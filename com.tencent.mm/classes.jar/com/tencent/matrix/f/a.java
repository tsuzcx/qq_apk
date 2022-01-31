package com.tencent.matrix.f;

import android.os.Handler;
import android.os.Process;
import com.tencent.matrix.g.c;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a
  extends com.tencent.matrix.d.b
{
  private int bQA;
  private final a.b bQB;
  private a.a bQv;
  private List<List<a.d>> bQw;
  private long bQx;
  private long bQy;
  private long bQz;
  private Handler handler;
  private long lastReportTime;
  
  public static List<a.e> a(a.c paramc, a.b paramb)
  {
    LinkedList localLinkedList = new LinkedList();
    String str = String.format("/proc/%s/task/", new Object[] { Integer.valueOf(Process.myPid()) });
    Object localObject1 = new File(str);
    if (((File)localObject1).isDirectory())
    {
      localObject1 = ((File)localObject1).listFiles();
      int j = localObject1.length;
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label277;
        }
        Object localObject2 = localObject1[i];
        try
        {
          localObject2 = getStringFromFile(str + ((File)localObject2).getName() + "/stat");
          if (localObject2 != null)
          {
            localObject2 = ((String)localObject2).replaceAll("\n", "").split(" ");
            a.e locale = new a.e();
            locale.tid = Long.parseLong(localObject2[0]);
            locale.name = localObject2[1].replace("(", "").replace(")", "");
            locale.state = localObject2[2].replace("'", "");
            locale.bQI = aw(locale.tid);
            if ((paramb != null) && (!paramb.b(locale)))
            {
              localLinkedList.add(locale);
              if (paramc != null) {
                paramc.a(locale);
              }
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            c.e("Matrix.ThreadWatcher", "%s %s", new Object[] { localException, stackTraceToString(localException.getStackTrace()) });
          }
        }
        i += 1;
      }
    }
    label277:
    return localLinkedList;
  }
  
  private static long aw(long paramLong)
  {
    String str = String.format("/proc/%s/task/%s/schedstat", new Object[] { Integer.valueOf(Process.myPid()), Long.valueOf(paramLong) });
    try
    {
      str = getStringFromFile(str);
      if (str == null) {
        return -1L;
      }
      paramLong = Long.parseLong(str.replaceAll("\n", "").split(" ")[2]);
      return paramLong;
    }
    catch (Exception localException) {}
    return -2L;
  }
  
  private static String convertStreamToString(InputStream paramInputStream)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream, "UTF-8"));
      try
      {
        for (;;)
        {
          paramInputStream = localBufferedReader.readLine();
          if (paramInputStream == null) {
            break;
          }
          localStringBuilder.append(paramInputStream).append('\n');
        }
        if (localBufferedReader == null) {
          break label59;
        }
      }
      finally {}
    }
    finally
    {
      for (;;)
      {
        BufferedReader localBufferedReader = null;
      }
    }
    localBufferedReader.close();
    label59:
    throw paramInputStream;
    localBufferedReader.close();
    return localStringBuilder.toString();
  }
  
  private static String getStringFromFile(String paramString)
  {
    paramString = new File(paramString);
    FileInputStream localFileInputStream;
    try
    {
      localFileInputStream = new FileInputStream(paramString);
      if (localFileInputStream == null) {
        break label40;
      }
    }
    finally
    {
      try
      {
        paramString = convertStreamToString(localFileInputStream);
        localFileInputStream.close();
        return paramString;
      }
      finally {}
      paramString = finally;
      localFileInputStream = null;
    }
    localFileInputStream.close();
    label40:
    throw paramString;
  }
  
  private static String stackTraceToString(StackTraceElement[] paramArrayOfStackTraceElement)
  {
    if (paramArrayOfStackTraceElement == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 2;
    while (i < paramArrayOfStackTraceElement.length)
    {
      localStringBuilder.append('[');
      localStringBuilder.append(paramArrayOfStackTraceElement[i].getClassName());
      localStringBuilder.append(':');
      localStringBuilder.append(paramArrayOfStackTraceElement[i].getMethodName());
      localStringBuilder.append("(" + paramArrayOfStackTraceElement[i].getLineNumber() + ")]");
      localStringBuilder.append("\n");
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static int zq()
  {
    Object localObject1 = String.format("/proc/%s/status", new Object[] { Integer.valueOf(Process.myPid()) });
    for (;;)
    {
      int i;
      try
      {
        localObject1 = getStringFromFile((String)localObject1).trim().split("\n");
        int j = localObject1.length;
        i = 0;
        if (i < j)
        {
          Object localObject2 = localObject1[i];
          if (((String)localObject2).startsWith("Threads"))
          {
            localObject2 = Pattern.compile("\\d+").matcher((CharSequence)localObject2);
            if (((Matcher)localObject2).find()) {
              return Integer.parseInt(((Matcher)localObject2).group());
            }
          }
        }
        else
        {
          c.w("Matrix.ThreadWatcher", "[getProcessThreadCount] Wrong!", new Object[] { localObject1[24] });
          i = Integer.parseInt(localObject1[24].trim());
          return i;
        }
      }
      catch (Exception localException)
      {
        return 0;
      }
      i += 1;
    }
  }
  
  public void onForeground(boolean paramBoolean)
  {
    super.onForeground(paramBoolean);
    this.handler.removeCallbacksAndMessages(null);
    if (this.bQv != null)
    {
      if (paramBoolean) {
        this.handler.postDelayed(this.bQv, this.bQx);
      }
    }
    else {
      return;
    }
    this.handler.postDelayed(this.bQv, this.bQy);
  }
  
  public void start()
  {
    super.start();
    c.i("Matrix.ThreadWatcher", "start!", new Object[0]);
    com.tencent.matrix.g.b.zH().post(new a.1(this));
  }
  
  public void stop()
  {
    super.stop();
    c.i("Matrix.ThreadWatcher", "stop!", new Object[0]);
    this.handler.removeCallbacks(this.bQv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.matrix.f.a
 * JD-Core Version:    0.7.0.1
 */