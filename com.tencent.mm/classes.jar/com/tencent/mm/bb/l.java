package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.caq;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;

@Deprecated
public final class l
  extends k.b
{
  private caq iix;
  
  public l(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt, String paramString9, String paramString10)
  {
    super(1);
    AppMethodBeat.i(43058);
    this.iix = new caq();
    this.iix.GVj = 2048;
    this.iix.GbY = new cwt().aPy(bt.nullAsNil(paramString1));
    this.iix.GKC = new cwt().aPy(bt.nullAsNil(paramString2));
    this.iix.Fsf = 0;
    this.iix.GVk = new cwt().aPy(bt.nullAsNil(paramString3));
    this.iix.GVl = new cwt().aPy(bt.nullAsNil(paramString4));
    this.iix.nDG = 0;
    paramString2 = i.aY(bt.nullAsNil(paramString5), 0, -1);
    paramString3 = this.iix;
    if (paramString2 == null)
    {
      paramString1 = new byte[0];
      paramString3.GVh = new b(paramString1);
      paramString1 = this.iix;
      if (paramString2 != null) {
        break label315;
      }
    }
    label315:
    for (int i = 0;; i = paramString2.length)
    {
      paramString1.GVg = i;
      this.iix.jdc = 0;
      this.iix.jdg = 0;
      this.iix.jdf = bt.nullAsNil(paramString6);
      this.iix.jde = bt.nullAsNil(paramString7);
      this.iix.jdd = bt.nullAsNil(paramString8);
      this.iix.Fsi = paramInt;
      this.iix.GNW = bt.nullAsNil(paramString9);
      this.iix.GVq = 0;
      this.iix.jdh = bt.nullAsNil(paramString10);
      this.iix.GNY = 0;
      this.iix.GNX = "";
      this.vKm = this.iix;
      AppMethodBeat.o(43058);
      return;
      paramString1 = paramString2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bb.l
 * JD-Core Version:    0.7.0.1
 */