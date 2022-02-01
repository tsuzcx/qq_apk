package com.tencent.device.msg.activities;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.device.file.DeviceAVFileMsgObserver;
import com.tencent.device.file.DeviceAVFileMsgObserver.DevMsgViewCallback;
import com.tencent.device.file.DeviceAVFileMsgObserver.DevMsgViewData;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.Holder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import dat;
import dau;
import dav;

public class DevShortVideoItemBuilder
  extends ShortVideoItemBuilder
  implements DeviceAVFileMsgObserver.DevMsgViewCallback
{
  private static final String b = "DeviceShortVideo";
  
  public DevShortVideoItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.f = 1;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramChatMessage = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a().a(paramChatMessage, this);
    return paramChatMessage;
  }
  
  protected void a(View paramView)
  {
    paramView = (ShortVideoItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localMessageForShortVideo.isSendFromLocal())
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
      localActionSheet.a(2131366317, 5);
      localActionSheet.e(2131365736);
      localActionSheet.a(new dav(this, localMessageForShortVideo, paramView, localActionSheet));
      localActionSheet.show();
    }
  }
  
  public void a(View paramView, DeviceAVFileMsgObserver.DevMsgViewData paramDevMsgViewData)
  {
    paramView = (ShortVideoItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localMessageForShortVideo.uniseq != paramDevMsgViewData.jdField_a_of_type_Long) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("DeviceShortVideo", 2, "updateView msg.uniseq:" + localMessageForShortVideo.uniseq + " ===> fileStatus:" + ShortVideoUtils.b(paramDevMsgViewData.jdField_a_of_type_Int));
      }
      switch (paramDevMsgViewData.jdField_a_of_type_Int)
      {
      case 1004: 
      default: 
        return;
      case 1001: 
        a(paramView);
        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        return;
      case 1003: 
        b(paramView);
        return;
      case 1005: 
        b(paramView);
        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        return;
      }
    } while (!localMessageForShortVideo.isSendFromLocal());
    int j = (int)(100.0F * paramDevMsgViewData.jdField_a_of_type_Float);
    if ((paramView.jdField_a_of_type_AndroidWidgetProgressBar == null) || (paramView.jdField_a_of_type_AndroidWidgetProgressBar.getVisibility() != 0)) {
      a(paramView);
    }
    paramDevMsgViewData = paramView.jdField_a_of_type_AndroidWidgetProgressBar;
    if (j == 0) {}
    for (int i = 1;; i = j)
    {
      paramDevMsgViewData.setProgress(i);
      if (QLog.isColorLevel()) {
        QLog.d("DeviceShortVideo", 2, "handleMessage VIDEO ==> STATUS_SEND_PROCESS, progress=" + j);
      }
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
      return;
    }
  }
  
  public void a(ShortVideoItemBuilder.Holder paramHolder)
  {
    super.a(paramHolder);
    if (paramHolder.jdField_a_of_type_AndroidWidgetImageView != null) {
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  protected void a(ShortVideoItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo)
  {
    int j = 0;
    int k = 1;
    DeviceAVFileMsgObserver localDeviceAVFileMsgObserver = ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a();
    if (localDeviceAVFileMsgObserver != null) {}
    for (int i = 1;; i = 0)
    {
      if (!localDeviceAVFileMsgObserver.a(paramMessageForShortVideo.uniseq)) {
        j = 1;
      }
      if ((i & j) == 0) {
        break;
      }
      b(paramHolder);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      if (QLog.isColorLevel()) {
        QLog.d("DeviceShortVideo", 2, "getBubbleView : --> STATUS_SEND_PROCESS, 上传过程中被杀进程然后恢复");
      }
      return;
    }
    a(paramHolder);
    j = paramMessageForShortVideo.videoFileProgress;
    paramHolder = paramHolder.jdField_a_of_type_AndroidWidgetProgressBar;
    if (j == 0) {}
    for (i = k;; i = j)
    {
      paramHolder.setProgress(i);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("DeviceShortVideo", 2, "getBubbleView : SHORT_VIDEO --> STATUS_SEND_PROCESS, 正在上传， progress:" + j);
      return;
    }
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo)
  {
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      paramMessageForShortVideo = Looper.getMainLooper();
      if (Thread.currentThread() == paramMessageForShortVideo.getThread())
      {
        FMToastUtil.a(2131362120);
        return;
      }
      new Handler(paramMessageForShortVideo).post(new dat(this));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DeviceShortVideo", 2, "startUploadVideo");
    }
    ThreadManager.a().post(new dau(this, paramMessageForShortVideo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.device.msg.activities.DevShortVideoItemBuilder
 * JD-Core Version:    0.7.0.1
 */