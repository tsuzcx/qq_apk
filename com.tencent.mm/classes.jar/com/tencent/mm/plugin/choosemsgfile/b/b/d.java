package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.os.Looper;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.q;
import com.tencent.mm.f.c.et;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;
import com.tencent.mm.plugin.choosemsgfile.b.d.c;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public abstract class d
  extends a<m>
{
  public d(g paramg, ca paramca)
  {
    super(paramg, paramca);
  }
  
  private void a(final m paramm)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      b(paramm);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
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
    switch (this.tMs)
    {
    default: 
    case 1: 
    case 2: 
      do
      {
        return;
        paramm.mUB.setVisibility(0);
        paramm.tMK.setVisibility(8);
        paramm.jbE.setVisibility(8);
        paramm.tMQ.setVisibility(8);
        paramm.tMR.setVisibility(8);
        return;
        paramm.mUB.setVisibility(0);
        paramm.tMK.setVisibility(0);
        paramm.jbE.setVisibility(8);
        paramm.tMQ.setVisibility(8);
        paramm.tMR.setVisibility(8);
      } while (this.sL <= 0);
      int i = (int)(this.zP / this.sL * 100.0F);
      if ((i == -1) || (i >= 100))
      {
        paramm.tMK.setProgress(100);
        return;
      }
      paramm.tMK.setProgress(i);
      return;
    case 3: 
      paramm.mUB.setVisibility(8);
      paramm.tMK.setVisibility(8);
      paramm.jbE.setVisibility(0);
      paramm.tMQ.setVisibility(0);
      paramm.tMR.setVisibility(8);
      return;
    case 4: 
      paramm.mUB.setVisibility(8);
      paramm.tMK.setVisibility(8);
      paramm.jbE.setVisibility(8);
      paramm.tMQ.setVisibility(8);
      paramm.tMR.setVisibility(0);
      return;
    case 5: 
      paramm.mUB.setVisibility(8);
      paramm.tMK.setVisibility(8);
      paramm.jbE.setVisibility(8);
      paramm.tMQ.setVisibility(8);
      paramm.tMR.setVisibility(0);
      return;
    }
    paramm.mUB.setVisibility(8);
    paramm.tMK.setVisibility(8);
    paramm.jbE.setVisibility(0);
    paramm.tMQ.setVisibility(0);
    paramm.jbE.setChecked(false);
    paramm.tMR.setVisibility(8);
  }
  
  public void a(m paramm, int paramInt, a parama)
  {
    paramm.sDJ.setTag(this);
    paramm.tMQ.setTag(this);
    q.bml().a(bfg(), paramm.sDJ, c.eX(getContext()));
    paramm.tMN.setVisibility(8);
    paramm.tMO.setVisibility(8);
    paramm.tML.setVisibility(8);
    paramm.tMM.setVisibility(8);
    paramm.tMQ.setVisibility(0);
    paramm.jbE.setVisibility(0);
    a(paramm);
    if (cMN().Ih(this.tMi.field_msgId))
    {
      paramm.tMP.setVisibility(8);
      paramm.jbE.setChecked(true);
    }
    while (isEnable())
    {
      paramm.tMJ.setAlpha(1.0F);
      return;
      paramm.tMP.setVisibility(0);
      paramm.jbE.setChecked(false);
    }
    paramm.tMJ.setAlpha(0.6F);
  }
  
  protected String bfg()
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.d
 * JD-Core Version:    0.7.0.1
 */