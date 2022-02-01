package com.tencent.mm.plugin.game.luggage.f;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.luggage.d.h;
import com.tencent.luggage.d.j;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class d
  extends g
{
  public Map<String, g> ufF;
  private Map<String, Integer> ufG;
  public a ufH;
  public FrameLayout ufI;
  public View ufJ;
  public g ufK;
  private String ufL;
  
  public d(j paramj, Bundle paramBundle)
  {
    super(paramj, null, paramBundle);
    AppMethodBeat.i(193055);
    this.ufF = new ConcurrentHashMap();
    this.ufG = new ConcurrentHashMap();
    paramj = paramBundle.getString("game_tab_key");
    if (!bu.isNullOrNil(paramj)) {
      this.ufF.put(paramj, this);
    }
    this.ufK = this;
    this.ugE = this;
    a(this, paramj);
    if (eSQ() != null) {
      eSQ().eTj();
    }
    this.ufL = paramBundle.getString("game_pre_inject_data");
    this.mParams.remove("game_pre_inject_data");
    AppMethodBeat.o(193055);
  }
  
  private void amt(String paramString)
  {
    AppMethodBeat.i(193063);
    if ((bu.isNullOrNil(paramString)) || (!this.ufG.containsKey(paramString)) || (!this.ufF.containsKey(paramString)))
    {
      AppMethodBeat.o(193063);
      return;
    }
    if (((Integer)this.ufG.get(paramString)).intValue() == 3)
    {
      this.ufG.put(paramString, Integer.valueOf(4));
      ((g)this.ufF.get(paramString)).cC("javascript:(function(){ window.__gameTabFirstShow__= 1; })()");
      ae.i("MicroMsg.GameTabWebPage", "injectTabFirstShow, tabKey:%s", new Object[] { paramString });
    }
    AppMethodBeat.o(193063);
  }
  
  private void dO(String paramString, int paramInt)
  {
    AppMethodBeat.i(193062);
    Integer localInteger = (Integer)this.ufG.get(paramString);
    if (localInteger == null) {
      this.ufG.put(paramString, Integer.valueOf(paramInt));
    }
    for (;;)
    {
      amt(paramString);
      AppMethodBeat.o(193062);
      return;
      this.ufG.put(paramString, Integer.valueOf(localInteger.intValue() | paramInt));
    }
  }
  
  public final View BR()
  {
    AppMethodBeat.i(193057);
    Object localObject = super.BR();
    this.ufJ = ((View)localObject);
    this.ufI = new FrameLayout(this.mContext);
    this.ufI.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
    localObject = this.ufI;
    AppMethodBeat.o(193057);
    return localObject;
  }
  
  public final void a(final g paramg, final String paramString)
  {
    AppMethodBeat.i(193061);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(193061);
      return;
    }
    paramg.ugF = new g.a()
    {
      public final void cZV()
      {
        AppMethodBeat.i(193054);
        d.a(d.this).postUI(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(193053);
            Object localObject = d.this;
            int i;
            if (((d)localObject).ufH != null)
            {
              i = ((d)localObject).ufH.cZW();
              localObject = String.format("javascript:(function(){ window.wgclient = window.wgclient || {}; window.wgclient.__gameTabHeight__= %d; })()", new Object[] { Integer.valueOf(i) });
              ae.i("MicroMsg.GameTabWebPage", "tabKey:%s, jsStr_1:%s", new Object[] { d.1.this.ufM, localObject });
              d.1.this.ufN.cC((String)localObject);
              localObject = d.this;
              if (((d)localObject).ufH == null) {
                break label186;
              }
            }
            label186:
            for (localObject = ((d)localObject).ufH.cZX();; localObject = "")
            {
              localObject = String.format("javascript:(function(){ window.wgclient = window.wgclient || {}; window.wgclient.__gameTabInfo__= %s; })()", new Object[] { localObject });
              ae.i("MicroMsg.GameTabWebPage", "tabKey:%s, jsStr_2:%s", new Object[] { d.1.this.ufM, localObject });
              d.1.this.ufN.cC((String)localObject);
              d.a(d.this, d.1.this.ufM);
              AppMethodBeat.o(193053);
              return;
              i = 0;
              break;
            }
          }
        });
        AppMethodBeat.o(193054);
      }
    };
    AppMethodBeat.o(193061);
  }
  
  protected final String cZU()
  {
    return this.ufL;
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(193059);
    if (this.ufK == null)
    {
      AppMethodBeat.o(193059);
      return;
    }
    if ((this.ufK instanceof d))
    {
      ae.i("MicroMsg.GameTabWebPage", "GameTabWebPage onBackground, url:%s", new Object[] { this.ufK.bRn() });
      super.onBackground();
      AppMethodBeat.o(193059);
      return;
    }
    ae.i("MicroMsg.GameTabWebPage", "onBackground, url:%s", new Object[] { this.ufK.bRn() });
    this.ufK.BU();
    AppMethodBeat.o(193059);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(193060);
    ae.i("MicroMsg.GameTabWebPage", "onDestroy");
    super.onDestroy();
    Iterator localIterator = this.ufF.values().iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)localIterator.next();
      if (localg != null) {
        localg.destroy();
      }
    }
    this.ufF.clear();
    AppMethodBeat.o(193060);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(193058);
    if (this.ufK == null)
    {
      AppMethodBeat.o(193058);
      return;
    }
    Object localObject = this.ufK;
    Map.Entry localEntry;
    if (localObject != null)
    {
      Iterator localIterator = this.ufF.entrySet().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localEntry = (Map.Entry)localIterator.next();
      } while (localObject != localEntry.getValue());
    }
    for (localObject = (String)localEntry.getKey();; localObject = "")
    {
      dO((String)localObject, 1);
      if (!(this.ufK instanceof d)) {
        break;
      }
      ae.i("MicroMsg.GameTabWebPage", "GameTabWebPage onForeground, url:%s", new Object[] { this.ufK.bRn() });
      super.onForeground();
      AppMethodBeat.o(193058);
      return;
    }
    ae.i("MicroMsg.GameTabWebPage", "onForeground, url:%s", new Object[] { this.ufK.bRn() });
    this.ufK.BT();
    AppMethodBeat.o(193058);
  }
  
  public final void setPageChanging(boolean paramBoolean)
  {
    AppMethodBeat.i(193056);
    if (this.ufH != null) {
      this.ufH.setPageChanging(paramBoolean);
    }
    AppMethodBeat.o(193056);
  }
  
  public static abstract interface a
  {
    public abstract void HX(int paramInt);
    
    public abstract void HY(int paramInt);
    
    public abstract boolean aKK();
    
    public abstract int cZW();
    
    public abstract String cZX();
    
    public abstract void setPageChanging(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.f.d
 * JD-Core Version:    0.7.0.1
 */