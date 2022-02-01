package com.tencent.mm.ao;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.brb;
import com.tencent.mm.protocal.protobuf.dsk;
import com.tencent.mm.protocal.protobuf.efz;
import com.tencent.mm.protocal.protobuf.ix;
import com.tencent.mm.protocal.protobuf.nw;
import com.tencent.mm.protocal.protobuf.nx;
import com.tencent.mm.protocal.protobuf.xj;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEvent;

public final class e
  extends MAutoStorage<d>
  implements i
{
  public static final String[] SQL_CREATE;
  public static ix lEi;
  private ISQLiteDatabase db;
  private final MStorageEvent<a, e.a.a> lEj;
  
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
    this.lEj = new MStorageEvent() {};
    this.db = paramISQLiteDatabase;
    paramISQLiteDatabase.execSQL("BizEnterprise", "CREATE INDEX IF NOT EXISTS BizEnterpriseUserNameIndex ON BizEnterprise ( userName )");
    y.a(this);
    ae.a(this);
    AppMethodBeat.o(123989);
  }
  
  public static ae a(String paramString, boolean paramBoolean, i parami)
  {
    AppMethodBeat.i(123999);
    nw localnw = new nw();
    localnw.RUp = paramString;
    if (paramBoolean) {}
    for (int i = 17;; i = 0)
    {
      localnw.RUO = i;
      localnw.RUM = 0;
      paramString = new ae(localnw, parami);
      if (!h.aHF().kcd.a(paramString, 0)) {
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
    h.aHF().kcd.a(paramae);
    paramae.bnW = null;
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
    e.a.b localb = e.a.b.lEo;
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = super.replace(paramd);
      localb = e.a.b.lEq;
    }
    if (bool1)
    {
      e.a.a locala = new e.a.a();
      locala.lEm = paramd.field_userName;
      locala.lEl = localb;
      locala.lEn = paramd;
      this.lEj.event(locala);
      this.lEj.doNotify();
    }
    AppMethodBeat.o(123996);
    return bool1;
  }
  
  private boolean a(nw paramnw)
  {
    AppMethodBeat.i(123997);
    d locald = Uk(paramnw.RUp);
    locald.field_userName = paramnw.RUp;
    locald.field_qyUin = paramnw.RUM;
    locald.field_userUin = paramnw.RUN;
    locald.field_wwMaxExposeTimes = paramnw.RUP;
    locald.field_wwUserVid = paramnw.RUQ;
    locald.field_wwCorpId = paramnw.RUR;
    locald.field_userType = paramnw.RUz;
    locald.field_chatOpen = paramnw.RUS;
    locald.field_wwUnreadCnt = paramnw.RUT;
    locald.field_show_confirm = paramnw.RUU;
    locald.field_use_preset_banner_tips = paramnw.RUW;
    if (paramnw.RUX != null)
    {
      locald.field_hide_create_chat = paramnw.RUX.SjC;
      locald.field_hide_mod_chat_member = paramnw.RUX.SjD;
    }
    locald.field_hide_colleage_invite = paramnw.RUZ;
    try
    {
      nx localnx = new nx();
      localnx.RUY = paramnw.RUY;
      localnx.RVa = paramnw.RVa;
      localnx.RVb = paramnw.RVb;
      localnx.RVc = paramnw.RVc;
      locald.field_raw_attrs = localnx.toByteArray();
      label193:
      lEi = paramnw.RUV;
      if ((paramnw.RUQ == 0L) && (paramnw.RUR == 0L) && (paramnw.RUM != 0))
      {
        locald.field_wwUserVid = paramnw.RUN;
        locald.field_wwCorpId = paramnw.RUM;
      }
      paramnw.RUO &= 0xFFFFFFF7;
      locald.field_userFlag = (paramnw.RUO | locald.field_userFlag & 0x8);
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
    if (g.UC(paramString)) {}
    for (int i = 1;; i = 2)
    {
      paramString = new y(paramString, i, parami);
      boolean bool = h.aHF().kcd.a(paramString, 0);
      AppMethodBeat.o(123998);
      return bool;
      if (!g.UB(paramString)) {
        break;
      }
    }
    AppMethodBeat.o(123998);
    return false;
  }
  
  public static String biQ()
  {
    AppMethodBeat.i(179034);
    if (lEi == null) {
      lEi = new ix();
    }
    String str = lEi.jump_url;
    AppMethodBeat.o(179034);
    return str;
  }
  
  public static String biR()
  {
    AppMethodBeat.i(179035);
    if (lEi == null) {
      lEi = new ix();
    }
    String str = lEi.ufC;
    AppMethodBeat.o(179035);
    return str;
  }
  
  public static int biS()
  {
    AppMethodBeat.i(179036);
    if (lEi == null) {
      lEi = new ix();
    }
    int i = 0;
    try
    {
      int j = Integer.parseInt(lEi.ROP);
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
  
  public static String vJ(int paramInt)
  {
    AppMethodBeat.i(124003);
    String str = null;
    if (lEi == null) {
      lEi = new ix();
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(124003);
      return str;
      str = lEi.ROL;
      continue;
      str = lEi.ROM;
      continue;
      str = lEi.RON;
    }
  }
  
  public final d Uj(String paramString)
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
  
  public final d Uk(String paramString)
  {
    AppMethodBeat.i(123993);
    d locald = Uj(paramString);
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
  
  public final int Ul(String paramString)
  {
    AppMethodBeat.i(123994);
    paramString = Uj(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(123994);
      return 0;
    }
    int i = paramString.field_qyUin;
    AppMethodBeat.o(123994);
    return i;
  }
  
  public final void Um(String paramString)
  {
    AppMethodBeat.i(124000);
    paramString = Uk(paramString);
    if (paramString.field_wwExposeTimes >= paramString.field_wwMaxExposeTimes)
    {
      AppMethodBeat.o(124000);
      return;
    }
    paramString.field_wwExposeTimes += 1;
    a(paramString);
    AppMethodBeat.o(124000);
  }
  
  public final boolean Un(String paramString)
  {
    AppMethodBeat.i(124002);
    paramString = Uj(paramString);
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
    if (this.lEj != null) {
      this.lEj.remove(parama);
    }
    AppMethodBeat.o(123991);
  }
  
  public final void a(a parama, Looper paramLooper)
  {
    AppMethodBeat.i(123990);
    this.lEj.add(parama, paramLooper);
    AppMethodBeat.o(123990);
  }
  
  public final boolean ho(String paramString)
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
      locala.lEm = paramString;
      locala.lEl = e.a.b.lEp;
      locala.lEn = locald;
      this.lEj.event(locala);
      this.lEj.doNotify();
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
      if ((((y)localObject2).rr != null) && (d.c.b(((y)localObject2).rr.lBS) != null)) {}
      for (localObject1 = (brb)d.c.b(((y)localObject2).rr.lBS); (localObject1 == null) || (((brb)localObject1).RUv == null) || (((brb)localObject1).RUv.ret != 0) || (((brb)localObject1).TbW == null); localObject1 = null)
      {
        AppMethodBeat.o(124004);
        return;
      }
      if (!a(((brb)localObject1).TbW)) {
        paramInt2 = -1;
      }
      localObject1 = (i)((y)localObject2).bnW;
      i = paramInt2;
      if (localObject1 != null)
      {
        ((i)localObject1).onSceneEnd(paramInt1, paramInt2, paramString, paramq);
        i = paramInt2;
      }
    }
    if ((paramq instanceof ae))
    {
      localObject2 = (ae)paramq;
      if ((((ae)localObject2).rr != null) && (d.c.b(((ae)localObject2).rr.lBS) != null)) {}
      for (localObject1 = (efz)d.c.b(((ae)localObject2).rr.lBS); (localObject1 == null) || (((efz)localObject1).RUv == null) || (((efz)localObject1).RUv.ret != 0) || (((efz)localObject1).TbW == null); localObject1 = null)
      {
        AppMethodBeat.o(124004);
        return;
      }
      if (a(((efz)localObject1).TbW)) {
        break label319;
      }
    }
    label319:
    for (paramInt2 = j;; paramInt2 = i)
    {
      localObject1 = (i)((ae)localObject2).bnW;
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
      public e.a.b lEl;
      public String lEm;
      public d lEn;
    }
    
    public static enum b
    {
      static
      {
        AppMethodBeat.i(123988);
        lEo = new b("INSERT", 0);
        lEp = new b("DELETE", 1);
        lEq = new b("UPDATE", 2);
        lEr = new b[] { lEo, lEp, lEq };
        AppMethodBeat.o(123988);
      }
      
      private b() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ao.e
 * JD-Core Version:    0.7.0.1
 */