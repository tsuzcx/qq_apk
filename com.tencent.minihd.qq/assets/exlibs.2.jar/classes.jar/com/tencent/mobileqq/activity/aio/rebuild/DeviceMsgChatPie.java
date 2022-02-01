package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.dataline.util.file.SendInfo;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.file.DevAudioMsgProcessor;
import com.tencent.device.file.DevVideoMsgProcessor;
import com.tencent.device.file.DeviceAVFileMsgObserver;
import com.tencent.device.msg.data.DeviceComnFileMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.PanelAdapter.ViewHolder;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.PatchedButton;
import fzv;
import fzw;
import fzx;
import fzy;
import java.io.File;
import java.util.ArrayList;

public class DeviceMsgChatPie
  extends BaseChatPie
{
  private static final String M = "devicemsg_showsupporttips_first";
  public static final int cg = 1;
  public static final int ch = 2;
  public String K = "";
  private final String L = DeviceMsgChatPie.class.getSimpleName();
  private BroadcastReceiver a;
  public Boolean a;
  public int cf = 0;
  private boolean o = false;
  
  public DeviceMsgChatPie(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    super(paramQQAppInterface, paramBaseActivity);
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new fzy(this);
  }
  
  private void ae()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getExtras() == null) {
      v();
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(20);
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    Object localObject;
    if ((81 == paramInt1) || (83 == paramInt1))
    {
      localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53);
      DeviceInfo localDeviceInfo = ((SmartDeviceProxyMgr)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      if (localDeviceInfo == null) {
        break label441;
      }
      localObject = ((SmartDeviceProxyMgr)localObject).a(localDeviceInfo.productId);
      if ((localObject == null) || (!((ProductInfo)localObject).isSupportFuncMsgType(2))) {
        break label441;
      }
    }
    label441:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131369916), MessageCache.a(), true, false, true);
        SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Usr_AIO_SendMsg", 7, 0, 0);
      }
      do
      {
        do
        {
          do
          {
            return;
            switch (paramInt1)
            {
            case 82: 
            default: 
              return;
            }
          } while ((paramInt2 != -1) || (paramIntent == null));
          paramIntent = paramIntent.getParcelableArrayListExtra("sendInfo");
        } while ((paramIntent == null) || (paramIntent.size() <= 0));
        this.K = ((SendInfo)paramIntent.get(0)).a();
        DevVideoMsgProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.K);
        return;
        this.K = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext()).getString("device_video_path", "");
        PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext()).edit().remove("device_video_path").commit();
        if (paramInt2 != -1) {
          break;
        }
      } while (TextUtils.isEmpty(this.K));
      paramIntent = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230);
      paramIntent.setNegativeButton(2131365736, new fzv(this));
      paramIntent.setPositiveButton(2131365737, new fzw(this));
      paramIntent.setTitle("提示");
      localObject = new File(this.K);
      localObject = ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ((File)localObject).length());
      paramIntent.setMessage("视频大小为" + (String)localObject + "，确定要发送吗？");
      paramIntent.show();
      return;
      if (!TextUtils.isEmpty(this.K)) {
        FileUtils.d(this.K);
      }
      this.K = "";
      return;
    }
  }
  
  protected void a(String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.L, 2, "cancelSendPttInner(),recordingUniseq is:" + paramLong + ",path is:" + paramString);
    }
  }
  
  protected void a(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    if (!this.o) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "sendPttInner(),recordingUniseq is:" + paramLong + ",path is:" + paramString);
      }
      MessageRecord localMessageRecord;
      if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)) {
        if (paramLong != 0L) {
          localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong);
        }
      }
      while (localMessageRecord != null)
      {
        super.a(0, paramString, localMessageRecord.uniseq);
        ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a().a(DeviceMsgHandle.d, paramString, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), localMessageRecord.uniseq, localMessageRecord.istroop);
        paramLong = localMessageRecord.uniseq;
        return;
        localMessageRecord = DevAudioMsgProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, -2L);
        continue;
        localMessageRecord = null;
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Usr_AIO_SendMsg", 1, 0, 0);
    Object localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53);
    DeviceInfo localDeviceInfo = ((SmartDeviceProxyMgr)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (localDeviceInfo != null)
    {
      localObject = ((SmartDeviceProxyMgr)localObject).a(localDeviceInfo.productId);
      if ((localObject == null) || (!((ProductInfo)localObject).isSupportMainMsgType(2))) {}
    }
    for (boolean bool = true;; bool = false)
    {
      this.o = bool;
      if (!bool)
      {
        ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131369918), MessageCache.a(), true, false, true);
        SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Usr_AIO_SendMsg", 7, 0, 0);
      }
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d(this.L, 2, "onRecorderPerpare path = " + paramString);
        }
        StreamDataManager.a(paramString, 0, (int)(System.currentTimeMillis() / 1000L));
        StreamDataManager.a(paramString, "#!AMR\n".getBytes(), "#!AMR\n".getBytes().length, (short)0);
      } while (paramString == null);
      if (paramBoolean)
      {
        this.c = 0L;
        g(2131165197);
      }
      for (;;)
      {
        c(true);
        return;
        paramString = DevAudioMsgProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, -2L);
        if (paramString != null) {
          this.c = paramString.uniseq;
        }
        g(2131165189);
      }
    }
  }
  
  protected boolean a(boolean paramBoolean)
  {
    int i = 0;
    ae();
    super.a(paramBoolean);
    if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())
    {
      this.d.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(8);
      ad();
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("SmartDevice_DeviceUnBindRst");
      ((IntentFilter)localObject).addAction("SmartDevice_ProductFetchRst");
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getExtras();
      if (localObject != null)
      {
        this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(((Bundle)localObject).getBoolean("bFromLightApp", false));
        i = ((Bundle)localObject).getInt("operType", 0);
      }
      if (i != 1) {
        break label176;
      }
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.performClick();
      localObject = new View(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      localViewHolder = new PanelAdapter.ViewHolder();
      localViewHolder.jdField_a_of_type_Int = 2130838012;
      ((View)localObject).setTag(localViewHolder);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.onClick((View)localObject);
    }
    label176:
    while (i != 2) {
      return true;
    }
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.performClick();
    Object localObject = new View(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    PanelAdapter.ViewHolder localViewHolder = new PanelAdapter.ViewHolder();
    localViewHolder.jdField_a_of_type_Int = 2130838002;
    ((View)localObject).setTag(localViewHolder);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.onClick((View)localObject);
    return true;
  }
  
  public void ad()
  {
    int i = (int)(6.0F * this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics().density);
    Object localObject1 = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetEditText.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject1).leftMargin = i;
    this.jdField_a_of_type_AndroidWidgetEditText.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    Object localObject3 = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53);
    Object localObject2 = ((SmartDeviceProxyMgr)localObject3).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (localObject2 != null)
    {
      localObject3 = ((SmartDeviceProxyMgr)localObject3).a(((DeviceInfo)localObject2).productId);
      if ((localObject3 != null) && (((ProductInfo)localObject3).isSupportMainMsgType(4)))
      {
        this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(0);
        ((LinearLayout.LayoutParams)localObject1).leftMargin = 0;
        this.jdField_a_of_type_AndroidWidgetEditText.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      this.cf = ((DeviceInfo)localObject2).productId;
    }
    for (;;)
    {
      boolean bool = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null, "devicemsg_showsupporttips_first", true);
      if ((localObject3 != null) && (bool)) {
        if ((((ProductInfo)localObject3).supportMainMsgType & 0x7) != 0) {
          break label300;
        }
      }
      for (localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131369912);; localObject1 = (String)localObject1 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131369914))
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject1, MessageCache.a(), true, false, true);
          SettingCloneUtil.writeValue(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null, "devicemsg_showsupporttips_first", false);
        }
        if (QLog.isColorLevel())
        {
          if (localObject3 == null) {
            break;
          }
          QLog.d(this.L, 2, "support msg type maintype" + ((ProductInfo)localObject3).supportMainMsgType + ", FuncMsgType:" + ((ProductInfo)localObject3).supportFuncMsgType);
        }
        return;
        label300:
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131369913);
        localObject1 = localObject2;
        if (((ProductInfo)localObject3).isSupportMainMsgType(1)) {
          localObject1 = (String)localObject2 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131369907) + "、";
        }
        localObject2 = localObject1;
        if (((ProductInfo)localObject3).isSupportMainMsgType(2)) {
          localObject2 = (String)localObject1 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131369908) + "、";
        }
        localObject1 = localObject2;
        if (((ProductInfo)localObject3).isSupportFuncMsgType(1)) {
          localObject1 = (String)localObject2 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131369909) + "、";
        }
        localObject2 = localObject1;
        if (((ProductInfo)localObject3).isSupportFuncMsgType(2)) {
          localObject2 = (String)localObject1 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131369910) + "、";
        }
        localObject1 = localObject2;
        if (((String)localObject2).endsWith("、")) {
          localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
        }
      }
      QLog.d(this.L, 2, "product is null");
      return;
      localObject3 = null;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    Object localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53);
    DeviceInfo localDeviceInfo = ((SmartDeviceProxyMgr)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (localDeviceInfo != null)
    {
      localObject = ((SmartDeviceProxyMgr)localObject).a(localDeviceInfo.productId);
      if ((localObject == null) || (!((ProductInfo)localObject).isSupportMainMsgType(1))) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131369917), MessageCache.a(), true, false, true);
        SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Usr_AIO_SendMsg", 7, 0, 0);
      }
      SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Usr_AIO_SendMsg", 6, 0, 0);
      return;
    }
  }
  
  protected void c(Intent paramIntent)
  {
    super.c(paramIntent);
  }
  
  public void d(String paramString)
  {
    if (this.o) {
      super.d(paramString);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.handleMessage(paramMessage);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(20);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(20, 10000L);
      continue;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(20);
    }
  }
  
  protected void i(Intent paramIntent)
  {
    ae();
    super.i(paramIntent);
    if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) {
      k(paramIntent);
    }
  }
  
  void k(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra(AlbumConstants.i, -1);
    if ((80 == i) || (82 == i))
    {
      Object localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53);
      DeviceInfo localDeviceInfo = ((SmartDeviceProxyMgr)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      if (localDeviceInfo == null) {
        break label180;
      }
      localObject = ((SmartDeviceProxyMgr)localObject).a(localDeviceInfo.productId);
      if ((localObject == null) || (!((ProductInfo)localObject).isSupportFuncMsgType(1))) {
        break label180;
      }
    }
    label180:
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131369915), MessageCache.a(), true, false, true);
        SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Usr_AIO_SendMsg", 7, 0, 0);
        return;
      }
      paramIntent = paramIntent.getExtras().getStringArrayList("PhotoConst.PHOTO_PATHS");
      ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a().a(DeviceMsgHandle.b, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramIntent);
      return;
    }
  }
  
  public void m()
  {
    Object localObject = ((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (localObject != null) {}
    for (int i = ((DeviceInfo)localObject).productId;; i = 0)
    {
      SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Usr_AIO_Menu", 1, 0, i);
      localObject = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null);
      ((ActionSheet)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131369919), 5);
      ((ActionSheet)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131369920), 5);
      ((ActionSheet)localObject).e(2131365736);
      ((ActionSheet)localObject).a(new fzx(this, i, (ActionSheet)localObject));
      ((ActionSheet)localObject).show();
      return;
    }
  }
  
  protected void o()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838415);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getText(2131363663));
    }
  }
  
  protected void u()
  {
    super.u();
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie
 * JD-Core Version:    0.7.0.1
 */