package com.tencent.mm.loader.e;

import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
  implements com.tencent.mm.loader.f.g
{
  public final String c(com.tencent.mm.loader.h.a.a<?> parama)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (parama != null)
    {
      localObject1 = localObject2;
      if (!Util.isNullOrNil(parama.toString()))
      {
        localObject1 = com.tencent.mm.b.g.getMessageDigest(parama.toString().getBytes());
        Log.d("MicroMsg.Loader.DefaultFileNameCreator", "create image file name :%s", new Object[] { localObject1 });
      }
    }
    return localObject1;
  }
  
  public final String d(com.tencent.mm.loader.h.a.a<?> parama)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (parama != null)
    {
      localObject1 = localObject2;
      if (!Util.isNullOrNil(parama.toString()))
      {
        localObject1 = com.tencent.mm.b.g.getMessageDigest(parama.toString().getBytes());
        Log.d("MicroMsg.Loader.DefaultFileNameCreator", "create image file name :%s", new Object[] { localObject1 });
      }
    }
    return (String)localObject1 + ".tmp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.e.a
 * JD-Core Version:    0.7.0.1
 */