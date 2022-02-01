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
import com.tencent.mm.live.core.core.b.d;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import d.g.b.p;
import d.l;
import d.n.n;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/plugin/LiveBeforePlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/widget/RelativeLayout;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "closeBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "hostString", "liveEditTopGroup", "liveRoomIdEdit", "Landroid/widget/EditText;", "liveTitleEdit", "liveTitleEditCancel", "Landroid/widget/TextView;", "liveTitleEditGroup", "liveTitleEditOk", "Landroid/widget/Button;", "liveTitleEditTextNumHint", "liveTitleTv", "mTopicName", "providerTip", "rootLayout", "startLiveBtn", "switchBtn", "titleEditBackground", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "topGroup", "Landroid/view/ViewGroup;", "checkLiveName", "", "liveName", "createLive", "", "enableTestRoomId", "keyboardChange", "show", "height", "", "onBackPress", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class k
  extends a
{
  private final String TAG;
  final b gVv;
  private final RelativeLayout gWd;
  final Button gWe;
  final TextView gWf;
  final EditText gWg;
  private final WeImageView gWh;
  private final WeImageView gWi;
  private final ViewGroup gWj;
  final EditText gWk;
  final TextView gWl;
  private final TextView gWm;
  final Button gWn;
  final RelativeLayout gWo;
  private final RelativeLayout gWp;
  private final TextView gWq;
  String gWr;
  String gWs;
  private Drawable gWt;
  
  public k(final RelativeLayout paramRelativeLayout, b paramb)
  {
    super((ViewGroup)paramRelativeLayout, paramb);
    AppMethodBeat.i(215985);
    this.gVv = paramb;
    this.TAG = "MicroMsg.LiveBeforePlugin";
    paramb = paramRelativeLayout.findViewById(2131307594);
    p.g(paramb, "root.findViewById(R.id.live_before_ui_root)");
    this.gWd = ((RelativeLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131307586);
    p.g(paramb, "root.findViewById(R.id.l…before_content_start_btn)");
    this.gWe = ((Button)paramb);
    paramb = paramRelativeLayout.findViewById(2131307284);
    p.g(paramb, "root.findViewById(R.id.live_before_provider_tip)");
    this.gWf = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307587);
    p.g(paramb, "root.findViewById(R.id.l…efore_content_title_edit)");
    this.gWg = ((EditText)paramb);
    paramb = paramRelativeLayout.findViewById(2131307591);
    p.g(paramb, "root.findViewById(R.id.live_before_top_close)");
    this.gWh = ((WeImageView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307593);
    p.g(paramb, "root.findViewById(R.id.live_before_top_switch)");
    this.gWi = ((WeImageView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307592);
    p.g(paramb, "root.findViewById(R.id.live_before_top_group)");
    this.gWj = ((ViewGroup)paramb);
    paramb = paramRelativeLayout.findViewById(2131307585);
    p.g(paramb, "root.findViewById(R.id.l…fore_content_roomid_edit)");
    this.gWk = ((EditText)paramb);
    paramb = paramRelativeLayout.findViewById(2131308036);
    p.g(paramb, "root.findViewById(R.id.title_edit_text_num_hint)");
    this.gWl = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307802);
    p.g(paramb, "root.findViewById(R.id.live_title_edit_cancel)");
    this.gWm = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307803);
    p.g(paramb, "root.findViewById(R.id.live_title_edit_ok)");
    this.gWn = ((Button)paramb);
    paramb = paramRelativeLayout.findViewById(2131307588);
    p.g(paramb, "root.findViewById(R.id.l…content_title_edit_group)");
    this.gWo = ((RelativeLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131307589);
    p.g(paramb, "root.findViewById(R.id.live_before_edit_top_group)");
    this.gWp = ((RelativeLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131307590);
    p.g(paramb, "root.findViewById(R.id.live_before_title)");
    this.gWq = ((TextView)paramb);
    this.gWr = "";
    this.gWs = "";
    this.gWt = this.gWg.getBackground();
    this.gWd.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(215969);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveBeforePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (!bu.isNullOrNil(this.gWu.gWg.getText().toString()))
        {
          paramAnonymousView = paramRelativeLayout.getContext();
          if (paramAnonymousView == null)
          {
            paramAnonymousView = new d.v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(215969);
            throw paramAnonymousView;
          }
          ((MMActivity)paramAnonymousView).hideVKB();
          this.gWu.gWg.clearFocus();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveBeforePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(215969);
      }
    });
    paramb = com.tencent.mm.model.v.aBo();
    Object localObject;
    if (paramb != null)
    {
      localObject = paramb.adG();
      paramb = (b)localObject;
      if (localObject != null) {}
    }
    else
    {
      paramb = "";
    }
    this.gWs = paramb;
    this.gWg.setHint((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.b(paramRelativeLayout.getContext(), (CharSequence)paramRelativeLayout.getContext().getString(2131766574, new Object[] { this.gWs }), this.gWg.getTextSize()));
    this.gWg.setOnEditorActionListener((TextView.OnEditorActionListener)new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(215971);
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
            paramAnonymousTextView = new d.v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(215971);
            throw paramAnonymousTextView;
          }
          ((MMActivity)paramAnonymousTextView).hideVKB();
          this.gWu.gWg.clearFocus();
        }
        AppMethodBeat.o(215971);
        return false;
      }
    });
    this.gWh.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(215972);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveBeforePlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        b.b.a(this.gWu.gVv, b.c.gUe);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveBeforePlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(215972);
      }
    });
    this.gWi.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(215973);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveBeforePlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        this.gWu.gVv.a(b.c.gUf, new Bundle());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveBeforePlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(215973);
      }
    });
    this.gWe.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(215974);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveBeforePlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        localObject = this.gWu;
        paramAnonymousView = (CharSequence)((k)localObject).gWg.getText();
        if ((paramAnonymousView == null) || (n.aD(paramAnonymousView)))
        {
          i = 1;
          if (i == 0) {
            break label208;
          }
          paramAnonymousView = "";
          label70:
          if (!k.aoW()) {
            break label222;
          }
        }
        label208:
        label222:
        for (int i = Integer.parseInt(((k)localObject).gWk.getText().toString());; i = -1)
        {
          Bundle localBundle = new Bundle();
          localBundle.putInt("PARAM_LIVE_TEST_ROOM_ID", i);
          localBundle.putString("PARAM_START_LIVE_TITLE", paramAnonymousView);
          paramAnonymousView = com.tencent.mm.live.b.g.gQZ;
          com.tencent.mm.live.b.g.anH().Hil = com.tencent.mm.pluginsdk.ui.span.k.b(((a)localObject).gJt.getContext(), (CharSequence)((a)localObject).gJt.getContext().getString(2131766574, new Object[] { ((k)localObject).gWs }), ((k)localObject).gWg.getTextSize()).toString();
          ((k)localObject).gVv.a(b.c.gUX, localBundle);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveBeforePlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(215974);
          return;
          i = 0;
          break;
          paramAnonymousView = ((k)localObject).gWg.getText().toString();
          break label70;
        }
      }
    });
    paramb = this.gWk;
    if (aoW()) {}
    for (int i = 0;; i = 8)
    {
      paramb.setVisibility(i);
      paramb = this.gWk;
      localObject = d.gKq;
      paramb.setText((CharSequence)String.valueOf(d.alP().roomId));
      c.d(this.gWg).kj(0, 28).a(null);
      this.gWg.addTextChangedListener((TextWatcher)new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(215975);
          if (paramAnonymousEditable != null)
          {
            Button localButton = this.gWu.gWn;
            if (!bu.ah((CharSequence)paramAnonymousEditable)) {}
            for (boolean bool = true;; bool = false)
            {
              localButton.setEnabled(bool);
              int i = f.a(paramAnonymousEditable.toString(), com.tencent.mm.ui.tools.f.a.Lfh);
              this.gWu.gWl.setText((CharSequence)String.valueOf(28 - i));
              this.gWu.gWg.setSelection(this.gWu.gWg.getText().length());
              paramAnonymousEditable = com.tencent.mm.live.b.g.gQZ;
              com.tencent.mm.live.b.g.anH().Gud = this.gWu.gWg.getText().toString();
              paramAnonymousEditable = com.tencent.mm.live.b.g.gQZ;
              com.tencent.mm.live.b.g.dL(true);
              com.tencent.mm.live.d.a.apx();
              AppMethodBeat.o(215975);
              return;
            }
          }
          AppMethodBeat.o(215975);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.gWg.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(215976);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveBeforePlugin$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          this.gWu.gWr = this.gWu.gWg.getText().toString();
          if (bu.isNullOrNil(this.gWu.gWr)) {
            this.gWu.gWn.setEnabled(false);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveBeforePlugin$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(215976);
            return;
            this.gWu.gWn.setEnabled(true);
          }
        }
      });
      this.gWm.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(215977);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveBeforePlugin$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (n.aD((CharSequence)this.gWu.gWr))
          {
            this.gWu.gWg.setHint((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.b(paramRelativeLayout.getContext(), (CharSequence)paramRelativeLayout.getContext().getString(2131766574, new Object[] { this.gWu.gWs }), this.gWu.gWg.getTextSize()).toString());
            this.gWu.gWg.setText(null);
            paramAnonymousView = com.tencent.mm.live.b.g.gQZ;
          }
          for (com.tencent.mm.live.b.g.anH().Gud = com.tencent.mm.pluginsdk.ui.span.k.b(paramRelativeLayout.getContext(), (CharSequence)paramRelativeLayout.getContext().getString(2131766574, new Object[] { this.gWu.gWs }), this.gWu.gWg.getTextSize()).toString();; com.tencent.mm.live.b.g.anH().Gud = this.gWu.gWg.getText().toString())
          {
            paramAnonymousView = com.tencent.mm.live.b.g.gQZ;
            com.tencent.mm.live.b.g.dL(false);
            paramAnonymousView = paramRelativeLayout.getContext();
            if (paramAnonymousView != null) {
              break;
            }
            paramAnonymousView = new d.v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(215977);
            throw paramAnonymousView;
            this.gWu.gWg.setText((CharSequence)this.gWu.gWr);
            paramAnonymousView = com.tencent.mm.live.b.g.gQZ;
          }
          ((MMActivity)paramAnonymousView).hideVKB();
          this.gWu.gWg.clearFocus();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveBeforePlugin$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(215977);
        }
      });
      this.gWn.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(215978);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveBeforePlugin$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = paramRelativeLayout.getContext();
          if (paramAnonymousView == null)
          {
            paramAnonymousView = new d.v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(215978);
            throw paramAnonymousView;
          }
          ((MMActivity)paramAnonymousView).hideVKB();
          this.gWu.gWg.clearFocus();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveBeforePlugin$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(215978);
        }
      });
      this.gWo.post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(215970);
          Object localObject;
          if (this.gWu.aoA())
          {
            localObject = this.gWu.gWo.getLayoutParams();
            if (localObject == null)
            {
              localObject = new d.v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
              AppMethodBeat.o(215970);
              throw ((Throwable)localObject);
            }
          }
          for (((RelativeLayout.LayoutParams)localObject).bottomMargin = (com.tencent.mm.cb.a.ax(paramRelativeLayout.getContext(), 2131165275) + com.tencent.mm.cb.a.ax(paramRelativeLayout.getContext(), 2131167040) + this.gWu.gWe.getHeight());; ((RelativeLayout.LayoutParams)localObject).bottomMargin = (com.tencent.mm.cb.a.ax(paramRelativeLayout.getContext(), 2131165275) + com.tencent.mm.cb.a.ax(paramRelativeLayout.getContext(), 2131165277) + this.gWu.gWe.getHeight() + ar.en(paramRelativeLayout.getContext())))
          {
            this.gWu.gWo.requestLayout();
            AppMethodBeat.o(215970);
            return;
            localObject = this.gWu.gWf.getLayoutParams();
            if (localObject != null)
            {
              if (localObject == null)
              {
                localObject = new d.v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(215970);
                throw ((Throwable)localObject);
              }
              localObject = (ViewGroup.MarginLayoutParams)localObject;
              ((ViewGroup.MarginLayoutParams)localObject).bottomMargin += ar.en(paramRelativeLayout.getContext());
              this.gWu.gWf.requestLayout();
            }
            localObject = this.gWu.gWe.getLayoutParams();
            if (localObject != null)
            {
              if (localObject == null)
              {
                localObject = new d.v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(215970);
                throw ((Throwable)localObject);
              }
              localObject = (ViewGroup.MarginLayoutParams)localObject;
              ((ViewGroup.MarginLayoutParams)localObject).bottomMargin += ar.en(paramRelativeLayout.getContext());
              this.gWu.gWe.requestLayout();
            }
            localObject = this.gWu.gWo.getLayoutParams();
            if (localObject == null)
            {
              localObject = new d.v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
              AppMethodBeat.o(215970);
              throw ((Throwable)localObject);
            }
          }
        }
      });
      if ((!aoA()) || (this.gWj.getLayoutParams() == null) || (this.gWp.getLayoutParams() == null)) {
        break label813;
      }
      paramb = this.gWj.getLayoutParams();
      if (paramb != null) {
        break;
      }
      paramRelativeLayout = new d.v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(215985);
      throw paramRelativeLayout;
    }
    ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(ar.en(paramRelativeLayout.getContext()));
    paramb = this.gWp.getLayoutParams();
    if (paramb == null)
    {
      paramRelativeLayout = new d.v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(215985);
      throw paramRelativeLayout;
    }
    ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(ar.en(paramRelativeLayout.getContext()));
    this.gWj.requestLayout();
    this.gWp.requestLayout();
    try
    {
      label813:
      paramRelativeLayout = paramRelativeLayout.getContext();
      p.g(paramRelativeLayout, "root.context");
      paramRelativeLayout = paramRelativeLayout.getResources().getString(2131767090);
      paramRelativeLayout = new i(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qPX, "{\"simple_chinese\":\"" + paramRelativeLayout + "\",\"xg_traditional_chinese\":\"" + paramRelativeLayout + "\",\"tw_traditional_chinese\":\"" + paramRelativeLayout + "\",\"english\":\"" + paramRelativeLayout + "\"}"));
      paramb = ad.fom();
      if (p.i("zh_CN", paramb)) {
        paramRelativeLayout = paramRelativeLayout.getString("simple_chinese");
      }
      while (!bu.isNullOrNil(paramRelativeLayout))
      {
        this.gWf.setText((CharSequence)paramRelativeLayout);
        AppMethodBeat.o(215985);
        return;
        if (p.i("zh_TW", paramb)) {
          paramRelativeLayout = paramRelativeLayout.getString("xg_traditional_chinese");
        } else if (p.i("zh_HK", paramb)) {
          paramRelativeLayout = paramRelativeLayout.getString("tw_traditional_chinese");
        } else {
          paramRelativeLayout = paramRelativeLayout.getString("english");
        }
      }
      return;
    }
    catch (Exception paramRelativeLayout)
    {
      ae.w(this.TAG, "Exception: " + paramRelativeLayout.getMessage());
      AppMethodBeat.o(215985);
    }
  }
  
  static boolean aoW()
  {
    AppMethodBeat.i(215981);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajR();
    p.g(locale, "MMKernel.storage()");
    if (locale.ajA().getInt(am.a.JdG, 0) == 1)
    {
      AppMethodBeat.o(215981);
      return true;
    }
    AppMethodBeat.o(215981);
    return false;
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(215983);
    p.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (l.cqt[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(215983);
      return;
      nL(8);
      AppMethodBeat.o(215983);
      return;
      if (paramBundle != null)
      {
        paramc = Integer.valueOf(paramBundle.getInt("PARAM_FACE_VERIFY_ERROR", -1));
        if ((paramc != null) && (paramc.intValue() != -1)) {
          new com.tencent.mm.ui.widget.a.f.a(this.gJt.getContext()).fQD().aZq(this.gJt.getContext().getString(paramc.intValue())).aZu(this.gJt.getContext().getString(2131755792)).b((f.c)k.a.gWv).show();
        }
        paramc = com.tencent.mm.live.b.g.gQZ;
        paramBundle = com.tencent.mm.live.b.g.anH();
        paramc = (CharSequence)this.gWg.getText();
        if ((paramc != null) && (!n.aD(paramc))) {
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
      for (paramc = com.tencent.mm.pluginsdk.ui.span.k.b(this.gJt.getContext(), (CharSequence)this.gJt.getContext().getString(2131766574, new Object[] { this.gWs }), this.gWg.getTextSize()).toString();; paramc = this.gWg.getText().toString())
      {
        paramBundle.Gud = paramc;
        paramc = com.tencent.mm.live.b.g.gQZ;
        com.tencent.mm.live.b.g.dO(false);
        nL(0);
        AppMethodBeat.o(215983);
        return;
        paramc = null;
        break;
        i = 0;
        break label206;
      }
      paramc = com.tencent.mm.live.b.g.gQZ;
      if (com.tencent.mm.live.b.g.aod()) {}
      for (int i = 3;; i = 2)
      {
        paramc = com.tencent.mm.live.b.g.gQZ;
        paramc = com.tencent.mm.live.b.g.anC();
        paramBundle = com.tencent.mm.live.b.g.gQZ;
        boolean bool1 = com.tencent.mm.live.b.g.aoa();
        paramBundle = com.tencent.mm.live.b.g.gQZ;
        boolean bool2 = com.tencent.mm.live.b.g.aob();
        paramBundle = com.tencent.mm.live.b.g.gQZ;
        paramBundle = com.tencent.mm.live.b.g.anH().Gud;
        Object localObject = com.tencent.mm.live.b.g.gQZ;
        boolean bool3 = com.tencent.mm.live.b.g.anZ();
        localObject = this.gJt.getResources();
        p.g(localObject, "root.resources");
        com.tencent.mm.live.d.e.a(paramc, bool1, bool2, paramBundle, bool3, ((Resources)localObject).getConfiguration().orientation, i);
        com.tencent.mm.live.d.a.apw();
        paramc = com.tencent.mm.live.b.g.gQZ;
        com.tencent.mm.live.b.g.dO(false);
        AppMethodBeat.o(215983);
        return;
      }
      com.tencent.mm.live.d.a.apv();
    }
  }
  
  public final boolean aoQ()
  {
    AppMethodBeat.i(215984);
    if (this.gJt.getVisibility() == 0)
    {
      b.b.a(this.gVv, b.c.gUe);
      AppMethodBeat.o(215984);
      return true;
    }
    AppMethodBeat.o(215984);
    return false;
  }
  
  public final void i(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(215982);
    if (paramBoolean)
    {
      this.gWq.setVisibility(8);
      this.gWj.setVisibility(8);
      this.gWe.setVisibility(8);
      if (aoA()) {}
      for (paramInt = ar.ck(this.gJt.getContext()).y - paramInt - com.tencent.mm.cb.a.ax(this.gJt.getContext(), 2131165289);; paramInt = ar.ck(this.gJt.getContext()).y - paramInt - ar.en(this.gJt.getContext()) - com.tencent.mm.cb.a.ax(this.gJt.getContext(), 2131165289))
      {
        Object localObject1 = new int[2];
        this.gWo.getLocationOnScreen((int[])localObject1);
        int i = localObject1[1];
        int j = this.gWo.getHeight();
        this.gWo.animate().translationY(paramInt - (i + j)).start();
        localObject1 = this.gWg;
        Object localObject2 = this.gJt.getContext();
        p.g(localObject2, "root.context");
        ((EditText)localObject1).setBackground(((Context)localObject2).getResources().getDrawable(2131101053));
        this.gWg.setPadding(0, 0, 0, 0);
        this.gWg.setHint((CharSequence)" ");
        this.gWg.setCursorVisible(true);
        this.gWl.setVisibility(0);
        localObject1 = this.gWg.getText();
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
        paramInt = f.a((String)localObject1, com.tencent.mm.ui.tools.f.a.Lfh);
        this.gWl.setText((CharSequence)String.valueOf(28 - paramInt));
        this.gWm.setVisibility(0);
        this.gWn.setVisibility(0);
        AppMethodBeat.o(215982);
        return;
      }
    }
    this.gWq.setVisibility(0);
    this.gWj.setVisibility(0);
    this.gWe.setVisibility(0);
    this.gWo.animate().translationY(0.0F).start();
    this.gWg.setBackground(this.gWt);
    com.tencent.mm.cb.a.ax(this.gJt.getContext(), 2131165294);
    paramInt = com.tencent.mm.cb.a.ax(this.gJt.getContext(), 2131165303);
    this.gWg.setPadding(0, 0, 0, paramInt);
    this.gWg.setHint((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.b(this.gJt.getContext(), (CharSequence)this.gJt.getContext().getString(2131766574, new Object[] { this.gWs }), this.gWg.getTextSize()));
    this.gWg.setCursorVisible(false);
    this.gWl.setVisibility(8);
    this.gWm.setVisibility(8);
    this.gWn.setVisibility(8);
    AppMethodBeat.o(215982);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.c.k
 * JD-Core Version:    0.7.0.1
 */