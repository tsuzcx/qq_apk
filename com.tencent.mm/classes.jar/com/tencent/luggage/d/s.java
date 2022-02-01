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
  private q ctJ;
  public p ctS;
  SwipeBackLayout ctT;
  private String ctU;
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
    this.ctU = null;
    this.ctJ = new q()
    {
      public final String LJ()
      {
        AppMethodBeat.i(140446);
        String str = s.a(s.this);
        AppMethodBeat.o(140446);
        return str;
      }
      
      public final WebResourceResponse a(WebResourceRequest paramAnonymousWebResourceRequest, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(140447);
        if (s.this.LL() != null)
        {
          paramAnonymousWebResourceRequest = s.this.LL().a(paramAnonymousWebResourceRequest, paramAnonymousBundle);
          AppMethodBeat.o(140447);
          return paramAnonymousWebResourceRequest;
        }
        AppMethodBeat.o(140447);
        return null;
      }
      
      public final void cV(String paramAnonymousString)
      {
        AppMethodBeat.i(140444);
        if (s.this.LL() != null) {
          s.this.LL().a(s.this, paramAnonymousString);
        }
        AppMethodBeat.o(140444);
      }
      
      public final void cW(String paramAnonymousString)
      {
        AppMethodBeat.i(140445);
        if (s.this.LL() != null) {
          s.this.LL().b(s.this, paramAnonymousString);
        }
        s.this.Lh();
        AppMethodBeat.o(140445);
      }
    };
    if (paramBundle != null) {}
    for (;;)
    {
      this.mParams = paramBundle;
      this.ctS = paramp;
      paramp = this.ctS;
      paramj = paramp;
      if (paramp == null) {
        paramj = this.ctg.Lq();
      }
      paramp = paramj;
      if (paramj == null) {
        paramp = new p(this.mContext, this.ctg.Lr());
      }
      this.ctS = paramp;
      paramj = this.ctS;
      paramj.a(this.ctg.Lz(), this);
      paramj.ctJ = this.ctJ;
      paramj = Lf();
      this.ctT = new SwipeBackLayout(this.mContext);
      this.ctT.setScrimColor(0);
      this.ctT.addView(paramj);
      this.ctT.setContentView(paramj);
      this.ctT.a(new SwipeBackLayout.a()
      {
        public final void LN()
        {
          AppMethodBeat.i(140442);
          if (s.this.ctg.Lx().size() <= 1) {
            s.this.ctT.setEnableGesture(false);
          }
          AppMethodBeat.o(140442);
        }
        
        public final int bS(boolean paramAnonymousBoolean)
        {
          return 1;
        }
        
        public final void i(int paramAnonymousInt, float paramAnonymousFloat)
        {
          AppMethodBeat.i(140443);
          Object localObject = s.this;
          paramAnonymousInt = ((h)localObject).ctg.Lx().indexOf(localObject);
          if (paramAnonymousInt >= ((h)localObject).ctg.Lx().size() - 1) {}
          for (localObject = null; localObject == null; localObject = (h)((h)localObject).ctg.Lx().get(paramAnonymousInt + 1))
          {
            AppMethodBeat.o(140443);
            return;
          }
          if ((Float.compare(1.0F, paramAnonymousFloat) <= 0) && (this.ctV[0] == 0))
          {
            localObject = ((h)localObject).getContentView();
            ((View)localObject).clearAnimation();
            ((View)localObject).setTranslationX(0.0F);
            s.this.ctg.Ly().bR(false);
            this.ctV[0] = true;
          }
          Log.i("", "scrollPercent %f", new Object[] { Float.valueOf(paramAnonymousFloat) });
          AppMethodBeat.o(140443);
        }
        
        public final void n(MotionEvent paramAnonymousMotionEvent) {}
      });
      this.mContentView = this.ctT;
      AppMethodBeat.o(140451);
      return;
      paramBundle = new Bundle();
    }
  }
  
  protected String LJ()
  {
    return "";
  }
  
  public final void LK()
  {
    AppMethodBeat.i(140452);
    if (this.ctT != null) {
      this.ctT.setEnableGesture(false);
    }
    AppMethodBeat.o(140452);
  }
  
  public final a LL()
  {
    return (a)this.cth;
  }
  
  public void LM()
  {
    AppMethodBeat.i(221201);
    this.ctS.destroy();
    AppMethodBeat.o(221201);
  }
  
  public final n Lc()
  {
    return this.ctS;
  }
  
  protected View Lf()
  {
    AppMethodBeat.i(140454);
    View localView = this.ctS.getView();
    AppMethodBeat.o(140454);
    return localView;
  }
  
  public final void a(h.a parama)
  {
    AppMethodBeat.i(140455);
    if ((parama instanceof a))
    {
      this.cth = parama;
      AppMethodBeat.o(140455);
      return;
    }
    this.cth = new a(parama);
    AppMethodBeat.o(140455);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(140457);
    Ll();
    p localp = this.ctS;
    ViewParent localViewParent = localp.getView().getParent();
    if ((localViewParent instanceof ViewGroup))
    {
      Log.i("Luggage.LuggageWebCore", "removeSelfFromParent");
      ((ViewGroup)localViewParent).removeView(localp.getView());
    }
    LM();
    AppMethodBeat.o(140457);
  }
  
  public void g(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(140453);
    this.ctS.loadUrl(paramString);
    AppMethodBeat.o(140453);
  }
  
  public final View getContentView()
  {
    return this.mContentView;
  }
  
  public final Bundle getParams()
  {
    return this.mParams;
  }
  
  protected boolean onBackPressed()
  {
    AppMethodBeat.i(140456);
    if (this.ctS.ctK.canGoBack())
    {
      this.ctS.ctK.goBack();
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
      if ((this.ctj instanceof a))
      {
        paramWebResourceRequest = ((a)this.ctj).a(paramWebResourceRequest, paramBundle);
        AppMethodBeat.o(140450);
        return paramWebResourceRequest;
      }
      AppMethodBeat.o(140450);
      return null;
    }
    
    public void a(s params, String paramString)
    {
      AppMethodBeat.i(140448);
      if ((this.ctj instanceof a)) {
        ((a)this.ctj).a(params, paramString);
      }
      AppMethodBeat.o(140448);
    }
    
    public void b(s params, String paramString)
    {
      AppMethodBeat.i(140449);
      if ((this.ctj instanceof a)) {
        ((a)this.ctj).b(params, paramString);
      }
      AppMethodBeat.o(140449);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.d.s
 * JD-Core Version:    0.7.0.1
 */