package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.cbk;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;

@Deprecated
public final class l
  extends k.b
{
  private cbk ilq;
  
  public l(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt, String paramString9, String paramString10)
  {
    super(1);
    AppMethodBeat.i(43058);
    this.ilq = new cbk();
    this.ilq.HoK = 2048;
    this.ilq.GuF = new cxn().aQV(bu.nullAsNil(paramString1));
    this.ilq.Hed = new cxn().aQV(bu.nullAsNil(paramString2));
    this.ilq.FKD = 0;
    this.ilq.HoL = new cxn().aQV(bu.nullAsNil(paramString3));
    this.ilq.HoM = new cxn().aQV(bu.nullAsNil(paramString4));
    this.ilq.nJb = 0;
    paramString2 = o.bb(bu.nullAsNil(paramString5), 0, -1);
    paramString3 = this.ilq;
    if (paramString2 == null)
    {
      paramString1 = new byte[0];
      paramString3.HoI = new b(paramString1);
      paramString1 = this.ilq;
      if (paramString2 != null) {
        break label315;
      }
    }
    label315:
    for (int i = 0;; i = paramString2.length)
    {
      paramString1.HoH = i;
      this.ilq.jfV = 0;
      this.ilq.jfZ = 0;
      this.ilq.jfY = bu.nullAsNil(paramString6);
      this.ilq.jfX = bu.nullAsNil(paramString7);
      this.ilq.jfW = bu.nullAsNil(paramString8);
      this.ilq.FKG = paramInt;
      this.ilq.Hhw = bu.nullAsNil(paramString9);
      this.ilq.HoR = 0;
      this.ilq.jga = bu.nullAsNil(paramString10);
      this.ilq.Hhy = 0;
      this.ilq.Hhx = "";
      this.vWq = this.ilq;
      AppMethodBeat.o(43058);
      return;
      paramString1 = paramString2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ba.l
 * JD-Core Version:    0.7.0.1
 */