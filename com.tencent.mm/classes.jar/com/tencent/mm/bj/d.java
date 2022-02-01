package com.tencent.mm.bj;

import android.database.Cursor;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.d;
import com.tencent.mm.g.a.gh;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bo.d;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class d
  implements aw
{
  public static int gMk = 0;
  public static int[] hYe = new int[1000];
  private final int cKE;
  private e hYa;
  private b hYb;
  private final long hYc;
  private final int hYd;
  private com.tencent.mm.sdk.b.c hYf;
  
  public d()
  {
    AppMethodBeat.i(20665);
    this.hYa = new e();
    this.hYb = new b();
    this.hYc = 259200000L;
    this.cKE = 0;
    this.hYd = 2;
    this.hYf = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(20665);
  }
  
  public static void a(cu paramcu, bo.d paramd)
  {
    AppMethodBeat.i(20672);
    ac.d("MicroMsg.SubCoreVerify", "saveToLbsVerifyStg, cmdAM, status = " + paramcu.ndj + ", id = " + paramcu.vTQ);
    bl localbl = new bl();
    localbl.field_content = z.a(paramcu.DPV);
    localbl.field_createtime = bs.aNx();
    localbl.field_imgpath = "";
    localbl.field_sayhicontent = paramd.content;
    localbl.field_sayhiuser = paramd.zTO;
    localbl.field_scene = paramd.scene;
    if (paramcu.ndj > 3) {}
    for (int i = paramcu.ndj;; i = 3)
    {
      localbl.field_status = i;
      localbl.field_svrid = paramcu.vTQ;
      localbl.field_talker = z.a(paramcu.DPT);
      localbl.field_type = paramcu.tit;
      localbl.field_isSend = 0;
      localbl.field_sayhiencryptuser = paramd.GZm;
      localbl.field_ticket = paramd.sBi;
      localbl.field_flag = 1;
      ((bm)((k)g.ab(k.class)).dco()).a(localbl);
      com.tencent.mm.aj.c.ag(localbl.field_sayhiencryptuser, 3);
      AppMethodBeat.o(20672);
      return;
    }
  }
  
  public static be aJd()
  {
    AppMethodBeat.i(20666);
    g.agP().afT();
    bc localbc = aJe();
    be localbe = (be)((k)g.ab(k.class)).dcq();
    localbe.add(localbc, g.agU().GrZ.getLooper());
    AppMethodBeat.o(20666);
    return localbe;
  }
  
  public static bc aJe()
  {
    AppMethodBeat.i(20667);
    g.agP().afT();
    bc localbc = (bc)((k)g.ab(k.class)).dcp();
    AppMethodBeat.o(20667);
    return localbc;
  }
  
  public static bm aJf()
  {
    AppMethodBeat.i(20668);
    g.agP().afT();
    bm localbm = (bm)((k)g.ab(k.class)).dco();
    AppMethodBeat.o(20668);
    return localbm;
  }
  
  public static by aJg()
  {
    AppMethodBeat.i(20669);
    g.agP().afT();
    by localby = (by)((k)g.ab(k.class)).dcn();
    AppMethodBeat.o(20669);
    return localby;
  }
  
  public static void b(cu paramcu, bo.d paramd)
  {
    AppMethodBeat.i(20673);
    ac.d("MicroMsg.SubCoreVerify", "saveToShakeVerifyStg, cmdAM, status = " + paramcu.ndj + ", id = " + paramcu.vTQ);
    bx localbx = new bx();
    localbx.field_content = z.a(paramcu.DPV);
    localbx.field_createtime = bs.aNx();
    localbx.field_imgpath = "";
    localbx.field_sayhicontent = paramd.content;
    localbx.field_sayhiuser = paramd.zTO;
    localbx.field_scene = paramd.scene;
    if (paramcu.ndj > 3) {}
    for (int i = paramcu.ndj;; i = 3)
    {
      localbx.field_status = i;
      localbx.field_svrid = paramcu.vTQ;
      localbx.field_talker = z.a(paramcu.DPT);
      localbx.field_type = paramcu.tit;
      localbx.field_isSend = 0;
      ((by)((k)g.ab(k.class)).dcn()).a(localbx);
      com.tencent.mm.aj.c.ag(localbx.field_sayhiuser, 3);
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
    f.d.a(Integer.valueOf(37), this.hYa);
    f.d.a(Integer.valueOf(65), this.hYa);
    f.d.a(Integer.valueOf(40), this.hYb);
    com.tencent.mm.sdk.b.a.GpY.c(this.hYf);
    int j = aJe().fbh();
    long l = System.currentTimeMillis();
    az.ayM();
    l -= bs.a((Long)com.tencent.mm.model.c.agA().get(340225, null), 0L);
    ac.i("MicroMsg.SubCoreVerify", "timeInterval = ".concat(String.valueOf(l)));
    if ((l > 259200000L) && (j > 0))
    {
      Object localObject1 = aJe();
      Object localObject2 = String.format("select %s from %s where isNew = 1 ORDER BY lastModifiedTime DESC limit %d", new Object[] { "contentNickname", "fmessage_conversation", Integer.valueOf(2) });
      localObject1 = ((bc)localObject1).db.a((String)localObject2, null, 2);
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
        ac.i("MicroMsg.SubCoreVerify", "title = ".concat(String.valueOf(localObject1)));
        localObject2 = new mw();
        ((mw)localObject2).dpr.userName = null;
        ((mw)localObject2).dpr.bLs = ((String)localObject1);
        ((mw)localObject2).dpr.type = 0;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
        az.ayM();
        com.tencent.mm.model.c.agA().set(340225, Long.valueOf(System.currentTimeMillis()));
      }
    }
    AppMethodBeat.o(20671);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(20670);
    f.d.b(Integer.valueOf(37), this.hYa);
    f.d.b(Integer.valueOf(65), this.hYa);
    f.d.b(Integer.valueOf(40), this.hYb);
    com.tencent.mm.sdk.b.a.GpY.d(this.hYf);
    az.getNotification().UP();
    AppMethodBeat.o(20670);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bj.d
 * JD-Core Version:    0.7.0.1
 */