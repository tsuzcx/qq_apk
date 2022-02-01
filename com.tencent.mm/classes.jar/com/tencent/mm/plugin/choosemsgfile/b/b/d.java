package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.os.Looper;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.q;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;
import com.tencent.mm.plugin.choosemsgfile.b.d.c;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public abstract class d
  extends a<m>
{
  public d(g paramg, bu parambu)
  {
    super(paramg, parambu);
  }
  
  private void a(final m paramm)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      b(paramm);
      return;
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123266);
        d.a(d.this, paramm);
        AppMethodBeat.o(123266);
      }
    });
  }
  
  private void b(m paramm)
  {
    switch (this.oSe)
    {
    default: 
    case 1: 
    case 2: 
      do
      {
        return;
        paramm.jcf.setVisibility(0);
        paramm.oSC.setVisibility(8);
        paramm.fQc.setVisibility(8);
        paramm.oSI.setVisibility(8);
        paramm.oSJ.setVisibility(8);
        return;
        paramm.jcf.setVisibility(0);
        paramm.oSC.setVisibility(0);
        paramm.fQc.setVisibility(8);
        paramm.oSI.setVisibility(8);
        paramm.oSJ.setVisibility(8);
      } while (this.apW <= 0);
      int i = (int)(this.fq / this.apW * 100.0F);
      if ((i == -1) || (i >= 100))
      {
        paramm.oSC.setProgress(100);
        return;
      }
      paramm.oSC.setProgress(i);
      return;
    case 3: 
      paramm.jcf.setVisibility(8);
      paramm.oSC.setVisibility(8);
      paramm.fQc.setVisibility(0);
      paramm.oSI.setVisibility(0);
      paramm.oSJ.setVisibility(8);
      return;
    case 4: 
      paramm.jcf.setVisibility(8);
      paramm.oSC.setVisibility(8);
      paramm.fQc.setVisibility(8);
      paramm.oSI.setVisibility(8);
      paramm.oSJ.setVisibility(0);
      return;
    case 5: 
      paramm.jcf.setVisibility(8);
      paramm.oSC.setVisibility(8);
      paramm.fQc.setVisibility(8);
      paramm.oSI.setVisibility(8);
      paramm.oSJ.setVisibility(0);
      return;
    }
    paramm.jcf.setVisibility(8);
    paramm.oSC.setVisibility(8);
    paramm.fQc.setVisibility(0);
    paramm.oSI.setVisibility(0);
    paramm.fQc.setChecked(false);
    paramm.oSJ.setVisibility(8);
  }
  
  public void a(m paramm, int paramInt, a parama)
  {
    paramm.oSB.setTag(this);
    paramm.oSI.setTag(this);
    q.aIJ().a(aCp(), paramm.oSB, c.et(getContext()));
    paramm.oSF.setVisibility(8);
    paramm.oSG.setVisibility(8);
    paramm.oSD.setVisibility(8);
    paramm.oSE.setVisibility(8);
    paramm.oSI.setVisibility(0);
    paramm.fQc.setVisibility(0);
    a(paramm);
    if (bZm().tC(this.oRU.field_msgId))
    {
      paramm.oSH.setVisibility(8);
      paramm.fQc.setChecked(true);
    }
    while (isEnable())
    {
      paramm.oSA.setAlpha(1.0F);
      return;
      paramm.oSH.setVisibility(0);
      paramm.fQc.setChecked(false);
    }
    paramm.oSA.setAlpha(0.6F);
  }
  
  protected String aCp()
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.d
 * JD-Core Version:    0.7.0.1
 */