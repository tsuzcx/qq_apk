package com.tencent.mm.plugin.finder.storage.config;

import d.l;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "", "title", "", "(Ljava/lang/String;)V", "chosenIndex", "", "getChosenIndex", "()I", "setChosenIndex", "(I)V", "getTitle", "()Ljava/lang/String;", "setTitle", "itemNameList", "", "onItemClick", "", "index", "reset", "svrValue", "plugin-finder_release"})
public abstract class d
{
  public int szz;
  public String title;
  
  public d(String paramString)
  {
    this.title = paramString;
    this.szz = -1;
  }
  
  public abstract void Fq(int paramInt);
  
  public List<String> cIW()
  {
    return (List)new LinkedList();
  }
  
  public abstract String cIX();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.config.d
 * JD-Core Version:    0.7.0.1
 */