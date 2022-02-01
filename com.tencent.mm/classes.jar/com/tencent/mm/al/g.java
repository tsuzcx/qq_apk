package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.al;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import java.lang.reflect.Field;
import java.util.Map;

public final class g
  extends al
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(124069);
    c.a locala = new c.a();
    locala.GvF = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "openId";
    locala.GvH.put("openId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" openId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "openId";
    locala.columns[1] = "brandUsername";
    locala.GvH.put("brandUsername", "TEXT default '' ");
    localStringBuilder.append(" brandUsername TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "headImgUrl";
    locala.GvH.put("headImgUrl", "TEXT");
    localStringBuilder.append(" headImgUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "nickname";
    locala.GvH.put("nickname", "TEXT");
    localStringBuilder.append(" nickname TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "kfType";
    locala.GvH.put("kfType", "INTEGER");
    localStringBuilder.append(" kfType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "updateTime";
    locala.GvH.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    locala.columns[6] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(124069);
  }
  
  public g() {}
  
  public g(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, long paramLong)
  {
    this.field_openId = paramString1;
    this.field_brandUsername = paramString2;
    this.field_headImgUrl = paramString3;
    this.field_nickname = paramString4;
    this.field_kfType = paramInt;
    this.field_updateTime = paramLong;
  }
  
  public static boolean F(bo parambo)
  {
    AppMethodBeat.i(176137);
    if ((parambo == null) || (bs.isNullOrNil(parambo.field_talker)))
    {
      AppMethodBeat.o(176137);
      return false;
    }
    if (parambo.eSp == 2)
    {
      AppMethodBeat.o(176137);
      return true;
    }
    if ((!bs.isNullOrNil(parambo.eSj)) && (f.AM(parambo.field_talker)))
    {
      parambo = af.aCV().AX(parambo.eSj);
      if ((parambo != null) && (parambo.field_kfType == 2))
      {
        AppMethodBeat.o(176137);
        return true;
      }
    }
    AppMethodBeat.o(176137);
    return false;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.g
 * JD-Core Version:    0.7.0.1
 */