package com.facebook.share.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public enum LikeView$ObjectType
{
  public static ObjectType DEFAULT;
  private int intValue;
  private String stringValue;
  
  static
  {
    AppMethodBeat.i(97641);
    UNKNOWN = new ObjectType("UNKNOWN", 0, "unknown", 0);
    OPEN_GRAPH = new ObjectType("OPEN_GRAPH", 1, "open_graph", 1);
    PAGE = new ObjectType("PAGE", 2, "page", 2);
    $VALUES = new ObjectType[] { UNKNOWN, OPEN_GRAPH, PAGE };
    DEFAULT = UNKNOWN;
    AppMethodBeat.o(97641);
  }
  
  private LikeView$ObjectType(String paramString, int paramInt)
  {
    this.stringValue = paramString;
    this.intValue = paramInt;
  }
  
  public static ObjectType fromInt(int paramInt)
  {
    AppMethodBeat.i(97640);
    ObjectType[] arrayOfObjectType = values();
    int j = arrayOfObjectType.length;
    int i = 0;
    while (i < j)
    {
      ObjectType localObjectType = arrayOfObjectType[i];
      if (localObjectType.getValue() == paramInt)
      {
        AppMethodBeat.o(97640);
        return localObjectType;
      }
      i += 1;
    }
    AppMethodBeat.o(97640);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.share.widget.LikeView.ObjectType
 * JD-Core Version:    0.7.0.1
 */