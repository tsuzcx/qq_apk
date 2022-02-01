package com.tencent.mm.plugin.appbrand.launching;

import android.content.res.Resources;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.e.i.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

abstract class bb<T>
  implements g, Callable<T>
{
  protected volatile long lnD = 0L;
  protected volatile long lnE = 0L;
  protected volatile long lnF = 0L;
  private boolean lnG = true;
  
  public final void Oq(String paramString)
  {
    if (!this.lnG)
    {
      ac.e(getTag(), "silent toast: %s", new Object[] { paramString });
      return;
    }
    bc.Oq(paramString);
  }
  
  final Future<T> bnK()
  {
    return h.JZN.d(new a());
  }
  
  final T bnL()
  {
    this.lnD = bs.eWj();
    Object localObject = call();
    this.lnE = bs.eWj();
    this.lnF = (this.lnE - this.lnD);
    return localObject;
  }
  
  public void gS(boolean paramBoolean)
  {
    this.lnG = paramBoolean;
  }
  
  public final String getKey()
  {
    return getTag();
  }
  
  abstract String getTag();
  
  public final void tG(int paramInt)
  {
    Oq(ai.getResources().getString(paramInt));
  }
  
  final class a
    implements g, Callable<T>
  {
    a() {}
    
    public final T call()
    {
      AppMethodBeat.i(186843);
      bb.this.lnD = bs.eWj();
      try
      {
        Object localObject1 = bb.this.call();
        return localObject1;
      }
      finally
      {
        bb.this.lnE = bs.eWj();
        bb.this.lnF = (bb.this.lnE - bb.this.lnD);
        AppMethodBeat.o(186843);
      }
    }
    
    public final String getKey()
    {
      AppMethodBeat.i(186842);
      String str = bb.this.getTag();
      AppMethodBeat.o(186842);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.bb
 * JD-Core Version:    0.7.0.1
 */