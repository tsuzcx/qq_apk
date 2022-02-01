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
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class a
  implements d
{
  protected c nxr;
  private final d.b qGj = new d.b()
  {
    public final ViewGroup cU(View paramAnonymousView)
    {
      AppMethodBeat.i(245033);
      Activity localActivity = null;
      if ((a.this.nxr instanceof o)) {
        localActivity = AndroidContextUtil.castActivityOrNull(((o)a.this.nxr).mContext);
      }
      if (localActivity == null)
      {
        paramAnonymousView = (ViewGroup)paramAnonymousView.getRootView();
        AppMethodBeat.o(245033);
        return paramAnonymousView;
      }
      paramAnonymousView = (ViewGroup)localActivity.getWindow().getDecorView();
      AppMethodBeat.o(245033);
      return paramAnonymousView;
    }
  };
  private d.b qGk;
  private View qGl;
  private WebChromeClient.CustomViewCallback qGm;
  private int qGn;
  private ViewGroup.LayoutParams qGo;
  private ViewGroup qGp;
  private final Set<b> qGq = Collections.newSetFromMap(new ConcurrentHashMap());
  protected View qGr;
  protected boolean qGs = false;
  
  public a(c paramc, d.b paramb)
  {
    this.qGk = paramb;
    this.nxr = paramc;
  }
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public void O(View paramView, int paramInt)
  {
    this.qGs = true;
    Object localObject = this.qGk;
    if (localObject == null) {
      localObject = this.qGj;
    }
    for (;;)
    {
      this.qGr = this.qGl;
      this.qGl = paramView;
      if (this.qGr == null)
      {
        if (!(paramView.getParent() instanceof ViewGroup)) {
          break label126;
        }
        this.qGp = ((ViewGroup)paramView.getParent());
        this.qGn = this.qGp.indexOfChild(paramView);
        this.qGo = paramView.getLayoutParams();
        this.qGp.removeView(paramView);
      }
      for (;;)
      {
        localObject = ((d.b)localObject).cU(paramView);
        ((ViewGroup)localObject).addView(paramView, new ViewGroup.LayoutParams(-1, -1));
        ((ViewGroup)localObject).bringChildToFront(paramView);
        paramView.setX(0.0F);
        paramView.setY(0.0F);
        return;
        label126:
        this.qGn = 0;
        this.qGp = null;
        this.qGo = null;
      }
    }
  }
  
  public final void a(WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.qGm = paramCustomViewCallback;
  }
  
  public final void a(b paramb)
  {
    if (paramb == null) {
      return;
    }
    this.qGq.add(paramb);
  }
  
  public final void b(b paramb)
  {
    this.qGq.remove(paramb);
  }
  
  public boolean bEz()
  {
    if (this.qGl == null) {
      return false;
    }
    if (this.qGm != null) {
      this.qGm.onCustomViewHidden();
    }
    if ((this.qGl.getParent() instanceof ViewGroup)) {
      ((ViewGroup)this.qGl.getParent()).removeView(this.qGl);
    }
    if (this.qGp != null) {
      this.qGp.addView(this.qGl, this.qGn, this.qGo);
    }
    this.qGl = null;
    this.qGm = null;
    this.qGs = false;
    return true;
  }
  
  public final boolean cgP()
  {
    return this.qGs;
  }
  
  protected final void cgQ()
  {
    Iterator localIterator = this.qGq.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).bOO();
    }
  }
  
  protected final void cgR()
  {
    Iterator localIterator = this.qGq.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).PS();
    }
  }
  
  public void release()
  {
    bEz();
    this.qGq.clear();
    this.qGm = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.a
 * JD-Core Version:    0.7.0.1
 */