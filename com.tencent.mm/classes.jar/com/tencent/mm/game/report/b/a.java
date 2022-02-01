package com.tencent.mm.game.report.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.e;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  public static String a(int paramInt, Map paramMap)
  {
    AppMethodBeat.i(108271);
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      paramMap = com.tencent.mm.game.report.d.a.m((Map)localObject);
      AppMethodBeat.o(108271);
      return paramMap;
      ((Map)localObject).put("ssid", Integer.valueOf(9));
      continue;
      ((Map)localObject).put("ssid", Integer.valueOf(10));
      continue;
      ((Map)localObject).put("ssid", Integer.valueOf(11));
      continue;
      ((Map)localObject).put("ssid", Integer.valueOf(8));
      continue;
      ((Map)localObject).put("ssid", Integer.valueOf(12));
      continue;
      ((Map)localObject).put("ssid", Integer.valueOf(13));
    }
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(108272);
    e.a(paramContext, 87, paramInt1, paramInt2, paramInt3, 0, paramString);
    AppMethodBeat.o(108272);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    AppMethodBeat.i(108273);
    e.a(paramContext, 87, paramInt1, paramInt2, paramInt3, paramString1, 0, paramString2);
    AppMethodBeat.o(108273);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.game.report.b.a
 * JD-Core Version:    0.7.0.1
 */