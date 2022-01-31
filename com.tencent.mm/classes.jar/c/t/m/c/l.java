package c.t.m.c;

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
    AppMethodBeat.i(136377);
    for (;;)
    {
      int i;
      try
      {
        paramContext = new File(paramContext.getFilesDir(), "TencentLocation/odex");
        if (!paramContext.exists()) {
          paramContext.mkdirs();
        }
        if ((paramContext.canRead()) && (paramContext.canWrite()) && (paramContext.canExecute())) {
          break label286;
        }
        boolean bool1 = paramContext.setReadable(true);
        boolean bool2 = paramContext.setWritable(true);
        boolean bool3 = paramContext.setExecutable(true);
        e.a().a("DMK", "ods:" + bool2 + "_" + bool1 + "_" + bool3);
        paramContext = paramContext.listFiles();
        if ((paramContext != null) && (paramContext.length > 0))
        {
          i = 0;
          if (i < paramContext.length)
          {
            Object localObject = paramContext[i];
            if ((!localObject.canRead()) || (!localObject.canWrite()) || (!localObject.canExecute()))
            {
              bool1 = localObject.setWritable(true);
              bool2 = localObject.setReadable(true);
              bool3 = localObject.setExecutable(true);
              e.a().a("DMK", "ofs:" + bool1 + "_" + bool2 + "_" + bool3);
            }
            else
            {
              e.a().a("DMK", "ofs:ok");
            }
          }
        }
      }
      catch (Throwable paramContext)
      {
        e.a().a("DMK", "exp:" + paramContext.toString());
        AppMethodBeat.o(136377);
        return;
      }
      AppMethodBeat.o(136377);
      return;
      label286:
      e.a().a("DMK", "ods:ok");
      AppMethodBeat.o(136377);
      return;
      i += 1;
    }
  }
  
  public static boolean a(List<a> paramList1, List<a> paramList2)
  {
    AppMethodBeat.i(136380);
    paramList1 = paramList1.iterator();
    boolean bool = true;
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
      if (i == 0) {
        bool = false;
      }
      for (;;)
      {
        break;
        AppMethodBeat.o(136380);
        return bool;
      }
    }
  }
  
  public static boolean b(Context paramContext)
  {
    AppMethodBeat.i(136378);
    if (!q.b(paramContext, "__SP_LAST_TencentLoc_COMP_SDK_VER__", "").equals(i.a))
    {
      AppMethodBeat.o(136378);
      return false;
    }
    String str = q.b(paramContext, "__SP_LAST_TencentLoc_COMP_INFO__", "");
    e.a(paramContext).a("DBC", str);
    if ((str == null) || (str.equals("")))
    {
      AppMethodBeat.o(136378);
      return false;
    }
    Object localObject1 = q.b(str);
    if ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      AppMethodBeat.o(136378);
      return false;
    }
    Object localObject2 = new byte[2048];
    str = paramContext.getFilesDir().getAbsolutePath() + File.separator + "TencentLocation/comp";
    Object localObject3 = paramContext.getFilesDir().getAbsolutePath() + File.separator + "TencentLocation/lastComp";
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((List)localObject1).iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      Object localObject4 = (a)localIterator.next();
      if (!q.b(paramContext, (String)localObject3 + File.separator + ((a)localObject4).c, str, "tmp_backup_" + ((a)localObject4).c, ((a)localObject4).d, (byte[])localObject2))
      {
        localObject4 = new File(str + File.separator + "tmp_backup_" + ((a)localObject4).c);
        if ((((File)localObject4).exists()) && (((File)localObject4).isFile())) {
          ((File)localObject4).delete();
        }
        i = 0;
      }
      else
      {
        localArrayList.add(localObject4);
      }
    }
    if (i == 0)
    {
      paramContext = localArrayList.iterator();
      while (paramContext.hasNext())
      {
        localObject1 = (a)paramContext.next();
        localObject1 = new File(str + File.separator + "tmp_backup_" + ((a)localObject1).c);
        if ((((File)localObject1).exists()) && (((File)localObject1).isFile())) {
          ((File)localObject1).delete();
        }
      }
      localArrayList.clear();
      AppMethodBeat.o(136378);
      return false;
    }
    if (((List)localObject1).size() == localArrayList.size())
    {
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (a)((Iterator)localObject1).next();
        localObject3 = new File(str, ((a)localObject2).c);
        if ((((File)localObject3).exists()) && (((File)localObject3).isFile())) {
          ((File)localObject3).delete();
        }
        new File(str, "tmp_backup_" + ((a)localObject2).c).renameTo((File)localObject3);
      }
      str = q.a(localArrayList);
      q.a(paramContext, "__SP_Tencent_Loc_COMP_INFO__", str);
      e.a(paramContext).a("DBC", str);
      AppMethodBeat.o(136378);
      return true;
    }
    AppMethodBeat.o(136378);
    return false;
  }
  
  public static boolean c(Context paramContext)
  {
    AppMethodBeat.i(136379);
    String str1 = q.b(paramContext);
    q.e(str1);
    Object localObject1 = q.b(q.b(paramContext, "TencentLocationComp" + File.separator + "comp_list"));
    Object localObject3 = new byte[2048];
    Object localObject2 = new ArrayList();
    Object localObject4 = ((List)localObject1).iterator();
    a locala;
    int i;
    if (((Iterator)localObject4).hasNext())
    {
      locala = (a)((Iterator)localObject4).next();
      String str2 = "TencentLocationComp" + File.separator + locala.c;
      locala.c += ".dex";
      String str3 = "tmp_asset_" + locala.c;
      if (!q.a(paramContext, str2, str1, str3, locala.d, (byte[])localObject3))
      {
        localObject3 = new File(str1 + File.separator + str3);
        if ((!((File)localObject3).exists()) || (!((File)localObject3).isFile())) {
          break label499;
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
            localObject1 = new File(str1 + File.separator + "tmp_asset_" + ((a)localObject1).c);
            if ((((File)localObject1).exists()) && (((File)localObject1).isFile()))
            {
              ((File)localObject1).delete();
              continue;
              ((ArrayList)localObject2).add(locala);
              break;
            }
          }
        }
        AppMethodBeat.o(136379);
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
          new File(str1, "tmp_asset_" + ((a)localObject3).c).renameTo((File)localObject4);
        }
        q.a(paramContext, "__SP_Tencent_Loc_COMP_INFO__", q.a((List)localObject1));
        AppMethodBeat.o(136379);
        return true;
      }
      AppMethodBeat.o(136379);
      return false;
      label499:
      i = 0;
      continue;
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     c.t.m.c.l
 * JD-Core Version:    0.7.0.1
 */