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
  h aaQ;
  private o.a afH;
  b agL;
  f agM;
  
  public i(h paramh)
  {
    this.aaQ = paramh;
  }
  
  public final void a(h paramh, boolean paramBoolean)
  {
    if (((paramBoolean) || (paramh == this.aaQ)) && (this.agL != null)) {
      this.agL.dismiss();
    }
    if (this.afH != null) {
      this.afH.a(paramh, paramBoolean);
    }
  }
  
  public final boolean d(h paramh)
  {
    if (this.afH != null) {
      return this.afH.d(paramh);
    }
    return false;
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.aaQ.a((j)this.agM.getAdapter().getItem(paramInt), null, 0);
  }
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    this.agM.a(this.aaQ, true);
  }
  
  public final boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 82) || (paramInt == 4)) {
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
      {
        paramDialogInterface = this.agL.getWindow();
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
        Object localObject = this.agL.getWindow();
        if (localObject != null)
        {
          localObject = ((Window)localObject).getDecorView();
          if (localObject != null)
          {
            localObject = ((View)localObject).getKeyDispatcherState();
            if ((localObject != null) && (((KeyEvent.DispatcherState)localObject).isTracking(paramKeyEvent)))
            {
              this.aaQ.aa(true);
              paramDialogInterface.dismiss();
              return true;
            }
          }
        }
      }
    }
    return this.aaQ.performShortcut(paramInt, paramKeyEvent, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.i
 * JD-Core Version:    0.7.0.1
 */