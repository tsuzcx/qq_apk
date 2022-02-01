package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/model/BizTLRecFeedUtil$BizTimelineClickScene;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "CLICK_SUBSCRIBE", "CLICK_REC", "CLICK_REC_FEED", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum a$a
{
  private final int value;
  
  static
  {
    AppMethodBeat.i(302208);
    vNS = new a("CLICK_SUBSCRIBE", 0, 0);
    vNT = new a("CLICK_REC", 1, 1);
    vNU = new a("CLICK_REC_FEED", 2, 2);
    vNV = new a[] { vNS, vNT, vNU };
    AppMethodBeat.o(302208);
  }
  
  private a$a(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a
 * JD-Core Version:    0.7.0.1
 */