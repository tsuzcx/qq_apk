package com.tencent.mm.contact;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.storage.ar;
import java.lang.reflect.Field;
import java.util.Map;

public class d
  extends ax
{
  public static IAutoDBItem.MAutoDBInfo info;
  private static a jxu;
  public long jxt;
  public int versionCode;
  
  static
  {
    AppMethodBeat.i(42758);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[24];
    localMAutoDBInfo.columns = new String[25];
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
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[23] = "usernameFlag";
    localMAutoDBInfo.colsMap.put("usernameFlag", "LONG default '0' ");
    localStringBuilder.append(" usernameFlag LONG default '0' ");
    localMAutoDBInfo.columns[24] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    jxu = null;
    AppMethodBeat.o(42758);
  }
  
  public d()
  {
    AppMethodBeat.i(42667);
    this.versionCode = 0;
    super.setUsername("");
    super.setNickname("");
    super.It("");
    super.Iu("");
    super.Iq("");
    super.Ir("");
    super.Ix("");
    super.Iw("");
    super.Is("");
    super.pr(0);
    super.Iv("");
    super.pq(0);
    super.setType(0);
    super.ps(0);
    super.pt(0);
    super.Iz("");
    super.pw(0);
    super.IM("");
    super.setFromType(0);
    super.setUin(0);
    super.IF("");
    super.IG("");
    super.py(0);
    super.pz(0);
    super.IH("");
    super.II("");
    super.pA(1);
    super.pv(0);
    super.pB(0);
    super.IJ("");
    super.IK("");
    super.IL("");
    super.setSource(0);
    super.IO("");
    super.IN("");
    super.Ey(0L);
    super.IE("");
    super.IP("");
    super.pC(0);
    super.IS("");
    super.IT("");
    super.IU("");
    super.IX("");
    super.IA("");
    super.IB("");
    super.Ex(0L);
    super.Iy("");
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
  
  private static boolean C(char paramChar)
  {
    return ((paramChar >= 'A') && (paramChar <= 'Z')) || ((paramChar >= 'a') && (paramChar <= 'z'));
  }
  
  public static String Lp(String paramString)
  {
    AppMethodBeat.i(42668);
    if (jxu != null)
    {
      paramString = jxu.he(paramString);
      AppMethodBeat.o(42668);
      return paramString;
    }
    AppMethodBeat.o(42668);
    return null;
  }
  
  private static String Lq(String paramString)
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
    jxu = parama;
  }
  
  public static int axN()
  {
    return 1;
  }
  
  public static int axO()
  {
    return 8;
  }
  
  public static int axP()
  {
    return 524288;
  }
  
  public static int axQ()
  {
    return 131072;
  }
  
  public static int axR()
  {
    return 262144;
  }
  
  public static int axS()
  {
    return 8388608;
  }
  
  public static int axT()
  {
    return 256;
  }
  
  public static int axU()
  {
    return 1048576;
  }
  
  public static int axV()
  {
    return 33554432;
  }
  
  public static int axW()
  {
    return 134217728;
  }
  
  public static int axX()
  {
    return 16;
  }
  
  public static int axY()
  {
    return 32;
  }
  
  private int ayv()
  {
    int i = this.versionCode + 1;
    this.versionCode = i;
    return i;
  }
  
  public static boolean rk(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public final void EA(long paramLong)
  {
    AppMethodBeat.i(178862);
    if (!Util.isEqual(this.hDD, paramLong))
    {
      super.EA(paramLong);
      ayv();
    }
    AppMethodBeat.o(178862);
  }
  
  public final void Ey(long paramLong)
  {
    AppMethodBeat.i(42726);
    if (!Util.isEqual(apu(), paramLong))
    {
      super.Ey(paramLong);
      ayv();
    }
    AppMethodBeat.o(42726);
  }
  
  public final void Ez(long paramLong)
  {
    AppMethodBeat.i(163506);
    if (!Util.isEqual(this.hDC, paramLong))
    {
      super.Ez(paramLong);
      ayv();
    }
    AppMethodBeat.o(163506);
  }
  
  public final void Fa(long paramLong)
  {
    AppMethodBeat.i(239223);
    if (!Util.isEqual(this.field_usernameFlag, paramLong))
    {
      super.Ex(paramLong);
      ayv();
    }
    AppMethodBeat.o(239223);
  }
  
  public final void IB(String paramString)
  {
    AppMethodBeat.i(42755);
    if (!Util.isEqual(this.field_openImAppid, paramString))
    {
      super.IB(paramString);
      ayv();
    }
    AppMethodBeat.o(42755);
  }
  
  public final void IC(String paramString)
  {
    AppMethodBeat.i(42756);
    if (!Util.isEqual(this.field_sourceExtInfo, paramString))
    {
      super.IC(paramString);
      ayv();
    }
    AppMethodBeat.o(42756);
  }
  
  public final void ID(String paramString)
  {
    AppMethodBeat.i(42757);
    if (!Util.isEqual(this.field_ticket, paramString))
    {
      super.ID(paramString);
      ayv();
    }
    AppMethodBeat.o(42757);
  }
  
  public final void IE(String paramString)
  {
    AppMethodBeat.i(42725);
    if (!Util.isEqual(this.hDd, paramString))
    {
      super.IE(paramString);
      ayv();
    }
    AppMethodBeat.o(42725);
  }
  
  public final void IF(String paramString)
  {
    AppMethodBeat.i(42728);
    if (!Util.isEqual(getEmail(), paramString))
    {
      super.IF(paramString);
      ayv();
    }
    AppMethodBeat.o(42728);
  }
  
  public final void IG(String paramString)
  {
    AppMethodBeat.i(42729);
    if (!Util.isEqual(this.fLC, paramString))
    {
      super.IG(paramString);
      ayv();
    }
    AppMethodBeat.o(42729);
  }
  
  public final void IH(String paramString)
  {
    AppMethodBeat.i(42732);
    if (!Util.isEqual(apv(), paramString))
    {
      super.IH(paramString);
      ayv();
    }
    AppMethodBeat.o(42732);
  }
  
  public final void II(String paramString)
  {
    AppMethodBeat.i(42733);
    if (!Util.isEqual(apw(), paramString))
    {
      super.II(paramString);
      ayv();
    }
    AppMethodBeat.o(42733);
  }
  
  public final void IJ(String paramString)
  {
    AppMethodBeat.i(42736);
    if (!Util.isEqual(this.signature, paramString))
    {
      super.IJ(paramString);
      ayv();
    }
    AppMethodBeat.o(42736);
  }
  
  public void IK(String paramString)
  {
    AppMethodBeat.i(42737);
    if (!Util.isEqual(getProvince(), paramString))
    {
      super.IK(paramString);
      ayv();
    }
    AppMethodBeat.o(42737);
  }
  
  public void IL(String paramString)
  {
    AppMethodBeat.i(42738);
    if (!Util.isEqual(getCity(), paramString))
    {
      super.IL(paramString);
      ayv();
    }
    AppMethodBeat.o(42738);
  }
  
  public final void IM(String paramString)
  {
    AppMethodBeat.i(42739);
    if (!Util.isEqual(this.hDl, paramString))
    {
      super.IM(paramString);
      ayv();
    }
    AppMethodBeat.o(42739);
  }
  
  public final void IN(String paramString)
  {
    AppMethodBeat.i(42742);
    if (!Util.isEqual(this.hDm, paramString))
    {
      super.IN(paramString);
      ayv();
    }
    AppMethodBeat.o(42742);
  }
  
  public final void IO(String paramString)
  {
    AppMethodBeat.i(42743);
    if (!Util.isEqual(this.verifyInfo, paramString))
    {
      super.IO(paramString);
      ayv();
    }
    AppMethodBeat.o(42743);
  }
  
  public void IP(String paramString)
  {
    AppMethodBeat.i(42744);
    if (!Util.isEqual(this.hDn, paramString))
    {
      super.IP(paramString);
      ayv();
    }
    AppMethodBeat.o(42744);
  }
  
  public final void IQ(String paramString)
  {
    AppMethodBeat.i(42747);
    if (!Util.isEqual(this.hDq, paramString))
    {
      super.IQ(paramString);
      ayv();
    }
    AppMethodBeat.o(42747);
  }
  
  public final void IR(String paramString)
  {
    AppMethodBeat.i(42748);
    if (!Util.isEqual(this.hDr, paramString))
    {
      super.IR(paramString);
      ayv();
    }
    AppMethodBeat.o(42748);
  }
  
  public final void IS(String paramString)
  {
    AppMethodBeat.i(42749);
    if (!Util.isEqual(this.hDs, paramString))
    {
      super.IS(paramString);
      ayv();
    }
    AppMethodBeat.o(42749);
  }
  
  public final void IT(String paramString)
  {
    AppMethodBeat.i(42750);
    if (!Util.isEqual(this.hDt, paramString))
    {
      super.IT(paramString);
      ayv();
    }
    AppMethodBeat.o(42750);
  }
  
  public final void IU(String paramString)
  {
    AppMethodBeat.i(42751);
    if (!Util.isEqual(this.hDu, paramString))
    {
      super.IU(paramString);
      ayv();
    }
    AppMethodBeat.o(42751);
  }
  
  public final void IV(String paramString)
  {
    AppMethodBeat.i(42752);
    if (!Util.isEqual(this.hDv, paramString))
    {
      super.IV(paramString);
      ayv();
    }
    AppMethodBeat.o(42752);
  }
  
  public final void IW(String paramString)
  {
    AppMethodBeat.i(42753);
    if (!Util.isEqual(this.hDw, paramString))
    {
      super.IW(paramString);
      ayv();
    }
    AppMethodBeat.o(42753);
  }
  
  public final void IX(String paramString)
  {
    AppMethodBeat.i(42754);
    if (!Util.isEqual(this.hDx, paramString))
    {
      super.IX(paramString);
      ayv();
    }
    AppMethodBeat.o(42754);
  }
  
  public final void Iq(String paramString)
  {
    AppMethodBeat.i(42705);
    if (!Util.isEqual(apf(), paramString))
    {
      super.Iq(paramString);
      ayv();
    }
    AppMethodBeat.o(42705);
  }
  
  public final void Ir(String paramString)
  {
    AppMethodBeat.i(42706);
    if (!Util.isEqual(this.field_conRemark, paramString))
    {
      super.Ir(paramString);
      ayv();
    }
    AppMethodBeat.o(42706);
  }
  
  public final void Is(String paramString)
  {
    AppMethodBeat.i(42707);
    if (!Util.isEqual(this.field_domainList, paramString))
    {
      super.Is(paramString);
      ayv();
    }
    AppMethodBeat.o(42707);
  }
  
  public final void It(String paramString)
  {
    AppMethodBeat.i(42709);
    if (!Util.isEqual(aph(), paramString))
    {
      super.It(paramString);
      ayv();
    }
    AppMethodBeat.o(42709);
  }
  
  public final void Iu(String paramString)
  {
    AppMethodBeat.i(42710);
    if (!Util.isEqual(api(), paramString))
    {
      super.Iu(paramString);
      ayv();
    }
    AppMethodBeat.o(42710);
  }
  
  public final void Iv(String paramString)
  {
    AppMethodBeat.i(42714);
    if (!Util.isEqual(this.field_weiboNickname, paramString))
    {
      super.Iv(paramString);
      ayv();
    }
    AppMethodBeat.o(42714);
  }
  
  public final void Iw(String paramString)
  {
    AppMethodBeat.i(42715);
    if (!Util.isEqual(this.field_conRemarkPYFull, paramString))
    {
      super.Iw(paramString);
      ayv();
    }
    AppMethodBeat.o(42715);
  }
  
  public final void Ix(String paramString)
  {
    AppMethodBeat.i(42716);
    if (!Util.isEqual(this.field_conRemarkPYShort, paramString))
    {
      super.Ix(paramString);
      ayv();
    }
    AppMethodBeat.o(42716);
  }
  
  public final void Iy(String paramString)
  {
    AppMethodBeat.i(42719);
    if (!Util.isEqual(this.field_encryptUsername, paramString))
    {
      super.Iy(paramString);
      ayv();
    }
    AppMethodBeat.o(42719);
  }
  
  public final void Iz(String paramString)
  {
    AppMethodBeat.i(42722);
    if (!Util.isEqual(this.field_contactLabelIds, paramString))
    {
      super.Iz(paramString);
      ayv();
    }
    AppMethodBeat.o(42722);
  }
  
  public final boolean aeg()
  {
    return (this.field_type & 0x200) != 0;
  }
  
  public final void ag(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(42717);
    if (!Util.isEqual(apl(), paramArrayOfByte))
    {
      super.ag(paramArrayOfByte);
      ayv();
    }
    AppMethodBeat.o(42717);
  }
  
  public final String apf()
  {
    AppMethodBeat.i(42695);
    if (jxu != null) {}
    for (String str = jxu.hf(this.field_username); str == null; str = null)
    {
      str = super.apf();
      AppMethodBeat.o(42695);
      return str;
    }
    AppMethodBeat.o(42695);
    return str;
  }
  
  public final String aph()
  {
    AppMethodBeat.i(42693);
    if ((super.aph() == null) || (super.aph().length() < 0))
    {
      str = api();
      AppMethodBeat.o(42693);
      return str;
    }
    String str = super.aph();
    AppMethodBeat.o(42693);
    return str;
  }
  
  public final String api()
  {
    AppMethodBeat.i(42694);
    if ((super.api() == null) || (super.api().length() < 0))
    {
      str = this.field_nickname;
      AppMethodBeat.o(42694);
      return str;
    }
    String str = super.api();
    AppMethodBeat.o(42694);
    return str;
  }
  
  public final boolean asV()
  {
    return (this.field_type & 0x400) == 0;
  }
  
  public final void axA()
  {
    AppMethodBeat.i(42684);
    setType(this.field_type & 0xFFFFFFBF);
    AppMethodBeat.o(42684);
  }
  
  public final void axB()
  {
    AppMethodBeat.i(42685);
    setType(this.field_type | 0x200);
    AppMethodBeat.o(42685);
  }
  
  public final void axC()
  {
    AppMethodBeat.i(42686);
    setType(this.field_type & 0xFFFFFDFF);
    AppMethodBeat.o(42686);
  }
  
  public final void axD()
  {
    AppMethodBeat.i(42687);
    setType(this.field_type | 0x100);
    AppMethodBeat.o(42687);
  }
  
  public final void axE()
  {
    AppMethodBeat.i(42688);
    setType(this.field_type & 0xFFFFFEFF);
    AppMethodBeat.o(42688);
  }
  
  public final void axF()
  {
    AppMethodBeat.i(239139);
    setType(this.field_type | 0x100000);
    AppMethodBeat.o(239139);
  }
  
  public final void axG()
  {
    AppMethodBeat.i(239140);
    setType(this.field_type & 0xFFEFFFFF);
    AppMethodBeat.o(239140);
  }
  
  public final void axH()
  {
    AppMethodBeat.i(42689);
    setType(this.field_type | 0x800000);
    AppMethodBeat.o(42689);
  }
  
  public final void axI()
  {
    AppMethodBeat.i(42690);
    setType(this.field_type & 0xFF7FFFFF);
    AppMethodBeat.o(42690);
  }
  
  public final void axJ()
  {
    AppMethodBeat.i(239146);
    setType(this.field_type | 0x2000000);
    AppMethodBeat.o(239146);
  }
  
  public final void axK()
  {
    AppMethodBeat.i(239148);
    setType(this.field_type & 0xFDFFFFFF);
    AppMethodBeat.o(239148);
  }
  
  public final void axL()
  {
    AppMethodBeat.i(239150);
    setType(this.field_type | 0x8000000);
    AppMethodBeat.o(239150);
  }
  
  public final void axM()
  {
    AppMethodBeat.i(239152);
    setType(this.field_type & 0xF7FFFFFF);
    AppMethodBeat.o(239152);
  }
  
  public final boolean axZ()
  {
    AppMethodBeat.i(292923);
    boolean bool = rk(this.field_type);
    AppMethodBeat.o(292923);
    return bool;
  }
  
  public final int axh()
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
      if ((super.aph() != null) && (!super.aph().equals("")))
      {
        i = super.aph().charAt(0);
        break;
      }
      if ((super.api() != null) && (!super.api().equals("")))
      {
        i = super.api().charAt(0);
        break;
      }
      if ((this.field_nickname != null) && (!this.field_nickname.equals("")) && (C(this.field_nickname.charAt(0))))
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
      if (!C(this.field_username.charAt(0))) {
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
  
  public final void axi()
  {
    AppMethodBeat.i(42670);
    setType(0);
    AppMethodBeat.o(42670);
  }
  
  public final void axj()
  {
    AppMethodBeat.i(42671);
    setType(this.field_type | 0x4);
    AppMethodBeat.o(42671);
  }
  
  public final void axk()
  {
    AppMethodBeat.i(42672);
    setType(this.field_type | 0x1);
    AppMethodBeat.o(42672);
  }
  
  public final void axl()
  {
    AppMethodBeat.i(42673);
    Log.w("MicroMsg.RContact", "unSetContact!! user:%s oldType:%d [%s]", new Object[] { this.field_username, Integer.valueOf(this.field_type), Util.getStack() });
    setType(this.field_type & 0xFFFFFFFE);
    AppMethodBeat.o(42673);
  }
  
  public final void axm()
  {
    AppMethodBeat.i(42674);
    setType(this.field_type | 0x8);
    AppMethodBeat.o(42674);
  }
  
  public final void axn()
  {
    AppMethodBeat.i(42675);
    setType(this.field_type & 0xFFFFFFF7);
    AppMethodBeat.o(42675);
  }
  
  public final void axo()
  {
    AppMethodBeat.i(239128);
    setType(this.field_type | 0x20000);
    AppMethodBeat.o(239128);
  }
  
  public final void axp()
  {
    AppMethodBeat.i(239129);
    setType(this.field_type & 0xFFFDFFFF);
    AppMethodBeat.o(239129);
  }
  
  public final void axq()
  {
    AppMethodBeat.i(239130);
    setType(this.field_type | 0x40000);
    AppMethodBeat.o(239130);
  }
  
  public final void axr()
  {
    AppMethodBeat.i(239131);
    setType(this.field_type & 0xFFFBFFFF);
    AppMethodBeat.o(239131);
  }
  
  public final void axs()
  {
    AppMethodBeat.i(42676);
    setType(this.field_type | 0x80000);
    AppMethodBeat.o(42676);
  }
  
  public final void axt()
  {
    AppMethodBeat.i(42677);
    setType(this.field_type & 0xFFF7FFFF);
    AppMethodBeat.o(42677);
  }
  
  public final void axu()
  {
    AppMethodBeat.i(42678);
    setType(this.field_type | 0x2);
    AppMethodBeat.o(42678);
  }
  
  public final void axv()
  {
    AppMethodBeat.i(42679);
    setType(this.field_type & 0xFFFFFFFD);
    AppMethodBeat.o(42679);
  }
  
  public final void axw()
  {
    AppMethodBeat.i(42680);
    setType(this.field_type & 0xFFFFF7FF);
    AppMethodBeat.o(42680);
  }
  
  public final void axx()
  {
    AppMethodBeat.i(42681);
    setType(this.field_type | 0x20);
    AppMethodBeat.o(42681);
  }
  
  public final void axy()
  {
    AppMethodBeat.i(42682);
    setType(this.field_type & 0xFFFFFFDF);
    AppMethodBeat.o(42682);
  }
  
  public final void axz()
  {
    AppMethodBeat.i(42683);
    setType(this.field_type | 0x40);
    AppMethodBeat.o(42683);
  }
  
  public final boolean aya()
  {
    return (this.field_type & 0x2) != 0;
  }
  
  public final boolean ayb()
  {
    return (this.field_type & 0x4) != 0;
  }
  
  public final boolean ayc()
  {
    return (this.field_type & 0x8) != 0;
  }
  
  public final boolean ayd()
  {
    return (0x80000 & this.field_type) != 0;
  }
  
  public final boolean aye()
  {
    return (0x20000 & this.field_type) != 0;
  }
  
  public final boolean ayf()
  {
    return (0x40000 & this.field_type) != 0;
  }
  
  public final boolean ayg()
  {
    return (0x100000 & this.field_type) != 0;
  }
  
  public final boolean ayh()
  {
    return (this.field_type & 0x40) != 0;
  }
  
  public final boolean ayi()
  {
    return (this.field_type & 0x100) != 0;
  }
  
  public final boolean ayj()
  {
    return (0x10000 & this.field_type) != 0;
  }
  
  public final boolean ayk()
  {
    return (0x800000 & this.field_type) != 0;
  }
  
  public final boolean ayl()
  {
    return (0x2000000 & this.field_type) != 0;
  }
  
  public final boolean aym()
  {
    return (0x8000000 & this.field_type) != 0;
  }
  
  public final boolean ayn()
  {
    return (this.field_type & 0x800) != 0;
  }
  
  public final boolean ayo()
  {
    return (0x8000 & this.field_type) != 0;
  }
  
  public final void ayp()
  {
    AppMethodBeat.i(42692);
    setType(this.field_type | 0x8000);
    AppMethodBeat.o(42692);
  }
  
  public final int ayq()
  {
    return (int)this.jxt;
  }
  
  public final String ayr()
  {
    AppMethodBeat.i(42696);
    if (jxu != null) {}
    for (String str = jxu.he(this.field_username); str != null; str = null)
    {
      AppMethodBeat.o(42696);
      return str;
    }
    if ((this.field_nickname == null) || (this.field_nickname.length() <= 0))
    {
      str = ayt();
      AppMethodBeat.o(42696);
      return str;
    }
    str = this.field_nickname;
    AppMethodBeat.o(42696);
    return str;
  }
  
  public final String ays()
  {
    AppMethodBeat.i(42697);
    if ((this.field_conRemark != null) && (!this.field_conRemark.trim().equals("")))
    {
      str = this.field_conRemark;
      AppMethodBeat.o(42697);
      return str;
    }
    String str = ayr();
    AppMethodBeat.o(42697);
    return str;
  }
  
  public final String ayt()
  {
    AppMethodBeat.i(42698);
    String str = apf();
    if (!Util.isNullOrNil(str))
    {
      AppMethodBeat.o(42698);
      return str;
    }
    str = Lq(this.field_username);
    if ((str != null) && (str.length() != 0))
    {
      AppMethodBeat.o(42698);
      return str;
    }
    str = this.field_username;
    AppMethodBeat.o(42698);
    return str;
  }
  
  public final int ayu()
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
    this.jxt = this.systemRowid;
    super.ag(null);
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
  
  public final void pA(int paramInt)
  {
    AppMethodBeat.i(42734);
    if (!Util.isEqual(this.hDj, paramInt))
    {
      super.pA(paramInt);
      ayv();
    }
    AppMethodBeat.o(42734);
  }
  
  public final void pB(int paramInt)
  {
    AppMethodBeat.i(42735);
    if (!Util.isEqual(this.hDk, paramInt))
    {
      super.pB(paramInt);
      ayv();
    }
    AppMethodBeat.o(42735);
  }
  
  public final void pC(int paramInt)
  {
    AppMethodBeat.i(42745);
    if (!Util.isEqual(this.hDo, paramInt))
    {
      super.pC(paramInt);
      ayv();
    }
    AppMethodBeat.o(42745);
  }
  
  public final void pD(int paramInt)
  {
    AppMethodBeat.i(42746);
    if (!Util.isEqual(this.hDp, paramInt))
    {
      super.pD(paramInt);
      ayv();
    }
    AppMethodBeat.o(42746);
  }
  
  public final void pq(int paramInt)
  {
    AppMethodBeat.i(42711);
    if (!Util.isEqual(this.field_showHead, paramInt))
    {
      super.pq(paramInt);
      ayv();
    }
    AppMethodBeat.o(42711);
  }
  
  public final void pr(int paramInt)
  {
    AppMethodBeat.i(42713);
    if (!Util.isEqual(this.field_weiboFlag, paramInt))
    {
      super.pr(paramInt);
      ayv();
    }
    AppMethodBeat.o(42713);
  }
  
  public final void ps(int paramInt)
  {
    AppMethodBeat.i(42718);
    if (!Util.isEqual(this.field_verifyFlag, paramInt))
    {
      super.ps(paramInt);
      ayv();
    }
    AppMethodBeat.o(42718);
  }
  
  public final void pt(int paramInt)
  {
    AppMethodBeat.i(42720);
    if (!Util.isEqual(apo(), paramInt))
    {
      super.pt(paramInt);
      ayv();
    }
    AppMethodBeat.o(42720);
  }
  
  public final void pu(int paramInt)
  {
    AppMethodBeat.i(42721);
    if (!Util.isEqual(this.field_deleteFlag, paramInt))
    {
      super.pu(paramInt);
      ayv();
    }
    AppMethodBeat.o(42721);
  }
  
  public final void pv(int paramInt)
  {
    AppMethodBeat.i(42723);
    if (!Util.isEqual(this.hDc, paramInt))
    {
      super.pv(paramInt);
      ayv();
    }
    AppMethodBeat.o(42723);
  }
  
  public final void pw(int paramInt)
  {
    AppMethodBeat.i(42724);
    if (!Util.isEqual(this.sex, paramInt))
    {
      super.pw(paramInt);
      ayv();
    }
    AppMethodBeat.o(42724);
  }
  
  public final void py(int paramInt)
  {
    AppMethodBeat.i(42730);
    if (!Util.isEqual(getShowFlag(), paramInt))
    {
      super.py(paramInt);
      ayv();
    }
    AppMethodBeat.o(42730);
  }
  
  public final void pz(int paramInt)
  {
    AppMethodBeat.i(42731);
    if (!Util.isEqual(this.hDg, paramInt))
    {
      super.pz(paramInt);
      ayv();
    }
    AppMethodBeat.o(42731);
  }
  
  public final void rl(int paramInt)
  {
    AppMethodBeat.i(42702);
    pt(apo() & 0xFFFFFFFE | paramInt & 0x1);
    AppMethodBeat.o(42702);
  }
  
  public final void rm(int paramInt)
  {
    AppMethodBeat.i(239224);
    if (!Util.isEqual(this.field_type, paramInt))
    {
      super.setType(paramInt);
      ayv();
    }
    AppMethodBeat.o(239224);
  }
  
  public final void setFromType(int paramInt)
  {
    AppMethodBeat.i(42740);
    if (!Util.isEqual(getFromType(), paramInt))
    {
      super.setFromType(paramInt);
      ayv();
    }
    AppMethodBeat.o(42740);
  }
  
  public final void setNickname(String paramString)
  {
    AppMethodBeat.i(42708);
    if (!Util.isEqual(this.field_nickname, paramString))
    {
      super.setNickname(paramString);
      ayv();
    }
    AppMethodBeat.o(42708);
  }
  
  public final void setSource(int paramInt)
  {
    AppMethodBeat.i(42741);
    if (!Util.isEqual(super.getSource(), paramInt))
    {
      super.setSource(paramInt);
      ayv();
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
      ayv();
    }
    AppMethodBeat.o(42712);
  }
  
  public final void setUin(int paramInt)
  {
    AppMethodBeat.i(42727);
    if (!Util.isEqual(this.uin, paramInt))
    {
      super.setUin(paramInt);
      ayv();
    }
    AppMethodBeat.o(42727);
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(42704);
    if (!Util.isEqual(this.field_username, paramString))
    {
      super.setUsername(paramString);
      ayv();
    }
    Fa(ar.bvF(this.field_username));
    AppMethodBeat.o(42704);
  }
  
  public static abstract interface a
  {
    public abstract String he(String paramString);
    
    public abstract String hf(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.contact.d
 * JD-Core Version:    0.7.0.1
 */