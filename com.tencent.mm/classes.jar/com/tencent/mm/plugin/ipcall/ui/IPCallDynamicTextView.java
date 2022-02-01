package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aq;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class IPCallDynamicTextView
  extends TextView
{
  private aq mHandler;
  private int mHeight;
  private String mValue;
  private int vcY;
  private double vcZ;
  private double vda;
  private double vdb;
  private boolean vdc;
  private int vdd;
  private int vde;
  DecimalFormat vdf;
  private String vdg;
  private String vdh;
  
  public IPCallDynamicTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(25761);
    this.vdd = 4000;
    this.vde = 50;
    this.vdf = new DecimalFormat("0.00");
    this.vdg = "";
    this.vdh = "";
    this.mHandler = new aq()
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
    this.vdd = 4000;
    this.vde = 50;
    this.vdf = new DecimalFormat("0.00");
    this.vdg = "";
    this.vdh = "";
    this.mHandler = new aq()
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
  
  public static String aoR(String paramString)
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
    this.vcY = paramInt;
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
      this.vda = Double.parseDouble(aoR(paramString1));
      this.vdg = "";
      i = 0;
      while ((i < paramString2.length()) && (!Character.isDigit(paramString2.charAt(i))))
      {
        this.vdg += paramString2.charAt(i);
        i += 1;
      }
      this.vdh = "";
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
      this.vdh += paramString2.charAt(i);
      i -= 1;
    }
    paramString1 = paramString2.substring(this.vdg.length(), paramString2.length() - this.vdh.length());
    try
    {
      this.vdb = Double.parseDouble(paramString1);
      this.mValue = paramString2;
      this.vcZ = ((this.vdb - this.vda) / (this.vdd / this.vde));
      if (this.vcZ == 0.0D)
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
    this.vcZ = new BigDecimal(this.vcZ).setScale(2, 4).doubleValue();
    if (isShown()) {
      this.mHandler.sendEmptyMessage(1);
    }
    AppMethodBeat.o(25764);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallDynamicTextView
 * JD-Core Version:    0.7.0.1
 */