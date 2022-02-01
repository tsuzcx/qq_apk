package com.tencent.mm.openim.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.k;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/contact/OpenIMKefuCardExtension;", "Lcom/tencent/mm/model/BaseMsgExtension;", "()V", "prepareMsgInfo", "Lcom/tencent/mm/storage/MsgInfo;", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "fromUser", "", "toUser", "userName", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.model.e
{
  public static final b.a prJ;
  
  static
  {
    AppMethodBeat.i(236031);
    prJ = new b.a((byte)0);
    AppMethodBeat.o(236031);
  }
  
  public final cc a(g.a parama, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(236038);
    s.u(parama, "addMsgInfo");
    Object localObject = parama.mpN;
    e locale = g.RD(w.a(((dl)localObject).YFG));
    if (locale == null)
    {
      Log.e("MicroMsg.OpenIMKefuCardExtension", "alvinluo kefuCard content parse failed");
      parama = super.a(parama, paramString1, paramString2, paramString3);
      AppMethodBeat.o(236038);
      return parama;
    }
    if (((dl)localObject).IIs == 67) {
      ((com.tencent.mm.openim.api.e)h.ax(com.tencent.mm.openim.api.e.class)).RG(locale.prQ);
    }
    if (((CharSequence)locale.username).length() > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = new j();
        ((j)localObject).username = locale.username;
        ((j)localObject).jZY = 3;
        ((j)localObject).gX(true);
        ((j)localObject).osN = locale.nnS;
        ((j)localObject).osM = locale.prO;
        ((j)localObject).eQp = -1;
        Log.d("MicroMsg.OpenIMKefuCardExtension", "alvinluo kefuCard prepareMsgInfo user: " + locale.username + ", headImage: " + locale.nnS + ", " + locale.prO);
        q.bFE().b((j)localObject);
      }
      parama = super.a(parama, paramString1, paramString2, paramString3);
      AppMethodBeat.o(236038);
      return parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.a.b
 * JD-Core Version:    0.7.0.1
 */