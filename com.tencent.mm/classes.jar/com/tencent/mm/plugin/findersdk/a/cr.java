package com.tencent.mm.plugin.findersdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.message.k.b;
import com.tencent.mm.pluginsdk.ui.tools.b;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/api/MusicShareObjectUtil;", "", "()V", "isMusicShareObjectInvalid", "", "musicShareObject", "Lcom/tencent/mm/protocal/protobuf/MusicShareObject;", "parseFromMusicPiece", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "piece", "Lcom/tencent/mm/pluginsdk/ui/tools/AppContentMusicPiece;", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cr
{
  public static final cr HcB;
  
  static
  {
    AppMethodBeat.i(274026);
    HcB = new cr();
    AppMethodBeat.o(274026);
  }
  
  public static final dtj a(k.b paramb, b paramb1)
  {
    AppMethodBeat.i(274018);
    if ((paramb1 != null) && (paramb != null))
    {
      dtj localdtj = new dtj();
      localdtj.YqN = paramb1.YqN;
      localdtj.YqO = paramb1.YqO;
      localdtj.YqP = paramb1.YqP;
      localdtj.YqQ = paramb1.YqQ;
      CharSequence localCharSequence = (CharSequence)paramb1.YqR;
      int i;
      if ((localCharSequence == null) || (localCharSequence.length() == 0))
      {
        i = 1;
        if (i != 0) {
          break label194;
        }
      }
      label194:
      for (localdtj.singerName = paramb1.YqR;; localdtj.singerName = paramb.description)
      {
        localdtj.albumName = paramb1.YqS;
        localdtj.musicGenre = paramb1.YqT;
        localdtj.issueDate = Util.safeParseLong(paramb1.YqU);
        localdtj.identification = paramb1.YqV;
        localdtj.extraInfo = paramb.messageExt;
        localdtj.LNC = paramb1.LNC;
        localdtj.musicOperationUrl = paramb1.YqX;
        localdtj.oOZ = paramb1.oOZ;
        localdtj.songName = paramb.title;
        localdtj.songLyric = paramb1.songLyric;
        localdtj.RfH = paramb1.songAlbumUrl;
        AppMethodBeat.o(274018);
        return localdtj;
        i = 0;
        break;
      }
    }
    AppMethodBeat.o(274018);
    return null;
  }
  
  public static final boolean b(dtj paramdtj)
  {
    AppMethodBeat.i(274022);
    if (paramdtj == null)
    {
      AppMethodBeat.o(274022);
      return true;
    }
    CharSequence localCharSequence = (CharSequence)paramdtj.YqN;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label119;
      }
      localCharSequence = (CharSequence)paramdtj.YqO;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label109;
      }
      i = 1;
      label66:
      if (i == 0) {
        break label119;
      }
      paramdtj = (CharSequence)paramdtj.singerName;
      if ((paramdtj != null) && (paramdtj.length() != 0)) {
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
      AppMethodBeat.o(274022);
      return true;
      i = 0;
      break;
      i = 0;
      break label66;
    }
    label119:
    AppMethodBeat.o(274022);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.cr
 * JD-Core Version:    0.7.0.1
 */