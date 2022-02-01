package midas.x;

import android.content.Context;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.qqgame.GameModel;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;

public class o0
{
  public static int h;
  public Context a = null;
  public String b = "";
  public String c = "";
  public String d = "";
  public int e = -1;
  public ArrayList<String> f = new ArrayList();
  public ArrayList<q0> g = null;
  
  static
  {
    try
    {
      System.loadLibrary("ufoPatch");
      return;
    }
    finally
    {
      localObject.printStackTrace();
    }
  }
  
  public o0(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public void a()
  {
    Object localObject = this.a.getApplicationContext();
    int i = 0;
    localObject = ((Context)localObject).getDir("midaspluginsTemp", 0).listFiles();
    if (localObject != null)
    {
      int j = localObject.length;
      while (i < j)
      {
        if (localObject[i].getName().endsWith(".diff"))
        {
          APLog.i("GameModel ", "resultData=删除data区的app_midasplugins的diff文件");
          localObject[i].delete();
        }
        i += 1;
      }
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.f.size() > 0) && (h == 0))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("resultData=diff包的合并失败开始再次开始全量下载，要下载的数目是");
      ((StringBuilder)localObject1).append(this.f.size());
      APLog.i("Gamemodel", ((StringBuilder)localObject1).toString());
      h = 1;
      Object localObject2 = r0.p().b();
      localObject1 = new ArrayList();
      int i = 0;
      while (i < this.f.size())
      {
        int j = 0;
        while (j < ((ArrayList)localObject2).size())
        {
          if (((String)this.f.get(i)).equals(((q0)((ArrayList)localObject2).get(j)).a))
          {
            ((q0)((ArrayList)localObject2).get(j)).f = false;
            ((q0)((ArrayList)localObject2).get(j)).d = ((q0)((ArrayList)localObject2).get(j)).e;
            ((q0)((ArrayList)localObject2).get(j)).b = ((q0)((ArrayList)localObject2).get(j)).c;
            ((ArrayList)localObject1).add(((ArrayList)localObject2).get(j));
          }
          j += 1;
        }
        i += 1;
      }
      if (paramInt == 1)
      {
        localObject2 = new s0(this.a);
        w0 localw0 = new w0(this.a, (s0)localObject2);
        ((s0)localObject2).b((ArrayList)localObject1);
        ((s0)localObject2).a((ArrayList)localObject1, 1);
        localw0.a((ArrayList)localObject1, 1);
        return;
      }
      if (paramInt == 2) {
        this.g = ((ArrayList)localObject1);
      }
    }
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 != null) && (paramString2 != null) && (paramString2.length() > 0) && (paramString3 != null) && (paramString3.length() > 0))
    {
      PrintStream localPrintStream = System.out;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[makeAPK] oldfile=");
      localStringBuilder.append(paramString1);
      localPrintStream.println(localStringBuilder.toString());
      localPrintStream = System.out;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[makeAPK] newfile=");
      localStringBuilder.append(paramString2);
      localPrintStream.println(localStringBuilder.toString());
      localPrintStream = System.out;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[makeAPK] patchfile=");
      localStringBuilder.append(paramString3);
      localPrintStream.println(localStringBuilder.toString());
      this.e = GameModel.gamePatch(paramString1, paramString2, paramString3);
    }
    paramString1 = System.out;
    paramString2 = new StringBuilder();
    paramString2.append("[makeAPK] ret=");
    paramString2.append(this.e);
    paramString1.println(paramString2.toString());
    return this.e == 0;
  }
  
  public boolean b()
  {
    ArrayList localArrayList = r0.p().b();
    for (;;)
    {
      boolean bool1;
      int k;
      try
      {
        APLog.i("Gamemodel", "resultData=合并diff包开始");
        File localFile = this.a.getApplicationContext().getDir("midaspluginsTemp", 0);
        File[] arrayOfFile1 = localFile.listFiles();
        Object localObject1 = this.a.getApplicationContext().getDir("midasplugins", 0);
        File[] arrayOfFile2 = ((File)localObject1).listFiles();
        Object localObject2 = "";
        int i = 0;
        bool1 = true;
        bool2 = bool1;
        try
        {
          if (i >= arrayOfFile1.length) {
            break label670;
          }
          if (arrayOfFile1[i].getName().endsWith(".diff"))
          {
            APLog.i("Gamemodel", "resultData=包含diff包");
            String str = arrayOfFile1[i].getName().split("\\.")[0];
            Object localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(localFile.getAbsolutePath());
            ((StringBuilder)localObject3).append("/");
            ((StringBuilder)localObject3).append(arrayOfFile1[i].getName());
            this.d = ((StringBuilder)localObject3).toString();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("resultData=差分时diff文件");
            ((StringBuilder)localObject3).append(this.d);
            APLog.i("Gamemodel", ((StringBuilder)localObject3).toString());
            int j = 0;
            try
            {
              if (j < arrayOfFile2.length)
              {
                if (arrayOfFile2[j].getName().startsWith(str))
                {
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append(((File)localObject1).getAbsolutePath());
                  ((StringBuilder)localObject3).append("/");
                  ((StringBuilder)localObject3).append(arrayOfFile2[j].getName());
                  this.b = ((StringBuilder)localObject3).toString();
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("resultData=差分时旧文件");
                  ((StringBuilder)localObject3).append(this.b);
                  APLog.i("Gamemodel", ((StringBuilder)localObject3).toString());
                  k = 0;
                  if (k < localArrayList.size())
                  {
                    if (!((q0)localArrayList.get(k)).a.split("\\_")[0].equals(str)) {
                      break label673;
                    }
                    localObject2 = ((q0)localArrayList.get(k)).a;
                    if (((String)localObject2).endsWith(".apk"))
                    {
                      localObject3 = new StringBuilder();
                      ((StringBuilder)localObject3).append(localFile.getAbsolutePath());
                      ((StringBuilder)localObject3).append("/");
                      ((StringBuilder)localObject3).append((String)localObject2);
                      this.c = ((StringBuilder)localObject3).toString();
                    }
                    else
                    {
                      localObject3 = new StringBuilder();
                      ((StringBuilder)localObject3).append(localFile.getAbsolutePath());
                      ((StringBuilder)localObject3).append("/");
                      ((StringBuilder)localObject3).append((String)localObject2);
                      ((StringBuilder)localObject3).append(".apk");
                      this.c = ((StringBuilder)localObject3).toString();
                    }
                    localObject3 = new StringBuilder();
                    ((StringBuilder)localObject3).append("resultData=差分时要合成的文件");
                    ((StringBuilder)localObject3).append(this.c);
                    APLog.i("Gamemodel", ((StringBuilder)localObject3).toString());
                    break label673;
                  }
                  Object localObject4 = localObject1;
                  a(this.b, this.c, this.d);
                  bool2 = bool1;
                  localObject3 = localObject2;
                  localObject1 = localObject4;
                  if (this.e != 0)
                  {
                    if (((String)localObject2).length() > 0) {
                      this.f.add(localObject2);
                    }
                    try
                    {
                      APLog.i("Gamemodel", "resultData=差分失败删除差分diff文件");
                      arrayOfFile1[i].delete();
                      bool2 = false;
                      localObject3 = localObject2;
                      localObject1 = localObject4;
                    }
                    catch (Exception localException1)
                    {
                      bool1 = false;
                      break label661;
                    }
                  }
                }
                else
                {
                  localObject3 = localObject2;
                  bool2 = bool1;
                }
                j += 1;
                bool1 = bool2;
                localObject2 = localObject3;
                continue;
              }
            }
            catch (Exception localException2)
            {
              break label661;
            }
          }
          i += 1;
        }
        catch (Exception localException3) {}
        localException4.printStackTrace();
      }
      catch (Exception localException4)
      {
        bool1 = true;
      }
      label661:
      boolean bool2 = bool1;
      label670:
      return bool2;
      label673:
      k += 1;
    }
  }
  
  public ArrayList<q0> c()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.o0
 * JD-Core Version:    0.7.0.1
 */