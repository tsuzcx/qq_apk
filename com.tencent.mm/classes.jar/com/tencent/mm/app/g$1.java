package com.tencent.mm.app;

import com.tencent.mm.kernel.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.FileSystemManager.b;
import java.security.Key;
import java.util.Map;
import javax.crypto.spec.SecretKeySpec;

final class g$1
  implements FileSystemManager.b
{
  g$1(g paramg) {}
  
  private static boolean sO()
  {
    try
    {
      boolean bool = com.tencent.mm.kernel.g.DK();
      return bool;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public final Key d(String paramString, Map<String, String> paramMap)
  {
    if ((paramMap.get("account") == null) || (!sO())) {
      return null;
    }
    y.i("VFS.Debug", "KeyGen.generate: " + paramString);
    paramMap = new StringBuilder();
    com.tencent.mm.kernel.g.DN();
    return new SecretKeySpec(com.tencent.mm.a.g.p((a.CL() + paramString).getBytes()), "RC4");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.g.1
 * JD-Core Version:    0.7.0.1
 */