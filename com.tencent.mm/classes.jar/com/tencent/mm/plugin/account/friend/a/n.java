package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.h.c.ca;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class n
  extends ca
{
  protected static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[16];
    locala.columns = new String[17];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "googleid";
    locala.ujN.put("googleid", "TEXT");
    localStringBuilder.append(" googleid TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "googlename";
    locala.ujN.put("googlename", "TEXT");
    localStringBuilder.append(" googlename TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "googlephotourl";
    locala.ujN.put("googlephotourl", "TEXT");
    localStringBuilder.append(" googlephotourl TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "googlegmail";
    locala.ujN.put("googlegmail", "TEXT");
    localStringBuilder.append(" googlegmail TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "username";
    locala.ujN.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "nickname";
    locala.ujN.put("nickname", "TEXT");
    localStringBuilder.append(" nickname TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "nicknameqp";
    locala.ujN.put("nicknameqp", "TEXT");
    localStringBuilder.append(" nicknameqp TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "usernamepy";
    locala.ujN.put("usernamepy", "TEXT");
    localStringBuilder.append(" usernamepy TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "small_url";
    locala.ujN.put("small_url", "TEXT");
    localStringBuilder.append(" small_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "big_url";
    locala.ujN.put("big_url", "TEXT");
    localStringBuilder.append(" big_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "ret";
    locala.ujN.put("ret", "INTEGER");
    localStringBuilder.append(" ret INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "status";
    locala.ujN.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "googleitemid";
    locala.ujN.put("googleitemid", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" googleitemid TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "googleitemid";
    locala.columns[13] = "googlecgistatus";
    locala.ujN.put("googlecgistatus", "INTEGER default '2' ");
    localStringBuilder.append(" googlecgistatus INTEGER default '2' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "contecttype";
    locala.ujN.put("contecttype", "TEXT");
    localStringBuilder.append(" contecttype TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "googlenamepy";
    locala.ujN.put("googlenamepy", "TEXT");
    localStringBuilder.append(" googlenamepy TEXT");
    locala.columns[16] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("googleIDgoogleid\n");
    localStringBuffer.append("googleNamegooglename\n");
    localStringBuffer.append("googlePhotoUrlgooglephotourl\n");
    localStringBuffer.append("googleGmailgooglegmail\n");
    localStringBuffer.append("userNameusername\n");
    localStringBuffer.append("nickNamenickname\n");
    localStringBuffer.append("nickNameQuanPinnicknameqp\n");
    localStringBuffer.append("nickNamePYInitialusernamepy\n");
    localStringBuffer.append("smallHeaderUrlsmall_url\n");
    localStringBuffer.append("bigHeaderUrlbig_url\n");
    localStringBuffer.append("retret\n");
    localStringBuffer.append("statusstatus\n");
    localStringBuffer.append("googleItemIDgoogleitemid\n");
    localStringBuffer.append("cgiStatusgooglecgistatus\n");
    localStringBuffer.append("contactTypecontecttype\n");
    localStringBuffer.append("googleNamePYInitialgooglenamepy\n");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.n
 * JD-Core Version:    0.7.0.1
 */