package com.tencent.mm.plugin.fts.ui.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.secdata.a.b;
import com.tencent.mm.plugin.secdata.g;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.al;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.aqo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fts/ui/logic/FTSRedDotLogic;", "", "()V", "RedDotExpireTime", "", "TAG", "", "getTAG", "()Ljava/lang/String;", "receiver", "Lcom/tencent/mm/plugin/messenger/foundation/api/INewXmlReceived;", "redDotMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/FTSRedDotData;", "Lkotlin/collections/HashMap;", "getRedDotMap", "()Ljava/util/HashMap;", "clickRedDot", "", "bizType", "getCurrRedDotMsgId", "needShowRedDot", "", "onCreate", "onDestroy", "showRedDot", "ui-fts_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  public static final k HBV;
  private static final t HBW;
  private static final String TAG;
  private static final HashMap<Long, aqo> qmm;
  
  static
  {
    AppMethodBeat.i(265618);
    HBV = new k();
    TAG = "MicroMsg.FTS.FTSRedDotLogic";
    qmm = new HashMap();
    HBW = k..ExternalSyntheticLambda0.INSTANCE;
    AppMethodBeat.o(265618);
  }
  
  private static final void a(int paramInt1, int paramInt2, boolean paramBoolean, b paramb, aqo paramaqo)
  {
    AppMethodBeat.i(265596);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("action:").append(paramInt2).append(" success:").append(paramBoolean).append(" bizType:");
    if (paramaqo == null) {}
    for (paramb = null;; paramb = Long.valueOf(paramaqo.ZxG))
    {
      Log.i(str, paramb);
      if (paramaqo != null) {
        qmm.put(Long.valueOf(paramInt1), paramaqo);
      }
      AppMethodBeat.o(265596);
      return;
    }
  }
  
  private static final void a(int paramInt, boolean paramBoolean, b paramb, aqo paramaqo)
  {
    AppMethodBeat.i(265603);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("action:").append(paramInt).append(" success:").append(paramBoolean).append(" bizType:");
    if (paramaqo == null) {}
    for (paramb = null;; paramb = Long.valueOf(paramaqo.ZxG))
    {
      Log.i(str, paramb);
      AppMethodBeat.o(265603);
      return;
    }
  }
  
  private static final void b(int paramInt, boolean paramBoolean, b paramb, aqo paramaqo)
  {
    AppMethodBeat.i(265613);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("action:").append(paramInt).append(" success:").append(paramBoolean).append(" bizType:");
    if (paramaqo == null) {}
    for (paramb = null;; paramb = Long.valueOf(paramaqo.ZxG))
    {
      Log.i(str, paramb);
      AppMethodBeat.o(265613);
      return;
    }
  }
  
  private static final void b(String paramString, Map paramMap, g.a parama)
  {
    AppMethodBeat.i(265609);
    if (s.p(paramString, "mmsearch_fts_reddot"))
    {
      paramString = new aqo();
      if (paramMap != null)
      {
        paramString.qvp = Util.safeParseInt((String)paramMap.get(".sysmsg.mmsearch_fts_reddot.android_cli_version"));
        paramString.msgId = Util.safeFormatString((String)paramMap.get(".sysmsg.mmsearch_fts_reddot.msgid"), new Object[0]);
        paramString.ZxF = Util.safeParseLong((String)paramMap.get(".sysmsg.mmsearch_fts_reddot.h5_version"));
        paramString.ZxG = Util.safeParseLong((String)paramMap.get(".sysmsg.mmsearch_fts_reddot.biz_type"));
        paramString.ZxH = Util.safeParseLong((String)paramMap.get(".sysmsg.mmsearch_fts_reddot.expose_expire_time"));
        paramString.ZxI = Util.safeParseInt((String)paramMap.get(".sysmsg.mmsearch_fts_reddot.reddot_action"));
      }
      ((Map)qmm).put(Long.valueOf(paramString.ZxG), paramString);
      ((g)h.az(g.class)).updateWithSave(12, String.valueOf(paramString.ZxG), (a)paramString, 604800000L, k..ExternalSyntheticLambda2.INSTANCE);
    }
    AppMethodBeat.o(265609);
  }
  
  private static final void c(int paramInt, boolean paramBoolean, b paramb, aqo paramaqo)
  {
    AppMethodBeat.i(265615);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("action:").append(paramInt).append(" success:").append(paramBoolean).append(" bizType:");
    if (paramaqo == null) {}
    for (paramb = null;; paramb = Long.valueOf(paramaqo.ZxG))
    {
      Log.i(str, paramb);
      AppMethodBeat.o(265615);
      return;
    }
  }
  
  public static void onCreate()
  {
    int j = 0;
    AppMethodBeat.i(265575);
    ((v)h.az(v.class)).getSysCmdMsgExtension().a("mmsearch_fts_reddot", HBW);
    JSONArray localJSONArray = al.bix("educationTab").optJSONArray("items");
    int i;
    if (localJSONArray != null)
    {
      if (localJSONArray.length() <= 0) {
        break label140;
      }
      i = 1;
      if (i == 0) {
        break label145;
      }
    }
    for (;;)
    {
      if (localJSONArray != null)
      {
        int k = localJSONArray.length();
        if (k > 0)
        {
          i = j;
          do
          {
            j = i + 1;
            JSONObject localJSONObject = localJSONArray.optJSONObject(i);
            if (localJSONObject != null)
            {
              i = localJSONObject.optInt("businessType");
              ((g)h.az(g.class)).getWithoutClear(12, String.valueOf(i), aqo.class, new k..ExternalSyntheticLambda1(i));
            }
            i = j;
          } while (j < k);
        }
      }
      AppMethodBeat.o(265575);
      return;
      label140:
      i = 0;
      break;
      label145:
      localJSONArray = null;
    }
  }
  
  public static void onDestroy()
  {
    AppMethodBeat.i(265592);
    qmm.clear();
    ((v)h.az(v.class)).getSysCmdMsgExtension().b("mmsearch_fts_reddot", HBW);
    AppMethodBeat.o(265592);
  }
  
  public static String rt(long paramLong)
  {
    AppMethodBeat.i(265567);
    Object localObject = (aqo)qmm.get(Long.valueOf(paramLong));
    if (localObject == null)
    {
      AppMethodBeat.o(265567);
      return "";
    }
    localObject = ((aqo)localObject).msgId;
    if (localObject == null)
    {
      AppMethodBeat.o(265567);
      return "";
    }
    AppMethodBeat.o(265567);
    return localObject;
  }
  
  public static boolean ru(long paramLong)
  {
    AppMethodBeat.i(265580);
    aqo localaqo = (aqo)qmm.get(Long.valueOf(paramLong));
    if (localaqo != null)
    {
      long l;
      if (localaqo.Fzm == 0L)
      {
        l = cn.bDw();
        if ((localaqo.ZxG != paramLong) || (localaqo.ZxI != 1) || (l + localaqo.ZxH * 1000L < cn.bDw()) || (d.Yxh < localaqo.qvp) || (aj.asY(0) < localaqo.ZxF)) {
          break label156;
        }
      }
      label156:
      for (boolean bool = true;; bool = false)
      {
        Log.i(TAG, "needShowRedDot " + bool + ' ' + paramLong);
        AppMethodBeat.o(265580);
        return bool;
        l = localaqo.Fzm;
        break;
      }
    }
    AppMethodBeat.o(265580);
    return false;
  }
  
  public static void rv(long paramLong)
  {
    AppMethodBeat.i(265584);
    aqo localaqo = (aqo)qmm.get(Long.valueOf(paramLong));
    if (localaqo != null)
    {
      if ((ru(paramLong)) && (localaqo.Fzm == 0L))
      {
        localaqo.Fzm = cn.bDw();
        ((g)h.az(g.class)).updateWithSave(12, String.valueOf(localaqo.ZxG), (a)localaqo, 604800000L, k..ExternalSyntheticLambda3.INSTANCE);
        Log.i(TAG, "showRedDot save reddot bizType:" + localaqo.ZxG + " exposeTimestamp:" + localaqo.Fzm + " redDotAction:" + localaqo.ZxI);
        AppMethodBeat.o(265584);
        return;
      }
      Log.i(TAG, "showRedDot not save currentBizType:" + localaqo.ZxG + " checkBizType:" + paramLong + " exposeTimestamp:" + localaqo.Fzm + " redDotAction:" + localaqo.ZxI);
    }
    AppMethodBeat.o(265584);
  }
  
  public static void rw(long paramLong)
  {
    AppMethodBeat.i(265589);
    Log.i(TAG, s.X("click reddot ", Long.valueOf(paramLong)));
    if (ru(paramLong))
    {
      qmm.remove(Long.valueOf(paramLong));
      ((g)h.az(g.class)).removeFromStorage(12, String.valueOf(paramLong), k..ExternalSyntheticLambda4.INSTANCE);
    }
    AppMethodBeat.o(265589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.c.k
 * JD-Core Version:    0.7.0.1
 */