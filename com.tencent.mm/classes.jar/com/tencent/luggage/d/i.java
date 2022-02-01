package com.tencent.luggage.d;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public class i
  implements k
{
  protected Class<? extends com.tencent.luggage.webview.a> ctk;
  public FrameLayout ctl;
  public a<h> ctm;
  protected e ctn;
  public f cto;
  public m ctp;
  Integer ctq;
  private Class<? extends com.tencent.luggage.webview.a> ctr;
  public j cts;
  protected Context mContext;
  
  public i(Activity paramActivity)
  {
    AppMethodBeat.i(140390);
    this.ctm = new a((byte)0);
    this.ctq = null;
    this.ctr = null;
    this.cts = new j()
    {
      public final f LA()
      {
        return i.this.cto;
      }
      
      public final p Lq()
      {
        AppMethodBeat.i(174614);
        p localp = i.a(i.this);
        AppMethodBeat.o(174614);
        return localp;
      }
      
      final Class<? extends com.tencent.luggage.webview.a> Lr()
      {
        AppMethodBeat.i(174612);
        Class localClass = i.this.Lr();
        AppMethodBeat.o(174612);
        return localClass;
      }
      
      public final LinkedList<h> Lx()
      {
        return i.this.ctm;
      }
      
      public final k Ly()
      {
        return i.this;
      }
      
      public final LinkedList<Class<? extends b>> Lz()
      {
        AppMethodBeat.i(174613);
        LinkedList localLinkedList = (LinkedList)i.this.ctn.ctd.clone();
        AppMethodBeat.o(174613);
        return localLinkedList;
      }
      
      final Context getContext()
      {
        return i.this.mContext;
      }
    };
    this.mContext = paramActivity;
    FrameLayout localFrameLayout = new FrameLayout(this.mContext);
    localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    localFrameLayout.setBackgroundColor(-1);
    this.ctl = localFrameLayout;
    this.ctn = new e();
    a(null);
    this.cto = f.aK(paramActivity);
    AppMethodBeat.o(140390);
  }
  
  private p Lq()
  {
    AppMethodBeat.i(140402);
    Object localObject = this.ctq;
    this.ctq = null;
    localObject = r.a(this.mContext, (Integer)localObject);
    if ((localObject != null) && (((p)localObject).ctI.equals(Lr())))
    {
      AppMethodBeat.o(140402);
      return localObject;
    }
    AppMethodBeat.o(140402);
    return null;
  }
  
  private void a(final h paramh)
  {
    AppMethodBeat.i(140400);
    this.ctl.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(140380);
        i.this.ctl.removeView(paramh.getContentView());
        AppMethodBeat.o(140380);
      }
    });
    paramh.destroy();
    AppMethodBeat.o(140400);
  }
  
  private void c(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(140403);
    this.ctl.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(140403);
  }
  
  public final j Lm()
  {
    return this.cts;
  }
  
  public final h Ln()
  {
    AppMethodBeat.i(140391);
    if (this.ctm.size() > 0)
    {
      h localh = (h)this.ctm.peek();
      AppMethodBeat.o(140391);
      return localh;
    }
    AppMethodBeat.o(140391);
    return null;
  }
  
  public final boolean Lo()
  {
    AppMethodBeat.i(140396);
    boolean bool = bR(true);
    AppMethodBeat.o(140396);
    return bool;
  }
  
  public final void Lp()
  {
    AppMethodBeat.i(140401);
    if (this.ctq != null)
    {
      AppMethodBeat.o(140401);
      return;
    }
    c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(174610);
        if (!((Activity)i.this.mContext).isFinishing()) {
          i.this.ctq = r.b(i.this.mContext.getApplicationContext(), i.this.Lr());
        }
        AppMethodBeat.o(174610);
      }
    }, 200L);
    AppMethodBeat.o(140401);
  }
  
  final Class<? extends com.tencent.luggage.webview.a> Lr()
  {
    if (this.ctr == null) {
      if (this.ctk != null) {
        break label27;
      }
    }
    label27:
    for (Object localObject = com.tencent.luggage.webview.default_impl.a.class;; localObject = this.ctk)
    {
      this.ctr = ((Class)localObject);
      return this.ctr;
    }
  }
  
  protected void Ls() {}
  
  protected void Lt() {}
  
  protected void Lu() {}
  
  protected void Lv() {}
  
  protected boolean Lw()
  {
    return true;
  }
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(140404);
    Object localObject = paramm;
    if (paramm == null) {
      localObject = new m()
      {
        public final h k(String paramAnonymousString, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(174611);
          paramAnonymousString = new s(i.this.cts, paramAnonymousBundle);
          AppMethodBeat.o(174611);
          return paramAnonymousString;
        }
      };
    }
    this.ctp = ((m)localObject);
    AppMethodBeat.o(140404);
  }
  
  public final boolean a(String paramString, Bundle paramBundle, final boolean paramBoolean)
  {
    AppMethodBeat.i(140395);
    final h localh = this.ctp.k(paramString, paramBundle);
    if (localh == null)
    {
      Log.e("LuggagePageContainer", "No page specified for url %s", new Object[] { paramString });
      AppMethodBeat.o(140395);
      return false;
    }
    if (!Lw())
    {
      Log.i("LuggagePageContainer", "Pushing page is banned");
      AppMethodBeat.o(140395);
      return false;
    }
    this.ctl.addView(localh.getContentView(), 0);
    localh.getContentView().setVisibility(4);
    final Runnable local1 = new Runnable()
    {
      boolean done = false;
      
      public final void run()
      {
        AppMethodBeat.i(140375);
        i.this.Lv();
        if (this.done)
        {
          AppMethodBeat.o(140375);
          return;
        }
        this.done = true;
        Object localObject2;
        ObjectAnimator localObjectAnimator;
        Object localObject3;
        if ((i.this.ctm.peek() != null) && (paramBoolean))
        {
          localObject1 = (h)i.this.ctm.peek();
          localObject2 = ObjectAnimator.ofFloat(((h)localObject1).getContentView(), "translationX", new float[] { 0.0F, -(((h)localObject1).getContentView().getWidth() * 0.25F) });
          ((ObjectAnimator)localObject2).setDuration(250L);
          localObjectAnimator = ObjectAnimator.ofFloat(((h)localObject1).getContentView(), "translationX", new float[] { 0.0F });
          localObjectAnimator.setDuration(0L);
          localObject3 = new AnimatorSet();
          ((AnimatorSet)localObject3).playSequentially(new Animator[] { localObject2, localObjectAnimator });
          ((h)localObject1).a((Animator)localObject3, null);
          ((h)i.this.ctm.peek()).Lj();
        }
        localh.getContentView().bringToFront();
        localh.getContentView().setVisibility(0);
        localh.Li();
        Object localObject1 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(140374);
            i.this.ctm.push(i.1.this.ctu);
            i.this.Lp();
            AppMethodBeat.o(140374);
          }
        };
        if (paramBoolean)
        {
          localObject2 = localh;
          localObjectAnimator = ObjectAnimator.ofFloat(((h)localObject2).getContentView(), "translationX", new float[] { ((h)localObject2).getContentView().getWidth(), 0.0F });
          localObjectAnimator.setDuration(250L);
          localObject3 = ObjectAnimator.ofFloat(((h)localObject2).getContentView(), "alpha", new float[] { 0.0F, 1.0F });
          ((ObjectAnimator)localObject3).setDuration(166L);
          AnimatorSet localAnimatorSet = new AnimatorSet();
          localAnimatorSet.playTogether(new Animator[] { localObjectAnimator, localObject3 });
          ((h)localObject2).a(localAnimatorSet, (Runnable)localObject1);
          AppMethodBeat.o(140375);
          return;
        }
        ((Runnable)localObject1).run();
        AppMethodBeat.o(140375);
      }
    };
    localh.ctf.a(new l.e()
    {
      public final void onReady()
      {
        AppMethodBeat.i(140376);
        local1.run();
        AppMethodBeat.o(140376);
      }
    });
    Lu();
    localh.g(paramString, paramBundle);
    c(local1, 300L);
    if (!paramBoolean) {
      local1.run();
    }
    AppMethodBeat.o(140395);
    return true;
  }
  
  public final boolean bR(boolean paramBoolean)
  {
    AppMethodBeat.i(140397);
    if (this.ctm.size() <= 1)
    {
      AppMethodBeat.o(140397);
      return false;
    }
    final h localh = (h)this.ctm.pop();
    if (paramBoolean)
    {
      localh.h(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(140377);
          i.a(i.this, localh);
          AppMethodBeat.o(140377);
        }
      });
      if (!paramBoolean) {
        break label94;
      }
      ((h)this.ctm.peek()).g(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(140378);
          ((h)i.this.ctm.peek()).Li();
          AppMethodBeat.o(140378);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(140397);
      return true;
      a(localh);
      break;
      label94:
      ((h)this.ctm.peek()).Li();
    }
  }
  
  public final boolean cS(String paramString)
  {
    AppMethodBeat.i(140393);
    boolean bool = h(paramString, null);
    AppMethodBeat.o(140393);
    return bool;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(140392);
    Object localObject = this.ctm.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((h)((Iterator)localObject).next()).destroy();
    }
    localObject = Lq();
    if (localObject != null) {
      ((p)localObject).destroy();
    }
    f.aL(this.mContext);
    AppMethodBeat.o(140392);
  }
  
  public final View getContentView()
  {
    return this.ctl;
  }
  
  public final boolean h(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(140394);
    if (!this.ctm.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      bool = a(paramString, paramBundle, bool);
      AppMethodBeat.o(140394);
      return bool;
    }
  }
  
  public final boolean i(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(140399);
    if (this.ctm.size() == 0) {}
    for (h localh = null;; localh = (h)this.ctm.pop())
    {
      if (localh != null) {
        a(localh);
      }
      boolean bool = a(paramString, paramBundle, false);
      AppMethodBeat.o(140399);
      return bool;
    }
  }
  
  public final boolean j(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(174615);
    final h localh = this.ctp.k(paramString, paramBundle);
    if (localh == null)
    {
      Log.e("LuggagePageContainer", "No page specified for url %s", new Object[] { paramString });
      AppMethodBeat.o(174615);
      return false;
    }
    localh.g(paramString, paramBundle);
    c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(140379);
        if (((Activity)i.this.mContext).isFinishing())
        {
          AppMethodBeat.o(140379);
          return;
        }
        if (i.this.ctm.size() == 0) {}
        for (h localh = null;; localh = (h)i.this.ctm.pop())
        {
          if (localh != null) {
            i.a(i.this, localh);
          }
          i.this.ctm.push(localh);
          i.this.ctl.addView(localh.getContentView());
          localh.Li();
          AppMethodBeat.o(140379);
          return;
        }
      }
    }, 500L);
    AppMethodBeat.o(174615);
    return true;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(140405);
    h localh = Ln();
    if (localh == null)
    {
      AppMethodBeat.o(140405);
      return;
    }
    localh.Li();
    AppMethodBeat.o(140405);
  }
  
  public final boolean remove(int paramInt)
  {
    AppMethodBeat.i(140398);
    if (paramInt < 0)
    {
      AppMethodBeat.o(140398);
      return true;
    }
    if ((this.ctm.size() <= 1) || (this.ctm.size() <= paramInt))
    {
      AppMethodBeat.o(140398);
      return false;
    }
    if (paramInt == 0)
    {
      boolean bool = bR(false);
      AppMethodBeat.o(140398);
      return bool;
    }
    a((h)this.ctm.remove(paramInt));
    AppMethodBeat.o(140398);
    return true;
  }
  
  public final class a<E>
    extends LinkedList<E>
  {
    private a() {}
    
    public final void add(int paramInt, E paramE)
    {
      AppMethodBeat.i(140389);
      super.add(paramInt, paramE);
      i.this.Ls();
      AppMethodBeat.o(140389);
    }
    
    public final boolean add(E paramE)
    {
      AppMethodBeat.i(140388);
      boolean bool = super.add(paramE);
      if (bool) {
        i.this.Ls();
      }
      AppMethodBeat.o(140388);
      return bool;
    }
    
    public final E pop()
    {
      AppMethodBeat.i(140386);
      Object localObject = super.pop();
      i.this.Lt();
      AppMethodBeat.o(140386);
      return localObject;
    }
    
    public final void push(E paramE)
    {
      AppMethodBeat.i(140387);
      super.push(paramE);
      i.this.Ls();
      AppMethodBeat.o(140387);
    }
    
    public final E remove(int paramInt)
    {
      AppMethodBeat.i(140385);
      Object localObject = super.remove(paramInt);
      i.this.Lt();
      AppMethodBeat.o(140385);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.d.i
 * JD-Core Version:    0.7.0.1
 */