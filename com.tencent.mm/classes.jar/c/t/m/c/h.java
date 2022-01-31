package c.t.m.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class h
{
  private Context a;
  
  public h(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private List<String> c()
  {
    AppMethodBeat.i(136362);
    Object localObject = new File(this.a.getFilesDir(), "TencentLocation/comp");
    ArrayList localArrayList2 = null;
    ArrayList localArrayList1 = localArrayList2;
    if (((File)localObject).exists())
    {
      localArrayList1 = localArrayList2;
      if (((File)localObject).isDirectory())
      {
        localObject = ((File)localObject).listFiles();
        localArrayList1 = localArrayList2;
        if (localObject != null)
        {
          localArrayList1 = localArrayList2;
          if (localObject.length > 0)
          {
            localArrayList2 = new ArrayList();
            int j = localObject.length;
            int i = 0;
            for (;;)
            {
              localArrayList1 = localArrayList2;
              if (i >= j) {
                break;
              }
              localArrayList1 = localObject[i];
              localArrayList2.add(localArrayList1.getName() + "," + localArrayList1.length() + "," + q.a(localArrayList1));
              i += 1;
            }
          }
        }
      }
    }
    AppMethodBeat.o(136362);
    return localArrayList1;
  }
  
  public void a()
  {
    AppMethodBeat.i(136360);
    if (!d.a(this.a).a("backup"))
    {
      AppMethodBeat.o(136360);
      return;
    }
    b();
    Object localObject1 = c();
    Object localObject2 = q.b(q.b(this.a, "__SP_Tencent_Loc_COMP_INFO__", ""));
    if ((localObject1 == null) || (((List)localObject1).size() == 0) || (((List)localObject2).size() == 0)) {
      j = 0;
    }
    Object localObject4;
    Object localObject5;
    Object localObject3;
    int i;
    Object localObject7;
    for (;;)
    {
      if (j != 0)
      {
        localObject4 = new byte[2048];
        localObject5 = this.a.getFilesDir().getAbsolutePath() + File.separator + "TencentLocation/comp";
        localObject1 = this.a.getFilesDir().getAbsolutePath() + File.separator + "TencentLocation/lastComp";
        localObject3 = new ArrayList();
        Object localObject6 = ((List)localObject2).iterator();
        i = 0;
        for (;;)
        {
          if (((Iterator)localObject6).hasNext())
          {
            localObject7 = (a)((Iterator)localObject6).next();
            Object localObject8 = new File((String)localObject1, ((a)localObject7).c);
            if (((File)localObject8).exists())
            {
              localObject8 = q.a((File)localObject8);
              if (((a)localObject7).e.equals(localObject8)) {}
            }
            else if (q.b(this.a, (String)localObject5 + File.separator + ((a)localObject7).c, (String)localObject1, "tmp_" + ((a)localObject7).c, ((a)localObject7).d, (byte[])localObject4))
            {
              ((List)localObject3).add(localObject7);
              continue;
              localObject3 = ((List)localObject2).iterator();
              i = 1;
              label335:
              j = i;
              if (!((Iterator)localObject3).hasNext()) {
                break;
              }
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
          }
        }
      }
    }
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        i = 0;
      }
      for (;;)
      {
        break label335;
        localObject7 = new File((String)localObject1 + File.separator + "tmp_" + ((a)localObject7).c);
        if ((((File)localObject7).exists()) && (((File)localObject7).isFile())) {
          ((File)localObject7).delete();
        }
        i = 1;
        break;
        if (i != 0)
        {
          localObject2 = ((List)localObject3).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (a)((Iterator)localObject2).next();
            localObject3 = new File((String)localObject1 + File.separator + "tmp_" + ((a)localObject3).c);
            if ((((File)localObject3).exists()) && (((File)localObject3).isFile())) {
              ((File)localObject3).delete();
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
            new File((String)localObject1, "tmp_" + ((a)localObject4).c).renameTo((File)localObject5);
          }
          localObject1 = q.a((List)localObject3);
          q.a(this.a, "__SP_LAST_TencentLoc_COMP_INFO__", (String)localObject1);
          q.a(this.a, "__SP_LAST_TencentLoc_COMP_SDK_VER__", i.a);
        }
        d.a(this.a).b("backup");
        AppMethodBeat.o(136360);
        return;
      }
    }
  }
  
  public void b()
  {
    AppMethodBeat.i(136361);
    File localFile = new File(this.a.getFilesDir(), "TencentLocation/lastComp");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    AppMethodBeat.o(136361);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     c.t.m.c.h
 * JD-Core Version:    0.7.0.1
 */