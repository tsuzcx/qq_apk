package com.tencent.mm.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.aa;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import junit.framework.Assert;

public final class k
  extends aa
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    boolean bool = false;
    AppMethodBeat.i(150130);
    info = aa.aJm();
    int j;
    if (CrashReportFactory.hasDebuger())
    {
      Field[] arrayOfField = k.b.class.getDeclaredFields();
      int i = 0;
      int k;
      for (j = 0; i < arrayOfField.length; j = k)
      {
        Field localField = arrayOfField[i];
        k = j;
        if (!Modifier.isStatic(localField.getModifiers()))
        {
          k = j;
          if (!localField.getName().equals("_hellAccFlag_")) {
            k = j + 1;
          }
        }
        i += 1;
      }
      if (j <= 209) {
        break label128;
      }
      Log.e("MicroMsg.AppMessage", "AppMessage.Content should not add new field!!! (%d) is over the limit(%d)!!!", new Object[] { Integer.valueOf(j), Integer.valueOf(209) });
    }
    for (;;)
    {
      Assert.assertTrue(bool);
      AppMethodBeat.o(150130);
      return;
      label128:
      Log.i("MicroMsg.AppMessage", "AppMessage.Content nonStaticFieldCount: %d", new Object[] { Integer.valueOf(j) });
      bool = true;
    }
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.message.k
 * JD-Core Version:    0.7.0.1
 */