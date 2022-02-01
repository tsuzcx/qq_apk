package com.tencent.mm.plugin.appbrand.launching;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.NotifyWxaCommLibUpdatedEvent;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.event.IListener;
import java.util.concurrent.CountDownLatch;

class PrepareStepCheckLaunchInfo$2
  extends IListener<NotifyWxaCommLibUpdatedEvent>
{
  PrepareStepCheckLaunchInfo$2(bb parambb, q paramq, long paramLong, PBool paramPBool, CountDownLatch paramCountDownLatch)
  {
    super(paramq);
    AppMethodBeat.i(321119);
    this.__eventId = NotifyWxaCommLibUpdatedEvent.class.getName().hashCode();
    AppMethodBeat.o(321119);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.PrepareStepCheckLaunchInfo.2
 * JD-Core Version:    0.7.0.1
 */