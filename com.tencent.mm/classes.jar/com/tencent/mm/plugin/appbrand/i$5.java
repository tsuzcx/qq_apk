package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.app.ActivityManager.TaskDescription;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.b;

final class i$5
  extends b.b
{
  i$5(i parami, Activity paramActivity, ActivityManager.TaskDescription paramTaskDescription) {}
  
  public final void w(Bitmap paramBitmap)
  {
    AppMethodBeat.i(141624);
    this.val$activity.setTaskDescription(new ActivityManager.TaskDescription(this.gQb.getLabel(), paramBitmap, this.gQb.getPrimaryColor()));
    AppMethodBeat.o(141624);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i.5
 * JD-Core Version:    0.7.0.1
 */