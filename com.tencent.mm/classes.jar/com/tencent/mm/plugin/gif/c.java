package com.tencent.mm.plugin.gif;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.a.f.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.r;
import java.lang.ref.WeakReference;

public class c
{
  private static c nEX;
  f<String, WeakReference<e>> nEY;
  f<String, WeakReference<b>> nEZ;
  
  public c()
  {
    AppMethodBeat.i(62352);
    this.nEY = new com.tencent.mm.memory.a.c(10);
    this.nEZ = new com.tencent.mm.memory.a.c(new f.b() {});
    AppMethodBeat.o(62352);
  }
  
  /* Error */
  public static c bHK()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 45
    //   5: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 47	com/tencent/mm/plugin/gif/c:nEX	Lcom/tencent/mm/plugin/gif/c;
    //   11: ifnonnull +25 -> 36
    //   14: ldc 2
    //   16: monitorenter
    //   17: getstatic 47	com/tencent/mm/plugin/gif/c:nEX	Lcom/tencent/mm/plugin/gif/c;
    //   20: ifnonnull +13 -> 33
    //   23: new 2	com/tencent/mm/plugin/gif/c
    //   26: dup
    //   27: invokespecial 48	com/tencent/mm/plugin/gif/c:<init>	()V
    //   30: putstatic 47	com/tencent/mm/plugin/gif/c:nEX	Lcom/tencent/mm/plugin/gif/c;
    //   33: ldc 2
    //   35: monitorexit
    //   36: getstatic 47	com/tencent/mm/plugin/gif/c:nEX	Lcom/tencent/mm/plugin/gif/c;
    //   39: astore_0
    //   40: ldc 45
    //   42: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: ldc 2
    //   47: monitorexit
    //   48: aload_0
    //   49: areturn
    //   50: astore_0
    //   51: ldc 2
    //   53: monitorexit
    //   54: ldc 45
    //   56: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aload_0
    //   60: athrow
    //   61: astore_0
    //   62: ldc 2
    //   64: monitorexit
    //   65: aload_0
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   39	10	0	localc	c
    //   50	10	0	localObject1	Object
    //   61	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   17	33	50	finally
    //   33	36	50	finally
    //   51	54	50	finally
    //   3	17	61	finally
    //   36	45	61	finally
    //   54	61	61	finally
  }
  
  public final b QG(String paramString)
  {
    AppMethodBeat.i(62354);
    b localb = null;
    if (this.nEZ.get(paramString) != null) {
      localb = (b)((WeakReference)this.nEZ.get(paramString)).get();
    }
    AppMethodBeat.o(62354);
    return localb;
  }
  
  public final b c(Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(62356);
    if (this.nEZ.get(null) != null) {}
    for (b localb = (b)((WeakReference)this.nEZ.get(null)).get();; localb = null)
    {
      Object localObject = localb;
      if (localb == null)
      {
        localObject = new d(paramResources, paramInt);
        this.nEZ.put(null, new WeakReference(localObject));
      }
      AppMethodBeat.o(62356);
      return localObject;
    }
  }
  
  public final b eK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(62355);
    b localb = null;
    if (this.nEZ.get(paramString1) != null) {
      localb = (b)((WeakReference)this.nEZ.get(paramString1)).get();
    }
    Object localObject = localb;
    long l;
    if (localb == null)
    {
      l = System.currentTimeMillis();
      if (!r.aoZ(paramString2)) {
        break label123;
      }
    }
    label123:
    for (paramString2 = new h(paramString2);; paramString2 = new d(paramString2))
    {
      ab.d("MicroMsg.GIF.MMAnimateDrawableCacheMgr", "new MMAnimateDrawable use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      this.nEZ.put(paramString1, new WeakReference(paramString2));
      localObject = paramString2;
      AppMethodBeat.o(62355);
      return localObject;
    }
  }
  
  public final b x(String paramString, byte[] paramArrayOfByte)
  {
    b localb = null;
    AppMethodBeat.i(62357);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(62357);
      return null;
    }
    if (this.nEZ.get(paramString) != null) {
      localb = (b)((WeakReference)this.nEZ.get(paramString)).get();
    }
    Object localObject = localb;
    if (localb == null) {
      if ((!r.bX(paramArrayOfByte)) || (!((PluginEmoji)g.G(PluginEmoji.class)).getEmojiMgr().ble())) {
        break label136;
      }
    }
    label136:
    for (paramArrayOfByte = new h(paramArrayOfByte);; paramArrayOfByte = new d(paramArrayOfByte))
    {
      this.nEZ.put(paramString, new WeakReference(paramArrayOfByte));
      localObject = paramArrayOfByte;
      if (!((b)localObject).isRunning()) {
        ((b)localObject).reset();
      }
      AppMethodBeat.o(62357);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.c
 * JD-Core Version:    0.7.0.1
 */