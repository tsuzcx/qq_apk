package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.QQPlayerService.QQPlayerCallback;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.ref.WeakReference;
import java.util.Date;
import jwy;
import jxa;
import jxb;
import jxc;
import jxd;

public class StructMsgForAudioShare
  extends AbsShareMsg
  implements QQPlayerService.QQPlayerCallback
{
  private static View.OnClickListener a = new jxa();
  private WeakReference mCoverImage;
  private View.OnClickListener musicShareCoverClikListener = new jxb(this);
  
  StructMsgForAudioShare()
  {
    this.mMsgServiceID = 2;
  }
  
  StructMsgForAudioShare(Bundle paramBundle)
  {
    super(paramBundle);
    this.mContentSrc = paramBundle.getString("audio_url");
    this.mContentLayout = 2;
    this.mMsgServiceID = 2;
    this.mMsgAction = "web";
  }
  
  StructMsgForAudioShare(StructMsgNode paramStructMsgNode)
  {
    super(paramStructMsgNode);
    this.mMsgServiceID = 2;
  }
  
  public static StructMsgForAudioShare getTestObj()
  {
    StructMsgForAudioShare localStructMsgForAudioShare = new StructMsgForAudioShare();
    localStructMsgForAudioShare.mMsgServiceID = 2;
    localStructMsgForAudioShare.fwFlag = 0;
    localStructMsgForAudioShare.mContentCover = "https://url.cn/R3i1JD";
    localStructMsgForAudioShare.mContentLayout = 2;
    localStructMsgForAudioShare.mContentSrc = "https://url.cn/JpkdzT";
    localStructMsgForAudioShare.mContentSummary = "张惠妹";
    localStructMsgForAudioShare.mContentTitle = ("记得" + new Date());
    localStructMsgForAudioShare.mMsgUrl = "https://y.qq.com/i/song.html?songid=625023&source=qq";
    localStructMsgForAudioShare.mSourceName = "QQ音乐";
    localStructMsgForAudioShare.mMsgBrief = "QQ音乐 的分享";
    localStructMsgForAudioShare.mMsgAction = "web";
    localStructMsgForAudioShare.mMsgActionData = "y.qq.com";
    localStructMsgForAudioShare.mMsg_A_ActionData = "com.tencent.qqmusic";
    localStructMsgForAudioShare.mSource_I_ActionData = "tencent100497308://";
    localStructMsgForAudioShare.mSourceAction = "app";
    localStructMsgForAudioShare.mMsgTemplateID = 1;
    localStructMsgForAudioShare.mSourceAppid = 100497308L;
    localStructMsgForAudioShare.mSourceUrl = "https://web.p.qq.com/qqmpmobile/aio/app.html?id=100497308";
    localStructMsgForAudioShare.mSourceIcon = "https://p.qpic.cn/qqconnect_app_logo/1LlgQzJVOyA9xucianwgfHru8JA97ERytRa0lHcRRGGw/0";
    return localStructMsgForAudioShare;
  }
  
  public View.OnClickListener getOnClickListener()
  {
    return a;
  }
  
  public View getPreDialogView(Context paramContext, View paramView)
  {
    View localView = LayoutInflater.from(paramContext).inflate(2130904453, null);
    ImageView localImageView = (ImageView)localView.findViewById(2131296340);
    Object localObject = (TextView)localView.findViewById(2131296341);
    TextView localTextView = (TextView)localView.findViewById(2131296342);
    paramView = this.mContentCover;
    String str1 = this.mContentTitle;
    String str2 = this.mContentSummary;
    ((TextView)localObject).setText(str1);
    localTextView.setText(str2);
    if (!TextUtils.isEmpty(str1))
    {
      localTextView.setMaxLines(2);
      ((TextView)localObject).setVisibility(0);
      if (!TextUtils.isEmpty(str2)) {
        break label177;
      }
    }
    label177:
    for (int i = 3;; i = 2)
    {
      ((TextView)localObject).setMaxLines(i);
      i = 2130841991;
      if ((this instanceof StructMsgForAudioShare)) {
        i = 2130841994;
      }
      localObject = paramContext.getResources().getDrawable(i);
      localImageView.setBackgroundDrawable(null);
      if (!TextUtils.isEmpty(paramView)) {
        break label182;
      }
      localImageView.setImageDrawable((Drawable)localObject);
      return localView;
      ((TextView)localObject).setVisibility(8);
      localTextView.setMaxLines(4);
      break;
    }
    label182:
    if ((!paramView.startsWith("http://")) && (!paramView.startsWith("https://"))) {}
    for (paramContext = Uri.fromFile(new File(paramView)).toString();; paramContext = paramView)
    {
      localImageView.setImageDrawable(URLDrawable.getDrawable(paramContext, (Drawable)localObject, (Drawable)localObject));
      return localView;
    }
  }
  
  public String getToken()
  {
    return QQPlayerService.a(1, String.valueOf(this.uniseq));
  }
  
  public View getView(Context paramContext, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Object localObject1 = paramContext.getResources();
    paramView = LayoutInflater.from(paramContext).inflate(2130904451, null);
    paramOnLongClickAndTouchListener = (URLImageView)paramView.findViewById(2131296340);
    this.mCoverImage = new WeakReference(paramOnLongClickAndTouchListener);
    Object localObject2 = (TextView)paramView.findViewById(2131296341);
    TextView localTextView = (TextView)paramView.findViewById(2131296342);
    ((TextView)localObject2).setText(this.mContentTitle);
    localTextView.setText(this.mContentSummary);
    int i;
    if (!TextUtils.isEmpty(this.mContentTitle))
    {
      localTextView.setMaxLines(2);
      ((TextView)localObject2).setVisibility(0);
      if (!TextUtils.isEmpty(this.mContentSummary)) {
        break label293;
      }
      i = 3;
      label115:
      ((TextView)localObject2).setMaxLines(i);
      paramOnLongClickAndTouchListener.setVisibility(0);
      if (!QQPlayerService.a(this)) {
        break label299;
      }
      paramOnLongClickAndTouchListener.setImageResource(2130840374);
      paramOnLongClickAndTouchListener.setContentDescription(((Resources)localObject1).getString(2131369277));
      label153:
      if (TextUtils.isEmpty(this.mContentCover)) {
        break label367;
      }
      localObject2 = this.mContentCover;
      localObject1 = ((Resources)localObject1).getDrawable(2130841994);
    }
    for (;;)
    {
      try
      {
        localObject1 = URLDrawable.getDrawable((String)localObject2, (Drawable)localObject1, (Drawable)localObject1);
        if (AbsDownloader.a((String)localObject2)) {
          break label392;
        }
        if (URLDrawableHelper.a(paramContext)) {
          continue;
        }
      }
      catch (Exception paramContext)
      {
        label293:
        label299:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("AudioShareMsg", 2, "getView " + paramContext.getMessage());
        continue;
      }
      ((URLDrawable)localObject1).setAutoDownload(bool);
      paramOnLongClickAndTouchListener.setBackgroundDrawable((Drawable)localObject1);
      paramContext = paramView.getLayoutParams();
      if (paramContext == null)
      {
        paramContext = new RelativeLayout.LayoutParams(BaseChatItemLayout.g, -2);
        paramView.setLayoutParams(paramContext);
        paramOnLongClickAndTouchListener.setTag(this);
        paramOnLongClickAndTouchListener.setOnClickListener(this.musicShareCoverClikListener);
        paramView.setId(2131296309);
        paramView.setTag(2131296309, this);
        return paramView;
        ((TextView)localObject2).setVisibility(8);
        localTextView.setMaxLines(4);
        break;
        i = 2;
        break label115;
        paramOnLongClickAndTouchListener.setImageResource(2130840373);
        paramOnLongClickAndTouchListener.setContentDescription(((Resources)localObject1).getString(2131369276));
        break label153;
        bool = false;
        continue;
        label367:
        paramOnLongClickAndTouchListener.setBackgroundResource(2130841994);
        continue;
      }
      paramContext.width = BaseChatItemLayout.g;
      paramContext.height = -2;
      continue;
      label392:
      boolean bool = true;
    }
  }
  
  public void onPlaySongChanged(SongInfo paramSongInfo) {}
  
  public void onPlayStateChanged(int paramInt)
  {
    if ((this.mCoverImage == null) || (this.mCoverImage.get() == null)) {}
    URLImageView localURLImageView;
    do
    {
      return;
      localURLImageView = (URLImageView)this.mCoverImage.get();
    } while (localURLImageView == null);
    Resources localResources = localURLImageView.getContext().getResources();
    if ((paramInt == 2) || (paramInt == 1))
    {
      localURLImageView.post(new jxc(this, localURLImageView));
      localURLImageView.setContentDescription(localResources.getString(2131369277));
      return;
    }
    localURLImageView.post(new jxd(this, localURLImageView));
    localURLImageView.setContentDescription(localResources.getString(2131369276));
  }
  
  protected boolean parseContentNode(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {}
    do
    {
      do
      {
        return true;
        this.mContentLayout = StructMsgUtils.a(paramStructMsgNode.a("layout"));
      } while ((paramStructMsgNode == null) || (paramStructMsgNode.a() < 3));
      StructMsgNode localStructMsgNode = paramStructMsgNode.a(0);
      if (localStructMsgNode != null)
      {
        this.mContentCover = localStructMsgNode.a("cover");
        this.mContentSrc = localStructMsgNode.a("src");
      }
      localStructMsgNode = paramStructMsgNode.a(1);
      if (localStructMsgNode != null) {
        this.mContentTitle = MessageUtils.a(StructMsgFactory.a(localStructMsgNode), false);
      }
      paramStructMsgNode = paramStructMsgNode.a(2);
    } while (paramStructMsgNode == null);
    this.mContentSummary = MessageUtils.a(StructMsgFactory.a(paramStructMsgNode), false);
    return true;
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    for (;;)
    {
      int i;
      try
      {
        i = paramObjectInput.readInt();
        this.mVersion = i;
        if (i != 1) {
          break label561;
        }
        this.mMsgTemplateID = paramObjectInput.readInt();
        this.mMsgAction = paramObjectInput.readUTF();
        this.mMsgActionData = paramObjectInput.readUTF();
        this.mMsg_A_ActionData = paramObjectInput.readUTF();
        this.mMsg_I_ActionData = paramObjectInput.readUTF();
        this.mMsgUrl = paramObjectInput.readUTF();
        this.mMsgBrief = paramObjectInput.readUTF();
        this.mContentLayout = paramObjectInput.readInt();
        this.mContentCover = paramObjectInput.readUTF();
        this.mContentSrc = paramObjectInput.readUTF();
        this.mContentTitle = paramObjectInput.readUTF();
        this.mContentSummary = paramObjectInput.readUTF();
        this.mSourceAppid = paramObjectInput.readLong();
        this.mSourceIcon = paramObjectInput.readUTF();
        this.mSourceName = paramObjectInput.readUTF();
        this.mSourceUrl = paramObjectInput.readUTF();
        this.mSourceAction = paramObjectInput.readUTF();
        this.mSourceActionData = paramObjectInput.readUTF();
        this.mSource_A_ActionData = paramObjectInput.readUTF();
        this.mSource_I_ActionData = paramObjectInput.readUTF();
        this.fwFlag = paramObjectInput.readInt();
        if ((TextUtils.isEmpty(this.mSourceName)) && (TextUtils.isEmpty(this.mSourceIcon))) {
          break label560;
        }
        this.mHasSource = true;
        return;
      }
      catch (IOException paramObjectInput) {}
      this.mMsgTemplateID = paramObjectInput.readInt();
      this.mMsgAction = paramObjectInput.readUTF();
      this.mMsgActionData = paramObjectInput.readUTF();
      this.mMsg_A_ActionData = paramObjectInput.readUTF();
      this.mMsg_I_ActionData = paramObjectInput.readUTF();
      this.mMsgUrl = paramObjectInput.readUTF();
      this.mMsgBrief = paramObjectInput.readUTF();
      this.mContentLayout = paramObjectInput.readInt();
      this.mContentCover = paramObjectInput.readUTF();
      this.mContentSrc = paramObjectInput.readUTF();
      this.mContentTitle = paramObjectInput.readUTF();
      this.mContentSummary = paramObjectInput.readUTF();
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
      this.mHasSource = paramObjectInput.readBoolean();
      this.mCommentText = paramObjectInput.readUTF();
      if (i == 3)
      {
        this.mCompatibleText = paramObjectInput.readUTF();
        this.msgId = paramObjectInput.readLong();
        this.mPromotionType = paramObjectInput.readInt();
        this.mPromotionMsg = paramObjectInput.readUTF();
        this.mPromotionMenus = paramObjectInput.readUTF();
        this.mPromotionMenuDestructiveIndex = paramObjectInput.readInt();
        return;
      }
      label560:
      label561:
      do
      {
        return;
        if (i == 2) {
          break;
        }
      } while (i != 3);
    }
  }
  
  protected void toContentXml(jwy paramjwy)
  {
    paramjwy.startTag(null, "item");
    paramjwy.attribute(null, "layout", String.valueOf(this.mContentLayout));
    paramjwy.startTag(null, "audio");
    if (this.mContentCover == null)
    {
      str = "";
      paramjwy.attribute(null, "cover", str);
      if (this.mContentSrc != null) {
        break label173;
      }
      str = "";
      label66:
      paramjwy.attribute(null, "src", str);
      paramjwy.endTag(null, "audio");
      paramjwy.startTag(null, "title");
      if (this.mContentTitle != null) {
        break label181;
      }
      str = "";
      label105:
      paramjwy.text(str);
      paramjwy.endTag(null, "title");
      paramjwy.startTag(null, "summary");
      if (this.mContentSummary != null) {
        break label189;
      }
    }
    label173:
    label181:
    label189:
    for (String str = "";; str = this.mContentSummary)
    {
      paramjwy.text(str);
      paramjwy.endTag(null, "summary");
      paramjwy.endTag(null, "item");
      return;
      str = this.mContentCover;
      break;
      str = this.mContentSrc;
      break label66;
      str = this.mContentTitle;
      break label105;
    }
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeInt(this.mMsgServiceID);
    paramObjectOutput.writeInt(this.mVersion);
    paramObjectOutput.writeInt(this.mMsgTemplateID);
    if (this.mMsgAction == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.mMsgActionData != null) {
        break label497;
      }
      str = "";
      label59:
      paramObjectOutput.writeUTF(str);
      if (this.mMsg_A_ActionData != null) {
        break label505;
      }
      str = "";
      label77:
      paramObjectOutput.writeUTF(str);
      if (this.mMsg_I_ActionData != null) {
        break label513;
      }
      str = "";
      label95:
      paramObjectOutput.writeUTF(str);
      if (this.mMsgUrl != null) {
        break label521;
      }
      str = "";
      label113:
      paramObjectOutput.writeUTF(str);
      if (this.mMsgBrief != null) {
        break label529;
      }
      str = "";
      label131:
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeInt(this.mContentLayout);
      if (this.mContentCover != null) {
        break label537;
      }
      str = "";
      label159:
      paramObjectOutput.writeUTF(str);
      if (this.mContentSrc != null) {
        break label545;
      }
      str = "";
      label177:
      paramObjectOutput.writeUTF(str);
      if (this.mContentTitle != null) {
        break label553;
      }
      str = "";
      label195:
      paramObjectOutput.writeUTF(str);
      if (this.mContentSummary != null) {
        break label565;
      }
      str = "";
      label213:
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeLong(this.mSourceAppid);
      if (this.mSourceIcon != null) {
        break label577;
      }
      str = "";
      label241:
      paramObjectOutput.writeUTF(str);
      if (this.mSourceName != null) {
        break label585;
      }
      str = "";
      label259:
      paramObjectOutput.writeUTF(str);
      if (this.mSourceUrl != null) {
        break label593;
      }
      str = "";
      label277:
      paramObjectOutput.writeUTF(str);
      if (this.mSourceAction != null) {
        break label601;
      }
      str = "";
      label295:
      paramObjectOutput.writeUTF(str);
      if (this.mSourceActionData != null) {
        break label609;
      }
      str = "";
      label313:
      paramObjectOutput.writeUTF(str);
      if (this.mSource_A_ActionData != null) {
        break label617;
      }
      str = "";
      label331:
      paramObjectOutput.writeUTF(str);
      if (this.mSource_I_ActionData != null) {
        break label625;
      }
      str = "";
      label349:
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeInt(this.fwFlag);
      paramObjectOutput.writeInt(this.mFlag);
      paramObjectOutput.writeBoolean(this.mHasSource);
      if (this.mCommentText != null) {
        break label633;
      }
      str = "";
      label397:
      paramObjectOutput.writeUTF(str);
      if (this.mCompatibleText != null) {
        break label641;
      }
      str = "";
      label415:
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeLong(this.msgId);
      paramObjectOutput.writeInt(this.mPromotionType);
      if (this.mPromotionMsg != null) {
        break label649;
      }
      str = "";
      label453:
      paramObjectOutput.writeUTF(str);
      if (this.mPromotionMenus != null) {
        break label657;
      }
    }
    label513:
    label521:
    label657:
    for (String str = "";; str = this.mPromotionMenus)
    {
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeInt(this.mPromotionMenuDestructiveIndex);
      return;
      str = this.mMsgAction;
      break;
      label497:
      str = this.mMsgActionData;
      break label59;
      label505:
      str = this.mMsg_A_ActionData;
      break label77;
      str = this.mMsg_I_ActionData;
      break label95;
      str = this.mMsgUrl;
      break label113;
      label529:
      str = this.mMsgBrief;
      break label131;
      label537:
      str = this.mContentCover;
      break label159;
      label545:
      str = this.mContentSrc;
      break label177;
      label553:
      str = MessageUtils.a(this.mContentTitle, false);
      break label195;
      label565:
      str = MessageUtils.a(this.mContentSummary, false);
      break label213;
      label577:
      str = this.mSourceIcon;
      break label241;
      label585:
      str = this.mSourceName;
      break label259;
      label593:
      str = this.mSourceUrl;
      break label277;
      label601:
      str = this.mSourceAction;
      break label295;
      label609:
      str = this.mSourceActionData;
      break label313;
      label617:
      str = this.mSource_A_ActionData;
      break label331;
      label625:
      str = this.mSource_I_ActionData;
      break label349;
      label633:
      str = this.mCommentText;
      break label397;
      str = this.mCompatibleText;
      break label415;
      str = this.mPromotionMsg;
      break label453;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForAudioShare
 * JD-Core Version:    0.7.0.1
 */