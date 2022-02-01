package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow.OnDismissListener;
import androidx.core.g.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class ActivityChooserView$b
  implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  ActivityChooserView$b(ActivityChooserView paramActivityChooserView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(200209);
    if (paramView == this.re.qU)
    {
      this.re.eb();
      paramView = this.re.qO.rf.dQ();
      int i = this.re.qO.rf.a(paramView);
      Object localObject = this.re.qO.rf.am(i);
      if (localObject != null)
      {
        ((Intent)localObject).addFlags(524288);
        paramView = this.re.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "androidx/appcompat/widget/ActivityChooserView$Callbacks", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramView, "androidx/appcompat/widget/ActivityChooserView$Callbacks", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      AppMethodBeat.o(200209);
      return;
    }
    if (paramView == this.re.qS)
    {
      this.re.rb = false;
      this.re.an(this.re.rc);
      AppMethodBeat.o(200209);
      return;
    }
    paramView = new IllegalArgumentException();
    AppMethodBeat.o(200209);
    throw paramView;
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(200223);
    if (this.re.mQ != null) {
      this.re.mQ.onDismiss();
    }
    if (this.re.qX != null) {
      this.re.qX.aD(false);
    }
    AppMethodBeat.o(200223);
  }
  
  public final void onItemClick(AdapterView<?> arg1, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(200203);
    switch (((ActivityChooserView.a)???.getAdapter()).getItemViewType(paramInt))
    {
    default: 
      ??? = new IllegalArgumentException();
      AppMethodBeat.o(200203);
      throw ???;
    case 1: 
      this.re.an(2147483647);
      AppMethodBeat.o(200203);
      return;
    }
    this.re.eb();
    if (this.re.rb)
    {
      if (paramInt > 0)
      {
        paramView = this.re.qO.rf;
        synchronized (paramView.qz)
        {
          paramView.dT();
          c.a locala1 = (c.a)paramView.qA.get(paramInt);
          c.a locala2 = (c.a)paramView.qA.get(0);
          if (locala2 != null)
          {
            f = locala2.qL - locala1.qL + 5.0F;
            paramView.a(new c.c(new ComponentName(locala1.qK.activityInfo.packageName, locala1.qK.activityInfo.name), System.currentTimeMillis(), f));
            AppMethodBeat.o(200203);
            return;
          }
          float f = 1.0F;
        }
      }
    }
    else
    {
      if (this.re.qO.rh) {}
      for (;;)
      {
        paramView = this.re.qO.rf.am(paramInt);
        if (paramView != null)
        {
          paramView.addFlags(524288);
          ??? = this.re.getContext();
          paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
          com.tencent.mm.hellhoundlib.a.a.b(???, paramView.aYi(), "androidx/appcompat/widget/ActivityChooserView$Callbacks", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ???.startActivity((Intent)paramView.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(???, "androidx/appcompat/widget/ActivityChooserView$Callbacks", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(200203);
        return;
        paramInt += 1;
      }
    }
    AppMethodBeat.o(200203);
  }
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(200217);
    if (paramView == this.re.qU)
    {
      if (this.re.qO.getCount() > 0)
      {
        this.re.rb = true;
        this.re.an(this.re.rc);
      }
      AppMethodBeat.o(200217);
      return true;
    }
    paramView = new IllegalArgumentException();
    AppMethodBeat.o(200217);
    throw paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.appcompat.widget.ActivityChooserView.b
 * JD-Core Version:    0.7.0.1
 */