package com.tencent.mm.bj;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.d;
import com.tencent.mm.g.a.go;
import com.tencent.mm.g.a.nx;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.de;
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
import com.tencent.mm.storage.cl;
import com.tencent.mm.storage.cm;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class d
  implements bd
{
  public static int ibS = 0;
  public static int[] jpG = new int[1000];
  private final int dnp;
  private e jpC;
  private b jpD;
  private final long jpE;
  private final int jpF;
  private IListener jpH;
  
  public d()
  {
    AppMethodBeat.i(20665);
    this.jpC = new e();
    this.jpD = new b();
    this.jpE = 259200000L;
    this.dnp = 0;
    this.jpF = 2;
    this.jpH = new IListener() {};
    AppMethodBeat.o(20665);
  }
  
  public static void a(de paramde, ca.d paramd)
  {
    AppMethodBeat.i(20672);
    Log.d("MicroMsg.SubCoreVerify", "saveToLbsVerifyStg, cmdAM, status = " + paramde.oTW + ", id = " + paramde.Brn);
    bx localbx = new bx();
    localbx.field_content = z.a(paramde.KHn);
    localbx.field_createtime = Util.nowSecond();
    localbx.field_imgpath = "";
    localbx.field_sayhicontent = paramd.content;
    localbx.field_sayhiuser = paramd.dkU;
    localbx.field_scene = paramd.scene;
    if (paramde.oTW > 3) {}
    for (int i = paramde.oTW;; i = 3)
    {
      localbx.field_status = i;
      localbx.field_svrid = paramde.Brn;
      localbx.field_talker = z.a(paramde.KHl);
      localbx.field_type = paramde.xKb;
      localbx.field_isSend = 0;
      localbx.field_sayhiencryptuser = paramd.OqZ;
      localbx.field_ticket = paramd.wZz;
      localbx.field_flag = 1;
      ((by)((l)g.af(l.class)).eiv()).a(localbx);
      com.tencent.mm.aj.c.ap(localbx.field_sayhiencryptuser, 3);
      AppMethodBeat.o(20672);
      return;
    }
  }
  
  public static void b(de paramde, ca.d paramd)
  {
    AppMethodBeat.i(20673);
    Log.d("MicroMsg.SubCoreVerify", "saveToShakeVerifyStg, cmdAM, status = " + paramde.oTW + ", id = " + paramde.Brn);
    cl localcl = new cl();
    localcl.field_content = z.a(paramde.KHn);
    localcl.field_createtime = Util.nowSecond();
    localcl.field_imgpath = "";
    localcl.field_sayhicontent = paramd.content;
    localcl.field_sayhiuser = paramd.dkU;
    localcl.field_scene = paramd.scene;
    if (paramde.oTW > 3) {}
    for (int i = paramde.oTW;; i = 3)
    {
      localcl.field_status = i;
      localcl.field_svrid = paramde.Brn;
      localcl.field_talker = z.a(paramde.KHl);
      localcl.field_type = paramde.xKb;
      localcl.field_isSend = 0;
      ((cm)((l)g.af(l.class)).eiu()).a(localcl);
      com.tencent.mm.aj.c.ap(localcl.field_sayhiuser, 3);
      AppMethodBeat.o(20673);
      return;
    }
  }
  
  public static bo bgM()
  {
    AppMethodBeat.i(20666);
    g.aAf().azk();
    bm localbm = bgN();
    bo localbo = (bo)((l)g.af(l.class)).eix();
    localbo.add(localbm, g.aAk().getLooper());
    AppMethodBeat.o(20666);
    return localbo;
  }
  
  public static bm bgN()
  {
    AppMethodBeat.i(20667);
    g.aAf().azk();
    bm localbm = (bm)((l)g.af(l.class)).eiw();
    AppMethodBeat.o(20667);
    return localbm;
  }
  
  public static by bgO()
  {
    AppMethodBeat.i(20668);
    g.aAf().azk();
    by localby = (by)((l)g.af(l.class)).eiv();
    AppMethodBeat.o(20668);
    return localby;
  }
  
  public static cm bgP()
  {
    AppMethodBeat.i(20669);
    g.aAf().azk();
    cm localcm = (cm)((l)g.af(l.class)).eiu();
    AppMethodBeat.o(20669);
    return localcm;
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
    h.d.a(Integer.valueOf(37), this.jpC);
    h.d.a(Integer.valueOf(65), this.jpC);
    h.d.a(Integer.valueOf(40), this.jpD);
    EventCenter.instance.addListener(this.jpH);
    int j = bgN().gCR();
    long l = System.currentTimeMillis();
    bg.aVF();
    l -= Util.nullAs((Long)com.tencent.mm.model.c.azQ().get(340225, null), 0L);
    Log.i("MicroMsg.SubCoreVerify", "timeInterval = ".concat(String.valueOf(l)));
    if ((l > 259200000L) && (j > 0))
    {
      Object localObject1 = bgN();
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
        localObject2 = new nx();
        ((nx)localObject2).dTZ.userName = null;
        ((nx)localObject2).dTZ.nickName = ((String)localObject1);
        ((nx)localObject2).dTZ.type = 0;
        EventCenter.instance.publish((IEvent)localObject2);
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(340225, Long.valueOf(System.currentTimeMillis()));
      }
    }
    AppMethodBeat.o(20671);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(20670);
    h.d.b(Integer.valueOf(37), this.jpC);
    h.d.b(Integer.valueOf(65), this.jpC);
    h.d.b(Integer.valueOf(40), this.jpD);
    EventCenter.instance.removeListener(this.jpH);
    bg.getNotification().alb();
    AppMethodBeat.o(20670);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bj.d
 * JD-Core Version:    0.7.0.1
 */