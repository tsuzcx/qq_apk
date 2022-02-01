package com.tencent.mm.plugin.calcwx;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.dj;
import com.tencent.mm.autogen.a.dj.a;
import com.tencent.mm.plugin.calcwx.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;

class CalcWxService$11
  extends IListener<dj>
{
  CalcWxService$11(a parama, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(277798);
    this.__eventId = dj.class.getName().hashCode();
    AppMethodBeat.o(277798);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.calcwx.CalcWxService.11
 * JD-Core Version:    0.7.0.1
 */