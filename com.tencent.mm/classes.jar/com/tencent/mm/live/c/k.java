package com.tencent.mm.live.c;

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
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.b.u;
import com.tencent.mm.live.d.e;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.g.a;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/plugin/LiveBeforePlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/widget/RelativeLayout;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "closeBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "hostString", "liveEditTopGroup", "liveRoomIdEdit", "Landroid/widget/EditText;", "liveTitleEdit", "liveTitleEditCancel", "Landroid/widget/TextView;", "liveTitleEditGroup", "liveTitleEditOk", "Landroid/widget/Button;", "liveTitleEditTextNumHint", "liveTitleTv", "mTopicName", "providerTip", "rootLayout", "startLiveBtn", "switchBtn", "titleEditBackground", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "topGroup", "Landroid/view/ViewGroup;", "checkLiveName", "", "liveName", "createLive", "", "enableTestRoomId", "keyboardChange", "show", "height", "", "onBackPress", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class k
  extends a
{
  private final String TAG;
  private final b kCL;
  private final EditText kDA;
  private final TextView kDB;
  private final TextView kDC;
  private final Button kDD;
  private final RelativeLayout kDE;
  private final RelativeLayout kDF;
  private final TextView kDG;
  private String kDH;
  private String kDI;
  private Drawable kDJ;
  private final RelativeLayout kDt;
  private final Button kDu;
  private final TextView kDv;
  private final EditText kDw;
  private final WeImageView kDx;
  private final WeImageView kDy;
  private final ViewGroup kDz;
  
  public k(final RelativeLayout paramRelativeLayout, b paramb)
  {
    super((ViewGroup)paramRelativeLayout, paramb);
    AppMethodBeat.i(198532);
    this.kCL = paramb;
    this.TAG = "MicroMsg.LiveBeforePlugin";
    paramb = paramRelativeLayout.findViewById(b.e.live_before_ui_root);
    p.j(paramb, "root.findViewById(R.id.live_before_ui_root)");
    this.kDt = ((RelativeLayout)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_before_content_start_btn);
    p.j(paramb, "root.findViewById(R.id.l…before_content_start_btn)");
    this.kDu = ((Button)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_before_provider_tip);
    p.j(paramb, "root.findViewById(R.id.live_before_provider_tip)");
    this.kDv = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_before_content_title_edit);
    p.j(paramb, "root.findViewById(R.id.l…efore_content_title_edit)");
    this.kDw = ((EditText)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_before_top_close);
    p.j(paramb, "root.findViewById(R.id.live_before_top_close)");
    this.kDx = ((WeImageView)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_before_top_switch);
    p.j(paramb, "root.findViewById(R.id.live_before_top_switch)");
    this.kDy = ((WeImageView)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_before_top_group);
    p.j(paramb, "root.findViewById(R.id.live_before_top_group)");
    this.kDz = ((ViewGroup)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_before_content_roomid_edit);
    p.j(paramb, "root.findViewById(R.id.l…fore_content_roomid_edit)");
    this.kDA = ((EditText)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.title_edit_text_num_hint);
    p.j(paramb, "root.findViewById(R.id.title_edit_text_num_hint)");
    this.kDB = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_title_edit_cancel);
    p.j(paramb, "root.findViewById(R.id.live_title_edit_cancel)");
    this.kDC = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_title_edit_ok);
    p.j(paramb, "root.findViewById(R.id.live_title_edit_ok)");
    this.kDD = ((Button)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_before_content_title_edit_group);
    p.j(paramb, "root.findViewById(R.id.l…content_title_edit_group)");
    this.kDE = ((RelativeLayout)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_before_edit_top_group);
    p.j(paramb, "root.findViewById(R.id.live_before_edit_top_group)");
    this.kDF = ((RelativeLayout)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_before_title);
    p.j(paramb, "root.findViewById(R.id.live_before_title)");
    this.kDG = ((TextView)paramb);
    this.kDH = "";
    this.kDI = "";
    this.kDJ = this.kDw.getBackground();
    this.kDt.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(197155);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveBeforePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (!Util.isNullOrNil(k.a(this.kDK).getText().toString()))
        {
          paramAnonymousView = paramRelativeLayout.getContext();
          if (paramAnonymousView == null)
          {
            paramAnonymousView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(197155);
            throw paramAnonymousView;
          }
          ((MMActivity)paramAnonymousView).hideVKB();
          k.a(this.kDK).clearFocus();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveBeforePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(197155);
      }
    });
    paramb = z.bdN();
    Object localObject;
    if (paramb != null)
    {
      localObject = paramb.ays();
      paramb = (b)localObject;
      if (localObject != null) {}
    }
    else
    {
      paramb = "";
    }
    this.kDI = paramb;
    this.kDw.setHint((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b(paramRelativeLayout.getContext(), (CharSequence)paramRelativeLayout.getContext().getString(b.h.live_before_title_edit, new Object[] { this.kDI }), this.kDw.getTextSize()));
    this.kDw.setOnEditorActionListener((TextView.OnEditorActionListener)new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(190751);
        if (6 != paramAnonymousInt)
        {
          p.j(paramAnonymousKeyEvent, "keyEvent");
          if (paramAnonymousKeyEvent.getAction() != 66) {}
        }
        else
        {
          paramAnonymousTextView = paramRelativeLayout.getContext();
          if (paramAnonymousTextView == null)
          {
            paramAnonymousTextView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(190751);
            throw paramAnonymousTextView;
          }
          ((MMActivity)paramAnonymousTextView).hideVKB();
          k.a(this.kDK).clearFocus();
        }
        AppMethodBeat.o(190751);
        return false;
      }
    });
    this.kDx.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191210);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveBeforePlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        b.b.a(k.b(this.kDK), b.c.kyW);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveBeforePlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(191210);
      }
    });
    this.kDy.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196802);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveBeforePlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        k.b(this.kDK).statusChange(b.c.kyX, new Bundle());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveBeforePlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(196802);
      }
    });
    this.kDu.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(189036);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveBeforePlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        k.c(this.kDK);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveBeforePlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(189036);
      }
    });
    paramb = this.kDA;
    if (aPv()) {}
    for (int i = 0;; i = 8)
    {
      paramb.setVisibility(i);
      paramb = this.kDA;
      localObject = com.tencent.mm.live.core.core.model.g.kmu;
      paramb.setText((CharSequence)String.valueOf(com.tencent.mm.live.core.core.model.g.aLj().roomId));
      c.i(this.kDw).mM(0, 28).a(null);
      this.kDw.addTextChangedListener((TextWatcher)new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(196380);
          if (paramAnonymousEditable != null)
          {
            Button localButton = k.d(this.kDK);
            if (!Util.isNullOrNil((CharSequence)paramAnonymousEditable)) {}
            for (boolean bool = true;; bool = false)
            {
              localButton.setEnabled(bool);
              int i = com.tencent.mm.ui.tools.g.a(paramAnonymousEditable.toString(), g.a.XSu);
              k.e(this.kDK).setText((CharSequence)String.valueOf(28 - i));
              k.a(this.kDK).setSelection(k.a(this.kDK).getText().length());
              paramAnonymousEditable = u.kwz;
              u.aOr().Srb = k.a(this.kDK).getText().toString();
              paramAnonymousEditable = u.kwz;
              u.fn(true);
              com.tencent.mm.live.d.a.aPU();
              AppMethodBeat.o(196380);
              return;
            }
          }
          AppMethodBeat.o(196380);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.kDw.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(193885);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveBeforePlugin$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          k.a(this.kDK, k.a(this.kDK).getText().toString());
          if (Util.isNullOrNil(k.f(this.kDK))) {
            k.d(this.kDK).setEnabled(false);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveBeforePlugin$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(193885);
            return;
            k.d(this.kDK).setEnabled(true);
          }
        }
      });
      this.kDC.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(192993);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveBeforePlugin$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (n.ba((CharSequence)k.f(this.kDK)))
          {
            k.a(this.kDK).setHint((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b(paramRelativeLayout.getContext(), (CharSequence)paramRelativeLayout.getContext().getString(b.h.live_before_title_edit, new Object[] { k.g(this.kDK) }), k.a(this.kDK).getTextSize()).toString());
            k.a(this.kDK).setText(null);
            paramAnonymousView = u.kwz;
          }
          for (u.aOr().Srb = com.tencent.mm.pluginsdk.ui.span.l.b(paramRelativeLayout.getContext(), (CharSequence)paramRelativeLayout.getContext().getString(b.h.live_before_title_edit, new Object[] { k.g(this.kDK) }), k.a(this.kDK).getTextSize()).toString();; u.aOr().Srb = k.a(this.kDK).getText().toString())
          {
            paramAnonymousView = u.kwz;
            u.fn(false);
            paramAnonymousView = paramRelativeLayout.getContext();
            if (paramAnonymousView != null) {
              break;
            }
            paramAnonymousView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(192993);
            throw paramAnonymousView;
            k.a(this.kDK).setText((CharSequence)k.f(this.kDK));
            paramAnonymousView = u.kwz;
          }
          ((MMActivity)paramAnonymousView).hideVKB();
          k.a(this.kDK).clearFocus();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveBeforePlugin$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(192993);
        }
      });
      this.kDD.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(194774);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveBeforePlugin$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = paramRelativeLayout.getContext();
          if (paramAnonymousView == null)
          {
            paramAnonymousView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(194774);
            throw paramAnonymousView;
          }
          ((MMActivity)paramAnonymousView).hideVKB();
          k.a(this.kDK).clearFocus();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveBeforePlugin$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(194774);
        }
      });
      this.kDE.post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(197566);
          Object localObject;
          if (this.kDK.isLandscape())
          {
            localObject = k.h(this.kDK).getLayoutParams();
            if (localObject == null)
            {
              localObject = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
              AppMethodBeat.o(197566);
              throw ((Throwable)localObject);
            }
          }
          for (((RelativeLayout.LayoutParams)localObject).bottomMargin = (com.tencent.mm.ci.a.aY(paramRelativeLayout.getContext(), com.tencent.mm.live.b.c.Edge_10A) + com.tencent.mm.ci.a.aY(paramRelativeLayout.getContext(), com.tencent.mm.live.b.c.live_before_content_start_btn_margin_bottom) + k.i(this.kDK).getHeight());; ((RelativeLayout.LayoutParams)localObject).bottomMargin = (com.tencent.mm.ci.a.aY(paramRelativeLayout.getContext(), com.tencent.mm.live.b.c.Edge_10A) + com.tencent.mm.ci.a.aY(paramRelativeLayout.getContext(), com.tencent.mm.live.b.c.Edge_12A) + k.i(this.kDK).getHeight() + ax.aB(paramRelativeLayout.getContext())))
          {
            k.h(this.kDK).requestLayout();
            AppMethodBeat.o(197566);
            return;
            localObject = k.j(this.kDK).getLayoutParams();
            if (localObject != null)
            {
              if (localObject == null)
              {
                localObject = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(197566);
                throw ((Throwable)localObject);
              }
              localObject = (ViewGroup.MarginLayoutParams)localObject;
              ((ViewGroup.MarginLayoutParams)localObject).bottomMargin += ax.aB(paramRelativeLayout.getContext());
              k.j(this.kDK).requestLayout();
            }
            localObject = k.i(this.kDK).getLayoutParams();
            if (localObject != null)
            {
              if (localObject == null)
              {
                localObject = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(197566);
                throw ((Throwable)localObject);
              }
              localObject = (ViewGroup.MarginLayoutParams)localObject;
              ((ViewGroup.MarginLayoutParams)localObject).bottomMargin += ax.aB(paramRelativeLayout.getContext());
              k.i(this.kDK).requestLayout();
            }
            localObject = k.h(this.kDK).getLayoutParams();
            if (localObject == null)
            {
              localObject = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
              AppMethodBeat.o(197566);
              throw ((Throwable)localObject);
            }
          }
        }
      });
      if ((!isLandscape()) || (this.kDz.getLayoutParams() == null) || (this.kDF.getLayoutParams() == null)) {
        break label828;
      }
      paramb = this.kDz.getLayoutParams();
      if (paramb != null) {
        break;
      }
      paramRelativeLayout = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(198532);
      throw paramRelativeLayout;
    }
    ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(ax.aB(paramRelativeLayout.getContext()));
    paramb = this.kDF.getLayoutParams();
    if (paramb == null)
    {
      paramRelativeLayout = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(198532);
      throw paramRelativeLayout;
    }
    ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(ax.aB(paramRelativeLayout.getContext()));
    this.kDz.requestLayout();
    this.kDF.requestLayout();
    try
    {
      label828:
      paramRelativeLayout = paramRelativeLayout.getContext();
      p.j(paramRelativeLayout, "root.context");
      paramRelativeLayout = paramRelativeLayout.getResources().getString(b.h.live_provider_tip);
      p.j(paramRelativeLayout, "root.context.resources.g…string.live_provider_tip)");
      paramRelativeLayout = new i(((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vYE, "{\"simple_chinese\":\"" + paramRelativeLayout + "\",\"xg_traditional_chinese\":\"" + paramRelativeLayout + "\",\"tw_traditional_chinese\":\"" + paramRelativeLayout + "\",\"english\":\"" + paramRelativeLayout + "\"}"));
      paramb = LocaleUtil.getApplicationLanguage();
      if (p.h("zh_CN", paramb)) {
        paramRelativeLayout = paramRelativeLayout.getString("simple_chinese");
      }
      while (!Util.isNullOrNil(paramRelativeLayout))
      {
        this.kDv.setText((CharSequence)paramRelativeLayout);
        AppMethodBeat.o(198532);
        return;
        if (p.h("zh_TW", paramb)) {
          paramRelativeLayout = paramRelativeLayout.getString("xg_traditional_chinese");
        } else if (p.h("zh_HK", paramb)) {
          paramRelativeLayout = paramRelativeLayout.getString("tw_traditional_chinese");
        } else {
          paramRelativeLayout = paramRelativeLayout.getString("english");
        }
      }
      return;
    }
    catch (Exception paramRelativeLayout)
    {
      Log.w(this.TAG, "Exception: " + paramRelativeLayout.getMessage());
      AppMethodBeat.o(198532);
    }
  }
  
  private static boolean aPv()
  {
    AppMethodBeat.i(198476);
    f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    if (localf.aHp().getInt(ar.a.VCy, 0) == 1)
    {
      AppMethodBeat.o(198476);
      return true;
    }
    AppMethodBeat.o(198476);
    return false;
  }
  
  public final void keyboardChange(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(198488);
    if (paramBoolean)
    {
      this.kDG.setVisibility(8);
      this.kDz.setVisibility(8);
      this.kDu.setVisibility(8);
      if (isLandscape()) {}
      for (paramInt = ax.au(this.kiF.getContext()).y - paramInt - com.tencent.mm.ci.a.aY(this.kiF.getContext(), com.tencent.mm.live.b.c.Edge_2A);; paramInt = ax.au(this.kiF.getContext()).y - paramInt - ax.aB(this.kiF.getContext()) - com.tencent.mm.ci.a.aY(this.kiF.getContext(), com.tencent.mm.live.b.c.Edge_2A))
      {
        Object localObject1 = new int[2];
        this.kDE.getLocationOnScreen((int[])localObject1);
        int i = localObject1[1];
        int j = this.kDE.getHeight();
        this.kDE.animate().translationY(paramInt - (i + j)).start();
        localObject1 = this.kDw;
        Object localObject2 = this.kiF.getContext();
        p.j(localObject2, "root.context");
        ((EditText)localObject1).setBackground(((Context)localObject2).getResources().getDrawable(com.tencent.mm.live.b.b.transparent));
        this.kDw.setPadding(0, 0, 0, 0);
        this.kDw.setHint((CharSequence)" ");
        this.kDw.setCursorVisible(true);
        this.kDB.setVisibility(0);
        localObject1 = this.kDw.getText();
        if (localObject1 != null)
        {
          localObject2 = localObject1.toString();
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        paramInt = com.tencent.mm.ui.tools.g.a((String)localObject1, g.a.XSu);
        this.kDB.setText((CharSequence)String.valueOf(28 - paramInt));
        this.kDC.setVisibility(0);
        this.kDD.setVisibility(0);
        AppMethodBeat.o(198488);
        return;
      }
    }
    this.kDG.setVisibility(0);
    this.kDz.setVisibility(0);
    this.kDu.setVisibility(0);
    this.kDE.animate().translationY(0.0F).start();
    this.kDw.setBackground(this.kDJ);
    com.tencent.mm.ci.a.aY(this.kiF.getContext(), com.tencent.mm.live.b.c.Edge_4A);
    paramInt = com.tencent.mm.ci.a.aY(this.kiF.getContext(), com.tencent.mm.live.b.c.Edge_A);
    this.kDw.setPadding(0, 0, 0, paramInt);
    this.kDw.setHint((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b(this.kiF.getContext(), (CharSequence)this.kiF.getContext().getString(b.h.live_before_title_edit, new Object[] { this.kDI }), this.kDw.getTextSize()));
    this.kDw.setCursorVisible(false);
    this.kDB.setVisibility(8);
    this.kDC.setVisibility(8);
    this.kDD.setVisibility(8);
    AppMethodBeat.o(198488);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(198503);
    if (this.kiF.getVisibility() == 0)
    {
      b.b.a(this.kCL, b.c.kyW);
      AppMethodBeat.o(198503);
      return true;
    }
    AppMethodBeat.o(198503);
    return false;
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(198500);
    p.k(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (l.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(198500);
      return;
      tU(8);
      AppMethodBeat.o(198500);
      return;
      if (paramBundle != null)
      {
        paramc = Integer.valueOf(paramBundle.getInt("PARAM_FACE_VERIFY_ERROR", -1));
        if ((paramc != null) && (paramc.intValue() != -1)) {
          new f.a(this.kiF.getContext()).icD().bBl(this.kiF.getContext().getString(paramc.intValue())).bBp(this.kiF.getContext().getString(b.h.app_i_know)).b((f.c)a.kDL).show();
        }
        paramc = u.kwz;
        paramBundle = u.aOr();
        paramc = (CharSequence)this.kDw.getText();
        if ((paramc != null) && (!n.ba(paramc))) {
          break label288;
        }
        i = 1;
        label206:
        if (i == 0) {
          break label293;
        }
      }
      label288:
      label293:
      for (paramc = com.tencent.mm.pluginsdk.ui.span.l.b(this.kiF.getContext(), (CharSequence)this.kiF.getContext().getString(b.h.live_before_title_edit, new Object[] { this.kDI }), this.kDw.getTextSize()).toString();; paramc = this.kDw.getText().toString())
      {
        paramBundle.Srb = paramc;
        paramc = u.kwz;
        u.fq(false);
        tU(0);
        AppMethodBeat.o(198500);
        return;
        paramc = null;
        break;
        i = 0;
        break label206;
      }
      paramc = u.kwz;
      if (u.aOL()) {}
      for (int i = 3;; i = 2)
      {
        paramc = u.kwz;
        paramc = u.aOm();
        paramBundle = u.kwz;
        boolean bool1 = u.aOI();
        paramBundle = u.kwz;
        boolean bool2 = u.aOJ();
        paramBundle = u.kwz;
        paramBundle = u.aOr().Srb;
        Object localObject = u.kwz;
        boolean bool3 = u.aOH();
        localObject = this.kiF.getResources();
        p.j(localObject, "root.resources");
        e.a(paramc, bool1, bool2, paramBundle, bool3, ((Resources)localObject).getConfiguration().orientation, i);
        com.tencent.mm.live.d.a.aPT();
        paramc = u.kwz;
        u.fq(false);
        AppMethodBeat.o(198500);
        return;
      }
      com.tencent.mm.live.d.a.aPS();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class a
    implements f.c
  {
    public static final a kDL;
    
    static
    {
      AppMethodBeat.i(197464);
      kDL = new a();
      AppMethodBeat.o(197464);
    }
    
    public final void g(boolean paramBoolean, String paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.k
 * JD-Core Version:    0.7.0.1
 */