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
  private TextView kEu;
  private g sYH;
  private MMEditText tae;
  LinearLayout tqj;
  ImageView tqk;
  BaseEmojiView tql;
  private View.OnClickListener tqm;
  
  public LuckyMoneyTextInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(65933);
    paramContext = LayoutInflater.from(paramContext).inflate(2131494660, this, true);
    this.tae = ((MMEditText)paramContext.findViewById(2131301944));
    this.kEu = ((TextView)paramContext.findViewById(2131301945));
    this.tqj = ((LinearLayout)paramContext.findViewById(2131301794));
    this.tqk = ((ImageView)paramContext.findViewById(2131301795));
    this.tql = ((BaseEmojiView)paramContext.findViewById(2131301793));
    this.tae.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(65931);
        if (LuckyMoneyTextInputView.a(LuckyMoneyTextInputView.this) != null)
        {
          paramAnonymousView = LuckyMoneyTextInputView.a(LuckyMoneyTextInputView.this);
          LuckyMoneyTextInputView.this.getInputViewId();
          paramAnonymousView.cKZ();
        }
        AppMethodBeat.o(65931);
      }
    });
    this.tqj.setOnClickListener(new View.OnClickListener()
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
    this.tqj.setVisibility(8);
    AppMethodBeat.o(65933);
  }
  
  public final void A(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(65938);
    this.tqj.setTag("delete");
    this.tqk.setVisibility(8);
    this.tql.setVisibility(0);
    this.tql.setEmojiInfo(paramEmojiInfo);
    AppMethodBeat.o(65938);
  }
  
  public final String FI(int paramInt)
  {
    return null;
  }
  
  public final int cKY()
  {
    return 0;
  }
  
  public String getInput()
  {
    AppMethodBeat.i(65934);
    String str = this.tae.getText().toString();
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
  
  public final void mT(boolean paramBoolean)
  {
    AppMethodBeat.i(65937);
    if (paramBoolean)
    {
      this.tqj.setVisibility(8);
      AppMethodBeat.o(65937);
      return;
    }
    this.tqj.setVisibility(0);
    this.tqk.setVisibility(0);
    this.tql.setVisibility(8);
    AppMethodBeat.o(65937);
  }
  
  public final void onError() {}
  
  public final void restore() {}
  
  public void setHintText(String paramString)
  {
    AppMethodBeat.i(65935);
    this.tae.setHint(paramString);
    AppMethodBeat.o(65935);
  }
  
  public void setOnInputValidChangerListener(g paramg)
  {
    this.sYH = paramg;
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(65936);
    this.kEu.setText(paramString);
    AppMethodBeat.o(65936);
  }
  
  public void setmOnEmojiSelectClickListener(View.OnClickListener paramOnClickListener)
  {
    this.tqm = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView
 * JD-Core Version:    0.7.0.1
 */