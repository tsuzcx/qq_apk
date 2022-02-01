package com.qqreader;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QRPluginBooks
{
  public static final String a = "UTF-8";
  public static final String b = "/Tencent/ReaderZone/";
  public static final String c = "pluginBooks";
  public static final String d = "title";
  public static final String e = "lmcpushname";
  public static final String f = "author";
  public static final String g = "choose";
  private static final String h = "PluginBooks";
  private Context jdField_a_of_type_AndroidContentContext = null;
  JSONArray jdField_a_of_type_OrgJsonJSONArray = null;
  
  public QRPluginBooks(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = a(this.jdField_a_of_type_AndroidContentContext);
    if (!TextUtils.isEmpty(paramContext))
    {
      this.jdField_a_of_type_OrgJsonJSONArray = new JSONArray(paramContext);
      return;
    }
    this.jdField_a_of_type_OrgJsonJSONArray = new JSONArray();
  }
  
  /* Error */
  private String a(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_1
    //   7: invokestatic 63	com/qqreader/QRUtility:a	(Landroid/content/Context;)Ljava/lang/String;
    //   10: astore_1
    //   11: new 65	java/io/File
    //   14: dup
    //   15: aload_1
    //   16: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: astore_1
    //   20: aload_1
    //   21: invokevirtual 70	java/io/File:exists	()Z
    //   24: ifne +40 -> 64
    //   27: ldc 72
    //   29: astore_3
    //   30: iconst_0
    //   31: ifeq +11 -> 42
    //   34: new 74	java/lang/NullPointerException
    //   37: dup
    //   38: invokespecial 75	java/lang/NullPointerException:<init>	()V
    //   41: athrow
    //   42: iconst_0
    //   43: ifeq +11 -> 54
    //   46: new 74	java/lang/NullPointerException
    //   49: dup
    //   50: invokespecial 75	java/lang/NullPointerException:<init>	()V
    //   53: athrow
    //   54: aload_3
    //   55: areturn
    //   56: astore_1
    //   57: aload_1
    //   58: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   61: ldc 72
    //   63: areturn
    //   64: new 80	java/io/FileInputStream
    //   67: dup
    //   68: aload_1
    //   69: invokespecial 83	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   72: astore_3
    //   73: new 85	java/io/ByteArrayOutputStream
    //   76: dup
    //   77: invokespecial 86	java/io/ByteArrayOutputStream:<init>	()V
    //   80: astore_1
    //   81: sipush 4096
    //   84: newarray byte
    //   86: astore 4
    //   88: aload_3
    //   89: aload 4
    //   91: iconst_0
    //   92: sipush 4096
    //   95: invokevirtual 92	java/io/InputStream:read	([BII)I
    //   98: istore_2
    //   99: iload_2
    //   100: iconst_m1
    //   101: if_icmpeq +52 -> 153
    //   104: aload_1
    //   105: aload 4
    //   107: iconst_0
    //   108: iload_2
    //   109: invokevirtual 96	java/io/ByteArrayOutputStream:write	([BII)V
    //   112: goto -24 -> 88
    //   115: astore 5
    //   117: aload_1
    //   118: astore 4
    //   120: aload_3
    //   121: astore_1
    //   122: aload 4
    //   124: astore_3
    //   125: aload 5
    //   127: astore 4
    //   129: aload 4
    //   131: invokevirtual 97	java/lang/Exception:printStackTrace	()V
    //   134: aload_1
    //   135: ifnull +7 -> 142
    //   138: aload_1
    //   139: invokevirtual 100	java/io/InputStream:close	()V
    //   142: aload_3
    //   143: ifnull +7 -> 150
    //   146: aload_3
    //   147: invokevirtual 101	java/io/ByteArrayOutputStream:close	()V
    //   150: ldc 72
    //   152: areturn
    //   153: new 103	java/lang/String
    //   156: dup
    //   157: aload_1
    //   158: invokevirtual 107	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   161: ldc 109
    //   163: invokespecial 112	java/lang/String:<init>	([BLjava/lang/String;)V
    //   166: astore 4
    //   168: aload_3
    //   169: ifnull +7 -> 176
    //   172: aload_3
    //   173: invokevirtual 100	java/io/InputStream:close	()V
    //   176: aload 4
    //   178: astore_3
    //   179: aload_1
    //   180: ifnull -126 -> 54
    //   183: aload_1
    //   184: invokevirtual 101	java/io/ByteArrayOutputStream:close	()V
    //   187: aload 4
    //   189: areturn
    //   190: astore_1
    //   191: aload_1
    //   192: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   195: aload 4
    //   197: areturn
    //   198: astore_1
    //   199: aload_1
    //   200: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   203: goto -53 -> 150
    //   206: astore_1
    //   207: aconst_null
    //   208: astore_3
    //   209: aload_3
    //   210: ifnull +7 -> 217
    //   213: aload_3
    //   214: invokevirtual 100	java/io/InputStream:close	()V
    //   217: aload 4
    //   219: ifnull +8 -> 227
    //   222: aload 4
    //   224: invokevirtual 101	java/io/ByteArrayOutputStream:close	()V
    //   227: aload_1
    //   228: athrow
    //   229: astore_3
    //   230: aload_3
    //   231: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   234: goto -7 -> 227
    //   237: astore_1
    //   238: goto -29 -> 209
    //   241: astore 5
    //   243: aload_1
    //   244: astore 4
    //   246: aload 5
    //   248: astore_1
    //   249: goto -40 -> 209
    //   252: astore 4
    //   254: aload_1
    //   255: astore 5
    //   257: aload 4
    //   259: astore_1
    //   260: aload_3
    //   261: astore 4
    //   263: aload 5
    //   265: astore_3
    //   266: goto -57 -> 209
    //   269: astore 4
    //   271: aconst_null
    //   272: astore_1
    //   273: aload 5
    //   275: astore_3
    //   276: goto -147 -> 129
    //   279: astore 4
    //   281: aload_3
    //   282: astore_1
    //   283: aload 5
    //   285: astore_3
    //   286: goto -157 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	this	QRPluginBooks
    //   0	289	1	paramContext	Context
    //   98	11	2	i	int
    //   29	185	3	localObject1	Object
    //   229	32	3	localIOException	java.io.IOException
    //   265	21	3	localContext1	Context
    //   1	244	4	localObject2	Object
    //   252	6	4	localObject3	Object
    //   261	1	4	localObject4	Object
    //   269	1	4	localException1	java.lang.Exception
    //   279	1	4	localException2	java.lang.Exception
    //   4	1	5	localObject5	Object
    //   115	11	5	localException3	java.lang.Exception
    //   241	6	5	localObject6	Object
    //   255	29	5	localContext2	Context
    // Exception table:
    //   from	to	target	type
    //   34	42	56	java/io/IOException
    //   46	54	56	java/io/IOException
    //   81	88	115	java/lang/Exception
    //   88	99	115	java/lang/Exception
    //   104	112	115	java/lang/Exception
    //   153	168	115	java/lang/Exception
    //   172	176	190	java/io/IOException
    //   183	187	190	java/io/IOException
    //   138	142	198	java/io/IOException
    //   146	150	198	java/io/IOException
    //   11	27	206	finally
    //   64	73	206	finally
    //   213	217	229	java/io/IOException
    //   222	227	229	java/io/IOException
    //   73	81	237	finally
    //   81	88	241	finally
    //   88	99	241	finally
    //   104	112	241	finally
    //   153	168	241	finally
    //   129	134	252	finally
    //   11	27	269	java/lang/Exception
    //   64	73	269	java/lang/Exception
    //   73	81	279	java/lang/Exception
  }
  
  /* Error */
  private boolean b(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_1
    //   3: ifnull +10 -> 13
    //   6: aload_1
    //   7: invokevirtual 117	java/lang/String:length	()I
    //   10: ifgt +7 -> 17
    //   13: iconst_0
    //   14: istore_2
    //   15: iload_2
    //   16: ireturn
    //   17: aconst_null
    //   18: astore 5
    //   20: aconst_null
    //   21: astore 4
    //   23: new 65	java/io/File
    //   26: dup
    //   27: aload_0
    //   28: getfield 38	com/qqreader/QRPluginBooks:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   31: invokestatic 63	com/qqreader/QRUtility:a	(Landroid/content/Context;)Ljava/lang/String;
    //   34: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   37: astore_3
    //   38: aload_3
    //   39: invokevirtual 121	java/io/File:getParentFile	()Ljava/io/File;
    //   42: astore 6
    //   44: aload 6
    //   46: invokevirtual 70	java/io/File:exists	()Z
    //   49: ifne +9 -> 58
    //   52: aload 6
    //   54: invokevirtual 124	java/io/File:mkdirs	()Z
    //   57: pop
    //   58: new 126	java/io/FileOutputStream
    //   61: dup
    //   62: aload_3
    //   63: invokespecial 127	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   66: astore_3
    //   67: aload_3
    //   68: aload_1
    //   69: invokevirtual 130	java/lang/String:getBytes	()[B
    //   72: invokevirtual 133	java/io/FileOutputStream:write	([B)V
    //   75: aload_3
    //   76: ifnull -61 -> 15
    //   79: aload_3
    //   80: invokevirtual 134	java/io/FileOutputStream:close	()V
    //   83: iconst_1
    //   84: ireturn
    //   85: astore_1
    //   86: iconst_1
    //   87: ireturn
    //   88: astore_1
    //   89: aload 4
    //   91: astore_1
    //   92: aload_1
    //   93: ifnull +7 -> 100
    //   96: aload_1
    //   97: invokevirtual 134	java/io/FileOutputStream:close	()V
    //   100: iconst_0
    //   101: ireturn
    //   102: astore_1
    //   103: aload 5
    //   105: astore_3
    //   106: aload_3
    //   107: ifnull +7 -> 114
    //   110: aload_3
    //   111: invokevirtual 134	java/io/FileOutputStream:close	()V
    //   114: aload_1
    //   115: athrow
    //   116: astore_1
    //   117: iconst_1
    //   118: ireturn
    //   119: astore_1
    //   120: iconst_1
    //   121: ireturn
    //   122: astore_1
    //   123: goto -17 -> 106
    //   126: astore_1
    //   127: aload_3
    //   128: astore_1
    //   129: goto -37 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	QRPluginBooks
    //   0	132	1	paramString	String
    //   1	15	2	bool	boolean
    //   37	91	3	localObject1	Object
    //   21	69	4	localObject2	Object
    //   18	86	5	localObject3	Object
    //   42	11	6	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   79	83	85	java/io/IOException
    //   23	58	88	java/lang/Exception
    //   58	67	88	java/lang/Exception
    //   23	58	102	finally
    //   58	67	102	finally
    //   96	100	116	java/io/IOException
    //   110	114	119	java/io/IOException
    //   67	75	122	finally
    //   67	75	126	java/lang/Exception
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_OrgJsonJSONArray == null) || (this.jdField_a_of_type_OrgJsonJSONArray.length() == 0)) {
      return false;
    }
    return b(this.jdField_a_of_type_OrgJsonJSONArray.toString());
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_OrgJsonJSONArray == null) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.jdField_a_of_type_OrgJsonJSONArray.length()) {
        try
        {
          int j = this.jdField_a_of_type_OrgJsonJSONArray.getJSONObject(i).getInt("id");
          if (j == paramInt) {
            return true;
          }
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          i += 1;
        }
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (this.jdField_a_of_type_OrgJsonJSONArray != null) {
      try
      {
        boolean bool = a(new JSONObject(paramString));
        return bool;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return false;
      }
    }
    return true;
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return false;
    }
    if (this.jdField_a_of_type_OrgJsonJSONArray != null) {}
    try
    {
      this.jdField_a_of_type_OrgJsonJSONArray.put(this.jdField_a_of_type_OrgJsonJSONArray.length(), paramJSONObject);
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.qqreader.QRPluginBooks
 * JD-Core Version:    0.7.0.1
 */