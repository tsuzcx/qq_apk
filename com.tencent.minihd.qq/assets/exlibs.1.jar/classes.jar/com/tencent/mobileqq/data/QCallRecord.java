package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.persistence.Entity;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class QCallRecord
  extends Entity
{
  private static final int Kilo = 1000;
  public static int TYPE_DATE = 0;
  public static int TYPE_REALRECORD = 1;
  public static final int VERSION_CODE = 1;
  public int contactId = -1;
  public String friendUin;
  public int isVideo;
  public int issend = 1;
  public byte[] msgData;
  public String senderuin;
  public int state;
  public String talkTime;
  public long time;
  public String troopUin;
  public int type = TYPE_REALRECORD;
  public int uinType;
  public long uniseq;
  public int versionCode = 1;
  
  public QCallRecord()
  {
    this(TYPE_REALRECORD);
  }
  
  public QCallRecord(int paramInt)
  {
    this.type = paramInt;
    if (paramInt == TYPE_REALRECORD) {
      createMessageUniseq();
    }
  }
  
  public static String getTableName(String paramString, int paramInt)
  {
    return "qc_" + paramInt + "_" + MsgProxyUtils.a(paramString);
  }
  
  public void createMessageUniseq()
  {
    this.uniseq = ((int)this.time);
    if (this.uniseq == 0L) {
      this.uniseq = ((int)(System.currentTimeMillis() / 1000L));
    }
    this.uniseq = (this.uniseq << 32 | Math.abs(new Random().nextInt()));
  }
  
  public int getDate()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(this.time * 1000L);
    return localCalendar.get(5);
  }
  
  public String getDateString()
  {
    Calendar localCalendar1 = Calendar.getInstance();
    Date localDate = new Date(this.time * 1000L);
    localCalendar1.setTime(localDate);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(System.currentTimeMillis());
    if ((localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) == localCalendar2.get(6))) {
      return "今天";
    }
    if ((localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) + 1 == localCalendar2.get(6))) {
      return "昨天";
    }
    if ((localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) > localCalendar2.get(6) - 7)) {}
    switch (localCalendar1.get(7))
    {
    default: 
      return new SimpleDateFormat("yy-MM-dd").format(localDate);
    case 1: 
      return "星期日";
    case 2: 
      return "星期一";
    case 3: 
      return "星期二";
    case 4: 
      return "星期三";
    case 5: 
      return "星期四";
    case 6: 
      return "星期五";
    }
    return "星期六";
  }
  
  public String getTableName()
  {
    return getTableName(this.friendUin, this.uinType);
  }
  
  public String getTalkTimeMinute()
  {
    int j = 0;
    if (TextUtils.isEmpty(this.talkTime)) {
      return "";
    }
    Object localObject = this.talkTime;
    long l1;
    long l3;
    if (this.uinType == 3000)
    {
      long l2 = Long.parseLong(this.talkTime);
      localObject = "00:00";
      if (l2 > 0L)
      {
        l1 = l2 % 60L;
        l3 = l2 / 60L;
        l2 = l3 / 60L;
        l3 %= 60L;
        if (l2 <= 0L) {
          break label274;
        }
        localObject = String.format(Locale.CHINA, "%02d:%02d:%02d", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l1) });
      }
    }
    int i;
    int k;
    if ((localObject != null) && (!((String)localObject).equals("")) && (((String)localObject).split(":").length >= 2))
    {
      localObject = ((String)localObject).split(":");
      if (localObject.length == 2)
      {
        j = Integer.parseInt(localObject[0]);
        i = Integer.parseInt(localObject[1]);
        k = 0;
      }
    }
    for (;;)
    {
      label189:
      if (k != 0) {}
      for (localObject = "" + k + "小时";; localObject = "")
      {
        if (j != 0) {
          localObject = (String)localObject + j + "分钟";
        }
        for (;;)
        {
          return (String)localObject + i + "秒钟";
          label274:
          localObject = String.format(Locale.CHINA, "%02d:%02d", new Object[] { Long.valueOf(l3), Long.valueOf(l1) });
          break;
          if (localObject.length != 3) {
            break label354;
          }
          k = Integer.parseInt(localObject[0]);
          j = Integer.parseInt(localObject[1]);
          i = Integer.parseInt(localObject[2]);
          break label189;
          return "";
        }
      }
      label354:
      i = 0;
      k = 0;
    }
  }
  
  public String getTime()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(this.time * 1000L);
    DecimalFormat localDecimalFormat = new DecimalFormat("00");
    return localDecimalFormat.format(localCalendar.get(11)) + ":" + localDecimalFormat.format(localCalendar.get(12));
  }
  
  public boolean isMissCall()
  {
    if (this.uinType != 3000) {}
    while ((this.issend != 0) || (this.state != 2)) {
      return false;
    }
    return true;
  }
  
  public boolean isSender()
  {
    return this.issend == 1;
  }
  
  public boolean isVideo()
  {
    return this.isVideo == 1;
  }
  
  public String toString()
  {
    return "QCallRecord [state=" + this.state + ", time=" + this.time + ", talkTime=" + this.talkTime + ", type=" + this.type + ", friendUin=" + this.friendUin + ", troopUin=" + this.troopUin + ", uinType=" + this.uinType + ", uniseq=" + this.uniseq + ", issend=" + this.issend + ", msgData=" + Arrays.toString(this.msgData) + ", senderuin=" + this.senderuin + ", isVideo=" + this.isVideo + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.QCallRecord
 * JD-Core Version:    0.7.0.1
 */