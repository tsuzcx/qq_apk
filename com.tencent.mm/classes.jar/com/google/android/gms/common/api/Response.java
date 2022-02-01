package com.google.android.gms.common.api;

public class Response<T extends Result>
{
  private T zzdm;
  
  public Response() {}
  
  protected Response(T paramT)
  {
    this.zzdm = paramT;
  }
  
  protected T getResult()
  {
    return this.zzdm;
  }
  
  public void setResult(T paramT)
  {
    this.zzdm = paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.api.Response
 * JD-Core Version:    0.7.0.1
 */