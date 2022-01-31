package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.ds;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.avv;
import com.tencent.mm.protocal.protobuf.awa;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class l$2$1
  implements f
{
  l$2$1(l.2 param2, com.tencent.mm.modelmulti.c paramc) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(15855);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramm = (agx)this.dZD.fBd.fsW.fta;
      if (paramm.result == 0)
      {
        paramString = paramm.wZx;
        paramm = paramm.wZz;
        String str = paramString.title + "," + paramString.desc + "," + paramString.xln + "," + paramString.xlo + "," + paramm.eAx + "," + paramm.major + "," + paramm.minor;
        aw.aaz();
        String[] arrayOfString = bo.bf((String)com.tencent.mm.model.c.Ru().get(ac.a.yBc, null), "").split(",");
        paramString = Boolean.FALSE;
        paramInt2 = arrayOfString.length;
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          if (arrayOfString[paramInt1].equals(paramm.eAx + paramm.major + paramm.minor)) {
            paramString = Boolean.TRUE;
          }
          paramInt1 += 1;
        }
        if (!paramString.booleanValue())
        {
          h.qsU.e(12653, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
          h.qsU.e(12653, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(ac.a.yBb, str);
        }
      }
    }
    for (;;)
    {
      aw.aaz();
      com.tencent.mm.model.c.QR();
      paramString = new ds();
      a.ymk.l(paramString);
      l.b(Boolean.FALSE);
      aw.Rc().b(1708, this);
      AppMethodBeat.o(15855);
      return;
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(ac.a.yBb, "");
      continue;
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(ac.a.yBb, "");
      continue;
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(ac.a.yBb, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.l.2.1
 * JD-Core Version:    0.7.0.1
 */