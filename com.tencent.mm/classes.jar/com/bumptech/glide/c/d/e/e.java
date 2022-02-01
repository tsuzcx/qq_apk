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
    g localg = ((c)this.drawable).aKc.aKh;
    int i = localg.aKi.nK();
    int j = com.bumptech.glide.h.j.i(localg.pr().getWidth(), localg.pr().getHeight(), localg.pr().getConfig());
    AppMethodBeat.o(77503);
    return j + i;
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(77505);
    ((c)this.drawable).pm().prepareToDraw();
    AppMethodBeat.o(77505);
  }
  
  public final Class<c> oy()
  {
    return c.class;
  }
  
  public final void recycle()
  {
    AppMethodBeat.i(77504);
    ((c)this.drawable).stop();
    Object localObject = (c)this.drawable;
    ((c)localObject).aGc = true;
    localObject = ((c)localObject).aKc.aKh;
    ((g)localObject).callbacks.clear();
    ((g)localObject).pt();
    ((g)localObject).isRunning = false;
    if (((g)localObject).aKm != null)
    {
      ((g)localObject).aBl.c(((g)localObject).aKm);
      ((g)localObject).aKm = null;
    }
    if (((g)localObject).aKo != null)
    {
      ((g)localObject).aBl.c(((g)localObject).aKo);
      ((g)localObject).aKo = null;
    }
    if (((g)localObject).aKq != null)
    {
      ((g)localObject).aBl.c(((g)localObject).aKq);
      ((g)localObject).aKq = null;
    }
    ((g)localObject).aKi.clear();
    ((g)localObject).aKn = true;
    AppMethodBeat.o(77504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.d.e.e
 * JD-Core Version:    0.7.0.1
 */