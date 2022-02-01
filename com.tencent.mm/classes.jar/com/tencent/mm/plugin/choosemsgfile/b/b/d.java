package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.os.Looper;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.g.c.eo;
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
    switch (this.qnF)
    {
    default: 
    case 1: 
    case 2: 
      do
      {
        return;
        paramm.kdb.setVisibility(0);
        paramm.qoc.setVisibility(8);
        paramm.gxr.setVisibility(8);
        paramm.qoi.setVisibility(8);
        paramm.qoj.setVisibility(8);
        return;
        paramm.kdb.setVisibility(0);
        paramm.qoc.setVisibility(0);
        paramm.gxr.setVisibility(8);
        paramm.qoi.setVisibility(8);
        paramm.qoj.setVisibility(8);
      } while (this.aqi <= 0);
      int i = (int)(this.fs / this.aqi * 100.0F);
      if ((i == -1) || (i >= 100))
      {
        paramm.qoc.setProgress(100);
        return;
      }
      paramm.qoc.setProgress(i);
      return;
    case 3: 
      paramm.kdb.setVisibility(8);
      paramm.qoc.setVisibility(8);
      paramm.gxr.setVisibility(0);
      paramm.qoi.setVisibility(0);
      paramm.qoj.setVisibility(8);
      return;
    case 4: 
      paramm.kdb.setVisibility(8);
      paramm.qoc.setVisibility(8);
      paramm.gxr.setVisibility(8);
      paramm.qoi.setVisibility(8);
      paramm.qoj.setVisibility(0);
      return;
    case 5: 
      paramm.kdb.setVisibility(8);
      paramm.qoc.setVisibility(8);
      paramm.gxr.setVisibility(8);
      paramm.qoi.setVisibility(8);
      paramm.qoj.setVisibility(0);
      return;
    }
    paramm.kdb.setVisibility(8);
    paramm.qoc.setVisibility(8);
    paramm.gxr.setVisibility(0);
    paramm.qoi.setVisibility(0);
    paramm.gxr.setChecked(false);
    paramm.qoj.setVisibility(8);
  }
  
  public void a(m paramm, int paramInt, a parama)
  {
    paramm.puw.setTag(this);
    paramm.qoi.setTag(this);
    q.bcV().a(aWd(), paramm.puw, c.eT(getContext()));
    paramm.qof.setVisibility(8);
    paramm.qog.setVisibility(8);
    paramm.qod.setVisibility(8);
    paramm.qoe.setVisibility(8);
    paramm.qoi.setVisibility(0);
    paramm.gxr.setVisibility(0);
    a(paramm);
    if (cys().BY(this.qnv.field_msgId))
    {
      paramm.qoh.setVisibility(8);
      paramm.gxr.setChecked(true);
    }
    while (isEnable())
    {
      paramm.qob.setAlpha(1.0F);
      return;
      paramm.qoh.setVisibility(0);
      paramm.gxr.setChecked(false);
    }
    paramm.qob.setAlpha(0.6F);
  }
  
  protected String aWd()
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.d
 * JD-Core Version:    0.7.0.1
 */