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
  
  public abstract boolean a(String paramString, View paramView, Bundle paramBundle);
  
  public abstract boolean a(String paramString, View paramView, Bundle paramBundle, b paramb);
  
  public abstract void b(String paramString, View paramView);
  
  public abstract b.h bEK();
  
  public abstract b.f eE(int paramInt1, int paramInt2);
  
  public abstract void j(int paramInt, Bundle paramBundle);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(2625);
      opT = new a("DECODE_TYPE_DEFAULT", 0);
      opU = new a("DECODE_TYPE_ORIGIN", 1);
      opV = new a[] { opT, opU };
      AppMethodBeat.o(2625);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void vJ(int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void bEL();
    
    public abstract void gU(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.k
 * JD-Core Version:    0.7.0.1
 */