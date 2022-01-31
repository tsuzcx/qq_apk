package com.tencent.mm.plugin.brandservice.ui.timeline.a.c;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.protocal.c.bxy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class d
{
  private static Map<String, b> iiA;
  private static b iiB;
  private static Map<Integer, Long> iiC = new ConcurrentHashMap();
  private static List<Integer> iiD = new ArrayList();
  private static LinkedList<Integer> iiz;
  
  static
  {
    Object localObject = new LinkedList();
    iiz = (LinkedList)localObject;
    ((LinkedList)localObject).add(Integer.valueOf(0));
    iiz.add(Integer.valueOf(1));
    iiz.add(Integer.valueOf(2));
    iiz.add(Integer.valueOf(3));
    iiA = new ConcurrentHashMap();
    localObject = new b();
    iiB = (b)localObject;
    ((b)localObject).field_reportId = 908;
    iiB.field_FullVersion = "#LOCAL";
    iiB.field_version = 2147483647;
    iiB.field_filePath = com.tencent.mm.plugin.brandservice.ui.timeline.a.c.iia;
  }
  
  public static void a(bxy parambxy)
  {
    if (parambxy == null)
    {
      y.e("MicroMsg.Preload.TmplInfoManager", "updateTmplInfo() tmpInfo is null");
      return;
    }
    String str = c.oD(parambxy.type);
    e locale = com.tencent.mm.plugin.brandservice.c.axq();
    b localb = new b();
    localb.field_tmplName = c.oD(parambxy.type);
    boolean bool = locale.b(localb, new String[0]);
    localb.field_version = parambxy.hQQ;
    localb.field_md5 = parambxy.jnU;
    localb.field_versionLowerBound = parambxy.sNE;
    localb.field_downloadUrl = parambxy.sND;
    localb.field_FullVersion = parambxy.tNV;
    localb.field_reportId = parambxy.tFj;
    localb.field_downloadTime = System.currentTimeMillis();
    y.v("MicroMsg.Preload.TmplInfoStorage", "[insertOrUpdate]TmplInfo:%s", new Object[] { localb });
    if (bool) {
      locale.c(localb, new String[0]);
    }
    for (;;)
    {
      iiA.put(str, localb);
      return;
      locale.b(localb);
    }
  }
  
  public static void ayy()
  {
    if (aq.is2G(ae.getContext())) {
      y.w("MicroMsg.Preload.TmplInfoManager", "[checkTmpl] not check, because network is 2g");
    }
    LinkedList localLinkedList;
    Integer localInteger;
    label166:
    label197:
    do
    {
      return;
      if (com.tencent.mm.plugin.brandservice.ui.timeline.a.c.ayp())
      {
        com.tencent.mm.plugin.brandservice.ui.timeline.a.e.cp("MicroMsg.Preload.TmplInfoManager", "use local file, ignore");
        return;
      }
      if (com.tencent.mm.plugin.brandservice.ui.timeline.a.c.ayq())
      {
        com.tencent.mm.kernel.g.DS().O(new d.1());
        return;
      }
      localLinkedList = new LinkedList();
      localIterator = iiz.iterator();
      while (localIterator.hasNext())
      {
        localInteger = (Integer)localIterator.next();
        int i = localInteger.intValue();
        l = 0L;
        if (iiC.containsKey(Integer.valueOf(i))) {
          l = ((Long)iiC.get(Integer.valueOf(i))).longValue();
        }
        if (iiD.contains(Integer.valueOf(i))) {
          y.v("MicroMsg.Preload.TmplInfoManager", "[checkTmplVer] %d already check", new Object[] { Integer.valueOf(i) });
        }
        for (i = 0;; i = 1)
        {
          if (i == 0) {
            break label197;
          }
          localLinkedList.add(localInteger);
          break;
          if (System.currentTimeMillis() - l <= 60000L) {
            break label166;
          }
        }
      }
    } while (localLinkedList.size() <= 0);
    iiD.addAll(localLinkedList);
    long l = System.currentTimeMillis();
    Iterator localIterator = localLinkedList.iterator();
    while (localIterator.hasNext())
    {
      localInteger = (Integer)localIterator.next();
      iiC.put(localInteger, Long.valueOf(l));
    }
    com.tencent.mm.plugin.webview.preload.a.jdMethod_if(0);
    new a(localLinkedList).Km().g(new d.2(localLinkedList));
  }
  
  private static boolean b(bxy parambxy)
  {
    boolean bool2 = false;
    if (parambxy == null) {}
    for (;;)
    {
      try
      {
        y.e("MicroMsg.Preload.TmplInfoManager", "isTmplInfoExist() tmplInfo is null, return false");
        bool1 = bool2;
        return bool1;
      }
      finally {}
      Object localObject = oE(parambxy.type);
      boolean bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((b)localObject).field_version == parambxy.hQQ)
        {
          localObject = new File(c.k(parambxy.type, parambxy.hQQ, parambxy.tNV));
          if (!((File)localObject).exists())
          {
            y.w("MicroMsg.Preload.TmplInfoManager", "[isTmplInfoExist]file isn't exist, may be delete");
            bool1 = bool2;
          }
          else
          {
            String str = com.tencent.mm.a.g.m((File)localObject);
            if ((bk.bl(str)) || (!str.equals(parambxy.jnU)))
            {
              y.w("MicroMsg.Preload.TmplInfoManager", "[isTmplInfoExist]file md5 not equal, may be modify");
              ((File)localObject).delete();
              bool1 = bool2;
            }
            else
            {
              bool1 = true;
            }
          }
        }
      }
    }
  }
  
  public static b oE(int paramInt)
  {
    Object localObject;
    if (com.tencent.mm.plugin.brandservice.ui.timeline.a.c.ayp())
    {
      localObject = iiB;
      return localObject;
    }
    String str = c.oD(paramInt);
    b localb = (b)iiA.get(str);
    if (localb == null)
    {
      localObject = (Bundle)com.tencent.mm.ipcinvoker.f.a("com.tencent.mm", new IPCString(str), d.a.class);
      if (localObject == null) {
        break label231;
      }
      localb = new b();
      localb.field_tmplName = ((Bundle)localObject).getString("tmplName");
      localb.field_version = ((Bundle)localObject).getInt("version");
      localb.field_md5 = ((Bundle)localObject).getString("md5");
      localb.field_filePath = ((Bundle)localObject).getString("filePath");
      localb.field_versionLowerBound = ((Bundle)localObject).getInt("versionLowerBound");
      localb.field_downloadUrl = ((Bundle)localObject).getString("downloadUrl");
      localb.field_reportId = ((Bundle)localObject).getInt("repordId");
      localb.field_downloadTime = ((Bundle)localObject).getLong("downloadTime");
    }
    for (;;)
    {
      boolean bool;
      if (localb != null)
      {
        bool = true;
        label163:
        y.i("MicroMsg.Preload.TmplInfoManager", "getTmplInfoDB() localTmplInfo is %b", new Object[] { Boolean.valueOf(bool) });
      }
      for (;;)
      {
        localObject = localb;
        if (localb != null) {
          break;
        }
        y.e("MicroMsg.Preload.TmplInfoManager", "[getTmplInfo]tmplName:%s is null, err", new Object[] { str });
        return localb;
        bool = false;
        break label163;
        localb.field_filePath = c.k(paramInt, localb.field_version, localb.field_FullVersion);
      }
      label231:
      localb = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.c.d
 * JD-Core Version:    0.7.0.1
 */