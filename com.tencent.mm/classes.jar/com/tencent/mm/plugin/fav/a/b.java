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
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.g.a.gi.a;
import com.tencent.mm.g.a.gi.b;
import com.tencent.mm.g.a.li;
import com.tencent.mm.g.a.pd;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.ad.a;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.n;
import com.tencent.mm.model.t;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acb;
import com.tencent.mm.protocal.protobuf.acf;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.ack;
import com.tencent.mm.protocal.protobuf.acp;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.protocal.protobuf.acz;
import com.tencent.mm.protocal.protobuf.add;
import com.tencent.mm.protocal.protobuf.adf;
import com.tencent.mm.protocal.protobuf.bdy;
import com.tencent.mm.protocal.protobuf.beb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
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
  private static HashMap<Long, ArrayList<String>> msJ;
  private static long msK;
  
  static
  {
    AppMethodBeat.i(102620);
    msJ = new HashMap();
    msK = 0L;
    AppMethodBeat.o(102620);
  }
  
  public static String NA(String paramString)
  {
    AppMethodBeat.i(102567);
    ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(paramString);
    if (localad != null)
    {
      if (!bo.isNullOrNil(localad.field_conRemark))
      {
        paramString = localad.field_conRemark;
        AppMethodBeat.o(102567);
        return paramString;
      }
      if (!bo.isNullOrNil(localad.field_nickname))
      {
        paramString = localad.field_nickname;
        AppMethodBeat.o(102567);
        return paramString;
      }
      paramString = localad.field_username;
      AppMethodBeat.o(102567);
      return paramString;
    }
    AppMethodBeat.o(102567);
    return paramString;
  }
  
  public static String NB(String paramString)
  {
    AppMethodBeat.i(102589);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(102589);
      return null;
    }
    paramString = new com.tencent.mm.vfs.b(bvW() + com.tencent.mm.a.g.w(paramString.getBytes()));
    if (paramString.exists())
    {
      paramString = com.tencent.mm.vfs.j.p(paramString.dQJ());
      AppMethodBeat.o(102589);
      return paramString;
    }
    AppMethodBeat.o(102589);
    return null;
  }
  
  public static int NC(String paramString)
  {
    AppMethodBeat.i(102598);
    if ((!bo.isNullOrNil(paramString)) && (paramString.equals("speex")))
    {
      AppMethodBeat.o(102598);
      return 1;
    }
    if ((!bo.isNullOrNil(paramString)) && (paramString.equals("silk")))
    {
      AppMethodBeat.o(102598);
      return 2;
    }
    AppMethodBeat.o(102598);
    return 0;
  }
  
  public static g ND(String paramString)
  {
    AppMethodBeat.i(102600);
    g localg = new g();
    localg.field_localId = -1L;
    localg.field_id = -1;
    localg.field_xml = paramString;
    localg.field_type = 18;
    localg.NF(paramString);
    AppMethodBeat.o(102600);
    return localg;
  }
  
  private static g NE(String paramString)
  {
    AppMethodBeat.i(102601);
    if ((paramString == null) || (paramString.equals("")))
    {
      ab.e("MicroMsg.Fav.FavApiLogic", "parseSnsNoteInfoXml but xml is null");
      AppMethodBeat.o(102601);
      return null;
    }
    paramString = paramString.replace("cdndataurl", "cdn_dataurl").replace("cdndatakey", "cdn_datakey").replace("cdnthumburl", "cdn_thumburl").replace("cdnthumbkey", "cdn_thumbkey").replace("datasize", "fullsize").replace("thumbsize", "thumbfullsize").replace("sourcename", "datasrcname").replace("sourcetime", "datasrctime").replace("streamlowbandurl", "stream_lowbandurl").replace("streamdataurl", "stream_dataurl").replace("streamweburl", "stream_weburl");
    if (!paramString.startsWith("<noteinfo>")) {
      paramString = "<noteinfo>" + paramString + "</noteinfo>";
    }
    for (;;)
    {
      Map localMap = br.F(paramString, "noteinfo");
      if (localMap == null)
      {
        ab.e("MicroMsg.Fav.FavApiLogic", "parseSnsNoteInfoXml, FavItemInfo maps null");
        AppMethodBeat.o(102601);
        return null;
      }
      g localg = new g();
      try
      {
        localg.field_favProto = new acq();
        localg.field_type = 18;
        Object localObject = (String)localMap.get(".noteinfo.edittime");
        localg.field_favProto.nH(bo.getLong((String)localObject, 0L));
        localObject = new ack();
        ((ack)localObject).wUU = ((String)localMap.get(".noteinfo.noteeditor"));
        ((ack)localObject).wUT = ((String)localMap.get(".noteinfo.noteauthor"));
        localg.field_favProto.a((ack)localObject);
        localg.field_localId = bo.getLong((String)localMap.get(".noteinfo.favlocalid"), System.currentTimeMillis());
        com.tencent.mm.plugin.fav.a.a.c.a(paramString, localg.field_favProto);
        AppMethodBeat.o(102601);
        return localg;
      }
      catch (Exception paramString)
      {
        ab.printErrStackTrace("MicroMsg.Fav.FavApiLogic", paramString, "", new Object[0]);
        ab.e("MicroMsg.Fav.FavApiLogic", "parseSnsNoteInfoXml , FavItemInfo exception:+%s", new Object[] { paramString.toString() });
        AppMethodBeat.o(102601);
        return null;
      }
    }
  }
  
  private static com.tencent.mm.vfs.b Nx(String paramString)
  {
    AppMethodBeat.i(102544);
    int i = paramString.hashCode();
    paramString = new com.tencent.mm.vfs.b(String.format("%s/%s/%d/", new Object[] { com.tencent.mm.kernel.g.RL().eHR, "favorite", Integer.valueOf(i & 0xFF) }));
    if ((!paramString.exists()) || (!paramString.isDirectory())) {
      paramString.mkdirs();
    }
    AppMethodBeat.o(102544);
    return paramString;
  }
  
  public static String Ny(String paramString)
  {
    AppMethodBeat.i(102549);
    paramString = paramString + "_t";
    AppMethodBeat.o(102549);
    return paramString;
  }
  
  public static boolean Nz(String paramString)
  {
    AppMethodBeat.i(102555);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(102555);
      return false;
    }
    boolean bool = paramString.endsWith("_t");
    AppMethodBeat.o(102555);
    return bool;
  }
  
  public static long a(g paramg)
  {
    AppMethodBeat.i(102526);
    Object localObject = a.msH;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      if (localObject[i] == paramg.field_type)
      {
        if (paramg.field_favProto != null)
        {
          localObject = paramg.field_favProto.wVc.iterator();
          for (long l1 = 0L;; l1 = ((aca)((Iterator)localObject).next()).wSX + l1)
          {
            l2 = l1;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
          }
        }
        long l2 = 0L;
        paramg.field_datatotalsize = l2;
        ab.d("MicroMsg.Fav.FavApiLogic", "calFavItemInfoTotalLength id:%d,length:%d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(l2) });
        AppMethodBeat.o(102526);
        return l2;
      }
      i += 1;
    }
    AppMethodBeat.o(102526);
    return 0L;
  }
  
  public static g a(acq paramacq)
  {
    AppMethodBeat.i(102604);
    g localg = new g();
    localg.field_favProto = new acq();
    localg.field_type = 18;
    localg.field_favProto = paramacq;
    AppMethodBeat.o(102604);
    return localg;
  }
  
  public static aca a(g paramg, String paramString)
  {
    AppMethodBeat.i(102556);
    if ((bo.isNullOrNil(paramString)) || (paramg == null) || (paramg.field_favProto.wVc.size() == 0))
    {
      AppMethodBeat.o(102556);
      return null;
    }
    paramg = paramg.field_favProto.wVc.iterator();
    while (paramg.hasNext())
    {
      aca localaca = (aca)paramg.next();
      if (localaca.mBq.equals(paramString))
      {
        AppMethodBeat.o(102556);
        return localaca;
      }
    }
    AppMethodBeat.o(102556);
    return null;
  }
  
  public static acf a(int paramInt, acq paramacq, add paramadd)
  {
    AppMethodBeat.i(102527);
    if (paramacq == null)
    {
      ab.w("MicroMsg.Fav.FavApiLogic", "proto item is null");
      AppMethodBeat.o(102527);
      return null;
    }
    acf localacf = new acf();
    acw localacw = paramacq.wVa;
    if (localacw != null)
    {
      localacf.czp = localacw.czp;
      localacf.wUL = localacw.wUA;
      localacf.appId = localacw.appId;
      localacf.cmx = localacw.cmx;
    }
    if (paramadd != null)
    {
      if (paramadd.wVp != null) {
        localacf.wUM.addAll(paramadd.wVp);
      }
      if (paramadd.wVq != null) {
        localacf.wUM.addAll(paramadd.wVq);
      }
    }
    localacf.cEC = paramacq;
    localacf.type = paramInt;
    switch (paramInt)
    {
    case 3: 
    case 9: 
    case 13: 
    case 16: 
    case 17: 
    default: 
      ab.w("MicroMsg.Fav.FavApiLogic", "unknown type %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(102527);
      return localacf;
    case 1: 
      localacf.title = "";
      localacf.desc = paramacq.desc;
      AppMethodBeat.o(102527);
      return localacf;
    case 4: 
      if ((paramacq.wVc != null) && (!paramacq.wVc.isEmpty())) {
        localacf.title = ((aca)paramacq.wVc.get(0)).title;
      }
      AppMethodBeat.o(102527);
      return localacf;
    case 5: 
      if (paramacq.wUf != null)
      {
        localacf.title = paramacq.wUf.title;
        localacf.desc = paramacq.wUf.wVF;
      }
      if ((bo.isNullOrNil(localacf.title)) && (paramacq.wVc != null) && (!paramacq.wVc.isEmpty())) {
        localacf.title = ((aca)paramacq.wVc.get(0)).title;
      }
      if ((bo.isNullOrNil(localacf.desc)) && (localacw != null)) {
        localacf.desc = localacw.link;
      }
      AppMethodBeat.o(102527);
      return localacf;
    case 6: 
      localacf.title = paramacq.hKa;
      if (bo.isNullOrNil(localacf.title)) {
        if (paramacq.wUd != null)
        {
          localacf.title = paramacq.wUd.cDl;
          localacf.desc = paramacq.wUd.label;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(102527);
        return localacf;
        if (paramacq.wUd != null) {
          localacf.desc = paramacq.wUd.cDl;
        }
      }
    case 2: 
      if ((paramacq.wVc != null) && (paramacq.wVc.size() > 0)) {
        localacf.title = ((aca)paramacq.wVc.get(0)).title;
      }
      AppMethodBeat.o(102527);
      return localacf;
    case 7: 
      if ((paramacq.wVc != null) && (!paramacq.wVc.isEmpty()))
      {
        localacf.title = ((aca)paramacq.wVc.get(0)).title;
        localacf.desc = ((aca)paramacq.wVc.get(0)).desc;
      }
      AppMethodBeat.o(102527);
      return localacf;
    case 8: 
      localacf.title = paramacq.title;
      if ((bo.isNullOrNil(localacf.title)) && (paramacq.wVc != null) && (!paramacq.wVc.isEmpty())) {
        localacf.title = ((aca)paramacq.wVc.get(0)).title;
      }
      AppMethodBeat.o(102527);
      return localacf;
    case 10: 
    case 11: 
      if (paramacq.wUh != null)
      {
        localacf.title = paramacq.wUh.title;
        localacf.desc = paramacq.wUh.desc;
      }
      AppMethodBeat.o(102527);
      return localacf;
    case 12: 
    case 15: 
      if (paramacq.wUj != null)
      {
        localacf.title = paramacq.wUj.title;
        localacf.desc = paramacq.wUj.desc;
      }
      AppMethodBeat.o(102527);
      return localacf;
    }
    paramacq = paramacq.wVc;
    if (paramacq == null)
    {
      AppMethodBeat.o(102527);
      return null;
    }
    paramacq = paramacq.iterator();
    while (paramacq.hasNext())
    {
      paramadd = (aca)paramacq.next();
      if (1 == paramadd.dataType) {
        localacf.title = paramadd.desc;
      }
    }
    AppMethodBeat.o(102527);
    return localacf;
  }
  
  public static String a(aca paramaca)
  {
    AppMethodBeat.i(102523);
    acb localacb = paramaca.wTw;
    String str = "";
    switch (paramaca.dataType)
    {
    case 2: 
    case 3: 
    case 7: 
    case 9: 
    default: 
      paramaca = eo(eo("", localacb.title), localacb.desc);
    }
    for (;;)
    {
      AppMethodBeat.o(102523);
      return paramaca;
      paramaca = eo("", paramaca.desc);
      continue;
      paramaca = str;
      if (localacb.wUj != null)
      {
        paramaca = eo("", localacb.wUj.title);
        continue;
        paramaca = str;
        if (localacb.wUf != null)
        {
          paramaca = eo("", localacb.wUf.title);
          continue;
          str = eo("", localacb.hKa);
          paramaca = str;
          if (localacb.wUd != null)
          {
            paramaca = eo(eo(str, localacb.wUd.cDl), localacb.wUd.label);
            continue;
            paramaca = str;
            if (localacb.wUh != null)
            {
              paramaca = eo(eo("", localacb.wUh.title), localacb.wUh.desc);
              continue;
              paramaca = eo("", localacb.title);
            }
          }
        }
      }
    }
  }
  
  public static ArrayList<g> a(List<String> paramList1, List<String> paramList2, List<Integer> paramList, List<g> paramList3, Set<Integer> paramSet, w paramw)
  {
    AppMethodBeat.i(102597);
    paramList1 = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavSearchStorage().b(paramList1, paramList2, paramList);
    paramList2 = new ArrayList();
    if (paramList1.size() == 0)
    {
      AppMethodBeat.o(102597);
      return paramList2;
    }
    int i;
    for (int j = 0;; j = i)
    {
      Object localObject;
      if (j + 20 < paramList1.size())
      {
        i = j + 20;
        ab.v("MicroMsg.Fav.FavApiLogic", "start:%d  end:%d listSize:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramList1.size()) });
        localObject = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().a(paramList1.subList(j, i), paramList3, paramSet, paramw);
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
                LinkedList localLinkedList = localg.field_favProto.wVc;
                j = 1;
                if (j >= localLinkedList.size()) {
                  continue;
                }
                int k = ((aca)localLinkedList.get(j)).dataType;
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
        AppMethodBeat.o(102597);
        return paramList2;
      }
    }
  }
  
  public static List<g> a(long paramLong, int paramInt, Set<Integer> paramSet, w paramw)
  {
    AppMethodBeat.i(102586);
    if (paramLong == 0L)
    {
      paramSet = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().a(paramInt, paramSet, paramw);
      AppMethodBeat.o(102586);
      return paramSet;
    }
    paramSet = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().b(paramLong, paramInt, paramSet, paramw);
    AppMethodBeat.o(102586);
    return paramSet;
  }
  
  public static void a(long paramLong, ach paramach, String paramString1, String paramString2, ArrayList<String> paramArrayList, Context paramContext)
  {
    AppMethodBeat.i(102617);
    if ((paramach == null) || (paramContext == null))
    {
      AppMethodBeat.o(102617);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("KFavLocSigleView", true);
    localIntent.putExtra("map_view_type", 2);
    localIntent.putExtra("kFavInfoLocalId", paramLong);
    localIntent.putExtra("kwebmap_slat", paramach.lat);
    localIntent.putExtra("kwebmap_lng", paramach.lng);
    localIntent.putExtra("kPoiName", paramach.cDl);
    localIntent.putExtra("Kwebmap_locaion", paramach.label);
    if (paramach.cyX >= 0) {
      localIntent.putExtra("kwebmap_scale", paramach.cyX);
    }
    localIntent.putExtra("kisUsername", paramString1);
    localIntent.putExtra("kwebmap_from_to", true);
    localIntent.putExtra("kRemark", paramString2);
    localIntent.putExtra("kTags", paramArrayList);
    localIntent.putExtra("kFavCanDel", true);
    localIntent.putExtra("kFavCanRemark", true);
    com.tencent.mm.bq.d.b(paramContext, "location", ".ui.RedirectUI", localIntent);
    AppMethodBeat.o(102617);
  }
  
  public static void a(Context paramContext, String paramString, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(102611);
    a(paramContext, paramString, paramIntent, paramInt, null);
    AppMethodBeat.o(102611);
  }
  
  public static void a(Context paramContext, String paramString, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(102612);
    Intent localIntent = paramIntent;
    if (paramIntent == null) {}
    try
    {
      localIntent = new Intent();
      String str = com.tencent.mm.sdk.platformtools.ah.dsO() + ".plugin.fav";
      paramIntent = paramString;
      if (paramString.startsWith(".")) {
        paramIntent = str + paramString;
      }
      localIntent.setClassName(com.tencent.mm.sdk.platformtools.ah.getPackageName(), paramIntent);
      Class.forName(paramIntent, false, paramContext.getClassLoader());
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).startActivityForResult(localIntent, paramInt, paramBundle);
      }
      AppMethodBeat.o(102612);
      return;
    }
    catch (Exception paramContext)
    {
      ab.e("MicroMsg.Fav.FavApiLogic", "Class Not Found when startActivity %s", new Object[] { paramContext });
      AppMethodBeat.o(102612);
    }
  }
  
  public static void a(Context paramContext, String paramString, Intent paramIntent, Bundle paramBundle)
  {
    AppMethodBeat.i(102610);
    Intent localIntent = paramIntent;
    if (paramIntent == null) {}
    try
    {
      localIntent = new Intent();
      String str = com.tencent.mm.sdk.platformtools.ah.dsO() + ".plugin.fav";
      paramIntent = paramString;
      if (paramString.startsWith(".")) {
        paramIntent = str + paramString;
      }
      localIntent.setClassName(com.tencent.mm.sdk.platformtools.ah.getPackageName(), paramIntent);
      Class.forName(paramIntent, false, paramContext.getClassLoader());
      if ((paramContext instanceof Activity))
      {
        paramContext.startActivity(localIntent, paramBundle);
        AppMethodBeat.o(102610);
        return;
      }
      localIntent.addFlags(268435456);
      paramContext.startActivity(localIntent, paramBundle);
      AppMethodBeat.o(102610);
      return;
    }
    catch (Exception paramContext)
    {
      ab.e("MicroMsg.Fav.FavApiLogic", "Class Not Found when startActivity %s", new Object[] { paramContext });
      AppMethodBeat.o(102610);
    }
  }
  
  private static void a(gi paramgi)
  {
    AppMethodBeat.i(102533);
    if (bo.isNullOrNil(paramgi.cuX.desc))
    {
      paramgi.cuY.ret = -1;
      AppMethodBeat.o(102533);
      return;
    }
    Object localObject = NE(paramgi.cuX.desc);
    if ((localObject == null) || (((g)localObject).field_localId <= 0L))
    {
      paramgi.cuY.ret = -1;
      AppMethodBeat.o(102533);
      return;
    }
    boolean bool = e((g)localObject);
    String str = paramgi.cuX.cvd;
    if (bool)
    {
      paramgi.cuY.ret = 1;
      paramgi = (ArrayList)msJ.get(Long.valueOf(((g)localObject).field_localId));
      if (paramgi != null)
      {
        if (paramgi.contains(str)) {
          paramgi.remove(str);
        }
        if (paramgi.size() == 0) {
          msJ.remove(Long.valueOf(((g)localObject).field_localId));
        }
      }
      AppMethodBeat.o(102533);
      return;
    }
    if (bo.isNullOrNil(str))
    {
      paramgi.cuY.ret = -1;
      AppMethodBeat.o(102533);
      return;
    }
    long l = ((g)localObject).field_localId;
    if (msJ.get(Long.valueOf(l)) == null) {}
    for (localObject = new ArrayList();; localObject = (ArrayList)msJ.get(Long.valueOf(l)))
    {
      ((ArrayList)localObject).add(str);
      msJ.put(Long.valueOf(l), localObject);
      localObject = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(l);
      if ((localObject != null) && (((g)localObject).field_localId > 0L)) {
        break;
      }
      paramgi.cuY.ret = -1;
      AppMethodBeat.o(102533);
      return;
    }
    if ((e((g)localObject)) || (((g)localObject).field_itemStatus == 10))
    {
      paramgi.cuY.ret = -1;
      com.tencent.mm.kernel.g.RO().o(new b.1((g)localObject), 500L);
      AppMethodBeat.o(102533);
      return;
    }
    paramgi.cuY.ret = -1;
    AppMethodBeat.o(102533);
  }
  
  public static void a(c paramc)
  {
    AppMethodBeat.i(102557);
    int i = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().t(paramc.field_favLocalId, 0);
    ab.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus, upload data status:%d, favlocalId:%d", new Object[] { Integer.valueOf(i), Long.valueOf(paramc.field_favLocalId) });
    g localg = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(paramc.field_favLocalId);
    if (localg == null)
    {
      ab.e("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus iteminfo null");
      AppMethodBeat.o(102557);
      return;
    }
    if (localg.bws())
    {
      ab.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus waiting server upload skip.");
      AppMethodBeat.o(102557);
      return;
    }
    if ((paramc.field_status == 3) && (i != paramc.field_status) && (localg.field_type == 18) && (((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().NP(paramc.field_dataId).field_status == 3))
    {
      a(paramc, localg);
      AppMethodBeat.o(102557);
      return;
    }
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(102557);
      return;
      if (localg.bwr()) {
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().O(15, paramc.field_favLocalId);
      }
      for (;;)
      {
        ab.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus, continue upload data, favlocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
        AppMethodBeat.o(102557);
        return;
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().O(4, paramc.field_favLocalId);
      }
      if (localg.bwr()) {
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().O(16, paramc.field_favLocalId);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.qsU.e(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(localg.field_type), Integer.valueOf(-5), Long.valueOf(b(localg)), Long.valueOf(h.jU(localg.field_localId)) });
        ab.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus, error, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
        AppMethodBeat.o(102557);
        return;
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().O(6, paramc.field_favLocalId);
      }
      AppMethodBeat.o(102557);
      return;
      if (localg.field_type == 18)
      {
        a(paramc, localg);
        AppMethodBeat.o(102557);
        return;
      }
      if (localg.bwr())
      {
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().O(17, paramc.field_favLocalId);
        ab.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus start mod faviteminfo, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getModService().run();
        AppMethodBeat.o(102557);
        return;
      }
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().O(9, paramc.field_favLocalId);
      ab.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus start send faviteminfo, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getSendService().run();
      AppMethodBeat.o(102557);
      return;
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().O(6, paramc.field_favLocalId);
      ab.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus pause, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
    }
  }
  
  private static void a(c paramc, g paramg)
  {
    AppMethodBeat.i(102559);
    Iterator localIterator = paramg.field_favProto.wVc.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      aca localaca = (aca)localIterator.next();
      if ((localaca.dataType != 1) && (localaca.dataType != 6))
      {
        if (!bo.isNullOrNil(localaca.wSC)) {
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
          ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().O(17, paramc.field_favLocalId);
          ((ae)com.tencent.mm.kernel.g.G(ae.class)).getModService().run();
          AppMethodBeat.o(102559);
          return;
        }
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().O(9, paramc.field_favLocalId);
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getSendService().run();
      }
      AppMethodBeat.o(102559);
      return;
    }
  }
  
  public static void a(g paramg, int paramInt)
  {
    AppMethodBeat.i(102608);
    if (paramg == null)
    {
      ab.w("MicroMsg.Fav.FavApiLogic", "modeTag, item info is null");
      AppMethodBeat.o(102608);
      return;
    }
    Object localObject1 = new LinkedList();
    Object localObject2 = new bdy();
    ((bdy)localObject2).xtK = 4;
    ((bdy)localObject2).xtL = 0;
    ((LinkedList)localObject1).add(localObject2);
    localObject2 = new LinkedList();
    beb localbeb = new beb();
    localbeb.ntn = "favitem.taglist";
    localbeb.jKs = 1;
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramg.field_tagProto.wVq.size();
    int i = 0;
    while (i < j)
    {
      localStringBuffer.append("<tag>").append(bo.apT((String)paramg.field_tagProto.wVq.get(i))).append("</tag>");
      i += 1;
    }
    localbeb.qsu = localStringBuffer.toString();
    ab.v("MicroMsg.Fav.FavApiLogic", "do net scene mod tag, id=%d, tag=%s", new Object[] { Integer.valueOf(paramg.field_id), localbeb.qsu });
    ((LinkedList)localObject2).add(localbeb);
    if (paramg.field_id > 0)
    {
      localObject1 = new al(paramg.field_id, (LinkedList)localObject1, (LinkedList)localObject2);
      com.tencent.mm.kernel.g.Rc().a((m)localObject1, 0);
      h.j(paramg.field_id, j, paramInt);
      AppMethodBeat.o(102608);
      return;
    }
    ((ae)com.tencent.mm.kernel.g.G(ae.class)).getEditService().a(paramg.field_localId, (LinkedList)localObject1, (LinkedList)localObject2, paramInt);
    AppMethodBeat.o(102608);
  }
  
  public static void a(g paramg, aca paramaca)
  {
    AppMethodBeat.i(102572);
    if (bo.isNullOrNil(paramaca.mBq))
    {
      AppMethodBeat.o(102572);
      return;
    }
    String str = Ny(paramaca.mBq);
    c localc = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().NP(str);
    Object localObject = localc;
    if (localc != null)
    {
      localObject = localc;
      if (localc.field_status == 3)
      {
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().b(localc, new String[] { "dataId" });
        localObject = null;
      }
    }
    if ((localObject != null) && (((c)localObject).field_type == 1))
    {
      ((c)localObject).field_status = 1;
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().a((c)localObject, new String[] { "dataId" });
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnService().NN(str);
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnService().run();
      AppMethodBeat.o(102572);
      return;
    }
    localObject = new com.tencent.mm.vfs.b(c(paramaca));
    if ((!bo.isNullOrNil(paramaca.wSy)) && (!bo.isNullOrNil(paramaca.fgM)) && (!((com.tencent.mm.vfs.b)localObject).exists()))
    {
      a(paramaca, paramg, 1);
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnService().NN(str);
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnService().run();
    }
    AppMethodBeat.o(102572);
  }
  
  public static void a(g paramg, aca paramaca, boolean paramBoolean)
  {
    AppMethodBeat.i(102571);
    if ((paramg == null) || (bo.isNullOrNil(paramaca.mBq)))
    {
      AppMethodBeat.o(102571);
      return;
    }
    ab.i("MicroMsg.Fav.FavApiLogic", "restart cdndata download, favId %d, favLocalId %d, dataId %s", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), paramaca.mBq });
    Object localObject2 = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().NP(paramaca.mBq);
    Object localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((c)localObject2).field_status == 3)
      {
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().b((c)localObject2, new String[] { "dataId" });
        localObject1 = null;
      }
    }
    localObject2 = localObject1;
    if (localObject1 != null) {
      if ((!bo.isNullOrNil(((c)localObject1).field_cdnUrl)) && (!bo.isNullOrNil(((c)localObject1).field_cdnKey)) && (!bo.isNullOrNil(((c)localObject1).field_dataId)) && (((c)localObject1).field_cdnUrl.equals(paramaca.wSC)) && (((c)localObject1).field_cdnKey.equals(paramaca.wSE)))
      {
        localObject2 = localObject1;
        if (((c)localObject1).field_dataId.equals(paramaca.mBq)) {}
      }
      else
      {
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().b((c)localObject1, new String[] { "dataId" });
        localObject2 = null;
      }
    }
    if ((localObject2 != null) && (((c)localObject2).field_type == 1))
    {
      ab.i("MicroMsg.Fav.FavApiLogic", "klem data not download completed.");
      ((c)localObject2).field_status = 1;
      ((c)localObject2).field_path = b(paramaca);
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().a((c)localObject2, new String[] { "dataId" });
      if (paramBoolean)
      {
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnService().NN(paramaca.mBq);
        if ((!bo.isNullOrNil(paramaca.wTE)) && (paramaca.wTE.equals("WeNoteHtmlFile")))
        {
          paramg = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().NP(paramaca.mBq);
          ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnService().c(paramg);
        }
      }
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnService().run();
      AppMethodBeat.o(102571);
      return;
    }
    localObject1 = new com.tencent.mm.vfs.b(b(paramaca));
    if ((!bo.isNullOrNil(paramaca.wSE)) && (!bo.isNullOrNil(paramaca.wSC)) && (!((com.tencent.mm.vfs.b)localObject1).exists()))
    {
      ab.i("MicroMsg.Fav.FavApiLogic", "klem big img not exist, start download.");
      long l = System.currentTimeMillis();
      a(paramaca, paramg, 1, true);
      if (paramBoolean)
      {
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnService().NN(paramaca.mBq);
        if ((!bo.isNullOrNil(paramaca.wTE)) && (paramaca.wTE.equals("WeNoteHtmlFile")))
        {
          paramg = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().NP(paramaca.mBq);
          ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnService().c(paramg);
        }
      }
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnService().run();
      ab.i("MicroMsg.Fav.FavApiLogic", "insert cdn item use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
    AppMethodBeat.o(102571);
  }
  
  public static void a(g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(102551);
    h(paramg);
    ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavSearchStorage().kd(paramg.field_localId);
    ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().z(paramg);
    ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().jZ(paramg.field_localId);
    ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavTagSetMgr().v(paramg);
    if (paramBoolean)
    {
      Set localSet = bvV();
      localSet.add(paramg.field_id);
      c(localSet);
      bvX();
    }
    AppMethodBeat.o(102551);
  }
  
  public static void a(aca paramaca, int paramInt, long paramLong)
  {
    AppMethodBeat.i(102593);
    if (bo.isNullOrNil(paramaca.mBq))
    {
      AppMethodBeat.o(102593);
      return;
    }
    if ((bo.isNullOrNil(paramaca.wSy)) || (bo.isNullOrNil(paramaca.fgM)))
    {
      AppMethodBeat.o(102593);
      return;
    }
    String str = Ny(paramaca.mBq);
    c localc = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().NP(str);
    Object localObject = localc;
    if (localc != null) {
      if (localc.field_status != 3)
      {
        localObject = localc;
        if (localc.field_status != 4) {}
      }
      else
      {
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().b(localc, new String[] { "dataId" });
        localObject = null;
      }
    }
    if ((localObject != null) && (((c)localObject).field_type == 1))
    {
      ((c)localObject).field_status = 1;
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().a((c)localObject, new String[] { "dataId" });
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnService().NN(str);
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnService().run();
      AppMethodBeat.o(102593);
      return;
    }
    localObject = new com.tencent.mm.vfs.b(c(paramaca));
    if ((!bo.isNullOrNil(paramaca.wSy)) && (!bo.isNullOrNil(paramaca.fgM)) && (!((com.tencent.mm.vfs.b)localObject).exists()))
    {
      localObject = new g();
      ((g)localObject).field_localId = paramLong;
      ((g)localObject).field_id = -1;
      ((g)localObject).field_type = paramInt;
      a(paramaca, (g)localObject, 1);
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnService().NN(str);
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnService().run();
    }
    AppMethodBeat.o(102593);
  }
  
  public static void a(aca paramaca, g paramg, int paramInt)
  {
    AppMethodBeat.i(102560);
    if ((paramInt == 1) && ((paramaca.wTi <= 0L) || (bo.isNullOrNil(paramaca.wSy)) || (bo.isNullOrNil(paramaca.fgM))))
    {
      ab.e("MicroMsg.Fav.FavApiLogic", "insertCdnThumbInfo, type recv, cdndataurl must not be null!");
      AppMethodBeat.o(102560);
      return;
    }
    if ((paramInt == 0) && (bo.isNullOrNil(c(paramaca))))
    {
      ab.e("MicroMsg.Fav.FavApiLogic", "insertCdnThumbInfo, type send, path must not be null!");
      AppMethodBeat.o(102560);
      return;
    }
    String str = Ny(paramaca.mBq);
    if (((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().NP(str) != null)
    {
      ab.w("MicroMsg.Fav.FavApiLogic", "cdn info exist, id[%s], return", new Object[] { str });
      AppMethodBeat.o(102560);
      return;
    }
    ab.v("MicroMsg.Fav.FavApiLogic", "insert cdn thumb info, fav local id[%d] fav id[%d]", new Object[] { Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
    c localc = new c();
    localc.field_cdnKey = paramaca.wSy;
    localc.field_cdnUrl = paramaca.fgM;
    localc.field_dataId = str;
    localc.field_favLocalId = paramg.field_localId;
    localc.field_totalLen = ((int)paramaca.wTi);
    localc.field_type = paramInt;
    localc.field_status = 1;
    localc.field_path = c(paramaca);
    localc.field_modifyTime = bo.aoy();
    localc.field_attrFlag |= 1L;
    ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().e(localc);
    if (paramInt == 1)
    {
      b(localc);
      AppMethodBeat.o(102560);
      return;
    }
    a(localc);
    AppMethodBeat.o(102560);
  }
  
  public static void a(aca paramaca, g paramg, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(102561);
    if ((paramInt == 1) && ((bo.isNullOrNil(paramaca.wSE)) || (bo.isNullOrNil(paramaca.wSC))))
    {
      ab.e("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo, type recv, cdndataurl must not be null!");
      AppMethodBeat.o(102561);
      return;
    }
    if ((paramInt == 0) && (bo.isNullOrNil(b(paramaca))))
    {
      ab.e("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo, type send, path must not be null!");
      AppMethodBeat.o(102561);
      return;
    }
    if (((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().NP(paramaca.mBq) != null)
    {
      ab.v("MicroMsg.Fav.FavApiLogic", "cdn info exist, id[%s], return", new Object[] { paramaca.mBq });
      AppMethodBeat.o(102561);
      return;
    }
    ab.i("MicroMsg.Fav.FavApiLogic", "insert cdn data info, fav local id[%d] fav id[%d]", new Object[] { Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
    c localc = new c();
    localc.field_dataId = paramaca.mBq;
    localc.field_totalLen = ((int)paramaca.wSX);
    localc.field_type = paramInt;
    localc.field_favLocalId = paramg.field_localId;
    localc.field_cdnKey = paramaca.wSE;
    localc.field_cdnUrl = paramaca.wSC;
    localc.field_path = b(paramaca);
    int i;
    label269:
    boolean bool;
    if (paramaca.dataType == 3)
    {
      paramaca = paramaca.wSR;
      label425:
      if ((!bo.isNullOrNil(paramaca)) && (paramaca.equals("speex")))
      {
        i = -3;
        localc.field_dataType = i;
        localc.field_modifyTime = bo.aoy();
        bool = at.isWifi(com.tencent.mm.sdk.platformtools.ah.getContext());
        if (paramInt == 0)
        {
          ab.i("MicroMsg.Fav.FavApiLogic", "can auto upload, force %B, isWifi %B, dataType %d, totalLen %d", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), Integer.valueOf(localc.field_dataType), Integer.valueOf(localc.field_totalLen) });
          if (!paramBoolean) {
            break label525;
          }
          i = 1;
          label345:
          if (i == 0) {
            break label652;
          }
          localc.field_status = 1;
          ab.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo upload status traning");
        }
        label364:
        if (paramInt == 1)
        {
          ab.i("MicroMsg.Fav.FavApiLogic", "can auto download, force %B, isWifi %B, dataType %d, totalLen %d", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), Integer.valueOf(localc.field_dataType), Integer.valueOf(localc.field_totalLen) });
          if (!paramBoolean) {
            break label669;
          }
          i = 1;
          if (i == 0) {
            break label782;
          }
          localc.field_status = 1;
          ab.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo download status traning");
        }
      }
    }
    for (;;)
    {
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().e(localc);
      if (paramInt != 1) {
        break label799;
      }
      b(localc);
      AppMethodBeat.o(102561);
      return;
      if ((!bo.isNullOrNil(paramaca)) && (paramaca.equals("silk")))
      {
        i = -4;
        break;
      }
      i = -2;
      break;
      localc.field_dataType = paramaca.dataType;
      break label269;
      label525:
      if (bool)
      {
        i = 1;
        break label345;
      }
      if ((localc.field_dataType != 8) && (localc.field_dataType != 4) && (localc.field_dataType != 15))
      {
        i = 1;
        break label345;
      }
      long l2 = com.tencent.mm.sdk.platformtools.ah.getContext().getSharedPreferences(com.tencent.mm.sdk.platformtools.ah.dsP(), 0).getLong("fav_mx_auto_upload_size", 0L);
      long l1 = l2;
      if (l2 == 0L) {
        l1 = 26214400L;
      }
      if (localc.field_totalLen <= l1)
      {
        ab.i("MicroMsg.Fav.FavApiLogic", "match max auto upload, max size %d", new Object[] { Long.valueOf(l1) });
        i = 1;
        break label345;
      }
      i = 0;
      break label345;
      label652:
      localc.field_status = 4;
      ab.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo upload status pause");
      break label364;
      label669:
      if (bool)
      {
        i = 1;
        break label425;
      }
      if ((localc.field_dataType != 8) && (localc.field_dataType != 4) && (localc.field_dataType != 15))
      {
        i = 1;
        break label425;
      }
      l1 = com.tencent.mm.sdk.platformtools.ah.getContext().getSharedPreferences(com.tencent.mm.sdk.platformtools.ah.dsP(), 0).getLong("fav_mx_auto_download_size", 26214400L);
      if (localc.field_totalLen <= l1)
      {
        ab.i("MicroMsg.Fav.FavApiLogic", "match max auto download, max size %d", new Object[] { Long.valueOf(l1) });
        i = 1;
        break label425;
      }
      i = 0;
      break label425;
      label782:
      localc.field_status = 4;
      ab.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo download status pause");
    }
    label799:
    a(localc);
    AppMethodBeat.o(102561);
  }
  
  public static boolean a(long paramLong, Runnable paramRunnable)
  {
    AppMethodBeat.i(102595);
    boolean bool = a(((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(paramLong), true, paramRunnable);
    AppMethodBeat.o(102595);
    return bool;
  }
  
  public static boolean a(g paramg, boolean paramBoolean, Runnable paramRunnable)
  {
    AppMethodBeat.i(102552);
    if (paramg == null)
    {
      ab.w("MicroMsg.Fav.FavApiLogic", "delete fav item fail, item is null");
      com.tencent.mm.sdk.platformtools.al.d(paramRunnable);
      AppMethodBeat.o(102552);
      return false;
    }
    if (Looper.myLooper() == com.tencent.mm.kernel.g.RO().oNc.getLooper())
    {
      ab.i("MicroMsg.Fav.FavApiLogic", "delete favItem id %d, localId %d, needBatchDel %B, do directly", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), Boolean.valueOf(paramBoolean) });
      a(paramg, paramBoolean);
      com.tencent.mm.sdk.platformtools.al.d(paramRunnable);
    }
    for (;;)
    {
      AppMethodBeat.o(102552);
      return true;
      ab.i("MicroMsg.Fav.FavApiLogic", "delete favItem id %d, localId %d, needBatchDel %B, post to worker", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), Boolean.valueOf(paramBoolean) });
      com.tencent.mm.kernel.g.RO().ac(new b.2(paramg, paramBoolean, paramRunnable));
    }
  }
  
  public static String[] a(g paramg, ak paramak)
  {
    Object localObject2 = null;
    AppMethodBeat.i(102618);
    if (paramg == null)
    {
      ab.w("MicroMsg.Fav.FavApiLogic", "GetThumbUrlAndLocalPath favItemInfo is null");
      AppMethodBeat.o(102618);
      return null;
    }
    aca localaca = c(paramg);
    String[] arrayOfString = new String[2];
    b.3 local3 = new b.3(paramg, localaca);
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
      if (localaca != null)
      {
        arrayOfString[0] = c(localaca);
        arrayOfString[1] = localaca.cpH;
        paramak.post(local3);
      }
    case 5: 
    case 10: 
    case 15: 
    case 11: 
      for (;;)
      {
        ab.d("MicroMsg.Fav.FavApiLogic", "GetThumbUrlAndLocalPath thumbPath %s, thumbUrl %s, type %d", new Object[] { arrayOfString[0], arrayOfString[1], Integer.valueOf(paramg.field_type) });
        AppMethodBeat.o(102618);
        return arrayOfString;
        localObject1 = paramg.field_favProto.wUf;
        if (localaca == null)
        {
          if (localObject1 != null) {
            arrayOfString[1] = ((adf)localObject1).thumbUrl;
          }
        }
        else
        {
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = ((adf)localObject1).thumbUrl)
          {
            localObject2 = localObject1;
            if (bo.isNullOrNil((String)localObject1)) {
              localObject2 = localaca.cpH;
            }
            arrayOfString[0] = c(localaca);
            arrayOfString[1] = localObject2;
            paramak.post(local3);
            break;
          }
          paramak = paramg.field_favProto.wUh;
          if (paramak != null)
          {
            arrayOfString[1] = paramak.thumbUrl;
            continue;
            paramak = paramg.field_favProto.wUj;
            if (paramak != null)
            {
              arrayOfString[1] = paramak.thumbUrl;
              continue;
              paramak = paramg.field_favProto.wUh;
              if (paramak != null) {
                arrayOfString[1] = paramak.thumbUrl;
              }
            }
          }
        }
      }
    }
    if (paramg.field_favProto.wVc != null)
    {
      Iterator localIterator = paramg.field_favProto.wVc.iterator();
      label375:
      localObject1 = localObject2;
      if (localIterator.hasNext())
      {
        localObject1 = (aca)localIterator.next();
        if (((aca)localObject1).dataType != 2) {
          break label435;
        }
        localObject1 = b((aca)localObject1);
        paramak.post(local3);
      }
    }
    for (;;)
    {
      arrayOfString[0] = localObject1;
      arrayOfString[1] = localaca.cpH;
      break;
      label435:
      if (((aca)localObject1).dataType != 15) {
        break label375;
      }
      localObject1 = c((aca)localObject1);
      paramak.post(local3);
    }
  }
  
  public static String aJ(float paramFloat)
  {
    AppMethodBeat.i(102579);
    if (paramFloat < 1024.0F)
    {
      str = String.format("%.1fB", new Object[] { Float.valueOf(paramFloat) });
      AppMethodBeat.o(102579);
      return str;
    }
    if (paramFloat < 1048576.0F)
    {
      str = String.format("%.1fKB", new Object[] { Float.valueOf(paramFloat / 1024.0F) });
      AppMethodBeat.o(102579);
      return str;
    }
    if (paramFloat < 1.073742E+009F)
    {
      str = String.format("%.1fMB", new Object[] { Float.valueOf(paramFloat / 1024.0F / 1024.0F) });
      AppMethodBeat.o(102579);
      return str;
    }
    String str = String.format("%.1fGB", new Object[] { Float.valueOf(paramFloat / 1024.0F / 1024.0F / 1024.0F) });
    AppMethodBeat.o(102579);
    return str;
  }
  
  public static long b(g paramg)
  {
    AppMethodBeat.i(102528);
    if (paramg == null)
    {
      AppMethodBeat.o(102528);
      return 0L;
    }
    paramg = paramg.field_favProto.wVc.iterator();
    aca localaca;
    for (int i = 0; paramg.hasNext(); i = (int)(localaca.wSX + l))
    {
      localaca = (aca)paramg.next();
      l = i;
    }
    long l = i;
    AppMethodBeat.o(102528);
    return l;
  }
  
  public static String b(aca paramaca)
  {
    AppMethodBeat.i(102543);
    if (paramaca == null)
    {
      AppMethodBeat.o(102543);
      return "";
    }
    Object localObject2 = paramaca.mBq;
    if ((bo.isNullOrNil((String)localObject2)) || (!com.tencent.mm.kernel.g.RG()))
    {
      AppMethodBeat.o(102543);
      return "";
    }
    com.tencent.mm.vfs.b localb2 = Nx((String)localObject2);
    int j = 0;
    int i = j;
    com.tencent.mm.vfs.b localb1 = localb2;
    Object localObject1 = localObject2;
    if (paramaca.dataType == 8)
    {
      i = j;
      localb1 = localb2;
      localObject1 = localObject2;
      if (!bo.isNullOrNil(paramaca.title))
      {
        localObject1 = paramaca.title;
        localb1 = Nx(paramaca.mBq);
        i = 1;
      }
    }
    localObject2 = localObject1;
    if (paramaca.wSR != null)
    {
      localObject2 = localObject1;
      if (paramaca.wSR.trim().length() > 0)
      {
        localObject2 = localObject1;
        if (i == 0) {
          localObject2 = (String)localObject1 + "." + paramaca.wSR;
        }
      }
    }
    localObject1 = new com.tencent.mm.vfs.b(localb1, (String)localObject2);
    if ((((com.tencent.mm.vfs.b)localObject1).exists()) || (bo.isNullOrNil(paramaca.wST)))
    {
      paramaca = com.tencent.mm.vfs.j.p(((com.tencent.mm.vfs.b)localObject1).dQJ());
      AppMethodBeat.o(102543);
      return paramaca;
    }
    localObject2 = com.tencent.mm.a.g.w((paramaca.wST + paramaca.mBq).getBytes());
    if (bo.isNullOrNil((String)localObject2))
    {
      paramaca = com.tencent.mm.vfs.j.p(((com.tencent.mm.vfs.b)localObject1).dQJ());
      AppMethodBeat.o(102543);
      return paramaca;
    }
    localObject1 = localObject2;
    if (paramaca.wSR != null)
    {
      localObject1 = localObject2;
      if (paramaca.wSR.trim().length() > 0) {
        localObject1 = (String)localObject2 + "." + paramaca.wSR;
      }
    }
    localObject1 = new com.tencent.mm.vfs.b(localb1, (String)localObject1);
    if (((com.tencent.mm.vfs.b)localObject1).exists())
    {
      paramaca = com.tencent.mm.vfs.j.p(((com.tencent.mm.vfs.b)localObject1).dQJ());
      AppMethodBeat.o(102543);
      return paramaca;
    }
    localObject2 = paramaca.mBq;
    localObject1 = localObject2;
    if (paramaca.wSR != null)
    {
      localObject1 = localObject2;
      if (paramaca.wSR.trim().length() > 0) {
        localObject1 = (String)localObject2 + "." + paramaca.wSR;
      }
    }
    ab.d("MicroMsg.Fav.FavApiLogic", "use dataId.fmt, ".concat(String.valueOf(localObject1)));
    paramaca = com.tencent.mm.vfs.j.p(new com.tencent.mm.vfs.b(localb1, (String)localObject1).dQJ());
    AppMethodBeat.o(102543);
    return paramaca;
  }
  
  public static void b(Context paramContext, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(156804);
    a(paramContext, paramString, paramIntent, null);
    AppMethodBeat.o(156804);
  }
  
  private static void b(gi paramgi)
  {
    AppMethodBeat.i(102603);
    g localg = NE(paramgi.cuX.desc);
    if (localg == null)
    {
      AppMethodBeat.o(102603);
      return;
    }
    if ((localg.field_favProto != null) && (localg.field_favProto.wVc != null))
    {
      Iterator localIterator = localg.field_favProto.wVc.iterator();
      while (localIterator.hasNext())
      {
        aca localaca = (aca)localIterator.next();
        if (localaca.dataType == 20)
        {
          localaca.pz(true);
          localaca.py(true);
          localaca.anE("");
          localaca.anu("");
          localaca.anv("");
          localaca.ans("");
          localaca.ant("");
        }
      }
    }
    paramgi.cuX.cpT = localg.field_favProto;
    AppMethodBeat.o(102603);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(102558);
    int i = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().t(paramc.field_favLocalId, 1);
    ab.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, download data status:%d, favlocalId:%d", new Object[] { Integer.valueOf(i), Long.valueOf(paramc.field_favLocalId) });
    g localg = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(paramc.field_favLocalId);
    if (localg == null)
    {
      ab.e("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus iteminfo null");
      AppMethodBeat.o(102558);
      return;
    }
    if ((localg.bws()) || (localg.bwo()) || (localg.bwp()))
    {
      ab.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, status upload, skip. isWaitServerUpload:%b  isUploadding:%b  isUploadFailed:%b", new Object[] { Boolean.valueOf(localg.bws()), Boolean.valueOf(localg.bwo()), Boolean.valueOf(localg.bwp()) });
      AppMethodBeat.o(102558);
      return;
    }
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(102558);
      return;
      h.jV(localg.field_localId);
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().O(7, paramc.field_favLocalId);
      AppMethodBeat.o(102558);
      return;
      ab.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, error, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
      com.tencent.mm.plugin.report.service.h.qsU.e(10659, new Object[] { Integer.valueOf(1), Integer.valueOf(localg.field_type), Integer.valueOf(-5), Long.valueOf(b(localg)), Long.valueOf(h.jU(localg.field_localId)) });
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().O(8, paramc.field_favLocalId);
      AppMethodBeat.o(102558);
      return;
      ab.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus init, favLocalId:%d, favId:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id) });
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().O(10, paramc.field_favLocalId);
      AppMethodBeat.o(102558);
      return;
      ab.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus finish, favLocalId:%d, favId:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id) });
      com.tencent.mm.plugin.report.service.h.qsU.e(10659, new Object[] { Integer.valueOf(1), Integer.valueOf(localg.field_type), Integer.valueOf(0), Long.valueOf(b(localg)), Long.valueOf(h.jU(localg.field_localId)) });
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().O(10, paramc.field_favLocalId);
      AppMethodBeat.o(102558);
      return;
      ab.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus pause, favLocalId:%d, favId:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id) });
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().O(8, paramc.field_favLocalId);
    }
  }
  
  private static void b(g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(102605);
    ack localack = new ack();
    if (!paramBoolean) {
      localack.wUT = com.tencent.mm.model.r.Zn();
    }
    localack.wUU = com.tencent.mm.model.r.Zn();
    paramg.field_favProto.nH(bo.aox());
    paramg.field_favProto.a(localack);
    AppMethodBeat.o(102605);
  }
  
  public static void b(aca paramaca, int paramInt, long paramLong)
  {
    AppMethodBeat.i(102594);
    if (bo.isNullOrNil(paramaca.mBq))
    {
      AppMethodBeat.o(102594);
      return;
    }
    ab.i("MicroMsg.Fav.FavApiLogic", "restart cdndata download, dataId %s", new Object[] { paramaca.mBq });
    c localc = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().NP(paramaca.mBq);
    Object localObject = localc;
    if (localc != null) {
      if (localc.field_status != 3)
      {
        localObject = localc;
        if (localc.field_status != 4) {}
      }
      else
      {
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().b(localc, new String[] { "dataId" });
        localObject = null;
      }
    }
    if ((localObject != null) && (((c)localObject).field_type == 1))
    {
      ab.i("MicroMsg.Fav.FavApiLogic", "klem data not download completed.");
      ((c)localObject).field_status = 1;
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().a((c)localObject, new String[] { "dataId" });
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnService().NN(paramaca.mBq);
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnService().run();
      AppMethodBeat.o(102594);
      return;
    }
    localObject = new com.tencent.mm.vfs.b(b(paramaca));
    if ((!bo.isNullOrNil(paramaca.wSE)) && (!bo.isNullOrNil(paramaca.wSC)) && (!((com.tencent.mm.vfs.b)localObject).exists()))
    {
      ab.i("MicroMsg.Fav.FavApiLogic", "klem big img not exist, start download.");
      long l = System.currentTimeMillis();
      localObject = new g();
      ((g)localObject).field_localId = paramLong;
      ((g)localObject).field_id = -1;
      ((g)localObject).field_type = paramInt;
      a(paramaca, (g)localObject, 1, true);
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnService().NN(paramaca.mBq);
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnService().run();
      ab.i("MicroMsg.Fav.FavApiLogic", "insert cdn item use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
    AppMethodBeat.o(102594);
  }
  
  public static void bF(List<Integer> paramList)
  {
    AppMethodBeat.i(102536);
    if (paramList.size() == 0)
    {
      ab.e("MicroMsg.Fav.FavApiLogic", "setDeleted list null");
      AppMethodBeat.o(102536);
      return;
    }
    Set localSet = bvV();
    ab.i("MicroMsg.Fav.FavApiLogic", "setDeleted before del:%s", new Object[] { localSet.toString() });
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Integer localInteger = (Integer)paramList.next();
      ab.i("MicroMsg.Fav.FavApiLogic", "setDeleted id:%d, ret:%b", new Object[] { localInteger, Boolean.valueOf(localSet.remove(localInteger.toString())) });
    }
    ab.i("MicroMsg.Fav.FavApiLogic", "setDeleted after del:%s", new Object[] { localSet.toString() });
    c(localSet);
    AppMethodBeat.o(102536);
  }
  
  public static boolean bG(List<g> paramList)
  {
    AppMethodBeat.i(102550);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ab.w("MicroMsg.Fav.FavApiLogic", "delete fav item fail, item is null");
      AppMethodBeat.o(102550);
      return false;
    }
    Set localSet = bvV();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      g localg = (g)paramList.next();
      h(localg);
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavSearchStorage().kd(localg.field_localId);
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().z(localg);
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().jZ(localg.field_localId);
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavTagSetMgr().v(localg);
      localSet.add(localg.field_id);
      ab.d("MicroMsg.Fav.FavApiLogic", "delete id %d", new Object[] { Integer.valueOf(localg.field_id) });
    }
    c(localSet);
    bvX();
    AppMethodBeat.o(102550);
    return true;
  }
  
  private static Set<String> bvV()
  {
    AppMethodBeat.i(102538);
    Object localObject = (String)com.tencent.mm.kernel.g.RL().Ru().get(225282, "");
    ab.i("MicroMsg.Fav.FavApiLogic", "get need del IDs: %s", new Object[] { localObject });
    HashSet localHashSet = new HashSet();
    if (bo.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(102538);
      return localHashSet;
    }
    localObject = ((String)localObject).split(",");
    if ((localObject == null) || (localObject.length == 0))
    {
      AppMethodBeat.o(102538);
      return localHashSet;
    }
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localHashSet.add(localObject[i]);
      i += 1;
    }
    AppMethodBeat.o(102538);
    return localHashSet;
  }
  
  public static String bvW()
  {
    AppMethodBeat.i(102542);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.RM();
    localObject = com.tencent.mm.kernel.g.RL().eHR + "favorite/web/";
    AppMethodBeat.o(102542);
    return localObject;
  }
  
  public static void bvX()
  {
    AppMethodBeat.i(102546);
    Object localObject2 = bvV();
    if (((Set)localObject2).size() == 0)
    {
      ab.v("MicroMsg.Fav.FavApiLogic", "doBatchDel no item to delete");
      AppMethodBeat.o(102546);
      return;
    }
    ab.i("MicroMsg.Fav.FavApiLogic", "doBatchDel idList:%s", new Object[] { localObject2.toString() });
    Object localObject1 = new LinkedList();
    localObject2 = ((Set)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      try
      {
        ((LinkedList)localObject1).add(Integer.valueOf(bo.getInt(str, 0)));
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.Fav.FavApiLogic", localException, "", new Object[0]);
        ab.e("MicroMsg.Fav.FavApiLogic", "doBatchDel parseInt error:%s", new Object[] { localException.getMessage() });
      }
    }
    ab.i("MicroMsg.Fav.FavApiLogic", "doBatchDel after parse, total size %d", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()) });
    if (((LinkedList)localObject1).size() > 0)
    {
      localObject1 = new ag((LinkedList)localObject1);
      com.tencent.mm.kernel.g.Rc().a((m)localObject1, 0);
    }
    AppMethodBeat.o(102546);
  }
  
  public static void bvY()
  {
    AppMethodBeat.i(102563);
    if (0L >= msK)
    {
      ab.i("MicroMsg.Fav.FavApiLogic", "addTagWhenAddToFav,try to add tag ,but favLocalId is null, return");
      AppMethodBeat.o(102563);
      return;
    }
    g localg = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(msK);
    msK = 0L;
    if (localg == null)
    {
      ab.i("MicroMsg.Fav.FavApiLogic", "addTagWhenAddToFav,try to add tag ,but iteminfo is null, return");
      AppMethodBeat.o(102563);
      return;
    }
    ab.i("MicroMsg.Fav.FavApiLogic", "addTagWhenAddToFav ,go on");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_fav_scene", 5);
    localIntent.putExtra("key_fav_item_id", localg.field_localId);
    a(com.tencent.mm.sdk.platformtools.ah.getContext(), ".ui.FavTagEditUI", localIntent, null);
    AppMethodBeat.o(102563);
  }
  
  public static long bvZ()
  {
    AppMethodBeat.i(102564);
    long l2 = bwa() - bwb();
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 1024L;
    }
    AppMethodBeat.o(102564);
    return l1;
  }
  
  public static long bwa()
  {
    AppMethodBeat.i(102565);
    long l = ((Long)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yAB, Long.valueOf(0L))).longValue();
    AppMethodBeat.o(102565);
    return l;
  }
  
  public static long bwb()
  {
    AppMethodBeat.i(102566);
    long l = ((Long)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yAA, Long.valueOf(0L))).longValue();
    AppMethodBeat.o(102566);
    return l;
  }
  
  public static boolean bwc()
  {
    AppMethodBeat.i(102575);
    if (bwa() == 0L)
    {
      AppMethodBeat.o(102575);
      return false;
    }
    if (bvZ() < 52428800L)
    {
      AppMethodBeat.o(102575);
      return true;
    }
    AppMethodBeat.o(102575);
    return false;
  }
  
  public static String bwd()
  {
    AppMethodBeat.i(102581);
    String str = com.tencent.mm.kernel.g.RL().eHR + "favorite/music/";
    AppMethodBeat.o(102581);
    return str;
  }
  
  public static String bwe()
  {
    AppMethodBeat.i(102584);
    String str = com.tencent.mm.kernel.g.RL().eHR + "favorite/";
    AppMethodBeat.o(102584);
    return str;
  }
  
  public static String bwf()
  {
    AppMethodBeat.i(102585);
    String str = com.tencent.mm.kernel.g.RL().eHR + "favorite/voice/";
    AppMethodBeat.o(102585);
    return str;
  }
  
  public static boolean bwg()
  {
    AppMethodBeat.i(102592);
    if (ah.bwW() > 0)
    {
      AppMethodBeat.o(102592);
      return true;
    }
    AppMethodBeat.o(102592);
    return false;
  }
  
  public static boolean bwh()
  {
    AppMethodBeat.i(102599);
    if (bwa() == 0L)
    {
      AppMethodBeat.o(102599);
      return false;
    }
    if (bvZ() < 10485760L)
    {
      AppMethodBeat.o(102599);
      return true;
    }
    AppMethodBeat.o(102599);
    return false;
  }
  
  public static aca c(g paramg)
  {
    AppMethodBeat.i(102529);
    if (paramg == null)
    {
      paramg = new aca();
      AppMethodBeat.o(102529);
      return paramg;
    }
    if (paramg.field_favProto.wVc.size() == 0)
    {
      paramg = new aca();
      AppMethodBeat.o(102529);
      return paramg;
    }
    paramg = (aca)paramg.field_favProto.wVc.get(0);
    AppMethodBeat.o(102529);
    return paramg;
  }
  
  public static String c(aca paramaca)
  {
    AppMethodBeat.i(102548);
    if ((paramaca == null) || (bo.isNullOrNil(paramaca.mBq)))
    {
      AppMethodBeat.o(102548);
      return "";
    }
    paramaca = Ny(paramaca.mBq);
    paramaca = com.tencent.mm.vfs.j.p(new com.tencent.mm.vfs.b(Nx(paramaca), paramaca).dQJ());
    AppMethodBeat.o(102548);
    return paramaca;
  }
  
  public static void c(gi paramgi)
  {
    AppMethodBeat.i(102607);
    Object localObject2;
    Object localObject3;
    if (paramgi.cuX.cve == 1)
    {
      paramgi.cuY.path = jM(paramgi.cuX.cpM);
      localObject2 = paramgi.cuY;
      long l = paramgi.cuX.cpM;
      localObject3 = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(l);
      if ((localObject3 == null) || (((g)localObject3).field_favProto == null)) {
        paramgi = "";
      }
      for (;;)
      {
        label86:
        ((gi.b)localObject2).thumbPath = paramgi;
        AppMethodBeat.o(102607);
        return;
        if ((((g)localObject3).field_type != 18) || (((g)localObject3).field_favProto.wVc.size() > 1))
        {
          paramgi = ((g)localObject3).field_favProto.wVc.iterator();
          for (;;)
          {
            if (paramgi.hasNext())
            {
              aca localaca = (aca)paramgi.next();
              switch (localaca.dataType)
              {
              default: 
                break;
              case 2: 
                localObject1 = c(localaca);
                paramgi = (gi)localObject1;
                if (com.tencent.mm.vfs.e.cN((String)localObject1)) {
                  break label86;
                }
                paramgi = b(localaca);
                if (com.tencent.mm.vfs.e.cN(paramgi))
                {
                  com.tencent.mm.sdk.platformtools.d.c(paramgi, 150, 150, Bitmap.CompressFormat.JPEG, 90, (String)localObject1);
                  paramgi = c(localaca);
                  break label86;
                }
                if (localaca.wSx)
                {
                  a((g)localObject3, localaca);
                  paramgi = (gi)localObject1;
                  break label86;
                }
                if (localaca.wSD)
                {
                  a((g)localObject3, localaca, true);
                  break label86;
                }
                paramgi = "";
                break label86;
              }
            }
          }
        }
        paramgi = "";
      }
    }
    if (paramgi.cuX.cve == 2)
    {
      localObject1 = new g();
      ((g)localObject1).field_type = 2;
      localObject2 = new aca();
      ((aca)localObject2).anD(cj(localObject2.toString(), 2));
      localObject3 = b((aca)localObject2);
      ((aca)localObject2).anE((String)localObject3);
      ((aca)localObject2).MI(2);
      ((g)localObject1).field_favProto.wVc.add(localObject2);
      paramgi.cuY.path = g.s((g)localObject1);
      paramgi.cuY.thumbPath = ((String)localObject3);
      AppMethodBeat.o(102607);
      return;
    }
    if (paramgi.cuX.cve == 3)
    {
      localObject1 = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(paramgi.cuX.cpM);
      if (localObject1 != null) {
        paramgi.cuY.path = (com.tencent.mm.model.r.Zn() + ";" + ((g)localObject1).field_fromUser + ";" + ((g)localObject1).field_updateTime);
      }
      AppMethodBeat.o(102607);
      return;
    }
    if (paramgi.cuX.cve == 4)
    {
      b(paramgi);
      AppMethodBeat.o(102607);
      return;
    }
    if (paramgi.cuX.cve == 5)
    {
      a(paramgi);
      AppMethodBeat.o(102607);
      return;
    }
    if (paramgi.cuX.cve == 6)
    {
      localObject1 = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(paramgi.cuX.cpM);
      if (localObject1 == null)
      {
        paramgi.cuY.ret = 0;
        AppMethodBeat.o(102607);
        return;
      }
      paramgi = paramgi.cuY;
      if (((g)localObject1).field_id > 0) {}
      for (int i = 1;; i = 0)
      {
        paramgi.ret = i;
        AppMethodBeat.o(102607);
        return;
      }
    }
    Object localObject1 = new g();
    ((g)localObject1).field_type = 18;
    ((g)localObject1).field_favProto = paramgi.cuX.cpT;
    paramgi.cuY.path = g.s((g)localObject1);
    AppMethodBeat.o(102607);
  }
  
  public static void c(String paramString, Context paramContext)
  {
    AppMethodBeat.i(102613);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.Fav.FavApiLogic", "share image to friend fail, imgPath is null");
      AppMethodBeat.o(102613);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Retr_File_Name", paramString);
    localIntent.putExtra("Retr_Compress_Type", 0);
    localIntent.putExtra("Retr_Msg_Type", 0);
    com.tencent.mm.bq.d.f(paramContext, ".ui.transmit.MsgRetransmitUI", localIntent);
    AppMethodBeat.o(102613);
  }
  
  private static void c(Set<String> paramSet)
  {
    AppMethodBeat.i(102537);
    StringBuffer localStringBuffer = new StringBuffer();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      localStringBuffer.append((String)paramSet.next()).append(",");
    }
    paramSet = "";
    if (localStringBuffer.length() > 0) {
      paramSet = localStringBuffer.substring(0, localStringBuffer.length() - 1);
    }
    ab.i("MicroMsg.Fav.FavApiLogic", "set need del IDs: %s", new Object[] { paramSet });
    com.tencent.mm.kernel.g.RL().Ru().set(225282, paramSet);
    AppMethodBeat.o(102537);
  }
  
  public static String cj(String paramString, int paramInt)
  {
    AppMethodBeat.i(102525);
    paramString = com.tencent.mm.a.g.w((paramString + paramInt + System.currentTimeMillis()).getBytes());
    AppMethodBeat.o(102525);
    return paramString;
  }
  
  public static void d(g paramg)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(102534);
        if ((paramg == null) || (paramg.field_type != 18))
        {
          AppMethodBeat.o(102534);
          return;
        }
        if (!msJ.containsKey(Long.valueOf(paramg.field_localId)))
        {
          AppMethodBeat.o(102534);
          continue;
        }
        if (msJ.get(Long.valueOf(paramg.field_localId)) == null) {
          break label101;
        }
      }
      finally {}
      if (((ArrayList)msJ.get(Long.valueOf(paramg.field_localId))).size() == 0)
      {
        label101:
        AppMethodBeat.o(102534);
      }
      else
      {
        String str = jM(paramg.field_localId);
        ab.i("MicroMsg.Fav.FavApiLogic", "checkUpdateSnsNotePostXml, resend favlocal id:%d,xml:%s", new Object[] { Long.valueOf(paramg.field_localId), str });
        pd localpd = new pd();
        localpd.cFL.cFM = ((ArrayList)msJ.get(Long.valueOf(paramg.field_localId)));
        localpd.cFL.cFN = str;
        com.tencent.mm.sdk.b.a.ymk.l(localpd);
        msJ.remove(Long.valueOf(paramg.field_localId));
        AppMethodBeat.o(102534);
      }
    }
  }
  
  public static void d(aca paramaca)
  {
    AppMethodBeat.i(102573);
    c localc = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().NP(paramaca.mBq);
    if ((localc != null) && (localc.field_status != 3))
    {
      localc.field_status = 2;
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnService().pauseDownload(paramaca.mBq);
    }
    localc = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().NP(Ny(paramaca.mBq));
    if ((localc != null) && (localc.field_status != 3))
    {
      localc.field_status = 2;
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnService().pauseDownload(Ny(paramaca.mBq));
    }
    AppMethodBeat.o(102573);
  }
  
  public static void d(String paramString, Context paramContext)
  {
    AppMethodBeat.i(102614);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.Fav.FavApiLogic", "share image to timeline fail, filePath is null");
      AppMethodBeat.o(102614);
      return;
    }
    Intent localIntent = new Intent();
    String str1 = "fav_" + com.tencent.mm.model.r.Zn() + "_0";
    String str2 = v.oQ(str1);
    v.aae().z(str2, true).i("prePublishId", str1);
    localIntent.putExtra("reportSessionId", str2);
    localIntent.putExtra("Ksnsupload_type", 0);
    localIntent.putExtra("sns_kemdia_path", paramString);
    com.tencent.mm.bq.d.b(paramContext, "sns", ".ui.SnsUploadUI", localIntent);
    AppMethodBeat.o(102614);
  }
  
  public static void e(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(102602);
    g localg = NE(paramString1);
    if (localg == null)
    {
      AppMethodBeat.o(102602);
      return;
    }
    li localli = new li();
    localli.cBr.type = 2;
    localli.cBr.field_localId = -1L;
    localli.cBr.context = paramContext;
    localli.cBr.cBx = 4;
    localli.cBr.cBz = true;
    paramContext = new Bundle();
    paramContext.putString("noteauthor", localg.field_favProto.wjV.wUT);
    paramContext.putString("noteeditor", localg.field_favProto.wjV.wUU);
    paramContext.putLong("edittime", localg.field_favProto.lsP);
    paramContext.putString("notexml", g.s(localg));
    paramContext.putString("snslocalid", paramString2);
    paramContext.putString("snsthumbpath", paramString3);
    paramContext.putString("snsnotelinkxml", paramString1);
    localli.cBr.cBw = paramContext;
    localli.cBr.field_favProto = localg.field_favProto;
    com.tencent.mm.sdk.b.a.ymk.l(localli);
    AppMethodBeat.o(102602);
  }
  
  public static void e(String paramString, Context paramContext)
  {
    AppMethodBeat.i(102616);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.Fav.FavApiLogic", "shareTextToFriend content null");
      AppMethodBeat.o(102616);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Retr_Msg_content", paramString);
    localIntent.putExtra("Retr_Msg_Type", 4);
    localIntent.putExtra("mutil_select_is_ret", true);
    com.tencent.mm.bq.d.f(paramContext, ".ui.transmit.MsgRetransmitUI", localIntent);
    AppMethodBeat.o(102616);
  }
  
  private static boolean e(g paramg)
  {
    AppMethodBeat.i(102535);
    if (paramg == null)
    {
      AppMethodBeat.o(102535);
      return false;
    }
    paramg = paramg.field_favProto.wVc.iterator();
    aca localaca;
    do
    {
      if (!paramg.hasNext()) {
        break;
      }
      localaca = (aca)paramg.next();
    } while (((localaca.dataType != 8) && (localaca.dataType != 4) && (localaca.dataType != 2) && (localaca.dataType != 3)) || ((!bo.isNullOrNil(localaca.wSC)) && (!bo.isNullOrNil(localaca.wSE))));
    for (boolean bool = false;; bool = true)
    {
      AppMethodBeat.o(102535);
      return bool;
    }
  }
  
  public static boolean e(aca paramaca)
  {
    AppMethodBeat.i(102580);
    com.tencent.mm.aw.e locale = com.tencent.mm.aw.a.aiz();
    if ((locale != null) && (locale.fKh == 6) && (bo.bf(paramaca.mBq, "").equals(locale.fKj)) && (com.tencent.mm.aw.a.aiw()))
    {
      AppMethodBeat.o(102580);
      return true;
    }
    AppMethodBeat.o(102580);
    return false;
  }
  
  private static String eo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(102524);
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(102524);
      return paramString2;
    }
    if (bo.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(102524);
      return paramString1;
    }
    paramString1 = paramString1 + "​" + paramString2;
    AppMethodBeat.o(102524);
    return paramString1;
  }
  
  public static boolean f(g paramg)
  {
    AppMethodBeat.i(102545);
    if (paramg.field_favProto == null)
    {
      AppMethodBeat.o(102545);
      return false;
    }
    paramg = paramg.field_favProto.wVc.iterator();
    while (paramg.hasNext())
    {
      aca localaca = (aca)paramg.next();
      if (localaca.wTK == 2)
      {
        AppMethodBeat.o(102545);
        return true;
      }
      if (localaca.wTK == 1)
      {
        AppMethodBeat.o(102545);
        return true;
      }
    }
    AppMethodBeat.o(102545);
    return false;
  }
  
  public static boolean f(aca paramaca)
  {
    AppMethodBeat.i(102590);
    boolean bool = new com.tencent.mm.vfs.b(b(paramaca)).exists();
    AppMethodBeat.o(102590);
    return bool;
  }
  
  public static boolean g(g paramg)
  {
    if (paramg == null) {}
    while ((paramg.field_itemStatus != 8) && (paramg.field_itemStatus != 10) && (paramg.field_itemStatus != 7)) {
      return false;
    }
    return true;
  }
  
  public static boolean g(aca paramaca)
  {
    AppMethodBeat.i(102591);
    boolean bool = com.tencent.mm.sdk.platformtools.r.aoY(b(paramaca));
    AppMethodBeat.o(102591);
    return bool;
  }
  
  public static String getAppName(Context paramContext, String paramString)
  {
    AppMethodBeat.i(102582);
    ad.b localb = ad.a.flG;
    if (localb != null)
    {
      paramContext = localb.t(paramContext, paramString);
      AppMethodBeat.o(102582);
      return paramContext;
    }
    AppMethodBeat.o(102582);
    return "";
  }
  
  private static void h(g paramg)
  {
    AppMethodBeat.i(102547);
    Set localSet = an.muC;
    paramg = paramg.field_favProto.wVc;
    int i = 0;
    while (i < paramg.size())
    {
      String str = c((aca)paramg.get(i));
      if ((localSet == null) || (!localSet.contains(str))) {
        com.tencent.mm.vfs.e.deleteFile(str);
      }
      str = b((aca)paramg.get(i));
      if ((localSet == null) || (!localSet.contains(str))) {
        com.tencent.mm.vfs.e.deleteFile(str);
      }
      i += 1;
    }
    AppMethodBeat.o(102547);
  }
  
  public static float hi(long paramLong)
  {
    float f2 = 60.0F;
    float f1 = 1.0F;
    AppMethodBeat.i(102576);
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
        AppMethodBeat.o(102576);
        return f1;
      }
      f1 = f3;
    }
  }
  
  public static boolean i(g paramg)
  {
    AppMethodBeat.i(102553);
    boolean bool = a(paramg, true, null);
    AppMethodBeat.o(102553);
    return bool;
  }
  
  public static void j(g paramg)
  {
    AppMethodBeat.i(102554);
    j localj = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavSearchStorage().ke(paramg.field_localId);
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
      if (paramg.field_favProto.wVa != null)
      {
        localObject1 = paramg.field_favProto.wVa;
        if (!bo.isNullOrNil(((acw)localObject1).czp))
        {
          localStringBuffer.append(((acw)localObject1).czp);
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(((acw)localObject1).czp);
          if (localObject2 != null) {
            localStringBuffer.append(((aq)localObject2).field_nickname).append(((aq)localObject2).field_conRemark);
          }
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(((acw)localObject1).toUser);
          if (localObject2 != null) {
            localStringBuffer.append(((aq)localObject2).field_nickname).append(((aq)localObject2).field_conRemark);
          }
          localStringBuffer.append(((acw)localObject1).wUA);
        }
      }
      Object localObject1 = paramg.field_favProto.wVc;
      localj.field_subtype = 0;
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (aca)((Iterator)localObject1).next();
        if (((aca)localObject2).desc != null) {
          localStringBuffer.append(((aca)localObject2).desc);
        }
        if (((aca)localObject2).title != null) {
          localStringBuffer.append(((aca)localObject2).title);
        }
        int j = ((aca)localObject2).dataType;
        int k = localj.field_subtype;
        localj.field_subtype = (j.vS(j) | k);
      }
      if (paramg.field_favProto.wUf != null)
      {
        if (paramg.field_favProto.wUf.desc != null) {
          localStringBuffer.append(paramg.field_favProto.wUf.desc);
        }
        if (paramg.field_favProto.wUf.title != null) {
          localStringBuffer.append(paramg.field_favProto.wUf.title);
        }
      }
      if (paramg.field_favProto.wUh != null)
      {
        if (paramg.field_favProto.wUh.desc != null) {
          localStringBuffer.append(paramg.field_favProto.wUh.desc);
        }
        if (paramg.field_favProto.wUh.title != null) {
          localStringBuffer.append(paramg.field_favProto.wUh.title);
        }
      }
      localj.field_tagContent = "";
      localObject1 = paramg.field_tagProto.wVp.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localj.field_tagContent = (localj.field_tagContent + " " + (String)localObject2);
        localStringBuffer.append((String)localObject2);
      }
      localObject1 = paramg.field_tagProto.wVq.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localj.field_tagContent = (localj.field_tagContent + " " + (String)localObject2);
        localStringBuffer.append((String)localObject2);
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavTagSetMgr().NK((String)localObject2);
      }
      localj.field_content = localStringBuffer.toString();
      localj.field_time = paramg.field_updateTime;
      localj.field_type = paramg.field_type;
      if (i != 0)
      {
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavSearchStorage().a(localj);
        AppMethodBeat.o(102554);
        return;
      }
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavSearchStorage().a(localj, new String[] { "localId" });
      AppMethodBeat.o(102554);
      return;
    }
  }
  
  public static void jK(long paramLong)
  {
    AppMethodBeat.i(102530);
    ab.i("MicroMsg.Fav.FavApiLogic", "setUsedCapacity:%d", new Object[] { Long.valueOf(paramLong) });
    com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yAA, Long.valueOf(paramLong));
    AppMethodBeat.o(102530);
  }
  
  public static void jL(long paramLong)
  {
    AppMethodBeat.i(102531);
    ab.i("MicroMsg.Fav.FavApiLogic", "setTotalCapacity:%d", new Object[] { Long.valueOf(paramLong) });
    com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yAB, Long.valueOf(paramLong));
    AppMethodBeat.o(102531);
  }
  
  private static String jM(long paramLong)
  {
    AppMethodBeat.i(102532);
    StringBuilder localStringBuilder = new StringBuilder();
    g localg = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(paramLong);
    if ((localg == null) || (localg.field_favProto == null) || (localg.field_favProto.wVc.size() <= 1))
    {
      AppMethodBeat.o(102532);
      return "";
    }
    ack localack = localg.field_favProto.wjV;
    String str2 = "";
    String str1 = "";
    if (localack != null)
    {
      str2 = localack.wUU;
      str1 = localack.wUT;
    }
    localStringBuilder.append("<noteinfo>");
    localStringBuilder.append("<noteauthor>").append(str1).append("</noteauthor>");
    localStringBuilder.append("<noteeditor>").append(str2).append("</noteeditor>");
    localStringBuilder.append("<edittime>").append(localg.field_favProto.lsP).append("</edittime>");
    localStringBuilder.append("<favlocalid>").append(localg.field_localId).append("</favlocalid>");
    localStringBuilder.append(com.tencent.mm.plugin.fav.a.a.a.bH(localg.field_favProto.wVc).replace("cdn_dataurl", "cdndataurl").replace("cdn_datakey", "cdndatakey").replace("cdn_thumburl", "cdnthumburl").replace("cdn_thumbkey", "cdnthumbkey").replace("thumbfullsize", "thumbsize").replace("fullsize", "datasize").replace("datasrcname", "sourcename").replace("datasrctime", "sourcetime").replace("stream_lowbandurl", "streamlowbandurl").replace("stream_dataurl", "streamdataurl").replace("stream_weburl", "streamweburl"));
    localStringBuilder.append("</noteinfo>");
    str1 = localStringBuilder.toString();
    AppMethodBeat.o(102532);
    return str1;
  }
  
  public static void jN(long paramLong)
  {
    AppMethodBeat.i(102539);
    com.tencent.mm.sdk.platformtools.ah.getContext().getSharedPreferences(com.tencent.mm.sdk.platformtools.ah.dsP(), 0).edit().putLong("fav_mx_auto_download_size", paramLong).commit();
    AppMethodBeat.o(102539);
  }
  
  public static void jO(long paramLong)
  {
    AppMethodBeat.i(102540);
    com.tencent.mm.sdk.platformtools.ah.getContext().getSharedPreferences(com.tencent.mm.sdk.platformtools.ah.dsP(), 0).edit().putLong("fav_mx_auto_upload_size", paramLong).commit();
    AppMethodBeat.o(102540);
  }
  
  public static void jP(long paramLong)
  {
    AppMethodBeat.i(102541);
    com.tencent.mm.sdk.platformtools.ah.getContext().getSharedPreferences(com.tencent.mm.sdk.platformtools.ah.dsP(), 0).edit().putLong("fav_mx_file_size", paramLong).commit();
    AppMethodBeat.o(102541);
  }
  
  public static void jQ(long paramLong)
  {
    msK = paramLong;
  }
  
  public static float jR(long paramLong)
  {
    float f1 = 1.0F;
    AppMethodBeat.i(102577);
    float f2 = (float)paramLong / 1000.0F;
    if (f2 < 1.0F) {}
    for (;;)
    {
      f1 = Math.round(f1);
      AppMethodBeat.o(102577);
      return f1;
      f1 = f2;
    }
  }
  
  public static String jS(long paramLong)
  {
    AppMethodBeat.i(102578);
    if (paramLong == 0L)
    {
      AppMethodBeat.o(102578);
      return "0KB";
    }
    String str;
    if (paramLong * 1.0D / 1048576.0D >= 1.0D)
    {
      str = String.format("%dMB", new Object[] { Integer.valueOf((int)(paramLong * 1.0D / 1048576.0D)) });
      AppMethodBeat.o(102578);
      return str;
    }
    if (paramLong * 1.0D / 1024.0D >= 1.0D)
    {
      str = String.format("%dKB", new Object[] { Integer.valueOf((int)(paramLong * 1.0D / 1024.0D)) });
      AppMethodBeat.o(102578);
      return str;
    }
    AppMethodBeat.o(102578);
    return "1KB";
  }
  
  public static boolean k(g paramg)
  {
    AppMethodBeat.i(102562);
    if (((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(paramg.field_localId) != null)
    {
      AppMethodBeat.o(102562);
      return true;
    }
    AppMethodBeat.o(102562);
    return false;
  }
  
  public static void l(g paramg)
  {
    AppMethodBeat.i(102569);
    if (!paramg.bwp())
    {
      ab.f("MicroMsg.Fav.FavApiLogic", "restartItemUpload status not upload failed!");
      AppMethodBeat.o(102569);
      return;
    }
    switch (paramg.field_itemStatus)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(102569);
      return;
      paramg.field_itemStatus = 1;
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getCheckCdnService().run();
      AppMethodBeat.o(102569);
      return;
      if (((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().jW(paramg.field_localId).size() == 0)
      {
        paramg.field_itemStatus = 9;
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
        paramg = new af(paramg);
        com.tencent.mm.kernel.g.Rc().a(paramg, 0);
        AppMethodBeat.o(102569);
        return;
      }
      paramg.field_itemStatus = 4;
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().x(paramg);
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
      Iterator localIterator = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().jW(paramg.field_localId).iterator();
      c localc;
      while (localIterator.hasNext())
      {
        localc = (c)localIterator.next();
        ab.i("MicroMsg.Fav.FavApiLogic", "force upload favItem[last failed], favid:%d localId:%d, dataId:%s, dataType:%d totalLength %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), localc.field_dataId, Integer.valueOf(localc.field_dataType), Integer.valueOf(localc.field_totalLen) });
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnService().NN(localc.field_dataId);
      }
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnService().run();
      AppMethodBeat.o(102569);
      return;
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().O(12, paramg.field_localId);
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getSendService().run();
      AppMethodBeat.o(102569);
      return;
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().O(15, paramg.field_localId);
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().x(paramg);
      localIterator = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().jW(paramg.field_localId).iterator();
      while (localIterator.hasNext())
      {
        localc = (c)localIterator.next();
        ab.i("MicroMsg.Fav.FavApiLogic", "force upload favItem[last mod failed], favid:%d localId:%d, dataId:%s, dataType:%d totalLength %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), localc.field_dataId, Integer.valueOf(localc.field_dataType), Integer.valueOf(localc.field_totalLen) });
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnService().NN(localc.field_dataId);
      }
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnService().run();
      AppMethodBeat.o(102569);
      return;
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().O(17, paramg.field_localId);
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getModService().run();
      AppMethodBeat.o(102569);
      return;
      paramg.field_itemStatus = 9;
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getSendService().run();
    }
  }
  
  public static void m(g paramg)
  {
    AppMethodBeat.i(102570);
    if (paramg == null)
    {
      AppMethodBeat.o(102570);
      return;
    }
    if ((paramg.field_itemStatus == 8) || (paramg.field_itemStatus == 10))
    {
      paramg.field_itemStatus = 7;
      Object localObject = paramg.field_favProto.wVc;
      if (((List)localObject).size() == 0)
      {
        AppMethodBeat.o(102570);
        return;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        aca localaca = (aca)((Iterator)localObject).next();
        a(paramg, localaca, true);
        a(paramg, localaca);
      }
      AppMethodBeat.o(102570);
      return;
    }
    ab.e("MicroMsg.Fav.FavApiLogic", "status not download failed or done!");
    AppMethodBeat.o(102570);
  }
  
  public static void n(g paramg)
  {
    AppMethodBeat.i(102574);
    if (!paramg.bwo())
    {
      ab.e("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, not uploading");
      AppMethodBeat.o(102574);
      return;
    }
    ab.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, itemStatu:%d", new Object[] { Integer.valueOf(paramg.field_itemStatus) });
    Iterator localIterator = paramg.field_favProto.wVc.iterator();
    while (localIterator.hasNext())
    {
      aca localaca = (aca)localIterator.next();
      c localc = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().NP(localaca.mBq);
      if ((localc != null) && (localc.field_status != 3))
      {
        localc.field_status = 2;
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnService().NO(localaca.mBq);
      }
      localc = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().NP(Ny(localaca.mBq));
      if ((localc != null) && (localc.field_status != 3))
      {
        localc.field_status = 2;
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnService().NO(Ny(localaca.mBq));
      }
    }
    paramg = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(paramg.field_localId);
    ab.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, after pause data itemStatu:%d", new Object[] { Integer.valueOf(paramg.field_itemStatus) });
    switch (paramg.field_itemStatus)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(102574);
      return;
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().O(3, paramg.field_localId);
      ab.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(3) });
      AppMethodBeat.o(102574);
      return;
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().O(6, paramg.field_localId);
      ab.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(6) });
      AppMethodBeat.o(102574);
      return;
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().O(11, paramg.field_localId);
      ab.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(11) });
      AppMethodBeat.o(102574);
      return;
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().O(14, paramg.field_localId);
      ab.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(14) });
      AppMethodBeat.o(102574);
      return;
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().O(16, paramg.field_localId);
      ab.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(16) });
      AppMethodBeat.o(102574);
      return;
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().O(18, paramg.field_localId);
      ab.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(18) });
    }
  }
  
  public static String nF(String paramString)
  {
    AppMethodBeat.i(102568);
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(paramString);
    if (localObject == null)
    {
      ab.w("MicroMsg.Fav.FavApiLogic", "wtf get contact null, username %s", new Object[] { paramString });
      AppMethodBeat.o(102568);
      return "";
    }
    String str = ((ad)localObject).Of();
    localObject = str;
    if (t.lA(str))
    {
      paramString = n.nt(paramString);
      localObject = com.tencent.mm.model.r.Zn();
      if ((paramString != null) && (!paramString.isEmpty())) {
        break label109;
      }
      ab.w("MicroMsg.Fav.FavApiLogic", "get members from username error, content empty");
    }
    for (localObject = str;; localObject = n.f(paramString, 3))
    {
      AppMethodBeat.o(102568);
      return localObject;
      label109:
      paramString.remove(localObject);
      paramString.add(0, localObject);
    }
  }
  
  public static boolean o(g paramg)
  {
    AppMethodBeat.i(102583);
    if (paramg == null)
    {
      AppMethodBeat.o(102583);
      return false;
    }
    aca localaca = c(paramg);
    if (localaca == null)
    {
      AppMethodBeat.o(102583);
      return false;
    }
    long l = bo.yB();
    com.tencent.mm.plugin.sight.base.a locala = com.tencent.mm.plugin.sight.base.d.Zo(b(localaca));
    int j;
    int i;
    boolean bool;
    if (locala != null)
    {
      j = locala.cmu();
      i = localaca.duration;
      if ((i <= 0) || (Math.abs(i - j) >= 2))
      {
        localaca.MH(j);
        bool = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.Fav.FavApiLogic", "repair video duration[%d TO %d] %b cost time %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool), Long.valueOf(bo.av(l)) });
      AppMethodBeat.o(102583);
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
    AppMethodBeat.i(102596);
    j localj = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavSearchStorage().ke(paramg.field_localId);
    if (localj == null)
    {
      localj = new j();
      localj.field_localId = paramg.field_localId;
    }
    for (int i = 1;; i = 0)
    {
      localj.field_tagContent = "";
      Iterator localIterator = paramg.field_tagProto.wVp.iterator();
      String str;
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        localj.field_tagContent = (localj.field_tagContent + " " + str);
      }
      localIterator = paramg.field_tagProto.wVq.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        localj.field_tagContent = (localj.field_tagContent + " " + str);
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavTagSetMgr().NK(str);
      }
      localj.field_content = "";
      localj.field_time = paramg.field_updateTime;
      localj.field_type = paramg.field_type;
      if (i != 0)
      {
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavSearchStorage().a(localj);
        AppMethodBeat.o(102596);
        return;
      }
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavSearchStorage().a(localj, new String[] { "localId" });
      AppMethodBeat.o(102596);
      return;
    }
  }
  
  public static void q(g paramg)
  {
    AppMethodBeat.i(102606);
    if (paramg == null)
    {
      AppMethodBeat.o(102606);
      return;
    }
    ack localack = paramg.field_favProto.wjV;
    if ((localack != null) && (!bo.isNullOrNil(localack.wUU)))
    {
      AppMethodBeat.o(102606);
      return;
    }
    if (paramg.field_type == 18)
    {
      if (paramg.field_favProto.wVa.cpG != 6) {
        break label113;
      }
      b(paramg, false);
    }
    for (;;)
    {
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
      AppMethodBeat.o(102606);
      return;
      label113:
      b(paramg, true);
    }
  }
  
  public static final String r(g paramg)
  {
    AppMethodBeat.i(102619);
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
      AppMethodBeat.o(102619);
      return paramg;
    case 2: 
    case 8: 
      paramg = paramg.field_favProto.wVc.iterator();
      l = 0L;
      if (paramg.hasNext())
      {
        localObject = (aca)paramg.next();
        if (localObject == null) {
          break label455;
        }
        l = ((aca)localObject).wSX + l;
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
        if (bo.isNullOrNil(paramg.field_favProto.desc)) {
          break;
        }
        localStringBuffer.append(paramg.field_favProto.desc.getBytes().length);
        break;
        localStringBuffer.append(c(paramg).duration);
        break;
        localObject = "";
        try
        {
          paramg = paramg.field_favProto.wUf.wVF;
          localStringBuffer.append(paramg);
          break;
          if (paramg == null) {
            break;
          }
          paramg = paramg.field_favProto.wVc.iterator();
          int i = 0;
          int m = 0;
          int k = 0;
          int j = 0;
          while (paramg.hasNext())
          {
            localObject = (aca)paramg.next();
            switch (((aca)localObject).dataType)
            {
            case 3: 
            default: 
              i += 1;
              break;
            case 1: 
              if (bo.isNullOrNil(((aca)localObject).desc)) {
                break label452;
              }
              k = ((aca)localObject).desc.getBytes().length + k;
              break;
            case 2: 
              m += 1;
              break;
            case 4: 
              j += 1;
            }
          }
          paramg = String.format("%d:%d:%d:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(i) });
          AppMethodBeat.o(102619);
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
  
  public static long s(long paramLong, int paramInt)
  {
    AppMethodBeat.i(102587);
    ab.i("MicroMsg.Fav.FavApiLogic", "tryStartBatchGet...");
    long l1 = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().y(paramLong, paramInt);
    long l2 = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().w(paramLong, paramInt);
    ab.v("MicroMsg.Fav.FavApiLogic", "klem, tryStartBatchGet, batchGetTime:%d, itemTiem:%d, updateTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(paramLong) });
    if (l1 == 0L)
    {
      AppMethodBeat.o(102587);
      return l2;
    }
    Object localObject = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().x(l1, paramInt);
    if (((LinkedList)localObject).size() > 0)
    {
      ab.i("MicroMsg.Fav.FavApiLogic", "klem, tryStartBatchGet, batchGetTime:%d, itemTiem:%d, updateTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(paramLong) });
      ab.i("MicroMsg.Fav.FavApiLogic", "klem, tryStartBatchGet, need batch get idList size:%d", new Object[] { Integer.valueOf(((LinkedList)localObject).size()) });
      localObject = new ah((LinkedList)localObject);
      if (!com.tencent.mm.kernel.g.Rc().a((m)localObject, 0))
      {
        ab.w("MicroMsg.Fav.FavApiLogic", "do scene BatchGetFav fail");
        ah.bwV();
      }
    }
    if (l2 == 0L)
    {
      AppMethodBeat.o(102587);
      return l1;
    }
    if (l1 < l2)
    {
      AppMethodBeat.o(102587);
      return l1;
    }
    AppMethodBeat.o(102587);
    return l2;
  }
  
  public static void startSync()
  {
    AppMethodBeat.i(102588);
    aj localaj = new aj();
    com.tencent.mm.kernel.g.Rc().a(localaj, 0);
    AppMethodBeat.o(102588);
  }
  
  public static void v(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(102615);
    if (paramContext != null)
    {
      paramIntent.putExtra("Ksnsupload_type", 1);
      com.tencent.mm.bq.d.b(paramContext, "sns", ".ui.SnsUploadUI", paramIntent);
    }
    AppMethodBeat.o(102615);
  }
  
  public static boolean vP(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = a.msH;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.b
 * JD-Core Version:    0.7.0.1
 */