package com.tencent.mm.openim.model;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.k;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.openim.api.e;
import com.tencent.mm.openim.room.a.a.1;
import com.tencent.mm.openim.room.a.a.2;
import com.tencent.mm.openim.room.a.b.c;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.col;
import com.tencent.mm.protocal.protobuf.com;
import com.tencent.mm.protocal.protobuf.dxe;
import com.tencent.mm.protocal.protobuf.dxh;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private final String hMM;
  private final com.tencent.mm.am.c rr;
  private final int version;
  
  public h(String paramString, int paramInt)
  {
    AppMethodBeat.i(151193);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new col();
    ((c.a)localObject).otF = new com();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/getopenimchatroommemberdetail";
    ((c.a)localObject).funcId = 942;
    this.rr = ((c.a)localObject).bEF();
    this.hMM = paramString;
    this.version = paramInt;
    localObject = (col)c.b.b(this.rr.otB);
    ((col)localObject).pss = paramString;
    ((col)localObject).aavB = paramInt;
    Log.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "get roomname:%s, version=%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(151193);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(151195);
    this.callback = paramh;
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
    Log.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname:%s, %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.hMM, Integer.valueOf(this.version) });
    if (paramInt3 == 0)
    {
      paramArrayOfByte = (com)c.c.b(((com.tencent.mm.am.c)params).otC);
      Object localObject = ((b)com.tencent.mm.kernel.h.ax(b.class)).bzK().Jv(this.hMM);
      long l = paramArrayOfByte.aavC;
      Log.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "updateMemberDetail svrVer:%d, localVer:%d", new Object[] { Integer.valueOf(paramArrayOfByte.aavC), Integer.valueOf(this.version) });
      if (this.version < (0xFFFFFFFF & l))
      {
        ((aj)localObject).ayP(paramArrayOfByte.aavC);
        if (aj.iZk())
        {
          Log.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "updateMemberDetail has get all inviteer info");
          ((aj)localObject).field_chatroomLocalVersion = 1L;
        }
        label198:
        com.tencent.mm.openim.room.a.c localc;
        bx localbx;
        k localk;
        LinkedList localLinkedList1;
        LinkedList localLinkedList2;
        label323:
        Iterator localIterator;
        if (paramArrayOfByte.aavD == null)
        {
          params = null;
          if (params != null) {
            break label561;
          }
          paramInt1 = -1;
          Log.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "updateMemberDetail memInfoList size[%d]", new Object[] { Integer.valueOf(paramInt1) });
          ((aj)localObject).P(z.bAM(), b.c.cq(params));
          ((b)com.tencent.mm.kernel.h.ax(b.class)).bzK().replace((IAutoDBItem)localObject);
          localObject = paramArrayOfByte.aavD;
          localc = new com.tencent.mm.openim.room.a.c();
          if (localObject == null) {
            break label917;
          }
          params = ((dxe)localObject).YFR;
          localbx = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA();
          localk = q.bFE();
          localLinkedList1 = new LinkedList();
          localLinkedList2 = new LinkedList();
          if (params != null) {
            break label572;
          }
          paramInt1 = -1;
          Log.i("OpenIMChatRoomContactLogic", "updateMemberDetail memInfoList size[%d]", new Object[] { Integer.valueOf(paramInt1) });
          if (paramInt1 < 0) {
            break label917;
          }
          if (paramInt1 <= WXHardCoderJNI.hcUpdateChatroomMemberCount) {
            break label583;
          }
          paramInt1 = 0;
          localc.lyw = paramInt1;
          localIterator = params.iterator();
        }
        for (;;)
        {
          label371:
          if (!localIterator.hasNext()) {
            break label789;
          }
          dxh localdxh = (dxh)localIterator.next();
          if ((((dxe)localObject).abdl == 0) && (!Util.isNullOrNil(localdxh.userName)) && (!Util.isNullOrNil(localdxh.Zqg)))
          {
            paramArrayOfByte = localk.LS(localdxh.userName);
            params = paramArrayOfByte;
            if (paramArrayOfByte == null)
            {
              params = new j();
              params.username = localdxh.userName;
            }
            params.osN = localdxh.Zqf;
            params.osM = localdxh.Zqg;
            params.jZY = 3;
            if (Util.isNullOrNil(localdxh.Zqf)) {
              break label649;
            }
          }
          label649:
          for (boolean bool = true;; bool = false)
          {
            params.gX(bool);
            localLinkedList2.add(params);
            params = localbx.JE(localdxh.userName);
            if (params != null) {
              break label655;
            }
            Log.e("OpenIMChatRoomContactLogic", "updateMemberDetail memberlist username is null");
            break label371;
            params = paramArrayOfByte.aavD.YFR;
            break;
            label561:
            paramInt1 = params.size();
            break label198;
            label572:
            paramInt1 = params.size();
            break label323;
            label583:
            bool = WXHardCoderJNI.hcUpdateChatroomEnable;
            int i = WXHardCoderJNI.hcUpdateChatroomDelay;
            int j = WXHardCoderJNI.hcUpdateChatroomCPU;
            int k = WXHardCoderJNI.hcUpdateChatroomIO;
            if (WXHardCoderJNI.hcUpdateChatroomThr) {}
            for (paramInt1 = com.tencent.mm.kernel.h.baH().getProcessTid();; paramInt1 = 0)
            {
              paramInt1 = WXHardCoderJNI.startPerformance(bool, i, j, k, paramInt1, WXHardCoderJNI.hcUpdateChatroomTimeout, 401, WXHardCoderJNI.hcUpdateChatroomAction, "PerfTrace");
              break;
            }
          }
          label655:
          if (params.aSE())
          {
            params.setNickname(localdxh.nickName);
            localLinkedList1.add(new Pair(localdxh.userName, params));
          }
          if (!Util.isNullOrNil(localdxh.appId)) {
            params.Bg(localdxh.appId);
          }
          if (!Util.isNullOrNil(localdxh.abdn)) {
            params.Bf(localdxh.abdn);
          }
          localbx.aA(params);
          if (!Util.isNullOrNil(localdxh.appId)) {
            ((e)com.tencent.mm.kernel.h.ax(e.class)).y(localdxh.appId, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()), localdxh.abdn);
          }
        }
        label789:
        Log.d("OpenIMChatRoomContactLogic", "updateMemberDetail update newImgFlagList size:%d, updateList size:%d", new Object[] { Integer.valueOf(localLinkedList2.size()), Integer.valueOf(localLinkedList1.size()) });
        if (!localLinkedList2.isEmpty())
        {
          localc.xJ(1);
          new MTimerHandler(com.tencent.mm.kernel.h.baH().getLooper(), new a.1(localLinkedList2, localc, localk), true).startTimer(100L);
        }
        if (!localLinkedList1.isEmpty())
        {
          localc.xJ(2);
          new MTimerHandler(com.tencent.mm.kernel.h.baH().getLooper(), new a.2(localLinkedList1, localc, localbx), true).startTimer(100L);
        }
      }
    }
    label917:
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(151194);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.model.h
 * JD-Core Version:    0.7.0.1
 */