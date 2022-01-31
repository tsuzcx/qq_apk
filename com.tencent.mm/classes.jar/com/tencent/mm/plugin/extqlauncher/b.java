package com.tencent.mm.plugin.extqlauncher;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.be;
import java.util.HashMap;
import java.util.List;

public final class b
  implements ar
{
  private b.a jLQ;
  private b.b jLR;
  boolean jLS = false;
  private m.b jLT = new b.1(this);
  boolean jLU = false;
  long jLV = 0L;
  private final long jLW = 300000L;
  private final long jLX = 4000L;
  private final String jLY = "fun1";
  int jLZ = 0;
  private ah jMa = new b.3(this, Looper.getMainLooper());
  
  public static b aNP()
  {
    au.Hq();
    b localb2 = (b)bu.iR("plugin.extqlauncher");
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b();
      au.Hq().a("plugin.extqlauncher", localb1);
    }
    return localb1;
  }
  
  public static int aNQ()
  {
    int i;
    if (!au.DK())
    {
      y.w("MicroMsg.SubCoreExtQLauncher", "getMMUnread account not ready");
      i = 0;
    }
    int j;
    int k;
    do
    {
      return i;
      j = t.ie(s.dUT);
      k = k.Gf();
      i = j;
    } while ((q.Gn() & 0x8000) != 0);
    return j - k;
  }
  
  public final void aNR()
  {
    this.jMa.removeMessages(0);
    this.jMa.sendEmptyMessageDelayed(0, 4000L);
  }
  
  public final void bh(boolean paramBoolean)
  {
    au.Hx();
    c.FB().a(this.jLT);
    if (this.jLQ == null) {
      this.jLQ = new b.a();
    }
    a.udP.c(this.jLQ);
    if (this.jLR == null) {
      this.jLR = new b.b(this, (byte)0);
    }
    a.udP.c(this.jLR);
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    if (this.jLQ != null) {
      a.udP.d(this.jLQ);
    }
    if (this.jLR != null) {
      a.udP.d(this.jLR);
    }
    au.Hx();
    c.FB().b(this.jLT);
    this.jMa.removeMessages(0);
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.extqlauncher.b
 * JD-Core Version:    0.7.0.1
 */