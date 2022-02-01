package com.tencent.kinda.gen;

public abstract interface KPayEditText
  extends KEditText
{
  public abstract PayEditState getEditState();
  
  public abstract String getInputText();
  
  public abstract String getSalt();
  
  public abstract void setEditState(PayEditState paramPayEditState);
  
  public abstract void setSalt(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.gen.KPayEditText
 * JD-Core Version:    0.7.0.1
 */