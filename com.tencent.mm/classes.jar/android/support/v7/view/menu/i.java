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
  h aaD;
  private o.a afu;
  b agy;
  f agz;
  
  public i(h paramh)
  {
    this.aaD = paramh;
  }
  
  public final void a(h paramh, boolean paramBoolean)
  {
    if (((paramBoolean) || (paramh == this.aaD)) && (this.agy != null)) {
      this.agy.dismiss();
    }
    if (this.afu != null) {
      this.afu.a(paramh, paramBoolean);
    }
  }
  
  public final boolean d(h paramh)
  {
    if (this.afu != null) {
      return this.afu.d(paramh);
    }
    return false;
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.aaD.a((j)this.agz.getAdapter().getItem(paramInt), null, 0);
  }
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    this.agz.a(this.aaD, true);
  }
  
  public final boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 82) || (paramInt == 4)) {
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
      {
        paramDialogInterface = this.agy.getWindow();
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
        Object localObject = this.agy.getWindow();
        if (localObject != null)
        {
          localObject = ((Window)localObject).getDecorView();
          if (localObject != null)
          {
            localObject = ((View)localObject).getKeyDispatcherState();
            if ((localObject != null) && (((KeyEvent.DispatcherState)localObject).isTracking(paramKeyEvent)))
            {
              this.aaD.ab(true);
              paramDialogInterface.dismiss();
              return true;
            }
          }
        }
      }
    }
    return this.aaD.performShortcut(paramInt, paramKeyEvent, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.i
 * JD-Core Version:    0.7.0.1
 */