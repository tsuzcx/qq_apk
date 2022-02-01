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
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.box.webview.BoxWebView;
import com.tencent.mm.plugin.box.webview.b;
import com.tencent.mm.plugin.box.webview.d;
import com.tencent.mm.protocal.protobuf.ol;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public final class a
  extends android.support.v7.app.e
  implements c
{
  private ol ntU;
  private FrameLayout ntV;
  private d ntW;
  private BoxWebView ntX;
  private b ntY;
  
  public a(Context paramContext, ol paramol)
  {
    super(paramContext, 2131820791);
    this.ntU = paramol;
  }
  
  public final com.tencent.mm.plugin.box.webview.e bIK()
  {
    return this.ntY;
  }
  
  public final d bIL()
  {
    return this.ntW;
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
    return this.ntX;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(76333);
    super.onCreate(paramBundle);
    getWindow().setLayout(-1, -1);
    getWindow().addFlags(67108864);
    getWindow().setDimAmount(0.5F);
    paramBundle = LayoutInflater.from(getContext()).inflate(2131493237, null, false);
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
    this.ntV = ((FrameLayout)paramBundle.findViewById(2131306912));
    this.ntV.setLayoutParams(this.ntV.getLayoutParams());
    this.ntY = new b(this);
    this.ntX = new BoxWebView(ai.getContext());
    this.ntW = new d(this);
    paramBundle = new com.tencent.mm.plugin.box.webview.a();
    com.tencent.mm.plugin.box.webview.c localc = new com.tencent.mm.plugin.box.webview.c(this.ntU, this.ntY);
    this.ntX.a(paramBundle, localc);
    this.ntX.addJavascriptInterface(this.ntW, "boxJSApi");
    ac.i("MicroMsg.Box.BoxHomeUI", "start to load url %s", new Object[] { this.ntU.Url });
    this.ntX.loadUrl(this.ntU.Url);
    this.ntV.addView(this.ntX);
    setCancelable(true);
    setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(76332);
        ac.i("MicroMsg.Box.BoxHomeUI", "dismiss dialog");
        if (a.a(a.this) != null)
        {
          paramAnonymousDialogInterface = a.a(a.this);
          if (paramAnonymousDialogInterface.nub != null) {
            g.agi().a(paramAnonymousDialogInterface.nub);
          }
          g.agi().b(1869, paramAnonymousDialogInterface);
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
    com.tencent.mm.plugin.box.a.a.lA(1);
    AppMethodBeat.o(76333);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.box.c.a
 * JD-Core Version:    0.7.0.1
 */