package com.google.android.gms.dynamic;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class zza$5
  implements View.OnClickListener
{
  zza$5(Context paramContext, Intent paramIntent) {}
  
  public final void onClick(View paramView)
  {
    try
    {
      this.zztf.startActivity(this.zzaRJ);
      return;
    }
    catch (ActivityNotFoundException paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.dynamic.zza.5
 * JD-Core Version:    0.7.0.1
 */