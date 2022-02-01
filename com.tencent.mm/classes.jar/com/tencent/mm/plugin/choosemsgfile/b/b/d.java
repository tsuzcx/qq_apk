package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.os.Looper;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;
import com.tencent.mm.plugin.choosemsgfile.b.d.c;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public abstract class d
  extends a<m>
{
  public d(g paramg, bv parambv)
  {
    super(paramg, parambv);
  }
  
  private void a(final m paramm)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      b(paramm);
      return;
    }
    ar.f(new Runnable()
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
    switch (this.oYG)
    {
    default: 
    case 1: 
    case 2: 
      do
      {
        return;
        paramm.jeY.setVisibility(0);
        paramm.oZe.setVisibility(8);
        paramm.fSi.setVisibility(8);
        paramm.oZk.setVisibility(8);
        paramm.oZl.setVisibility(8);
        return;
        paramm.jeY.setVisibility(0);
        paramm.oZe.setVisibility(0);
        paramm.fSi.setVisibility(8);
        paramm.oZk.setVisibility(8);
        paramm.oZl.setVisibility(8);
      } while (this.apW <= 0);
      int i = (int)(this.fq / this.apW * 100.0F);
      if ((i == -1) || (i >= 100))
      {
        paramm.oZe.setProgress(100);
        return;
      }
      paramm.oZe.setProgress(i);
      return;
    case 3: 
      paramm.jeY.setVisibility(8);
      paramm.oZe.setVisibility(8);
      paramm.fSi.setVisibility(0);
      paramm.oZk.setVisibility(0);
      paramm.oZl.setVisibility(8);
      return;
    case 4: 
      paramm.jeY.setVisibility(8);
      paramm.oZe.setVisibility(8);
      paramm.fSi.setVisibility(8);
      paramm.oZk.setVisibility(8);
      paramm.oZl.setVisibility(0);
      return;
    case 5: 
      paramm.jeY.setVisibility(8);
      paramm.oZe.setVisibility(8);
      paramm.fSi.setVisibility(8);
      paramm.oZk.setVisibility(8);
      paramm.oZl.setVisibility(0);
      return;
    }
    paramm.jeY.setVisibility(8);
    paramm.oZe.setVisibility(8);
    paramm.fSi.setVisibility(0);
    paramm.oZk.setVisibility(0);
    paramm.fSi.setChecked(false);
    paramm.oZl.setVisibility(8);
  }
  
  public void a(m paramm, int paramInt, a parama)
  {
    paramm.oZd.setTag(this);
    paramm.oZk.setTag(this);
    q.aJb().a(aCF(), paramm.oZd, c.ex(getContext()));
    paramm.oZh.setVisibility(8);
    paramm.oZi.setVisibility(8);
    paramm.oZf.setVisibility(8);
    paramm.oZg.setVisibility(8);
    paramm.oZk.setVisibility(0);
    paramm.fSi.setVisibility(0);
    a(paramm);
    if (caB().tT(this.oYw.field_msgId))
    {
      paramm.oZj.setVisibility(8);
      paramm.fSi.setChecked(true);
    }
    while (isEnable())
    {
      paramm.oZc.setAlpha(1.0F);
      return;
      paramm.oZj.setVisibility(0);
      paramm.fSi.setChecked(false);
    }
    paramm.oZc.setAlpha(0.6F);
  }
  
  protected String aCF()
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.d
 * JD-Core Version:    0.7.0.1
 */