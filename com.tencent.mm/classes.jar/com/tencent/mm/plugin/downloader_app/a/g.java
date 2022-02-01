package com.tencent.mm.plugin.downloader_app.a;

import android.content.pm.PackageInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.c.a.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class g
{
  public com.tencent.mm.plugin.downloader.c.a.a.b qKY;
  private Map<String, i> qKZ;
  private LinkedList<i> qLa;
  public f qLb;
  private String qLc;
  
  public g(com.tencent.mm.plugin.downloader.c.a.a.b paramb)
  {
    AppMethodBeat.i(8896);
    this.qKZ = new HashMap();
    this.qLa = new LinkedList();
    this.qLc = "";
    if (paramb == null)
    {
      this.qKY = new com.tencent.mm.plugin.downloader.c.a.a.b();
      AppMethodBeat.o(8896);
      return;
    }
    this.qKY = paramb;
    amZ();
    AppMethodBeat.o(8896);
  }
  
  public g(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(8897);
    this.qKZ = new HashMap();
    this.qLa = new LinkedList();
    this.qLc = "";
    this.qKY = new com.tencent.mm.plugin.downloader.c.a.a.b();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(8897);
      return;
    }
    try
    {
      this.qKY.parseFrom(paramArrayOfByte);
      amZ();
      AppMethodBeat.o(8897);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        Log.e("MicroMsg.PBAppInfo", "Parsing Failed: %s", new Object[] { paramArrayOfByte.getMessage() });
      }
    }
  }
  
  private void amZ()
  {
    AppMethodBeat.i(8898);
    this.qLb = this.qKY.qFN;
    if (Util.isNullOrNil(this.qKY.qFM))
    {
      AppMethodBeat.o(8898);
      return;
    }
    Iterator localIterator = this.qKY.qFM.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.downloader.c.a.a.d locald = (com.tencent.mm.plugin.downloader.c.a.a.d)localIterator.next();
      if ((locald.qFP.qHa == null) || (locald.qFP.qHa.qGP == null))
      {
        Log.e("MicroMsg.PBAppInfo", "download info is null, appid:%s", new Object[] { locald.qFP.qGY.dNI });
      }
      else
      {
        i locali = new i();
        locali.appId = locald.qFP.qGY.dNI;
        locali.appName = locald.qFP.qGY.qGA;
        locali.iconUrl = locald.qFP.qGY.qGB;
        locali.packageName = locald.qFP.qHa.qGP.qGp;
        locali.qLi = locald.qFP.qHa.qGP;
        Object localObject;
        if (locald.qFR != null)
        {
          localObject = locald.qFR.qFO;
          label219:
          locali.jumpUrl = ((String)localObject);
          if (!Util.isNullOrNil(locali.jumpUrl)) {
            this.qLc = locali.jumpUrl;
          }
          locali.qLg = locald.qFP.qHa.qGP.qGx;
          locali.qLk = locald.qFP.qHc;
          if (j.alA(locald.qFP.qGY.dNI) != k.UN_INSTALLED) {
            break label326;
          }
          locali.type = 2;
        }
        for (;;)
        {
          this.qKZ.put(locali.appId, locali);
          break;
          localObject = "";
          break label219;
          label326:
          localObject = com.tencent.mm.plugin.appbrand.ac.b.getPackageInfo(MMApplicationContext.getContext(), locald.qFP.qHa.qGP.qGp);
          if ((localObject != null) && (((PackageInfo)localObject).versionCode < locald.qFP.qHa.qGP.qGt)) {
            locali.type = 4;
          } else {
            locali.type = 6;
          }
        }
      }
    }
    AppMethodBeat.o(8898);
  }
  
  public final LinkedList<i> X(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(8900);
    this.qLa.clear();
    if (!Util.isNullOrNil(paramLinkedList))
    {
      paramLinkedList = paramLinkedList.iterator();
      int i = 0;
      int k = 0;
      int j = 0;
      if (paramLinkedList.hasNext())
      {
        Object localObject = (String)paramLinkedList.next();
        localObject = (i)this.qKZ.get(localObject);
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
          this.qLa.add(localObject);
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
      paramLinkedList.qLj = this.qLb;
      this.qLa.add(paramLinkedList);
    }
    paramLinkedList = this.qLa;
    AppMethodBeat.o(8900);
    return paramLinkedList;
  }
  
  public final i alz(String paramString)
  {
    AppMethodBeat.i(8899);
    paramString = (i)this.qKZ.get(paramString);
    AppMethodBeat.o(8899);
    return paramString;
  }
  
  public final boolean cCb()
  {
    AppMethodBeat.i(8901);
    if (this.qKZ.size() == 0)
    {
      AppMethodBeat.o(8901);
      return true;
    }
    AppMethodBeat.o(8901);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.g
 * JD-Core Version:    0.7.0.1
 */