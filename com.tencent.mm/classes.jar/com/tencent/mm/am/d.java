package com.tencent.mm.am;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.protocal.protobuf.aqq;
import com.tencent.mm.protocal.protobuf.cfw;
import com.tencent.mm.protocal.protobuf.crd;
import com.tencent.mm.protocal.protobuf.ii;
import com.tencent.mm.protocal.protobuf.mn;
import com.tencent.mm.protocal.protobuf.mo;
import com.tencent.mm.protocal.protobuf.to;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bt;

public final class d
  extends j<c>
  implements com.tencent.mm.al.g
{
  public static final String[] SQL_CREATE;
  public static ii gWQ;
  private e db;
  private final l<a, d.a.a> gWR;
  
  static
  {
    AppMethodBeat.i(124005);
    SQL_CREATE = new String[] { j.getCreateSQLs(c.info, "BizEnterprise") };
    AppMethodBeat.o(124005);
  }
  
  public d(e parame)
  {
    super(parame, c.info, "BizEnterprise", null);
    AppMethodBeat.i(123989);
    this.gWR = new l() {};
    this.db = parame;
    parame.execSQL("BizEnterprise", "CREATE INDEX IF NOT EXISTS BizEnterpriseUserNameIndex ON BizEnterprise ( userName )");
    com.tencent.mm.kernel.g.afA().gcy.a(1343, this);
    com.tencent.mm.kernel.g.afA().gcy.a(1228, this);
    AppMethodBeat.o(123989);
  }
  
  public static ae a(String paramString, boolean paramBoolean, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(123999);
    mn localmn = new mn();
    localmn.CIQ = paramString;
    if (paramBoolean) {}
    for (int i = 17;; i = 0)
    {
      localmn.CJm = i;
      localmn.CJk = 0;
      paramString = new ae(localmn, paramg);
      if (!com.tencent.mm.kernel.g.afA().gcy.a(paramString, 0)) {
        break;
      }
      AppMethodBeat.o(123999);
      return paramString;
    }
    AppMethodBeat.o(123999);
    return null;
  }
  
  public static void a(ae paramae)
  {
    AppMethodBeat.i(124001);
    com.tencent.mm.kernel.g.afA().gcy.a(paramae);
    paramae.data = null;
    AppMethodBeat.o(124001);
  }
  
  private boolean a(c paramc)
  {
    AppMethodBeat.i(123996);
    if (paramc == null)
    {
      AppMethodBeat.o(123996);
      return false;
    }
    boolean bool2 = super.insert(paramc);
    d.a.b localb = d.a.b.gWW;
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = super.replace(paramc);
      localb = d.a.b.gWY;
    }
    if (bool1)
    {
      d.a.a locala = new d.a.a();
      locala.gWU = paramc.field_userName;
      locala.gWT = localb;
      locala.gWV = paramc;
      this.gWR.dR(locala);
      this.gWR.doNotify();
    }
    AppMethodBeat.o(123996);
    return bool1;
  }
  
  private boolean a(mn parammn)
  {
    AppMethodBeat.i(123997);
    c localc = wu(parammn.CIQ);
    localc.field_userName = parammn.CIQ;
    localc.field_qyUin = parammn.CJk;
    localc.field_userUin = parammn.CJl;
    localc.field_wwMaxExposeTimes = parammn.CJn;
    localc.field_wwUserVid = parammn.CJo;
    localc.field_wwCorpId = parammn.CJp;
    localc.field_userType = parammn.CJb;
    localc.field_chatOpen = parammn.CJq;
    localc.field_wwUnreadCnt = parammn.CJr;
    localc.field_show_confirm = parammn.CJs;
    localc.field_use_preset_banner_tips = parammn.CJu;
    if (parammn.CJv != null)
    {
      localc.field_hide_create_chat = parammn.CJv.CVp;
      localc.field_hide_mod_chat_member = parammn.CJv.CVq;
    }
    localc.field_hide_colleage_invite = parammn.CJx;
    try
    {
      mo localmo = new mo();
      localmo.CJw = parammn.CJw;
      localmo.CJy = parammn.CJy;
      localmo.CJz = parammn.CJz;
      localmo.CJA = parammn.CJA;
      localc.field_raw_attrs = localmo.toByteArray();
      label193:
      gWQ = parammn.CJt;
      if ((parammn.CJo == 0L) && (parammn.CJp == 0L) && (parammn.CJk != 0))
      {
        localc.field_wwUserVid = parammn.CJl;
        localc.field_wwCorpId = parammn.CJk;
      }
      parammn.CJm &= 0xFFFFFFF7;
      localc.field_userFlag = (parammn.CJm | localc.field_userFlag & 0x8);
      boolean bool = a(localc);
      AppMethodBeat.o(123997);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      break label193;
    }
  }
  
  public static boolean a(String paramString, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(123998);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(123998);
      return false;
    }
    if (f.wL(paramString)) {}
    for (int i = 1;; i = 2)
    {
      paramString = new x(paramString, i, paramg);
      boolean bool = com.tencent.mm.kernel.g.afA().gcy.a(paramString, 0);
      AppMethodBeat.o(123998);
      return bool;
      if (!f.wK(paramString)) {
        break;
      }
    }
    AppMethodBeat.o(123998);
    return false;
  }
  
  public static String avw()
  {
    AppMethodBeat.i(179034);
    if (gWQ == null) {
      gWQ = new ii();
    }
    String str = gWQ.ntj;
    AppMethodBeat.o(179034);
    return str;
  }
  
  public static String avx()
  {
    AppMethodBeat.i(179035);
    if (gWQ == null) {
      gWQ = new ii();
    }
    String str = gWQ.odo;
    AppMethodBeat.o(179035);
    return str;
  }
  
  public static int avy()
  {
    AppMethodBeat.i(179036);
    if (gWQ == null) {
      gWQ = new ii();
    }
    int i = 0;
    try
    {
      int j = Integer.parseInt(gWQ.CDV);
      i = j;
    }
    catch (Throwable localThrowable)
    {
      label36:
      break label36;
    }
    AppMethodBeat.o(179036);
    return i;
  }
  
  public static String nG(int paramInt)
  {
    AppMethodBeat.i(124003);
    String str = null;
    if (gWQ == null) {
      gWQ = new ii();
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(124003);
      return str;
      str = gWQ.CDR;
      continue;
      str = gWQ.CDS;
      continue;
      str = gWQ.CDT;
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(123991);
    if (this.gWR != null) {
      this.gWR.remove(parama);
    }
    AppMethodBeat.o(123991);
  }
  
  public final void a(a parama, Looper paramLooper)
  {
    AppMethodBeat.i(123990);
    this.gWR.a(parama, paramLooper);
    AppMethodBeat.o(123990);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    int j = -1;
    AppMethodBeat.i(124004);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(124004);
      return;
    }
    int i = paramInt2;
    Object localObject2;
    Object localObject1;
    if ((paramn instanceof x))
    {
      localObject2 = (x)paramn;
      if ((((x)localObject2).rr != null) && (((x)localObject2).rr.gUT.gUX != null)) {}
      for (localObject1 = (aqq)((x)localObject2).rr.gUT.gUX; (localObject1 == null) || (((aqq)localObject1).CIW == null) || (((aqq)localObject1).CIW.ret != 0) || (((aqq)localObject1).DrA == null); localObject1 = null)
      {
        AppMethodBeat.o(124004);
        return;
      }
      if (!a(((aqq)localObject1).DrA)) {
        paramInt2 = -1;
      }
      localObject1 = (com.tencent.mm.al.g)((x)localObject2).data;
      i = paramInt2;
      if (localObject1 != null)
      {
        ((com.tencent.mm.al.g)localObject1).onSceneEnd(paramInt1, paramInt2, paramString, paramn);
        i = paramInt2;
      }
    }
    if ((paramn instanceof ae))
    {
      localObject2 = (ae)paramn;
      if ((((ae)localObject2).rr != null) && (((ae)localObject2).rr.gUT.gUX != null)) {}
      for (localObject1 = (crd)((ae)localObject2).rr.gUT.gUX; (localObject1 == null) || (((crd)localObject1).CIW == null) || (((crd)localObject1).CIW.ret != 0) || (((crd)localObject1).DrA == null); localObject1 = null)
      {
        AppMethodBeat.o(124004);
        return;
      }
      if (a(((crd)localObject1).DrA)) {
        break label319;
      }
    }
    label319:
    for (paramInt2 = j;; paramInt2 = i)
    {
      localObject1 = (com.tencent.mm.al.g)((ae)localObject2).data;
      if (localObject1 != null) {
        ((com.tencent.mm.al.g)localObject1).onSceneEnd(paramInt1, paramInt2, paramString, paramn);
      }
      AppMethodBeat.o(124004);
      return;
    }
  }
  
  public final boolean vv(String paramString)
  {
    AppMethodBeat.i(123995);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(123995);
      return false;
    }
    c localc = new c();
    localc.field_userName = paramString;
    boolean bool = super.delete(localc, new String[] { "userName" });
    if (bool)
    {
      d.a.a locala = new d.a.a();
      locala.gWU = paramString;
      locala.gWT = d.a.b.gWX;
      locala.gWV = localc;
      this.gWR.dR(locala);
      this.gWR.doNotify();
    }
    AppMethodBeat.o(123995);
    return bool;
  }
  
  public final c wt(String paramString)
  {
    AppMethodBeat.i(123992);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(123992);
      return null;
    }
    c localc = new c();
    localc.field_userName = paramString;
    if (super.get(localc, new String[0]))
    {
      AppMethodBeat.o(123992);
      return localc;
    }
    a(paramString, null);
    AppMethodBeat.o(123992);
    return null;
  }
  
  public final c wu(String paramString)
  {
    AppMethodBeat.i(123993);
    c localc = wt(paramString);
    if (localc == null)
    {
      localc = new c();
      localc.field_userName = paramString;
      localc.field_qyUin = 0;
      localc.field_userUin = 0;
      localc.field_userFlag = 0;
      localc.field_wwExposeTimes = 0;
      localc.field_wwMaxExposeTimes = 0;
      localc.field_wwUserVid = 0L;
      localc.field_wwCorpId = 0L;
      localc.field_chatOpen = false;
      localc.field_wwUnreadCnt = 0;
      AppMethodBeat.o(123993);
      return localc;
    }
    AppMethodBeat.o(123993);
    return localc;
  }
  
  public final int wv(String paramString)
  {
    AppMethodBeat.i(123994);
    paramString = wt(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(123994);
      return 0;
    }
    int i = paramString.field_qyUin;
    AppMethodBeat.o(123994);
    return i;
  }
  
  public final void ww(String paramString)
  {
    AppMethodBeat.i(124000);
    paramString = wu(paramString);
    if (paramString.field_wwExposeTimes >= paramString.field_wwMaxExposeTimes)
    {
      AppMethodBeat.o(124000);
      return;
    }
    paramString.field_wwExposeTimes += 1;
    a(paramString);
    AppMethodBeat.o(124000);
  }
  
  public final boolean wx(String paramString)
  {
    AppMethodBeat.i(124002);
    paramString = wt(paramString);
    if ((paramString != null) && ((paramString.field_userFlag & 0x1) != 0) && ((paramString.field_userFlag & 0x10) != 0))
    {
      AppMethodBeat.o(124002);
      return true;
    }
    AppMethodBeat.o(124002);
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void a(a parama);
    
    public static final class a
    {
      public d.a.b gWT;
      public String gWU;
      public c gWV;
    }
    
    public static enum b
    {
      static
      {
        AppMethodBeat.i(123988);
        gWW = new b("INSERT", 0);
        gWX = new b("DELETE", 1);
        gWY = new b("UPDATE", 2);
        gWZ = new b[] { gWW, gWX, gWY };
        AppMethodBeat.o(123988);
      }
      
      private b() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.d
 * JD-Core Version:    0.7.0.1
 */