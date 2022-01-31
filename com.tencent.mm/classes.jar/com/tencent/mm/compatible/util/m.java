package com.tencent.mm.compatible.util;

import com.tencent.mm.compatible.e.y;

public final class m
{
  public static boolean zN()
  {
    String str = y.get("ro.mediatek.platform");
    return (str != null) && ((str.startsWith("MT")) || (str.startsWith("mt")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.compatible.util.m
 * JD-Core Version:    0.7.0.1
 */