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
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.gf;
import com.tencent.mm.h.a.gf.a;
import com.tencent.mm.h.a.gf.b;
import com.tencent.mm.h.a.ku;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.ac.b;
import com.tencent.mm.model.s;
import com.tencent.mm.model.u.b;
import com.tencent.mm.protocal.c.axi;
import com.tencent.mm.protocal.c.axl;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.xw;
import com.tencent.mm.protocal.c.ya;
import com.tencent.mm.protocal.c.yc;
import com.tencent.mm.protocal.c.yd;
import com.tencent.mm.protocal.c.yi;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yp;
import com.tencent.mm.protocal.c.ys;
import com.tencent.mm.protocal.c.yw;
import com.tencent.mm.protocal.c.yy;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
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
  private static HashMap<Long, ArrayList<String>> jYp = new HashMap();
  private static long jYq = 0L;
  
  public static int CA(String paramString)
  {
    if ((!bk.bl(paramString)) && (paramString.equals("speex"))) {
      return 1;
    }
    if ((!bk.bl(paramString)) && (paramString.equals("silk"))) {
      return 2;
    }
    return 0;
  }
  
  public static g CB(String paramString)
  {
    g localg = new g();
    localg.field_localId = -1L;
    localg.field_id = -1;
    localg.field_xml = paramString;
    localg.field_type = 18;
    localg.CD(paramString);
    return localg;
  }
  
  private static g CC(String paramString)
  {
    if ((paramString == null) || (paramString.equals("")))
    {
      y.e("MicroMsg.Fav.FavApiLogic", "parseSnsNoteInfoXml but xml is null");
      return null;
    }
    paramString = paramString.replace("cdndataurl", "cdn_dataurl").replace("cdndatakey", "cdn_datakey").replace("cdnthumburl", "cdn_thumburl").replace("cdnthumbkey", "cdn_thumbkey").replace("datasize", "fullsize").replace("thumbsize", "thumbfullsize").replace("sourcename", "datasrcname").replace("sourcetime", "datasrctime").replace("streamlowbandurl", "stream_lowbandurl").replace("streamdataurl", "stream_dataurl").replace("streamweburl", "stream_weburl");
    if (!paramString.startsWith("<noteinfo>")) {
      paramString = "<noteinfo>" + paramString + "</noteinfo>";
    }
    for (;;)
    {
      Map localMap = bn.s(paramString, "noteinfo");
      if (localMap == null)
      {
        y.e("MicroMsg.Fav.FavApiLogic", "parseSnsNoteInfoXml, FavItemInfo maps null");
        return null;
      }
      g localg = new g();
      try
      {
        localg.field_favProto = new yj();
        localg.field_type = 18;
        Object localObject = (String)localMap.get(".noteinfo.edittime");
        localg.field_favProto.hk(bk.getLong((String)localObject, 0L));
        localObject = new yd();
        ((yd)localObject).sWU = ((String)localMap.get(".noteinfo.noteeditor"));
        ((yd)localObject).sWT = ((String)localMap.get(".noteinfo.noteauthor"));
        localg.field_favProto.a((yd)localObject);
        localg.field_localId = bk.getLong((String)localMap.get(".noteinfo.favlocalid"), System.currentTimeMillis());
        com.tencent.mm.plugin.fav.a.a.b.a(paramString, localg.field_favProto);
        return localg;
      }
      catch (Exception paramString)
      {
        y.printErrStackTrace("MicroMsg.Fav.FavApiLogic", paramString, "", new Object[0]);
        y.e("MicroMsg.Fav.FavApiLogic", "parseSnsNoteInfoXml , FavItemInfo exception:+%s", new Object[] { paramString.toString() });
        return null;
      }
    }
  }
  
  private static com.tencent.mm.vfs.b Cv(String paramString)
  {
    int i = paramString.hashCode();
    paramString = new com.tencent.mm.vfs.b(String.format("%s/%s/%d/", new Object[] { com.tencent.mm.kernel.g.DP().dKt, "favorite", Integer.valueOf(i & 0xFF) }));
    if ((!paramString.exists()) || (!paramString.isDirectory())) {
      paramString.mkdirs();
    }
    return paramString;
  }
  
  public static String Cw(String paramString)
  {
    return paramString + "_t";
  }
  
  public static boolean Cx(String paramString)
  {
    if (bk.bl(paramString)) {
      return false;
    }
    return paramString.endsWith("_t");
  }
  
  public static String Cy(String paramString)
  {
    ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramString);
    if (localad != null)
    {
      if (!bk.bl(localad.field_conRemark)) {
        paramString = localad.field_conRemark;
      }
    }
    else {
      return paramString;
    }
    if (!bk.bl(localad.field_nickname)) {
      return localad.field_nickname;
    }
    return localad.field_username;
  }
  
  public static String Cz(String paramString)
  {
    if (bk.bl(paramString)) {}
    do
    {
      return null;
      paramString = new com.tencent.mm.vfs.b(aPI() + com.tencent.mm.a.g.o(paramString.getBytes()));
    } while (!paramString.exists());
    return com.tencent.mm.vfs.j.n(paramString.cLr());
  }
  
  public static long a(g paramg)
  {
    Object localObject = a.jYn;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      if (localObject[i] == paramg.field_type)
      {
        if (paramg.field_favProto != null)
        {
          localObject = paramg.field_favProto.sXc.iterator();
          for (long l1 = 0L;; l1 = ((xv)((Iterator)localObject).next()).sVb + l1)
          {
            l2 = l1;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
          }
        }
        long l2 = 0L;
        paramg.field_datatotalsize = l2;
        y.d("MicroMsg.Fav.FavApiLogic", "calFavItemInfoTotalLength id:%d,length:%d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(l2) });
        return l2;
      }
      i += 1;
    }
    return 0L;
  }
  
  public static g a(yj paramyj)
  {
    g localg = new g();
    localg.field_favProto = new yj();
    localg.field_type = 18;
    localg.field_favProto = paramyj;
    return localg;
  }
  
  public static xv a(g paramg, String paramString)
  {
    if ((bk.bl(paramString)) || (paramg == null) || (paramg.field_favProto.sXc.size() == 0)) {
      return null;
    }
    paramg = paramg.field_favProto.sXc.iterator();
    while (paramg.hasNext())
    {
      xv localxv = (xv)paramg.next();
      if (localxv.kgC.equals(paramString)) {
        return localxv;
      }
    }
    return null;
  }
  
  public static ya a(int paramInt, yj paramyj, yw paramyw)
  {
    if (paramyj == null) {
      y.w("MicroMsg.Fav.FavApiLogic", "proto item is null");
    }
    ya localya;
    do
    {
      return null;
      localya = new ya();
      yp localyp = paramyj.sXa;
      if (localyp != null)
      {
        localya.bRO = localyp.bRO;
        localya.sWM = localyp.sWB;
        localya.appId = localyp.appId;
        localya.bFn = localyp.bFn;
      }
      if (paramyw != null)
      {
        if (paramyw.sXp != null) {
          localya.sWN.addAll(paramyw.sXp);
        }
        if (paramyw.sXq != null) {
          localya.sWN.addAll(paramyw.sXq);
        }
      }
      localya.bWM = paramyj;
      localya.type = paramInt;
      switch (paramInt)
      {
      case 3: 
      case 9: 
      case 13: 
      case 16: 
      case 17: 
      default: 
        y.w("MicroMsg.Fav.FavApiLogic", "unknown type %d", new Object[] { Integer.valueOf(paramInt) });
        return localya;
      case 1: 
        localya.title = "";
        localya.desc = paramyj.desc;
        return localya;
      case 4: 
        if ((paramyj.sXc != null) && (!paramyj.sXc.isEmpty())) {
          localya.title = ((xv)paramyj.sXc.get(0)).title;
        }
        return localya;
      case 5: 
        if (paramyj.sWh != null)
        {
          localya.title = paramyj.sWh.title;
          localya.desc = paramyj.sWh.sXG;
        }
        if ((bk.bl(localya.title)) && (paramyj.sXc != null) && (!paramyj.sXc.isEmpty())) {
          localya.title = ((xv)paramyj.sXc.get(0)).title;
        }
        if ((bk.bl(localya.desc)) && (localyp != null)) {
          localya.desc = localyp.eAl;
        }
        return localya;
      case 6: 
        localya.title = paramyj.fGK;
        if (bk.bl(localya.title)) {
          if (paramyj.sWf != null)
          {
            localya.title = paramyj.sWf.bVA;
            localya.desc = paramyj.sWf.label;
          }
        }
        for (;;)
        {
          return localya;
          if (paramyj.sWf != null) {
            localya.desc = paramyj.sWf.bVA;
          }
        }
      case 2: 
        if ((paramyj.sXc != null) && (paramyj.sXc.size() > 0)) {
          localya.title = ((xv)paramyj.sXc.get(0)).title;
        }
        return localya;
      case 7: 
        if ((paramyj.sXc != null) && (!paramyj.sXc.isEmpty()))
        {
          localya.title = ((xv)paramyj.sXc.get(0)).title;
          localya.desc = ((xv)paramyj.sXc.get(0)).desc;
        }
        return localya;
      case 8: 
        localya.title = paramyj.title;
        if ((bk.bl(localya.title)) && (paramyj.sXc != null) && (!paramyj.sXc.isEmpty())) {
          localya.title = ((xv)paramyj.sXc.get(0)).title;
        }
        return localya;
      case 10: 
      case 11: 
        if (paramyj.sWj != null)
        {
          localya.title = paramyj.sWj.title;
          localya.desc = paramyj.sWj.desc;
        }
        return localya;
      case 12: 
      case 15: 
        if (paramyj.sWl != null)
        {
          localya.title = paramyj.sWl.title;
          localya.desc = paramyj.sWl.desc;
        }
        return localya;
      }
      paramyj = paramyj.sXc;
    } while (paramyj == null);
    paramyj = paramyj.iterator();
    while (paramyj.hasNext())
    {
      paramyw = (xv)paramyj.next();
      if (1 == paramyw.aYU) {
        localya.title = paramyw.desc;
      }
    }
    return localya;
  }
  
  public static String a(xv paramxv)
  {
    xw localxw = paramxv.sVA;
    String str = "";
    switch (paramxv.aYU)
    {
    case 2: 
    case 3: 
    case 7: 
    case 9: 
    default: 
      paramxv = cZ(cZ("", localxw.title), localxw.desc);
    case 1: 
    case 4: 
    case 5: 
    case 6: 
    case 10: 
    case 11: 
      do
      {
        do
        {
          do
          {
            do
            {
              return paramxv;
              return cZ("", paramxv.desc);
              paramxv = str;
            } while (localxw.sWl == null);
            return cZ("", localxw.sWl.title);
            paramxv = str;
          } while (localxw.sWh == null);
          return cZ("", localxw.sWh.title);
          str = cZ("", localxw.fGK);
          paramxv = str;
        } while (localxw.sWf == null);
        return cZ(cZ(str, localxw.sWf.bVA), localxw.sWf.label);
        paramxv = str;
      } while (localxw.sWj == null);
      return cZ(cZ("", localxw.sWj.title), localxw.sWj.desc);
    }
    return cZ("", localxw.title);
  }
  
  public static ArrayList<g> a(List<String> paramList1, List<String> paramList2, List<Integer> paramList, List<g> paramList3, Set<Integer> paramSet, w paramw)
  {
    paramList1 = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavSearchStorage().a(paramList1, paramList2, paramList);
    paramList2 = new ArrayList();
    if (paramList1.size() == 0) {
      return paramList2;
    }
    int i;
    for (int j = 0;; j = i)
    {
      Object localObject;
      if (j + 20 < paramList1.size())
      {
        i = j + 20;
        y.v("MicroMsg.Fav.FavApiLogic", "start:%d  end:%d listSize:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramList1.size()) });
        localObject = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().a(paramList1.subList(j, i), paramList3, paramSet, paramw);
        if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
          break label326;
        }
        if (paramList.contains(Integer.valueOf(8))) {
          localObject = ((ArrayList)localObject).iterator();
        }
      }
      else
      {
        for (;;)
        {
          label176:
          if (!((Iterator)localObject).hasNext()) {
            break label326;
          }
          g localg = (g)((Iterator)localObject).next();
          if (localg.field_type == 18) {
            for (;;)
            {
              try
              {
                LinkedList localLinkedList = localg.field_favProto.sXc;
                j = 1;
                if (j >= localLinkedList.size()) {
                  continue;
                }
                int k = ((xv)localLinkedList.get(j)).aYU;
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
                break label176;
              }
              paramList2.add(localg);
              break label176;
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
      label326:
      if (i >= paramList1.size()) {
        return paramList2;
      }
    }
  }
  
  public static List<g> a(long paramLong, int paramInt, Set<Integer> paramSet, w paramw)
  {
    if (paramLong == 0L) {
      return ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().a(paramInt, paramSet, paramw);
    }
    return ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().b(paramLong, paramInt, paramSet, paramw);
  }
  
  public static void a(long paramLong, yc paramyc, String paramString1, String paramString2, ArrayList<String> paramArrayList, Context paramContext)
  {
    if ((paramyc == null) || (paramContext == null)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("KFavLocSigleView", true);
    localIntent.putExtra("map_view_type", 2);
    localIntent.putExtra("kFavInfoLocalId", paramLong);
    localIntent.putExtra("kwebmap_slat", paramyc.lat);
    localIntent.putExtra("kwebmap_lng", paramyc.lng);
    localIntent.putExtra("kPoiName", paramyc.bVA);
    localIntent.putExtra("Kwebmap_locaion", paramyc.label);
    if (paramyc.bRv >= 0) {
      localIntent.putExtra("kwebmap_scale", paramyc.bRv);
    }
    localIntent.putExtra("kisUsername", paramString1);
    localIntent.putExtra("kwebmap_from_to", true);
    localIntent.putExtra("kRemark", paramString2);
    localIntent.putExtra("kTags", paramArrayList);
    localIntent.putExtra("kFavCanDel", true);
    localIntent.putExtra("kFavCanRemark", true);
    com.tencent.mm.br.d.b(paramContext, "location", ".ui.RedirectUI", localIntent);
  }
  
  public static void a(Context paramContext, String paramString, Intent paramIntent)
  {
    a(paramContext, paramString, paramIntent, null);
  }
  
  public static void a(Context paramContext, String paramString, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {}
    try
    {
      localIntent = new Intent();
      String str = com.tencent.mm.sdk.platformtools.ae.cqQ() + ".plugin.fav";
      paramIntent = paramString;
      if (paramString.startsWith(".")) {
        paramIntent = str + paramString;
      }
      localIntent.setClassName(com.tencent.mm.sdk.platformtools.ae.getPackageName(), paramIntent);
      Class.forName(paramIntent, false, paramContext.getClassLoader());
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).startActivityForResult(localIntent, paramInt, paramBundle);
      }
      return;
    }
    catch (Exception paramContext)
    {
      y.e("MicroMsg.Fav.FavApiLogic", "Class Not Found when startActivity %s", new Object[] { paramContext });
    }
  }
  
  public static void a(Context paramContext, String paramString, Intent paramIntent, Bundle paramBundle)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {}
    try
    {
      localIntent = new Intent();
      String str = com.tencent.mm.sdk.platformtools.ae.cqQ() + ".plugin.fav";
      paramIntent = paramString;
      if (paramString.startsWith(".")) {
        paramIntent = str + paramString;
      }
      localIntent.setClassName(com.tencent.mm.sdk.platformtools.ae.getPackageName(), paramIntent);
      Class.forName(paramIntent, false, paramContext.getClassLoader());
      if ((paramContext instanceof Activity))
      {
        paramContext.startActivity(localIntent, paramBundle);
        return;
      }
      localIntent.addFlags(268435456);
      paramContext.startActivity(localIntent, paramBundle);
      return;
    }
    catch (Exception paramContext)
    {
      y.e("MicroMsg.Fav.FavApiLogic", "Class Not Found when startActivity %s", new Object[] { paramContext });
    }
  }
  
  private static void a(gf paramgf)
  {
    if (bk.bl(paramgf.bNF.desc)) {
      paramgf.bNG.ret = -1;
    }
    String str;
    do
    {
      do
      {
        return;
        localObject = CC(paramgf.bNF.desc);
        if ((localObject == null) || (((g)localObject).field_localId <= 0L))
        {
          paramgf.bNG.ret = -1;
          return;
        }
        boolean bool = e((g)localObject);
        str = paramgf.bNF.bNL;
        if (!bool) {
          break;
        }
        paramgf.bNG.ret = 1;
        paramgf = (ArrayList)jYp.get(Long.valueOf(((g)localObject).field_localId));
      } while (paramgf == null);
      if (paramgf.contains(str)) {
        paramgf.remove(str);
      }
    } while (paramgf.size() != 0);
    jYp.remove(Long.valueOf(((g)localObject).field_localId));
    return;
    if (bk.bl(str))
    {
      paramgf.bNG.ret = -1;
      return;
    }
    long l = ((g)localObject).field_localId;
    if (jYp.get(Long.valueOf(l)) == null) {}
    for (Object localObject = new ArrayList();; localObject = (ArrayList)jYp.get(Long.valueOf(l)))
    {
      ((ArrayList)localObject).add(str);
      jYp.put(Long.valueOf(l), localObject);
      localObject = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(l);
      if ((localObject != null) && (((g)localObject).field_localId > 0L)) {
        break;
      }
      paramgf.bNG.ret = -1;
      return;
    }
    if ((e((g)localObject)) || (((g)localObject).field_itemStatus == 10))
    {
      paramgf.bNG.ret = -1;
      com.tencent.mm.kernel.g.DS().k(new b.1((g)localObject), 500L);
      return;
    }
    paramgf.bNG.ret = -1;
  }
  
  public static void a(c paramc)
  {
    int i = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().o(paramc.field_favLocalId, 0);
    y.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus, upload data status:%d, favlocalId:%d", new Object[] { Integer.valueOf(i), Long.valueOf(paramc.field_favLocalId) });
    g localg = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(paramc.field_favLocalId);
    if (localg == null)
    {
      y.e("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus iteminfo null");
      return;
    }
    if (localg.aQd())
    {
      y.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus waiting server upload skip.");
      return;
    }
    if ((paramc.field_status == 3) && (i != paramc.field_status) && (localg.field_type == 18) && (((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().CN(paramc.field_dataId).field_status == 3))
    {
      a(paramc, localg);
      return;
    }
    switch (i)
    {
    case 0: 
    default: 
      return;
    case 1: 
      if (localg.aQc()) {
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().x(15, paramc.field_favLocalId);
      }
      for (;;)
      {
        y.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus, continue upload data, favlocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
        return;
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().x(4, paramc.field_favLocalId);
      }
    case 4: 
      if (localg.aQc()) {
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().x(16, paramc.field_favLocalId);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.f(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(localg.field_type), Integer.valueOf(-5), Long.valueOf(b(localg)), Long.valueOf(h.ex(localg.field_localId)) });
        y.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus, error, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
        return;
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().x(6, paramc.field_favLocalId);
      }
    case 3: 
      if (localg.field_type == 18)
      {
        a(paramc, localg);
        return;
      }
      if (localg.aQc())
      {
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().x(17, paramc.field_favLocalId);
        y.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus start mod faviteminfo, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getModService().run();
        return;
      }
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().x(9, paramc.field_favLocalId);
      y.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus start send faviteminfo, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getSendService().run();
      return;
    }
    ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().x(6, paramc.field_favLocalId);
    y.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus pause, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
  }
  
  private static void a(c paramc, g paramg)
  {
    Iterator localIterator = paramg.field_favProto.sXc.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      xv localxv = (xv)localIterator.next();
      if ((localxv.aYU != 1) && (localxv.aYU != 6))
      {
        if (!bk.bl(localxv.sUG)) {
          break label171;
        }
        i += 1;
      }
    }
    label171:
    for (;;)
    {
      break;
      if (i == 0)
      {
        if (paramg.field_id > 0)
        {
          ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().x(17, paramc.field_favLocalId);
          ((ae)com.tencent.mm.kernel.g.t(ae.class)).getModService().run();
        }
      }
      else {
        return;
      }
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().x(9, paramc.field_favLocalId);
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getSendService().run();
      return;
    }
  }
  
  public static void a(g paramg, int paramInt)
  {
    if (paramg == null)
    {
      y.w("MicroMsg.Fav.FavApiLogic", "modeTag, item info is null");
      return;
    }
    Object localObject1 = new LinkedList();
    Object localObject2 = new axi();
    ((axi)localObject2).ttL = 4;
    ((axi)localObject2).ttM = 0;
    ((LinkedList)localObject1).add(localObject2);
    localObject2 = new LinkedList();
    axl localaxl = new axl();
    localaxl.kVl = "favitem.taglist";
    localaxl.hQR = 1;
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramg.field_tagProto.sXq.size();
    int i = 0;
    while (i < j)
    {
      localStringBuffer.append("<tag>").append(bk.ZP((String)paramg.field_tagProto.sXq.get(i))).append("</tag>");
      i += 1;
    }
    localaxl.nFs = localStringBuffer.toString();
    y.v("MicroMsg.Fav.FavApiLogic", "do net scene mod tag, id=%d, tag=%s", new Object[] { Integer.valueOf(paramg.field_id), localaxl.nFs });
    ((LinkedList)localObject2).add(localaxl);
    if (paramg.field_id > 0)
    {
      localObject1 = new al(paramg.field_id, (LinkedList)localObject1, (LinkedList)localObject2);
      com.tencent.mm.kernel.g.Dk().a((com.tencent.mm.ah.m)localObject1, 0);
      h.g(paramg.field_id, j, paramInt);
      return;
    }
    ((ae)com.tencent.mm.kernel.g.t(ae.class)).getEditService().a(paramg.field_localId, (LinkedList)localObject1, (LinkedList)localObject2, paramInt);
  }
  
  public static void a(g paramg, xv paramxv)
  {
    if (bk.bl(paramxv.kgC)) {}
    String str;
    Object localObject;
    do
    {
      return;
      str = Cw(paramxv.kgC);
      c localc = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().CN(str);
      localObject = localc;
      if (localc != null)
      {
        localObject = localc;
        if (localc.field_status == 3)
        {
          ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().b(localc, new String[] { "dataId" });
          localObject = null;
        }
      }
      if ((localObject != null) && (((c)localObject).field_type == 1))
      {
        ((c)localObject).field_status = 1;
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().a((c)localObject, new String[] { "dataId" });
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnService().CL(str);
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnService().run();
        return;
      }
      localObject = new com.tencent.mm.vfs.b(c(paramxv));
    } while ((bk.bl(paramxv.sUC)) || (bk.bl(paramxv.dQL)) || (((com.tencent.mm.vfs.b)localObject).exists()));
    a(paramxv, paramg, 1);
    ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnService().CL(str);
    ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnService().run();
  }
  
  public static void a(g paramg, xv paramxv, boolean paramBoolean)
  {
    if ((paramg == null) || (bk.bl(paramxv.kgC))) {}
    Object localObject1;
    do
    {
      return;
      y.i("MicroMsg.Fav.FavApiLogic", "restart cdndata download, favId %d, favLocalId %d, dataId %s", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), paramxv.kgC });
      Object localObject2 = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().CN(paramxv.kgC);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((c)localObject2).field_status == 3)
        {
          ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().b((c)localObject2, new String[] { "dataId" });
          localObject1 = null;
        }
      }
      localObject2 = localObject1;
      if (localObject1 != null) {
        if ((!bk.bl(((c)localObject1).field_cdnUrl)) && (!bk.bl(((c)localObject1).field_cdnKey)) && (!bk.bl(((c)localObject1).field_dataId)) && (((c)localObject1).field_cdnUrl.equals(paramxv.sUG)) && (((c)localObject1).field_cdnKey.equals(paramxv.sUI)))
        {
          localObject2 = localObject1;
          if (((c)localObject1).field_dataId.equals(paramxv.kgC)) {}
        }
        else
        {
          ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().b((c)localObject1, new String[] { "dataId" });
          localObject2 = null;
        }
      }
      if ((localObject2 != null) && (((c)localObject2).field_type == 1))
      {
        y.i("MicroMsg.Fav.FavApiLogic", "klem data not download completed.");
        ((c)localObject2).field_status = 1;
        ((c)localObject2).field_path = b(paramxv);
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().a((c)localObject2, new String[] { "dataId" });
        if (paramBoolean)
        {
          ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnService().CL(paramxv.kgC);
          if ((!bk.bl(paramxv.sVI)) && (paramxv.sVI.equals("WeNoteHtmlFile")))
          {
            paramg = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().CN(paramxv.kgC);
            ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnService().c(paramg);
          }
        }
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnService().run();
        return;
      }
      localObject1 = new com.tencent.mm.vfs.b(b(paramxv));
    } while ((bk.bl(paramxv.sUI)) || (bk.bl(paramxv.sUG)) || (((com.tencent.mm.vfs.b)localObject1).exists()));
    y.i("MicroMsg.Fav.FavApiLogic", "klem big img not exist, start download.");
    long l = System.currentTimeMillis();
    a(paramxv, paramg, 1, true);
    if (paramBoolean)
    {
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnService().CL(paramxv.kgC);
      if ((!bk.bl(paramxv.sVI)) && (paramxv.sVI.equals("WeNoteHtmlFile")))
      {
        paramg = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().CN(paramxv.kgC);
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnService().c(paramg);
      }
    }
    ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnService().run();
    y.i("MicroMsg.Fav.FavApiLogic", "insert cdn item use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  public static void a(g paramg, boolean paramBoolean)
  {
    h(paramg);
    ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavSearchStorage().eG(paramg.field_localId);
    ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().z(paramg);
    ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().eC(paramg.field_localId);
    ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavTagSetMgr().v(paramg);
    if (paramBoolean)
    {
      Set localSet = aPH();
      localSet.add(paramg.field_id);
      d(localSet);
      aPJ();
    }
  }
  
  public static void a(xv paramxv, int paramInt, long paramLong)
  {
    if (bk.bl(paramxv.kgC)) {}
    String str;
    do
    {
      do
      {
        return;
      } while ((bk.bl(paramxv.sUC)) || (bk.bl(paramxv.dQL)));
      str = Cw(paramxv.kgC);
      c localc = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().CN(str);
      localObject = localc;
      if (localc != null) {
        if (localc.field_status != 3)
        {
          localObject = localc;
          if (localc.field_status != 4) {}
        }
        else
        {
          ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().b(localc, new String[] { "dataId" });
          localObject = null;
        }
      }
      if ((localObject != null) && (((c)localObject).field_type == 1))
      {
        ((c)localObject).field_status = 1;
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().a((c)localObject, new String[] { "dataId" });
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnService().CL(str);
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnService().run();
        return;
      }
      localObject = new com.tencent.mm.vfs.b(c(paramxv));
    } while ((bk.bl(paramxv.sUC)) || (bk.bl(paramxv.dQL)) || (((com.tencent.mm.vfs.b)localObject).exists()));
    Object localObject = new g();
    ((g)localObject).field_localId = paramLong;
    ((g)localObject).field_id = -1;
    ((g)localObject).field_type = paramInt;
    a(paramxv, (g)localObject, 1);
    ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnService().CL(str);
    ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnService().run();
  }
  
  public static void a(xv paramxv, g paramg, int paramInt)
  {
    if ((paramInt == 1) && ((paramxv.sVm <= 0L) || (bk.bl(paramxv.sUC)) || (bk.bl(paramxv.dQL))))
    {
      y.e("MicroMsg.Fav.FavApiLogic", "insertCdnThumbInfo, type recv, cdndataurl must not be null!");
      return;
    }
    if ((paramInt == 0) && (bk.bl(c(paramxv))))
    {
      y.e("MicroMsg.Fav.FavApiLogic", "insertCdnThumbInfo, type send, path must not be null!");
      return;
    }
    String str = Cw(paramxv.kgC);
    if (((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().CN(str) != null)
    {
      y.w("MicroMsg.Fav.FavApiLogic", "cdn info exist, id[%s], return", new Object[] { str });
      return;
    }
    y.v("MicroMsg.Fav.FavApiLogic", "insert cdn thumb info, fav local id[%d] fav id[%d]", new Object[] { Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
    c localc = new c();
    localc.field_cdnKey = paramxv.sUC;
    localc.field_cdnUrl = paramxv.dQL;
    localc.field_dataId = str;
    localc.field_favLocalId = paramg.field_localId;
    localc.field_totalLen = ((int)paramxv.sVm);
    localc.field_type = paramInt;
    localc.field_status = 1;
    localc.field_path = c(paramxv);
    localc.field_modifyTime = bk.UY();
    localc.field_attrFlag |= 1L;
    ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().e(localc);
    if (paramInt == 1)
    {
      b(localc);
      return;
    }
    a(localc);
  }
  
  public static void a(xv paramxv, g paramg, int paramInt, boolean paramBoolean)
  {
    if ((paramInt == 1) && ((bk.bl(paramxv.sUI)) || (bk.bl(paramxv.sUG))))
    {
      y.e("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo, type recv, cdndataurl must not be null!");
      return;
    }
    if ((paramInt == 0) && (bk.bl(b(paramxv))))
    {
      y.e("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo, type send, path must not be null!");
      return;
    }
    if (((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().CN(paramxv.kgC) != null)
    {
      y.v("MicroMsg.Fav.FavApiLogic", "cdn info exist, id[%s], return", new Object[] { paramxv.kgC });
      return;
    }
    y.i("MicroMsg.Fav.FavApiLogic", "insert cdn data info, fav local id[%d] fav id[%d]", new Object[] { Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
    c localc = new c();
    localc.field_dataId = paramxv.kgC;
    localc.field_totalLen = ((int)paramxv.sVb);
    localc.field_type = paramInt;
    localc.field_favLocalId = paramg.field_localId;
    localc.field_cdnKey = paramxv.sUI;
    localc.field_cdnUrl = paramxv.sUG;
    localc.field_path = b(paramxv);
    int i;
    label245:
    boolean bool;
    if (paramxv.aYU == 3)
    {
      paramxv = paramxv.sUV;
      label401:
      if ((!bk.bl(paramxv)) && (paramxv.equals("speex")))
      {
        i = -3;
        localc.field_dataType = i;
        localc.field_modifyTime = bk.UY();
        bool = aq.isWifi(com.tencent.mm.sdk.platformtools.ae.getContext());
        if (paramInt == 0)
        {
          y.i("MicroMsg.Fav.FavApiLogic", "can auto upload, force %B, isWifi %B, dataType %d, totalLen %d", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), Integer.valueOf(localc.field_dataType), Integer.valueOf(localc.field_totalLen) });
          if (!paramBoolean) {
            break label495;
          }
          i = 1;
          label321:
          if (i == 0) {
            break label622;
          }
          localc.field_status = 1;
          y.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo upload status traning");
        }
        label340:
        if (paramInt == 1)
        {
          y.i("MicroMsg.Fav.FavApiLogic", "can auto download, force %B, isWifi %B, dataType %d, totalLen %d", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), Integer.valueOf(localc.field_dataType), Integer.valueOf(localc.field_totalLen) });
          if (!paramBoolean) {
            break label639;
          }
          i = 1;
          if (i == 0) {
            break label752;
          }
          localc.field_status = 1;
          y.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo download status traning");
        }
      }
    }
    for (;;)
    {
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().e(localc);
      if (paramInt != 1) {
        break label769;
      }
      b(localc);
      return;
      if ((!bk.bl(paramxv)) && (paramxv.equals("silk")))
      {
        i = -4;
        break;
      }
      i = -2;
      break;
      localc.field_dataType = paramxv.aYU;
      break label245;
      label495:
      if (bool)
      {
        i = 1;
        break label321;
      }
      if ((localc.field_dataType != 8) && (localc.field_dataType != 4) && (localc.field_dataType != 15))
      {
        i = 1;
        break label321;
      }
      long l2 = com.tencent.mm.sdk.platformtools.ae.getContext().getSharedPreferences(com.tencent.mm.sdk.platformtools.ae.cqR(), 0).getLong("fav_mx_auto_upload_size", 0L);
      long l1 = l2;
      if (l2 == 0L) {
        l1 = 26214400L;
      }
      if (localc.field_totalLen <= l1)
      {
        y.i("MicroMsg.Fav.FavApiLogic", "match max auto upload, max size %d", new Object[] { Long.valueOf(l1) });
        i = 1;
        break label321;
      }
      i = 0;
      break label321;
      label622:
      localc.field_status = 4;
      y.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo upload status pause");
      break label340;
      label639:
      if (bool)
      {
        i = 1;
        break label401;
      }
      if ((localc.field_dataType != 8) && (localc.field_dataType != 4) && (localc.field_dataType != 15))
      {
        i = 1;
        break label401;
      }
      l1 = com.tencent.mm.sdk.platformtools.ae.getContext().getSharedPreferences(com.tencent.mm.sdk.platformtools.ae.cqR(), 0).getLong("fav_mx_auto_download_size", 26214400L);
      if (localc.field_totalLen <= l1)
      {
        y.i("MicroMsg.Fav.FavApiLogic", "match max auto download, max size %d", new Object[] { Long.valueOf(l1) });
        i = 1;
        break label401;
      }
      i = 0;
      break label401;
      label752:
      localc.field_status = 4;
      y.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo download status pause");
    }
    label769:
    a(localc);
  }
  
  public static boolean a(long paramLong, Runnable paramRunnable)
  {
    return a(((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(paramLong), true, paramRunnable);
  }
  
  public static boolean a(g paramg, boolean paramBoolean, Runnable paramRunnable)
  {
    if (paramg == null)
    {
      y.w("MicroMsg.Fav.FavApiLogic", "delete fav item fail, item is null");
      ai.d(paramRunnable);
      return false;
    }
    if (Looper.myLooper() == com.tencent.mm.kernel.g.DS().mnU.getLooper())
    {
      y.i("MicroMsg.Fav.FavApiLogic", "delete favItem id %d, localId %d, needBatchDel %B, do directly", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), Boolean.valueOf(paramBoolean) });
      a(paramg, paramBoolean);
      ai.d(paramRunnable);
    }
    for (;;)
    {
      return true;
      y.i("MicroMsg.Fav.FavApiLogic", "delete favItem id %d, localId %d, needBatchDel %B, post to worker", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), Boolean.valueOf(paramBoolean) });
      com.tencent.mm.kernel.g.DS().O(new b.2(paramg, paramBoolean, paramRunnable));
    }
  }
  
  public static String[] a(g paramg, com.tencent.mm.sdk.platformtools.ah paramah)
  {
    Object localObject2 = null;
    if (paramg == null)
    {
      y.w("MicroMsg.Fav.FavApiLogic", "GetThumbUrlAndLocalPath favItemInfo is null");
      return null;
    }
    xv localxv = c(paramg);
    String[] arrayOfString = new String[2];
    b.3 local3 = new b.3(paramg, localxv);
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
      if (localxv != null)
      {
        arrayOfString[0] = c(localxv);
        arrayOfString[1] = localxv.bIm;
        paramah.post(local3);
      }
    case 5: 
    case 10: 
    case 15: 
    case 11: 
      for (;;)
      {
        y.d("MicroMsg.Fav.FavApiLogic", "GetThumbUrlAndLocalPath thumbPath %s, thumbUrl %s, type %d", new Object[] { arrayOfString[0], arrayOfString[1], Integer.valueOf(paramg.field_type) });
        return arrayOfString;
        localObject1 = paramg.field_favProto.sWh;
        if (localxv == null)
        {
          if (localObject1 != null) {
            arrayOfString[1] = ((yy)localObject1).thumbUrl;
          }
        }
        else
        {
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = ((yy)localObject1).thumbUrl)
          {
            localObject2 = localObject1;
            if (bk.bl((String)localObject1)) {
              localObject2 = localxv.bIm;
            }
            arrayOfString[0] = c(localxv);
            arrayOfString[1] = localObject2;
            paramah.post(local3);
            break;
          }
          paramah = paramg.field_favProto.sWj;
          if (paramah != null)
          {
            arrayOfString[1] = paramah.thumbUrl;
            continue;
            paramah = paramg.field_favProto.sWl;
            if (paramah != null)
            {
              arrayOfString[1] = paramah.thumbUrl;
              continue;
              paramah = paramg.field_favProto.sWj;
              if (paramah != null) {
                arrayOfString[1] = paramah.thumbUrl;
              }
            }
          }
        }
      }
    }
    if (paramg.field_favProto.sXc != null)
    {
      Iterator localIterator = paramg.field_favProto.sXc.iterator();
      label357:
      localObject1 = localObject2;
      if (localIterator.hasNext())
      {
        localObject1 = (xv)localIterator.next();
        if (((xv)localObject1).aYU != 2) {
          break label417;
        }
        localObject1 = b((xv)localObject1);
        paramah.post(local3);
      }
    }
    for (;;)
    {
      arrayOfString[0] = localObject1;
      arrayOfString[1] = localxv.bIm;
      break;
      label417:
      if (((xv)localObject1).aYU != 15) {
        break label357;
      }
      localObject1 = c((xv)localObject1);
      paramah.post(local3);
    }
  }
  
  private static Set<String> aPH()
  {
    Object localObject = (String)com.tencent.mm.kernel.g.DP().Dz().get(225282, "");
    y.i("MicroMsg.Fav.FavApiLogic", "get need del IDs: %s", new Object[] { localObject });
    HashSet localHashSet = new HashSet();
    if (bk.bl((String)localObject)) {
      return localHashSet;
    }
    localObject = ((String)localObject).split(",");
    if ((localObject == null) || (localObject.length == 0)) {
      return localHashSet;
    }
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localHashSet.add(localObject[i]);
      i += 1;
    }
    return localHashSet;
  }
  
  public static String aPI()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.DQ();
    return com.tencent.mm.kernel.g.DP().dKt + "favorite/web/";
  }
  
  public static void aPJ()
  {
    Object localObject2 = aPH();
    if (((Set)localObject2).size() == 0) {
      y.v("MicroMsg.Fav.FavApiLogic", "doBatchDel no item to delete");
    }
    do
    {
      return;
      y.i("MicroMsg.Fav.FavApiLogic", "doBatchDel idList:%s", new Object[] { localObject2.toString() });
      localObject1 = new LinkedList();
      localObject2 = ((Set)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        try
        {
          ((LinkedList)localObject1).add(Integer.valueOf(bk.getInt(str, 0)));
        }
        catch (Exception localException)
        {
          y.printErrStackTrace("MicroMsg.Fav.FavApiLogic", localException, "", new Object[0]);
          y.e("MicroMsg.Fav.FavApiLogic", "doBatchDel parseInt error:%s", new Object[] { localException.getMessage() });
        }
      }
      y.i("MicroMsg.Fav.FavApiLogic", "doBatchDel after parse, total size %d", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()) });
    } while (((LinkedList)localObject1).size() <= 0);
    Object localObject1 = new ag((LinkedList)localObject1);
    com.tencent.mm.kernel.g.Dk().a((com.tencent.mm.ah.m)localObject1, 0);
  }
  
  public static void aPK()
  {
    if (0L >= jYq)
    {
      y.i("MicroMsg.Fav.FavApiLogic", "addTagWhenAddToFav,try to add tag ,but favLocalId is null, return");
      return;
    }
    g localg = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(jYq);
    jYq = 0L;
    if (localg == null)
    {
      y.i("MicroMsg.Fav.FavApiLogic", "addTagWhenAddToFav,try to add tag ,but iteminfo is null, return");
      return;
    }
    y.i("MicroMsg.Fav.FavApiLogic", "addTagWhenAddToFav ,go on");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_fav_scene", 5);
    localIntent.putExtra("key_fav_item_id", localg.field_localId);
    a(com.tencent.mm.sdk.platformtools.ae.getContext(), ".ui.FavTagEditUI", localIntent, null);
  }
  
  public static long aPL()
  {
    long l2 = aPM() - aPN();
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 1024L;
    }
    return l1;
  }
  
  public static long aPM()
  {
    return ((Long)com.tencent.mm.kernel.g.DP().Dz().get(com.tencent.mm.storage.ac.a.uqB, Long.valueOf(0L))).longValue();
  }
  
  public static long aPN()
  {
    return ((Long)com.tencent.mm.kernel.g.DP().Dz().get(com.tencent.mm.storage.ac.a.uqA, Long.valueOf(0L))).longValue();
  }
  
  public static boolean aPO()
  {
    if (aPM() == 0L) {}
    while (aPL() >= 52428800L) {
      return false;
    }
    return true;
  }
  
  public static String aPP()
  {
    return com.tencent.mm.kernel.g.DP().dKt + "favorite/music/";
  }
  
  public static String aPQ()
  {
    return com.tencent.mm.kernel.g.DP().dKt + "favorite/";
  }
  
  public static String aPR()
  {
    return com.tencent.mm.kernel.g.DP().dKt + "favorite/voice/";
  }
  
  public static boolean aPS()
  {
    return ah.aQH() > 0;
  }
  
  public static boolean aPT()
  {
    if (aPM() == 0L) {}
    while (aPL() >= 10485760L) {
      return false;
    }
    return true;
  }
  
  public static String ar(float paramFloat)
  {
    if (paramFloat < 1024.0F) {
      return String.format("%.1fB", new Object[] { Float.valueOf(paramFloat) });
    }
    if (paramFloat < 1048576.0F) {
      return String.format("%.1fKB", new Object[] { Float.valueOf(paramFloat / 1024.0F) });
    }
    if (paramFloat < 1.073742E+009F) {
      return String.format("%.1fMB", new Object[] { Float.valueOf(paramFloat / 1024.0F / 1024.0F) });
    }
    return String.format("%.1fGB", new Object[] { Float.valueOf(paramFloat / 1024.0F / 1024.0F / 1024.0F) });
  }
  
  public static long b(g paramg)
  {
    if (paramg == null) {
      return 0L;
    }
    paramg = paramg.field_favProto.sXc.iterator();
    xv localxv;
    long l;
    for (int i = 0; paramg.hasNext(); i = (int)(localxv.sVb + l))
    {
      localxv = (xv)paramg.next();
      l = i;
    }
    return i;
  }
  
  public static String b(xv paramxv)
  {
    if (paramxv == null) {
      return "";
    }
    Object localObject2 = paramxv.kgC;
    if ((bk.bl((String)localObject2)) || (!com.tencent.mm.kernel.g.DK())) {
      return "";
    }
    com.tencent.mm.vfs.b localb2 = Cv((String)localObject2);
    int j = 0;
    int i = j;
    com.tencent.mm.vfs.b localb1 = localb2;
    Object localObject1 = localObject2;
    if (paramxv.aYU == 8)
    {
      i = j;
      localb1 = localb2;
      localObject1 = localObject2;
      if (!bk.bl(paramxv.title))
      {
        localObject1 = paramxv.title;
        localb1 = Cv(paramxv.kgC);
        i = 1;
      }
    }
    localObject2 = localObject1;
    if (paramxv.sUV != null)
    {
      localObject2 = localObject1;
      if (paramxv.sUV.trim().length() > 0)
      {
        localObject2 = localObject1;
        if (i == 0) {
          localObject2 = (String)localObject1 + "." + paramxv.sUV;
        }
      }
    }
    localObject1 = new com.tencent.mm.vfs.b(localb1, (String)localObject2);
    if ((((com.tencent.mm.vfs.b)localObject1).exists()) || (bk.bl(paramxv.sUX))) {
      return com.tencent.mm.vfs.j.n(((com.tencent.mm.vfs.b)localObject1).cLr());
    }
    localObject2 = com.tencent.mm.a.g.o((paramxv.sUX + paramxv.kgC).getBytes());
    if (bk.bl((String)localObject2)) {
      return com.tencent.mm.vfs.j.n(((com.tencent.mm.vfs.b)localObject1).cLr());
    }
    localObject1 = localObject2;
    if (paramxv.sUV != null)
    {
      localObject1 = localObject2;
      if (paramxv.sUV.trim().length() > 0) {
        localObject1 = (String)localObject2 + "." + paramxv.sUV;
      }
    }
    localObject1 = new com.tencent.mm.vfs.b(localb1, (String)localObject1);
    if (((com.tencent.mm.vfs.b)localObject1).exists()) {
      return com.tencent.mm.vfs.j.n(((com.tencent.mm.vfs.b)localObject1).cLr());
    }
    localObject2 = paramxv.kgC;
    localObject1 = localObject2;
    if (paramxv.sUV != null)
    {
      localObject1 = localObject2;
      if (paramxv.sUV.trim().length() > 0) {
        localObject1 = (String)localObject2 + "." + paramxv.sUV;
      }
    }
    y.d("MicroMsg.Fav.FavApiLogic", "use dataId.fmt, " + (String)localObject1);
    return com.tencent.mm.vfs.j.n(new com.tencent.mm.vfs.b(localb1, (String)localObject1).cLr());
  }
  
  public static void b(Context paramContext, String paramString, Intent paramIntent, int paramInt)
  {
    a(paramContext, paramString, paramIntent, paramInt, null);
  }
  
  private static void b(gf paramgf)
  {
    g localg = CC(paramgf.bNF.desc);
    if (localg == null) {
      return;
    }
    if ((localg.field_favProto != null) && (localg.field_favProto.sXc != null))
    {
      Iterator localIterator = localg.field_favProto.sXc.iterator();
      while (localIterator.hasNext())
      {
        xv localxv = (xv)localIterator.next();
        if (localxv.aYU == 20)
        {
          localxv.mk(true);
          localxv.mj(true);
          localxv.XI("");
          localxv.Xy("");
          localxv.Xz("");
          localxv.Xw("");
          localxv.Xx("");
        }
      }
    }
    paramgf.bNF.bIy = localg.field_favProto;
  }
  
  public static void b(c paramc)
  {
    int i = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().o(paramc.field_favLocalId, 1);
    y.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, download data status:%d, favlocalId:%d", new Object[] { Integer.valueOf(i), Long.valueOf(paramc.field_favLocalId) });
    g localg = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(paramc.field_favLocalId);
    if (localg == null)
    {
      y.e("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus iteminfo null");
      return;
    }
    if ((localg.aQd()) || (localg.aPZ()) || (localg.aQa()))
    {
      y.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, status upload, skip. isWaitServerUpload:%b  isUploadding:%b  isUploadFailed:%b", new Object[] { Boolean.valueOf(localg.aQd()), Boolean.valueOf(localg.aPZ()), Boolean.valueOf(localg.aQa()) });
      return;
    }
    switch (i)
    {
    default: 
      return;
    case 0: 
      y.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus init, favLocalId:%d, favId:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id) });
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().x(10, paramc.field_favLocalId);
      return;
    case 1: 
      h.ey(localg.field_localId);
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().x(7, paramc.field_favLocalId);
      return;
    case 4: 
      y.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, error, favLocalId:%d, favId:%d, itemStatus:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_itemStatus) });
      com.tencent.mm.plugin.report.service.h.nFQ.f(10659, new Object[] { Integer.valueOf(1), Integer.valueOf(localg.field_type), Integer.valueOf(-5), Long.valueOf(b(localg)), Long.valueOf(h.ex(localg.field_localId)) });
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().x(8, paramc.field_favLocalId);
      return;
    case 3: 
      y.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus finish, favLocalId:%d, favId:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id) });
      com.tencent.mm.plugin.report.service.h.nFQ.f(10659, new Object[] { Integer.valueOf(1), Integer.valueOf(localg.field_type), Integer.valueOf(0), Long.valueOf(b(localg)), Long.valueOf(h.ex(localg.field_localId)) });
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().x(10, paramc.field_favLocalId);
      return;
    }
    y.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus pause, favLocalId:%d, favId:%d", new Object[] { Long.valueOf(paramc.field_favLocalId), Integer.valueOf(localg.field_id) });
    ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().x(8, paramc.field_favLocalId);
  }
  
  private static void b(g paramg, boolean paramBoolean)
  {
    yd localyd = new yd();
    if (!paramBoolean) {
      localyd.sWT = com.tencent.mm.model.q.Gj();
    }
    localyd.sWU = com.tencent.mm.model.q.Gj();
    paramg.field_favProto.hk(bk.UX());
    paramg.field_favProto.a(localyd);
  }
  
  public static void b(xv paramxv, int paramInt, long paramLong)
  {
    if (bk.bl(paramxv.kgC)) {}
    do
    {
      return;
      y.i("MicroMsg.Fav.FavApiLogic", "restart cdndata download, dataId %s", new Object[] { paramxv.kgC });
      c localc = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().CN(paramxv.kgC);
      localObject = localc;
      if (localc != null) {
        if (localc.field_status != 3)
        {
          localObject = localc;
          if (localc.field_status != 4) {}
        }
        else
        {
          ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().b(localc, new String[] { "dataId" });
          localObject = null;
        }
      }
      if ((localObject != null) && (((c)localObject).field_type == 1))
      {
        y.i("MicroMsg.Fav.FavApiLogic", "klem data not download completed.");
        ((c)localObject).field_status = 1;
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().a((c)localObject, new String[] { "dataId" });
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnService().CL(paramxv.kgC);
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnService().run();
        return;
      }
      localObject = new com.tencent.mm.vfs.b(b(paramxv));
    } while ((bk.bl(paramxv.sUI)) || (bk.bl(paramxv.sUG)) || (((com.tencent.mm.vfs.b)localObject).exists()));
    y.i("MicroMsg.Fav.FavApiLogic", "klem big img not exist, start download.");
    long l = System.currentTimeMillis();
    Object localObject = new g();
    ((g)localObject).field_localId = paramLong;
    ((g)localObject).field_id = -1;
    ((g)localObject).field_type = paramInt;
    a(paramxv, (g)localObject, 1, true);
    ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnService().CL(paramxv.kgC);
    ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnService().run();
    y.i("MicroMsg.Fav.FavApiLogic", "insert cdn item use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  public static String bB(String paramString, int paramInt)
  {
    return com.tencent.mm.a.g.o((paramString + paramInt + System.currentTimeMillis()).getBytes());
  }
  
  public static void bm(List<Integer> paramList)
  {
    if (paramList.size() == 0)
    {
      y.e("MicroMsg.Fav.FavApiLogic", "setDeleted list null");
      return;
    }
    Set localSet = aPH();
    y.i("MicroMsg.Fav.FavApiLogic", "setDeleted before del:%s", new Object[] { localSet.toString() });
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Integer localInteger = (Integer)paramList.next();
      y.i("MicroMsg.Fav.FavApiLogic", "setDeleted id:%d, ret:%b", new Object[] { localInteger, Boolean.valueOf(localSet.remove(localInteger.toString())) });
    }
    y.i("MicroMsg.Fav.FavApiLogic", "setDeleted after del:%s", new Object[] { localSet.toString() });
    d(localSet);
  }
  
  public static boolean bn(List<g> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      y.w("MicroMsg.Fav.FavApiLogic", "delete fav item fail, item is null");
      return false;
    }
    Set localSet = aPH();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      g localg = (g)paramList.next();
      h(localg);
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavSearchStorage().eG(localg.field_localId);
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().z(localg);
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().eC(localg.field_localId);
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavTagSetMgr().v(localg);
      localSet.add(localg.field_id);
      y.d("MicroMsg.Fav.FavApiLogic", "delete id %d", new Object[] { Integer.valueOf(localg.field_id) });
    }
    d(localSet);
    aPJ();
    return true;
  }
  
  public static xv c(g paramg)
  {
    if (paramg == null) {
      return new xv();
    }
    if (paramg.field_favProto.sXc.size() == 0) {
      return new xv();
    }
    return (xv)paramg.field_favProto.sXc.get(0);
  }
  
  public static String c(xv paramxv)
  {
    if ((paramxv == null) || (bk.bl(paramxv.kgC))) {
      return "";
    }
    paramxv = Cw(paramxv.kgC);
    return com.tencent.mm.vfs.j.n(new com.tencent.mm.vfs.b(Cv(paramxv), paramxv).cLr());
  }
  
  public static void c(gf paramgf)
  {
    Object localObject2;
    Object localObject3;
    if (paramgf.bNF.bNM == 1)
    {
      paramgf.bNG.path = ep(paramgf.bNF.bIr);
      localObject2 = paramgf.bNG;
      long l = paramgf.bNF.bIr;
      localObject3 = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(l);
      if ((localObject3 == null) || (((g)localObject3).field_favProto == null))
      {
        paramgf = "";
        label80:
        ((gf.b)localObject2).thumbPath = paramgf;
      }
    }
    do
    {
      return;
      if ((((g)localObject3).field_type != 18) || (((g)localObject3).field_favProto.sXc.size() > 1))
      {
        paramgf = ((g)localObject3).field_favProto.sXc.iterator();
        for (;;)
        {
          if (paramgf.hasNext())
          {
            xv localxv = (xv)paramgf.next();
            switch (localxv.aYU)
            {
            default: 
              break;
            case 2: 
              localObject1 = c(localxv);
              paramgf = (gf)localObject1;
              if (com.tencent.mm.vfs.e.bK((String)localObject1)) {
                break label80;
              }
              paramgf = b(localxv);
              if (com.tencent.mm.vfs.e.bK(paramgf))
              {
                com.tencent.mm.sdk.platformtools.c.c(paramgf, 150, 150, Bitmap.CompressFormat.JPEG, 90, (String)localObject1);
                paramgf = c(localxv);
                break label80;
              }
              if (localxv.sUB)
              {
                a((g)localObject3, localxv);
                paramgf = (gf)localObject1;
                break label80;
              }
              if (localxv.sUH)
              {
                a((g)localObject3, localxv, true);
                break label80;
              }
              paramgf = "";
              break label80;
            }
          }
        }
      }
      paramgf = "";
      break;
      if (paramgf.bNF.bNM == 2)
      {
        localObject1 = new g();
        ((g)localObject1).field_type = 2;
        localObject2 = new xv();
        ((xv)localObject2).XH(bB(localObject2.toString(), 2));
        localObject3 = b((xv)localObject2);
        ((xv)localObject2).XI((String)localObject3);
        ((xv)localObject2).EH(2);
        ((g)localObject1).field_favProto.sXc.add(localObject2);
        paramgf.bNG.path = g.s((g)localObject1);
        paramgf.bNG.thumbPath = ((String)localObject3);
        return;
      }
      if (paramgf.bNF.bNM != 3) {
        break label485;
      }
      localObject1 = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(paramgf.bNF.bIr);
    } while (localObject1 == null);
    paramgf.bNG.path = (com.tencent.mm.model.q.Gj() + ";" + ((g)localObject1).field_fromUser + ";" + ((g)localObject1).field_updateTime);
    return;
    label485:
    if (paramgf.bNF.bNM == 4)
    {
      b(paramgf);
      return;
    }
    if (paramgf.bNF.bNM == 5)
    {
      a(paramgf);
      return;
    }
    if (paramgf.bNF.bNM == 6)
    {
      localObject1 = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(paramgf.bNF.bIr);
      if (localObject1 == null)
      {
        paramgf.bNG.ret = 0;
        return;
      }
      paramgf = paramgf.bNG;
      if (((g)localObject1).field_id > 0) {}
      for (int i = 1;; i = 0)
      {
        paramgf.ret = i;
        return;
      }
    }
    Object localObject1 = new g();
    ((g)localObject1).field_type = 18;
    ((g)localObject1).field_favProto = paramgf.bNF.bIy;
    paramgf.bNG.path = g.s((g)localObject1);
  }
  
  public static void c(String paramString, Context paramContext)
  {
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.Fav.FavApiLogic", "share image to friend fail, imgPath is null");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Retr_File_Name", paramString);
    localIntent.putExtra("Retr_Compress_Type", 0);
    localIntent.putExtra("Retr_Msg_Type", 0);
    com.tencent.mm.br.d.e(paramContext, ".ui.transmit.MsgRetransmitUI", localIntent);
  }
  
  private static String cZ(String paramString1, String paramString2)
  {
    if (bk.bl(paramString1)) {
      return paramString2;
    }
    if (bk.bl(paramString2)) {
      return paramString1;
    }
    return paramString1 + "​" + paramString2;
  }
  
  public static float ck(long paramLong)
  {
    float f2 = 60.0F;
    float f1 = 1.0F;
    float f3 = (float)paramLong / 1000.0F;
    if (f3 < 1.0F) {}
    for (;;)
    {
      if (f1 > 60.0F) {
        f1 = f2;
      }
      for (;;)
      {
        return Math.round(f1);
      }
      f1 = f3;
    }
  }
  
  /* Error */
  public static void d(g paramg)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +14 -> 18
    //   7: aload_0
    //   8: getfield 60	com/tencent/mm/plugin/fav/a/g:field_type	I
    //   11: istore_1
    //   12: iload_1
    //   13: bipush 18
    //   15: if_icmpeq +7 -> 22
    //   18: ldc 2
    //   20: monitorexit
    //   21: return
    //   22: getstatic 18	com/tencent/mm/plugin/fav/a/b:jYp	Ljava/util/HashMap;
    //   25: aload_0
    //   26: getfield 49	com/tencent/mm/plugin/fav/a/g:field_localId	J
    //   29: invokestatic 365	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   32: invokevirtual 1522	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   35: ifeq -17 -> 18
    //   38: getstatic 18	com/tencent/mm/plugin/fav/a/b:jYp	Ljava/util/HashMap;
    //   41: aload_0
    //   42: getfield 49	com/tencent/mm/plugin/fav/a/g:field_localId	J
    //   45: invokestatic 365	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   48: invokevirtual 724	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   51: ifnull -33 -> 18
    //   54: getstatic 18	com/tencent/mm/plugin/fav/a/b:jYp	Ljava/util/HashMap;
    //   57: aload_0
    //   58: getfield 49	com/tencent/mm/plugin/fav/a/g:field_localId	J
    //   61: invokestatic 365	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   64: invokevirtual 724	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   67: checkcast 536	java/util/ArrayList
    //   70: invokevirtual 557	java/util/ArrayList:size	()I
    //   73: ifeq -55 -> 18
    //   76: aload_0
    //   77: getfield 49	com/tencent/mm/plugin/fav/a/g:field_localId	J
    //   80: invokestatic 1437	com/tencent/mm/plugin/fav/a/b:ep	(J)Ljava/lang/String;
    //   83: astore_2
    //   84: ldc 70
    //   86: ldc_w 1524
    //   89: iconst_2
    //   90: anewarray 4	java/lang/Object
    //   93: dup
    //   94: iconst_0
    //   95: aload_0
    //   96: getfield 49	com/tencent/mm/plugin/fav/a/g:field_localId	J
    //   99: invokestatic 365	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   102: aastore
    //   103: dup
    //   104: iconst_1
    //   105: aload_2
    //   106: aastore
    //   107: invokestatic 778	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   110: new 1526	com/tencent/mm/h/a/oc
    //   113: dup
    //   114: invokespecial 1527	com/tencent/mm/h/a/oc:<init>	()V
    //   117: astore_3
    //   118: aload_3
    //   119: getfield 1531	com/tencent/mm/h/a/oc:bXN	Lcom/tencent/mm/h/a/oc$a;
    //   122: getstatic 18	com/tencent/mm/plugin/fav/a/b:jYp	Ljava/util/HashMap;
    //   125: aload_0
    //   126: getfield 49	com/tencent/mm/plugin/fav/a/g:field_localId	J
    //   129: invokestatic 365	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   132: invokevirtual 724	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   135: checkcast 536	java/util/ArrayList
    //   138: putfield 1537	com/tencent/mm/h/a/oc$a:bXO	Ljava/util/ArrayList;
    //   141: aload_3
    //   142: getfield 1531	com/tencent/mm/h/a/oc:bXN	Lcom/tencent/mm/h/a/oc$a;
    //   145: aload_2
    //   146: putfield 1540	com/tencent/mm/h/a/oc$a:bXP	Ljava/lang/String;
    //   149: getstatic 1546	com/tencent/mm/sdk/b/a:udP	Lcom/tencent/mm/sdk/b/a;
    //   152: aload_3
    //   153: invokevirtual 1550	com/tencent/mm/sdk/b/a:m	(Lcom/tencent/mm/sdk/b/b;)Z
    //   156: pop
    //   157: getstatic 18	com/tencent/mm/plugin/fav/a/b:jYp	Ljava/util/HashMap;
    //   160: aload_0
    //   161: getfield 49	com/tencent/mm/plugin/fav/a/g:field_localId	J
    //   164: invokestatic 365	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   167: invokevirtual 730	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   170: pop
    //   171: goto -153 -> 18
    //   174: astore_0
    //   175: ldc 2
    //   177: monitorexit
    //   178: aload_0
    //   179: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	paramg	g
    //   11	5	1	i	int
    //   83	63	2	str	String
    //   117	36	3	localoc	com.tencent.mm.h.a.oc
    // Exception table:
    //   from	to	target	type
    //   7	12	174	finally
    //   22	171	174	finally
  }
  
  public static void d(xv paramxv)
  {
    c localc = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().CN(paramxv.kgC);
    if ((localc != null) && (localc.field_status != 3))
    {
      localc.field_status = 2;
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnService().pauseDownload(paramxv.kgC);
    }
    localc = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().CN(Cw(paramxv.kgC));
    if ((localc != null) && (localc.field_status != 3))
    {
      localc.field_status = 2;
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnService().pauseDownload(Cw(paramxv.kgC));
    }
  }
  
  public static void d(String paramString, Context paramContext)
  {
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.Fav.FavApiLogic", "share image to timeline fail, filePath is null");
      return;
    }
    Intent localIntent = new Intent();
    String str1 = "fav_" + com.tencent.mm.model.q.Gj() + "_0";
    String str2 = com.tencent.mm.model.u.ij(str1);
    com.tencent.mm.model.u.Hc().v(str2, true).h("prePublishId", str1);
    localIntent.putExtra("reportSessionId", str2);
    localIntent.putExtra("Ksnsupload_type", 0);
    localIntent.putExtra("sns_kemdia_path", paramString);
    com.tencent.mm.br.d.b(paramContext, "sns", ".ui.SnsUploadUI", localIntent);
  }
  
  private static void d(Set<String> paramSet)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      localStringBuffer.append((String)paramSet.next()).append(",");
    }
    paramSet = "";
    if (localStringBuffer.length() > 0) {
      paramSet = localStringBuffer.substring(0, localStringBuffer.length() - 1);
    }
    y.i("MicroMsg.Fav.FavApiLogic", "set need del IDs: %s", new Object[] { paramSet });
    com.tencent.mm.kernel.g.DP().Dz().o(225282, paramSet);
  }
  
  public static void e(String paramString, Context paramContext)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.Fav.FavApiLogic", "shareTextToFriend content null");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Retr_Msg_content", paramString);
    localIntent.putExtra("Retr_Msg_Type", 4);
    localIntent.putExtra("mutil_select_is_ret", true);
    com.tencent.mm.br.d.e(paramContext, ".ui.transmit.MsgRetransmitUI", localIntent);
  }
  
  private static boolean e(g paramg)
  {
    if (paramg == null) {
      return false;
    }
    paramg = paramg.field_favProto.sXc.iterator();
    xv localxv;
    do
    {
      if (!paramg.hasNext()) {
        break;
      }
      localxv = (xv)paramg.next();
    } while (((localxv.aYU != 8) && (localxv.aYU != 4) && (localxv.aYU != 2) && (localxv.aYU != 3)) || ((!bk.bl(localxv.sUG)) && (!bk.bl(localxv.sUI))));
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  public static boolean e(xv paramxv)
  {
    com.tencent.mm.av.e locale = com.tencent.mm.av.a.Pw();
    return (locale != null) && (locale.euv == 6) && (bk.aM(paramxv.kgC, "").equals(locale.eux)) && (com.tencent.mm.av.a.Pu());
  }
  
  public static void en(long paramLong)
  {
    y.i("MicroMsg.Fav.FavApiLogic", "setUsedCapacity:%d", new Object[] { Long.valueOf(paramLong) });
    com.tencent.mm.kernel.g.DP().Dz().c(com.tencent.mm.storage.ac.a.uqA, Long.valueOf(paramLong));
  }
  
  public static void eo(long paramLong)
  {
    y.i("MicroMsg.Fav.FavApiLogic", "setTotalCapacity:%d", new Object[] { Long.valueOf(paramLong) });
    com.tencent.mm.kernel.g.DP().Dz().c(com.tencent.mm.storage.ac.a.uqB, Long.valueOf(paramLong));
  }
  
  private static String ep(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    g localg = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(paramLong);
    if ((localg == null) || (localg.field_favProto == null) || (localg.field_favProto.sXc.size() <= 1)) {
      return "";
    }
    yd localyd = localg.field_favProto.sro;
    String str2 = "";
    String str1 = "";
    if (localyd != null)
    {
      str2 = localyd.sWU;
      str1 = localyd.sWT;
    }
    localStringBuilder.append("<noteinfo>");
    localStringBuilder.append("<noteauthor>").append(str1).append("</noteauthor>");
    localStringBuilder.append("<noteeditor>").append(str2).append("</noteeditor>");
    localStringBuilder.append("<edittime>").append(localg.field_favProto.srp).append("</edittime>");
    localStringBuilder.append("<favlocalid>").append(localg.field_localId).append("</favlocalid>");
    localStringBuilder.append(com.tencent.mm.plugin.fav.a.a.a.bo(localg.field_favProto.sXc).replace("cdn_dataurl", "cdndataurl").replace("cdn_datakey", "cdndatakey").replace("cdn_thumburl", "cdnthumburl").replace("cdn_thumbkey", "cdnthumbkey").replace("thumbfullsize", "thumbsize").replace("fullsize", "datasize").replace("datasrcname", "sourcename").replace("datasrctime", "sourcetime").replace("stream_lowbandurl", "streamlowbandurl").replace("stream_dataurl", "streamdataurl").replace("stream_weburl", "streamweburl"));
    localStringBuilder.append("</noteinfo>");
    return localStringBuilder.toString();
  }
  
  public static void eq(long paramLong)
  {
    com.tencent.mm.sdk.platformtools.ae.getContext().getSharedPreferences(com.tencent.mm.sdk.platformtools.ae.cqR(), 0).edit().putLong("fav_mx_auto_download_size", paramLong).commit();
  }
  
  public static void er(long paramLong)
  {
    com.tencent.mm.sdk.platformtools.ae.getContext().getSharedPreferences(com.tencent.mm.sdk.platformtools.ae.cqR(), 0).edit().putLong("fav_mx_auto_upload_size", paramLong).commit();
  }
  
  public static void es(long paramLong)
  {
    com.tencent.mm.sdk.platformtools.ae.getContext().getSharedPreferences(com.tencent.mm.sdk.platformtools.ae.cqR(), 0).edit().putLong("fav_mx_file_size", paramLong).commit();
  }
  
  public static void et(long paramLong)
  {
    jYq = paramLong;
  }
  
  public static float eu(long paramLong)
  {
    float f1 = 1.0F;
    float f2 = (float)paramLong / 1000.0F;
    if (f2 < 1.0F) {}
    for (;;)
    {
      return Math.round(f1);
      f1 = f2;
    }
  }
  
  public static String ev(long paramLong)
  {
    if (paramLong == 0L) {
      return "0KB";
    }
    if (paramLong * 1.0D / 1048576.0D >= 1.0D) {
      return String.format("%dMB", new Object[] { Integer.valueOf((int)(paramLong * 1.0D / 1048576.0D)) });
    }
    if (paramLong * 1.0D / 1024.0D >= 1.0D) {
      return String.format("%dKB", new Object[] { Integer.valueOf((int)(paramLong * 1.0D / 1024.0D)) });
    }
    return "1KB";
  }
  
  public static void f(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    g localg = CC(paramString1);
    if (localg == null) {
      return;
    }
    ku localku = new ku();
    localku.bTL.type = 2;
    localku.bTL.field_localId = -1L;
    localku.bTL.context = paramContext;
    localku.bTL.bTR = 4;
    localku.bTL.bTT = true;
    paramContext = new Bundle();
    paramContext.putString("noteauthor", localg.field_favProto.sro.sWT);
    paramContext.putString("noteeditor", localg.field_favProto.sro.sWU);
    paramContext.putLong("edittime", localg.field_favProto.srp);
    paramContext.putString("notexml", g.s(localg));
    paramContext.putString("snslocalid", paramString2);
    paramContext.putString("snsthumbpath", paramString3);
    paramContext.putString("snsnotelinkxml", paramString1);
    localku.bTL.bTQ = paramContext;
    localku.bTL.field_favProto = localg.field_favProto;
    com.tencent.mm.sdk.b.a.udP.m(localku);
  }
  
  public static boolean f(g paramg)
  {
    if (paramg.field_favProto == null) {
      return false;
    }
    paramg = paramg.field_favProto.sXc.iterator();
    while (paramg.hasNext())
    {
      xv localxv = (xv)paramg.next();
      if (localxv.sVO == 2) {
        return true;
      }
      if (localxv.sVO == 1) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean f(xv paramxv)
  {
    return new com.tencent.mm.vfs.b(b(paramxv)).exists();
  }
  
  public static boolean g(g paramg)
  {
    if (paramg == null) {}
    while ((paramg.field_itemStatus != 8) && (paramg.field_itemStatus != 10) && (paramg.field_itemStatus != 7)) {
      return false;
    }
    return true;
  }
  
  public static boolean g(xv paramxv)
  {
    return com.tencent.mm.sdk.platformtools.o.Za(b(paramxv));
  }
  
  public static String gW(String paramString)
  {
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramString);
    if (localObject == null)
    {
      y.w("MicroMsg.Fav.FavApiLogic", "wtf get contact null, username %s", new Object[] { paramString });
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = ((ad)localObject).Bq();
      localObject = str;
    } while (!s.fn(str));
    paramString = com.tencent.mm.model.m.gK(paramString);
    localObject = com.tencent.mm.model.q.Gj();
    if ((paramString == null) || (paramString.isEmpty()))
    {
      y.w("MicroMsg.Fav.FavApiLogic", "get members from username error, content empty");
      return str;
    }
    paramString.remove(localObject);
    paramString.add(0, localObject);
    return com.tencent.mm.model.m.c(paramString, 3);
  }
  
  public static String getAppName(Context paramContext, String paramString)
  {
    ac.b localb = com.tencent.mm.model.ac.a.dVw;
    if (localb != null) {
      return localb.n(paramContext, paramString);
    }
    return "";
  }
  
  private static void h(g paramg)
  {
    Set localSet = an.kag;
    paramg = paramg.field_favProto.sXc;
    int i = 0;
    while (i < paramg.size())
    {
      String str = c((xv)paramg.get(i));
      if ((localSet == null) || (!localSet.contains(str))) {
        com.tencent.mm.vfs.e.deleteFile(str);
      }
      str = b((xv)paramg.get(i));
      if ((localSet == null) || (!localSet.contains(str))) {
        com.tencent.mm.vfs.e.deleteFile(str);
      }
      i += 1;
    }
  }
  
  public static boolean i(g paramg)
  {
    return a(paramg, true, null);
  }
  
  public static void j(g paramg)
  {
    j localj = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavSearchStorage().eH(paramg.field_localId);
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
      if (paramg.field_favProto.sXa != null)
      {
        localObject1 = paramg.field_favProto.sXa;
        if (!bk.bl(((yp)localObject1).bRO))
        {
          localStringBuffer.append(((yp)localObject1).bRO);
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(((yp)localObject1).bRO);
          if (localObject2 != null) {
            localStringBuffer.append(((ao)localObject2).field_nickname).append(((ao)localObject2).field_conRemark);
          }
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(((yp)localObject1).toUser);
          if (localObject2 != null) {
            localStringBuffer.append(((ao)localObject2).field_nickname).append(((ao)localObject2).field_conRemark);
          }
          localStringBuffer.append(((yp)localObject1).sWB);
        }
      }
      Object localObject1 = paramg.field_favProto.sXc;
      localj.field_subtype = 0;
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (xv)((Iterator)localObject1).next();
        if (((xv)localObject2).desc != null) {
          localStringBuffer.append(((xv)localObject2).desc);
        }
        if (((xv)localObject2).title != null) {
          localStringBuffer.append(((xv)localObject2).title);
        }
        int j = ((xv)localObject2).aYU;
        int k = localj.field_subtype;
        localj.field_subtype = (j.qX(j) | k);
      }
      if (paramg.field_favProto.sWh != null)
      {
        if (paramg.field_favProto.sWh.desc != null) {
          localStringBuffer.append(paramg.field_favProto.sWh.desc);
        }
        if (paramg.field_favProto.sWh.title != null) {
          localStringBuffer.append(paramg.field_favProto.sWh.title);
        }
      }
      if (paramg.field_favProto.sWj != null)
      {
        if (paramg.field_favProto.sWj.desc != null) {
          localStringBuffer.append(paramg.field_favProto.sWj.desc);
        }
        if (paramg.field_favProto.sWj.title != null) {
          localStringBuffer.append(paramg.field_favProto.sWj.title);
        }
      }
      localj.field_tagContent = "";
      localObject1 = paramg.field_tagProto.sXp.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localj.field_tagContent = (localj.field_tagContent + " " + (String)localObject2);
        localStringBuffer.append((String)localObject2);
      }
      localObject1 = paramg.field_tagProto.sXq.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localj.field_tagContent = (localj.field_tagContent + " " + (String)localObject2);
        localStringBuffer.append((String)localObject2);
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavTagSetMgr().CI((String)localObject2);
      }
      localj.field_content = localStringBuffer.toString();
      localj.field_time = paramg.field_updateTime;
      localj.field_type = paramg.field_type;
      if (i != 0)
      {
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavSearchStorage().a(localj);
        return;
      }
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavSearchStorage().a(localj, new String[] { "localId" });
      return;
    }
  }
  
  public static boolean k(g paramg)
  {
    return ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(paramg.field_localId) != null;
  }
  
  public static void l(g paramg)
  {
    if (!paramg.aQa())
    {
      y.f("MicroMsg.Fav.FavApiLogic", "restartItemUpload status not upload failed!");
      return;
    }
    Iterator localIterator;
    c localc;
    switch (paramg.field_itemStatus)
    {
    default: 
      return;
    case 3: 
      paramg.field_itemStatus = 1;
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getCheckCdnService().run();
      return;
    case 6: 
      if (((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().ez(paramg.field_localId).size() == 0)
      {
        paramg.field_itemStatus = 9;
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
        paramg = new af(paramg);
        com.tencent.mm.kernel.g.Dk().a(paramg, 0);
        return;
      }
      paramg.field_itemStatus = 4;
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().x(paramg);
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
      localIterator = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().ez(paramg.field_localId).iterator();
      while (localIterator.hasNext())
      {
        localc = (c)localIterator.next();
        y.i("MicroMsg.Fav.FavApiLogic", "force upload favItem[last failed], favid:%d localId:%d, dataId:%s, dataType:%d totalLength %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), localc.field_dataId, Integer.valueOf(localc.field_dataType), Integer.valueOf(localc.field_totalLen) });
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnService().CL(localc.field_dataId);
      }
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnService().run();
      return;
    case 14: 
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().x(12, paramg.field_localId);
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getSendService().run();
      return;
    case 16: 
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().x(15, paramg.field_localId);
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().x(paramg);
      localIterator = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().ez(paramg.field_localId).iterator();
      while (localIterator.hasNext())
      {
        localc = (c)localIterator.next();
        y.i("MicroMsg.Fav.FavApiLogic", "force upload favItem[last mod failed], favid:%d localId:%d, dataId:%s, dataType:%d totalLength %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), localc.field_dataId, Integer.valueOf(localc.field_dataType), Integer.valueOf(localc.field_totalLen) });
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnService().CL(localc.field_dataId);
      }
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnService().run();
      return;
    case 18: 
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().x(17, paramg.field_localId);
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getModService().run();
      return;
    }
    paramg.field_itemStatus = 9;
    ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
    ((ae)com.tencent.mm.kernel.g.t(ae.class)).getSendService().run();
  }
  
  public static void m(g paramg)
  {
    if (paramg == null) {}
    for (;;)
    {
      return;
      if ((paramg.field_itemStatus != 8) && (paramg.field_itemStatus != 10)) {
        break;
      }
      paramg.field_itemStatus = 7;
      Object localObject = paramg.field_favProto.sXc;
      if (((List)localObject).size() != 0)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          xv localxv = (xv)((Iterator)localObject).next();
          a(paramg, localxv, true);
          a(paramg, localxv);
        }
      }
    }
    y.e("MicroMsg.Fav.FavApiLogic", "status not download failed or done!");
  }
  
  public static long n(long paramLong, int paramInt)
  {
    y.i("MicroMsg.Fav.FavApiLogic", "tryStartBatchGet...");
    long l1 = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().t(paramLong, paramInt);
    long l2 = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().r(paramLong, paramInt);
    y.v("MicroMsg.Fav.FavApiLogic", "klem, tryStartBatchGet, batchGetTime:%d, itemTiem:%d, updateTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(paramLong) });
    if (l1 == 0L) {
      return l2;
    }
    Object localObject = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().s(l1, paramInt);
    if (((LinkedList)localObject).size() > 0)
    {
      y.i("MicroMsg.Fav.FavApiLogic", "klem, tryStartBatchGet, batchGetTime:%d, itemTiem:%d, updateTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(paramLong) });
      y.i("MicroMsg.Fav.FavApiLogic", "klem, tryStartBatchGet, need batch get idList size:%d", new Object[] { Integer.valueOf(((LinkedList)localObject).size()) });
      localObject = new ah((LinkedList)localObject);
      if (!com.tencent.mm.kernel.g.Dk().a((com.tencent.mm.ah.m)localObject, 0))
      {
        y.w("MicroMsg.Fav.FavApiLogic", "do scene BatchGetFav fail");
        ah.aQG();
      }
    }
    if (l2 == 0L) {
      return l1;
    }
    if (l1 < l2) {
      return l1;
    }
    return l2;
  }
  
  public static void n(g paramg)
  {
    if (!paramg.aPZ())
    {
      y.e("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, not uploading");
      return;
    }
    y.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, itemStatu:%d", new Object[] { Integer.valueOf(paramg.field_itemStatus) });
    Iterator localIterator = paramg.field_favProto.sXc.iterator();
    while (localIterator.hasNext())
    {
      xv localxv = (xv)localIterator.next();
      c localc = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().CN(localxv.kgC);
      if ((localc != null) && (localc.field_status != 3))
      {
        localc.field_status = 2;
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnService().CM(localxv.kgC);
      }
      localc = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().CN(Cw(localxv.kgC));
      if ((localc != null) && (localc.field_status != 3))
      {
        localc.field_status = 2;
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnService().CM(Cw(localxv.kgC));
      }
    }
    paramg = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(paramg.field_localId);
    y.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, after pause data itemStatu:%d", new Object[] { Integer.valueOf(paramg.field_itemStatus) });
    switch (paramg.field_itemStatus)
    {
    default: 
      return;
    case 1: 
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().x(3, paramg.field_localId);
      y.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(3) });
      return;
    case 4: 
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().x(6, paramg.field_localId);
      y.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(6) });
      return;
    case 9: 
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().x(11, paramg.field_localId);
      y.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(11) });
      return;
    case 12: 
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().x(14, paramg.field_localId);
      y.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(14) });
      return;
    case 15: 
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().x(16, paramg.field_localId);
      y.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(16) });
      return;
    }
    ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().x(18, paramg.field_localId);
    y.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[] { Integer.valueOf(18) });
  }
  
  public static boolean o(g paramg)
  {
    if (paramg == null) {}
    xv localxv;
    do
    {
      return false;
      localxv = c(paramg);
    } while (localxv == null);
    long l = bk.UZ();
    com.tencent.mm.plugin.sight.base.a locala = com.tencent.mm.plugin.sight.base.d.MH(b(localxv));
    int j;
    int i;
    boolean bool;
    if (locala != null)
    {
      j = locala.bAT();
      i = localxv.duration;
      if ((i <= 0) || (Math.abs(i - j) >= 2))
      {
        localxv.EG(j);
        bool = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
      }
    }
    for (;;)
    {
      y.i("MicroMsg.Fav.FavApiLogic", "repair video duration[%d TO %d] %b cost time %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool), Long.valueOf(bk.cp(l)) });
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
    j localj = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavSearchStorage().eH(paramg.field_localId);
    if (localj == null)
    {
      localj = new j();
      localj.field_localId = paramg.field_localId;
    }
    for (int i = 1;; i = 0)
    {
      localj.field_tagContent = "";
      Iterator localIterator = paramg.field_tagProto.sXp.iterator();
      String str;
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        localj.field_tagContent = (localj.field_tagContent + " " + str);
      }
      localIterator = paramg.field_tagProto.sXq.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        localj.field_tagContent = (localj.field_tagContent + " " + str);
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavTagSetMgr().CI(str);
      }
      localj.field_content = "";
      localj.field_time = paramg.field_updateTime;
      localj.field_type = paramg.field_type;
      if (i != 0)
      {
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavSearchStorage().a(localj);
        return;
      }
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavSearchStorage().a(localj, new String[] { "localId" });
      return;
    }
  }
  
  public static void q(g paramg)
  {
    if (paramg == null) {}
    yd localyd;
    do
    {
      return;
      localyd = paramg.field_favProto.sro;
    } while (((localyd != null) && (!bk.bl(localyd.sWU))) || (paramg.field_type != 18));
    if (paramg.field_favProto.sXa.bIl == 6) {
      b(paramg, false);
    }
    for (;;)
    {
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
      return;
      b(paramg, true);
    }
  }
  
  public static boolean qU(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = a.jYn;
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
  
  public static final String r(g paramg)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    long l;
    label132:
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
      return localStringBuffer.toString();
    case 2: 
    case 8: 
      paramg = paramg.field_favProto.sXc.iterator();
      l = 0L;
      if (paramg.hasNext())
      {
        localObject = (xv)paramg.next();
        if (localObject == null) {
          break label435;
        }
        l = ((xv)localObject).sVb + l;
      }
      break;
    }
    label432:
    label435:
    for (;;)
    {
      for (;;)
      {
        break label132;
        localStringBuffer.append(l);
        break;
        if (bk.bl(paramg.field_favProto.desc)) {
          break;
        }
        localStringBuffer.append(paramg.field_favProto.desc.getBytes().length);
        break;
        localStringBuffer.append(c(paramg).duration);
        break;
        localObject = "";
        try
        {
          paramg = paramg.field_favProto.sWh.sXG;
          localStringBuffer.append(paramg);
          break;
          if (paramg == null) {
            break;
          }
          paramg = paramg.field_favProto.sXc.iterator();
          int m = 0;
          int k = 0;
          int i = 0;
          int j = 0;
          while (paramg.hasNext())
          {
            localObject = (xv)paramg.next();
            switch (((xv)localObject).aYU)
            {
            case 3: 
            default: 
              i += 1;
              break;
            case 1: 
              if (bk.bl(((xv)localObject).desc)) {
                break label432;
              }
              k = ((xv)localObject).desc.getBytes().length + k;
              break;
            case 2: 
              m += 1;
              break;
            case 4: 
              j += 1;
            }
          }
          return String.format("%d:%d:%d:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(i) });
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
    aj localaj = new aj();
    com.tencent.mm.kernel.g.Dk().a(localaj, 0);
  }
  
  public static void w(Intent paramIntent, Context paramContext)
  {
    if (paramContext != null)
    {
      paramIntent.putExtra("Ksnsupload_type", 1);
      com.tencent.mm.br.d.b(paramContext, "sns", ".ui.SnsUploadUI", paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.b
 * JD-Core Version:    0.7.0.1
 */