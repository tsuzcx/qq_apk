package com.tencent.mm.plugin.masssend.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.u;

final class c$c
  implements View.OnClickListener
{
  private String fileName;
  private int length;
  private int size;
  private int videoSource;
  
  public c$c(c paramc, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.fileName = paramString;
    this.videoSource = paramInt1;
    this.length = paramInt3;
    this.size = paramInt2;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(26407);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnVideoClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    bg.aVF();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      u.g(c.a(this.znT), null);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnVideoClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(26407);
      return;
    }
    if (this.videoSource == 2) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      o.bhj();
      boolean bool2 = r.Ql(t.Qw(this.fileName));
      Log.i("MicroMsg.HistoryAdapter", "video clicked, path:%s, isExport:%b, typeQt:%b", new Object[] { this.fileName, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      com.tencent.mm.plugin.masssend.a.jRt.a(bool1, bool2, c.a(this.znT), this.fileName, this.length, this.size);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnVideoClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(26407);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.c.c
 * JD-Core Version:    0.7.0.1
 */