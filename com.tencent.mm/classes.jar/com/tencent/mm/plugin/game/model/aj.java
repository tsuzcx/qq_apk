package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.modelimage.loader.a;
import com.tencent.mm.modelimage.loader.b.d;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.protobuf.ay;
import com.tencent.mm.plugin.game.protobuf.br;
import com.tencent.mm.plugin.game.protobuf.bs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class aj
  extends p
  implements m
{
  public static final String IFV;
  public static com.tencent.mm.am.h maV;
  private com.tencent.mm.am.h callback;
  private final com.tencent.mm.am.c mtC;
  
  static
  {
    AppMethodBeat.i(41591);
    IFV = com.tencent.mm.plugin.game.commlib.e.c.c(com.tencent.mm.plugin.game.commlib.e.c.a.Ito) + "tabnav/";
    maV = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(41581);
        com.tencent.mm.kernel.h.aZW().b(2641, this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          Log.i("MicroMsg.NetSceneGameIndex4TabNav", "update gameIndexTabNav data success");
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(41580);
              aj.a(this.IFW);
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
    com.tencent.mm.am.c.a locala = new com.tencent.mm.am.c.a();
    locala.otE = new br();
    locala.otF = new bs();
    locala.uri = "/cgi-bin/mmgame-bin/getgameindex4tabnav";
    locala.funcId = getType();
    locala.otG = 0;
    locala.respCmdId = 0;
    this.mtC = locala.bEF();
    AppMethodBeat.o(41584);
  }
  
  public static void a(bs parambs)
  {
    AppMethodBeat.i(41588);
    if (parambs == null)
    {
      AppMethodBeat.o(41588);
      return;
    }
    if (Util.isNullOrNil(parambs.IIU))
    {
      Log.i("MicroMsg.NetSceneGameIndex4TabNav", "nav list is null");
      AppMethodBeat.o(41588);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = parambs.IIU.iterator();
    while (localIterator.hasNext())
    {
      ay localay = (ay)localIterator.next();
      if (localay != null)
      {
        localArrayList.add(localay.IJg);
        localArrayList.add(localay.IJh);
      }
    }
    a(localArrayList, new a()
    {
      public final void onComplete()
      {
        AppMethodBeat.i(41582);
        Log.i("MicroMsg.NetSceneGameIndex4TabNav", "nav icon download complete! save nav data");
        ((f)com.tencent.mm.kernel.h.ax(f.class)).fCi().b("game_index4_tab_nav", aj.this);
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
    Object localObject = IFV + com.tencent.mm.b.g.getMessageDigest(str.getBytes());
    com.tencent.mm.modelimage.loader.a.c.a locala = new com.tencent.mm.modelimage.loader.a.c.a();
    locala.oKp = true;
    locala.fullPath = ((String)localObject);
    localObject = locala.bKx();
    r.bKe().a(str, (com.tencent.mm.modelimage.loader.a.c)localObject, new d()
    {
      public final void onImageDownload(boolean paramAnonymousBoolean, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(275408);
        Log.i("MicroMsg.NetSceneGameIndex4TabNav", "nav icon download %b! thumburl:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), aj.this });
        aj.b(paramList, parama);
        AppMethodBeat.o(275408);
      }
    });
    AppMethodBeat.o(41589);
  }
  
  public static void dCn()
  {
    AppMethodBeat.i(41587);
    Log.i("MicroMsg.NetSceneGameIndex4TabNav", "update gameIndexTabNav data");
    com.tencent.mm.kernel.h.aZW().a(2641, maV);
    aj localaj = new aj();
    com.tencent.mm.kernel.h.aZW().a(localaj, 0);
    AppMethodBeat.o(41587);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(41586);
    this.callback = paramh;
    int i = dispatch(paramg, this.mtC, this);
    AppMethodBeat.o(41586);
    return i;
  }
  
  public final bs fHb()
  {
    AppMethodBeat.i(275402);
    bs localbs = (bs)c.c.b(this.mtC.otC);
    AppMethodBeat.o(275402);
    return localbs;
  }
  
  public final int getType()
  {
    return 2641;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.aj
 * JD-Core Version:    0.7.0.1
 */