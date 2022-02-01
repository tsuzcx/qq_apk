package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.protocal.protobuf.aqq;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/data/PageItem;", "", "()V", "source", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "(Lcom/tencent/mm/protocal/protobuf/FinderFPItem;)V", "getSource", "()Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "setSource", "extract", "targetDataType", "", "toRVFeed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "plugin-finder_release"})
public abstract class s
{
  aqq vGD;
  
  public s()
  {
    this.vGD = new aqq();
  }
  
  public s(aqq paramaqq)
  {
    this.vGD = paramaqq;
  }
  
  public abstract bo dyH();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.s
 * JD-Core Version:    0.7.0.1
 */