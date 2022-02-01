package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.ui.a.k;
import com.tencent.mm.plugin.fts.ui.a.s;
import com.tencent.mm.plugin.fts.ui.c.d;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.protobuf.cqh;
import com.tencent.mm.protocal.protobuf.ecw;
import com.tencent.mm.protocal.protobuf.ecx;
import com.tencent.mm.protocal.protobuf.fox;
import com.tencent.mm.protocal.protobuf.fpj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public final class n
  extends com.tencent.mm.plugin.fts.a.d.b
  implements i
{
  private int BJB;
  public long BJO;
  private int BJz;
  private long BMI;
  private long BNf;
  private d BQV;
  private ecx BQW;
  private MMHandler BQX;
  private String query;
  
  public n(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
    AppMethodBeat.i(112221);
    this.BJz = 2147483647;
    this.BJB = 2147483647;
    this.BQX = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(112220);
        super.handleMessage(paramAnonymousMessage);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(112220);
          return;
          if (paramAnonymousMessage.obj.equals(Long.valueOf(n.a(n.this))))
          {
            n.a(n.this, System.currentTimeMillis());
            Log.i("MicroMsg.FTS.FTSWeAppSearchUIUnit", "cancel Time %d", new Object[] { Long.valueOf(n.b(n.this) - n.c(n.this)) });
            n.e(n.this).a(n.this, n.d(n.this));
            n.this.eqZ();
            n.this.clearData();
          }
        }
      }
    };
    AppMethodBeat.o(112221);
  }
  
  public final List<c> NG(long paramLong)
  {
    AppMethodBeat.i(112230);
    ArrayList localArrayList = new ArrayList();
    if ((this.BQW != null) && (this.BQW.RLp.size() > 0)) {
      if (eqW() != 2) {
        break label239;
      }
    }
    label239:
    for (int i = 26;; i = 25)
    {
      c localc = new c();
      localc.position = (this.BJz + 1);
      localc.BHU = (this.BJO - paramLong);
      localc.fND = String.valueOf(((fpj)this.BQW.RLp.get(0)).hashCode());
      localc.fNO = i;
      localc.BHW = ((fpj)this.BQW.RLp.get(0)).Uhd;
      localArrayList.add(localc);
      if (this.BQW.Tic)
      {
        localc = new c();
        localc.position = this.BJB;
        localc.BHU = (this.BJO - paramLong);
        localc.fND = String.valueOf(this.BQW.hashCode());
        localc.fNO = i;
        localc.BHW = ((fpj)this.BQW.RLp.get(0)).Uhd;
        localArrayList.add(localc);
      }
      AppMethodBeat.o(112230);
      return localArrayList;
    }
  }
  
  public final int SB(int paramInt)
  {
    AppMethodBeat.i(112224);
    int i;
    if ((this.BQW != null) && (this.BQW.RLp.size() > 0))
    {
      this.BJz = paramInt;
      i = paramInt + 1 + this.BQW.RLp.size();
      if (this.BQW.Tic)
      {
        this.BJB = i;
        i += 1;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.FTS.FTSWeAppSearchUIUnit", "updateHeaderPosition curPos %d oriPos %d headerPosition %d morePosition %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(this.BJz), Integer.valueOf(this.BJB) });
      AppMethodBeat.o(112224);
      return i;
      this.BJB = 2147483647;
      continue;
      this.BJz = 2147483647;
      this.BJB = 2147483647;
      i = paramInt;
    }
  }
  
  public final a SC(int paramInt)
  {
    AppMethodBeat.i(112226);
    Object localObject;
    if (paramInt == this.BJz) {
      localObject = new k(paramInt);
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((a)localObject).uMD = -20;
        ((a)localObject).ptD = eqY();
        ((a)localObject).BJG = false;
        ((a)localObject).BHY = com.tencent.mm.plugin.fts.a.a.h.bJ(this.query, false);
      }
      if (localObject != null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.FTS.FTSWeAppSearchUIUnit", "createDataItem position %d %s %d %d", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool), Integer.valueOf(this.BJz), Integer.valueOf(this.BJB) });
        AppMethodBeat.o(112226);
        return localObject;
        if (paramInt == this.BJB)
        {
          localObject = new com.tencent.mm.plugin.fts.ui.a.t(paramInt);
          ((com.tencent.mm.plugin.fts.ui.a.t)localObject).BPN = ((fpj)this.BQW.RLp.get(0));
          ((com.tencent.mm.plugin.fts.ui.a.t)localObject).BQc = this.BQW.Uhq;
          ((com.tencent.mm.plugin.fts.ui.a.t)localObject).BJP = true;
          ((com.tencent.mm.plugin.fts.ui.a.t)localObject).BJI = 2;
          break;
        }
        if (paramInt != this.BJz + 1) {
          break label229;
        }
        localObject = new s(paramInt);
        ((s)localObject).BPN = ((fpj)this.BQW.RLp.get(0));
        ((s)localObject).BJP = true;
        ((s)localObject).BJI = 1;
        break;
      }
      label229:
      localObject = null;
    }
  }
  
  public final void a(String paramString, MMHandler paramMMHandler, HashSet<String> paramHashSet, long paramLong)
  {
    AppMethodBeat.i(112222);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vGT, 0) == 0)
    {
      eqX().a(this, paramString);
      AppMethodBeat.o(112222);
      return;
    }
    this.query = paramString;
    if (this.BQV != null)
    {
      com.tencent.mm.kernel.h.aGY().a(this.BQV);
      com.tencent.mm.kernel.h.aGY().b(2599, this);
      this.BQV = null;
    }
    paramMMHandler = new ecw();
    paramMMHandler.RYJ = paramString;
    paramMMHandler.UdA = paramLong;
    paramMMHandler.UdF = e.BHi;
    paramMMHandler.Uho = true;
    paramMMHandler.Uhn = 25L;
    this.BNf = paramLong;
    paramString = ai.czn();
    if (paramString != null)
    {
      paramMMHandler.Uhp = new fox();
      paramMMHandler.Uhp.ScP = paramString.ScP;
      paramMMHandler.Uhp.ScO = paramString.ScO;
    }
    this.BQV = new d(paramMMHandler);
    com.tencent.mm.kernel.h.aGY().a(2599, this);
    com.tencent.mm.kernel.h.aGY().a(this.BQV, 0);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vGU, 500);
    this.BMI = System.currentTimeMillis();
    this.BQX.removeMessages(1);
    paramString = this.BQX.obtainMessage(1, Long.valueOf(paramLong));
    this.BQX.sendMessageDelayed(paramString, i);
    AppMethodBeat.o(112222);
  }
  
  public final void clearData()
  {
    this.BNf = 0L;
    this.query = null;
    this.BQW = null;
    this.BJz = 2147483647;
    this.BJB = 2147483647;
  }
  
  public final int eqW()
  {
    AppMethodBeat.i(112228);
    if ((this.BQW != null) && (this.BQW.RLp.size() > 0)) {
      try
      {
        boolean bool = "HOME".equals(new JSONObject(((fpj)this.BQW.RLp.get(0)).UNe).optString("content_type", ""));
        if (bool)
        {
          AppMethodBeat.o(112228);
          return 2;
        }
        AppMethodBeat.o(112228);
        return 1;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(112228);
    return 0;
  }
  
  public final void eqZ()
  {
    AppMethodBeat.i(112223);
    if (this.BQV != null)
    {
      com.tencent.mm.kernel.h.aGY().a(this.BQV);
      com.tencent.mm.kernel.h.aGY().b(2599, this);
      this.BQV = null;
    }
    this.BQX.removeMessages(1);
    AppMethodBeat.o(112223);
  }
  
  public final LinkedList<Integer> era()
  {
    AppMethodBeat.i(112225);
    LinkedList localLinkedList = new LinkedList();
    if (this.BJz != 2147483647) {
      localLinkedList.add(Integer.valueOf(this.BJz));
    }
    AppMethodBeat.o(112225);
    return localLinkedList;
  }
  
  public final int erb()
  {
    int i = 0;
    AppMethodBeat.i(112227);
    if (this.BQW != null)
    {
      if (this.BQW.RLp.size() > 0)
      {
        if (this.BQW.Tic) {
          i = 1;
        }
        AppMethodBeat.o(112227);
        return i + 1;
      }
      AppMethodBeat.o(112227);
      return 0;
    }
    AppMethodBeat.o(112227);
    return 0;
  }
  
  public final long erc()
  {
    return this.BJO;
  }
  
  public final int getType()
  {
    return 256;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(112229);
    if (paramq.equals(this.BQV))
    {
      this.BQX.removeMessages(1);
      this.BJO = System.currentTimeMillis();
      com.tencent.mm.kernel.h.aGY().b(2599, this);
      paramString = this.BQV.BQR;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.BQW = paramString;
        Log.i("MicroMsg.FTS.FTSWeAppSearchUIUnit", "onSceneEnd Count %d TotalCount %d ContinueFlag %s SearchTime %d", new Object[] { Integer.valueOf(this.BQW.rVx), Integer.valueOf(this.BQW.rVW), Boolean.valueOf(this.BQW.Tic), Long.valueOf(this.BJO - this.BMI) });
      }
      eqX().a(this, this.query);
    }
    AppMethodBeat.o(112229);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.n
 * JD-Core Version:    0.7.0.1
 */