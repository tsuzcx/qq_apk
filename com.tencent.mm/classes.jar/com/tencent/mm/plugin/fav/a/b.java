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
import com.tencent.mm.az.f;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.cp;
import com.tencent.mm.g.a.gq;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.g.a.gw.a;
import com.tencent.mm.g.a.gw.b;
import com.tencent.mm.g.a.nj;
import com.tencent.mm.g.a.rp;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ah.a;
import com.tencent.mm.model.ah.b;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajo;
import com.tencent.mm.protocal.protobuf.ajs;
import com.tencent.mm.protocal.protobuf.aju;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akc;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.protocal.protobuf.akq;
import com.tencent.mm.protocal.protobuf.aks;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.protocal.protobuf.bzw;
import com.tencent.mm.protocal.protobuf.bzz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bp;
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
  private static HashMap<Long, ArrayList<String>> rrZ;
  private static long rsa;
  
  static
  {
    AppMethodBeat.i(103360);
    rrZ = new HashMap();
    rsa = 0L;
    AppMethodBeat.o(103360);
  }
  
  public static boolean DU(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = a.rrX;
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
    Object localObject = a.rrX;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      if (localObject[i] == paramg.field_type)
      {
        if (paramg.field_favProto != null)
        {
          localObject = paramg.field_favProto.nZa.iterator();
          for (long l1 = 0L;; l1 = ((ajn)((Iterator)localObject).next()).Ghm + l1)
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
  
  public static g a(akd paramakd)
  {
    AppMethodBeat.i(103342);
    g localg = new g();
    localg.field_favProto = new akd();
    localg.field_type = 18;
    localg.field_favProto = paramakd;
    AppMethodBeat.o(103342);
    return localg;
  }
  
  public static ajn a(g paramg, String paramString)
  {
    AppMethodBeat.i(103292);
    if ((bt.isNullOrNil(paramString)) || (paramg == null) || (paramg.field_favProto.nZa.size() == 0))
    {
      AppMethodBeat.o(103292);
      return null;
    }
    paramg = paramg.field_favProto.nZa.iterator();
    while (paramg.hasNext())
    {
      ajn localajn = (ajn)paramg.next();
      if (localajn.dsU.equals(paramString))
      {
        AppMethodBeat.o(103292);
        return localajn;
      }
    }
    AppMethodBeat.o(103292);
    return null;
  }
  
  public static ajs a(int paramInt, akd paramakd, akq paramakq)
  {
    AppMethodBeat.i(103262);
    if (paramakd == null)
    {
      ad.w("MicroMsg.Fav.FavApiLogic", "proto item is null");
      AppMethodBeat.o(103262);
      return null;
    }
    ajs localajs = new ajs();
    akj localakj = paramakd.Gjv;
    if (localakj != null)
    {
      localajs.dyU = localakj.dyU;
      localajs.Gjg = localakj.GiV;
      localajs.appId = localakj.appId;
      localajs.djX = localakj.djX;
    }
    if (paramakq != null)
    {
      if (paramakq.GjI != null) {
        localajs.Gjh.addAll(paramakq.GjI);
      }
      if (paramakq.GjJ != null) {
        localajs.Gjh.addAll(paramakq.GjJ);
      }
    }
    localajs.dEQ = paramakd;
    localajs.type = paramInt;
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
      return localajs;
    case 1: 
      localajs.title = "";
      localajs.desc = paramakd.desc;
      AppMethodBeat.o(103262);
      return localajs;
    case 4: 
      if ((paramakd.nZa != null) && (!paramakd.nZa.isEmpty())) {
        localajs.title = ((ajn)paramakd.nZa.get(0)).title;
      }
      AppMethodBeat.o(103262);
      return localajs;
    case 5: 
      if (paramakd.Giw != null)
      {
        localajs.title = paramakd.Giw.title;
        localajs.desc = paramakd.Giw.GjX;
      }
      if ((bt.isNullOrNil(localajs.title)) && (paramakd.nZa != null) && (!paramakd.nZa.isEmpty())) {
        localajs.title = ((ajn)paramakd.nZa.get(0)).title;
      }
      if ((bt.isNullOrNil(localajs.desc)) && (localakj != null)) {
        localajs.desc = localakj.link;
      }
      AppMethodBeat.o(103262);
      return localajs;
    case 6: 
      localajs.title = paramakd.iTM;
      if (bt.isNullOrNil(localajs.title)) {
        if (paramakd.Giu != null)
        {
          localajs.title = paramakd.Giu.dDq;
          localajs.desc = paramakd.Giu.label;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(103262);
        return localajs;
        if (paramakd.Giu != null) {
          localajs.desc = paramakd.Giu.dDq;
        }
      }
    case 2: 
      if ((paramakd.nZa != null) && (paramakd.nZa.size() > 0)) {
        localajs.title = ((ajn)paramakd.nZa.get(0)).title;
      }
      AppMethodBeat.o(103262);
      return localajs;
    case 7: 
      if ((paramakd.nZa != null) && (!paramakd.nZa.isEmpty()))
      {
        localajs.title = ((ajn)paramakd.nZa.get(0)).title;
        localajs.desc = ((ajn)paramakd.nZa.get(0)).desc;
      }
      AppMethodBeat.o(103262);
      return localajs;
    case 8: 
      localajs.title = paramakd.title;
      if ((bt.isNullOrNil(localajs.title)) && (paramakd.nZa != null) && (!paramakd.nZa.isEmpty())) {
        localajs.title = ((ajn)paramakd.nZa.get(0)).title;
      }
      AppMethodBeat.o(103262);
      return localajs;
    case 10: 
    case 11: 
      if (paramakd.Giy != null)
      {
        localajs.title = paramakd.Giy.title;
        localajs.desc = paramakd.Giy.desc;
      }
      AppMethodBeat.o(103262);
      return localajs;
    case 12: 
    case 15: 
      if (paramakd.GiA != null)
      {
        localajs.title = paramakd.GiA.title;
        localajs.desc = paramakd.GiA.desc;
      }
      AppMethodBeat.o(103262);
      return localajs;
    }
    paramakd = paramakd.nZa;
    if (paramakd == null)
    {
      AppMethodBeat.o(103262);
      return null;
    }
    paramakd = paramakd.iterator();
    while (paramakd.hasNext())
    {
      paramakq = (ajn)paramakd.next();
      if (1 == paramakq.dataType) {
        localajs.title = paramakq.desc;
      }
    }
    AppMethodBeat.o(103262);
    return localajs;
  }
  
  public static String a(ajn paramajn)
  {
    AppMethodBeat.i(103283);
    if ((paramajn == null) || (bt.isNullOrNil(paramajn.dsU)))
    {
      AppMethodBeat.o(103283);
      return "";
    }
    paramajn = agd(paramajn.dsU);
    paramajn = com.tencent.mm.vfs.q.B(new com.tencent.mm.vfs.e(agc(paramajn), paramajn).fOK());
    AppMethodBeat.o(103283);
    return paramajn;
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
                LinkedList localLinkedList = localg.field_favProto.nZa;
                j = 1;
                if (j >= localLinkedList.size()) {
                  continue;
                }
                int k = ((ajn)localLinkedList.get(j)).dataType;
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
  
  public static void a(long paramLong, aju paramaju, String paramString1, String paramString2, ArrayList<String> paramArrayList, Context paramContext)
  {
    AppMethodBeat.i(103355);
    if ((paramaju == null) || (paramContext == null))
    {
      AppMethodBeat.o(103355);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("KFavLocSigleView", true);
    localIntent.putExtra("map_view_type", 2);
    localIntent.putExtra("kFavInfoLocalId", paramLong);
    localIntent.putExtra("kwebmap_slat", paramaju.lat);
    localIntent.putExtra("kwebmap_lng", paramaju.lng);
    localIntent.putExtra("kPoiName", paramaju.dDq);
    localIntent.putExtra("Kwebmap_locaion", paramaju.label);
    if (paramaju.dyB >= 0) {
      localIntent.putExtra("kwebmap_scale", paramaju.dyB);
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
      String str = aj.fkB() + ".plugin.fav";
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
      String str = aj.fkB() + ".plugin.fav";
      paramIntent = paramString;
      if (paramString.startsWith(".")) {
        paramIntent = str + paramString;
      }
      localIntent.setClassName(aj.getPackageName(), paramIntent);
      Class.forName(paramIntent, false, paramContext.getClassLoader());
      if ((paramContext instanceof Activity))
      {
        paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramBundle).bc(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.ahp(), "com/tencent/mm/plugin/fav/api/FavApiLogic", "startFavActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
        paramContext.startActivity((Intent)paramString.mq(0), (Bundle)paramString.mq(1));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/fav/api/FavApiLogic", "startFavActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
        AppMethodBeat.o(103348);
        return;
      }
      localIntent.addFlags(268435456);
      paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramBundle).bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.ahp(), "com/tencent/mm/plugin/fav/api/FavApiLogic", "startFavActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
      paramContext.startActivity((Intent)paramString.mq(0), (Bundle)paramString.mq(1));
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
  
  private static void a(gw paramgw)
  {
    AppMethodBeat.i(103268);
    if (bt.isNullOrNil(paramgw.dsV.desc))
    {
      paramgw.dsW.ret = -1;
      AppMethodBeat.o(103268);
      return;
    }
    Object localObject = agk(paramgw.dsV.desc);
    if ((localObject == null) || (((g)localObject).field_localId <= 0L))
    {
      paramgw.dsW.ret = -1;
      AppMethodBeat.o(103268);
      return;
    }
    boolean bool = e((g)localObject);
    String str = paramgw.dsV.dtb;
    if (bool)
    {
      paramgw.dsW.ret = 1;
      paramgw = (ArrayList)rrZ.get(Long.valueOf(((g)localObject).field_localId));
      if (paramgw != null)
      {
        if (paramgw.contains(str)) {
          paramgw.remove(str);
        }
        if (paramgw.size() == 0) {
          rrZ.remove(Long.valueOf(((g)localObject).field_localId));
        }
      }
      AppMethodBeat.o(103268);
      return;
    }
    if (bt.isNullOrNil(str))
    {
      paramgw.dsW.ret = -1;
      AppMethodBeat.o(103268);
      return;
    }
    long l = ((g)localObject).field_localId;
    ArrayList localArrayList = (ArrayList)rrZ.get(Long.valueOf(l));
    localObject = localArrayList;
    if (localArrayList == null) {
      localObject = new ArrayList();
    }
    ((ArrayList)localObject).add(str);
    rrZ.put(Long.valueOf(l), localObject);
    localObject = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(l);
    if ((localObject == null) || (((g)localObject).field_localId <= 0L))
    {
      paramgw.dsW.ret = -1;
      AppMethodBeat.o(103268);
      return;
    }
    if ((e((g)localObject)) || (((g)localObject).field_itemStatus == 10))
    {
      paramgw.dsW.ret = -1;
      com.tencent.mm.kernel.g.ajF().n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103255);
          b.d(this.rsb);
          AppMethodBeat.o(103255);
        }
      }, 500L);
      AppMethodBeat.o(103268);
      return;
    }
    paramgw.dsW.ret = -1;
    AppMethodBeat.o(103268);
  }
  
  private static void a(c paramc, g paramg)
  {
    AppMethodBeat.i(103295);
    Iterator localIterator = paramg.field_favProto.nZa.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      ajn localajn = (ajn)localIterator.next();
      if ((localajn.dataType != 1) && (localajn.dataType != 6))
      {
        if (!bt.isNullOrNil(localajn.GgR)) {
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
          ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ad(17, paramc.field_favLocalId);
          ((af)com.tencent.mm.kernel.g.ad(af.class)).getModService().run();
          AppMethodBeat.o(103295);
          return;
        }
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ad(9, paramc.field_favLocalId);
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
    Object localObject2 = new bzw();
    ((bzw)localObject2).GUM = 4;
    ((bzw)localObject2).GUN = 0;
    ((LinkedList)localObject1).add(localObject2);
    localObject2 = new LinkedList();
    bzz localbzz = new bzz();
    localbzz.uiP = "favitem.taglist";
    localbzz.nEf = 1;
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramg.field_tagProto.GjJ.size();
    int i = 0;
    while (i < j)
    {
      localStringBuffer.append("<tag>").append(bt.aRc((String)paramg.field_tagProto.GjJ.get(i))).append("</tag>");
      i += 1;
    }
    localbzz.yhw = localStringBuffer.toString();
    ad.v("MicroMsg.Fav.FavApiLogic", "do net scene mod tag, id=%d, tag=%s", new Object[] { Integer.valueOf(paramg.field_id), localbzz.yhw });
    ((LinkedList)localObject2).add(localbzz);
    if (paramg.field_id > 0)
    {
      localObject1 = new am(paramg.field_id, (LinkedList)localObject1, (LinkedList)localObject2);
      com.tencent.mm.kernel.g.aiU().a((n)localObject1, 0);
      h.j(paramg.field_id, j, paramInt);
      AppMethodBeat.o(103346);
      return;
    }
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getEditService().a(paramg.field_localId, (LinkedList)localObject1, (LinkedList)localObject2, paramInt);
    AppMethodBeat.o(103346);
  }
  
  public static void a(g paramg, ajn paramajn)
  {
    AppMethodBeat.i(103308);
    if (bt.isNullOrNil(paramajn.dsU))
    {
      AppMethodBeat.o(103308);
      return;
    }
    String str = agd(paramajn.dsU);
    c localc = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().agv(str);
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
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().agt(str);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
      AppMethodBeat.o(103308);
      return;
    }
    localObject = new com.tencent.mm.vfs.e(a(paramajn));
    if ((!bt.isNullOrNil(paramajn.GgN)) && (!bt.isNullOrNil(paramajn.hAe)) && (!((com.tencent.mm.vfs.e)localObject).exists()))
    {
      a(paramajn, paramg, 1);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().agt(str);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
    }
    AppMethodBeat.o(103308);
  }
  
  public static void a(g paramg, ajn paramajn, boolean paramBoolean)
  {
    AppMethodBeat.i(103307);
    if ((paramg == null) || (bt.isNullOrNil(paramajn.dsU)))
    {
      AppMethodBeat.o(103307);
      return;
    }
    ad.i("MicroMsg.Fav.FavApiLogic", "restart cdndata download, favId %d, favLocalId %d, dataId %s", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), paramajn.dsU });
    Object localObject2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().agv(paramajn.dsU);
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
      if ((!bt.isNullOrNil(((c)localObject1).field_cdnUrl)) && (!bt.isNullOrNil(((c)localObject1).field_cdnKey)) && (!bt.isNullOrNil(((c)localObject1).field_dataId)) && (((c)localObject1).field_cdnUrl.equals(paramajn.GgR)) && (((c)localObject1).field_cdnKey.equals(paramajn.GgT)))
      {
        localObject2 = localObject1;
        if (((c)localObject1).field_dataId.equals(paramajn.dsU)) {}
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
      ((c)localObject2).field_path = d(paramajn);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a((c)localObject2, new String[] { "dataId" });
      if (paramBoolean)
      {
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().agt(paramajn.dsU);
        if ((!bt.isNullOrNil(paramajn.GhT)) && (paramajn.GhT.equals("WeNoteHtmlFile")))
        {
          paramg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().agv(paramajn.dsU);
          ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().d(paramg);
        }
      }
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
      AppMethodBeat.o(103307);
      return;
    }
    localObject1 = new com.tencent.mm.vfs.e(d(paramajn));
    if ((!bt.isNullOrNil(paramajn.GgT)) && (!bt.isNullOrNil(paramajn.GgR)) && (!((com.tencent.mm.vfs.e)localObject1).exists()))
    {
      ad.i("MicroMsg.Fav.FavApiLogic", "klem big img not exist, start download.");
      long l = System.currentTimeMillis();
      a(paramajn, paramg, 1, true);
      if (paramBoolean)
      {
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().agt(paramajn.dsU);
        if ((!bt.isNullOrNil(paramajn.GhT)) && (paramajn.GhT.equals("WeNoteHtmlFile")))
        {
          paramg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().agv(paramajn.dsU);
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
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavSearchStorage().vG(paramg.field_localId);
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().A(paramg);
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().vC(paramg.field_localId);
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().w(paramg);
    if (paramBoolean)
    {
      Set localSet = cuA();
      localSet.add(paramg.field_id);
      i(localSet);
      cuC();
    }
    if (paramg.field_type == 18)
    {
      long l = paramg.field_localId;
      if (l <= 0L)
      {
        AppMethodBeat.o(103286);
        return;
      }
      paramg = new cp();
      paramg.dny.dnz = l;
      com.tencent.mm.sdk.b.a.IbL.l(paramg);
    }
    AppMethodBeat.o(103286);
  }
  
  public static void a(ajn paramajn, int paramInt, long paramLong)
  {
    AppMethodBeat.i(103329);
    if (bt.isNullOrNil(paramajn.dsU))
    {
      AppMethodBeat.o(103329);
      return;
    }
    if ((bt.isNullOrNil(paramajn.GgN)) || (bt.isNullOrNil(paramajn.hAe)))
    {
      AppMethodBeat.o(103329);
      return;
    }
    String str = agd(paramajn.dsU);
    c localc = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().agv(str);
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
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().agt(str);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
      AppMethodBeat.o(103329);
      return;
    }
    localObject = new com.tencent.mm.vfs.e(a(paramajn));
    if ((!bt.isNullOrNil(paramajn.GgN)) && (!bt.isNullOrNil(paramajn.hAe)) && (!((com.tencent.mm.vfs.e)localObject).exists()))
    {
      localObject = new g();
      ((g)localObject).field_localId = paramLong;
      ((g)localObject).field_id = -1;
      ((g)localObject).field_type = paramInt;
      a(paramajn, (g)localObject, 1);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().agt(str);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
    }
    AppMethodBeat.o(103329);
  }
  
  public static void a(ajn paramajn, g paramg, int paramInt)
  {
    AppMethodBeat.i(103296);
    if ((paramInt == 1) && ((paramajn.Ghx <= 0L) || (bt.isNullOrNil(paramajn.GgN)) || (bt.isNullOrNil(paramajn.hAe))))
    {
      ad.e("MicroMsg.Fav.FavApiLogic", "insertCdnThumbInfo, type recv, cdndataurl must not be null!");
      AppMethodBeat.o(103296);
      return;
    }
    if ((paramInt == 0) && (bt.isNullOrNil(a(paramajn))))
    {
      ad.e("MicroMsg.Fav.FavApiLogic", "insertCdnThumbInfo, type send, path must not be null!");
      AppMethodBeat.o(103296);
      return;
    }
    String str = agd(paramajn.dsU);
    if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().agv(str) != null)
    {
      ad.w("MicroMsg.Fav.FavApiLogic", "cdn info exist, id[%s], return", new Object[] { str });
      AppMethodBeat.o(103296);
      return;
    }
    ad.v("MicroMsg.Fav.FavApiLogic", "insert cdn thumb info, fav local id[%d] fav id[%d]", new Object[] { Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
    c localc = new c();
    localc.field_cdnKey = paramajn.GgN;
    localc.field_cdnUrl = paramajn.hAe;
    localc.field_dataId = str;
    localc.field_favLocalId = paramg.field_localId;
    localc.field_totalLen = ((int)paramajn.Ghx);
    localc.field_type = paramInt;
    localc.field_status = 1;
    localc.field_path = a(paramajn);
    localc.field_modifyTime = bt.flT();
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
  
  public static void a(ajn paramajn, g paramg, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(103297);
    if ((paramInt == 1) && ((bt.isNullOrNil(paramajn.GgT)) || (bt.isNullOrNil(paramajn.GgR))))
    {
      ad.e("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo, type recv, cdndataurl must not be null!");
      AppMethodBeat.o(103297);
      return;
    }
    if ((paramInt == 0) && (bt.isNullOrNil(d(paramajn))))
    {
      ad.e("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo, type send, path must not be null!");
      AppMethodBeat.o(103297);
      return;
    }
    if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().agv(paramajn.dsU) != null)
    {
      ad.v("MicroMsg.Fav.FavApiLogic", "cdn info exist, id[%s], return", new Object[] { paramajn.dsU });
      AppMethodBeat.o(103297);
      return;
    }
    ad.i("MicroMsg.Fav.FavApiLogic", "insert cdn data info, fav local id[%d] fav id[%d]", new Object[] { Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
    c localc = new c();
    localc.field_dataId = paramajn.dsU;
    localc.field_totalLen = ((int)paramajn.Ghm);
    localc.field_type = paramInt;
    localc.field_favLocalId = paramg.field_localId;
    localc.field_cdnKey = paramajn.GgT;
    localc.field_cdnUrl = paramajn.GgR;
    localc.field_path = d(paramajn);
    boolean bool;
    int i;
    label405:
    if (paramajn.dataType == 3)
    {
      localc.field_dataType = agf(paramajn.Ghg);
      localc.field_modifyTime = bt.flT();
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
      localc.field_dataType = paramajn.dataType;
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
      long l2 = aj.getContext().getSharedPreferences(aj.fkC(), 0).getLong("fav_mx_auto_upload_size", 0L);
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
      l1 = aj.getContext().getSharedPreferences(aj.fkC(), 0).getLong("fav_mx_auto_download_size", ((af)com.tencent.mm.kernel.g.ad(af.class)).getFileSizeLimit(true));
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
    d.f(paramContext, ".ui.transmit.MsgRetransmitUI", localIntent);
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
      ad.w("MicroMsg.Fav.FavApiLogic", "delete fav item fail, item is null");
      aq.f(paramRunnable);
      AppMethodBeat.o(103287);
      return false;
    }
    if (Looper.myLooper() == com.tencent.mm.kernel.g.ajF().IdO.getLooper())
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
      com.tencent.mm.kernel.g.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103256);
          ad.i("MicroMsg.Fav.FavApiLogic", "delete favItem id %d, localId %d, needBatchDel %B, do on worker thread", new Object[] { Integer.valueOf(this.rsc.field_id), Long.valueOf(this.rsc.field_localId), Boolean.valueOf(paramBoolean) });
          b.a(this.rsc, paramBoolean);
          aq.f(paramRunnable);
          b.s(this.rsc);
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
    final ajn localajn = c(paramg);
    String[] arrayOfString = new String[2];
    Runnable local3 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(103257);
        b.a(this.rsf, localajn);
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
      if (localajn != null)
      {
        arrayOfString[0] = a(localajn);
        arrayOfString[1] = localajn.dnv;
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
        localObject1 = paramg.field_favProto.Giw;
        if (localajn == null)
        {
          if (localObject1 != null) {
            arrayOfString[1] = ((aks)localObject1).thumbUrl;
          }
        }
        else
        {
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = ((aks)localObject1).thumbUrl)
          {
            localObject2 = localObject1;
            if (bt.isNullOrNil((String)localObject1)) {
              localObject2 = localajn.dnv;
            }
            arrayOfString[0] = a(localajn);
            arrayOfString[1] = localObject2;
            paramap.post(local3);
            break;
          }
          paramap = paramg.field_favProto.Giy;
          if (paramap != null)
          {
            arrayOfString[1] = paramap.thumbUrl;
            continue;
            paramap = paramg.field_favProto.GiA;
            if (paramap != null)
            {
              arrayOfString[1] = paramap.thumbUrl;
              continue;
              paramap = paramg.field_favProto.Giy;
              if (paramap != null) {
                arrayOfString[1] = paramap.thumbUrl;
              }
            }
          }
        }
      }
    }
    if (paramg.field_favProto.nZa != null)
    {
      Iterator localIterator = paramg.field_favProto.nZa.iterator();
      label375:
      localObject1 = localObject2;
      if (localIterator.hasNext())
      {
        localObject1 = (ajn)localIterator.next();
        if (((ajn)localObject1).dataType != 2) {
          break label435;
        }
        localObject1 = d((ajn)localObject1);
        paramap.post(local3);
      }
    }
    for (;;)
    {
      arrayOfString[0] = localObject1;
      arrayOfString[1] = localajn.dnv;
      break;
      label435:
      if (((ajn)localObject1).dataType != 15) {
        break label375;
      }
      localObject1 = a((ajn)localObject1);
      paramap.post(local3);
    }
  }
  
  private static com.tencent.mm.vfs.e agc(String paramString)
  {
    AppMethodBeat.i(103279);
    int i = paramString.hashCode();
    paramString = new com.tencent.mm.vfs.e(String.format("%s%s/%d/", new Object[] { com.tencent.mm.kernel.g.ajC().gBm, "favorite", Integer.valueOf(i & 0xFF) }));
    if ((!paramString.exists()) || (!paramString.isDirectory())) {
      paramString.mkdirs();
    }
    AppMethodBeat.o(103279);
    return paramString;
  }
  
  public static String agd(String paramString)
  {
    AppMethodBeat.i(103284);
    paramString = paramString + "_t";
    AppMethodBeat.o(103284);
    return paramString;
  }
  
  public static boolean age(String paramString)
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
  
  public static int agf(String paramString)
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
  
  public static String agg(String paramString)
  {
    AppMethodBeat.i(103303);
    com.tencent.mm.storage.am localam = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramString);
    if (localam != null)
    {
      if (!bt.isNullOrNil(localam.field_conRemark))
      {
        paramString = localam.field_conRemark;
        AppMethodBeat.o(103303);
        return paramString;
      }
      if (!bt.isNullOrNil(localam.field_nickname))
      {
        paramString = localam.field_nickname;
        AppMethodBeat.o(103303);
        return paramString;
      }
      paramString = localam.field_username;
      AppMethodBeat.o(103303);
      return paramString;
    }
    AppMethodBeat.o(103303);
    return paramString;
  }
  
  public static String agh(String paramString)
  {
    AppMethodBeat.i(103325);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(103325);
      return null;
    }
    paramString = new com.tencent.mm.vfs.e(cuB() + com.tencent.mm.b.g.getMessageDigest(paramString.getBytes()));
    if (paramString.exists())
    {
      paramString = com.tencent.mm.vfs.q.B(paramString.fOK());
      AppMethodBeat.o(103325);
      return paramString;
    }
    AppMethodBeat.o(103325);
    return null;
  }
  
  public static int agi(String paramString)
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
  
  public static g agj(String paramString)
  {
    AppMethodBeat.i(103338);
    g localg = new g();
    localg.field_localId = -1L;
    localg.field_id = -1;
    localg.field_xml = paramString;
    localg.field_type = 18;
    localg.agl(paramString);
    AppMethodBeat.o(103338);
    return localg;
  }
  
  private static g agk(String paramString)
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
      Map localMap = bw.M(paramString, "noteinfo");
      if (localMap == null)
      {
        ad.e("MicroMsg.Fav.FavApiLogic", "parseSnsNoteInfoXml, FavItemInfo maps null");
        AppMethodBeat.o(103339);
        return null;
      }
      g localg = new g();
      try
      {
        localg.field_favProto = new akd();
        localg.field_type = 18;
        Object localObject = (String)localMap.get(".noteinfo.edittime");
        localg.field_favProto.CL(bt.getLong((String)localObject, 0L));
        localObject = new ajx();
        ((ajx)localObject).Gjp = ((String)localMap.get(".noteinfo.noteeditor"));
        ((ajx)localObject).Gjo = ((String)localMap.get(".noteinfo.noteauthor"));
        localg.field_favProto.a((ajx)localObject);
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
  
  public static long b(g paramg)
  {
    AppMethodBeat.i(103263);
    if (paramg == null)
    {
      AppMethodBeat.o(103263);
      return 0L;
    }
    paramg = paramg.field_favProto.nZa.iterator();
    ajn localajn;
    for (int i = 0; paramg.hasNext(); i = (int)(localajn.Ghm + l))
    {
      localajn = (ajn)paramg.next();
      l = i;
    }
    long l = i;
    AppMethodBeat.o(103263);
    return l;
  }
  
  public static String b(akd paramakd)
  {
    AppMethodBeat.i(103358);
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramakd != null) && (paramakd.nZa != null))
    {
      paramakd = paramakd.nZa.iterator();
      while (paramakd.hasNext()) {
        localStringBuilder.append(((ajn)paramakd.next()).dsU).append(";");
      }
    }
    paramakd = localStringBuilder.toString();
    AppMethodBeat.o(103358);
    return paramakd;
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
        LinkedList localLinkedList = localg1.field_favProto.nZa;
        if (localg1.field_type != 18) {
          break label374;
        }
        i = 1;
        if (i >= localLinkedList.size()) {
          break;
        }
        ajn localajn = (ajn)localLinkedList.get(i);
        if (localajn.dataType != paramInt1) {
          break label379;
        }
        g localg2 = localg1.cuX();
        localg2.field_type = paramInt2;
        localg2.rsm = true;
        localg2.rsn = localg1;
        localg2.dsK = (localg1.field_localId + "_" + localajn.dsU);
        localg2.rso = localajn.dsU;
        localg2.field_favProto = com.tencent.mm.plugin.fav.a.a.c.c(localg1.field_favProto);
        localg2.field_favProto.nZa = new LinkedList();
        localg2.field_favProto.nZa.add(localajn);
        localg2.field_favProto.aPd(localajn.title);
        if (localajn.GhL != null)
        {
          if (paramInt1 == 6) {
            localg2.field_favProto.d(localajn.GhL.Giu);
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
        localg2.field_favProto.b(localajn.GhL.Giw);
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
    AppMethodBeat.i(221622);
    a(paramContext, paramString, paramIntent, null);
    AppMethodBeat.o(221622);
  }
  
  private static void b(gw paramgw)
  {
    AppMethodBeat.i(103341);
    g localg = agk(paramgw.dsV.desc);
    if (localg == null)
    {
      AppMethodBeat.o(103341);
      return;
    }
    if ((localg.field_favProto != null) && (localg.field_favProto.nZa != null))
    {
      Iterator localIterator = localg.field_favProto.nZa.iterator();
      while (localIterator.hasNext())
      {
        ajn localajn = (ajn)localIterator.next();
        if (localajn.dataType == 20)
        {
          localajn.wl(true);
          localajn.wk(true);
          localajn.aOt("");
          localajn.aOj("");
          localajn.aOk("");
          localajn.aOh("");
          localajn.aOi("");
        }
      }
    }
    paramgw.dsV.dnI = localg.field_favProto;
    AppMethodBeat.o(103341);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(103293);
    int i = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().z(paramc.field_favLocalId, 0);
    ad.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus, upload data status:%d, favlocalId:%d", new Object[] { Integer.valueOf(i), Long.valueOf(paramc.field_favLocalId) });
    g localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(paramc.field_favLocalId);
    if (localg == null)
    {
      ad.e("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus iteminfo null");
      AppMethodBeat.o(103293);
      return;
    }
    if (localg.cuW())
    {
      ad.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus waiting server upload skip.");
      AppMethodBeat.o(103293);
      return;
    }
    if ((paramc.field_status == 3) && (i != paramc.field_status) && (localg.field_type == 18) && (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().agv(paramc.field_dataId).field_status == 3))
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
      if (localg.cuV()) {
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ad(15, paramc.field_favLocalId);
      }
      for (;;)
      {
        ad.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus, continue upload data, favlocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
        AppMethodBeat.o(103293);
        return;
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ad(4, paramc.field_favLocalId);
      }
      if (localg.cuV()) {
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ad(16, paramc.field_favLocalId);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.g.yhR.f(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(localg.field_type), Integer.valueOf(-5), Long.valueOf(b(localg)), Long.valueOf(h.vx(localg.field_localId)) });
        ad.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus, error, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
        AppMethodBeat.o(103293);
        return;
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ad(6, paramc.field_favLocalId);
      }
      AppMethodBeat.o(103293);
      return;
      if (localg.field_type == 18)
      {
        a(paramc, localg);
        AppMethodBeat.o(103293);
        return;
      }
      if (localg.cuV())
      {
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ad(17, paramc.field_favLocalId);
        ad.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus start mod faviteminfo, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getModService().run();
        AppMethodBeat.o(103293);
        return;
      }
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ad(9, paramc.field_favLocalId);
      ad.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus start send faviteminfo, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getSendService().run();
      AppMethodBeat.o(103293);
      return;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ad(6, paramc.field_favLocalId);
      ad.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus pause, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
    }
  }
  
  private static void b(g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(103343);
    ajx localajx = new ajx();
    if (!paramBoolean) {
      localajx.Gjo = com.tencent.mm.model.u.aAm();
    }
    localajx.Gjp = com.tencent.mm.model.u.aAm();
    paramg.field_favProto.CL(bt.aQJ());
    paramg.field_favProto.a(localajx);
    AppMethodBeat.o(103343);
  }
  
  public static void b(ajn paramajn, int paramInt, long paramLong)
  {
    AppMethodBeat.i(103330);
    if (bt.isNullOrNil(paramajn.dsU))
    {
      AppMethodBeat.o(103330);
      return;
    }
    ad.i("MicroMsg.Fav.FavApiLogic", "restart cdndata download, dataId %s", new Object[] { paramajn.dsU });
    c localc = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().agv(paramajn.dsU);
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
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().agt(paramajn.dsU);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
      AppMethodBeat.o(103330);
      return;
    }
    localObject = new com.tencent.mm.vfs.e(d(paramajn));
    if ((!bt.isNullOrNil(paramajn.GgT)) && (!bt.isNullOrNil(paramajn.GgR)) && (!((com.tencent.mm.vfs.e)localObject).exists()))
    {
      ad.i("MicroMsg.Fav.FavApiLogic", "klem big img not exist, start download.");
      long l = System.currentTimeMillis();
      localObject = new g();
      ((g)localObject).field_localId = paramLong;
      ((g)localObject).field_id = -1;
      ((g)localObject).field_type = paramInt;
      a(paramajn, (g)localObject, 1, true);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().agt(paramajn.dsU);
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
    String str1 = "fav_" + com.tencent.mm.model.u.aAm() + "_0";
    String str2 = y.AH(str1);
    y.aBq().F(str2, true).k("prePublishId", str1);
    localIntent.putExtra("reportSessionId", str2);
    localIntent.putExtra("Ksnsupload_type", 0);
    localIntent.putExtra("sns_kemdia_path", paramString);
    d.b(paramContext, "sns", ".ui.SnsUploadUI", localIntent);
    AppMethodBeat.o(103352);
  }
  
  public static boolean b(long paramLong, Runnable paramRunnable)
  {
    AppMethodBeat.i(103331);
    boolean bool = a(((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(paramLong), true, paramRunnable);
    AppMethodBeat.o(103331);
    return bool;
  }
  
  public static String ba(float paramFloat)
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
  
  public static ajn c(g paramg)
  {
    AppMethodBeat.i(103264);
    if (paramg == null)
    {
      paramg = new ajn();
      AppMethodBeat.o(103264);
      return paramg;
    }
    if (paramg.field_favProto.nZa.size() == 0)
    {
      paramg = new ajn();
      AppMethodBeat.o(103264);
      return paramg;
    }
    paramg = (ajn)paramg.field_favProto.nZa.get(0);
    AppMethodBeat.o(103264);
    return paramg;
  }
  
  public static String c(ajn paramajn)
  {
    AppMethodBeat.i(103258);
    ajo localajo = paramajn.GhL;
    String str = "";
    switch (paramajn.dataType)
    {
    case 2: 
    case 3: 
    case 7: 
    case 9: 
    default: 
      paramajn = gh(gh("", localajo.title), localajo.desc);
    }
    for (;;)
    {
      AppMethodBeat.o(103258);
      return paramajn;
      paramajn = gh("", paramajn.desc);
      continue;
      paramajn = str;
      if (localajo.GiA != null)
      {
        paramajn = gh("", localajo.GiA.title);
        continue;
        paramajn = str;
        if (localajo.Giw != null)
        {
          paramajn = gh("", localajo.Giw.title);
          continue;
          str = gh("", localajo.iTM);
          paramajn = str;
          if (localajo.Giu != null)
          {
            paramajn = gh(gh(str, localajo.Giu.dDq), localajo.Giu.label);
            continue;
            paramajn = str;
            if (localajo.Giy != null)
            {
              paramajn = gh(gh("", localajo.Giy.title), localajo.Giy.desc);
              continue;
              paramajn = gh("", localajo.title);
            }
          }
        }
      }
    }
  }
  
  public static void c(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(103340);
    g localg = agk(paramString1);
    if (localg == null)
    {
      AppMethodBeat.o(103340);
      return;
    }
    nj localnj = new nj();
    localnj.dBj.type = 2;
    localnj.dBj.field_localId = -1L;
    localnj.dBj.context = paramContext;
    localnj.dBj.dBs = 4;
    localnj.dBj.dBt = true;
    paramContext = new Bundle();
    paramContext.putString("noteauthor", localg.field_favProto.FpF.Gjo);
    paramContext.putString("noteeditor", localg.field_favProto.FpF.Gjp);
    paramContext.putLong("edittime", localg.field_favProto.pQi);
    paramContext.putString("notexml", g.t(localg));
    paramContext.putString("snslocalid", paramString2);
    paramContext.putString("snsthumbpath", paramString3);
    paramContext.putString("snsnotelinkxml", paramString1);
    localnj.dBj.dBq = paramContext;
    localnj.dBj.field_favProto = localg.field_favProto;
    com.tencent.mm.sdk.b.a.IbL.l(localnj);
    AppMethodBeat.o(103340);
  }
  
  public static void c(gw paramgw)
  {
    AppMethodBeat.i(103345);
    Object localObject2;
    Object localObject3;
    if (paramgw.dsV.dtc == 1)
    {
      paramgw.dsW.path = vp(paramgw.dsV.dnC);
      localObject2 = paramgw.dsW;
      long l = paramgw.dsV.dnC;
      localObject3 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(l);
      if ((localObject3 == null) || (((g)localObject3).field_favProto == null)) {
        paramgw = "";
      }
      for (;;)
      {
        label86:
        ((gw.b)localObject2).thumbPath = paramgw;
        AppMethodBeat.o(103345);
        return;
        if ((((g)localObject3).field_type != 18) || (((g)localObject3).field_favProto.nZa.size() > 1))
        {
          paramgw = ((g)localObject3).field_favProto.nZa.iterator();
          for (;;)
          {
            if (paramgw.hasNext())
            {
              ajn localajn = (ajn)paramgw.next();
              switch (localajn.dataType)
              {
              default: 
                break;
              case 2: 
                localObject1 = a(localajn);
                paramgw = (gw)localObject1;
                if (i.fv((String)localObject1)) {
                  break label86;
                }
                paramgw = d(localajn);
                if (i.fv(paramgw))
                {
                  com.tencent.mm.sdk.platformtools.g.c(paramgw, 150, 150, Bitmap.CompressFormat.JPEG, 90, (String)localObject1);
                  paramgw = a(localajn);
                  break label86;
                }
                if (localajn.GgM)
                {
                  a((g)localObject3, localajn);
                  paramgw = (gw)localObject1;
                  break label86;
                }
                if (localajn.GgS)
                {
                  a((g)localObject3, localajn, true);
                  break label86;
                }
                paramgw = "";
                break label86;
              }
            }
          }
        }
        paramgw = "";
      }
    }
    if (paramgw.dsV.dtc == 2)
    {
      localObject1 = new g();
      ((g)localObject1).field_type = 2;
      localObject2 = new ajn();
      ((ajn)localObject2).aOs(di(localObject2.toString(), 2));
      localObject3 = d((ajn)localObject2);
      ((ajn)localObject2).aOt((String)localObject3);
      ((ajn)localObject2).ZI(2);
      ((g)localObject1).field_favProto.nZa.add(localObject2);
      paramgw.dsW.path = g.t((g)localObject1);
      paramgw.dsW.thumbPath = ((String)localObject3);
      AppMethodBeat.o(103345);
      return;
    }
    if (paramgw.dsV.dtc == 3)
    {
      localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(paramgw.dsV.dnC);
      if (localObject1 != null) {
        paramgw.dsW.path = (com.tencent.mm.model.u.aAm() + ";" + ((g)localObject1).field_fromUser + ";" + ((g)localObject1).field_updateTime);
      }
      AppMethodBeat.o(103345);
      return;
    }
    if (paramgw.dsV.dtc == 4)
    {
      b(paramgw);
      AppMethodBeat.o(103345);
      return;
    }
    if (paramgw.dsV.dtc == 5)
    {
      a(paramgw);
      AppMethodBeat.o(103345);
      return;
    }
    if (paramgw.dsV.dtc == 6)
    {
      localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(paramgw.dsV.dnC);
      if (localObject1 == null)
      {
        paramgw.dsW.ret = 0;
        AppMethodBeat.o(103345);
        return;
      }
      paramgw = paramgw.dsW;
      if (((g)localObject1).field_id > 0) {}
      for (int i = 1;; i = 0)
      {
        paramgw.ret = i;
        AppMethodBeat.o(103345);
        return;
      }
    }
    Object localObject1 = new g();
    ((g)localObject1).field_type = 18;
    ((g)localObject1).field_favProto = paramgw.dsV.dnI;
    paramgw.dsW.path = g.t((g)localObject1);
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
    int i = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().z(paramc.field_favLocalId, 1);
    ad.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, download data status:%d, favlocalId:%d", new Object[] { Integer.valueOf(i), Long.valueOf(paramc.field_favLocalId) });
    if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage() == null)
    {
      ad.e("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus getFavItemInfoStorage null");
      AppMethodBeat.o(103294);
      return;
    }
    g localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(paramc.field_favLocalId);
    if (localg == null)
    {
      ad.e("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus iteminfo null");
      AppMethodBeat.o(103294);
      return;
    }
    if ((localg.cuW()) || (localg.cuT()) || (localg.isUploadFailed()))
    {
      ad.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, status upload, skip. isWaitServerUpload:%b  isUploadding:%b  isUploadFailed:%b", new Object[] { Boolean.valueOf(localg.cuW()), Boolean.valueOf(localg.cuT()), Boolean.valueOf(localg.isUploadFailed()) });
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
      h.vy(localg.field_localId);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ad(7, paramc.field_favLocalId);
      AppMethodBeat.o(103294);
      return;
      ad.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, error, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
      com.tencent.mm.plugin.report.service.g.yhR.f(10659, new Object[] { Integer.valueOf(1), Integer.valueOf(localg.field_type), Integer.valueOf(-5), Long.valueOf(b(localg)), Long.valueOf(h.vx(localg.field_localId)) });
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ad(8, paramc.field_favLocalId);
      AppMethodBeat.o(103294);
      return;
      ad.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus init, favLocalId:%d, favId:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id) });
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ad(10, paramc.field_favLocalId);
      AppMethodBeat.o(103294);
      return;
      ad.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus finish, favLocalId:%d, favId:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id) });
      com.tencent.mm.plugin.report.service.g.yhR.f(10659, new Object[] { Integer.valueOf(1), Integer.valueOf(localg.field_type), Integer.valueOf(0), Long.valueOf(b(localg)), Long.valueOf(h.vx(localg.field_localId)) });
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ad(10, paramc.field_favLocalId);
      AppMethodBeat.o(103294);
      return;
      ad.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus pause, favLocalId:%d, favId:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id) });
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ad(8, paramc.field_favLocalId);
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
    d.f(paramContext, ".ui.transmit.MsgRetransmitUI", localIntent);
    AppMethodBeat.o(103354);
  }
  
  private static Set<String> cuA()
  {
    AppMethodBeat.i(103273);
    Object localObject = (String)com.tencent.mm.kernel.g.ajC().ajl().get(225282, "");
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
  
  public static String cuB()
  {
    AppMethodBeat.i(103277);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.ajD();
    localObject = com.tencent.mm.kernel.g.ajC().gBm + "favorite/web/";
    AppMethodBeat.o(103277);
    return localObject;
  }
  
  public static void cuC()
  {
    AppMethodBeat.i(103281);
    Object localObject2 = cuA();
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
      com.tencent.mm.kernel.g.aiU().a((n)localObject1, 0);
    }
    AppMethodBeat.o(103281);
  }
  
  public static long cuD()
  {
    AppMethodBeat.i(103300);
    long l2 = cuE() - cuF();
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 1024L;
    }
    AppMethodBeat.o(103300);
    return l1;
  }
  
  public static long cuE()
  {
    AppMethodBeat.i(103301);
    long l = ((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Ite, Long.valueOf(0L))).longValue();
    AppMethodBeat.o(103301);
    return l;
  }
  
  public static long cuF()
  {
    AppMethodBeat.i(103302);
    long l = ((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Itd, Long.valueOf(0L))).longValue();
    AppMethodBeat.o(103302);
    return l;
  }
  
  public static boolean cuG()
  {
    AppMethodBeat.i(103311);
    if (cuE() == 0L)
    {
      AppMethodBeat.o(103311);
      return false;
    }
    if (cuD() < 52428800L)
    {
      AppMethodBeat.o(103311);
      return true;
    }
    AppMethodBeat.o(103311);
    return false;
  }
  
  public static String cuH()
  {
    AppMethodBeat.i(103317);
    String str = com.tencent.mm.kernel.g.ajC().gBm + "favorite/music/";
    AppMethodBeat.o(103317);
    return str;
  }
  
  public static String cuI()
  {
    AppMethodBeat.i(103320);
    String str = com.tencent.mm.kernel.g.ajC().gBm + "favorite/";
    AppMethodBeat.o(103320);
    return str;
  }
  
  public static String cuJ()
  {
    AppMethodBeat.i(103321);
    String str = com.tencent.mm.kernel.g.ajC().gBm + "favorite/voice/";
    AppMethodBeat.o(103321);
    return str;
  }
  
  public static boolean cuK()
  {
    AppMethodBeat.i(103328);
    if (ai.cvy() > 0)
    {
      AppMethodBeat.o(103328);
      return true;
    }
    AppMethodBeat.o(103328);
    return false;
  }
  
  public static boolean cuL()
  {
    AppMethodBeat.i(103337);
    if (cuE() == 0L)
    {
      AppMethodBeat.o(103337);
      return false;
    }
    if (cuD() < 10485760L)
    {
      AppMethodBeat.o(103337);
      return true;
    }
    AppMethodBeat.o(103337);
    return false;
  }
  
  public static boolean cuM()
  {
    AppMethodBeat.i(168688);
    if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzG, 0) != 1) && (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qAv, 0) == 1))
    {
      AppMethodBeat.o(168688);
      return true;
    }
    AppMethodBeat.o(168688);
    return false;
  }
  
  public static String d(ajn paramajn)
  {
    AppMethodBeat.i(103278);
    if (paramajn == null)
    {
      AppMethodBeat.o(103278);
      return "";
    }
    Object localObject2 = paramajn.dsU;
    if ((bt.isNullOrNil((String)localObject2)) || (!com.tencent.mm.kernel.g.ajx()))
    {
      AppMethodBeat.o(103278);
      return "";
    }
    com.tencent.mm.vfs.e locale2 = agc((String)localObject2);
    int j = 0;
    int i = j;
    com.tencent.mm.vfs.e locale1 = locale2;
    Object localObject1 = localObject2;
    if (paramajn.dataType == 8)
    {
      i = j;
      locale1 = locale2;
      localObject1 = localObject2;
      if (!bt.isNullOrNil(paramajn.title))
      {
        localObject1 = paramajn.title;
        locale1 = agc(paramajn.dsU);
        i = 1;
      }
    }
    localObject2 = localObject1;
    if (paramajn.Ghg != null)
    {
      localObject2 = localObject1;
      if (paramajn.Ghg.trim().length() > 0)
      {
        localObject2 = localObject1;
        if (i == 0) {
          localObject2 = (String)localObject1 + "." + paramajn.Ghg;
        }
      }
    }
    localObject1 = new com.tencent.mm.vfs.e(locale1, (String)localObject2);
    if ((((com.tencent.mm.vfs.e)localObject1).exists()) || (bt.isNullOrNil(paramajn.Ghi)))
    {
      paramajn = com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject1).fOK());
      AppMethodBeat.o(103278);
      return paramajn;
    }
    localObject2 = com.tencent.mm.b.g.getMessageDigest((paramajn.Ghi + paramajn.dsU).getBytes());
    if (bt.isNullOrNil((String)localObject2))
    {
      paramajn = com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject1).fOK());
      AppMethodBeat.o(103278);
      return paramajn;
    }
    localObject1 = localObject2;
    if (paramajn.Ghg != null)
    {
      localObject1 = localObject2;
      if (paramajn.Ghg.trim().length() > 0) {
        localObject1 = (String)localObject2 + "." + paramajn.Ghg;
      }
    }
    localObject1 = new com.tencent.mm.vfs.e(locale1, (String)localObject1);
    if (((com.tencent.mm.vfs.e)localObject1).exists())
    {
      paramajn = com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject1).fOK());
      AppMethodBeat.o(103278);
      return paramajn;
    }
    localObject2 = paramajn.dsU;
    localObject1 = localObject2;
    if (paramajn.Ghg != null)
    {
      localObject1 = localObject2;
      if (paramajn.Ghg.trim().length() > 0) {
        localObject1 = (String)localObject2 + "." + paramajn.Ghg;
      }
    }
    ad.d("MicroMsg.Fav.FavApiLogic", "use dataId.fmt, ".concat(String.valueOf(localObject1)));
    paramajn = com.tencent.mm.vfs.q.B(new com.tencent.mm.vfs.e(locale1, (String)localObject1).fOK());
    AppMethodBeat.o(103278);
    return paramajn;
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
        if (!rrZ.containsKey(Long.valueOf(paramg.field_localId)))
        {
          AppMethodBeat.o(103269);
          continue;
        }
        if (rrZ.get(Long.valueOf(paramg.field_localId)) == null) {
          break label101;
        }
      }
      finally {}
      if (((ArrayList)rrZ.get(Long.valueOf(paramg.field_localId))).size() == 0)
      {
        label101:
        AppMethodBeat.o(103269);
      }
      else
      {
        String str = vp(paramg.field_localId);
        ad.i("MicroMsg.Fav.FavApiLogic", "checkUpdateSnsNotePostXml, resend favlocal id:%d,xml:%s", new Object[] { Long.valueOf(paramg.field_localId), str });
        rp localrp = new rp();
        localrp.dGj.dGk = ((ArrayList)rrZ.get(Long.valueOf(paramg.field_localId)));
        localrp.dGj.dGl = str;
        com.tencent.mm.sdk.b.a.IbL.l(localrp);
        rrZ.remove(Long.valueOf(paramg.field_localId));
        AppMethodBeat.o(103269);
      }
    }
  }
  
  public static String di(String paramString, int paramInt)
  {
    AppMethodBeat.i(103260);
    paramString = com.tencent.mm.b.g.getMessageDigest((paramString + paramInt + System.currentTimeMillis()).getBytes());
    AppMethodBeat.o(103260);
    return paramString;
  }
  
  public static void dl(List<Integer> paramList)
  {
    AppMethodBeat.i(103271);
    if (paramList.size() == 0)
    {
      ad.e("MicroMsg.Fav.FavApiLogic", "setDeleted list null");
      AppMethodBeat.o(103271);
      return;
    }
    Set localSet = cuA();
    ad.i("MicroMsg.Fav.FavApiLogic", "setDeleted before del:%s", new Object[] { localSet.toString() });
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Integer localInteger = (Integer)paramList.next();
      ad.i("MicroMsg.Fav.FavApiLogic", "setDeleted id:%d, ret:%b", new Object[] { localInteger, Boolean.valueOf(localSet.remove(localInteger.toString())) });
    }
    ad.i("MicroMsg.Fav.FavApiLogic", "setDeleted after del:%s", new Object[] { localSet.toString() });
    i(localSet);
    AppMethodBeat.o(103271);
  }
  
  public static boolean dm(List<g> paramList)
  {
    AppMethodBeat.i(103285);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ad.w("MicroMsg.Fav.FavApiLogic", "delete fav item fail, item is null");
      AppMethodBeat.o(103285);
      return false;
    }
    Set localSet = cuA();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      g localg = (g)paramList.next();
      h(localg);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavSearchStorage().vG(localg.field_localId);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().A(localg);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().vC(localg.field_localId);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().w(localg);
      localSet.add(localg.field_id);
      ad.d("MicroMsg.Fav.FavApiLogic", "delete id %d", new Object[] { Integer.valueOf(localg.field_id) });
    }
    i(localSet);
    cuC();
    AppMethodBeat.o(103285);
    return true;
  }
  
  public static void e(ajn paramajn)
  {
    AppMethodBeat.i(103309);
    c localc = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().agv(paramajn.dsU);
    if ((localc != null) && (localc.field_status != 3))
    {
      localc.field_status = 2;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().pauseDownload(paramajn.dsU);
    }
    localc = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().agv(agd(paramajn.dsU));
    if ((localc != null) && (localc.field_status != 3))
    {
      localc.field_status = 2;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().pauseDownload(agd(paramajn.dsU));
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
    paramg = paramg.field_favProto.nZa.iterator();
    ajn localajn;
    do
    {
      if (!paramg.hasNext()) {
        break;
      }
      localajn = (ajn)paramg.next();
    } while (((localajn.dataType != 8) && (localajn.dataType != 4) && (localajn.dataType != 2) && (localajn.dataType != 3)) || ((!bt.isNullOrNil(localajn.GgR)) && (!bt.isNullOrNil(localajn.GgT))));
    for (boolean bool = false;; bool = true)
    {
      AppMethodBeat.o(103270);
      return bool;
    }
  }
  
  public static void eJ(Context paramContext)
  {
    AppMethodBeat.i(221053);
    if (0L >= rsa)
    {
      ad.i("MicroMsg.Fav.FavApiLogic", "addTagWhenAddToFav,try to add tag ,but favLocalId is null, return");
      AppMethodBeat.o(221053);
      return;
    }
    g localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(rsa);
    rsa = 0L;
    if (localg == null)
    {
      ad.i("MicroMsg.Fav.FavApiLogic", "addTagWhenAddToFav,try to add tag ,but iteminfo is null, return");
      AppMethodBeat.o(221053);
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
    AppMethodBeat.o(221053);
  }
  
  public static boolean f(g paramg)
  {
    AppMethodBeat.i(103280);
    if (paramg.field_favProto == null)
    {
      AppMethodBeat.o(103280);
      return false;
    }
    paramg = paramg.field_favProto.nZa.iterator();
    while (paramg.hasNext())
    {
      ajn localajn = (ajn)paramg.next();
      if (localajn.GhZ == 2)
      {
        AppMethodBeat.o(103280);
        return true;
      }
      if (localajn.GhZ == 1)
      {
        AppMethodBeat.o(103280);
        return true;
      }
    }
    AppMethodBeat.o(103280);
    return false;
  }
  
  public static boolean f(ajn paramajn)
  {
    AppMethodBeat.i(103316);
    f localf = com.tencent.mm.az.a.aJJ();
    if ((localf != null) && (localf.ihe == 6) && (bt.bI(paramajn.dsU, "").equals(localf.ihg)) && (com.tencent.mm.az.a.aJG()))
    {
      AppMethodBeat.o(103316);
      return true;
    }
    AppMethodBeat.o(103316);
    return false;
  }
  
  public static boolean g(g paramg)
  {
    if (paramg == null) {}
    while ((paramg.field_itemStatus != 8) && (paramg.field_itemStatus != 10) && (paramg.field_itemStatus != 7)) {
      return false;
    }
    return true;
  }
  
  public static boolean g(ajn paramajn)
  {
    AppMethodBeat.i(103326);
    boolean bool = new com.tencent.mm.vfs.e(d(paramajn)).exists();
    AppMethodBeat.o(103326);
    return bool;
  }
  
  public static String getAppName(Context paramContext, String paramString)
  {
    AppMethodBeat.i(103318);
    ah.b localb = ah.a.hFM;
    if (localb != null)
    {
      paramContext = localb.r(paramContext, paramString);
      AppMethodBeat.o(103318);
      return paramContext;
    }
    AppMethodBeat.o(103318);
    return "";
  }
  
  private static String gh(String paramString1, String paramString2)
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
  
  private static void h(g paramg)
  {
    AppMethodBeat.i(103282);
    Set localSet = ao.rtS;
    paramg = paramg.field_favProto.nZa;
    int i = 0;
    while (i < paramg.size())
    {
      Object localObject = a((ajn)paramg.get(i));
      if ((localSet == null) || (!localSet.contains(localObject))) {
        i.deleteFile((String)localObject);
      }
      localObject = d((ajn)paramg.get(i));
      if ((localSet == null) || (!localSet.contains(localObject))) {
        i.deleteFile((String)localObject);
      }
      localObject = (ajn)paramg.get(i);
      if ((((ajn)localObject).GhL != null) && (((ajn)localObject).GhL.GiM != null)) {
        com.tencent.mm.modelvideo.u.Hx(((ajn)localObject).dsU);
      }
      i += 1;
    }
    AppMethodBeat.o(103282);
  }
  
  public static boolean h(ajn paramajn)
  {
    AppMethodBeat.i(103327);
    boolean bool = t.aQj(d(paramajn));
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
      if (paramg.field_favProto.Giw != null) {
        str1 = paramg.field_favProto.Giw.GjX;
      }
      String str2 = str1;
      if (paramg.field_favProto.Gjv != null)
      {
        str2 = str1;
        if (bt.isNullOrNil(str1)) {
          str2 = paramg.field_favProto.Gjv.link;
        }
      }
      paramg = new gq();
      paramg.dsz.url = str2;
      com.tencent.mm.sdk.b.a.IbL.l(paramg);
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
    ad.i("MicroMsg.Fav.FavApiLogic", "set need del IDs: %s", new Object[] { paramSet });
    com.tencent.mm.kernel.g.ajC().ajl().set(225282, paramSet);
    AppMethodBeat.o(103272);
  }
  
  public static void j(g paramg)
  {
    AppMethodBeat.i(103290);
    j localj = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavSearchStorage().vH(paramg.field_localId);
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
      if (paramg.field_favProto.Gjv != null)
      {
        localObject1 = paramg.field_favProto.Gjv;
        if (!bt.isNullOrNil(((akj)localObject1).dyU))
        {
          localStringBuffer.append(((akj)localObject1).dyU);
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(((akj)localObject1).dyU);
          if (localObject2 != null) {
            localStringBuffer.append(((aw)localObject2).field_nickname).append(((aw)localObject2).field_conRemark);
          }
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(((akj)localObject1).toUser);
          if (localObject2 != null) {
            localStringBuffer.append(((aw)localObject2).field_nickname).append(((aw)localObject2).field_conRemark);
          }
          localStringBuffer.append(((akj)localObject1).GiV);
        }
      }
      Object localObject1 = paramg.field_favProto.nZa;
      localj.field_subtype = 0;
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ajn)((Iterator)localObject1).next();
        if (((ajn)localObject2).desc != null) {
          localStringBuffer.append(((ajn)localObject2).desc);
        }
        if (((ajn)localObject2).title != null) {
          localStringBuffer.append(((ajn)localObject2).title);
        }
        int j = ((ajn)localObject2).dataType;
        int k = localj.field_subtype;
        localj.field_subtype = (j.DX(j) | k);
      }
      if (paramg.field_favProto.Giw != null)
      {
        if (paramg.field_favProto.Giw.desc != null) {
          localStringBuffer.append(paramg.field_favProto.Giw.desc);
        }
        if (paramg.field_favProto.Giw.title != null) {
          localStringBuffer.append(paramg.field_favProto.Giw.title);
        }
      }
      if (paramg.field_favProto.Giy != null)
      {
        if (paramg.field_favProto.Giy.desc != null) {
          localStringBuffer.append(paramg.field_favProto.Giy.desc);
        }
        if (paramg.field_favProto.Giy.title != null) {
          localStringBuffer.append(paramg.field_favProto.Giy.title);
        }
      }
      if (paramg.field_favProto.GiO != null)
      {
        if (paramg.field_favProto.GiO.nickname != null) {
          localStringBuffer.append(paramg.field_favProto.GiO.nickname);
        }
        if (paramg.field_favProto.GiO.desc != null) {
          localStringBuffer.append(paramg.field_favProto.GiO.desc);
        }
      }
      localj.field_tagContent = "";
      localObject1 = paramg.field_tagProto.GjI.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localj.field_tagContent = (localj.field_tagContent + " " + (String)localObject2);
        localStringBuffer.append((String)localObject2);
      }
      localObject1 = paramg.field_tagProto.GjJ.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localj.field_tagContent = (localj.field_tagContent + " " + (String)localObject2);
        localStringBuffer.append((String)localObject2);
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().agq((String)localObject2);
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
    if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(paramg.field_localId) != null)
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
      if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().vz(paramg.field_localId).size() == 0)
      {
        paramg.field_itemStatus = 9;
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
        paramg = new ag(paramg);
        com.tencent.mm.kernel.g.aiU().a(paramg, 0);
        AppMethodBeat.o(103305);
        return;
      }
      paramg.field_itemStatus = 4;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().y(paramg);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
      Iterator localIterator = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().vz(paramg.field_localId).iterator();
      c localc;
      while (localIterator.hasNext())
      {
        localc = (c)localIterator.next();
        ad.i("MicroMsg.Fav.FavApiLogic", "force upload favItem[last failed], favid:%d localId:%d, dataId:%s, dataType:%d totalLength %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), localc.field_dataId, Integer.valueOf(localc.field_dataType), Integer.valueOf(localc.field_totalLen) });
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().agt(localc.field_dataId);
      }
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
      AppMethodBeat.o(103305);
      return;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ad(12, paramg.field_localId);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getSendService().run();
      AppMethodBeat.o(103305);
      return;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ad(15, paramg.field_localId);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().y(paramg);
      localIterator = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().vz(paramg.field_localId).iterator();
      while (localIterator.hasNext())
      {
        localc = (c)localIterator.next();
        ad.i("MicroMsg.Fav.FavApiLogic", "force upload favItem[last mod failed], favid:%d localId:%d, dataId:%s, dataType:%d totalLength %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), localc.field_dataId, Integer.valueOf(localc.field_dataType), Integer.valueOf(localc.field_totalLen) });
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().agt(localc.field_dataId);
      }
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
      AppMethodBeat.o(103305);
      return;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ad(17, paramg.field_localId);
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
      Object localObject = paramg.field_favProto.nZa;
      if (((List)localObject).size() == 0)
      {
        AppMethodBeat.o(103306);
        return;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ajn localajn = (ajn)((Iterator)localObject).next();
        a(paramg, localajn, true);
        a(paramg, localajn);
      }
      AppMethodBeat.o(103306);
      return;
    }
    ad.e("MicroMsg.Fav.FavApiLogic", "status not download failed or done!");
    AppMethodBeat.o(103306);
  }
  
  public static void n(g paramg)
  {
    AppMethodBeat.i(103310);
    if (!paramg.cuT())
    {
      ad.e("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, not uploading");
      AppMethodBeat.o(103310);
      return;
    }
    ad.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, itemStatu:%d", new Object[] { Integer.valueOf(paramg.field_itemStatus) });
    Iterator localIterator = paramg.field_favProto.nZa.iterator();
    while (localIterator.hasNext())
    {
      ajn localajn = (ajn)localIterator.next();
      c localc = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().agv(localajn.dsU);
      if ((localc != null) && (localc.field_status != 3))
      {
        localc.field_status = 2;
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().agu(localajn.dsU);
      }
      localc = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().agv(agd(localajn.dsU));
      if ((localc != null) && (localc.field_status != 3))
      {
        localc.field_status = 2;
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().agu(agd(localajn.dsU));
      }
    }
    paramg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(paramg.field_localId);
    ad.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, after pause data itemStatu:%d", new Object[] { Integer.valueOf(paramg.field_itemStatus) });
    switch (paramg.field_itemStatus)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(103310);
      return;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ad(3, paramg.field_localId);
      ad.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(3) });
      AppMethodBeat.o(103310);
      return;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ad(6, paramg.field_localId);
      ad.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(6) });
      AppMethodBeat.o(103310);
      return;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ad(11, paramg.field_localId);
      ad.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(11) });
      AppMethodBeat.o(103310);
      return;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ad(14, paramg.field_localId);
      ad.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(14) });
      AppMethodBeat.o(103310);
      return;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ad(16, paramg.field_localId);
      ad.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(16) });
      AppMethodBeat.o(103310);
      return;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ad(18, paramg.field_localId);
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
    ajn localajn = c(paramg);
    if (localajn == null)
    {
      AppMethodBeat.o(103319);
      return false;
    }
    long l = bt.HI();
    com.tencent.mm.plugin.sight.base.a locala = com.tencent.mm.plugin.sight.base.e.axx(d(localajn));
    int j;
    int i;
    boolean bool;
    if (locala != null)
    {
      j = locala.getVideoDuration();
      i = localajn.duration;
      if ((i <= 0) || (Math.abs(i - j) >= 2))
      {
        localajn.ZH(j);
        bool = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.Fav.FavApiLogic", "repair video duration[%d TO %d] %b cost time %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool), Long.valueOf(bt.aO(l)) });
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
    j localj = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavSearchStorage().vH(paramg.field_localId);
    if (localj == null)
    {
      localj = new j();
      localj.field_localId = paramg.field_localId;
    }
    for (int i = 1;; i = 0)
    {
      localj.field_tagContent = "";
      Iterator localIterator = paramg.field_tagProto.GjI.iterator();
      String str;
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        localj.field_tagContent = (localj.field_tagContent + " " + str);
      }
      localIterator = paramg.field_tagProto.GjJ.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        localj.field_tagContent = (localj.field_tagContent + " " + str);
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().agq(str);
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
  
  public static void q(g paramg)
  {
    AppMethodBeat.i(103344);
    if (paramg == null)
    {
      AppMethodBeat.o(103344);
      return;
    }
    ajx localajx = paramg.field_favProto.FpF;
    if ((localajx != null) && (!bt.isNullOrNil(localajx.Gjp)))
    {
      AppMethodBeat.o(103344);
      return;
    }
    if (paramg.field_type == 18)
    {
      if (paramg.field_favProto.Gjv.sourceType != 6) {
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
      paramg = paramg.field_favProto.nZa.iterator();
      l = 0L;
      if (paramg.hasNext())
      {
        localObject = (ajn)paramg.next();
        if (localObject == null) {
          break label455;
        }
        l = ((ajn)localObject).Ghm + l;
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
          paramg = paramg.field_favProto.Giw.GjX;
          localStringBuffer.append(paramg);
          break;
          if (paramg == null) {
            break;
          }
          paramg = paramg.field_favProto.nZa.iterator();
          int i = 0;
          int m = 0;
          int k = 0;
          int j = 0;
          while (paramg.hasNext())
          {
            localObject = (ajn)paramg.next();
            switch (((ajn)localObject).dataType)
            {
            case 3: 
            default: 
              i += 1;
              break;
            case 1: 
              if (bt.isNullOrNil(((ajn)localObject).desc)) {
                break label452;
              }
              k = ((ajn)localObject).desc.getBytes().length + k;
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
    com.tencent.mm.kernel.g.aiU().a(localak, 0);
    AppMethodBeat.o(103324);
  }
  
  public static float sv(long paramLong)
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
  
  public static void vn(long paramLong)
  {
    AppMethodBeat.i(103265);
    ad.i("MicroMsg.Fav.FavApiLogic", "setUsedCapacity:%d", new Object[] { Long.valueOf(paramLong) });
    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Itd, Long.valueOf(paramLong));
    AppMethodBeat.o(103265);
  }
  
  public static void vo(long paramLong)
  {
    AppMethodBeat.i(103266);
    ad.i("MicroMsg.Fav.FavApiLogic", "setTotalCapacity:%d", new Object[] { Long.valueOf(paramLong) });
    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Ite, Long.valueOf(paramLong));
    AppMethodBeat.o(103266);
  }
  
  private static String vp(long paramLong)
  {
    AppMethodBeat.i(103267);
    StringBuilder localStringBuilder = new StringBuilder();
    g localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(paramLong);
    if ((localg == null) || (localg.field_favProto == null) || (localg.field_favProto.nZa.size() <= 1))
    {
      AppMethodBeat.o(103267);
      return "";
    }
    ajx localajx = localg.field_favProto.FpF;
    String str2 = "";
    String str1 = "";
    if (localajx != null)
    {
      str2 = localajx.Gjp;
      str1 = localajx.Gjo;
    }
    localStringBuilder.append("<noteinfo>");
    localStringBuilder.append("<noteauthor>").append(str1).append("</noteauthor>");
    localStringBuilder.append("<noteeditor>").append(str2).append("</noteeditor>");
    localStringBuilder.append("<edittime>").append(localg.field_favProto.pQi).append("</edittime>");
    localStringBuilder.append("<editusr>").append(str1).append("</editusr>");
    localStringBuilder.append("<favlocalid>").append(localg.field_localId).append("</favlocalid>");
    localStringBuilder.append(com.tencent.mm.plugin.fav.a.a.a.dn(localg.field_favProto.nZa).replace("cdn_dataurl", "cdndataurl").replace("cdn_datakey", "cdndatakey").replace("cdn_thumburl", "cdnthumburl").replace("cdn_thumbkey", "cdnthumbkey").replace("thumbfullsize", "thumbsize").replace("fullsize", "datasize").replace("datasrcname", "sourcename").replace("datasrctime", "sourcetime").replace("stream_lowbandurl", "streamlowbandurl").replace("stream_dataurl", "streamdataurl").replace("stream_weburl", "streamweburl"));
    localStringBuilder.append("</noteinfo>");
    str1 = localStringBuilder.toString();
    AppMethodBeat.o(103267);
    return str1;
  }
  
  public static void vq(long paramLong)
  {
    AppMethodBeat.i(103274);
    aj.getContext().getSharedPreferences(aj.fkC(), 0).edit().putLong("fav_mx_auto_download_size", paramLong).commit();
    AppMethodBeat.o(103274);
  }
  
  public static void vr(long paramLong)
  {
    AppMethodBeat.i(103275);
    aj.getContext().getSharedPreferences(aj.fkC(), 0).edit().putLong("fav_mx_auto_upload_size", paramLong).commit();
    AppMethodBeat.o(103275);
  }
  
  public static void vs(long paramLong)
  {
    AppMethodBeat.i(103276);
    aj.getContext().getSharedPreferences(aj.fkC(), 0).edit().putLong("fav_mx_file_size", paramLong).commit();
    AppMethodBeat.o(103276);
  }
  
  public static void vt(long paramLong)
  {
    rsa = paramLong;
  }
  
  public static float vu(long paramLong)
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
  
  public static String vv(long paramLong)
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
  
  public static long y(long paramLong, int paramInt)
  {
    AppMethodBeat.i(103323);
    ad.i("MicroMsg.Fav.FavApiLogic", "tryStartBatchGet...");
    long l1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().E(paramLong, paramInt);
    long l2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().C(paramLong, paramInt);
    ad.i("MicroMsg.Fav.FavApiLogic", "klem, tryStartBatchGet, batchGetTime:%d, itemTiem:%d, updateTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(paramLong) });
    if (l1 == 0L)
    {
      AppMethodBeat.o(103323);
      return l2;
    }
    Object localObject = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().D(l1, paramInt);
    if (((LinkedList)localObject).size() > 0)
    {
      ad.i("MicroMsg.Fav.FavApiLogic", "klem, tryStartBatchGet, batchGetTime:%d, itemTiem:%d, updateTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(paramLong) });
      ad.i("MicroMsg.Fav.FavApiLogic", "klem, tryStartBatchGet, need batch get idList size:%d", new Object[] { Integer.valueOf(((LinkedList)localObject).size()) });
      localObject = new ai((LinkedList)localObject);
      if (!com.tencent.mm.kernel.g.aiU().a((n)localObject, 0))
      {
        ad.w("MicroMsg.Fav.FavApiLogic", "do scene BatchGetFav fail");
        ai.cvx();
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
  
  public static String zg(String paramString)
  {
    AppMethodBeat.i(103304);
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramString);
    if (localObject == null)
    {
      ad.w("MicroMsg.Fav.FavApiLogic", "wtf get contact null, username %s", new Object[] { paramString });
      AppMethodBeat.o(103304);
      return "";
    }
    String str = ((com.tencent.mm.storage.am)localObject).adv();
    localObject = str;
    if (com.tencent.mm.model.w.vF(str))
    {
      paramString = com.tencent.mm.model.q.yQ(paramString);
      localObject = com.tencent.mm.model.u.aAm();
      if ((paramString != null) && (!paramString.isEmpty())) {
        break label110;
      }
      ad.w("MicroMsg.Fav.FavApiLogic", "get members from username error, content empty");
    }
    for (localObject = str;; localObject = com.tencent.mm.model.q.e(paramString, 3))
    {
      AppMethodBeat.o(103304);
      return localObject;
      label110:
      paramString.remove(localObject);
      paramString.add(0, localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.b
 * JD-Core Version:    0.7.0.1
 */