package com.facebook.share.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public enum LikeView$AuxiliaryViewPosition
{
  static AuxiliaryViewPosition DEFAULT;
  private int intValue;
  private String stringValue;
  
  static
  {
    AppMethodBeat.i(97630);
    BOTTOM = new AuxiliaryViewPosition("BOTTOM", 0, "bottom", 0);
    INLINE = new AuxiliaryViewPosition("INLINE", 1, "inline", 1);
    TOP = new AuxiliaryViewPosition("TOP", 2, "top", 2);
    $VALUES = new AuxiliaryViewPosition[] { BOTTOM, INLINE, TOP };
    DEFAULT = BOTTOM;
    AppMethodBeat.o(97630);
  }
  
  private LikeView$AuxiliaryViewPosition(String paramString, int paramInt)
  {
    this.stringValue = paramString;
    this.intValue = paramInt;
  }
  
  static AuxiliaryViewPosition fromInt(int paramInt)
  {
    AppMethodBeat.i(97628);
    AuxiliaryViewPosition[] arrayOfAuxiliaryViewPosition = values();
    int j = arrayOfAuxiliaryViewPosition.length;
    int i = 0;
    while (i < j)
    {
      AuxiliaryViewPosition localAuxiliaryViewPosition = arrayOfAuxiliaryViewPosition[i];
      if (localAuxiliaryViewPosition.getValue() == paramInt)
      {
        AppMethodBeat.o(97628);
        return localAuxiliaryViewPosition;
      }
      i += 1;
    }
    AppMethodBeat.o(97628);
    return null;
  }
  
  private int getValue()
  {
    return this.intValue;
  }
  
  public final String toString()
  {
    return this.stringValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.share.widget.LikeView.AuxiliaryViewPosition
 * JD-Core Version:    0.7.0.1
 */