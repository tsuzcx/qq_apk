package com.tencent.mm.plugin.byp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.modelimage.c;
import com.tencent.mm.modelimage.o;
import com.tencent.mm.modelimage.t;
import com.tencent.mm.modelmulti.n;
import com.tencent.mm.modelmulti.t.a;
import com.tencent.mm.modelmulti.t.e;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.modelvideo.k;
import com.tencent.mm.modelvideo.l;
import com.tencent.mm.modelvideo.m;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/byp/config/DefaultSendMsgInterceptors;", "Lcom/tencent/mm/plugin/byp/config/IPrivateMsgConfig$ICreateSendMsgInterceptor;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "createCdnImageCgi", "Lcom/tencent/mm/modelmulti/SendMsgCgiFactory$BuildResult;", "params", "Lcom/tencent/mm/modelmulti/SendMsgCgiFactory$SendMsgParams;", "createEmojiCgi", "createImageCgi", "createTextCgi", "createVideoCgi", "support", "", "plugin-byp_release"}, k=1, mv={1, 5, 1}, xi=48)
public class d
  implements e.a
{
  private final String TAG = "DefaultSendMsgInterceptors";
  
  public t.a c(t.e parame)
  {
    AppMethodBeat.i(271979);
    t.a locala = new t.a();
    s.checkNotNull(parame);
    if (parame.oNj == 5)
    {
      parame = new n(parame.toUser, parame.content, parame.type, parame.eQp, parame.oNi);
      locala.oNa = parame.msgId;
      locala.hEi = ((com.tencent.mm.am.p)parame);
    }
    for (;;)
    {
      AppMethodBeat.o(271979);
      return locala;
      if (parame.oNj == 4)
      {
        parame = new n(parame.toUser, parame.content, parame.type, parame.eQp);
        locala.oNa = parame.msgId;
        locala.hEi = ((com.tencent.mm.am.p)parame);
      }
      else if (parame.oNj == 2)
      {
        parame = new n(parame.msgId);
        locala.oNa = parame.msgId;
        locala.hEi = ((com.tencent.mm.am.p)parame);
      }
      else
      {
        parame = new n();
        locala.oNa = parame.msgId;
        locala.hEi = ((com.tencent.mm.am.p)parame);
      }
    }
  }
  
  public t.a d(t.e parame)
  {
    AppMethodBeat.i(271999);
    t.a locala = new t.a();
    if ((parame instanceof t))
    {
      if (((t)parame).oNj != 1) {
        break label59;
      }
      locala.hEi = ((com.tencent.mm.am.p)new k(((t)parame).fileName));
    }
    for (;;)
    {
      AppMethodBeat.o(271999);
      return locala;
      label59:
      if (((t)parame).oNj == 4)
      {
        if (ab.bOG()) {
          if (((t)parame).oJL != null) {
            parame = new l(((t)parame).fileName, ((t)parame).oJM, ((t)parame).oJI, ((t)parame).oJJ, ((t)parame).oJL, ((t)parame).oJK);
          }
        }
        for (;;)
        {
          locala.hEi = ((com.tencent.mm.am.p)parame);
          break;
          parame = new l(((t)parame).fileName, ((t)parame).oJM, ((t)parame).oJI, ((t)parame).oJJ, ((t)parame).oJK);
          continue;
          parame = new l(((t)parame).fileName, ((t)parame).oJI, ((t)parame).oJJ, ((t)parame).oJK);
        }
      }
      if (((t)parame).oNj == 20) {
        locala.hEi = ((com.tencent.mm.am.p)new m(((t)parame).fileName, ((t)parame).oJI, ((t)parame).oJJ, ((t)parame).oJK, ((t)parame).enableHitCheck));
      }
    }
  }
  
  public t.a e(t.e parame)
  {
    AppMethodBeat.i(272005);
    t.a locala = new t.a();
    if ((parame instanceof com.tencent.mm.modelimage.d)) {
      locala.hEi = ((com.tencent.mm.am.p)new com.tencent.mm.modelimage.p(((com.tencent.mm.modelimage.d)parame).mxO, ((com.tencent.mm.modelimage.d)parame).oGa, ((com.tencent.mm.modelimage.d)parame).oGb, ((com.tencent.mm.modelimage.d)parame).mxU, ((com.tencent.mm.modelimage.d)parame).oGc));
    }
    AppMethodBeat.o(272005);
    return locala;
  }
  
  public t.a f(t.e parame)
  {
    AppMethodBeat.i(272012);
    parame = new t.a();
    AppMethodBeat.o(272012);
    return parame;
  }
  
  public boolean g(t.e parame)
  {
    return true;
  }
  
  public final t.a h(t.e parame)
  {
    AppMethodBeat.i(271988);
    t.a locala = new t.a();
    Object localObject;
    o localo;
    if (parame != null)
    {
      Log.i(this.TAG, "[createImageCgi] constructorId=%s toUser=%s", new Object[] { Integer.valueOf(parame.oNj), parame.toUser });
      if ((parame.oGu == 1) && (c.NN(parame.oIx)))
      {
        Log.i(this.TAG, "[createImageCgi] send as big no compress");
        parame.oGu = 0;
      }
      localObject = null;
      if (parame.oNj != 2) {
        break label161;
      }
      localo = new o(parame.oNr, parame.oGu);
      localObject = localo;
      if (parame.mxV)
      {
        localo.bJN();
        localObject = localo;
      }
    }
    for (;;)
    {
      if ((localObject != null) && (((o)localObject).bJM() != null)) {
        locala.oNa = ((o)localObject).bJM().field_msgId;
      }
      locala.hEi = ((com.tencent.mm.am.p)localObject);
      AppMethodBeat.o(271988);
      return locala;
      label161:
      if (parame.oNj == 3)
      {
        localo = new o(parame.oNr, parame.oGu, parame.oNk);
        localObject = localo;
        if (parame.mxV)
        {
          localo.bJN();
          localObject = localo;
        }
      }
      else if (parame.oNj == 6)
      {
        localo = new o(parame.mxO, parame.hQQ, parame.toUser, parame.oIx, parame.oGu, parame.oNk);
        localObject = localo;
        if (parame.mxV)
        {
          localo.bJN();
          localObject = localo;
        }
      }
      else if (parame.oNj == 9)
      {
        localo = new o(parame.mxO, parame.hQQ, parame.toUser, parame.oIx, parame.oGu, parame.oNk, parame.hOX, parame.oGC, parame.thumbPath);
        localObject = localo;
        if (parame.mxV)
        {
          localo.bJN();
          localObject = localo;
        }
      }
      else if (parame.oNj == 10)
      {
        localo = new o(parame.mxO, parame.hQQ, parame.toUser, parame.oIx, parame.oGu, parame.oNk, parame.hOX, parame.oNl, parame.oNm);
        s.checkNotNull(parame);
        localObject = localo;
        if (parame.mxV)
        {
          localo.bJN();
          localObject = localo;
        }
      }
      else
      {
        s.checkNotNull(parame);
        if (parame.oNj == 11)
        {
          localo = new o(parame.mxO, parame.hQQ, parame.toUser, parame.oIx, parame.oGu, parame.oNk, parame.hOX, parame.oGC, parame.thumbPath, parame.oNn, parame.oNm);
          localObject = localo;
          if (parame.mxV)
          {
            localo.bJN();
            localObject = localo;
          }
        }
        else if (parame.oNj == 13)
        {
          localo = new o(parame.mxO, parame.hQQ, parame.toUser, parame.oIx, parame.oGu, parame.oNk, parame.hOX, parame.oGC, parame.thumbPath, parame.oNn, parame.oNm, parame.oNo, parame.oNq);
          localObject = localo;
          if (parame.mxV)
          {
            localo.bJN();
            localObject = localo;
          }
        }
        else if (parame.oNj == 14)
        {
          localObject = new o(parame.oNr, parame.mxO, parame.hQQ, parame.toUser, parame.oIx, parame.oGu, parame.oNk, parame.hOX, parame.oGC, parame.thumbPath, parame.oNn, parame.oNm, parame.oNs);
          if (parame.mxV) {
            ((o)localObject).bJN();
          }
        }
        else if (parame.oNj == 19)
        {
          localo = new o(parame.mxO, parame.hQQ, parame.toUser, parame.oIx, parame.oGu, parame.oNk, parame.hOX, parame.oGC, parame.thumbPath, parame.oNn, parame.oNm, parame.oNs, parame.oNt, parame.longitude, parame.latitude, parame.oNp, parame.oNo, parame.oNq);
          localObject = localo;
          if (parame.mxV)
          {
            localo.bJN();
            localObject = localo;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.c.d
 * JD-Core Version:    0.7.0.1
 */