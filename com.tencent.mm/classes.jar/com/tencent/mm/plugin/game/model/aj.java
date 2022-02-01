package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.av.a.a;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.a.c.d;
import com.tencent.mm.av.o;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.game.d.an;
import com.tencent.mm.plugin.game.d.bf;
import com.tencent.mm.plugin.game.d.bg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class aj
  extends n
  implements k
{
  public static com.tencent.mm.ak.g hwV;
  public static final String tgu;
  private com.tencent.mm.ak.g callback;
  private final com.tencent.mm.ak.b fYA;
  
  static
  {
    AppMethodBeat.i(41591);
    tgu = com.tencent.mm.plugin.game.commlib.e.b.b(com.tencent.mm.plugin.game.commlib.e.b.a.sWx) + "tabnav/";
    hwV = new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(41581);
        com.tencent.mm.kernel.g.agi().b(2641, this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          ac.i("MicroMsg.NetSceneGameIndex4TabNav", "update gameIndexTabNav data success");
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(41580);
              aj.a(this.tgv);
              AppMethodBeat.o(41580);
            }
          });
          AppMethodBeat.o(41581);
          return;
        }
        ac.i("MicroMsg.NetSceneGameIndex4TabNav", "update gameIndexTabNav data fail");
        AppMethodBeat.o(41581);
      }
    };
    AppMethodBeat.o(41591);
  }
  
  public aj()
  {
    AppMethodBeat.i(41584);
    com.tencent.mm.ak.b.a locala = new com.tencent.mm.ak.b.a();
    locala.hvt = new bf();
    locala.hvu = new bg();
    locala.uri = "/cgi-bin/mmgame-bin/getgameindex4tabnav";
    locala.funcId = getType();
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.fYA = locala.aAz();
    AppMethodBeat.o(41584);
  }
  
  public static void a(bg parambg)
  {
    AppMethodBeat.i(41588);
    if (parambg == null)
    {
      AppMethodBeat.o(41588);
      return;
    }
    if (bs.gY(parambg.tiT))
    {
      ac.i("MicroMsg.NetSceneGameIndex4TabNav", "nav list is null");
      AppMethodBeat.o(41588);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = parambg.tiT.iterator();
    while (localIterator.hasNext())
    {
      an localan = (an)localIterator.next();
      if (localan != null)
      {
        localArrayList.add(localan.tjf);
        localArrayList.add(localan.tjg);
      }
    }
    a(localArrayList, new a()
    {
      public final void onComplete()
      {
        AppMethodBeat.i(41582);
        ac.i("MicroMsg.NetSceneGameIndex4TabNav", "nav icon download complete! save nav data");
        ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOn().b("game_index4_tab_nav", this.tgv);
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
      if (bs.gY(paramList))
      {
        if (parama != null) {
          parama.onComplete();
        }
        AppMethodBeat.o(41589);
        return;
      }
      str = (String)paramList.remove(0);
      if (!bs.isNullOrNil(str)) {
        break;
      }
      ac.e("MicroMsg.NetSceneGameIndex4TabNav", "iconUrl is null");
    }
    Object localObject = tgu + com.tencent.mm.b.g.getMessageDigest(str.getBytes());
    c.a locala = new c.a();
    locala.hKx = true;
    locala.gKe = ((String)localObject);
    localObject = locala.aFT();
    o.aFB().a(str, (c)localObject, new d()
    {
      public final void eI(boolean paramAnonymousVarArgs)
      {
        AppMethodBeat.i(41583);
        ac.i("MicroMsg.NetSceneGameIndex4TabNav", "nav icon download %b! thumburl:%s", new Object[] { Boolean.valueOf(paramAnonymousVarArgs), this.paa });
        aj.b(paramList, parama);
        AppMethodBeat.o(41583);
      }
    });
    AppMethodBeat.o(41589);
  }
  
  public static void updateData()
  {
    AppMethodBeat.i(41587);
    ac.i("MicroMsg.NetSceneGameIndex4TabNav", "update gameIndexTabNav data");
    com.tencent.mm.kernel.g.agi().a(2641, hwV);
    aj localaj = new aj();
    com.tencent.mm.kernel.g.agi().a(localaj, 0);
    AppMethodBeat.o(41587);
  }
  
  public final bg cQZ()
  {
    return (bg)this.fYA.hvs.hvw;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(41586);
    this.callback = paramg;
    int i = dispatch(parame, this.fYA, this);
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
    ac.i("MicroMsg.NetSceneGameIndex4TabNav", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41585);
  }
  
  static abstract interface a
  {
    public abstract void onComplete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.aj
 * JD-Core Version:    0.7.0.1
 */