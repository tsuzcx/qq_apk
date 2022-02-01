package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.NotifyWxaCommLibUpdatedEvent;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.event.IListener;
import java.util.concurrent.CountDownLatch;

final class az$2
  extends IListener<NotifyWxaCommLibUpdatedEvent>
{
  az$2(az paramaz, long paramLong, PBool paramPBool, CountDownLatch paramCountDownLatch)
  {
    AppMethodBeat.i(276488);
    this.__eventId = NotifyWxaCommLibUpdatedEvent.class.getName().hashCode();
    AppMethodBeat.o(276488);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.az.2
 * JD-Core Version:    0.7.0.1
 */