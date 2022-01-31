package com.tencent.mm.plugin.appbrand.launching;

import java.util.Locale;

final class i$a$a
{
  String gKq;
  String gKr;
  
  final i.a alI()
  {
    return new i.a(this.gKr, this.gKq);
  }
  
  final a m(String paramString, Object... paramVarArgs)
  {
    this.gKq = String.format(Locale.US, paramString, paramVarArgs);
    return this;
  }
  
  final a n(String paramString, Object... paramVarArgs)
  {
    this.gKr = String.format(Locale.US, paramString, paramVarArgs);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.i.a.a
 * JD-Core Version:    0.7.0.1
 */