package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_user
  extends JceStruct
{
  public int from = 1;
  public byte isAnnualVip = 0;
  public int isFamousWhite = 0;
  public int isQzoneUser = 0;
  public int is_own = 0;
  public int is_owner = 0;
  public int level = 0;
  public String logo = "";
  public String nickname = "";
  public int operation_mask = 0;
  public int portrait_id = 0;
  public String qzonedesc = "";
  public String talk_id = "";
  public int timestamp = 0;
  public String uid = "";
  public long uin = 0L;
  public String uinkey = "";
  public int vip = 0;
  public int viplevel = 0;
  public int viptype = 0;
  
  public s_user() {}
  
  public s_user(long paramLong, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString4, int paramInt7, int paramInt8, String paramString5, String paramString6, int paramInt9, int paramInt10, int paramInt11, int paramInt12, byte paramByte)
  {
    this.uin = paramLong;
    this.nickname = paramString1;
    this.timestamp = paramInt1;
    this.from = paramInt2;
    this.uinkey = paramString2;
    this.logo = paramString3;
    this.vip = paramInt3;
    this.level = paramInt4;
    this.viplevel = paramInt5;
    this.viptype = paramInt6;
    this.qzonedesc = paramString4;
    this.is_owner = paramInt7;
    this.operation_mask = paramInt8;
    this.uid = paramString5;
    this.talk_id = paramString6;
    this.portrait_id = paramInt9;
    this.is_own = paramInt10;
    this.isFamousWhite = paramInt11;
    this.isQzoneUser = paramInt12;
    this.isAnnualVip = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.nickname = paramJceInputStream.readString(1, false);
    this.timestamp = paramJceInputStream.read(this.timestamp, 2, false);
    this.from = paramJceInputStream.read(this.from, 3, false);
    this.uinkey = paramJceInputStream.readString(4, false);
    this.logo = paramJceInputStream.readString(5, false);
    this.vip = paramJceInputStream.read(this.vip, 6, false);
    this.level = paramJceInputStream.read(this.level, 7, false);
    this.viplevel = paramJceInputStream.read(this.viplevel, 8, false);
    this.viptype = paramJceInputStream.read(this.viptype, 9, false);
    this.qzonedesc = paramJceInputStream.readString(10, false);
    this.is_owner = paramJceInputStream.read(this.is_owner, 11, false);
    this.operation_mask = paramJceInputStream.read(this.operation_mask, 12, false);
    this.uid = paramJceInputStream.readString(13, false);
    this.talk_id = paramJceInputStream.readString(14, false);
    this.portrait_id = paramJceInputStream.read(this.portrait_id, 15, false);
    this.is_own = paramJceInputStream.read(this.is_own, 16, false);
    this.isFamousWhite = paramJceInputStream.read(this.isFamousWhite, 17, false);
    this.isQzoneUser = paramJceInputStream.read(this.isQzoneUser, 18, false);
    this.isAnnualVip = paramJceInputStream.read(this.isAnnualVip, 19, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.nickname != null) {
      paramJceOutputStream.write(this.nickname, 1);
    }
    paramJceOutputStream.write(this.timestamp, 2);
    paramJceOutputStream.write(this.from, 3);
    if (this.uinkey != null) {
      paramJceOutputStream.write(this.uinkey, 4);
    }
    if (this.logo != null) {
      paramJceOutputStream.write(this.logo, 5);
    }
    paramJceOutputStream.write(this.vip, 6);
    paramJceOutputStream.write(this.level, 7);
    paramJceOutputStream.write(this.viplevel, 8);
    paramJceOutputStream.write(this.viptype, 9);
    if (this.qzonedesc != null) {
      paramJceOutputStream.write(this.qzonedesc, 10);
    }
    paramJceOutputStream.write(this.is_owner, 11);
    paramJceOutputStream.write(this.operation_mask, 12);
    if (this.uid != null) {
      paramJceOutputStream.write(this.uid, 13);
    }
    if (this.talk_id != null) {
      paramJceOutputStream.write(this.talk_id, 14);
    }
    paramJceOutputStream.write(this.portrait_id, 15);
    paramJceOutputStream.write(this.is_own, 16);
    paramJceOutputStream.write(this.isFamousWhite, 17);
    paramJceOutputStream.write(this.isQzoneUser, 18);
    paramJceOutputStream.write(this.isAnnualVip, 19);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_user
 * JD-Core Version:    0.7.0.1
 */