package com.tencent.mm.plugin.brandservice;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

public final class a
  implements n
{
  public static m eUR;
  public static l eUS;
  
  public static void g(int paramInt, Object paramObject)
  {
    if (paramObject == null) {}
    for (String str = "null";; str = paramObject.toString())
    {
      y.i("MicroMsg.BrandService.BrandServiceApplication", "set config, key[%d], value[%s]", new Object[] { Integer.valueOf(paramInt), str });
      g.DQ();
      g.DP().Dz().o(paramInt, paramObject);
      return;
    }
  }
  
  public final void a(l paraml)
  {
    eUS = paraml;
  }
  
  public final void a(m paramm)
  {
    eUR = paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.a
 * JD-Core Version:    0.7.0.1
 */