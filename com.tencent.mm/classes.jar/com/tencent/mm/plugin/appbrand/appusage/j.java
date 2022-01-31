package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Bundle;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.u.n;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class j
  extends com.tencent.mm.sdk.e.j
{
  private static volatile j fIl = null;
  
  public static j acU()
  {
    if (fIl == null) {}
    try
    {
      if (fIl == null) {
        fIl = new j();
      }
      return fIl;
    }
    finally {}
  }
  
  public static boolean acV()
  {
    if (!g.DK()) {
      return false;
    }
    return ((Boolean)g.DP().Dz().get(ac.a.usP, Boolean.valueOf(false))).booleanValue();
  }
  
  public static void release()
  {
    fIl = null;
  }
  
  public final void a(long paramLong, boolean paramBoolean, Bundle paramBundle, int paramInt1, int paramInt2)
  {
    n.DS().O(new j.3(this, paramInt1, paramInt2, paramBoolean, paramLong, paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.j
 * JD-Core Version:    0.7.0.1
 */