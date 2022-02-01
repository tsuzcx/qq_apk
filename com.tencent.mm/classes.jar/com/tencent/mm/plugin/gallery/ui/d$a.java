package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.vfs.o;

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
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/ImageAdapter$VideoItemClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    paramView = new Intent();
    paramView.setAction("android.intent.action.VIEW");
    localObject = new o(this.filePath);
    FileProviderHelper.setIntentDataAndType(this.xpJ.mContext, paramView, (o)localObject, "video/*", false);
    try
    {
      localObject = this.xpJ.mContext;
      paramView = new com.tencent.mm.hellhoundlib.b.a().bl(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramView.axQ(), "com/tencent/mm/plugin/gallery/ui/ImageAdapter$VideoItemClickListener", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject).startActivity((Intent)paramView.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/gallery/ui/ImageAdapter$VideoItemClickListener", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      label144:
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImageAdapter$VideoItemClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(111515);
      return;
    }
    catch (Exception paramView)
    {
      break label144;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.d.a
 * JD-Core Version:    0.7.0.1
 */