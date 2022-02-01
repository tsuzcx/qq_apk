package com.google.android.gms.wearable;

public abstract interface MessageEvent
{
  public abstract byte[] getData();
  
  public abstract String getPath();
  
  public abstract int getRequestId();
  
  public abstract String getSourceNodeId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.MessageEvent
 * JD-Core Version:    0.7.0.1
 */