package com.tencent.mm.plugin.appbrand.debugger;

import android.app.Activity;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ipcinvoker.wx_extension.b;
import com.tencent.mm.plugin.appbrand.config.d;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.i.e;
import com.tencent.mm.plugin.appbrand.i.f;
import com.tencent.mm.plugin.appbrand.i.g;
import com.tencent.mm.plugin.appbrand.o.k.b;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.protocal.c.ajx;
import com.tencent.mm.protocal.c.ajy;
import com.tencent.mm.protocal.c.cgp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public final class l
  implements f
{
  j fSm;
  String fSn;
  q fSo;
  n fSp = new n();
  public s fSq;
  k.b fSr = new l.2(this);
  Activity fyk;
  com.tencent.mm.plugin.appbrand.o fyo;
  
  public l()
  {
    com.tencent.mm.sdk.b.a.udP.b(new l.4(this));
  }
  
  public final <T extends g> T I(Class<T> paramClass)
  {
    return null;
  }
  
  public final void a(j paramj)
  {
    this.fSm = paramj;
    this.fyo = this.fSm.fRI;
    this.fyk = ((Activity)this.fyo.getContext());
    this.fSq = new s(this.fyk, this.fSm, new l.1(this));
    paramj = this.fSq;
    paramj.fSV = ((ViewGroup)this.fyo.getRuntime().fyq.getParent());
    int i = 0;
    Object localObject;
    while (i < paramj.fSV.getChildCount())
    {
      localObject = paramj.fSV.getChildAt(i);
      if ((localObject instanceof s)) {
        paramj.fSV.removeView((View)localObject);
      }
      i += 1;
    }
    paramj.fSV.addView(paramj);
    paramj.fSV.bringChildToFront(paramj);
    paramj.fSW = ((RemoteDebugMoveView)LayoutInflater.from(paramj.getContext()).inflate(y.h.app_brand_remote_debug_move_view, null));
    paramj.fSZ = ((TextView)paramj.fSW.findViewById(y.g.app_brand_remote_debug_connect_tv));
    paramj.fSY = ((TextView)paramj.fSW.findViewById(y.g.app_brand_remote_debug_server_tv));
    paramj.fTa = ((TextView)paramj.fSW.findViewById(y.g.app_brand_remote_debug_info_tv));
    paramj.fTb = ((TextView)paramj.fSW.findViewById(y.g.app_brand_remote_debug_quit_tv));
    paramj.fTc = ((TextView)paramj.fSW.findViewById(y.g.app_brand_remote_debug_expand_tv));
    paramj.fTd = ((TextView)paramj.fSW.findViewById(y.g.app_brand_remote_debug_collapse_tv));
    paramj.fTe = ((TextView)paramj.fSW.findViewById(y.g.app_brand_remote_debug_error_tv));
    paramj.fTg = ((ImageView)paramj.fSW.findViewById(y.g.app_brand_remote_debug_connect_dot));
    paramj.fTf = ((ImageView)paramj.fSW.findViewById(y.g.app_brand_remote_debug_server_dot));
    paramj.fTh = paramj.fSW.findViewById(y.g.app_brand_remote_debug_detail_layout);
    paramj.show();
    paramj.fTc.setOnClickListener(paramj.mOnClickListener);
    paramj.fTd.setOnClickListener(paramj.mOnClickListener);
    paramj.fTb.setOnClickListener(paramj.mOnClickListener);
    paramj.postDelayed(new s.1(paramj), 100L);
    connect();
    if (bk.bl(this.fSm.aez()))
    {
      y.i("MicroMsg.RemoteDebugJsEngine", "getRemoteDebugTicket");
      paramj = new ajx();
      localObject = new b.a();
      ((b.a)localObject).ecH = paramj;
      ((b.a)localObject).ecI = new ajy();
      ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxabusiness/getremotedebugticket";
      ((b.a)localObject).ecG = 1862;
      ((b.a)localObject).ecJ = 0;
      ((b.a)localObject).ecK = 0;
      b.a(((b.a)localObject).Kt(), new l.3(this));
    }
  }
  
  public final void a(m paramm)
  {
    this.fSp.a(paramm);
  }
  
  public final void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback)
  {
    evaluateJavascript(paramString, paramValueCallback);
  }
  
  public final void a(URL paramURL, String paramString1, String paramString2, String paramString3, ValueCallback<String> paramValueCallback)
  {
    evaluateJavascript(paramString3, paramValueCallback);
  }
  
  public final void addJavascriptInterface(Object paramObject, String paramString) {}
  
  final void connect()
  {
    if (this.fSo == null)
    {
      this.fSo = new q(d.h((com.tencent.mm.plugin.appbrand.n)this.fyo.getRuntime()));
      n localn = this.fSp;
      q localq = this.fSo;
      j localj = this.fSm;
      s locals = this.fSq;
      localn.fSo = localq;
      localn.fSm = localj;
      localn.fSq = locals;
    }
    if (this.fSm.aeE())
    {
      this.fSo.a("ws://localhost:" + this.fSm.fRO.fSk, this.fSr);
      return;
    }
    this.fSo.a("wss://wxagame.weixin.qq.com/remote/", this.fSr);
  }
  
  public final void destroy()
  {
    this.fSp.quit();
    this.fSp.aeK();
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    if (this.fSm.aeC()) {
      return;
    }
    if (!this.fSm.isReady())
    {
      this.fSm.fRZ.add(new Pair(paramString, paramValueCallback));
      this.fSn = null;
      return;
    }
    Object localObject = new cgp();
    ((cgp)localObject).tVE = this.fSm.fRU.incrementAndGet();
    ((cgp)localObject).script = paramString;
    m localm = r.a((com.tencent.mm.bv.a)localObject, this.fSm, "evaluateJavascript");
    this.fSp.a(localm);
    int i = ((cgp)localObject).tVE;
    localObject = new a();
    if (!bk.bl(this.fSn))
    {
      ((a)localObject).bGt = this.fSn;
      this.fSn = null;
    }
    for (;;)
    {
      ((a)localObject).fRE = System.currentTimeMillis();
      ((a)localObject).size = paramString.length();
      ((a)localObject).fRD = paramValueCallback;
      this.fSm.fSd.put(Integer.valueOf(i), localObject);
      return;
      ((a)localObject).bGt = o.sP(paramString);
    }
  }
  
  final void onReady()
  {
    y.i("MicroMsg.RemoteDebugJsEngine", "onReady");
    this.fSm.setStatus(3);
    y.i("MicroMsg.RemoteDebugJsEngine", "clearPendingScript");
    Iterator localIterator = this.fSm.fRZ.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      evaluateJavascript((String)localPair.first, (ValueCallback)localPair.second);
    }
    this.fSm.fRZ.clear();
    this.fSp.bP(this.fSm.aeA(), 2147483647);
    this.fSq.aeS();
  }
  
  public final void setJsExceptionHandler(e parame) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.l
 * JD-Core Version:    0.7.0.1
 */