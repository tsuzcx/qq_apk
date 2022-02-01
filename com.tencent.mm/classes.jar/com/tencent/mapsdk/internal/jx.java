package com.tencent.mapsdk.internal;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class jx
{
  private static a a(Context paramContext)
  {
    AppMethodBeat.i(223834);
    paramContext = a(paramContext, null, " ", 0);
    AppMethodBeat.o(223834);
    return paramContext;
  }
  
  private static a a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(223847);
    paramContext = a(paramContext, null, paramString, 0);
    AppMethodBeat.o(223847);
    return paramContext;
  }
  
  public static a a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(223866);
    if (paramContext == null)
    {
      AppMethodBeat.o(223866);
      return null;
    }
    a locala = new a(paramContext);
    paramContext = locala.a(paramContext, locala.a(paramContext, paramString1, paramString2), paramInt);
    AppMethodBeat.o(223866);
    return paramContext;
  }
  
  private static a b(Context paramContext, String paramString)
  {
    AppMethodBeat.i(223857);
    paramContext = a(paramContext, null, paramString, 0);
    AppMethodBeat.o(223857);
    return paramContext;
  }
  
  public static final class a
  {
    public Toast a;
    private int b;
    private int c;
    private int d;
    private String e;
    private String f;
    private TextView g;
    private TextView h;
    private TextView i;
    private Context j;
    
    a(Context paramContext)
    {
      this.j = paramContext;
    }
    
    private a a(int paramInt)
    {
      AppMethodBeat.i(221494);
      this.b = paramInt;
      if (this.a != null) {
        this.a.setGravity(this.b, this.c, this.d);
      }
      AppMethodBeat.o(221494);
      return this;
    }
    
    private a a(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(221499);
      this.c = paramInt1;
      this.d = paramInt2;
      if (this.a != null) {
        this.a.setGravity(this.b, this.c, this.d);
      }
      AppMethodBeat.o(221499);
      return this;
    }
    
    private a a(String paramString)
    {
      AppMethodBeat.i(221478);
      this.e = paramString;
      if ((paramString != null) && (this.h != null)) {
        this.h.setText(paramString);
      }
      AppMethodBeat.o(221478);
      return this;
    }
    
    private a b(String paramString)
    {
      AppMethodBeat.i(221488);
      paramString = a(paramString, 8388611);
      AppMethodBeat.o(221488);
      return paramString;
    }
    
    private void c()
    {
      AppMethodBeat.i(221510);
      if (this.a != null) {
        this.a.cancel();
      }
      AppMethodBeat.o(221510);
    }
    
    final ViewGroup a(Context paramContext, String paramString1, String paramString2)
    {
      AppMethodBeat.i(221550);
      this.e = paramString1;
      this.f = paramString2;
      LinearLayout localLinearLayout = new LinearLayout(paramContext);
      int k = jt.a(paramContext, 5);
      int m = jt.a(paramContext, 10);
      localLinearLayout.setPadding(m, k, m, k);
      localLinearLayout.setBackgroundColor(-12303292);
      localLinearLayout.setOrientation(1);
      if (!TextUtils.isEmpty(paramString1))
      {
        this.h = new TextView(paramContext);
        k = jt.a(paramContext, 5);
        this.h.setPadding(k, k, k, k);
        this.h.setText(paramString1);
        this.h.setTextColor(-1);
        this.h.setTextSize(2, 18.0F);
        paramString1 = new ViewGroup.MarginLayoutParams(-1, -2);
        localLinearLayout.addView(this.h, paramString1);
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        this.i = new TextView(paramContext);
        this.i.setId(16908299);
        this.i.setText(paramString2);
        this.i.setTextColor(-1);
        this.i.setTextSize(2, 16.0F);
        k = jt.a(paramContext, 5);
        this.i.setPadding(k, k, k, k);
        paramString1 = new ViewGroup.MarginLayoutParams(-1, -2);
        localLinearLayout.addView(this.i, paramString1);
      }
      paramString1 = new LinearLayout(paramContext);
      paramString1.setOrientation(0);
      paramString1.setGravity(21);
      paramString2 = new TextView(paramContext);
      k = jt.a(paramContext, 5);
      m = jt.a(paramContext, 10);
      paramString2.setTextColor(-1);
      paramString2.setBackgroundColor(-16776961);
      paramString2.setPadding(m, k, m, k);
      paramString2.setVisibility(8);
      this.g = paramString2;
      paramString1.addView(paramString2, new ViewGroup.MarginLayoutParams(-2, -2));
      localLinearLayout.addView(paramString1, new ViewGroup.MarginLayoutParams(-1, -2));
      AppMethodBeat.o(221550);
      return localLinearLayout;
    }
    
    public final a a()
    {
      AppMethodBeat.i(221556);
      try
      {
        Object localObject = gy.a(this.a, "mTN");
        if (localObject != null)
        {
          localObject = gy.a(localObject, "mParams");
          if ((localObject instanceof WindowManager.LayoutParams)) {
            ((WindowManager.LayoutParams)localObject).flags = 136;
          }
        }
      }
      catch (Exception localException)
      {
        label43:
        break label43;
      }
      AppMethodBeat.o(221556);
      return this;
    }
    
    final a a(Context paramContext, View paramView, int paramInt)
    {
      AppMethodBeat.i(221537);
      this.a = new Toast(paramContext);
      this.a.setView(paramView);
      this.a.setDuration(paramInt);
      this.b = this.a.getGravity();
      AppMethodBeat.o(221537);
      return this;
    }
    
    public final a a(String paramString, int paramInt)
    {
      AppMethodBeat.i(221569);
      this.f = paramString;
      if ((paramString != null) && (this.i != null))
      {
        this.i.setText(paramString);
        this.i.setGravity(paramInt);
      }
      AppMethodBeat.o(221569);
      return this;
    }
    
    public final a a(String paramString, View.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(221563);
      if ((this.g != null) && (!TextUtils.isEmpty(paramString)) && (paramOnClickListener != null))
      {
        this.g.setText(paramString);
        this.g.setOnClickListener(paramOnClickListener);
        this.g.setVisibility(0);
      }
      AppMethodBeat.o(221563);
      return this;
    }
    
    public final boolean b()
    {
      AppMethodBeat.i(221578);
      if (this.a != null)
      {
        this.a.show();
        AppMethodBeat.o(221578);
        return true;
      }
      AppMethodBeat.o(221578);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.jx
 * JD-Core Version:    0.7.0.1
 */