package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.bu;

public class DialNumberButton
  extends RelativeLayout
{
  private TextView van;
  private TextView vao;
  private boolean vap;
  
  public DialNumberButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(25568);
    this.vap = false;
    LayoutInflater.from(getContext()).inflate(2131493708, this);
    this.van = ((TextView)findViewById(2131299096));
    this.vao = ((TextView)findViewById(2131299097));
    if (d.lA(16))
    {
      this.van.setTypeface(Typeface.create("sans-serif-light", 0));
      this.vao.setTypeface(Typeface.create("sans-serif-normal", 0));
    }
    setClipChildren(false);
    setClipToPadding(false);
    AppMethodBeat.o(25568);
  }
  
  public String getNumberText()
  {
    AppMethodBeat.i(25570);
    String str = this.van.getText().toString();
    AppMethodBeat.o(25570);
    return str;
  }
  
  public String getOtherText()
  {
    AppMethodBeat.i(25571);
    String str = this.vao.getText().toString();
    AppMethodBeat.o(25571);
    return str;
  }
  
  public final void hD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(25572);
    if ((!bu.isNullOrNil(paramString1)) && (paramString1.length() == 1)) {
      this.van.setText(paramString1);
    }
    if ((bu.isNullOrNil(paramString2)) && (!"1".equals(paramString1)))
    {
      this.vao.setVisibility(8);
      AppMethodBeat.o(25572);
      return;
    }
    this.vao.setText(paramString2);
    this.vao.setVisibility(0);
    AppMethodBeat.o(25572);
  }
  
  public void setInTalkUIMode(boolean paramBoolean)
  {
    AppMethodBeat.i(25573);
    this.vap = paramBoolean;
    if (this.vap)
    {
      if (("#".equals(this.van.getText())) || ("*".equals(this.van.getText()))) {
        this.van.setTextColor(getContext().getResources().getColor(2131100232));
      }
      for (;;)
      {
        this.vao.setTextColor(getContext().getResources().getColor(2131100232));
        setBackgroundDrawable(getResources().getDrawable(2131231912));
        AppMethodBeat.o(25573);
        return;
        this.van.setTextColor(getContext().getResources().getColor(2131100234));
      }
    }
    if (("#".equals(this.van.getText())) || ("*".equals(this.van.getText()))) {
      this.van.setTextColor(getContext().getResources().getColor(2131100232));
    }
    for (;;)
    {
      this.vao.setTextColor(getContext().getResources().getColor(2131100232));
      setBackgroundDrawable(getResources().getDrawable(2131231913));
      AppMethodBeat.o(25573);
      return;
      this.van.setTextColor(getContext().getResources().getColor(2131100233));
    }
  }
  
  public final void setNumberTextSize$255e752(float paramFloat)
  {
    AppMethodBeat.i(25569);
    this.van.setTextSize(0, paramFloat);
    AppMethodBeat.o(25569);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.DialNumberButton
 * JD-Core Version:    0.7.0.1
 */