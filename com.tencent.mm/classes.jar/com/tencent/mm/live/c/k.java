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
import com.tencent.mm.ac.i;
import com.tencent.mm.live.core.core.b.d;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
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
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/plugin/LiveBeforePlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/widget/RelativeLayout;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "closeBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "hostString", "liveEditTopGroup", "liveRoomIdEdit", "Landroid/widget/EditText;", "liveTitleEdit", "liveTitleEditCancel", "Landroid/widget/TextView;", "liveTitleEditGroup", "liveTitleEditOk", "Landroid/widget/Button;", "liveTitleEditTextNumHint", "liveTitleTv", "mTopicName", "providerTip", "rootLayout", "startLiveBtn", "switchBtn", "titleEditBackground", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "topGroup", "Landroid/view/ViewGroup;", "checkLiveName", "", "liveName", "createLive", "", "enableTestRoomId", "keyboardChange", "show", "height", "", "onBackPress", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class k
  extends a
{
  private final String TAG;
  final b gSM;
  final EditText gTA;
  final TextView gTB;
  private final TextView gTC;
  final Button gTD;
  final RelativeLayout gTE;
  private final RelativeLayout gTF;
  private final TextView gTG;
  String gTH;
  String gTI;
  private Drawable gTJ;
  private final RelativeLayout gTu;
  final Button gTv;
  final EditText gTw;
  private final WeImageView gTx;
  private final WeImageView gTy;
  private final ViewGroup gTz;
  final TextView jLY;
  
  public k(final RelativeLayout paramRelativeLayout, b paramb)
  {
    super((ViewGroup)paramRelativeLayout, paramb);
    AppMethodBeat.i(212365);
    this.gSM = paramb;
    this.TAG = "MicroMsg.LiveBeforePlugin";
    paramb = paramRelativeLayout.findViewById(2131307594);
    p.g(paramb, "root.findViewById(R.id.live_before_ui_root)");
    this.gTu = ((RelativeLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131307586);
    p.g(paramb, "root.findViewById(R.id.l…before_content_start_btn)");
    this.gTv = ((Button)paramb);
    paramb = paramRelativeLayout.findViewById(2131307284);
    p.g(paramb, "root.findViewById(R.id.live_before_provider_tip)");
    this.jLY = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307587);
    p.g(paramb, "root.findViewById(R.id.l…efore_content_title_edit)");
    this.gTw = ((EditText)paramb);
    paramb = paramRelativeLayout.findViewById(2131307591);
    p.g(paramb, "root.findViewById(R.id.live_before_top_close)");
    this.gTx = ((WeImageView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307593);
    p.g(paramb, "root.findViewById(R.id.live_before_top_switch)");
    this.gTy = ((WeImageView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307592);
    p.g(paramb, "root.findViewById(R.id.live_before_top_group)");
    this.gTz = ((ViewGroup)paramb);
    paramb = paramRelativeLayout.findViewById(2131307585);
    p.g(paramb, "root.findViewById(R.id.l…fore_content_roomid_edit)");
    this.gTA = ((EditText)paramb);
    paramb = paramRelativeLayout.findViewById(2131308036);
    p.g(paramb, "root.findViewById(R.id.title_edit_text_num_hint)");
    this.gTB = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307802);
    p.g(paramb, "root.findViewById(R.id.live_title_edit_cancel)");
    this.gTC = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307803);
    p.g(paramb, "root.findViewById(R.id.live_title_edit_ok)");
    this.gTD = ((Button)paramb);
    paramb = paramRelativeLayout.findViewById(2131307588);
    p.g(paramb, "root.findViewById(R.id.l…content_title_edit_group)");
    this.gTE = ((RelativeLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131307589);
    p.g(paramb, "root.findViewById(R.id.live_before_edit_top_group)");
    this.gTF = ((RelativeLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131307590);
    p.g(paramb, "root.findViewById(R.id.live_before_title)");
    this.gTG = ((TextView)paramb);
    this.gTH = "";
    this.gTI = "";
    this.gTJ = this.gTw.getBackground();
    this.gTu.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(212349);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveBeforePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (!bt.isNullOrNil(this.gTK.gTw.getText().toString()))
        {
          paramAnonymousView = paramRelativeLayout.getContext();
          if (paramAnonymousView == null)
          {
            paramAnonymousView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(212349);
            throw paramAnonymousView;
          }
          ((MMActivity)paramAnonymousView).hideVKB();
          this.gTK.gTw.clearFocus();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveBeforePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(212349);
      }
    });
    paramb = u.aAY();
    Object localObject;
    if (paramb != null)
    {
      localObject = paramb.adv();
      paramb = (b)localObject;
      if (localObject != null) {}
    }
    else
    {
      paramb = "";
    }
    this.gTI = paramb;
    this.gTw.setHint((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.b(paramRelativeLayout.getContext(), (CharSequence)paramRelativeLayout.getContext().getString(2131766574, new Object[] { this.gTI }), this.gTw.getTextSize()));
    this.gTw.setOnEditorActionListener((TextView.OnEditorActionListener)new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(212351);
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
            paramAnonymousTextView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(212351);
            throw paramAnonymousTextView;
          }
          ((MMActivity)paramAnonymousTextView).hideVKB();
          this.gTK.gTw.clearFocus();
        }
        AppMethodBeat.o(212351);
        return false;
      }
    });
    this.gTx.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(212352);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveBeforePlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        b.b.a(this.gTK.gSM, b.c.gRw);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveBeforePlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(212352);
      }
    });
    this.gTy.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(212353);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveBeforePlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        this.gTK.gSM.a(b.c.gRx, new Bundle());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveBeforePlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(212353);
      }
    });
    this.gTv.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(212354);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveBeforePlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        localObject = this.gTK;
        paramAnonymousView = (CharSequence)((k)localObject).gTw.getText();
        if ((paramAnonymousView == null) || (n.aE(paramAnonymousView)))
        {
          i = 1;
          if (i == 0) {
            break label208;
          }
          paramAnonymousView = "";
          label70:
          if (!k.aoI()) {
            break label222;
          }
        }
        label208:
        label222:
        for (int i = Integer.parseInt(((k)localObject).gTA.getText().toString());; i = -1)
        {
          Bundle localBundle = new Bundle();
          localBundle.putInt("PARAM_LIVE_TEST_ROOM_ID", i);
          localBundle.putString("PARAM_START_LIVE_TITLE", paramAnonymousView);
          paramAnonymousView = com.tencent.mm.live.b.g.gOr;
          com.tencent.mm.live.b.g.ans().GOL = com.tencent.mm.pluginsdk.ui.span.k.b(((a)localObject).gGK.getContext(), (CharSequence)((a)localObject).gGK.getContext().getString(2131766574, new Object[] { ((k)localObject).gTI }), ((k)localObject).gTw.getTextSize()).toString();
          ((k)localObject).gSM.a(b.c.gSp, localBundle);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveBeforePlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(212354);
          return;
          i = 0;
          break;
          paramAnonymousView = ((k)localObject).gTw.getText().toString();
          break label70;
        }
      }
    });
    paramb = this.gTA;
    if (aoI()) {}
    for (int i = 0;; i = 8)
    {
      paramb.setVisibility(i);
      paramb = this.gTA;
      localObject = d.gHH;
      paramb.setText((CharSequence)String.valueOf(d.alA().roomId));
      c.d(this.gTw).kc(0, 28).a(null);
      this.gTw.addTextChangedListener((TextWatcher)new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(212355);
          if (paramAnonymousEditable != null)
          {
            Button localButton = this.gTK.gTD;
            if (!bt.ai((CharSequence)paramAnonymousEditable)) {}
            for (boolean bool = true;; bool = false)
            {
              localButton.setEnabled(bool);
              int i = f.a(paramAnonymousEditable.toString(), com.tencent.mm.ui.tools.f.a.KIN);
              this.gTK.gTB.setText((CharSequence)String.valueOf(28 - i));
              this.gTK.gTw.setSelection(this.gTK.gTw.getText().length());
              paramAnonymousEditable = com.tencent.mm.live.b.g.gOr;
              com.tencent.mm.live.b.g.ans().Gbw = this.gTK.gTw.getText().toString();
              paramAnonymousEditable = com.tencent.mm.live.b.g.gOr;
              com.tencent.mm.live.b.g.dK(true);
              com.tencent.mm.live.d.a.apj();
              AppMethodBeat.o(212355);
              return;
            }
          }
          AppMethodBeat.o(212355);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.gTw.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(212356);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveBeforePlugin$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          this.gTK.gTH = this.gTK.gTw.getText().toString();
          if (bt.isNullOrNil(this.gTK.gTH)) {
            this.gTK.gTD.setEnabled(false);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveBeforePlugin$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(212356);
            return;
            this.gTK.gTD.setEnabled(true);
          }
        }
      });
      this.gTC.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(212357);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveBeforePlugin$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (n.aE((CharSequence)this.gTK.gTH))
          {
            this.gTK.gTw.setHint((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.b(paramRelativeLayout.getContext(), (CharSequence)paramRelativeLayout.getContext().getString(2131766574, new Object[] { this.gTK.gTI }), this.gTK.gTw.getTextSize()).toString());
            this.gTK.gTw.setText(null);
            paramAnonymousView = com.tencent.mm.live.b.g.gOr;
          }
          for (com.tencent.mm.live.b.g.ans().Gbw = com.tencent.mm.pluginsdk.ui.span.k.b(paramRelativeLayout.getContext(), (CharSequence)paramRelativeLayout.getContext().getString(2131766574, new Object[] { this.gTK.gTI }), this.gTK.gTw.getTextSize()).toString();; com.tencent.mm.live.b.g.ans().Gbw = this.gTK.gTw.getText().toString())
          {
            paramAnonymousView = com.tencent.mm.live.b.g.gOr;
            com.tencent.mm.live.b.g.dK(false);
            paramAnonymousView = paramRelativeLayout.getContext();
            if (paramAnonymousView != null) {
              break;
            }
            paramAnonymousView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(212357);
            throw paramAnonymousView;
            this.gTK.gTw.setText((CharSequence)this.gTK.gTH);
            paramAnonymousView = com.tencent.mm.live.b.g.gOr;
          }
          ((MMActivity)paramAnonymousView).hideVKB();
          this.gTK.gTw.clearFocus();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveBeforePlugin$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(212357);
        }
      });
      this.gTD.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(212358);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveBeforePlugin$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          paramAnonymousView = paramRelativeLayout.getContext();
          if (paramAnonymousView == null)
          {
            paramAnonymousView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(212358);
            throw paramAnonymousView;
          }
          ((MMActivity)paramAnonymousView).hideVKB();
          this.gTK.gTw.clearFocus();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveBeforePlugin$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(212358);
        }
      });
      this.gTE.post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(212350);
          Object localObject;
          if (this.gTK.aol())
          {
            localObject = this.gTK.gTE.getLayoutParams();
            if (localObject == null)
            {
              localObject = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
              AppMethodBeat.o(212350);
              throw ((Throwable)localObject);
            }
          }
          for (((RelativeLayout.LayoutParams)localObject).bottomMargin = (com.tencent.mm.cc.a.ax(paramRelativeLayout.getContext(), 2131165275) + com.tencent.mm.cc.a.ax(paramRelativeLayout.getContext(), 2131167040) + this.gTK.gTv.getHeight());; ((RelativeLayout.LayoutParams)localObject).bottomMargin = (com.tencent.mm.cc.a.ax(paramRelativeLayout.getContext(), 2131165275) + com.tencent.mm.cc.a.ax(paramRelativeLayout.getContext(), 2131165277) + this.gTK.gTv.getHeight() + ar.ej(paramRelativeLayout.getContext())))
          {
            this.gTK.gTE.requestLayout();
            AppMethodBeat.o(212350);
            return;
            localObject = this.gTK.jLY.getLayoutParams();
            if (localObject != null)
            {
              if (localObject == null)
              {
                localObject = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(212350);
                throw ((Throwable)localObject);
              }
              localObject = (ViewGroup.MarginLayoutParams)localObject;
              ((ViewGroup.MarginLayoutParams)localObject).bottomMargin += ar.ej(paramRelativeLayout.getContext());
              this.gTK.jLY.requestLayout();
            }
            localObject = this.gTK.gTv.getLayoutParams();
            if (localObject != null)
            {
              if (localObject == null)
              {
                localObject = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(212350);
                throw ((Throwable)localObject);
              }
              localObject = (ViewGroup.MarginLayoutParams)localObject;
              ((ViewGroup.MarginLayoutParams)localObject).bottomMargin += ar.ej(paramRelativeLayout.getContext());
              this.gTK.gTv.requestLayout();
            }
            localObject = this.gTK.gTE.getLayoutParams();
            if (localObject == null)
            {
              localObject = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
              AppMethodBeat.o(212350);
              throw ((Throwable)localObject);
            }
          }
        }
      });
      if ((!aol()) || (this.gTz.getLayoutParams() == null) || (this.gTF.getLayoutParams() == null)) {
        break label813;
      }
      paramb = this.gTz.getLayoutParams();
      if (paramb != null) {
        break;
      }
      paramRelativeLayout = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(212365);
      throw paramRelativeLayout;
    }
    ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(ar.ej(paramRelativeLayout.getContext()));
    paramb = this.gTF.getLayoutParams();
    if (paramb == null)
    {
      paramRelativeLayout = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(212365);
      throw paramRelativeLayout;
    }
    ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(ar.ej(paramRelativeLayout.getContext()));
    this.gTz.requestLayout();
    this.gTF.requestLayout();
    try
    {
      label813:
      paramRelativeLayout = paramRelativeLayout.getContext();
      p.g(paramRelativeLayout, "root.context");
      paramRelativeLayout = paramRelativeLayout.getResources().getString(2131767090);
      paramRelativeLayout = new i(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.CZp, "{\"simple_chinese\":\"" + paramRelativeLayout + "\",\"xg_traditional_chinese\":\"" + paramRelativeLayout + "\",\"tw_traditional_chinese\":\"" + paramRelativeLayout + "\",\"english\":\"" + paramRelativeLayout + "\"}"));
      paramb = ac.fks();
      if (p.i("zh_CN", paramb)) {
        paramRelativeLayout = paramRelativeLayout.getString("simple_chinese");
      }
      while (!bt.isNullOrNil(paramRelativeLayout))
      {
        this.jLY.setText((CharSequence)paramRelativeLayout);
        AppMethodBeat.o(212365);
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
      ad.w(this.TAG, "Exception: " + paramRelativeLayout.getMessage());
      AppMethodBeat.o(212365);
    }
  }
  
  static boolean aoI()
  {
    AppMethodBeat.i(212361);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajC();
    p.g(locale, "MMKernel.storage()");
    if (locale.ajl().getInt(al.a.IJa, 0) == 1)
    {
      AppMethodBeat.o(212361);
      return true;
    }
    AppMethodBeat.o(212361);
    return false;
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(212363);
    p.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (l.cpQ[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(212363);
      return;
      nI(8);
      AppMethodBeat.o(212363);
      return;
      if (paramBundle != null)
      {
        paramc = Integer.valueOf(paramBundle.getInt("PARAM_FACE_VERIFY_ERROR", -1));
        if ((paramc != null) && (paramc.intValue() != -1)) {
          new com.tencent.mm.ui.widget.a.f.a(this.gGK.getContext()).fMj().aXO(this.gGK.getContext().getString(paramc.intValue())).aXS(this.gGK.getContext().getString(2131755792)).b((f.c)k.a.gTL).show();
        }
        paramc = com.tencent.mm.live.b.g.gOr;
        paramBundle = com.tencent.mm.live.b.g.ans();
        paramc = (CharSequence)this.gTw.getText();
        if ((paramc != null) && (!n.aE(paramc))) {
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
      for (paramc = com.tencent.mm.pluginsdk.ui.span.k.b(this.gGK.getContext(), (CharSequence)this.gGK.getContext().getString(2131766574, new Object[] { this.gTI }), this.gTw.getTextSize()).toString();; paramc = this.gTw.getText().toString())
      {
        paramBundle.Gbw = paramc;
        paramc = com.tencent.mm.live.b.g.gOr;
        com.tencent.mm.live.b.g.dN(false);
        nI(0);
        AppMethodBeat.o(212363);
        return;
        paramc = null;
        break;
        i = 0;
        break label206;
      }
      paramc = com.tencent.mm.live.b.g.gOr;
      if (com.tencent.mm.live.b.g.anO()) {}
      for (int i = 3;; i = 2)
      {
        paramc = com.tencent.mm.live.b.g.gOr;
        paramc = com.tencent.mm.live.b.g.anm();
        paramBundle = com.tencent.mm.live.b.g.gOr;
        boolean bool1 = com.tencent.mm.live.b.g.anL();
        paramBundle = com.tencent.mm.live.b.g.gOr;
        boolean bool2 = com.tencent.mm.live.b.g.anM();
        paramBundle = com.tencent.mm.live.b.g.gOr;
        paramBundle = com.tencent.mm.live.b.g.ans().Gbw;
        Object localObject = com.tencent.mm.live.b.g.gOr;
        boolean bool3 = com.tencent.mm.live.b.g.anK();
        localObject = this.gGK.getResources();
        p.g(localObject, "root.resources");
        com.tencent.mm.live.d.e.a(paramc, bool1, bool2, paramBundle, bool3, ((Resources)localObject).getConfiguration().orientation, i);
        com.tencent.mm.live.d.a.api();
        paramc = com.tencent.mm.live.b.g.gOr;
        com.tencent.mm.live.b.g.dN(false);
        AppMethodBeat.o(212363);
        return;
      }
      com.tencent.mm.live.d.a.aph();
    }
  }
  
  public final boolean aoB()
  {
    AppMethodBeat.i(212364);
    if (this.gGK.getVisibility() == 0)
    {
      b.b.a(this.gSM, b.c.gRw);
      AppMethodBeat.o(212364);
      return true;
    }
    AppMethodBeat.o(212364);
    return false;
  }
  
  public final void i(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(212362);
    if (paramBoolean)
    {
      this.gTG.setVisibility(8);
      this.gTz.setVisibility(8);
      this.gTv.setVisibility(8);
      if (aol()) {}
      for (paramInt = ar.ci(this.gGK.getContext()).y - paramInt - com.tencent.mm.cc.a.ax(this.gGK.getContext(), 2131165289);; paramInt = ar.ci(this.gGK.getContext()).y - paramInt - ar.ej(this.gGK.getContext()) - com.tencent.mm.cc.a.ax(this.gGK.getContext(), 2131165289))
      {
        Object localObject1 = new int[2];
        this.gTE.getLocationOnScreen((int[])localObject1);
        int i = localObject1[1];
        int j = this.gTE.getHeight();
        this.gTE.animate().translationY(paramInt - (i + j)).start();
        localObject1 = this.gTw;
        Object localObject2 = this.gGK.getContext();
        p.g(localObject2, "root.context");
        ((EditText)localObject1).setBackground(((Context)localObject2).getResources().getDrawable(2131101053));
        this.gTw.setPadding(0, 0, 0, 0);
        this.gTw.setHint((CharSequence)" ");
        this.gTw.setCursorVisible(true);
        this.gTB.setVisibility(0);
        localObject1 = this.gTw.getText();
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
        paramInt = f.a((String)localObject1, com.tencent.mm.ui.tools.f.a.KIN);
        this.gTB.setText((CharSequence)String.valueOf(28 - paramInt));
        this.gTC.setVisibility(0);
        this.gTD.setVisibility(0);
        AppMethodBeat.o(212362);
        return;
      }
    }
    this.gTG.setVisibility(0);
    this.gTz.setVisibility(0);
    this.gTv.setVisibility(0);
    this.gTE.animate().translationY(0.0F).start();
    this.gTw.setBackground(this.gTJ);
    com.tencent.mm.cc.a.ax(this.gGK.getContext(), 2131165294);
    paramInt = com.tencent.mm.cc.a.ax(this.gGK.getContext(), 2131165303);
    this.gTw.setPadding(0, 0, 0, paramInt);
    this.gTw.setHint((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.b(this.gGK.getContext(), (CharSequence)this.gGK.getContext().getString(2131766574, new Object[] { this.gTI }), this.gTw.getTextSize()));
    this.gTw.setCursorVisible(false);
    this.gTB.setVisibility(8);
    this.gTC.setVisibility(8);
    this.gTD.setVisibility(8);
    AppMethodBeat.o(212362);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.k
 * JD-Core Version:    0.7.0.1
 */