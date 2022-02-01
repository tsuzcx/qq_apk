package com.tencent.mm.plugin.finder.storage.config;

import d.l;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "", "title", "", "(Ljava/lang/String;)V", "chosenIndex", "", "getChosenIndex", "()I", "setChosenIndex", "(I)V", "getTitle", "()Ljava/lang/String;", "setTitle", "itemNameList", "", "onItemClick", "", "index", "reset", "svrValue", "plugin-finder_release"})
public abstract class d
{
  public int sKs;
  public String title;
  
  public d(String paramString)
  {
    this.title = paramString;
    this.sKs = -1;
  }
  
  public abstract void FN(int paramInt);
  
  public List<String> cLy()
  {
    return (List)new LinkedList();
  }
  
  public abstract String cLz();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.config.d
 * JD-Core Version:    0.7.0.1
 */