package com.tencent.mm.audio.mix.b.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.d;
import com.tencent.mm.audio.mix.h.b;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
  implements f
{
  private String appId;
  private String filePath;
  
  public a(String paramString1, String paramString2)
  {
    this.appId = paramString1;
    this.filePath = paramString2;
  }
  
  public final void aFi()
  {
    AppMethodBeat.i(136749);
    b.i("MicroMsg.Mix.AudioPcmDataTrackCacheToFileTask", "runTask, appId:%s", new Object[] { this.appId });
    Object localObject2;
    Object localObject1;
    int i;
    if (TextUtils.isEmpty(this.filePath))
    {
      b.i("MicroMsg.Mix.AudioPcmDataTrackCacheToFileTask", "cache to file task");
      localObject2 = com.tencent.mm.audio.mix.b.f.aFr().aFt();
      if (((ArrayList)localObject2).size() > 0)
      {
        localObject1 = "";
        Iterator localIterator = ((ArrayList)localObject2).iterator();
        i = 0;
        while (localIterator.hasNext())
        {
          localObject2 = (String)localIterator.next();
          d locald = com.tencent.mm.audio.mix.b.f.aFr().iR((String)localObject2);
          if ((locald == null) || (!locald.ckB) || (!locald.hqO))
          {
            int j = com.tencent.mm.audio.mix.b.f.aFr().iS((String)localObject2);
            if (j < i) {
              break label291;
            }
            i = j;
            localObject1 = localObject2;
          }
        }
      }
    }
    label291:
    for (;;)
    {
      break;
      localObject2 = com.tencent.mm.audio.mix.b.f.aFr().iR((String)localObject1);
      if ((localObject2 != null) && (((d)localObject2).ckB) && (!((d)localObject2).hqO)) {
        ((d)localObject2).iN(this.appId);
      }
      b.i("MicroMsg.Mix.AudioPcmDataTrackCacheToFileTask", "cache to file path :%s, size:%d", new Object[] { localObject1, Integer.valueOf(i) });
      AppMethodBeat.o(136749);
      return;
      i = com.tencent.mm.audio.mix.b.f.aFr().iS(this.filePath);
      b.i("MicroMsg.Mix.AudioPcmDataTrackCacheToFileTask", "cache to file path :%s, size:%d", new Object[] { this.filePath, Integer.valueOf(i) });
      localObject1 = com.tencent.mm.audio.mix.b.f.aFr().iR(this.filePath);
      if ((localObject1 != null) && (((d)localObject1).ckB) && (!((d)localObject1).hqO)) {
        ((d)localObject1).iN(this.appId);
      }
      AppMethodBeat.o(136749);
      return;
    }
  }
  
  public final void end() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.b.a.a
 * JD-Core Version:    0.7.0.1
 */