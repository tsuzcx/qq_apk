package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.fhq;
import com.tencent.mm.protocal.protobuf.fhr;
import com.tencent.mm.protocal.protobuf.fhs;
import com.tencent.mm.protocal.protobuf.fht;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import java.util.HashSet;
import java.util.LinkedList;
import org.json.JSONObject;

public final class ac
  extends p
  implements m
{
  private static HashSet<Long> oTr;
  private com.tencent.mm.am.h callback;
  private final String hHa;
  private final com.tencent.mm.am.c rr;
  
  static
  {
    AppMethodBeat.i(150959);
    oTr = new HashSet();
    AppMethodBeat.o(150959);
  }
  
  public ac(String paramString, int paramInt1, int paramInt2, LinkedList<fht> paramLinkedList)
  {
    AppMethodBeat.i(150955);
    this.hHa = paramString;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fhr();
    ((c.a)localObject).otF = new fhs();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/statusnotify";
    ((c.a)localObject).funcId = 251;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (fhr)c.b.b(this.rr.otB);
    ((fhr)localObject).IMh = z.bAM();
    ((fhr)localObject).abIu = paramInt1;
    ((fhr)localObject).IMg = paramString;
    ((fhr)localObject).YHk = System.currentTimeMillis();
    if ((paramLinkedList != null) && (paramLinkedList.size() == paramInt2))
    {
      ((fhr)localObject).abIv = paramInt2;
      ((fhr)localObject).abIw.addAll(paramLinkedList);
    }
    Log.d("MicroMsg.NetSceneStatusNotify", "summerstatus toUserName = " + paramString + " unreadChatListCount = " + ((fhr)localObject).abIw.size());
    AppMethodBeat.o(150955);
  }
  
  private ac(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(150956);
    this.hHa = paramString1;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fhr();
    ((c.a)localObject).otF = new fhs();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/statusnotify";
    ((c.a)localObject).funcId = 251;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (fhr)c.b.b(this.rr.otB);
    ((fhr)localObject).IMh = z.bAM();
    ((fhr)localObject).abIu = paramInt;
    ((fhr)localObject).IMg = paramString1;
    ((fhr)localObject).YHk = System.currentTimeMillis();
    ((fhr)localObject).abIx = new fhq();
    ((fhr)localObject).abIx.IGU = paramString2;
    ((fhr)localObject).abIx.abIt = paramString3;
    AppMethodBeat.o(150956);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(150953);
    Log.i("MicroMsg.NetSceneStatusNotify", "enterSession %s %s %s %s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, paramString3 });
    if ((Util.isNullOrNil(paramString1)) || (ab.IV(paramString1)))
    {
      AppMethodBeat.o(150953);
      return;
    }
    if (!com.tencent.mm.kernel.h.baC().aZN())
    {
      AppMethodBeat.o(150953);
      return;
    }
    paramString1 = new ac(paramString1, paramInt, paramString2, paramString3);
    com.tencent.mm.kernel.h.baD().mCm.a(paramString1, 0);
    AppMethodBeat.o(150953);
  }
  
  public static void aY(String paramString, int paramInt)
  {
    AppMethodBeat.i(236695);
    cc localcc = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLG(paramString);
    if (localcc != null) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("messageSvrId", localcc.field_msgSvrId);
        localJSONObject.put("MsgCreateTime", localcc.getCreateTime());
        a(paramString, paramInt, "lastMessage", localJSONObject.toString());
        AppMethodBeat.o(236695);
        return;
      }
      catch (Exception paramString) {}
    }
    AppMethodBeat.o(236695);
  }
  
  public static void aZ(String paramString, int paramInt)
  {
    AppMethodBeat.i(150951);
    Log.i("MicroMsg.NetSceneStatusNotify", "enterSession %s %s", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150951);
      return;
    }
    if ((!com.tencent.mm.kernel.h.baC().aZN()) || ((ab.IV(paramString)) && (!au.bvT(paramString))))
    {
      AppMethodBeat.o(150951);
      return;
    }
    paramString = new ac(paramString, paramInt, 0, null);
    com.tencent.mm.kernel.h.baD().mCm.a(paramString, 0);
    AppMethodBeat.o(150951);
  }
  
  public static void am(cc paramcc)
  {
    AppMethodBeat.i(150952);
    com.tencent.mm.kernel.h.baF();
    if (!((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acPp, Boolean.TRUE)).booleanValue())
    {
      Log.i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]autoSyncState close");
      AppMethodBeat.o(150952);
      return;
    }
    if (oTr.contains(Long.valueOf(paramcc.field_msgId)))
    {
      Log.i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]sendSyncMultiTerminalCmd: has send cmd: msgSvrId:%d, msgLocalId:%d", new Object[] { Long.valueOf(paramcc.field_msgId), Long.valueOf(paramcc.field_msgId) });
      AppMethodBeat.o(150952);
      return;
    }
    oTr.add(Long.valueOf(paramcc.field_msgId));
    if (!com.tencent.mm.kernel.h.baC().aZN())
    {
      AppMethodBeat.o(150952);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<![CDATA[<downloadList>");
    localStringBuilder.append("<downloadItem>");
    localStringBuilder.append("<username>");
    localStringBuilder.append(paramcc.field_talker);
    localStringBuilder.append("</username>");
    localStringBuilder.append("<msgsvrid>");
    localStringBuilder.append(paramcc.field_msgSvrId);
    localStringBuilder.append("</msgsvrid>");
    localStringBuilder.append("</downloadItem>");
    localStringBuilder.append("</downloadList>]]>");
    String str = localStringBuilder.toString();
    Log.i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]sendSyncMultiTerminalCmd:msgID:%d,  %s", new Object[] { Long.valueOf(paramcc.field_msgId), localStringBuilder });
    paramcc = new ac(z.bAM(), 11, "DownloadFile", str);
    com.tencent.mm.kernel.h.baD().mCm.a(paramcc, 0);
    AppMethodBeat.o(150952);
  }
  
  public static void bN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(236718);
    Log.i("MicroMsg.NetSceneStatusNotify", "enterSessionFunction %s %s %s", new Object[] { Integer.valueOf(9), paramString1, paramString2 });
    paramString1 = new ac(z.bAM(), 9, paramString1, paramString2);
    com.tencent.mm.kernel.h.baD().mCm.a(paramString1, 0);
    AppMethodBeat.o(236718);
  }
  
  public static boolean bO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(236726);
    if (!com.tencent.mm.kernel.h.baC().aZN())
    {
      Log.e("MicroMsg.NetSceneStatusNotify", "sendHandOffSyncCmd fail due to account has not initialized");
      AppMethodBeat.o(236726);
      return false;
    }
    if (!Util.isNullOrNil(paramString1))
    {
      paramString1 = new ac(z.bAM(), 11, paramString2, paramString1);
      com.tencent.mm.kernel.h.baD().mCm.a(paramString1, 0);
      AppMethodBeat.o(236726);
      return true;
    }
    AppMethodBeat.o(236726);
    return false;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(150957);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(150957);
    return i;
  }
  
  public final int getType()
  {
    return 251;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150958);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.d("MicroMsg.NetSceneStatusNotify", "StatusNotify Error. userName=" + this.hHa + ", errType=" + paramInt2 + ", errCode=" + paramInt3 + ",errMsg=" + paramString);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ac
 * JD-Core Version:    0.7.0.1
 */