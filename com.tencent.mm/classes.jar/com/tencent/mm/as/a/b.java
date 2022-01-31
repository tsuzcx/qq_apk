package com.tencent.mm.as.a;

import android.graphics.Bitmap;
import com.tencent.mm.as.a.c.a;
import com.tencent.mm.as.a.c.h;
import com.tencent.mm.as.a.c.m;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public final class b
{
  Executor eqA;
  public final Map<Integer, String> eqB = Collections.synchronizedMap(new HashMap());
  public HashMap<Integer, com.tencent.mm.as.a.f.b> eqC = new HashMap();
  public com.tencent.mm.as.a.a.b eqy;
  h eqz;
  
  public b(com.tencent.mm.as.a.a.b paramb)
  {
    this.eqy = paramb;
    this.eqz = paramb.eqZ;
    this.eqA = paramb.era;
    this.eqy.eqT.a(this.eqy.eqV);
  }
  
  public final void a(c paramc)
  {
    this.eqB.remove(Integer.valueOf(paramc.eqE));
    y.d("MicroMsg.imageloader.ImageLoaderManager", "[cpan] remove image weak holder size:%d viewcode:%s", new Object[] { Integer.valueOf(this.eqB.size()), Integer.valueOf(paramc.eqE) });
  }
  
  public final Bitmap mr(String paramString)
  {
    if (this.eqy != null) {
      return this.eqy.eqS.jK(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.as.a.b
 * JD-Core Version:    0.7.0.1
 */