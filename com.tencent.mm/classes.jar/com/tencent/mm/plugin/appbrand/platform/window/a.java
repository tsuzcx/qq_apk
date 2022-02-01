package com.tencent.mm.plugin.appbrand.platform.window;

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
  protected c qwF;
  private final d.b tKV = new d.b()
  {
    public final ViewGroup dB(View paramAnonymousView)
    {
      AppMethodBeat.i(317495);
      Activity localActivity = null;
      if ((a.this.qwF instanceof o)) {
        localActivity = AndroidContextUtil.castActivityOrNull(((o)a.this.qwF).mContext);
      }
      if (localActivity == null)
      {
        paramAnonymousView = (ViewGroup)paramAnonymousView.getRootView();
        AppMethodBeat.o(317495);
        return paramAnonymousView;
      }
      paramAnonymousView = (ViewGroup)localActivity.getWindow().getDecorView();
      AppMethodBeat.o(317495);
      return paramAnonymousView;
    }
  };
  private d.b tKW;
  private View tKX;
  private WebChromeClient.CustomViewCallback tKY;
  private int tKZ;
  private ViewGroup.LayoutParams tLa;
  private ViewGroup tLb;
  private final Set<b> tLc = Collections.newSetFromMap(new ConcurrentHashMap());
  protected View tLd;
  protected boolean tLe = false;
  
  public a(c paramc, d.b paramb)
  {
    this.tKW = paramb;
    this.qwF = paramc;
  }
  
  public void T(View paramView, int paramInt)
  {
    this.tLe = true;
    Object localObject = this.tKW;
    if (localObject == null) {
      localObject = this.tKV;
    }
    for (;;)
    {
      this.tLd = this.tKX;
      this.tKX = paramView;
      if (this.tLd == null)
      {
        if (!(paramView.getParent() instanceof ViewGroup)) {
          break label126;
        }
        this.tLb = ((ViewGroup)paramView.getParent());
        this.tKZ = this.tLb.indexOfChild(paramView);
        this.tLa = paramView.getLayoutParams();
        this.tLb.removeView(paramView);
      }
      for (;;)
      {
        localObject = ((d.b)localObject).dB(paramView);
        ((ViewGroup)localObject).addView(paramView, new ViewGroup.LayoutParams(-1, -1));
        ((ViewGroup)localObject).bringChildToFront(paramView);
        paramView.setX(0.0F);
        paramView.setY(0.0F);
        return;
        label126:
        this.tKZ = 0;
        this.tLb = null;
        this.tLa = null;
      }
    }
  }
  
  public final void a(WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.tKY = paramCustomViewCallback;
  }
  
  public final void a(b paramb)
  {
    if (paramb == null) {
      return;
    }
    this.tLc.add(paramb);
  }
  
  public final void b(b paramb)
  {
    this.tLc.remove(paramb);
  }
  
  public final boolean cHN()
  {
    return this.tLe;
  }
  
  protected final void cHO()
  {
    Iterator localIterator = this.tLc.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).cpc();
    }
  }
  
  protected final void cHP()
  {
    Iterator localIterator = this.tLc.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).aqb();
    }
  }
  
  public boolean cdL()
  {
    if (this.tKX == null) {
      return false;
    }
    if (this.tKY != null) {
      this.tKY.onCustomViewHidden();
    }
    if ((this.tKX.getParent() instanceof ViewGroup)) {
      ((ViewGroup)this.tKX.getParent()).removeView(this.tKX);
    }
    if (this.tLb != null) {
      this.tLb.addView(this.tKX, this.tKZ, this.tLa);
    }
    this.tKX = null;
    this.tKY = null;
    this.tLe = false;
    return true;
  }
  
  public void release()
  {
    cdL();
    this.tLc.clear();
    this.tKY = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.a
 * JD-Core Version:    0.7.0.1
 */