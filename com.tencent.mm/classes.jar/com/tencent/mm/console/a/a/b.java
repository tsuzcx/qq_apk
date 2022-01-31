package com.tencent.mm.console.a.a;

import android.content.Context;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.lang.reflect.Method;

public final class b
  implements a
{
  private static String A(Context paramContext, String paramString)
  {
    try
    {
      File localFile1 = (File)paramContext.getClass().getMethod("getSharedPrefsFile", new Class[] { String.class }).invoke(paramContext, new Object[] { paramString });
      File localFile3 = localFile1;
      if (localFile1 == null) {
        localFile3 = new File(paramContext.getFilesDir().getParent() + "/shared_prefs", paramString + ".xml");
      }
      return localFile3.getAbsolutePath();
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        y.w("MicroMsg.HCSettingCommand", "Failed call getSharedPrefsFile", new Object[] { localThrowable });
        File localFile2 = new File(paramContext.getFilesDir().getParent() + "/shared_prefs", paramString + ".xml");
      }
    }
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString)
  {
    if (paramArrayOfString.length <= 1) {
      return false;
    }
    int i = bk.getInt(paramArrayOfString[1], 0);
    y.i("MicroMsg.HCSettingCommand", "hardcoder copy[%d] [%s]", new Object[] { Integer.valueOf(i), A(paramContext, "hardcoder_setting") });
    paramArrayOfString = A(paramContext, "hardcoder_setting");
    Object localObject = com.tencent.mm.compatible.util.e.bkH + "hardcoder_setting.xml";
    if (i > 0)
    {
      paramContext = paramArrayOfString;
      if (i <= 0) {
        break label152;
      }
    }
    for (;;)
    {
      paramArrayOfString = new com.tencent.mm.vfs.b((String)localObject);
      if (paramArrayOfString.exists()) {
        paramArrayOfString.delete();
      }
      y.i("MicroMsg.HCSettingCommand", "hcsetting copy[%d], ret[%d] src[%s] to dest[%s]", new Object[] { Integer.valueOf(i), Long.valueOf(com.tencent.mm.vfs.e.r(paramContext, (String)localObject)), paramContext, localObject });
      return true;
      paramContext = (Context)localObject;
      break;
      label152:
      localObject = paramArrayOfString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.console.a.a.b
 * JD-Core Version:    0.7.0.1
 */