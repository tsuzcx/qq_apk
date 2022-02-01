package com.tencent.mm.live.b;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.kernel.f;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.c.e;
import com.tencent.mm.live.model.u;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/plugin/LiveBeforePlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/widget/RelativeLayout;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "closeBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "hostString", "liveEditTopGroup", "liveRoomIdEdit", "Landroid/widget/EditText;", "liveTitleEdit", "liveTitleEditCancel", "Landroid/widget/TextView;", "liveTitleEditGroup", "liveTitleEditOk", "Landroid/widget/Button;", "liveTitleEditTextNumHint", "liveTitleTv", "mTopicName", "providerTip", "rootLayout", "startLiveBtn", "switchBtn", "titleEditBackground", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "topGroup", "Landroid/view/ViewGroup;", "checkLiveName", "", "liveName", "createLive", "", "enableTestRoomId", "keyboardChange", "show", "height", "", "onBackPress", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends a
{
  private final String TAG;
  private final b nfT;
  private final RelativeLayout ngJ;
  private final Button ngK;
  private final TextView ngL;
  private final EditText ngM;
  private final WeImageView ngN;
  private final WeImageView ngO;
  private final ViewGroup ngP;
  private final EditText ngQ;
  private final TextView ngR;
  private final TextView ngS;
  private final Button ngT;
  private final RelativeLayout ngU;
  private final RelativeLayout ngV;
  private final TextView ngW;
  private String ngX;
  private String ngY;
  private Drawable ngZ;
  
  public g(RelativeLayout paramRelativeLayout, b paramb)
  {
    super((ViewGroup)paramRelativeLayout, paramb);
    AppMethodBeat.i(247075);
    this.nfT = paramb;
    this.TAG = "MicroMsg.LiveBeforePlugin";
    paramb = paramRelativeLayout.findViewById(b.e.live_before_ui_root);
    s.s(paramb, "root.findViewById(R.id.live_before_ui_root)");
    this.ngJ = ((RelativeLayout)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_before_content_start_btn);
    s.s(paramb, "root.findViewById(R.id.l…before_content_start_btn)");
    this.ngK = ((Button)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_before_provider_tip);
    s.s(paramb, "root.findViewById(R.id.live_before_provider_tip)");
    this.ngL = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_before_content_title_edit);
    s.s(paramb, "root.findViewById(R.id.l…efore_content_title_edit)");
    this.ngM = ((EditText)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_before_top_close);
    s.s(paramb, "root.findViewById(R.id.live_before_top_close)");
    this.ngN = ((WeImageView)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_before_top_switch);
    s.s(paramb, "root.findViewById(R.id.live_before_top_switch)");
    this.ngO = ((WeImageView)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_before_top_group);
    s.s(paramb, "root.findViewById(R.id.live_before_top_group)");
    this.ngP = ((ViewGroup)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_before_content_roomid_edit);
    s.s(paramb, "root.findViewById(R.id.l…fore_content_roomid_edit)");
    this.ngQ = ((EditText)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.title_edit_text_num_hint);
    s.s(paramb, "root.findViewById(R.id.title_edit_text_num_hint)");
    this.ngR = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_title_edit_cancel);
    s.s(paramb, "root.findViewById(R.id.live_title_edit_cancel)");
    this.ngS = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_title_edit_ok);
    s.s(paramb, "root.findViewById(R.id.live_title_edit_ok)");
    this.ngT = ((Button)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_before_content_title_edit_group);
    s.s(paramb, "root.findViewById(R.id.l…content_title_edit_group)");
    this.ngU = ((RelativeLayout)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_before_edit_top_group);
    s.s(paramb, "root.findViewById(R.id.live_before_edit_top_group)");
    this.ngV = ((RelativeLayout)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_before_title);
    s.s(paramb, "root.findViewById(R.id.live_before_title)");
    this.ngW = ((TextView)paramb);
    this.ngX = "";
    this.ngY = "";
    this.ngZ = this.ngM.getBackground();
    this.ngJ.setOnClickListener(new g..ExternalSyntheticLambda5(this, paramRelativeLayout));
    paramb = z.bBF();
    if (paramb == null)
    {
      paramb = "";
      this.ngY = paramb;
      this.ngM.setHint((CharSequence)p.b(paramRelativeLayout.getContext(), (CharSequence)paramRelativeLayout.getContext().getString(b.h.live_before_title_edit, new Object[] { this.ngY }), this.ngM.getTextSize()));
      this.ngM.setOnEditorActionListener(new g..ExternalSyntheticLambda7(paramRelativeLayout, this));
      this.ngN.setOnClickListener(new g..ExternalSyntheticLambda2(this));
      this.ngO.setOnClickListener(new g..ExternalSyntheticLambda4(this));
      this.ngK.setOnClickListener(new g..ExternalSyntheticLambda1(this));
      paramb = this.ngQ;
      if (!bjh()) {
        break label738;
      }
    }
    label738:
    for (int i = 0;; i = 8)
    {
      paramb.setVisibility(i);
      paramb = this.ngQ;
      Object localObject = com.tencent.mm.live.core.core.model.h.mNy;
      paramb.setText((CharSequence)String.valueOf(com.tencent.mm.live.core.core.model.h.ben().roomId));
      com.tencent.mm.ui.tools.b.c.i(this.ngM).oF(0, 28).a(null);
      this.ngM.addTextChangedListener((TextWatcher)new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(247498);
          g localg;
          Button localButton;
          if (paramAnonymousEditable != null)
          {
            localg = this.nha;
            localButton = g.a(localg);
            if (Util.isNullOrNil((CharSequence)paramAnonymousEditable)) {
              break label128;
            }
          }
          label128:
          for (boolean bool = true;; bool = false)
          {
            localButton.setEnabled(bool);
            int i = com.tencent.mm.ui.tools.g.a(paramAnonymousEditable.toString(), com.tencent.mm.ui.tools.g.a.afII);
            g.b(localg).setText((CharSequence)String.valueOf(28 - i));
            g.c(localg).setSelection(g.c(localg).getText().length());
            paramAnonymousEditable = u.mZl;
            u.bie().Zqd = g.c(localg).getText().toString();
            paramAnonymousEditable = u.mZl;
            u.fU(true);
            com.tencent.mm.live.c.a.bjH();
            AppMethodBeat.o(247498);
            return;
          }
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.ngM.setOnClickListener(new g..ExternalSyntheticLambda3(this));
      this.ngS.setOnClickListener(new g..ExternalSyntheticLambda6(this, paramRelativeLayout));
      this.ngT.setOnClickListener(new g..ExternalSyntheticLambda0(paramRelativeLayout, this));
      this.ngU.post(new g..ExternalSyntheticLambda9(this, paramRelativeLayout));
      if ((!isLandscape()) || (this.ngP.getLayoutParams() == null) || (this.ngV.getLayoutParams() == null)) {
        break label816;
      }
      paramb = this.ngP.getLayoutParams();
      if (paramb != null) {
        break label744;
      }
      paramRelativeLayout = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(247075);
      throw paramRelativeLayout;
      localObject = paramb.aSV();
      paramb = (b)localObject;
      if (localObject != null) {
        break;
      }
      paramb = "";
      break;
    }
    label744:
    ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(bf.bk(paramRelativeLayout.getContext()));
    paramb = this.ngV.getLayoutParams();
    if (paramb == null)
    {
      paramRelativeLayout = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(247075);
      throw paramRelativeLayout;
    }
    ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(bf.bk(paramRelativeLayout.getContext()));
    this.ngP.requestLayout();
    this.ngV.requestLayout();
    try
    {
      label816:
      paramRelativeLayout = paramRelativeLayout.getContext().getResources().getString(b.h.live_provider_tip);
      s.s(paramRelativeLayout, "root.context.resources.g…string.live_provider_tip)");
      paramRelativeLayout = new i(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zrY, "{\"simple_chinese\":\"" + paramRelativeLayout + "\",\"xg_traditional_chinese\":\"" + paramRelativeLayout + "\",\"tw_traditional_chinese\":\"" + paramRelativeLayout + "\",\"english\":\"" + paramRelativeLayout + "\"}"));
      paramb = LocaleUtil.getApplicationLanguage();
      if (s.p("zh_CN", paramb)) {
        paramRelativeLayout = paramRelativeLayout.getString("simple_chinese");
      }
      while (!Util.isNullOrNil(paramRelativeLayout))
      {
        this.ngL.setText((CharSequence)paramRelativeLayout);
        AppMethodBeat.o(247075);
        return;
        if (s.p("zh_TW", paramb)) {
          paramRelativeLayout = paramRelativeLayout.getString("xg_traditional_chinese");
        } else if (s.p("zh_HK", paramb)) {
          paramRelativeLayout = paramRelativeLayout.getString("tw_traditional_chinese");
        } else {
          paramRelativeLayout = paramRelativeLayout.getString("english");
        }
      }
      return;
    }
    catch (Exception paramRelativeLayout)
    {
      Log.w(this.TAG, s.X("Exception: ", paramRelativeLayout.getMessage()));
      AppMethodBeat.o(247075);
    }
  }
  
  private static final void a(RelativeLayout paramRelativeLayout, g paramg, View paramView)
  {
    AppMethodBeat.i(247176);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramRelativeLayout);
    localb.cH(paramg);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveBeforePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRelativeLayout, "$root");
    s.u(paramg, "this$0");
    paramRelativeLayout = paramRelativeLayout.getContext();
    if (paramRelativeLayout == null)
    {
      paramRelativeLayout = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(247176);
      throw paramRelativeLayout;
    }
    ((MMActivity)paramRelativeLayout).hideVKB();
    paramg.ngM.clearFocus();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveBeforePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(247176);
  }
  
  private static final void a(g paramg, View paramView)
  {
    AppMethodBeat.i(247128);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramg);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveBeforePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramg, "this$0");
    b.b.a(paramg.nfT, b.c.ncl);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveBeforePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(247128);
  }
  
  private static final void a(g paramg, RelativeLayout paramRelativeLayout)
  {
    AppMethodBeat.i(247190);
    s.u(paramg, "this$0");
    s.u(paramRelativeLayout, "$root");
    Object localObject;
    if (paramg.isLandscape())
    {
      localObject = paramg.ngU.getLayoutParams();
      if (localObject == null)
      {
        paramg = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(247190);
        throw paramg;
      }
    }
    for (((RelativeLayout.LayoutParams)localObject).bottomMargin = (com.tencent.mm.cd.a.br(paramRelativeLayout.getContext(), com.tencent.mm.live.b.c.Edge_10A) + com.tencent.mm.cd.a.br(paramRelativeLayout.getContext(), com.tencent.mm.live.b.c.live_before_content_start_btn_margin_bottom) + paramg.ngK.getHeight());; ((RelativeLayout.LayoutParams)localObject).bottomMargin = (com.tencent.mm.cd.a.br(paramRelativeLayout.getContext(), com.tencent.mm.live.b.c.Edge_10A) + com.tencent.mm.cd.a.br(paramRelativeLayout.getContext(), com.tencent.mm.live.b.c.Edge_12A) + paramg.ngK.getHeight() + bf.bk(paramRelativeLayout.getContext())))
    {
      paramg.ngU.requestLayout();
      AppMethodBeat.o(247190);
      return;
      localObject = paramg.ngL.getLayoutParams();
      if (localObject != null)
      {
        localObject = (ViewGroup.MarginLayoutParams)localObject;
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin += bf.bk(paramRelativeLayout.getContext());
        paramg.ngL.requestLayout();
      }
      localObject = paramg.ngK.getLayoutParams();
      if (localObject != null)
      {
        localObject = (ViewGroup.MarginLayoutParams)localObject;
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin += bf.bk(paramRelativeLayout.getContext());
        paramg.ngK.requestLayout();
      }
      localObject = paramg.ngU.getLayoutParams();
      if (localObject == null)
      {
        paramg = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(247190);
        throw paramg;
      }
    }
  }
  
  private static final void a(g paramg, RelativeLayout paramRelativeLayout, View paramView)
  {
    AppMethodBeat.i(247109);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramg);
    localb.cH(paramRelativeLayout);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveBeforePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramg, "this$0");
    s.u(paramRelativeLayout, "$root");
    if (!Util.isNullOrNil(paramg.ngM.getText().toString()))
    {
      paramRelativeLayout = paramRelativeLayout.getContext();
      if (paramRelativeLayout == null)
      {
        paramg = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(247109);
        throw paramg;
      }
      ((MMActivity)paramRelativeLayout).hideVKB();
      paramg.ngM.clearFocus();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveBeforePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(247109);
  }
  
  private static final boolean a(RelativeLayout paramRelativeLayout, g paramg, TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(247115);
    s.u(paramRelativeLayout, "$root");
    s.u(paramg, "this$0");
    if ((6 == paramInt) || (paramKeyEvent.getAction() == 66))
    {
      paramRelativeLayout = paramRelativeLayout.getContext();
      if (paramRelativeLayout == null)
      {
        paramRelativeLayout = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(247115);
        throw paramRelativeLayout;
      }
      ((MMActivity)paramRelativeLayout).hideVKB();
      paramg.ngM.clearFocus();
    }
    AppMethodBeat.o(247115);
    return false;
  }
  
  private static final void b(g paramg, View paramView)
  {
    AppMethodBeat.i(247139);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramg);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveBeforePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramg, "this$0");
    paramg.nfT.statusChange(b.c.ncm, new Bundle());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveBeforePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(247139);
  }
  
  private static final void b(g paramg, RelativeLayout paramRelativeLayout, View paramView)
  {
    AppMethodBeat.i(247165);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramg);
    localb.cH(paramRelativeLayout);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveBeforePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramg, "this$0");
    s.u(paramRelativeLayout, "$root");
    if (n.bp((CharSequence)paramg.ngX))
    {
      paramg.ngM.setHint((CharSequence)p.b(paramRelativeLayout.getContext(), (CharSequence)paramRelativeLayout.getContext().getString(b.h.live_before_title_edit, new Object[] { paramg.ngY }), paramg.ngM.getTextSize()).toString());
      paramg.ngM.setText(null);
      paramView = u.mZl;
    }
    for (u.bie().Zqd = p.b(paramRelativeLayout.getContext(), (CharSequence)paramRelativeLayout.getContext().getString(b.h.live_before_title_edit, new Object[] { paramg.ngY }), paramg.ngM.getTextSize()).toString();; u.bie().Zqd = paramg.ngM.getText().toString())
    {
      paramView = u.mZl;
      u.fU(false);
      paramRelativeLayout = paramRelativeLayout.getContext();
      if (paramRelativeLayout != null) {
        break;
      }
      paramg = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(247165);
      throw paramg;
      paramg.ngM.setText((CharSequence)paramg.ngX);
      paramView = u.mZl;
    }
    ((MMActivity)paramRelativeLayout).hideVKB();
    paramg.ngM.clearFocus();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveBeforePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(247165);
  }
  
  private static boolean bjh()
  {
    AppMethodBeat.i(247084);
    if (com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adfs, 0) == 1)
    {
      AppMethodBeat.o(247084);
      return true;
    }
    AppMethodBeat.o(247084);
    return false;
  }
  
  private final void bji()
  {
    AppMethodBeat.i(247097);
    Object localObject = (CharSequence)this.ngM.getText();
    if ((localObject == null) || (n.bp((CharSequence)localObject)))
    {
      i = 1;
      if (i == 0) {
        break label164;
      }
      localObject = "";
      label38:
      if (!bjh()) {
        break label178;
      }
    }
    label164:
    label178:
    for (int i = Integer.parseInt(this.ngQ.getText().toString());; i = -1)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("PARAM_LIVE_TEST_ROOM_ID", i);
      localBundle.putString("PARAM_START_LIVE_TITLE", (String)localObject);
      localObject = u.mZl;
      u.bie().aaNq = p.b(this.mJe.getContext(), (CharSequence)this.mJe.getContext().getString(b.h.live_before_title_edit, new Object[] { this.ngY }), this.ngM.getTextSize()).toString();
      this.nfT.statusChange(b.c.ndi, localBundle);
      AppMethodBeat.o(247097);
      return;
      i = 0;
      break;
      localObject = this.ngM.getText().toString();
      break label38;
    }
  }
  
  private static final void c(g paramg, View paramView)
  {
    AppMethodBeat.i(247150);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramg);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveBeforePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramg, "this$0");
    paramg.bji();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveBeforePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(247150);
  }
  
  private static final void d(g paramg, View paramView)
  {
    AppMethodBeat.i(247157);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramg);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveBeforePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramg, "this$0");
    paramg.ngX = paramg.ngM.getText().toString();
    if (Util.isNullOrNil(paramg.ngX)) {
      paramg.ngT.setEnabled(false);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveBeforePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(247157);
      return;
      paramg.ngT.setEnabled(true);
    }
  }
  
  private static final void o(boolean paramBoolean, String paramString) {}
  
  public final void keyboardChange(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(247304);
    if (paramBoolean)
    {
      this.ngW.setVisibility(8);
      this.ngP.setVisibility(8);
      this.ngK.setVisibility(8);
      Object localObject;
      if (isLandscape())
      {
        paramInt = bf.bf(this.mJe.getContext()).y - paramInt - com.tencent.mm.cd.a.br(this.mJe.getContext(), com.tencent.mm.live.b.c.Edge_2A);
        localObject = new int[2];
        this.ngU.getLocationOnScreen((int[])localObject);
        int i = localObject[1];
        int j = this.ngU.getHeight();
        this.ngU.animate().translationY(paramInt - (i + j)).start();
        this.ngM.setBackground(this.mJe.getContext().getResources().getDrawable(com.tencent.mm.live.b.b.transparent));
        this.ngM.setPadding(0, 0, 0, 0);
        this.ngM.setHint((CharSequence)" ");
        this.ngM.setCursorVisible(true);
        this.ngR.setVisibility(0);
        localObject = this.ngM.getText();
        if (localObject != null) {
          break label297;
        }
        localObject = "";
      }
      for (;;)
      {
        paramInt = com.tencent.mm.ui.tools.g.a((String)localObject, com.tencent.mm.ui.tools.g.a.afII);
        this.ngR.setText((CharSequence)String.valueOf(28 - paramInt));
        this.ngS.setVisibility(0);
        this.ngT.setVisibility(0);
        AppMethodBeat.o(247304);
        return;
        paramInt = bf.bf(this.mJe.getContext()).y - paramInt - bf.bk(this.mJe.getContext()) - com.tencent.mm.cd.a.br(this.mJe.getContext(), com.tencent.mm.live.b.c.Edge_2A);
        break;
        label297:
        String str = localObject.toString();
        localObject = str;
        if (str == null) {
          localObject = "";
        }
      }
    }
    this.ngW.setVisibility(0);
    this.ngP.setVisibility(0);
    this.ngK.setVisibility(0);
    this.ngU.animate().translationY(0.0F).start();
    this.ngM.setBackground(this.ngZ);
    com.tencent.mm.cd.a.br(this.mJe.getContext(), com.tencent.mm.live.b.c.Edge_4A);
    paramInt = com.tencent.mm.cd.a.br(this.mJe.getContext(), com.tencent.mm.live.b.c.Edge_A);
    this.ngM.setPadding(0, 0, 0, paramInt);
    this.ngM.setHint((CharSequence)p.b(this.mJe.getContext(), (CharSequence)this.mJe.getContext().getString(b.h.live_before_title_edit, new Object[] { this.ngY }), this.ngM.getTextSize()));
    this.ngM.setCursorVisible(false);
    this.ngR.setVisibility(8);
    this.ngS.setVisibility(8);
    this.ngT.setVisibility(8);
    AppMethodBeat.o(247304);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(247318);
    if (this.mJe.getVisibility() == 0)
    {
      b.b.a(this.nfT, b.c.ncl);
      AppMethodBeat.o(247318);
      return true;
    }
    AppMethodBeat.o(247318);
    return false;
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(247313);
    s.u(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (g.a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(247313);
      return;
      tO(8);
      AppMethodBeat.o(247313);
      return;
      if (paramBundle == null)
      {
        paramc = null;
        if ((paramc != null) && (paramc.intValue() != -1))
        {
          paramBundle = new com.tencent.mm.ui.widget.a.g.a(this.mJe.getContext());
          paramBundle.Xdm = true;
          paramBundle.bDE(this.mJe.getContext().getString(paramc.intValue())).bDI(this.mJe.getContext().getString(b.h.app_i_know)).b(g..ExternalSyntheticLambda8.INSTANCE).show();
        }
        paramc = u.mZl;
        paramBundle = u.bie();
        paramc = (CharSequence)this.ngM.getText();
        if ((paramc != null) && (!n.bp(paramc))) {
          break label289;
        }
        i = 1;
        label197:
        if (i == 0) {
          break label294;
        }
      }
      label289:
      label294:
      for (paramc = p.b(this.mJe.getContext(), (CharSequence)this.mJe.getContext().getString(b.h.live_before_title_edit, new Object[] { this.ngY }), this.ngM.getTextSize()).toString();; paramc = this.ngM.getText().toString())
      {
        paramBundle.Zqd = paramc;
        paramc = u.mZl;
        u.fX(false);
        tO(0);
        AppMethodBeat.o(247313);
        return;
        paramc = Integer.valueOf(paramBundle.getInt("PARAM_FACE_VERIFY_ERROR", -1));
        break;
        i = 0;
        break label197;
      }
      paramc = u.mZl;
      if (u.biy()) {}
      for (int i = 3;; i = 2)
      {
        paramc = u.mZl;
        paramc = u.bhZ();
        paramBundle = u.mZl;
        boolean bool1 = u.biv();
        paramBundle = u.mZl;
        boolean bool2 = u.biw();
        paramBundle = u.mZl;
        paramBundle = u.bie().Zqd;
        u localu = u.mZl;
        e.a(paramc, bool1, bool2, paramBundle, u.biu(), this.mJe.getResources().getConfiguration().orientation, i);
        com.tencent.mm.live.c.a.bjG();
        paramc = u.mZl;
        u.fX(false);
        AppMethodBeat.o(247313);
        return;
      }
      com.tencent.mm.live.c.a.bjF();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.b.g
 * JD-Core Version:    0.7.0.1
 */