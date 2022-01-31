package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.protocal.c.qv;
import com.tencent.mm.protocal.c.sm;
import com.tencent.mm.storage.be;

public final class b
  implements r
{
  public final void a(qv paramqv, byte[] paramArrayOfByte, boolean paramBoolean, t paramt)
  {
    switch (paramqv.sOA)
    {
    default: 
      return;
    }
    paramqv = (sm)new sm().aH(paramArrayOfByte);
    ((j)g.r(j.class)).FB().abu(aa.a(paramqv.sQs));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.b
 * JD-Core Version:    0.7.0.1
 */