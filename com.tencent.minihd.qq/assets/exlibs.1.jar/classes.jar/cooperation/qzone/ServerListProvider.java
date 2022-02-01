package cooperation.qzone;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Environment;
import android.os.Process;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.IUploadService.UploadServiceCreator;
import com.tencent.upload.uinterface.Utility;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;

public class ServerListProvider
{
  public static final int A = 36;
  public static final int B = 37;
  public static final int C = 38;
  public static final int D = 39;
  public static final int E = 40;
  public static final int F = 41;
  public static final int G = 42;
  public static final int H = 43;
  public static final int I = 44;
  public static final int J = 45;
  public static final int K = 46;
  public static final int L = 47;
  public static final int M = 48;
  public static final int N = 49;
  public static final int O = 50;
  public static final int P = 51;
  public static final int Q = 60;
  public static final int R = 61;
  public static final int S = 62;
  public static final int T = 63;
  public static final int U = 64;
  public static final int V = 65;
  public static final int W = 66;
  public static final int X = 67;
  public static final int Y = 68;
  public static final int Z = 69;
  public static final int a = 0;
  private static String a = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Tencent/com/tencent/mobileqq";
  public static final int aa = 70;
  public static final int ab = 71;
  public static final int ac = 72;
  public static final int ad = 73;
  public static final int ae = 74;
  public static final int af = 75;
  public static final int ag = 76;
  public static final int ah = 77;
  public static final int ai = 78;
  public static final int aj = 79;
  public static final int ak = 80;
  public static final int al = 81;
  public static final int am = 82;
  public static final int an = 83;
  public static final int ao = 84;
  public static final int ap = 85;
  public static final int b = 11;
  public static final int c = 12;
  public static final int d = 13;
  public static final int e = 14;
  public static final int f = 15;
  public static final int g = 16;
  public static final int h = 17;
  public static final int i = 18;
  public static final int j = 19;
  public static final int k = 20;
  public static final int l = 21;
  public static final int m = 22;
  public static final int n = 23;
  public static final int o = 24;
  public static final int p = 25;
  public static final int q = 26;
  public static final int r = 27;
  public static final int s = 28;
  public static final int t = 29;
  public static final int u = 30;
  public static final int v = 31;
  public static final int w = 32;
  public static final int x = 33;
  public static final int y = 34;
  public static final int z = 35;
  
  public static int a()
  {
    return LocalMultiProcConfig.a("ServerEnvironment", 0);
  }
  
  public static String a()
  {
    switch ()
    {
    case 52: 
    case 53: 
    case 54: 
    case 55: 
    case 56: 
    case 57: 
    case 58: 
    case 59: 
    default: 
      return "SQQzoneSvc.";
    case 11: 
      return "SQQzoneSvcTest001.";
    case 12: 
      return "SQQzoneSvcTouch001.";
    case 13: 
      return "SQQzoneSvcDb2.";
    case 14: 
      return "SQQzoneSvcPublish.";
    case 15: 
      return "SQQzoneSvcDev001.";
    case 16: 
      return "SQQzoneSvcDev002.";
    case 17: 
      return "SQQzoneSvcDev003.";
    case 18: 
      return "SQQzoneSvcDev004.";
    case 19: 
      return "SQQzoneSvcDev005.";
    case 20: 
      return "SQQzoneSvcDev006.";
    case 21: 
      return "SQQzoneSvcDev007.";
    case 22: 
      return "SQQzoneSvcDev008.";
    case 23: 
      return "SQQzoneSvcDev009.";
    case 24: 
      return "SQQzoneSvcDev010.";
    case 25: 
      return "SQQzoneSvcDev011.";
    case 26: 
      return "SQQzoneSvcDev012.";
    case 27: 
      return "SQQzoneSvcDev013.";
    case 28: 
      return "SQQzoneSvcDev014.";
    case 29: 
      return "SQQzoneSvcDev015.";
    case 30: 
      return "SQQzoneSvcDev016.";
    case 31: 
      return "SQQzoneSvcDev017.";
    case 32: 
      return "SQQzoneSvcDev018.";
    case 33: 
      return "SQQzoneSvcDev019.";
    case 34: 
      return "SQQzoneSvcDev020.";
    case 35: 
      return "SQQzoneSvcDev021.";
    case 36: 
      return "SQQzoneSvcDev022.";
    case 37: 
      return "SQQzoneSvcDev023.";
    case 38: 
      return "SQQzoneSvcDev024.";
    case 39: 
      return "SQQzoneSvcDev025.";
    case 40: 
      return "SQQzoneSvcDev026.";
    case 41: 
      return "SQQzoneSvcDev027.";
    case 42: 
      return "SQQzoneSvcDev028.";
    case 43: 
      return "SQQzoneSvcDev029.";
    case 44: 
      return "SQQzoneSvcDev030.";
    case 45: 
      return "SQQzoneSvcDev031.";
    case 46: 
      return "SQQzoneSvcDev032.";
    case 47: 
      return "SQQzoneSvcDev033.";
    case 48: 
      return "SQQzoneSvcDev034.";
    case 49: 
      return "SQQzoneSvcDev035.";
    case 50: 
      return "SQQzoneSvcDev036.";
    case 51: 
      return "SQQzoneSvcDev037.";
    case 60: 
      return "SQQzoneSvcDev050.";
    case 61: 
      return "SQQzoneSvcDev051.";
    case 62: 
      return "SQQzoneSvcDev052.";
    case 63: 
      return "SQQzoneSvcDev053.";
    case 64: 
      return "SQQzoneSvcDev054.";
    case 65: 
      return "SQQzoneSvcDev055.";
    case 66: 
      return "SQQzoneSvcDev056.";
    case 67: 
      return "SQQzoneSvcDev057.";
    case 68: 
      return "SQQzoneSvcDev058.";
    case 69: 
      return "SQQzoneSvcDev059.";
    case 70: 
      return "SQQzoneSvcDev060.";
    case 71: 
      return "SQQzoneSvcDev061.";
    case 72: 
      return "SQQzoneSvcDev062.";
    case 73: 
      return "SQQzoneSvcDev063.";
    case 74: 
      return "SQQzoneSvcDev064.";
    case 75: 
      return "SQQzoneSvcDev065.";
    case 76: 
      return "SQQzoneSvcDev066.";
    case 77: 
      return "SQQzoneSvcDev067.";
    case 78: 
      return "SQQzoneSvcDev068.";
    case 79: 
      return "SQQzoneSvcDev069.";
    case 80: 
      return "SQQzoneSvcDev089.";
    case 81: 
      return "SQQzoneSvcTest007.";
    case 82: 
      return "SQQzoneSvcDev070.";
    case 83: 
      return "SQQzoneSvcDev071.";
    case 84: 
      return "SQQzoneSvcTest008.";
    }
    return "SQQzoneSvcTest009.";
  }
  
