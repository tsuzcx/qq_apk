package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.e.s;
import com.tencent.mm.h.a.bs;
import com.tencent.mm.h.a.ll;
import com.tencent.mm.h.a.ll.a;
import com.tencent.mm.h.a.ll.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public abstract class a
  implements k
{
  public final void a(ll paramll, int paramInt, String paramString)
  {
    y.i("MicroMsg.BaseFingerprintImp", "hy: onOpenFingerprintAuthFailed");
    if ((paramll != null) && (paramll.bUv.bUz != null))
    {
      paramll.bUw = new ll.b();
      paramll.bUw.errCode = paramInt;
      paramll.bUw.bOU = "";
      paramll.bUw.bOV = "";
      paramll.bUw.aox = paramString;
      paramll.bUw.bUB = type();
      paramll.bUv.bUz.run();
    }
  }
  
  public String aSA()
  {
    return "";
  }
  
  public final boolean aSw()
  {
    return e.aSY();
  }
  
  public boolean aSx()
  {
    return false;
  }
  
  public boolean aSy()
  {
    return false;
  }
  
  public final boolean aSz()
  {
    return ((Boolean)g.DP().Dz().get(ac.a.uzF, Boolean.valueOf(false))).booleanValue();
  }
  
  public final void dg(Context paramContext)
  {
    y.i("MicroMsg.BaseFingerprintImp", "showFingerPrintEntrance");
    if (((e.aSY()) && (!aSG())) || ((aSz()) && (!aST())))
    {
      y.e("MicroMsg.BaseFingerprintImp", "the fingerprint is open ready, but system has none Finger print ids!");
      y.i("MicroMsg.BaseFingerprintImp", "closeFP");
      localbs = new bs();
      localbs.bFJ = new a.1(this, localbs);
      com.tencent.mm.sdk.b.a.udP.a(localbs, paramContext.getMainLooper());
    }
    while (q.dyh.dyq == 1)
    {
      bs localbs;
      return;
    }
    y.e("MicroMsg.BaseFingerprintImp", "hy: device info not support");
  }
  
  public final void gf(boolean paramBoolean)
  {
    y.i("MicroMsg.BaseFingerprintImp", "hy: set isOpenFp: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    e.gh(paramBoolean);
  }
  
  public final void gg(boolean paramBoolean)
  {
    y.i("MicroMsg.BaseFingerprintImp", "set is open faceid: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    g.DP().Dz().c(ac.a.uzF, Boolean.valueOf(paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.a
 * JD-Core Version:    0.7.0.1
 */