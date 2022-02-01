package com.tencent.mm.plugin.findersdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.pluginsdk.ui.tools.b;
import com.tencent.mm.protocal.protobuf.dbr;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/api/MusicShareObjectUtil;", "", "()V", "isMusicShareObjectInvalid", "", "musicShareObject", "Lcom/tencent/mm/protocal/protobuf/MusicShareObject;", "parseFromMusicPiece", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "piece", "Lcom/tencent/mm/pluginsdk/ui/tools/AppContentMusicPiece;", "finder-sdk_release"})
public final class an
{
  public static final an Bvt;
  
  static
  {
    AppMethodBeat.i(208809);
    Bvt = new an();
    AppMethodBeat.o(208809);
  }
  
  public static final dbr a(k.b paramb, b paramb1)
  {
    AppMethodBeat.i(208807);
    if ((paramb1 != null) && (paramb != null))
    {
      dbr localdbr = new dbr();
      localdbr.Ruu = paramb1.Ruu;
      localdbr.Ruv = paramb1.Ruv;
      localdbr.Ruw = paramb1.Ruw;
      localdbr.Rux = paramb1.Rux;
      CharSequence localCharSequence = (CharSequence)paramb1.Ruy;
      int i;
      if ((localCharSequence == null) || (localCharSequence.length() == 0))
      {
        i = 1;
        if (i != 0) {
          break label178;
        }
      }
      label178:
      for (localdbr.singerName = paramb1.Ruy;; localdbr.singerName = paramb.description)
      {
        localdbr.albumName = paramb1.Ruz;
        localdbr.musicGenre = paramb1.RuA;
        localdbr.issueDate = Util.safeParseLong(paramb1.RuB);
        localdbr.identification = paramb1.RuC;
        localdbr.extraInfo = paramb.messageExt;
        localdbr.FSG = paramb1.FSG;
        localdbr.HLH = paramb.title;
        localdbr.songLyric = paramb1.songLyric;
        localdbr.KGh = paramb1.songAlbumUrl;
        AppMethodBeat.o(208807);
        return localdbr;
        i = 0;
        break;
      }
    }
    AppMethodBeat.o(208807);
    return null;
  }
  
  public static final boolean b(dbr paramdbr)
  {
    AppMethodBeat.i(208808);
    if (paramdbr == null)
    {
      AppMethodBeat.o(208808);
      return true;
    }
    CharSequence localCharSequence = (CharSequence)paramdbr.Ruu;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label119;
      }
      localCharSequence = (CharSequence)paramdbr.Ruv;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label109;
      }
      i = 1;
      label66:
      if (i == 0) {
        break label119;
      }
      paramdbr = (CharSequence)paramdbr.singerName;
      if ((paramdbr != null) && (paramdbr.length() != 0)) {
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
      AppMethodBeat.o(208808);
      return true;
      i = 0;
      break;
      i = 0;
      break label66;
    }
    label119:
    AppMethodBeat.o(208808);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.an
 * JD-Core Version:    0.7.0.1
 */