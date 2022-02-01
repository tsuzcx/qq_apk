package com.tencent.mm.plugin.editor.widget;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class a$5
  implements View.OnClickListener
{
  public a$5(a parama, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(181974);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/editor/widget/EditorFooterPanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    Log.i("MicroMsg.EditorFooterPanel", "go to GalleryEntryUI");
    com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().af(-1, false);
    paramView = new Intent();
    paramView.putExtra("max_select_count", 9);
    paramView.putExtra("query_source_type", 13);
    paramView.putExtra("query_media_type", 3);
    paramView.putExtra("show_header_view", false);
    paramView.addFlags(67108864);
    paramView.putExtra("key_can_select_video_and_pic", true);
    com.tencent.mm.by.c.b(this.val$context, "gallery", ".ui.GalleryEntryUI", paramView, 4096);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/EditorFooterPanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(181974);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.widget.a.5
 * JD-Core Version:    0.7.0.1
 */