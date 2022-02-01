package com.tencent.mm.contact;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.reflect.Field;
import java.util.Map;

public class c
  extends aw
{
  private static a ghu;
  public static com.tencent.mm.sdk.e.c.a info;
  public long ght;
  public int versionCode;
  
  static
  {
    AppMethodBeat.i(42758);
    com.tencent.mm.sdk.e.c.a locala = new com.tencent.mm.sdk.e.c.a();
    locala.IBL = new Field[23];
    locala.columns = new String[24];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.IBN.put("username", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "username";
    locala.columns[1] = "alias";
    locala.IBN.put("alias", "TEXT default '' ");
    localStringBuilder.append(" alias TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "conRemark";
    locala.IBN.put("conRemark", "TEXT default '' ");
    localStringBuilder.append(" conRemark TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "domainList";
    locala.IBN.put("domainList", "TEXT default '' ");
    localStringBuilder.append(" domainList TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "nickname";
    locala.IBN.put("nickname", "TEXT default '' ");
    localStringBuilder.append(" nickname TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "pyInitial";
    locala.IBN.put("pyInitial", "TEXT default '' ");
    localStringBuilder.append(" pyInitial TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "quanPin";
    locala.IBN.put("quanPin", "TEXT default '' ");
    localStringBuilder.append(" quanPin TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "showHead";
    locala.IBN.put("showHead", "INTEGER default '0' ");
    localStringBuilder.append(" showHead INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "type";
    locala.IBN.put("type", "INTEGER default '0' ");
    localStringBuilder.append(" type INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "weiboFlag";
    locala.IBN.put("weiboFlag", "INTEGER default '0' ");
    localStringBuilder.append(" weiboFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "weiboNickname";
    locala.IBN.put("weiboNickname", "TEXT default '' ");
    localStringBuilder.append(" weiboNickname TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "conRemarkPYFull";
    locala.IBN.put("conRemarkPYFull", "TEXT default '' ");
    localStringBuilder.append(" conRemarkPYFull TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "conRemarkPYShort";
    locala.IBN.put("conRemarkPYShort", "TEXT default '' ");
    localStringBuilder.append(" conRemarkPYShort TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "lvbuff";
    locala.IBN.put("lvbuff", "BLOB");
    localStringBuilder.append(" lvbuff BLOB");
    localStringBuilder.append(", ");
    locala.columns[14] = "verifyFlag";
    locala.IBN.put("verifyFlag", "INTEGER default '0' ");
    localStringBuilder.append(" verifyFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[15] = "encryptUsername";
    locala.IBN.put("encryptUsername", "TEXT default '' ");
    localStringBuilder.append(" encryptUsername TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[16] = "chatroomFlag";
    locala.IBN.put("chatroomFlag", "INTEGER");
    localStringBuilder.append(" chatroomFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[17] = "deleteFlag";
    locala.IBN.put("deleteFlag", "INTEGER default '0' ");
    localStringBuilder.append(" deleteFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "contactLabelIds";
    locala.IBN.put("contactLabelIds", "TEXT default '' ");
    localStringBuilder.append(" contactLabelIds TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[19] = "descWordingId";
    locala.IBN.put("descWordingId", "TEXT default '' ");
    localStringBuilder.append(" descWordingId TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[20] = "openImAppid";
    locala.IBN.put("openImAppid", "TEXT");
    localStringBuilder.append(" openImAppid TEXT");
    localStringBuilder.append(", ");
    locala.columns[21] = "sourceExtInfo";
    locala.IBN.put("sourceExtInfo", "TEXT");
    localStringBuilder.append(" sourceExtInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[22] = "ticket";
    locala.IBN.put("ticket", "TEXT default '' ");
    localStringBuilder.append(" ticket TEXT default '' ");
    locala.columns[23] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    ghu = null;
    AppMethodBeat.o(42758);
  }
  
  public c()
  {
    AppMethodBeat.i(42667);
    this.versionCode = 0;
    super.setUsername("");
    super.to("");
    super.tp("");
    super.tq("");
    super.tl("");
    super.tm("");
    super.tt("");
    super.ts("");
    super.tn("");
    super.kc(0);
    super.tr("");
    super.kb(0);
    super.setType(0);
    super.kd(0);
    super.ke(0);
    super.tv("");
    super.kh(0);
    super.tI("");
    super.setFromType(0);
    super.setUin(0);
    super.tB("");
    super.tC("");
    super.ki(0);
    super.kj(0);
    super.tD("");
    super.tE("");
    super.kk(1);
    super.kg(0);
    super.kl(0);
    super.tF("");
    super.tG("");
    super.tH("");
    super.setSource(0);
    super.tK("");
    super.tJ("");
    super.qE(0L);
    super.tA("");
    super.tL("");
    super.km(0);
    super.tO("");
    super.tP("");
    super.tQ("");
    super.tT("");
    super.tw("");
    super.tx("");
    this.versionCode = 0;
    AppMethodBeat.o(42667);
  }
  
  public c(String paramString)
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
    ghu = parama;
  }
  
  private int adJ()
  {
    int i = this.versionCode + 1;
    this.versionCode = i;
    return i;
  }
  
  public static int adm()
  {
    return 1;
  }
  
  public static int adn()
  {
    return 8;
  }
  
  public static int ado()
  {
    return 524288;
  }
  
  public static int adp()
  {
    return 8388608;
  }
  
  public static int adq()
  {
    return 16;
  }
  
  public static int adr()
  {
    return 32;
  }
  
  private static boolean isLetter(char paramChar)
  {
    return ((paramChar >= 'A') && (paramChar <= 'Z')) || ((paramChar >= 'a') && (paramChar <= 'z'));
  }
  
  public static boolean lO(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public static String wh(String paramString)
  {
    AppMethodBeat.i(42668);
    if (ghu != null)
    {
      paramString = ghu.fI(paramString);
      AppMethodBeat.o(42668);
      return paramString;
    }
    AppMethodBeat.o(42668);
    return null;
  }
  
  private static String wi(String paramString)
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
  
  public final void L(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(42717);
    if (!bu.isEqual(this.field_lvbuff, paramArrayOfByte))
    {
      super.L(paramArrayOfByte);
      adJ();
    }
    AppMethodBeat.o(42717);
  }
  
  public final boolean Pd()
  {
    return (this.field_type & 0x200) != 0;
  }
  
  public final String VI()
  {
    AppMethodBeat.i(42695);
    if (ghu != null) {}
    for (String str = ghu.fJ(this.field_username); str == null; str = null)
    {
      str = super.VI();
      AppMethodBeat.o(42695);
      return str;
    }
    AppMethodBeat.o(42695);
    return str;
  }
  
  public final String VL()
  {
    AppMethodBeat.i(42693);
    if ((super.VL() == null) || (super.VL().length() < 0))
    {
      str = VM();
      AppMethodBeat.o(42693);
      return str;
    }
    String str = super.VL();
    AppMethodBeat.o(42693);
    return str;
  }
  
  public final String VM()
  {
    AppMethodBeat.i(42694);
    if ((super.VM() == null) || (super.VM().length() < 0))
    {
      str = this.field_nickname;
      AppMethodBeat.o(42694);
      return str;
    }
    String str = super.VM();
    AppMethodBeat.o(42694);
    return str;
  }
  
  public final boolean Zh()
  {
    return (this.field_type & 0x400) == 0;
  }
  
  public final int acP()
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
      if ((super.VL() != null) && (!super.VL().equals("")))
      {
        i = super.VL().charAt(0);
        break;
      }
      if ((super.VM() != null) && (!super.VM().equals("")))
      {
        i = super.VM().charAt(0);
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
  
  public final void acQ()
  {
    AppMethodBeat.i(42670);
    setType(0);
    AppMethodBeat.o(42670);
  }
  
  public final void acR()
  {
    AppMethodBeat.i(42671);
    setType(this.field_type | 0x4);
    AppMethodBeat.o(42671);
  }
  
  public final void acS()
  {
    AppMethodBeat.i(42672);
    setType(this.field_type | 0x1);
    AppMethodBeat.o(42672);
  }
  
  public final void acT()
  {
    AppMethodBeat.i(42673);
    ae.w("MicroMsg.RContact", "unSetContact!! user:%s oldType:%d [%s]", new Object[] { this.field_username, Integer.valueOf(this.field_type), bu.fpN() });
    setType(this.field_type & 0xFFFFFFFE);
    AppMethodBeat.o(42673);
  }
  
  public final void acU()
  {
    AppMethodBeat.i(42674);
    setType(this.field_type | 0x8);
    AppMethodBeat.o(42674);
  }
  
  public final void acV()
  {
    AppMethodBeat.i(42675);
    setType(this.field_type & 0xFFFFFFF7);
    AppMethodBeat.o(42675);
  }
  
  public final void acW()
  {
    AppMethodBeat.i(42676);
    setType(this.field_type | 0x80000);
    AppMethodBeat.o(42676);
  }
  
  public final void acX()
  {
    AppMethodBeat.i(42677);
    setType(this.field_type & 0xFFF7FFFF);
    AppMethodBeat.o(42677);
  }
  
  public final void acY()
  {
    AppMethodBeat.i(42678);
    setType(this.field_type | 0x2);
    AppMethodBeat.o(42678);
  }
  
  public final void acZ()
  {
    AppMethodBeat.i(42679);
    setType(this.field_type & 0xFFFFFFFD);
    AppMethodBeat.o(42679);
  }
  
  public final boolean adA()
  {
    return (0x800000 & this.field_type) != 0;
  }
  
  public final boolean adB()
  {
    return (this.field_type & 0x800) != 0;
  }
  
  public final boolean adC()
  {
    return (0x8000 & this.field_type) != 0;
  }
  
  public final void adD()
  {
    AppMethodBeat.i(42692);
    setType(this.field_type | 0x8000);
    AppMethodBeat.o(42692);
  }
  
  public final int adE()
  {
    return (int)this.ght;
  }
  
  public final String adF()
  {
    AppMethodBeat.i(42696);
    if (ghu != null) {}
    for (String str = ghu.fI(this.field_username); str != null; str = null)
    {
      AppMethodBeat.o(42696);
      return str;
    }
    if ((this.field_nickname == null) || (this.field_nickname.length() <= 0))
    {
      str = adH();
      AppMethodBeat.o(42696);
      return str;
    }
    str = this.field_nickname;
    AppMethodBeat.o(42696);
    return str;
  }
  
  public final String adG()
  {
    AppMethodBeat.i(42697);
    if ((this.field_conRemark != null) && (!this.field_conRemark.trim().equals("")))
    {
      str = this.field_conRemark;
      AppMethodBeat.o(42697);
      return str;
    }
    String str = adF();
    AppMethodBeat.o(42697);
    return str;
  }
  
  public final String adH()
  {
    AppMethodBeat.i(42698);
    String str = VI();
    if (!bu.isNullOrNil(str))
    {
      AppMethodBeat.o(42698);
      return str;
    }
    str = wi(this.field_username);
    if ((str != null) && (str.length() != 0))
    {
      AppMethodBeat.o(42698);
      return str;
    }
    str = this.field_username;
    AppMethodBeat.o(42698);
    return str;
  }
  
  public final int adI()
  {
    AppMethodBeat.i(42700);
    int i = super.getSource();
    AppMethodBeat.o(42700);
    return i;
  }
  
  public final void ada()
  {
    AppMethodBeat.i(42680);
    setType(this.field_type & 0xFFFFF7FF);
    AppMethodBeat.o(42680);
  }
  
  public final void adb()
  {
    AppMethodBeat.i(42681);
    setType(this.field_type | 0x20);
    AppMethodBeat.o(42681);
  }
  
  public final void adc()
  {
    AppMethodBeat.i(42682);
    setType(this.field_type & 0xFFFFFFDF);
    AppMethodBeat.o(42682);
  }
  
  public final void ade()
  {
    AppMethodBeat.i(42683);
    setType(this.field_type | 0x40);
    AppMethodBeat.o(42683);
  }
  
  public final void adf()
  {
    AppMethodBeat.i(42684);
    setType(this.field_type & 0xFFFFFFBF);
    AppMethodBeat.o(42684);
  }
  
  public final void adg()
  {
    AppMethodBeat.i(42685);
    setType(this.field_type | 0x200);
    AppMethodBeat.o(42685);
  }
  
  public final void adh()
  {
    AppMethodBeat.i(42686);
    setType(this.field_type & 0xFFFFFDFF);
    AppMethodBeat.o(42686);
  }
  
  public final void adi()
  {
    AppMethodBeat.i(42687);
    setType(this.field_type | 0x100);
    AppMethodBeat.o(42687);
  }
  
  public final void adj()
  {
    AppMethodBeat.i(42688);
    setType(this.field_type & 0xFFFFFEFF);
    AppMethodBeat.o(42688);
  }
  
  public final void adk()
  {
    AppMethodBeat.i(42689);
    setType(this.field_type | 0x800000);
    AppMethodBeat.o(42689);
  }
  
  public final void adl()
  {
    AppMethodBeat.i(42690);
    setType(this.field_type & 0xFF7FFFFF);
    AppMethodBeat.o(42690);
  }
  
  public final boolean ads()
  {
    AppMethodBeat.i(224498);
    boolean bool = lO(this.field_type);
    AppMethodBeat.o(224498);
    return bool;
  }
  
  public final boolean adt()
  {
    return (this.field_type & 0x2) != 0;
  }
  
  public final boolean adu()
  {
    return (this.field_type & 0x4) != 0;
  }
  
  public final boolean adv()
  {
    return (this.field_type & 0x8) != 0;
  }
  
  public final boolean adw()
  {
    return (0x80000 & this.field_type) != 0;
  }
  
  public final boolean adx()
  {
    return (this.field_type & 0x40) != 0;
  }
  
  public final boolean ady()
  {
    return (this.field_type & 0x100) != 0;
  }
  
  public final boolean adz()
  {
    return (0x10000 & this.field_type) != 0;
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(42703);
    super.convertFrom(paramCursor);
    this.ght = this.systemRowid;
    super.L(null);
    AppMethodBeat.o(42703);
  }
  
  public com.tencent.mm.sdk.e.c.a getDBInfo()
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
  
  public final void kb(int paramInt)
  {
    AppMethodBeat.i(42711);
    if (!bu.jB(this.field_showHead, paramInt))
    {
      super.kb(paramInt);
      adJ();
    }
    AppMethodBeat.o(42711);
  }
  
  public final void kc(int paramInt)
  {
    AppMethodBeat.i(42713);
    if (!bu.jB(this.field_weiboFlag, paramInt))
    {
      super.kc(paramInt);
      adJ();
    }
    AppMethodBeat.o(42713);
  }
  
  public final void kd(int paramInt)
  {
    AppMethodBeat.i(42718);
    if (!bu.jB(this.field_verifyFlag, paramInt))
    {
      super.kd(paramInt);
      adJ();
    }
    AppMethodBeat.o(42718);
  }
  
  public final void ke(int paramInt)
  {
    AppMethodBeat.i(42720);
    if (!bu.jB(this.field_chatroomFlag, paramInt))
    {
      super.ke(paramInt);
      adJ();
    }
    AppMethodBeat.o(42720);
  }
  
  public final void kf(int paramInt)
  {
    AppMethodBeat.i(42721);
    if (!bu.jB(this.field_deleteFlag, paramInt))
    {
      super.kf(paramInt);
      adJ();
    }
    AppMethodBeat.o(42721);
  }
  
  public final void kg(int paramInt)
  {
    AppMethodBeat.i(42723);
    if (!bu.jB(this.eQU, paramInt))
    {
      super.kg(paramInt);
      adJ();
    }
    AppMethodBeat.o(42723);
  }
  
  public final void kh(int paramInt)
  {
    AppMethodBeat.i(42724);
    if (!bu.jB(this.eQV, paramInt))
    {
      super.kh(paramInt);
      adJ();
    }
    AppMethodBeat.o(42724);
  }
  
  public final void ki(int paramInt)
  {
    AppMethodBeat.i(42730);
    if (!bu.jB(this.eQZ, paramInt))
    {
      super.ki(paramInt);
      adJ();
    }
    AppMethodBeat.o(42730);
  }
  
  public final void kj(int paramInt)
  {
    AppMethodBeat.i(42731);
    if (!bu.jB(this.eRa, paramInt))
    {
      super.kj(paramInt);
      adJ();
    }
    AppMethodBeat.o(42731);
  }
  
  public final void kk(int paramInt)
  {
    AppMethodBeat.i(42734);
    if (!bu.jB(this.eRd, paramInt))
    {
      super.kk(paramInt);
      adJ();
    }
    AppMethodBeat.o(42734);
  }
  
  public final void kl(int paramInt)
  {
    AppMethodBeat.i(42735);
    if (!bu.jB(this.eRe, paramInt))
    {
      super.kl(paramInt);
      adJ();
    }
    AppMethodBeat.o(42735);
  }
  
  public final void km(int paramInt)
  {
    AppMethodBeat.i(42745);
    if (!bu.jB(this.eRm, paramInt))
    {
      super.km(paramInt);
      adJ();
    }
    AppMethodBeat.o(42745);
  }
  
  public final void kn(int paramInt)
  {
    AppMethodBeat.i(42746);
    if (!bu.jB(this.eRn, paramInt))
    {
      super.kn(paramInt);
      adJ();
    }
    AppMethodBeat.o(42746);
  }
  
  public final void lP(int paramInt)
  {
    AppMethodBeat.i(42702);
    ke(this.field_chatroomFlag & 0xFFFFFFFE | paramInt & 0x1);
    AppMethodBeat.o(42702);
  }
  
  public final void qE(long paramLong)
  {
    AppMethodBeat.i(42726);
    if (!bu.az(this.eQX, paramLong))
    {
      super.qE(paramLong);
      adJ();
    }
    AppMethodBeat.o(42726);
  }
  
  public final void qF(long paramLong)
  {
    AppMethodBeat.i(163506);
    if (!bu.az(this.eRA, paramLong))
    {
      super.qF(paramLong);
      adJ();
    }
    AppMethodBeat.o(163506);
  }
  
  public final void qG(long paramLong)
  {
    AppMethodBeat.i(178862);
    if (!bu.az(this.eRB, paramLong))
    {
      super.qG(paramLong);
      adJ();
    }
    AppMethodBeat.o(178862);
  }
  
  public final void setFromType(int paramInt)
  {
    AppMethodBeat.i(42740);
    if (!bu.jB(this.eRi, paramInt))
    {
      super.setFromType(paramInt);
      adJ();
    }
    AppMethodBeat.o(42740);
  }
  
  public final void setSource(int paramInt)
  {
    AppMethodBeat.i(42741);
    if (!bu.jB(super.getSource(), paramInt))
    {
      super.setSource(paramInt);
      adJ();
    }
    AppMethodBeat.o(42741);
  }
  
  public final void setType(int paramInt)
  {
    AppMethodBeat.i(42712);
    if (!bu.jB(this.field_type, paramInt))
    {
      super.setType(paramInt);
      adJ();
    }
    AppMethodBeat.o(42712);
  }
  
  public final void setUin(int paramInt)
  {
    AppMethodBeat.i(42727);
    if (!bu.jB(this.uin, paramInt))
    {
      super.setUin(paramInt);
      adJ();
    }
    AppMethodBeat.o(42727);
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(42704);
    if (!bu.lX(this.field_username, paramString))
    {
      super.setUsername(paramString);
      adJ();
    }
    AppMethodBeat.o(42704);
  }
  
  public final void tA(String paramString)
  {
    AppMethodBeat.i(42725);
    if (!bu.lX(this.eQW, paramString))
    {
      super.tA(paramString);
      adJ();
    }
    AppMethodBeat.o(42725);
  }
  
  public final void tB(String paramString)
  {
    AppMethodBeat.i(42728);
    if (!bu.lX(this.eQY, paramString))
    {
      super.tB(paramString);
      adJ();
    }
    AppMethodBeat.o(42728);
  }
  
  public final void tC(String paramString)
  {
    AppMethodBeat.i(42729);
    if (!bu.lX(this.dAs, paramString))
    {
      super.tC(paramString);
      adJ();
    }
    AppMethodBeat.o(42729);
  }
  
  public final void tD(String paramString)
  {
    AppMethodBeat.i(42732);
    if (!bu.lX(this.eRb, paramString))
    {
      super.tD(paramString);
      adJ();
    }
    AppMethodBeat.o(42732);
  }
  
  public final void tE(String paramString)
  {
    AppMethodBeat.i(42733);
    if (!bu.lX(this.eRc, paramString))
    {
      super.tE(paramString);
      adJ();
    }
    AppMethodBeat.o(42733);
  }
  
  public final void tF(String paramString)
  {
    AppMethodBeat.i(42736);
    if (!bu.lX(this.signature, paramString))
    {
      super.tF(paramString);
      adJ();
    }
    AppMethodBeat.o(42736);
  }
  
  public void tG(String paramString)
  {
    AppMethodBeat.i(42737);
    if (!bu.lX(getProvince(), paramString))
    {
      super.tG(paramString);
      adJ();
    }
    AppMethodBeat.o(42737);
  }
  
  public void tH(String paramString)
  {
    AppMethodBeat.i(42738);
    if (!bu.lX(getCity(), paramString))
    {
      super.tH(paramString);
      adJ();
    }
    AppMethodBeat.o(42738);
  }
  
  public final void tI(String paramString)
  {
    AppMethodBeat.i(42739);
    if (!bu.lX(this.eRh, paramString))
    {
      super.tI(paramString);
      adJ();
    }
    AppMethodBeat.o(42739);
  }
  
  public final void tJ(String paramString)
  {
    AppMethodBeat.i(42742);
    if (!bu.lX(this.eRj, paramString))
    {
      super.tJ(paramString);
      adJ();
    }
    AppMethodBeat.o(42742);
  }
  
  public final void tK(String paramString)
  {
    AppMethodBeat.i(42743);
    if (!bu.lX(this.eRk, paramString))
    {
      super.tK(paramString);
      adJ();
    }
    AppMethodBeat.o(42743);
  }
  
  public void tL(String paramString)
  {
    AppMethodBeat.i(42744);
    if (!bu.lX(this.eRl, paramString))
    {
      super.tL(paramString);
      adJ();
    }
    AppMethodBeat.o(42744);
  }
  
  public final void tM(String paramString)
  {
    AppMethodBeat.i(42747);
    if (!bu.lX(this.eRo, paramString))
    {
      super.tM(paramString);
      adJ();
    }
    AppMethodBeat.o(42747);
  }
  
  public final void tN(String paramString)
  {
    AppMethodBeat.i(42748);
    if (!bu.lX(this.eRp, paramString))
    {
      super.tN(paramString);
      adJ();
    }
    AppMethodBeat.o(42748);
  }
  
  public final void tO(String paramString)
  {
    AppMethodBeat.i(42749);
    if (!bu.lX(this.eRq, paramString))
    {
      super.tO(paramString);
      adJ();
    }
    AppMethodBeat.o(42749);
  }
  
  public final void tP(String paramString)
  {
    AppMethodBeat.i(42750);
    if (!bu.lX(this.eRr, paramString))
    {
      super.tP(paramString);
      adJ();
    }
    AppMethodBeat.o(42750);
  }
  
  public final void tQ(String paramString)
  {
    AppMethodBeat.i(42751);
    if (!bu.lX(this.eRs, paramString))
    {
      super.tQ(paramString);
      adJ();
    }
    AppMethodBeat.o(42751);
  }
  
  public final void tR(String paramString)
  {
    AppMethodBeat.i(42752);
    if (!bu.lX(this.eRt, paramString))
    {
      super.tR(paramString);
      adJ();
    }
    AppMethodBeat.o(42752);
  }
  
  public final void tS(String paramString)
  {
    AppMethodBeat.i(42753);
    if (!bu.lX(this.eRu, paramString))
    {
      super.tS(paramString);
      adJ();
    }
    AppMethodBeat.o(42753);
  }
  
  public final void tT(String paramString)
  {
    AppMethodBeat.i(42754);
    if (!bu.lX(this.eRv, paramString))
    {
      super.tT(paramString);
      adJ();
    }
    AppMethodBeat.o(42754);
  }
  
  public final void tl(String paramString)
  {
    AppMethodBeat.i(42705);
    if (!bu.lX(VI(), paramString))
    {
      super.tl(paramString);
      adJ();
    }
    AppMethodBeat.o(42705);
  }
  
  public final void tm(String paramString)
  {
    AppMethodBeat.i(42706);
    if (!bu.lX(this.field_conRemark, paramString))
    {
      super.tm(paramString);
      adJ();
    }
    AppMethodBeat.o(42706);
  }
  
  public final void tn(String paramString)
  {
    AppMethodBeat.i(42707);
    if (!bu.lX(this.field_domainList, paramString))
    {
      super.tn(paramString);
      adJ();
    }
    AppMethodBeat.o(42707);
  }
  
  public final void to(String paramString)
  {
    AppMethodBeat.i(42708);
    if (!bu.lX(this.field_nickname, paramString))
    {
      super.to(paramString);
      adJ();
    }
    AppMethodBeat.o(42708);
  }
  
  public final void tp(String paramString)
  {
    AppMethodBeat.i(42709);
    if (!bu.lX(VL(), paramString))
    {
      super.tp(paramString);
      adJ();
    }
    AppMethodBeat.o(42709);
  }
  
  public final void tq(String paramString)
  {
    AppMethodBeat.i(42710);
    if (!bu.lX(VM(), paramString))
    {
      super.tq(paramString);
      adJ();
    }
    AppMethodBeat.o(42710);
  }
  
  public final void tr(String paramString)
  {
    AppMethodBeat.i(42714);
    if (!bu.lX(this.field_weiboNickname, paramString))
    {
      super.tr(paramString);
      adJ();
    }
    AppMethodBeat.o(42714);
  }
  
  public final void ts(String paramString)
  {
    AppMethodBeat.i(42715);
    if (!bu.lX(this.field_conRemarkPYFull, paramString))
    {
      super.ts(paramString);
      adJ();
    }
    AppMethodBeat.o(42715);
  }
  
  public final void tt(String paramString)
  {
    AppMethodBeat.i(42716);
    if (!bu.lX(this.field_conRemarkPYShort, paramString))
    {
      super.tt(paramString);
      adJ();
    }
    AppMethodBeat.o(42716);
  }
  
  public final void tu(String paramString)
  {
    AppMethodBeat.i(42719);
    if (!bu.lX(this.field_encryptUsername, paramString))
    {
      super.tu(paramString);
      adJ();
    }
    AppMethodBeat.o(42719);
  }
  
  public final void tv(String paramString)
  {
    AppMethodBeat.i(42722);
    if (!bu.lX(this.field_contactLabelIds, paramString))
    {
      super.tv(paramString);
      adJ();
    }
    AppMethodBeat.o(42722);
  }
  
  public final void tx(String paramString)
  {
    AppMethodBeat.i(42755);
    if (!bu.lX(this.field_openImAppid, paramString))
    {
      super.tx(paramString);
      adJ();
    }
    AppMethodBeat.o(42755);
  }
  
  public final void ty(String paramString)
  {
    AppMethodBeat.i(42756);
    if (!bu.lX(this.field_sourceExtInfo, paramString))
    {
      super.ty(paramString);
      adJ();
    }
    AppMethodBeat.o(42756);
  }
  
  public final void tz(String paramString)
  {
    AppMethodBeat.i(42757);
    if (!bu.lX(this.field_ticket, paramString))
    {
      super.tz(paramString);
      adJ();
    }
    AppMethodBeat.o(42757);
  }
  
  public static abstract interface a
  {
    public abstract String fI(String paramString);
    
    public abstract String fJ(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.contact.c
 * JD-Core Version:    0.7.0.1
 */