package com.tencent.mm.plugin.account.bind.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.ab;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.d;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.na;
import com.tencent.mm.protocal.protobuf.nb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.Iterator;
import java.util.Set;

public final class b
  extends com.tencent.mm.am.p
  implements m
{
  private com.tencent.mm.am.h callback;
  private String hNI;
  private String hNK;
  public long oTt;
  public final c rr;
  
  public b(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(109745);
    this.oTt = 0L;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new na();
    ((c.a)localObject).otF = new nb();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/bindqq";
    ((c.a)localObject).funcId = 144;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    this.oTt = paramLong;
    localObject = (na)c.b.b(this.rr.otB);
    ((na)localObject).YOK = new com.tencent.mm.b.p(paramLong).intValue();
    ((na)localObject).YOy = "";
    ((na)localObject).YOL = "";
    ((na)localObject).YOM = "";
    ((na)localObject).YON = "";
    ((na)localObject).YOP = new etl().btH("");
    ((na)localObject).YOO = 1;
    if (paramBoolean == true) {}
    for (paramString1 = com.tencent.mm.kernel.h.baC().aZE().g(paramLong, paramString3);; paramString1 = com.tencent.mm.kernel.h.baC().aZE().a(paramLong, Util.getFullPasswordMD5(paramString1), true))
    {
      ((na)localObject).YMf = new gol().df(paramString1);
      String str = Util.nullAsNil((String)com.tencent.mm.kernel.h.baE().ban().d(47, null));
      ((na)localObject).YOQ = new gol().df(Util.decodeHexString(str));
      Log.i("MicroMsg.NetSceneBindQQ", "init opcode:%d qq:%d  wtbuf:%d img[%s,%s,%s] ksid:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), Integer.valueOf(Util.getLength(paramString1)), paramString3, paramString2, paramString4, str });
      AppMethodBeat.o(109745);
      return;
    }
  }
  
  public b(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean)
  {
    this(paramLong, paramString1, paramString2, paramString3, paramString4, 1, paramBoolean);
    AppMethodBeat.i(109746);
    this.hNI = paramString5;
    this.hNK = paramString6;
    paramString1 = (na)c.b.b(this.rr.otB);
    paramString1.YOh = paramString5;
    paramString1.YOi = paramString6;
    AppMethodBeat.o(109746);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(109747);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(109747);
    return i;
  }
  
  public final int getType()
  {
    return 144;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(109748);
    params = (na)c.b.b(this.rr.otB);
    paramArrayOfByte = (nb)c.c.b(this.rr.otC);
    Object localObject = w.a(paramArrayOfByte.YJl);
    if (!Util.isNullOrNil((byte[])localObject)) {}
    for (boolean bool1 = com.tencent.mm.kernel.h.baC().aZE().b(new com.tencent.mm.b.p(params.YOK).longValue(), (byte[])localObject);; bool1 = false)
    {
      if ((bool1) && (com.tencent.mm.kernel.h.baz())) {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adgT, Boolean.TRUE);
      }
      Log.i("MicroMsg.NetSceneBindQQ", "onGYNetEnd[%d,%d] wtret:%b wtRespBuf:%d imgsid:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(bool1), Integer.valueOf(Util.getLength((byte[])localObject)), paramArrayOfByte.YOM });
      boolean bool2;
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        paramInt1 = com.tencent.mm.kernel.h.baE().ban().getInt(9, 0);
        com.tencent.mm.kernel.h.baE().ban().B(9, Integer.valueOf(params.YOK));
        if (paramInt1 != 0)
        {
          if (com.tencent.mm.kernel.h.baE().ban().get(at.a.acWp, "").equals(String.valueOf(paramInt1))) {
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acWp, z.bAM());
          }
          localObject = cj.ono.bDj().iterator();
          while (((Iterator)localObject).hasNext())
          {
            str = (String)((Iterator)localObject).next();
            if (String.valueOf(paramInt1).equals(cj.ono.getString(str, "login_user_name"))) {
              cj.ono.s(str, "login_user_name", str);
            }
          }
        }
        if (params.YOO == 1) {
          com.tencent.mm.kernel.h.baE().ban().B(17, Integer.valueOf(paramArrayOfByte.YCd));
        }
        localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzJ();
        String str = paramArrayOfByte.YOT;
        if (paramArrayOfByte.YOS == 1)
        {
          bool2 = true;
          ((l)localObject).cr(str, bool2);
          paramInt1 = params.YOK;
          if (paramInt1 != 0) {
            ((n)com.tencent.mm.kernel.h.ax(n.class)).bzJ().gd(new com.tencent.mm.b.p(paramInt1) + "@qqim", 3);
          }
          d.n(paramInt1, 3);
          com.tencent.mm.kernel.h.baE().ban().B(32, params.YOy);
          com.tencent.mm.kernel.h.baE().ban().B(33, params.YOL);
          localObject = Util.encodeHexString(com.tencent.mm.kernel.h.baC().aZE().iB(new com.tencent.mm.b.p(params.YOK).longValue()));
          Log.i("MicroMsg.NetSceneBindQQ", "onGYNetEnd wtret:%b newa2key:%s ", new Object[] { Boolean.valueOf(bool1), Util.secPrint((String)localObject) });
          com.tencent.mm.kernel.h.baE().ban().B(72, localObject);
          com.tencent.mm.kernel.h.baE().ban().B(46, Util.encodeHexString(w.a(paramArrayOfByte.YJr)));
          localObject = Util.encodeHexString(w.a(params.YOQ));
          com.tencent.mm.kernel.h.baE().ban().B(47, localObject);
          com.tencent.mm.kernel.h.baE().mCE.B(18, localObject);
          com.tencent.mm.kernel.h.baE().ban().B(-1535680990, paramArrayOfByte.YOU);
        }
      }
      for (;;)
      {
        paramInt1 = paramInt3;
        if (params.YOO == 3)
        {
          paramInt1 = paramInt3;
          if (paramInt3 == -3)
          {
            paramInt1 = 10000;
            Log.d("MicroMsg.NetSceneBindQQ", "onGYNetEnd : retCode = 10000");
          }
        }
        this.callback.onSceneEnd(paramInt2, paramInt1, paramString, this);
        AppMethodBeat.o(109748);
        return;
        bool2 = false;
        break;
        if (paramInt2 == 4)
        {
          com.tencent.mm.kernel.h.baE().ban().B(32, "");
          com.tencent.mm.kernel.h.baE().ban().B(33, "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.a.b
 * JD-Core Version:    0.7.0.1
 */