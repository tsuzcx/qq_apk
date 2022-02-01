package com.tencent.mm.plugin.finder.storage.config;

import android.app.Activity;
import java.util.LinkedList;
import java.util.List;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "", "title", "", "(Ljava/lang/String;)V", "chosenIndex", "", "getChosenIndex", "()I", "setChosenIndex", "(I)V", "context", "Landroid/app/Activity;", "getContext", "()Landroid/app/Activity;", "setContext", "(Landroid/app/Activity;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "itemNameList", "", "onItemClick", "", "index", "reset", "setActivityContext", "svrValue", "versionTag", "plugin-finder_release"})
public abstract class e
{
  public Activity dKq;
  public String title;
  public int vFI;
  
  public e(String paramString)
  {
    this.title = paramString;
    this.vFI = -1;
  }
  
  public abstract void Lc(int paramInt);
  
  public List<String> dyo()
  {
    return (List)new LinkedList();
  }
  
  public abstract String dyp();
  
  public abstract String dyq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.config.e
 * JD-Core Version:    0.7.0.1
 */