package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ViewReportStruct
{
  public int mBgColor;
  public boolean mCheckBtnNoResponse;
  public boolean mCheckColor;
  public boolean mCheckViewExposure;
  public String mCustomKey;
  public ReportEvent mEvent;
  public String mViewId;
  
  public ViewReportStruct() {}
  
  public ViewReportStruct(String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, ReportEvent paramReportEvent, String paramString2)
  {
    this.mViewId = paramString1;
    this.mCheckViewExposure = paramBoolean1;
    this.mCheckBtnNoResponse = paramBoolean2;
    this.mCheckColor = paramBoolean3;
    this.mBgColor = paramInt;
    this.mEvent = paramReportEvent;
    this.mCustomKey = paramString2;
  }
  
  public final int getBgColor()
  {
    return this.mBgColor;
  }
  
  public final boolean getCheckBtnNoResponse()
  {
    return this.mCheckBtnNoResponse;
  }
  
  public final boolean getCheckColor()
  {
    return this.mCheckColor;
  }
  
  public final boolean getCheckViewExposure()
  {
    return this.mCheckViewExposure;
  }
  
  public final String getCustomKey()
  {
    return this.mCustomKey;
  }
  
  public final ReportEvent getEvent()
  {
    return this.mEvent;
  }
  
  public final String getViewId()
  {
    return this.mViewId;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(226732);
    String str = "ViewReportStruct{mViewId=" + this.mViewId + ",mCheckViewExposure=" + this.mCheckViewExposure + ",mCheckBtnNoResponse=" + this.mCheckBtnNoResponse + ",mCheckColor=" + this.mCheckColor + ",mBgColor=" + this.mBgColor + ",mEvent=" + this.mEvent + ",mCustomKey=" + this.mCustomKey + "}";
    AppMethodBeat.o(226732);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.kinda.gen.ViewReportStruct
 * JD-Core Version:    0.7.0.1
 */