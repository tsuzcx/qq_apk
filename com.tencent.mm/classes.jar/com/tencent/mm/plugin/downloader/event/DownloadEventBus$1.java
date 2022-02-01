package com.tencent.mm.plugin.downloader.event;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ky;
import com.tencent.mm.sdk.event.IListener;

class DownloadEventBus$1
  extends IListener<ky>
{
  DownloadEventBus$1(q paramq)
  {
    super(paramq);
    AppMethodBeat.i(267107);
    this.__eventId = ky.class.getName().hashCode();
    AppMethodBeat.o(267107);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.event.DownloadEventBus.1
 * JD-Core Version:    0.7.0.1
 */