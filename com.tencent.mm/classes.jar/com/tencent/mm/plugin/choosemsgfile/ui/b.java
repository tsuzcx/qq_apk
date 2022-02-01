package com.tencent.mm.plugin.choosemsgfile.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;

public final class b
  extends com.tencent.mm.plugin.multitask.a.b
{
  public b(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public final Activity getActivity()
  {
    AppMethodBeat.i(237151);
    Activity localActivity = (Activity)Objects.requireNonNull(super.getActivity());
    AppMethodBeat.o(237151);
    return localActivity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.b
 * JD-Core Version:    0.7.0.1
 */