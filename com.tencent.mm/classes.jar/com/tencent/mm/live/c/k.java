package com.tencent.mm.live.c;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.core.core.b.d;
import com.tencent.mm.model.u;
import com.tencent.mm.protocal.protobuf.eas;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.af;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import d.l;
import d.n.n;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/plugin/LiveBeforePlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/widget/RelativeLayout;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "MAX_TITLE_TEXT_NUM", "", "TAG", "", "closeBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "hostString", "liveRoomIdEdit", "Landroid/widget/EditText;", "liveTitleEdit", "liveTitleEditCancel", "Landroid/widget/TextView;", "liveTitleEditOk", "Landroid/widget/Button;", "liveTitleEditTextNumHint", "mTopicName", "startLiveBtn", "switchBtn", "titleEditBackground", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "titleTip", "topGroup", "Landroid/view/ViewGroup;", "checkLiveName", "", "liveName", "createLive", "", "enableTestRoomId", "keyboardChange", "show", "height", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class k
  extends a
{
  final b IIs;
  final int Kuf;
  private final Button Kug;
  private final TextView Kuh;
  final EditText Kui;
  private final WeImageView Kuj;
  private final WeImageView Kuk;
  private final ViewGroup Kul;
  final EditText Kum;
  final TextView Kun;
  private final TextView Kuo;
  private final Button Kup;
  String Kuq;
  String Kur;
  private Drawable Kus;
  private final String TAG;
  
  public k(final RelativeLayout paramRelativeLayout, b paramb)
  {
    super((ViewGroup)paramRelativeLayout, paramb);
    AppMethodBeat.i(202868);
    this.IIs = paramb;
    this.TAG = "MicroMsg.LiveBeforePlugin";
    this.Kuf = 14;
    paramb = paramRelativeLayout.findViewById(2131307508);
    d.g.b.k.g(paramb, "root.findViewById(R.id.l…before_content_start_btn)");
    this.Kug = ((Button)paramb);
    paramb = paramRelativeLayout.findViewById(2131307509);
    d.g.b.k.g(paramb, "root.findViewById<TextVi….live_before_content_tip)");
    this.Kuh = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307510);
    d.g.b.k.g(paramb, "root.findViewById(R.id.l…efore_content_title_edit)");
    this.Kui = ((EditText)paramb);
    paramb = paramRelativeLayout.findViewById(2131307511);
    d.g.b.k.g(paramb, "root.findViewById(R.id.live_before_top_close)");
    this.Kuj = ((WeImageView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307513);
    d.g.b.k.g(paramb, "root.findViewById(R.id.live_before_top_switch)");
    this.Kuk = ((WeImageView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307512);
    d.g.b.k.g(paramb, "root.findViewById(R.id.live_before_top_group)");
    this.Kul = ((ViewGroup)paramb);
    paramb = paramRelativeLayout.findViewById(2131307507);
    d.g.b.k.g(paramb, "root.findViewById(R.id.l…fore_content_roomid_edit)");
    this.Kum = ((EditText)paramb);
    paramb = paramRelativeLayout.findViewById(2131307896);
    d.g.b.k.g(paramb, "root.findViewById(R.id.title_edit_text_num_hint)");
    this.Kun = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307721);
    d.g.b.k.g(paramb, "root.findViewById(R.id.live_title_edit_cancel)");
    this.Kuo = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307722);
    d.g.b.k.g(paramb, "root.findViewById(R.id.live_title_edit_ok)");
    this.Kup = ((Button)paramb);
    this.Kuq = "";
    this.Kur = "";
    this.Kus = this.Kui.getBackground();
    paramb = u.arm();
    Object localObject;
    if (paramb != null)
    {
      localObject = paramb.ZX();
      paramb = (b)localObject;
      if (localObject != null) {}
    }
    else
    {
      paramb = "";
    }
    this.Kur = paramb;
    this.Kui.setHint((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.b(paramRelativeLayout.getContext(), (CharSequence)paramRelativeLayout.getContext().getString(2131766553, new Object[] { this.Kur }), this.Kui.getTextSize()));
    this.Kui.setOnEditorActionListener((TextView.OnEditorActionListener)new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(202856);
        if (6 != paramAnonymousInt)
        {
          d.g.b.k.g(paramAnonymousKeyEvent, "keyEvent");
          if (paramAnonymousKeyEvent.getAction() != 66) {}
        }
        else
        {
          paramAnonymousTextView = this.IIt.getContext();
          if (paramAnonymousTextView == null)
          {
            paramAnonymousTextView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(202856);
            throw paramAnonymousTextView;
          }
          ((MMActivity)paramAnonymousTextView).hideVKB();
        }
        AppMethodBeat.o(202856);
        return false;
      }
    });
    this.Kuj.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(202857);
        b.b.a(this.Kut.IIs, b.c.FAX);
        AppMethodBeat.o(202857);
      }
    });
    this.Kuk.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(202858);
        this.Kut.IIs.a(b.c.FAY, new Bundle());
        AppMethodBeat.o(202858);
      }
    });
    this.Kug.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(202859);
        k localk = this.Kut;
        paramAnonymousView = (CharSequence)localk.Kui.getText();
        if ((paramAnonymousView == null) || (n.aC(paramAnonymousView)))
        {
          i = 1;
          if (i == 0) {
            break label111;
          }
          paramAnonymousView = "";
          label41:
          if (!k.fOS()) {
            break label125;
          }
        }
        label111:
        label125:
        for (int i = Integer.parseInt(localk.Kum.getText().toString());; i = -1)
        {
          Bundle localBundle = new Bundle();
          localBundle.putInt("PARAM_LIVE_TEST_ROOM_ID", i);
          localBundle.putString("PARAM_START_LIVE_TITLE", paramAnonymousView);
          localk.IIs.a(b.c.HRT, localBundle);
          AppMethodBeat.o(202859);
          return;
          i = 0;
          break;
          paramAnonymousView = localk.Kui.getText().toString();
          break label41;
        }
      }
    });
    paramb = this.Kum;
    if (fOS()) {}
    for (int i = 0;; i = 8)
    {
      paramb.setVisibility(i);
      paramb = this.Kum;
      localObject = d.qzw;
      paramb.setText((CharSequence)String.valueOf(d.cns().roomId));
      this.Kui.addTextChangedListener((TextWatcher)new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(202860);
          TextView localTextView = this.Kut.Kun;
          StringBuilder localStringBuilder = new StringBuilder();
          paramAnonymousEditable = this.Kut.Kui.getText();
          if (paramAnonymousEditable != null)
          {
            paramAnonymousEditable = Integer.valueOf(paramAnonymousEditable.length());
            localTextView.setText((CharSequence)(paramAnonymousEditable + '/' + this.Kut.Kuf));
            paramAnonymousEditable = this.Kut.Kui.getText();
            if (paramAnonymousEditable == null) {
              break label214;
            }
          }
          label214:
          for (int i = paramAnonymousEditable.length();; i = 0)
          {
            if (i > this.Kut.Kuf)
            {
              this.Kut.Kui.setText(this.Kut.Kui.getText().subSequence(0, this.Kut.Kuf));
              this.Kut.Kui.setSelection(this.Kut.Kui.getText().length());
            }
            paramAnonymousEditable = f.rGw;
            f.eNG().LwZ = this.Kut.Kui.getText().toString();
            paramAnonymousEditable = f.rGw;
            f.kQ(true);
            com.tencent.mm.live.d.a.fPk();
            AppMethodBeat.o(202860);
            return;
            paramAnonymousEditable = null;
            break;
          }
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.Kui.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(202861);
          this.Kut.Kuq = this.Kut.Kui.getText().toString();
          AppMethodBeat.o(202861);
        }
      });
      this.Kuo.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(202862);
          if (n.aC((CharSequence)this.Kut.Kuq))
          {
            this.Kut.Kui.setHint((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.b(paramRelativeLayout.getContext(), (CharSequence)paramRelativeLayout.getContext().getString(2131766553, new Object[] { this.Kut.Kur }), this.Kut.Kui.getTextSize()).toString());
            this.Kut.Kui.setText(null);
            paramAnonymousView = f.rGw;
          }
          for (f.eNG().LwZ = com.tencent.mm.pluginsdk.ui.span.k.b(paramRelativeLayout.getContext(), (CharSequence)paramRelativeLayout.getContext().getString(2131766553, new Object[] { this.Kut.Kur }), this.Kut.Kui.getTextSize()).toString();; f.eNG().LwZ = this.Kut.Kui.getText().toString())
          {
            paramAnonymousView = f.rGw;
            f.kQ(false);
            paramAnonymousView = paramRelativeLayout.getContext();
            if (paramAnonymousView != null) {
              break;
            }
            paramAnonymousView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(202862);
            throw paramAnonymousView;
            this.Kut.Kui.setText((CharSequence)this.Kut.Kuq);
            paramAnonymousView = f.rGw;
          }
          ((MMActivity)paramAnonymousView).hideVKB();
          AppMethodBeat.o(202862);
        }
      });
      this.Kup.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(202863);
          paramAnonymousView = this.IIt.getContext();
          if (paramAnonymousView == null)
          {
            paramAnonymousView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(202863);
            throw paramAnonymousView;
          }
          ((MMActivity)paramAnonymousView).hideVKB();
          AppMethodBeat.o(202863);
        }
      });
      AppMethodBeat.o(202868);
      return;
    }
  }
  
  static boolean fOS()
  {
    AppMethodBeat.i(202865);
    com.tencent.mm.kernel.e locale = g.afB();
    d.g.b.k.g(locale, "MMKernel.storage()");
    if (locale.afk().getInt(ae.a.LBE, 0) == 1)
    {
      AppMethodBeat.o(202865);
      return true;
    }
    AppMethodBeat.o(202865);
    return false;
  }
  
  public final void X(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(202866);
    if (paramBoolean)
    {
      this.Kul.setVisibility(8);
      this.Kug.setVisibility(8);
      localObject1 = this.Kui.getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(202866);
        throw ((Throwable)localObject1);
      }
      localObject1 = (RelativeLayout.LayoutParams)localObject1;
      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = (com.tencent.mm.cd.a.ao(this.pTc.getContext(), 2131165289) + paramInt);
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = com.tencent.mm.cd.a.ao(this.pTc.getContext(), 2131165292);
      ((RelativeLayout.LayoutParams)localObject1).addRule(9, -1);
      ((RelativeLayout.LayoutParams)localObject1).addRule(14, 0);
      this.Kui.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = this.Kui;
      Object localObject2 = this.pTc.getContext();
      d.g.b.k.g(localObject2, "root.context");
      ((EditText)localObject1).setBackground(((Context)localObject2).getResources().getDrawable(2131101053));
      this.Kui.setPadding(0, 0, 0, 0);
      this.Kun.setVisibility(0);
      localObject2 = this.Kun;
      StringBuilder localStringBuilder = new StringBuilder();
      localObject1 = this.Kui.getText();
      if (localObject1 != null) {}
      for (localObject1 = Integer.valueOf(((Editable)localObject1).length());; localObject1 = null)
      {
        ((TextView)localObject2).setText((CharSequence)(localObject1 + '/' + this.Kuf));
        this.Kuo.setVisibility(0);
        this.Kup.setVisibility(0);
        AppMethodBeat.o(202866);
        return;
      }
    }
    this.Kul.setVisibility(0);
    this.Kug.setVisibility(0);
    Object localObject1 = this.Kui.getLayoutParams();
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(202866);
      throw ((Throwable)localObject1);
    }
    localObject1 = (RelativeLayout.LayoutParams)localObject1;
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cd.a.ao(this.pTc.getContext(), 2131165275);
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = 0;
    ((RelativeLayout.LayoutParams)localObject1).addRule(9, 0);
    ((RelativeLayout.LayoutParams)localObject1).addRule(14, -1);
    this.Kui.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.Kui.setBackground(this.Kus);
    paramInt = com.tencent.mm.cd.a.ao(this.pTc.getContext(), 2131165294);
    int i = com.tencent.mm.cd.a.ao(this.pTc.getContext(), 2131165303);
    this.Kui.setPadding(paramInt, 0, paramInt, i);
    this.Kun.setVisibility(8);
    this.Kuo.setVisibility(8);
    this.Kup.setVisibility(8);
    AppMethodBeat.o(202866);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(202867);
    d.g.b.k.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (l.ciE[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(202867);
      return;
      agK(8);
      AppMethodBeat.o(202867);
      return;
      paramc = f.rGw;
      paramBundle = f.eNG();
      paramc = (CharSequence)this.Kui.getText();
      if ((paramc == null) || (n.aC(paramc)))
      {
        i = 1;
        if (i == 0) {
          break label197;
        }
      }
      label197:
      for (paramc = com.tencent.mm.pluginsdk.ui.span.k.b(this.pTc.getContext(), (CharSequence)this.pTc.getContext().getString(2131766553, new Object[] { this.Kur }), this.Kui.getTextSize()).toString();; paramc = this.Kui.getText().toString())
      {
        paramBundle.LwZ = paramc;
        paramc = f.rGw;
        f.kX(false);
        agK(0);
        AppMethodBeat.o(202867);
        return;
        i = 0;
        break;
      }
      paramc = f.rGw;
      if (f.fvH()) {}
      for (int i = 3;; i = 2)
      {
        paramc = f.rGw;
        paramc = f.eNB();
        paramBundle = f.rGw;
        boolean bool1 = f.fiE();
        paramBundle = f.rGw;
        boolean bool2 = f.fiF();
        paramBundle = f.rGw;
        paramBundle = f.eNG().LwZ;
        Object localObject = f.rGw;
        boolean bool3 = f.fhK();
        localObject = this.pTc.getResources();
        d.g.b.k.g(localObject, "root.resources");
        com.tencent.mm.live.d.e.a(paramc, bool1, bool2, paramBundle, bool3, ((Resources)localObject).getConfiguration().orientation, i);
        com.tencent.mm.live.d.a.fPj();
        AppMethodBeat.o(202867);
        return;
      }
      com.tencent.mm.live.d.a.fPi();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.c.k
 * JD-Core Version:    0.7.0.1
 */