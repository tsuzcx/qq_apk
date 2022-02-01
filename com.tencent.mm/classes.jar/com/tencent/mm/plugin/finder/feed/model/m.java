package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderSurveyItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "leafId", "", "wording", "", "(JLjava/lang/String;)V", "getLeafId", "()J", "getWording", "()Ljava/lang/String;", "getItemId", "getItemType", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  implements a
{
  public final long BiZ;
  public final String wording;
  
  public m(long paramLong, String paramString)
  {
    AppMethodBeat.i(366368);
    this.BiZ = paramLong;
    this.wording = paramString;
    AppMethodBeat.o(366368);
  }
  
  public final long bZA()
  {
    return 0L;
  }
  
  public final int bZB()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.m
 * JD-Core Version:    0.7.0.1
 */