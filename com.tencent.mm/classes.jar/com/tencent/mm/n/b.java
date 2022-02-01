package com.tencent.mm.n;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.g.c.au;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.reflect.Field;
import java.util.Map;

public class b
  extends au
{
  private static a fIe;
  public static c.a info;
  public long fId;
  public int versionCode;
  
  static
  {
    AppMethodBeat.i(42758);
    c.a locala = new c.a();
    locala.EYt = new Field[23];
    locala.columns = new String[24];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.EYv.put("username", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "username";
    locala.columns[1] = "alias";
    locala.EYv.put("alias", "TEXT default '' ");
    localStringBuilder.append(" alias TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "conRemark";
    locala.EYv.put("conRemark", "TEXT default '' ");
    localStringBuilder.append(" conRemark TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "domainList";
    locala.EYv.put("domainList", "TEXT default '' ");
    localStringBuilder.append(" domainList TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "nickname";
    locala.EYv.put("nickname", "TEXT default '' ");
    localStringBuilder.append(" nickname TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "pyInitial";
    locala.EYv.put("pyInitial", "TEXT default '' ");
    localStringBuilder.append(" pyInitial TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "quanPin";
    locala.EYv.put("quanPin", "TEXT default '' ");
    localStringBuilder.append(" quanPin TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "showHead";
    locala.EYv.put("showHead", "INTEGER default '0' ");
    localStringBuilder.append(" showHead INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "type";
    locala.EYv.put("type", "INTEGER default '0' ");
    localStringBuilder.append(" type INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "weiboFlag";
    locala.EYv.put("weiboFlag", "INTEGER default '0' ");
    localStringBuilder.append(" weiboFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "weiboNickname";
    locala.EYv.put("weiboNickname", "TEXT default '' ");
    localStringBuilder.append(" weiboNickname TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "conRemarkPYFull";
    locala.EYv.put("conRemarkPYFull", "TEXT default '' ");
    localStringBuilder.append(" conRemarkPYFull TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "conRemarkPYShort";
    locala.EYv.put("conRemarkPYShort", "TEXT default '' ");
    localStringBuilder.append(" conRemarkPYShort TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "lvbuff";
    locala.EYv.put("lvbuff", "BLOB");
    localStringBuilder.append(" lvbuff BLOB");
    localStringBuilder.append(", ");
    locala.columns[14] = "verifyFlag";
    locala.EYv.put("verifyFlag", "INTEGER default '0' ");
    localStringBuilder.append(" verifyFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[15] = "encryptUsername";
    locala.EYv.put("encryptUsername", "TEXT default '' ");
    localStringBuilder.append(" encryptUsername TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[16] = "chatroomFlag";
    locala.EYv.put("chatroomFlag", "INTEGER");
    localStringBuilder.append(" chatroomFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[17] = "deleteFlag";
    locala.EYv.put("deleteFlag", "INTEGER default '0' ");
    localStringBuilder.append(" deleteFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "contactLabelIds";
    locala.EYv.put("contactLabelIds", "TEXT default '' ");
    localStringBuilder.append(" contactLabelIds TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[19] = "descWordingId";
    locala.EYv.put("descWordingId", "TEXT default '' ");
    localStringBuilder.append(" descWordingId TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[20] = "openImAppid";
    locala.EYv.put("openImAppid", "TEXT");
    localStringBuilder.append(" openImAppid TEXT");
    localStringBuilder.append(", ");
    locala.columns[21] = "sourceExtInfo";
    locala.EYv.put("sourceExtInfo", "TEXT");
    localStringBuilder.append(" sourceExtInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[22] = "ticket";
    locala.EYv.put("ticket", "TEXT default '' ");
    localStringBuilder.append(" ticket TEXT default '' ");
    locala.columns[23] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    fIe = null;
    AppMethodBeat.o(42758);
  }
  
  public b()
  {
    AppMethodBeat.i(42667);
    this.versionCode = 0;
    super.setUsername("");
    super.nd("");
    super.ne("");
    super.nf("");
    super.na("");
    super.nb("");
    super.ni("");
    super.nh("");
    super.nc("");
    super.jE(0);
    super.ng("");
    super.jD(0);
    super.setType(0);
    super.jF(0);
    super.jG(0);
    super.nk("");
    super.jJ(0);
    super.nx("");
    super.setFromType(0);
    super.setUin(0);
    super.nq("");
    super.nr("");
    super.jK(0);
    super.jL(0);
    super.ns("");
    super.nt("");
    super.jM(1);
    super.jI(0);
    super.jN(0);
    super.nu("");
    super.nv("");
    super.nw("");
    super.setSource(0);
    super.nz("");
    super.ny("");
    super.kP(0L);
    super.np("");
    super.nA("");
    super.jO(0);
    super.nD("");
    super.nE("");
    super.nF("");
    super.nI("");
    super.nl("");
    super.nm("");
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
  
  public static int ZD()
  {
    return 1;
  }
  
  public static int ZE()
  {
    return 8;
  }
  
  public static int ZF()
  {
    return 524288;
  }
  
  public static int ZG()
  {
    return 8388608;
  }
  
  public static int ZH()
  {
    return 16;
  }
  
  public static int ZI()
  {
    return 32;
  }
  
  public static void a(a parama)
  {
    fIe = parama;
  }
  
  private int aaa()
  {
    int i = this.versionCode + 1;
    this.versionCode = i;
    return i;
  }
  
  private static boolean isLetter(char paramChar)
  {
    return ((paramChar >= 'A') && (paramChar <= 'Z')) || ((paramChar >= 'a') && (paramChar <= 'z'));
  }
  
  public static boolean ls(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public static String pL(String paramString)
  {
    AppMethodBeat.i(42668);
    if (fIe != null)
    {
      paramString = fIe.eR(paramString);
      AppMethodBeat.o(42668);
      return paramString;
    }
    AppMethodBeat.o(42668);
    return null;
  }
  
  private static String pM(String paramString)
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
    AppMethodBeat.o(42701);
    return paramString;
  }
  
  public final boolean Ny()
  {
    return (this.field_type & 0x200) != 0;
  }
  
  public final void O(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(42717);
    if (!bt.isEqual(this.field_lvbuff, paramArrayOfByte))
    {
      super.O(paramArrayOfByte);
      aaa();
    }
    AppMethodBeat.o(42717);
  }
  
  public final String Ss()
  {
    AppMethodBeat.i(42695);
    if (fIe != null) {}
    for (String str = fIe.eS(this.field_username); str == null; str = null)
    {
      str = super.Ss();
      AppMethodBeat.o(42695);
      return str;
    }
    AppMethodBeat.o(42695);
    return str;
  }
  
  public final String Sv()
  {
    AppMethodBeat.i(42693);
    if ((super.Sv() == null) || (super.Sv().length() < 0))
    {
      str = Sw();
      AppMethodBeat.o(42693);
      return str;
    }
    String str = super.Sv();
    AppMethodBeat.o(42693);
    return str;
  }
  
  public final String Sw()
  {
    AppMethodBeat.i(42694);
    if ((super.Sw() == null) || (super.Sw().length() < 0))
    {
      str = this.field_nickname;
      AppMethodBeat.o(42694);
      return str;
    }
    String str = super.Sw();
    AppMethodBeat.o(42694);
    return str;
  }
  
  public final boolean VG()
  {
    return (this.field_type & 0x400) == 0;
  }
  
  public final void ZA()
  {
    AppMethodBeat.i(42688);
    setType(this.field_type & 0xFFFFFEFF);
    AppMethodBeat.o(42688);
  }
  
  public final void ZB()
  {
    AppMethodBeat.i(42689);
    setType(this.field_type | 0x800000);
    AppMethodBeat.o(42689);
  }
  
  public final void ZC()
  {
    AppMethodBeat.i(42690);
    setType(this.field_type & 0xFF7FFFFF);
    AppMethodBeat.o(42690);
  }
  
  public final boolean ZJ()
  {
    AppMethodBeat.i(197133);
    boolean bool = ls(this.field_type);
    AppMethodBeat.o(197133);
    return bool;
  }
  
  public final boolean ZK()
  {
    return (this.field_type & 0x2) != 0;
  }
  
  public final boolean ZL()
  {
    return (this.field_type & 0x4) != 0;
  }
  
  public final boolean ZM()
  {
    return (this.field_type & 0x8) != 0;
  }
  
  public final boolean ZN()
  {
    return (0x80000 & this.field_type) != 0;
  }
  
  public final boolean ZO()
  {
    return (this.field_type & 0x40) != 0;
  }
  
  public final boolean ZP()
  {
    return (this.field_type & 0x100) != 0;
  }
  
  public final boolean ZQ()
  {
    return (0x10000 & this.field_type) != 0;
  }
  
  public final boolean ZR()
  {
    return (0x800000 & this.field_type) != 0;
  }
  
  public final boolean ZS()
  {
    return (this.field_type & 0x800) != 0;
  }
  
  public final boolean ZT()
  {
    return (0x8000 & this.field_type) != 0;
  }
  
  public final void ZU()
  {
    AppMethodBeat.i(42692);
    setType(this.field_type | 0x8000);
    AppMethodBeat.o(42692);
  }
  
  public final int ZV()
  {
    return (int)this.fId;
  }
  
  public final String ZW()
  {
    AppMethodBeat.i(42696);
    if (fIe != null) {}
    for (String str = fIe.eR(this.field_username); str != null; str = null)
    {
      AppMethodBeat.o(42696);
      return str;
    }
    if ((this.field_nickname == null) || (this.field_nickname.length() <= 0))
    {
      str = ZY();
      AppMethodBeat.o(42696);
      return str;
    }
    str = this.field_nickname;
    AppMethodBeat.o(42696);
    return str;
  }
  
  public final String ZX()
  {
    AppMethodBeat.i(42697);
    if ((this.field_conRemark != null) && (!this.field_conRemark.trim().equals("")))
    {
      str = this.field_conRemark;
      AppMethodBeat.o(42697);
      return str;
    }
    String str = ZW();
    AppMethodBeat.o(42697);
    return str;
  }
  
  public final String ZY()
  {
    AppMethodBeat.i(42698);
    String str = Ss();
    if (!bt.isNullOrNil(str))
    {
      AppMethodBeat.o(42698);
      return str;
    }
    str = pM(this.field_username);
    if ((str != null) && (str.length() != 0))
    {
      AppMethodBeat.o(42698);
      return str;
    }
    str = this.field_username;
    AppMethodBeat.o(42698);
    return str;
  }
  
  public final int ZZ()
  {
    AppMethodBeat.i(42700);
    int i = super.getSource();
    AppMethodBeat.o(42700);
    return i;
  }
  
  public final int Zh()
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
      if ((super.Sv() != null) && (!super.Sv().equals("")))
      {
        i = super.Sv().charAt(0);
        break;
      }
      if ((super.Sw() != null) && (!super.Sw().equals("")))
      {
        i = super.Sw().charAt(0);
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
  
  public final void Zi()
  {
    AppMethodBeat.i(42670);
    setType(0);
    AppMethodBeat.o(42670);
  }
  
  public final void Zj()
  {
    AppMethodBeat.i(42671);
    setType(this.field_type | 0x4);
    AppMethodBeat.o(42671);
  }
  
  public final void Zk()
  {
    AppMethodBeat.i(42672);
    setType(this.field_type | 0x1);
    AppMethodBeat.o(42672);
  }
  
  public final void Zl()
  {
    AppMethodBeat.i(42673);
    ad.w("MicroMsg.RContact", "unSetContact!! user:%s oldType:%d [%s]", new Object[] { this.field_username, Integer.valueOf(this.field_type), bt.eGN() });
    setType(this.field_type & 0xFFFFFFFE);
    AppMethodBeat.o(42673);
  }
  
  public final void Zm()
  {
    AppMethodBeat.i(42674);
    setType(this.field_type | 0x8);
    AppMethodBeat.o(42674);
  }
  
  public final void Zn()
  {
    AppMethodBeat.i(42675);
    setType(this.field_type & 0xFFFFFFF7);
    AppMethodBeat.o(42675);
  }
  
  public final void Zo()
  {
    AppMethodBeat.i(42676);
    setType(this.field_type | 0x80000);
    AppMethodBeat.o(42676);
  }
  
  public final void Zp()
  {
    AppMethodBeat.i(42677);
    setType(this.field_type & 0xFFF7FFFF);
    AppMethodBeat.o(42677);
  }
  
  public final void Zq()
  {
    AppMethodBeat.i(42678);
    setType(this.field_type | 0x2);
    AppMethodBeat.o(42678);
  }
  
  public final void Zr()
  {
    AppMethodBeat.i(42679);
    setType(this.field_type & 0xFFFFFFFD);
    AppMethodBeat.o(42679);
  }
  
  public final void Zs()
  {
    AppMethodBeat.i(42680);
    setType(this.field_type & 0xFFFFF7FF);
    AppMethodBeat.o(42680);
  }
  
  public final void Zt()
  {
    AppMethodBeat.i(42681);
    setType(this.field_type | 0x20);
    AppMethodBeat.o(42681);
  }
  
  public final void Zu()
  {
    AppMethodBeat.i(42682);
    setType(this.field_type & 0xFFFFFFDF);
    AppMethodBeat.o(42682);
  }
  
  public final void Zv()
  {
    AppMethodBeat.i(42683);
    setType(this.field_type | 0x40);
    AppMethodBeat.o(42683);
  }
  
  public final void Zw()
  {
    AppMethodBeat.i(42684);
    setType(this.field_type & 0xFFFFFFBF);
    AppMethodBeat.o(42684);
  }
  
  public final void Zx()
  {
    AppMethodBeat.i(42685);
    setType(this.field_type | 0x200);
    AppMethodBeat.o(42685);
  }
  
  public final void Zy()
  {
    AppMethodBeat.i(42686);
    setType(this.field_type & 0xFFFFFDFF);
    AppMethodBeat.o(42686);
  }
  
  public final void Zz()
  {
    AppMethodBeat.i(42687);
    setType(this.field_type | 0x100);
    AppMethodBeat.o(42687);
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(42703);
    super.convertFrom(paramCursor);
    this.fId = this.systemRowid;
    super.O(null);
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
  
  public final void jD(int paramInt)
  {
    AppMethodBeat.i(42711);
    if (!bt.iY(this.field_showHead, paramInt))
    {
      super.jD(paramInt);
      aaa();
    }
    AppMethodBeat.o(42711);
  }
  
  public final void jE(int paramInt)
  {
    AppMethodBeat.i(42713);
    if (!bt.iY(this.field_weiboFlag, paramInt))
    {
      super.jE(paramInt);
      aaa();
    }
    AppMethodBeat.o(42713);
  }
  
  public final void jF(int paramInt)
  {
    AppMethodBeat.i(42718);
    if (!bt.iY(this.field_verifyFlag, paramInt))
    {
      super.jF(paramInt);
      aaa();
    }
    AppMethodBeat.o(42718);
  }
  
  public final void jG(int paramInt)
  {
    AppMethodBeat.i(42720);
    if (!bt.iY(this.field_chatroomFlag, paramInt))
    {
      super.jG(paramInt);
      aaa();
    }
    AppMethodBeat.o(42720);
  }
  
  public final void jH(int paramInt)
  {
    AppMethodBeat.i(42721);
    if (!bt.iY(this.field_deleteFlag, paramInt))
    {
      super.jH(paramInt);
      aaa();
    }
    AppMethodBeat.o(42721);
  }
  
  public final void jI(int paramInt)
  {
    AppMethodBeat.i(42723);
    if (!bt.iY(this.evo, paramInt))
    {
      super.jI(paramInt);
      aaa();
    }
    AppMethodBeat.o(42723);
  }
  
  public final void jJ(int paramInt)
  {
    AppMethodBeat.i(42724);
    if (!bt.iY(this.evp, paramInt))
    {
      super.jJ(paramInt);
      aaa();
    }
    AppMethodBeat.o(42724);
  }
  
  public final void jK(int paramInt)
  {
    AppMethodBeat.i(42730);
    if (!bt.iY(this.evt, paramInt))
    {
      super.jK(paramInt);
      aaa();
    }
    AppMethodBeat.o(42730);
  }
  
  public final void jL(int paramInt)
  {
    AppMethodBeat.i(42731);
    if (!bt.iY(this.evu, paramInt))
    {
      super.jL(paramInt);
      aaa();
    }
    AppMethodBeat.o(42731);
  }
  
  public final void jM(int paramInt)
  {
    AppMethodBeat.i(42734);
    if (!bt.iY(this.evx, paramInt))
    {
      super.jM(paramInt);
      aaa();
    }
    AppMethodBeat.o(42734);
  }
  
  public final void jN(int paramInt)
  {
    AppMethodBeat.i(42735);
    if (!bt.iY(this.evy, paramInt))
    {
      super.jN(paramInt);
      aaa();
    }
    AppMethodBeat.o(42735);
  }
  
  public final void jO(int paramInt)
  {
    AppMethodBeat.i(42745);
    if (!bt.iY(this.evG, paramInt))
    {
      super.jO(paramInt);
      aaa();
    }
    AppMethodBeat.o(42745);
  }
  
  public final void jP(int paramInt)
  {
    AppMethodBeat.i(42746);
    if (!bt.iY(this.evH, paramInt))
    {
      super.jP(paramInt);
      aaa();
    }
    AppMethodBeat.o(42746);
  }
  
  public final void kP(long paramLong)
  {
    AppMethodBeat.i(42726);
    if (!bt.aw(this.evr, paramLong))
    {
      super.kP(paramLong);
      aaa();
    }
    AppMethodBeat.o(42726);
  }
  
  public final void kQ(long paramLong)
  {
    AppMethodBeat.i(163506);
    if (!bt.aw(this.evU, paramLong))
    {
      super.kQ(paramLong);
      aaa();
    }
    AppMethodBeat.o(163506);
  }
  
  public final void kR(long paramLong)
  {
    AppMethodBeat.i(178862);
    if (!bt.aw(this.evV, paramLong))
    {
      super.kR(paramLong);
      aaa();
    }
    AppMethodBeat.o(178862);
  }
  
  public final void lt(int paramInt)
  {
    AppMethodBeat.i(42702);
    jG(this.field_chatroomFlag & 0xFFFFFFFE | paramInt & 0x1);
    AppMethodBeat.o(42702);
  }
  
  public void nA(String paramString)
  {
    AppMethodBeat.i(42744);
    if (!bt.kU(this.evF, paramString))
    {
      super.nA(paramString);
      aaa();
    }
    AppMethodBeat.o(42744);
  }
  
  public final void nB(String paramString)
  {
    AppMethodBeat.i(42747);
    if (!bt.kU(this.evI, paramString))
    {
      super.nB(paramString);
      aaa();
    }
    AppMethodBeat.o(42747);
  }
  
  public final void nC(String paramString)
  {
    AppMethodBeat.i(42748);
    if (!bt.kU(this.evJ, paramString))
    {
      super.nC(paramString);
      aaa();
    }
    AppMethodBeat.o(42748);
  }
  
  public final void nD(String paramString)
  {
    AppMethodBeat.i(42749);
    if (!bt.kU(this.evK, paramString))
    {
      super.nD(paramString);
      aaa();
    }
    AppMethodBeat.o(42749);
  }
  
  public final void nE(String paramString)
  {
    AppMethodBeat.i(42750);
    if (!bt.kU(this.evL, paramString))
    {
      super.nE(paramString);
      aaa();
    }
    AppMethodBeat.o(42750);
  }
  
  public final void nF(String paramString)
  {
    AppMethodBeat.i(42751);
    if (!bt.kU(this.evM, paramString))
    {
      super.nF(paramString);
      aaa();
    }
    AppMethodBeat.o(42751);
  }
  
  public final void nG(String paramString)
  {
    AppMethodBeat.i(42752);
    if (!bt.kU(this.evN, paramString))
    {
      super.nG(paramString);
      aaa();
    }
    AppMethodBeat.o(42752);
  }
  
  public final void nH(String paramString)
  {
    AppMethodBeat.i(42753);
    if (!bt.kU(this.evO, paramString))
    {
      super.nH(paramString);
      aaa();
    }
    AppMethodBeat.o(42753);
  }
  
  public final void nI(String paramString)
  {
    AppMethodBeat.i(42754);
    if (!bt.kU(this.evP, paramString))
    {
      super.nI(paramString);
      aaa();
    }
    AppMethodBeat.o(42754);
  }
  
  public final void na(String paramString)
  {
    AppMethodBeat.i(42705);
    if (!bt.kU(Ss(), paramString))
    {
      super.na(paramString);
      aaa();
    }
    AppMethodBeat.o(42705);
  }
  
  public final void nb(String paramString)
  {
    AppMethodBeat.i(42706);
    if (!bt.kU(this.field_conRemark, paramString))
    {
      super.nb(paramString);
      aaa();
    }
    AppMethodBeat.o(42706);
  }
  
  public final void nc(String paramString)
  {
    AppMethodBeat.i(42707);
    if (!bt.kU(this.field_domainList, paramString))
    {
      super.nc(paramString);
      aaa();
    }
    AppMethodBeat.o(42707);
  }
  
  public final void nd(String paramString)
  {
    AppMethodBeat.i(42708);
    if (!bt.kU(this.field_nickname, paramString))
    {
      super.nd(paramString);
      aaa();
    }
    AppMethodBeat.o(42708);
  }
  
  public final void ne(String paramString)
  {
    AppMethodBeat.i(42709);
    if (!bt.kU(Sv(), paramString))
    {
      super.ne(paramString);
      aaa();
    }
    AppMethodBeat.o(42709);
  }
  
  public final void nf(String paramString)
  {
    AppMethodBeat.i(42710);
    if (!bt.kU(Sw(), paramString))
    {
      super.nf(paramString);
      aaa();
    }
    AppMethodBeat.o(42710);
  }
  
  public final void ng(String paramString)
  {
    AppMethodBeat.i(42714);
    if (!bt.kU(this.field_weiboNickname, paramString))
    {
      super.ng(paramString);
      aaa();
    }
    AppMethodBeat.o(42714);
  }
  
  public final void nh(String paramString)
  {
    AppMethodBeat.i(42715);
    if (!bt.kU(this.field_conRemarkPYFull, paramString))
    {
      super.nh(paramString);
      aaa();
    }
    AppMethodBeat.o(42715);
  }
  
  public final void ni(String paramString)
  {
    AppMethodBeat.i(42716);
    if (!bt.kU(this.field_conRemarkPYShort, paramString))
    {
      super.ni(paramString);
      aaa();
    }
    AppMethodBeat.o(42716);
  }
  
  public final void nj(String paramString)
  {
    AppMethodBeat.i(42719);
    if (!bt.kU(this.field_encryptUsername, paramString))
    {
      super.nj(paramString);
      aaa();
    }
    AppMethodBeat.o(42719);
  }
  
  public final void nk(String paramString)
  {
    AppMethodBeat.i(42722);
    if (!bt.kU(this.field_contactLabelIds, paramString))
    {
      super.nk(paramString);
      aaa();
    }
    AppMethodBeat.o(42722);
  }
  
  public final void nm(String paramString)
  {
    AppMethodBeat.i(42755);
    if (!bt.kU(this.field_openImAppid, paramString))
    {
      super.nm(paramString);
      aaa();
    }
    AppMethodBeat.o(42755);
  }
  
  public final void nn(String paramString)
  {
    AppMethodBeat.i(42756);
    if (!bt.kU(this.field_sourceExtInfo, paramString))
    {
      super.nn(paramString);
      aaa();
    }
    AppMethodBeat.o(42756);
  }
  
  public final void no(String paramString)
  {
    AppMethodBeat.i(42757);
    if (!bt.kU(this.field_ticket, paramString))
    {
      super.no(paramString);
      aaa();
    }
    AppMethodBeat.o(42757);
  }
  
  public final void np(String paramString)
  {
    AppMethodBeat.i(42725);
    if (!bt.kU(this.evq, paramString))
    {
      super.np(paramString);
      aaa();
    }
    AppMethodBeat.o(42725);
  }
  
  public final void nq(String paramString)
  {
    AppMethodBeat.i(42728);
    if (!bt.kU(this.evs, paramString))
    {
      super.nq(paramString);
      aaa();
    }
    AppMethodBeat.o(42728);
  }
  
  public final void nr(String paramString)
  {
    AppMethodBeat.i(42729);
    if (!bt.kU(this.dpO, paramString))
    {
      super.nr(paramString);
      aaa();
    }
    AppMethodBeat.o(42729);
  }
  
  public final void ns(String paramString)
  {
    AppMethodBeat.i(42732);
    if (!bt.kU(this.evv, paramString))
    {
      super.ns(paramString);
      aaa();
    }
    AppMethodBeat.o(42732);
  }
  
  public final void nt(String paramString)
  {
    AppMethodBeat.i(42733);
    if (!bt.kU(this.evw, paramString))
    {
      super.nt(paramString);
      aaa();
    }
    AppMethodBeat.o(42733);
  }
  
  public final void nu(String paramString)
  {
    AppMethodBeat.i(42736);
    if (!bt.kU(this.signature, paramString))
    {
      super.nu(paramString);
      aaa();
    }
    AppMethodBeat.o(42736);
  }
  
  public void nv(String paramString)
  {
    AppMethodBeat.i(42737);
    if (!bt.kU(getProvince(), paramString))
    {
      super.nv(paramString);
      aaa();
    }
    AppMethodBeat.o(42737);
  }
  
  public void nw(String paramString)
  {
    AppMethodBeat.i(42738);
    if (!bt.kU(getCity(), paramString))
    {
      super.nw(paramString);
      aaa();
    }
    AppMethodBeat.o(42738);
  }
  
  public final void nx(String paramString)
  {
    AppMethodBeat.i(42739);
    if (!bt.kU(this.evB, paramString))
    {
      super.nx(paramString);
      aaa();
    }
    AppMethodBeat.o(42739);
  }
  
  public final void ny(String paramString)
  {
    AppMethodBeat.i(42742);
    if (!bt.kU(this.evD, paramString))
    {
      super.ny(paramString);
      aaa();
    }
    AppMethodBeat.o(42742);
  }
  
  public final void nz(String paramString)
  {
    AppMethodBeat.i(42743);
    if (!bt.kU(this.evE, paramString))
    {
      super.nz(paramString);
      aaa();
    }
    AppMethodBeat.o(42743);
  }
  
  public final void setFromType(int paramInt)
  {
    AppMethodBeat.i(42740);
    if (!bt.iY(this.evC, paramInt))
    {
      super.setFromType(paramInt);
      aaa();
    }
    AppMethodBeat.o(42740);
  }
  
  public final void setSource(int paramInt)
  {
    AppMethodBeat.i(42741);
    if (!bt.iY(super.getSource(), paramInt))
    {
      super.setSource(paramInt);
      aaa();
    }
    AppMethodBeat.o(42741);
  }
  
  public final void setType(int paramInt)
  {
    AppMethodBeat.i(42712);
    if (!bt.iY(this.field_type, paramInt))
    {
      super.setType(paramInt);
      aaa();
    }
    AppMethodBeat.o(42712);
  }
  
  public final void setUin(int paramInt)
  {
    AppMethodBeat.i(42727);
    if (!bt.iY(this.uin, paramInt))
    {
      super.setUin(paramInt);
      aaa();
    }
    AppMethodBeat.o(42727);
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(42704);
    if (!bt.kU(this.field_username, paramString))
    {
      super.setUsername(paramString);
      aaa();
    }
    AppMethodBeat.o(42704);
  }
  
  public static abstract interface a
  {
    public abstract String eR(String paramString);
    
    public abstract String eS(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.n.b
 * JD-Core Version:    0.7.0.1
 */