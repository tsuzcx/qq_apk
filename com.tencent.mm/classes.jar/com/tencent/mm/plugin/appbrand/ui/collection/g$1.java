package com.tencent.mm.plugin.appbrand.ui.collection;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class g$1
  implements Runnable
{
  g$1(Context paramContext, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(133321);
    Context localContext = this.val$context;
    if (this.iSa) {}
    for (String str = this.val$context.getString(2131296598);; str = this.val$context.getString(2131296596))
    {
      Toast.makeText(localContext, str, 0).show();
      AppMethodBeat.o(133321);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.g.1
 * JD-Core Version:    0.7.0.1
 */