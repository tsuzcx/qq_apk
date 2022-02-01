package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.NotifyWxaCommLibUpdatedEvent;
import com.tencent.mm.plugin.appbrand.appcache.NotifyWxaCommLibUpdatedEvent.UpdateResult.Succeed;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;

public class AppBrandRuntimeWC$26
  extends IListener<NotifyWxaCommLibUpdatedEvent>
{
  public AppBrandRuntimeWC$26(w paramw, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(316677);
    this.__eventId = NotifyWxaCommLibUpdatedEvent.class.getName().hashCode();
    AppMethodBeat.o(316677);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntimeWC.26
 * JD-Core Version:    0.7.0.1
 */