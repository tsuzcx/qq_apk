package com.tencent.mm.plugin.emojicapture.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.ContextThemeWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$1
  implements a.a
{
  b$1(Context paramContext, Intent paramIntent) {}
  
  public final void ha(boolean paramBoolean)
  {
    AppMethodBeat.i(104401);
    if (paramBoolean)
    {
      if ((this.val$context instanceof Activity))
      {
        ((Activity)this.val$context).startActivityForResult(this.val$intent, this.val$requestCode);
        AppMethodBeat.o(104401);
        return;
      }
      if ((this.val$context instanceof ContextThemeWrapper))
      {
        localContext = ((ContextThemeWrapper)this.val$context).getBaseContext();
        if ((localContext instanceof Activity))
        {
          ((Activity)localContext).startActivityForResult(this.val$intent, this.val$requestCode);
          AppMethodBeat.o(104401);
          return;
        }
        localContext = this.val$context;
        localObject = this.val$intent;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/emojicapture/api/TakeEmojiCapture$1", "onCheckResult", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/emojicapture/api/TakeEmojiCapture$1", "onCheckResult", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(104401);
        return;
      }
      Context localContext = this.val$context;
      Object localObject = this.val$intent;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/emojicapture/api/TakeEmojiCapture$1", "onCheckResult", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/emojicapture/api/TakeEmojiCapture$1", "onCheckResult", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(104401);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.api.b.1
 * JD-Core Version:    0.7.0.1
 */