package com.tencent.mm.opensdk.utils;

import android.net.Uri;
import android.provider.BaseColumns;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public static final class a
  {
    public static Object a(int paramInt, String paramString)
    {
      AppMethodBeat.i(3755);
      switch (paramInt)
      {
      }
      try
      {
        Log.e("MicroMsg.SDK.PluginProvider.Resolver", "unknown type");
        AppMethodBeat.o(3755);
        return null;
        paramString = Integer.valueOf(paramString);
        AppMethodBeat.o(3755);
        return paramString;
        paramString = Long.valueOf(paramString);
        AppMethodBeat.o(3755);
        return paramString;
        AppMethodBeat.o(3755);
        return paramString;
        paramString = Boolean.valueOf(paramString);
        AppMethodBeat.o(3755);
        return paramString;
        paramString = Float.valueOf(paramString);
        AppMethodBeat.o(3755);
        return paramString;
        paramString = Double.valueOf(paramString);
        AppMethodBeat.o(3755);
        return paramString;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Log.e("MicroMsg.SDK.PluginProvider.Resolver", "resolveObj exception:" + paramString.getMessage());
        }
      }
    }
  }
  
  public static final class b
    implements BaseColumns
  {
    public static final Uri CONTENT_URI;
    
    static
    {
      AppMethodBeat.i(3749);
      CONTENT_URI = Uri.parse("content://com.tencent.mm.sdk.plugin.provider/sharedpref");
      AppMethodBeat.o(3749);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.utils.c
 * JD-Core Version:    0.7.0.1
 */