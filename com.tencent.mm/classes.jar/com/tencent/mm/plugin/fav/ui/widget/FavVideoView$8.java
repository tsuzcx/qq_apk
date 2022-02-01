package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.k;

final class FavVideoView$8
  implements Runnable
{
  FavVideoView$8(FavVideoView paramFavVideoView, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(107569);
    Object localObject = new Intent();
    ((Intent)localObject).setAction("android.intent.action.VIEW");
    o.a(this.rNz.getContext(), (Intent)localObject, new k(this.rNA), "video/*");
    try
    {
      Context localContext = this.rNz.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/fav/ui/widget/FavVideoView$7", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/fav/ui/widget/FavVideoView$7", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(107569);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.FavVideoView", "startActivity fail, activity not found");
      h.l(this.rNz.getContext(), 2131758931, 2131758932);
      AppMethodBeat.o(107569);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavVideoView.8
 * JD-Core Version:    0.7.0.1
 */