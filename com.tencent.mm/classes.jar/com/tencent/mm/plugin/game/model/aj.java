package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.at.a.a;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.al;
import com.tencent.mm.plugin.game.d.bf;
import com.tencent.mm.plugin.game.d.bg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class aj
  extends m
  implements k
{
  public static f fur;
  public static final String nph;
  private f callback;
  private final com.tencent.mm.ai.b lFp;
  
  static
  {
    AppMethodBeat.i(111426);
    nph = com.tencent.mm.loader.j.b.eQz + "Game/TabNav/";
    fur = new aj.1();
    AppMethodBeat.o(111426);
  }
  
  public aj()
  {
    AppMethodBeat.i(111419);
    b.a locala = new b.a();
    locala.fsX = new bf();
    locala.fsY = new bg();
    locala.uri = "/cgi-bin/mmgame-bin/getgameindex4tabnav";
    locala.funcId = getType();
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.lFp = locala.ado();
    AppMethodBeat.o(111419);
  }
  
  public static void a(bg parambg)
  {
    AppMethodBeat.i(111423);
    if (parambg == null)
    {
      AppMethodBeat.o(111423);
      return;
    }
    if (bo.es(parambg.nrw))
    {
      ab.i("MicroMsg.NetSceneGameIndex4TabNav", "nav list is null");
      AppMethodBeat.o(111423);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = parambg.nrw.iterator();
    while (localIterator.hasNext())
    {
      al localal = (al)localIterator.next();
      if (localal != null)
      {
        localArrayList.add(localal.nrG);
        localArrayList.add(localal.nrH);
      }
    }
    a(localArrayList, new aj.2(parambg));
    AppMethodBeat.o(111423);
  }
  
  private static void a(List<String> paramList, aj.a parama)
  {
    AppMethodBeat.i(111424);
    String str;
    for (;;)
    {
      if (bo.es(paramList))
      {
        if (parama != null) {
          parama.onComplete();
        }
        AppMethodBeat.o(111424);
        return;
      }
      str = (String)paramList.remove(0);
      if (!bo.isNullOrNil(str)) {
        break;
      }
      ab.e("MicroMsg.NetSceneGameIndex4TabNav", "iconUrl is null");
    }
    Object localObject = nph + com.tencent.mm.a.g.w(str.getBytes());
    c.a locala = new c.a();
    locala.eNM = true;
    locala.eNO = ((String)localObject);
    localObject = locala.ahY();
    o.ahG().a(str, (c)localObject, new aj.3(str, paramList, parama));
    AppMethodBeat.o(111424);
  }
  
  public static void updateData()
  {
    AppMethodBeat.i(111422);
    ab.i("MicroMsg.NetSceneGameIndex4TabNav", "update gameIndexTabNav data");
    com.tencent.mm.kernel.g.Rc().a(2641, fur);
    aj localaj = new aj();
    com.tencent.mm.kernel.g.Rc().a(localaj, 0);
    AppMethodBeat.o(111422);
  }
  
  public final bg bGU()
  {
    return (bg)this.lFp.fsW.fta;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(111421);
    this.callback = paramf;
    int i = dispatch(parame, this.lFp, this);
    AppMethodBeat.o(111421);
    return i;
  }
  
  public final int getType()
  {
    return 2641;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(111420);
    ab.i("MicroMsg.NetSceneGameIndex4TabNav", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(111420);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.aj
 * JD-Core Version:    0.7.0.1
 */