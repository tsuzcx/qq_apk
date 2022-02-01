package com.facebook.share;

public abstract interface Sharer
{
  public abstract boolean getShouldFailOnDataError();
  
  public abstract void setShouldFailOnDataError(boolean paramBoolean);
  
  public static class Result
  {
    final String postId;
    
    public Result(String paramString)
    {
      this.postId = paramString;
    }
    
    public String getPostId()
    {
      return this.postId;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.share.Sharer
 * JD-Core Version:    0.7.0.1
 */