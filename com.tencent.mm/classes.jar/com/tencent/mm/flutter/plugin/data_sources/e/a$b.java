package com.tencent.mm.flutter.plugin.data_sources.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/flutter/plugin/data_sources/text_status/TextStatusDataSource$TextStatusType;", "", "(Ljava/lang/String;I)V", "None", "Image", "Video", "Companion", "plugin-voip-status_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum a$b
{
  public static final a mrW;
  
  static
  {
    AppMethodBeat.i(233328);
    mrX = new b("None", 0);
    mrY = new b("Image", 1);
    mrZ = new b("Video", 2);
    msa = new b[] { mrX, mrY, mrZ };
    mrW = new a((byte)0);
    AppMethodBeat.o(233328);
  }
  
  private a$b() {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/flutter/plugin/data_sources/text_status/TextStatusDataSource$TextStatusType$Companion;", "", "()V", "fromMediaType", "Lcom/tencent/mm/flutter/plugin/data_sources/text_status/TextStatusDataSource$TextStatusType;", "type", "", "plugin-voip-status_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.flutter.plugin.data_sources.e.a.b
 * JD-Core Version:    0.7.0.1
 */