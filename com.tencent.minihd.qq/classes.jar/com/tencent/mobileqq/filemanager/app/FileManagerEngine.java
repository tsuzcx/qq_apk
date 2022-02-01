package com.tencent.mobileqq.filemanager.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.core.DiscPicThumbDownloader;
import com.tencent.mobileqq.filemanager.core.DiscVideoThumbDownloader;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.core.OfflineVideoThumbDownLoader;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.core.ThumbHttpDownloader;
import com.tencent.mobileqq.filemanager.core.WeiYunLogicCenter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.IForwardCallBack;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;
import mqq.app.MobileQQ;

public class FileManagerEngine
{
  private static final String jdField_a_of_type_JavaLangString = "FileManagerEngine<FileAssistant>";
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  private DiscPicThumbDownloader jdField_a_of_type_ComTencentMobileqqFilemanagerCoreDiscPicThumbDownloader = null;
  private DiscVideoThumbDownloader jdField_a_of_type_ComTencentMobileqqFilemanagerCoreDiscVideoThumbDownloader = null;
  private OfflineVideoThumbDownLoader jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOfflineVideoThumbDownLoader = null;
  private ThumbHttpDownloader jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader = null;
  WeiYunLogicCenter jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter;
  
  public FileManagerEngine(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter == null) {
      a();
    }
    FileManagerUtil.a();
  }
  
  private void a(long paramLong, String paramString, int paramInt)
  {
    if (paramLong < 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "uniseq is wrong!can't retry!uniseq[" + String.valueOf(paramLong) + "]");
      }
      return;
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong, paramString, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramString);
  }
  
  private void b(long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
    if (localFileManagerEntity == null) {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "queryFileManagerEntity is fail!,check sessionID[" + String.valueOf(paramLong) + "]");
      }
    }
    do
    {
      do
      {
        return;
        switch (localFileManagerEntity.nOpType)
        {
        }
      } while (!QLog.isColorLevel());
      QLog.e("FileManagerEngine<FileAssistant>", 2, "unknow operation type!");
      return;
      if (localFileManagerEntity.cloudType == 0)
      {
        localFileManagerEntity.cloudType = 1;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity);
      return;
      a().a(localFileManagerEntity, localFileManagerEntity.peerType, true);
      return;
      a(localFileManagerEntity);
      return;
      c(localFileManagerEntity);
      return;
      a(localFileManagerEntity, localFileManagerEntity.nOpType);
      return;
      if (localFileManagerEntity.cloudType == 0)
      {
        if (localFileManagerEntity.bDelInFM == true)
        {
          localFileManagerEntity.bDelInFM = false;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localFileManagerEntity);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 3, null);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramLong);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("FileManagerEngine<FileAssistant>", 2, "err cloud type.when reTry :" + localFileManagerEntity.cloudType);
    return;
    TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.TroopUin).a(localFileManagerEntity.forwardTroopFileEntrance, localFileManagerEntity.TroopUin, localFileManagerEntity.busId, Long.valueOf(localFileManagerEntity.peerUin).longValue(), localFileManagerEntity.peerType, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, localFileManagerEntity.strTroopFilePath, true, paramLong, FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
  }
  
  private void c(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "FileManagerEntity is null!!!");
      }
      return;
    }
    FileManagerUtil.b(paramFileManagerEntity.nSessionId);
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      paramFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 34, new Object[] { Integer.valueOf(0), null, null, Long.valueOf(paramFileManagerEntity.nSessionId) });
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileOf2Wy", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, 9004L, "Error_No_Network", 0L, 0L, 0L, "", "", 0, "Error_No_Network", null);
      return;
    }
    paramFileManagerEntity.fProgress = 0.0F;
    paramFileManagerEntity.status = 2;
    paramFileManagerEntity.nOpType = 4;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(25, paramFileManagerEntity);
  }
  
  public ThumbHttpDownloader a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader = new ThumbHttpDownloader(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader;
  }
  
  public WeiYunLogicCenter a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter = new WeiYunLogicCenter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter;
  }
  
  public FileManagerEntity a(FileManagerEntity paramFileManagerEntity, String paramString)
  {
    paramString = a().a(paramFileManagerEntity, paramString);
    if (paramFileManagerEntity.peerType == 3000)
    {
      a(paramString, 20);
      return paramString;
    }
    c(paramString);
    return paramString;
  }
  
  public FileManagerEntity a(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "insertForwardOfflineEntity , FilemanagerEntity is null!");
      }
      FileManagerUtil.a();
      return null;
    }
    paramString1 = new FileManagerEntity();
    paramString1.copyFrom(paramFileManagerEntity);
    paramString1.nSessionId = FileManagerUtil.a().longValue();
    if ((paramString1.fileName == null) || (paramString1.fileName.length() == 0)) {
      paramString1.fileName = FileManagerUtil.a(paramString1.strFilePath);
    }
    if ((paramString1.strFilePath == null) || (paramString1.strFilePath.length() == 0)) {
      paramString1.strFilePath = paramString1.fileName;
    }
    paramString1.uniseq = MessageRecordFactory.a(-1000).uniseq;
    paramString1.nOpType = 7;
    paramString1.bSend = true;
    paramString1.isReaded = true;
    paramString1.peerType = paramInt;
    paramString1.peerUin = paramString2;
    paramString1.peerNick = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, null, paramInt);
    paramString1.selfUin = paramFileManagerEntity.peerUin;
    paramString1.srvTime = (MessageCache.a() * 1000L);
    paramString1.cloudType = 1;
    paramString1.status = 2;
    paramString1.msgSeq = FileManagerUtil.a();
    paramString1.msgUid = FileManagerUtil.b();
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerEngine<FileAssistant>", 2, "insertForwardOfflineEntity FilemanagerEntity:" + FileManagerUtil.a(paramString1));
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramString1);
    return paramString1;
  }
  
  public FileManagerEntity a(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "insertForwardOfflineEntity , FilemanagerEntity is null!");
      }
      FileManagerUtil.a();
      return null;
    }
    String str = TransfileUtile.a("", 0L, 0, true);
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.copyFrom(paramFileManagerEntity);
    localFileManagerEntity.nSessionId = FileManagerUtil.a().longValue();
    if ((localFileManagerEntity.fileName == null) || (localFileManagerEntity.fileName.length() == 0)) {
      localFileManagerEntity.fileName = FileManagerUtil.a(localFileManagerEntity.strFilePath);
    }
    if ((localFileManagerEntity.strFilePath == null) || (localFileManagerEntity.strFilePath.length() == 0)) {
      localFileManagerEntity.strFilePath = localFileManagerEntity.fileName;
    }
    long l = MessageRecordFactory.a(-1000).uniseq;
    localFileManagerEntity.uniseq = l;
    localFileManagerEntity.nOpType = 7;
    localFileManagerEntity.bSend = true;
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerType = paramInt;
    localFileManagerEntity.peerUin = paramString2;
    localFileManagerEntity.peerNick = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, null, paramInt);
    if ((paramFileManagerEntity.peerType == 3000) || (paramFileManagerEntity.peerType == 1))
    {
      localFileManagerEntity.selfUin = paramFileManagerEntity.peerUin;
      localFileManagerEntity.srvTime = (MessageCache.a() * 1000L);
      localFileManagerEntity.cloudType = 1;
      localFileManagerEntity.status = 2;
      localFileManagerEntity.msgSeq = FileManagerUtil.a();
      localFileManagerEntity.msgUid = FileManagerUtil.b();
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerEngine<FileAssistant>", 2, "insertForwardOfflineEntity FilemanagerEntity:" + FileManagerUtil.a(localFileManagerEntity));
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2, localFileManagerEntity);
      if (!paramBoolean) {
        break label456;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity.nSessionId);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2, paramString1, true, localFileManagerEntity.strFilePath, localFileManagerEntity.fileSize, true, paramInt, str, localFileManagerEntity.msgSeq, localFileManagerEntity.msgSeq, localFileManagerEntity.Uuid, 1, l, localFileManagerEntity.msgUid, -1L, MessageCache.a());
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerEngine<FileAssistant>", 2, "insertForwardOfflineEntity FilemanagerEntity:" + FileManagerUtil.a(localFileManagerEntity));
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2, localFileManagerEntity);
      return localFileManagerEntity;
      localFileManagerEntity.selfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      break;
      label456:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(localFileManagerEntity);
    }
  }
  
  public FileManagerEntity a(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "why FileManagerRSCenter is null???");
      }
      return null;
    }
    String str2 = TransfileUtile.a(paramString1, 0L, 0, true);
    String str1 = FileManagerUtil.a(paramString1);
    long l = -1L;
    int i;
    int j;
    label63:
    FileManagerEntity localFileManagerEntity;
    if (paramBoolean)
    {
      i = 0;
      if (!paramBoolean) {
        break label463;
      }
      j = 3;
      if (paramBoolean) {
        l = MessageRecordFactory.a(-1000).uniseq;
      }
      localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l, paramString3, paramInt);
      localFileManagerEntity.status = 2;
      localFileManagerEntity.nOpType = i;
      localFileManagerEntity.fileSize = FileManagerUtil.a(paramString1);
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerEngine<FileAssistant>", 2, "toOffline[" + String.valueOf(paramBoolean) + "], filepath[" + paramString1 + "]:size[" + String.valueOf(localFileManagerEntity.fileSize) + "]");
      }
      localFileManagerEntity.isReaded = true;
      localFileManagerEntity.peerUin = paramString3;
      localFileManagerEntity.peerNick = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString3, null, paramInt);
      localFileManagerEntity.strFilePath = paramString1;
      localFileManagerEntity.srvTime = (MessageCache.a() * 1000L);
      localFileManagerEntity.fileName = str1;
      localFileManagerEntity.nFileType = FileManagerUtil.a(paramString1);
      localFileManagerEntity.cloudType = 3;
      localFileManagerEntity.bSend = paramBoolean;
      localFileManagerEntity.msgSeq = FileManagerUtil.a();
      localFileManagerEntity.msgUid = FileManagerUtil.b();
      localFileManagerEntity.strThumbPath = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString1, 150, 150);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString3, localFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      if ((paramInt != 1004) && (paramInt != 1000)) {
        break label469;
      }
      str1 = paramString2;
    }
    for (;;)
    {
      if (localFileManagerEntity.nFileType == 5)
      {
        localFileManagerEntity.strApkPackageName = FileCategoryUtil.a(localFileManagerEntity.strFilePath, BaseApplicationImpl.getContext());
        localFileManagerEntity.fileName = FileCategoryUtil.a(localFileManagerEntity.strFilePath);
      }
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString3, str1, true, paramString1, 0L, true, paramInt, str2, localFileManagerEntity.msgSeq, localFileManagerEntity.msgSeq, null, j, l, localFileManagerEntity.msgUid, -1L, MessageCache.a());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
      return localFileManagerEntity;
      i = 6;
      break;
      label463:
      j = 2;
      break label63;
      label469:
      if (paramInt == 1006)
      {
        localFileManagerEntity.tmpSessionFromPhone = paramString2;
        localFileManagerEntity.tmpSessionToPhone = paramString3;
        str1 = paramString2;
      }
    }
  }
  
  public String a(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreDiscPicThumbDownloader == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreDiscPicThumbDownloader = new DiscPicThumbDownloader(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreDiscPicThumbDownloader.a(paramFileManagerEntity, paramInt);
  }
  
  public String a(String paramString, int paramInt, boolean paramBoolean, Object paramObject)
  {
    return a().a(paramString, paramInt, paramBoolean, paramObject);
  }
  
  public String a(String paramString1, String paramString2, int paramInt, Object paramObject)
  {
    return a().a(paramString1, paramString2, paramInt, paramObject);
  }
  
  public ArrayList a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerEngine<FileAssistant>", 2, "saveAllSelectFileToWeiYun");
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    Object localObject;
    while (i < FMDataCache.d().size())
    {
      localObject = (OfflineFileInfo)FMDataCache.d().get(i);
      localArrayList.add(a(FileManagerUtil.a((OfflineFileInfo)localObject, 0), String.valueOf(((OfflineFileInfo)localObject).jdField_a_of_type_Long)));
      i += 1;
    }
    i = 0;
    if (i < FMDataCache.c().size())
    {
      localObject = (FileManagerEntity)FMDataCache.c().get(i);
      FileCategoryUtil.a((FileManagerEntity)localObject);
      switch (((FileManagerEntity)localObject).cloudType)
      {
      case 2: 
      default: 
        localObject = null;
      }
      for (;;)
      {
        if (localObject != null) {
          localArrayList.add(localObject);
        }
        i += 1;
        break;
        localObject = a(((FileManagerEntity)localObject).strFilePath, "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0, false);
        continue;
        localObject = a((FileManagerEntity)localObject, String.valueOf(((FileManagerEntity)localObject).peerUin));
      }
    }
    i = 0;
    while (i < FMDataCache.b().size())
    {
      localObject = a(((FileInfo)FMDataCache.b().get(i)).d(), "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0, false);
      ((FileManagerEntity)localObject).strApkPackageName = ((FileInfo)FMDataCache.b().get(i)).c();
      localArrayList.add(localObject);
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    a().a(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(long paramLong)
  {
    b(paramLong);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong1, paramLong2, paramString, paramInt1, paramInt2);
  }
  
  public void a(long paramLong, String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((FileManagerEntity)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString, 1);
    localFileManagerEntity.fProgress = 0.0F;
    try
    {
      localFileManagerEntity.TroopUin = Long.parseLong(paramString);
      localFileManagerEntity.status = 2;
      if (((FileManagerEntity)localObject).peerType == 0)
      {
        localFileManagerEntity.nOpType = 26;
        if ((TextUtils.isEmpty(localFileManagerEntity.strTroopFileUuid)) || (localFileManagerEntity.mContext == null))
        {
          IForwardCallBack localIForwardCallBack = FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          localFileManagerEntity.strTroopFileUuid = localIForwardCallBack.a(localFileManagerEntity.peerUin, ((FileManagerEntity)localObject).peerType, paramString, ((FileManagerEntity)localObject).peerType, localFileManagerEntity.Uuid, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, localFileManagerEntity.nSessionId);
          localFileManagerEntity.mContext = localIForwardCallBack;
        }
        if ((localFileManagerEntity.busId != 102) && (localFileManagerEntity.busId != 104)) {
          localFileManagerEntity.busId = 102;
        }
        if (NetworkUtil.e(BaseApplication.getContext())) {
          break label350;
        }
        localObject = BaseApplicationImpl.getContext().getString(2131367136);
        localFileManagerEntity.status = 0;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 19, new Object[] { Integer.valueOf(9004), localObject, Long.valueOf(0L), Long.valueOf(0L), null, Long.valueOf(localFileManagerEntity.nSessionId) });
        if ((localFileManagerEntity.mContext instanceof IForwardCallBack)) {
          ((IForwardCallBack)localFileManagerEntity.mContext).a(false, localFileManagerEntity.strTroopFileUuid, paramLong, 9004, (String)localObject, paramString, "");
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("FileManagerEngine<FileAssistant>", 2, FileManagerUtil.a());
          continue;
          if (((FileManagerEntity)localObject).peerType == 3000) {
            localFileManagerEntity.nOpType = 27;
          }
        }
      }
      label350:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(102, localFileManagerEntity);
    }
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "FileManagerEntity is null!!!");
      }
      return;
    }
    FileManagerUtil.b(paramFileManagerEntity.nSessionId);
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      paramFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 19, new Object[] { Integer.valueOf(0), null, Long.valueOf(0L), Long.valueOf(0L), null, Long.valueOf(paramFileManagerEntity.nSessionId) });
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileOf2Of", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, 9004L, "Error_No_Network", 0L, 0L, 0L, "", "", 0, "Error_No_Network", null);
      return;
    }
    QLog.i("FileManagerEngine<FileAssistant>", 1, "ForwardOfflineFile, nId[" + paramFileManagerEntity.nSessionId + "], opYype[" + paramFileManagerEntity.nOpType + "]");
    ShieldMsgManger localShieldMsgManger = (ShieldMsgManger)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15);
    if ((localShieldMsgManger != null) && (localShieldMsgManger.a(paramFileManagerEntity.peerUin)))
    {
      FileManagerUtil.a("该好友已被屏蔽！请先解除屏蔽！");
      paramFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 19, new Object[] { Integer.valueOf(0), null, Long.valueOf(0L), Long.valueOf(0L), null, Long.valueOf(paramFileManagerEntity.nSessionId) });
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramFileManagerEntity);
      return;
    }
    paramFileManagerEntity.fProgress = 0.0F;
    paramFileManagerEntity.status = 2;
    if (paramFileManagerEntity.nOpType == 28)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(106, paramFileManagerEntity);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "FileManagerEntity is null!!!");
      }
      return;
    }
    paramFileManagerEntity.nOpType = paramInt;
    QLog.e("FileManagerEngine<FileAssistant>", 1, "ForwardDisc2X, nOperationType[" + paramInt + "]");
    FileManagerUtil.b(paramFileManagerEntity.nSessionId);
    if ((paramInt != 27) && (!NetworkUtil.e(BaseApplication.getContext())))
    {
      paramFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 34, new Object[] { Integer.valueOf(0), null, null, Long.valueOf(paramFileManagerEntity.nSessionId) });
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileDisc2Wy", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, 9004L, "Error_No_Network", 0L, 0L, 0L, "", "", 0, "Error_No_Network", null);
      return;
    }
    QLog.i("FileManagerEngine<FileAssistant>", 1, "ForwardDisc2X, nId[" + paramFileManagerEntity.nSessionId + "], type[" + paramInt + "]");
    paramFileManagerEntity.bSend = true;
    paramFileManagerEntity.fProgress = 0.0F;
    paramFileManagerEntity.status = 2;
    paramFileManagerEntity.nOpType = paramInt;
    int j = 0;
    int i = j;
    switch (paramInt)
    {
    default: 
      i = j;
    }
    while (paramFileManagerEntity.selfUin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))
    {
      QLog.e("FileManagerEngine<FileAssistant>", 1, "ForwardDisc2X, nId[" + paramFileManagerEntity.nSessionId + "], type[" + paramInt + "] error");
      if (QLog.isDevelopLevel())
      {
        QLog.e("FileManagerEngine<FileAssistant>", 1, "讨论组转发，selfUin不能为自己！！！");
        throw new NullPointerException("讨论组转发，selfUin不能为自己！！！");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity.nSessionId, paramFileManagerEntity.peerUin, paramFileManagerEntity.fileSize, paramFileManagerEntity.selfUin, paramFileManagerEntity.fileName, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5);
        return;
        i = 3;
        continue;
        i = 25;
        continue;
        Object localObject;
        if ((TextUtils.isEmpty(paramFileManagerEntity.strTroopFileUuid)) || (paramFileManagerEntity.mContext == null))
        {
          localObject = FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          paramFileManagerEntity.strTroopFileUuid = ((IForwardCallBack)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramFileManagerEntity.peerType, paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, paramFileManagerEntity.Uuid, paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize, paramFileManagerEntity.nSessionId);
          paramFileManagerEntity.mContext = localObject;
        }
        if ((paramFileManagerEntity.busId != 102) && (paramFileManagerEntity.busId != 104)) {
          paramFileManagerEntity.busId = 102;
        }
        j = paramFileManagerEntity.busId;
        i = j;
        if (!NetworkUtil.e(BaseApplication.getContext()))
        {
          i = j;
          if ((paramFileManagerEntity.mContext instanceof IForwardCallBack))
          {
            localObject = BaseApplicationImpl.getContext().getString(2131367136);
            ((IForwardCallBack)paramFileManagerEntity.mContext).a(false, paramFileManagerEntity.strTroopFileUuid, paramFileManagerEntity.nSessionId, 9004, (String)localObject, String.valueOf(paramFileManagerEntity.peerUin), "");
            return;
          }
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity, i);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt)
  {
    paramFileManagerEntity = a().a(paramFileManagerEntity, paramString1, paramString2, paramInt);
    FileManagerUtil.b(paramFileManagerEntity.nSessionId);
    FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2, paramFileManagerEntity);
    a().a(paramFileManagerEntity, paramInt, false);
  }
  
  public void a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    a().a(paramWeiYunFileInfo);
  }
  
  public void a(String paramString)
  {
    int i = 0;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Up_sent_files", 0, 0, "", paramString, "", "");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Succ_upload", 0, 0, "", paramString, String.valueOf(FMDataCache.b().size()), "");
    while (i < FMDataCache.b().size())
    {
      a(((FileInfo)FMDataCache.b().get(i)).d(), paramString);
      i += 1;
    }
    FMDataCache.b();
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    a().a(paramString, paramInt1, paramInt2, paramLong);
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, long paramLong, int paramInt2, String paramString3)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramInt1, paramString2, paramLong, paramInt2, paramString3, null);
  }
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    a(paramLong, paramString, paramInt);
  }
  
  public void a(String paramString1, String paramString2)
  {
    a().a(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerEngine<FileAssistant>", 2, "sendAllSelectedFiles, strSendUin[" + FileManagerUtil.e(paramString1) + "], recvUin[" + FileManagerUtil.e(paramString2) + "], peerType[" + paramInt + "]");
    }
    int i = 0;
    while (i < FMDataCache.e().size())
    {
      b(FileManagerUtil.a((WeiYunFileInfo)FMDataCache.e().get(i)), paramString1, paramString2, paramInt);
      i += 1;
    }
    i = 0;
    Object localObject;
    while (i < FMDataCache.d().size())
    {
      localObject = (OfflineFileInfo)FMDataCache.d().get(i);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(FileManagerUtil.a((OfflineFileInfo)localObject, paramInt), paramString1, paramString2, paramInt, true);
      ((FileManagerEntity)localObject).peerType = paramInt;
      ((FileManagerEntity)localObject).status = 2;
      if (paramInt == 3000) {
        ((FileManagerEntity)localObject).nOpType = 28;
      }
      a((FileManagerEntity)localObject);
      i += 1;
    }
    i = 0;
    while (i < FMDataCache.c().size())
    {
      localObject = (FileManagerEntity)FMDataCache.c().get(i);
      FileCategoryUtil.a((FileManagerEntity)localObject);
      a(((FileManagerEntity)localObject).nSessionId, paramString1, paramString2, paramInt, true);
      i += 1;
    }
    i = 0;
    while (i < FMDataCache.b().size())
    {
      a(((FileInfo)FMDataCache.b().get(i)).d(), paramString1, paramString2, paramInt, true).strApkPackageName = ((FileInfo)FMDataCache.b().get(i)).c();
      i += 1;
    }
    i = FileManagerUtil.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    if ((paramInt == 0) && (i < 3) && (FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString2)))
    {
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString2, false);
      paramString1 = BaseApplicationImpl.getContext().getString(2131364871);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramInt, -3009, paramString1);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), i + 1);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    QLog.i("FileManagerEngine<FileAssistant>", 1, "deleteOfflineFile, peerUin[" + FileManagerUtil.e(paramString1) + "],fileName[" + paramString2 + "],uuid[" + paramString3 + "]");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramString3, paramString2, paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerEngine<FileAssistant>", 2, "delAllSelectedFiles, bDelLocalFile[" + paramBoolean + "]");
    }
    int i = 0;
    while (i < FMDataCache.e().size())
    {
      a((WeiYunFileInfo)FMDataCache.e().get(i));
      i += 1;
    }
    i = 0;
    Object localObject;
    while (i < FMDataCache.d().size())
    {
      localObject = (OfflineFileInfo)FMDataCache.d().get(i);
      a(String.valueOf(((OfflineFileInfo)localObject).jdField_a_of_type_Long), ((OfflineFileInfo)localObject).b, ((OfflineFileInfo)localObject).jdField_a_of_type_JavaLangString, ((OfflineFileInfo)localObject).jdField_a_of_type_Boolean);
      i += 1;
    }
    i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i < FMDataCache.c().size())
      {
        localObject = (FileManagerEntity)FMDataCache.c().get(i);
        FileCategoryUtil.a((FileManagerEntity)localObject);
        b(((FileManagerEntity)localObject).nSessionId);
        if (paramBoolean) {}
        try
        {
          FileUtil.a(new File(((FileManagerEntity)localObject).strFilePath));
          i += 1;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("FileManagerEngine<FileAssistant>", 2, "delAllSelectedFiles recent exception:" + localException1.toString());
            }
          }
        }
      }
    }
    for (;;)
    {
      if (j < FMDataCache.b().size())
      {
        String str = ((FileInfo)FMDataCache.b().get(j)).d();
        try
        {
          FileUtil.a(new File(str));
          j += 1;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("FileManagerEngine<FileAssistant>", 2, "delAllSelectedFiles local exception:" + localException2.toString());
            }
          }
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
  }
  
  public boolean a(long paramLong)
  {
    QLog.i("FileManagerEngine<FileAssistant>", 1, "sessionid[" + String.valueOf(paramLong) + "] call Pause");
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
    if (localFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("FileManagerEngine<FileAssistant>", 2, "sessionid[" + String.valueOf(paramLong) + "] item is not exist");
      }
      return false;
    }
    if ((localFileManagerEntity.cloudType == 0) && (1 != localFileManagerEntity.nOpType))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
      return true;
    }
    FileManagerReporter.fileAssistantReportData localfileAssistantReportData;
    if (1 == localFileManagerEntity.nOpType)
    {
      localfileAssistantReportData = new FileManagerReporter.fileAssistantReportData();
      localfileAssistantReportData.b = "recv_file_cancel";
      FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), localfileAssistantReportData);
    }
    while ((localFileManagerEntity.peerUin == null) || (localFileManagerEntity.uniseq == -1L))
    {
      return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
      if (localFileManagerEntity.nOpType == 0)
      {
        localfileAssistantReportData = new FileManagerReporter.fileAssistantReportData();
        localfileAssistantReportData.b = "send_file_cancel";
        FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), localfileAssistantReportData);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.peerUin, localFileManagerEntity.uniseq, localFileManagerEntity.peerType);
  }
  
  public boolean a(long paramLong, String paramString)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramLong);
    if (localFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "why entity is null you can choose!!!");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FileManagerEngine<FileAssistant>", 2, "Printe FileManagerEntity InfoItem [" + FileManagerUtil.a(localFileManagerEntity) + " ]");
    }
    return a(localFileManagerEntity.strFilePath, paramString);
  }
  
  public boolean a(long paramLong1, String paramString, long paramLong2, long paramLong3, int paramInt1, int paramInt2)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong1);
    if (paramString == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FileManagerEngine<FileAssistant>", 2, String.format("ForwardTroopFile==>fileName:%s|mEntrySessionID:%s|old filePath:%s", new Object[] { paramString.fileName, paramLong1 + "", paramString.strTroopFilePath }));
    }
    Object localObject = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong2, paramString.Uuid, paramString.strTroopFilePath, paramString.fileName, paramString.fileSize, paramString.busId);
    if ((localObject == null) || (((TroopFileStatusInfo)localObject).d == null)) {
      return false;
    }
    if (paramInt1 == 1)
    {
      paramInt1 = Math.abs(new Random().nextInt());
      TroopFileStatusInfo localTroopFileStatusInfo = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong3).a(((TroopFileStatusInfo)localObject).d, paramLong2, ((TroopFileStatusInfo)localObject).jdField_e_of_type_JavaLangString, ((TroopFileStatusInfo)localObject).jdField_a_of_type_JavaLangString, ((TroopFileStatusInfo)localObject).b, ((TroopFileStatusInfo)localObject).jdField_e_of_type_Int, paramInt1, paramLong1);
      paramLong2 = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong3), localTroopFileStatusInfo.jdField_e_of_type_JavaLangString, localTroopFileStatusInfo.b, localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID.toString(), paramInt1, String.valueOf(((TroopFileStatusInfo)localObject).jdField_a_of_type_Long), paramLong1);
      paramString.structMsgSeq = paramLong2;
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerEngine<FileAssistant>", 2, "ForwardTroopFile, startCopyToGroup, entrySessionID:" + paramLong1 + "|InsertAIOMsg, msgSeq:" + paramLong2);
      }
      return true;
    }
    if ((paramInt1 == 3000) || (paramInt1 == 0))
    {
      localObject = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong2);
      if (paramLong2 != 0L) {
        break label356;
      }
    }
    label356:
    for (paramLong1 = paramString.TroopUin;; paramLong1 = paramLong2)
    {
      ((TroopFileTransferManager)localObject).a(paramInt2, paramLong1, paramString.busId, paramLong3, paramInt1, paramString.fileName, paramString.fileSize, paramString.strTroopFilePath, false, 0L, FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      return true;
    }
  }
  
  public boolean a(long paramLong, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramLong);
    if (localFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "why entity is null you can choose!!!");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FileManagerEngine<FileAssistant>", 2, "Printe FileManagerEntity InfoItem [" + FileManagerUtil.a(localFileManagerEntity) + " ]");
    }
    FileManagerUtil.c(localFileManagerEntity);
    if ((localFileManagerEntity.cloudType == 2) && (localFileManagerEntity.WeiYunFileId != null) && (paramBoolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerEngine<FileAssistant>", 2, "Send lastOperation list type id weiyun to offlinefile, fileid[" + localFileManagerEntity.WeiYunFileId + "], filename[" + localFileManagerEntity.fileName + "], filename[" + localFileManagerEntity.fileSize + "]");
      }
      FileManagerUtil.b(localFileManagerEntity.nSessionId);
      if ((paramString1 == null) || (paramString1.length() == 0)) {
        a(localFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString2, paramInt);
      }
    }
    for (;;)
    {
      return false;
      b(localFileManagerEntity, paramString1, paramString2, paramInt);
      continue;
      if ((localFileManagerEntity.cloudType == 1) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FileManagerEngine<FileAssistant>", 2, "cloud is offline,so try offline to offline!, nSessionId[" + paramLong + "], strSendUin[" + FileManagerUtil.e(paramString1) + "], recvUin[" + FileManagerUtil.e(paramString2) + "], peerType[" + paramInt + "], toOffline[" + paramBoolean + "]");
        }
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        if ((paramInt == 1004) || (paramInt == 1000)) {
          localObject = paramString1;
        }
        for (;;)
        {
          localObject = a(localFileManagerEntity, (String)localObject, paramString2, paramInt, true);
          FileManagerUtil.b(((FileManagerEntity)localObject).nSessionId);
          FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2, (FileManagerEntity)localObject);
          ((FileManagerEntity)localObject).peerType = localFileManagerEntity.peerType;
          if (localFileManagerEntity.peerType != 3000) {
            break label479;
          }
          if (paramInt != 3000) {
            break label462;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((FileManagerEntity)localObject, 22);
          break;
          if (paramInt == 1006) {
            localObject = paramString1;
          }
        }
        label462:
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((FileManagerEntity)localObject, 21);
        continue;
        label479:
        if (paramInt == 3000) {
          ((FileManagerEntity)localObject).nOpType = 28;
        }
        a((FileManagerEntity)localObject);
      }
      else
      {
        if (localFileManagerEntity.strFilePath != null) {
          return a(localFileManagerEntity.strFilePath, paramString1, paramString2, paramInt, paramBoolean) != null;
        }
        if (QLog.isColorLevel()) {
          QLog.e("FileManagerEngine<FileAssistant>", 2, "what's type for this file!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
      }
    }
  }
  
  public boolean a(String paramString, long paramLong, int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramLong, paramInt);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    Object localObject = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(paramString2));
    if (localObject != null)
    {
      int i = Math.abs(new Random().nextInt());
      localObject = ((TroopFileTransferManager)localObject).a(paramString1, true, i);
      paramString1 = new File(paramString1);
      TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString1.getName(), paramString1.length(), ((TroopFileStatusInfo)localObject).jdField_a_of_type_JavaUtilUUID.toString(), i, null, 0L);
    }
    return true;
  }
  
  public String b(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOfflineVideoThumbDownLoader == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOfflineVideoThumbDownLoader = new OfflineVideoThumbDownLoader(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOfflineVideoThumbDownLoader.a(paramFileManagerEntity, paramInt);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
  }
  
  public void b(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "ReviceFile,entity is null!");
      }
      return;
    }
    switch (paramFileManagerEntity.cloudType)
    {
    }
    for (;;)
    {
      i();
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("FileManagerEngine<FileAssistant>", 2, "ReviceFile, but entity is localFile");
      return;
      if (QLog.isColorLevel()) {
        QLog.w("FileManagerEngine<FileAssistant>", 2, "ReviceFile, entity is CLOUD_TYPE_OFFLINE ,peerType[" + paramFileManagerEntity.peerType + "]");
      }
      a(paramFileManagerEntity.nSessionId, paramFileManagerEntity.uniseq, paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, 1);
      continue;
      if (QLog.isColorLevel()) {
        QLog.w("FileManagerEngine<FileAssistant>", 2, "ReviceFile, entity is CLOUD_TYPE_WEIYUN ,peerType[" + paramFileManagerEntity.peerType + "]");
      }
      a(paramFileManagerEntity.nSessionId, paramFileManagerEntity.uniseq, paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, 5);
    }
  }
  
  public void b(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt)
  {
    if (paramInt == 1)
    {
      a().a(paramFileManagerEntity, paramString2);
      return;
    }
    String str;
    if (paramString1 != null)
    {
      str = paramString1;
      if (paramString1.length() != 0) {}
    }
    else
    {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    }
    a(paramFileManagerEntity, str, paramString2, paramInt);
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString);
  }
  
  public void b(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramString2);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
  }
  
  public boolean b(long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
    boolean bool1;
    if (localFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "delete record fail. entity is null, sessionid: " + paramLong);
      }
      bool1 = false;
      return bool1;
    }
    if (localFileManagerEntity.cloudType == 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
    }
    for (;;)
    {
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
      bool1 = bool2;
      if (localFileManagerEntity == null) {
        break;
      }
      bool1 = bool2;
      if (!localFileManagerEntity.bDelInAio) {
        break;
      }
      bool1 = bool2;
      if (!localFileManagerEntity.bDelInFM) {
        break;
      }
      bool1 = bool2;
      if (localFileManagerEntity.cloudType != 0) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(localFileManagerEntity.nSessionId);
      return bool2;
      if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong)) && (QLog.isColorLevel())) {
        QLog.w("FileManagerEngine<FileAssistant>", 2, "Pause[" + String.valueOf(paramLong) + "] faild!,status[" + String.valueOf(localFileManagerEntity.status) + "]");
      }
    }
  }
  
  public String c(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreDiscVideoThumbDownloader == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreDiscVideoThumbDownloader = new DiscVideoThumbDownloader(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreDiscVideoThumbDownloader.a(paramFileManagerEntity, paramInt);
  }
  
  public void c()
  {
    a().a();
  }
  
  public void c(String paramString)
  {
    a().a(paramString);
  }
  
  public boolean c()
  {
    return a().a();
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
  }
  
  public void d(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter.b(paramString);
  }
  
  public boolean d()
  {
    return false;
  }
  
  public void e()
  {
    a().b();
  }
  
  public void f()
  {
    FileViewMusicService.a().c();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerEngine<FileAssistant>", 2, "downLoadAllSelectFiles,weiyun[" + FMDataCache.e().size() + "], offline[" + FMDataCache.d().size() + "], recent[" + FMDataCache.c().size() + "], localfile[" + FMDataCache.b().size() + "]");
    }
    int i = 0;
    FileManagerEntity localFileManagerEntity;
    while (i < FMDataCache.e().size())
    {
      localFileManagerEntity = FileManagerUtil.a((WeiYunFileInfo)FMDataCache.e().get(i));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerEngine<FileAssistant>", 2, "downWeiYunFiles,weiyun[" + i + "]");
      }
      a(localFileManagerEntity.nSessionId, localFileManagerEntity.uniseq, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 5);
      i += 1;
    }
    i = 0;
    while (i < FMDataCache.d().size())
    {
      localFileManagerEntity = FileManagerUtil.a((OfflineFileInfo)FMDataCache.d().get(i), 0);
      localFileManagerEntity.status = 2;
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerEngine<FileAssistant>", 2, "downOfflineFiles,weiyun[" + i + "]");
      }
      a(localFileManagerEntity.nSessionId, localFileManagerEntity.uniseq, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 8);
      i += 1;
    }
    i = 0;
    if (i < FMDataCache.c().size())
    {
      localFileManagerEntity = (FileManagerEntity)FMDataCache.c().get(i);
      FileCategoryUtil.a(localFileManagerEntity);
      switch (localFileManagerEntity.cloudType)
      {
      default: 
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerEngine<FileAssistant>", 2, "unknow type,Engity:" + FileManagerUtil.a(localFileManagerEntity));
        }
        break;
      }
      for (;;)
      {
        i += 1;
        break;
        if (QLog.isColorLevel())
        {
          QLog.i("FileManagerEngine<FileAssistant>", 2, "downRecentFiles,local[" + i + "] break");
          continue;
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerEngine<FileAssistant>", 2, "downRecentFiles,offline[" + i + "]");
          }
          a(localFileManagerEntity.nSessionId, localFileManagerEntity.uniseq, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 8);
          continue;
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerEngine<FileAssistant>", 2, "downRecentFiles,weiyun[" + i + "]");
          }
          a(localFileManagerEntity.nSessionId, localFileManagerEntity.uniseq, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 5);
        }
      }
    }
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("OfflineFileConfigV2", 0).edit().putBoolean("HasNewDownload", false).commit();
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("OfflineFileConfigV2", 0).edit().putBoolean("HasNewDownload", true).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileManagerEngine
 * JD-Core Version:    0.7.0.1
 */