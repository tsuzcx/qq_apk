package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.vfs.k;

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
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/ImageAdapter$VideoItemClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
    paramView = new Intent();
    paramView.setAction("android.intent.action.VIEW");
    localObject = new k(this.filePath);
    o.a(this.tYw.mContext, paramView, (k)localObject, "video/*");
    try
    {
      localObject = this.tYw.mContext;
      paramView = new com.tencent.mm.hellhoundlib.b.a().bc(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramView.ahE(), "com/tencent/mm/plugin/gallery/ui/ImageAdapter$VideoItemClickListener", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject).startActivity((Intent)paramView.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/gallery/ui/ImageAdapter$VideoItemClickListener", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      label143:
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImageAdapter$VideoItemClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(111515);
      return;
    }
    catch (Exception paramView)
    {
      break label143;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.d.a
 * JD-Core Version:    0.7.0.1
 */