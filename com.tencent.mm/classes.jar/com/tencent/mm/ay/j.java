package com.tencent.mm.ay;

import com.tencent.mm.bv.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.protocal.c.axx;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.vfs.e;

@Deprecated
public final class j
  extends i.b
{
  private axx ewe = new axx();
  
  public j(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt, String paramString9, String paramString10)
  {
    super(1);
    this.ewe.tue = 2048;
    this.ewe.sQs = new bml().YI(bk.pm(paramString1));
    this.ewe.tmw = new bml().YI(bk.pm(paramString2));
    this.ewe.stM = 0;
    this.ewe.tuf = new bml().YI(bk.pm(paramString3));
    this.ewe.tug = new bml().YI(bk.pm(paramString4));
    this.ewe.hQq = 0;
    paramString2 = e.c(bk.pm(paramString5), 0, -1);
    paramString3 = this.ewe;
    if (paramString2 == null)
    {
      paramString1 = new byte[0];
      paramString3.tuc = new b(paramString1);
      paramString1 = this.ewe;
      if (paramString2 != null) {
        break label305;
      }
    }
    label305:
    for (int i = 0;; i = paramString2.length)
    {
      paramString1.tub = i;
      this.ewe.ffh = 0;
      this.ewe.ffl = 0;
      this.ewe.ffk = bk.pm(paramString6);
      this.ewe.ffj = bk.pm(paramString7);
      this.ewe.ffi = bk.pm(paramString8);
      this.ewe.stP = paramInt;
      this.ewe.tpi = bk.pm(paramString9);
      this.ewe.tul = 0;
      this.ewe.ffm = bk.pm(paramString10);
      this.ewe.tpk = 0;
      this.ewe.tpj = "";
      this.mdD = this.ewe;
      return;
      paramString1 = paramString2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ay.j
 * JD-Core Version:    0.7.0.1
 */