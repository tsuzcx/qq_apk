package com.tencent.mm.plugin.finder.ui.sharerel;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.cgi.dc;
import com.tencent.mm.protocal.protobuf.bzg;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/sharerel/WxaAdReporter;", "", "context", "Landroid/app/Activity;", "wxaAdInfo", "Lcom/tencent/mm/protocal/protobuf/FinderWxaAdFlowInfo;", "(Landroid/app/Activity;Lcom/tencent/mm/protocal/protobuf/FinderWxaAdFlowInfo;)V", "TAG", "", "clickAdTimeMs", "", "getContext", "()Landroid/app/Activity;", "expTime", "feedbackGood", "feedbackJsonArray", "Lorg/json/JSONArray;", "feedbackType", "", "isClickAd", "", "getWxaAdInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderWxaAdFlowInfo;", "colletFeedbackInfo", "markClick", "", "reportAvatarClick", "reportCommentClick", "reportExpose", "reportFeedback", "reason", "", "reportFeedbackGood", "reportFirstPlay", "reportFollowClick", "reportForwardClick", "reportLikeClick", "reportNicknameClick", "reportNormalAction", "source", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  final bzg FYg;
  boolean FYh;
  long FYi;
  long FYj;
  final List<String> FYk;
  final String FYl;
  public final JSONArray FYm;
  final String TAG;
  private final Activity hHU;
  
  public b(Activity paramActivity, bzg parambzg)
  {
    AppMethodBeat.i(347827);
    this.hHU = paramActivity;
    this.FYg = parambzg;
    this.TAG = "Finder.WxaAdUIC";
    this.FYk = kotlin.a.p.listOf(new String[] { "dismatch", "duplicate", "quality" });
    this.FYl = "good";
    this.FYm = new JSONArray();
    AppMethodBeat.o(347827);
  }
  
  public final void aBh(String paramString)
  {
    AppMethodBeat.i(347873);
    try
    {
      Object localObject2 = this.FYg.aaiw;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      int i = new JSONObject((String)localObject1).optInt(paramString, -1);
      localObject2 = this.FYg.mxQ;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      JSONObject localJSONObject = new JSONObject((String)localObject1);
      localObject2 = localJSONObject.optJSONObject("weapp_extra_data");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new JSONObject();
      }
      localJSONObject.put("report_type", 2);
      localJSONObject.put("report_link", this.FYg.aaiv);
      localJSONObject.put("press_interval", 0);
      localJSONObject.put("click_pos", i);
      localJSONObject.put("pos_x", 0);
      localJSONObject.put("pos_y", 0);
      ((JSONObject)localObject1).put("exp_time", this.FYj);
      ((JSONObject)localObject1).put("clk_time", cn.bDw());
      localJSONObject.put("weapp_extra_data", ((JSONObject)localObject1).toString());
      Log.i(this.TAG, kotlin.g.b.s.X("reportNormalAction ", paramString));
      localObject1 = localJSONObject.toString();
      kotlin.g.b.s.s(localObject1, "json.toString()");
      localObject1 = new dc((String)localObject1);
      h.aZW().a((com.tencent.mm.am.p)localObject1, 0);
      AppMethodBeat.o(347873);
      return;
    }
    finally
    {
      Log.printErrStackTrace(this.TAG, localThrowable, kotlin.g.b.s.X("reportNormalAction ", paramString), new Object[0]);
      AppMethodBeat.o(347873);
    }
  }
  
  public final void fcZ()
  {
    AppMethodBeat.i(347837);
    fdb();
    aBh("follow");
    AppMethodBeat.o(347837);
  }
  
  public final void fda()
  {
    AppMethodBeat.i(347849);
    fdb();
    aBh("like");
    AppMethodBeat.o(347849);
  }
  
  public final void fdb()
  {
    AppMethodBeat.i(347855);
    this.FYh = true;
    this.FYi = cn.bDw();
    AppMethodBeat.o(347855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.sharerel.b
 * JD-Core Version:    0.7.0.1
 */