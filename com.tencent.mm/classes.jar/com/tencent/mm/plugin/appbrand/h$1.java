package com.tencent.mm.plugin.appbrand;

import android.os.Build.VERSION;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.d;
import com.tencent.mm.g.b.a.bz;
import com.tencent.mm.plugin.appbrand.appcache.ap;
import com.tencent.mm.plugin.appbrand.appcache.n;
import com.tencent.mm.plugin.appbrand.appcache.n.b;
import com.tencent.mm.plugin.appbrand.appcache.n.c;
import com.tencent.mm.plugin.appbrand.appcache.n.e;
import com.tencent.mm.plugin.appbrand.appcache.r;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.PackageManager;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class h$1
  extends c<d>
{
  h$1()
  {
    AppMethodBeat.i(128950);
    this.__eventId = d.class.getName().hashCode();
    AppMethodBeat.o(128950);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h.1
 * JD-Core Version:    0.7.0.1
 */