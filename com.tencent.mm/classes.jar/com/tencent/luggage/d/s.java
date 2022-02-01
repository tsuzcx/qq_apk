package com.tencent.luggage.d;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.SwipeBackLayout.a;

public class s
  extends h
  implements a
{
  private q chO;
  public p chX;
  SwipeBackLayout chY;
  private String chZ;
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
    this.chZ = null;
    this.chO = new q()
    {
      public final String Cs()
      {
        AppMethodBeat.i(140446);
        String str = s.a(s.this);
        AppMethodBeat.o(140446);
        return str;
      }
      
      public final WebResourceResponse a(WebResourceRequest paramAnonymousWebResourceRequest, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(140447);
        if (s.this.Cu() != null)
        {
          paramAnonymousWebResourceRequest = s.this.Cu().a(paramAnonymousWebResourceRequest, paramAnonymousBundle);
          AppMethodBeat.o(140447);
          return paramAnonymousWebResourceRequest;
        }
        AppMethodBeat.o(140447);
        return null;
      }
      
      public final void cE(String paramAnonymousString)
      {
        AppMethodBeat.i(140444);
        if (s.this.Cu() != null) {
          s.this.Cu().a(s.this, paramAnonymousString);
        }
        AppMethodBeat.o(140444);
      }
      
      public final void cF(String paramAnonymousString)
      {
        AppMethodBeat.i(140445);
        if (s.this.Cu() != null) {
          s.this.Cu().b(s.this, paramAnonymousString);
        }
        s.this.BS();
        AppMethodBeat.o(140445);
      }
    };
    if (paramBundle != null) {}
    for (;;)
    {
      this.mParams = paramBundle;
      this.chX = paramp;
      paramp = this.chX;
      paramj = paramp;
      if (paramp == null) {
        paramj = this.chm.Ca();
      }
      paramp = paramj;
      if (paramj == null) {
        paramp = new p(this.mContext, this.chm.Cb());
      }
      this.chX = paramp;
      paramj = this.chX;
      paramj.a(this.chm.Ci(), this);
      paramj.chO = this.chO;
      paramj = BR();
      this.chY = new SwipeBackLayout(this.mContext);
      this.chY.setScrimColor(0);
      this.chY.addView(paramj);
      this.chY.setContentView(paramj);
      this.chY.a(new SwipeBackLayout.a()
      {
        public final void Cv()
        {
          AppMethodBeat.i(140442);
          if (s.this.chm.Cg().size() <= 1) {
            s.this.chY.setEnableGesture(false);
          }
          AppMethodBeat.o(140442);
        }
        
        public final int bq(boolean paramAnonymousBoolean)
        {
          return 1;
        }
        
        public final void i(int paramAnonymousInt, float paramAnonymousFloat)
        {
          AppMethodBeat.i(140443);
          Object localObject = s.this;
          paramAnonymousInt = ((h)localObject).chm.Cg().indexOf(localObject);
          if (paramAnonymousInt >= ((h)localObject).chm.Cg().size() - 1) {}
          for (localObject = null; localObject == null; localObject = (h)((h)localObject).chm.Cg().get(paramAnonymousInt + 1))
          {
            AppMethodBeat.o(140443);
            return;
          }
          if ((Float.compare(1.0F, paramAnonymousFloat) <= 0) && (this.cia[0] == 0))
          {
            localObject = ((h)localObject).getContentView();
            ((View)localObject).clearAnimation();
            ((View)localObject).setTranslationX(0.0F);
            s.this.chm.Ch().bp(false);
            this.cia[0] = true;
          }
          ae.i("", "scrollPercent %f", new Object[] { Float.valueOf(paramAnonymousFloat) });
          AppMethodBeat.o(140443);
        }
        
        public final void k(MotionEvent paramAnonymousMotionEvent) {}
      });
      this.mContentView = this.chY;
      AppMethodBeat.o(140451);
      return;
      paramBundle = new Bundle();
    }
  }
  
  public final n BO()
  {
    return this.chX;
  }
  
  protected View BR()
  {
    AppMethodBeat.i(140454);
    View localView = this.chX.getView();
    AppMethodBeat.o(140454);
    return localView;
  }
  
  protected String Cs()
  {
    return "";
  }
  
  public final void Ct()
  {
    AppMethodBeat.i(140452);
    if (this.chY != null) {
      this.chY.setEnableGesture(false);
    }
    AppMethodBeat.o(140452);
  }
  
  public final a Cu()
  {
    return (a)this.chn;
  }
  
  public final void a(h.a parama)
  {
    AppMethodBeat.i(140455);
    if ((parama instanceof a))
    {
      this.chn = parama;
      AppMethodBeat.o(140455);
      return;
    }
    this.chn = new a(parama);
    AppMethodBeat.o(140455);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(140457);
    BW();
    this.chX.destroy();
    AppMethodBeat.o(140457);
  }
  
  public void g(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(140453);
    this.chX.loadUrl(paramString);
    AppMethodBeat.o(140453);
  }
  
  public final View getContentView()
  {
    return this.mContentView;
  }
  
  protected final boolean onBackPressed()
  {
    AppMethodBeat.i(140456);
    if (this.chX.chP.canGoBack())
    {
      this.chX.chP.goBack();
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
      if ((this.chp instanceof a))
      {
        paramWebResourceRequest = ((a)this.chp).a(paramWebResourceRequest, paramBundle);
        AppMethodBeat.o(140450);
        return paramWebResourceRequest;
      }
      AppMethodBeat.o(140450);
      return null;
    }
    
    public void a(s params, String paramString)
    {
      AppMethodBeat.i(140448);
      if ((this.chp instanceof a)) {
        ((a)this.chp).a(params, paramString);
      }
      AppMethodBeat.o(140448);
    }
    
    public void b(s params, String paramString)
    {
      AppMethodBeat.i(140449);
      if ((this.chp instanceof a)) {
        ((a)this.chp).b(params, paramString);
      }
      AppMethodBeat.o(140449);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.d.s
 * JD-Core Version:    0.7.0.1
 */