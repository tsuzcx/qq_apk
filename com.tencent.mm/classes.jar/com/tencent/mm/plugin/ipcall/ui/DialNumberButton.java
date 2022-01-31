package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.compatible.util.d;

public class DialNumberButton
  extends RelativeLayout
{
  TextView lsT;
  TextView lsU;
  private boolean lsV = false;
  
  public DialNumberButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(getContext()).inflate(R.i.dial_number_button, this);
    this.lsT = ((TextView)findViewById(R.h.dial_button_number));
    this.lsU = ((TextView)findViewById(R.h.dial_button_text));
    if (d.gF(16))
    {
      this.lsT.setTypeface(Typeface.create("sans-serif-light", 0));
      this.lsU.setTypeface(Typeface.create("sans-serif-normal", 0));
    }
    setClipChildren(false);
    setClipToPadding(false);
  }
  
  public String getNumberText()
  {
    return this.lsT.getText().toString();
  }
  
  public String getOtherText()
  {
    return this.lsU.getText().toString();
  }
  
  public void setInTalkUIMode(boolean paramBoolean)
  {
    this.lsV = paramBoolean;
    if (this.lsV)
    {
      if (("#".equals(this.lsT.getText())) || ("*".equals(this.lsT.getText()))) {
        this.lsT.setTextColor(getContext().getResources().getColor(R.e.dial_number_button_other_text_color));
      }
      for (;;)
      {
        this.lsU.setTextColor(getContext().getResources().getColor(R.e.dial_number_button_other_text_color));
        setBackgroundDrawable(getResources().getDrawable(R.g.dial_number_button_background_black));
        return;
        this.lsT.setTextColor(getContext().getResources().getColor(R.e.dial_number_button_text_color_white));
      }
    }
    if (("#".equals(this.lsT.getText())) || ("*".equals(this.lsT.getText()))) {
      this.lsT.setTextColor(getContext().getResources().getColor(R.e.dial_number_button_other_text_color));
    }
    for (;;)
    {
      this.lsU.setTextColor(getContext().getResources().getColor(R.e.dial_number_button_other_text_color));
      setBackgroundDrawable(getResources().getDrawable(R.g.dial_number_button_background_white));
      return;
      this.lsT.setTextColor(getContext().getResources().getColor(R.e.dial_number_button_text_color));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.DialNumberButton
 * JD-Core Version:    0.7.0.1
 */