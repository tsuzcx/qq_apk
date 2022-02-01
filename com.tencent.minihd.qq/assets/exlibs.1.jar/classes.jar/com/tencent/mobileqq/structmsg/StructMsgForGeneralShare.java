package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout3;
import com.tencent.mobileqq.structmsg.view.StructMsgItemProgress;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Iterator;
import java.util.List;
import jwy;
import jxe;
import jxf;
import jxg;
import jxh;
import jxi;

public class StructMsgForGeneralShare
  extends AbsShareMsg
{
  private static View.OnClickListener a = new jxi();
  
  StructMsgForGeneralShare()
  {
    this.mMsgServiceID = 1;
    this.mMsgAction = "web";
  }
  
  StructMsgForGeneralShare(Bundle paramBundle)
  {
    super(paramBundle);
    this.mContentLayout = 2;
    this.mMsgServiceID = paramBundle.getInt("req_type", 1);
    this.mSourceUrl = paramBundle.getString("source_url");
    paramBundle = paramBundle.getString("category");
    AbsStructMsgItem localAbsStructMsgItem1 = StructMsgElementFactory.a(2);
    if (!TextUtils.isEmpty(paramBundle))
    {
      AbsStructMsgItem localAbsStructMsgItem2 = StructMsgElementFactory.a(0);
      localAbsStructMsgItem2.b(paramBundle);
      addItem(localAbsStructMsgItem2);
      localAbsStructMsgItem1.a(this.mContentCover, this.mContentTitle, this.mContentSummary, 1);
    }
    for (;;)
    {
      addItem(localAbsStructMsgItem1);
      if (this.mMsgAction == null) {
        this.mMsgAction = "web";
      }
      return;
      localAbsStructMsgItem1.a(this.mContentCover, this.mContentTitle, this.mContentSummary);
    }
  }
  
  StructMsgForGeneralShare(StructMsgNode paramStructMsgNode)
  {
    super(paramStructMsgNode);
  }
  
  public boolean LayoutEquals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == null);
      bool1 = bool2;
    } while (getClass() != paramObject.getClass());
    paramObject = (StructMsgForGeneralShare)paramObject;
    return getLayoutStr().equals(paramObject.getLayoutStr());
  }
  
  public String getLayoutStr()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (this.mStructMsgItemLists != null)
    {
      Iterator localIterator = this.mStructMsgItemLists.iterator();
      while (localIterator.hasNext()) {
        localStringBuffer.append(((AbsStructMsgElement)localIterator.next()).a());
      }
    }
    return localStringBuffer.toString();
  }
  
  public View.OnClickListener getOnClickListener()
  {
    return a;
  }
  
  public int getProgress()
  {
    AbsStructMsgElement localAbsStructMsgElement = findXmlNode("progress");
    if ((localAbsStructMsgElement != null) && ((localAbsStructMsgElement instanceof StructMsgItemProgress))) {
      return ((StructMsgItemProgress)localAbsStructMsgElement).b();
    }
    return -1;
  }
  
  public View getView(Context paramContext, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    int i = 0;
    if (paramView == null)
    {
      localObject1 = super.getView(paramContext, null, paramOnLongClickAndTouchListener);
      if (localObject1 == null) {
        return null;
      }
      if (!(localObject1 instanceof ViewGroup)) {
        break label580;
      }
    }
    label154:
    label563:
    label580:
    for (Object localObject1 = (ViewGroup)localObject1;; localObject1 = null)
    {
      if (localObject1 == null) {
        return null;
      }
      int j = getItemCount();
      if (j > 0) {
        if (i < j)
        {
          AbsStructMsgElement localAbsStructMsgElement = getItemByIndex(i);
          if ((this.uin != null) && (!this.uin.equalsIgnoreCase(localAbsStructMsgElement.i))) {
            localAbsStructMsgElement.i = this.uin;
          }
          if (localAbsStructMsgElement.a() == 0)
          {
            if (i == 0) {
              localAbsStructMsgElement.b(1);
            }
            if (i == j - 1) {
              localAbsStructMsgElement.b(2);
            }
          }
          if ((localAbsStructMsgElement instanceof StructMsgItemLayout3))
          {
            localObject2 = localAbsStructMsgElement.a(paramContext, null, paramOnLongClickAndTouchListener);
            if (localObject2 == null) {
              break label246;
            }
            if (!TextUtils.isEmpty(localAbsStructMsgElement.c))
            {
              ((View)localObject2).setTag(localAbsStructMsgElement);
              ((View)localObject2).setClickable(true);
              ((View)localObject2).setOnClickListener(localAbsStructMsgElement);
              ((View)localObject2).setOnLongClickListener(new jxe(this, paramOnLongClickAndTouchListener));
              ((View)localObject2).setOnTouchListener(new jxf(this, paramOnLongClickAndTouchListener));
            }
            ((ViewGroup)localObject1).addView((View)localObject2);
          }
          for (;;)
          {
            i += 1;
            break;
            localObject2 = localAbsStructMsgElement.a(paramContext, paramView);
            break label154;
            label246:
            if (QLog.isDevelopLevel()) {
              QLog.e("StructMsg", 4, "Create item view failure by #StructMsgItemViewFactory");
            }
          }
        }
      }
      paramContext = ((ViewGroup)localObject1).getLayoutParams();
      if (paramContext == null)
      {
        paramContext = new LinearLayout.LayoutParams(-2, -2);
        if (hasFlag(4))
        {
          paramContext.width = -1;
          ((ViewGroup)localObject1).setBackgroundResource(2130837636);
        }
        ((ViewGroup)localObject1).setLayoutParams(paramContext);
      }
      do
      {
        do
        {
          ((View)localObject1).setId(2131296309);
          ((View)localObject1).setTag(2131296309, this);
          return localObject1;
          paramContext.width = -2;
          paramContext.height = -2;
          break;
          j = getItemCount();
          localObject1 = paramView;
        } while (j <= 0);
        i = 0;
        localObject1 = paramView;
      } while (i >= j);
      Object localObject2 = getItemByIndex(i);
      if ((this.uin != null) && (!this.uin.equalsIgnoreCase(((AbsStructMsgElement)localObject2).i))) {
        ((AbsStructMsgElement)localObject2).i = this.uin;
      }
      if (((AbsStructMsgElement)localObject2).a() == 0)
      {
        if (i == 0) {
          ((AbsStructMsgElement)localObject2).b(1);
        }
        if (i == j - 1) {
          ((AbsStructMsgElement)localObject2).b(2);
        }
      }
      localObject1 = ((ViewGroup)paramView).getChildAt(i);
      if ((localObject2 instanceof StructMsgItemLayout3))
      {
        localObject1 = ((AbsStructMsgElement)localObject2).a(paramContext, (View)localObject1, paramOnLongClickAndTouchListener);
        label477:
        if (localObject1 == null) {
          break label563;
        }
        if (!TextUtils.isEmpty(((AbsStructMsgElement)localObject2).c))
        {
          ((View)localObject1).setTag(localObject2);
          ((View)localObject1).setClickable(true);
          ((View)localObject1).setOnClickListener((View.OnClickListener)localObject2);
          ((View)localObject1).setOnLongClickListener(new jxg(this, paramOnLongClickAndTouchListener));
          ((View)localObject1).setOnTouchListener(new jxh(this, paramOnLongClickAndTouchListener));
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localObject1 = ((AbsStructMsgElement)localObject2).a(paramContext, (View)localObject1);
        break label477;
        if (QLog.isDevelopLevel()) {
          QLog.e("StructMsg", 4, "Create item view failure by #StructMsgItemViewFactory");
        }
      }
    }
  }
  
  protected boolean parseContentNode(StructMsgNode paramStructMsgNode)
  {
    boolean bool = false;
    if (paramStructMsgNode == null) {
      bool = true;
    }
    Object localObject;
    do
    {
      return bool;
      if ("item".equals(paramStructMsgNode.b)) {}
      for (localObject = paramStructMsgNode.a("layout");; localObject = StructMsgElementFactory.a(paramStructMsgNode.b))
      {
        try
        {
          if (!TextUtils.isEmpty((CharSequence)localObject)) {}
          for (int i = Integer.parseInt((String)localObject);; i = 0)
          {
            localObject = StructMsgElementFactory.a(i);
            if (localObject != null) {
              break;
            }
            return true;
          }
          if (!QLog.isDevelopLevel()) {
            break;
          }
        }
        catch (NumberFormatException paramStructMsgNode) {}
        QLog.d("StructMsg", 4, "Item layout value is " + 0);
        return false;
      }
    } while (!((AbsStructMsgElement)localObject).a(paramStructMsgNode));
    addItem((AbsStructMsgElement)localObject);
    return true;
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    int m = 0;
    int i = 1;
    try
    {
      int n = paramObjectInput.readInt();
      this.mVersion = n;
      Object localObject;
      label321:
      int i1;
      int k;
      if (n == 1)
      {
        this.mMsgTemplateID = paramObjectInput.readInt();
        this.mMsgAction = paramObjectInput.readUTF();
        this.mMsgActionData = paramObjectInput.readUTF();
        this.mMsg_A_ActionData = paramObjectInput.readUTF();
        this.mMsg_I_ActionData = paramObjectInput.readUTF();
        this.mMsgUrl = paramObjectInput.readUTF();
        this.mMsgBrief = paramObjectInput.readUTF();
        this.mContentLayout = paramObjectInput.readInt();
        this.mContentCover = paramObjectInput.readUTF();
        this.mContentTitle = paramObjectInput.readUTF();
        this.mContentSummary = paramObjectInput.readUTF();
        localObject = StructMsgElementFactory.a(this.mContentLayout);
        ((AbsStructMsgItem)localObject).a(new StructMsgItemCover(this.mContentCover));
        ((AbsStructMsgItem)localObject).a(new StructMsgItemTitle(this.mContentTitle));
        ((AbsStructMsgItem)localObject).a(new StructMsgItemSummary(this.mContentSummary));
        addItem((AbsStructMsgElement)localObject);
        this.mSourceAppid = paramObjectInput.readLong();
        this.mSourceIcon = paramObjectInput.readUTF();
        this.mSourceName = paramObjectInput.readUTF();
        this.mSourceUrl = paramObjectInput.readUTF();
        this.mSourceAction = paramObjectInput.readUTF();
        this.mSourceActionData = paramObjectInput.readUTF();
        this.mSource_A_ActionData = paramObjectInput.readUTF();
        this.mSource_I_ActionData = paramObjectInput.readUTF();
        this.fwFlag = paramObjectInput.readInt();
        if ((!this.mHasSource) && ((!TextUtils.isEmpty(this.mSourceName)) || (!TextUtils.isEmpty(this.mSourceIcon))))
        {
          this.mHasSource = true;
          return;
          this.mMsgTemplateID = paramObjectInput.readInt();
          this.mMsgAction = paramObjectInput.readUTF();
          this.mMsgActionData = paramObjectInput.readUTF();
          this.mMsg_A_ActionData = paramObjectInput.readUTF();
          this.mMsg_I_ActionData = paramObjectInput.readUTF();
          this.mMsgUrl = paramObjectInput.readUTF();
          this.mMsgBrief = paramObjectInput.readUTF();
          i1 = paramObjectInput.readInt();
          k = 0;
        }
      }
      for (;;)
      {
        int j;
        if (k < i1)
        {
          localObject = paramObjectInput.readUTF();
          if ("item".equals(localObject)) {
            localObject = StructMsgElementFactory.a(paramObjectInput.readInt());
          }
          for (;;)
          {
            j = i;
            if (localObject == null) {
              break;
            }
            ((AbsStructMsgElement)localObject).a(paramObjectInput);
            j = i;
            if (!TextUtils.isEmpty(((AbsStructMsgElement)localObject).c))
            {
              ((AbsStructMsgElement)localObject).h = String.valueOf(i);
              j = i + 1;
            }
            ((AbsStructMsgElement)localObject).i = this.uin;
            addItem((AbsStructMsgElement)localObject);
            break;
            AbsStructMsgElement localAbsStructMsgElement = StructMsgElementFactory.a((String)localObject);
            localObject = localAbsStructMsgElement;
            if (localAbsStructMsgElement != null)
            {
              localObject = localAbsStructMsgElement;
              if (AbsStructMsgItem.class.isInstance(localAbsStructMsgElement))
              {
                paramObjectInput.readInt();
                localObject = localAbsStructMsgElement;
              }
            }
          }
        }
        this.mSourceAppid = paramObjectInput.readLong();
        this.mSourceIcon = paramObjectInput.readUTF();
        this.mSourceName = paramObjectInput.readUTF();
        this.mSourceUrl = paramObjectInput.readUTF();
        this.mSourceAction = paramObjectInput.readUTF();
        this.mSourceActionData = paramObjectInput.readUTF();
        this.mSource_A_ActionData = paramObjectInput.readUTF();
        this.mSource_I_ActionData = paramObjectInput.readUTF();
        this.fwFlag = paramObjectInput.readInt();
        this.mFlag = paramObjectInput.readInt();
        this.mResid = paramObjectInput.readUTF();
        this.mFileName = paramObjectInput.readUTF();
        this.mFileSize = paramObjectInput.readLong();
        this.mCommentText = paramObjectInput.readUTF();
        if (n != 3) {
          break;
        }
        this.mCompatibleText = paramObjectInput.readUTF();
        this.msgId = paramObjectInput.readLong();
        this.mPromotionType = paramObjectInput.readInt();
        this.mPromotionMsg = paramObjectInput.readUTF();
        this.mPromotionMenus = paramObjectInput.readUTF();
        this.mPromotionMenuDestructiveIndex = paramObjectInput.readInt();
        i = m;
        while (i < this.mStructMsgItemLists.size())
        {
          ((AbsStructMsgElement)this.mStructMsgItemLists.get(i)).a = this.msgId;
          i += 1;
        }
        break;
        return;
        if (n == 2) {
          break label321;
        }
        if (n != 3) {
          break;
        }
        break label321;
        k += 1;
        i = j;
      }
      return;
    }
    catch (IOException paramObjectInput) {}
  }
  
  @Deprecated
  public void setProgress(int paramInt)
  {
    AbsStructMsgElement localAbsStructMsgElement = findXmlNode("progress");
    if ((localAbsStructMsgElement != null) && ((localAbsStructMsgElement instanceof StructMsgItemProgress))) {
      ((StructMsgItemProgress)localAbsStructMsgElement).d(paramInt);
    }
  }
  
  @Deprecated
  public void setSummary(String paramString)
  {
    AbsStructMsgElement localAbsStructMsgElement = findXmlNode("summary");
    if ((localAbsStructMsgElement != null) && ((localAbsStructMsgElement instanceof StructMsgItemSummary))) {
      ((StructMsgItemSummary)localAbsStructMsgElement).a(paramString);
    }
  }
  
  @Deprecated
  public void setTitle(String paramString)
  {
    AbsStructMsgElement localAbsStructMsgElement = findXmlNode("title");
    if ((localAbsStructMsgElement != null) && ((localAbsStructMsgElement instanceof StructMsgItemTitle))) {
      ((StructMsgItemTitle)localAbsStructMsgElement).a(paramString);
    }
  }
  
  protected void toContentXml(jwy paramjwy)
  {
    Iterator localIterator = iterator();
    while (localIterator.hasNext()) {
      ((AbsStructMsgElement)localIterator.next()).a(paramjwy);
    }
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeInt(this.mMsgServiceID);
    paramObjectOutput.writeInt(this.mVersion);
    paramObjectOutput.writeInt(this.mMsgTemplateID);
    if (this.mMsgAction == null)
    {
      localObject = "";
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMsgActionData != null) {
        break label186;
      }
      localObject = "";
      label59:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMsg_A_ActionData != null) {
        break label194;
      }
      localObject = "";
      label77:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMsg_I_ActionData != null) {
        break label202;
      }
      localObject = "";
      label95:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMsgUrl != null) {
        break label210;
      }
      localObject = "";
      label113:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMsgBrief != null) {
        break label218;
      }
    }
    label186:
    label194:
    label202:
    label210:
    label218:
    for (Object localObject = "";; localObject = this.mMsgBrief)
    {
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(getItemCount());
      localObject = iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AbsStructMsgElement)((Iterator)localObject).next()).a(paramObjectOutput);
      }
      localObject = this.mMsgAction;
      break;
      localObject = this.mMsgActionData;
      break label59;
      localObject = this.mMsg_A_ActionData;
      break label77;
      localObject = this.mMsg_I_ActionData;
      break label95;
      localObject = this.mMsgUrl;
      break label113;
    }
    paramObjectOutput.writeLong(this.mSourceAppid);
    if (this.mSourceIcon == null)
    {
      localObject = "";
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceName != null) {
        break label539;
      }
      localObject = "";
      label265:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceUrl != null) {
        break label547;
      }
      localObject = "";
      label283:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceAction != null) {
        break label555;
      }
      localObject = "";
      label301:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceActionData != null) {
        break label563;
      }
      localObject = "";
      label319:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSource_A_ActionData != null) {
        break label571;
      }
      localObject = "";
      label337:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSource_I_ActionData != null) {
        break label579;
      }
      localObject = "";
      label355:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.fwFlag);
      paramObjectOutput.writeInt(this.mFlag);
      if (this.mResid != null) {
        break label587;
      }
      localObject = "";
      label393:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mFileName != null) {
        break label595;
      }
      localObject = "";
      label411:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeLong(this.mFileSize);
      if (this.mCommentText != null) {
        break label603;
      }
      localObject = "";
      label439:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mCompatibleText != null) {
        break label611;
      }
      localObject = "";
      label457:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeLong(this.msgId);
      paramObjectOutput.writeInt(this.mPromotionType);
      if (this.mPromotionMsg != null) {
        break label619;
      }
      localObject = "";
      label495:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mPromotionMenus != null) {
        break label627;
      }
    }
    label539:
    label547:
    label555:
    label563:
    label571:
    label579:
    label587:
    label595:
    label603:
    label611:
    label619:
    label627:
    for (localObject = "";; localObject = this.mPromotionMenus)
    {
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.mPromotionMenuDestructiveIndex);
      return;
      localObject = this.mSourceIcon;
      break;
      localObject = this.mSourceName;
      break label265;
      localObject = this.mSourceUrl;
      break label283;
      localObject = this.mSourceAction;
      break label301;
      localObject = this.mSourceActionData;
      break label319;
      localObject = this.mSource_A_ActionData;
      break label337;
      localObject = this.mSource_I_ActionData;
      break label355;
      localObject = this.mResid;
      break label393;
      localObject = this.mFileName;
      break label411;
      localObject = this.mCommentText;
      break label439;
      localObject = this.mCompatibleText;
      break label457;
      localObject = this.mPromotionMsg;
      break label495;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForGeneralShare
 * JD-Core Version:    0.7.0.1
 */