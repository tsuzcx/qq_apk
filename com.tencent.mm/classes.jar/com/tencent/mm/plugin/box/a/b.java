package com.tencent.mm.plugin.box.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Pattern;

public final class b
{
  public static final Pattern vAb;
  
  static
  {
    AppMethodBeat.i(278705);
    vAb = Pattern.compile("(([a-zA-Z]{2}[0-9]{11,13})|([0-9]{13,15}))[0-9a-zA-Z]?");
    AppMethodBeat.o(278705);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.box.a.b
 * JD-Core Version:    0.7.0.1
 */