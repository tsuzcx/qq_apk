package com.tencent.mobileqq.filemanager.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.service.message.MessageCache;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="nSessionId")
public class FileManagerEntity
  extends Entity
  implements Cloneable
{
  public long TroopUin = 0L;
  public String Uuid;
  public String WeiYunFileId;
  public boolean bDelInAio = false;
  public boolean bDelInFM = false;
  public boolean bSend = true;
  public byte[] bombData;
  public int busId = 0;
  public int cloudType = -1;
  public long dbVer = 50L;
  public int errCode = 0;
  public float fOlRecvProgressOnNotify = 0.0F;
  public float fOlRecvSpeed = 0.0F;
  public float fProgress = 0.0F;
  public String fileName;
  public long fileSize = 0L;
  public int forwardTroopFileEntrance;
  public boolean isReaded = false;
  public long lastTime = 0L;
  @notColumn
  public Object mContext;
  public long msgSeq = 0L;
  public long msgTime = 0L;
  public long msgUid = 0L;
  public int nFileType = -1;
  public long nOLfileSessionId = 0L;
  public int nOlSenderProgress = -1;
  public int nOpType = -1;
  public long nRelatedSessionId = 0L;
  @unique
  public long nSessionId = 0L;
  public int nWeiYunSrcType = 0;
  @notColumn
  public long peerDin;
  public String peerNick;
  public int peerType = 0;
  public String peerUin;
  @notColumn
  public int qlmsgSrc = 0;
  @notColumn
  public FileManagerEntity relatedEntity;
  public String selfUin;
  public long srvTime = MessageCache.a() * 1000L;
  public int status = -1;
  public String strApkPackageName;
  @notColumn
  public String strDataLineMPFileID;
  public String strFileMd5;
  public String strFilePath;
  public String strFileSHA;
  @notColumn
  public String strLargeThumPath;
  public String strServerPath;
  public String strSrcName;
  public String strThumbPath;
  public String strTroopFileID;
  public String strTroopFilePath;
  public String strTroopFileUuid;
  public long structMsgSeq;
  public String tmpSessionFromPhone;
  public String tmpSessionRelatedUin;
  @notColumn
  public byte[] tmpSessionSig;
  public String tmpSessionToPhone;
  public long tmpSessionType = 0L;
  @notColumn
  public int transSpeed = 0;
  public long uniseq = -1L;
  
  public static String tableName()
  {
    return "mr_fileManager";
  }
  
  public FileManagerEntity clone()
  {
    try
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)super.clone();
      return localFileManagerEntity;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public void copyFrom(FileManagerEntity paramFileManagerEntity)
  {
    try
    {
      if (paramFileManagerEntity.bombData != null) {
        this.bombData = ((byte[])paramFileManagerEntity.bombData.clone());
      }
      this.cloudType = paramFileManagerEntity.cloudType;
      this.fileName = paramFileManagerEntity.fileName;
      this.fileSize = paramFileManagerEntity.fileSize;
      this.fProgress = paramFileManagerEntity.fProgress;
      this.isReaded = paramFileManagerEntity.isReaded;
      this.uniseq = paramFileManagerEntity.uniseq;
      this.nFileType = paramFileManagerEntity.nFileType;
      this.nOpType = paramFileManagerEntity.nOpType;
      this.peerNick = paramFileManagerEntity.peerNick;
      this.peerType = paramFileManagerEntity.peerType;
      this.peerUin = paramFileManagerEntity.peerUin;
      this.selfUin = paramFileManagerEntity.selfUin;
      this.srvTime = paramFileManagerEntity.srvTime;
      this.status = paramFileManagerEntity.status;
      this.strFilePath = paramFileManagerEntity.strFilePath;
      this.strServerPath = paramFileManagerEntity.strServerPath;
      this.strThumbPath = paramFileManagerEntity.strThumbPath;
      this.Uuid = paramFileManagerEntity.Uuid;
      this.WeiYunFileId = paramFileManagerEntity.WeiYunFileId;
      this.nWeiYunSrcType = paramFileManagerEntity.nWeiYunSrcType;
      this.lastTime = paramFileManagerEntity.lastTime;
      this.bSend = paramFileManagerEntity.bSend;
      this.nOlSenderProgress = paramFileManagerEntity.nOlSenderProgress;
      this.fOlRecvSpeed = paramFileManagerEntity.fOlRecvSpeed;
      this.fOlRecvProgressOnNotify = paramFileManagerEntity.fOlRecvProgressOnNotify;
      this.dbVer = paramFileManagerEntity.dbVer;
      this.strSrcName = paramFileManagerEntity.strSrcName;
      this.msgSeq = paramFileManagerEntity.msgSeq;
      this.msgUid = paramFileManagerEntity.msgUid;
      this.nRelatedSessionId = paramFileManagerEntity.nRelatedSessionId;
      this.msgTime = paramFileManagerEntity.msgTime;
      this.nOLfileSessionId = paramFileManagerEntity.nOLfileSessionId;
      this.strFileMd5 = paramFileManagerEntity.strFileMd5;
      this.strTroopFileID = paramFileManagerEntity.strTroopFileID;
      this.strTroopFilePath = paramFileManagerEntity.strTroopFilePath;
      this.busId = paramFileManagerEntity.busId;
      this.TroopUin = paramFileManagerEntity.TroopUin;
      this.structMsgSeq = paramFileManagerEntity.structMsgSeq;
      this.errCode = paramFileManagerEntity.errCode;
      this.strFileSHA = paramFileManagerEntity.strFileSHA;
      this.tmpSessionType = paramFileManagerEntity.tmpSessionType;
      this.tmpSessionRelatedUin = paramFileManagerEntity.tmpSessionRelatedUin;
      this.tmpSessionFromPhone = paramFileManagerEntity.tmpSessionFromPhone;
      this.tmpSessionToPhone = paramFileManagerEntity.tmpSessionToPhone;
      return;
    }
    finally {}
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FileManagerEntity)) {}
    while (((FileManagerEntity)paramObject).nSessionId != this.nSessionId) {
      return false;
    }
    return true;
  }
  
  public String getTableName()
  {
    return "mr_fileManager";
  }
  
  public boolean isFromProcessingForward2c2cOrDiscItem()
  {
    return ((this.nOpType == 24) || (this.nOpType == 25)) && ((this.status == 2) || (this.status == 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.FileManagerEntity
 * JD-Core Version:    0.7.0.1
 */