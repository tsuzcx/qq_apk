package com.tencent.mm.plugin.brandservice.ui.timeline.a.c;

import com.tencent.mm.ck.g;
import com.tencent.mm.protocal.c.bxx;
import com.tencent.mm.protocal.c.bxy;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

final class f$1
  implements Runnable
{
  f$1(f paramf, bxy parambxy) {}
  
  public final void run()
  {
    y.i("MicroMsg.Preload.TmplDownloader", "Type:%d Version:%d CdnUrl:%s  start download md5:%s", new Object[] { Integer.valueOf(this.iiH.type), Integer.valueOf(this.iiH.hQQ), this.iiH.sND, this.iiH.jnU });
    int i = this.iiH.type;
    int j = this.iiH.hQQ;
    String str = this.iiH.jnU;
    str = this.iiH.sND;
    int k = this.iiH.sNE;
    boolean bool = this.iiH.tNU;
    HashMap localHashMap = new HashMap();
    Object localObject = this.iiH.tNT.iterator();
    while (((Iterator)localObject).hasNext())
    {
      bxx localbxx = (bxx)((Iterator)localObject).next();
      if ((!bk.bl(localbxx.sCH)) && (!bk.bl(localbxx.nFs))) {
        localHashMap.put(localbxx.sCH, localbxx.nFs);
      }
    }
    localObject = this.iiH.tNV;
    k = this.iiH.tFj;
    g.cNB().h(new f.1.2(this, bool, str, localHashMap)).g(new f.1.1(this, i, j, (String)localObject, k, localHashMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.c.f.1
 * JD-Core Version:    0.7.0.1
 */