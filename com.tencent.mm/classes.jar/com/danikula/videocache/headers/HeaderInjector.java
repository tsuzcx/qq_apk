package com.danikula.videocache.headers;

import java.util.Map;

public abstract interface HeaderInjector
{
  public abstract Map<String, String> addHeaders(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.danikula.videocache.headers.HeaderInjector
 * JD-Core Version:    0.7.0.1
 */