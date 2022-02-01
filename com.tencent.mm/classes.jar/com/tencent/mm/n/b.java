package com.tencent.mm.n;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.g.c.av;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.reflect.Field;
import java.util.Map;

public class b
  extends av
{
  private static a fLK;
  public static c.a info;
  public long fLJ;
  public int versionCode;
  
  static
  {
    AppMethodBeat.i(42758);
    c.a locala = new c.a();
    locala.GvF = new Field[23];
    locala.columns = new String[24];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.GvH.put("username", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "username";
    locala.columns[1] = "alias";
    locala.GvH.put("alias", "TEXT default '' ");
    localStringBuilder.append(" alias TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "conRemark";
    locala.GvH.put("conRemark", "TEXT default '' ");
    localStringBuilder.append(" conRemark TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "domainList";
    locala.GvH.put("domainList", "TEXT default '' ");
    localStringBuilder.append(" domainList TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "nickname";
    locala.GvH.put("nickname", "TEXT default '' ");
    localStringBuilder.append(" nickname TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "pyInitial";
    locala.GvH.put("pyInitial", "TEXT default '' ");
    localStringBuilder.append(" pyInitial TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "quanPin";
    locala.GvH.put("quanPin", "TEXT default '' ");
    localStringBuilder.append(" quanPin TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "showHead";
    locala.GvH.put("showHead", "INTEGER default '0' ");
    localStringBuilder.append(" showHead INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "type";
    locala.GvH.put("type", "INTEGER default '0' ");
    localStringBuilder.append(" type INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "weiboFlag";
    locala.GvH.put("weiboFlag", "INTEGER default '0' ");
    localStringBuilder.append(" weiboFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "weiboNickname";
    locala.GvH.put("weiboNickname", "TEXT default '' ");
    localStringBuilder.append(" weiboNickname TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "conRemarkPYFull";
    locala.GvH.put("conRemarkPYFull", "TEXT default '' ");
    localStringBuilder.append(" conRemarkPYFull TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "conRemarkPYShort";
    locala.GvH.put("conRemarkPYShort", "TEXT default '' ");
    localStringBuilder.append(" conRemarkPYShort TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "lvbuff";
    locala.GvH.put("lvbuff", "BLOB");
    localStringBuilder.append(" lvbuff BLOB");
    localStringBuilder.append(", ");
    locala.columns[14] = "verifyFlag";
    locala.GvH.put("verifyFlag", "INTEGER default '0' ");
    localStringBuilder.append(" verifyFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[15] = "encryptUsername";
    locala.GvH.put("encryptUsername", "TEXT default '' ");
    localStringBuilder.append(" encryptUsername TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[16] = "chatroomFlag";
    locala.GvH.put("chatroomFlag", "INTEGER");
    localStringBuilder.append(" chatroomFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[17] = "deleteFlag";
    locala.GvH.put("deleteFlag", "INTEGER default '0' ");
    localStringBuilder.append(" deleteFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "contactLabelIds";
    locala.GvH.put("contactLabelIds", "TEXT default '' ");
    localStringBuilder.append(" contactLabelIds TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[19] = "descWordingId";
    locala.GvH.put("descWordingId", "TEXT default '' ");
    localStringBuilder.append(" descWordingId TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[20] = "openImAppid";
    locala.GvH.put("openImAppid", "TEXT");
    localStringBuilder.append(" openImAppid TEXT");
    localStringBuilder.append(", ");
    locala.columns[21] = "sourceExtInfo";
    locala.GvH.put("sourceExtInfo", "TEXT");
    localStringBuilder.append(" sourceExtInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[22] = "ticket";
    locala.GvH.put("ticket", "TEXT default '' ");
    localStringBuilder.append(" ticket TEXT default '' ");
    locala.columns[23] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    fLK = null;
    AppMethodBeat.o(42758);
  }
  
  public b()
  {
    AppMethodBeat.i(42667);
    this.versionCode = 0;
    super.setUsername("");
    super.qj("");
    super.qk("");
    super.ql("");
    super.qg("");
    super.qh("");
    super.qo("");
    super.qn("");
    super.qi("");
    super.jC(0);
    super.qm("");
    super.jB(0);
    super.setType(0);
    super.jD(0);
    super.jE(0);
    super.qq("");
    super.jH(0);
    super.qD("");
    super.setFromType(0);
    super.setUin(0);
    super.qw("");
    super.qx("");
    super.jI(0);
    super.jJ(0);
    super.qy("");
    super.qz("");
    super.jK(1);
    super.jG(0);
    super.jL(0);
    super.qA("");
    super.qB("");
    super.qC("");
    super.setSource(0);
    super.qF("");
    super.qE("");
    super.or(0L);
    super.qv("");
    super.qG("");
    super.jM(0);
    super.qJ("");
    super.qK("");
    super.qL("");
    super.qO("");
    super.qr("");
    super.qs("");
    this.versionCode = 0;
    AppMethodBeat.o(42667);
  }
  
  public b(String paramString)
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
  
  public static void a(a parama)
  {
    fLK = parama;
  }
  
  public static int aaA()
  {
    return 524288;
  }
  
  public static int aaB()
  {
    return 8388608;
  }
  
  public static int aaC()
  {
    return 16;
  }
  
  public static int aaD()
  {
    return 32;
  }
  
  private int aaV()
  {
    int i = this.versionCode + 1;
    this.versionCode = i;
    return i;
  }
  
  public static int aay()
  {
    return 1;
  }
  
  public static int aaz()
  {
    return 8;
  }
  
  private static boolean isLetter(char paramChar)
  {
    return ((paramChar >= 'A') && (paramChar <= 'Z')) || ((paramChar >= 'a') && (paramChar <= 'z'));
  }
  
  public static boolean ln(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public static String sW(String paramString)
  {
    AppMethodBeat.i(42668);
    if (fLK != null)
    {
      paramString = fLK.eH(paramString);
      AppMethodBeat.o(42668);
      return paramString;
    }
    AppMethodBeat.o(42668);
    return null;
  }
  
  private static String sX(String paramString)
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
  
  public final void M(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(42717);
    if (!bs.isEqual(this.field_lvbuff, paramArrayOfByte))
    {
      super.M(paramArrayOfByte);
      aaV();
    }
    AppMethodBeat.o(42717);
  }
  
  public final boolean Nw()
  {
    return (this.field_type & 0x200) != 0;
  }
  
  public final String Tl()
  {
    AppMethodBeat.i(42695);
    if (fLK != null) {}
    for (String str = fLK.eI(this.field_username); str == null; str = null)
    {
      str = super.Tl();
      AppMethodBeat.o(42695);
      return str;
    }
    AppMethodBeat.o(42695);
    return str;
  }
  
  public final String To()
  {
    AppMethodBeat.i(42693);
    if ((super.To() == null) || (super.To().length() < 0))
    {
      str = Tp();
      AppMethodBeat.o(42693);
      return str;
    }
    String str = super.To();
    AppMethodBeat.o(42693);
    return str;
  }
  
  public final String Tp()
  {
    AppMethodBeat.i(42694);
    if ((super.Tp() == null) || (super.Tp().length() < 0))
    {
      str = this.field_nickname;
      AppMethodBeat.o(42694);
      return str;
    }
    String str = super.Tp();
    AppMethodBeat.o(42694);
    return str;
  }
  
  public final boolean WE()
  {
    return (this.field_type & 0x400) == 0;
  }
  
  public final boolean aaE()
  {
    AppMethodBeat.i(210242);
    boolean bool = ln(this.field_type);
    AppMethodBeat.o(210242);
    return bool;
  }
  
  public final boolean aaF()
  {
    return (this.field_type & 0x2) != 0;
  }
  
  public final boolean aaG()
  {
    return (this.field_type & 0x4) != 0;
  }
  
  public final boolean aaH()
  {
    return (this.field_type & 0x8) != 0;
  }
  
  public final boolean aaI()
  {
    return (0x80000 & this.field_type) != 0;
  }
  
  public final boolean aaJ()
  {
    return (this.field_type & 0x40) != 0;
  }
  
  public final boolean aaK()
  {
    return (this.field_type & 0x100) != 0;
  }
  
  public final boolean aaL()
  {
    return (0x10000 & this.field_type) != 0;
  }
  
  public final boolean aaM()
  {
    return (0x800000 & this.field_type) != 0;
  }
  
  public final boolean aaN()
  {
    return (this.field_type & 0x800) != 0;
  }
  
  public final boolean aaO()
  {
    return (0x8000 & this.field_type) != 0;
  }
  
  public final void aaP()
  {
    AppMethodBeat.i(42692);
    setType(this.field_type | 0x8000);
    AppMethodBeat.o(42692);
  }
  
  public final int aaQ()
  {
    return (int)this.fLJ;
  }
  
  public final String aaR()
  {
    AppMethodBeat.i(42696);
    if (fLK != null) {}
    for (String str = fLK.eH(this.field_username); str != null; str = null)
    {
      AppMethodBeat.o(42696);
      return str;
    }
    if ((this.field_nickname == null) || (this.field_nickname.length() <= 0))
    {
      str = aaT();
      AppMethodBeat.o(42696);
      return str;
    }
    str = this.field_nickname;
    AppMethodBeat.o(42696);
    return str;
  }
  
  public final String aaS()
  {
    AppMethodBeat.i(42697);
    if ((this.field_conRemark != null) && (!this.field_conRemark.trim().equals("")))
    {
      str = this.field_conRemark;
      AppMethodBeat.o(42697);
      return str;
    }
    String str = aaR();
    AppMethodBeat.o(42697);
    return str;
  }
  
  public final String aaT()
  {
    AppMethodBeat.i(42698);
    String str = Tl();
    if (!bs.isNullOrNil(str))
    {
      AppMethodBeat.o(42698);
      return str;
    }
    str = sX(this.field_username);
    if ((str != null) && (str.length() != 0))
    {
      AppMethodBeat.o(42698);
      return str;
    }
    str = this.field_username;
    AppMethodBeat.o(42698);
    return str;
  }
  
  public final int aaU()
  {
    AppMethodBeat.i(42700);
    int i = super.getSource();
    AppMethodBeat.o(42700);
    return i;
  }
  
  public final int aac()
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
      if ((super.To() != null) && (!super.To().equals("")))
      {
        i = super.To().charAt(0);
        break;
      }
      if ((super.Tp() != null) && (!super.Tp().equals("")))
      {
        i = super.Tp().charAt(0);
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
  
  public final void aad()
  {
    AppMethodBeat.i(42670);
    setType(0);
    AppMethodBeat.o(42670);
  }
  
  public final void aae()
  {
    AppMethodBeat.i(42671);
    setType(this.field_type | 0x4);
    AppMethodBeat.o(42671);
  }
  
  public final void aaf()
  {
    AppMethodBeat.i(42672);
    setType(this.field_type | 0x1);
    AppMethodBeat.o(42672);
  }
  
  public final void aag()
  {
    AppMethodBeat.i(42673);
    ac.w("MicroMsg.RContact", "unSetContact!! user:%s oldType:%d [%s]", new Object[] { this.field_username, Integer.valueOf(this.field_type), bs.eWi() });
    setType(this.field_type & 0xFFFFFFFE);
    AppMethodBeat.o(42673);
  }
  
  public final void aah()
  {
    AppMethodBeat.i(42674);
    setType(this.field_type | 0x8);
    AppMethodBeat.o(42674);
  }
  
  public final void aai()
  {
    AppMethodBeat.i(42675);
    setType(this.field_type & 0xFFFFFFF7);
    AppMethodBeat.o(42675);
  }
  
  public final void aaj()
  {
    AppMethodBeat.i(42676);
    setType(this.field_type | 0x80000);
    AppMethodBeat.o(42676);
  }
  
  public final void aak()
  {
    AppMethodBeat.i(42677);
    setType(this.field_type & 0xFFF7FFFF);
    AppMethodBeat.o(42677);
  }
  
  public final void aal()
  {
    AppMethodBeat.i(42678);
    setType(this.field_type | 0x2);
    AppMethodBeat.o(42678);
  }
  
  public final void aam()
  {
    AppMethodBeat.i(42679);
    setType(this.field_type & 0xFFFFFFFD);
    AppMethodBeat.o(42679);
  }
  
  public final void aan()
  {
    AppMethodBeat.i(42680);
    setType(this.field_type & 0xFFFFF7FF);
    AppMethodBeat.o(42680);
  }
  
  public final void aao()
  {
    AppMethodBeat.i(42681);
    setType(this.field_type | 0x20);
    AppMethodBeat.o(42681);
  }
  
  public final void aap()
  {
    AppMethodBeat.i(42682);
    setType(this.field_type & 0xFFFFFFDF);
    AppMethodBeat.o(42682);
  }
  
  public final void aaq()
  {
    AppMethodBeat.i(42683);
    setType(this.field_type | 0x40);
    AppMethodBeat.o(42683);
  }
  
  public final void aar()
  {
    AppMethodBeat.i(42684);
    setType(this.field_type & 0xFFFFFFBF);
    AppMethodBeat.o(42684);
  }
  
  public final void aas()
  {
    AppMethodBeat.i(42685);
    setType(this.field_type | 0x200);
    AppMethodBeat.o(42685);
  }
  
  public final void aat()
  {
    AppMethodBeat.i(42686);
    setType(this.field_type & 0xFFFFFDFF);
    AppMethodBeat.o(42686);
  }
  
  public final void aau()
  {
    AppMethodBeat.i(42687);
    setType(this.field_type | 0x100);
    AppMethodBeat.o(42687);
  }
  
  public final void aav()
  {
    AppMethodBeat.i(42688);
    setType(this.field_type & 0xFFFFFEFF);
    AppMethodBeat.o(42688);
  }
  
  public final void aaw()
  {
    AppMethodBeat.i(42689);
    setType(this.field_type | 0x800000);
    AppMethodBeat.o(42689);
  }
  
  public final void aax()
  {
    AppMethodBeat.i(42690);
    setType(this.field_type & 0xFF7FFFFF);
    AppMethodBeat.o(42690);
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(42703);
    super.convertFrom(paramCursor);
    this.fLJ = this.systemRowid;
    super.M(null);
    AppMethodBeat.o(42703);
  }
  
  public c.a getDBInfo()
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
  
  public final boolean isHidden()
  {
    return (this.field_type & 0x20) != 0;
  }
  
  public final void jB(int paramInt)
  {
    AppMethodBeat.i(42711);
    if (!bs.jl(this.field_showHead, paramInt))
    {
      super.jB(paramInt);
      aaV();
    }
    AppMethodBeat.o(42711);
  }
  
  public final void jC(int paramInt)
  {
    AppMethodBeat.i(42713);
    if (!bs.jl(this.field_weiboFlag, paramInt))
    {
      super.jC(paramInt);
      aaV();
    }
    AppMethodBeat.o(42713);
  }
  
  public final void jD(int paramInt)
  {
    AppMethodBeat.i(42718);
    if (!bs.jl(this.field_verifyFlag, paramInt))
    {
      super.jD(paramInt);
      aaV();
    }
    AppMethodBeat.o(42718);
  }
  
  public final void jE(int paramInt)
  {
    AppMethodBeat.i(42720);
    if (!bs.jl(this.field_chatroomFlag, paramInt))
    {
      super.jE(paramInt);
      aaV();
    }
    AppMethodBeat.o(42720);
  }
  
  public final void jF(int paramInt)
  {
    AppMethodBeat.i(42721);
    if (!bs.jl(this.field_deleteFlag, paramInt))
    {
      super.jF(paramInt);
      aaV();
    }
    AppMethodBeat.o(42721);
  }
  
  public final void jG(int paramInt)
  {
    AppMethodBeat.i(42723);
    if (!bs.jl(this.exK, paramInt))
    {
      super.jG(paramInt);
      aaV();
    }
    AppMethodBeat.o(42723);
  }
  
  public final void jH(int paramInt)
  {
    AppMethodBeat.i(42724);
    if (!bs.jl(this.exL, paramInt))
    {
      super.jH(paramInt);
      aaV();
    }
    AppMethodBeat.o(42724);
  }
  
  public final void jI(int paramInt)
  {
    AppMethodBeat.i(42730);
    if (!bs.jl(this.exP, paramInt))
    {
      super.jI(paramInt);
      aaV();
    }
    AppMethodBeat.o(42730);
  }
  
  public final void jJ(int paramInt)
  {
    AppMethodBeat.i(42731);
    if (!bs.jl(this.exQ, paramInt))
    {
      super.jJ(paramInt);
      aaV();
    }
    AppMethodBeat.o(42731);
  }
  
  public final void jK(int paramInt)
  {
    AppMethodBeat.i(42734);
    if (!bs.jl(this.exT, paramInt))
    {
      super.jK(paramInt);
      aaV();
    }
    AppMethodBeat.o(42734);
  }
  
  public final void jL(int paramInt)
  {
    AppMethodBeat.i(42735);
    if (!bs.jl(this.exU, paramInt))
    {
      super.jL(paramInt);
      aaV();
    }
    AppMethodBeat.o(42735);
  }
  
  public final void jM(int paramInt)
  {
    AppMethodBeat.i(42745);
    if (!bs.jl(this.eyc, paramInt))
    {
      super.jM(paramInt);
      aaV();
    }
    AppMethodBeat.o(42745);
  }
  
  public final void jN(int paramInt)
  {
    AppMethodBeat.i(42746);
    if (!bs.jl(this.eyd, paramInt))
    {
      super.jN(paramInt);
      aaV();
    }
    AppMethodBeat.o(42746);
  }
  
  public final void lo(int paramInt)
  {
    AppMethodBeat.i(42702);
    jE(this.field_chatroomFlag & 0xFFFFFFFE | paramInt & 0x1);
    AppMethodBeat.o(42702);
  }
  
  public final void or(long paramLong)
  {
    AppMethodBeat.i(42726);
    if (!bs.av(this.exN, paramLong))
    {
      super.or(paramLong);
      aaV();
    }
    AppMethodBeat.o(42726);
  }
  
  public final void os(long paramLong)
  {
    AppMethodBeat.i(163506);
    if (!bs.av(this.eyr, paramLong))
    {
      super.os(paramLong);
      aaV();
    }
    AppMethodBeat.o(163506);
  }
  
  public final void ot(long paramLong)
  {
    AppMethodBeat.i(178862);
    if (!bs.av(this.eys, paramLong))
    {
      super.ot(paramLong);
      aaV();
    }
    AppMethodBeat.o(178862);
  }
  
  public final void qA(String paramString)
  {
    AppMethodBeat.i(42736);
    if (!bs.lr(this.signature, paramString))
    {
      super.qA(paramString);
      aaV();
    }
    AppMethodBeat.o(42736);
  }
  
  public void qB(String paramString)
  {
    AppMethodBeat.i(42737);
    if (!bs.lr(getProvince(), paramString))
    {
      super.qB(paramString);
      aaV();
    }
    AppMethodBeat.o(42737);
  }
  
  public void qC(String paramString)
  {
    AppMethodBeat.i(42738);
    if (!bs.lr(getCity(), paramString))
    {
      super.qC(paramString);
      aaV();
    }
    AppMethodBeat.o(42738);
  }
  
  public final void qD(String paramString)
  {
    AppMethodBeat.i(42739);
    if (!bs.lr(this.exX, paramString))
    {
      super.qD(paramString);
      aaV();
    }
    AppMethodBeat.o(42739);
  }
  
  public final void qE(String paramString)
  {
    AppMethodBeat.i(42742);
    if (!bs.lr(this.exZ, paramString))
    {
      super.qE(paramString);
      aaV();
    }
    AppMethodBeat.o(42742);
  }
  
  public final void qF(String paramString)
  {
    AppMethodBeat.i(42743);
    if (!bs.lr(this.eya, paramString))
    {
      super.qF(paramString);
      aaV();
    }
    AppMethodBeat.o(42743);
  }
  
  public void qG(String paramString)
  {
    AppMethodBeat.i(42744);
    if (!bs.lr(this.eyb, paramString))
    {
      super.qG(paramString);
      aaV();
    }
    AppMethodBeat.o(42744);
  }
  
  public final void qH(String paramString)
  {
    AppMethodBeat.i(42747);
    if (!bs.lr(this.eyf, paramString))
    {
      super.qH(paramString);
      aaV();
    }
    AppMethodBeat.o(42747);
  }
  
  public final void qI(String paramString)
  {
    AppMethodBeat.i(42748);
    if (!bs.lr(this.eyg, paramString))
    {
      super.qI(paramString);
      aaV();
    }
    AppMethodBeat.o(42748);
  }
  
  public final void qJ(String paramString)
  {
    AppMethodBeat.i(42749);
    if (!bs.lr(this.eyh, paramString))
    {
      super.qJ(paramString);
      aaV();
    }
    AppMethodBeat.o(42749);
  }
  
  public final void qK(String paramString)
  {
    AppMethodBeat.i(42750);
    if (!bs.lr(this.eyi, paramString))
    {
      super.qK(paramString);
      aaV();
    }
    AppMethodBeat.o(42750);
  }
  
  public final void qL(String paramString)
  {
    AppMethodBeat.i(42751);
    if (!bs.lr(this.eyj, paramString))
    {
      super.qL(paramString);
      aaV();
    }
    AppMethodBeat.o(42751);
  }
  
  public final void qM(String paramString)
  {
    AppMethodBeat.i(42752);
    if (!bs.lr(this.eyk, paramString))
    {
      super.qM(paramString);
      aaV();
    }
    AppMethodBeat.o(42752);
  }
  
  public final void qN(String paramString)
  {
    AppMethodBeat.i(42753);
    if (!bs.lr(this.eyl, paramString))
    {
      super.qN(paramString);
      aaV();
    }
    AppMethodBeat.o(42753);
  }
  
  public final void qO(String paramString)
  {
    AppMethodBeat.i(42754);
    if (!bs.lr(this.eym, paramString))
    {
      super.qO(paramString);
      aaV();
    }
    AppMethodBeat.o(42754);
  }
  
  public final void qg(String paramString)
  {
    AppMethodBeat.i(42705);
    if (!bs.lr(Tl(), paramString))
    {
      super.qg(paramString);
      aaV();
    }
    AppMethodBeat.o(42705);
  }
  
  public final void qh(String paramString)
  {
    AppMethodBeat.i(42706);
    if (!bs.lr(this.field_conRemark, paramString))
    {
      super.qh(paramString);
      aaV();
    }
    AppMethodBeat.o(42706);
  }
  
  public final void qi(String paramString)
  {
    AppMethodBeat.i(42707);
    if (!bs.lr(this.field_domainList, paramString))
    {
      super.qi(paramString);
      aaV();
    }
    AppMethodBeat.o(42707);
  }
  
  public final void qj(String paramString)
  {
    AppMethodBeat.i(42708);
    if (!bs.lr(this.field_nickname, paramString))
    {
      super.qj(paramString);
      aaV();
    }
    AppMethodBeat.o(42708);
  }
  
  public final void qk(String paramString)
  {
    AppMethodBeat.i(42709);
    if (!bs.lr(To(), paramString))
    {
      super.qk(paramString);
      aaV();
    }
    AppMethodBeat.o(42709);
  }
  
  public final void ql(String paramString)
  {
    AppMethodBeat.i(42710);
    if (!bs.lr(Tp(), paramString))
    {
      super.ql(paramString);
      aaV();
    }
    AppMethodBeat.o(42710);
  }
  
  public final void qm(String paramString)
  {
    AppMethodBeat.i(42714);
    if (!bs.lr(this.field_weiboNickname, paramString))
    {
      super.qm(paramString);
      aaV();
    }
    AppMethodBeat.o(42714);
  }
  
  public final void qn(String paramString)
  {
    AppMethodBeat.i(42715);
    if (!bs.lr(this.field_conRemarkPYFull, paramString))
    {
      super.qn(paramString);
      aaV();
    }
    AppMethodBeat.o(42715);
  }
  
  public final void qo(String paramString)
  {
    AppMethodBeat.i(42716);
    if (!bs.lr(this.field_conRemarkPYShort, paramString))
    {
      super.qo(paramString);
      aaV();
    }
    AppMethodBeat.o(42716);
  }
  
  public final void qp(String paramString)
  {
    AppMethodBeat.i(42719);
    if (!bs.lr(this.field_encryptUsername, paramString))
    {
      super.qp(paramString);
      aaV();
    }
    AppMethodBeat.o(42719);
  }
  
  public final void qq(String paramString)
  {
    AppMethodBeat.i(42722);
    if (!bs.lr(this.field_contactLabelIds, paramString))
    {
      super.qq(paramString);
      aaV();
    }
    AppMethodBeat.o(42722);
  }
  
  public final void qs(String paramString)
  {
    AppMethodBeat.i(42755);
    if (!bs.lr(this.field_openImAppid, paramString))
    {
      super.qs(paramString);
      aaV();
    }
    AppMethodBeat.o(42755);
  }
  
  public final void qt(String paramString)
  {
    AppMethodBeat.i(42756);
    if (!bs.lr(this.field_sourceExtInfo, paramString))
    {
      super.qt(paramString);
      aaV();
    }
    AppMethodBeat.o(42756);
  }
  
  public final void qu(String paramString)
  {
    AppMethodBeat.i(42757);
    if (!bs.lr(this.field_ticket, paramString))
    {
      super.qu(paramString);
      aaV();
    }
    AppMethodBeat.o(42757);
  }
  
  public final void qv(String paramString)
  {
    AppMethodBeat.i(42725);
    if (!bs.lr(this.exM, paramString))
    {
      super.qv(paramString);
      aaV();
    }
    AppMethodBeat.o(42725);
  }
  
  public final void qw(String paramString)
  {
    AppMethodBeat.i(42728);
    if (!bs.lr(this.exO, paramString))
    {
      super.qw(paramString);
      aaV();
    }
    AppMethodBeat.o(42728);
  }
  
  public final void qx(String paramString)
  {
    AppMethodBeat.i(42729);
    if (!bs.lr(this.dnz, paramString))
    {
      super.qx(paramString);
      aaV();
    }
    AppMethodBeat.o(42729);
  }
  
  public final void qy(String paramString)
  {
    AppMethodBeat.i(42732);
    if (!bs.lr(this.exR, paramString))
    {
      super.qy(paramString);
      aaV();
    }
    AppMethodBeat.o(42732);
  }
  
  public final void qz(String paramString)
  {
    AppMethodBeat.i(42733);
    if (!bs.lr(this.exS, paramString))
    {
      super.qz(paramString);
      aaV();
    }
    AppMethodBeat.o(42733);
  }
  
  public final void setFromType(int paramInt)
  {
    AppMethodBeat.i(42740);
    if (!bs.jl(this.exY, paramInt))
    {
      super.setFromType(paramInt);
      aaV();
    }
    AppMethodBeat.o(42740);
  }
  
  public final void setSource(int paramInt)
  {
    AppMethodBeat.i(42741);
    if (!bs.jl(super.getSource(), paramInt))
    {
      super.setSource(paramInt);
      aaV();
    }
    AppMethodBeat.o(42741);
  }
  
  public final void setType(int paramInt)
  {
    AppMethodBeat.i(42712);
    if (!bs.jl(this.field_type, paramInt))
    {
      super.setType(paramInt);
      aaV();
    }
    AppMethodBeat.o(42712);
  }
  
  public final void setUin(int paramInt)
  {
    AppMethodBeat.i(42727);
    if (!bs.jl(this.uin, paramInt))
    {
      super.setUin(paramInt);
      aaV();
    }
    AppMethodBeat.o(42727);
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(42704);
    if (!bs.lr(this.field_username, paramString))
    {
      super.setUsername(paramString);
      aaV();
    }
    AppMethodBeat.o(42704);
  }
  
  public static abstract interface a
  {
    public abstract String eH(String paramString);
    
    public abstract String eI(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.n.b
 * JD-Core Version:    0.7.0.1
 */