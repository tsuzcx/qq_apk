package com.tencent.mm.plugin.ball.f;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.Set;

public final class a
{
  public static void a(Intent paramIntent, Bundle paramBundle, Set<String> paramSet)
  {
    AppMethodBeat.i(127555);
    Bundle localBundle = new Bundle();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      String str = (String)paramSet.next();
      if (paramBundle.containsKey(str)) {
        a(localBundle, str, paramBundle.get(str));
      }
    }
    paramIntent.putExtras(localBundle);
    AppMethodBeat.o(127555);
  }
  
  private static void a(Bundle paramBundle, String paramString, Object paramObject)
  {
    AppMethodBeat.i(127557);
    if ((paramObject instanceof String))
    {
      paramBundle.putString(paramString, (String)paramObject);
      AppMethodBeat.o(127557);
      return;
    }
    if ((paramObject instanceof Integer))
    {
      paramBundle.putInt(paramString, ((Integer)paramObject).intValue());
      AppMethodBeat.o(127557);
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramBundle.putLong(paramString, ((Long)paramObject).longValue());
      AppMethodBeat.o(127557);
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      paramBundle.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
      AppMethodBeat.o(127557);
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramBundle.putDouble(paramString, ((Double)paramObject).doubleValue());
      AppMethodBeat.o(127557);
      return;
    }
    if ((paramObject instanceof byte[]))
    {
      paramBundle.putByteArray(paramString, (byte[])paramObject);
      AppMethodBeat.o(127557);
      return;
    }
    ac.w("MicroMsg.FloatBallIntentUtil", "put not support type, key:%s, value:%s", new Object[] { paramString, paramObject });
    AppMethodBeat.o(127557);
  }
  
  public static void b(Intent paramIntent, Bundle paramBundle, Set<String> paramSet)
  {
    AppMethodBeat.i(127556);
    if (paramIntent.getExtras() != null)
    {
      paramIntent = paramIntent.getExtras();
      paramSet = paramSet.iterator();
      while (paramSet.hasNext())
      {
        String str = (String)paramSet.next();
        if (paramIntent.containsKey(str)) {
          a(paramBundle, str, paramIntent.get(str));
        }
      }
    }
    AppMethodBeat.o(127556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.f.a
 * JD-Core Version:    0.7.0.1
 */