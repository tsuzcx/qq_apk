package androidx.appcompat.b.a;

import android.graphics.drawable.Animatable;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$a
  extends a.f
{
  private final Animatable iG;
  
  a$a(Animatable paramAnimatable)
  {
    super((byte)0);
    this.iG = paramAnimatable;
  }
  
  public final void start()
  {
    AppMethodBeat.i(238632);
    this.iG.start();
    AppMethodBeat.o(238632);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(238634);
    this.iG.stop();
    AppMethodBeat.o(238634);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.appcompat.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */