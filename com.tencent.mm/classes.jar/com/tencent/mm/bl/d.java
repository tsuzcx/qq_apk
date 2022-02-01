package com.tencent.mm.bl;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.d;
import com.tencent.mm.f.a.gv;
import com.tencent.mm.f.a.ou;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.ca.d;
import com.tencent.mm.storage.cm;
import com.tencent.mm.storage.cn;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class d
  implements be
{
  public static int[] mfb = new int[1000];
  public static int num = 0;
  private final int ffC;
  private e meX;
  private b meY;
  private final long meZ;
  private final int mfa;
  private IListener mfc;
  
  public d()
  {
    AppMethodBeat.i(20665);
    this.meX = new e();
    this.meY = new b();
    this.meZ = 259200000L;
    this.ffC = 0;
    this.mfa = 2;
    this.mfc = new IListener() {};
    AppMethodBeat.o(20665);
  }
  
  public static void a(db paramdb, ca.d paramd)
  {
    AppMethodBeat.i(20672);
    Log.d("MicroMsg.SubCoreVerify", "saveToLbsVerifyStg, cmdAM, status = " + paramdb.rVU + ", id = " + paramdb.HlH);
    bx localbx = new bx();
    localbx.field_content = z.a(paramdb.RIF);
    localbx.field_createtime = Util.nowSecond();
    localbx.field_imgpath = "";
    localbx.field_sayhicontent = paramd.content;
    localbx.field_sayhiuser = paramd.fcC;
    localbx.field_scene = paramd.scene;
    if (paramdb.rVU > 3) {}
    for (int i = paramdb.rVU;; i = 3)
    {
      localbx.field_status = i;
      localbx.field_svrid = paramdb.HlH;
      localbx.field_talker = z.a(paramdb.RID);
      localbx.field_type = paramdb.COi;
      localbx.field_isSend = 0;
      localbx.field_sayhiencryptuser = paramd.VGV;
      localbx.field_ticket = paramd.BLy;
      localbx.field_flag = 1;
      ((by)((n)h.ae(n.class)).eSb()).a(localbx);
      com.tencent.mm.am.d.aH(localbx.field_sayhiencryptuser, 3);
      AppMethodBeat.o(20672);
      return;
    }
  }
  
  public static void b(db paramdb, ca.d paramd)
  {
    AppMethodBeat.i(20673);
    Log.d("MicroMsg.SubCoreVerify", "saveToShakeVerifyStg, cmdAM, status = " + paramdb.rVU + ", id = " + paramdb.HlH);
    cm localcm = new cm();
    localcm.field_content = z.a(paramdb.RIF);
    localcm.field_createtime = Util.nowSecond();
    localcm.field_imgpath = "";
    localcm.field_sayhicontent = paramd.content;
    localcm.field_sayhiuser = paramd.fcC;
    localcm.field_scene = paramd.scene;
    if (paramdb.rVU > 3) {}
    for (int i = paramdb.rVU;; i = 3)
    {
      localcm.field_status = i;
      localcm.field_svrid = paramdb.HlH;
      localcm.field_talker = z.a(paramdb.RID);
      localcm.field_type = paramdb.COi;
      localcm.field_isSend = 0;
      ((cn)((n)h.ae(n.class)).eSa()).a(localcm);
      com.tencent.mm.am.d.aH(localcm.field_sayhiuser, 3);
      AppMethodBeat.o(20673);
      return;
    }
  }
  
  public static bo bqb()
  {
    AppMethodBeat.i(20666);
    h.aHE().aGH();
    bm localbm = bqc();
    bo localbo = (bo)((n)h.ae(n.class)).eSd();
    localbo.add(localbm, h.aHJ().getLooper());
    AppMethodBeat.o(20666);
    return localbo;
  }
  
  public static bm bqc()
  {
    AppMethodBeat.i(20667);
    h.aHE().aGH();
    bm localbm = (bm)((n)h.ae(n.class)).eSc();
    AppMethodBeat.o(20667);
    return localbm;
  }
  
  public static by bqd()
  {
    AppMethodBeat.i(20668);
    h.aHE().aGH();
    by localby = (by)((n)h.ae(n.class)).eSb();
    AppMethodBeat.o(20668);
    return localby;
  }
  
  public static cn bqe()
  {
    AppMethodBeat.i(20669);
    h.aHE().aGH();
    cn localcn = (cn)((n)h.ae(n.class)).eSa();
    AppMethodBeat.o(20669);
    return localcn;
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
    h.d.a(Integer.valueOf(37), this.meX);
    h.d.a(Integer.valueOf(65), this.meX);
    h.d.a(Integer.valueOf(40), this.meY);
    EventCenter.instance.addListener(this.mfc);
    int j = bqc().hze();
    long l = System.currentTimeMillis();
    bh.beI();
    l -= Util.nullAs((Long)c.aHp().b(340225, null), 0L);
    Log.i("MicroMsg.SubCoreVerify", "timeInterval = ".concat(String.valueOf(l)));
    if ((l > 259200000L) && (j > 0))
    {
      Object localObject1 = bqc();
      Object localObject2 = String.format("select %s from %s where isNew = 1 ORDER BY lastModifiedTime DESC limit %d", new Object[] { "contentNickname", "fmessage_conversation", Integer.valueOf(2) });
      localObject1 = ((bm)localObject1).db.rawQuery((String)localObject2, null, 2);
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
        localObject2 = new ou();
        ((ou)localObject2).fNB.userName = null;
        ((ou)localObject2).fNB.nickName = ((String)localObject1);
        ((ou)localObject2).fNB.type = 0;
        EventCenter.instance.publish((IEvent)localObject2);
        bh.beI();
        c.aHp().i(340225, Long.valueOf(System.currentTimeMillis()));
      }
    }
    AppMethodBeat.o(20671);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(20670);
    h.d.b(Integer.valueOf(37), this.meX);
    h.d.b(Integer.valueOf(65), this.meX);
    h.d.b(Integer.valueOf(40), this.meY);
    EventCenter.instance.removeListener(this.mfc);
    bh.getNotification().aqY();
    AppMethodBeat.o(20670);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bl.d
 * JD-Core Version:    0.7.0.1
 */