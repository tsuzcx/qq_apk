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
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.box.e.a;
import com.tencent.mm.plugin.box.e.b;
import com.tencent.mm.plugin.box.e.c;
import com.tencent.mm.plugin.box.webview.BoxWebView;
import com.tencent.mm.plugin.box.webview.c;
import com.tencent.mm.plugin.box.webview.d;
import com.tencent.mm.protocal.protobuf.rx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
  extends androidx.appcompat.app.e
  implements b
{
  private rx vAe;
  private FrameLayout vAf;
  private d vAg;
  private BoxWebView vAh;
  private com.tencent.mm.plugin.box.webview.b vAi;
  
  public a(Context paramContext, rx paramrx)
  {
    super(paramContext, e.c.BoxDialog);
    this.vAe = paramrx;
  }
  
  public final BoxWebView dbl()
  {
    return this.vAh;
  }
  
  public final com.tencent.mm.plugin.box.webview.e dbm()
  {
    return this.vAi;
  }
  
  public final d dbn()
  {
    return this.vAg;
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
    this.vAf = ((FrameLayout)paramBundle.findViewById(e.a.webview_container));
    this.vAi = new com.tencent.mm.plugin.box.webview.b(this);
    this.vAh = new BoxWebView(MMApplicationContext.getContext());
    this.vAg = new d(this);
    paramBundle = new com.tencent.mm.plugin.box.webview.a();
    c localc = new c(this.vAe, this.vAi);
    this.vAh.a(paramBundle, localc);
    this.vAh.addJavascriptInterface(this.vAg, "boxJSApi");
    Log.i("MicroMsg.Box.BoxHomeUI", "start to load url %s", new Object[] { this.vAe.Url });
    this.vAh.loadUrl(this.vAe.Url);
    this.vAf.addView(this.vAh);
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
          if (paramAnonymousDialogInterface.vAl != null) {
            h.aZW().a(paramAnonymousDialogInterface.vAl);
          }
          h.aZW().b(1869, paramAnonymousDialogInterface);
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
    com.tencent.mm.plugin.box.a.a.rG(1);
    AppMethodBeat.o(76333);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.box.c.a
 * JD-Core Version:    0.7.0.1
 */