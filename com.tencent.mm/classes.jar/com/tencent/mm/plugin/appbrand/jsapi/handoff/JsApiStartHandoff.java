package com.tencent.mm.plugin.appbrand.jsapi.handoff;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public final class JsApiStartHandoff
  extends a<c>
{
  public static final int CTRL_INDEX = 903;
  public static final String NAME = "startHandoff";
  private static int ioG = -1;
  private static int ioL = 0;
  private static boolean kRc = false;
  
  public static void V(Context paramContext, final String paramString)
  {
    AppMethodBeat.i(222546);
    h.MqF.aM(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(222538);
        Toast localToast = Toast.makeText(this.val$context, "", 3000);
        View localView = View.inflate(this.val$context, 2131496531, null);
        ((TextView)localView.findViewById(2131305957)).setText(paramString);
        localToast.setGravity(17, 0, 0);
        localToast.setView(localView);
        localToast.show();
        AppMethodBeat.o(222538);
      }
    });
    AppMethodBeat.o(222546);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.handoff.JsApiStartHandoff
 * JD-Core Version:    0.7.0.1
 */