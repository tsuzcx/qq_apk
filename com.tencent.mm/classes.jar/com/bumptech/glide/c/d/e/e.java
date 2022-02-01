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
    g localg = ((c)this.drawable).aJm.aJr;
    int i = localg.aJs.nA();
    int j = com.bumptech.glide.h.j.i(localg.ph().getWidth(), localg.ph().getHeight(), localg.ph().getConfig());
    AppMethodBeat.o(77503);
    return j + i;
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(77505);
    ((c)this.drawable).pc().prepareToDraw();
    AppMethodBeat.o(77505);
  }
  
  public final Class<c> oo()
  {
    return c.class;
  }
  
  public final void recycle()
  {
    AppMethodBeat.i(77504);
    ((c)this.drawable).stop();
    Object localObject = (c)this.drawable;
    ((c)localObject).aFm = true;
    localObject = ((c)localObject).aJm.aJr;
    ((g)localObject).callbacks.clear();
    ((g)localObject).pj();
    ((g)localObject).isRunning = false;
    if (((g)localObject).aJw != null)
    {
      ((g)localObject).aAr.c(((g)localObject).aJw);
      ((g)localObject).aJw = null;
    }
    if (((g)localObject).aJy != null)
    {
      ((g)localObject).aAr.c(((g)localObject).aJy);
      ((g)localObject).aJy = null;
    }
    if (((g)localObject).aJA != null)
    {
      ((g)localObject).aAr.c(((g)localObject).aJA);
      ((g)localObject).aJA = null;
    }
    ((g)localObject).aJs.clear();
    ((g)localObject).aJx = true;
    AppMethodBeat.o(77504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.d.e.e
 * JD-Core Version:    0.7.0.1
 */