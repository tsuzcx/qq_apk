package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.al.f;
import com.tencent.mm.g.b.a.k;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.plugin.video.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;

final class n$2
  implements Runnable
{
  n$2(n paramn, String paramString1, String[] paramArrayOfString, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, long paramLong1, long paramLong2, int paramInt2, int paramInt3, String paramString6) {}
  
  public final void run()
  {
    AppMethodBeat.i(50753);
    com.tencent.mm.plugin.sight.base.a locala = d.Zo(this.val$path);
    if (locala == null)
    {
      ab.w("MicroMsg.SubCoreMediaRpt", "get media info is null. %s", new Object[] { this.val$path });
      AppMethodBeat.o(50753);
      return;
    }
    int j = e.cM(this.val$path);
    Object localObject1 = null;
    if (this.fWK != null)
    {
      localObject1 = new StringBuffer();
      localObject2 = this.fWK;
      int k = localObject2.length;
      i = 0;
      while (i < k)
      {
        ((StringBuffer)localObject1).append(localObject2[i]).append("|");
        i += 1;
      }
      localObject1 = ((StringBuffer)localObject1).toString();
    }
    int i = at.gW(ah.getContext());
    f.afP();
    Object localObject2 = com.tencent.mm.al.a.sE(this.val$path);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.fkI).append(",").append(this.fWL).append(",");
    localStringBuffer.append(this.fWM).append(",").append(this.fWN).append(",");
    localStringBuffer.append(this.fWO).append(",").append(i).append(",");
    localStringBuffer.append((String)localObject2).append(",").append(this.fET).append(",");
    localStringBuffer.append(this.fWP).append(",").append(j).append(",");
    localStringBuffer.append(locala.eVA).append(",").append(locala.videoBitrate / 1000).append(",");
    localStringBuffer.append(locala.fzT / 1000).append(",").append(locala.eRw).append(",");
    localStringBuffer.append(locala.width).append(",").append(locala.height).append(",");
    localStringBuffer.append((String)localObject1).append(",").append(locala.qSh).append(",");
    localStringBuffer.append(this.fWQ).append(",").append(this.fWR).append(",");
    localStringBuffer.append(c.aeA(this.fWS));
    ab.i("MicroMsg.SubCoreMediaRpt", "download video rpt %s ", new Object[] { localStringBuffer.toString() });
    new k(localStringBuffer.toString()).ake();
    AppMethodBeat.o(50753);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.n.2
 * JD-Core Version:    0.7.0.1
 */