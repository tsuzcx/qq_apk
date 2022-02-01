import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.util.IForwardCallBack;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;
import java.util.UUID;

public final class jaz
  implements IForwardCallBack
{
  public jaz(QQAppInterface paramQQAppInterface) {}
  
  public long a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, long paramLong, int paramInt3)
  {
    return 0L;
  }
  
  public String a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, long paramLong1, long paramLong2)
  {
    paramInt2 = 3;
    if (paramInt1 == 0) {
      paramInt1 = 3;
    }
    TroopFileTransferManager localTroopFileTransferManager;
    do
    {
      for (;;)
      {
        localTroopFileTransferManager = TroopFileTransferManager.a(this.a, Long.valueOf(paramString2).longValue());
        if (localTroopFileTransferManager != null) {
          break label78;
        }
        if (QLog.isColorLevel()) {
          QLog.e("FileManagerUtil<FileAssistant>", 2, "send2Troop: troopuin error");
        }
        return null;
        if (paramInt1 != 3000) {
          break;
        }
        paramInt1 = 106;
      }
      paramInt1 = paramInt2;
    } while (!QLog.isDevelopLevel());
    throw new NullPointerException("传递的peerType不对！");
    label78:
    paramInt2 = Math.abs(new Random().nextInt());
    paramString3 = localTroopFileTransferManager.a(paramString3, paramString4, null, paramLong1, paramInt1, paramInt2, Long.valueOf(paramString1).longValue(), paramLong2);
    paramLong1 = TroopFileUtils.a(this.a, paramString2, paramString4, paramLong1, paramString3.a.toString(), paramInt2, paramString1, paramLong2);
    paramString1 = this.a.a().a(paramLong2);
    if (paramString1 != null)
    {
      paramString1.structMsgSeq = paramLong1;
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerUtil<FileAssistant>", 2, "prepareForward2Troop==>InsertAIOMsg, msgSeq:" + paramLong1);
      }
    }
    return paramString3.a.toString();
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void a(boolean paramBoolean, String paramString1, long paramLong, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerUtil<FileAssistant>", 2, "getTroopProcessCallback->onResult2Troop{bSuccess[" + paramBoolean + "],troopFileUuid[" + paramString1 + "],nSessionId[" + paramLong + "],retCode[" + paramInt + "],retMsg[" + paramString2 + "],troopUin[" + paramString3 + "],newFilePath[" + paramString4 + "]}");
    }
    paramString3 = TroopFileTransferManager.a(this.a, Long.valueOf(paramString3).longValue());
    if (paramString3 != null) {
      paramString3.a(paramLong, UUID.fromString(paramString1), null, paramInt, paramString4, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jaz
 * JD-Core Version:    0.7.0.1
 */