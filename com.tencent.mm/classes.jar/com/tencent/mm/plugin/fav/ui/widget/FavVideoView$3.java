package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.ui.base.h;
import java.io.File;

final class FavVideoView$3
  implements Runnable
{
  FavVideoView$3(FavVideoView paramFavVideoView, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(74716);
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    k.a(this.mEC.getContext(), localIntent, new File(this.mED), "video/*");
    try
    {
      this.mEC.getContext().startActivity(localIntent);
      AppMethodBeat.o(74716);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.FavVideoView", "startActivity fail, activity not found");
      h.h(this.mEC.getContext(), 2131299759, 2131299760);
      AppMethodBeat.o(74716);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavVideoView.3
 * JD-Core Version:    0.7.0.1
 */