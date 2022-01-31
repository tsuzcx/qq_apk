package com.tencent.mm.opensdk.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public static final class a
  {
    public static Object a(int paramInt, String paramString)
    {
      AppMethodBeat.i(128070);
      switch (paramInt)
      {
      }
      try
      {
        Log.e("MicroMsg.SDK.PluginProvider.Resolver", "unknown type");
        AppMethodBeat.o(128070);
        return null;
        paramString = Integer.valueOf(paramString);
        AppMethodBeat.o(128070);
        return paramString;
        paramString = Long.valueOf(paramString);
        AppMethodBeat.o(128070);
        return paramString;
        AppMethodBeat.o(128070);
        return paramString;
        paramString = Boolean.valueOf(paramString);
        AppMethodBeat.o(128070);
        return paramString;
        paramString = Float.valueOf(paramString);
        AppMethodBeat.o(128070);
        return paramString;
        paramString = Double.valueOf(paramString);
        AppMethodBeat.o(128070);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.opensdk.utils.c
 * JD-Core Version:    0.7.0.1
 */