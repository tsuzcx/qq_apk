package android.support.v7.view.menu;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.support.v7.app.b;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;
import android.widget.ListAdapter;

final class i
  implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnKeyListener, o.a
{
  private o.a VE;
  b WH;
  f WI;
  h eq;
  
  public i(h paramh)
  {
    this.eq = paramh;
  }
  
  public final void a(h paramh, boolean paramBoolean)
  {
    if (((paramBoolean) || (paramh == this.eq)) && (this.WH != null)) {
      this.WH.dismiss();
    }
    if (this.VE != null) {
      this.VE.a(paramh, paramBoolean);
    }
  }
  
  public final boolean d(h paramh)
  {
    if (this.VE != null) {
      return this.VE.d(paramh);
    }
    return false;
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.eq.a((j)this.WI.getAdapter().getItem(paramInt), null, 0);
  }
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    this.WI.a(this.eq, true);
  }
  
  public final boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 82) || (paramInt == 4)) {
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
      {
        paramDialogInterface = this.WH.getWindow();
        if (paramDialogInterface != null)
        {
          paramDialogInterface = paramDialogInterface.getDecorView();
          if (paramDialogInterface != null)
          {
            paramDialogInterface = paramDialogInterface.getKeyDispatcherState();
            if (paramDialogInterface != null)
            {
              paramDialogInterface.startTracking(paramKeyEvent, this);
              return true;
            }
          }
        }
      }
      else if ((paramKeyEvent.getAction() == 1) && (!paramKeyEvent.isCanceled()))
      {
        Object localObject = this.WH.getWindow();
        if (localObject != null)
        {
          localObject = ((Window)localObject).getDecorView();
          if (localObject != null)
          {
            localObject = ((View)localObject).getKeyDispatcherState();
            if ((localObject != null) && (((KeyEvent.DispatcherState)localObject).isTracking(paramKeyEvent)))
            {
              this.eq.V(true);
              paramDialogInterface.dismiss();
              return true;
            }
          }
        }
      }
    }
    return this.eq.performShortcut(paramInt, paramKeyEvent, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.i
 * JD-Core Version:    0.7.0.1
 */