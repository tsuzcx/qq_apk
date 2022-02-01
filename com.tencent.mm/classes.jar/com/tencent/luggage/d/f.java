package com.tencent.luggage.d;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;

public class f
  implements h
{
  protected Class<? extends com.tencent.luggage.webview.a> cad;
  public FrameLayout cae;
  public a<e> caf;
  protected d cag;
  com.tencent.luggage.h.e cah;
  public j cai;
  Integer caj;
  private Class<? extends com.tencent.luggage.webview.a> cak;
  public g cal;
  protected Context mContext;
  
  public f(Activity paramActivity)
  {
    AppMethodBeat.i(140390);
    this.caf = new a((byte)0);
    this.caj = null;
    this.cak = null;
    this.cal = new g()
    {
      public final k AW()
      {
        AppMethodBeat.i(174614);
        k localk = f.a(f.this);
        AppMethodBeat.o(174614);
        return localk;
      }
      
      final Class<? extends com.tencent.luggage.webview.a> AX()
      {
        AppMethodBeat.i(174612);
        Class localClass = f.this.AX();
        AppMethodBeat.o(174612);
        return localClass;
      }
      
      public final LinkedList<e> Ba()
      {
        return f.this.caf;
      }
      
      public final h Bb()
      {
        return f.this;
      }
      
      public final LinkedList<Class<? extends a>> Bc()
      {
        AppMethodBeat.i(174613);
        LinkedList localLinkedList = (LinkedList)f.this.cag.bZX.clone();
        AppMethodBeat.o(174613);
        return localLinkedList;
      }
      
      public final com.tencent.luggage.h.e Bd()
      {
        return f.this.cah;
      }
      
      final Context getContext()
      {
        return f.this.mContext;
      }
    };
    this.mContext = paramActivity;
    FrameLayout localFrameLayout = new FrameLayout(this.mContext);
    localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    localFrameLayout.setBackgroundColor(-1);
    this.cae = localFrameLayout;
    this.cag = new d();
    a(null);
    this.cah = com.tencent.luggage.h.e.az(paramActivity);
    AppMethodBeat.o(140390);
  }
  
  private k AW()
  {
    AppMethodBeat.i(140402);
    Object localObject = this.caj;
    this.caj = null;
    localObject = m.a(this.mContext, (Integer)localObject);
    if ((localObject != null) && (((k)localObject).cat.equals(AX())))
    {
      AppMethodBeat.o(140402);
      return localObject;
    }
    AppMethodBeat.o(140402);
    return null;
  }
  
  private void c(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(140403);
    this.cae.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(140403);
  }
  
  public final e AT()
  {
    AppMethodBeat.i(140391);
    if (this.caf.size() > 0)
    {
      e locale = (e)this.caf.peek();
      AppMethodBeat.o(140391);
      return locale;
    }
    AppMethodBeat.o(140391);
    return null;
  }
  
  public final boolean AU()
  {
    AppMethodBeat.i(140396);
    boolean bool = bp(true);
    AppMethodBeat.o(140396);
    return bool;
  }
  
  public final void AV()
  {
    AppMethodBeat.i(140401);
    if (this.caj != null)
    {
      AppMethodBeat.o(140401);
      return;
    }
    c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(174610);
        if (!((Activity)f.this.mContext).isFinishing()) {
          f.this.caj = m.b(f.this.mContext.getApplicationContext(), f.this.AX());
        }
        AppMethodBeat.o(174610);
      }
    }, 200L);
    AppMethodBeat.o(140401);
  }
  
  final Class<? extends com.tencent.luggage.webview.a> AX()
  {
    if (this.cak == null) {
      if (this.cad != null) {
        break label27;
      }
    }
    label27:
    for (Object localObject = com.tencent.luggage.webview.default_impl.a.class;; localObject = this.cad)
    {
      this.cak = ((Class)localObject);
      return this.cak;
    }
  }
  
  protected void AY() {}
  
  protected void AZ() {}
  
  final void a(final e parame)
  {
    AppMethodBeat.i(140400);
    this.cae.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(140380);
        f.this.cae.removeView(parame.getContentView());
        AppMethodBeat.o(140380);
      }
    });
    parame.destroy();
    AppMethodBeat.o(140400);
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(140404);
    Object localObject = paramj;
    if (paramj == null) {
      localObject = new j()
      {
        public final e k(String paramAnonymousString, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(174611);
          paramAnonymousString = new n(f.this.cal, paramAnonymousBundle);
          AppMethodBeat.o(174611);
          return paramAnonymousString;
        }
      };
    }
    this.cai = ((j)localObject);
    AppMethodBeat.o(140404);
  }
  
  public final boolean a(String paramString, Bundle paramBundle, final boolean paramBoolean)
  {
    AppMethodBeat.i(140395);
    final e locale = this.cai.k(paramString, paramBundle);
    this.cae.addView(locale.getContentView(), 0);
    locale.getContentView().setVisibility(4);
    final Runnable local1 = new Runnable()
    {
      boolean done = false;
      
      public final void run()
      {
        AppMethodBeat.i(140375);
        if (this.done)
        {
          AppMethodBeat.o(140375);
          return;
        }
        this.done = true;
        Object localObject2;
        ObjectAnimator localObjectAnimator;
        Object localObject3;
        if ((f.this.caf.peek() != null) && (paramBoolean))
        {
          localObject1 = (e)f.this.caf.peek();
          localObject2 = ObjectAnimator.ofFloat(((e)localObject1).getContentView(), "translationX", new float[] { 0.0F, -(((e)localObject1).getContentView().getWidth() * 0.25F) });
          ((ObjectAnimator)localObject2).setDuration(250L);
          localObjectAnimator = ObjectAnimator.ofFloat(((e)localObject1).getContentView(), "translationX", new float[] { 0.0F });
          localObjectAnimator.setDuration(0L);
          localObject3 = new AnimatorSet();
          ((AnimatorSet)localObject3).playSequentially(new Animator[] { localObject2, localObjectAnimator });
          ((e)localObject1).a((Animator)localObject3, null);
          ((e)f.this.caf.peek()).AQ();
        }
        locale.getContentView().bringToFront();
        locale.getContentView().setVisibility(0);
        locale.AP();
        Object localObject1 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(140374);
            f.this.caf.push(f.1.this.can);
            f.this.AV();
            AppMethodBeat.o(140374);
          }
        };
        if (paramBoolean)
        {
          localObject2 = locale;
          localObjectAnimator = ObjectAnimator.ofFloat(((e)localObject2).getContentView(), "translationX", new float[] { ((e)localObject2).getContentView().getWidth(), 0.0F });
          localObjectAnimator.setDuration(250L);
          localObject3 = ObjectAnimator.ofFloat(((e)localObject2).getContentView(), "alpha", new float[] { 0.0F, 1.0F });
          ((ObjectAnimator)localObject3).setDuration(166L);
          AnimatorSet localAnimatorSet = new AnimatorSet();
          localAnimatorSet.playTogether(new Animator[] { localObjectAnimator, localObject3 });
          ((e)localObject2).a(localAnimatorSet, (Runnable)localObject1);
          AppMethodBeat.o(140375);
          return;
        }
        ((Runnable)localObject1).run();
        AppMethodBeat.o(140375);
      }
    };
    locale.bZY.a(new i.e()
    {
      public final void onReady()
      {
        AppMethodBeat.i(140376);
        local1.run();
        AppMethodBeat.o(140376);
      }
    });
    locale.g(paramString, paramBundle);
    c(local1, 300L);
    if (!paramBoolean) {
      local1.run();
    }
    AppMethodBeat.o(140395);
    return true;
  }
  
  public final boolean bS(String paramString)
  {
    AppMethodBeat.i(140393);
    boolean bool = h(paramString, null);
    AppMethodBeat.o(140393);
    return bool;
  }
  
  public final boolean bp(boolean paramBoolean)
  {
    AppMethodBeat.i(140397);
    if (this.caf.size() <= 1)
    {
      AppMethodBeat.o(140397);
      return false;
    }
    final e locale = (e)this.caf.pop();
    if (paramBoolean)
    {
      locale.i(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(140377);
          f.this.a(locale);
          AppMethodBeat.o(140377);
        }
      });
      if (!paramBoolean) {
        break label91;
      }
      ((e)this.caf.peek()).h(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(140378);
          ((e)f.this.caf.peek()).AP();
          AppMethodBeat.o(140378);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(140397);
      return true;
      a(locale);
      break;
      label91:
      ((e)this.caf.peek()).AP();
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(140392);
    Object localObject = this.caf.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((e)((Iterator)localObject).next()).destroy();
    }
    localObject = AW();
    if (localObject != null) {
      ((k)localObject).destroy();
    }
    com.tencent.luggage.h.e.aA(this.mContext);
    AppMethodBeat.o(140392);
  }
  
  public final boolean h(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(140394);
    if (!this.caf.isEmpty()) {}
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
    if (this.caf.size() == 0) {}
    for (e locale = null;; locale = (e)this.caf.pop())
    {
      if (locale != null) {
        a(locale);
      }
      boolean bool = a(paramString, paramBundle, false);
      AppMethodBeat.o(140399);
      return bool;
    }
  }
  
  public final boolean j(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(174615);
    final e locale = this.cai.k(paramString, paramBundle);
    locale.g(paramString, paramBundle);
    c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(140379);
        if (((Activity)f.this.mContext).isFinishing())
        {
          AppMethodBeat.o(140379);
          return;
        }
        if (f.this.caf.size() == 0) {}
        for (e locale = null;; locale = (e)f.this.caf.pop())
        {
          if (locale != null) {
            f.this.a(locale);
          }
          f.this.caf.push(locale);
          f.this.cae.addView(locale.getContentView());
          locale.AP();
          AppMethodBeat.o(140379);
          return;
        }
      }
    }, 500L);
    AppMethodBeat.o(174615);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(140408);
    this.cah.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(140408);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(140407);
    e locale = AT();
    if (locale == null)
    {
      AppMethodBeat.o(140407);
      return false;
    }
    if (locale.AR())
    {
      AppMethodBeat.o(140407);
      return true;
    }
    if (this.caf.size() > 1)
    {
      bp(true);
      AppMethodBeat.o(140407);
      return true;
    }
    AppMethodBeat.o(140407);
    return false;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(140406);
    e locale = AT();
    if (locale == null)
    {
      AppMethodBeat.o(140406);
      return;
    }
    locale.AQ();
    AppMethodBeat.o(140406);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(140405);
    e locale = AT();
    if (locale == null)
    {
      AppMethodBeat.o(140405);
      return;
    }
    locale.AP();
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
    if ((this.caf.size() <= 1) || (this.caf.size() <= paramInt))
    {
      AppMethodBeat.o(140398);
      return false;
    }
    if (paramInt == 0)
    {
      boolean bool = bp(false);
      AppMethodBeat.o(140398);
      return bool;
    }
    a((e)this.caf.remove(paramInt));
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
      f.this.AY();
      AppMethodBeat.o(140389);
    }
    
    public final boolean add(E paramE)
    {
      AppMethodBeat.i(140388);
      boolean bool = super.add(paramE);
      if (bool) {
        f.this.AY();
      }
      AppMethodBeat.o(140388);
      return bool;
    }
    
    public final E pop()
    {
      AppMethodBeat.i(140386);
      Object localObject = super.pop();
      f.this.AZ();
      AppMethodBeat.o(140386);
      return localObject;
    }
    
    public final void push(E paramE)
    {
      AppMethodBeat.i(140387);
      super.push(paramE);
      f.this.AY();
      AppMethodBeat.o(140387);
    }
    
    public final E remove(int paramInt)
    {
      AppMethodBeat.i(140385);
      Object localObject = super.remove(paramInt);
      f.this.AZ();
      AppMethodBeat.o(140385);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.d.f
 * JD-Core Version:    0.7.0.1
 */