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
import com.tencent.mm.live.core.core.b.d;
import com.tencent.mm.model.u;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import d.l;
import d.n.n;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/plugin/LiveBeforePlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/widget/RelativeLayout;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "closeBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "hostString", "liveEditTopGroup", "liveRoomIdEdit", "Landroid/widget/EditText;", "liveTitleEdit", "liveTitleEditCancel", "Landroid/widget/TextView;", "liveTitleEditGroup", "liveTitleEditOk", "Landroid/widget/Button;", "liveTitleEditTextNumHint", "liveTitleTv", "mTopicName", "rootLayout", "startLiveBtn", "switchBtn", "titleEditBackground", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "topGroup", "Landroid/view/ViewGroup;", "checkLiveName", "", "liveName", "createLive", "", "enableTestRoomId", "keyboardChange", "show", "height", "", "onBackPress", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class k
  extends a
{
  private final String TAG;
  private final RelativeLayout gzJ;
  final Button gzK;
  final EditText gzL;
  private final WeImageView gzM;
  private final WeImageView gzN;
  private final ViewGroup gzO;
  final EditText gzP;
  final TextView gzQ;
  private final TextView gzR;
  final Button gzS;
  final RelativeLayout gzT;
  private final RelativeLayout gzU;
  private final TextView gzV;
  String gzW;
  String gzX;
  private Drawable gzY;
  final b gzb;
  
  public k(final RelativeLayout paramRelativeLayout, b paramb)
  {
    super((ViewGroup)paramRelativeLayout, paramb);
    AppMethodBeat.i(190077);
    this.gzb = paramb;
    this.TAG = "MicroMsg.LiveBeforePlugin";
    paramb = paramRelativeLayout.findViewById(2131307594);
    d.g.b.k.g(paramb, "root.findViewById(R.id.live_before_ui_root)");
    this.gzJ = ((RelativeLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131307586);
    d.g.b.k.g(paramb, "root.findViewById(R.id.l…before_content_start_btn)");
    this.gzK = ((Button)paramb);
    paramb = paramRelativeLayout.findViewById(2131307587);
    d.g.b.k.g(paramb, "root.findViewById(R.id.l…efore_content_title_edit)");
    this.gzL = ((EditText)paramb);
    paramb = paramRelativeLayout.findViewById(2131307591);
    d.g.b.k.g(paramb, "root.findViewById(R.id.live_before_top_close)");
    this.gzM = ((WeImageView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307593);
    d.g.b.k.g(paramb, "root.findViewById(R.id.live_before_top_switch)");
    this.gzN = ((WeImageView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307592);
    d.g.b.k.g(paramb, "root.findViewById(R.id.live_before_top_group)");
    this.gzO = ((ViewGroup)paramb);
    paramb = paramRelativeLayout.findViewById(2131307585);
    d.g.b.k.g(paramb, "root.findViewById(R.id.l…fore_content_roomid_edit)");
    this.gzP = ((EditText)paramb);
    paramb = paramRelativeLayout.findViewById(2131308036);
    d.g.b.k.g(paramb, "root.findViewById(R.id.title_edit_text_num_hint)");
    this.gzQ = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307802);
    d.g.b.k.g(paramb, "root.findViewById(R.id.live_title_edit_cancel)");
    this.gzR = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307803);
    d.g.b.k.g(paramb, "root.findViewById(R.id.live_title_edit_ok)");
    this.gzS = ((Button)paramb);
    paramb = paramRelativeLayout.findViewById(2131307588);
    d.g.b.k.g(paramb, "root.findViewById(R.id.l…content_title_edit_group)");
    this.gzT = ((RelativeLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131307589);
    d.g.b.k.g(paramb, "root.findViewById(R.id.live_before_edit_top_group)");
    this.gzU = ((RelativeLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131307590);
    d.g.b.k.g(paramb, "root.findViewById(R.id.live_before_title)");
    this.gzV = ((TextView)paramb);
    this.gzW = "";
    this.gzX = "";
    this.gzY = this.gzL.getBackground();
    this.gzJ.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(190061);
        if (!bs.isNullOrNil(this.gzZ.gzL.getText().toString()))
        {
          paramAnonymousView = paramRelativeLayout.getContext();
          if (paramAnonymousView == null)
          {
            paramAnonymousView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(190061);
            throw paramAnonymousView;
          }
          ((MMActivity)paramAnonymousView).hideVKB();
          this.gzZ.gzL.clearFocus();
        }
        AppMethodBeat.o(190061);
      }
    });
    paramb = u.ayc();
    Object localObject;
    if (paramb != null)
    {
      localObject = paramb.aaS();
      paramb = (b)localObject;
      if (localObject != null) {}
    }
    else
    {
      paramb = "";
    }
    this.gzX = paramb;
    this.gzL.setHint((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.b(paramRelativeLayout.getContext(), (CharSequence)paramRelativeLayout.getContext().getString(2131766574, new Object[] { this.gzX }), this.gzL.getTextSize()));
    this.gzL.setOnEditorActionListener((TextView.OnEditorActionListener)new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(190063);
        if (6 != paramAnonymousInt)
        {
          d.g.b.k.g(paramAnonymousKeyEvent, "keyEvent");
          if (paramAnonymousKeyEvent.getAction() != 66) {}
        }
        else
        {
          paramAnonymousTextView = paramRelativeLayout.getContext();
          if (paramAnonymousTextView == null)
          {
            paramAnonymousTextView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(190063);
            throw paramAnonymousTextView;
          }
          ((MMActivity)paramAnonymousTextView).hideVKB();
          this.gzZ.gzL.clearFocus();
        }
        AppMethodBeat.o(190063);
        return false;
      }
    });
    this.gzM.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(190064);
        b.b.a(this.gzZ.gzb, b.c.gxL);
        AppMethodBeat.o(190064);
      }
    });
    this.gzN.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(190065);
        this.gzZ.gzb.a(b.c.gxM, new Bundle());
        AppMethodBeat.o(190065);
      }
    });
    this.gzK.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(190066);
        k localk = this.gzZ;
        paramAnonymousView = (CharSequence)localk.gzL.getText();
        if ((paramAnonymousView == null) || (n.aD(paramAnonymousView)))
        {
          i = 1;
          if (i == 0) {
            break label167;
          }
          paramAnonymousView = "";
          label41:
          if (!k.alV()) {
            break label181;
          }
        }
        label167:
        label181:
        for (int i = Integer.parseInt(localk.gzP.getText().toString());; i = -1)
        {
          Bundle localBundle = new Bundle();
          localBundle.putInt("PARAM_LIVE_TEST_ROOM_ID", i);
          localBundle.putString("PARAM_START_LIVE_TITLE", paramAnonymousView);
          paramAnonymousView = com.tencent.mm.live.b.g.guG;
          com.tencent.mm.live.b.g.akF().Ffh = com.tencent.mm.pluginsdk.ui.span.k.b(localk.gnb.getContext(), (CharSequence)localk.gnb.getContext().getString(2131766574, new Object[] { localk.gzX }), localk.gzL.getTextSize()).toString();
          localk.gzb.a(b.c.gyE, localBundle);
          AppMethodBeat.o(190066);
          return;
          i = 0;
          break;
          paramAnonymousView = localk.gzL.getText().toString();
          break label41;
        }
      }
    });
    paramb = this.gzP;
    if (alV()) {}
    for (int i = 0;; i = 8)
    {
      paramb.setVisibility(i);
      paramb = this.gzP;
      localObject = d.gnY;
      paramb.setText((CharSequence)String.valueOf(d.aiO().roomId));
      c.d(this.gzL).jQ(0, 28).a(null);
      this.gzL.addTextChangedListener((TextWatcher)new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(190067);
          if (paramAnonymousEditable != null)
          {
            Button localButton = this.gzZ.gzS;
            if (!bs.aj((CharSequence)paramAnonymousEditable)) {}
            for (boolean bool = true;; bool = false)
            {
              localButton.setEnabled(bool);
              int i = f.a(paramAnonymousEditable.toString(), com.tencent.mm.ui.tools.f.a.IRJ);
              this.gzZ.gzQ.setText((CharSequence)String.valueOf(28 - i));
              this.gzZ.gzL.setSelection(this.gzZ.gzL.getText().length());
              paramAnonymousEditable = com.tencent.mm.live.b.g.guG;
              com.tencent.mm.live.b.g.akF().Eud = this.gzZ.gzL.getText().toString();
              paramAnonymousEditable = com.tencent.mm.live.b.g.guG;
              com.tencent.mm.live.b.g.dI(true);
              com.tencent.mm.live.d.a.amw();
              AppMethodBeat.o(190067);
              return;
            }
          }
          AppMethodBeat.o(190067);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.gzL.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(190068);
          this.gzZ.gzW = this.gzZ.gzL.getText().toString();
          if (bs.isNullOrNil(this.gzZ.gzW))
          {
            this.gzZ.gzS.setEnabled(false);
            AppMethodBeat.o(190068);
            return;
          }
          this.gzZ.gzS.setEnabled(true);
          AppMethodBeat.o(190068);
        }
      });
      this.gzR.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(190069);
          if (n.aD((CharSequence)this.gzZ.gzW))
          {
            this.gzZ.gzL.setHint((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.b(paramRelativeLayout.getContext(), (CharSequence)paramRelativeLayout.getContext().getString(2131766574, new Object[] { this.gzZ.gzX }), this.gzZ.gzL.getTextSize()).toString());
            this.gzZ.gzL.setText(null);
            paramAnonymousView = com.tencent.mm.live.b.g.guG;
          }
          for (com.tencent.mm.live.b.g.akF().Eud = com.tencent.mm.pluginsdk.ui.span.k.b(paramRelativeLayout.getContext(), (CharSequence)paramRelativeLayout.getContext().getString(2131766574, new Object[] { this.gzZ.gzX }), this.gzZ.gzL.getTextSize()).toString();; com.tencent.mm.live.b.g.akF().Eud = this.gzZ.gzL.getText().toString())
          {
            paramAnonymousView = com.tencent.mm.live.b.g.guG;
            com.tencent.mm.live.b.g.dI(false);
            paramAnonymousView = paramRelativeLayout.getContext();
            if (paramAnonymousView != null) {
              break;
            }
            paramAnonymousView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(190069);
            throw paramAnonymousView;
            this.gzZ.gzL.setText((CharSequence)this.gzZ.gzW);
            paramAnonymousView = com.tencent.mm.live.b.g.guG;
          }
          ((MMActivity)paramAnonymousView).hideVKB();
          this.gzZ.gzL.clearFocus();
          AppMethodBeat.o(190069);
        }
      });
      this.gzS.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(190070);
          paramAnonymousView = paramRelativeLayout.getContext();
          if (paramAnonymousView == null)
          {
            paramAnonymousView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(190070);
            throw paramAnonymousView;
          }
          ((MMActivity)paramAnonymousView).hideVKB();
          this.gzZ.gzL.clearFocus();
          AppMethodBeat.o(190070);
        }
      });
      this.gzT.post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(190062);
          Object localObject;
          if (this.gzZ.aly())
          {
            localObject = this.gzZ.gzT.getLayoutParams();
            if (localObject == null)
            {
              localObject = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
              AppMethodBeat.o(190062);
              throw ((Throwable)localObject);
            }
          }
          for (((RelativeLayout.LayoutParams)localObject).bottomMargin = (com.tencent.mm.cc.a.au(paramRelativeLayout.getContext(), 2131165275) + com.tencent.mm.cc.a.au(paramRelativeLayout.getContext(), 2131165294) + this.gzZ.gzK.getHeight());; ((RelativeLayout.LayoutParams)localObject).bottomMargin = (com.tencent.mm.cc.a.au(paramRelativeLayout.getContext(), 2131165275) + com.tencent.mm.cc.a.au(paramRelativeLayout.getContext(), 2131165277) + this.gzZ.gzK.getHeight()))
          {
            this.gzZ.gzT.requestLayout();
            AppMethodBeat.o(190062);
            return;
            localObject = this.gzZ.gzT.getLayoutParams();
            if (localObject == null)
            {
              localObject = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
              AppMethodBeat.o(190062);
              throw ((Throwable)localObject);
            }
          }
        }
      });
      if ((!aly()) || (this.gzO.getLayoutParams() == null) || (this.gzU.getLayoutParams() == null)) {
        break label792;
      }
      paramb = this.gzO.getLayoutParams();
      if (paramb != null) {
        break;
      }
      paramRelativeLayout = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(190077);
      throw paramRelativeLayout;
    }
    ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(ap.ej(paramRelativeLayout.getContext()));
    paramb = this.gzU.getLayoutParams();
    if (paramb == null)
    {
      paramRelativeLayout = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(190077);
      throw paramRelativeLayout;
    }
    ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(ap.ej(paramRelativeLayout.getContext()));
    this.gzO.requestLayout();
    this.gzU.requestLayout();
    label792:
    AppMethodBeat.o(190077);
  }
  
  static boolean alV()
  {
    AppMethodBeat.i(190073);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(locale, "MMKernel.storage()");
    if (locale.agA().getInt(ah.a.GWd, 0) == 1)
    {
      AppMethodBeat.o(190073);
      return true;
    }
    AppMethodBeat.o(190073);
    return false;
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(190075);
    d.g.b.k.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (l.cfA[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(190075);
      return;
      nj(8);
      AppMethodBeat.o(190075);
      return;
      if (paramBundle != null)
      {
        paramc = Integer.valueOf(paramBundle.getInt("PARAM_FACE_VERIFY_ERROR", -1));
        if ((paramc != null) && (paramc.intValue() != -1)) {
          new com.tencent.mm.ui.widget.a.f.a(this.gnb.getContext()).fvx().aRQ(this.gnb.getContext().getString(paramc.intValue())).aRU(this.gnb.getContext().getString(2131755792)).b((f.c)a.gAa).show();
        }
        paramc = com.tencent.mm.live.b.g.guG;
        paramBundle = com.tencent.mm.live.b.g.akF();
        paramc = (CharSequence)this.gzL.getText();
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
      for (paramc = com.tencent.mm.pluginsdk.ui.span.k.b(this.gnb.getContext(), (CharSequence)this.gnb.getContext().getString(2131766574, new Object[] { this.gzX }), this.gzL.getTextSize()).toString();; paramc = this.gzL.getText().toString())
      {
        paramBundle.Eud = paramc;
        paramc = com.tencent.mm.live.b.g.guG;
        com.tencent.mm.live.b.g.dL(false);
        nj(0);
        AppMethodBeat.o(190075);
        return;
        paramc = null;
        break;
        i = 0;
        break label206;
      }
      paramc = com.tencent.mm.live.b.g.guG;
      if (com.tencent.mm.live.b.g.alb()) {}
      for (int i = 3;; i = 2)
      {
        paramc = com.tencent.mm.live.b.g.guG;
        paramc = com.tencent.mm.live.b.g.akA();
        paramBundle = com.tencent.mm.live.b.g.guG;
        boolean bool1 = com.tencent.mm.live.b.g.akY();
        paramBundle = com.tencent.mm.live.b.g.guG;
        boolean bool2 = com.tencent.mm.live.b.g.akZ();
        paramBundle = com.tencent.mm.live.b.g.guG;
        paramBundle = com.tencent.mm.live.b.g.akF().Eud;
        Object localObject = com.tencent.mm.live.b.g.guG;
        boolean bool3 = com.tencent.mm.live.b.g.akX();
        localObject = this.gnb.getResources();
        d.g.b.k.g(localObject, "root.resources");
        com.tencent.mm.live.d.e.a(paramc, bool1, bool2, paramBundle, bool3, ((Resources)localObject).getConfiguration().orientation, i);
        com.tencent.mm.live.d.a.amv();
        paramc = com.tencent.mm.live.b.g.guG;
        com.tencent.mm.live.b.g.dL(false);
        AppMethodBeat.o(190075);
        return;
      }
      com.tencent.mm.live.d.a.amu();
    }
  }
  
  public final boolean alO()
  {
    AppMethodBeat.i(190076);
    if (this.gnb.getVisibility() == 0)
    {
      b.b.a(this.gzb, b.c.gxL);
      AppMethodBeat.o(190076);
      return true;
    }
    AppMethodBeat.o(190076);
    return false;
  }
  
  public final void i(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(190074);
    if (paramBoolean)
    {
      this.gzV.setVisibility(8);
      this.gzO.setVisibility(8);
      this.gzK.setVisibility(8);
      if (aly()) {}
      for (paramInt = ap.cl(this.gnb.getContext()).y - paramInt - com.tencent.mm.cc.a.au(this.gnb.getContext(), 2131165289);; paramInt = ap.cl(this.gnb.getContext()).y - paramInt - ap.ej(this.gnb.getContext()) - com.tencent.mm.cc.a.au(this.gnb.getContext(), 2131165289))
      {
        Object localObject1 = new int[2];
        this.gzT.getLocationOnScreen((int[])localObject1);
        int i = localObject1[1];
        int j = this.gzT.getHeight();
        this.gzT.animate().translationY(paramInt - (i + j)).start();
        localObject1 = this.gzL;
        Object localObject2 = this.gnb.getContext();
        d.g.b.k.g(localObject2, "root.context");
        ((EditText)localObject1).setBackground(((Context)localObject2).getResources().getDrawable(2131101053));
        this.gzL.setPadding(0, 0, 0, 0);
        this.gzL.setHint((CharSequence)" ");
        this.gzL.setCursorVisible(true);
        this.gzQ.setVisibility(0);
        localObject1 = this.gzL.getText();
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
        paramInt = f.a((String)localObject1, com.tencent.mm.ui.tools.f.a.IRJ);
        this.gzQ.setText((CharSequence)String.valueOf(28 - paramInt));
        this.gzR.setVisibility(0);
        this.gzS.setVisibility(0);
        AppMethodBeat.o(190074);
        return;
      }
    }
    this.gzV.setVisibility(0);
    this.gzO.setVisibility(0);
    this.gzK.setVisibility(0);
    this.gzT.animate().translationY(0.0F).start();
    this.gzL.setBackground(this.gzY);
    com.tencent.mm.cc.a.au(this.gnb.getContext(), 2131165294);
    paramInt = com.tencent.mm.cc.a.au(this.gnb.getContext(), 2131165303);
    this.gzL.setPadding(0, 0, 0, paramInt);
    this.gzL.setHint((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.b(this.gnb.getContext(), (CharSequence)this.gnb.getContext().getString(2131766574, new Object[] { this.gzX }), this.gzL.getTextSize()));
    this.gzL.setCursorVisible(false);
    this.gzQ.setVisibility(8);
    this.gzR.setVisibility(8);
    this.gzS.setVisibility(8);
    AppMethodBeat.o(190074);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class a
    implements f.c
  {
    public static final a gAa;
    
    static
    {
      AppMethodBeat.i(190072);
      gAa = new a();
      AppMethodBeat.o(190072);
    }
    
    public final void d(boolean paramBoolean, String paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.k
 * JD-Core Version:    0.7.0.1
 */