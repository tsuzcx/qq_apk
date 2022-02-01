package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.am;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.storage.ca;
import java.lang.reflect.Field;
import java.util.Map;

public final class h
  extends am
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(124069);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[6];
    localMAutoDBInfo.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "openId";
    localMAutoDBInfo.colsMap.put("openId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" openId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "openId";
    localMAutoDBInfo.columns[1] = "brandUsername";
    localMAutoDBInfo.colsMap.put("brandUsername", "TEXT default '' ");
    localStringBuilder.append(" brandUsername TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "headImgUrl";
    localMAutoDBInfo.colsMap.put("headImgUrl", "TEXT");
    localStringBuilder.append(" headImgUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "nickname";
    localMAutoDBInfo.colsMap.put("nickname", "TEXT");
    localStringBuilder.append(" nickname TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "kfType";
    localMAutoDBInfo.colsMap.put("kfType", "INTEGER");
    localStringBuilder.append(" kfType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localMAutoDBInfo.columns[6] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(124069);
  }
  
  public h() {}
  
  public h(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, long paramLong)
  {
    this.field_openId = paramString1;
    this.field_brandUsername = paramString2;
    this.field_headImgUrl = paramString3;
    this.field_nickname = paramString4;
    this.field_kfType = paramInt;
    this.field_updateTime = paramLong;
  }
  
  public static boolean R(ca paramca)
  {
    AppMethodBeat.i(176137);
    if ((paramca == null) || (Util.isNullOrNil(paramca.field_talker)))
    {
      AppMethodBeat.o(176137);
      return false;
    }
    if (paramca.fRf == 2)
    {
      AppMethodBeat.o(176137);
      return true;
    }
    if ((!Util.isNullOrNil(paramca.fQZ)) && (g.Nb(paramca.field_talker)))
    {
      paramca = ag.bag().Nm(paramca.fQZ);
      if ((paramca != null) && (paramca.field_kfType == 2))
      {
        AppMethodBeat.o(176137);
        return true;
      }
    }
    AppMethodBeat.o(176137);
    return false;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.al.h
 * JD-Core Version:    0.7.0.1
 */