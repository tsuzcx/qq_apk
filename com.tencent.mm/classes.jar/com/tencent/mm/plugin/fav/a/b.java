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
import com.tencent.mm.ay.f;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.cq;
import com.tencent.mm.g.a.gr;
import com.tencent.mm.g.a.gx;
import com.tencent.mm.g.a.gx.a;
import com.tencent.mm.g.a.gx.b;
import com.tencent.mm.g.a.nk;
import com.tencent.mm.g.a.rq;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ai.a;
import com.tencent.mm.model.ai.b;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.ajy;
import com.tencent.mm.protocal.protobuf.akc;
import com.tencent.mm.protocal.protobuf.ake;
import com.tencent.mm.protocal.protobuf.akh;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.protocal.protobuf.akw;
import com.tencent.mm.protocal.protobuf.ala;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.protocal.protobuf.ary;
import com.tencent.mm.protocal.protobuf.caq;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.vfs.k;
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
  private static HashMap<Long, ArrayList<String>> rAm;
  private static long rAn;
  
  static
  {
    AppMethodBeat.i(103360);
    rAm = new HashMap();
    rAn = 0L;
    AppMethodBeat.o(103360);
  }
  
  public static boolean Eh(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = a.rAk;
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
    Object localObject = a.rAk;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      if (localObject[i] == paramg.field_type)
      {
        if (paramg.field_favProto != null)
        {
          localObject = paramg.field_favProto.oeJ.iterator();
          for (long l1 = 0L;; l1 = ((ajx)((Iterator)localObject).next()).GzV + l1)
          {
            l2 = l1;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
          }
        }
        long l2 = 0L;
        paramg.field_datatotalsize = l2;
        ae.d("MicroMsg.Fav.FavApiLogic", "calFavItemInfoTotalLength id:%d,length:%d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(l2) });
        AppMethodBeat.o(103261);
        return l2;
      }
      i += 1;
    }
    AppMethodBeat.o(103261);
    return 0L;
  }
  
  public static g a(akn paramakn)
  {
    AppMethodBeat.i(103342);
    g localg = new g();
    localg.field_favProto = new akn();
    localg.field_type = 18;
    localg.field_favProto = paramakn;
    AppMethodBeat.o(103342);
    return localg;
  }
  
  public static ajx a(g paramg, String paramString)
  {
    AppMethodBeat.i(103292);
    if ((bu.isNullOrNil(paramString)) || (paramg == null) || (paramg.field_favProto.oeJ.size() == 0))
    {
      AppMethodBeat.o(103292);
      return null;
    }
    paramg = paramg.field_favProto.oeJ.iterator();
    while (paramg.hasNext())
    {
      ajx localajx = (ajx)paramg.next();
      if (localajx.dua.equals(paramString))
      {
        AppMethodBeat.o(103292);
        return localajx;
      }
    }
    AppMethodBeat.o(103292);
    return null;
  }
  
  public static akc a(int paramInt, akn paramakn, ala paramala)
  {
    AppMethodBeat.i(103262);
    if (paramakn == null)
    {
      ae.w("MicroMsg.Fav.FavApiLogic", "proto item is null");
      AppMethodBeat.o(103262);
      return null;
    }
    akc localakc = new akc();
    akt localakt = paramakn.GCe;
    if (localakt != null)
    {
      localakc.dzZ = localakt.dzZ;
      localakc.GBP = localakt.GBE;
      localakc.appId = localakt.appId;
      localakc.dkZ = localakt.dkZ;
    }
    if (paramala != null)
    {
      if (paramala.GCr != null) {
        localakc.GBQ.addAll(paramala.GCr);
      }
      if (paramala.GCs != null) {
        localakc.GBQ.addAll(paramala.GCs);
      }
    }
    localakc.dFV = paramakn;
    localakc.type = paramInt;
    switch (paramInt)
    {
    case 3: 
    case 9: 
    case 13: 
    case 16: 
    case 17: 
    default: 
      ae.w("MicroMsg.Fav.FavApiLogic", "unknown type %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(103262);
      return localakc;
    case 1: 
      localakc.title = "";
      localakc.desc = paramakn.desc;
      AppMethodBeat.o(103262);
      return localakc;
    case 4: 
      if ((paramakn.oeJ != null) && (!paramakn.oeJ.isEmpty())) {
        localakc.title = ((ajx)paramakn.oeJ.get(0)).title;
      }
      AppMethodBeat.o(103262);
      return localakc;
    case 5: 
      if (paramakn.GBf != null)
      {
        localakc.title = paramakn.GBf.title;
        localakc.desc = paramakn.GBf.GCG;
      }
      if ((bu.isNullOrNil(localakc.title)) && (paramakn.oeJ != null) && (!paramakn.oeJ.isEmpty())) {
        localakc.title = ((ajx)paramakn.oeJ.get(0)).title;
      }
      if ((bu.isNullOrNil(localakc.desc)) && (localakt != null)) {
        localakc.desc = localakt.link;
      }
      AppMethodBeat.o(103262);
      return localakc;
    case 6: 
      localakc.title = paramakn.iWF;
      if (bu.isNullOrNil(localakc.title)) {
        if (paramakn.GBd != null)
        {
          localakc.title = paramakn.GBd.dEv;
          localakc.desc = paramakn.GBd.label;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(103262);
        return localakc;
        if (paramakn.GBd != null) {
          localakc.desc = paramakn.GBd.dEv;
        }
      }
    case 2: 
      if ((paramakn.oeJ != null) && (paramakn.oeJ.size() > 0)) {
        localakc.title = ((ajx)paramakn.oeJ.get(0)).title;
      }
      AppMethodBeat.o(103262);
      return localakc;
    case 7: 
      if ((paramakn.oeJ != null) && (!paramakn.oeJ.isEmpty()))
      {
        localakc.title = ((ajx)paramakn.oeJ.get(0)).title;
        localakc.desc = ((ajx)paramakn.oeJ.get(0)).desc;
      }
      AppMethodBeat.o(103262);
      return localakc;
    case 8: 
      localakc.title = paramakn.title;
      if ((bu.isNullOrNil(localakc.title)) && (paramakn.oeJ != null) && (!paramakn.oeJ.isEmpty())) {
        localakc.title = ((ajx)paramakn.oeJ.get(0)).title;
      }
      AppMethodBeat.o(103262);
      return localakc;
    case 10: 
    case 11: 
      if (paramakn.GBh != null)
      {
        localakc.title = paramakn.GBh.title;
        localakc.desc = paramakn.GBh.desc;
      }
      AppMethodBeat.o(103262);
      return localakc;
    case 12: 
    case 15: 
      if (paramakn.GBj != null)
      {
        localakc.title = paramakn.GBj.title;
        localakc.desc = paramakn.GBj.desc;
      }
      AppMethodBeat.o(103262);
      return localakc;
    }
    paramakn = paramakn.oeJ;
    if (paramakn == null)
    {
      AppMethodBeat.o(103262);
      return null;
    }
    paramakn = paramakn.iterator();
    while (paramakn.hasNext())
    {
      paramala = (ajx)paramakn.next();
      if (1 == paramala.dataType) {
        localakc.title = paramala.desc;
      }
    }
    AppMethodBeat.o(103262);
    return localakc;
  }
  
  public static String a(ajx paramajx)
  {
    AppMethodBeat.i(103283);
    if ((paramajx == null) || (bu.isNullOrNil(paramajx.dua)))
    {
      AppMethodBeat.o(103283);
      return "";
    }
    paramajx = aha(paramajx.dua);
    paramajx = com.tencent.mm.vfs.w.B(new k(agZ(paramajx), paramajx).fTh());
    AppMethodBeat.o(103283);
    return paramajx;
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
        ae.v("MicroMsg.Fav.FavApiLogic", "start:%d  end:%d listSize:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramList1.size()) });
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
        ae.v("MicroMsg.Fav.FavApiLogic", "start:%d  end:%d listSize:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramList1.size()) });
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
                LinkedList localLinkedList = localg.field_favProto.oeJ;
                j = 1;
                if (j >= localLinkedList.size()) {
                  continue;
                }
                int k = ((ajx)localLinkedList.get(j)).dataType;
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
      ae.e("MicroMsg.Fav.FavApiLogic", "getItemList error, getFavItemInfoStorage null.");
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
  
  public static void a(long paramLong, ake paramake, String paramString1, String paramString2, ArrayList<String> paramArrayList, Context paramContext)
  {
    AppMethodBeat.i(103355);
    if ((paramake == null) || (paramContext == null))
    {
      AppMethodBeat.o(103355);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("KFavLocSigleView", true);
    localIntent.putExtra("map_view_type", 2);
    localIntent.putExtra("kFavInfoLocalId", paramLong);
    localIntent.putExtra("kwebmap_slat", paramake.lat);
    localIntent.putExtra("kwebmap_lng", paramake.lng);
    localIntent.putExtra("kPoiName", paramake.dEv);
    localIntent.putExtra("Kwebmap_locaion", paramake.label);
    if (paramake.dzG >= 0) {
      localIntent.putExtra("kwebmap_scale", paramake.dzG);
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
      String str = com.tencent.mm.sdk.platformtools.ak.fov() + ".plugin.fav";
      paramIntent = paramString;
      if (paramString.startsWith(".")) {
        paramIntent = str + paramString;
      }
      localIntent.setClassName(com.tencent.mm.sdk.platformtools.ak.getPackageName(), paramIntent);
      Class.forName(paramIntent, false, paramContext.getClassLoader());
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).startActivityForResult(localIntent, paramInt, paramBundle);
      }
      AppMethodBeat.o(103350);
      return;
    }
    catch (Exception paramContext)
    {
      ae.e("MicroMsg.Fav.FavApiLogic", "Class Not Found when startActivity %s", new Object[] { paramContext });
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
      String str = com.tencent.mm.sdk.platformtools.ak.fov() + ".plugin.fav";
      paramIntent = paramString;
      if (paramString.startsWith(".")) {
        paramIntent = str + paramString;
      }
      localIntent.setClassName(com.tencent.mm.sdk.platformtools.ak.getPackageName(), paramIntent);
      Class.forName(paramIntent, false, paramContext.getClassLoader());
      if ((paramContext instanceof Activity))
      {
        paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramBundle).bc(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.ahE(), "com/tencent/mm/plugin/fav/api/FavApiLogic", "startFavActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
        paramContext.startActivity((Intent)paramString.mt(0), (Bundle)paramString.mt(1));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/fav/api/FavApiLogic", "startFavActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
        AppMethodBeat.o(103348);
        return;
      }
      localIntent.addFlags(268435456);
      paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramBundle).bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.ahE(), "com/tencent/mm/plugin/fav/api/FavApiLogic", "startFavActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
      paramContext.startActivity((Intent)paramString.mt(0), (Bundle)paramString.mt(1));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/fav/api/FavApiLogic", "startFavActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
      AppMethodBeat.o(103348);
      return;
    }
    catch (Exception paramContext)
    {
      ae.e("MicroMsg.Fav.FavApiLogic", "Class Not Found when startActivity %s", new Object[] { paramContext });
      AppMethodBeat.o(103348);
    }
  }
  
  private static void a(gx paramgx)
  {
    AppMethodBeat.i(103268);
    if (bu.isNullOrNil(paramgx.dub.desc))
    {
      paramgx.duc.ret = -1;
      AppMethodBeat.o(103268);
      return;
    }
    Object localObject = ahh(paramgx.dub.desc);
    if ((localObject == null) || (((g)localObject).field_localId <= 0L))
    {
      paramgx.duc.ret = -1;
      AppMethodBeat.o(103268);
      return;
    }
    boolean bool = e((g)localObject);
    String str = paramgx.dub.duh;
    if (bool)
    {
      paramgx.duc.ret = 1;
      paramgx = (ArrayList)rAm.get(Long.valueOf(((g)localObject).field_localId));
      if (paramgx != null)
      {
        if (paramgx.contains(str)) {
          paramgx.remove(str);
        }
        if (paramgx.size() == 0) {
          rAm.remove(Long.valueOf(((g)localObject).field_localId));
        }
      }
      AppMethodBeat.o(103268);
      return;
    }
    if (bu.isNullOrNil(str))
    {
      paramgx.duc.ret = -1;
      AppMethodBeat.o(103268);
      return;
    }
    long l = ((g)localObject).field_localId;
    ArrayList localArrayList = (ArrayList)rAm.get(Long.valueOf(l));
    localObject = localArrayList;
    if (localArrayList == null) {
      localObject = new ArrayList();
    }
    ((ArrayList)localObject).add(str);
    rAm.put(Long.valueOf(l), localObject);
    localObject = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(l);
    if ((localObject == null) || (((g)localObject).field_localId <= 0L))
    {
      paramgx.duc.ret = -1;
      AppMethodBeat.o(103268);
      return;
    }
    if ((e((g)localObject)) || (((g)localObject).field_itemStatus == 10))
    {
      paramgx.duc.ret = -1;
      com.tencent.mm.kernel.g.ajU().n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103255);
          b.d(this.rAo);
          AppMethodBeat.o(103255);
        }
      }, 500L);
      AppMethodBeat.o(103268);
      return;
    }
    paramgx.duc.ret = -1;
    AppMethodBeat.o(103268);
  }
  
  private static void a(c paramc, g paramg)
  {
    AppMethodBeat.i(103295);
    Iterator localIterator = paramg.field_favProto.oeJ.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      ajx localajx = (ajx)localIterator.next();
      if ((localajx.dataType != 1) && (localajx.dataType != 6))
      {
        if (!bu.isNullOrNil(localajx.GzA)) {
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
          ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ac(17, paramc.field_favLocalId);
          ((af)com.tencent.mm.kernel.g.ad(af.class)).getModService().run();
          AppMethodBeat.o(103295);
          return;
        }
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ac(9, paramc.field_favLocalId);
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
      ae.w("MicroMsg.Fav.FavApiLogic", "modeTag, item info is null");
      AppMethodBeat.o(103346);
      return;
    }
    Object localObject1 = new LinkedList();
    Object localObject2 = new caq();
    ((caq)localObject2).Hon = 4;
    ((caq)localObject2).Hoo = 0;
    ((LinkedList)localObject1).add(localObject2);
    localObject2 = new LinkedList();
    cat localcat = new cat();
    localcat.uum = "favitem.taglist";
    localcat.nJA = 1;
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramg.field_tagProto.GCs.size();
    int i = 0;
    while (i < j)
    {
      localStringBuffer.append("<tag>").append(bu.aSz((String)paramg.field_tagProto.GCs.get(i))).append("</tag>");
      i += 1;
    }
    localcat.yxn = localStringBuffer.toString();
    ae.v("MicroMsg.Fav.FavApiLogic", "do net scene mod tag, id=%d, tag=%s", new Object[] { Integer.valueOf(paramg.field_id), localcat.yxn });
    ((LinkedList)localObject2).add(localcat);
    if (paramg.field_id > 0)
    {
      localObject1 = new am(paramg.field_id, (LinkedList)localObject1, (LinkedList)localObject2);
      com.tencent.mm.kernel.g.ajj().a((n)localObject1, 0);
      h.j(paramg.field_id, j, paramInt);
      AppMethodBeat.o(103346);
      return;
    }
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getEditService().a(paramg.field_localId, (LinkedList)localObject1, (LinkedList)localObject2, paramInt);
    AppMethodBeat.o(103346);
  }
  
  public static void a(g paramg, ajx paramajx)
  {
    AppMethodBeat.i(103308);
    if (bu.isNullOrNil(paramajx.dua))
    {
      AppMethodBeat.o(103308);
      return;
    }
    String str = aha(paramajx.dua);
    c localc = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().ahs(str);
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
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().ahq(str);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
      AppMethodBeat.o(103308);
      return;
    }
    localObject = new k(a(paramajx));
    if ((!bu.isNullOrNil(paramajx.Gzw)) && (!bu.isNullOrNil(paramajx.hCS)) && (!((k)localObject).exists()))
    {
      a(paramajx, paramg, 1);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().ahq(str);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
    }
    AppMethodBeat.o(103308);
  }
  
  public static void a(g paramg, ajx paramajx, boolean paramBoolean)
  {
    AppMethodBeat.i(103307);
    if ((paramg == null) || (bu.isNullOrNil(paramajx.dua)))
    {
      AppMethodBeat.o(103307);
      return;
    }
    ae.i("MicroMsg.Fav.FavApiLogic", "restart cdndata download, favId %d, favLocalId %d, dataId %s", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), paramajx.dua });
    Object localObject2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().ahs(paramajx.dua);
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
      if ((!bu.isNullOrNil(((c)localObject1).field_cdnUrl)) && (!bu.isNullOrNil(((c)localObject1).field_cdnKey)) && (!bu.isNullOrNil(((c)localObject1).field_dataId)) && (((c)localObject1).field_cdnUrl.equals(paramajx.GzA)) && (((c)localObject1).field_cdnKey.equals(paramajx.GzC)))
      {
        localObject2 = localObject1;
        if (((c)localObject1).field_dataId.equals(paramajx.dua)) {}
      }
      else
      {
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().b((c)localObject1, new String[] { "dataId" });
        localObject2 = null;
      }
    }
    if ((localObject2 != null) && (((c)localObject2).field_type == 1))
    {
      ae.i("MicroMsg.Fav.FavApiLogic", "klem data not download completed.");
      ((c)localObject2).field_status = 1;
      ((c)localObject2).field_path = d(paramajx);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a((c)localObject2, new String[] { "dataId" });
      if (paramBoolean)
      {
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().ahq(paramajx.dua);
        if ((!bu.isNullOrNil(paramajx.GAC)) && (paramajx.GAC.equals("WeNoteHtmlFile")))
        {
          paramg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().ahs(paramajx.dua);
          ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().d(paramg);
        }
      }
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
      AppMethodBeat.o(103307);
      return;
    }
    localObject1 = new k(d(paramajx));
    if ((!bu.isNullOrNil(paramajx.GzC)) && (!bu.isNullOrNil(paramajx.GzA)) && (!((k)localObject1).exists()))
    {
      ae.i("MicroMsg.Fav.FavApiLogic", "klem big img not exist, start download.");
      long l = System.currentTimeMillis();
      a(paramajx, paramg, 1, true);
      if (paramBoolean)
      {
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().ahq(paramajx.dua);
        if ((!bu.isNullOrNil(paramajx.GAC)) && (paramajx.GAC.equals("WeNoteHtmlFile")))
        {
          paramg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().ahs(paramajx.dua);
          ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().d(paramg);
        }
      }
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
      ae.i("MicroMsg.Fav.FavApiLogic", "insert cdn item use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
    AppMethodBeat.o(103307);
  }
  
  public static void a(g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(103286);
    h(paramg);
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavSearchStorage().vW(paramg.field_localId);
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().A(paramg);
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().vS(paramg.field_localId);
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().w(paramg);
    if (paramBoolean)
    {
      Set localSet = cwb();
      localSet.add(paramg.field_id);
      i(localSet);
      cwd();
    }
    if (paramg.field_type == 18)
    {
      long l = paramg.field_localId;
      if (l <= 0L)
      {
        AppMethodBeat.o(103286);
        return;
      }
      paramg = new cq();
      paramg.doD.doE = l;
      com.tencent.mm.sdk.b.a.IvT.l(paramg);
    }
    AppMethodBeat.o(103286);
  }
  
  public static void a(ajx paramajx, int paramInt, long paramLong)
  {
    AppMethodBeat.i(103329);
    if (bu.isNullOrNil(paramajx.dua))
    {
      AppMethodBeat.o(103329);
      return;
    }
    if ((bu.isNullOrNil(paramajx.Gzw)) || (bu.isNullOrNil(paramajx.hCS)))
    {
      AppMethodBeat.o(103329);
      return;
    }
    String str = aha(paramajx.dua);
    c localc = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().ahs(str);
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
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().ahq(str);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
      AppMethodBeat.o(103329);
      return;
    }
    localObject = new k(a(paramajx));
    if ((!bu.isNullOrNil(paramajx.Gzw)) && (!bu.isNullOrNil(paramajx.hCS)) && (!((k)localObject).exists()))
    {
      localObject = new g();
      ((g)localObject).field_localId = paramLong;
      ((g)localObject).field_id = -1;
      ((g)localObject).field_type = paramInt;
      a(paramajx, (g)localObject, 1);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().ahq(str);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
    }
    AppMethodBeat.o(103329);
  }
  
  public static void a(ajx paramajx, g paramg, int paramInt)
  {
    AppMethodBeat.i(103296);
    if ((paramInt == 1) && ((paramajx.GAg <= 0L) || (bu.isNullOrNil(paramajx.Gzw)) || (bu.isNullOrNil(paramajx.hCS))))
    {
      ae.e("MicroMsg.Fav.FavApiLogic", "insertCdnThumbInfo, type recv, cdndataurl must not be null!");
      AppMethodBeat.o(103296);
      return;
    }
    if ((paramInt == 0) && (bu.isNullOrNil(a(paramajx))))
    {
      ae.e("MicroMsg.Fav.FavApiLogic", "insertCdnThumbInfo, type send, path must not be null!");
      AppMethodBeat.o(103296);
      return;
    }
    String str = aha(paramajx.dua);
    if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().ahs(str) != null)
    {
      ae.w("MicroMsg.Fav.FavApiLogic", "cdn info exist, id[%s], return", new Object[] { str });
      AppMethodBeat.o(103296);
      return;
    }
    ae.v("MicroMsg.Fav.FavApiLogic", "insert cdn thumb info, fav local id[%d] fav id[%d]", new Object[] { Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
    c localc = new c();
    localc.field_cdnKey = paramajx.Gzw;
    localc.field_cdnUrl = paramajx.hCS;
    localc.field_dataId = str;
    localc.field_favLocalId = paramg.field_localId;
    localc.field_totalLen = ((int)paramajx.GAg);
    localc.field_type = paramInt;
    localc.field_status = 1;
    localc.field_path = a(paramajx);
    localc.field_modifyTime = bu.fpO();
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
  
  public static void a(ajx paramajx, g paramg, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(103297);
    if ((paramInt == 1) && ((bu.isNullOrNil(paramajx.GzC)) || (bu.isNullOrNil(paramajx.GzA))))
    {
      ae.e("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo, type recv, cdndataurl must not be null!");
      AppMethodBeat.o(103297);
      return;
    }
    if ((paramInt == 0) && (bu.isNullOrNil(d(paramajx))))
    {
      ae.e("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo, type send, path must not be null!");
      AppMethodBeat.o(103297);
      return;
    }
    if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().ahs(paramajx.dua) != null)
    {
      ae.v("MicroMsg.Fav.FavApiLogic", "cdn info exist, id[%s], return", new Object[] { paramajx.dua });
      AppMethodBeat.o(103297);
      return;
    }
    ae.i("MicroMsg.Fav.FavApiLogic", "insert cdn data info, fav local id[%d] fav id[%d]", new Object[] { Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
    c localc = new c();
    localc.field_dataId = paramajx.dua;
    localc.field_totalLen = ((int)paramajx.GzV);
    localc.field_type = paramInt;
    localc.field_favLocalId = paramg.field_localId;
    localc.field_cdnKey = paramajx.GzC;
    localc.field_cdnUrl = paramajx.GzA;
    localc.field_path = d(paramajx);
    boolean bool;
    int i;
    label405:
    if (paramajx.dataType == 3)
    {
      localc.field_dataType = ahc(paramajx.GzP);
      localc.field_modifyTime = bu.fpO();
      bool = az.isWifi(com.tencent.mm.sdk.platformtools.ak.getContext());
      if (paramInt == 0)
      {
        ae.i("MicroMsg.Fav.FavApiLogic", "can auto upload, force %B, isWifi %B, dataType %d, totalLen %d", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), Integer.valueOf(localc.field_dataType), Integer.valueOf(localc.field_totalLen) });
        if (!paramBoolean) {
          break label475;
        }
        i = 1;
        label325:
        if (i == 0) {
          break label615;
        }
        localc.field_status = 1;
        ae.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo upload status traning");
      }
      label344:
      if (paramInt == 1)
      {
        ae.i("MicroMsg.Fav.FavApiLogic", "can auto download, force %B, isWifi %B, dataType %d, totalLen %d", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), Integer.valueOf(localc.field_dataType), Integer.valueOf(localc.field_totalLen) });
        if (!paramBoolean) {
          break label632;
        }
        i = 1;
        if (i == 0) {
          break label758;
        }
        localc.field_status = 1;
        ae.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo download status traning");
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
      localc.field_dataType = paramajx.dataType;
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
      long l2 = com.tencent.mm.sdk.platformtools.ak.getContext().getSharedPreferences(com.tencent.mm.sdk.platformtools.ak.fow(), 0).getLong("fav_mx_auto_upload_size", 0L);
      long l1 = l2;
      if (l2 == 0L) {
        l1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFileSizeLimit(true);
      }
      if (localc.field_totalLen <= l1)
      {
        ae.i("MicroMsg.Fav.FavApiLogic", "match max auto upload, max size %d", new Object[] { Long.valueOf(l1) });
        i = 1;
        break label325;
      }
      i = 0;
      break label325;
      label615:
      localc.field_status = 4;
      ae.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo upload status pause");
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
      l1 = com.tencent.mm.sdk.platformtools.ak.getContext().getSharedPreferences(com.tencent.mm.sdk.platformtools.ak.fow(), 0).getLong("fav_mx_auto_download_size", ((af)com.tencent.mm.kernel.g.ad(af.class)).getFileSizeLimit(true));
      if (localc.field_totalLen <= l1)
      {
        ae.i("MicroMsg.Fav.FavApiLogic", "match max auto download, max size %d", new Object[] { Long.valueOf(l1) });
        i = 1;
        break label405;
      }
      i = 0;
      break label405;
      label758:
      localc.field_status = 4;
      ae.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo download status pause");
    }
    label775:
    b(localc);
    AppMethodBeat.o(103297);
  }
  
  public static void a(String paramString1, Context paramContext, String paramString2)
  {
    AppMethodBeat.i(168687);
    if (bu.isNullOrNil(paramString1))
    {
      ae.w("MicroMsg.Fav.FavApiLogic", "share image to friend fail, imgPath is null");
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
      ae.w("MicroMsg.Fav.FavApiLogic", "delete fav item fail, item is null");
      ar.f(paramRunnable);
      AppMethodBeat.o(103287);
      return false;
    }
    if (Looper.myLooper() == com.tencent.mm.kernel.g.ajU().IxZ.getLooper())
    {
      ae.i("MicroMsg.Fav.FavApiLogic", "delete favItem id %d, localId %d, needBatchDel %B, do directly", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), Boolean.valueOf(paramBoolean) });
      a(paramg, paramBoolean);
      ar.f(paramRunnable);
      i(paramg);
    }
    for (;;)
    {
      AppMethodBeat.o(103287);
      return true;
      ae.i("MicroMsg.Fav.FavApiLogic", "delete favItem id %d, localId %d, needBatchDel %B, post to worker", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), Boolean.valueOf(paramBoolean) });
      com.tencent.mm.kernel.g.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103256);
          ae.i("MicroMsg.Fav.FavApiLogic", "delete favItem id %d, localId %d, needBatchDel %B, do on worker thread", new Object[] { Integer.valueOf(this.rAp.field_id), Long.valueOf(this.rAp.field_localId), Boolean.valueOf(paramBoolean) });
          b.a(this.rAp, paramBoolean);
          ar.f(paramRunnable);
          b.s(this.rAp);
          AppMethodBeat.o(103256);
        }
      });
    }
  }
  
  public static String[] a(g paramg, aq paramaq)
  {
    Object localObject2 = null;
    AppMethodBeat.i(103356);
    if (paramg == null)
    {
      ae.w("MicroMsg.Fav.FavApiLogic", "GetThumbUrlAndLocalPath favItemInfo is null");
      AppMethodBeat.o(103356);
      return null;
    }
    final ajx localajx = c(paramg);
    String[] arrayOfString = new String[2];
    Runnable local3 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(103257);
        b.a(this.rAs, localajx);
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
      if (localajx != null)
      {
        arrayOfString[0] = a(localajx);
        arrayOfString[1] = localajx.dox;
        paramaq.post(local3);
      }
    case 5: 
    case 10: 
    case 15: 
    case 11: 
      for (;;)
      {
        ae.d("MicroMsg.Fav.FavApiLogic", "GetThumbUrlAndLocalPath thumbPath %s, thumbUrl %s, type %d", new Object[] { arrayOfString[0], arrayOfString[1], Integer.valueOf(paramg.field_type) });
        AppMethodBeat.o(103356);
        return arrayOfString;
        localObject1 = paramg.field_favProto.GBf;
        if (localajx == null)
        {
          if (localObject1 != null) {
            arrayOfString[1] = ((alc)localObject1).thumbUrl;
          }
        }
        else
        {
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = ((alc)localObject1).thumbUrl)
          {
            localObject2 = localObject1;
            if (bu.isNullOrNil((String)localObject1)) {
              localObject2 = localajx.dox;
            }
            arrayOfString[0] = a(localajx);
            arrayOfString[1] = localObject2;
            paramaq.post(local3);
            break;
          }
          paramaq = paramg.field_favProto.GBh;
          if (paramaq != null)
          {
            arrayOfString[1] = paramaq.thumbUrl;
            continue;
            paramaq = paramg.field_favProto.GBj;
            if (paramaq != null)
            {
              arrayOfString[1] = paramaq.thumbUrl;
              continue;
              paramaq = paramg.field_favProto.GBh;
              if (paramaq != null) {
                arrayOfString[1] = paramaq.thumbUrl;
              }
            }
          }
        }
      }
    }
    if (paramg.field_favProto.oeJ != null)
    {
      Iterator localIterator = paramg.field_favProto.oeJ.iterator();
      label375:
      localObject1 = localObject2;
      if (localIterator.hasNext())
      {
        localObject1 = (ajx)localIterator.next();
        if (((ajx)localObject1).dataType != 2) {
          break label435;
        }
        localObject1 = d((ajx)localObject1);
        paramaq.post(local3);
      }
    }
    for (;;)
    {
      arrayOfString[0] = localObject1;
      arrayOfString[1] = localajx.dox;
      break;
      label435:
      if (((ajx)localObject1).dataType != 15) {
        break label375;
      }
      localObject1 = a((ajx)localObject1);
      paramaq.post(local3);
    }
  }
  
  private static k agZ(String paramString)
  {
    AppMethodBeat.i(103279);
    int i = paramString.hashCode();
    paramString = new k(String.format("%s%s/%d/", new Object[] { com.tencent.mm.kernel.g.ajR().gDT, "favorite", Integer.valueOf(i & 0xFF) }));
    if ((!paramString.exists()) || (!paramString.isDirectory())) {
      paramString.mkdirs();
    }
    AppMethodBeat.o(103279);
    return paramString;
  }
  
  public static String aha(String paramString)
  {
    AppMethodBeat.i(103284);
    paramString = paramString + "_t";
    AppMethodBeat.o(103284);
    return paramString;
  }
  
  public static boolean ahb(String paramString)
  {
    AppMethodBeat.i(103291);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(103291);
      return false;
    }
    boolean bool = paramString.endsWith("_t");
    AppMethodBeat.o(103291);
    return bool;
  }
  
  public static int ahc(String paramString)
  {
    AppMethodBeat.i(184037);
    if ((!bu.isNullOrNil(paramString)) && (paramString.equals("speex")))
    {
      AppMethodBeat.o(184037);
      return -3;
    }
    if ((!bu.isNullOrNil(paramString)) && (paramString.equals("silk")))
    {
      AppMethodBeat.o(184037);
      return -4;
    }
    AppMethodBeat.o(184037);
    return -2;
  }
  
  public static String ahd(String paramString)
  {
    AppMethodBeat.i(103303);
    an localan = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paramString);
    if (localan != null)
    {
      if (!bu.isNullOrNil(localan.field_conRemark))
      {
        paramString = localan.field_conRemark;
        AppMethodBeat.o(103303);
        return paramString;
      }
      if (!bu.isNullOrNil(localan.field_nickname))
      {
        paramString = localan.field_nickname;
        AppMethodBeat.o(103303);
        return paramString;
      }
      paramString = localan.field_username;
      AppMethodBeat.o(103303);
      return paramString;
    }
    AppMethodBeat.o(103303);
    return paramString;
  }
  
  public static String ahe(String paramString)
  {
    AppMethodBeat.i(103325);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(103325);
      return null;
    }
    paramString = new k(cwc() + com.tencent.mm.b.g.getMessageDigest(paramString.getBytes()));
    if (paramString.exists())
    {
      paramString = com.tencent.mm.vfs.w.B(paramString.fTh());
      AppMethodBeat.o(103325);
      return paramString;
    }
    AppMethodBeat.o(103325);
    return null;
  }
  
  public static int ahf(String paramString)
  {
    AppMethodBeat.i(103336);
    if ((!bu.isNullOrNil(paramString)) && (paramString.equals("speex")))
    {
      AppMethodBeat.o(103336);
      return 1;
    }
    if ((!bu.isNullOrNil(paramString)) && (paramString.equals("silk")))
    {
      AppMethodBeat.o(103336);
      return 2;
    }
    AppMethodBeat.o(103336);
    return 0;
  }
  
  public static g ahg(String paramString)
  {
    AppMethodBeat.i(103338);
    g localg = new g();
    localg.field_localId = -1L;
    localg.field_id = -1;
    localg.field_xml = paramString;
    localg.field_type = 18;
    localg.ahi(paramString);
    AppMethodBeat.o(103338);
    return localg;
  }
  
  private static g ahh(String paramString)
  {
    AppMethodBeat.i(103339);
    if ((paramString == null) || (paramString.equals("")))
    {
      ae.e("MicroMsg.Fav.FavApiLogic", "parseSnsNoteInfoXml but xml is null");
      AppMethodBeat.o(103339);
      return null;
    }
    paramString = paramString.replace("cdndataurl", "cdn_dataurl").replace("cdndatakey", "cdn_datakey").replace("cdnthumburl", "cdn_thumburl").replace("cdnthumbkey", "cdn_thumbkey").replace("datasize", "fullsize").replace("thumbsize", "thumbfullsize").replace("sourcename", "datasrcname").replace("sourcetime", "datasrctime").replace("streamlowbandurl", "stream_lowbandurl").replace("streamdataurl", "stream_dataurl").replace("streamweburl", "stream_weburl");
    if (!paramString.startsWith("<noteinfo>")) {
      paramString = "<noteinfo>" + paramString + "</noteinfo>";
    }
    for (;;)
    {
      Map localMap = bx.M(paramString, "noteinfo");
      if (localMap == null)
      {
        ae.e("MicroMsg.Fav.FavApiLogic", "parseSnsNoteInfoXml, FavItemInfo maps null");
        AppMethodBeat.o(103339);
        return null;
      }
      g localg = new g();
      try
      {
        localg.field_favProto = new akn();
        localg.field_type = 18;
        Object localObject = (String)localMap.get(".noteinfo.edittime");
        localg.field_favProto.Dj(bu.getLong((String)localObject, 0L));
        localObject = new akh();
        ((akh)localObject).GBY = ((String)localMap.get(".noteinfo.noteeditor"));
        ((akh)localObject).GBX = ((String)localMap.get(".noteinfo.noteauthor"));
        localg.field_favProto.a((akh)localObject);
        localg.field_localId = bu.getLong((String)localMap.get(".noteinfo.favlocalid"), System.currentTimeMillis());
        com.tencent.mm.plugin.fav.a.a.c.a(paramString, localg.field_favProto);
        AppMethodBeat.o(103339);
        return localg;
      }
      catch (Exception paramString)
      {
        ae.printErrStackTrace("MicroMsg.Fav.FavApiLogic", paramString, "", new Object[0]);
        ae.e("MicroMsg.Fav.FavApiLogic", "parseSnsNoteInfoXml , FavItemInfo exception:+%s", new Object[] { paramString.toString() });
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
    paramg = paramg.field_favProto.oeJ.iterator();
    ajx localajx;
    for (int i = 0; paramg.hasNext(); i = (int)(localajx.GzV + l))
    {
      localajx = (ajx)paramg.next();
      l = i;
    }
    long l = i;
    AppMethodBeat.o(103263);
    return l;
  }
  
  public static String b(akn paramakn)
  {
    AppMethodBeat.i(103358);
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramakn != null) && (paramakn.oeJ != null))
    {
      paramakn = paramakn.oeJ.iterator();
      while (paramakn.hasNext()) {
        localStringBuilder.append(((ajx)paramakn.next()).dua).append(";");
      }
    }
    paramakn = localStringBuilder.toString();
    AppMethodBeat.o(103358);
    return paramakn;
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
        LinkedList localLinkedList = localg1.field_favProto.oeJ;
        if (localg1.field_type != 18) {
          break label374;
        }
        i = 1;
        if (i >= localLinkedList.size()) {
          break;
        }
        ajx localajx = (ajx)localLinkedList.get(i);
        if (localajx.dataType != paramInt1) {
          break label379;
        }
        g localg2 = localg1.cwy();
        localg2.field_type = paramInt2;
        localg2.rAz = true;
        localg2.rAA = localg1;
        localg2.dtQ = (localg1.field_localId + "_" + localajx.dua);
        localg2.rAB = localajx.dua;
        localg2.field_favProto = com.tencent.mm.plugin.fav.a.a.c.c(localg1.field_favProto);
        localg2.field_favProto.oeJ = new LinkedList();
        localg2.field_favProto.oeJ.add(localajx);
        localg2.field_favProto.aQA(localajx.title);
        if (localajx.GAu != null)
        {
          if (paramInt1 == 6) {
            localg2.field_favProto.d(localajx.GAu.GBd);
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
        localg2.field_favProto.b(localajx.GAu.GBf);
        continue;
      }
      catch (Exception localException)
      {
        ae.e("MicroMsg.Fav.FavApiLogic", "getSearchList() [%s] Exception:%s %s", new Object[] { Integer.valueOf(paramInt1), localException.getClass().getSimpleName(), localException.getMessage() });
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
    AppMethodBeat.i(224509);
    a(paramContext, paramString, paramIntent, null);
    AppMethodBeat.o(224509);
  }
  
  private static void b(gx paramgx)
  {
    AppMethodBeat.i(103341);
    g localg = ahh(paramgx.dub.desc);
    if (localg == null)
    {
      AppMethodBeat.o(103341);
      return;
    }
    if ((localg.field_favProto != null) && (localg.field_favProto.oeJ != null))
    {
      Iterator localIterator = localg.field_favProto.oeJ.iterator();
      while (localIterator.hasNext())
      {
        ajx localajx = (ajx)localIterator.next();
        if (localajx.dataType == 20)
        {
          localajx.wt(true);
          localajx.ws(true);
          localajx.aPQ("");
          localajx.aPG("");
          localajx.aPH("");
          localajx.aPE("");
          localajx.aPF("");
        }
      }
    }
    paramgx.dub.doN = localg.field_favProto;
    AppMethodBeat.o(103341);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(103293);
    int i = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().z(paramc.field_favLocalId, 0);
    ae.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus, upload data status:%d, favlocalId:%d", new Object[] { Integer.valueOf(i), Long.valueOf(paramc.field_favLocalId) });
    g localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(paramc.field_favLocalId);
    if (localg == null)
    {
      ae.e("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus iteminfo null");
      AppMethodBeat.o(103293);
      return;
    }
    if (localg.cwx())
    {
      ae.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus waiting server upload skip.");
      AppMethodBeat.o(103293);
      return;
    }
    if ((paramc.field_status == 3) && (i != paramc.field_status) && (localg.field_type == 18) && (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().ahs(paramc.field_dataId).field_status == 3))
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
      if (localg.cww()) {
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ac(15, paramc.field_favLocalId);
      }
      for (;;)
      {
        ae.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus, continue upload data, favlocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
        AppMethodBeat.o(103293);
        return;
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ac(4, paramc.field_favLocalId);
      }
      if (localg.cww()) {
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ac(16, paramc.field_favLocalId);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.g.yxI.f(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(localg.field_type), Integer.valueOf(-5), Long.valueOf(b(localg)), Long.valueOf(h.vN(localg.field_localId)) });
        ae.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus, error, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
        AppMethodBeat.o(103293);
        return;
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ac(6, paramc.field_favLocalId);
      }
      AppMethodBeat.o(103293);
      return;
      if (localg.field_type == 18)
      {
        a(paramc, localg);
        AppMethodBeat.o(103293);
        return;
      }
      if (localg.cww())
      {
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ac(17, paramc.field_favLocalId);
        ae.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus start mod faviteminfo, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getModService().run();
        AppMethodBeat.o(103293);
        return;
      }
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ac(9, paramc.field_favLocalId);
      ae.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus start send faviteminfo, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getSendService().run();
      AppMethodBeat.o(103293);
      return;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ac(6, paramc.field_favLocalId);
      ae.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus pause, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
    }
  }
  
  private static void b(g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(103343);
    akh localakh = new akh();
    if (!paramBoolean) {
      localakh.GBX = v.aAC();
    }
    localakh.GBY = v.aAC();
    paramg.field_favProto.Dj(bu.aRi());
    paramg.field_favProto.a(localakh);
    AppMethodBeat.o(103343);
  }
  
  public static void b(ajx paramajx, int paramInt, long paramLong)
  {
    AppMethodBeat.i(103330);
    if (bu.isNullOrNil(paramajx.dua))
    {
      AppMethodBeat.o(103330);
      return;
    }
    ae.i("MicroMsg.Fav.FavApiLogic", "restart cdndata download, dataId %s", new Object[] { paramajx.dua });
    c localc = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().ahs(paramajx.dua);
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
      ae.i("MicroMsg.Fav.FavApiLogic", "klem data not download completed.");
      ((c)localObject).field_status = 1;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a((c)localObject, new String[] { "dataId" });
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().ahq(paramajx.dua);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
      AppMethodBeat.o(103330);
      return;
    }
    localObject = new k(d(paramajx));
    if ((!bu.isNullOrNil(paramajx.GzC)) && (!bu.isNullOrNil(paramajx.GzA)) && (!((k)localObject).exists()))
    {
      ae.i("MicroMsg.Fav.FavApiLogic", "klem big img not exist, start download.");
      long l = System.currentTimeMillis();
      localObject = new g();
      ((g)localObject).field_localId = paramLong;
      ((g)localObject).field_id = -1;
      ((g)localObject).field_type = paramInt;
      a(paramajx, (g)localObject, 1, true);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().ahq(paramajx.dua);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
      ae.i("MicroMsg.Fav.FavApiLogic", "insert cdn item use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
    AppMethodBeat.o(103330);
  }
  
  public static void b(String paramString, Context paramContext)
  {
    AppMethodBeat.i(103352);
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.Fav.FavApiLogic", "share image to timeline fail, filePath is null");
      AppMethodBeat.o(103352);
      return;
    }
    Intent localIntent = new Intent();
    String str1 = "fav_" + v.aAC() + "_0";
    String str2 = com.tencent.mm.model.z.Br(str1);
    com.tencent.mm.model.z.aBG().F(str2, true).k("prePublishId", str1);
    localIntent.putExtra("reportSessionId", str2);
    localIntent.putExtra("Ksnsupload_type", 0);
    localIntent.putExtra("sns_kemdia_path", paramString);
    d.b(paramContext, "sns", ".ui.SnsUploadUI", localIntent);
    AppMethodBeat.o(103352);
  }
  
  public static boolean b(long paramLong, Runnable paramRunnable)
  {
    AppMethodBeat.i(103331);
    boolean bool = a(((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(paramLong), true, paramRunnable);
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
  
  public static ajx c(g paramg)
  {
    AppMethodBeat.i(103264);
    if (paramg == null)
    {
      paramg = new ajx();
      AppMethodBeat.o(103264);
      return paramg;
    }
    if (paramg.field_favProto.oeJ.size() == 0)
    {
      paramg = new ajx();
      AppMethodBeat.o(103264);
      return paramg;
    }
    paramg = (ajx)paramg.field_favProto.oeJ.get(0);
    AppMethodBeat.o(103264);
    return paramg;
  }
  
  public static String c(ajx paramajx)
  {
    AppMethodBeat.i(103258);
    ajy localajy = paramajx.GAu;
    String str = "";
    switch (paramajx.dataType)
    {
    case 2: 
    case 3: 
    case 7: 
    case 9: 
    default: 
      paramajx = gm(gm("", localajy.title), localajy.desc);
    }
    for (;;)
    {
      AppMethodBeat.o(103258);
      return paramajx;
      paramajx = gm("", paramajx.desc);
      continue;
      paramajx = str;
      if (localajy.GBj != null)
      {
        paramajx = gm("", localajy.GBj.title);
        continue;
        paramajx = str;
        if (localajy.GBf != null)
        {
          paramajx = gm("", localajy.GBf.title);
          continue;
          str = gm("", localajy.iWF);
          paramajx = str;
          if (localajy.GBd != null)
          {
            paramajx = gm(gm(str, localajy.GBd.dEv), localajy.GBd.label);
            continue;
            paramajx = str;
            if (localajy.GBh != null)
            {
              paramajx = gm(gm("", localajy.GBh.title), localajy.GBh.desc);
              continue;
              paramajx = gm("", localajy.title);
            }
          }
        }
      }
    }
  }
  
  public static void c(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(103340);
    g localg = ahh(paramString1);
    if (localg == null)
    {
      AppMethodBeat.o(103340);
      return;
    }
    nk localnk = new nk();
    localnk.dCo.type = 2;
    localnk.dCo.field_localId = -1L;
    localnk.dCo.context = paramContext;
    localnk.dCo.dCx = 4;
    localnk.dCo.dCy = true;
    paramContext = new Bundle();
    paramContext.putString("noteauthor", localg.field_favProto.FId.GBX);
    paramContext.putString("noteeditor", localg.field_favProto.FId.GBY);
    paramContext.putLong("edittime", localg.field_favProto.pWN);
    paramContext.putString("notexml", g.t(localg));
    paramContext.putString("snslocalid", paramString2);
    paramContext.putString("snsthumbpath", paramString3);
    paramContext.putString("snsnotelinkxml", paramString1);
    localnk.dCo.dCv = paramContext;
    localnk.dCo.field_favProto = localg.field_favProto;
    com.tencent.mm.sdk.b.a.IvT.l(localnk);
    AppMethodBeat.o(103340);
  }
  
  public static void c(gx paramgx)
  {
    AppMethodBeat.i(103345);
    Object localObject2;
    Object localObject3;
    if (paramgx.dub.dui == 1)
    {
      paramgx.duc.path = vF(paramgx.dub.doH);
      localObject2 = paramgx.duc;
      long l = paramgx.dub.doH;
      localObject3 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(l);
      if ((localObject3 == null) || (((g)localObject3).field_favProto == null)) {
        paramgx = "";
      }
      for (;;)
      {
        label86:
        ((gx.b)localObject2).thumbPath = paramgx;
        AppMethodBeat.o(103345);
        return;
        if ((((g)localObject3).field_type != 18) || (((g)localObject3).field_favProto.oeJ.size() > 1))
        {
          paramgx = ((g)localObject3).field_favProto.oeJ.iterator();
          for (;;)
          {
            if (paramgx.hasNext())
            {
              ajx localajx = (ajx)paramgx.next();
              switch (localajx.dataType)
              {
              default: 
                break;
              case 2: 
                localObject1 = a(localajx);
                paramgx = (gx)localObject1;
                if (com.tencent.mm.vfs.o.fB((String)localObject1)) {
                  break label86;
                }
                paramgx = d(localajx);
                if (com.tencent.mm.vfs.o.fB(paramgx))
                {
                  com.tencent.mm.sdk.platformtools.h.c(paramgx, 150, 150, Bitmap.CompressFormat.JPEG, 90, (String)localObject1);
                  paramgx = a(localajx);
                  break label86;
                }
                if (localajx.Gzv)
                {
                  a((g)localObject3, localajx);
                  paramgx = (gx)localObject1;
                  break label86;
                }
                if (localajx.GzB)
                {
                  a((g)localObject3, localajx, true);
                  break label86;
                }
                paramgx = "";
                break label86;
              }
            }
          }
        }
        paramgx = "";
      }
    }
    if (paramgx.dub.dui == 2)
    {
      localObject1 = new g();
      ((g)localObject1).field_type = 2;
      localObject2 = new ajx();
      ((ajx)localObject2).aPP(dm(localObject2.toString(), 2));
      localObject3 = d((ajx)localObject2);
      ((ajx)localObject2).aPQ((String)localObject3);
      ((ajx)localObject2).aao(2);
      ((g)localObject1).field_favProto.oeJ.add(localObject2);
      paramgx.duc.path = g.t((g)localObject1);
      paramgx.duc.thumbPath = ((String)localObject3);
      AppMethodBeat.o(103345);
      return;
    }
    if (paramgx.dub.dui == 3)
    {
      localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(paramgx.dub.doH);
      if (localObject1 != null) {
        paramgx.duc.path = (v.aAC() + ";" + ((g)localObject1).field_fromUser + ";" + ((g)localObject1).field_updateTime);
      }
      AppMethodBeat.o(103345);
      return;
    }
    if (paramgx.dub.dui == 4)
    {
      b(paramgx);
      AppMethodBeat.o(103345);
      return;
    }
    if (paramgx.dub.dui == 5)
    {
      a(paramgx);
      AppMethodBeat.o(103345);
      return;
    }
    if (paramgx.dub.dui == 6)
    {
      localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(paramgx.dub.doH);
      if (localObject1 == null)
      {
        paramgx.duc.ret = 0;
        AppMethodBeat.o(103345);
        return;
      }
      paramgx = paramgx.duc;
      if (((g)localObject1).field_id > 0) {}
      for (int i = 1;; i = 0)
      {
        paramgx.ret = i;
        AppMethodBeat.o(103345);
        return;
      }
    }
    Object localObject1 = new g();
    ((g)localObject1).field_type = 18;
    ((g)localObject1).field_favProto = paramgx.dub.doN;
    paramgx.duc.path = g.t((g)localObject1);
    AppMethodBeat.o(103345);
  }
  
  public static void c(c paramc)
  {
    AppMethodBeat.i(103294);
    if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage() == null)
    {
      ae.e("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, getFavCdnStorage null");
      AppMethodBeat.o(103294);
      return;
    }
    int i = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().z(paramc.field_favLocalId, 1);
    ae.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, download data status:%d, favlocalId:%d", new Object[] { Integer.valueOf(i), Long.valueOf(paramc.field_favLocalId) });
    if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage() == null)
    {
      ae.e("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus getFavItemInfoStorage null");
      AppMethodBeat.o(103294);
      return;
    }
    g localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(paramc.field_favLocalId);
    if (localg == null)
    {
      ae.e("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus iteminfo null");
      AppMethodBeat.o(103294);
      return;
    }
    if ((localg.cwx()) || (localg.cwu()) || (localg.isUploadFailed()))
    {
      ae.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, status upload, skip. isWaitServerUpload:%b  isUploadding:%b  isUploadFailed:%b", new Object[] { Boolean.valueOf(localg.cwx()), Boolean.valueOf(localg.cwu()), Boolean.valueOf(localg.isUploadFailed()) });
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
      h.vO(localg.field_localId);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ac(7, paramc.field_favLocalId);
      AppMethodBeat.o(103294);
      return;
      ae.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, error, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
      com.tencent.mm.plugin.report.service.g.yxI.f(10659, new Object[] { Integer.valueOf(1), Integer.valueOf(localg.field_type), Integer.valueOf(-5), Long.valueOf(b(localg)), Long.valueOf(h.vN(localg.field_localId)) });
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ac(8, paramc.field_favLocalId);
      AppMethodBeat.o(103294);
      return;
      ae.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus init, favLocalId:%d, favId:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id) });
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ac(10, paramc.field_favLocalId);
      AppMethodBeat.o(103294);
      return;
      ae.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus finish, favLocalId:%d, favId:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id) });
      com.tencent.mm.plugin.report.service.g.yxI.f(10659, new Object[] { Integer.valueOf(1), Integer.valueOf(localg.field_type), Integer.valueOf(0), Long.valueOf(b(localg)), Long.valueOf(h.vN(localg.field_localId)) });
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ac(10, paramc.field_favLocalId);
      AppMethodBeat.o(103294);
      return;
      ae.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus pause, favLocalId:%d, favId:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id) });
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ac(8, paramc.field_favLocalId);
    }
  }
  
  public static void c(String paramString, Context paramContext)
  {
    AppMethodBeat.i(103354);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.Fav.FavApiLogic", "shareTextToFriend content null");
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
  
  private static Set<String> cwb()
  {
    AppMethodBeat.i(103273);
    Object localObject = (String)com.tencent.mm.kernel.g.ajR().ajA().get(225282, "");
    ae.i("MicroMsg.Fav.FavApiLogic", "get need del IDs: %s", new Object[] { localObject });
    HashSet localHashSet = new HashSet();
    if (bu.isNullOrNil((String)localObject))
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
  
  public static String cwc()
  {
    AppMethodBeat.i(103277);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.ajS();
    localObject = com.tencent.mm.kernel.g.ajR().gDT + "favorite/web/";
    AppMethodBeat.o(103277);
    return localObject;
  }
  
  public static void cwd()
  {
    AppMethodBeat.i(103281);
    Object localObject2 = cwb();
    if (((Set)localObject2).size() == 0)
    {
      ae.v("MicroMsg.Fav.FavApiLogic", "doBatchDel no item to delete");
      AppMethodBeat.o(103281);
      return;
    }
    ae.i("MicroMsg.Fav.FavApiLogic", "doBatchDel idList:%s", new Object[] { localObject2.toString() });
    Object localObject1 = new LinkedList();
    localObject2 = ((Set)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      try
      {
        ((LinkedList)localObject1).add(Integer.valueOf(bu.getInt(str, 0)));
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.Fav.FavApiLogic", localException, "", new Object[0]);
        ae.e("MicroMsg.Fav.FavApiLogic", "doBatchDel parseInt error:%s", new Object[] { localException.getMessage() });
      }
    }
    ae.i("MicroMsg.Fav.FavApiLogic", "doBatchDel after parse, total size %d", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()) });
    if (((LinkedList)localObject1).size() > 0)
    {
      localObject1 = new ah((LinkedList)localObject1);
      com.tencent.mm.kernel.g.ajj().a((n)localObject1, 0);
    }
    AppMethodBeat.o(103281);
  }
  
  public static long cwe()
  {
    AppMethodBeat.i(103300);
    long l2 = cwf() - cwg();
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 1024L;
    }
    AppMethodBeat.o(103300);
    return l1;
  }
  
  public static long cwf()
  {
    AppMethodBeat.i(103301);
    long l = ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.INA, Long.valueOf(0L))).longValue();
    AppMethodBeat.o(103301);
    return l;
  }
  
  public static long cwg()
  {
    AppMethodBeat.i(103302);
    long l = ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.INz, Long.valueOf(0L))).longValue();
    AppMethodBeat.o(103302);
    return l;
  }
  
  public static boolean cwh()
  {
    AppMethodBeat.i(103311);
    if (cwf() == 0L)
    {
      AppMethodBeat.o(103311);
      return false;
    }
    if (cwe() < 52428800L)
    {
      AppMethodBeat.o(103311);
      return true;
    }
    AppMethodBeat.o(103311);
    return false;
  }
  
  public static String cwi()
  {
    AppMethodBeat.i(103317);
    String str = com.tencent.mm.kernel.g.ajR().gDT + "favorite/music/";
    AppMethodBeat.o(103317);
    return str;
  }
  
  public static String cwj()
  {
    AppMethodBeat.i(103320);
    String str = com.tencent.mm.kernel.g.ajR().gDT + "favorite/";
    AppMethodBeat.o(103320);
    return str;
  }
  
  public static String cwk()
  {
    AppMethodBeat.i(103321);
    String str = com.tencent.mm.kernel.g.ajR().gDT + "favorite/voice/";
    AppMethodBeat.o(103321);
    return str;
  }
  
  public static boolean cwl()
  {
    AppMethodBeat.i(103328);
    if (ai.cwZ() > 0)
    {
      AppMethodBeat.o(103328);
      return true;
    }
    AppMethodBeat.o(103328);
    return false;
  }
  
  public static boolean cwm()
  {
    AppMethodBeat.i(103337);
    if (cwf() == 0L)
    {
      AppMethodBeat.o(103337);
      return false;
    }
    if (cwe() < 10485760L)
    {
      AppMethodBeat.o(103337);
      return true;
    }
    AppMethodBeat.o(103337);
    return false;
  }
  
  public static boolean cwn()
  {
    AppMethodBeat.i(168688);
    if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGN, 0) != 1) && (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qHF, 0) == 1))
    {
      AppMethodBeat.o(168688);
      return true;
    }
    AppMethodBeat.o(168688);
    return false;
  }
  
  public static String d(ajx paramajx)
  {
    AppMethodBeat.i(103278);
    if (paramajx == null)
    {
      AppMethodBeat.o(103278);
      return "";
    }
    Object localObject2 = paramajx.dua;
    if ((bu.isNullOrNil((String)localObject2)) || (!com.tencent.mm.kernel.g.ajM()))
    {
      AppMethodBeat.o(103278);
      return "";
    }
    k localk2 = agZ((String)localObject2);
    int j = 0;
    int i = j;
    k localk1 = localk2;
    Object localObject1 = localObject2;
    if (paramajx.dataType == 8)
    {
      i = j;
      localk1 = localk2;
      localObject1 = localObject2;
      if (!bu.isNullOrNil(paramajx.title))
      {
        localObject1 = paramajx.title;
        localk1 = agZ(paramajx.dua);
        i = 1;
      }
    }
    localObject2 = localObject1;
    if (paramajx.GzP != null)
    {
      localObject2 = localObject1;
      if (paramajx.GzP.trim().length() > 0)
      {
        localObject2 = localObject1;
        if (i == 0) {
          localObject2 = (String)localObject1 + "." + paramajx.GzP;
        }
      }
    }
    localObject1 = new k(localk1, (String)localObject2);
    if ((((k)localObject1).exists()) || (bu.isNullOrNil(paramajx.GzR)))
    {
      paramajx = com.tencent.mm.vfs.w.B(((k)localObject1).fTh());
      AppMethodBeat.o(103278);
      return paramajx;
    }
    localObject2 = com.tencent.mm.b.g.getMessageDigest((paramajx.GzR + paramajx.dua).getBytes());
    if (bu.isNullOrNil((String)localObject2))
    {
      paramajx = com.tencent.mm.vfs.w.B(((k)localObject1).fTh());
      AppMethodBeat.o(103278);
      return paramajx;
    }
    localObject1 = localObject2;
    if (paramajx.GzP != null)
    {
      localObject1 = localObject2;
      if (paramajx.GzP.trim().length() > 0) {
        localObject1 = (String)localObject2 + "." + paramajx.GzP;
      }
    }
    localObject1 = new k(localk1, (String)localObject1);
    if (((k)localObject1).exists())
    {
      paramajx = com.tencent.mm.vfs.w.B(((k)localObject1).fTh());
      AppMethodBeat.o(103278);
      return paramajx;
    }
    localObject2 = paramajx.dua;
    localObject1 = localObject2;
    if (paramajx.GzP != null)
    {
      localObject1 = localObject2;
      if (paramajx.GzP.trim().length() > 0) {
        localObject1 = (String)localObject2 + "." + paramajx.GzP;
      }
    }
    ae.d("MicroMsg.Fav.FavApiLogic", "use dataId.fmt, ".concat(String.valueOf(localObject1)));
    paramajx = com.tencent.mm.vfs.w.B(new k(localk1, (String)localObject1).fTh());
    AppMethodBeat.o(103278);
    return paramajx;
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
        if (!rAm.containsKey(Long.valueOf(paramg.field_localId)))
        {
          AppMethodBeat.o(103269);
          continue;
        }
        if (rAm.get(Long.valueOf(paramg.field_localId)) == null) {
          break label101;
        }
      }
      finally {}
      if (((ArrayList)rAm.get(Long.valueOf(paramg.field_localId))).size() == 0)
      {
        label101:
        AppMethodBeat.o(103269);
      }
      else
      {
        String str = vF(paramg.field_localId);
        ae.i("MicroMsg.Fav.FavApiLogic", "checkUpdateSnsNotePostXml, resend favlocal id:%d,xml:%s", new Object[] { Long.valueOf(paramg.field_localId), str });
        rq localrq = new rq();
        localrq.dHp.dHq = ((ArrayList)rAm.get(Long.valueOf(paramg.field_localId)));
        localrq.dHp.dHr = str;
        com.tencent.mm.sdk.b.a.IvT.l(localrq);
        rAm.remove(Long.valueOf(paramg.field_localId));
        AppMethodBeat.o(103269);
      }
    }
  }
  
  public static String dm(String paramString, int paramInt)
  {
    AppMethodBeat.i(103260);
    paramString = com.tencent.mm.b.g.getMessageDigest((paramString + paramInt + System.currentTimeMillis()).getBytes());
    AppMethodBeat.o(103260);
    return paramString;
  }
  
  public static void jdMethod_do(List<Integer> paramList)
  {
    AppMethodBeat.i(103271);
    if (paramList.size() == 0)
    {
      ae.e("MicroMsg.Fav.FavApiLogic", "setDeleted list null");
      AppMethodBeat.o(103271);
      return;
    }
    Set localSet = cwb();
    ae.i("MicroMsg.Fav.FavApiLogic", "setDeleted before del:%s", new Object[] { localSet.toString() });
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Integer localInteger = (Integer)paramList.next();
      ae.i("MicroMsg.Fav.FavApiLogic", "setDeleted id:%d, ret:%b", new Object[] { localInteger, Boolean.valueOf(localSet.remove(localInteger.toString())) });
    }
    ae.i("MicroMsg.Fav.FavApiLogic", "setDeleted after del:%s", new Object[] { localSet.toString() });
    i(localSet);
    AppMethodBeat.o(103271);
  }
  
  public static boolean dp(List<g> paramList)
  {
    AppMethodBeat.i(103285);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ae.w("MicroMsg.Fav.FavApiLogic", "delete fav item fail, item is null");
      AppMethodBeat.o(103285);
      return false;
    }
    Set localSet = cwb();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      g localg = (g)paramList.next();
      h(localg);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavSearchStorage().vW(localg.field_localId);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().A(localg);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().vS(localg.field_localId);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().w(localg);
      localSet.add(localg.field_id);
      ae.d("MicroMsg.Fav.FavApiLogic", "delete id %d", new Object[] { Integer.valueOf(localg.field_id) });
    }
    i(localSet);
    cwd();
    AppMethodBeat.o(103285);
    return true;
  }
  
  public static void e(ajx paramajx)
  {
    AppMethodBeat.i(103309);
    c localc = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().ahs(paramajx.dua);
    if ((localc != null) && (localc.field_status != 3))
    {
      localc.field_status = 2;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().pauseDownload(paramajx.dua);
    }
    localc = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().ahs(aha(paramajx.dua));
    if ((localc != null) && (localc.field_status != 3))
    {
      localc.field_status = 2;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().pauseDownload(aha(paramajx.dua));
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
    paramg = paramg.field_favProto.oeJ.iterator();
    ajx localajx;
    do
    {
      if (!paramg.hasNext()) {
        break;
      }
      localajx = (ajx)paramg.next();
    } while (((localajx.dataType != 8) && (localajx.dataType != 4) && (localajx.dataType != 2) && (localajx.dataType != 3)) || ((!bu.isNullOrNil(localajx.GzA)) && (!bu.isNullOrNil(localajx.GzC))));
    for (boolean bool = false;; bool = true)
    {
      AppMethodBeat.o(103270);
      return bool;
    }
  }
  
  public static void eN(Context paramContext)
  {
    AppMethodBeat.i(201311);
    if (0L >= rAn)
    {
      ae.i("MicroMsg.Fav.FavApiLogic", "addTagWhenAddToFav,try to add tag ,but favLocalId is null, return");
      AppMethodBeat.o(201311);
      return;
    }
    g localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(rAn);
    rAn = 0L;
    if (localg == null)
    {
      ae.i("MicroMsg.Fav.FavApiLogic", "addTagWhenAddToFav,try to add tag ,but iteminfo is null, return");
      AppMethodBeat.o(201311);
      return;
    }
    ae.i("MicroMsg.Fav.FavApiLogic", "addTagWhenAddToFav ,go on");
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = com.tencent.mm.sdk.platformtools.ak.getContext();
    }
    paramContext = new Intent();
    paramContext.putExtra("key_fav_scene", 5);
    paramContext.putExtra("key_fav_item_id", localg.field_localId);
    a(localContext, ".ui.FavTagEditUI", paramContext, null);
    AppMethodBeat.o(201311);
  }
  
  public static boolean f(g paramg)
  {
    AppMethodBeat.i(103280);
    if (paramg.field_favProto == null)
    {
      AppMethodBeat.o(103280);
      return false;
    }
    paramg = paramg.field_favProto.oeJ.iterator();
    while (paramg.hasNext())
    {
      ajx localajx = (ajx)paramg.next();
      if (localajx.GAI == 2)
      {
        AppMethodBeat.o(103280);
        return true;
      }
      if (localajx.GAI == 1)
      {
        AppMethodBeat.o(103280);
        return true;
      }
    }
    AppMethodBeat.o(103280);
    return false;
  }
  
  public static boolean f(ajx paramajx)
  {
    AppMethodBeat.i(103316);
    f localf = com.tencent.mm.ay.a.aKc();
    if ((localf != null) && (localf.ijX == 6) && (bu.bI(paramajx.dua, "").equals(localf.ijZ)) && (com.tencent.mm.ay.a.aJZ()))
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
  
  public static boolean g(ajx paramajx)
  {
    AppMethodBeat.i(103326);
    boolean bool = new k(d(paramajx)).exists();
    AppMethodBeat.o(103326);
    return bool;
  }
  
  public static String getAppName(Context paramContext, String paramString)
  {
    AppMethodBeat.i(103318);
    ai.b localb = ai.a.hIE;
    if (localb != null)
    {
      paramContext = localb.r(paramContext, paramString);
      AppMethodBeat.o(103318);
      return paramContext;
    }
    AppMethodBeat.o(103318);
    return "";
  }
  
  private static String gm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(103259);
    if (bu.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(103259);
      return paramString2;
    }
    if (bu.isNullOrNil(paramString2))
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
    Set localSet = ao.rCe;
    paramg = paramg.field_favProto.oeJ;
    int i = 0;
    while (i < paramg.size())
    {
      Object localObject = a((ajx)paramg.get(i));
      if ((localSet == null) || (!localSet.contains(localObject))) {
        com.tencent.mm.vfs.o.deleteFile((String)localObject);
      }
      localObject = d((ajx)paramg.get(i));
      if ((localSet == null) || (!localSet.contains(localObject))) {
        com.tencent.mm.vfs.o.deleteFile((String)localObject);
      }
      localObject = (ajx)paramg.get(i);
      if ((((ajx)localObject).GAu != null) && (((ajx)localObject).GAu.GBv != null)) {
        com.tencent.mm.modelvideo.u.HZ(((ajx)localObject).dua);
      }
      i += 1;
    }
    AppMethodBeat.o(103282);
  }
  
  public static boolean h(ajx paramajx)
  {
    AppMethodBeat.i(103327);
    boolean bool = com.tencent.mm.sdk.platformtools.u.aRG(d(paramajx));
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
      if (paramg.field_favProto.GBf != null) {
        str1 = paramg.field_favProto.GBf.GCG;
      }
      String str2 = str1;
      if (paramg.field_favProto.GCe != null)
      {
        str2 = str1;
        if (bu.isNullOrNil(str1)) {
          str2 = paramg.field_favProto.GCe.link;
        }
      }
      paramg = new gr();
      paramg.dtF.url = str2;
      com.tencent.mm.sdk.b.a.IvT.l(paramg);
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
    ae.i("MicroMsg.Fav.FavApiLogic", "set need del IDs: %s", new Object[] { paramSet });
    com.tencent.mm.kernel.g.ajR().ajA().set(225282, paramSet);
    AppMethodBeat.o(103272);
  }
  
  public static void j(g paramg)
  {
    AppMethodBeat.i(103290);
    j localj = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavSearchStorage().vX(paramg.field_localId);
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
      if (paramg.field_favProto.GCe != null)
      {
        localObject1 = paramg.field_favProto.GCe;
        if (!bu.isNullOrNil(((akt)localObject1).dzZ))
        {
          localStringBuffer.append(((akt)localObject1).dzZ);
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(((akt)localObject1).dzZ);
          if (localObject2 != null) {
            localStringBuffer.append(((aw)localObject2).field_nickname).append(((aw)localObject2).field_conRemark);
          }
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(((akt)localObject1).toUser);
          if (localObject2 != null) {
            localStringBuffer.append(((aw)localObject2).field_nickname).append(((aw)localObject2).field_conRemark);
          }
          localStringBuffer.append(((akt)localObject1).GBE);
        }
      }
      Object localObject1 = paramg.field_favProto.oeJ;
      localj.field_subtype = 0;
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ajx)((Iterator)localObject1).next();
        if (((ajx)localObject2).desc != null) {
          localStringBuffer.append(((ajx)localObject2).desc);
        }
        if (((ajx)localObject2).title != null) {
          localStringBuffer.append(((ajx)localObject2).title);
        }
        int j = ((ajx)localObject2).dataType;
        int k = localj.field_subtype;
        localj.field_subtype = (j.Ek(j) | k);
      }
      if (paramg.field_favProto.GBf != null)
      {
        if (paramg.field_favProto.GBf.desc != null) {
          localStringBuffer.append(paramg.field_favProto.GBf.desc);
        }
        if (paramg.field_favProto.GBf.title != null) {
          localStringBuffer.append(paramg.field_favProto.GBf.title);
        }
      }
      if (paramg.field_favProto.GBh != null)
      {
        if (paramg.field_favProto.GBh.desc != null) {
          localStringBuffer.append(paramg.field_favProto.GBh.desc);
        }
        if (paramg.field_favProto.GBh.title != null) {
          localStringBuffer.append(paramg.field_favProto.GBh.title);
        }
      }
      if (paramg.field_favProto.GBx != null)
      {
        if (paramg.field_favProto.GBx.nickname != null) {
          localStringBuffer.append(paramg.field_favProto.GBx.nickname);
        }
        if (paramg.field_favProto.GBx.desc != null) {
          localStringBuffer.append(paramg.field_favProto.GBx.desc);
        }
      }
      localj.field_tagContent = "";
      localObject1 = paramg.field_tagProto.GCr.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localj.field_tagContent = (localj.field_tagContent + " " + (String)localObject2);
        localStringBuffer.append((String)localObject2);
      }
      localObject1 = paramg.field_tagProto.GCs.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localj.field_tagContent = (localj.field_tagContent + " " + (String)localObject2);
        localStringBuffer.append((String)localObject2);
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().ahn((String)localObject2);
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
    if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(paramg.field_localId) != null)
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
      ae.f("MicroMsg.Fav.FavApiLogic", "restartItemUpload status not upload failed!");
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
      if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().vP(paramg.field_localId).size() == 0)
      {
        paramg.field_itemStatus = 9;
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
        paramg = new ag(paramg);
        com.tencent.mm.kernel.g.ajj().a(paramg, 0);
        AppMethodBeat.o(103305);
        return;
      }
      paramg.field_itemStatus = 4;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().y(paramg);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
      Iterator localIterator = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().vP(paramg.field_localId).iterator();
      c localc;
      while (localIterator.hasNext())
      {
        localc = (c)localIterator.next();
        ae.i("MicroMsg.Fav.FavApiLogic", "force upload favItem[last failed], favid:%d localId:%d, dataId:%s, dataType:%d totalLength %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), localc.field_dataId, Integer.valueOf(localc.field_dataType), Integer.valueOf(localc.field_totalLen) });
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().ahq(localc.field_dataId);
      }
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
      AppMethodBeat.o(103305);
      return;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ac(12, paramg.field_localId);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getSendService().run();
      AppMethodBeat.o(103305);
      return;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ac(15, paramg.field_localId);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().y(paramg);
      localIterator = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().vP(paramg.field_localId).iterator();
      while (localIterator.hasNext())
      {
        localc = (c)localIterator.next();
        ae.i("MicroMsg.Fav.FavApiLogic", "force upload favItem[last mod failed], favid:%d localId:%d, dataId:%s, dataType:%d totalLength %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), localc.field_dataId, Integer.valueOf(localc.field_dataType), Integer.valueOf(localc.field_totalLen) });
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().ahq(localc.field_dataId);
      }
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
      AppMethodBeat.o(103305);
      return;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ac(17, paramg.field_localId);
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
      Object localObject = paramg.field_favProto.oeJ;
      if (((List)localObject).size() == 0)
      {
        AppMethodBeat.o(103306);
        return;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ajx localajx = (ajx)((Iterator)localObject).next();
        a(paramg, localajx, true);
        a(paramg, localajx);
      }
      AppMethodBeat.o(103306);
      return;
    }
    ae.e("MicroMsg.Fav.FavApiLogic", "status not download failed or done!");
    AppMethodBeat.o(103306);
  }
  
  public static void n(g paramg)
  {
    AppMethodBeat.i(103310);
    if (!paramg.cwu())
    {
      ae.e("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, not uploading");
      AppMethodBeat.o(103310);
      return;
    }
    ae.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, itemStatu:%d", new Object[] { Integer.valueOf(paramg.field_itemStatus) });
    Iterator localIterator = paramg.field_favProto.oeJ.iterator();
    while (localIterator.hasNext())
    {
      ajx localajx = (ajx)localIterator.next();
      c localc = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().ahs(localajx.dua);
      if ((localc != null) && (localc.field_status != 3))
      {
        localc.field_status = 2;
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().ahr(localajx.dua);
      }
      localc = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().ahs(aha(localajx.dua));
      if ((localc != null) && (localc.field_status != 3))
      {
        localc.field_status = 2;
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().ahr(aha(localajx.dua));
      }
    }
    paramg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(paramg.field_localId);
    ae.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, after pause data itemStatu:%d", new Object[] { Integer.valueOf(paramg.field_itemStatus) });
    switch (paramg.field_itemStatus)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(103310);
      return;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ac(3, paramg.field_localId);
      ae.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(3) });
      AppMethodBeat.o(103310);
      return;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ac(6, paramg.field_localId);
      ae.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(6) });
      AppMethodBeat.o(103310);
      return;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ac(11, paramg.field_localId);
      ae.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(11) });
      AppMethodBeat.o(103310);
      return;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ac(14, paramg.field_localId);
      ae.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(14) });
      AppMethodBeat.o(103310);
      return;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ac(16, paramg.field_localId);
      ae.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(16) });
      AppMethodBeat.o(103310);
      return;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ac(18, paramg.field_localId);
      ae.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(18) });
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
    ajx localajx = c(paramg);
    if (localajx == null)
    {
      AppMethodBeat.o(103319);
      return false;
    }
    long l = bu.HQ();
    com.tencent.mm.plugin.sight.base.a locala = com.tencent.mm.plugin.sight.base.e.ayN(d(localajx));
    int j;
    int i;
    boolean bool;
    if (locala != null)
    {
      j = locala.getVideoDuration();
      i = localajx.duration;
      if ((i <= 0) || (Math.abs(i - j) >= 2))
      {
        localajx.aan(j);
        bool = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.Fav.FavApiLogic", "repair video duration[%d TO %d] %b cost time %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool), Long.valueOf(bu.aO(l)) });
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
    j localj = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavSearchStorage().vX(paramg.field_localId);
    if (localj == null)
    {
      localj = new j();
      localj.field_localId = paramg.field_localId;
    }
    for (int i = 1;; i = 0)
    {
      localj.field_tagContent = "";
      Iterator localIterator = paramg.field_tagProto.GCr.iterator();
      String str;
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        localj.field_tagContent = (localj.field_tagContent + " " + str);
      }
      localIterator = paramg.field_tagProto.GCs.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        localj.field_tagContent = (localj.field_tagContent + " " + str);
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().ahn(str);
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
    akh localakh = paramg.field_favProto.FId;
    if ((localakh != null) && (!bu.isNullOrNil(localakh.GBY)))
    {
      AppMethodBeat.o(103344);
      return;
    }
    if (paramg.field_type == 18)
    {
      if (paramg.field_favProto.GCe.sourceType != 6) {
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
      paramg = paramg.field_favProto.oeJ.iterator();
      l = 0L;
      if (paramg.hasNext())
      {
        localObject = (ajx)paramg.next();
        if (localObject == null) {
          break label455;
        }
        l = ((ajx)localObject).GzV + l;
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
        if (bu.isNullOrNil(paramg.field_favProto.desc)) {
          break;
        }
        localStringBuffer.append(paramg.field_favProto.desc.getBytes().length);
        break;
        localStringBuffer.append(c(paramg).duration);
        break;
        localObject = "";
        try
        {
          paramg = paramg.field_favProto.GBf.GCG;
          localStringBuffer.append(paramg);
          break;
          if (paramg == null) {
            break;
          }
          paramg = paramg.field_favProto.oeJ.iterator();
          int i = 0;
          int m = 0;
          int k = 0;
          int j = 0;
          while (paramg.hasNext())
          {
            localObject = (ajx)paramg.next();
            switch (((ajx)localObject).dataType)
            {
            case 3: 
            default: 
              i += 1;
              break;
            case 1: 
              if (bu.isNullOrNil(((ajx)localObject).desc)) {
                break label452;
              }
              k = ((ajx)localObject).desc.getBytes().length + k;
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
  
  public static float sI(long paramLong)
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
  
  public static void startSync()
  {
    AppMethodBeat.i(103324);
    ak localak = new ak();
    com.tencent.mm.kernel.g.ajj().a(localak, 0);
    AppMethodBeat.o(103324);
  }
  
  public static void vD(long paramLong)
  {
    AppMethodBeat.i(103265);
    ae.i("MicroMsg.Fav.FavApiLogic", "setUsedCapacity:%d", new Object[] { Long.valueOf(paramLong) });
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.INz, Long.valueOf(paramLong));
    AppMethodBeat.o(103265);
  }
  
  public static void vE(long paramLong)
  {
    AppMethodBeat.i(103266);
    ae.i("MicroMsg.Fav.FavApiLogic", "setTotalCapacity:%d", new Object[] { Long.valueOf(paramLong) });
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.INA, Long.valueOf(paramLong));
    AppMethodBeat.o(103266);
  }
  
  private static String vF(long paramLong)
  {
    AppMethodBeat.i(103267);
    StringBuilder localStringBuilder = new StringBuilder();
    g localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(paramLong);
    if ((localg == null) || (localg.field_favProto == null) || (localg.field_favProto.oeJ.size() <= 1))
    {
      AppMethodBeat.o(103267);
      return "";
    }
    akh localakh = localg.field_favProto.FId;
    String str2 = "";
    String str1 = "";
    if (localakh != null)
    {
      str2 = localakh.GBY;
      str1 = localakh.GBX;
    }
    localStringBuilder.append("<noteinfo>");
    localStringBuilder.append("<noteauthor>").append(str1).append("</noteauthor>");
    localStringBuilder.append("<noteeditor>").append(str2).append("</noteeditor>");
    localStringBuilder.append("<edittime>").append(localg.field_favProto.pWN).append("</edittime>");
    localStringBuilder.append("<editusr>").append(str1).append("</editusr>");
    localStringBuilder.append("<favlocalid>").append(localg.field_localId).append("</favlocalid>");
    localStringBuilder.append(com.tencent.mm.plugin.fav.a.a.a.dq(localg.field_favProto.oeJ).replace("cdn_dataurl", "cdndataurl").replace("cdn_datakey", "cdndatakey").replace("cdn_thumburl", "cdnthumburl").replace("cdn_thumbkey", "cdnthumbkey").replace("thumbfullsize", "thumbsize").replace("fullsize", "datasize").replace("datasrcname", "sourcename").replace("datasrctime", "sourcetime").replace("stream_lowbandurl", "streamlowbandurl").replace("stream_dataurl", "streamdataurl").replace("stream_weburl", "streamweburl"));
    localStringBuilder.append("</noteinfo>");
    str1 = localStringBuilder.toString();
    AppMethodBeat.o(103267);
    return str1;
  }
  
  public static void vG(long paramLong)
  {
    AppMethodBeat.i(103274);
    com.tencent.mm.sdk.platformtools.ak.getContext().getSharedPreferences(com.tencent.mm.sdk.platformtools.ak.fow(), 0).edit().putLong("fav_mx_auto_download_size", paramLong).commit();
    AppMethodBeat.o(103274);
  }
  
  public static void vH(long paramLong)
  {
    AppMethodBeat.i(103275);
    com.tencent.mm.sdk.platformtools.ak.getContext().getSharedPreferences(com.tencent.mm.sdk.platformtools.ak.fow(), 0).edit().putLong("fav_mx_auto_upload_size", paramLong).commit();
    AppMethodBeat.o(103275);
  }
  
  public static void vI(long paramLong)
  {
    AppMethodBeat.i(103276);
    com.tencent.mm.sdk.platformtools.ak.getContext().getSharedPreferences(com.tencent.mm.sdk.platformtools.ak.fow(), 0).edit().putLong("fav_mx_file_size", paramLong).commit();
    AppMethodBeat.o(103276);
  }
  
  public static void vJ(long paramLong)
  {
    rAn = paramLong;
  }
  
  public static float vK(long paramLong)
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
  
  public static String vL(long paramLong)
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
    ae.i("MicroMsg.Fav.FavApiLogic", "tryStartBatchGet...");
    long l1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().E(paramLong, paramInt);
    long l2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().C(paramLong, paramInt);
    ae.i("MicroMsg.Fav.FavApiLogic", "klem, tryStartBatchGet, batchGetTime:%d, itemTiem:%d, updateTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(paramLong) });
    if (l1 == 0L)
    {
      AppMethodBeat.o(103323);
      return l2;
    }
    Object localObject = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().D(l1, paramInt);
    if (((LinkedList)localObject).size() > 0)
    {
      ae.i("MicroMsg.Fav.FavApiLogic", "klem, tryStartBatchGet, batchGetTime:%d, itemTiem:%d, updateTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(paramLong) });
      ae.i("MicroMsg.Fav.FavApiLogic", "klem, tryStartBatchGet, need batch get idList size:%d", new Object[] { Integer.valueOf(((LinkedList)localObject).size()) });
      localObject = new ai((LinkedList)localObject);
      if (!com.tencent.mm.kernel.g.ajj().a((n)localObject, 0))
      {
        ae.w("MicroMsg.Fav.FavApiLogic", "do scene BatchGetFav fail");
        ai.cwY();
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
  
  public static String zQ(String paramString)
  {
    AppMethodBeat.i(103304);
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paramString);
    if (localObject == null)
    {
      ae.w("MicroMsg.Fav.FavApiLogic", "wtf get contact null, username %s", new Object[] { paramString });
      AppMethodBeat.o(103304);
      return "";
    }
    String str = ((an)localObject).adG();
    localObject = str;
    if (com.tencent.mm.model.x.wb(str))
    {
      paramString = com.tencent.mm.model.r.zA(paramString);
      localObject = v.aAC();
      if ((paramString != null) && (!paramString.isEmpty())) {
        break label110;
      }
      ae.w("MicroMsg.Fav.FavApiLogic", "get members from username error, content empty");
    }
    for (localObject = str;; localObject = com.tencent.mm.model.r.e(paramString, 3))
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