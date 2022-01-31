package com.tencent.mm.ay;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.qv;
import com.tencent.mm.protocal.c.qw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends m
  implements k
{
  private f dmL;
  public a.a evQ;
  public final List<i.b> evR = new ArrayList();
  
  public a(List<i.b> paramList)
  {
    this.evR.addAll(paramList);
    this.evQ = new a.a();
    ((a.b)this.evQ.Kv()).evU.tvu = T(paramList);
  }
  
  private static qw T(List<i.b> paramList)
  {
    qw localqw = new qw();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      i.b localb = (i.b)localIterator.next();
      byte[] arrayOfByte = localb.getBuffer();
      qv localqv = new qv();
      localqv.sOA = localb.getCmdId();
      localqv.sOB = new bmk().bs(arrayOfByte);
      localqw.hPT.add(localqv);
    }
    localqw.hPS = paramList.size();
    y.d("MicroMsg.NetSceneOplog", "summeroplog oplogs size=" + paramList.size());
    return localqw;
  }
  
  protected final int Ka()
  {
    return 5;
  }
  
  public final int a(e parame, f paramf)
  {
    Iterator localIterator = this.evR.iterator();
    while (localIterator.hasNext()) {
      if (((i.b)localIterator.next()).getCmdId() == 1) {
        ae.getContext().getSharedPreferences(ae.cqR(), 0).edit().putBoolean(com.tencent.mm.model.q.Gj() + "_has_mod_userinfo", true).commit();
      }
    }
    this.dmL = paramf;
    return a(parame, this.evQ, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  protected final m.b b(com.tencent.mm.network.q paramq)
  {
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 681;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ay.a
 * JD-Core Version:    0.7.0.1
 */