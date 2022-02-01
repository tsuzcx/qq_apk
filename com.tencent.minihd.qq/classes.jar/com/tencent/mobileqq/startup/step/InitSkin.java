package com.tencent.mobileqq.startup.step;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.OOMHandler;
import com.tencent.common.config.AppSetting;
import com.tencent.minihd.qq.R.color;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import jvx;

public class InitSkin
  extends Step
{
  public static boolean a;
  private static final int[] a;
  private static final int[] b = { 2130837525, 2130837526, 2130837528, 2130837529, 2130837531, 2130837532, 2130837534, 2130837535, 2130838111, 2130838110, 2130841714, 2130841973, 2130841972, 2130841363, 2130838417, 2130838416, 2130842089, 2130841805, 2130841809, 2130841813, 2130841814, 2130841819, 2130841820, 2130841821, 2130841824, 2130841825, 2130842093, 2130842131, 2130838453, 2130838451, 2130838452, 2130838450, 2130838448, 2130838449, 2130839609, 2130839607, 2130839608, 2130838456, 2130838454, 2130838455, 2130837682, 2130842210, 2130838656, 2130838657, 2130838658, 2130838659, 2130841946, 2130841754, 2130841790, 2130841792, 2130839130, 2130839128, 2130839132, 2130841857, 2130841855, 2130841859, 2130839133, 2130839135, 2130841804, 2130839139, 2130839138, 2130839134 };
  private static final int[] c = { 2130837525, 2130837526, 2130837528, 2130837529, 2130837531, 2130837532, 2130837534, 2130837535, 2130837553, 2130837584, 2130837614, 2130837670, 2130842246, 2130842243, 2130842244, 2130842241, 2130842242, 2130842248, 2130837682, 2130837683, 2130837684, 2130837944, 2130837992, 2130837994, 2130838035, 2130838036, 2130838038, 2130838039, 2130838063, 2130838064, 2130838066, 2130838067, 2130838110, 2130838111, 2130838116, 2130838129, 2130838133, 2130838137, 2130838158, 2130838164, 2130838171, 2130838211, 2130838225, 2130838240, 2130839941, 2130838301, 2130838319, 2130837760, 2130842245, 2130842236, 2130838406, 2130841215, 2130841216, 2130841217, 2130838446, 2130838447, 2130841269, 2130838562, 2130838607, 2130839026, 2130839027, 2130839028, 2130839029, 2130839391, 2130839392, 2130839416, 2130839686, 2130839687, 2130840509, 2130840510, 2130840514, 2130840515, 2130840517, 2130840518, 2130840519, 2130840520, 2130840531, 2130840922, 2130840923, 2130840924, 2130842250, 2130840930, 2130840931, 2130840933, 2130840934, 2130840935, 2130840938, 2130840945, 2130840946, 2130840947, 2130840948, 2130840951, 2130840953, 2130840954, 2130840955, 2130840956, 2130840957, 2130840958, 2130840959, 2130840960, 2130840962, 2130840963, 2130840964, 2130840967, 2130840968, 2130840969, 2130840970, 2130840971, 2130840972, 2130840973, 2130840974, 2130840976, 2130840978, 2130840979, 2130840980, 2130840990, 2130840993, 2130840994, 2130840995, 2130840996, 2130840997, 2130840998, 2130840999, 2130841000, 2130842253, 2130841001, 2130841002, 2130841003, 2130841004, 2130841005, 2130841006, 2130841007, 2130841008, 2130841009, 2130841010, 2130841011, 2130841012, 2130841013, 2130841014, 2130841015, 2130841016, 2130841017, 2130841018, 2130841020, 2130841021, 2130841022, 2130841023, 2130841024, 2130841025, 2130841026, 2130841027, 2130841028, 2130841029, 2130841030, 2130841031, 2130841032, 2130841033, 2130841034, 2130841035, 2130841036, 2130841037, 2130841038, 2130841039, 2130841040, 2130841041, 2130841042, 2130841043, 2130841044, 2130841045, 2130841046, 2130841047, 2130841048, 2130841049, 2130841058, 2130841059, 2130841060, 2130841061, 2130841070, 2130841071, 2130841073, 2130841893, 2130841891, 2130841892, 2130841895, 2130841894, 2130841896, 2130841074, 2130841075, 2130841076, 2130841077, 2130841078, 2130841085, 2130841086, 2130841087, 2130841088, 2130841089, 2130841090, 2130841092, 2130841093, 2130842238, 2130842239, 2130841097, 2130841107, 2130841113, 2130842249, 2130841114, 2130841115, 2130841116, 2130841132, 2130841133, 2130841134, 2130841135, 2130841136, 2130842251, 2130842252, 2130841137, 2130841138, 2130841139, 2130841140, 2130841141, 2130841143, 2130841144, 2130841145, 2130841146, 2130841147, 2130841148, 2130841149, 2130841150, 2130841152, 2130841154, 2130841157, 2130841158, 2130841159, 2130841160, 2130841161, 2130841162, 2130841163, 2130841172, 2130841173, 2130841174, 2130841175, 2130841176, 2130841177, 2130841178, 2130841179, 2130841182, 2130841183, 2130841185, 2130841186, 2130841188, 2130841190, 2130841191, 2130841192, 2130841193, 2130841194, 2130841195, 2130841196, 2130841197, 2130841198, 2130841199, 2130841200, 2130841203, 2130841205, 2130841206, 2130841209, 2130841210, 2130841211, 2130841212, 2130841213, 2130841214, 2130841218, 2130841219, 2130841220, 2130841223, 2130841224, 2130841225, 2130841226, 2130841227, 2130841231, 2130841232, 2130841233, 2130841234, 2130841235, 2130841236, 2130841237, 2130841238, 2130841239, 2130841240, 2130841241, 2130841244, 2130841245, 2130841249, 2130841252, 2130841253, 2130841257, 2130841259, 2130841260, 2130841261, 2130841262, 2130841263, 2130841264, 2130841265, 2130841266, 2130841267, 2130841268, 2130841296, 2130841300, 2130841302, 2130841316, 2130841317, 2130841318, 2130841320, 2130841321, 2130841322, 2130841323, 2130841324, 2130841325, 2130841328, 2130841337, 2130841340, 2130841341, 2130841347, 2130841348, 2130841349, 2130841357, 2130841358, 2130841359, 2130841360, 2130841361, 2130841362, 2130841366, 2130841367, 2130841368, 2130841369, 2130841371, 2130841372, 2130841374, 2130841375, 2130841376, 2130841377, 2130841378, 2130841379, 2130841398, 2130841426, 2130841427, 2130841428, 2130841429, 2130841433, 2130841455, 2130841462, 2130841463, 2130841465, 2130841467, 2130841469, 2130841470, 2130841473, 2130841474, 2130841481, 2130841484, 2130841485, 2130841492, 2130841493, 2130841496, 2130841497, 2130841498, 2130841499, 2130841500, 2130841501, 2130841502, 2130841503, 2130841506, 2130841507, 2130841508, 2130841509, 2130841510, 2130841511, 2130841512, 2130841513, 2130841514, 2130841515, 2130841516, 2130841517, 2130841518, 2130841519, 2130841520, 2130841521, 2130841522, 2130841523, 2130841524, 2130841525, 2130841526, 2130841527, 2130841540, 2130841541, 2130841562, 2130841563, 2130841564, 2130841565, 2130841566, 2130841568, 2130841607, 2130841616, 2130841617, 2130841618, 2130841638, 2130841636, 2130841637, 2130841639, 2130841641, 2130841644, 2130841714, 2130841717, 2130841737, 2130841738, 2130841739, 2130841740, 2130841741, 2130841754, 2130841767, 2130841768, 2130841769, 2130841770, 2130841771, 2130841775, 2130841776, 2130841777, 2130841786, 2130841787, 2130841788, 2130841789, 2130841790, 2130841791, 2130841792, 2130841805, 2130841809, 2130841813, 2130841814, 2130841819, 2130841820, 2130841821, 2130841824, 2130841825, 2130841826, 2130841832, 2130841835, 2130841837, 2130841839, 2130841840, 2130841842, 2130841845, 2130841847, 2130841848, 2130841850, 2130841851, 2130841855, 2130841880, 2130841877, 2130841878, 2130841879, 2130841881, 2130841884, 2130841885, 2130841886, 2130841887, 2130841888, 2130841889, 2130841890, 2130841897, 2130841898, 2130841899, 2130841900, 2130841901, 2130841902, 2130841903, 2130841904, 2130841905, 2130841906, 2130841907, 2130841908, 2130841909, 2130841912, 2130841913, 2130841914, 2130841915, 2130841920, 2130841921, 2130841924, 2130841925, 2130841955, 2130841956, 2130841991, 2130842077, 2130842079, 2130842081, 2130842085, 2130842086, 2130842087, 2130842210, 2130842097, 2130842099, 2130842205, 2130842206, 2130842207, 2130842208, 2130842209, 2130841207, 2130841882 };
  
  static
  {
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_ArrayOfInt = new int[] { 2130837575, 2130837635, 2130837634, 2130837633, 2130838063, 2130838111, 2130838110, 2130838129, 2130838131, 2130838137, 2130838123, 2130838211, 2130838318, 2130838429, 2130838568, 2130839197, 2130839569, 2130839593, 2130840520, 2130840519, 2130840515, 2130840514, 2130840510, 2130840509, 2130839564, 2130839565, 2130839566, 2130839567, 2130839569, 2130839570, 2130839571, 2130839572, 2130839573, 2130839578, 2130839579, 2130839580, 2130839581, 2130839582, 2130839583, 2130839584, 2130839585, 2130839586, 2130839589, 2130839588, 2130839590, 2130839591, 2130839592, 2130839594, 2130839593, 2130839595, 2130839596, 2130839597, 2130839598, 2130839599, 2130839600, 2130839601, 2130839602, 2130839603, 2130839604, 2130839605, 2130840455, 2130839686, 2130839687, 2130839579, 2130839639, 2130839686, 2130839687, 2130839578, 2130841561, 2130841714, 2130841711, 2130841710, 2130841722, 2130841721, 2130841913, 2130841857, 2130841855, 2130841754, 2130841805, 2130841956, 2130841814, 2130841813, 2130841819, 2130841825, 2130841824, 2130841809, 2130841777, 2130841786, 2130841787, 2130841792, 2130841913, 2130841886, 2130841887, 2130841897, 2130841905, 2130841907, 2130841906, 2130841909, 2130841908 };
  }
  
  private static final boolean a(Context paramContext)
  {
    for (;;)
    {
      try
      {
        localFile2 = paramContext.getCacheDir();
        l1 = SystemClock.uptimeMillis();
        SkinEngine.SWITCH_DEBUG = false;
        SkinEngine.DEBUG = false;
        localFile1 = new File(localFile2, "/skin/web_config");
        localFile2 = new File(localFile2, "/skin/web_skin_cache");
      }
      catch (Exception localException1)
      {
        File localFile2;
        long l1;
        File localFile1;
        ObjectInputStream localObjectInputStream;
        int i;
        String str;
        long l2;
        BaseApplicationImpl.jdField_a_of_type_Boolean = false;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SkinEngine", 2, "", localException1);
        paramContext = new File(paramContext.getCacheDir(), "/skin/unsupport");
        if (paramContext.exists()) {
          continue;
        }
        if (paramContext.getParentFile().exists()) {
          continue;
        }
        paramContext.getParentFile().mkdirs();
        try
        {
          paramContext.createNewFile();
        }
        catch (IOException paramContext) {}
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SkinEngine", 2, "No cache found");
        SkinEngine.init(paramContext, b, R.color.class, 2131427328, null);
        ThreadManager.b().postDelayed(new jvx("/skin/web_config", "/skin/web_skin_cache"), 10000L);
        continue;
      }
      try
      {
        if (!localFile1.exists()) {
          continue;
        }
        localObjectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(localFile1)));
        i = localObjectInputStream.readInt();
        str = localObjectInputStream.readUTF();
        localObjectInputStream.close();
        if ((i != AppSetting.a) || (!"2cb8ec".equals(str))) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "web skin cache find, use cache file accered");
        }
        SkinEngine.init(paramContext, b, R.color.class, 2131427328, localFile2);
      }
      catch (Exception localException3)
      {
        if (localFile1.exists()) {
          continue;
        }
        localFile1.delete();
        if (localFile2.exists()) {
          continue;
        }
        localFile2.delete();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SkinEngine", 2, "web skin Cache load failed.", localException3);
        SkinEngine.init(paramContext, b, R.color.class, 2131427328, null);
        continue;
      }
      SkinEngine.getInstances().setSkinEngineHandler(new OOMHandler(BaseApplicationImpl.a()));
      SkinEngine.getInstances().addDrawableResource(2130837687);
      SkinEngine.getInstances().addDrawableResource(2130838126);
      l2 = SystemClock.uptimeMillis();
      try
      {
        paramContext.getResources().getDrawable(2130837504);
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "web skin init skin engine cost: " + (l2 - l1));
        }
        return true;
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          break label507;
        }
        QLog.e("SkinEngine", 2, "", localException2);
        SkinEngine.getInstances().unInit();
        throw localException2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SkinEngine", 2, "web skin cache time out");
      }
      SkinEngine.init(paramContext, b, R.color.class, 2131427328, null);
      ThreadManager.b().postDelayed(new jvx("/skin/web_config", "/skin/web_skin_cache"), 10000L);
    }
  }
  
  private static final boolean b(Context paramContext)
  {
    for (;;)
    {
      try
      {
        localFile2 = paramContext.getCacheDir();
        l1 = SystemClock.uptimeMillis();
        SkinEngine.SWITCH_DEBUG = false;
        SkinEngine.DEBUG = false;
        localFile1 = new File(localFile2, "/skin/qqfav_config");
        localFile2 = new File(localFile2, "/skin/qqfav_skin_cache");
      }
      catch (Exception localException1)
      {
        File localFile2;
        long l1;
        File localFile1;
        ObjectInputStream localObjectInputStream;
        int i;
        String str;
        long l2;
        BaseApplicationImpl.jdField_a_of_type_Boolean = false;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SkinEngine", 2, "", localException1);
        paramContext = new File(paramContext.getCacheDir(), "/skin/unsupport");
        if (paramContext.exists()) {
          continue;
        }
        if (paramContext.getParentFile().exists()) {
          continue;
        }
        paramContext.getParentFile().mkdirs();
        try
        {
          paramContext.createNewFile();
        }
        catch (IOException paramContext) {}
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SkinEngine", 2, "No cache found");
        SkinEngine.init(paramContext, jdField_a_of_type_ArrayOfInt, R.color.class, 2131427328, null);
        ThreadManager.b().postDelayed(new jvx("/skin/qqfav_config", "/skin/qqfav_skin_cache"), 10000L);
        continue;
      }
      try
      {
        if (!localFile1.exists()) {
          continue;
        }
        localObjectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(localFile1)));
        i = localObjectInputStream.readInt();
        str = localObjectInputStream.readUTF();
        localObjectInputStream.close();
        if ((i != AppSetting.a) || (!"2cb8ec".equals(str))) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "qqfav skin cache find, use cache file accered");
        }
        SkinEngine.init(paramContext, jdField_a_of_type_ArrayOfInt, R.color.class, 2131427328, localFile2);
      }
      catch (Exception localException3)
      {
        if (localFile1.exists()) {
          continue;
        }
        localFile1.delete();
        if (localFile2.exists()) {
          continue;
        }
        localFile2.delete();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SkinEngine", 2, "qqfav skin Cache load failed.", localException3);
        SkinEngine.init(paramContext, jdField_a_of_type_ArrayOfInt, R.color.class, 2131427328, null);
        continue;
      }
      SkinEngine.getInstances().setSkinEngineHandler(new OOMHandler(BaseApplicationImpl.a()));
      SkinEngine.getInstances().addDrawableResource(2130837687);
      SkinEngine.getInstances().addDrawableResource(2130837979);
      SkinEngine.getInstances().addDrawableResource(2130838126);
      SkinEngine.getInstances().addDrawableResource(2130837993);
      l2 = SystemClock.uptimeMillis();
      try
      {
        paramContext.getResources().getDrawable(2130837504);
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "qqfav skin init skin engine cost: " + (l2 - l1));
        }
        return true;
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          break label525;
        }
        QLog.e("SkinEngine", 2, "", localException2);
        SkinEngine.getInstances().unInit();
        throw localException2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SkinEngine", 2, "qqfav skin cache time out");
      }
      SkinEngine.init(paramContext, jdField_a_of_type_ArrayOfInt, R.color.class, 2131427328, null);
      ThreadManager.b().postDelayed(new jvx("/skin/qqfav_config", "/skin/qqfav_skin_cache"), 10000L);
    }
  }
  
  private static final boolean c(Context paramContext)
  {
    for (;;)
    {
      try
      {
        localFile2 = paramContext.getCacheDir();
        l1 = SystemClock.uptimeMillis();
        SkinEngine.SWITCH_DEBUG = false;
        SkinEngine.DEBUG = false;
        localFile1 = new File(localFile2, "/skin/qzone_config");
        localFile2 = new File(localFile2, "/skin/qzone_skin_cache");
      }
      catch (Exception localException1)
      {
        File localFile2;
        long l1;
        File localFile1;
        ObjectInputStream localObjectInputStream;
        int i;
        String str;
        long l2;
        BaseApplicationImpl.jdField_a_of_type_Boolean = false;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SkinEngine", 2, "", localException1);
        paramContext = new File(paramContext.getCacheDir(), "/skin/unsupport");
        if (paramContext.exists()) {
          continue;
        }
        if (paramContext.getParentFile().exists()) {
          continue;
        }
        paramContext.getParentFile().mkdirs();
        try
        {
          paramContext.createNewFile();
        }
        catch (IOException paramContext) {}
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SkinEngine", 2, "No cache found");
        SkinEngine.init(paramContext, c, R.color.class, 2131427328, null);
        ThreadManager.b().postDelayed(new jvx("/skin/qzone_config", "/skin/qzone_skin_cache"), 10000L);
        continue;
      }
      try
      {
        if (!localFile1.exists()) {
          continue;
        }
        localObjectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(localFile1)));
        i = localObjectInputStream.readInt();
        str = localObjectInputStream.readUTF();
        localObjectInputStream.close();
        if ((i != AppSetting.a) || (!"2cb8ec".equals(str))) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "qzone skin cache find, use cache file accered");
        }
        SkinEngine.init(paramContext, c, R.color.class, 2131427328, localFile2);
      }
      catch (Exception localException3)
      {
        if (localFile1.exists()) {
          continue;
        }
        localFile1.delete();
        if (localFile2.exists()) {
          continue;
        }
        localFile2.delete();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SkinEngine", 2, "qzone skin Cache load failed.", localException3);
        SkinEngine.init(paramContext, c, R.color.class, 2131427328, null);
        continue;
      }
      SkinEngine.getInstances().setSkinEngineHandler(new OOMHandler(BaseApplicationImpl.a()));
      SkinEngine.getInstances().addDrawableResource(2130837687);
      SkinEngine.getInstances().addDrawableResource(2130837979);
      SkinEngine.getInstances().addDrawableResource(2130838126);
      SkinEngine.getInstances().addDrawableResource(2130837993);
      l2 = SystemClock.uptimeMillis();
      try
      {
        paramContext.getResources().getDrawable(2130837504);
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "qzone skin init skin engine cost: " + (l2 - l1));
        }
        return true;
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          break label525;
        }
        QLog.e("SkinEngine", 2, "", localException2);
        SkinEngine.getInstances().unInit();
        throw localException2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SkinEngine", 2, "qzone skin cache time out");
      }
      SkinEngine.init(paramContext, c, R.color.class, 2131427328, null);
      ThreadManager.b().postDelayed(new jvx("/skin/qzone_config", "/skin/qzone_skin_cache"), 10000L);
    }
  }
  
  /* Error */
  private static final boolean d(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 630	android/content/Context:getCacheDir	()Ljava/io/File;
    //   4: astore 7
    //   6: invokestatic 636	android/os/SystemClock:uptimeMillis	()J
    //   9: lstore_2
    //   10: iconst_0
    //   11: putstatic 641	com/tencent/theme/SkinEngine:SWITCH_DEBUG	Z
    //   14: iconst_0
    //   15: putstatic 644	com/tencent/theme/SkinEngine:DEBUG	Z
    //   18: getstatic 845	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   21: astore 6
    //   23: aload 6
    //   25: invokevirtual 851	android/app/Application:getPackageManager	()Landroid/content/pm/PackageManager;
    //   28: aload 6
    //   30: invokevirtual 854	android/app/Application:getPackageName	()Ljava/lang/String;
    //   33: sipush 128
    //   36: invokevirtual 860	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   39: getfield 866	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   42: ldc_w 868
    //   45: invokevirtual 874	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   48: ifeq +45 -> 93
    //   51: ldc 27
    //   53: invokestatic 880	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   56: putstatic 884	com/tencent/theme/SkinEngine:mIconResourceID	Ljava/lang/Integer;
    //   59: invokestatic 699	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   62: ifeq +31 -> 93
    //   65: ldc_w 701
    //   68: iconst_2
    //   69: new 751	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 752	java/lang/StringBuilder:<init>	()V
    //   76: ldc_w 886
    //   79: invokevirtual 758	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc 27
    //   84: invokevirtual 889	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   87: invokevirtual 764	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 707	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   93: new 646	java/io/File
    //   96: dup
    //   97: aload 7
    //   99: ldc_w 891
    //   102: invokespecial 651	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   105: astore 6
    //   107: new 646	java/io/File
    //   110: dup
    //   111: aload 7
    //   113: ldc_w 893
    //   116: invokespecial 651	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   119: astore 7
    //   121: aload 6
    //   123: invokevirtual 657	java/io/File:exists	()Z
    //   126: ifeq +418 -> 544
    //   129: new 659	java/io/ObjectInputStream
    //   132: dup
    //   133: new 661	java/io/BufferedInputStream
    //   136: dup
    //   137: new 663	java/io/FileInputStream
    //   140: dup
    //   141: aload 6
    //   143: invokespecial 666	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   146: invokespecial 669	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   149: invokespecial 670	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   152: astore 8
    //   154: aload 8
    //   156: invokevirtual 674	java/io/ObjectInputStream:readInt	()I
    //   159: istore_1
    //   160: aload 8
    //   162: invokevirtual 678	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   165: astore 9
    //   167: aload 8
    //   169: invokevirtual 681	java/io/ObjectInputStream:close	()V
    //   172: iload_1
    //   173: getstatic 686	com/tencent/common/config/AppSetting:a	I
    //   176: if_icmpne +241 -> 417
    //   179: ldc_w 688
    //   182: aload 9
    //   184: invokevirtual 694	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   187: ifeq +230 -> 417
    //   190: invokestatic 699	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +13 -> 206
    //   196: ldc_w 701
    //   199: iconst_2
    //   200: ldc_w 895
    //   203: invokestatic 707	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: aload_0
    //   207: ldc_w 897
    //   210: ldc_w 743
    //   213: ldc_w 709
    //   216: ldc_w 710
    //   219: aload 7
    //   221: invokestatic 900	com/tencent/theme/SkinEngine:init	(Landroid/content/Context;Ljava/lang/Class;ILjava/lang/Class;ILjava/io/File;)V
    //   224: invokestatic 718	com/tencent/theme/SkinEngine:getInstances	()Lcom/tencent/theme/SkinEngine;
    //   227: new 720	com/tencent/common/app/OOMHandler
    //   230: dup
    //   231: invokestatic 725	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   234: invokespecial 728	com/tencent/common/app/OOMHandler:<init>	(Lcom/tencent/common/app/BaseApplicationImpl;)V
    //   237: invokevirtual 732	com/tencent/theme/SkinEngine:setSkinEngineHandler	(Lcom/tencent/theme/SkinEngineHandler;)V
    //   240: invokestatic 718	com/tencent/theme/SkinEngine:getInstances	()Lcom/tencent/theme/SkinEngine;
    //   243: ldc_w 733
    //   246: invokevirtual 737	com/tencent/theme/SkinEngine:addDrawableResource	(I)V
    //   249: invokestatic 718	com/tencent/theme/SkinEngine:getInstances	()Lcom/tencent/theme/SkinEngine;
    //   252: ldc_w 821
    //   255: invokevirtual 737	com/tencent/theme/SkinEngine:addDrawableResource	(I)V
    //   258: invokestatic 718	com/tencent/theme/SkinEngine:getInstances	()Lcom/tencent/theme/SkinEngine;
    //   261: ldc_w 738
    //   264: invokevirtual 737	com/tencent/theme/SkinEngine:addDrawableResource	(I)V
    //   267: invokestatic 718	com/tencent/theme/SkinEngine:getInstances	()Lcom/tencent/theme/SkinEngine;
    //   270: ldc_w 822
    //   273: invokevirtual 737	com/tencent/theme/SkinEngine:addDrawableResource	(I)V
    //   276: invokestatic 636	android/os/SystemClock:uptimeMillis	()J
    //   279: lstore 4
    //   281: aload_0
    //   282: invokevirtual 742	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   285: ldc_w 743
    //   288: invokevirtual 749	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   291: pop
    //   292: invokestatic 699	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   295: ifeq +337 -> 632
    //   298: ldc_w 701
    //   301: iconst_2
    //   302: new 751	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 752	java/lang/StringBuilder:<init>	()V
    //   309: ldc_w 902
    //   312: invokevirtual 758	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: lload 4
    //   317: lload_2
    //   318: lsub
    //   319: invokevirtual 761	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   322: invokevirtual 764	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokestatic 707	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   328: goto +304 -> 632
    //   331: astore 6
    //   333: aload 6
    //   335: invokevirtual 905	android/content/pm/PackageManager$NameNotFoundException:printStackTrace	()V
    //   338: goto -245 -> 93
    //   341: astore 6
    //   343: iconst_0
    //   344: putstatic 793	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_Boolean	Z
    //   347: invokestatic 699	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   350: ifeq +15 -> 365
    //   353: ldc_w 701
    //   356: iconst_2
    //   357: ldc_w 795
    //   360: aload 6
    //   362: invokestatic 798	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   365: new 646	java/io/File
    //   368: dup
    //   369: aload_0
    //   370: invokevirtual 630	android/content/Context:getCacheDir	()Ljava/io/File;
    //   373: ldc_w 800
    //   376: invokespecial 651	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   379: astore_0
    //   380: aload_0
    //   381: invokevirtual 657	java/io/File:exists	()Z
    //   384: ifne +248 -> 632
    //   387: aload_0
    //   388: invokevirtual 803	java/io/File:getParentFile	()Ljava/io/File;
    //   391: invokevirtual 657	java/io/File:exists	()Z
    //   394: ifne +11 -> 405
    //   397: aload_0
    //   398: invokevirtual 803	java/io/File:getParentFile	()Ljava/io/File;
    //   401: invokevirtual 806	java/io/File:mkdirs	()Z
    //   404: pop
    //   405: aload_0
    //   406: invokevirtual 809	java/io/File:createNewFile	()Z
    //   409: pop
    //   410: goto +222 -> 632
    //   413: astore_0
    //   414: goto +218 -> 632
    //   417: invokestatic 699	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   420: ifeq +13 -> 433
    //   423: ldc_w 701
    //   426: iconst_2
    //   427: ldc_w 907
    //   430: invokestatic 707	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   433: aload_0
    //   434: ldc_w 897
    //   437: ldc_w 743
    //   440: ldc_w 709
    //   443: ldc_w 710
    //   446: aconst_null
    //   447: invokestatic 900	com/tencent/theme/SkinEngine:init	(Landroid/content/Context;Ljava/lang/Class;ILjava/lang/Class;ILjava/io/File;)V
    //   450: invokestatic 771	com/tencent/mobileqq/app/ThreadManager:b	()Landroid/os/Handler;
    //   453: new 773	jvx
    //   456: dup
    //   457: ldc_w 891
    //   460: ldc_w 893
    //   463: invokespecial 776	jvx:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   466: ldc2_w 777
    //   469: invokevirtual 784	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   472: pop
    //   473: goto -249 -> 224
    //   476: astore 8
    //   478: aload 6
    //   480: invokevirtual 657	java/io/File:exists	()Z
    //   483: ifne +9 -> 492
    //   486: aload 6
    //   488: invokevirtual 787	java/io/File:delete	()Z
    //   491: pop
    //   492: aload 7
    //   494: invokevirtual 657	java/io/File:exists	()Z
    //   497: ifne +9 -> 506
    //   500: aload 7
    //   502: invokevirtual 787	java/io/File:delete	()Z
    //   505: pop
    //   506: invokestatic 699	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   509: ifeq +15 -> 524
    //   512: ldc_w 701
    //   515: iconst_2
    //   516: ldc_w 909
    //   519: aload 8
    //   521: invokestatic 792	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   524: aload_0
    //   525: ldc_w 897
    //   528: ldc_w 743
    //   531: ldc_w 709
    //   534: ldc_w 710
    //   537: aconst_null
    //   538: invokestatic 900	com/tencent/theme/SkinEngine:init	(Landroid/content/Context;Ljava/lang/Class;ILjava/lang/Class;ILjava/io/File;)V
    //   541: goto -317 -> 224
    //   544: invokestatic 699	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   547: ifeq +13 -> 560
    //   550: ldc_w 701
    //   553: iconst_2
    //   554: ldc_w 811
    //   557: invokestatic 707	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   560: aload_0
    //   561: ldc_w 897
    //   564: ldc_w 743
    //   567: ldc_w 709
    //   570: ldc_w 710
    //   573: aconst_null
    //   574: invokestatic 900	com/tencent/theme/SkinEngine:init	(Landroid/content/Context;Ljava/lang/Class;ILjava/lang/Class;ILjava/io/File;)V
    //   577: invokestatic 771	com/tencent/mobileqq/app/ThreadManager:b	()Landroid/os/Handler;
    //   580: new 773	jvx
    //   583: dup
    //   584: ldc_w 891
    //   587: ldc_w 893
    //   590: invokespecial 776	jvx:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   593: ldc2_w 777
    //   596: invokevirtual 784	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   599: pop
    //   600: goto -376 -> 224
    //   603: astore 6
    //   605: invokestatic 699	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   608: ifeq +15 -> 623
    //   611: ldc_w 701
    //   614: iconst_2
    //   615: ldc_w 795
    //   618: aload 6
    //   620: invokestatic 798	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   623: invokestatic 718	com/tencent/theme/SkinEngine:getInstances	()Lcom/tencent/theme/SkinEngine;
    //   626: invokevirtual 814	com/tencent/theme/SkinEngine:unInit	()V
    //   629: aload 6
    //   631: athrow
    //   632: iconst_1
    //   633: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	634	0	paramContext	Context
    //   159	18	1	i	int
    //   9	309	2	l1	long
    //   279	37	4	l2	long
    //   21	121	6	localObject	Object
    //   331	3	6	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
    //   341	146	6	localException1	Exception
    //   603	27	6	localException2	Exception
    //   4	497	7	localFile	File
    //   152	16	8	localObjectInputStream	ObjectInputStream
    //   476	44	8	localException3	Exception
    //   165	18	9	str	String
    // Exception table:
    //   from	to	target	type
    //   18	93	331	android/content/pm/PackageManager$NameNotFoundException
    //   0	18	341	java/lang/Exception
    //   18	93	341	java/lang/Exception
    //   93	121	341	java/lang/Exception
    //   224	281	341	java/lang/Exception
    //   292	328	341	java/lang/Exception
    //   333	338	341	java/lang/Exception
    //   478	492	341	java/lang/Exception
    //   492	506	341	java/lang/Exception
    //   506	524	341	java/lang/Exception
    //   524	541	341	java/lang/Exception
    //   605	623	341	java/lang/Exception
    //   623	632	341	java/lang/Exception
    //   405	410	413	java/io/IOException
    //   121	206	476	java/lang/Exception
    //   206	224	476	java/lang/Exception
    //   417	433	476	java/lang/Exception
    //   433	473	476	java/lang/Exception
    //   544	560	476	java/lang/Exception
    //   560	600	476	java/lang/Exception
    //   281	292	603	java/lang/Exception
  }
  
  protected boolean a()
  {
    if (jdField_a_of_type_Boolean) {}
    do
    {
      return true;
      jdField_a_of_type_Boolean = true;
      localObject = BaseApplicationImpl.processName.split(":");
    } while (localObject.length <= 1);
    Object localObject = localObject[1];
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitSkin
 * JD-Core Version:    0.7.0.1
 */