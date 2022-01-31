package com.tencent.mm.plugin.cdndownloader.c;

import com.tencent.mm.j.d;
import com.tencent.mm.j.f;
import com.tencent.mm.j.f.b;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class a$3
  implements Runnable
{
  a$3(a parama, String paramString, d paramd) {}
  
  public final void run()
  {
    f localf = (f)a.d(this.iAt).get(this.BF);
    if (localf == null) {
      y.e("MicroMsg.CdnDownloadNativeService", " task in jni get info failed mediaid:%s", new Object[] { this.BF });
    }
    while (localf.dmc == null) {
      return;
    }
    localf.dmc.a(this.BF, this.eiR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.c.a.3
 * JD-Core Version:    0.7.0.1
 */