package com.tencent.mm.plugin.mediabasic.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mediabasic/data/MediaStatusCode;", "", "(Ljava/lang/String;I)V", "MediaRemuxError", "MediaRemuxSuccess", "MediaRemuxIgnore", "plugin-basic_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum d
{
  static
  {
    AppMethodBeat.i(269643);
    KOP = new d("MediaRemuxError", 0);
    KOQ = new d("MediaRemuxSuccess", 1);
    KOR = new d("MediaRemuxIgnore", 2);
    KOS = new d[] { KOP, KOQ, KOR };
    AppMethodBeat.o(269643);
  }
  
  private d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mediabasic.data.d
 * JD-Core Version:    0.7.0.1
 */