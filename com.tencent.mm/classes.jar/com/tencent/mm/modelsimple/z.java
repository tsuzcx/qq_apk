package com.tencent.mm.modelsimple;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.c.bvq;
import com.tencent.mm.protocal.c.bvr;
import com.tencent.mm.protocal.c.bvs;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bi;
import java.util.HashSet;

public final class z
  extends m
  implements k
{
  private static HashSet<Long> eAn = new HashSet();
  private final com.tencent.mm.ah.b dmK;
  private f dmL;
  private final String toUserName;
  
  public z(String paramString, int paramInt)
  {
    this.toUserName = paramString;
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bvr();
    ((b.a)localObject).ecI = new bvs();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/statusnotify";
    ((b.a)localObject).ecG = 251;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bvr)this.dmK.ecE.ecN;
    ((bvr)localObject).kWn = com.tencent.mm.model.q.Gj();
    ((bvr)localObject).tMt = paramInt;
    ((bvr)localObject).kWm = paramString;
    ((bvr)localObject).swQ = System.currentTimeMillis();
    y.d("MicroMsg.NetSceneStatusNotify", "toUserName = " + paramString);
  }
  
  private z(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.toUserName = paramString1;
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bvr();
    ((b.a)localObject).ecI = new bvs();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/statusnotify";
    ((b.a)localObject).ecG = 251;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bvr)this.dmK.ecE.ecN;
    ((bvr)localObject).kWn = com.tencent.mm.model.q.Gj();
    ((bvr)localObject).tMt = paramInt;
    ((bvr)localObject).kWm = paramString1;
    ((bvr)localObject).swQ = System.currentTimeMillis();
    ((bvr)localObject).tMw = new bvq();
    ((bvr)localObject).tMw.kRZ = paramString2;
    ((bvr)localObject).tMw.tMs = paramString3;
  }
  
  public static void T(String paramString, int paramInt)
  {
    if (bk.bl(paramString)) {}
    while ((!g.DN().Dc()) || ((s.hU(paramString)) && (!s.hp(paramString)))) {
      return;
    }
    paramString = new z(paramString, paramInt);
    g.DO().dJT.a(paramString, 0);
  }
  
  public static void b(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if ((bk.bl(paramString1)) || (s.hU(paramString1))) {}
    while (!g.DN().Dc()) {
      return;
    }
    paramString1 = new z(paramString1, paramInt, paramString2, paramString3);
    g.DO().dJT.a(paramString1, 0);
  }
  
  public static void w(bi parambi)
  {
    g.DQ();
    if (!((Boolean)g.DP().Dz().get(ac.a.uuD, Boolean.valueOf(true))).booleanValue()) {
      y.i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]autoSyncState close");
    }
    do
    {
      return;
      if (eAn.contains(Long.valueOf(parambi.field_msgId)))
      {
        y.i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]sendSyncMultiTerminalCmd: has send cmd: msgSvrId:%d, msgLocalId:%d", new Object[] { Long.valueOf(parambi.field_msgId), Long.valueOf(parambi.field_msgId) });
        return;
      }
      eAn.add(Long.valueOf(parambi.field_msgId));
    } while (!g.DN().Dc());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<![CDATA[<downloadList>");
    localStringBuilder.append("<downloadItem>");
    localStringBuilder.append("<username>");
    localStringBuilder.append(parambi.field_talker);
    localStringBuilder.append("</username>");
    localStringBuilder.append("<msgsvrid>");
    localStringBuilder.append(parambi.field_msgSvrId);
    localStringBuilder.append("</msgsvrid>");
    localStringBuilder.append("</downloadItem>");
    localStringBuilder.append("</downloadList>]]>");
    String str = localStringBuilder.toString();
    y.i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]sendSyncMultiTerminalCmd:msgID:%d,  %s", new Object[] { Long.valueOf(parambi.field_msgId), localStringBuilder });
    parambi = new z(com.tencent.mm.model.q.Gj(), 11, "DownloadFile", str);
    g.DO().dJT.a(parambi, 0);
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      y.d("MicroMsg.NetSceneStatusNotify", "StatusNotify Error. userName=" + this.toUserName);
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 251;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelsimple.z
 * JD-Core Version:    0.7.0.1
 */