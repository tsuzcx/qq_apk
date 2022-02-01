package com.tencent.mm.plugin.game.luggage.page;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.appcompat.app.e;
import com.tencent.luggage.d.j;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.j.g;
import com.tencent.mm.plugin.webview.luggage.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class f
  extends GameWebPage
{
  public Map<String, GameWebPage> IvP;
  Map<String, Integer> IvQ;
  public a IvR;
  public FrameLayout IvS;
  public View IvT;
  public GameWebPage IvU;
  private String IvV;
  private Dialog IvW;
  public MMActivity wry;
  
  public f(j paramj, Bundle paramBundle)
  {
    super(paramj, null, paramBundle);
    AppMethodBeat.i(277045);
    this.IvP = new ConcurrentHashMap();
    this.IvQ = new ConcurrentHashMap();
    if ((getContext() instanceof MMActivity)) {
      this.wry = ((MMActivity)getContext());
    }
    paramj = paramBundle.getString("game_tab_key");
    if (!Util.isNullOrNil(paramj)) {
      this.IvP.put(paramj, this);
    }
    this.IvU = this;
    this.Ixc = this;
    a(this, paramj);
    if (iuf() != null) {
      iuf().iuD();
    }
    this.IvV = paramBundle.getString("game_pre_inject_data");
    this.ejT.remove("game_pre_inject_data");
    if (this.IvW == null)
    {
      this.IvW = new e(getContext(), j.g.Iur);
      this.IvW.setCanceledOnTouchOutside(true);
    }
    AppMethodBeat.o(277045);
  }
  
  private static void a(GameWebPage paramGameWebPage)
  {
    AppMethodBeat.i(277047);
    if (paramGameWebPage.iud()) {
      paramGameWebPage.IF(false);
    }
    AppMethodBeat.o(277047);
  }
  
  private void aGg(String paramString)
  {
    AppMethodBeat.i(277049);
    if ((Util.isNullOrNil(paramString)) || (!this.IvQ.containsKey(paramString)) || (!this.IvP.containsKey(paramString)))
    {
      AppMethodBeat.o(277049);
      return;
    }
    if (((Integer)this.IvQ.get(paramString)).intValue() == 3)
    {
      this.IvQ.put(paramString, Integer.valueOf(4));
      ((GameWebPage)this.IvP.get(paramString)).eE("javascript:(function(){ window.__gameTabFirstShow__= 1; })()");
      Log.i("MicroMsg.GameTabWebPage", "injectTabFirstShow, tabKey:%s", new Object[] { paramString });
    }
    AppMethodBeat.o(277049);
  }
  
  public final void a(final GameWebPage paramGameWebPage, final String paramString)
  {
    AppMethodBeat.i(277101);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(277101);
      return;
    }
    paramGameWebPage.a(new GameWebPage.a()
    {
      public final void fEE()
      {
        AppMethodBeat.i(277036);
        f.b(f.this).postUI(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(277022);
            Object localObject = f.this;
            int i;
            if (((f)localObject).IvR != null)
            {
              i = ((f)localObject).IvR.fEF();
              localObject = String.format("javascript:(function(){ window.wgclient = window.wgclient || {}; window.wgclient.__gameTabHeight__= %d; })()", new Object[] { Integer.valueOf(i) });
              Log.i("MicroMsg.GameTabWebPage", "tabKey:%s, jsStr_1:%s", new Object[] { f.2.this.IvY, localObject });
              f.2.this.IvZ.eE((String)localObject);
              localObject = f.this;
              if (((f)localObject).IvR == null) {
                break label186;
              }
            }
            label186:
            for (localObject = ((f)localObject).IvR.fEG();; localObject = "")
            {
              localObject = String.format("javascript:(function(){ window.wgclient = window.wgclient || {}; window.wgclient.__gameTabInfo__= %s; })()", new Object[] { localObject });
              Log.i("MicroMsg.GameTabWebPage", "tabKey:%s, jsStr_2:%s", new Object[] { f.2.this.IvY, localObject });
              f.2.this.IvZ.eE((String)localObject);
              f.a(f.this, f.2.this.IvY);
              AppMethodBeat.o(277022);
              return;
              i = 0;
              break;
            }
          }
        });
        AppMethodBeat.o(277036);
      }
    });
    AppMethodBeat.o(277101);
  }
  
  public final View aog()
  {
    AppMethodBeat.i(277068);
    Object localObject = super.aog();
    this.IvT = ((View)localObject);
    this.IvS = new FrameLayout(getContext());
    this.IvS.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
    localObject = this.IvS;
    AppMethodBeat.o(277068);
    return localObject;
  }
  
  final String b(GameWebPage paramGameWebPage)
  {
    AppMethodBeat.i(277095);
    if (paramGameWebPage == null)
    {
      AppMethodBeat.o(277095);
      return "";
    }
    Iterator localIterator = this.IvP.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (paramGameWebPage == localEntry.getValue())
      {
        paramGameWebPage = (String)localEntry.getKey();
        AppMethodBeat.o(277095);
        return paramGameWebPage;
      }
    }
    AppMethodBeat.o(277095);
    return "";
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(277082);
    super.destroy();
    Iterator localIterator = this.IvP.values().iterator();
    while (localIterator.hasNext())
    {
      GameWebPage localGameWebPage = (GameWebPage)localIterator.next();
      if ((localGameWebPage != null) && (!(localGameWebPage instanceof f))) {
        localGameWebPage.destroy();
      }
    }
    this.IvP.clear();
    AppMethodBeat.o(277082);
  }
  
  protected final String fED()
  {
    return this.IvV;
  }
  
  final void fr(String paramString, int paramInt)
  {
    AppMethodBeat.i(277106);
    Integer localInteger = (Integer)this.IvQ.get(paramString);
    if (localInteger == null) {
      this.IvQ.put(paramString, Integer.valueOf(paramInt));
    }
    for (;;)
    {
      aGg(paramString);
      AppMethodBeat.o(277106);
      return;
      this.IvQ.put(paramString, Integer.valueOf(localInteger.intValue() | paramInt));
    }
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(277080);
    if (this.IvU == null)
    {
      AppMethodBeat.o(277080);
      return;
    }
    if ((this.IvU instanceof f))
    {
      Log.i("MicroMsg.GameTabWebPage", "GameTabWebPage onBackground, url:%s", new Object[] { this.IvU.dgY() });
      super.onBackground();
      a(this);
      AppMethodBeat.o(277080);
      return;
    }
    Log.i("MicroMsg.GameTabWebPage", "onBackground, url:%s", new Object[] { this.IvU.dgY() });
    this.IvU.aoi();
    a(this.IvU);
    AppMethodBeat.o(277080);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(277088);
    Log.i("MicroMsg.GameTabWebPage", "onDestroy");
    if (this.IvW != null)
    {
      this.IvW.dismiss();
      this.IvW = null;
    }
    super.onDestroy();
    AppMethodBeat.o(277088);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(277076);
    if (this.IvU == null)
    {
      AppMethodBeat.o(277076);
      return;
    }
    fr(b(this.IvU), 1);
    if ((this.IvU instanceof f))
    {
      Log.i("MicroMsg.GameTabWebPage", "GameTabWebPage onForeground, url:%s", new Object[] { this.IvU.dgY() });
      super.onForeground();
    }
    for (;;)
    {
      if (this.IvW != null) {
        this.IvW.show();
      }
      h.ahAA.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(277034);
          if (f.a(f.this) != null) {
            f.a(f.this).dismiss();
          }
          AppMethodBeat.o(277034);
        }
      }, 50L);
      AppMethodBeat.o(277076);
      return;
      Log.i("MicroMsg.GameTabWebPage", "onForeground, url:%s", new Object[] { this.IvU.dgY() });
      this.IvU.aoh();
    }
  }
  
  public final void setPageChanging(boolean paramBoolean)
  {
    AppMethodBeat.i(277063);
    if (this.IvR != null) {
      this.IvR.setPageChanging(paramBoolean);
    }
    AppMethodBeat.o(277063);
  }
  
  public static abstract interface a
  {
    public abstract void Xn(int paramInt);
    
    public abstract void Xo(int paramInt);
    
    public abstract void aGh(String paramString);
    
    public abstract boolean aou();
    
    public abstract int fEF();
    
    public abstract String fEG();
    
    public abstract void setPageChanging(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.page.f
 * JD-Core Version:    0.7.0.1
 */