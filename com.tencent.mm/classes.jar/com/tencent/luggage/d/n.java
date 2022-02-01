package com.tencent.luggage.d;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.tencent.luggage.webview.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.SwipeBackLayout.a;

public class n
  extends e
  implements b
{
  public k caI;
  SwipeBackLayout caJ;
  private String caK;
  private l cau;
  public View mContentView;
  public Bundle mParams;
  
  public n(g paramg, Bundle paramBundle)
  {
    this(paramg, null, paramBundle);
  }
  
  public n(g paramg, k paramk, Bundle paramBundle)
  {
    super(paramg);
    AppMethodBeat.i(140451);
    this.caK = null;
    this.cau = new l()
    {
      public final String Bm()
      {
        AppMethodBeat.i(140446);
        String str = n.a(n.this);
        AppMethodBeat.o(140446);
        return str;
      }
      
      public final WebResourceResponse a(WebResourceRequest paramAnonymousWebResourceRequest, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(140447);
        if (n.this.Bo() != null)
        {
          paramAnonymousWebResourceRequest = n.this.Bo().a(paramAnonymousWebResourceRequest, paramAnonymousBundle);
          AppMethodBeat.o(140447);
          return paramAnonymousWebResourceRequest;
        }
        AppMethodBeat.o(140447);
        return null;
      }
      
      public final void bU(String paramAnonymousString)
      {
        AppMethodBeat.i(140444);
        if (n.this.Bo() != null) {
          n.this.Bo().a(n.this, paramAnonymousString);
        }
        AppMethodBeat.o(140444);
      }
      
      public final void bV(String paramAnonymousString)
      {
        AppMethodBeat.i(140445);
        if (n.this.Bo() != null) {
          n.this.Bo().b(n.this, paramAnonymousString);
        }
        n.this.AO();
        AppMethodBeat.o(140445);
      }
    };
    if (paramBundle != null) {}
    for (;;)
    {
      this.mParams = paramBundle;
      this.caI = paramk;
      paramk = this.caI;
      paramg = paramk;
      if (paramk == null) {
        paramg = this.bZZ.AW();
      }
      paramk = paramg;
      if (paramg == null) {
        paramk = new k(this.mContext, this.bZZ.AX());
      }
      this.caI = paramk;
      paramg = this.caI;
      paramg.a(this.bZZ.Bc(), this);
      paramg.cau = this.cau;
      paramg = AN();
      this.caJ = new SwipeBackLayout(this.mContext);
      this.caJ.setScrimColor(0);
      this.caJ.addView(paramg);
      this.caJ.setContentView(paramg);
      this.caJ.a(new SwipeBackLayout.a()
      {
        public final void Bp()
        {
          AppMethodBeat.i(140442);
          if (n.this.bZZ.Ba().size() <= 1) {
            n.this.caJ.setEnableGesture(false);
          }
          AppMethodBeat.o(140442);
        }
        
        public final int bq(boolean paramAnonymousBoolean)
        {
          return 1;
        }
        
        public final void h(int paramAnonymousInt, float paramAnonymousFloat)
        {
          AppMethodBeat.i(140443);
          Object localObject = n.this;
          paramAnonymousInt = ((e)localObject).bZZ.Ba().indexOf(localObject);
          if (paramAnonymousInt >= ((e)localObject).bZZ.Ba().size() - 1) {}
          for (localObject = null; localObject == null; localObject = (e)((e)localObject).bZZ.Ba().get(paramAnonymousInt + 1))
          {
            AppMethodBeat.o(140443);
            return;
          }
          if ((Float.compare(1.0F, paramAnonymousFloat) <= 0) && (this.caL[0] == 0))
          {
            localObject = ((e)localObject).getContentView();
            ((View)localObject).clearAnimation();
            ((View)localObject).setTranslationX(0.0F);
            n.this.bZZ.Bb().bp(false);
            this.caL[0] = true;
          }
          ad.i("", "scrollPercent %f", new Object[] { Float.valueOf(paramAnonymousFloat) });
          AppMethodBeat.o(140443);
        }
        
        public final void m(MotionEvent paramAnonymousMotionEvent) {}
      });
      this.mContentView = this.caJ;
      AppMethodBeat.o(140451);
      return;
      paramBundle = new Bundle();
    }
  }
  
  protected View AN()
  {
    AppMethodBeat.i(140454);
    View localView = this.caI.getView();
    AppMethodBeat.o(140454);
    return localView;
  }
  
  protected String Bm()
  {
    return "";
  }
  
  public final void Bn()
  {
    AppMethodBeat.i(140452);
    if (this.caJ != null) {
      this.caJ.setEnableGesture(false);
    }
    AppMethodBeat.o(140452);
  }
  
  public final a Bo()
  {
    return (a)this.caa;
  }
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(140455);
    if ((parama instanceof a))
    {
      this.caa = parama;
      AppMethodBeat.o(140455);
      return;
    }
    this.caa = new a(parama);
    AppMethodBeat.o(140455);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(140457);
    AS();
    this.caI.destroy();
    AppMethodBeat.o(140457);
  }
  
  public void g(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(140453);
    this.caI.loadUrl(paramString);
    AppMethodBeat.o(140453);
  }
  
  public final View getContentView()
  {
    return this.mContentView;
  }
  
  protected final boolean onBackPressed()
  {
    AppMethodBeat.i(140456);
    if (this.caI.cav.canGoBack())
    {
      this.caI.cav.goBack();
      AppMethodBeat.o(140456);
      return true;
    }
    AppMethodBeat.o(140456);
    return false;
  }
  
  public static class a
    extends e.a
  {
    public a() {}
    
    protected a(e.a parama)
    {
      super();
    }
    
    public WebResourceResponse a(WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
    {
      AppMethodBeat.i(140450);
      if ((this.cac instanceof a))
      {
        paramWebResourceRequest = ((a)this.cac).a(paramWebResourceRequest, paramBundle);
        AppMethodBeat.o(140450);
        return paramWebResourceRequest;
      }
      AppMethodBeat.o(140450);
      return null;
    }
    
    public void a(n paramn, String paramString)
    {
      AppMethodBeat.i(140448);
      if ((this.cac instanceof a)) {
        ((a)this.cac).a(paramn, paramString);
      }
      AppMethodBeat.o(140448);
    }
    
    public void b(n paramn, String paramString)
    {
      AppMethodBeat.i(140449);
      if ((this.cac instanceof a)) {
        ((a)this.cac).b(paramn, paramString);
      }
      AppMethodBeat.o(140449);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.d.n
 * JD-Core Version:    0.7.0.1
 */