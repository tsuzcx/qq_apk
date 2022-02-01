package com.etrump.mixlayout;

public class ETFont
{
  public static final int ET_COLOR_BLACK = -16777216;
  public int mFontColor;
  public int mFontId;
  private String mFontPath;
  private int mFontSize;
  private final int mFontSizeMin = 8;
  
  public ETFont(int paramInt, String paramString, float paramFloat)
  {
    this.mFontId = paramInt;
    this.mFontPath = paramString;
    setSize(paramFloat);
    this.mFontColor = -16777216;
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = (ETFont)paramObject;
    return (this.mFontId == paramObject.mFontId) && (this.mFontColor == paramObject.mFontColor) && (this.mFontSize == paramObject.mFontSize);
  }
  
  public int getColor()
  {
    return this.mFontColor;
  }
  
  public int getId()
  {
    return this.mFontId;
  }
  
  public String getPath()
  {
    return this.mFontPath;
  }
  
  public int getSize()
  {
    return this.mFontSize;
  }
  
  public void setColor(int paramInt)
  {
    this.mFontColor = paramInt;
  }
  
  public void setId(int paramInt)
  {
    this.mFontId = paramInt;
  }
  
  public void setPath(String paramString)
  {
    this.mFontPath = paramString;
  }
  
  public void setSize(float paramFloat)
  {
    int i = 8;
    int j = (int)paramFloat;
    if (j < 8) {}
    for (;;)
    {
      this.mFontSize = i;
      return;
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.etrump.mixlayout.ETFont
 * JD-Core Version:    0.7.0.1
 */