  private static void a()
  {
    if (a()) {}
    for (;;)
    {
      return;
      Object localObject = new File(a);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      localObject = new File(a + "/testserver");
      if (!((File)localObject).exists()) {
        try
        {
          if (((File)localObject).createNewFile())
          {
            localObject = new BufferedWriter(new FileWriter((File)localObject));
            ((BufferedWriter)localObject).write("server=socket://113.108.89.210:14000");
            ((BufferedWriter)localObject).close();
            return;
          }
        }
        catch (Exception localException) {}
      }
    }
  }
  
  public static boolean a()
  {
    boolean bool2 = false;
    try
    {
      File localFile = new File(a + "/testserver");
      boolean bool1 = bool2;
      if (localFile.exists())
      {
        long l1 = localFile.length();
        bool1 = bool2;
        if (l1 > 0L) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static int b()
  {
    c();
    int i1 = LocalMultiProcConfig.a("ServerUploadEnvironment", 0);
    if (QLog.isColorLevel()) {
      QLog.d("upload", 2, "debug Version server:" + i1);
    }
    IUploadService.UploadServiceCreator.getInstance().setTestServer(i1);
    return i1;
  }
  
  private static void b()
  {
    try
    {
      File localFile = new File(a + "/testserver");
      if ((localFile != null) && (localFile.exists())) {
        localFile.delete();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public static boolean b()
  {
    if (!a())
    {
      a();
      if (!d()) {}
    }
    else
    {
      return true;
    }
    b();
    return false;
  }
  
  private static void c()
  {
    Utility.CUSTOM_IP = LocalMultiProcConfig.a("ServerUploadCustomIp", "113.108.67.16");
    Utility.CUSTOM_PORT = LocalMultiProcConfig.a("ServerUploadCustomPort", 19994);
    if (QLog.isColorLevel()) {
      QLog.d("upload", 2, "custom server loaded:" + Utility.CUSTOM_IP + ":" + Utility.CUSTOM_PORT);
    }
  }
  
  public static boolean c()
  {
    if (a())
    {
      b();
      if (!d()) {}
    }
    else
    {
      return true;
    }
    a();
    return false;
  }
  
  private static boolean d()
  {
    try
    {
      Context localContext = BaseApplication.getContext();
      if (localContext != null)
      {
        Iterator localIterator = ((ActivityManager)BaseApplication.getContext().getSystemService("activity")).getRunningAppProcesses().iterator();
        while (localIterator.hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
          if (localRunningAppProcessInfo.processName.equals(localContext.getPackageName() + ":MSF"))
          {
            Process.killProcess(localRunningAppProcessInfo.pid);
            return true;
          }
        }
      }
    }
    catch (Exception localException) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.ServerListProvider
 * JD-Core Version:    0.7.0.1
 */