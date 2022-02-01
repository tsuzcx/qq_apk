package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface e
{
  public abstract void destroy();
  
  public abstract View getActionView();
  
  public abstract int getBackgroundColor();
  
  public abstract void gz(boolean paramBoolean);
  
  public abstract void setBackButtonClickListener(View.OnClickListener paramOnClickListener);
  
  public abstract void setBackgroundColor(int paramInt);
  
  public abstract void setCloseButtonClickListener(View.OnClickListener paramOnClickListener);
  
  public abstract void setForegroundColor(int paramInt);
  
  public abstract void setForegroundStyle(String paramString);
  
  public abstract void setLoadingIconVisibility(boolean paramBoolean);
  
  public abstract void setMainTitle(CharSequence paramCharSequence);
  
  public static enum a
  {
    public final int omu;
    
    static
    {
      AppMethodBeat.i(219631);
      oms = new a("BLACK", 0, -16777216);
      omt = new a("WHITE", 1, -1);
      omv = new a[] { oms, omt };
      AppMethodBeat.o(219631);
    }
    
    private a(int paramInt)
    {
      this.omu = paramInt;
    }
    
    public static a afW(String paramString)
    {
      AppMethodBeat.i(219630);
      if (!TextUtils.isEmpty(paramString))
      {
        a[] arrayOfa = values();
        int j = arrayOfa.length;
        int i = 0;
        while (i < j)
        {
          a locala = arrayOfa[i];
          if (locala.name().equalsIgnoreCase(paramString))
          {
            AppMethodBeat.o(219630);
            return locala;
          }
          i += 1;
        }
      }
      paramString = omt;
      AppMethodBeat.o(219630);
      return paramString;
    }
    
    public static a zP(int paramInt)
    {
      if (paramInt == -1) {
        return omt;
      }
      return oms;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.e
 * JD-Core Version:    0.7.0.1
 */