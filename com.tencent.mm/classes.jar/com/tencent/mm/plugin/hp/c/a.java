package com.tencent.mm.plugin.hp.c;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.boots.a.c;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.bjt;
import com.tencent.mm.protocal.protobuf.bju;
import com.tencent.mm.protocal.protobuf.bjv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class a
  extends m
  implements k
{
  protected com.tencent.mm.ai.f callback;
  protected LinkedList<bju> kon;
  protected int mScene;
  protected String nKv;
  protected String nKw;
  protected LinkedList<bjt> nKx;
  protected int nKy;
  protected final b rr;
  protected String type;
  
  public a()
  {
    AppMethodBeat.i(90616);
    this.nKx = new LinkedList();
    this.kon = new LinkedList();
    this.nKy = 0;
    this.mScene = 0;
    b.a locala = new b.a();
    locala.fsX = new bju();
    locala.fsY = new bjv();
    locala.uri = "/cgi-bin/micromsg-bin/prconfig";
    locala.funcId = 3899;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    AppMethodBeat.o(90616);
  }
  
  public static LinkedList<bjt> bIj()
  {
    AppMethodBeat.i(90619);
    LinkedList localLinkedList = new LinkedList();
    long l1 = 0L;
    try
    {
      long l2 = com.tencent.mm.kernel.a.QW() & 0xFFFFFFFF;
      l1 = l2;
      ab.i("MicroMsg.Tinker.NetSceneBaseCheckTinkerUpdate", "uin is %s", new Object[] { bo.aqg(String.valueOf(l2)) });
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        ab.printErrStackTrace("MicroMsg.Tinker.NetSceneBaseCheckTinkerUpdate", localException, "tinker patch manager get uin failed.", new Object[0]);
        continue;
        int i = 2;
      }
      AppMethodBeat.o(90619);
    }
    localLinkedList.add(eO("code-version", com.tencent.mm.sdk.platformtools.f.CLIENT_VERSION));
    localLinkedList.add(eO("code-reversion", com.tencent.mm.sdk.platformtools.f.REV));
    localLinkedList.add(eO("sdk", String.valueOf(Build.VERSION.SDK_INT)));
    localLinkedList.add(eO("os-name", d.whE));
    localLinkedList.add(eO("device-brand", d.whB));
    localLinkedList.add(eO("device-name", d.DEVICE_NAME));
    localLinkedList.add(eO("uin", String.valueOf(l1)));
    if (at.isWifi(ah.getContext()))
    {
      i = 3;
      localLinkedList.add(eO("network", String.valueOf(i)));
      localObject = ((c)g.E(c.class)).aWg();
      if (localObject == null) {
        break label280;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.boots.a.a locala = (com.tencent.mm.plugin.boots.a.a)((Iterator)localObject).next();
        localLinkedList.add(eO(Integer.toHexString(locala.field_key), String.valueOf(locala.field_dau)));
      }
    }
    label280:
    return localLinkedList;
  }
  
  private static bjt eO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90620);
    bjt localbjt = new bjt();
    localbjt.key = paramString1;
    localbjt.value = paramString2;
    AppMethodBeat.o(90620);
    return localbjt;
  }
  
  public int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(90617);
    this.callback = paramf;
    paramf = (bju)this.rr.fsV.fta;
    paramf.xyg = this.nKv;
    paramf.pqD = this.nKw;
    paramf.xyh = this.nKx;
    paramf.type = this.type;
    paramf.uxU = this.kon;
    paramf.xyi = this.nKy;
    paramf.xyj = this.mScene;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(90617);
    return i;
  }
  
  public int getType()
  {
    return 3899;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(90618);
    ab.i("MicroMsg.Tinker.NetSceneBaseCheckTinkerUpdate", "errType:%d errCode:%d errMsg:%s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(90618);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.c.a
 * JD-Core Version:    0.7.0.1
 */