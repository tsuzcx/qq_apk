package com.tencent.mm.plugin.game.luggage.g;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.e;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.luggage.d.j;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.m;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
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
  public MMActivity pQZ;
  public Map<String, i> xxQ;
  Map<String, Integer> xxR;
  public a xxS;
  public FrameLayout xxT;
  public View xxU;
  public i xxV;
  private String xxW;
  private Dialog xxX;
  
  public f(j paramj, Bundle paramBundle)
  {
    super(paramj, null, paramBundle);
    AppMethodBeat.i(186939);
    this.xxQ = new ConcurrentHashMap();
    this.xxR = new ConcurrentHashMap();
    if ((this.mContext instanceof MMActivity)) {
      this.pQZ = ((MMActivity)this.mContext);
    }
    paramj = paramBundle.getString("game_tab_key");
    if (!Util.isNullOrNil(paramj)) {
      this.xxQ.put(paramj, this);
    }
    this.xxV = this;
    this.xyT = this;
    a(this, paramj);
    if (gbC() != null) {
      gbC().gbW();
    }
    this.xxW = paramBundle.getString("game_pre_inject_data");
    this.mParams.remove("game_pre_inject_data");
    if (this.xxX == null)
    {
      this.xxX = new e(this.mContext, 2131820980);
      this.xxX.setCanceledOnTouchOutside(true);
    }
    AppMethodBeat.o(186939);
  }
  
  private static void a(i parami)
  {
    AppMethodBeat.i(186946);
    if (parami.ITi.isShown()) {
      parami.zc(false);
    }
    AppMethodBeat.o(186946);
  }
  
  private void azI(String paramString)
  {
    AppMethodBeat.i(186950);
    if ((Util.isNullOrNil(paramString)) || (!this.xxR.containsKey(paramString)) || (!this.xxQ.containsKey(paramString)))
    {
      AppMethodBeat.o(186950);
      return;
    }
    if (((Integer)this.xxR.get(paramString)).intValue() == 3)
    {
      this.xxR.put(paramString, Integer.valueOf(4));
      ((i)this.xxQ.get(paramString)).cT("javascript:(function(){ window.__gameTabFirstShow__= 1; })()");
      Log.i("MicroMsg.GameTabWebPage", "injectTabFirstShow, tabKey:%s", new Object[] { paramString });
    }
    AppMethodBeat.o(186950);
  }
  
  public final View Lf()
  {
    AppMethodBeat.i(186941);
    Object localObject = super.Lf();
    this.xxU = ((View)localObject);
    this.xxT = new FrameLayout(this.mContext);
    this.xxT.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
    localObject = this.xxT;
    AppMethodBeat.o(186941);
    return localObject;
  }
  
  public final void a(final i parami, final String paramString)
  {
    AppMethodBeat.i(186948);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(186948);
      return;
    }
    parami.xza = new i.a()
    {
      public final void dTD()
      {
        AppMethodBeat.i(186938);
        f.b(f.this).postUI(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(186937);
            Object localObject = f.this;
            int i;
            if (((f)localObject).xxS != null)
            {
              i = ((f)localObject).xxS.dTE();
              localObject = String.format("javascript:(function(){ window.wgclient = window.wgclient || {}; window.wgclient.__gameTabHeight__= %d; })()", new Object[] { Integer.valueOf(i) });
              Log.i("MicroMsg.GameTabWebPage", "tabKey:%s, jsStr_1:%s", new Object[] { f.2.this.xxZ, localObject });
              f.2.this.xya.cT((String)localObject);
              localObject = f.this;
              if (((f)localObject).xxS == null) {
                break label186;
              }
            }
            label186:
            for (localObject = ((f)localObject).xxS.dTF();; localObject = "")
            {
              localObject = String.format("javascript:(function(){ window.wgclient = window.wgclient || {}; window.wgclient.__gameTabInfo__= %s; })()", new Object[] { localObject });
              Log.i("MicroMsg.GameTabWebPage", "tabKey:%s, jsStr_2:%s", new Object[] { f.2.this.xxZ, localObject });
              f.2.this.xya.cT((String)localObject);
              f.a(f.this, f.2.this.xxZ);
              AppMethodBeat.o(186937);
              return;
              i = 0;
              break;
            }
          }
        });
        AppMethodBeat.o(186938);
      }
    };
    AppMethodBeat.o(186948);
  }
  
  final String b(i parami)
  {
    AppMethodBeat.i(186947);
    if (parami == null)
    {
      AppMethodBeat.o(186947);
      return "";
    }
    Iterator localIterator = this.xxQ.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (parami == localEntry.getValue())
      {
        parami = (String)localEntry.getKey();
        AppMethodBeat.o(186947);
        return parami;
      }
    }
    AppMethodBeat.o(186947);
    return "";
  }
  
  protected final String dTC()
  {
    return this.xxW;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(186944);
    super.destroy();
    Iterator localIterator = this.xxQ.values().iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if ((locali != null) && (!(locali instanceof f))) {
        locali.destroy();
      }
    }
    this.xxQ.clear();
    AppMethodBeat.o(186944);
  }
  
  final void ed(String paramString, int paramInt)
  {
    AppMethodBeat.i(186949);
    Integer localInteger = (Integer)this.xxR.get(paramString);
    if (localInteger == null) {
      this.xxR.put(paramString, Integer.valueOf(paramInt));
    }
    for (;;)
    {
      azI(paramString);
      AppMethodBeat.o(186949);
      return;
      this.xxR.put(paramString, Integer.valueOf(localInteger.intValue() | paramInt));
    }
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(186943);
    if (this.xxV == null)
    {
      AppMethodBeat.o(186943);
      return;
    }
    if ((this.xxV instanceof f))
    {
      Log.i("MicroMsg.GameTabWebPage", "GameTabWebPage onBackground, url:%s", new Object[] { this.xxV.coX() });
      super.onBackground();
      a(this);
      AppMethodBeat.o(186943);
      return;
    }
    Log.i("MicroMsg.GameTabWebPage", "onBackground, url:%s", new Object[] { this.xxV.coX() });
    this.xxV.Lj();
    a(this.xxV);
    AppMethodBeat.o(186943);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(186945);
    Log.i("MicroMsg.GameTabWebPage", "onDestroy");
    if (this.xxX != null)
    {
      this.xxX.dismiss();
      this.xxX = null;
    }
    super.onDestroy();
    AppMethodBeat.o(186945);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(186942);
    if (this.xxV == null)
    {
      AppMethodBeat.o(186942);
      return;
    }
    ed(b(this.xxV), 1);
    if ((this.xxV instanceof f))
    {
      Log.i("MicroMsg.GameTabWebPage", "GameTabWebPage onForeground, url:%s", new Object[] { this.xxV.coX() });
      super.onForeground();
    }
    for (;;)
    {
      if (this.xxX != null) {
        this.xxX.show();
      }
      com.tencent.f.h.RTc.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(186936);
          if (f.a(f.this) != null) {
            f.a(f.this).dismiss();
          }
          AppMethodBeat.o(186936);
        }
      }, 50L);
      AppMethodBeat.o(186942);
      return;
      Log.i("MicroMsg.GameTabWebPage", "onForeground, url:%s", new Object[] { this.xxV.coX() });
      this.xxV.Li();
    }
  }
  
  public final void setPageChanging(boolean paramBoolean)
  {
    AppMethodBeat.i(186940);
    if (this.xxS != null) {
      this.xxS.setPageChanging(paramBoolean);
    }
    AppMethodBeat.o(186940);
  }
  
  public static abstract interface a
  {
    public abstract boolean Lw();
    
    public abstract void Oa(int paramInt);
    
    public abstract void Ob(int paramInt);
    
    public abstract int dTE();
    
    public abstract String dTF();
    
    public abstract void setPageChanging(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.g.f
 * JD-Core Version:    0.7.0.1
 */