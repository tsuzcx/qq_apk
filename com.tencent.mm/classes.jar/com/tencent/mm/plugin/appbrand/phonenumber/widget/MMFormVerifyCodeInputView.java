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
import com.tencent.luggage.l.a.c;
import com.tencent.luggage.l.a.d;
import com.tencent.luggage.l.a.g;
import com.tencent.luggage.l.a.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

public class MMFormVerifyCodeInputView
  extends LinearLayout
{
  private View.OnFocusChangeListener jQt;
  private int layout;
  private Context mContext;
  private TextView mNb;
  private Button nds;
  private EditText qDO;
  private TextView qDP;
  private int qDQ;
  private int qDR;
  private int qDS;
  private int qDT;
  private int qDU;
  private int[] qDV;
  private View.OnClickListener qDW;
  private MTimerHandler timerHandler;
  
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
    this.qDQ = -1;
    this.qDR = -1;
    this.qDS = -1;
    this.layout = -1;
    this.qDT = 60;
    this.qDU = this.qDT;
    this.jQt = null;
    this.qDW = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.i.FormItemView, paramInt, 0);
    this.qDR = paramAttributeSet.getResourceId(a.i.FormItemView_form_hint, -1);
    this.qDQ = paramAttributeSet.getResourceId(a.i.FormItemView_form_title, -1);
    this.qDS = paramAttributeSet.getResourceId(a.i.FormItemView_form_btn_title, -1);
    this.layout = paramAttributeSet.getResourceId(a.i.FormItemView_form_layout, this.layout);
    paramAttributeSet.recycle();
    inflate(paramContext, this.layout, this);
    this.mContext = paramContext;
    AppMethodBeat.o(169516);
  }
  
  public final void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(169529);
    if (this.qDO != null)
    {
      this.qDO.addTextChangedListener(paramTextWatcher);
      AppMethodBeat.o(169529);
      return;
    }
    Log.w("MicroMsg.MMFormVerifyCodeInputView", "watcher : %s, contentET : %s", new Object[] { paramTextWatcher, this.qDO });
    AppMethodBeat.o(169529);
  }
  
  public final void cgz()
  {
    AppMethodBeat.i(169526);
    this.nds.setVisibility(8);
    this.qDP.setVisibility(0);
    this.qDP.setText(getContext().getString(a.g.appbrand_mobile_input_send_sms_timer_title, new Object[] { Integer.valueOf(this.qDT) }));
    if (this.timerHandler != null)
    {
      this.timerHandler.stopTimer();
      this.timerHandler.startTimer(1000L);
      AppMethodBeat.o(169526);
      return;
    }
    if (getContext() != null)
    {
      this.timerHandler = new MTimerHandler(getContext().getMainLooper(), new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(169515);
          MMFormVerifyCodeInputView.f(MMFormVerifyCodeInputView.this);
          MMFormVerifyCodeInputView.h(MMFormVerifyCodeInputView.this).setText(MMFormVerifyCodeInputView.this.getContext().getString(a.g.appbrand_mobile_input_send_sms_timer_title, new Object[] { Integer.valueOf(MMFormVerifyCodeInputView.g(MMFormVerifyCodeInputView.this)) }));
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
      this.timerHandler.startTimer(1000L);
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
    return this.qDO;
  }
  
  public Editable getText()
  {
    AppMethodBeat.i(169530);
    if (this.qDO != null)
    {
      Editable localEditable = this.qDO.getText();
      AppMethodBeat.o(169530);
      return localEditable;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(169530);
    return null;
  }
  
  public TextView getTitleTextView()
  {
    return this.mNb;
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(169517);
    super.onFinishInflate();
    this.mNb = ((TextView)findViewById(a.d.title));
    this.qDO = ((EditText)findViewById(a.d.edittext));
    this.qDP = ((TextView)findViewById(a.d.timer));
    this.nds = ((Button)findViewById(a.d.send_verify_code_btn));
    if ((this.mNb == null) || (this.qDO == null) || (this.qDP == null) || (this.nds == null)) {
      Log.w("MicroMsg.MMFormVerifyCodeInputView", "titleTV : %s, contentET : %s, timerTv: %s, sendSmsBtn: %s", new Object[] { this.mNb, this.qDO, this.qDP, this.nds });
    }
    for (;;)
    {
      if (this.qDO != null)
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
                break label74;
              }
              MMFormVerifyCodeInputView.this.setBackgroundResource(a.c.input_bar_bg_active);
            }
            for (;;)
            {
              MMFormVerifyCodeInputView.c(MMFormVerifyCodeInputView.this);
              if (MMFormVerifyCodeInputView.d(MMFormVerifyCodeInputView.this) != null) {
                MMFormVerifyCodeInputView.d(MMFormVerifyCodeInputView.this).onFocusChange(paramAnonymousView, paramAnonymousBoolean);
              }
              AppMethodBeat.o(169513);
              return;
              label74:
              MMFormVerifyCodeInputView.this.setBackgroundResource(a.c.input_bar_bg_normal);
            }
          }
        };
        this.qDO.setOnFocusChangeListener(local1);
      }
      if (this.nds != null) {
        this.nds.setOnClickListener(new MMFormVerifyCodeInputView.2(this));
      }
      AppMethodBeat.o(169517);
      return;
      if (this.qDQ != -1) {
        this.mNb.setText(this.qDQ);
      }
      if (this.qDR != -1) {
        this.qDO.setHint(this.qDR);
      }
      if (this.qDS != -1) {
        this.nds.setText(this.qDS);
      }
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(169527);
    if (this.timerHandler != null) {
      this.timerHandler.stopTimer();
    }
    this.qDO.setText("");
    this.qDP.setVisibility(8);
    this.qDU = this.qDT;
    this.nds.setVisibility(0);
    AppMethodBeat.o(169527);
  }
  
  public void setFocusListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.jQt = paramOnFocusChangeListener;
  }
  
  public void setHint(int paramInt)
  {
    AppMethodBeat.i(169521);
    if (this.qDO != null)
    {
      this.qDO.setHint(paramInt);
      AppMethodBeat.o(169521);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(169521);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(169519);
    if (this.qDO != null)
    {
      this.qDO.setHint(paramString);
      AppMethodBeat.o(169519);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(169519);
  }
  
  public void setImeOption(int paramInt)
  {
    AppMethodBeat.i(169523);
    if (this.qDO != null)
    {
      this.qDO.setImeOptions(paramInt);
      AppMethodBeat.o(169523);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(169523);
  }
  
  public void setInputType(int paramInt)
  {
    AppMethodBeat.i(169528);
    if (this.qDO != null)
    {
      this.qDO.setInputType(paramInt);
      AppMethodBeat.o(169528);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(169528);
  }
  
  public void setSendSmsBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.qDW = paramOnClickListener;
  }
  
  public void setSmsBtnText(int paramInt)
  {
    AppMethodBeat.i(169524);
    if (this.nds != null)
    {
      this.nds.setText(paramInt);
      AppMethodBeat.o(169524);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "sendSmsBtn is null!");
    AppMethodBeat.o(169524);
  }
  
  public void setSmsBtnText(String paramString)
  {
    AppMethodBeat.i(169525);
    if (this.nds != null)
    {
      this.nds.setText(paramString);
      AppMethodBeat.o(169525);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "sendSmsBtn is null!");
    AppMethodBeat.o(169525);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(169522);
    if (this.qDO != null)
    {
      this.qDO.setText(paramString);
      AppMethodBeat.o(169522);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(169522);
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(169520);
    if (this.mNb != null)
    {
      this.mNb.setText(paramInt);
      AppMethodBeat.o(169520);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "titleTV is null!");
    AppMethodBeat.o(169520);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(169518);
    if (this.mNb != null)
    {
      this.mNb.setText(paramString);
      AppMethodBeat.o(169518);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "titleTV is null!");
    AppMethodBeat.o(169518);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.widget.MMFormVerifyCodeInputView
 * JD-Core Version:    0.7.0.1
 */