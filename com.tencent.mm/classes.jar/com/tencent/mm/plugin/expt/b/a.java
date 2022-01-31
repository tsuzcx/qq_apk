package com.tencent.mm.plugin.expt.b;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fb;
import com.tencent.mm.g.a.jw;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.g.a.qp.a;
import com.tencent.mm.g.a.qq;
import com.tencent.mm.g.b.a.de;
import com.tencent.mm.g.b.a.df;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bz;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.expt.ui.ExptDebugUI;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.protobuf.ds;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class a
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.expt.a.a
{
  private static a mbP;
  private int eAS;
  private int fsj;
  public com.tencent.mm.plugin.expt.e.d mbQ;
  public com.tencent.mm.plugin.expt.e.b mbR;
  private com.tencent.mm.a.f<Integer, com.tencent.mm.plugin.expt.d.a> mbS;
  private com.tencent.mm.a.f<String, Integer> mbT;
  private int mbU;
  private com.tencent.mm.sdk.b.c mbV;
  private n mbW;
  private com.tencent.mm.ai.f mbX;
  private com.tencent.mm.sdk.b.c<jw> mbY;
  
  private a()
  {
    AppMethodBeat.i(73494);
    this.fsj = 0;
    this.eAS = 0;
    this.mbS = new com.tencent.mm.memory.a.c(100);
    this.mbT = new com.tencent.mm.memory.a.c(100);
    this.mbU = 0;
    this.mbV = new a.1(this);
    this.mbW = new a.2(this);
    this.mbX = new a.3(this);
    this.mbY = new a.4(this);
    AppMethodBeat.o(73494);
  }
  
  private int MU(String paramString)
  {
    AppMethodBeat.i(73502);
    Integer localInteger = (Integer)this.mbT.get(paramString);
    if (localInteger != null)
    {
      i = localInteger.intValue();
      AppMethodBeat.o(73502);
      return i;
    }
    int i = this.mbR.MU(paramString);
    if (i > 0) {
      this.mbT.put(paramString, Integer.valueOf(i));
    }
    AppMethodBeat.o(73502);
    return i;
  }
  
  private static void a(SharedPreferences paramSharedPreferences, boolean paramBoolean)
  {
    AppMethodBeat.i(73510);
    paramSharedPreferences = paramSharedPreferences.edit();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramSharedPreferences.putInt("special_scene_enable", i).commit();
      ab.i("MicroMsg.ExptService", "setSpecialSceneEnable() enable: %s", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(73510);
      return;
    }
  }
  
  public static void a(List<com.tencent.mm.plugin.expt.d.a> paramList, List<ds> paramList1, List<Integer> paramList2)
  {
    AppMethodBeat.i(73514);
    LinkedList localLinkedList = new LinkedList();
    Object localObject1;
    Object localObject2;
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject1 = (com.tencent.mm.plugin.expt.d.a)paramList.next();
        if ((localObject1 != null) && (((com.tencent.mm.plugin.expt.d.a)localObject1).btc()))
        {
          localObject2 = new com.tencent.mm.plugin.welab.b.c();
          ((com.tencent.mm.plugin.welab.b.c)localObject2).vvd = ((com.tencent.mm.plugin.expt.d.a)localObject1).field_exptId;
          ((com.tencent.mm.plugin.welab.b.c)localObject2).TR = ((com.tencent.mm.plugin.expt.d.a)localObject1).field_groupId;
          ((com.tencent.mm.plugin.welab.b.c)localObject2).startTime = ((com.tencent.mm.plugin.expt.d.a)localObject1).field_startTime;
          ((com.tencent.mm.plugin.welab.b.c)localObject2).endTime = ((com.tencent.mm.plugin.expt.d.a)localObject1).field_endTime;
          ((com.tencent.mm.plugin.welab.b.c)localObject2).vvf = ((com.tencent.mm.plugin.expt.d.a)localObject1).field_exptContent;
          ((com.tencent.mm.plugin.welab.b.c)localObject2).vve = ((com.tencent.mm.plugin.expt.d.a)localObject1).field_exptSeq;
          ((com.tencent.mm.plugin.welab.b.c)localObject2).bSA = ((com.tencent.mm.plugin.expt.d.a)localObject1).bti();
          localLinkedList.add(localObject2);
        }
      }
    }
    paramList = new LinkedList();
    if (paramList1 != null)
    {
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        localObject1 = (ds)paramList1.next();
        localObject2 = new com.tencent.mm.plugin.welab.b.d();
        ((com.tencent.mm.plugin.welab.b.d)localObject2).appId = ((ds)localObject1).cwc;
        ((com.tencent.mm.plugin.welab.b.d)localObject2).status = ((ds)localObject1).status;
        paramList.add(localObject2);
      }
    }
    ((com.tencent.mm.plugin.welab.b.a)g.E(com.tencent.mm.plugin.welab.b.a.class)).e(localLinkedList, paramList, paramList2);
    AppMethodBeat.o(73514);
  }
  
  public static void aJ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(152434);
    ab.i("MicroMsg.ExptService", "notiy session uba config json[%b] isDel[%b]", new Object[] { Boolean.valueOf(bo.isNullOrNil(paramString)), Boolean.valueOf(paramBoolean) });
    qq localqq = new qq();
    localqq.cHg.cvV = paramString;
    localqq.cHg.cHf = Boolean.valueOf(paramBoolean);
    com.tencent.mm.sdk.b.a.ymk.l(localqq);
    AppMethodBeat.o(152434);
  }
  
  public static a bsG()
  {
    AppMethodBeat.i(73493);
    if (mbP == null) {
      mbP = new a();
    }
    a locala = mbP;
    AppMethodBeat.o(73493);
    return locala;
  }
  
  private void bsI()
  {
    AppMethodBeat.i(73508);
    int i = a(a.a.lVC, -1);
    Object localObject1;
    Object localObject2;
    if (!bo.hl(i, 0)) {
      if (bo.hl(i, 2))
      {
        localObject1 = a(a.a.lVF, "");
        ab.i("MicroMsg.ExptService", "manufacturers:%s", new Object[] { bo.bf((String)localObject1, "null") });
        if (bo.isNullOrNil((String)localObject1))
        {
          com.tencent.mm.booter.c.bD(true);
          i = a(a.a.lVG, 0);
          if ((!com.tencent.mm.compatible.util.d.fv(26)) || (!bo.hl(i, 0)) || (!com.tencent.mm.sdk.h.a.duM())) {
            break label431;
          }
          localObject2 = a(a.a.lVH, "");
          localObject1 = Build.MODEL.toLowerCase();
          ab.i("MicroMsg.ExptService", "model:%s startServiceHuaweiInfo:%s", new Object[] { localObject1, bo.bf((String)localObject2, "null") });
        }
      }
    }
    for (;;)
    {
      try
      {
        if (!bo.isNullOrNil((String)localObject2))
        {
          localObject2 = ((String)localObject2).split(",");
          i = 0;
          if (i >= localObject2.length) {
            break label442;
          }
          if (((String)localObject1).startsWith(localObject2[i].toLowerCase()))
          {
            com.tencent.mm.booter.c.jdMethod_if(1);
            i = 1;
            if (i == 0) {
              com.tencent.mm.booter.c.jdMethod_if(0);
            }
            AppMethodBeat.o(73508);
            return;
            localObject1 = ((String)localObject1).split(",");
            i = 0;
            if (i >= localObject1.length) {
              break label452;
            }
            if (String.valueOf(localObject1[i]).equalsIgnoreCase(Build.MANUFACTURER))
            {
              com.tencent.mm.booter.c.bD(false);
              i = 1;
              if (i != 0) {
                break;
              }
              com.tencent.mm.booter.c.bD(true);
              break;
            }
            i += 1;
            continue;
            if (!bo.hl(i, 1)) {
              break;
            }
            localObject1 = a(a.a.lVD, "");
            ab.i("MicroMsg.ExptService", "manufacturers:%s", new Object[] { bo.bf((String)localObject1, "null") });
            if (!bo.isNullOrNil((String)localObject1))
            {
              localObject1 = ((String)localObject1).split(",");
              i = 0;
              if (i >= localObject1.length) {
                break label447;
              }
              if (String.valueOf(localObject1[i]).equalsIgnoreCase(Build.MANUFACTURER))
              {
                com.tencent.mm.booter.c.bD(true);
                i = 1;
                if (i != 0) {
                  break;
                }
                com.tencent.mm.booter.c.bD(false);
                break;
              }
              i += 1;
              continue;
            }
            com.tencent.mm.booter.c.bD(false);
            break;
          }
          i += 1;
          continue;
        }
        com.tencent.mm.booter.c.jdMethod_if(0);
        AppMethodBeat.o(73508);
        return;
      }
      catch (Exception localException)
      {
        ab.i("MicroMsg.ExptService", "startServiceHuaweiInfo Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        com.tencent.mm.booter.c.jdMethod_if(0);
        AppMethodBeat.o(73508);
        return;
      }
      label431:
      com.tencent.mm.booter.c.jdMethod_if(1);
      AppMethodBeat.o(73508);
      return;
      label442:
      i = 0;
      continue;
      label447:
      i = 0;
      continue;
      label452:
      i = 0;
    }
  }
  
  private boolean bsJ()
  {
    return (this.mbQ == null) || (this.mbR == null);
  }
  
  private void bsK()
  {
    AppMethodBeat.i(73515);
    int i = a(a.a.lSh, -1);
    if (i != -1)
    {
      h.qsU.cT(1006, 200);
      ab.i("MicroMsg.ExptService", "snsStoryReport config[%d]", new Object[] { Integer.valueOf(i) });
    }
    AppMethodBeat.o(73515);
  }
  
  private static void c(SharedPreferences paramSharedPreferences)
  {
    boolean bool2 = false;
    AppMethodBeat.i(73509);
    int i = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lTC, -1);
    ab.i("MicroMsg.ExptService", "iniNotificationSpecialSceneSwitchEnable() enable:%s", new Object[] { Integer.valueOf(i) });
    Object localObject;
    boolean bool1;
    if (bo.hl(i, 1))
    {
      localObject = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lTD, "");
      ab.i("MicroMsg.ExptService", "specialSceneDetail %s", new Object[] { localObject });
      bool1 = bool2;
      if (!bo.isNullOrNil((String)localObject))
      {
        localObject = br.F((String)localObject, "manufacturerlist");
        bool1 = bool2;
        if (localObject != null) {
          if (!((Map)localObject).containsKey(".manufacturerlist.size")) {
            break label480;
          }
        }
      }
    }
    label268:
    label433:
    label480:
    for (i = bo.getInt((String)((Map)localObject).get(".manufacturerlist.size"), 0);; i = 0)
    {
      int k = Build.VERSION.SDK_INT;
      int j = 0;
      for (;;)
      {
        bool1 = bool2;
        if (j < i)
        {
          if (j != 0) {
            break label268;
          }
          if (!String.valueOf(bo.nullAsNil((String)((Map)localObject).get(".manufacturerlist.manufacturer.name"))).equalsIgnoreCase(Build.MANUFACTURER)) {
            break label433;
          }
        }
        for (bool1 = com.tencent.mm.sdk.h.b.g(k, bo.nullAsNil((String)((Map)localObject).get(".manufacturerlist.manufacturer.sdkversionmin")), bo.nullAsNil((String)((Map)localObject).get(".manufacturerlist.manufacturer.sdkversionmax")), bo.nullAsNil((String)((Map)localObject).get(".manufacturerlist.manufacturer.versintime")));; bool1 = com.tencent.mm.sdk.h.b.g(k, bo.nullAsNil((String)((Map)localObject).get(".manufacturerlist.manufacturer" + j + ".sdkversionmin")), bo.nullAsNil((String)((Map)localObject).get(".manufacturerlist.manufacturer" + j + ".sdkversionmax")), bo.nullAsNil((String)((Map)localObject).get(".manufacturerlist.manufacturer" + j + ".versintime"))))
        {
          a(paramSharedPreferences, bool1);
          AppMethodBeat.o(73509);
          return;
          if (!String.valueOf(bo.nullAsNil((String)((Map)localObject).get(".manufacturerlist.manufacturer" + j + ".name"))).equalsIgnoreCase(Build.MANUFACTURER)) {
            break;
          }
        }
        j += 1;
      }
      if (bo.hl(i, 0))
      {
        a(paramSharedPreferences, false);
        AppMethodBeat.o(73509);
        return;
      }
      if (bo.hl(i, 2)) {
        a(paramSharedPreferences, true);
      }
      AppMethodBeat.o(73509);
      return;
    }
  }
  
  public static void e(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(152433);
    ab.i("MicroMsg.ExptService", "notiy session config json[%b] needReport[%b] isDel[%b]", new Object[] { Boolean.valueOf(bo.isNullOrNil(paramString)), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    qp localqp = new qp();
    localqp.cHd.cvV = paramString;
    qp.a locala = localqp.cHd;
    if (paramBoolean2) {}
    for (;;)
    {
      locala.cHf = Boolean.valueOf(paramBoolean2);
      localqp.cHd.cHe = Boolean.valueOf(paramBoolean1);
      com.tencent.mm.sdk.b.a.ymk.l(localqp);
      AppMethodBeat.o(152433);
      return;
      paramBoolean2 = bo.isNullOrNil(paramString);
    }
  }
  
  public static void vv(int paramInt)
  {
    AppMethodBeat.i(73513);
    g.Rc().a(new b(paramInt), 0);
    AppMethodBeat.o(73513);
  }
  
  public final void MV(String paramString)
  {
    AppMethodBeat.i(73506);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.ExptService", "receive expt xml but content is null");
      AppMethodBeat.o(73506);
      return;
    }
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    com.tencent.mm.plugin.expt.d.a locala = new com.tencent.mm.plugin.expt.d.a();
    Object localObject;
    boolean bool;
    if (locala.MX(paramString)) {
      if (locala.field_exptSeq < 0)
      {
        h.qsU.idkeyStat(863L, 3L, 1L, false);
        localObject = vu(locala.field_exptId);
        if ((localObject != null) && (((com.tencent.mm.plugin.expt.d.a)localObject).btc())) {
          localLinkedList1.add(Integer.valueOf(locala.field_exptId));
        }
        if ((localObject != null) && (((com.tencent.mm.plugin.expt.d.a)localObject).btd())) {
          e("", false, true);
        }
        if ((localObject != null) && (((com.tencent.mm.plugin.expt.d.a)localObject).bte())) {
          aJ("", true);
        }
        localObject = new ArrayList();
        ((List)localObject).add(Integer.valueOf(locala.field_exptId));
        if (by((List)localObject) > 0)
        {
          bool = true;
          bsH();
        }
      }
    }
    for (;;)
    {
      if ((localLinkedList2.size() > 0) || (localLinkedList1.size() > 0)) {
        a(localLinkedList2, null, localLinkedList1);
      }
      ab.i("MicroMsg.ExptService", "received expt xml dbFlag[%b] [%s] ", new Object[] { Boolean.valueOf(bool), paramString });
      AppMethodBeat.o(73506);
      return;
      bool = false;
      break;
      h.qsU.idkeyStat(863L, 4L, 1L, false);
      localObject = new ArrayList();
      ((List)localObject).add(locala);
      if (bx((List)localObject) > 0) {}
      for (bool = true;; bool = false)
      {
        if (locala.btc()) {
          localLinkedList2.add(locala);
        }
        if (locala.btd()) {
          e(locala.bth(), locala.btg(), false);
        }
        if (locala.bte()) {
          aJ(locala.bth(), false);
        }
        localObject = new de();
        ((de)localObject).deV = locala.field_exptId;
        ((de)localObject).deW = locala.field_groupId;
        ((de)localObject).deX = locala.field_exptSeq;
        ((de)localObject).ake();
        break;
      }
      bool = false;
    }
  }
  
  public final float a(a.a parama, float paramFloat)
  {
    AppMethodBeat.i(73497);
    parama = a(parama, "");
    if (bo.isNullOrNil(parama))
    {
      AppMethodBeat.o(73497);
      return paramFloat;
    }
    paramFloat = bo.getFloat(parama, paramFloat);
    AppMethodBeat.o(73497);
    return paramFloat;
  }
  
  public final int a(a.a parama, int paramInt)
  {
    AppMethodBeat.i(73498);
    parama = a(parama, "");
    if (bo.isNullOrNil(parama))
    {
      AppMethodBeat.o(73498);
      return paramInt;
    }
    paramInt = bo.getInt(parama, paramInt);
    AppMethodBeat.o(73498);
    return paramInt;
  }
  
  public final long a(a.a parama, long paramLong)
  {
    AppMethodBeat.i(73499);
    parama = a(parama, "");
    if (bo.isNullOrNil(parama))
    {
      AppMethodBeat.o(73499);
      return paramLong;
    }
    paramLong = bo.getLong(parama, paramLong);
    AppMethodBeat.o(73499);
    return paramLong;
  }
  
  public final String a(a.a parama, String paramString)
  {
    AppMethodBeat.i(73500);
    if (parama == null)
    {
      AppMethodBeat.o(73500);
      return paramString;
    }
    if (bsJ())
    {
      com.tencent.mm.plugin.expt.e.c.btm();
      str = com.tencent.mm.plugin.expt.e.c.a(parama, paramString, true);
      ab.i("MicroMsg.ExptService", "API check Expt from mmkv result[%s] key[%s] def[%s]", new Object[] { str, parama, paramString });
      AppMethodBeat.o(73500);
      return str;
    }
    long l = bo.yB();
    String str = parama.name();
    int i = MU(str);
    df localdf = new df();
    PBool localPBool = new PBool();
    Object localObject = a(i, true, localdf, localPBool);
    if ((localObject == null) || (((HashMap)localObject).size() <= 0))
    {
      AppMethodBeat.o(73500);
      return paramString;
    }
    localObject = (String)((HashMap)localObject).get(str);
    if ((!bo.isNullOrNil((String)localObject)) && (localPBool.value)) {
      localdf.iz(str).iA((String)localObject).ake();
    }
    ab.i("MicroMsg.ExptService", "API Got Expt result[%s] exptId[%d] key[%s %s] defStr[%s] cost[%d]", new Object[] { localObject, Integer.valueOf(i), parama, str, paramString, Long.valueOf(bo.av(l)) });
    if (!bo.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(73500);
      return localObject;
    }
    AppMethodBeat.o(73500);
    return paramString;
  }
  
  public final HashMap<String, String> a(int paramInt, boolean paramBoolean, df paramdf, PBool paramPBool)
  {
    AppMethodBeat.i(73503);
    if (this.mbQ == null)
    {
      ab.e("MicroMsg.ExptService", "Expt service is not init here! exptId[%d]", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(73503);
      return null;
    }
    if (paramInt <= 0)
    {
      AppMethodBeat.o(73503);
      return null;
    }
    long l = bo.yB();
    Object localObject1 = null;
    Object localObject2 = null;
    com.tencent.mm.plugin.expt.d.a locala = vu(paramInt);
    if ((locala == null) || (bo.isNullOrNil(locala.field_exptContent)))
    {
      ab.w("MicroMsg.ExptService", "expt item is null or expt content is null.");
      if (localObject1 == null) {
        break label321;
      }
    }
    label321:
    for (paramdf = (df)localObject1;; paramdf = Integer.valueOf(0))
    {
      ab.i("MicroMsg.ExptService", "get expt [%d] map[%s] expt[%s] cost[%d]", new Object[] { Integer.valueOf(paramInt), paramdf, localObject2, Long.valueOf(bo.av(l)) });
      AppMethodBeat.o(73503);
      return localObject1;
      String str = locala.field_exptContent;
      if ((paramBoolean) && (!locala.isReady()))
      {
        ab.w("MicroMsg.ExptService", "expt time is invalid time[%d %d] seq[%d]", new Object[] { Long.valueOf(locala.field_startTime), Long.valueOf(locala.field_endTime), Integer.valueOf(locala.field_exptSeq) });
        localObject2 = str;
        break;
      }
      HashMap localHashMap = locala.bti();
      localObject2 = str;
      localObject1 = localHashMap;
      if (!locala.btf()) {
        break;
      }
      paramPBool.value = true;
      localObject2 = str;
      localObject1 = localHashMap;
      if (paramdf == null) {
        break;
      }
      paramdf.deV = locala.field_exptId;
      paramdf.deW = locala.field_groupId;
      paramdf.deX = locala.field_exptSeq;
      paramdf.cUd = locala.field_startTime;
      paramdf.deY = locala.field_endTime;
      localObject2 = str;
      localObject1 = localHashMap;
      break;
    }
  }
  
  public final boolean a(a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(73496);
    parama = a(parama, "");
    if (bo.isNullOrNil(parama))
    {
      AppMethodBeat.o(73496);
      return paramBoolean;
    }
    if (paramBoolean) {}
    for (int i = 1; bo.getInt(parama, i) != 0; i = 0)
    {
      AppMethodBeat.o(73496);
      return true;
    }
    AppMethodBeat.o(73496);
    return false;
  }
  
  final void bsF()
  {
    try
    {
      AppMethodBeat.i(73492);
      this.mbS.clear();
      this.mbT.clear();
      AppMethodBeat.o(73492);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected final void bsH()
  {
    AppMethodBeat.i(73507);
    com.tencent.mm.sdk.b.a.ymk.l(new fb());
    SharedPreferences localSharedPreferences = com.tencent.mm.kernel.a.Mu();
    localSharedPreferences.edit().putBoolean("keepaliveserviceswitch", a(a.a.lTE, false)).commit();
    c(localSharedPreferences);
    bsK();
    bsI();
    AppMethodBeat.o(73507);
  }
  
  public final int bx(List<com.tencent.mm.plugin.expt.d.a> paramList)
  {
    AppMethodBeat.i(73511);
    if (paramList.size() <= 0)
    {
      AppMethodBeat.o(73511);
      return 0;
    }
    List localList = this.mbQ.bE(paramList);
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    int k;
    label140:
    label237:
    int j;
    int i;
    if (localList != null)
    {
      k = localList.size();
      Iterator localIterator1 = localList.iterator();
      while (localIterator1.hasNext())
      {
        com.tencent.mm.plugin.expt.d.a locala = (com.tencent.mm.plugin.expt.d.a)localIterator1.next();
        this.mbS.put(Integer.valueOf(locala.field_exptId), locala);
        Object localObject = locala.bti();
        if (localObject != null)
        {
          Iterator localIterator2 = ((HashMap)localObject).keySet().iterator();
          String str;
          if (localIterator2.hasNext())
          {
            str = (String)localIterator2.next();
            localObject = this.mbR.Na(str);
            if (localObject == null) {
              break label237;
            }
            if (((com.tencent.mm.plugin.expt.e.a)localObject).field_exptId == locala.field_exptId) {
              break label386;
            }
            ((com.tencent.mm.plugin.expt.e.a)localObject).field_exptId = locala.field_exptId;
            localLinkedList1.add(localObject);
          }
          for (;;)
          {
            this.mbT.put(((com.tencent.mm.plugin.expt.e.a)localObject).field_exptKey, Integer.valueOf(((com.tencent.mm.plugin.expt.e.a)localObject).field_exptId));
            break label140;
            break;
            localObject = new com.tencent.mm.plugin.expt.e.a();
            ((com.tencent.mm.plugin.expt.e.a)localObject).field_exptId = locala.field_exptId;
            ((com.tencent.mm.plugin.expt.e.a)localObject).field_exptKey = str;
            localLinkedList2.add(localObject);
          }
        }
      }
      j = this.mbR.bz(localLinkedList2);
      i = this.mbR.bA(localLinkedList1);
      com.tencent.mm.plugin.expt.e.c.btm().bC(localList);
    }
    for (;;)
    {
      ab.i("MicroMsg.ExptService", "replace ExptIds args[%d] db[%d] exptMap insert[list:%d  db:%d], update[list:%d db:%d]", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(k), Integer.valueOf(localLinkedList2.size()), Integer.valueOf(j), Integer.valueOf(localLinkedList1.size()), Integer.valueOf(i) });
      AppMethodBeat.o(73511);
      return k;
      label386:
      break;
      i = 0;
      j = 0;
      k = 0;
    }
  }
  
  public final int by(List<Integer> paramList)
  {
    AppMethodBeat.i(73512);
    int i = this.mbQ.by(paramList);
    ab.i("MicroMsg.ExptService", "delete expt ids deleteCount[%d] deleteMapCount[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(this.mbR.bB(paramList)) });
    bsF();
    com.tencent.mm.plugin.expt.e.c.btm().bD(paramList);
    AppMethodBeat.o(73512);
    return i;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(73504);
    ab.i("MicroMsg.ExptService", "onAccountInitialized, %d", new Object[] { Integer.valueOf(hashCode()) });
    ab.v("MicroMsg.ExptService", "add listener ");
    if (ah.brt())
    {
      com.tencent.mm.sdk.b.a.ymk.b(this.mbV);
      com.tencent.mm.sdk.b.a.ymk.b(this.mbY);
      g.Rc().a(2738, this.mbX);
      ((com.tencent.mm.plugin.messenger.foundation.a.p)g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("expt", this.mbW);
    }
    if (paramc != null) {}
    try
    {
      if (paramc.eIj)
      {
        ab.i("MicroMsg.ExptService", "client upgrade now, reset last update time. previous version [%d]", new Object[] { Integer.valueOf(paramc.eIk) });
        this.fsj = 0;
        g.RL().Ru().set(ac.a.yKb, Integer.valueOf(0));
      }
      AppMethodBeat.o(73504);
      return;
    }
    catch (Exception paramc)
    {
      ab.printErrStackTrace("MicroMsg.ExptService", paramc, "onAccountInitialized error[%s]", new Object[] { paramc.toString() });
      AppMethodBeat.o(73504);
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(73505);
    ab.i("MicroMsg.ExptService", "onAccountRelease");
    bsF();
    com.tencent.mm.sdk.b.a.ymk.d(this.mbV);
    com.tencent.mm.sdk.b.a.ymk.d(this.mbY);
    g.Rc().b(2738, this.mbX);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("expt", this.mbW);
    com.tencent.mm.sdk.g.d.ysm.remove("manual_get_expt");
    AppMethodBeat.o(73505);
  }
  
  public final void r(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(73495);
    paramIntent.setClass(paramContext, ExptDebugUI.class);
    paramContext.startActivity(paramIntent);
    AppMethodBeat.o(73495);
  }
  
  public final com.tencent.mm.plugin.expt.d.a vu(int paramInt)
  {
    AppMethodBeat.i(73501);
    com.tencent.mm.plugin.expt.d.a locala = (com.tencent.mm.plugin.expt.d.a)this.mbS.get(Integer.valueOf(paramInt));
    if (locala != null)
    {
      AppMethodBeat.o(73501);
      return locala;
    }
    locala = this.mbQ.vy(paramInt);
    if (locala != null) {
      this.mbS.put(Integer.valueOf(paramInt), locala);
    }
    AppMethodBeat.o(73501);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.b.a
 * JD-Core Version:    0.7.0.1
 */