import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.IForwardCallBack;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

public final class jay
  implements IForwardCallBack
{
  public jay(QQAppInterface paramQQAppInterface) {}
  
  public long a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, long paramLong, int paramInt3)
  {
    Object localObject1 = TroopFileManager.a(this.a, Long.parseLong(paramString2));
    if (localObject1 != null) {
      ((TroopFileManager)localObject1).b(paramString3, paramString4, paramLong, paramInt2);
    }
    String str = TransfileUtile.a("", 0L, 0, true);
    localObject1 = null;
    long l1 = 0L;
    try
    {
      l2 = Long.parseLong(paramString2);
      l1 = l2;
      localObject2 = TroopFileManager.a(this.a, l2).a(paramString3);
      localObject1 = localObject2;
      l1 = l2;
    }
    catch (Exception localException)
    {
      long l2;
      Object localObject2;
      label82:
      break label82;
    }
    localObject2 = new FileManagerEntity();
    ((FileManagerEntity)localObject2).nSessionId = FileManagerUtil.a().longValue();
    ((FileManagerEntity)localObject2).fileName = paramString4;
    l2 = MessageRecordFactory.a(-1000).uniseq;
    ((FileManagerEntity)localObject2).uniseq = l2;
    if (paramInt1 == 0)
    {
      ((FileManagerEntity)localObject2).nOpType = 24;
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerUtil<FileAssistant>", 1, "getC2CProcessCallBack->prepareForward nSessionId[" + ((FileManagerEntity)localObject2).nSessionId + "],[troopToOffline]");
      }
    }
    do
    {
      for (;;)
      {
        ((FileManagerEntity)localObject2).bSend = true;
        ((FileManagerEntity)localObject2).isReaded = true;
        ((FileManagerEntity)localObject2).peerType = paramInt1;
        ((FileManagerEntity)localObject2).peerUin = paramString1;
        ((FileManagerEntity)localObject2).peerNick = FileManagerUtil.a(this.a, paramString1, null, paramInt1);
        ((FileManagerEntity)localObject2).selfUin = paramString2;
        ((FileManagerEntity)localObject2).srvTime = (MessageCache.a() * 1000L);
        ((FileManagerEntity)localObject2).cloudType = 4;
        ((FileManagerEntity)localObject2).status = 2;
        ((FileManagerEntity)localObject2).msgSeq = FileManagerUtil.a();
        ((FileManagerEntity)localObject2).msgUid = FileManagerUtil.b();
        ((FileManagerEntity)localObject2).fileSize = paramLong;
        ((FileManagerEntity)localObject2).TroopUin = l1;
        ((FileManagerEntity)localObject2).busId = paramInt2;
        ((FileManagerEntity)localObject2).strTroopFilePath = paramString3;
        ((FileManagerEntity)localObject2).strTroopFileID = ((TroopFileInfo)localObject1).a.toString();
        ((FileManagerEntity)localObject2).lastTime = ((TroopFileInfo)localObject1).d;
        ((FileManagerEntity)localObject2).TroopUin = l1;
        ((FileManagerEntity)localObject2).forwardTroopFileEntrance = paramInt3;
        paramString2 = this.a.a();
        this.a.a().a(paramString1, paramString2, true, "", paramLong, true, paramInt1, str, ((FileManagerEntity)localObject2).msgSeq, ((FileManagerEntity)localObject2).msgSeq, paramString3, 1, l2, ((FileManagerEntity)localObject2).msgUid, -1L, MessageCache.a());
        this.a.a().a((FileManagerEntity)localObject2);
        return ((FileManagerEntity)localObject2).nSessionId;
        if (paramInt1 != 3000) {
          break;
        }
        ((FileManagerEntity)localObject2).nOpType = 25;
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerUtil<FileAssistant>", 1, "getC2CProcessCallBack->prepareForward nSessionId[" + ((FileManagerEntity)localObject2).nSessionId + "],[troopToDisc]");
        }
      }
    } while (!QLog.isDevelopLevel());
    throw new NullPointerException("群同事传递的peerType不对！");
  }
  
  public String a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, long paramLong1, long paramLong2)
  {
    return null;
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerUtil<FileAssistant>", 1, "getC2CProcessCallBack->onResult bSuccess[" + paramBoolean + "],nSessionId[" + paramLong + "],retCode[" + paramInt + "],retMsg[" + paramString1 + "],uuid[" + paramString2 + "],troopUin[" + paramString3 + "],strNewPath[" + paramString4 + "]");
    }
    FileManagerEntity localFileManagerEntity = this.a.a().b(paramLong);
    if (localFileManagerEntity == null)
    {
      QLog.e("FileManagerUtil<FileAssistant>", 1, "getC2CProcessCallBack->onResult,but entity is null SessionId[" + paramLong + "]");
      return;
    }
    if (localFileManagerEntity.nOpType == 24)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerUtil<FileAssistant>", 1, "getC2CProcessCallBack->onResult [troopToOffline]");
      }
      if ((paramBoolean) && (TextUtils.isEmpty(paramString4) != true)) {
        break label435;
      }
      localFileManagerEntity.status = 0;
      if (TextUtils.isEmpty(paramString4) == true) {
        QLog.e("FileManagerUtil<FileAssistant>", 1, "!!!!!!!！！！new uuid is null!!!!!!!");
      }
    }
    label900:
    label909:
    for (;;)
    {
      label223:
      String str;
      if (paramInt != 0)
      {
        if (!TextUtils.isEmpty(paramString1))
        {
          FMToastUtil.c(paramString1);
          paramBoolean = false;
        }
      }
      else
      {
        if (localFileManagerEntity.peerType != 0) {
          break label808;
        }
        paramString4 = this.a;
        str = localFileManagerEntity.forwardTroopFileEntrance + "";
        if (paramBoolean != true) {
          break label800;
        }
        paramString2 = "1";
        label274:
        ReportController.b(paramString4, "P_CliOper", "Grp_files", "", "transfer", "Clk_fri", 0, 0, paramString3, str, paramString2, localFileManagerEntity.peerUin);
        label306:
        paramString2 = this.a.a();
        if (localFileManagerEntity.status != 1) {
          break label900;
        }
        paramBoolean = true;
        label326:
        paramString2.a(paramBoolean, 46, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Integer.valueOf(paramInt), paramString1 });
        return;
        if (localFileManagerEntity.nOpType == 25)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("FileManagerUtil<FileAssistant>", 1, "getC2CProcessCallBack->onResult [troopToDisc]");
          break;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("FileManagerUtil<FileAssistant>", 1, "getC2CProcessCallBack->onResult operation Error![" + localFileManagerEntity.nOpType + "]");
        break;
        label435:
        localFileManagerEntity.status = 1;
        localFileManagerEntity.cloudType = 1;
        localFileManagerEntity.Uuid = paramString4;
        localFileManagerEntity.TroopUin = 0L;
        localFileManagerEntity.strTroopFileID = null;
        localFileManagerEntity.strTroopFilePath = null;
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerUtil<FileAssistant>", 1, "onResult bSuccess[true],peerType[" + localFileManagerEntity.peerType + "],peerUin[" + localFileManagerEntity.peerUin + "],uuid[" + localFileManagerEntity.Uuid + "]");
        }
        if (localFileManagerEntity.peerType == 3000)
        {
          this.a.a().a(localFileManagerEntity, 64, "");
          this.a.a().a(localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, this.a.a(), localFileManagerEntity.fileName, localFileManagerEntity.fileSize, paramString4, localFileManagerEntity.uniseq, localFileManagerEntity.msgUid, null);
          if (FileManagerUtil.a(localFileManagerEntity.fileName) == 0) {
            paramString2 = this.a.a().a(localFileManagerEntity, 3);
          }
        }
      }
      for (;;)
      {
        if (paramString2 == null) {
          break label909;
        }
        localFileManagerEntity.strThumbPath = paramString2;
        break;
        if (FileManagerUtil.a(localFileManagerEntity.fileName) == 2)
        {
          paramString2 = this.a.a().c(localFileManagerEntity, 2);
          continue;
          this.a.a().a(localFileManagerEntity, 63, "");
          this.a.a().a(localFileManagerEntity.peerUin, localFileManagerEntity, null);
          if (FileManagerUtil.a(localFileManagerEntity.fileName) == 0)
          {
            paramString2 = this.a.a().a(paramString4, 3, true, localFileManagerEntity);
            continue;
          }
          if (FileManagerUtil.a(localFileManagerEntity.fileName) == 2)
          {
            paramString2 = this.a.a().b(localFileManagerEntity, 2);
            continue;
            FMToastUtil.c(BaseApplicationImpl.getContext().getString(2131362554));
            break label223;
            label800:
            paramString2 = "2";
            break label274;
            label808:
            if (localFileManagerEntity.peerType != 3000) {
              break label306;
            }
            paramString4 = this.a;
            str = localFileManagerEntity.forwardTroopFileEntrance + "";
            if (paramBoolean == true) {}
            for (paramString2 = "1";; paramString2 = "2")
            {
              ReportController.b(paramString4, "P_CliOper", "Grp_files", "", "transfer", "Clk_talk", 0, 0, paramString3, str, paramString2, "");
              break;
            }
            paramBoolean = false;
            break label326;
          }
        }
        paramString2 = null;
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, long paramLong, int paramInt, String paramString2, String paramString3, String paramString4) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jay
 * JD-Core Version:    0.7.0.1
 */