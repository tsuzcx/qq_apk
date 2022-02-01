package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.protocal.protobuf.amo;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/data/PageItem;", "", "()V", "source", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "(Lcom/tencent/mm/protocal/protobuf/FinderFPItem;)V", "getSource", "()Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "setSource", "extract", "targetDataType", "", "toRVFeed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "plugin-finder_release"})
public abstract class o
{
  amo sAk;
  
  public o()
  {
    this.sAk = new amo();
  }
  
  public o(amo paramamo)
  {
    this.sAk = paramamo;
  }
  
  public abstract al cJk();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.o
 * JD-Core Version:    0.7.0.1
 */