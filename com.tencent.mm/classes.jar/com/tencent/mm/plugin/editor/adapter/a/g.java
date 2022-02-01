package com.tencent.mm.plugin.editor.adapter.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.model.a.a;
import com.tencent.mm.plugin.editor.model.a.k;
import com.tencent.mm.plugin.editor.model.nativenote.manager.j;

public final class g
  extends d
{
  public g(View paramView, j paramj)
  {
    super(paramView, paramj);
    AppMethodBeat.i(181661);
    this.pzb.setVisibility(0);
    this.dtJ.setVisibility(8);
    this.jnX.setVisibility(8);
    this.pzb.setTag(this);
    this.pzb.setOnClickListener(this.pzq);
    AppMethodBeat.o(181661);
  }
  
  public final void a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181662);
    this.pze.setImageResource(2131690875);
    this.pzc.setText(((k)parama).title);
    this.pzd.setText(((k)parama).content);
    super.a(parama, paramInt1, paramInt2);
    AppMethodBeat.o(181662);
  }
  
  public final int cfi()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a.g
 * JD-Core Version:    0.7.0.1
 */