package com.google.android.material.snackbar;

import com.google.android.material.behavior.SwipeDismissBehavior;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class BaseTransientBottomBar$a
{
  public BaseTransientBottomBar$a(SwipeDismissBehavior<?> paramSwipeDismissBehavior)
  {
    AppMethodBeat.i(239202);
    paramSwipeDismissBehavior.bwg = SwipeDismissBehavior.P(0.1F);
    paramSwipeDismissBehavior.bwh = SwipeDismissBehavior.P(0.6F);
    paramSwipeDismissBehavior.bwe = 0;
    AppMethodBeat.o(239202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.snackbar.BaseTransientBottomBar.a
 * JD-Core Version:    0.7.0.1
 */