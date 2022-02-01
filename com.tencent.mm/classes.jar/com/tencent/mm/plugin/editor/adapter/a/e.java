package com.tencent.mm.plugin.editor.adapter.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.model.a.a;
import com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.editor.model.nativenote.manager.j;

public final class e
  extends d
{
  private View oPe;
  
  public e(View paramView, j paramj)
  {
    super(paramView, paramj);
    AppMethodBeat.i(181653);
    this.oON.setVisibility(8);
    this.dhf.setVisibility(8);
    this.iRV.setVisibility(8);
    this.oON.setOnClickListener(null);
    this.oOS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181652);
        e.this.oOM.bZW();
        e.this.oOM.requestFocus();
        AppMethodBeat.o(181652);
      }
    });
    AppMethodBeat.o(181653);
  }
  
  public final void a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181654);
    super.a(parama, paramInt1, paramInt2);
    if (parama.getType() != -1)
    {
      AppMethodBeat.o(181654);
      return;
    }
    parama = (RelativeLayout.LayoutParams)this.oOT.getLayoutParams();
    parama.bottomMargin = 0;
    parama.topMargin = 0;
    this.oOT.setLayoutParams(parama);
    this.oOS.setVisibility(0);
    this.oPe = this.asD.findViewById(2131302940);
    AppMethodBeat.o(181654);
  }
  
  public final int bZp()
  {
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a.e
 * JD-Core Version:    0.7.0.1
 */