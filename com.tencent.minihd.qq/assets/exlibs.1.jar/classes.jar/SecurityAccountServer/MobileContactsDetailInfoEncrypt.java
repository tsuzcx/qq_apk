package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MobileContactsDetailInfoEncrypt
  extends JceStruct
{
  static byte[] cache_MobileNoMask;
  public byte[] MobileNoMask = null;
  public String QQ = "";
  public int accountAbi = 0;
  public long bindingDate = 0L;
  public String contactsInfoEncrypt = "";
  public long isRecommend = 0L;
  public String nickname = "";
  public long originBinder = 0L;
  public short rmdScore = 0;
  
  public MobileContactsDetailInfoEncrypt() {}
  
  public MobileContactsDetailInfoEncrypt(String paramString1, long paramLong1, long paramLong2, String paramString2, String paramString3, byte[] paramArrayOfByte, long paramLong3, int paramInt, short paramShort)
  {
    this.QQ = paramString1;
    this.bindingDate = paramLong1;
    this.isRecommend = paramLong2;
    this.nickname = paramString2;
    this.contactsInfoEncrypt = paramString3;
    this.MobileNoMask = paramArrayOfByte;
    this.originBinder = paramLong3;
    this.accountAbi = paramInt;
    this.rmdScore = paramShort;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.QQ = paramJceInputStream.readString(0, true);
    this.bindingDate = paramJceInputStream.read(this.bindingDate, 1, false);
    this.isRecommend = paramJceInputStream.read(this.isRecommend, 2, false);
    this.nickname = paramJceInputStream.readString(3, false);
    this.contactsInfoEncrypt = paramJceInputStream.readString(4, true);
    if (cache_MobileNoMask == null)
    {
      cache_MobileNoMask = (byte[])new byte[1];
      ((byte[])cache_MobileNoMask)[0] = 0;
    }
    this.MobileNoMask = ((byte[])paramJceInputStream.read(cache_MobileNoMask, 5, true));
    this.originBinder = paramJceInputStream.read(this.originBinder, 6, false);
    this.accountAbi = paramJceInputStream.read(this.accountAbi, 7, false);
    this.rmdScore = paramJceInputStream.read(this.rmdScore, 8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.QQ, 0);
    paramJceOutputStream.write(this.bindingDate, 1);
    paramJceOutputStream.write(this.isRecommend, 2);
    if (this.nickname != null) {
      paramJceOutputStream.write(this.nickname, 3);
    }
    paramJceOutputStream.write(this.contactsInfoEncrypt, 4);
    paramJceOutputStream.write(this.MobileNoMask, 5);
    paramJceOutputStream.write(this.originBinder, 6);
    paramJceOutputStream.write(this.accountAbi, 7);
    paramJceOutputStream.write(this.rmdScore, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     SecurityAccountServer.MobileContactsDetailInfoEncrypt
 * JD-Core Version:    0.7.0.1
 */