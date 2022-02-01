package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.dpi;
import com.tencent.mm.protocal.protobuf.dpj;
import com.tencent.mm.protocal.protobuf.li;
import com.tencent.mm.protocal.protobuf.lj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h
  extends p
  implements m
{
  private List<String> cBS;
  private com.tencent.mm.am.h callback;
  private int index;
  private final int oLG;
  private final int oLH;
  private final int oLI;
  private final int oLJ;
  private final int oLK;
  public List<String> oLL;
  private int oLM;
  public int op;
  private c rr;
  private int total;
  private int type;
  
  public h(List<String> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(243109);
    this.oLG = 1000;
    this.oLH = 0;
    this.oLI = 1;
    this.oLJ = 2;
    this.oLK = 3;
    this.oLL = new LinkedList();
    this.cBS = paramList;
    this.type = paramInt1;
    this.op = paramInt2;
    this.index = 0;
    this.total = paramList.size();
    this.oLM = paramInt3;
    AppMethodBeat.o(243109);
  }
  
  public final int bKN()
  {
    AppMethodBeat.i(243122);
    int i = this.total;
    int j = this.oLL.size();
    AppMethodBeat.o(243122);
    return i - j;
  }
  
  public final lj bKO()
  {
    AppMethodBeat.i(243123);
    lj locallj = (lj)c.c.b(this.rr.otC);
    AppMethodBeat.o(243123);
    return locallj;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(243119);
    this.callback = paramh;
    paramh = new c.a();
    paramh.uri = "/cgi-bin/micromsg-bin/batchmodcontacttype";
    paramh.funcId = 3990;
    paramh.otG = 0;
    paramh.respCmdId = 0;
    paramh.otE = new li();
    paramh.otF = new lj();
    this.rr = paramh.bEF();
    paramh = (li)c.b.b(this.rr.otB);
    paramh.YMZ = new LinkedList();
    int i = 0;
    while ((i < this.oLM) && (this.cBS.size() > 0))
    {
      dpi localdpi = new dpi();
      localdpi.UserName = ((String)this.cBS.remove(0));
      localdpi.aaWh = this.type;
      localdpi.aaWi = this.op;
      paramh.YMZ.add(localdpi);
      i += 1;
    }
    paramh.YMY = paramh.YMZ.size();
    if ((this.type == 134217728) || (this.type == 33554432)) {
      paramh.scene = 1;
    }
    i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(243119);
    return i;
  }
  
  public final int getType()
  {
    return 3990;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(243121);
    Log.i("MicroMsg.NetSceneBatchModContactType", "errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    int i;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = ((lj)c.c.b(this.rr.otC)).YNb.iterator();
      paramInt1 = 0;
      while (params.hasNext())
      {
        paramArrayOfByte = (dpj)params.next();
        if (paramArrayOfByte.Idd == 0)
        {
          com.tencent.mm.kernel.h.baF();
          au localau = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramArrayOfByte.aaWj.UserName);
          if ((localau != null) && (d.rs(localau.field_type)))
          {
            switch (paramArrayOfByte.aaWj.aaWh)
            {
            }
            for (;;)
            {
              com.tencent.mm.kernel.h.baF();
              ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().d(localau.field_username, localau);
              this.oLL.add(localau.field_username);
              break;
              if (paramArrayOfByte.aaWj.aaWi == 1)
              {
                localau.aSj();
              }
              else
              {
                localau.aSk();
                continue;
                if (paramArrayOfByte.aaWj.aaWi == 1)
                {
                  localau.aSl();
                }
                else
                {
                  localau.aSm();
                  continue;
                  if (paramArrayOfByte.aaWj.aaWi == 1) {
                    localau.aSn();
                  } else {
                    localau.aSo();
                  }
                }
              }
            }
          }
        }
        else
        {
          paramInt1 += 1;
        }
      }
      i = paramInt1;
      if (paramInt1 == 0)
      {
        i = paramInt1;
        if (this.cBS.size() > 0)
        {
          if (doScene(dispatcher(), this.callback) < 0)
          {
            Log.e("MicroMsg.NetSceneBatchModContactType", "onGYNetEnd : doScene fail");
            this.callback.onSceneEnd(3, -1, "", this);
          }
          AppMethodBeat.o(243121);
        }
      }
    }
    else
    {
      i = 0;
    }
    params = this.callback;
    if (i > 0) {
      paramInt3 = -3500;
    }
    params.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(243121);
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final p.b securityVerificationChecked(s params)
  {
    return p.b.ouh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelmulti.h
 * JD-Core Version:    0.7.0.1
 */