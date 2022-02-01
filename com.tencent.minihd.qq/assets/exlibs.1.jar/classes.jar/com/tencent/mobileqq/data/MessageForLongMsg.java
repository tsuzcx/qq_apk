package com.tencent.mobileqq.data;

import android.content.Context;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ims.bankcode_info.BankcodeCtrlInfo;
import com.tencent.ims.bankcode_info.BankcodeElem;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mqp.app.sec.MQPSensitiveMsgUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MessageForLongMsg
  extends ChatMessage
{
  public Object fragmentListSyncLock = new Object();
  public List longMsgFragmentList;
  public CharSequence sb;
  
  public MessageForLongMsg()
  {
    this.longMsgFragmentList = new ArrayList();
  }
  
  public MessageForLongMsg(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      this.longMsgFragmentList = new ArrayList();
      this.longMsgFragmentList.addAll(paramArrayList);
      MessageRecord.copyMessageRecordBaseField(this, (MessageRecord)this.longMsgFragmentList.get(0));
      this.msgtype = -1037;
      paramArrayList = this.longMsgFragmentList.iterator();
      while (paramArrayList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramArrayList.next();
        if (!(localMessageRecord instanceof MessageForText)) {
          this.msgtype = -1036;
        }
        if ((localMessageRecord.extraflag == 32768) && (localMessageRecord.isSendFromLocal())) {
          this.extraflag = 32768;
        }
      }
    }
  }
  
  protected void doParse()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      Object localObject5;
      boolean bool1;
      int k;
      boolean bool2;
      int j;
      synchronized (this.fragmentListSyncLock)
      {
        if ((this.longMsgFragmentList == null) || (this.longMsgFragmentList.isEmpty())) {
          break label619;
        }
        localObject5 = this.longMsgFragmentList.iterator();
        bool1 = false;
        i = 0;
        k = 0;
        if (((Iterator)localObject5).hasNext())
        {
          Object localObject1 = ((MessageRecord)((Iterator)localObject5).next()).getExtInfoFromExtStr("sens_msg_ctrl_info");
          bool2 = TextUtils.isEmpty((CharSequence)localObject1);
          if (bool2) {
            break label692;
          }
          int m = k;
          try
          {
            localObject6 = new bankcode_info.BankcodeCtrlInfo();
            m = k;
            ((bankcode_info.BankcodeCtrlInfo)localObject6).mergeFrom(HexUtil.hexStr2Bytes((String)localObject1));
            j = k;
            m = k;
            if (((bankcode_info.BankcodeCtrlInfo)localObject6).msgtail_id.has())
            {
              m = k;
              j = ((bankcode_info.BankcodeCtrlInfo)localObject6).msgtail_id.get();
            }
            k = j;
            if (j != 1) {
              continue;
            }
            m = j;
            if (((bankcode_info.BankcodeCtrlInfo)localObject6).bankcode_elems.has())
            {
              m = j;
              localObject1 = ((bankcode_info.BankcodeCtrlInfo)localObject6).bankcode_elems.get();
              if (localObject1 != null)
              {
                m = j;
                localObject6 = ((List)localObject1).iterator();
                bool2 = bool1;
              }
            }
          }
          catch (Exception localException1)
          {
            Object localObject6;
            boolean bool3;
            k = m;
            j = i;
          }
        }
        try
        {
          if (((Iterator)localObject6).hasNext())
          {
            bool2 = bool1;
            bankcode_info.BankcodeElem localBankcodeElem = (bankcode_info.BankcodeElem)((Iterator)localObject6).next();
            bool2 = bool1;
            if (!localBankcodeElem.bankcode_attr.has()) {
              break label687;
            }
            bool2 = bool1;
            k = localBankcodeElem.bankcode_attr.get();
            break label699;
          }
          k = i;
          bool3 = bool1;
          if (i != 20) {
            continue;
          }
          bool2 = bool1;
          localObject6 = ((List)localObject1).iterator();
          k = i;
          bool3 = bool1;
          bool2 = bool1;
          if (!((Iterator)localObject6).hasNext()) {
            continue;
          }
          bool2 = bool1;
          localObject1 = (bankcode_info.BankcodeElem)((Iterator)localObject6).next();
          bool2 = bool1;
          if (!((bankcode_info.BankcodeElem)localObject1).bankcode_attr.has()) {
            break label677;
          }
          bool2 = bool1;
          k = ((bankcode_info.BankcodeElem)localObject1).bankcode_attr.get();
        }
        catch (Exception localException2)
        {
          Iterator localIterator;
          k = j;
          j = i;
          bool1 = bool2;
          continue;
          continue;
          localObject3 = null;
          continue;
          k = 0;
          continue;
        }
        if (k != 20) {
          continue;
        }
        bool2 = bool1;
        if (!((bankcode_info.BankcodeElem)localObject1).clean_bankcode.has()) {
          break label671;
        }
        bool2 = bool1;
        localObject1 = ((bankcode_info.BankcodeElem)localObject1).clean_bankcode.get();
        bool2 = bool1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label668;
        }
        bool2 = bool1;
        bool3 = MQPSensitiveMsgUtil.a().a((String)localObject1);
        if (bool3) {
          break label668;
        }
        bool1 = true;
        continue;
        bool3 = bool1;
        k = i;
        i = j;
        bool1 = bool3;
        j = k;
        k = i;
        i = j;
        continue;
        localException1.printStackTrace();
        i = k;
      }
      localIterator = this.longMsgFragmentList.iterator();
      while (localIterator.hasNext())
      {
        localObject5 = (MessageRecord)localIterator.next();
        if ((localObject5 instanceof ChatMessage))
        {
          if (k == 1)
          {
            ((MessageRecord)localObject5).saveExtInfoToExtStr("sens_msg_attr", Integer.toString(i));
            ((MessageRecord)localObject5).saveExtInfoToExtStr("sens_msg_has_not_confirmed_msg", Boolean.toString(bool1));
          }
          ((ChatMessage)localObject5).doParse();
          if ((localObject5 instanceof MessageForText)) {
            localStringBuilder.append(((MessageForText)localObject5).msg);
          } else if ((localObject5 instanceof MessageForMixedMsg)) {
            localStringBuilder.append(((MessageForMixedMsg)localObject5).msg);
          } else if ((localObject5 instanceof MessageForPic)) {
            localStringBuilder.append(BaseApplicationImpl.getContext().getString(2131365739));
          }
        }
      }
      label619:
      this.msg = localStringBuilder.toString();
      this.sb = new QQText(this.msg, 13, 32, this.istroop);
      return;
      label668:
      label671:
      label677:
      label687:
      label692:
      label699:
      do
      {
        Object localObject3;
        k = i;
        break label704;
        k = 0;
        continue;
        j = i;
        i = k;
        break;
      } while (k <= i);
      label704:
      int i = k;
    }
  }
  
  public MessageRecord rebuildLongMsg()
  {
    Object localObject3;
    if (this.msgtype == -1037)
    {
      StringBuilder localStringBuilder = new StringBuilder("");
      synchronized (this.fragmentListSyncLock)
      {
        localObject3 = this.longMsgFragmentList.iterator();
        if (((Iterator)localObject3).hasNext()) {
          localStringBuilder.append(((MessageForText)((Iterator)localObject3).next()).msg);
        }
      }
      ??? = (MessageForText)MessageRecordFactory.a(-1000);
      copyMessageRecordBaseField((MessageRecord)???, this);
      ((MessageForText)???).msgtype = -1000;
      ((MessageForText)???).msg = localObject1.toString();
      return ???;
    }
    if (this.msgtype == -1036)
    {
      ??? = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      localObject3 = new StringBuffer();
      for (;;)
      {
        Object localObject5;
        synchronized (this.fragmentListSyncLock)
        {
          Iterator localIterator = this.longMsgFragmentList.iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          localObject5 = (MessageRecord)localIterator.next();
          if ((localObject5 instanceof MessageForText)) {
            ((List)???).add(localObject5);
          }
        }
        if ((localObject5 instanceof MessageForMixedMsg))
        {
          localObject5 = ((MessageForMixedMsg)localObject5).msgElemList.iterator();
          while (((Iterator)localObject5).hasNext())
          {
            MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject5).next();
            if ((localMessageRecord instanceof MessageForText))
            {
              ((List)???).add(localMessageRecord);
            }
            else if ((localMessageRecord instanceof MessageForPic))
            {
              if (!((List)???).isEmpty())
              {
                Object localObject6 = ((List)???).iterator();
                while (((Iterator)localObject6).hasNext()) {
                  ((StringBuffer)localObject3).append(((MessageRecord)((Iterator)localObject6).next()).msg);
                }
                localObject6 = (MessageForText)MessageRecordFactory.a(-1000);
                ((MessageForText)localObject6).msgtype = -1000;
                ((MessageForText)localObject6).msg = ((StringBuffer)localObject3).toString();
                ((StringBuffer)localObject3).delete(0, ((StringBuffer)localObject3).length());
                localCollection.add(localObject6);
                ((List)???).clear();
              }
              localCollection.add((MessageForPic)localMessageRecord.deepCopyByReflect());
            }
          }
        }
      }
      if (!((List)???).isEmpty())
      {
        ??? = ((List)???).iterator();
        while (((Iterator)???).hasNext()) {
          ((StringBuffer)localObject3).append(((MessageRecord)((Iterator)???).next()).msg);
        }
        ??? = (MessageForText)MessageRecordFactory.a(-1000);
        ((MessageForText)???).msgtype = -1000;
        ((MessageForText)???).msg = ((StringBuffer)localObject3).toString();
        ((StringBuffer)localObject3).delete(0, ((StringBuffer)localObject3).length());
        localCollection.add(???);
        ((List)???).clear();
      }
      ??? = (MessageForMixedMsg)MessageRecordFactory.a(-1035);
      copyMessageRecordBaseField((MessageRecord)???, this);
      ((MessageForMixedMsg)???).msgtype = -1035;
      ((MessageForMixedMsg)???).msgElemList = new CopyOnWriteArrayList();
      ((MessageForMixedMsg)???).msgElemList.addAll(localCollection);
      ((MessageForMixedMsg)???).prewrite();
      return ???;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForLongMsg
 * JD-Core Version:    0.7.0.1
 */