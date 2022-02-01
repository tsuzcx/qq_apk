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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

public class MMFormVerifyCodeInputView
  extends LinearLayout
{
  private View.OnFocusChangeListener heD;
  private TextView jVO;
  private Button klC;
  private int layout;
  private Context mContext;
  private EditText nBD;
  private TextView nBE;
  private int nBF;
  private int nBG;
  private int nBH;
  private int nBI;
  private int nBJ;
  private int[] nBK;
  private View.OnClickListener nBL;
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
    this.nBF = -1;
    this.nBG = -1;
    this.nBH = -1;
    this.layout = -1;
    this.nBI = 60;
    this.nBJ = this.nBI;
    this.heD = null;
    this.nBL = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.FormItemView, paramInt, 0);
    this.nBG = paramAttributeSet.getResourceId(1, -1);
    this.nBF = paramAttributeSet.getResourceId(3, -1);
    this.nBH = paramAttributeSet.getResourceId(0, -1);
    this.layout = paramAttributeSet.getResourceId(2, this.layout);
    paramAttributeSet.recycle();
    inflate(paramContext, this.layout, this);
    this.mContext = paramContext;
    AppMethodBeat.o(169516);
  }
  
  public final void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(169529);
    if (this.nBD != null)
    {
      this.nBD.addTextChangedListener(paramTextWatcher);
      AppMethodBeat.o(169529);
      return;
    }
    Log.w("MicroMsg.MMFormVerifyCodeInputView", "watcher : %s, contentET : %s", new Object[] { paramTextWatcher, this.nBD });
    AppMethodBeat.o(169529);
  }
  
  public final void bTu()
  {
    AppMethodBeat.i(169526);
    this.klC.setVisibility(8);
    this.nBE.setVisibility(0);
    this.nBE.setText(getContext().getString(2131756116, new Object[] { Integer.valueOf(this.nBI) }));
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
          MMFormVerifyCodeInputView.h(MMFormVerifyCodeInputView.this).setText(MMFormVerifyCodeInputView.this.getContext().getString(2131756116, new Object[] { Integer.valueOf(MMFormVerifyCodeInputView.g(MMFormVerifyCodeInputView.this)) }));
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
    return this.nBD;
  }
  
  public Editable getText()
  {
    AppMethodBeat.i(169530);
    if (this.nBD != null)
    {
      Editable localEditable = this.nBD.getText();
      AppMethodBeat.o(169530);
      return localEditable;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(169530);
    return null;
  }
  
  public TextView getTitleTextView()
  {
    return this.jVO;
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(169517);
    super.onFinishInflate();
    this.jVO = ((TextView)findViewById(2131309195));
    this.nBD = ((EditText)findViewById(2131299910));
    this.nBE = ((TextView)findViewById(2131309125));
    this.klC = ((Button)findViewById(2131307632));
    if ((this.jVO == null) || (this.nBD == null) || (this.nBE == null) || (this.klC == null)) {
      Log.w("MicroMsg.MMFormVerifyCodeInputView", "titleTV : %s, contentET : %s, timerTv: %s, sendSmsBtn: %s", new Object[] { this.jVO, this.nBD, this.nBE, this.klC });
    }
    for (;;)
    {
      if (this.nBD != null)
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
              MMFormVerifyCodeInputView.this.setBackgroundResource(2131233162);
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
              MMFormVerifyCodeInputView.this.setBackgroundResource(2131233163);
            }
          }
        };
        this.nBD.setOnFocusChangeListener(local1);
      }
      if (this.klC != null) {
        this.klC.setOnClickListener(new MMFormVerifyCodeInputView.2(this));
      }
      AppMethodBeat.o(169517);
      return;
      if (this.nBF != -1) {
        this.jVO.setText(this.nBF);
      }
      if (this.nBG != -1) {
        this.nBD.setHint(this.nBG);
      }
      if (this.nBH != -1) {
        this.klC.setText(this.nBH);
      }
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(169527);
    if (this.timerHandler != null) {
      this.timerHandler.stopTimer();
    }
    this.nBD.setText("");
    this.nBE.setVisibility(8);
    this.nBJ = this.nBI;
    this.klC.setVisibility(0);
    AppMethodBeat.o(169527);
  }
  
  public void setFocusListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.heD = paramOnFocusChangeListener;
  }
  
  public void setHint(int paramInt)
  {
    AppMethodBeat.i(169521);
    if (this.nBD != null)
    {
      this.nBD.setHint(paramInt);
      AppMethodBeat.o(169521);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(169521);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(169519);
    if (this.nBD != null)
    {
      this.nBD.setHint(paramString);
      AppMethodBeat.o(169519);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(169519);
  }
  
  public void setImeOption(int paramInt)
  {
    AppMethodBeat.i(169523);
    if (this.nBD != null)
    {
      this.nBD.setImeOptions(paramInt);
      AppMethodBeat.o(169523);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(169523);
  }
  
  public void setInputType(int paramInt)
  {
    AppMethodBeat.i(169528);
    if (this.nBD != null)
    {
      this.nBD.setInputType(paramInt);
      AppMethodBeat.o(169528);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(169528);
  }
  
  public void setSendSmsBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.nBL = paramOnClickListener;
  }
  
  public void setSmsBtnText(int paramInt)
  {
    AppMethodBeat.i(169524);
    if (this.klC != null)
    {
      this.klC.setText(paramInt);
      AppMethodBeat.o(169524);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "sendSmsBtn is null!");
    AppMethodBeat.o(169524);
  }
  
  public void setSmsBtnText(String paramString)
  {
    AppMethodBeat.i(169525);
    if (this.klC != null)
    {
      this.klC.setText(paramString);
      AppMethodBeat.o(169525);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "sendSmsBtn is null!");
    AppMethodBeat.o(169525);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(169522);
    if (this.nBD != null)
    {
      this.nBD.setText(paramString);
      AppMethodBeat.o(169522);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(169522);
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(169520);
    if (this.jVO != null)
    {
      this.jVO.setText(paramInt);
      AppMethodBeat.o(169520);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "titleTV is null!");
    AppMethodBeat.o(169520);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(169518);
    if (this.jVO != null)
    {
      this.jVO.setText(paramString);
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