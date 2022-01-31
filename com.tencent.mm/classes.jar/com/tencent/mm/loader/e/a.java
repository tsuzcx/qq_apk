package com.tencent.mm.loader.e;

import com.tencent.mm.a.g;
import com.tencent.mm.loader.f.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class a
  implements f
{
  public final String b(com.tencent.mm.loader.h.a.a<?> parama)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (parama != null)
    {
      localObject1 = localObject2;
      if (!bo.isNullOrNil(parama.toString()))
      {
        localObject1 = g.w(parama.toString().getBytes());
        ab.d("MicroMsg.Loader.DefaultFileNameCreator", "create image file name :%s", new Object[] { localObject1 });
      }
    }
    return localObject1;
  }
  
  public final String c(com.tencent.mm.loader.h.a.a<?> parama)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (parama != null)
    {
      localObject1 = localObject2;
      if (!bo.isNullOrNil(parama.toString()))
      {
        localObject1 = g.w(parama.toString().getBytes());
        ab.d("MicroMsg.Loader.DefaultFileNameCreator", "create image file name :%s", new Object[] { localObject1 });
      }
    }
    return (String)localObject1 + ".tmp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.loader.e.a
 * JD-Core Version:    0.7.0.1
 */