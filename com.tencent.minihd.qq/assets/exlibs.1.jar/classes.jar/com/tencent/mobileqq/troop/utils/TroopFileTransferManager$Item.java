package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.TroopFileTansferItemEntity;
import com.tencent.mobileqq.filemanager.util.IForwardCallBack;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import java.security.MessageDigest;
import java.util.UUID;

public class TroopFileTransferManager$Item
  extends TroopFileTansferItemEntity
{
  public static final String ThumbnailFilePrefix = "[Thumb]";
  public transient byte[] CheckKey;
  public transient MessageDigest DigestMd5;
  public transient MessageDigest DigestSha;
  public transient String DownloadIp;
  public transient String DownloadUrl;
  public transient boolean IsNewStatus;
  public transient int Pausing;
  public transient long ScanPos;
  public transient long StatusUpdateTimeMs;
  public transient boolean ThumbnailDownloading_Large;
  public transient boolean ThumbnailDownloading_Small;
  public transient String TmpFile;
  public transient String UploadIp;
  public transient TroopFileTransferManager.Item.W2MPauseEnum W2MPause;
  public transient String cookieValue;
  public transient String downUrlStr4Report;
  public transient boolean isFileExist;
  public IForwardCallBack mForwardCallback = null;
  public transient int retryTimes = 0;
  public transient String rspHeadStr;
  public transient long transferBeginTime = 0L;
  public transient long transferedSize = 0L;
  public transient String uploadUrl;
  
  public TroopFileTransferManager$Item(TroopFileTansferItemEntity paramTroopFileTansferItemEntity)
  {
    this.Id = paramTroopFileTansferItemEntity.Id;
    this.LocalFile = paramTroopFileTansferItemEntity.LocalFile;
    this.Status = paramTroopFileTansferItemEntity.Status;
    this.FilePath = paramTroopFileTansferItemEntity.FilePath;
    this.FileName = paramTroopFileTansferItemEntity.FileName;
    this.ProgressTotal = paramTroopFileTansferItemEntity.ProgressTotal;
    this.UploadTime = paramTroopFileTansferItemEntity.UploadTime;
    this.BusId = paramTroopFileTansferItemEntity.BusId;
    this.ErrorCode = paramTroopFileTansferItemEntity.ErrorCode;
    this.ProgressValue = paramTroopFileTansferItemEntity.ProgressValue;
    this.Md5 = paramTroopFileTansferItemEntity.Md5;
    this.Sha = paramTroopFileTansferItemEntity.Sha;
    this.isFromAIO = paramTroopFileTansferItemEntity.isFromAIO;
    this.HasThumbnailFile_Small = paramTroopFileTansferItemEntity.HasThumbnailFile_Small;
    this.ThumbnailFileTimeMS_Small = paramTroopFileTansferItemEntity.ThumbnailFileTimeMS_Small;
    this.HasThumbnailFile_Large = paramTroopFileTansferItemEntity.HasThumbnailFile_Large;
    this.ThumbnailFileTimeMS_Large = paramTroopFileTansferItemEntity.ThumbnailFileTimeMS_Large;
    this.NickName = paramTroopFileTansferItemEntity.NickName;
    this.RandomNum = paramTroopFileTansferItemEntity.RandomNum;
    this.NameForSave = paramTroopFileTansferItemEntity.NameForSave;
    this.SafeCheckRes = paramTroopFileTansferItemEntity.SafeCheckRes;
    this.ForwardPath = paramTroopFileTansferItemEntity.ForwardPath;
    this.ForwardBusId = paramTroopFileTansferItemEntity.ForwardBusId;
    this.ForwardTroopuin = paramTroopFileTansferItemEntity.ForwardTroopuin;
  }
  
  public TroopFileTransferManager$Item(TroopFileInfo paramTroopFileInfo)
  {
    this.Id = paramTroopFileInfo.jdField_a_of_type_JavaUtilUUID;
    this.LocalFile = paramTroopFileInfo.f;
    this.Status = paramTroopFileInfo.jdField_g_of_type_Int;
    this.FilePath = paramTroopFileInfo.jdField_b_of_type_JavaLangString;
    this.FileName = paramTroopFileInfo.jdField_c_of_type_JavaLangString;
    this.ProgressTotal = paramTroopFileInfo.jdField_a_of_type_Long;
    this.UploadTime = paramTroopFileInfo.jdField_c_of_type_Int;
    this.BusId = paramTroopFileInfo.jdField_a_of_type_Int;
    if ((paramTroopFileInfo.jdField_g_of_type_JavaLangString != null) && (paramTroopFileInfo.jdField_g_of_type_JavaLangString.length() > 0))
    {
      bool1 = true;
      this.HasThumbnailFile_Small = bool1;
      if ((paramTroopFileInfo.h == null) || (paramTroopFileInfo.h.length() <= 0)) {
        break label152;
      }
    }
    label152:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.HasThumbnailFile_Large = bool1;
      this.NickName = paramTroopFileInfo.i;
      return;
      bool1 = false;
      break;
    }
  }
  
  public final boolean canFetchThumbnailFile(int paramInt)
  {
    if (this.Status == 4) {}
    long l;
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
            if (paramInt != 128) {
              break;
            }
          } while (this.ThumbnailDownloading_Small);
          l = SystemClock.uptimeMillis() - this.ThumbnailFileTimeMS_Small;
        } while ((this.ThumbnailFileTimeMS_Small != 0L) && (l <= 300000L) && (l >= 0L));
        return true;
      } while ((paramInt != 640) || (this.ThumbnailDownloading_Large));
      l = SystemClock.uptimeMillis() - this.ThumbnailFileTimeMS_Large;
    } while ((this.ThumbnailFileTimeMS_Large != 0L) && (l <= 300000L) && (l >= 0L));
    return true;
  }
  
  public Bundle createExtraData(long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopUin", paramLong);
    localBundle.putString("itemKey", this.Id.toString());
    return localBundle;
  }
  
  public final TroopFileStatusInfo getInfo(long paramLong)
  {
    Object localObject2 = null;
    TroopFileStatusInfo localTroopFileStatusInfo = new TroopFileStatusInfo();
    localTroopFileStatusInfo.jdField_a_of_type_Long = paramLong;
    localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID = this.Id;
    localTroopFileStatusInfo.jdField_c_of_type_Long = this.ProgressValue;
    localTroopFileStatusInfo.jdField_b_of_type_Int = this.Status;
    localTroopFileStatusInfo.jdField_a_of_type_Boolean = this.IsNewStatus;
    localTroopFileStatusInfo.jdField_c_of_type_Int = this.ErrorCode;
    localTroopFileStatusInfo.jdField_e_of_type_Int = this.BusId;
    Object localObject1;
    if (this.HasThumbnailFile_Small)
    {
      localObject1 = getThumbnailFile(paramLong, 128);
      localTroopFileStatusInfo.jdField_b_of_type_JavaLangString = ((String)localObject1);
      if (!this.HasThumbnailFile_Large) {
        break label222;
      }
      localObject1 = getThumbnailFile(paramLong, 640);
      label110:
      localTroopFileStatusInfo.jdField_c_of_type_JavaLangString = ((String)localObject1);
      localTroopFileStatusInfo.jdField_b_of_type_Long = this.ProgressTotal;
      localTroopFileStatusInfo.jdField_d_of_type_Int = this.UploadTime;
      localTroopFileStatusInfo.jdField_d_of_type_JavaLangString = this.FilePath;
      if ((TextUtils.isEmpty(this.NameForSave)) || (this.SafeCheckRes != 2)) {
        break label242;
      }
    }
    label222:
    label242:
    for (localTroopFileStatusInfo.jdField_e_of_type_JavaLangString = this.NameForSave;; localTroopFileStatusInfo.jdField_e_of_type_JavaLangString = this.FileName)
    {
      localTroopFileStatusInfo.jdField_a_of_type_JavaLangString = this.LocalFile;
      localTroopFileStatusInfo.f = this.NickName;
      localTroopFileStatusInfo.jdField_d_of_type_Long = this.entrySessionID;
      return localTroopFileStatusInfo;
      if (canFetchThumbnailFile(128))
      {
        localObject1 = null;
        break;
      }
      localObject1 = "";
      break;
      localObject1 = localObject2;
      if (canFetchThumbnailFile(640)) {
        break label110;
      }
      localObject1 = "";
      break label110;
    }
  }
  
  public final String getThumbnailFile(long paramLong, int paramInt)
  {
    if (paramInt == 128) {
      return AppConstants.aS + "[Thumb]" + paramLong + "-" + this.Id.toString();
    }
    return AppConstants.aS + "[Thumb]" + paramInt + paramLong + "-" + this.Id.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item
 * JD-Core Version:    0.7.0.1
 */