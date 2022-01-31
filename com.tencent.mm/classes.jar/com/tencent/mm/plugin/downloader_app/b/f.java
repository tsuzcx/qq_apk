package com.tencent.mm.plugin.downloader_app.b;

import android.content.pm.PackageInfo;
import com.tencent.mm.plugin.downloader.e.c;
import com.tencent.mm.plugin.downloader.e.d;
import com.tencent.mm.plugin.downloader.e.e;
import com.tencent.mm.plugin.downloader.e.g;
import com.tencent.mm.plugin.downloader.e.h;
import com.tencent.mm.plugin.downloader.e.i;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class f
{
  public c iSk;
  public Map<String, j> iSl = new HashMap();
  public LinkedList<j> iSm = new LinkedList();
  public String iSn = "";
  
  public f(c paramc)
  {
    if (paramc == null)
    {
      this.iSk = new c();
      return;
    }
    this.iSk = paramc;
    xK();
  }
  
  public f(byte[] paramArrayOfByte)
  {
    this.iSk = new c();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return;
    }
    try
    {
      this.iSk.aH(paramArrayOfByte);
      xK();
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        y.e("MicroMsg.PBAppInfo", "Parsing Failed: %s", new Object[] { paramArrayOfByte.getMessage() });
      }
    }
  }
  
  private void xK()
  {
    if (bk.dk(this.iSk.iQd)) {
      return;
    }
    Iterator localIterator = this.iSk.iQd.iterator();
    label25:
    i locali;
    j localj;
    Object localObject;
    while (localIterator.hasNext())
    {
      locali = (i)localIterator.next();
      if ((locali.iQy.iQI == null) || (locali.iQy.iQI.iQv == null))
      {
        y.e("MicroMsg.PBAppInfo", "download info is null, appid:%s", new Object[] { locali.iQy.iQG.bOL });
      }
      else
      {
        localj = new j();
        localj.appId = locali.iQy.iQG.bOL;
        localj.appName = locali.iQy.iQG.dRQ;
        localj.iconUrl = locali.iQy.iQG.iQn;
        localj.packageName = locali.iQy.iQI.iQv.iQe;
        localj.iSt = locali.iQy.iQI.iQv;
        if (locali.iQA == null) {
          break label285;
        }
        localObject = locali.iQA.iQu;
        label196:
        localj.jumpUrl = ((String)localObject);
        if (!bk.bl(localj.jumpUrl)) {
          this.iSn = localj.jumpUrl;
        }
        localj.iSr = locali.iQy.iQI.iQv.iQm;
        if (k.Ae(locali.iQy.iQG.bOL) != l.UN_INSTALLED) {
          break label291;
        }
        localj.type = 2;
      }
    }
    for (;;)
    {
      this.iSl.put(localj.appId, localj);
      break label25;
      break;
      label285:
      localObject = "";
      break label196;
      label291:
      localObject = p.getPackageInfo(ae.getContext(), locali.iQy.iQI.iQv.iQe);
      if ((localObject != null) && (((PackageInfo)localObject).versionCode < locali.iQy.iQI.iQv.iQi)) {
        localj.type = 4;
      } else {
        localj.type = 6;
      }
    }
  }
  
  public final j Ad(String paramString)
  {
    return (j)this.iSl.get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.b.f
 * JD-Core Version:    0.7.0.1
 */