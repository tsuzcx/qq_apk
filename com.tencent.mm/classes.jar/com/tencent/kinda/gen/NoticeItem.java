package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class NoticeItem
{
  public int mIsShowNotice;
  public String mJumpUrl;
  public String mLeftIcon;
  public String mNoticeId;
  public String mWording;
  
  public NoticeItem() {}
  
  public NoticeItem(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.mIsShowNotice = paramInt;
    this.mWording = paramString1;
    this.mLeftIcon = paramString2;
    this.mJumpUrl = paramString3;
    this.mNoticeId = paramString4;
  }
  
  public final int getIsShowNotice()
  {
    return this.mIsShowNotice;
  }
  
  public final String getJumpUrl()
  {
    return this.mJumpUrl;
  }
  
  public final String getLeftIcon()
  {
    return this.mLeftIcon;
  }
  
  public final String getNoticeId()
  {
    return this.mNoticeId;
  }
  
  public final String getWording()
  {
    return this.mWording;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(226764);
    String str = "NoticeItem{mIsShowNotice=" + this.mIsShowNotice + ",mWording=" + this.mWording + ",mLeftIcon=" + this.mLeftIcon + ",mJumpUrl=" + this.mJumpUrl + ",mNoticeId=" + this.mNoticeId + "}";
    AppMethodBeat.o(226764);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.gen.NoticeItem
 * JD-Core Version:    0.7.0.1
 */