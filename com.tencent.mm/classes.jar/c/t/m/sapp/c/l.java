package c.t.m.sapp.c;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class l
{
  public static void a(Context paramContext)
  {
    AppMethodBeat.i(186393);
    for (;;)
    {
      int i;
      try
      {
        paramContext = new File(paramContext.getFilesDir(), r.c);
        if (!paramContext.exists()) {
          paramContext.mkdirs();
        }
        if ((paramContext.canRead()) && (paramContext.canWrite()) && (paramContext.canExecute()))
        {
          paramContext = e.b();
          paramContext.a("DMK", "ods:ok");
          AppMethodBeat.o(186393);
          return;
        }
        boolean bool1 = paramContext.setReadable(true);
        boolean bool2 = paramContext.setWritable(true);
        boolean bool3 = paramContext.setExecutable(true);
        e locale = e.b();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder = localStringBuilder.append("ods:").append(bool2);
        localStringBuilder = localStringBuilder.append("_").append(bool1);
        locale.a("DMK", "_" + bool3);
        paramContext = paramContext.listFiles();
        if ((paramContext != null) && (paramContext.length > 0))
        {
          i = 0;
          if (i < paramContext.length)
          {
            locale = paramContext[i];
            if ((locale.canRead()) && (locale.canWrite()) && (locale.canExecute()))
            {
              locale = e.b();
              locale.a("DMK", "ofs:ok");
            }
            else
            {
              bool1 = locale.setWritable(true);
              bool2 = locale.setReadable(true);
              bool3 = locale.setExecutable(true);
              locale = e.b();
              localStringBuilder = new StringBuilder();
              localStringBuilder = localStringBuilder.append("ofs:").append(bool1);
              localStringBuilder = localStringBuilder.append("_").append(bool2);
              locale.a("DMK", "_" + bool3);
            }
          }
        }
      }
      finally
      {
        e.b().a("DMK", "exp:" + paramContext.toString());
        AppMethodBeat.o(186393);
        return;
      }
      i += 1;
    }
  }
  
  public static boolean a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(186361);
    try
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        int i = ((ActivityManager.RunningAppProcessInfo)paramContext.next()).pid;
        if (i == paramInt)
        {
          AppMethodBeat.o(186361);
          return true;
        }
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(186361);
    }
    return false;
  }
  
  public static boolean a(List<a> paramList1, List<a> paramList2)
  {
    AppMethodBeat.i(186424);
    paramList1 = paramList1.iterator();
    boolean bool = true;
    label212:
    for (;;)
    {
      if (paramList1.hasNext())
      {
        a locala1 = (a)paramList1.next();
        if (!locala1.c.contains(".dex")) {
          locala1.c += ".dex";
        }
        Iterator localIterator = paramList2.iterator();
        a locala2;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          locala2 = (a)localIterator.next();
          if (!locala2.c.contains(".dex")) {
            locala2.c += ".dex";
          }
        } while ((!locala1.c.equals(locala2.c)) || (locala1.d != locala2.d) || (!locala1.e.equals(locala2.e)));
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label212;
        }
        bool = false;
        break;
        AppMethodBeat.o(186424);
        return bool;
      }
    }
  }
  
  public static int b(Context paramContext)
  {
    AppMethodBeat.i(186201);
    List localList = r.e(r.b(paramContext, "__SP_Tencent_Loc_COMP_INFO__sapp_", ""));
    int i = e(paramContext);
    if (i <= 3) {
      r.c(paramContext, "__pro_dex_load_info___sapp", "default");
    }
    if ((localList != null) && (!localList.equals("")))
    {
      paramContext = r.b(paramContext, "__SP_UPDATE_TencentLoc_COMP_INFO__sapp_", "");
      if ((paramContext != null) && (!paramContext.equals("")))
      {
        if (a(localList, r.e(paramContext)))
        {
          if (i <= 3)
          {
            AppMethodBeat.o(186201);
            return 2;
          }
          AppMethodBeat.o(186201);
          return 3;
        }
        if (i <= 3)
        {
          AppMethodBeat.o(186201);
          return 6;
        }
        AppMethodBeat.o(186201);
        return 5;
      }
      AppMethodBeat.o(186201);
      return 1;
    }
    AppMethodBeat.o(186201);
    return 0;
  }
  
  public static boolean c(Context paramContext)
  {
    AppMethodBeat.i(186410);
    if (!r.b(paramContext, "__SP_UPDATE_TencentLoc_COMP_SDK_VER__sapp_", "").equals(h.a))
    {
      AppMethodBeat.o(186410);
      return false;
    }
    String str = r.b(paramContext, "__SP_UPDATE_TencentLoc_COMP_INFO__sapp_", "");
    Object localObject2;
    Object localObject1;
    Object localObject3;
    Object localObject4;
    Iterator localIterator;
    int i;
    if ((str != null) && (!str.equals("")))
    {
      localObject2 = r.e(str);
      if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
      {
        str = r.b(paramContext, "__bad_dex_info___sapp", "preference_default_sapp");
        localObject1 = r.e(str);
        if ((!str.equals("preference_default_sapp")) && (!((List)localObject1).isEmpty()) && (a((List)localObject2, (List)localObject1)))
        {
          AppMethodBeat.o(186410);
          return false;
        }
        localObject3 = new byte[2048];
        str = paramContext.getFilesDir().getAbsolutePath() + File.separator + r.b;
        localObject4 = paramContext.getFilesDir().getAbsolutePath() + File.separator + "TencentLocation_sapp/UpCp";
        localObject1 = new ArrayList();
        localIterator = ((List)localObject2).iterator();
        i = 1;
      }
    }
    for (;;)
    {
      if (localIterator.hasNext())
      {
        Object localObject5 = (a)localIterator.next();
        if (!r.b(paramContext, (String)localObject4 + File.separator + ((a)localObject5).c, str, "tmp_backup__sapp" + ((a)localObject5).c, ((a)localObject5).d, (byte[])localObject3))
        {
          localObject5 = new File(str + File.separator + "tmp_backup__sapp" + ((a)localObject5).c);
          if ((((File)localObject5).exists()) && (((File)localObject5).isFile()))
          {
            ((File)localObject5).delete();
            i = 0;
          }
        }
        else
        {
          ((List)localObject1).add(localObject5);
        }
      }
      else
      {
        if (i == 0)
        {
          paramContext = ((List)localObject1).iterator();
          while (paramContext.hasNext())
          {
            localObject2 = (a)paramContext.next();
            localObject2 = new File(str + File.separator + "tmp_backup__sapp" + ((a)localObject2).c);
            if ((((File)localObject2).exists()) && (((File)localObject2).isFile())) {
              ((File)localObject2).delete();
            }
          }
          ((List)localObject1).clear();
          AppMethodBeat.o(186410);
          return false;
        }
        if (((List)localObject2).size() == ((List)localObject1).size())
        {
          localObject2 = ((List)localObject1).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (a)((Iterator)localObject2).next();
            localObject4 = new File(str, ((a)localObject3).c);
            if ((((File)localObject4).exists()) && (((File)localObject4).isFile())) {
              ((File)localObject4).delete();
            }
            new File(str, "tmp_backup__sapp" + ((a)localObject3).c).renameTo((File)localObject4);
          }
          str = r.a((List)localObject1);
          r.c(paramContext, "__SP_Tencent_Loc_COMP_INFO__sapp_", str);
          e.a(paramContext).a("DBC", str);
          AppMethodBeat.o(186410);
          return true;
        }
        AppMethodBeat.o(186410);
        return false;
        AppMethodBeat.o(186410);
        return false;
        AppMethodBeat.o(186410);
        return false;
      }
      i = 0;
    }
  }
  
  public static boolean d(Context paramContext)
  {
    AppMethodBeat.i(186420);
    String str1 = r.c(paramContext);
    if (!r.a(str1)) {
      j.a("clear private dir failed");
    }
    Object localObject1 = r.c(paramContext, "TencentLocationComp_sapp" + File.separator + "comp_list");
    j.a("base comp info:" + (String)localObject1);
    localObject1 = r.e((String)localObject1);
    Object localObject3 = new byte[2048];
    Object localObject2 = new ArrayList();
    Object localObject4 = ((List)localObject1).iterator();
    a locala;
    int i;
    if (((Iterator)localObject4).hasNext())
    {
      locala = (a)((Iterator)localObject4).next();
      String str2 = "TencentLocationComp_sapp" + File.separator + locala.c;
      locala.c += ".dex";
      String str3 = "tmp_asset__sapp" + locala.c;
      if (!r.a(paramContext, str2, str1, str3, locala.d, (byte[])localObject3))
      {
        localObject3 = new File(str1 + File.separator + str3);
        if ((!((File)localObject3).exists()) || (!((File)localObject3).isFile())) {
          break label539;
        }
        ((File)localObject3).delete();
        i = 0;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        paramContext = ((ArrayList)localObject2).iterator();
        for (;;)
        {
          if (paramContext.hasNext())
          {
            localObject1 = (a)paramContext.next();
            localObject1 = new File(str1 + File.separator + "tmp_asset__sapp" + ((a)localObject1).c);
            if ((((File)localObject1).exists()) && (((File)localObject1).isFile()))
            {
              ((File)localObject1).delete();
              continue;
              ((ArrayList)localObject2).add(locala);
              break;
            }
          }
        }
        AppMethodBeat.o(186420);
        return false;
      }
      if (((ArrayList)localObject2).size() == ((List)localObject1).size())
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (a)((Iterator)localObject2).next();
          localObject4 = new File(str1, ((a)localObject3).c);
          if ((((File)localObject4).exists()) && (((File)localObject4).isFile())) {
            ((File)localObject4).delete();
          }
          new File(str1, "tmp_asset__sapp" + ((a)localObject3).c).renameTo((File)localObject4);
        }
        r.c(paramContext, "__SP_Tencent_Loc_COMP_INFO__sapp_", r.a((List)localObject1));
        AppMethodBeat.o(186420);
        return true;
      }
      AppMethodBeat.o(186420);
      return false;
      label539:
      i = 0;
      continue;
      i = 1;
    }
  }
  
  public static int e(Context paramContext)
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(186208);
    Object localObject = r.b(paramContext, "__pro_dex_load_info___sapp", "default");
    if (((String)localObject).equals("default"))
    {
      AppMethodBeat.o(186208);
      return 1;
    }
    try
    {
      localObject = ((String)localObject).split("#");
      int k = j;
      if (localObject != null)
      {
        k = j;
        if (localObject.length > 0)
        {
          j = 0;
          for (;;)
          {
            k = i;
            if (j >= localObject.length) {
              break;
            }
            String[] arrayOfString = localObject[j];
            arrayOfString = arrayOfString.split("&");
            k = i;
            if (arrayOfString != null)
            {
              k = i;
              if (arrayOfString.length == 2)
              {
                boolean bool = a(paramContext, Integer.parseInt(arrayOfString[0]));
                k = i;
                if (bool) {
                  k = 0;
                }
              }
            }
            j += 1;
            i = k;
          }
        }
      }
      if (k != 0)
      {
        AppMethodBeat.o(186208);
        return 3;
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(186208);
    }
    return 4;
  }
  
  public static void f(Context paramContext)
  {
    int m = 0;
    AppMethodBeat.i(186367);
    String str = r.d(paramContext);
    if (str == null)
    {
      AppMethodBeat.o(186367);
      return;
    }
    int n = r.g();
    Object localObject1 = r.b(paramContext, "__pro_dex_load_info___sapp", "default");
    if (((String)localObject1).equals("default"))
    {
      r.c(paramContext, "__pro_dex_load_info___sapp", n + "&" + str + "#");
      AppMethodBeat.o(186367);
      return;
    }
    label363:
    for (;;)
    {
      try
      {
        String[] arrayOfString = ((String)localObject1).split("#");
        if ((arrayOfString != null) && (arrayOfString.length > 0))
        {
          int j = 0;
          int i = 0;
          if (j < arrayOfString.length)
          {
            localObject1 = arrayOfString[j];
            localObject1 = ((String)localObject1).split("&");
            int k = i;
            if (localObject1 != null)
            {
              k = i;
              if (localObject1.length == 2)
              {
                Object localObject2 = localObject1[1];
                Integer.parseInt(localObject1[0]);
                k = i;
                if (str.equals(localObject2))
                {
                  localObject1 = new StringBuilder().append(n);
                  arrayOfString[j] = ("&" + str);
                  k = 1;
                }
              }
            }
            j += 1;
            i = k;
            continue;
          }
          localObject1 = "";
          j = m;
          if (j < arrayOfString.length)
          {
            localObject1 = new StringBuilder().append((String)localObject1).append(arrayOfString[j]);
            localObject1 = "#";
            j += 1;
            continue;
          }
          if (i != 0) {
            break label363;
          }
          localObject1 = new StringBuilder().append((String)localObject1).append(n);
          localObject1 = ((StringBuilder)localObject1).append("&").append(str);
          localObject1 = "#";
          r.c(paramContext, "__pro_dex_load_info___sapp", (String)localObject1);
          AppMethodBeat.o(186367);
        }
      }
      catch (Exception paramContext)
      {
        AppMethodBeat.o(186367);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     c.t.m.sapp.c.l
 * JD-Core Version:    0.7.0.1
 */