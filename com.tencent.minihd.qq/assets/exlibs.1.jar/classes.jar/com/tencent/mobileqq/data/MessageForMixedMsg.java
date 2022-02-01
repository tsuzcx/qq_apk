package com.tencent.mobileqq.data;

import android.content.Context;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mqp.app.sec.MQPSensitiveMsgUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import localpb.richMsg.MarketFaceMsg.MarketFaceRec;
import localpb.richMsg.MixedMsg.Elem;
import localpb.richMsg.MixedMsg.Msg;
import localpb.richMsg.RichMsg.PicRec;

public class MessageForMixedMsg
  extends ChatMessage
{
  private static final String TAG = "MessageForMixedMsg";
  public Object elemListSyncLock = new Object();
  public List msgElemList;
  
  public static void copyBaseInfoFromMixedToPic(MessageForPic paramMessageForPic, MessageForMixedMsg paramMessageForMixedMsg)
  {
    paramMessageForPic.senderuin = paramMessageForMixedMsg.senderuin;
    paramMessageForPic.selfuin = paramMessageForMixedMsg.selfuin;
    paramMessageForPic.frienduin = paramMessageForMixedMsg.frienduin;
    paramMessageForPic.time = paramMessageForMixedMsg.time;
    paramMessageForPic.issend = paramMessageForMixedMsg.issend;
    paramMessageForPic.istroop = paramMessageForMixedMsg.istroop;
    paramMessageForPic.shmsgseq = paramMessageForMixedMsg.shmsgseq;
    paramMessageForPic.msgtype = -2000;
    paramMessageForPic.uniseq = paramMessageForMixedMsg.uniseq;
    paramMessageForPic.msgseq = paramMessageForMixedMsg.msgseq;
  }
  
  public static CharSequence getTextFromMixedMsg(ChatMessage arg0)
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder("");
    int j;
    Object localObject5;
    if ((??? instanceof MessageForMixedMsg))
    {
      ??? = (MessageForMixedMsg)???;
      synchronized (((MessageForMixedMsg)???).elemListSyncLock)
      {
        j = ((MessageForMixedMsg)???).msgElemList.size();
        if (i < j)
        {
          ??? = (MessageRecord)((MessageForMixedMsg)???).msgElemList.get(i);
          if ((??? instanceof MessageForText))
          {
            localObject5 = (MessageForText)???;
            if (((MessageForText)localObject5).sb != null) {}
            for (??? = ((MessageForText)localObject5).sb.toString();; ??? = ???.msg)
            {
              localStringBuilder.append(???);
              break;
            }
          }
          if (!(??? instanceof MessageForPic)) {
            break label373;
          }
          localStringBuilder.append(BaseApplicationImpl.getContext().getString(2131365739));
        }
      }
    }
    label150:
    while (!(??? instanceof MessageForLongMsg)) {
      return localStringBuilder.toString();
    }
    ??? = (MessageForLongMsg)???;
    for (;;)
    {
      synchronized (((MessageForLongMsg)???).fragmentListSyncLock)
      {
        int k = ((MessageForLongMsg)???).longMsgFragmentList.size();
        i = 0;
        if (i >= k) {
          break label368;
        }
        ??? = (MessageRecord)((MessageForLongMsg)???).longMsgFragmentList.get(i);
        if ((??? instanceof MessageForText))
        {
          localStringBuilder.append(((MessageForText)???).msg);
          break label380;
        }
        if (!(??? instanceof MessageForMixedMsg)) {
          break label380;
        }
        localObject5 = (MessageForMixedMsg)???;
        synchronized (((MessageForMixedMsg)localObject5).elemListSyncLock)
        {
          int m = ((MessageForMixedMsg)localObject5).msgElemList.size();
          j = 0;
          if (j < m)
          {
            MessageRecord localMessageRecord = (MessageRecord)((MessageForMixedMsg)localObject5).msgElemList.get(j);
            if ((localMessageRecord instanceof MessageForText)) {
              localStringBuilder.append(((MessageForText)localMessageRecord).msg);
            } else if ((localMessageRecord instanceof MessageForPic)) {
              localStringBuilder.append(BaseApplicationImpl.getContext().getString(2131365739));
            }
          }
        }
      }
      break label380;
      label368:
      break label150;
      label373:
      i += 1;
      break;
      label380:
      i += 1;
      continue;
      j += 1;
    }
  }
  
  public void doParse()
  {
    boolean bool2 = true;
    MixedMsg.Msg localMsg = new MixedMsg.Msg();
    Object localObject2 = new StringBuilder();
    int j;
    Object localObject3;
    int i;
    try
    {
      localMsg.mergeFrom(this.msgData);
      if (QLog.isColorLevel()) {
        QLog.i("MessageForMixedMsg", 2, "MessageForMixedMsg.doParse");
      }
      this.msgElemList = new CopyOnWriteArrayList();
      if (QLog.isColorLevel()) {
        QLog.i("MessageForMixedMsg", 2, "MessageForMixedMsg.doParse list created");
      }
      if (localMsg.elems.get().size() <= 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MessageForMixedMsg", 2, "MessageForMixedMsg.doParse no element");
        }
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
      j = localMsg.elems.get().size();
      localObject3 = this.elemListSyncLock;
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        MixedMsg.Elem localElem;
        try
        {
          localElem = (MixedMsg.Elem)localMsg.elems.get().get(i);
          Object localObject4;
          if (localElem.textMsg.has())
          {
            localObject4 = new MessageForText();
            ((MessageForText)localObject4).msg = localElem.textMsg.get();
            ((MessageForText)localObject4).msgData = ((MessageForText)localObject4).msg.getBytes();
            ((MessageForText)localObject4).doParse(true);
            this.msgElemList.add(localObject4);
            ((StringBuilder)localObject2).append(((MessageForText)localObject4).msg);
          }
          else if (localElem.picMsg.has())
          {
            localObject4 = new MessageForPic();
            ((MessageForPic)localObject4).msgData = ((RichMsg.PicRec)localElem.picMsg.get()).toByteArray();
            ((MessageForPic)localObject4).doParse();
            ((MessageForPic)localObject4).subMsgId = i;
            copyBaseInfoFromMixedToPic((MessageForPic)localObject4, this);
            this.msgElemList.add(localObject4);
            ((StringBuilder)localObject2).append(BaseApplicationImpl.getContext().getString(2131365739));
          }
        }
        finally {}
        if (!localElem.markfaceMsg.has()) {}
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("MessageForMixedMsg", 2, "MessageForMixedMsg.doParse list size is " + this.msgElemList.size());
        }
        this.msg = ((StringBuilder)localObject2).toString();
        String str = getExtInfoFromExtStr("sens_msg_need_parse");
        if (!TextUtils.isEmpty(str)) {}
        for (;;)
        {
          try
          {
            bool1 = Boolean.parseBoolean(str);
            if (!bool1) {
              break;
            }
            str = getExtInfoFromExtStr("sens_msg_ctrl_info");
            if (TextUtils.isEmpty(str)) {
              break;
            }
            localObject2 = getExtInfoFromExtStr("sens_msg_confirmed");
            if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).equalsIgnoreCase("1"))) {
              break label558;
            }
            bool1 = bool2;
            if (bool1) {
              break label543;
            }
            localObject2 = this.msgElemList.iterator();
            if (!((Iterator)localObject2).hasNext()) {
              break label543;
            }
            localObject3 = (MessageRecord)((Iterator)localObject2).next();
            if (!(localObject3 instanceof MessageForText)) {
              continue;
            }
            ((MessageRecord)localObject3).saveExtInfoToExtStr("sens_msg_original_text", ((MessageRecord)localObject3).msg);
            continue;
            bool1 = true;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
          continue;
          label543:
          MQPSensitiveMsgUtil.a(this, this.msgElemList, bool1, HexUtil.hexStr2Bytes(localException));
          return;
          label558:
          boolean bool1 = false;
        }
      }
      i += 1;
    }
  }
  
  public MessageRecord getSubMessage(long paramLong)
  {
    if ((this.msgElemList == null) || (paramLong < 0L) || (paramLong >= this.msgElemList.size())) {
      return null;
    }
    return (MessageRecord)this.msgElemList.get((int)paramLong);
  }
  
  public void parse()
  {
    super.parse();
    synchronized (this.elemListSyncLock)
    {
      Iterator localIterator = this.msgElemList.iterator();
      while (localIterator.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
        if (((localMessageRecord instanceof MessageForPic)) && (localMessageRecord.uniseq != this.uniseq))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MessageForMixedMsg", 2, " Error : Info not Equals : child : " + localMessageRecord.uniseq + " parent:" + this.uniseq);
          }
          copyBaseInfoFromMixedToPic((MessageForPic)localMessageRecord, this);
        }
      }
    }
  }
  
  protected void postRead()
  {
    this.msgId = getLogicMsgID(getId(), this.versionCode);
    parse();
  }
  
  protected void prewrite()
  {
    if (this.msgElemList == null) {
      return;
    }
    MixedMsg.Msg localMsg = new MixedMsg.Msg();
    label164:
    label175:
    for (;;)
    {
      Object localObject3;
      MixedMsg.Elem localElem;
      synchronized (this.elemListSyncLock)
      {
        Iterator localIterator = this.msgElemList.iterator();
        if (!localIterator.hasNext()) {
          break label164;
        }
        localObject3 = localIterator.next();
        localElem = new MixedMsg.Elem();
        if ((localObject3 instanceof MessageForText))
        {
          String str = getExtInfoFromExtStr("sens_msg_original_text");
          if (!TextUtils.isEmpty(str)) {
            break label175;
          }
          str = ((MessageForText)localObject3).msg;
          localElem.textMsg.set(str);
          localMsg.elems.get().add(localElem);
        }
      }
      if ((localObject3 instanceof MessageForPic))
      {
        localElem.picMsg.set(((MessageForPic)localObject3).getSerialPB());
      }
      else if ((localObject3 instanceof MessageForMarketFace))
      {
        continue;
        this.msgData = localMsg.toByteArray();
        return;
      }
    }
  }
  
  public byte[] upateMessageForPic(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic == null) {
      return this.msgData;
    }
    if (this.msgElemList == null) {
      return this.msgData;
    }
    MixedMsg.Msg localMsg = new MixedMsg.Msg();
    label219:
    label235:
    for (;;)
    {
      Object localObject3;
      MixedMsg.Elem localElem;
      Object localObject1;
      synchronized (this.elemListSyncLock)
      {
        Iterator localIterator = this.msgElemList.iterator();
        if (!localIterator.hasNext()) {
          break label219;
        }
        localObject3 = localIterator.next();
        localElem = new MixedMsg.Elem();
        if ((localObject3 instanceof MessageForText))
        {
          localObject1 = getExtInfoFromExtStr("sens_msg_original_text");
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break label235;
          }
          localObject1 = ((MessageForText)localObject3).msg;
          localElem.textMsg.set((String)localObject1);
          localMsg.elems.get().add(localElem);
        }
      }
      if ((localObject3 instanceof MessageForPic))
      {
        localObject1 = (MessageForPic)localObject3;
        if ((((MessageForPic)localObject1).uniseq == paramMessageForPic.uniseq) && (((MessageForPic)localObject1).subMsgId == paramMessageForPic.subMsgId)) {
          localElem.picMsg.set(paramMessageForPic.getSerialPB());
        } else {
          localElem.picMsg.set(((MessageForPic)localObject1).getSerialPB());
        }
      }
      else if ((localObject3 instanceof MessageForMarketFace))
      {
        continue;
        this.msgData = localMsg.toByteArray();
        return this.msgData;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForMixedMsg
 * JD-Core Version:    0.7.0.1
 */