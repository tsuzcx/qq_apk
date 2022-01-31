package com.tencent.mm.plugin.downloader_app.b;

import android.content.pm.PackageInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.c.a.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class f
{
  public com.tencent.mm.plugin.downloader.c.a.a.b laR;
  private Map<String, i> laS;
  private LinkedList<i> laT;
  public com.tencent.mm.plugin.downloader.c.a.a.f laU;
  private String laV;
  
  public f(com.tencent.mm.plugin.downloader.c.a.a.b paramb)
  {
    AppMethodBeat.i(136135);
    this.laS = new HashMap();
    this.laT = new LinkedList();
    this.laV = "";
    if (paramb == null)
    {
      this.laR = new com.tencent.mm.plugin.downloader.c.a.a.b();
      AppMethodBeat.o(136135);
      return;
    }
    this.laR = paramb;
    Kc();
    AppMethodBeat.o(136135);
  }
  
  public f(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(136136);
    this.laS = new HashMap();
    this.laT = new LinkedList();
    this.laV = "";
    this.laR = new com.tencent.mm.plugin.downloader.c.a.a.b();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(136136);
      return;
    }
    try
    {
      this.laR.parseFrom(paramArrayOfByte);
      Kc();
      AppMethodBeat.o(136136);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        ab.e("MicroMsg.PBAppInfo", "Parsing Failed: %s", new Object[] { paramArrayOfByte.getMessage() });
      }
    }
  }
  
  private void Kc()
  {
    AppMethodBeat.i(136137);
    this.laU = this.laR.kVO;
    if (bo.es(this.laR.kVN))
    {
      AppMethodBeat.o(136137);
      return;
    }
    Iterator localIterator = this.laR.kVN.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if ((locald.kVQ.kWX == null) || (locald.kVQ.kWX.kWM == null))
      {
        ab.e("MicroMsg.PBAppInfo", "download info is null, appid:%s", new Object[] { locald.kVQ.kWV.cwc });
      }
      else
      {
        i locali = new i();
        locali.appId = locald.kVQ.kWV.cwc;
        locali.appName = locald.kVQ.kWV.kWx;
        locali.iconUrl = locald.kVQ.kWV.kWy;
        locali.packageName = locald.kVQ.kWX.kWM.kWn;
        locali.lbb = locald.kVQ.kWX.kWM;
        Object localObject;
        if (locald.kVS != null)
        {
          localObject = locald.kVS.kVP;
          label217:
          locali.jumpUrl = ((String)localObject);
          if (!bo.isNullOrNil(locali.jumpUrl)) {
            this.laV = locali.jumpUrl;
          }
          locali.laZ = locald.kVQ.kWX.kWM.kWv;
          locali.lbd = locald.kVQ.kWZ;
          if (j.Kc(locald.kVQ.kWV.cwc) != k.UN_INSTALLED) {
            break label324;
          }
          locali.type = 2;
        }
        for (;;)
        {
          this.laS.put(locali.appId, locali);
          break;
          localObject = "";
          break label217;
          label324:
          localObject = com.tencent.mm.plugin.appbrand.s.b.getPackageInfo(ah.getContext(), locald.kVQ.kWX.kWM.kWn);
          if ((localObject != null) && (((PackageInfo)localObject).versionCode < locald.kVQ.kWX.kWM.kWr)) {
            locali.type = 4;
          } else {
            locali.type = 6;
          }
        }
      }
    }
    AppMethodBeat.o(136137);
  }
  
  public final i Kb(String paramString)
  {
    AppMethodBeat.i(136138);
    paramString = (i)this.laS.get(paramString);
    AppMethodBeat.o(136138);
    return paramString;
  }
  
  public final LinkedList<i> O(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(136139);
    this.laT.clear();
    if (!bo.es(paramLinkedList))
    {
      paramLinkedList = paramLinkedList.iterator();
      int i = 0;
      int k = 0;
      int j = 0;
      if (paramLinkedList.hasNext())
      {
        Object localObject = (String)paramLinkedList.next();
        localObject = (i)this.laS.get(localObject);
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
          this.laT.add(localObject);
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
      paramLinkedList.lbc = this.laU;
      this.laT.add(paramLinkedList);
    }
    paramLinkedList = this.laT;
    AppMethodBeat.o(136139);
    return paramLinkedList;
  }
  
  public final boolean bjQ()
  {
    AppMethodBeat.i(136140);
    if (this.laS.size() == 0)
    {
      AppMethodBeat.o(136140);
      return true;
    }
    AppMethodBeat.o(136140);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.b.f
 * JD-Core Version:    0.7.0.1
 */