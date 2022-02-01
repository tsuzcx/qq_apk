package com.tencent.mm.plugin.finder.live.component;

import android.app.Activity;
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
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.azc;
import com.tencent.mm.protocal.protobuf.aze;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.e;
import java.util.Arrays;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$ViewCallback;", "rootView", "Landroid/view/View;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$Presenter;", "(Landroid/view/View;Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$Presenter;)V", "LOTTERY_ANY_COMMENT", "", "LOTTERY_COMMENT", "LOTTERY_LIKE", "LOTTERY_SHOPPING", "LOTTERY_SPECIAL_COMMENT", "MAX_INPUT_CHINESE_LENGTH", "MAX_INPUT_CHINESE_SIZE", "MAX_INPUT_NUMBER_LENGTH", "MAX_INPUT_NUMBER_SIZE", "TAG", "", "getTAG", "()Ljava/lang/String;", "attendType", "getAttendType", "()Landroid/view/View;", "setAttendType", "(Landroid/view/View;)V", "attendTypeTxt", "Landroid/widget/TextView;", "getAttendTypeTxt", "()Landroid/widget/TextView;", "setAttendTypeTxt", "(Landroid/widget/TextView;)V", "commentTypeBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "confirmBtn", "Landroid/widget/Button;", "getConfirmBtn", "()Landroid/widget/Button;", "setConfirmBtn", "(Landroid/widget/Button;)V", "confirmBtnContainer", "getConfirmBtnContainer", "setConfirmBtnContainer", "descContainer", "getDescContainer", "setDescContainer", "descCount", "getDescCount", "setDescCount", "descTxt", "Landroid/widget/EditText;", "getDescTxt", "()Landroid/widget/EditText;", "setDescTxt", "(Landroid/widget/EditText;)V", "durationContainer", "Landroid/widget/RelativeLayout;", "getDurationContainer", "()Landroid/widget/RelativeLayout;", "setDurationContainer", "(Landroid/widget/RelativeLayout;)V", "durationTip", "getDurationTip", "setDurationTip", "durationTxt", "getDurationTxt", "setDurationTxt", "exception", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveExceptionWidget;", "inputClose", "inputContainer", "inputDialogArea", "inputEt", "inputFinishBtn", "inputPage", "Landroid/view/ViewGroup;", "inputRoot", "leftInputHint", "lotteryType", "getLotteryType", "()I", "setLotteryType", "(I)V", "lotteryTypeBottomSheet", "menuItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "statement", "getStatement", "setStatement", "winnerContainer", "getWinnerContainer", "setWinnerContainer", "winnerTxt", "getWinnerTxt", "setWinnerTxt", "adjustConfirmBtnLayout", "", "show", "", "height", "adjustInputDialogLayout", "bottomInputFinish", "destroy", "getActivity", "getPresenter", "hideInput", "et", "hideInputAction", "hideInputPage", "initInputPage", "initNormalView", "initView", "keyboardChange", "openInputPage", "prepareCommentTypeMenu", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "prepareLotteryTypeMenu", "setBtnStatus", "btn", "enable", "setInputFinishBtnEnable", "setLotteryInfo", "showAlertDialog", "msg", "showAttendTypeBottomSheet", "showCommentBottomSheet", "showErrMsg", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCreateLotteryResponse;", "showInput", "showInputAction", "updateConfirmBtn", "canConfirm", "updateLotteryDesc", "desc", "updateLotteryDurationTips", "valid", "warning", "updateLotteryType", "type", "updateWinnerNumber", "cnt", "plugin-finder_release"})
public final class s
  implements p.b
{
  private final String TAG;
  final MMActivity activity;
  private final View oFW;
  private Button raT;
  int yaG;
  final p.a yaS;
  final int yaV;
  final int yaW;
  final int yaX;
  final int yaY;
  final int yaZ;
  private Button ybA;
  q.g ybB;
  private int yba;
  private int ybb;
  private int ybc;
  private int ybd;
  private View ybe;
  TextView ybf;
  private RelativeLayout ybg;
  EditText ybh;
  private TextView ybi;
  private RelativeLayout ybj;
  EditText ybk;
  private View ybl;
  EditText ybm;
  private TextView ybn;
  private View ybo;
  private View ybp;
  e ybq;
  e ybr;
  private com.tencent.mm.plugin.finder.live.widget.o ybs;
  private View ybt;
  ViewGroup ybu;
  private View ybv;
  private View ybw;
  private View ybx;
  EditText yby;
  private TextView ybz;
  
  public s(View paramView, MMActivity paramMMActivity, p.a parama)
  {
    AppMethodBeat.i(273466);
    this.oFW = paramView;
    this.activity = paramMMActivity;
    this.yaS = parama;
    this.TAG = "FinderLiveLotteryCreateViewCallback";
    this.yaW = 1;
    this.yaX = 2;
    this.yaY = 3;
    this.yaZ = 4;
    this.yba = 20;
    this.ybb = (this.yba / 2);
    this.ybc = 8;
    this.ybd = (this.ybc / 2);
    this.yaG = 1;
    this.ybB = ((q.g)new n(this));
    AppMethodBeat.o(273466);
  }
  
  private final void a(Button paramButton, boolean paramBoolean)
  {
    AppMethodBeat.i(273463);
    Context localContext;
    if (paramBoolean)
    {
      if (ar.isDarkMode())
      {
        if (paramButton != null)
        {
          localContext = this.oFW.getContext();
          p.j(localContext, "rootView.context");
          paramButton.setTextColor(localContext.getResources().getColor(b.c.BW_100_Alpha_0_8));
          AppMethodBeat.o(273463);
          return;
        }
        AppMethodBeat.o(273463);
        return;
      }
      if (paramButton != null)
      {
        localContext = this.oFW.getContext();
        p.j(localContext, "rootView.context");
        paramButton.setTextColor(localContext.getResources().getColor(b.c.White));
        AppMethodBeat.o(273463);
        return;
      }
      AppMethodBeat.o(273463);
      return;
    }
    if (ar.isDarkMode())
    {
      if (paramButton != null)
      {
        localContext = this.oFW.getContext();
        p.j(localContext, "rootView.context");
        paramButton.setTextColor(localContext.getResources().getColor(b.c.BW_100_Alpha_0_2));
        AppMethodBeat.o(273463);
        return;
      }
      AppMethodBeat.o(273463);
      return;
    }
    if (paramButton != null)
    {
      localContext = this.oFW.getContext();
      p.j(localContext, "rootView.context");
      paramButton.setTextColor(localContext.getResources().getColor(b.c.BW_0_Alpha_0_2));
      AppMethodBeat.o(273463);
      return;
    }
    AppMethodBeat.o(273463);
  }
  
  static void d(EditText paramEditText)
  {
    Object localObject2 = null;
    AppMethodBeat.i(273456);
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
      AppMethodBeat.o(273456);
      return;
    }
    AppMethodBeat.o(273456);
  }
  
  public final void S(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(273460);
    Context localContext;
    if (!paramBoolean1)
    {
      localObject = this.ybh;
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
          localObject = this.ybi;
          if (localObject != null)
          {
            localContext = this.oFW.getContext();
            p.j(localContext, "rootView.context");
            ((TextView)localObject).setTextColor(localContext.getResources().getColor(b.c.finder_live_logo_color));
            AppMethodBeat.o(273460);
            return;
            localObject = null;
            break;
            label117:
            i = 0;
            continue;
          }
          AppMethodBeat.o(273460);
          return;
        }
      }
    }
    Object localObject = this.ybi;
    if (localObject != null)
    {
      localContext = this.oFW.getContext();
      p.j(localContext, "rootView.context");
      ((TextView)localObject).setTextColor(localContext.getResources().getColor(b.c.BW_0_Alpha_0_5));
      AppMethodBeat.o(273460);
      return;
    }
    AppMethodBeat.o(273460);
  }
  
  public final void a(int paramInt, String paramString, azc paramazc)
  {
    int i = 0;
    Object localObject2 = null;
    AppMethodBeat.i(273464);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("showErrMsg errorPage is empty:");
    Object localObject1;
    boolean bool;
    if (paramazc != null)
    {
      localObject1 = paramazc.SFh;
      if (localObject1 != null) {
        break label169;
      }
      bool = true;
      label48:
      localStringBuilder = localStringBuilder.append(bool).append(",type:");
      if (paramazc == null) {
        break label175;
      }
      localObject1 = paramazc.SFh;
      if (localObject1 == null) {
        break label175;
      }
      localObject1 = Integer.valueOf(((aze)localObject1).type);
      label88:
      Log.i(str, localObject1 + ",errMsg:" + paramString);
      if (paramazc == null) {
        break label181;
      }
    }
    label169:
    label175:
    label181:
    for (paramString = paramazc.SFh;; paramString = null)
    {
      if (paramString != null) {
        break label186;
      }
      w.makeText((Context)this.activity, (CharSequence)this.oFW.getResources().getString(b.j.finder_live_create_lottery_fail), 0).show();
      AppMethodBeat.o(273464);
      return;
      localObject1 = null;
      break;
      bool = false;
      break label48;
      localObject1 = null;
      break label88;
    }
    label186:
    if (paramazc != null)
    {
      paramString = paramazc.SFh;
      paramazc = localObject2;
      if (paramString != null) {
        paramazc = Integer.valueOf(paramString.type);
      }
      if (paramazc != null) {
        break label230;
      }
    }
    for (;;)
    {
      if (paramazc == null)
      {
        AppMethodBeat.o(273464);
        return;
        paramString = null;
        break;
        label230:
        if (paramazc.intValue() == 1)
        {
          if (paramString != null)
          {
            paramazc = paramString.wording;
            paramString = paramazc;
            if (paramazc != null) {}
          }
          else
          {
            paramString = "";
          }
          p.j(paramString, "errPage?.wording ?: \"\"");
          paramazc = (CharSequence)paramString;
          if (paramazc != null)
          {
            paramInt = i;
            if (paramazc.length() != 0) {}
          }
          else
          {
            paramInt = 1;
          }
          if (paramInt != 0)
          {
            paramString = this.oFW.getResources().getString(b.j.finder_live_create_lottery_fail);
            p.j(paramString, "rootView.resources.getSt…live_create_lottery_fail)");
          }
          paramazc = com.tencent.mm.plugin.findersdk.c.a.Bwg;
          com.tencent.mm.plugin.findersdk.c.a.aGP(paramString);
          AppMethodBeat.o(273464);
          return;
        }
      }
    }
    if (paramazc.intValue() == 2)
    {
      if (this.ybs == null)
      {
        paramazc = this.oFW.findViewById(b.f.finder_live_post_forbidden);
        p.j(paramazc, "rootView.findViewById(R.…nder_live_post_forbidden)");
        this.ybs = new com.tencent.mm.plugin.finder.live.widget.o(paramazc);
      }
      paramazc = this.ybs;
      if (paramazc != null)
      {
        localObject1 = com.tencent.mm.plugin.finder.live.widget.o.znK;
        paramazc.a(com.tencent.mm.plugin.finder.live.widget.o.dIi(), paramString, paramInt, (kotlin.g.a.b)new s(this));
        AppMethodBeat.o(273464);
        return;
      }
    }
    AppMethodBeat.o(273464);
  }
  
  public final void aBU(String paramString)
  {
    AppMethodBeat.i(273465);
    p.k(paramString, "msg");
    d.uiThread((kotlin.g.a.a)new p(paramString));
    AppMethodBeat.o(273465);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(273462);
    dxB();
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    com.tencent.mm.plugin.finder.live.utils.a.aq((Activity)this.activity);
    AppMethodBeat.o(273462);
  }
  
  final void dxA()
  {
    String str = null;
    AppMethodBeat.i(273458);
    Object localObject1 = this.yaS;
    if (localObject1 != null) {
      ((p.a)localObject1).Ne(this.yaG);
    }
    localObject1 = this.ybh;
    int i;
    p.a locala;
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
          locala = this.yaS;
          if (locala != null)
          {
            localObject1 = this.ybh;
            if (localObject1 == null) {
              break label234;
            }
            localObject1 = ((EditText)localObject1).getHint();
            if (localObject1 == null) {
              break label234;
            }
            localObject1 = localObject1.toString();
            label104:
            locala.Nf(Util.safeParseInt((String)localObject1));
          }
        }
      }
    }
    label214:
    label234:
    label239:
    do
    {
      locala = this.yaS;
      if (locala != null)
      {
        Object localObject2 = this.ybk;
        localObject1 = str;
        if (localObject2 != null)
        {
          localObject2 = ((EditText)localObject2).getText();
          localObject1 = str;
          if (localObject2 != null) {
            localObject1 = localObject2.toString();
          }
        }
        locala.Ng(Util.safeParseInt((String)localObject1));
      }
      locala = this.yaS;
      if (locala == null) {
        break label292;
      }
      localObject1 = this.ybm;
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
      locala.aBT((String)localObject1);
      AppMethodBeat.o(273458);
      return;
      i = 0;
      break;
      localObject1 = null;
      break label104;
      locala = this.yaS;
    } while (locala == null);
    localObject1 = this.ybh;
    if (localObject1 != null)
    {
      localObject1 = ((EditText)localObject1).getText();
      if (localObject1 == null) {}
    }
    for (localObject1 = localObject1.toString();; localObject1 = null)
    {
      locala.Nf(Util.safeParseInt((String)localObject1));
      break;
    }
    label292:
    AppMethodBeat.o(273458);
  }
  
  final void dxB()
  {
    AppMethodBeat.i(273459);
    ViewGroup localViewGroup = this.ybu;
    if (localViewGroup != null) {
      localViewGroup.setVisibility(4);
    }
    d(this.yby);
    AppMethodBeat.o(273459);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(273454);
    this.ybe = this.oFW.findViewById(b.f.attend_type);
    this.ybf = ((TextView)this.oFW.findViewById(b.f.attend_type_txt));
    this.ybg = ((RelativeLayout)this.oFW.findViewById(b.f.duration));
    this.ybh = ((EditText)this.oFW.findViewById(b.f.duration_value));
    Object localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    com.tencent.mm.plugin.finder.live.utils.a.a(this.ybh, null, this.ybc, this.ybd, (kotlin.g.a.a)new f(this));
    this.ybi = ((TextView)this.oFW.findViewById(b.f.duration_tips));
    localObject1 = this.ybi;
    if (localObject1 != null)
    {
      Object localObject2 = af.aaBG;
      localObject2 = this.activity.getResources().getString(b.j.finder_live_lottery_duration_tips);
      p.j(localObject2, "activity.resources.getSt…ve_lottery_duration_tips)");
      q.a locala = q.yaO;
      localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { Integer.valueOf(q.dxz()) }, 1));
      p.j(localObject2, "java.lang.String.format(format, *args)");
      ((TextView)localObject1).setText((CharSequence)localObject2);
    }
    this.ybj = ((RelativeLayout)this.oFW.findViewById(b.f.winner_number));
    this.ybk = ((EditText)this.oFW.findViewById(b.f.winner_value));
    localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    com.tencent.mm.plugin.finder.live.utils.a.a(this.ybk, null, this.ybc, this.ybd, (kotlin.g.a.a)new g(this));
    this.ybl = this.oFW.findViewById(b.f.desc);
    this.ybm = ((EditText)this.oFW.findViewById(b.f.desc_txt));
    this.ybn = ((TextView)this.oFW.findViewById(b.f.desc_count));
    this.ybo = this.oFW.findViewById(b.f.confirm_btn_layout);
    this.ybp = this.oFW.findViewById(b.f.statement);
    this.raT = ((Button)this.oFW.findViewById(b.f.confirm_btn));
    localObject1 = this.raT;
    if (localObject1 != null) {}
    for (localObject1 = ((Button)localObject1).getPaint();; localObject1 = null)
    {
      ar.a((Paint)localObject1, 0.8F);
      oG(false);
      localObject1 = this.ybe;
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener((View.OnClickListener)new h(this));
      }
      localObject1 = this.ybg;
      if (localObject1 != null) {
        ((RelativeLayout)localObject1).setOnClickListener((View.OnClickListener)new i(this));
      }
      localObject1 = this.ybj;
      if (localObject1 != null) {
        ((RelativeLayout)localObject1).setOnClickListener((View.OnClickListener)new j(this));
      }
      localObject1 = this.ybl;
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener((View.OnClickListener)new k(this));
      }
      localObject1 = this.raT;
      if (localObject1 != null) {
        ((Button)localObject1).setOnClickListener((View.OnClickListener)new l(this));
      }
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.live.utils.a.a(this.ybm, this.ybn, this.yba, this.ybb, (kotlin.g.a.a)s.m.ybD);
      localObject1 = this.activity.getWindow();
      p.j(localObject1, "activity.window");
      localObject1 = ((Window)localObject1).getDecorView();
      if (localObject1 != null) {
        break;
      }
      localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(273454);
      throw ((Throwable)localObject1);
    }
    localObject1 = (ViewGroup)localObject1;
    this.ybt = LayoutInflater.from((Context)this.activity).inflate(b.g.finder_live_bottom_input_dialog, (ViewGroup)localObject1, true);
    localObject1 = this.ybt;
    if (localObject1 != null)
    {
      localObject1 = (ViewGroup)((View)localObject1).findViewById(b.f.input_page);
      this.ybu = ((ViewGroup)localObject1);
      localObject1 = this.ybu;
      if (localObject1 != null) {
        ((ViewGroup)localObject1).setOnClickListener((View.OnClickListener)new a(this));
      }
      localObject1 = this.ybu;
      if (localObject1 == null) {
        break label961;
      }
      localObject1 = ((ViewGroup)localObject1).findViewById(b.f.dialog);
      label671:
      this.ybv = ((View)localObject1);
      localObject1 = this.ybu;
      if (localObject1 == null) {
        break label966;
      }
      localObject1 = ((ViewGroup)localObject1).findViewById(b.f.close);
      label693:
      this.ybw = ((View)localObject1);
      localObject1 = this.ybw;
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener((View.OnClickListener)new b(this));
      }
      localObject1 = this.ybu;
      if (localObject1 == null) {
        break label971;
      }
      localObject1 = ((ViewGroup)localObject1).findViewById(b.f.input_container);
      label739:
      this.ybx = ((View)localObject1);
      localObject1 = this.ybx;
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener((View.OnClickListener)new c(this));
      }
      localObject1 = this.ybx;
      if (localObject1 == null) {
        break label976;
      }
      localObject1 = (EditText)((View)localObject1).findViewById(b.f.input_et);
      label788:
      this.yby = ((EditText)localObject1);
      localObject1 = this.ybx;
      if (localObject1 == null) {
        break label981;
      }
      localObject1 = (TextView)((View)localObject1).findViewById(b.f.left_hint);
      label813:
      this.ybz = ((TextView)localObject1);
      localObject1 = this.ybu;
      if (localObject1 == null) {
        break label986;
      }
      localObject1 = (Button)((ViewGroup)localObject1).findViewById(b.f.finish_button);
      label838:
      this.ybA = ((Button)localObject1);
      localObject1 = this.ybA;
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
      ar.a((Paint)localObject1, 0.8F);
      localObject1 = this.ybA;
      if (localObject1 != null) {
        ((Button)localObject1).setOnClickListener((View.OnClickListener)new d(this));
      }
      oH(false);
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.live.utils.a.a(this.yby, this.ybz, this.yba, this.ybb, (kotlin.g.a.a)new e(this));
      localObject1 = this.ybu;
      if (localObject1 != null) {
        ((ViewGroup)localObject1).setVisibility(8);
      }
      dxA();
      AppMethodBeat.o(273454);
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
    AppMethodBeat.i(273457);
    if (!paramBoolean) {
      dxA();
    }
    Object localObject1 = this.ybv;
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
      localObject2 = this.ybu;
      if (localObject2 != null) {
        ((ViewGroup)localObject2).updateViewLayout(this.ybv, (ViewGroup.LayoutParams)localObject1);
      }
    }
    localObject1 = this.ybo;
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
      p.j(localObject1, "MMApplicationContext.getContext()");
      int k = ((Context)localObject1).getResources().getDimensionPixelOffset(b.d.Edge_8A);
      if (localLayoutParams == null) {
        break label539;
      }
      if (!paramBoolean) {
        break label487;
      }
      int m = ax.au(MMApplicationContext.getContext()).y;
      localObject1 = this.ybo;
      if (localObject1 == null) {
        break label448;
      }
      i = ((View)localObject1).getHeight();
      localObject1 = new int[2];
      localObject2 = this.ybl;
      if (localObject2 != null) {
        ((View)localObject2).getLocationOnScreen((int[])localObject1);
      }
      int n = localObject1[1];
      localObject1 = this.ybl;
      if (localObject1 == null) {
        break label453;
      }
      j = ((View)localObject1).getHeight();
      label240:
      Log.i(this.TAG, "adjustConfirmBtnLayout screenHeight:" + m + ",confirmBtnContainerH:" + i + ",descContainerY:" + n + ",itemHeight:" + j + ",height:" + paramInt);
      if ((i != 0) && (n != 0) && (m - k - i - (j + n) > paramInt)) {
        break label459;
      }
      localObject1 = this.ybl;
      if (localObject1 != null)
      {
        paramInt = ((View)localObject1).getId();
        localLayoutParams.removeRule(2);
        localLayoutParams.removeRule(12);
        localLayoutParams.addRule(3, paramInt);
        localLayoutParams.bottomMargin = 0;
      }
      label376:
      localObject1 = this.ybo;
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
      ((ViewGroup)localObject1).updateViewLayout(this.ybo, (ViewGroup.LayoutParams)localLayoutParams);
      AppMethodBeat.o(273457);
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
      localObject1 = this.ybp;
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
    AppMethodBeat.o(273457);
  }
  
  public final void oG(boolean paramBoolean)
  {
    AppMethodBeat.i(273461);
    Log.i(this.TAG, "updateConfirmBtn canConfirm:".concat(String.valueOf(paramBoolean)));
    Button localButton = this.raT;
    if (localButton != null) {
      localButton.setEnabled(paramBoolean);
    }
    a(this.raT, paramBoolean);
    AppMethodBeat.o(273461);
  }
  
  final void oH(boolean paramBoolean)
  {
    AppMethodBeat.i(273455);
    Button localButton = this.ybA;
    if (localButton != null) {
      localButton.setEnabled(paramBoolean);
    }
    a(this.ybA, paramBoolean);
    AppMethodBeat.o(273455);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(s params) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(287553);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initInputPage$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.ybC.dxB();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initInputPage$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(287553);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(s params) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(274658);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initInputPage$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.ybC.dxB();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initInputPage$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(274658);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(s params) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(279748);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initInputPage$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.ybC.yby;
      if (paramView != null) {
        paramView.requestFocus();
      }
      s.g(this.ybC.yby);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initInputPage$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(279748);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(s params) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(282112);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initInputPage$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      s locals = this.ybC;
      paramView = locals.yby;
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
      localObject = aj.AGc;
      paramView = aj.aFP(paramView);
      localObject = (CharSequence)paramView;
      int i;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0))
      {
        i = 1;
        if (i == 0) {
          break label134;
        }
        locals.dxB();
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initInputPage$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(282112);
        return;
        i = 0;
        break;
        label134:
        locals.yaG = 1;
        localObject = locals.ybf;
        if (localObject != null) {
          ((TextView)localObject).setText((CharSequence)(locals.activity.getResources().getString(b.j.finder_live_lottery_comment) + '"' + paramView + '"'));
        }
        localObject = locals.yaS;
        if (localObject != null) {
          ((p.a)localObject).Ne(locals.yaG);
        }
        localObject = locals.yaS;
        if (localObject != null) {
          ((p.a)localObject).aBS(paramView);
        }
        localObject = locals.ybu;
        if (localObject != null) {
          ((ViewGroup)localObject).setVisibility(4);
        }
        s.d(locals.yby);
        localObject = k.yBj;
        k.a(com.tencent.mm.plugin.finder.live.report.s.f.yEX, paramView);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    e(s params)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    f(s params)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    g(s params)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(s params) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(271309);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initNormalView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = this.ybC;
      paramView.ybq = new e((Context)paramView.activity, 1, false);
      localObject = paramView.ybq;
      if (localObject != null) {
        ((e)localObject).a((q.f)new s.q(paramView));
      }
      localObject = paramView.ybq;
      if (localObject != null) {
        ((e)localObject).a(paramView.ybB);
      }
      paramView = paramView.ybq;
      if (paramView != null) {
        paramView.eik();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initNormalView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(271309);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(s params) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(285418);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initNormalView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.ybC.ybh;
      if (paramView != null) {
        paramView.requestFocus();
      }
      s.g(this.ybC.ybh);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initNormalView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(285418);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(s params) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(290265);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initNormalView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.ybC.ybk;
      if (paramView != null) {
        paramView.requestFocus();
      }
      s.g(this.ybC.ybk);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initNormalView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(290265);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(s params) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(280596);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initNormalView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.ybC.ybm;
      if (paramView != null) {
        paramView.requestFocus();
      }
      s.g(this.ybC.ybm);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initNormalView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(280596);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    l(s params) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(276796);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initNormalView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = aj.AGc;
      if (aj.isFastClick())
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initNormalView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(276796);
        return;
      }
      this.ybC.dxA();
      paramView = this.ybC.yaS;
      if (paramView != null) {
        paramView.dxy();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initNormalView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(276796);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
  static final class n
    implements q.g
  {
    n(s params) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(269018);
      if (paramMenuItem != null)
      {
        localObject = Integer.valueOf(paramMenuItem.getItemId());
        paramInt = this.ybC.yaV;
        if (localObject != null) {
          break label90;
        }
        label31:
        paramInt = this.ybC.yaY;
        if (localObject != null) {
          break label205;
        }
        label43:
        paramInt = this.ybC.yaZ;
        if (localObject != null) {
          break label322;
        }
        label55:
        paramInt = this.ybC.yaW;
        if (localObject != null) {
          break label433;
        }
      }
      label90:
      while (((Integer)localObject).intValue() != paramInt)
      {
        paramInt = this.ybC.yaX;
        if (localObject != null) {
          break label550;
        }
        AppMethodBeat.o(269018);
        return;
        localObject = null;
        break;
        if (((Integer)localObject).intValue() != paramInt) {
          break label31;
        }
        paramMenuItem = this.ybC.ybq;
        if (paramMenuItem != null) {
          paramMenuItem.bYF();
        }
        paramMenuItem = this.ybC;
        paramMenuItem.ybr = new e((Context)paramMenuItem.activity, 1, false);
        localObject = paramMenuItem.ybr;
        if (localObject != null) {
          ((e)localObject).a((q.f)new s.r(paramMenuItem));
        }
        localObject = paramMenuItem.ybr;
        if (localObject != null) {
          ((e)localObject).a(paramMenuItem.ybB);
        }
        paramMenuItem = paramMenuItem.ybr;
        if (paramMenuItem != null)
        {
          paramMenuItem.eik();
          AppMethodBeat.o(269018);
          return;
        }
        AppMethodBeat.o(269018);
        return;
        if (((Integer)localObject).intValue() != paramInt) {
          break label43;
        }
        localObject = this.ybC.ybf;
        if (localObject != null) {
          ((TextView)localObject).setText(paramMenuItem.getTitle());
        }
        this.ybC.yaG = 2;
        paramMenuItem = this.ybC.yaS;
        if (paramMenuItem != null) {
          paramMenuItem.Ne(this.ybC.yaG);
        }
        paramMenuItem = this.ybC.yaS;
        if (paramMenuItem != null) {
          paramMenuItem.aBS("");
        }
        paramMenuItem = this.ybC.ybq;
        if (paramMenuItem != null) {
          paramMenuItem.bYF();
        }
        paramMenuItem = k.yBj;
        k.a(com.tencent.mm.plugin.finder.live.report.s.f.yEW, "");
        AppMethodBeat.o(269018);
        return;
        if (((Integer)localObject).intValue() != paramInt) {
          break label55;
        }
        localObject = this.ybC.ybf;
        if (localObject != null) {
          ((TextView)localObject).setText(paramMenuItem.getTitle());
        }
        this.ybC.yaG = 3;
        paramMenuItem = this.ybC.yaS;
        if (paramMenuItem != null) {
          paramMenuItem.Ne(this.ybC.yaG);
        }
        paramMenuItem = this.ybC.yaS;
        if (paramMenuItem != null) {
          paramMenuItem.aBS("");
        }
        paramMenuItem = this.ybC.ybq;
        if (paramMenuItem != null)
        {
          paramMenuItem.bYF();
          AppMethodBeat.o(269018);
          return;
        }
        AppMethodBeat.o(269018);
        return;
      }
      label205:
      Object localObject = this.ybC.ybf;
      label322:
      if (localObject != null) {
        ((TextView)localObject).setText(paramMenuItem.getTitle());
      }
      label433:
      this.ybC.yaG = 1;
      paramMenuItem = this.ybC.yaS;
      if (paramMenuItem != null) {
        paramMenuItem.Ne(this.ybC.yaG);
      }
      paramMenuItem = this.ybC.yaS;
      if (paramMenuItem != null) {
        paramMenuItem.aBS("");
      }
      paramMenuItem = this.ybC.ybr;
      if (paramMenuItem != null) {
        paramMenuItem.bYF();
      }
      paramMenuItem = k.yBj;
      k.a(com.tencent.mm.plugin.finder.live.report.s.f.yEU, "");
      AppMethodBeat.o(269018);
      return;
      label550:
      if (((Integer)localObject).intValue() == paramInt)
      {
        paramMenuItem = k.yBj;
        k.a(com.tencent.mm.plugin.finder.live.report.s.f.yEV, "");
        paramMenuItem = this.ybC;
        localObject = paramMenuItem.ybu;
        if (localObject != null) {
          ((ViewGroup)localObject).setVisibility(0);
        }
        localObject = paramMenuItem.yby;
        if (localObject != null) {
          ((EditText)localObject).post((Runnable)new s.o(paramMenuItem));
        }
        paramMenuItem = this.ybC.ybr;
        if (paramMenuItem != null)
        {
          paramMenuItem.bYF();
          AppMethodBeat.o(269018);
          return;
        }
      }
      AppMethodBeat.o(269018);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class o
    implements Runnable
  {
    o(s params) {}
    
    public final void run()
    {
      AppMethodBeat.i(282534);
      EditText localEditText = this.ybC.yby;
      if (localEditText != null) {
        localEditText.requestFocus();
      }
      s.g(this.ybC.yby);
      AppMethodBeat.o(282534);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class p
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    p(String paramString)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class q
    implements q.f
  {
    q(s params) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramo)
    {
      AppMethodBeat.i(268170);
      Object localObject = k.yBj;
      k.a(com.tencent.mm.plugin.finder.live.report.s.f.yET, "");
      localObject = this.ybC;
      p.j(paramo, "menu");
      paramo.d(((s)localObject).yaW, (CharSequence)((s)localObject).activity.getResources().getString(b.j.finder_live_lottery_any_comment));
      paramo.d(((s)localObject).yaX, (CharSequence)((s)localObject).activity.getResources().getString(b.j.finder_live_lottery_special_comment));
      paramo.d(((s)localObject).yaY, (CharSequence)((s)localObject).activity.getResources().getString(b.j.finder_live_lottery_like));
      AppMethodBeat.o(268170);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class r
    implements q.f
  {
    r(s params) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramo)
    {
      AppMethodBeat.i(287611);
      s locals = this.ybC;
      p.j(paramo, "menu");
      paramo.d(locals.yaW, (CharSequence)locals.activity.getResources().getString(b.j.finder_live_lottery_any_comment));
      paramo.d(locals.yaX, (CharSequence)locals.activity.getResources().getString(b.j.finder_live_lottery_special_comment));
      AppMethodBeat.o(287611);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "ok", "", "invoke"})
  static final class s
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Boolean, x>
  {
    s(s params)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.s
 * JD-Core Version:    0.7.0.1
 */