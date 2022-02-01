package com.tencent.mm.plugin.masssend.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.vfs.s;

final class c$a
  implements View.OnClickListener
{
  private String fileName;
  private int znr;
  
  public c$a(c paramc, String paramString, int paramInt)
  {
    this.fileName = paramString;
    this.znr = paramInt;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(26405);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnImageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    Log.v("MicroMsg.HistoryAdapter", "image clicked:" + this.fileName);
    bg.aVF();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      u.g(c.a(this.znT), null);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnImageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(26405);
      return;
    }
    paramView = new StringBuilder();
    bg.aVF();
    paramView = com.tencent.mm.model.c.aSY() + this.fileName;
    if ((paramView == null) || (paramView.equals("")) || (!s.YS(paramView)))
    {
      Log.d("MicroMsg.HistoryAdapter", "showImg : imgPath is null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnImageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(26405);
      return;
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("key_compress_type", this.znr);
    ((Intent)localObject).putExtra("key_favorite", false);
    ((Intent)localObject).putExtra("key_image_path", paramView);
    com.tencent.mm.plugin.masssend.a.jRt.d(c.a(this.znT), (Intent)localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnImageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(26405);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.c.a
 * JD-Core Version:    0.7.0.1
 */