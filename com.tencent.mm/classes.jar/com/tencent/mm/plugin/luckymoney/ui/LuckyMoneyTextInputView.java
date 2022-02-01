package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.text.InputFilter;
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
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.widget.MMEditText;

public class LuckyMoneyTextInputView
  extends LinearLayout
  implements d
{
  LinearLayout ENV;
  ImageView ENW;
  BaseEmojiView ENX;
  private View.OnClickListener ENY;
  private h EtX;
  MMEditText Evu;
  private TextView pPT;
  
  public LuckyMoneyTextInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(65933);
    paramContext = LayoutInflater.from(paramContext).inflate(a.g.lucky_money_text_input_view, this, true);
    this.Evu = ((MMEditText)paramContext.findViewById(a.f.lucky_money_text));
    this.pPT = ((TextView)paramContext.findViewById(a.f.lucky_money_text_input_title));
    this.ENV = ((LinearLayout)paramContext.findViewById(a.f.lucky_money_emoji_area));
    this.ENW = ((ImageView)paramContext.findViewById(a.f.lucky_money_emoji_bt));
    this.ENX = ((BaseEmojiView)paramContext.findViewById(a.f.lucky_money_emoji));
    this.Evu.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(65931);
        if (LuckyMoneyTextInputView.a(LuckyMoneyTextInputView.this) != null)
        {
          paramAnonymousView = LuckyMoneyTextInputView.a(LuckyMoneyTextInputView.this);
          LuckyMoneyTextInputView.this.getInputViewId();
          paramAnonymousView.eOd();
        }
        AppMethodBeat.o(65931);
      }
    });
    this.ENV.setOnClickListener(new LuckyMoneyTextInputView.2(this));
    this.ENV.setVisibility(8);
    this.ENW.setContentDescription(paramContext.getContext().getString(a.i.lucky_money_add_expression));
    this.Evu.setMaxLines(2147483647);
    this.Evu.setFilters(new InputFilter[0]);
    AppMethodBeat.o(65933);
  }
  
  public final void C(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(65938);
    this.ENV.setTag("delete");
    this.ENW.setVisibility(8);
    this.ENX.setVisibility(0);
    this.ENX.setEmojiInfo(paramEmojiInfo);
    AppMethodBeat.o(65938);
  }
  
  public final String VJ(int paramInt)
  {
    return null;
  }
  
  public final int eOc()
  {
    return 0;
  }
  
  public String getInput()
  {
    AppMethodBeat.i(65934);
    String str = this.Evu.getText().toString();
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
  
  public final void onError() {}
  
  public final void restore() {}
  
  public void setHintText(String paramString)
  {
    AppMethodBeat.i(65935);
    this.Evu.setHint(paramString);
    AppMethodBeat.o(65935);
  }
  
  public void setOnInputValidChangerListener(h paramh)
  {
    this.EtX = paramh;
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(65936);
    this.pPT.setText(paramString);
    AppMethodBeat.o(65936);
  }
  
  public void setmOnEmojiSelectClickListener(View.OnClickListener paramOnClickListener)
  {
    this.ENY = paramOnClickListener;
  }
  
  public final void tU(boolean paramBoolean)
  {
    AppMethodBeat.i(65937);
    if (paramBoolean)
    {
      this.ENV.setVisibility(8);
      AppMethodBeat.o(65937);
      return;
    }
    this.ENV.setVisibility(0);
    this.ENW.setVisibility(0);
    this.ENX.setVisibility(8);
    AppMethodBeat.o(65937);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView
 * JD-Core Version:    0.7.0.1
 */