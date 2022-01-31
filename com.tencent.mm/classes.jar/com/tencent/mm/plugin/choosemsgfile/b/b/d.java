package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.os.Looper;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.at.o;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;
import com.tencent.mm.plugin.choosemsgfile.b.d.b;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public abstract class d
  extends a<m>
{
  public d(g paramg, bi parambi)
  {
    super(paramg, parambi);
  }
  
  private void a(m paramm)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      b(paramm);
      return;
    }
    al.d(new d.1(this, paramm));
  }
  
  private void b(m paramm)
  {
    switch (this.kEJ)
    {
    default: 
    case 1: 
    case 2: 
      do
      {
        return;
        paramm.gvS.setVisibility(0);
        paramm.kFf.setVisibility(8);
        paramm.kFl.setVisibility(8);
        paramm.kFm.setVisibility(8);
        paramm.kFn.setVisibility(8);
        return;
        paramm.gvS.setVisibility(0);
        paramm.kFf.setVisibility(0);
        paramm.kFl.setVisibility(8);
        paramm.kFm.setVisibility(8);
        paramm.kFn.setVisibility(8);
      } while (this.agc <= 0);
      int i = (int)(this.Fb / this.agc * 100.0F);
      if ((i == -1) || (i >= 100))
      {
        paramm.kFf.setProgress(100);
        return;
      }
      paramm.kFf.setProgress(i);
      return;
    case 3: 
      paramm.gvS.setVisibility(8);
      paramm.kFf.setVisibility(8);
      paramm.kFl.setVisibility(0);
      paramm.kFm.setVisibility(0);
      paramm.kFn.setVisibility(8);
      return;
    case 4: 
      paramm.gvS.setVisibility(8);
      paramm.kFf.setVisibility(8);
      paramm.kFl.setVisibility(8);
      paramm.kFm.setVisibility(8);
      paramm.kFn.setVisibility(0);
      return;
    case 5: 
      paramm.gvS.setVisibility(8);
      paramm.kFf.setVisibility(8);
      paramm.kFl.setVisibility(8);
      paramm.kFm.setVisibility(8);
      paramm.kFn.setVisibility(0);
      return;
    }
    paramm.gvS.setVisibility(8);
    paramm.kFf.setVisibility(8);
    paramm.kFl.setVisibility(0);
    paramm.kFm.setVisibility(0);
    paramm.kFl.setChecked(false);
    paramm.kFn.setVisibility(8);
  }
  
  public void a(m paramm, int paramInt)
  {
    paramm.kha.setTag(this);
    paramm.kFm.setTag(this);
    o.ahG().a(aaZ(), paramm.kha, b.dD(getContext()));
    paramm.kFi.setVisibility(8);
    paramm.kFj.setVisibility(8);
    paramm.kFg.setVisibility(8);
    paramm.kFh.setVisibility(8);
    paramm.kFm.setVisibility(0);
    paramm.kFl.setVisibility(0);
    a(paramm);
    if (bgl().ij(this.kEz.field_msgId))
    {
      paramm.kFk.setVisibility(8);
      paramm.kFl.setChecked(true);
    }
    while (isEnable())
    {
      paramm.kFe.setAlpha(1.0F);
      return;
      paramm.kFk.setVisibility(0);
      paramm.kFl.setChecked(false);
    }
    paramm.kFe.setAlpha(0.6F);
  }
  
  protected String aaZ()
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.d
 * JD-Core Version:    0.7.0.1
 */