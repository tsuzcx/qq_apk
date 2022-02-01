package com.tencent.mm.plugin.box.c;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.box.e.a;
import com.tencent.mm.plugin.box.e.b;
import com.tencent.mm.plugin.box.e.c;
import com.tencent.mm.plugin.box.webview.BoxWebView;
import com.tencent.mm.plugin.box.webview.c;
import com.tencent.mm.plugin.box.webview.d;
import com.tencent.mm.protocal.protobuf.qm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
  extends androidx.appcompat.app.e
  implements b
{
  private qm sog;
  private FrameLayout soh;
  private d soi;
  private BoxWebView soj;
  private com.tencent.mm.plugin.box.webview.b sok;
  
  public a(Context paramContext, qm paramqm)
  {
    super(paramContext, e.c.BoxDialog);
    this.sog = paramqm;
  }
  
  public final BoxWebView cyu()
  {
    return this.soj;
  }
  
  public final com.tencent.mm.plugin.box.webview.e cyv()
  {
    return this.sok;
  }
  
  public final d cyw()
  {
    return this.soi;
  }
  
  public final Context getActivityContext()
  {
    AppMethodBeat.i(76334);
    Context localContext = getContext();
    AppMethodBeat.o(76334);
    return localContext;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(76333);
    super.onCreate(paramBundle);
    getWindow().setLayout(-1, -1);
    getWindow().addFlags(67108864);
    getWindow().setDimAmount(0.5F);
    paramBundle = LayoutInflater.from(getContext()).inflate(e.b.box_dialog, null, false);
    paramBundle.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(76331);
        a.this.dismiss();
        AppMethodBeat.o(76331);
        return true;
      }
    });
    setContentView(paramBundle, new ViewGroup.LayoutParams(-1, -1));
    this.soh = ((FrameLayout)paramBundle.findViewById(e.a.webview_container));
    this.sok = new com.tencent.mm.plugin.box.webview.b(this);
    this.soj = new BoxWebView(MMApplicationContext.getContext());
    this.soi = new d(this);
    paramBundle = new com.tencent.mm.plugin.box.webview.a();
    c localc = new c(this.sog, this.sok);
    this.soj.a(paramBundle, localc);
    this.soj.addJavascriptInterface(this.soi, "boxJSApi");
    Log.i("MicroMsg.Box.BoxHomeUI", "start to load url %s", new Object[] { this.sog.Url });
    this.soj.loadUrl(this.sog.Url);
    this.soh.addView(this.soj);
    setCancelable(true);
    setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(76332);
        Log.i("MicroMsg.Box.BoxHomeUI", "dismiss dialog");
        if (a.a(a.this) != null)
        {
          paramAnonymousDialogInterface = a.a(a.this);
          if (paramAnonymousDialogInterface.son != null) {
            h.aGY().a(paramAnonymousDialogInterface.son);
          }
          h.aGY().b(1869, paramAnonymousDialogInterface);
        }
        if (a.b(a.this) != null)
        {
          a.b(a.this).removeJavascriptInterface("boxJSApi");
          a.b(a.this).destroy();
          a.c(a.this);
        }
        AppMethodBeat.o(76332);
      }
    });
    getWindow().setWindowAnimations(e.c.BottomToTopSlowAnimation);
    com.tencent.mm.plugin.box.a.a.rE(1);
    AppMethodBeat.o(76333);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.box.c.a
 * JD-Core Version:    0.7.0.1
 */