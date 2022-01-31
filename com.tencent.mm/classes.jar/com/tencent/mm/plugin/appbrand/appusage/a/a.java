package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.v.c;
import com.tencent.mm.protocal.c.mk;
import com.tencent.mm.protocal.c.qn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class a
{
  private static volatile a fKj;
  public volatile long fKk = 0L;
  public volatile long fKl = 0L;
  public List<a.a> fKm = new ArrayList();
  public LinkedList<a.b> fKn = new LinkedList();
  float fKo = 0.0F;
  float fKp = 0.0F;
  private volatile long fKq = 0L;
  private boolean fKr = false;
  
  public static a adA()
  {
    if (fKj == null) {}
    try
    {
      if (fKj == null) {
        fKj = new a();
      }
      return fKj;
    }
    finally {}
  }
  
  private void b(int paramInt1, int paramInt2, mk parammk, long paramLong)
  {
    if (!g.DK()) {
      return;
    }
    qn localqn = new qn();
    localqn.latitude = this.fKp;
    localqn.longitude = this.fKo;
    localqn.sOp = aq.getNetTypeString(ae.getContext());
    new a.2(this, paramInt1, paramInt2, parammk, paramLong, localqn, paramInt2, paramInt1).Km();
  }
  
  public static void release()
  {
    fKj = null;
  }
  
  public final void a(int paramInt1, int paramInt2, mk parammk, long paramLong)
  {
    c.DS().O(new a.1(this, paramInt1, paramInt2, parammk, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.a
 * JD-Core Version:    0.7.0.1
 */