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
  h YO;
  private o.a adD;
  b aeH;
  f aeI;
  
  public i(h paramh)
  {
    this.YO = paramh;
  }
  
  public final void a(h paramh, boolean paramBoolean)
  {
    if (((paramBoolean) || (paramh == this.YO)) && (this.aeH != null)) {
      this.aeH.dismiss();
    }
    if (this.adD != null) {
      this.adD.a(paramh, paramBoolean);
    }
  }
  
  public final boolean d(h paramh)
  {
    if (this.adD != null) {
      return this.adD.d(paramh);
    }
    return false;
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.YO.a((j)this.aeI.getAdapter().getItem(paramInt), null, 0);
  }
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    this.aeI.a(this.YO, true);
  }
  
  public final boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 82) || (paramInt == 4)) {
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
      {
        paramDialogInterface = this.aeH.getWindow();
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
        Object localObject = this.aeH.getWindow();
        if (localObject != null)
        {
          localObject = ((Window)localObject).getDecorView();
          if (localObject != null)
          {
            localObject = ((View)localObject).getKeyDispatcherState();
            if ((localObject != null) && (((KeyEvent.DispatcherState)localObject).isTracking(paramKeyEvent)))
            {
              this.YO.ab(true);
              paramDialogInterface.dismiss();
              return true;
            }
          }
        }
      }
    }
    return this.YO.performShortcut(paramInt, paramKeyEvent, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.i
 * JD-Core Version:    0.7.0.1
 */