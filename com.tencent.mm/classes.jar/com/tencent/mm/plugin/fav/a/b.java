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
import com.tencent.mm.ak.t;
import com.tencent.mm.ay.f;
import com.tencent.mm.g.a.ct;
import com.tencent.mm.g.a.gv;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.hb.a;
import com.tencent.mm.g.a.hb.b;
import com.tencent.mm.g.a.oc;
import com.tencent.mm.g.a.sm;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.amq;
import com.tencent.mm.protocal.protobuf.ams;
import com.tencent.mm.protocal.protobuf.amv;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.ano;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.protocal.protobuf.cps;
import com.tencent.mm.protocal.protobuf.cpv;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vfs.s;
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
  private static HashMap<Long, ArrayList<String>> sZQ;
  private static long sZR;
  
  static
  {
    AppMethodBeat.i(103360);
    sZQ = new HashMap();
    sZR = 0L;
    AppMethodBeat.o(103360);
  }
  
  public static float AO(long paramLong)
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
  
  public static void DH(long paramLong)
  {
    AppMethodBeat.i(103265);
    Log.i("MicroMsg.Fav.FavApiLogic", "setUsedCapacity:%d", new Object[] { Long.valueOf(paramLong) });
    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NVC, Long.valueOf(paramLong));
    AppMethodBeat.o(103265);
  }
  
  public static void DI(long paramLong)
  {
    AppMethodBeat.i(103266);
    Log.i("MicroMsg.Fav.FavApiLogic", "setTotalCapacity:%d", new Object[] { Long.valueOf(paramLong) });
    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NVD, Long.valueOf(paramLong));
    AppMethodBeat.o(103266);
  }
  
  private static String DJ(long paramLong)
  {
    AppMethodBeat.i(103267);
    StringBuilder localStringBuilder = new StringBuilder();
    g localg = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(paramLong);
    if ((localg == null) || (localg.field_favProto == null) || (localg.field_favProto.ppH.size() <= 1))
    {
      AppMethodBeat.o(103267);
      return "";
    }
    amv localamv = localg.field_favProto.KBr;
    String str2 = "";
    String str1 = "";
    if (localamv != null)
    {
      str2 = localamv.LxU;
      str1 = localamv.LxT;
    }
    localStringBuilder.append("<noteinfo>");
    localStringBuilder.append("<noteauthor>").append(str1).append("</noteauthor>");
    localStringBuilder.append("<noteeditor>").append(str2).append("</noteeditor>");
    localStringBuilder.append("<edittime>").append(localg.field_favProto.rnM).append("</edittime>");
    localStringBuilder.append("<editusr>").append(str1).append("</editusr>");
    localStringBuilder.append("<favlocalid>").append(localg.field_localId).append("</favlocalid>");
    localStringBuilder.append(com.tencent.mm.plugin.fav.a.a.a.dE(localg.field_favProto.ppH).replace("cdn_dataurl", "cdndataurl").replace("cdn_datakey", "cdndatakey").replace("cdn_thumburl", "cdnthumburl").replace("cdn_thumbkey", "cdnthumbkey").replace("thumbfullsize", "thumbsize").replace("fullsize", "datasize").replace("datasrcname", "sourcename").replace("datasrctime", "sourcetime").replace("stream_lowbandurl", "streamlowbandurl").replace("stream_dataurl", "streamdataurl").replace("stream_weburl", "streamweburl"));
    localStringBuilder.append("</noteinfo>");
    str1 = localStringBuilder.toString();
    AppMethodBeat.o(103267);
    return str1;
  }
  
  public static void DK(long paramLong)
  {
    AppMethodBeat.i(103274);
    MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putLong("fav_mx_auto_download_size", paramLong).commit();
    AppMethodBeat.o(103274);
  }
  
  public static void DL(long paramLong)
  {
    AppMethodBeat.i(103275);
    MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putLong("fav_mx_auto_upload_size", paramLong).commit();
    AppMethodBeat.o(103275);
  }
  
  public static void DM(long paramLong)
  {
    AppMethodBeat.i(103276);
    MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putLong("fav_mx_file_size", paramLong).commit();
    AppMethodBeat.o(103276);
  }
  
  public static void DN(long paramLong)
  {
    sZR = paramLong;
  }
  
  public static float DO(long paramLong)
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
  
  public static String DP(long paramLong)
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
  
  public static String EX(String paramString)
  {
    AppMethodBeat.i(199698);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(199698);
      return "";
    }
    paramString = arI(paramString);
    paramString = com.tencent.mm.vfs.aa.z(new com.tencent.mm.vfs.o(arH(paramString), paramString).her());
    AppMethodBeat.o(199698);
    return paramString;
  }
  
  public static boolean HS(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = a.sZO;
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
  
  public static String Is(String paramString)
  {
    AppMethodBeat.i(103304);
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramString);
    if (localObject == null)
    {
      Log.w("MicroMsg.Fav.FavApiLogic", "wtf get contact null, username %s", new Object[] { paramString });
      AppMethodBeat.o(103304);
      return "";
    }
    String str = ((as)localObject).arJ();
    localObject = str;
    if (ab.Eq(str))
    {
      paramString = v.Ic(paramString);
      localObject = com.tencent.mm.model.z.aTY();
      if ((paramString != null) && (!paramString.isEmpty())) {
        break label110;
      }
      Log.w("MicroMsg.Fav.FavApiLogic", "get members from username error, content empty");
    }
    for (localObject = str;; localObject = v.e(paramString, 3))
    {
      AppMethodBeat.o(103304);
      return localObject;
      label110:
      paramString.remove(localObject);
      paramString.add(0, localObject);
    }
  }
  
  public static long a(g paramg)
  {
    AppMethodBeat.i(103261);
    Object localObject = a.sZO;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      if (localObject[i] == paramg.field_type)
      {
        if (paramg.field_favProto != null)
        {
          localObject = paramg.field_favProto.ppH.iterator();
          for (long l1 = 0L;; l1 = ((aml)((Iterator)localObject).next()).LvI + l1)
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
  
  public static g a(anb paramanb)
  {
    AppMethodBeat.i(103342);
    g localg = new g();
    localg.field_favProto = new anb();
    localg.field_type = 18;
    localg.field_favProto = paramanb;
    AppMethodBeat.o(103342);
    return localg;
  }
  
  public static aml a(g paramg, String paramString)
  {
    AppMethodBeat.i(103292);
    if ((Util.isNullOrNil(paramString)) || (paramg == null) || (paramg.field_favProto.ppH.size() == 0))
    {
      AppMethodBeat.o(103292);
      return null;
    }
    paramg = paramg.field_favProto.ppH.iterator();
    while (paramg.hasNext())
    {
      aml localaml = (aml)paramg.next();
      if (localaml.dLl.equals(paramString))
      {
        AppMethodBeat.o(103292);
        return localaml;
      }
    }
    AppMethodBeat.o(103292);
    return null;
  }
  
  public static amq a(int paramInt, anb paramanb, ano paramano)
  {
    AppMethodBeat.i(103262);
    if (paramanb == null)
    {
      Log.w("MicroMsg.Fav.FavApiLogic", "proto item is null");
      AppMethodBeat.o(103262);
      return null;
    }
    amq localamq = new amq();
    anh localanh = paramanb.Lya;
    if (localanh != null)
    {
      localamq.dRL = localanh.dRL;
      localamq.LxL = localanh.LxA;
      localamq.appId = localanh.appId;
      localamq.dCl = localanh.dCl;
    }
    if (paramano != null)
    {
      if (paramano.Lyn != null) {
        localamq.LxM.addAll(paramano.Lyn);
      }
      if (paramano.Lyo != null) {
        localamq.LxM.addAll(paramano.Lyo);
      }
    }
    localamq.dXI = paramanb;
    localamq.type = paramInt;
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
      return localamq;
    case 1: 
      localamq.title = "";
      localamq.desc = paramanb.desc;
      AppMethodBeat.o(103262);
      return localamq;
    case 4: 
      if ((paramanb.ppH != null) && (!paramanb.ppH.isEmpty())) {
        localamq.title = ((aml)paramanb.ppH.get(0)).title;
      }
      AppMethodBeat.o(103262);
      return localamq;
    case 5: 
      if (paramanb.LwS != null)
      {
        localamq.title = paramanb.LwS.title;
        localamq.desc = paramanb.LwS.LyC;
      }
      if ((Util.isNullOrNil(localamq.title)) && (paramanb.ppH != null) && (!paramanb.ppH.isEmpty())) {
        localamq.title = ((aml)paramanb.ppH.get(0)).title;
      }
      if ((Util.isNullOrNil(localamq.desc)) && (localanh != null)) {
        localamq.desc = localanh.link;
      }
      AppMethodBeat.o(103262);
      return localamq;
    case 6: 
      localamq.title = paramanb.remark;
      if (Util.isNullOrNil(localamq.title)) {
        if (paramanb.LwQ != null)
        {
          localamq.title = paramanb.LwQ.dWi;
          localamq.desc = paramanb.LwQ.label;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(103262);
        return localamq;
        if (paramanb.LwQ != null) {
          localamq.desc = paramanb.LwQ.dWi;
        }
      }
    case 2: 
      if ((paramanb.ppH != null) && (paramanb.ppH.size() > 0)) {
        localamq.title = ((aml)paramanb.ppH.get(0)).title;
      }
      AppMethodBeat.o(103262);
      return localamq;
    case 7: 
    case 21: 
      if ((paramanb.ppH != null) && (!paramanb.ppH.isEmpty()))
      {
        localamq.title = ((aml)paramanb.ppH.get(0)).title;
        localamq.desc = ((aml)paramanb.ppH.get(0)).desc;
      }
      AppMethodBeat.o(103262);
      return localamq;
    case 8: 
      localamq.title = paramanb.title;
      if ((Util.isNullOrNil(localamq.title)) && (paramanb.ppH != null) && (!paramanb.ppH.isEmpty())) {
        localamq.title = ((aml)paramanb.ppH.get(0)).title;
      }
      AppMethodBeat.o(103262);
      return localamq;
    case 10: 
    case 11: 
      if (paramanb.LwU != null)
      {
        localamq.title = paramanb.LwU.title;
        localamq.desc = paramanb.LwU.desc;
      }
      AppMethodBeat.o(103262);
      return localamq;
    case 12: 
    case 15: 
      if (paramanb.LwW != null)
      {
        localamq.title = paramanb.LwW.title;
        localamq.desc = paramanb.LwW.desc;
      }
      AppMethodBeat.o(103262);
      return localamq;
    }
    paramanb = paramanb.ppH;
    if (paramanb == null)
    {
      AppMethodBeat.o(103262);
      return null;
    }
    paramanb = paramanb.iterator();
    while (paramanb.hasNext())
    {
      paramano = (aml)paramanb.next();
      if (1 == paramano.dataType) {
        localamq.title = paramano.desc;
      }
    }
    AppMethodBeat.o(103262);
    return localamq;
  }
  
  public static String a(aml paramaml)
  {
    AppMethodBeat.i(103283);
    if ((paramaml == null) || (Util.isNullOrNil(paramaml.dLl)))
    {
      AppMethodBeat.o(103283);
      return "";
    }
    paramaml = arI(paramaml.dLl);
    paramaml = com.tencent.mm.vfs.aa.z(new com.tencent.mm.vfs.o(arH(paramaml), paramaml).her());
    AppMethodBeat.o(103283);
    return paramaml;
  }
  
  private static ArrayList<g> a(List<String> paramList, ArrayList<g> paramArrayList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199700);
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
        LinkedList localLinkedList = localg.field_favProto.ppH;
        if (localg.field_type != 18) {
          break label457;
        }
        i = 1;
        if (i >= localLinkedList.size()) {
          break;
        }
        aml localaml = (aml)localLinkedList.get(i);
        if (localaml.dataType != paramInt1) {
          break label471;
        }
        if (!Util.isNullOrNil(localaml.title))
        {
          paramArrayList = localaml.title;
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
          paramArrayList = localg.cUC();
          paramArrayList.field_type = paramInt2;
          paramArrayList.tad = true;
          paramArrayList.tae = localg;
          paramArrayList.dLb = (localg.field_localId + "_" + localaml.dLl);
          paramArrayList.taf = localaml.dLl;
          paramArrayList.field_favProto = com.tencent.mm.plugin.fav.a.a.c.c(localg.field_favProto);
          paramArrayList.field_favProto.ppH = new LinkedList();
          paramArrayList.field_favProto.ppH.add(localaml);
          paramArrayList.field_favProto.bhd(localaml.title);
          if (localaml.Lwh != null)
          {
            if (paramInt1 == 6) {
              paramArrayList.field_favProto.d(localaml.Lwh.LwQ);
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
          paramArrayList = localaml.desc;
          continue;
        }
        if (paramInt1 != 5) {
          continue;
        }
        paramArrayList.field_favProto.b(localaml.Lwh.LwS);
        continue;
      }
      catch (Exception paramArrayList)
      {
        Log.e("MicroMsg.Fav.FavApiLogic", "getSearchList() [%s] Exception:%s %s", new Object[] { Integer.valueOf(paramInt1), paramArrayList.getClass().getSimpleName(), paramArrayList.getMessage() });
      }
      localArrayList.add(localg);
      break;
      AppMethodBeat.o(199700);
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
  
  public static ArrayList<g> a(List<String> paramList1, List<String> paramList2, int paramInt, List<g> paramList, Set<Integer> paramSet, w paramw)
  {
    AppMethodBeat.i(103333);
    ArrayList localArrayList1 = new ArrayList(1);
    localArrayList1.add(Integer.valueOf(paramInt));
    paramList2 = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavSearchStorage().b(paramList1, paramList2, localArrayList1);
    localArrayList1 = new ArrayList();
    if (paramList2.size() == 0)
    {
      AppMethodBeat.o(103333);
      return localArrayList1;
    }
    int i;
    label364:
    for (int j = 0;; j = i)
    {
      ArrayList localArrayList2;
      if (j + 20 < paramList2.size())
      {
        i = j + 20;
        Log.v("MicroMsg.Fav.FavApiLogic", "start:%d  end:%d listSize:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramList2.size()) });
        localArrayList2 = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(paramList2.subList(j, i), paramList, paramSet, paramw);
        if ((localArrayList2 != null) && (localArrayList2.size() > 0))
        {
          if (paramInt != 8) {
            break label243;
          }
          localArrayList1.addAll(a(paramList1, localArrayList2, 8, 8));
        }
      }
      for (;;)
      {
        if (i < paramList2.size()) {
          break label364;
        }
        AppMethodBeat.o(103333);
        return localArrayList1;
        i = paramList2.size();
        break;
        label243:
        if (paramInt == 5)
        {
          localArrayList1.addAll(a(paramList1, localArrayList2, 5, 5));
        }
        else if (paramInt == 7)
        {
          localArrayList1.addAll(a(paramList1, localArrayList2, 7, 7));
          localArrayList1.addAll(a(paramList1, localArrayList2, 29, 21));
        }
        else if (paramInt == 6)
        {
          localArrayList1.addAll(a(paramList1, localArrayList2, 6, 6));
        }
        else if (paramInt == 3)
        {
          localArrayList1.addAll(a(paramList1, localArrayList2, 3, 3));
        }
        else
        {
          localArrayList1.addAll(localArrayList2);
        }
      }
    }
  }
  
  public static ArrayList<g> a(List<String> paramList1, List<String> paramList2, List<Integer> paramList, List<g> paramList3, Set<Integer> paramSet, w paramw)
  {
    AppMethodBeat.i(103335);
    paramList1 = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavSearchStorage().b(paramList1, paramList2, paramList);
    paramList2 = new ArrayList();
    if (paramList1.size() == 0)
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
        localObject = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(paramList1.subList(j, i), paramList3, paramSet, paramw);
        if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
          break label336;
        }
        if (paramList.contains(Integer.valueOf(8))) {
          localObject = ((ArrayList)localObject).iterator();
        }
      }
      else
      {
        for (;;)
        {
          label186:
          if (!((Iterator)localObject).hasNext()) {
            break label336;
          }
          g localg = (g)((Iterator)localObject).next();
          if (localg.field_type == 18) {
            for (;;)
            {
              try
              {
                LinkedList localLinkedList = localg.field_favProto.ppH;
                j = 1;
                if (j >= localLinkedList.size()) {
                  continue;
                }
                int k = ((aml)localLinkedList.get(j)).dataType;
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
                break label186;
              }
              paramList2.add(localg);
              break label186;
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
      label336:
      if (i >= paramList1.size())
      {
        AppMethodBeat.o(103335);
        return paramList2;
      }
    }
  }
  
  public static List<g> a(long paramLong, int paramInt, Set<Integer> paramSet, w paramw)
  {
    AppMethodBeat.i(103322);
    if (((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage() == null)
    {
      Log.e("MicroMsg.Fav.FavApiLogic", "getItemList error, getFavItemInfoStorage null.");
      AppMethodBeat.o(103322);
      return null;
    }
    if (paramLong == 0L)
    {
      paramSet = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(paramInt, paramSet, paramw);
      AppMethodBeat.o(103322);
      return paramSet;
    }
    paramSet = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().b(paramLong, paramInt, paramSet, paramw);
    AppMethodBeat.o(103322);
    return paramSet;
  }
  
  public static void a(long paramLong, ams paramams, String paramString1, String paramString2, ArrayList<String> paramArrayList, Context paramContext)
  {
    AppMethodBeat.i(103355);
    if ((paramams == null) || (paramContext == null))
    {
      AppMethodBeat.o(103355);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("KFavLocSigleView", true);
    localIntent.putExtra("map_view_type", 2);
    localIntent.putExtra("kFavInfoLocalId", paramLong);
    localIntent.putExtra("kwebmap_slat", paramams.lat);
    localIntent.putExtra("kwebmap_lng", paramams.lng);
    localIntent.putExtra("kPoiName", paramams.dWi);
    localIntent.putExtra("Kwebmap_locaion", paramams.label);
    if (paramams.dRt >= 0) {
      localIntent.putExtra("kwebmap_scale", paramams.dRt);
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
        paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramBundle).bl(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.axQ(), "com/tencent/mm/plugin/fav/api/FavApiLogic", "startFavActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
        paramContext.startActivity((Intent)paramString.pG(0), (Bundle)paramString.pG(1));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/fav/api/FavApiLogic", "startFavActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
        AppMethodBeat.o(103348);
        return;
      }
      localIntent.addFlags(268435456);
      paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramBundle).bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.axQ(), "com/tencent/mm/plugin/fav/api/FavApiLogic", "startFavActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
      paramContext.startActivity((Intent)paramString.pG(0), (Bundle)paramString.pG(1));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/fav/api/FavApiLogic", "startFavActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
      AppMethodBeat.o(103348);
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.Fav.FavApiLogic", "Class Not Found when startActivity %s", new Object[] { paramContext });
      AppMethodBeat.o(103348);
    }
  }
  
  private static void a(hb paramhb)
  {
    AppMethodBeat.i(103268);
    if (Util.isNullOrNil(paramhb.dLm.desc))
    {
      paramhb.dLn.ret = -1;
      AppMethodBeat.o(103268);
      return;
    }
    Object localObject = arP(paramhb.dLm.desc);
    if ((localObject == null) || (((g)localObject).field_localId <= 0L))
    {
      paramhb.dLn.ret = -1;
      AppMethodBeat.o(103268);
      return;
    }
    boolean bool = e((g)localObject);
    String str = paramhb.dLm.dLs;
    if (bool)
    {
      paramhb.dLn.ret = 1;
      paramhb = (ArrayList)sZQ.get(Long.valueOf(((g)localObject).field_localId));
      if (paramhb != null)
      {
        if (paramhb.contains(str)) {
          paramhb.remove(str);
        }
        if (paramhb.size() == 0) {
          sZQ.remove(Long.valueOf(((g)localObject).field_localId));
        }
      }
      AppMethodBeat.o(103268);
      return;
    }
    if (Util.isNullOrNil(str))
    {
      paramhb.dLn.ret = -1;
      AppMethodBeat.o(103268);
      return;
    }
    long l = ((g)localObject).field_localId;
    ArrayList localArrayList = (ArrayList)sZQ.get(Long.valueOf(l));
    localObject = localArrayList;
    if (localArrayList == null) {
      localObject = new ArrayList();
    }
    ((ArrayList)localObject).add(str);
    sZQ.put(Long.valueOf(l), localObject);
    localObject = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(l);
    if ((localObject == null) || (((g)localObject).field_localId <= 0L))
    {
      paramhb.dLn.ret = -1;
      AppMethodBeat.o(103268);
      return;
    }
    if ((e((g)localObject)) || (((g)localObject).field_itemStatus == 10))
    {
      paramhb.dLn.ret = -1;
      com.tencent.mm.kernel.g.aAk().postToWorkerDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103255);
          b.d(this.sZS);
          AppMethodBeat.o(103255);
        }
      }, 500L);
      AppMethodBeat.o(103268);
      return;
    }
    paramhb.dLn.ret = -1;
    AppMethodBeat.o(103268);
  }
  
  private static void a(c paramc, g paramg)
  {
    AppMethodBeat.i(103295);
    Iterator localIterator = paramg.field_favProto.ppH.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      aml localaml = (aml)localIterator.next();
      if ((localaml.dataType != 1) && (localaml.dataType != 6))
      {
        if (!Util.isNullOrNil(localaml.KuR)) {
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
          ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(17, paramc.field_favLocalId);
          ((af)com.tencent.mm.kernel.g.ah(af.class)).getModService().run();
          AppMethodBeat.o(103295);
          return;
        }
        ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(9, paramc.field_favLocalId);
        ((af)com.tencent.mm.kernel.g.ah(af.class)).getSendService().run();
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
    Object localObject2 = new cps();
    ((cps)localObject2).MvI = 4;
    ((cps)localObject2).MvJ = 0;
    ((LinkedList)localObject1).add(localObject2);
    localObject2 = new LinkedList();
    cpv localcpv = new cpv();
    localcpv.xMo = "favitem.taglist";
    localcpv.oUv = 1;
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramg.field_tagProto.Lyo.size();
    int i = 0;
    while (i < j)
    {
      localStringBuffer.append("<tag>").append(Util.escapeStringForXml((String)paramg.field_tagProto.Lyo.get(i))).append("</tag>");
      i += 1;
    }
    localcpv.Cyk = localStringBuffer.toString();
    Log.v("MicroMsg.Fav.FavApiLogic", "do net scene mod tag, id=%d, tag=%s", new Object[] { Integer.valueOf(paramg.field_id), localcpv.Cyk });
    ((LinkedList)localObject2).add(localcpv);
    if (paramg.field_id > 0)
    {
      localObject1 = new am(paramg.field_id, (LinkedList)localObject1, (LinkedList)localObject2);
      com.tencent.mm.kernel.g.azz().a((com.tencent.mm.ak.q)localObject1, 0);
      h.i(paramg.field_id, j, paramInt);
      AppMethodBeat.o(103346);
      return;
    }
    ((af)com.tencent.mm.kernel.g.ah(af.class)).getEditService().a(paramg.field_localId, (LinkedList)localObject1, (LinkedList)localObject2, paramInt);
    AppMethodBeat.o(103346);
  }
  
  public static void a(g paramg, aml paramaml)
  {
    AppMethodBeat.i(103308);
    if (Util.isNullOrNil(paramaml.dLl))
    {
      AppMethodBeat.o(103308);
      return;
    }
    String str = arI(paramaml.dLl);
    c localc = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(str);
    Object localObject = localc;
    if (localc != null)
    {
      localObject = localc;
      if (localc.field_status == 3)
      {
        ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().b(localc, new String[] { "dataId" });
        localObject = null;
      }
    }
    if ((localObject != null) && (((c)localObject).field_type == 1))
    {
      ((c)localObject).field_status = 1;
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().a((c)localObject, new String[] { "dataId" });
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().arY(str);
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().run();
      AppMethodBeat.o(103308);
      return;
    }
    localObject = new com.tencent.mm.vfs.o(a(paramaml));
    if ((!Util.isNullOrNil(paramaml.Lvk)) && (!Util.isNullOrNil(paramaml.iwX)) && (!((com.tencent.mm.vfs.o)localObject).exists()))
    {
      a(paramaml, paramg, 1);
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().arY(str);
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().run();
    }
    AppMethodBeat.o(103308);
  }
  
  public static void a(g paramg, aml paramaml, boolean paramBoolean)
  {
    AppMethodBeat.i(103307);
    if ((paramg == null) || (Util.isNullOrNil(paramaml.dLl)))
    {
      AppMethodBeat.o(103307);
      return;
    }
    Log.i("MicroMsg.Fav.FavApiLogic", "restart cdndata download, favId %d, favLocalId %d, dataId %s", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), paramaml.dLl });
    Object localObject2 = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(paramaml.dLl);
    Object localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((c)localObject2).field_status == 3)
      {
        ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().b((c)localObject2, new String[] { "dataId" });
        localObject1 = null;
      }
    }
    localObject2 = localObject1;
    if (localObject1 != null) {
      if ((!Util.isNullOrNil(((c)localObject1).field_cdnUrl)) && (!Util.isNullOrNil(((c)localObject1).field_cdnKey)) && (!Util.isNullOrNil(((c)localObject1).field_dataId)) && (((c)localObject1).field_cdnUrl.equals(paramaml.KuR)) && (((c)localObject1).field_cdnKey.equals(paramaml.Lvp)))
      {
        localObject2 = localObject1;
        if (((c)localObject1).field_dataId.equals(paramaml.dLl)) {}
      }
      else
      {
        ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().b((c)localObject1, new String[] { "dataId" });
        localObject2 = null;
      }
    }
    if ((localObject2 != null) && (((c)localObject2).field_type == 1))
    {
      Log.i("MicroMsg.Fav.FavApiLogic", "klem data not download completed.");
      ((c)localObject2).field_status = 1;
      ((c)localObject2).field_path = d(paramaml);
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().a((c)localObject2, new String[] { "dataId" });
      if (paramBoolean)
      {
        ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().arY(paramaml.dLl);
        if ((!Util.isNullOrNil(paramaml.Lwp)) && (paramaml.Lwp.equals("WeNoteHtmlFile")))
        {
          paramg = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(paramaml.dLl);
          ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().d(paramg);
        }
      }
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().run();
      AppMethodBeat.o(103307);
      return;
    }
    localObject1 = new com.tencent.mm.vfs.o(d(paramaml));
    if ((!Util.isNullOrNil(paramaml.Lvp)) && (!Util.isNullOrNil(paramaml.KuR)) && (!((com.tencent.mm.vfs.o)localObject1).exists()))
    {
      Log.i("MicroMsg.Fav.FavApiLogic", "klem big img not exist, start download.");
      long l = System.currentTimeMillis();
      a(paramaml, paramg, 1, true);
      if (paramBoolean)
      {
        ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().arY(paramaml.dLl);
        if ((!Util.isNullOrNil(paramaml.Lwp)) && (paramaml.Lwp.equals("WeNoteHtmlFile")))
        {
          paramg = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(paramaml.dLl);
          ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().d(paramg);
        }
      }
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().run();
      Log.i("MicroMsg.Fav.FavApiLogic", "insert cdn item use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
    AppMethodBeat.o(103307);
  }
  
  public static void a(g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(103286);
    h(paramg);
    ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavSearchStorage().Ea(paramg.field_localId);
    ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().A(paramg);
    ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().DW(paramg.field_localId);
    ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavTagSetMgr().w(paramg);
    if (paramBoolean)
    {
      Set localSet = cUe();
      localSet.add(paramg.field_id);
      i(localSet);
      cUg();
    }
    if (paramg.field_type == 18)
    {
      long l = paramg.field_localId;
      if (l <= 0L)
      {
        AppMethodBeat.o(103286);
        return;
      }
      paramg = new ct();
      paramg.dFT.localId = l;
      EventCenter.instance.publish(paramg);
    }
    AppMethodBeat.o(103286);
  }
  
  public static void a(aml paramaml, int paramInt, long paramLong)
  {
    AppMethodBeat.i(103329);
    if (Util.isNullOrNil(paramaml.dLl))
    {
      AppMethodBeat.o(103329);
      return;
    }
    if ((Util.isNullOrNil(paramaml.Lvk)) || (Util.isNullOrNil(paramaml.iwX)))
    {
      AppMethodBeat.o(103329);
      return;
    }
    String str = arI(paramaml.dLl);
    c localc = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(str);
    Object localObject = localc;
    if (localc != null) {
      if (localc.field_status != 3)
      {
        localObject = localc;
        if (localc.field_status != 4) {}
      }
      else
      {
        ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().b(localc, new String[] { "dataId" });
        localObject = null;
      }
    }
    if ((localObject != null) && (((c)localObject).field_type == 1))
    {
      ((c)localObject).field_status = 1;
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().a((c)localObject, new String[] { "dataId" });
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().arY(str);
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().run();
      AppMethodBeat.o(103329);
      return;
    }
    localObject = new com.tencent.mm.vfs.o(a(paramaml));
    if ((!Util.isNullOrNil(paramaml.Lvk)) && (!Util.isNullOrNil(paramaml.iwX)) && (!((com.tencent.mm.vfs.o)localObject).exists()))
    {
      localObject = new g();
      ((g)localObject).field_localId = paramLong;
      ((g)localObject).field_id = -1;
      ((g)localObject).field_type = paramInt;
      a(paramaml, (g)localObject, 1);
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().arY(str);
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().run();
    }
    AppMethodBeat.o(103329);
  }
  
  public static void a(aml paramaml, g paramg, int paramInt)
  {
    AppMethodBeat.i(103296);
    if ((paramInt == 1) && ((paramaml.LvT <= 0L) || (Util.isNullOrNil(paramaml.Lvk)) || (Util.isNullOrNil(paramaml.iwX))))
    {
      Log.e("MicroMsg.Fav.FavApiLogic", "insertCdnThumbInfo, type recv, cdndataurl must not be null!");
      AppMethodBeat.o(103296);
      return;
    }
    if ((paramInt == 0) && (Util.isNullOrNil(a(paramaml))))
    {
      Log.e("MicroMsg.Fav.FavApiLogic", "insertCdnThumbInfo, type send, path must not be null!");
      AppMethodBeat.o(103296);
      return;
    }
    String str = arI(paramaml.dLl);
    if (((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(str) != null)
    {
      Log.w("MicroMsg.Fav.FavApiLogic", "cdn info exist, id[%s], return", new Object[] { str });
      AppMethodBeat.o(103296);
      return;
    }
    Log.v("MicroMsg.Fav.FavApiLogic", "insert cdn thumb info, fav local id[%d] fav id[%d]", new Object[] { Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
    c localc = new c();
    localc.field_cdnKey = paramaml.Lvk;
    localc.field_cdnUrl = paramaml.iwX;
    localc.field_dataId = str;
    localc.field_favLocalId = paramg.field_localId;
    localc.field_totalLen = ((int)paramaml.LvT);
    localc.field_type = paramInt;
    localc.field_status = 1;
    localc.field_path = a(paramaml);
    localc.field_modifyTime = Util.nowMilliSecond();
    localc.field_attrFlag |= 1L;
    ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().f(localc);
    if (paramInt == 1)
    {
      c(localc);
      AppMethodBeat.o(103296);
      return;
    }
    b(localc);
    AppMethodBeat.o(103296);
  }
  
  public static void a(aml paramaml, g paramg, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(103297);
    if ((paramInt == 1) && ((Util.isNullOrNil(paramaml.Lvp)) || (Util.isNullOrNil(paramaml.KuR))))
    {
      Log.e("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo, type recv, cdndataurl must not be null!");
      AppMethodBeat.o(103297);
      return;
    }
    if ((paramInt == 0) && (Util.isNullOrNil(d(paramaml))))
    {
      Log.e("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo, type send, path must not be null!");
      AppMethodBeat.o(103297);
      return;
    }
    if (((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(paramaml.dLl) != null)
    {
      Log.v("MicroMsg.Fav.FavApiLogic", "cdn info exist, id[%s], return", new Object[] { paramaml.dLl });
      AppMethodBeat.o(103297);
      return;
    }
    Log.i("MicroMsg.Fav.FavApiLogic", "insert cdn data info, fav local id[%d] fav id[%d]", new Object[] { Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
    c localc = new c();
    localc.field_dataId = paramaml.dLl;
    localc.field_totalLen = ((int)paramaml.LvI);
    localc.field_type = paramInt;
    localc.field_favLocalId = paramg.field_localId;
    localc.field_cdnKey = paramaml.Lvp;
    localc.field_cdnUrl = paramaml.KuR;
    localc.field_path = d(paramaml);
    boolean bool;
    int i;
    label404:
    if (paramaml.dataType == 3)
    {
      localc.field_dataType = arK(paramaml.LvC);
      localc.field_modifyTime = Util.nowMilliSecond();
      bool = NetStatusUtil.isWifi(MMApplicationContext.getContext());
      if (paramInt == 0)
      {
        Log.i("MicroMsg.Fav.FavApiLogic", "can auto upload, force %B, isWifi %B, dataType %d, totalLen %d", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), Integer.valueOf(localc.field_dataType), Integer.valueOf(localc.field_totalLen) });
        if (!paramBoolean) {
          break label473;
        }
        i = 1;
        label324:
        if (i == 0) {
          break label612;
        }
        localc.field_status = 1;
        Log.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo upload status traning");
      }
      label343:
      if (paramInt == 1)
      {
        Log.i("MicroMsg.Fav.FavApiLogic", "can auto download, force %B, isWifi %B, dataType %d, totalLen %d", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), Integer.valueOf(localc.field_dataType), Integer.valueOf(localc.field_totalLen) });
        if (!paramBoolean) {
          break label629;
        }
        i = 1;
        if (i == 0) {
          break label754;
        }
        localc.field_status = 1;
        Log.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo download status traning");
      }
    }
    for (;;)
    {
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().f(localc);
      if (paramInt != 1) {
        break label771;
      }
      c(localc);
      AppMethodBeat.o(103297);
      return;
      localc.field_dataType = paramaml.dataType;
      break;
      label473:
      if (bool)
      {
        i = 1;
        break label324;
      }
      if ((localc.field_dataType != 8) && (localc.field_dataType != 4) && (localc.field_dataType != 15))
      {
        i = 1;
        break label324;
      }
      long l2 = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getLong("fav_mx_auto_upload_size", 0L);
      long l1 = l2;
      if (l2 == 0L) {
        l1 = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFileSizeLimit(true);
      }
      if (localc.field_totalLen <= l1)
      {
        Log.i("MicroMsg.Fav.FavApiLogic", "match max auto upload, max size %d", new Object[] { Long.valueOf(l1) });
        i = 1;
        break label324;
      }
      i = 0;
      break label324;
      label612:
      localc.field_status = 4;
      Log.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo upload status pause");
      break label343;
      label629:
      if (bool)
      {
        i = 1;
        break label404;
      }
      if ((localc.field_dataType != 8) && (localc.field_dataType != 4) && (localc.field_dataType != 15))
      {
        i = 1;
        break label404;
      }
      l1 = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getLong("fav_mx_auto_download_size", ((af)com.tencent.mm.kernel.g.ah(af.class)).getFileSizeLimit(true));
      if (localc.field_totalLen <= l1)
      {
        Log.i("MicroMsg.Fav.FavApiLogic", "match max auto download, max size %d", new Object[] { Long.valueOf(l1) });
        i = 1;
        break label404;
      }
      i = 0;
      break label404;
      label754:
      localc.field_status = 4;
      Log.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo download status pause");
    }
    label771:
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
    com.tencent.mm.br.c.f(paramContext, ".ui.transmit.MsgRetransmitUI", localIntent);
    AppMethodBeat.o(168687);
  }
  
  public static boolean a(g paramg, Runnable paramRunnable)
  {
    AppMethodBeat.i(103289);
    boolean bool = a(paramg, true, paramRunnable);
    AppMethodBeat.o(103289);
    return bool;
  }
  
  public static boolean a(g paramg, boolean paramBoolean, Runnable paramRunnable)
  {
    AppMethodBeat.i(103287);
    if (paramg == null)
    {
      Log.w("MicroMsg.Fav.FavApiLogic", "delete fav item fail, item is null");
      MMHandlerThread.postToMainThread(paramRunnable);
      AppMethodBeat.o(103287);
      return false;
    }
    if (Looper.myLooper() == com.tencent.mm.kernel.g.aAk().getLooper())
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
      com.tencent.mm.kernel.g.aAk().postToWorker(new b.2(paramg, paramBoolean, paramRunnable));
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
    final aml localaml = c(paramg);
    String[] arrayOfString = new String[2];
    Runnable local3 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(103257);
        b.a(this.sZW, localaml);
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
      if (localaml != null)
      {
        arrayOfString[0] = a(localaml);
        arrayOfString[1] = localaml.dFN;
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
        localObject1 = paramg.field_favProto.LwS;
        if (localaml == null)
        {
          if (localObject1 != null) {
            arrayOfString[1] = ((anq)localObject1).thumbUrl;
          }
        }
        else
        {
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = ((anq)localObject1).thumbUrl)
          {
            localObject2 = localObject1;
            if (Util.isNullOrNil((String)localObject1)) {
              localObject2 = localaml.dFN;
            }
            arrayOfString[0] = a(localaml);
            arrayOfString[1] = localObject2;
            paramMMHandler.post(local3);
            break;
          }
          paramMMHandler = paramg.field_favProto.LwU;
          if (paramMMHandler != null)
          {
            arrayOfString[1] = paramMMHandler.thumbUrl;
            continue;
            paramMMHandler = paramg.field_favProto.LwW;
            if (paramMMHandler != null)
            {
              arrayOfString[1] = paramMMHandler.thumbUrl;
              continue;
              paramMMHandler = paramg.field_favProto.LwU;
              if (paramMMHandler != null) {
                arrayOfString[1] = paramMMHandler.thumbUrl;
              }
            }
          }
        }
      }
    }
    if (paramg.field_favProto.ppH != null)
    {
      Iterator localIterator = paramg.field_favProto.ppH.iterator();
      label375:
      localObject1 = localObject2;
      if (localIterator.hasNext())
      {
        localObject1 = (aml)localIterator.next();
        if (((aml)localObject1).dataType != 2) {
          break label435;
        }
        localObject1 = d((aml)localObject1);
        paramMMHandler.post(local3);
      }
    }
    for (;;)
    {
      arrayOfString[0] = localObject1;
      arrayOfString[1] = localaml.dFN;
      break;
      label435:
      if (((aml)localObject1).dataType != 15) {
        break label375;
      }
      localObject1 = a((aml)localObject1);
      paramMMHandler.post(local3);
    }
  }
  
  private static com.tencent.mm.vfs.o arH(String paramString)
  {
    AppMethodBeat.i(103279);
    int i = paramString.hashCode();
    paramString = new com.tencent.mm.vfs.o(String.format("%s%s/%d/", new Object[] { com.tencent.mm.kernel.g.aAh().hqG, "favorite", Integer.valueOf(i & 0xFF) }));
    if ((!paramString.exists()) || (!paramString.isDirectory())) {
      paramString.mkdirs();
    }
    AppMethodBeat.o(103279);
    return paramString;
  }
  
  public static String arI(String paramString)
  {
    AppMethodBeat.i(103284);
    paramString = paramString + "_t";
    AppMethodBeat.o(103284);
    return paramString;
  }
  
  public static boolean arJ(String paramString)
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
  
  public static int arK(String paramString)
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
  
  public static String arL(String paramString)
  {
    AppMethodBeat.i(103303);
    as localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramString);
    if (localas != null)
    {
      if (!Util.isNullOrNil(localas.field_conRemark))
      {
        paramString = localas.field_conRemark;
        AppMethodBeat.o(103303);
        return paramString;
      }
      if (!Util.isNullOrNil(localas.field_nickname))
      {
        paramString = localas.field_nickname;
        AppMethodBeat.o(103303);
        return paramString;
      }
      paramString = localas.field_username;
      AppMethodBeat.o(103303);
      return paramString;
    }
    AppMethodBeat.o(103303);
    return paramString;
  }
  
  public static String arM(String paramString)
  {
    AppMethodBeat.i(103325);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(103325);
      return null;
    }
    paramString = new com.tencent.mm.vfs.o(cUf() + com.tencent.mm.b.g.getMessageDigest(paramString.getBytes()));
    if (paramString.exists())
    {
      paramString = com.tencent.mm.vfs.aa.z(paramString.her());
      AppMethodBeat.o(103325);
      return paramString;
    }
    AppMethodBeat.o(103325);
    return null;
  }
  
  public static int arN(String paramString)
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
  
  public static g arO(String paramString)
  {
    AppMethodBeat.i(103338);
    g localg = new g();
    localg.field_localId = -1L;
    localg.field_id = -1;
    localg.field_xml = paramString;
    localg.field_type = 18;
    localg.arQ(paramString);
    AppMethodBeat.o(103338);
    return localg;
  }
  
  private static g arP(String paramString)
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
        localg.field_favProto = new anb();
        localg.field_type = 18;
        Object localObject = (String)localMap.get(".noteinfo.edittime");
        localg.field_favProto.Mz(Util.getLong((String)localObject, 0L));
        localObject = new amv();
        ((amv)localObject).LxU = ((String)localMap.get(".noteinfo.noteeditor"));
        ((amv)localObject).LxT = ((String)localMap.get(".noteinfo.noteauthor"));
        localg.field_favProto.a((amv)localObject);
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
    paramg = paramg.field_favProto.ppH.iterator();
    aml localaml;
    for (int i = 0; paramg.hasNext(); i = (int)(localaml.LvI + l))
    {
      localaml = (aml)paramg.next();
      l = i;
    }
    long l = i;
    AppMethodBeat.o(103263);
    return l;
  }
  
  public static String b(anb paramanb)
  {
    AppMethodBeat.i(103358);
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramanb != null) && (paramanb.ppH != null))
    {
      paramanb = paramanb.ppH.iterator();
      while (paramanb.hasNext()) {
        localStringBuilder.append(((aml)paramanb.next()).dLl).append(";");
      }
    }
    paramanb = localStringBuilder.toString();
    AppMethodBeat.o(103358);
    return paramanb;
  }
  
  public static void b(Context paramContext, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(258614);
    a(paramContext, paramString, paramIntent, null);
    AppMethodBeat.o(258614);
  }
  
  private static void b(hb paramhb)
  {
    AppMethodBeat.i(103341);
    g localg = arP(paramhb.dLm.desc);
    if (localg == null)
    {
      AppMethodBeat.o(103341);
      return;
    }
    if ((localg.field_favProto != null) && (localg.field_favProto.ppH != null))
    {
      Iterator localIterator = localg.field_favProto.ppH.iterator();
      while (localIterator.hasNext())
      {
        aml localaml = (aml)localIterator.next();
        if (localaml.dataType == 20)
        {
          localaml.At(true);
          localaml.As(true);
          localaml.bgt("");
          localaml.bgj("");
          localaml.bgk("");
          localaml.bgh("");
          localaml.bgi("");
        }
      }
    }
    paramhb.dLm.dGb = localg.field_favProto;
    AppMethodBeat.o(103341);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(103293);
    int i = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().x(paramc.field_favLocalId, 0);
    Log.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus, upload data status:%d, favlocalId:%d", new Object[] { Integer.valueOf(i), Long.valueOf(paramc.field_favLocalId) });
    g localg = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(paramc.field_favLocalId);
    if (localg == null)
    {
      Log.e("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus iteminfo null");
      AppMethodBeat.o(103293);
      return;
    }
    if (localg.cUB())
    {
      Log.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus waiting server upload skip.");
      AppMethodBeat.o(103293);
      return;
    }
    if ((paramc.field_status == 3) && (i != paramc.field_status) && (localg.field_type == 18) && (((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(paramc.field_dataId).field_status == 3))
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
      if (localg.cUA()) {
        ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(15, paramc.field_favLocalId);
      }
      for (;;)
      {
        Log.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus, continue upload data, favlocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
        AppMethodBeat.o(103293);
        return;
        ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(4, paramc.field_favLocalId);
      }
      if (localg.cUA()) {
        ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(16, paramc.field_favLocalId);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(localg.field_type), Integer.valueOf(-5), Long.valueOf(b(localg)), Long.valueOf(h.DR(localg.field_localId)) });
        Log.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus, error, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
        AppMethodBeat.o(103293);
        return;
        ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(6, paramc.field_favLocalId);
      }
      AppMethodBeat.o(103293);
      return;
      if (localg.field_type == 18)
      {
        a(paramc, localg);
        AppMethodBeat.o(103293);
        return;
      }
      if (localg.cUA())
      {
        ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(17, paramc.field_favLocalId);
        Log.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus start mod faviteminfo, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
        ((af)com.tencent.mm.kernel.g.ah(af.class)).getModService().run();
        AppMethodBeat.o(103293);
        return;
      }
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(9, paramc.field_favLocalId);
      Log.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus start send faviteminfo, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getSendService().run();
      AppMethodBeat.o(103293);
      return;
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(6, paramc.field_favLocalId);
      Log.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus pause, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
    }
  }
  
  private static void b(g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(103343);
    amv localamv = new amv();
    if (!paramBoolean) {
      localamv.LxT = com.tencent.mm.model.z.aTY();
    }
    localamv.LxU = com.tencent.mm.model.z.aTY();
    paramg.field_favProto.Mz(Util.nowSecond());
    paramg.field_favProto.a(localamv);
    AppMethodBeat.o(103343);
  }
  
  public static void b(aml paramaml, int paramInt, long paramLong)
  {
    AppMethodBeat.i(103330);
    if (Util.isNullOrNil(paramaml.dLl))
    {
      AppMethodBeat.o(103330);
      return;
    }
    Log.i("MicroMsg.Fav.FavApiLogic", "restart cdndata download, dataId %s", new Object[] { paramaml.dLl });
    c localc = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(paramaml.dLl);
    Object localObject = localc;
    if (localc != null) {
      if (localc.field_status != 3)
      {
        localObject = localc;
        if (localc.field_status != 4) {}
      }
      else
      {
        ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().b(localc, new String[] { "dataId" });
        localObject = null;
      }
    }
    if ((localObject != null) && (((c)localObject).field_type == 1))
    {
      Log.i("MicroMsg.Fav.FavApiLogic", "klem data not download completed.");
      ((c)localObject).field_status = 1;
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().a((c)localObject, new String[] { "dataId" });
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().arY(paramaml.dLl);
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().run();
      AppMethodBeat.o(103330);
      return;
    }
    localObject = new com.tencent.mm.vfs.o(d(paramaml));
    if ((!Util.isNullOrNil(paramaml.Lvp)) && (!Util.isNullOrNil(paramaml.KuR)) && (!((com.tencent.mm.vfs.o)localObject).exists()))
    {
      Log.i("MicroMsg.Fav.FavApiLogic", "klem big img not exist, start download.");
      long l = System.currentTimeMillis();
      localObject = new g();
      ((g)localObject).field_localId = paramLong;
      ((g)localObject).field_id = -1;
      ((g)localObject).field_type = paramInt;
      a(paramaml, (g)localObject, 1, true);
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().arY(paramaml.dLl);
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().run();
      Log.i("MicroMsg.Fav.FavApiLogic", "insert cdn item use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
    AppMethodBeat.o(103330);
  }
  
  public static void b(String paramString, Context paramContext)
  {
    AppMethodBeat.i(103352);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.Fav.FavApiLogic", "share image to timeline fail, filePath is null");
      AppMethodBeat.o(103352);
      return;
    }
    Intent localIntent = new Intent();
    String str1 = "fav_" + com.tencent.mm.model.z.aTY() + "_0";
    String str2 = ad.JX(str1);
    ad.aVe().G(str2, true).l("prePublishId", str1);
    localIntent.putExtra("reportSessionId", str2);
    localIntent.putExtra("Ksnsupload_type", 0);
    localIntent.putExtra("sns_kemdia_path", paramString);
    com.tencent.mm.br.c.b(paramContext, "sns", ".ui.SnsUploadUI", localIntent);
    AppMethodBeat.o(103352);
  }
  
  public static boolean b(long paramLong, Runnable paramRunnable)
  {
    AppMethodBeat.i(103331);
    boolean bool = a(((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(paramLong), true, paramRunnable);
    AppMethodBeat.o(103331);
    return bool;
  }
  
  public static aml c(g paramg)
  {
    AppMethodBeat.i(103264);
    if (paramg == null)
    {
      paramg = new aml();
      AppMethodBeat.o(103264);
      return paramg;
    }
    if (paramg.field_favProto.ppH.size() == 0)
    {
      paramg = new aml();
      AppMethodBeat.o(103264);
      return paramg;
    }
    paramg = (aml)paramg.field_favProto.ppH.get(0);
    AppMethodBeat.o(103264);
    return paramg;
  }
  
  public static String c(aml paramaml)
  {
    AppMethodBeat.i(103258);
    amm localamm = paramaml.Lwh;
    String str = "";
    switch (paramaml.dataType)
    {
    case 2: 
    case 3: 
    case 7: 
    case 9: 
    default: 
      paramaml = gE(gE("", localamm.title), localamm.desc);
    }
    for (;;)
    {
      AppMethodBeat.o(103258);
      return paramaml;
      paramaml = gE("", paramaml.desc);
      continue;
      paramaml = str;
      if (localamm.LwW != null)
      {
        paramaml = gE("", localamm.LwW.title);
        continue;
        paramaml = str;
        if (localamm.LwS != null)
        {
          paramaml = gE("", localamm.LwS.title);
          continue;
          str = gE("", localamm.remark);
          paramaml = str;
          if (localamm.LwQ != null)
          {
            paramaml = gE(gE(str, localamm.LwQ.dWi), localamm.LwQ.label);
            continue;
            paramaml = str;
            if (localamm.LwU != null)
            {
              paramaml = gE(gE("", localamm.LwU.title), localamm.LwU.desc);
              continue;
              paramaml = gE("", localamm.title);
            }
          }
        }
      }
    }
  }
  
  public static void c(hb paramhb)
  {
    int i = 1;
    AppMethodBeat.i(103345);
    Object localObject2;
    Object localObject3;
    if (paramhb.dLm.dLt == 1)
    {
      paramhb.dLn.path = DJ(paramhb.dLm.dFW);
      localObject2 = paramhb.dLn;
      long l = paramhb.dLm.dFW;
      localObject3 = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(l);
      if ((localObject3 == null) || (((g)localObject3).field_favProto == null)) {
        paramhb = "";
      }
      for (;;)
      {
        label87:
        ((hb.b)localObject2).thumbPath = paramhb;
        AppMethodBeat.o(103345);
        return;
        if ((((g)localObject3).field_type != 18) || (((g)localObject3).field_favProto.ppH.size() > 1))
        {
          paramhb = ((g)localObject3).field_favProto.ppH.iterator();
          for (;;)
          {
            if (paramhb.hasNext())
            {
              aml localaml = (aml)paramhb.next();
              switch (localaml.dataType)
              {
              default: 
                break;
              case 2: 
                localObject1 = a(localaml);
                paramhb = (hb)localObject1;
                if (s.YS((String)localObject1)) {
                  break label87;
                }
                paramhb = d(localaml);
                if (s.YS(paramhb))
                {
                  BitmapUtil.createThumbNail(paramhb, 150, 150, Bitmap.CompressFormat.JPEG, 90, (String)localObject1, true);
                  paramhb = a(localaml);
                  break label87;
                }
                if (localaml.Lvj)
                {
                  a((g)localObject3, localaml);
                  paramhb = (hb)localObject1;
                  break label87;
                }
                if (localaml.Lvo)
                {
                  a((g)localObject3, localaml, true);
                  break label87;
                }
                paramhb = "";
                break label87;
              }
            }
          }
        }
        paramhb = "";
      }
    }
    if (paramhb.dLm.dLt == 2)
    {
      localObject1 = new g();
      ((g)localObject1).field_type = 2;
      localObject2 = new aml();
      ((aml)localObject2).bgs(ds(localObject2.toString(), 2));
      localObject3 = d((aml)localObject2);
      ((aml)localObject2).bgt((String)localObject3);
      ((aml)localObject2).ajd(2);
      ((g)localObject1).field_favProto.ppH.add(localObject2);
      paramhb.dLn.path = g.t((g)localObject1);
      paramhb.dLn.thumbPath = ((String)localObject3);
      AppMethodBeat.o(103345);
      return;
    }
    if (paramhb.dLm.dLt == 3)
    {
      localObject1 = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(paramhb.dLm.dFW);
      if (localObject1 != null) {
        paramhb.dLn.path = (com.tencent.mm.model.z.aTY() + ";" + ((g)localObject1).field_fromUser + ";" + ((g)localObject1).field_updateTime);
      }
      AppMethodBeat.o(103345);
      return;
    }
    if (paramhb.dLm.dLt == 4)
    {
      b(paramhb);
      AppMethodBeat.o(103345);
      return;
    }
    if (paramhb.dLm.dLt == 5)
    {
      a(paramhb);
      AppMethodBeat.o(103345);
      return;
    }
    if (paramhb.dLm.dLt == 6)
    {
      localObject1 = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(paramhb.dLm.dFW);
      if (localObject1 == null)
      {
        paramhb.dLn.ret = 0;
        AppMethodBeat.o(103345);
        return;
      }
      paramhb = paramhb.dLn;
      if (((g)localObject1).field_id > 0) {}
      for (;;)
      {
        paramhb.ret = i;
        AppMethodBeat.o(103345);
        return;
        i = 0;
      }
    }
    Object localObject1 = new g();
    ((g)localObject1).field_type = 18;
    ((g)localObject1).field_favProto = paramhb.dLm.dGb;
    paramhb.dLn.path = g.t((g)localObject1);
    AppMethodBeat.o(103345);
  }
  
  public static void c(c paramc)
  {
    AppMethodBeat.i(103294);
    if (((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage() == null)
    {
      Log.e("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, getFavCdnStorage null");
      AppMethodBeat.o(103294);
      return;
    }
    int i = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().x(paramc.field_favLocalId, 1);
    Log.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, download data status:%d, favlocalId:%d", new Object[] { Integer.valueOf(i), Long.valueOf(paramc.field_favLocalId) });
    if (((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage() == null)
    {
      Log.e("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus getFavItemInfoStorage null");
      AppMethodBeat.o(103294);
      return;
    }
    g localg = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(paramc.field_favLocalId);
    if (localg == null)
    {
      Log.e("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus iteminfo null");
      AppMethodBeat.o(103294);
      return;
    }
    if ((localg.cUB()) || (localg.cUx()) || (localg.cUy()))
    {
      Log.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, status upload, skip. isWaitServerUpload:%b  isUploadding:%b  isUploadFailed:%b", new Object[] { Boolean.valueOf(localg.cUB()), Boolean.valueOf(localg.cUx()), Boolean.valueOf(localg.cUy()) });
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
      h.DS(localg.field_localId);
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(7, paramc.field_favLocalId);
      AppMethodBeat.o(103294);
      return;
      Log.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, error, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
      com.tencent.mm.plugin.report.service.h.CyF.a(10659, new Object[] { Integer.valueOf(1), Integer.valueOf(localg.field_type), Integer.valueOf(-5), Long.valueOf(b(localg)), Long.valueOf(h.DR(localg.field_localId)) });
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(8, paramc.field_favLocalId);
      AppMethodBeat.o(103294);
      return;
      Log.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus init, favLocalId:%d, favId:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id) });
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(10, paramc.field_favLocalId);
      AppMethodBeat.o(103294);
      return;
      Log.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus finish, favLocalId:%d, favId:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id) });
      com.tencent.mm.plugin.report.service.h.CyF.a(10659, new Object[] { Integer.valueOf(1), Integer.valueOf(localg.field_type), Integer.valueOf(0), Long.valueOf(b(localg)), Long.valueOf(h.DR(localg.field_localId)) });
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(10, paramc.field_favLocalId);
      AppMethodBeat.o(103294);
      return;
      Log.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus pause, favLocalId:%d, favId:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id) });
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(8, paramc.field_favLocalId);
    }
  }
  
  public static void c(String paramString, Context paramContext)
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
    com.tencent.mm.br.c.f(paramContext, ".ui.transmit.MsgRetransmitUI", localIntent);
    AppMethodBeat.o(103354);
  }
  
  private static Set<String> cUe()
  {
    AppMethodBeat.i(103273);
    Object localObject = (String)com.tencent.mm.kernel.g.aAh().azQ().get(225282, "");
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
  
  public static String cUf()
  {
    AppMethodBeat.i(103277);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.aAi();
    localObject = com.tencent.mm.kernel.g.aAh().hqG + "favorite/web/";
    AppMethodBeat.o(103277);
    return localObject;
  }
  
  public static void cUg()
  {
    AppMethodBeat.i(103281);
    Object localObject2 = cUe();
    if (((Set)localObject2).size() == 0)
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
      localObject1 = new ah((LinkedList)localObject1);
      com.tencent.mm.kernel.g.azz().a((com.tencent.mm.ak.q)localObject1, 0);
    }
    AppMethodBeat.o(103281);
  }
  
  public static long cUh()
  {
    AppMethodBeat.i(103300);
    long l2 = cUi() - cUj();
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 1024L;
    }
    AppMethodBeat.o(103300);
    return l1;
  }
  
  public static long cUi()
  {
    AppMethodBeat.i(103301);
    long l = ((Long)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NVD, Long.valueOf(0L))).longValue();
    AppMethodBeat.o(103301);
    return l;
  }
  
  public static long cUj()
  {
    AppMethodBeat.i(103302);
    long l = ((Long)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NVC, Long.valueOf(0L))).longValue();
    AppMethodBeat.o(103302);
    return l;
  }
  
  public static boolean cUk()
  {
    AppMethodBeat.i(103311);
    if (cUi() == 0L)
    {
      AppMethodBeat.o(103311);
      return false;
    }
    if (cUh() < 52428800L)
    {
      AppMethodBeat.o(103311);
      return true;
    }
    AppMethodBeat.o(103311);
    return false;
  }
  
  public static String cUl()
  {
    AppMethodBeat.i(103317);
    String str = com.tencent.mm.kernel.g.aAh().hqG + "favorite/music/";
    AppMethodBeat.o(103317);
    return str;
  }
  
  public static String cUm()
  {
    AppMethodBeat.i(103320);
    String str = com.tencent.mm.kernel.g.aAh().hqG + "favorite/";
    AppMethodBeat.o(103320);
    return str;
  }
  
  public static String cUn()
  {
    AppMethodBeat.i(103321);
    String str = com.tencent.mm.kernel.g.aAh().hqG + "favorite/voice/";
    AppMethodBeat.o(103321);
    return str;
  }
  
  public static boolean cUo()
  {
    AppMethodBeat.i(103328);
    if (ai.cVd() > 0)
    {
      AppMethodBeat.o(103328);
      return true;
    }
    AppMethodBeat.o(103328);
    return false;
  }
  
  public static boolean cUp()
  {
    AppMethodBeat.i(103337);
    if (cUi() == 0L)
    {
      AppMethodBeat.o(103337);
      return false;
    }
    if (cUh() < 10485760L)
    {
      AppMethodBeat.o(103337);
      return true;
    }
    AppMethodBeat.o(103337);
    return false;
  }
  
  public static boolean cUq()
  {
    AppMethodBeat.i(168688);
    if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sai, 0) != 1) && (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sbx, 0) == 1))
    {
      AppMethodBeat.o(168688);
      return true;
    }
    AppMethodBeat.o(168688);
    return false;
  }
  
  public static String d(aml paramaml)
  {
    AppMethodBeat.i(103278);
    if (paramaml == null)
    {
      AppMethodBeat.o(103278);
      return "";
    }
    Object localObject2 = paramaml.dLl;
    if ((Util.isNullOrNil((String)localObject2)) || (!com.tencent.mm.kernel.g.aAc()))
    {
      AppMethodBeat.o(103278);
      return "";
    }
    com.tencent.mm.vfs.o localo2 = arH((String)localObject2);
    int j = 0;
    int i = j;
    com.tencent.mm.vfs.o localo1 = localo2;
    Object localObject1 = localObject2;
    if (paramaml.dataType == 8)
    {
      i = j;
      localo1 = localo2;
      localObject1 = localObject2;
      if (!Util.isNullOrNil(paramaml.title))
      {
        localObject1 = paramaml.title;
        localo1 = arH(paramaml.dLl);
        i = 1;
      }
    }
    localObject2 = localObject1;
    if (paramaml.LvC != null)
    {
      localObject2 = localObject1;
      if (paramaml.LvC.trim().length() > 0)
      {
        localObject2 = localObject1;
        if (i == 0) {
          localObject2 = (String)localObject1 + "." + paramaml.LvC;
        }
      }
    }
    localObject1 = new com.tencent.mm.vfs.o(localo1, (String)localObject2);
    if ((((com.tencent.mm.vfs.o)localObject1).exists()) || (Util.isNullOrNil(paramaml.LvE)))
    {
      paramaml = com.tencent.mm.vfs.aa.z(((com.tencent.mm.vfs.o)localObject1).her());
      AppMethodBeat.o(103278);
      return paramaml;
    }
    localObject2 = com.tencent.mm.b.g.getMessageDigest((paramaml.LvE + paramaml.dLl).getBytes());
    if (Util.isNullOrNil((String)localObject2))
    {
      paramaml = com.tencent.mm.vfs.aa.z(((com.tencent.mm.vfs.o)localObject1).her());
      AppMethodBeat.o(103278);
      return paramaml;
    }
    localObject1 = localObject2;
    if (paramaml.LvC != null)
    {
      localObject1 = localObject2;
      if (paramaml.LvC.trim().length() > 0) {
        localObject1 = (String)localObject2 + "." + paramaml.LvC;
      }
    }
    localObject1 = new com.tencent.mm.vfs.o(localo1, (String)localObject1);
    if (((com.tencent.mm.vfs.o)localObject1).exists())
    {
      paramaml = com.tencent.mm.vfs.aa.z(((com.tencent.mm.vfs.o)localObject1).her());
      AppMethodBeat.o(103278);
      return paramaml;
    }
    localObject2 = paramaml.dLl;
    localObject1 = localObject2;
    if (paramaml.LvC != null)
    {
      localObject1 = localObject2;
      if (paramaml.LvC.trim().length() > 0) {
        localObject1 = (String)localObject2 + "." + paramaml.LvC;
      }
    }
    Log.d("MicroMsg.Fav.FavApiLogic", "use dataId.fmt, ".concat(String.valueOf(localObject1)));
    paramaml = com.tencent.mm.vfs.aa.z(new com.tencent.mm.vfs.o(localo1, (String)localObject1).her());
    AppMethodBeat.o(103278);
    return paramaml;
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
        if (!sZQ.containsKey(Long.valueOf(paramg.field_localId)))
        {
          AppMethodBeat.o(103269);
          continue;
        }
        if (sZQ.get(Long.valueOf(paramg.field_localId)) == null) {
          break label101;
        }
      }
      finally {}
      if (((ArrayList)sZQ.get(Long.valueOf(paramg.field_localId))).size() == 0)
      {
        label101:
        AppMethodBeat.o(103269);
      }
      else
      {
        String str = DJ(paramg.field_localId);
        Log.i("MicroMsg.Fav.FavApiLogic", "checkUpdateSnsNotePostXml, resend favlocal id:%d,xml:%s", new Object[] { Long.valueOf(paramg.field_localId), str });
        sm localsm = new sm();
        localsm.dZa.dZb = ((ArrayList)sZQ.get(Long.valueOf(paramg.field_localId)));
        localsm.dZa.dZc = str;
        EventCenter.instance.publish(localsm);
        sZQ.remove(Long.valueOf(paramg.field_localId));
        AppMethodBeat.o(103269);
      }
    }
  }
  
  public static void dC(List<Integer> paramList)
  {
    AppMethodBeat.i(103271);
    if (paramList.size() == 0)
    {
      Log.e("MicroMsg.Fav.FavApiLogic", "setDeleted list null");
      AppMethodBeat.o(103271);
      return;
    }
    Set localSet = cUe();
    Log.i("MicroMsg.Fav.FavApiLogic", "setDeleted before del:%s", new Object[] { localSet.toString() });
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Integer localInteger = (Integer)paramList.next();
      Log.i("MicroMsg.Fav.FavApiLogic", "setDeleted id:%d, ret:%b", new Object[] { localInteger, Boolean.valueOf(localSet.remove(localInteger.toString())) });
    }
    Log.i("MicroMsg.Fav.FavApiLogic", "setDeleted after del:%s", new Object[] { localSet.toString() });
    i(localSet);
    AppMethodBeat.o(103271);
  }
  
  public static boolean dD(List<g> paramList)
  {
    AppMethodBeat.i(103285);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      Log.w("MicroMsg.Fav.FavApiLogic", "delete fav item fail, item is null");
      AppMethodBeat.o(103285);
      return false;
    }
    Set localSet = cUe();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      g localg = (g)paramList.next();
      h(localg);
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavSearchStorage().Ea(localg.field_localId);
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().A(localg);
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().DW(localg.field_localId);
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavTagSetMgr().w(localg);
      localSet.add(localg.field_id);
      Log.d("MicroMsg.Fav.FavApiLogic", "delete id %d", new Object[] { Integer.valueOf(localg.field_id) });
    }
    i(localSet);
    cUg();
    AppMethodBeat.o(103285);
    return true;
  }
  
  public static String ds(String paramString, int paramInt)
  {
    AppMethodBeat.i(103260);
    paramString = com.tencent.mm.b.g.getMessageDigest((paramString + paramInt + System.currentTimeMillis()).getBytes());
    AppMethodBeat.o(103260);
    return paramString;
  }
  
  public static void e(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(103340);
    g localg = arP(paramString1);
    if (localg == null)
    {
      AppMethodBeat.o(103340);
      return;
    }
    oc localoc = new oc();
    localoc.dUe.type = 2;
    localoc.dUe.field_localId = -1L;
    localoc.dUe.context = paramContext;
    localoc.dUe.dUn = 4;
    localoc.dUe.dUo = true;
    paramContext = new Bundle();
    paramContext.putString("noteauthor", localg.field_favProto.KBr.LxT);
    paramContext.putString("noteeditor", localg.field_favProto.KBr.LxU);
    paramContext.putLong("edittime", localg.field_favProto.rnM);
    paramContext.putString("notexml", g.t(localg));
    paramContext.putString("snslocalid", paramString2);
    paramContext.putString("snsthumbpath", paramString3);
    paramContext.putString("snsnotelinkxml", paramString1);
    localoc.dUe.dUl = paramContext;
    localoc.dUe.field_favProto = localg.field_favProto;
    EventCenter.instance.publish(localoc);
    AppMethodBeat.o(103340);
  }
  
  public static void e(aml paramaml)
  {
    AppMethodBeat.i(103309);
    c localc = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(paramaml.dLl);
    if ((localc != null) && (localc.field_status != 3))
    {
      localc.field_status = 2;
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().pauseDownload(paramaml.dLl);
    }
    localc = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(arI(paramaml.dLl));
    if ((localc != null) && (localc.field_status != 3))
    {
      localc.field_status = 2;
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().pauseDownload(arI(paramaml.dLl));
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
    paramg = paramg.field_favProto.ppH.iterator();
    aml localaml;
    do
    {
      if (!paramg.hasNext()) {
        break;
      }
      localaml = (aml)paramg.next();
    } while (((localaml.dataType != 8) && (localaml.dataType != 4) && (localaml.dataType != 2) && (localaml.dataType != 3)) || ((!Util.isNullOrNil(localaml.KuR)) && (!Util.isNullOrNil(localaml.Lvp))));
    for (boolean bool = false;; bool = true)
    {
      AppMethodBeat.o(103270);
      return bool;
    }
  }
  
  public static boolean f(g paramg)
  {
    AppMethodBeat.i(103280);
    if (paramg.field_favProto == null)
    {
      AppMethodBeat.o(103280);
      return false;
    }
    paramg = paramg.field_favProto.ppH.iterator();
    while (paramg.hasNext())
    {
      aml localaml = (aml)paramg.next();
      if (localaml.Lwv == 2)
      {
        AppMethodBeat.o(103280);
        return true;
      }
      if (localaml.Lwv == 1)
      {
        AppMethodBeat.o(103280);
        return true;
      }
    }
    AppMethodBeat.o(103280);
    return false;
  }
  
  public static boolean f(aml paramaml)
  {
    AppMethodBeat.i(103316);
    f localf = com.tencent.mm.ay.a.bef();
    if ((localf != null) && (localf.jeT == 6) && (Util.nullAs(paramaml.dLl, "").equals(localf.jeV)) && (com.tencent.mm.ay.a.bec()))
    {
      AppMethodBeat.o(103316);
      return true;
    }
    AppMethodBeat.o(103316);
    return false;
  }
  
  public static void fh(Context paramContext)
  {
    AppMethodBeat.i(199699);
    if (0L >= sZR)
    {
      Log.i("MicroMsg.Fav.FavApiLogic", "addTagWhenAddToFav,try to add tag ,but favLocalId is null, return");
      AppMethodBeat.o(199699);
      return;
    }
    g localg = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(sZR);
    sZR = 0L;
    if (localg == null)
    {
      Log.i("MicroMsg.Fav.FavApiLogic", "addTagWhenAddToFav,try to add tag ,but iteminfo is null, return");
      AppMethodBeat.o(199699);
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
    AppMethodBeat.o(199699);
  }
  
  public static boolean g(g paramg)
  {
    if (paramg == null) {}
    while ((paramg.field_itemStatus != 8) && (paramg.field_itemStatus != 10) && (paramg.field_itemStatus != 7)) {
      return false;
    }
    return true;
  }
  
  public static boolean g(aml paramaml)
  {
    AppMethodBeat.i(103326);
    boolean bool = new com.tencent.mm.vfs.o(d(paramaml)).exists();
    AppMethodBeat.o(103326);
    return bool;
  }
  
  private static String gE(String paramString1, String paramString2)
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
  
  public static String getAppName(Context paramContext, String paramString)
  {
    AppMethodBeat.i(103318);
    am.b localb = am.a.iDo;
    if (localb != null)
    {
      paramContext = localb.r(paramContext, paramString);
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
  
  private static void h(g paramg)
  {
    AppMethodBeat.i(103282);
    Set localSet = ao.tbJ;
    paramg = paramg.field_favProto.ppH;
    int i = 0;
    while (i < paramg.size())
    {
      Object localObject = a((aml)paramg.get(i));
      if ((localSet == null) || (!localSet.contains(localObject))) {
        s.deleteFile((String)localObject);
      }
      localObject = d((aml)paramg.get(i));
      if ((localSet == null) || (!localSet.contains(localObject))) {
        s.deleteFile((String)localObject);
      }
      localObject = (aml)paramg.get(i);
      if ((((aml)localObject).Lwh != null) && (((aml)localObject).Lwh.Lxi != null)) {
        com.tencent.mm.modelvideo.u.QM(((aml)localObject).dLl);
      }
      i += 1;
    }
    AppMethodBeat.o(103282);
  }
  
  public static boolean h(aml paramaml)
  {
    AppMethodBeat.i(103327);
    boolean bool = ImgUtil.isGif(d(paramaml));
    AppMethodBeat.o(103327);
    return bool;
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
      if (paramg.field_favProto.LwS != null) {
        str1 = paramg.field_favProto.LwS.LyC;
      }
      String str2 = str1;
      if (paramg.field_favProto.Lya != null)
      {
        str2 = str1;
        if (Util.isNullOrNil(str1)) {
          str2 = paramg.field_favProto.Lya.link;
        }
      }
      paramg = new gv();
      paramg.dKQ.url = str2;
      EventCenter.instance.publish(paramg);
    }
    AppMethodBeat.o(103288);
  }
  
  private static void i(Set<String> paramSet)
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
    com.tencent.mm.kernel.g.aAh().azQ().set(225282, paramSet);
    AppMethodBeat.o(103272);
  }
  
  public static void j(g paramg)
  {
    AppMethodBeat.i(103290);
    j localj = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavSearchStorage().Eb(paramg.field_localId);
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
      if (paramg.field_favProto.Lya != null)
      {
        localObject1 = paramg.field_favProto.Lya;
        if (!Util.isNullOrNil(((anh)localObject1).dRL))
        {
          localStringBuffer.append(((anh)localObject1).dRL);
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(((anh)localObject1).dRL);
          if (localObject2 != null) {
            localStringBuffer.append(((ax)localObject2).field_nickname).append(((ax)localObject2).field_conRemark);
          }
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(((anh)localObject1).toUser);
          if (localObject2 != null) {
            localStringBuffer.append(((ax)localObject2).field_nickname).append(((ax)localObject2).field_conRemark);
          }
          localStringBuffer.append(((anh)localObject1).LxA);
        }
      }
      Object localObject1 = paramg.field_favProto.ppH;
      localj.field_subtype = 0;
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (aml)((Iterator)localObject1).next();
        if (((aml)localObject2).desc != null) {
          localStringBuffer.append(((aml)localObject2).desc);
        }
        if (((aml)localObject2).title != null) {
          localStringBuffer.append(((aml)localObject2).title);
        }
        int j = ((aml)localObject2).dataType;
        int k = localj.field_subtype;
        localj.field_subtype = (j.HV(j) | k);
      }
      if (paramg.field_favProto.LwS != null)
      {
        if (paramg.field_favProto.LwS.desc != null) {
          localStringBuffer.append(paramg.field_favProto.LwS.desc);
        }
        if (paramg.field_favProto.LwS.title != null) {
          localStringBuffer.append(paramg.field_favProto.LwS.title);
        }
      }
      if (paramg.field_favProto.LwU != null)
      {
        if (paramg.field_favProto.LwU.desc != null) {
          localStringBuffer.append(paramg.field_favProto.LwU.desc);
        }
        if (paramg.field_favProto.LwU.title != null) {
          localStringBuffer.append(paramg.field_favProto.LwU.title);
        }
      }
      if (paramg.field_favProto.Lxk != null)
      {
        if (paramg.field_favProto.Lxk.nickname != null) {
          localStringBuffer.append(paramg.field_favProto.Lxk.nickname);
        }
        if (paramg.field_favProto.Lxk.desc != null) {
          localStringBuffer.append(paramg.field_favProto.Lxk.desc);
        }
      }
      localj.field_tagContent = "";
      localObject1 = paramg.field_tagProto.Lyn.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localj.field_tagContent = (localj.field_tagContent + " " + (String)localObject2);
        localStringBuffer.append((String)localObject2);
      }
      localObject1 = paramg.field_tagProto.Lyo.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localj.field_tagContent = (localj.field_tagContent + " " + (String)localObject2);
        localStringBuffer.append((String)localObject2);
        ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavTagSetMgr().arV((String)localObject2);
      }
      localj.field_content = localStringBuffer.toString();
      localj.field_time = paramg.field_updateTime;
      localj.field_type = paramg.field_type;
      if (i != 0)
      {
        ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavSearchStorage().a(localj);
        AppMethodBeat.o(103290);
        return;
      }
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavSearchStorage().a(localj, new String[] { "localId" });
      AppMethodBeat.o(103290);
      return;
    }
  }
  
  public static boolean k(g paramg)
  {
    AppMethodBeat.i(103298);
    if (((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(paramg.field_localId) != null)
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
    if (!paramg.cUy())
    {
      Log.f("MicroMsg.Fav.FavApiLogic", "restartItemUpload status not upload failed!");
      AppMethodBeat.o(103305);
      return;
    }
    switch (paramg.field_itemStatus)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(103305);
      return;
      paramg.field_itemStatus = 1;
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getCheckCdnService().run();
      AppMethodBeat.o(103305);
      return;
      if (((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().DT(paramg.field_localId).size() == 0)
      {
        paramg.field_itemStatus = 9;
        ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
        paramg = new ag(paramg);
        com.tencent.mm.kernel.g.azz().a(paramg, 0);
        AppMethodBeat.o(103305);
        return;
      }
      paramg.field_itemStatus = 4;
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().y(paramg);
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
      Iterator localIterator = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().DT(paramg.field_localId).iterator();
      c localc;
      while (localIterator.hasNext())
      {
        localc = (c)localIterator.next();
        Log.i("MicroMsg.Fav.FavApiLogic", "force upload favItem[last failed], favid:%d localId:%d, dataId:%s, dataType:%d totalLength %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), localc.field_dataId, Integer.valueOf(localc.field_dataType), Integer.valueOf(localc.field_totalLen) });
        ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().arY(localc.field_dataId);
      }
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().run();
      AppMethodBeat.o(103305);
      return;
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(12, paramg.field_localId);
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getSendService().run();
      AppMethodBeat.o(103305);
      return;
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(15, paramg.field_localId);
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().y(paramg);
      localIterator = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().DT(paramg.field_localId).iterator();
      while (localIterator.hasNext())
      {
        localc = (c)localIterator.next();
        Log.i("MicroMsg.Fav.FavApiLogic", "force upload favItem[last mod failed], favid:%d localId:%d, dataId:%s, dataType:%d totalLength %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), localc.field_dataId, Integer.valueOf(localc.field_dataType), Integer.valueOf(localc.field_totalLen) });
        ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().arY(localc.field_dataId);
      }
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().run();
      AppMethodBeat.o(103305);
      return;
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(17, paramg.field_localId);
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getModService().run();
      AppMethodBeat.o(103305);
      return;
      paramg.field_itemStatus = 9;
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getSendService().run();
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
      Object localObject = paramg.field_favProto.ppH;
      if (((List)localObject).size() == 0)
      {
        AppMethodBeat.o(103306);
        return;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        aml localaml = (aml)((Iterator)localObject).next();
        a(paramg, localaml, true);
        a(paramg, localaml);
      }
      AppMethodBeat.o(103306);
      return;
    }
    Log.e("MicroMsg.Fav.FavApiLogic", "status not download failed or done!");
    AppMethodBeat.o(103306);
  }
  
  public static void n(g paramg)
  {
    AppMethodBeat.i(103310);
    if (!paramg.cUx())
    {
      Log.e("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, not uploading");
      AppMethodBeat.o(103310);
      return;
    }
    Log.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, itemStatu:%d", new Object[] { Integer.valueOf(paramg.field_itemStatus) });
    Iterator localIterator = paramg.field_favProto.ppH.iterator();
    while (localIterator.hasNext())
    {
      aml localaml = (aml)localIterator.next();
      c localc = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(localaml.dLl);
      if ((localc != null) && (localc.field_status != 3))
      {
        localc.field_status = 2;
        ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
        ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().arZ(localaml.dLl);
      }
      localc = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(arI(localaml.dLl));
      if ((localc != null) && (localc.field_status != 3))
      {
        localc.field_status = 2;
        ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
        ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().arZ(arI(localaml.dLl));
      }
    }
    paramg = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(paramg.field_localId);
    Log.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, after pause data itemStatu:%d", new Object[] { Integer.valueOf(paramg.field_itemStatus) });
    switch (paramg.field_itemStatus)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(103310);
      return;
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(3, paramg.field_localId);
      Log.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(3) });
      AppMethodBeat.o(103310);
      return;
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(6, paramg.field_localId);
      Log.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(6) });
      AppMethodBeat.o(103310);
      return;
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(11, paramg.field_localId);
      Log.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(11) });
      AppMethodBeat.o(103310);
      return;
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(14, paramg.field_localId);
      Log.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(14) });
      AppMethodBeat.o(103310);
      return;
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(16, paramg.field_localId);
      Log.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(16) });
      AppMethodBeat.o(103310);
      return;
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(18, paramg.field_localId);
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
    aml localaml = c(paramg);
    if (localaml == null)
    {
      AppMethodBeat.o(103319);
      return false;
    }
    long l = Util.currentTicks();
    com.tencent.mm.plugin.sight.base.a locala = com.tencent.mm.plugin.sight.base.e.aNx(d(localaml));
    int j;
    int i;
    boolean bool;
    if (locala != null)
    {
      j = locala.getVideoDuration();
      i = localaml.duration;
      if ((i <= 0) || (Math.abs(i - j) >= 2))
      {
        localaml.ajc(j);
        bool = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
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
    j localj = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavSearchStorage().Eb(paramg.field_localId);
    if (localj == null)
    {
      localj = new j();
      localj.field_localId = paramg.field_localId;
    }
    for (int i = 1;; i = 0)
    {
      localj.field_tagContent = "";
      Iterator localIterator = paramg.field_tagProto.Lyn.iterator();
      String str;
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        localj.field_tagContent = (localj.field_tagContent + " " + str);
      }
      localIterator = paramg.field_tagProto.Lyo.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        localj.field_tagContent = (localj.field_tagContent + " " + str);
        ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavTagSetMgr().arV(str);
      }
      localj.field_time = paramg.field_updateTime;
      localj.field_type = paramg.field_type;
      if (i != 0)
      {
        ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavSearchStorage().a(localj);
        AppMethodBeat.o(103332);
        return;
      }
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavSearchStorage().a(localj, new String[] { "localId" });
      AppMethodBeat.o(103332);
      return;
    }
  }
  
  public static void q(g paramg)
  {
    AppMethodBeat.i(103344);
    if (paramg == null)
    {
      AppMethodBeat.o(103344);
      return;
    }
    amv localamv = paramg.field_favProto.KBr;
    if ((localamv != null) && (!Util.isNullOrNil(localamv.LxU)))
    {
      AppMethodBeat.o(103344);
      return;
    }
    if (paramg.field_type == 18)
    {
      if (paramg.field_favProto.Lya.sourceType != 6) {
        break label112;
      }
      b(paramg, false);
    }
    for (;;)
    {
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
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
      paramg = paramg.field_favProto.ppH.iterator();
      l = 0L;
      if (paramg.hasNext())
      {
        localObject = (aml)paramg.next();
        if (localObject == null) {
          break label467;
        }
        l = ((aml)localObject).LvI + l;
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
          paramg = paramg.field_favProto.LwS.LyC;
          localStringBuffer.append(paramg);
          break;
          if (paramg == null) {
            break;
          }
          paramg = paramg.field_favProto.ppH.iterator();
          int i = 0;
          int m = 0;
          int k = 0;
          int j = 0;
          while (paramg.hasNext())
          {
            localObject = (aml)paramg.next();
            switch (((aml)localObject).dataType)
            {
            case 3: 
            default: 
              i += 1;
              break;
            case 1: 
              if (Util.isNullOrNil(((aml)localObject).desc)) {
                break label464;
              }
              k = ((aml)localObject).desc.getBytes().length + k;
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
    ak localak = new ak();
    com.tencent.mm.kernel.g.azz().a(localak, 0);
    AppMethodBeat.o(103324);
  }
  
  public static long v(long paramLong, int paramInt)
  {
    AppMethodBeat.i(103323);
    Log.i("MicroMsg.Fav.FavApiLogic", "tryStartBatchGet...");
    long l1 = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().C(paramLong, paramInt);
    long l2 = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().A(paramLong, paramInt);
    Log.i("MicroMsg.Fav.FavApiLogic", "klem, tryStartBatchGet, batchGetTime:%d, itemTiem:%d, updateTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(paramLong) });
    if (l1 == 0L)
    {
      AppMethodBeat.o(103323);
      return l2;
    }
    Object localObject = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().B(l1, paramInt);
    if (((LinkedList)localObject).size() > 0)
    {
      Log.i("MicroMsg.Fav.FavApiLogic", "klem, tryStartBatchGet, batchGetTime:%d, itemTiem:%d, updateTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(paramLong) });
      Log.i("MicroMsg.Fav.FavApiLogic", "klem, tryStartBatchGet, need batch get idList size:%d", new Object[] { Integer.valueOf(((LinkedList)localObject).size()) });
      localObject = new ai((LinkedList)localObject);
      if (!com.tencent.mm.kernel.g.azz().a((com.tencent.mm.ak.q)localObject, 0))
      {
        Log.w("MicroMsg.Fav.FavApiLogic", "do scene BatchGetFav fail");
        ai.cVc();
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
  
  public static void v(Intent paramIntent, Context paramContext)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.b
 * JD-Core Version:    0.7.0.1
 */