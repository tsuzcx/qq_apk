package com.tencent.luggage.d;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.tencent.luggage.webview.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.SwipeBackLayout.a;

public class n
  extends e
  implements b
{
  public k bXF;
  SwipeBackLayout bXG;
  private String bXH;
  private l bXr;
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
    this.bXH = null;
    this.bXr = new l()
    {
      public final String AQ()
      {
        AppMethodBeat.i(140446);
        String str = n.a(n.this);
        AppMethodBeat.o(140446);
        return str;
      }
      
      public final WebResourceResponse a(WebResourceRequest paramAnonymousWebResourceRequest, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(140447);
        if (n.this.AS() != null)
        {
          paramAnonymousWebResourceRequest = n.this.AS().a(paramAnonymousWebResourceRequest, paramAnonymousBundle);
          AppMethodBeat.o(140447);
          return paramAnonymousWebResourceRequest;
        }
        AppMethodBeat.o(140447);
        return null;
      }
      
      public final void bK(String paramAnonymousString)
      {
        AppMethodBeat.i(140444);
        if (n.this.AS() != null) {
          n.this.AS().a(n.this, paramAnonymousString);
        }
        AppMethodBeat.o(140444);
      }
      
      public final void bL(String paramAnonymousString)
      {
        AppMethodBeat.i(140445);
        if (n.this.AS() != null) {
          n.this.AS().b(n.this, paramAnonymousString);
        }
        n.this.As();
        AppMethodBeat.o(140445);
      }
    };
    if (paramBundle != null) {}
    for (;;)
    {
      this.mParams = paramBundle;
      this.bXF = paramk;
      paramk = this.bXF;
      paramg = paramk;
      if (paramk == null) {
        paramg = this.bWW.AA();
      }
      paramk = paramg;
      if (paramg == null) {
        paramk = new k(this.mContext, this.bWW.AB());
      }
      this.bXF = paramk;
      paramg = this.bXF;
      paramg.a(this.bWW.AG(), this);
      paramg.bXr = this.bXr;
      paramg = Ar();
      this.bXG = new SwipeBackLayout(this.mContext);
      this.bXG.setScrimColor(0);
      this.bXG.addView(paramg);
      this.bXG.setContentView(paramg);
      this.bXG.a(new SwipeBackLayout.a()
      {
        public final void AT()
        {
          AppMethodBeat.i(140442);
          if (n.this.bWW.AE().size() <= 1) {
            n.this.bXG.setEnableGesture(false);
          }
          AppMethodBeat.o(140442);
        }
        
        public final int bp(boolean paramAnonymousBoolean)
        {
          return 1;
        }
        
        public final void h(int paramAnonymousInt, float paramAnonymousFloat)
        {
          AppMethodBeat.i(140443);
          Object localObject = n.this;
          paramAnonymousInt = ((e)localObject).bWW.AE().indexOf(localObject);
          if (paramAnonymousInt >= ((e)localObject).bWW.AE().size() - 1) {}
          for (localObject = null; localObject == null; localObject = (e)((e)localObject).bWW.AE().get(paramAnonymousInt + 1))
          {
            AppMethodBeat.o(140443);
            return;
          }
          if ((Float.compare(1.0F, paramAnonymousFloat) <= 0) && (this.bXI[0] == 0))
          {
            localObject = ((e)localObject).getContentView();
            ((View)localObject).clearAnimation();
            ((View)localObject).setTranslationX(0.0F);
            n.this.bWW.AF().bo(false);
            this.bXI[0] = true;
          }
          ac.i("", "scrollPercent %f", new Object[] { Float.valueOf(paramAnonymousFloat) });
          AppMethodBeat.o(140443);
        }
        
        public final void k(MotionEvent paramAnonymousMotionEvent) {}
      });
      this.mContentView = this.bXG;
      AppMethodBeat.o(140451);
      return;
      paramBundle = new Bundle();
    }
  }
  
  protected String AQ()
  {
    return "";
  }
  
  public final void AR()
  {
    AppMethodBeat.i(140452);
    if (this.bXG != null) {
      this.bXG.setEnableGesture(false);
    }
    AppMethodBeat.o(140452);
  }
  
  public final a AS()
  {
    return (a)this.bWX;
  }
  
  protected View Ar()
  {
    AppMethodBeat.i(140454);
    View localView = this.bXF.getView();
    AppMethodBeat.o(140454);
    return localView;
  }
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(140455);
    if ((parama instanceof a))
    {
      this.bWX = parama;
      AppMethodBeat.o(140455);
      return;
    }
    this.bWX = new a(parama);
    AppMethodBeat.o(140455);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(140457);
    Aw();
    this.bXF.destroy();
    AppMethodBeat.o(140457);
  }
  
  public void g(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(140453);
    this.bXF.loadUrl(paramString);
    AppMethodBeat.o(140453);
  }
  
  public final View getContentView()
  {
    return this.mContentView;
  }
  
  protected final boolean onBackPressed()
  {
    AppMethodBeat.i(140456);
    if (this.bXF.bXs.canGoBack())
    {
      this.bXF.bXs.goBack();
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
      if ((this.bWZ instanceof a))
      {
        paramWebResourceRequest = ((a)this.bWZ).a(paramWebResourceRequest, paramBundle);
        AppMethodBeat.o(140450);
        return paramWebResourceRequest;
      }
      AppMethodBeat.o(140450);
      return null;
    }
    
    public void a(n paramn, String paramString)
    {
      AppMethodBeat.i(140448);
      if ((this.bWZ instanceof a)) {
        ((a)this.bWZ).a(paramn, paramString);
      }
      AppMethodBeat.o(140448);
    }
    
    public void b(n paramn, String paramString)
    {
      AppMethodBeat.i(140449);
      if ((this.bWZ instanceof a)) {
        ((a)this.bWZ).b(paramn, paramString);
      }
      AppMethodBeat.o(140449);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.d.n
 * JD-Core Version:    0.7.0.1
 */