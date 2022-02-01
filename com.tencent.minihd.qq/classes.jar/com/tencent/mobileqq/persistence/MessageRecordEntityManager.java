package com.tencent.mobileqq.persistence;

import android.database.Cursor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

public class MessageRecordEntityManager
  extends EntityManager
{
  public MessageRecordEntityManager(SQLiteOpenHelper paramSQLiteOpenHelper)
  {
    super(paramSQLiteOpenHelper);
  }
  
  public Entity a(Class paramClass, String paramString, Cursor paramCursor)
  {
    boolean bool2 = true;
    if (paramCursor.isBeforeFirst()) {
      paramCursor.moveToFirst();
    }
    label1102:
    for (;;)
    {
      try
      {
        if (paramCursor.getColumnIndex("_id") >= 0) {
          l = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
        }
      }
      catch (Exception localException)
      {
        try
        {
          long l;
          int i;
          Object localObject;
          if (paramClass.getName().equals(MessageRecord.class.getName()))
          {
            i = paramCursor.getInt(paramCursor.getColumnIndex("msgtype"));
            paramClass = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
            localObject = MessageRecordFactory.a(i, paramClass);
            ((MessageRecord)localObject).msgData = paramClass;
            ((Entity)localObject)._id = l;
            ((MessageRecord)localObject).selfuin = paramCursor.getString(paramCursor.getColumnIndex("selfuin"));
            ((MessageRecord)localObject).frienduin = paramCursor.getString(paramCursor.getColumnIndex("frienduin"));
            ((MessageRecord)localObject).senderuin = paramCursor.getString(paramCursor.getColumnIndex("senderuin"));
            ((MessageRecord)localObject).time = paramCursor.getLong(paramCursor.getColumnIndex("time"));
            ((MessageRecord)localObject).msgtype = paramCursor.getInt(paramCursor.getColumnIndex("msgtype"));
            if (paramCursor.getInt(paramCursor.getColumnIndex("isread")) != 0)
            {
              bool1 = true;
              ((MessageRecord)localObject).isread = bool1;
              ((MessageRecord)localObject).issend = paramCursor.getInt(paramCursor.getColumnIndex("issend"));
              ((MessageRecord)localObject).msgseq = paramCursor.getLong(paramCursor.getColumnIndex("msgseq"));
              ((MessageRecord)localObject).shmsgseq = paramCursor.getLong(paramCursor.getColumnIndex("shmsgseq"));
              ((MessageRecord)localObject).istroop = paramCursor.getInt(paramCursor.getColumnIndex("istroop"));
              ((MessageRecord)localObject).extraflag = paramCursor.getInt(paramCursor.getColumnIndex("extraflag"));
              ((MessageRecord)localObject).sendFailCode = paramCursor.getInt(paramCursor.getColumnIndex("sendFailCode"));
              ((MessageRecord)localObject).msgId = paramCursor.getLong(paramCursor.getColumnIndex("msgId"));
              ((MessageRecord)localObject).longMsgIndex = paramCursor.getInt(paramCursor.getColumnIndex("longMsgIndex"));
              ((MessageRecord)localObject).longMsgId = paramCursor.getInt(paramCursor.getColumnIndex("longMsgId"));
              ((MessageRecord)localObject).longMsgCount = paramCursor.getInt(paramCursor.getColumnIndex("longMsgCount"));
              ((MessageRecord)localObject).msgUid = paramCursor.getLong(paramCursor.getColumnIndex("msgUid"));
              ((MessageRecord)localObject).uniseq = paramCursor.getLong(paramCursor.getColumnIndex("uniseq"));
              ((MessageRecord)localObject).extStr = paramCursor.getString(paramCursor.getColumnIndex("extStr"));
              ((MessageRecord)localObject).extInt = paramCursor.getInt(paramCursor.getColumnIndex("extInt"));
              ((MessageRecord)localObject).extLong = paramCursor.getInt(paramCursor.getColumnIndex("extLong"));
              if (paramCursor.getInt(paramCursor.getColumnIndex("isValid")) == 0) {
                continue;
              }
              bool1 = bool2;
              ((MessageRecord)localObject).isValid = bool1;
              ((MessageRecord)localObject).versionCode = paramCursor.getInt(paramCursor.getColumnIndex("versionCode"));
              ((MessageRecord)localObject).vipBubbleID = paramCursor.getLong(paramCursor.getColumnIndex("vipBubbleID"));
              if (((MessageRecord)localObject).versionCode <= 0) {
                ((MessageRecord)localObject).msg = paramCursor.getString(paramCursor.getColumnIndex("msg"));
              }
              if ((l != -1L) && (paramString != null))
              {
                ((Entity)localObject)._status = 1001;
                ((Entity)localObject).postRead();
                return localObject;
              }
              ((Entity)localObject)._status = 1002;
              continue;
            }
          }
          else
          {
            paramClass = (Entity)paramClass.newInstance();
            if (paramClass != null)
            {
              paramClass._id = l;
              localObject = TableBuilder.b(paramClass).iterator();
              if (((Iterator)localObject).hasNext())
              {
                Field localField = (Field)((Iterator)localObject).next();
                Class localClass = localField.getType();
                if (Entity.class.isAssignableFrom(localClass))
                {
                  Entity localEntity = a(localClass, paramCursor);
                  localEntity._status = 1002;
                  localField.set(paramClass, localEntity);
                }
                i = paramCursor.getColumnIndex(localField.getName());
                if (i == -1) {
                  continue;
                }
                if (!localField.isAccessible()) {
                  localField.setAccessible(true);
                }
                if (localClass == Long.TYPE)
                {
                  localField.set(paramClass, Long.valueOf(paramCursor.getLong(i)));
                  continue;
                }
                if (localClass == Integer.TYPE)
                {
                  localField.set(paramClass, Integer.valueOf(paramCursor.getInt(i)));
                  continue;
                }
                if (localClass == String.class)
                {
                  localField.set(paramClass, paramCursor.getString(i));
                  continue;
                }
                if (localClass == Byte.TYPE)
                {
                  localField.set(paramClass, Byte.valueOf((byte)paramCursor.getShort(i)));
                  continue;
                }
                if (localClass == [B.class)
                {
                  localField.set(paramClass, paramCursor.getBlob(i));
                  continue;
                }
                if (localClass == Short.TYPE)
                {
                  localField.set(paramClass, Short.valueOf(paramCursor.getShort(i)));
                  continue;
                }
                if (localClass == Boolean.TYPE)
                {
                  if (paramCursor.getInt(i) == 0) {
                    break label1102;
                  }
                  bool1 = true;
                  localField.set(paramClass, Boolean.valueOf(bool1));
                  continue;
                }
                if (localClass == Float.TYPE)
                {
                  localField.set(paramClass, Float.valueOf(paramCursor.getFloat(i)));
                  continue;
                }
                if (localClass != Double.TYPE) {
                  continue;
                }
                localField.set(paramClass, Double.valueOf(paramCursor.getDouble(i)));
                continue;
              }
            }
            if ((l != -1L) && (paramString != null))
            {
              paramClass._status = 1001;
              paramClass.postRead();
              return paramClass;
            }
            paramClass._status = 1002;
            continue;
            l = -1L;
            continue;
            localException = localException;
            l = -1L;
            continue;
          }
          boolean bool1 = false;
          continue;
          bool1 = false;
          continue;
          bool1 = false;
        }
        catch (Exception paramClass)
        {
          return null;
        }
      }
    }
  }
  
  public List a(String paramString, String[] paramArrayOfString, QQAppInterface paramQQAppInterface)
  {
    paramString = a(MessageRecord.class, paramString, paramArrayOfString);
    if ((paramString != null) && (paramString.size() > 0))
    {
      paramArrayOfString = paramString.iterator();
      while (paramArrayOfString.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramArrayOfString.next();
        paramQQAppInterface.a().a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord);
      }
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.MessageRecordEntityManager
 * JD-Core Version:    0.7.0.1
 */