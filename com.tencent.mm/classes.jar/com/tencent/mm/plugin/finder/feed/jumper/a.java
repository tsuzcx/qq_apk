package com.tencent.mm.plugin.finder.feed.jumper;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import com.tencent.mm.protocal.protobuf.Html5Info;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/jumper/AdMutualCacheHandler;", "Lcom/tencent/mm/plugin/finder/feed/jumper/JumperCacheHandler;", "()V", "onGenerate", "Lcom/tencent/mm/plugin/finder/feed/jumper/FinderJumpInfoCache;", "info", "Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements q
{
  public static final a.a EJy;
  
  static
  {
    AppMethodBeat.i(370894);
    EJy = new a.a((byte)0);
    AppMethodBeat.o(370894);
  }
  
  public final j a(FinderJumpInfo paramFinderJumpInfo)
  {
    AppMethodBeat.i(364197);
    s.u(paramFinderJumpInfo, "info");
    Log.i("AdMutualCacheHandler", String.valueOf(paramFinderJumpInfo.ext_info));
    l locall;
    int i;
    if ((Util.isNullOrNil(paramFinderJumpInfo.ext_info)) || (s.p("{}", paramFinderJumpInfo.ext_info)))
    {
      locall = new l(new i());
      CharSequence localCharSequence = (CharSequence)locall.url;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label140;
      }
      i = 1;
      label86:
      if (i != 0)
      {
        paramFinderJumpInfo = paramFinderJumpInfo.html5_info;
        if (paramFinderJumpInfo != null) {
          break label145;
        }
      }
    }
    label140:
    label145:
    for (paramFinderJumpInfo = null;; paramFinderJumpInfo = paramFinderJumpInfo.url)
    {
      locall.url = paramFinderJumpInfo;
      paramFinderJumpInfo = (j)locall;
      AppMethodBeat.o(364197);
      return paramFinderJumpInfo;
      locall = new l(new i(paramFinderJumpInfo.ext_info));
      break;
      i = 0;
      break label86;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.jumper.a
 * JD-Core Version:    0.7.0.1
 */