package com.tencent.mm.console.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelstat.WatchDogPushReceiver;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.protocal.MMProtocalJni;
import java.text.SimpleDateFormat;
import java.util.Date;
import junit.framework.Assert;

public final class i
  implements a
{
  static
  {
    AppMethodBeat.i(20186);
    b.a(new i(), new String[] { "//assert", "//netassert", "//jniassert", "//jnipushassert", "//pushassert" });
    AppMethodBeat.o(20186);
  }
  
  public static void init() {}
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(20185);
    paramContext = paramArrayOfString[0];
    label64:
    int i;
    switch (paramContext.hashCode())
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(20185);
        return false;
        if (!paramContext.equals("//assert")) {
          break label64;
        }
        i = 0;
        continue;
        if (!paramContext.equals("//netassert")) {
          break label64;
        }
        i = 1;
        continue;
        if (!paramContext.equals("//jniassert")) {
          break label64;
        }
        i = 2;
        continue;
        if (!paramContext.equals("//jnipushassert")) {
          break label64;
        }
        i = 3;
        continue;
        if (!paramContext.equals("//pushassert")) {
          break label64;
        }
        i = 4;
      }
    }
    Assert.assertTrue("test errlog " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), false);
    AppMethodBeat.o(20185);
    return true;
    Assert.assertTrue("NetsceneQueue forbid in ", false);
    AppMethodBeat.o(20185);
    return true;
    MMProtocalJni.setClientPackVersion(-1);
    AppMethodBeat.o(20185);
    return true;
    WatchDogPushReceiver.oP(2);
    AppMethodBeat.o(20185);
    return true;
    WatchDogPushReceiver.oP(1);
    AppMethodBeat.o(20185);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.console.a.i
 * JD-Core Version:    0.7.0.1
 */