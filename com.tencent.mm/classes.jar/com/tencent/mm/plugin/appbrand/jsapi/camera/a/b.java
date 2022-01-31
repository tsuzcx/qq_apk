package com.tencent.mm.plugin.appbrand.jsapi.camera.a;

import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class b
{
  AtomicBoolean gpj = new AtomicBoolean(false);
  b.a gpk;
  ai gpl = new ai("MicroMsg.appbrand.ScanDecoder");
  
  public b(b.a parama)
  {
    this.gpk = parama;
  }
  
  protected final void b(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.appbrand.ScanDecoder", "result:%b, resultText:%s, resultType:%d, codeType:%d, codeVersion:%d", new Object[] { Boolean.valueOf(true), paramString, Integer.valueOf(paramInt), Integer.valueOf(0), Integer.valueOf(0) });
    ai.d(new b.2(this, paramInt, paramString, paramArrayOfByte));
  }
  
  abstract boolean b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  abstract void init();
  
  abstract void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.a.b
 * JD-Core Version:    0.7.0.1
 */