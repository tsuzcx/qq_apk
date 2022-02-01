package com.tencent.mm.flutter.plugin.data_sources.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/flutter/plugin/data_sources/finder/FinderDataSource$FinderItemType;", "", "(Ljava/lang/String;I)V", "Image", "Video", "Live", "plugin-voip-status_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum a$b
{
  static
  {
    AppMethodBeat.i(233313);
    mrm = new b("Image", 0);
    mrn = new b("Video", 1);
    mro = new b("Live", 2);
    mrp = new b[] { mrm, mrn, mro };
    AppMethodBeat.o(233313);
  }
  
  private a$b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.flutter.plugin.data_sources.b.a.b
 * JD-Core Version:    0.7.0.1
 */