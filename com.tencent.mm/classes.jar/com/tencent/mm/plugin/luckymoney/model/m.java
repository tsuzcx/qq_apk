package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bg;
import com.tencent.mm.pluginsdk.g.a.a.b.c;
import com.tencent.mm.sdk.b.c;

public final class m
  extends c<bg>
{
  public static final String oog;
  
  static
  {
    AppMethodBeat.i(42333);
    oog = com.tencent.mm.loader.j.b.eQv + "/luckymoney/";
    AppMethodBeat.o(42333);
  }
  
  public m()
  {
    AppMethodBeat.i(42327);
    this.__eventId = bg.class.getName().hashCode();
    AppMethodBeat.o(42327);
  }
  
  public static void bNo()
  {
    AppMethodBeat.i(42328);
    b.c.dmg();
    com.tencent.mm.pluginsdk.g.a.a.b.LE(58);
    AppMethodBeat.o(42328);
  }
  
  public static String yp(int paramInt)
  {
    AppMethodBeat.i(42329);
    String str = oog + paramInt + "/";
    AppMethodBeat.o(42329);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.m
 * JD-Core Version:    0.7.0.1
 */