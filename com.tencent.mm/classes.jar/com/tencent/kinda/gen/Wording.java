package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Wording
{
  public String mDesc;
  public String mEntryTip;
  public boolean mNeedshow;
  public String mSubDesc;
  public String mSubTitle;
  public String mTitle;
  
  public Wording() {}
  
  public Wording(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.mNeedshow = paramBoolean;
    this.mEntryTip = paramString1;
    this.mTitle = paramString2;
    this.mSubTitle = paramString3;
    this.mDesc = paramString4;
    this.mSubDesc = paramString5;
  }
  
  public final String getDesc()
  {
    return this.mDesc;
  }
  
  public final String getEntryTip()
  {
    return this.mEntryTip;
  }
  
  public final boolean getNeedshow()
  {
    return this.mNeedshow;
  }
  
  public final String getSubDesc()
  {
    return this.mSubDesc;
  }
  
  public final String getSubTitle()
  {
    return this.mSubTitle;
  }
  
  public final String getTitle()
  {
    return this.mTitle;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(136069);
    String str = "Wording{mNeedshow=" + this.mNeedshow + ",mEntryTip=" + this.mEntryTip + ",mTitle=" + this.mTitle + ",mSubTitle=" + this.mSubTitle + ",mDesc=" + this.mDesc + ",mSubDesc=" + this.mSubDesc + "}";
    AppMethodBeat.o(136069);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.Wording
 * JD-Core Version:    0.7.0.1
 */