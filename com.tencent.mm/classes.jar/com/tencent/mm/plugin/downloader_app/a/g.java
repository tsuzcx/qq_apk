package com.tencent.mm.plugin.downloader_app.a;

import android.content.pm.PackageInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.c.a.a.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class g
{
  public com.tencent.mm.plugin.downloader.c.a.a.b oLt;
  private Map<String, i> oLu;
  private LinkedList<i> oLv;
  public f oLw;
  private String oLx;
  
  public g(com.tencent.mm.plugin.downloader.c.a.a.b paramb)
  {
    AppMethodBeat.i(8896);
    this.oLu = new HashMap();
    this.oLv = new LinkedList();
    this.oLx = "";
    if (paramb == null)
    {
      this.oLt = new com.tencent.mm.plugin.downloader.c.a.a.b();
      AppMethodBeat.o(8896);
      return;
    }
    this.oLt = paramb;
    WJ();
    AppMethodBeat.o(8896);
  }
  
  public g(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(8897);
    this.oLu = new HashMap();
    this.oLv = new LinkedList();
    this.oLx = "";
    this.oLt = new com.tencent.mm.plugin.downloader.c.a.a.b();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(8897);
      return;
    }
    try
    {
      this.oLt.parseFrom(paramArrayOfByte);
      WJ();
      AppMethodBeat.o(8897);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        ac.e("MicroMsg.PBAppInfo", "Parsing Failed: %s", new Object[] { paramArrayOfByte.getMessage() });
      }
    }
  }
  
  private void WJ()
  {
    AppMethodBeat.i(8898);
    this.oLw = this.oLt.oFZ;
    if (bs.gY(this.oLt.oFY))
    {
      AppMethodBeat.o(8898);
      return;
    }
    Iterator localIterator = this.oLt.oFY.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.downloader.c.a.a.d locald = (com.tencent.mm.plugin.downloader.c.a.a.d)localIterator.next();
      if ((locald.oGb.oHm == null) || (locald.oGb.oHm.oHb == null))
      {
        ac.e("MicroMsg.PBAppInfo", "download info is null, appid:%s", new Object[] { locald.oGb.oHk.djj });
      }
      else
      {
        i locali = new i();
        locali.appId = locald.oGb.oHk.djj;
        locali.appName = locald.oGb.oHk.oGM;
        locali.iconUrl = locald.oGb.oHk.oGN;
        locali.packageName = locald.oGb.oHm.oHb.oGB;
        locali.oLD = locald.oGb.oHm.oHb;
        Object localObject;
        if (locald.oGd != null)
        {
          localObject = locald.oGd.oGa;
          label219:
          locali.jumpUrl = ((String)localObject);
          if (!bs.isNullOrNil(locali.jumpUrl)) {
            this.oLx = locali.jumpUrl;
          }
          locali.oLB = locald.oGb.oHm.oHb.oGJ;
          locali.oLF = locald.oGb.oHo;
          if (j.WW(locald.oGb.oHk.djj) != k.UN_INSTALLED) {
            break label326;
          }
          locali.type = 2;
        }
        for (;;)
        {
          this.oLu.put(locali.appId, locali);
          break;
          localObject = "";
          break label219;
          label326:
          localObject = com.tencent.mm.plugin.appbrand.z.b.getPackageInfo(ai.getContext(), locald.oGb.oHm.oHb.oGB);
          if ((localObject != null) && (((PackageInfo)localObject).versionCode < locald.oGb.oHm.oHb.oGF)) {
            locali.type = 4;
          } else {
            locali.type = 6;
          }
        }
      }
    }
    AppMethodBeat.o(8898);
  }
  
  public final LinkedList<i> U(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(8900);
    this.oLv.clear();
    if (!bs.gY(paramLinkedList))
    {
      paramLinkedList = paramLinkedList.iterator();
      int i = 0;
      int k = 0;
      int j = 0;
      if (paramLinkedList.hasNext())
      {
        Object localObject = (String)paramLinkedList.next();
        localObject = (i)this.oLu.get(localObject);
        int m = i;
        int n = k;
        int i1 = j;
        if (localObject != null)
        {
          m = i;
          n = k;
          i1 = j;
          switch (((i)localObject).type)
          {
          default: 
            i1 = j;
            n = k;
            m = i;
          }
        }
        for (;;)
        {
          this.oLv.add(localObject);
          i = m;
          k = n;
          j = i1;
          break;
          i1 = j + 1;
          ((i)localObject).position = i1;
          m = i;
          n = k;
          continue;
          n = k + 1;
          ((i)localObject).position = n;
          m = i;
          i1 = j;
          continue;
          m = i + 1;
          ((i)localObject).position = m;
          n = k;
          i1 = j;
        }
      }
      paramLinkedList = new i(8);
      paramLinkedList.oLE = this.oLw;
      this.oLv.add(paramLinkedList);
    }
    paramLinkedList = this.oLv;
    AppMethodBeat.o(8900);
    return paramLinkedList;
  }
  
  public final i WV(String paramString)
  {
    AppMethodBeat.i(8899);
    paramString = (i)this.oLu.get(paramString);
    AppMethodBeat.o(8899);
    return paramString;
  }
  
  public final boolean bYs()
  {
    AppMethodBeat.i(8901);
    if (this.oLu.size() == 0)
    {
      AppMethodBeat.o(8901);
      return true;
    }
    AppMethodBeat.o(8901);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.g
 * JD-Core Version:    0.7.0.1
 */