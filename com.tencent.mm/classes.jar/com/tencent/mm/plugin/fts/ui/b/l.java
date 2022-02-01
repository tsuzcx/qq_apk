package com.tencent.mm.plugin.fts.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.an.h.a;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ck;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.fts.ui.widget.FTSMainUIEducationLayout;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.a.ae;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/fts/ui/logic/FTSRedDotLogic;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "currentFTSRedDot", "Lcom/tencent/mm/plugin/fts/ui/logic/FTSEducationRedDot;", "getCurrentFTSRedDot", "()Lcom/tencent/mm/plugin/fts/ui/logic/FTSEducationRedDot;", "setCurrentFTSRedDot", "(Lcom/tencent/mm/plugin/fts/ui/logic/FTSEducationRedDot;)V", "invaildRedDotsRemoveDelayMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getInvaildRedDotsRemoveDelayMap", "()Ljava/util/HashMap;", "receiver", "Lcom/tencent/mm/plugin/messenger/foundation/api/INewXmlReceived;", "redDotObj", "getRedDotObj", "checkRedValidDot", "", "searchEducationLayout", "Lcom/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout;", "clickRedDot", "bizType", "", "getCurrRedDotMsgId", "needShowRedDot", "", "onCreate", "onDestroy", "showRedDot", "ui-fts_release"})
public final class l
{
  public static final HashMap<String, g> BQk;
  public static final HashMap<String, g> BQl;
  public static g BQm;
  private static final t BQn;
  public static final l BQo;
  public static final String TAG = "MicroMsg.FTS.FTSRedDotLogic";
  
  static
  {
    AppMethodBeat.i(194522);
    BQo = new l();
    TAG = "MicroMsg.FTS.FTSRedDotLogic";
    BQk = new HashMap();
    BQl = new HashMap();
    BQn = (t)a.BQp;
    AppMethodBeat.o(194522);
  }
  
  public static boolean NH(long paramLong)
  {
    AppMethodBeat.i(194517);
    Object localObject = String.valueOf(paramLong);
    if ((BQk.containsKey(localObject)) && (ae.e((Map)BQk, localObject) != null)) {
      BQm = (g)ae.e((Map)BQk, localObject);
    }
    localObject = BQm;
    if (localObject != null)
    {
      boolean bool = ((g)localObject).NH(paramLong);
      AppMethodBeat.o(194517);
      return bool;
    }
    AppMethodBeat.o(194517);
    return false;
  }
  
  public static void NI(long paramLong)
  {
    AppMethodBeat.i(194519);
    Object localObject = String.valueOf(paramLong);
    if ((BQk.containsKey(localObject)) && (ae.e((Map)BQk, localObject) != null)) {
      BQm = (g)ae.e((Map)BQk, localObject);
    }
    localObject = BQm;
    if (localObject != null)
    {
      if ((((g)localObject).NH(paramLong)) && (((g)localObject).BQj == 0L))
      {
        ((g)localObject).BQj = cm.bfE();
        String str = ((g)localObject).erW();
        f localf = h.aHG();
        p.j(localf, "MMKernel.storage()");
        localf.aHp().set(ar.a.VrD, str);
        Log.i(((g)localObject).TAG, "showRedDot save reddot ".concat(String.valueOf(str)));
        AppMethodBeat.o(194519);
        return;
      }
      Log.i(((g)localObject).TAG, "showRedDot not save currentBizType:" + ((g)localObject).BQh + " checkBizType:" + paramLong + " exposeTimestamp:" + ((g)localObject).BQj + " redDotAction:" + ((g)localObject).BQi);
      AppMethodBeat.o(194519);
      return;
    }
    AppMethodBeat.o(194519);
  }
  
  public static void a(g paramg)
  {
    BQm = paramg;
  }
  
