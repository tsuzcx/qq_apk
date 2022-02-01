package com.tencent.mm.plugin.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.pluginsdk.ui.tools.b;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/findersdk/api/MusicShareObjectUtil;", "", "()V", "isMusicShareObjectInvalid", "", "musicShareObject", "Lcom/tencent/mm/protocal/protobuf/MusicShareObject;", "parseFromMusicPiece", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "piece", "Lcom/tencent/mm/pluginsdk/ui/tools/AppContentMusicPiece;", "finder-sdk_release"})
public final class al
{
  public static final al wEm;
  
  static
  {
    AppMethodBeat.i(208798);
    wEm = new al();
    AppMethodBeat.o(208798);
  }
  
  public static final css a(k.b paramb, b paramb1)
  {
    AppMethodBeat.i(208796);
    if ((paramb1 != null) && (paramb != null))
    {
      css localcss = new css();
      localcss.Ktn = paramb1.Ktn;
      localcss.Kto = paramb1.Kto;
      localcss.Ktp = paramb1.Ktp;
      localcss.Ktq = paramb1.Ktq;
      localcss.singerName = paramb1.Ktr;
      localcss.albumName = paramb1.Kts;
      localcss.musicGenre = paramb1.Ktt;
      localcss.issueDate = Util.safeParseLong(paramb1.Ktu);
      localcss.identification = paramb1.Ktv;
      localcss.extraInfo = paramb.messageExt;
      localcss.Alz = paramb1.Alz;
      localcss.BPc = paramb.title;
      localcss.songLyric = paramb1.songLyric;
      localcss.EsK = paramb1.songAlbumUrl;
      AppMethodBeat.o(208796);
      return localcss;
    }
    AppMethodBeat.o(208796);
    return null;
  }
  
  public static final boolean b(css paramcss)
  {
    AppMethodBeat.i(208797);
    if (paramcss == null)
    {
      AppMethodBeat.o(208797);
      return true;
    }
    CharSequence localCharSequence = (CharSequence)paramcss.Ktn;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label119;
      }
      localCharSequence = (CharSequence)paramcss.Kto;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label109;
      }
      i = 1;
      label66:
      if (i == 0) {
        break label119;
      }
      paramcss = (CharSequence)paramcss.singerName;
      if ((paramcss != null) && (paramcss.length() != 0)) {
        break label114;
      }
    }
    label109:
    label114:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label119;
      }
      AppMethodBeat.o(208797);
      return true;
      i = 0;
      break;
      i = 0;
      break label66;
    }
    label119:
    AppMethodBeat.o(208797);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.al
 * JD-Core Version:    0.7.0.1
 */