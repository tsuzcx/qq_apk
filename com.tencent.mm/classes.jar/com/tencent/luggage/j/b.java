package com.tencent.luggage.j;

import java.util.List;

public final class b
{
  public static <L extends List<T>, T> L c(L paramL, List<T> paramList)
  {
    if (paramList != null) {
      paramL.addAll(paramList);
    }
    return paramL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.j.b
 * JD-Core Version:    0.7.0.1
 */