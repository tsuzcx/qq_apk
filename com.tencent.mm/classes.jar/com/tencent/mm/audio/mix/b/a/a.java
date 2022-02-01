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
  
  public final void adj()
  {
    AppMethodBeat.i(136749);
    b.i("MicroMsg.Mix.AudioPcmDataTrackCacheToFileTask", "runTask, appId:%s", new Object[] { this.appId });
    Object localObject2;
    Object localObject1;
    int i;
    if (TextUtils.isEmpty(this.filePath))
    {
      b.i("MicroMsg.Mix.AudioPcmDataTrackCacheToFileTask", "cache to file task");
      localObject2 = com.tencent.mm.audio.mix.b.f.ads().adu();
      if (((ArrayList)localObject2).size() > 0)
      {
        localObject1 = "";
        Iterator localIterator = ((ArrayList)localObject2).iterator();
        i = 0;
        while (localIterator.hasNext())
        {
          localObject2 = (String)localIterator.next();
          d locald = com.tencent.mm.audio.mix.b.f.ads().hq((String)localObject2);
          if ((locald == null) || (!locald.awf) || (!locald.fmD))
          {
            int j = com.tencent.mm.audio.mix.b.f.ads().hr((String)localObject2);
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
      localObject2 = com.tencent.mm.audio.mix.b.f.ads().hq((String)localObject1);
      if ((localObject2 != null) && (((d)localObject2).awf) && (!((d)localObject2).fmD)) {
        ((d)localObject2).hm(this.appId);
      }
      b.i("MicroMsg.Mix.AudioPcmDataTrackCacheToFileTask", "cache to file path :%s, size:%d", new Object[] { localObject1, Integer.valueOf(i) });
      AppMethodBeat.o(136749);
      return;
      i = com.tencent.mm.audio.mix.b.f.ads().hr(this.filePath);
      b.i("MicroMsg.Mix.AudioPcmDataTrackCacheToFileTask", "cache to file path :%s, size:%d", new Object[] { this.filePath, Integer.valueOf(i) });
      localObject1 = com.tencent.mm.audio.mix.b.f.ads().hq(this.filePath);
      if ((localObject1 != null) && (((d)localObject1).awf) && (!((d)localObject1).fmD)) {
        ((d)localObject1).hm(this.appId);
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