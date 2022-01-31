package com.tencent.mm.plugin.appbrand.game;

import android.webkit.ValueCallback;
import com.tencent.magicbrush.a.d.f;
import com.tencent.magicbrush.engine.JsEngine;
import com.tencent.magicbrush.engine.a;
import com.tencent.magicbrush.engine.c;
import com.tencent.mm.plugin.appbrand.i.d;
import com.tencent.mm.plugin.appbrand.i.h;
import com.tencent.mm.plugin.appbrand.i.l;
import java.nio.ByteBuffer;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public enum i
  implements h, com.tencent.mm.plugin.appbrand.i.i, l
{
  volatile e gae;
  final AtomicInteger gaf = new AtomicInteger(0);
  final TreeMap<Integer, d> gag = new TreeMap();
  
  private i() {}
  
  public final void a(String paramString1, String paramString2, ValueCallback<String> paramValueCallback)
  {
    c localc = this.gae.fZW;
    if (localc.bkz == 0L) {
      paramString1 = "";
    }
    for (;;)
    {
      paramValueCallback.onReceiveValue(paramString1);
      return;
      paramString1 = JsEngine.evaluateJavascriptDebug(localc.bkz, paramString1, paramString2);
      localc.qI();
    }
  }
  
  public final void aP(Object paramObject)
  {
    this.gae.fZW.bkC = ((a)paramObject);
  }
  
  public final d ago()
  {
    return this.gae;
  }
  
  public final d agp()
  {
    int i = this.gaf.addAndGet(1);
    e locale = new e(false, new c(this.gae.fZW.qH(), i), i);
    this.gag.put(Integer.valueOf(i), locale);
    return locale;
  }
  
  public final ByteBuffer getNativeBuffer(int paramInt)
  {
    return this.gae.fZW.getNativeBuffer(paramInt);
  }
  
  public final int getNativeBufferId()
  {
    e locale = this.gae;
    return JsEngine.getNativeBufferId();
  }
  
  public final d kQ(int paramInt)
  {
    return (d)this.gag.get(Integer.valueOf(paramInt));
  }
  
  public final void kR(int paramInt)
  {
    d locald = (d)this.gag.get(Integer.valueOf(paramInt));
    if (locald != null) {
      locald.destroy();
    }
    this.gag.remove(Integer.valueOf(paramInt));
  }
  
  public final void setNativeBuffer(int paramInt, ByteBuffer paramByteBuffer)
  {
    Object localObject = this.gae;
    if (paramByteBuffer == null)
    {
      d.f.d("JsVmContext", "JsVmContext setNativeBuffer failed. byteBuffer == null", new Object[0]);
      return;
    }
    localObject = paramByteBuffer;
    if (!paramByteBuffer.isDirect())
    {
      localObject = ByteBuffer.allocateDirect(paramByteBuffer.capacity());
      paramByteBuffer.rewind();
      ((ByteBuffer)localObject).put(paramByteBuffer);
    }
    JsEngine.setNativeBuffer(paramInt, (ByteBuffer)localObject);
  }
  
  public final void tp(String paramString)
  {
    c localc = this.gae.fZW;
    if (localc.bkz != 0L)
    {
      JsEngine.waitForDebuger(localc.bkz, paramString);
      localc.qI();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.i
 * JD-Core Version:    0.7.0.1
 */