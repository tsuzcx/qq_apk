package midas.x;

import android.content.Context;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.qqgame.GameModel;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;

public class an
{
  public static int a;
  private Context b = null;
  private String c = "";
  private String d = "";
  private String e = "";
  private int f = -1;
  private ArrayList<String> g = new ArrayList();
  private ArrayList<ap> h = null;
  
  static
  {
    try
    {
      System.loadLibrary("ufoPatch");
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public an(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public void a(int paramInt)
  {
    if ((this.g.size() > 0) && (a == 0))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("resultData=diff包的合并失败开始再次开始全量下载，要下载的数目是");
      ((StringBuilder)localObject1).append(this.g.size());
      APLog.i("Gamemodel", ((StringBuilder)localObject1).toString());
      a = 1;
      Object localObject2 = aq.a().b();
      localObject1 = new ArrayList();
      int i = 0;
      while (i < this.g.size())
      {
        int j = 0;
        while (j < ((ArrayList)localObject2).size())
        {
          if (((String)this.g.get(i)).equals(((ap)((ArrayList)localObject2).get(j)).a))
          {
            ((ap)((ArrayList)localObject2).get(j)).f = false;
            ((ap)((ArrayList)localObject2).get(j)).d = ((ap)((ArrayList)localObject2).get(j)).e;
            ((ap)((ArrayList)localObject2).get(j)).b = ((ap)((ArrayList)localObject2).get(j)).c;
            ((ArrayList)localObject1).add(((ArrayList)localObject2).get(j));
          }
          j += 1;
        }
        i += 1;
      }
      if (paramInt == 1)
      {
        localObject2 = new ar(this.b);
        av localav = new av(this.b, (ar)localObject2);
        ((ar)localObject2).a((ArrayList)localObject1);
        ((ar)localObject2).b((ArrayList)localObject1, 1);
        localav.a((ArrayList)localObject1, 1);
        return;
      }
      if (paramInt == 2) {
        this.h = ((ArrayList)localObject1);
      }
    }
  }
  
  public boolean a()
  {
    ArrayList localArrayList = aq.a().b();
    for (;;)
    {
      boolean bool1;
      int k;
      try
      {
        APLog.i("Gamemodel", "resultData=合并diff包开始");
        File localFile1 = this.b.getApplicationContext().getDir("midaspluginsTemp", 0);
        File[] arrayOfFile1 = localFile1.listFiles();
        File localFile2 = this.b.getApplicationContext().getDir("midasplugins", 0);
        File[] arrayOfFile2 = localFile2.listFiles();
        String str1 = "";
        int i = 0;
        bool1 = true;
        bool2 = bool1;
        try
        {
          if (i >= arrayOfFile1.length) {
            break label682;
          }
          bool2 = bool1;
          Object localObject3 = str1;
          if (arrayOfFile1[i].getName().endsWith(".diff"))
          {
            APLog.i("Gamemodel", "resultData=包含diff包");
            String str2 = arrayOfFile1[i].getName().split("\\.")[0];
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(localFile1.getAbsolutePath());
            ((StringBuilder)localObject3).append("/");
            ((StringBuilder)localObject3).append(arrayOfFile1[i].getName());
            this.e = ((StringBuilder)localObject3).toString();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("resultData=差分时diff文件");
            ((StringBuilder)localObject3).append(this.e);
            APLog.i("Gamemodel", ((StringBuilder)localObject3).toString());
            int j = 0;
            try
            {
              Object localObject1;
              if (j < arrayOfFile2.length)
              {
                bool2 = bool1;
                localObject3 = str1;
                if (arrayOfFile2[j].getName().startsWith(str2))
                {
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append(localFile2.getAbsolutePath());
                  ((StringBuilder)localObject3).append("/");
                  ((StringBuilder)localObject3).append(arrayOfFile2[j].getName());
                  this.c = ((StringBuilder)localObject3).toString();
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("resultData=差分时旧文件");
                  ((StringBuilder)localObject3).append(this.c);
                  APLog.i("Gamemodel", ((StringBuilder)localObject3).toString());
                  k = 0;
                  if (k < localArrayList.size())
                  {
                    if (!((ap)localArrayList.get(k)).a.split("\\_")[0].equals(str2)) {
                      break label685;
                    }
                    str1 = ((ap)localArrayList.get(k)).a;
                    if (str1.endsWith(".apk"))
                    {
                      localObject3 = new StringBuilder();
                      ((StringBuilder)localObject3).append(localFile1.getAbsolutePath());
                      ((StringBuilder)localObject3).append("/");
                      ((StringBuilder)localObject3).append(str1);
                      this.d = ((StringBuilder)localObject3).toString();
                    }
                    else
                    {
                      localObject3 = new StringBuilder();
                      ((StringBuilder)localObject3).append(localFile1.getAbsolutePath());
                      ((StringBuilder)localObject3).append("/");
                      ((StringBuilder)localObject3).append(str1);
                      ((StringBuilder)localObject3).append(".apk");
                      this.d = ((StringBuilder)localObject3).toString();
                    }
                    localObject3 = new StringBuilder();
                    ((StringBuilder)localObject3).append("resultData=差分时要合成的文件");
                    ((StringBuilder)localObject3).append(this.d);
                    APLog.i("Gamemodel", ((StringBuilder)localObject3).toString());
                    break label685;
                  }
                  a(this.c, this.d, this.e);
                  if (this.f != 0)
                  {
                    if (str1.length() > 0) {
                      this.g.add(str1);
                    }
                    try
                    {
                      APLog.i("Gamemodel", "resultData=差分失败删除差分diff文件");
                      arrayOfFile1[i].delete();
                      bool2 = false;
                      localObject3 = str1;
                    }
                    catch (Exception localException1)
                    {
                      bool1 = false;
                      break label673;
                    }
                  }
                  else
                  {
                    localObject3 = localException1;
                    bool2 = bool1;
                  }
                }
                j += 1;
                bool1 = bool2;
                localObject1 = localObject3;
                continue;
              }
              bool2 = bool1;
              localObject3 = localObject1;
            }
            catch (Exception localException2)
            {
              break label673;
            }
          }
          i += 1;
          bool1 = bool2;
          Object localObject2 = localObject3;
        }
        catch (Exception localException3) {}
        localException4.printStackTrace();
      }
      catch (Exception localException4)
      {
        bool1 = true;
      }
      label673:
      boolean bool2 = bool1;
      label682:
      return bool2;
      label685:
      k += 1;
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
      this.f = GameModel.gamePatch(paramString1, paramString2, paramString3);
    }
    paramString1 = System.out;
    paramString2 = new StringBuilder();
    paramString2.append("[makeAPK] ret=");
    paramString2.append(this.f);
    paramString1.println(paramString2.toString());
    return this.f == 0;
  }
  
  public ArrayList<ap> b()
  {
    return this.h;
  }
  
  public void c()
  {
    Object localObject = this.b.getApplicationContext();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.an
 * JD-Core Version:    0.7.0.1
 */