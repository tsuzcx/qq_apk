package com.tencent.mm.o;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.reflect.Field;
import java.util.Map;

public class b
  extends aw
{
  private static a gfk;
  public static c.a info;
  public long gfj;
  public int versionCode;
  
  static
  {
    AppMethodBeat.i(42758);
    c.a locala = new c.a();
    locala.IhA = new Field[23];
    locala.columns = new String[24];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.IhC.put("username", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "username";
    locala.columns[1] = "alias";
    locala.IhC.put("alias", "TEXT default '' ");
    localStringBuilder.append(" alias TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "conRemark";
    locala.IhC.put("conRemark", "TEXT default '' ");
    localStringBuilder.append(" conRemark TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "domainList";
    locala.IhC.put("domainList", "TEXT default '' ");
    localStringBuilder.append(" domainList TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "nickname";
    locala.IhC.put("nickname", "TEXT default '' ");
    localStringBuilder.append(" nickname TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "pyInitial";
    locala.IhC.put("pyInitial", "TEXT default '' ");
    localStringBuilder.append(" pyInitial TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "quanPin";
    locala.IhC.put("quanPin", "TEXT default '' ");
    localStringBuilder.append(" quanPin TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "showHead";
    locala.IhC.put("showHead", "INTEGER default '0' ");
    localStringBuilder.append(" showHead INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "type";
    locala.IhC.put("type", "INTEGER default '0' ");
    localStringBuilder.append(" type INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "weiboFlag";
    locala.IhC.put("weiboFlag", "INTEGER default '0' ");
    localStringBuilder.append(" weiboFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "weiboNickname";
    locala.IhC.put("weiboNickname", "TEXT default '' ");
    localStringBuilder.append(" weiboNickname TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "conRemarkPYFull";
    locala.IhC.put("conRemarkPYFull", "TEXT default '' ");
    localStringBuilder.append(" conRemarkPYFull TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "conRemarkPYShort";
    locala.IhC.put("conRemarkPYShort", "TEXT default '' ");
    localStringBuilder.append(" conRemarkPYShort TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "lvbuff";
    locala.IhC.put("lvbuff", "BLOB");
    localStringBuilder.append(" lvbuff BLOB");
    localStringBuilder.append(", ");
    locala.columns[14] = "verifyFlag";
    locala.IhC.put("verifyFlag", "INTEGER default '0' ");
    localStringBuilder.append(" verifyFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[15] = "encryptUsername";
    locala.IhC.put("encryptUsername", "TEXT default '' ");
    localStringBuilder.append(" encryptUsername TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[16] = "chatroomFlag";
    locala.IhC.put("chatroomFlag", "INTEGER");
    localStringBuilder.append(" chatroomFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[17] = "deleteFlag";
    locala.IhC.put("deleteFlag", "INTEGER default '0' ");
    localStringBuilder.append(" deleteFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "contactLabelIds";
    locala.IhC.put("contactLabelIds", "TEXT default '' ");
    localStringBuilder.append(" contactLabelIds TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[19] = "descWordingId";
    locala.IhC.put("descWordingId", "TEXT default '' ");
    localStringBuilder.append(" descWordingId TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[20] = "openImAppid";
    locala.IhC.put("openImAppid", "TEXT");
    localStringBuilder.append(" openImAppid TEXT");
    localStringBuilder.append(", ");
    locala.columns[21] = "sourceExtInfo";
    locala.IhC.put("sourceExtInfo", "TEXT");
    localStringBuilder.append(" sourceExtInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[22] = "ticket";
    locala.IhC.put("ticket", "TEXT default '' ");
    localStringBuilder.append(" ticket TEXT default '' ");
    locala.columns[23] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    gfk = null;
    AppMethodBeat.o(42758);
  }
  
  public b()
  {
    AppMethodBeat.i(42667);
    this.versionCode = 0;
    super.setUsername("");
    super.sT("");
    super.sU("");
    super.sV("");
    super.sQ("");
    super.sR("");
    super.sY("");
    super.sX("");
    super.sS("");
    super.ka(0);
    super.sW("");
    super.jZ(0);
    super.setType(0);
    super.kb(0);
    super.kc(0);
    super.ta("");
    super.kf(0);
    super.tn("");
    super.setFromType(0);
    super.setUin(0);
    super.tg("");
    super.th("");
    super.kg(0);
    super.kh(0);
    super.ti("");
    super.tj("");
    super.ki(1);
    super.ke(0);
    super.kj(0);
    super.tk("");
    super.tl("");
    super.tm("");
    super.setSource(0);
    super.tp("");
    super.to("");
    super.qr(0L);
    super.tf("");
    super.tq("");
    super.kk(0);
    super.tt("");
    super.tu("");
    super.tv("");
    super.ty("");
    super.tb("");
    super.tc("");
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
    gfk = parama;
  }
  
  public static int ada()
  {
    return 1;
  }
  
  public static int adb()
  {
    return 8;
  }
  
  public static int adc()
  {
    return 524288;
  }
  
  public static int ade()
  {
    return 8388608;
  }
  
  public static int adf()
  {
    return 16;
  }
  
  public static int adg()
  {
    return 32;
  }
  
  private int ady()
  {
    int i = this.versionCode + 1;
    this.versionCode = i;
    return i;
  }
  
  private static boolean isLetter(char paramChar)
  {
    return ((paramChar >= 'A') && (paramChar <= 'Z')) || ((paramChar >= 'a') && (paramChar <= 'z'));
  }
  
  public static boolean lM(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public static String vL(String paramString)
  {
    AppMethodBeat.i(42668);
    if (gfk != null)
    {
      paramString = gfk.fC(paramString);
      AppMethodBeat.o(42668);
      return paramString;
    }
    AppMethodBeat.o(42668);
    return null;
  }
  
  private static String vM(String paramString)
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
    if (!bt.isEqual(this.field_lvbuff, paramArrayOfByte))
    {
      super.L(paramArrayOfByte);
      ady();
    }
    AppMethodBeat.o(42717);
  }
  
  public final boolean Pf()
  {
    return (this.field_type & 0x200) != 0;
  }
  
  public final String VA()
  {
    AppMethodBeat.i(42695);
    if (gfk != null) {}
    for (String str = gfk.fD(this.field_username); str == null; str = null)
    {
      str = super.VA();
      AppMethodBeat.o(42695);
      return str;
    }
    AppMethodBeat.o(42695);
    return str;
  }
  
  public final String VD()
  {
    AppMethodBeat.i(42693);
    if ((super.VD() == null) || (super.VD().length() < 0))
    {
      str = VE();
      AppMethodBeat.o(42693);
      return str;
    }
    String str = super.VD();
    AppMethodBeat.o(42693);
    return str;
  }
  
  public final String VE()
  {
    AppMethodBeat.i(42694);
    if ((super.VE() == null) || (super.VE().length() < 0))
    {
      str = this.field_nickname;
      AppMethodBeat.o(42694);
      return str;
    }
    String str = super.VE();
    AppMethodBeat.o(42694);
    return str;
  }
  
  public final boolean YY()
  {
    return (this.field_type & 0x400) == 0;
  }
  
  public final int acE()
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
      if ((super.VD() != null) && (!super.VD().equals("")))
      {
        i = super.VD().charAt(0);
        break;
      }
      if ((super.VE() != null) && (!super.VE().equals("")))
      {
        i = super.VE().charAt(0);
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
  
  public final void acF()
  {
    AppMethodBeat.i(42670);
    setType(0);
    AppMethodBeat.o(42670);
  }
  
  public final void acG()
  {
    AppMethodBeat.i(42671);
    setType(this.field_type | 0x4);
    AppMethodBeat.o(42671);
  }
  
  public final void acH()
  {
    AppMethodBeat.i(42672);
    setType(this.field_type | 0x1);
    AppMethodBeat.o(42672);
  }
  
  public final void acI()
  {
    AppMethodBeat.i(42673);
    ad.w("MicroMsg.RContact", "unSetContact!! user:%s oldType:%d [%s]", new Object[] { this.field_username, Integer.valueOf(this.field_type), bt.flS() });
    setType(this.field_type & 0xFFFFFFFE);
    AppMethodBeat.o(42673);
  }
  
  public final void acJ()
  {
    AppMethodBeat.i(42674);
    setType(this.field_type | 0x8);
    AppMethodBeat.o(42674);
  }
  
  public final void acK()
  {
    AppMethodBeat.i(42675);
    setType(this.field_type & 0xFFFFFFF7);
    AppMethodBeat.o(42675);
  }
  
  public final void acL()
  {
    AppMethodBeat.i(42676);
    setType(this.field_type | 0x80000);
    AppMethodBeat.o(42676);
  }
  
  public final void acM()
  {
    AppMethodBeat.i(42677);
    setType(this.field_type & 0xFFF7FFFF);
    AppMethodBeat.o(42677);
  }
  
  public final void acN()
  {
    AppMethodBeat.i(42678);
    setType(this.field_type | 0x2);
    AppMethodBeat.o(42678);
  }
  
  public final void acO()
  {
    AppMethodBeat.i(42679);
    setType(this.field_type & 0xFFFFFFFD);
    AppMethodBeat.o(42679);
  }
  
  public final void acP()
  {
    AppMethodBeat.i(42680);
    setType(this.field_type & 0xFFFFF7FF);
    AppMethodBeat.o(42680);
  }
  
  public final void acQ()
  {
    AppMethodBeat.i(42681);
    setType(this.field_type | 0x20);
    AppMethodBeat.o(42681);
  }
  
  public final void acR()
  {
    AppMethodBeat.i(42682);
    setType(this.field_type & 0xFFFFFFDF);
    AppMethodBeat.o(42682);
  }
  
  public final void acS()
  {
    AppMethodBeat.i(42683);
    setType(this.field_type | 0x40);
    AppMethodBeat.o(42683);
  }
  
  public final void acT()
  {
    AppMethodBeat.i(42684);
    setType(this.field_type & 0xFFFFFFBF);
    AppMethodBeat.o(42684);
  }
  
  public final void acU()
  {
    AppMethodBeat.i(42685);
    setType(this.field_type | 0x200);
    AppMethodBeat.o(42685);
  }
  
  public final void acV()
  {
    AppMethodBeat.i(42686);
    setType(this.field_type & 0xFFFFFDFF);
    AppMethodBeat.o(42686);
  }
  
  public final void acW()
  {
    AppMethodBeat.i(42687);
    setType(this.field_type | 0x100);
    AppMethodBeat.o(42687);
  }
  
  public final void acX()
  {
    AppMethodBeat.i(42688);
    setType(this.field_type & 0xFFFFFEFF);
    AppMethodBeat.o(42688);
  }
  
  public final void acY()
  {
    AppMethodBeat.i(42689);
    setType(this.field_type | 0x800000);
    AppMethodBeat.o(42689);
  }
  
  public final void acZ()
  {
    AppMethodBeat.i(42690);
    setType(this.field_type & 0xFF7FFFFF);
    AppMethodBeat.o(42690);
  }
  
  public final boolean adh()
  {
    AppMethodBeat.i(221202);
    boolean bool = lM(this.field_type);
    AppMethodBeat.o(221202);
    return bool;
  }
  
  public final boolean adi()
  {
    return (this.field_type & 0x2) != 0;
  }
  
  public final boolean adj()
  {
    return (this.field_type & 0x4) != 0;
  }
  
  public final boolean adk()
  {
    return (this.field_type & 0x8) != 0;
  }
  
  public final boolean adl()
  {
    return (0x80000 & this.field_type) != 0;
  }
  
  public final boolean adm()
  {
    return (this.field_type & 0x40) != 0;
  }
  
  public final boolean adn()
  {
    return (this.field_type & 0x100) != 0;
  }
  
  public final boolean ado()
  {
    return (0x10000 & this.field_type) != 0;
  }
  
  public final boolean adp()
  {
    return (0x800000 & this.field_type) != 0;
  }
  
  public final boolean adq()
  {
    return (this.field_type & 0x800) != 0;
  }
  
  public final boolean adr()
  {
    return (0x8000 & this.field_type) != 0;
  }
  
  public final void ads()
  {
    AppMethodBeat.i(42692);
    setType(this.field_type | 0x8000);
    AppMethodBeat.o(42692);
  }
  
  public final int adt()
  {
    return (int)this.gfj;
  }
  
  public final String adu()
  {
    AppMethodBeat.i(42696);
    if (gfk != null) {}
    for (String str = gfk.fC(this.field_username); str != null; str = null)
    {
      AppMethodBeat.o(42696);
      return str;
    }
    if ((this.field_nickname == null) || (this.field_nickname.length() <= 0))
    {
      str = adw();
      AppMethodBeat.o(42696);
      return str;
    }
    str = this.field_nickname;
    AppMethodBeat.o(42696);
    return str;
  }
  
  public final String adv()
  {
    AppMethodBeat.i(42697);
    if ((this.field_conRemark != null) && (!this.field_conRemark.trim().equals("")))
    {
      str = this.field_conRemark;
      AppMethodBeat.o(42697);
      return str;
    }
    String str = adu();
    AppMethodBeat.o(42697);
    return str;
  }
  
  public final String adw()
  {
    AppMethodBeat.i(42698);
    String str = VA();
    if (!bt.isNullOrNil(str))
    {
      AppMethodBeat.o(42698);
      return str;
    }
    str = vM(this.field_username);
    if ((str != null) && (str.length() != 0))
    {
      AppMethodBeat.o(42698);
      return str;
    }
    str = this.field_username;
    AppMethodBeat.o(42698);
    return str;
  }
  
  public final int adx()
  {
    AppMethodBeat.i(42700);
    int i = super.getSource();
    AppMethodBeat.o(42700);
    return i;
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(42703);
    super.convertFrom(paramCursor);
    this.gfj = this.systemRowid;
    super.L(null);
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
  
  public final void jZ(int paramInt)
  {
    AppMethodBeat.i(42711);
    if (!bt.jx(this.field_showHead, paramInt))
    {
      super.jZ(paramInt);
      ady();
    }
    AppMethodBeat.o(42711);
  }
  
  public final void ka(int paramInt)
  {
    AppMethodBeat.i(42713);
    if (!bt.jx(this.field_weiboFlag, paramInt))
    {
      super.ka(paramInt);
      ady();
    }
    AppMethodBeat.o(42713);
  }
  
  public final void kb(int paramInt)
  {
    AppMethodBeat.i(42718);
    if (!bt.jx(this.field_verifyFlag, paramInt))
    {
      super.kb(paramInt);
      ady();
    }
    AppMethodBeat.o(42718);
  }
  
  public final void kc(int paramInt)
  {
    AppMethodBeat.i(42720);
    if (!bt.jx(this.field_chatroomFlag, paramInt))
    {
      super.kc(paramInt);
      ady();
    }
    AppMethodBeat.o(42720);
  }
  
  public final void kd(int paramInt)
  {
    AppMethodBeat.i(42721);
    if (!bt.jx(this.field_deleteFlag, paramInt))
    {
      super.kd(paramInt);
      ady();
    }
    AppMethodBeat.o(42721);
  }
  
  public final void ke(int paramInt)
  {
    AppMethodBeat.i(42723);
    if (!bt.jx(this.ePj, paramInt))
    {
      super.ke(paramInt);
      ady();
    }
    AppMethodBeat.o(42723);
  }
  
  public final void kf(int paramInt)
  {
    AppMethodBeat.i(42724);
    if (!bt.jx(this.ePk, paramInt))
    {
      super.kf(paramInt);
      ady();
    }
    AppMethodBeat.o(42724);
  }
  
  public final void kg(int paramInt)
  {
    AppMethodBeat.i(42730);
    if (!bt.jx(this.ePo, paramInt))
    {
      super.kg(paramInt);
      ady();
    }
    AppMethodBeat.o(42730);
  }
  
  public final void kh(int paramInt)
  {
    AppMethodBeat.i(42731);
    if (!bt.jx(this.ePp, paramInt))
    {
      super.kh(paramInt);
      ady();
    }
    AppMethodBeat.o(42731);
  }
  
  public final void ki(int paramInt)
  {
    AppMethodBeat.i(42734);
    if (!bt.jx(this.ePs, paramInt))
    {
      super.ki(paramInt);
      ady();
    }
    AppMethodBeat.o(42734);
  }
  
  public final void kj(int paramInt)
  {
    AppMethodBeat.i(42735);
    if (!bt.jx(this.ePt, paramInt))
    {
      super.kj(paramInt);
      ady();
    }
    AppMethodBeat.o(42735);
  }
  
  public final void kk(int paramInt)
  {
    AppMethodBeat.i(42745);
    if (!bt.jx(this.ePB, paramInt))
    {
      super.kk(paramInt);
      ady();
    }
    AppMethodBeat.o(42745);
  }
  
  public final void kl(int paramInt)
  {
    AppMethodBeat.i(42746);
    if (!bt.jx(this.ePC, paramInt))
    {
      super.kl(paramInt);
      ady();
    }
    AppMethodBeat.o(42746);
  }
  
  public final void lN(int paramInt)
  {
    AppMethodBeat.i(42702);
    kc(this.field_chatroomFlag & 0xFFFFFFFE | paramInt & 0x1);
    AppMethodBeat.o(42702);
  }
  
  public final void qr(long paramLong)
  {
    AppMethodBeat.i(42726);
    if (!bt.aA(this.ePm, paramLong))
    {
      super.qr(paramLong);
      ady();
    }
    AppMethodBeat.o(42726);
  }
  
  public final void qs(long paramLong)
  {
    AppMethodBeat.i(163506);
    if (!bt.aA(this.ePP, paramLong))
    {
      super.qs(paramLong);
      ady();
    }
    AppMethodBeat.o(163506);
  }
  
  public final void qt(long paramLong)
  {
    AppMethodBeat.i(178862);
    if (!bt.aA(this.ePQ, paramLong))
    {
      super.qt(paramLong);
      ady();
    }
    AppMethodBeat.o(178862);
  }
  
  public final void sQ(String paramString)
  {
    AppMethodBeat.i(42705);
    if (!bt.lQ(VA(), paramString))
    {
      super.sQ(paramString);
      ady();
    }
    AppMethodBeat.o(42705);
  }
  
  public final void sR(String paramString)
  {
    AppMethodBeat.i(42706);
    if (!bt.lQ(this.field_conRemark, paramString))
    {
      super.sR(paramString);
      ady();
    }
    AppMethodBeat.o(42706);
  }
  
  public final void sS(String paramString)
  {
    AppMethodBeat.i(42707);
    if (!bt.lQ(this.field_domainList, paramString))
    {
      super.sS(paramString);
      ady();
    }
    AppMethodBeat.o(42707);
  }
  
  public final void sT(String paramString)
  {
    AppMethodBeat.i(42708);
    if (!bt.lQ(this.field_nickname, paramString))
    {
      super.sT(paramString);
      ady();
    }
    AppMethodBeat.o(42708);
  }
  
  public final void sU(String paramString)
  {
    AppMethodBeat.i(42709);
    if (!bt.lQ(VD(), paramString))
    {
      super.sU(paramString);
      ady();
    }
    AppMethodBeat.o(42709);
  }
  
  public final void sV(String paramString)
  {
    AppMethodBeat.i(42710);
    if (!bt.lQ(VE(), paramString))
    {
      super.sV(paramString);
      ady();
    }
    AppMethodBeat.o(42710);
  }
  
  public final void sW(String paramString)
  {
    AppMethodBeat.i(42714);
    if (!bt.lQ(this.field_weiboNickname, paramString))
    {
      super.sW(paramString);
      ady();
    }
    AppMethodBeat.o(42714);
  }
  
  public final void sX(String paramString)
  {
    AppMethodBeat.i(42715);
    if (!bt.lQ(this.field_conRemarkPYFull, paramString))
    {
      super.sX(paramString);
      ady();
    }
    AppMethodBeat.o(42715);
  }
  
  public final void sY(String paramString)
  {
    AppMethodBeat.i(42716);
    if (!bt.lQ(this.field_conRemarkPYShort, paramString))
    {
      super.sY(paramString);
      ady();
    }
    AppMethodBeat.o(42716);
  }
  
  public final void sZ(String paramString)
  {
    AppMethodBeat.i(42719);
    if (!bt.lQ(this.field_encryptUsername, paramString))
    {
      super.sZ(paramString);
      ady();
    }
    AppMethodBeat.o(42719);
  }
  
  public final void setFromType(int paramInt)
  {
    AppMethodBeat.i(42740);
    if (!bt.jx(this.ePx, paramInt))
    {
      super.setFromType(paramInt);
      ady();
    }
    AppMethodBeat.o(42740);
  }
  
  public final void setSource(int paramInt)
  {
    AppMethodBeat.i(42741);
    if (!bt.jx(super.getSource(), paramInt))
    {
      super.setSource(paramInt);
      ady();
    }
    AppMethodBeat.o(42741);
  }
  
  public final void setType(int paramInt)
  {
    AppMethodBeat.i(42712);
    if (!bt.jx(this.field_type, paramInt))
    {
      super.setType(paramInt);
      ady();
    }
    AppMethodBeat.o(42712);
  }
  
  public final void setUin(int paramInt)
  {
    AppMethodBeat.i(42727);
    if (!bt.jx(this.uin, paramInt))
    {
      super.setUin(paramInt);
      ady();
    }
    AppMethodBeat.o(42727);
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(42704);
    if (!bt.lQ(this.field_username, paramString))
    {
      super.setUsername(paramString);
      ady();
    }
    AppMethodBeat.o(42704);
  }
  
  public final void ta(String paramString)
  {
    AppMethodBeat.i(42722);
    if (!bt.lQ(this.field_contactLabelIds, paramString))
    {
      super.ta(paramString);
      ady();
    }
    AppMethodBeat.o(42722);
  }
  
  public final void tc(String paramString)
  {
    AppMethodBeat.i(42755);
    if (!bt.lQ(this.field_openImAppid, paramString))
    {
      super.tc(paramString);
      ady();
    }
    AppMethodBeat.o(42755);
  }
  
  public final void td(String paramString)
  {
    AppMethodBeat.i(42756);
    if (!bt.lQ(this.field_sourceExtInfo, paramString))
    {
      super.td(paramString);
      ady();
    }
    AppMethodBeat.o(42756);
  }
  
  public final void te(String paramString)
  {
    AppMethodBeat.i(42757);
    if (!bt.lQ(this.field_ticket, paramString))
    {
      super.te(paramString);
      ady();
    }
    AppMethodBeat.o(42757);
  }
  
  public final void tf(String paramString)
  {
    AppMethodBeat.i(42725);
    if (!bt.lQ(this.ePl, paramString))
    {
      super.tf(paramString);
      ady();
    }
    AppMethodBeat.o(42725);
  }
  
  public final void tg(String paramString)
  {
    AppMethodBeat.i(42728);
    if (!bt.lQ(this.ePn, paramString))
    {
      super.tg(paramString);
      ady();
    }
    AppMethodBeat.o(42728);
  }
  
  public final void th(String paramString)
  {
    AppMethodBeat.i(42729);
    if (!bt.lQ(this.dzn, paramString))
    {
      super.th(paramString);
      ady();
    }
    AppMethodBeat.o(42729);
  }
  
  public final void ti(String paramString)
  {
    AppMethodBeat.i(42732);
    if (!bt.lQ(this.ePq, paramString))
    {
      super.ti(paramString);
      ady();
    }
    AppMethodBeat.o(42732);
  }
  
  public final void tj(String paramString)
  {
    AppMethodBeat.i(42733);
    if (!bt.lQ(this.ePr, paramString))
    {
      super.tj(paramString);
      ady();
    }
    AppMethodBeat.o(42733);
  }
  
  public final void tk(String paramString)
  {
    AppMethodBeat.i(42736);
    if (!bt.lQ(this.signature, paramString))
    {
      super.tk(paramString);
      ady();
    }
    AppMethodBeat.o(42736);
  }
  
  public void tl(String paramString)
  {
    AppMethodBeat.i(42737);
    if (!bt.lQ(getProvince(), paramString))
    {
      super.tl(paramString);
      ady();
    }
    AppMethodBeat.o(42737);
  }
  
  public void tm(String paramString)
  {
    AppMethodBeat.i(42738);
    if (!bt.lQ(getCity(), paramString))
    {
      super.tm(paramString);
      ady();
    }
    AppMethodBeat.o(42738);
  }
  
  public final void tn(String paramString)
  {
    AppMethodBeat.i(42739);
    if (!bt.lQ(this.ePw, paramString))
    {
      super.tn(paramString);
      ady();
    }
    AppMethodBeat.o(42739);
  }
  
  public final void to(String paramString)
  {
    AppMethodBeat.i(42742);
    if (!bt.lQ(this.ePy, paramString))
    {
      super.to(paramString);
      ady();
    }
    AppMethodBeat.o(42742);
  }
  
  public final void tp(String paramString)
  {
    AppMethodBeat.i(42743);
    if (!bt.lQ(this.ePz, paramString))
    {
      super.tp(paramString);
      ady();
    }
    AppMethodBeat.o(42743);
  }
  
  public void tq(String paramString)
  {
    AppMethodBeat.i(42744);
    if (!bt.lQ(this.ePA, paramString))
    {
      super.tq(paramString);
      ady();
    }
    AppMethodBeat.o(42744);
  }
  
  public final void tr(String paramString)
  {
    AppMethodBeat.i(42747);
    if (!bt.lQ(this.ePD, paramString))
    {
      super.tr(paramString);
      ady();
    }
    AppMethodBeat.o(42747);
  }
  
  public final void ts(String paramString)
  {
    AppMethodBeat.i(42748);
    if (!bt.lQ(this.ePE, paramString))
    {
      super.ts(paramString);
      ady();
    }
    AppMethodBeat.o(42748);
  }
  
  public final void tt(String paramString)
  {
    AppMethodBeat.i(42749);
    if (!bt.lQ(this.ePF, paramString))
    {
      super.tt(paramString);
      ady();
    }
    AppMethodBeat.o(42749);
  }
  
  public final void tu(String paramString)
  {
    AppMethodBeat.i(42750);
    if (!bt.lQ(this.ePG, paramString))
    {
      super.tu(paramString);
      ady();
    }
    AppMethodBeat.o(42750);
  }
  
  public final void tv(String paramString)
  {
    AppMethodBeat.i(42751);
    if (!bt.lQ(this.ePH, paramString))
    {
      super.tv(paramString);
      ady();
    }
    AppMethodBeat.o(42751);
  }
  
  public final void tw(String paramString)
  {
    AppMethodBeat.i(42752);
    if (!bt.lQ(this.ePI, paramString))
    {
      super.tw(paramString);
      ady();
    }
    AppMethodBeat.o(42752);
  }
  
  public final void tx(String paramString)
  {
    AppMethodBeat.i(42753);
    if (!bt.lQ(this.ePJ, paramString))
    {
      super.tx(paramString);
      ady();
    }
    AppMethodBeat.o(42753);
  }
  
  public final void ty(String paramString)
  {
    AppMethodBeat.i(42754);
    if (!bt.lQ(this.ePK, paramString))
    {
      super.ty(paramString);
      ady();
    }
    AppMethodBeat.o(42754);
  }
  
  public static abstract interface a
  {
    public abstract String fC(String paramString);
    
    public abstract String fD(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.o.b
 * JD-Core Version:    0.7.0.1
 */