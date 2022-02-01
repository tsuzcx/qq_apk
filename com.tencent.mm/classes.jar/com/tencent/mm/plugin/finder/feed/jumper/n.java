package com.tencent.mm.plugin.finder.feed.jumper;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/jumper/FinderShopJumpInfoCache;", "Lcom/tencent/mm/plugin/finder/feed/jumper/FinderJumpInfoCache;", "iconUrl", "", "wording", "recommendReason", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  extends j
{
  public static final n.a Bei;
  
  static
  {
    AppMethodBeat.i(364177);
    Bei = new n.a((byte)0);
    AppMethodBeat.o(364177);
  }
  
  public n(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(364171);
    this.iconUrl = paramString1;
    this.title = ((CharSequence)paramString2);
    this.BdX = ((CharSequence)paramString3);
    AppMethodBeat.o(364171);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.jumper.n
 * JD-Core Version:    0.7.0.1
 */