package com.tencent.mm.openim.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.j;
import com.tencent.mm.am.k;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.openim.a.a;
import com.tencent.mm.openim.room.a.a.1;
import com.tencent.mm.openim.room.a.a.2;
import com.tencent.mm.openim.room.a.b.c;
import com.tencent.mm.openim.room.a.c;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.bzg;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.dfc;
import com.tencent.mm.protocal.protobuf.dff;
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
  extends com.tencent.mm.an.q
  implements m
{
  private i callback;
  private final String fHp;
  private final d rr;
  private final int version;
  
  public f(String paramString, int paramInt)
  {
    AppMethodBeat.i(151193);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new bzg();
    ((d.a)localObject).lBV = new bzh();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getopenimchatroommemberdetail";
    ((d.a)localObject).funcId = 942;
    this.rr = ((d.a)localObject).bgN();
    this.fHp = paramString;
    this.version = paramInt;
    localObject = (bzg)d.b.b(this.rr.lBR);
    ((bzg)localObject).mye = paramString;
    ((bzg)localObject).Tii = paramInt;
    Log.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "get roomname:%s, version=%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(151193);
  }
  
  public final int doScene(g paramg, i parami)
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
    Log.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname:%s, %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.fHp, Integer.valueOf(this.version) });
    if (paramInt3 == 0)
    {
      paramArrayOfByte = (bzh)d.c.b(((d)params).lBS);
      Object localObject = ((b)h.ae(b.class)).bbV().Rx(this.fHp);
      long l = paramArrayOfByte.Tij;
      Log.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "updateMemberDetail svrVer:%d, localVer:%d", new Object[] { Integer.valueOf(paramArrayOfByte.Tij), Integer.valueOf(this.version) });
      if (this.version < (0xFFFFFFFF & l))
      {
        ((ah)localObject).asA(paramArrayOfByte.Tij);
        label182:
        c localc;
        bv localbv;
        k localk;
        LinkedList localLinkedList1;
        LinkedList localLinkedList2;
        label307:
        Iterator localIterator;
        if (paramArrayOfByte.Tik == null)
        {
          params = null;
          if (params != null) {
            break label545;
          }
          paramInt1 = -1;
          Log.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "updateMemberDetail memInfoList size[%d]", new Object[] { Integer.valueOf(paramInt1) });
          ((ah)localObject).H(z.bcZ(), b.c.aL(params));
          ((b)h.ae(b.class)).bbV().replace((IAutoDBItem)localObject);
          localObject = paramArrayOfByte.Tik;
          localc = new c();
          if (localObject == null) {
            break label901;
          }
          params = ((dfc)localObject).RIQ;
          localbv = ((n)h.ae(n.class)).bbL();
          localk = com.tencent.mm.am.q.bhP();
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
          localc.iWt = paramInt1;
          localIterator = params.iterator();
        }
        for (;;)
        {
          label355:
          if (!localIterator.hasNext()) {
            break label773;
          }
          dff localdff = (dff)localIterator.next();
          if ((((dfc)localObject).TMU == 0) && (!Util.isNullOrNil(localdff.userName)) && (!Util.isNullOrNil(localdff.Sre)))
          {
            paramArrayOfByte = localk.TS(localdff.userName);
            params = paramArrayOfByte;
            if (paramArrayOfByte == null)
            {
              params = new j();
              params.username = localdff.userName;
            }
            params.lBe = localdff.Srd;
            params.lBd = localdff.Sre;
            params.hDc = 3;
            if (Util.isNullOrNil(localdff.Srd)) {
              break label633;
            }
          }
          label545:
          label556:
          label567:
          label633:
          for (boolean bool = true;; bool = false)
          {
            params.gg(bool);
            localLinkedList2.add(params);
            params = localbv.RG(localdff.userName);
            if (params != null) {
              break label639;
            }
            Log.e("OpenIMChatRoomContactLogic", "updateMemberDetail memberlist username is null");
            break label355;
            params = paramArrayOfByte.Tik.RIQ;
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
            for (paramInt1 = h.aHJ().getProcessTid();; paramInt1 = 0)
            {
              paramInt1 = WXHardCoderJNI.startPerformance(bool, i, j, k, paramInt1, WXHardCoderJNI.hcUpdateChatroomTimeout, 401, WXHardCoderJNI.hcUpdateChatroomAction, "PerfTrace");
              break;
            }
          }
          label639:
          if (params.ayb())
          {
            params.setNickname(localdff.nickName);
            localLinkedList1.add(new Pair(localdff.userName, params));
          }
          if (!Util.isNullOrNil(localdff.appId)) {
            params.IB(localdff.appId);
          }
          if (!Util.isNullOrNil(localdff.TMW)) {
            params.IA(localdff.TMW);
          }
          localbv.au(params);
          if (!Util.isNullOrNil(localdff.appId)) {
            ((a)h.ae(a.class)).v(localdff.appId, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()), localdff.TMW);
          }
        }
        label773:
        Log.d("OpenIMChatRoomContactLogic", "updateMemberDetail update newImgFlagList size:%d, updateList size:%d", new Object[] { Integer.valueOf(localLinkedList2.size()), Integer.valueOf(localLinkedList1.size()) });
        if (!localLinkedList2.isEmpty())
        {
          localc.xF(1);
          new MTimerHandler(h.aHJ().getLooper(), new a.1(localLinkedList2, localc, localk), true).startTimer(100L);
        }
        if (!localLinkedList1.isEmpty())
        {
          localc.xF(2);
          new MTimerHandler(h.aHJ().getLooper(), new a.2(localLinkedList1, localc, localbv), true).startTimer(100L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.f
 * JD-Core Version:    0.7.0.1
 */