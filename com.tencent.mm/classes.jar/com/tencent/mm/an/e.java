package com.tencent.mm.an;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.protocal.protobuf.cfs;
import com.tencent.mm.protocal.protobuf.elf;
import com.tencent.mm.protocal.protobuf.ezs;
import com.tencent.mm.protocal.protobuf.jt;
import com.tencent.mm.protocal.protobuf.pc;
import com.tencent.mm.protocal.protobuf.pd;
import com.tencent.mm.protocal.protobuf.zb;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEvent;

public final class e
  extends MAutoStorage<d>
  implements com.tencent.mm.am.h
{
  public static final String[] SQL_CREATE;
  public static jt ovP;
  private ISQLiteDatabase db;
  private final MStorageEvent<a, e.a.a> ovQ;
  
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
    this.ovQ = new MStorageEvent() {};
    this.db = paramISQLiteDatabase;
    paramISQLiteDatabase.execSQL("BizEnterprise", "CREATE INDEX IF NOT EXISTS BizEnterpriseUserNameIndex ON BizEnterprise ( userName )");
    y.a(this);
    ae.a(this);
    AppMethodBeat.o(123989);
  }
  
  public static ae a(String paramString, boolean paramBoolean, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(123999);
    pc localpc = new pc();
    localpc.YRQ = paramString;
    if (paramBoolean) {}
    for (int i = 17;; i = 0)
    {
      localpc.user_flag = i;
      localpc.YSl = 0;
      paramString = new ae(localpc, paramh);
      if (!com.tencent.mm.kernel.h.baD().mCm.a(paramString, 0)) {
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
    com.tencent.mm.kernel.h.baD().mCm.a(paramae);
    paramae.cpt = null;
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
    e.a.b localb = e.a.b.ovV;
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = super.replace(paramd);
      localb = e.a.b.ovX;
    }
    if (bool1)
    {
      e.a.a locala = new e.a.a();
      locala.ovT = paramd.field_userName;
      locala.ovS = localb;
      locala.ovU = paramd;
      this.ovQ.event(locala);
      this.ovQ.doNotify();
    }
    AppMethodBeat.o(123996);
    return bool1;
  }
  
  private boolean a(pc parampc)
  {
    AppMethodBeat.i(123997);
    d locald = Mj(parampc.YRQ);
    locald.field_userName = parampc.YRQ;
    locald.field_qyUin = parampc.YSl;
    locald.field_userUin = parampc.YSm;
    locald.field_wwMaxExposeTimes = parampc.YSn;
    locald.field_wwUserVid = parampc.YSo;
    locald.field_wwCorpId = parampc.YSp;
    locald.field_userType = parampc.YSa;
    locald.field_chatOpen = parampc.YSq;
    locald.field_wwUnreadCnt = parampc.YSr;
    locald.field_show_confirm = parampc.YSs;
    locald.field_use_preset_banner_tips = parampc.YSu;
    if (parampc.YSv != null)
    {
      locald.field_hide_create_chat = parampc.YSv.ZhG;
      locald.field_hide_mod_chat_member = parampc.YSv.ZhH;
    }
    locald.field_hide_colleage_invite = parampc.YSx;
    try
    {
      pd localpd = new pd();
      localpd.YSw = parampc.YSw;
      localpd.YSy = parampc.YSy;
      localpd.YSz = parampc.YSz;
      localpd.YSA = parampc.YSA;
      locald.field_raw_attrs = localpd.toByteArray();
      label193:
      ovP = parampc.YSt;
      if ((parampc.YSo == 0L) && (parampc.YSp == 0L) && (parampc.YSl != 0))
      {
        locald.field_wwUserVid = parampc.YSm;
        locald.field_wwCorpId = parampc.YSl;
      }
      parampc.user_flag &= 0xFFFFFFF7;
      locald.field_userFlag = (parampc.user_flag | locald.field_userFlag & 0x8);
      boolean bool = a(locald);
      AppMethodBeat.o(123997);
      return bool;
    }
    finally
    {
      break label193;
    }
  }
  
  public static boolean a(String paramString, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(123998);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(123998);
      return false;
    }
    if (g.MB(paramString)) {}
    for (int i = 1;; i = 2)
    {
      paramString = new y(paramString, i, paramh);
      boolean bool = com.tencent.mm.kernel.h.baD().mCm.a(paramString, 0);
      AppMethodBeat.o(123998);
      return bool;
      if (!g.MA(paramString)) {
        break;
      }
    }
    AppMethodBeat.o(123998);
    return false;
  }
  
  public static String bGA()
  {
    AppMethodBeat.i(179034);
    if (ovP == null) {
      ovP = new jt();
    }
    String str = ovP.jump_url;
    AppMethodBeat.o(179034);
    return str;
  }
  
  public static String bGB()
  {
    AppMethodBeat.i(179035);
    if (ovP == null) {
      ovP = new jt();
    }
    String str = ovP.icon_url;
    AppMethodBeat.o(179035);
    return str;
  }
  
  public static int bGC()
  {
    AppMethodBeat.i(179036);
    if (ovP == null) {
      ovP = new jt();
    }
    int i = 0;
    try
    {
      int j = Integer.parseInt(ovP.YMd);
      i = j;
    }
    finally
    {
      label36:
      break label36;
    }
    AppMethodBeat.o(179036);
    return i;
  }
  
  public static String vO(int paramInt)
  {
    AppMethodBeat.i(124003);
    String str = null;
    if (ovP == null) {
      ovP = new jt();
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(124003);
      return str;
      str = ovP.YLZ;
      continue;
      str = ovP.YMa;
      continue;
      str = ovP.YMb;
    }
  }
  
  public final d Mi(String paramString)
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
  
  public final d Mj(String paramString)
  {
    AppMethodBeat.i(123993);
    d locald = Mi(paramString);
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
  
  public final int Mk(String paramString)
  {
    AppMethodBeat.i(123994);
    paramString = Mi(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(123994);
      return 0;
    }
    int i = paramString.field_qyUin;
    AppMethodBeat.o(123994);
    return i;
  }
  
  public final void Ml(String paramString)
  {
    AppMethodBeat.i(124000);
    paramString = Mj(paramString);
    if (paramString.field_wwExposeTimes >= paramString.field_wwMaxExposeTimes)
    {
      AppMethodBeat.o(124000);
      return;
    }
    paramString.field_wwExposeTimes += 1;
    a(paramString);
    AppMethodBeat.o(124000);
  }
  
  public final boolean Mm(String paramString)
  {
    AppMethodBeat.i(124002);
    paramString = Mi(paramString);
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
    if (this.ovQ != null) {
      this.ovQ.remove(parama);
    }
    AppMethodBeat.o(123991);
  }
  
  public final void a(a parama, Looper paramLooper)
  {
    AppMethodBeat.i(123990);
    this.ovQ.add(parama, paramLooper);
    AppMethodBeat.o(123990);
  }
  
  public final boolean iP(String paramString)
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
      locala.ovT = paramString;
      locala.ovS = e.a.b.ovW;
      locala.ovU = locald;
      this.ovQ.event(locala);
      this.ovQ.doNotify();
    }
    AppMethodBeat.o(123995);
    return bool;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
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
    if ((paramp instanceof y))
    {
      localObject2 = (y)paramp;
      if ((((y)localObject2).rr != null) && (c.c.b(((y)localObject2).rr.otC) != null)) {}
      for (localObject1 = (cfs)c.c.b(((y)localObject2).rr.otC); (localObject1 == null) || (((cfs)localObject1).YRW == null) || (((cfs)localObject1).YRW.ret != 0) || (((cfs)localObject1).aapi == null); localObject1 = null)
      {
        AppMethodBeat.o(124004);
        return;
      }
      if (!a(((cfs)localObject1).aapi)) {
        paramInt2 = -1;
      }
      localObject1 = (com.tencent.mm.am.h)((y)localObject2).cpt;
      i = paramInt2;
      if (localObject1 != null)
      {
        ((com.tencent.mm.am.h)localObject1).onSceneEnd(paramInt1, paramInt2, paramString, paramp);
        i = paramInt2;
      }
    }
    if ((paramp instanceof ae))
    {
      localObject2 = (ae)paramp;
      if ((((ae)localObject2).rr != null) && (c.c.b(((ae)localObject2).rr.otC) != null)) {}
      for (localObject1 = (ezs)c.c.b(((ae)localObject2).rr.otC); (localObject1 == null) || (((ezs)localObject1).YRW == null) || (((ezs)localObject1).YRW.ret != 0) || (((ezs)localObject1).aapi == null); localObject1 = null)
      {
        AppMethodBeat.o(124004);
        return;
      }
      if (a(((ezs)localObject1).aapi)) {
        break label319;
      }
    }
    label319:
    for (paramInt2 = j;; paramInt2 = i)
    {
      localObject1 = (com.tencent.mm.am.h)((ae)localObject2).cpt;
      if (localObject1 != null) {
        ((com.tencent.mm.am.h)localObject1).onSceneEnd(paramInt1, paramInt2, paramString, paramp);
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
      public e.a.b ovS;
      public String ovT;
      public d ovU;
    }
    
    public static enum b
    {
      static
      {
        AppMethodBeat.i(123988);
        ovV = new b("INSERT", 0);
        ovW = new b("DELETE", 1);
        ovX = new b("UPDATE", 2);
        ovY = new b[] { ovV, ovW, ovX };
        AppMethodBeat.o(123988);
      }
      
      private b() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.an.e
 * JD-Core Version:    0.7.0.1
 */