package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.autogen.a.ea;
import com.tencent.mm.network.g;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.protocal.protobuf.gof;
import com.tencent.mm.protocal.protobuf.gog;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.bl;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class o
  extends p
  implements com.tencent.mm.network.m
{
  private com.tencent.mm.am.h callback;
  private final int mScene;
  public final int mType;
  private final c rr;
  public byte[] xOH;
  public int xOJ;
  public byte[] xOK;
  private boolean xOL;
  private ArrayList<cjb> xOM;
  
  public o(int paramInt1, int paramInt2)
  {
    this(paramInt1, null, paramInt2);
  }
  
  public o(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    this(paramInt1, paramArrayOfByte, paramInt2, false);
  }
  
  public o(int paramInt1, byte[] paramArrayOfByte, int paramInt2, boolean paramBoolean)
  {
    this(paramInt1, paramArrayOfByte, paramInt2, paramBoolean, (byte)0);
    AppMethodBeat.i(108706);
    AppMethodBeat.o(108706);
  }
  
  private o(int paramInt1, byte[] paramArrayOfByte, int paramInt2, boolean paramBoolean, byte paramByte)
  {
    AppMethodBeat.i(269851);
    this.xOK = null;
    this.xOL = false;
    this.xOM = new ArrayList();
    this.xOH = null;
    c.a locala = new c.a();
    locala.otE = new gof();
    locala.otF = new gog();
    locala.uri = "/cgi-bin/micromsg-bin/getemotionlist";
    locala.funcId = 411;
    locala.otG = 210;
    locala.respCmdId = 1000000210;
    this.rr = locala.bEF();
    this.xOH = paramArrayOfByte;
    this.xOK = null;
    this.mType = paramInt1;
    this.mScene = paramInt2;
    this.xOL = paramBoolean;
    Log.i("MicroMsg.emoji.NetSceneGetEmotionList", "NetSceneGetEmotionList: %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(269851);
  }
  
  public static com.tencent.mm.plugin.emoji.model.m c(gog paramgog)
  {
    AppMethodBeat.i(108709);
    Log.d("MicroMsg.emoji.NetSceneGetEmotionList", "getEmotionListModel");
    if (paramgog == null)
    {
      AppMethodBeat.o(108709);
      return null;
    }
    com.tencent.mm.plugin.emoji.model.m localm = new com.tencent.mm.plugin.emoji.model.m();
    if (paramgog != null)
    {
      localm.xMT = paramgog.Zve;
      Object localObject1 = new ArrayList();
      if ((paramgog.Zvf != null) && (!paramgog.Zvf.isEmpty()))
      {
        Object[] arrayOfObject = paramgog.Zvf.toArray();
        if ((arrayOfObject != null) && (arrayOfObject.length > 0))
        {
          int j = arrayOfObject.length;
          int i = 0;
          while (i < j)
          {
            Object localObject2 = arrayOfObject[i];
            if ((localObject2 != null) && ((localObject2 instanceof cjb)))
            {
              localObject2 = (cjb)localObject2;
              if ((localObject2 != null) && (!Util.isNullOrNil(((cjb)localObject2).ProductID)))
              {
                ((List)localObject1).add(new com.tencent.mm.plugin.emoji.a.a.f((cjb)localObject2));
                Log.d("MicroMsg.emoji.NetSceneGetEmotionList", "EmojiSummary ProductId:%s,ProductName:%s PackPrice:%s , PackType:%s , PriceNum:%s ,PriceType:%s ,PackFlag:%s , PackWeCoinNum:%s , WeCoinNum:%s ", new Object[] { ((cjb)localObject2).Zul, ((cjb)localObject2).ProductID, ((cjb)localObject2).akkc, Integer.valueOf(((cjb)localObject2).akkd), ((cjb)localObject2).akkj, ((cjb)localObject2).Zuw, Integer.valueOf(((cjb)localObject2).akke), Integer.valueOf(((cjb)localObject2).akkv), Integer.valueOf(((cjb)localObject2).akkw) });
              }
            }
            i += 1;
          }
        }
      }
      localm.xMU = ((List)localObject1);
      localm.xMV = paramgog.akkW;
      localm.xMW = paramgog.akkY;
      localObject1 = paramgog.akle;
      if (localm.xMY == null)
      {
        localm.xMY = new LinkedList();
        localm.xMY.addAll((Collection)localObject1);
      }
      localm.xMX = paramgog.akla;
    }
    AppMethodBeat.o(108709);
    return localm;
  }
  
  private void dAG()
  {
    AppMethodBeat.i(108710);
    gog localgog = dAF();
    if ((localgog != null) && (localgog.Zvf != null) && (localgog.Zvf.size() > 0))
    {
      this.xOM.addAll(localgog.Zvf);
      AppMethodBeat.o(108710);
      return;
    }
    Log.w("MicroMsg.emoji.NetSceneGetEmotionList", "addSummaryList faild. response is null or emotion list is empty.");
    AppMethodBeat.o(108710);
  }
  
  public final gog dAF()
  {
    AppMethodBeat.i(269914);
    if (this.rr == null)
    {
      AppMethodBeat.o(269914);
      return null;
    }
    gog localgog = (gog)c.c.b(this.rr.otC);
    AppMethodBeat.o(269914);
    return localgog;
  }
  
  public int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(108707);
    this.callback = paramh;
    gof localgof = (gof)c.b.b(this.rr.otB);
    if (this.xOH != null)
    {
      localgof.YGU = w.aN(this.xOH);
      if (this.xOK == null) {
        break label152;
      }
      localgof.akkV = w.aN(this.xOK);
      label64:
      if (localgof.YGU != null) {
        break label167;
      }
    }
    label152:
    label167:
    for (paramh = "Buf is NULL";; paramh = localgof.YGU.toString())
    {
      Log.d("MicroMsg.emoji.NetSceneGetEmotionList", paramh);
      localgof.nUz = this.mType;
      localgof.IJG = this.mScene;
      if (this.mType == 7) {
        localgof.aary = this.xOJ;
      }
      int i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(108707);
      return i;
      localgof.YGU = new gol();
      break;
      localgof.akkV = new gol();
      break label64;
    }
  }
  
  public int getType()
  {
    return 411;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108708);
    Log.d("MicroMsg.emoji.NetSceneGetEmotionList", "ErrType:" + paramInt2 + "   errCode:" + paramInt3);
    if (this.mType == 8)
    {
      if ((paramInt2 == 0) && (paramInt3 == 0)) {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acHW, Long.valueOf(System.currentTimeMillis()));
      }
    }
    else if (this.mType == 11)
    {
      if ((paramInt2 != 0) || (paramInt3 != 0)) {
        break label185;
      }
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acIa, Long.valueOf(System.currentTimeMillis()));
    }
    for (;;)
    {
      com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjx.a(this.mType, dAF());
      if ((paramInt2 == 0) || (paramInt2 == 4)) {
        break label214;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108708);
      return;
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acHW, Long.valueOf(System.currentTimeMillis() - 86400000L + 3600000L));
      break;
      label185:
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acIa, Long.valueOf(System.currentTimeMillis() - 28800000L + 600000L));
    }
    label214:
    paramArrayOfByte = (gog)c.c.b(((c)params).otC);
    if (paramArrayOfByte.YGU != null) {
      this.xOH = w.a(paramArrayOfByte.YGU);
    }
    if (this.mType == 8)
    {
      if (paramInt3 == 0)
      {
        dAG();
        com.tencent.threadpool.h.ahAA.bm(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(179057);
            o.a(o.this, o.a(o.this));
            AppMethodBeat.o(179057);
          }
        });
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acHW, Long.valueOf(System.currentTimeMillis()));
      }
    }
    else
    {
      if ((this.mType != 1) && (this.mType != 9)) {
        break label522;
      }
      params = j.dzN();
      paramArrayOfByte = dAF().aklf;
      if (!Util.isEqual(params.xMG, paramArrayOfByte))
      {
        params.xMG = paramArrayOfByte;
        params.dzO();
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acXe, paramArrayOfByte);
        new ea().publish();
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108708);
      return;
      if (paramInt3 == 2)
      {
        dAG();
        ((gof)c.b.b(((c)params).otB)).YGU = ((gog)c.c.b(((c)params).otC)).YGU;
        doScene(dispatcher(), this.callback);
        break;
      }
      if (paramInt3 != 3) {
        break;
      }
      if (this.xOM != null) {
        this.xOM.clear();
      }
      ((gof)c.b.b(((c)params).otB)).YGU = new gol();
      doScene(dispatcher(), this.callback);
      break;
      label522:
      if (this.mType == 5)
      {
        params = j.dzN();
        paramArrayOfByte = dAF().aklf;
        if (!Util.isEqual(params.xMF, paramArrayOfByte))
        {
          params.xMF = paramArrayOfByte;
          params.dzO();
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acXf, paramArrayOfByte);
          new ea().publish();
        }
      }
    }
  }
  
  public int securityLimitCount()
  {
    return 100;
  }
  
  public p.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return p.b.ouh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.o
 * JD-Core Version:    0.7.0.1
 */