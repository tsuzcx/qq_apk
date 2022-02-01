package com.tencent.mm.plugin.ai.data.business.global;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ai;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.ai.d.e;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.extension.reddot.p;
import com.tencent.mm.plugin.finder.extension.reddot.q;
import com.tencent.mm.plugin.findersdk.a.bl;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.pointers.PFloat;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import com.tencent.mm.protocal.protobuf.adf;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  private static b qmj;
  
  public static String TM(String paramString)
  {
    AppMethodBeat.i(267681);
    try
    {
      p localp = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().Su(paramString);
      if (localp != null)
      {
        paramString = localp.avK(paramString);
        if ((paramString != null) && (paramString.aagu != null))
        {
          Object localObject = com.tencent.mm.ae.f.dg(localp.eav());
          if (localp.eav() != null) {}
          for (long l = localp.eav().object_id;; l = 0L)
          {
            ((JSONObject)localObject).put("object_id", com.tencent.mm.ae.d.hF(l));
            localObject = ((JSONObject)localObject).toString().replace(",", ";");
            paramString = String.format("{\"tipsid\":\"%s\";\"ctrltype\":%d;\"showtype\":%d;\"expose_count\":%d;\"first_expose_time\":%d;\"rece_time\":%d;\"redDotShowInfoExt\":%s}", new Object[] { localp.field_tipsId, Integer.valueOf(localp.field_ctrType), Integer.valueOf(paramString.show_type), Integer.valueOf(paramString.aagu.ZlK), Long.valueOf(paramString.aagu.ZlM), Long.valueOf(localp.field_time), localObject });
            AppMethodBeat.o(267681);
            return paramString;
          }
        }
      }
      return "";
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(267681);
    }
  }
  
  public static bxq a(p paramp)
  {
    AppMethodBeat.i(267559);
    if (paramp != null)
    {
      paramp = paramp.avK("FinderEntrance");
      AppMethodBeat.o(267559);
      return paramp;
    }
    AppMethodBeat.o(267559);
    return null;
  }
  
  public static bxq a(btw parambtw)
  {
    AppMethodBeat.i(267567);
    if (parambtw != null)
    {
      parambtw = parambtw.aabA;
      if ((parambtw != null) && (!parambtw.isEmpty()))
      {
        parambtw = parambtw.iterator();
        while (parambtw.hasNext())
        {
          bxq localbxq = (bxq)parambtw.next();
          if (Util.isEqual(localbxq.path, "FinderEntrance"))
          {
            AppMethodBeat.o(267567);
            return localbxq;
          }
        }
      }
    }
    AppMethodBeat.o(267567);
    return null;
  }
  
  private static JSONObject a(bxq parambxq)
  {
    AppMethodBeat.i(267687);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (parambxq.aagr == 1)
    {
      localObject1 = new FinderTipsShowEntranceExtInfo();
      ((FinderTipsShowEntranceExtInfo)localObject1).parseFrom(parambxq.aags.toByteArray());
      parambxq = ((FinderTipsShowEntranceExtInfo)localObject1).report_ext_info;
      localObject1 = localObject2;
      if (!Util.isNullOrNil(parambxq)) {
        localObject1 = new JSONObject(new String(com.tencent.mm.plugin.appbrand.ah.f.a.decode(parambxq), "UTF-8"));
      }
    }
    AppMethodBeat.o(267687);
    return localObject1;
  }
  
  private static void a(int[] paramArrayOfInt, PString paramPString1, PString paramPString2)
  {
    int i = 0;
    AppMethodBeat.i(267694);
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    StringBuffer localStringBuffer1 = new StringBuffer();
    StringBuffer localStringBuffer2 = new StringBuffer();
    while (i < 3)
    {
      int j = paramArrayOfInt[i];
      try
      {
        localPInt2.value = 0;
        localPInt1.value = 0;
        e.caH().qpp.c(j, localPInt1, localPInt2);
        localStringBuffer1.append(localPInt1.value).append("#");
        localStringBuffer2.append(localPInt2.value).append("#");
        i += 1;
      }
      catch (Exception paramArrayOfInt) {}
    }
    paramPString1.value = localStringBuffer1.toString();
    paramPString2.value = localStringBuffer2.toString();
    AppMethodBeat.o(267694);
  }
  
  public static boolean a(bxq parambxq, PInt paramPInt)
  {
    AppMethodBeat.i(267648);
    try
    {
      bZW();
      paramPInt.value = a(parambxq).optInt("live_sub_recall_type", 0);
      AppMethodBeat.o(267648);
      return true;
    }
    catch (Exception parambxq)
    {
      AppMethodBeat.o(267648);
      return false;
    }
    catch (JSONException parambxq)
    {
      label34:
      break label34;
    }
  }
  
  public static boolean a(bxq parambxq, PInt paramPInt, PString paramPString)
  {
    AppMethodBeat.i(267577);
    try
    {
      bZW();
      parambxq = a(parambxq);
      paramPInt.value = parambxq.optInt("push_type", 0);
      paramPString.value = parambxq.optString("scene", "");
      AppMethodBeat.o(267577);
      return true;
    }
    catch (Exception parambxq)
    {
      AppMethodBeat.o(267577);
      return false;
    }
    catch (JSONException parambxq)
    {
      label49:
      break label49;
    }
  }
  
  public static bxq b(p paramp)
  {
    AppMethodBeat.i(267633);
    if (paramp != null)
    {
      paramp = paramp.avK("FinderLiveEntrance");
      AppMethodBeat.o(267633);
      return paramp;
    }
    AppMethodBeat.o(267633);
    return null;
  }
  
  public static bxq b(btw parambtw)
  {
    AppMethodBeat.i(267641);
    if (parambtw != null)
    {
      parambtw = parambtw.aabA;
      if ((parambtw != null) && (!parambtw.isEmpty()))
      {
        parambtw = parambtw.iterator();
        while (parambtw.hasNext())
        {
          bxq localbxq = (bxq)parambtw.next();
          if (Util.isEqual(localbxq.path, "FinderLiveEntrance"))
          {
            AppMethodBeat.o(267641);
            return localbxq;
          }
        }
      }
    }
    AppMethodBeat.o(267641);
    return null;
  }
  
  public static String bZJ()
  {
    int j = -1;
    AppMethodBeat.i(267705);
    long l = Util.currentTicks();
    Object localObject1 = new JSONObject();
    for (;;)
    {
      try
      {
        ((JSONObject)localObject1).put("6", caa());
        ((JSONObject)localObject1).put("7", cab());
        Object localObject2 = q.ASF;
        ((JSONObject)localObject1).put("8", q.eaQ());
        localObject2 = q.ASF;
        ((JSONObject)localObject1).put("9", q.eaP());
        if (!bZX()) {
          continue;
        }
        i = 1;
        ((JSONObject)localObject1).put("10", i);
        ((JSONObject)localObject1).put("18", cah());
        ((JSONObject)localObject1).put("19", cai());
        localObject2 = q.ASF;
        ((JSONObject)localObject1).put("20", q.eaT());
        localObject2 = q.ASF;
        ((JSONObject)localObject1).put("21", q.eaS());
        if (!cae()) {
          continue;
        }
        i = 1;
        ((JSONObject)localObject1).put("22", i);
        ((JSONObject)localObject1).put("27", c.caj().cal());
        ((JSONObject)localObject1).put("28", NetStatusUtil.getIOSOldNetType(MMApplicationContext.getContext()));
        if (!f.cao().qmE) {
          continue;
        }
        i = 1;
        ((JSONObject)localObject1).put("29", i);
        e.caH();
        localObject2 = com.tencent.mm.plugin.ai.d.d.TV("calendar_statistics_discover");
        if (localObject2 != null)
        {
          ((JSONObject)localObject1).put("37", ((ai)localObject2).iog);
          ((JSONObject)localObject1).put("38", ((ai)localObject2).ioi);
        }
        e.caH();
        localObject2 = com.tencent.mm.plugin.ai.d.d.TV("calendar_statistics_finder");
        if (localObject2 != null)
        {
          ((JSONObject)localObject1).put("39", ((ai)localObject2).iog);
          ((JSONObject)localObject1).put("41", ((ai)localObject2).ioi);
          ((JSONObject)localObject1).put("42", ((ai)localObject2).iol);
          ((JSONObject)localObject1).put("43", ((ai)localObject2).iom);
          ((JSONObject)localObject1).put("44", ((ai)localObject2).ion);
          ((JSONObject)localObject1).put("45", ((ai)localObject2).ioj);
        }
        e.caH();
        localObject2 = com.tencent.mm.plugin.ai.d.d.TV("calendar_statistics_live");
        if (localObject2 != null)
        {
          ((JSONObject)localObject1).put("46", ((ai)localObject2).iog);
          ((JSONObject)localObject1).put("48", ((ai)localObject2).ioi);
          ((JSONObject)localObject1).put("49", ((ai)localObject2).iol);
          ((JSONObject)localObject1).put("50", ((ai)localObject2).iom);
          ((JSONObject)localObject1).put("51", ((ai)localObject2).ion);
          ((JSONObject)localObject1).put("52", ((ai)localObject2).ioj);
        }
        if (a.bZV() < 3) {
          continue;
        }
        i = 1;
        ((JSONObject)localObject1).put("58", i);
        localObject2 = new PFloat();
        a.a((PFloat)localObject2);
        ((JSONObject)localObject1).put("59", (int)(((PFloat)localObject2).value * 100.0F));
        ((JSONObject)localObject1).put("60", cac());
        ((JSONObject)localObject1).put("61", cad());
        localObject2 = d.cam();
        i = j;
        if (((d)localObject2).qmu != null) {
          i = Util.getInt(((d)localObject2).qmu.id, -1);
        }
        ((JSONObject)localObject1).put("62", i);
        localObject2 = new PString();
        PString localPString = new PString();
        a(new int[] { 5, 30, 60 }, (PString)localObject2, localPString);
        ((JSONObject)localObject1).put("63", ((PString)localObject2).value);
        ((JSONObject)localObject1).put("64", localPString.value);
        ((JSONObject)localObject1).put("9999", Util.ticksToNow(l));
        localObject1 = ((JSONObject)localObject1).toString();
      }
      catch (Exception localException)
      {
        int i;
        String str = "";
        continue;
      }
      Log.d("MicroMsg.AiFinderData", "checkToReturnAiFinderInfo json:%s", new Object[] { localObject1 });
      AppMethodBeat.o(267705);
      return localObject1;
      i = 0;
      continue;
      i = 0;
      continue;
      i = 0;
      continue;
      i = 0;
    }
  }
  
  public static b bZW()
  {
    AppMethodBeat.i(267531);
    if (qmj == null) {
      qmj = new b();
    }
    b localb = qmj;
    AppMethodBeat.o(267531);
    return localb;
  }
  
  public static boolean bZX()
  {
    AppMethodBeat.i(267539);
    boolean bool3 = ((cn)h.az(cn.class)).showFinderEntry();
    boolean bool1;
    if (!ju(34359738368L))
    {
      bool1 = true;
      if ((!((com.tencent.mm.plugin.teenmode.a.d)h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu()) || (((com.tencent.mm.plugin.teenmode.a.d)h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).eZD() != 2)) {
        break label128;
      }
    }
    label128:
    for (boolean bool2 = true;; bool2 = false)
    {
      Log.i("MicroMsg.AiFinderData", "[isShowFinderEntrance] show:%s open:%s, isTeenModeAndNothing:%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool3) || (!bool1) || (bool2)) {
        break label133;
      }
      AppMethodBeat.o(267539);
      return true;
      bool1 = false;
      break;
    }
    label133:
    AppMethodBeat.o(267539);
    return false;
  }
  
  public static boolean bZY()
  {
    AppMethodBeat.i(267545);
    boolean bool = ((cn)h.az(cn.class)).getRedDotManager().dZs();
    AppMethodBeat.o(267545);
    return bool;
  }
  
  public static p bZZ()
  {
    AppMethodBeat.i(267552);
    p localp = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().Su("FinderEntrance");
    AppMethodBeat.o(267552);
    return localp;
  }
  
  public static long caa()
  {
    AppMethodBeat.i(267580);
    long l = e.caH().qpt.TT("rece_finder_reddot_ms");
    AppMethodBeat.o(267580);
    return l;
  }
  
  public static long cab()
  {
    AppMethodBeat.i(267587);
    long l = e.caH().qpt.TT("last_expose_finder_reddot_ms");
    AppMethodBeat.o(267587);
    return l;
  }
  
  public static int cac()
  {
    AppMethodBeat.i(267593);
    int i = e.caH().qpt.TU("finder_drop_reddot_count");
    AppMethodBeat.o(267593);
    return i;
  }
  
  public static int cad()
  {
    AppMethodBeat.i(267603);
    int i = e.caH().qpt.TU("finder_deep_read_count");
    AppMethodBeat.o(267603);
    return i;
  }
  
  public static boolean cae()
  {
    AppMethodBeat.i(267610);
    boolean bool2 = ((com.tencent.mm.plugin.teenmode.a.d)h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu();
    if (!ju(9007199254740992L)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      com.tencent.mm.plugin.finder.nearby.abtest.a locala = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
      boolean bool3 = com.tencent.mm.plugin.finder.nearby.abtest.a.eEi();
      Log.i("MicroMsg.AiFinderData", "[isShowLiveEntrance] openLiveFriends:%s enableFinderLiveEntry:%s, isTeenMode:%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) || (!bool3) || (bool2)) {
        break;
      }
      AppMethodBeat.o(267610);
      return true;
    }
    AppMethodBeat.o(267610);
    return false;
  }
  
  public static boolean caf()
  {
    AppMethodBeat.i(267619);
    boolean bool = ((cn)h.az(cn.class)).getRedDotManager().dZv();
    AppMethodBeat.o(267619);
    return bool;
  }
  
  public static p cag()
  {
    AppMethodBeat.i(267627);
    p localp = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().Su("FinderLiveEntrance");
    AppMethodBeat.o(267627);
    return localp;
  }
  
  public static long cah()
  {
    AppMethodBeat.i(267657);
    long l = e.caH().qpt.TT("rece_finder_live_reddot_ms");
    AppMethodBeat.o(267657);
    return l;
  }
  
  public static long cai()
  {
    AppMethodBeat.i(267664);
    long l = e.caH().qpt.TT("last_expose_finder_live_reddot_ms");
    AppMethodBeat.o(267664);
    return l;
  }
  
  public static boolean ju(long paramLong)
  {
    AppMethodBeat.i(267672);
    if ((z.bAR() & paramLong) != 0L)
    {
      AppMethodBeat.o(267672);
      return true;
    }
    AppMethodBeat.o(267672);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.data.business.global.b
 * JD-Core Version:    0.7.0.1
 */