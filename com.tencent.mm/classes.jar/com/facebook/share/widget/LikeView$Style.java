package com.facebook.share.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public enum LikeView$Style
{
  static Style DEFAULT;
  private int intValue;
  private String stringValue;
  
  static
  {
    AppMethodBeat.i(97646);
    STANDARD = new Style("STANDARD", 0, "standard", 0);
    BUTTON = new Style("BUTTON", 1, "button", 1);
    BOX_COUNT = new Style("BOX_COUNT", 2, "box_count", 2);
    $VALUES = new Style[] { STANDARD, BUTTON, BOX_COUNT };
    DEFAULT = STANDARD;
    AppMethodBeat.o(97646);
  }
  
  private LikeView$Style(String paramString, int paramInt)
  {
    this.stringValue = paramString;
    this.intValue = paramInt;
  }
  
  static Style fromInt(int paramInt)
  {
    AppMethodBeat.i(97644);
    Style[] arrayOfStyle = values();
    int j = arrayOfStyle.length;
    int i = 0;
    while (i < j)
    {
      Style localStyle = arrayOfStyle[i];
      if (localStyle.getValue() == paramInt)
      {
        AppMethodBeat.o(97644);
        return localStyle;
      }
      i += 1;
    }
    AppMethodBeat.o(97644);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.share.widget.LikeView.Style
 * JD-Core Version:    0.7.0.1
 */