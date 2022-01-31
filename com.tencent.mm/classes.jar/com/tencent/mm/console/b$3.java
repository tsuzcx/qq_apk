package com.tencent.mm.console;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import java.util.ArrayList;

final class b$3
  implements DialogInterface.OnClickListener
{
  b$3(int paramInt, ArrayList paramArrayList, Context paramContext) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(16077);
    d.post(new b.3.1(this), "copypackage");
    AppMethodBeat.o(16077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.console.b.3
 * JD-Core Version:    0.7.0.1
 */