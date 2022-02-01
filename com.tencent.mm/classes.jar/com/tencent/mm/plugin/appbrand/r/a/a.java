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
  protected c jzX;
  private final Set<b> moA = Collections.newSetFromMap(new ConcurrentHashMap());
  protected View moB;
  protected boolean moC = false;
  private final d.b mot = new d.b()
  {
    public final ViewGroup cH(View paramAnonymousView)
    {
      AppMethodBeat.i(197425);
      Activity localActivity = null;
      if ((a.this.jzX instanceof o)) {
        localActivity = com.tencent.mm.sdk.f.a.jq(((o)a.this.jzX).mContext);
      }
      if (localActivity == null)
      {
        paramAnonymousView = (ViewGroup)paramAnonymousView.getRootView();
        AppMethodBeat.o(197425);
        return paramAnonymousView;
      }
      paramAnonymousView = (ViewGroup)localActivity.getWindow().getDecorView();
      AppMethodBeat.o(197425);
      return paramAnonymousView;
    }
  };
  private d.b mou;
  private View mov;
  private WebChromeClient.CustomViewCallback mow;
  private int mox;
  private ViewGroup.LayoutParams moy;
  private ViewGroup moz;
  
  public a(c paramc, d.b paramb)
  {
    this.mou = paramb;
    this.jzX = paramc;
  }
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public void O(View paramView, int paramInt)
  {
    this.moC = true;
    Object localObject = this.mou;
    if (localObject == null) {
      localObject = this.mot;
    }
    for (;;)
    {
      this.moB = this.mov;
      this.mov = paramView;
      if (this.moB == null)
      {
        if (!(paramView.getParent() instanceof ViewGroup)) {
          break label126;
        }
        this.moz = ((ViewGroup)paramView.getParent());
        this.mox = this.moz.indexOfChild(paramView);
        this.moy = paramView.getLayoutParams();
        this.moz.removeView(paramView);
      }
      for (;;)
      {
        localObject = ((d.b)localObject).cH(paramView);
        ((ViewGroup)localObject).addView(paramView, new ViewGroup.LayoutParams(-1, -1));
        ((ViewGroup)localObject).bringChildToFront(paramView);
        paramView.setX(0.0F);
        paramView.setY(0.0F);
        return;
        label126:
        this.mox = 0;
        this.moz = null;
        this.moy = null;
      }
    }
  }
  
  public final void a(WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.mow = paramCustomViewCallback;
  }
  
  public final void a(b paramb)
  {
    if (paramb == null) {
      return;
    }
    this.moA.add(paramb);
  }
  
  public boolean aXV()
  {
    if (this.mov == null) {
      return false;
    }
    if (this.mow != null) {
      this.mow.onCustomViewHidden();
    }
    if ((this.mov.getParent() instanceof ViewGroup)) {
      ((ViewGroup)this.mov.getParent()).removeView(this.mov);
    }
    if (this.moz != null) {
      this.moz.addView(this.mov, this.mox, this.moy);
    }
    this.mov = null;
    this.mow = null;
    this.moC = false;
    return true;
  }
  
  public final void b(b paramb)
  {
    this.moA.remove(paramb);
  }
  
  public final boolean bwI()
  {
    return this.moC;
  }
  
  protected final void bwJ()
  {
    Iterator localIterator = this.moA.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).bht();
    }
  }
  
  protected final void bwK()
  {
    Iterator localIterator = this.moA.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).DA();
    }
  }
  
  public void release()
  {
    aXV();
    this.moA.clear();
    this.mow = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.a.a
 * JD-Core Version:    0.7.0.1
 */