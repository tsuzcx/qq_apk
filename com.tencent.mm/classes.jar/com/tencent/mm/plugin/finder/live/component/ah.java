package com.tencent.mm.plugin.finder.live.component;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.q.h;
import com.tencent.mm.plugin.finder.live.widget.w;
import com.tencent.mm.protocal.protobuf.bgj;
import com.tencent.mm.protocal.protobuf.bgq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.a.m;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$ViewCallback;", "rootView", "Landroid/view/View;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$Presenter;", "(Landroid/view/View;Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$Presenter;)V", "MAX_INPUT_CHINESE_LENGTH", "", "MAX_INPUT_CHINESE_SIZE", "MAX_INPUT_NUMBER_LENGTH", "MAX_INPUT_NUMBER_SIZE", "TAG", "", "getTAG", "()Ljava/lang/String;", "attendType", "getAttendType", "()Landroid/view/View;", "setAttendType", "(Landroid/view/View;)V", "attendTypeTxt", "Landroid/widget/TextView;", "getAttendTypeTxt", "()Landroid/widget/TextView;", "setAttendTypeTxt", "(Landroid/widget/TextView;)V", "commentContentEt", "Landroid/widget/EditText;", "getCommentContentEt", "()Landroid/widget/EditText;", "setCommentContentEt", "(Landroid/widget/EditText;)V", "commentContentGroup", "getCommentContentGroup", "setCommentContentGroup", "confirmBtn", "Landroid/widget/Button;", "getConfirmBtn", "()Landroid/widget/Button;", "setConfirmBtn", "(Landroid/widget/Button;)V", "confirmBtnContainer", "getConfirmBtnContainer", "setConfirmBtnContainer", "descContainer", "getDescContainer", "setDescContainer", "descTxt", "getDescTxt", "setDescTxt", "durationContainer", "Landroid/widget/RelativeLayout;", "getDurationContainer", "()Landroid/widget/RelativeLayout;", "setDurationContainer", "(Landroid/widget/RelativeLayout;)V", "durationTxt", "getDurationTxt", "setDurationTxt", "exception", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveExceptionWidget;", "lotteryTypeChooserDialog", "Lcom/tencent/mm/ui/widget/dialog/MMHalfBottomDialog;", "repeatCheck", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "getRepeatCheck", "()Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "setRepeatCheck", "(Lcom/tencent/mm/ui/widget/MMSwitchBtn;)V", "repeatGroup", "getRepeatGroup", "setRepeatGroup", "repeatTips", "getRepeatTips", "setRepeatTips", "slideHideAnim", "Landroid/animation/ObjectAnimator;", "getSlideHideAnim", "()Landroid/animation/ObjectAnimator;", "setSlideHideAnim", "(Landroid/animation/ObjectAnimator;)V", "slideShowAnim", "getSlideShowAnim", "setSlideShowAnim", "statement", "getStatement", "setStatement", "topWaringView", "getTopWaringView", "setTopWaringView", "winnerContainer", "getWinnerContainer", "setWinnerContainer", "winnerTxt", "getWinnerTxt", "setWinnerTxt", "adjustConfirmBtnLayout", "", "show", "", "height", "checkCommentContentGroupVisibility", "type", "Lcom/tencent/mm/plugin/finder/live/component/LotteryCreateItem;", "chooserLotteryType", "pos", "destroy", "getActivity", "getPresenter", "hideInput", "et", "initView", "keyboardChange", "reportLooteryType", "setBtnStatus", "btn", "enable", "setLotteryTypeView", "showAlertDialog", "msg", "showAttendTypeDialog", "showErrMsg", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCreateLotteryResponse;", "showInput", "updateConfirmBtn", "canConfirm", "updateLotteryDurationTips", "valid", "updateLotteryInfo", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ah
  implements ae.b
{
  private View CzA;
  EditText CzB;
  private View CzC;
  private MMSwitchBtn CzD;
  private TextView CzE;
  private View CzF;
  private TextView CzG;
  private RelativeLayout CzH;
  EditText CzI;
  private RelativeLayout CzJ;
  EditText CzK;
  private View CzL;
  EditText CzM;
  private View CzN;
  private View CzO;
  com.tencent.mm.ui.widget.a.j CzP;
  private w CzQ;
  private ObjectAnimator CzR;
  private ObjectAnimator CzS;
  final ae.a Czu;
  private final int Czv;
  private final int Czw;
  private final int Czx;
  private final int Czy;
  TextView Czz;
  final String TAG;
  final MMActivity activity;
  private final View rootView;
  private Button ugK;
  
  public ah(View paramView, MMActivity paramMMActivity, ae.a parama)
  {
    AppMethodBeat.i(353085);
    this.rootView = paramView;
    this.activity = paramMMActivity;
    this.Czu = parama;
    this.TAG = "FinderLiveLotteryCreateViewCallback";
    this.Czv = 20;
    this.Czw = (this.Czv / 2);
    this.Czx = 8;
    this.Czy = (this.Czx / 2);
    AppMethodBeat.o(353085);
  }
  
  private final void a(Button paramButton, boolean paramBoolean)
  {
    AppMethodBeat.i(353122);
    if (paramBoolean)
    {
      if (com.tencent.mm.ui.aw.isDarkMode())
      {
        if (paramButton != null)
        {
          paramButton.setTextColor(this.rootView.getContext().getResources().getColor(p.b.BW_100_Alpha_0_8));
          AppMethodBeat.o(353122);
        }
      }
      else if (paramButton != null)
      {
        paramButton.setTextColor(this.rootView.getContext().getResources().getColor(p.b.White));
        AppMethodBeat.o(353122);
      }
    }
    else if (com.tencent.mm.ui.aw.isDarkMode())
    {
      if (paramButton != null)
      {
        paramButton.setTextColor(this.rootView.getContext().getResources().getColor(p.b.BW_100_Alpha_0_2));
        AppMethodBeat.o(353122);
      }
    }
    else if (paramButton != null) {
      paramButton.setTextColor(this.rootView.getContext().getResources().getColor(p.b.BW_0_Alpha_0_2));
    }
    AppMethodBeat.o(353122);
  }
  
  private static final void a(ah paramah, View paramView)
  {
    AppMethodBeat.i(353148);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramah);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramah, "this$0");
    paramah.CzP = new com.tencent.mm.ui.widget.a.j((Context)paramah.activity, 0, 2);
    paramView = View.inflate((Context)paramah.activity, p.f.Cey, null);
    com.tencent.mm.ui.aw.a((Paint)((TextView)paramView.findViewById(p.e.BXr)).getPaint(), 0.8F);
    localObject1 = paramView.findViewById(p.e.BXo);
    if (localObject1 != null) {
      ((View)localObject1).setOnClickListener(new ah..ExternalSyntheticLambda0(paramah));
    }
    localObject1 = paramah.CzP;
    if (localObject1 != null) {
      ((com.tencent.mm.ui.widget.a.j)localObject1).setHeaderView(paramView);
    }
    localObject1 = new RecyclerView((Context)paramah.activity);
    ((RecyclerView)localObject1).setHasFixedSize(true);
    ((RecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
    localObject2 = new ac();
    paramView = paramah.Czu;
    if (paramView == null)
    {
      paramView = null;
      ((ac)localObject2).dataList = paramView;
      ((ac)localObject2).CyZ = ((m)new e(paramah));
      ((RecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
      paramView = paramah.CzP;
      if (paramView != null) {
        paramView.setCustomView((View)localObject1);
      }
      paramView = ((RecyclerView)localObject1).getLayoutParams();
      if (paramView != null) {
        if (!(paramView instanceof ViewGroup.MarginLayoutParams)) {
          break label353;
        }
      }
    }
    label353:
    for (paramView = (ViewGroup.MarginLayoutParams)paramView;; paramView = null)
    {
      if (paramView != null) {
        paramView.bottomMargin = bf.bk(MMApplicationContext.getContext());
      }
      paramah = paramah.CzP;
      if (paramah != null) {
        paramah.dDn();
      }
      com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.h.Dsr, "");
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(353148);
      return;
      paramView = paramView.eiu();
      break;
    }
  }
  
  private static final void a(ah paramah, boolean paramBoolean)
  {
    AppMethodBeat.i(353131);
    s.u(paramah, "this$0");
    paramah = paramah.Czu;
    if (paramah != null) {
      paramah.qs(paramBoolean);
    }
    AppMethodBeat.o(353131);
  }
  
  private static final void b(ah paramah, View paramView)
  {
    AppMethodBeat.i(353158);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramah);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramah, "this$0");
    d(paramah.CzI);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(353158);
  }
  
  private static final void c(ah paramah, View paramView)
  {
    AppMethodBeat.i(353164);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramah);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramah, "this$0");
    d(paramah.CzK);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(353164);
  }
  
  private final void c(at paramat)
  {
    AppMethodBeat.i(353109);
    if (s.p(paramat.title, MMApplicationContext.getResources().getString(p.h.Cmx)))
    {
      paramat = this.CzA;
      if (paramat != null)
      {
        paramat.setVisibility(0);
        AppMethodBeat.o(353109);
      }
    }
    else
    {
      paramat = this.CzA;
      if (paramat != null) {
        paramat.setVisibility(8);
      }
    }
    AppMethodBeat.o(353109);
  }
  
  private static void d(EditText paramEditText)
  {
    Object localObject = null;
    AppMethodBeat.i(353097);
    if (paramEditText != null) {
      paramEditText.requestFocus();
    }
    if (paramEditText == null) {}
    for (;;)
    {
      localObject = (InputMethodManager)localObject;
      if (localObject != null) {
        ((InputMethodManager)localObject).showSoftInput((View)paramEditText, 0);
      }
      AppMethodBeat.o(353097);
      return;
      Context localContext = paramEditText.getContext();
      if (localContext != null) {
        localObject = localContext.getSystemService("input_method");
      }
    }
  }
  
  private static final void d(ah paramah, View paramView)
  {
    AppMethodBeat.i(353168);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramah);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramah, "this$0");
    d(paramah.CzM);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(353168);
  }
  
  private static final void e(ah paramah, View paramView)
  {
    AppMethodBeat.i(353173);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramah);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramah, "this$0");
    d(paramah.CzB);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(353173);
  }
  
  private static final void f(ah paramah, View paramView)
  {
    AppMethodBeat.i(353180);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramah);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramah, "this$0");
    paramView = com.tencent.mm.plugin.finder.utils.aw.Gjk;
    if (com.tencent.mm.plugin.finder.utils.aw.isFastClick())
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(353180);
      return;
    }
    paramah = paramah.Czu;
    if (paramah != null) {
      paramah.eix();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(353180);
  }
  
  private static final void g(ah paramah, View paramView)
  {
    AppMethodBeat.i(353189);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramah);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramah, "this$0");
    paramah = paramah.CzP;
    if (paramah != null) {
      paramah.cyW();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(353189);
  }
  
  public final void a(int paramInt, String paramString, bgj parambgj)
  {
    int i = 1;
    Object localObject2 = null;
    AppMethodBeat.i(353307);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("showErrMsg errorPage is empty:");
    boolean bool;
    if (parambgj == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label162;
      }
      bool = true;
      label45:
      localStringBuilder = localStringBuilder.append(bool).append(",type:");
      if (parambgj != null) {
        break label168;
      }
      localObject1 = null;
      label67:
      Log.i(str, localObject1 + ",errMsg:" + paramString);
      if (parambgj != null) {
        break label198;
      }
    }
    label162:
    label168:
    label198:
    for (Object localObject1 = null;; localObject1 = parambgj.ZGW)
    {
      if (localObject1 != null) {
        break label207;
      }
      localObject1 = (Context)this.activity;
      parambgj = paramString;
      if (paramString == null)
      {
        parambgj = this.rootView.getResources().getString(p.h.CjH);
        s.s(parambgj, "rootView.resources.getSt…live_create_lottery_fail)");
      }
      aa.showTextToast((Context)localObject1, parambgj);
      AppMethodBeat.o(353307);
      return;
      localObject1 = parambgj.ZGW;
      break;
      bool = false;
      break label45;
      localObject1 = parambgj.ZGW;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label67;
      }
      localObject1 = Integer.valueOf(((bgq)localObject1).type);
      break label67;
    }
    label207:
    if (parambgj == null)
    {
      paramString = null;
      if (paramString != null) {
        break label243;
      }
      parambgj = localObject2;
      label220:
      if (parambgj != null) {
        break label254;
      }
    }
    for (;;)
    {
      label343:
      if (parambgj == null)
      {
        AppMethodBeat.o(353307);
        return;
        paramString = parambgj.ZGW;
        break;
        label243:
        parambgj = Integer.valueOf(paramString.type);
        break label220;
        label254:
        if (parambgj.intValue() == 1)
        {
          if (paramString == null)
          {
            paramString = "";
            if (((CharSequence)paramString).length() != 0) {
              break label343;
            }
          }
          for (paramInt = i;; paramInt = 0)
          {
            if (paramInt != 0)
            {
              paramString = this.rootView.getResources().getString(p.h.CjH);
              s.s(paramString, "rootView.resources.getSt…live_create_lottery_fail)");
            }
            parambgj = com.tencent.mm.plugin.findersdk.d.a.Hdr;
            com.tencent.mm.plugin.findersdk.d.a.aDg(paramString);
            AppMethodBeat.o(353307);
            return;
            parambgj = paramString.wording;
            paramString = parambgj;
            if (parambgj != null) {
              break;
            }
            paramString = "";
            break;
          }
        }
      }
    }
    if (parambgj.intValue() == 2)
    {
      if (this.CzQ == null)
      {
        parambgj = this.rootView.findViewById(p.e.BQF);
        s.s(parambgj, "rootView.findViewById(R.…nder_live_post_forbidden)");
        this.CzQ = new w(parambgj);
      }
      parambgj = this.CzQ;
      if (parambgj != null)
      {
        localObject1 = w.EoA;
        parambgj.a(w.eAF(), paramString, paramInt, (kotlin.g.a.b)new f(this));
      }
    }
    AppMethodBeat.o(353307);
  }
  
  final void b(at paramat)
  {
    AppMethodBeat.i(353265);
    TextView localTextView = this.CzG;
    if (localTextView != null) {
      localTextView.setText((CharSequence)paramat.title);
    }
    c(paramat);
    AppMethodBeat.o(353265);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(353297);
    Object localObject = this.CzP;
    if (localObject != null) {
      ((com.tencent.mm.ui.widget.a.j)localObject).cyW();
    }
    localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.aC((Activity)this.activity);
    AppMethodBeat.o(353297);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(353256);
    this.Czz = ((TextView)this.rootView.findViewById(p.e.CbF));
    Object localObject1 = this.Czz;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = am.aixg;
      localObject2 = this.activity.getResources().getString(p.h.CmB);
      s.s(localObject2, "activity.resources.getSt…ve_lottery_duration_tips)");
      af.a locala = af.Czj;
      localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { Integer.valueOf(af.eiD()) }, 1));
      s.s(localObject2, "java.lang.String.format(format, *args)");
      ((TextView)localObject1).setText((CharSequence)localObject2);
    }
    this.CzC = this.rootView.findViewById(p.e.BXE);
    localObject1 = this.CzC;
    if (localObject1 == null)
    {
      localObject1 = null;
      this.CzD = ((MMSwitchBtn)localObject1);
      localObject1 = this.CzD;
      if (localObject1 != null) {
        ((MMSwitchBtn)localObject1).setSwitchListener(new ah..ExternalSyntheticLambda7(this));
      }
      localObject1 = this.rootView;
      if (localObject1 != null) {
        break label799;
      }
      localObject1 = null;
      label161:
      this.CzE = ((TextView)localObject1);
      this.CzF = this.rootView.findViewById(p.e.BBE);
      this.CzG = ((TextView)this.rootView.findViewById(p.e.BBF));
      this.CzA = this.rootView.findViewById(p.e.BCp);
      localObject1 = this.CzA;
      if (localObject1 != null) {
        break label813;
      }
      localObject1 = null;
      label222:
      this.CzB = ((EditText)localObject1);
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.a(this.CzB, this.Czv, this.Czw, (kotlin.g.a.a)new a(this));
      this.CzH = ((RelativeLayout)this.rootView.findViewById(p.e.duration));
      this.CzI = ((EditText)this.rootView.findViewById(p.e.BCP));
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.a(this.CzI, this.Czx, this.Czy, (kotlin.g.a.a)new b(this));
      this.CzJ = ((RelativeLayout)this.rootView.findViewById(p.e.Cct));
      this.CzK = ((EditText)this.rootView.findViewById(p.e.Ccw));
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.a(this.CzK, this.Czx, this.Czy, (kotlin.g.a.a)new c(this));
      this.CzL = this.rootView.findViewById(p.e.desc);
      this.CzM = ((EditText)this.rootView.findViewById(p.e.BCJ));
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.a(this.CzM, this.Czv, this.Czw, (kotlin.g.a.a)new d(this));
      localObject1 = com.tencent.mm.plugin.finder.accessibility.a.Ate;
      localObject1 = this.rootView.getContext();
      s.s(localObject1, "rootView.context");
      float f = com.tencent.mm.plugin.finder.accessibility.a.g((Context)localObject1, 17.0F);
      localObject1 = this.CzM;
      if (localObject1 != null) {
        ((EditText)localObject1).setTextSize(1, f);
      }
      localObject1 = (TextView)this.rootView.findViewById(p.e.BXF);
      if (localObject1 != null) {
        ((TextView)localObject1).setTextSize(1, f);
      }
      this.CzN = this.rootView.findViewById(p.e.BCv);
      this.CzO = this.rootView.findViewById(p.e.Cbr);
      this.ugK = ((Button)this.rootView.findViewById(p.e.confirm_btn));
      localObject1 = this.ugK;
      if (localObject1 != null) {
        break label827;
      }
    }
    label799:
    label813:
    label827:
    for (localObject1 = null;; localObject1 = ((Button)localObject1).getPaint())
    {
      com.tencent.mm.ui.aw.a((Paint)localObject1, 0.8F);
      qu(false);
      localObject1 = this.CzF;
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener(new ah..ExternalSyntheticLambda1(this));
      }
      localObject1 = this.CzH;
      if (localObject1 != null) {
        ((RelativeLayout)localObject1).setOnClickListener(new ah..ExternalSyntheticLambda5(this));
      }
      localObject1 = this.CzJ;
      if (localObject1 != null) {
        ((RelativeLayout)localObject1).setOnClickListener(new ah..ExternalSyntheticLambda3(this));
      }
      localObject1 = this.CzL;
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener(new ah..ExternalSyntheticLambda6(this));
      }
      localObject1 = this.CzA;
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener(new ah..ExternalSyntheticLambda2(this));
      }
      localObject1 = this.ugK;
      if (localObject1 != null) {
        ((Button)localObject1).setOnClickListener(new ah..ExternalSyntheticLambda4(this));
      }
      localObject1 = this.Czu;
      if (localObject1 != null)
      {
        localObject2 = ((ae.a)localObject1).eiv();
        if (localObject2 != null) {
          b((at)localObject2);
        }
        localObject2 = this.CzI;
        if (localObject2 != null) {
          ((EditText)localObject2).setHint((CharSequence)String.valueOf(((ae.a)localObject1).eiw()));
        }
        localObject2 = this.CzD;
        if (localObject2 != null) {
          ((MMSwitchBtn)localObject2).setCheck(((ae.a)localObject1).eiy());
        }
      }
      AppMethodBeat.o(353256);
      return;
      localObject1 = (MMSwitchBtn)((View)localObject1).findViewById(p.e.Cal);
      break;
      localObject1 = (TextView)((View)localObject1).findViewById(p.e.Cam);
      break label161;
      localObject1 = (EditText)((View)localObject1).findViewById(p.e.BCq);
      break label222;
    }
  }
  
  public final void keyboardChange(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(353274);
    Object localObject1 = this.CzN;
    label35:
    int i;
    label82:
    int j;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
        break label352;
      }
      localObject1 = (RelativeLayout.LayoutParams)localObject1;
      int k = MMApplicationContext.getContext().getResources().getDimensionPixelOffset(p.c.Edge_8A);
      if (localObject1 != null)
      {
        if (!paramBoolean) {
          break label405;
        }
        int m = bf.bf(MMApplicationContext.getContext()).y;
        localObject2 = this.CzN;
        if (localObject2 != null) {
          break label358;
        }
        i = 0;
        localObject2 = new int[2];
        TextView localTextView = this.CzE;
        if (localTextView != null) {
          localTextView.getLocationOnScreen((int[])localObject2);
        }
        int n = localObject2[1];
        localObject2 = this.CzE;
        if (localObject2 != null) {
          break label367;
        }
        j = 0;
        label125:
        int i1 = m - k - i - (n + j);
        Log.i(this.TAG, "adjustConfirmBtnLayout screenHeight:" + m + ", bottomSpaceHeight:" + k + ", confirmBtnContainerH:" + i + ",descContainerY:" + n + ",itemHeight:" + j + ",leftHeight:" + i1 + ",height:" + paramInt);
        if ((i != 0) && (n != 0) && (i1 > paramInt)) {
          break label377;
        }
        localObject2 = this.CzE;
        if (localObject2 != null)
        {
          paramInt = ((TextView)localObject2).getId();
          ((RelativeLayout.LayoutParams)localObject1).removeRule(2);
          ((RelativeLayout.LayoutParams)localObject1).removeRule(12);
          ((RelativeLayout.LayoutParams)localObject1).addRule(3, paramInt);
          ((RelativeLayout.LayoutParams)localObject1).bottomMargin = 0;
        }
        label287:
        localObject2 = this.CzN;
        if (localObject2 != null) {
          break label451;
        }
        localObject2 = null;
        label301:
        if (!(localObject2 instanceof ViewGroup)) {
          break label461;
        }
      }
    }
    label405:
    label451:
    label461:
    for (Object localObject2 = (ViewGroup)localObject2;; localObject2 = null)
    {
      if (localObject2 != null) {
        ((ViewGroup)localObject2).updateViewLayout(this.CzN, (ViewGroup.LayoutParams)localObject1);
      }
      AppMethodBeat.o(353274);
      return;
      localObject1 = ((View)localObject1).getLayoutParams();
      break;
      label352:
      localObject1 = null;
      break label35;
      label358:
      i = ((View)localObject2).getHeight();
      break label82;
      label367:
      j = ((TextView)localObject2).getHeight();
      break label125;
      label377:
      ((RelativeLayout.LayoutParams)localObject1).removeRule(2);
      ((RelativeLayout.LayoutParams)localObject1).removeRule(3);
      ((RelativeLayout.LayoutParams)localObject1).addRule(12);
      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = paramInt;
      break label287;
      localObject2 = this.CzO;
      if (localObject2 == null) {
        break label287;
      }
      paramInt = ((View)localObject2).getId();
      ((RelativeLayout.LayoutParams)localObject1).removeRule(3);
      ((RelativeLayout.LayoutParams)localObject1).removeRule(12);
      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = 0;
      ((RelativeLayout.LayoutParams)localObject1).addRule(2, paramInt);
      break label287;
      localObject2 = ((View)localObject2).getParent();
      break label301;
    }
  }
  
  public final void qt(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(353282);
    Object localObject;
    if (paramBoolean)
    {
      localObject = this.Czz;
      if (localObject != null)
      {
        if (((TextView)localObject).getVisibility() != 8)
        {
          if (this.CzS == null)
          {
            this.CzS = ObjectAnimator.ofFloat(localObject, "translationY", new float[] { 0.0F, -((TextView)localObject).getLayoutParams().height });
            localObject = this.CzS;
            if (localObject != null) {
              ((ObjectAnimator)localObject).addListener((Animator.AnimatorListener)new g(this));
            }
          }
          localObject = this.CzS;
          if ((localObject == null) || (((ObjectAnimator)localObject).isRunning() != true)) {
            break label132;
          }
        }
        for (;;)
        {
          if (i == 0)
          {
            localObject = this.CzS;
            if (localObject != null) {
              ((ObjectAnimator)localObject).start();
            }
          }
          AppMethodBeat.o(353282);
          return;
          label132:
          i = 0;
        }
      }
    }
    else
    {
      localObject = this.Czz;
      if ((localObject != null) && (((TextView)localObject).getVisibility() != 0))
      {
        ((TextView)localObject).setVisibility(0);
        if (this.CzR == null) {
          this.CzR = ObjectAnimator.ofFloat(localObject, "translationY", new float[] { -((TextView)localObject).getLayoutParams().height, 0.0F });
        }
        localObject = this.CzR;
        if ((localObject == null) || (((ObjectAnimator)localObject).isRunning() != true)) {
          break label238;
        }
      }
    }
    label238:
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = this.CzR;
        if (localObject != null) {
          ((ObjectAnimator)localObject).start();
        }
      }
      AppMethodBeat.o(353282);
      return;
    }
  }
  
  public final void qu(boolean paramBoolean)
  {
    AppMethodBeat.i(353290);
    Log.i(this.TAG, s.X("updateConfirmBtn canConfirm:", Boolean.valueOf(paramBoolean)));
    Button localButton = this.ugK;
    if (localButton != null) {
      localButton.setEnabled(paramBoolean);
    }
    a(this.ugK, paramBoolean);
    AppMethodBeat.o(353290);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    a(ah paramah)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    b(ah paramah)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    c(ah paramah)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    d(ah paramah)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "item", "Lcom/tencent/mm/plugin/finder/live/component/LotteryCreateItem;", "pos", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements m<at, Integer, kotlin.ah>
  {
    e(ah paramah)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "ok", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.b<Boolean, kotlin.ah>
  {
    f(ah paramah)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$updateLotteryDurationTips$1$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements Animator.AnimatorListener
  {
    g(ah paramah) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(353327);
      paramAnimator = this.CzT.Czz;
      if (paramAnimator != null) {
        paramAnimator.setVisibility(8);
      }
      AppMethodBeat.o(353327);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.ah
 * JD-Core Version:    0.7.0.1
 */