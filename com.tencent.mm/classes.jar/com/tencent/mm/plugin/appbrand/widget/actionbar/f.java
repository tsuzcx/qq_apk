package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface f
{
  public abstract void destroy();
  
  public abstract View getActionView();
  
  public abstract int getBackgroundColor();
  
  public abstract void hk(boolean paramBoolean);
  
  public abstract void setBackButtonClickListener(View.OnClickListener paramOnClickListener);
  
  public abstract void setBackgroundColor(int paramInt);
  
  public abstract void setCloseButtonClickListener(View.OnClickListener paramOnClickListener);
  
  public abstract void setForegroundColor(int paramInt);
  
  public abstract void setForegroundStyle(String paramString);
  
  public abstract void setLoadingIconVisibility(boolean paramBoolean);
  
  public abstract void setMainTitle(CharSequence paramCharSequence);
  
  public static enum a
  {
    public final int roW;
    
    static
    {
      AppMethodBeat.i(244974);
      roU = new a("BLACK", 0, -16777216);
      roV = new a("WHITE", 1, -1);
      roX = new a[] { roU, roV };
      AppMethodBeat.o(244974);
    }
    
    private a(int paramInt)
    {
      this.roW = paramInt;
    }
    
    public static a Dy(int paramInt)
    {
      if (paramInt == -1) {
        return roV;
      }
      return roU;
    }
    
    public static a anB(String paramString)
    {
      AppMethodBeat.i(244970);
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
            AppMethodBeat.o(244970);
            return locala;
          }
          i += 1;
        }
      }
      paramString = roV;
      AppMethodBeat.o(244970);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.f
 * JD-Core Version:    0.7.0.1
 */