package com.tencent.mm.game.report.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.c;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  public static String a(int paramInt, Map paramMap)
  {
    AppMethodBeat.i(140318);
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      paramMap = com.tencent.mm.game.report.c.a.h((Map)localObject);
      AppMethodBeat.o(140318);
      return paramMap;
      ((Map)localObject).put("ssid", Integer.valueOf(9));
      continue;
      ((Map)localObject).put("ssid", Integer.valueOf(10));
      continue;
      ((Map)localObject).put("ssid", Integer.valueOf(11));
      continue;
      ((Map)localObject).put("ssid", Integer.valueOf(8));
    }
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(140319);
    c.a(paramContext, 87, paramInt1, paramInt2, paramInt3, 0, paramString);
    AppMethodBeat.o(140319);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(154298);
    c.a(paramContext, 87, 8760, paramInt1, paramInt2, paramString1, 0, paramString2);
    AppMethodBeat.o(154298);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.game.report.b.a
 * JD-Core Version:    0.7.0.1
 */