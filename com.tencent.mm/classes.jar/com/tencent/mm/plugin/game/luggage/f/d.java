package com.tencent.mm.plugin.game.luggage.f;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.luggage.d.h;
import com.tencent.luggage.d.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class d
  extends g
{
  public Map<String, g> tUL;
  private Map<String, Integer> tUM;
  public a tUN;
  public FrameLayout tUO;
  public View tUP;
  public g tUQ;
  
  public d(j paramj, Bundle paramBundle)
  {
    super(paramj, null, paramBundle);
    AppMethodBeat.i(211664);
    this.tUL = new ConcurrentHashMap();
    this.tUM = new ConcurrentHashMap();
    paramj = paramBundle.getString("game_tab_key");
    if (!bt.isNullOrNil(paramj)) {
      this.tUL.put(paramj, this);
    }
    this.tUQ = this;
    this.tVG = this;
    a(this, paramj);
    if (ePe() != null) {
      ePe().ePx();
    }
    AppMethodBeat.o(211664);
  }
  
  private void alv(String paramString)
  {
    AppMethodBeat.i(211671);
    if ((bt.isNullOrNil(paramString)) || (!this.tUM.containsKey(paramString)) || (!this.tUL.containsKey(paramString)))
    {
      AppMethodBeat.o(211671);
      return;
    }
    if (((Integer)this.tUM.get(paramString)).intValue() == 3)
    {
      this.tUM.put(paramString, Integer.valueOf(4));
      ((g)this.tUL.get(paramString)).cB("javascript:(function(){ window.__gameTabFirstShow__= 1; })()");
      ad.i("MicroMsg.GameTabWebPage", "injectTabFirstShow, tabKey:%s", new Object[] { paramString });
    }
    AppMethodBeat.o(211671);
  }
  
  private void dK(String paramString, int paramInt)
  {
    AppMethodBeat.i(211670);
    Integer localInteger = (Integer)this.tUM.get(paramString);
    if (localInteger == null) {
      this.tUM.put(paramString, Integer.valueOf(paramInt));
    }
    for (;;)
    {
      alv(paramString);
      AppMethodBeat.o(211670);
      return;
      this.tUM.put(paramString, Integer.valueOf(localInteger.intValue() | paramInt));
    }
  }
  
  public final View BQ()
  {
    AppMethodBeat.i(211665);
    Object localObject = super.BQ();
    this.tUP = ((View)localObject);
    this.tUO = new FrameLayout(this.mContext);
    this.tUO.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
    localObject = this.tUO;
    AppMethodBeat.o(211665);
    return localObject;
  }
  
  public final void a(final g paramg, final String paramString)
  {
    AppMethodBeat.i(211669);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(211669);
      return;
    }
    paramg.tVH = new g.a()
    {
      public final void cXl()
      {
        AppMethodBeat.i(211663);
        d.a(d.this).postUI(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(211662);
            Object localObject = d.this;
            int i;
            if (((d)localObject).tUN != null)
            {
              i = ((d)localObject).tUN.cXm();
              localObject = String.format("javascript:(function(){ window.wgclient = window.wgclient || {}; window.wgclient.__gameTabHeight__= %d; })()", new Object[] { Integer.valueOf(i) });
              ad.i("MicroMsg.GameTabWebPage", "tabKey:%s, jsStr_1:%s", new Object[] { d.1.this.tUR, localObject });
              d.1.this.tUS.cB((String)localObject);
              localObject = d.this;
              if (((d)localObject).tUN == null) {
                break label186;
              }
            }
            label186:
            for (localObject = ((d)localObject).tUN.cXn();; localObject = "")
            {
              localObject = String.format("javascript:(function(){ window.wgclient = window.wgclient || {}; window.wgclient.__gameTabInfo__= %s; })()", new Object[] { localObject });
              ad.i("MicroMsg.GameTabWebPage", "tabKey:%s, jsStr_2:%s", new Object[] { d.1.this.tUR, localObject });
              d.1.this.tUS.cB((String)localObject);
              d.a(d.this, d.1.this.tUR);
              AppMethodBeat.o(211662);
              return;
              i = 0;
              break;
            }
          }
        });
        AppMethodBeat.o(211663);
      }
    };
    AppMethodBeat.o(211669);
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(211667);
    if (this.tUQ == null)
    {
      AppMethodBeat.o(211667);
      return;
    }
    if ((this.tUQ instanceof d))
    {
      ad.i("MicroMsg.GameTabWebPage", "GameTabWebPage onBackground, url:%s", new Object[] { this.tUQ.bQm() });
      super.onBackground();
      AppMethodBeat.o(211667);
      return;
    }
    ad.i("MicroMsg.GameTabWebPage", "onBackground, url:%s", new Object[] { this.tUQ.bQm() });
    this.tUQ.BT();
    AppMethodBeat.o(211667);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(211668);
    ad.i("MicroMsg.GameTabWebPage", "onDestroy");
    super.onDestroy();
    Iterator localIterator = this.tUL.values().iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)localIterator.next();
      if (localg != null) {
        localg.destroy();
      }
    }
    this.tUL.clear();
    AppMethodBeat.o(211668);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(211666);
    if (this.tUQ == null)
    {
      AppMethodBeat.o(211666);
      return;
    }
    Object localObject = this.tUQ;
    Map.Entry localEntry;
    if (localObject != null)
    {
      Iterator localIterator = this.tUL.entrySet().iterator();
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
      dK((String)localObject, 1);
      if (!(this.tUQ instanceof d)) {
        break;
      }
      ad.i("MicroMsg.GameTabWebPage", "GameTabWebPage onForeground, url:%s", new Object[] { this.tUQ.bQm() });
      super.onForeground();
      AppMethodBeat.o(211666);
      return;
    }
    ad.i("MicroMsg.GameTabWebPage", "onForeground, url:%s", new Object[] { this.tUQ.bQm() });
    this.tUQ.BS();
    AppMethodBeat.o(211666);
  }
  
  public static abstract interface a
  {
    public abstract void HA(int paramInt);
    
    public abstract void HB(int paramInt);
    
    public abstract int cXm();
    
    public abstract String cXn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.f.d
 * JD-Core Version:    0.7.0.1
 */