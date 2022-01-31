package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

final class q$1
  implements Runnable
{
  q$1(q paramq, c paramc, String paramString1, int paramInt, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(102784);
    Object localObject = this.hza.wX().zg(this.hLX);
    if (localObject == null)
    {
      this.hza.h(this.bAX, this.hLZ.j("fail:file doesn't exist", null));
      AppMethodBeat.o(102784);
      return;
    }
    File localFile = new File(((File)localObject).getAbsolutePath());
    localObject = this.hLY;
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
      this.hza.h(this.bAX, this.hLZ.j("ok", localHashMap));
      AppMethodBeat.o(102784);
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
      localObject = g.r(localFile);
      continue;
      localObject = q.F(localFile);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.q.1
 * JD-Core Version:    0.7.0.1
 */