package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.a;
import com.tencent.mm.f.b.a.av;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.video.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.vfs.u;

final class r$2
  implements Runnable
{
  r$2(r paramr, String paramString1, String[] paramArrayOfString, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, long paramLong1, long paramLong2, int paramInt2, int paramInt3, String paramString6) {}
  
  public final void run()
  {
    AppMethodBeat.i(126915);
    b localb = com.tencent.mm.plugin.sight.base.f.aYg(this.val$path);
    if (localb == null)
    {
      Log.w("MicroMsg.SubCoreMediaRpt", "get media info is null. %s", new Object[] { this.val$path });
      AppMethodBeat.o(126915);
      return;
    }
    int j = (int)u.bBQ(this.val$path);
    Object localObject1 = null;
    if (this.mhe != null)
    {
      localObject1 = new StringBuffer();
      localObject2 = this.mhe;
      int k = localObject2.length;
      i = 0;
      while (i < k)
      {
        ((StringBuffer)localObject1).append(localObject2[i]).append("|");
        i += 1;
      }
      localObject1 = ((StringBuffer)localObject1).toString();
    }
    int i = NetStatusUtil.getIOSOldNetType(MMApplicationContext.getContext());
    com.tencent.mm.aq.f.bkh();
    Object localObject2 = a.Vu(this.val$path);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.lrl).append(",").append(this.mhf).append(",");
    localStringBuffer.append(this.mhg).append(",").append(this.mhh).append(",");
    localStringBuffer.append(this.mhi).append(",").append(i).append(",");
    localStringBuffer.append((String)localObject2).append(",").append(this.val$startTime).append(",");
    localStringBuffer.append(this.mhj).append(",").append(j).append(",");
    localStringBuffer.append(localb.videoDuration).append(",").append(localb.videoBitrate / 1000).append(",");
    localStringBuffer.append(localb.audioBitrate / 1000).append(",").append(localb.frameRate).append(",");
    localStringBuffer.append(localb.width).append(",").append(localb.height).append(",");
    localStringBuffer.append((String)localObject1).append(",").append(localb.audioChannel).append(",");
    localStringBuffer.append(this.mhk).append(",").append(this.mhl).append(",");
    localStringBuffer.append(c.bfp(this.mhm));
    Log.i("MicroMsg.SubCoreMediaRpt", "download video rpt %s ", new Object[] { localStringBuffer.toString() });
    new av(localStringBuffer.toString()).bpa();
    AppMethodBeat.o(126915);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.r.2
 * JD-Core Version:    0.7.0.1
 */