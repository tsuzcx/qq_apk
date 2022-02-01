package com.tencent.mm.contact;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.b.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.storage.at;

public class d
  extends az
{
  public static IAutoDBItem.MAutoDBInfo info;
  private static a maO;
  public long maN;
  public int versionCode;
  
  static
  {
    AppMethodBeat.i(42758);
    info = az.aJm();
    maO = null;
    AppMethodBeat.o(42758);
  }
  
  public d()
  {
    AppMethodBeat.i(42667);
    this.versionCode = 0;
    super.setUsername("");
    super.setNickname("");
    super.AY("");
    super.AZ("");
    super.AV("");
    super.AW("");
    super.Bc("");
    super.Bb("");
    super.AX("");
    super.pq(0);
    super.Ba("");
    super.pp(0);
    super.setType(0);
    super.pr(0);
    super.ps(0);
    super.Be("");
    super.pv(0);
    super.Br("");
    super.setFromType(0);
    super.setUin(0);
    super.Bk("");
    super.Bl("");
    super.pw(0);
    super.py(0);
    super.Bm("");
    super.Bn("");
    super.pz(1);
    super.pu(0);
    super.pA(0);
    super.Bo("");
    super.Bp("");
    super.Bq("");
    super.setSource(0);
    super.Bt("");
    super.Bs("");
    super.gO(0L);
    super.Bj("");
    super.Bu("");
    super.pB(0);
    super.Bx("");
    super.By("");
    super.Bz("");
    super.BC("");
    super.Bf("");
    super.Bg("");
    super.gN(0L);
    super.Bd("");
    super.pD(0);
    this.versionCode = 0;
    AppMethodBeat.o(42667);
  }
  
  public d(String paramString)
  {
    this();
    AppMethodBeat.i(42666);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    setUsername(str);
    AppMethodBeat.o(42666);
  }
  
  public static String DW(String paramString)
  {
    AppMethodBeat.i(42668);
    if (maO != null)
    {
      paramString = maO.iF(paramString);
      AppMethodBeat.o(42668);
      return paramString;
    }
    AppMethodBeat.o(42668);
    return null;
  }
  
  private static String DX(String paramString)
  {
    AppMethodBeat.i(42701);
    if (paramString == null)
    {
      AppMethodBeat.o(42701);
      return null;
    }
    if (paramString.toLowerCase().endsWith("@t.qq.com"))
    {
      paramString = "@" + paramString.replace("@t.qq.com", "");
      AppMethodBeat.o(42701);
      return paramString;
    }
    if (paramString.toLowerCase().endsWith("@qqim"))
    {
      paramString = paramString.replace("@qqim", "");
      long l = Long.valueOf(paramString).longValue();
      if (l < 0L)
      {
        paramString = new p(l).toString();
        AppMethodBeat.o(42701);
        return paramString;
      }
      AppMethodBeat.o(42701);
      return paramString;
    }
    if (paramString.toLowerCase().endsWith("@stranger"))
    {
      AppMethodBeat.o(42701);
      return " ";
    }
    AppMethodBeat.o(42701);
    return paramString;
  }
  
  public static void a(a parama)
  {
    maO = parama;
  }
  
  public static int aSA()
  {
    return 32;
  }
  
  public static int aSB()
  {
    return 1073741824;
  }
  
  public static int aSC()
  {
    return 536870912;
  }
  
  private int aSY()
  {
    int i = this.versionCode + 1;
    this.versionCode = i;
    return i;
  }
  
  public static int aSp()
  {
    return 1;
  }
  
  public static int aSq()
  {
    return 8;
  }
  
  public static int aSr()
  {
    return 524288;
  }
  
  public static int aSs()
  {
    return 131072;
  }
  
  public static int aSt()
  {
    return 262144;
  }
  
  public static int aSu()
  {
    return 8388608;
  }
  
  public static int aSv()
  {
    return 256;
  }
  
  public static int aSw()
  {
    return 1048576;
  }
  
  public static int aSx()
  {
    return 33554432;
  }
  
  public static int aSy()
  {
    return 134217728;
  }
  
  public static int aSz()
  {
    return 16;
  }
  
  public static boolean rs(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  private static boolean u(char paramChar)
  {
    return ((paramChar >= 'A') && (paramChar <= 'Z')) || ((paramChar >= 'a') && (paramChar <= 'z'));
  }
  
  public final void AV(String paramString)
  {
    AppMethodBeat.i(42705);
    if (!Util.isEqual(aJs(), paramString))
    {
      super.AV(paramString);
      aSY();
    }
    AppMethodBeat.o(42705);
  }
  
  public final void AW(String paramString)
  {
    AppMethodBeat.i(42706);
    if (!Util.isEqual(this.field_conRemark, paramString))
    {
      super.AW(paramString);
      aSY();
    }
    AppMethodBeat.o(42706);
  }
  
  public final void AX(String paramString)
  {
    AppMethodBeat.i(42707);
    if (!Util.isEqual(this.field_domainList, paramString))
    {
      super.AX(paramString);
      aSY();
    }
    AppMethodBeat.o(42707);
  }
  
  public final void AY(String paramString)
  {
    AppMethodBeat.i(42709);
    if (!Util.isEqual(aJt(), paramString))
    {
      super.AY(paramString);
      aSY();
    }
    AppMethodBeat.o(42709);
  }
  
  public final void AZ(String paramString)
  {
    AppMethodBeat.i(42710);
    if (!Util.isEqual(aJu(), paramString))
    {
      super.AZ(paramString);
      aSY();
    }
    AppMethodBeat.o(42710);
  }
  
  public final void BA(String paramString)
  {
    AppMethodBeat.i(42752);
    if (!Util.isEqual(this.kaq, paramString))
    {
      super.BA(paramString);
      aSY();
    }
    AppMethodBeat.o(42752);
  }
  
  public final void BB(String paramString)
  {
    AppMethodBeat.i(42753);
    if (!Util.isEqual(this.kar, paramString))
    {
      super.BB(paramString);
      aSY();
    }
    AppMethodBeat.o(42753);
  }
  
  public final void BC(String paramString)
  {
    AppMethodBeat.i(42754);
    if (!Util.isEqual(this.kas, paramString))
    {
      super.BC(paramString);
      aSY();
    }
    AppMethodBeat.o(42754);
  }
  
  public final void Ba(String paramString)
  {
    AppMethodBeat.i(42714);
    if (!Util.isEqual(this.field_weiboNickname, paramString))
    {
      super.Ba(paramString);
      aSY();
    }
    AppMethodBeat.o(42714);
  }
  
  public final void Bb(String paramString)
  {
    AppMethodBeat.i(42715);
    if (!Util.isEqual(this.field_conRemarkPYFull, paramString))
    {
      super.Bb(paramString);
      aSY();
    }
    AppMethodBeat.o(42715);
  }
  
  public final void Bc(String paramString)
  {
    AppMethodBeat.i(42716);
    if (!Util.isEqual(this.field_conRemarkPYShort, paramString))
    {
      super.Bc(paramString);
      aSY();
    }
    AppMethodBeat.o(42716);
  }
  
  public final void Bd(String paramString)
  {
    AppMethodBeat.i(42719);
    if (!Util.isEqual(this.field_encryptUsername, paramString))
    {
      super.Bd(paramString);
      aSY();
    }
    AppMethodBeat.o(42719);
  }
  
  public final void Be(String paramString)
  {
    AppMethodBeat.i(42722);
    if (!Util.isEqual(this.field_contactLabelIds, paramString))
    {
      super.Be(paramString);
      aSY();
    }
    AppMethodBeat.o(42722);
  }
  
  public final void Bg(String paramString)
  {
    AppMethodBeat.i(42755);
    if (!Util.isEqual(this.field_openImAppid, paramString))
    {
      super.Bg(paramString);
      aSY();
    }
    AppMethodBeat.o(42755);
  }
  
  public final void Bh(String paramString)
  {
    AppMethodBeat.i(42756);
    if (!Util.isEqual(this.field_sourceExtInfo, paramString))
    {
      super.Bh(paramString);
      aSY();
    }
    AppMethodBeat.o(42756);
  }
  
  public final void Bi(String paramString)
  {
    AppMethodBeat.i(42757);
    if (!Util.isEqual(this.field_ticket, paramString))
    {
      super.Bi(paramString);
      aSY();
    }
    AppMethodBeat.o(42757);
  }
  
  public final void Bj(String paramString)
  {
    AppMethodBeat.i(42725);
    if (!Util.isEqual(this.jZZ, paramString))
    {
      super.Bj(paramString);
      aSY();
    }
    AppMethodBeat.o(42725);
  }
  
  public final void Bk(String paramString)
  {
    AppMethodBeat.i(42728);
    if (!Util.isEqual(getEmail(), paramString))
    {
      super.Bk(paramString);
      aSY();
    }
    AppMethodBeat.o(42728);
  }
  
  public final void Bl(String paramString)
  {
    AppMethodBeat.i(42729);
    if (!Util.isEqual(this.hRk, paramString))
    {
      super.Bl(paramString);
      aSY();
    }
    AppMethodBeat.o(42729);
  }
  
  public final void Bm(String paramString)
  {
    AppMethodBeat.i(42732);
    if (!Util.isEqual(aJA(), paramString))
    {
      super.Bm(paramString);
      aSY();
    }
    AppMethodBeat.o(42732);
  }
  
  public final void Bn(String paramString)
  {
    AppMethodBeat.i(42733);
    if (!Util.isEqual(aJB(), paramString))
    {
      super.Bn(paramString);
      aSY();
    }
    AppMethodBeat.o(42733);
  }
  
  public final void Bo(String paramString)
  {
    AppMethodBeat.i(42736);
    if (!Util.isEqual(this.signature, paramString))
    {
      super.Bo(paramString);
      aSY();
    }
    AppMethodBeat.o(42736);
  }
  
  public void Bp(String paramString)
  {
    AppMethodBeat.i(42737);
    if (!Util.isEqual(getProvince(), paramString))
    {
      super.Bp(paramString);
      aSY();
    }
    AppMethodBeat.o(42737);
  }
  
  public void Bq(String paramString)
  {
    AppMethodBeat.i(42738);
    if (!Util.isEqual(getCity(), paramString))
    {
      super.Bq(paramString);
      aSY();
    }
    AppMethodBeat.o(42738);
  }
  
  public final void Br(String paramString)
  {
    AppMethodBeat.i(42739);
    if (!Util.isEqual(this.kah, paramString))
    {
      super.Br(paramString);
      aSY();
    }
    AppMethodBeat.o(42739);
  }
  
  public final void Bs(String paramString)
  {
    AppMethodBeat.i(42742);
    if (!Util.isEqual(this.kai, paramString))
    {
      super.Bs(paramString);
      aSY();
    }
    AppMethodBeat.o(42742);
  }
  
  public final void Bt(String paramString)
  {
    AppMethodBeat.i(42743);
    if (!Util.isEqual(this.verifyInfo, paramString))
    {
      super.Bt(paramString);
      aSY();
    }
    AppMethodBeat.o(42743);
  }
  
  public void Bu(String paramString)
  {
    AppMethodBeat.i(42744);
    if (!Util.isEqual(this.kaj, paramString))
    {
      super.Bu(paramString);
      aSY();
    }
    AppMethodBeat.o(42744);
  }
  
  public final void Bv(String paramString)
  {
    AppMethodBeat.i(42747);
    if (!Util.isEqual(this.kal, paramString))
    {
      super.Bv(paramString);
      aSY();
    }
    AppMethodBeat.o(42747);
  }
  
  public final void Bw(String paramString)
  {
    AppMethodBeat.i(42748);
    if (!Util.isEqual(this.kam, paramString))
    {
      super.Bw(paramString);
      aSY();
    }
    AppMethodBeat.o(42748);
  }
  
  public final void Bx(String paramString)
  {
    AppMethodBeat.i(42749);
    if (!Util.isEqual(this.kan, paramString))
    {
      super.Bx(paramString);
      aSY();
    }
    AppMethodBeat.o(42749);
  }
  
  public final void By(String paramString)
  {
    AppMethodBeat.i(42750);
    if (!Util.isEqual(this.kao, paramString))
    {
      super.By(paramString);
      aSY();
    }
    AppMethodBeat.o(42750);
  }
  
  public final void Bz(String paramString)
  {
    AppMethodBeat.i(42751);
    if (!Util.isEqual(this.kap, paramString))
    {
      super.Bz(paramString);
      aSY();
    }
    AppMethodBeat.o(42751);
  }
  
  public final boolean aGe()
  {
    return (this.field_type & 0x200) != 0;
  }
  
  public final String aJs()
  {
    AppMethodBeat.i(42695);
    if (maO != null) {}
    for (String str = maO.iG(this.field_username); str == null; str = null)
    {
      str = super.aJs();
      AppMethodBeat.o(42695);
      return str;
    }
    AppMethodBeat.o(42695);
    return str;
  }
  
  public final String aJt()
  {
    AppMethodBeat.i(42693);
    if ((super.aJt() == null) || (super.aJt().length() < 0))
    {
      str = aJu();
      AppMethodBeat.o(42693);
      return str;
    }
    String str = super.aJt();
    AppMethodBeat.o(42693);
    return str;
  }
  
  public final String aJu()
  {
    AppMethodBeat.i(42694);
    if ((super.aJu() == null) || (super.aJu().length() < 0))
    {
      str = this.field_nickname;
      AppMethodBeat.o(42694);
      return str;
    }
    String str = super.aJu();
    AppMethodBeat.o(42694);
    return str;
  }
  
  public final boolean aMW()
  {
    return (this.field_type & 0x400) == 0;
  }
  
  public final boolean aMt()
  {
    return (0x10000000 & this.field_type) != 0;
  }
  
  public final int aRH()
  {
    AppMethodBeat.i(42669);
    int j = 32;
    int i;
    if ((this.field_conRemarkPYShort != null) && (!this.field_conRemarkPYShort.equals("")))
    {
      i = this.field_conRemarkPYShort.charAt(0);
      if ((i < 97) || (i > 122)) {
        break label252;
      }
      j = (char)(i - 32);
    }
    for (;;)
    {
      AppMethodBeat.o(42669);
      return j;
      if ((this.field_conRemarkPYFull != null) && (!this.field_conRemarkPYFull.equals("")))
      {
        i = this.field_conRemarkPYFull.charAt(0);
        break;
      }
      if ((super.aJt() != null) && (!super.aJt().equals("")))
      {
        i = super.aJt().charAt(0);
        break;
      }
      if ((super.aJu() != null) && (!super.aJu().equals("")))
      {
        i = super.aJu().charAt(0);
        break;
      }
      if ((this.field_nickname != null) && (!this.field_nickname.equals("")) && (u(this.field_nickname.charAt(0))))
      {
        i = this.field_nickname.charAt(0);
        break;
      }
      i = j;
      if (this.field_username == null) {
        break;
      }
      i = j;
      if (this.field_username.equals("")) {
        break;
      }
      i = j;
      if (!u(this.field_username.charAt(0))) {
        break;
      }
      i = this.field_username.charAt(0);
      break;
      label252:
      if (i >= 65)
      {
        j = i;
        if (i <= 90) {}
      }
      else
      {
        j = 123;
      }
    }
  }
  
  public final void aRI()
  {
    AppMethodBeat.i(42670);
    setType(0);
    AppMethodBeat.o(42670);
  }
  
  public final void aRJ()
  {
    AppMethodBeat.i(42671);
    setType(this.field_type | 0x4);
    AppMethodBeat.o(42671);
  }
  
  public final void aRK()
  {
    AppMethodBeat.i(42672);
    setType(this.field_type | 0x1);
    AppMethodBeat.o(42672);
  }
  
  public final void aRL()
  {
    AppMethodBeat.i(42673);
    Log.w("MicroMsg.RContact", "unSetContact!! user:%s oldType:%d [%s]", new Object[] { this.field_username, Integer.valueOf(this.field_type), Util.getStack() });
    setType(this.field_type & 0xFFFFFFFE);
    AppMethodBeat.o(42673);
  }
  
  public final void aRM()
  {
    AppMethodBeat.i(42674);
    setType(this.field_type | 0x8);
    AppMethodBeat.o(42674);
  }
  
  public final void aRN()
  {
    AppMethodBeat.i(42675);
    setType(this.field_type & 0xFFFFFFF7);
    AppMethodBeat.o(42675);
  }
  
  public final void aRO()
  {
    AppMethodBeat.i(233820);
    setType(this.field_type | 0x20000);
    AppMethodBeat.o(233820);
  }
  
  public final void aRP()
  {
    AppMethodBeat.i(233823);
    setType(this.field_type & 0xFFFDFFFF);
    AppMethodBeat.o(233823);
  }
  
  public final void aRQ()
  {
    AppMethodBeat.i(233824);
    setType(this.field_type | 0x40000);
    AppMethodBeat.o(233824);
  }
  
  public final void aRR()
  {
    AppMethodBeat.i(233825);
    setType(this.field_type & 0xFFFBFFFF);
    AppMethodBeat.o(233825);
  }
  
  public final void aRS()
  {
    AppMethodBeat.i(42676);
    setType(this.field_type | 0x80000);
    AppMethodBeat.o(42676);
  }
  
  public final void aRT()
  {
    AppMethodBeat.i(42677);
    setType(this.field_type & 0xFFF7FFFF);
    AppMethodBeat.o(42677);
  }
  
  public final void aRU()
  {
    AppMethodBeat.i(42678);
    setType(this.field_type | 0x2);
    AppMethodBeat.o(42678);
  }
  
  public final void aRV()
  {
    AppMethodBeat.i(42679);
    setType(this.field_type & 0xFFFFFFFD);
    AppMethodBeat.o(42679);
  }
  
  public final void aRW()
  {
    AppMethodBeat.i(42680);
    setType(this.field_type & 0xFFFFF7FF);
    AppMethodBeat.o(42680);
  }
  
  public final void aRX()
  {
    AppMethodBeat.i(233831);
    setType(this.field_type | 0x10000000);
    AppMethodBeat.o(233831);
  }
  
  public final void aRY()
  {
    AppMethodBeat.i(233834);
    setType(this.field_type & 0xEFFFFFFF);
    AppMethodBeat.o(233834);
  }
  
  public final void aRZ()
  {
    AppMethodBeat.i(42681);
    setType(this.field_type | 0x20);
    AppMethodBeat.o(42681);
  }
  
  public final boolean aSD()
  {
    return (this.field_type & 0x2) != 0;
  }
  
  public final boolean aSE()
  {
    return (this.field_type & 0x4) != 0;
  }
  
  public final boolean aSF()
  {
    return (this.field_type & 0x8) != 0;
  }
  
  public final boolean aSG()
  {
    return (0x80000 & this.field_type) != 0;
  }
  
  public final boolean aSH()
  {
    return (0x20000 & this.field_type) != 0;
  }
  
  public final boolean aSI()
  {
    return (0x40000 & this.field_type) != 0;
  }
  
  public final boolean aSJ()
  {
    return (0x100000 & this.field_type) != 0;
  }
  
  public final boolean aSK()
  {
    return (this.field_type & 0x40) != 0;
  }
  
  public final boolean aSL()
  {
    return (this.field_type & 0x100) != 0;
  }
  
  public final boolean aSM()
  {
    return (0x10000 & this.field_type) != 0;
  }
  
  public final boolean aSN()
  {
    return (0x800000 & this.field_type) != 0;
  }
  
  public final boolean aSO()
  {
    return (0x2000000 & this.field_type) != 0;
  }
  
  public final boolean aSP()
  {
    return (0x8000000 & this.field_type) != 0;
  }
  
  public final boolean aSQ()
  {
    return (this.field_type & 0x800) != 0;
  }
  
  public final boolean aSR()
  {
    return (0x8000 & this.field_type) != 0;
  }
  
  public final void aSS()
  {
    AppMethodBeat.i(42692);
    setType(this.field_type | 0x8000);
    AppMethodBeat.o(42692);
  }
  
  public final int aST()
  {
    return (int)this.maN;
  }
  
  public final String aSU()
  {
    AppMethodBeat.i(42696);
    if (maO != null) {}
    for (String str = maO.iF(this.field_username); str != null; str = null)
    {
      AppMethodBeat.o(42696);
      return str;
    }
    if ((this.field_nickname == null) || (this.field_nickname.length() <= 0))
    {
      str = aSW();
      AppMethodBeat.o(42696);
      return str;
    }
    str = this.field_nickname;
    AppMethodBeat.o(42696);
    return str;
  }
  
  public final String aSV()
  {
    AppMethodBeat.i(42697);
    if ((this.field_conRemark != null) && (!this.field_conRemark.trim().equals("")))
    {
      str = this.field_conRemark;
      AppMethodBeat.o(42697);
      return str;
    }
    String str = aSU();
    AppMethodBeat.o(42697);
    return str;
  }
  
  public final String aSW()
  {
    AppMethodBeat.i(42698);
    String str = aJs();
    if (!Util.isNullOrNil(str))
    {
      AppMethodBeat.o(42698);
      return str;
    }
    str = DX(this.field_username);
    if ((str != null) && (str.length() != 0))
    {
      AppMethodBeat.o(42698);
      return str;
    }
    str = this.field_username;
    AppMethodBeat.o(42698);
    return str;
  }
  
  public final int aSX()
  {
    AppMethodBeat.i(42700);
    int i = super.getSource();
    AppMethodBeat.o(42700);
    return i;
  }
  
  public final void aSa()
  {
    AppMethodBeat.i(42682);
    setType(this.field_type & 0xFFFFFFDF);
    AppMethodBeat.o(42682);
  }
  
  public final void aSb()
  {
    AppMethodBeat.i(42683);
    setType(this.field_type | 0x40);
    AppMethodBeat.o(42683);
  }
  
  public final void aSc()
  {
    AppMethodBeat.i(42684);
    setType(this.field_type & 0xFFFFFFBF);
    AppMethodBeat.o(42684);
  }
  
  public final void aSd()
  {
    AppMethodBeat.i(42685);
    setType(this.field_type | 0x200);
    AppMethodBeat.o(42685);
  }
  
  public final void aSe()
  {
    AppMethodBeat.i(42686);
    setType(this.field_type & 0xFFFFFDFF);
    AppMethodBeat.o(42686);
  }
  
  public final void aSf()
  {
    AppMethodBeat.i(42687);
    setType(this.field_type | 0x100);
    AppMethodBeat.o(42687);
  }
  
  public final void aSg()
  {
    AppMethodBeat.i(42688);
    setType(this.field_type & 0xFFFFFEFF);
    AppMethodBeat.o(42688);
  }
  
  public final void aSh()
  {
    AppMethodBeat.i(233851);
    setType(this.field_type | 0x100000);
    AppMethodBeat.o(233851);
  }
  
  public final void aSi()
  {
    AppMethodBeat.i(233852);
    setType(this.field_type & 0xFFEFFFFF);
    AppMethodBeat.o(233852);
  }
  
  public final void aSj()
  {
    AppMethodBeat.i(42689);
    setType(this.field_type | 0x800000);
    AppMethodBeat.o(42689);
  }
  
  public final void aSk()
  {
    AppMethodBeat.i(42690);
    setType(this.field_type & 0xFF7FFFFF);
    AppMethodBeat.o(42690);
  }
  
  public final void aSl()
  {
    AppMethodBeat.i(233855);
    setType(this.field_type | 0x2000000);
    AppMethodBeat.o(233855);
  }
  
  public final void aSm()
  {
    AppMethodBeat.i(233856);
    setType(this.field_type & 0xFDFFFFFF);
    AppMethodBeat.o(233856);
  }
  
  public final void aSn()
  {
    AppMethodBeat.i(233858);
    setType(this.field_type | 0x8000000);
    AppMethodBeat.o(233858);
  }
  
  public final void aSo()
  {
    AppMethodBeat.i(233863);
    setType(this.field_type & 0xF7FFFFFF);
    AppMethodBeat.o(233863);
  }
  
  public final void ag(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(42717);
    if (!Util.isEqual(aJv(), paramArrayOfByte))
    {
      super.ag(paramArrayOfByte);
      aSY();
    }
    AppMethodBeat.o(42717);
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(42703);
    super.convertFrom(paramCursor);
    this.maN = this.systemRowid;
    super.ag(null);
    AppMethodBeat.o(42703);
  }
  
  public final void gO(long paramLong)
  {
    AppMethodBeat.i(42726);
    if (!Util.isEqual(aJz(), paramLong))
    {
      super.gO(paramLong);
      aSY();
    }
    AppMethodBeat.o(42726);
  }
  
  public final void gP(long paramLong)
  {
    AppMethodBeat.i(163506);
    if (!Util.isEqual(this.kax, paramLong))
    {
      super.gP(paramLong);
      aSY();
    }
    AppMethodBeat.o(163506);
  }
  
  public final void gQ(long paramLong)
  {
    AppMethodBeat.i(178862);
    if (!Util.isEqual(this.kay, paramLong))
    {
      super.gQ(paramLong);
      aSY();
    }
    AppMethodBeat.o(178862);
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final int getSource()
  {
    AppMethodBeat.i(42699);
    int i = super.getSource();
    AppMethodBeat.o(42699);
    return i % 1000000;
  }
  
  public final void hs(long paramLong)
  {
    AppMethodBeat.i(233916);
    if (!Util.isEqual(this.field_usernameFlag, paramLong))
    {
      super.gN(paramLong);
      aSY();
    }
    AppMethodBeat.o(233916);
  }
  
  public final boolean isHidden()
  {
    return (this.field_type & 0x20) != 0;
  }
  
  public final void pA(int paramInt)
  {
    AppMethodBeat.i(42735);
    if (!Util.isEqual(this.kag, paramInt))
    {
      super.pA(paramInt);
      aSY();
    }
    AppMethodBeat.o(42735);
  }
  
  public final void pB(int paramInt)
  {
    AppMethodBeat.i(42745);
    if (!Util.isEqual(this.kak, paramInt))
    {
      super.pB(paramInt);
      aSY();
    }
    AppMethodBeat.o(42745);
  }
  
  public final void pC(int paramInt)
  {
    AppMethodBeat.i(42746);
    if (!Util.isEqual(this.hyY, paramInt))
    {
      super.pC(paramInt);
      aSY();
    }
    AppMethodBeat.o(42746);
  }
  
  public final void pp(int paramInt)
  {
    AppMethodBeat.i(42711);
    if (!Util.isEqual(this.field_showHead, paramInt))
    {
      super.pp(paramInt);
      aSY();
    }
    AppMethodBeat.o(42711);
  }
  
  public final void pq(int paramInt)
  {
    AppMethodBeat.i(42713);
    if (!Util.isEqual(this.field_weiboFlag, paramInt))
    {
      super.pq(paramInt);
      aSY();
    }
    AppMethodBeat.o(42713);
  }
  
  public final void pr(int paramInt)
  {
    AppMethodBeat.i(42718);
    if (!Util.isEqual(this.field_verifyFlag, paramInt))
    {
      super.pr(paramInt);
      aSY();
    }
    AppMethodBeat.o(42718);
  }
  
  public final void ps(int paramInt)
  {
    AppMethodBeat.i(42720);
    if (!Util.isEqual(aJw(), paramInt))
    {
      super.ps(paramInt);
      aSY();
    }
    AppMethodBeat.o(42720);
  }
  
  public final void pt(int paramInt)
  {
    AppMethodBeat.i(42721);
    if (!Util.isEqual(this.field_deleteFlag, paramInt))
    {
      super.pt(paramInt);
      aSY();
    }
    AppMethodBeat.o(42721);
  }
  
  public final void pu(int paramInt)
  {
    AppMethodBeat.i(42723);
    if (!Util.isEqual(this.jZY, paramInt))
    {
      super.pu(paramInt);
      aSY();
    }
    AppMethodBeat.o(42723);
  }
  
  public final void pv(int paramInt)
  {
    AppMethodBeat.i(42724);
    if (!Util.isEqual(this.sex, paramInt))
    {
      super.pv(paramInt);
      aSY();
    }
    AppMethodBeat.o(42724);
  }
  
  public final void pw(int paramInt)
  {
    AppMethodBeat.i(42730);
    if (!Util.isEqual(getShowFlag(), paramInt))
    {
      super.pw(paramInt);
      aSY();
    }
    AppMethodBeat.o(42730);
  }
  
  public final void py(int paramInt)
  {
    AppMethodBeat.i(42731);
    if (!Util.isEqual(this.kac, paramInt))
    {
      super.py(paramInt);
      aSY();
    }
    AppMethodBeat.o(42731);
  }
  
  public final void pz(int paramInt)
  {
    AppMethodBeat.i(42734);
    if (!Util.isEqual(this.kaf, paramInt))
    {
      super.pz(paramInt);
      aSY();
    }
    AppMethodBeat.o(42734);
  }
  
  public final void rt(int paramInt)
  {
    AppMethodBeat.i(42702);
    ps(aJw() & 0xFFFFFFFE | paramInt & 0x1);
    AppMethodBeat.o(42702);
  }
  
  public final void ru(int paramInt)
  {
    AppMethodBeat.i(233918);
    if (!Util.isEqual(this.field_type, paramInt))
    {
      super.setType(paramInt);
      aSY();
    }
    AppMethodBeat.o(233918);
  }
  
  public final void setFromType(int paramInt)
  {
    AppMethodBeat.i(42740);
    if (!Util.isEqual(this.fromType, paramInt))
    {
      super.setFromType(paramInt);
      aSY();
    }
    AppMethodBeat.o(42740);
  }
  
  public final void setNickname(String paramString)
  {
    AppMethodBeat.i(42708);
    if (!Util.isEqual(this.field_nickname, paramString))
    {
      super.setNickname(paramString);
      aSY();
    }
    AppMethodBeat.o(42708);
  }
  
  public final void setSource(int paramInt)
  {
    AppMethodBeat.i(42741);
    if (!Util.isEqual(super.getSource(), paramInt))
    {
      super.setSource(paramInt);
      aSY();
    }
    AppMethodBeat.o(42741);
  }
  
  public final void setType(int paramInt)
  {
    AppMethodBeat.i(42712);
    if (!Util.isEqual(this.field_type, paramInt))
    {
      Log.i("MicroMsg.RContact", "setType %s old:%s new:%s", new Object[] { Util.nullAs(this.field_username, "null"), Integer.valueOf(this.field_type), Integer.valueOf(paramInt) });
      super.setType(paramInt);
      aSY();
    }
    AppMethodBeat.o(42712);
  }
  
  public final void setUin(int paramInt)
  {
    AppMethodBeat.i(42727);
    if (!Util.isEqual(this.uin, paramInt))
    {
      super.setUin(paramInt);
      aSY();
    }
    AppMethodBeat.o(42727);
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(42704);
    if (!Util.isEqual(this.field_username, paramString))
    {
      super.setUsername(paramString);
      aSY();
    }
    hs(at.bvQ(this.field_username));
    AppMethodBeat.o(42704);
  }
  
  public static abstract interface a
  {
    public abstract String iF(String paramString);
    
    public abstract String iG(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.contact.d
 * JD-Core Version:    0.7.0.1
 */