package com.google.d;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class at
{
  private static volatile boolean dPS = false;
  private static final Class<?> dPT = ahH();
  private static volatile at dPU;
  static final at dPV = new at((byte)0);
  final Map<at.a, be.b<?, ?>> dPW;
  
  at()
  {
    this.dPW = new HashMap();
  }
  
  private at(byte paramByte)
  {
    this.dPW = Collections.emptyMap();
  }
  
  at(at paramat)
  {
    if (paramat == dPV)
    {
      this.dPW = Collections.emptyMap();
      return;
    }
    this.dPW = Collections.unmodifiableMap(paramat.dPW);
  }
  
  private static Class<?> ahH()
  {
    try
    {
      Class localClass = Class.forName("com.google.d.ap");
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return null;
  }
  
  public static boolean ahI()
  {
    return dPS;
  }
  
  public static at ahJ()
  {
    at localat2 = dPU;
    at localat1 = localat2;
    if (localat2 == null) {}
    try
    {
      localat2 = dPU;
      localat1 = localat2;
      if (localat2 == null)
      {
        localat1 = as.ahG();
        dPU = localat1;
      }
      return localat1;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.d.at
 * JD-Core Version:    0.7.0.1
 */