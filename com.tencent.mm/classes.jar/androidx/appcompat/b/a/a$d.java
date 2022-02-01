package androidx.appcompat.b.a;

import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$d
  extends a.f
{
  private final ObjectAnimator iK;
  private final boolean iL;
  
  a$d(AnimationDrawable paramAnimationDrawable, boolean paramBoolean1, boolean paramBoolean2)
  {
    super((byte)0);
    AppMethodBeat.i(238652);
    int j = paramAnimationDrawable.getNumberOfFrames();
    int i;
    if (paramBoolean1)
    {
      i = j - 1;
      if (!paramBoolean1) {
        break label116;
      }
      j = 0;
    }
    for (;;)
    {
      a.e locale = new a.e(paramAnimationDrawable, paramBoolean1);
      paramAnimationDrawable = ObjectAnimator.ofInt(paramAnimationDrawable, "currentIndex", new int[] { i, j });
      if (Build.VERSION.SDK_INT >= 18) {
        paramAnimationDrawable.setAutoCancel(true);
      }
      paramAnimationDrawable.setDuration(locale.iO);
      paramAnimationDrawable.setInterpolator(locale);
      this.iL = paramBoolean2;
      this.iK = paramAnimationDrawable;
      AppMethodBeat.o(238652);
      return;
      i = 0;
      break;
      label116:
      j -= 1;
    }
  }
  
  public final boolean bs()
  {
    return this.iL;
  }
  
  public final void bt()
  {
    AppMethodBeat.i(238654);
    this.iK.reverse();
    AppMethodBeat.o(238654);
  }
  
  public final void start()
  {
    AppMethodBeat.i(238653);
    this.iK.start();
    AppMethodBeat.o(238653);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(238656);
    this.iK.cancel();
    AppMethodBeat.o(238656);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.appcompat.b.a.a.d
 * JD-Core Version:    0.7.0.1
 */