package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;

final class a$2
  implements Runnable
{
  a$2(Context paramContext, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(265922);
    Toast localToast = Toast.makeText(this.val$context, "", 3000);
    View localView = View.inflate(this.val$context, a.h.text_toast, null);
    ((TextView)localView.findViewById(a.g.toast_text)).setText(this.val$text);
    localToast.setGravity(17, 0, 0);
    localToast.setView(localView);
    localToast.show();
    AppMethodBeat.o(265922);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.2
 * JD-Core Version:    0.7.0.1
 */