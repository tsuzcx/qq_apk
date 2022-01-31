package com.tencent.mm.n;

import android.database.Cursor;
import com.tencent.mm.a.o;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Field;
import java.util.Map;

public class a
  extends ao
{
  public static c.a buS;
  private static a dBf = null;
  public long dBe;
  public int versionCode = 0;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[21];
    locala.columns = new String[22];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.ujN.put("username", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "username";
    locala.columns[1] = "alias";
    locala.ujN.put("alias", "TEXT default '' ");
    localStringBuilder.append(" alias TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "conRemark";
    locala.ujN.put("conRemark", "TEXT default '' ");
    localStringBuilder.append(" conRemark TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "domainList";
    locala.ujN.put("domainList", "TEXT default '' ");
    localStringBuilder.append(" domainList TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "nickname";
    locala.ujN.put("nickname", "TEXT default '' ");
    localStringBuilder.append(" nickname TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "pyInitial";
    locala.ujN.put("pyInitial", "TEXT default '' ");
    localStringBuilder.append(" pyInitial TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "quanPin";
    locala.ujN.put("quanPin", "TEXT default '' ");
    localStringBuilder.append(" quanPin TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "showHead";
    locala.ujN.put("showHead", "INTEGER default '0' ");
    localStringBuilder.append(" showHead INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "type";
    locala.ujN.put("type", "INTEGER default '0' ");
    localStringBuilder.append(" type INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "weiboFlag";
    locala.ujN.put("weiboFlag", "INTEGER default '0' ");
    localStringBuilder.append(" weiboFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "weiboNickname";
    locala.ujN.put("weiboNickname", "TEXT default '' ");
    localStringBuilder.append(" weiboNickname TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "conRemarkPYFull";
    locala.ujN.put("conRemarkPYFull", "TEXT default '' ");
    localStringBuilder.append(" conRemarkPYFull TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "conRemarkPYShort";
    locala.ujN.put("conRemarkPYShort", "TEXT default '' ");
    localStringBuilder.append(" conRemarkPYShort TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "lvbuff";
    locala.ujN.put("lvbuff", "BLOB");
    localStringBuilder.append(" lvbuff BLOB");
    localStringBuilder.append(", ");
    locala.columns[14] = "verifyFlag";
    locala.ujN.put("verifyFlag", "INTEGER default '0' ");
    localStringBuilder.append(" verifyFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[15] = "encryptUsername";
    locala.ujN.put("encryptUsername", "TEXT default '' ");
    localStringBuilder.append(" encryptUsername TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[16] = "chatroomFlag";
    locala.ujN.put("chatroomFlag", "INTEGER");
    localStringBuilder.append(" chatroomFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[17] = "deleteFlag";
    locala.ujN.put("deleteFlag", "INTEGER default '0' ");
    localStringBuilder.append(" deleteFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "contactLabelIds";
    locala.ujN.put("contactLabelIds", "TEXT default '' ");
    localStringBuilder.append(" contactLabelIds TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[19] = "descWordingId";
    locala.ujN.put("descWordingId", "TEXT default '' ");
    localStringBuilder.append(" descWordingId TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[20] = "openImAppid";
    locala.ujN.put("openImAppid", "TEXT");
    localStringBuilder.append(" openImAppid TEXT");
    locala.columns[21] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  public a()
  {
    super.setUsername("");
    super.dk("");
    super.dl("");
    super.dm("");
    super.cZ("");
    super.df("");
    super.dp("");
    super.jdMethod_do("");
    super.dg("");
    super.fh(0);
    super.dn("");
    super.fg(0);
    super.setType(0);
    super.fi(0);
    super.fj(0);
    super.dr("");
    super.fm(0);
    super.dC("");
    super.fs(0);
    super.fn(0);
    super.dv("");
    super.dw("");
    super.fo(0);
    super.fp(0);
    super.dx("");
    super.dy("");
    super.fq(1);
    super.fl(0);
    super.fr(0);
    super.dz("");
    super.dA("");
    super.dB("");
    super.setSource(0);
    super.dE("");
    super.dD("");
    super.aZ(0L);
    super.du("");
    super.dF("");
    super.ft(0);
    super.dI("");
    super.dJ("");
    super.dK("");
    super.dN("");
    super.ds("");
    super.dt("");
    this.versionCode = 0;
  }
  
  public a(String paramString)
  {
    this();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    setUsername(str);
  }
  
  public static int AY()
  {
    return 1;
  }
  
  public static int AZ()
  {
    return 8;
  }
  
  public static int Ba()
  {
    return 524288;
  }
  
  public static int Bb()
  {
    return 16;
  }
  
  public static int Bc()
  {
    return 32;
  }
  
  private int Bt()
  {
    int i = this.versionCode + 1;
    this.versionCode = i;
    return i;
  }
  
  public static void a(a parama)
  {
    dBf = parama;
  }
  
  public static String ft(String paramString)
  {
    if (dBf != null) {
      return dBf.cx(paramString);
    }
    return null;
  }
  
  public static boolean gR(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  private static boolean isLetter(char paramChar)
  {
    return ((paramChar >= 'A') && (paramChar <= 'Z')) || ((paramChar >= 'a') && (paramChar <= 'z'));
  }
  
  public final int AE()
  {
    int j = 32;
    int i;
    if ((this.field_conRemarkPYShort != null) && (!this.field_conRemarkPYShort.equals("")))
    {
      i = this.field_conRemarkPYShort.charAt(0);
      if ((i < 97) || (i > 122)) {
        break label240;
      }
      j = (char)(i - 32);
    }
    label240:
    do
    {
      return j;
      if ((this.field_conRemarkPYFull != null) && (!this.field_conRemarkPYFull.equals("")))
      {
        i = this.field_conRemarkPYFull.charAt(0);
        break;
      }
      if ((super.vn() != null) && (!super.vn().equals("")))
      {
        i = super.vn().charAt(0);
        break;
      }
      if ((super.vo() != null) && (!super.vo().equals("")))
      {
        i = super.vo().charAt(0);
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
      if (i < 65) {
        break label254;
      }
      j = i;
    } while (i <= 90);
    label254:
    return 123;
  }
  
  public final void AF()
  {
    setType(0);
  }
  
  public final void AG()
  {
    setType(this.field_type | 0x4);
  }
  
  public final void AH()
  {
    setType(this.field_type | 0x1);
  }
  
  public final void AI()
  {
    y.w("MicroMsg.RContact", "unSetContact!! user:%s oldType:%d [%s]", new Object[] { this.field_username, Integer.valueOf(this.field_type), bk.csb() });
    setType(this.field_type & 0xFFFFFFFE);
  }
  
  public final void AJ()
  {
    setType(this.field_type | 0x8);
  }
  
  public final void AK()
  {
    setType(this.field_type & 0xFFFFFFF7);
  }
  
  public final void AL()
  {
    setType(this.field_type | 0x80000);
  }
  
  public final void AM()
  {
    setType(this.field_type & 0xFFF7FFFF);
  }
  
  public final void AN()
  {
    setType(this.field_type | 0x2);
  }
  
  public final void AO()
  {
    setType(this.field_type & 0xFFFFFFFD);
  }
  
  public final void AP()
  {
    setType(this.field_type & 0xFFFFF7FF);
  }
  
  public final void AQ()
  {
    setType(this.field_type | 0x20);
  }
  
  public final void AR()
  {
    setType(this.field_type & 0xFFFFFFDF);
  }
  
  public final void AS()
  {
    setType(this.field_type | 0x40);
  }
  
  public final void AT()
  {
    setType(this.field_type & 0xFFFFFFBF);
  }
  
  public final void AU()
  {
    setType(this.field_type | 0x200);
  }
  
  public final void AV()
  {
    setType(this.field_type & 0xFFFFFDFF);
  }
  
  public final void AW()
  {
    setType(this.field_type | 0x100);
  }
  
  public final void AX()
  {
    setType(this.field_type & 0xFFFFFEFF);
  }
  
  public final boolean Bd()
  {
    return gR(this.field_type);
  }
  
  public final boolean Be()
  {
    return (this.field_type & 0x2) != 0;
  }
  
  public final boolean Bf()
  {
    return (this.field_type & 0x4) != 0;
  }
  
  public final boolean Bg()
  {
    return (this.field_type & 0x8) != 0;
  }
  
  public final boolean Bh()
  {
    return (0x80000 & this.field_type) != 0;
  }
  
  public final boolean Bi()
  {
    return (this.field_type & 0x40) != 0;
  }
  
  public final boolean Bj()
  {
    return (this.field_type & 0x200) != 0;
  }
  
  public final boolean Bk()
  {
    return (this.field_type & 0x100) != 0;
  }
  
  public final boolean Bl()
  {
    return (this.field_type & 0x800) != 0;
  }
  
  public final boolean Bm()
  {
    return (0x8000 & this.field_type) != 0;
  }
  
  public final void Bn()
  {
    setType(this.field_type | 0x8000);
  }
  
  public final int Bo()
  {
    return (int)this.dBe;
  }
  
  public final String Bp()
  {
    if (dBf != null) {}
    for (String str = dBf.cx(this.field_username); str != null; str = null) {
      return str;
    }
    if ((this.field_nickname == null) || (this.field_nickname.length() <= 0)) {
      return Br();
    }
    return this.field_nickname;
  }
  
  public final String Bq()
  {
    if ((this.field_conRemark != null) && (!this.field_conRemark.trim().equals(""))) {
      return this.field_conRemark;
    }
    return Bp();
  }
  
  public final String Br()
  {
    Object localObject2 = vk();
    if (!bk.bl((String)localObject2)) {
      return localObject2;
    }
    localObject2 = this.field_username;
    Object localObject1;
    if (localObject2 == null) {
      localObject1 = null;
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((String)localObject1).length() != 0) {
          break;
        }
      }
      return this.field_username;
      if (((String)localObject2).toLowerCase().endsWith("@t.qq.com"))
      {
        localObject1 = "@" + ((String)localObject2).replace("@t.qq.com", "");
      }
      else
      {
        localObject1 = localObject2;
        if (((String)localObject2).toLowerCase().endsWith("@qqim"))
        {
          localObject1 = ((String)localObject2).replace("@qqim", "");
          long l = Long.valueOf((String)localObject1).longValue();
          if (l < 0L) {
            localObject1 = new o(l).toString();
          }
        }
      }
    }
  }
  
  public final int Bs()
  {
    return super.getSource();
  }
  
  public final void aZ(long paramLong)
  {
    if (!bk.T(this.cCs, paramLong))
    {
      super.aZ(paramLong);
      Bt();
    }
  }
  
  public final void cZ(String paramString)
  {
    if (!bk.isEqual(vk(), paramString))
    {
      super.cZ(paramString);
      Bt();
    }
  }
  
  public final void d(Cursor paramCursor)
  {
    super.d(paramCursor);
    this.dBe = this.ujK;
    super.v(null);
  }
  
  public void dA(String paramString)
  {
    if (!bk.isEqual(getProvince(), paramString))
    {
      super.dA(paramString);
      Bt();
    }
  }
  
  public void dB(String paramString)
  {
    if (!bk.isEqual(getCity(), paramString))
    {
      super.dB(paramString);
      Bt();
    }
  }
  
  public final void dC(String paramString)
  {
    if (!bk.isEqual(this.cCC, paramString))
    {
      super.dC(paramString);
      Bt();
    }
  }
  
  public final void dD(String paramString)
  {
    if (!bk.isEqual(this.cCE, paramString))
    {
      super.dD(paramString);
      Bt();
    }
  }
  
  public final void dE(String paramString)
  {
    if (!bk.isEqual(this.cCF, paramString))
    {
      super.dE(paramString);
      Bt();
    }
  }
  
  public void dF(String paramString)
  {
    if (!bk.isEqual(this.cCG, paramString))
    {
      super.dF(paramString);
      Bt();
    }
  }
  
  public final void dG(String paramString)
  {
    if (!bk.isEqual(this.cCJ, paramString))
    {
      super.dG(paramString);
      Bt();
    }
  }
  
  public final void dH(String paramString)
  {
    if (!bk.isEqual(this.cCK, paramString))
    {
      super.dH(paramString);
      Bt();
    }
  }
  
  public final void dI(String paramString)
  {
    if (!bk.isEqual(this.cCL, paramString))
    {
      super.dI(paramString);
      Bt();
    }
  }
  
  public final void dJ(String paramString)
  {
    if (!bk.isEqual(this.cCM, paramString))
    {
      super.dJ(paramString);
      Bt();
    }
  }
  
  public final void dK(String paramString)
  {
    if (!bk.isEqual(this.cCN, paramString))
    {
      super.dK(paramString);
      Bt();
    }
  }
  
  public final void dL(String paramString)
  {
    if (!bk.isEqual(this.cCO, paramString))
    {
      super.dL(paramString);
      Bt();
    }
  }
  
  public final void dM(String paramString)
  {
    if (!bk.isEqual(this.cCP, paramString))
    {
      super.dM(paramString);
      Bt();
    }
  }
  
  public final void dN(String paramString)
  {
    if (!bk.isEqual(this.cCQ, paramString))
    {
      super.dN(paramString);
      Bt();
    }
  }
  
  public final void df(String paramString)
  {
    if (!bk.isEqual(this.field_conRemark, paramString))
    {
      super.df(paramString);
      Bt();
    }
  }
  
  public final void dg(String paramString)
  {
    if (!bk.isEqual(this.field_domainList, paramString))
    {
      super.dg(paramString);
      Bt();
    }
  }
  
  public final void dk(String paramString)
  {
    if (!bk.isEqual(this.field_nickname, paramString))
    {
      super.dk(paramString);
      Bt();
    }
  }
  
  public final void dl(String paramString)
  {
    if (!bk.isEqual(vn(), paramString))
    {
      super.dl(paramString);
      Bt();
    }
  }
  
  public final void dm(String paramString)
  {
    if (!bk.isEqual(vo(), paramString))
    {
      super.dm(paramString);
      Bt();
    }
  }
  
  public final void dn(String paramString)
  {
    if (!bk.isEqual(this.field_weiboNickname, paramString))
    {
      super.dn(paramString);
      Bt();
    }
  }
  
  public final void jdMethod_do(String paramString)
  {
    if (!bk.isEqual(this.field_conRemarkPYFull, paramString))
    {
      super.jdMethod_do(paramString);
      Bt();
    }
  }
  
  public final void dp(String paramString)
  {
    if (!bk.isEqual(this.field_conRemarkPYShort, paramString))
    {
      super.dp(paramString);
      Bt();
    }
  }
  
  public final void dq(String paramString)
  {
    if (!bk.isEqual(this.field_encryptUsername, paramString))
    {
      super.dq(paramString);
      Bt();
    }
  }
  
  public final void dr(String paramString)
  {
    if (!bk.isEqual(this.field_contactLabelIds, paramString))
    {
      super.dr(paramString);
      Bt();
    }
  }
  
  public final void dt(String paramString)
  {
    if (!bk.isEqual(this.field_openImAppid, paramString))
    {
      super.dt(paramString);
      Bt();
    }
  }
  
  public final void du(String paramString)
  {
    if (!bk.isEqual(this.cCr, paramString))
    {
      super.du(paramString);
      Bt();
    }
  }
  
  public final void dv(String paramString)
  {
    if (!bk.isEqual(this.cCt, paramString))
    {
      super.dv(paramString);
      Bt();
    }
  }
  
  public final void dw(String paramString)
  {
    if (!bk.isEqual(this.bSe, paramString))
    {
      super.dw(paramString);
      Bt();
    }
  }
  
  public final void dx(String paramString)
  {
    if (!bk.isEqual(this.cCw, paramString))
    {
      super.dx(paramString);
      Bt();
    }
  }
  
  public final void dy(String paramString)
  {
    if (!bk.isEqual(this.cCx, paramString))
    {
      super.dy(paramString);
      Bt();
    }
  }
  
  public final void dz(String paramString)
  {
    if (!bk.isEqual(this.signature, paramString))
    {
      super.dz(paramString);
      Bt();
    }
  }
  
  public final void fg(int paramInt)
  {
    if (!bk.ff(this.field_showHead, paramInt))
    {
      super.fg(paramInt);
      Bt();
    }
  }
  
  public final void fh(int paramInt)
  {
    if (!bk.ff(this.field_weiboFlag, paramInt))
    {
      super.fh(paramInt);
      Bt();
    }
  }
  
  public final void fi(int paramInt)
  {
    if (!bk.ff(this.field_verifyFlag, paramInt))
    {
      super.fi(paramInt);
      Bt();
    }
  }
  
  public final void fj(int paramInt)
  {
    if (!bk.ff(this.field_chatroomFlag, paramInt))
    {
      super.fj(paramInt);
      Bt();
    }
  }
  
  public final void fk(int paramInt)
  {
    if (!bk.ff(this.field_deleteFlag, paramInt))
    {
      super.fk(paramInt);
      Bt();
    }
  }
  
  public final void fl(int paramInt)
  {
    if (!bk.ff(this.cCq, paramInt))
    {
      super.fl(paramInt);
      Bt();
    }
  }
  
  public final void fm(int paramInt)
  {
    if (!bk.ff(this.sex, paramInt))
    {
      super.fm(paramInt);
      Bt();
    }
  }
  
  public final void fn(int paramInt)
  {
    if (!bk.ff(this.uin, paramInt))
    {
      super.fn(paramInt);
      Bt();
    }
  }
  
  public final void fo(int paramInt)
  {
    if (!bk.ff(this.cCu, paramInt))
    {
      super.fo(paramInt);
      Bt();
    }
  }
  
  public final void fp(int paramInt)
  {
    if (!bk.ff(this.cCv, paramInt))
    {
      super.fp(paramInt);
      Bt();
    }
  }
  
  public final void fq(int paramInt)
  {
    if (!bk.ff(this.cCy, paramInt))
    {
      super.fq(paramInt);
      Bt();
    }
  }
  
  public final void fr(int paramInt)
  {
    if (!bk.ff(this.cCz, paramInt))
    {
      super.fr(paramInt);
      Bt();
    }
  }
  
  public final void fs(int paramInt)
  {
    if (!bk.ff(this.cCD, paramInt))
    {
      super.fs(paramInt);
      Bt();
    }
  }
  
  public final void ft(int paramInt)
  {
    if (!bk.ff(this.cCH, paramInt))
    {
      super.ft(paramInt);
      Bt();
    }
  }
  
  public final void fu(int paramInt)
  {
    if (!bk.ff(this.cCI, paramInt))
    {
      super.fu(paramInt);
      Bt();
    }
  }
  
  public final void gS(int paramInt)
  {
    fj(this.field_chatroomFlag & 0xFFFFFFFE | paramInt & 0x1);
  }
  
  public final int getSource()
  {
    return super.getSource() % 1000000;
  }
  
  public final boolean isHidden()
  {
    return (this.field_type & 0x20) != 0;
  }
  
  public final c.a rM()
  {
    return buS;
  }
  
  public final void setSource(int paramInt)
  {
    if (!bk.ff(super.getSource(), paramInt))
    {
      super.setSource(paramInt);
      Bt();
    }
  }
  
  public final void setType(int paramInt)
  {
    if (!bk.ff(this.field_type, paramInt))
    {
      super.setType(paramInt);
      Bt();
    }
  }
  
  public final void setUsername(String paramString)
  {
    if (!bk.isEqual(this.field_username, paramString))
    {
      super.setUsername(paramString);
      Bt();
    }
  }
  
  public final void v(byte[] paramArrayOfByte)
  {
    if (!bk.isEqual(this.field_lvbuff, paramArrayOfByte))
    {
      super.v(paramArrayOfByte);
      Bt();
    }
  }
  
  public final String vk()
  {
    if (dBf != null) {}
    for (String str1 = dBf.cy(this.field_username);; str1 = null)
    {
      String str2 = str1;
      if (str1 == null) {
        str2 = super.vk();
      }
      return str2;
    }
  }
  
  public final String vn()
  {
    if ((super.vn() == null) || (super.vn().length() < 0)) {
      return vo();
    }
    return super.vn();
  }
  
  public final String vo()
  {
    if ((super.vo() == null) || (super.vo().length() < 0)) {
      return this.field_nickname;
    }
    return super.vo();
  }
  
  public final boolean xG()
  {
    return (this.field_type & 0x400) == 0;
  }
  
  public static abstract interface a
  {
    public abstract String cx(String paramString);
    
    public abstract String cy(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.n.a
 * JD-Core Version:    0.7.0.1
 */