package com.tencent.magicbrush.handler.glfont;

import android.graphics.Typeface;
import com.tencent.magicbrush.a.c.c;
import com.tencent.magicbrush.a.d.a;
import com.tencent.magicbrush.utils.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class f
{
  HashMap<String, Typeface> eJg;
  HashMap<String, Integer> eJh;
  public b eJi;
  
  f(b paramb)
  {
    AppMethodBeat.i(140017);
    this.eJg = new HashMap();
    this.eJh = new HashMap() {};
    this.eJi = paramb;
    AppMethodBeat.o(140017);
  }
  
  static String fY(String paramString)
  {
    AppMethodBeat.i(140018);
    if (i.isNullOrNil(paramString))
    {
      AppMethodBeat.o(140018);
      return null;
    }
    if ((!paramString.endsWith("ttf")) && (a.avK() != null)) {
      a.avK().mQ(1);
    }
    try
    {
      Object localObject = m.eKa;
      localObject = m.gc(paramString);
      AppMethodBeat.o(140018);
      return localObject;
    }
    catch (Exception localException)
    {
      c.c.printStackTrace("MicroMsg.MBFont", localException, "ttf parse error, path: %s", new Object[] { paramString });
      AppMethodBeat.o(140018);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.f
 * JD-Core Version:    0.7.0.1
 */