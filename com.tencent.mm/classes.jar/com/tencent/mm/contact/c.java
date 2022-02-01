package com.tencent.mm.contact;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public class c
  extends ax
{
  private static a gNa;
  public static IAutoDBItem.MAutoDBInfo info;
  public long gMZ;
  public int versionCode;
  
  static
  {
    AppMethodBeat.i(42758);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[23];
    localMAutoDBInfo.columns = new String[24];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "username";
    localMAutoDBInfo.colsMap.put("username", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "username";
    localMAutoDBInfo.columns[1] = "alias";
    localMAutoDBInfo.colsMap.put("alias", "TEXT default '' ");
    localStringBuilder.append(" alias TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "conRemark";
    localMAutoDBInfo.colsMap.put("conRemark", "TEXT default '' ");
    localStringBuilder.append(" conRemark TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "domainList";
    localMAutoDBInfo.colsMap.put("domainList", "TEXT default '' ");
    localStringBuilder.append(" domainList TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "nickname";
    localMAutoDBInfo.colsMap.put("nickname", "TEXT default '' ");
    localStringBuilder.append(" nickname TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "pyInitial";
    localMAutoDBInfo.colsMap.put("pyInitial", "TEXT default '' ");
    localStringBuilder.append(" pyInitial TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "quanPin";
    localMAutoDBInfo.colsMap.put("quanPin", "TEXT default '' ");
    localStringBuilder.append(" quanPin TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "showHead";
    localMAutoDBInfo.colsMap.put("showHead", "INTEGER default '0' ");
    localStringBuilder.append(" showHead INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER default '0' ");
    localStringBuilder.append(" type INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "weiboFlag";
    localMAutoDBInfo.colsMap.put("weiboFlag", "INTEGER default '0' ");
    localStringBuilder.append(" weiboFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "weiboNickname";
    localMAutoDBInfo.colsMap.put("weiboNickname", "TEXT default '' ");
    localStringBuilder.append(" weiboNickname TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "conRemarkPYFull";
    localMAutoDBInfo.colsMap.put("conRemarkPYFull", "TEXT default '' ");
    localStringBuilder.append(" conRemarkPYFull TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "conRemarkPYShort";
    localMAutoDBInfo.colsMap.put("conRemarkPYShort", "TEXT default '' ");
    localStringBuilder.append(" conRemarkPYShort TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "lvbuff";
    localMAutoDBInfo.colsMap.put("lvbuff", "BLOB");
    localStringBuilder.append(" lvbuff BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "verifyFlag";
    localMAutoDBInfo.colsMap.put("verifyFlag", "INTEGER default '0' ");
    localStringBuilder.append(" verifyFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "encryptUsername";
    localMAutoDBInfo.colsMap.put("encryptUsername", "TEXT default '' ");
    localStringBuilder.append(" encryptUsername TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "chatroomFlag";
    localMAutoDBInfo.colsMap.put("chatroomFlag", "INTEGER");
    localStringBuilder.append(" chatroomFlag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "deleteFlag";
    localMAutoDBInfo.colsMap.put("deleteFlag", "INTEGER default '0' ");
    localStringBuilder.append(" deleteFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "contactLabelIds";
    localMAutoDBInfo.colsMap.put("contactLabelIds", "TEXT default '' ");
    localStringBuilder.append(" contactLabelIds TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "descWordingId";
    localMAutoDBInfo.colsMap.put("descWordingId", "TEXT default '' ");
    localStringBuilder.append(" descWordingId TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "openImAppid";
    localMAutoDBInfo.colsMap.put("openImAppid", "TEXT");
    localStringBuilder.append(" openImAppid TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[21] = "sourceExtInfo";
    localMAutoDBInfo.colsMap.put("sourceExtInfo", "TEXT");
    localStringBuilder.append(" sourceExtInfo TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[22] = "ticket";
    localMAutoDBInfo.colsMap.put("ticket", "TEXT default '' ");
    localStringBuilder.append(" ticket TEXT default '' ");
    localMAutoDBInfo.columns[23] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    gNa = null;
    AppMethodBeat.o(42758);
  }
  
  public c()
  {
    AppMethodBeat.i(42667);
    this.versionCode = 0;
    super.setUsername("");
    super.setNickname("");
    super.BF("");
    super.BG("");
    super.BC("");
    super.BD("");
    super.BJ("");
    super.BI("");
    super.BE("");
    super.ne(0);
    super.BH("");
    super.nd(0);
    super.setType(0);
    super.nf(0);
    super.ng(0);
    super.BL("");
    super.nj(0);
    super.BY("");
    super.setFromType(0);
    super.setUin(0);
    super.BR("");
    super.BS("");
    super.nk(0);
    super.nl(0);
    super.BT("");
    super.BU("");
    super.nm(1);
    super.ni(0);
    super.nn(0);
    super.BV("");
    super.BW("");
    super.BX("");
    super.setSource(0);
    super.Ca("");
    super.BZ("");
    super.yx(0L);
    super.BQ("");
    super.Cb("");
    super.no(0);
    super.Ce("");
    super.Cf("");
    super.Cg("");
    super.Cj("");
    super.BM("");
    super.BN("");
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
  
  public static String Ew(String paramString)
  {
    AppMethodBeat.i(42668);
    if (gNa != null)
    {
      paramString = gNa.gu(paramString);
      AppMethodBeat.o(42668);
      return paramString;
    }
    AppMethodBeat.o(42668);
    return null;
  }
  
  private static String Ex(String paramString)
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
    gNa = parama;
  }
  
  private int arM()
  {
    int i = this.versionCode + 1;
    this.versionCode = i;
    return i;
  }
  
  public static int arn()
  {
    return 1;
  }
  
  public static int aro()
  {
    return 8;
  }
  
  public static int arp()
  {
    return 524288;
  }
  
  public static int arq()
  {
    return 8388608;
  }
  
  public static int arr()
  {
    return 33554432;
  }
  
  public static int ars()
  {
    return 134217728;
  }
  
  public static int art()
  {
    return 16;
  }
  
  public static int aru()
  {
    return 32;
  }
  
  private static boolean isLetter(char paramChar)
  {
    return ((paramChar >= 'A') && (paramChar <= 'Z')) || ((paramChar >= 'a') && (paramChar <= 'z'));
  }
  
  public static boolean oR(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public final void BC(String paramString)
  {
    AppMethodBeat.i(42705);
    if (!Util.isEqual(ajx(), paramString))
    {
      super.BC(paramString);
      arM();
    }
    AppMethodBeat.o(42705);
  }
  
  public final void BD(String paramString)
  {
    AppMethodBeat.i(42706);
    if (!Util.isEqual(this.field_conRemark, paramString))
    {
      super.BD(paramString);
      arM();
    }
    AppMethodBeat.o(42706);
  }
  
  public final void BE(String paramString)
  {
    AppMethodBeat.i(42707);
    if (!Util.isEqual(this.field_domainList, paramString))
    {
      super.BE(paramString);
      arM();
    }
    AppMethodBeat.o(42707);
  }
  
  public final void BF(String paramString)
  {
    AppMethodBeat.i(42709);
    if (!Util.isEqual(ajz(), paramString))
    {
      super.BF(paramString);
      arM();
    }
    AppMethodBeat.o(42709);
  }
  
  public final void BG(String paramString)
  {
    AppMethodBeat.i(42710);
    if (!Util.isEqual(ajA(), paramString))
    {
      super.BG(paramString);
      arM();
    }
    AppMethodBeat.o(42710);
  }
  
  public final void BH(String paramString)
  {
    AppMethodBeat.i(42714);
    if (!Util.isEqual(this.field_weiboNickname, paramString))
    {
      super.BH(paramString);
      arM();
    }
    AppMethodBeat.o(42714);
  }
  
  public final void BI(String paramString)
  {
    AppMethodBeat.i(42715);
    if (!Util.isEqual(this.field_conRemarkPYFull, paramString))
    {
      super.BI(paramString);
      arM();
    }
    AppMethodBeat.o(42715);
  }
  
  public final void BJ(String paramString)
  {
    AppMethodBeat.i(42716);
    if (!Util.isEqual(this.field_conRemarkPYShort, paramString))
    {
      super.BJ(paramString);
      arM();
    }
    AppMethodBeat.o(42716);
  }
  
  public final void BK(String paramString)
  {
    AppMethodBeat.i(42719);
    if (!Util.isEqual(this.field_encryptUsername, paramString))
    {
      super.BK(paramString);
      arM();
    }
    AppMethodBeat.o(42719);
  }
  
  public final void BL(String paramString)
  {
    AppMethodBeat.i(42722);
    if (!Util.isEqual(this.field_contactLabelIds, paramString))
    {
      super.BL(paramString);
      arM();
    }
    AppMethodBeat.o(42722);
  }
  
  public final void BN(String paramString)
  {
    AppMethodBeat.i(42755);
    if (!Util.isEqual(this.field_openImAppid, paramString))
    {
      super.BN(paramString);
      arM();
    }
    AppMethodBeat.o(42755);
  }
  
  public final void BO(String paramString)
  {
    AppMethodBeat.i(42756);
    if (!Util.isEqual(this.field_sourceExtInfo, paramString))
    {
      super.BO(paramString);
      arM();
    }
    AppMethodBeat.o(42756);
  }
  
  public final void BP(String paramString)
  {
    AppMethodBeat.i(42757);
    if (!Util.isEqual(this.field_ticket, paramString))
    {
      super.BP(paramString);
      arM();
    }
    AppMethodBeat.o(42757);
  }
  
  public final void BQ(String paramString)
  {
    AppMethodBeat.i(42725);
    if (!Util.isEqual(this.fuB, paramString))
    {
      super.BQ(paramString);
      arM();
    }
    AppMethodBeat.o(42725);
  }
  
  public final void BR(String paramString)
  {
    AppMethodBeat.i(42728);
    if (!Util.isEqual(this.fuD, paramString))
    {
      super.BR(paramString);
      arM();
    }
    AppMethodBeat.o(42728);
  }
  
  public final void BS(String paramString)
  {
    AppMethodBeat.i(42729);
    if (!Util.isEqual(this.dSf, paramString))
    {
      super.BS(paramString);
      arM();
    }
    AppMethodBeat.o(42729);
  }
  
  public final void BT(String paramString)
  {
    AppMethodBeat.i(42732);
    if (!Util.isEqual(this.fuF, paramString))
    {
      super.BT(paramString);
      arM();
    }
    AppMethodBeat.o(42732);
  }
  
  public final void BU(String paramString)
  {
    AppMethodBeat.i(42733);
    if (!Util.isEqual(this.fuG, paramString))
    {
      super.BU(paramString);
      arM();
    }
    AppMethodBeat.o(42733);
  }
  
  public final void BV(String paramString)
  {
    AppMethodBeat.i(42736);
    if (!Util.isEqual(this.signature, paramString))
    {
      super.BV(paramString);
      arM();
    }
    AppMethodBeat.o(42736);
  }
  
  public void BW(String paramString)
  {
    AppMethodBeat.i(42737);
    if (!Util.isEqual(getProvince(), paramString))
    {
      super.BW(paramString);
      arM();
    }
    AppMethodBeat.o(42737);
  }
  
  public void BX(String paramString)
  {
    AppMethodBeat.i(42738);
    if (!Util.isEqual(getCity(), paramString))
    {
      super.BX(paramString);
      arM();
    }
    AppMethodBeat.o(42738);
  }
  
  public final void BY(String paramString)
  {
    AppMethodBeat.i(42739);
    if (!Util.isEqual(this.fuL, paramString))
    {
      super.BY(paramString);
      arM();
    }
    AppMethodBeat.o(42739);
  }
  
  public final void BZ(String paramString)
  {
    AppMethodBeat.i(42742);
    if (!Util.isEqual(this.fuM, paramString))
    {
      super.BZ(paramString);
      arM();
    }
    AppMethodBeat.o(42742);
  }
  
  public final void Ca(String paramString)
  {
    AppMethodBeat.i(42743);
    if (!Util.isEqual(this.fuN, paramString))
    {
      super.Ca(paramString);
      arM();
    }
    AppMethodBeat.o(42743);
  }
  
  public void Cb(String paramString)
  {
    AppMethodBeat.i(42744);
    if (!Util.isEqual(this.fuO, paramString))
    {
      super.Cb(paramString);
      arM();
    }
    AppMethodBeat.o(42744);
  }
  
  public final void Cc(String paramString)
  {
    AppMethodBeat.i(42747);
    if (!Util.isEqual(this.fuR, paramString))
    {
      super.Cc(paramString);
      arM();
    }
    AppMethodBeat.o(42747);
  }
  
  public final void Cd(String paramString)
  {
    AppMethodBeat.i(42748);
    if (!Util.isEqual(this.fuS, paramString))
    {
      super.Cd(paramString);
      arM();
    }
    AppMethodBeat.o(42748);
  }
  
  public final void Ce(String paramString)
  {
    AppMethodBeat.i(42749);
    if (!Util.isEqual(this.fuT, paramString))
    {
      super.Ce(paramString);
      arM();
    }
    AppMethodBeat.o(42749);
  }
  
  public final void Cf(String paramString)
  {
    AppMethodBeat.i(42750);
    if (!Util.isEqual(this.fuU, paramString))
    {
      super.Cf(paramString);
      arM();
    }
    AppMethodBeat.o(42750);
  }
  
  public final void Cg(String paramString)
  {
    AppMethodBeat.i(42751);
    if (!Util.isEqual(this.fuV, paramString))
    {
      super.Cg(paramString);
      arM();
    }
    AppMethodBeat.o(42751);
  }
  
  public final void Ch(String paramString)
  {
    AppMethodBeat.i(42752);
    if (!Util.isEqual(this.fuW, paramString))
    {
      super.Ch(paramString);
      arM();
    }
    AppMethodBeat.o(42752);
  }
  
  public final void Ci(String paramString)
  {
    AppMethodBeat.i(42753);
    if (!Util.isEqual(this.fuX, paramString))
    {
      super.Ci(paramString);
      arM();
    }
    AppMethodBeat.o(42753);
  }
  
  public final void Cj(String paramString)
  {
    AppMethodBeat.i(42754);
    if (!Util.isEqual(this.fuY, paramString))
    {
      super.Cj(paramString);
      arM();
    }
    AppMethodBeat.o(42754);
  }
  
  public final void Z(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(42717);
    if (!Util.isEqual(this.field_lvbuff, paramArrayOfByte))
    {
      super.Z(paramArrayOfByte);
      arM();
    }
    AppMethodBeat.o(42717);
  }
  
  public final boolean Zx()
  {
    return (this.field_type & 0x200) != 0;
  }
  
  public final String ajA()
  {
    AppMethodBeat.i(42694);
    if ((super.ajA() == null) || (super.ajA().length() < 0))
    {
      str = this.field_nickname;
      AppMethodBeat.o(42694);
      return str;
    }
    String str = super.ajA();
    AppMethodBeat.o(42694);
    return str;
  }
  
  public final String ajx()
  {
    AppMethodBeat.i(42695);
    if (gNa != null) {}
    for (String str = gNa.gv(this.field_username); str == null; str = null)
    {
      str = super.ajx();
      AppMethodBeat.o(42695);
      return str;
    }
    AppMethodBeat.o(42695);
    return str;
  }
  
  public final String ajz()
  {
    AppMethodBeat.i(42693);
    if ((super.ajz() == null) || (super.ajz().length() < 0))
    {
      str = ajA();
      AppMethodBeat.o(42693);
      return str;
    }
    String str = super.ajz();
    AppMethodBeat.o(42693);
    return str;
  }
  
  public final boolean amU()
  {
    return (this.field_type & 0x400) == 0;
  }
  
  public final int aqN()
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
      if ((super.ajz() != null) && (!super.ajz().equals("")))
      {
        i = super.ajz().charAt(0);
        break;
      }
      if ((super.ajA() != null) && (!super.ajA().equals("")))
      {
        i = super.ajA().charAt(0);
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
  
  public final void aqO()
  {
    AppMethodBeat.i(42670);
    setType(0);
    AppMethodBeat.o(42670);
  }
  
  public final void aqP()
  {
    AppMethodBeat.i(42671);
    setType(this.field_type | 0x4);
    AppMethodBeat.o(42671);
  }
  
  public final void aqQ()
  {
    AppMethodBeat.i(42672);
    setType(this.field_type | 0x1);
    AppMethodBeat.o(42672);
  }
  
  public final void aqR()
  {
    AppMethodBeat.i(42673);
    Log.w("MicroMsg.RContact", "unSetContact!! user:%s oldType:%d [%s]", new Object[] { this.field_username, Integer.valueOf(this.field_type), Util.getStack() });
    setType(this.field_type & 0xFFFFFFFE);
    AppMethodBeat.o(42673);
  }
  
  public final void aqS()
  {
    AppMethodBeat.i(42674);
    setType(this.field_type | 0x8);
    AppMethodBeat.o(42674);
  }
  
  public final void aqT()
  {
    AppMethodBeat.i(42675);
    setType(this.field_type & 0xFFFFFFF7);
    AppMethodBeat.o(42675);
  }
  
  public final void aqU()
  {
    AppMethodBeat.i(42676);
    setType(this.field_type | 0x80000);
    AppMethodBeat.o(42676);
  }
  
  public final void aqV()
  {
    AppMethodBeat.i(42677);
    setType(this.field_type & 0xFFF7FFFF);
    AppMethodBeat.o(42677);
  }
  
  public final void aqW()
  {
    AppMethodBeat.i(42678);
    setType(this.field_type | 0x2);
    AppMethodBeat.o(42678);
  }
  
  public final void aqX()
  {
    AppMethodBeat.i(42679);
    setType(this.field_type & 0xFFFFFFFD);
    AppMethodBeat.o(42679);
  }
  
  public final void aqY()
  {
    AppMethodBeat.i(42680);
    setType(this.field_type & 0xFFFFF7FF);
    AppMethodBeat.o(42680);
  }
  
  public final void aqZ()
  {
    AppMethodBeat.i(42681);
    setType(this.field_type | 0x20);
    AppMethodBeat.o(42681);
  }
  
  public final boolean arA()
  {
    return (this.field_type & 0x40) != 0;
  }
  
  public final boolean arB()
  {
    return (this.field_type & 0x100) != 0;
  }
  
  public final boolean arC()
  {
    return (0x10000 & this.field_type) != 0;
  }
  
  public final boolean arD()
  {
    return (0x800000 & this.field_type) != 0;
  }
  
  public final boolean arE()
  {
    return (this.field_type & 0x800) != 0;
  }
  
  public final boolean arF()
  {
    return (0x8000 & this.field_type) != 0;
  }
  
  public final void arG()
  {
    AppMethodBeat.i(42692);
    setType(this.field_type | 0x8000);
    AppMethodBeat.o(42692);
  }
  
  public final int arH()
  {
    return (int)this.gMZ;
  }
  
  public final String arI()
  {
    AppMethodBeat.i(42696);
    if (gNa != null) {}
    for (String str = gNa.gu(this.field_username); str != null; str = null)
    {
      AppMethodBeat.o(42696);
      return str;
    }
    if ((this.field_nickname == null) || (this.field_nickname.length() <= 0))
    {
      str = arK();
      AppMethodBeat.o(42696);
      return str;
    }
    str = this.field_nickname;
    AppMethodBeat.o(42696);
    return str;
  }
  
  public final String arJ()
  {
    AppMethodBeat.i(42697);
    if ((this.field_conRemark != null) && (!this.field_conRemark.trim().equals("")))
    {
      str = this.field_conRemark;
      AppMethodBeat.o(42697);
      return str;
    }
    String str = arI();
    AppMethodBeat.o(42697);
    return str;
  }
  
  public final String arK()
  {
    AppMethodBeat.i(42698);
    String str = ajx();
    if (!Util.isNullOrNil(str))
    {
      AppMethodBeat.o(42698);
      return str;
    }
    str = Ex(this.field_username);
    if ((str != null) && (str.length() != 0))
    {
      AppMethodBeat.o(42698);
      return str;
    }
    str = this.field_username;
    AppMethodBeat.o(42698);
    return str;
  }
  
  public final int arL()
  {
    AppMethodBeat.i(42700);
    int i = super.getSource();
    AppMethodBeat.o(42700);
    return i;
  }
  
  public final void ara()
  {
    AppMethodBeat.i(42682);
    setType(this.field_type & 0xFFFFFFDF);
    AppMethodBeat.o(42682);
  }
  
  public final void arb()
  {
    AppMethodBeat.i(42683);
    setType(this.field_type | 0x40);
    AppMethodBeat.o(42683);
  }
  
  public final void arc()
  {
    AppMethodBeat.i(42684);
    setType(this.field_type & 0xFFFFFFBF);
    AppMethodBeat.o(42684);
  }
  
  public final void ard()
  {
    AppMethodBeat.i(42685);
    setType(this.field_type | 0x200);
    AppMethodBeat.o(42685);
  }
  
  public final void are()
  {
    AppMethodBeat.i(42686);
    setType(this.field_type & 0xFFFFFDFF);
    AppMethodBeat.o(42686);
  }
  
  public final void arf()
  {
    AppMethodBeat.i(42687);
    setType(this.field_type | 0x100);
    AppMethodBeat.o(42687);
  }
  
  public final void arg()
  {
    AppMethodBeat.i(42688);
    setType(this.field_type & 0xFFFFFEFF);
    AppMethodBeat.o(42688);
  }
  
  public final void arh()
  {
    AppMethodBeat.i(42689);
    setType(this.field_type | 0x800000);
    AppMethodBeat.o(42689);
  }
  
  public final void ari()
  {
    AppMethodBeat.i(42690);
    setType(this.field_type & 0xFF7FFFFF);
    AppMethodBeat.o(42690);
  }
  
  public final void arj()
  {
    AppMethodBeat.i(225908);
    setType(this.field_type | 0x2000000);
    AppMethodBeat.o(225908);
  }
  
  public final void ark()
  {
    AppMethodBeat.i(225909);
    setType(this.field_type & 0xFDFFFFFF);
    AppMethodBeat.o(225909);
  }
  
  public final void arl()
  {
    AppMethodBeat.i(225910);
    setType(this.field_type | 0x8000000);
    AppMethodBeat.o(225910);
  }
  
  public final void arm()
  {
    AppMethodBeat.i(225911);
    setType(this.field_type & 0xF7FFFFFF);
    AppMethodBeat.o(225911);
  }
  
  public final boolean arv()
  {
    AppMethodBeat.i(258518);
    boolean bool = oR(this.field_type);
    AppMethodBeat.o(258518);
    return bool;
  }
  
  public final boolean arw()
  {
    return (this.field_type & 0x2) != 0;
  }
  
  public final boolean arx()
  {
    return (this.field_type & 0x4) != 0;
  }
  
  public final boolean ary()
  {
    return (this.field_type & 0x8) != 0;
  }
  
  public final boolean arz()
  {
    return (0x80000 & this.field_type) != 0;
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(42703);
    super.convertFrom(paramCursor);
    this.gMZ = this.systemRowid;
    super.Z(null);
    AppMethodBeat.o(42703);
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
  
  public final boolean isHidden()
  {
    return (this.field_type & 0x20) != 0;
  }
  
  public final void nd(int paramInt)
  {
    AppMethodBeat.i(42711);
    if (!Util.isEqual(this.field_showHead, paramInt))
    {
      super.nd(paramInt);
      arM();
    }
    AppMethodBeat.o(42711);
  }
  
  public final void ne(int paramInt)
  {
    AppMethodBeat.i(42713);
    if (!Util.isEqual(this.field_weiboFlag, paramInt))
    {
      super.ne(paramInt);
      arM();
    }
    AppMethodBeat.o(42713);
  }
  
  public final void nf(int paramInt)
  {
    AppMethodBeat.i(42718);
    if (!Util.isEqual(this.field_verifyFlag, paramInt))
    {
      super.nf(paramInt);
      arM();
    }
    AppMethodBeat.o(42718);
  }
  
  public final void ng(int paramInt)
  {
    AppMethodBeat.i(42720);
    if (!Util.isEqual(this.field_chatroomFlag, paramInt))
    {
      super.ng(paramInt);
      arM();
    }
    AppMethodBeat.o(42720);
  }
  
  public final void nh(int paramInt)
  {
    AppMethodBeat.i(42721);
    if (!Util.isEqual(this.field_deleteFlag, paramInt))
    {
      super.nh(paramInt);
      arM();
    }
    AppMethodBeat.o(42721);
  }
  
  public final void ni(int paramInt)
  {
    AppMethodBeat.i(42723);
    if (!Util.isEqual(this.fuz, paramInt))
    {
      super.ni(paramInt);
      arM();
    }
    AppMethodBeat.o(42723);
  }
  
  public final void nj(int paramInt)
  {
    AppMethodBeat.i(42724);
    if (!Util.isEqual(this.fuA, paramInt))
    {
      super.nj(paramInt);
      arM();
    }
    AppMethodBeat.o(42724);
  }
  
  public final void nk(int paramInt)
  {
    AppMethodBeat.i(42730);
    if (!Util.isEqual(this.showFlag, paramInt))
    {
      super.nk(paramInt);
      arM();
    }
    AppMethodBeat.o(42730);
  }
  
  public final void nl(int paramInt)
  {
    AppMethodBeat.i(42731);
    if (!Util.isEqual(this.fuE, paramInt))
    {
      super.nl(paramInt);
      arM();
    }
    AppMethodBeat.o(42731);
  }
  
  public final void nm(int paramInt)
  {
    AppMethodBeat.i(42734);
    if (!Util.isEqual(this.fuH, paramInt))
    {
      super.nm(paramInt);
      arM();
    }
    AppMethodBeat.o(42734);
  }
  
  public final void nn(int paramInt)
  {
    AppMethodBeat.i(42735);
    if (!Util.isEqual(this.fuI, paramInt))
    {
      super.nn(paramInt);
      arM();
    }
    AppMethodBeat.o(42735);
  }
  
  public final void no(int paramInt)
  {
    AppMethodBeat.i(42745);
    if (!Util.isEqual(this.fuP, paramInt))
    {
      super.no(paramInt);
      arM();
    }
    AppMethodBeat.o(42745);
  }
  
  public final void np(int paramInt)
  {
    AppMethodBeat.i(42746);
    if (!Util.isEqual(this.fuQ, paramInt))
    {
      super.np(paramInt);
      arM();
    }
    AppMethodBeat.o(42746);
  }
  
  public final void oS(int paramInt)
  {
    AppMethodBeat.i(42702);
    ng(this.field_chatroomFlag & 0xFFFFFFFE | paramInt & 0x1);
    AppMethodBeat.o(42702);
  }
  
  public final void setFromType(int paramInt)
  {
    AppMethodBeat.i(42740);
    if (!Util.isEqual(this.fromType, paramInt))
    {
      super.setFromType(paramInt);
      arM();
    }
    AppMethodBeat.o(42740);
  }
  
  public final void setNickname(String paramString)
  {
    AppMethodBeat.i(42708);
    if (!Util.isEqual(this.field_nickname, paramString))
    {
      super.setNickname(paramString);
      arM();
    }
    AppMethodBeat.o(42708);
  }
  
  public final void setSource(int paramInt)
  {
    AppMethodBeat.i(42741);
    if (!Util.isEqual(super.getSource(), paramInt))
    {
      super.setSource(paramInt);
      arM();
    }
    AppMethodBeat.o(42741);
  }
  
  public final void setType(int paramInt)
  {
    AppMethodBeat.i(42712);
    if (!Util.isEqual(this.field_type, paramInt))
    {
      super.setType(paramInt);
      arM();
    }
    AppMethodBeat.o(42712);
  }
  
  public final void setUin(int paramInt)
  {
    AppMethodBeat.i(42727);
    if (!Util.isEqual(this.uin, paramInt))
    {
      super.setUin(paramInt);
      arM();
    }
    AppMethodBeat.o(42727);
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(42704);
    if (!Util.isEqual(this.field_username, paramString))
    {
      super.setUsername(paramString);
      arM();
    }
    AppMethodBeat.o(42704);
  }
  
  public final void yx(long paramLong)
  {
    AppMethodBeat.i(42726);
    if (!Util.isEqual(this.fuC, paramLong))
    {
      super.yx(paramLong);
      arM();
    }
    AppMethodBeat.o(42726);
  }
  
  public final void yy(long paramLong)
  {
    AppMethodBeat.i(163506);
    if (!Util.isEqual(this.fvd, paramLong))
    {
      super.yy(paramLong);
      arM();
    }
    AppMethodBeat.o(163506);
  }
  
  public final void yz(long paramLong)
  {
    AppMethodBeat.i(178862);
    if (!Util.isEqual(this.fve, paramLong))
    {
      super.yz(paramLong);
      arM();
    }
    AppMethodBeat.o(178862);
  }
  
  public static abstract interface a
  {
    public abstract String gu(String paramString);
    
    public abstract String gv(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.contact.c
 * JD-Core Version:    0.7.0.1
 */