package com.tencent.mm.plugin.mediabasic.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mediabasic/data/MediaBasicType;", "", "(Ljava/lang/String;I)V", "VIDEO", "AUDIO", "IMAGE", "THUMB", "plugin-basic_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum a
{
  static
  {
    AppMethodBeat.i(269650);
    KOz = new a("VIDEO", 0);
    KOA = new a("AUDIO", 1);
    KOB = new a("IMAGE", 2);
    KOC = new a("THUMB", 3);
    KOD = new a[] { KOz, KOA, KOB, KOC };
    AppMethodBeat.o(269650);
  }
  
  private a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mediabasic.data.a
 * JD-Core Version:    0.7.0.1
 */