package com.tencent.map.tools.sheet;

import android.content.Context;
import android.os.Handler;
import com.tencent.map.tools.Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SheetManager$1
  implements Runnable
{
  SheetManager$1(SheetManager paramSheetManager, Context paramContext, SheetManager.Options paramOptions, Handler paramHandler, Callback paramCallback) {}
  
  public final void run()
  {
    AppMethodBeat.i(180948);
    this.e.init(this.a, this.b);
    this.c.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(180947);
        if (SheetManager.1.this.d != null) {
          SheetManager.1.this.d.callback(null);
        }
        AppMethodBeat.o(180947);
      }
    });
    AppMethodBeat.o(180948);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.map.tools.sheet.SheetManager.1
 * JD-Core Version:    0.7.0.1
 */