package com.tencent.mm.modelappbrand;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.modelappbrand.a.b.e;
import com.tencent.mm.modelappbrand.a.b.f;

public abstract interface i
  extends a
{
  public abstract b.e a(int paramInt1, int paramInt2, a parama);
  
  public abstract void a(String paramString, View paramView);
  
  public abstract boolean a(String paramString, View paramView, Bundle paramBundle);
  
  public abstract boolean a(String paramString, View paramView, Bundle paramBundle, i.b paramb);
  
  public abstract b.f acn();
  
  public abstract b.e cu(int paramInt1, int paramInt2);
  
  public abstract View e(Context paramContext, Bundle paramBundle);
  
  public abstract void f(int paramInt, Bundle paramBundle);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(51133);
      fpS = new a("DECODE_TYPE_DEFAULT", 0);
      fpT = new a("DECODE_TYPE_ORIGIN", 1);
      fpU = new a[] { fpS, fpT };
      AppMethodBeat.o(51133);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.i
 * JD-Core Version:    0.7.0.1
 */