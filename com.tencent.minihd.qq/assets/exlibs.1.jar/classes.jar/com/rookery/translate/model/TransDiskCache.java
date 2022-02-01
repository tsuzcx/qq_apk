package com.rookery.translate.model;

import android.content.Context;
import android.os.Environment;
import com.jakewharton.disklrucache.DiskLruCache;
import com.jakewharton.disklrucache.DiskLruCache.Editor;
import com.jakewharton.disklrucache.DiskLruCache.Snapshot;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class TransDiskCache
  implements ICache
{
  private static final int jdField_a_of_type_Int = 0;
  private static final String jdField_a_of_type_JavaLangString = "TransDiskCache_simsun_qqi";
  private static final int b = 1;
  private final DiskLruCache jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache;
  
  public TransDiskCache(Context paramContext, int paramInt, long paramLong)
  {
    paramContext = a(paramContext);
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    this.a = DiskLruCache.open(paramContext, paramInt, 1, paramLong);
    a();
  }
  
  private File a(Context paramContext)
  {
    String str1 = Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + paramContext.getPackageName() + "/cache/";
    for (;;)
    {
      try
      {
        if (("mounted".equals(Environment.getExternalStorageState())) || (!Utils.a()))
        {
          str2 = Utils.a(paramContext).getPath();
          paramContext = str2;
          if (QLog.isColorLevel()) {
            QLog.d("Translator", 2, "[TransDiskCache] getDiskCacheDir:" + paramContext);
          }
          return new File(paramContext + File.separator + "TransDiskCache_simsun_qqi");
        }
        String str2 = paramContext.getCacheDir().getPath();
        paramContext = str2;
        continue;
        int i;
        paramContext = str1;
      }
      catch (NullPointerException localNullPointerException)
      {
        paramContext = paramContext.getCacheDir().getPath();
        if (paramContext != null)
        {
          i = paramContext.length();
          if (i <= 0) {}
        }
      }
      finally
      {
        if (QLog.isColorLevel()) {
          QLog.d("Translator", 2, "[TransDiskCache] getDiskCacheDir:" + str1);
        }
        return new File(str1 + File.separator + "TransDiskCache_simsun_qqi");
      }
    }
  }
  
  /* Error */
  private String b(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_1
    //   4: invokestatic 121	com/rookery/translate/model/Utils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 40	com/rookery/translate/model/TransDiskCache:a	Lcom/jakewharton/disklrucache/DiskLruCache;
    //   12: aload_1
    //   13: invokevirtual 125	com/jakewharton/disklrucache/DiskLruCache:get	(Ljava/lang/String;)Lcom/jakewharton/disklrucache/DiskLruCache$Snapshot;
    //   16: astore_1
    //   17: aload_1
    //   18: ifnull +25 -> 43
    //   21: aload_1
    //   22: astore_2
    //   23: aload_1
    //   24: iconst_0
    //   25: invokevirtual 131	com/jakewharton/disklrucache/DiskLruCache$Snapshot:getString	(I)Ljava/lang/String;
    //   28: astore_3
    //   29: aload_3
    //   30: astore_2
    //   31: aload_1
    //   32: ifnull +9 -> 41
    //   35: aload_1
    //   36: invokevirtual 134	com/jakewharton/disklrucache/DiskLruCache$Snapshot:close	()V
    //   39: aload_3
    //   40: astore_2
    //   41: aload_2
    //   42: areturn
    //   43: aload 4
    //   45: astore_2
    //   46: aload_1
    //   47: ifnull -6 -> 41
    //   50: aload_1
    //   51: invokevirtual 134	com/jakewharton/disklrucache/DiskLruCache$Snapshot:close	()V
    //   54: aconst_null
    //   55: areturn
    //   56: astore_3
    //   57: aconst_null
    //   58: astore_1
    //   59: aload_1
    //   60: astore_2
    //   61: aload_3
    //   62: invokevirtual 137	java/io/IOException:printStackTrace	()V
    //   65: aload 4
    //   67: astore_2
    //   68: aload_1
    //   69: ifnull -28 -> 41
    //   72: aload_1
    //   73: invokevirtual 134	com/jakewharton/disklrucache/DiskLruCache$Snapshot:close	()V
    //   76: aconst_null
    //   77: areturn
    //   78: astore_1
    //   79: aconst_null
    //   80: astore_2
    //   81: aload_2
    //   82: ifnull +7 -> 89
    //   85: aload_2
    //   86: invokevirtual 134	com/jakewharton/disklrucache/DiskLruCache$Snapshot:close	()V
    //   89: aload_1
    //   90: athrow
    //   91: astore_1
    //   92: goto -11 -> 81
    //   95: astore_3
    //   96: goto -37 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	TransDiskCache
    //   0	99	1	paramString	String
    //   22	64	2	localObject1	Object
    //   28	12	3	str	String
    //   56	6	3	localIOException1	IOException
    //   95	1	3	localIOException2	IOException
    //   1	65	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   8	17	56	java/io/IOException
    //   8	17	78	finally
    //   23	29	91	finally
    //   61	65	91	finally
    //   23	29	95	java/io/IOException
  }
  
  private void b(String paramString1, String paramString2)
  {
    DiskLruCache.Editor localEditor = null;
    String str = Utils.a(paramString1);
    paramString1 = localEditor;
    try
    {
      localEditor = this.a.edit(str);
      if (localEditor == null) {
        return;
      }
      paramString1 = localEditor;
      localEditor.set(0, paramString2);
      paramString1 = localEditor;
      localEditor.commit();
      return;
    }
    catch (IOException paramString2)
    {
      if (paramString1 != null) {
        try
        {
          paramString1.abort();
          return;
        }
        catch (IOException paramString1) {}
      }
    }
  }
  
  public Trans_entity a(String paramString1, long paramLong, String paramString2)
  {
    String str = a(Utils.a(paramString2, paramString1));
    if (str == null) {
      return null;
    }
    paramString2 = a(Utils.a(paramString2, paramString1, paramLong));
    paramString1 = Boolean.valueOf(false);
    if (paramString2 != null) {
      paramString1 = Boolean.valueOf(paramString2);
    }
    return new Trans_entity(str, paramString1.booleanValue());
  }
  
  public String a(String paramString)
  {
    return b(paramString);
  }
  
  public void a() {}
  
  public void a(String paramString) {}
  
  public void a(String paramString1, String paramString2)
  {
    if (paramString2 != null) {
      b(paramString1, paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong, Boolean paramBoolean)
  {
    a(Utils.a(paramString1, paramString2, paramLong), paramBoolean.toString());
  }
  
  public void a(String paramString1, String paramString2, long paramLong, Boolean paramBoolean, String paramString3)
  {
    a(Utils.a(paramString3, paramString1, paramLong), paramBoolean.toString());
    a(Utils.a(paramString3, paramString1), paramString2);
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    try
    {
      paramString = this.a.get(paramString);
      if (paramString != null) {
        bool1 = true;
      }
      bool2 = bool1;
      if (paramString != null)
      {
        paramString.close();
        bool2 = bool1;
      }
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    finally
    {
      if (0 == 0) {
        break label63;
      }
      throw new NullPointerException();
    }
    return bool2;
  }
  
  public void b()
  {
    try
    {
      this.a.delete();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.rookery.translate.model.TransDiskCache
 * JD-Core Version:    0.7.0.1
 */