package com.tencent.kinda;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class JavaClassInfo
{
  public static String TAG = "JavaClassInfo";
  
  public static String getClassName(Object paramObject)
  {
    AppMethodBeat.i(141141);
    if (paramObject == null)
    {
      AppMethodBeat.o(141141);
      return "";
    }
    paramObject = "simple " + paramObject.toString();
    AppMethodBeat.o(141141);
    return paramObject;
  }
  
  public static String getFullClassName(Object paramObject)
  {
    AppMethodBeat.i(141142);
    if (paramObject == null)
    {
      AppMethodBeat.o(141142);
      return "";
    }
    paramObject = paramObject.toString();
    AppMethodBeat.o(141142);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.JavaClassInfo
 * JD-Core Version:    0.7.0.1
 */