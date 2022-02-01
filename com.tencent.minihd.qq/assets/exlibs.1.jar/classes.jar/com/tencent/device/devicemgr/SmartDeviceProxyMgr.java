package com.tencent.device.devicemgr;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.JNICallCenter.DataPoint;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.device.file.DeviceAVFileMsgObserver;
import com.tencent.device.msg.data.DevSingleStructMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.utils.LightAppUtil;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.smartdevice.ipc.SmartDeviceIPCHost;
import czq;
import czr;
import czs;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;

public class SmartDeviceProxyMgr
  extends BusinessHandler
{
  public static final int a = 0;
  private static final String jdField_a_of_type_JavaLangString = "SmartDeviceProxyMgr";
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int f = 0;
  public static final int g = 1;
  public static final int h = 2;
  private static final int k = 300000;
  private static final int l = 1000;
  private long jdField_a_of_type_Long = 0L;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new czq(this));
  private SmartDeviceIPCHost jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost;
  czs jdField_a_of_type_Czs = null;
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  public DeviceInfo[] a;
  public int e = 0;
  public int i = 0;
  private int j = 0;
  
  public SmartDeviceProxyMgr(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ArrayOfComTencentDeviceDatadefDeviceInfo = null;
    this.j = SettingCloneUtil.readValueForInt(BaseApplication.getContext(), paramQQAppInterface.a(), null, "qqsetting_deviceplugin_autoload_key", 0);
    this.jdField_a_of_type_Czs = new czs(this);
    paramQQAppInterface = new IntentFilter();
    paramQQAppInterface.addAction("SmartDevice_devListChang");
    paramQQAppInterface.addAction("onDeviceDisconnected");
    paramQQAppInterface.addAction("onDeviceLogined");
    paramQQAppInterface.addAction("SmartDevice_login");
    paramQQAppInterface.addAction("SmartDevice_clickOnDeviceList");
    paramQQAppInterface.addAction("mqq.intent.action.LOGOUT");
    BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_Czs, paramQQAppInterface);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 300000L);
    c("SmartDeviceProxyMgr::post delay task in 5 minutes to install plugin");
  }
  
  private void a(int paramInt, long paramLong, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ArrayOfComTencentDeviceDatadefDeviceInfo = null;
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "login");
    localBundle.putInt("iAppID", paramInt);
    localBundle.putLong("uin", paramLong);
    localBundle.putByteArray("a2", paramArrayOfByte);
    if (paramString1 != null) {
      localBundle.putString("strOpenId", paramString1);
    }
    if (paramString2 != null) {
      localBundle.putString("strAccessToken", paramString2);
    }
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost != null) {
      this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
    }
  }
  
  /* Error */
  private boolean b()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 41	com/tencent/device/devicemgr/SmartDeviceProxyMgr:jdField_a_of_type_Boolean	Z
    //   8: ifne +77 -> 85
    //   11: invokestatic 189	java/lang/System:currentTimeMillis	()J
    //   14: lstore_2
    //   15: aload_0
    //   16: iconst_1
    //   17: putfield 41	com/tencent/device/devicemgr/SmartDeviceProxyMgr:jdField_a_of_type_Boolean	Z
    //   20: aload_0
    //   21: iconst_1
    //   22: putfield 39	com/tencent/device/devicemgr/SmartDeviceProxyMgr:j	I
    //   25: aload_0
    //   26: new 178	cooperation/smartdevice/ipc/SmartDeviceIPCHost
    //   29: dup
    //   30: aload_0
    //   31: getfield 192	com/tencent/device/devicemgr/SmartDeviceProxyMgr:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   34: invokespecial 193	cooperation/smartdevice/ipc/SmartDeviceIPCHost:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   37: putfield 176	com/tencent/device/devicemgr/SmartDeviceProxyMgr:jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost	Lcooperation/smartdevice/ipc/SmartDeviceIPCHost;
    //   40: aload_0
    //   41: getfield 192	com/tencent/device/devicemgr/SmartDeviceProxyMgr:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   44: bipush 51
    //   46: invokevirtual 196	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   49: pop
    //   50: invokestatic 189	java/lang/System:currentTimeMillis	()J
    //   53: lstore 4
    //   55: aload_0
    //   56: new 198	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   63: ldc 201
    //   65: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: lload 4
    //   70: lload_2
    //   71: lsub
    //   72: invokevirtual 208	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   75: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokespecial 136	com/tencent/device/devicemgr/SmartDeviceProxyMgr:c	(Ljava/lang/String;)V
    //   81: aload_0
    //   82: monitorexit
    //   83: iload_1
    //   84: ireturn
    //   85: iconst_0
    //   86: istore_1
    //   87: goto -6 -> 81
    //   90: astore 6
    //   92: aload_0
    //   93: monitorexit
    //   94: aload 6
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	SmartDeviceProxyMgr
    //   1	86	1	bool	boolean
    //   14	57	2	l1	long
    //   53	16	4	l2	long
    //   90	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	81	90	finally
  }
  
  private void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SmartDeviceProxyMgr", 2, paramString);
    }
  }
  
  public int a(Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramBundle == null))
    {
      c("in SmartDeviceProxyMgr app is null or params is null");
      return 0;
    }
    String str = paramBundle.getString("sServiceCmd");
    int m = paramBundle.getInt("nSSOSeq");
    byte[] arrayOfByte = paramBundle.getByteArray("buffer");
    int n = paramBundle.getInt("curSeqNum");
    paramBundle = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), str);
    paramBundle.addAttribute("cookie", Integer.valueOf(n));
    paramBundle.addAttribute("ssoseq", Integer.valueOf(m));
    paramBundle.setRequestSsoSeq(m);
    paramBundle.putWupBuffer(arrayOfByte);
    b(paramBundle);
    c("SmartDeviceProxyMgr::InvokeSendData sServiceCmd[" + str + "], nSSOSeq[" + m + "], curSeqNum[" + n + "]");
    return n;
  }
  
  public long a()
  {
    c("SmartDeviceProxyMgr::getSelfUin");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {
      return 0L;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "getselfuin");
    localBundle = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
    if (localBundle != null) {}
    for (long l1 = localBundle.getLong("selfuin", 0L);; l1 = 0L)
    {
      if (l1 != 0L) {
        this.jdField_a_of_type_Long = l1;
      }
      return this.jdField_a_of_type_Long;
    }
  }
  
  public DeviceInfo a(long paramLong)
  {
    int m = 0;
    c("SmartDeviceProxyMgr::getDeviceInfoByDin");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {
      return new DeviceInfo();
    }
    if (this.jdField_a_of_type_ArrayOfComTencentDeviceDatadefDeviceInfo != null) {
      while (m < this.jdField_a_of_type_ArrayOfComTencentDeviceDatadefDeviceInfo.length)
      {
        if (paramLong == this.jdField_a_of_type_ArrayOfComTencentDeviceDatadefDeviceInfo[m].din) {
          return this.jdField_a_of_type_ArrayOfComTencentDeviceDatadefDeviceInfo[m];
        }
        m += 1;
      }
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "getinfobydin");
    localBundle.putLong("din", paramLong);
    localBundle = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
    if (localBundle == null) {
      return new DeviceInfo();
    }
    return (DeviceInfo)localBundle.getParcelable("deviceinfo");
  }
  
  public DeviceInfo a(String paramString)
  {
    int m = 0;
    c("SmartDeviceProxyMgr::getDeviceInfoBySerialNum");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {
      return null;
    }
    if (this.jdField_a_of_type_ArrayOfComTencentDeviceDatadefDeviceInfo != null) {
      while (m < this.jdField_a_of_type_ArrayOfComTencentDeviceDatadefDeviceInfo.length)
      {
        if (paramString.compareToIgnoreCase(this.jdField_a_of_type_ArrayOfComTencentDeviceDatadefDeviceInfo[m].serialNum) == 0) {
          return this.jdField_a_of_type_ArrayOfComTencentDeviceDatadefDeviceInfo[m];
        }
        m += 1;
      }
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "getDeviceInfoBySerialNum");
    localBundle.putString("serialNum", paramString);
    paramString = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
    if (paramString == null) {
      return null;
    }
    return (DeviceInfo)paramString.getParcelable("deviceinfo");
  }
  
  public ProductInfo a(int paramInt)
  {
    c("SmartDeviceProxyMgr::getProductInfo");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {}
    do
    {
      return null;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
        return (ProductInfo)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("notify_cmd", "getProductInfo");
      ((Bundle)localObject).putInt("productId", paramInt);
      localObject = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a((Bundle)localObject);
    } while (localObject == null);
    Object localObject = (ProductInfo)((Bundle)localObject).getParcelable("productInfo");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localObject);
    return localObject;
  }
  
  protected Class a()
  {
    return null;
  }
  
  public String a()
  {
    TicketManager localTicketManager = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    if (localTicketManager != null) {
      return localTicketManager.getA2(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    }
    return "";
  }
  
  public ArrayList a()
  {
    c("SmartDeviceProxyMgr::getLiteAppSettingList");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {}
    Bundle localBundle;
    do
    {
      return null;
      localBundle = new Bundle();
      localBundle.putString("notify_cmd", "getLiteAppSettingList");
      localBundle = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
    } while (localBundle == null);
    return localBundle.getParcelableArrayList("settinglist");
  }
  
  public void a()
  {
    c("SmartDeviceProxyMgr::scanNearByDevice");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "scanNearByDevice");
    this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
  }
  
  public void a(int paramInt)
  {
    c("SmartDeviceProxyMgr::setHasBindDeviceFlag");
    if (paramInt == 1) {
      this.j = paramInt;
    }
    SettingCloneUtil.writeValueForInt(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null, "qqsetting_deviceplugin_autoload_key", this.j);
    if (paramInt == 1) {
      a(false);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    c("SmartDeviceProxyMgr::queryIsDeviceHasBeenBinded");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "queryIsDeviceHasBeenBinded");
    localBundle.putInt("productId", paramInt);
    localBundle.putString("serialNum", paramString);
    this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
  }
  
  public void a(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    c("SmartDeviceProxyMgr::onRecvData");
    a(false);
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "notifyCmdReceivePush");
    localBundle.putInt("nSSOSeq", paramInt);
    if (paramString != null) {
      localBundle.putString("sServiceCmd", paramString);
    }
    if (paramArrayOfByte != null) {
      localBundle.putByteArray("buffer", paramArrayOfByte);
    }
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost != null) {
      this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
    }
  }
  
  public void a(Activity paramActivity, DeviceInfo paramDeviceInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKQQAgentPerf", 2, "liteAppEntry:" + System.currentTimeMillis());
    }
    a(false);
    if (paramDeviceInfo == null)
    {
      ToastUtil.a().a("设备信息为空");
      return;
    }
    new LightAppUtil(paramActivity).a(paramDeviceInfo);
  }
  
  public void a(Bundle paramBundle)
  {
    c("SmartDeviceProxyMgr::InvokeOpenChatMsgActivity");
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramBundle == null))
    {
      c("in SmartDeviceProxyMgr InvokeOpenChatMsgActivity app is null or params is null");
      return;
    }
    Object localObject = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    ((DeviceMsgHandle)localObject).a().b();
    ((DeviceMsgHandle)localObject).a().a();
    localObject = paramBundle.getString("din");
    String str = paramBundle.getString("devName");
    Boolean localBoolean = Boolean.valueOf(paramBundle.getBoolean("bFromLightApp", false));
    int m = paramBundle.getInt("operType");
    paramBundle = Looper.getMainLooper();
    if (Thread.currentThread() != paramBundle.getThread())
    {
      new Handler(paramBundle).post(new czr(this, (String)localObject, str, localBoolean, m));
      return;
    }
    paramBundle = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), ChatActivity.class);
    paramBundle.addFlags(268435456);
    paramBundle.addFlags(131072);
    paramBundle.putExtra("uin", (String)localObject);
    paramBundle.putExtra("uinname", str);
    paramBundle.putExtra("bFromLightApp", localBoolean);
    paramBundle.putExtra("uintype", 9501);
    paramBundle.putExtra("operType", m);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().startActivity(paramBundle);
  }
  
  public void a(DataPoint paramDataPoint, int paramInt1, int paramInt2, int paramInt3)
  {
    c("SmartDeviceProxyMgr::sendCSDataPointMsg");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "sendCSDataPointMsg");
    localBundle.putParcelable("datapoint", paramDataPoint);
    localBundle.putInt("cookie", paramInt1);
    localBundle.putLong("msgtype", paramInt2);
    localBundle.putLong("msgSubType", paramInt3);
    this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
  }
  
  public void a(DataPoint paramDataPoint, int paramInt, long paramLong)
  {
    c("SmartDeviceProxyMgr::sendCCDataPointMsg");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "sendCCDataPointMsg");
    localBundle.putParcelable("datapoint", paramDataPoint);
    localBundle.putInt("cookie", paramInt);
    localBundle.putLong("din", paramLong);
    this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    c("SmartDeviceProxyMgr::onReceive");
    a(false);
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "notifyCmdReceiveData");
    if (paramToServiceMsg != null) {
      localBundle.putParcelable("req", paramToServiceMsg);
    }
    if (paramFromServiceMsg != null) {
      localBundle.putParcelable("res", paramFromServiceMsg);
    }
    if (paramObject != null) {
      localBundle.putByteArray("data", (byte[])paramObject);
    }
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost != null) {
      this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
    }
  }
  
  public void a(String paramString)
  {
    c("SmartDeviceProxyMgr::unBind");
    a(false);
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "unBind");
    if (paramString != null) {
      localBundle.putString("gUID", paramString);
    }
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost != null) {
      this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    c("SmartDeviceProxyMgr::setRemark");
    a(false);
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "setRemark");
    if (paramString1 != null) {
      localBundle.putString("serialNum", paramString1);
    }
    if (paramString2 != null) {
      localBundle.putString("str", paramString2);
    }
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost != null) {
      this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    c("SmartDeviceProxyMgr::transferAppSettingList");
    a(false);
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "transferLiteAppSettingList");
    if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
      localBundle.putParcelableArrayList("settinglist", paramArrayList);
    }
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost != null) {
      this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("SmartDeviceProxyMgr::startPlugin, forceRefresh: ");
    if (paramBoolean) {}
    for (String str = "yes";; str = "no")
    {
      c(str);
      if (b()) {
        b(paramBoolean);
      }
      return;
    }
  }
  
  public boolean a()
  {
    return this.j == 1;
  }
  
  public boolean a(int paramInt)
  {
    c("SmartDeviceProxyMgr::fetchProductInfo");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {
      return false;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "fetchProductInfo");
    localBundle.putInt("productId", paramInt);
    this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
    return true;
  }
  
  public boolean a(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    c("SmartDeviceProxyMgr::datalineSendCSMsg");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {
      return false;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "datalineSendCSMsg");
    localBundle.putInt("subType", paramInt1);
    localBundle.putInt("cookie", paramInt2);
    localBundle.putByteArray("data", paramArrayOfByte);
    this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
    return true;
  }
  
  public boolean a(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    c("SmartDeviceProxyMgr::datalineSendCCMsg");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {
      return false;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "datalineSendCCMsg");
    localBundle.putLong("din", paramLong);
    localBundle.putInt("sendCookie", paramInt);
    localBundle.putByteArray("bodyContent", paramArrayOfByte);
    this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
    return true;
  }
  
  public byte[] a()
  {
    String str = a();
    if (!TextUtils.isEmpty(str))
    {
      c("device login,a2 len is:" + str.length());
      return HexUtil.a(a());
    }
    return HexUtil.a("");
  }
  
  public DeviceInfo[] a()
  {
    int n = 0;
    if (this.jdField_a_of_type_ArrayOfComTencentDeviceDatadefDeviceInfo != null) {}
    for (int m = this.jdField_a_of_type_ArrayOfComTencentDeviceDatadefDeviceInfo.length;; m = 0)
    {
      c("SmartDeviceProxyMgr::getServerDeviceList" + m);
      a(false);
      if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {
        return null;
      }
      if (this.jdField_a_of_type_ArrayOfComTencentDeviceDatadefDeviceInfo == null)
      {
        Object localObject = new Bundle();
        ((Bundle)localObject).putString("notify_cmd", "getServerDeviceList");
        localObject = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a((Bundle)localObject);
        if (localObject == null) {
          return null;
        }
        localObject = ((Bundle)localObject).getParcelableArray("devicelist");
        DeviceInfo[] arrayOfDeviceInfo = new DeviceInfo[localObject.length];
        m = n;
        while (m < localObject.length)
        {
          arrayOfDeviceInfo[m] = ((DeviceInfo)localObject[m]);
          m += 1;
        }
        this.jdField_a_of_type_ArrayOfComTencentDeviceDatadefDeviceInfo = arrayOfDeviceInfo;
      }
      return this.jdField_a_of_type_ArrayOfComTencentDeviceDatadefDeviceInfo;
    }
  }
  
  public DeviceInfo b(String paramString)
  {
    c("SmartDeviceProxyMgr::getDeviceInfoBySerialNumInNFCList");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {}
    do
    {
      return null;
      Bundle localBundle = new Bundle();
      localBundle.putString("notify_cmd", "getDeviceInfoBySerialNumInNFCList");
      localBundle.putString("serialNum", paramString);
      paramString = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
    } while (paramString == null);
    return (DeviceInfo)paramString.getParcelable("deviceinfo");
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Boolean) && (2 == this.e))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("notify_cmd", "logout");
      if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost != null) {
        this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
      }
    }
    this.e = 0;
    this.i = 0;
  }
  
  public void b(String paramString) {}
  
  /* Error */
  public void b(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 198	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 646
    //   12: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: astore 4
    //   17: iload_1
    //   18: ifeq +41 -> 59
    //   21: ldc_w 583
    //   24: astore_3
    //   25: aload_0
    //   26: aload 4
    //   28: aload_3
    //   29: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokespecial 136	com/tencent/device/devicemgr/SmartDeviceProxyMgr:c	(Ljava/lang/String;)V
    //   38: iconst_1
    //   39: aload_0
    //   40: getfield 56	com/tencent/device/devicemgr/SmartDeviceProxyMgr:e	I
    //   43: if_icmpeq +13 -> 56
    //   46: aload_0
    //   47: getfield 58	com/tencent/device/devicemgr/SmartDeviceProxyMgr:i	I
    //   50: istore_2
    //   51: iconst_1
    //   52: iload_2
    //   53: if_icmpne +13 -> 66
    //   56: aload_0
    //   57: monitorexit
    //   58: return
    //   59: ldc_w 589
    //   62: astore_3
    //   63: goto -38 -> 25
    //   66: iload_1
    //   67: ifeq +13 -> 80
    //   70: aload_0
    //   71: iconst_0
    //   72: putfield 56	com/tencent/device/devicemgr/SmartDeviceProxyMgr:e	I
    //   75: aload_0
    //   76: iconst_0
    //   77: putfield 58	com/tencent/device/devicemgr/SmartDeviceProxyMgr:i	I
    //   80: aload_0
    //   81: getfield 56	com/tencent/device/devicemgr/SmartDeviceProxyMgr:e	I
    //   84: ifeq +11 -> 95
    //   87: iconst_3
    //   88: aload_0
    //   89: getfield 56	com/tencent/device/devicemgr/SmartDeviceProxyMgr:e	I
    //   92: if_icmpne -36 -> 56
    //   95: aload_0
    //   96: ldc_w 647
    //   99: aload_0
    //   100: getfield 192	com/tencent/device/devicemgr/SmartDeviceProxyMgr:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   103: invokevirtual 87	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   106: invokestatic 653	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   109: aload_0
    //   110: invokevirtual 655	com/tencent/device/devicemgr/SmartDeviceProxyMgr:a	()[B
    //   113: ldc_w 368
    //   116: ldc_w 368
    //   119: invokespecial 657	com/tencent/device/devicemgr/SmartDeviceProxyMgr:a	(IJ[BLjava/lang/String;Ljava/lang/String;)V
    //   122: aload_0
    //   123: iconst_1
    //   124: putfield 56	com/tencent/device/devicemgr/SmartDeviceProxyMgr:e	I
    //   127: goto -71 -> 56
    //   130: astore_3
    //   131: aload_0
    //   132: monitorexit
    //   133: aload_3
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	SmartDeviceProxyMgr
    //   0	135	1	paramBoolean	boolean
    //   50	4	2	m	int
    //   24	39	3	str	String
    //   130	4	3	localObject	Object
    //   15	12	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	17	130	finally
    //   25	51	130	finally
    //   70	80	130	finally
    //   80	95	130	finally
    //   95	127	130	finally
  }
  
  public DeviceInfo[] b()
  {
    c("SmartDeviceProxyMgr::getNFCDeviceList");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {
      return null;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("notify_cmd", "getNFCDeviceList");
    localObject = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a((Bundle)localObject);
    if (localObject == null) {
      return null;
    }
    localObject = ((Bundle)localObject).getParcelableArray("devicelist");
    DeviceInfo[] arrayOfDeviceInfo = new DeviceInfo[localObject.length];
    int m = 0;
    while (m < localObject.length)
    {
      arrayOfDeviceInfo[m] = ((DeviceInfo)localObject[m]);
      m += 1;
    }
    return arrayOfDeviceInfo;
  }
  
  public void c()
  {
    c("SmartDeviceProxyMgr::updateServerDeviceList");
    a(false);
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "updateServerDeviceList");
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost != null) {
      this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
    }
  }
  
  public void d()
  {
    c("SmartDeviceProxyMgr::updateDeviceStatus");
    a(false);
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "updateDeviceStatus");
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost != null) {
      this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
    }
  }
  
  public void e()
  {
    super.e();
    BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_Czs);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.device.devicemgr.SmartDeviceProxyMgr
 * JD-Core Version:    0.7.0.1
 */