package com.tencent.mm.opensdk.utils;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static int a(Bundle paramBundle, String paramString)
  {
    int i = -1;
    AppMethodBeat.i(3757);
    if (paramBundle == null)
    {
      AppMethodBeat.o(3757);
      return -1;
    }
    try
    {
      int j = paramBundle.getInt(paramString, -1);
      i = j;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Log.e("MicroMsg.IntentUtil", "getIntExtra exception:" + paramBundle.getMessage());
      }
    }
    AppMethodBeat.o(3757);
    return i;
  }
  
  public static String b(Bundle paramBundle, String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(3758);
    if (paramBundle == null)
    {
      AppMethodBeat.o(3758);
      return null;
    }
    try
    {
      paramBundle = paramBundle.getString(paramString);
      AppMethodBeat.o(3758);
      return paramBundle;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Log.e("MicroMsg.IntentUtil", "getStringExtra exception:" + paramBundle.getMessage());
        paramBundle = localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.utils.a
 * JD-Core Version:    0.7.0.1
 */