package com.tencent.map.lib.models;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Keep
public class SubMarkerInfo
{
  private boolean mAvoidOtherMarker = false;
  private int mIconHeight;
  private String mIconName;
  private int mIconWidth;
  private boolean mInteractive = false;
  private boolean mIsAvoidAnnotation = false;
  
  public SubMarkerInfo avoidAnnotation(boolean paramBoolean)
  {
    this.mIsAvoidAnnotation = paramBoolean;
    return this;
  }
  
  public SubMarkerInfo avoidOtherMarker(boolean paramBoolean)
  {
    this.mAvoidOtherMarker = paramBoolean;
    return this;
  }
  
  public SubMarkerInfo iconHeight(int paramInt)
  {
    this.mIconHeight = paramInt;
    return this;
  }
  
  public SubMarkerInfo iconName(String paramString)
  {
    this.mIconName = paramString;
    return this;
  }
  
  public SubMarkerInfo iconWidth(int paramInt)
  {
    this.mIconWidth = paramInt;
    return this;
  }
  
  public SubMarkerInfo interactive(boolean paramBoolean)
  {
    this.mInteractive = paramBoolean;
    return this;
  }
  
  public String toString()
  {
    AppMethodBeat.i(209767);
    String str = "SubMarkerInfo{mIconName='" + this.mIconName + '\'' + ", mIconWidth=" + this.mIconWidth + ", mIconHeight=" + this.mIconHeight + ", mInteractive=" + this.mInteractive + ", mIsAvoidAnnotation=" + this.mIsAvoidAnnotation + ", mAvoidOtherMarker=" + this.mAvoidOtherMarker + '}';
    AppMethodBeat.o(209767);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.map.lib.models.SubMarkerInfo
 * JD-Core Version:    0.7.0.1
 */