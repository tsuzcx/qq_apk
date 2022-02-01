package com.tencent.luggage.d;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.SwipeBackLayout.a;

public class s
  extends h
  implements a
{
  private q crO;
  public p crX;
  SwipeBackLayout crY;
  private String crZ;
  public View mContentView;
  public Bundle mParams;
  
  public s(j paramj, Bundle paramBundle)
  {
    this(paramj, null, paramBundle);
  }
  
  public s(j paramj, p paramp, Bundle paramBundle)
  {
    super(paramj);
    AppMethodBeat.i(140451);
    this.crZ = null;
    this.crO = new q()
    {
      public final String Oz()
      {
        AppMethodBeat.i(140446);
        String str = s.a(s.this);
        AppMethodBeat.o(140446);
        return str;
      }
      
      public final WebResourceResponse a(WebResourceRequest paramAnonymousWebResourceRequest, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(140447);
        if (s.this.OC() != null)
        {
          paramAnonymousWebResourceRequest = s.this.OC().a(paramAnonymousWebResourceRequest, paramAnonymousBundle);
          AppMethodBeat.o(140447);
          return paramAnonymousWebResourceRequest;
        }
        AppMethodBeat.o(140447);
        return null;
      }
      
      public final void dv(String paramAnonymousString)
      {
        AppMethodBeat.i(140444);
        if (s.this.OC() != null) {
          s.this.OC().a(s.this, paramAnonymousString);
        }
        AppMethodBeat.o(140444);
      }
      
      public final void dw(String paramAnonymousString)
      {
        AppMethodBeat.i(140445);
        if (s.this.OC() != null) {
          s.this.OC().b(s.this, paramAnonymousString);
        }
        s.this.crl.P(l.e.class);
        AppMethodBeat.o(140445);
      }
    };
    if (paramBundle != null) {}
    for (;;)
    {
      this.mParams = paramBundle;
      this.crX = paramp;
      paramp = this.crX;
      paramj = paramp;
      if (paramp == null) {
        paramj = this.crm.Og();
      }
      paramp = paramj;
      if (paramj == null) {
        paramp = new p(getContext(), this.crm.Oh());
      }
      this.crX = paramp;
      paramj = this.crX;
      paramj.a(this.crm.Op(), this);
      paramj.crO = this.crO;
      paramj = NW();
      this.crY = new SwipeBackLayout(getContext());
      this.crY.setScrimColor(0);
      this.crY.addView(paramj);
      this.crY.setContentView(paramj);
      this.crY.a(new SwipeBackLayout.a()
      {
        public final void OE()
        {
          AppMethodBeat.i(140442);
          if (s.this.crm.On().size() <= 1) {
            s.this.crY.setEnableGesture(false);
          }
          AppMethodBeat.o(140442);
        }
        
        public final int cc(boolean paramAnonymousBoolean)
        {
          return 1;
        }
        
        public final void j(int paramAnonymousInt, float paramAnonymousFloat)
        {
          AppMethodBeat.i(140443);
          Object localObject = s.this;
          paramAnonymousInt = ((h)localObject).crm.On().indexOf(localObject);
          if (paramAnonymousInt >= ((h)localObject).crm.On().size() - 1) {}
          for (localObject = null; localObject == null; localObject = (h)((h)localObject).crm.On().get(paramAnonymousInt + 1))
          {
            AppMethodBeat.o(140443);
            return;
          }
          if ((Float.compare(1.0F, paramAnonymousFloat) <= 0) && (this.csa[0] == 0))
          {
            localObject = ((h)localObject).getContentView();
            ((View)localObject).clearAnimation();
            ((View)localObject).setTranslationX(0.0F);
            s.this.crm.Oo().cb(false);
            this.csa[0] = true;
          }
          Log.i("", "scrollPercent %f", new Object[] { Float.valueOf(paramAnonymousFloat) });
          AppMethodBeat.o(140443);
        }
        
        public final void n(MotionEvent paramAnonymousMotionEvent) {}
      });
      this.mContentView = this.crY;
      AppMethodBeat.o(140451);
      return;
      paramBundle = new Bundle();
    }
  }
  
  public final n NS()
  {
    return this.crX;
  }
  
  protected View NW()
  {
    AppMethodBeat.i(140454);
    View localView = this.crX.getView();
    AppMethodBeat.o(140454);
    return localView;
  }
  
  public final Bundle OA()
  {
    return this.mParams;
  }
  
  public final void OB()
  {
    AppMethodBeat.i(140452);
    if (this.crY != null) {
      this.crY.setEnableGesture(false);
    }
    AppMethodBeat.o(140452);
  }
  
  public final a OC()
  {
    return (a)this.crn;
  }
  
  public void OD()
  {
    AppMethodBeat.i(209608);
    this.crX.destroy();
    AppMethodBeat.o(209608);
  }
  
  protected String Oz()
  {
    return "";
  }
  
  public final void a(h.a parama)
  {
    AppMethodBeat.i(140455);
    if ((parama instanceof a))
    {
      this.crn = parama;
      AppMethodBeat.o(140455);
      return;
    }
    this.crn = new a(parama);
    AppMethodBeat.o(140455);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(140457);
    Ob();
    p localp = this.crX;
    ViewParent localViewParent = localp.getView().getParent();
    if ((localViewParent instanceof ViewGroup))
    {
      Log.i("Luggage.LuggageWebCore", "removeSelfFromParent");
      ((ViewGroup)localViewParent).removeView(localp.getView());
    }
    OD();
    AppMethodBeat.o(140457);
  }
  
  public final View getContentView()
  {
    return this.mContentView;
  }
  
  public void l(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(140453);
    this.crX.loadUrl(paramString);
    AppMethodBeat.o(140453);
  }
  
  protected boolean onBackPressed()
  {
    AppMethodBeat.i(140456);
    if (this.crX.crP.canGoBack())
    {
      this.crX.crP.goBack();
      AppMethodBeat.o(140456);
      return true;
    }
    AppMethodBeat.o(140456);
    return false;
  }
  
  public static class a
    extends h.a
  {
    public a() {}
    
    protected a(h.a parama)
    {
      super();
    }
    
    public WebResourceResponse a(WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
    {
      AppMethodBeat.i(140450);
      if ((this.crp instanceof a))
      {
        paramWebResourceRequest = ((a)this.crp).a(paramWebResourceRequest, paramBundle);
        AppMethodBeat.o(140450);
        return paramWebResourceRequest;
      }
      AppMethodBeat.o(140450);
      return null;
    }
    
    public void a(s params, String paramString)
    {
      AppMethodBeat.i(140448);
      if ((this.crp instanceof a)) {
        ((a)this.crp).a(params, paramString);
      }
      AppMethodBeat.o(140448);
    }
    
    public void b(s params, String paramString)
    {
      AppMethodBeat.i(140449);
      if ((this.crp instanceof a)) {
        ((a)this.crp).b(params, paramString);
      }
      AppMethodBeat.o(140449);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.d.s
 * JD-Core Version:    0.7.0.1
 */