package com.tencent.mm.plugin.finder.upload;

import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "", "onPostEnd", "", "localId", "", "isOk", "", "onPostNotify", "onPostOk", "svrID", "onPostStart", "plugin-finder-publish-api_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface r
{
  public abstract void onPostEnd(long paramLong, boolean paramBoolean);
  
  public abstract void onPostNotify(long paramLong, boolean paramBoolean);
  
  public abstract void onPostOk(long paramLong1, long paramLong2);
  
  public abstract void onPostStart(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.r
 * JD-Core Version:    0.7.0.1
 */