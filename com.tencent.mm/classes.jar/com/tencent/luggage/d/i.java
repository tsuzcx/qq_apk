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
import com.tencent.luggage.k.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public class i
  implements k
{
  private Class<? extends com.tencent.luggage.webview.a> crq;
  public FrameLayout crr;
  public a<h> crs;
  protected e crt;
  public f cru;
  public m crv;
  Integer crw;
  private Class<? extends com.tencent.luggage.webview.a> crx;
  public j cry;
  protected Context mContext;
  
  public i(Activity paramActivity)
  {
    AppMethodBeat.i(140390);
    this.crs = new a((byte)0);
    this.crw = null;
    this.crx = null;
    this.cry = new j()
    {
      public final p Og()
      {
        AppMethodBeat.i(174614);
        p localp = i.this.Og();
        AppMethodBeat.o(174614);
        return localp;
      }
      
      final Class<? extends com.tencent.luggage.webview.a> Oh()
      {
        AppMethodBeat.i(174612);
        Class localClass = i.this.Oh();
        AppMethodBeat.o(174612);
        return localClass;
      }
      
      public final LinkedList<h> On()
      {
        return i.this.crs;
      }
      
      public final k Oo()
      {
        return i.this;
      }
      
      public final LinkedList<Class<? extends b>> Op()
      {
        AppMethodBeat.i(174613);
        LinkedList localLinkedList = (LinkedList)i.this.crt.crj.clone();
        AppMethodBeat.o(174613);
        return localLinkedList;
      }
      
      public final f Oq()
      {
        return i.this.cru;
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
    this.crr = localFrameLayout;
    this.crt = new e();
    a(null);
    this.cru = f.aI(paramActivity);
    AppMethodBeat.o(140390);
  }
  
  private void a(final h paramh)
  {
    AppMethodBeat.i(140400);
    this.crr.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(140380);
        i.this.crr.removeView(paramh.getContentView());
        AppMethodBeat.o(140380);
      }
    });
    paramh.destroy();
    AppMethodBeat.o(140400);
  }
  
  private void c(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(140403);
    this.crr.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(140403);
  }
  
  public final void O(Class<? extends com.tencent.luggage.webview.a> paramClass)
  {
    this.crq = paramClass;
  }
  
  public final j Oc()
  {
    return this.cry;
  }
  
  public final h Od()
  {
    AppMethodBeat.i(140391);
    if (this.crs.size() > 0)
    {
      h localh = (h)this.crs.peek();
      AppMethodBeat.o(140391);
      return localh;
    }
    AppMethodBeat.o(140391);
    return null;
  }
  
  public final boolean Oe()
  {
    AppMethodBeat.i(140396);
    boolean bool = cb(true);
    AppMethodBeat.o(140396);
    return bool;
  }
  
  public final void Of()
  {
    AppMethodBeat.i(140401);
    if (this.crw != null)
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
          i.this.crw = r.b(i.this.mContext.getApplicationContext(), i.this.Oh());
        }
        AppMethodBeat.o(174610);
      }
    }, 200L);
    AppMethodBeat.o(140401);
  }
  
  final p Og()
  {
    AppMethodBeat.i(140402);
    Object localObject = this.crw;
    this.crw = null;
    localObject = r.a(this.mContext, (Integer)localObject);
    if ((localObject != null) && (((p)localObject).crN.equals(Oh())))
    {
      AppMethodBeat.o(140402);
      return localObject;
    }
    AppMethodBeat.o(140402);
    return null;
  }
  
  final Class<? extends com.tencent.luggage.webview.a> Oh()
  {
    if (this.crx == null) {
      if (this.crq != null) {
        break label27;
      }
    }
    label27:
    for (Object localObject = com.tencent.luggage.webview.default_impl.a.class;; localObject = this.crq)
    {
      this.crx = ((Class)localObject);
      return this.crx;
    }
  }
  
  protected void Oi() {}
  
  protected void Oj() {}
  
  protected void Ok() {}
  
  protected void Ol() {}
  
  protected boolean Om()
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
        public final h p(String paramAnonymousString, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(174611);
          paramAnonymousString = new s(i.this.cry, paramAnonymousBundle);
          AppMethodBeat.o(174611);
          return paramAnonymousString;
        }
      };
    }
    this.crv = ((m)localObject);
    AppMethodBeat.o(140404);
  }
  
  public final boolean a(String paramString, Bundle paramBundle, final boolean paramBoolean)
  {
    AppMethodBeat.i(140395);
    final h localh = this.crv.p(paramString, paramBundle);
    if (localh == null)
    {
      Log.e("LuggagePageContainer", "No page specified for url %s", new Object[] { paramString });
      AppMethodBeat.o(140395);
      return false;
    }
    if (!Om())
    {
      Log.i("LuggagePageContainer", "Pushing page is banned");
      AppMethodBeat.o(140395);
      return false;
    }
    this.crr.addView(localh.getContentView(), 0);
    localh.getContentView().setVisibility(4);
    final Runnable local1 = new Runnable()
    {
      boolean done = false;
      
      public final void run()
      {
        AppMethodBeat.i(140375);
        i.this.Ol();
        if (this.done)
        {
          AppMethodBeat.o(140375);
          return;
        }
        this.done = true;
        Object localObject2;
        ObjectAnimator localObjectAnimator;
        Object localObject3;
        if ((i.this.crs.peek() != null) && (paramBoolean))
        {
          localObject1 = (h)i.this.crs.peek();
          localObject2 = ObjectAnimator.ofFloat(((h)localObject1).getContentView(), "translationX", new float[] { 0.0F, -(((h)localObject1).getContentView().getWidth() * 0.25F) });
          ((ObjectAnimator)localObject2).setDuration(250L);
          localObjectAnimator = ObjectAnimator.ofFloat(((h)localObject1).getContentView(), "translationX", new float[] { 0.0F });
          localObjectAnimator.setDuration(0L);
          localObject3 = new AnimatorSet();
          ((AnimatorSet)localObject3).playSequentially(new Animator[] { localObject2, localObjectAnimator });
          ((h)localObject1).a((Animator)localObject3, null);
          ((h)i.this.crs.peek()).NZ();
        }
        localh.getContentView().bringToFront();
        localh.getContentView().setVisibility(0);
        localh.NY();
        Object localObject1 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(140374);
            i.this.crs.push(i.1.this.crA);
            i.this.Of();
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
    localh.crl.a(new l.e()
    {
      public final void NR()
      {
        AppMethodBeat.i(140376);
        local1.run();
        AppMethodBeat.o(140376);
      }
    });
    Ok();
    localh.l(paramString, paramBundle);
    c(local1, 300L);
    if (!paramBoolean) {
      local1.run();
    }
    AppMethodBeat.o(140395);
    return true;
  }
  
  public final boolean cb(boolean paramBoolean)
  {
    AppMethodBeat.i(140397);
    if (this.crs.size() <= 1)
    {
      AppMethodBeat.o(140397);
      return false;
    }
    final h localh = (h)this.crs.pop();
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
      ((h)this.crs.peek()).g(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(140378);
          ((h)i.this.crs.peek()).NY();
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
      ((h)this.crs.peek()).NY();
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(140392);
    Object localObject = this.crs.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((h)((Iterator)localObject).next()).destroy();
    }
    localObject = Og();
    if (localObject != null) {
      ((p)localObject).destroy();
    }
    f.aJ(this.mContext);
    AppMethodBeat.o(140392);
  }
  
  public final boolean ds(String paramString)
  {
    AppMethodBeat.i(140393);
    boolean bool = m(paramString, null);
    AppMethodBeat.o(140393);
    return bool;
  }
  
  public final View getContentView()
  {
    return this.crr;
  }
  
  public final boolean m(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(140394);
    if (!this.crs.isEmpty()) {}
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
    if (this.crs.size() == 0) {}
    for (h localh = null;; localh = (h)this.crs.pop())
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
    final h localh = this.crv.p(paramString, paramBundle);
    if (localh == null)
    {
      Log.e("LuggagePageContainer", "No page specified for url %s", new Object[] { paramString });
      AppMethodBeat.o(174615);
      return false;
    }
    localh.l(paramString, paramBundle);
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
        if (i.this.crs.size() == 0) {}
        for (h localh = null;; localh = (h)i.this.crs.pop())
        {
          if (localh != null) {
            i.a(i.this, localh);
          }
          i.this.crs.push(localh);
          i.this.crr.addView(localh.getContentView());
          localh.NY();
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
    h localh = Od();
    if (localh == null)
    {
      AppMethodBeat.o(140405);
      return;
    }
    localh.NY();
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
    if ((this.crs.size() <= 1) || (this.crs.size() <= paramInt))
    {
      AppMethodBeat.o(140398);
      return false;
    }
    if (paramInt == 0)
    {
      boolean bool = cb(false);
      AppMethodBeat.o(140398);
      return bool;
    }
    a((h)this.crs.remove(paramInt));
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
      i.this.Oi();
      AppMethodBeat.o(140389);
    }
    
    public final boolean add(E paramE)
    {
      AppMethodBeat.i(140388);
      boolean bool = super.add(paramE);
      if (bool) {
        i.this.Oi();
      }
      AppMethodBeat.o(140388);
      return bool;
    }
    
    public final E pop()
    {
      AppMethodBeat.i(140386);
      Object localObject = super.pop();
      i.this.Oj();
      AppMethodBeat.o(140386);
      return localObject;
    }
    
    public final void push(E paramE)
    {
      AppMethodBeat.i(140387);
      super.push(paramE);
      i.this.Oi();
      AppMethodBeat.o(140387);
    }
    
    public final E remove(int paramInt)
    {
      AppMethodBeat.i(140385);
      Object localObject = super.remove(paramInt);
      i.this.Oj();
      AppMethodBeat.o(140385);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.d.i
 * JD-Core Version:    0.7.0.1
 */