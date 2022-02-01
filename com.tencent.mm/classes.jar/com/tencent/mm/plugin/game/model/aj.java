package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.aw.a.a;
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.a.c.d;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.game.d.ap;
import com.tencent.mm.plugin.game.d.bi;
import com.tencent.mm.plugin.game.d.bj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class aj
  extends n
  implements k
{
  public static com.tencent.mm.al.f hPn;
  public static final String uel;
  private com.tencent.mm.al.f callback;
  private final com.tencent.mm.al.b grW;
  
  static
  {
    AppMethodBeat.i(41591);
    uel = com.tencent.mm.plugin.game.commlib.util.b.c(com.tencent.mm.plugin.game.commlib.util.b.a.tTf) + "tabnav/";
    hPn = new com.tencent.mm.al.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(41581);
        com.tencent.mm.kernel.g.aiU().b(2641, this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          ad.i("MicroMsg.NetSceneGameIndex4TabNav", "update gameIndexTabNav data success");
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(41580);
              aj.a(this.uem);
              AppMethodBeat.o(41580);
            }
          });
          AppMethodBeat.o(41581);
          return;
        }
        ad.i("MicroMsg.NetSceneGameIndex4TabNav", "update gameIndexTabNav data fail");
        AppMethodBeat.o(41581);
      }
    };
    AppMethodBeat.o(41591);
  }
  
  public aj()
  {
    AppMethodBeat.i(41584);
    com.tencent.mm.al.b.a locala = new com.tencent.mm.al.b.a();
    locala.hNM = new bi();
    locala.hNN = new bj();
    locala.uri = "/cgi-bin/mmgame-bin/getgameindex4tabnav";
    locala.funcId = getType();
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.grW = locala.aDC();
    AppMethodBeat.o(41584);
  }
  
  public static void a(bj parambj)
  {
    AppMethodBeat.i(41588);
    if (parambj == null)
    {
      AppMethodBeat.o(41588);
      return;
    }
    if (bt.hj(parambj.ugO))
    {
      ad.i("MicroMsg.NetSceneGameIndex4TabNav", "nav list is null");
      AppMethodBeat.o(41588);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = parambj.ugO.iterator();
    while (localIterator.hasNext())
    {
      ap localap = (ap)localIterator.next();
      if (localap != null)
      {
        localArrayList.add(localap.uha);
        localArrayList.add(localap.uhb);
      }
    }
    a(localArrayList, new a()
    {
      public final void onComplete()
      {
        AppMethodBeat.i(41582);
        ad.i("MicroMsg.NetSceneGameIndex4TabNav", "nav icon download complete! save nav data");
        ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cWI().b("game_index4_tab_nav", this.uem);
        AppMethodBeat.o(41582);
      }
    });
    AppMethodBeat.o(41588);
  }
  
  private static void a(final List<String> paramList, final a parama)
  {
    AppMethodBeat.i(41589);
    String str;
    for (;;)
    {
      if (bt.hj(paramList))
      {
        if (parama != null) {
          parama.onComplete();
        }
        AppMethodBeat.o(41589);
        return;
      }
      str = (String)paramList.remove(0);
      if (!bt.isNullOrNil(str)) {
        break;
      }
      ad.e("MicroMsg.NetSceneGameIndex4TabNav", "iconUrl is null");
    }
    Object localObject = uel + com.tencent.mm.b.g.getMessageDigest(str.getBytes());
    c.a locala = new c.a();
    locala.idr = true;
    locala.hdP = ((String)localObject);
    localObject = locala.aJc();
    com.tencent.mm.aw.q.aIJ().a(str, (c)localObject, new d()
    {
      public final void eK(boolean paramAnonymousVarArgs)
      {
        AppMethodBeat.i(41583);
        ad.i("MicroMsg.NetSceneGameIndex4TabNav", "nav icon download %b! thumburl:%s", new Object[] { Boolean.valueOf(paramAnonymousVarArgs), this.pDK });
        aj.b(paramList, parama);
        AppMethodBeat.o(41583);
      }
    });
    AppMethodBeat.o(41589);
  }
  
  public static void updateData()
  {
    AppMethodBeat.i(41587);
    ad.i("MicroMsg.NetSceneGameIndex4TabNav", "update gameIndexTabNav data");
    com.tencent.mm.kernel.g.aiU().a(2641, hPn);
    aj localaj = new aj();
    com.tencent.mm.kernel.g.aiU().a(localaj, 0);
    AppMethodBeat.o(41587);
  }
  
  public final bj cZF()
  {
    return (bj)this.grW.hNL.hNQ;
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(41586);
    this.callback = paramf;
    int i = dispatch(parame, this.grW, this);
    AppMethodBeat.o(41586);
    return i;
  }
  
  public final int getType()
  {
    return 2641;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41585);
    ad.i("MicroMsg.NetSceneGameIndex4TabNav", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41585);
  }
  
  static abstract interface a
  {
    public abstract void onComplete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.aj
 * JD-Core Version:    0.7.0.1
 */