package com.google.android.gms.dynamic;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zze
  implements View.OnClickListener
{
  zze(Context paramContext, Intent paramIntent) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(61639);
    try
    {
      this.val$context.startActivity(this.zzabl);
      AppMethodBeat.o(61639);
      return;
    }
    catch (ActivityNotFoundException paramView)
    {
      AppMethodBeat.o(61639);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.dynamic.zze
 * JD-Core Version:    0.7.0.1
 */