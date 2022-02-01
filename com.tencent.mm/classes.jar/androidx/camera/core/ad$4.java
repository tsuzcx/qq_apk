package androidx.camera.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class ad$4
  implements ThreadFactory
{
  private final AtomicInteger HS;
  
  ad$4(ad paramad)
  {
    AppMethodBeat.i(198253);
    this.HS = new AtomicInteger(0);
    AppMethodBeat.o(198253);
  }
  
  public final Thread newThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(198257);
    paramRunnable = new Thread(paramRunnable, "CameraX-image_capture_" + this.HS.getAndIncrement());
    AppMethodBeat.o(198257);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.camera.core.ad.4
 * JD-Core Version:    0.7.0.1
 */