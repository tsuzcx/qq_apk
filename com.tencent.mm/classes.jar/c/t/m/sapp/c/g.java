package c.t.m.sapp.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class g
{
  public static void a(Context paramContext)
  {
    AppMethodBeat.i(186147);
    b(paramContext);
    Object localObject1 = c(paramContext);
    Object localObject2 = r.e(r.b(paramContext, "__SP_Tencent_Loc_COMP_INFO__sapp_", ""));
    Object localObject3;
    int i;
    if ((localObject1 != null) && (((List)localObject1).size() != 0) && (((List)localObject2).size() != 0))
    {
      localObject3 = ((List)localObject2).iterator();
      i = 1;
    }
    label754:
    for (;;)
    {
      int j = i;
      Object localObject4;
      Object localObject5;
      Object localObject6;
      if (((Iterator)localObject3).hasNext())
      {
        localObject4 = (a)((Iterator)localObject3).next();
        localObject5 = ((List)localObject1).iterator();
        do
        {
          if (!((Iterator)localObject5).hasNext()) {
            break;
          }
          localObject6 = ((String)((Iterator)localObject5).next()).split(",");
        } while ((localObject6.length != 3) || (!((a)localObject4).c.equals(localObject6[0])) || (!String.valueOf(((a)localObject4).d).equals(localObject6[1])) || (!((a)localObject4).e.equals(localObject6[2])));
      }
      for (j = 1;; j = 0)
      {
        if (j != 0) {
          break label754;
        }
        i = 0;
        break;
        j = 0;
        if (j != 0)
        {
          localObject4 = new byte[2048];
          localObject5 = paramContext.getFilesDir().getAbsolutePath() + File.separator + r.b;
          localObject1 = paramContext.getFilesDir().getAbsolutePath() + File.separator + "TencentLocation_sapp/lastComp";
          localObject3 = new ArrayList();
          localObject6 = ((List)localObject2).iterator();
          i = 0;
        }
        for (;;)
        {
          if (((Iterator)localObject6).hasNext())
          {
            Object localObject7 = (a)((Iterator)localObject6).next();
            Object localObject8 = new File((String)localObject1, ((a)localObject7).c);
            if (((File)localObject8).exists())
            {
              localObject8 = r.a((File)localObject8);
              if (((a)localObject7).e.equals(localObject8)) {
                continue;
              }
            }
            if (r.b(paramContext, (String)localObject5 + File.separator + ((a)localObject7).c, (String)localObject1, "tmp__sapp" + ((a)localObject7).c, ((a)localObject7).d, (byte[])localObject4))
            {
              ((List)localObject3).add(localObject7);
              continue;
            }
            localObject7 = new File((String)localObject1 + File.separator + "tmp__sapp" + ((a)localObject7).c);
            if ((((File)localObject7).exists()) && (((File)localObject7).isFile()))
            {
              ((File)localObject7).delete();
              i = 1;
            }
          }
          else
          {
            if (i != 0)
            {
              paramContext = ((List)localObject3).iterator();
              while (paramContext.hasNext())
              {
                localObject2 = (a)paramContext.next();
                localObject2 = new File((String)localObject1 + File.separator + "tmp__sapp" + ((a)localObject2).c);
                if ((((File)localObject2).exists()) && (((File)localObject2).isFile())) {
                  ((File)localObject2).delete();
                }
              }
            }
            if (((List)localObject2).size() == ((List)localObject3).size())
            {
              localObject2 = ((List)localObject3).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject4 = (a)((Iterator)localObject2).next();
                localObject5 = new File((String)localObject1, ((a)localObject4).c);
                if ((((File)localObject5).exists()) && (((File)localObject5).isFile())) {
                  ((File)localObject5).delete();
                }
                new File((String)localObject1, "tmp__sapp" + ((a)localObject4).c).renameTo((File)localObject5);
              }
              r.c(paramContext, "__SP_LAST_TencentLoc_COMP_INFO__sapp_", r.a((List)localObject3));
              r.c(paramContext, "__SP_LAST_TencentLoc_COMP_SDK_VER__sapp_", h.a);
            }
            AppMethodBeat.o(186147);
            return;
          }
          i = 1;
        }
      }
    }
  }
  
  public static void b(Context paramContext)
  {
    AppMethodBeat.i(186278);
    paramContext = new File(paramContext.getFilesDir(), "TencentLocation_sapp/lastComp");
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    AppMethodBeat.o(186278);
  }
  
  public static List<String> c(Context paramContext)
  {
    AppMethodBeat.i(186283);
    Object localObject = new File(paramContext.getFilesDir(), r.b);
    ArrayList localArrayList = null;
    paramContext = localArrayList;
    if (((File)localObject).exists())
    {
      paramContext = localArrayList;
      if (((File)localObject).isDirectory())
      {
        localObject = ((File)localObject).listFiles();
        paramContext = localArrayList;
        if (localObject != null)
        {
          paramContext = localArrayList;
          if (localObject.length > 0)
          {
            localArrayList = new ArrayList();
            int j = localObject.length;
            int i = 0;
            for (;;)
            {
              paramContext = localArrayList;
              if (i >= j) {
                break;
              }
              paramContext = localObject[i];
              localArrayList.add(paramContext.getName() + "," + paramContext.length() + "," + r.a(paramContext));
              i += 1;
            }
          }
        }
      }
    }
    AppMethodBeat.o(186283);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     c.t.m.sapp.c.g
 * JD-Core Version:    0.7.0.1
 */