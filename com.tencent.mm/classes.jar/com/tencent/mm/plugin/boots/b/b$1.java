package com.tencent.mm.plugin.boots.b;

import com.tencent.mm.plugin.downloader.model.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.Vector;

final class b$1
  implements k
{
  b$1(b paramb) {}
  
  public final void b(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (this.hXV.hXT.contains(Long.valueOf(paramLong)))
    {
      y.i("MicroMsg.Boots.LuggageLogic", "onTaskFailed id:%d errCode:%d hasChangeUrl", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
      this.hXV.hXT.remove(Long.valueOf(paramLong));
    }
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    if (this.hXV.hXT.contains(Long.valueOf(paramLong)))
    {
      y.i("MicroMsg.Boots.LuggageLogic", "onTaskStarted id:%d path:%s", new Object[] { Long.valueOf(paramLong), paramString });
      this.hXV.hXT.remove(Long.valueOf(paramLong));
      if (new c(ae.getContext()).B(new File(paramString))) {
        y.i("MicroMsg.Boots.LuggageLogic", "check file success.");
      }
    }
    else
    {
      return;
    }
    y.w("MicroMsg.Boots.LuggageLogic", "check file failed.");
  }
  
  public final void cy(long paramLong) {}
  
  public final void cz(long paramLong) {}
  
  public final void k(long paramLong, String paramString) {}
  
  public final void onTaskPaused(long paramLong) {}
  
  public final void onTaskRemoved(long paramLong)
  {
    if (this.hXV.hXT.contains(Long.valueOf(paramLong)))
    {
      y.i("MicroMsg.Boots.LuggageLogic", "onTaskRemoved id:%d", new Object[] { Long.valueOf(paramLong) });
      this.hXV.hXT.remove(Long.valueOf(paramLong));
    }
  }
  
  public final void onTaskStarted(long paramLong, String paramString)
  {
    if (this.hXV.hXT.contains(Long.valueOf(paramLong))) {
      y.i("MicroMsg.Boots.LuggageLogic", "onTaskStarted id:%d path:%s", new Object[] { Long.valueOf(paramLong), paramString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.boots.b.b.1
 * JD-Core Version:    0.7.0.1
 */