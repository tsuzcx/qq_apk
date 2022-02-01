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
  private q ejI;
  public p ejR;
  SwipeBackLayout ejS;
  public Bundle ejT;
  private String ejU;
  public View mContentView;
  
  public s(j paramj, Bundle paramBundle)
  {
    this(paramj, null, paramBundle);
  }
  
  public s(j paramj, p paramp, Bundle paramBundle)
  {
    super(paramj);
    AppMethodBeat.i(140451);
    this.ejU = null;
    this.ejI = new q()
    {
      public final WebResourceResponse a(WebResourceRequest paramAnonymousWebResourceRequest, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(140447);
        if (s.this.aoK() != null)
        {
          paramAnonymousWebResourceRequest = s.this.aoK().a(paramAnonymousWebResourceRequest, paramAnonymousBundle);
          AppMethodBeat.o(140447);
          return paramAnonymousWebResourceRequest;
        }
        AppMethodBeat.o(140447);
        return null;
      }
      
      public final String aoH()
      {
        AppMethodBeat.i(140446);
        String str = s.a(s.this);
        AppMethodBeat.o(140446);
        return str;
      }
      
      public final WebResourceResponse aoI()
      {
        AppMethodBeat.i(219936);
        if (s.this.aoK() != null)
        {
          s.this.aoK();
          AppMethodBeat.o(219936);
          return null;
        }
        AppMethodBeat.o(219936);
        return null;
      }
      
      public final void eG(String paramAnonymousString)
      {
        AppMethodBeat.i(140444);
        if (s.this.aoK() != null) {
          s.this.aoK().a(s.this, paramAnonymousString);
        }
        AppMethodBeat.o(140444);
      }
      
      public final void eH(String paramAnonymousString)
      {
        AppMethodBeat.i(140445);
        if (s.this.aoK() != null) {
          s.this.aoK().b(s.this, paramAnonymousString);
        }
        s.this.ejd.Y(l.e.class);
        AppMethodBeat.o(140445);
      }
    };
    if (paramBundle != null) {}
    for (;;)
    {
      this.ejT = paramBundle;
      this.ejR = paramp;
      paramp = this.ejR;
      paramj = paramp;
      if (paramp == null) {
        paramj = this.eje.aoo();
      }
      paramp = paramj;
      if (paramj == null) {
        paramp = new p(getContext(), this.eje.aop());
      }
      this.ejR = paramp;
      paramj = this.ejR;
      paramj.a(this.eje.aox(), this);
      paramj.ejI = this.ejI;
      paramj = aog();
      this.ejS = new SwipeBackLayout(getContext());
      this.ejS.setScrimColor(0);
      this.ejS.addView(paramj);
      this.ejS.setContentView(paramj);
      this.ejS.a(new SwipeBackLayout.a()
      {
        public final void aoM()
        {
          AppMethodBeat.i(140442);
          if (s.this.eje.aov().size() <= 1) {
            s.this.ejS.setEnableGesture(false);
          }
          AppMethodBeat.o(140442);
        }
        
        public final int cI(boolean paramAnonymousBoolean)
        {
          return 1;
        }
        
        public final void n(int paramAnonymousInt, float paramAnonymousFloat)
        {
          AppMethodBeat.i(140443);
          Object localObject = s.this;
          paramAnonymousInt = ((h)localObject).eje.aov().indexOf(localObject);
          if (paramAnonymousInt >= ((h)localObject).eje.aov().size() - 1) {}
          for (localObject = null; localObject == null; localObject = (h)((h)localObject).eje.aov().get(paramAnonymousInt + 1))
          {
            AppMethodBeat.o(140443);
            return;
          }
          if ((Float.compare(1.0F, paramAnonymousFloat) <= 0) && (this.ejV[0] == 0))
          {
            localObject = ((h)localObject).getContentView();
            ((View)localObject).clearAnimation();
            ((View)localObject).setTranslationX(0.0F);
            s.this.eje.aow().cH(false);
            this.ejV[0] = true;
          }
          Log.i("", "scrollPercent %f", new Object[] { Float.valueOf(paramAnonymousFloat) });
          AppMethodBeat.o(140443);
        }
        
        public final void n(MotionEvent paramAnonymousMotionEvent) {}
      });
      this.mContentView = this.ejS;
      AppMethodBeat.o(140451);
      return;
      paramBundle = new Bundle();
    }
  }
  
  public final void a(h.a parama)
  {
    AppMethodBeat.i(140455);
    if ((parama instanceof a))
    {
      this.ejf = parama;
      AppMethodBeat.o(140455);
      return;
    }
    this.ejf = new a(parama);
    AppMethodBeat.o(140455);
  }
  
  protected String aoH()
  {
    return "";
  }
  
  public final void aoJ()
  {
    AppMethodBeat.i(140452);
    if (this.ejS != null) {
      this.ejS.setEnableGesture(false);
    }
    AppMethodBeat.o(140452);
  }
  
  public final a aoK()
  {
    return (a)this.ejf;
  }
  
  public void aoL()
  {
    AppMethodBeat.i(219938);
    this.ejR.destroy();
    AppMethodBeat.o(219938);
  }
  
  public final n aod()
  {
    return this.ejR;
  }
  
  protected View aog()
  {
    AppMethodBeat.i(140454);
    View localView = this.ejR.getView();
    AppMethodBeat.o(140454);
    return localView;
  }
  
  public void destroy()
  {
    AppMethodBeat.i(140457);
    aok();
    p localp = this.ejR;
    ViewParent localViewParent = localp.getView().getParent();
    if ((localViewParent instanceof ViewGroup))
    {
      Log.i("Luggage.LuggageWebCore", "removeSelfFromParent");
      ((ViewGroup)localViewParent).removeView(localp.getView());
    }
    aoL();
    AppMethodBeat.o(140457);
  }
  
  public final View getContentView()
  {
    return this.mContentView;
  }
  
  public void l(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(140453);
    this.ejR.loadUrl(paramString);
    AppMethodBeat.o(140453);
  }
  
  protected boolean onBackPressed()
  {
    AppMethodBeat.i(140456);
    if (this.ejR.ejJ.canGoBack())
    {
      this.ejR.ejJ.goBack();
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
      if ((this.ejh instanceof a))
      {
        paramWebResourceRequest = ((a)this.ejh).a(paramWebResourceRequest, paramBundle);
        AppMethodBeat.o(140450);
        return paramWebResourceRequest;
      }
      AppMethodBeat.o(140450);
      return null;
    }
    
    public void a(s params, String paramString)
    {
      AppMethodBeat.i(140448);
      if ((this.ejh instanceof a)) {
        ((a)this.ejh).a(params, paramString);
      }
      AppMethodBeat.o(140448);
    }
    
    public void b(s params, String paramString)
    {
      AppMethodBeat.i(140449);
      if ((this.ejh instanceof a)) {
        ((a)this.ejh).b(params, paramString);
      }
      AppMethodBeat.o(140449);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.d.s
 * JD-Core Version:    0.7.0.1
 */