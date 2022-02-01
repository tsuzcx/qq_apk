package com.tencent.mm.plugin.editor.adapter.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.editor.model.nativenote.manager.j;

public final class e
  extends d
{
  private View qOJ;
  
  public e(View paramView, j paramj)
  {
    super(paramView, paramj);
    AppMethodBeat.i(181653);
    this.qOs.setVisibility(8);
    this.dKU.setVisibility(8);
    this.kmg.setVisibility(8);
    this.qOs.setOnClickListener(null);
    this.qOx.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181652);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/adapter/itemholder/EditorSplitItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        e.this.qOr.cDF();
        e.this.qOr.requestFocus();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/adapter/itemholder/EditorSplitItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(181652);
      }
    });
    AppMethodBeat.o(181653);
  }
  
  public final void a(com.tencent.mm.plugin.editor.model.a.a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181654);
    super.a(parama, paramInt1, paramInt2);
    if (parama.getType() != -1)
    {
      AppMethodBeat.o(181654);
      return;
    }
    parama = (RelativeLayout.LayoutParams)this.qOy.getLayoutParams();
    parama.bottomMargin = 0;
    parama.topMargin = 0;
    this.qOy.setLayoutParams(parama);
    this.qOx.setVisibility(0);
    this.qOJ = this.aus.findViewById(2131305527);
    AppMethodBeat.o(181654);
  }
  
  public final int cCY()
  {
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a.e
 * JD-Core Version:    0.7.0.1
 */