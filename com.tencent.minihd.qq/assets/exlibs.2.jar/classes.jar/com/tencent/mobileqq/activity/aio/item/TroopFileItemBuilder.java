package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.RollangleImageView;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qqfav.QfavBuilder;
import cooperation.troop.TroopProxyActivity;
import fxm;
import fxn;
import fxo;
import fxp;
import java.util.UUID;

public class TroopFileItemBuilder
  extends BaseBubbleBuilder
{
  public static final String b;
  public Handler a;
  public View.OnClickListener a;
  
  static
  {
    jdField_b_of_type_JavaLangString = TroopFileItemBuilder.class.getSimpleName();
  }
  
  public TroopFileItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new fxm(this);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 2;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramViewGroup = (ViewGroup)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    paramOnLongClickAndTouchListener = (fxp)paramViewGroup.getTag();
    if (paramOnLongClickAndTouchListener.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      paramOnLongClickAndTouchListener.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      paramOnLongClickAndTouchListener.jdField_a_of_type_AndroidWidgetLinearLayout.setId(2131296325);
      paramView = new RelativeLayout.LayoutParams(-2, -2);
      if (!paramChatMessage.isSend()) {
        break label331;
      }
      paramView.addRule(0, 2131296315);
      paramView.addRule(1, 0);
    }
    for (;;)
    {
      paramView.addRule(5, 2131296322);
      paramView.addRule(3, 2131296322);
      paramView.topMargin = AIOUtils.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramView.leftMargin = AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramViewGroup.addView(paramOnLongClickAndTouchListener.jdField_a_of_type_AndroidWidgetLinearLayout, paramView);
      paramView = null;
      if (paramOnLongClickAndTouchListener.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() > 0) {
        paramView = paramOnLongClickAndTouchListener.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0);
      }
      paramView = a(this.jdField_a_of_type_AndroidContentContext, paramView);
      paramOnLongClickAndTouchListener.d = ((TextView)paramView.findViewById(2131302328));
      paramOnLongClickAndTouchListener.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302327));
      paramOnLongClickAndTouchListener.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.setMargins(AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
      paramOnLongClickAndTouchListener.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView, localLayoutParams);
      a(paramOnLongClickAndTouchListener.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, paramChatMessage, paramOnLongClickAndTouchListener);
      paramOnLongClickAndTouchListener.jdField_c_of_type_AndroidViewView.getLayoutParams().width = BaseChatItemLayout.f;
      return paramViewGroup;
      paramViewGroup.removeView(paramOnLongClickAndTouchListener.jdField_a_of_type_AndroidWidgetLinearLayout);
      break;
      label331:
      paramView.addRule(1, 2131296315);
      paramView.addRule(0, 0);
    }
  }
  
  public View a(Context paramContext, View paramView)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(paramContext).inflate(2130904488, null);
    }
    localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    return localView;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramViewHolder = (fxp)paramViewHolder;
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903141, null);
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131296364));
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131296365));
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131296366));
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramChatMessage.findViewById(2131296362));
      paramViewHolder.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramChatMessage.findViewById(2131296367));
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramChatMessage.findViewById(2131297060));
    }
    paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramChatMessage.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramChatMessage.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramChatMessage.setOnClickListener(this);
    return paramChatMessage;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new fxp(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return "发送了文件";
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    Object localObject2 = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(paramChatMessage.frienduin));
    if (localObject2 == null) {}
    Object localObject3;
    do
    {
      do
      {
        do
        {
          int i;
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          return;
                          localObject1 = (MessageForTroopFile)paramChatMessage;
                          localObject1 = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForTroopFile)localObject1);
                        } while (localObject1 == null);
                        i = NetworkUtil.a((Activity)paramContext);
                        localObject3 = new TroopFileItemOperation(Long.parseLong(paramChatMessage.frienduin), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)paramContext);
                        switch (paramInt)
                        {
                        default: 
                          return;
                        case 2131302500: 
                          paramContext = new Intent(this.jdField_a_of_type_AndroidContentContext, LiteActivity.class);
                          paramContext.putExtra("dataline_forward_type", 100);
                          paramContext.putExtra("dataline_forward_path", ((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaLangString);
                          this.jdField_a_of_type_AndroidContentContext.startActivity(paramContext);
                          return;
                        case 2131302502: 
                          if (i == 0)
                          {
                            TroopFileError.a(paramContext, this.jdField_a_of_type_AndroidContentContext.getString(2131363364));
                            return;
                          }
                          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down_pause_download", 0, 0, "", paramChatMessage.frienduin, "", "");
                        }
                      } while (((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 8);
                      ((TroopFileTransferManager)localObject2).g(((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID);
                      return;
                      if (i == 0)
                      {
                        TroopFileError.a(paramContext, this.jdField_a_of_type_AndroidContentContext.getString(2131363364));
                        return;
                      }
                      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Up_pause_upload", 0, 0, "", paramChatMessage.frienduin, "", "");
                    } while ((((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 0) && (((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 1));
                    ((TroopFileTransferManager)localObject2).d(((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID);
                    return;
                  } while (((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 9);
                  ((TroopFileItemOperation)localObject3).b(((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID);
                  return;
                } while (((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 2);
                ((TroopFileItemOperation)localObject3).a(((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID);
                return;
              } while ((((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 8) && (((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 9) && (((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 10));
              ((TroopFileTransferManager)localObject2).g(((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID);
              a(((TroopFileStatusInfo)localObject1).jdField_a_of_type_Long, (Activity)paramContext, ((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID);
              return;
              if (i == 0)
              {
                TroopFileError.a(paramContext, this.jdField_a_of_type_AndroidContentContext.getString(2131363364));
                return;
              }
            } while ((((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 1) && (((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 0) && (((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 2) && (((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 3));
            ((TroopFileTransferManager)localObject2).d(((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID);
            a(((TroopFileStatusInfo)localObject1).jdField_a_of_type_Long, (Activity)paramContext, ((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID, paramChatMessage);
            return;
            if (i == 0)
            {
              TroopFileError.a(paramContext, this.jdField_a_of_type_AndroidContentContext.getString(2131363364));
              return;
            }
            paramContext = new Bundle();
            paramContext.putInt("forward_type", 0);
            localObject2 = FileManagerUtil.a((TroopFileStatusInfo)localObject1);
            ((FileManagerEntity)localObject2).status = 2;
            localObject3 = new ForwardFileInfo();
            ((ForwardFileInfo)localObject3).b(((FileManagerEntity)localObject2).nSessionId);
            ((ForwardFileInfo)localObject3).b(10006);
            if (!TextUtils.isEmpty(((FileManagerEntity)localObject2).strFilePath)) {
              ((ForwardFileInfo)localObject3).a(((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaLangString);
            }
            ((ForwardFileInfo)localObject3).d(((TroopFileStatusInfo)localObject1).jdField_e_of_type_JavaLangString);
            ((ForwardFileInfo)localObject3).d(((TroopFileStatusInfo)localObject1).jdField_b_of_type_Long);
            ((ForwardFileInfo)localObject3).a(Long.parseLong(paramChatMessage.frienduin));
            if (((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID != null) {
              ((ForwardFileInfo)localObject3).e(((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID.toString());
            }
            ((ForwardFileInfo)localObject3).d(1);
            ((ForwardFileInfo)localObject3).a(1);
            paramContext.putParcelable("fileinfo", (Parcelable)localObject3);
            paramContext.putBoolean("not_forward", true);
            paramChatMessage = new Intent(this.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
            paramChatMessage.putExtras(paramContext);
            paramChatMessage.putExtra("forward_text", ((TroopFileStatusInfo)localObject1).jdField_e_of_type_JavaLangString);
            paramChatMessage.putExtra("forward_from_troop_file", true);
            ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(paramChatMessage, 21);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
            return;
          } while (((TroopFileStatusInfo)localObject1).d == null);
          if (i == 0)
          {
            TroopFileError.a(paramContext, this.jdField_a_of_type_AndroidContentContext.getString(2131363364));
            return;
          }
          FMToastUtil.b(FileManagerUtil.d(((TroopFileStatusInfo)localObject1).jdField_e_of_type_JavaLangString) + this.jdField_a_of_type_AndroidContentContext.getString(2131362432));
          ((TroopFileTransferManager)localObject2).a(((TroopFileStatusInfo)localObject1).d, ((TroopFileStatusInfo)localObject1).jdField_e_of_type_JavaLangString, ((TroopFileStatusInfo)localObject1).jdField_b_of_type_Long, ((TroopFileStatusInfo)localObject1).jdField_e_of_type_Int);
          return;
          FileManagerUtil.a((Activity)paramContext, ((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaLangString);
          return;
        } while (((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 3);
        ((TroopFileItemOperation)localObject3).a(((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID);
        return;
      } while (((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 10);
      ((TroopFileItemOperation)localObject3).b(((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID);
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down__start_download", 0, 0, "", paramChatMessage.frienduin, "", "");
    } while ((localObject1 != null) && (((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 7));
    ((TroopFileItemOperation)localObject3).a(((TroopFileStatusInfo)localObject1).d, ((TroopFileStatusInfo)localObject1).jdField_e_of_type_JavaLangString, ((TroopFileStatusInfo)localObject1).jdField_b_of_type_Long, ((TroopFileStatusInfo)localObject1).jdField_e_of_type_Int);
    return;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((Activity)this.jdField_a_of_type_AndroidContentContext, ((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaLangString, 2);
    return;
    paramContext = FileManagerUtil.a((TroopFileStatusInfo)localObject1);
    Object localObject1 = TroopFileManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((TroopFileStatusInfo)localObject1).jdField_a_of_type_Long).a(paramContext.strTroopFilePath);
    if (localObject1 != null)
    {
      paramContext.lastTime = ((TroopFileInfo)localObject1).d;
      paramContext.selfUin = String.valueOf(((TroopFileInfo)localObject1).jdField_b_of_type_Int);
    }
    new QfavBuilder(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, paramContext, paramChatMessage);
  }
  
  public void a(long paramLong, Activity paramActivity, UUID paramUUID)
  {
    paramUUID = new fxn(this, paramLong, paramUUID, paramActivity);
    DialogUtil.a(paramActivity, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131363348), this.jdField_a_of_type_AndroidContentContext.getString(2131363391), 2131363318, 2131363319, paramUUID, paramUUID).show();
  }
  
  public void a(long paramLong, Activity paramActivity, UUID paramUUID, ChatMessage paramChatMessage)
  {
    paramUUID = new fxo(this, paramLong, paramUUID, paramChatMessage, paramActivity);
    DialogUtil.a(paramActivity, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131363347), this.jdField_a_of_type_AndroidContentContext.getString(2131363392), 2131363316, 2131363317, paramUUID, paramUUID).show();
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    d(paramView);
  }
  
  public void a(BaseChatItemLayout paramBaseChatItemLayout, ChatMessage paramChatMessage, fxp paramfxp)
  {
    MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)paramChatMessage;
    localMessageForTroopFile.doParse();
    if (!localMessageForTroopFile.bReported)
    {
      localMessageForTroopFile.bReported = true;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down_appear_AIO", 0, 0, "", paramChatMessage.frienduin, "", "");
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 4, "Build TroopFileItem");
      }
    }
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForTroopFile);
    if (localTroopFileStatusInfo == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 4, "get fileStatusInfo fail ");
      }
      return;
    }
    paramfxp.jdField_a_of_type_AndroidWidgetTextView.setText(localTroopFileStatusInfo.jdField_e_of_type_JavaLangString);
    boolean bool2 = false;
    int m = 0;
    int n = 0;
    int i1 = 0;
    Object localObject = "";
    boolean bool1;
    int k;
    int j;
    int i;
    switch (localTroopFileStatusInfo.jdField_b_of_type_Int)
    {
    default: 
      bool1 = bool2;
      k = m;
      j = n;
      i = i1;
      if (!paramChatMessage.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))
      {
        m = 1;
        label248:
        if (k == 0) {
          break label924;
        }
        paramfxp.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(j);
        paramfxp.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        label270:
        if (i == 0) {
          break label936;
        }
        paramfxp.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        paramfxp.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        label292:
        paramfxp.jdField_b_of_type_AndroidWidgetTextView.setText(FileUtil.a(localTroopFileStatusInfo.jdField_b_of_type_Long));
        paramfxp.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramBaseChatItemLayout.setFailedIconVisable(bool1, this);
        paramBaseChatItemLayout = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(paramChatMessage.frienduin));
        if (localTroopFileStatusInfo.jdField_b_of_type_JavaLangString != null) {
          break label974;
        }
        FileManagerUtil.a(paramfxp.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localTroopFileStatusInfo.jdField_e_of_type_JavaLangString);
        if (localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID == null) {
          break label948;
        }
        paramBaseChatItemLayout.a(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID, 128);
      }
      break;
    }
    for (;;)
    {
      if (m == 0) {
        break label1050;
      }
      paramfxp.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (paramfxp.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() > 0) {
        paramfxp.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0).setVisibility(0);
      }
      paramfxp.d.setVisibility(0);
      paramfxp.d.setText("群文件");
      return;
      k = 1;
      j = 0;
      localObject = "上传中";
      i = 1;
      bool1 = bool2;
      break;
      String str = "未下载";
      localObject = str;
      i = i1;
      j = n;
      k = m;
      bool1 = bool2;
      if (localMessageForTroopFile.msgtype != -2017) {
        break;
      }
      if (localMessageForTroopFile.extraflag != 32772)
      {
        localObject = str;
        i = i1;
        j = n;
        k = m;
        bool1 = bool2;
        if (localMessageForTroopFile.extraflag != 32768) {
          break;
        }
      }
      localObject = str;
      i = i1;
      j = n;
      k = m;
      bool1 = bool2;
      if (!localMessageForTroopFile.isSendFromLocal()) {
        break;
      }
      localObject = str;
      i = i1;
      j = n;
      k = m;
      bool1 = bool2;
      if (!TextUtils.isEmpty(localMessageForTroopFile.FromUin)) {
        break;
      }
      b(paramChatMessage);
      localObject = str;
      i = i1;
      j = n;
      k = m;
      bool1 = bool2;
      break;
      localObject = "未下载";
      b(paramChatMessage);
      i = i1;
      j = n;
      k = m;
      bool1 = bool2;
      break;
      localObject = "上传中";
      i = 1;
      k = 1;
      j = TroopFileUtils.a(localTroopFileStatusInfo.c, localTroopFileStatusInfo.jdField_b_of_type_Long);
      bool1 = bool2;
      break;
      localObject = "下载中";
      k = 1;
      j = TroopFileUtils.a(localTroopFileStatusInfo.c, localTroopFileStatusInfo.jdField_b_of_type_Long);
      i = i1;
      bool1 = bool2;
      break;
      i = 1;
      localObject = "已暂停";
      k = 1;
      j = TroopFileUtils.a(localTroopFileStatusInfo.c, localTroopFileStatusInfo.jdField_b_of_type_Long);
      bool1 = bool2;
      break;
      i = 1;
      localObject = "已暂停";
      k = 1;
      j = TroopFileUtils.a(localTroopFileStatusInfo.c, localTroopFileStatusInfo.jdField_b_of_type_Long);
      bool1 = bool2;
      break;
      localObject = "已上传";
      i = 1;
      j = n;
      k = m;
      bool1 = bool2;
      break;
      localObject = "已下载";
      i = 1;
      j = n;
      k = m;
      bool1 = bool2;
      break;
      localObject = "失败";
      bool1 = true;
      i = i1;
      j = n;
      k = m;
      break;
      localObject = "失败";
      bool1 = true;
      i = i1;
      j = n;
      k = m;
      break;
      localObject = "已取消";
      bool1 = true;
      i = i1;
      j = n;
      k = m;
      break;
      localObject = "转发中";
      i = 1;
      j = n;
      k = m;
      bool1 = bool2;
      break;
      m = 0;
      break label248;
      label924:
      paramfxp.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      break label270;
      label936:
      paramfxp.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      break label292;
      label948:
      paramBaseChatItemLayout.a(localTroopFileStatusInfo.d, localTroopFileStatusInfo.jdField_e_of_type_JavaLangString, localTroopFileStatusInfo.jdField_e_of_type_Int, 128);
      continue;
      label974:
      if ((TextUtils.isEmpty(localTroopFileStatusInfo.jdField_b_of_type_JavaLangString)) || (!FileUtils.a(localTroopFileStatusInfo.jdField_b_of_type_JavaLangString)))
      {
        FileManagerUtil.a(paramfxp.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localTroopFileStatusInfo.jdField_e_of_type_JavaLangString);
      }
      else
      {
        paramBaseChatItemLayout = RollangleImageView.a(localTroopFileStatusInfo.jdField_b_of_type_JavaLangString);
        if (paramBaseChatItemLayout != null) {
          paramfxp.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageBitmap(paramBaseChatItemLayout);
        } else {
          FileManagerUtil.a(paramfxp.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localTroopFileStatusInfo.jdField_e_of_type_JavaLangString);
        }
      }
    }
    label1050:
    paramfxp.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    paramView = (MessageForTroopFile)localChatMessage;
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
    if (localTroopFileStatusInfo == null)
    {
      localQQCustomMenu.a(2131302513, this.jdField_a_of_type_AndroidContentContext.getString(2131363341));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down_press_files", 0, 0, "", localChatMessage.frienduin, "", "");
      return localQQCustomMenu.a();
    }
    Boolean localBoolean = Boolean.valueOf(false);
    paramView = localBoolean;
    switch (localTroopFileStatusInfo.jdField_b_of_type_Int)
    {
    default: 
      paramView = localBoolean;
    case 4: 
    case 5: 
    case 12: 
      if (paramView.booleanValue()) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Up_press_files", 0, 0, "", localChatMessage.frienduin, "", "");
      }
      break;
    }
    for (;;)
    {
      return localQQCustomMenu.a();
      localQQCustomMenu.a(2131302503, this.jdField_a_of_type_AndroidContentContext.getString(2131363332));
      paramView = Boolean.valueOf(true);
      break;
      localQQCustomMenu.a(2131302505, this.jdField_a_of_type_AndroidContentContext.getString(2131363333));
      localQQCustomMenu.a(2131302507, this.jdField_a_of_type_AndroidContentContext.getString(2131363335));
      paramView = Boolean.valueOf(true);
      break;
      localQQCustomMenu.a(2131302511, this.jdField_a_of_type_AndroidContentContext.getString(2131363339));
      localQQCustomMenu.a(2131302507, this.jdField_a_of_type_AndroidContentContext.getString(2131363335));
      paramView = Boolean.valueOf(true);
      break;
      localQQCustomMenu.a(2131302502, this.jdField_a_of_type_AndroidContentContext.getString(2131363332));
      localQQCustomMenu.a(2131302508, this.jdField_a_of_type_AndroidContentContext.getString(2131363336));
      localQQCustomMenu.a(2131302514, this.jdField_a_of_type_AndroidContentContext.getString(2131363342));
      localQQCustomMenu.a(2131302509, this.jdField_a_of_type_AndroidContentContext.getString(2131363337));
      paramView = localBoolean;
      break;
      localQQCustomMenu.a(2131302504, this.jdField_a_of_type_AndroidContentContext.getString(2131363333));
      localQQCustomMenu.a(2131302506, this.jdField_a_of_type_AndroidContentContext.getString(2131363334));
      localQQCustomMenu.a(2131302508, this.jdField_a_of_type_AndroidContentContext.getString(2131363336));
      localQQCustomMenu.a(2131302514, this.jdField_a_of_type_AndroidContentContext.getString(2131363342));
      localQQCustomMenu.a(2131302509, this.jdField_a_of_type_AndroidContentContext.getString(2131363337));
      paramView = localBoolean;
      break;
      localQQCustomMenu.a(2131302512, this.jdField_a_of_type_AndroidContentContext.getString(2131363340));
      localQQCustomMenu.a(2131302506, this.jdField_a_of_type_AndroidContentContext.getString(2131363334));
      paramView = localBoolean;
      break;
      localQQCustomMenu.a(2131302508, this.jdField_a_of_type_AndroidContentContext.getString(2131363336));
      localQQCustomMenu.a(2131302514, this.jdField_a_of_type_AndroidContentContext.getString(2131363342));
      localQQCustomMenu.a(2131302509, this.jdField_a_of_type_AndroidContentContext.getString(2131363337));
      localQQCustomMenu.a(2131302500, this.jdField_a_of_type_AndroidContentContext.getString(2131362126));
      localQQCustomMenu.a(2131302501, this.jdField_a_of_type_AndroidContentContext.getString(2131364975));
      paramView = Boolean.valueOf(true);
      break;
      if (!FileUtil.a(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString))
      {
        TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(localChatMessage.frienduin)).b();
        paramView = localBoolean;
        break;
      }
      if ((!TextUtils.isEmpty(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString)) && (FileUtils.e(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString))) {
        localQQCustomMenu.a(2131302510, this.jdField_a_of_type_AndroidContentContext.getString(2131363338));
      }
      localQQCustomMenu.a(2131302508, this.jdField_a_of_type_AndroidContentContext.getString(2131363336));
      localQQCustomMenu.a(2131302514, this.jdField_a_of_type_AndroidContentContext.getString(2131363342));
      localQQCustomMenu.a(2131302509, this.jdField_a_of_type_AndroidContentContext.getString(2131363337));
      localQQCustomMenu.a(2131302500, this.jdField_a_of_type_AndroidContentContext.getString(2131362126));
      localQQCustomMenu.a(2131302501, this.jdField_a_of_type_AndroidContentContext.getString(2131364975));
      paramView = localBoolean;
      break;
      localQQCustomMenu.a(2131302513, this.jdField_a_of_type_AndroidContentContext.getString(2131363341));
      localQQCustomMenu.a(2131302508, this.jdField_a_of_type_AndroidContentContext.getString(2131363336));
      localQQCustomMenu.a(2131302514, this.jdField_a_of_type_AndroidContentContext.getString(2131363342));
      localQQCustomMenu.a(2131302509, this.jdField_a_of_type_AndroidContentContext.getString(2131363337));
      paramView = localBoolean;
      break;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down_press_files", 0, 0, "", localChatMessage.frienduin, "", "");
    }
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.uniseq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
  }
  
  public void c(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.uniseq);
    if (paramChatMessage.isSendFromLocal()) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq));
    }
  }
  
  void d(View paramView)
  {
    Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
    Intent localIntent = new Intent();
    paramView = AIOUtils.a(paramView);
    MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)paramView;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, paramView.frienduin + "", "", "", "");
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForTroopFile);
    switch (localTroopFileStatusInfo.jdField_b_of_type_Int)
    {
    case 4: 
    case 5: 
    default: 
      return;
    case 0: 
    case 1: 
    case 2: 
    case 3: 
      localIntent.putExtra(TroopProxyActivity.f, paramView.frienduin);
      TroopProxyActivity.b(localActivity, localIntent);
      return;
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
      new TroopFileItemOperation(Long.valueOf(localMessageForTroopFile.frienduin).longValue(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localActivity).a(localTroopFileStatusInfo, localMessageForTroopFile.senderuin, localMessageForTroopFile.lastTime);
      return;
    }
    TroopFileError.a(localActivity, String.format(localActivity.getString(2131363383), new Object[] { TroopFileUtils.a(localTroopFileStatusInfo.jdField_e_of_type_JavaLangString) }));
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    d(paramView);
    AIOUtils.h = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopFileItemBuilder
 * JD-Core Version:    0.7.0.1
 */