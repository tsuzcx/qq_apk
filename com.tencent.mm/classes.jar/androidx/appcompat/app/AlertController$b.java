package androidx.appcompat.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

final class AlertController$b
  extends Handler
{
  private WeakReference<DialogInterface> fL;
  
  public AlertController$b(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(237974);
    this.fL = new WeakReference(paramDialogInterface);
    AppMethodBeat.o(237974);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(237976);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(237976);
      return;
      ((DialogInterface.OnClickListener)paramMessage.obj).onClick((DialogInterface)this.fL.get(), paramMessage.what);
      AppMethodBeat.o(237976);
      return;
      ((DialogInterface)paramMessage.obj).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.appcompat.app.AlertController.b
 * JD-Core Version:    0.7.0.1
 */