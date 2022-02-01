package com.tencent.mm.bj;

import android.database.Cursor;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.d;
import com.tencent.mm.g.a.gl;
import com.tencent.mm.g.a.nf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bc;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.bt;
import com.tencent.mm.storage.bv.d;
import com.tencent.mm.storage.ce;
import com.tencent.mm.storage.cf;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class d
  implements az
{
  public static int hiV = 0;
  public static int[] iuu = new int[1000];
  private final int cWO;
  private e iuq;
  private b iur;
  private final long ius;
  private final int iut;
  private com.tencent.mm.sdk.b.c iuv;
  
  public d()
  {
    AppMethodBeat.i(20665);
    this.iuq = new e();
    this.iur = new b();
    this.ius = 259200000L;
    this.cWO = 0;
    this.iut = 2;
    this.iuv = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(20665);
  }
  
  public static void a(cv paramcv, bv.d paramd)
  {
    AppMethodBeat.i(20672);
    ae.d("MicroMsg.SubCoreVerify", "saveToLbsVerifyStg, cmdAM, status = " + paramcv.nJb + ", id = " + paramcv.xrk);
    bs localbs = new bs();
    localbs.field_content = z.a(paramcv.FNI);
    localbs.field_createtime = bu.aRi();
    localbs.field_imgpath = "";
    localbs.field_sayhicontent = paramd.content;
    localbs.field_sayhiuser = paramd.cUA;
    localbs.field_scene = paramd.scene;
    if (paramcv.nJb > 3) {}
    for (int i = paramcv.nJb;; i = 3)
    {
      localbs.field_status = i;
      localbs.field_svrid = paramcv.xrk;
      localbs.field_talker = z.a(paramcv.FNG);
      localbs.field_type = paramcv.urJ;
      localbs.field_isSend = 0;
      localbs.field_sayhiencryptuser = paramd.Jhi;
      localbs.field_ticket = paramd.tIA;
      localbs.field_flag = 1;
      ((bt)((l)g.ab(l.class)).doG()).a(localbs);
      com.tencent.mm.aj.c.al(localbs.field_sayhiencryptuser, 3);
      AppMethodBeat.o(20672);
      return;
    }
  }
  
  public static bj aML()
  {
    AppMethodBeat.i(20666);
    g.ajP().aiU();
    bh localbh = aMM();
    bj localbj = (bj)((l)g.ab(l.class)).doI();
    localbj.add(localbh, g.ajU().IxZ.getLooper());
    AppMethodBeat.o(20666);
    return localbj;
  }
  
  public static bh aMM()
  {
    AppMethodBeat.i(20667);
    g.ajP().aiU();
    bh localbh = (bh)((l)g.ab(l.class)).doH();
    AppMethodBeat.o(20667);
    return localbh;
  }
  
  public static bt aMN()
  {
    AppMethodBeat.i(20668);
    g.ajP().aiU();
    bt localbt = (bt)((l)g.ab(l.class)).doG();
    AppMethodBeat.o(20668);
    return localbt;
  }
  
  public static cf aMO()
  {
    AppMethodBeat.i(20669);
    g.ajP().aiU();
    cf localcf = (cf)((l)g.ab(l.class)).doF();
    AppMethodBeat.o(20669);
    return localcf;
  }
  
  public static void b(cv paramcv, bv.d paramd)
  {
    AppMethodBeat.i(20673);
    ae.d("MicroMsg.SubCoreVerify", "saveToShakeVerifyStg, cmdAM, status = " + paramcv.nJb + ", id = " + paramcv.xrk);
    ce localce = new ce();
    localce.field_content = z.a(paramcv.FNI);
    localce.field_createtime = bu.aRi();
    localce.field_imgpath = "";
    localce.field_sayhicontent = paramd.content;
    localce.field_sayhiuser = paramd.cUA;
    localce.field_scene = paramd.scene;
    if (paramcv.nJb > 3) {}
    for (int i = paramcv.nJb;; i = 3)
    {
      localce.field_status = i;
      localce.field_svrid = paramcv.xrk;
      localce.field_talker = z.a(paramcv.FNG);
      localce.field_type = paramcv.urJ;
      localce.field_isSend = 0;
      ((cf)((l)g.ab(l.class)).doF()).a(localce);
      com.tencent.mm.aj.c.al(localce.field_sayhiuser, 3);
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
    e.d.a(Integer.valueOf(37), this.iuq);
    e.d.a(Integer.valueOf(65), this.iuq);
    e.d.a(Integer.valueOf(40), this.iur);
    com.tencent.mm.sdk.b.a.IvT.c(this.iuv);
    int j = aMM().fvk();
    long l = System.currentTimeMillis();
    bc.aCg();
    l -= bu.a((Long)com.tencent.mm.model.c.ajA().get(340225, null), 0L);
    ae.i("MicroMsg.SubCoreVerify", "timeInterval = ".concat(String.valueOf(l)));
    if ((l > 259200000L) && (j > 0))
    {
      Object localObject1 = aMM();
      Object localObject2 = String.format("select %s from %s where isNew = 1 ORDER BY lastModifiedTime DESC limit %d", new Object[] { "contentNickname", "fmessage_conversation", Integer.valueOf(2) });
      localObject1 = ((bh)localObject1).db.a((String)localObject2, null, 2);
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
        ae.i("MicroMsg.SubCoreVerify", "title = ".concat(String.valueOf(localObject1)));
        localObject2 = new nf();
        ((nf)localObject2).dCj.userName = null;
        ((nf)localObject2).dCj.bVF = ((String)localObject1);
        ((nf)localObject2).dCj.type = 0;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
        bc.aCg();
        com.tencent.mm.model.c.ajA().set(340225, Long.valueOf(System.currentTimeMillis()));
      }
    }
    AppMethodBeat.o(20671);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(20670);
    e.d.b(Integer.valueOf(37), this.iuq);
    e.d.b(Integer.valueOf(65), this.iuq);
    e.d.b(Integer.valueOf(40), this.iur);
    com.tencent.mm.sdk.b.a.IvT.d(this.iuv);
    bc.getNotification().Xo();
    AppMethodBeat.o(20670);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bj.d
 * JD-Core Version:    0.7.0.1
 */