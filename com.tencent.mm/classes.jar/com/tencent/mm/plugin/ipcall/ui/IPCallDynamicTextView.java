package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.ah;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class IPCallDynamicTextView
  extends TextView
{
  private int lvI;
  private double lvJ;
  private double lvK;
  private double lvL;
  private boolean lvM;
  private int lvN = 4000;
  private int lvO = 50;
  DecimalFormat lvP = new DecimalFormat("0.00");
  private String lvQ = "";
  private String lvR = "";
  private ah mHandler = new IPCallDynamicTextView.1(this);
  private int mHeight;
  private String mValue;
  
  public IPCallDynamicTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public IPCallDynamicTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  public static String FO(String paramString)
  {
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
    return paramString.substring(str1.length(), paramString.length() - str2.length());
  }
  
  private void init()
  {
    getViewTreeObserver().addOnGlobalLayoutListener(new IPCallDynamicTextView.2(this));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.mHeight = getMeasuredHeight();
  }
  
  public void setLocHeight(int paramInt)
  {
    this.lvI = paramInt;
  }
  
  public final void setValue(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() <= 0) || (paramString2 == null) || (paramString2.length() <= 0)) {
      setText(paramString2);
    }
    do
    {
      return;
      try
      {
        this.lvK = Double.parseDouble(FO(paramString1));
        this.lvQ = "";
        i = 0;
        while ((i < paramString2.length()) && (!Character.isDigit(paramString2.charAt(i))))
        {
          this.lvQ += paramString2.charAt(i);
          i += 1;
        }
        this.lvR = "";
      }
      catch (NumberFormatException paramString1)
      {
        setText(paramString2);
        return;
      }
      int i = paramString2.length() - 1;
      while ((i > 0) && (!Character.isDigit(paramString2.charAt(i))))
      {
        this.lvR += paramString2.charAt(i);
        i -= 1;
      }
      paramString1 = paramString2.substring(this.lvQ.length(), paramString2.length() - this.lvR.length());
      try
      {
        this.lvL = Double.parseDouble(paramString1);
        this.mValue = paramString2;
        this.lvJ = ((this.lvL - this.lvK) / (this.lvN / this.lvO));
        if (this.lvJ == 0.0D)
        {
          setText(paramString2);
          return;
        }
      }
      catch (NumberFormatException paramString1)
      {
        setText(paramString2);
        return;
      }
      this.lvJ = new BigDecimal(this.lvJ).setScale(2, 4).doubleValue();
    } while (!isShown());
    this.mHandler.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallDynamicTextView
 * JD-Core Version:    0.7.0.1
 */