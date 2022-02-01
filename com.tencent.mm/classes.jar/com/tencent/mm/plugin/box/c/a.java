package com.tencent.mm.plugin.box.c;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.box.webview.BoxWebView;
import com.tencent.mm.plugin.box.webview.b;
import com.tencent.mm.plugin.box.webview.d;
import com.tencent.mm.protocal.protobuf.ps;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

public final class a
  extends android.support.v7.app.e
  implements c
{
  private ps oaR;
  private FrameLayout oaS;
  private d oaT;
  private BoxWebView oaU;
  private b oaV;
  
  public a(Context paramContext, ps paramps)
  {
    super(paramContext, 2131820791);
    this.oaR = paramps;
  }
  
  public final com.tencent.mm.plugin.box.webview.e bNY()
  {
    return this.oaV;
  }
  
  public final d bNZ()
  {
    return this.oaT;
  }
  
  public final Context getActivityContext()
  {
    AppMethodBeat.i(76334);
    Context localContext = getContext();
    AppMethodBeat.o(76334);
    return localContext;
  }
  
  public final BoxWebView getBoxWebView()
  {
    return this.oaU;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(76333);
    super.onCreate(paramBundle);
    getWindow().setLayout(-1, -1);
    getWindow().addFlags(67108864);
    getWindow().setDimAmount(0.5F);
    paramBundle = LayoutInflater.from(getContext()).inflate(2131493237, null, false);
    paramBundle.setOnTouchListener(new a.1(this));
    setContentView(paramBundle, new ViewGroup.LayoutParams(-1, -1));
    this.oaS = ((FrameLayout)paramBundle.findViewById(2131306912));
    this.oaS.setLayoutParams(this.oaS.getLayoutParams());
    this.oaV = new b(this);
    this.oaU = new BoxWebView(ak.getContext());
    this.oaT = new d(this);
    paramBundle = new com.tencent.mm.plugin.box.webview.a();
    com.tencent.mm.plugin.box.webview.c localc = new com.tencent.mm.plugin.box.webview.c(this.oaR, this.oaV);
    this.oaU.a(paramBundle, localc);
    this.oaU.addJavascriptInterface(this.oaT, "boxJSApi");
    ae.i("MicroMsg.Box.BoxHomeUI", "start to load url %s", new Object[] { this.oaR.Url });
    this.oaU.loadUrl(this.oaR.Url);
    this.oaS.addView(this.oaU);
    setCancelable(true);
    setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(76332);
        ae.i("MicroMsg.Box.BoxHomeUI", "dismiss dialog");
        if (a.a(a.this) != null)
        {
          paramAnonymousDialogInterface = a.a(a.this);
          if (paramAnonymousDialogInterface.oaY != null) {
            g.ajj().a(paramAnonymousDialogInterface.oaY);
          }
          g.ajj().b(1869, paramAnonymousDialogInterface);
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
    getWindow().setWindowAnimations(2131820790);
    com.tencent.mm.plugin.box.a.a.md(1);
    AppMethodBeat.o(76333);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.box.c.a
 * JD-Core Version:    0.7.0.1
 */