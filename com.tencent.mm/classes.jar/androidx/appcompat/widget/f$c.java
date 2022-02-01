package androidx.appcompat.widget;

import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import androidx.b.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class f$c
  extends e<Integer, PorterDuffColorFilter>
{
  public f$c()
  {
    super(6);
  }
  
  static int b(int paramInt, PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(240744);
    int i = paramMode.hashCode();
    AppMethodBeat.o(240744);
    return (paramInt + 31) * 31 + i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.appcompat.widget.f.c
 * JD-Core Version:    0.7.0.1
 */