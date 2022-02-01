package com.tencent.mm.plugin.appbrand.platform.window;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class a
  implements d
{
  protected c jDa;
  protected boolean mtA = false;
  private final d.b mtr = new d.b()
  {
    public final ViewGroup cI(View paramAnonymousView)
    {
      AppMethodBeat.i(207967);
      Activity localActivity = null;
      if ((a.this.jDa instanceof o)) {
        localActivity = com.tencent.mm.sdk.f.a.jw(((o)a.this.jDa).mContext);
      }
      if (localActivity == null)
      {
        paramAnonymousView = (ViewGroup)paramAnonymousView.getRootView();
        AppMethodBeat.o(207967);
        return paramAnonymousView;
      }
      paramAnonymousView = (ViewGroup)localActivity.getWindow().getDecorView();
      AppMethodBeat.o(207967);
      return paramAnonymousView;
    }
  };
  private d.b mts;
  private View mtt;
  private WebChromeClient.CustomViewCallback mtu;
  private int mtv;
  private ViewGroup.LayoutParams mtw;
  private ViewGroup mtx;
  private final Set<b> mty = Collections.newSetFromMap(new ConcurrentHashMap());
  protected View mtz;
  
  public a(c paramc, d.b paramb)
  {
    this.mts = paramb;
    this.jDa = paramc;
  }
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public void O(View paramView, int paramInt)
  {
    this.mtA = true;
    Object localObject = this.mts;
    if (localObject == null) {
      localObject = this.mtr;
    }
    for (;;)
    {
      this.mtz = this.mtt;
      this.mtt = paramView;
      if (this.mtz == null)
      {
        if (!(paramView.getParent() instanceof ViewGroup)) {
          break label126;
        }
        this.mtx = ((ViewGroup)paramView.getParent());
        this.mtv = this.mtx.indexOfChild(paramView);
        this.mtw = paramView.getLayoutParams();
        this.mtx.removeView(paramView);
      }
      for (;;)
      {
        localObject = ((d.b)localObject).cI(paramView);
        ((ViewGroup)localObject).addView(paramView, new ViewGroup.LayoutParams(-1, -1));
        ((ViewGroup)localObject).bringChildToFront(paramView);
        paramView.setX(0.0F);
        paramView.setY(0.0F);
        return;
        label126:
        this.mtv = 0;
        this.mtx = null;
        this.mtw = null;
      }
    }
  }
  
  public final void a(WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.mtu = paramCustomViewCallback;
  }
  
  public final void a(b paramb)
  {
    if (paramb == null) {
      return;
    }
    this.mty.add(paramb);
  }
  
  public boolean aYo()
  {
    if (this.mtt == null) {
      return false;
    }
    if (this.mtu != null) {
      this.mtu.onCustomViewHidden();
    }
    if ((this.mtt.getParent() instanceof ViewGroup)) {
      ((ViewGroup)this.mtt.getParent()).removeView(this.mtt);
    }
    if (this.mtx != null) {
      this.mtx.addView(this.mtt, this.mtv, this.mtw);
    }
    this.mtt = null;
    this.mtu = null;
    this.mtA = false;
    return true;
  }
  
  public final void b(b paramb)
  {
    this.mty.remove(paramb);
  }
  
  protected final void bxA()
  {
    Iterator localIterator = this.mty.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).bib();
    }
  }
  
  protected final void bxB()
  {
    Iterator localIterator = this.mty.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).DD();
    }
  }
  
  public final boolean bxz()
  {
    return this.mtA;
  }
  
  public void release()
  {
    aYo();
    this.mty.clear();
    this.mtu = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.a
 * JD-Core Version:    0.7.0.1
 */