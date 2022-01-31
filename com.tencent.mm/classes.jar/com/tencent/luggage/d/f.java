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

public class f
  implements h
{
  protected Class<? extends com.tencent.luggage.webview.a> byN;
  public FrameLayout byO;
  public f.a<e> byP;
  protected d byQ;
  com.tencent.luggage.g.e byR;
  public j byS;
  Integer byT;
  private Class<? extends com.tencent.luggage.webview.a> byU;
  public g byV;
  protected Context mContext;
  
  public f(Activity paramActivity)
  {
    AppMethodBeat.i(90789);
    this.byP = new f.a(this, (byte)0);
    this.byT = null;
    this.byU = null;
    this.byV = new f.8(this);
    this.mContext = paramActivity;
    FrameLayout localFrameLayout = new FrameLayout(this.mContext);
    localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    localFrameLayout.setBackgroundColor(-1);
    this.byO = localFrameLayout;
    this.byQ = new d();
    a(null);
    this.byR = com.tencent.luggage.g.e.at(paramActivity);
    AppMethodBeat.o(90789);
  }
  
  private void d(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(90802);
    this.byO.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(90802);
  }
  
  private k ui()
  {
    AppMethodBeat.i(90801);
    Object localObject = this.byT;
    this.byT = null;
    localObject = m.a(this.mContext, (Integer)localObject);
    if ((localObject != null) && (((k)localObject).bzd.equals(uj())))
    {
      AppMethodBeat.o(90801);
      return localObject;
    }
    AppMethodBeat.o(90801);
    return null;
  }
  
  final void a(e parame)
  {
    AppMethodBeat.i(90799);
    this.byO.post(new f.5(this, parame));
    parame.destroy();
    AppMethodBeat.o(90799);
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(90803);
    Object localObject = paramj;
    if (paramj == null) {
      localObject = new f.7(this);
    }
    this.byS = ((j)localObject);
    AppMethodBeat.o(90803);
  }
  
  public final boolean a(String paramString, Bundle paramBundle, final boolean paramBoolean)
  {
    AppMethodBeat.i(90794);
    final e locale = this.byS.j(paramString, paramBundle);
    this.byO.addView(locale.getContentView(), 0);
    locale.getContentView().setVisibility(4);
    Runnable local1 = new Runnable()
    {
      boolean done = false;
      
      public final void run()
      {
        AppMethodBeat.i(90774);
        if (this.done)
        {
          AppMethodBeat.o(90774);
          return;
        }
        this.done = true;
        Object localObject2;
        ObjectAnimator localObjectAnimator;
        Object localObject3;
        if ((f.this.byP.peek() != null) && (paramBoolean))
        {
          localObject1 = (e)f.this.byP.peek();
          localObject2 = ObjectAnimator.ofFloat(((e)localObject1).getContentView(), "translationX", new float[] { 0.0F, -(((e)localObject1).getContentView().getWidth() * 0.25F) });
          ((ObjectAnimator)localObject2).setDuration(250L);
          localObjectAnimator = ObjectAnimator.ofFloat(((e)localObject1).getContentView(), "translationX", new float[] { 0.0F });
          localObjectAnimator.setDuration(0L);
          localObject3 = new AnimatorSet();
          ((AnimatorSet)localObject3).playSequentially(new Animator[] { localObject2, localObjectAnimator });
          ((e)localObject1).a((Animator)localObject3, null);
          ((e)f.this.byP.peek()).uc();
        }
        locale.getContentView().bringToFront();
        locale.getContentView().setVisibility(0);
        locale.ub();
        Object localObject1 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(90773);
            f.this.byP.push(f.1.this.byX);
            f.this.uh();
            AppMethodBeat.o(90773);
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
          AppMethodBeat.o(90774);
          return;
        }
        ((Runnable)localObject1).run();
        AppMethodBeat.o(90774);
      }
    };
    locale.byI.a(new f.2(this, local1));
    locale.g(paramString, paramBundle);
    d(local1, 300L);
    if (!paramBoolean) {
      local1.run();
    }
    AppMethodBeat.o(90794);
    return true;
  }
  
  public final boolean aY(boolean paramBoolean)
  {
    AppMethodBeat.i(90796);
    if (this.byP.size() <= 1)
    {
      AppMethodBeat.o(90796);
      return false;
    }
    e locale = (e)this.byP.pop();
    if (paramBoolean)
    {
      locale.g(new f.3(this, locale));
      if (!paramBoolean) {
        break label91;
      }
      ((e)this.byP.peek()).f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(90777);
          ((e)f.this.byP.peek()).ub();
          AppMethodBeat.o(90777);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(90796);
      return true;
      a(locale);
      break;
      label91:
      ((e)this.byP.peek()).ub();
    }
  }
  
  public final boolean bC(String paramString)
  {
    AppMethodBeat.i(90792);
    boolean bool = h(paramString, null);
    AppMethodBeat.o(90792);
    return bool;
  }
  
  public final boolean bu(int paramInt)
  {
    AppMethodBeat.i(90797);
    if (paramInt < 0)
    {
      AppMethodBeat.o(90797);
      return true;
    }
    if ((this.byP.size() <= 1) || (this.byP.size() <= paramInt))
    {
      AppMethodBeat.o(90797);
      return false;
    }
    if (paramInt == 0)
    {
      boolean bool = aY(false);
      AppMethodBeat.o(90797);
      return bool;
    }
    a((e)this.byP.remove(paramInt));
    AppMethodBeat.o(90797);
    return true;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(90791);
    Object localObject = this.byP.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((e)((Iterator)localObject).next()).destroy();
    }
    localObject = ui();
    if (localObject != null) {
      ((k)localObject).destroy();
    }
    com.tencent.luggage.g.e.au(this.mContext);
    AppMethodBeat.o(90791);
  }
  
  public final boolean h(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(90793);
    if (!this.byP.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      bool = a(paramString, paramBundle, bool);
      AppMethodBeat.o(90793);
      return bool;
    }
  }
  
  public final boolean i(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(90798);
    if (this.byP.size() == 0) {}
    for (e locale = null;; locale = (e)this.byP.pop())
    {
      if (locale != null) {
        a(locale);
      }
      boolean bool = a(paramString, paramBundle, false);
      AppMethodBeat.o(90798);
      return bool;
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(90807);
    this.byR.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(90807);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(90806);
    e locale = uf();
    if (locale == null)
    {
      AppMethodBeat.o(90806);
      return false;
    }
    if (locale.ud())
    {
      AppMethodBeat.o(90806);
      return true;
    }
    if (this.byP.size() > 1)
    {
      aY(true);
      AppMethodBeat.o(90806);
      return true;
    }
    AppMethodBeat.o(90806);
    return false;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(90805);
    e locale = uf();
    if (locale == null)
    {
      AppMethodBeat.o(90805);
      return;
    }
    locale.uc();
    AppMethodBeat.o(90805);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(90804);
    e locale = uf();
    if (locale == null)
    {
      AppMethodBeat.o(90804);
      return;
    }
    locale.ub();
    AppMethodBeat.o(90804);
  }
  
  public final e uf()
  {
    AppMethodBeat.i(90790);
    if (this.byP.size() > 0)
    {
      e locale = (e)this.byP.peek();
      AppMethodBeat.o(90790);
      return locale;
    }
    AppMethodBeat.o(90790);
    return null;
  }
  
  public final boolean ug()
  {
    AppMethodBeat.i(90795);
    boolean bool = aY(true);
    AppMethodBeat.o(90795);
    return bool;
  }
  
  public final void uh()
  {
    AppMethodBeat.i(90800);
    if (this.byT != null)
    {
      AppMethodBeat.o(90800);
      return;
    }
    d(new f.6(this), 200L);
    AppMethodBeat.o(90800);
  }
  
  final Class<? extends com.tencent.luggage.webview.a> uj()
  {
    if (this.byU == null) {
      if (this.byN != null) {
        break label28;
      }
    }
    label28:
    for (Object localObject = com.tencent.luggage.webview.default_impl.a.class;; localObject = this.byN)
    {
      this.byU = ((Class)localObject);
      return this.byU;
    }
  }
  
  protected void uk() {}
  
  protected void ul() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.d.f
 * JD-Core Version:    0.7.0.1
 */