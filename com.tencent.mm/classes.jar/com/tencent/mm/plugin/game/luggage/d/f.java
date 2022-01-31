package com.tencent.mm.plugin.game.luggage.d;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.luggage.d.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.game.d.dd;
import com.tencent.mm.plugin.game.luggage.b.1;
import com.tencent.mm.plugin.webview.luggage.l;
import com.tencent.mm.plugin.webview.luggage.t;
import com.tencent.mm.plugin.webview.ui.tools.bag.h;
import com.tencent.mm.plugin.webview.ui.tools.game.c.a;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton;
import com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class f
  extends com.tencent.mm.plugin.webview.luggage.e
{
  public boolean njj;
  private View nkD;
  private GameMenuImageButton nkE;
  private String nkF;
  public com.tencent.mm.plugin.webview.ui.tools.game.c nkG;
  private long nkH;
  private boolean nkI;
  private boolean nkJ;
  private com.tencent.mm.plugin.webview.ui.tools.game.g nkK;
  private Map<String, b> nkL;
  protected GameWebPerformanceInfo nkv;
  
  public f(com.tencent.luggage.d.g paramg, k paramk, Bundle paramBundle)
  {
    super(paramg, paramk, paramBundle);
    AppMethodBeat.i(135968);
    this.njj = false;
    this.nkL = new HashMap();
    this.nkG = new com.tencent.mm.plugin.webview.ui.tools.game.c()
    {
      public final void R(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(135963);
        com.tencent.mm.ipcinvoker.f.a("com.tencent.mm", paramAnonymousBundle, com.tencent.mm.plugin.game.luggage.e.a.class, null);
        AppMethodBeat.o(135963);
      }
    };
    ab.i("MicroMsg.GameWebPage", "initWebPageEnd, __Time__， time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    paramg = paramBundle.getString("rawUrl");
    this.nkv = GameWebPerformanceInfo.lN(paramg);
    this.nkv.ezP = bFD();
    this.nkv.eAi = System.currentTimeMillis();
    this.nkK = PU(paramg);
    paramg = this.bzu.getString("rawUrl");
    if (!bo.isNullOrNil(paramg))
    {
      paramg = Uri.parse(paramg).getQueryParameter("nav_color");
      if (!bo.isNullOrNil(paramg)) {
        try
        {
          int i = Color.parseColor("#".concat(String.valueOf(paramg)));
          this.bzu.putInt("customize_status_bar_color", i);
          AppMethodBeat.o(135968);
          return;
        }
        catch (IllegalArgumentException paramg) {}
      }
    }
    AppMethodBeat.o(135968);
  }
  
  private void p(final String paramString, final Map<String, String> paramMap)
  {
    AppMethodBeat.i(135990);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.GameWebPage", "fullUrl is null, return");
      AppMethodBeat.o(135990);
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135965);
        if ((paramMap != null) && (paramMap.size() != 0))
        {
          f.a(f.this);
          com.tencent.xweb.c.jQ(f.this.mContext);
          com.tencent.xweb.b localb = com.tencent.xweb.b.dYg();
          Iterator localIterator = paramMap.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            localb.setCookie(bo.aqm(paramString), str + "=" + (String)paramMap.get(str));
          }
          localb.setCookie(bo.aqm(paramString), "httponly");
          com.tencent.xweb.c.dYi();
          com.tencent.xweb.c.sync();
          ab.i("MicroMsg.GameWebPage", "cookies:%s", new Object[] { localb.getCookie(bo.aqm(f.b(f.this))) });
        }
        f.this.bzs.a(new com.tencent.luggage.d.c()
        {
          public final String name()
          {
            return "onGetA8KeyUrl";
          }
          
          public final JSONObject tY()
          {
            AppMethodBeat.i(154159);
            JSONObject localJSONObject = new JSONObject();
            for (;;)
            {
              try
              {
                localJSONObject.put("url", f.3.this.njr);
                if ((f.3.this.njq == null) || (f.3.this.njq.size() == 0)) {
                  continue;
                }
                i = 1;
                localJSONObject.put("set_cookie", i);
              }
              catch (Exception localException)
              {
                int i;
                ab.e("MicroMsg.GameWebPage", "onGetA8Key, e:" + localException.getMessage());
                continue;
              }
              AppMethodBeat.o(154159);
              return localJSONObject;
              i = 0;
            }
          }
        });
        AppMethodBeat.o(135965);
      }
    });
    AppMethodBeat.o(135990);
  }
  
  public final void PQ(String paramString)
  {
    AppMethodBeat.i(135988);
    super.PQ(paramString);
    if (this.nkK.vna == 0L) {
      this.nkK.vna = System.currentTimeMillis();
    }
    AppMethodBeat.o(135988);
  }
  
  public final boolean PT(String paramString)
  {
    AppMethodBeat.i(135981);
    boolean bool = ((e)this.uRk).PT(paramString);
    AppMethodBeat.o(135981);
    return bool;
  }
  
  protected com.tencent.mm.plugin.webview.ui.tools.game.g PU(String paramString)
  {
    AppMethodBeat.i(135971);
    paramString = com.tencent.mm.plugin.webview.ui.tools.game.g.aiO(paramString);
    AppMethodBeat.o(135971);
    return paramString;
  }
  
  public boolean PV(String paramString)
  {
    AppMethodBeat.i(135972);
    if ((PT(paramString)) && (com.tencent.mm.plugin.game.luggage.b.bFl()))
    {
      ab.i("MicroMsg.GameWebPage", "isWePkg and has valid cache");
      if (this.nkv.eAn == 0L) {
        this.nkv.ezU = 1;
      }
      this.nkJ = true;
      AppMethodBeat.o(135972);
      return false;
    }
    this.nkJ = false;
    if ((paramString.equals(daZ())) && (this.nkv.eAn == 0L))
    {
      this.nkv.eAn = System.currentTimeMillis();
      ab.i("MicroMsg.GameWebPage", "startGetA8Key, url: %s, time: %d", new Object[] { paramString, Long.valueOf(this.nkv.eAn) });
    }
    boolean bool = super.PV(paramString);
    AppMethodBeat.o(135972);
    return bool;
  }
  
  public final void PW(String paramString)
  {
    AppMethodBeat.i(135985);
    super.PW(paramString);
    if (this.nkv.eAk == 0L) {
      this.nkv.eAk = System.currentTimeMillis();
    }
    AppMethodBeat.o(135985);
  }
  
  public final void bE(String paramString)
  {
    AppMethodBeat.i(135986);
    long l = System.currentTimeMillis();
    ab.i("MicroMsg.GameWebPage", "onUrlLoadingStarted, url = %s, __Time__, time = %d", new Object[] { paramString, Long.valueOf(l) });
    super.bE(paramString);
    if (this.nkv.eAl == 0L) {
      this.nkv.eAl = l;
    }
    if (this.nkK.vmY == 0L) {
      this.nkK.vmY = l;
    }
    paramString = bo.apS(paramString);
    if ((this.nkJ) || ((paramString != null) && (paramString.equals("game.weixin.qq.com")))) {}
    for (this.bzs.bzh = com.tencent.luggage.d.a.a.bzy;; this.bzs.bzh = this.uRE)
    {
      this.nkG.vmB.dgb();
      AppMethodBeat.o(135986);
      return;
    }
  }
  
  public void bF(String paramString)
  {
    AppMethodBeat.i(135987);
    long l = System.currentTimeMillis();
    ab.i("MicroMsg.GameWebPage", "onUrlLoadingFinished, url = %s, __Time__, time = %d", new Object[] { paramString, Long.valueOf(l) });
    super.bF(paramString);
    if (this.nkv.eAm == 0L) {
      this.nkv.eAm = l;
    }
    if (this.nkK.vmZ == 0L) {
      this.nkK.vmZ = l;
    }
    if (this.nkJ)
    {
      paramString = this.bzs;
      if (paramString != null)
      {
        if (com.tencent.mm.plugin.game.luggage.b.mHeaders != null)
        {
          String str1 = "." + bo.aqm(com.tencent.mm.plugin.game.luggage.b.nji);
          String str2 = bo.aqm(com.tencent.mm.plugin.game.luggage.b.nji);
          com.tencent.xweb.c.jQ(ah.getContext());
          com.tencent.xweb.b localb = com.tencent.xweb.b.dYg();
          Iterator localIterator = com.tencent.mm.plugin.game.luggage.b.mHeaders.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str3 = (String)localIterator.next();
            localb.setCookie(str2, str3 + "=" + (String)com.tencent.mm.plugin.game.luggage.b.mHeaders.get(str3));
          }
          localb.setCookie(str2, "httponly");
          localb.setCookie(str1, "httponly");
          com.tencent.xweb.c.dYi();
          com.tencent.xweb.c.sync();
          ab.i("MicroMsg.LuggageGameUinKeyHolder", "cookies:%s", new Object[] { localb.getCookie(str2) });
          com.tencent.mm.plugin.game.luggage.b.njj = true;
        }
        paramString.a(new b.1());
      }
    }
    for (;;)
    {
      this.nkG.vmB.uG();
      AppMethodBeat.o(135987);
      return;
      if ((this.nkI) && (PT(paramString))) {
        p(this.nji, this.uRF);
      }
    }
  }
  
  public final void bFA()
  {
    AppMethodBeat.i(154161);
    dd localdd;
    if (!this.uRH)
    {
      this.uRI = this.bzu.getInt("customize_status_bar_color");
      if (this.uRI == 0)
      {
        localdd = com.tencent.mm.plugin.game.commlib.a.bFc();
        if ((localdd == null) || (bo.isNullOrNil(localdd.color))) {}
      }
    }
    try
    {
      this.uRI = Color.parseColor(localdd.color);
      if (this.uRI == 0) {
        this.uRI = android.support.v4.content.b.m(this.mContext, 2131689641);
      }
      daS();
      AppMethodBeat.o(154161);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        ab.e("MicroMsg.GameWebPage", "parse color: " + localIllegalArgumentException.getMessage());
      }
    }
  }
  
  public final void bFB()
  {
    AppMethodBeat.i(135983);
    this.nkD.setVisibility(8);
    AppMethodBeat.o(135983);
  }
  
  public final com.tencent.mm.plugin.wepkg.c bFC()
  {
    AppMethodBeat.i(135991);
    com.tencent.mm.plugin.wepkg.c localc = ((e)this.uRk).getWePkgPlugin();
    AppMethodBeat.o(135991);
    return localc;
  }
  
  public final String bFD()
  {
    AppMethodBeat.i(135992);
    String str = (hashCode() & 0x7FFFFFFF) + "_" + (daZ().hashCode() & 0x7FFFFFFF);
    AppMethodBeat.o(135992);
    return str;
  }
  
  public void bFr()
  {
    AppMethodBeat.i(135982);
    this.nkD.setVisibility(0);
    AppMethodBeat.o(135982);
  }
  
  public final void bFu()
  {
    AppMethodBeat.i(135973);
    this.uRn.bFu();
    AppMethodBeat.o(135973);
  }
  
  public final View bFz()
  {
    AppMethodBeat.i(135970);
    this.uRn = new d(this);
    l locall = this.uRn;
    AppMethodBeat.o(135970);
    return locall;
  }
  
  public final void c(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(154163);
    X(new f.5(this, paramString, paramInt3, paramInt4, paramInt1, paramInt2));
    AppMethodBeat.o(154163);
  }
  
  public final void d(final String paramString1, final String paramString2, final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4)
  {
    AppMethodBeat.i(154162);
    X(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135967);
        f.this.daX();
        f.this.bFB();
        Bundle localBundle = new Bundle();
        localBundle.putAll(f.this.bzu);
        localBundle.putString("rawUrl", paramString1);
        b localb = new b(f.this.byJ, localBundle);
        f.c(f.this).put(paramString2, localb);
        f.d(f.this).addView(localb.Qz, new FrameLayout.LayoutParams(paramInt3, paramInt4));
        localb.Qz.setX(paramInt1 + f.e(f.this).getX());
        localb.Qz.setY(paramInt2 + f.f(f.this).getY());
        localb.bNQ();
        localb.daX();
        localb.g(paramString1, localBundle);
        AppMethodBeat.o(135967);
      }
    });
    AppMethodBeat.o(154162);
  }
  
  public void e(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(135989);
    super.e(paramString1, paramString2, paramMap);
    e locale = (e)this.bzs.uv();
    locale.nji = paramString2;
    locale.nko = paramMap;
    if (bo.isNullOrNil(paramString2)) {
      ab.i("MicroMsg.LuggageGameUinKeyHolder", "setFullUrlAndHeaders, fullUrl is null");
    }
    for (;;)
    {
      long l = System.currentTimeMillis();
      if (paramString1.equals(daZ()))
      {
        ab.i("MicroMsg.GameWebPage", "getA8Key end, __Time__, time: %d", new Object[] { Long.valueOf(l) });
        this.nkv.eAo = l;
      }
      if (this.nkv.eAk == 0L) {
        this.nkv.eAk = l;
      }
      if (this.nkK.vnb == 0L) {
        this.nkK.vnb = System.currentTimeMillis();
      }
      if (PT(paramString1)) {
        p(paramString2, paramMap);
      }
      AppMethodBeat.o(135989);
      return;
      if (!Uri.parse(paramString2).getHost().equals("game.weixin.qq.com"))
      {
        ab.i("MicroMsg.LuggageGameUinKeyHolder", "setFullUrlAndHeaders, host is not wxgame");
      }
      else
      {
        com.tencent.mm.plugin.game.luggage.b.nji = paramString2;
        com.tencent.mm.plugin.game.luggage.b.mHeaders = paramMap;
        com.tencent.mm.plugin.game.luggage.b.Dt = System.currentTimeMillis() / 1000L;
      }
    }
  }
  
  public void g(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(135984);
    ab.i("MicroMsg.GameWebPage", "load url, __Time__, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    if (this.nkK.vmX == 0L) {
      this.nkK.vmX = System.currentTimeMillis();
    }
    super.g(paramString, paramBundle);
    AppMethodBeat.o(135984);
  }
  
  public void ib(boolean paramBoolean)
  {
    AppMethodBeat.i(135978);
    super.ib(paramBoolean);
    if (isFullScreen())
    {
      this.nkF = this.bzu.getString("game_hv_menu_appid");
      if (!bo.isNullOrNil(this.nkF))
      {
        if (this.nkE == null)
        {
          this.nkE = new GameMenuImageButton(this.mContext);
          this.nkE.a(this.osU, new f.2(this));
        }
        this.uRt.setVisibility(8);
        AppMethodBeat.o(135978);
        return;
      }
      this.uRt.setVisibility(0);
    }
    AppMethodBeat.o(135978);
  }
  
  public void onBackground()
  {
    AppMethodBeat.i(135975);
    ab.i("MicroMsg.GameWebPage", "onBackground, __Time__, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    Object localObject = this.nkv;
    ((GameWebPerformanceInfo)localObject).eAp += System.currentTimeMillis() - this.nkH;
    this.nkH = System.currentTimeMillis();
    this.nkG.vmB.onPause();
    int i = this.byJ.um().indexOf(this);
    if ((i > 1) && (((com.tencent.luggage.d.e)this.byJ.um().get(i - 1) instanceof a)))
    {
      AppMethodBeat.o(135975);
      return;
    }
    super.onBackground();
    localObject = this.nkL.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b)((Iterator)localObject).next()).onBackground();
    }
    AppMethodBeat.o(135975);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(135976);
    ab.i("MicroMsg.GameWebPage", "onDestroy, __Time__, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    super.onDestroy();
    com.tencent.mm.plugin.webview.ui.tools.game.c.a(this.nkG.vmB.vmC);
    Object localObject = this.nkv;
    ((GameWebPerformanceInfo)localObject).eAp += System.currentTimeMillis() - this.nkH;
    this.nkv.eAq = System.currentTimeMillis();
    if (!this.bzu.getBoolean("from_bag", false))
    {
      localObject = com.tencent.mm.game.report.api.a.ezM;
      if (localObject != null) {
        ((com.tencent.mm.game.report.api.a)localObject).a(this.nkv);
      }
      com.tencent.mm.plugin.webview.ui.tools.game.e.aiM(daZ());
    }
    GameWebPerformanceInfo.lP(daZ());
    com.tencent.mm.plugin.webview.ui.tools.game.g.aiP(daZ());
    localObject = this.nkL.values();
    if ((localObject != null) && (((Collection)localObject).size() > 0))
    {
      localObject = ((Collection)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((b)((Iterator)localObject).next()).onDestroy();
      }
      if (this.uRy.dfg()) {
        com.tencent.mm.plugin.webview.luggage.n.remove(t.uSZ);
      }
    }
    AppMethodBeat.o(135976);
  }
  
  public void onForeground()
  {
    AppMethodBeat.i(135974);
    ab.i("MicroMsg.GameWebPage", "onForeground, __Time__, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    if (this.nkv.eAg == 0L) {
      this.nkv.eAg = System.currentTimeMillis();
    }
    this.nkH = System.currentTimeMillis();
    this.nkG.vmB.onResume();
    super.onForeground();
    Iterator localIterator = this.nkL.values().iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).onForeground();
    }
    AppMethodBeat.o(135974);
  }
  
  public final void reload()
  {
    AppMethodBeat.i(135977);
    this.nkI = true;
    super.reload();
    AppMethodBeat.o(135977);
  }
  
  public View tZ()
  {
    AppMethodBeat.i(135969);
    View localView = super.tZ();
    this.nkD = LayoutInflater.from(this.mContext).inflate(2130969782, this.uRu, false);
    this.nkD.setVisibility(8);
    this.uRu.addView(this.nkD, new FrameLayout.LayoutParams(-2, -2, 17));
    ab.i("MicroMsg.GameWebPage", "create vie end, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    AppMethodBeat.o(135969);
    return localView;
  }
  
  public final boolean wZ(int paramInt)
  {
    AppMethodBeat.i(135993);
    if (this.bzs.ut() == com.tencent.luggage.d.a.a.bzy)
    {
      AppMethodBeat.o(135993);
      return true;
    }
    if (this.bzs.ut() == com.tencent.luggage.d.a.a.bzz)
    {
      AppMethodBeat.o(135993);
      return false;
    }
    boolean bool = super.wZ(paramInt);
    AppMethodBeat.o(135993);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.f
 * JD-Core Version:    0.7.0.1
 */