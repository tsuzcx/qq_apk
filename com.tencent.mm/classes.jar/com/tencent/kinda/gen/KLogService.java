package com.tencent.kinda.gen;

public abstract interface KLogService
{
  public abstract void debug(String paramString1, String paramString2);
  
  public abstract void error(String paramString1, String paramString2);
  
  public abstract void info(String paramString1, String paramString2);
  
  public abstract void verbose(String paramString1, String paramString2);
  
  public abstract void warning(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.KLogService
 * JD-Core Version:    0.7.0.1
 */