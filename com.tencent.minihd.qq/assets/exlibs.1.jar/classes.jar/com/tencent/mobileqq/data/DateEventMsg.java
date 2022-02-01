package com.tencent.mobileqq.data;

import android.content.Context;
import android.text.TextUtils;
import appoint.define.appoint_define.AddressInfo;
import appoint.define.appoint_define.AppointContent;
import appoint.define.appoint_define.AppointID;
import appoint.define.appoint_define.AppointInfo;
import appoint.define.appoint_define.DateComment;
import appoint.define.appoint_define.DateEvent;
import appoint.define.appoint_define.StrangerInfo;
import appoint.define.appoint_define.TravelInfo;
import com.tencent.mobileqq.dating.DatingComment;
import com.tencent.mobileqq.dating.DatingStranger;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class DateEventMsg
  extends Entity
  implements Comparable
{
  public int attendIdx;
  public byte bDeleted;
  public byte bReaded;
  @notColumn
  public DatingComment date_comment;
  @notColumn
  public appoint_define.AppointInfo date_info;
  @unique
  public long event_id;
  @notColumn
  boolean isInited = false;
  public String msg_content;
  public byte[] msg_date_info;
  public String msg_user_info;
  @notColumn
  public String strReadableTime;
  @notColumn
  public String strTime;
  @notColumn
  public String str_event_tips;
  public long time;
  public int type;
  @notColumn
  public DatingStranger user_info;
  
  public static DateEventMsg convertFrom(appoint_define.DateEvent paramDateEvent)
  {
    if (paramDateEvent == null) {
      return null;
    }
    DateEventMsg localDateEventMsg = new DateEventMsg();
    localDateEventMsg.event_id = paramDateEvent.uint64_event_id.get();
    localDateEventMsg.time = paramDateEvent.uint32_time.get();
    localDateEventMsg.type = paramDateEvent.uint32_type.get();
    localDateEventMsg.attendIdx = paramDateEvent.uint32_attend_idx.get();
    localDateEventMsg.bDeleted = 0;
    localDateEventMsg.bReaded = 0;
    if (paramDateEvent.msg_user_info.has())
    {
      localDateEventMsg.user_info = DatingStranger.a((appoint_define.StrangerInfo)paramDateEvent.msg_user_info.get());
      label96:
      if (!paramDateEvent.msg_date_info.has()) {
        break label175;
      }
    }
    label175:
    for (localDateEventMsg.date_info = ((appoint_define.AppointInfo)paramDateEvent.msg_date_info.get());; localDateEventMsg.date_info = null) {
      switch (localDateEventMsg.type)
      {
      default: 
        localDateEventMsg.isInited = true;
        return localDateEventMsg;
        localDateEventMsg.msg_user_info = null;
        break label96;
      }
    }
    if (paramDateEvent.msg_comment.has()) {
      localDateEventMsg.date_comment = DatingComment.a((appoint_define.DateComment)paramDateEvent.msg_comment.get());
    }
    for (;;)
    {
      DatingUtil.a("DateEventMsg.convertFrom", new Object[] { localDateEventMsg.date_comment });
      break;
      DatingUtil.b("DateEventMsg.convertFrom", new Object[] { "msg_comment no value" });
    }
    localDateEventMsg.str_event_tips = paramDateEvent.str_event_tips.get();
    if (TextUtils.isEmpty(localDateEventMsg.str_event_tips)) {
      switch (localDateEventMsg.type)
      {
      }
    }
    for (;;)
    {
      DatingUtil.a("DateEventMsg.convertFrom", new Object[] { paramDateEvent.str_event_tips.get(), localDateEventMsg.str_event_tips });
      break;
      localDateEventMsg.str_event_tips = "报名了你的约会";
      continue;
      localDateEventMsg.str_event_tips = "选择你为约会对象";
      continue;
      localDateEventMsg.str_event_tips = "该约会已经结束";
    }
  }
  
  public static List convertFromList(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DateEventMsg localDateEventMsg = convertFrom((appoint_define.DateEvent)paramList.next());
      if (localDateEventMsg != null) {
        localArrayList.add(localDateEventMsg);
      }
    }
    return localArrayList;
  }
  
  public int compareTo(DateEventMsg paramDateEventMsg)
  {
    if ((paramDateEventMsg == null) || (this.event_id > paramDateEventMsg.event_id)) {
      return 1;
    }
    if (this.event_id == paramDateEventMsg.event_id) {
      return 0;
    }
    return -1;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == null) {}
    do
    {
      return false;
      if (paramObject == this) {
        return true;
      }
    } while (paramObject.getClass() != getClass());
    if (this.event_id == ((DateEventMsg)paramObject).event_id) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public String getBusiImgUrl()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.date_info != null)
    {
      localObject1 = localObject2;
      if (this.date_info.msg_appointment.has())
      {
        appoint_define.AppointContent localAppointContent = (appoint_define.AppointContent)this.date_info.msg_appointment.get();
        localObject1 = localObject2;
        if (localAppointContent != null)
        {
          localObject1 = localObject2;
          if (localAppointContent.msg_appoint_address.has())
          {
            localObject1 = (appoint_define.AddressInfo)localAppointContent.msg_appoint_address.get();
            if (localObject1 != null) {
              break label77;
            }
          }
        }
      }
    }
    label77:
    for (localObject1 = null;; localObject1 = ((appoint_define.AddressInfo)localObject1).str_company_pic_url.get()) {
      return localObject1;
    }
  }
  
  public String getBusiUrl()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.date_info != null)
    {
      localObject1 = localObject2;
      if (this.date_info.msg_appointment.has())
      {
        appoint_define.AppointContent localAppointContent = (appoint_define.AppointContent)this.date_info.msg_appointment.get();
        localObject1 = localObject2;
        if (localAppointContent != null)
        {
          localObject1 = localObject2;
          if (localAppointContent.msg_appoint_address.has())
          {
            localObject1 = (appoint_define.AddressInfo)localAppointContent.msg_appoint_address.get();
            if (localObject1 != null) {
              break label77;
            }
          }
        }
      }
    }
    label77:
    for (localObject1 = null;; localObject1 = ((appoint_define.AddressInfo)localObject1).str_company_url.get()) {
      return localObject1;
    }
  }
  
  public String getCommentId()
  {
    String str = null;
    if (this.date_comment != null) {
      str = this.date_comment.a;
    }
    return str;
  }
  
  public String getDatingId()
  {
    String str = null;
    if (this.date_info != null) {
      str = DatingUtil.a((appoint_define.AppointID)this.date_info.msg_appoint_id.get());
    }
    while (this.date_comment == null) {
      return str;
    }
    return this.date_comment.b;
  }
  
  public int getDatingStrangerIdx()
  {
    int i = 0;
    if (this.user_info != null) {
      i = this.user_info.f;
    }
    return i;
  }
  
  public String getDescStr(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return "";
      int i = 0;
      switch (this.type)
      {
      }
      while (i != 0)
      {
        return paramContext.getString(i);
        if (paramBoolean)
        {
          i = 2131369745;
        }
        else
        {
          i = 2131369740;
          continue;
          if (paramBoolean)
          {
            i = 2131369746;
          }
          else
          {
            i = 2131369741;
            continue;
            if (paramBoolean)
            {
              i = 2131369747;
            }
            else
            {
              i = 2131369742;
              continue;
              if (paramBoolean)
              {
                i = 2131369748;
              }
              else
              {
                i = 2131369743;
                continue;
                if (paramBoolean) {
                  i = 2131369749;
                } else {
                  i = 2131369744;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public String getTravelImgUrl()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.date_info != null)
    {
      localObject1 = localObject2;
      if (this.date_info.msg_appointment.has())
      {
        appoint_define.AppointContent localAppointContent = (appoint_define.AppointContent)this.date_info.msg_appointment.get();
        localObject1 = localObject2;
        if (localAppointContent != null)
        {
          localObject1 = localObject2;
          if (localAppointContent.msg_travel_info.has())
          {
            localObject1 = (appoint_define.TravelInfo)localAppointContent.msg_travel_info.get();
            if (localObject1 != null) {
              break label77;
            }
          }
        }
      }
    }
    label77:
    for (localObject1 = null;; localObject1 = ((appoint_define.TravelInfo)localObject1).str_place_pic_url.get()) {
      return localObject1;
    }
  }
  
  public String getTravelUrl()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.date_info != null)
    {
      localObject1 = localObject2;
      if (this.date_info.msg_appointment.has())
      {
        appoint_define.AppointContent localAppointContent = (appoint_define.AppointContent)this.date_info.msg_appointment.get();
        localObject1 = localObject2;
        if (localAppointContent != null)
        {
          localObject1 = localObject2;
          if (localAppointContent.msg_travel_info.has())
          {
            localObject1 = (appoint_define.TravelInfo)localAppointContent.msg_travel_info.get();
            if (localObject1 != null) {
              break label77;
            }
          }
        }
      }
    }
    label77:
    for (localObject1 = null;; localObject1 = ((appoint_define.TravelInfo)localObject1).str_place_url.get()) {
      return localObject1;
    }
  }
  
  public void init()
  {
    if (this.isInited) {}
    label150:
    label203:
    do
    {
      return;
      this.isInited = true;
      try
      {
        if (TextUtils.isEmpty(this.msg_user_info)) {}
        for (this.user_info = null; (this.msg_date_info == null) || (this.msg_date_info.length == 0); this.user_info = DatingStranger.a(new JSONObject(this.msg_user_info)))
        {
          this.date_info = null;
          if ((this.type != 1) && (this.type != 2)) {
            break label203;
          }
          try
          {
            if (!TextUtils.isEmpty(this.msg_content)) {
              break label150;
            }
            this.str_event_tips = "";
            return;
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
            return;
          }
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
          continue;
          this.date_info = new appoint_define.AppointInfo();
          try
          {
            this.date_info.mergeFrom(this.msg_date_info);
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
          {
            localInvalidProtocolBufferMicroException.printStackTrace();
          }
        }
        this.date_comment = DatingComment.a(new JSONObject(this.msg_content));
        DatingUtil.a("DateEventMsg.init", new Object[] { Integer.valueOf(this.type), this.date_comment, this.msg_content });
        return;
      }
    } while ((this.type != 3) && (this.type != 4) && (this.type != 5));
    this.str_event_tips = this.msg_content;
  }
  
  public void pareseTime()
  {
    this.strReadableTime = DatingUtil.a(this.time, true);
    this.strTime = DatingUtil.a(this.time, false);
  }
  
  protected void prewrite()
  {
    Object localObject = DatingStranger.a(this.user_info);
    if (localObject == null)
    {
      localObject = "";
      this.msg_user_info = ((String)localObject);
      if (this.date_info == null) {
        break label83;
      }
      this.msg_date_info = this.date_info.toByteArray();
      label38:
      if ((this.type != 1) && (this.type != 2)) {
        break label99;
      }
      localObject = DatingComment.a(this.date_comment);
      if (localObject != null) {
        break label91;
      }
      localObject = "";
      this.msg_content = ((String)localObject);
    }
    label83:
    label91:
    label99:
    while ((this.type != 3) && (this.type != 4) && (this.type != 5)) {
      for (;;)
      {
        return;
        localObject = ((JSONObject)localObject).toString();
        break;
        this.msg_date_info = null;
        break label38;
        localObject = ((JSONObject)localObject).toString();
      }
    }
    if (this.str_event_tips == null) {}
    for (localObject = "";; localObject = this.str_event_tips)
    {
      this.msg_content = ((String)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.DateEventMsg
 * JD-Core Version:    0.7.0.1
 */