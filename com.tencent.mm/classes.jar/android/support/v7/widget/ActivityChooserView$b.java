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
    if (paramView == this.ZI.Zy)
    {
      this.ZI.gT();
      paramView = this.ZI.Zs.ZJ.gJ();
      int i = this.ZI.Zs.ZJ.a(paramView);
      paramView = this.ZI.Zs.ZJ.bg(i);
      if (paramView != null)
      {
        paramView.addFlags(524288);
        this.ZI.getContext().startActivity(paramView);
      }
      return;
    }
    if (paramView == this.ZI.Zw)
    {
      this.ZI.ZF = false;
      this.ZI.bh(this.ZI.ZG);
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public final void onDismiss()
  {
    if (this.ZI.VG != null) {
      this.ZI.VG.onDismiss();
    }
    if (this.ZI.ZB != null) {
      this.ZI.ZB.E(false);
    }
  }
  
  public final void onItemClick(AdapterView<?> arg1, View paramView, int paramInt, long paramLong)
  {
    switch (((ActivityChooserView.a)???.getAdapter()).getItemViewType(paramInt))
    {
    default: 
      throw new IllegalArgumentException();
    case 1: 
      this.ZI.bh(2147483647);
    }
    do
    {
      return;
      this.ZI.gT();
      if (!this.ZI.ZF) {
        break;
      }
    } while (paramInt <= 0);
    paramView = this.ZI.Zs.ZJ;
    for (;;)
    {
      synchronized (paramView.Zf)
      {
        paramView.gL();
        c.a locala1 = (c.a)paramView.Zg.get(paramInt);
        c.a locala2 = (c.a)paramView.Zg.get(0);
        if (locala2 != null)
        {
          f = locala2.weight - locala1.weight + 5.0F;
          paramView.a(new c.c(new ComponentName(locala1.resolveInfo.activityInfo.packageName, locala1.resolveInfo.activityInfo.name), System.currentTimeMillis(), f));
          return;
        }
      }
      float f = 1.0F;
    }
    if (this.ZI.Zs.ZL) {}
    for (;;)
    {
      ??? = this.ZI.Zs.ZJ.bg(paramInt);
      if (??? == null) {
        break;
      }
      ???.addFlags(524288);
      this.ZI.getContext().startActivity(???);
      return;
      paramInt += 1;
    }
  }
  
  public final boolean onLongClick(View paramView)
  {
    if (paramView == this.ZI.Zy)
    {
      if (this.ZI.Zs.getCount() > 0)
      {
        this.ZI.ZF = true;
        this.ZI.bh(this.ZI.ZG);
      }
      return true;
    }
    throw new IllegalArgumentException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v7.widget.ActivityChooserView.b
 * JD-Core Version:    0.7.0.1
 */