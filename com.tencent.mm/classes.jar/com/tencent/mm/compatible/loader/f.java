package com.tencent.mm.compatible.loader;

import android.app.Application;
import android.content.Context;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public final class f
{
  public static e c(Application paramApplication, String paramString)
  {
    try
    {
      paramString = (e)ae.getContext().getClassLoader().loadClass(ae.cqQ() + paramString).newInstance();
      paramString.app = paramApplication;
      return paramString;
    }
    catch (Exception paramApplication)
    {
      y.printErrStackTrace("MicroMsg.ProfileFactoryImpl", paramApplication, "", new Object[0]);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.compatible.loader.f
 * JD-Core Version:    0.7.0.1
 */