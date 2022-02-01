package com.tencent.mm.plugin.downloader_app.a;

import android.content.pm.PackageInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.c.a.a.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class g
{
  public com.tencent.mm.plugin.downloader.c.a.a.b pvH;
  private Map<String, i> pvI;
  private LinkedList<i> pvJ;
  public f pvK;
  private String pvL;
  
  public g(com.tencent.mm.plugin.downloader.c.a.a.b paramb)
  {
    AppMethodBeat.i(8896);
    this.pvI = new HashMap();
    this.pvJ = new LinkedList();
    this.pvL = "";
    if (paramb == null)
    {
      this.pvH = new com.tencent.mm.plugin.downloader.c.a.a.b();
      AppMethodBeat.o(8896);
      return;
    }
    this.pvH = paramb;
    Zm();
    AppMethodBeat.o(8896);
  }
  
  public g(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(8897);
    this.pvI = new HashMap();
    this.pvJ = new LinkedList();
    this.pvL = "";
    this.pvH = new com.tencent.mm.plugin.downloader.c.a.a.b();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(8897);
      return;
    }
    try
    {
      this.pvH.parseFrom(paramArrayOfByte);
      Zm();
      AppMethodBeat.o(8897);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        ae.e("MicroMsg.PBAppInfo", "Parsing Failed: %s", new Object[] { paramArrayOfByte.getMessage() });
      }
    }
  }
  
  private void Zm()
  {
    AppMethodBeat.i(8898);
    this.pvK = this.pvH.pqi;
    if (bu.ht(this.pvH.pqh))
    {
      AppMethodBeat.o(8898);
      return;
    }
    Iterator localIterator = this.pvH.pqh.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.downloader.c.a.a.d locald = (com.tencent.mm.plugin.downloader.c.a.a.d)localIterator.next();
      if ((locald.pqk.prv == null) || (locald.pqk.prv.prk == null))
      {
        ae.e("MicroMsg.PBAppInfo", "download info is null, appid:%s", new Object[] { locald.pqk.prt.dwb });
      }
      else
      {
        i locali = new i();
        locali.appId = locald.pqk.prt.dwb;
        locali.appName = locald.pqk.prt.pqV;
        locali.iconUrl = locald.pqk.prt.pqW;
        locali.packageName = locald.pqk.prv.prk.pqK;
        locali.pvR = locald.pqk.prv.prk;
        Object localObject;
        if (locald.pqm != null)
        {
          localObject = locald.pqm.pqj;
          label219:
          locali.jumpUrl = ((String)localObject);
          if (!bu.isNullOrNil(locali.jumpUrl)) {
            this.pvL = locali.jumpUrl;
          }
          locali.pvP = locald.pqk.prv.prk.pqS;
          locali.pvT = locald.pqk.prx;
          if (j.abu(locald.pqk.prt.dwb) != k.UN_INSTALLED) {
            break label326;
          }
          locali.type = 2;
        }
        for (;;)
        {
          this.pvI.put(locali.appId, locali);
          break;
          localObject = "";
          break label219;
          label326:
          localObject = com.tencent.mm.plugin.appbrand.y.b.getPackageInfo(ak.getContext(), locald.pqk.prv.prk.pqK);
          if ((localObject != null) && (((PackageInfo)localObject).versionCode < locald.pqk.prv.prk.pqO)) {
            locali.type = 4;
          } else {
            locali.type = 6;
          }
        }
      }
    }
    AppMethodBeat.o(8898);
  }
  
  public final LinkedList<i> V(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(8900);
    this.pvJ.clear();
    if (!bu.ht(paramLinkedList))
    {
      paramLinkedList = paramLinkedList.iterator();
      int i = 0;
      int k = 0;
      int j = 0;
      if (paramLinkedList.hasNext())
      {
        Object localObject = (String)paramLinkedList.next();
        localObject = (i)this.pvI.get(localObject);
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
          this.pvJ.add(localObject);
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
      paramLinkedList.pvS = this.pvK;
      this.pvJ.add(paramLinkedList);
    }
    paramLinkedList = this.pvJ;
    AppMethodBeat.o(8900);
    return paramLinkedList;
  }
  
  public final i abt(String paramString)
  {
    AppMethodBeat.i(8899);
    paramString = (i)this.pvI.get(paramString);
    AppMethodBeat.o(8899);
    return paramString;
  }
  
  public final boolean cel()
  {
    AppMethodBeat.i(8901);
    if (this.pvI.size() == 0)
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