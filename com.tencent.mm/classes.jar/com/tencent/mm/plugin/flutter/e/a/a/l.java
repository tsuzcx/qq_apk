package com.tencent.mm.plugin.flutter.e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.res.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/flutter/plugins/video/api/MMVideoEditorTextFetcher;", "", "()V", "FLUTTER_TAG", "", "getFLUTTER_TAG", "()Ljava/lang/String;", "checkFontFamilyRes", "", "getFontFamilyData", "", "Companion", "plugin-flutter_release"})
public final class l
{
  private static l wKv;
  public static final a wKw;
  final String vRb = "MMVideoEditorTextFetcher.FlutterVideoEditor_DataReport";
  
  static
  {
    AppMethodBeat.i(241099);
    wKw = new a((byte)0);
    AppMethodBeat.o(241099);
  }
  
  public final boolean dMa()
  {
    AppMethodBeat.i(241098);
    if (!e.BYn.BXZ)
    {
      h.CyF.dN(1565, 10);
      Log.i(this.vRb, "start to download font");
      e.BYn.BYa = ((kotlin.g.a.a)new b(this));
    }
    e.BYn.bbA();
    boolean bool = e.BYn.BXZ;
    AppMethodBeat.o(241098);
    return bool;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/flutter/plugins/video/api/MMVideoEditorTextFetcher$Companion;", "", "()V", "mInstance", "Lcom/tencent/mm/plugin/flutter/plugins/video/api/MMVideoEditorTextFetcher;", "getInstance", "plugin-flutter_release"})
  public static final class a
  {
    public static l dMc()
    {
      AppMethodBeat.i(241096);
      if (l.dMb() == null) {
        l.a(new l((byte)0));
      }
      l locall = l.dMb();
      if (locall == null) {
        p.hyc();
      }
      AppMethodBeat.o(241096);
      return locall;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(l paraml)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.e.a.a.l
 * JD-Core Version:    0.7.0.1
 */