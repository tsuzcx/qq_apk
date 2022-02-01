package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class IPCallDynamicTextView
  extends TextView
{
  private MMHandler mHandler;
  private int mHeight;
  private String mValue;
  private double yvA;
  private double yvB;
  private boolean yvC;
  private int yvD;
  private int yvE;
  DecimalFormat yvF;
  private String yvG;
  private String yvH;
  private int yvy;
  private double yvz;
  
  public IPCallDynamicTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(25761);
    this.yvD = 4000;
    this.yvE = 50;
    this.yvF = new DecimalFormat("0.00");
    this.yvG = "";
    this.yvH = "";
    this.mHandler = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(25759);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(25759);
          return;
          if (((IPCallDynamicTextView.a(IPCallDynamicTextView.this) > 0.0D) && (IPCallDynamicTextView.b(IPCallDynamicTextView.this) < IPCallDynamicTextView.c(IPCallDynamicTextView.this))) || ((IPCallDynamicTextView.a(IPCallDynamicTextView.this) < 0.0D) && (IPCallDynamicTextView.b(IPCallDynamicTextView.this) > IPCallDynamicTextView.c(IPCallDynamicTextView.this))))
          {
            IPCallDynamicTextView.a(IPCallDynamicTextView.this, true);
            IPCallDynamicTextView.a(IPCallDynamicTextView.this, IPCallDynamicTextView.b(IPCallDynamicTextView.this));
            IPCallDynamicTextView.b(IPCallDynamicTextView.this, IPCallDynamicTextView.b(IPCallDynamicTextView.this) + IPCallDynamicTextView.a(IPCallDynamicTextView.this));
            IPCallDynamicTextView.e(IPCallDynamicTextView.this).sendEmptyMessageDelayed(1, IPCallDynamicTextView.d(IPCallDynamicTextView.this));
            AppMethodBeat.o(25759);
            return;
          }
          IPCallDynamicTextView.a(IPCallDynamicTextView.this, false);
          IPCallDynamicTextView.a(IPCallDynamicTextView.this, IPCallDynamicTextView.c(IPCallDynamicTextView.this));
        }
      }
    };
    init();
    AppMethodBeat.o(25761);
  }
  
  public IPCallDynamicTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(25762);
    this.yvD = 4000;
    this.yvE = 50;
    this.yvF = new DecimalFormat("0.00");
    this.yvG = "";
    this.yvH = "";
    this.mHandler = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(25759);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(25759);
          return;
          if (((IPCallDynamicTextView.a(IPCallDynamicTextView.this) > 0.0D) && (IPCallDynamicTextView.b(IPCallDynamicTextView.this) < IPCallDynamicTextView.c(IPCallDynamicTextView.this))) || ((IPCallDynamicTextView.a(IPCallDynamicTextView.this) < 0.0D) && (IPCallDynamicTextView.b(IPCallDynamicTextView.this) > IPCallDynamicTextView.c(IPCallDynamicTextView.this))))
          {
            IPCallDynamicTextView.a(IPCallDynamicTextView.this, true);
            IPCallDynamicTextView.a(IPCallDynamicTextView.this, IPCallDynamicTextView.b(IPCallDynamicTextView.this));
            IPCallDynamicTextView.b(IPCallDynamicTextView.this, IPCallDynamicTextView.b(IPCallDynamicTextView.this) + IPCallDynamicTextView.a(IPCallDynamicTextView.this));
            IPCallDynamicTextView.e(IPCallDynamicTextView.this).sendEmptyMessageDelayed(1, IPCallDynamicTextView.d(IPCallDynamicTextView.this));
            AppMethodBeat.o(25759);
            return;
          }
          IPCallDynamicTextView.a(IPCallDynamicTextView.this, false);
          IPCallDynamicTextView.a(IPCallDynamicTextView.this, IPCallDynamicTextView.c(IPCallDynamicTextView.this));
        }
      }
    };
    init();
    AppMethodBeat.o(25762);
  }
  
  public static String aCl(String paramString)
  {
    AppMethodBeat.i(25765);
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
    AppMethodBeat.o(25765);
    return paramString;
  }
  
  private void init()
  {
    AppMethodBeat.i(25763);
    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(25760);
        if (IPCallDynamicTextView.b(IPCallDynamicTextView.this) != IPCallDynamicTextView.c(IPCallDynamicTextView.this)) {
          IPCallDynamicTextView.e(IPCallDynamicTextView.this).sendEmptyMessage(1);
        }
        AppMethodBeat.o(25760);
      }
    });
    AppMethodBeat.o(25763);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(25766);
    super.onMeasure(paramInt1, paramInt2);
    this.mHeight = getMeasuredHeight();
    AppMethodBeat.o(25766);
  }
  
  public void setLocHeight(int paramInt)
  {
    this.yvy = paramInt;
  }
  
  public final void setValue(String paramString1, String paramString2)
  {
    AppMethodBeat.i(25764);
    if ((paramString1 == null) || (paramString1.length() <= 0) || (paramString2 == null) || (paramString2.length() <= 0))
    {
      setText(paramString2);
      AppMethodBeat.o(25764);
      return;
    }
    try
    {
      this.yvA = Double.parseDouble(aCl(paramString1));
      this.yvG = "";
      i = 0;
      while ((i < paramString2.length()) && (!Character.isDigit(paramString2.charAt(i))))
      {
        this.yvG += paramString2.charAt(i);
        i += 1;
      }
      this.yvH = "";
    }
    catch (NumberFormatException paramString1)
    {
      setText(paramString2);
      AppMethodBeat.o(25764);
      return;
    }
    int i = paramString2.length() - 1;
    while ((i > 0) && (!Character.isDigit(paramString2.charAt(i))))
    {
      this.yvH += paramString2.charAt(i);
      i -= 1;
    }
    paramString1 = paramString2.substring(this.yvG.length(), paramString2.length() - this.yvH.length());
    try
    {
      this.yvB = Double.parseDouble(paramString1);
      this.mValue = paramString2;
      this.yvz = ((this.yvB - this.yvA) / (this.yvD / this.yvE));
      if (this.yvz == 0.0D)
      {
        setText(paramString2);
        AppMethodBeat.o(25764);
        return;
      }
    }
    catch (NumberFormatException paramString1)
    {
      setText(paramString2);
      AppMethodBeat.o(25764);
      return;
    }
    this.yvz = new BigDecimal(this.yvz).setScale(2, 4).doubleValue();
    if (isShown()) {
      this.mHandler.sendEmptyMessage(1);
    }
    AppMethodBeat.o(25764);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallDynamicTextView
 * JD-Core Version:    0.7.0.1
 */