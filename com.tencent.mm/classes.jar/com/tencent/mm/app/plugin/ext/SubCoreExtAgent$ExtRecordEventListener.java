package com.tencent.mm.app.plugin.ext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.audio.b.h;
import com.tencent.mm.autogen.a.gs;
import com.tencent.mm.sdk.event.IListener;

public class SubCoreExtAgent$ExtRecordEventListener
  extends IListener<gs>
{
  String fileName;
  h hlt;
  
  public SubCoreExtAgent$ExtRecordEventListener()
  {
    super(f.hfK);
    AppMethodBeat.i(161264);
    this.fileName = "";
    this.__eventId = gs.class.getName().hashCode();
    AppMethodBeat.o(161264);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.plugin.ext.SubCoreExtAgent.ExtRecordEventListener
 * JD-Core Version:    0.7.0.1
 */