package com.tencent.mm.ai;

import android.os.Looper;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.acr;
import com.tencent.mm.protocal.c.bih;
import com.tencent.mm.protocal.c.bqf;
import com.tencent.mm.protocal.c.fz;
import com.tencent.mm.protocal.c.iw;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bk;

public final class c
  extends i<b>
  implements com.tencent.mm.ah.f
{
  public static final String[] dXp = { i.a(b.buS, "BizEnterprise") };
  public static fz eeI;
  private e dXw;
  private final k<c.a, a.a> eeJ = new c.1(this);
  
  public c(e parame)
  {
    super(parame, b.buS, "BizEnterprise", null);
    this.dXw = parame;
    parame.gk("BizEnterprise", "CREATE INDEX IF NOT EXISTS BizEnterpriseUserNameIndex ON BizEnterprise ( userName )");
    g.DO().dJT.a(1343, this);
    g.DO().dJT.a(1228, this);
  }
  
  public static y a(String paramString, boolean paramBoolean, com.tencent.mm.ah.f paramf)
  {
    iw localiw = new iw();
    localiw.sCO = paramString;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localiw.sDa = i;
      localiw.sCY = 0;
      paramString = new y(localiw, paramf);
      if (!g.DO().dJT.a(paramString, 0)) {
        break;
      }
      return paramString;
    }
    return null;
  }
  
  public static void a(y paramy)
  {
    g.DO().dJT.c(paramy);
    paramy.data = null;
  }
  
  private boolean a(b paramb)
  {
    boolean bool2;
    if (paramb == null) {
      bool2 = false;
    }
    a.b localb;
    boolean bool1;
    do
    {
      return bool2;
      bool2 = super.b(paramb);
      localb = a.b.eeO;
      bool1 = bool2;
      if (!bool2)
      {
        bool1 = super.a(paramb);
        localb = a.b.eeQ;
      }
      bool2 = bool1;
    } while (!bool1);
    a.a locala = new a.a();
    locala.eeM = paramb.field_userName;
    locala.eeL = localb;
    locala.eeN = paramb;
    this.eeJ.bV(locala);
    this.eeJ.doNotify();
    return bool1;
  }
  
  private boolean a(iw paramiw)
  {
    b localb = kE(paramiw.sCO);
    localb.field_userName = paramiw.sCO;
    localb.field_qyUin = paramiw.sCY;
    localb.field_userUin = paramiw.sCZ;
    localb.field_wwMaxExposeTimes = paramiw.sDb;
    localb.field_wwUserVid = paramiw.sDc;
    localb.field_wwCorpId = paramiw.sDd;
    localb.field_userType = paramiw.sDe;
    localb.field_chatOpen = paramiw.sDf;
    localb.field_wwUnreadCnt = paramiw.sDg;
    localb.field_show_confirm = paramiw.sDh;
    localb.field_use_preset_banner_tips = paramiw.sDj;
    eeI = paramiw.sDi;
    if ((paramiw.sDc == 0L) && (paramiw.sDd == 0L) && (paramiw.sCY != 0))
    {
      localb.field_wwUserVid = paramiw.sCZ;
      localb.field_wwCorpId = paramiw.sCY;
    }
    paramiw.sDa &= 0xFFFFFFF7;
    localb.field_userFlag = (paramiw.sDa | localb.field_userFlag & 0x8);
    return a(localb);
  }
  
  public static boolean a(String paramString, com.tencent.mm.ah.f paramf)
  {
    if (bk.bl(paramString)) {
      return false;
    }
    if (f.lc(paramString)) {}
    for (int i = 1;; i = 2)
    {
      paramString = new s(paramString, i, paramf);
      return g.DO().dJT.a(paramString, 0);
      if (!f.lb(paramString)) {
        break;
      }
    }
    return false;
  }
  
  public static String ik(int paramInt)
  {
    if (eeI == null) {
      eeI = new fz();
    }
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return eeI.szZ;
    case 1: 
      return eeI.sAa;
    }
    return eeI.sAb;
  }
  
  public final void a(c.a parama)
  {
    if (this.eeJ != null) {
      this.eeJ.remove(parama);
    }
  }
  
  public final void a(c.a parama, Looper paramLooper)
  {
    this.eeJ.a(parama, paramLooper);
  }
  
  public final boolean jJ(String paramString)
  {
    boolean bool1 = false;
    if (bk.bl(paramString)) {}
    b localb;
    boolean bool2;
    do
    {
      return bool1;
      localb = new b();
      localb.field_userName = paramString;
      bool2 = super.a(localb, new String[] { "userName" });
      bool1 = bool2;
    } while (!bool2);
    a.a locala = new a.a();
    locala.eeM = paramString;
    locala.eeL = a.b.eeP;
    locala.eeN = localb;
    this.eeJ.bV(locala);
    this.eeJ.doNotify();
    return bool2;
  }
  
  public final b kD(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    b localb = new b();
    localb.field_userName = paramString;
    if (super.b(localb, new String[0])) {
      return localb;
    }
    a(paramString, null);
    return null;
  }
  
  public final b kE(String paramString)
  {
    b localb2 = kD(paramString);
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b();
      localb1.field_userName = paramString;
      localb1.field_qyUin = 0;
      localb1.field_userUin = 0;
      localb1.field_userFlag = 0;
      localb1.field_wwExposeTimes = 0;
      localb1.field_wwMaxExposeTimes = 0;
      localb1.field_wwUserVid = 0L;
      localb1.field_wwCorpId = 0L;
      localb1.field_chatOpen = false;
      localb1.field_wwUnreadCnt = 0;
    }
    return localb1;
  }
  
  public final int kF(String paramString)
  {
    paramString = kD(paramString);
    if (paramString == null) {
      return 0;
    }
    return paramString.field_qyUin;
  }
  
  public final void kG(String paramString)
  {
    paramString = kE(paramString);
    if (paramString.field_wwExposeTimes >= paramString.field_wwMaxExposeTimes) {
      return;
    }
    paramString.field_wwExposeTimes += 1;
    a(paramString);
  }
  
  public final boolean kH(String paramString)
  {
    paramString = kD(paramString);
    return (paramString != null) && ((paramString.field_userFlag & 0x1) != 0);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int j = -1;
    if ((paramInt1 != 0) || (paramInt2 != 0)) {}
    int i;
    Object localObject1;
    label68:
    do
    {
      return;
      i = paramInt2;
      if ((paramm instanceof s))
      {
        localObject2 = (s)paramm;
        if ((((s)localObject2).dmK == null) || (((s)localObject2).dmK.ecF.ecN == null)) {
          break;
        }
        localObject1 = (acr)((s)localObject2).dmK.ecF.ecN;
        if ((localObject1 == null) || (((acr)localObject1).sCU == null) || (((acr)localObject1).sCU.ret != 0) || (((acr)localObject1).tbu == null)) {
          break label279;
        }
        if (!a(((acr)localObject1).tbu)) {
          paramInt2 = -1;
        }
        localObject1 = (com.tencent.mm.ah.f)((s)localObject2).data;
        i = paramInt2;
        if (localObject1 != null)
        {
          ((com.tencent.mm.ah.f)localObject1).onSceneEnd(paramInt1, paramInt2, paramString, paramm);
          i = paramInt2;
        }
      }
    } while (!(paramm instanceof y));
    Object localObject2 = (y)paramm;
    if ((((y)localObject2).dmK != null) && (((y)localObject2).dmK.ecF.ecN != null))
    {
      localObject1 = (bqf)((y)localObject2).dmK.ecF.ecN;
      label200:
      if ((localObject1 == null) || (((bqf)localObject1).sCU == null) || (((bqf)localObject1).sCU.ret != 0) || (((bqf)localObject1).tbu == null)) {
        break label285;
      }
      if (a(((bqf)localObject1).tbu)) {
        break label287;
      }
    }
    label279:
    label285:
    label287:
    for (paramInt2 = j;; paramInt2 = i)
    {
      localObject1 = (com.tencent.mm.ah.f)((y)localObject2).data;
      if (localObject1 == null) {
        break;
      }
      ((com.tencent.mm.ah.f)localObject1).onSceneEnd(paramInt1, paramInt2, paramString, paramm);
      return;
      localObject1 = null;
      break label68;
      break;
      localObject1 = null;
      break label200;
      break;
    }
  }
  
  public static final class a$a
  {
    public c.a.b eeL;
    public String eeM;
    public b eeN;
  }
  
  public static enum a$b
  {
    private a$b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ai.c
 * JD-Core Version:    0.7.0.1
 */