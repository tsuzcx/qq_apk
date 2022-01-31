package com.facebook.login.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum LoginButton$ToolTipMode
{
  public static ToolTipMode DEFAULT;
  private int intValue;
  private String stringValue;
  
  static
  {
    AppMethodBeat.i(92646);
    AUTOMATIC = new ToolTipMode("AUTOMATIC", 0, "automatic", 0);
    DISPLAY_ALWAYS = new ToolTipMode("DISPLAY_ALWAYS", 1, "display_always", 1);
    NEVER_DISPLAY = new ToolTipMode("NEVER_DISPLAY", 2, "never_display", 2);
    $VALUES = new ToolTipMode[] { AUTOMATIC, DISPLAY_ALWAYS, NEVER_DISPLAY };
    DEFAULT = AUTOMATIC;
    AppMethodBeat.o(92646);
  }
  
  private LoginButton$ToolTipMode(String paramString, int paramInt)
  {
    this.stringValue = paramString;
    this.intValue = paramInt;
  }
  
  public static ToolTipMode fromInt(int paramInt)
  {
    AppMethodBeat.i(92645);
    ToolTipMode[] arrayOfToolTipMode = values();
    int j = arrayOfToolTipMode.length;
    int i = 0;
    while (i < j)
    {
      ToolTipMode localToolTipMode = arrayOfToolTipMode[i];
      if (localToolTipMode.getValue() == paramInt)
      {
        AppMethodBeat.o(92645);
        return localToolTipMode;
      }
      i += 1;
    }
    AppMethodBeat.o(92645);
    return null;
  }
  
  public final int getValue()
  {
    return this.intValue;
  }
  
  public final String toString()
  {
    return this.stringValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.login.widget.LoginButton.ToolTipMode
 * JD-Core Version:    0.7.0.1
 */