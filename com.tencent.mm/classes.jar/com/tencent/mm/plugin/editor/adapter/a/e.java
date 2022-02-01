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
  private View psM;
  
  public e(View paramView, j paramj)
  {
    super(paramView, paramj);
    AppMethodBeat.i(181653);
    this.psv.setVisibility(8);
    this.dsD.setVisibility(8);
    this.jld.setVisibility(8);
    this.psv.setOnClickListener(null);
    this.psA.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181652);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/adapter/itemholder/EditorSplitItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        e.this.psu.ceA();
        e.this.psu.requestFocus();
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
    parama = (RelativeLayout.LayoutParams)this.psB.getLayoutParams();
    parama.bottomMargin = 0;
    parama.topMargin = 0;
    this.psB.setLayoutParams(parama);
    this.psA.setVisibility(0);
    this.psM = this.auu.findViewById(2131302940);
    AppMethodBeat.o(181654);
  }
  
  public final int cdT()
  {
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a.e
 * JD-Core Version:    0.7.0.1
 */