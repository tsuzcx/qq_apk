package com.tencent.mm.bi;

import android.database.Cursor;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.d;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.g.a.le;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.an;
import com.tencent.mm.model.at;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bi.d;
import com.tencent.mm.storage.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class d
  implements at
{
  public static int ePU = 0;
  public static int[] fUT = new int[1000];
  private final long TIME_INTERVAL;
  private final int bZG;
  private e fUQ;
  private b fUR;
  private final int fUS;
  private com.tencent.mm.sdk.b.c fUU;
  
  public d()
  {
    AppMethodBeat.i(16622);
    this.fUQ = new e();
    this.fUR = new b();
    this.TIME_INTERVAL = 259200000L;
    this.bZG = 0;
    this.fUS = 2;
    this.fUU = new d.1(this);
    AppMethodBeat.o(16622);
  }
  
  public static void a(cm paramcm, bi.d paramd)
  {
    AppMethodBeat.i(16629);
    ab.d("MicroMsg.SubCoreVerify", "saveToLbsVerifyStg, cmdAM, status = " + paramcm.jJS + ", id = " + paramcm.pIG);
    bf localbf = new bf();
    localbf.field_content = aa.a(paramcm.woR);
    localbf.field_createtime = bo.aox();
    localbf.field_imgpath = "";
    localbf.field_sayhicontent = paramd.content;
    localbf.field_sayhiuser = paramd.tac;
    localbf.field_scene = paramd.scene;
    if (paramcm.jJS > 3) {}
    for (int i = paramcm.jJS;; i = 3)
    {
      localbf.field_status = i;
      localbf.field_svrid = paramcm.pIG;
      localbf.field_talker = aa.a(paramcm.woP);
      localbf.field_type = paramcm.nqW;
      localbf.field_isSend = 0;
      localbf.field_sayhiencryptuser = paramd.yOx;
      localbf.field_ticket = paramd.mVw;
      localbf.field_flag = 1;
      ((bg)((j)g.E(j.class)).bPN()).a(localbf);
      com.tencent.mm.ah.b.U(localbf.field_sayhiencryptuser, 3);
      AppMethodBeat.o(16629);
      return;
    }
  }
  
  public static ay alh()
  {
    AppMethodBeat.i(16623);
    g.RJ().QQ();
    com.tencent.mm.storage.aw localaw = ali();
    ay localay = (ay)((j)g.E(j.class)).bPP();
    localay.add(localaw, g.RO().oNc.getLooper());
    AppMethodBeat.o(16623);
    return localay;
  }
  
  public static com.tencent.mm.storage.aw ali()
  {
    AppMethodBeat.i(16624);
    g.RJ().QQ();
    com.tencent.mm.storage.aw localaw = (com.tencent.mm.storage.aw)((j)g.E(j.class)).bPO();
    AppMethodBeat.o(16624);
    return localaw;
  }
  
  public static bg alj()
  {
    AppMethodBeat.i(16625);
    g.RJ().QQ();
    bg localbg = (bg)((j)g.E(j.class)).bPN();
    AppMethodBeat.o(16625);
    return localbg;
  }
  
  public static bu alk()
  {
    AppMethodBeat.i(16626);
    g.RJ().QQ();
    bu localbu = (bu)((j)g.E(j.class)).bPM();
    AppMethodBeat.o(16626);
    return localbu;
  }
  
  public static void b(cm paramcm, bi.d paramd)
  {
    AppMethodBeat.i(16630);
    ab.d("MicroMsg.SubCoreVerify", "saveToShakeVerifyStg, cmdAM, status = " + paramcm.jJS + ", id = " + paramcm.pIG);
    bt localbt = new bt();
    localbt.field_content = aa.a(paramcm.woR);
    localbt.field_createtime = bo.aox();
    localbt.field_imgpath = "";
    localbt.field_sayhicontent = paramd.content;
    localbt.field_sayhiuser = paramd.tac;
    localbt.field_scene = paramd.scene;
    if (paramcm.jJS > 3) {}
    for (int i = paramcm.jJS;; i = 3)
    {
      localbt.field_status = i;
      localbt.field_svrid = paramcm.pIG;
      localbt.field_talker = aa.a(paramcm.woP);
      localbt.field_type = paramcm.nqW;
      localbt.field_isSend = 0;
      ((bu)((j)g.E(j.class)).bPM()).a(localbt);
      com.tencent.mm.ah.b.U(localbt.field_sayhiuser, 3);
      AppMethodBeat.o(16630);
      return;
    }
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(16628);
    e.d.a(Integer.valueOf(37), this.fUQ);
    e.d.a(Integer.valueOf(65), this.fUQ);
    e.d.a(Integer.valueOf(40), this.fUR);
    com.tencent.mm.sdk.b.a.ymk.c(this.fUU);
    int j = ali().dxy();
    long l = System.currentTimeMillis();
    com.tencent.mm.model.aw.aaz();
    l -= bo.a((Long)com.tencent.mm.model.c.Ru().get(340225, null), 0L);
    ab.i("MicroMsg.SubCoreVerify", "timeInterval = ".concat(String.valueOf(l)));
    if ((l > 259200000L) && (j > 0))
    {
      Object localObject1 = ali();
      Object localObject2 = String.format("select %s from %s where isNew = 1 ORDER BY lastModifiedTime DESC limit %d", new Object[] { "contentNickname", "fmessage_conversation", Integer.valueOf(2) });
      localObject1 = ((com.tencent.mm.storage.aw)localObject1).db.a((String)localObject2, null, 2);
      localObject2 = new ArrayList();
      while (((Cursor)localObject1).moveToNext()) {
        ((List)localObject2).add(((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("contentNickname")));
      }
      ((Cursor)localObject1).close();
      j = ((List)localObject2).size();
      if (j > 0)
      {
        localObject1 = (String)((List)localObject2).get(0);
        while (i < j)
        {
          localObject1 = (String)localObject1 + ", " + (String)((List)localObject2).get(i);
          i += 1;
        }
        ab.i("MicroMsg.SubCoreVerify", "title = ".concat(String.valueOf(localObject1)));
        localObject2 = new le();
        ((le)localObject2).cBo.userName = null;
        ((le)localObject2).cBo.blZ = ((String)localObject1);
        ((le)localObject2).cBo.type = 0;
        com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject2);
        com.tencent.mm.model.aw.aaz();
        com.tencent.mm.model.c.Ru().set(340225, Long.valueOf(System.currentTimeMillis()));
      }
    }
    AppMethodBeat.o(16628);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(16627);
    e.d.b(Integer.valueOf(37), this.fUQ);
    e.d.b(Integer.valueOf(65), this.fUQ);
    e.d.b(Integer.valueOf(40), this.fUR);
    com.tencent.mm.sdk.b.a.ymk.d(this.fUU);
    com.tencent.mm.model.aw.getNotification().IG();
    AppMethodBeat.o(16627);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.bi.d
 * JD-Core Version:    0.7.0.1
 */