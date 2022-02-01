package com.tencent.mm.plugin.emojicapture.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/presenter/CapturePresenter$RecordState;", "", "(Ljava/lang/String;I)V", "RECORD_STATE_IDLE", "RECORD_STATE_PREVIEW", "RECORD_STATE_PREVIEW_PAUSED", "RECORD_STATE_STARTED", "RECORD_STATE_STOP", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum a$b
{
  static
  {
    AppMethodBeat.i(317);
    yiQ = new b("RECORD_STATE_IDLE", 0);
    yiR = new b("RECORD_STATE_PREVIEW", 1);
    yiS = new b("RECORD_STATE_PREVIEW_PAUSED", 2);
    yiT = new b("RECORD_STATE_STARTED", 3);
    yiU = new b("RECORD_STATE_STOP", 4);
    yiV = new b[] { yiQ, yiR, yiS, yiT, yiU };
    AppMethodBeat.o(317);
  }
  
  private a$b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.e.a.b
 * JD-Core Version:    0.7.0.1
 */