package com.tencent.mobileqq.activity.aio.item;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewerParamParser;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.structmsg.TestStructMsg;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qqfav.QfavBuilder;
import ftm;
import ftn;
import ftp;
import ftq;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileItemBuilder
  extends BaseBubbleBuilder
  implements FileTransferManager.Callback
{
  private static final String b = FileItemBuilder.class.getSimpleName();
  public Handler a;
  public FileManagerEntity a;
  
  public FileItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
  }
  
  private int a(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong4, paramString1, paramInt, -1L);
    if (i != -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("chaosli", 2, "getFileTransStatus processor.getFileStatus() " + i);
      }
      return i;
    }
    paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong4, paramString1, paramInt);
    if (paramString2 != null) {
      return paramString2.status;
    }
    paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    paramString1 = (TransFileInfo)paramString2.a(TransFileInfo.class, new String[] { String.valueOf(paramLong3), String.valueOf(paramLong2), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString1 });
    paramString2.a();
    if (paramString1 == null) {
      return 0;
    }
    paramString1.status = FileManagerUtil.c(paramString1.status);
    if (paramString1.status == 2) {
      paramString1.status = 0;
    }
    return paramString1.status;
  }
  
  private long a(long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    paramString2 = (TransFileInfo)paramString1.a(TransFileInfo.class, new String[] { String.valueOf(paramLong2), String.valueOf(paramLong1), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString2 });
    paramString1.a();
    if (paramString2 != null) {
      return paramString2.transferedSize;
    }
    return 0L;
  }
  
  @SuppressLint({"ResourceAsColor"})
  @TargetApi(11)
  private RelativeLayout a(ftq paramftq)
  {
    int i = AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int j = AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int k = AIOUtils.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setId(2131296322);
    Object localObject2 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject2).setId(2131296360);
    ((RelativeLayout)localObject2).setBackgroundResource(2130839639);
    ((RelativeLayout)localObject2).setPadding(AIOUtils.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), i, i, AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    paramftq.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject2);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(10, 2131296322);
    localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject1).setId(2131296361);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, k);
    localLayoutParams.addRule(10, 2131296360);
    ((RelativeLayout)localObject2).addView((View)localObject1, localLayoutParams);
    localObject2 = new AsyncImageView(this.jdField_a_of_type_AndroidContentContext, k, k);
    ((AsyncImageView)localObject2).setId(2131296362);
    ((AsyncImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
    localLayoutParams = new RelativeLayout.LayoutParams(k, k);
    localLayoutParams.addRule(9, 2131296361);
    localLayoutParams.addRule(15, 2131296361);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramftq.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)localObject2);
    localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject2).setId(2131297060);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
    localLayoutParams = new RelativeLayout.LayoutParams(j, j);
    localLayoutParams.addRule(9, 2131296361);
    localLayoutParams.addRule(15, 2131296361);
    localLayoutParams.setMargins(i, 0, 0, 0);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramftq.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131296364);
    ((TextView)localObject2).setGravity(16);
    ((TextView)localObject2).setIncludeFontPadding(false);
    ((TextView)localObject2).setMaxLines(2);
    ((TextView)localObject2).setTextSize(1, 14.0F);
    ((TextView)localObject2).setTextColor(2131427942);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(1, 2131296362);
    localLayoutParams.addRule(11, 2131296361);
    localLayoutParams.addRule(10, 2131296361);
    localLayoutParams.setMargins(i, 0, 0, 0);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramftq.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131296365);
    ((TextView)localObject2).setSingleLine();
    if (VersionUtils.e()) {
      ((TextView)localObject2).setAlpha(0.75F);
    }
    ((TextView)localObject2).setGravity(17);
    ((TextView)localObject2).setTextColor(Color.parseColor("#777777"));
    ((TextView)localObject2).setTextSize(1, 12.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(5, 2131296364);
    localLayoutParams.addRule(12, 2131296361);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramftq.b = ((TextView)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131296366);
    ((TextView)localObject2).setSingleLine();
    ((TextView)localObject2).setGravity(5);
    ((TextView)localObject2).setTextColor(Color.parseColor("#777777"));
    ((TextView)localObject2).setTextSize(1, 12.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11, 2131296361);
    localLayoutParams.addRule(12, 2131296361);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramftq.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localObject2);
    return localRelativeLayout;
  }
  
  private String a(long paramLong1, long paramLong2, String paramString)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    paramString = (TransFileInfo)localEntityManager.a(TransFileInfo.class, new String[] { String.valueOf(paramLong2), String.valueOf(paramLong1), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString });
    localEntityManager.a();
    if (paramString != null) {
      return paramString.fileName;
    }
    return "";
  }
  
  private String a(long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    int i;
    if ((paramString1 == null) && (paramString2 != null))
    {
      paramString2 = a(paramLong1, paramLong2, paramString2);
      if (paramString2 != null)
      {
        i = paramString2.lastIndexOf(".");
        if (i >= 0) {}
      }
    }
    do
    {
      return paramString2;
      return paramString2.substring(0, i);
      if (paramString1 == null) {
        return null;
      }
      i = paramString1.lastIndexOf(File.separator);
      paramString2 = paramString1;
    } while (i < 0);
    String str = "";
    paramString2 = str;
    if (i > 0)
    {
      paramString2 = str;
      if (i + 1 < paramString1.length()) {
        paramString2 = paramString1.substring(i + 1);
      }
    }
    return paramString2;
  }
  
  private String a(String paramString)
  {
    if (paramString == null) {
      localObject = null;
    }
    int i;
    do
    {
      return localObject;
      i = paramString.lastIndexOf(File.separator);
      localObject = paramString;
    } while (i < 0);
    String str = "";
    Object localObject = str;
    if (i > 0)
    {
      localObject = str;
      if (i + 1 < paramString.length()) {
        localObject = paramString.substring(i + 1);
      }
    }
    return localObject;
  }
  
  private void a(Intent paramIntent, String paramString, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt, false);
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return;
    }
    paramString = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)((Iterator)localObject).next();
      if ((localChatMessage.msgtype == -2005) || (localChatMessage.msgtype == -2014)) {
        paramString.add(String.valueOf(localChatMessage.uniseq));
      }
    }
    paramIntent.putStringArrayListExtra("Aio_Uinseq_ImageList", paramString);
  }
  
  private void a(MessageForFile paramMessageForFile)
  {
    if (paramMessageForFile.tempMsg == null) {
      return;
    }
    if (paramMessageForFile.tempMsg.length > 0) {
      paramMessageForFile.url = paramMessageForFile.tempMsg[0].substring(1);
    }
    paramMessageForFile.fileName = a(paramMessageForFile.url);
    paramMessageForFile.fileType = b(paramMessageForFile.url);
    if ((paramMessageForFile.tempMsg.length > 1) && (paramMessageForFile.tempMsg[1] != null) && (Long.valueOf(paramMessageForFile.tempMsg[1]).longValue() > 0L)) {
      paramMessageForFile.fileSize = Long.valueOf(paramMessageForFile.tempMsg[1]).longValue();
    }
    paramMessageForFile.fileSizeString = FileUtil.a(paramMessageForFile.fileSize);
  }
  
  private void a(ftq paramftq, MessageForFile paramMessageForFile, FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      paramftq.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    String str;
    do
    {
      return;
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131362402);
      switch (paramFileManagerEntity.status)
      {
      case 2: 
      case 14: 
      case 15: 
      default: 
        paramftq.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      case 0: 
      case 16: 
        paramftq.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        if (paramMessageForFile.isSend())
        {
          if ((paramFileManagerEntity.nOpType == 8) || (paramFileManagerEntity.nOpType == 1) || (paramFileManagerEntity.nOpType == 5))
          {
            paramftq.jdField_c_of_type_AndroidWidgetTextView.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362480));
            return;
          }
          paramftq.jdField_c_of_type_AndroidWidgetTextView.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362484));
          return;
        }
        paramftq.jdField_c_of_type_AndroidWidgetTextView.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362485));
        return;
      case -1: 
        paramftq.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        if (paramMessageForFile.isSend())
        {
          paramftq.jdField_c_of_type_AndroidWidgetTextView.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362480));
          return;
        }
        paramftq.jdField_c_of_type_AndroidWidgetTextView.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362481));
        return;
      case 1: 
        paramftq.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        if (paramMessageForFile.isSend())
        {
          paramftq.jdField_c_of_type_AndroidWidgetTextView.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362480));
          return;
        }
        if (paramFileManagerEntity.cloudType == 0)
        {
          paramftq.jdField_c_of_type_AndroidWidgetTextView.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362493));
          return;
        }
        paramftq.jdField_c_of_type_AndroidWidgetTextView.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362478));
        return;
      case 3: 
        paramftq.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        if (!paramMessageForFile.isSend()) {
          break label603;
        }
        if ((paramFileManagerEntity.nOpType == 8) || (paramFileManagerEntity.nOpType == 5))
        {
          paramftq.jdField_c_of_type_AndroidWidgetTextView.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362480));
          return;
        }
        break;
      }
    } while (3 != paramFileManagerEntity.cloudType);
    paramftq.jdField_c_of_type_AndroidWidgetTextView.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362479));
    return;
    label603:
    paramftq.jdField_c_of_type_AndroidWidgetTextView.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362479));
    return;
    paramftq.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    paramftq.jdField_c_of_type_AndroidWidgetTextView.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362481));
    return;
    paramftq.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    paramftq.jdField_c_of_type_AndroidWidgetTextView.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362481));
    return;
    paramftq.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    paramftq.jdField_c_of_type_AndroidWidgetTextView.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362482));
    return;
    paramftq.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    paramftq.jdField_c_of_type_AndroidWidgetTextView.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362481));
  }
  
  private void a(ftq paramftq, FileManagerEntity paramFileManagerEntity)
  {
    int j = 1;
    int i;
    if (paramFileManagerEntity != null)
    {
      i = j;
      switch (paramFileManagerEntity.status)
      {
      }
    }
    label245:
    do
    {
      for (i = 0;; i = j)
      {
        if (i == 0) {
          break label245;
        }
        if (paramftq.jdField_a_of_type_AndroidWidgetProgressBar == null)
        {
          ProgressBar localProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext, null, 16842872);
          localProgressBar.setId(2131296367);
          localProgressBar.setMax(100);
          localProgressBar.setMinimumHeight(AIOUtils.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localProgressBar.setProgressDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837572));
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, AIOUtils.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localLayoutParams.addRule(3, 2131296361);
          localLayoutParams.addRule(12, 2131296360);
          localLayoutParams.setMargins(0, AIOUtils.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
          paramftq.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localProgressBar, localLayoutParams);
          paramftq.jdField_a_of_type_AndroidWidgetProgressBar = localProgressBar;
        }
        paramftq.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(paramFileManagerEntity.fProgress * 100.0F));
        paramftq.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        return;
        if (9 != paramFileManagerEntity.nOpType) {
          break;
        }
      }
    } while (paramftq.jdField_a_of_type_AndroidWidgetProgressBar == null);
    paramftq.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  private String b(String paramString)
  {
    int i = paramString.lastIndexOf(File.separator);
    int j = paramString.lastIndexOf(".");
    String str2 = "";
    String str1 = str2;
    if (i > 0)
    {
      str1 = str2;
      if (j > 0)
      {
        str1 = str2;
        if (j > i)
        {
          str1 = str2;
          if (j + 1 < paramString.length()) {
            str1 = paramString.substring(j + 1);
          }
        }
      }
    }
    return str1;
  }
  
  private void b(MessageForFile paramMessageForFile)
  {
    long l2 = 0L;
    for (;;)
    {
      try
      {
        if ((paramMessageForFile.tempMsg == null) || (paramMessageForFile.tempMsg.length <= 0)) {
          continue;
        }
        localObject1 = paramMessageForFile.tempMsg[0].substring(1);
        paramMessageForFile.url = ((String)localObject1);
        if (paramMessageForFile.url.length() == 0)
        {
          paramMessageForFile.url = a(paramMessageForFile.msgseq, paramMessageForFile.time, paramMessageForFile.frienduin);
          if ((paramMessageForFile.tempMsg != null) && (paramMessageForFile.tempMsg.length > 1)) {
            paramMessageForFile.tempMsg[1] = String.valueOf(a(paramMessageForFile.msgseq, paramMessageForFile.time, "", paramMessageForFile.frienduin));
          }
        }
        paramMessageForFile.fileName = a(paramMessageForFile.msgseq, paramMessageForFile.time, paramMessageForFile.url, paramMessageForFile.frienduin);
        paramMessageForFile.fileType = b(paramMessageForFile.url);
        if ((paramMessageForFile.tempMsg == null) || (paramMessageForFile.tempMsg.length <= 1) || (paramMessageForFile.tempMsg[1] == null) || (Long.valueOf(paramMessageForFile.tempMsg[1]).longValue() <= 0L)) {
          continue;
        }
        paramMessageForFile.fileSize = Long.valueOf(paramMessageForFile.tempMsg[1]).longValue();
      }
      catch (Exception localException)
      {
        Object localObject1;
        QLog.e(b, 1, localException.toString());
        continue;
        long l1 = 0L;
        continue;
        if (paramMessageForFile.tempMsg == null) {
          continue;
        }
        if (paramMessageForFile.tempMsg.length <= 1) {
          continue;
        }
        l1 = Long.valueOf(paramMessageForFile.tempMsg[1]).longValue();
        paramMessageForFile.fileSize = l1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(b, 2, "--------->>bindView 2 filePath:" + paramMessageForFile.url + "fileMsgLength:" + paramMessageForFile.tempMsg.length + ", fileSize:" + paramMessageForFile.fileSize);
        continue;
        l1 = 0L;
        continue;
        Object localObject2 = null;
        continue;
      }
      paramMessageForFile.fileSizeString = FileUtil.a(paramMessageForFile.fileSize);
      if (paramMessageForFile.tempMsg != null)
      {
        if (paramMessageForFile.tempMsg.length <= 4) {
          continue;
        }
        localObject1 = paramMessageForFile.tempMsg[4];
        paramMessageForFile.urlAtServer = ((String)localObject1);
      }
      paramMessageForFile.status = a(paramMessageForFile.frienduin, paramMessageForFile.url, paramMessageForFile.isSendFromLocal(), paramMessageForFile.fileSize, paramMessageForFile.msgseq, paramMessageForFile.time, paramMessageForFile.uniseq, paramMessageForFile.istroop);
      return;
      localObject1 = "";
      continue;
      if (!paramMessageForFile.isSendFromLocal()) {
        continue;
      }
      localObject1 = new File(paramMessageForFile.url);
      if (!((File)localObject1).exists()) {
        continue;
      }
      l1 = ((File)localObject1).length();
      paramMessageForFile.fileSize = l1;
      if (QLog.isColorLevel()) {
        QLog.d(b, 2, "--------->>bindView 1 filePath:" + paramMessageForFile.url + ",fileExists:" + ((File)localObject1).exists() + ", fileSize:" + ((File)localObject1).length());
      }
      if ((paramMessageForFile.fileSize == 0L) && (paramMessageForFile.tempMsg != null))
      {
        l1 = l2;
        if (paramMessageForFile.tempMsg.length > 1) {
          l1 = Long.valueOf(paramMessageForFile.tempMsg[1]).longValue();
        }
        paramMessageForFile.fileSize = l1;
      }
    }
  }
  
  private boolean b(FileManagerEntity paramFileManagerEntity)
  {
    boolean bool = true;
    if (paramFileManagerEntity == null) {
      return false;
    }
    switch (paramFileManagerEntity.status)
    {
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 9: 
    case 12: 
    case 13: 
    case 15: 
    default: 
      bool = false;
    }
    for (;;)
    {
      return bool;
      if (paramFileManagerEntity.status != 0) {
        break;
      }
      continue;
      if (13 != paramFileManagerEntity.nOpType) {
        break;
      }
      continue;
      if (10 == paramFileManagerEntity.nOpType)
      {
        bool = false;
      }
      else
      {
        bool = false;
        continue;
        if (13 != paramFileManagerEntity.nOpType) {
          break;
        }
      }
    }
  }
  
  private void d(View paramView)
  {
    Object localObject2 = (MessageForFile)AIOUtils.a(paramView);
    if (QLog.isColorLevel()) {
      QLog.d(b, 2, "TransfileUtile.TYPE_FILE uniseq " + ((MessageForFile)localObject2).uniseq + " itemStatus" + ((MessageForFile)localObject2).status);
    }
    Object localObject1 = a((MessageForFile)localObject2);
    paramView = new FileManagerReporter.fileAssistantReportData();
    paramView.b = "file_viewer_in";
    paramView.jdField_a_of_type_Int = 9;
    paramView.c = FileUtil.a(((FileManagerEntity)localObject1).fileName);
    paramView.d = FileManagerUtil.a(((FileManagerEntity)localObject1).cloudType, ((FileManagerEntity)localObject1).peerType);
    FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramView);
    FileManagerReporter.a("0X8004AE3");
    if ((((FileManagerEntity)localObject1).TroopUin != 0L) && (!TextUtils.isEmpty(((FileManagerEntity)localObject1).strTroopFileID)) && (!TextUtils.isEmpty(((FileManagerEntity)localObject1).strTroopFilePath)))
    {
      paramView = new ForwardFileInfo();
      paramView.b(((FileManagerEntity)localObject1).nSessionId);
      paramView.d(4);
      paramView.b(10006);
      paramView.a(((FileManagerEntity)localObject1).strFilePath);
      paramView.d(((FileManagerEntity)localObject1).fileName);
      paramView.d(((FileManagerEntity)localObject1).fileSize);
      paramView.a(((FileManagerEntity)localObject1).TroopUin);
      localObject1 = (Activity)this.jdField_a_of_type_AndroidContentContext;
      localObject2 = new Intent((Context)localObject1, TroopFileDetailBrowserActivity.class);
      ((Intent)localObject2).putExtra("fileinfo", paramView);
      ((Intent)localObject2).putExtra("removemementity", true);
      ((Intent)localObject2).putExtra("forward_from_troop_file", true);
      ((Intent)localObject2).putExtra("not_forward", true);
      ((Activity)localObject1).startActivityForResult((Intent)localObject2, 102);
      return;
    }
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.b(10004);
    if (((MessageForFile)localObject2).isSend()) {}
    for (paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();; paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)
    {
      localForwardFileInfo.d(((FileManagerEntity)localObject1).cloudType);
      localForwardFileInfo.a(Long.valueOf(paramView.replace("+", "")).longValue());
      localForwardFileInfo.c(((MessageForFile)localObject2).uniseq);
      localForwardFileInfo.b(((FileManagerEntity)localObject1).nSessionId);
      localForwardFileInfo.d(((MessageForFile)localObject2).fileName);
      localForwardFileInfo.d(((MessageForFile)localObject2).fileSize);
      localForwardFileInfo.b(((FileManagerEntity)localObject1).Uuid);
      localForwardFileInfo.a(((FileManagerEntity)localObject1).strFilePath);
      paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, FileBrowserActivity.class);
      paramView.putExtra("fileinfo", localForwardFileInfo);
      int i = FileManagerUtil.a(((FileManagerEntity)localObject1).fileName);
      if ((i == 0) || (i == 1)) {
        a(paramView, ((FileManagerEntity)localObject1).peerUin, ((MessageForFile)localObject2).istroop);
      }
      ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(paramView, 102);
      return;
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 2;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramChatMessage = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    ((ftq)paramChatMessage.getTag()).jdField_c_of_type_AndroidViewView.getLayoutParams().width = BaseChatItemLayout.f;
    return paramChatMessage;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    ftq localftq = (ftq)paramViewHolder;
    MessageForFile localMessageForFile = (MessageForFile)paramChatMessage;
    paramChatMessage = paramView;
    if (paramView == null) {
      paramChatMessage = a((ftq)paramViewHolder);
    }
    b(localMessageForFile);
    a(paramBaseChatItemLayout, localMessageForFile, localftq, localMessageForFile.status, false);
    paramChatMessage.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramChatMessage.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramChatMessage.setOnClickListener(this);
    localftq.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramChatMessage, this);
    return paramChatMessage;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new ftq(this);
  }
  
  public FileManagerEntity a(MessageForFile paramMessageForFile)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForFile.uniseq, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    FileManagerEntity localFileManagerEntity;
    label287:
    int i;
    if (localObject == null)
    {
      localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageForFile.uniseq, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d("FileManager", 2, "QueryFileEntityByuniseq return null, create new! sessionId[" + String.valueOf(localFileManagerEntity.nSessionId) + "], messageId[" + String.valueOf(localFileManagerEntity.uniseq) + "], peerUin[" + FileManagerUtil.e(localFileManagerEntity.peerUin) + "], peerType[" + String.valueOf(localFileManagerEntity.peerType) + "]");
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      TransFileInfo localTransFileInfo = (TransFileInfo)((EntityManager)localObject).a(TransFileInfo.class, new String[] { String.valueOf(paramMessageForFile.time), String.valueOf(paramMessageForFile.msgseq), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramMessageForFile.frienduin });
      ((EntityManager)localObject).a();
      localFileManagerEntity.status = FileManagerUtil.c(paramMessageForFile.status);
      if (paramMessageForFile.isSend())
      {
        localFileManagerEntity.cloudType = 3;
        localFileManagerEntity.strFilePath = paramMessageForFile.url;
        if (localTransFileInfo != null)
        {
          if (localTransFileInfo.uuid == null) {
            break label508;
          }
          localObject = new String(localTransFileInfo.uuid);
          localFileManagerEntity.Uuid = ((String)localObject);
        }
        localFileManagerEntity.fileName = paramMessageForFile.fileName;
        localFileManagerEntity.fileSize = paramMessageForFile.fileSize;
        if (!paramMessageForFile.isSend()) {
          break label515;
        }
        i = 0;
        label320:
        localFileManagerEntity.nOpType = i;
        localFileManagerEntity.peerUin = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        localFileManagerEntity.peerType = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
        localFileManagerEntity.peerNick = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramMessageForFile.frienduin), null, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        localFileManagerEntity.srvTime = (paramMessageForFile.time * 1000L);
        localFileManagerEntity.strServerPath = paramMessageForFile.urlAtServer;
        localFileManagerEntity.fProgress = ((float)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForFile.frienduin, paramMessageForFile.fileSize, paramMessageForFile.uniseq, paramMessageForFile.istroop) / 100.0F);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(localFileManagerEntity);
        localFileManagerEntity.bDelInFM = true;
        paramMessageForFile = localFileManagerEntity;
      }
    }
    label508:
    do
    {
      return paramMessageForFile;
      localFileManagerEntity.cloudType = 1;
      localFileManagerEntity.lastTime = (paramMessageForFile.time * 1000L + 604800000L);
      if (localFileManagerEntity.status != 1) {
        break;
      }
      localFileManagerEntity.cloudType = 3;
      localFileManagerEntity.strFilePath = paramMessageForFile.url;
      break;
      localObject = "";
      break label287;
      i = 1;
      break label320;
      paramMessageForFile = (MessageForFile)localObject;
    } while (!QLog.isColorLevel());
    label515:
    QLog.d("FileManager", 2, "QueryFileEntityByuniseq finded,FileEntity[" + FileManagerUtil.a((FileManagerEntity)localObject) + "]");
    return localObject;
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return "发送了文件";
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForFile localMessageForFile = (MessageForFile)paramChatMessage;
    Object localObject;
    switch (paramInt)
    {
    default: 
    case 2131302479: 
    case 2131302495: 
    case 2131302496: 
    case 2131302500: 
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
        return;
        ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        continue;
        localObject = a(localMessageForFile);
        switch (((FileManagerEntity)localObject).cloudType)
        {
        case 2: 
        case 4: 
        default: 
          break;
        case 1: 
          if (localMessageForFile.isSend())
          {
            paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
            FMToastUtil.b(FileManagerUtil.d(((FileManagerEntity)localObject).fileName) + paramContext.getString(2131362432));
            if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) {
              break label371;
            }
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((FileManagerEntity)localObject, paramChatMessage);
          }
          for (;;)
          {
            ((FileManagerEntity)localObject).nRelatedSessionId = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c((FileManagerEntity)localObject);
            if (QLog.isColorLevel()) {
              QLog.i("@-@", 1, "mEntity[" + String.valueOf(((FileManagerEntity)localObject).nSessionId) + "]'s relateId[" + String.valueOf(((FileManagerEntity)localObject).nRelatedSessionId) + "] No reInit,Show Juhua");
            }
            paramContext = new FileManagerReporter.fileAssistantReportData();
            paramContext.b = "file_to_weiyun";
            paramContext.jdField_a_of_type_Int = 9;
            paramContext.jdField_a_of_type_Long = ((FileManagerEntity)localObject).fileSize;
            paramContext.c = FileUtil.a(((FileManagerEntity)localObject).fileName);
            FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramContext);
            break;
            paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
            break label159;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
          }
        case 3: 
        case 5: 
          if (((FileManagerEntity)localObject).nRelatedSessionId > 0L) {}
          for (paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((FileManagerEntity)localObject).nRelatedSessionId);; paramChatMessage = null)
          {
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramChatMessage;
            if ((!FileManagerUtil.a()) || (localMessageForFile.fileSize <= 5242880L)) {
              break label471;
            }
            FMDialogUtil.a(paramContext, 2131362469, 2131362465, new ftm(this, localMessageForFile, paramContext, (FileManagerEntity)localObject));
            break;
          }
          FMToastUtil.b(FileManagerUtil.d(((FileManagerEntity)localObject).fileName) + paramContext.getString(2131362432));
          if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((FileManagerEntity)localObject).strFilePath, null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0, false);
          }
          for (;;)
          {
            ((FileManagerEntity)localObject).nRelatedSessionId = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c((FileManagerEntity)localObject);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("@-@", 1, "mEntity[" + String.valueOf(((FileManagerEntity)localObject).nSessionId) + "]'s relateId[" + String.valueOf(((FileManagerEntity)localObject).nRelatedSessionId) + "] reInit");
            break;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
          }
          paramContext = a(localMessageForFile);
          paramChatMessage = new FileManagerReporter.fileAssistantReportData();
          paramChatMessage.b = "file_forward";
          paramChatMessage.jdField_a_of_type_Int = 9;
          paramChatMessage.jdField_a_of_type_Long = paramContext.fileSize;
          paramChatMessage.c = FileUtil.a(paramContext.fileName);
          paramChatMessage.d = FileManagerUtil.a(paramContext.cloudType, paramContext.peerType);
          FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramChatMessage);
          paramChatMessage = new Bundle();
          paramChatMessage.putInt("forward_type", 0);
          paramChatMessage.putBoolean("not_forward", true);
          paramChatMessage.putParcelable("fileinfo", ForwardOperations.a(paramContext));
          localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
          ((Intent)localObject).putExtras(paramChatMessage);
          ((Intent)localObject).putExtra("forward_text", "已选择" + FileManagerUtil.d(paramContext.fileName) + "。");
          ((Intent)localObject).putExtra("display_like_dialog", true);
          ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject, 21);
          continue;
          paramContext = a(localMessageForFile);
          paramChatMessage = new Intent(this.jdField_a_of_type_AndroidContentContext, LiteActivity.class);
          localObject = new Bundle();
          ((Bundle)localObject).putInt("forward_type", 0);
          ((Bundle)localObject).putBoolean("not_forward", true);
          ((Bundle)localObject).putInt("dataline_forward_type", 100);
          ((Bundle)localObject).putString("dataline_forward_path", paramContext.strFilePath);
          ((Bundle)localObject).putParcelable("fileinfo", ForwardOperations.a(paramContext));
          paramChatMessage.putExtras((Bundle)localObject);
          this.jdField_a_of_type_AndroidContentContext.startActivity(paramChatMessage);
        }
      }
    case 2131302501: 
      label159:
      label371:
      paramContext = a(localMessageForFile);
      label471:
      if (3000 != paramContext.peerType) {
        break;
      }
    }
    for (paramInt = 3;; paramInt = 1)
    {
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(SplashActivity.sTopActivity, paramContext.strFilePath, paramInt);
        break;
        paramContext = a(localMessageForFile);
        new QfavBuilder(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, paramContext, paramChatMessage);
        break;
        try
        {
          paramContext = TestStructMsg.a(TestStructMsg.a(a(localMessageForFile).strFilePath));
          localObject = new SessionInfo();
          ((SessionInfo)localObject).jdField_a_of_type_JavaLangString = paramChatMessage.frienduin;
          ((SessionInfo)localObject).jdField_a_of_type_Int = paramChatMessage.istroop;
          ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (SessionInfo)localObject, paramContext);
        }
        catch (Exception paramContext)
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, "请先下载。。。。。。", 1).a();
        }
      }
      break;
    }
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    ftq localftq = (ftq)AIOUtils.a(paramView);
    MessageForFile localMessageForFile = (MessageForFile)localftq.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    BaseChatItemLayout localBaseChatItemLayout = localftq.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
    paramView = a(localMessageForFile);
    if (paramView.cloudType == 5)
    {
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView);
      return;
    }
    this.jdField_a_of_type_AndroidContentContext.getString(2131366317);
    this.jdField_a_of_type_AndroidContentContext.getString(2131366318);
    String str;
    switch (paramView.nOpType)
    {
    case 6: 
    case 7: 
    default: 
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131362369);
    }
    for (paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131362367); localMessageForFile.isSendFromLocal(); paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131362368))
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
      localActionSheet.c(str);
      localActionSheet.d(this.jdField_a_of_type_AndroidContentContext.getString(2131365736));
      localActionSheet.a(paramView);
      localActionSheet.a(new ftn(this, localMessageForFile, localBaseChatItemLayout, localftq, localActionSheet));
      localActionSheet.show();
      return;
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131362370);
    }
    paramView = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
    paramView.c(this.jdField_a_of_type_AndroidContentContext.getString(2131362370));
    paramView.d(this.jdField_a_of_type_AndroidContentContext.getString(2131365736));
    paramView.a(this.jdField_a_of_type_AndroidContentContext.getString(2131362368));
    paramView.a(new ftp(this, localMessageForFile, localBaseChatItemLayout, localftq, paramView));
    paramView.show();
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    paramView = (ftq)AIOUtils.a(paramView);
    MessageForFile localMessageForFile = (MessageForFile)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    BaseChatItemLayout localBaseChatItemLayout = paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
    if (localMessageForFile.uniseq != paramFileMsg.c) {
      return;
    }
    if (paramInt1 == 5000)
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131366406, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492923));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(b, 2, "transferListener FileMsg.TRANSFILE_TYPE_FILE uniseq " + localMessageForFile.uniseq + " itemStatus " + localMessageForFile.status);
    }
    a(localBaseChatItemLayout, localMessageForFile, paramView, paramInt1, false);
  }
  
  public void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForFile paramMessageForFile, ftq paramftq, int paramInt, boolean paramBoolean)
  {
    FileManagerEntity localFileManagerEntity = a(paramMessageForFile);
    FileManagerUtil.b(localFileManagerEntity);
    paramMessageForFile.fileName = localFileManagerEntity.fileName;
    paramMessageForFile.fileSize = localFileManagerEntity.fileSize;
    paramMessageForFile.status = localFileManagerEntity.status;
    paramMessageForFile.urlAtServer = localFileManagerEntity.strServerPath;
    paramMessageForFile.url = localFileManagerEntity.strFilePath;
    paramMessageForFile.fileSizeString = FileUtil.a(localFileManagerEntity.fileSize);
    if ((localFileManagerEntity.cloudType == 3) || (localFileManagerEntity.cloudType == 5))
    {
      paramftq.jdField_a_of_type_AndroidWidgetTextView.setText(FileManagerUtil.d(localFileManagerEntity.fileName));
      if ((localFileManagerEntity == null) || (15 != localFileManagerEntity.status) || (9 != localFileManagerEntity.nOpType)) {
        break label172;
      }
      paramftq.b.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131362453));
    }
    for (;;)
    {
      if (5 != localFileManagerEntity.cloudType) {
        break label189;
      }
      return;
      paramftq.jdField_a_of_type_AndroidWidgetTextView.setText(FileManagerUtil.d(localFileManagerEntity.strSrcName));
      break;
      label172:
      paramftq.b.setText(FileUtil.a(paramMessageForFile.fileSize));
    }
    label189:
    a(paramftq, localFileManagerEntity);
    a(paramftq, paramMessageForFile, localFileManagerEntity);
    paramBaseChatItemLayout.setFailedIconVisable(b(localFileManagerEntity), this);
    paramMessageForFile.status = paramInt;
    if (localFileManagerEntity == null)
    {
      FileManagerUtil.a(paramftq.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramMessageForFile.fileName);
      if ((localFileManagerEntity.nFileType != 1) || (!FileUtil.b(localFileManagerEntity.strFilePath))) {
        break label324;
      }
      if ((!FileViewMusicService.a().b(localFileManagerEntity.strFilePath)) || (!FileViewMusicService.a().a())) {
        break label311;
      }
      paramftq.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130839661);
    }
    for (;;)
    {
      paramftq.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
      FileManagerUtil.a(paramftq.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity);
      break;
      label311:
      paramftq.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130839660);
    }
    label324:
    paramftq.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramFileManagerEntity != null) {
      if (paramFileManagerEntity.nOpType != 24)
      {
        bool1 = bool2;
        if (paramFileManagerEntity.nOpType != 25) {}
      }
      else if (paramFileManagerEntity.status != 2)
      {
        bool1 = bool2;
        if (paramFileManagerEntity.status != 0) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = a((MessageForFile)AIOUtils.a(paramView));
    if (paramView.cloudType == 5) {
      return a(paramView);
    }
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    if ((paramView.cloudType != 0) && (!a(paramView)))
    {
      localQQCustomMenu.a(2131302496, this.jdField_a_of_type_AndroidContentContext.getString(2131362381));
      localQQCustomMenu.a(2131298924, this.jdField_a_of_type_AndroidContentContext.getString(2131362383));
    }
    if (DataLineHandler.a(paramView)) {
      localQQCustomMenu.a(2131302500, this.jdField_a_of_type_AndroidContentContext.getString(2131362126));
    }
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    return localQQCustomMenu.a();
  }
  
  QQCustomMenuItem[] a(FileManagerEntity paramFileManagerEntity)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    if ((!paramFileManagerEntity.bSend) && (paramFileManagerEntity.status != 1))
    {
      ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      return localQQCustomMenu.a();
    }
    localQQCustomMenu.a(2131302496, this.jdField_a_of_type_AndroidContentContext.getString(2131362381));
    localQQCustomMenu.a(2131302500, this.jdField_a_of_type_AndroidContentContext.getString(2131362126));
    if (paramFileManagerEntity.cloudType != 2)
    {
      paramFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity.nRelatedSessionId);
      if ((paramFileManagerEntity == null) || (paramFileManagerEntity.status != 1)) {
        localQQCustomMenu.a(2131302495, this.jdField_a_of_type_AndroidContentContext.getString(2131362385));
      }
    }
    localQQCustomMenu.a(2131302501, this.jdField_a_of_type_AndroidContentContext.getString(2131364975));
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    return localQQCustomMenu.a();
  }
  
  public void onClick(View paramView)
  {
    AIOUtils.h = true;
    if (super.a()) {}
    do
    {
      do
      {
        return;
        super.onClick(paramView);
        switch (paramView.getId())
        {
        case 2131296314: 
        default: 
          return;
        case 2131296322: 
          d(paramView);
          return;
        }
        paramView = a((MessageForFile)AIOUtils.a(paramView));
      } while (paramView == null);
      if (FileViewMusicService.a().b(paramView.strFilePath))
      {
        FileManagerReporter.a("0X8004BDF");
        FileViewMusicService.a().a();
        FileViewMusicService.a().c();
        return;
      }
      FileManagerReporter.a("0X8004BDE");
      FileViewMusicService.a().a(paramView.strFilePath);
      FileViewMusicService.a().b();
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramView.peerUin, paramView.peerType, false);
    } while ((localObject == null) || (((List)localObject).size() == 0));
    ArrayList localArrayList = new ArrayList();
    Object localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)((Iterator)localObject).next();
      if (localChatMessage.msgtype == -2005) {
        localArrayList.add(String.valueOf(localChatMessage.uniseq));
      }
    }
    localObject = new ArrayList();
    int i = FileViewerParamParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, paramView, (ArrayList)localObject);
    FileViewMusicService.a().a((List)localObject, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FileItemBuilder
 * JD-Core Version:    0.7.0.1
 */