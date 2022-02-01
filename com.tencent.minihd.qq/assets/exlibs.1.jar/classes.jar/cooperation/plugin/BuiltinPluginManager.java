package cooperation.plugin;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class BuiltinPluginManager
{
  private static BuiltinPluginManager jdField_a_of_type_CooperationPluginBuiltinPluginManager;
  private static final String jdField_a_of_type_JavaLangString = "BuiltinPluginManager";
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "qqfav.apk", "qzone_plugin.apk", "qwallet_plugin.apk", "WeiyunPlugin.apk", "qlink_plugin.apk", "troop_plugin.apk", "Photoplus.apk", "BuscardPlugin.apk" };
  private Context jdField_a_of_type_AndroidContentContext;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private BuiltinPluginManager(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    b();
  }
  
  public static final BuiltinPluginManager a(Context paramContext)
  {
    if (jdField_a_of_type_CooperationPluginBuiltinPluginManager == null) {}
    try
    {
      if (jdField_a_of_type_CooperationPluginBuiltinPluginManager == null) {
        jdField_a_of_type_CooperationPluginBuiltinPluginManager = new BuiltinPluginManager(paramContext);
      }
      return jdField_a_of_type_CooperationPluginBuiltinPluginManager;
    }
    finally {}
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        if (paramString.equals(jdField_a_of_type_ArrayOfJavaLangString[i])) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public PluginInfo a(String paramString)
  {
    return (PluginInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    jdField_a_of_type_CooperationPluginBuiltinPluginManager = null;
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString);
  }
  
  public void b()
  {
    c();
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "init. built in plugin size:" + this.jdField_a_of_type_JavaUtilHashMap.size());
    }
  }
  
  /* Error */
  void c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 116	java/io/BufferedReader
    //   5: dup
    //   6: new 118	java/io/InputStreamReader
    //   9: dup
    //   10: aload_0
    //   11: getfield 46	cooperation/plugin/BuiltinPluginManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   14: invokevirtual 124	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   17: ldc 126
    //   19: invokevirtual 132	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   22: invokespecial 135	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   25: invokespecial 138	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   28: astore_1
    //   29: aload_1
    //   30: invokevirtual 141	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   33: astore_2
    //   34: aload_2
    //   35: ifnull +91 -> 126
    //   38: aload_2
    //   39: invokevirtual 144	java/lang/String:trim	()Ljava/lang/String;
    //   42: ldc 146
    //   44: invokevirtual 150	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   47: astore 4
    //   49: aload 4
    //   51: iconst_0
    //   52: aaload
    //   53: astore_3
    //   54: ldc 152
    //   56: astore_2
    //   57: aload 4
    //   59: arraylength
    //   60: iconst_1
    //   61: if_icmple +8 -> 69
    //   64: aload 4
    //   66: iconst_1
    //   67: aaload
    //   68: astore_2
    //   69: new 72	cooperation/plugin/PluginInfo
    //   72: dup
    //   73: invokespecial 153	cooperation/plugin/PluginInfo:<init>	()V
    //   76: astore 4
    //   78: aload 4
    //   80: aload_3
    //   81: putfield 156	cooperation/plugin/PluginInfo:mID	Ljava/lang/String;
    //   84: aload 4
    //   86: aload_2
    //   87: putfield 159	cooperation/plugin/PluginInfo:mMD5	Ljava/lang/String;
    //   90: aload 4
    //   92: iconst_1
    //   93: putfield 163	cooperation/plugin/PluginInfo:mUpdateType	I
    //   96: aload 4
    //   98: iconst_0
    //   99: putfield 166	cooperation/plugin/PluginInfo:mInstallType	I
    //   102: aload_0
    //   103: getfield 44	cooperation/plugin/BuiltinPluginManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   106: aload_3
    //   107: aload 4
    //   109: invokevirtual 170	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   112: pop
    //   113: goto -84 -> 29
    //   116: astore_2
    //   117: aload_1
    //   118: ifnull +7 -> 125
    //   121: aload_1
    //   122: invokevirtual 173	java/io/BufferedReader:close	()V
    //   125: return
    //   126: aload_1
    //   127: ifnull -2 -> 125
    //   130: aload_1
    //   131: invokevirtual 173	java/io/BufferedReader:close	()V
    //   134: return
    //   135: astore_1
    //   136: return
    //   137: astore_1
    //   138: aload_2
    //   139: ifnull +7 -> 146
    //   142: aload_2
    //   143: invokevirtual 173	java/io/BufferedReader:close	()V
    //   146: aload_1
    //   147: athrow
    //   148: astore_1
    //   149: return
    //   150: astore_2
    //   151: goto -5 -> 146
    //   154: astore_3
    //   155: aload_1
    //   156: astore_2
    //   157: aload_3
    //   158: astore_1
    //   159: goto -21 -> 138
    //   162: astore_1
    //   163: aconst_null
    //   164: astore_1
    //   165: goto -48 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	BuiltinPluginManager
    //   28	103	1	localBufferedReader	java.io.BufferedReader
    //   135	1	1	localException1	java.lang.Exception
    //   137	10	1	localObject1	Object
    //   148	8	1	localException2	java.lang.Exception
    //   158	1	1	localObject2	Object
    //   162	1	1	localIOException1	java.io.IOException
    //   164	1	1	localObject3	Object
    //   1	86	2	str	String
    //   116	27	2	localIOException2	java.io.IOException
    //   150	1	2	localException3	java.lang.Exception
    //   156	1	2	localObject4	Object
    //   53	54	3	localObject5	Object
    //   154	4	3	localObject6	Object
    //   47	61	4	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   29	34	116	java/io/IOException
    //   38	49	116	java/io/IOException
    //   57	64	116	java/io/IOException
    //   69	113	116	java/io/IOException
    //   130	134	135	java/lang/Exception
    //   2	29	137	finally
    //   121	125	148	java/lang/Exception
    //   142	146	150	java/lang/Exception
    //   29	34	154	finally
    //   38	49	154	finally
    //   57	64	154	finally
    //   69	113	154	finally
    //   2	29	162	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.plugin.BuiltinPluginManager
 * JD-Core Version:    0.7.0.1
 */