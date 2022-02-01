package com.bumptech.glide.load.d.e;

import android.graphics.Bitmap;
import com.bumptech.glide.b.a;
import com.bumptech.glide.g.k;
import com.bumptech.glide.j;
import com.bumptech.glide.load.b.r;
import com.bumptech.glide.load.d.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class e
  extends b<c>
  implements r
{
  public e(c paramc)
  {
    super(paramc);
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(77503);
    g localg = ((c)this.drawable).aLL.aLQ;
    int i = localg.aLR.oi();
    int j = k.i(localg.pO().getWidth(), localg.pO().getHeight(), localg.pO().getConfig());
    AppMethodBeat.o(77503);
    return j + i;
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(77505);
    ((c)this.drawable).pJ().prepareToDraw();
    AppMethodBeat.o(77505);
  }
  
  public final Class<c> oV()
  {
    return c.class;
  }
  
  public final void recycle()
  {
    AppMethodBeat.i(77504);
    ((c)this.drawable).stop();
    Object localObject = (c)this.drawable;
    ((c)localObject).aHN = true;
    localObject = ((c)localObject).aLL.aLQ;
    ((g)localObject).callbacks.clear();
    ((g)localObject).pQ();
    ((g)localObject).isRunning = false;
    if (((g)localObject).aLV != null)
    {
      ((g)localObject).aDc.c(((g)localObject).aLV);
      ((g)localObject).aLV = null;
    }
    if (((g)localObject).aLX != null)
    {
      ((g)localObject).aDc.c(((g)localObject).aLX);
      ((g)localObject).aLX = null;
    }
    if (((g)localObject).aLZ != null)
    {
      ((g)localObject).aDc.c(((g)localObject).aLZ);
      ((g)localObject).aLZ = null;
    }
    ((g)localObject).aLR.clear();
    ((g)localObject).aLW = true;
    AppMethodBeat.o(77504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.d.e.e
 * JD-Core Version:    0.7.0.1
 */