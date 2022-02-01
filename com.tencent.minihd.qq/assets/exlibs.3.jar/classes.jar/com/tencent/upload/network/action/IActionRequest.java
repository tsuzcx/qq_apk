package com.tencent.upload.network.action;

import java.io.File;

public abstract interface IActionRequest
{
  public abstract byte[] encode();
  
  public abstract int getActionSequence();
  
  public abstract int getCommandId();
  
  public abstract File getFile();
  
  public abstract int getFileOffset();
  
  public abstract int getFileSendLenght();
  
  public abstract int getRequestSequence();
  
  public abstract boolean isPartFileMode();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.upload.network.action.IActionRequest
 * JD-Core Version:    0.7.0.1
 */