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
  private byte _hellAccFlag_;
  
  zze(Context paramContext, Intent paramIntent) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(12131);
    try
    {
      paramView = this.val$context;
      Object localObject = this.zzabl;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/google/android/gms/dynamic/zze", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/google/android/gms/dynamic/zze", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(12131);
      return;
    }
    catch (ActivityNotFoundException paramView)
    {
      AppMethodBeat.o(12131);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.dynamic.zze
 * JD-Core Version:    0.7.0.1
 */