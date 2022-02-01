package com.tencent.mm.plugin.appbrand.s.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.a.a.o;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class a
  implements d
{
  protected c iGU;
  private final d.b lmB = new d.b()
  {
    public final ViewGroup cD(View paramAnonymousView)
    {
      AppMethodBeat.i(194515);
      Activity localActivity = null;
      if ((a.this.iGU instanceof o)) {
        localActivity = com.tencent.mm.sdk.f.a.iV(((o)a.this.iGU).mContext);
      }
      if (localActivity == null)
      {
        paramAnonymousView = (ViewGroup)paramAnonymousView.getRootView();
        AppMethodBeat.o(194515);
        return paramAnonymousView;
      }
      paramAnonymousView = (ViewGroup)localActivity.getWindow().getDecorView();
      AppMethodBeat.o(194515);
      return paramAnonymousView;
    }
  };
  private d.b lmC;
  private View lmD;
  private WebChromeClient.CustomViewCallback lmE;
  private int lmF;
  private ViewGroup.LayoutParams lmG;
  private ViewGroup lmH;
  private final Set<b> lmI = Collections.newSetFromMap(new ConcurrentHashMap());
  protected View lmJ;
  protected boolean lmK = false;
  
  public a(c paramc, d.b paramb)
  {
    this.lmC = paramb;
    this.iGU = paramc;
  }
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public void O(View paramView, int paramInt)
  {
    this.lmK = true;
    Object localObject = this.lmC;
    if (localObject == null) {
      localObject = this.lmB;
    }
    for (;;)
    {
      this.lmJ = this.lmD;
      this.lmD = paramView;
      if (this.lmJ == null)
      {
        if (!(paramView.getParent() instanceof ViewGroup)) {
          break label126;
        }
        this.lmH = ((ViewGroup)paramView.getParent());
        this.lmF = this.lmH.indexOfChild(paramView);
        this.lmG = paramView.getLayoutParams();
        this.lmH.removeView(paramView);
      }
      for (;;)
      {
        localObject = ((d.b)localObject).cD(paramView);
        ((ViewGroup)localObject).addView(paramView, new ViewGroup.LayoutParams(-1, -1));
        ((ViewGroup)localObject).bringChildToFront(paramView);
        paramView.setX(0.0F);
        paramView.setY(0.0F);
        return;
        label126:
        this.lmF = 0;
        this.lmH = null;
        this.lmG = null;
      }
    }
  }
  
  public final void a(WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.lmE = paramCustomViewCallback;
  }
  
  public final void a(b paramb)
  {
    if (paramb == null) {
      return;
    }
    this.lmI.add(paramb);
  }
  
  public boolean aNT()
  {
    if (this.lmD == null) {
      return false;
    }
    if (this.lmE != null) {
      this.lmE.onCustomViewHidden();
    }
    if ((this.lmD.getParent() instanceof ViewGroup)) {
      ((ViewGroup)this.lmD.getParent()).removeView(this.lmD);
    }
    if (this.lmH != null) {
      this.lmH.addView(this.lmD, this.lmF, this.lmG);
    }
    this.lmD = null;
    this.lmE = null;
    this.lmK = false;
    return true;
  }
  
  public final void b(b paramb)
  {
    this.lmI.remove(paramb);
  }
  
  public final boolean blI()
  {
    return this.lmK;
  }
  
  protected final void blJ()
  {
    Iterator localIterator = this.lmI.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).aWR();
    }
  }
  
  protected final void blK()
  {
    Iterator localIterator = this.lmI.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).Cx();
    }
  }
  
  public final void release()
  {
    aNT();
    this.lmI.clear();
    this.lmE = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.a.a
 * JD-Core Version:    0.7.0.1
 */