package com.danikula.videocache.sourcestorage;

import com.danikula.videocache.SourceInfo;

public abstract interface SourceInfoStorage
{
  public abstract SourceInfo get(String paramString);
  
  public abstract void put(String paramString, SourceInfo paramSourceInfo);
  
  public abstract void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.danikula.videocache.sourcestorage.SourceInfoStorage
 * JD-Core Version:    0.7.0.1
 */