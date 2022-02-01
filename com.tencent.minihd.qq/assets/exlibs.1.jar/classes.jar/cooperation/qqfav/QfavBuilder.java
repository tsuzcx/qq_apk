package cooperation.qqfav;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import lzd;

public class QfavBuilder
  implements lzd
{
  private Intent a;
  
  public QfavBuilder(int paramInt)
  {
    this.a = new Intent();
    this.a.putExtra("nType", paramInt);
  }
  
  public QfavBuilder(Intent paramIntent)
  {
    this.a = paramIntent;
  }
  
  public static QfavBuilder a(float paramFloat1, float paramFloat2, String paramString1, String paramString2, String paramString3)
  {
    return new QfavBuilder(7).b("sLocation", paramString2).b("sBrief", paramString3).b("sPublisher", paramString1).a("fLatitude", paramFloat1).a("fLongitude", paramFloat2);
  }
  
  public static QfavBuilder a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, byte[] paramArrayOfByte, boolean paramBoolean, long paramLong)
  {
    paramArrayOfByte = QfavUtil.a(paramArrayOfByte);
    paramString1 = QfavUtil.a(paramArrayOfByte[0], paramString1);
    paramString2 = QfavUtil.a(paramArrayOfByte[1], paramString2);
    paramString3 = QfavUtil.a(paramArrayOfByte[2], paramString3);
    paramString4 = QfavUtil.a(paramArrayOfByte[3], paramString4);
    paramString5 = QfavUtil.a(paramArrayOfByte[4], paramString5);
    paramString6 = QfavUtil.a(paramArrayOfByte[5], paramString6);
    paramString1 = new QfavBuilder(6).a("nLinkType", paramInt).b("sTitle", paramString1).b("sUrl", paramString2).a("bAppShare", paramBoolean).a("lAppId", paramLong).b("sPublisher", paramString3).b("sBrief", paramString4).b("sPath", paramString5).b("sResUrl", paramString6);
    if (paramBoolean) {}
    for (paramLong = 4L;; paramLong = 1L) {
      return paramString1.a("lCategory", paramLong);
    }
  }
  
  public static QfavBuilder a(int paramInt, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = QfavUtil.a(paramArrayOfByte);
    return new QfavBuilder(6).a("nLinkType", paramInt).b("sTitle", paramArrayOfByte[0]).b("sUrl", paramArrayOfByte[1]).b("sPublisher", paramArrayOfByte[2]).b("sBrief", paramArrayOfByte[3]).b("sPath", paramArrayOfByte[4]).b("sResUrl", paramArrayOfByte[5]);
  }
  
  public static QfavBuilder a(Entity paramEntity)
  {
    return new QfavBuilder(2).c(paramEntity);
  }
  
  public static QfavBuilder a(String paramString)
  {
    return new QfavBuilder(6).b("sUrl", paramString);
  }
  
  public static QfavBuilder a(String paramString1, int paramInt, String paramString2)
  {
    return new QfavBuilder(4).b("sPath", paramString1).a("nDuration", paramInt).b("sBrief", paramString2);
  }
  
  public static QfavBuilder a(String paramString1, int paramInt, String paramString2, long paramLong1, String paramString3, long paramLong2)
  {
    paramInt = QfavUtil.b(paramInt);
    if (paramString2 == null) {
      paramString2 = "";
    }
    for (;;)
    {
      if ((4 == paramInt) || (5 == paramInt)) {
        paramString2 = String.valueOf(paramLong1);
      }
      return new QfavBuilder(2).b("sMD5", paramString1).b("sPath", paramString3).a("nPicType", paramInt).b("sPicId", paramString2).a("lSize", paramLong2);
    }
  }
  
  public static QfavBuilder a(String paramString1, String paramString2)
  {
    return new QfavBuilder(1).b("sText", paramString2).b("sTitle", paramString1);
  }
  
  public static QfavBuilder a(ArrayList paramArrayList, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, long paramLong, String paramString3)
  {
    paramArrayList = new QfavBuilder(8).a("sPathList", paramArrayList).b("sTitle", paramString1).a("bOnlyPic", paramBoolean1).b("sText", paramString2).a("bAppShare", paramBoolean2).a("lAppId", paramLong).b("sAppName", paramString3);
    if (paramBoolean2) {}
    for (paramLong = 4L;; paramLong = 1L) {
      return paramArrayList.a("lCategory", paramLong);
    }
  }
  
  public static void a(Activity paramActivity, Intent paramIntent)
  {
    if ((paramActivity == null) || (paramIntent == null)) {
      return;
    }
    if (!paramIntent.getBooleanExtra("bFailed", false))
    {
      if (paramIntent.getBooleanExtra("bFirstAdd", false)) {
        QfavUtil.a(paramActivity, false, null, null);
      }
      QfavUtil.a(paramActivity, 2131364628, 2);
      return;
    }
    QfavUtil.a(paramActivity, 2131364636, 1);
  }
  
  public static QfavBuilder b(Entity paramEntity)
  {
    return new QfavBuilder(8).c(paramEntity);
  }
  
  public static QfavBuilder b(String paramString)
  {
    return new QfavBuilder(2).b("sPath", paramString);
  }
  
  public Intent a()
  {
    return this.a;
  }
  
  public QfavBuilder a(int paramInt, long paramLong1, String paramString1, long paramLong2, String paramString2)
  {
    this.a.putExtra("nAuthorType", paramInt).putExtra("lUin", paramLong1).putExtra("sName", paramString1).putExtra("lGroupUin", paramLong2).putExtra("sGroupName", paramString2);
    return this;
  }
  
  public QfavBuilder a(long paramLong, String paramString)
  {
    this.a.putExtra("nAuthorType", 1).putExtra("lUin", paramLong).putExtra("sName", paramString);
    return this;
  }
  
  public QfavBuilder a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return this;
    }
    return a(Long.valueOf(paramQQAppInterface.a()).longValue(), paramQQAppInterface.c());
  }
  
  public QfavBuilder a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (paramQQAppInterface == null)) {
      return this;
    }
    return a(paramQQAppInterface, paramMessageRecord, paramMessageRecord.senderuin, paramMessageRecord.frienduin, paramMessageRecord.issend, paramMessageRecord.istroop);
  }
  
  public QfavBuilder a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (paramQQAppInterface == null) {
      return this;
    }
    int i = QfavUtil.a(paramInt2);
    String str3 = "";
    long l6 = 0L;
    Object localObject2 = "";
    long l5 = 0L;
    String str2;
    long l4;
    Object localObject1;
    long l3;
    Object localObject3;
    long l2;
    if (TextUtils.isEmpty(paramString1))
    {
      i = 1;
      paramInt2 = 0;
      str2 = paramString2;
      l4 = l5;
      localObject1 = localObject2;
      l3 = l6;
      paramString1 = str3;
      for (;;)
      {
        try
        {
          if (!MsgUtils.a(paramInt1)) {
            continue;
          }
          l4 = l5;
          localObject1 = localObject2;
          l3 = l6;
          paramString1 = str3;
          str1 = paramQQAppInterface.c();
          l4 = l5;
          localObject1 = localObject2;
          l3 = l6;
          paramString1 = str1;
          l1 = Long.valueOf(paramQQAppInterface.a()).longValue();
          localObject3 = localObject2;
          l2 = l5;
          label123:
          localObject2 = str1;
          if (paramMessageRecord == null) {
            break label833;
          }
          l4 = l2;
          localObject1 = localObject3;
          l3 = l1;
          paramString1 = str1;
          localObject2 = str1;
          if (!AnonymousChatHelper.a(paramMessageRecord)) {
            break label833;
          }
          l4 = l2;
          localObject1 = localObject3;
          l3 = l1;
          paramString1 = str1;
          if (paramMessageRecord.selfuin != null)
          {
            l4 = l2;
            localObject1 = localObject3;
            l3 = l1;
            paramString1 = str1;
            localObject2 = str1;
            if (paramMessageRecord.selfuin.equals(paramMessageRecord.senderuin)) {}
          }
          else
          {
            l4 = l2;
            localObject1 = localObject3;
            l3 = l1;
            paramString1 = str1;
            localObject2 = BaseApplicationImpl.getContext().getString(2131364761);
          }
        }
        catch (Exception paramString2)
        {
          String str1;
          label240:
          l2 = l3;
          label351:
          label494:
          long l1 = l4;
          label404:
          paramMessageRecord = paramString1;
          paramQQAppInterface = localObject1;
          paramString1 = paramString2;
          paramString1.printStackTrace();
          l3 = l1;
          continue;
          paramMessageRecord = str2;
          continue;
          paramMessageRecord = paramString2;
          continue;
        }
        if (1000 != paramInt2) {
          continue;
        }
        l4 = l2;
        localObject1 = localObject3;
        l3 = l1;
        paramString1 = (String)localObject2;
        paramMessageRecord = (FriendManager)paramQQAppInterface.getManager(8);
        if (paramMessageRecord == null) {
          continue;
        }
        l4 = l2;
        localObject1 = localObject3;
        l3 = l1;
        paramString1 = (String)localObject2;
        paramMessageRecord = paramMessageRecord.g(str2);
        l4 = l2;
        localObject1 = localObject3;
        l3 = l1;
        paramString1 = (String)localObject2;
        str1 = ContactUtils.a(paramQQAppInterface, paramMessageRecord, true);
        l4 = l2;
        localObject1 = str1;
        l3 = l1;
        paramString1 = (String)localObject2;
        l2 = Long.valueOf(paramMessageRecord).longValue();
        paramMessageRecord = str1;
        if (paramInt2 != 1004)
        {
          paramString1 = paramMessageRecord;
          l3 = l2;
          if (paramInt2 != 3000) {}
        }
        else if (paramInt2 == 1004)
        {
          paramString2 = str2;
        }
        try
        {
          paramString1 = ContactUtils.b(paramQQAppInterface, paramString2);
          paramMessageRecord = paramString1;
          l3 = Long.valueOf(paramString2).longValue();
          paramQQAppInterface = paramString1;
          paramMessageRecord = (MessageRecord)localObject2;
          l2 = l1;
          return a(i, l2, paramMessageRecord, l3, paramQQAppInterface);
        }
        catch (Exception paramString1)
        {
          paramQQAppInterface = paramMessageRecord;
          l3 = l2;
          l2 = l1;
          paramMessageRecord = (MessageRecord)localObject2;
          l1 = l3;
          continue;
        }
        if (paramInt2 != 1006) {
          break label862;
        }
        l2 = l5;
        localObject3 = localObject2;
        l1 = l6;
        str1 = str3;
        if (str2 != null)
        {
          l4 = l5;
          localObject1 = localObject2;
          l3 = l6;
          paramString1 = str3;
          str1 = ContactUtils.b(paramQQAppInterface, str2, paramInt2);
          l1 = 0L;
          l2 = l5;
          localObject3 = localObject2;
          continue;
          l4 = l5;
          localObject1 = localObject2;
          l3 = l6;
          paramString1 = str3;
          str1 = ContactUtils.b(paramQQAppInterface, paramString2, paramInt2);
          l4 = l5;
          localObject1 = localObject2;
          l3 = l6;
          paramString1 = str1;
          l1 = Long.valueOf(paramString2).longValue();
          l2 = l5;
          localObject3 = localObject2;
        }
      }
    }
    for (;;)
    {
      label555:
      l4 = l5;
      localObject1 = localObject2;
      l3 = l6;
      paramString1 = str3;
      str1 = ContactUtils.b(paramQQAppInterface, str2, 0);
      l4 = l5;
      localObject1 = localObject2;
      l3 = l6;
      paramString1 = str1;
      l1 = Long.valueOf(str2).longValue();
      if (1 == paramInt2)
      {
        l4 = l5;
        localObject1 = localObject2;
        l3 = l1;
        paramString1 = str1;
      }
      for (localObject3 = ContactUtils.a(paramQQAppInterface, paramString2, true);; localObject3 = ContactUtils.b(paramQQAppInterface, paramString2))
      {
        l4 = l5;
        localObject1 = localObject3;
        l3 = l1;
        paramString1 = str1;
        l2 = Long.valueOf(paramString2).longValue();
        break;
        l4 = l5;
        localObject1 = localObject2;
        l3 = l1;
        paramString1 = str1;
      }
      label833:
      label862:
      do
      {
        l4 = l5;
        localObject1 = localObject2;
        l3 = l6;
        paramString1 = str3;
        str1 = ContactUtils.b(paramQQAppInterface, str2, paramInt2);
        l4 = l5;
        localObject1 = localObject2;
        l3 = l6;
        paramString1 = str1;
        l1 = Long.valueOf(str2).longValue();
        l2 = l5;
        localObject3 = localObject2;
        break label123;
        do
        {
          paramMessageRecord = (MessageRecord)localObject3;
          break label351;
          do
          {
            paramString1 = (String)localObject3;
            l3 = l2;
            break label404;
            str2 = paramString1;
            break;
          } while ((2 != i) && (3 != i));
          if (1 == paramInt2) {
            break label240;
          }
        } while (1000 != paramInt2);
        break label240;
        if ((paramInt2 == 1004) || (paramInt2 == 1000)) {
          break label494;
        }
        if (paramInt2 == 1) {
          break label555;
        }
      } while (paramInt2 != 3000);
    }
  }
  
  public QfavBuilder a(String paramString, float paramFloat)
  {
    this.a.putExtra(paramString, paramFloat);
    return this;
  }
  
  public QfavBuilder a(String paramString, int paramInt)
  {
    this.a.putExtra(paramString, paramInt);
    return this;
  }
  
  public QfavBuilder a(String paramString, long paramLong)
  {
    this.a.putExtra(paramString, paramLong);
    return this;
  }
  
  public QfavBuilder a(String paramString, ArrayList paramArrayList)
  {
    this.a.putStringArrayListExtra(paramString, paramArrayList);
    return this;
  }
  
  public QfavBuilder a(String paramString, boolean paramBoolean)
  {
    this.a.putExtra(paramString, paramBoolean);
    return this;
  }
  
  public void a(Activity paramActivity, String paramString)
  {
    Object localObject = null;
    if (!a(paramActivity, paramString, -1, null))
    {
      paramString = localObject;
      if (0 == 0) {
        paramString = this.a;
      }
      QfavUtil.a(paramActivity, paramString.getIntExtra("nReasonInt", 2131364636), 1);
      return;
    }
    QfavUtil.a(paramActivity, 2131364628, 2);
    QfavUtil.a(paramActivity, paramString, true);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, FileManagerEntity paramFileManagerEntity, ChatMessage paramChatMessage)
  {
    String str = FileUtil.a(paramFileManagerEntity.fileName);
    int m = 6;
    if (paramChatMessage == null) {
      m = 7;
    }
    int j = -1;
    int i = j;
    switch (paramFileManagerEntity.cloudType)
    {
    default: 
      i = j;
    }
    while (paramFileManagerEntity.fileName.getBytes().length >= 256)
    {
      QfavUtil.a(paramActivity, 2131364640, 1);
      QfavReport.a(paramQQAppInterface, "User_AddFav", 6, -80010, m, i, str, null);
      return;
      if (3000 == paramFileManagerEntity.peerType)
      {
        i = 106;
      }
      else
      {
        i = 3;
        continue;
        i = paramFileManagerEntity.busId;
        continue;
        i = 25;
      }
    }
    int i1 = FileManagerUtil.a(paramFileManagerEntity);
    switch (i1)
    {
    case 3: 
    default: 
      QfavUtil.a(paramActivity, 2131364638, 1);
      QfavReport.a(paramQQAppInterface, "User_AddFav", 6, -80003, m, i, str, null);
      return;
    case 1: 
      if ((paramFileManagerEntity.lastTime > 0L) && (paramFileManagerEntity.lastTime <= System.currentTimeMillis() / 1000L))
      {
        QfavUtil.a(paramActivity, 2131364639, 1);
        QfavReport.a(paramQQAppInterface, "User_AddFav", 6, -80011, m, i, str, null);
        return;
      }
      break;
    case 4: 
      if ((104 == paramFileManagerEntity.busId) && (paramFileManagerEntity.lastTime > 0L) && (paramFileManagerEntity.lastTime <= System.currentTimeMillis() / 1000L))
      {
        QfavUtil.a(paramActivity, 2131364639, 1);
        QfavReport.a(paramQQAppInterface, "User_AddFav", 6, -80011, m, i, str, null);
        return;
      }
      break;
    }
    Object localObject;
    if (paramChatMessage != null)
    {
      a(paramQQAppInterface, paramChatMessage);
      localObject = "";
      paramChatMessage = (ChatMessage)localObject;
    }
    label388:
    int k;
    switch (i1)
    {
    default: 
      paramChatMessage = (ChatMessage)localObject;
    case 3: 
      localObject = new ContentValues();
      ((ContentValues)localObject).put("fileUuId", paramChatMessage);
      ((ContentValues)localObject).put("fileCloudType", Integer.valueOf(i1));
      ((ContentValues)localObject).put("fileSize", Long.valueOf(paramFileManagerEntity.fileSize));
      ((ContentValues)localObject).put("fileName", paramFileManagerEntity.fileName);
      ((ContentValues)localObject).put("fileMd5", paramFileManagerEntity.strFileMd5);
      ((ContentValues)localObject).put("filePath", paramFileManagerEntity.strFilePath);
      ((ContentValues)localObject).put("fileThumbPath", paramFileManagerEntity.strThumbPath);
      ((ContentValues)localObject).put("filePeerType", Integer.valueOf(paramFileManagerEntity.peerType));
      this.a.putExtra("fileContents", (Parcelable)localObject);
      a(paramActivity, paramQQAppInterface.getAccount());
      QfavReport.a(paramQQAppInterface, "User_AddFav", 6, 0, m, i, str, null);
      return;
      paramChatMessage = paramFileManagerEntity.selfUin;
      localObject = paramFileManagerEntity.peerUin;
      if (paramFileManagerEntity.bSend)
      {
        k = 1;
        label560:
        int n = 0;
        switch (paramFileManagerEntity.peerType)
        {
        default: 
          j = n;
          if (!paramFileManagerEntity.bSend)
          {
            paramChatMessage = paramFileManagerEntity.peerUin;
            j = n;
          }
          label629:
          if (TextUtils.isEmpty(paramChatMessage))
          {
            paramChatMessage = paramQQAppInterface.a();
            k = 1;
          }
          break;
        }
      }
      break;
    }
    for (;;)
    {
      a(paramQQAppInterface, null, paramChatMessage, (String)localObject, k, j);
      break;
      k = 0;
      break label560;
      j = 1;
      break label629;
      j = 3000;
      break label629;
      j = 1004;
      break label629;
      paramChatMessage = paramFileManagerEntity.Uuid;
      break label388;
      paramChatMessage = paramFileManagerEntity.strTroopFilePath;
      break label388;
      paramChatMessage = paramFileManagerEntity.WeiYunFileId;
      break label388;
    }
  }
  
  public boolean a(Activity paramActivity, String paramString, int paramInt, Intent paramIntent)
  {
    if (paramActivity == null) {
      return false;
    }
    this.a.putExtra("nOperation", 0);
    this.a.putExtra("lCollectTime", System.currentTimeMillis());
    if (paramIntent != null)
    {
      paramIntent.putExtras(this.a);
      switch (paramIntent.getIntExtra("nType", 0))
      {
      }
    }
    String str;
    do
    {
      return QfavPluginProxyActivity.a(paramActivity, paramString, paramIntent, paramInt);
      paramIntent = this.a;
      break;
      str = paramIntent.getStringExtra("sPath");
    } while ((paramIntent.getIntExtra("nPicType", 1) != 1) || (!QfavUtil.a(str, paramIntent.getLongExtra("lSize", -1L))));
    paramIntent.putExtra("nReasonInt", 2131364696);
    if (QLog.isColorLevel()) {
      QLog.i("qqfav", 2, "QfavBuilder.add: picture too big [" + str + "]");
    }
    QfavReport.a(null, "Net_AddFav", 3, 3, -3);
    return false;
  }
  
  public QfavBuilder b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    return a(paramQQAppInterface, paramMessageRecord).a("lCreateTime", paramMessageRecord.time * 1000L);
  }
  
  public QfavBuilder b(String paramString1, String paramString2)
  {
    this.a.putExtra(paramString1, paramString2);
    return this;
  }
  
  public void b(Activity paramActivity, String paramString)
  {
    Object localObject = null;
    if (!a(paramActivity, paramString, -1, null))
    {
      paramString = localObject;
      if (0 == 0) {
        paramString = this.a;
      }
      QQToast.a(paramActivity, 1, paramString.getIntExtra("nReasonInt", 2131364636), 2000).b(0);
      return;
    }
    QQToast.a(paramActivity, 2, 2131364628, 2000).b(0);
    QfavUtil.a(paramActivity, paramString, true);
  }
  
  public QfavBuilder c(Entity paramEntity)
  {
    this.a.putExtra("cvEntityContents", QfavUtil.a(paramEntity, ""));
    this.a.putExtra("sEntityClassName", paramEntity.getClass().getName());
    return this;
  }
  
  public QfavBuilder c(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      this.a.putExtra("nAuthorType", 1).putExtra("lUin", l);
      return this;
    }
    catch (Exception paramString) {}
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qqfav.QfavBuilder
 * JD-Core Version:    0.7.0.1
 */