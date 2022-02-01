package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;
import android.widget.ListAdapter;
import androidx.appcompat.app.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i
  implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnKeyListener, o.a
{
  h is;
  private o.a lR;
  b mW;
  f mZ;
  
  public i(h paramh)
  {
    this.is = paramh;
  }
  
  public final void a(h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(239452);
    if (((paramBoolean) || (paramh == this.is)) && (this.mW != null)) {
      this.mW.dismiss();
    }
    if (this.lR != null) {
      this.lR.a(paramh, paramBoolean);
    }
    AppMethodBeat.o(239452);
  }
  
  public final boolean c(h paramh)
  {
    AppMethodBeat.i(239453);
    if (this.lR != null)
    {
      boolean bool = this.lR.c(paramh);
      AppMethodBeat.o(239453);
      return bool;
    }
    AppMethodBeat.o(239453);
    return false;
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(239454);
    this.is.a((j)this.mZ.getAdapter().getItem(paramInt), null, 0);
    AppMethodBeat.o(239454);
  }
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(239450);
    this.mZ.a(this.is, true);
    AppMethodBeat.o(239450);
  }
  
  public final boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(239448);
    if ((paramInt == 82) || (paramInt == 4)) {
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
      {
        paramDialogInterface = this.mW.getWindow();
        if (paramDialogInterface != null)
        {
          paramDialogInterface = paramDialogInterface.getDecorView();
          if (paramDialogInterface != null)
          {
            paramDialogInterface = paramDialogInterface.getKeyDispatcherState();
            if (paramDialogInterface != null)
            {
              paramDialogInterface.startTracking(paramKeyEvent, this);
              AppMethodBeat.o(239448);
              return true;
            }
          }
        }
      }
      else if ((paramKeyEvent.getAction() == 1) && (!paramKeyEvent.isCanceled()))
      {
        Object localObject = this.mW.getWindow();
        if (localObject != null)
        {
          localObject = ((Window)localObject).getDecorView();
          if (localObject != null)
          {
            localObject = ((View)localObject).getKeyDispatcherState();
            if ((localObject != null) && (((KeyEvent.DispatcherState)localObject).isTracking(paramKeyEvent)))
            {
              this.is.G(true);
              paramDialogInterface.dismiss();
              AppMethodBeat.o(239448);
              return true;
            }
          }
        }
      }
    }
    boolean bool = this.is.performShortcut(paramInt, paramKeyEvent, 0);
    AppMethodBeat.o(239448);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.view.menu.i
 * JD-Core Version:    0.7.0.1
 */