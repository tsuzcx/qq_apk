package com.tencent.mm.plugin.finder.publish;

import com.tencent.mm.plugin.finder.upload.q;
import com.tencent.mm.plugin.finder.upload.r;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/publish/IFinderPostManager;", "", "addDraftListener", "", "listener", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostDraftListener;", "addPostEndListener", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "checkNextPost", "checkToStart", "doPostMv", "", "musicData", "draftObjectId", "rePost", "feed", "rePostDraft", "draft", "removeDraftListener", "removePostEndListener", "uploadActivityCover", "path", "", "callback", "uploadCoverImage", "userName", "uploadLiveCoverImage", "plugin-finder-publish-api_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface b
{
  public abstract void E(String paramString, Object paramObject);
  
  public abstract void a(q paramq);
  
  public abstract void a(r paramr);
  
  public abstract void b(q paramq);
  
  public abstract void b(r paramr);
  
  public abstract void eKX();
  
  public abstract void eKY();
  
  public abstract void fy(Object paramObject);
  
  public abstract void fz(Object paramObject);
  
  public abstract void g(String paramString1, String paramString2, Object paramObject);
  
  public abstract void h(String paramString1, String paramString2, Object paramObject);
  
  public abstract long u(Object paramObject, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.publish.b
 * JD-Core Version:    0.7.0.1
 */