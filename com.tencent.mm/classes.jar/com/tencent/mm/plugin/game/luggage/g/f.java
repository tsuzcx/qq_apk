package com.tencent.mm.plugin.game.luggage.g;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.appcompat.app.e;
import com.tencent.e.h;
import com.tencent.luggage.d.j;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.j.g;
import com.tencent.mm.plugin.webview.luggage.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class f
  extends i
{
  public Map<String, i> CCa;
  Map<String, Integer> CCb;
  public a CCc;
  public FrameLayout CCd;
  public View CCe;
  public i CCf;
  private String CCg;
  private Dialog CCh;
  public MMActivity tmY;
  
  public f(j paramj, Bundle paramBundle)
  {
    super(paramj, null, paramBundle);
    AppMethodBeat.i(232291);
    this.CCa = new ConcurrentHashMap();
    this.CCb = new ConcurrentHashMap();
    if ((getContext() instanceof MMActivity)) {
      this.tmY = ((MMActivity)getContext());
    }
    paramj = paramBundle.getString("game_tab_key");
    if (!Util.isNullOrNil(paramj)) {
      this.CCa.put(paramj, this);
    }
    this.CCf = this;
    this.CDb = this;
    a(this, paramj);
    if (gUx() != null) {
      gUx().gUS();
    }
    this.CCg = paramBundle.getString("game_pre_inject_data");
    this.mParams.remove("game_pre_inject_data");
    if (this.CCh == null)
    {
      this.CCh = new e(getContext(), j.g.CAF);
      this.CCh.setCanceledOnTouchOutside(true);
    }
    AppMethodBeat.o(232291);
  }
  
  private static void a(i parami)
  {
    AppMethodBeat.i(232304);
    if (parami.gUv()) {
      parami.CX(false);
    }
    AppMethodBeat.o(232304);
  }
  
  private void aJu(String paramString)
  {
    AppMethodBeat.i(232314);
    if ((Util.isNullOrNil(paramString)) || (!this.CCb.containsKey(paramString)) || (!this.CCa.containsKey(paramString)))
    {
      AppMethodBeat.o(232314);
      return;
    }
    if (((Integer)this.CCb.get(paramString)).intValue() == 3)
    {
      this.CCb.put(paramString, Integer.valueOf(4));
      ((i)this.CCa.get(paramString)).dt("javascript:(function(){ window.__gameTabFirstShow__= 1; })()");
      Log.i("MicroMsg.GameTabWebPage", "injectTabFirstShow, tabKey:%s", new Object[] { paramString });
    }
    AppMethodBeat.o(232314);
  }
  
  public final View NW()
  {
    AppMethodBeat.i(232294);
    Object localObject = super.NW();
    this.CCe = ((View)localObject);
    this.CCd = new FrameLayout(getContext());
    this.CCd.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
    localObject = this.CCd;
    AppMethodBeat.o(232294);
    return localObject;
  }
  
  public final void a(final i parami, final String paramString)
  {
    AppMethodBeat.i(232310);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(232310);
      return;
    }
    parami.a(new i.a()
    {
      public final void ewM()
      {
        AppMethodBeat.i(231430);
        f.b(f.this).postUI(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(232285);
            Object localObject = f.this;
            int i;
            if (((f)localObject).CCc != null)
            {
              i = ((f)localObject).CCc.ewN();
              localObject = String.format("javascript:(function(){ window.wgclient = window.wgclient || {}; window.wgclient.__gameTabHeight__= %d; })()", new Object[] { Integer.valueOf(i) });
              Log.i("MicroMsg.GameTabWebPage", "tabKey:%s, jsStr_1:%s", new Object[] { f.2.this.CCj, localObject });
              f.2.this.CCk.dt((String)localObject);
              localObject = f.this;
              if (((f)localObject).CCc == null) {
                break label186;
              }
            }
            label186:
            for (localObject = ((f)localObject).CCc.ewO();; localObject = "")
            {
              localObject = String.format("javascript:(function(){ window.wgclient = window.wgclient || {}; window.wgclient.__gameTabInfo__= %s; })()", new Object[] { localObject });
              Log.i("MicroMsg.GameTabWebPage", "tabKey:%s, jsStr_2:%s", new Object[] { f.2.this.CCj, localObject });
              f.2.this.CCk.dt((String)localObject);
              f.a(f.this, f.2.this.CCj);
              AppMethodBeat.o(232285);
              return;
              i = 0;
              break;
            }
          }
        });
        AppMethodBeat.o(231430);
      }
    });
    AppMethodBeat.o(232310);
  }
  
  final String b(i parami)
  {
    AppMethodBeat.i(232308);
    if (parami == null)
    {
      AppMethodBeat.o(232308);
      return "";
    }
    Iterator localIterator = this.CCa.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (parami == localEntry.getValue())
      {
        parami = (String)localEntry.getKey();
        AppMethodBeat.o(232308);
        return parami;
      }
    }
    AppMethodBeat.o(232308);
    return "";
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(232299);
    super.destroy();
    Iterator localIterator = this.CCa.values().iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if ((locali != null) && (!(locali instanceof f))) {
        locali.destroy();
      }
    }
    this.CCa.clear();
    AppMethodBeat.o(232299);
  }
  
  final void eB(String paramString, int paramInt)
  {
    AppMethodBeat.i(232313);
    Integer localInteger = (Integer)this.CCb.get(paramString);
    if (localInteger == null) {
      this.CCb.put(paramString, Integer.valueOf(paramInt));
    }
    for (;;)
    {
      aJu(paramString);
      AppMethodBeat.o(232313);
      return;
      this.CCb.put(paramString, Integer.valueOf(localInteger.intValue() | paramInt));
    }
  }
  
  protected final String ewL()
  {
    return this.CCg;
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(232297);
    if (this.CCf == null)
    {
      AppMethodBeat.o(232297);
      return;
    }
    if ((this.CCf instanceof f))
    {
      Log.i("MicroMsg.GameTabWebPage", "GameTabWebPage onBackground, url:%s", new Object[] { this.CCf.cDu() });
      super.onBackground();
      a(this);
      AppMethodBeat.o(232297);
      return;
    }
    Log.i("MicroMsg.GameTabWebPage", "onBackground, url:%s", new Object[] { this.CCf.cDu() });
    this.CCf.NZ();
    a(this.CCf);
    AppMethodBeat.o(232297);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(232301);
    Log.i("MicroMsg.GameTabWebPage", "onDestroy");
    if (this.CCh != null)
    {
      this.CCh.dismiss();
      this.CCh = null;
    }
    super.onDestroy();
    AppMethodBeat.o(232301);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(232295);
    if (this.CCf == null)
    {
      AppMethodBeat.o(232295);
      return;
    }
    eB(b(this.CCf), 1);
    if ((this.CCf instanceof f))
    {
      Log.i("MicroMsg.GameTabWebPage", "GameTabWebPage onForeground, url:%s", new Object[] { this.CCf.cDu() });
      super.onForeground();
    }
    for (;;)
    {
      if (this.CCh != null) {
        this.CCh.show();
      }
      h.ZvG.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(231692);
          if (f.a(f.this) != null) {
            f.a(f.this).dismiss();
          }
          AppMethodBeat.o(231692);
        }
      }, 50L);
      AppMethodBeat.o(232295);
      return;
      Log.i("MicroMsg.GameTabWebPage", "onForeground, url:%s", new Object[] { this.CCf.cDu() });
      this.CCf.NY();
    }
  }
  
  public final void setPageChanging(boolean paramBoolean)
  {
    AppMethodBeat.i(232293);
    if (this.CCc != null) {
      this.CCc.setPageChanging(paramBoolean);
    }
    AppMethodBeat.o(232293);
  }
  
  public static abstract interface a
  {
    public abstract boolean Om();
    
    public abstract void Tt(int paramInt);
    
    public abstract void Tu(int paramInt);
    
    public abstract int ewN();
    
    public abstract String ewO();
    
    public abstract void setPageChanging(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.g.f
 * JD-Core Version:    0.7.0.1
 */