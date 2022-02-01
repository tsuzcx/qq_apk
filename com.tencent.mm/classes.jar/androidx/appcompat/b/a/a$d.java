package androidx.appcompat.b.a;

import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$d
  extends a.f
{
  private final ObjectAnimator jF;
  private final boolean jG;
  
  a$d(AnimationDrawable paramAnimationDrawable, boolean paramBoolean1, boolean paramBoolean2)
  {
    super((byte)0);
    AppMethodBeat.i(199275);
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
      paramAnimationDrawable.setDuration(locale.jJ);
      paramAnimationDrawable.setInterpolator(locale);
      this.jG = paramBoolean2;
      this.jF = paramAnimationDrawable;
      AppMethodBeat.o(199275);
      return;
      i = 0;
      break;
      label116:
      j -= 1;
    }
  }
  
  public final boolean cl()
  {
    return this.jG;
  }
  
  public final void cm()
  {
    AppMethodBeat.i(199290);
    this.jF.reverse();
    AppMethodBeat.o(199290);
  }
  
  public final void start()
  {
    AppMethodBeat.i(199286);
    this.jF.start();
    AppMethodBeat.o(199286);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(199293);
    this.jF.cancel();
    AppMethodBeat.o(199293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.b.a.a.d
 * JD-Core Version:    0.7.0.1
 */