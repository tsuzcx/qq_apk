package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.e;

final class FavVideoView$8
  implements Runnable
{
  FavVideoView$8(FavVideoView paramFavVideoView, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(107569);
    Object localObject = new Intent();
    ((Intent)localObject).setAction("android.intent.action.VIEW");
    m.a(this.qVa.getContext(), (Intent)localObject, new e(this.qVb), "video/*");
    try
    {
      Context localContext = this.qVa.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/fav/ui/widget/FavVideoView$7", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/fav/ui/widget/FavVideoView$7", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(107569);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.FavVideoView", "startActivity fail, activity not found");
      h.l(this.qVa.getContext(), 2131758931, 2131758932);
      AppMethodBeat.o(107569);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavVideoView.8
 * JD-Core Version:    0.7.0.1
 */