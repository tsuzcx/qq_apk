package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.o;

final class FavVideoView$8
  implements Runnable
{
  FavVideoView$8(FavVideoView paramFavVideoView, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(107569);
    Object localObject = new Intent();
    ((Intent)localObject).setAction("android.intent.action.VIEW");
    FileProviderHelper.setIntentDataAndType(this.tnk.getContext(), (Intent)localObject, new o(this.tnl), "video/*", false);
    try
    {
      Context localContext = this.tnk.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/fav/ui/widget/FavVideoView$7", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/fav/ui/widget/FavVideoView$7", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(107569);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.FavVideoView", "startActivity fail, activity not found");
      h.n(this.tnk.getContext(), 2131759255, 2131759256);
      AppMethodBeat.o(107569);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavVideoView.8
 * JD-Core Version:    0.7.0.1
 */