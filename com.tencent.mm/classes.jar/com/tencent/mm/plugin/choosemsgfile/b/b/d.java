package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.os.Looper;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.c.du;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;
import com.tencent.mm.plugin.choosemsgfile.b.d.c;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public abstract class d
  extends a<m>
{
  public d(g paramg, bl parambl)
  {
    super(paramg, parambl);
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
    switch (this.nLJ)
    {
    default: 
    case 1: 
    case 2: 
      do
      {
        return;
        paramm.iiP.setVisibility(0);
        paramm.nMh.setVisibility(8);
        paramm.fti.setVisibility(8);
        paramm.nMn.setVisibility(8);
        paramm.nMo.setVisibility(8);
        return;
        paramm.iiP.setVisibility(0);
        paramm.nMh.setVisibility(0);
        paramm.fti.setVisibility(8);
        paramm.nMn.setVisibility(8);
        paramm.nMo.setVisibility(8);
      } while (this.anj <= 0);
      int i = (int)(this.LZ / this.anj * 100.0F);
      if ((i == -1) || (i >= 100))
      {
        paramm.nMh.setProgress(100);
        return;
      }
      paramm.nMh.setProgress(i);
      return;
    case 3: 
      paramm.iiP.setVisibility(8);
      paramm.nMh.setVisibility(8);
      paramm.fti.setVisibility(0);
      paramm.nMn.setVisibility(0);
      paramm.nMo.setVisibility(8);
      return;
    case 4: 
      paramm.iiP.setVisibility(8);
      paramm.nMh.setVisibility(8);
      paramm.fti.setVisibility(8);
      paramm.nMn.setVisibility(8);
      paramm.nMo.setVisibility(0);
      return;
    case 5: 
      paramm.iiP.setVisibility(8);
      paramm.nMh.setVisibility(8);
      paramm.fti.setVisibility(8);
      paramm.nMn.setVisibility(8);
      paramm.nMo.setVisibility(0);
      return;
    }
    paramm.iiP.setVisibility(8);
    paramm.nMh.setVisibility(8);
    paramm.fti.setVisibility(0);
    paramm.nMn.setVisibility(0);
    paramm.fti.setChecked(false);
    paramm.nMo.setVisibility(8);
  }
  
  public void a(m paramm, int paramInt, a parama)
  {
    paramm.nMg.setTag(this);
    paramm.nMn.setTag(this);
    o.ayJ().a(asu(), paramm.nMg, c.el(getContext()));
    paramm.nMk.setVisibility(8);
    paramm.nMl.setVisibility(8);
    paramm.nMi.setVisibility(8);
    paramm.nMj.setVisibility(8);
    paramm.nMn.setVisibility(0);
    paramm.fti.setVisibility(0);
    a(paramm);
    if (bNw().nR(this.nLz.field_msgId))
    {
      paramm.nMm.setVisibility(8);
      paramm.fti.setChecked(true);
    }
    while (isEnable())
    {
      paramm.nMf.setAlpha(1.0F);
      return;
      paramm.nMm.setVisibility(0);
      paramm.fti.setChecked(false);
    }
    paramm.nMf.setAlpha(0.6F);
  }
  
  protected String asu()
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.d
 * JD-Core Version:    0.7.0.1
 */