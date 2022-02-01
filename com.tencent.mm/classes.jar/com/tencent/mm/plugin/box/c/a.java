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
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.box.webview.BoxWebView;
import com.tencent.mm.plugin.box.webview.b;
import com.tencent.mm.plugin.box.webview.d;
import com.tencent.mm.protocal.protobuf.pq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class a
  extends android.support.v7.app.e
  implements c
{
  private pq nVk;
  private FrameLayout nVl;
  private d nVm;
  private BoxWebView nVn;
  private b nVo;
  
  public a(Context paramContext, pq parampq)
  {
    super(paramContext, 2131820791);
    this.nVk = parampq;
  }
  
  public final com.tencent.mm.plugin.box.webview.e bNa()
  {
    return this.nVo;
  }
  
  public final d bNb()
  {
    return this.nVm;
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
    return this.nVn;
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
    this.nVl = ((FrameLayout)paramBundle.findViewById(2131306912));
    this.nVl.setLayoutParams(this.nVl.getLayoutParams());
    this.nVo = new b(this);
    this.nVn = new BoxWebView(aj.getContext());
    this.nVm = new d(this);
    paramBundle = new com.tencent.mm.plugin.box.webview.a();
    com.tencent.mm.plugin.box.webview.c localc = new com.tencent.mm.plugin.box.webview.c(this.nVk, this.nVo);
    this.nVn.a(paramBundle, localc);
    this.nVn.addJavascriptInterface(this.nVm, "boxJSApi");
    ad.i("MicroMsg.Box.BoxHomeUI", "start to load url %s", new Object[] { this.nVk.Url });
    this.nVn.loadUrl(this.nVk.Url);
    this.nVl.addView(this.nVn);
    setCancelable(true);
    setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(76332);
        ad.i("MicroMsg.Box.BoxHomeUI", "dismiss dialog");
        if (a.a(a.this) != null)
        {
          paramAnonymousDialogInterface = a.a(a.this);
          if (paramAnonymousDialogInterface.nVr != null) {
            g.aiU().a(paramAnonymousDialogInterface.nVr);
          }
          g.aiU().b(1869, paramAnonymousDialogInterface);
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
    com.tencent.mm.plugin.box.a.a.ma(1);
    AppMethodBeat.o(76333);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.box.c.a
 * JD-Core Version:    0.7.0.1
 */