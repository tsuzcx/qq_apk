package com.tencent.luggage.d;

import android.os.Bundle;
import android.view.View;
import com.tencent.luggage.webview.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import me.imid.swipebacklayout.lib.SwipeBackLayout;

public class n
  extends e
  implements b
{
  public View Qz;
  private l bze;
  public k bzs;
  SwipeBackLayout bzt;
  public Bundle bzu;
  private String bzv;
  
  public n(g paramg, Bundle paramBundle)
  {
    this(paramg, null, paramBundle);
  }
  
  public n(g paramg, k paramk, Bundle paramBundle)
  {
    super(paramg);
    AppMethodBeat.i(90850);
    this.bzv = null;
    this.bze = new n.2(this);
    if (paramBundle != null) {}
    for (;;)
    {
      this.bzu = paramBundle;
      this.bzs = paramk;
      paramk = this.bzs;
      paramg = paramk;
      if (paramk == null) {
        paramg = this.byJ.ui();
      }
      paramk = paramg;
      if (paramg == null) {
        paramk = new k(this.mContext, this.byJ.uj());
      }
      this.bzs = paramk;
      paramg = this.bzs;
      paramg.a(this.byJ.uo(), this);
      paramg.bze = this.bze;
      paramg = tZ();
      this.bzt = new SwipeBackLayout(this.mContext);
      this.bzt.setScrimColor(0);
      this.bzt.addView(paramg);
      this.bzt.setContentView(paramg);
      this.bzt.a(new n.1(this, new boolean[] { false }));
      this.Qz = this.bzt;
      AppMethodBeat.o(90850);
      return;
      paramBundle = new Bundle();
    }
  }
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(90853);
    if ((parama instanceof n.a))
    {
      this.byK = parama;
      AppMethodBeat.o(90853);
      return;
    }
    this.byK = new n.a(parama);
    AppMethodBeat.o(90853);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(90855);
    ue();
    this.bzs.destroy();
    AppMethodBeat.o(90855);
  }
  
  public void g(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(90851);
    this.bzs.loadUrl(paramString);
    AppMethodBeat.o(90851);
  }
  
  public final View getContentView()
  {
    return this.Qz;
  }
  
  protected final boolean onBackPressed()
  {
    AppMethodBeat.i(90854);
    if (this.bzs.bzf.canGoBack())
    {
      this.bzs.bzf.goBack();
      AppMethodBeat.o(90854);
      return true;
    }
    AppMethodBeat.o(90854);
    return false;
  }
  
  protected View tZ()
  {
    AppMethodBeat.i(90852);
    View localView = this.bzs.getView();
    AppMethodBeat.o(90852);
    return localView;
  }
  
  protected String ux()
  {
    return "";
  }
  
  public final void uy()
  {
    AppMethodBeat.i(141785);
    if (this.bzt != null) {
      this.bzt.setEnableGesture(false);
    }
    AppMethodBeat.o(141785);
  }
  
  public final n.a uz()
  {
    return (n.a)this.byK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.d.n
 * JD-Core Version:    0.7.0.1
 */