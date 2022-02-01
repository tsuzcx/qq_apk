package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ct;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class n
  extends ct
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(131047);
    c.a locala = new c.a();
    locala.GvF = new Field[16];
    locala.columns = new String[17];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "googleid";
    locala.GvH.put("googleid", "TEXT");
    localStringBuilder.append(" googleid TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "googlename";
    locala.GvH.put("googlename", "TEXT");
    localStringBuilder.append(" googlename TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "googlephotourl";
    locala.GvH.put("googlephotourl", "TEXT");
    localStringBuilder.append(" googlephotourl TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "googlegmail";
    locala.GvH.put("googlegmail", "TEXT");
    localStringBuilder.append(" googlegmail TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "username";
    locala.GvH.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "nickname";
    locala.GvH.put("nickname", "TEXT");
    localStringBuilder.append(" nickname TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "nicknameqp";
    locala.GvH.put("nicknameqp", "TEXT");
    localStringBuilder.append(" nicknameqp TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "usernamepy";
    locala.GvH.put("usernamepy", "TEXT");
    localStringBuilder.append(" usernamepy TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "small_url";
    locala.GvH.put("small_url", "TEXT");
    localStringBuilder.append(" small_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "big_url";
    locala.GvH.put("big_url", "TEXT");
    localStringBuilder.append(" big_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "ret";
    locala.GvH.put("ret", "INTEGER");
    localStringBuilder.append(" ret INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "status";
    locala.GvH.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "googleitemid";
    locala.GvH.put("googleitemid", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" googleitemid TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "googleitemid";
    locala.columns[13] = "googlecgistatus";
    locala.GvH.put("googlecgistatus", "INTEGER default '2' ");
    localStringBuilder.append(" googlecgistatus INTEGER default '2' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "contecttype";
    locala.GvH.put("contecttype", "TEXT");
    localStringBuilder.append(" contecttype TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "googlenamepy";
    locala.GvH.put("googlenamepy", "TEXT");
    localStringBuilder.append(" googlenamepy TEXT");
    locala.columns[16] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(131047);
  }
  
  public final c.a getDBInfo()
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