package com.tencent.mm.plugin.fts.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Pattern;

public final class c$a
{
  public static final Pattern mQW;
  public static final Pattern mQX;
  public static final Pattern mQY;
  public static final Pattern mQZ;
  public static final Pattern mRa;
  public static final Pattern mRb;
  public static final Pattern mRc;
  public static final Pattern mRd;
  public static final Pattern mRe;
  
  static
  {
    AppMethodBeat.i(114186);
    mQW = Pattern.compile(";");
    mQX = Pattern.compile(" ");
    mQY = Pattern.compile("​");
    mQZ = Pattern.compile("‌");
    Pattern localPattern = Pattern.compile("‍");
    mRa = localPattern;
    mRb = localPattern;
    mRc = Pattern.compile("\\s+");
    mRd = Pattern.compile(",");
    mRe = Pattern.compile("[A-Za-z]+");
    AppMethodBeat.o(114186);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.c.a
 * JD-Core Version:    0.7.0.1
 */