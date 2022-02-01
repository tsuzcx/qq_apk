package com.tencent.mm.loader.d;

import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
  implements com.tencent.mm.loader.e.g
{
  public final String e(com.tencent.mm.loader.g.a.a<?> parama)
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
  
  public final String f(com.tencent.mm.loader.g.a.a<?> parama)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.d.a
 * JD-Core Version:    0.7.0.1
 */