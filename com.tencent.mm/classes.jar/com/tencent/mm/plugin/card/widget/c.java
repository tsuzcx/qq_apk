package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.protocal.protobuf.xo;
import java.util.LinkedList;

public final class c
  extends a
{
  protected TextView nJK;
  protected TextView nJL;
  
  public c(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void G(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected final void bMS()
  {
    AppMethodBeat.i(113902);
    this.nJL = ((TextView)bMR().findViewById(2131297733));
    this.nJK = ((TextView)bMR().findViewById(2131297902));
    AppMethodBeat.o(113902);
  }
  
  protected final void bMT()
  {
    AppMethodBeat.i(113903);
    if ((this.nqp.bHV().CRF != null) && (this.nqp.bHV().CRF.size() > 0))
    {
      xo localxo = (xo)this.nqp.bHV().CRF.get(0);
      if (this.lKe != null) {
        this.lKe.setText(localxo.title);
      }
      if (this.nJK != null)
      {
        if (TextUtils.isEmpty(localxo.nrs)) {
          break label138;
        }
        this.nJK.setText(localxo.nrs);
      }
      while (this.nJL != null) {
        if (!TextUtils.isEmpty(localxo.nrt))
        {
          this.nJL.setText(localxo.nrt);
          AppMethodBeat.o(113903);
          return;
          label138:
          this.nJK.setVisibility(8);
        }
        else
        {
          this.nJL.setVisibility(8);
        }
      }
    }
    AppMethodBeat.o(113903);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.c
 * JD-Core Version:    0.7.0.1
 */