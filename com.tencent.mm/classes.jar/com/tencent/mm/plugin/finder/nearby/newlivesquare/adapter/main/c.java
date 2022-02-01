package com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main;

import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/BaseFactory;", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "()V", "createFinderEmptyConvert", "Lcom/tencent/mm/plugin/finder/convert/FinderEmptyConvert;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class c
  implements com.tencent.mm.view.recyclerview.g
{
  public static com.tencent.mm.plugin.finder.convert.g eFP()
  {
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED)) {
      throw new RuntimeException("type invalid");
    }
    Log.printInfoStack("RecyclerViewAdapterEx", "type invalid", new Object[0]);
    return new com.tencent.mm.plugin.finder.convert.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.c
 * JD-Core Version:    0.7.0.1
 */