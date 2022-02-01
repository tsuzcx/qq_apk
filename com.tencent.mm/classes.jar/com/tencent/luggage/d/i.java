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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public class i
  implements k
{
  private Class<? extends com.tencent.luggage.webview.a> eji;
  public FrameLayout ejj;
  public a<h> ejk;
  protected e ejl;
  public com.tencent.luggage.l.e ejm;
  public m ejn;
  Integer ejo;
  private Class<? extends com.tencent.luggage.webview.a> ejp;
  public j ejq;
  protected Context mContext;
  
  public i(Activity paramActivity)
  {
    AppMethodBeat.i(140390);
    this.ejk = new a((byte)0);
    this.ejo = null;
    this.ejp = null;
    this.ejq = new j()
    {
      public final p aoo()
      {
        AppMethodBeat.i(174614);
        p localp = i.this.aoo();
        AppMethodBeat.o(174614);
        return localp;
      }
      
      final Class<? extends com.tencent.luggage.webview.a> aop()
      {
        AppMethodBeat.i(174612);
        Class localClass = i.this.aop();
        AppMethodBeat.o(174612);
        return localClass;
      }
      
      public final LinkedList<h> aov()
      {
        return i.this.ejk;
      }
      
      public final k aow()
      {
        return i.this;
      }
      
      public final LinkedList<Class<? extends b>> aox()
      {
        AppMethodBeat.i(174613);
        LinkedList localLinkedList = (LinkedList)i.this.ejl.ejb.clone();
        AppMethodBeat.o(174613);
        return localLinkedList;
      }
      
      public final com.tencent.luggage.l.e aoy()
      {
        return i.this.ejm;
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
    this.ejj = localFrameLayout;
    this.ejl = new e();
    a(null);
    this.ejm = com.tencent.luggage.l.e.bt(paramActivity);
    AppMethodBeat.o(140390);
  }
  
  private void a(final h paramh)
  {
    AppMethodBeat.i(140400);
    this.ejj.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(140380);
        i.this.ejj.removeView(paramh.getContentView());
        AppMethodBeat.o(140380);
      }
    });
    paramh.destroy();
    AppMethodBeat.o(140400);
  }
  
  private void d(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(140403);
    this.ejj.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(140403);
  }
  
  public final void X(Class<? extends com.tencent.luggage.webview.a> paramClass)
  {
    this.eji = paramClass;
  }
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(140404);
    Object localObject = paramm;
    if (paramm == null) {
      localObject = new m()
      {
        public final h p(String paramAnonymousString, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(174611);
          paramAnonymousString = new s(i.this.ejq, paramAnonymousBundle);
          AppMethodBeat.o(174611);
          return paramAnonymousString;
        }
      };
    }
    this.ejn = ((m)localObject);
    AppMethodBeat.o(140404);
  }
  
  public final boolean a(String paramString, Bundle paramBundle, final boolean paramBoolean)
  {
    AppMethodBeat.i(140395);
    final h localh = this.ejn.p(paramString, paramBundle);
    if (localh == null)
    {
      Log.e("LuggagePageContainer", "No page specified for url %s", new Object[] { paramString });
      AppMethodBeat.o(140395);
      return false;
    }
    if (!aou())
    {
      Log.i("LuggagePageContainer", "Pushing page is banned");
      AppMethodBeat.o(140395);
      return false;
    }
    this.ejj.addView(localh.getContentView(), 0);
    localh.getContentView().setVisibility(4);
    final Runnable local1 = new Runnable()
    {
      boolean done = false;
      
      public final void run()
      {
        AppMethodBeat.i(140375);
        i.this.aot();
        if (this.done)
        {
          AppMethodBeat.o(140375);
          return;
        }
        this.done = true;
        Object localObject2;
        ObjectAnimator localObjectAnimator;
        Object localObject3;
        if ((i.this.ejk.peek() != null) && (paramBoolean))
        {
          localObject1 = (h)i.this.ejk.peek();
          localObject2 = ObjectAnimator.ofFloat(((h)localObject1).getContentView(), "translationX", new float[] { 0.0F, -(((h)localObject1).getContentView().getWidth() * 0.25F) });
          ((ObjectAnimator)localObject2).setDuration(250L);
          localObjectAnimator = ObjectAnimator.ofFloat(((h)localObject1).getContentView(), "translationX", new float[] { 0.0F });
          localObjectAnimator.setDuration(0L);
          localObject3 = new AnimatorSet();
          ((AnimatorSet)localObject3).playSequentially(new Animator[] { localObject2, localObjectAnimator });
          ((h)localObject1).a((Animator)localObject3, null);
          ((h)i.this.ejk.peek()).aoi();
        }
        localh.getContentView().bringToFront();
        localh.getContentView().setVisibility(0);
        localh.aoh();
        Object localObject1 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(140374);
            i.this.ejk.push(i.1.this.ejs);
            i.this.aon();
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
    localh.ejd.a(new l.e()
    {
      public final void onReady()
      {
        AppMethodBeat.i(140376);
        local1.run();
        AppMethodBeat.o(140376);
      }
    });
    aos();
    localh.l(paramString, paramBundle);
    d(local1, 300L);
    if (!paramBoolean) {
      local1.run();
    }
    AppMethodBeat.o(140395);
    return true;
  }
  
  public final h aol()
  {
    AppMethodBeat.i(140391);
    if (this.ejk.size() > 0)
    {
      h localh = (h)this.ejk.peek();
      AppMethodBeat.o(140391);
      return localh;
    }
    AppMethodBeat.o(140391);
    return null;
  }
  
  public final boolean aom()
  {
    AppMethodBeat.i(140396);
    boolean bool = cH(true);
    AppMethodBeat.o(140396);
    return bool;
  }
  
  public final void aon()
  {
    AppMethodBeat.i(140401);
    if (this.ejo != null)
    {
      AppMethodBeat.o(140401);
      return;
    }
    d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(174610);
        if (!((Activity)i.this.mContext).isFinishing()) {
          i.this.ejo = r.c(i.this.mContext.getApplicationContext(), i.this.aop());
        }
        AppMethodBeat.o(174610);
      }
    }, 200L);
    AppMethodBeat.o(140401);
  }
  
  final p aoo()
  {
    AppMethodBeat.i(140402);
    Object localObject = this.ejo;
    this.ejo = null;
    localObject = r.a(this.mContext, (Integer)localObject);
    if ((localObject != null) && (((p)localObject).ejH.equals(aop())))
    {
      AppMethodBeat.o(140402);
      return localObject;
    }
    AppMethodBeat.o(140402);
    return null;
  }
  
  final Class<? extends com.tencent.luggage.webview.a> aop()
  {
    if (this.ejp == null) {
      if (this.eji != null) {
        break label28;
      }
    }
    label28:
    for (Object localObject = com.tencent.luggage.webview.default_impl.a.class;; localObject = this.eji)
    {
      this.ejp = ((Class)localObject);
      return this.ejp;
    }
  }
  
  protected void aoq() {}
  
  protected void aor() {}
  
  protected void aos() {}
  
  protected void aot() {}
  
  protected boolean aou()
  {
    return true;
  }
  
  public final boolean cH(boolean paramBoolean)
  {
    AppMethodBeat.i(140397);
    if (this.ejk.size() <= 1)
    {
      AppMethodBeat.o(140397);
      return false;
    }
    final h localh = (h)this.ejk.pop();
    if (paramBoolean)
    {
      localh.j(new Runnable()
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
      ((h)this.ejk.peek()).i(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(140378);
          ((h)i.this.ejk.peek()).aoh();
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
      ((h)this.ejk.peek()).aoh();
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(140392);
    Object localObject = this.ejk.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((h)((Iterator)localObject).next()).destroy();
    }
    localObject = aoo();
    if (localObject != null) {
      ((p)localObject).destroy();
    }
    com.tencent.luggage.l.e.bu(this.mContext);
    AppMethodBeat.o(140392);
  }
  
  public final boolean eD(String paramString)
  {
    AppMethodBeat.i(140393);
    boolean bool = m(paramString, null);
    AppMethodBeat.o(140393);
    return bool;
  }
  
  public final boolean m(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(140394);
    if (!this.ejk.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      bool = a(paramString, paramBundle, bool);
      AppMethodBeat.o(140394);
      return bool;
    }
  }
  
  public final boolean n(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(140399);
    if (this.ejk.size() == 0) {}
    for (h localh = null;; localh = (h)this.ejk.pop())
    {
      if (localh != null) {
        a(localh);
      }
      boolean bool = a(paramString, paramBundle, false);
      AppMethodBeat.o(140399);
      return bool;
    }
  }
  
  public final boolean o(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(174615);
    final h localh = this.ejn.p(paramString, paramBundle);
    if (localh == null)
    {
      Log.e("LuggagePageContainer", "No page specified for url %s", new Object[] { paramString });
      AppMethodBeat.o(174615);
      return false;
    }
    localh.l(paramString, paramBundle);
    d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(140379);
        if (((Activity)i.this.mContext).isFinishing())
        {
          AppMethodBeat.o(140379);
          return;
        }
        if (i.this.ejk.size() == 0) {}
        for (h localh = null;; localh = (h)i.this.ejk.pop())
        {
          if (localh != null) {
            i.a(i.this, localh);
          }
          i.this.ejk.push(localh);
          i.this.ejj.addView(localh.getContentView());
          localh.aoh();
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
    h localh = aol();
    if (localh == null)
    {
      AppMethodBeat.o(140405);
      return;
    }
    localh.aoh();
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
    if ((this.ejk.size() <= 1) || (this.ejk.size() <= paramInt))
    {
      AppMethodBeat.o(140398);
      return false;
    }
    if (paramInt == 0)
    {
      boolean bool = cH(false);
      AppMethodBeat.o(140398);
      return bool;
    }
    a((h)this.ejk.remove(paramInt));
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
      i.this.aoq();
      AppMethodBeat.o(140389);
    }
    
    public final boolean add(E paramE)
    {
      AppMethodBeat.i(140388);
      boolean bool = super.add(paramE);
      if (bool) {
        i.this.aoq();
      }
      AppMethodBeat.o(140388);
      return bool;
    }
    
    public final E pop()
    {
      AppMethodBeat.i(140386);
      Object localObject = super.pop();
      i.this.aor();
      AppMethodBeat.o(140386);
      return localObject;
    }
    
    public final void push(E paramE)
    {
      AppMethodBeat.i(140387);
      super.push(paramE);
      i.this.aoq();
      AppMethodBeat.o(140387);
    }
    
    public final E remove(int paramInt)
    {
      AppMethodBeat.i(140385);
      Object localObject = super.remove(paramInt);
      i.this.aor();
      AppMethodBeat.o(140385);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.d.i
 * JD-Core Version:    0.7.0.1
 */