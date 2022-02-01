package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface el
  extends fe
{
  public abstract Rect a();
  
  public abstract void a(b paramb);
  
  public abstract boolean a(ViewGroup paramViewGroup, Bundle paramBundle);
  
  public abstract void c();
  
  public abstract b d();
  
  public static enum a
  {
    public int e;
    
    static
    {
      AppMethodBeat.i(222751);
      a = new a("LEFT", 0, 0);
      b = new a("RIGHT", 1, 1);
      c = new a("BOTTOM", 2, 2);
      d = new a("TOP", 3, 3);
      f = new a[] { a, b, c, d };
      AppMethodBeat.o(222751);
    }
    
    private a(int paramInt)
    {
      this.e = paramInt;
    }
    
    public static final a a(int paramInt)
    {
      AppMethodBeat.i(222744);
      int i;
      if (paramInt >= 0)
      {
        i = paramInt;
        if (paramInt < values().length) {}
      }
      else
      {
        i = 0;
      }
      a locala = values()[i];
      AppMethodBeat.o(222744);
      return locala;
    }
  }
  
  public static enum b
  {
    public final int g;
    
    static
    {
      AppMethodBeat.i(222755);
      a = new b("LEFT_BOTTOM", 0, 0);
      b = new b("CENTER_BOTTOM", 1, 4);
      c = new b("RIGHT_BOTTOM", 2, 1);
      d = new b("LEFT_TOP", 3, 3);
      e = new b("CENTER_TOP", 4, 5);
      f = new b("RIGHT_TOP", 5, 2);
      h = new b[] { a, b, c, d, e, f };
      AppMethodBeat.o(222755);
    }
    
    private b(int paramInt)
    {
      this.g = paramInt;
    }
    
    public static b a(int paramInt)
    {
      AppMethodBeat.i(222745);
      int i;
      if (paramInt >= 0)
      {
        i = paramInt;
        if (paramInt < values().length) {}
      }
      else
      {
        i = 0;
      }
      Object localObject = a;
      b[] arrayOfb = values();
      int j = arrayOfb.length;
      paramInt = 0;
      if (paramInt < j)
      {
        b localb = arrayOfb[paramInt];
        if (localb.g == i) {
          localObject = localb;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(222745);
        return localObject;
        paramInt += 1;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.el
 * JD-Core Version:    0.7.0.1
 */