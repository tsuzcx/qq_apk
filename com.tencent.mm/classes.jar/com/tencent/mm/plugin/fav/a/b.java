package com.tencent.mm.plugin.fav.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.dh;
import com.tencent.mm.autogen.a.hn;
import com.tencent.mm.autogen.a.ht;
import com.tencent.mm.autogen.a.ht.a;
import com.tencent.mm.autogen.a.ht.b;
import com.tencent.mm.autogen.a.ql;
import com.tencent.mm.autogen.a.vc;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.e.d;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.ark;
import com.tencent.mm.protocal.protobuf.arm;
import com.tencent.mm.protocal.protobuf.arp;
import com.tencent.mm.protocal.protobuf.aru;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.protocal.protobuf.asi;
import com.tencent.mm.protocal.protobuf.ask;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.protocal.protobuf.dpo;
import com.tencent.mm.protocal.protobuf.dpr;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class b
{
  private static HashMap<Long, ArrayList<String>> Acd;
  private static long Ace;
  
  static
  {
    AppMethodBeat.i(103360);
    Acd = new HashMap();
    Ace = 0L;
    AppMethodBeat.o(103360);
  }
  
  public static String Ew(String paramString)
  {
    AppMethodBeat.i(274377);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(274377);
      return "";
    }
    paramString = atP(paramString);
    paramString = com.tencent.mm.vfs.ah.v(new u(atO(paramString), paramString).jKT());
    AppMethodBeat.o(274377);
    return paramString;
  }
  
  public static long H(long paramLong, int paramInt)
  {
    AppMethodBeat.i(103323);
    Log.i("MicroMsg.Fav.FavApiLogic", "tryStartBatchGet...");
    long l1 = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().O(paramLong, paramInt);
    long l2 = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().M(paramLong, paramInt);
    Log.i("MicroMsg.Fav.FavApiLogic", "klem, tryStartBatchGet, batchGetTime:%d, itemTiem:%d, updateTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(paramLong) });
    if (l1 == 0L)
    {
      AppMethodBeat.o(103323);
      return l2;
    }
    Object localObject = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().N(l1, paramInt);
    if ((localObject != null) && (((LinkedList)localObject).size() > 0))
    {
      Log.i("MicroMsg.Fav.FavApiLogic", "klem, tryStartBatchGet, batchGetTime:%d, itemTiem:%d, updateTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(paramLong) });
      Log.i("MicroMsg.Fav.FavApiLogic", "klem, tryStartBatchGet, need batch get idList size:%d", new Object[] { Integer.valueOf(((LinkedList)localObject).size()) });
      if (dQf())
      {
        Log.i("MicroMsg.Fav.FavApiLogic", "now %d batch-get scene is doing", new Object[] { Integer.valueOf(ak.dQU()) });
        com.tencent.mm.kernel.h.baD().mCm.cancel(402);
      }
      localObject = new ak((LinkedList)localObject);
      if (!com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject, 0))
      {
        Log.w("MicroMsg.Fav.FavApiLogic", "do scene BatchGetFav fail");
        ak.dQT();
      }
    }
    if (l2 == 0L)
    {
      AppMethodBeat.o(103323);
      return l1;
    }
    if (l1 < l2)
    {
      AppMethodBeat.o(103323);
      return l1;
    }
    AppMethodBeat.o(103323);
    return l2;
  }
  
  public static String IE(String paramString)
  {
    AppMethodBeat.i(103304);
    Object localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramString);
    if (localObject == null)
    {
      Log.w("MicroMsg.Fav.FavApiLogic", "wtf get contact null, username %s", new Object[] { paramString });
      AppMethodBeat.o(103304);
      return "";
    }
    String str = ((au)localObject).aSV();
    localObject = str;
    if (au.bwE(str))
    {
      paramString = com.tencent.mm.model.v.Il(paramString);
      localObject = z.bAM();
      if ((paramString != null) && (!paramString.isEmpty())) {
        break label104;
      }
      Log.w("MicroMsg.Fav.FavApiLogic", "get members from username error, content empty");
    }
    for (localObject = str;; localObject = com.tencent.mm.model.v.n(paramString, 3))
    {
      AppMethodBeat.o(103304);
      return localObject;
      label104:
      paramString.remove(localObject);
      paramString.add(0, localObject);
    }
  }
  
  public static boolean Mz(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = a.Acb;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static long a(g paramg)
  {
    AppMethodBeat.i(103261);
    Object localObject = a.Acb;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      if (localObject[i] == paramg.field_type)
      {
        if (paramg.field_favProto != null)
        {
          localObject = paramg.field_favProto.vEn.iterator();
          for (long l1 = 0L;; l1 = ((arf)((Iterator)localObject).next()).Zza + l1)
          {
            l2 = l1;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
          }
        }
        long l2 = 0L;
        paramg.field_datatotalsize = l2;
        Log.d("MicroMsg.Fav.FavApiLogic", "calFavItemInfoTotalLength id:%d,length:%d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(l2) });
        AppMethodBeat.o(103261);
        return l2;
      }
      i += 1;
    }
    AppMethodBeat.o(103261);
    return 0L;
  }
  
  public static g a(arv paramarv)
  {
    AppMethodBeat.i(103342);
    g localg = new g();
    localg.field_favProto = new arv();
    localg.field_type = 18;
    localg.field_favProto = paramarv;
    AppMethodBeat.o(103342);
    return localg;
  }
  
  public static arf a(g paramg, String paramString)
  {
    AppMethodBeat.i(103292);
    if ((Util.isNullOrNil(paramString)) || (paramg == null) || (paramg.field_favProto.vEn.size() == 0))
    {
      AppMethodBeat.o(103292);
      return null;
    }
    paramg = paramg.field_favProto.vEn.iterator();
    while (paramg.hasNext())
    {
      arf localarf = (arf)paramg.next();
      if (localarf.hIQ.equals(paramString))
      {
        AppMethodBeat.o(103292);
        return localarf;
      }
    }
    AppMethodBeat.o(103292);
    return null;
  }
  
  public static ark a(int paramInt, arv paramarv, asi paramasi)
  {
    AppMethodBeat.i(103262);
    if (paramarv == null)
    {
      Log.w("MicroMsg.Fav.FavApiLogic", "proto item is null");
      AppMethodBeat.o(103262);
      return null;
    }
    ark localark = new ark();
    asb localasb = paramarv.ZBt;
    if (localasb != null)
    {
      localark.hQQ = localasb.hQQ;
      localark.ZBe = localasb.ZAT;
      localark.appId = localasb.appId;
      localark.hzi = localasb.hzi;
    }
    if (paramasi != null)
    {
      if (paramasi.ZBG != null) {
        localark.ZBf.addAll(paramasi.ZBG);
      }
      if (paramasi.ZBH != null) {
        localark.ZBf.addAll(paramasi.ZBH);
      }
    }
    localark.hXw = paramarv;
    localark.type = paramInt;
    switch (paramInt)
    {
    case 3: 
    case 9: 
    case 13: 
    case 16: 
    case 17: 
    case 19: 
    case 20: 
    default: 
      Log.w("MicroMsg.Fav.FavApiLogic", "unknown type %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(103262);
      return localark;
    case 1: 
      localark.title = "";
      localark.desc = paramarv.desc;
      AppMethodBeat.o(103262);
      return localark;
    case 4: 
      if ((paramarv.vEn != null) && (!paramarv.vEn.isEmpty())) {
        localark.title = ((arf)paramarv.vEn.get(0)).title;
      }
      AppMethodBeat.o(103262);
      return localark;
    case 5: 
      if (paramarv.ZAj != null)
      {
        localark.title = paramarv.ZAj.title;
        localark.desc = paramarv.ZAj.ZBV;
      }
      if ((Util.isNullOrNil(localark.title)) && (paramarv.vEn != null) && (!paramarv.vEn.isEmpty())) {
        localark.title = ((arf)paramarv.vEn.get(0)).title;
      }
      if ((Util.isNullOrNil(localark.desc)) && (localasb != null)) {
        localark.desc = localasb.link;
      }
      AppMethodBeat.o(103262);
      return localark;
    case 6: 
      localark.title = paramarv.remark;
      if (Util.isNullOrNil(localark.title)) {
        if (paramarv.ZAh != null)
        {
          localark.title = paramarv.ZAh.hVI;
          localark.desc = paramarv.ZAh.label;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(103262);
        return localark;
        if (paramarv.ZAh != null) {
          localark.desc = paramarv.ZAh.hVI;
        }
      }
    case 2: 
      if ((paramarv.vEn != null) && (paramarv.vEn.size() > 0)) {
        localark.title = ((arf)paramarv.vEn.get(0)).title;
      }
      AppMethodBeat.o(103262);
      return localark;
    case 7: 
    case 21: 
      if ((paramarv.vEn != null) && (!paramarv.vEn.isEmpty()))
      {
        localark.title = ((arf)paramarv.vEn.get(0)).title;
        localark.desc = ((arf)paramarv.vEn.get(0)).desc;
      }
      AppMethodBeat.o(103262);
      return localark;
    case 8: 
      localark.title = paramarv.title;
      if ((Util.isNullOrNil(localark.title)) && (paramarv.vEn != null) && (!paramarv.vEn.isEmpty())) {
        localark.title = ((arf)paramarv.vEn.get(0)).title;
      }
      AppMethodBeat.o(103262);
      return localark;
    case 10: 
    case 11: 
      if (paramarv.ZAl != null)
      {
        localark.title = paramarv.ZAl.title;
        localark.desc = paramarv.ZAl.desc;
      }
      AppMethodBeat.o(103262);
      return localark;
    case 12: 
    case 15: 
      if (paramarv.ZAn != null)
      {
        localark.title = paramarv.ZAn.title;
        localark.desc = paramarv.ZAn.desc;
      }
      AppMethodBeat.o(103262);
      return localark;
    }
    paramarv = paramarv.vEn;
    if (paramarv == null)
    {
      AppMethodBeat.o(103262);
      return null;
    }
    paramarv = paramarv.iterator();
    while (paramarv.hasNext())
    {
      paramasi = (arf)paramarv.next();
      if (1 == paramasi.dataType) {
        localark.title = paramasi.desc;
      }
    }
    AppMethodBeat.o(103262);
    return localark;
  }
  
  public static String a(arf paramarf)
  {
    AppMethodBeat.i(103283);
    if ((paramarf == null) || (Util.isNullOrNil(paramarf.hIQ)))
    {
      AppMethodBeat.o(103283);
      return "";
    }
    paramarf = atP(paramarf.hIQ);
    paramarf = com.tencent.mm.vfs.ah.v(new u(atO(paramarf), paramarf).jKT());
    AppMethodBeat.o(103283);
    return paramarf;
  }
  
  private static ArrayList<g> a(List<String> paramList, ArrayList<g> paramArrayList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(274412);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = paramArrayList.iterator();
    g localg;
    if (localIterator1.hasNext())
    {
      localg = (g)localIterator1.next();
      if ((localg.field_type != 18) && (localg.field_type != 14)) {}
    }
    for (;;)
    {
      try
      {
        LinkedList localLinkedList = localg.field_favProto.vEn;
        if (localg.field_type != 18) {
          break label457;
        }
        i = 1;
        if (i >= localLinkedList.size()) {
          break;
        }
        arf localarf = (arf)localLinkedList.get(i);
        if (localarf.dataType != paramInt1) {
          break label471;
        }
        if (!Util.isNullOrNil(localarf.title))
        {
          paramArrayList = localarf.title;
          if ((paramList != null) && (!paramList.isEmpty()) && (!Util.isNullOrNil(paramArrayList)))
          {
            Iterator localIterator2 = paramList.iterator();
            if (!localIterator2.hasNext()) {
              break label451;
            }
            if (!paramArrayList.contains((String)localIterator2.next())) {
              continue;
            }
            j = 1;
            break label463;
          }
          paramArrayList = localg.dQt();
          paramArrayList.field_type = paramInt2;
          paramArrayList.Acq = true;
          paramArrayList.Acr = localg;
          paramArrayList.hIG = (localg.field_localId + "_" + localarf.hIQ);
          paramArrayList.Acs = localarf.hIQ;
          paramArrayList.field_favProto = com.tencent.mm.plugin.fav.a.a.c.c(localg.field_favProto);
          paramArrayList.field_favProto.vEn = new LinkedList();
          paramArrayList.field_favProto.vEn.add(localarf);
          paramArrayList.field_favProto.btm(localarf.title);
          if (localarf.Zzy != null)
          {
            if (paramInt1 == 6) {
              paramArrayList.field_favProto.d(localarf.Zzy.ZAh);
            }
          }
          else
          {
            localArrayList.add(paramArrayList);
            break label471;
          }
        }
        else
        {
          paramArrayList = localarf.desc;
          continue;
        }
        if (paramInt1 != 5) {
          continue;
        }
        paramArrayList.field_favProto.c(localarf.Zzy.ZAj);
        continue;
      }
      catch (Exception paramArrayList)
      {
        Log.e("MicroMsg.Fav.FavApiLogic", "getSearchList() [%s] Exception:%s %s", new Object[] { Integer.valueOf(paramInt1), paramArrayList.getClass().getSimpleName(), paramArrayList.getMessage() });
      }
      localArrayList.add(localg);
      break;
      AppMethodBeat.o(274412);
      return localArrayList;
      label451:
      int j = 0;
      break label463;
      label457:
      int i = 0;
      continue;
      label463:
      if (j == 0) {
        label471:
        i += 1;
      }
    }
  }
  
  public static ArrayList<g> a(List<String> paramList1, List<String> paramList2, int paramInt, List<g> paramList, Set<Integer> paramSet, x paramx)
  {
    AppMethodBeat.i(103333);
    ArrayList localArrayList1 = new ArrayList(1);
    localArrayList1.add(Integer.valueOf(paramInt));
    paramList2 = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavSearchStorage().b(paramList1, paramList2, localArrayList1);
    ArrayList localArrayList2 = new ArrayList();
    if ((paramList2 == null) || (paramList2.size() == 0))
    {
      AppMethodBeat.o(103333);
      return localArrayList2;
    }
    int i;
    label256:
    label361:
    for (int j = 0;; j = i)
    {
      ArrayList localArrayList3;
      if (j + 20 < paramList2.size())
      {
        i = j + 20;
        Log.v("MicroMsg.Fav.FavApiLogic", "start:%d  end:%d listSize:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramList2.size()) });
        boolean bool = e.d.mr(localArrayList1);
        localArrayList3 = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().a(paramList2.subList(j, i), paramList, paramSet, paramx, bool);
        if ((localArrayList3 != null) && (localArrayList3.size() > 0))
        {
          if (paramInt != 8) {
            break label256;
          }
          localArrayList2.addAll(a(paramList1, localArrayList3, 8, 8));
        }
      }
      for (;;)
      {
        if (i < paramList2.size()) {
          break label361;
        }
        AppMethodBeat.o(103333);
        return localArrayList2;
        i = paramList2.size();
        break;
        if (paramInt == 5) {
          localArrayList2.addAll(a(paramList1, localArrayList3, 5, 5));
        } else if (paramInt == 7) {
          localArrayList2.addAll(a(paramList1, localArrayList3, 7, 7));
        } else if (paramInt == 6) {
          localArrayList2.addAll(a(paramList1, localArrayList3, 6, 6));
        } else if (paramInt == 3) {
          localArrayList2.addAll(a(paramList1, localArrayList3, 3, 3));
        } else {
          localArrayList2.addAll(localArrayList3);
        }
      }
    }
  }
  
  public static ArrayList<g> a(List<String> paramList1, List<String> paramList2, List<Integer> paramList, List<g> paramList3, Set<Integer> paramSet, x paramx)
  {
    AppMethodBeat.i(103335);
    paramList1 = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavSearchStorage().b(paramList1, paramList2, paramList);
    paramList2 = new ArrayList();
    if ((paramList1 == null) || (paramList1.size() == 0))
    {
      AppMethodBeat.o(103335);
      return paramList2;
    }
    int i;
    for (int j = 0;; j = i)
    {
      Object localObject;
      if (j + 20 < paramList1.size())
      {
        i = j + 20;
        Log.v("MicroMsg.Fav.FavApiLogic", "start:%d  end:%d listSize:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramList1.size()) });
        boolean bool = e.d.mr(paramList);
        localObject = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().a(paramList1.subList(j, i), paramList3, paramSet, paramx, bool);
        if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
          break label348;
        }
        if (paramList.contains(Integer.valueOf(8))) {
          localObject = ((ArrayList)localObject).iterator();
        }
      }
      else
      {
        for (;;)
        {
          label198:
          if (!((Iterator)localObject).hasNext()) {
            break label348;
          }
          g localg = (g)((Iterator)localObject).next();
          if (localg.field_type == 18) {
            for (;;)
            {
              try
              {
                LinkedList localLinkedList = localg.field_favProto.vEn;
                j = 1;
                if (j >= localLinkedList.size()) {
                  continue;
                }
                int k = ((arf)localLinkedList.get(j)).dataType;
                if (k != 8) {
                  continue;
                }
                j = 1;
              }
              catch (Exception localException)
              {
                j = 0;
                continue;
              }
              if (j == 0) {
                break label198;
              }
              paramList2.add(localg);
              break label198;
              i = paramList1.size();
              break;
              j += 1;
              continue;
              j = 0;
            }
          }
          paramList2.add(localg);
        }
      }
      paramList2.addAll((Collection)localObject);
      label348:
      if (i >= paramList1.size())
      {
        AppMethodBeat.o(103335);
        return paramList2;
      }
    }
  }
  
  public static List<g> a(long paramLong, int paramInt, Set<Integer> paramSet, x paramx)
  {
    AppMethodBeat.i(103322);
    if (((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage() == null)
    {
      Log.e("MicroMsg.Fav.FavApiLogic", "getItemList error, getFavItemInfoStorage null.");
      AppMethodBeat.o(103322);
      return null;
    }
    if (paramLong == 0L)
    {
      paramSet = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().a(paramInt, paramSet, paramx);
      AppMethodBeat.o(103322);
      return paramSet;
    }
    paramSet = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().b(paramLong, paramInt, paramSet, paramx);
    AppMethodBeat.o(103322);
    return paramSet;
  }
  
  public static void a(long paramLong, arm paramarm, String paramString1, String paramString2, ArrayList<String> paramArrayList, Context paramContext)
  {
    AppMethodBeat.i(103355);
    if ((paramarm == null) || (paramContext == null))
    {
      AppMethodBeat.o(103355);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("KFavLocSigleView", true);
    localIntent.putExtra("map_view_type", 2);
    localIntent.putExtra("kFavInfoLocalId", paramLong);
    localIntent.putExtra("kwebmap_slat", paramarm.lat);
    localIntent.putExtra("kwebmap_lng", paramarm.lng);
    localIntent.putExtra("kPoiName", paramarm.hVI);
    localIntent.putExtra("Kwebmap_locaion", paramarm.label);
    if (paramarm.hQp >= 0) {
      localIntent.putExtra("kwebmap_scale", paramarm.hQp);
    }
    localIntent.putExtra("kisUsername", paramString1);
    localIntent.putExtra("kwebmap_from_to", true);
    localIntent.putExtra("kRemark", paramString2);
    localIntent.putExtra("kTags", paramArrayList);
    localIntent.putExtra("kFavCanDel", true);
    localIntent.putExtra("kFavCanRemark", true);
    com.tencent.mm.br.c.b(paramContext, "location", ".ui.RedirectUI", localIntent);
    AppMethodBeat.o(103355);
  }
  
  public static void a(Context paramContext, String paramString, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(103349);
    a(paramContext, paramString, paramIntent, paramInt, null);
    AppMethodBeat.o(103349);
  }
  
  public static void a(Context paramContext, String paramString, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(103350);
    Intent localIntent = paramIntent;
    if (paramIntent == null) {}
    try
    {
      localIntent = new Intent();
      String str = MMApplicationContext.getSourcePackageName() + ".plugin.fav";
      paramIntent = paramString;
      if (paramString.startsWith(".")) {
        paramIntent = str + paramString;
      }
      localIntent.setClassName(MMApplicationContext.getPackageName(), paramIntent);
      Class.forName(paramIntent, false, paramContext.getClassLoader());
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).startActivityForResult(localIntent, paramInt, paramBundle);
      }
      AppMethodBeat.o(103350);
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.Fav.FavApiLogic", "Class Not Found when startActivity %s", new Object[] { paramContext });
      AppMethodBeat.o(103350);
    }
  }
  
  public static void a(Context paramContext, String paramString, Intent paramIntent, Bundle paramBundle)
  {
    AppMethodBeat.i(103348);
    Intent localIntent = paramIntent;
    if (paramIntent == null) {}
    try
    {
      localIntent = new Intent();
      String str = MMApplicationContext.getSourcePackageName() + ".plugin.fav";
      paramIntent = paramString;
      if (paramString.startsWith(".")) {
        paramIntent = str + paramString;
      }
      localIntent.setClassName(MMApplicationContext.getPackageName(), paramIntent);
      Class.forName(paramIntent, false, paramContext.getClassLoader());
      if ((paramContext instanceof Activity))
      {
        paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramBundle).cG(localIntent);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aYi(), "com/tencent/mm/plugin/fav/api/FavApiLogic", "startFavActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
        paramContext.startActivity((Intent)paramString.sb(0), (Bundle)paramString.sb(1));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/fav/api/FavApiLogic", "startFavActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
        AppMethodBeat.o(103348);
        return;
      }
      localIntent.addFlags(268435456);
      paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramBundle).cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aYi(), "com/tencent/mm/plugin/fav/api/FavApiLogic", "startFavActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
      paramContext.startActivity((Intent)paramString.sb(0), (Bundle)paramString.sb(1));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/fav/api/FavApiLogic", "startFavActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
      AppMethodBeat.o(103348);
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.Fav.FavApiLogic", "Class Not Found when startActivity %s", new Object[] { paramContext });
      AppMethodBeat.o(103348);
    }
  }
  
  private static void a(ht paramht)
  {
    AppMethodBeat.i(103268);
    if (Util.isNullOrNil(paramht.hIR.desc))
    {
      paramht.hIS.ret = -1;
      AppMethodBeat.o(103268);
      return;
    }
    Object localObject = atW(paramht.hIR.desc);
    if ((localObject == null) || (((g)localObject).field_localId <= 0L))
    {
      paramht.hIS.ret = -1;
      AppMethodBeat.o(103268);
      return;
    }
    boolean bool = e((g)localObject);
    String str = paramht.hIR.hIX;
    if (bool)
    {
      paramht.hIS.ret = 1;
      paramht = (ArrayList)Acd.get(Long.valueOf(((g)localObject).field_localId));
      if (paramht != null)
      {
        if (paramht.contains(str)) {
          paramht.remove(str);
        }
        if (paramht.size() == 0) {
          Acd.remove(Long.valueOf(((g)localObject).field_localId));
        }
      }
      AppMethodBeat.o(103268);
      return;
    }
    if (Util.isNullOrNil(str))
    {
      paramht.hIS.ret = -1;
      AppMethodBeat.o(103268);
      return;
    }
    long l = ((g)localObject).field_localId;
    ArrayList localArrayList = (ArrayList)Acd.get(Long.valueOf(l));
    localObject = localArrayList;
    if (localArrayList == null) {
      localObject = new ArrayList();
    }
    ((ArrayList)localObject).add(str);
    Acd.put(Long.valueOf(l), localObject);
    localObject = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mK(l);
    if ((localObject == null) || (((g)localObject).field_localId <= 0L))
    {
      paramht.hIS.ret = -1;
      AppMethodBeat.o(103268);
      return;
    }
    if ((e((g)localObject)) || (((g)localObject).field_itemStatus == 10))
    {
      paramht.hIS.ret = -1;
      com.tencent.mm.kernel.h.baH().postToWorkerDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103255);
          b.d(b.this);
          AppMethodBeat.o(103255);
        }
      }, 500L);
      AppMethodBeat.o(103268);
      return;
    }
    paramht.hIS.ret = -1;
    AppMethodBeat.o(103268);
  }
  
  private static void a(c paramc, g paramg)
  {
    AppMethodBeat.i(103295);
    Iterator localIterator = paramg.field_favProto.vEn.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      arf localarf = (arf)localIterator.next();
      if ((localarf.dataType != 1) && (localarf.dataType != 6))
      {
        if (!Util.isNullOrNil(localarf.Ysw)) {
          break label185;
        }
        i += 1;
      }
    }
    label185:
    for (;;)
    {
      break;
      if (i == 0)
      {
        if (paramg.field_id > 0)
        {
          ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().ak(17, paramc.field_favLocalId);
          ((ah)com.tencent.mm.kernel.h.az(ah.class)).getModService().run();
          AppMethodBeat.o(103295);
          return;
        }
        ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().ak(9, paramc.field_favLocalId);
        ((ah)com.tencent.mm.kernel.h.az(ah.class)).getSendService().run();
      }
      AppMethodBeat.o(103295);
      return;
    }
  }
  
  public static void a(g paramg, int paramInt)
  {
    AppMethodBeat.i(103346);
    if (paramg == null)
    {
      Log.w("MicroMsg.Fav.FavApiLogic", "modeTag, item info is null");
      AppMethodBeat.o(103346);
      return;
    }
    Object localObject1 = new LinkedList();
    Object localObject2 = new dpo();
    ((dpo)localObject2).aaWn = 4;
    ((dpo)localObject2).aaWo = 0;
    ((LinkedList)localObject1).add(localObject2);
    localObject2 = new LinkedList();
    dpr localdpr = new dpr();
    localdpr.IKH = "favitem.taglist";
    localdpr.vhJ = 1;
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramg.field_tagProto.ZBH.size();
    int i = 0;
    while (i < j)
    {
      localStringBuffer.append("<tag>").append(Util.escapeStringForXml((String)paramg.field_tagProto.ZBH.get(i))).append("</tag>");
      i += 1;
    }
    localdpr.OzQ = localStringBuffer.toString();
    Log.v("MicroMsg.Fav.FavApiLogic", "do net scene mod tag, id=%d, tag=%s", new Object[] { Integer.valueOf(paramg.field_id), localdpr.OzQ });
    ((LinkedList)localObject2).add(localdpr);
    if (paramg.field_id > 0)
    {
      localObject1 = new ao(paramg.field_id, (LinkedList)localObject1, (LinkedList)localObject2);
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject1, 0);
      h.k(paramg.field_id, j, paramInt);
      AppMethodBeat.o(103346);
      return;
    }
    ((ah)com.tencent.mm.kernel.h.az(ah.class)).getEditService().a(paramg.field_localId, (LinkedList)localObject1, (LinkedList)localObject2, paramInt);
    AppMethodBeat.o(103346);
  }
  
  public static void a(g paramg, arf paramarf)
  {
    AppMethodBeat.i(103308);
    if (Util.isNullOrNil(paramarf.hIQ))
    {
      AppMethodBeat.o(103308);
      return;
    }
    String str = atP(paramarf.hIQ);
    c localc = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().aui(str);
    Object localObject = localc;
    if (localc != null)
    {
      localObject = localc;
      if (localc.field_status == 3)
      {
        ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().b(localc, new String[] { "dataId" });
        localObject = null;
      }
    }
    if ((localObject != null) && (((c)localObject).field_type == 1))
    {
      ((c)localObject).field_status = 1;
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().a((c)localObject, new String[] { "dataId" });
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnService().aug(str);
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnService().run();
      AppMethodBeat.o(103308);
      return;
    }
    localObject = new u(a(paramarf));
    if ((!Util.isNullOrNil(paramarf.ZyC)) && (!Util.isNullOrNil(paramarf.nRr)) && (!((u)localObject).jKS()))
    {
      a(paramarf, paramg, 1);
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnService().aug(str);
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnService().run();
    }
    AppMethodBeat.o(103308);
  }
  
  public static void a(g paramg, arf paramarf, boolean paramBoolean)
  {
    AppMethodBeat.i(103307);
    if ((paramg == null) || (Util.isNullOrNil(paramarf.hIQ)))
    {
      AppMethodBeat.o(103307);
      return;
    }
    Log.i("MicroMsg.Fav.FavApiLogic", "restart cdndata download, favId %d, favLocalId %d, dataId %s", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), paramarf.hIQ });
    Object localObject2 = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().aui(paramarf.hIQ);
    Object localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((c)localObject2).field_status == 3)
      {
        ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().b((c)localObject2, new String[] { "dataId" });
        localObject1 = null;
      }
    }
    localObject2 = localObject1;
    if (localObject1 != null) {
      if ((!Util.isNullOrNil(((c)localObject1).field_cdnUrl)) && (!Util.isNullOrNil(((c)localObject1).field_cdnKey)) && (!Util.isNullOrNil(((c)localObject1).field_dataId)) && (((c)localObject1).field_cdnUrl.equals(paramarf.Ysw)) && (((c)localObject1).field_cdnKey.equals(paramarf.ZyH)))
      {
        localObject2 = localObject1;
        if (((c)localObject1).field_dataId.equals(paramarf.hIQ)) {}
      }
      else
      {
        ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().b((c)localObject1, new String[] { "dataId" });
        localObject2 = null;
      }
    }
    if ((localObject2 != null) && (((c)localObject2).field_type == 1))
    {
      Log.i("MicroMsg.Fav.FavApiLogic", "klem data not download completed.");
      ((c)localObject2).field_status = 1;
      ((c)localObject2).field_path = d(paramarf);
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().a((c)localObject2, new String[] { "dataId" });
      if (paramBoolean)
      {
        ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnService().aug(paramarf.hIQ);
        if ((!Util.isNullOrNil(paramarf.ZzG)) && (paramarf.ZzG.equals("WeNoteHtmlFile")))
        {
          paramg = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().aui(paramarf.hIQ);
          ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnService().d(paramg);
        }
      }
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnService().run();
      AppMethodBeat.o(103307);
      return;
    }
    localObject1 = new u(d(paramarf));
    if ((!Util.isNullOrNil(paramarf.ZyH)) && (!Util.isNullOrNil(paramarf.Ysw)) && (!((u)localObject1).jKS()))
    {
      Log.i("MicroMsg.Fav.FavApiLogic", "klem big img not exist, start download.");
      long l = System.currentTimeMillis();
      a(paramarf, paramg, 1, true);
      if (paramBoolean)
      {
        ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnService().aug(paramarf.hIQ);
        if ((!Util.isNullOrNil(paramarf.ZzG)) && (paramarf.ZzG.equals("WeNoteHtmlFile")))
        {
          paramg = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().aui(paramarf.hIQ);
          ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnService().d(paramg);
        }
      }
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnService().run();
      Log.i("MicroMsg.Fav.FavApiLogic", "insert cdn item use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
    AppMethodBeat.o(103307);
  }
  
  public static void a(g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(103286);
    h(paramg);
    ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavSearchStorage().mM(paramg.field_localId);
    ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().A(paramg);
    ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().mI(paramg.field_localId);
    ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavTagSetMgr().w(paramg);
    if (paramBoolean)
    {
      Set localSet = dPV();
      localSet.add(paramg.field_id);
      p(localSet);
      dPX();
    }
    if (paramg.field_type == 18)
    {
      long l = paramg.field_localId;
      if (l <= 0L)
      {
        AppMethodBeat.o(103286);
        return;
      }
      paramg = new dh();
      paramg.hDk.localId = l;
      paramg.publish();
    }
    AppMethodBeat.o(103286);
  }
  
  public static void a(arf paramarf, int paramInt, long paramLong)
  {
    AppMethodBeat.i(103329);
    if (Util.isNullOrNil(paramarf.hIQ))
    {
      AppMethodBeat.o(103329);
      return;
    }
    if ((Util.isNullOrNil(paramarf.ZyC)) || (Util.isNullOrNil(paramarf.nRr)))
    {
      AppMethodBeat.o(103329);
      return;
    }
    String str = atP(paramarf.hIQ);
    c localc = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().aui(str);
    Object localObject = localc;
    if (localc != null) {
      if (localc.field_status != 3)
      {
        localObject = localc;
        if (localc.field_status != 4) {}
      }
      else
      {
        ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().b(localc, new String[] { "dataId" });
        localObject = null;
      }
    }
    if ((localObject != null) && (((c)localObject).field_type == 1))
    {
      ((c)localObject).field_status = 1;
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().a((c)localObject, new String[] { "dataId" });
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnService().aug(str);
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnService().run();
      AppMethodBeat.o(103329);
      return;
    }
    localObject = new u(a(paramarf));
    if ((!Util.isNullOrNil(paramarf.ZyC)) && (!Util.isNullOrNil(paramarf.nRr)) && (!((u)localObject).jKS()))
    {
      localObject = new g();
      ((g)localObject).field_localId = paramLong;
      ((g)localObject).field_id = -1;
      ((g)localObject).field_type = paramInt;
      a(paramarf, (g)localObject, 1);
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnService().aug(str);
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnService().run();
    }
    AppMethodBeat.o(103329);
  }
  
  public static void a(arf paramarf, g paramg, int paramInt)
  {
    AppMethodBeat.i(103296);
    if ((paramInt == 1) && ((paramarf.Zzk <= 0L) || (Util.isNullOrNil(paramarf.ZyC)) || (Util.isNullOrNil(paramarf.nRr))))
    {
      Log.e("MicroMsg.Fav.FavApiLogic", "insertCdnThumbInfo, type recv, cdndataurl must not be null!");
      AppMethodBeat.o(103296);
      return;
    }
    if ((paramInt == 0) && (Util.isNullOrNil(a(paramarf))))
    {
      Log.e("MicroMsg.Fav.FavApiLogic", "insertCdnThumbInfo, type send, path must not be null!");
      AppMethodBeat.o(103296);
      return;
    }
    String str = atP(paramarf.hIQ);
    if (((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().aui(str) != null)
    {
      Log.w("MicroMsg.Fav.FavApiLogic", "cdn info exist, id[%s], return", new Object[] { str });
      AppMethodBeat.o(103296);
      return;
    }
    Log.i("MicroMsg.Fav.FavApiLogic", "insert cdn thumb info, fav local id[%d] fav id[%d] dataId:[%s]", new Object[] { Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id), paramarf.hIQ });
    c localc = new c();
    localc.field_cdnKey = paramarf.ZyC;
    localc.field_cdnUrl = paramarf.nRr;
    localc.field_dataId = str;
    localc.field_favLocalId = paramg.field_localId;
    localc.field_totalLen = ((int)paramarf.Zzk);
    localc.field_type = paramInt;
    localc.field_status = 1;
    localc.field_path = a(paramarf);
    localc.field_modifyTime = Util.nowMilliSecond();
    localc.field_attrFlag |= 1L;
    ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().f(localc);
    if (paramInt == 1)
    {
      c(localc);
      AppMethodBeat.o(103296);
      return;
    }
    b(localc);
    AppMethodBeat.o(103296);
  }
  
  public static void a(arf paramarf, g paramg, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(103297);
    if ((paramInt == 1) && ((Util.isNullOrNil(paramarf.ZyH)) || (Util.isNullOrNil(paramarf.Ysw))))
    {
      Log.e("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo, type recv, cdndataurl must not be null!");
      AppMethodBeat.o(103297);
      return;
    }
    if ((paramInt == 0) && (Util.isNullOrNil(d(paramarf))))
    {
      Log.e("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo, type send, path must not be null!");
      AppMethodBeat.o(103297);
      return;
    }
    if (((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().aui(paramarf.hIQ) != null)
    {
      Log.w("MicroMsg.Fav.FavApiLogic", "cdn info exist, id[%s], return", new Object[] { paramarf.hIQ });
      AppMethodBeat.o(103297);
      return;
    }
    Log.i("MicroMsg.Fav.FavApiLogic", "insert cdn data info, fav local id[%d] fav id[%d] dataId:[%s]", new Object[] { Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id), paramarf.hIQ });
    c localc = new c();
    localc.field_dataId = paramarf.hIQ;
    localc.field_totalLen = ((int)paramarf.Zza);
    localc.field_type = paramInt;
    localc.field_favLocalId = paramg.field_localId;
    localc.field_cdnKey = paramarf.ZyH;
    localc.field_cdnUrl = paramarf.Ysw;
    localc.field_path = d(paramarf);
    boolean bool;
    int i;
    label411:
    if (paramarf.dataType == 3)
    {
      localc.field_dataType = atR(paramarf.ZyU);
      localc.field_modifyTime = Util.nowMilliSecond();
      bool = NetStatusUtil.isWifi(MMApplicationContext.getContext());
      if (paramInt == 0)
      {
        Log.i("MicroMsg.Fav.FavApiLogic", "can auto upload, force %B, isWifi %B, dataType %d, totalLen %d", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), Integer.valueOf(localc.field_dataType), Integer.valueOf(localc.field_totalLen) });
        if (!paramBoolean) {
          break label480;
        }
        i = 1;
        label331:
        if (i == 0) {
          break label618;
        }
        localc.field_status = 1;
        Log.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo upload status traning");
      }
      label350:
      if (paramInt == 1)
      {
        Log.i("MicroMsg.Fav.FavApiLogic", "can auto download, force %B, isWifi %B, dataType %d, totalLen %d", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), Integer.valueOf(localc.field_dataType), Integer.valueOf(localc.field_totalLen) });
        if (!paramBoolean) {
          break label635;
        }
        i = 1;
        if (i == 0) {
          break label759;
        }
        localc.field_status = 1;
        Log.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo download status traning");
      }
    }
    for (;;)
    {
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().f(localc);
      if (paramInt != 1) {
        break label776;
      }
      c(localc);
      AppMethodBeat.o(103297);
      return;
      localc.field_dataType = paramarf.dataType;
      break;
      label480:
      if (bool)
      {
        i = 1;
        break label331;
      }
      if ((localc.field_dataType != 8) && (localc.field_dataType != 4) && (localc.field_dataType != 15))
      {
        i = 1;
        break label331;
      }
      long l2 = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getLong("fav_mx_auto_upload_size", 0L);
      long l1 = l2;
      if (l2 == 0L) {
        l1 = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFileSizeLimit(true);
      }
      if (localc.field_totalLen <= l1)
      {
        Log.i("MicroMsg.Fav.FavApiLogic", "match max auto upload, max size %d", new Object[] { Long.valueOf(l1) });
        i = 1;
        break label331;
      }
      i = 0;
      break label331;
      label618:
      localc.field_status = 4;
      Log.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo upload status pause");
      break label350;
      label635:
      if (bool)
      {
        i = 1;
        break label411;
      }
      if ((localc.field_dataType != 8) && (localc.field_dataType != 4) && (localc.field_dataType != 15))
      {
        i = 1;
        break label411;
      }
      l1 = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getLong("fav_mx_auto_download_size", ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFileSizeLimit(true));
      if (localc.field_totalLen <= l1)
      {
        Log.i("MicroMsg.Fav.FavApiLogic", "match max auto download, max size %d", new Object[] { Long.valueOf(l1) });
        i = 1;
        break label411;
      }
      i = 0;
      break label411;
      label759:
      localc.field_status = 4;
      Log.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo download status pause");
    }
    label776:
    b(localc);
    AppMethodBeat.o(103297);
  }
  
  public static void a(String paramString1, Context paramContext, String paramString2)
  {
    AppMethodBeat.i(168687);
    if (Util.isNullOrNil(paramString1))
    {
      Log.w("MicroMsg.Fav.FavApiLogic", "share image to friend fail, imgPath is null");
      AppMethodBeat.o(168687);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Retr_File_Name", paramString1);
    localIntent.putExtra("Retr_Compress_Type", 0);
    localIntent.putExtra("Retr_Msg_Type", 0);
    localIntent.putExtra("msg_uuid", paramString2);
    com.tencent.mm.br.c.g(paramContext, ".ui.transmit.MsgRetransmitUI", localIntent);
    AppMethodBeat.o(168687);
  }
  
  public static boolean a(g paramg, Runnable paramRunnable)
  {
    AppMethodBeat.i(103289);
    boolean bool = a(paramg, true, paramRunnable);
    AppMethodBeat.o(103289);
    return bool;
  }
  
  public static boolean a(g paramg, final boolean paramBoolean, final Runnable paramRunnable)
  {
    AppMethodBeat.i(103287);
    if (paramg == null)
    {
      Log.w("MicroMsg.Fav.FavApiLogic", "delete fav item fail, item is null");
      MMHandlerThread.postToMainThread(paramRunnable);
      AppMethodBeat.o(103287);
      return false;
    }
    if (Looper.myLooper() == com.tencent.mm.kernel.h.baH().getLooper())
    {
      Log.i("MicroMsg.Fav.FavApiLogic", "delete favItem id %d, localId %d, needBatchDel %B, do directly", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), Boolean.valueOf(paramBoolean) });
      a(paramg, paramBoolean);
      MMHandlerThread.postToMainThread(paramRunnable);
      i(paramg);
    }
    for (;;)
    {
      AppMethodBeat.o(103287);
      return true;
      Log.i("MicroMsg.Fav.FavApiLogic", "delete favItem id %d, localId %d, needBatchDel %B, post to worker", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), Boolean.valueOf(paramBoolean) });
      com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103256);
          Log.i("MicroMsg.Fav.FavApiLogic", "delete favItem id %d, localId %d, needBatchDel %B, do on worker thread", new Object[] { Integer.valueOf(b.this.field_id), Long.valueOf(b.this.field_localId), Boolean.valueOf(paramBoolean) });
          b.a(b.this, paramBoolean);
          MMHandlerThread.postToMainThread(paramRunnable);
          b.s(b.this);
          AppMethodBeat.o(103256);
        }
      });
    }
  }
  
  public static String[] a(g paramg, MMHandler paramMMHandler)
  {
    Object localObject2 = null;
    AppMethodBeat.i(103356);
    if (paramg == null)
    {
      Log.w("MicroMsg.Fav.FavApiLogic", "GetThumbUrlAndLocalPath favItemInfo is null");
      AppMethodBeat.o(103356);
      return null;
    }
    final arf localarf = c(paramg);
    String[] arrayOfString = new String[2];
    Runnable local3 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(103257);
        b.a(b.this, localarf);
        AppMethodBeat.o(103257);
      }
    };
    Object localObject1;
    switch (paramg.field_type)
    {
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 12: 
    case 13: 
    case 16: 
    case 17: 
    default: 
      if (localarf != null)
      {
        arrayOfString[0] = a(localarf);
        arrayOfString[1] = localarf.hDd;
        paramMMHandler.post(local3);
      }
    case 5: 
    case 10: 
    case 15: 
    case 11: 
      for (;;)
      {
        Log.d("MicroMsg.Fav.FavApiLogic", "GetThumbUrlAndLocalPath thumbPath %s, thumbUrl %s, type %d", new Object[] { arrayOfString[0], arrayOfString[1], Integer.valueOf(paramg.field_type) });
        AppMethodBeat.o(103356);
        return arrayOfString;
        localObject1 = paramg.field_favProto.ZAj;
        if (localarf == null)
        {
          if (localObject1 != null) {
            arrayOfString[1] = ((ask)localObject1).thumbUrl;
          }
        }
        else
        {
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = ((ask)localObject1).thumbUrl)
          {
            localObject2 = localObject1;
            if (Util.isNullOrNil((String)localObject1)) {
              localObject2 = localarf.hDd;
            }
            arrayOfString[0] = a(localarf);
            arrayOfString[1] = localObject2;
            paramMMHandler.post(local3);
            break;
          }
          paramMMHandler = paramg.field_favProto.ZAl;
          if (paramMMHandler != null)
          {
            arrayOfString[1] = paramMMHandler.thumbUrl;
            continue;
            paramMMHandler = paramg.field_favProto.ZAn;
            if (paramMMHandler != null)
            {
              arrayOfString[1] = paramMMHandler.thumbUrl;
              continue;
              paramMMHandler = paramg.field_favProto.ZAl;
              if (paramMMHandler != null) {
                arrayOfString[1] = paramMMHandler.thumbUrl;
              }
            }
          }
        }
      }
    }
    if (paramg.field_favProto.vEn != null)
    {
      Iterator localIterator = paramg.field_favProto.vEn.iterator();
      label375:
      localObject1 = localObject2;
      if (localIterator.hasNext())
      {
        localObject1 = (arf)localIterator.next();
        if (((arf)localObject1).dataType != 2) {
          break label435;
        }
        localObject1 = d((arf)localObject1);
        paramMMHandler.post(local3);
      }
    }
    for (;;)
    {
      arrayOfString[0] = localObject1;
      arrayOfString[1] = localarf.hDd;
      break;
      label435:
      if (((arf)localObject1).dataType != 15) {
        break label375;
      }
      localObject1 = a((arf)localObject1);
      paramMMHandler.post(local3);
    }
  }
  
  private static u atO(String paramString)
  {
    AppMethodBeat.i(103279);
    int i = paramString.hashCode();
    paramString = new u(String.format("%s%s/%d/", new Object[] { com.tencent.mm.kernel.h.baE().mCJ, "favorite", Integer.valueOf(i & 0xFF) }));
    if ((!paramString.jKS()) || (!paramString.isDirectory())) {
      paramString.jKY();
    }
    AppMethodBeat.o(103279);
    return paramString;
  }
  
  public static String atP(String paramString)
  {
    AppMethodBeat.i(103284);
    paramString = paramString + "_t";
    AppMethodBeat.o(103284);
    return paramString;
  }
  
  public static boolean atQ(String paramString)
  {
    AppMethodBeat.i(103291);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(103291);
      return false;
    }
    boolean bool = paramString.endsWith("_t");
    AppMethodBeat.o(103291);
    return bool;
  }
  
  public static int atR(String paramString)
  {
    AppMethodBeat.i(184037);
    if ((!Util.isNullOrNil(paramString)) && (paramString.equals("speex")))
    {
      AppMethodBeat.o(184037);
      return -3;
    }
    if ((!Util.isNullOrNil(paramString)) && (paramString.equals("silk")))
    {
      AppMethodBeat.o(184037);
      return -4;
    }
    AppMethodBeat.o(184037);
    return -2;
  }
  
  public static String atS(String paramString)
  {
    AppMethodBeat.i(103303);
    au localau = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramString);
    if (localau != null)
    {
      if (!Util.isNullOrNil(localau.field_conRemark))
      {
        paramString = localau.field_conRemark;
        AppMethodBeat.o(103303);
        return paramString;
      }
      if (!Util.isNullOrNil(localau.field_nickname))
      {
        paramString = localau.field_nickname;
        AppMethodBeat.o(103303);
        return paramString;
      }
      paramString = localau.field_username;
      AppMethodBeat.o(103303);
      return paramString;
    }
    AppMethodBeat.o(103303);
    return paramString;
  }
  
  public static String atT(String paramString)
  {
    AppMethodBeat.i(103325);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(103325);
      return null;
    }
    paramString = new u(dPW() + com.tencent.mm.b.g.getMessageDigest(paramString.getBytes()));
    if (paramString.jKS())
    {
      paramString = com.tencent.mm.vfs.ah.v(paramString.jKT());
      AppMethodBeat.o(103325);
      return paramString;
    }
    AppMethodBeat.o(103325);
    return null;
  }
  
  public static int atU(String paramString)
  {
    AppMethodBeat.i(103336);
    if ((!Util.isNullOrNil(paramString)) && (paramString.equals("speex")))
    {
      AppMethodBeat.o(103336);
      return 1;
    }
    if ((!Util.isNullOrNil(paramString)) && (paramString.equals("silk")))
    {
      AppMethodBeat.o(103336);
      return 2;
    }
    AppMethodBeat.o(103336);
    return 0;
  }
  
  public static g atV(String paramString)
  {
    AppMethodBeat.i(103338);
    g localg = new g();
    localg.field_localId = -1L;
    localg.field_id = -1;
    localg.field_xml = paramString;
    localg.field_type = 18;
    localg.atX(paramString);
    AppMethodBeat.o(103338);
    return localg;
  }
  
  private static g atW(String paramString)
  {
    AppMethodBeat.i(103339);
    if ((paramString == null) || (paramString.equals("")))
    {
      Log.e("MicroMsg.Fav.FavApiLogic", "parseSnsNoteInfoXml but xml is null");
      AppMethodBeat.o(103339);
      return null;
    }
    paramString = paramString.replace("cdndataurl", "cdn_dataurl").replace("cdndatakey", "cdn_datakey").replace("cdnthumburl", "cdn_thumburl").replace("cdnthumbkey", "cdn_thumbkey").replace("datasize", "fullsize").replace("thumbsize", "thumbfullsize").replace("sourcename", "datasrcname").replace("sourcetime", "datasrctime").replace("streamlowbandurl", "stream_lowbandurl").replace("streamdataurl", "stream_dataurl").replace("streamweburl", "stream_weburl");
    if (!paramString.startsWith("<noteinfo>")) {
      paramString = "<noteinfo>" + paramString + "</noteinfo>";
    }
    for (;;)
    {
      Map localMap = XmlParser.parseXml(paramString, "noteinfo", null);
      if (localMap == null)
      {
        Log.e("MicroMsg.Fav.FavApiLogic", "parseSnsNoteInfoXml, FavItemInfo maps null");
        AppMethodBeat.o(103339);
        return null;
      }
      g localg = new g();
      try
      {
        localg.field_favProto = new arv();
        localg.field_type = 18;
        Object localObject = (String)localMap.get(".noteinfo.edittime");
        localg.field_favProto.yt(Util.getLong((String)localObject, 0L));
        localObject = new arp();
        ((arp)localObject).ZBn = ((String)localMap.get(".noteinfo.noteeditor"));
        ((arp)localObject).ZBm = ((String)localMap.get(".noteinfo.noteauthor"));
        localg.field_favProto.a((arp)localObject);
        localg.field_localId = Util.getLong((String)localMap.get(".noteinfo.favlocalid"), System.currentTimeMillis());
        com.tencent.mm.plugin.fav.a.a.c.a(paramString, localg.field_favProto);
        AppMethodBeat.o(103339);
        return localg;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.Fav.FavApiLogic", paramString, "", new Object[0]);
        Log.e("MicroMsg.Fav.FavApiLogic", "parseSnsNoteInfoXml , FavItemInfo exception:+%s", new Object[] { paramString.toString() });
        AppMethodBeat.o(103339);
        return null;
      }
    }
  }
  
  public static long b(g paramg)
  {
    AppMethodBeat.i(103263);
    if (paramg == null)
    {
      AppMethodBeat.o(103263);
      return 0L;
    }
    paramg = paramg.field_favProto.vEn.iterator();
    arf localarf;
    for (int i = 0; paramg.hasNext(); i = (int)(localarf.Zza + l))
    {
      localarf = (arf)paramg.next();
      l = i;
    }
    long l = i;
    AppMethodBeat.o(103263);
    return l;
  }
  
  public static String b(arv paramarv)
  {
    AppMethodBeat.i(103358);
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramarv != null) && (paramarv.vEn != null))
    {
      paramarv = paramarv.vEn.iterator();
      while (paramarv.hasNext()) {
        localStringBuilder.append(((arf)paramarv.next()).hIQ).append(";");
      }
    }
    paramarv = localStringBuilder.toString();
    AppMethodBeat.o(103358);
    return paramarv;
  }
  
  public static void b(Context paramContext, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(369754);
    a(paramContext, paramString, paramIntent, null);
    AppMethodBeat.o(369754);
  }
  
  private static void b(ht paramht)
  {
    AppMethodBeat.i(103341);
    g localg = atW(paramht.hIR.desc);
    if (localg == null)
    {
      AppMethodBeat.o(103341);
      return;
    }
    if ((localg.field_favProto != null) && (localg.field_favProto.vEn != null))
    {
      Iterator localIterator = localg.field_favProto.vEn.iterator();
      while (localIterator.hasNext())
      {
        arf localarf = (arf)localIterator.next();
        if (localarf.dataType == 20)
        {
          localarf.Kk(true);
          localarf.Kj(true);
          localarf.bsC("");
          localarf.bss("");
          localarf.bst("");
          localarf.bsq("");
          localarf.bsr("");
        }
      }
    }
    paramht.hIR.hDt = localg.field_favProto;
    AppMethodBeat.o(103341);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(103293);
    int i = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().J(paramc.field_favLocalId, 0);
    Log.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus, upload data status:%d, favlocalId:%d", new Object[] { Integer.valueOf(i), Long.valueOf(paramc.field_favLocalId) });
    g localg = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mK(paramc.field_favLocalId);
    if (localg == null)
    {
      Log.e("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus iteminfo null");
      AppMethodBeat.o(103293);
      return;
    }
    if (localg.dQs())
    {
      Log.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus waiting server upload skip.");
      AppMethodBeat.o(103293);
      return;
    }
    if ((paramc.field_status == 3) && (i != paramc.field_status) && (localg.field_type == 18) && (((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().aui(paramc.field_dataId).field_status == 3))
    {
      a(paramc, localg);
      AppMethodBeat.o(103293);
      return;
    }
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(103293);
      return;
      if (localg.dQr()) {
        ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().ak(15, paramc.field_favLocalId);
      }
      for (;;)
      {
        Log.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus, continue upload data, favlocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
        AppMethodBeat.o(103293);
        return;
        ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().ak(4, paramc.field_favLocalId);
      }
      if (localg.dQr()) {
        ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().ak(16, paramc.field_favLocalId);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(localg.field_type), Integer.valueOf(-5), Long.valueOf(b(localg)), Long.valueOf(h.mD(localg.field_localId)) });
        Log.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus, error, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
        AppMethodBeat.o(103293);
        return;
        ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().ak(6, paramc.field_favLocalId);
      }
      AppMethodBeat.o(103293);
      return;
      if (localg.field_type == 18)
      {
        a(paramc, localg);
        AppMethodBeat.o(103293);
        return;
      }
      if (localg.dQr())
      {
        ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().ak(17, paramc.field_favLocalId);
        Log.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus start mod faviteminfo, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
        ((ah)com.tencent.mm.kernel.h.az(ah.class)).getModService().run();
        AppMethodBeat.o(103293);
        return;
      }
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().ak(9, paramc.field_favLocalId);
      Log.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus start send faviteminfo, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getSendService().run();
      AppMethodBeat.o(103293);
      return;
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().ak(6, paramc.field_favLocalId);
      Log.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus pause, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
    }
  }
  
  private static void b(g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(103343);
    arp localarp = new arp();
    if (!paramBoolean) {
      localarp.ZBm = z.bAM();
    }
    localarp.ZBn = z.bAM();
    paramg.field_favProto.yt(Util.nowSecond());
    paramg.field_favProto.a(localarp);
    AppMethodBeat.o(103343);
  }
  
  public static void b(arf paramarf, int paramInt, long paramLong)
  {
    AppMethodBeat.i(103330);
    if (Util.isNullOrNil(paramarf.hIQ))
    {
      AppMethodBeat.o(103330);
      return;
    }
    Log.i("MicroMsg.Fav.FavApiLogic", "restart cdndata download, dataId %s", new Object[] { paramarf.hIQ });
    c localc = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().aui(paramarf.hIQ);
    Object localObject = localc;
    if (localc != null) {
      if (localc.field_status != 3)
      {
        localObject = localc;
        if (localc.field_status != 4) {}
      }
      else
      {
        ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().b(localc, new String[] { "dataId" });
        localObject = null;
      }
    }
    if ((localObject != null) && (((c)localObject).field_type == 1))
    {
      Log.i("MicroMsg.Fav.FavApiLogic", "klem data not download completed.");
      ((c)localObject).field_status = 1;
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().a((c)localObject, new String[] { "dataId" });
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnService().aug(paramarf.hIQ);
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnService().run();
      AppMethodBeat.o(103330);
      return;
    }
    localObject = new u(d(paramarf));
    if ((!Util.isNullOrNil(paramarf.ZyH)) && (!Util.isNullOrNil(paramarf.Ysw)) && (!((u)localObject).jKS()))
    {
      Log.i("MicroMsg.Fav.FavApiLogic", "klem big img not exist, start download.");
      long l = System.currentTimeMillis();
      localObject = new g();
      ((g)localObject).field_localId = paramLong;
      ((g)localObject).field_id = -1;
      ((g)localObject).field_type = paramInt;
      a(paramarf, (g)localObject, 1, true);
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnService().aug(paramarf.hIQ);
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnService().run();
      Log.i("MicroMsg.Fav.FavApiLogic", "insert cdn item use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
    AppMethodBeat.o(103330);
  }
  
  public static boolean b(long paramLong, Runnable paramRunnable)
  {
    AppMethodBeat.i(103331);
    boolean bool = a(((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mK(paramLong), true, paramRunnable);
    AppMethodBeat.o(103331);
    return bool;
  }
  
  public static arf c(g paramg)
  {
    AppMethodBeat.i(103264);
    if (paramg == null)
    {
      paramg = new arf();
      AppMethodBeat.o(103264);
      return paramg;
    }
    if (paramg.field_favProto.vEn.size() == 0)
    {
      paramg = new arf();
      AppMethodBeat.o(103264);
      return paramg;
    }
    paramg = (arf)paramg.field_favProto.vEn.get(0);
    AppMethodBeat.o(103264);
    return paramg;
  }
  
  public static String c(arf paramarf)
  {
    AppMethodBeat.i(103258);
    arg localarg = paramarf.Zzy;
    String str = "";
    switch (paramarf.dataType)
    {
    case 2: 
    case 3: 
    case 7: 
    case 9: 
    default: 
      paramarf = hB(hB("", localarg.title), localarg.desc);
    }
    for (;;)
    {
      AppMethodBeat.o(103258);
      return paramarf;
      paramarf = hB("", paramarf.desc);
      continue;
      paramarf = str;
      if (localarg.ZAn != null)
      {
        paramarf = hB("", localarg.ZAn.title);
        continue;
        paramarf = str;
        if (localarg.ZAj != null)
        {
          paramarf = hB("", localarg.ZAj.title);
          continue;
          str = hB("", localarg.remark);
          paramarf = str;
          if (localarg.ZAh != null)
          {
            paramarf = hB(hB(str, localarg.ZAh.hVI), localarg.ZAh.label);
            continue;
            paramarf = str;
            if (localarg.ZAl != null)
            {
              paramarf = hB(hB("", localarg.ZAl.title), localarg.ZAl.desc);
              continue;
              paramarf = hB("", localarg.title);
            }
          }
        }
      }
    }
  }
  
  public static void c(ht paramht)
  {
    int i = 1;
    AppMethodBeat.i(103345);
    Object localObject2;
    Object localObject3;
    if (paramht.hIR.hIY == 1)
    {
      paramht.hIS.path = mv(paramht.hIR.hDn);
      localObject2 = paramht.hIS;
      long l = paramht.hIR.hDn;
      localObject3 = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mK(l);
      if ((localObject3 == null) || (((g)localObject3).field_favProto == null)) {
        paramht = "";
      }
      for (;;)
      {
        label87:
        ((ht.b)localObject2).thumbPath = paramht;
        AppMethodBeat.o(103345);
        return;
        if ((((g)localObject3).field_type != 18) || (((g)localObject3).field_favProto.vEn.size() > 1))
        {
          paramht = ((g)localObject3).field_favProto.vEn.iterator();
          for (;;)
          {
            if (paramht.hasNext())
            {
              arf localarf = (arf)paramht.next();
              switch (localarf.dataType)
              {
              default: 
                break;
              case 2: 
                localObject1 = a(localarf);
                paramht = (ht)localObject1;
                if (com.tencent.mm.vfs.y.ZC((String)localObject1)) {
                  break label87;
                }
                paramht = d(localarf);
                if (com.tencent.mm.vfs.y.ZC(paramht))
                {
                  BitmapUtil.createThumbNail(paramht, 150, 150, Bitmap.CompressFormat.JPEG, 90, (String)localObject1, true);
                  paramht = a(localarf);
                  break label87;
                }
                if (localarf.ZyB)
                {
                  a((g)localObject3, localarf);
                  paramht = (ht)localObject1;
                  break label87;
                }
                if (localarf.ZyG)
                {
                  a((g)localObject3, localarf, true);
                  break label87;
                }
                paramht = "";
                break label87;
              }
            }
          }
        }
        paramht = "";
      }
    }
    if (paramht.hIR.hIY == 2)
    {
      localObject1 = new g();
      ((g)localObject1).field_type = 2;
      localObject2 = new arf();
      ((arf)localObject2).bsB(er(localObject2.toString(), 2));
      localObject3 = d((arf)localObject2);
      ((arf)localObject2).bsC((String)localObject3);
      ((arf)localObject2).axy(2);
      ((g)localObject1).field_favProto.vEn.add(localObject2);
      paramht.hIS.path = g.t((g)localObject1);
      paramht.hIS.thumbPath = ((String)localObject3);
      AppMethodBeat.o(103345);
      return;
    }
    if (paramht.hIR.hIY == 3)
    {
      localObject1 = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mK(paramht.hIR.hDn);
      if (localObject1 != null) {
        paramht.hIS.path = (z.bAM() + ";" + ((g)localObject1).field_fromUser + ";" + ((g)localObject1).field_updateTime);
      }
      AppMethodBeat.o(103345);
      return;
    }
    if (paramht.hIR.hIY == 4)
    {
      b(paramht);
      AppMethodBeat.o(103345);
      return;
    }
    if (paramht.hIR.hIY == 5)
    {
      a(paramht);
      AppMethodBeat.o(103345);
      return;
    }
    if (paramht.hIR.hIY == 6)
    {
      localObject1 = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mK(paramht.hIR.hDn);
      if (localObject1 == null)
      {
        paramht.hIS.ret = 0;
        AppMethodBeat.o(103345);
        return;
      }
      paramht = paramht.hIS;
      if (((g)localObject1).field_id > 0) {}
      for (;;)
      {
        paramht.ret = i;
        AppMethodBeat.o(103345);
        return;
        i = 0;
      }
    }
    Object localObject1 = new g();
    ((g)localObject1).field_type = 18;
    ((g)localObject1).field_favProto = paramht.hIR.hDt;
    paramht.hIS.path = g.t((g)localObject1);
    AppMethodBeat.o(103345);
  }
  
  public static void c(c paramc)
  {
    AppMethodBeat.i(103294);
    if (((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage() == null)
    {
      Log.e("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, getFavCdnStorage null");
      AppMethodBeat.o(103294);
      return;
    }
    int i = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().J(paramc.field_favLocalId, 1);
    Log.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, download data status:%d, favlocalId:%d", new Object[] { Integer.valueOf(i), Long.valueOf(paramc.field_favLocalId) });
    if (((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage() == null)
    {
      Log.e("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus getFavItemInfoStorage null");
      AppMethodBeat.o(103294);
      return;
    }
    g localg = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mK(paramc.field_favLocalId);
    if (localg == null)
    {
      Log.e("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus iteminfo null");
      AppMethodBeat.o(103294);
      return;
    }
    if ((localg.dQs()) || (localg.dQo()) || (localg.dQp()))
    {
      Log.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, status upload, skip. isWaitServerUpload:%b  isUploadding:%b  isUploadFailed:%b", new Object[] { Boolean.valueOf(localg.dQs()), Boolean.valueOf(localg.dQo()), Boolean.valueOf(localg.dQp()) });
      AppMethodBeat.o(103294);
      return;
    }
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(103294);
      return;
      h.mE(localg.field_localId);
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().ak(7, paramc.field_favLocalId);
      AppMethodBeat.o(103294);
      return;
      Log.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, error, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
      com.tencent.mm.plugin.report.service.h.OAn.b(10659, new Object[] { Integer.valueOf(1), Integer.valueOf(localg.field_type), Integer.valueOf(-5), Long.valueOf(b(localg)), Long.valueOf(h.mD(localg.field_localId)) });
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().ak(8, paramc.field_favLocalId);
      AppMethodBeat.o(103294);
      return;
      Log.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus init, favLocalId:%d, favId:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id) });
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().ak(10, paramc.field_favLocalId);
      AppMethodBeat.o(103294);
      return;
      Log.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus finish, favLocalId:%d, favId:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id) });
      com.tencent.mm.plugin.report.service.h.OAn.b(10659, new Object[] { Integer.valueOf(1), Integer.valueOf(localg.field_type), Integer.valueOf(0), Long.valueOf(b(localg)), Long.valueOf(h.mD(localg.field_localId)) });
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().ak(10, paramc.field_favLocalId);
      AppMethodBeat.o(103294);
      return;
      Log.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus pause, favLocalId:%d, favId:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id) });
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().ak(8, paramc.field_favLocalId);
    }
  }
  
  public static void c(String paramString, Context paramContext)
  {
    AppMethodBeat.i(103352);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.Fav.FavApiLogic", "share image to timeline fail, filePath is null");
      AppMethodBeat.o(103352);
      return;
    }
    Intent localIntent = new Intent();
    String str1 = "fav_" + z.bAM() + "_0";
    String str2 = ad.Jo(str1);
    ad.bCb().M(str2, true).q("prePublishId", str1);
    localIntent.putExtra("reportSessionId", str2);
    localIntent.putExtra("Ksnsupload_type", 0);
    localIntent.putExtra("sns_kemdia_path", paramString);
    com.tencent.mm.br.c.b(paramContext, "sns", ".ui.SnsUploadUI", localIntent);
    AppMethodBeat.o(103352);
  }
  
  public static String d(arf paramarf)
  {
    AppMethodBeat.i(103278);
    if (paramarf == null)
    {
      AppMethodBeat.o(103278);
      return "";
    }
    Object localObject2 = paramarf.hIQ;
    if ((Util.isNullOrNil((String)localObject2)) || (!com.tencent.mm.kernel.h.baz()))
    {
      AppMethodBeat.o(103278);
      return "";
    }
    u localu2 = atO((String)localObject2);
    int j = 0;
    int i = j;
    u localu1 = localu2;
    Object localObject1 = localObject2;
    if (paramarf.dataType == 8)
    {
      i = j;
      localu1 = localu2;
      localObject1 = localObject2;
      if (!Util.isNullOrNil(paramarf.title))
      {
        localObject1 = paramarf.title;
        localu1 = atO(paramarf.hIQ);
        i = 1;
      }
    }
    localObject2 = localObject1;
    if (paramarf.ZyU != null)
    {
      localObject2 = localObject1;
      if (paramarf.ZyU.trim().length() > 0)
      {
        localObject2 = localObject1;
        if (i == 0) {
          localObject2 = (String)localObject1 + "." + paramarf.ZyU;
        }
      }
    }
    localObject1 = new u(localu1, (String)localObject2);
    if ((((u)localObject1).jKS()) || (Util.isNullOrNil(paramarf.ZyW)))
    {
      paramarf = com.tencent.mm.vfs.ah.v(((u)localObject1).jKT());
      AppMethodBeat.o(103278);
      return paramarf;
    }
    localObject2 = com.tencent.mm.b.g.getMessageDigest((paramarf.ZyW + paramarf.hIQ).getBytes());
    if (Util.isNullOrNil((String)localObject2))
    {
      paramarf = com.tencent.mm.vfs.ah.v(((u)localObject1).jKT());
      AppMethodBeat.o(103278);
      return paramarf;
    }
    localObject1 = localObject2;
    if (paramarf.ZyU != null)
    {
      localObject1 = localObject2;
      if (paramarf.ZyU.trim().length() > 0) {
        localObject1 = (String)localObject2 + "." + paramarf.ZyU;
      }
    }
    localObject1 = new u(localu1, (String)localObject1);
    if (((u)localObject1).jKS())
    {
      paramarf = com.tencent.mm.vfs.ah.v(((u)localObject1).jKT());
      AppMethodBeat.o(103278);
      return paramarf;
    }
    localObject2 = paramarf.hIQ;
    localObject1 = localObject2;
    if (paramarf.ZyU != null)
    {
      localObject1 = localObject2;
      if (paramarf.ZyU.trim().length() > 0) {
        localObject1 = (String)localObject2 + "." + paramarf.ZyU;
      }
    }
    Log.d("MicroMsg.Fav.FavApiLogic", "use dataId.fmt, ".concat(String.valueOf(localObject1)));
    paramarf = com.tencent.mm.vfs.ah.v(new u(localu1, (String)localObject1).jKT());
    AppMethodBeat.o(103278);
    return paramarf;
  }
  
  public static void d(g paramg)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(103269);
        if ((paramg == null) || (paramg.field_type != 18))
        {
          AppMethodBeat.o(103269);
          return;
        }
        if (!Acd.containsKey(Long.valueOf(paramg.field_localId)))
        {
          AppMethodBeat.o(103269);
          continue;
        }
        if (Acd.get(Long.valueOf(paramg.field_localId)) == null) {
          break label101;
        }
      }
      finally {}
      if (((ArrayList)Acd.get(Long.valueOf(paramg.field_localId))).size() == 0)
      {
        label101:
        AppMethodBeat.o(103269);
      }
      else
      {
        String str = mv(paramg.field_localId);
        Log.i("MicroMsg.Fav.FavApiLogic", "checkUpdateSnsNotePostXml, resend favlocal id:%d,xml:%s", new Object[] { Long.valueOf(paramg.field_localId), str });
        vc localvc = new vc();
        localvc.hYR.hYS = ((ArrayList)Acd.get(Long.valueOf(paramg.field_localId)));
        localvc.hYR.hYT = str;
        localvc.publish();
        Acd.remove(Long.valueOf(paramg.field_localId));
        AppMethodBeat.o(103269);
      }
    }
  }
  
  public static void d(String paramString, Context paramContext)
  {
    AppMethodBeat.i(103354);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.Fav.FavApiLogic", "shareTextToFriend content null");
      AppMethodBeat.o(103354);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Retr_Msg_content", paramString);
    localIntent.putExtra("Retr_Msg_Type", 4);
    localIntent.putExtra("mutil_select_is_ret", true);
    com.tencent.mm.br.c.g(paramContext, ".ui.transmit.MsgRetransmitUI", localIntent);
    AppMethodBeat.o(103354);
  }
  
  private static Set<String> dPV()
  {
    AppMethodBeat.i(103273);
    Object localObject = (String)com.tencent.mm.kernel.h.baE().ban().d(225282, "");
    Log.i("MicroMsg.Fav.FavApiLogic", "get need del IDs: %s", new Object[] { localObject });
    HashSet localHashSet = new HashSet();
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(103273);
      return localHashSet;
    }
    localObject = ((String)localObject).split(",");
    if ((localObject == null) || (localObject.length == 0))
    {
      AppMethodBeat.o(103273);
      return localHashSet;
    }
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localHashSet.add(localObject[i]);
      i += 1;
    }
    AppMethodBeat.o(103273);
    return localHashSet;
  }
  
  public static String dPW()
  {
    AppMethodBeat.i(103277);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.h.baF();
    localObject = com.tencent.mm.kernel.h.baE().mCJ + "favorite/web/";
    AppMethodBeat.o(103277);
    return localObject;
  }
  
  public static void dPX()
  {
    AppMethodBeat.i(103281);
    Object localObject2 = dPV();
    if ((localObject2 == null) || (((Set)localObject2).size() == 0))
    {
      Log.v("MicroMsg.Fav.FavApiLogic", "doBatchDel no item to delete");
      AppMethodBeat.o(103281);
      return;
    }
    Log.i("MicroMsg.Fav.FavApiLogic", "doBatchDel idList:%s", new Object[] { localObject2.toString() });
    Object localObject1 = new LinkedList();
    localObject2 = ((Set)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      try
      {
        ((LinkedList)localObject1).add(Integer.valueOf(Util.getInt(str, 0)));
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.Fav.FavApiLogic", localException, "", new Object[0]);
        Log.e("MicroMsg.Fav.FavApiLogic", "doBatchDel parseInt error:%s", new Object[] { localException.getMessage() });
      }
    }
    Log.i("MicroMsg.Fav.FavApiLogic", "doBatchDel after parse, total size %d", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()) });
    if (((LinkedList)localObject1).size() > 0)
    {
      localObject1 = new aj((LinkedList)localObject1);
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject1, 0);
    }
    AppMethodBeat.o(103281);
  }
  
  public static long dPY()
  {
    AppMethodBeat.i(103300);
    long l2 = dPZ() - dQa();
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 1024L;
    }
    AppMethodBeat.o(103300);
    return l1;
  }
  
  public static long dPZ()
  {
    AppMethodBeat.i(103301);
    long l = ((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acKX, Long.valueOf(0L))).longValue();
    AppMethodBeat.o(103301);
    return l;
  }
  
  public static long dQa()
  {
    AppMethodBeat.i(103302);
    long l = ((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acKW, Long.valueOf(0L))).longValue();
    AppMethodBeat.o(103302);
    return l;
  }
  
  public static boolean dQb()
  {
    AppMethodBeat.i(103311);
    if (dPZ() == 0L)
    {
      AppMethodBeat.o(103311);
      return false;
    }
    if (dPY() < 52428800L)
    {
      AppMethodBeat.o(103311);
      return true;
    }
    AppMethodBeat.o(103311);
    return false;
  }
  
  public static String dQc()
  {
    AppMethodBeat.i(103317);
    String str = com.tencent.mm.kernel.h.baE().mCJ + "favorite/music/";
    AppMethodBeat.o(103317);
    return str;
  }
  
  public static String dQd()
  {
    AppMethodBeat.i(103320);
    String str = com.tencent.mm.kernel.h.baE().mCJ + "favorite/";
    AppMethodBeat.o(103320);
    return str;
  }
  
  public static String dQe()
  {
    AppMethodBeat.i(103321);
    String str = com.tencent.mm.kernel.h.baE().mCJ + "favorite/voice/";
    AppMethodBeat.o(103321);
    return str;
  }
  
  public static boolean dQf()
  {
    AppMethodBeat.i(103328);
    if (ak.dQU() > 0)
    {
      AppMethodBeat.o(103328);
      return true;
    }
    AppMethodBeat.o(103328);
    return false;
  }
  
  public static boolean dQg()
  {
    AppMethodBeat.i(103337);
    if (dPZ() == 0L)
    {
      AppMethodBeat.o(103337);
      return false;
    }
    if (dPY() < 10485760L)
    {
      AppMethodBeat.o(103337);
      return true;
    }
    AppMethodBeat.o(103337);
    return false;
  }
  
  public static boolean dQh()
  {
    AppMethodBeat.i(168688);
    if ((((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yXy, 0) != 1) && (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yZS, 0) == 1))
    {
      AppMethodBeat.o(168688);
      return true;
    }
    AppMethodBeat.o(168688);
    return false;
  }
  
  public static void e(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(103340);
    g localg = atW(paramString1);
    if (localg == null)
    {
      AppMethodBeat.o(103340);
      return;
    }
    ql localql = new ql();
    localql.hTy.type = 2;
    localql.hTy.field_localId = -1L;
    localql.hTy.context = paramContext;
    localql.hTy.hTG = 4;
    localql.hTy.hTH = true;
    paramContext = new Bundle();
    paramContext.putString("noteauthor", localg.field_favProto.YzK.ZBm);
    paramContext.putString("noteeditor", localg.field_favProto.YzK.ZBn);
    paramContext.putLong("edittime", localg.field_favProto.ygh);
    paramContext.putString("notexml", g.t(localg));
    paramContext.putString("snslocalid", paramString2);
    paramContext.putString("snsthumbpath", paramString3);
    paramContext.putString("snsnotelinkxml", paramString1);
    localql.hTy.hTF = paramContext;
    localql.hTy.field_favProto = localg.field_favProto;
    localql.publish();
    AppMethodBeat.o(103340);
  }
  
  public static void e(arf paramarf)
  {
    AppMethodBeat.i(103309);
    c localc = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().aui(paramarf.hIQ);
    if ((localc != null) && (localc.field_status != 3))
    {
      localc.field_status = 2;
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnService().pauseDownload(paramarf.hIQ);
    }
    localc = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().aui(atP(paramarf.hIQ));
    if ((localc != null) && (localc.field_status != 3))
    {
      localc.field_status = 2;
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnService().pauseDownload(atP(paramarf.hIQ));
    }
    AppMethodBeat.o(103309);
  }
  
  private static boolean e(g paramg)
  {
    AppMethodBeat.i(103270);
    if (paramg == null)
    {
      AppMethodBeat.o(103270);
      return false;
    }
    paramg = paramg.field_favProto.vEn.iterator();
    arf localarf;
    do
    {
      if (!paramg.hasNext()) {
        break;
      }
      localarf = (arf)paramg.next();
    } while (((localarf.dataType != 8) && (localarf.dataType != 4) && (localarf.dataType != 2) && (localarf.dataType != 3)) || ((!Util.isNullOrNil(localarf.Ysw)) && (!Util.isNullOrNil(localarf.ZyH))));
    for (boolean bool = false;; bool = true)
    {
      AppMethodBeat.o(103270);
      return bool;
    }
  }
  
  public static String er(String paramString, int paramInt)
  {
    AppMethodBeat.i(103260);
    paramString = com.tencent.mm.b.g.getMessageDigest((paramString + paramInt + System.currentTimeMillis()).getBytes());
    AppMethodBeat.o(103260);
    return paramString;
  }
  
  public static boolean f(g paramg)
  {
    AppMethodBeat.i(103280);
    if (paramg.field_favProto == null)
    {
      AppMethodBeat.o(103280);
      return false;
    }
    paramg = paramg.field_favProto.vEn.iterator();
    while (paramg.hasNext())
    {
      arf localarf = (arf)paramg.next();
      if (localarf.ZzM == 2)
      {
        AppMethodBeat.o(103280);
        return true;
      }
      if (localarf.ZzM == 1)
      {
        AppMethodBeat.o(103280);
        return true;
      }
    }
    AppMethodBeat.o(103280);
    return false;
  }
  
  public static boolean f(arf paramarf)
  {
    AppMethodBeat.i(103316);
    com.tencent.mm.aw.f localf = com.tencent.mm.aw.a.bLn();
    if ((localf != null) && (localf.oOt == 6) && (Util.nullAs(paramarf.hIQ, "").equals(localf.oOv)) && (com.tencent.mm.aw.a.bLk()))
    {
      AppMethodBeat.o(103316);
      return true;
    }
    AppMethodBeat.o(103316);
    return false;
  }
  
  public static void fD(List<Integer> paramList)
  {
    AppMethodBeat.i(103271);
    if (paramList.size() == 0)
    {
      Log.e("MicroMsg.Fav.FavApiLogic", "setDeleted list null");
      AppMethodBeat.o(103271);
      return;
    }
    Set localSet = dPV();
    Log.i("MicroMsg.Fav.FavApiLogic", "setDeleted before del:%s", new Object[] { localSet.toString() });
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Integer localInteger = (Integer)paramList.next();
      Log.i("MicroMsg.Fav.FavApiLogic", "setDeleted id:%d, ret:%b", new Object[] { localInteger, Boolean.valueOf(localSet.remove(localInteger.toString())) });
    }
    Log.i("MicroMsg.Fav.FavApiLogic", "setDeleted after del:%s", new Object[] { localSet.toString() });
    p(localSet);
    AppMethodBeat.o(103271);
  }
  
  public static boolean fE(List<g> paramList)
  {
    AppMethodBeat.i(103285);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      Log.w("MicroMsg.Fav.FavApiLogic", "delete fav item fail, item is null");
      AppMethodBeat.o(103285);
      return false;
    }
    Set localSet = dPV();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      g localg = (g)paramList.next();
      h(localg);
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavSearchStorage().mM(localg.field_localId);
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().A(localg);
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().mI(localg.field_localId);
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavTagSetMgr().w(localg);
      localSet.add(localg.field_id);
      Log.d("MicroMsg.Fav.FavApiLogic", "delete id %d", new Object[] { Integer.valueOf(localg.field_id) });
    }
    p(localSet);
    dPX();
    AppMethodBeat.o(103285);
    return true;
  }
  
  public static boolean g(g paramg)
  {
    if (paramg == null) {}
    while ((paramg.field_itemStatus != 8) && (paramg.field_itemStatus != 10) && (paramg.field_itemStatus != 7)) {
      return false;
    }
    return true;
  }
  
  public static boolean g(arf paramarf)
  {
    AppMethodBeat.i(103326);
    boolean bool = new u(d(paramarf)).jKS();
    AppMethodBeat.o(103326);
    return bool;
  }
  
  public static String getAppName(Context paramContext, String paramString)
  {
    AppMethodBeat.i(103318);
    am.b localb = am.a.okN;
    if (localb != null)
    {
      paramContext = localb.x(paramContext, paramString);
      AppMethodBeat.o(103318);
      return paramContext;
    }
    AppMethodBeat.o(103318);
    return "";
  }
  
  public static String getLengthStr(float paramFloat)
  {
    AppMethodBeat.i(103315);
    if (paramFloat < 1024.0F)
    {
      str = String.format("%.1fB", new Object[] { Float.valueOf(paramFloat) });
      AppMethodBeat.o(103315);
      return str;
    }
    if (paramFloat < 1048576.0F)
    {
      str = String.format("%.1fKB", new Object[] { Float.valueOf(paramFloat / 1024.0F) });
      AppMethodBeat.o(103315);
      return str;
    }
    if (paramFloat < 1.073742E+009F)
    {
      str = String.format("%.1fMB", new Object[] { Float.valueOf(paramFloat / 1024.0F / 1024.0F) });
      AppMethodBeat.o(103315);
      return str;
    }
    String str = String.format("%.1fGB", new Object[] { Float.valueOf(paramFloat / 1024.0F / 1024.0F / 1024.0F) });
    AppMethodBeat.o(103315);
    return str;
  }
  
  public static void gk(Context paramContext)
  {
    AppMethodBeat.i(274387);
    if (0L >= Ace)
    {
      Log.i("MicroMsg.Fav.FavApiLogic", "addTagWhenAddToFav,try to add tag ,but favLocalId is null, return");
      AppMethodBeat.o(274387);
      return;
    }
    g localg = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mK(Ace);
    Ace = 0L;
    if (localg == null)
    {
      Log.i("MicroMsg.Fav.FavApiLogic", "addTagWhenAddToFav,try to add tag ,but iteminfo is null, return");
      AppMethodBeat.o(274387);
      return;
    }
    Log.i("MicroMsg.Fav.FavApiLogic", "addTagWhenAddToFav ,go on");
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = MMApplicationContext.getContext();
    }
    paramContext = new Intent();
    paramContext.putExtra("key_fav_scene", 5);
    paramContext.putExtra("key_fav_item_id", localg.field_localId);
    a(localContext, ".ui.FavTagEditUI", paramContext, null);
    AppMethodBeat.o(274387);
  }
  
  private static void h(g paramg)
  {
    AppMethodBeat.i(103282);
    Set localSet = aq.Aec;
    paramg = paramg.field_favProto.vEn;
    int i = 0;
    while (i < paramg.size())
    {
      Object localObject = a((arf)paramg.get(i));
      if ((localSet == null) || (!localSet.contains(localObject))) {
        com.tencent.mm.vfs.y.deleteFile((String)localObject);
      }
      localObject = d((arf)paramg.get(i));
      if ((localSet == null) || (!localSet.contains(localObject))) {
        com.tencent.mm.vfs.y.deleteFile((String)localObject);
      }
      localObject = (arf)paramg.get(i);
      if ((((arf)localObject).Zzy != null) && (((arf)localObject).Zzy.ZAz != null)) {
        ab.Qn(((arf)localObject).hIQ);
      }
      i += 1;
    }
    AppMethodBeat.o(103282);
  }
  
  public static boolean h(arf paramarf)
  {
    AppMethodBeat.i(103327);
    boolean bool = ImgUtil.isGif(d(paramarf));
    AppMethodBeat.o(103327);
    return bool;
  }
  
  private static String hB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(103259);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(103259);
      return paramString2;
    }
    if (Util.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(103259);
      return paramString1;
    }
    paramString1 = paramString1 + "​" + paramString2;
    AppMethodBeat.o(103259);
    return paramString1;
  }
  
  private static void i(g paramg)
  {
    AppMethodBeat.i(103288);
    if (paramg == null)
    {
      AppMethodBeat.o(103288);
      return;
    }
    if (5 == paramg.field_type)
    {
      String str1 = "";
      if (paramg.field_favProto.ZAj != null) {
        str1 = paramg.field_favProto.ZAj.ZBV;
      }
      String str2 = str1;
      if (paramg.field_favProto.ZBt != null)
      {
        str2 = str1;
        if (Util.isNullOrNil(str1)) {
          str2 = paramg.field_favProto.ZBt.link;
        }
      }
      paramg = new hn();
      paramg.hIv.url = str2;
      paramg.publish();
    }
    AppMethodBeat.o(103288);
  }
  
  public static void j(g paramg)
  {
    AppMethodBeat.i(103290);
    j localj = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavSearchStorage().mN(paramg.field_localId);
    if (localj == null)
    {
      localj = new j();
      localj.field_localId = paramg.field_localId;
    }
    for (int i = 1;; i = 0)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      if (paramg.field_favProto.title != null) {
        localStringBuffer.append(paramg.field_favProto.title);
      }
      if (paramg.field_favProto.desc != null) {
        localStringBuffer.append(paramg.field_favProto.desc);
      }
      Object localObject2;
      if (paramg.field_favProto.ZBt != null)
      {
        localObject1 = paramg.field_favProto.ZBt;
        if (!Util.isNullOrNil(((asb)localObject1).hQQ))
        {
          localStringBuffer.append(((asb)localObject1).hQQ);
          localObject2 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(((asb)localObject1).hQQ);
          if (localObject2 != null) {
            localStringBuffer.append(((az)localObject2).field_nickname).append(((az)localObject2).field_conRemark);
          }
          localObject2 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(((asb)localObject1).toUser);
          if (localObject2 != null) {
            localStringBuffer.append(((az)localObject2).field_nickname).append(((az)localObject2).field_conRemark);
          }
          localStringBuffer.append(((asb)localObject1).ZAT);
        }
      }
      Object localObject1 = paramg.field_favProto.vEn;
      localj.field_subtype = 0;
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (arf)((Iterator)localObject1).next();
        if (((arf)localObject2).desc != null) {
          localStringBuffer.append(((arf)localObject2).desc);
        }
        if (((arf)localObject2).title != null) {
          localStringBuffer.append(((arf)localObject2).title);
        }
        int j = ((arf)localObject2).dataType;
        int k = localj.field_subtype;
        localj.field_subtype = (j.MC(j) | k);
      }
      if (paramg.field_favProto.ZAj != null)
      {
        if (paramg.field_favProto.ZAj.desc != null) {
          localStringBuffer.append(paramg.field_favProto.ZAj.desc);
        }
        if (paramg.field_favProto.ZAj.title != null) {
          localStringBuffer.append(paramg.field_favProto.ZAj.title);
        }
      }
      if (paramg.field_favProto.ZAl != null)
      {
        if (paramg.field_favProto.ZAl.desc != null) {
          localStringBuffer.append(paramg.field_favProto.ZAl.desc);
        }
        if (paramg.field_favProto.ZAl.title != null) {
          localStringBuffer.append(paramg.field_favProto.ZAl.title);
        }
      }
      if (paramg.field_favProto.ZAB != null)
      {
        if (paramg.field_favProto.ZAB.nickname != null)
        {
          localObject2 = paramg.field_favProto.ZAB.nickname;
          localObject1 = localObject2;
          if (paramg.field_favProto.ZAB.mIK != null)
          {
            localObject1 = localObject2;
            if (!paramg.field_favProto.ZAB.mIK.isEmpty()) {
              localObject1 = paramg.field_favProto.ZAB.mIK;
            }
          }
          localStringBuffer.append((String)localObject1);
        }
        if (paramg.field_favProto.ZAB.desc != null) {
          localStringBuffer.append(paramg.field_favProto.ZAB.desc);
        }
      }
      localj.field_tagContent = "";
      localObject1 = paramg.field_tagProto.ZBG.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localj.field_tagContent = (localj.field_tagContent + " " + (String)localObject2);
        localStringBuffer.append((String)localObject2);
      }
      localObject1 = paramg.field_tagProto.ZBH.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localj.field_tagContent = (localj.field_tagContent + " " + (String)localObject2);
        localStringBuffer.append((String)localObject2);
        ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavTagSetMgr().auc((String)localObject2);
      }
      localj.field_content = localStringBuffer.toString();
      localj.field_time = paramg.field_updateTime;
      localj.field_type = paramg.field_type;
      if (i != 0)
      {
        ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavSearchStorage().a(localj);
        AppMethodBeat.o(103290);
        return;
      }
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavSearchStorage().a(localj, new String[] { "localId" });
      AppMethodBeat.o(103290);
      return;
    }
  }
  
  public static float jh(long paramLong)
  {
    float f2 = 60.0F;
    float f1 = 1.0F;
    AppMethodBeat.i(103312);
    float f3 = (float)paramLong / 1000.0F;
    if (f3 < 1.0F) {}
    for (;;)
    {
      if (f1 > 60.0F) {
        f1 = f2;
      }
      for (;;)
      {
        f1 = Math.round(f1);
        AppMethodBeat.o(103312);
        return f1;
      }
      f1 = f3;
    }
  }
  
  public static boolean k(g paramg)
  {
    AppMethodBeat.i(103298);
    if (((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mK(paramg.field_localId) != null)
    {
      AppMethodBeat.o(103298);
      return true;
    }
    AppMethodBeat.o(103298);
    return false;
  }
  
  public static void l(g paramg)
  {
    AppMethodBeat.i(103305);
    if (!paramg.dQp())
    {
      Log.f("MicroMsg.Fav.FavApiLogic", "restartItemUpload status not upload failed!");
      AppMethodBeat.o(103305);
      return;
    }
    Object localObject;
    if ((paramg != null) && (!Util.isNullOrNil(g.t(paramg))))
    {
      localObject = g.t(paramg);
      Log.i("MicroMsg.Fav.FavApiLogic", "restartItemUpload, force:%b, itemStatus:%d, item_xml:%s", new Object[] { Boolean.TRUE, Integer.valueOf(paramg.field_itemStatus), localObject });
      switch (paramg.field_itemStatus)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(103305);
      return;
      localObject = "";
      break;
      paramg.field_itemStatus = 1;
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getCheckCdnService().run();
      AppMethodBeat.o(103305);
      return;
      localObject = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().mF(paramg.field_localId);
      if ((localObject == null) || (((List)localObject).size() == 0))
      {
        paramg.field_itemStatus = 9;
        ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
        paramg = new ai(paramg);
        com.tencent.mm.kernel.h.aZW().a(paramg, 0);
        AppMethodBeat.o(103305);
        return;
      }
      paramg.field_itemStatus = 4;
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().y(paramg);
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
      localObject = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().mF(paramg.field_localId).iterator();
      c localc;
      Iterator localIterator;
      arf localarf;
      String str1;
      String str2;
      while (((Iterator)localObject).hasNext())
      {
        localc = (c)((Iterator)localObject).next();
        Log.i("MicroMsg.Fav.FavApiLogic", "force upload favItem[last failed], favid:%d localId:%d, dataId:%s, dataType:%d totalLength %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), localc.field_dataId, Integer.valueOf(localc.field_dataType), Integer.valueOf(localc.field_totalLen) });
        if (!com.tencent.mm.vfs.y.ZC(localc.field_path))
        {
          Log.i("MicroMsg.Fav.FavApiLogic", "cdnInfo.field_path (%s) not exists, exportPath:%s", new Object[] { localc.field_path, com.tencent.mm.vfs.y.n(localc.field_path, false) });
          if ((paramg.field_favProto != null) && (paramg.field_favProto.vEn != null))
          {
            localIterator = paramg.field_favProto.vEn.iterator();
            while (localIterator.hasNext())
            {
              localarf = (arf)localIterator.next();
              str1 = d(localarf);
              str2 = com.tencent.mm.vfs.y.n(str1, false);
              Log.i("MicroMsg.Fav.FavApiLogic", "toPath:%s, trueDataPath:%s", new Object[] { str1, str2 });
              if ((str1.equals(localc.field_path)) || (str2.equals(localc.field_path))) {
                Log.i("MicroMsg.Fav.FavApiLogic", "copy ret:%s", new Object[] { Long.valueOf(com.tencent.mm.vfs.y.O(localarf.Zzd, localc.field_path, false)) });
              }
            }
          }
        }
        ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnService().aug(localc.field_dataId);
      }
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnService().run();
      AppMethodBeat.o(103305);
      return;
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().ak(12, paramg.field_localId);
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getSendService().run();
      AppMethodBeat.o(103305);
      return;
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().ak(15, paramg.field_localId);
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().y(paramg);
      localObject = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().mF(paramg.field_localId).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localc = (c)((Iterator)localObject).next();
        Log.i("MicroMsg.Fav.FavApiLogic", "force upload favItem[last mod failed], favid:%d localId:%d, dataId:%s, dataType:%d totalLength %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), localc.field_dataId, Integer.valueOf(localc.field_dataType), Integer.valueOf(localc.field_totalLen) });
        if (!com.tencent.mm.vfs.y.ZC(localc.field_path))
        {
          Log.i("MicroMsg.Fav.FavApiLogic", "cdnInfo.field_path (%s) not exists, exportPath:%s", new Object[] { localc.field_path, com.tencent.mm.vfs.y.n(localc.field_path, false) });
          if ((paramg.field_favProto != null) && (paramg.field_favProto.vEn != null))
          {
            localIterator = paramg.field_favProto.vEn.iterator();
            while (localIterator.hasNext())
            {
              localarf = (arf)localIterator.next();
              str1 = d(localarf);
              str2 = com.tencent.mm.vfs.y.n(str1, false);
              Log.i("MicroMsg.Fav.FavApiLogic", "toPath:%s, trueDataPath:%s", new Object[] { str1, str2 });
              if ((str1.equals(localc.field_path)) || (str2.equals(localc.field_path))) {
                Log.i("MicroMsg.Fav.FavApiLogic", "copy ret:%s", new Object[] { Long.valueOf(com.tencent.mm.vfs.y.O(localarf.Zzd, localc.field_path, false)) });
              }
            }
          }
        }
        ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnService().aug(localc.field_dataId);
      }
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnService().run();
      AppMethodBeat.o(103305);
      return;
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().ak(17, paramg.field_localId);
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getModService().run();
      AppMethodBeat.o(103305);
      return;
      paramg.field_itemStatus = 9;
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getSendService().run();
    }
  }
  
  public static void m(g paramg)
  {
    AppMethodBeat.i(103306);
    if (paramg == null)
    {
      AppMethodBeat.o(103306);
      return;
    }
    if ((paramg.field_itemStatus == 8) || (paramg.field_itemStatus == 10))
    {
      paramg.field_itemStatus = 7;
      Object localObject = paramg.field_favProto.vEn;
      if (((List)localObject).size() == 0)
      {
        AppMethodBeat.o(103306);
        return;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        arf localarf = (arf)((Iterator)localObject).next();
        a(paramg, localarf, true);
        a(paramg, localarf);
      }
      AppMethodBeat.o(103306);
      return;
    }
    Log.e("MicroMsg.Fav.FavApiLogic", "status not download failed or done!");
    AppMethodBeat.o(103306);
  }
  
  public static float mA(long paramLong)
  {
    float f1 = 1.0F;
    AppMethodBeat.i(103313);
    float f2 = (float)paramLong / 1000.0F;
    if (f2 < 1.0F) {}
    for (;;)
    {
      f1 = Math.round(f1);
      AppMethodBeat.o(103313);
      return f1;
      f1 = f2;
    }
  }
  
  public static String mB(long paramLong)
  {
    AppMethodBeat.i(103314);
    if (paramLong == 0L)
    {
      AppMethodBeat.o(103314);
      return "0KB";
    }
    String str;
    if (paramLong * 1.0D / 1048576.0D >= 1.0D)
    {
      str = String.format("%dMB", new Object[] { Integer.valueOf((int)(paramLong * 1.0D / 1048576.0D)) });
      AppMethodBeat.o(103314);
      return str;
    }
    if (paramLong * 1.0D / 1024.0D >= 1.0D)
    {
      str = String.format("%dKB", new Object[] { Integer.valueOf((int)(paramLong * 1.0D / 1024.0D)) });
      AppMethodBeat.o(103314);
      return str;
    }
    AppMethodBeat.o(103314);
    return "1KB";
  }
  
  public static void mt(long paramLong)
  {
    AppMethodBeat.i(103265);
    Log.i("MicroMsg.Fav.FavApiLogic", "setUsedCapacity:%d", new Object[] { Long.valueOf(paramLong) });
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acKW, Long.valueOf(paramLong));
    AppMethodBeat.o(103265);
  }
  
  public static void mu(long paramLong)
  {
    AppMethodBeat.i(103266);
    Log.i("MicroMsg.Fav.FavApiLogic", "setTotalCapacity:%d", new Object[] { Long.valueOf(paramLong) });
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acKX, Long.valueOf(paramLong));
    AppMethodBeat.o(103266);
  }
  
  private static String mv(long paramLong)
  {
    AppMethodBeat.i(103267);
    StringBuilder localStringBuilder = new StringBuilder();
    g localg = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mK(paramLong);
    if ((localg == null) || (localg.field_favProto == null) || (localg.field_favProto.vEn.size() <= 1))
    {
      AppMethodBeat.o(103267);
      return "";
    }
    arp localarp = localg.field_favProto.YzK;
    String str2 = "";
    String str1 = "";
    if (localarp != null)
    {
      str2 = localarp.ZBn;
      str1 = localarp.ZBm;
    }
    localStringBuilder.append("<noteinfo>");
    localStringBuilder.append("<noteauthor>").append(str1).append("</noteauthor>");
    localStringBuilder.append("<noteeditor>").append(str2).append("</noteeditor>");
    localStringBuilder.append("<edittime>").append(localg.field_favProto.ygh).append("</edittime>");
    localStringBuilder.append("<editusr>").append(str1).append("</editusr>");
    localStringBuilder.append("<favlocalid>").append(localg.field_localId).append("</favlocalid>");
    localStringBuilder.append(com.tencent.mm.plugin.fav.a.a.a.fF(localg.field_favProto.vEn).replace("cdn_dataurl", "cdndataurl").replace("cdn_datakey", "cdndatakey").replace("cdn_thumburl", "cdnthumburl").replace("cdn_thumbkey", "cdnthumbkey").replace("thumbfullsize", "thumbsize").replace("fullsize", "datasize").replace("datasrcname", "sourcename").replace("datasrctime", "sourcetime").replace("stream_lowbandurl", "streamlowbandurl").replace("stream_dataurl", "streamdataurl").replace("stream_weburl", "streamweburl"));
    localStringBuilder.append("</noteinfo>");
    str1 = localStringBuilder.toString();
    AppMethodBeat.o(103267);
    return str1;
  }
  
  public static void mw(long paramLong)
  {
    AppMethodBeat.i(103274);
    MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putLong("fav_mx_auto_download_size", paramLong).commit();
    AppMethodBeat.o(103274);
  }
  
  public static void mx(long paramLong)
  {
    AppMethodBeat.i(103275);
    MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putLong("fav_mx_auto_upload_size", paramLong).commit();
    AppMethodBeat.o(103275);
  }
  
  public static void my(long paramLong)
  {
    AppMethodBeat.i(103276);
    MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putLong("fav_mx_file_size", paramLong).commit();
    AppMethodBeat.o(103276);
  }
  
  public static void mz(long paramLong)
  {
    Ace = paramLong;
  }
  
  public static void n(g paramg)
  {
    AppMethodBeat.i(103310);
    if (!paramg.dQo())
    {
      Log.e("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, not uploading");
      AppMethodBeat.o(103310);
      return;
    }
    Log.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, itemStatu:%d", new Object[] { Integer.valueOf(paramg.field_itemStatus) });
    Iterator localIterator = paramg.field_favProto.vEn.iterator();
    while (localIterator.hasNext())
    {
      arf localarf = (arf)localIterator.next();
      c localc = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().aui(localarf.hIQ);
      if ((localc != null) && (localc.field_status != 3))
      {
        localc.field_status = 2;
        ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
        ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnService().auh(localarf.hIQ);
      }
      localc = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().aui(atP(localarf.hIQ));
      if ((localc != null) && (localc.field_status != 3))
      {
        localc.field_status = 2;
        ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
        ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnService().auh(atP(localarf.hIQ));
      }
    }
    paramg = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mK(paramg.field_localId);
    Log.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, after pause data itemStatu:%d", new Object[] { Integer.valueOf(paramg.field_itemStatus) });
    switch (paramg.field_itemStatus)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(103310);
      return;
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().ak(3, paramg.field_localId);
      Log.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(3) });
      AppMethodBeat.o(103310);
      return;
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().ak(6, paramg.field_localId);
      Log.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(6) });
      AppMethodBeat.o(103310);
      return;
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().ak(11, paramg.field_localId);
      Log.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(11) });
      AppMethodBeat.o(103310);
      return;
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().ak(14, paramg.field_localId);
      Log.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(14) });
      AppMethodBeat.o(103310);
      return;
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().ak(16, paramg.field_localId);
      Log.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(16) });
      AppMethodBeat.o(103310);
      return;
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().ak(18, paramg.field_localId);
      Log.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(18) });
    }
  }
  
  public static boolean o(g paramg)
  {
    AppMethodBeat.i(103319);
    if (paramg == null)
    {
      AppMethodBeat.o(103319);
      return false;
    }
    arf localarf = c(paramg);
    if (localarf == null)
    {
      AppMethodBeat.o(103319);
      return false;
    }
    long l = Util.currentTicks();
    com.tencent.mm.plugin.sight.base.b localb = com.tencent.mm.plugin.sight.base.f.aVX(d(localarf));
    int j;
    int i;
    boolean bool;
    if (localb != null)
    {
      j = localb.getVideoDuration();
      i = localarf.duration;
      if ((i <= 0) || (Math.abs(i - j) >= 2))
      {
        localarf.axx(j);
        bool = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.Fav.FavApiLogic", "repair video duration[%d TO %d] %b cost time %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool), Long.valueOf(Util.ticksToNow(l)) });
      AppMethodBeat.o(103319);
      return bool;
      bool = false;
      continue;
      bool = false;
      i = 0;
      j = 0;
    }
  }
  
  public static void p(g paramg)
  {
    AppMethodBeat.i(103332);
    j localj = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavSearchStorage().mN(paramg.field_localId);
    if (localj == null)
    {
      localj = new j();
      localj.field_localId = paramg.field_localId;
    }
    for (int i = 1;; i = 0)
    {
      localj.field_tagContent = "";
      Iterator localIterator = paramg.field_tagProto.ZBG.iterator();
      String str;
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        localj.field_tagContent = (localj.field_tagContent + " " + str);
      }
      localIterator = paramg.field_tagProto.ZBH.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        localj.field_tagContent = (localj.field_tagContent + " " + str);
        ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavTagSetMgr().auc(str);
      }
      localj.field_time = paramg.field_updateTime;
      localj.field_type = paramg.field_type;
      if (i != 0)
      {
        ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavSearchStorage().a(localj);
        AppMethodBeat.o(103332);
        return;
      }
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavSearchStorage().a(localj, new String[] { "localId" });
      AppMethodBeat.o(103332);
      return;
    }
  }
  
  private static void p(Set<String> paramSet)
  {
    AppMethodBeat.i(103272);
    StringBuffer localStringBuffer = new StringBuffer();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      localStringBuffer.append((String)paramSet.next()).append(",");
    }
    paramSet = "";
    if (localStringBuffer.length() > 0) {
      paramSet = localStringBuffer.substring(0, localStringBuffer.length() - 1);
    }
    Log.i("MicroMsg.Fav.FavApiLogic", "set need del IDs: %s", new Object[] { paramSet });
    com.tencent.mm.kernel.h.baE().ban().B(225282, paramSet);
    AppMethodBeat.o(103272);
  }
  
  public static void q(g paramg)
  {
    AppMethodBeat.i(103344);
    if (paramg == null)
    {
      AppMethodBeat.o(103344);
      return;
    }
    arp localarp = paramg.field_favProto.YzK;
    if ((localarp != null) && (!Util.isNullOrNil(localarp.ZBn)))
    {
      AppMethodBeat.o(103344);
      return;
    }
    if (paramg.field_type == 18)
    {
      if (paramg.field_favProto.ZBt.sourceType != 6) {
        break label112;
      }
      b(paramg, false);
    }
    for (;;)
    {
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
      AppMethodBeat.o(103344);
      return;
      label112:
      b(paramg, true);
    }
  }
  
  public static final String r(g paramg)
  {
    AppMethodBeat.i(103357);
    StringBuffer localStringBuffer = new StringBuffer();
    long l;
    label156:
    Object localObject;
    switch (paramg.field_type)
    {
    case -2: 
    case -1: 
    case 0: 
    case 6: 
    case 7: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 15: 
    case 17: 
    case 19: 
    case 20: 
    case 21: 
    default: 
      paramg = localStringBuffer.toString();
      AppMethodBeat.o(103357);
      return paramg;
    case 2: 
    case 8: 
      paramg = paramg.field_favProto.vEn.iterator();
      l = 0L;
      if (paramg.hasNext())
      {
        localObject = (arf)paramg.next();
        if (localObject == null) {
          break label467;
        }
        l = ((arf)localObject).Zza + l;
      }
      break;
    }
    label464:
    label467:
    for (;;)
    {
      for (;;)
      {
        break label156;
        localStringBuffer.append(l);
        break;
        if (Util.isNullOrNil(paramg.field_favProto.desc)) {
          break;
        }
        localStringBuffer.append(paramg.field_favProto.desc.getBytes().length);
        break;
        localStringBuffer.append(c(paramg).duration);
        break;
        localObject = "";
        try
        {
          paramg = paramg.field_favProto.ZAj.ZBV;
          localStringBuffer.append(paramg);
          break;
          if (paramg == null) {
            break;
          }
          paramg = paramg.field_favProto.vEn.iterator();
          int i = 0;
          int m = 0;
          int k = 0;
          int j = 0;
          while (paramg.hasNext())
          {
            localObject = (arf)paramg.next();
            switch (((arf)localObject).dataType)
            {
            case 3: 
            default: 
              i += 1;
              break;
            case 1: 
              if (Util.isNullOrNil(((arf)localObject).desc)) {
                break label464;
              }
              k = ((arf)localObject).desc.getBytes().length + k;
              break;
            case 2: 
              m += 1;
              break;
            case 4: 
              j += 1;
            }
          }
          paramg = String.format("%d:%d:%d:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(i) });
          AppMethodBeat.o(103357);
          return paramg;
        }
        catch (Exception paramg)
        {
          for (;;)
          {
            paramg = (g)localObject;
          }
        }
      }
    }
  }
  
  public static void startSync()
  {
    AppMethodBeat.i(103324);
    am localam = new am();
    com.tencent.mm.kernel.h.aZW().a(localam, 0);
    AppMethodBeat.o(103324);
  }
  
  public static void u(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(103353);
    if (paramContext != null)
    {
      paramIntent.putExtra("Ksnsupload_type", 1);
      com.tencent.mm.br.c.b(paramContext, "sns", ".ui.SnsUploadUI", paramIntent);
    }
    AppMethodBeat.o(103353);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.b
 * JD-Core Version:    0.7.0.1
 */