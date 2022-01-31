package com.tencent.mm.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ah$a
{
  public final String toString()
  {
    AppMethodBeat.i(16673);
    Object localObject = new Throwable().getStackTrace();
    if ((localObject == null) || (localObject.length < 4))
    {
      AppMethodBeat.o(16673);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 3;
    while (i < localObject.length)
    {
      if (localObject[i].getClassName().contains("com.tencent.mm"))
      {
        localStringBuilder.append("[");
        localStringBuilder.append(localObject[i].getClassName().substring(15));
        localStringBuilder.append(":");
        localStringBuilder.append(localObject[i].getMethodName());
        localStringBuilder.append("(" + localObject[i].getLineNumber() + ")]");
      }
      i += 1;
    }
    localObject = localStringBuilder.toString();
    AppMethodBeat.o(16673);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.platformtools.ah.a
 * JD-Core Version:    0.7.0.1
 */