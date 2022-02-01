package midas.x;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.midas.comm.APLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.Writer;
import java.security.MessageDigest;
import java.util.ArrayList;

public class v0
{
  public static final char[] b = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  public Context a = null;
  
  public v0() {}
  
  public v0(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(b[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(b[(paramArrayOfByte[i] & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static boolean g()
  {
    if (Build.CPU_ABI.startsWith("arm64-v8a")) {
      return false;
    }
    File[] arrayOfFile = a.r().d.getDir("midasplugins", 0).listFiles();
    int i = 0;
    while (i < arrayOfFile.length)
    {
      if (arrayOfFile[i].getName().startsWith("MidasCFT")) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public String a(String paramString)
  {
    byte[] arrayOfByte = new byte[1024];
    try
    {
      paramString = new FileInputStream(paramString);
      BufferedInputStream localBufferedInputStream = new BufferedInputStream(paramString);
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      for (;;)
      {
        int i = localBufferedInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localMessageDigest.update(arrayOfByte, 0, i);
      }
      localBufferedInputStream.close();
      paramString.close();
      paramString = a(localMessageDigest.digest());
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public void a(int paramInt)
  {
    z0.a(this.a, 1, paramInt);
  }
  
  public final void a(File paramFile)
  {
    paramFile.delete();
  }
  
  public void a(File paramFile, String paramString)
  {
    try
    {
      APLog.i("APMidasDownUtif", "resultData file from sdcard copy to data plugins");
      Object localObject1 = this.a.getApplicationContext().getDir("midaspluginsTemp", 0);
      if (!((File)localObject1).exists()) {
        ((File)localObject1).mkdir();
      }
      paramFile = new FileInputStream(paramFile);
      BufferedInputStream localBufferedInputStream = new BufferedInputStream(paramFile);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append(paramString);
      paramString = new FileOutputStream(new File((File)localObject1, ((StringBuilder)localObject2).toString()));
      localObject1 = new BufferedOutputStream(paramString);
      localObject2 = new byte[1024];
      for (;;)
      {
        int i = localBufferedInputStream.read((byte[])localObject2);
        if (i == -1) {
          break;
        }
        ((BufferedOutputStream)localObject1).write((byte[])localObject2, 0, i);
      }
      ((BufferedOutputStream)localObject1).flush();
      ((BufferedOutputStream)localObject1).close();
      paramString.flush();
      paramString.close();
      localBufferedInputStream.close();
      paramFile.close();
      return;
    }
    catch (Exception paramFile)
    {
      paramFile.printStackTrace();
    }
  }
  
  public final void a(File[] paramArrayOfFile)
  {
    if (paramArrayOfFile != null)
    {
      int i = 0;
      while (i < paramArrayOfFile.length)
      {
        try
        {
          paramArrayOfFile[i].delete();
          APLog.i("APMidasDownIUtif", "resultData data file invalid, deleted");
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        i += 1;
      }
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1;
    try
    {
      Object localObject1 = this.a.getApplicationContext().getDir("midaspluginsTemp", 0);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("resultData downlod md5 check:");
      ((StringBuilder)localObject2).append(((File)localObject1).listFiles().length);
      APLog.i("APMidasDownUtif", ((StringBuilder)localObject2).toString());
      bool1 = bool2;
      if (((File)localObject1).listFiles() != null)
      {
        bool1 = bool2;
        if (((File)localObject1).listFiles().length > 0)
        {
          localObject1 = ((File)localObject1).listFiles();
          int i = 0;
          bool1 = false;
          try
          {
            while (i < localObject1.length)
            {
              bool2 = bool1;
              if (!localObject1[i].getName().endsWith(".diff"))
              {
                bool2 = bool1;
                if (!localObject1[i].getName().endsWith(".ini"))
                {
                  Object localObject3 = localObject1[i].getName().split("\\_")[3].split("\\.")[0];
                  localObject2 = a(localObject1[i].getAbsolutePath());
                  if ((localObject3 != null) && (localObject2 != null))
                  {
                    int j = ((String)localObject3).compareToIgnoreCase((String)localObject2);
                    if (j == 0) {
                      try
                      {
                        localObject3 = new StringBuilder();
                        ((StringBuilder)localObject3).append("resultData download md5 check succ ");
                        ((StringBuilder)localObject3).append((String)localObject2);
                        APLog.i("APMidasDownUtif", ((StringBuilder)localObject3).toString());
                        bool2 = true;
                      }
                      catch (Exception localException1)
                      {
                        bool1 = true;
                        break label274;
                      }
                    }
                  }
                  APLog.i("APMidasDownUtif", "resultData download md5 check fail");
                  return false;
                }
              }
              i += 1;
              bool1 = bool2;
            }
            return bool1;
          }
          catch (Exception localException2) {}
          localException3.printStackTrace();
        }
      }
    }
    catch (Exception localException3)
    {
      bool1 = bool3;
    }
    label274:
    return bool1;
  }
  
  public boolean a(ArrayList<q0> paramArrayList)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(Environment.getExternalStorageDirectory().getAbsolutePath());
    ((StringBuilder)localObject1).append("/Tencent/MidasPay/");
    File localFile = new File(((StringBuilder)localObject1).toString());
    ArrayList localArrayList = new ArrayList();
    if (localFile.exists())
    {
      int i = 0;
      boolean bool1 = false;
      for (;;)
      {
        bool2 = bool1;
        if (i >= paramArrayList.size()) {
          break;
        }
        Object localObject2 = ((q0)paramArrayList.get(i)).a;
        localObject1 = localObject2;
        if (!((String)localObject2).endsWith(".apk"))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append(".apk");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(localFile.getAbsolutePath());
        ((StringBuilder)localObject2).append("/");
        ((StringBuilder)localObject2).append((String)localObject1);
        if (a(((StringBuilder)localObject2).toString()).compareToIgnoreCase(((q0)paramArrayList.get(i)).h) == 0)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(localFile.getAbsolutePath());
          ((StringBuilder)localObject2).append("/");
          ((StringBuilder)localObject2).append((String)localObject1);
          a(new File(((StringBuilder)localObject2).toString()), (String)localObject1);
          bool1 = true;
        }
        else
        {
          APLog.i("APMidasDownUtif", "resultData sdcard file check fail");
          localArrayList.add(paramArrayList.get(i));
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(localFile.getAbsolutePath());
          ((StringBuilder)localObject2).append("/");
          ((StringBuilder)localObject2).append((String)localObject1);
          a(new File(((StringBuilder)localObject2).toString()));
        }
        i += 1;
      }
    }
    boolean bool2 = false;
    if (localArrayList.size() > 0)
    {
      APLog.i("APMidasDownUtif", "resultData sdcard file check faile，need download");
      r0.p().d(localArrayList);
      return false;
    }
    return bool2;
  }
  
  public String b(File paramFile)
  {
    String str = "";
    Object localObject = str;
    try
    {
      paramFile = this.a.getApplicationContext().getPackageManager().getPackageArchiveInfo(paramFile.getAbsolutePath(), 1);
      localObject = str;
      if (paramFile != null)
      {
        localObject = str;
        paramFile = paramFile.versionName;
        localObject = paramFile;
        str = String.format("Vesion: %s", new Object[] { paramFile });
        localObject = paramFile;
        StringBuilder localStringBuilder = new StringBuilder();
        localObject = paramFile;
        localStringBuilder.append("resultData data verison:");
        localObject = paramFile;
        localStringBuilder.append(str);
        localObject = paramFile;
        APLog.i("APMidasDownUtif", localStringBuilder.toString());
        return paramFile;
      }
    }
    catch (Exception paramFile)
    {
      paramFile.printStackTrace();
    }
    return localObject;
  }
  
  public ArrayList<q0> b(ArrayList<q0> paramArrayList)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory().getAbsolutePath());
    ((StringBuilder)localObject).append("/Tencent/MidasPay/");
    localObject = new File(((StringBuilder)localObject).toString());
    if (((File)localObject).exists())
    {
      localObject = ((File)localObject).listFiles();
      if (localObject != null)
      {
        int i = 0;
        while (i < paramArrayList.size())
        {
          String str1 = ((q0)paramArrayList.get(i)).a;
          int j = 0;
          while (j < localObject.length)
          {
            String str2 = localObject[j].getName();
            if (str1.equals(str2.substring(0, str2.length() - 4)))
            {
              localArrayList1.add(paramArrayList.get(i));
              j = 1;
              break label168;
            }
            j += 1;
          }
          j = 0;
          label168:
          if (j == 0) {
            localArrayList2.add(paramArrayList.get(i));
          }
          i += 1;
        }
      }
      if (localArrayList2.size() > 0)
      {
        r0.p().c(localArrayList2);
        if (localArrayList1.size() >= 1) {
          r0.p().e(localArrayList1);
        }
      }
      return localArrayList1;
    }
    return null;
  }
  
  public void b(int paramInt)
  {
    Object localObject1;
    if (paramInt == 1) {
      localObject1 = this.a.getApplicationContext().getDir("midasplugins", 0);
    } else {
      localObject1 = this.a.getApplicationContext().getDir("midaspluginsTemp", 0);
    }
    ArrayList localArrayList = r0.p().l();
    if (localArrayList != null)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      int i = localArrayList.size();
      paramInt = 0;
      Object localObject3;
      while (paramInt < i)
      {
        localObject3 = ((t0)localArrayList.get(paramInt)).a;
        localObject2 = localObject3;
        if (!((String)localObject3).endsWith(".apk"))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject3);
          ((StringBuilder)localObject2).append(".apk");
          localObject2 = ((StringBuilder)localObject2).toString();
        }
        localObject3 = ((t0)localArrayList.get(paramInt)).b;
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append((String)localObject2);
        localStringBuilder2.append(":");
        localStringBuilder2.append((String)localObject3);
        localStringBuilder1.append(localStringBuilder2.toString());
        localStringBuilder1.append("\r\n");
        paramInt += 1;
      }
      Object localObject2 = localStringBuilder1.toString();
      localObject1 = new File((File)localObject1, "MidasSign.ini");
      try
      {
        localObject1 = new FileWriter((File)localObject1);
        localObject3 = new BufferedWriter((Writer)localObject1);
        ((BufferedWriter)localObject3).write((String)localObject2);
        ((BufferedWriter)localObject3).close();
        ((FileWriter)localObject1).close();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      r0.p().d(false);
    }
  }
  
  public boolean b()
  {
    File[] arrayOfFile = a.r().d.getDir("midasplugins", 0).listFiles();
    ArrayList localArrayList = r0.p().a();
    int i = 0;
    while (i < arrayOfFile.length)
    {
      if (arrayOfFile[i].getName().startsWith("MidasPay"))
      {
        i = 1;
        break label64;
      }
      i += 1;
    }
    i = 0;
    label64:
    if (i == 0)
    {
      a(arrayOfFile);
      APLog.i("APMidasDownIUtif", "resultData=data区里的文件数目与校验表不一致的，则删除文件");
      return false;
    }
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      int j = 0;
      int k;
      for (i = 0; j < arrayOfFile.length; i = k)
      {
        k = i;
        if (arrayOfFile[j].getName().startsWith("Midas"))
        {
          k = i;
          if (arrayOfFile[j].getName().endsWith(".apk"))
          {
            Object localObject = a(arrayOfFile[j].getAbsolutePath());
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("resultData current md5:");
            localStringBuilder.append((String)localObject);
            APLog.i("APMidasDownIUtif", localStringBuilder.toString());
            k = 0;
            while (k < localArrayList.size())
            {
              if (((q0)localArrayList.get(k)).g.compareToIgnoreCase((String)localObject) == 0)
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("resultData buypage md5:");
                ((StringBuilder)localObject).append(((q0)localArrayList.get(k)).g);
                APLog.i("APMidasDownIUtif", ((StringBuilder)localObject).toString());
                i = 1;
                break;
              }
              k += 1;
              i = 0;
            }
            if (i == 0)
            {
              i = 0;
              while (i < arrayOfFile.length)
              {
                try
                {
                  arrayOfFile[i].delete();
                  APLog.i("APMidasDownIUtif", "resultData file md5 is not valid delete current file");
                }
                catch (Exception localException)
                {
                  localException.printStackTrace();
                }
                i += 1;
              }
              return false;
            }
            k = i;
          }
        }
        j += 1;
      }
    }
    return true;
  }
  
  public void c()
  {
    try
    {
      Object localObject = a.r().d;
      int i = 0;
      localObject = ((Context)localObject).getDir("midasplugins", 0);
      if ((((File)localObject).listFiles() != null) && (((File)localObject).listFiles().length > 0))
      {
        localObject = ((File)localObject).listFiles();
        while (i < localObject.length)
        {
          localObject[i].delete();
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void d()
  {
    try
    {
      Object localObject = a.r().d;
      int i = 0;
      localObject = ((Context)localObject).getDir("midaspluginsTemp", 0);
      if ((((File)localObject).listFiles() != null) && (((File)localObject).listFiles().length > 0))
      {
        localObject = ((File)localObject).listFiles();
        while (i < localObject.length)
        {
          localObject[i].delete();
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public long e()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    long l = localStatFs.getBlockSize();
    return localStatFs.getAvailableBlocks() * l;
  }
  
  public long f()
  {
    StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
    long l = localStatFs.getBlockSize();
    return localStatFs.getAvailableBlocks() * l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.v0
 * JD-Core Version:    0.7.0.1
 */