  public static void a(FTSMainUIEducationLayout paramFTSMainUIEducationLayout)
  {
    AppMethodBeat.i(194516);
    p.k(paramFTSMainUIEducationLayout, "searchEducationLayout");
    if (BQl.isEmpty())
    {
      AppMethodBeat.o(194516);
      return;
    }
    Iterator localIterator = ((Map)BQl).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (g)((Map.Entry)localObject).getValue();
      if ((!Util.isNullOrNil(str)) && (localObject != null) && (BQk.containsKey(str)) && (((g)localObject).equals(ae.e((Map)BQk, str))))
      {
        BQl.remove(str);
        BQk.remove(str);
        paramFTSMainUIEducationLayout.aIn(str);
      }
    }
    AppMethodBeat.o(194516);
  }
  
  public static HashMap<String, g> erX()
  {
    return BQk;
  }
  
  public static String erY()
  {
    Object localObject = BQm;
    if (localObject != null)
    {
      String str = ((g)localObject).msgId;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    return localObject;
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  public static void onCreate()
  {
    AppMethodBeat.i(194514);
    Object localObject = h.ag(v.class);
    p.j(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((v)localObject).getSysCmdMsgExtension().a("mmsearch_fts_reddot", BQn);
    localObject = h.aHG();
    p.j(localObject, "MMKernel.storage()");
    localObject = ((f)localObject).aHp().a(ar.a.VrD, "");
    int i;
    if (localObject != null) {
      if (((CharSequence)localObject).length() > 0) {
        i = 1;
      }
    }
    for (;;)
    {
      label84:
      g localg;
      if (i != 0)
      {
        if (localObject == null) {
          break label235;
        }
        localg = new g();
        p.k(localObject, "value");
      }
      try
      {
        i locali = new i((String)localObject);
        String str = locali.optString("msgId", "");
        p.j(str, "json.optString(\"msgId\", \"\")");
        localg.msgId = str;
        localg.BQf = locali.optLong("h5Version", 0L);
        localg.BQg = locali.optLong("exposeExpiredTime", 0L);
        localg.BQh = locali.optLong("bizType", 0L);
        localg.BQi = locali.optInt("redDotAction", 0);
        localg.BQj = locali.optLong("exposeTimestamp", 0L);
        label198:
        Log.i(TAG, "load from saveStr:".concat(String.valueOf(localObject)));
        BQm = localg;
        AppMethodBeat.o(194514);
        return;
        i = 0;
        continue;
        localObject = null;
        break label84;
        label235:
        AppMethodBeat.o(194514);
        return;
      }
      catch (Exception localException)
      {
        break label198;
      }
    }
  }
  
  public static void onDestroy()
  {
    AppMethodBeat.i(194520);
    BQm = null;
    BQk.clear();
    a locala = h.ag(v.class);
    p.j(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((v)locala).getSysCmdMsgExtension().b("mmsearch_fts_reddot", BQn);
    AppMethodBeat.o(194520);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "subType", "", "kotlin.jvm.PlatformType", "values", "", "", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "onNewXmlReceived"})
  static final class a
    implements t
  {
    public static final a BQp;
    
    static
    {
      AppMethodBeat.i(193479);
      BQp = new a();
      AppMethodBeat.o(193479);
    }
    
    public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, h.a parama)
    {
      AppMethodBeat.i(193477);
      if (p.h(paramString, "mmsearch_fts_reddot"))
      {
        paramString = l.BQo;
        paramString = new g();
        if (paramMap != null)
        {
          paramString.lZO = Util.safeParseInt((String)paramMap.get(".sysmsg.mmsearch_fts_reddot.android_cli_version"));
          parama = Util.safeFormatString((String)paramMap.get(".sysmsg.mmsearch_fts_reddot.msgid"), new Object[0]);
          p.j(parama, "Util.safeFormatString(va…S_MAIN_REDPOINT}.msgid\"])");
          p.k(parama, "<set-?>");
          paramString.msgId = parama;
          paramString.BQf = Util.safeParseLong((String)paramMap.get(".sysmsg.mmsearch_fts_reddot.h5_version"));
          paramString.BQh = Util.safeParseLong((String)paramMap.get(".sysmsg.mmsearch_fts_reddot.biz_type"));
          paramString.BQg = Util.safeParseLong((String)paramMap.get(".sysmsg.mmsearch_fts_reddot.expose_expire_time"));
          paramString.BQi = Util.safeParseInt((String)paramMap.get(".sysmsg.mmsearch_fts_reddot.reddot_action"));
        }
        paramMap = l.BQo;
        l.erX().put(String.valueOf(paramString.BQh), paramString);
        paramMap = paramString.erW();
        parama = h.aHG();
        p.j(parama, "MMKernel.storage()");
        parama.aHp().set(ar.a.VrD, paramMap);
        parama = l.BQo;
        Log.i(l.getTAG(), "receive reddot ".concat(String.valueOf(paramMap)));
        l.a(paramString);
      }
      AppMethodBeat.o(193477);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.l
 * JD-Core Version:    0.7.0.1
 */