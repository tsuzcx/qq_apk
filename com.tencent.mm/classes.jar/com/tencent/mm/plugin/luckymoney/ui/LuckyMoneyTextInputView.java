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
  private TextView iJG;
  private g oiU;
  private MMEditText okr;
  LinearLayout oxb;
  ImageView oxc;
  BaseEmojiView oxd;
  private View.OnClickListener oxe;
  
  public LuckyMoneyTextInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(43038);
    paramContext = LayoutInflater.from(paramContext).inflate(2130970046, this, true);
    this.okr = ((MMEditText)paramContext.findViewById(2131825833));
    this.iJG = ((TextView)paramContext.findViewById(2131825832));
    this.oxb = ((LinearLayout)paramContext.findViewById(2131825834));
    this.oxc = ((ImageView)paramContext.findViewById(2131825835));
    this.oxd = ((BaseEmojiView)paramContext.findViewById(2131825634));
    this.okr.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(43036);
        if (LuckyMoneyTextInputView.a(LuckyMoneyTextInputView.this) != null)
        {
          paramAnonymousView = LuckyMoneyTextInputView.a(LuckyMoneyTextInputView.this);
          LuckyMoneyTextInputView.this.getInputViewId();
          paramAnonymousView.bMQ();
        }
        AppMethodBeat.o(43036);
      }
    });
    this.oxb.setOnClickListener(new LuckyMoneyTextInputView.2(this));
    this.oxb.setVisibility(8);
    AppMethodBeat.o(43038);
  }
  
  public final void A(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(43043);
    this.oxb.setTag("delete");
    this.oxc.setVisibility(8);
    this.oxd.setVisibility(0);
    this.oxd.setEmojiInfo(paramEmojiInfo);
    AppMethodBeat.o(43043);
  }
  
  public final int bMP()
  {
    return 0;
  }
  
  public String getInput()
  {
    AppMethodBeat.i(43039);
    String str = this.okr.getText().toString();
    AppMethodBeat.o(43039);
    return str;
  }
  
  public int getInputViewId()
  {
    AppMethodBeat.i(43044);
    int i = getId();
    AppMethodBeat.o(43044);
    return i;
  }
  
  public final void je(boolean paramBoolean)
  {
    AppMethodBeat.i(43042);
    if (paramBoolean)
    {
      this.oxb.setVisibility(8);
      AppMethodBeat.o(43042);
      return;
    }
    this.oxb.setVisibility(0);
    this.oxc.setVisibility(0);
    this.oxd.setVisibility(8);
    AppMethodBeat.o(43042);
  }
  
  public final void onError() {}
  
  public final void restore() {}
  
  public void setHintText(String paramString)
  {
    AppMethodBeat.i(43040);
    this.okr.setHint(paramString);
    AppMethodBeat.o(43040);
  }
  
  public void setOnInputValidChangerListener(g paramg)
  {
    this.oiU = paramg;
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(43041);
    this.iJG.setText(paramString);
    AppMethodBeat.o(43041);
  }
  
  public void setmOnEmojiSelectClickListener(View.OnClickListener paramOnClickListener)
  {
    this.oxe = paramOnClickListener;
  }
  
  public final String yf(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView
 * JD-Core Version:    0.7.0.1
 */