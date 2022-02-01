package com.danikula.videocache;

import java.io.File;

public abstract interface CacheListener
{
  public abstract void onCacheAvailable(File paramFile, String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.danikula.videocache.CacheListener
 * JD-Core Version:    0.7.0.1
 */