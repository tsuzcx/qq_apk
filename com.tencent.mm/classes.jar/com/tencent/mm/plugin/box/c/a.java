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
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.box.webview.BoxWebView;
import com.tencent.mm.plugin.box.webview.c;
import com.tencent.mm.plugin.box.webview.d;
import com.tencent.mm.protocal.protobuf.qt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
  extends android.support.v7.app.e
  implements b
{
  private qt plO;
  private FrameLayout plP;
  private d plQ;
  private BoxWebView plR;
  private com.tencent.mm.plugin.box.webview.b plS;
  
  public a(Context paramContext, qt paramqt)
  {
    super(paramContext, 2131820794);
    this.plO = paramqt;
  }
  
  public final BoxWebView ckY()
  {
    return this.plR;
  }
  
  public final com.tencent.mm.plugin.box.webview.e ckZ()
  {
    return this.plS;
  }
  
  public final d cla()
  {
    return this.plQ;
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
    paramBundle = LayoutInflater.from(getContext()).inflate(2131493319, null, false);
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
    this.plP = ((FrameLayout)paramBundle.findViewById(2131310385));
    this.plS = new com.tencent.mm.plugin.box.webview.b(this);
    this.plR = new BoxWebView(MMApplicationContext.getContext());
    this.plQ = new d(this);
    paramBundle = new com.tencent.mm.plugin.box.webview.a();
    c localc = new c(this.plO, this.plS);
    this.plR.a(paramBundle, localc);
    this.plR.addJavascriptInterface(this.plQ, "boxJSApi");
    Log.i("MicroMsg.Box.BoxHomeUI", "start to load url %s", new Object[] { this.plO.Url });
    this.plR.loadUrl(this.plO.Url);
    this.plP.addView(this.plR);
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
          if (paramAnonymousDialogInterface.plV != null) {
            g.azz().a(paramAnonymousDialogInterface.plV);
          }
          g.azz().b(1869, paramAnonymousDialogInterface);
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
    getWindow().setWindowAnimations(2131820793);
    com.tencent.mm.plugin.box.a.a.pl(1);
    AppMethodBeat.o(76333);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.box.c.a
 * JD-Core Version:    0.7.0.1
 */