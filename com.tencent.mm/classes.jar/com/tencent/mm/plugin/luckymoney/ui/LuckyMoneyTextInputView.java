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
  private TextView lCL;
  LinearLayout vBe;
  ImageView vBf;
  BaseEmojiView vBg;
  private View.OnClickListener vBh;
  private g vjF;
  private MMEditText vlc;
  
  public LuckyMoneyTextInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(65933);
    paramContext = LayoutInflater.from(paramContext).inflate(2131494660, this, true);
    this.vlc = ((MMEditText)paramContext.findViewById(2131301944));
    this.lCL = ((TextView)paramContext.findViewById(2131301945));
    this.vBe = ((LinearLayout)paramContext.findViewById(2131301794));
    this.vBf = ((ImageView)paramContext.findViewById(2131301795));
    this.vBg = ((BaseEmojiView)paramContext.findViewById(2131301793));
    this.vlc.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(65931);
        if (LuckyMoneyTextInputView.a(LuckyMoneyTextInputView.this) != null)
        {
          paramAnonymousView = LuckyMoneyTextInputView.a(LuckyMoneyTextInputView.this);
          LuckyMoneyTextInputView.this.getInputViewId();
          paramAnonymousView.dhR();
        }
        AppMethodBeat.o(65931);
      }
    });
    this.vBe.setOnClickListener(new LuckyMoneyTextInputView.2(this));
    this.vBe.setVisibility(8);
    AppMethodBeat.o(65933);
  }
  
  public final void A(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(65938);
    this.vBe.setTag("delete");
    this.vBf.setVisibility(8);
    this.vBg.setVisibility(0);
    this.vBg.setEmojiInfo(paramEmojiInfo);
    AppMethodBeat.o(65938);
  }
  
  public final String IZ(int paramInt)
  {
    return null;
  }
  
  public final int dhQ()
  {
    return 0;
  }
  
  public String getInput()
  {
    AppMethodBeat.i(65934);
    String str = this.vlc.getText().toString();
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
  
  public final void of(boolean paramBoolean)
  {
    AppMethodBeat.i(65937);
    if (paramBoolean)
    {
      this.vBe.setVisibility(8);
      AppMethodBeat.o(65937);
      return;
    }
    this.vBe.setVisibility(0);
    this.vBf.setVisibility(0);
    this.vBg.setVisibility(8);
    AppMethodBeat.o(65937);
  }
  
  public final void onError() {}
  
  public final void restore() {}
  
  public void setHintText(String paramString)
  {
    AppMethodBeat.i(65935);
    this.vlc.setHint(paramString);
    AppMethodBeat.o(65935);
  }
  
  public void setOnInputValidChangerListener(g paramg)
  {
    this.vjF = paramg;
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(65936);
    this.lCL.setText(paramString);
    AppMethodBeat.o(65936);
  }
  
  public void setmOnEmojiSelectClickListener(View.OnClickListener paramOnClickListener)
  {
    this.vBh = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView
 * JD-Core Version:    0.7.0.1
 */