package com.tencent.mm.plugin.gallery.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.thumbplayer.view.ThumbPlayerVideoView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;

final class d$a
  implements View.OnClickListener
{
  private final d.b Ccg;
  private final String filePath;
  
  public d$a(d paramd, d.b paramb, String paramString)
  {
    this.filePath = paramString;
    this.Ccg = paramb;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111515);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/gallery/ui/ImageAdapter$VideoItemClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if (!u.agG(this.filePath))
    {
      Log.w("MicroMsg.ImageAdapter", "File doesn't exists anymore");
      a.a(this, "com/tencent/mm/plugin/gallery/ui/ImageAdapter$VideoItemClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(111515);
      return;
    }
    this.Ccg.Ccl.setVideoPath(this.filePath);
    a.a(this, "com/tencent/mm/plugin/gallery/ui/ImageAdapter$VideoItemClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(111515);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.d.a
 * JD-Core Version:    0.7.0.1
 */