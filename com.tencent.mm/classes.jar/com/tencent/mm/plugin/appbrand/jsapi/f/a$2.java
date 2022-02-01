package com.tencent.mm.plugin.appbrand.jsapi.f;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$2
  implements Runnable
{
  a$2(Context paramContext, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(226841);
    Toast localToast = Toast.makeText(this.val$context, "", 3000);
    View localView = View.inflate(this.val$context, 2131496707, null);
    ((TextView)localView.findViewById(2131309260)).setText(this.val$text);
    localToast.setGravity(17, 0, 0);
    localToast.setView(localView);
    localToast.show();
    AppMethodBeat.o(226841);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.a.2
 * JD-Core Version:    0.7.0.1
 */