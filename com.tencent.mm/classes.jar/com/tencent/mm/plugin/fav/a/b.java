package com.tencent.mm.plugin.fav.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.gm;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.g.a.gs.a;
import com.tencent.mm.g.a.gs.b;
import com.tencent.mm.g.a.ms;
import com.tencent.mm.g.a.qv;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.ag.a;
import com.tencent.mm.model.ag.b;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.afz;
import com.tencent.mm.protocal.protobuf.agd;
import com.tencent.mm.protocal.protobuf.agf;
import com.tencent.mm.protocal.protobuf.agi;
import com.tencent.mm.protocal.protobuf.agn;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahb;
import com.tencent.mm.protocal.protobuf.ahd;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.bqq;
import com.tencent.mm.protocal.protobuf.bqt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.bg;
import com.tencent.mm.vfs.i;
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
  private static HashMap<Long, ArrayList<String>> pZr;
  private static long pZs;
  
  static
  {
    AppMethodBeat.i(103360);
    pZr = new HashMap();
    pZs = 0L;
    AppMethodBeat.o(103360);
  }
  
  public static boolean Ch(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = a.pZp;
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
  
  private static com.tencent.mm.vfs.e XR(String paramString)
  {
    AppMethodBeat.i(103279);
    int i = paramString.hashCode();
    paramString = new com.tencent.mm.vfs.e(String.format("%s%s/%d/", new Object[] { com.tencent.mm.kernel.g.afB().gcW, "favorite", Integer.valueOf(i & 0xFF) }));
    if ((!paramString.exists()) || (!paramString.isDirectory())) {
      paramString.mkdirs();
    }
    AppMethodBeat.o(103279);
    return paramString;
  }
  
  public static String XS(String paramString)
  {
    AppMethodBeat.i(103284);
    paramString = paramString + "_t";
    AppMethodBeat.o(103284);
    return paramString;
  }
  
  public static boolean XT(String paramString)
  {
    AppMethodBeat.i(103291);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(103291);
      return false;
    }
    boolean bool = paramString.endsWith("_t");
    AppMethodBeat.o(103291);
    return bool;
  }
  
  public static int XU(String paramString)
  {
    AppMethodBeat.i(184037);
    if ((!bt.isNullOrNil(paramString)) && (paramString.equals("speex")))
    {
      AppMethodBeat.o(184037);
      return -3;
    }
    if ((!bt.isNullOrNil(paramString)) && (paramString.equals("silk")))
    {
      AppMethodBeat.o(184037);
      return -4;
    }
    AppMethodBeat.o(184037);
    return -2;
  }
  
  public static String XV(String paramString)
  {
    AppMethodBeat.i(103303);
    com.tencent.mm.storage.af localaf = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHY(paramString);
    if (localaf != null)
    {
      if (!bt.isNullOrNil(localaf.field_conRemark))
      {
        paramString = localaf.field_conRemark;
        AppMethodBeat.o(103303);
        return paramString;
      }
      if (!bt.isNullOrNil(localaf.field_nickname))
      {
        paramString = localaf.field_nickname;
        AppMethodBeat.o(103303);
        return paramString;
      }
      paramString = localaf.field_username;
      AppMethodBeat.o(103303);
      return paramString;
    }
    AppMethodBeat.o(103303);
    return paramString;
  }
  
  public static String XW(String paramString)
  {
    AppMethodBeat.i(103325);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(103325);
      return null;
    }
    paramString = new com.tencent.mm.vfs.e(chp() + com.tencent.mm.b.g.getMessageDigest(paramString.getBytes()));
    if (paramString.exists())
    {
      paramString = com.tencent.mm.vfs.q.B(paramString.fhU());
      AppMethodBeat.o(103325);
      return paramString;
    }
    AppMethodBeat.o(103325);
    return null;
  }
  
  public static int XX(String paramString)
  {
    AppMethodBeat.i(103336);
    if ((!bt.isNullOrNil(paramString)) && (paramString.equals("speex")))
    {
      AppMethodBeat.o(103336);
      return 1;
    }
    if ((!bt.isNullOrNil(paramString)) && (paramString.equals("silk")))
    {
      AppMethodBeat.o(103336);
      return 2;
    }
    AppMethodBeat.o(103336);
    return 0;
  }
  
  public static g XY(String paramString)
  {
    AppMethodBeat.i(103338);
    g localg = new g();
    localg.field_localId = -1L;
    localg.field_id = -1;
    localg.field_xml = paramString;
    localg.field_type = 18;
    localg.Ya(paramString);
    AppMethodBeat.o(103338);
    return localg;
  }
  
  private static g XZ(String paramString)
  {
    AppMethodBeat.i(103339);
    if ((paramString == null) || (paramString.equals("")))
    {
      ad.e("MicroMsg.Fav.FavApiLogic", "parseSnsNoteInfoXml but xml is null");
      AppMethodBeat.o(103339);
      return null;
    }
    paramString = paramString.replace("cdndataurl", "cdn_dataurl").replace("cdndatakey", "cdn_datakey").replace("cdnthumburl", "cdn_thumburl").replace("cdnthumbkey", "cdn_thumbkey").replace("datasize", "fullsize").replace("thumbsize", "thumbfullsize").replace("sourcename", "datasrcname").replace("sourcetime", "datasrctime").replace("streamlowbandurl", "stream_lowbandurl").replace("streamdataurl", "stream_dataurl").replace("streamweburl", "stream_weburl");
    if (!paramString.startsWith("<noteinfo>")) {
      paramString = "<noteinfo>" + paramString + "</noteinfo>";
    }
    for (;;)
    {
      Map localMap = bw.K(paramString, "noteinfo");
      if (localMap == null)
      {
        ad.e("MicroMsg.Fav.FavApiLogic", "parseSnsNoteInfoXml, FavItemInfo maps null");
        AppMethodBeat.o(103339);
        return null;
      }
      g localg = new g();
      try
      {
        localg.field_favProto = new ago();
        localg.field_type = 18;
        Object localObject = (String)localMap.get(".noteinfo.edittime");
        localg.field_favProto.vu(bt.getLong((String)localObject, 0L));
        localObject = new agi();
        ((agi)localObject).Dix = ((String)localMap.get(".noteinfo.noteeditor"));
        ((agi)localObject).Diw = ((String)localMap.get(".noteinfo.noteauthor"));
        localg.field_favProto.a((agi)localObject);
        localg.field_localId = bt.getLong((String)localMap.get(".noteinfo.favlocalid"), System.currentTimeMillis());
        com.tencent.mm.plugin.fav.a.a.c.a(paramString, localg.field_favProto);
        AppMethodBeat.o(103339);
        return localg;
      }
      catch (Exception paramString)
      {
        ad.printErrStackTrace("MicroMsg.Fav.FavApiLogic", paramString, "", new Object[0]);
        ad.e("MicroMsg.Fav.FavApiLogic", "parseSnsNoteInfoXml , FavItemInfo exception:+%s", new Object[] { paramString.toString() });
        AppMethodBeat.o(103339);
        return null;
      }
    }
  }
  
  public static long a(g paramg)
  {
    AppMethodBeat.i(103261);
    Object localObject = a.pZp;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      if (localObject[i] == paramg.field_type)
      {
        if (paramg.field_favProto != null)
        {
          localObject = paramg.field_favProto.mVb.iterator();
          for (long l1 = 0L;; l1 = ((afy)((Iterator)localObject).next()).Dgu + l1)
          {
            l2 = l1;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
          }
        }
        long l2 = 0L;
        paramg.field_datatotalsize = l2;
        ad.d("MicroMsg.Fav.FavApiLogic", "calFavItemInfoTotalLength id:%d,length:%d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(l2) });
        AppMethodBeat.o(103261);
        return l2;
      }
      i += 1;
    }
    AppMethodBeat.o(103261);
    return 0L;
  }
  
  public static g a(ago paramago)
  {
    AppMethodBeat.i(103342);
    g localg = new g();
    localg.field_favProto = new ago();
    localg.field_type = 18;
    localg.field_favProto = paramago;
    AppMethodBeat.o(103342);
    return localg;
  }
  
  public static afy a(g paramg, String paramString)
  {
    AppMethodBeat.i(103292);
    if ((bt.isNullOrNil(paramString)) || (paramg == null) || (paramg.field_favProto.mVb.size() == 0))
    {
      AppMethodBeat.o(103292);
      return null;
    }
    paramg = paramg.field_favProto.mVb.iterator();
    while (paramg.hasNext())
    {
      afy localafy = (afy)paramg.next();
      if (localafy.dkb.equals(paramString))
      {
        AppMethodBeat.o(103292);
        return localafy;
      }
    }
    AppMethodBeat.o(103292);
    return null;
  }
  
  public static agd a(int paramInt, ago paramago, ahb paramahb)
  {
    AppMethodBeat.i(103262);
    if (paramago == null)
    {
      ad.w("MicroMsg.Fav.FavApiLogic", "proto item is null");
      AppMethodBeat.o(103262);
      return null;
    }
    agd localagd = new agd();
    agu localagu = paramago.DiD;
    if (localagu != null)
    {
      localagd.dpv = localagu.dpv;
      localagd.Dio = localagu.Did;
      localagd.appId = localagu.appId;
      localagd.dbj = localagu.dbj;
    }
    if (paramahb != null)
    {
      if (paramahb.DiQ != null) {
        localagd.Dip.addAll(paramahb.DiQ);
      }
      if (paramahb.DiR != null) {
        localagd.Dip.addAll(paramahb.DiR);
      }
    }
    localagd.dve = paramago;
    localagd.type = paramInt;
    switch (paramInt)
    {
    case 3: 
    case 9: 
    case 13: 
    case 16: 
    case 17: 
    default: 
      ad.w("MicroMsg.Fav.FavApiLogic", "unknown type %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(103262);
      return localagd;
    case 1: 
      localagd.title = "";
      localagd.desc = paramago.desc;
      AppMethodBeat.o(103262);
      return localagd;
    case 4: 
      if ((paramago.mVb != null) && (!paramago.mVb.isEmpty())) {
        localagd.title = ((afy)paramago.mVb.get(0)).title;
      }
      AppMethodBeat.o(103262);
      return localagd;
    case 5: 
      if (paramago.DhE != null)
      {
        localagd.title = paramago.DhE.title;
        localagd.desc = paramago.DhE.Djf;
      }
      if ((bt.isNullOrNil(localagd.title)) && (paramago.mVb != null) && (!paramago.mVb.isEmpty())) {
        localagd.title = ((afy)paramago.mVb.get(0)).title;
      }
      if ((bt.isNullOrNil(localagd.desc)) && (localagu != null)) {
        localagd.desc = localagu.link;
      }
      AppMethodBeat.o(103262);
      return localagd;
    case 6: 
      localagd.title = paramago.iaz;
      if (bt.isNullOrNil(localagd.title)) {
        if (paramago.DhC != null)
        {
          localagd.title = paramago.DhC.dtN;
          localagd.desc = paramago.DhC.label;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(103262);
        return localagd;
        if (paramago.DhC != null) {
          localagd.desc = paramago.DhC.dtN;
        }
      }
    case 2: 
      if ((paramago.mVb != null) && (paramago.mVb.size() > 0)) {
        localagd.title = ((afy)paramago.mVb.get(0)).title;
      }
      AppMethodBeat.o(103262);
      return localagd;
    case 7: 
      if ((paramago.mVb != null) && (!paramago.mVb.isEmpty()))
      {
        localagd.title = ((afy)paramago.mVb.get(0)).title;
        localagd.desc = ((afy)paramago.mVb.get(0)).desc;
      }
      AppMethodBeat.o(103262);
      return localagd;
    case 8: 
      localagd.title = paramago.title;
      if ((bt.isNullOrNil(localagd.title)) && (paramago.mVb != null) && (!paramago.mVb.isEmpty())) {
        localagd.title = ((afy)paramago.mVb.get(0)).title;
      }
      AppMethodBeat.o(103262);
      return localagd;
    case 10: 
    case 11: 
      if (paramago.DhG != null)
      {
        localagd.title = paramago.DhG.title;
        localagd.desc = paramago.DhG.desc;
      }
      AppMethodBeat.o(103262);
      return localagd;
    case 12: 
    case 15: 
      if (paramago.DhI != null)
      {
        localagd.title = paramago.DhI.title;
        localagd.desc = paramago.DhI.desc;
      }
      AppMethodBeat.o(103262);
      return localagd;
    }
    paramago = paramago.mVb;
    if (paramago == null)
    {
      AppMethodBeat.o(103262);
      return null;
    }
    paramago = paramago.iterator();
    while (paramago.hasNext())
    {
      paramahb = (afy)paramago.next();
      if (1 == paramahb.dataType) {
        localagd.title = paramahb.desc;
      }
    }
    AppMethodBeat.o(103262);
    return localagd;
  }
  
  public static String a(afy paramafy)
  {
    AppMethodBeat.i(103283);
    if ((paramafy == null) || (bt.isNullOrNil(paramafy.dkb)))
    {
      AppMethodBeat.o(103283);
      return "";
    }
    paramafy = XS(paramafy.dkb);
    paramafy = com.tencent.mm.vfs.q.B(new com.tencent.mm.vfs.e(XR(paramafy), paramafy).fhU());
    AppMethodBeat.o(103283);
    return paramafy;
  }
  
  public static ArrayList<g> a(List<String> paramList1, List<String> paramList2, int paramInt, List<g> paramList, Set<Integer> paramSet, w paramw)
  {
    AppMethodBeat.i(103333);
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(Integer.valueOf(paramInt));
    paramList1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavSearchStorage().b(paramList1, paramList2, localArrayList);
    paramList2 = new ArrayList();
    if (paramList1.size() == 0)
    {
      AppMethodBeat.o(103333);
      return paramList2;
    }
    int i;
    label336:
    for (int j = 0;; j = i)
    {
      if (j + 20 < paramList1.size())
      {
        i = j + 20;
        ad.v("MicroMsg.Fav.FavApiLogic", "start:%d  end:%d listSize:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramList1.size()) });
        localArrayList = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(paramList1.subList(j, i), paramList, paramSet, paramw);
        if ((localArrayList != null) && (localArrayList.size() > 0))
        {
          if (paramInt != 8) {
            break label240;
          }
          paramList2.addAll(b(localArrayList, 8, 8));
        }
      }
      for (;;)
      {
        if (i < paramList1.size()) {
          break label336;
        }
        AppMethodBeat.o(103333);
        return paramList2;
        i = paramList1.size();
        break;
        label240:
        if (paramInt == 5) {
          paramList2.addAll(b(localArrayList, 5, 5));
        } else if (paramInt == 7) {
          paramList2.addAll(b(localArrayList, 7, 7));
        } else if (paramInt == 6) {
          paramList2.addAll(b(localArrayList, 6, 6));
        } else if (paramInt == 3) {
          paramList2.addAll(b(localArrayList, 3, 3));
        } else {
          paramList2.addAll(localArrayList);
        }
      }
    }
  }
  
  public static ArrayList<g> a(List<String> paramList1, List<String> paramList2, List<Integer> paramList, List<g> paramList3, Set<Integer> paramSet, w paramw)
  {
    AppMethodBeat.i(103335);
    paramList1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavSearchStorage().b(paramList1, paramList2, paramList);
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
        ad.v("MicroMsg.Fav.FavApiLogic", "start:%d  end:%d listSize:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramList1.size()) });
        localObject = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(paramList1.subList(j, i), paramList3, paramSet, paramw);
        if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
          break label338;
        }
        if (paramList.contains(Integer.valueOf(8))) {
          localObject = ((ArrayList)localObject).iterator();
        }
      }
      else
      {
        for (;;)
        {
          label188:
          if (!((Iterator)localObject).hasNext()) {
            break label338;
          }
          g localg = (g)((Iterator)localObject).next();
          if (localg.field_type == 18) {
            for (;;)
            {
              try
              {
                LinkedList localLinkedList = localg.field_favProto.mVb;
                j = 1;
                if (j >= localLinkedList.size()) {
                  continue;
                }
                int k = ((afy)localLinkedList.get(j)).dataType;
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
                break label188;
              }
              paramList2.add(localg);
              break label188;
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
      label338:
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
    if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage() == null)
    {
      ad.e("MicroMsg.Fav.FavApiLogic", "getItemList error, getFavItemInfoStorage null.");
      AppMethodBeat.o(103322);
      return null;
    }
    if (paramLong == 0L)
    {
      paramSet = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(paramInt, paramSet, paramw);
      AppMethodBeat.o(103322);
      return paramSet;
    }
    paramSet = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().b(paramLong, paramInt, paramSet, paramw);
    AppMethodBeat.o(103322);
    return paramSet;
  }
  
  public static void a(long paramLong, agf paramagf, String paramString1, String paramString2, ArrayList<String> paramArrayList, Context paramContext)
  {
    AppMethodBeat.i(103355);
    if ((paramagf == null) || (paramContext == null))
    {
      AppMethodBeat.o(103355);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("KFavLocSigleView", true);
    localIntent.putExtra("map_view_type", 2);
    localIntent.putExtra("kFavInfoLocalId", paramLong);
    localIntent.putExtra("kwebmap_slat", paramagf.lat);
    localIntent.putExtra("kwebmap_lng", paramagf.lng);
    localIntent.putExtra("kPoiName", paramagf.dtN);
    localIntent.putExtra("Kwebmap_locaion", paramagf.label);
    if (paramagf.dpd >= 0) {
      localIntent.putExtra("kwebmap_scale", paramagf.dpd);
    }
    localIntent.putExtra("kisUsername", paramString1);
    localIntent.putExtra("kwebmap_from_to", true);
    localIntent.putExtra("kRemark", paramString2);
    localIntent.putExtra("kTags", paramArrayList);
    localIntent.putExtra("kFavCanDel", true);
    localIntent.putExtra("kFavCanRemark", true);
    d.b(paramContext, "location", ".ui.RedirectUI", localIntent);
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
      String str = aj.eFC() + ".plugin.fav";
      paramIntent = paramString;
      if (paramString.startsWith(".")) {
        paramIntent = str + paramString;
      }
      localIntent.setClassName(aj.getPackageName(), paramIntent);
      Class.forName(paramIntent, false, paramContext.getClassLoader());
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).startActivityForResult(localIntent, paramInt, paramBundle);
      }
      AppMethodBeat.o(103350);
      return;
    }
    catch (Exception paramContext)
    {
      ad.e("MicroMsg.Fav.FavApiLogic", "Class Not Found when startActivity %s", new Object[] { paramContext });
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
      String str = aj.eFC() + ".plugin.fav";
      paramIntent = paramString;
      if (paramString.startsWith(".")) {
        paramIntent = str + paramString;
      }
      localIntent.setClassName(aj.getPackageName(), paramIntent);
      Class.forName(paramIntent, false, paramContext.getClassLoader());
      if ((paramContext instanceof Activity))
      {
        paramString = new com.tencent.mm.hellhoundlib.b.a().bd(paramBundle).bd(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.adn(), "com/tencent/mm/plugin/fav/api/FavApiLogic", "startFavActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
        paramContext.startActivity((Intent)paramString.lS(0), (Bundle)paramString.lS(1));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/fav/api/FavApiLogic", "startFavActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
        AppMethodBeat.o(103348);
        return;
      }
      localIntent.addFlags(268435456);
      paramString = new com.tencent.mm.hellhoundlib.b.a().bd(paramBundle).bd(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.adn(), "com/tencent/mm/plugin/fav/api/FavApiLogic", "startFavActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
      paramContext.startActivity((Intent)paramString.lS(0), (Bundle)paramString.lS(1));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/fav/api/FavApiLogic", "startFavActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
      AppMethodBeat.o(103348);
      return;
    }
    catch (Exception paramContext)
    {
      ad.e("MicroMsg.Fav.FavApiLogic", "Class Not Found when startActivity %s", new Object[] { paramContext });
      AppMethodBeat.o(103348);
    }
  }
  
  private static void a(gs paramgs)
  {
    AppMethodBeat.i(103268);
    if (bt.isNullOrNil(paramgs.dkc.desc))
    {
      paramgs.dkd.ret = -1;
      AppMethodBeat.o(103268);
      return;
    }
    Object localObject = XZ(paramgs.dkc.desc);
    if ((localObject == null) || (((g)localObject).field_localId <= 0L))
    {
      paramgs.dkd.ret = -1;
      AppMethodBeat.o(103268);
      return;
    }
    boolean bool = e((g)localObject);
    String str = paramgs.dkc.dki;
    if (bool)
    {
      paramgs.dkd.ret = 1;
      paramgs = (ArrayList)pZr.get(Long.valueOf(((g)localObject).field_localId));
      if (paramgs != null)
      {
        if (paramgs.contains(str)) {
          paramgs.remove(str);
        }
        if (paramgs.size() == 0) {
          pZr.remove(Long.valueOf(((g)localObject).field_localId));
        }
      }
      AppMethodBeat.o(103268);
      return;
    }
    if (bt.isNullOrNil(str))
    {
      paramgs.dkd.ret = -1;
      AppMethodBeat.o(103268);
      return;
    }
    long l = ((g)localObject).field_localId;
    ArrayList localArrayList = (ArrayList)pZr.get(Long.valueOf(l));
    localObject = localArrayList;
    if (localArrayList == null) {
      localObject = new ArrayList();
    }
    ((ArrayList)localObject).add(str);
    pZr.put(Long.valueOf(l), localObject);
    localObject = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(l);
    if ((localObject == null) || (((g)localObject).field_localId <= 0L))
    {
      paramgs.dkd.ret = -1;
      AppMethodBeat.o(103268);
      return;
    }
    if ((e((g)localObject)) || (((g)localObject).field_itemStatus == 10))
    {
      paramgs.dkd.ret = -1;
      com.tencent.mm.kernel.g.afE().m(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103255);
          b.d(this.pZt);
          AppMethodBeat.o(103255);
        }
      }, 500L);
      AppMethodBeat.o(103268);
      return;
    }
    paramgs.dkd.ret = -1;
    AppMethodBeat.o(103268);
  }
  
  private static void a(c paramc, g paramg)
  {
    AppMethodBeat.i(103295);
    Iterator localIterator = paramg.field_favProto.mVb.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      afy localafy = (afy)localIterator.next();
      if ((localafy.dataType != 1) && (localafy.dataType != 6))
      {
        if (!bt.isNullOrNil(localafy.DfZ)) {
          break label189;
        }
        i += 1;
      }
    }
    label189:
    for (;;)
    {
      break;
      if (i == 0)
      {
        if (paramg.field_id > 0)
        {
          ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ab(17, paramc.field_favLocalId);
          ((af)com.tencent.mm.kernel.g.ad(af.class)).getModService().run();
          AppMethodBeat.o(103295);
          return;
        }
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ab(9, paramc.field_favLocalId);
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getSendService().run();
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
      ad.w("MicroMsg.Fav.FavApiLogic", "modeTag, item info is null");
      AppMethodBeat.o(103346);
      return;
    }
    Object localObject1 = new LinkedList();
    Object localObject2 = new bqq();
    ((bqq)localObject2).DON = 4;
    ((bqq)localObject2).DOO = 0;
    ((LinkedList)localObject1).add(localObject2);
    localObject2 = new LinkedList();
    bqt localbqt = new bqt();
    localbqt.scP = "favitem.taglist";
    localbqt.mBH = 1;
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramg.field_tagProto.DiR.size();
    int i = 0;
    while (i < j)
    {
      localStringBuffer.append("<tag>").append(bt.aGf((String)paramg.field_tagProto.DiR.get(i))).append("</tag>");
      i += 1;
    }
    localbqt.vJI = localStringBuffer.toString();
    ad.v("MicroMsg.Fav.FavApiLogic", "do net scene mod tag, id=%d, tag=%s", new Object[] { Integer.valueOf(paramg.field_id), localbqt.vJI });
    ((LinkedList)localObject2).add(localbqt);
    if (paramg.field_id > 0)
    {
      localObject1 = new am(paramg.field_id, (LinkedList)localObject1, (LinkedList)localObject2);
      com.tencent.mm.kernel.g.aeS().a((n)localObject1, 0);
      h.j(paramg.field_id, j, paramInt);
      AppMethodBeat.o(103346);
      return;
    }
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getEditService().a(paramg.field_localId, (LinkedList)localObject1, (LinkedList)localObject2, paramInt);
    AppMethodBeat.o(103346);
  }
  
  public static void a(g paramg, afy paramafy)
  {
    AppMethodBeat.i(103308);
    if (bt.isNullOrNil(paramafy.dkb))
    {
      AppMethodBeat.o(103308);
      return;
    }
    String str = XS(paramafy.dkb);
    c localc = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().Yk(str);
    Object localObject = localc;
    if (localc != null)
    {
      localObject = localc;
      if (localc.field_status == 3)
      {
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().b(localc, new String[] { "dataId" });
        localObject = null;
      }
    }
    if ((localObject != null) && (((c)localObject).field_type == 1))
    {
      ((c)localObject).field_status = 1;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a((c)localObject, new String[] { "dataId" });
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().Yi(str);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
      AppMethodBeat.o(103308);
      return;
    }
    localObject = new com.tencent.mm.vfs.e(a(paramafy));
    if ((!bt.isNullOrNil(paramafy.DfV)) && (!bt.isNullOrNil(paramafy.gHu)) && (!((com.tencent.mm.vfs.e)localObject).exists()))
    {
      a(paramafy, paramg, 1);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().Yi(str);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
    }
    AppMethodBeat.o(103308);
  }
  
  public static void a(g paramg, afy paramafy, boolean paramBoolean)
  {
    AppMethodBeat.i(103307);
    if ((paramg == null) || (bt.isNullOrNil(paramafy.dkb)))
    {
      AppMethodBeat.o(103307);
      return;
    }
    ad.i("MicroMsg.Fav.FavApiLogic", "restart cdndata download, favId %d, favLocalId %d, dataId %s", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), paramafy.dkb });
    Object localObject2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().Yk(paramafy.dkb);
    Object localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((c)localObject2).field_status == 3)
      {
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().b((c)localObject2, new String[] { "dataId" });
        localObject1 = null;
      }
    }
    localObject2 = localObject1;
    if (localObject1 != null) {
      if ((!bt.isNullOrNil(((c)localObject1).field_cdnUrl)) && (!bt.isNullOrNil(((c)localObject1).field_cdnKey)) && (!bt.isNullOrNil(((c)localObject1).field_dataId)) && (((c)localObject1).field_cdnUrl.equals(paramafy.DfZ)) && (((c)localObject1).field_cdnKey.equals(paramafy.Dgb)))
      {
        localObject2 = localObject1;
        if (((c)localObject1).field_dataId.equals(paramafy.dkb)) {}
      }
      else
      {
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().b((c)localObject1, new String[] { "dataId" });
        localObject2 = null;
      }
    }
    if ((localObject2 != null) && (((c)localObject2).field_type == 1))
    {
      ad.i("MicroMsg.Fav.FavApiLogic", "klem data not download completed.");
      ((c)localObject2).field_status = 1;
      ((c)localObject2).field_path = d(paramafy);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a((c)localObject2, new String[] { "dataId" });
      if (paramBoolean)
      {
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().Yi(paramafy.dkb);
        if ((!bt.isNullOrNil(paramafy.Dhb)) && (paramafy.Dhb.equals("WeNoteHtmlFile")))
        {
          paramg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().Yk(paramafy.dkb);
          ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().d(paramg);
        }
      }
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
      AppMethodBeat.o(103307);
      return;
    }
    localObject1 = new com.tencent.mm.vfs.e(d(paramafy));
    if ((!bt.isNullOrNil(paramafy.Dgb)) && (!bt.isNullOrNil(paramafy.DfZ)) && (!((com.tencent.mm.vfs.e)localObject1).exists()))
    {
      ad.i("MicroMsg.Fav.FavApiLogic", "klem big img not exist, start download.");
      long l = System.currentTimeMillis();
      a(paramafy, paramg, 1, true);
      if (paramBoolean)
      {
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().Yi(paramafy.dkb);
        if ((!bt.isNullOrNil(paramafy.Dhb)) && (paramafy.Dhb.equals("WeNoteHtmlFile")))
        {
          paramg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().Yk(paramafy.dkb);
          ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().d(paramg);
        }
      }
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
      ad.i("MicroMsg.Fav.FavApiLogic", "insert cdn item use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
    AppMethodBeat.o(103307);
  }
  
  public static void a(g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(103286);
    h(paramg);
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavSearchStorage().pU(paramg.field_localId);
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().A(paramg);
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().pQ(paramg.field_localId);
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().w(paramg);
    if (paramBoolean)
    {
      Set localSet = cho();
      localSet.add(paramg.field_id);
      d(localSet);
      chq();
    }
    if (paramg.field_type == 18)
    {
      long l = paramg.field_localId;
      if (l <= 0L)
      {
        AppMethodBeat.o(103286);
        return;
      }
      paramg = new cm();
      paramg.deH.deI = l;
      com.tencent.mm.sdk.b.a.ESL.l(paramg);
    }
    AppMethodBeat.o(103286);
  }
  
  public static void a(afy paramafy, int paramInt, long paramLong)
  {
    AppMethodBeat.i(103329);
    if (bt.isNullOrNil(paramafy.dkb))
    {
      AppMethodBeat.o(103329);
      return;
    }
    if ((bt.isNullOrNil(paramafy.DfV)) || (bt.isNullOrNil(paramafy.gHu)))
    {
      AppMethodBeat.o(103329);
      return;
    }
    String str = XS(paramafy.dkb);
    c localc = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().Yk(str);
    Object localObject = localc;
    if (localc != null) {
      if (localc.field_status != 3)
      {
        localObject = localc;
        if (localc.field_status != 4) {}
      }
      else
      {
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().b(localc, new String[] { "dataId" });
        localObject = null;
      }
    }
    if ((localObject != null) && (((c)localObject).field_type == 1))
    {
      ((c)localObject).field_status = 1;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a((c)localObject, new String[] { "dataId" });
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().Yi(str);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
      AppMethodBeat.o(103329);
      return;
    }
    localObject = new com.tencent.mm.vfs.e(a(paramafy));
    if ((!bt.isNullOrNil(paramafy.DfV)) && (!bt.isNullOrNil(paramafy.gHu)) && (!((com.tencent.mm.vfs.e)localObject).exists()))
    {
      localObject = new g();
      ((g)localObject).field_localId = paramLong;
      ((g)localObject).field_id = -1;
      ((g)localObject).field_type = paramInt;
      a(paramafy, (g)localObject, 1);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().Yi(str);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
    }
    AppMethodBeat.o(103329);
  }
  
  public static void a(afy paramafy, g paramg, int paramInt)
  {
    AppMethodBeat.i(103296);
    if ((paramInt == 1) && ((paramafy.DgF <= 0L) || (bt.isNullOrNil(paramafy.DfV)) || (bt.isNullOrNil(paramafy.gHu))))
    {
      ad.e("MicroMsg.Fav.FavApiLogic", "insertCdnThumbInfo, type recv, cdndataurl must not be null!");
      AppMethodBeat.o(103296);
      return;
    }
    if ((paramInt == 0) && (bt.isNullOrNil(a(paramafy))))
    {
      ad.e("MicroMsg.Fav.FavApiLogic", "insertCdnThumbInfo, type send, path must not be null!");
      AppMethodBeat.o(103296);
      return;
    }
    String str = XS(paramafy.dkb);
    if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().Yk(str) != null)
    {
      ad.w("MicroMsg.Fav.FavApiLogic", "cdn info exist, id[%s], return", new Object[] { str });
      AppMethodBeat.o(103296);
      return;
    }
    ad.v("MicroMsg.Fav.FavApiLogic", "insert cdn thumb info, fav local id[%d] fav id[%d]", new Object[] { Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
    c localc = new c();
    localc.field_cdnKey = paramafy.DfV;
    localc.field_cdnUrl = paramafy.gHu;
    localc.field_dataId = str;
    localc.field_favLocalId = paramg.field_localId;
    localc.field_totalLen = ((int)paramafy.DgF);
    localc.field_type = paramInt;
    localc.field_status = 1;
    localc.field_path = a(paramafy);
    localc.field_modifyTime = bt.eGO();
    localc.field_attrFlag |= 1L;
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().f(localc);
    if (paramInt == 1)
    {
      c(localc);
      AppMethodBeat.o(103296);
      return;
    }
    b(localc);
    AppMethodBeat.o(103296);
  }
  
  public static void a(afy paramafy, g paramg, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(103297);
    if ((paramInt == 1) && ((bt.isNullOrNil(paramafy.Dgb)) || (bt.isNullOrNil(paramafy.DfZ))))
    {
      ad.e("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo, type recv, cdndataurl must not be null!");
      AppMethodBeat.o(103297);
      return;
    }
    if ((paramInt == 0) && (bt.isNullOrNil(d(paramafy))))
    {
      ad.e("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo, type send, path must not be null!");
      AppMethodBeat.o(103297);
      return;
    }
    if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().Yk(paramafy.dkb) != null)
    {
      ad.v("MicroMsg.Fav.FavApiLogic", "cdn info exist, id[%s], return", new Object[] { paramafy.dkb });
      AppMethodBeat.o(103297);
      return;
    }
    ad.i("MicroMsg.Fav.FavApiLogic", "insert cdn data info, fav local id[%d] fav id[%d]", new Object[] { Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
    c localc = new c();
    localc.field_dataId = paramafy.dkb;
    localc.field_totalLen = ((int)paramafy.Dgu);
    localc.field_type = paramInt;
    localc.field_favLocalId = paramg.field_localId;
    localc.field_cdnKey = paramafy.Dgb;
    localc.field_cdnUrl = paramafy.DfZ;
    localc.field_path = d(paramafy);
    boolean bool;
    int i;
    label405:
    if (paramafy.dataType == 3)
    {
      localc.field_dataType = XU(paramafy.Dgo);
      localc.field_modifyTime = bt.eGO();
      bool = ay.isWifi(aj.getContext());
      if (paramInt == 0)
      {
        ad.i("MicroMsg.Fav.FavApiLogic", "can auto upload, force %B, isWifi %B, dataType %d, totalLen %d", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), Integer.valueOf(localc.field_dataType), Integer.valueOf(localc.field_totalLen) });
        if (!paramBoolean) {
          break label475;
        }
        i = 1;
        label325:
        if (i == 0) {
          break label615;
        }
        localc.field_status = 1;
        ad.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo upload status traning");
      }
      label344:
      if (paramInt == 1)
      {
        ad.i("MicroMsg.Fav.FavApiLogic", "can auto download, force %B, isWifi %B, dataType %d, totalLen %d", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), Integer.valueOf(localc.field_dataType), Integer.valueOf(localc.field_totalLen) });
        if (!paramBoolean) {
          break label632;
        }
        i = 1;
        if (i == 0) {
          break label758;
        }
        localc.field_status = 1;
        ad.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo download status traning");
      }
    }
    for (;;)
    {
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().f(localc);
      if (paramInt != 1) {
        break label775;
      }
      c(localc);
      AppMethodBeat.o(103297);
      return;
      localc.field_dataType = paramafy.dataType;
      break;
      label475:
      if (bool)
      {
        i = 1;
        break label325;
      }
      if ((localc.field_dataType != 8) && (localc.field_dataType != 4) && (localc.field_dataType != 15))
      {
        i = 1;
        break label325;
      }
      long l2 = aj.getContext().getSharedPreferences(aj.eFD(), 0).getLong("fav_mx_auto_upload_size", 0L);
      long l1 = l2;
      if (l2 == 0L) {
        l1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFileSizeLimit(true);
      }
      if (localc.field_totalLen <= l1)
      {
        ad.i("MicroMsg.Fav.FavApiLogic", "match max auto upload, max size %d", new Object[] { Long.valueOf(l1) });
        i = 1;
        break label325;
      }
      i = 0;
      break label325;
      label615:
      localc.field_status = 4;
      ad.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo upload status pause");
      break label344;
      label632:
      if (bool)
      {
        i = 1;
        break label405;
      }
      if ((localc.field_dataType != 8) && (localc.field_dataType != 4) && (localc.field_dataType != 15))
      {
        i = 1;
        break label405;
      }
      l1 = aj.getContext().getSharedPreferences(aj.eFD(), 0).getLong("fav_mx_auto_download_size", ((af)com.tencent.mm.kernel.g.ad(af.class)).getFileSizeLimit(true));
      if (localc.field_totalLen <= l1)
      {
        ad.i("MicroMsg.Fav.FavApiLogic", "match max auto download, max size %d", new Object[] { Long.valueOf(l1) });
        i = 1;
        break label405;
      }
      i = 0;
      break label405;
      label758:
      localc.field_status = 4;
      ad.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo download status pause");
    }
    label775:
    b(localc);
    AppMethodBeat.o(103297);
  }
  
  public static void a(String paramString1, Context paramContext, String paramString2)
  {
    AppMethodBeat.i(168687);
    if (bt.isNullOrNil(paramString1))
    {
      ad.w("MicroMsg.Fav.FavApiLogic", "share image to friend fail, imgPath is null");
      AppMethodBeat.o(168687);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Retr_File_Name", paramString1);
    localIntent.putExtra("Retr_Compress_Type", 0);
    localIntent.putExtra("Retr_Msg_Type", 0);
    localIntent.putExtra("msg_uuid", paramString2);
    d.e(paramContext, ".ui.transmit.MsgRetransmitUI", localIntent);
    AppMethodBeat.o(168687);
  }
  
  public static boolean a(long paramLong, Runnable paramRunnable)
  {
    AppMethodBeat.i(103331);
    boolean bool = a(((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(paramLong), true, paramRunnable);
    AppMethodBeat.o(103331);
    return bool;
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
      ad.w("MicroMsg.Fav.FavApiLogic", "delete fav item fail, item is null");
      aq.f(paramRunnable);
      AppMethodBeat.o(103287);
      return false;
    }
    if (Looper.myLooper() == com.tencent.mm.kernel.g.afE().EUN.getLooper())
    {
      ad.i("MicroMsg.Fav.FavApiLogic", "delete favItem id %d, localId %d, needBatchDel %B, do directly", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), Boolean.valueOf(paramBoolean) });
      a(paramg, paramBoolean);
      aq.f(paramRunnable);
      i(paramg);
    }
    for (;;)
    {
      AppMethodBeat.o(103287);
      return true;
      ad.i("MicroMsg.Fav.FavApiLogic", "delete favItem id %d, localId %d, needBatchDel %B, post to worker", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), Boolean.valueOf(paramBoolean) });
      com.tencent.mm.kernel.g.afE().ax(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103256);
          ad.i("MicroMsg.Fav.FavApiLogic", "delete favItem id %d, localId %d, needBatchDel %B, do on worker thread", new Object[] { Integer.valueOf(this.pZu.field_id), Long.valueOf(this.pZu.field_localId), Boolean.valueOf(paramBoolean) });
          b.a(this.pZu, paramBoolean);
          aq.f(paramRunnable);
          b.s(this.pZu);
          AppMethodBeat.o(103256);
        }
      });
    }
  }
  
  public static String[] a(g paramg, ap paramap)
  {
    Object localObject2 = null;
    AppMethodBeat.i(103356);
    if (paramg == null)
    {
      ad.w("MicroMsg.Fav.FavApiLogic", "GetThumbUrlAndLocalPath favItemInfo is null");
      AppMethodBeat.o(103356);
      return null;
    }
    final afy localafy = c(paramg);
    String[] arrayOfString = new String[2];
    Runnable local3 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(103257);
        b.a(this.pZx, localafy);
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
      if (localafy != null)
      {
        arrayOfString[0] = a(localafy);
        arrayOfString[1] = localafy.deE;
        paramap.post(local3);
      }
    case 5: 
    case 10: 
    case 15: 
    case 11: 
      for (;;)
      {
        ad.d("MicroMsg.Fav.FavApiLogic", "GetThumbUrlAndLocalPath thumbPath %s, thumbUrl %s, type %d", new Object[] { arrayOfString[0], arrayOfString[1], Integer.valueOf(paramg.field_type) });
        AppMethodBeat.o(103356);
        return arrayOfString;
        localObject1 = paramg.field_favProto.DhE;
        if (localafy == null)
        {
          if (localObject1 != null) {
            arrayOfString[1] = ((ahd)localObject1).thumbUrl;
          }
        }
        else
        {
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = ((ahd)localObject1).thumbUrl)
          {
            localObject2 = localObject1;
            if (bt.isNullOrNil((String)localObject1)) {
              localObject2 = localafy.deE;
            }
            arrayOfString[0] = a(localafy);
            arrayOfString[1] = localObject2;
            paramap.post(local3);
            break;
          }
          paramap = paramg.field_favProto.DhG;
          if (paramap != null)
          {
            arrayOfString[1] = paramap.thumbUrl;
            continue;
            paramap = paramg.field_favProto.DhI;
            if (paramap != null)
            {
              arrayOfString[1] = paramap.thumbUrl;
              continue;
              paramap = paramg.field_favProto.DhG;
              if (paramap != null) {
                arrayOfString[1] = paramap.thumbUrl;
              }
            }
          }
        }
      }
    }
    if (paramg.field_favProto.mVb != null)
    {
      Iterator localIterator = paramg.field_favProto.mVb.iterator();
      label375:
      localObject1 = localObject2;
      if (localIterator.hasNext())
      {
        localObject1 = (afy)localIterator.next();
        if (((afy)localObject1).dataType != 2) {
          break label435;
        }
        localObject1 = d((afy)localObject1);
        paramap.post(local3);
      }
    }
    for (;;)
    {
      arrayOfString[0] = localObject1;
      arrayOfString[1] = localafy.deE;
      break;
      label435:
      if (((afy)localObject1).dataType != 15) {
        break label375;
      }
      localObject1 = a((afy)localObject1);
      paramap.post(local3);
    }
  }
  
  public static String aS(float paramFloat)
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
  
  public static long b(g paramg)
  {
    AppMethodBeat.i(103263);
    if (paramg == null)
    {
      AppMethodBeat.o(103263);
      return 0L;
    }
    paramg = paramg.field_favProto.mVb.iterator();
    afy localafy;
    for (int i = 0; paramg.hasNext(); i = (int)(localafy.Dgu + l))
    {
      localafy = (afy)paramg.next();
      l = i;
    }
    long l = i;
    AppMethodBeat.o(103263);
    return l;
  }
  
  public static String b(ago paramago)
  {
    AppMethodBeat.i(103358);
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramago != null) && (paramago.mVb != null))
    {
      paramago = paramago.mVb.iterator();
      while (paramago.hasNext()) {
        localStringBuilder.append(((afy)paramago.next()).dkb).append(";");
      }
    }
    paramago = localStringBuilder.toString();
    AppMethodBeat.o(103358);
    return paramago;
  }
  
  private static ArrayList<g> b(ArrayList<g> paramArrayList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103334);
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    g localg1;
    if (paramArrayList.hasNext())
    {
      localg1 = (g)paramArrayList.next();
      if ((localg1.field_type != 18) && (localg1.field_type != 14)) {}
    }
    for (;;)
    {
      try
      {
        LinkedList localLinkedList = localg1.field_favProto.mVb;
        if (localg1.field_type != 18) {
          break label374;
        }
        i = 1;
        if (i >= localLinkedList.size()) {
          break;
        }
        afy localafy = (afy)localLinkedList.get(i);
        if (localafy.dataType != paramInt1) {
          break label379;
        }
        g localg2 = localg1.chL();
        localg2.field_type = paramInt2;
        localg2.pZE = true;
        localg2.pZF = localg1;
        localg2.djR = (localg1.field_localId + "_" + localafy.dkb);
        localg2.pZG = localafy.dkb;
        localg2.field_favProto = com.tencent.mm.plugin.fav.a.a.c.c(localg1.field_favProto);
        localg2.field_favProto.mVb = new LinkedList();
        localg2.field_favProto.mVb.add(localafy);
        localg2.field_favProto.aEj(localafy.title);
        if (localafy.DgT != null)
        {
          if (paramInt1 == 6) {
            localg2.field_favProto.d(localafy.DgT.DhC);
          }
        }
        else
        {
          localArrayList.add(localg2);
          break label379;
        }
        if (paramInt1 != 5) {
          continue;
        }
        localg2.field_favProto.b(localafy.DgT.DhE);
        continue;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.Fav.FavApiLogic", "getSearchList() [%s] Exception:%s %s", new Object[] { Integer.valueOf(paramInt1), localException.getClass().getSimpleName(), localException.getMessage() });
      }
      localArrayList.add(localException);
      break;
      AppMethodBeat.o(103334);
      return localArrayList;
      label374:
      int i = 0;
      continue;
      label379:
      i += 1;
    }
  }
  
  public static void b(Context paramContext, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(204834);
    a(paramContext, paramString, paramIntent, null);
    AppMethodBeat.o(204834);
  }
  
  private static void b(gs paramgs)
  {
    AppMethodBeat.i(103341);
    g localg = XZ(paramgs.dkc.desc);
    if (localg == null)
    {
      AppMethodBeat.o(103341);
      return;
    }
    if ((localg.field_favProto != null) && (localg.field_favProto.mVb != null))
    {
      Iterator localIterator = localg.field_favProto.mVb.iterator();
      while (localIterator.hasNext())
      {
        afy localafy = (afy)localIterator.next();
        if (localafy.dataType == 20)
        {
          localafy.ux(true);
          localafy.uw(true);
          localafy.aDz("");
          localafy.aDp("");
          localafy.aDq("");
          localafy.aDn("");
          localafy.aDo("");
        }
      }
    }
    paramgs.dkc.deS = localg.field_favProto;
    AppMethodBeat.o(103341);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(103293);
    int i = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().x(paramc.field_favLocalId, 0);
    ad.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus, upload data status:%d, favlocalId:%d", new Object[] { Integer.valueOf(i), Long.valueOf(paramc.field_favLocalId) });
    g localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(paramc.field_favLocalId);
    if (localg == null)
    {
      ad.e("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus iteminfo null");
      AppMethodBeat.o(103293);
      return;
    }
    if (localg.chK())
    {
      ad.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus waiting server upload skip.");
      AppMethodBeat.o(103293);
      return;
    }
    if ((paramc.field_status == 3) && (i != paramc.field_status) && (localg.field_type == 18) && (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().Yk(paramc.field_dataId).field_status == 3))
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
      if (localg.chJ()) {
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ab(15, paramc.field_favLocalId);
      }
      for (;;)
      {
        ad.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus, continue upload data, favlocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
        AppMethodBeat.o(103293);
        return;
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ab(4, paramc.field_favLocalId);
      }
      if (localg.chJ()) {
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ab(16, paramc.field_favLocalId);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.vKh.f(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(localg.field_type), Integer.valueOf(-5), Long.valueOf(b(localg)), Long.valueOf(h.pL(localg.field_localId)) });
        ad.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus, error, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
        AppMethodBeat.o(103293);
        return;
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ab(6, paramc.field_favLocalId);
      }
      AppMethodBeat.o(103293);
      return;
      if (localg.field_type == 18)
      {
        a(paramc, localg);
        AppMethodBeat.o(103293);
        return;
      }
      if (localg.chJ())
      {
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ab(17, paramc.field_favLocalId);
        ad.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus start mod faviteminfo, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getModService().run();
        AppMethodBeat.o(103293);
        return;
      }
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ab(9, paramc.field_favLocalId);
      ad.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus start send faviteminfo, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getSendService().run();
      AppMethodBeat.o(103293);
      return;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ab(6, paramc.field_favLocalId);
      ad.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus pause, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
    }
  }
  
  private static void b(g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(103343);
    agi localagi = new agi();
    if (!paramBoolean) {
      localagi.Diw = com.tencent.mm.model.u.aqG();
    }
    localagi.Dix = com.tencent.mm.model.u.aqG();
    paramg.field_favProto.vu(bt.aGK());
    paramg.field_favProto.a(localagi);
    AppMethodBeat.o(103343);
  }
  
  public static void b(afy paramafy, int paramInt, long paramLong)
  {
    AppMethodBeat.i(103330);
    if (bt.isNullOrNil(paramafy.dkb))
    {
      AppMethodBeat.o(103330);
      return;
    }
    ad.i("MicroMsg.Fav.FavApiLogic", "restart cdndata download, dataId %s", new Object[] { paramafy.dkb });
    c localc = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().Yk(paramafy.dkb);
    Object localObject = localc;
    if (localc != null) {
      if (localc.field_status != 3)
      {
        localObject = localc;
        if (localc.field_status != 4) {}
      }
      else
      {
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().b(localc, new String[] { "dataId" });
        localObject = null;
      }
    }
    if ((localObject != null) && (((c)localObject).field_type == 1))
    {
      ad.i("MicroMsg.Fav.FavApiLogic", "klem data not download completed.");
      ((c)localObject).field_status = 1;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a((c)localObject, new String[] { "dataId" });
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().Yi(paramafy.dkb);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
      AppMethodBeat.o(103330);
      return;
    }
    localObject = new com.tencent.mm.vfs.e(d(paramafy));
    if ((!bt.isNullOrNil(paramafy.Dgb)) && (!bt.isNullOrNil(paramafy.DfZ)) && (!((com.tencent.mm.vfs.e)localObject).exists()))
    {
      ad.i("MicroMsg.Fav.FavApiLogic", "klem big img not exist, start download.");
      long l = System.currentTimeMillis();
      localObject = new g();
      ((g)localObject).field_localId = paramLong;
      ((g)localObject).field_id = -1;
      ((g)localObject).field_type = paramInt;
      a(paramafy, (g)localObject, 1, true);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().Yi(paramafy.dkb);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
      ad.i("MicroMsg.Fav.FavApiLogic", "insert cdn item use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
    AppMethodBeat.o(103330);
  }
  
  public static void b(String paramString, Context paramContext)
  {
    AppMethodBeat.i(103352);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.Fav.FavApiLogic", "share image to timeline fail, filePath is null");
      AppMethodBeat.o(103352);
      return;
    }
    Intent localIntent = new Intent();
    String str1 = "fav_" + com.tencent.mm.model.u.aqG() + "_0";
    String str2 = y.tD(str1);
    y.arz().E(str2, true).m("prePublishId", str1);
    localIntent.putExtra("reportSessionId", str2);
    localIntent.putExtra("Ksnsupload_type", 0);
    localIntent.putExtra("sns_kemdia_path", paramString);
    d.b(paramContext, "sns", ".ui.SnsUploadUI", localIntent);
    AppMethodBeat.o(103352);
  }
  
  public static afy c(g paramg)
  {
    AppMethodBeat.i(103264);
    if (paramg == null)
    {
      paramg = new afy();
      AppMethodBeat.o(103264);
      return paramg;
    }
    if (paramg.field_favProto.mVb.size() == 0)
    {
      paramg = new afy();
      AppMethodBeat.o(103264);
      return paramg;
    }
    paramg = (afy)paramg.field_favProto.mVb.get(0);
    AppMethodBeat.o(103264);
    return paramg;
  }
  
  public static String c(afy paramafy)
  {
    AppMethodBeat.i(103258);
    afz localafz = paramafy.DgT;
    String str = "";
    switch (paramafy.dataType)
    {
    case 2: 
    case 3: 
    case 7: 
    case 9: 
    default: 
      paramafy = fL(fL("", localafz.title), localafz.desc);
    }
    for (;;)
    {
      AppMethodBeat.o(103258);
      return paramafy;
      paramafy = fL("", paramafy.desc);
      continue;
      paramafy = str;
      if (localafz.DhI != null)
      {
        paramafy = fL("", localafz.DhI.title);
        continue;
        paramafy = str;
        if (localafz.DhE != null)
        {
          paramafy = fL("", localafz.DhE.title);
          continue;
          str = fL("", localafz.iaz);
          paramafy = str;
          if (localafz.DhC != null)
          {
            paramafy = fL(fL(str, localafz.DhC.dtN), localafz.DhC.label);
            continue;
            paramafy = str;
            if (localafz.DhG != null)
            {
              paramafy = fL(fL("", localafz.DhG.title), localafz.DhG.desc);
              continue;
              paramafy = fL("", localafz.title);
            }
          }
        }
      }
    }
  }
  
  public static void c(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(103340);
    g localg = XZ(paramString1);
    if (localg == null)
    {
      AppMethodBeat.o(103340);
      return;
    }
    ms localms = new ms();
    localms.drL.type = 2;
    localms.drL.field_localId = -1L;
    localms.drL.context = paramContext;
    localms.drL.drU = 4;
    localms.drL.drV = true;
    paramContext = new Bundle();
    paramContext.putString("noteauthor", localg.field_favProto.Csh.Diw);
    paramContext.putString("noteeditor", localg.field_favProto.Csh.Dix);
    paramContext.putLong("edittime", localg.field_favProto.oJi);
    paramContext.putString("notexml", g.t(localg));
    paramContext.putString("snslocalid", paramString2);
    paramContext.putString("snsthumbpath", paramString3);
    paramContext.putString("snsnotelinkxml", paramString1);
    localms.drL.drS = paramContext;
    localms.drL.field_favProto = localg.field_favProto;
    com.tencent.mm.sdk.b.a.ESL.l(localms);
    AppMethodBeat.o(103340);
  }
  
  public static void c(gs paramgs)
  {
    AppMethodBeat.i(103345);
    Object localObject2;
    Object localObject3;
    if (paramgs.dkc.dkj == 1)
    {
      paramgs.dkd.path = pD(paramgs.dkc.deL);
      localObject2 = paramgs.dkd;
      long l = paramgs.dkc.deL;
      localObject3 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(l);
      if ((localObject3 == null) || (((g)localObject3).field_favProto == null)) {
        paramgs = "";
      }
      for (;;)
      {
        label86:
        ((gs.b)localObject2).thumbPath = paramgs;
        AppMethodBeat.o(103345);
        return;
        if ((((g)localObject3).field_type != 18) || (((g)localObject3).field_favProto.mVb.size() > 1))
        {
          paramgs = ((g)localObject3).field_favProto.mVb.iterator();
          for (;;)
          {
            if (paramgs.hasNext())
            {
              afy localafy = (afy)paramgs.next();
              switch (localafy.dataType)
              {
              default: 
                break;
              case 2: 
                localObject1 = a(localafy);
                paramgs = (gs)localObject1;
                if (i.eK((String)localObject1)) {
                  break label86;
                }
                paramgs = d(localafy);
                if (i.eK(paramgs))
                {
                  com.tencent.mm.sdk.platformtools.f.c(paramgs, 150, 150, Bitmap.CompressFormat.JPEG, 90, (String)localObject1);
                  paramgs = a(localafy);
                  break label86;
                }
                if (localafy.DfU)
                {
                  a((g)localObject3, localafy);
                  paramgs = (gs)localObject1;
                  break label86;
                }
                if (localafy.Dga)
                {
                  a((g)localObject3, localafy, true);
                  break label86;
                }
                paramgs = "";
                break label86;
              }
            }
          }
        }
        paramgs = "";
      }
    }
    if (paramgs.dkc.dkj == 2)
    {
      localObject1 = new g();
      ((g)localObject1).field_type = 2;
      localObject2 = new afy();
      ((afy)localObject2).aDy(cT(localObject2.toString(), 2));
      localObject3 = d((afy)localObject2);
      ((afy)localObject2).aDz((String)localObject3);
      ((afy)localObject2).VD(2);
      ((g)localObject1).field_favProto.mVb.add(localObject2);
      paramgs.dkd.path = g.t((g)localObject1);
      paramgs.dkd.thumbPath = ((String)localObject3);
      AppMethodBeat.o(103345);
      return;
    }
    if (paramgs.dkc.dkj == 3)
    {
      localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(paramgs.dkc.deL);
      if (localObject1 != null) {
        paramgs.dkd.path = (com.tencent.mm.model.u.aqG() + ";" + ((g)localObject1).field_fromUser + ";" + ((g)localObject1).field_updateTime);
      }
      AppMethodBeat.o(103345);
      return;
    }
    if (paramgs.dkc.dkj == 4)
    {
      b(paramgs);
      AppMethodBeat.o(103345);
      return;
    }
    if (paramgs.dkc.dkj == 5)
    {
      a(paramgs);
      AppMethodBeat.o(103345);
      return;
    }
    if (paramgs.dkc.dkj == 6)
    {
      localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(paramgs.dkc.deL);
      if (localObject1 == null)
      {
        paramgs.dkd.ret = 0;
        AppMethodBeat.o(103345);
        return;
      }
      paramgs = paramgs.dkd;
      if (((g)localObject1).field_id > 0) {}
      for (int i = 1;; i = 0)
      {
        paramgs.ret = i;
        AppMethodBeat.o(103345);
        return;
      }
    }
    Object localObject1 = new g();
    ((g)localObject1).field_type = 18;
    ((g)localObject1).field_favProto = paramgs.dkc.deS;
    paramgs.dkd.path = g.t((g)localObject1);
    AppMethodBeat.o(103345);
  }
  
  public static void c(c paramc)
  {
    AppMethodBeat.i(103294);
    if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage() == null)
    {
      ad.e("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, getFavCdnStorage null");
      AppMethodBeat.o(103294);
      return;
    }
    int i = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().x(paramc.field_favLocalId, 1);
    ad.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, download data status:%d, favlocalId:%d", new Object[] { Integer.valueOf(i), Long.valueOf(paramc.field_favLocalId) });
    if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage() == null)
    {
      ad.e("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus getFavItemInfoStorage null");
      AppMethodBeat.o(103294);
      return;
    }
    g localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(paramc.field_favLocalId);
    if (localg == null)
    {
      ad.e("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus iteminfo null");
      AppMethodBeat.o(103294);
      return;
    }
    if ((localg.chK()) || (localg.chH()) || (localg.isUploadFailed()))
    {
      ad.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, status upload, skip. isWaitServerUpload:%b  isUploadding:%b  isUploadFailed:%b", new Object[] { Boolean.valueOf(localg.chK()), Boolean.valueOf(localg.chH()), Boolean.valueOf(localg.isUploadFailed()) });
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
      h.pM(localg.field_localId);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ab(7, paramc.field_favLocalId);
      AppMethodBeat.o(103294);
      return;
      ad.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, error, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
      com.tencent.mm.plugin.report.service.h.vKh.f(10659, new Object[] { Integer.valueOf(1), Integer.valueOf(localg.field_type), Integer.valueOf(-5), Long.valueOf(b(localg)), Long.valueOf(h.pL(localg.field_localId)) });
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ab(8, paramc.field_favLocalId);
      AppMethodBeat.o(103294);
      return;
      ad.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus init, favLocalId:%d, favId:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id) });
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ab(10, paramc.field_favLocalId);
      AppMethodBeat.o(103294);
      return;
      ad.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus finish, favLocalId:%d, favId:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id) });
      com.tencent.mm.plugin.report.service.h.vKh.f(10659, new Object[] { Integer.valueOf(1), Integer.valueOf(localg.field_type), Integer.valueOf(0), Long.valueOf(b(localg)), Long.valueOf(h.pL(localg.field_localId)) });
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ab(10, paramc.field_favLocalId);
      AppMethodBeat.o(103294);
      return;
      ad.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus pause, favLocalId:%d, favId:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id) });
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ab(8, paramc.field_favLocalId);
    }
  }
  
  public static void c(String paramString, Context paramContext)
  {
    AppMethodBeat.i(103354);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.Fav.FavApiLogic", "shareTextToFriend content null");
      AppMethodBeat.o(103354);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Retr_Msg_content", paramString);
    localIntent.putExtra("Retr_Msg_Type", 4);
    localIntent.putExtra("mutil_select_is_ret", true);
    d.e(paramContext, ".ui.transmit.MsgRetransmitUI", localIntent);
    AppMethodBeat.o(103354);
  }
  
  public static String cT(String paramString, int paramInt)
  {
    AppMethodBeat.i(103260);
    paramString = com.tencent.mm.b.g.getMessageDigest((paramString + paramInt + System.currentTimeMillis()).getBytes());
    AppMethodBeat.o(103260);
    return paramString;
  }
  
  public static boolean chA()
  {
    AppMethodBeat.i(168688);
    if ((((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.prk, 0) != 1) && (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.prM, 0) == 1))
    {
      AppMethodBeat.o(168688);
      return true;
    }
    AppMethodBeat.o(168688);
    return false;
  }
  
  private static Set<String> cho()
  {
    AppMethodBeat.i(103273);
    Object localObject = (String)com.tencent.mm.kernel.g.afB().afk().get(225282, "");
    ad.i("MicroMsg.Fav.FavApiLogic", "get need del IDs: %s", new Object[] { localObject });
    HashSet localHashSet = new HashSet();
    if (bt.isNullOrNil((String)localObject))
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
  
  public static String chp()
  {
    AppMethodBeat.i(103277);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.afC();
    localObject = com.tencent.mm.kernel.g.afB().gcW + "favorite/web/";
    AppMethodBeat.o(103277);
    return localObject;
  }
  
  public static void chq()
  {
    AppMethodBeat.i(103281);
    Object localObject2 = cho();
    if (((Set)localObject2).size() == 0)
    {
      ad.v("MicroMsg.Fav.FavApiLogic", "doBatchDel no item to delete");
      AppMethodBeat.o(103281);
      return;
    }
    ad.i("MicroMsg.Fav.FavApiLogic", "doBatchDel idList:%s", new Object[] { localObject2.toString() });
    Object localObject1 = new LinkedList();
    localObject2 = ((Set)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      try
      {
        ((LinkedList)localObject1).add(Integer.valueOf(bt.getInt(str, 0)));
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.Fav.FavApiLogic", localException, "", new Object[0]);
        ad.e("MicroMsg.Fav.FavApiLogic", "doBatchDel parseInt error:%s", new Object[] { localException.getMessage() });
      }
    }
    ad.i("MicroMsg.Fav.FavApiLogic", "doBatchDel after parse, total size %d", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()) });
    if (((LinkedList)localObject1).size() > 0)
    {
      localObject1 = new ah((LinkedList)localObject1);
      com.tencent.mm.kernel.g.aeS().a((n)localObject1, 0);
    }
    AppMethodBeat.o(103281);
  }
  
  public static long chr()
  {
    AppMethodBeat.i(103300);
    long l2 = chs() - cht();
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 1024L;
    }
    AppMethodBeat.o(103300);
    return l1;
  }
  
  public static long chs()
  {
    AppMethodBeat.i(103301);
    long l = ((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FiX, Long.valueOf(0L))).longValue();
    AppMethodBeat.o(103301);
    return l;
  }
  
  public static long cht()
  {
    AppMethodBeat.i(103302);
    long l = ((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FiW, Long.valueOf(0L))).longValue();
    AppMethodBeat.o(103302);
    return l;
  }
  
  public static boolean chu()
  {
    AppMethodBeat.i(103311);
    if (chs() == 0L)
    {
      AppMethodBeat.o(103311);
      return false;
    }
    if (chr() < 52428800L)
    {
      AppMethodBeat.o(103311);
      return true;
    }
    AppMethodBeat.o(103311);
    return false;
  }
  
  public static String chv()
  {
    AppMethodBeat.i(103317);
    String str = com.tencent.mm.kernel.g.afB().gcW + "favorite/music/";
    AppMethodBeat.o(103317);
    return str;
  }
  
  public static String chw()
  {
    AppMethodBeat.i(103320);
    String str = com.tencent.mm.kernel.g.afB().gcW + "favorite/";
    AppMethodBeat.o(103320);
    return str;
  }
  
  public static String chx()
  {
    AppMethodBeat.i(103321);
    String str = com.tencent.mm.kernel.g.afB().gcW + "favorite/voice/";
    AppMethodBeat.o(103321);
    return str;
  }
  
  public static boolean chy()
  {
    AppMethodBeat.i(103328);
    if (ai.cim() > 0)
    {
      AppMethodBeat.o(103328);
      return true;
    }
    AppMethodBeat.o(103328);
    return false;
  }
  
  public static boolean chz()
  {
    AppMethodBeat.i(103337);
    if (chs() == 0L)
    {
      AppMethodBeat.o(103337);
      return false;
    }
    if (chr() < 10485760L)
    {
      AppMethodBeat.o(103337);
      return true;
    }
    AppMethodBeat.o(103337);
    return false;
  }
  
  public static String d(afy paramafy)
  {
    AppMethodBeat.i(103278);
    if (paramafy == null)
    {
      AppMethodBeat.o(103278);
      return "";
    }
    Object localObject2 = paramafy.dkb;
    if ((bt.isNullOrNil((String)localObject2)) || (!com.tencent.mm.kernel.g.afw()))
    {
      AppMethodBeat.o(103278);
      return "";
    }
    com.tencent.mm.vfs.e locale2 = XR((String)localObject2);
    int j = 0;
    int i = j;
    com.tencent.mm.vfs.e locale1 = locale2;
    Object localObject1 = localObject2;
    if (paramafy.dataType == 8)
    {
      i = j;
      locale1 = locale2;
      localObject1 = localObject2;
      if (!bt.isNullOrNil(paramafy.title))
      {
        localObject1 = paramafy.title;
        locale1 = XR(paramafy.dkb);
        i = 1;
      }
    }
    localObject2 = localObject1;
    if (paramafy.Dgo != null)
    {
      localObject2 = localObject1;
      if (paramafy.Dgo.trim().length() > 0)
      {
        localObject2 = localObject1;
        if (i == 0) {
          localObject2 = (String)localObject1 + "." + paramafy.Dgo;
        }
      }
    }
    localObject1 = new com.tencent.mm.vfs.e(locale1, (String)localObject2);
    if ((((com.tencent.mm.vfs.e)localObject1).exists()) || (bt.isNullOrNil(paramafy.Dgq)))
    {
      paramafy = com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject1).fhU());
      AppMethodBeat.o(103278);
      return paramafy;
    }
    localObject2 = com.tencent.mm.b.g.getMessageDigest((paramafy.Dgq + paramafy.dkb).getBytes());
    if (bt.isNullOrNil((String)localObject2))
    {
      paramafy = com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject1).fhU());
      AppMethodBeat.o(103278);
      return paramafy;
    }
    localObject1 = localObject2;
    if (paramafy.Dgo != null)
    {
      localObject1 = localObject2;
      if (paramafy.Dgo.trim().length() > 0) {
        localObject1 = (String)localObject2 + "." + paramafy.Dgo;
      }
    }
    localObject1 = new com.tencent.mm.vfs.e(locale1, (String)localObject1);
    if (((com.tencent.mm.vfs.e)localObject1).exists())
    {
      paramafy = com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject1).fhU());
      AppMethodBeat.o(103278);
      return paramafy;
    }
    localObject2 = paramafy.dkb;
    localObject1 = localObject2;
    if (paramafy.Dgo != null)
    {
      localObject1 = localObject2;
      if (paramafy.Dgo.trim().length() > 0) {
        localObject1 = (String)localObject2 + "." + paramafy.Dgo;
      }
    }
    ad.d("MicroMsg.Fav.FavApiLogic", "use dataId.fmt, ".concat(String.valueOf(localObject1)));
    paramafy = com.tencent.mm.vfs.q.B(new com.tencent.mm.vfs.e(locale1, (String)localObject1).fhU());
    AppMethodBeat.o(103278);
    return paramafy;
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
        if (!pZr.containsKey(Long.valueOf(paramg.field_localId)))
        {
          AppMethodBeat.o(103269);
          continue;
        }
        if (pZr.get(Long.valueOf(paramg.field_localId)) == null) {
          break label101;
        }
      }
      finally {}
      if (((ArrayList)pZr.get(Long.valueOf(paramg.field_localId))).size() == 0)
      {
        label101:
        AppMethodBeat.o(103269);
      }
      else
      {
        String str = pD(paramg.field_localId);
        ad.i("MicroMsg.Fav.FavApiLogic", "checkUpdateSnsNotePostXml, resend favlocal id:%d,xml:%s", new Object[] { Long.valueOf(paramg.field_localId), str });
        qv localqv = new qv();
        localqv.dww.dwx = ((ArrayList)pZr.get(Long.valueOf(paramg.field_localId)));
        localqv.dww.dwy = str;
        com.tencent.mm.sdk.b.a.ESL.l(localqv);
        pZr.remove(Long.valueOf(paramg.field_localId));
        AppMethodBeat.o(103269);
      }
    }
  }
  
  private static void d(Set<String> paramSet)
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
    ad.i("MicroMsg.Fav.FavApiLogic", "set need del IDs: %s", new Object[] { paramSet });
    com.tencent.mm.kernel.g.afB().afk().set(225282, paramSet);
    AppMethodBeat.o(103272);
  }
  
  public static void dh(List<Integer> paramList)
  {
    AppMethodBeat.i(103271);
    if (paramList.size() == 0)
    {
      ad.e("MicroMsg.Fav.FavApiLogic", "setDeleted list null");
      AppMethodBeat.o(103271);
      return;
    }
    Set localSet = cho();
    ad.i("MicroMsg.Fav.FavApiLogic", "setDeleted before del:%s", new Object[] { localSet.toString() });
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Integer localInteger = (Integer)paramList.next();
      ad.i("MicroMsg.Fav.FavApiLogic", "setDeleted id:%d, ret:%b", new Object[] { localInteger, Boolean.valueOf(localSet.remove(localInteger.toString())) });
    }
    ad.i("MicroMsg.Fav.FavApiLogic", "setDeleted after del:%s", new Object[] { localSet.toString() });
    d(localSet);
    AppMethodBeat.o(103271);
  }
  
  public static boolean di(List<g> paramList)
  {
    AppMethodBeat.i(103285);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ad.w("MicroMsg.Fav.FavApiLogic", "delete fav item fail, item is null");
      AppMethodBeat.o(103285);
      return false;
    }
    Set localSet = cho();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      g localg = (g)paramList.next();
      h(localg);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavSearchStorage().pU(localg.field_localId);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().A(localg);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().pQ(localg.field_localId);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().w(localg);
      localSet.add(localg.field_id);
      ad.d("MicroMsg.Fav.FavApiLogic", "delete id %d", new Object[] { Integer.valueOf(localg.field_id) });
    }
    d(localSet);
    chq();
    AppMethodBeat.o(103285);
    return true;
  }
  
  public static void e(afy paramafy)
  {
    AppMethodBeat.i(103309);
    c localc = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().Yk(paramafy.dkb);
    if ((localc != null) && (localc.field_status != 3))
    {
      localc.field_status = 2;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().pauseDownload(paramafy.dkb);
    }
    localc = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().Yk(XS(paramafy.dkb));
    if ((localc != null) && (localc.field_status != 3))
    {
      localc.field_status = 2;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().pauseDownload(XS(paramafy.dkb));
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
    paramg = paramg.field_favProto.mVb.iterator();
    afy localafy;
    do
    {
      if (!paramg.hasNext()) {
        break;
      }
      localafy = (afy)paramg.next();
    } while (((localafy.dataType != 8) && (localafy.dataType != 4) && (localafy.dataType != 2) && (localafy.dataType != 3)) || ((!bt.isNullOrNil(localafy.DfZ)) && (!bt.isNullOrNil(localafy.Dgb))));
    for (boolean bool = false;; bool = true)
    {
      AppMethodBeat.o(103270);
      return bool;
    }
  }
  
  public static void eB(Context paramContext)
  {
    AppMethodBeat.i(193578);
    if (0L >= pZs)
    {
      ad.i("MicroMsg.Fav.FavApiLogic", "addTagWhenAddToFav,try to add tag ,but favLocalId is null, return");
      AppMethodBeat.o(193578);
      return;
    }
    g localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(pZs);
    pZs = 0L;
    if (localg == null)
    {
      ad.i("MicroMsg.Fav.FavApiLogic", "addTagWhenAddToFav,try to add tag ,but iteminfo is null, return");
      AppMethodBeat.o(193578);
      return;
    }
    ad.i("MicroMsg.Fav.FavApiLogic", "addTagWhenAddToFav ,go on");
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = aj.getContext();
    }
    paramContext = new Intent();
    paramContext.putExtra("key_fav_scene", 5);
    paramContext.putExtra("key_fav_item_id", localg.field_localId);
    a(localContext, ".ui.FavTagEditUI", paramContext, null);
    AppMethodBeat.o(193578);
  }
  
  public static boolean f(g paramg)
  {
    AppMethodBeat.i(103280);
    if (paramg.field_favProto == null)
    {
      AppMethodBeat.o(103280);
      return false;
    }
    paramg = paramg.field_favProto.mVb.iterator();
    while (paramg.hasNext())
    {
      afy localafy = (afy)paramg.next();
      if (localafy.Dhh == 2)
      {
        AppMethodBeat.o(103280);
        return true;
      }
      if (localafy.Dhh == 1)
      {
        AppMethodBeat.o(103280);
        return true;
      }
    }
    AppMethodBeat.o(103280);
    return false;
  }
  
  public static boolean f(afy paramafy)
  {
    AppMethodBeat.i(103316);
    com.tencent.mm.az.f localf = com.tencent.mm.az.a.azI();
    if ((localf != null) && (localf.hnn == 6) && (bt.by(paramafy.dkb, "").equals(localf.hnp)) && (com.tencent.mm.az.a.azF()))
    {
      AppMethodBeat.o(103316);
      return true;
    }
    AppMethodBeat.o(103316);
    return false;
  }
  
  private static String fL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(103259);
    if (bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(103259);
      return paramString2;
    }
    if (bt.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(103259);
      return paramString1;
    }
    paramString1 = paramString1 + "​" + paramString2;
    AppMethodBeat.o(103259);
    return paramString1;
  }
  
  public static boolean g(g paramg)
  {
    if (paramg == null) {}
    while ((paramg.field_itemStatus != 8) && (paramg.field_itemStatus != 10) && (paramg.field_itemStatus != 7)) {
      return false;
    }
    return true;
  }
  
  public static boolean g(afy paramafy)
  {
    AppMethodBeat.i(103326);
    boolean bool = new com.tencent.mm.vfs.e(d(paramafy)).exists();
    AppMethodBeat.o(103326);
    return bool;
  }
  
  public static String getAppName(Context paramContext, String paramString)
  {
    AppMethodBeat.i(103318);
    ag.b localb = ag.a.gMU;
    if (localb != null)
    {
      paramContext = localb.s(paramContext, paramString);
      AppMethodBeat.o(103318);
      return paramContext;
    }
    AppMethodBeat.o(103318);
    return "";
  }
  
  private static void h(g paramg)
  {
    AppMethodBeat.i(103282);
    Set localSet = ao.qbk;
    paramg = paramg.field_favProto.mVb;
    int i = 0;
    while (i < paramg.size())
    {
      Object localObject = a((afy)paramg.get(i));
      if ((localSet == null) || (!localSet.contains(localObject))) {
        i.deleteFile((String)localObject);
      }
      localObject = d((afy)paramg.get(i));
      if ((localSet == null) || (!localSet.contains(localObject))) {
        i.deleteFile((String)localObject);
      }
      localObject = (afy)paramg.get(i);
      if ((((afy)localObject).DgT != null) && (((afy)localObject).DgT.DhU != null)) {
        com.tencent.mm.modelvideo.u.Ad(((afy)localObject).dkb);
      }
      i += 1;
    }
    AppMethodBeat.o(103282);
  }
  
  public static boolean h(afy paramafy)
  {
    AppMethodBeat.i(103327);
    boolean bool = t.aFm(d(paramafy));
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
      if (paramg.field_favProto.DhE != null) {
        str1 = paramg.field_favProto.DhE.Djf;
      }
      String str2 = str1;
      if (paramg.field_favProto.DiD != null)
      {
        str2 = str1;
        if (bt.isNullOrNil(str1)) {
          str2 = paramg.field_favProto.DiD.link;
        }
      }
      paramg = new gm();
      paramg.djG.url = str2;
      com.tencent.mm.sdk.b.a.ESL.l(paramg);
    }
    AppMethodBeat.o(103288);
  }
  
  public static void j(g paramg)
  {
    AppMethodBeat.i(103290);
    j localj = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavSearchStorage().pV(paramg.field_localId);
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
      if (paramg.field_favProto.DiD != null)
      {
        localObject1 = paramg.field_favProto.DiD;
        if (!bt.isNullOrNil(((agu)localObject1).dpv))
        {
          localStringBuffer.append(((agu)localObject1).dpv);
          localObject2 = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHY(((agu)localObject1).dpv);
          if (localObject2 != null) {
            localStringBuffer.append(((au)localObject2).field_nickname).append(((au)localObject2).field_conRemark);
          }
          localObject2 = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHY(((agu)localObject1).toUser);
          if (localObject2 != null) {
            localStringBuffer.append(((au)localObject2).field_nickname).append(((au)localObject2).field_conRemark);
          }
          localStringBuffer.append(((agu)localObject1).Did);
        }
      }
      Object localObject1 = paramg.field_favProto.mVb;
      localj.field_subtype = 0;
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (afy)((Iterator)localObject1).next();
        if (((afy)localObject2).desc != null) {
          localStringBuffer.append(((afy)localObject2).desc);
        }
        if (((afy)localObject2).title != null) {
          localStringBuffer.append(((afy)localObject2).title);
        }
        int j = ((afy)localObject2).dataType;
        int k = localj.field_subtype;
        localj.field_subtype = (j.Ck(j) | k);
      }
      if (paramg.field_favProto.DhE != null)
      {
        if (paramg.field_favProto.DhE.desc != null) {
          localStringBuffer.append(paramg.field_favProto.DhE.desc);
        }
        if (paramg.field_favProto.DhE.title != null) {
          localStringBuffer.append(paramg.field_favProto.DhE.title);
        }
      }
      if (paramg.field_favProto.DhG != null)
      {
        if (paramg.field_favProto.DhG.desc != null) {
          localStringBuffer.append(paramg.field_favProto.DhG.desc);
        }
        if (paramg.field_favProto.DhG.title != null) {
          localStringBuffer.append(paramg.field_favProto.DhG.title);
        }
      }
      if (paramg.field_favProto.DhW != null)
      {
        if (paramg.field_favProto.DhW.nickname != null) {
          localStringBuffer.append(paramg.field_favProto.DhW.nickname);
        }
        if (paramg.field_favProto.DhW.desc != null) {
          localStringBuffer.append(paramg.field_favProto.DhW.desc);
        }
      }
      localj.field_tagContent = "";
      localObject1 = paramg.field_tagProto.DiQ.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localj.field_tagContent = (localj.field_tagContent + " " + (String)localObject2);
        localStringBuffer.append((String)localObject2);
      }
      localObject1 = paramg.field_tagProto.DiR.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localj.field_tagContent = (localj.field_tagContent + " " + (String)localObject2);
        localStringBuffer.append((String)localObject2);
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().Yf((String)localObject2);
      }
      localj.field_content = localStringBuffer.toString();
      localj.field_time = paramg.field_updateTime;
      localj.field_type = paramg.field_type;
      if (i != 0)
      {
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavSearchStorage().a(localj);
        AppMethodBeat.o(103290);
        return;
      }
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavSearchStorage().a(localj, new String[] { "localId" });
      AppMethodBeat.o(103290);
      return;
    }
  }
  
  public static boolean k(g paramg)
  {
    AppMethodBeat.i(103298);
    if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(paramg.field_localId) != null)
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
    if (!paramg.isUploadFailed())
    {
      ad.f("MicroMsg.Fav.FavApiLogic", "restartItemUpload status not upload failed!");
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
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getCheckCdnService().run();
      AppMethodBeat.o(103305);
      return;
      if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().pN(paramg.field_localId).size() == 0)
      {
        paramg.field_itemStatus = 9;
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
        paramg = new ag(paramg);
        com.tencent.mm.kernel.g.aeS().a(paramg, 0);
        AppMethodBeat.o(103305);
        return;
      }
      paramg.field_itemStatus = 4;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().y(paramg);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
      Iterator localIterator = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().pN(paramg.field_localId).iterator();
      c localc;
      while (localIterator.hasNext())
      {
        localc = (c)localIterator.next();
        ad.i("MicroMsg.Fav.FavApiLogic", "force upload favItem[last failed], favid:%d localId:%d, dataId:%s, dataType:%d totalLength %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), localc.field_dataId, Integer.valueOf(localc.field_dataType), Integer.valueOf(localc.field_totalLen) });
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().Yi(localc.field_dataId);
      }
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
      AppMethodBeat.o(103305);
      return;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ab(12, paramg.field_localId);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getSendService().run();
      AppMethodBeat.o(103305);
      return;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ab(15, paramg.field_localId);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().y(paramg);
      localIterator = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().pN(paramg.field_localId).iterator();
      while (localIterator.hasNext())
      {
        localc = (c)localIterator.next();
        ad.i("MicroMsg.Fav.FavApiLogic", "force upload favItem[last mod failed], favid:%d localId:%d, dataId:%s, dataType:%d totalLength %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), localc.field_dataId, Integer.valueOf(localc.field_dataType), Integer.valueOf(localc.field_totalLen) });
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().Yi(localc.field_dataId);
      }
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
      AppMethodBeat.o(103305);
      return;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ab(17, paramg.field_localId);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getModService().run();
      AppMethodBeat.o(103305);
      return;
      paramg.field_itemStatus = 9;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getSendService().run();
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
      Object localObject = paramg.field_favProto.mVb;
      if (((List)localObject).size() == 0)
      {
        AppMethodBeat.o(103306);
        return;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        afy localafy = (afy)((Iterator)localObject).next();
        a(paramg, localafy, true);
        a(paramg, localafy);
      }
      AppMethodBeat.o(103306);
      return;
    }
    ad.e("MicroMsg.Fav.FavApiLogic", "status not download failed or done!");
    AppMethodBeat.o(103306);
  }
  
  public static float mI(long paramLong)
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
  
  public static void n(g paramg)
  {
    AppMethodBeat.i(103310);
    if (!paramg.chH())
    {
      ad.e("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, not uploading");
      AppMethodBeat.o(103310);
      return;
    }
    ad.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, itemStatu:%d", new Object[] { Integer.valueOf(paramg.field_itemStatus) });
    Iterator localIterator = paramg.field_favProto.mVb.iterator();
    while (localIterator.hasNext())
    {
      afy localafy = (afy)localIterator.next();
      c localc = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().Yk(localafy.dkb);
      if ((localc != null) && (localc.field_status != 3))
      {
        localc.field_status = 2;
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().Yj(localafy.dkb);
      }
      localc = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().Yk(XS(localafy.dkb));
      if ((localc != null) && (localc.field_status != 3))
      {
        localc.field_status = 2;
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().Yj(XS(localafy.dkb));
      }
    }
    paramg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(paramg.field_localId);
    ad.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, after pause data itemStatu:%d", new Object[] { Integer.valueOf(paramg.field_itemStatus) });
    switch (paramg.field_itemStatus)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(103310);
      return;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ab(3, paramg.field_localId);
      ad.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(3) });
      AppMethodBeat.o(103310);
      return;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ab(6, paramg.field_localId);
      ad.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(6) });
      AppMethodBeat.o(103310);
      return;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ab(11, paramg.field_localId);
      ad.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(11) });
      AppMethodBeat.o(103310);
      return;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ab(14, paramg.field_localId);
      ad.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(14) });
      AppMethodBeat.o(103310);
      return;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ab(16, paramg.field_localId);
      ad.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(16) });
      AppMethodBeat.o(103310);
      return;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ab(18, paramg.field_localId);
      ad.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(18) });
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
    afy localafy = c(paramg);
    if (localafy == null)
    {
      AppMethodBeat.o(103319);
      return false;
    }
    long l = bt.GC();
    com.tencent.mm.plugin.sight.base.a locala = com.tencent.mm.plugin.sight.base.e.ano(d(localafy));
    int j;
    int i;
    boolean bool;
    if (locala != null)
    {
      j = locala.getVideoDuration();
      i = localafy.duration;
      if ((i <= 0) || (Math.abs(i - j) >= 2))
      {
        localafy.VC(j);
        bool = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.Fav.FavApiLogic", "repair video duration[%d TO %d] %b cost time %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool), Long.valueOf(bt.aS(l)) });
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
    j localj = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavSearchStorage().pV(paramg.field_localId);
    if (localj == null)
    {
      localj = new j();
      localj.field_localId = paramg.field_localId;
    }
    for (int i = 1;; i = 0)
    {
      localj.field_tagContent = "";
      Iterator localIterator = paramg.field_tagProto.DiQ.iterator();
      String str;
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        localj.field_tagContent = (localj.field_tagContent + " " + str);
      }
      localIterator = paramg.field_tagProto.DiR.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        localj.field_tagContent = (localj.field_tagContent + " " + str);
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().Yf(str);
      }
      localj.field_content = "";
      localj.field_time = paramg.field_updateTime;
      localj.field_type = paramg.field_type;
      if (i != 0)
      {
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavSearchStorage().a(localj);
        AppMethodBeat.o(103332);
        return;
      }
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavSearchStorage().a(localj, new String[] { "localId" });
      AppMethodBeat.o(103332);
      return;
    }
  }
  
  public static void pB(long paramLong)
  {
    AppMethodBeat.i(103265);
    ad.i("MicroMsg.Fav.FavApiLogic", "setUsedCapacity:%d", new Object[] { Long.valueOf(paramLong) });
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.FiW, Long.valueOf(paramLong));
    AppMethodBeat.o(103265);
  }
  
  public static void pC(long paramLong)
  {
    AppMethodBeat.i(103266);
    ad.i("MicroMsg.Fav.FavApiLogic", "setTotalCapacity:%d", new Object[] { Long.valueOf(paramLong) });
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.FiX, Long.valueOf(paramLong));
    AppMethodBeat.o(103266);
  }
  
  private static String pD(long paramLong)
  {
    AppMethodBeat.i(103267);
    StringBuilder localStringBuilder = new StringBuilder();
    g localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(paramLong);
    if ((localg == null) || (localg.field_favProto == null) || (localg.field_favProto.mVb.size() <= 1))
    {
      AppMethodBeat.o(103267);
      return "";
    }
    agi localagi = localg.field_favProto.Csh;
    String str2 = "";
    String str1 = "";
    if (localagi != null)
    {
      str2 = localagi.Dix;
      str1 = localagi.Diw;
    }
    localStringBuilder.append("<noteinfo>");
    localStringBuilder.append("<noteauthor>").append(str1).append("</noteauthor>");
    localStringBuilder.append("<noteeditor>").append(str2).append("</noteeditor>");
    localStringBuilder.append("<edittime>").append(localg.field_favProto.oJi).append("</edittime>");
    localStringBuilder.append("<editusr>").append(str1).append("</editusr>");
    localStringBuilder.append("<favlocalid>").append(localg.field_localId).append("</favlocalid>");
    localStringBuilder.append(com.tencent.mm.plugin.fav.a.a.a.dj(localg.field_favProto.mVb).replace("cdn_dataurl", "cdndataurl").replace("cdn_datakey", "cdndatakey").replace("cdn_thumburl", "cdnthumburl").replace("cdn_thumbkey", "cdnthumbkey").replace("thumbfullsize", "thumbsize").replace("fullsize", "datasize").replace("datasrcname", "sourcename").replace("datasrctime", "sourcetime").replace("stream_lowbandurl", "streamlowbandurl").replace("stream_dataurl", "streamdataurl").replace("stream_weburl", "streamweburl"));
    localStringBuilder.append("</noteinfo>");
    str1 = localStringBuilder.toString();
    AppMethodBeat.o(103267);
    return str1;
  }
  
  public static void pE(long paramLong)
  {
    AppMethodBeat.i(103274);
    aj.getContext().getSharedPreferences(aj.eFD(), 0).edit().putLong("fav_mx_auto_download_size", paramLong).commit();
    AppMethodBeat.o(103274);
  }
  
  public static void pF(long paramLong)
  {
    AppMethodBeat.i(103275);
    aj.getContext().getSharedPreferences(aj.eFD(), 0).edit().putLong("fav_mx_auto_upload_size", paramLong).commit();
    AppMethodBeat.o(103275);
  }
  
  public static void pG(long paramLong)
  {
    AppMethodBeat.i(103276);
    aj.getContext().getSharedPreferences(aj.eFD(), 0).edit().putLong("fav_mx_file_size", paramLong).commit();
    AppMethodBeat.o(103276);
  }
  
  public static void pH(long paramLong)
  {
    pZs = paramLong;
  }
  
  public static float pI(long paramLong)
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
  
  public static String pJ(long paramLong)
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
  
  public static void q(g paramg)
  {
    AppMethodBeat.i(103344);
    if (paramg == null)
    {
      AppMethodBeat.o(103344);
      return;
    }
    agi localagi = paramg.field_favProto.Csh;
    if ((localagi != null) && (!bt.isNullOrNil(localagi.Dix)))
    {
      AppMethodBeat.o(103344);
      return;
    }
    if (paramg.field_type == 18)
    {
      if (paramg.field_favProto.DiD.sourceType != 6) {
        break label113;
      }
      b(paramg, false);
    }
    for (;;)
    {
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
      AppMethodBeat.o(103344);
      return;
      label113:
      b(paramg, true);
    }
  }
  
  public static final String r(g paramg)
  {
    AppMethodBeat.i(103357);
    StringBuffer localStringBuffer = new StringBuffer();
    long l;
    label144:
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
    default: 
      paramg = localStringBuffer.toString();
      AppMethodBeat.o(103357);
      return paramg;
    case 2: 
    case 8: 
      paramg = paramg.field_favProto.mVb.iterator();
      l = 0L;
      if (paramg.hasNext())
      {
        localObject = (afy)paramg.next();
        if (localObject == null) {
          break label455;
        }
        l = ((afy)localObject).Dgu + l;
      }
      break;
    }
    label452:
    label455:
    for (;;)
    {
      for (;;)
      {
        break label144;
        localStringBuffer.append(l);
        break;
        if (bt.isNullOrNil(paramg.field_favProto.desc)) {
          break;
        }
        localStringBuffer.append(paramg.field_favProto.desc.getBytes().length);
        break;
        localStringBuffer.append(c(paramg).duration);
        break;
        localObject = "";
        try
        {
          paramg = paramg.field_favProto.DhE.Djf;
          localStringBuffer.append(paramg);
          break;
          if (paramg == null) {
            break;
          }
          paramg = paramg.field_favProto.mVb.iterator();
          int i = 0;
          int m = 0;
          int k = 0;
          int j = 0;
          while (paramg.hasNext())
          {
            localObject = (afy)paramg.next();
            switch (((afy)localObject).dataType)
            {
            case 3: 
            default: 
              i += 1;
              break;
            case 1: 
              if (bt.isNullOrNil(((afy)localObject).desc)) {
                break label452;
              }
              k = ((afy)localObject).desc.getBytes().length + k;
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
  
  public static String si(String paramString)
  {
    AppMethodBeat.i(103304);
    Object localObject = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHY(paramString);
    if (localObject == null)
    {
      ad.w("MicroMsg.Fav.FavApiLogic", "wtf get contact null, username %s", new Object[] { paramString });
      AppMethodBeat.o(103304);
      return "";
    }
    String str = ((com.tencent.mm.storage.af)localObject).ZX();
    localObject = str;
    if (com.tencent.mm.model.w.pF(str))
    {
      paramString = com.tencent.mm.model.q.rW(paramString);
      localObject = com.tencent.mm.model.u.aqG();
      if ((paramString != null) && (!paramString.isEmpty())) {
        break label109;
      }
      ad.w("MicroMsg.Fav.FavApiLogic", "get members from username error, content empty");
    }
    for (localObject = str;; localObject = com.tencent.mm.model.q.e(paramString, 3))
    {
      AppMethodBeat.o(103304);
      return localObject;
      label109:
      paramString.remove(localObject);
      paramString.add(0, localObject);
    }
  }
  
  public static void startSync()
  {
    AppMethodBeat.i(103324);
    ak localak = new ak();
    com.tencent.mm.kernel.g.aeS().a(localak, 0);
    AppMethodBeat.o(103324);
  }
  
  public static long w(long paramLong, int paramInt)
  {
    AppMethodBeat.i(103323);
    ad.i("MicroMsg.Fav.FavApiLogic", "tryStartBatchGet...");
    long l1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().C(paramLong, paramInt);
    long l2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().A(paramLong, paramInt);
    ad.i("MicroMsg.Fav.FavApiLogic", "klem, tryStartBatchGet, batchGetTime:%d, itemTiem:%d, updateTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(paramLong) });
    if (l1 == 0L)
    {
      AppMethodBeat.o(103323);
      return l2;
    }
    Object localObject = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().B(l1, paramInt);
    if (((LinkedList)localObject).size() > 0)
    {
      ad.i("MicroMsg.Fav.FavApiLogic", "klem, tryStartBatchGet, batchGetTime:%d, itemTiem:%d, updateTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(paramLong) });
      ad.i("MicroMsg.Fav.FavApiLogic", "klem, tryStartBatchGet, need batch get idList size:%d", new Object[] { Integer.valueOf(((LinkedList)localObject).size()) });
      localObject = new ai((LinkedList)localObject);
      if (!com.tencent.mm.kernel.g.aeS().a((n)localObject, 0))
      {
        ad.w("MicroMsg.Fav.FavApiLogic", "do scene BatchGetFav fail");
        ai.cil();
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
  
  public static void w(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(103353);
    if (paramContext != null)
    {
      paramIntent.putExtra("Ksnsupload_type", 1);
      d.b(paramContext, "sns", ".ui.SnsUploadUI", paramIntent);
    }
    AppMethodBeat.o(103353);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.b
 * JD-Core Version:    0.7.0.1
 */