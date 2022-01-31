package com.tencent.mm.plugin.appbrand.page;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.f.a;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class d
{
  private static final d.a ivf;
  private d.a ivg;
  private View ivh;
  WebChromeClient.CustomViewCallback ivi;
  private int ivj;
  private ViewGroup.LayoutParams ivk;
  private ViewGroup ivl;
  private int ivm;
  private int ivn;
  private WindowManager.LayoutParams ivo;
  final Set<ao> ivp;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(141801);
    ivf = new d.a()
    {
      public final ViewGroup cs(View paramAnonymousView)
      {
        AppMethodBeat.i(141799);
        Activity localActivity = a.hr(paramAnonymousView.getContext());
        if (localActivity == null)
        {
          paramAnonymousView = (ViewGroup)paramAnonymousView.getRootView();
          AppMethodBeat.o(141799);
          return paramAnonymousView;
        }
        paramAnonymousView = (ViewGroup)localActivity.getWindow().getDecorView();
        AppMethodBeat.o(141799);
        return paramAnonymousView;
      }
    };
    AppMethodBeat.o(141801);
  }
  
  d(Context paramContext, d.a parama)
  {
    AppMethodBeat.i(141800);
    this.ivp = Collections.newSetFromMap(new ConcurrentHashMap());
    this.mContext = paramContext;
    this.ivg = parama;
    AppMethodBeat.o(141800);
  }
  
  private void aIK()
  {
    AppMethodBeat.i(91085);
    Iterator localIterator = this.ivp.iterator();
    while (localIterator.hasNext()) {
      ((ao)localIterator.next()).aJy();
    }
    AppMethodBeat.o(91085);
  }
  
  private void aIL()
  {
    AppMethodBeat.i(91086);
    Iterator localIterator = this.ivp.iterator();
    while (localIterator.hasNext()) {
      ((ao)localIterator.next()).aDk();
    }
    AppMethodBeat.o(91086);
  }
  
  public final void J(View paramView, int paramInt)
  {
    AppMethodBeat.i(91082);
    aIJ();
    Object localObject = this.ivg;
    if (localObject == null) {
      localObject = ivf;
    }
    for (;;)
    {
      this.ivh = paramView;
      if ((paramView.getParent() instanceof ViewGroup))
      {
        this.ivl = ((ViewGroup)paramView.getParent());
        this.ivj = this.ivl.indexOfChild(paramView);
        this.ivk = paramView.getLayoutParams();
        this.ivl.removeView(paramView);
        localObject = ((d.a)localObject).cs(paramView);
        ((ViewGroup)localObject).addView(paramView, new ViewGroup.LayoutParams(-1, -1));
        ((ViewGroup)localObject).bringChildToFront(paramView);
        paramView.setX(0.0F);
        paramView.setY(0.0F);
        paramView = a.hr(this.mContext);
        if (paramView == null) {
          break label325;
        }
        localObject = (ViewGroup)paramView.getWindow().getDecorView();
        this.ivm = ((ViewGroup)localObject).getSystemUiVisibility();
        if (!com.tencent.mm.compatible.util.d.fw(19)) {
          break label290;
        }
        ((ViewGroup)localObject).setSystemUiVisibility(2);
        label158:
        this.ivo = new WindowManager.LayoutParams();
        this.ivo.copyFrom(paramView.getWindow().getAttributes());
        paramView.getWindow().addFlags(1024);
        if (Build.VERSION.SDK_INT >= 28) {
          paramView.getWindow().getAttributes().layoutInDisplayCutoutMode = 2;
        }
        this.ivn = paramView.getRequestedOrientation();
        switch (paramInt)
        {
        default: 
          paramView.setRequestedOrientation(9);
        }
      }
      for (;;)
      {
        aIK();
        AppMethodBeat.o(91082);
        return;
        this.ivj = 0;
        this.ivl = null;
        this.ivk = null;
        break;
        label290:
        ((ViewGroup)localObject).setSystemUiVisibility(4102);
        break label158;
        paramView.setRequestedOrientation(0);
        continue;
        paramView.setRequestedOrientation(8);
        continue;
        paramView.setRequestedOrientation(1);
        continue;
        label325:
        com.tencent.luggage.g.d.e("Luggage.AppBrandCustomViewFullscreenImpl", "enterFullscreen, get NULL activity");
        this.ivn = -1;
        this.ivo = null;
        this.ivm = 0;
      }
    }
  }
  
  public final void a(ao paramao)
  {
    AppMethodBeat.i(91084);
    this.ivp.add(paramao);
    AppMethodBeat.o(91084);
  }
  
  public final boolean aIJ()
  {
    AppMethodBeat.i(91083);
    if (this.ivh == null)
    {
      AppMethodBeat.o(91083);
      return false;
    }
    if (this.ivi != null) {
      this.ivi.onCustomViewHidden();
    }
    Activity localActivity = a.hr(this.mContext);
    if (localActivity != null)
    {
      ((ViewGroup)localActivity.getWindow().getDecorView()).setSystemUiVisibility(this.ivm);
      localActivity.getWindow().clearFlags(1024);
      if (this.ivo != null) {
        localActivity.getWindow().setAttributes(this.ivo);
      }
      localActivity.setRequestedOrientation(this.ivn);
    }
    for (;;)
    {
      if ((this.ivh.getParent() instanceof ViewGroup)) {
        ((ViewGroup)this.ivh.getParent()).removeView(this.ivh);
      }
      if (this.ivl != null) {
        this.ivl.addView(this.ivh, this.ivj, this.ivk);
      }
      this.ivh = null;
      this.ivi = null;
      aIL();
      AppMethodBeat.o(91083);
      return true;
      com.tencent.luggage.g.d.e("Luggage.AppBrandCustomViewFullscreenImpl", "exitFullscreen, get NULL activity");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.d
 * JD-Core Version:    0.7.0.1
 */