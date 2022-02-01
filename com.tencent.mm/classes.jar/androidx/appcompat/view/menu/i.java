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
  h jo;
  private o.a mO;
  b nU;
  f nV;
  
  public i(h paramh)
  {
    this.jo = paramh;
  }
  
  public final void a(h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(200997);
    if (((paramBoolean) || (paramh == this.jo)) && (this.nU != null)) {
      this.nU.dismiss();
    }
    if (this.mO != null) {
      this.mO.a(paramh, paramBoolean);
    }
    AppMethodBeat.o(200997);
  }
  
  public final boolean c(h paramh)
  {
    AppMethodBeat.i(201008);
    if (this.mO != null)
    {
      boolean bool = this.mO.c(paramh);
      AppMethodBeat.o(201008);
      return bool;
    }
    AppMethodBeat.o(201008);
    return false;
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(201018);
    this.jo.a((j)this.nV.getAdapter().getItem(paramInt), null, 0);
    AppMethodBeat.o(201018);
  }
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(200985);
    this.nV.a(this.jo, true);
    AppMethodBeat.o(200985);
  }
  
  public final boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(200974);
    if ((paramInt == 82) || (paramInt == 4)) {
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
      {
        paramDialogInterface = this.nU.getWindow();
        if (paramDialogInterface != null)
        {
          paramDialogInterface = paramDialogInterface.getDecorView();
          if (paramDialogInterface != null)
          {
            paramDialogInterface = paramDialogInterface.getKeyDispatcherState();
            if (paramDialogInterface != null)
            {
              paramDialogInterface.startTracking(paramKeyEvent, this);
              AppMethodBeat.o(200974);
              return true;
            }
          }
        }
      }
      else if ((paramKeyEvent.getAction() == 1) && (!paramKeyEvent.isCanceled()))
      {
        Object localObject = this.nU.getWindow();
        if (localObject != null)
        {
          localObject = ((Window)localObject).getDecorView();
          if (localObject != null)
          {
            localObject = ((View)localObject).getKeyDispatcherState();
            if ((localObject != null) && (((KeyEvent.DispatcherState)localObject).isTracking(paramKeyEvent)))
            {
              this.jo.K(true);
              paramDialogInterface.dismiss();
              AppMethodBeat.o(200974);
              return true;
            }
          }
        }
      }
    }
    boolean bool = this.jo.performShortcut(paramInt, paramKeyEvent, 0);
    AppMethodBeat.o(200974);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.view.menu.i
 * JD-Core Version:    0.7.0.1
 */