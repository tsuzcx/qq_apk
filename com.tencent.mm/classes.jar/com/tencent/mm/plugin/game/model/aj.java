package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.ay.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.protobuf.ax;
import com.tencent.mm.plugin.game.protobuf.bq;
import com.tencent.mm.plugin.game.protobuf.br;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class aj
  extends com.tencent.mm.an.q
  implements m
{
  public static final String CLO;
  public static i jxB;
  private i callback;
  private final com.tencent.mm.an.d jTk;
  
  static
  {
    AppMethodBeat.i(41591);
    CLO = com.tencent.mm.plugin.game.commlib.e.c.c(com.tencent.mm.plugin.game.commlib.e.c.a.Czy) + "tabnav/";
    jxB = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.q paramAnonymousq)
      {
        AppMethodBeat.i(41581);
        h.aGY().b(2641, this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          Log.i("MicroMsg.NetSceneGameIndex4TabNav", "update gameIndexTabNav data success");
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(41580);
              aj.a(this.CLP);
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
    locala.lBU = new bq();
    locala.lBV = new br();
    locala.uri = "/cgi-bin/mmgame-bin/getgameindex4tabnav";
    locala.funcId = getType();
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.jTk = locala.bgN();
    AppMethodBeat.o(41584);
  }
  
  public static void a(br parambr)
  {
    AppMethodBeat.i(41588);
    if (parambr == null)
    {
      AppMethodBeat.o(41588);
      return;
    }
    if (Util.isNullOrNil(parambr.COK))
    {
      Log.i("MicroMsg.NetSceneGameIndex4TabNav", "nav list is null");
      AppMethodBeat.o(41588);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = parambr.COK.iterator();
    while (localIterator.hasNext())
    {
      ax localax = (ax)localIterator.next();
      if (localax != null)
      {
        localArrayList.add(localax.COW);
        localArrayList.add(localax.COX);
      }
    }
    a(localArrayList, new a()
    {
      public final void onComplete()
      {
        AppMethodBeat.i(41582);
        Log.i("MicroMsg.NetSceneGameIndex4TabNav", "nav icon download complete! save nav data");
        ((f)h.ae(f.class)).evp().b("game_index4_tab_nav", this.CLP);
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
    Object localObject = CLO + com.tencent.mm.b.g.getMessageDigest(str.getBytes());
    com.tencent.mm.ay.a.a.c.a locala = new com.tencent.mm.ay.a.a.c.a();
    locala.lRD = true;
    locala.fullPath = ((String)localObject);
    localObject = locala.bmL();
    com.tencent.mm.ay.q.bml().a(str, (com.tencent.mm.ay.a.a.c)localObject, new com.tencent.mm.ay.a.c.d()
    {
      public final void a(boolean paramAnonymousBoolean, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(193887);
        Log.i("MicroMsg.NetSceneGameIndex4TabNav", "nav icon download %b! thumburl:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), this.uDR });
        aj.b(paramList, parama);
        AppMethodBeat.o(193887);
      }
    });
    AppMethodBeat.o(41589);
  }
  
  public static void updateData()
  {
    AppMethodBeat.i(41587);
    Log.i("MicroMsg.NetSceneGameIndex4TabNav", "update gameIndexTabNav data");
    h.aGY().a(2641, jxB);
    aj localaj = new aj();
    h.aGY().a(localaj, 0);
    AppMethodBeat.o(41587);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(41586);
    this.callback = parami;
    int i = dispatch(paramg, this.jTk, this);
    AppMethodBeat.o(41586);
    return i;
  }
  
  public final br ezf()
  {
    AppMethodBeat.i(191975);
    br localbr = (br)d.c.b(this.jTk.lBS);
    AppMethodBeat.o(191975);
    return localbr;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.aj
 * JD-Core Version:    0.7.0.1
 */