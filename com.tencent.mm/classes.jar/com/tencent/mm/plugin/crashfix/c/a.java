package com.tencent.mm.plugin.crashfix.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;

public final class a
{
  public static void f(Field paramField)
  {
    AppMethodBeat.i(145624);
    try
    {
      Field localField = Field.class.getDeclaredField("accessFlags");
      localField.setAccessible(true);
      localField.setInt(paramField, paramField.getModifiers() & 0xFFFFFFEF);
      AppMethodBeat.o(145624);
      return;
    }
    catch (Exception paramField)
    {
      Log.e("MicroMsg.HookUtils", paramField.getMessage());
      AppMethodBeat.o(145624);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.c.a
 * JD-Core Version:    0.7.0.1
 */