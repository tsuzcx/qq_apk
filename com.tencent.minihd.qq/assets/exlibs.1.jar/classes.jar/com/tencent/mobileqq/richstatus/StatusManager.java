package com.tencent.mobileqq.richstatus;

import PersonalState.UserProfile;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import jrd;
import jrf;
import jti;
import jtj;
import jtk;
import jtl;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import protocol.KQQConfig.GetResourceReqInfo;

public class StatusManager
  implements jrf, Manager
{
  public static final int a = -3;
  private static final long jdField_a_of_type_Long = 65L;
  public static final String a = "Q.richstatus.";
  private static volatile WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  public static final boolean a = false;
  private static Object[] jdField_a_of_type_ArrayOfJavaLangObject = new Object[2];
  public static final int b = -2;
  private static final long jdField_b_of_type_Long = 180000L;
  public static final String b = "Q.richstatus.img";
  public static final int c = -1;
  private static final long jdField_c_of_type_Long = 240000L;
  public static final String c = "Q.richstatus.xml";
  public static final int d = 100;
  private static final long jdField_d_of_type_Long = 60000L;
  public static final String d = "Q.richstatus.shuo";
  public static final int e = 101;
  private static final long jdField_e_of_type_Long = 43200000L;
  public static final String e = "Q.richstatus.set";
  public static final int f = 102;
  private static final long f = 300000L;
  public static final String f = "Q.richstatus.mate";
  public static final int g = 200;
  public static final String g = "Q.richstatus.status";
  public static final int h = 201;
  public static final String h = "rich_status.tmp";
  public static final int i = 300;
  public static final String i = "$N";
  public static final int j = 301;
  public static final String j = "$A";
  public static final int k = -1;
  public static final String k = "rich_status";
  public static final int l = 0;
  public static final String l = "k_version";
  public static final int m = 0;
  public static final String m = "key_params_qq";
  public static final int n = 1;
  private static final String n = "rich_status.xml";
  private static final int jdField_o_of_type_Int = 2;
  private static final String jdField_o_of_type_JavaLangString = "_";
  private static final int jdField_p_of_type_Int = 3;
  private static final String jdField_p_of_type_JavaLangString = "_s_";
  private static final String jdField_q_of_type_JavaLangString = "$U";
  private static final String jdField_r_of_type_JavaLangString = "$D";
  private static final String jdField_s_of_type_JavaLangString = "$T";
  private static final int jdField_t_of_type_Int = 14;
  private static final String jdField_t_of_type_JavaLangString = "$S";
  private static final String u = "$I";
  private static final String v = "k_update_time";
  private static final String w = "k_icon";
  private static final String x = "k_sync_ss";
  private static final String y = "k_ss_time";
  private volatile AsyncTask jdField_a_of_type_AndroidOsAsyncTask;
  private volatile SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private RichStatus jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
  private StatusObserver jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private HashSet jdField_a_of_type_JavaUtilHashSet;
  private LinkedList jdField_a_of_type_JavaUtilLinkedList;
  private jrd jdField_a_of_type_Jrd;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private AsyncTask jdField_b_of_type_AndroidOsAsyncTask;
  private ArrayList jdField_b_of_type_JavaUtilArrayList;
  private LinkedList jdField_b_of_type_JavaUtilLinkedList;
  private ArrayList jdField_c_of_type_JavaUtilArrayList;
  private LinkedList jdField_c_of_type_JavaUtilLinkedList;
  private LinkedList jdField_d_of_type_JavaUtilLinkedList;
  private LinkedList jdField_e_of_type_JavaUtilLinkedList;
  private long g;
  private long h;
  private long i;
  private long j;
  private int jdField_q_of_type_Int;
  private int jdField_r_of_type_Int;
  private int jdField_s_of_type_Int;
  
  private StatusManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.i = a().getLong("k_update_time", 0L);
  }
  
  private int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "updateActions_Local");
    }
    if (this.jdField_a_of_type_AndroidOsAsyncTask != null) {
      return 100;
    }
    this.jdField_a_of_type_AndroidOsAsyncTask = new jti(this).execute(new Void[0]);
    return 100;
  }
  
  /* Error */
  private android.content.Intent a(BaseActivity paramBaseActivity, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: iload_3
    //   5: invokevirtual 208	com/tencent/mobileqq/richstatus/StatusManager:a	(I)Lcom/tencent/mobileqq/richstatus/ActionInfo;
    //   8: astore 7
    //   10: aload 7
    //   12: ifnonnull +5 -> 17
    //   15: aconst_null
    //   16: areturn
    //   17: aload 7
    //   19: getfield 212	com/tencent/mobileqq/richstatus/ActionInfo:jdField_j_of_type_Int	I
    //   22: tableswitch	default:+22 -> 44, 4:+24->46, 5:+74->96
    //   45: areturn
    //   46: aload 7
    //   48: getfield 214	com/tencent/mobileqq/richstatus/ActionInfo:f	Ljava/lang/String;
    //   51: ifnull -36 -> 15
    //   54: new 216	android/content/Intent
    //   57: dup
    //   58: aload_1
    //   59: ldc 218
    //   61: invokespecial 221	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   64: astore_1
    //   65: aload_1
    //   66: ldc 76
    //   68: aload_0
    //   69: aload 7
    //   71: getfield 214	com/tencent/mobileqq/richstatus/ActionInfo:f	Ljava/lang/String;
    //   74: iload_3
    //   75: iload 4
    //   77: aload 5
    //   79: invokevirtual 224	com/tencent/mobileqq/richstatus/StatusManager:a	(Ljava/lang/String;IILjava/lang/String;)Ljava/lang/String;
    //   82: invokevirtual 228	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   85: pop
    //   86: aload_1
    //   87: ldc 230
    //   89: aload_2
    //   90: invokevirtual 228	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   93: pop
    //   94: aload_1
    //   95: areturn
    //   96: new 216	android/content/Intent
    //   99: dup
    //   100: aload_1
    //   101: aload 7
    //   103: getfield 232	com/tencent/mobileqq/richstatus/ActionInfo:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   106: invokestatic 238	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   109: invokespecial 221	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   112: astore_1
    //   113: aload 7
    //   115: getfield 240	com/tencent/mobileqq/richstatus/ActionInfo:k	Ljava/lang/String;
    //   118: ifnull +24 -> 142
    //   121: aload_1
    //   122: ldc 76
    //   124: aload_0
    //   125: aload 7
    //   127: getfield 240	com/tencent/mobileqq/richstatus/ActionInfo:k	Ljava/lang/String;
    //   130: iload_3
    //   131: iload 4
    //   133: aload 5
    //   135: invokevirtual 224	com/tencent/mobileqq/richstatus/StatusManager:a	(Ljava/lang/String;IILjava/lang/String;)Ljava/lang/String;
    //   138: invokevirtual 228	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   141: pop
    //   142: aload_1
    //   143: areturn
    //   144: astore_2
    //   145: aload 6
    //   147: astore_1
    //   148: aload_2
    //   149: invokevirtual 243	java/lang/Exception:printStackTrace	()V
    //   152: aload_1
    //   153: areturn
    //   154: astore_2
    //   155: goto -7 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	StatusManager
    //   0	158	1	paramBaseActivity	BaseActivity
    //   0	158	2	paramString1	String
    //   0	158	3	paramInt1	int
    //   0	158	4	paramInt2	int
    //   0	158	5	paramString2	String
    //   1	145	6	localObject	Object
    //   8	118	7	localActionInfo	ActionInfo
    // Exception table:
    //   from	to	target	type
    //   96	113	144	java/lang/Exception
    //   113	142	154	java/lang/Exception
  }
  
  private SharedPreferences a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("rich_status", 0);
  }
  
  public static StatusManager a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (StatusManager localStatusManager1 = (StatusManager)jdField_a_of_type_JavaLangRefWeakReference.get();; localStatusManager1 = null)
    {
      StatusManager localStatusManager2;
      if (localStatusManager1 == null)
      {
        localStatusManager2 = new StatusManager(paramQQAppInterface);
        jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localStatusManager2);
      }
      for (;;)
      {
        localStatusManager2.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
        return localStatusManager2;
        localStatusManager1.jdField_a_of_type_JavaUtilHashSet.clear();
        localStatusManager1.h = 0L;
        localStatusManager1.g = 0L;
        localStatusManager1.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = null;
        if (localStatusManager1.jdField_a_of_type_ComTencentMobileqqAppConfigObserver != null)
        {
          localStatusManager1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(localStatusManager1.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
          localStatusManager1.jdField_a_of_type_ComTencentMobileqqAppConfigObserver = null;
        }
        if (localStatusManager1.jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver != null)
        {
          localStatusManager1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(localStatusManager1.jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver);
          localStatusManager1.jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver = null;
        }
        localStatusManager2 = localStatusManager1;
        if (localStatusManager1.jdField_a_of_type_Jrd != null)
        {
          localStatusManager1.jdField_a_of_type_Jrd.a();
          localStatusManager2 = localStatusManager1;
        }
      }
    }
  }
  
  private boolean a(SparseArray paramSparseArray1, SparseArray paramSparseArray2)
  {
    int i1 = 0;
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "removeOldIcons(" + paramSparseArray1 + ", " + paramSparseArray2 + ")");
    }
    File localFile = jrd.a();
    boolean bool1;
    if (localFile == null)
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.richstatus.xml", 2, "removeOldIcons: dir is null");
        bool1 = bool2;
      }
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          if (!localFile.exists())
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.richstatus.xml", 2, "removeOldIcons: dir does not exist!");
            }
            return true;
          }
          if (localFile.canWrite()) {
            break;
          }
          bool1 = bool2;
        } while (!QLog.isColorLevel());
        QLog.d("Q.richstatus.xml", 2, "removeOldIcons: dir can not write!");
        return false;
        if (paramSparseArray1 != null) {
          break;
        }
        paramSparseArray1 = localFile.listFiles();
        i2 = paramSparseArray1.length;
        if (i1 < i2)
        {
          paramSparseArray2 = paramSparseArray1[i1];
          if (paramSparseArray2 == null) {}
          for (;;)
          {
            i1 += 1;
            break;
            if ((!paramSparseArray2.exists()) || (paramSparseArray2.delete()) || (paramSparseArray2.delete()) || (!paramSparseArray2.delete())) {}
          }
        }
        bool2 = localFile.canWrite();
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("Q.richstatus.xml", 2, "removeOldIcons return with " + bool2);
      return bool2;
      ArrayList localArrayList = new ArrayList();
      int i2 = paramSparseArray2.size();
      i1 = 0;
      while (i1 < i2)
      {
        ActionInfo localActionInfo1 = (ActionInfo)paramSparseArray2.valueAt(i1);
        ActionInfo localActionInfo2 = (ActionInfo)paramSparseArray1.get(localActionInfo1.i);
        if ((localActionInfo2 != null) && (localActionInfo2.jdField_a_of_type_JavaLangString != null) && (!localActionInfo2.jdField_a_of_type_JavaLangString.equalsIgnoreCase(localActionInfo1.jdField_a_of_type_JavaLangString))) {
          localArrayList.add(localActionInfo2.i + "_s_" + 201);
        }
        if ((localActionInfo2 != null) && (localActionInfo2.b != null) && (!localActionInfo2.b.equalsIgnoreCase(localActionInfo1.b))) {
          localArrayList.add(localActionInfo2.i + "_s_" + 200);
        }
        i1 += 1;
      }
      paramSparseArray1 = localArrayList.iterator();
      while (paramSparseArray1.hasNext())
      {
        paramSparseArray2 = new File(localFile, (String)paramSparseArray1.next());
        if ((!paramSparseArray2.exists()) || (paramSparseArray2.delete()) || (paramSparseArray2.delete()) || (!paramSparseArray2.delete())) {}
      }
      bool2 = localFile.canWrite();
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("Q.richstatus.xml", 2, "removeOldIcons return with " + bool2);
    return bool2;
  }
  
  private Object[] a(InputStream paramInputStream)
  {
    int i2 = -1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "parseXmlFile(" + paramInputStream + ")");
    }
    Object[] arrayOfObject = new Object[2];
    if (paramInputStream == null) {
      return arrayOfObject;
    }
    Object localObject2 = new StatusXmlHandler();
    for (;;)
    {
      try
      {
        SAXParserFactory.newInstance().newSAXParser().parse(paramInputStream, (DefaultHandler)localObject2);
        SparseArray localSparseArray = ((StatusXmlHandler)localObject2).a();
        localObject2 = ((StatusXmlHandler)localObject2).a();
        if (localSparseArray.size() > 1) {
          arrayOfObject[0] = localSparseArray;
        }
        if (((ArrayList)localObject2).size() > 0) {
          arrayOfObject[1] = localObject2;
        }
      }
      catch (ParserConfigurationException localParserConfigurationException)
      {
        localParserConfigurationException.printStackTrace();
        try
        {
          paramInputStream.close();
        }
        catch (IOException paramInputStream)
        {
          paramInputStream.printStackTrace();
        }
        continue;
      }
      catch (SAXException localSAXException)
      {
        localSAXException.printStackTrace();
        try
        {
          paramInputStream.close();
        }
        catch (IOException paramInputStream)
        {
          paramInputStream.printStackTrace();
        }
        continue;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        try
        {
          paramInputStream.close();
        }
        catch (IOException paramInputStream)
        {
          paramInputStream.printStackTrace();
        }
        continue;
      }
      finally
      {
        try
        {
          paramInputStream.close();
          throw localObject1;
        }
        catch (IOException paramInputStream)
        {
          paramInputStream.printStackTrace();
          continue;
        }
        int i1 = -1;
        continue;
      }
      try
      {
        paramInputStream.close();
        if (QLog.isColorLevel())
        {
          paramInputStream = new StringBuilder().append("parseXmlFile return, action num: ");
          if (arrayOfObject[0] != null)
          {
            i1 = ((SparseArray)arrayOfObject[0]).size();
            paramInputStream = paramInputStream.append(i1).append(" tag num: ");
            i1 = i2;
            if (arrayOfObject[1] != null) {
              i1 = ((ArrayList)arrayOfObject[1]).size();
            }
            QLog.d("Q.richstatus.xml", 2, i1);
          }
        }
        else
        {
          return arrayOfObject;
        }
      }
      catch (IOException paramInputStream)
      {
        paramInputStream.printStackTrace();
      }
    }
  }
  
  private int b()
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "updateActions_Remote:" + l1 + ", " + this.h + ", " + "rich_status_android");
    }
    if (Math.abs(l1 - this.h) > 240000L)
    {
      ConfigHandler localConfigHandler = (ConfigHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(4);
      if (this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver == null) {
        c();
      }
      localConfigHandler.a(null, new GetResourceReqInfo[] { localConfigHandler.e() });
      this.h = l1;
    }
    return 100;
  }
  
  private int b(boolean paramBoolean)
  {
    int i1 = 101;
    if (this.jdField_a_of_type_AndroidUtilSparseArray.size() == 0) {
      i1 = 102;
    }
    long l1;
    do
    {
      return i1;
      l1 = System.currentTimeMillis();
      if (Math.abs(this.i - l1) <= 43200000L) {
        break;
      }
    } while (!paramBoolean);
    if (Math.abs(this.j - l1) > 300000L)
    {
      this.j = l1;
      return 101;
    }
    return 100;
  }
  
  private SharedPreferences b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("rich_status" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
  }
  
  private void b(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    b().edit().putBoolean("k_sync_ss", paramBoolean).putLong("k_ss_time", l1).commit();
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new jtj(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
  }
  
  private boolean c()
  {
    int i1 = b(true);
    if (i1 != 100)
    {
      a(i1);
      return true;
    }
    return false;
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver = new jtk(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver);
  }
  
  public int a(int paramInt)
  {
    if (paramInt == 102) {
      return a();
    }
    if (paramInt == 101) {
      return b();
    }
    return -1;
  }
  
  public int a(int paramInt, ArrayList paramArrayList)
  {
    if (paramArrayList == null) {
      throw new InvalidParameterException("list is null!");
    }
    paramArrayList.clear();
    Object localObject = (ActionInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null) {}
    for (localObject = ((ActionInfo)localObject).jdField_a_of_type_JavaUtilArrayList;; localObject = null)
    {
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          paramArrayList.add((ActionInfo)((Iterator)localObject).next());
        }
      }
      return b(false);
    }
  }
  
  public int a(RichStatus paramRichStatus, int paramInt)
  {
    if (paramRichStatus == null) {}
    for (;;)
    {
      return 100;
      if (QLog.isColorLevel()) {
        QLog.d("Q.richstatus.set", 2, "changeStatus " + paramRichStatus.b + paramInt);
      }
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramRichStatus;
      if (paramRichStatus.a()) {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          paramRichStatus = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), StatusServlet.class);
          paramRichStatus.putExtra("k_cmd", 8);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramRichStatus);
        }
      }
      while (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver == null)
      {
        d();
        return 100;
        byte[] arrayOfByte = paramRichStatus.a();
        NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), StatusServlet.class);
        localNewIntent.putExtra("k_cmd", 9);
        localNewIntent.putExtra("k_tpl_id", paramRichStatus.jdField_d_of_type_Int);
        localNewIntent.putExtra("k_sign_len", arrayOfByte.length);
        localNewIntent.putExtra("k_sign_data", arrayOfByte);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
      }
    }
  }
  
  public int a(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {
      throw new InvalidParameterException("array list is null");
    }
    paramArrayList.clear();
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      paramArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    }
    return b(false);
  }
  
  public int a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.shuo", 2, "setSyncShuoShuo " + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver == null) {
      d();
    }
    StatusServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean);
    return 100;
  }
  
  public int a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    byte[] arrayOfByte = null;
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.mate", 2, "getStatusMates " + paramBoolean + ", " + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ", " + paramString);
    }
    if (paramBoolean)
    {
      this.q = paramInt1;
      this.r = paramInt2;
      this.s = paramInt3;
      this.jdField_b_of_type_JavaUtilArrayList = null;
      if ((this.jdField_c_of_type_JavaUtilArrayList == null) && (this.jdField_b_of_type_AndroidOsAsyncTask == null))
      {
        this.jdField_b_of_type_AndroidOsAsyncTask = new jtl(this);
        this.jdField_b_of_type_AndroidOsAsyncTask.execute(new Void[0]);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver == null) {
      d();
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramBoolean) {}
    for (;;)
    {
      StatusServlet.a(localQQAppInterface, paramBoolean, paramInt1, paramInt2, paramInt3, paramString, arrayOfByte);
      return 100;
      arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    }
  }
  
  public long a()
  {
    return a().getLong("k_version", 0L);
  }
  
  public Bitmap a(int paramInt1, int paramInt2)
  {
    localObject7 = null;
    if (this.jdField_a_of_type_Jrd == null) {
      this.jdField_a_of_type_Jrd = new jrd("StatusIcon_", this);
    }
    localObject3 = (ActionInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
    Object localObject5 = paramInt1 + "_s_" + paramInt2;
    Object localObject6 = this.jdField_a_of_type_Jrd;
    Object localObject1;
    if (localObject3 != null) {
      if (paramInt2 == 201)
      {
        localObject1 = ((ActionInfo)localObject3).jdField_a_of_type_JavaLangString;
        localObject6 = ((jrd)localObject6).a((String)localObject5, null, (String)localObject1);
        if ((localObject3 == null) && (c()) && (localObject6 == null)) {
          this.jdField_a_of_type_JavaUtilHashSet.add(localObject5);
        }
        if (paramInt2 != 201) {
          break label256;
        }
      }
    }
    try
    {
      if (BaseApplicationImpl.a != null)
      {
        localObject5 = (Bitmap)BaseApplicationImpl.a.get("StatusIcon_RichStatusDefaultBig");
        localObject1 = localObject5;
        localObject3 = localObject7;
        if (localObject5 == null) {
          localObject1 = localObject5;
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        label208:
        localObject2 = null;
        label256:
        localObject3 = localObject7;
      }
    }
    try
    {
      localObject5 = BitmapManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources(), 2130841573);
      localObject1 = localObject5;
      BaseApplicationImpl.a.put("StatusIcon_RichStatusDefaultSmall", localObject5, (byte)0);
      localObject3 = localObject7;
      localObject1 = localObject5;
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      Object localObject4 = localObject7;
      break label208;
      localObject2 = null;
      break label208;
      localObject2 = null;
      localObject4 = localObject7;
      break label208;
    }
    if (localObject6 != null) {
      localObject1 = localObject6;
    }
    while (paramInt2 == 201)
    {
      return localObject1;
      localObject1 = ((ActionInfo)localObject3).b;
      break;
      localObject1 = null;
      break;
      localObject1 = BitmapManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources(), 2130841573);
      localObject3 = localObject7;
      break label208;
      if (paramInt2 != 200) {
        break label381;
      }
      if (BaseApplicationImpl.a != null)
      {
        localObject3 = (Bitmap)BaseApplicationImpl.a.get("StatusIcon_RichStatusDefaultSmall");
        if (localObject3 != null) {
          break label376;
        }
        localObject3 = BitmapManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources(), 2130841575);
        BaseApplicationImpl.a.put("StatusIcon_RichStatusDefaultSmall", localObject3, (byte)0);
        localObject1 = null;
        break label208;
      }
      localObject3 = BitmapManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources(), 2130841575);
      localObject1 = null;
      break label208;
    }
    return localObject3;
  }
  
  public ActionInfo a(int paramInt)
  {
    ActionInfo localActionInfo = (ActionInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localActionInfo == null) {
      c();
    }
    return localActionInfo;
  }
  
  public RichStatus a()
  {
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus != null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
      return localObject2;
    }
    Object localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
    if (localObject1 != null)
    {
      localObject1 = ((FriendsManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      if (localObject1 == null) {}
    }
    for (localObject1 = ((ExtensionInfo)localObject1).getRichStatus();; localObject1 = null)
    {
      localObject2 = localObject1;
      if (localObject1 != null) {
        break;
      }
      return new RichStatus(null);
    }
  }
  
  public String a()
  {
    Object localObject = a();
    if (((RichStatus)localObject).b == 14)
    {
      localObject = a(((RichStatus)localObject).b);
      if (localObject != null) {
        return ((ActionInfo)localObject).jdField_c_of_type_JavaLangString;
      }
      return "听音乐";
    }
    StringBuilder localStringBuilder = new StringBuilder().append(((RichStatus)localObject).jdField_c_of_type_JavaLangString);
    if (TextUtils.isEmpty(((RichStatus)localObject).jdField_d_of_type_JavaLangString)) {}
    for (localObject = "";; localObject = ((RichStatus)localObject).jdField_d_of_type_JavaLangString) {
      return (String)localObject;
    }
  }
  
  public String a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    return paramString1.replace("$I", Integer.toString(paramInt1)).replace("$U", Integer.toString(paramInt2)).replace("$A", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).replace("$S", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid()).replace("$N", paramString2);
  }
  
  /* Error */
  public ArrayList a()
  {
    // Byte code:
    //   0: new 145	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 146	java/util/ArrayList:<init>	()V
    //   7: astore 8
    //   9: aload_0
    //   10: getfield 150	com/tencent/mobileqq/richstatus/StatusManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13: bipush 8
    //   15: invokevirtual 670	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   18: checkcast 712	com/tencent/mobileqq/model/FriendManager
    //   21: astore 10
    //   23: aload 10
    //   25: ifnull +261 -> 286
    //   28: invokestatic 468	java/lang/System:currentTimeMillis	()J
    //   31: ldc2_w 713
    //   34: ldiv
    //   35: lstore_2
    //   36: aload_0
    //   37: getfield 609	com/tencent/mobileqq/richstatus/StatusManager:r	I
    //   40: istore_1
    //   41: aload_0
    //   42: getfield 611	com/tencent/mobileqq/richstatus/StatusManager:s	I
    //   45: i2l
    //   46: lstore 4
    //   48: aload_0
    //   49: getfield 150	com/tencent/mobileqq/richstatus/StatusManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   52: invokevirtual 502	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   55: astore 6
    //   57: aload 6
    //   59: ifnonnull +569 -> 628
    //   62: ldc_w 698
    //   65: astore 6
    //   67: aload 10
    //   69: invokeinterface 716 1 0
    //   74: astore 7
    //   76: aload 7
    //   78: ifnull +208 -> 286
    //   81: aload 7
    //   83: invokeinterface 719 1 0
    //   88: ifle +198 -> 286
    //   91: aload 7
    //   93: invokeinterface 720 1 0
    //   98: astore 7
    //   100: aload 7
    //   102: invokeinterface 399 1 0
    //   107: ifeq +179 -> 286
    //   110: aload 7
    //   112: invokeinterface 402 1 0
    //   117: checkcast 722	com/tencent/mobileqq/persistence/Entity
    //   120: checkcast 724	com/tencent/mobileqq/data/Friends
    //   123: astore 9
    //   125: aload 10
    //   127: aload 9
    //   129: getfield 727	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   132: invokeinterface 728 2 0
    //   137: astore 11
    //   139: aload 11
    //   141: ifnull -41 -> 100
    //   144: aload 6
    //   146: aload 9
    //   148: getfield 727	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   151: invokevirtual 731	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   154: ifne -54 -> 100
    //   157: lload_2
    //   158: aload 11
    //   160: getfield 734	com/tencent/mobileqq/data/ExtensionInfo:richTime	J
    //   163: lsub
    //   164: ldc2_w 735
    //   167: lcmp
    //   168: ifge -68 -> 100
    //   171: aload 11
    //   173: invokevirtual 680	com/tencent/mobileqq/data/ExtensionInfo:getRichStatus	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   176: astore 12
    //   178: iload_1
    //   179: aload 12
    //   181: getfield 560	com/tencent/mobileqq/richstatus/RichStatus:b	I
    //   184: if_icmpne -84 -> 100
    //   187: lload 4
    //   189: aload 12
    //   191: getfield 738	com/tencent/mobileqq/richstatus/RichStatus:jdField_c_of_type_Int	I
    //   194: i2l
    //   195: lcmp
    //   196: ifeq +9 -> 205
    //   199: iload_1
    //   200: bipush 14
    //   202: if_icmpne -102 -> 100
    //   205: new 740	PersonalState/UserProfile
    //   208: dup
    //   209: invokespecial 741	PersonalState/UserProfile:<init>	()V
    //   212: astore 13
    //   214: aload 13
    //   216: aload 9
    //   218: getfield 727	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   221: invokestatic 747	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   224: putfield 750	PersonalState/UserProfile:lEctID	J
    //   227: aload 13
    //   229: aload 9
    //   231: invokestatic 755	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/data/Friends;)Ljava/lang/String;
    //   234: putfield 758	PersonalState/UserProfile:strNick	Ljava/lang/String;
    //   237: aload 13
    //   239: aload 9
    //   241: getfield 762	com/tencent/mobileqq/data/Friends:status	B
    //   244: i2l
    //   245: putfield 765	PersonalState/UserProfile:nStatus	J
    //   248: aload 13
    //   250: aload 9
    //   252: getfield 769	com/tencent/mobileqq/data/Friends:faceid	S
    //   255: putfield 772	PersonalState/UserProfile:wFace	S
    //   258: aload 13
    //   260: aload 12
    //   262: putfield 775	PersonalState/UserProfile:rs	Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   265: aload 13
    //   267: aload 11
    //   269: getfield 734	com/tencent/mobileqq/data/ExtensionInfo:richTime	J
    //   272: putfield 776	PersonalState/UserProfile:richTime	J
    //   275: aload 8
    //   277: aload 13
    //   279: invokevirtual 388	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   282: pop
    //   283: goto -183 -> 100
    //   286: aload 8
    //   288: invokevirtual 450	java/util/ArrayList:size	()I
    //   291: ifle +175 -> 466
    //   294: aload_0
    //   295: getfield 150	com/tencent/mobileqq/richstatus/StatusManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   298: invokevirtual 779	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   301: invokevirtual 785	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   304: astore 9
    //   306: aconst_null
    //   307: astore 6
    //   309: aload 9
    //   311: invokevirtual 790	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   314: astore 7
    //   316: aload 7
    //   318: astore 6
    //   320: aload 6
    //   322: invokevirtual 793	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   325: aload 8
    //   327: invokevirtual 394	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   330: astore 7
    //   332: aload 7
    //   334: invokeinterface 399 1 0
    //   339: ifeq +235 -> 574
    //   342: aload 7
    //   344: invokeinterface 402 1 0
    //   349: checkcast 740	PersonalState/UserProfile
    //   352: astore 11
    //   354: aload 10
    //   356: aload 11
    //   358: getfield 750	PersonalState/UserProfile:lEctID	J
    //   361: invokestatic 796	java/lang/Long:toString	(J)Ljava/lang/String;
    //   364: invokeinterface 799 2 0
    //   369: astore 12
    //   371: aload 12
    //   373: ifnull +192 -> 565
    //   376: aload 11
    //   378: aload 12
    //   380: getfield 804	com/tencent/mobileqq/data/Card:iFaceNum	I
    //   383: i2l
    //   384: putfield 807	PersonalState/UserProfile:nPicNum	J
    //   387: aload 11
    //   389: aload 12
    //   391: getfield 810	com/tencent/mobileqq/data/Card:age	B
    //   394: putfield 813	PersonalState/UserProfile:bAge	B
    //   397: aload 12
    //   399: getfield 816	com/tencent/mobileqq/data/Card:shGender	S
    //   402: ifne +103 -> 505
    //   405: aload 11
    //   407: iconst_0
    //   408: putfield 819	PersonalState/UserProfile:bSex	B
    //   411: goto -79 -> 332
    //   414: astore 7
    //   416: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   419: ifeq +14 -> 433
    //   422: ldc 17
    //   424: iconst_2
    //   425: aload 7
    //   427: invokevirtual 822	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   430: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   433: aload 6
    //   435: ifnull +8 -> 443
    //   438: aload 6
    //   440: invokevirtual 824	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   443: aload 9
    //   445: ifnull +8 -> 453
    //   448: aload 9
    //   450: invokevirtual 825	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   453: aload 8
    //   455: new 827	jtm
    //   458: dup
    //   459: aload_0
    //   460: invokespecial 828	jtm:<init>	(Lcom/tencent/mobileqq/richstatus/StatusManager;)V
    //   463: invokestatic 834	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   466: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   469: ifeq +33 -> 502
    //   472: ldc 51
    //   474: iconst_2
    //   475: new 315	java/lang/StringBuilder
    //   478: dup
    //   479: invokespecial 316	java/lang/StringBuilder:<init>	()V
    //   482: ldc_w 836
    //   485: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: aload 8
    //   490: invokevirtual 450	java/util/ArrayList:size	()I
    //   493: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   496: invokevirtual 333	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   499: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   502: aload 8
    //   504: areturn
    //   505: aload 12
    //   507: getfield 816	com/tencent/mobileqq/data/Card:shGender	S
    //   510: iconst_1
    //   511: if_icmpne +45 -> 556
    //   514: aload 11
    //   516: iconst_1
    //   517: putfield 819	PersonalState/UserProfile:bSex	B
    //   520: goto -188 -> 332
    //   523: astore 8
    //   525: aload 6
    //   527: astore 7
    //   529: aload 8
    //   531: astore 6
    //   533: aload 7
    //   535: ifnull +8 -> 543
    //   538: aload 7
    //   540: invokevirtual 824	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   543: aload 9
    //   545: ifnull +8 -> 553
    //   548: aload 9
    //   550: invokevirtual 825	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   553: aload 6
    //   555: athrow
    //   556: aload 11
    //   558: iconst_2
    //   559: putfield 819	PersonalState/UserProfile:bSex	B
    //   562: goto -230 -> 332
    //   565: aload 11
    //   567: iconst_2
    //   568: putfield 819	PersonalState/UserProfile:bSex	B
    //   571: goto -239 -> 332
    //   574: aload 6
    //   576: invokevirtual 837	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   579: aload 6
    //   581: ifnull +8 -> 589
    //   584: aload 6
    //   586: invokevirtual 824	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   589: aload 9
    //   591: ifnull -138 -> 453
    //   594: aload 9
    //   596: invokevirtual 825	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   599: goto -146 -> 453
    //   602: astore 6
    //   604: aconst_null
    //   605: astore 7
    //   607: goto -74 -> 533
    //   610: astore 8
    //   612: aload 6
    //   614: astore 7
    //   616: aload 8
    //   618: astore 6
    //   620: goto -87 -> 533
    //   623: astore 7
    //   625: goto -209 -> 416
    //   628: goto -561 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	631	0	this	StatusManager
    //   40	163	1	i1	int
    //   35	123	2	l1	long
    //   46	142	4	l2	long
    //   55	530	6	localObject1	Object
    //   602	11	6	localObject2	Object
    //   618	1	6	localObject3	Object
    //   74	269	7	localObject4	Object
    //   414	12	7	localException1	Exception
    //   527	88	7	localObject5	Object
    //   623	1	7	localException2	Exception
    //   7	496	8	localArrayList	ArrayList
    //   523	7	8	localObject6	Object
    //   610	7	8	localObject7	Object
    //   123	472	9	localObject8	Object
    //   21	334	10	localFriendManager	com.tencent.mobileqq.model.FriendManager
    //   137	429	11	localObject9	Object
    //   176	330	12	localObject10	Object
    //   212	66	13	localUserProfile	UserProfile
    // Exception table:
    //   from	to	target	type
    //   320	332	414	java/lang/Exception
    //   332	371	414	java/lang/Exception
    //   376	411	414	java/lang/Exception
    //   505	520	414	java/lang/Exception
    //   556	562	414	java/lang/Exception
    //   565	571	414	java/lang/Exception
    //   574	579	414	java/lang/Exception
    //   320	332	523	finally
    //   332	371	523	finally
    //   376	411	523	finally
    //   505	520	523	finally
    //   556	562	523	finally
    //   565	571	523	finally
    //   574	579	523	finally
    //   309	316	602	finally
    //   416	433	610	finally
    //   309	316	623	java/lang/Exception
  }
  
  public ArrayList a(ArrayList paramArrayList)
  {
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    int i2 = paramArrayList.size();
    Object localObject;
    if ((localHashMap != null) && (localHashMap.size() > 0) && (i2 > 0))
    {
      i1 = i2 - 1;
      while (i1 > -1)
      {
        localObject = (UserProfile)paramArrayList.get(i1);
        UserProfile localUserProfile = (UserProfile)localHashMap.get(Long.valueOf(((UserProfile)localObject).lEctID));
        if (localUserProfile != null)
        {
          localUserProfile.bAge = ((UserProfile)localObject).bAge;
          localUserProfile.bSex = ((UserProfile)localObject).bSex;
          localUserProfile.strDesc = ((UserProfile)localObject).strDesc;
          paramArrayList.remove(i1);
        }
        i1 -= 1;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("filterFriends ").append(i2).append(" - ");
      if (localHashMap == null) {
        break label185;
      }
    }
    label185:
    for (int i1 = localHashMap.size();; i1 = -1)
    {
      QLog.d("Q.richstatus.mate", 2, i1 + "=" + paramArrayList.size());
      return paramArrayList;
    }
  }
  
  public ArrayList a(ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    if (paramInt == -1)
    {
      localArrayList.addAll(paramArrayList1);
      localObject1 = paramArrayList1.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (UserProfile)((Iterator)localObject1).next();
        localHashMap.put(Long.valueOf(((UserProfile)localObject2).lEctID), localObject2);
      }
    }
    Object localObject1 = paramArrayList1.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (UserProfile)((Iterator)localObject1).next();
      if (((UserProfile)localObject2).bSex == paramInt)
      {
        localArrayList.add(localObject2);
        localHashMap.put(Long.valueOf(((UserProfile)localObject2).lEctID), localObject2);
      }
    }
    Object localObject2 = Long.valueOf(0L);
    try
    {
      long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      localObject1 = Long.valueOf(l1);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.w("Q.richstatus.xml", 2, localException.toString());
          localObject1 = localObject2;
          continue;
          localException.bAge = ((UserProfile)localObject2).bAge;
          localException.bSex = ((UserProfile)localObject2).bSex;
          localException.strDesc = ((UserProfile)localObject2).strDesc;
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap = localHashMap;
      if (!QLog.isColorLevel()) {
        break label396;
      }
    }
    localHashMap.put(localObject1, new UserProfile());
    localObject1 = paramArrayList2.iterator();
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (UserProfile)((Iterator)localObject1).next();
        UserProfile localUserProfile = (UserProfile)localHashMap.get(Long.valueOf(((UserProfile)localObject2).lEctID));
        if (localUserProfile == null)
        {
          localArrayList.add(localObject2);
          continue;
        }
      }
      localObject1 = new StringBuilder().append("mergeFriendsStrangers ");
      if (paramArrayList1 == null) {
        break;
      }
    }
    for (int i1 = paramArrayList1.size();; i1 = -1)
    {
      QLog.d("Q.richstatus.mate", 2, i1 + " " + paramArrayList2.size() + " " + paramInt + "=" + localArrayList.size());
      label396:
      return localArrayList;
    }
  }
  
  public void a()
  {
    StatusServlet.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(Object paramObject)
  {
    if (paramObject == null) {}
    label79:
    label116:
    do
    {
      for (;;)
      {
        return;
        if ((paramObject instanceof IIconListener))
        {
          if (this.jdField_a_of_type_JavaUtilLinkedList == null)
          {
            this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
            this.jdField_a_of_type_JavaUtilLinkedList.add((IIconListener)paramObject);
          }
        }
        else
        {
          if ((paramObject instanceof IActionListener))
          {
            if (this.jdField_b_of_type_JavaUtilLinkedList != null) {
              break label217;
            }
            this.jdField_b_of_type_JavaUtilLinkedList = new LinkedList();
            this.jdField_b_of_type_JavaUtilLinkedList.add((IActionListener)paramObject);
          }
          if ((paramObject instanceof IImageListener))
          {
            if (this.jdField_c_of_type_JavaUtilLinkedList != null) {
              break label243;
            }
            this.jdField_c_of_type_JavaUtilLinkedList = new LinkedList();
            this.jdField_c_of_type_JavaUtilLinkedList.add((IImageListener)paramObject);
          }
          if ((paramObject instanceof IStatusListener))
          {
            if (this.d != null) {
              break label269;
            }
            this.d = new LinkedList();
            this.d.add((IStatusListener)paramObject);
          }
        }
        for (;;)
        {
          if (!(paramObject instanceof ISameStatusListener)) {
            break label293;
          }
          if (this.e != null) {
            break label295;
          }
          this.e = new LinkedList();
          this.e.add((ISameStatusListener)paramObject);
          return;
          if (this.jdField_a_of_type_JavaUtilLinkedList.contains(paramObject)) {
            break;
          }
          this.jdField_a_of_type_JavaUtilLinkedList.add((IIconListener)paramObject);
          break;
          if (this.jdField_b_of_type_JavaUtilLinkedList.contains(paramObject)) {
            break label79;
          }
          this.jdField_b_of_type_JavaUtilLinkedList.add((IActionListener)paramObject);
          break label79;
          if (this.jdField_c_of_type_JavaUtilLinkedList.contains(paramObject)) {
            break label116;
          }
          this.jdField_c_of_type_JavaUtilLinkedList.add((IImageListener)paramObject);
          break label116;
          if (!this.d.contains(paramObject)) {
            this.d.add((IStatusListener)paramObject);
          }
        }
      }
    } while (this.e.contains(paramObject));
    label217:
    label243:
    this.e.add((ISameStatusListener)paramObject);
    label269:
    label293:
    label295:
    return;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "sp_hot_status", paramString).commit();
  }
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap, int paramInt)
  {
    if ((paramString2 == null) && (paramBitmap != null)) {
      this.jdField_a_of_type_JavaUtilHashSet.remove(paramString1);
    }
    paramString1 = paramString1.split("_");
    int i1;
    if (paramString1.length == 3)
    {
      if (this.jdField_a_of_type_JavaUtilLinkedList != null)
      {
        paramInt = Integer.parseInt(paramString1[0]);
        i1 = Integer.parseInt(paramString1[2]);
        paramString1 = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (paramString1.hasNext()) {
          ((IIconListener)paramString1.next()).a(paramInt, i1, paramBitmap);
        }
      }
    }
    else if ((paramString1.length == 2) && (this.jdField_c_of_type_JavaUtilLinkedList != null))
    {
      i1 = Integer.parseInt(paramString1[0]);
      int i2 = Integer.parseInt(paramString1[1]);
      paramString1 = this.jdField_c_of_type_JavaUtilLinkedList.iterator();
      while (paramString1.hasNext()) {
        ((IImageListener)paramString1.next()).a(i1, i2, paramBitmap, paramInt);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (((this.jdField_a_of_type_JavaUtilLinkedList == null) || (this.jdField_a_of_type_JavaUtilLinkedList.size() == 0)) && ((this.jdField_c_of_type_JavaUtilLinkedList == null) || (this.jdField_c_of_type_JavaUtilLinkedList.size() == 0)))
    {
      this.jdField_a_of_type_JavaUtilHashSet.clear();
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
    label50:
    String str;
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        localObject1 = str.split("_");
        localObject2 = (ActionInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(Integer.parseInt(localObject1[0]));
        if (localObject2 != null) {
          if (localObject1.length == 3) {
            if (Integer.parseInt(localObject1[2]) == 201) {
              localObject1 = ((ActionInfo)localObject2).jdField_a_of_type_JavaLangString;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = this.jdField_a_of_type_Jrd.a(str, null, (String)localObject1);
        if (localObject2 == null) {
          break label50;
        }
        a(str, (String)localObject1, (Bitmap)localObject2, 1);
        break label50;
        localObject1 = ((ActionInfo)localObject2).b;
        continue;
        if ((localObject1.length != 2) || (TextUtils.isEmpty(((ActionInfo)localObject2).g))) {
          break label224;
        }
        localObject1 = ((ActionInfo)localObject2).g.replace("$U", localObject1[1]);
        continue;
      }
      localIterator.remove();
      break label50;
      if (!paramBoolean) {
        break;
      }
      this.jdField_a_of_type_JavaUtilHashSet.clear();
      return;
      label224:
      localObject1 = null;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus != null;
  }
  
  public boolean a(long paramLong)
  {
    long l2 = a().getLong("k_version", 65L);
    long l1 = l2;
    if (l2 < 65L) {
      l1 = 65L;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "StatusManager.isNewVersion(): localVersion " + l1 + " serverVersion " + paramLong + ", builtInVersion " + 65L);
    }
    return paramLong > l1;
  }
  
  public boolean a(BaseActivity paramBaseActivity, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      return false;
      paramString1 = a(paramBaseActivity, paramString1, paramInt1, paramInt2, paramString2);
    } while (paramString1 == null);
    paramBaseActivity.startActivity(paramString1);
    return true;
  }
  
  public boolean a(File paramFile, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "saveActions(" + paramFile + ", " + paramLong + ")");
    }
    for (;;)
    {
      try
      {
        Object localObject1 = a(new FileInputStream(paramFile));
        ??? = (SparseArray)localObject1[0];
        ArrayList localArrayList = (ArrayList)localObject1[1];
        if ((??? != null) && (((SparseArray)???).size() > 0) && (localArrayList != null) && (localArrayList.size() > 0))
        {
          localObject1 = this.jdField_a_of_type_AndroidUtilSparseArray;
          synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
          {
            AsyncTask localAsyncTask = this.jdField_a_of_type_AndroidOsAsyncTask;
            if (localAsyncTask != null) {
              localAsyncTask.cancel(true);
            }
            this.jdField_a_of_type_AndroidUtilSparseArray = ((SparseArray)???);
            if ((localArrayList == null) || (localArrayList.size() <= 0)) {}
          }
        }
        boolean bool;
        if (!QLog.isColorLevel()) {
          continue;
        }
      }
      catch (FileNotFoundException paramFile)
      {
        synchronized (this.jdField_a_of_type_JavaUtilArrayList)
        {
          this.jdField_a_of_type_JavaUtilArrayList.clear();
          this.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
          this.i = System.currentTimeMillis();
          ??? = new File(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getFilesDir(), "rich_status.xml");
          if ((paramFile.renameTo((File)???)) || (paramFile.renameTo((File)???)) || (paramFile.renameTo((File)???)))
          {
            paramFile = a().edit();
            paramFile.putLong("k_version", paramLong).putLong("k_update_time", this.i).commit();
            if (a((SparseArray)localObject1, this.jdField_a_of_type_AndroidUtilSparseArray)) {
              paramFile.putLong("k_icon", paramLong).commit();
            }
            bool = true;
            if (QLog.isColorLevel()) {
              QLog.d("Q.richstatus.xml", 2, "saveActions return with " + bool);
            }
            return bool;
            paramFile = finally;
            throw paramFile;
            paramFile = paramFile;
            paramFile.printStackTrace();
            bool = false;
          }
        }
      }
      QLog.d("Q.richstatus.xml", 2, "saveActions rename failed!");
    }
  }
  
  public Object[] a(int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    if (this.jdField_a_of_type_Jrd == null) {
      this.jdField_a_of_type_Jrd = new jrd("StatusIcon_", this);
    }
    Object localObject3 = (ActionInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
    String str2 = paramInt1 + "_" + paramInt2;
    Object localObject1 = this.jdField_a_of_type_Jrd.a(str2);
    String str1;
    if (localObject1 == null)
    {
      if ((localObject3 == null) && (c())) {
        this.jdField_a_of_type_JavaUtilHashSet.add(str2);
      }
      if ((localObject3 != null) && (((ActionInfo)localObject3).g != null))
      {
        localObject1 = ((ActionInfo)localObject3).g.replace("$U", Integer.toString(paramInt2)).replace("$D", Integer.toString(paramInt2 % 100)).replace("$T", Integer.toString(paramInt2 % 1000));
        str1 = paramInt1 + "_s_" + 201;
        localObject3 = this.jdField_a_of_type_Jrd.a(str1);
        jrd localjrd = this.jdField_a_of_type_Jrd;
        if (localObject3 != null)
        {
          label201:
          localjrd.a(str2, (String)localObject2, (String)localObject1);
          if (localObject3 != null) {
            break label324;
          }
          if (BaseApplicationImpl.a == null) {
            break label297;
          }
          localObject1 = (Bitmap)BaseApplicationImpl.a.get("StatusIcon_RichStatusDefaultBig");
          if (localObject1 != null) {
            break label319;
          }
          localObject1 = BitmapManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources(), 2130841573);
          BaseApplicationImpl.a.put("StatusIcon_RichStatusDefaultSmall", localObject1, (byte)0);
          paramInt1 = 0;
        }
      }
    }
    for (;;)
    {
      jdField_a_of_type_ArrayOfJavaLangObject[0] = localObject1;
      jdField_a_of_type_ArrayOfJavaLangObject[1] = Integer.valueOf(paramInt1);
      return jdField_a_of_type_ArrayOfJavaLangObject;
      localObject2 = str1;
      break label201;
      label297:
      localObject1 = BitmapManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources(), 2130841573);
      paramInt1 = 0;
      continue;
      label319:
      paramInt1 = 0;
      continue;
      label324:
      localObject1 = localObject3;
      paramInt1 = 0;
      continue;
      localObject1 = null;
      break;
      paramInt1 = 1;
    }
  }
  
  public Bitmap b(int paramInt1, int paramInt2)
  {
    return (Bitmap)a(paramInt1, paramInt2)[0];
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.mate", 2, "clearSameFriends");
    }
    this.jdField_c_of_type_JavaUtilArrayList = null;
    this.jdField_b_of_type_JavaUtilArrayList = null;
    if (this.jdField_b_of_type_AndroidOsAsyncTask != null)
    {
      this.jdField_b_of_type_AndroidOsAsyncTask.cancel(true);
      this.jdField_b_of_type_AndroidOsAsyncTask = null;
    }
  }
  
  public void b(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return;
      if (((paramObject instanceof IIconListener)) && (this.jdField_a_of_type_JavaUtilLinkedList != null)) {
        this.jdField_a_of_type_JavaUtilLinkedList.remove(paramObject);
      }
      if (((paramObject instanceof IActionListener)) && (this.jdField_b_of_type_JavaUtilLinkedList != null)) {
        this.jdField_b_of_type_JavaUtilLinkedList.remove(paramObject);
      }
      if (((paramObject instanceof IImageListener)) && (this.jdField_c_of_type_JavaUtilLinkedList != null)) {
        this.jdField_c_of_type_JavaUtilLinkedList.remove(paramObject);
      }
      if (((paramObject instanceof IStatusListener)) && (this.d != null)) {
        this.d.remove(paramObject);
      }
    } while ((!(paramObject instanceof ISameStatusListener)) || (this.e == null));
    this.e.remove(paramObject);
  }
  
  public boolean b()
  {
    SharedPreferences localSharedPreferences = b();
    boolean bool = localSharedPreferences.getBoolean("k_sync_ss", false);
    long l1 = System.currentTimeMillis();
    if ((Math.abs(l1 - this.g) > 180000L) && (Math.abs(l1 - localSharedPreferences.getLong("k_ss_time", 0L)) > 60000L))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver == null) {
        d();
      }
      this.g = l1;
      StatusServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.shuo", 2, "getSyncShuoShuo " + bool);
    }
    return bool;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusManager
 * JD-Core Version:    0.7.0.1
 */