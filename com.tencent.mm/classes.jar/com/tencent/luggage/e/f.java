package com.tencent.luggage.e;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class f
  implements h
{
  public Class<? extends com.tencent.luggage.webview.a> bip;
  public FrameLayout biq;
  f.a<e> bir = new f.a(this, (byte)0);
  public d bis;
  public com.tencent.luggage.j.d bit;
  private j biu;
  Integer biv = null;
  private Class<? extends com.tencent.luggage.webview.a> biw = null;
  public g bix = new f.8(this);
  public Context mContext;
  
  public f(Activity paramActivity)
  {
    this.mContext = paramActivity;
    FrameLayout localFrameLayout = new FrameLayout(this.mContext);
    localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.biq = localFrameLayout;
    this.bis = new d();
    a(null);
    this.bit = com.tencent.luggage.j.d.ad(paramActivity);
  }
  
  final void a(e parame)
  {
    this.biq.post(new f.5(this, parame));
    parame.destroy();
  }
  
  public final void a(j paramj)
  {
    Object localObject = paramj;
    if (paramj == null) {
      localObject = new f.7(this);
    }
    this.biu = ((j)localObject);
  }
  
  public final boolean a(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    e locale = this.biu.f(paramString, paramBundle);
    this.biq.addView(locale.getContentView(), 0);
    locale.getContentView().setVisibility(4);
    f.1 local1 = new f.1(this, paramBoolean, locale);
    i locali = locale.bik;
    f.2 local2 = new f.2(this, local1);
    locali.biD.put(local2, Boolean.valueOf(true));
    locale.c(paramString, paramBundle);
    c(local1, 300L);
    if (!paramBoolean) {
      local1.run();
    }
    return true;
  }
  
  public final boolean aJ(boolean paramBoolean)
  {
    if (this.bir.size() <= 1) {
      return false;
    }
    e locale = (e)this.bir.pop();
    if (paramBoolean)
    {
      Object localObject = new f.3(this, locale);
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(locale.getContentView(), "translationX", new float[] { 0.0F, locale.getContentView().getWidth() });
      localObjectAnimator.setDuration(250L);
      locale.a(localObjectAnimator, (Runnable)localObject);
      if (!paramBoolean) {
        break label166;
      }
      locale = (e)this.bir.peek();
      localObject = new f.4(this);
      localObjectAnimator = ObjectAnimator.ofFloat(locale.getContentView(), "translationX", new float[] { -(locale.getContentView().getWidth() * 0.25F), 0.0F });
      localObjectAnimator.setDuration(250L);
      locale.a(localObjectAnimator, (Runnable)localObject);
    }
    for (;;)
    {
      return true;
      a(locale);
      break;
      label166:
      ((e)this.bir.peek()).pX();
    }
  }
  
  public final boolean bb(String paramString)
  {
    return d(paramString, null);
  }
  
  public final boolean bu(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramInt < 0) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this.bir.size() <= 1);
      bool1 = bool2;
    } while (this.bir.size() <= paramInt);
    if (this.bir.size() - 1 == paramInt) {
      return aJ(false);
    }
    a((e)this.bir.remove(paramInt));
    return true;
  }
  
  final void c(Runnable paramRunnable, long paramLong)
  {
    this.biq.postDelayed(paramRunnable, paramLong);
  }
  
  public final boolean d(String paramString, Bundle paramBundle)
  {
    if (!this.bir.isEmpty()) {}
    for (boolean bool = true;; bool = false) {
      return a(paramString, paramBundle, bool);
    }
  }
  
  public final void destroy()
  {
    Object localObject = this.bir.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((e)((Iterator)localObject).next()).destroy();
    }
    localObject = qf();
    if (localObject != null) {
      ((k)localObject).destroy();
    }
    com.tencent.luggage.j.d.ae(this.mContext);
  }
  
  public final boolean e(String paramString, Bundle paramBundle)
  {
    if (this.bir.size() == 0) {}
    for (e locale = null;; locale = (e)this.bir.pop())
    {
      if (locale != null) {
        a(locale);
      }
      return a(paramString, paramBundle, false);
    }
  }
  
  public final void onPause()
  {
    e locale = qd();
    if (locale == null) {
      return;
    }
    locale.pZ();
  }
  
  public void onResume()
  {
    e locale = qd();
    if (locale == null) {
      return;
    }
    locale.pX();
  }
  
  public final boolean qc()
  {
    e locale = qd();
    if (locale == null) {}
    do
    {
      return false;
      if (locale.qb()) {
        return true;
      }
    } while (this.bir.size() <= 1);
    aJ(true);
    return true;
  }
  
  public final e qd()
  {
    if (this.bir.size() > 0) {
      return (e)this.bir.peek();
    }
    return null;
  }
  
  public final boolean qe()
  {
    return aJ(true);
  }
  
  final k qf()
  {
    Object localObject = this.biv;
    this.biv = null;
    localObject = m.a(this.mContext, (Integer)localObject);
    if ((localObject != null) && (((k)localObject).biF.equals(qg()))) {
      return localObject;
    }
    return null;
  }
  
  final Class<? extends com.tencent.luggage.webview.a> qg()
  {
    if (this.biw == null) {
      if (this.bip != null) {
        break label28;
      }
    }
    label28:
    for (Object localObject = com.tencent.luggage.webview.default_impl.a.class;; localObject = this.bip)
    {
      this.biw = ((Class)localObject);
      return this.biw;
    }
  }
  
  public void qh() {}
  
  public void qi() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.e.f
 * JD-Core Version:    0.7.0.1
 */