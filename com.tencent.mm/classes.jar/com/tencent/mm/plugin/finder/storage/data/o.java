package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.protocal.protobuf.ana;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/data/PageItem;", "", "()V", "source", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "(Lcom/tencent/mm/protocal/protobuf/FinderFPItem;)V", "getSource", "()Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "setSource", "extract", "targetDataType", "", "toRVFeed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "plugin-finder_release"})
public abstract class o
{
  ana sLi;
  
  public o()
  {
    this.sLi = new ana();
  }
  
  public o(ana paramana)
  {
    this.sLi = paramana;
  }
  
  public abstract am cLN();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.o
 * JD-Core Version:    0.7.0.1
 */