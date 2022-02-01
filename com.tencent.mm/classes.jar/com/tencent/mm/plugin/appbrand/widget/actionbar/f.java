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
  
  public abstract void hZ(boolean paramBoolean);
  
  public abstract void setBackButtonClickListener(View.OnClickListener paramOnClickListener);
  
  public abstract void setBackgroundColor(int paramInt);
  
  public abstract void setCloseButtonClickListener(View.OnClickListener paramOnClickListener);
  
  public abstract void setForegroundColor(int paramInt);
  
  public abstract void setForegroundStyle(String paramString);
  
  public abstract void setLoadingIconVisibility(boolean paramBoolean);
  
  public abstract void setMainTitle(CharSequence paramCharSequence);
  
  public abstract void setNavHidden(boolean paramBoolean);
  
  public static enum a
  {
    public final int uzh;
    
    static
    {
      AppMethodBeat.i(324179);
      uzf = new a("BLACK", 0, -16777216);
      uzg = new a("WHITE", 1, -1);
      uzi = new a[] { uzf, uzg };
      AppMethodBeat.o(324179);
    }
    
    private a(int paramInt)
    {
      this.uzh = paramInt;
    }
    
    public static a DX(int paramInt)
    {
      if (paramInt == -1) {
        return uzg;
      }
      return uzf;
    }
    
    public static a agY(String paramString)
    {
      AppMethodBeat.i(324175);
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
            AppMethodBeat.o(324175);
            return locala;
          }
          i += 1;
        }
      }
      paramString = uzg;
      AppMethodBeat.o(324175);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.f
 * JD-Core Version:    0.7.0.1
 */