package com.tencent.mm.plugin.finder.feed.jumper;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.g;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/jumper/FinderJumpInfoCache;", "", "()V", "desc", "", "getDesc", "()Ljava/lang/CharSequence;", "setDesc", "(Ljava/lang/CharSequence;)V", "failedIconColorRes", "", "getFailedIconColorRes", "()I", "setFailedIconColorRes", "(I)V", "failedIconResId", "getFailedIconResId", "setFailedIconResId", "iconUrl", "", "getIconUrl", "()Ljava/lang/String;", "setIconUrl", "(Ljava/lang/String;)V", "title", "getTitle", "setTitle", "checkInvalid", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class j
{
  public CharSequence BdX;
  public int BdY = e.g.icons_filled_link;
  public int BdZ = e.b.hot_tab_BW_100_Alpha_0_5;
  public String iconUrl;
  public CharSequence title;
  
  public final boolean edD()
  {
    AppMethodBeat.i(364183);
    CharSequence localCharSequence = this.title;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label70;
      }
      localCharSequence = this.BdX;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label65;
      }
    }
    label65:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label70;
      }
      AppMethodBeat.o(364183);
      return true;
      i = 0;
      break;
    }
    label70:
    AppMethodBeat.o(364183);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.jumper.j
 * JD-Core Version:    0.7.0.1
 */