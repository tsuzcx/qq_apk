package com.tencent.mm.modelverify;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.d;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.qe;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bz;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cc.f;
import com.tencent.mm.storage.cp;
import com.tencent.mm.storage.cq;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class d
  implements be
{
  public static int num = 0;
  public static int[] oXT = new int[1000];
  private final int hjL;
  private e oXP;
  private b oXQ;
  private final long oXR;
  private final int oXS;
  private IListener oXU;
  
  public d()
  {
    AppMethodBeat.i(20665);
    this.oXP = new e();
    this.oXQ = new b();
    this.oXR = 259200000L;
    this.hjL = 0;
    this.oXS = 2;
    this.oXU = new SubCoreVerify.1(this, f.hfK);
    AppMethodBeat.o(20665);
  }
  
  public static void a(dl paramdl, cc.f paramf)
  {
    AppMethodBeat.i(20672);
    Log.d("MicroMsg.SubCoreVerify", "saveToLbsVerifyStg, cmdAM, status = " + paramdl.vhk + ", id = " + paramdl.Njv);
    bz localbz = new bz();
    localbz.field_content = w.a(paramdl.YFG);
    localbz.field_createtime = Util.nowSecond();
    localbz.field_imgpath = "";
    localbz.field_sayhicontent = paramf.content;
    localbz.field_sayhiuser = paramf.hgk;
    localbz.field_scene = paramf.scene;
    if (paramdl.vhk > 3) {}
    for (int i = paramdl.vhk;; i = 3)
    {
      localbz.field_status = i;
      localbz.field_svrid = paramdl.Njv;
      localbz.field_talker = w.a(paramdl.YFE);
      localbz.field_type = paramdl.IIs;
      localbz.field_isSend = 0;
      localbz.field_sayhiencryptuser = paramf.adkQ;
      localbz.field_ticket = paramf.pPi;
      localbz.field_flag = 1;
      ((ca)((n)h.ax(n.class)).gaW()).a(localbz);
      com.tencent.mm.modelavatar.d.aS(localbz.field_sayhiencryptuser, 3);
      AppMethodBeat.o(20672);
      return;
    }
  }
  
  public static void b(dl paramdl, cc.f paramf)
  {
    AppMethodBeat.i(20673);
    Log.d("MicroMsg.SubCoreVerify", "saveToShakeVerifyStg, cmdAM, status = " + paramdl.vhk + ", id = " + paramdl.Njv);
    cp localcp = new cp();
    localcp.field_content = w.a(paramdl.YFG);
    localcp.field_createtime = Util.nowSecond();
    localcp.field_imgpath = "";
    localcp.field_sayhicontent = paramf.content;
    localcp.field_sayhiuser = paramf.hgk;
    localcp.field_scene = paramf.scene;
    if (paramdl.vhk > 3) {}
    for (int i = paramdl.vhk;; i = 3)
    {
      localcp.field_status = i;
      localcp.field_svrid = paramdl.Njv;
      localcp.field_talker = w.a(paramdl.YFE);
      localcp.field_type = paramdl.IIs;
      localcp.field_isSend = 0;
      ((cq)((n)h.ax(n.class)).gaV()).a(localcp);
      com.tencent.mm.modelavatar.d.aS(localcp.field_sayhiuser, 3);
      AppMethodBeat.o(20673);
      return;
    }
  }
  
  public static bq bNH()
  {
    AppMethodBeat.i(20666);
    h.baC().aZJ();
    bo localbo = bNI();
    bq localbq = (bq)((n)h.ax(n.class)).gaY();
    localbq.add(localbo, h.baH().getLooper());
    AppMethodBeat.o(20666);
    return localbq;
  }
  
  public static bo bNI()
  {
    AppMethodBeat.i(20667);
    h.baC().aZJ();
    bo localbo = (bo)((n)h.ax(n.class)).gaX();
    AppMethodBeat.o(20667);
    return localbo;
  }
  
  public static ca bNJ()
  {
    AppMethodBeat.i(20668);
    h.baC().aZJ();
    ca localca = (ca)((n)h.ax(n.class)).gaW();
    AppMethodBeat.o(20668);
    return localca;
  }
  
  public static cq bNK()
  {
    AppMethodBeat.i(20669);
    h.baC().aZJ();
    cq localcq = (cq)((n)h.ax(n.class)).gaV();
    AppMethodBeat.o(20669);
    return localcq;
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
    g.d.a(Integer.valueOf(37), this.oXP);
    g.d.a(Integer.valueOf(65), this.oXP);
    g.d.a(Integer.valueOf(40), this.oXQ);
    this.oXU.alive();
    int j = bNI().jbe();
    long l = System.currentTimeMillis();
    bh.bCz();
    l -= Util.nullAs((Long)c.ban().d(340225, null), 0L);
    Log.i("MicroMsg.SubCoreVerify", "timeInterval = ".concat(String.valueOf(l)));
    if ((l > 259200000L) && (j > 0))
    {
      Object localObject1 = bNI();
      Object localObject2 = String.format("select %s from %s where isNew = 1 ORDER BY lastModifiedTime DESC limit %d", new Object[] { "contentNickname", "fmessage_conversation", Integer.valueOf(2) });
      localObject1 = ((bo)localObject1).db.rawQuery((String)localObject2, null, 2);
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
        Log.i("MicroMsg.SubCoreVerify", "title = ".concat(String.valueOf(localObject1)));
        localObject2 = new qe();
        ((qe)localObject2).hTo.userName = null;
        ((qe)localObject2).hTo.nickName = ((String)localObject1);
        ((qe)localObject2).hTo.type = 0;
        ((qe)localObject2).publish();
        bh.bCz();
        c.ban().B(340225, Long.valueOf(System.currentTimeMillis()));
      }
    }
    AppMethodBeat.o(20671);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(20670);
    g.d.b(Integer.valueOf(37), this.oXP);
    g.d.b(Integer.valueOf(65), this.oXP);
    g.d.b(Integer.valueOf(40), this.oXQ);
    this.oXU.dead();
    bh.getNotification().aKV();
    AppMethodBeat.o(20670);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelverify.d
 * JD-Core Version:    0.7.0.1
 */