package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.cqm;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

@Deprecated
public final class l
  extends k.b
{
  private cqm jgp;
  
  public l(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt, String paramString9, String paramString10)
  {
    super(1);
    AppMethodBeat.i(43058);
    this.jgp = new cqm();
    this.jgp.Mwf = 2048;
    this.jgp.Lqk = new dqi().bhy(Util.nullAsNil(paramString1));
    this.jgp.Mjj = new dqi().bhy(Util.nullAsNil(paramString2));
    this.jgp.KDZ = 0;
    this.jgp.Mwg = new dqi().bhy(Util.nullAsNil(paramString3));
    this.jgp.Mwh = new dqi().bhy(Util.nullAsNil(paramString4));
    this.jgp.oTW = 0;
    paramString2 = s.aW(Util.nullAsNil(paramString5), 0, -1);
    paramString3 = this.jgp;
    if (paramString2 == null)
    {
      paramString1 = new byte[0];
      paramString3.Mwd = new b(paramString1);
      paramString1 = this.jgp;
      if (paramString2 != null) {
        break label315;
      }
    }
    label315:
    for (int i = 0;; i = paramString2.length)
    {
      paramString1.Mwc = i;
      this.jgp.kdY = 0;
      this.jgp.kec = 0;
      this.jgp.keb = Util.nullAsNil(paramString6);
      this.jgp.kea = Util.nullAsNil(paramString7);
      this.jgp.kdZ = Util.nullAsNil(paramString8);
      this.jgp.KEc = paramInt;
      this.jgp.MmM = Util.nullAsNil(paramString9);
      this.jgp.Mwm = 0;
      this.jgp.ked = Util.nullAsNil(paramString10);
      this.jgp.MmO = 0;
      this.jgp.MmN = "";
      this.zqv = this.jgp;
      AppMethodBeat.o(43058);
      return;
      paramString1 = paramString2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ba.l
 * JD-Core Version:    0.7.0.1
 */