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
  private TextView lHk;
  LinearLayout vNi;
  ImageView vNj;
  BaseEmojiView vNk;
  private View.OnClickListener vNl;
  private g vvK;
  private MMEditText vxh;
  
  public LuckyMoneyTextInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(65933);
    paramContext = LayoutInflater.from(paramContext).inflate(2131494660, this, true);
    this.vxh = ((MMEditText)paramContext.findViewById(2131301944));
    this.lHk = ((TextView)paramContext.findViewById(2131301945));
    this.vNi = ((LinearLayout)paramContext.findViewById(2131301794));
    this.vNj = ((ImageView)paramContext.findViewById(2131301795));
    this.vNk = ((BaseEmojiView)paramContext.findViewById(2131301793));
    this.vxh.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(65931);
        if (LuckyMoneyTextInputView.a(LuckyMoneyTextInputView.this) != null)
        {
          paramAnonymousView = LuckyMoneyTextInputView.a(LuckyMoneyTextInputView.this);
          LuckyMoneyTextInputView.this.getInputViewId();
          paramAnonymousView.dkQ();
        }
        AppMethodBeat.o(65931);
      }
    });
    this.vNi.setOnClickListener(new LuckyMoneyTextInputView.2(this));
    this.vNi.setVisibility(8);
    AppMethodBeat.o(65933);
  }
  
  public final void B(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(65938);
    this.vNi.setTag("delete");
    this.vNj.setVisibility(8);
    this.vNk.setVisibility(0);
    this.vNk.setEmojiInfo(paramEmojiInfo);
    AppMethodBeat.o(65938);
  }
  
  public final String Jy(int paramInt)
  {
    return null;
  }
  
  public final int dkP()
  {
    return 0;
  }
  
  public String getInput()
  {
    AppMethodBeat.i(65934);
    String str = this.vxh.getText().toString();
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
  
  public final void ok(boolean paramBoolean)
  {
    AppMethodBeat.i(65937);
    if (paramBoolean)
    {
      this.vNi.setVisibility(8);
      AppMethodBeat.o(65937);
      return;
    }
    this.vNi.setVisibility(0);
    this.vNj.setVisibility(0);
    this.vNk.setVisibility(8);
    AppMethodBeat.o(65937);
  }
  
  public final void onError() {}
  
  public final void restore() {}
  
  public void setHintText(String paramString)
  {
    AppMethodBeat.i(65935);
    this.vxh.setHint(paramString);
    AppMethodBeat.o(65935);
  }
  
  public void setOnInputValidChangerListener(g paramg)
  {
    this.vvK = paramg;
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(65936);
    this.lHk.setText(paramString);
    AppMethodBeat.o(65936);
  }
  
  public void setmOnEmojiSelectClickListener(View.OnClickListener paramOnClickListener)
  {
    this.vNl = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView
 * JD-Core Version:    0.7.0.1
 */