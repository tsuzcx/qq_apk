package cooperation.qzone.remote;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.qphone.base.util.QLog;
import mdb;

public class SendMsg
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new mdb();
  private static final String tag = "SendMsg";
  public IActionListener actionListener;
  public final Bundle extraData = new Bundle();
  int requestId;
  long sendTime = -1L;
  public String serviceCmd;
  long timeout = -1L;
  
  public SendMsg(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public SendMsg(String paramString)
  {
    this.serviceCmd = paramString;
  }
  
  private void readFromParcel(Parcel paramParcel)
  {
    try
    {
      this.requestId = paramParcel.readInt();
      this.serviceCmd = paramParcel.readString();
      this.timeout = paramParcel.readLong();
      this.extraData.clear();
      this.extraData.putAll(paramParcel.readBundle(getClass().getClassLoader()));
      this.actionListener = IActionListener.Stub.asInterface(paramParcel.readStrongBinder());
      return;
    }
    catch (RuntimeException paramParcel)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SendMsg", 2, "readFromParcel RuntimeException", paramParcel);
      }
      throw paramParcel;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public IActionListener getActionListener()
  {
    return this.actionListener;
  }
  
  public Bundle getExtraData()
  {
    return this.extraData;
  }
  
  public int getRequestId()
  {
    return this.requestId;
  }
  
  public long getSendTime()
  {
    return this.sendTime;
  }
  
  public String getServiceCmd()
  {
    return this.serviceCmd;
  }
  
  public long getTimeout()
  {
    return this.timeout;
  }
  
  public byte[] getWupBuffer()
  {
    return this.extraData.getByteArray("wup");
  }
  
  public boolean isNeedCallback()
  {
    return this.extraData.getBoolean("needCallback", true);
  }
  
  public void putWupBuffer(byte[] paramArrayOfByte)
  {
    this.extraData.putByteArray("wup", paramArrayOfByte);
  }
  
  public void setNeedCallback(boolean paramBoolean)
  {
    this.extraData.putBoolean("needCallback", paramBoolean);
  }
  
  public void setRequestId(int paramInt)
  {
    this.requestId = paramInt;
  }
  
  public void setSendTime(long paramLong)
  {
    this.sendTime = paramLong;
  }
  
  public void setTimeout(long paramLong)
  {
    this.timeout = paramLong;
  }
  
  public String toString()
  {
    return "SendMsg appSeq:" + this.requestId + " serviceCmd:" + this.serviceCmd + " timeout:" + this.timeout;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      paramParcel.writeInt(this.requestId);
      paramParcel.writeString(this.serviceCmd);
      paramParcel.writeLong(this.timeout);
      paramParcel.writeBundle(this.extraData);
      paramParcel.writeStrongInterface(this.actionListener);
      return;
    }
    catch (RuntimeException paramParcel)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendMsg", 2, "writeToParcel RuntimeException", paramParcel);
      }
      throw paramParcel;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.remote.SendMsg
 * JD-Core Version:    0.7.0.1
 */