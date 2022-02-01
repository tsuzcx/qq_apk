package com.tencent.mm.bk;

import android.database.Cursor;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.d;
import com.tencent.mm.g.a.gk;
import com.tencent.mm.g.a.ne;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.ba;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.bu.d;
import com.tencent.mm.storage.cd;
import com.tencent.mm.storage.ce;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class d
  implements ax
{
  public static int hgh = 0;
  public static int[] irA = new int[1000];
  private final int cVR;
  private com.tencent.mm.sdk.b.c irB;
  private e irw;
  private b irx;
  private final long iry;
  private final int irz;
  
  public d()
  {
    AppMethodBeat.i(20665);
    this.irw = new e();
    this.irx = new b();
    this.iry = 259200000L;
    this.cVR = 0;
    this.irz = 2;
    this.irB = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(20665);
  }
  
  public static void a(cv paramcv, bu.d paramd)
  {
    AppMethodBeat.i(20672);
    ad.d("MicroMsg.SubCoreVerify", "saveToLbsVerifyStg, cmdAM, status = " + paramcv.nDG + ", id = " + paramcv.xbt);
    br localbr = new br();
    localbr.field_content = z.a(paramcv.Fvk);
    localbr.field_createtime = bt.aQJ();
    localbr.field_imgpath = "";
    localbr.field_sayhicontent = paramd.content;
    localbr.field_sayhiuser = paramd.dHm;
    localbr.field_scene = paramd.scene;
    if (paramcv.nDG > 3) {}
    for (int i = paramcv.nDG;; i = 3)
    {
      localbr.field_status = i;
      localbr.field_svrid = paramcv.xbt;
      localbr.field_talker = z.a(paramcv.Fvi);
      localbr.field_type = paramcv.ugm;
      localbr.field_isSend = 0;
      localbr.field_sayhiencryptuser = paramd.IMB;
      localbr.field_ticket = paramd.txJ;
      localbr.field_flag = 1;
      ((bs)((l)g.ab(l.class)).dlH()).a(localbr);
      com.tencent.mm.ak.c.ak(localbr.field_sayhiencryptuser, 3);
      AppMethodBeat.o(20672);
      return;
    }
  }
  
  public static bi aMn()
  {
    AppMethodBeat.i(20666);
    g.ajA().aiF();
    bg localbg = aMo();
    bi localbi = (bi)((l)g.ab(l.class)).dlJ();
    localbi.add(localbg, g.ajF().IdO.getLooper());
    AppMethodBeat.o(20666);
    return localbi;
  }
  
  public static bg aMo()
  {
    AppMethodBeat.i(20667);
    g.ajA().aiF();
    bg localbg = (bg)((l)g.ab(l.class)).dlI();
    AppMethodBeat.o(20667);
    return localbg;
  }
  
  public static bs aMp()
  {
    AppMethodBeat.i(20668);
    g.ajA().aiF();
    bs localbs = (bs)((l)g.ab(l.class)).dlH();
    AppMethodBeat.o(20668);
    return localbs;
  }
  
  public static ce aMq()
  {
    AppMethodBeat.i(20669);
    g.ajA().aiF();
    ce localce = (ce)((l)g.ab(l.class)).dlG();
    AppMethodBeat.o(20669);
    return localce;
  }
  
  public static void b(cv paramcv, bu.d paramd)
  {
    AppMethodBeat.i(20673);
    ad.d("MicroMsg.SubCoreVerify", "saveToShakeVerifyStg, cmdAM, status = " + paramcv.nDG + ", id = " + paramcv.xbt);
    cd localcd = new cd();
    localcd.field_content = z.a(paramcv.Fvk);
    localcd.field_createtime = bt.aQJ();
    localcd.field_imgpath = "";
    localcd.field_sayhicontent = paramd.content;
    localcd.field_sayhiuser = paramd.dHm;
    localcd.field_scene = paramd.scene;
    if (paramcv.nDG > 3) {}
    for (int i = paramcv.nDG;; i = 3)
    {
      localcd.field_status = i;
      localcd.field_svrid = paramcv.xbt;
      localcd.field_talker = z.a(paramcv.Fvi);
      localcd.field_type = paramcv.ugm;
      localcd.field_isSend = 0;
      ((ce)((l)g.ab(l.class)).dlG()).a(localcd);
      com.tencent.mm.ak.c.ak(localcd.field_sayhiuser, 3);
      AppMethodBeat.o(20673);
      return;
    }
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(20671);
    e.d.a(Integer.valueOf(37), this.irw);
    e.d.a(Integer.valueOf(65), this.irw);
    e.d.a(Integer.valueOf(40), this.irx);
    com.tencent.mm.sdk.b.a.IbL.c(this.irB);
    int j = aMo().frk();
    long l = System.currentTimeMillis();
    ba.aBQ();
    l -= bt.a((Long)com.tencent.mm.model.c.ajl().get(340225, null), 0L);
    ad.i("MicroMsg.SubCoreVerify", "timeInterval = ".concat(String.valueOf(l)));
    if ((l > 259200000L) && (j > 0))
    {
      Object localObject1 = aMo();
      Object localObject2 = String.format("select %s from %s where isNew = 1 ORDER BY lastModifiedTime DESC limit %d", new Object[] { "contentNickname", "fmessage_conversation", Integer.valueOf(2) });
      localObject1 = ((bg)localObject1).db.a((String)localObject2, null, 2);
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
        ad.i("MicroMsg.SubCoreVerify", "title = ".concat(String.valueOf(localObject1)));
        localObject2 = new ne();
        ((ne)localObject2).dBe.userName = null;
        ((ne)localObject2).dBe.bVF = ((String)localObject1);
        ((ne)localObject2).dBe.type = 0;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
        ba.aBQ();
        com.tencent.mm.model.c.ajl().set(340225, Long.valueOf(System.currentTimeMillis()));
      }
    }
    AppMethodBeat.o(20671);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(20670);
    e.d.b(Integer.valueOf(37), this.irw);
    e.d.b(Integer.valueOf(65), this.irw);
    e.d.b(Integer.valueOf(40), this.irx);
    com.tencent.mm.sdk.b.a.IbL.d(this.irB);
    ba.getNotification().Xg();
    AppMethodBeat.o(20670);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bk.d
 * JD-Core Version:    0.7.0.1
 */