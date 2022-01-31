package com.facebook.share.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public enum LikeView$HorizontalAlignment
{
  static HorizontalAlignment DEFAULT;
  private int intValue;
  private String stringValue;
  
  static
  {
    AppMethodBeat.i(97635);
    CENTER = new HorizontalAlignment("CENTER", 0, "center", 0);
    LEFT = new HorizontalAlignment("LEFT", 1, "left", 1);
    RIGHT = new HorizontalAlignment("RIGHT", 2, "right", 2);
    $VALUES = new HorizontalAlignment[] { CENTER, LEFT, RIGHT };
    DEFAULT = CENTER;
    AppMethodBeat.o(97635);
  }
  
  private LikeView$HorizontalAlignment(String paramString, int paramInt)
  {
    this.stringValue = paramString;
    this.intValue = paramInt;
  }
  
  static HorizontalAlignment fromInt(int paramInt)
  {
    AppMethodBeat.i(97633);
    HorizontalAlignment[] arrayOfHorizontalAlignment = values();
    int j = arrayOfHorizontalAlignment.length;
    int i = 0;
    while (i < j)
    {
      HorizontalAlignment localHorizontalAlignment = arrayOfHorizontalAlignment[i];
      if (localHorizontalAlignment.getValue() == paramInt)
      {
        AppMethodBeat.o(97633);
        return localHorizontalAlignment;
      }
      i += 1;
    }
    AppMethodBeat.o(97633);
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
 * Qualified Name:     com.facebook.share.widget.LikeView.HorizontalAlignment
 * JD-Core Version:    0.7.0.1
 */