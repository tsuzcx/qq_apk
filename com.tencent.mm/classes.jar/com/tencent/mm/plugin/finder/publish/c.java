package com.tencent.mm.plugin.finder.publish;

import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/publish/IPluginFinderPublish;", "Lcom/tencent/mm/kernel/plugin/IAlias;", "finderPostFileManager", "Lcom/tencent/mm/plugin/finder/publish/IFinderPostFileManager;", "finderPostManager", "Lcom/tencent/mm/plugin/finder/publish/IFinderPostManager;", "publishPostApi", "Lcom/tencent/mm/plugin/finder/publish/IPublishPostApi;", "publishRouterApi", "Lcom/tencent/mm/plugin/finder/publish/IPublishRouterApi;", "publishStatApi", "Lcom/tencent/mm/plugin/finder/publish/IPublishStatApi;", "publishVlogApi", "Lcom/tencent/mm/plugin/finder/publish/IPublishVlogApi;", "Companion", "plugin-finder-publish-api_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface c
  extends com.tencent.mm.kernel.b.a
{
  public static final c.a FhO = c.a.FhP;
  
  public abstract a finderPostFileManager();
  
  public abstract b finderPostManager();
  
  public abstract d publishPostApi();
  
  public abstract e publishRouterApi();
  
  public abstract f publishStatApi();
  
  public abstract g publishVlogApi();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.publish.c
 * JD-Core Version:    0.7.0.1
 */