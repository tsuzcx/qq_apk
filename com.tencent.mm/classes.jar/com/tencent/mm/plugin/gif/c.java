package com.tencent.mm.plugin.gif;

import com.tencent.mm.a.f;
import com.tencent.mm.a.f.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

public class c
{
  private static c lhB;
  public f<String, WeakReference<e>> lhC = new f(10);
  f<String, WeakReference<b>> lhD = new f(10, new f.b() {});
  
  /* Error */
  public static c baM()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 37	com/tencent/mm/plugin/gif/c:lhB	Lcom/tencent/mm/plugin/gif/c;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 37	com/tencent/mm/plugin/gif/c:lhB	Lcom/tencent/mm/plugin/gif/c;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	com/tencent/mm/plugin/gif/c
    //   21: dup
    //   22: invokespecial 38	com/tencent/mm/plugin/gif/c:<init>	()V
    //   25: putstatic 37	com/tencent/mm/plugin/gif/c:lhB	Lcom/tencent/mm/plugin/gif/c;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 37	com/tencent/mm/plugin/gif/c:lhB	Lcom/tencent/mm/plugin/gif/c;
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: areturn
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	5	0	localc	c
    //   40	5	0	localObject1	Object
    //   46	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	28	40	finally
    //   28	31	40	finally
    //   41	44	40	finally
    //   3	12	46	finally
    //   31	35	46	finally
    //   44	46	46	finally
  }
  
  public final b Fi(String paramString)
  {
    b localb = null;
    if (this.lhD.get(paramString) != null) {
      localb = (b)((WeakReference)this.lhD.get(paramString)).get();
    }
    return localb;
  }
  
  public final b dt(String paramString1, String paramString2)
  {
    b localb = null;
    if (this.lhD.get(paramString1) != null) {
      localb = (b)((WeakReference)this.lhD.get(paramString1)).get();
    }
    Object localObject = localb;
    long l;
    if (localb == null)
    {
      l = System.currentTimeMillis();
      if (!o.Zb(paramString2)) {
        break label107;
      }
    }
    label107:
    for (paramString2 = new h(paramString2);; paramString2 = new d(paramString2))
    {
      y.d("MicroMsg.GIF.MMAnimateDrawableCacheMgr", "new MMAnimateDrawable use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      this.lhD.put(paramString1, new WeakReference(paramString2));
      localObject = paramString2;
      return localObject;
    }
  }
  
  public final b p(String paramString, byte[] paramArrayOfByte)
  {
    b localb = null;
    Object localObject = null;
    if (paramArrayOfByte == null)
    {
      paramString = (String)localObject;
      return paramString;
    }
    if (this.lhD.get(paramString) != null) {
      localb = (b)((WeakReference)this.lhD.get(paramString)).get();
    }
    localObject = localb;
    if (localb == null) {
      if ((!o.bz(paramArrayOfByte)) || (!((PluginEmoji)g.t(PluginEmoji.class)).getEmojiMgr().aHs())) {
        break label118;
      }
    }
    label118:
    for (localObject = new h(paramArrayOfByte);; localObject = new d(paramArrayOfByte))
    {
      this.lhD.put(paramString, new WeakReference(localObject));
      paramString = (String)localObject;
      if (((b)localObject).isRunning()) {
        break;
      }
      ((b)localObject).reset();
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.c
 * JD-Core Version:    0.7.0.1
 */