package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.dm;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class n
  extends dm
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(131047);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[16];
    localMAutoDBInfo.columns = new String[17];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "googleid";
    localMAutoDBInfo.colsMap.put("googleid", "TEXT");
    localStringBuilder.append(" googleid TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "googlename";
    localMAutoDBInfo.colsMap.put("googlename", "TEXT");
    localStringBuilder.append(" googlename TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "googlephotourl";
    localMAutoDBInfo.colsMap.put("googlephotourl", "TEXT");
    localStringBuilder.append(" googlephotourl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "googlegmail";
    localMAutoDBInfo.colsMap.put("googlegmail", "TEXT");
    localStringBuilder.append(" googlegmail TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "username";
    localMAutoDBInfo.colsMap.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "nickname";
    localMAutoDBInfo.colsMap.put("nickname", "TEXT");
    localStringBuilder.append(" nickname TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "nicknameqp";
    localMAutoDBInfo.colsMap.put("nicknameqp", "TEXT");
    localStringBuilder.append(" nicknameqp TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "usernamepy";
    localMAutoDBInfo.colsMap.put("usernamepy", "TEXT");
    localStringBuilder.append(" usernamepy TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "small_url";
    localMAutoDBInfo.colsMap.put("small_url", "TEXT");
    localStringBuilder.append(" small_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "big_url";
    localMAutoDBInfo.colsMap.put("big_url", "TEXT");
    localStringBuilder.append(" big_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "ret";
    localMAutoDBInfo.colsMap.put("ret", "INTEGER");
    localStringBuilder.append(" ret INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "googleitemid";
    localMAutoDBInfo.colsMap.put("googleitemid", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" googleitemid TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "googleitemid";
    localMAutoDBInfo.columns[13] = "googlecgistatus";
    localMAutoDBInfo.colsMap.put("googlecgistatus", "INTEGER default '2' ");
    localStringBuilder.append(" googlecgistatus INTEGER default '2' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "contecttype";
    localMAutoDBInfo.colsMap.put("contecttype", "TEXT");
    localStringBuilder.append(" contecttype TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "googlenamepy";
    localMAutoDBInfo.colsMap.put("googlenamepy", "TEXT");
    localStringBuilder.append(" googlenamepy TEXT");
    localMAutoDBInfo.columns[16] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(131047);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(131046);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("googleIDgoogleid\n");
    ((StringBuffer)localObject).append("googleNamegooglename\n");
    ((StringBuffer)localObject).append("googlePhotoUrlgooglephotourl\n");
    ((StringBuffer)localObject).append("googleGmailgooglegmail\n");
    ((StringBuffer)localObject).append("userNameusername\n");
    ((StringBuffer)localObject).append("nickNamenickname\n");
    ((StringBuffer)localObject).append("nickNameQuanPinnicknameqp\n");
    ((StringBuffer)localObject).append("nickNamePYInitialusernamepy\n");
    ((StringBuffer)localObject).append("smallHeaderUrlsmall_url\n");
    ((StringBuffer)localObject).append("bigHeaderUrlbig_url\n");
    ((StringBuffer)localObject).append("retret\n");
    ((StringBuffer)localObject).append("statusstatus\n");
    ((StringBuffer)localObject).append("googleItemIDgoogleitemid\n");
    ((StringBuffer)localObject).append("cgiStatusgooglecgistatus\n");
    ((StringBuffer)localObject).append("contactTypecontecttype\n");
    ((StringBuffer)localObject).append("googleNamePYInitialgooglenamepy\n");
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(131046);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.n
 * JD-Core Version:    0.7.0.1
 */