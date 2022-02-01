package com.bumptech.glide.c.d.e;

import android.graphics.Bitmap;
import com.bumptech.glide.b.a;
import com.bumptech.glide.c.b.q;
import com.bumptech.glide.c.d.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class e
  extends b<c>
  implements q
{
  public e(c paramc)
  {
    super(paramc);
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(77503);
    g localg = ((c)this.drawable).aLT.aLY;
    int i = localg.aLZ.oc();
    int j = com.bumptech.glide.h.j.i(localg.pJ().getWidth(), localg.pJ().getHeight(), localg.pJ().getConfig());
    AppMethodBeat.o(77503);
    return j + i;
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(77505);
    ((c)this.drawable).pE().prepareToDraw();
    AppMethodBeat.o(77505);
  }
  
  public final Class<c> oQ()
  {
    return c.class;
  }
  
  public final void recycle()
  {
    AppMethodBeat.i(77504);
    ((c)this.drawable).stop();
    Object localObject = (c)this.drawable;
    ((c)localObject).aHT = true;
    localObject = ((c)localObject).aLT.aLY;
    ((g)localObject).callbacks.clear();
    ((g)localObject).pL();
    ((g)localObject).isRunning = false;
    if (((g)localObject).aMd != null)
    {
      ((g)localObject).aDc.c(((g)localObject).aMd);
      ((g)localObject).aMd = null;
    }
    if (((g)localObject).aMf != null)
    {
      ((g)localObject).aDc.c(((g)localObject).aMf);
      ((g)localObject).aMf = null;
    }
    if (((g)localObject).aMh != null)
    {
      ((g)localObject).aDc.c(((g)localObject).aMh);
      ((g)localObject).aMh = null;
    }
    ((g)localObject).aLZ.clear();
    ((g)localObject).aMe = true;
    AppMethodBeat.o(77504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.d.e.e
 * JD-Core Version:    0.7.0.1
 */