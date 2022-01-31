package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class IPCallDynamicTextView
  extends TextView
{
  private ak mHandler;
  private int mHeight;
  private String mValue;
  private int nSX;
  private double nSY;
  private double nSZ;
  private double nTa;
  private boolean nTb;
  private int nTc;
  private int nTd;
  DecimalFormat nTe;
  private String nTf;
  private String nTg;
  
  public IPCallDynamicTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(22144);
    this.nTc = 4000;
    this.nTd = 50;
    this.nTe = new DecimalFormat("0.00");
    this.nTf = "";
    this.nTg = "";
    this.mHandler = new IPCallDynamicTextView.1(this);
    init();
    AppMethodBeat.o(22144);
  }
  
  public IPCallDynamicTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(22145);
    this.nTc = 4000;
    this.nTd = 50;
    this.nTe = new DecimalFormat("0.00");
    this.nTf = "";
    this.nTg = "";
    this.mHandler = new IPCallDynamicTextView.1(this);
    init();
    AppMethodBeat.o(22145);
  }
  
  public static String Rq(String paramString)
  {
    AppMethodBeat.i(22148);
    String str1 = "";
    int i = 0;
    while ((i < paramString.length()) && (!Character.isDigit(paramString.charAt(i))))
    {
      str1 = str1 + paramString.charAt(i);
      i += 1;
    }
    String str2 = "";
    i = paramString.length() - 1;
    while ((i > 0) && (!Character.isDigit(paramString.charAt(i))))
    {
      str2 = str2 + paramString.charAt(i);
      i -= 1;
    }
    paramString = paramString.substring(str1.length(), paramString.length() - str2.length());
    AppMethodBeat.o(22148);
    return paramString;
  }
  
  private void init()
  {
    AppMethodBeat.i(22146);
    getViewTreeObserver().addOnGlobalLayoutListener(new IPCallDynamicTextView.2(this));
    AppMethodBeat.o(22146);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(22149);
    super.onMeasure(paramInt1, paramInt2);
    this.mHeight = getMeasuredHeight();
    AppMethodBeat.o(22149);
  }
  
  public void setLocHeight(int paramInt)
  {
    this.nSX = paramInt;
  }
  
  public final void setValue(String paramString1, String paramString2)
  {
    AppMethodBeat.i(22147);
    if ((paramString1 == null) || (paramString1.length() <= 0) || (paramString2 == null) || (paramString2.length() <= 0))
    {
      setText(paramString2);
      AppMethodBeat.o(22147);
      return;
    }
    try
    {
      this.nSZ = Double.parseDouble(Rq(paramString1));
      this.nTf = "";
      i = 0;
      while ((i < paramString2.length()) && (!Character.isDigit(paramString2.charAt(i))))
      {
        this.nTf += paramString2.charAt(i);
        i += 1;
      }
      this.nTg = "";
    }
    catch (NumberFormatException paramString1)
    {
      setText(paramString2);
      AppMethodBeat.o(22147);
      return;
    }
    int i = paramString2.length() - 1;
    while ((i > 0) && (!Character.isDigit(paramString2.charAt(i))))
    {
      this.nTg += paramString2.charAt(i);
      i -= 1;
    }
    paramString1 = paramString2.substring(this.nTf.length(), paramString2.length() - this.nTg.length());
    try
    {
      this.nTa = Double.parseDouble(paramString1);
      this.mValue = paramString2;
      this.nSY = ((this.nTa - this.nSZ) / (this.nTc / this.nTd));
      if (this.nSY == 0.0D)
      {
        setText(paramString2);
        AppMethodBeat.o(22147);
        return;
      }
    }
    catch (NumberFormatException paramString1)
    {
      setText(paramString2);
      AppMethodBeat.o(22147);
      return;
    }
    this.nSY = new BigDecimal(this.nSY).setScale(2, 4).doubleValue();
    if (isShown()) {
      this.mHandler.sendEmptyMessage(1);
    }
    AppMethodBeat.o(22147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallDynamicTextView
 * JD-Core Version:    0.7.0.1
 */