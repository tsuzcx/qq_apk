package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.a.g;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

final class o$1
  implements Runnable
{
  o$1(o paramo, c paramc, String paramString1, int paramInt, String paramString2) {}
  
  public final void run()
  {
    Object localObject = this.ggE.Zl().rx(this.gqL);
    if (localObject == null)
    {
      this.ggE.C(this.dIS, this.gqN.h("fail:file doesn't exist", null));
      return;
    }
    File localFile = new File(((File)localObject).getAbsolutePath());
    localObject = this.gqM;
    int i = -1;
    switch (((String)localObject).hashCode())
    {
    default: 
      switch (i)
      {
      default: 
        localObject = "";
      }
      break;
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap(2);
      localHashMap.put("size", Long.valueOf(localFile.length()));
      localHashMap.put("digest", localObject);
      this.ggE.C(this.dIS, this.gqN.h("ok", localHashMap));
      return;
      if (!((String)localObject).equals("md5")) {
        break;
      }
      i = 0;
      break;
      if (!((String)localObject).equals("sha1")) {
        break;
      }
      i = 1;
      break;
      localObject = g.m(localFile);
      continue;
      localObject = o.y(localFile);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.o.1
 * JD-Core Version:    0.7.0.1
 */