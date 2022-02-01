package androidx.transition;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AutoTransition
  extends TransitionSet
{
  public AutoTransition()
  {
    AppMethodBeat.i(191673);
    init();
    AppMethodBeat.o(191673);
  }
  
  public AutoTransition(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(191676);
    init();
    AppMethodBeat.o(191676);
  }
  
  private void init()
  {
    AppMethodBeat.i(191681);
    dz(1);
    c(new Fade(2)).c(new ChangeBounds()).c(new Fade(1));
    AppMethodBeat.o(191681);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.transition.AutoTransition
 * JD-Core Version:    0.7.0.1
 */