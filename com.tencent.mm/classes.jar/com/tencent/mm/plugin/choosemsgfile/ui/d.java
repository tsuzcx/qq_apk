package com.tencent.mm.plugin.choosemsgfile.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.a.b;
import java.util.Objects;

public final class d
  extends b
{
  public d(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public final Activity getActivity()
  {
    AppMethodBeat.i(262559);
    Activity localActivity = (Activity)Objects.requireNonNull(super.getActivity());
    AppMethodBeat.o(262559);
    return localActivity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.d
 * JD-Core Version:    0.7.0.1
 */