package com.tencent.matrix.report;

import android.os.Process;
import android.text.TextUtils;
import androidx.core.f.d;
import com.tencent.wxperf.thread.ThreadInspect;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class c$b
{
  static String gT(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    String[] arrayOfString = paramString.split("\n");
    int i = 0;
    if ((i < arrayOfString.length) && (i < 30))
    {
      if (localStringBuilder.length() == 0) {}
      for (paramString = "";; paramString = ";")
      {
        localStringBuilder.append(paramString).append(arrayOfString[i]);
        i += 1;
        break;
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String gU(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    String[] arrayOfString = paramString.split("\n");
    int j = arrayOfString.length;
    int i = 0;
    if (i < j)
    {
      String str = arrayOfString[i].trim();
      if ((!str.startsWith("com.tencent.wxperf.thread.ThreadInspect")) && (!str.startsWith("at com.tencent.wxperf.thread.ThreadInspect"))) {
        if (localStringBuilder.length() != 0) {
          break label93;
        }
      }
      label93:
      for (paramString = "";; paramString = ";")
      {
        localStringBuilder.append(paramString).append(str);
        i += 1;
        break;
      }
    }
    return localStringBuilder.toString();
  }
  
  static String gV(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    List localList = Arrays.asList(new String[] { "tencent", "hilive" });
    String[] arrayOfString = paramString.split("\n");
    int n = arrayOfString.length;
    int k = 0;
    int i = 0;
    Object localObject;
    if (k < n)
    {
      paramString = arrayOfString[k];
      if (i < 10)
      {
        localObject = localList.iterator();
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
        } while (!paramString.contains((String)((Iterator)localObject).next()));
      }
    }
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        j = -1;
        int m = paramString.length();
        if (paramString.contains("/lib"))
        {
          j = paramString.lastIndexOf("/lib") + 4;
          label139:
          if (paramString.contains("+")) {
            m = paramString.lastIndexOf("+");
          }
          if ((j < 0) || (j >= m)) {
            break label276;
          }
          localObject = paramString.substring(j, m).trim();
          if ((TextUtils.isEmpty((CharSequence)localObject)) || ((((String)localObject).endsWith(".so")) && (localStringBuilder.toString().endsWith((String)localObject)))) {
            break label276;
          }
          if (localStringBuilder.length() != 0) {
            break label264;
          }
          paramString = "";
          label220:
          localStringBuilder.append(paramString).append((String)localObject);
          i += 1;
        }
      }
      label264:
      label276:
      for (;;)
      {
        k += 1;
        break;
        if (!paramString.contains(" (")) {
          break label139;
        }
        j = paramString.lastIndexOf(" (") + 2;
        break label139;
        paramString = ";";
        break label220;
        return localStringBuilder.toString();
      }
    }
  }
  
  static d<String, String> nr(int paramInt)
  {
    Object localObject3 = "";
    for (;;)
    {
      try
      {
        if (paramInt != Process.myPid()) {
          continue;
        }
        localObject1 = "unwind_err: skip ui thread";
      }
      finally
      {
        Object localObject1;
        String str2;
        String str1 = "unwind_err: " + localObject2.getMessage();
        continue;
      }
      return new d(localObject1, localObject3);
      if (ThreadInspect.init())
      {
        str2 = ThreadInspect.jUnwindR(paramInt);
        if (!TextUtils.isEmpty(str2))
        {
          localObject1 = gT(str2);
          str2 = gU(str2);
          localObject3 = str2;
        }
        else
        {
          if (paramInt == Process.myTid())
          {
            localObject1 = ThreadInspect.getLocalCurrentThread();
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              localObject1 = "unwind_err: empty";
            }
          }
          else
          {
            localObject1 = ThreadInspect.getLocalThread(paramInt);
            continue;
          }
          str2 = gT((String)localObject1);
          localObject1 = gV((String)localObject1);
          localObject3 = localObject1;
          localObject1 = str2;
        }
      }
      else
      {
        localObject1 = "unwind_err: init fail";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.report.c.b
 * JD-Core Version:    0.7.0.1
 */