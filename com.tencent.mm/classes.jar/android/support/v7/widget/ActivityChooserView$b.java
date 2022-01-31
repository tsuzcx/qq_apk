package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.support.v4.view.b;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow.OnDismissListener;
import java.util.List;

final class ActivityChooserView$b
  implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  ActivityChooserView$b(ActivityChooserView paramActivityChooserView) {}
  
  public final void onClick(View paramView)
  {
    if (paramView == this.YX.YN)
    {
      this.YX.fW();
      paramView = this.YX.YH.YY.fP();
      int i = this.YX.YH.YY.a(paramView);
      paramView = this.YX.YH.YY.bi(i);
      if (paramView != null)
      {
        paramView.addFlags(524288);
        this.YX.getContext().startActivity(paramView);
      }
      return;
    }
    if (paramView == this.YX.YL)
    {
      this.YX.YU = false;
      this.YX.bj(this.YX.YV);
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public final void onDismiss()
  {
    if (this.YX.UT != null) {
      this.YX.UT.onDismiss();
    }
    if (this.YX.YQ != null) {
      this.YX.YQ.E(false);
    }
  }
  
  public final void onItemClick(AdapterView<?> arg1, View paramView, int paramInt, long paramLong)
  {
    switch (((ActivityChooserView.a)???.getAdapter()).getItemViewType(paramInt))
    {
    default: 
      throw new IllegalArgumentException();
    case 1: 
      this.YX.bj(2147483647);
    }
    do
    {
      return;
      this.YX.fW();
      if (!this.YX.YU) {
        break;
      }
    } while (paramInt <= 0);
    paramView = this.YX.YH.YY;
    for (;;)
    {
      synchronized (paramView.Yu)
      {
        paramView.fQ();
        d.a locala1 = (d.a)paramView.Yv.get(paramInt);
        d.a locala2 = (d.a)paramView.Yv.get(0);
        if (locala2 != null)
        {
          f = locala2.weight - locala1.weight + 5.0F;
          paramView.a(new d.c(new ComponentName(locala1.resolveInfo.activityInfo.packageName, locala1.resolveInfo.activityInfo.name), System.currentTimeMillis(), f));
          return;
        }
      }
      float f = 1.0F;
    }
    if (this.YX.YH.Za) {}
    for (;;)
    {
      ??? = this.YX.YH.YY.bi(paramInt);
      if (??? == null) {
        break;
      }
      ???.addFlags(524288);
      this.YX.getContext().startActivity(???);
      return;
      paramInt += 1;
    }
  }
  
  public final boolean onLongClick(View paramView)
  {
    if (paramView == this.YX.YN)
    {
      if (this.YX.YH.getCount() > 0)
      {
        this.YX.YU = true;
        this.YX.bj(this.YX.YV);
      }
      return true;
    }
    throw new IllegalArgumentException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v7.widget.ActivityChooserView.b
 * JD-Core Version:    0.7.0.1
 */