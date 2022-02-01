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
import com.tencent.mm.wallet_core.ui.k;

public class LuckyMoneyTextInputView
  extends LinearLayout
  implements d
{
  LinearLayout KIu;
  ImageView KIv;
  BaseEmojiView KIw;
  private View.OnClickListener KIx;
  private h KmE;
  MMEditText Koc;
  private TextView sUt;
  
  public LuckyMoneyTextInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(65933);
    paramContext = LayoutInflater.from(paramContext).inflate(a.g.lucky_money_text_input_view, this, true);
    this.Koc = ((MMEditText)paramContext.findViewById(a.f.lucky_money_text));
    this.sUt = ((TextView)paramContext.findViewById(a.f.lucky_money_text_input_title));
    this.KIu = ((LinearLayout)paramContext.findViewById(a.f.lucky_money_emoji_area));
    this.KIv = ((ImageView)paramContext.findViewById(a.f.lucky_money_emoji_bt));
    this.KIw = ((BaseEmojiView)paramContext.findViewById(a.f.lucky_money_emoji));
    this.Koc.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(65931);
        if (LuckyMoneyTextInputView.a(LuckyMoneyTextInputView.this) != null)
        {
          paramAnonymousView = LuckyMoneyTextInputView.a(LuckyMoneyTextInputView.this);
          LuckyMoneyTextInputView.this.getInputViewId();
          paramAnonymousView.fWx();
        }
        AppMethodBeat.o(65931);
      }
    });
    this.KIu.setOnClickListener(new k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(284149);
        if (LuckyMoneyTextInputView.b(LuckyMoneyTextInputView.this) != null) {
          LuckyMoneyTextInputView.b(LuckyMoneyTextInputView.this).onClick(paramAnonymousView);
        }
        AppMethodBeat.o(284149);
      }
    });
    this.KIu.setVisibility(8);
    this.KIv.setContentDescription(paramContext.getContext().getString(a.i.lucky_money_add_expression));
    this.Koc.setMaxLines(2147483647);
    this.Koc.setFilters(new InputFilter[0]);
    AppMethodBeat.o(65933);
  }
  
  public final void C(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(65938);
    this.KIu.setTag("delete");
    this.KIv.setVisibility(8);
    this.KIw.setVisibility(0);
    this.KIw.setEmojiInfo(paramEmojiInfo);
    AppMethodBeat.o(65938);
  }
  
  public final String ZF(int paramInt)
  {
    return null;
  }
  
  public final void atR() {}
  
  public final int fWv()
  {
    return 0;
  }
  
  public final int fWw()
  {
    return 0;
  }
  
  public String getInput()
  {
    AppMethodBeat.i(65934);
    String str = this.Koc.getText().toString();
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
  
  public final void restore() {}
  
  public void setHintText(String paramString)
  {
    AppMethodBeat.i(65935);
    this.Koc.setHint(paramString);
    AppMethodBeat.o(65935);
  }
  
  public void setOnInputValidChangerListener(h paramh)
  {
    this.KmE = paramh;
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(65936);
    this.sUt.setText(paramString);
    AppMethodBeat.o(65936);
  }
  
  public void setmOnEmojiSelectClickListener(View.OnClickListener paramOnClickListener)
  {
    this.KIx = paramOnClickListener;
  }
  
  public final void yj(boolean paramBoolean)
  {
    AppMethodBeat.i(65937);
    if (paramBoolean)
    {
      this.KIu.setVisibility(8);
      AppMethodBeat.o(65937);
      return;
    }
    this.KIu.setVisibility(0);
    this.KIv.setVisibility(0);
    this.KIw.setVisibility(8);
    AppMethodBeat.o(65937);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView
 * JD-Core Version:    0.7.0.1
 */