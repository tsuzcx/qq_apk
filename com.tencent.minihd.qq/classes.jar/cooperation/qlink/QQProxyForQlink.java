package cooperation.qlink;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import lxv;
import lxw;
import lxx;
import lxy;
import lxz;

public class QQProxyForQlink
  implements QlAndQQInterface.QQ2Ql, QlAndQQInterface.Ql2QQ
{
  private static final String jdField_a_of_type_JavaLangString = "QQProxyForQlink";
  private static final String jdField_b_of_type_JavaLangString = "_QLINK_FILEASSIS_ENTER_NEW_";
  private int jdField_a_of_type_Int;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new lxz(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private QQProxyForQlink.WState jdField_a_of_type_CooperationQlinkQQProxyForQlink$WState = new QQProxyForQlink.WState();
  private int jdField_b_of_type_Int;
  private String c;
  
  public QQProxyForQlink(QQAppInterface paramQQAppInterface)
  {
    this.b = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.qlink.finishworkingdlg");
    if ((paramQQAppInterface != null) && (paramQQAppInterface.a() != null)) {
      paramQQAppInterface.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  public static void a(Context paramContext, int paramInt, Bundle paramBundle)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQProxyForQlink", 2, "[QLINK] QQ - startQlink failed context=null!");
      }
      Toast.makeText(BaseApplication.getContext(), "加载失败，请重试", 0).show();
      return;
    }
    Intent localIntent = new Intent(paramContext, QlinkBridgeActivity.class);
    localIntent.putExtra("_from_", paramInt);
    if (paramBundle != null) {
      localIntent.putExtra("_param_", paramBundle);
    }
    if ((9 == paramInt) || (10 == paramInt)) {
      localIntent.addFlags(268435456);
    }
    paramContext.startActivity(localIntent);
  }
  
  private boolean b()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    if (str == null) {
      return false;
    }
    if ((-1 == this.b) || (!str.equalsIgnoreCase(this.c)))
    {
      this.c = str;
      this.b = 1;
    }
    try
    {
      this.b = BaseApplication.getContext().getSharedPreferences("_QLINK_FILEASSIS_ENTER_NEW_", 0).getInt(str, 0);
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public QQProxyForQlink.WState a()
  {
    return this.jdField_a_of_type_CooperationQlinkQQProxyForQlink$WState;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = paramInt;
    if (i != this.jdField_a_of_type_Int)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("QQProxyForQlink", 4, "[QLINK]-QQ UI_LOG:notifyGoingonTransChanged.count:" + paramInt);
      }
      Handler localHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
      if (localHandler != null) {
        localHandler.obtainMessage(1134025, null).sendToTarget();
      }
    }
  }
  
  public void a(Activity paramActivity, String paramString, int paramInt)
  {
    if ((paramActivity == null) || (paramString == null)) {
      return;
    }
    switch (paramInt)
    {
    }
    while (!this.jdField_a_of_type_CooperationQlinkQQProxyForQlink$WState.jdField_a_of_type_Boolean)
    {
      Intent localIntent = new Intent(paramActivity, QlinkSendTipsActivity.class);
      localIntent.putExtra("_FILE_PATH_", paramString);
      localIntent.putExtra("_SEND_FILE_SRC_", paramInt);
      paramActivity.startActivity(localIntent);
      paramActivity.overridePendingTransition(0, 0);
      return;
      a("0X800484F", 1);
      continue;
      a("0X800485B", 1);
      continue;
      a("0X800485E", 1);
      continue;
      a("0X8004858", 1);
    }
    a(paramString, paramActivity, new lxv(this, paramString, paramActivity), new lxw(this), new lxx(this));
  }
  
  public void a(Bundle paramBundle)
  {
    int j = 1;
    int i = 1;
    if (paramBundle != null)
    {
      k = paramBundle.getInt("wstate_state", -1);
      bool = paramBundle.getBoolean("wstate_issend", false);
      str = paramBundle.getString("wstate_peeruin");
      paramBundle = paramBundle.getString("wstate_peernick");
      if (QLog.isDevelopLevel()) {
        QLog.d("QQProxyForQlink", 4, "[QLINK]-QQ syncState::what:" + k + " issend:" + bool + " uin:" + str + " nick:" + paramBundle);
      }
      if (1 == k)
      {
        if ((this.jdField_a_of_type_CooperationQlinkQQProxyForQlink$WState.jdField_a_of_type_Boolean) && (QLog.isDevelopLevel())) {
          QLog.w("QQProxyForQlink", 4, "[QLINK]-QQ syncState:START but had start");
        }
        this.jdField_a_of_type_CooperationQlinkQQProxyForQlink$WState.jdField_a_of_type_Boolean = true;
        localWState = this.jdField_a_of_type_CooperationQlinkQQProxyForQlink$WState;
        if (bool)
        {
          localWState.jdField_a_of_type_Int = i;
          this.jdField_a_of_type_CooperationQlinkQQProxyForQlink$WState.jdField_a_of_type_JavaLangString = str;
          this.jdField_a_of_type_CooperationQlinkQQProxyForQlink$WState.b = paramBundle;
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      int k;
      String str;
      do
      {
        boolean bool;
        for (;;)
        {
          QQProxyForQlink.WState localWState;
          return;
          i = 2;
        }
        if (3 == k)
        {
          if ((!this.jdField_a_of_type_CooperationQlinkQQProxyForQlink$WState.jdField_a_of_type_Boolean) && (QLog.isDevelopLevel())) {
            QLog.w("QQProxyForQlink", 4, "[QLINK]-QQ syncState:STOP but had stop");
          }
          this.jdField_a_of_type_CooperationQlinkQQProxyForQlink$WState.jdField_a_of_type_Boolean = false;
          paramBundle = this.jdField_a_of_type_CooperationQlinkQQProxyForQlink$WState;
          if (bool) {}
          for (i = j;; i = 2)
          {
            paramBundle.jdField_a_of_type_Int = i;
            this.jdField_a_of_type_CooperationQlinkQQProxyForQlink$WState.jdField_a_of_type_JavaLangString = null;
            this.jdField_a_of_type_CooperationQlinkQQProxyForQlink$WState.b = null;
            return;
          }
        }
      } while ((2 != k) || (str == null) || (!str.equalsIgnoreCase(this.jdField_a_of_type_CooperationQlinkQQProxyForQlink$WState.jdField_a_of_type_JavaLangString)));
      if ((!this.jdField_a_of_type_CooperationQlinkQQProxyForQlink$WState.jdField_a_of_type_Boolean) && (QLog.isDevelopLevel())) {
        QLog.w("QQProxyForQlink", 4, "[QLINK]-QQ syncState:NICK_SYNC  but had stop");
      }
      this.jdField_a_of_type_CooperationQlinkQQProxyForQlink$WState.b = paramBundle;
      return;
    }
    QLog.e("QQProxyForQlink", 2, "[QLINK]-QQ syncState info=null:");
  }
  
  public void a(QlAndQQInterface.DailogClickInfo paramDailogClickInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable(QlAndQQInterface.jdField_a_of_type_JavaLangString, paramDailogClickInfo);
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("cmd.senddailogclickinfo", localBundle);
    if (QLog.isDevelopLevel()) {
      QLog.d("QQProxyForQlink", 4, "[QLINK]-QQ sendDailogClick:" + i);
    }
  }
  
  public void a(QlAndQQInterface.InsertFMFileInfo paramInsertFMFileInfo)
  {
    if (paramInsertFMFileInfo == null) {
      return;
    }
    String str = FileManagerUtil.a(paramInsertFMFileInfo.filePath);
    long l1 = FileManagerUtil.a(paramInsertFMFileInfo.filePath);
    long l2 = MessageRecordFactory.a(-1000).uniseq;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l2, paramInsertFMFileInfo.uin, 0);
    localFileManagerEntity.cloudType = 5;
    localFileManagerEntity.nSessionId = paramInsertFMFileInfo.sessionId;
    localFileManagerEntity.strFilePath = paramInsertFMFileInfo.filePath;
    localFileManagerEntity.strThumbPath = paramInsertFMFileInfo.thumbPath;
    localFileManagerEntity.fileName = str;
    localFileManagerEntity.fileSize = l1;
    localFileManagerEntity.srvTime = (MessageCache.a() * 1000L);
    localFileManagerEntity.msgSeq = FileManagerUtil.a();
    localFileManagerEntity.msgUid = FileManagerUtil.b();
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerUin = paramInsertFMFileInfo.uin;
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
    if (localFriendsManager.c(String.valueOf(localFileManagerEntity.peerUin)) != null)
    {
      localFileManagerEntity.peerType = 0;
      localFileManagerEntity.peerNick = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInsertFMFileInfo.uin, null, 0);
      localFileManagerEntity.status = 1;
      if ((!localFriendsManager.b(paramInsertFMFileInfo.uin)) && (!paramInsertFMFileInfo.bSend)) {
        break label279;
      }
      localFileManagerEntity.nOpType = 0;
      localFileManagerEntity.bSend = true;
      TransfileUtile.a(paramInsertFMFileInfo.filePath, 0L, 0, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity);
      return;
      localFileManagerEntity.peerType = 1003;
      break;
      label279:
      localFileManagerEntity.nOpType = 1;
      localFileManagerEntity.bSend = false;
      TransfileUtile.a(paramInsertFMFileInfo.filePath, l1, 0, false, null);
      BuddyTransfileProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), str, 0, null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
    }
  }
  
  public void a(QlAndQQInterface.UserInfo paramUserInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable(QlAndQQInterface.jdField_a_of_type_JavaLangString, paramUserInfo);
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("cmd.senduserinfo", localBundle);
    if (QLog.isDevelopLevel()) {
      QLog.d("QQProxyForQlink", 4, "[QLINK]-QQ sendUserInfo:" + i);
    }
  }
  
  public void a(String paramString)
  {
    Object localObject = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    if (localObject != null)
    {
      localObject = ((FriendManager)localObject).c(paramString);
      if (localObject != null)
      {
        QlAndQQInterface.UserInfo localUserInfo = new QlAndQQInterface.UserInfo();
        localUserInfo.uin = paramString;
        localUserInfo.nick = ((String)localObject);
        a(localUserInfo);
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QQProxyForQlink", 4, "QLINK_CLICK_EVENT: act=" + paramString + " count:" + paramInt);
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", paramString, paramString, 0, paramInt, 0, "", "", "", "");
  }
  
  public void a(String paramString, Activity paramActivity, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      return;
    }
    paramString = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    if (paramString != null) {}
    for (paramString = paramString.c(this.jdField_a_of_type_CooperationQlinkQQProxyForQlink$WState.jdField_a_of_type_JavaLangString);; paramString = null)
    {
      String str;
      if (paramString != null)
      {
        str = paramString;
        if (!this.jdField_a_of_type_CooperationQlinkQQProxyForQlink$WState.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString)) {}
      }
      else
      {
        if (this.jdField_a_of_type_CooperationQlinkQQProxyForQlink$WState.b == null) {
          break label215;
        }
        str = this.jdField_a_of_type_CooperationQlinkQQProxyForQlink$WState.b;
      }
      if (this.jdField_a_of_type_CooperationQlinkQQProxyForQlink$WState.jdField_a_of_type_Int == 1)
      {
        a("0X8004854", 1);
        paramString = paramActivity.getResources().getString(2131364980) + str + paramActivity.getResources().getString(2131364981);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(paramActivity, 230, paramActivity.getResources().getString(2131364942), paramString, paramActivity.getResources().getString(2131364982), paramActivity.getResources().getString(2131364983), paramOnClickListener1, paramOnClickListener2);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
          break label346;
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new lxy(this));
        return;
        label215:
        str = this.jdField_a_of_type_CooperationQlinkQQProxyForQlink$WState.jdField_a_of_type_JavaLangString;
        break;
        if (this.jdField_a_of_type_CooperationQlinkQQProxyForQlink$WState.jdField_a_of_type_Int == 2)
        {
          a("0X8004856", 1);
          paramString = str + paramActivity.getResources().getString(2131364984);
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(paramActivity, 230, paramActivity.getResources().getString(2131364942), paramString, paramActivity.getResources().getString(2131364985), paramActivity.getResources().getString(2131364985), paramOnClickListener3, null);
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        }
        else if (QLog.isColorLevel())
        {
          QLog.e("QQProxyForQlink", 2, "[QLINK] QQ - working but op err");
        }
      }
      label346:
      break;
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap paramHashMap)
  {
    QlinkReliableReport.a(paramString1, paramString2, paramBoolean, paramLong1, paramLong2, paramHashMap);
  }
  
  @TargetApi(9)
  public void a(boolean paramBoolean)
  {
    int i = 0;
    if (!b()) {}
    do
    {
      return;
      if (paramBoolean) {
        i = 1;
      }
    } while (this.b == i);
    this.b = i;
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    SharedPreferences.Editor localEditor;
    try
    {
      localEditor = BaseApplication.getContext().getSharedPreferences("_QLINK_FILEASSIS_ENTER_NEW_", 0).edit();
      localEditor.putInt(str, this.b);
      if (Build.VERSION.SDK_INT < 9)
      {
        localEditor.commit();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    localEditor.apply();
  }
  
  public boolean a()
  {
    if (!b()) {}
    while (this.b != 0) {
      return false;
    }
    return true;
  }
  
  public boolean a(QlAndQQInterface.SendFileInfos paramSendFileInfos)
  {
    boolean bool = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("0X8004763", 1);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable(QlAndQQInterface.jdField_a_of_type_JavaLangString, paramSendFileInfos);
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("cmd.sendfilemsgs", localBundle);
    if (QLog.isDevelopLevel()) {
      QLog.d("QQProxyForQlink", 4, "[QLINK]-QQ QQ2QlSendFileMsgs:" + i);
    }
    if (i == -1) {
      bool = false;
    }
    return bool;
  }
  
  public boolean a(String paramString, List paramList)
  {
    if ((paramList == null) || (paramString == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("QQProxyForQlink", 2, "[QLINK]-QQ sendFileMsgs. param error");
      }
    }
    do
    {
      return false;
      if (paramList.size() > 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("QQProxyForQlink", 2, "[QLINK]-QQ sendFileMsgs. no any file");
    return false;
    QlAndQQInterface.SendFileInfos localSendFileInfos = new QlAndQQInterface.SendFileInfos();
    localSendFileInfos.strUin = paramString;
    new ArrayList();
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      paramList = (String)paramString.next();
      QlAndQQInterface.SendFileInfo localSendFileInfo = new QlAndQQInterface.SendFileInfo();
      localSendFileInfo.sessionid = FileManagerUtil.a().longValue();
      localSendFileInfo.filePath = paramList;
      localSendFileInfo.fileSize = FileManagerUtil.a(paramList);
      localSendFileInfos.infos.add(localSendFileInfo);
    }
    return a(localSendFileInfos);
  }
  
  public void b() {}
  
  public void b(Bundle paramBundle)
  {
    int i = paramBundle.getInt("Event", 0);
    switch (i)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("QQProxyForQlink", 2, "[QLINK] QQ - unimplement event[" + i + "]");
      }
    case 18: 
    case 19: 
      do
      {
        return;
        a(paramBundle.getString("action_name"), paramBundle.getInt(QlAndQQInterface.jdField_a_of_type_JavaLangString));
        return;
        paramBundle = (QlAndQQInterface.ReportInfo)paramBundle.getSerializable(QlAndQQInterface.jdField_a_of_type_JavaLangString);
      } while (!(paramBundle.data instanceof QlAndQQInterface.ReportPerformanceInfo));
      paramBundle = (QlAndQQInterface.ReportPerformanceInfo)paramBundle.data;
      a(paramBundle.mUin, paramBundle.mTagName, paramBundle.mSuccess, paramBundle.mDuration, paramBundle.mSize, paramBundle.mParams);
      return;
    case 20: 
      QlinkReliableReport.a();
      return;
    case 21: 
      QlinkReliableReport.b();
      return;
    case 15: 
      a((QlAndQQInterface.InsertFMFileInfo)paramBundle.getSerializable(QlAndQQInterface.jdField_a_of_type_JavaLangString));
      return;
    case 16: 
      a(paramBundle.getInt(QlAndQQInterface.jdField_a_of_type_JavaLangString));
      return;
    case 17: 
      a(paramBundle.getString(QlAndQQInterface.jdField_a_of_type_JavaLangString));
      return;
    case 22: 
      c();
      return;
    }
    a(paramBundle.getBundle(QlAndQQInterface.jdField_a_of_type_JavaLangString));
  }
  
  public void c()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("param", 1);
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("startQlinkService", localBundle);
    if (QLog.isDevelopLevel()) {
      QLog.d("QQProxyForQlink", 4, "[QLINK]-QQ onQlinkStart:" + i);
    }
  }
  
  public void d() {}
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    }
  }
  
  public void f() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     cooperation.qlink.QQProxyForQlink
 * JD-Core Version:    0.7.0.1
 */