package com.tencent.mobileqq.activity;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.biz.thridappshare.ThridAppShareHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQMapActivityProxy;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.FileProvider7Helper;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import cooperation.buscard.BuscardPluginInstallActivity;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qqfav.QfavUtil;
import cooperation.qqwifi.QQWiFiPluginInstallActivity;
import efk;
import efl;
import efm;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mqq.app.AppRuntime;

public class JumpActivity
  extends BaseActivity
{
  public static final int a = 18;
  private static final String jdField_a_of_type_JavaLangString = "JumpAction";
  public static boolean a = false;
  public static final int b = 19;
  public static final int c = 20;
  public static final int d = 21;
  public static final int e = 22;
  public static final int f = 1;
  public static final int g = 2;
  private Uri jdField_a_of_type_AndroidNetUri;
  private QQMapActivityProxy jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = false;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  public int h = -1;
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  /* Error */
  public static String a(android.content.Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 50	android/net/Uri:getScheme	()Ljava/lang/String;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnull +12 -> 18
    //   9: aload_3
    //   10: ldc 52
    //   12: invokevirtual 58	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15: ifeq +20 -> 35
    //   18: new 60	java/io/File
    //   21: dup
    //   22: aload_1
    //   23: invokevirtual 63	android/net/Uri:getPath	()Ljava/lang/String;
    //   26: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   29: invokevirtual 69	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   32: astore_1
    //   33: aload_1
    //   34: areturn
    //   35: aload_3
    //   36: ldc 71
    //   38: invokevirtual 58	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   41: ifeq +104 -> 145
    //   44: aload_0
    //   45: invokevirtual 77	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   48: aload_1
    //   49: iconst_1
    //   50: anewarray 54	java/lang/String
    //   53: dup
    //   54: iconst_0
    //   55: ldc 79
    //   57: aastore
    //   58: aconst_null
    //   59: aconst_null
    //   60: aconst_null
    //   61: invokevirtual 85	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   64: astore_0
    //   65: aload_0
    //   66: astore_1
    //   67: aload_0
    //   68: ldc 79
    //   70: invokeinterface 91 2 0
    //   75: istore_2
    //   76: aload_0
    //   77: astore_1
    //   78: aload_0
    //   79: invokeinterface 95 1 0
    //   84: pop
    //   85: aload_0
    //   86: astore_1
    //   87: aload_0
    //   88: iload_2
    //   89: invokeinterface 99 2 0
    //   94: astore_3
    //   95: aload_3
    //   96: astore_1
    //   97: aload_0
    //   98: ifnull -65 -> 33
    //   101: aload_0
    //   102: invokeinterface 102 1 0
    //   107: aload_3
    //   108: areturn
    //   109: astore_3
    //   110: aconst_null
    //   111: astore_0
    //   112: aload_0
    //   113: astore_1
    //   114: aload_3
    //   115: invokevirtual 105	java/lang/Exception:printStackTrace	()V
    //   118: aload_0
    //   119: ifnull +36 -> 155
    //   122: aload_0
    //   123: invokeinterface 102 1 0
    //   128: aconst_null
    //   129: areturn
    //   130: astore_0
    //   131: aconst_null
    //   132: astore_1
    //   133: aload_1
    //   134: ifnull +9 -> 143
    //   137: aload_1
    //   138: invokeinterface 102 1 0
    //   143: aload_0
    //   144: athrow
    //   145: aconst_null
    //   146: areturn
    //   147: astore_0
    //   148: goto -15 -> 133
    //   151: astore_3
    //   152: goto -40 -> 112
    //   155: aconst_null
    //   156: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	paramContext	android.content.Context
    //   0	157	1	paramUri	Uri
    //   75	14	2	i	int
    //   4	104	3	str	String
    //   109	6	3	localException1	Exception
    //   151	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   44	65	109	java/lang/Exception
    //   44	65	130	finally
    //   67	76	147	finally
    //   78	85	147	finally
    //   87	95	147	finally
    //   114	118	147	finally
    //   67	76	151	java/lang/Exception
    //   78	85	151	java/lang/Exception
    //   87	95	151	java/lang/Exception
  }
  
  private String a(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    localByteArrayOutputStream.close();
    return new String(localByteArrayOutputStream.toByteArray(), "UTF-8");
  }
  
  private void a(Intent paramIntent)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("JumpAction", 4, "action=android.nfc.action.TECH_DISCOVERED");
    }
    Object localObject = "{ \"viewTag\":\"busCard\", \"comeForm\":4, \"appInfo\":\"appid#0|bargainor_id#0|channel#qwallet_gotonfc\", \"userId\":\"" + this.app.a() + "\" }";
    Parcelable localParcelable = paramIntent.getParcelableExtra("android.nfc.extra.TAG");
    if (QLog.isDevelopLevel()) {
      QLog.i("JumpAction", 4, "gotoQWalletNfc() 1");
    }
    paramIntent = new Bundle();
    paramIntent.putString("json", (String)localObject);
    paramIntent.putString("callbackSn", "0");
    paramIntent.putParcelable("android.nfc.extra.TAG", localParcelable);
    if (QLog.isDevelopLevel()) {
      QLog.i("JumpAction", 4, "gotoQWalletNfc() 2");
    }
    localObject = new Intent();
    ((Intent)localObject).setClass(this, BuscardPluginInstallActivity.class);
    ((Intent)localObject).putExtras(paramIntent);
    startActivity((Intent)localObject);
    if (QLog.isDevelopLevel()) {
      QLog.i("JumpAction", 4, "after startActivity");
    }
    finish();
  }
  
  private void a(Intent paramIntent, Bundle paramBundle)
  {
    new efk(this, paramIntent, paramBundle).run();
  }
  
  private void a(Bundle paramBundle)
  {
    new efl(this, paramBundle).run();
  }
  
  private void a(String paramString)
  {
    a();
    paramString = getIntent();
    paramString.setClass(this, QQWiFiPluginInstallActivity.class);
    startActivity(paramString);
    finish();
  }
  
  private void a(boolean paramBoolean)
  {
    Intent localIntent = getIntent();
    Object localObject2 = localIntent.getExtras();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new Bundle();
    }
    if ((paramBoolean) && (!this.app.isLogin()))
    {
      localObject2 = new Intent(this, LoginActivity.class);
      ((Intent)localObject2).putExtra("isActionSend", true);
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      ((Intent)localObject2).putExtras(localIntent);
      startActivityForResult((Intent)localObject2, 20);
      return;
    }
    a(localIntent, (Bundle)localObject1);
  }
  
  private void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    Object localObject = getIntent();
    if ((paramBoolean1) && (!this.app.isLogin()))
    {
      jdField_a_of_type_Boolean = true;
      paramString = new Intent(this, LoginActivity.class);
      paramString.putExtra("isActionSend", true);
      paramString.putExtras(paramString);
      paramString.setFlags(16777216);
      startActivityForResult(paramString, 21);
      return;
    }
    if ((paramBoolean2) && (GesturePWDUtils.getJumpLock(this, this.app.a())))
    {
      startActivityForResult(new Intent(getActivity(), GesturePWDUnlockActivity.class), 22);
      return;
    }
    jdField_a_of_type_Boolean = false;
    localObject = ((Intent)localObject).getDataString();
    localObject = JumpParser.a(this.app, this, (String)localObject);
    ((JumpAction)localObject).a(paramString);
    ((JumpAction)localObject).b();
    finish();
  }
  
  private void b(Intent paramIntent)
  {
    boolean bool = paramIntent.getBooleanExtra("IS_LOGIN_SUC_CALL", false);
    if (!this.app.isLogin())
    {
      if (bool)
      {
        finish();
        return;
      }
      Intent localIntent = new Intent();
      localIntent.setClass(this, LoginActivity.class);
      localIntent.addFlags(67371008);
      localIntent.putExtra("QLINK_SHORTCUT_JUMP_KEY", paramIntent);
      startActivity(localIntent);
      finish();
      return;
    }
    QQProxyForQlink.a(this, 7, null);
    finish();
  }
  
  private void b(String paramString)
  {
    if ((paramString == null) || (this.jdField_d_of_type_JavaLangString == null) || (this.jdField_c_of_type_JavaLangString == null) || (this.jdField_b_of_type_JavaLangString == null)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ("app".equals(this.jdField_b_of_type_JavaLangString));
        if (!"web".equals(this.jdField_b_of_type_JavaLangString)) {
          break;
        }
      } while (!"javascript".equals(this.jdField_c_of_type_JavaLangString));
      paramString = "javascript:" + this.jdField_d_of_type_JavaLangString + "('" + paramString + "')";
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("uin", this.app.a());
      localIntent.setData(Uri.parse(paramString));
      startActivity(localIntent);
      return;
    } while (!"internal".equals(this.jdField_b_of_type_JavaLangString));
  }
  
  private void b(boolean paramBoolean)
  {
    Bundle localBundle = getIntent().getExtras();
    if (localBundle == null)
    {
      finish();
      return;
    }
    if ((paramBoolean) && (!this.app.isLogin()))
    {
      Intent localIntent = new Intent(this, LoginActivity.class);
      localIntent.putExtra("isActionSend", true);
      localIntent.putExtras(localBundle);
      localIntent.putExtras(localIntent);
      startActivityForResult(localIntent, 19);
      return;
    }
    if (localBundle.getBoolean("qqfav_extra_from_system_share", false))
    {
      if (a(localBundle) != 0) {
        QfavUtil.a(this, 2131364730, 1);
      }
      finish();
      return;
    }
    a(localBundle);
  }
  
  private void c()
  {
    String str1 = getPackageName();
    String str2 = InstallActivity.class.getName();
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.addCategory("android.intent.category.LAUNCHER");
    localIntent.addFlags(268435456);
    localIntent.setComponent(new ComponentName(str1, str2));
    startActivity(localIntent);
    finish();
  }
  
  private void d()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy = new QQMapActivityProxy(this.app.getAccount());
      }
      startActivityForResult(new Intent(this, QQMapActivity.class).putExtra("uin", this.app.getAccount()), 18);
      return;
    }
    catch (Exception localException)
    {
      if (this.jdField_d_of_type_Boolean) {
        b("Google Map not exist");
      }
      finish();
    }
  }
  
  protected int a(Bundle paramBundle)
  {
    Object localObject2;
    String str3;
    HashMap localHashMap;
    int i;
    for (;;)
    {
      try
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("qqfav|QfavJumpActivity", 4, "startSystemShareToQQFav|beg");
        }
        localObject1 = paramBundle.getString("android.intent.extra.TITLE");
        paramBundle.getString("android.intent.extra.SUBJECT");
        localObject2 = paramBundle.getString("android.intent.extra.TEXT");
        paramBundle.getString("image_url");
        paramBundle.getString("detail_url");
        str3 = getIntent().getType();
        if (TextUtils.isEmpty(str3))
        {
          if (!QLog.isColorLevel()) {
            break label1171;
          }
          QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|type null");
          break label1171;
        }
        localHashMap = new HashMap();
        localHashMap.put("src_type", "app");
        localHashMap.put("version", "1");
        localHashMap.put("cflag", Base64Util.encodeToString("1".getBytes(), 0));
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          continue;
        }
        localObject1 = "";
        localHashMap.put("title", localObject1);
        if (!str3.startsWith("text")) {
          continue;
        }
        if (paramBundle.containsKey("android.intent.extra.STREAM")) {
          continue;
        }
        localHashMap.put("req_type", Base64Util.encodeToString("6".getBytes(), 0));
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          continue;
        }
        paramBundle = "";
        localHashMap.put("description", paramBundle);
      }
      catch (OutOfMemoryError paramBundle)
      {
        try
        {
          label261:
          label622:
          Object localObject1 = URLEncoder.encode(paramBundle, "UTF-8");
          localHashMap.put("file_data", Base64Util.encodeToString(((String)localObject1).getBytes(), 0));
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException1)
        {
          if (!QLog.isColorLevel()) {
            break label781;
          }
          QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|encode fail. path=" + paramBundle + ",exp:" + localUnsupportedEncodingException1.getMessage());
          return 1;
        }
        paramBundle = paramBundle;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|outofmemoryerror");
        return 1;
      }
      paramBundle = new StringBuilder("mqqapi://share/to_qqfav?");
      localObject1 = localHashMap.keySet();
      localObject2 = ((Set)localObject1).iterator();
      i = 0;
      if (!((Iterator)localObject2).hasNext()) {
        break label1107;
      }
      str3 = (String)((Iterator)localObject2).next();
      paramBundle.append(str3);
      paramBundle.append("=");
      paramBundle.append((String)localHashMap.get(str3));
      if (i == ((Set)localObject1).size() - 1) {
        break label1173;
      }
      paramBundle.append("&");
      break label1173;
      localObject1 = Base64Util.encodeToString(((String)localObject1).getBytes(), 0);
      continue;
      paramBundle = Base64Util.encodeToString(((String)localObject2).getBytes(), 0);
      continue;
      for (;;)
      {
        try
        {
          paramBundle = (Uri)paramBundle.getParcelable("android.intent.extra.STREAM");
          if (paramBundle == null) {
            break;
          }
          paramBundle = a(super.getContentResolver().openInputStream(paramBundle));
          if (TextUtils.isEmpty(paramBundle))
          {
            if (!QLog.isColorLevel()) {
              break label1180;
            }
            QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|text, extra_stream, empty");
            break label1180;
          }
          localHashMap.put("req_type", Base64Util.encodeToString("6".getBytes(), 0));
          if (TextUtils.isEmpty(paramBundle))
          {
            paramBundle = "";
            localHashMap.put("description", paramBundle);
          }
        }
        catch (Exception paramBundle)
        {
          if (QLog.isColorLevel()) {
            QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|text, extra_stream, exp:" + paramBundle.getMessage());
          }
          return 1;
        }
        paramBundle = Base64Util.encodeToString(paramBundle.getBytes(), 0);
        continue;
        if (!str3.startsWith("image")) {
          break label1070;
        }
        localHashMap.put("req_type", Base64Util.encodeToString("5".getBytes(), 0));
        if (!getIntent().getAction().equals("android.intent.action.SEND")) {
          break label783;
        }
        paramBundle = paramBundle.get("android.intent.extra.STREAM");
        if (paramBundle == null)
        {
          if (!QLog.isColorLevel()) {
            break label1182;
          }
          QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|action_send extra_stream null");
          break label1182;
        }
        if ((paramBundle instanceof Uri))
        {
          paramBundle = (Uri)paramBundle;
          break label1184;
        }
        if (!(paramBundle instanceof String)) {
          break label1166;
        }
        paramBundle = Uri.parse((String)paramBundle);
        break label1184;
        paramBundle = a(this, paramBundle);
        if ((TextUtils.isEmpty(paramBundle)) || (!new File(paramBundle).exists()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|action_send file path invalid. path=" + paramBundle);
          }
          return 1;
        }
      }
    }
    try
    {
      label781:
      label783:
      paramBundle = (ArrayList)paramBundle.get("android.intent.extra.STREAM");
      if (paramBundle == null)
      {
        if (!QLog.isColorLevel()) {
          break label1190;
        }
        QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|action_send_muti extra_stream null");
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
        paramBundle = null;
      }
      localObject2 = new ArrayList();
      i = 0;
      for (;;)
      {
        if (i < paramBundle.size())
        {
          String str1 = a(this, (Uri)paramBundle.get(i));
          if (!TextUtils.isEmpty(str1))
          {
            boolean bool = new File(str1).exists();
            if (!bool) {}
          }
          try
          {
            ((ArrayList)localObject2).add(URLEncoder.encode(str1, "UTF-8"));
            i += 1;
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException2)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|action_send_muti path encode fail: %s" + localUnsupportedEncodingException2.getMessage());
              }
            }
          }
        }
      }
      if (!((ArrayList)localObject2).isEmpty()) {
        break label1194;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|action_send_muti pathlist empty");
    }
    for (;;)
    {
      if (i < ((ArrayList)localObject2).size())
      {
        String str2 = paramBundle + (String)((ArrayList)localObject2).get(i);
        paramBundle = str2;
        if (i != ((ArrayList)localObject2).size() - 1) {
          paramBundle = str2 + ";";
        }
      }
      else
      {
        localHashMap.put("file_data", Base64Util.encodeToString(paramBundle.getBytes(), 0));
        break;
        label1070:
        if (!QLog.isColorLevel()) {
          break label1210;
        }
        QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|unknown type. type=" + str3);
        break label1210;
        label1107:
        paramBundle = JumpParser.a(this.app, this, paramBundle.toString());
        if (paramBundle == null)
        {
          if (!QLog.isColorLevel()) {
            break label1212;
          }
          QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|jump parse fail");
          break label1212;
        }
        paramBundle.b();
        if (QLog.isDevelopLevel()) {
          QLog.d("qqfav|QfavJumpActivity", 4, "startSystemShareToQQFav|end");
        }
        return 0;
        label1166:
        paramBundle = null;
        break label1184;
        label1171:
        return 1;
        label1173:
        i += 1;
        break label261;
        label1180:
        return 1;
        label1182:
        return 1;
        label1184:
        if (paramBundle != null) {
          break label622;
        }
        return 1;
        label1190:
        return 1;
        return 1;
        label1194:
        paramBundle = "";
        i = 0;
        continue;
      }
      i += 1;
    }
    label1210:
    return 1;
    label1212:
    return 1;
  }
  
  public void a()
  {
    try
    {
      Object localObject2 = getSystemService("statusbar");
      Object localObject1 = Class.forName("android.app.StatusBarManager");
      if (Build.VERSION.SDK_INT <= 16) {}
      for (localObject1 = ((Class)localObject1).getMethod("collapse", new Class[0]);; localObject1 = ((Class)localObject1).getMethod("collapsePanels", new Class[0]))
      {
        ((Method)localObject1).setAccessible(true);
        ((Method)localObject1).invoke(localObject2, new Object[0]);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  void a(int paramInt)
  {
    Intent localIntent = new Intent("android.intent.action.GET_CONTENT");
    localIntent.setType("image/*");
    startActivityForResult(localIntent, paramInt);
  }
  
  protected boolean a(Intent paramIntent)
  {
    return false;
  }
  
  void b()
  {
    Object localObject = new File(AppConstants.aG + "photo/");
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = new Intent();
    this.jdField_a_of_type_AndroidNetUri = FileProvider7Helper.setSystemCapture(this, new File(AppConstants.aG + "photo/" + System.currentTimeMillis() + ".jpg"), (Intent)localObject);
    startActivityForResult((Intent)localObject, 3);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("JumpActivity onActivityResult,requestCode=").append(paramInt1).append(",resultCode=").append(paramInt2).append(",data=");
      if (paramIntent == null) {
        break label165;
      }
    }
    label165:
    for (Object localObject = paramIntent.toString();; localObject = "null")
    {
      QLog.d("JumpAction", 2, (String)localObject);
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      if (paramInt2 != -1) {
        break;
      }
      switch (paramInt1)
      {
      default: 
        return;
      }
    }
    if (paramIntent != null) {}
    for (boolean bool = paramIntent.getBooleanExtra("changed", false);; bool = false)
    {
      if ((!bool) || (this.jdField_d_of_type_Boolean)) {
        b("HexUtil.bytes2HexStr(fileKey)");
      }
      finish();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy = null;
      }
      localObject = paramIntent.getExtras();
      if (localObject == null) {
        break;
      }
      paramIntent = ((Bundle)localObject).getString("latitude");
      localObject = ((Bundle)localObject).getString("longitude");
      if (this.jdField_d_of_type_Boolean) {
        b("ret=0&lon=" + (String)localObject + "&lat=" + paramIntent);
      }
      finish();
      return;
      b(false);
      return;
      a(false);
      return;
      a(false, null, true);
      return;
      a(true, null, false);
      return;
      if ((-1 == paramInt2) && (paramIntent != null))
      {
        paramIntent = paramIntent.getStringExtra("roomId");
        if (paramIntent == null) {
          break;
        }
        localObject = new efm(this);
        if (!ChatActivityUtils.a(this.app, this, 3000, paramIntent, true, true, (Handler.Callback)localObject)) {
          break;
        }
        finish();
        return;
      }
      finish();
      return;
      finish();
      return;
      finish();
      return;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    Object localObject2 = null;
    Intent localIntent;
    try
    {
      super.doOnCreate(paramBundle);
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "JumpActivity doOnCreate()");
      }
      if (a(getIntent()))
      {
        finish();
        return false;
      }
      localIntent = getIntent();
      if (localIntent != null) {
        this.h = localIntent.getIntExtra("cur_tab_index", -1);
      }
      if ((localIntent != null) && (!TextUtils.isEmpty(localIntent.getAction())) && ((localIntent.getAction().equals("android.intent.action.SEND")) || (localIntent.getAction().equals("android.intent.action.SEND_MULTIPLE"))))
      {
        b(true);
        return false;
      }
    }
    catch (Exception paramBundle)
    {
      QLog.e("JumpAction", 1, "doOnCreate|exp:" + paramBundle.getMessage());
      finish();
      return false;
    }
    if ((localIntent != null) && (!TextUtils.isEmpty(localIntent.getAction())) && (localIntent.getAction().equals("android.intent.action.VIEW")) && (!TextUtils.isEmpty(localIntent.getScheme())) && (localIntent.getScheme().equals("file")))
    {
      a(true);
      return false;
    }
    if ((localIntent != null) && (!TextUtils.isEmpty(localIntent.getAction())) && (localIntent.getAction().equals("android.intent.action.SENDTO")) && (!TextUtils.isEmpty(localIntent.getScheme())) && (localIntent.getScheme().equals("imto")))
    {
      c();
      return false;
    }
    if ((localIntent != null) && (!TextUtils.isEmpty(localIntent.getAction())) && ((localIntent.getAction().equals("com.tencent.mobileqq.action.QQWiFiProxy")) || (localIntent.getAction().equals("com.tencent.mobileqq.action.QQWiFi")) || (localIntent.getAction().equals("com.tencent.mobileqq.msf.qqwifi.missions")) || (localIntent.getAction().equals("com.tencent.mobileqq.msf.qqwifi.settings")) || (localIntent.getAction().equals("com.tencent.mobileqq.msf.qqwifi.redtouch")) || (localIntent.getAction().equals("com.tencent.mobileqq.msf.qqwifi.map"))))
    {
      a(localIntent.getAction());
      return false;
    }
    if ((localIntent != null) && ("thridapp".equals(localIntent.getStringExtra("share_from"))))
    {
      if (!ThridAppShareHelper.a().a(String.valueOf(Long.valueOf(localIntent.getLongExtra("req_share_id", 0L)))))
      {
        super.finish();
        return false;
      }
      paramBundle = new Intent(this, ChatActivity.class);
      paramBundle.putExtras(localIntent.getExtras());
      paramBundle.addFlags(67108864);
      startActivity(paramBundle);
      return false;
    }
    if ((localIntent != null) && (((!TextUtils.isEmpty(localIntent.getAction())) && (localIntent.getAction().equals("android.intent.action.MAIN")) && (localIntent.getBooleanExtra("_is_from_qlink_shortcut", false))) || (localIntent.getBooleanExtra("_goto_qlink_when_login_suc_", false))))
    {
      b(localIntent);
      return false;
    }
    if ((Build.VERSION.SDK_INT >= 10) && (localIntent != null) && (!TextUtils.isEmpty(localIntent.getAction())) && ("android.nfc.action.TECH_DISCOVERED".equals(localIntent.getAction())))
    {
      a(localIntent);
      return false;
    }
    String str1 = getIntent().getDataString();
    String str2 = getIntent().getStringExtra("from");
    try
    {
      localObject1 = getCallingPackage();
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = getIntent().getStringExtra("pkg_name");
      }
      JumpAction localJumpAction;
      if (str1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "jump url:" + str1);
        }
        localJumpAction = JumpParser.a(this.app, this, str1);
        if (("webview".equals(str2)) && (localJumpAction != null)) {
          localJumpAction.a(str2);
        }
        if (localJumpAction != null)
        {
          localJumpAction.jdField_a_of_type_Boolean = true;
          if ((localJumpAction.cJ != null) && (localJumpAction.cJ.equals("puzzle_verify_code")) && (localJumpAction.cK != null))
          {
            paramBundle = new Intent(getIntent());
            if (localJumpAction.cK.equals("PUZZLEVERIFYCODE")) {
              paramBundle.setClass(this, QQBrowserActivity.class);
            }
            for (;;)
            {
              super.startActivity(paramBundle);
              super.finish();
              return false;
              if (localJumpAction.cK.equals("VERIFYCODE")) {
                paramBundle.setClass(this, VerifyCodeActivity.class);
              } else if (localJumpAction.cK.equals("DEVLOCK_CODE")) {
                paramBundle.setClass(this, AuthDevUgActivity.class);
              }
            }
          }
          if ((localJumpAction.cJ == null) || (!localJumpAction.cJ.equals("ptlogin")) || (localJumpAction.cK == null) || (!localJumpAction.cK.equals("qlogin"))) {
            break label1578;
          }
        }
      }
      label1578:
      for (int i = 0;; i = 1)
      {
        if ((!str1.startsWith("mqqwpa://im")) && (!str1.startsWith("mqqwpaopenid://im")))
        {
          if (!str1.startsWith(String.format("%s%s", new Object[] { "mqqvoipivr://", "crmivr" }))) {}
        }
        else
        {
          a(true, str2, true);
          return false;
        }
        localObject1 = paramBundle;
        if (str1.startsWith("mqqapi:")) {
          if (paramBundle != null)
          {
            localObject1 = paramBundle;
            if (!"com.tencent.minihd.qq".equals(paramBundle)) {}
          }
          else
          {
            localObject1 = getIntent().getStringExtra("pkg_name");
          }
        }
        boolean bool;
        if ((!this.app.isLogin()) && (i != 0))
        {
          localObject2 = new StringBuilder().append(str1);
          if (str1.indexOf("?") <= -1) {
            break label1592;
          }
          paramBundle = "&";
          paramBundle = paramBundle;
          paramBundle = paramBundle + "jfrom=login";
          localObject2 = new Intent(this, LoginActivity.class);
          ((Intent)localObject2).putExtra("scheme_content", paramBundle);
          ((Intent)localObject2).putExtra("pkg_name", (String)localObject1);
          ((Intent)localObject2).putExtras((Intent)localObject2);
          ((Intent)localObject2).setFlags(268435456);
          if (VersionUtils.e()) {
            ((Intent)localObject2).addFlags(32768);
          }
          startActivity((Intent)localObject2);
          bool = true;
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("JumpAction", 2, "JumpActivity is finish");
          }
          if ((localJumpAction.cJ != null) && (localJumpAction.cK != null)) {
            break;
          }
          finish();
          return false;
          if ((GesturePWDUtils.getJumpLock(this, this.app.a())) && (!GesturePWDUtils.getAppForground(this)))
          {
            paramBundle = new Intent(getActivity(), GesturePWDUnlockActivity.class);
            paramBundle.putExtra("key_gesture_from_jumpactivity", true);
            paramBundle.putExtra("scheme_content", str1);
            paramBundle.putExtra("pkg_name", (String)localObject1);
            startActivity(paramBundle);
            bool = true;
          }
          else
          {
            if (str1.startsWith("mqqapi://tenpay/pay?"))
            {
              paramBundle = (Bundle)localObject2;
              if (localIntent != null) {
                paramBundle = localIntent.getStringExtra("url_app_info");
              }
              if (!TextUtils.isEmpty(paramBundle)) {
                localJumpAction.a("url_app_info", paramBundle);
              }
            }
            localJumpAction.b((String)localObject1);
            bool = localJumpAction.b();
          }
        }
        if ((localJumpAction.cJ.equals("gav")) && (localJumpAction.cK.equals("request")))
        {
          if (("0".equals(localJumpAction.a("relation_id"))) || (!bool)) {
            break;
          }
          finish();
          return false;
        }
        if ((localJumpAction.cJ.equals("videochat")) && (localJumpAction.cK.equals("request")))
        {
          if (!bool) {
            break;
          }
          finish();
          return false;
        }
        if ((localJumpAction.cJ.equals("wallet")) && (localJumpAction.cK.equals("modify_pass")))
        {
          if (!bool) {
            break;
          }
          finish();
          return false;
        }
        finish();
        return false;
        paramBundle = getIntent().getStringExtra("action");
        if (paramBundle == null)
        {
          finish();
          return false;
        }
        this.jdField_d_of_type_Boolean = getIntent().getBooleanExtra("doCallBack", false);
        this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("src_type");
        this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("callback_type");
        this.jdField_d_of_type_JavaLangString = getIntent().getStringExtra("callback_name");
        if ("photo".equals(paramBundle)) {
          this.jdField_b_of_type_Boolean = true;
        }
        while ((!this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean))
        {
          d();
          return false;
          if ("select_location".equals(paramBundle)) {
            this.jdField_c_of_type_Boolean = true;
          }
        }
      }
      return false;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Object localObject1 = null;
        continue;
        label1592:
        paramBundle = "?";
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    jdField_a_of_type_Boolean = false;
  }
  
  protected int getTabIndex()
  {
    if (this.h >= 0) {
      return this.h;
    }
    return super.getTabIndex();
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      this.app = ((QQAppInterface)localAppRuntime);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("JumpAction", 2, "onAccountChanged" + localAppRuntime);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JumpActivity
 * JD-Core Version:    0.7.0.1
 */