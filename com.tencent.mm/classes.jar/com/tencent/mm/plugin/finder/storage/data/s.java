package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.axb;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/data/PageItem;", "", "()V", "source", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "(Lcom/tencent/mm/protocal/protobuf/FinderFPItem;)V", "getSource", "()Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "setSource", "extract", "targetDataType", "", "toRVFeed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class s
{
  public axb FNr;
  
  public s()
  {
    this.FNr = new axb();
  }
  
  public s(axb paramaxb)
  {
    this.FNr = paramaxb;
  }
  
  public abstract cc eIE();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.s
 * JD-Core Version:    0.7.0.1
 */