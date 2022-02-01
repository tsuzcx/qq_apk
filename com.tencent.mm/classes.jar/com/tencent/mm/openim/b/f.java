package com.tencent.mm.openim.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.openim.a.a;
import com.tencent.mm.openim.room.a.a.1;
import com.tencent.mm.openim.room.a.a.2;
import com.tencent.mm.openim.room.a.b.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.brk;
import com.tencent.mm.protocal.protobuf.brl;
import com.tencent.mm.protocal.protobuf.cvs;
import com.tencent.mm.protocal.protobuf.cvv;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class f
  extends q
  implements m
{
  private com.tencent.mm.ak.i callback;
  private final String dOe;
  private final d rr;
  private final int version;
  
  public f(String paramString, int paramInt)
  {
    AppMethodBeat.i(151193);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new brk();
    ((d.a)localObject).iLO = new brl();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getopenimchatroommemberdetail";
    ((d.a)localObject).funcId = 942;
    this.rr = ((d.a)localObject).aXF();
    this.dOe = paramString;
    this.version = paramInt;
    localObject = (brk)this.rr.iLK.iLR;
    ((brk)localObject).jHa = paramString;
    ((brk)localObject).LYO = paramInt;
    Log.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "get roomname:%s, version=%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(151193);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(151195);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(151195);
    return i;
  }
  
  public final int getType()
  {
    return 942;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151194);
    Log.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname:%s, %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.dOe, Integer.valueOf(this.version) });
    if (paramInt3 == 0)
    {
      paramArrayOfByte = (brl)((d)params).iLL.iLR;
      Object localObject = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Ke(this.dOe);
      long l = paramArrayOfByte.LYP;
      Log.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "updateMemberDetail svrVer:%d, localVer:%d", new Object[] { Integer.valueOf(paramArrayOfByte.LYP), Integer.valueOf(this.version) });
      if (this.version < (0xFFFFFFFF & l))
      {
        ((ah)localObject).akd(paramArrayOfByte.LYP);
        label182:
        com.tencent.mm.openim.room.a.c localc;
        bv localbv;
        j localj;
        LinkedList localLinkedList1;
        LinkedList localLinkedList2;
        label307:
        Iterator localIterator;
        if (paramArrayOfByte.LYQ == null)
        {
          params = null;
          if (params != null) {
            break label545;
          }
          paramInt1 = -1;
          Log.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "updateMemberDetail memInfoList size[%d]", new Object[] { Integer.valueOf(paramInt1) });
          ((ah)localObject).I(z.aTY(), b.c.aN(params));
          ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().replace((IAutoDBItem)localObject);
          localObject = paramArrayOfByte.LYQ;
          localc = new com.tencent.mm.openim.room.a.c();
          if (localObject == null) {
            break label901;
          }
          params = ((cvs)localObject).KHx;
          localbv = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN();
          localj = p.aYB();
          localLinkedList1 = new LinkedList();
          localLinkedList2 = new LinkedList();
          if (params != null) {
            break label556;
          }
          paramInt1 = -1;
          Log.i("OpenIMChatRoomContactLogic", "updateMemberDetail memInfoList size[%d]", new Object[] { Integer.valueOf(paramInt1) });
          if (paramInt1 < 0) {
            break label901;
          }
          if (paramInt1 <= WXHardCoderJNI.hcUpdateChatroomMemberCount) {
            break label567;
          }
          paramInt1 = 0;
          localc.gsi = paramInt1;
          localIterator = params.iterator();
        }
        for (;;)
        {
          label355:
          if (!localIterator.hasNext()) {
            break label773;
          }
          cvv localcvv = (cvv)localIterator.next();
          if ((((cvs)localObject).MBn == 0) && (!Util.isNullOrNil(localcvv.userName)) && (!Util.isNullOrNil(localcvv.LpI)))
          {
            paramArrayOfByte = localj.Mx(localcvv.userName);
            params = paramArrayOfByte;
            if (paramArrayOfByte == null)
            {
              params = new com.tencent.mm.aj.i();
              params.username = localcvv.userName;
            }
            params.iKX = localcvv.LpH;
            params.iKW = localcvv.LpI;
            params.fuz = 3;
            if (Util.isNullOrNil(localcvv.LpH)) {
              break label633;
            }
          }
          label545:
          label556:
          label567:
          label633:
          for (boolean bool = true;; bool = false)
          {
            params.fv(bool);
            localLinkedList2.add(params);
            params = localbv.Kn(localcvv.userName);
            if (params != null) {
              break label639;
            }
            Log.e("OpenIMChatRoomContactLogic", "updateMemberDetail memberlist username is null");
            break label355;
            params = paramArrayOfByte.LYQ.KHx;
            break;
            paramInt1 = params.size();
            break label182;
            paramInt1 = params.size();
            break label307;
            bool = WXHardCoderJNI.hcUpdateChatroomEnable;
            int i = WXHardCoderJNI.hcUpdateChatroomDelay;
            int j = WXHardCoderJNI.hcUpdateChatroomCPU;
            int k = WXHardCoderJNI.hcUpdateChatroomIO;
            if (WXHardCoderJNI.hcUpdateChatroomThr) {}
            for (paramInt1 = com.tencent.mm.kernel.g.aAk().getProcessTid();; paramInt1 = 0)
            {
              paramInt1 = WXHardCoderJNI.startPerformance(bool, i, j, k, paramInt1, WXHardCoderJNI.hcUpdateChatroomTimeout, 401, WXHardCoderJNI.hcUpdateChatroomAction, "PerfTrace");
              break;
            }
          }
          label639:
          if (params.arx())
          {
            params.setNickname(localcvv.nickName);
            localLinkedList1.add(new Pair(localcvv.userName, params));
          }
          if (!Util.isNullOrNil(localcvv.appId)) {
            params.BN(localcvv.appId);
          }
          if (!Util.isNullOrNil(localcvv.MBp)) {
            params.BM(localcvv.MBp);
          }
          localbv.ao(params);
          if (!Util.isNullOrNil(localcvv.appId)) {
            ((a)com.tencent.mm.kernel.g.af(a.class)).s(localcvv.appId, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()), localcvv.MBp);
          }
        }
        label773:
        Log.d("OpenIMChatRoomContactLogic", "updateMemberDetail update newImgFlagList size:%d, updateList size:%d", new Object[] { Integer.valueOf(localLinkedList2.size()), Integer.valueOf(localLinkedList1.size()) });
        if (!localLinkedList2.isEmpty())
        {
          localc.uD(1);
          new MTimerHandler(com.tencent.mm.kernel.g.aAk().getLooper(), new a.1(localLinkedList2, localc, localj), true).startTimer(100L);
        }
        if (!localLinkedList1.isEmpty())
        {
          localc.uD(2);
          new MTimerHandler(com.tencent.mm.kernel.g.aAk().getLooper(), new a.2(localLinkedList1, localc, localbv), true).startTimer(100L);
        }
      }
    }
    label901:
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(151194);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.b.f
 * JD-Core Version:    0.7.0.1
 */