package com.tencent.mm.plugin.gallery.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.thumbplayer.view.ThumbPlayerVideoView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;

final class d$a
  implements View.OnClickListener
{
  private final d.b HOi;
  private final String filePath;
  
  public d$a(d paramd, d.b paramb, String paramString)
  {
    this.filePath = paramString;
    this.HOi = paramb;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111515);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/gallery/ui/ImageAdapter$VideoItemClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (!y.ZC(this.filePath))
    {
      Log.w("MicroMsg.ImageAdapter", "File doesn't exists anymore");
      a.a(this, "com/tencent/mm/plugin/gallery/ui/ImageAdapter$VideoItemClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(111515);
      return;
    }
    this.HOi.HOn.setVideoPath(this.filePath);
    a.a(this, "com/tencent/mm/plugin/gallery/ui/ImageAdapter$VideoItemClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(111515);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.d.a
 * JD-Core Version:    0.7.0.1
 */