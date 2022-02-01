package c.t.m.sapp.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class h
{
  public static String a = "6.7.3";
  public static h b;
  public Context c;
  public List<a> d;
  
  public h(Context paramContext)
  {
    AppMethodBeat.i(210721);
    this.d = new ArrayList();
    this.c = paramContext;
    AppMethodBeat.o(210721);
  }
  
  public static h a(Context paramContext)
  {
    AppMethodBeat.i(210722);
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new h(paramContext);
      }
      paramContext = b;
      AppMethodBeat.o(210722);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(210722);
    }
  }
  
  public List<a> a(String paramString)
  {
    AppMethodBeat.i(210727);
    paramString = q.e(q.a(this.c, paramString, ""));
    if (paramString.size() == 0) {
      e.a(this.c).a("DLC", "localComp parse error");
    }
    AppMethodBeat.o(210727);
    return paramString;
  }
  
  public boolean a()
  {
    AppMethodBeat.i(210724);
    c();
    String str1 = a;
    String str2 = q.a(this.c, "__Tencent_Cover_SDK_Version__sapp_", "");
    j.a("cv:" + str2 + "_" + str1);
    e.a(this.c).a("DCV", str2 + "_" + str1);
    if (!str1.equals(str2))
    {
      System.currentTimeMillis();
      if (!l.d(this.c))
      {
        j.a("copy to private dir failed");
        AppMethodBeat.o(210724);
        return false;
      }
      q.b(this.c, "__Tencent_Cover_SDK_Version__sapp_", str1);
      q.b(this.c, "__pro_dex_load_info___sapp", "default");
      q.b(this.c, "__SP_UPDATE_TencentLoc_COMP_INFO__sapp_", "");
      q.a(this.c.getFilesDir().getAbsolutePath() + File.separator + "TencentLocation_sapp/UpCp");
      AppMethodBeat.o(210724);
      return true;
    }
    AppMethodBeat.o(210724);
    return false;
  }
  
  public boolean a(boolean paramBoolean, List<a> paramList, String paramString)
  {
    AppMethodBeat.i(210725);
    paramString = new File(this.c.getFilesDir(), paramString);
    paramString = q.a(this.c, paramString);
    Object localObject1;
    Object localObject2;
    if ((paramString != null) && (paramString.size() != 0) && (paramList.size() != 0))
    {
      localObject1 = q.a(this.c, "__bad_dex_info___sapp", "preference_default_sapp");
      localObject2 = q.e((String)localObject1);
      if ((!((String)localObject1).equals("preference_default_sapp")) && (!((List)localObject2).isEmpty()) && (l.a(paramList, (List)localObject2)))
      {
        AppMethodBeat.o(210725);
        return false;
      }
      paramList = paramList.iterator();
      paramBoolean = true;
    }
    label277:
    for (;;)
    {
      boolean bool = paramBoolean;
      if (paramList.hasNext())
      {
        localObject1 = (a)paramList.next();
        localObject2 = paramString.iterator();
        String[] arrayOfString;
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          arrayOfString = ((String)((Iterator)localObject2).next()).split(",");
        } while ((arrayOfString.length != 3) || (!((a)localObject1).c.equals(arrayOfString[0])) || (!String.valueOf(((a)localObject1).d).equals(arrayOfString[1])) || (!((a)localObject1).e.equals(arrayOfString[2])));
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label277;
        }
        paramBoolean = false;
        break;
        j.a("private dir files is empty");
        e.a(this.c).a("DLC", "localComp file error");
        bool = false;
        AppMethodBeat.o(210725);
        return bool;
      }
    }
  }
  
  public DexClassLoader b()
  {
    AppMethodBeat.i(210723);
    a();
    if (l.b(this.c) == 6) {
      l.c(this.c);
    }
    if (!a(true, a("__SP_Tencent_Loc_COMP_INFO__sapp_"), q.b)) {
      d();
    }
    Object localObject = a("__SP_Tencent_Loc_COMP_INFO__sapp_");
    localObject = b.a(this.c).a((List)localObject, q.b);
    AppMethodBeat.o(210723);
    return localObject;
  }
  
  public final void c()
  {
    AppMethodBeat.i(210728);
    File localFile = new File(this.c.getFilesDir(), q.b);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localFile = new File(this.c.getFilesDir(), q.c);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    l.a(this.c);
    AppMethodBeat.o(210728);
  }
  
  public void d()
  {
    AppMethodBeat.i(210726);
    e.a(this.c).a("DCR", "goback");
    if (!l.d(this.c)) {
      e.a(this.c).a("DCR", "copy from asset failed");
    }
    AppMethodBeat.o(210726);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     c.t.m.sapp.c.h
 * JD-Core Version:    0.7.0.1
 */