package com.tencent.kinda.gen;

public abstract interface KActionSheet
{
  public abstract void addButtonImpl(String paramString, VoidCallback paramVoidCallback);
  
  public abstract void setCancelButtonTitle(String paramString);
  
  public abstract void setDestructiveIndex(int paramInt);
  
  public abstract void setTitle(String paramString);
  
  public abstract void show();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.gen.KActionSheet
 * JD-Core Version:    0.7.0.1
 */