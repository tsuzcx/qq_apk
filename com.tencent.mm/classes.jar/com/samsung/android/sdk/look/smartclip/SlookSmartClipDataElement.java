package com.samsung.android.sdk.look.smartclip;

import android.graphics.Rect;

public abstract interface SlookSmartClipDataElement
{
  public abstract void addTag(SlookSmartClipMetaTag paramSlookSmartClipMetaTag);
  
  public abstract SlookSmartClipMetaTagArray getAllTag();
  
  public abstract Rect getMetaAreaRect();
  
  public abstract SlookSmartClipMetaTagArray getTag(String paramString);
  
  public abstract void removeTag(String paramString);
  
  public abstract void setMetaAreaRect(Rect paramRect);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.samsung.android.sdk.look.smartclip.SlookSmartClipDataElement
 * JD-Core Version:    0.7.0.1
 */