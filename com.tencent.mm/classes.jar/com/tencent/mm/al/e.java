package com.tencent.mm.al;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.protocal.protobuf.bjs;
import com.tencent.mm.protocal.protobuf.dis;
import com.tencent.mm.protocal.protobuf.dvx;
import com.tencent.mm.protocal.protobuf.ji;
import com.tencent.mm.protocal.protobuf.og;
import com.tencent.mm.protocal.protobuf.oh;
import com.tencent.mm.protocal.protobuf.xd;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEvent;

public final class e
  extends MAutoStorage<d>
  implements i
{
  public static final String[] SQL_CREATE;
  public static ji iNR;
  private ISQLiteDatabase db;
  private final MStorageEvent<a, e.a.a> iNS;
  
  static
  {
    AppMethodBeat.i(124005);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(d.info, "BizEnterprise") };
    AppMethodBeat.o(124005);
  }
  
  public e(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, d.info, "BizEnterprise", null);
    AppMethodBeat.i(123989);
    this.iNS = new MStorageEvent() {};
    this.db = paramISQLiteDatabase;
    paramISQLiteDatabase.execSQL("BizEnterprise", "CREATE INDEX IF NOT EXISTS BizEnterpriseUserNameIndex ON BizEnterprise ( userName )");
    com.tencent.mm.kernel.g.aAg().hqi.a(1343, this);
    com.tencent.mm.kernel.g.aAg().hqi.a(1228, this);
    AppMethodBeat.o(123989);
  }
  
  public static af a(String paramString, boolean paramBoolean, i parami)
  {
    AppMethodBeat.i(123999);
    og localog = new og();
    localog.KTt = paramString;
    if (paramBoolean) {}
    for (int i = 17;; i = 0)
    {
      localog.KTQ = i;
      localog.KTO = 0;
      paramString = new af(localog, parami);
      if (!com.tencent.mm.kernel.g.aAg().hqi.a(paramString, 0)) {
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
    com.tencent.mm.kernel.g.aAg().hqi.a(paramaf);
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
    e.a.b localb = e.a.b.iNX;
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = super.replace(paramd);
      localb = e.a.b.iNZ;
    }
    if (bool1)
    {
      e.a.a locala = new e.a.a();
      locala.iNV = paramd.field_userName;
      locala.iNU = localb;
      locala.iNW = paramd;
      this.iNS.event(locala);
      this.iNS.doNotify();
    }
    AppMethodBeat.o(123996);
    return bool1;
  }
  
  private boolean a(og paramog)
  {
    AppMethodBeat.i(123997);
    d locald = MP(paramog.KTt);
    locald.field_userName = paramog.KTt;
    locald.field_qyUin = paramog.KTO;
    locald.field_userUin = paramog.KTP;
    locald.field_wwMaxExposeTimes = paramog.KTR;
    locald.field_wwUserVid = paramog.KTS;
    locald.field_wwCorpId = paramog.KTT;
    locald.field_userType = paramog.KTD;
    locald.field_chatOpen = paramog.KTU;
    locald.field_wwUnreadCnt = paramog.KTV;
    locald.field_show_confirm = paramog.KTW;
    locald.field_use_preset_banner_tips = paramog.KTY;
    if (paramog.KTZ != null)
    {
      locald.field_hide_create_chat = paramog.KTZ.Lil;
      locald.field_hide_mod_chat_member = paramog.KTZ.Lim;
    }
    locald.field_hide_colleage_invite = paramog.KUb;
    try
    {
      oh localoh = new oh();
      localoh.KUa = paramog.KUa;
      localoh.KUc = paramog.KUc;
      localoh.KUd = paramog.KUd;
      localoh.KUe = paramog.KUe;
      locald.field_raw_attrs = localoh.toByteArray();
      label193:
      iNR = paramog.KTX;
      if ((paramog.KTS == 0L) && (paramog.KTT == 0L) && (paramog.KTO != 0))
      {
        locald.field_wwUserVid = paramog.KTP;
        locald.field_wwCorpId = paramog.KTO;
      }
      paramog.KTQ &= 0xFFFFFFF7;
      locald.field_userFlag = (paramog.KTQ | locald.field_userFlag & 0x8);
      boolean bool = a(locald);
      AppMethodBeat.o(123997);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      break label193;
    }
  }
  
  public static boolean a(String paramString, i parami)
  {
    AppMethodBeat.i(123998);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(123998);
      return false;
    }
    if (g.Ng(paramString)) {}
    for (int i = 1;; i = 2)
    {
      paramString = new y(paramString, i, parami);
      boolean bool = com.tencent.mm.kernel.g.aAg().hqi.a(paramString, 0);
      AppMethodBeat.o(123998);
      return bool;
      if (!g.Nf(paramString)) {
        break;
      }
    }
    AppMethodBeat.o(123998);
    return false;
  }
  
  public static String aZA()
  {
    AppMethodBeat.i(179034);
    if (iNR == null) {
      iNR = new ji();
    }
    String str = iNR.pTL;
    AppMethodBeat.o(179034);
    return str;
  }
  
  public static String aZB()
  {
    AppMethodBeat.i(179035);
    if (iNR == null) {
      iNR = new ji();
    }
    String str = iNR.qGB;
    AppMethodBeat.o(179035);
    return str;
  }
  
  public static int aZC()
  {
    AppMethodBeat.i(179036);
    if (iNR == null) {
      iNR = new ji();
    }
    int i = 0;
    try
    {
      int j = Integer.parseInt(iNR.KNV);
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
  
  public static String sM(int paramInt)
  {
    AppMethodBeat.i(124003);
    String str = null;
    if (iNR == null) {
      iNR = new ji();
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(124003);
      return str;
      str = iNR.KNR;
      continue;
      str = iNR.KNS;
      continue;
      str = iNR.KNT;
    }
  }
  
  public final d MO(String paramString)
  {
    AppMethodBeat.i(123992);
    if (Util.isNullOrNil(paramString))
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
  
  public final d MP(String paramString)
  {
    AppMethodBeat.i(123993);
    d locald = MO(paramString);
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
  
  public final int MQ(String paramString)
  {
    AppMethodBeat.i(123994);
    paramString = MO(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(123994);
      return 0;
    }
    int i = paramString.field_qyUin;
    AppMethodBeat.o(123994);
    return i;
  }
  
  public final void MR(String paramString)
  {
    AppMethodBeat.i(124000);
    paramString = MP(paramString);
    if (paramString.field_wwExposeTimes >= paramString.field_wwMaxExposeTimes)
    {
      AppMethodBeat.o(124000);
      return;
    }
    paramString.field_wwExposeTimes += 1;
    a(paramString);
    AppMethodBeat.o(124000);
  }
  
  public final boolean MS(String paramString)
  {
    AppMethodBeat.i(124002);
    paramString = MO(paramString);
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
    if (this.iNS != null) {
      this.iNS.remove(parama);
    }
    AppMethodBeat.o(123991);
  }
  
  public final void a(a parama, Looper paramLooper)
  {
    AppMethodBeat.i(123990);
    this.iNS.add(parama, paramLooper);
    AppMethodBeat.o(123990);
  }
  
  public final boolean gC(String paramString)
  {
    AppMethodBeat.i(123995);
    if (Util.isNullOrNil(paramString))
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
      locala.iNV = paramString;
      locala.iNU = e.a.b.iNY;
      locala.iNW = locald;
      this.iNS.event(locala);
      this.iNS.doNotify();
    }
    AppMethodBeat.o(123995);
    return bool;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
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
    if ((paramq instanceof y))
    {
      localObject2 = (y)paramq;
      if ((((y)localObject2).rr != null) && (((y)localObject2).rr.iLL.iLR != null)) {}
      for (localObject1 = (bjs)((y)localObject2).rr.iLL.iLR; (localObject1 == null) || (((bjs)localObject1).KTz == null) || (((bjs)localObject1).KTz.ret != 0) || (((bjs)localObject1).LTl == null); localObject1 = null)
      {
        AppMethodBeat.o(124004);
        return;
      }
      if (!a(((bjs)localObject1).LTl)) {
        paramInt2 = -1;
      }
      localObject1 = (i)((y)localObject2).data;
      i = paramInt2;
      if (localObject1 != null)
      {
        ((i)localObject1).onSceneEnd(paramInt1, paramInt2, paramString, paramq);
        i = paramInt2;
      }
    }
    if ((paramq instanceof af))
    {
      localObject2 = (af)paramq;
      if ((((af)localObject2).rr != null) && (((af)localObject2).rr.iLL.iLR != null)) {}
      for (localObject1 = (dvx)((af)localObject2).rr.iLL.iLR; (localObject1 == null) || (((dvx)localObject1).KTz == null) || (((dvx)localObject1).KTz.ret != 0) || (((dvx)localObject1).LTl == null); localObject1 = null)
      {
        AppMethodBeat.o(124004);
        return;
      }
      if (a(((dvx)localObject1).LTl)) {
        break label319;
      }
    }
    label319:
    for (paramInt2 = j;; paramInt2 = i)
    {
      localObject1 = (i)((af)localObject2).data;
      if (localObject1 != null) {
        ((i)localObject1).onSceneEnd(paramInt1, paramInt2, paramString, paramq);
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
      public e.a.b iNU;
      public String iNV;
      public d iNW;
    }
    
    public static enum b
    {
      static
      {
        AppMethodBeat.i(123988);
        iNX = new b("INSERT", 0);
        iNY = new b("DELETE", 1);
        iNZ = new b("UPDATE", 2);
        iOa = new b[] { iNX, iNY, iNZ };
        AppMethodBeat.o(123988);
      }
      
      private b() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.al.e
 * JD-Core Version:    0.7.0.1
 */