package com.tencent.mm.console.a;

import android.content.Context;
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
    b.a(new i(), new String[] { "//assert", "//netassert", "//jniassert", "//jnipushassert", "//pushassert" });
  }
  
  public static void init() {}
  
  public final boolean a(Context paramContext, String[] paramArrayOfString)
  {
    paramContext = paramArrayOfString[0];
    label60:
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
        return false;
        if (!paramContext.equals("//assert")) {
          break label60;
        }
        i = 0;
        continue;
        if (!paramContext.equals("//netassert")) {
          break label60;
        }
        i = 1;
        continue;
        if (!paramContext.equals("//jniassert")) {
          break label60;
        }
        i = 2;
        continue;
        if (!paramContext.equals("//jnipushassert")) {
          break label60;
        }
        i = 3;
        continue;
        if (!paramContext.equals("//pushassert")) {
          break label60;
        }
        i = 4;
      }
    }
    Assert.assertTrue("test errlog " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), false);
    return true;
    Assert.assertTrue("NetsceneQueue forbid in ", false);
    return true;
    MMProtocalJni.setClientPackVersion(-1);
    return true;
    WatchDogPushReceiver.jo(2);
    return true;
    WatchDogPushReceiver.jo(1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.console.a.i
 * JD-Core Version:    0.7.0.1
 */