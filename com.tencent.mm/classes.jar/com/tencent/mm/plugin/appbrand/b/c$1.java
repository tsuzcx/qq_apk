package com.tencent.mm.plugin.appbrand.b;

import android.support.v4.f.a;
import com.tencent.mm.plugin.appbrand.i;
import java.util.Set;

final class c$1
  extends d
{
  c$1(c paramc, i parami)
  {
    super(parami);
  }
  
  final void a(b paramb)
  {
    c localc = this.fFP;
    synchronized (localc.fFO)
    {
      c.a[] arrayOfa = new c.a[localc.fFO.size()];
      arrayOfa = (c.a[])localc.fFO.keySet().toArray(arrayOfa);
      int j = arrayOfa.length;
      int i = 0;
      if (i < j)
      {
        arrayOfa[i].a(localc.fzT.mAppId, paramb);
        i += 1;
      }
    }
  }
  
  final void acy()
  {
    c localc = this.fFP;
    if (!localc.fzT.mFinished) {
      localc.fzT.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.c.1
 * JD-Core Version:    0.7.0.1
 */