package com.tencent.mm.plugin.ai.data.business.trigger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.nk;
import com.tencent.mm.autogen.a.nk.a;
import com.tencent.mm.autogen.mmdata.rpt.i;
import com.tencent.mm.plugin.ai.data.business.finder.e;
import com.tencent.mm.plugin.ai.data.business.global.b;
import com.tencent.mm.plugin.ai.data.business.global.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;

class SessionChangeTrigger$2
  extends IListener<nk>
{
  SessionChangeTrigger$2(f paramf, androidx.lifecycle.q paramq)
  {
    super(paramq);
    AppMethodBeat.i(267583);
    this.__eventId = nk.class.getName().hashCode();
    AppMethodBeat.o(267583);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.data.business.trigger.SessionChangeTrigger.2
 * JD-Core Version:    0.7.0.1
 */