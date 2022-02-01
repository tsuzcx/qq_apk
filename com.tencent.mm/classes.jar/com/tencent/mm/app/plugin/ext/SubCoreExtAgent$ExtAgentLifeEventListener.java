package com.tencent.mm.app.plugin.ext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.gi;
import com.tencent.mm.sdk.event.IListener;

public class SubCoreExtAgent$ExtAgentLifeEventListener
  extends IListener<gi>
{
  SubCoreExtAgent.RequestAccountSyncEventListener hlk;
  SubCoreExtAgent.ExtRecordEventListener hll;
  SubCoreExtAgent.ExtSimpleRecordEventListener hlm;
  SubCoreExtAgent.ExtPlayerEventListener hln;
  SubCoreExtAgent.ExtVoiceMsgIdToFileNameEventListener hlo;
  SubCoreExtAgent.ExtVoiceFileNameToMsgIdEventListener hlp;
  SubCoreExtAgent.ExtNetSceneSendMsgEventListener hlq;
  SubCoreExtAgent.ExtCursorForTimeLineEventListener hlr;
  
  public SubCoreExtAgent$ExtAgentLifeEventListener()
  {
    super(f.hfK);
    AppMethodBeat.i(161260);
    this.__eventId = gi.class.getName().hashCode();
    AppMethodBeat.o(161260);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.plugin.ext.SubCoreExtAgent.ExtAgentLifeEventListener
 * JD-Core Version:    0.7.0.1
 */