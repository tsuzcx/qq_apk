package com.tencent.mm.plugin.appbrand.game.f.a;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.b;
import com.tencent.mm.media.i.b.a;
import java.util.concurrent.atomic.AtomicBoolean;

final class a$2
  implements Runnable
{
  a$2(a parama, int paramInt1, int paramInt2, SurfaceTexture paramSurfaceTexture) {}
  
  public final void run()
  {
    AppMethodBeat.i(143183);
    a.a(this.htO, this.val$width);
    a.b(this.htO, this.val$height);
    a.a(this.htO, this.htP);
    a locala = this.htO;
    b.a locala1 = b.eZw;
    a.a(locala, b.a.a(new Surface(this.htP), null, 0, 0));
    if (a.a(this.htO) != null)
    {
      a.a(this.htO).onSurfaceCreated(null, null);
      a.a(this.htO).cn(this.val$width, this.val$height);
      a.a(this.htO).cm(this.val$width, this.val$height);
      a.a(this.htO).cD(true);
    }
    a.a(this.htO, a.b(this.htO).getSurfaceTexture(), this.val$width, this.val$height);
    a.c(this.htO).getAndSet(true);
    if (a.d(this.htO) != null)
    {
      a.d(this.htO);
      a.b(this.htO);
    }
    AppMethodBeat.o(143183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.a.a.2
 * JD-Core Version:    0.7.0.1
 */