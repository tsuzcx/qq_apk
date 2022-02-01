package com.tencent.mm.plugin.finder.ui.sharerel;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.protocal.protobuf.blp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.l;
import kotlin.o;
import org.json.JSONArray;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget;", "", "context", "Landroid/app/Activity;", "root", "Landroid/view/View;", "miniAppAdInfo", "Lcom/tencent/mm/protocal/protobuf/FinderWxaAdFlowInfo;", "reporter", "Lcom/tencent/mm/plugin/finder/ui/sharerel/WxaAdReporter;", "(Landroid/app/Activity;Landroid/view/View;Lcom/tencent/mm/protocal/protobuf/FinderWxaAdFlowInfo;Lcom/tencent/mm/plugin/finder/ui/sharerel/WxaAdReporter;)V", "TAG", "", "getContext", "()Landroid/app/Activity;", "feedbackFrameOne", "getFeedbackFrameOne", "()Landroid/view/View;", "setFeedbackFrameOne", "(Landroid/view/View;)V", "feedbackFrameTwo", "getFeedbackFrameTwo", "setFeedbackFrameTwo", "feedbackReasonIndex", "", "getFeedbackReasonIndex", "()I", "setFeedbackReasonIndex", "(I)V", "feedbackReasonView", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Landroid/widget/TextView;", "Lkotlin/collections/ArrayList;", "getFeedbackReasonView", "()Ljava/util/ArrayList;", "feedbackRootLayout", "Landroid/view/ViewGroup;", "getFeedbackRootLayout", "()Landroid/view/ViewGroup;", "setFeedbackRootLayout", "(Landroid/view/ViewGroup;)V", "getMiniAppAdInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderWxaAdFlowInfo;", "getReporter", "()Lcom/tencent/mm/plugin/finder/ui/sharerel/WxaAdReporter;", "getRoot", "clickUninterest", "", "index", "dismissFeedBackFrame", "doUninterest", "goExposeUrl", "onFeedBackDismiss", "showFeedBackFrameOne", "showFeedBackFrameTwo", "showToastAndDismiss", "plugin-finder_release"})
public final class a
{
  ViewGroup AyH;
  View AyI;
  View AyJ;
  int AyK;
  final ArrayList<o<TextView, View>> AyL;
  private final blp AyM;
  final b AyN;
  final String TAG;
  final Activity fDf;
  private final View jac;
  
