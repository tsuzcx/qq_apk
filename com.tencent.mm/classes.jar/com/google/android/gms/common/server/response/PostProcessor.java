package com.google.android.gms.common.server.response;

public abstract interface PostProcessor<T extends FastJsonResponse>
{
  public abstract T postProcess(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.server.response.PostProcessor
 * JD-Core Version:    0.7.0.1
 */