package com.danikula.videocache.sourcestorage;

import com.danikula.videocache.SourceInfo;

public class NoSourceInfoStorage
  implements SourceInfoStorage
{
  public SourceInfo get(String paramString)
  {
    return null;
  }
  
  public void put(String paramString, SourceInfo paramSourceInfo) {}
  
  public void release() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.danikula.videocache.sourcestorage.NoSourceInfoStorage
 * JD-Core Version:    0.7.0.1
 */