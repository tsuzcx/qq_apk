package com.tencent.kinda;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class JavaClassInfo
{
  public static String TAG = "JavaClassInfo";
  
  public static String getClassName(Object paramObject)
  {
    AppMethodBeat.i(135630);
    if (paramObject == null)
    {
      AppMethodBeat.o(135630);
      return "";
    }
    paramObject = "simple " + paramObject.toString();
    AppMethodBeat.o(135630);
    return paramObject;
  }
  
  public static String getFullClassName(Object paramObject)
  {
    AppMethodBeat.i(135631);
    if (paramObject == null)
    {
      AppMethodBeat.o(135631);
      return "";
    }
    paramObject = paramObject.toString();
    AppMethodBeat.o(135631);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.JavaClassInfo
 * JD-Core Version:    0.7.0.1
 */