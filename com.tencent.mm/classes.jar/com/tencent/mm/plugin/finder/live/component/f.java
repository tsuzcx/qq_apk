package com.tencent.mm.plugin.finder.live.component;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s.f;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.avp;
import com.tencent.mm.protocal.protobuf.avr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.u;
import java.util.Arrays;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$ViewCallback;", "rootView", "Landroid/view/View;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$Presenter;", "(Landroid/view/View;Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$Presenter;)V", "LOTTERY_ANY_COMMENT", "", "LOTTERY_COMMENT", "LOTTERY_LIKE", "LOTTERY_SHOPPING", "LOTTERY_SPECIAL_COMMENT", "MAX_INPUT_CHINESE_LENGTH", "MAX_INPUT_CHINESE_SIZE", "MAX_INPUT_NUMBER_LENGTH", "MAX_INPUT_NUMBER_SIZE", "TAG", "", "getTAG", "()Ljava/lang/String;", "attendType", "getAttendType", "()Landroid/view/View;", "setAttendType", "(Landroid/view/View;)V", "attendTypeTxt", "Landroid/widget/TextView;", "getAttendTypeTxt", "()Landroid/widget/TextView;", "setAttendTypeTxt", "(Landroid/widget/TextView;)V", "commentTypeBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "confirmBtn", "Landroid/widget/Button;", "getConfirmBtn", "()Landroid/widget/Button;", "setConfirmBtn", "(Landroid/widget/Button;)V", "confirmBtnContainer", "getConfirmBtnContainer", "setConfirmBtnContainer", "descContainer", "getDescContainer", "setDescContainer", "descCount", "getDescCount", "setDescCount", "descTxt", "Landroid/widget/EditText;", "getDescTxt", "()Landroid/widget/EditText;", "setDescTxt", "(Landroid/widget/EditText;)V", "durationContainer", "Landroid/widget/RelativeLayout;", "getDurationContainer", "()Landroid/widget/RelativeLayout;", "setDurationContainer", "(Landroid/widget/RelativeLayout;)V", "durationTip", "getDurationTip", "setDurationTip", "durationTxt", "getDurationTxt", "setDurationTxt", "exception", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveExceptionWidget;", "inputClose", "inputContainer", "inputDialogArea", "inputEt", "inputFinishBtn", "inputPage", "Landroid/view/ViewGroup;", "inputRoot", "leftInputHint", "lotteryType", "getLotteryType", "()I", "setLotteryType", "(I)V", "lotteryTypeBottomSheet", "menuItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "statement", "getStatement", "setStatement", "winnerContainer", "getWinnerContainer", "setWinnerContainer", "winnerTxt", "getWinnerTxt", "setWinnerTxt", "adjustConfirmBtnLayout", "", "show", "", "height", "adjustInputDialogLayout", "bottomInputFinish", "getActivity", "getPresenter", "hideInput", "et", "hideInputAction", "hideInputPage", "initInputPage", "initNormalView", "initView", "keyboardChange", "openInputPage", "prepareCommentTypeMenu", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "prepareLotteryTypeMenu", "setBtnStatus", "btn", "enable", "setInputFinishBtnEnable", "setLotteryInfo", "showAlertDialog", "msg", "showAttendTypeBottomSheet", "showCommentBottomSheet", "showErrMsg", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCreateLotteryResponse;", "showInput", "showInputAction", "updateConfirmBtn", "canConfirm", "updateLotteryDesc", "desc", "updateLotteryDurationTips", "valid", "warning", "updateLotteryType", "type", "updateWinnerNumber", "cnt", "plugin-finder_release"})
public final class f
  implements d.b
{
  private final String TAG;
  final MMActivity activity;
  private final View lJI;
  private Button nZi;
  int ugE;
  final d.a ugO;
  final int ugR;
  final int ugS;
  final int ugT;
  final int ugU;
  final int ugV;
  private int ugW;
  private int ugX;
  private int ugY;
  private int ugZ;
  private View uha;
  TextView uhb;
  private RelativeLayout uhc;
  EditText uhd;
  private TextView uhe;
  private RelativeLayout uhf;
  EditText uhg;
  private View uhh;
  EditText uhi;
  private TextView uhj;
  private View uhk;
  private View uhl;
  com.tencent.mm.ui.widget.a.e uhm;
  com.tencent.mm.ui.widget.a.e uhn;
  private com.tencent.mm.plugin.finder.live.widget.f uho;
  private View uhp;
  ViewGroup uhq;
  private View uhr;
  private View uhs;
  private View uht;
  EditText uhu;
  private TextView uhv;
  private Button uhw;
  o.g uhx;
  
  public f(View paramView, MMActivity paramMMActivity, d.a parama)
  {
    AppMethodBeat.i(245971);
    this.lJI = paramView;
    this.activity = paramMMActivity;
    this.ugO = parama;
    this.TAG = "FinderLiveLotteryCreateViewCallback";
    this.ugS = 1;
    this.ugT = 2;
    this.ugU = 3;
    this.ugV = 4;
    this.ugW = 20;
    this.ugX = (this.ugW / 2);
    this.ugY = 8;
    this.ugZ = (this.ugY / 2);
    this.ugE = 1;
    this.uhx = ((o.g)new n(this));
    AppMethodBeat.o(245971);
  }
  
  private final void a(Button paramButton, boolean paramBoolean)
  {
    AppMethodBeat.i(245968);
    Context localContext;
    if (paramBoolean)
    {
      if (ao.isDarkMode())
      {
        if (paramButton != null)
        {
          localContext = this.lJI.getContext();
          p.g(localContext, "rootView.context");
          paramButton.setTextColor(localContext.getResources().getColor(2131099679));
          AppMethodBeat.o(245968);
          return;
        }
        AppMethodBeat.o(245968);
        return;
      }
      if (paramButton != null)
      {
        localContext = this.lJI.getContext();
        p.g(localContext, "rootView.context");
        paramButton.setTextColor(localContext.getResources().getColor(2131099844));
        AppMethodBeat.o(245968);
        return;
      }
      AppMethodBeat.o(245968);
      return;
    }
    if (ao.isDarkMode())
    {
      if (paramButton != null)
      {
        localContext = this.lJI.getContext();
        p.g(localContext, "rootView.context");
        paramButton.setTextColor(localContext.getResources().getColor(2131099675));
        AppMethodBeat.o(245968);
        return;
      }
      AppMethodBeat.o(245968);
      return;
    }
    if (paramButton != null)
    {
      localContext = this.lJI.getContext();
      p.g(localContext, "rootView.context");
      paramButton.setTextColor(localContext.getResources().getColor(2131099660));
      AppMethodBeat.o(245968);
      return;
    }
    AppMethodBeat.o(245968);
  }
  
  static void d(EditText paramEditText)
  {
    Object localObject2 = null;
    AppMethodBeat.i(245962);
    if (paramEditText != null)
    {
      localObject1 = paramEditText.getContext();
      if (localObject1 == null) {}
    }
    for (Object localObject1 = ((Context)localObject1).getSystemService("input_method");; localObject1 = null)
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)localObject1;
      if (localInputMethodManager == null) {
        break;
      }
      localObject1 = localObject2;
      if (paramEditText != null) {
        localObject1 = paramEditText.getWindowToken();
      }
      localInputMethodManager.hideSoftInputFromWindow((IBinder)localObject1, 0);
      AppMethodBeat.o(245962);
      return;
    }
    AppMethodBeat.o(245962);
  }
  
  public final void N(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(245966);
    Context localContext;
    if (!paramBoolean1)
    {
      localObject = this.uhd;
      int i;
      if (localObject != null)
      {
        localObject = ((EditText)localObject).getText();
        localObject = (CharSequence)localObject;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label117;
        }
        i = 1;
      }
      for (;;)
      {
        if ((i == 0) && (paramBoolean2))
        {
          localObject = this.uhe;
          if (localObject != null)
          {
            localContext = this.lJI.getContext();
            p.g(localContext, "rootView.context");
            ((TextView)localObject).setTextColor(localContext.getResources().getColor(2131100431));
            AppMethodBeat.o(245966);
            return;
            localObject = null;
            break;
            label117:
            i = 0;
            continue;
          }
          AppMethodBeat.o(245966);
          return;
        }
      }
    }
    Object localObject = this.uhe;
    if (localObject != null)
    {
      localContext = this.lJI.getContext();
      p.g(localContext, "rootView.context");
      ((TextView)localObject).setTextColor(localContext.getResources().getColor(2131099665));
      AppMethodBeat.o(245966);
      return;
    }
    AppMethodBeat.o(245966);
  }
  
  public final void a(int paramInt, String paramString, avp paramavp)
  {
    int i = 0;
    Object localObject2 = null;
    AppMethodBeat.i(245969);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("showErrMsg errorPage is empty:");
    Object localObject1;
    boolean bool;
    if (paramavp != null)
    {
      localObject1 = paramavp.LCg;
      if (localObject1 != null) {
        break label169;
      }
      bool = true;
      label48:
      localStringBuilder = localStringBuilder.append(bool).append(",type:");
      if (paramavp == null) {
        break label175;
      }
      localObject1 = paramavp.LCg;
      if (localObject1 == null) {
        break label175;
      }
      localObject1 = Integer.valueOf(((avr)localObject1).type);
      label88:
      Log.i(str, localObject1 + ",errMsg:" + paramString);
      if (paramavp == null) {
        break label181;
      }
    }
    label169:
    label175:
    label181:
    for (paramString = paramavp.LCg;; paramString = null)
    {
      if (paramString != null) {
        break label186;
      }
      u.makeText((Context)this.activity, (CharSequence)this.lJI.getResources().getString(2131759913), 0).show();
      AppMethodBeat.o(245969);
      return;
      localObject1 = null;
      break;
      bool = false;
      break label48;
      localObject1 = null;
      break label88;
    }
    label186:
    if (paramavp != null)
    {
      paramString = paramavp.LCg;
      paramavp = localObject2;
      if (paramString != null) {
        paramavp = Integer.valueOf(paramString.type);
      }
      if (paramavp != null) {
        break label230;
      }
    }
    for (;;)
    {
      if (paramavp == null)
      {
        AppMethodBeat.o(245969);
        return;
        paramString = null;
        break;
        label230:
        if (paramavp.intValue() == 1)
        {
          if (paramString != null)
          {
            paramavp = paramString.dQx;
            paramString = paramavp;
            if (paramavp != null) {}
          }
          else
          {
            paramString = "";
          }
          p.g(paramString, "errPage?.wording ?: \"\"");
          paramavp = (CharSequence)paramString;
          if (paramavp != null)
          {
            paramInt = i;
            if (paramavp.length() != 0) {}
          }
          else
          {
            paramInt = 1;
          }
          if (paramInt != 0)
          {
            paramString = this.lJI.getResources().getString(2131759913);
            p.g(paramString, "rootView.resources.getSt…live_create_lottery_fail)");
          }
          paramavp = com.tencent.mm.plugin.finder.spam.a.vwk;
          com.tencent.mm.plugin.finder.spam.a.avm(paramString);
          AppMethodBeat.o(245969);
          return;
        }
      }
    }
    if (paramavp.intValue() == 2)
    {
      if (this.uho == null)
      {
        paramavp = this.lJI.findViewById(2131301223);
        p.g(paramavp, "rootView.findViewById(R.…nder_live_post_forbidden)");
        this.uho = new com.tencent.mm.plugin.finder.live.widget.f(paramavp);
      }
      paramavp = this.uho;
      if (paramavp != null)
      {
        localObject1 = com.tencent.mm.plugin.finder.live.widget.f.uGx;
        paramavp.a(com.tencent.mm.plugin.finder.live.widget.f.djJ(), paramString, paramInt, (kotlin.g.a.b)new s(this));
        AppMethodBeat.o(245969);
        return;
      }
    }
    AppMethodBeat.o(245969);
  }
  
  public final void atw(String paramString)
  {
    AppMethodBeat.i(245970);
    p.h(paramString, "msg");
    d.h((kotlin.g.a.a)new p(paramString));
    AppMethodBeat.o(245970);
  }
  
  final void dfh()
  {
    String str = null;
    AppMethodBeat.i(245964);
    Object localObject1 = this.ugO;
    if (localObject1 != null) {
      ((d.a)localObject1).IZ(this.ugE);
    }
    localObject1 = this.uhd;
    int i;
    d.a locala;
    if (localObject1 != null)
    {
      localObject1 = ((EditText)localObject1).getText();
      if (localObject1 != null)
      {
        localObject1 = (CharSequence)localObject1;
        if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
        {
          i = 1;
          if (i != 1) {
            break label239;
          }
          locala = this.ugO;
          if (locala != null)
          {
            localObject1 = this.uhd;
            if (localObject1 == null) {
              break label234;
            }
            localObject1 = ((EditText)localObject1).getHint();
            if (localObject1 == null) {
              break label234;
            }
            localObject1 = localObject1.toString();
            label104:
            locala.Ja(Util.safeParseInt((String)localObject1));
          }
        }
      }
    }
    label214:
    label234:
    label239:
    do
    {
      locala = this.ugO;
      if (locala != null)
      {
        Object localObject2 = this.uhg;
        localObject1 = str;
        if (localObject2 != null)
        {
          localObject2 = ((EditText)localObject2).getText();
          localObject1 = str;
          if (localObject2 != null) {
            localObject1 = localObject2.toString();
          }
        }
        locala.Jb(Util.safeParseInt((String)localObject1));
      }
      locala = this.ugO;
      if (locala == null) {
        break label292;
      }
      localObject1 = this.uhi;
      if (localObject1 != null)
      {
        localObject1 = ((EditText)localObject1).getText();
        if (localObject1 != null)
        {
          str = localObject1.toString();
          localObject1 = str;
          if (str != null) {
            break label214;
          }
        }
      }
      localObject1 = "";
      locala.atv((String)localObject1);
      AppMethodBeat.o(245964);
      return;
      i = 0;
      break;
      localObject1 = null;
      break label104;
      locala = this.ugO;
    } while (locala == null);
    localObject1 = this.uhd;
    if (localObject1 != null)
    {
      localObject1 = ((EditText)localObject1).getText();
      if (localObject1 == null) {}
    }
    for (localObject1 = localObject1.toString();; localObject1 = null)
    {
      locala.Ja(Util.safeParseInt((String)localObject1));
      break;
    }
    label292:
    AppMethodBeat.o(245964);
  }
  
  final void dfi()
  {
    AppMethodBeat.i(245965);
    ViewGroup localViewGroup = this.uhq;
    if (localViewGroup != null) {
      localViewGroup.setVisibility(4);
    }
    d(this.uhu);
    AppMethodBeat.o(245965);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(245960);
    this.uha = this.lJI.findViewById(2131297076);
    this.uhb = ((TextView)this.lJI.findViewById(2131297079));
    this.uhc = ((RelativeLayout)this.lJI.findViewById(2131299806));
    this.uhd = ((EditText)this.lJI.findViewById(2131299810));
    Object localObject1 = com.tencent.mm.plugin.finder.utils.m.vVH;
    com.tencent.mm.plugin.finder.utils.m.a(this.uhd, null, this.ugY, this.ugZ, (kotlin.g.a.a)new f(this));
    this.uhe = ((TextView)this.lJI.findViewById(2131299808));
    localObject1 = this.uhe;
    if (localObject1 != null)
    {
      Object localObject2 = ae.SYK;
      localObject2 = this.activity.getResources().getString(2131760033);
      p.g(localObject2, "activity.resources.getSt…ve_lottery_duration_tips)");
      e.a locala = e.ugM;
      localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { Integer.valueOf(e.dfg()) }, 1));
      p.g(localObject2, "java.lang.String.format(format, *args)");
      ((TextView)localObject1).setText((CharSequence)localObject2);
    }
    this.uhf = ((RelativeLayout)this.lJI.findViewById(2131310516));
    this.uhg = ((EditText)this.lJI.findViewById(2131310520));
    localObject1 = com.tencent.mm.plugin.finder.utils.m.vVH;
    com.tencent.mm.plugin.finder.utils.m.a(this.uhg, null, this.ugY, this.ugZ, (kotlin.g.a.a)new g(this));
    this.uhh = this.lJI.findViewById(2131299495);
    this.uhi = ((EditText)this.lJI.findViewById(2131299512));
    this.uhj = ((TextView)this.lJI.findViewById(2131299504));
    this.uhk = this.lJI.findViewById(2131298991);
    this.uhl = this.lJI.findViewById(2131308384);
    this.nZi = ((Button)this.lJI.findViewById(2131298990));
    localObject1 = this.nZi;
    if (localObject1 != null) {}
    for (localObject1 = ((Button)localObject1).getPaint();; localObject1 = null)
    {
      ao.a((Paint)localObject1, 0.8F);
      nk(false);
      localObject1 = this.uha;
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener((View.OnClickListener)new h(this));
      }
      localObject1 = this.uhc;
      if (localObject1 != null) {
        ((RelativeLayout)localObject1).setOnClickListener((View.OnClickListener)new i(this));
      }
      localObject1 = this.uhf;
      if (localObject1 != null) {
        ((RelativeLayout)localObject1).setOnClickListener((View.OnClickListener)new j(this));
      }
      localObject1 = this.uhh;
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener((View.OnClickListener)new k(this));
      }
      localObject1 = this.nZi;
      if (localObject1 != null) {
        ((Button)localObject1).setOnClickListener((View.OnClickListener)new l(this));
      }
      localObject1 = com.tencent.mm.plugin.finder.utils.m.vVH;
      com.tencent.mm.plugin.finder.utils.m.a(this.uhi, this.uhj, this.ugW, this.ugX, (kotlin.g.a.a)f.m.uhz);
      localObject1 = this.activity.getWindow();
      p.g(localObject1, "activity.window");
      localObject1 = ((Window)localObject1).getDecorView();
      if (localObject1 != null) {
        break;
      }
      localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(245960);
      throw ((Throwable)localObject1);
    }
    localObject1 = (ViewGroup)localObject1;
    this.uhp = LayoutInflater.from((Context)this.activity).inflate(2131494380, (ViewGroup)localObject1, true);
    localObject1 = this.uhp;
    if (localObject1 != null)
    {
      localObject1 = (ViewGroup)((View)localObject1).findViewById(2131302682);
      this.uhq = ((ViewGroup)localObject1);
      localObject1 = this.uhq;
      if (localObject1 != null) {
        ((ViewGroup)localObject1).setOnClickListener((View.OnClickListener)new a(this));
      }
      localObject1 = this.uhq;
      if (localObject1 == null) {
        break label961;
      }
      localObject1 = ((ViewGroup)localObject1).findViewById(2131299639);
      label671:
      this.uhr = ((View)localObject1);
      localObject1 = this.uhq;
      if (localObject1 == null) {
        break label966;
      }
      localObject1 = ((ViewGroup)localObject1).findViewById(2131298763);
      label693:
      this.uhs = ((View)localObject1);
      localObject1 = this.uhs;
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener((View.OnClickListener)new b(this));
      }
      localObject1 = this.uhq;
      if (localObject1 == null) {
        break label971;
      }
      localObject1 = ((ViewGroup)localObject1).findViewById(2131302671);
      label739:
      this.uht = ((View)localObject1);
      localObject1 = this.uht;
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener((View.OnClickListener)new c(this));
      }
      localObject1 = this.uht;
      if (localObject1 == null) {
        break label976;
      }
      localObject1 = (EditText)((View)localObject1).findViewById(2131302674);
      label788:
      this.uhu = ((EditText)localObject1);
      localObject1 = this.uht;
      if (localObject1 == null) {
        break label981;
      }
      localObject1 = (TextView)((View)localObject1).findViewById(2131303138);
      label813:
      this.uhv = ((TextView)localObject1);
      localObject1 = this.uhq;
      if (localObject1 == null) {
        break label986;
      }
      localObject1 = (Button)((ViewGroup)localObject1).findViewById(2131301538);
      label838:
      this.uhw = ((Button)localObject1);
      localObject1 = this.uhw;
      if (localObject1 == null) {
        break label991;
      }
    }
    label961:
    label966:
    label971:
    label976:
    label981:
    label986:
    label991:
    for (localObject1 = ((Button)localObject1).getPaint();; localObject1 = null)
    {
      ao.a((Paint)localObject1, 0.8F);
      localObject1 = this.uhw;
      if (localObject1 != null) {
        ((Button)localObject1).setOnClickListener((View.OnClickListener)new d(this));
      }
      nl(false);
      localObject1 = com.tencent.mm.plugin.finder.utils.m.vVH;
      com.tencent.mm.plugin.finder.utils.m.a(this.uhu, this.uhv, this.ugW, this.ugX, (kotlin.g.a.a)new e(this));
      localObject1 = this.uhq;
      if (localObject1 != null) {
        ((ViewGroup)localObject1).setVisibility(8);
      }
      dfh();
      AppMethodBeat.o(245960);
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label671;
      localObject1 = null;
      break label693;
      localObject1 = null;
      break label739;
      localObject1 = null;
      break label788;
      localObject1 = null;
      break label813;
      localObject1 = null;
      break label838;
    }
  }
  
  public final void keyboardChange(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(245963);
    if (!paramBoolean) {
      dfh();
    }
    Object localObject1 = this.uhr;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((View)localObject1).getLayoutParams();
      localObject1 = localObject2;
      if (!(localObject2 instanceof ViewGroup.MarginLayoutParams)) {
        localObject1 = null;
      }
      localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
      if (localObject1 != null) {
        ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = paramInt;
      }
      localObject2 = this.uhq;
      if (localObject2 != null) {
        ((ViewGroup)localObject2).updateViewLayout(this.uhr, (ViewGroup.LayoutParams)localObject1);
      }
    }
    localObject1 = this.uhk;
    RelativeLayout.LayoutParams localLayoutParams;
    int i;
    label193:
    int j;
    if (localObject1 != null)
    {
      localObject1 = ((View)localObject1).getLayoutParams();
      localObject2 = localObject1;
      if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
        localObject2 = null;
      }
      localLayoutParams = (RelativeLayout.LayoutParams)localObject2;
      localObject1 = MMApplicationContext.getContext();
      p.g(localObject1, "MMApplicationContext.getContext()");
      int k = ((Context)localObject1).getResources().getDimensionPixelOffset(2131165312);
      if (localLayoutParams == null) {
        break label539;
      }
      if (!paramBoolean) {
        break label487;
      }
      int m = au.az(MMApplicationContext.getContext()).y;
      localObject1 = this.uhk;
      if (localObject1 == null) {
        break label448;
      }
      i = ((View)localObject1).getHeight();
      localObject1 = new int[2];
      localObject2 = this.uhh;
      if (localObject2 != null) {
        ((View)localObject2).getLocationOnScreen((int[])localObject1);
      }
      int n = localObject1[1];
      localObject1 = this.uhh;
      if (localObject1 == null) {
        break label453;
      }
      j = ((View)localObject1).getHeight();
      label240:
      Log.i(this.TAG, "adjustConfirmBtnLayout screenHeight:" + m + ",confirmBtnContainerH:" + i + ",descContainerY:" + n + ",itemHeight:" + j + ",height:" + paramInt);
      if ((i != 0) && (n != 0) && (m - k - i - (j + n) > paramInt)) {
        break label459;
      }
      localObject1 = this.uhh;
      if (localObject1 != null)
      {
        paramInt = ((View)localObject1).getId();
        localLayoutParams.removeRule(2);
        localLayoutParams.removeRule(12);
        localLayoutParams.addRule(3, paramInt);
        localLayoutParams.bottomMargin = 0;
      }
      label376:
      localObject1 = this.uhk;
      if (localObject1 == null) {
        break label533;
      }
    }
    label533:
    for (localObject1 = ((View)localObject1).getParent();; localObject1 = null)
    {
      localObject2 = localObject1;
      if (!(localObject1 instanceof ViewGroup)) {
        localObject2 = null;
      }
      localObject1 = (ViewGroup)localObject2;
      if (localObject1 == null) {
        break label539;
      }
      ((ViewGroup)localObject1).updateViewLayout(this.uhk, (ViewGroup.LayoutParams)localLayoutParams);
      AppMethodBeat.o(245963);
      return;
      localObject1 = null;
      break;
      label448:
      i = 0;
      break label193;
      label453:
      j = 0;
      break label240;
      label459:
      localLayoutParams.removeRule(2);
      localLayoutParams.removeRule(3);
      localLayoutParams.addRule(12);
      localLayoutParams.bottomMargin = paramInt;
      break label376;
      label487:
      localObject1 = this.uhl;
      if (localObject1 == null) {
        break label376;
      }
      paramInt = ((View)localObject1).getId();
      localLayoutParams.removeRule(3);
      localLayoutParams.removeRule(12);
      localLayoutParams.bottomMargin = 0;
      localLayoutParams.addRule(2, paramInt);
      break label376;
    }
    label539:
    AppMethodBeat.o(245963);
  }
  
  public final void nk(boolean paramBoolean)
  {
    AppMethodBeat.i(245967);
    Log.i(this.TAG, "updateConfirmBtn canConfirm:".concat(String.valueOf(paramBoolean)));
    Button localButton = this.nZi;
    if (localButton != null) {
      localButton.setEnabled(paramBoolean);
    }
    a(this.nZi, paramBoolean);
    AppMethodBeat.o(245967);
  }
  
  final void nl(boolean paramBoolean)
  {
    AppMethodBeat.i(245961);
    Button localButton = this.uhw;
    if (localButton != null) {
      localButton.setEnabled(paramBoolean);
    }
    a(this.uhw, paramBoolean);
    AppMethodBeat.o(245961);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(f paramf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(245941);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initInputPage$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.uhy.dfi();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initInputPage$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(245941);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(f paramf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(245942);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initInputPage$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.uhy.dfi();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initInputPage$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(245942);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(f paramf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(245943);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initInputPage$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.uhy.uhu;
      if (paramView != null) {
        paramView.requestFocus();
      }
      f.e(this.uhy.uhu);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initInputPage$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(245943);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(f paramf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(245944);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initInputPage$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      f localf = this.uhy;
      paramView = localf.uhu;
      if (paramView != null)
      {
        paramView = paramView.getText();
        if (paramView != null)
        {
          localObject = paramView.toString();
          paramView = (View)localObject;
          if (localObject != null) {
            break label73;
          }
        }
      }
      paramView = "";
      label73:
      localObject = y.vXH;
      paramView = y.awt(paramView);
      localObject = (CharSequence)paramView;
      int i;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0))
      {
        i = 1;
        if (i == 0) {
          break label134;
        }
        localf.dfi();
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initInputPage$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(245944);
        return;
        i = 0;
        break;
        label134:
        localf.ugE = 1;
        localObject = localf.uhb;
        if (localObject != null) {
          ((TextView)localObject).setText((CharSequence)(localf.activity.getResources().getString(2131760024) + '"' + paramView + '"'));
        }
        localObject = localf.ugO;
        if (localObject != null) {
          ((d.a)localObject).IZ(localf.ugE);
        }
        localObject = localf.ugO;
        if (localObject != null) {
          ((d.a)localObject).atu(paramView);
        }
        localObject = localf.uhq;
        if (localObject != null) {
          ((ViewGroup)localObject).setVisibility(4);
        }
        f.d(localf.uhu);
        localObject = k.vkd;
        k.a(s.f.vnu, paramView);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(f paramf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(245948);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initNormalView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = this.uhy;
      paramView.uhm = new com.tencent.mm.ui.widget.a.e((Context)paramView.activity, 1, false);
      localObject = paramView.uhm;
      if (localObject != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject).a((o.f)new f.q(paramView));
      }
      localObject = paramView.uhm;
      if (localObject != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject).a(paramView.uhx);
      }
      paramView = paramView.uhm;
      if (paramView != null) {
        paramView.dGm();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initNormalView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(245948);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(f paramf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(245949);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initNormalView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.uhy.uhd;
      if (paramView != null) {
        paramView.requestFocus();
      }
      f.e(this.uhy.uhd);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initNormalView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(245949);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(f paramf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(245950);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initNormalView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.uhy.uhg;
      if (paramView != null) {
        paramView.requestFocus();
      }
      f.e(this.uhy.uhg);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initNormalView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(245950);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(f paramf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(245951);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initNormalView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.uhy.uhi;
      if (paramView != null) {
        paramView.requestFocus();
      }
      f.e(this.uhy.uhi);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initNormalView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(245951);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    l(f paramf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(245952);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initNormalView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = y.vXH;
      if (y.isFastClick())
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initNormalView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(245952);
        return;
      }
      this.uhy.dfh();
      paramView = this.uhy.ugO;
      if (paramView != null) {
        paramView.dff();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initNormalView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(245952);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
  static final class n
    implements o.g
  {
    n(f paramf) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(245954);
      if (paramMenuItem != null)
      {
        localObject = Integer.valueOf(paramMenuItem.getItemId());
        paramInt = this.uhy.ugR;
        if (localObject != null) {
          break label90;
        }
        label31:
        paramInt = this.uhy.ugU;
        if (localObject != null) {
          break label205;
        }
        label43:
        paramInt = this.uhy.ugV;
        if (localObject != null) {
          break label322;
        }
        label55:
        paramInt = this.uhy.ugS;
        if (localObject != null) {
          break label433;
        }
      }
      label90:
      while (((Integer)localObject).intValue() != paramInt)
      {
        paramInt = this.uhy.ugT;
        if (localObject != null) {
          break label550;
        }
        AppMethodBeat.o(245954);
        return;
        localObject = null;
        break;
        if (((Integer)localObject).intValue() != paramInt) {
          break label31;
        }
        paramMenuItem = this.uhy.uhm;
        if (paramMenuItem != null) {
          paramMenuItem.bMo();
        }
        paramMenuItem = this.uhy;
        paramMenuItem.uhn = new com.tencent.mm.ui.widget.a.e((Context)paramMenuItem.activity, 1, false);
        localObject = paramMenuItem.uhn;
        if (localObject != null) {
          ((com.tencent.mm.ui.widget.a.e)localObject).a((o.f)new f.r(paramMenuItem));
        }
        localObject = paramMenuItem.uhn;
        if (localObject != null) {
          ((com.tencent.mm.ui.widget.a.e)localObject).a(paramMenuItem.uhx);
        }
        paramMenuItem = paramMenuItem.uhn;
        if (paramMenuItem != null)
        {
          paramMenuItem.dGm();
          AppMethodBeat.o(245954);
          return;
        }
        AppMethodBeat.o(245954);
        return;
        if (((Integer)localObject).intValue() != paramInt) {
          break label43;
        }
        localObject = this.uhy.uhb;
        if (localObject != null) {
          ((TextView)localObject).setText(paramMenuItem.getTitle());
        }
        this.uhy.ugE = 2;
        paramMenuItem = this.uhy.ugO;
        if (paramMenuItem != null) {
          paramMenuItem.IZ(this.uhy.ugE);
        }
        paramMenuItem = this.uhy.ugO;
        if (paramMenuItem != null) {
          paramMenuItem.atu("");
        }
        paramMenuItem = this.uhy.uhm;
        if (paramMenuItem != null) {
          paramMenuItem.bMo();
        }
        paramMenuItem = k.vkd;
        k.a(s.f.vnt, "");
        AppMethodBeat.o(245954);
        return;
        if (((Integer)localObject).intValue() != paramInt) {
          break label55;
        }
        localObject = this.uhy.uhb;
        if (localObject != null) {
          ((TextView)localObject).setText(paramMenuItem.getTitle());
        }
        this.uhy.ugE = 3;
        paramMenuItem = this.uhy.ugO;
        if (paramMenuItem != null) {
          paramMenuItem.IZ(this.uhy.ugE);
        }
        paramMenuItem = this.uhy.ugO;
        if (paramMenuItem != null) {
          paramMenuItem.atu("");
        }
        paramMenuItem = this.uhy.uhm;
        if (paramMenuItem != null)
        {
          paramMenuItem.bMo();
          AppMethodBeat.o(245954);
          return;
        }
        AppMethodBeat.o(245954);
        return;
      }
      label205:
      Object localObject = this.uhy.uhb;
      label322:
      if (localObject != null) {
        ((TextView)localObject).setText(paramMenuItem.getTitle());
      }
      label433:
      this.uhy.ugE = 1;
      paramMenuItem = this.uhy.ugO;
      if (paramMenuItem != null) {
        paramMenuItem.IZ(this.uhy.ugE);
      }
      paramMenuItem = this.uhy.ugO;
      if (paramMenuItem != null) {
        paramMenuItem.atu("");
      }
      paramMenuItem = this.uhy.uhn;
      if (paramMenuItem != null) {
        paramMenuItem.bMo();
      }
      paramMenuItem = k.vkd;
      k.a(s.f.vnr, "");
      AppMethodBeat.o(245954);
      return;
      label550:
      if (((Integer)localObject).intValue() == paramInt)
      {
        paramMenuItem = k.vkd;
        k.a(s.f.vns, "");
        paramMenuItem = this.uhy;
        localObject = paramMenuItem.uhq;
        if (localObject != null) {
          ((ViewGroup)localObject).setVisibility(0);
        }
        localObject = paramMenuItem.uhu;
        if (localObject != null) {
          ((EditText)localObject).post((Runnable)new f.o(paramMenuItem));
        }
        paramMenuItem = this.uhy.uhn;
        if (paramMenuItem != null)
        {
          paramMenuItem.bMo();
          AppMethodBeat.o(245954);
          return;
        }
      }
      AppMethodBeat.o(245954);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class o
    implements Runnable
  {
    o(f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(245955);
      EditText localEditText = this.uhy.uhu;
      if (localEditText != null) {
        localEditText.requestFocus();
      }
      f.e(this.uhy.uhu);
      AppMethodBeat.o(245955);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class p
    extends q
    implements kotlin.g.a.a<x>
  {
    p(String paramString)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class q
    implements o.f
  {
    q(f paramf) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramm)
    {
      AppMethodBeat.i(245957);
      Object localObject = k.vkd;
      k.a(s.f.vnq, "");
      localObject = this.uhy;
      p.g(paramm, "menu");
      paramm.d(((f)localObject).ugS, (CharSequence)((f)localObject).activity.getResources().getString(2131760014));
      paramm.d(((f)localObject).ugT, (CharSequence)((f)localObject).activity.getResources().getString(2131760061));
      paramm.d(((f)localObject).ugU, (CharSequence)((f)localObject).activity.getResources().getString(2131760050));
      AppMethodBeat.o(245957);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class r
    implements o.f
  {
    r(f paramf) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramm)
    {
      AppMethodBeat.i(245958);
      f localf = this.uhy;
      p.g(paramm, "menu");
      paramm.d(localf.ugS, (CharSequence)localf.activity.getResources().getString(2131760014));
      paramm.d(localf.ugT, (CharSequence)localf.activity.getResources().getString(2131760061));
      AppMethodBeat.o(245958);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "ok", "", "invoke"})
  static final class s
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    s(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.f
 * JD-Core Version:    0.7.0.1
 */