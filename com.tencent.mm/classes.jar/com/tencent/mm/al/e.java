package com.tencent.mm.al;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.protocal.protobuf.ayi;
import com.tencent.mm.protocal.protobuf.cqt;
import com.tencent.mm.protocal.protobuf.dct;
import com.tencent.mm.protocal.protobuf.iv;
import com.tencent.mm.protocal.protobuf.nn;
import com.tencent.mm.protocal.protobuf.no;
import com.tencent.mm.protocal.protobuf.vv;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bu;

public final class e
  extends j<d>
  implements f
{
  public static final String[] SQL_CREATE;
  public static iv hSC;
  private com.tencent.mm.sdk.e.e db;
  private final l<a, e.a.a> hSD;
  
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
    this.hSD = new l() {};
    this.db = parame;
    parame.execSQL("BizEnterprise", "CREATE INDEX IF NOT EXISTS BizEnterpriseUserNameIndex ON BizEnterprise ( userName )");
    com.tencent.mm.kernel.g.ajQ().gDv.a(1343, this);
    com.tencent.mm.kernel.g.ajQ().gDv.a(1228, this);
    AppMethodBeat.o(123989);
  }
  
  public static af a(String paramString, boolean paramBoolean, f paramf)
  {
    AppMethodBeat.i(123999);
    nn localnn = new nn();
    localnn.FZx = paramString;
    if (paramBoolean) {}
    for (int i = 17;; i = 0)
    {
      localnn.FZW = i;
      localnn.FZU = 0;
      paramString = new af(localnn, paramf);
      if (!com.tencent.mm.kernel.g.ajQ().gDv.a(paramString, 0)) {
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
    com.tencent.mm.kernel.g.ajQ().gDv.a(paramaf);
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
    e.a.b localb = e.a.b.hSI;
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = super.replace(paramd);
      localb = e.a.b.hSK;
    }
    if (bool1)
    {
      e.a.a locala = new e.a.a();
      locala.hSG = paramd.field_userName;
      locala.hSF = localb;
      locala.hSH = paramd;
      this.hSD.dW(locala);
      this.hSD.doNotify();
    }
    AppMethodBeat.o(123996);
    return bool1;
  }
  
  private boolean a(nn paramnn)
  {
    AppMethodBeat.i(123997);
    d locald = Eb(paramnn.FZx);
    locald.field_userName = paramnn.FZx;
    locald.field_qyUin = paramnn.FZU;
    locald.field_userUin = paramnn.FZV;
    locald.field_wwMaxExposeTimes = paramnn.FZX;
    locald.field_wwUserVid = paramnn.FZY;
    locald.field_wwCorpId = paramnn.FZZ;
    locald.field_userType = paramnn.FZI;
    locald.field_chatOpen = paramnn.Gaa;
    locald.field_wwUnreadCnt = paramnn.Gab;
    locald.field_show_confirm = paramnn.Gac;
    locald.field_use_preset_banner_tips = paramnn.Gae;
    if (paramnn.Gaf != null)
    {
      locald.field_hide_create_chat = paramnn.Gaf.GnH;
      locald.field_hide_mod_chat_member = paramnn.Gaf.GnI;
    }
    locald.field_hide_colleage_invite = paramnn.Gah;
    try
    {
      no localno = new no();
      localno.Gag = paramnn.Gag;
      localno.Gai = paramnn.Gai;
      localno.Gaj = paramnn.Gaj;
      localno.Gak = paramnn.Gak;
      locald.field_raw_attrs = localno.toByteArray();
      label193:
      hSC = paramnn.Gad;
      if ((paramnn.FZY == 0L) && (paramnn.FZZ == 0L) && (paramnn.FZU != 0))
      {
        locald.field_wwUserVid = paramnn.FZV;
        locald.field_wwCorpId = paramnn.FZU;
      }
      paramnn.FZW &= 0xFFFFFFF7;
      locald.field_userFlag = (paramnn.FZW | locald.field_userFlag & 0x8);
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
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(123998);
      return false;
    }
    if (g.Es(paramString)) {}
    for (int i = 1;; i = 2)
    {
      paramString = new y(paramString, i, paramf);
      boolean bool = com.tencent.mm.kernel.g.ajQ().gDv.a(paramString, 0);
      AppMethodBeat.o(123998);
      return bool;
      if (!g.Er(paramString)) {
        break;
      }
    }
    AppMethodBeat.o(123998);
    return false;
  }
  
  public static String aFI()
  {
    AppMethodBeat.i(179034);
    if (hSC == null) {
      hSC = new iv();
    }
    String str = hSC.oGf;
    AppMethodBeat.o(179034);
    return str;
  }
  
  public static String aFJ()
  {
    AppMethodBeat.i(179035);
    if (hSC == null) {
      hSC = new iv();
    }
    String str = hSC.pqW;
    AppMethodBeat.o(179035);
    return str;
  }
  
  public static int aFK()
  {
    AppMethodBeat.i(179036);
    if (hSC == null) {
      hSC = new iv();
    }
    int i = 0;
    try
    {
      int j = Integer.parseInt(hSC.FUm);
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
  
  public static String oY(int paramInt)
  {
    AppMethodBeat.i(124003);
    String str = null;
    if (hSC == null) {
      hSC = new iv();
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(124003);
      return str;
      str = hSC.FUi;
      continue;
      str = hSC.FUj;
      continue;
      str = hSC.FUk;
    }
  }
  
  public final boolean Dc(String paramString)
  {
    AppMethodBeat.i(123995);
    if (bu.isNullOrNil(paramString))
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
      locala.hSG = paramString;
      locala.hSF = e.a.b.hSJ;
      locala.hSH = locald;
      this.hSD.dW(locala);
      this.hSD.doNotify();
    }
    AppMethodBeat.o(123995);
    return bool;
  }
  
  public final d Ea(String paramString)
  {
    AppMethodBeat.i(123992);
    if (bu.isNullOrNil(paramString))
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
  
  public final d Eb(String paramString)
  {
    AppMethodBeat.i(123993);
    d locald = Ea(paramString);
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
  
  public final int Ec(String paramString)
  {
    AppMethodBeat.i(123994);
    paramString = Ea(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(123994);
      return 0;
    }
    int i = paramString.field_qyUin;
    AppMethodBeat.o(123994);
    return i;
  }
  
  public final void Ed(String paramString)
  {
    AppMethodBeat.i(124000);
    paramString = Eb(paramString);
    if (paramString.field_wwExposeTimes >= paramString.field_wwMaxExposeTimes)
    {
      AppMethodBeat.o(124000);
      return;
    }
    paramString.field_wwExposeTimes += 1;
    a(paramString);
    AppMethodBeat.o(124000);
  }
  
  public final boolean Ee(String paramString)
  {
    AppMethodBeat.i(124002);
    paramString = Ea(paramString);
    if ((paramString != null) && ((paramString.field_userFlag & 0x1) != 0) && ((paramString.field_userFlag & 0x10) != 0))
    {
      AppMethodBeat.o(124002);
      return true;
    }
    AppMethodBeat.o(124002);
    return false;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(123991);
    if (this.hSD != null) {
      this.hSD.remove(parama);
    }
    AppMethodBeat.o(123991);
  }
  
  public final void a(a parama, Looper paramLooper)
  {
    AppMethodBeat.i(123990);
    this.hSD.a(parama, paramLooper);
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
      if ((((y)localObject2).rr != null) && (((y)localObject2).rr.hQE.hQJ != null)) {}
      for (localObject1 = (ayi)((y)localObject2).rr.hQE.hQJ; (localObject1 == null) || (((ayi)localObject1).FZD == null) || (((ayi)localObject1).FZD.ret != 0) || (((ayi)localObject1).GPf == null); localObject1 = null)
      {
        AppMethodBeat.o(124004);
        return;
      }
      if (!a(((ayi)localObject1).GPf)) {
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
      if ((((af)localObject2).rr != null) && (((af)localObject2).rr.hQE.hQJ != null)) {}
      for (localObject1 = (dct)((af)localObject2).rr.hQE.hQJ; (localObject1 == null) || (((dct)localObject1).FZD == null) || (((dct)localObject1).FZD.ret != 0) || (((dct)localObject1).GPf == null); localObject1 = null)
      {
        AppMethodBeat.o(124004);
        return;
      }
      if (a(((dct)localObject1).GPf)) {
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
      public e.a.b hSF;
      public String hSG;
      public d hSH;
    }
    
    public static enum b
    {
      static
      {
        AppMethodBeat.i(123988);
        hSI = new b("INSERT", 0);
        hSJ = new b("DELETE", 1);
        hSK = new b("UPDATE", 2);
        hSL = new b[] { hSI, hSJ, hSK };
        AppMethodBeat.o(123988);
      }
      
      private b() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.e
 * JD-Core Version:    0.7.0.1
 */