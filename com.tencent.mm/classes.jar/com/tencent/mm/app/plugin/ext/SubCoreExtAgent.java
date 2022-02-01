package com.tencent.mm.app.plugin.ext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.audio.a.a;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.autogen.a.gr;
import com.tencent.mm.autogen.a.gt;
import com.tencent.mm.autogen.a.gu;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

public final class SubCoreExtAgent
{
  public static class ExtPlayerEventListener
    extends IListener<gr>
  {
    String fileName;
    a hls;
    
    public ExtPlayerEventListener()
    {
      super();
      AppMethodBeat.i(161263);
      this.__eventId = gr.class.getName().hashCode();
      AppMethodBeat.o(161263);
    }
  }
  
  public static class ExtSimpleRecordEventListener
    extends IListener<gu>
  {
    String fileName;
    m hlu;
    boolean hlv;
    boolean hlw;
    gu hlx;
    Runnable hly;
    boolean isTimeout;
    MTimerHandler timer;
    
    public ExtSimpleRecordEventListener()
    {
      super();
      AppMethodBeat.i(161265);
      this.fileName = "";
      this.__eventId = gu.class.getName().hashCode();
      AppMethodBeat.o(161265);
    }
    
    private void stopRecord()
    {
      AppMethodBeat.i(19781);
      if (this.hlu != null)
      {
        this.hlw = this.hlu.aGH();
        if (this.hly != null)
        {
          if (this.hlx != null)
          {
            this.hlx.hHm.hHn = this.hlu.hvI.hwE;
            this.hlx = null;
          }
          if (this.isTimeout) {
            this.hly.run();
          }
          this.hly = null;
        }
        this.hlv = true;
      }
      AppMethodBeat.o(19781);
    }
  }
  
  public static class RequestAccountSyncEventListener
    extends IListener<gt>
  {
    public RequestAccountSyncEventListener()
    {
      super();
      AppMethodBeat.i(161268);
      this.__eventId = gt.class.getName().hashCode();
      AppMethodBeat.o(161268);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.plugin.ext.SubCoreExtAgent
 * JD-Core Version:    0.7.0.1
 */