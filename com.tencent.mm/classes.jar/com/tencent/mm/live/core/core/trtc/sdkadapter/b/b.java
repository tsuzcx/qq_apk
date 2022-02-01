package com.tencent.mm.live.core.core.trtc.sdkadapter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b
{
  Map<String, Map<String, a>> mTA;
  String mTB;
  public List<a> mTz;
  
  private b()
  {
    AppMethodBeat.i(248305);
    this.mTz = new ArrayList();
    this.mTA = new ConcurrentHashMap();
    AppMethodBeat.o(248305);
  }
  
  public final void FS(String paramString)
  {
    AppMethodBeat.i(248327);
    Log.i("MicroMsg.RemoteUserConfigHelper", "removeRemoteUser: target userName:".concat(String.valueOf(paramString)));
    Iterator localIterator = this.mTz.iterator();
    while (localIterator.hasNext()) {
      if (paramString.equals(((a)localIterator.next()).luk))
      {
        Log.i("MicroMsg.RemoteUserConfigHelper", "removeRemoteUser: find userName:" + paramString + ", remove");
        localIterator.remove();
        AppMethodBeat.o(248327);
        return;
      }
    }
    AppMethodBeat.o(248327);
  }
  
  public final void FT(String paramString)
  {
    AppMethodBeat.i(248338);
    Log.i("MicroMsg.RemoteUserConfigHelper", "setCurrentSessionId: sessionId:".concat(String.valueOf(paramString)));
    this.mTB = paramString;
    if (paramString != null)
    {
      Iterator localIterator = this.mTz.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        int i = 0;
        try
        {
          int j = Integer.parseInt(locala.lyn);
          i = j;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          label74:
          break label74;
        }
        a(paramString, locala.luk, i, locala.mTy);
      }
    }
    else
    {
      AppMethodBeat.o(248338);
      return;
    }
  }
  
  public final a FU(String paramString)
  {
    AppMethodBeat.i(248345);
    Iterator localIterator = this.mTz.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (paramString.equals(locala.luk))
      {
        AppMethodBeat.o(248345);
        return locala;
      }
    }
    AppMethodBeat.o(248345);
    return null;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(248319);
    Log.i("MicroMsg.RemoteUserConfigHelper", "addRemoteUser: userName:" + parama.luk);
    this.mTz.add(parama);
    AppMethodBeat.o(248319);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(248352);
    Log.i("MicroMsg.RemoteUserConfigHelper", "updateCacheUserInfoMap: sessionId:" + paramString1 + ", userId:" + paramString2 + ", roomId:" + paramInt + ", isAnchor:" + paramBoolean);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(248352);
      return;
    }
    Object localObject2 = (Map)this.mTA.get(paramString1);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ConcurrentHashMap();
    }
    localObject2 = new a("");
    ((a)localObject2).lyn = String.valueOf(paramInt);
    ((a)localObject2).mTy = paramBoolean;
    ((Map)localObject1).put(paramString2, localObject2);
    this.mTA.put(paramString1, localObject1);
    AppMethodBeat.o(248352);
  }
  
  public static final class a
  {
    private static b mTC;
    
    static
    {
      AppMethodBeat.i(248318);
      mTC = new b((byte)0);
      AppMethodBeat.o(248318);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.sdkadapter.b.b
 * JD-Core Version:    0.7.0.1
 */