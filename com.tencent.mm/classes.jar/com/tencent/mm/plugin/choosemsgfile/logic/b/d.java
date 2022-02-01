package com.tencent.mm.plugin.choosemsgfile.logic.b;

import android.os.Looper;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.choosemsgfile.logic.c.c;
import com.tencent.mm.plugin.choosemsgfile.logic.ui.g;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public abstract class d
  extends a<m>
{
  public d(g paramg, cc paramcc)
  {
    super(paramg, paramcc);
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
    switch (this.wPI)
    {
    default: 
    case 1: 
    case 2: 
      do
      {
        return;
        paramm.pRi.setVisibility(0);
        paramm.wQa.setVisibility(8);
        paramm.lDE.setVisibility(8);
        paramm.wQg.setVisibility(8);
        paramm.wQh.setVisibility(8);
        return;
        paramm.pRi.setVisibility(0);
        paramm.wQa.setVisibility(0);
        paramm.lDE.setVisibility(8);
        paramm.wQg.setVisibility(8);
        paramm.wQh.setVisibility(8);
      } while (this.tK <= 0);
      int i = (int)(this.Sc / this.tK * 100.0F);
      if ((i == -1) || (i >= 100))
      {
        paramm.wQa.setProgress(100);
        return;
      }
      paramm.wQa.setProgress(i);
      return;
    case 3: 
      paramm.pRi.setVisibility(8);
      paramm.wQa.setVisibility(8);
      paramm.lDE.setVisibility(0);
      paramm.wQg.setVisibility(0);
      paramm.wQh.setVisibility(8);
      return;
    case 4: 
      paramm.pRi.setVisibility(8);
      paramm.wQa.setVisibility(8);
      paramm.lDE.setVisibility(8);
      paramm.wQg.setVisibility(8);
      paramm.wQh.setVisibility(0);
      return;
    case 5: 
      paramm.pRi.setVisibility(8);
      paramm.wQa.setVisibility(8);
      paramm.lDE.setVisibility(8);
      paramm.wQg.setVisibility(8);
      paramm.wQh.setVisibility(0);
      return;
    }
    paramm.pRi.setVisibility(8);
    paramm.wQa.setVisibility(8);
    paramm.lDE.setVisibility(0);
    paramm.wQg.setVisibility(0);
    paramm.lDE.setChecked(false);
    paramm.wQh.setVisibility(8);
  }
  
  public void a(m paramm, int paramInt, a parama)
  {
    paramm.coverIv.setTag(this);
    paramm.wQg.setTag(this);
    r.bKe().a(bCX(), paramm.coverIv, c.fU(getContext()));
    paramm.wQd.setVisibility(8);
    paramm.wQe.setVisibility(8);
    paramm.wQb.setVisibility(8);
    paramm.wQc.setVisibility(8);
    paramm.wQg.setVisibility(0);
    paramm.lDE.setVisibility(0);
    a(paramm);
    if (dqs().kz(this.wPy.field_msgId))
    {
      paramm.wQf.setVisibility(8);
      paramm.lDE.setChecked(true);
    }
    while (isEnable())
    {
      paramm.wPZ.setAlpha(1.0F);
      return;
      paramm.wQf.setVisibility(0);
      paramm.lDE.setChecked(false);
    }
    paramm.wPZ.setAlpha(0.6F);
  }
  
  protected String bCX()
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.logic.b.d
 * JD-Core Version:    0.7.0.1
 */