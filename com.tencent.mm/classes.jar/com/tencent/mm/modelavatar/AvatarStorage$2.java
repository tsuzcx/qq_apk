package com.tencent.mm.modelavatar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class AvatarStorage$2
  implements AvatarStorage.a
{
  AvatarStorage$2(AvatarStorage paramAvatarStorage) {}
  
  public final void LM(String paramString)
  {
    AppMethodBeat.i(150238);
    Log.d("MicroMsg.AvatarStorage", "notifyChanged user:%s clonesize:%d watchers:%d", new Object[] { paramString, Integer.valueOf(AvatarStorage.a(this.osi).size()), Integer.valueOf(AvatarStorage.a(this.osi).size()) });
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      Iterator localIterator;
      synchronized (AvatarStorage.a(this.osi))
      {
        localIterator = AvatarStorage.a(this.osi).iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        Object localObject2 = (WeakReference)localIterator.next();
        if (localObject2 == null) {
          continue;
        }
        localObject2 = (AvatarStorage.a)((WeakReference)localObject2).get();
        if (localObject2 != null) {
          localArrayList.add(localObject2);
        }
      }
      localIterator.remove();
    }
    ??? = localArrayList.iterator();
    while (((Iterator)???).hasNext()) {
      ((AvatarStorage.a)((Iterator)???).next()).LM(paramString);
    }
    AppMethodBeat.o(150238);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelavatar.AvatarStorage.2
 * JD-Core Version:    0.7.0.1
 */