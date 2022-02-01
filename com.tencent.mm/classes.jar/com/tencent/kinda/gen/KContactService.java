package com.tencent.kinda.gen;

public abstract interface KContactService
{
  public abstract void attachAvatar(String paramString, KImageView paramKImageView);
  
  public abstract KContact get(String paramString);
  
  public abstract long getCryptUin();
  
  public abstract String getUserName();
  
  public abstract boolean isEuropeRegUser();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.KContactService
 * JD-Core Version:    0.7.0.1
 */