package com.tencent.mm.plugin.appbrand.r.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.a.a.o;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class a
  implements d
{
  protected c jgX;
  private final d.b lOD = new d.b()
  {
    public final ViewGroup cF(View paramAnonymousView)
    {
      AppMethodBeat.i(193505);
      Activity localActivity = null;
      if ((a.this.jgX instanceof o)) {
        localActivity = com.tencent.mm.sdk.f.a.jg(((o)a.this.jgX).mContext);
      }
      if (localActivity == null)
      {
        paramAnonymousView = (ViewGroup)paramAnonymousView.getRootView();
        AppMethodBeat.o(193505);
        return paramAnonymousView;
      }
      paramAnonymousView = (ViewGroup)localActivity.getWindow().getDecorView();
      AppMethodBeat.o(193505);
      return paramAnonymousView;
    }
  };
  private d.b lOE;
  private View lOF;
  private WebChromeClient.CustomViewCallback lOG;
  private int lOH;
  private ViewGroup.LayoutParams lOI;
  private ViewGroup lOJ;
  private final Set<b> lOK = Collections.newSetFromMap(new ConcurrentHashMap());
  protected View lOL;
  protected boolean lOM = false;
  
  public a(c paramc, d.b paramb)
  {
    this.lOE = paramb;
    this.jgX = paramc;
  }
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public void O(View paramView, int paramInt)
  {
    this.lOM = true;
    Object localObject = this.lOE;
    if (localObject == null) {
      localObject = this.lOD;
    }
    for (;;)
    {
      this.lOL = this.lOF;
      this.lOF = paramView;
      if (this.lOL == null)
      {
        if (!(paramView.getParent() instanceof ViewGroup)) {
          break label126;
        }
        this.lOJ = ((ViewGroup)paramView.getParent());
        this.lOH = this.lOJ.indexOfChild(paramView);
        this.lOI = paramView.getLayoutParams();
        this.lOJ.removeView(paramView);
      }
      for (;;)
      {
        localObject = ((d.b)localObject).cF(paramView);
        ((ViewGroup)localObject).addView(paramView, new ViewGroup.LayoutParams(-1, -1));
        ((ViewGroup)localObject).bringChildToFront(paramView);
        paramView.setX(0.0F);
        paramView.setY(0.0F);
        return;
        label126:
        this.lOH = 0;
        this.lOJ = null;
        this.lOI = null;
      }
    }
  }
  
  public final void a(WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.lOG = paramCustomViewCallback;
  }
  
  public final void a(b paramb)
  {
    if (paramb == null) {
      return;
    }
    this.lOK.add(paramb);
  }
  
  public boolean aUJ()
  {
    if (this.lOF == null) {
      return false;
    }
    if (this.lOG != null) {
      this.lOG.onCustomViewHidden();
    }
    if ((this.lOF.getParent() instanceof ViewGroup)) {
      ((ViewGroup)this.lOF.getParent()).removeView(this.lOF);
    }
    if (this.lOJ != null) {
      this.lOJ.addView(this.lOF, this.lOH, this.lOI);
    }
    this.lOF = null;
    this.lOG = null;
    this.lOM = false;
    return true;
  }
  
  public final void b(b paramb)
  {
    this.lOK.remove(paramb);
  }
  
  public final boolean bsE()
  {
    return this.lOM;
  }
  
  protected final void bsF()
  {
    Iterator localIterator = this.lOK.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).bdP();
    }
  }
  
  protected final void bsG()
  {
    Iterator localIterator = this.lOK.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).Cb();
    }
  }
  
  public void release()
  {
    aUJ();
    this.lOK.clear();
    this.lOG = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.a.a
 * JD-Core Version:    0.7.0.1
 */