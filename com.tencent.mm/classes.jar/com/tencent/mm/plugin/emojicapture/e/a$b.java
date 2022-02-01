package com.tencent.mm.plugin.emojicapture.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/presenter/CapturePresenter$RecordState;", "", "(Ljava/lang/String;I)V", "RECORD_STATE_IDLE", "RECORD_STATE_PREVIEW", "RECORD_STATE_PREVIEW_PAUSED", "RECORD_STATE_STARTED", "RECORD_STATE_STOP", "plugin-emojicapture_release"})
public enum a$b
{
  static
  {
    AppMethodBeat.i(317);
    b localb1 = new b("RECORD_STATE_IDLE", 0);
    oMp = localb1;
    b localb2 = new b("RECORD_STATE_PREVIEW", 1);
    oMq = localb2;
    b localb3 = new b("RECORD_STATE_PREVIEW_PAUSED", 2);
    oMr = localb3;
    b localb4 = new b("RECORD_STATE_STARTED", 3);
    oMs = localb4;
    b localb5 = new b("RECORD_STATE_STOP", 4);
    oMt = localb5;
    oMu = new b[] { localb1, localb2, localb3, localb4, localb5 };
    AppMethodBeat.o(317);
  }
  
  private a$b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.e.a.b
 * JD-Core Version:    0.7.0.1
 */