package com.tencent.mm.modelappbrand;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.modelappbrand.a.b.h;

public abstract interface k
  extends a
{
  public abstract View a(Context paramContext, Bundle paramBundle, boolean paramBoolean, c paramc);
  
  public abstract b.f a(int paramInt1, int paramInt2, a parama);
  
  public abstract void a(String paramString, View paramView);
  
  public abstract boolean a(String paramString, View paramView, Bundle paramBundle);
  
  public abstract boolean a(String paramString, View paramView, Bundle paramBundle, b paramb);
  
  public abstract b.h aDH();
  
  public abstract b.f de(int paramInt1, int paramInt2);
  
  public abstract void h(int paramInt, Bundle paramBundle);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(2625);
      hKr = new a("DECODE_TYPE_DEFAULT", 0);
      hKs = new a("DECODE_TYPE_ORIGIN", 1);
      hKt = new a[] { hKr, hKs };
      AppMethodBeat.o(2625);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void oM(int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void aDI();
    
    public abstract void ez(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.k
 * JD-Core Version:    0.7.0.1
 */