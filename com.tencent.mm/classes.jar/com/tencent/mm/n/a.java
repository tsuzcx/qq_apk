package com.tencent.mm.n;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Field;
import java.util.Map;

public class a
  extends aq
{
  private static a euG;
  public static c.a info;
  public long euF;
  public int versionCode;
  
  static
  {
    AppMethodBeat.i(59708);
    c.a locala = new c.a();
    locala.yrK = new Field[22];
    locala.columns = new String[23];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.yrM.put("username", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "username";
    locala.columns[1] = "alias";
    locala.yrM.put("alias", "TEXT default '' ");
    localStringBuilder.append(" alias TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "conRemark";
    locala.yrM.put("conRemark", "TEXT default '' ");
    localStringBuilder.append(" conRemark TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "domainList";
    locala.yrM.put("domainList", "TEXT default '' ");
    localStringBuilder.append(" domainList TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "nickname";
    locala.yrM.put("nickname", "TEXT default '' ");
    localStringBuilder.append(" nickname TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "pyInitial";
    locala.yrM.put("pyInitial", "TEXT default '' ");
    localStringBuilder.append(" pyInitial TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "quanPin";
    locala.yrM.put("quanPin", "TEXT default '' ");
    localStringBuilder.append(" quanPin TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "showHead";
    locala.yrM.put("showHead", "INTEGER default '0' ");
    localStringBuilder.append(" showHead INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "type";
    locala.yrM.put("type", "INTEGER default '0' ");
    localStringBuilder.append(" type INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "weiboFlag";
    locala.yrM.put("weiboFlag", "INTEGER default '0' ");
    localStringBuilder.append(" weiboFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "weiboNickname";
    locala.yrM.put("weiboNickname", "TEXT default '' ");
    localStringBuilder.append(" weiboNickname TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "conRemarkPYFull";
    locala.yrM.put("conRemarkPYFull", "TEXT default '' ");
    localStringBuilder.append(" conRemarkPYFull TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "conRemarkPYShort";
    locala.yrM.put("conRemarkPYShort", "TEXT default '' ");
    localStringBuilder.append(" conRemarkPYShort TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "lvbuff";
    locala.yrM.put("lvbuff", "BLOB");
    localStringBuilder.append(" lvbuff BLOB");
    localStringBuilder.append(", ");
    locala.columns[14] = "verifyFlag";
    locala.yrM.put("verifyFlag", "INTEGER default '0' ");
    localStringBuilder.append(" verifyFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[15] = "encryptUsername";
    locala.yrM.put("encryptUsername", "TEXT default '' ");
    localStringBuilder.append(" encryptUsername TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[16] = "chatroomFlag";
    locala.yrM.put("chatroomFlag", "INTEGER");
    localStringBuilder.append(" chatroomFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[17] = "deleteFlag";
    locala.yrM.put("deleteFlag", "INTEGER default '0' ");
    localStringBuilder.append(" deleteFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "contactLabelIds";
    locala.yrM.put("contactLabelIds", "TEXT default '' ");
    localStringBuilder.append(" contactLabelIds TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[19] = "descWordingId";
    locala.yrM.put("descWordingId", "TEXT default '' ");
    localStringBuilder.append(" descWordingId TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[20] = "openImAppid";
    locala.yrM.put("openImAppid", "TEXT");
    localStringBuilder.append(" openImAppid TEXT");
    localStringBuilder.append(", ");
    locala.columns[21] = "sourceExtInfo";
    locala.yrM.put("sourceExtInfo", "TEXT");
    localStringBuilder.append(" sourceExtInfo TEXT");
    locala.columns[22] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    euG = null;
    AppMethodBeat.o(59708);
  }
  
  public a()
  {
    AppMethodBeat.i(59621);
    this.versionCode = 0;
    super.setUsername("");
    super.jp("");
    super.jq("");
    super.jr("");
    super.jm("");
    super.jn("");
    super.ju("");
    super.jt("");
    super.jo("");
    super.ht(0);
    super.js("");
    super.hs(0);
    super.setType(0);
    super.hu(0);
    super.hv(0);
    super.jw("");
    super.hy(0);
    super.jI("");
    super.hD(0);
    super.setUin(0);
    super.jB("");
    super.jC("");
    super.hz(0);
    super.hA(0);
    super.jD("");
    super.jE("");
    super.hB(1);
    super.hx(0);
    super.hC(0);
    super.jF("");
    super.jG("");
    super.jH("");
    super.setSource(0);
    super.jK("");
    super.jJ("");
    super.fJ(0L);
    super.jA("");
    super.jL("");
    super.hE(0);
    super.jO("");
    super.jP("");
    super.jQ("");
    super.jT("");
    super.jx("");
    super.jy("");
    this.versionCode = 0;
    AppMethodBeat.o(59621);
  }
  
  public a(String paramString)
  {
    this();
    AppMethodBeat.i(59620);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    setUsername(str);
    AppMethodBeat.o(59620);
  }
  
  public static int NO()
  {
    return 1;
  }
  
  public static int NP()
  {
    return 8;
  }
  
  public static int NQ()
  {
    return 524288;
  }
  
  public static int NR()
  {
    return 16;
  }
  
  public static int NS()
  {
    return 32;
  }
  
  private int Oi()
  {
    int i = this.versionCode + 1;
    this.versionCode = i;
    return i;
  }
  
  public static void a(a parama)
  {
    euG = parama;
  }
  
  private static boolean isLetter(char paramChar)
  {
    return ((paramChar >= 'A') && (paramChar <= 'Z')) || ((paramChar >= 'a') && (paramChar <= 'z'));
  }
  
  public static boolean je(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public static String lG(String paramString)
  {
    AppMethodBeat.i(59622);
    if (euG != null)
    {
      paramString = euG.dK(paramString);
      AppMethodBeat.o(59622);
      return paramString;
    }
    AppMethodBeat.o(59622);
    return null;
  }
  
  private static String lH(String paramString)
  {
    AppMethodBeat.i(59653);
    if (paramString == null)
    {
      AppMethodBeat.o(59653);
      return null;
    }
    if (paramString.toLowerCase().endsWith("@t.qq.com"))
    {
      paramString = "@" + paramString.replace("@t.qq.com", "");
      AppMethodBeat.o(59653);
      return paramString;
    }
    if (paramString.toLowerCase().endsWith("@qqim"))
    {
      paramString = paramString.replace("@qqim", "");
      long l = Long.valueOf(paramString).longValue();
      if (l < 0L)
      {
        paramString = new p(l).toString();
        AppMethodBeat.o(59653);
        return paramString;
      }
      AppMethodBeat.o(59653);
      return paramString;
    }
    AppMethodBeat.o(59653);
    return paramString;
  }
  
  public final boolean DP()
  {
    return (this.field_type & 0x200) != 0;
  }
  
  public final void G(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(59669);
    if (!bo.isEqual(this.field_lvbuff, paramArrayOfByte))
    {
      super.G(paramArrayOfByte);
      Oi();
    }
    AppMethodBeat.o(59669);
  }
  
  public final String Hq()
  {
    AppMethodBeat.i(59647);
    if (euG != null) {}
    for (String str = euG.dL(this.field_username); str == null; str = null)
    {
      str = super.Hq();
      AppMethodBeat.o(59647);
      return str;
    }
    AppMethodBeat.o(59647);
    return str;
  }
  
  public final String Ht()
  {
    AppMethodBeat.i(59645);
    if ((super.Ht() == null) || (super.Ht().length() < 0))
    {
      str = Hu();
      AppMethodBeat.o(59645);
      return str;
    }
    String str = super.Ht();
    AppMethodBeat.o(59645);
    return str;
  }
  
  public final String Hu()
  {
    AppMethodBeat.i(59646);
    if ((super.Hu() == null) || (super.Hu().length() < 0))
    {
      str = this.field_nickname;
      AppMethodBeat.o(59646);
      return str;
    }
    String str = super.Hu();
    AppMethodBeat.o(59646);
    return str;
  }
  
  public final boolean JY()
  {
    return (this.field_type & 0x400) == 0;
  }
  
  public final void NA()
  {
    AppMethodBeat.i(59629);
    setType(this.field_type & 0xFFFFFFF7);
    AppMethodBeat.o(59629);
  }
  
  public final void NB()
  {
    AppMethodBeat.i(59630);
    setType(this.field_type | 0x80000);
    AppMethodBeat.o(59630);
  }
  
  public final void NC()
  {
    AppMethodBeat.i(59631);
    setType(this.field_type & 0xFFF7FFFF);
    AppMethodBeat.o(59631);
  }
  
  public final void ND()
  {
    AppMethodBeat.i(59632);
    setType(this.field_type | 0x2);
    AppMethodBeat.o(59632);
  }
  
  public final void NE()
  {
    AppMethodBeat.i(59633);
    setType(this.field_type & 0xFFFFFFFD);
    AppMethodBeat.o(59633);
  }
  
  public final void NF()
  {
    AppMethodBeat.i(59634);
    setType(this.field_type & 0xFFFFF7FF);
    AppMethodBeat.o(59634);
  }
  
  public final void NG()
  {
    AppMethodBeat.i(59635);
    setType(this.field_type | 0x20);
    AppMethodBeat.o(59635);
  }
  
  public final void NH()
  {
    AppMethodBeat.i(59636);
    setType(this.field_type & 0xFFFFFFDF);
    AppMethodBeat.o(59636);
  }
  
  public final void NI()
  {
    AppMethodBeat.i(59637);
    setType(this.field_type | 0x40);
    AppMethodBeat.o(59637);
  }
  
  public final void NJ()
  {
    AppMethodBeat.i(59638);
    setType(this.field_type & 0xFFFFFFBF);
    AppMethodBeat.o(59638);
  }
  
  public final void NK()
  {
    AppMethodBeat.i(59639);
    setType(this.field_type | 0x200);
    AppMethodBeat.o(59639);
  }
  
  public final void NL()
  {
    AppMethodBeat.i(59640);
    setType(this.field_type & 0xFFFFFDFF);
    AppMethodBeat.o(59640);
  }
  
  public final void NM()
  {
    AppMethodBeat.i(59641);
    setType(this.field_type | 0x100);
    AppMethodBeat.o(59641);
  }
  
  public final void NN()
  {
    AppMethodBeat.i(59642);
    setType(this.field_type & 0xFFFFFEFF);
    AppMethodBeat.o(59642);
  }
  
  public final boolean NT()
  {
    AppMethodBeat.i(156800);
    boolean bool = je(this.field_type);
    AppMethodBeat.o(156800);
    return bool;
  }
  
  public final boolean NU()
  {
    return (this.field_type & 0x2) != 0;
  }
  
  public final boolean NV()
  {
    return (this.field_type & 0x4) != 0;
  }
  
  public final boolean NW()
  {
    return (this.field_type & 0x8) != 0;
  }
  
  public final boolean NX()
  {
    return (0x80000 & this.field_type) != 0;
  }
  
  public final boolean NY()
  {
    return (this.field_type & 0x40) != 0;
  }
  
  public final boolean NZ()
  {
    return (this.field_type & 0x100) != 0;
  }
  
  public final int Nu()
  {
    AppMethodBeat.i(59623);
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
      AppMethodBeat.o(59623);
      return j;
      if ((this.field_conRemarkPYFull != null) && (!this.field_conRemarkPYFull.equals("")))
      {
        i = this.field_conRemarkPYFull.charAt(0);
        break;
      }
      if ((super.Ht() != null) && (!super.Ht().equals("")))
      {
        i = super.Ht().charAt(0);
        break;
      }
      if ((super.Hu() != null) && (!super.Hu().equals("")))
      {
        i = super.Hu().charAt(0);
        break;
      }
      if ((this.field_nickname != null) && (!this.field_nickname.equals("")) && (isLetter(this.field_nickname.charAt(0))))
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
      if (!isLetter(this.field_username.charAt(0))) {
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
  
  public final void Nv()
  {
    AppMethodBeat.i(59624);
    setType(0);
    AppMethodBeat.o(59624);
  }
  
  public final void Nw()
  {
    AppMethodBeat.i(59625);
    setType(this.field_type | 0x4);
    AppMethodBeat.o(59625);
  }
  
  public final void Nx()
  {
    AppMethodBeat.i(59626);
    setType(this.field_type | 0x1);
    AppMethodBeat.o(59626);
  }
  
  public final void Ny()
  {
    AppMethodBeat.i(59627);
    ab.w("MicroMsg.RContact", "unSetContact!! user:%s oldType:%d [%s]", new Object[] { this.field_username, Integer.valueOf(this.field_type), bo.dtY() });
    setType(this.field_type & 0xFFFFFFFE);
    AppMethodBeat.o(59627);
  }
  
  public final void Nz()
  {
    AppMethodBeat.i(59628);
    setType(this.field_type | 0x8);
    AppMethodBeat.o(59628);
  }
  
  public final boolean Oa()
  {
    return (this.field_type & 0x800) != 0;
  }
  
  public final boolean Ob()
  {
    return (0x8000 & this.field_type) != 0;
  }
  
  public final void Oc()
  {
    AppMethodBeat.i(59644);
    setType(this.field_type | 0x8000);
    AppMethodBeat.o(59644);
  }
  
  public final int Od()
  {
    return (int)this.euF;
  }
  
  public final String Oe()
  {
    AppMethodBeat.i(59648);
    if (euG != null) {}
    for (String str = euG.dK(this.field_username); str != null; str = null)
    {
      AppMethodBeat.o(59648);
      return str;
    }
    if ((this.field_nickname == null) || (this.field_nickname.length() <= 0))
    {
      str = Og();
      AppMethodBeat.o(59648);
      return str;
    }
    str = this.field_nickname;
    AppMethodBeat.o(59648);
    return str;
  }
  
  public final String Of()
  {
    AppMethodBeat.i(59649);
    if ((this.field_conRemark != null) && (!this.field_conRemark.trim().equals("")))
    {
      str = this.field_conRemark;
      AppMethodBeat.o(59649);
      return str;
    }
    String str = Oe();
    AppMethodBeat.o(59649);
    return str;
  }
  
  public final String Og()
  {
    AppMethodBeat.i(59650);
    String str = Hq();
    if (!bo.isNullOrNil(str))
    {
      AppMethodBeat.o(59650);
      return str;
    }
    str = lH(this.field_username);
    if ((str != null) && (str.length() != 0))
    {
      AppMethodBeat.o(59650);
      return str;
    }
    str = this.field_username;
    AppMethodBeat.o(59650);
    return str;
  }
  
  public final int Oh()
  {
    AppMethodBeat.i(59652);
    int i = super.getSource();
    AppMethodBeat.o(59652);
    return i;
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(59655);
    super.convertFrom(paramCursor);
    this.euF = this.systemRowid;
    super.G(null);
    AppMethodBeat.o(59655);
  }
  
  public final void fJ(long paramLong)
  {
    AppMethodBeat.i(59678);
    if (!bo.ah(this.dqE, paramLong))
    {
      super.fJ(paramLong);
      Oi();
    }
    AppMethodBeat.o(59678);
  }
  
  public c.a getDBInfo()
  {
    return info;
  }
  
  public final int getSource()
  {
    AppMethodBeat.i(59651);
    int i = super.getSource();
    AppMethodBeat.o(59651);
    return i % 1000000;
  }
  
  public final void hA(int paramInt)
  {
    AppMethodBeat.i(59683);
    if (!bo.hl(this.dqH, paramInt))
    {
      super.hA(paramInt);
      Oi();
    }
    AppMethodBeat.o(59683);
  }
  
  public final void hB(int paramInt)
  {
    AppMethodBeat.i(59686);
    if (!bo.hl(this.dqK, paramInt))
    {
      super.hB(paramInt);
      Oi();
    }
    AppMethodBeat.o(59686);
  }
  
  public final void hC(int paramInt)
  {
    AppMethodBeat.i(59687);
    if (!bo.hl(this.dqL, paramInt))
    {
      super.hC(paramInt);
      Oi();
    }
    AppMethodBeat.o(59687);
  }
  
  public final void hD(int paramInt)
  {
    AppMethodBeat.i(59692);
    if (!bo.hl(this.dqN, paramInt))
    {
      super.hD(paramInt);
      Oi();
    }
    AppMethodBeat.o(59692);
  }
  
  public final void hE(int paramInt)
  {
    AppMethodBeat.i(59697);
    if (!bo.hl(this.dqR, paramInt))
    {
      super.hE(paramInt);
      Oi();
    }
    AppMethodBeat.o(59697);
  }
  
  public final void hF(int paramInt)
  {
    AppMethodBeat.i(59698);
    if (!bo.hl(this.dqS, paramInt))
    {
      super.hF(paramInt);
      Oi();
    }
    AppMethodBeat.o(59698);
  }
  
  public final void hs(int paramInt)
  {
    AppMethodBeat.i(59663);
    if (!bo.hl(this.field_showHead, paramInt))
    {
      super.hs(paramInt);
      Oi();
    }
    AppMethodBeat.o(59663);
  }
  
  public final void ht(int paramInt)
  {
    AppMethodBeat.i(59665);
    if (!bo.hl(this.field_weiboFlag, paramInt))
    {
      super.ht(paramInt);
      Oi();
    }
    AppMethodBeat.o(59665);
  }
  
  public final void hu(int paramInt)
  {
    AppMethodBeat.i(59670);
    if (!bo.hl(this.field_verifyFlag, paramInt))
    {
      super.hu(paramInt);
      Oi();
    }
    AppMethodBeat.o(59670);
  }
  
  public final void hv(int paramInt)
  {
    AppMethodBeat.i(59672);
    if (!bo.hl(this.field_chatroomFlag, paramInt))
    {
      super.hv(paramInt);
      Oi();
    }
    AppMethodBeat.o(59672);
  }
  
  public final void hw(int paramInt)
  {
    AppMethodBeat.i(59673);
    if (!bo.hl(this.field_deleteFlag, paramInt))
    {
      super.hw(paramInt);
      Oi();
    }
    AppMethodBeat.o(59673);
  }
  
  public final void hx(int paramInt)
  {
    AppMethodBeat.i(59675);
    if (!bo.hl(this.dqB, paramInt))
    {
      super.hx(paramInt);
      Oi();
    }
    AppMethodBeat.o(59675);
  }
  
  public final void hy(int paramInt)
  {
    AppMethodBeat.i(59676);
    if (!bo.hl(this.dqC, paramInt))
    {
      super.hy(paramInt);
      Oi();
    }
    AppMethodBeat.o(59676);
  }
  
  public final void hz(int paramInt)
  {
    AppMethodBeat.i(59682);
    if (!bo.hl(this.dqG, paramInt))
    {
      super.hz(paramInt);
      Oi();
    }
    AppMethodBeat.o(59682);
  }
  
  public final boolean isHidden()
  {
    return (this.field_type & 0x20) != 0;
  }
  
  public final void jA(String paramString)
  {
    AppMethodBeat.i(59677);
    if (!bo.isEqual(this.dqD, paramString))
    {
      super.jA(paramString);
      Oi();
    }
    AppMethodBeat.o(59677);
  }
  
  public final void jB(String paramString)
  {
    AppMethodBeat.i(59680);
    if (!bo.isEqual(this.dqF, paramString))
    {
      super.jB(paramString);
      Oi();
    }
    AppMethodBeat.o(59680);
  }
  
  public final void jC(String paramString)
  {
    AppMethodBeat.i(59681);
    if (!bo.isEqual(this.czF, paramString))
    {
      super.jC(paramString);
      Oi();
    }
    AppMethodBeat.o(59681);
  }
  
  public final void jD(String paramString)
  {
    AppMethodBeat.i(59684);
    if (!bo.isEqual(this.dqI, paramString))
    {
      super.jD(paramString);
      Oi();
    }
    AppMethodBeat.o(59684);
  }
  
  public final void jE(String paramString)
  {
    AppMethodBeat.i(59685);
    if (!bo.isEqual(this.dqJ, paramString))
    {
      super.jE(paramString);
      Oi();
    }
    AppMethodBeat.o(59685);
  }
  
  public final void jF(String paramString)
  {
    AppMethodBeat.i(59688);
    if (!bo.isEqual(this.signature, paramString))
    {
      super.jF(paramString);
      Oi();
    }
    AppMethodBeat.o(59688);
  }
  
  public void jG(String paramString)
  {
    AppMethodBeat.i(59689);
    if (!bo.isEqual(getProvince(), paramString))
    {
      super.jG(paramString);
      Oi();
    }
    AppMethodBeat.o(59689);
  }
  
  public void jH(String paramString)
  {
    AppMethodBeat.i(59690);
    if (!bo.isEqual(getCity(), paramString))
    {
      super.jH(paramString);
      Oi();
    }
    AppMethodBeat.o(59690);
  }
  
  public final void jI(String paramString)
  {
    AppMethodBeat.i(59691);
    if (!bo.isEqual(this.dqM, paramString))
    {
      super.jI(paramString);
      Oi();
    }
    AppMethodBeat.o(59691);
  }
  
  public final void jJ(String paramString)
  {
    AppMethodBeat.i(59694);
    if (!bo.isEqual(this.dqO, paramString))
    {
      super.jJ(paramString);
      Oi();
    }
    AppMethodBeat.o(59694);
  }
  
  public final void jK(String paramString)
  {
    AppMethodBeat.i(59695);
    if (!bo.isEqual(this.dqP, paramString))
    {
      super.jK(paramString);
      Oi();
    }
    AppMethodBeat.o(59695);
  }
  
  public void jL(String paramString)
  {
    AppMethodBeat.i(59696);
    if (!bo.isEqual(this.dqQ, paramString))
    {
      super.jL(paramString);
      Oi();
    }
    AppMethodBeat.o(59696);
  }
  
  public final void jM(String paramString)
  {
    AppMethodBeat.i(59699);
    if (!bo.isEqual(this.dqT, paramString))
    {
      super.jM(paramString);
      Oi();
    }
    AppMethodBeat.o(59699);
  }
  
  public final void jN(String paramString)
  {
    AppMethodBeat.i(59700);
    if (!bo.isEqual(this.dqU, paramString))
    {
      super.jN(paramString);
      Oi();
    }
    AppMethodBeat.o(59700);
  }
  
  public final void jO(String paramString)
  {
    AppMethodBeat.i(59701);
    if (!bo.isEqual(this.dqV, paramString))
    {
      super.jO(paramString);
      Oi();
    }
    AppMethodBeat.o(59701);
  }
  
  public final void jP(String paramString)
  {
    AppMethodBeat.i(59702);
    if (!bo.isEqual(this.dqW, paramString))
    {
      super.jP(paramString);
      Oi();
    }
    AppMethodBeat.o(59702);
  }
  
  public final void jQ(String paramString)
  {
    AppMethodBeat.i(59703);
    if (!bo.isEqual(this.dqX, paramString))
    {
      super.jQ(paramString);
      Oi();
    }
    AppMethodBeat.o(59703);
  }
  
  public final void jR(String paramString)
  {
    AppMethodBeat.i(59704);
    if (!bo.isEqual(this.dqY, paramString))
    {
      super.jR(paramString);
      Oi();
    }
    AppMethodBeat.o(59704);
  }
  
  public final void jS(String paramString)
  {
    AppMethodBeat.i(59705);
    if (!bo.isEqual(this.dqZ, paramString))
    {
      super.jS(paramString);
      Oi();
    }
    AppMethodBeat.o(59705);
  }
  
  public final void jT(String paramString)
  {
    AppMethodBeat.i(59706);
    if (!bo.isEqual(this.dra, paramString))
    {
      super.jT(paramString);
      Oi();
    }
    AppMethodBeat.o(59706);
  }
  
  public final void jf(int paramInt)
  {
    AppMethodBeat.i(59654);
    hv(this.field_chatroomFlag & 0xFFFFFFFE | paramInt & 0x1);
    AppMethodBeat.o(59654);
  }
  
  public final void jm(String paramString)
  {
    AppMethodBeat.i(59657);
    if (!bo.isEqual(Hq(), paramString))
    {
      super.jm(paramString);
      Oi();
    }
    AppMethodBeat.o(59657);
  }
  
  public final void jn(String paramString)
  {
    AppMethodBeat.i(59658);
    if (!bo.isEqual(this.field_conRemark, paramString))
    {
      super.jn(paramString);
      Oi();
    }
    AppMethodBeat.o(59658);
  }
  
  public final void jo(String paramString)
  {
    AppMethodBeat.i(59659);
    if (!bo.isEqual(this.field_domainList, paramString))
    {
      super.jo(paramString);
      Oi();
    }
    AppMethodBeat.o(59659);
  }
  
  public final void jp(String paramString)
  {
    AppMethodBeat.i(59660);
    if (!bo.isEqual(this.field_nickname, paramString))
    {
      super.jp(paramString);
      Oi();
    }
    AppMethodBeat.o(59660);
  }
  
  public final void jq(String paramString)
  {
    AppMethodBeat.i(59661);
    if (!bo.isEqual(Ht(), paramString))
    {
      super.jq(paramString);
      Oi();
    }
    AppMethodBeat.o(59661);
  }
  
  public final void jr(String paramString)
  {
    AppMethodBeat.i(59662);
    if (!bo.isEqual(Hu(), paramString))
    {
      super.jr(paramString);
      Oi();
    }
    AppMethodBeat.o(59662);
  }
  
  public final void js(String paramString)
  {
    AppMethodBeat.i(59666);
    if (!bo.isEqual(this.field_weiboNickname, paramString))
    {
      super.js(paramString);
      Oi();
    }
    AppMethodBeat.o(59666);
  }
  
  public final void jt(String paramString)
  {
    AppMethodBeat.i(59667);
    if (!bo.isEqual(this.field_conRemarkPYFull, paramString))
    {
      super.jt(paramString);
      Oi();
    }
    AppMethodBeat.o(59667);
  }
  
  public final void ju(String paramString)
  {
    AppMethodBeat.i(59668);
    if (!bo.isEqual(this.field_conRemarkPYShort, paramString))
    {
      super.ju(paramString);
      Oi();
    }
    AppMethodBeat.o(59668);
  }
  
  public final void jv(String paramString)
  {
    AppMethodBeat.i(59671);
    if (!bo.isEqual(this.field_encryptUsername, paramString))
    {
      super.jv(paramString);
      Oi();
    }
    AppMethodBeat.o(59671);
  }
  
  public final void jw(String paramString)
  {
    AppMethodBeat.i(59674);
    if (!bo.isEqual(this.field_contactLabelIds, paramString))
    {
      super.jw(paramString);
      Oi();
    }
    AppMethodBeat.o(59674);
  }
  
  public final void jy(String paramString)
  {
    AppMethodBeat.i(59707);
    if (!bo.isEqual(this.field_openImAppid, paramString))
    {
      super.jy(paramString);
      Oi();
    }
    AppMethodBeat.o(59707);
  }
  
  public final void jz(String paramString)
  {
    AppMethodBeat.i(141739);
    if (!bo.isEqual(this.field_sourceExtInfo, paramString))
    {
      super.jz(paramString);
      Oi();
    }
    AppMethodBeat.o(141739);
  }
  
  public final void setSource(int paramInt)
  {
    AppMethodBeat.i(59693);
    if (!bo.hl(super.getSource(), paramInt))
    {
      super.setSource(paramInt);
      Oi();
    }
    AppMethodBeat.o(59693);
  }
  
  public final void setType(int paramInt)
  {
    AppMethodBeat.i(59664);
    if (!bo.hl(this.field_type, paramInt))
    {
      super.setType(paramInt);
      Oi();
    }
    AppMethodBeat.o(59664);
  }
  
  public final void setUin(int paramInt)
  {
    AppMethodBeat.i(59679);
    if (!bo.hl(this.uin, paramInt))
    {
      super.setUin(paramInt);
      Oi();
    }
    AppMethodBeat.o(59679);
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(59656);
    if (!bo.isEqual(this.field_username, paramString))
    {
      super.setUsername(paramString);
      Oi();
    }
    AppMethodBeat.o(59656);
  }
  
  public static abstract interface a
  {
    public abstract String dK(String paramString);
    
    public abstract String dL(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.n.a
 * JD-Core Version:    0.7.0.1
 */