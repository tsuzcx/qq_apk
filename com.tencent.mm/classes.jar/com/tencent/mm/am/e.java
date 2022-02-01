package com.tencent.mm.am;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.protocal.protobuf.axs;
import com.tencent.mm.protocal.protobuf.cpz;
import com.tencent.mm.protocal.protobuf.dbz;
import com.tencent.mm.protocal.protobuf.iv;
import com.tencent.mm.protocal.protobuf.nl;
import com.tencent.mm.protocal.protobuf.nm;
import com.tencent.mm.protocal.protobuf.vt;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bt;

public final class e
  extends j<d>
  implements f
{
  public static final String[] SQL_CREATE;
  public static iv hPK;
  private com.tencent.mm.sdk.e.e db;
  private final l<a, e.a.a> hPL;
  
  static
  {
    AppMethodBeat.i(124005);
    SQL_CREATE = new String[] { j.getCreateSQLs(d.info, "BizEnterprise") };
    AppMethodBeat.o(124005);
  }
  
  public e(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, d.info, "BizEnterprise", null);
    AppMethodBeat.i(123989);
    this.hPL = new l() {};
    this.db = parame;
    parame.execSQL("BizEnterprise", "CREATE INDEX IF NOT EXISTS BizEnterpriseUserNameIndex ON BizEnterprise ( userName )");
    com.tencent.mm.kernel.g.ajB().gAO.a(1343, this);
    com.tencent.mm.kernel.g.ajB().gAO.a(1228, this);
    AppMethodBeat.o(123989);
  }
  
  public static af a(String paramString, boolean paramBoolean, f paramf)
  {
    AppMethodBeat.i(123999);
    nl localnl = new nl();
    localnl.FHb = paramString;
    if (paramBoolean) {}
    for (int i = 17;; i = 0)
    {
      localnl.FHA = i;
      localnl.FHy = 0;
      paramString = new af(localnl, paramf);
      if (!com.tencent.mm.kernel.g.ajB().gAO.a(paramString, 0)) {
        break;
      }
      AppMethodBeat.o(123999);
      return paramString;
    }
    AppMethodBeat.o(123999);
    return null;
  }
  
  public static void a(af paramaf)
  {
    AppMethodBeat.i(124001);
    com.tencent.mm.kernel.g.ajB().gAO.a(paramaf);
    paramaf.data = null;
    AppMethodBeat.o(124001);
  }
  
  private boolean a(d paramd)
  {
    AppMethodBeat.i(123996);
    if (paramd == null)
    {
      AppMethodBeat.o(123996);
      return false;
    }
    boolean bool2 = super.insert(paramd);
    e.a.b localb = e.a.b.hPQ;
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = super.replace(paramd);
      localb = e.a.b.hPS;
    }
    if (bool1)
    {
      e.a.a locala = new e.a.a();
      locala.hPO = paramd.field_userName;
      locala.hPN = localb;
      locala.hPP = paramd;
      this.hPL.dV(locala);
      this.hPL.doNotify();
    }
    AppMethodBeat.o(123996);
    return bool1;
  }
  
  private boolean a(nl paramnl)
  {
    AppMethodBeat.i(123997);
    d locald = Dz(paramnl.FHb);
    locald.field_userName = paramnl.FHb;
    locald.field_qyUin = paramnl.FHy;
    locald.field_userUin = paramnl.FHz;
    locald.field_wwMaxExposeTimes = paramnl.FHB;
    locald.field_wwUserVid = paramnl.FHC;
    locald.field_wwCorpId = paramnl.FHD;
    locald.field_userType = paramnl.FHm;
    locald.field_chatOpen = paramnl.FHE;
    locald.field_wwUnreadCnt = paramnl.FHF;
    locald.field_show_confirm = paramnl.FHG;
    locald.field_use_preset_banner_tips = paramnl.FHI;
    if (paramnl.FHJ != null)
    {
      locald.field_hide_create_chat = paramnl.FHJ.FVi;
      locald.field_hide_mod_chat_member = paramnl.FHJ.FVj;
    }
    locald.field_hide_colleage_invite = paramnl.FHL;
    try
    {
      nm localnm = new nm();
      localnm.FHK = paramnl.FHK;
      localnm.FHM = paramnl.FHM;
      localnm.FHN = paramnl.FHN;
      localnm.FHO = paramnl.FHO;
      locald.field_raw_attrs = localnm.toByteArray();
      label193:
      hPK = paramnl.FHH;
      if ((paramnl.FHC == 0L) && (paramnl.FHD == 0L) && (paramnl.FHy != 0))
      {
        locald.field_wwUserVid = paramnl.FHz;
        locald.field_wwCorpId = paramnl.FHy;
      }
      paramnl.FHA &= 0xFFFFFFF7;
      locald.field_userFlag = (paramnl.FHA | locald.field_userFlag & 0x8);
      boolean bool = a(locald);
      AppMethodBeat.o(123997);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      break label193;
    }
  }
  
  public static boolean a(String paramString, f paramf)
  {
    AppMethodBeat.i(123998);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(123998);
      return false;
    }
    if (g.DQ(paramString)) {}
    for (int i = 1;; i = 2)
    {
      paramString = new y(paramString, i, paramf);
      boolean bool = com.tencent.mm.kernel.g.ajB().gAO.a(paramString, 0);
      AppMethodBeat.o(123998);
      return bool;
      if (!g.DP(paramString)) {
        break;
      }
    }
    AppMethodBeat.o(123998);
    return false;
  }
  
  public static String aFs()
  {
    AppMethodBeat.i(179034);
    if (hPK == null) {
      hPK = new iv();
    }
    String str = hPK.ozD;
    AppMethodBeat.o(179034);
    return str;
  }
  
  public static String aFt()
  {
    AppMethodBeat.i(179035);
    if (hPK == null) {
      hPK = new iv();
    }
    String str = hPK.pkr;
    AppMethodBeat.o(179035);
    return str;
  }
  
  public static int aFu()
  {
    AppMethodBeat.i(179036);
    if (hPK == null) {
      hPK = new iv();
    }
    int i = 0;
    try
    {
      int j = Integer.parseInt(hPK.FBR);
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
  
  public static String oV(int paramInt)
  {
    AppMethodBeat.i(124003);
    String str = null;
    if (hPK == null) {
      hPK = new iv();
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(124003);
      return str;
      str = hPK.FBN;
      continue;
      str = hPK.FBO;
      continue;
      str = hPK.FBP;
    }
  }
  
  public final boolean CA(String paramString)
  {
    AppMethodBeat.i(123995);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(123995);
      return false;
    }
    d locald = new d();
    locald.field_userName = paramString;
    boolean bool = super.delete(locald, new String[] { "userName" });
    if (bool)
    {
      e.a.a locala = new e.a.a();
      locala.hPO = paramString;
      locala.hPN = e.a.b.hPR;
      locala.hPP = locald;
      this.hPL.dV(locala);
      this.hPL.doNotify();
    }
    AppMethodBeat.o(123995);
    return bool;
  }
  
  public final int DA(String paramString)
  {
    AppMethodBeat.i(123994);
    paramString = Dy(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(123994);
      return 0;
    }
    int i = paramString.field_qyUin;
    AppMethodBeat.o(123994);
    return i;
  }
  
  public final void DB(String paramString)
  {
    AppMethodBeat.i(124000);
    paramString = Dz(paramString);
    if (paramString.field_wwExposeTimes >= paramString.field_wwMaxExposeTimes)
    {
      AppMethodBeat.o(124000);
      return;
    }
    paramString.field_wwExposeTimes += 1;
    a(paramString);
    AppMethodBeat.o(124000);
  }
  
  public final boolean DC(String paramString)
  {
    AppMethodBeat.i(124002);
    paramString = Dy(paramString);
    if ((paramString != null) && ((paramString.field_userFlag & 0x1) != 0) && ((paramString.field_userFlag & 0x10) != 0))
    {
      AppMethodBeat.o(124002);
      return true;
    }
    AppMethodBeat.o(124002);
    return false;
  }
  
  public final d Dy(String paramString)
  {
    AppMethodBeat.i(123992);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(123992);
      return null;
    }
    d locald = new d();
    locald.field_userName = paramString;
    if (super.get(locald, new String[0]))
    {
      AppMethodBeat.o(123992);
      return locald;
    }
    a(paramString, null);
    AppMethodBeat.o(123992);
    return null;
  }
  
  public final d Dz(String paramString)
  {
    AppMethodBeat.i(123993);
    d locald = Dy(paramString);
    if (locald == null)
    {
      locald = new d();
      locald.field_userName = paramString;
      locald.field_qyUin = 0;
      locald.field_userUin = 0;
      locald.field_userFlag = 0;
      locald.field_wwExposeTimes = 0;
      locald.field_wwMaxExposeTimes = 0;
      locald.field_wwUserVid = 0L;
      locald.field_wwCorpId = 0L;
      locald.field_chatOpen = false;
      locald.field_wwUnreadCnt = 0;
      AppMethodBeat.o(123993);
      return locald;
    }
    AppMethodBeat.o(123993);
    return locald;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(123991);
    if (this.hPL != null) {
      this.hPL.remove(parama);
    }
    AppMethodBeat.o(123991);
  }
  
  public final void a(a parama, Looper paramLooper)
  {
    AppMethodBeat.i(123990);
    this.hPL.a(parama, paramLooper);
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
    if ((paramn instanceof y))
    {
      localObject2 = (y)paramn;
      if ((((y)localObject2).rr != null) && (((y)localObject2).rr.hNL.hNQ != null)) {}
      for (localObject1 = (axs)((y)localObject2).rr.hNL.hNQ; (localObject1 == null) || (((axs)localObject1).FHh == null) || (((axs)localObject1).FHh.ret != 0) || (((axs)localObject1).GvG == null); localObject1 = null)
      {
        AppMethodBeat.o(124004);
        return;
      }
      if (!a(((axs)localObject1).GvG)) {
        paramInt2 = -1;
      }
      localObject1 = (f)((y)localObject2).data;
      i = paramInt2;
      if (localObject1 != null)
      {
        ((f)localObject1).onSceneEnd(paramInt1, paramInt2, paramString, paramn);
        i = paramInt2;
      }
    }
    if ((paramn instanceof af))
    {
      localObject2 = (af)paramn;
      if ((((af)localObject2).rr != null) && (((af)localObject2).rr.hNL.hNQ != null)) {}
      for (localObject1 = (dbz)((af)localObject2).rr.hNL.hNQ; (localObject1 == null) || (((dbz)localObject1).FHh == null) || (((dbz)localObject1).FHh.ret != 0) || (((dbz)localObject1).GvG == null); localObject1 = null)
      {
        AppMethodBeat.o(124004);
        return;
      }
      if (a(((dbz)localObject1).GvG)) {
        break label319;
      }
    }
    label319:
    for (paramInt2 = j;; paramInt2 = i)
    {
      localObject1 = (f)((af)localObject2).data;
      if (localObject1 != null) {
        ((f)localObject1).onSceneEnd(paramInt1, paramInt2, paramString, paramn);
      }
      AppMethodBeat.o(124004);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(a parama);
    
    public static final class a
    {
      public e.a.b hPN;
      public String hPO;
      public d hPP;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.am.e
 * JD-Core Version:    0.7.0.1
 */