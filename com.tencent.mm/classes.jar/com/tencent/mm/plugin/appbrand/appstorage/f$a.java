package com.tencent.mm.plugin.appbrand.appstorage;

import a.f.b.j;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.Set;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage$Companion;", "", "()V", "CACHE", "", "", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage;", "NAME", "", "NORMAL_VALUE_TYPE_SEPARATOR", "TAG", "obtain", "uin", "onAccountRelease", "", "luggage-wechat-full-sdk_release"})
public final class f$a
{
  public static f hr(long paramLong)
  {
    AppMethodBeat.i(140999);
    synchronized (f.awH())
    {
      if (!f.awH().keySet().contains(Long.valueOf(paramLong))) {
        f.awH().put(Long.valueOf(paramLong), new f(paramLong, (byte)0));
      }
      y localy = y.BMg;
      ??? = f.awH().get(Long.valueOf(paramLong));
      if (??? == null) {
        j.ebi();
      }
      ??? = (f)???;
      AppMethodBeat.o(140999);
      return ???;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.f.a
 * JD-Core Version:    0.7.0.1
 */