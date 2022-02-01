package com.tencent.mm.flutter.plugin.data_sources.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/flutter/plugin/data_sources/sns/SnsDataSource$SnsDataType;", "", "(Ljava/lang/String;I)V", "Text", "Image", "Video", "Unknown", "plugin-voip-status_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum a$b
{
  static
  {
    AppMethodBeat.i(233401);
    mrG = new b("Text", 0);
    mrH = new b("Image", 1);
    mrI = new b("Video", 2);
    mrJ = new b("Unknown", 3);
    mrK = new b[] { mrG, mrH, mrI, mrJ };
    AppMethodBeat.o(233401);
  }
  
  private a$b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.flutter.plugin.data_sources.d.a.b
 * JD-Core Version:    0.7.0.1
 */