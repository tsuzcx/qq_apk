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
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.cx;
import com.tencent.mm.f.a.hc;
import com.tencent.mm.f.a.hi;
import com.tencent.mm.f.a.hi.a;
import com.tencent.mm.f.a.hi.b;
import com.tencent.mm.f.a.oz;
import com.tencent.mm.f.a.tn;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.anr;
import com.tencent.mm.protocal.protobuf.ant;
import com.tencent.mm.protocal.protobuf.anw;
import com.tencent.mm.protocal.protobuf.aob;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.aol;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.protocal.protobuf.aor;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.protocal.protobuf.cyi;
import com.tencent.mm.protocal.protobuf.cyl;
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
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
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
  private static HashMap<Long, ArrayList<String>> wFU;
  private static long wFV;
  
  static
  {
    AppMethodBeat.i(103360);
    wFU = new HashMap();
    wFV = 0L;
    AppMethodBeat.o(103360);
  }
  
  public static float GW(long paramLong)
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
  
  public static void JV(long paramLong)
  {
    AppMethodBeat.i(103265);
    Log.i("MicroMsg.Fav.FavApiLogic", "setUsedCapacity:%d", new Object[] { Long.valueOf(paramLong) });
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VjC, Long.valueOf(paramLong));
    AppMethodBeat.o(103265);
  }
  
  public static void JW(long paramLong)
  {
    AppMethodBeat.i(103266);
    Log.i("MicroMsg.Fav.FavApiLogic", "setTotalCapacity:%d", new Object[] { Long.valueOf(paramLong) });
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VjD, Long.valueOf(paramLong));
    AppMethodBeat.o(103266);
  }
  
  private static String JX(long paramLong)
  {
    AppMethodBeat.i(103267);
    StringBuilder localStringBuilder = new StringBuilder();
    g localg = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(paramLong);
    if ((localg == null) || (localg.field_favProto == null) || (localg.field_favProto.syG.size() <= 1))
    {
      AppMethodBeat.o(103267);
      return "";
    }
    anw localanw = localg.field_favProto.RDh;
    String str2 = "";
    String str1 = "";
    if (localanw != null)
    {
      str2 = localanw.SAv;
      str1 = localanw.SAu;
    }
    localStringBuilder.append("<noteinfo>");
    localStringBuilder.append("<noteauthor>").append(str1).append("</noteauthor>");
    localStringBuilder.append("<noteeditor>").append(str2).append("</noteeditor>");
    localStringBuilder.append("<edittime>").append(localg.field_favProto.uTt).append("</edittime>");
    localStringBuilder.append("<editusr>").append(str1).append("</editusr>");
    localStringBuilder.append("<favlocalid>").append(localg.field_localId).append("</favlocalid>");
    localStringBuilder.append(com.tencent.mm.plugin.fav.a.a.a.dK(localg.field_favProto.syG).replace("cdn_dataurl", "cdndataurl").replace("cdn_datakey", "cdndatakey").replace("cdn_thumburl", "cdnthumburl").replace("cdn_thumbkey", "cdnthumbkey").replace("thumbfullsize", "thumbsize").replace("fullsize", "datasize").replace("datasrcname", "sourcename").replace("datasrctime", "sourcetime").replace("stream_lowbandurl", "streamlowbandurl").replace("stream_dataurl", "streamdataurl").replace("stream_weburl", "streamweburl"));
    localStringBuilder.append("</noteinfo>");
    str1 = localStringBuilder.toString();
    AppMethodBeat.o(103267);
    return str1;
  }
  
  public static void JY(long paramLong)
  {
    AppMethodBeat.i(103274);
    MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putLong("fav_mx_auto_download_size", paramLong).commit();
    AppMethodBeat.o(103274);
  }
  
  public static void JZ(long paramLong)
  {
    AppMethodBeat.i(103275);
    MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putLong("fav_mx_auto_upload_size", paramLong).commit();
    AppMethodBeat.o(103275);
  }
  
  public static void Ka(long paramLong)
  {
    AppMethodBeat.i(103276);
    MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putLong("fav_mx_file_size", paramLong).commit();
    AppMethodBeat.o(103276);
  }
  
  public static void Kb(long paramLong)
  {
    wFV = paramLong;
  }
  
  public static float Kc(long paramLong)
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
  
  public static String Kd(long paramLong)
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
  
  public static boolean LC(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = a.wFS;
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
  
  public static String LQ(String paramString)
  {
    AppMethodBeat.i(203954);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(203954);
      return "";
    }
    paramString = azJ(paramString);
    paramString = new com.tencent.mm.vfs.q(azI(paramString), paramString).bOF();
    AppMethodBeat.o(203954);
    return paramString;
  }
  
  public static String PK(String paramString)
  {
    AppMethodBeat.i(103304);
    Object localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramString);
    if (localObject == null)
    {
      Log.w("MicroMsg.Fav.FavApiLogic", "wtf get contact null, username %s", new Object[] { paramString });
      AppMethodBeat.o(103304);
      return "";
    }
    String str = ((as)localObject).ays();
    localObject = str;
    if (com.tencent.mm.model.ab.Lj(str))
    {
      paramString = com.tencent.mm.model.v.Ps(paramString);
      localObject = z.bcZ();
      if ((paramString != null) && (!paramString.isEmpty())) {
        break label110;
      }
      Log.w("MicroMsg.Fav.FavApiLogic", "get members from username error, content empty");
    }
    for (localObject = str;; localObject = com.tencent.mm.model.v.e(paramString, 3))
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
    Object localObject = a.wFS;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      if (localObject[i] == paramg.field_type)
      {
        if (paramg.field_favProto != null)
        {
          localObject = paramg.field_favProto.syG.iterator();
          for (long l1 = 0L;; l1 = ((anm)((Iterator)localObject).next()).Syi + l1)
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
  
  public static g a(aoc paramaoc)
  {
    AppMethodBeat.i(103342);
    g localg = new g();
    localg.field_favProto = new aoc();
    localg.field_type = 18;
    localg.field_favProto = paramaoc;
    AppMethodBeat.o(103342);
    return localg;
  }
  
  public static anm a(g paramg, String paramString)
  {
    AppMethodBeat.i(103292);
    if ((Util.isNullOrNil(paramString)) || (paramg == null) || (paramg.field_favProto.syG.size() == 0))
    {
      AppMethodBeat.o(103292);
      return null;
    }
    paramg = paramg.field_favProto.syG.iterator();
    while (paramg.hasNext())
    {
      anm localanm = (anm)paramg.next();
      if (localanm.fEa.equals(paramString))
      {
        AppMethodBeat.o(103292);
        return localanm;
      }
    }
    AppMethodBeat.o(103292);
    return null;
  }
  
  public static anr a(int paramInt, aoc paramaoc, aop paramaop)
  {
    AppMethodBeat.i(103262);
    if (paramaoc == null)
    {
      Log.w("MicroMsg.Fav.FavApiLogic", "proto item is null");
      AppMethodBeat.o(103262);
      return null;
    }
    anr localanr = new anr();
    aoi localaoi = paramaoc.SAB;
    if (localaoi != null)
    {
      localanr.fLi = localaoi.fLi;
      localanr.SAm = localaoi.SAb;
      localanr.appId = localaoi.appId;
      localanr.fuO = localaoi.fuO;
    }
    if (paramaop != null)
    {
      if (paramaop.SAO != null) {
        localanr.SAn.addAll(paramaop.SAO);
      }
      if (paramaop.SAP != null) {
        localanr.SAn.addAll(paramaop.SAP);
      }
    }
    localanr.fRz = paramaoc;
    localanr.type = paramInt;
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
      return localanr;
    case 1: 
      localanr.title = "";
      localanr.desc = paramaoc.desc;
      AppMethodBeat.o(103262);
      return localanr;
    case 4: 
      if ((paramaoc.syG != null) && (!paramaoc.syG.isEmpty())) {
        localanr.title = ((anm)paramaoc.syG.get(0)).title;
      }
      AppMethodBeat.o(103262);
      return localanr;
    case 5: 
      if (paramaoc.Szr != null)
      {
        localanr.title = paramaoc.Szr.title;
        localanr.desc = paramaoc.Szr.SBc;
      }
      if ((Util.isNullOrNil(localanr.title)) && (paramaoc.syG != null) && (!paramaoc.syG.isEmpty())) {
        localanr.title = ((anm)paramaoc.syG.get(0)).title;
      }
      if ((Util.isNullOrNil(localanr.desc)) && (localaoi != null)) {
        localanr.desc = localaoi.link;
      }
      AppMethodBeat.o(103262);
      return localanr;
    case 6: 
      localanr.title = paramaoc.remark;
      if (Util.isNullOrNil(localanr.title)) {
        if (paramaoc.Szp != null)
        {
          localanr.title = paramaoc.Szp.fPN;
          localanr.desc = paramaoc.Szp.label;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(103262);
        return localanr;
        if (paramaoc.Szp != null) {
          localanr.desc = paramaoc.Szp.fPN;
        }
      }
    case 2: 
      if ((paramaoc.syG != null) && (paramaoc.syG.size() > 0)) {
        localanr.title = ((anm)paramaoc.syG.get(0)).title;
      }
      AppMethodBeat.o(103262);
      return localanr;
    case 7: 
    case 21: 
      if ((paramaoc.syG != null) && (!paramaoc.syG.isEmpty()))
      {
        localanr.title = ((anm)paramaoc.syG.get(0)).title;
        localanr.desc = ((anm)paramaoc.syG.get(0)).desc;
      }
      AppMethodBeat.o(103262);
      return localanr;
    case 8: 
      localanr.title = paramaoc.title;
      if ((Util.isNullOrNil(localanr.title)) && (paramaoc.syG != null) && (!paramaoc.syG.isEmpty())) {
        localanr.title = ((anm)paramaoc.syG.get(0)).title;
      }
      AppMethodBeat.o(103262);
      return localanr;
    case 10: 
    case 11: 
      if (paramaoc.Szt != null)
      {
        localanr.title = paramaoc.Szt.title;
        localanr.desc = paramaoc.Szt.desc;
      }
      AppMethodBeat.o(103262);
      return localanr;
    case 12: 
    case 15: 
      if (paramaoc.Szv != null)
      {
        localanr.title = paramaoc.Szv.title;
        localanr.desc = paramaoc.Szv.desc;
      }
      AppMethodBeat.o(103262);
      return localanr;
    }
    paramaoc = paramaoc.syG;
    if (paramaoc == null)
    {
      AppMethodBeat.o(103262);
      return null;
    }
    paramaoc = paramaoc.iterator();
    while (paramaoc.hasNext())
    {
      paramaop = (anm)paramaoc.next();
      if (1 == paramaop.dataType) {
        localanr.title = paramaop.desc;
      }
    }
    AppMethodBeat.o(103262);
    return localanr;
  }
  
  public static String a(anm paramanm)
  {
    AppMethodBeat.i(103283);
    if ((paramanm == null) || (Util.isNullOrNil(paramanm.fEa)))
    {
      AppMethodBeat.o(103283);
      return "";
    }
    paramanm = azJ(paramanm.fEa);
    paramanm = new com.tencent.mm.vfs.q(azI(paramanm), paramanm).bOF();
    AppMethodBeat.o(103283);
    return paramanm;
  }
  
  private static ArrayList<g> a(List<String> paramList, ArrayList<g> paramArrayList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(203992);
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
        LinkedList localLinkedList = localg.field_favProto.syG;
        if (localg.field_type != 18) {
          break label457;
        }
        i = 1;
        if (i >= localLinkedList.size()) {
          break;
        }
        anm localanm = (anm)localLinkedList.get(i);
        if (localanm.dataType != paramInt1) {
          break label471;
        }
        if (!Util.isNullOrNil(localanm.title))
        {
          paramArrayList = localanm.title;
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
          paramArrayList = localg.djI();
          paramArrayList.field_type = paramInt2;
          paramArrayList.wGh = true;
          paramArrayList.wGi = localg;
          paramArrayList.fDQ = (localg.field_localId + "_" + localanm.fEa);
          paramArrayList.wGj = localanm.fEa;
          paramArrayList.field_favProto = com.tencent.mm.plugin.fav.a.a.c.c(localg.field_favProto);
          paramArrayList.field_favProto.syG = new LinkedList();
          paramArrayList.field_favProto.syG.add(localanm);
          paramArrayList.field_favProto.btv(localanm.title);
          if (localanm.SyG != null)
          {
            if (paramInt1 == 6) {
              paramArrayList.field_favProto.d(localanm.SyG.Szp);
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
          paramArrayList = localanm.desc;
          continue;
        }
        if (paramInt1 != 5) {
          continue;
        }
        paramArrayList.field_favProto.c(localanm.SyG.Szr);
        continue;
      }
      catch (Exception paramArrayList)
      {
        Log.e("MicroMsg.Fav.FavApiLogic", "getSearchList() [%s] Exception:%s %s", new Object[] { Integer.valueOf(paramInt1), paramArrayList.getClass().getSimpleName(), paramArrayList.getMessage() });
      }
      localArrayList.add(localg);
      break;
      AppMethodBeat.o(203992);
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
    paramList2 = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavSearchStorage().b(paramList1, paramList2, localArrayList1);
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
        localArrayList2 = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().a(paramList2.subList(j, i), paramList, paramSet, paramx);
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
  
  public static ArrayList<g> a(List<String> paramList1, List<String> paramList2, List<Integer> paramList, List<g> paramList3, Set<Integer> paramSet, x paramx)
  {
    AppMethodBeat.i(103335);
    paramList1 = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavSearchStorage().b(paramList1, paramList2, paramList);
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
        localObject = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().a(paramList1.subList(j, i), paramList3, paramSet, paramx);
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
                LinkedList localLinkedList = localg.field_favProto.syG;
                j = 1;
                if (j >= localLinkedList.size()) {
                  continue;
                }
                int k = ((anm)localLinkedList.get(j)).dataType;
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
  
  public static List<g> a(long paramLong, int paramInt, Set<Integer> paramSet, x paramx)
  {
    AppMethodBeat.i(103322);
    if (((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage() == null)
    {
      Log.e("MicroMsg.Fav.FavApiLogic", "getItemList error, getFavItemInfoStorage null.");
      AppMethodBeat.o(103322);
      return null;
    }
    if (paramLong == 0L)
    {
      paramSet = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().a(paramInt, paramSet, paramx);
      AppMethodBeat.o(103322);
      return paramSet;
    }
    paramSet = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().b(paramLong, paramInt, paramSet, paramx);
    AppMethodBeat.o(103322);
    return paramSet;
  }
  
  public static void a(long paramLong, ant paramant, String paramString1, String paramString2, ArrayList<String> paramArrayList, Context paramContext)
  {
    AppMethodBeat.i(103355);
    if ((paramant == null) || (paramContext == null))
    {
      AppMethodBeat.o(103355);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("KFavLocSigleView", true);
    localIntent.putExtra("map_view_type", 2);
    localIntent.putExtra("kFavInfoLocalId", paramLong);
    localIntent.putExtra("kwebmap_slat", paramant.lat);
    localIntent.putExtra("kwebmap_lng", paramant.lng);
    localIntent.putExtra("kPoiName", paramant.fPN);
    localIntent.putExtra("Kwebmap_locaion", paramant.label);
    if (paramant.fKJ >= 0) {
      localIntent.putExtra("kwebmap_scale", paramant.fKJ);
    }
    localIntent.putExtra("kisUsername", paramString1);
    localIntent.putExtra("kwebmap_from_to", true);
    localIntent.putExtra("kRemark", paramString2);
    localIntent.putExtra("kTags", paramArrayList);
    localIntent.putExtra("kFavCanDel", true);
    localIntent.putExtra("kFavCanRemark", true);
    com.tencent.mm.by.c.b(paramContext, "location", ".ui.RedirectUI", localIntent);
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
        paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramBundle).bm(localIntent);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aFh(), "com/tencent/mm/plugin/fav/api/FavApiLogic", "startFavActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
        paramContext.startActivity((Intent)paramString.sf(0), (Bundle)paramString.sf(1));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/fav/api/FavApiLogic", "startFavActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
        AppMethodBeat.o(103348);
        return;
      }
      localIntent.addFlags(268435456);
      paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramBundle).bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aFh(), "com/tencent/mm/plugin/fav/api/FavApiLogic", "startFavActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
      paramContext.startActivity((Intent)paramString.sf(0), (Bundle)paramString.sf(1));
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
  
  private static void a(hi paramhi)
  {
    AppMethodBeat.i(103268);
    if (Util.isNullOrNil(paramhi.fEb.desc))
    {
      paramhi.fEc.ret = -1;
      AppMethodBeat.o(103268);
      return;
    }
    Object localObject = azQ(paramhi.fEb.desc);
    if ((localObject == null) || (((g)localObject).field_localId <= 0L))
    {
      paramhi.fEc.ret = -1;
      AppMethodBeat.o(103268);
      return;
    }
    boolean bool = e((g)localObject);
    String str = paramhi.fEb.fEh;
    if (bool)
    {
      paramhi.fEc.ret = 1;
      paramhi = (ArrayList)wFU.get(Long.valueOf(((g)localObject).field_localId));
      if (paramhi != null)
      {
        if (paramhi.contains(str)) {
          paramhi.remove(str);
        }
        if (paramhi.size() == 0) {
          wFU.remove(Long.valueOf(((g)localObject).field_localId));
        }
      }
      AppMethodBeat.o(103268);
      return;
    }
    if (Util.isNullOrNil(str))
    {
      paramhi.fEc.ret = -1;
      AppMethodBeat.o(103268);
      return;
    }
    long l = ((g)localObject).field_localId;
    ArrayList localArrayList = (ArrayList)wFU.get(Long.valueOf(l));
    localObject = localArrayList;
    if (localArrayList == null) {
      localObject = new ArrayList();
    }
    ((ArrayList)localObject).add(str);
    wFU.put(Long.valueOf(l), localObject);
    localObject = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(l);
    if ((localObject == null) || (((g)localObject).field_localId <= 0L))
    {
      paramhi.fEc.ret = -1;
      AppMethodBeat.o(103268);
      return;
    }
    if ((e((g)localObject)) || (((g)localObject).field_itemStatus == 10))
    {
      paramhi.fEc.ret = -1;
      com.tencent.mm.kernel.h.aHJ().postToWorkerDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103255);
          b.d(this.wFW);
          AppMethodBeat.o(103255);
        }
      }, 500L);
      AppMethodBeat.o(103268);
      return;
    }
    paramhi.fEc.ret = -1;
    AppMethodBeat.o(103268);
  }
  
  private static void a(c paramc, g paramg)
  {
    AppMethodBeat.i(103295);
    Iterator localIterator = paramg.field_favProto.syG.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      anm localanm = (anm)localIterator.next();
      if ((localanm.dataType != 1) && (localanm.dataType != 6))
      {
        if (!Util.isNullOrNil(localanm.Rwb)) {
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
          ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().ag(17, paramc.field_favLocalId);
          ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getModService().run();
          AppMethodBeat.o(103295);
          return;
        }
        ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().ag(9, paramc.field_favLocalId);
        ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getSendService().run();
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
    Object localObject2 = new cyi();
    ((cyi)localObject2).TGG = 4;
    ((cyi)localObject2).TGH = 0;
    ((LinkedList)localObject1).add(localObject2);
    localObject2 = new LinkedList();
    cyl localcyl = new cyl();
    localcyl.CQx = "favitem.taglist";
    localcyl.rWu = 1;
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramg.field_tagProto.SAP.size();
    int i = 0;
    while (i < j)
    {
      localStringBuffer.append("<tag>").append(Util.escapeStringForXml((String)paramg.field_tagProto.SAP.get(i))).append("</tag>");
      i += 1;
    }
    localcyl.Izj = localStringBuffer.toString();
    Log.v("MicroMsg.Fav.FavApiLogic", "do net scene mod tag, id=%d, tag=%s", new Object[] { Integer.valueOf(paramg.field_id), localcyl.Izj });
    ((LinkedList)localObject2).add(localcyl);
    if (paramg.field_id > 0)
    {
      localObject1 = new an(paramg.field_id, (LinkedList)localObject1, (LinkedList)localObject2);
      com.tencent.mm.kernel.h.aGY().a((com.tencent.mm.an.q)localObject1, 0);
      h.i(paramg.field_id, j, paramInt);
      AppMethodBeat.o(103346);
      return;
    }
    ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getEditService().a(paramg.field_localId, (LinkedList)localObject1, (LinkedList)localObject2, paramInt);
    AppMethodBeat.o(103346);
  }
  
  public static void a(g paramg, anm paramanm)
  {
    AppMethodBeat.i(103308);
    if (Util.isNullOrNil(paramanm.fEa))
    {
      AppMethodBeat.o(103308);
      return;
    }
    String str = azJ(paramanm.fEa);
    c localc = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().aAb(str);
    Object localObject = localc;
    if (localc != null)
    {
      localObject = localc;
      if (localc.field_status == 3)
      {
        ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().b(localc, new String[] { "dataId" });
        localObject = null;
      }
    }
    if ((localObject != null) && (((c)localObject).field_type == 1))
    {
      ((c)localObject).field_status = 1;
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().a((c)localObject, new String[] { "dataId" });
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnService().azZ(str);
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnService().run();
      AppMethodBeat.o(103308);
      return;
    }
    localObject = new com.tencent.mm.vfs.q(a(paramanm));
    if ((!Util.isNullOrNil(paramanm.SxK)) && (!Util.isNullOrNil(paramanm.lmm)) && (!((com.tencent.mm.vfs.q)localObject).ifE()))
    {
      a(paramanm, paramg, 1);
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnService().azZ(str);
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnService().run();
    }
    AppMethodBeat.o(103308);
  }
  
  public static void a(g paramg, anm paramanm, boolean paramBoolean)
  {
    AppMethodBeat.i(103307);
    if ((paramg == null) || (Util.isNullOrNil(paramanm.fEa)))
    {
      AppMethodBeat.o(103307);
      return;
    }
    Log.i("MicroMsg.Fav.FavApiLogic", "restart cdndata download, favId %d, favLocalId %d, dataId %s", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), paramanm.fEa });
    Object localObject2 = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().aAb(paramanm.fEa);
    Object localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((c)localObject2).field_status == 3)
      {
        ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().b((c)localObject2, new String[] { "dataId" });
        localObject1 = null;
      }
    }
    localObject2 = localObject1;
    if (localObject1 != null) {
      if ((!Util.isNullOrNil(((c)localObject1).field_cdnUrl)) && (!Util.isNullOrNil(((c)localObject1).field_cdnKey)) && (!Util.isNullOrNil(((c)localObject1).field_dataId)) && (((c)localObject1).field_cdnUrl.equals(paramanm.Rwb)) && (((c)localObject1).field_cdnKey.equals(paramanm.SxP)))
      {
        localObject2 = localObject1;
        if (((c)localObject1).field_dataId.equals(paramanm.fEa)) {}
      }
      else
      {
        ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().b((c)localObject1, new String[] { "dataId" });
        localObject2 = null;
      }
    }
    if ((localObject2 != null) && (((c)localObject2).field_type == 1))
    {
      Log.i("MicroMsg.Fav.FavApiLogic", "klem data not download completed.");
      ((c)localObject2).field_status = 1;
      ((c)localObject2).field_path = d(paramanm);
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().a((c)localObject2, new String[] { "dataId" });
      if (paramBoolean)
      {
        ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnService().azZ(paramanm.fEa);
        if ((!Util.isNullOrNil(paramanm.SyO)) && (paramanm.SyO.equals("WeNoteHtmlFile")))
        {
          paramg = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().aAb(paramanm.fEa);
          ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnService().d(paramg);
        }
      }
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnService().run();
      AppMethodBeat.o(103307);
      return;
    }
    localObject1 = new com.tencent.mm.vfs.q(d(paramanm));
    if ((!Util.isNullOrNil(paramanm.SxP)) && (!Util.isNullOrNil(paramanm.Rwb)) && (!((com.tencent.mm.vfs.q)localObject1).ifE()))
    {
      Log.i("MicroMsg.Fav.FavApiLogic", "klem big img not exist, start download.");
      long l = System.currentTimeMillis();
      a(paramanm, paramg, 1, true);
      if (paramBoolean)
      {
        ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnService().azZ(paramanm.fEa);
        if ((!Util.isNullOrNil(paramanm.SyO)) && (paramanm.SyO.equals("WeNoteHtmlFile")))
        {
          paramg = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().aAb(paramanm.fEa);
          ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnService().d(paramg);
        }
      }
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnService().run();
      Log.i("MicroMsg.Fav.FavApiLogic", "insert cdn item use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
    AppMethodBeat.o(103307);
  }
  
  public static void a(g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(103286);
    h(paramg);
    ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavSearchStorage().Ko(paramg.field_localId);
    ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().A(paramg);
    ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().Kk(paramg.field_localId);
    ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavTagSetMgr().w(paramg);
    if (paramBoolean)
    {
      Set localSet = djk();
      localSet.add(paramg.field_id);
      i(localSet);
      djm();
    }
    if (paramg.field_type == 18)
    {
      long l = paramg.field_localId;
      if (l <= 0L)
      {
        AppMethodBeat.o(103286);
        return;
      }
      paramg = new cx();
      paramg.fyB.localId = l;
      EventCenter.instance.publish(paramg);
    }
    AppMethodBeat.o(103286);
  }
  
  public static void a(anm paramanm, int paramInt, long paramLong)
  {
    AppMethodBeat.i(103329);
    if (Util.isNullOrNil(paramanm.fEa))
    {
      AppMethodBeat.o(103329);
      return;
    }
    if ((Util.isNullOrNil(paramanm.SxK)) || (Util.isNullOrNil(paramanm.lmm)))
    {
      AppMethodBeat.o(103329);
      return;
    }
    String str = azJ(paramanm.fEa);
    c localc = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().aAb(str);
    Object localObject = localc;
    if (localc != null) {
      if (localc.field_status != 3)
      {
        localObject = localc;
        if (localc.field_status != 4) {}
      }
      else
      {
        ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().b(localc, new String[] { "dataId" });
        localObject = null;
      }
    }
    if ((localObject != null) && (((c)localObject).field_type == 1))
    {
      ((c)localObject).field_status = 1;
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().a((c)localObject, new String[] { "dataId" });
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnService().azZ(str);
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnService().run();
      AppMethodBeat.o(103329);
      return;
    }
    localObject = new com.tencent.mm.vfs.q(a(paramanm));
    if ((!Util.isNullOrNil(paramanm.SxK)) && (!Util.isNullOrNil(paramanm.lmm)) && (!((com.tencent.mm.vfs.q)localObject).ifE()))
    {
      localObject = new g();
      ((g)localObject).field_localId = paramLong;
      ((g)localObject).field_id = -1;
      ((g)localObject).field_type = paramInt;
      a(paramanm, (g)localObject, 1);
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnService().azZ(str);
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnService().run();
    }
    AppMethodBeat.o(103329);
  }
  
  public static void a(anm paramanm, g paramg, int paramInt)
  {
    AppMethodBeat.i(103296);
    if ((paramInt == 1) && ((paramanm.Sys <= 0L) || (Util.isNullOrNil(paramanm.SxK)) || (Util.isNullOrNil(paramanm.lmm))))
    {
      Log.e("MicroMsg.Fav.FavApiLogic", "insertCdnThumbInfo, type recv, cdndataurl must not be null!");
      AppMethodBeat.o(103296);
      return;
    }
    if ((paramInt == 0) && (Util.isNullOrNil(a(paramanm))))
    {
      Log.e("MicroMsg.Fav.FavApiLogic", "insertCdnThumbInfo, type send, path must not be null!");
      AppMethodBeat.o(103296);
      return;
    }
    String str = azJ(paramanm.fEa);
    if (((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().aAb(str) != null)
    {
      Log.w("MicroMsg.Fav.FavApiLogic", "cdn info exist, id[%s], return", new Object[] { str });
      AppMethodBeat.o(103296);
      return;
    }
    Log.v("MicroMsg.Fav.FavApiLogic", "insert cdn thumb info, fav local id[%d] fav id[%d]", new Object[] { Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
    c localc = new c();
    localc.field_cdnKey = paramanm.SxK;
    localc.field_cdnUrl = paramanm.lmm;
    localc.field_dataId = str;
    localc.field_favLocalId = paramg.field_localId;
    localc.field_totalLen = ((int)paramanm.Sys);
    localc.field_type = paramInt;
    localc.field_status = 1;
    localc.field_path = a(paramanm);
    localc.field_modifyTime = Util.nowMilliSecond();
    localc.field_attrFlag |= 1L;
    ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().f(localc);
    if (paramInt == 1)
    {
      c(localc);
      AppMethodBeat.o(103296);
      return;
    }
    b(localc);
    AppMethodBeat.o(103296);
  }
  
  public static void a(anm paramanm, g paramg, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(103297);
    if ((paramInt == 1) && ((Util.isNullOrNil(paramanm.SxP)) || (Util.isNullOrNil(paramanm.Rwb))))
    {
      Log.e("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo, type recv, cdndataurl must not be null!");
      AppMethodBeat.o(103297);
      return;
    }
    if ((paramInt == 0) && (Util.isNullOrNil(d(paramanm))))
    {
      Log.e("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo, type send, path must not be null!");
      AppMethodBeat.o(103297);
      return;
    }
    if (((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().aAb(paramanm.fEa) != null)
    {
      Log.v("MicroMsg.Fav.FavApiLogic", "cdn info exist, id[%s], return", new Object[] { paramanm.fEa });
      AppMethodBeat.o(103297);
      return;
    }
    Log.i("MicroMsg.Fav.FavApiLogic", "insert cdn data info, fav local id[%d] fav id[%d]", new Object[] { Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
    c localc = new c();
    localc.field_dataId = paramanm.fEa;
    localc.field_totalLen = ((int)paramanm.Syi);
    localc.field_type = paramInt;
    localc.field_favLocalId = paramg.field_localId;
    localc.field_cdnKey = paramanm.SxP;
    localc.field_cdnUrl = paramanm.Rwb;
    localc.field_path = d(paramanm);
    boolean bool;
    int i;
    label404:
    if (paramanm.dataType == 3)
    {
      localc.field_dataType = azL(paramanm.Syc);
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
          break label611;
        }
        localc.field_status = 1;
        Log.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo upload status traning");
      }
      label343:
      if (paramInt == 1)
      {
        Log.i("MicroMsg.Fav.FavApiLogic", "can auto download, force %B, isWifi %B, dataType %d, totalLen %d", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), Integer.valueOf(localc.field_dataType), Integer.valueOf(localc.field_totalLen) });
        if (!paramBoolean) {
          break label628;
        }
        i = 1;
        if (i == 0) {
          break label752;
        }
        localc.field_status = 1;
        Log.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo download status traning");
      }
    }
    for (;;)
    {
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().f(localc);
      if (paramInt != 1) {
        break label769;
      }
      c(localc);
      AppMethodBeat.o(103297);
      return;
      localc.field_dataType = paramanm.dataType;
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
        l1 = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFileSizeLimit(true);
      }
      if (localc.field_totalLen <= l1)
      {
        Log.i("MicroMsg.Fav.FavApiLogic", "match max auto upload, max size %d", new Object[] { Long.valueOf(l1) });
        i = 1;
        break label324;
      }
      i = 0;
      break label324;
      label611:
      localc.field_status = 4;
      Log.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo upload status pause");
      break label343;
      label628:
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
      l1 = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getLong("fav_mx_auto_download_size", ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFileSizeLimit(true));
      if (localc.field_totalLen <= l1)
      {
        Log.i("MicroMsg.Fav.FavApiLogic", "match max auto download, max size %d", new Object[] { Long.valueOf(l1) });
        i = 1;
        break label404;
      }
      i = 0;
      break label404;
      label752:
      localc.field_status = 4;
      Log.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo download status pause");
    }
    label769:
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
    com.tencent.mm.by.c.f(paramContext, ".ui.transmit.MsgRetransmitUI", localIntent);
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
    if (Looper.myLooper() == com.tencent.mm.kernel.h.aHJ().getLooper())
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
      com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103256);
          Log.i("MicroMsg.Fav.FavApiLogic", "delete favItem id %d, localId %d, needBatchDel %B, do on worker thread", new Object[] { Integer.valueOf(this.wFX.field_id), Long.valueOf(this.wFX.field_localId), Boolean.valueOf(paramBoolean) });
          b.a(this.wFX, paramBoolean);
          MMHandlerThread.postToMainThread(paramRunnable);
          b.s(this.wFX);
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
    final anm localanm = c(paramg);
    String[] arrayOfString = new String[2];
    Runnable local3 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(103257);
        b.a(this.wGa, localanm);
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
      if (localanm != null)
      {
        arrayOfString[0] = a(localanm);
        arrayOfString[1] = localanm.fyu;
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
        localObject1 = paramg.field_favProto.Szr;
        if (localanm == null)
        {
          if (localObject1 != null) {
            arrayOfString[1] = ((aor)localObject1).thumbUrl;
          }
        }
        else
        {
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = ((aor)localObject1).thumbUrl)
          {
            localObject2 = localObject1;
            if (Util.isNullOrNil((String)localObject1)) {
              localObject2 = localanm.fyu;
            }
            arrayOfString[0] = a(localanm);
            arrayOfString[1] = localObject2;
            paramMMHandler.post(local3);
            break;
          }
          paramMMHandler = paramg.field_favProto.Szt;
          if (paramMMHandler != null)
          {
            arrayOfString[1] = paramMMHandler.thumbUrl;
            continue;
            paramMMHandler = paramg.field_favProto.Szv;
            if (paramMMHandler != null)
            {
              arrayOfString[1] = paramMMHandler.thumbUrl;
              continue;
              paramMMHandler = paramg.field_favProto.Szt;
              if (paramMMHandler != null) {
                arrayOfString[1] = paramMMHandler.thumbUrl;
              }
            }
          }
        }
      }
    }
    if (paramg.field_favProto.syG != null)
    {
      Iterator localIterator = paramg.field_favProto.syG.iterator();
      label375:
      localObject1 = localObject2;
      if (localIterator.hasNext())
      {
        localObject1 = (anm)localIterator.next();
        if (((anm)localObject1).dataType != 2) {
          break label435;
        }
        localObject1 = d((anm)localObject1);
        paramMMHandler.post(local3);
      }
    }
    for (;;)
    {
      arrayOfString[0] = localObject1;
      arrayOfString[1] = localanm.fyu;
      break;
      label435:
      if (((anm)localObject1).dataType != 15) {
        break label375;
      }
      localObject1 = a((anm)localObject1);
      paramMMHandler.post(local3);
    }
  }
  
  private static com.tencent.mm.vfs.q azI(String paramString)
  {
    AppMethodBeat.i(103279);
    int i = paramString.hashCode();
    paramString = new com.tencent.mm.vfs.q(String.format("%s%s/%d/", new Object[] { com.tencent.mm.kernel.h.aHG().kcB, "favorite", Integer.valueOf(i & 0xFF) }));
    if ((!paramString.ifE()) || (!paramString.isDirectory())) {
      paramString.ifL();
    }
    AppMethodBeat.o(103279);
    return paramString;
  }
  
  public static String azJ(String paramString)
  {
    AppMethodBeat.i(103284);
    paramString = paramString + "_t";
    AppMethodBeat.o(103284);
    return paramString;
  }
  
  public static boolean azK(String paramString)
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
  
  public static int azL(String paramString)
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
  
  public static String azM(String paramString)
  {
    AppMethodBeat.i(103303);
    as localas = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramString);
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
  
  public static String azN(String paramString)
  {
    AppMethodBeat.i(103325);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(103325);
      return null;
    }
    paramString = new com.tencent.mm.vfs.q(djl() + com.tencent.mm.b.g.getMessageDigest(paramString.getBytes()));
    if (paramString.ifE())
    {
      paramString = paramString.bOF();
      AppMethodBeat.o(103325);
      return paramString;
    }
    AppMethodBeat.o(103325);
    return null;
  }
  
  public static int azO(String paramString)
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
  
  public static g azP(String paramString)
  {
    AppMethodBeat.i(103338);
    g localg = new g();
    localg.field_localId = -1L;
    localg.field_id = -1;
    localg.field_xml = paramString;
    localg.field_type = 18;
    localg.azR(paramString);
    AppMethodBeat.o(103338);
    return localg;
  }
  
  private static g azQ(String paramString)
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
        localg.field_favProto = new aoc();
        localg.field_type = 18;
        Object localObject = (String)localMap.get(".noteinfo.edittime");
        localg.field_favProto.Ud(Util.getLong((String)localObject, 0L));
        localObject = new anw();
        ((anw)localObject).SAv = ((String)localMap.get(".noteinfo.noteeditor"));
        ((anw)localObject).SAu = ((String)localMap.get(".noteinfo.noteauthor"));
        localg.field_favProto.a((anw)localObject);
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
    paramg = paramg.field_favProto.syG.iterator();
    anm localanm;
    for (int i = 0; paramg.hasNext(); i = (int)(localanm.Syi + l))
    {
      localanm = (anm)paramg.next();
      l = i;
    }
    long l = i;
    AppMethodBeat.o(103263);
    return l;
  }
  
  public static String b(aoc paramaoc)
  {
    AppMethodBeat.i(103358);
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramaoc != null) && (paramaoc.syG != null))
    {
      paramaoc = paramaoc.syG.iterator();
      while (paramaoc.hasNext()) {
        localStringBuilder.append(((anm)paramaoc.next()).fEa).append(";");
      }
    }
    paramaoc = localStringBuilder.toString();
    AppMethodBeat.o(103358);
    return paramaoc;
  }
  
  public static void b(Context paramContext, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(293050);
    a(paramContext, paramString, paramIntent, null);
    AppMethodBeat.o(293050);
  }
  
  private static void b(hi paramhi)
  {
    AppMethodBeat.i(103341);
    g localg = azQ(paramhi.fEb.desc);
    if (localg == null)
    {
      AppMethodBeat.o(103341);
      return;
    }
    if ((localg.field_favProto != null) && (localg.field_favProto.syG != null))
    {
      Iterator localIterator = localg.field_favProto.syG.iterator();
      while (localIterator.hasNext())
      {
        anm localanm = (anm)localIterator.next();
        if (localanm.dataType == 20)
        {
          localanm.Ey(true);
          localanm.Ex(true);
          localanm.bsL("");
          localanm.bsB("");
          localanm.bsC("");
          localanm.bsz("");
          localanm.bsA("");
        }
      }
    }
    paramhi.fEb.fyK = localg.field_favProto;
    AppMethodBeat.o(103341);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(103293);
    int i = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().z(paramc.field_favLocalId, 0);
    Log.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus, upload data status:%d, favlocalId:%d", new Object[] { Integer.valueOf(i), Long.valueOf(paramc.field_favLocalId) });
    g localg = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(paramc.field_favLocalId);
    if (localg == null)
    {
      Log.e("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus iteminfo null");
      AppMethodBeat.o(103293);
      return;
    }
    if (localg.djH())
    {
      Log.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus waiting server upload skip.");
      AppMethodBeat.o(103293);
      return;
    }
    if ((paramc.field_status == 3) && (i != paramc.field_status) && (localg.field_type == 18) && (((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().aAb(paramc.field_dataId).field_status == 3))
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
      if (localg.djG()) {
        ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().ag(15, paramc.field_favLocalId);
      }
      for (;;)
      {
        Log.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus, continue upload data, favlocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
        AppMethodBeat.o(103293);
        return;
        ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().ag(4, paramc.field_favLocalId);
      }
      if (localg.djG()) {
        ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().ag(16, paramc.field_favLocalId);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(localg.field_type), Integer.valueOf(-5), Long.valueOf(b(localg)), Long.valueOf(h.Kf(localg.field_localId)) });
        Log.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus, error, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
        AppMethodBeat.o(103293);
        return;
        ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().ag(6, paramc.field_favLocalId);
      }
      AppMethodBeat.o(103293);
      return;
      if (localg.field_type == 18)
      {
        a(paramc, localg);
        AppMethodBeat.o(103293);
        return;
      }
      if (localg.djG())
      {
        ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().ag(17, paramc.field_favLocalId);
        Log.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus start mod faviteminfo, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
        ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getModService().run();
        AppMethodBeat.o(103293);
        return;
      }
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().ag(9, paramc.field_favLocalId);
      Log.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus start send faviteminfo, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getSendService().run();
      AppMethodBeat.o(103293);
      return;
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().ag(6, paramc.field_favLocalId);
      Log.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus pause, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
    }
  }
  
  private static void b(g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(103343);
    anw localanw = new anw();
    if (!paramBoolean) {
      localanw.SAu = z.bcZ();
    }
    localanw.SAv = z.bcZ();
    paramg.field_favProto.Ud(Util.nowSecond());
    paramg.field_favProto.a(localanw);
    AppMethodBeat.o(103343);
  }
  
  public static void b(anm paramanm, int paramInt, long paramLong)
  {
    AppMethodBeat.i(103330);
    if (Util.isNullOrNil(paramanm.fEa))
    {
      AppMethodBeat.o(103330);
      return;
    }
    Log.i("MicroMsg.Fav.FavApiLogic", "restart cdndata download, dataId %s", new Object[] { paramanm.fEa });
    c localc = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().aAb(paramanm.fEa);
    Object localObject = localc;
    if (localc != null) {
      if (localc.field_status != 3)
      {
        localObject = localc;
        if (localc.field_status != 4) {}
      }
      else
      {
        ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().b(localc, new String[] { "dataId" });
        localObject = null;
      }
    }
    if ((localObject != null) && (((c)localObject).field_type == 1))
    {
      Log.i("MicroMsg.Fav.FavApiLogic", "klem data not download completed.");
      ((c)localObject).field_status = 1;
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().a((c)localObject, new String[] { "dataId" });
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnService().azZ(paramanm.fEa);
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnService().run();
      AppMethodBeat.o(103330);
      return;
    }
    localObject = new com.tencent.mm.vfs.q(d(paramanm));
    if ((!Util.isNullOrNil(paramanm.SxP)) && (!Util.isNullOrNil(paramanm.Rwb)) && (!((com.tencent.mm.vfs.q)localObject).ifE()))
    {
      Log.i("MicroMsg.Fav.FavApiLogic", "klem big img not exist, start download.");
      long l = System.currentTimeMillis();
      localObject = new g();
      ((g)localObject).field_localId = paramLong;
      ((g)localObject).field_id = -1;
      ((g)localObject).field_type = paramInt;
      a(paramanm, (g)localObject, 1, true);
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnService().azZ(paramanm.fEa);
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnService().run();
      Log.i("MicroMsg.Fav.FavApiLogic", "insert cdn item use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
    AppMethodBeat.o(103330);
  }
  
  public static boolean b(long paramLong, Runnable paramRunnable)
  {
    AppMethodBeat.i(103331);
    boolean bool = a(((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(paramLong), true, paramRunnable);
    AppMethodBeat.o(103331);
    return bool;
  }
  
  public static anm c(g paramg)
  {
    AppMethodBeat.i(103264);
    if (paramg == null)
    {
      paramg = new anm();
      AppMethodBeat.o(103264);
      return paramg;
    }
    if (paramg.field_favProto.syG.size() == 0)
    {
      paramg = new anm();
      AppMethodBeat.o(103264);
      return paramg;
    }
    paramg = (anm)paramg.field_favProto.syG.get(0);
    AppMethodBeat.o(103264);
    return paramg;
  }
  
  public static String c(anm paramanm)
  {
    AppMethodBeat.i(103258);
    ann localann = paramanm.SyG;
    String str = "";
    switch (paramanm.dataType)
    {
    case 2: 
    case 3: 
    case 7: 
    case 9: 
    default: 
      paramanm = gS(gS("", localann.title), localann.desc);
    }
    for (;;)
    {
      AppMethodBeat.o(103258);
      return paramanm;
      paramanm = gS("", paramanm.desc);
      continue;
      paramanm = str;
      if (localann.Szv != null)
      {
        paramanm = gS("", localann.Szv.title);
        continue;
        paramanm = str;
        if (localann.Szr != null)
        {
          paramanm = gS("", localann.Szr.title);
          continue;
          str = gS("", localann.remark);
          paramanm = str;
          if (localann.Szp != null)
          {
            paramanm = gS(gS(str, localann.Szp.fPN), localann.Szp.label);
            continue;
            paramanm = str;
            if (localann.Szt != null)
            {
              paramanm = gS(gS("", localann.Szt.title), localann.Szt.desc);
              continue;
              paramanm = gS("", localann.title);
            }
          }
        }
      }
    }
  }
  
  public static void c(hi paramhi)
  {
    int i = 1;
    AppMethodBeat.i(103345);
    Object localObject2;
    Object localObject3;
    if (paramhi.fEb.fEi == 1)
    {
      paramhi.fEc.path = JX(paramhi.fEb.fyE);
      localObject2 = paramhi.fEc;
      long l = paramhi.fEb.fyE;
      localObject3 = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(l);
      if ((localObject3 == null) || (((g)localObject3).field_favProto == null)) {
        paramhi = "";
      }
      for (;;)
      {
        label87:
        ((hi.b)localObject2).thumbPath = paramhi;
        AppMethodBeat.o(103345);
        return;
        if ((((g)localObject3).field_type != 18) || (((g)localObject3).field_favProto.syG.size() > 1))
        {
          paramhi = ((g)localObject3).field_favProto.syG.iterator();
          for (;;)
          {
            if (paramhi.hasNext())
            {
              anm localanm = (anm)paramhi.next();
              switch (localanm.dataType)
              {
              default: 
                break;
              case 2: 
                localObject1 = a(localanm);
                paramhi = (hi)localObject1;
                if (u.agG((String)localObject1)) {
                  break label87;
                }
                paramhi = d(localanm);
                if (u.agG(paramhi))
                {
                  BitmapUtil.createThumbNail(paramhi, 150, 150, Bitmap.CompressFormat.JPEG, 90, (String)localObject1, true);
                  paramhi = a(localanm);
                  break label87;
                }
                if (localanm.SxJ)
                {
                  a((g)localObject3, localanm);
                  paramhi = (hi)localObject1;
                  break label87;
                }
                if (localanm.SxO)
                {
                  a((g)localObject3, localanm, true);
                  break label87;
                }
                paramhi = "";
                break label87;
              }
            }
          }
        }
        paramhi = "";
      }
    }
    if (paramhi.fEb.fEi == 2)
    {
      localObject1 = new g();
      ((g)localObject1).field_type = 2;
      localObject2 = new anm();
      ((anm)localObject2).bsK(dN(localObject2.toString(), 2));
      localObject3 = d((anm)localObject2);
      ((anm)localObject2).bsL((String)localObject3);
      ((anm)localObject2).arq(2);
      ((g)localObject1).field_favProto.syG.add(localObject2);
      paramhi.fEc.path = g.t((g)localObject1);
      paramhi.fEc.thumbPath = ((String)localObject3);
      AppMethodBeat.o(103345);
      return;
    }
    if (paramhi.fEb.fEi == 3)
    {
      localObject1 = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(paramhi.fEb.fyE);
      if (localObject1 != null) {
        paramhi.fEc.path = (z.bcZ() + ";" + ((g)localObject1).field_fromUser + ";" + ((g)localObject1).field_updateTime);
      }
      AppMethodBeat.o(103345);
      return;
    }
    if (paramhi.fEb.fEi == 4)
    {
      b(paramhi);
      AppMethodBeat.o(103345);
      return;
    }
    if (paramhi.fEb.fEi == 5)
    {
      a(paramhi);
      AppMethodBeat.o(103345);
      return;
    }
    if (paramhi.fEb.fEi == 6)
    {
      localObject1 = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(paramhi.fEb.fyE);
      if (localObject1 == null)
      {
        paramhi.fEc.ret = 0;
        AppMethodBeat.o(103345);
        return;
      }
      paramhi = paramhi.fEc;
      if (((g)localObject1).field_id > 0) {}
      for (;;)
      {
        paramhi.ret = i;
        AppMethodBeat.o(103345);
        return;
        i = 0;
      }
    }
    Object localObject1 = new g();
    ((g)localObject1).field_type = 18;
    ((g)localObject1).field_favProto = paramhi.fEb.fyK;
    paramhi.fEc.path = g.t((g)localObject1);
    AppMethodBeat.o(103345);
  }
  
  public static void c(c paramc)
  {
    AppMethodBeat.i(103294);
    if (((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage() == null)
    {
      Log.e("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, getFavCdnStorage null");
      AppMethodBeat.o(103294);
      return;
    }
    int i = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().z(paramc.field_favLocalId, 1);
    Log.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, download data status:%d, favlocalId:%d", new Object[] { Integer.valueOf(i), Long.valueOf(paramc.field_favLocalId) });
    if (((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage() == null)
    {
      Log.e("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus getFavItemInfoStorage null");
      AppMethodBeat.o(103294);
      return;
    }
    g localg = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(paramc.field_favLocalId);
    if (localg == null)
    {
      Log.e("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus iteminfo null");
      AppMethodBeat.o(103294);
      return;
    }
    if ((localg.djH()) || (localg.djD()) || (localg.djE()))
    {
      Log.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, status upload, skip. isWaitServerUpload:%b  isUploadding:%b  isUploadFailed:%b", new Object[] { Boolean.valueOf(localg.djH()), Boolean.valueOf(localg.djD()), Boolean.valueOf(localg.djE()) });
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
      h.Kg(localg.field_localId);
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().ag(7, paramc.field_favLocalId);
      AppMethodBeat.o(103294);
      return;
      Log.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, error, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
      com.tencent.mm.plugin.report.service.h.IzE.a(10659, new Object[] { Integer.valueOf(1), Integer.valueOf(localg.field_type), Integer.valueOf(-5), Long.valueOf(b(localg)), Long.valueOf(h.Kf(localg.field_localId)) });
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().ag(8, paramc.field_favLocalId);
      AppMethodBeat.o(103294);
      return;
      Log.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus init, favLocalId:%d, favId:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id) });
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().ag(10, paramc.field_favLocalId);
      AppMethodBeat.o(103294);
      return;
      Log.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus finish, favLocalId:%d, favId:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id) });
      com.tencent.mm.plugin.report.service.h.IzE.a(10659, new Object[] { Integer.valueOf(1), Integer.valueOf(localg.field_type), Integer.valueOf(0), Long.valueOf(b(localg)), Long.valueOf(h.Kf(localg.field_localId)) });
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().ag(10, paramc.field_favLocalId);
      AppMethodBeat.o(103294);
      return;
      Log.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus pause, favLocalId:%d, favId:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id) });
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().ag(8, paramc.field_favLocalId);
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
    String str1 = "fav_" + z.bcZ() + "_0";
    String str2 = com.tencent.mm.model.ad.Rp(str1);
    com.tencent.mm.model.ad.beh().I(str2, true).k("prePublishId", str1);
    localIntent.putExtra("reportSessionId", str2);
    localIntent.putExtra("Ksnsupload_type", 0);
    localIntent.putExtra("sns_kemdia_path", paramString);
    com.tencent.mm.by.c.b(paramContext, "sns", ".ui.SnsUploadUI", localIntent);
    AppMethodBeat.o(103352);
  }
  
  public static String d(anm paramanm)
  {
    AppMethodBeat.i(103278);
    if (paramanm == null)
    {
      AppMethodBeat.o(103278);
      return "";
    }
    Object localObject2 = paramanm.fEa;
    if ((Util.isNullOrNil((String)localObject2)) || (!com.tencent.mm.kernel.h.aHB()))
    {
      AppMethodBeat.o(103278);
      return "";
    }
    com.tencent.mm.vfs.q localq2 = azI((String)localObject2);
    int j = 0;
    int i = j;
    com.tencent.mm.vfs.q localq1 = localq2;
    Object localObject1 = localObject2;
    if (paramanm.dataType == 8)
    {
      i = j;
      localq1 = localq2;
      localObject1 = localObject2;
      if (!Util.isNullOrNil(paramanm.title))
      {
        localObject1 = paramanm.title;
        localq1 = azI(paramanm.fEa);
        i = 1;
      }
    }
    localObject2 = localObject1;
    if (paramanm.Syc != null)
    {
      localObject2 = localObject1;
      if (paramanm.Syc.trim().length() > 0)
      {
        localObject2 = localObject1;
        if (i == 0) {
          localObject2 = (String)localObject1 + "." + paramanm.Syc;
        }
      }
    }
    localObject1 = new com.tencent.mm.vfs.q(localq1, (String)localObject2);
    if ((((com.tencent.mm.vfs.q)localObject1).ifE()) || (Util.isNullOrNil(paramanm.Sye)))
    {
      paramanm = ((com.tencent.mm.vfs.q)localObject1).bOF();
      AppMethodBeat.o(103278);
      return paramanm;
    }
    localObject2 = com.tencent.mm.b.g.getMessageDigest((paramanm.Sye + paramanm.fEa).getBytes());
    if (Util.isNullOrNil((String)localObject2))
    {
      paramanm = ((com.tencent.mm.vfs.q)localObject1).bOF();
      AppMethodBeat.o(103278);
      return paramanm;
    }
    localObject1 = localObject2;
    if (paramanm.Syc != null)
    {
      localObject1 = localObject2;
      if (paramanm.Syc.trim().length() > 0) {
        localObject1 = (String)localObject2 + "." + paramanm.Syc;
      }
    }
    localObject1 = new com.tencent.mm.vfs.q(localq1, (String)localObject1);
    if (((com.tencent.mm.vfs.q)localObject1).ifE())
    {
      paramanm = ((com.tencent.mm.vfs.q)localObject1).bOF();
      AppMethodBeat.o(103278);
      return paramanm;
    }
    localObject2 = paramanm.fEa;
    localObject1 = localObject2;
    if (paramanm.Syc != null)
    {
      localObject1 = localObject2;
      if (paramanm.Syc.trim().length() > 0) {
        localObject1 = (String)localObject2 + "." + paramanm.Syc;
      }
    }
    Log.d("MicroMsg.Fav.FavApiLogic", "use dataId.fmt, ".concat(String.valueOf(localObject1)));
    paramanm = new com.tencent.mm.vfs.q(localq1, (String)localObject1).bOF();
    AppMethodBeat.o(103278);
    return paramanm;
  }
  
  public static void d(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(103340);
    g localg = azQ(paramString1);
    if (localg == null)
    {
      AppMethodBeat.o(103340);
      return;
    }
    oz localoz = new oz();
    localoz.fNG.type = 2;
    localoz.fNG.field_localId = -1L;
    localoz.fNG.context = paramContext;
    localoz.fNG.fNP = 4;
    localoz.fNG.fNQ = true;
    paramContext = new Bundle();
    paramContext.putString("noteauthor", localg.field_favProto.RDh.SAu);
    paramContext.putString("noteeditor", localg.field_favProto.RDh.SAv);
    paramContext.putLong("edittime", localg.field_favProto.uTt);
    paramContext.putString("notexml", g.t(localg));
    paramContext.putString("snslocalid", paramString2);
    paramContext.putString("snsthumbpath", paramString3);
    paramContext.putString("snsnotelinkxml", paramString1);
    localoz.fNG.fNN = paramContext;
    localoz.fNG.field_favProto = localg.field_favProto;
    EventCenter.instance.publish(localoz);
    AppMethodBeat.o(103340);
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
        if (!wFU.containsKey(Long.valueOf(paramg.field_localId)))
        {
          AppMethodBeat.o(103269);
          continue;
        }
        if (wFU.get(Long.valueOf(paramg.field_localId)) == null) {
          break label101;
        }
      }
      finally {}
      if (((ArrayList)wFU.get(Long.valueOf(paramg.field_localId))).size() == 0)
      {
        label101:
        AppMethodBeat.o(103269);
      }
      else
      {
        String str = JX(paramg.field_localId);
        Log.i("MicroMsg.Fav.FavApiLogic", "checkUpdateSnsNotePostXml, resend favlocal id:%d,xml:%s", new Object[] { Long.valueOf(paramg.field_localId), str });
        tn localtn = new tn();
        localtn.fST.fSU = ((ArrayList)wFU.get(Long.valueOf(paramg.field_localId)));
        localtn.fST.fSV = str;
        EventCenter.instance.publish(localtn);
        wFU.remove(Long.valueOf(paramg.field_localId));
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
    com.tencent.mm.by.c.f(paramContext, ".ui.transmit.MsgRetransmitUI", localIntent);
    AppMethodBeat.o(103354);
  }
  
  public static void dI(List<Integer> paramList)
  {
    AppMethodBeat.i(103271);
    if (paramList.size() == 0)
    {
      Log.e("MicroMsg.Fav.FavApiLogic", "setDeleted list null");
      AppMethodBeat.o(103271);
      return;
    }
    Set localSet = djk();
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
  
  public static boolean dJ(List<g> paramList)
  {
    AppMethodBeat.i(103285);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      Log.w("MicroMsg.Fav.FavApiLogic", "delete fav item fail, item is null");
      AppMethodBeat.o(103285);
      return false;
    }
    Set localSet = djk();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      g localg = (g)paramList.next();
      h(localg);
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavSearchStorage().Ko(localg.field_localId);
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().A(localg);
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().Kk(localg.field_localId);
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavTagSetMgr().w(localg);
      localSet.add(localg.field_id);
      Log.d("MicroMsg.Fav.FavApiLogic", "delete id %d", new Object[] { Integer.valueOf(localg.field_id) });
    }
    i(localSet);
    djm();
    AppMethodBeat.o(103285);
    return true;
  }
  
  public static String dN(String paramString, int paramInt)
  {
    AppMethodBeat.i(103260);
    paramString = com.tencent.mm.b.g.getMessageDigest((paramString + paramInt + System.currentTimeMillis()).getBytes());
    AppMethodBeat.o(103260);
    return paramString;
  }
  
  private static Set<String> djk()
  {
    AppMethodBeat.i(103273);
    Object localObject = (String)com.tencent.mm.kernel.h.aHG().aHp().b(225282, "");
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
  
  public static String djl()
  {
    AppMethodBeat.i(103277);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.h.aHH();
    localObject = com.tencent.mm.kernel.h.aHG().kcB + "favorite/web/";
    AppMethodBeat.o(103277);
    return localObject;
  }
  
  public static void djm()
  {
    AppMethodBeat.i(103281);
    Object localObject2 = djk();
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
      localObject1 = new ai((LinkedList)localObject1);
      com.tencent.mm.kernel.h.aGY().a((com.tencent.mm.an.q)localObject1, 0);
    }
    AppMethodBeat.o(103281);
  }
  
  public static long djn()
  {
    AppMethodBeat.i(103300);
    long l2 = djo() - djp();
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 1024L;
    }
    AppMethodBeat.o(103300);
    return l1;
  }
  
  public static long djo()
  {
    AppMethodBeat.i(103301);
    long l = ((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VjD, Long.valueOf(0L))).longValue();
    AppMethodBeat.o(103301);
    return l;
  }
  
  public static long djp()
  {
    AppMethodBeat.i(103302);
    long l = ((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VjC, Long.valueOf(0L))).longValue();
    AppMethodBeat.o(103302);
    return l;
  }
  
  public static boolean djq()
  {
    AppMethodBeat.i(103311);
    if (djo() == 0L)
    {
      AppMethodBeat.o(103311);
      return false;
    }
    if (djn() < 52428800L)
    {
      AppMethodBeat.o(103311);
      return true;
    }
    AppMethodBeat.o(103311);
    return false;
  }
  
  public static String djr()
  {
    AppMethodBeat.i(103317);
    String str = com.tencent.mm.kernel.h.aHG().kcB + "favorite/music/";
    AppMethodBeat.o(103317);
    return str;
  }
  
  public static String djs()
  {
    AppMethodBeat.i(103320);
    String str = com.tencent.mm.kernel.h.aHG().kcB + "favorite/";
    AppMethodBeat.o(103320);
    return str;
  }
  
  public static String djt()
  {
    AppMethodBeat.i(103321);
    String str = com.tencent.mm.kernel.h.aHG().kcB + "favorite/voice/";
    AppMethodBeat.o(103321);
    return str;
  }
  
  public static boolean dju()
  {
    AppMethodBeat.i(103328);
    if (aj.dkj() > 0)
    {
      AppMethodBeat.o(103328);
      return true;
    }
    AppMethodBeat.o(103328);
    return false;
  }
  
  public static boolean djv()
  {
    AppMethodBeat.i(103337);
    if (djo() == 0L)
    {
      AppMethodBeat.o(103337);
      return false;
    }
    if (djn() < 10485760L)
    {
      AppMethodBeat.o(103337);
      return true;
    }
    AppMethodBeat.o(103337);
    return false;
  }
  
  public static boolean djw()
  {
    AppMethodBeat.i(168688);
    if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHv, 0) != 1) && (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vJz, 0) == 1))
    {
      AppMethodBeat.o(168688);
      return true;
    }
    AppMethodBeat.o(168688);
    return false;
  }
  
  public static void e(anm paramanm)
  {
    AppMethodBeat.i(103309);
    c localc = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().aAb(paramanm.fEa);
    if ((localc != null) && (localc.field_status != 3))
    {
      localc.field_status = 2;
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnService().pauseDownload(paramanm.fEa);
    }
    localc = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().aAb(azJ(paramanm.fEa));
    if ((localc != null) && (localc.field_status != 3))
    {
      localc.field_status = 2;
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnService().pauseDownload(azJ(paramanm.fEa));
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
    paramg = paramg.field_favProto.syG.iterator();
    anm localanm;
    do
    {
      if (!paramg.hasNext()) {
        break;
      }
      localanm = (anm)paramg.next();
    } while (((localanm.dataType != 8) && (localanm.dataType != 4) && (localanm.dataType != 2) && (localanm.dataType != 3)) || ((!Util.isNullOrNil(localanm.Rwb)) && (!Util.isNullOrNil(localanm.SxP))));
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
    paramg = paramg.field_favProto.syG.iterator();
    while (paramg.hasNext())
    {
      anm localanm = (anm)paramg.next();
      if (localanm.SyU == 2)
      {
        AppMethodBeat.o(103280);
        return true;
      }
      if (localanm.SyU == 1)
      {
        AppMethodBeat.o(103280);
        return true;
      }
    }
    AppMethodBeat.o(103280);
    return false;
  }
  
  public static boolean f(anm paramanm)
  {
    AppMethodBeat.i(103316);
    com.tencent.mm.bb.f localf = com.tencent.mm.bb.a.bnA();
    if ((localf != null) && (localf.lVr == 6) && (Util.nullAs(paramanm.fEa, "").equals(localf.lVt)) && (com.tencent.mm.bb.a.bnx()))
    {
      AppMethodBeat.o(103316);
      return true;
    }
    AppMethodBeat.o(103316);
    return false;
  }
  
  public static void fm(Context paramContext)
  {
    AppMethodBeat.i(203967);
    if (0L >= wFV)
    {
      Log.i("MicroMsg.Fav.FavApiLogic", "addTagWhenAddToFav,try to add tag ,but favLocalId is null, return");
      AppMethodBeat.o(203967);
      return;
    }
    g localg = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(wFV);
    wFV = 0L;
    if (localg == null)
    {
      Log.i("MicroMsg.Fav.FavApiLogic", "addTagWhenAddToFav,try to add tag ,but iteminfo is null, return");
      AppMethodBeat.o(203967);
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
    AppMethodBeat.o(203967);
  }
  
  public static boolean g(g paramg)
  {
    if (paramg == null) {}
    while ((paramg.field_itemStatus != 8) && (paramg.field_itemStatus != 10) && (paramg.field_itemStatus != 7)) {
      return false;
    }
    return true;
  }
  
  public static boolean g(anm paramanm)
  {
    AppMethodBeat.i(103326);
    boolean bool = new com.tencent.mm.vfs.q(d(paramanm)).ifE();
    AppMethodBeat.o(103326);
    return bool;
  }
  
  private static String gS(String paramString1, String paramString2)
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
    am.b localb = am.a.lto;
    if (localb != null)
    {
      paramContext = localb.t(paramContext, paramString);
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
    Set localSet = ap.wHO;
    paramg = paramg.field_favProto.syG;
    int i = 0;
    while (i < paramg.size())
    {
      Object localObject = a((anm)paramg.get(i));
      if ((localSet == null) || (!localSet.contains(localObject))) {
        u.deleteFile((String)localObject);
      }
      localObject = d((anm)paramg.get(i));
      if ((localSet == null) || (!localSet.contains(localObject))) {
        u.deleteFile((String)localObject);
      }
      localObject = (anm)paramg.get(i);
      if ((((anm)localObject).SyG != null) && (((anm)localObject).SyG.SzH != null)) {
        com.tencent.mm.modelvideo.y.Yj(((anm)localObject).fEa);
      }
      i += 1;
    }
    AppMethodBeat.o(103282);
  }
  
  public static boolean h(anm paramanm)
  {
    AppMethodBeat.i(103327);
    boolean bool = ImgUtil.isGif(d(paramanm));
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
      if (paramg.field_favProto.Szr != null) {
        str1 = paramg.field_favProto.Szr.SBc;
      }
      String str2 = str1;
      if (paramg.field_favProto.SAB != null)
      {
        str2 = str1;
        if (Util.isNullOrNil(str1)) {
          str2 = paramg.field_favProto.SAB.link;
        }
      }
      paramg = new hc();
      paramg.fDF.url = str2;
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
    com.tencent.mm.kernel.h.aHG().aHp().i(225282, paramSet);
    AppMethodBeat.o(103272);
  }
  
  public static void j(g paramg)
  {
    AppMethodBeat.i(103290);
    j localj = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavSearchStorage().Kp(paramg.field_localId);
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
      if (paramg.field_favProto.SAB != null)
      {
        localObject1 = paramg.field_favProto.SAB;
        if (!Util.isNullOrNil(((aoi)localObject1).fLi))
        {
          localStringBuffer.append(((aoi)localObject1).fLi);
          localObject2 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(((aoi)localObject1).fLi);
          if (localObject2 != null) {
            localStringBuffer.append(((ax)localObject2).field_nickname).append(((ax)localObject2).field_conRemark);
          }
          localObject2 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(((aoi)localObject1).toUser);
          if (localObject2 != null) {
            localStringBuffer.append(((ax)localObject2).field_nickname).append(((ax)localObject2).field_conRemark);
          }
          localStringBuffer.append(((aoi)localObject1).SAb);
        }
      }
      Object localObject1 = paramg.field_favProto.syG;
      localj.field_subtype = 0;
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (anm)((Iterator)localObject1).next();
        if (((anm)localObject2).desc != null) {
          localStringBuffer.append(((anm)localObject2).desc);
        }
        if (((anm)localObject2).title != null) {
          localStringBuffer.append(((anm)localObject2).title);
        }
        int j = ((anm)localObject2).dataType;
        int k = localj.field_subtype;
        localj.field_subtype = (j.LF(j) | k);
      }
      if (paramg.field_favProto.Szr != null)
      {
        if (paramg.field_favProto.Szr.desc != null) {
          localStringBuffer.append(paramg.field_favProto.Szr.desc);
        }
        if (paramg.field_favProto.Szr.title != null) {
          localStringBuffer.append(paramg.field_favProto.Szr.title);
        }
      }
      if (paramg.field_favProto.Szt != null)
      {
        if (paramg.field_favProto.Szt.desc != null) {
          localStringBuffer.append(paramg.field_favProto.Szt.desc);
        }
        if (paramg.field_favProto.Szt.title != null) {
          localStringBuffer.append(paramg.field_favProto.Szt.title);
        }
      }
      if (paramg.field_favProto.SzJ != null)
      {
        if (paramg.field_favProto.SzJ.nickname != null) {
          localStringBuffer.append(paramg.field_favProto.SzJ.nickname);
        }
        if (paramg.field_favProto.SzJ.desc != null) {
          localStringBuffer.append(paramg.field_favProto.SzJ.desc);
        }
      }
      localj.field_tagContent = "";
      localObject1 = paramg.field_tagProto.SAO.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localj.field_tagContent = (localj.field_tagContent + " " + (String)localObject2);
        localStringBuffer.append((String)localObject2);
      }
      localObject1 = paramg.field_tagProto.SAP.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localj.field_tagContent = (localj.field_tagContent + " " + (String)localObject2);
        localStringBuffer.append((String)localObject2);
        ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavTagSetMgr().azW((String)localObject2);
      }
      localj.field_content = localStringBuffer.toString();
      localj.field_time = paramg.field_updateTime;
      localj.field_type = paramg.field_type;
      if (i != 0)
      {
        ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavSearchStorage().a(localj);
        AppMethodBeat.o(103290);
        return;
      }
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavSearchStorage().a(localj, new String[] { "localId" });
      AppMethodBeat.o(103290);
      return;
    }
  }
  
  public static boolean k(g paramg)
  {
    AppMethodBeat.i(103298);
    if (((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(paramg.field_localId) != null)
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
    if (!paramg.djE())
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
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getCheckCdnService().run();
      AppMethodBeat.o(103305);
      return;
      if (((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().Kh(paramg.field_localId).size() == 0)
      {
        paramg.field_itemStatus = 9;
        ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
        paramg = new ah(paramg);
        com.tencent.mm.kernel.h.aGY().a(paramg, 0);
        AppMethodBeat.o(103305);
        return;
      }
      paramg.field_itemStatus = 4;
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().y(paramg);
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
      localObject = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().Kh(paramg.field_localId).iterator();
      c localc;
      Iterator localIterator;
      anm localanm;
      String str1;
      String str2;
      while (((Iterator)localObject).hasNext())
      {
        localc = (c)((Iterator)localObject).next();
        Log.i("MicroMsg.Fav.FavApiLogic", "force upload favItem[last failed], favid:%d localId:%d, dataId:%s, dataType:%d totalLength %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), localc.field_dataId, Integer.valueOf(localc.field_dataType), Integer.valueOf(localc.field_totalLen) });
        if (!u.agG(localc.field_path))
        {
          Log.i("MicroMsg.Fav.FavApiLogic", "cdnInfo.field_path (%s) not exists, exportPath:%s", new Object[] { localc.field_path, u.n(localc.field_path, false) });
          if ((paramg.field_favProto != null) && (paramg.field_favProto.syG != null))
          {
            localIterator = paramg.field_favProto.syG.iterator();
            while (localIterator.hasNext())
            {
              localanm = (anm)localIterator.next();
              str1 = d(localanm);
              str2 = u.n(str1, false);
              Log.i("MicroMsg.Fav.FavApiLogic", "toPath:%s, trueDataPath:%s", new Object[] { str1, str2 });
              if ((str1.equals(localc.field_path)) || (str2.equals(localc.field_path))) {
                Log.i("MicroMsg.Fav.FavApiLogic", "copy ret:%s", new Object[] { Long.valueOf(u.on(localanm.Syl, localc.field_path)) });
              }
            }
          }
        }
        ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnService().azZ(localc.field_dataId);
      }
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnService().run();
      AppMethodBeat.o(103305);
      return;
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().ag(12, paramg.field_localId);
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getSendService().run();
      AppMethodBeat.o(103305);
      return;
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().ag(15, paramg.field_localId);
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().y(paramg);
      localObject = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().Kh(paramg.field_localId).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localc = (c)((Iterator)localObject).next();
        Log.i("MicroMsg.Fav.FavApiLogic", "force upload favItem[last mod failed], favid:%d localId:%d, dataId:%s, dataType:%d totalLength %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), localc.field_dataId, Integer.valueOf(localc.field_dataType), Integer.valueOf(localc.field_totalLen) });
        if (!u.agG(localc.field_path))
        {
          Log.i("MicroMsg.Fav.FavApiLogic", "cdnInfo.field_path (%s) not exists, exportPath:%s", new Object[] { localc.field_path, u.n(localc.field_path, false) });
          if ((paramg.field_favProto != null) && (paramg.field_favProto.syG != null))
          {
            localIterator = paramg.field_favProto.syG.iterator();
            while (localIterator.hasNext())
            {
              localanm = (anm)localIterator.next();
              str1 = d(localanm);
              str2 = u.n(str1, false);
              Log.i("MicroMsg.Fav.FavApiLogic", "toPath:%s, trueDataPath:%s", new Object[] { str1, str2 });
              if ((str1.equals(localc.field_path)) || (str2.equals(localc.field_path))) {
                Log.i("MicroMsg.Fav.FavApiLogic", "copy ret:%s", new Object[] { Long.valueOf(u.on(localanm.Syl, localc.field_path)) });
              }
            }
          }
        }
        ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnService().azZ(localc.field_dataId);
      }
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnService().run();
      AppMethodBeat.o(103305);
      return;
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().ag(17, paramg.field_localId);
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getModService().run();
      AppMethodBeat.o(103305);
      return;
      paramg.field_itemStatus = 9;
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getSendService().run();
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
      Object localObject = paramg.field_favProto.syG;
      if (((List)localObject).size() == 0)
      {
        AppMethodBeat.o(103306);
        return;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        anm localanm = (anm)((Iterator)localObject).next();
        a(paramg, localanm, true);
        a(paramg, localanm);
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
    if (!paramg.djD())
    {
      Log.e("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, not uploading");
      AppMethodBeat.o(103310);
      return;
    }
    Log.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, itemStatu:%d", new Object[] { Integer.valueOf(paramg.field_itemStatus) });
    Iterator localIterator = paramg.field_favProto.syG.iterator();
    while (localIterator.hasNext())
    {
      anm localanm = (anm)localIterator.next();
      c localc = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().aAb(localanm.fEa);
      if ((localc != null) && (localc.field_status != 3))
      {
        localc.field_status = 2;
        ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
        ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnService().aAa(localanm.fEa);
      }
      localc = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().aAb(azJ(localanm.fEa));
      if ((localc != null) && (localc.field_status != 3))
      {
        localc.field_status = 2;
        ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
        ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnService().aAa(azJ(localanm.fEa));
      }
    }
    paramg = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(paramg.field_localId);
    Log.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, after pause data itemStatu:%d", new Object[] { Integer.valueOf(paramg.field_itemStatus) });
    switch (paramg.field_itemStatus)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(103310);
      return;
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().ag(3, paramg.field_localId);
      Log.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(3) });
      AppMethodBeat.o(103310);
      return;
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().ag(6, paramg.field_localId);
      Log.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(6) });
      AppMethodBeat.o(103310);
      return;
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().ag(11, paramg.field_localId);
      Log.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(11) });
      AppMethodBeat.o(103310);
      return;
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().ag(14, paramg.field_localId);
      Log.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(14) });
      AppMethodBeat.o(103310);
      return;
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().ag(16, paramg.field_localId);
      Log.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(16) });
      AppMethodBeat.o(103310);
      return;
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().ag(18, paramg.field_localId);
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
    anm localanm = c(paramg);
    if (localanm == null)
    {
      AppMethodBeat.o(103319);
      return false;
    }
    long l = Util.currentTicks();
    com.tencent.mm.plugin.sight.base.b localb = com.tencent.mm.plugin.sight.base.f.aYg(d(localanm));
    int j;
    int i;
    boolean bool;
    if (localb != null)
    {
      j = localb.getVideoDuration();
      i = localanm.duration;
      if ((i <= 0) || (Math.abs(i - j) >= 2))
      {
        localanm.arp(j);
        bool = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
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
    j localj = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavSearchStorage().Kp(paramg.field_localId);
    if (localj == null)
    {
      localj = new j();
      localj.field_localId = paramg.field_localId;
    }
    for (int i = 1;; i = 0)
    {
      localj.field_tagContent = "";
      Iterator localIterator = paramg.field_tagProto.SAO.iterator();
      String str;
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        localj.field_tagContent = (localj.field_tagContent + " " + str);
      }
      localIterator = paramg.field_tagProto.SAP.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        localj.field_tagContent = (localj.field_tagContent + " " + str);
        ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavTagSetMgr().azW(str);
      }
      localj.field_time = paramg.field_updateTime;
      localj.field_type = paramg.field_type;
      if (i != 0)
      {
        ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavSearchStorage().a(localj);
        AppMethodBeat.o(103332);
        return;
      }
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavSearchStorage().a(localj, new String[] { "localId" });
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
    anw localanw = paramg.field_favProto.RDh;
    if ((localanw != null) && (!Util.isNullOrNil(localanw.SAv)))
    {
      AppMethodBeat.o(103344);
      return;
    }
    if (paramg.field_type == 18)
    {
      if (paramg.field_favProto.SAB.sourceType != 6) {
        break label112;
      }
      b(paramg, false);
    }
    for (;;)
    {
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
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
      paramg = paramg.field_favProto.syG.iterator();
      l = 0L;
      if (paramg.hasNext())
      {
        localObject = (anm)paramg.next();
        if (localObject == null) {
          break label467;
        }
        l = ((anm)localObject).Syi + l;
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
          paramg = paramg.field_favProto.Szr.SBc;
          localStringBuffer.append(paramg);
          break;
          if (paramg == null) {
            break;
          }
          paramg = paramg.field_favProto.syG.iterator();
          int i = 0;
          int m = 0;
          int k = 0;
          int j = 0;
          while (paramg.hasNext())
          {
            localObject = (anm)paramg.next();
            switch (((anm)localObject).dataType)
            {
            case 3: 
            default: 
              i += 1;
              break;
            case 1: 
              if (Util.isNullOrNil(((anm)localObject).desc)) {
                break label464;
              }
              k = ((anm)localObject).desc.getBytes().length + k;
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
    al localal = new al();
    com.tencent.mm.kernel.h.aGY().a(localal, 0);
    AppMethodBeat.o(103324);
  }
  
  public static void u(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(103353);
    if (paramContext != null)
    {
      paramIntent.putExtra("Ksnsupload_type", 1);
      com.tencent.mm.by.c.b(paramContext, "sns", ".ui.SnsUploadUI", paramIntent);
    }
    AppMethodBeat.o(103353);
  }
  
  public static long x(long paramLong, int paramInt)
  {
    AppMethodBeat.i(103323);
    Log.i("MicroMsg.Fav.FavApiLogic", "tryStartBatchGet...");
    long l1 = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().E(paramLong, paramInt);
    long l2 = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().C(paramLong, paramInt);
    Log.i("MicroMsg.Fav.FavApiLogic", "klem, tryStartBatchGet, batchGetTime:%d, itemTiem:%d, updateTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(paramLong) });
    if (l1 == 0L)
    {
      AppMethodBeat.o(103323);
      return l2;
    }
    Object localObject = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().D(l1, paramInt);
    if (((LinkedList)localObject).size() > 0)
    {
      Log.i("MicroMsg.Fav.FavApiLogic", "klem, tryStartBatchGet, batchGetTime:%d, itemTiem:%d, updateTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(paramLong) });
      Log.i("MicroMsg.Fav.FavApiLogic", "klem, tryStartBatchGet, need batch get idList size:%d", new Object[] { Integer.valueOf(((LinkedList)localObject).size()) });
      if (dju())
      {
        Log.i("MicroMsg.Fav.FavApiLogic", "now %d batch-get scene is doing", new Object[] { Integer.valueOf(aj.dkj()) });
        com.tencent.mm.kernel.h.aHF().kcd.cancel(402);
      }
      localObject = new aj((LinkedList)localObject);
      if (!com.tencent.mm.kernel.h.aGY().a((com.tencent.mm.an.q)localObject, 0))
      {
        Log.w("MicroMsg.Fav.FavApiLogic", "do scene BatchGetFav fail");
        aj.dki();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.b
 * JD-Core Version:    0.7.0.1
 */