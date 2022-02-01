package com.tencent.biz.troop;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import cnx;
import cny;
import cnz;
import coa;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.TroopRedpoint.TroopRedTouchHandler;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.apiproxy.QQMusicService;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQMapActivityProxy;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import mqq.app.AppRuntime;
import mqq.app.AppService;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import tencent.im.group.nearbybanner.nearbybanner.ClientInfo;
import tencent.im.group.nearbybanner.nearbybanner.ReqBody;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class TroopMemberApiService
  extends AppService
{
  public static final int a = 1;
  static final String jdField_a_of_type_JavaLangString = "com.tencent.biz.troop.TroopMemberApiService";
  public static final int b = 2;
  public static final String b = "https://jubao.qq.com/cn/jubao";
  public static final int c = 3;
  public static final String c = "nearby_group_banner.get_banner_info";
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 7;
  public static final int h = 8;
  public static final int i = 9;
  public static final int j = 11;
  public static final int k = 12;
  public static final int l = 13;
  public static final int m = 14;
  public static final int n = 15;
  public static final int o = 16;
  public static final int p = 1;
  public static final int q = 2;
  final Messenger jdField_a_of_type_AndroidOsMessenger = new Messenger(new coa(this));
  QQMusicService jdField_a_of_type_ComTencentBizApiproxyQQMusicService;
  public BizTroopHandler a;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new cnx(this);
  public FriendListObserver a;
  public LBSHandler a;
  public LBSObserver a;
  public QQMapActivityProxy a;
  public Messenger b = null;
  
  public TroopMemberApiService()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new cny(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new cnz(this);
  }
  
  /* Error */
  private String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_2
    //   5: aconst_null
    //   6: aload_1
    //   7: invokestatic 97	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   10: astore_3
    //   11: aload_3
    //   12: ifnull +140 -> 152
    //   15: new 99	java/io/ByteArrayOutputStream
    //   18: dup
    //   19: invokespecial 100	java/io/ByteArrayOutputStream:<init>	()V
    //   22: astore_2
    //   23: aload_2
    //   24: astore_1
    //   25: aload_3
    //   26: getstatic 106	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   29: bipush 60
    //   31: aload_2
    //   32: invokevirtual 112	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   35: pop
    //   36: aload_2
    //   37: astore_1
    //   38: aload_2
    //   39: invokevirtual 115	java/io/ByteArrayOutputStream:flush	()V
    //   42: aload_2
    //   43: astore_1
    //   44: aload_2
    //   45: invokevirtual 118	java/io/ByteArrayOutputStream:close	()V
    //   48: aload_2
    //   49: astore_1
    //   50: aload_2
    //   51: invokevirtual 122	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   54: iconst_0
    //   55: invokestatic 128	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   58: astore_3
    //   59: aload_3
    //   60: astore_1
    //   61: aload_1
    //   62: astore_3
    //   63: aload_2
    //   64: ifnull +13 -> 77
    //   67: aload_2
    //   68: invokevirtual 115	java/io/ByteArrayOutputStream:flush	()V
    //   71: aload_2
    //   72: invokevirtual 118	java/io/ByteArrayOutputStream:close	()V
    //   75: aload_1
    //   76: astore_3
    //   77: aload_3
    //   78: areturn
    //   79: astore_2
    //   80: aload_2
    //   81: invokevirtual 131	java/io/IOException:printStackTrace	()V
    //   84: aload_1
    //   85: areturn
    //   86: astore_3
    //   87: aconst_null
    //   88: astore_2
    //   89: aload_2
    //   90: astore_1
    //   91: aload_3
    //   92: invokevirtual 131	java/io/IOException:printStackTrace	()V
    //   95: aload 4
    //   97: astore_3
    //   98: aload_2
    //   99: ifnull -22 -> 77
    //   102: aload_2
    //   103: invokevirtual 115	java/io/ByteArrayOutputStream:flush	()V
    //   106: aload_2
    //   107: invokevirtual 118	java/io/ByteArrayOutputStream:close	()V
    //   110: aconst_null
    //   111: areturn
    //   112: astore_1
    //   113: aload_1
    //   114: invokevirtual 131	java/io/IOException:printStackTrace	()V
    //   117: aconst_null
    //   118: areturn
    //   119: astore_2
    //   120: aconst_null
    //   121: astore_1
    //   122: aload_1
    //   123: ifnull +11 -> 134
    //   126: aload_1
    //   127: invokevirtual 115	java/io/ByteArrayOutputStream:flush	()V
    //   130: aload_1
    //   131: invokevirtual 118	java/io/ByteArrayOutputStream:close	()V
    //   134: aload_2
    //   135: athrow
    //   136: astore_1
    //   137: aload_1
    //   138: invokevirtual 131	java/io/IOException:printStackTrace	()V
    //   141: goto -7 -> 134
    //   144: astore_2
    //   145: goto -23 -> 122
    //   148: astore_3
    //   149: goto -60 -> 89
    //   152: aconst_null
    //   153: astore_3
    //   154: aload_2
    //   155: astore_1
    //   156: aload_3
    //   157: astore_2
    //   158: goto -97 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	this	TroopMemberApiService
    //   0	161	1	paramString	String
    //   4	68	2	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   79	2	2	localIOException1	java.io.IOException
    //   88	19	2	localObject1	Object
    //   119	16	2	localObject2	Object
    //   144	11	2	localObject3	Object
    //   157	1	2	localObject4	Object
    //   10	68	3	localObject5	Object
    //   86	6	3	localIOException2	java.io.IOException
    //   97	1	3	localObject6	Object
    //   148	1	3	localIOException3	java.io.IOException
    //   153	4	3	localObject7	Object
    //   1	95	4	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   67	75	79	java/io/IOException
    //   15	23	86	java/io/IOException
    //   102	110	112	java/io/IOException
    //   15	23	119	finally
    //   126	134	136	java/io/IOException
    //   25	36	144	finally
    //   38	42	144	finally
    //   44	48	144	finally
    //   50	59	144	finally
    //   91	95	144	finally
    //   25	36	148	java/io/IOException
    //   38	42	148	java/io/IOException
    //   44	48	148	java/io/IOException
    //   50	59	148	java/io/IOException
  }
  
  public static boolean a(AppRuntime paramAppRuntime, BusinessObserver paramBusinessObserver)
  {
    nearbybanner.ReqBody localReqBody = new nearbybanner.ReqBody();
    try
    {
      Object localObject = paramAppRuntime.getApplication().getResources().getDisplayMetrics();
      int i1 = ((DisplayMetrics)localObject).widthPixels;
      int i2 = ((DisplayMetrics)localObject).heightPixels;
      localObject = new nearbybanner.ClientInfo();
      ((nearbybanner.ClientInfo)localObject).uint32_lcd_height.set(i2);
      ((nearbybanner.ClientInfo)localObject).uint32_lcd_width.set(i1);
      ((nearbybanner.ClientInfo)localObject).bytes_client_version.set(ByteStringMicro.copyFromUtf8("5.9.3.3468"));
      ((nearbybanner.ClientInfo)localObject).uint32_os.set(0);
      localReqBody.msg_client_info.set((MessageMicro)localObject);
      localObject = new NewIntent(paramAppRuntime.getApplication(), ProtoServlet.class);
      ((NewIntent)localObject).putExtra("cmd", "nearby_group_banner.get_banner_info");
      ((NewIntent)localObject).putExtra("data", localReqBody.toByteArray());
      ((NewIntent)localObject).setObserver(paramBusinessObserver);
      paramAppRuntime.startServlet((NewIntent)localObject);
      return true;
    }
    catch (Exception paramAppRuntime) {}
    return false;
  }
  
  public QQMusicService a()
  {
    if (this.jdField_a_of_type_ComTencentBizApiproxyQQMusicService == null) {
      this.jdField_a_of_type_ComTencentBizApiproxyQQMusicService = new QQMusicService(this);
    }
    return this.jdField_a_of_type_ComTencentBizApiproxyQQMusicService;
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    Message localMessage = Message.obtain(null, paramInt);
    localMessage.setData(paramBundle);
    paramBundle = this.b;
    if (paramBundle != null) {}
    try
    {
      paramBundle.send(localMessage);
      return;
    }
    catch (RemoteException paramBundle)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("com.tencent.biz.troop.TroopMemberApiService", 2, "messeage not sent:" + paramBundle.getMessage());
    }
  }
  
  public void a(Bundle paramBundle)
  {
    int i2 = 0;
    Object localObject1;
    if ((this.app instanceof QQAppInterface))
    {
      localObject1 = (QQAppInterface)this.app;
      Object localObject2 = (TroopRedTouchManager)((QQAppInterface)localObject1).getManager(66);
      i1 = i2;
      if (localObject2 != null)
      {
        localObject2 = ((TroopRedTouchManager)localObject2).a(7);
        i1 = i2;
        if (localObject2 != null)
        {
          TroopRedTouchHandler.a((QQAppInterface)localObject1, (oidb_0x791.RedDotInfo)localObject2);
          localObject1 = (TroopRedTouchHandler)((QQAppInterface)this.app).a(45);
          i1 = i2;
          if (localObject1 != null) {
            ((TroopRedTouchHandler)localObject1).a(105, true, null);
          }
        }
      }
    }
    for (int i1 = i2;; i1 = 1)
    {
      localObject1 = new Bundle();
      if (paramBundle != null)
      {
        ((Bundle)localObject1).putInt("seq", paramBundle.getInt("seq", -1));
        if (!TextUtils.isEmpty(paramBundle.getString("callback"))) {
          ((Bundle)localObject1).putString("callback", paramBundle.getString("callback"));
        }
      }
      ((Bundle)localObject1).putString("data", "{code:\"" + i1 + "\"}");
      ((Bundle)localObject1).putString("method", "cleanDynamicRedPoint");
      a(15, (Bundle)localObject1);
      return;
      ReportController.a(null, "P_CliOper", "BizTechReport", "", "tribe", "clearreddot", 0, 1, "", "", "", "");
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppRuntime localAppRuntime = this.app;
    if ((localAppRuntime == null) || (!(localAppRuntime instanceof QQAppInterface))) {}
    do
    {
      return;
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString4))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("com.tencent.biz.troop.TroopMemberApiService", 2, "safetyReport param null");
    return;
    if (!TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      paramString2 = URLEncoder.encode(paramString2);
      paramString1 = "groupuin=" + paramString1 + "&eviluin=0&anonyid=" + paramString2 + "&impeachuin=" + paramString3 + "&msglist=" + paramString4;
      paramString1 = paramString1 + "&uin_source=unfriend";
      paramString1 = "SourceID=401&appname=KQQ&jubaotype=uin&system=android&subapp=BusinessCard&" + paramString1;
      if (paramString1 == null) {
        paramString1 = null;
      }
      for (;;)
      {
        paramString2 = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
        paramString2.putExtra("BSafeReportPost", true);
        paramString2.putExtra("SafeReportData", paramString1);
        paramString2.putExtra("hide_more_button", true);
        paramString2.putExtra("ishiderefresh", true);
        paramString2.putExtra("ishidebackforward", true);
        paramString2.putExtra("url", "https://jubao.qq.com/cn/jubao");
        paramString2.addFlags(268435456);
        BaseApplication.getContext().startActivity(paramString2);
        return;
        try
        {
          paramString1 = paramString1.getBytes("utf-8");
        }
        catch (Exception paramString1) {}
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("com.tencent.biz.troop.TroopMemberApiService", 2, "safetyReport exception" + paramString1.getMessage());
      return;
      paramString1 = "0";
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("com.tencent.biz.troop.TroopMemberApiService", 2, "MessengerService onBind");
    }
    return this.jdField_a_of_type_AndroidOsMessenger.getBinder();
  }
  
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.i("com.tencent.biz.troop.TroopMemberApiService", 2, "MessengerService onCreate");
    }
    super.onCreate();
    if ((this.app instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBizTroopHandler = ((BizTroopHandler)((QQAppInterface)this.app).a(21));
      this.jdField_a_of_type_ComTencentMobileqqAppLBSHandler = ((LBSHandler)((QQAppInterface)this.app).a(3));
      ((QQAppInterface)this.app).a(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver, true);
      ((QQAppInterface)this.app).a(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
      ((QQAppInterface)this.app).a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("com.tencent.biz.troop.TroopMemberApiService", 2, "MessengerService onDestroy");
    }
    super.onDestroy();
    if ((this.app instanceof QQAppInterface))
    {
      ((QQAppInterface)this.app).c(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      ((QQAppInterface)this.app).c(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
      ((QQAppInterface)this.app).c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
    this.app = null;
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopHandler = null;
    this.jdField_a_of_type_ComTencentMobileqqAppLBSHandler = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService
 * JD-Core Version:    0.7.0.1
 */