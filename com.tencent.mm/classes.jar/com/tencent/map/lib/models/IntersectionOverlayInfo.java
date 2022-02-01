package com.tencent.map.lib.models;

import android.graphics.Rect;

public class IntersectionOverlayInfo
{
  protected Rect mBounds;
  protected byte[] mData;
  protected int mDistance;
  protected boolean mIsDarkMode;
  protected boolean mVisibility = true;
  
  public void enableDarkMode(boolean paramBoolean)
  {
    this.mIsDarkMode = paramBoolean;
  }
  
  public void setBounds(Rect paramRect)
  {
    this.mBounds = paramRect;
  }
  
  public void setData(byte[] paramArrayOfByte)
  {
    this.mData = paramArrayOfByte;
  }
  
  public void setDistance(int paramInt)
  {
    this.mDistance = paramInt;
  }
  
  public void setVisibility(boolean paramBoolean)
  {
    this.mVisibility = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.map.lib.models.IntersectionOverlayInfo
 * JD-Core Version:    0.7.0.1
 */