package com.tencent.mm.al;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.protocal.protobuf.atu;
import com.tencent.mm.protocal.protobuf.ckz;
import com.tencent.mm.protocal.protobuf.cwm;
import com.tencent.mm.protocal.protobuf.io;
import com.tencent.mm.protocal.protobuf.mu;
import com.tencent.mm.protocal.protobuf.mv;
import com.tencent.mm.protocal.protobuf.ty;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bs;

public final class d
  extends j<c>
  implements com.tencent.mm.ak.g
{
  public static final String[] SQL_CREATE;
  public static io hxp;
  private e db;
  private final l<a, d.a.a> hxq;
  
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
    this.hxq = new l() {};
    this.db = parame;
    parame.execSQL("BizEnterprise", "CREATE INDEX IF NOT EXISTS BizEnterpriseUserNameIndex ON BizEnterprise ( userName )");
    com.tencent.mm.kernel.g.agQ().ghe.a(1343, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(1228, this);
    AppMethodBeat.o(123989);
  }
  
  public static ae a(String paramString, boolean paramBoolean, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(123999);
    mu localmu = new mu();
    localmu.Ebs = paramString;
    if (paramBoolean) {}
    for (int i = 17;; i = 0)
    {
      localmu.EbO = i;
      localmu.EbM = 0;
      paramString = new ae(localmu, paramg);
      if (!com.tencent.mm.kernel.g.agQ().ghe.a(paramString, 0)) {
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
    com.tencent.mm.kernel.g.agQ().ghe.a(paramae);
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
    d.a.b localb = d.a.b.hxv;
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = super.replace(paramc);
      localb = d.a.b.hxx;
    }
    if (bool1)
    {
      d.a.a locala = new d.a.a();
      locala.hxt = paramc.field_userName;
      locala.hxs = localb;
      locala.hxu = paramc;
      this.hxq.dS(locala);
      this.hxq.doNotify();
    }
    AppMethodBeat.o(123996);
    return bool1;
  }
  
  private boolean a(mu parammu)
  {
    AppMethodBeat.i(123997);
    c localc = AA(parammu.Ebs);
    localc.field_userName = parammu.Ebs;
    localc.field_qyUin = parammu.EbM;
    localc.field_userUin = parammu.EbN;
    localc.field_wwMaxExposeTimes = parammu.EbP;
    localc.field_wwUserVid = parammu.EbQ;
    localc.field_wwCorpId = parammu.EbR;
    localc.field_userType = parammu.EbD;
    localc.field_chatOpen = parammu.EbS;
    localc.field_wwUnreadCnt = parammu.EbT;
    localc.field_show_confirm = parammu.EbU;
    localc.field_use_preset_banner_tips = parammu.EbW;
    if (parammu.EbX != null)
    {
      localc.field_hide_create_chat = parammu.EbX.EnZ;
      localc.field_hide_mod_chat_member = parammu.EbX.Eoa;
    }
    localc.field_hide_colleage_invite = parammu.EbZ;
    try
    {
      mv localmv = new mv();
      localmv.EbY = parammu.EbY;
      localmv.Eca = parammu.Eca;
      localmv.Ecb = parammu.Ecb;
      localmv.Ecc = parammu.Ecc;
      localc.field_raw_attrs = localmv.toByteArray();
      label193:
      hxp = parammu.EbV;
      if ((parammu.EbQ == 0L) && (parammu.EbR == 0L) && (parammu.EbM != 0))
      {
        localc.field_wwUserVid = parammu.EbN;
        localc.field_wwCorpId = parammu.EbM;
      }
      parammu.EbO &= 0xFFFFFFF7;
      localc.field_userFlag = (parammu.EbO | localc.field_userFlag & 0x8);
      boolean bool = a(localc);
      AppMethodBeat.o(123997);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      break label193;
    }
  }
  
  public static boolean a(String paramString, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(123998);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(123998);
      return false;
    }
    if (f.AR(paramString)) {}
    for (int i = 1;; i = 2)
    {
      paramString = new x(paramString, i, paramg);
      boolean bool = com.tencent.mm.kernel.g.agQ().ghe.a(paramString, 0);
      AppMethodBeat.o(123998);
      return bool;
      if (!f.AQ(paramString)) {
        break;
      }
    }
    AppMethodBeat.o(123998);
    return false;
  }
  
  public static String aCp()
  {
    AppMethodBeat.i(179034);
    if (hxp == null) {
      hxp = new io();
    }
    String str = hxp.nWj;
    AppMethodBeat.o(179034);
    return str;
  }
  
  public static String aCq()
  {
    AppMethodBeat.i(179035);
    if (hxp == null) {
      hxp = new io();
    }
    String str = hxp.oGN;
    AppMethodBeat.o(179035);
    return str;
  }
  
  public static int aCr()
  {
    AppMethodBeat.i(179036);
    if (hxp == null) {
      hxp = new io();
    }
    int i = 0;
    try
    {
      int j = Integer.parseInt(hxp.DWv);
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
  
  public static String ou(int paramInt)
  {
    AppMethodBeat.i(124003);
    String str = null;
    if (hxp == null) {
      hxp = new io();
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(124003);
      return str;
      str = hxp.DWr;
      continue;
      str = hxp.DWs;
      continue;
      str = hxp.DWt;
    }
  }
  
  public final c AA(String paramString)
  {
    AppMethodBeat.i(123993);
    c localc = Az(paramString);
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
  
  public final int AB(String paramString)
  {
    AppMethodBeat.i(123994);
    paramString = Az(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(123994);
      return 0;
    }
    int i = paramString.field_qyUin;
    AppMethodBeat.o(123994);
    return i;
  }
  
  public final void AC(String paramString)
  {
    AppMethodBeat.i(124000);
    paramString = AA(paramString);
    if (paramString.field_wwExposeTimes >= paramString.field_wwMaxExposeTimes)
    {
      AppMethodBeat.o(124000);
      return;
    }
    paramString.field_wwExposeTimes += 1;
    a(paramString);
    AppMethodBeat.o(124000);
  }
  
  public final boolean AD(String paramString)
  {
    AppMethodBeat.i(124002);
    paramString = Az(paramString);
    if ((paramString != null) && ((paramString.field_userFlag & 0x1) != 0) && ((paramString.field_userFlag & 0x10) != 0))
    {
      AppMethodBeat.o(124002);
      return true;
    }
    AppMethodBeat.o(124002);
    return false;
  }
  
  public final c Az(String paramString)
  {
    AppMethodBeat.i(123992);
    if (bs.isNullOrNil(paramString))
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
  
  public final void a(a parama)
  {
    AppMethodBeat.i(123991);
    if (this.hxq != null) {
      this.hxq.remove(parama);
    }
    AppMethodBeat.o(123991);
  }
  
  public final void a(a parama, Looper paramLooper)
  {
    AppMethodBeat.i(123990);
    this.hxq.a(parama, paramLooper);
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
      if ((((x)localObject2).rr != null) && (((x)localObject2).rr.hvs.hvw != null)) {}
      for (localObject1 = (atu)((x)localObject2).rr.hvs.hvw; (localObject1 == null) || (((atu)localObject1).Eby == null) || (((atu)localObject1).Eby.ret != 0) || (((atu)localObject1).EMC == null); localObject1 = null)
      {
        AppMethodBeat.o(124004);
        return;
      }
      if (!a(((atu)localObject1).EMC)) {
        paramInt2 = -1;
      }
      localObject1 = (com.tencent.mm.ak.g)((x)localObject2).data;
      i = paramInt2;
      if (localObject1 != null)
      {
        ((com.tencent.mm.ak.g)localObject1).onSceneEnd(paramInt1, paramInt2, paramString, paramn);
        i = paramInt2;
      }
    }
    if ((paramn instanceof ae))
    {
      localObject2 = (ae)paramn;
      if ((((ae)localObject2).rr != null) && (((ae)localObject2).rr.hvs.hvw != null)) {}
      for (localObject1 = (cwm)((ae)localObject2).rr.hvs.hvw; (localObject1 == null) || (((cwm)localObject1).Eby == null) || (((cwm)localObject1).Eby.ret != 0) || (((cwm)localObject1).EMC == null); localObject1 = null)
      {
        AppMethodBeat.o(124004);
        return;
      }
      if (a(((cwm)localObject1).EMC)) {
        break label319;
      }
    }
    label319:
    for (paramInt2 = j;; paramInt2 = i)
    {
      localObject1 = (com.tencent.mm.ak.g)((ae)localObject2).data;
      if (localObject1 != null) {
        ((com.tencent.mm.ak.g)localObject1).onSceneEnd(paramInt1, paramInt2, paramString, paramn);
      }
      AppMethodBeat.o(124004);
      return;
    }
  }
  
  public final boolean zB(String paramString)
  {
    AppMethodBeat.i(123995);
    if (bs.isNullOrNil(paramString))
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
      locala.hxt = paramString;
      locala.hxs = d.a.b.hxw;
      locala.hxu = localc;
      this.hxq.dS(locala);
      this.hxq.doNotify();
    }
    AppMethodBeat.o(123995);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract void a(a parama);
    
    public static final class a
    {
      public d.a.b hxs;
      public String hxt;
      public c hxu;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.d
 * JD-Core Version:    0.7.0.1
 */