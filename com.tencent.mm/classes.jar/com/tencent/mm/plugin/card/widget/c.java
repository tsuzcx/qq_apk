package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.protocal.protobuf.yg;
import java.util.LinkedList;

public final class c
  extends a
{
  protected TextView omK;
  protected TextView omL;
  
  public c(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void H(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected final void bUd()
  {
    AppMethodBeat.i(113902);
    this.omL = ((TextView)bUc().findViewById(2131297733));
    this.omK = ((TextView)bUc().findViewById(2131297902));
    AppMethodBeat.o(113902);
  }
  
  protected final void bUe()
  {
    AppMethodBeat.i(113903);
    if ((this.nTp.bPi().Ekq != null) && (this.nTp.bPi().Ekq.size() > 0))
    {
      yg localyg = (yg)this.nTp.bPi().Ekq.get(0);
      if (this.mmb != null) {
        this.mmb.setText(localyg.title);
      }
      if (this.omK != null)
      {
        if (TextUtils.isEmpty(localyg.nUs)) {
          break label138;
        }
        this.omK.setText(localyg.nUs);
      }
      while (this.omL != null) {
        if (!TextUtils.isEmpty(localyg.nUt))
        {
          this.omL.setText(localyg.nUt);
          AppMethodBeat.o(113903);
          return;
          label138:
          this.omK.setVisibility(8);
        }
        else
        {
          this.omL.setVisibility(8);
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