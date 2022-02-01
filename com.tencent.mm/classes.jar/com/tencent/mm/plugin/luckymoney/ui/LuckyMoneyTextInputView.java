package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.widget.MMEditText;

public class LuckyMoneyTextInputView
  extends LinearLayout
  implements c
{
  private TextView lfN;
  private g ugV;
  private MMEditText uiu;
  LinearLayout uyB;
  ImageView uyC;
  BaseEmojiView uyD;
  private View.OnClickListener uyE;
  
  public LuckyMoneyTextInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(65933);
    paramContext = LayoutInflater.from(paramContext).inflate(2131494660, this, true);
    this.uiu = ((MMEditText)paramContext.findViewById(2131301944));
    this.lfN = ((TextView)paramContext.findViewById(2131301945));
    this.uyB = ((LinearLayout)paramContext.findViewById(2131301794));
    this.uyC = ((ImageView)paramContext.findViewById(2131301795));
    this.uyD = ((BaseEmojiView)paramContext.findViewById(2131301793));
    this.uiu.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(65931);
        if (LuckyMoneyTextInputView.a(LuckyMoneyTextInputView.this) != null)
        {
          paramAnonymousView = LuckyMoneyTextInputView.a(LuckyMoneyTextInputView.this);
          LuckyMoneyTextInputView.this.getInputViewId();
          paramAnonymousView.cYF();
        }
        AppMethodBeat.o(65931);
      }
    });
    this.uyB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65932);
        if (LuckyMoneyTextInputView.b(LuckyMoneyTextInputView.this) != null) {
          LuckyMoneyTextInputView.b(LuckyMoneyTextInputView.this).onClick(paramAnonymousView);
        }
        AppMethodBeat.o(65932);
      }
    });
    this.uyB.setVisibility(8);
    AppMethodBeat.o(65933);
  }
  
  public final void A(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(65938);
    this.uyB.setTag("delete");
    this.uyC.setVisibility(8);
    this.uyD.setVisibility(0);
    this.uyD.setEmojiInfo(paramEmojiInfo);
    AppMethodBeat.o(65938);
  }
  
  public final String HD(int paramInt)
  {
    return null;
  }
  
  public final int cYE()
  {
    return 0;
  }
  
  public String getInput()
  {
    AppMethodBeat.i(65934);
    String str = this.uiu.getText().toString();
    AppMethodBeat.o(65934);
    return str;
  }
  
  public int getInputViewId()
  {
    AppMethodBeat.i(65939);
    int i = getId();
    AppMethodBeat.o(65939);
    return i;
  }
  
  public final void nL(boolean paramBoolean)
  {
    AppMethodBeat.i(65937);
    if (paramBoolean)
    {
      this.uyB.setVisibility(8);
      AppMethodBeat.o(65937);
      return;
    }
    this.uyB.setVisibility(0);
    this.uyC.setVisibility(0);
    this.uyD.setVisibility(8);
    AppMethodBeat.o(65937);
  }
  
  public final void onError() {}
  
  public final void restore() {}
  
  public void setHintText(String paramString)
  {
    AppMethodBeat.i(65935);
    this.uiu.setHint(paramString);
    AppMethodBeat.o(65935);
  }
  
  public void setOnInputValidChangerListener(g paramg)
  {
    this.ugV = paramg;
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(65936);
    this.lfN.setText(paramString);
    AppMethodBeat.o(65936);
  }
  
  public void setmOnEmojiSelectClickListener(View.OnClickListener paramOnClickListener)
  {
    this.uyE = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView
 * JD-Core Version:    0.7.0.1
 */