package com.tencent.mm.plugin.downloader_app.a;

import android.content.pm.PackageInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.b.a.a.f;
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
  private String xsA;
  public com.tencent.mm.plugin.downloader.b.a.a.b xsw;
  private Map<String, i> xsx;
  private LinkedList<i> xsy;
  public f xsz;
  
  public g(com.tencent.mm.plugin.downloader.b.a.a.b paramb)
  {
    AppMethodBeat.i(8896);
    this.xsx = new HashMap();
    this.xsy = new LinkedList();
    this.xsA = "";
    if (paramb == null)
    {
      this.xsw = new com.tencent.mm.plugin.downloader.b.a.a.b();
      AppMethodBeat.o(8896);
      return;
    }
    this.xsw = paramb;
    aNi();
    AppMethodBeat.o(8896);
  }
  
  public g(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(8897);
    this.xsx = new HashMap();
    this.xsy = new LinkedList();
    this.xsA = "";
    this.xsw = new com.tencent.mm.plugin.downloader.b.a.a.b();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(8897);
      return;
    }
    try
    {
      this.xsw.parseFrom(paramArrayOfByte);
      aNi();
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
  
  private void aNi()
  {
    AppMethodBeat.i(8898);
    this.xsz = this.xsw.xkQ;
    if (Util.isNullOrNil(this.xsw.xkP))
    {
      AppMethodBeat.o(8898);
      return;
    }
    Iterator localIterator = this.xsw.xkP.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.downloader.b.a.a.d locald = (com.tencent.mm.plugin.downloader.b.a.a.d)localIterator.next();
      if ((locald.xkS.xmh == null) || (locald.xkS.xmh.xlW == null))
      {
        Log.e("MicroMsg.PBAppInfo", "download info is null, appid:%s", new Object[] { locald.xkS.xmf.appid });
      }
      else
      {
        i locali = new i();
        locali.appId = locald.xkS.xmf.appid;
        locali.appName = locald.xkS.xmf.xlJ;
        locali.iconUrl = locald.xkS.xmf.icon_url;
        locali.packageName = locald.xkS.xmh.xlW.xlr;
        locali.xsG = locald.xkS.xmh.xlW;
        Object localObject;
        if (locald.xkU != null)
        {
          localObject = locald.xkU.xkR;
          label219:
          locali.jumpUrl = ((String)localObject);
          if (!Util.isNullOrNil(locali.jumpUrl)) {
            this.xsA = locali.jumpUrl;
          }
          locali.xsE = locald.xkS.xmh.xlW.xlz;
          locali.xsI = locald.xkS.xmj;
          if (j.ani(locald.xkS.xmf.appid) != k.UN_INSTALLED) {
            break label326;
          }
          locali.type = 2;
        }
        for (;;)
        {
          this.xsx.put(locali.appId, locali);
          break;
          localObject = "";
          break label219;
          label326:
          localObject = com.tencent.mm.plugin.appbrand.af.b.getPackageInfo(MMApplicationContext.getContext(), locald.xkS.xmh.xlW.xlr);
          if ((localObject != null) && (((PackageInfo)localObject).versionCode < locald.xkS.xmh.xlW.xlv)) {
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
    this.xsy.clear();
    if (!Util.isNullOrNil(paramLinkedList))
    {
      paramLinkedList = paramLinkedList.iterator();
      int i = 0;
      int k = 0;
      int j = 0;
      if (paramLinkedList.hasNext())
      {
        Object localObject = (String)paramLinkedList.next();
        localObject = (i)this.xsx.get(localObject);
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
          this.xsy.add(localObject);
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
      paramLinkedList.xsH = this.xsz;
      this.xsy.add(paramLinkedList);
    }
    paramLinkedList = this.xsy;
    AppMethodBeat.o(8900);
    return paramLinkedList;
  }
  
  public final i anh(String paramString)
  {
    AppMethodBeat.i(8899);
    paramString = (i)this.xsx.get(paramString);
    AppMethodBeat.o(8899);
    return paramString;
  }
  
  public final boolean duY()
  {
    AppMethodBeat.i(8901);
    if (this.xsx.size() == 0)
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