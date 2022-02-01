package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.vfs.e;

final class d$a
  implements View.OnClickListener
{
  private String filePath;
  
  public d$a(d paramd, String paramString)
  {
    this.filePath = paramString;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111515);
    paramView = new Intent();
    paramView.setAction("android.intent.action.VIEW");
    Object localObject = new e(this.filePath);
    m.a(this.sRb.mContext, paramView, (e)localObject, "video/*");
    try
    {
      localObject = this.sRb.mContext;
      paramView = new com.tencent.mm.hellhoundlib.b.a().ba(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramView.aeD(), "com/tencent/mm/plugin/gallery/ui/ImageAdapter$VideoItemClickListener", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject).startActivity((Intent)paramView.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/gallery/ui/ImageAdapter$VideoItemClickListener", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(111515);
      return;
    }
    catch (Exception paramView)
    {
      AppMethodBeat.o(111515);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.d.a
 * JD-Core Version:    0.7.0.1
 */