package com.tencent.mm.aj;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.ahj;
import com.tencent.mm.protocal.protobuf.bqx;
import com.tencent.mm.protocal.protobuf.can;
import com.tencent.mm.protocal.protobuf.hk;
import com.tencent.mm.protocal.protobuf.ky;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bo;

public final class c
  extends j<b>
  implements com.tencent.mm.ai.f
{
  public static final String[] SQL_CREATE;
  public static hk fuK;
  private e db;
  private final l<c.a, c.a.a> fuL;
  
  static
  {
    AppMethodBeat.i(11270);
    SQL_CREATE = new String[] { j.getCreateSQLs(b.info, "BizEnterprise") };
    AppMethodBeat.o(11270);
  }
  
  public c(e parame)
  {
    super(parame, b.info, "BizEnterprise", null);
    AppMethodBeat.i(11254);
    this.fuL = new c.1(this);
    this.db = parame;
    parame.execSQL("BizEnterprise", "CREATE INDEX IF NOT EXISTS BizEnterpriseUserNameIndex ON BizEnterprise ( userName )");
    g.RK().eHt.a(1343, this);
    g.RK().eHt.a(1228, this);
    AppMethodBeat.o(11254);
  }
  
  public static y a(String paramString, boolean paramBoolean, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(11264);
    ky localky = new ky();
    localky.wyh = paramString;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localky.wyC = i;
      localky.wyA = 0;
      paramString = new y(localky, paramf);
      if (!g.RK().eHt.a(paramString, 0)) {
        break;
      }
      AppMethodBeat.o(11264);
      return paramString;
    }
    AppMethodBeat.o(11264);
    return null;
  }
  
  public static void a(y paramy)
  {
    AppMethodBeat.i(11266);
    g.RK().eHt.a(paramy);
    paramy.data = null;
    AppMethodBeat.o(11266);
  }
  
  private boolean a(b paramb)
  {
    AppMethodBeat.i(11261);
    if (paramb == null)
    {
      AppMethodBeat.o(11261);
      return false;
    }
    boolean bool2 = super.insert(paramb);
    c.a.b localb = c.a.b.fuQ;
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = super.replace(paramb);
      localb = c.a.b.fuS;
    }
    if (bool1)
    {
      c.a.a locala = new c.a.a();
      locala.fuO = paramb.field_userName;
      locala.fuN = localb;
      locala.fuP = paramb;
      this.fuL.cy(locala);
      this.fuL.doNotify();
    }
    AppMethodBeat.o(11261);
    return bool1;
  }
  
  private boolean a(ky paramky)
  {
    AppMethodBeat.i(11262);
    b localb = ry(paramky.wyh);
    localb.field_userName = paramky.wyh;
    localb.field_qyUin = paramky.wyA;
    localb.field_userUin = paramky.wyB;
    localb.field_wwMaxExposeTimes = paramky.wyD;
    localb.field_wwUserVid = paramky.wyE;
    localb.field_wwCorpId = paramky.wyF;
    localb.field_userType = paramky.wyG;
    localb.field_chatOpen = paramky.wyH;
    localb.field_wwUnreadCnt = paramky.wyI;
    localb.field_show_confirm = paramky.wyJ;
    localb.field_use_preset_banner_tips = paramky.wyL;
    fuK = paramky.wyK;
    if ((paramky.wyE == 0L) && (paramky.wyF == 0L) && (paramky.wyA != 0))
    {
      localb.field_wwUserVid = paramky.wyB;
      localb.field_wwCorpId = paramky.wyA;
    }
    paramky.wyC &= 0xFFFFFFF7;
    localb.field_userFlag = (paramky.wyC | localb.field_userFlag & 0x8);
    boolean bool = a(localb);
    AppMethodBeat.o(11262);
    return bool;
  }
  
  public static boolean a(String paramString, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(11263);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(11263);
      return false;
    }
    if (f.rX(paramString)) {}
    for (int i = 1;; i = 2)
    {
      paramString = new s(paramString, i, paramf);
      boolean bool = g.RK().eHt.a(paramString, 0);
      AppMethodBeat.o(11263);
      return bool;
      if (!f.rW(paramString)) {
        break;
      }
    }
    AppMethodBeat.o(11263);
    return false;
  }
  
  public static String kX(int paramInt)
  {
    AppMethodBeat.i(11268);
    String str = null;
    if (fuK == null) {
      fuK = new hk();
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(11268);
      return str;
      str = fuK.wud;
      continue;
      str = fuK.wue;
      continue;
      str = fuK.wuf;
    }
  }
  
  public final void a(c.a parama)
  {
    AppMethodBeat.i(11256);
    if (this.fuL != null) {
      this.fuL.remove(parama);
    }
    AppMethodBeat.o(11256);
  }
  
  public final void a(c.a parama, Looper paramLooper)
  {
    AppMethodBeat.i(11255);
    this.fuL.a(parama, paramLooper);
    AppMethodBeat.o(11255);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int j = -1;
    AppMethodBeat.i(11269);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(11269);
      return;
    }
    int i = paramInt2;
    Object localObject2;
    Object localObject1;
    if ((paramm instanceof s))
    {
      localObject2 = (s)paramm;
      if ((((s)localObject2).rr != null) && (((s)localObject2).rr.fsW.fta != null)) {}
      for (localObject1 = (ahj)((s)localObject2).rr.fsW.fta; (localObject1 == null) || (((ahj)localObject1).wyn == null) || (((ahj)localObject1).wyn.ret != 0) || (((ahj)localObject1).wZL == null); localObject1 = null)
      {
        AppMethodBeat.o(11269);
        return;
      }
      if (!a(((ahj)localObject1).wZL)) {
        paramInt2 = -1;
      }
      localObject1 = (com.tencent.mm.ai.f)((s)localObject2).data;
      i = paramInt2;
      if (localObject1 != null)
      {
        ((com.tencent.mm.ai.f)localObject1).onSceneEnd(paramInt1, paramInt2, paramString, paramm);
        i = paramInt2;
      }
    }
    if ((paramm instanceof y))
    {
      localObject2 = (y)paramm;
      if ((((y)localObject2).rr != null) && (((y)localObject2).rr.fsW.fta != null)) {}
      for (localObject1 = (can)((y)localObject2).rr.fsW.fta; (localObject1 == null) || (((can)localObject1).wyn == null) || (((can)localObject1).wyn.ret != 0) || (((can)localObject1).wZL == null); localObject1 = null)
      {
        AppMethodBeat.o(11269);
        return;
      }
      if (a(((can)localObject1).wZL)) {
        break label319;
      }
    }
    label319:
    for (paramInt2 = j;; paramInt2 = i)
    {
      localObject1 = (com.tencent.mm.ai.f)((y)localObject2).data;
      if (localObject1 != null) {
        ((com.tencent.mm.ai.f)localObject1).onSceneEnd(paramInt1, paramInt2, paramString, paramm);
      }
      AppMethodBeat.o(11269);
      return;
    }
  }
  
  public final boolean qD(String paramString)
  {
    AppMethodBeat.i(11260);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(11260);
      return false;
    }
    b localb = new b();
    localb.field_userName = paramString;
    boolean bool = super.delete(localb, new String[] { "userName" });
    if (bool)
    {
      c.a.a locala = new c.a.a();
      locala.fuO = paramString;
      locala.fuN = c.a.b.fuR;
      locala.fuP = localb;
      this.fuL.cy(locala);
      this.fuL.doNotify();
    }
    AppMethodBeat.o(11260);
    return bool;
  }
  
  public final void rA(String paramString)
  {
    AppMethodBeat.i(11265);
    paramString = ry(paramString);
    if (paramString.field_wwExposeTimes >= paramString.field_wwMaxExposeTimes)
    {
      AppMethodBeat.o(11265);
      return;
    }
    paramString.field_wwExposeTimes += 1;
    a(paramString);
    AppMethodBeat.o(11265);
  }
  
  public final boolean rB(String paramString)
  {
    AppMethodBeat.i(11267);
    paramString = rx(paramString);
    if ((paramString != null) && ((paramString.field_userFlag & 0x1) != 0))
    {
      AppMethodBeat.o(11267);
      return true;
    }
    AppMethodBeat.o(11267);
    return false;
  }
  
  public final b rx(String paramString)
  {
    AppMethodBeat.i(11257);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(11257);
      return null;
    }
    b localb = new b();
    localb.field_userName = paramString;
    if (super.get(localb, new String[0]))
    {
      AppMethodBeat.o(11257);
      return localb;
    }
    a(paramString, null);
    AppMethodBeat.o(11257);
    return null;
  }
  
  public final b ry(String paramString)
  {
    AppMethodBeat.i(11258);
    b localb = rx(paramString);
    if (localb == null)
    {
      localb = new b();
      localb.field_userName = paramString;
      localb.field_qyUin = 0;
      localb.field_userUin = 0;
      localb.field_userFlag = 0;
      localb.field_wwExposeTimes = 0;
      localb.field_wwMaxExposeTimes = 0;
      localb.field_wwUserVid = 0L;
      localb.field_wwCorpId = 0L;
      localb.field_chatOpen = false;
      localb.field_wwUnreadCnt = 0;
      AppMethodBeat.o(11258);
      return localb;
    }
    AppMethodBeat.o(11258);
    return localb;
  }
  
  public final int rz(String paramString)
  {
    AppMethodBeat.i(11259);
    paramString = rx(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(11259);
      return 0;
    }
    int i = paramString.field_qyUin;
    AppMethodBeat.o(11259);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aj.c
 * JD-Core Version:    0.7.0.1
 */