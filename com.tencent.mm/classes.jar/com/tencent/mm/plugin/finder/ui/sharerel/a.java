package com.tencent.mm.plugin.finder.ui.sharerel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.protocal.protobuf.bzg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.aa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.r;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget;", "", "context", "Landroid/app/Activity;", "root", "Landroid/view/View;", "miniAppAdInfo", "Lcom/tencent/mm/protocal/protobuf/FinderWxaAdFlowInfo;", "reporter", "Lcom/tencent/mm/plugin/finder/ui/sharerel/WxaAdReporter;", "(Landroid/app/Activity;Landroid/view/View;Lcom/tencent/mm/protocal/protobuf/FinderWxaAdFlowInfo;Lcom/tencent/mm/plugin/finder/ui/sharerel/WxaAdReporter;)V", "TAG", "", "getContext", "()Landroid/app/Activity;", "feedbackFrameOne", "getFeedbackFrameOne", "()Landroid/view/View;", "setFeedbackFrameOne", "(Landroid/view/View;)V", "feedbackFrameTwo", "getFeedbackFrameTwo", "setFeedbackFrameTwo", "feedbackReasonIndex", "", "getFeedbackReasonIndex", "()I", "setFeedbackReasonIndex", "(I)V", "feedbackReasonView", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Landroid/widget/TextView;", "Lkotlin/collections/ArrayList;", "getFeedbackReasonView", "()Ljava/util/ArrayList;", "feedbackRootLayout", "Landroid/view/ViewGroup;", "getFeedbackRootLayout", "()Landroid/view/ViewGroup;", "setFeedbackRootLayout", "(Landroid/view/ViewGroup;)V", "getMiniAppAdInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderWxaAdFlowInfo;", "getReporter", "()Lcom/tencent/mm/plugin/finder/ui/sharerel/WxaAdReporter;", "getRoot", "clickUninterest", "", "index", "dismissFeedBackFrame", "doUninterest", "goExposeUrl", "onFeedBackDismiss", "showFeedBackFrameOne", "showFeedBackFrameTwo", "showToastAndDismiss", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private final bzg FXZ;
  private final b FYa;
  private ViewGroup FYb;
  private View FYc;
  private View FYd;
  private int FYe;
  private final ArrayList<r<TextView, View>> FYf;
  private final String TAG;
  private final Activity hHU;
  private final View lBX;
  
  public a(Activity paramActivity, View paramView, bzg parambzg, b paramb)
  {
    AppMethodBeat.i(347826);
    this.hHU = paramActivity;
    this.lBX = paramView;
    this.FXZ = parambzg;
    this.FYa = paramb;
    this.TAG = "Finder.WxaAdUIC";
    this.FYe = -1;
    this.FYf = new ArrayList();
    this.FYb = ((ViewGroup)this.lBX.findViewById(e.e.feedback_root));
    paramActivity = this.FYb;
    if (paramActivity == null)
    {
      paramActivity = null;
      this.FYc = paramActivity;
      paramActivity = this.FYb;
      if (paramActivity != null) {
        break label569;
      }
      paramActivity = null;
      label124:
      this.FYd = paramActivity;
      this.lBX.findViewById(e.e.ad_btn).setOnClickListener(new a..ExternalSyntheticLambda2(this));
      paramActivity = this.FYb;
      if (paramActivity != null) {
        paramActivity.setOnClickListener(new a..ExternalSyntheticLambda4(this));
      }
      paramActivity = this.FYc;
      if (paramActivity != null) {
        paramActivity.setOnClickListener(a..ExternalSyntheticLambda11.INSTANCE);
      }
      paramActivity = this.FYc;
      if (paramActivity != null)
      {
        paramActivity = paramActivity.findViewById(e.e.reason_one_layout);
        if (paramActivity != null) {
          paramActivity.setOnClickListener(new a..ExternalSyntheticLambda3(this));
        }
      }
      paramActivity = this.FYc;
      if (paramActivity != null)
      {
        paramActivity = paramActivity.findViewById(e.e.reason_two_layout);
        if (paramActivity != null) {
          paramActivity.setOnClickListener(new a..ExternalSyntheticLambda8(this));
        }
      }
      paramActivity = this.FYc;
      if (paramActivity != null)
      {
        paramActivity = paramActivity.findViewById(e.e.frame_one_expose_layout);
        if (paramActivity != null) {
          paramActivity.setOnClickListener(new a..ExternalSyntheticLambda5(this));
        }
      }
      paramActivity = this.FYd;
      if (paramActivity != null) {
        paramActivity.setOnClickListener(a..ExternalSyntheticLambda10.INSTANCE);
      }
      paramActivity = this.FYd;
      if (paramActivity != null)
      {
        paramView = paramActivity.findViewById(e.e.reason_three_layout);
        if (paramView != null)
        {
          paramActivity = this.FYd;
          if (paramActivity != null) {
            break label580;
          }
          paramActivity = null;
          label334:
          this.FYf.add(new r(paramActivity, paramView));
          paramView.setOnClickListener(new a..ExternalSyntheticLambda7(this));
        }
      }
      paramActivity = this.FYd;
      if (paramActivity != null)
      {
        paramView = paramActivity.findViewById(e.e.reason_four_layout);
        if (paramView != null)
        {
          paramActivity = this.FYd;
          if (paramActivity != null) {
            break label594;
          }
          paramActivity = null;
          label395:
          this.FYf.add(new r(paramActivity, paramView));
          paramView.setOnClickListener(new a..ExternalSyntheticLambda9(this));
        }
      }
      paramActivity = this.FYd;
      if (paramActivity != null)
      {
        paramView = paramActivity.findViewById(e.e.reason_five_layout);
        if (paramView != null)
        {
          paramActivity = this.FYd;
          if (paramActivity != null) {
            break label608;
          }
        }
      }
    }
    label569:
    label580:
    label594:
    label608:
    for (paramActivity = localObject;; paramActivity = (TextView)paramActivity.findViewById(e.e.reason_five_tv))
    {
      this.FYf.add(new r(paramActivity, paramView));
      paramView.setOnClickListener(new a..ExternalSyntheticLambda1(this));
      paramActivity = this.FYd;
      if (paramActivity != null)
      {
        paramActivity = paramActivity.findViewById(e.e.feed_back_ok_btn);
        if (paramActivity != null) {
          paramActivity.setOnClickListener(new a..ExternalSyntheticLambda0(this));
        }
      }
      paramActivity = this.FYd;
      if (paramActivity != null)
      {
        paramActivity = paramActivity.findViewById(e.e.frame_two_expose_layout);
        if (paramActivity != null) {
          paramActivity.setOnClickListener(new a..ExternalSyntheticLambda6(this));
        }
      }
      AppMethodBeat.o(347826);
      return;
      paramActivity = paramActivity.findViewById(e.e.feedback_frame_one);
      break;
      paramActivity = paramActivity.findViewById(e.e.feedback_frame_two);
      break label124;
      paramActivity = (TextView)paramActivity.findViewById(e.e.reason_three_tv);
      break label334;
      paramActivity = (TextView)paramActivity.findViewById(e.e.reason_four_tv);
      break label395;
    }
  }
  
  private final void TK(int paramInt)
  {
    AppMethodBeat.i(347852);
    Log.i(this.TAG, s.X("clickUninterest ", Integer.valueOf(paramInt)));
    Object localObject1 = ((Iterable)this.FYf).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (r)((Iterator)localObject1).next();
      TextView localTextView = (TextView)((r)localObject2).bsC;
      if (localTextView != null) {
        localTextView.setTextColor(this.hHU.getResources().getColor(e.b.UN_BW_0_Alpha_0_9));
      }
      localObject2 = (View)((r)localObject2).bsD;
      if (localObject2 != null) {
        ((View)localObject2).setBackgroundResource(e.d.finder_ad_option_btn_bg1);
      }
    }
    if (this.FYe == paramInt)
    {
      this.FYe = -1;
      if (this.FYe >= 0)
      {
        localObject1 = this.FYd;
        if (localObject1 != null) {
          break label231;
        }
      }
    }
    label231:
    for (localObject1 = null;; localObject1 = ((View)localObject1).findViewById(e.e.feed_back_ok_btn))
    {
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      AppMethodBeat.o(347852);
      return;
      this.FYe = paramInt;
      localObject1 = (r)p.ae((List)this.FYf, paramInt);
      if (localObject1 == null) {
        break;
      }
      localObject2 = (TextView)((r)localObject1).bsC;
      if (localObject2 != null) {
        ((TextView)localObject2).setTextColor(this.hHU.getResources().getColor(e.b.Brand));
      }
      localObject1 = (View)((r)localObject1).bsD;
      if (localObject1 == null) {
        break;
      }
      ((View)localObject1).setBackgroundResource(e.d.finder_ad_option_btn_bg2);
      break;
    }
  }
  
  private static final void a(a parama, View paramView)
  {
    AppMethodBeat.i(347869);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    paramView = parama.FYb;
    if ((paramView != null) && (paramView.getVisibility() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        Log.i(parama.TAG, "showFeedBackFrameOne");
        paramView = parama.FYb;
        if (paramView != null) {
          paramView.setVisibility(0);
        }
        paramView = parama.FYc;
        if (paramView != null) {
          paramView.setVisibility(0);
        }
        parama = parama.FYd;
        if (parama != null) {
          parama.setVisibility(8);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(347869);
      return;
    }
  }
  
  private static final void b(a parama, View paramView)
  {
    AppMethodBeat.i(347872);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    Log.i(parama.TAG, "click root empty");
    parama.fcW();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(347872);
  }
  
  private static final void c(a parama, View paramView)
  {
    AppMethodBeat.i(347882);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    Log.i(parama.TAG, "click reason 1");
    paramView = parama.FYa;
    Log.i(paramView.TAG, "reportFeedback");
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("type", paramView.FYl);
        ((JSONObject)localObject).put("expTime", paramView.FYj);
        if (!paramView.FYh) {
          continue;
        }
        i = 1;
        ((JSONObject)localObject).put("isClickAd", i);
        ((JSONObject)localObject).put("clickAdTimeMs", paramView.FYi);
        ((JSONObject)localObject).put("feedbackTimeMs", cn.bDw());
        paramView.FYm.put(localObject);
      }
      finally
      {
        int i;
        Log.printErrStackTrace(paramView.TAG, localThrowable, "reportFeedbackGood", new Object[0]);
        continue;
      }
      parama.fcX();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(347882);
      return;
      i = 0;
    }
  }
  
  private static final void d(a parama, View paramView)
  {
    AppMethodBeat.i(347887);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    Log.i(parama.TAG, "click reason 2");
    parama.fcV();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(347887);
  }
  
  private static final void df(View paramView)
  {
    AppMethodBeat.i(347877);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(347877);
  }
  
  private static final void e(a parama, View paramView)
  {
    AppMethodBeat.i(347893);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    parama.fcY();
    parama.fcW();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(347893);
  }
  
  private static final void f(a parama, View paramView)
  {
    AppMethodBeat.i(347905);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    parama.TK(0);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(347905);
  }
  
  private final void fcV()
  {
    AppMethodBeat.i(347832);
    Object localObject1 = this.FYb;
    if (localObject1 != null) {
      ((ViewGroup)localObject1).setVisibility(0);
    }
    localObject1 = this.FYc;
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(8);
    }
    localObject1 = this.FYd;
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(0);
    }
    this.FYe = -1;
    localObject1 = this.FYd;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((View)localObject1).findViewById(e.e.feed_back_ok_btn))
    {
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      localObject1 = ((Iterable)this.FYf).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (r)((Iterator)localObject1).next();
        TextView localTextView = (TextView)((r)localObject2).bsC;
        if (localTextView != null) {
          localTextView.setTextColor(this.hHU.getResources().getColor(e.b.UN_BW_0_Alpha_0_9));
        }
        localObject2 = (View)((r)localObject2).bsD;
        if (localObject2 != null) {
          ((View)localObject2).setBackgroundResource(e.d.finder_ad_option_btn_bg1);
        }
      }
    }
    AppMethodBeat.o(347832);
  }
  
  private final void fcW()
  {
    AppMethodBeat.i(347839);
    ViewGroup localViewGroup = this.FYb;
    if (localViewGroup != null) {
      localViewGroup.setVisibility(8);
    }
    AppMethodBeat.o(347839);
  }
  
  private final void fcX()
  {
    AppMethodBeat.i(347847);
    aa.db((Context)this.hHU, this.hHU.getResources().getString(e.h.finder_ad_feedback_finish));
    fcW();
    AppMethodBeat.o(347847);
  }
  
  private final void fcY()
  {
    AppMethodBeat.i(347860);
    String str = this.TAG;
    Object localObject = this.FXZ;
    Intent localIntent;
    if (localObject == null)
    {
      localObject = null;
      Log.i(str, s.X("goExposeUrl ", localObject));
      localIntent = new Intent();
      localObject = this.FXZ;
      if (localObject != null) {
        break label95;
      }
      localObject = "";
    }
    for (;;)
    {
      localIntent.putExtra("rawUrl", (String)localObject);
      c.b((Context)this.hHU, "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(347860);
      return;
      localObject = ((bzg)localObject).zSx;
      break;
      label95:
      str = ((bzg)localObject).zSx;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
    }
  }
  
  private static final void g(a parama, View paramView)
  {
    AppMethodBeat.i(347910);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    parama.TK(1);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(347910);
  }
  
  private static final void gL(View paramView)
  {
    AppMethodBeat.i(347900);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(347900);
  }
  
  private static final void h(a parama, View paramView)
  {
    AppMethodBeat.i(347917);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    parama.TK(2);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(347917);
  }
  
  private static final void i(a parama, View paramView)
  {
    AppMethodBeat.i(347930);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    Log.i(parama.TAG, "doUninterest");
    paramView = parama.FYa;
    int i = parama.FYe;
    Log.i(paramView.TAG, "reportFeedback");
    if ((i >= 0) && (i < paramView.FYk.size())) {}
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("type", paramView.FYk.get(i));
        ((JSONObject)localObject).put("expTime", paramView.FYj);
        if (!paramView.FYh) {
          continue;
        }
        i = 1;
        ((JSONObject)localObject).put("isClickAd", i);
        ((JSONObject)localObject).put("clickAdTimeMs", paramView.FYi);
        ((JSONObject)localObject).put("feedbackTimeMs", cn.bDw());
        paramView.FYm.put(localObject);
      }
      finally
      {
        Log.printErrStackTrace(paramView.TAG, localThrowable, "reportFeedback", new Object[0]);
        continue;
      }
      parama.fcX();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(347930);
      return;
      i = 0;
    }
  }
  
  private static final void j(a parama, View paramView)
  {
    AppMethodBeat.i(347937);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    parama.fcY();
    parama.fcW();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(347937);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.sharerel.a
 * JD-Core Version:    0.7.0.1
 */