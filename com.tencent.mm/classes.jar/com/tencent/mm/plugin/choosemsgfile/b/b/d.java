package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.os.Looper;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.o;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;
import com.tencent.mm.plugin.choosemsgfile.b.d.c;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public abstract class d
  extends a<m>
{
  public d(g paramg, bo parambo)
  {
    super(paramg, parambo);
  }
  
  private void a(final m paramm)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      b(paramm);
      return;
    }
    ap.f(new Runnable()
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
    switch (this.ooJ)
    {
    default: 
    case 1: 
    case 2: 
      do
      {
        return;
        paramm.iIW.setVisibility(0);
        paramm.oph.setVisibility(8);
        paramm.fwP.setVisibility(8);
        paramm.opn.setVisibility(8);
        paramm.opo.setVisibility(8);
        return;
        paramm.iIW.setVisibility(0);
        paramm.oph.setVisibility(0);
        paramm.fwP.setVisibility(8);
        paramm.opn.setVisibility(8);
        paramm.opo.setVisibility(8);
      } while (this.aoe <= 0);
      int i = (int)(this.MW / this.aoe * 100.0F);
      if ((i == -1) || (i >= 100))
      {
        paramm.oph.setProgress(100);
        return;
      }
      paramm.oph.setProgress(i);
      return;
    case 3: 
      paramm.iIW.setVisibility(8);
      paramm.oph.setVisibility(8);
      paramm.fwP.setVisibility(0);
      paramm.opn.setVisibility(0);
      paramm.opo.setVisibility(8);
      return;
    case 4: 
      paramm.iIW.setVisibility(8);
      paramm.oph.setVisibility(8);
      paramm.fwP.setVisibility(8);
      paramm.opn.setVisibility(8);
      paramm.opo.setVisibility(0);
      return;
    case 5: 
      paramm.iIW.setVisibility(8);
      paramm.oph.setVisibility(8);
      paramm.fwP.setVisibility(8);
      paramm.opn.setVisibility(8);
      paramm.opo.setVisibility(0);
      return;
    }
    paramm.iIW.setVisibility(8);
    paramm.oph.setVisibility(8);
    paramm.fwP.setVisibility(0);
    paramm.opn.setVisibility(0);
    paramm.fwP.setChecked(false);
    paramm.opo.setVisibility(8);
  }
  
  public void a(m paramm, int paramInt, a parama)
  {
    paramm.opg.setTag(this);
    paramm.opn.setTag(this);
    o.aFB().a(azl(), paramm.opg, c.et(getContext()));
    paramm.opk.setVisibility(8);
    paramm.opl.setVisibility(8);
    paramm.opi.setVisibility(8);
    paramm.opj.setVisibility(8);
    paramm.opn.setVisibility(0);
    paramm.fwP.setVisibility(0);
    a(paramm);
    if (bUH().rD(this.ooz.field_msgId))
    {
      paramm.opm.setVisibility(8);
      paramm.fwP.setChecked(true);
    }
    while (isEnable())
    {
      paramm.opf.setAlpha(1.0F);
      return;
      paramm.opm.setVisibility(0);
      paramm.fwP.setChecked(false);
    }
    paramm.opf.setAlpha(0.6F);
  }
  
  protected String azl()
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.d
 * JD-Core Version:    0.7.0.1
 */