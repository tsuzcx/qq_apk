package androidx.transition;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AutoTransition
  extends TransitionSet
{
  public AutoTransition()
  {
    AppMethodBeat.i(201210);
    init();
    AppMethodBeat.o(201210);
  }
  
  public AutoTransition(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(201218);
    init();
    AppMethodBeat.o(201218);
  }
  
  private void init()
  {
    AppMethodBeat.i(201229);
    gJ(1);
    c(new Fade(2)).c(new ChangeBounds()).c(new Fade(1));
    AppMethodBeat.o(201229);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.transition.AutoTransition
 * JD-Core Version:    0.7.0.1
 */