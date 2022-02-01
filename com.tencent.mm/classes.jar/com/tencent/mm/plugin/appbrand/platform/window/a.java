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
  protected c kEb;
  private final d.b nDZ = new d.b()
  {
    public final ViewGroup cB(View paramAnonymousView)
    {
      AppMethodBeat.i(219571);
      Activity localActivity = null;
      if ((a.this.kEb instanceof o)) {
        localActivity = AndroidContextUtil.castActivityOrNull(((o)a.this.kEb).mContext);
      }
      if (localActivity == null)
      {
        paramAnonymousView = (ViewGroup)paramAnonymousView.getRootView();
        AppMethodBeat.o(219571);
        return paramAnonymousView;
      }
      paramAnonymousView = (ViewGroup)localActivity.getWindow().getDecorView();
      AppMethodBeat.o(219571);
      return paramAnonymousView;
    }
  };
  private d.b nEa;
  private View nEb;
  private WebChromeClient.CustomViewCallback nEc;
  private int nEd;
  private ViewGroup.LayoutParams nEe;
  private ViewGroup nEf;
  private final Set<b> nEg = Collections.newSetFromMap(new ConcurrentHashMap());
  protected View nEh;
  protected boolean nEi = false;
  
  public a(c paramc, d.b paramb)
  {
    this.nEa = paramb;
    this.kEb = paramc;
  }
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public void N(View paramView, int paramInt)
  {
    this.nEi = true;
    Object localObject = this.nEa;
    if (localObject == null) {
      localObject = this.nDZ;
    }
    for (;;)
    {
      this.nEh = this.nEb;
      this.nEb = paramView;
      if (this.nEh == null)
      {
        if (!(paramView.getParent() instanceof ViewGroup)) {
          break label126;
        }
        this.nEf = ((ViewGroup)paramView.getParent());
        this.nEd = this.nEf.indexOfChild(paramView);
        this.nEe = paramView.getLayoutParams();
        this.nEf.removeView(paramView);
      }
      for (;;)
      {
        localObject = ((d.b)localObject).cB(paramView);
        ((ViewGroup)localObject).addView(paramView, new ViewGroup.LayoutParams(-1, -1));
        ((ViewGroup)localObject).bringChildToFront(paramView);
        paramView.setX(0.0F);
        paramView.setY(0.0F);
        return;
        label126:
        this.nEd = 0;
        this.nEf = null;
        this.nEe = null;
      }
    }
  }
  
  public final void a(WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.nEc = paramCustomViewCallback;
  }
  
  public final void a(b paramb)
  {
    if (paramb == null) {
      return;
    }
    this.nEg.add(paramb);
  }
  
  public final void b(b paramb)
  {
    this.nEg.remove(paramb);
  }
  
  public final boolean bTK()
  {
    return this.nEi;
  }
  
  protected final void bTL()
  {
    Iterator localIterator = this.nEg.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).bDq();
    }
  }
  
  protected final void bTM()
  {
    Iterator localIterator = this.nEg.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).Na();
    }
  }
  
  public boolean btC()
  {
    if (this.nEb == null) {
      return false;
    }
    if (this.nEc != null) {
      this.nEc.onCustomViewHidden();
    }
    if ((this.nEb.getParent() instanceof ViewGroup)) {
      ((ViewGroup)this.nEb.getParent()).removeView(this.nEb);
    }
    if (this.nEf != null) {
      this.nEf.addView(this.nEb, this.nEd, this.nEe);
    }
    this.nEb = null;
    this.nEc = null;
    this.nEi = false;
    return true;
  }
  
  public void release()
  {
    btC();
    this.nEg.clear();
    this.nEc = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.a
 * JD-Core Version:    0.7.0.1
 */