package com.tencent.mm.plugin.emojicapture.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.ContextThemeWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$1
  implements b.a
{
  c$1(Context paramContext, Intent paramIntent) {}
  
  public final void gR(boolean paramBoolean)
  {
    AppMethodBeat.i(57468);
    if (paramBoolean)
    {
      if ((this.val$context instanceof Activity))
      {
        ((Activity)this.val$context).startActivityForResult(this.val$intent, this.val$requestCode);
        AppMethodBeat.o(57468);
        return;
      }
      if ((this.val$context instanceof ContextThemeWrapper))
      {
        Context localContext = ((ContextThemeWrapper)this.val$context).getBaseContext();
        if ((localContext instanceof Activity))
        {
          ((Activity)localContext).startActivityForResult(this.val$intent, this.val$requestCode);
          AppMethodBeat.o(57468);
          return;
        }
        this.val$context.startActivity(this.val$intent);
        AppMethodBeat.o(57468);
        return;
      }
      this.val$context.startActivity(this.val$intent);
    }
    AppMethodBeat.o(57468);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.api.c.1
 * JD-Core Version:    0.7.0.1
 */