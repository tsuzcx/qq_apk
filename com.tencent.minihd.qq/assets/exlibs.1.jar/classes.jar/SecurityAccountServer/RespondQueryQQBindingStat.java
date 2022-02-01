package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RespondQueryQQBindingStat
  extends JceStruct
{
  static int cache_type;
  public String MobileUniqueNo = "";
  public long bindingTime = 0L;
  public long isRecommend = 0L;
  public long lastUsedFlag = 1L;
  public String mobileNo = "";
  public String nationCode = "";
  public long originBinder = 0L;
  public int type = 0;
  
  public RespondQueryQQBindingStat() {}
  
  public RespondQueryQQBindingStat(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt)
  {
    this.nationCode = paramString1;
    this.mobileNo = paramString2;
    this.MobileUniqueNo = paramString3;
    this.isRecommend = paramLong1;
    this.originBinder = paramLong2;
    this.bindingTime = paramLong3;
    this.lastUsedFlag = paramLong4;
    this.type = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nationCode = paramJceInputStream.readString(0, true);
    this.mobileNo = paramJceInputStream.readString(1, true);
    this.MobileUniqueNo = paramJceInputStream.readString(2, true);
    this.isRecommend = paramJceInputStream.read(this.isRecommend, 3, true);
    this.originBinder = paramJceInputStream.read(this.originBinder, 4, true);
    this.bindingTime = paramJceInputStream.read(this.bindingTime, 5, false);
    this.lastUsedFlag = paramJceInputStream.read(this.lastUsedFlag, 6, false);
    this.type = paramJceInputStream.read(this.type, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nationCode, 0);
    paramJceOutputStream.write(this.mobileNo, 1);
    paramJceOutputStream.write(this.MobileUniqueNo, 2);
    paramJceOutputStream.write(this.isRecommend, 3);
    paramJceOutputStream.write(this.originBinder, 4);
    paramJceOutputStream.write(this.bindingTime, 5);
    paramJceOutputStream.write(this.lastUsedFlag, 6);
    paramJceOutputStream.write(this.type, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     SecurityAccountServer.RespondQueryQQBindingStat
 * JD-Core Version:    0.7.0.1
 */