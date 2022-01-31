package com.tencent.mm.plugin.appbrand;

import android.webkit.JavascriptInterface;
import com.tencent.mm.d.a.b;
import com.tencent.mm.d.a.i;
import com.tencent.mm.d.a.i.3;
import com.tencent.mm.d.a.i.a;
import com.tencent.mm.d.a.j;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.i.f;
import com.tencent.mm.plugin.appbrand.u.d;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

public class s
{
  j bzH = new j()
  {
    public final void a(int paramAnonymousInt, ByteBuffer paramAnonymousByteBuffer)
    {
      if (s.this.fAk != null) {
        s.this.fAk.setNativeBuffer(paramAnonymousInt, paramAnonymousByteBuffer);
      }
    }
    
    public final ByteBuffer eu(int paramAnonymousInt)
    {
      if (s.this.fAk != null) {
        return s.this.fAk.getNativeBuffer(paramAnonymousInt);
      }
      return null;
    }
    
    public final void i(int paramAnonymousInt, String paramAnonymousString)
    {
      s.this.fyo.ahK().evaluateJavascript(String.format("typeof WeixinWorker.workerMsgHandler !== 'undefined' && WeixinWorker.workerMsgHandler(%d, %s);", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString }), null);
    }
    
    public final int tE()
    {
      if (s.this.fAk != null) {
        return s.this.fAk.getNativeBufferId();
      }
      return 0;
    }
  };
  com.tencent.mm.plugin.appbrand.i.h fAk;
  public i fAl;
  private ArrayList<i.a> fAm;
  o fyo;
  
  public s(o paramo)
  {
    this.fyo = paramo;
    this.fAk = ((com.tencent.mm.plugin.appbrand.i.h)paramo.ahK().I(com.tencent.mm.plugin.appbrand.i.h.class));
    this.fAl = aaD();
    this.fAm = new ArrayList();
    String str1 = this.fyo.aay() + "wxa_library/bootstrap_j2v8_worker.js";
    String str2 = d.wB("wxa_library/bootstrap_j2v8_worker.js");
    this.fAm.add(new i.a(str1, str2));
    paramo.ahK().addJavascriptInterface(this, "WeixinWorker");
  }
  
  protected i aaD()
  {
    return new i(this.bzH);
  }
  
  protected void b(ArrayList<i.a> paramArrayList, String paramString)
  {
    paramArrayList.add(new i.a(this.fyo.aay() + "config", String.format("var __wxConfig = %s;", new Object[] { this.fyo.aaw().toString() })));
  }
  
  @JavascriptInterface
  public int create(String paramString)
  {
    ArrayList localArrayList = new ArrayList(this.fAm);
    b(localArrayList, paramString);
    localArrayList.add(qO(paramString));
    return this.fAl.d(localArrayList);
  }
  
  @JavascriptInterface
  public void postMsgToWorker(int paramInt, String paramString)
  {
    i locali = this.fAl;
    b localb = (b)locali.bzG.get(Integer.valueOf(paramInt));
    if (localb != null) {
      localb.byY.i(new i.3(locali, localb, paramString));
    }
  }
  
  protected i.a qO(String paramString)
  {
    return new i.a(this.fyo.aaz() + paramString, aq.a(this.fyo.getRuntime(), paramString) + this.fyo.qK(paramString));
  }
  
  @JavascriptInterface
  public void terminate(int paramInt)
  {
    b localb = (b)this.fAl.bzG.remove(Integer.valueOf(paramInt));
    if (localb != null) {
      localb.destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s
 * JD-Core Version:    0.7.0.1
 */