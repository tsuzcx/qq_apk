package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.pb.secmsg.SecMsgComu.SecMsg_IDMap;
import hzg;
import java.util.Iterator;
import java.util.List;

public class SecMsgSession
  extends Entity
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new hzg();
  public long activeTime;
  public boolean complete;
  public long createTime;
  public long creatorSuid;
  @unique
  public String id;
  public boolean isOpen;
  @notColumn
  public boolean isShield;
  public boolean localDeleted;
  @notColumn
  public long localSeq;
  @notColumn
  public int msgCount;
  public long mySuid;
  public long paperId;
  @notColumn
  public String receiverName;
  public String receiverUin;
  public String subject;
  public int unreadCount;
  
  public SecMsgSession() {}
  
  private SecMsgSession(Parcel paramParcel)
  {
    this.id = paramParcel.readString();
    this.creatorSuid = paramParcel.readLong();
    this.mySuid = paramParcel.readLong();
    this.subject = paramParcel.readString();
    this.paperId = paramParcel.readLong();
    this.createTime = paramParcel.readLong();
    this.activeTime = paramParcel.readLong();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = (SecMsgSession)paramObject;
    return this.id.equals(paramObject.id);
  }
  
  public String getReceiverName(QQAppInterface paramQQAppInterface)
  {
    if ((!isCreator()) || (paramQQAppInterface == null)) {
      return null;
    }
    if (this.receiverName == null)
    {
      paramQQAppInterface = (FriendManager)paramQQAppInterface.getManager(8);
      if (paramQQAppInterface != null) {
        this.receiverName = paramQQAppInterface.b(this.receiverUin);
      }
    }
    return this.receiverName;
  }
  
  public boolean isCreator()
  {
    return this.creatorSuid == this.mySuid;
  }
  
  public void resolveReceiverUin(List paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        SecMsgComu.SecMsg_IDMap localSecMsg_IDMap = (SecMsgComu.SecMsg_IDMap)paramList.next();
        if ((localSecMsg_IDMap != null) && (localSecMsg_IDMap.suid.get() != this.mySuid)) {
          this.receiverUin = String.valueOf(localSecMsg_IDMap.uin.get());
        }
      }
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.id);
    paramParcel.writeLong(this.creatorSuid);
    paramParcel.writeLong(this.mySuid);
    paramParcel.writeString(this.subject);
    paramParcel.writeLong(this.paperId);
    paramParcel.writeLong(this.createTime);
    paramParcel.writeLong(this.activeTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.SecMsgSession
 * JD-Core Version:    0.7.0.1
 */