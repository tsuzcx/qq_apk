package com.tencent.mm.plugin.editor.adapter.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.d.g;
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
    this.xwT.setVisibility(0);
    this.hIz.setVisibility(8);
    this.pZr.setVisibility(8);
    this.xwT.setTag(this);
    this.xwT.setOnClickListener(this.xxi);
    AppMethodBeat.o(181661);
  }
  
  public final void a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181662);
    this.xwW.setImageResource(d.g.msg_state_fail_resend);
    this.xwU.setText(((k)parama).title);
    this.xwV.setText(((k)parama).content);
    super.a(parama, paramInt1, paramInt2);
    AppMethodBeat.o(181662);
  }
  
  public final int dvW()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a.g
 * JD-Core Version:    0.7.0.1
 */