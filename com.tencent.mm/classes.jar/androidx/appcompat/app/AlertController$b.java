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
  private WeakReference<DialogInterface> gG;
  
  public AlertController$b(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(200621);
    this.gG = new WeakReference(paramDialogInterface);
    AppMethodBeat.o(200621);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(200631);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(200631);
      return;
      ((DialogInterface.OnClickListener)paramMessage.obj).onClick((DialogInterface)this.gG.get(), paramMessage.what);
      AppMethodBeat.o(200631);
      return;
      ((DialogInterface)paramMessage.obj).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.appcompat.app.AlertController.b
 * JD-Core Version:    0.7.0.1
 */