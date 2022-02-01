package com.google.d;

import java.io.InputStream;
import java.nio.ByteBuffer;

public abstract interface cs<MessageType>
{
  public abstract MessageType parseDelimitedFrom(InputStream paramInputStream);
  
  public abstract MessageType parseDelimitedFrom(InputStream paramInputStream, at paramat);
  
  public abstract MessageType parseFrom(h paramh);
  
  public abstract MessageType parseFrom(h paramh, at paramat);
  
  public abstract MessageType parseFrom(i parami);
  
  public abstract MessageType parseFrom(i parami, at paramat);
  
  public abstract MessageType parseFrom(InputStream paramInputStream);
  
  public abstract MessageType parseFrom(InputStream paramInputStream, at paramat);
  
  public abstract MessageType parseFrom(ByteBuffer paramByteBuffer);
  
  public abstract MessageType parseFrom(ByteBuffer paramByteBuffer, at paramat);
  
  public abstract MessageType parseFrom(byte[] paramArrayOfByte);
  
  public abstract MessageType parseFrom(byte[] paramArrayOfByte, at paramat);
  
  public abstract MessageType parsePartialFrom(i parami, at paramat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.cs
 * JD-Core Version:    0.7.0.1
 */