  public a(Activity paramActivity, View paramView, blp paramblp, b paramb)
  {
    AppMethodBeat.i(271442);
    this.fDf = paramActivity;
    this.jac = paramView;
    this.AyM = paramblp;
    this.AyN = paramb;
    this.TAG = "Finder.WxaAdUIC";
    this.AyK = -1;
    this.AyL = new ArrayList();
    this.AyH = ((ViewGroup)this.jac.findViewById(b.f.feedback_root));
    paramActivity = this.AyH;
    if (paramActivity != null)
    {
      paramActivity = paramActivity.findViewById(b.f.feedback_frame_one);
      this.AyI = paramActivity;
      paramActivity = this.AyH;
      if (paramActivity == null) {
        break label634;
      }
      paramActivity = paramActivity.findViewById(b.f.feedback_frame_two);
      label133:
      this.AyJ = paramActivity;
      this.jac.findViewById(b.f.ad_btn).setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(278318);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          paramAnonymousView = this.AyO.AyH;
          if ((paramAnonymousView == null) || (paramAnonymousView.getVisibility() != 0))
          {
            paramAnonymousView = this.AyO;
            Log.i(paramAnonymousView.TAG, "showFeedBackFrameOne");
            localObject = paramAnonymousView.AyH;
            if (localObject != null) {
              ((ViewGroup)localObject).setVisibility(0);
            }
            localObject = paramAnonymousView.AyI;
            if (localObject != null) {
              ((View)localObject).setVisibility(0);
            }
            paramAnonymousView = paramAnonymousView.AyJ;
            if (paramAnonymousView != null) {
              paramAnonymousView.setVisibility(8);
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(278318);
        }
      });
      paramActivity = this.AyH;
      if (paramActivity != null) {
        paramActivity.setOnClickListener((View.OnClickListener)new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(285478);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            Log.i(this.AyO.TAG, "click root empty");
            this.AyO.ebP();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(285478);
          }
        });
      }
      paramActivity = this.AyI;
      if (paramActivity != null) {
        paramActivity.setOnClickListener((View.OnClickListener)5.AyP);
      }
      paramActivity = this.AyI;
      if (paramActivity != null)
      {
        paramActivity = paramActivity.findViewById(b.f.reason_one_layout);
        if (paramActivity != null) {
          paramActivity.setOnClickListener((View.OnClickListener)new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(286382);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
              Log.i(this.AyO.TAG, "click reason 1");
              paramAnonymousView = this.AyO.AyN;
              Log.i(paramAnonymousView.TAG, "reportFeedback");
              for (;;)
              {
                try
                {
                  localObject = new JSONObject();
                  ((JSONObject)localObject).put("type", paramAnonymousView.AyV);
                  ((JSONObject)localObject).put("expTime", paramAnonymousView.AyT);
                  if (!paramAnonymousView.AyR) {
                    continue;
                  }
                  i = 1;
                  ((JSONObject)localObject).put("isClickAd", i);
                  ((JSONObject)localObject).put("clickAdTimeMs", paramAnonymousView.AyS);
                  ((JSONObject)localObject).put("feedbackTimeMs", cm.bfE());
                  paramAnonymousView.AyW.put(localObject);
                }
                catch (Throwable localThrowable)
                {
                  int i;
                  Log.printErrStackTrace(paramAnonymousView.TAG, localThrowable, "reportFeedbackGood", new Object[0]);
                  continue;
                }
                this.AyO.ebQ();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(286382);
                return;
                i = 0;
              }
            }
          });
        }
      }
      paramActivity = this.AyI;
      if (paramActivity != null)
      {
        paramActivity = paramActivity.findViewById(b.f.reason_two_layout);
        if (paramActivity != null) {
          paramActivity.setOnClickListener((View.OnClickListener)new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(278703);
              Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
              Log.i(this.AyO.TAG, "click reason 2");
              paramAnonymousView = this.AyO;
              localObject1 = paramAnonymousView.AyH;
              if (localObject1 != null) {
                ((ViewGroup)localObject1).setVisibility(0);
              }
              localObject1 = paramAnonymousView.AyI;
              if (localObject1 != null) {
                ((View)localObject1).setVisibility(8);
              }
              localObject1 = paramAnonymousView.AyJ;
              if (localObject1 != null) {
                ((View)localObject1).setVisibility(0);
              }
              paramAnonymousView.AyK = -1;
              localObject1 = paramAnonymousView.AyJ;
              if (localObject1 != null)
              {
                localObject1 = ((View)localObject1).findViewById(b.f.feed_back_ok_btn);
                if (localObject1 != null) {
                  ((View)localObject1).setVisibility(8);
                }
              }
              localObject1 = ((Iterable)paramAnonymousView.AyL).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                Object localObject2 = (o)((Iterator)localObject1).next();
                TextView localTextView = (TextView)((o)localObject2).Mx;
                if (localTextView != null) {
                  localTextView.setTextColor(paramAnonymousView.fDf.getResources().getColor(b.c.UN_BW_0_Alpha_0_9));
                }
                localObject2 = (View)((o)localObject2).My;
                if (localObject2 != null) {
                  ((View)localObject2).setBackgroundResource(b.e.finder_ad_option_btn_bg1);
                }
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(278703);
            }
          });
        }
      }
      paramActivity = this.AyI;
      if (paramActivity != null)
      {
        paramActivity = paramActivity.findViewById(b.f.frame_one_expose_layout);
        if (paramActivity != null) {
          paramActivity.setOnClickListener((View.OnClickListener)new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(268337);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              a.a(this.AyO);
              this.AyO.ebP();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(268337);
            }
          });
        }
      }
      paramActivity = this.AyJ;
      if (paramActivity != null) {
        paramActivity.setOnClickListener((View.OnClickListener)9.AyQ);
      }
      paramActivity = this.AyJ;
      if (paramActivity != null)
      {
        paramView = paramActivity.findViewById(b.f.reason_three_layout);
        if (paramView != null)
        {
          paramActivity = this.AyJ;
          if (paramActivity == null) {
            break label639;
          }
          paramActivity = (TextView)paramActivity.findViewById(b.f.reason_three_tv);
          label373:
          this.AyL.add(new o(paramActivity, paramView));
          paramView.setOnClickListener((View.OnClickListener)new a(this));
        }
      }
      paramActivity = this.AyJ;
      if (paramActivity != null)
      {
        paramView = paramActivity.findViewById(b.f.reason_four_layout);
        if (paramView != null)
        {
          paramActivity = this.AyJ;
          if (paramActivity == null) {
            break label644;
          }
          paramActivity = (TextView)paramActivity.findViewById(b.f.reason_four_tv);
          label446:
          this.AyL.add(new o(paramActivity, paramView));
          paramView.setOnClickListener((View.OnClickListener)new b(this));
        }
      }
      paramActivity = this.AyJ;
      if (paramActivity != null)
      {
        paramView = paramActivity.findViewById(b.f.reason_five_layout);
        if (paramView != null)
        {
          paramActivity = this.AyJ;
          if (paramActivity == null) {
            break label649;
          }
        }
      }
    }
    label644:
    label649:
    for (paramActivity = (TextView)paramActivity.findViewById(b.f.reason_five_tv);; paramActivity = null)
    {
      this.AyL.add(new o(paramActivity, paramView));
      paramView.setOnClickListener((View.OnClickListener)new c(this));
      paramActivity = this.AyJ;
      if (paramActivity != null)
      {
        paramActivity = paramActivity.findViewById(b.f.feed_back_ok_btn);
        if (paramActivity != null) {
          paramActivity.setOnClickListener((View.OnClickListener)new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(287062);
              localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
              paramAnonymousView = this.AyO;
              Log.i(paramAnonymousView.TAG, "doUninterest");
              localObject = paramAnonymousView.AyN;
              int i = paramAnonymousView.AyK;
              Log.i(((b)localObject).TAG, "reportFeedback");
              if ((i >= 0) && (i < ((b)localObject).AyU.size())) {}
              for (;;)
              {
                try
                {
                  JSONObject localJSONObject = new JSONObject();
                  localJSONObject.put("type", ((b)localObject).AyU.get(i));
                  localJSONObject.put("expTime", ((b)localObject).AyT);
                  if (!((b)localObject).AyR) {
                    continue;
                  }
                  i = 1;
                  localJSONObject.put("isClickAd", i);
                  localJSONObject.put("clickAdTimeMs", ((b)localObject).AyS);
                  localJSONObject.put("feedbackTimeMs", cm.bfE());
                  ((b)localObject).AyW.put(localJSONObject);
                }
                catch (Throwable localThrowable)
                {
                  Log.printErrStackTrace(((b)localObject).TAG, localThrowable, "reportFeedback", new Object[0]);
                  continue;
                }
                paramAnonymousView.ebQ();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(287062);
                return;
                i = 0;
              }
            }
          });
        }
      }
      paramActivity = this.AyJ;
      if (paramActivity == null) {
        break label654;
      }
      paramActivity = paramActivity.findViewById(b.f.frame_two_expose_layout);
      if (paramActivity == null) {
        break label654;
      }
      paramActivity.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(288663);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          a.a(this.AyO);
          this.AyO.ebP();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(288663);
        }
      });
      AppMethodBeat.o(271442);
      return;
      paramActivity = null;
      break;
      label634:
      paramActivity = null;
      break label133;
      label639:
      paramActivity = null;
      break label373;
      paramActivity = null;
      break label446;
    }
    label654:
    AppMethodBeat.o(271442);
  }
  
  final void ebP()
  {
    AppMethodBeat.i(271440);
    ViewGroup localViewGroup = this.AyH;
    if (localViewGroup != null)
    {
      localViewGroup.setVisibility(8);
      AppMethodBeat.o(271440);
      return;
    }
    AppMethodBeat.o(271440);
  }
  
  final void ebQ()
  {
    AppMethodBeat.i(271441);
    w.cR((Context)this.fDf, this.fDf.getResources().getString(b.j.finder_ad_feedback_finish));
    ebP();
    AppMethodBeat.o(271441);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget$8$1"})
  static final class a
    implements View.OnClickListener
  {
    a(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(278169);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget$$special$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      a.a(this.AyO, 0);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget$$special$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(278169);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget$9$1"})
  static final class b
    implements View.OnClickListener
  {
    b(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(270865);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget$$special$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      a.a(this.AyO, 1);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget$$special$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(270865);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget$10$1"})
  static final class c
    implements View.OnClickListener
  {
    c(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(289983);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget$$special$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      a.a(this.AyO, 2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/sharerel/WxaAdFeedbackWidget$$special$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(289983);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.sharerel.a
 * JD-Core Version:    0.7.0.1
 */