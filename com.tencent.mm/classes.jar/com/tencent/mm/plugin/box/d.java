package com.tencent.mm.plugin.box;

public abstract interface d
  extends com.tencent.mm.kernel.b.d
{
  public abstract a checkAllHotWords(String paramString);
  
  public abstract String checkFirstHotWord(String paramString);
  
  public abstract String getExposedFingerWord(String paramString);
  
  public abstract String getMatchedFingerWord(String paramString1, String paramString2);
  
  public abstract int getSearchDuration();
  
  public abstract String getWordBankVersionForStat();
  
  public static class a
  {
    public String vzP;
    public int vzQ;
    public String vzR;
    public String vzS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.box.d
 * JD-Core Version:    0.7.0.1
 */