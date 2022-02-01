package com.tencent.mm.plugin.appbrand.phonenumber.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.luggage.i.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;

public class MMFormVerifyCodeInputView
  extends LinearLayout
{
  private TextView iYj;
  private Button jnu;
  private int layout;
  private Context mContext;
  private EditText mqR;
  private TextView mqS;
  private int mqT;
  private int mqU;
  private int mqV;
  private int mqW;
  private int mqX;
  private int[] mqY;
  private View.OnFocusChangeListener mqZ;
  private View.OnClickListener mra;
  private aw timerHandler;
  
  public MMFormVerifyCodeInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  @TargetApi(11)
  public MMFormVerifyCodeInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(169516);
    this.mContext = null;
    this.mqT = -1;
    this.mqU = -1;
    this.mqV = -1;
    this.layout = -1;
    this.mqW = 60;
    this.mqX = this.mqW;
    this.mqZ = null;
    this.mra = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.FormItemView, paramInt, 0);
    this.mqU = paramAttributeSet.getResourceId(1, -1);
    this.mqT = paramAttributeSet.getResourceId(3, -1);
    this.mqV = paramAttributeSet.getResourceId(0, -1);
    this.layout = paramAttributeSet.getResourceId(2, this.layout);
    paramAttributeSet.recycle();
    inflate(paramContext, this.layout, this);
    this.mContext = paramContext;
    AppMethodBeat.o(169516);
  }
  
  public final void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(169529);
    if (this.mqR != null)
    {
      this.mqR.addTextChangedListener(paramTextWatcher);
      AppMethodBeat.o(169529);
      return;
    }
    ae.w("MicroMsg.MMFormVerifyCodeInputView", "watcher : %s, contentET : %s", new Object[] { paramTextWatcher, this.mqR });
    AppMethodBeat.o(169529);
  }
  
  public final void bxk()
  {
    AppMethodBeat.i(169526);
    this.jnu.setVisibility(8);
    this.mqS.setVisibility(0);
    this.mqS.setText(getContext().getString(2131756001, new Object[] { Integer.valueOf(this.mqW) }));
    if (this.timerHandler != null)
    {
      this.timerHandler.stopTimer();
      this.timerHandler.ay(1000L, 1000L);
      AppMethodBeat.o(169526);
      return;
    }
    if (getContext() != null)
    {
      this.timerHandler = new aw(getContext().getMainLooper(), new aw.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(169515);
          MMFormVerifyCodeInputView.f(MMFormVerifyCodeInputView.this);
          MMFormVerifyCodeInputView.h(MMFormVerifyCodeInputView.this).setText(MMFormVerifyCodeInputView.this.getContext().getString(2131756001, new Object[] { Integer.valueOf(MMFormVerifyCodeInputView.g(MMFormVerifyCodeInputView.this)) }));
          if (MMFormVerifyCodeInputView.g(MMFormVerifyCodeInputView.this) == 0)
          {
            MMFormVerifyCodeInputView.i(MMFormVerifyCodeInputView.this).stopTimer();
            MMFormVerifyCodeInputView.a(MMFormVerifyCodeInputView.this, MMFormVerifyCodeInputView.j(MMFormVerifyCodeInputView.this));
            MMFormVerifyCodeInputView.k(MMFormVerifyCodeInputView.this).setVisibility(0);
            MMFormVerifyCodeInputView.h(MMFormVerifyCodeInputView.this).setVisibility(8);
          }
          AppMethodBeat.o(169515);
          return true;
        }
      }, true);
      this.timerHandler.ay(1000L, 1000L);
      AppMethodBeat.o(169526);
      return;
    }
    if (this.timerHandler != null) {
      this.timerHandler.stopTimer();
    }
    AppMethodBeat.o(169526);
  }
  
  public EditText getContentEditText()
  {
    return this.mqR;
  }
  
  public Editable getText()
  {
    AppMethodBeat.i(169530);
    if (this.mqR != null)
    {
      Editable localEditable = this.mqR.getText();
      AppMethodBeat.o(169530);
      return localEditable;
    }
    ae.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(169530);
    return null;
  }
  
  public TextView getTitleTextView()
  {
    return this.iYj;
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(169517);
    super.onFinishInflate();
    this.iYj = ((TextView)findViewById(2131305902));
    this.mqR = ((EditText)findViewById(2131299306));
    this.mqS = ((TextView)findViewById(2131305845));
    this.jnu = ((Button)findViewById(2131304586));
    if ((this.iYj == null) || (this.mqR == null) || (this.mqS == null) || (this.jnu == null)) {
      ae.w("MicroMsg.MMFormVerifyCodeInputView", "titleTV : %s, contentET : %s, timerTv: %s, sendSmsBtn: %s", new Object[] { this.iYj, this.mqR, this.mqS, this.jnu });
    }
    for (;;)
    {
      if (this.mqR != null)
      {
        View.OnFocusChangeListener local1 = new View.OnFocusChangeListener()
        {
          public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(169513);
            if (paramAnonymousView == MMFormVerifyCodeInputView.a(MMFormVerifyCodeInputView.this))
            {
              MMFormVerifyCodeInputView.b(MMFormVerifyCodeInputView.this);
              if (!paramAnonymousBoolean) {
                break label73;
              }
              MMFormVerifyCodeInputView.this.setBackgroundResource(2131232723);
            }
            for (;;)
            {
              MMFormVerifyCodeInputView.c(MMFormVerifyCodeInputView.this);
              if (MMFormVerifyCodeInputView.d(MMFormVerifyCodeInputView.this) != null) {
                MMFormVerifyCodeInputView.d(MMFormVerifyCodeInputView.this).onFocusChange(paramAnonymousView, paramAnonymousBoolean);
              }
              AppMethodBeat.o(169513);
              return;
              label73:
              MMFormVerifyCodeInputView.this.setBackgroundResource(2131232724);
            }
          }
        };
        this.mqR.setOnFocusChangeListener(local1);
      }
      if (this.jnu != null) {
        this.jnu.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(169514);
            b localb = new b();
            localb.bd(paramAnonymousView);
            a.b("com/tencent/mm/plugin/appbrand/phonenumber/widget/MMFormVerifyCodeInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if (MMFormVerifyCodeInputView.e(MMFormVerifyCodeInputView.this) != null) {
              MMFormVerifyCodeInputView.e(MMFormVerifyCodeInputView.this).onClick(paramAnonymousView);
            }
            a.a(this, "com/tencent/mm/plugin/appbrand/phonenumber/widget/MMFormVerifyCodeInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(169514);
          }
        });
      }
      AppMethodBeat.o(169517);
      return;
      if (this.mqT != -1) {
        this.iYj.setText(this.mqT);
      }
      if (this.mqU != -1) {
        this.mqR.setHint(this.mqU);
      }
      if (this.mqV != -1) {
        this.jnu.setText(this.mqV);
      }
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(169527);
    if (this.timerHandler != null) {
      this.timerHandler.stopTimer();
    }
    this.mqR.setText("");
    this.mqS.setVisibility(8);
    this.mqX = this.mqW;
    this.jnu.setVisibility(0);
    AppMethodBeat.o(169527);
  }
  
  public void setFocusListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.mqZ = paramOnFocusChangeListener;
  }
  
  public void setHint(int paramInt)
  {
    AppMethodBeat.i(169521);
    if (this.mqR != null)
    {
      this.mqR.setHint(paramInt);
      AppMethodBeat.o(169521);
      return;
    }
    ae.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(169521);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(169519);
    if (this.mqR != null)
    {
      this.mqR.setHint(paramString);
      AppMethodBeat.o(169519);
      return;
    }
    ae.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(169519);
  }
  
  public void setImeOption(int paramInt)
  {
    AppMethodBeat.i(169523);
    if (this.mqR != null)
    {
      this.mqR.setImeOptions(paramInt);
      AppMethodBeat.o(169523);
      return;
    }
    ae.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(169523);
  }
  
  public void setInputType(int paramInt)
  {
    AppMethodBeat.i(169528);
    if (this.mqR != null)
    {
      this.mqR.setInputType(paramInt);
      AppMethodBeat.o(169528);
      return;
    }
    ae.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(169528);
  }
  
  public void setSendSmsBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mra = paramOnClickListener;
  }
  
  public void setSmsBtnText(int paramInt)
  {
    AppMethodBeat.i(169524);
    if (this.jnu != null)
    {
      this.jnu.setText(paramInt);
      AppMethodBeat.o(169524);
      return;
    }
    ae.e("MicroMsg.MMFormVerifyCodeInputView", "sendSmsBtn is null!");
    AppMethodBeat.o(169524);
  }
  
  public void setSmsBtnText(String paramString)
  {
    AppMethodBeat.i(169525);
    if (this.jnu != null)
    {
      this.jnu.setText(paramString);
      AppMethodBeat.o(169525);
      return;
    }
    ae.e("MicroMsg.MMFormVerifyCodeInputView", "sendSmsBtn is null!");
    AppMethodBeat.o(169525);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(169522);
    if (this.mqR != null)
    {
      this.mqR.setText(paramString);
      AppMethodBeat.o(169522);
      return;
    }
    ae.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(169522);
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(169520);
    if (this.iYj != null)
    {
      this.iYj.setText(paramInt);
      AppMethodBeat.o(169520);
      return;
    }
    ae.e("MicroMsg.MMFormVerifyCodeInputView", "titleTV is null!");
    AppMethodBeat.o(169520);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(169518);
    if (this.iYj != null)
    {
      this.iYj.setText(paramString);
      AppMethodBeat.o(169518);
      return;
    }
    ae.e("MicroMsg.MMFormVerifyCodeInputView", "titleTV is null!");
    AppMethodBeat.o(169518);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.widget.MMFormVerifyCodeInputView
 * JD-Core Version:    0.7.0.1
 */