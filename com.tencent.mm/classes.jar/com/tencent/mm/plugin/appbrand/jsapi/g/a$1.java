package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.appbrand.au.h;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.ui.widget.imageview.WeImageView;

final class a$1
  implements Runnable
{
  a$1(Context paramContext) {}
  
  public final void run()
  {
    AppMethodBeat.i(267812);
    Toast localToast = Toast.makeText(this.val$context, "", 3000);
    View localView = View.inflate(this.val$context, a.h.center_toast, null);
    ((WeImageView)localView.findViewById(a.g.toast_img)).setImageResource(au.h.icons_outlined_colorful_handoff_success);
    final TextView localTextView = (TextView)localView.findViewById(a.g.toast_text);
    localTextView.setText(this.val$context.getString(au.i.appbrand_handoffOk));
    localTextView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(276003);
        if (localTextView.getLineCount() > 1) {
          localTextView.setTextSize(0, a.aY(a.1.this.val$context, a.e.DescTextSize));
        }
        localTextView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        AppMethodBeat.o(276003);
      }
    });
    localToast.setGravity(17, 0, 0);
    localToast.setView(localView);
    localToast.show();
    AppMethodBeat.o(267812);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.1
 * JD-Core Version:    0.7.0.1
 */