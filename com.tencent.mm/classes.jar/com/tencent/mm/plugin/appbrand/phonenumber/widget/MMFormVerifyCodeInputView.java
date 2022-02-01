package com.tencent.mm.plugin.appbrand.phonenumber.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.luggage.m.a.b;
import com.tencent.luggage.m.a.c;
import com.tencent.luggage.m.a.d;
import com.tencent.luggage.m.a.g;
import com.tencent.luggage.m.a.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

public class MMFormVerifyCodeInputView
  extends LinearLayout
{
  private int layout;
  private Context mContext;
  private View.OnFocusChangeListener mpk;
  private TextView pJJ;
  public Button qaJ;
  public EditText tID;
  public TextView tIE;
  private int tIF;
  private int tIG;
  private int tIH;
  public int tII;
  public int tIJ;
  private int[] tIK;
  private View.OnClickListener tIL;
  public MTimerHandler timerHandler;
  
  public MMFormVerifyCodeInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MMFormVerifyCodeInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(169516);
    this.mContext = null;
    this.tIF = -1;
    this.tIG = -1;
    this.tIH = -1;
    this.layout = -1;
    this.tII = 60;
    this.tIJ = this.tII;
    this.mpk = null;
    this.tIL = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.i.FormItemView, paramInt, 0);
    this.tIG = paramAttributeSet.getResourceId(a.i.FormItemView_form_hint, -1);
    this.tIF = paramAttributeSet.getResourceId(a.i.FormItemView_form_title, -1);
    this.tIH = paramAttributeSet.getResourceId(a.i.FormItemView_form_btn_title, -1);
    this.layout = paramAttributeSet.getResourceId(a.i.FormItemView_form_layout, this.layout);
    paramAttributeSet.recycle();
    inflate(paramContext, this.layout, this);
    this.mContext = paramContext;
    AppMethodBeat.o(169516);
  }
  
  public EditText getContentEditText()
  {
    return this.tID;
  }
  
  public Editable getText()
  {
    AppMethodBeat.i(169530);
    if (this.tID != null)
    {
      Editable localEditable = this.tID.getText();
      AppMethodBeat.o(169530);
      return localEditable;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(169530);
    return null;
  }
  
  public TextView getTitleTextView()
  {
    return this.pJJ;
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(169517);
    super.onFinishInflate();
    this.pJJ = ((TextView)findViewById(a.d.title));
    this.tID = ((EditText)findViewById(a.d.edittext));
    this.tIE = ((TextView)findViewById(a.d.timer));
    this.qaJ = ((Button)findViewById(a.d.send_verify_code_btn));
    if ((this.pJJ == null) || (this.tID == null) || (this.tIE == null) || (this.qaJ == null)) {
      Log.w("MicroMsg.MMFormVerifyCodeInputView", "titleTV : %s, contentET : %s, timerTv: %s, sendSmsBtn: %s", new Object[] { this.pJJ, this.tID, this.tIE, this.qaJ });
    }
    for (;;)
    {
      if (this.tID != null)
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
        this.tID.setOnFocusChangeListener(local1);
      }
      if (this.qaJ != null)
      {
        c.a(this.qaJ, null, Integer.valueOf(a.b.Edge_1_5_A));
        this.qaJ.setOnClickListener(new MMFormVerifyCodeInputView.2(this));
      }
      AppMethodBeat.o(169517);
      return;
      if (this.tIF != -1) {
        this.pJJ.setText(this.tIF);
      }
      if (this.tIG != -1) {
        this.tID.setHint(this.tIG);
      }
      if (this.tIH != -1) {
        this.qaJ.setText(this.tIH);
      }
    }
  }
  
  public void setFocusListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.mpk = paramOnFocusChangeListener;
  }
  
  public void setHint(int paramInt)
  {
    AppMethodBeat.i(169521);
    if (this.tID != null)
    {
      this.tID.setHint(paramInt);
      AppMethodBeat.o(169521);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(169521);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(169519);
    if (this.tID != null)
    {
      this.tID.setHint(paramString);
      AppMethodBeat.o(169519);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(169519);
  }
  
  public void setImeOption(int paramInt)
  {
    AppMethodBeat.i(169523);
    if (this.tID != null)
    {
      this.tID.setImeOptions(paramInt);
      AppMethodBeat.o(169523);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(169523);
  }
  
  public void setInputType(int paramInt)
  {
    AppMethodBeat.i(169528);
    if (this.tID != null)
    {
      this.tID.setInputType(paramInt);
      AppMethodBeat.o(169528);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(169528);
  }
  
  public void setSendSmsBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.tIL = paramOnClickListener;
  }
  
  public void setSmsBtnText(int paramInt)
  {
    AppMethodBeat.i(169524);
    if (this.qaJ != null)
    {
      this.qaJ.setText(paramInt);
      AppMethodBeat.o(169524);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "sendSmsBtn is null!");
    AppMethodBeat.o(169524);
  }
  
  public void setSmsBtnText(String paramString)
  {
    AppMethodBeat.i(169525);
    if (this.qaJ != null)
    {
      this.qaJ.setText(paramString);
      AppMethodBeat.o(169525);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "sendSmsBtn is null!");
    AppMethodBeat.o(169525);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(169522);
    if (this.tID != null)
    {
      this.tID.setText(paramString);
      AppMethodBeat.o(169522);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(169522);
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(169520);
    if (this.pJJ != null)
    {
      this.pJJ.setText(paramInt);
      AppMethodBeat.o(169520);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "titleTV is null!");
    AppMethodBeat.o(169520);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(169518);
    if (this.pJJ != null)
    {
      this.pJJ.setText(paramString);
      AppMethodBeat.o(169518);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "titleTV is null!");
    AppMethodBeat.o(169518);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.widget.MMFormVerifyCodeInputView
 * JD-Core Version:    0.7.0.1
 */