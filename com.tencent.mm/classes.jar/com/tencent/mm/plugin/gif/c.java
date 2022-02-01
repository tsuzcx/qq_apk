package com.tencent.mm.plugin.gif;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.b.f.b;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

public class c
{
  private static c DmP;
  f<String, WeakReference<e>> DmQ;
  f<String, WeakReference<b>> DmR;
  
  public c()
  {
    AppMethodBeat.i(104585);
    this.DmQ = new com.tencent.mm.memory.a.c(10);
    this.DmR = new com.tencent.mm.memory.a.c(new f.b() {});
    AppMethodBeat.o(104585);
  }
  
  /* Error */
  public static c eAV()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 45
    //   5: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 47	com/tencent/mm/plugin/gif/c:DmP	Lcom/tencent/mm/plugin/gif/c;
    //   11: ifnonnull +25 -> 36
    //   14: ldc 2
    //   16: monitorenter
    //   17: getstatic 47	com/tencent/mm/plugin/gif/c:DmP	Lcom/tencent/mm/plugin/gif/c;
    //   20: ifnonnull +13 -> 33
    //   23: new 2	com/tencent/mm/plugin/gif/c
    //   26: dup
    //   27: invokespecial 48	com/tencent/mm/plugin/gif/c:<init>	()V
    //   30: putstatic 47	com/tencent/mm/plugin/gif/c:DmP	Lcom/tencent/mm/plugin/gif/c;
    //   33: ldc 2
    //   35: monitorexit
    //   36: getstatic 47	com/tencent/mm/plugin/gif/c:DmP	Lcom/tencent/mm/plugin/gif/c;
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
    //   3	17	61	finally
    //   36	45	61	finally
    //   51	61	61	finally
  }
  
  public final b aKR(String paramString)
  {
    AppMethodBeat.i(104587);
    b localb = null;
    if (this.DmR.get(paramString) != null) {
      localb = (b)((WeakReference)this.DmR.get(paramString)).get();
    }
    AppMethodBeat.o(104587);
    return localb;
  }
  
  public final b c(Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(104589);
    if (this.DmR.get(null) != null) {}
    for (b localb = (b)((WeakReference)this.DmR.get(null)).get();; localb = null)
    {
      Object localObject = localb;
      if (localb == null)
      {
        localObject = new d(paramResources, paramInt);
        this.DmR.put(null, new WeakReference(localObject));
      }
      AppMethodBeat.o(104589);
      return localObject;
    }
  }
  
  public final b ic(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104588);
    b localb = null;
    if (this.DmR.get(paramString1) != null) {
      localb = (b)((WeakReference)this.DmR.get(paramString1)).get();
    }
    Object localObject = localb;
    long l;
    if (localb == null)
    {
      l = System.currentTimeMillis();
      if (!ImgUtil.isWXGF(paramString2)) {
        break label123;
      }
    }
    label123:
    for (paramString2 = new h(paramString2);; paramString2 = new d(paramString2))
    {
      Log.d("MicroMsg.GIF.MMAnimateDrawableCacheMgr", "new MMAnimateDrawable use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      this.DmR.put(paramString1, new WeakReference(paramString2));
      localObject = paramString2;
      AppMethodBeat.o(104588);
      return localObject;
    }
  }
  
  public final b v(String paramString, byte[] paramArrayOfByte)
  {
    b localb = null;
    AppMethodBeat.i(104590);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(104590);
      return null;
    }
    if (this.DmR.get(paramString) != null) {
      localb = (b)((WeakReference)this.DmR.get(paramString)).get();
    }
    Object localObject = localb;
    if (localb == null) {
      if ((!ImgUtil.isWXGF(paramArrayOfByte)) || (!((PluginEmoji)com.tencent.mm.kernel.h.ag(PluginEmoji.class)).getEmojiMgr().cUw())) {
        break label136;
      }
    }
    label136:
    for (paramArrayOfByte = new h(paramArrayOfByte);; paramArrayOfByte = new d(paramArrayOfByte))
    {
      this.DmR.put(paramString, new WeakReference(paramArrayOfByte));
      localObject = paramArrayOfByte;
      if (!((b)localObject).isRunning()) {
        ((b)localObject).reset();
      }
      AppMethodBeat.o(104590);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.c
 * JD-Core Version:    0.7.0.1
 */