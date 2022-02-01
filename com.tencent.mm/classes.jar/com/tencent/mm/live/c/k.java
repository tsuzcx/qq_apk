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
import com.tencent.mm.ab.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.b.x;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/plugin/LiveBeforePlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/widget/RelativeLayout;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "closeBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "hostString", "liveEditTopGroup", "liveRoomIdEdit", "Landroid/widget/EditText;", "liveTitleEdit", "liveTitleEditCancel", "Landroid/widget/TextView;", "liveTitleEditGroup", "liveTitleEditOk", "Landroid/widget/Button;", "liveTitleEditTextNumHint", "liveTitleTv", "mTopicName", "providerTip", "rootLayout", "startLiveBtn", "switchBtn", "titleEditBackground", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "topGroup", "Landroid/view/ViewGroup;", "checkLiveName", "", "liveName", "createLive", "", "enableTestRoomId", "keyboardChange", "show", "height", "", "onBackPress", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class k
  extends a
{
  private final String TAG;
  private final RelativeLayout hOX;
  final Button hOY;
  final TextView hOZ;
  final b hOp;
  final EditText hPa;
  private final WeImageView hPb;
  private final WeImageView hPc;
  private final ViewGroup hPd;
  final EditText hPe;
  final TextView hPf;
  private final TextView hPg;
  final Button hPh;
  final RelativeLayout hPi;
  private final RelativeLayout hPj;
  private final TextView hPk;
  String hPl;
  String hPm;
  private Drawable hPn;
  
  public k(final RelativeLayout paramRelativeLayout, b paramb)
  {
    super((ViewGroup)paramRelativeLayout, paramb);
    AppMethodBeat.i(207947);
    this.hOp = paramb;
    this.TAG = "MicroMsg.LiveBeforePlugin";
    paramb = paramRelativeLayout.findViewById(2131303355);
    p.g(paramb, "root.findViewById(R.id.live_before_ui_root)");
    this.hOX = ((RelativeLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131303346);
    p.g(paramb, "root.findViewById(R.id.l…before_content_start_btn)");
    this.hOY = ((Button)paramb);
    paramb = paramRelativeLayout.findViewById(2131303350);
    p.g(paramb, "root.findViewById(R.id.live_before_provider_tip)");
    this.hOZ = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131303347);
    p.g(paramb, "root.findViewById(R.id.l…efore_content_title_edit)");
    this.hPa = ((EditText)paramb);
    paramb = paramRelativeLayout.findViewById(2131303352);
    p.g(paramb, "root.findViewById(R.id.live_before_top_close)");
    this.hPb = ((WeImageView)paramb);
    paramb = paramRelativeLayout.findViewById(2131303354);
    p.g(paramb, "root.findViewById(R.id.live_before_top_switch)");
    this.hPc = ((WeImageView)paramb);
    paramb = paramRelativeLayout.findViewById(2131303353);
    p.g(paramb, "root.findViewById(R.id.live_before_top_group)");
    this.hPd = ((ViewGroup)paramb);
    paramb = paramRelativeLayout.findViewById(2131303345);
    p.g(paramb, "root.findViewById(R.id.l…fore_content_roomid_edit)");
    this.hPe = ((EditText)paramb);
    paramb = paramRelativeLayout.findViewById(2131309218);
    p.g(paramb, "root.findViewById(R.id.title_edit_text_num_hint)");
    this.hPf = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131303589);
    p.g(paramb, "root.findViewById(R.id.live_title_edit_cancel)");
    this.hPg = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131303590);
    p.g(paramb, "root.findViewById(R.id.live_title_edit_ok)");
    this.hPh = ((Button)paramb);
    paramb = paramRelativeLayout.findViewById(2131303348);
    p.g(paramb, "root.findViewById(R.id.l…content_title_edit_group)");
    this.hPi = ((RelativeLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131303349);
    p.g(paramb, "root.findViewById(R.id.live_before_edit_top_group)");
    this.hPj = ((RelativeLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131303351);
    p.g(paramb, "root.findViewById(R.id.live_before_title)");
    this.hPk = ((TextView)paramb);
    this.hPl = "";
    this.hPm = "";
    this.hPn = this.hPa.getBackground();
    this.hOX.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(207931);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveBeforePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (!Util.isNullOrNil(this.hPo.hPa.getText().toString()))
        {
          paramAnonymousView = paramRelativeLayout.getContext();
          if (paramAnonymousView == null)
          {
            paramAnonymousView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(207931);
            throw paramAnonymousView;
          }
          ((MMActivity)paramAnonymousView).hideVKB();
          this.hPo.hPa.clearFocus();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveBeforePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(207931);
      }
    });
    paramb = z.aUL();
    Object localObject;
    if (paramb != null)
    {
      localObject = paramb.arJ();
      paramb = (b)localObject;
      if (localObject != null) {}
    }
    else
    {
      paramb = "";
    }
    this.hPm = paramb;
    this.hPa.setHint((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b(paramRelativeLayout.getContext(), (CharSequence)paramRelativeLayout.getContext().getString(2131762261, new Object[] { this.hPm }), this.hPa.getTextSize()));
    this.hPa.setOnEditorActionListener((TextView.OnEditorActionListener)new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(207933);
        if (6 != paramAnonymousInt)
        {
          p.g(paramAnonymousKeyEvent, "keyEvent");
          if (paramAnonymousKeyEvent.getAction() != 66) {}
        }
        else
        {
          paramAnonymousTextView = paramRelativeLayout.getContext();
          if (paramAnonymousTextView == null)
          {
            paramAnonymousTextView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(207933);
            throw paramAnonymousTextView;
          }
          ((MMActivity)paramAnonymousTextView).hideVKB();
          this.hPo.hPa.clearFocus();
        }
        AppMethodBeat.o(207933);
        return false;
      }
    });
    this.hPb.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(207934);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveBeforePlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        b.b.a(this.hPo.hOp, b.c.hLD);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveBeforePlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(207934);
      }
    });
    this.hPc.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(207935);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveBeforePlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        this.hPo.hOp.statusChange(b.c.hLE, new Bundle());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveBeforePlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(207935);
      }
    });
    this.hOY.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(207936);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveBeforePlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        localObject = this.hPo;
        paramAnonymousView = (CharSequence)((k)localObject).hPa.getText();
        if ((paramAnonymousView == null) || (n.aL(paramAnonymousView)))
        {
          i = 1;
          if (i == 0) {
            break label208;
          }
          paramAnonymousView = "";
          label70:
          if (!k.aHv()) {
            break label222;
          }
        }
        label208:
        label222:
        for (int i = Integer.parseInt(((k)localObject).hPe.getText().toString());; i = -1)
        {
          Bundle localBundle = new Bundle();
          localBundle.putInt("PARAM_LIVE_TEST_ROOM_ID", i);
          localBundle.putString("PARAM_START_LIVE_TITLE", paramAnonymousView);
          paramAnonymousView = x.hJf;
          x.aGr().MnO = com.tencent.mm.pluginsdk.ui.span.l.b(((a)localObject).hwr.getContext(), (CharSequence)((a)localObject).hwr.getContext().getString(2131762261, new Object[] { ((k)localObject).hPm }), ((k)localObject).hPa.getTextSize()).toString();
          ((k)localObject).hOp.statusChange(b.c.hMx, localBundle);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveBeforePlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(207936);
          return;
          i = 0;
          break;
          paramAnonymousView = ((k)localObject).hPa.getText().toString();
          break label70;
        }
      }
    });
    paramb = this.hPe;
    if (aHv()) {}
    for (int i = 0;; i = 8)
    {
      paramb.setVisibility(i);
      paramb = this.hPe;
      localObject = com.tencent.mm.live.core.core.b.f.hzy;
      paramb.setText((CharSequence)String.valueOf(com.tencent.mm.live.core.core.b.f.aDq().roomId));
      c.f(this.hPa).lv(0, 28).a(null);
      this.hPa.addTextChangedListener((TextWatcher)new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(207937);
          if (paramAnonymousEditable != null)
          {
            Button localButton = this.hPo.hPh;
            if (!Util.isNullOrNil((CharSequence)paramAnonymousEditable)) {}
            for (boolean bool = true;; bool = false)
            {
              localButton.setEnabled(bool);
              int i = com.tencent.mm.ui.tools.f.a(paramAnonymousEditable.toString(), com.tencent.mm.ui.tools.f.a.Qui);
              this.hPo.hPf.setText((CharSequence)String.valueOf(28 - i));
              this.hPo.hPa.setSelection(this.hPo.hPa.getText().length());
              paramAnonymousEditable = x.hJf;
              x.aGr().LpF = this.hPo.hPa.getText().toString();
              paramAnonymousEditable = x.hJf;
              x.eH(true);
              com.tencent.mm.live.d.a.aHW();
              AppMethodBeat.o(207937);
              return;
            }
          }
          AppMethodBeat.o(207937);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.hPa.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(207938);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveBeforePlugin$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          this.hPo.hPl = this.hPo.hPa.getText().toString();
          if (Util.isNullOrNil(this.hPo.hPl)) {
            this.hPo.hPh.setEnabled(false);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveBeforePlugin$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(207938);
            return;
            this.hPo.hPh.setEnabled(true);
          }
        }
      });
      this.hPg.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(207939);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveBeforePlugin$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (n.aL((CharSequence)this.hPo.hPl))
          {
            this.hPo.hPa.setHint((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b(paramRelativeLayout.getContext(), (CharSequence)paramRelativeLayout.getContext().getString(2131762261, new Object[] { this.hPo.hPm }), this.hPo.hPa.getTextSize()).toString());
            this.hPo.hPa.setText(null);
            paramAnonymousView = x.hJf;
          }
          for (x.aGr().LpF = com.tencent.mm.pluginsdk.ui.span.l.b(paramRelativeLayout.getContext(), (CharSequence)paramRelativeLayout.getContext().getString(2131762261, new Object[] { this.hPo.hPm }), this.hPo.hPa.getTextSize()).toString();; x.aGr().LpF = this.hPo.hPa.getText().toString())
          {
            paramAnonymousView = x.hJf;
            x.eH(false);
            paramAnonymousView = paramRelativeLayout.getContext();
            if (paramAnonymousView != null) {
              break;
            }
            paramAnonymousView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(207939);
            throw paramAnonymousView;
            this.hPo.hPa.setText((CharSequence)this.hPo.hPl);
            paramAnonymousView = x.hJf;
          }
          ((MMActivity)paramAnonymousView).hideVKB();
          this.hPo.hPa.clearFocus();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveBeforePlugin$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(207939);
        }
      });
      this.hPh.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(207940);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveBeforePlugin$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = paramRelativeLayout.getContext();
          if (paramAnonymousView == null)
          {
            paramAnonymousView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(207940);
            throw paramAnonymousView;
          }
          ((MMActivity)paramAnonymousView).hideVKB();
          this.hPo.hPa.clearFocus();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveBeforePlugin$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(207940);
        }
      });
      this.hPi.post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(207932);
          Object localObject;
          if (this.hPo.isLandscape())
          {
            localObject = this.hPo.hPi.getLayoutParams();
            if (localObject == null)
            {
              localObject = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
              AppMethodBeat.o(207932);
              throw ((Throwable)localObject);
            }
          }
          for (((RelativeLayout.LayoutParams)localObject).bottomMargin = (com.tencent.mm.cb.a.aG(paramRelativeLayout.getContext(), 2131165278) + com.tencent.mm.cb.a.aG(paramRelativeLayout.getContext(), 2131166577) + this.hPo.hOY.getHeight());; ((RelativeLayout.LayoutParams)localObject).bottomMargin = (com.tencent.mm.cb.a.aG(paramRelativeLayout.getContext(), 2131165278) + com.tencent.mm.cb.a.aG(paramRelativeLayout.getContext(), 2131165281) + this.hPo.hOY.getHeight() + au.aD(paramRelativeLayout.getContext())))
          {
            this.hPo.hPi.requestLayout();
            AppMethodBeat.o(207932);
            return;
            localObject = this.hPo.hOZ.getLayoutParams();
            if (localObject != null)
            {
              if (localObject == null)
              {
                localObject = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(207932);
                throw ((Throwable)localObject);
              }
              localObject = (ViewGroup.MarginLayoutParams)localObject;
              ((ViewGroup.MarginLayoutParams)localObject).bottomMargin += au.aD(paramRelativeLayout.getContext());
              this.hPo.hOZ.requestLayout();
            }
            localObject = this.hPo.hOY.getLayoutParams();
            if (localObject != null)
            {
              if (localObject == null)
              {
                localObject = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(207932);
                throw ((Throwable)localObject);
              }
              localObject = (ViewGroup.MarginLayoutParams)localObject;
              ((ViewGroup.MarginLayoutParams)localObject).bottomMargin += au.aD(paramRelativeLayout.getContext());
              this.hPo.hOY.requestLayout();
            }
            localObject = this.hPo.hPi.getLayoutParams();
            if (localObject == null)
            {
              localObject = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
              AppMethodBeat.o(207932);
              throw ((Throwable)localObject);
            }
          }
        }
      });
      if ((!isLandscape()) || (this.hPd.getLayoutParams() == null) || (this.hPj.getLayoutParams() == null)) {
        break label813;
      }
      paramb = this.hPd.getLayoutParams();
      if (paramb != null) {
        break;
      }
      paramRelativeLayout = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(207947);
      throw paramRelativeLayout;
    }
    ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(au.aD(paramRelativeLayout.getContext()));
    paramb = this.hPj.getLayoutParams();
    if (paramb == null)
    {
      paramRelativeLayout = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(207947);
      throw paramRelativeLayout;
    }
    ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(au.aD(paramRelativeLayout.getContext()));
    this.hPd.requestLayout();
    this.hPj.requestLayout();
    try
    {
      label813:
      paramRelativeLayout = paramRelativeLayout.getContext();
      p.g(paramRelativeLayout, "root.context");
      paramRelativeLayout = paramRelativeLayout.getResources().getString(2131762357);
      p.g(paramRelativeLayout, "root.context.resources.g…string.live_provider_tip)");
      paramRelativeLayout = new i(((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sns, "{\"simple_chinese\":\"" + paramRelativeLayout + "\",\"xg_traditional_chinese\":\"" + paramRelativeLayout + "\",\"tw_traditional_chinese\":\"" + paramRelativeLayout + "\",\"english\":\"" + paramRelativeLayout + "\"}"));
      paramb = LocaleUtil.getApplicationLanguage();
      if (p.j("zh_CN", paramb)) {
        paramRelativeLayout = paramRelativeLayout.getString("simple_chinese");
      }
      while (!Util.isNullOrNil(paramRelativeLayout))
      {
        this.hOZ.setText((CharSequence)paramRelativeLayout);
        AppMethodBeat.o(207947);
        return;
        if (p.j("zh_TW", paramb)) {
          paramRelativeLayout = paramRelativeLayout.getString("xg_traditional_chinese");
        } else if (p.j("zh_HK", paramb)) {
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
      AppMethodBeat.o(207947);
    }
  }
  
  static boolean aHv()
  {
    AppMethodBeat.i(207943);
    com.tencent.mm.kernel.e locale = g.aAh();
    p.g(locale, "MMKernel.storage()");
    if (locale.azQ().getInt(ar.a.Onm, 0) == 1)
    {
      AppMethodBeat.o(207943);
      return true;
    }
    AppMethodBeat.o(207943);
    return false;
  }
  
  public final void keyboardChange(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(207944);
    if (paramBoolean)
    {
      this.hPk.setVisibility(8);
      this.hPd.setVisibility(8);
      this.hOY.setVisibility(8);
      if (isLandscape()) {}
      for (paramInt = au.az(this.hwr.getContext()).y - paramInt - com.tencent.mm.cb.a.aG(this.hwr.getContext(), 2131165296);; paramInt = au.az(this.hwr.getContext()).y - paramInt - au.aD(this.hwr.getContext()) - com.tencent.mm.cb.a.aG(this.hwr.getContext(), 2131165296))
      {
        Object localObject1 = new int[2];
        this.hPi.getLocationOnScreen((int[])localObject1);
        int i = localObject1[1];
        int j = this.hPi.getHeight();
        this.hPi.animate().translationY(paramInt - (i + j)).start();
        localObject1 = this.hPa;
        Object localObject2 = this.hwr.getContext();
        p.g(localObject2, "root.context");
        ((EditText)localObject1).setBackground(((Context)localObject2).getResources().getDrawable(2131101287));
        this.hPa.setPadding(0, 0, 0, 0);
        this.hPa.setHint((CharSequence)" ");
        this.hPa.setCursorVisible(true);
        this.hPf.setVisibility(0);
        localObject1 = this.hPa.getText();
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
        paramInt = com.tencent.mm.ui.tools.f.a((String)localObject1, com.tencent.mm.ui.tools.f.a.Qui);
        this.hPf.setText((CharSequence)String.valueOf(28 - paramInt));
        this.hPg.setVisibility(0);
        this.hPh.setVisibility(0);
        AppMethodBeat.o(207944);
        return;
      }
    }
    this.hPk.setVisibility(0);
    this.hPd.setVisibility(0);
    this.hOY.setVisibility(0);
    this.hPi.animate().translationY(0.0F).start();
    this.hPa.setBackground(this.hPn);
    com.tencent.mm.cb.a.aG(this.hwr.getContext(), 2131165303);
    paramInt = com.tencent.mm.cb.a.aG(this.hwr.getContext(), 2131165314);
    this.hPa.setPadding(0, 0, 0, paramInt);
    this.hPa.setHint((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b(this.hwr.getContext(), (CharSequence)this.hwr.getContext().getString(2131762261, new Object[] { this.hPm }), this.hPa.getTextSize()));
    this.hPa.setCursorVisible(false);
    this.hPf.setVisibility(8);
    this.hPg.setVisibility(8);
    this.hPh.setVisibility(8);
    AppMethodBeat.o(207944);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(207946);
    if (this.hwr.getVisibility() == 0)
    {
      b.b.a(this.hOp, b.c.hLD);
      AppMethodBeat.o(207946);
      return true;
    }
    AppMethodBeat.o(207946);
    return false;
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(207945);
    p.h(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (l.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(207945);
      return;
      rg(8);
      AppMethodBeat.o(207945);
      return;
      if (paramBundle != null)
      {
        paramc = Integer.valueOf(paramBundle.getInt("PARAM_FACE_VERIFY_ERROR", -1));
        if ((paramc != null) && (paramc.intValue() != -1)) {
          new com.tencent.mm.ui.widget.a.f.a(this.hwr.getContext()).hbu().bow(this.hwr.getContext().getString(paramc.intValue())).boA(this.hwr.getContext().getString(2131755873)).b((f.c)a.hPp).show();
        }
        paramc = x.hJf;
        paramBundle = x.aGr();
        paramc = (CharSequence)this.hPa.getText();
        if ((paramc != null) && (!n.aL(paramc))) {
          break label287;
        }
        i = 1;
        label206:
        if (i == 0) {
          break label292;
        }
      }
      label287:
      label292:
      for (paramc = com.tencent.mm.pluginsdk.ui.span.l.b(this.hwr.getContext(), (CharSequence)this.hwr.getContext().getString(2131762261, new Object[] { this.hPm }), this.hPa.getTextSize()).toString();; paramc = this.hPa.getText().toString())
      {
        paramBundle.LpF = paramc;
        paramc = x.hJf;
        x.eK(false);
        rg(0);
        AppMethodBeat.o(207945);
        return;
        paramc = null;
        break;
        i = 0;
        break label206;
      }
      paramc = x.hJf;
      if (x.aGL()) {}
      for (int i = 3;; i = 2)
      {
        paramc = x.hJf;
        paramc = x.aGm();
        paramBundle = x.hJf;
        boolean bool1 = x.aGI();
        paramBundle = x.hJf;
        boolean bool2 = x.aGJ();
        paramBundle = x.hJf;
        paramBundle = x.aGr().LpF;
        Object localObject = x.hJf;
        boolean bool3 = x.aGH();
        localObject = this.hwr.getResources();
        p.g(localObject, "root.resources");
        com.tencent.mm.live.d.e.a(paramc, bool1, bool2, paramBundle, bool3, ((Resources)localObject).getConfiguration().orientation, i);
        com.tencent.mm.live.d.a.aHV();
        paramc = x.hJf;
        x.eK(false);
        AppMethodBeat.o(207945);
        return;
      }
      com.tencent.mm.live.d.a.aHU();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class a
    implements f.c
  {
    public static final a hPp;
    
    static
    {
      AppMethodBeat.i(207942);
      hPp = new a();
      AppMethodBeat.o(207942);
    }
    
    public final void e(boolean paramBoolean, String paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.c.k
 * JD-Core Version:    0.7.0.1
 */