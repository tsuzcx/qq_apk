package com.tencent.mm.plugin.finder.ui.sharerel;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.cgi.cd;
import com.tencent.mm.protocal.protobuf.blp;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/sharerel/WxaAdReporter;", "", "context", "Landroid/app/Activity;", "wxaAdInfo", "Lcom/tencent/mm/protocal/protobuf/FinderWxaAdFlowInfo;", "(Landroid/app/Activity;Lcom/tencent/mm/protocal/protobuf/FinderWxaAdFlowInfo;)V", "TAG", "", "clickAdTimeMs", "", "getContext", "()Landroid/app/Activity;", "expTime", "feedbackGood", "feedbackJsonArray", "Lorg/json/JSONArray;", "feedbackType", "", "isClickAd", "", "getWxaAdInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderWxaAdFlowInfo;", "colletFeedbackInfo", "markClick", "", "reportAvatarClick", "reportCommentClick", "reportExpose", "reportFeedback", "reason", "", "reportFeedbackGood", "reportFirstPlay", "reportFollowClick", "reportForwardClick", "reportLikeClick", "reportNicknameClick", "reportNormalAction", "source", "plugin-finder_release"})
public final class b
{
  boolean AyR;
  long AyS;
  long AyT;
  final List<String> AyU;
  final String AyV;
  public final JSONArray AyW;
  final blp AyX;
  final String TAG;
  private final Activity fDf;
  
  public b(Activity paramActivity, blp paramblp)
  {
    AppMethodBeat.i(275487);
    this.fDf = paramActivity;
    this.AyX = paramblp;
    this.TAG = "Finder.WxaAdUIC";
    this.AyU = j.listOf(new String[] { "dismatch", "duplicate", "quality" });
    this.AyV = "good";
    this.AyW = new JSONArray();
    AppMethodBeat.o(275487);
  }
  
  public final void aFi(String paramString)
  {
    AppMethodBeat.i(275486);
    try
    {
      Object localObject2 = this.AyX.SWG;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      int i = new JSONObject((String)localObject1).optInt(paramString, -1);
      localObject2 = this.AyX.jXW;
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
      localJSONObject.put("report_link", this.AyX.SWF);
      localJSONObject.put("press_interval", 0);
      localJSONObject.put("click_pos", i);
      localJSONObject.put("pos_x", 0);
      localJSONObject.put("pos_y", 0);
      ((JSONObject)localObject1).put("exp_time", this.AyT);
      ((JSONObject)localObject1).put("clk_time", cm.bfE());
      localJSONObject.put("weapp_extra_data", ((JSONObject)localObject1).toString());
      Log.i(this.TAG, "reportNormalAction ".concat(String.valueOf(paramString)));
      localObject1 = localJSONObject.toString();
      p.j(localObject1, "json.toString()");
      localObject1 = new cd((String)localObject1);
      h.aGY().b((q)localObject1);
      AppMethodBeat.o(275486);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace(this.TAG, localThrowable, "reportNormalAction ".concat(String.valueOf(paramString)), new Object[0]);
      AppMethodBeat.o(275486);
    }
  }
  
  public final void ebR()
  {
    AppMethodBeat.i(275482);
    ebT();
    aFi("follow");
    AppMethodBeat.o(275482);
  }
  
  public final void ebS()
  {
    AppMethodBeat.i(275483);
    ebT();
    aFi("like");
    AppMethodBeat.o(275483);
  }
  
  public final void ebT()
  {
    AppMethodBeat.i(275485);
    this.AyR = true;
    this.AyS = cm.bfE();
    AppMethodBeat.o(275485);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.sharerel.b
 * JD-Core Version:    0.7.0.1
 */