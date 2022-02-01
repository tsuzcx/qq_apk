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
  private int JML;
  private double JMM;
  private double JMN;
  private double JMO;
  private boolean JMP;
  private int JMQ;
  private int JMR;
  DecimalFormat JMS;
  private String JMT;
  private String JMU;
  private String lWc;
  private MMHandler mHandler;
  private int mHeight;
  
  public IPCallDynamicTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(25761);
    this.JMQ = 4000;
    this.JMR = 50;
    this.JMS = new DecimalFormat("0.00");
    this.JMT = "";
    this.JMU = "";
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
            IPCallDynamicTextView.b(IPCallDynamicTextView.this, IPCallDynamicTextView.a(IPCallDynamicTextView.this));
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
    this.JMQ = 4000;
    this.JMR = 50;
    this.JMS = new DecimalFormat("0.00");
    this.JMT = "";
    this.JMU = "";
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
            IPCallDynamicTextView.b(IPCallDynamicTextView.this, IPCallDynamicTextView.a(IPCallDynamicTextView.this));
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
  
  public static String aJm(String paramString)
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
    this.JML = paramInt;
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
      this.JMN = Double.parseDouble(aJm(paramString1));
      this.JMT = "";
      i = 0;
      while ((i < paramString2.length()) && (!Character.isDigit(paramString2.charAt(i))))
      {
        this.JMT += paramString2.charAt(i);
        i += 1;
      }
      this.JMU = "";
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
      this.JMU += paramString2.charAt(i);
      i -= 1;
    }
    paramString1 = paramString2.substring(this.JMT.length(), paramString2.length() - this.JMU.length());
    try
    {
      this.JMO = Double.parseDouble(paramString1);
      this.lWc = paramString2;
      this.JMM = ((this.JMO - this.JMN) / (this.JMQ / this.JMR));
      if (this.JMM == 0.0D)
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
    this.JMM = new BigDecimal(this.JMM).setScale(2, 4).doubleValue();
    if (isShown()) {
      this.mHandler.sendEmptyMessage(1);
    }
    AppMethodBeat.o(25764);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallDynamicTextView
 * JD-Core Version:    0.7.0.1
 */