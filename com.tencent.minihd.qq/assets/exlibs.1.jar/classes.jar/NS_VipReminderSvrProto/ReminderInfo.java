package NS_VipReminderSvrProto;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ReminderInfo
  extends JceStruct
{
  static ArrayList cache_vecQbossAdv;
  public int iQbAccount = 0;
  public int iRecoverScore = 0;
  public int iRemindType = 0;
  public String sSVipOverDay = "";
  public String sVipOverDay = "";
  public String sYVipOverDay = "";
  public long uiExpire = 0L;
  public long uiSExpire = 0L;
  public long uiYExpire = 0L;
  public ArrayList vecQbossAdv = null;
  
  public ReminderInfo() {}
  
  public ReminderInfo(int paramInt1, int paramInt2, int paramInt3, ArrayList paramArrayList, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, long paramLong3)
  {
    this.iRemindType = paramInt1;
    this.iQbAccount = paramInt2;
    this.iRecoverScore = paramInt3;
    this.vecQbossAdv = paramArrayList;
    this.sVipOverDay = paramString1;
    this.sYVipOverDay = paramString2;
    this.sSVipOverDay = paramString3;
    this.uiExpire = paramLong1;
    this.uiYExpire = paramLong2;
    this.uiSExpire = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iRemindType = paramJceInputStream.read(this.iRemindType, 0, true);
    this.iQbAccount = paramJceInputStream.read(this.iQbAccount, 1, true);
    this.iRecoverScore = paramJceInputStream.read(this.iRecoverScore, 2, false);
    if (cache_vecQbossAdv == null)
    {
      cache_vecQbossAdv = new ArrayList();
      QbossAdv localQbossAdv = new QbossAdv();
      cache_vecQbossAdv.add(localQbossAdv);
    }
    this.vecQbossAdv = ((ArrayList)paramJceInputStream.read(cache_vecQbossAdv, 3, true));
    this.sVipOverDay = paramJceInputStream.readString(4, true);
    this.sYVipOverDay = paramJceInputStream.readString(5, true);
    this.sSVipOverDay = paramJceInputStream.readString(6, true);
    this.uiExpire = paramJceInputStream.read(this.uiExpire, 7, true);
    this.uiYExpire = paramJceInputStream.read(this.uiYExpire, 8, true);
    this.uiSExpire = paramJceInputStream.read(this.uiSExpire, 9, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iRemindType, 0);
    paramJceOutputStream.write(this.iQbAccount, 1);
    paramJceOutputStream.write(this.iRecoverScore, 2);
    paramJceOutputStream.write(this.vecQbossAdv, 3);
    paramJceOutputStream.write(this.sVipOverDay, 4);
    paramJceOutputStream.write(this.sYVipOverDay, 5);
    paramJceOutputStream.write(this.sSVipOverDay, 6);
    paramJceOutputStream.write(this.uiExpire, 7);
    paramJceOutputStream.write(this.uiYExpire, 8);
    paramJceOutputStream.write(this.uiSExpire, 9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_VipReminderSvrProto.ReminderInfo
 * JD-Core Version:    0.7.0.1
 */