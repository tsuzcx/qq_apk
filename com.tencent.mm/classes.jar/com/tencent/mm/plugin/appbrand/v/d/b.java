package com.tencent.mm.plugin.appbrand.v.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.plugin.appbrand.permission.d.c;
import com.tencent.mm.plugin.appbrand.v.a.e;
import com.tencent.mm.plugin.appbrand.v.a.e.a;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class b
  extends e
{
  private d.c tqL;
  
  public b(e.a parama, y paramy)
  {
    super(parama, paramy);
  }
  
  public static void a(Map<String, Object> paramMap, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(321247);
    paramMap.put("fg", paramArrayOfByte1);
    paramMap.put("bg", paramArrayOfByte2);
    AppMethodBeat.o(321247);
  }
  
  public static void c(Map<String, Object> paramMap, Map<String, AppRuntimeApiPermissionBundle> paramMap1)
  {
    AppMethodBeat.i(321251);
    HashMap localHashMap1 = new HashMap();
    paramMap.put("plugins", localHashMap1);
    if ((paramMap1 != null) && (!paramMap1.isEmpty()))
    {
      paramMap = paramMap1.entrySet().iterator();
      while (paramMap.hasNext())
      {
        paramMap1 = (Map.Entry)paramMap.next();
        HashMap localHashMap2 = new HashMap();
        localHashMap2.put("fg", ((AppRuntimeApiPermissionBundle)paramMap1.getValue()).tEj);
        localHashMap2.put("bg", ((AppRuntimeApiPermissionBundle)paramMap1.getValue()).tEk);
        localHashMap1.put((String)paramMap1.getKey(), localHashMap2);
      }
    }
    AppMethodBeat.o(321251);
  }
  
  public final void cCY()
  {
    AppMethodBeat.i(147408);
    com.tencent.mm.plugin.appbrand.permission.d locald = ((com.tencent.luggage.sdk.e.d)this.esk.getRuntime()).evw;
    if (locald == null)
    {
      Log.e("MicroMsg.ProxyOnPermissionUpdateListener", "AppRuntimeApiPermissionController null");
      AppMethodBeat.o(147408);
      return;
    }
    this.tqL = new d.c()
    {
      public final void g(final byte[] paramAnonymousArrayOfByte1, final byte[] paramAnonymousArrayOfByte2)
      {
        AppMethodBeat.i(147407);
        Log.i("MicroMsg.ProxyOnPermissionUpdateListener", "onUpdate");
        paramAnonymousArrayOfByte1 = new HashMap() {};
        b.this.aa(paramAnonymousArrayOfByte1);
        AppMethodBeat.o(147407);
      }
      
      public final void h(final HashMap<String, AppRuntimeApiPermissionBundle> paramAnonymousHashMap)
      {
        AppMethodBeat.i(321250);
        Log.i("MicroMsg.ProxyOnPermissionUpdateListener", "onPluginUpdate");
        if (paramAnonymousHashMap == null)
        {
          AppMethodBeat.o(321250);
          return;
        }
        paramAnonymousHashMap = new HashMap() {};
        b.this.aa(paramAnonymousHashMap);
        AppMethodBeat.o(321250);
      }
    };
    d.c localc = this.tqL;
    synchronized (locald.tEr)
    {
      locald.tEx.add(localc);
      AppMethodBeat.o(147408);
      return;
    }
  }
  
  public final int getType()
  {
    return 3;
  }
  
  public final void removeListener()
  {
    AppMethodBeat.i(147409);
    if (this.tqL == null)
    {
      AppMethodBeat.o(147409);
      return;
    }
    if (this.esk.getRuntime() == null)
    {
      AppMethodBeat.o(147409);
      return;
    }
    com.tencent.mm.plugin.appbrand.permission.d locald = ((com.tencent.luggage.sdk.e.d)this.esk.getRuntime()).evw;
    if (locald == null)
    {
      AppMethodBeat.o(147409);
      return;
    }
    d.c localc = this.tqL;
    synchronized (locald.tEr)
    {
      locald.tEx.remove(localc);
      AppMethodBeat.o(147409);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.d.b
 * JD-Core Version:    0.7.0.1
 */