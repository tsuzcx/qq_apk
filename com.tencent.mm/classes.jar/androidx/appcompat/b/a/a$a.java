package androidx.appcompat.b.a;

import android.graphics.drawable.Animatable;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$a
  extends a.f
{
  private final Animatable jB;
  
  a$a(Animatable paramAnimatable)
  {
    super((byte)0);
    this.jB = paramAnimatable;
  }
  
  public final void start()
  {
    AppMethodBeat.i(199276);
    this.jB.start();
    AppMethodBeat.o(199276);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(199283);
    this.jB.stop();
    AppMethodBeat.o(199283);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.appcompat.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */