package com.tencent.mm.plugin.findersdk.a;

import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.protocal.protobuf.buy;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/api/IMixSearchProfileAdapter;", "", "getContactList", "", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "getData", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeedPosition", "", "position", "getItemViewType", "getSafetyHint", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface cj
{
  public abstract int Td(int paramInt);
  
  public abstract List<buy> eOH();
  
  public abstract List<BaseFinderFeed> getData();
  
  public abstract int getItemViewType(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.cj
 * JD-Core Version:    0.7.0.1
 */