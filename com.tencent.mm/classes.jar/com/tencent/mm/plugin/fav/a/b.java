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
import com.tencent.mm.ak.n;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.gn;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.gt.a;
import com.tencent.mm.g.a.gt.b;
import com.tencent.mm.g.a.nb;
import com.tencent.mm.g.a.re;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.ag.a;
import com.tencent.mm.model.ag.b;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.protocal.protobuf.ahc;
import com.tencent.mm.protocal.protobuf.ahe;
import com.tencent.mm.protocal.protobuf.ahh;
import com.tencent.mm.protocal.protobuf.ahm;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.protocal.protobuf.ahw;
import com.tencent.mm.protocal.protobuf.aia;
import com.tencent.mm.protocal.protobuf.aic;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.protocal.protobuf.bvh;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bj;
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
  private static HashMap<Long, ArrayList<String>> qHY;
  private static long qHZ;
  
  static
  {
    AppMethodBeat.i(103360);
    qHY = new HashMap();
    qHZ = 0L;
    AppMethodBeat.o(103360);
  }
  
  public static boolean Dc(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = a.qHW;
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
    Object localObject = a.qHW;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      if (localObject[i] == paramg.field_type)
      {
        if (paramg.field_favProto != null)
        {
          localObject = paramg.field_favProto.nxC.iterator();
          for (long l1 = 0L;; l1 = ((agx)((Iterator)localObject).next()).EzA + l1)
          {
            l2 = l1;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
          }
        }
        long l2 = 0L;
        paramg.field_datatotalsize = l2;
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.Fav.FavApiLogic", "calFavItemInfoTotalLength id:%d,length:%d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(l2) });
        AppMethodBeat.o(103261);
        return l2;
      }
      i += 1;
    }
    AppMethodBeat.o(103261);
    return 0L;
  }
  
  public static g a(ahn paramahn)
  {
    AppMethodBeat.i(103342);
    g localg = new g();
    localg.field_favProto = new ahn();
    localg.field_type = 18;
    localg.field_favProto = paramahn;
    AppMethodBeat.o(103342);
    return localg;
  }
  
  public static agx a(g paramg, String paramString)
  {
    AppMethodBeat.i(103292);
    if ((bs.isNullOrNil(paramString)) || (paramg == null) || (paramg.field_favProto.nxC.size() == 0))
    {
      AppMethodBeat.o(103292);
      return null;
    }
    paramg = paramg.field_favProto.nxC.iterator();
    while (paramg.hasNext())
    {
      agx localagx = (agx)paramg.next();
      if (localagx.dhw.equals(paramString))
      {
        AppMethodBeat.o(103292);
        return localagx;
      }
    }
    AppMethodBeat.o(103292);
    return null;
  }
  
  public static ahc a(int paramInt, ahn paramahn, aia paramaia)
  {
    AppMethodBeat.i(103262);
    if (paramahn == null)
    {
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.Fav.FavApiLogic", "proto item is null");
      AppMethodBeat.o(103262);
      return null;
    }
    ahc localahc = new ahc();
    aht localaht = paramahn.EBJ;
    if (localaht != null)
    {
      localahc.dng = localaht.dng;
      localahc.EBu = localaht.EBj;
      localahc.appId = localaht.appId;
      localahc.cYF = localaht.cYF;
    }
    if (paramaia != null)
    {
      if (paramaia.EBW != null) {
        localahc.EBv.addAll(paramaia.EBW);
      }
      if (paramaia.EBX != null) {
        localahc.EBv.addAll(paramaia.EBX);
      }
    }
    localahc.dsQ = paramahn;
    localahc.type = paramInt;
    switch (paramInt)
    {
    case 3: 
    case 9: 
    case 13: 
    case 16: 
    case 17: 
    default: 
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.Fav.FavApiLogic", "unknown type %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(103262);
      return localahc;
    case 1: 
      localahc.title = "";
      localahc.desc = paramahn.desc;
      AppMethodBeat.o(103262);
      return localahc;
    case 4: 
      if ((paramahn.nxC != null) && (!paramahn.nxC.isEmpty())) {
        localahc.title = ((agx)paramahn.nxC.get(0)).title;
      }
      AppMethodBeat.o(103262);
      return localahc;
    case 5: 
      if (paramahn.EAK != null)
      {
        localahc.title = paramahn.EAK.title;
        localahc.desc = paramahn.EAK.ECl;
      }
      if ((bs.isNullOrNil(localahc.title)) && (paramahn.nxC != null) && (!paramahn.nxC.isEmpty())) {
        localahc.title = ((agx)paramahn.nxC.get(0)).title;
      }
      if ((bs.isNullOrNil(localahc.desc)) && (localaht != null)) {
        localahc.desc = localaht.link;
      }
      AppMethodBeat.o(103262);
      return localahc;
    case 6: 
      localahc.title = paramahn.iAC;
      if (bs.isNullOrNil(localahc.title)) {
        if (paramahn.EAI != null)
        {
          localahc.title = paramahn.EAI.dry;
          localahc.desc = paramahn.EAI.label;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(103262);
        return localahc;
        if (paramahn.EAI != null) {
          localahc.desc = paramahn.EAI.dry;
        }
      }
    case 2: 
      if ((paramahn.nxC != null) && (paramahn.nxC.size() > 0)) {
        localahc.title = ((agx)paramahn.nxC.get(0)).title;
      }
      AppMethodBeat.o(103262);
      return localahc;
    case 7: 
      if ((paramahn.nxC != null) && (!paramahn.nxC.isEmpty()))
      {
        localahc.title = ((agx)paramahn.nxC.get(0)).title;
        localahc.desc = ((agx)paramahn.nxC.get(0)).desc;
      }
      AppMethodBeat.o(103262);
      return localahc;
    case 8: 
      localahc.title = paramahn.title;
      if ((bs.isNullOrNil(localahc.title)) && (paramahn.nxC != null) && (!paramahn.nxC.isEmpty())) {
        localahc.title = ((agx)paramahn.nxC.get(0)).title;
      }
      AppMethodBeat.o(103262);
      return localahc;
    case 10: 
    case 11: 
      if (paramahn.EAM != null)
      {
        localahc.title = paramahn.EAM.title;
        localahc.desc = paramahn.EAM.desc;
      }
      AppMethodBeat.o(103262);
      return localahc;
    case 12: 
    case 15: 
      if (paramahn.EAO != null)
      {
        localahc.title = paramahn.EAO.title;
        localahc.desc = paramahn.EAO.desc;
      }
      AppMethodBeat.o(103262);
      return localahc;
    }
    paramahn = paramahn.nxC;
    if (paramahn == null)
    {
      AppMethodBeat.o(103262);
      return null;
    }
    paramahn = paramahn.iterator();
    while (paramahn.hasNext())
    {
      paramaia = (agx)paramahn.next();
      if (1 == paramaia.dataType) {
        localahc.title = paramaia.desc;
      }
    }
    AppMethodBeat.o(103262);
    return localahc;
  }
  
  public static String a(agx paramagx)
  {
    AppMethodBeat.i(103283);
    if ((paramagx == null) || (bs.isNullOrNil(paramagx.dhw)))
    {
      AppMethodBeat.o(103283);
      return "";
    }
    paramagx = aco(paramagx.dhw);
    paramagx = com.tencent.mm.vfs.q.B(new com.tencent.mm.vfs.e(acn(paramagx), paramagx).fxV());
    AppMethodBeat.o(103283);
    return paramagx;
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
        com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.Fav.FavApiLogic", "start:%d  end:%d listSize:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramList1.size()) });
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
        com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.Fav.FavApiLogic", "start:%d  end:%d listSize:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramList1.size()) });
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
                LinkedList localLinkedList = localg.field_favProto.nxC;
                j = 1;
                if (j >= localLinkedList.size()) {
                  continue;
                }
                int k = ((agx)localLinkedList.get(j)).dataType;
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
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.Fav.FavApiLogic", "getItemList error, getFavItemInfoStorage null.");
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
  
  public static void a(long paramLong, ahe paramahe, String paramString1, String paramString2, ArrayList<String> paramArrayList, Context paramContext)
  {
    AppMethodBeat.i(103355);
    if ((paramahe == null) || (paramContext == null))
    {
      AppMethodBeat.o(103355);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("KFavLocSigleView", true);
    localIntent.putExtra("map_view_type", 2);
    localIntent.putExtra("kFavInfoLocalId", paramLong);
    localIntent.putExtra("kwebmap_slat", paramahe.lat);
    localIntent.putExtra("kwebmap_lng", paramahe.lng);
    localIntent.putExtra("kPoiName", paramahe.dry);
    localIntent.putExtra("Kwebmap_locaion", paramahe.label);
    if (paramahe.dmN >= 0) {
      localIntent.putExtra("kwebmap_scale", paramahe.dmN);
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
      String str = com.tencent.mm.sdk.platformtools.ai.eUW() + ".plugin.fav";
      paramIntent = paramString;
      if (paramString.startsWith(".")) {
        paramIntent = str + paramString;
      }
      localIntent.setClassName(com.tencent.mm.sdk.platformtools.ai.getPackageName(), paramIntent);
      Class.forName(paramIntent, false, paramContext.getClassLoader());
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).startActivityForResult(localIntent, paramInt, paramBundle);
      }
      AppMethodBeat.o(103350);
      return;
    }
    catch (Exception paramContext)
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.Fav.FavApiLogic", "Class Not Found when startActivity %s", new Object[] { paramContext });
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
      String str = com.tencent.mm.sdk.platformtools.ai.eUW() + ".plugin.fav";
      paramIntent = paramString;
      if (paramString.startsWith(".")) {
        paramIntent = str + paramString;
      }
      localIntent.setClassName(com.tencent.mm.sdk.platformtools.ai.getPackageName(), paramIntent);
      Class.forName(paramIntent, false, paramContext.getClassLoader());
      if ((paramContext instanceof Activity))
      {
        paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramBundle).ba(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.aeD(), "com/tencent/mm/plugin/fav/api/FavApiLogic", "startFavActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
        paramContext.startActivity((Intent)paramString.lR(0), (Bundle)paramString.lR(1));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/fav/api/FavApiLogic", "startFavActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
        AppMethodBeat.o(103348);
        return;
      }
      localIntent.addFlags(268435456);
      paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramBundle).ba(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.aeD(), "com/tencent/mm/plugin/fav/api/FavApiLogic", "startFavActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
      paramContext.startActivity((Intent)paramString.lR(0), (Bundle)paramString.lR(1));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/fav/api/FavApiLogic", "startFavActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
      AppMethodBeat.o(103348);
      return;
    }
    catch (Exception paramContext)
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.Fav.FavApiLogic", "Class Not Found when startActivity %s", new Object[] { paramContext });
      AppMethodBeat.o(103348);
    }
  }
  
  private static void a(gt paramgt)
  {
    AppMethodBeat.i(103268);
    if (bs.isNullOrNil(paramgt.dhx.desc))
    {
      paramgt.dhy.ret = -1;
      AppMethodBeat.o(103268);
      return;
    }
    Object localObject = acv(paramgt.dhx.desc);
    if ((localObject == null) || (((g)localObject).field_localId <= 0L))
    {
      paramgt.dhy.ret = -1;
      AppMethodBeat.o(103268);
      return;
    }
    boolean bool = e((g)localObject);
    String str = paramgt.dhx.dhD;
    if (bool)
    {
      paramgt.dhy.ret = 1;
      paramgt = (ArrayList)qHY.get(Long.valueOf(((g)localObject).field_localId));
      if (paramgt != null)
      {
        if (paramgt.contains(str)) {
          paramgt.remove(str);
        }
        if (paramgt.size() == 0) {
          qHY.remove(Long.valueOf(((g)localObject).field_localId));
        }
      }
      AppMethodBeat.o(103268);
      return;
    }
    if (bs.isNullOrNil(str))
    {
      paramgt.dhy.ret = -1;
      AppMethodBeat.o(103268);
      return;
    }
    long l = ((g)localObject).field_localId;
    ArrayList localArrayList = (ArrayList)qHY.get(Long.valueOf(l));
    localObject = localArrayList;
    if (localArrayList == null) {
      localObject = new ArrayList();
    }
    ((ArrayList)localObject).add(str);
    qHY.put(Long.valueOf(l), localObject);
    localObject = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(l);
    if ((localObject == null) || (((g)localObject).field_localId <= 0L))
    {
      paramgt.dhy.ret = -1;
      AppMethodBeat.o(103268);
      return;
    }
    if ((e((g)localObject)) || (((g)localObject).field_itemStatus == 10))
    {
      paramgt.dhy.ret = -1;
      com.tencent.mm.kernel.g.agU().m(new b.1((g)localObject), 500L);
      AppMethodBeat.o(103268);
      return;
    }
    paramgt.dhy.ret = -1;
    AppMethodBeat.o(103268);
  }
  
  private static void a(c paramc, g paramg)
  {
    AppMethodBeat.i(103295);
    Iterator localIterator = paramg.field_favProto.nxC.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      agx localagx = (agx)localIterator.next();
      if ((localagx.dataType != 1) && (localagx.dataType != 6))
      {
        if (!bs.isNullOrNil(localagx.Ezf)) {
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
          ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().aa(17, paramc.field_favLocalId);
          ((af)com.tencent.mm.kernel.g.ad(af.class)).getModService().run();
          AppMethodBeat.o(103295);
          return;
        }
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().aa(9, paramc.field_favLocalId);
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
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.Fav.FavApiLogic", "modeTag, item info is null");
      AppMethodBeat.o(103346);
      return;
    }
    Object localObject1 = new LinkedList();
    Object localObject2 = new bvh();
    ((bvh)localObject2).Fle = 4;
    ((bvh)localObject2).Flf = 0;
    ((LinkedList)localObject1).add(localObject2);
    localObject2 = new LinkedList();
    bvk localbvk = new bvk();
    localbvk.tkJ = "favitem.taglist";
    localbvk.ndI = 1;
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramg.field_tagProto.EBX.size();
    int i = 0;
    while (i < j)
    {
      localStringBuffer.append("<tag>").append(bs.aLw((String)paramg.field_tagProto.EBX.get(i))).append("</tag>");
      i += 1;
    }
    localbvk.wTM = localStringBuffer.toString();
    com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.Fav.FavApiLogic", "do net scene mod tag, id=%d, tag=%s", new Object[] { Integer.valueOf(paramg.field_id), localbvk.wTM });
    ((LinkedList)localObject2).add(localbvk);
    if (paramg.field_id > 0)
    {
      localObject1 = new am(paramg.field_id, (LinkedList)localObject1, (LinkedList)localObject2);
      com.tencent.mm.kernel.g.agi().a((n)localObject1, 0);
      h.j(paramg.field_id, j, paramInt);
      AppMethodBeat.o(103346);
      return;
    }
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getEditService().a(paramg.field_localId, (LinkedList)localObject1, (LinkedList)localObject2, paramInt);
    AppMethodBeat.o(103346);
  }
  
  public static void a(g paramg, agx paramagx)
  {
    AppMethodBeat.i(103308);
    if (bs.isNullOrNil(paramagx.dhw))
    {
      AppMethodBeat.o(103308);
      return;
    }
    String str = aco(paramagx.dhw);
    c localc = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().acG(str);
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
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().acE(str);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
      AppMethodBeat.o(103308);
      return;
    }
    localObject = new com.tencent.mm.vfs.e(a(paramagx));
    if ((!bs.isNullOrNil(paramagx.Ezb)) && (!bs.isNullOrNil(paramagx.hhV)) && (!((com.tencent.mm.vfs.e)localObject).exists()))
    {
      a(paramagx, paramg, 1);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().acE(str);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
    }
    AppMethodBeat.o(103308);
  }
  
  public static void a(g paramg, agx paramagx, boolean paramBoolean)
  {
    AppMethodBeat.i(103307);
    if ((paramg == null) || (bs.isNullOrNil(paramagx.dhw)))
    {
      AppMethodBeat.o(103307);
      return;
    }
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "restart cdndata download, favId %d, favLocalId %d, dataId %s", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), paramagx.dhw });
    Object localObject2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().acG(paramagx.dhw);
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
      if ((!bs.isNullOrNil(((c)localObject1).field_cdnUrl)) && (!bs.isNullOrNil(((c)localObject1).field_cdnKey)) && (!bs.isNullOrNil(((c)localObject1).field_dataId)) && (((c)localObject1).field_cdnUrl.equals(paramagx.Ezf)) && (((c)localObject1).field_cdnKey.equals(paramagx.Ezh)))
      {
        localObject2 = localObject1;
        if (((c)localObject1).field_dataId.equals(paramagx.dhw)) {}
      }
      else
      {
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().b((c)localObject1, new String[] { "dataId" });
        localObject2 = null;
      }
    }
    if ((localObject2 != null) && (((c)localObject2).field_type == 1))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "klem data not download completed.");
      ((c)localObject2).field_status = 1;
      ((c)localObject2).field_path = d(paramagx);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a((c)localObject2, new String[] { "dataId" });
      if (paramBoolean)
      {
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().acE(paramagx.dhw);
        if ((!bs.isNullOrNil(paramagx.EAh)) && (paramagx.EAh.equals("WeNoteHtmlFile")))
        {
          paramg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().acG(paramagx.dhw);
          ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().d(paramg);
        }
      }
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
      AppMethodBeat.o(103307);
      return;
    }
    localObject1 = new com.tencent.mm.vfs.e(d(paramagx));
    if ((!bs.isNullOrNil(paramagx.Ezh)) && (!bs.isNullOrNil(paramagx.Ezf)) && (!((com.tencent.mm.vfs.e)localObject1).exists()))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "klem big img not exist, start download.");
      long l = System.currentTimeMillis();
      a(paramagx, paramg, 1, true);
      if (paramBoolean)
      {
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().acE(paramagx.dhw);
        if ((!bs.isNullOrNil(paramagx.EAh)) && (paramagx.EAh.equals("WeNoteHtmlFile")))
        {
          paramg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().acG(paramagx.dhw);
          ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().d(paramg);
        }
      }
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "insert cdn item use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
    AppMethodBeat.o(103307);
  }
  
  public static void a(g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(103286);
    h(paramg);
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavSearchStorage().tJ(paramg.field_localId);
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().A(paramg);
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().tF(paramg.field_localId);
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().w(paramg);
    if (paramBoolean)
    {
      Set localSet = coV();
      localSet.add(paramg.field_id);
      e(localSet);
      coX();
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
      paramg.dcc.dcd = l;
      com.tencent.mm.sdk.b.a.GpY.l(paramg);
    }
    AppMethodBeat.o(103286);
  }
  
  public static void a(agx paramagx, int paramInt, long paramLong)
  {
    AppMethodBeat.i(103329);
    if (bs.isNullOrNil(paramagx.dhw))
    {
      AppMethodBeat.o(103329);
      return;
    }
    if ((bs.isNullOrNil(paramagx.Ezb)) || (bs.isNullOrNil(paramagx.hhV)))
    {
      AppMethodBeat.o(103329);
      return;
    }
    String str = aco(paramagx.dhw);
    c localc = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().acG(str);
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
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().acE(str);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
      AppMethodBeat.o(103329);
      return;
    }
    localObject = new com.tencent.mm.vfs.e(a(paramagx));
    if ((!bs.isNullOrNil(paramagx.Ezb)) && (!bs.isNullOrNil(paramagx.hhV)) && (!((com.tencent.mm.vfs.e)localObject).exists()))
    {
      localObject = new g();
      ((g)localObject).field_localId = paramLong;
      ((g)localObject).field_id = -1;
      ((g)localObject).field_type = paramInt;
      a(paramagx, (g)localObject, 1);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().acE(str);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
    }
    AppMethodBeat.o(103329);
  }
  
  public static void a(agx paramagx, g paramg, int paramInt)
  {
    AppMethodBeat.i(103296);
    if ((paramInt == 1) && ((paramagx.EzL <= 0L) || (bs.isNullOrNil(paramagx.Ezb)) || (bs.isNullOrNil(paramagx.hhV))))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.Fav.FavApiLogic", "insertCdnThumbInfo, type recv, cdndataurl must not be null!");
      AppMethodBeat.o(103296);
      return;
    }
    if ((paramInt == 0) && (bs.isNullOrNil(a(paramagx))))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.Fav.FavApiLogic", "insertCdnThumbInfo, type send, path must not be null!");
      AppMethodBeat.o(103296);
      return;
    }
    String str = aco(paramagx.dhw);
    if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().acG(str) != null)
    {
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.Fav.FavApiLogic", "cdn info exist, id[%s], return", new Object[] { str });
      AppMethodBeat.o(103296);
      return;
    }
    com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.Fav.FavApiLogic", "insert cdn thumb info, fav local id[%d] fav id[%d]", new Object[] { Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
    c localc = new c();
    localc.field_cdnKey = paramagx.Ezb;
    localc.field_cdnUrl = paramagx.hhV;
    localc.field_dataId = str;
    localc.field_favLocalId = paramg.field_localId;
    localc.field_totalLen = ((int)paramagx.EzL);
    localc.field_type = paramInt;
    localc.field_status = 1;
    localc.field_path = a(paramagx);
    localc.field_modifyTime = bs.eWj();
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
  
  public static void a(agx paramagx, g paramg, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(103297);
    if ((paramInt == 1) && ((bs.isNullOrNil(paramagx.Ezh)) || (bs.isNullOrNil(paramagx.Ezf))))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo, type recv, cdndataurl must not be null!");
      AppMethodBeat.o(103297);
      return;
    }
    if ((paramInt == 0) && (bs.isNullOrNil(d(paramagx))))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo, type send, path must not be null!");
      AppMethodBeat.o(103297);
      return;
    }
    if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().acG(paramagx.dhw) != null)
    {
      com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.Fav.FavApiLogic", "cdn info exist, id[%s], return", new Object[] { paramagx.dhw });
      AppMethodBeat.o(103297);
      return;
    }
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "insert cdn data info, fav local id[%d] fav id[%d]", new Object[] { Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
    c localc = new c();
    localc.field_dataId = paramagx.dhw;
    localc.field_totalLen = ((int)paramagx.EzA);
    localc.field_type = paramInt;
    localc.field_favLocalId = paramg.field_localId;
    localc.field_cdnKey = paramagx.Ezh;
    localc.field_cdnUrl = paramagx.Ezf;
    localc.field_path = d(paramagx);
    boolean bool;
    int i;
    label405:
    if (paramagx.dataType == 3)
    {
      localc.field_dataType = acq(paramagx.Ezu);
      localc.field_modifyTime = bs.eWj();
      bool = ax.isWifi(com.tencent.mm.sdk.platformtools.ai.getContext());
      if (paramInt == 0)
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "can auto upload, force %B, isWifi %B, dataType %d, totalLen %d", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), Integer.valueOf(localc.field_dataType), Integer.valueOf(localc.field_totalLen) });
        if (!paramBoolean) {
          break label475;
        }
        i = 1;
        label325:
        if (i == 0) {
          break label615;
        }
        localc.field_status = 1;
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo upload status traning");
      }
      label344:
      if (paramInt == 1)
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "can auto download, force %B, isWifi %B, dataType %d, totalLen %d", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), Integer.valueOf(localc.field_dataType), Integer.valueOf(localc.field_totalLen) });
        if (!paramBoolean) {
          break label632;
        }
        i = 1;
        if (i == 0) {
          break label758;
        }
        localc.field_status = 1;
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo download status traning");
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
      localc.field_dataType = paramagx.dataType;
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
      long l2 = com.tencent.mm.sdk.platformtools.ai.getContext().getSharedPreferences(com.tencent.mm.sdk.platformtools.ai.eUX(), 0).getLong("fav_mx_auto_upload_size", 0L);
      long l1 = l2;
      if (l2 == 0L) {
        l1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFileSizeLimit(true);
      }
      if (localc.field_totalLen <= l1)
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "match max auto upload, max size %d", new Object[] { Long.valueOf(l1) });
        i = 1;
        break label325;
      }
      i = 0;
      break label325;
      label615:
      localc.field_status = 4;
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo upload status pause");
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
      l1 = com.tencent.mm.sdk.platformtools.ai.getContext().getSharedPreferences(com.tencent.mm.sdk.platformtools.ai.eUX(), 0).getLong("fav_mx_auto_download_size", ((af)com.tencent.mm.kernel.g.ad(af.class)).getFileSizeLimit(true));
      if (localc.field_totalLen <= l1)
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "match max auto download, max size %d", new Object[] { Long.valueOf(l1) });
        i = 1;
        break label405;
      }
      i = 0;
      break label405;
      label758:
      localc.field_status = 4;
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo download status pause");
    }
    label775:
    b(localc);
    AppMethodBeat.o(103297);
  }
  
  public static void a(String paramString1, Context paramContext, String paramString2)
  {
    AppMethodBeat.i(168687);
    if (bs.isNullOrNil(paramString1))
    {
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.Fav.FavApiLogic", "share image to friend fail, imgPath is null");
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
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.Fav.FavApiLogic", "delete fav item fail, item is null");
      ap.f(paramRunnable);
      AppMethodBeat.o(103287);
      return false;
    }
    if (Looper.myLooper() == com.tencent.mm.kernel.g.agU().GrZ.getLooper())
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "delete favItem id %d, localId %d, needBatchDel %B, do directly", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), Boolean.valueOf(paramBoolean) });
      a(paramg, paramBoolean);
      ap.f(paramRunnable);
      i(paramg);
    }
    for (;;)
    {
      AppMethodBeat.o(103287);
      return true;
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "delete favItem id %d, localId %d, needBatchDel %B, post to worker", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), Boolean.valueOf(paramBoolean) });
      com.tencent.mm.kernel.g.agU().az(new b.2(paramg, paramBoolean, paramRunnable));
    }
  }
  
  public static String[] a(g paramg, com.tencent.mm.sdk.platformtools.ao paramao)
  {
    Object localObject2 = null;
    AppMethodBeat.i(103356);
    if (paramg == null)
    {
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.Fav.FavApiLogic", "GetThumbUrlAndLocalPath favItemInfo is null");
      AppMethodBeat.o(103356);
      return null;
    }
    final agx localagx = c(paramg);
    String[] arrayOfString = new String[2];
    Runnable local3 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(103257);
        b.a(this.qIe, localagx);
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
      if (localagx != null)
      {
        arrayOfString[0] = a(localagx);
        arrayOfString[1] = localagx.dbZ;
        paramao.post(local3);
      }
    case 5: 
    case 10: 
    case 15: 
    case 11: 
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.Fav.FavApiLogic", "GetThumbUrlAndLocalPath thumbPath %s, thumbUrl %s, type %d", new Object[] { arrayOfString[0], arrayOfString[1], Integer.valueOf(paramg.field_type) });
        AppMethodBeat.o(103356);
        return arrayOfString;
        localObject1 = paramg.field_favProto.EAK;
        if (localagx == null)
        {
          if (localObject1 != null) {
            arrayOfString[1] = ((aic)localObject1).thumbUrl;
          }
        }
        else
        {
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = ((aic)localObject1).thumbUrl)
          {
            localObject2 = localObject1;
            if (bs.isNullOrNil((String)localObject1)) {
              localObject2 = localagx.dbZ;
            }
            arrayOfString[0] = a(localagx);
            arrayOfString[1] = localObject2;
            paramao.post(local3);
            break;
          }
          paramao = paramg.field_favProto.EAM;
          if (paramao != null)
          {
            arrayOfString[1] = paramao.thumbUrl;
            continue;
            paramao = paramg.field_favProto.EAO;
            if (paramao != null)
            {
              arrayOfString[1] = paramao.thumbUrl;
              continue;
              paramao = paramg.field_favProto.EAM;
              if (paramao != null) {
                arrayOfString[1] = paramao.thumbUrl;
              }
            }
          }
        }
      }
    }
    if (paramg.field_favProto.nxC != null)
    {
      Iterator localIterator = paramg.field_favProto.nxC.iterator();
      label375:
      localObject1 = localObject2;
      if (localIterator.hasNext())
      {
        localObject1 = (agx)localIterator.next();
        if (((agx)localObject1).dataType != 2) {
          break label435;
        }
        localObject1 = d((agx)localObject1);
        paramao.post(local3);
      }
    }
    for (;;)
    {
      arrayOfString[0] = localObject1;
      arrayOfString[1] = localagx.dbZ;
      break;
      label435:
      if (((agx)localObject1).dataType != 15) {
        break label375;
      }
      localObject1 = a((agx)localObject1);
      paramao.post(local3);
    }
  }
  
  public static String aX(float paramFloat)
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
  
  private static com.tencent.mm.vfs.e acn(String paramString)
  {
    AppMethodBeat.i(103279);
    int i = paramString.hashCode();
    paramString = new com.tencent.mm.vfs.e(String.format("%s%s/%d/", new Object[] { com.tencent.mm.kernel.g.agR().ghC, "favorite", Integer.valueOf(i & 0xFF) }));
    if ((!paramString.exists()) || (!paramString.isDirectory())) {
      paramString.mkdirs();
    }
    AppMethodBeat.o(103279);
    return paramString;
  }
  
  public static String aco(String paramString)
  {
    AppMethodBeat.i(103284);
    paramString = paramString + "_t";
    AppMethodBeat.o(103284);
    return paramString;
  }
  
  public static boolean acp(String paramString)
  {
    AppMethodBeat.i(103291);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(103291);
      return false;
    }
    boolean bool = paramString.endsWith("_t");
    AppMethodBeat.o(103291);
    return bool;
  }
  
  public static int acq(String paramString)
  {
    AppMethodBeat.i(184037);
    if ((!bs.isNullOrNil(paramString)) && (paramString.equals("speex")))
    {
      AppMethodBeat.o(184037);
      return -3;
    }
    if ((!bs.isNullOrNil(paramString)) && (paramString.equals("silk")))
    {
      AppMethodBeat.o(184037);
      return -4;
    }
    AppMethodBeat.o(184037);
    return -2;
  }
  
  public static String acr(String paramString)
  {
    AppMethodBeat.i(103303);
    com.tencent.mm.storage.ai localai = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt(paramString);
    if (localai != null)
    {
      if (!bs.isNullOrNil(localai.field_conRemark))
      {
        paramString = localai.field_conRemark;
        AppMethodBeat.o(103303);
        return paramString;
      }
      if (!bs.isNullOrNil(localai.field_nickname))
      {
        paramString = localai.field_nickname;
        AppMethodBeat.o(103303);
        return paramString;
      }
      paramString = localai.field_username;
      AppMethodBeat.o(103303);
      return paramString;
    }
    AppMethodBeat.o(103303);
    return paramString;
  }
  
  public static String acs(String paramString)
  {
    AppMethodBeat.i(103325);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(103325);
      return null;
    }
    paramString = new com.tencent.mm.vfs.e(coW() + com.tencent.mm.b.g.getMessageDigest(paramString.getBytes()));
    if (paramString.exists())
    {
      paramString = com.tencent.mm.vfs.q.B(paramString.fxV());
      AppMethodBeat.o(103325);
      return paramString;
    }
    AppMethodBeat.o(103325);
    return null;
  }
  
  public static int act(String paramString)
  {
    AppMethodBeat.i(103336);
    if ((!bs.isNullOrNil(paramString)) && (paramString.equals("speex")))
    {
      AppMethodBeat.o(103336);
      return 1;
    }
    if ((!bs.isNullOrNil(paramString)) && (paramString.equals("silk")))
    {
      AppMethodBeat.o(103336);
      return 2;
    }
    AppMethodBeat.o(103336);
    return 0;
  }
  
  public static g acu(String paramString)
  {
    AppMethodBeat.i(103338);
    g localg = new g();
    localg.field_localId = -1L;
    localg.field_id = -1;
    localg.field_xml = paramString;
    localg.field_type = 18;
    localg.acw(paramString);
    AppMethodBeat.o(103338);
    return localg;
  }
  
  private static g acv(String paramString)
  {
    AppMethodBeat.i(103339);
    if ((paramString == null) || (paramString.equals("")))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.Fav.FavApiLogic", "parseSnsNoteInfoXml but xml is null");
      AppMethodBeat.o(103339);
      return null;
    }
    paramString = paramString.replace("cdndataurl", "cdn_dataurl").replace("cdndatakey", "cdn_datakey").replace("cdnthumburl", "cdn_thumburl").replace("cdnthumbkey", "cdn_thumbkey").replace("datasize", "fullsize").replace("thumbsize", "thumbfullsize").replace("sourcename", "datasrcname").replace("sourcetime", "datasrctime").replace("streamlowbandurl", "stream_lowbandurl").replace("streamdataurl", "stream_dataurl").replace("streamweburl", "stream_weburl");
    if (!paramString.startsWith("<noteinfo>")) {
      paramString = "<noteinfo>" + paramString + "</noteinfo>";
    }
    for (;;)
    {
      Map localMap = bv.L(paramString, "noteinfo");
      if (localMap == null)
      {
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.Fav.FavApiLogic", "parseSnsNoteInfoXml, FavItemInfo maps null");
        AppMethodBeat.o(103339);
        return null;
      }
      g localg = new g();
      try
      {
        localg.field_favProto = new ahn();
        localg.field_type = 18;
        Object localObject = (String)localMap.get(".noteinfo.edittime");
        localg.field_favProto.zX(bs.getLong((String)localObject, 0L));
        localObject = new ahh();
        ((ahh)localObject).EBD = ((String)localMap.get(".noteinfo.noteeditor"));
        ((ahh)localObject).EBC = ((String)localMap.get(".noteinfo.noteauthor"));
        localg.field_favProto.a((ahh)localObject);
        localg.field_localId = bs.getLong((String)localMap.get(".noteinfo.favlocalid"), System.currentTimeMillis());
        com.tencent.mm.plugin.fav.a.a.c.a(paramString, localg.field_favProto);
        AppMethodBeat.o(103339);
        return localg;
      }
      catch (Exception paramString)
      {
        com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.Fav.FavApiLogic", paramString, "", new Object[0]);
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.Fav.FavApiLogic", "parseSnsNoteInfoXml , FavItemInfo exception:+%s", new Object[] { paramString.toString() });
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
    paramg = paramg.field_favProto.nxC.iterator();
    agx localagx;
    for (int i = 0; paramg.hasNext(); i = (int)(localagx.EzA + l))
    {
      localagx = (agx)paramg.next();
      l = i;
    }
    long l = i;
    AppMethodBeat.o(103263);
    return l;
  }
  
  public static String b(ahn paramahn)
  {
    AppMethodBeat.i(103358);
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramahn != null) && (paramahn.nxC != null))
    {
      paramahn = paramahn.nxC.iterator();
      while (paramahn.hasNext()) {
        localStringBuilder.append(((agx)paramahn.next()).dhw).append(";");
      }
    }
    paramahn = localStringBuilder.toString();
    AppMethodBeat.o(103358);
    return paramahn;
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
        LinkedList localLinkedList = localg1.field_favProto.nxC;
        if (localg1.field_type != 18) {
          break label374;
        }
        i = 1;
        if (i >= localLinkedList.size()) {
          break;
        }
        agx localagx = (agx)localLinkedList.get(i);
        if (localagx.dataType != paramInt1) {
          break label379;
        }
        g localg2 = localg1.cps();
        localg2.field_type = paramInt2;
        localg2.qIl = true;
        localg2.qIm = localg1;
        localg2.dhm = (localg1.field_localId + "_" + localagx.dhw);
        localg2.qIn = localagx.dhw;
        localg2.field_favProto = com.tencent.mm.plugin.fav.a.a.c.c(localg1.field_favProto);
        localg2.field_favProto.nxC = new LinkedList();
        localg2.field_favProto.nxC.add(localagx);
        localg2.field_favProto.aJA(localagx.title);
        if (localagx.EzZ != null)
        {
          if (paramInt1 == 6) {
            localg2.field_favProto.d(localagx.EzZ.EAI);
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
        localg2.field_favProto.b(localagx.EzZ.EAK);
        continue;
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.Fav.FavApiLogic", "getSearchList() [%s] Exception:%s %s", new Object[] { Integer.valueOf(paramInt1), localException.getClass().getSimpleName(), localException.getMessage() });
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
    AppMethodBeat.i(210498);
    a(paramContext, paramString, paramIntent, null);
    AppMethodBeat.o(210498);
  }
  
  private static void b(gt paramgt)
  {
    AppMethodBeat.i(103341);
    g localg = acv(paramgt.dhx.desc);
    if (localg == null)
    {
      AppMethodBeat.o(103341);
      return;
    }
    if ((localg.field_favProto != null) && (localg.field_favProto.nxC != null))
    {
      Iterator localIterator = localg.field_favProto.nxC.iterator();
      while (localIterator.hasNext())
      {
        agx localagx = (agx)localIterator.next();
        if (localagx.dataType == 20)
        {
          localagx.vz(true);
          localagx.vy(true);
          localagx.aIQ("");
          localagx.aIG("");
          localagx.aIH("");
          localagx.aIE("");
          localagx.aIF("");
        }
      }
    }
    paramgt.dhx.dcm = localg.field_favProto;
    AppMethodBeat.o(103341);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(103293);
    int i = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().y(paramc.field_favLocalId, 0);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus, upload data status:%d, favlocalId:%d", new Object[] { Integer.valueOf(i), Long.valueOf(paramc.field_favLocalId) });
    g localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(paramc.field_favLocalId);
    if (localg == null)
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus iteminfo null");
      AppMethodBeat.o(103293);
      return;
    }
    if (localg.cpr())
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus waiting server upload skip.");
      AppMethodBeat.o(103293);
      return;
    }
    if ((paramc.field_status == 3) && (i != paramc.field_status) && (localg.field_type == 18) && (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().acG(paramc.field_dataId).field_status == 3))
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
      if (localg.cpq()) {
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().aa(15, paramc.field_favLocalId);
      }
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus, continue upload data, favlocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
        AppMethodBeat.o(103293);
        return;
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().aa(4, paramc.field_favLocalId);
      }
      if (localg.cpq()) {
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().aa(16, paramc.field_favLocalId);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.wUl.f(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(localg.field_type), Integer.valueOf(-5), Long.valueOf(b(localg)), Long.valueOf(h.tA(localg.field_localId)) });
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus, error, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
        AppMethodBeat.o(103293);
        return;
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().aa(6, paramc.field_favLocalId);
      }
      AppMethodBeat.o(103293);
      return;
      if (localg.field_type == 18)
      {
        a(paramc, localg);
        AppMethodBeat.o(103293);
        return;
      }
      if (localg.cpq())
      {
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().aa(17, paramc.field_favLocalId);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus start mod faviteminfo, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getModService().run();
        AppMethodBeat.o(103293);
        return;
      }
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().aa(9, paramc.field_favLocalId);
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus start send faviteminfo, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getSendService().run();
      AppMethodBeat.o(103293);
      return;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().aa(6, paramc.field_favLocalId);
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus pause, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
    }
  }
  
  private static void b(g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(103343);
    ahh localahh = new ahh();
    if (!paramBoolean) {
      localahh.EBC = com.tencent.mm.model.u.axw();
    }
    localahh.EBD = com.tencent.mm.model.u.axw();
    paramg.field_favProto.zX(bs.aNx());
    paramg.field_favProto.a(localahh);
    AppMethodBeat.o(103343);
  }
  
  public static void b(agx paramagx, int paramInt, long paramLong)
  {
    AppMethodBeat.i(103330);
    if (bs.isNullOrNil(paramagx.dhw))
    {
      AppMethodBeat.o(103330);
      return;
    }
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "restart cdndata download, dataId %s", new Object[] { paramagx.dhw });
    c localc = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().acG(paramagx.dhw);
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
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "klem data not download completed.");
      ((c)localObject).field_status = 1;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a((c)localObject, new String[] { "dataId" });
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().acE(paramagx.dhw);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
      AppMethodBeat.o(103330);
      return;
    }
    localObject = new com.tencent.mm.vfs.e(d(paramagx));
    if ((!bs.isNullOrNil(paramagx.Ezh)) && (!bs.isNullOrNil(paramagx.Ezf)) && (!((com.tencent.mm.vfs.e)localObject).exists()))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "klem big img not exist, start download.");
      long l = System.currentTimeMillis();
      localObject = new g();
      ((g)localObject).field_localId = paramLong;
      ((g)localObject).field_id = -1;
      ((g)localObject).field_type = paramInt;
      a(paramagx, (g)localObject, 1, true);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().acE(paramagx.dhw);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "insert cdn item use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
    AppMethodBeat.o(103330);
  }
  
  public static void b(String paramString, Context paramContext)
  {
    AppMethodBeat.i(103352);
    if (bs.isNullOrNil(paramString))
    {
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.Fav.FavApiLogic", "share image to timeline fail, filePath is null");
      AppMethodBeat.o(103352);
      return;
    }
    Intent localIntent = new Intent();
    String str1 = "fav_" + com.tencent.mm.model.u.axw() + "_0";
    String str2 = y.xJ(str1);
    y.ayq().F(str2, true).l("prePublishId", str1);
    localIntent.putExtra("reportSessionId", str2);
    localIntent.putExtra("Ksnsupload_type", 0);
    localIntent.putExtra("sns_kemdia_path", paramString);
    d.b(paramContext, "sns", ".ui.SnsUploadUI", localIntent);
    AppMethodBeat.o(103352);
  }
  
  public static boolean b(long paramLong, Runnable paramRunnable)
  {
    AppMethodBeat.i(103331);
    boolean bool = a(((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(paramLong), true, paramRunnable);
    AppMethodBeat.o(103331);
    return bool;
  }
  
  public static agx c(g paramg)
  {
    AppMethodBeat.i(103264);
    if (paramg == null)
    {
      paramg = new agx();
      AppMethodBeat.o(103264);
      return paramg;
    }
    if (paramg.field_favProto.nxC.size() == 0)
    {
      paramg = new agx();
      AppMethodBeat.o(103264);
      return paramg;
    }
    paramg = (agx)paramg.field_favProto.nxC.get(0);
    AppMethodBeat.o(103264);
    return paramg;
  }
  
  public static String c(agx paramagx)
  {
    AppMethodBeat.i(103258);
    agy localagy = paramagx.EzZ;
    String str = "";
    switch (paramagx.dataType)
    {
    case 2: 
    case 3: 
    case 7: 
    case 9: 
    default: 
      paramagx = fY(fY("", localagy.title), localagy.desc);
    }
    for (;;)
    {
      AppMethodBeat.o(103258);
      return paramagx;
      paramagx = fY("", paramagx.desc);
      continue;
      paramagx = str;
      if (localagy.EAO != null)
      {
        paramagx = fY("", localagy.EAO.title);
        continue;
        paramagx = str;
        if (localagy.EAK != null)
        {
          paramagx = fY("", localagy.EAK.title);
          continue;
          str = fY("", localagy.iAC);
          paramagx = str;
          if (localagy.EAI != null)
          {
            paramagx = fY(fY(str, localagy.EAI.dry), localagy.EAI.label);
            continue;
            paramagx = str;
            if (localagy.EAM != null)
            {
              paramagx = fY(fY("", localagy.EAM.title), localagy.EAM.desc);
              continue;
              paramagx = fY("", localagy.title);
            }
          }
        }
      }
    }
  }
  
  public static void c(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(103340);
    g localg = acv(paramString1);
    if (localg == null)
    {
      AppMethodBeat.o(103340);
      return;
    }
    nb localnb = new nb();
    localnb.dpw.type = 2;
    localnb.dpw.field_localId = -1L;
    localnb.dpw.context = paramContext;
    localnb.dpw.dpF = 4;
    localnb.dpw.dpG = true;
    paramContext = new Bundle();
    paramContext.putString("noteauthor", localg.field_favProto.DKz.EBC);
    paramContext.putString("noteeditor", localg.field_favProto.DKz.EBD);
    paramContext.putLong("edittime", localg.field_favProto.pmI);
    paramContext.putString("notexml", g.t(localg));
    paramContext.putString("snslocalid", paramString2);
    paramContext.putString("snsthumbpath", paramString3);
    paramContext.putString("snsnotelinkxml", paramString1);
    localnb.dpw.dpD = paramContext;
    localnb.dpw.field_favProto = localg.field_favProto;
    com.tencent.mm.sdk.b.a.GpY.l(localnb);
    AppMethodBeat.o(103340);
  }
  
  public static void c(gt paramgt)
  {
    AppMethodBeat.i(103345);
    Object localObject2;
    Object localObject3;
    if (paramgt.dhx.dhE == 1)
    {
      paramgt.dhy.path = ts(paramgt.dhx.dcg);
      localObject2 = paramgt.dhy;
      long l = paramgt.dhx.dcg;
      localObject3 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(l);
      if ((localObject3 == null) || (((g)localObject3).field_favProto == null)) {
        paramgt = "";
      }
      for (;;)
      {
        label86:
        ((gt.b)localObject2).thumbPath = paramgt;
        AppMethodBeat.o(103345);
        return;
        if ((((g)localObject3).field_type != 18) || (((g)localObject3).field_favProto.nxC.size() > 1))
        {
          paramgt = ((g)localObject3).field_favProto.nxC.iterator();
          for (;;)
          {
            if (paramgt.hasNext())
            {
              agx localagx = (agx)paramgt.next();
              switch (localagx.dataType)
              {
              default: 
                break;
              case 2: 
                localObject1 = a(localagx);
                paramgt = (gt)localObject1;
                if (i.eA((String)localObject1)) {
                  break label86;
                }
                paramgt = d(localagx);
                if (i.eA(paramgt))
                {
                  com.tencent.mm.sdk.platformtools.f.c(paramgt, 150, 150, Bitmap.CompressFormat.JPEG, 90, (String)localObject1);
                  paramgt = a(localagx);
                  break label86;
                }
                if (localagx.Eza)
                {
                  a((g)localObject3, localagx);
                  paramgt = (gt)localObject1;
                  break label86;
                }
                if (localagx.Ezg)
                {
                  a((g)localObject3, localagx, true);
                  break label86;
                }
                paramgt = "";
                break label86;
              }
            }
          }
        }
        paramgt = "";
      }
    }
    if (paramgt.dhx.dhE == 2)
    {
      localObject1 = new g();
      ((g)localObject1).field_type = 2;
      localObject2 = new agx();
      ((agx)localObject2).aIP(cY(localObject2.toString(), 2));
      localObject3 = d((agx)localObject2);
      ((agx)localObject2).aIQ((String)localObject3);
      ((agx)localObject2).XM(2);
      ((g)localObject1).field_favProto.nxC.add(localObject2);
      paramgt.dhy.path = g.t((g)localObject1);
      paramgt.dhy.thumbPath = ((String)localObject3);
      AppMethodBeat.o(103345);
      return;
    }
    if (paramgt.dhx.dhE == 3)
    {
      localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(paramgt.dhx.dcg);
      if (localObject1 != null) {
        paramgt.dhy.path = (com.tencent.mm.model.u.axw() + ";" + ((g)localObject1).field_fromUser + ";" + ((g)localObject1).field_updateTime);
      }
      AppMethodBeat.o(103345);
      return;
    }
    if (paramgt.dhx.dhE == 4)
    {
      b(paramgt);
      AppMethodBeat.o(103345);
      return;
    }
    if (paramgt.dhx.dhE == 5)
    {
      a(paramgt);
      AppMethodBeat.o(103345);
      return;
    }
    if (paramgt.dhx.dhE == 6)
    {
      localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(paramgt.dhx.dcg);
      if (localObject1 == null)
      {
        paramgt.dhy.ret = 0;
        AppMethodBeat.o(103345);
        return;
      }
      paramgt = paramgt.dhy;
      if (((g)localObject1).field_id > 0) {}
      for (int i = 1;; i = 0)
      {
        paramgt.ret = i;
        AppMethodBeat.o(103345);
        return;
      }
    }
    Object localObject1 = new g();
    ((g)localObject1).field_type = 18;
    ((g)localObject1).field_favProto = paramgt.dhx.dcm;
    paramgt.dhy.path = g.t((g)localObject1);
    AppMethodBeat.o(103345);
  }
  
  public static void c(c paramc)
  {
    AppMethodBeat.i(103294);
    if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage() == null)
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, getFavCdnStorage null");
      AppMethodBeat.o(103294);
      return;
    }
    int i = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().y(paramc.field_favLocalId, 1);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, download data status:%d, favlocalId:%d", new Object[] { Integer.valueOf(i), Long.valueOf(paramc.field_favLocalId) });
    if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage() == null)
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus getFavItemInfoStorage null");
      AppMethodBeat.o(103294);
      return;
    }
    g localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(paramc.field_favLocalId);
    if (localg == null)
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus iteminfo null");
      AppMethodBeat.o(103294);
      return;
    }
    if ((localg.cpr()) || (localg.cpo()) || (localg.isUploadFailed()))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, status upload, skip. isWaitServerUpload:%b  isUploadding:%b  isUploadFailed:%b", new Object[] { Boolean.valueOf(localg.cpr()), Boolean.valueOf(localg.cpo()), Boolean.valueOf(localg.isUploadFailed()) });
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
      h.tB(localg.field_localId);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().aa(7, paramc.field_favLocalId);
      AppMethodBeat.o(103294);
      return;
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, error, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
      com.tencent.mm.plugin.report.service.h.wUl.f(10659, new Object[] { Integer.valueOf(1), Integer.valueOf(localg.field_type), Integer.valueOf(-5), Long.valueOf(b(localg)), Long.valueOf(h.tA(localg.field_localId)) });
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().aa(8, paramc.field_favLocalId);
      AppMethodBeat.o(103294);
      return;
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus init, favLocalId:%d, favId:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id) });
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().aa(10, paramc.field_favLocalId);
      AppMethodBeat.o(103294);
      return;
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus finish, favLocalId:%d, favId:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id) });
      com.tencent.mm.plugin.report.service.h.wUl.f(10659, new Object[] { Integer.valueOf(1), Integer.valueOf(localg.field_type), Integer.valueOf(0), Long.valueOf(b(localg)), Long.valueOf(h.tA(localg.field_localId)) });
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().aa(10, paramc.field_favLocalId);
      AppMethodBeat.o(103294);
      return;
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus pause, favLocalId:%d, favId:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id) });
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().aa(8, paramc.field_favLocalId);
    }
  }
  
  public static void c(String paramString, Context paramContext)
  {
    AppMethodBeat.i(103354);
    if (bs.isNullOrNil(paramString))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.Fav.FavApiLogic", "shareTextToFriend content null");
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
  
  public static String cY(String paramString, int paramInt)
  {
    AppMethodBeat.i(103260);
    paramString = com.tencent.mm.b.g.getMessageDigest((paramString + paramInt + System.currentTimeMillis()).getBytes());
    AppMethodBeat.o(103260);
    return paramString;
  }
  
  private static Set<String> coV()
  {
    AppMethodBeat.i(103273);
    Object localObject = (String)com.tencent.mm.kernel.g.agR().agA().get(225282, "");
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "get need del IDs: %s", new Object[] { localObject });
    HashSet localHashSet = new HashSet();
    if (bs.isNullOrNil((String)localObject))
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
  
  public static String coW()
  {
    AppMethodBeat.i(103277);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.agS();
    localObject = com.tencent.mm.kernel.g.agR().ghC + "favorite/web/";
    AppMethodBeat.o(103277);
    return localObject;
  }
  
  public static void coX()
  {
    AppMethodBeat.i(103281);
    Object localObject2 = coV();
    if (((Set)localObject2).size() == 0)
    {
      com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.Fav.FavApiLogic", "doBatchDel no item to delete");
      AppMethodBeat.o(103281);
      return;
    }
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "doBatchDel idList:%s", new Object[] { localObject2.toString() });
    Object localObject1 = new LinkedList();
    localObject2 = ((Set)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      try
      {
        ((LinkedList)localObject1).add(Integer.valueOf(bs.getInt(str, 0)));
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.Fav.FavApiLogic", localException, "", new Object[0]);
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.Fav.FavApiLogic", "doBatchDel parseInt error:%s", new Object[] { localException.getMessage() });
      }
    }
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "doBatchDel after parse, total size %d", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()) });
    if (((LinkedList)localObject1).size() > 0)
    {
      localObject1 = new ah((LinkedList)localObject1);
      com.tencent.mm.kernel.g.agi().a((n)localObject1, 0);
    }
    AppMethodBeat.o(103281);
  }
  
  public static long coY()
  {
    AppMethodBeat.i(103300);
    long l2 = coZ() - cpa();
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 1024L;
    }
    AppMethodBeat.o(103300);
    return l1;
  }
  
  public static long coZ()
  {
    AppMethodBeat.i(103301);
    long l = ((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GGM, Long.valueOf(0L))).longValue();
    AppMethodBeat.o(103301);
    return l;
  }
  
  public static long cpa()
  {
    AppMethodBeat.i(103302);
    long l = ((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GGL, Long.valueOf(0L))).longValue();
    AppMethodBeat.o(103302);
    return l;
  }
  
  public static boolean cpb()
  {
    AppMethodBeat.i(103311);
    if (coZ() == 0L)
    {
      AppMethodBeat.o(103311);
      return false;
    }
    if (coY() < 52428800L)
    {
      AppMethodBeat.o(103311);
      return true;
    }
    AppMethodBeat.o(103311);
    return false;
  }
  
  public static String cpc()
  {
    AppMethodBeat.i(103317);
    String str = com.tencent.mm.kernel.g.agR().ghC + "favorite/music/";
    AppMethodBeat.o(103317);
    return str;
  }
  
  public static String cpd()
  {
    AppMethodBeat.i(103320);
    String str = com.tencent.mm.kernel.g.agR().ghC + "favorite/";
    AppMethodBeat.o(103320);
    return str;
  }
  
  public static String cpe()
  {
    AppMethodBeat.i(103321);
    String str = com.tencent.mm.kernel.g.agR().ghC + "favorite/voice/";
    AppMethodBeat.o(103321);
    return str;
  }
  
  public static boolean cpf()
  {
    AppMethodBeat.i(103328);
    if (ai.cpT() > 0)
    {
      AppMethodBeat.o(103328);
      return true;
    }
    AppMethodBeat.o(103328);
    return false;
  }
  
  public static boolean cpg()
  {
    AppMethodBeat.i(103337);
    if (coZ() == 0L)
    {
      AppMethodBeat.o(103337);
      return false;
    }
    if (coY() < 10485760L)
    {
      AppMethodBeat.o(103337);
      return true;
    }
    AppMethodBeat.o(103337);
    return false;
  }
  
  public static boolean cph()
  {
    AppMethodBeat.i(168688);
    if ((((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pUX, 0) != 1) && (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pVK, 0) == 1))
    {
      AppMethodBeat.o(168688);
      return true;
    }
    AppMethodBeat.o(168688);
    return false;
  }
  
  public static String d(agx paramagx)
  {
    AppMethodBeat.i(103278);
    if (paramagx == null)
    {
      AppMethodBeat.o(103278);
      return "";
    }
    Object localObject2 = paramagx.dhw;
    if ((bs.isNullOrNil((String)localObject2)) || (!com.tencent.mm.kernel.g.agM()))
    {
      AppMethodBeat.o(103278);
      return "";
    }
    com.tencent.mm.vfs.e locale2 = acn((String)localObject2);
    int j = 0;
    int i = j;
    com.tencent.mm.vfs.e locale1 = locale2;
    Object localObject1 = localObject2;
    if (paramagx.dataType == 8)
    {
      i = j;
      locale1 = locale2;
      localObject1 = localObject2;
      if (!bs.isNullOrNil(paramagx.title))
      {
        localObject1 = paramagx.title;
        locale1 = acn(paramagx.dhw);
        i = 1;
      }
    }
    localObject2 = localObject1;
    if (paramagx.Ezu != null)
    {
      localObject2 = localObject1;
      if (paramagx.Ezu.trim().length() > 0)
      {
        localObject2 = localObject1;
        if (i == 0) {
          localObject2 = (String)localObject1 + "." + paramagx.Ezu;
        }
      }
    }
    localObject1 = new com.tencent.mm.vfs.e(locale1, (String)localObject2);
    if ((((com.tencent.mm.vfs.e)localObject1).exists()) || (bs.isNullOrNil(paramagx.Ezw)))
    {
      paramagx = com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject1).fxV());
      AppMethodBeat.o(103278);
      return paramagx;
    }
    localObject2 = com.tencent.mm.b.g.getMessageDigest((paramagx.Ezw + paramagx.dhw).getBytes());
    if (bs.isNullOrNil((String)localObject2))
    {
      paramagx = com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject1).fxV());
      AppMethodBeat.o(103278);
      return paramagx;
    }
    localObject1 = localObject2;
    if (paramagx.Ezu != null)
    {
      localObject1 = localObject2;
      if (paramagx.Ezu.trim().length() > 0) {
        localObject1 = (String)localObject2 + "." + paramagx.Ezu;
      }
    }
    localObject1 = new com.tencent.mm.vfs.e(locale1, (String)localObject1);
    if (((com.tencent.mm.vfs.e)localObject1).exists())
    {
      paramagx = com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject1).fxV());
      AppMethodBeat.o(103278);
      return paramagx;
    }
    localObject2 = paramagx.dhw;
    localObject1 = localObject2;
    if (paramagx.Ezu != null)
    {
      localObject1 = localObject2;
      if (paramagx.Ezu.trim().length() > 0) {
        localObject1 = (String)localObject2 + "." + paramagx.Ezu;
      }
    }
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.Fav.FavApiLogic", "use dataId.fmt, ".concat(String.valueOf(localObject1)));
    paramagx = com.tencent.mm.vfs.q.B(new com.tencent.mm.vfs.e(locale1, (String)localObject1).fxV());
    AppMethodBeat.o(103278);
    return paramagx;
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
        if (!qHY.containsKey(Long.valueOf(paramg.field_localId)))
        {
          AppMethodBeat.o(103269);
          continue;
        }
        if (qHY.get(Long.valueOf(paramg.field_localId)) == null) {
          break label101;
        }
      }
      finally {}
      if (((ArrayList)qHY.get(Long.valueOf(paramg.field_localId))).size() == 0)
      {
        label101:
        AppMethodBeat.o(103269);
      }
      else
      {
        String str = ts(paramg.field_localId);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "checkUpdateSnsNotePostXml, resend favlocal id:%d,xml:%s", new Object[] { Long.valueOf(paramg.field_localId), str });
        re localre = new re();
        localre.duj.duk = ((ArrayList)qHY.get(Long.valueOf(paramg.field_localId)));
        localre.duj.dul = str;
        com.tencent.mm.sdk.b.a.GpY.l(localre);
        qHY.remove(Long.valueOf(paramg.field_localId));
        AppMethodBeat.o(103269);
      }
    }
  }
  
  public static void dj(List<Integer> paramList)
  {
    AppMethodBeat.i(103271);
    if (paramList.size() == 0)
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.Fav.FavApiLogic", "setDeleted list null");
      AppMethodBeat.o(103271);
      return;
    }
    Set localSet = coV();
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "setDeleted before del:%s", new Object[] { localSet.toString() });
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Integer localInteger = (Integer)paramList.next();
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "setDeleted id:%d, ret:%b", new Object[] { localInteger, Boolean.valueOf(localSet.remove(localInteger.toString())) });
    }
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "setDeleted after del:%s", new Object[] { localSet.toString() });
    e(localSet);
    AppMethodBeat.o(103271);
  }
  
  public static boolean dk(List<g> paramList)
  {
    AppMethodBeat.i(103285);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.Fav.FavApiLogic", "delete fav item fail, item is null");
      AppMethodBeat.o(103285);
      return false;
    }
    Set localSet = coV();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      g localg = (g)paramList.next();
      h(localg);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavSearchStorage().tJ(localg.field_localId);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().A(localg);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().tF(localg.field_localId);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().w(localg);
      localSet.add(localg.field_id);
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.Fav.FavApiLogic", "delete id %d", new Object[] { Integer.valueOf(localg.field_id) });
    }
    e(localSet);
    coX();
    AppMethodBeat.o(103285);
    return true;
  }
  
  public static void e(agx paramagx)
  {
    AppMethodBeat.i(103309);
    c localc = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().acG(paramagx.dhw);
    if ((localc != null) && (localc.field_status != 3))
    {
      localc.field_status = 2;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().pauseDownload(paramagx.dhw);
    }
    localc = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().acG(aco(paramagx.dhw));
    if ((localc != null) && (localc.field_status != 3))
    {
      localc.field_status = 2;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().pauseDownload(aco(paramagx.dhw));
    }
    AppMethodBeat.o(103309);
  }
  
  private static void e(Set<String> paramSet)
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
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "set need del IDs: %s", new Object[] { paramSet });
    com.tencent.mm.kernel.g.agR().agA().set(225282, paramSet);
    AppMethodBeat.o(103272);
  }
  
  private static boolean e(g paramg)
  {
    AppMethodBeat.i(103270);
    if (paramg == null)
    {
      AppMethodBeat.o(103270);
      return false;
    }
    paramg = paramg.field_favProto.nxC.iterator();
    agx localagx;
    do
    {
      if (!paramg.hasNext()) {
        break;
      }
      localagx = (agx)paramg.next();
    } while (((localagx.dataType != 8) && (localagx.dataType != 4) && (localagx.dataType != 2) && (localagx.dataType != 3)) || ((!bs.isNullOrNil(localagx.Ezf)) && (!bs.isNullOrNil(localagx.Ezh))));
    for (boolean bool = false;; bool = true)
    {
      AppMethodBeat.o(103270);
      return bool;
    }
  }
  
  public static void eJ(Context paramContext)
  {
    AppMethodBeat.i(200801);
    if (0L >= qHZ)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "addTagWhenAddToFav,try to add tag ,but favLocalId is null, return");
      AppMethodBeat.o(200801);
      return;
    }
    g localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(qHZ);
    qHZ = 0L;
    if (localg == null)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "addTagWhenAddToFav,try to add tag ,but iteminfo is null, return");
      AppMethodBeat.o(200801);
      return;
    }
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "addTagWhenAddToFav ,go on");
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = com.tencent.mm.sdk.platformtools.ai.getContext();
    }
    paramContext = new Intent();
    paramContext.putExtra("key_fav_scene", 5);
    paramContext.putExtra("key_fav_item_id", localg.field_localId);
    a(localContext, ".ui.FavTagEditUI", paramContext, null);
    AppMethodBeat.o(200801);
  }
  
  public static boolean f(g paramg)
  {
    AppMethodBeat.i(103280);
    if (paramg.field_favProto == null)
    {
      AppMethodBeat.o(103280);
      return false;
    }
    paramg = paramg.field_favProto.nxC.iterator();
    while (paramg.hasNext())
    {
      agx localagx = (agx)paramg.next();
      if (localagx.EAn == 2)
      {
        AppMethodBeat.o(103280);
        return true;
      }
      if (localagx.EAn == 1)
      {
        AppMethodBeat.o(103280);
        return true;
      }
    }
    AppMethodBeat.o(103280);
    return false;
  }
  
  public static boolean f(agx paramagx)
  {
    AppMethodBeat.i(103316);
    com.tencent.mm.ay.f localf = com.tencent.mm.ay.a.aGy();
    if ((localf != null) && (localf.hNQ == 6) && (bs.bG(paramagx.dhw, "").equals(localf.hNS)) && (com.tencent.mm.ay.a.aGv()))
    {
      AppMethodBeat.o(103316);
      return true;
    }
    AppMethodBeat.o(103316);
    return false;
  }
  
  private static String fY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(103259);
    if (bs.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(103259);
      return paramString2;
    }
    if (bs.isNullOrNil(paramString2))
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
  
  public static boolean g(agx paramagx)
  {
    AppMethodBeat.i(103326);
    boolean bool = new com.tencent.mm.vfs.e(d(paramagx)).exists();
    AppMethodBeat.o(103326);
    return bool;
  }
  
  public static String getAppName(Context paramContext, String paramString)
  {
    AppMethodBeat.i(103318);
    ag.b localb = ag.a.hnu;
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
    Set localSet = ao.qJQ;
    paramg = paramg.field_favProto.nxC;
    int i = 0;
    while (i < paramg.size())
    {
      Object localObject = a((agx)paramg.get(i));
      if ((localSet == null) || (!localSet.contains(localObject))) {
        i.deleteFile((String)localObject);
      }
      localObject = d((agx)paramg.get(i));
      if ((localSet == null) || (!localSet.contains(localObject))) {
        i.deleteFile((String)localObject);
      }
      localObject = (agx)paramg.get(i);
      if ((((agx)localObject).EzZ != null) && (((agx)localObject).EzZ.EBa != null)) {
        com.tencent.mm.modelvideo.u.Ei(((agx)localObject).dhw);
      }
      i += 1;
    }
    AppMethodBeat.o(103282);
  }
  
  public static boolean h(agx paramagx)
  {
    AppMethodBeat.i(103327);
    boolean bool = s.aKD(d(paramagx));
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
      if (paramg.field_favProto.EAK != null) {
        str1 = paramg.field_favProto.EAK.ECl;
      }
      String str2 = str1;
      if (paramg.field_favProto.EBJ != null)
      {
        str2 = str1;
        if (bs.isNullOrNil(str1)) {
          str2 = paramg.field_favProto.EBJ.link;
        }
      }
      paramg = new gn();
      paramg.dhb.url = str2;
      com.tencent.mm.sdk.b.a.GpY.l(paramg);
    }
    AppMethodBeat.o(103288);
  }
  
  public static void j(g paramg)
  {
    AppMethodBeat.i(103290);
    j localj = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavSearchStorage().tK(paramg.field_localId);
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
      if (paramg.field_favProto.EBJ != null)
      {
        localObject1 = paramg.field_favProto.EBJ;
        if (!bs.isNullOrNil(((aht)localObject1).dng))
        {
          localStringBuffer.append(((aht)localObject1).dng);
          localObject2 = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt(((aht)localObject1).dng);
          if (localObject2 != null) {
            localStringBuffer.append(((av)localObject2).field_nickname).append(((av)localObject2).field_conRemark);
          }
          localObject2 = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt(((aht)localObject1).toUser);
          if (localObject2 != null) {
            localStringBuffer.append(((av)localObject2).field_nickname).append(((av)localObject2).field_conRemark);
          }
          localStringBuffer.append(((aht)localObject1).EBj);
        }
      }
      Object localObject1 = paramg.field_favProto.nxC;
      localj.field_subtype = 0;
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (agx)((Iterator)localObject1).next();
        if (((agx)localObject2).desc != null) {
          localStringBuffer.append(((agx)localObject2).desc);
        }
        if (((agx)localObject2).title != null) {
          localStringBuffer.append(((agx)localObject2).title);
        }
        int j = ((agx)localObject2).dataType;
        int k = localj.field_subtype;
        localj.field_subtype = (j.Df(j) | k);
      }
      if (paramg.field_favProto.EAK != null)
      {
        if (paramg.field_favProto.EAK.desc != null) {
          localStringBuffer.append(paramg.field_favProto.EAK.desc);
        }
        if (paramg.field_favProto.EAK.title != null) {
          localStringBuffer.append(paramg.field_favProto.EAK.title);
        }
      }
      if (paramg.field_favProto.EAM != null)
      {
        if (paramg.field_favProto.EAM.desc != null) {
          localStringBuffer.append(paramg.field_favProto.EAM.desc);
        }
        if (paramg.field_favProto.EAM.title != null) {
          localStringBuffer.append(paramg.field_favProto.EAM.title);
        }
      }
      if (paramg.field_favProto.EBc != null)
      {
        if (paramg.field_favProto.EBc.nickname != null) {
          localStringBuffer.append(paramg.field_favProto.EBc.nickname);
        }
        if (paramg.field_favProto.EBc.desc != null) {
          localStringBuffer.append(paramg.field_favProto.EBc.desc);
        }
      }
      localj.field_tagContent = "";
      localObject1 = paramg.field_tagProto.EBW.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localj.field_tagContent = (localj.field_tagContent + " " + (String)localObject2);
        localStringBuffer.append((String)localObject2);
      }
      localObject1 = paramg.field_tagProto.EBX.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localj.field_tagContent = (localj.field_tagContent + " " + (String)localObject2);
        localStringBuffer.append((String)localObject2);
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().acB((String)localObject2);
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
    if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(paramg.field_localId) != null)
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
      com.tencent.mm.sdk.platformtools.ac.f("MicroMsg.Fav.FavApiLogic", "restartItemUpload status not upload failed!");
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
      if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().tC(paramg.field_localId).size() == 0)
      {
        paramg.field_itemStatus = 9;
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
        paramg = new ag(paramg);
        com.tencent.mm.kernel.g.agi().a(paramg, 0);
        AppMethodBeat.o(103305);
        return;
      }
      paramg.field_itemStatus = 4;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().y(paramg);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
      Iterator localIterator = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().tC(paramg.field_localId).iterator();
      c localc;
      while (localIterator.hasNext())
      {
        localc = (c)localIterator.next();
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "force upload favItem[last failed], favid:%d localId:%d, dataId:%s, dataType:%d totalLength %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), localc.field_dataId, Integer.valueOf(localc.field_dataType), Integer.valueOf(localc.field_totalLen) });
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().acE(localc.field_dataId);
      }
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
      AppMethodBeat.o(103305);
      return;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().aa(12, paramg.field_localId);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getSendService().run();
      AppMethodBeat.o(103305);
      return;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().aa(15, paramg.field_localId);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().y(paramg);
      localIterator = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().tC(paramg.field_localId).iterator();
      while (localIterator.hasNext())
      {
        localc = (c)localIterator.next();
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "force upload favItem[last mod failed], favid:%d localId:%d, dataId:%s, dataType:%d totalLength %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), localc.field_dataId, Integer.valueOf(localc.field_dataType), Integer.valueOf(localc.field_totalLen) });
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().acE(localc.field_dataId);
      }
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
      AppMethodBeat.o(103305);
      return;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().aa(17, paramg.field_localId);
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
      Object localObject = paramg.field_favProto.nxC;
      if (((List)localObject).size() == 0)
      {
        AppMethodBeat.o(103306);
        return;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        agx localagx = (agx)((Iterator)localObject).next();
        a(paramg, localagx, true);
        a(paramg, localagx);
      }
      AppMethodBeat.o(103306);
      return;
    }
    com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.Fav.FavApiLogic", "status not download failed or done!");
    AppMethodBeat.o(103306);
  }
  
  public static void n(g paramg)
  {
    AppMethodBeat.i(103310);
    if (!paramg.cpo())
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, not uploading");
      AppMethodBeat.o(103310);
      return;
    }
    com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, itemStatu:%d", new Object[] { Integer.valueOf(paramg.field_itemStatus) });
    Iterator localIterator = paramg.field_favProto.nxC.iterator();
    while (localIterator.hasNext())
    {
      agx localagx = (agx)localIterator.next();
      c localc = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().acG(localagx.dhw);
      if ((localc != null) && (localc.field_status != 3))
      {
        localc.field_status = 2;
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().acF(localagx.dhw);
      }
      localc = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().acG(aco(localagx.dhw));
      if ((localc != null) && (localc.field_status != 3))
      {
        localc.field_status = 2;
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().acF(aco(localagx.dhw));
      }
    }
    paramg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(paramg.field_localId);
    com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, after pause data itemStatu:%d", new Object[] { Integer.valueOf(paramg.field_itemStatus) });
    switch (paramg.field_itemStatus)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(103310);
      return;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().aa(3, paramg.field_localId);
      com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(3) });
      AppMethodBeat.o(103310);
      return;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().aa(6, paramg.field_localId);
      com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(6) });
      AppMethodBeat.o(103310);
      return;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().aa(11, paramg.field_localId);
      com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(11) });
      AppMethodBeat.o(103310);
      return;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().aa(14, paramg.field_localId);
      com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(14) });
      AppMethodBeat.o(103310);
      return;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().aa(16, paramg.field_localId);
      com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(16) });
      AppMethodBeat.o(103310);
      return;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().aa(18, paramg.field_localId);
      com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(18) });
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
    agx localagx = c(paramg);
    if (localagx == null)
    {
      AppMethodBeat.o(103319);
      return false;
    }
    long l = bs.Gn();
    com.tencent.mm.plugin.sight.base.a locala = com.tencent.mm.plugin.sight.base.e.asx(d(localagx));
    int j;
    int i;
    boolean bool;
    if (locala != null)
    {
      j = locala.getVideoDuration();
      i = localagx.duration;
      if ((i <= 0) || (Math.abs(i - j) >= 2))
      {
        localagx.XL(j);
        bool = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "repair video duration[%d TO %d] %b cost time %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool), Long.valueOf(bs.aO(l)) });
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
    j localj = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavSearchStorage().tK(paramg.field_localId);
    if (localj == null)
    {
      localj = new j();
      localj.field_localId = paramg.field_localId;
    }
    for (int i = 1;; i = 0)
    {
      localj.field_tagContent = "";
      Iterator localIterator = paramg.field_tagProto.EBW.iterator();
      String str;
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        localj.field_tagContent = (localj.field_tagContent + " " + str);
      }
      localIterator = paramg.field_tagProto.EBX.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        localj.field_tagContent = (localj.field_tagContent + " " + str);
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().acB(str);
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
    ahh localahh = paramg.field_favProto.DKz;
    if ((localahh != null) && (!bs.isNullOrNil(localahh.EBD)))
    {
      AppMethodBeat.o(103344);
      return;
    }
    if (paramg.field_type == 18)
    {
      if (paramg.field_favProto.EBJ.sourceType != 6) {
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
  
  public static float qw(long paramLong)
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
      paramg = paramg.field_favProto.nxC.iterator();
      l = 0L;
      if (paramg.hasNext())
      {
        localObject = (agx)paramg.next();
        if (localObject == null) {
          break label455;
        }
        l = ((agx)localObject).EzA + l;
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
        if (bs.isNullOrNil(paramg.field_favProto.desc)) {
          break;
        }
        localStringBuffer.append(paramg.field_favProto.desc.getBytes().length);
        break;
        localStringBuffer.append(c(paramg).duration);
        break;
        localObject = "";
        try
        {
          paramg = paramg.field_favProto.EAK.ECl;
          localStringBuffer.append(paramg);
          break;
          if (paramg == null) {
            break;
          }
          paramg = paramg.field_favProto.nxC.iterator();
          int i = 0;
          int m = 0;
          int k = 0;
          int j = 0;
          while (paramg.hasNext())
          {
            localObject = (agx)paramg.next();
            switch (((agx)localObject).dataType)
            {
            case 3: 
            default: 
              i += 1;
              break;
            case 1: 
              if (bs.isNullOrNil(((agx)localObject).desc)) {
                break label452;
              }
              k = ((agx)localObject).desc.getBytes().length + k;
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
    com.tencent.mm.kernel.g.agi().a(localak, 0);
    AppMethodBeat.o(103324);
  }
  
  public static void tq(long paramLong)
  {
    AppMethodBeat.i(103265);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "setUsedCapacity:%d", new Object[] { Long.valueOf(paramLong) });
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GGL, Long.valueOf(paramLong));
    AppMethodBeat.o(103265);
  }
  
  public static void tr(long paramLong)
  {
    AppMethodBeat.i(103266);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "setTotalCapacity:%d", new Object[] { Long.valueOf(paramLong) });
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GGM, Long.valueOf(paramLong));
    AppMethodBeat.o(103266);
  }
  
  private static String ts(long paramLong)
  {
    AppMethodBeat.i(103267);
    StringBuilder localStringBuilder = new StringBuilder();
    g localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(paramLong);
    if ((localg == null) || (localg.field_favProto == null) || (localg.field_favProto.nxC.size() <= 1))
    {
      AppMethodBeat.o(103267);
      return "";
    }
    ahh localahh = localg.field_favProto.DKz;
    String str2 = "";
    String str1 = "";
    if (localahh != null)
    {
      str2 = localahh.EBD;
      str1 = localahh.EBC;
    }
    localStringBuilder.append("<noteinfo>");
    localStringBuilder.append("<noteauthor>").append(str1).append("</noteauthor>");
    localStringBuilder.append("<noteeditor>").append(str2).append("</noteeditor>");
    localStringBuilder.append("<edittime>").append(localg.field_favProto.pmI).append("</edittime>");
    localStringBuilder.append("<editusr>").append(str1).append("</editusr>");
    localStringBuilder.append("<favlocalid>").append(localg.field_localId).append("</favlocalid>");
    localStringBuilder.append(com.tencent.mm.plugin.fav.a.a.a.dl(localg.field_favProto.nxC).replace("cdn_dataurl", "cdndataurl").replace("cdn_datakey", "cdndatakey").replace("cdn_thumburl", "cdnthumburl").replace("cdn_thumbkey", "cdnthumbkey").replace("thumbfullsize", "thumbsize").replace("fullsize", "datasize").replace("datasrcname", "sourcename").replace("datasrctime", "sourcetime").replace("stream_lowbandurl", "streamlowbandurl").replace("stream_dataurl", "streamdataurl").replace("stream_weburl", "streamweburl"));
    localStringBuilder.append("</noteinfo>");
    str1 = localStringBuilder.toString();
    AppMethodBeat.o(103267);
    return str1;
  }
  
  public static void tt(long paramLong)
  {
    AppMethodBeat.i(103274);
    com.tencent.mm.sdk.platformtools.ai.getContext().getSharedPreferences(com.tencent.mm.sdk.platformtools.ai.eUX(), 0).edit().putLong("fav_mx_auto_download_size", paramLong).commit();
    AppMethodBeat.o(103274);
  }
  
  public static void tu(long paramLong)
  {
    AppMethodBeat.i(103275);
    com.tencent.mm.sdk.platformtools.ai.getContext().getSharedPreferences(com.tencent.mm.sdk.platformtools.ai.eUX(), 0).edit().putLong("fav_mx_auto_upload_size", paramLong).commit();
    AppMethodBeat.o(103275);
  }
  
  public static void tv(long paramLong)
  {
    AppMethodBeat.i(103276);
    com.tencent.mm.sdk.platformtools.ai.getContext().getSharedPreferences(com.tencent.mm.sdk.platformtools.ai.eUX(), 0).edit().putLong("fav_mx_file_size", paramLong).commit();
    AppMethodBeat.o(103276);
  }
  
  public static void tw(long paramLong)
  {
    qHZ = paramLong;
  }
  
  public static float tx(long paramLong)
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
  
  public static String ty(long paramLong)
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
  
  public static String wl(String paramString)
  {
    AppMethodBeat.i(103304);
    Object localObject = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt(paramString);
    if (localObject == null)
    {
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.Fav.FavApiLogic", "wtf get contact null, username %s", new Object[] { paramString });
      AppMethodBeat.o(103304);
      return "";
    }
    String str = ((com.tencent.mm.storage.ai)localObject).aaS();
    localObject = str;
    if (com.tencent.mm.model.w.sQ(str))
    {
      paramString = com.tencent.mm.model.q.vZ(paramString);
      localObject = com.tencent.mm.model.u.axw();
      if ((paramString != null) && (!paramString.isEmpty())) {
        break label110;
      }
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.Fav.FavApiLogic", "get members from username error, content empty");
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
  
  public static long x(long paramLong, int paramInt)
  {
    AppMethodBeat.i(103323);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "tryStartBatchGet...");
    long l1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().D(paramLong, paramInt);
    long l2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().B(paramLong, paramInt);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "klem, tryStartBatchGet, batchGetTime:%d, itemTiem:%d, updateTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(paramLong) });
    if (l1 == 0L)
    {
      AppMethodBeat.o(103323);
      return l2;
    }
    Object localObject = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().C(l1, paramInt);
    if (((LinkedList)localObject).size() > 0)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "klem, tryStartBatchGet, batchGetTime:%d, itemTiem:%d, updateTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(paramLong) });
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavApiLogic", "klem, tryStartBatchGet, need batch get idList size:%d", new Object[] { Integer.valueOf(((LinkedList)localObject).size()) });
      localObject = new ai((LinkedList)localObject);
      if (!com.tencent.mm.kernel.g.agi().a((n)localObject, 0))
      {
        com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.Fav.FavApiLogic", "do scene BatchGetFav fail");
        ai.cpS();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.b
 * JD-Core Version:    0.7.0.1
 */