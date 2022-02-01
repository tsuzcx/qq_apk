package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.av.a.a;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.a.c.d;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.game.d.av;
import com.tencent.mm.plugin.game.d.bp;
import com.tencent.mm.plugin.game.d.bq;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class aj
  extends n
  implements k
{
  public static com.tencent.mm.ak.f ghB;
  public static final String ups;
  private com.tencent.mm.ak.f callback;
  private final com.tencent.mm.ak.b gux;
  
  static
  {
    AppMethodBeat.i(41591);
    ups = com.tencent.mm.plugin.game.commlib.util.b.c(com.tencent.mm.plugin.game.commlib.util.b.a.udW) + "tabnav/";
    ghB = new com.tencent.mm.ak.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(41581);
        com.tencent.mm.kernel.g.ajj().b(2641, this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          ae.i("MicroMsg.NetSceneGameIndex4TabNav", "update gameIndexTabNav data success");
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(41580);
              aj.a(this.upt);
              AppMethodBeat.o(41580);
            }
          });
          AppMethodBeat.o(41581);
          return;
        }
        ae.i("MicroMsg.NetSceneGameIndex4TabNav", "update gameIndexTabNav data fail");
        AppMethodBeat.o(41581);
      }
    };
    AppMethodBeat.o(41591);
  }
  
  public aj()
  {
    AppMethodBeat.i(41584);
    com.tencent.mm.ak.b.a locala = new com.tencent.mm.ak.b.a();
    locala.hQF = new bp();
    locala.hQG = new bq();
    locala.uri = "/cgi-bin/mmgame-bin/getgameindex4tabnav";
    locala.funcId = getType();
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.gux = locala.aDS();
    AppMethodBeat.o(41584);
  }
  
  public static void a(bq parambq)
  {
    AppMethodBeat.i(41588);
    if (parambq == null)
    {
      AppMethodBeat.o(41588);
      return;
    }
    if (bu.ht(parambq.usl))
    {
      ae.i("MicroMsg.NetSceneGameIndex4TabNav", "nav list is null");
      AppMethodBeat.o(41588);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = parambq.usl.iterator();
    while (localIterator.hasNext())
    {
      av localav = (av)localIterator.next();
      if (localav != null)
      {
        localArrayList.add(localav.usx);
        localArrayList.add(localav.usy);
      }
    }
    a(localArrayList, new a()
    {
      public final void onComplete()
      {
        AppMethodBeat.i(41582);
        ae.i("MicroMsg.NetSceneGameIndex4TabNav", "nav icon download complete! save nav data");
        ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cZm().b("game_index4_tab_nav", this.upt);
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
      if (bu.ht(paramList))
      {
        if (parama != null) {
          parama.onComplete();
        }
        AppMethodBeat.o(41589);
        return;
      }
      str = (String)paramList.remove(0);
      if (!bu.isNullOrNil(str)) {
        break;
      }
      ae.e("MicroMsg.NetSceneGameIndex4TabNav", "iconUrl is null");
    }
    Object localObject = ups + com.tencent.mm.b.g.getMessageDigest(str.getBytes());
    c.a locala = new c.a();
    locala.igk = true;
    locala.hgD = ((String)localObject);
    localObject = locala.aJu();
    com.tencent.mm.av.q.aJb().a(str, (c)localObject, new d()
    {
      public final void eM(boolean paramAnonymousVarArgs)
      {
        AppMethodBeat.i(41583);
        ae.i("MicroMsg.NetSceneGameIndex4TabNav", "nav icon download %b! thumburl:%s", new Object[] { Boolean.valueOf(paramAnonymousVarArgs), this.pKo });
        aj.b(paramList, parama);
        AppMethodBeat.o(41583);
      }
    });
    AppMethodBeat.o(41589);
  }
  
  public static void updateData()
  {
    AppMethodBeat.i(41587);
    ae.i("MicroMsg.NetSceneGameIndex4TabNav", "update gameIndexTabNav data");
    com.tencent.mm.kernel.g.ajj().a(2641, ghB);
    aj localaj = new aj();
    com.tencent.mm.kernel.g.ajj().a(localaj, 0);
    AppMethodBeat.o(41587);
  }
  
  public final bq dcq()
  {
    return (bq)this.gux.hQE.hQJ;
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(41586);
    this.callback = paramf;
    int i = dispatch(parame, this.gux, this);
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
    ae.i("MicroMsg.NetSceneGameIndex4TabNav", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41585);
  }
  
  static abstract interface a
  {
    public abstract void onComplete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.aj
 * JD-Core Version:    0.7.0.1
 */