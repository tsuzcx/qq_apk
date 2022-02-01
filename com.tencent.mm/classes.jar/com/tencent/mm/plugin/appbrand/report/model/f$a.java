package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/report/model/AppBrandUIInvalidIntentTraceReport$ReportWorker;", "", "appId", "", "versionType", "", "(Ljava/lang/String;I)V", "padding", "reportItemList", "Ljava/util/ArrayList;", "Lcom/tencent/mars/smc/IDKey;", "Lkotlin/collections/ArrayList;", "flush", "", "reportGap", "gap", "", "reportLoad", "setPadding", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class f$a
{
  private final String appId;
  private final int euz;
  int padding;
  private final ArrayList<IDKey> tPr;
  
  public f$a(String paramString, int paramInt)
  {
    AppMethodBeat.i(321500);
    this.appId = paramString;
    this.euz = paramInt;
    this.tPr = new ArrayList(4);
    AppMethodBeat.o(321500);
  }
  
  public final void cIO()
  {
    AppMethodBeat.i(321501);
    this.tPr.add(new IDKey(1774, this.padding + 0, 1));
    AppMethodBeat.o(321501);
  }
  
  public final void flush()
  {
    AppMethodBeat.i(321504);
    h.OAn.b(this.tPr, false);
    Iterator localIterator = ((Iterable)this.tPr).iterator();
    while (localIterator.hasNext())
    {
      IDKey localIDKey = (IDKey)localIterator.next();
      Log.i("MicroMsg.AppBrandUIInvalidIntentTraceReport", "flush report appId:" + this.appId + " versionType:" + this.euz + " idkey: " + localIDKey.GetID() + ' ' + localIDKey.GetKey());
      j.a(this.appId, 0, this.euz, localIDKey.GetID(), localIDKey.GetKey(), 1L);
    }
    AppMethodBeat.o(321504);
  }
  
  public final void jS(long paramLong)
  {
    AppMethodBeat.i(321502);
    int i;
    if (paramLong > TimeUnit.HOURS.toMillis(24L)) {
      i = 11;
    }
    for (;;)
    {
      if (i > 0) {
        this.tPr.add(new IDKey(1774, i + this.padding, 1));
      }
      AppMethodBeat.o(321502);
      return;
      if (paramLong > TimeUnit.HOURS.toMillis(12L)) {
        i = 10;
      } else if (paramLong > TimeUnit.HOURS.toMillis(6L)) {
        i = 9;
      } else if (paramLong > TimeUnit.HOURS.toMillis(2L)) {
        i = 8;
      } else if (paramLong > TimeUnit.HOURS.toMillis(1L)) {
        i = 7;
      } else if (paramLong > TimeUnit.MINUTES.toMillis(30L)) {
        i = 6;
      } else if (paramLong > TimeUnit.MINUTES.toMillis(10L)) {
        i = 5;
      } else if (paramLong > TimeUnit.MINUTES.toMillis(5L)) {
        i = 4;
      } else if (paramLong > TimeUnit.MINUTES.toMillis(2L)) {
        i = 3;
      } else if (paramLong > TimeUnit.MINUTES.toMillis(1L)) {
        i = 2;
      } else if (paramLong > 30000L) {
        i = 1;
      } else {
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.f.a
 * JD-Core Version:    0.7.0.1
 */