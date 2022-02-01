package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.ui.a.k;
import com.tencent.mm.plugin.fts.ui.a.s;
import com.tencent.mm.plugin.fts.ui.a.t;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.protocal.protobuf.bpa;
import com.tencent.mm.protocal.protobuf.ctq;
import com.tencent.mm.protocal.protobuf.ctr;
import com.tencent.mm.protocal.protobuf.ebj;
import com.tencent.mm.protocal.protobuf.ebu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public final class n
  extends com.tencent.mm.plugin.fts.a.d.b
  implements com.tencent.mm.ak.g
{
  String query;
  long sCr;
  long sGa;
  private com.tencent.mm.plugin.fts.ui.c.c sGb;
  private ctr sGc;
  private ao sGd;
  public long szB;
  private int szm;
  private int szo;
  
  public n(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
    AppMethodBeat.i(112221);
    this.szm = 2147483647;
    this.szo = 2147483647;
    this.sGd = new ao(Looper.getMainLooper())
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
          if (paramAnonymousMessage.obj.equals(Long.valueOf(n.this.sGa)))
          {
            n.this.szB = System.currentTimeMillis();
            ac.i("MicroMsg.FTS.FTSWeAppSearchUIUnit", "cancel Time %d", new Object[] { Long.valueOf(n.this.szB - n.this.sCr) });
            n.this.szl.a(n.this, n.this.query);
            n.this.cKD();
            n.this.clearData();
          }
        }
      }
    };
    AppMethodBeat.o(112221);
  }
  
  public final int FB(int paramInt)
  {
    AppMethodBeat.i(112224);
    int i;
    if ((this.sGc != null) && (this.sGc.DSZ.size() > 0))
    {
      this.szm = paramInt;
      i = paramInt + 1 + this.sGc.DSZ.size();
      if (this.sGc.ERy)
      {
        this.szo = i;
        i += 1;
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.FTS.FTSWeAppSearchUIUnit", "updateHeaderPosition curPos %d oriPos %d headerPosition %d morePosition %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(this.szm), Integer.valueOf(this.szo) });
      AppMethodBeat.o(112224);
      return i;
      this.szo = 2147483647;
      continue;
      this.szm = 2147483647;
      this.szo = 2147483647;
      i = paramInt;
    }
  }
  
  public final a FC(int paramInt)
  {
    AppMethodBeat.i(112226);
    Object localObject;
    if (paramInt == this.szm) {
      localObject = new k(paramInt);
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((a)localObject).pil = -20;
        ((a)localObject).kNw = this.kNw;
        ((a)localObject).szt = false;
        ((a)localObject).sxM = h.bi(this.query, false);
      }
      if (localObject != null) {}
      for (boolean bool = true;; bool = false)
      {
        ac.i("MicroMsg.FTS.FTSWeAppSearchUIUnit", "createDataItem position %d %s %d %d", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool), Integer.valueOf(this.szm), Integer.valueOf(this.szo) });
        AppMethodBeat.o(112226);
        return localObject;
        if (paramInt == this.szo)
        {
          localObject = new t(paramInt);
          ((t)localObject).sFg = ((ebu)this.sGc.DSZ.get(0));
          ((t)localObject).sFt = this.sGc.FFo;
          ((t)localObject).szC = true;
          ((t)localObject).szv = 2;
          break;
        }
        if (paramInt != this.szm + 1) {
          break label229;
        }
        localObject = new s(paramInt);
        ((s)localObject).sFg = ((ebu)this.sGc.DSZ.get(0));
        ((s)localObject).szC = true;
        ((s)localObject).szv = 1;
        break;
      }
      label229:
      localObject = null;
    }
  }
  
  public final void a(String paramString, ao paramao, HashSet<String> paramHashSet, long paramLong)
  {
    AppMethodBeat.i(112222);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pUO, com.tencent.mm.util.c.fwV()) == 0)
    {
      this.szl.a(this, paramString);
      AppMethodBeat.o(112222);
      return;
    }
    this.query = paramString;
    if (this.sGb != null)
    {
      com.tencent.mm.kernel.g.agi().a(this.sGb);
      com.tencent.mm.kernel.g.agi().b(2599, this);
      this.sGb = null;
    }
    paramao = new ctq();
    paramao.Eel = paramString;
    paramao.FCv = paramLong;
    paramao.FCA = e.swV;
    paramao.FFm = true;
    paramao.FFl = 25L;
    this.sGa = paramLong;
    paramString = z.bJn();
    if (paramString != null)
    {
      paramao.FFn = new ebj();
      paramao.FFn.Ehu = paramString.Ehu;
      paramao.FFn.Eht = paramString.Eht;
    }
    this.sGb = new com.tencent.mm.plugin.fts.ui.c.c(paramao);
    com.tencent.mm.kernel.g.agi().a(2599, this);
    com.tencent.mm.kernel.g.agi().a(this.sGb, 0);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pUP, 500);
    this.sCr = System.currentTimeMillis();
    this.sGd.removeMessages(1);
    paramString = this.sGd.obtainMessage(1, Long.valueOf(paramLong));
    this.sGd.sendMessageDelayed(paramString, i);
    AppMethodBeat.o(112222);
  }
  
  public final int cKC()
  {
    AppMethodBeat.i(112228);
    if ((this.sGc != null) && (this.sGc.DSZ.size() > 0)) {
      try
      {
        boolean bool = "HOME".equals(new JSONObject(((ebu)this.sGc.DSZ.get(0)).Ghg).optString("content_type", ""));
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
  
  public final void cKD()
  {
    AppMethodBeat.i(112223);
    if (this.sGb != null)
    {
      com.tencent.mm.kernel.g.agi().a(this.sGb);
      com.tencent.mm.kernel.g.agi().b(2599, this);
      this.sGb = null;
    }
    this.sGd.removeMessages(1);
    AppMethodBeat.o(112223);
  }
  
  public final LinkedList<Integer> cKE()
  {
    AppMethodBeat.i(112225);
    LinkedList localLinkedList = new LinkedList();
    if (this.szm != 2147483647) {
      localLinkedList.add(Integer.valueOf(this.szm));
    }
    AppMethodBeat.o(112225);
    return localLinkedList;
  }
  
  public final int cKF()
  {
    int i = 0;
    AppMethodBeat.i(112227);
    if (this.sGc != null)
    {
      if (this.sGc.DSZ.size() > 0)
      {
        if (this.sGc.ERy) {
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
  
  public final long cKG()
  {
    return this.szB;
  }
  
  public final void clearData()
  {
    this.sGa = 0L;
    this.query = null;
    this.sGc = null;
    this.szm = 2147483647;
    this.szo = 2147483647;
  }
  
  public final int getType()
  {
    return 256;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(112229);
    if (paramn.equals(this.sGb))
    {
      this.sGd.removeMessages(1);
      this.szB = System.currentTimeMillis();
      com.tencent.mm.kernel.g.agi().b(2599, this);
      paramString = this.sGb.sFW;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.sGc = paramString;
        ac.i("MicroMsg.FTS.FTSWeAppSearchUIUnit", "onSceneEnd Count %d TotalCount %d ContinueFlag %s SearchTime %d", new Object[] { Integer.valueOf(this.sGc.ncL), Integer.valueOf(this.sGc.ndl), Boolean.valueOf(this.sGc.ERy), Long.valueOf(this.szB - this.sCr) });
      }
      this.szl.a(this, this.query);
    }
    AppMethodBeat.o(112229);
  }
  
  public final List<com.tencent.mm.plugin.fts.a.a.c> vu(long paramLong)
  {
    AppMethodBeat.i(112230);
    ArrayList localArrayList = new ArrayList();
    if ((this.sGc != null) && (this.sGc.DSZ.size() > 0)) {
      if (cKC() != 2) {
        break label241;
      }
    }
    label241:
    for (int i = 26;; i = 25)
    {
      com.tencent.mm.plugin.fts.a.a.c localc = new com.tencent.mm.plugin.fts.a.a.c();
      localc.position = (this.szm + 1);
      localc.sxI = (this.szB - paramLong);
      localc.dpt = String.valueOf(((ebu)this.sGc.DSZ.get(0)).hashCode());
      localc.dpE = i;
      localc.sxK = ((ebu)this.sGc.DSZ.get(0)).Ghc;
      localArrayList.add(localc);
      if (this.sGc.ERy)
      {
        localc = new com.tencent.mm.plugin.fts.a.a.c();
        localc.position = this.szo;
        localc.sxI = (this.szB - paramLong);
        localc.dpt = String.valueOf(this.sGc.hashCode());
        localc.dpE = i;
        localc.sxK = ((ebu)this.sGc.DSZ.get(0)).Ghc;
        localArrayList.add(localc);
      }
      AppMethodBeat.o(112230);
      return localArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.n
 * JD-Core Version:    0.7.0.1
 */