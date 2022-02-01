package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.av.a.a;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.commlib.util.b;
import com.tencent.mm.plugin.game.commlib.util.b.a;
import com.tencent.mm.plugin.game.protobuf.aw;
import com.tencent.mm.plugin.game.protobuf.bp;
import com.tencent.mm.plugin.game.protobuf.bq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class aj
  extends com.tencent.mm.ak.q
  implements m
{
  public static i gNh;
  public static final String xHL;
  private i callback;
  private final com.tencent.mm.ak.d hhm;
  
  static
  {
    AppMethodBeat.i(41591);
    xHL = b.c(b.a.xvI) + "tabnav/";
    gNh = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq)
      {
        AppMethodBeat.i(41581);
        com.tencent.mm.kernel.g.azz().b(2641, this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          Log.i("MicroMsg.NetSceneGameIndex4TabNav", "update gameIndexTabNav data success");
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(41580);
              aj.a(this.xHM);
              AppMethodBeat.o(41580);
            }
          });
          AppMethodBeat.o(41581);
          return;
        }
        Log.i("MicroMsg.NetSceneGameIndex4TabNav", "update gameIndexTabNav data fail");
        AppMethodBeat.o(41581);
      }
    };
    AppMethodBeat.o(41591);
  }
  
  public aj()
  {
    AppMethodBeat.i(41584);
    d.a locala = new d.a();
    locala.iLN = new bp();
    locala.iLO = new bq();
    locala.uri = "/cgi-bin/mmgame-bin/getgameindex4tabnav";
    locala.funcId = getType();
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.hhm = locala.aXF();
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
    if (Util.isNullOrNil(parambq.xKD))
    {
      Log.i("MicroMsg.NetSceneGameIndex4TabNav", "nav list is null");
      AppMethodBeat.o(41588);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = parambq.xKD.iterator();
    while (localIterator.hasNext())
    {
      aw localaw = (aw)localIterator.next();
      if (localaw != null)
      {
        localArrayList.add(localaw.xKP);
        localArrayList.add(localaw.xKQ);
      }
    }
    a(localArrayList, new a()
    {
      public final void onComplete()
      {
        AppMethodBeat.i(41582);
        Log.i("MicroMsg.NetSceneGameIndex4TabNav", "nav icon download complete! save nav data");
        ((f)com.tencent.mm.kernel.g.af(f.class)).dSL().b("game_index4_tab_nav", this.xHM);
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
      if (Util.isNullOrNil(paramList))
      {
        if (parama != null) {
          parama.onComplete();
        }
        AppMethodBeat.o(41589);
        return;
      }
      str = (String)paramList.remove(0);
      if (!Util.isNullOrNil(str)) {
        break;
      }
      Log.e("MicroMsg.NetSceneGameIndex4TabNav", "iconUrl is null");
    }
    Object localObject = xHL + com.tencent.mm.b.g.getMessageDigest(str.getBytes());
    c.a locala = new c.a();
    locala.jbf = true;
    locala.fullPath = ((String)localObject);
    localObject = locala.bdv();
    com.tencent.mm.av.q.bcV().a(str, (c)localObject, new com.tencent.mm.av.a.c.d()
    {
      public final void a(boolean paramAnonymousBoolean, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(204179);
        Log.i("MicroMsg.NetSceneGameIndex4TabNav", "nav icon download %b! thumburl:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), this.raR });
        aj.b(paramList, parama);
        AppMethodBeat.o(204179);
      }
    });
    AppMethodBeat.o(41589);
  }
  
  public static void updateData()
  {
    AppMethodBeat.i(41587);
    Log.i("MicroMsg.NetSceneGameIndex4TabNav", "update gameIndexTabNav data");
    com.tencent.mm.kernel.g.azz().a(2641, gNh);
    aj localaj = new aj();
    com.tencent.mm.kernel.g.azz().a(localaj, 0);
    AppMethodBeat.o(41587);
  }
  
  public final bq dVX()
  {
    return (bq)this.hhm.iLL.iLR;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(41586);
    this.callback = parami;
    int i = dispatch(paramg, this.hhm, this);
    AppMethodBeat.o(41586);
    return i;
  }
  
  public final int getType()
  {
    return 2641;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41585);
    Log.i("MicroMsg.NetSceneGameIndex4TabNav", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41585);
  }
  
  static abstract interface a
  {
    public abstract void onComplete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.aj
 * JD-Core Version:    0.7.0.1
 */