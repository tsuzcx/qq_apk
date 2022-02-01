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
  implements d
{
  private TextView mPa;
  private h yPY;
  private MMEditText yRw;
  LinearLayout ziF;
  ImageView ziG;
  BaseEmojiView ziH;
  private View.OnClickListener ziI;
  
  public LuckyMoneyTextInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(65933);
    paramContext = LayoutInflater.from(paramContext).inflate(2131495385, this, true);
    this.yRw = ((MMEditText)paramContext.findViewById(2131304269));
    this.mPa = ((TextView)paramContext.findViewById(2131304270));
    this.ziF = ((LinearLayout)paramContext.findViewById(2131304099));
    this.ziG = ((ImageView)paramContext.findViewById(2131304100));
    this.ziH = ((BaseEmojiView)paramContext.findViewById(2131304098));
    this.yRw.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(65931);
        if (LuckyMoneyTextInputView.a(LuckyMoneyTextInputView.this) != null)
        {
          paramAnonymousView = LuckyMoneyTextInputView.a(LuckyMoneyTextInputView.this);
          LuckyMoneyTextInputView.this.getInputViewId();
          paramAnonymousView.eeI();
        }
        AppMethodBeat.o(65931);
      }
    });
    this.ziF.setOnClickListener(new LuckyMoneyTextInputView.2(this));
    this.ziF.setVisibility(8);
    AppMethodBeat.o(65933);
  }
  
  public final void A(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(65938);
    this.ziF.setTag("delete");
    this.ziG.setVisibility(8);
    this.ziH.setVisibility(0);
    this.ziH.setEmojiInfo(paramEmojiInfo);
    AppMethodBeat.o(65938);
  }
  
  public final String PA(int paramInt)
  {
    return null;
  }
  
  public final int eeH()
  {
    return 0;
  }
  
  public String getInput()
  {
    AppMethodBeat.i(65934);
    String str = this.yRw.getText().toString();
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
  
  public final void qS(boolean paramBoolean)
  {
    AppMethodBeat.i(65937);
    if (paramBoolean)
    {
      this.ziF.setVisibility(8);
      AppMethodBeat.o(65937);
      return;
    }
    this.ziF.setVisibility(0);
    this.ziG.setVisibility(0);
    this.ziH.setVisibility(8);
    AppMethodBeat.o(65937);
  }
  
  public final void restore() {}
  
  public void setHintText(String paramString)
  {
    AppMethodBeat.i(65935);
    this.yRw.setHint(paramString);
    AppMethodBeat.o(65935);
  }
  
  public void setOnInputValidChangerListener(h paramh)
  {
    this.yPY = paramh;
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(65936);
    this.mPa.setText(paramString);
    AppMethodBeat.o(65936);
  }
  
  public void setmOnEmojiSelectClickListener(View.OnClickListener paramOnClickListener)
  {
    this.ziI = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView
 * JD-Core Version:    0.7.0.1
 */