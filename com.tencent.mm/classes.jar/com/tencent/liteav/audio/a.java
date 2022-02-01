package com.tencent.liteav.audio;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class a
{
  private HashMap<String, HashSet<Integer>> a;
  
  private a()
  {
    AppMethodBeat.i(230396);
    this.a = new HashMap();
    AppMethodBeat.o(230396);
  }
  
  public static a a()
  {
    AppMethodBeat.i(230392);
    a locala = a.a();
    AppMethodBeat.o(230392);
    return locala;
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(230435);
    Object localObject1 = new HashSet();
    Object localObject2 = this.a.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
      String str = (String)((Map.Entry)localObject3).getKey();
      localObject3 = (HashSet)((Map.Entry)localObject3).getValue();
      ((HashSet)localObject3).remove(Integer.valueOf(paramInt));
      if (((HashSet)localObject3).isEmpty())
      {
        ((HashSet)localObject1).add(str);
        TXCAudioEngine.getInstance().stopRemoteAudio(str);
        TXCLog.i("AudioPlayManager", "stopPlay, tinyId:".concat(String.valueOf(str)));
      }
    }
    localObject1 = ((HashSet)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      this.a.remove(localObject2);
    }
    AppMethodBeat.o(230435);
  }
  
  public void a(String paramString, int paramInt)
  {
    AppMethodBeat.i(16271);
    HashSet localHashSet = (HashSet)this.a.get(paramString);
    if (localHashSet == null)
    {
      AppMethodBeat.o(16271);
      return;
    }
    localHashSet.remove(Integer.valueOf(paramInt));
    if (localHashSet.isEmpty())
    {
      this.a.remove(paramString);
      TXCAudioEngine.getInstance().stopRemoteAudio(paramString);
      TXCLog.i("AudioPlayManager", "stopRemoteAudio. tinyId:" + paramString + ", sessionId:" + paramInt);
      AppMethodBeat.o(16271);
      return;
    }
    TXCLog.i("AudioPlayManager", "ignore stopRemoteAudio. because the same user is playing in other session. tinyId:" + paramString + ", cur sessionId:" + paramInt + ", other sessionId:" + ((Integer)localHashSet.iterator().next()).intValue());
    AppMethodBeat.o(16271);
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(230414);
    HashSet localHashSet2 = (HashSet)this.a.get(paramString);
    HashSet localHashSet1 = localHashSet2;
    if (localHashSet2 == null)
    {
      localHashSet1 = new HashSet();
      this.a.put(paramString, localHashSet1);
    }
    localHashSet1.add(Integer.valueOf(paramInt));
    TXCAudioEngine.getInstance().startRemoteAudio(paramString, paramBoolean);
    TXCLog.i("AudioPlayManager", "startRemoteAudio tinyId:" + paramString + ", sessionId:" + paramInt);
    AppMethodBeat.o(230414);
  }
  
  static class a
  {
    private static final a a;
    
    static
    {
      AppMethodBeat.i(230354);
      a = new a(null);
      AppMethodBeat.o(230354);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.audio.a
 * JD-Core Version:    0.7.0.1
 */