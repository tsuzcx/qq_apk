package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class NavigationBarConfig
{
  public DynamicColor mBackgroundColor;
  public String mBarTitle;
  public LeftBarButtonType mLeftBarButtonType;
  public String mLeftButtonColor;
  public String mRightButtonColor;
  public String mRightButtonImage;
  public String mRightButtonTitle;
  public boolean mUseBlackStatusbar;
  
  public NavigationBarConfig() {}
  
  public NavigationBarConfig(DynamicColor paramDynamicColor, boolean paramBoolean, String paramString1, LeftBarButtonType paramLeftBarButtonType, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.mBackgroundColor = paramDynamicColor;
    this.mUseBlackStatusbar = paramBoolean;
    this.mBarTitle = paramString1;
    this.mLeftBarButtonType = paramLeftBarButtonType;
    this.mLeftButtonColor = paramString2;
    this.mRightButtonTitle = paramString3;
    this.mRightButtonImage = paramString4;
    this.mRightButtonColor = paramString5;
  }
  
  public final DynamicColor getBackgroundColor()
  {
    return this.mBackgroundColor;
  }
  
  public final String getBarTitle()
  {
    return this.mBarTitle;
  }
  
  public final LeftBarButtonType getLeftBarButtonType()
  {
    return this.mLeftBarButtonType;
  }
  
  public final String getLeftButtonColor()
  {
    return this.mLeftButtonColor;
  }
  
  public final String getRightButtonColor()
  {
    return this.mRightButtonColor;
  }
  
  public final String getRightButtonImage()
  {
    return this.mRightButtonImage;
  }
  
  public final String getRightButtonTitle()
  {
    return this.mRightButtonTitle;
  }
  
  public final boolean getUseBlackStatusbar()
  {
    return this.mUseBlackStatusbar;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(135957);
    String str = "NavigationBarConfig{mBackgroundColor=" + this.mBackgroundColor + ",mUseBlackStatusbar=" + this.mUseBlackStatusbar + ",mBarTitle=" + this.mBarTitle + ",mLeftBarButtonType=" + this.mLeftBarButtonType + ",mLeftButtonColor=" + this.mLeftButtonColor + ",mRightButtonTitle=" + this.mRightButtonTitle + ",mRightButtonImage=" + this.mRightButtonImage + ",mRightButtonColor=" + this.mRightButtonColor + "}";
    AppMethodBeat.o(135957);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.gen.NavigationBarConfig
 * JD-Core Version:    0.7.0.1
 */