package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class NavigationBarConfig
{
  public String mBackgroundColor;
  public String mBarTitle;
  public LeftBarButtonType mLeftBarButtonType;
  public String mLeftButtonColor;
  public String mRightButtonColor;
  public String mRightButtonImage;
  public String mRightButtonTitle;
  public boolean mUseBlackStatusbar;
  
  public NavigationBarConfig() {}
  
  public NavigationBarConfig(String paramString1, boolean paramBoolean, String paramString2, LeftBarButtonType paramLeftBarButtonType, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.mBackgroundColor = paramString1;
    this.mUseBlackStatusbar = paramBoolean;
    this.mBarTitle = paramString2;
    this.mLeftBarButtonType = paramLeftBarButtonType;
    this.mLeftButtonColor = paramString3;
    this.mRightButtonTitle = paramString4;
    this.mRightButtonImage = paramString5;
    this.mRightButtonColor = paramString6;
  }
  
  public final String getBackgroundColor()
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
    AppMethodBeat.i(141438);
    String str = "NavigationBarConfig{mBackgroundColor=" + this.mBackgroundColor + ",mUseBlackStatusbar=" + this.mUseBlackStatusbar + ",mBarTitle=" + this.mBarTitle + ",mLeftBarButtonType=" + this.mLeftBarButtonType + ",mLeftButtonColor=" + this.mLeftButtonColor + ",mRightButtonTitle=" + this.mRightButtonTitle + ",mRightButtonImage=" + this.mRightButtonImage + ",mRightButtonColor=" + this.mRightButtonColor + "}";
    AppMethodBeat.o(141438);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.kinda.gen.NavigationBarConfig
 * JD-Core Version:    0.7.0.1
 */