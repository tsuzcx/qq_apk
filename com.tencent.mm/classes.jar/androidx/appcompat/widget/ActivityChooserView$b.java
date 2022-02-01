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
    AppMethodBeat.i(240589);
    if (paramView == this.qh.pX)
    {
      this.qh.di();
      paramView = this.qh.pR.qi.cX();
      int i = this.qh.pR.qi.a(paramView);
      Object localObject = this.qh.pR.qi.ao(i);
      if (localObject != null)
      {
        ((Intent)localObject).addFlags(524288);
        paramView = this.qh.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "androidx/appcompat/widget/ActivityChooserView$Callbacks", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramView, "androidx/appcompat/widget/ActivityChooserView$Callbacks", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      AppMethodBeat.o(240589);
      return;
    }
    if (paramView == this.qh.pV)
    {
      this.qh.qe = false;
      this.qh.ap(this.qh.qf);
      AppMethodBeat.o(240589);
      return;
    }
    paramView = new IllegalArgumentException();
    AppMethodBeat.o(240589);
    throw paramView;
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(240593);
    if (this.qh.lT != null) {
      this.qh.lT.onDismiss();
    }
    if (this.qh.qa != null) {
      this.qh.qa.X(false);
    }
    AppMethodBeat.o(240593);
  }
  
  public final void onItemClick(AdapterView<?> arg1, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(240586);
    switch (((ActivityChooserView.a)???.getAdapter()).getItemViewType(paramInt))
    {
    default: 
      ??? = new IllegalArgumentException();
      AppMethodBeat.o(240586);
      throw ???;
    case 1: 
      this.qh.ap(2147483647);
      AppMethodBeat.o(240586);
      return;
    }
    this.qh.di();
    if (this.qh.qe)
    {
      if (paramInt > 0)
      {
        paramView = this.qh.pR.qi;
        synchronized (paramView.pC)
        {
          paramView.da();
          c.a locala1 = (c.a)paramView.pD.get(paramInt);
          c.a locala2 = (c.a)paramView.pD.get(0);
          if (locala2 != null)
          {
            f = locala2.pO - locala1.pO + 5.0F;
            paramView.a(new c.c(new ComponentName(locala1.pN.activityInfo.packageName, locala1.pN.activityInfo.name), System.currentTimeMillis(), f));
            AppMethodBeat.o(240586);
            return;
          }
          float f = 1.0F;
        }
      }
    }
    else
    {
      if (this.qh.pR.qk) {}
      for (;;)
      {
        paramView = this.qh.pR.qi.ao(paramInt);
        if (paramView != null)
        {
          paramView.addFlags(524288);
          ??? = this.qh.getContext();
          paramView = new com.tencent.mm.hellhoundlib.b.a().bm(paramView);
          com.tencent.mm.hellhoundlib.a.a.b(???, paramView.aFh(), "androidx/appcompat/widget/ActivityChooserView$Callbacks", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ???.startActivity((Intent)paramView.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(???, "androidx/appcompat/widget/ActivityChooserView$Callbacks", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(240586);
        return;
        paramInt += 1;
      }
    }
    AppMethodBeat.o(240586);
  }
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(240591);
    if (paramView == this.qh.pX)
    {
      if (this.qh.pR.getCount() > 0)
      {
        this.qh.qe = true;
        this.qh.ap(this.qh.qf);
      }
      AppMethodBeat.o(240591);
      return true;
    }
    paramView = new IllegalArgumentException();
    AppMethodBeat.o(240591);
    throw paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.appcompat.widget.ActivityChooserView.b
 * JD-Core Version:    0.7.0.1
 */