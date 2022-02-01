package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class KJumpRemindInfo
{
  public boolean mIsPopUpWindows;
  public int mJumpType;
  public String mLeftButtonWording;
  public String mRightButtonWording;
  public String mTitle;
  public KRedirectUrl mUrl;
  public String mWording;
  
  public KJumpRemindInfo() {}
  
  public KJumpRemindInfo(int paramInt, boolean paramBoolean, String paramString1, String paramString2, String paramString3, KRedirectUrl paramKRedirectUrl, String paramString4)
  {
    this.mJumpType = paramInt;
    this.mIsPopUpWindows = paramBoolean;
    this.mWording = paramString1;
    this.mLeftButtonWording = paramString2;
    this.mRightButtonWording = paramString3;
    this.mUrl = paramKRedirectUrl;
    this.mTitle = paramString4;
  }
  
  public final boolean getIsPopUpWindows()
  {
    return this.mIsPopUpWindows;
  }
  
  public final int getJumpType()
  {
    return this.mJumpType;
  }
  
  public final String getLeftButtonWording()
  {
    return this.mLeftButtonWording;
  }
  
  public final String getRightButtonWording()
  {
    return this.mRightButtonWording;
  }
  
  public final String getTitle()
  {
    return this.mTitle;
  }
  
  public final KRedirectUrl getUrl()
  {
    return this.mUrl;
  }
  
  public final String getWording()
  {
    return this.mWording;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(135834);
    String str = "KJumpRemindInfo{mJumpType=" + this.mJumpType + ",mIsPopUpWindows=" + this.mIsPopUpWindows + ",mWording=" + this.mWording + ",mLeftButtonWording=" + this.mLeftButtonWording + ",mRightButtonWording=" + this.mRightButtonWording + ",mUrl=" + this.mUrl + ",mTitle=" + this.mTitle + "}";
    AppMethodBeat.o(135834);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.gen.KJumpRemindInfo
 * JD-Core Version:    0.7.0.1
 */