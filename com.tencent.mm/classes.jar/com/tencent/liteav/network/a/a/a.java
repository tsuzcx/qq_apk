package com.tencent.liteav.network.a.a;

import com.tencent.liteav.network.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class a
{
  public static InetAddress[] a()
  {
    AppMethodBeat.i(67635);
    ArrayList localArrayList;
    try
    {
      LineNumberReader localLineNumberReader = new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("getprop").getInputStream()));
      localArrayList = new ArrayList(5);
      for (;;)
      {
        String str = localLineNumberReader.readLine();
        if (str == null) {
          break;
        }
        int i = str.indexOf("]: [");
        if (i != -1)
        {
          Object localObject = str.substring(1, i);
          str = str.substring(i + 4, str.length() - 1);
          if ((((String)localObject).endsWith(".dns")) || (((String)localObject).endsWith(".dns1")) || (((String)localObject).endsWith(".dns2")) || (((String)localObject).endsWith(".dns3")) || (((String)localObject).endsWith(".dns4")))
          {
            localObject = InetAddress.getByName(str);
            if (localObject != null)
            {
              str = ((InetAddress)localObject).getHostAddress();
              if ((str != null) && (str.length() != 0)) {
                localArrayList.add(localObject);
              }
            }
          }
        }
      }
      while (localArrayList.size() <= 0) {}
    }
    catch (IOException localIOException)
    {
      Logger.getLogger("AndroidDnsServer").log(Level.WARNING, "Exception in findDNSByExec", localIOException);
      AppMethodBeat.o(67635);
      return null;
    }
    InetAddress[] arrayOfInetAddress = (InetAddress[])localArrayList.toArray(new InetAddress[localArrayList.size()]);
    AppMethodBeat.o(67635);
    return arrayOfInetAddress;
  }
  
  public static InetAddress[] b()
  {
    AppMethodBeat.i(67636);
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class });
        ArrayList localArrayList = new ArrayList(5);
        i = 0;
        if (i < 4)
        {
          Object localObject2 = (String)((Method)localObject1).invoke(null, new Object[] { new String[] { "net.dns1", "net.dns2", "net.dns3", "net.dns4" }[i] });
          if ((localObject2 != null) && (((String)localObject2).length() != 0))
          {
            localObject2 = InetAddress.getByName((String)localObject2);
            if (localObject2 != null)
            {
              String str = ((InetAddress)localObject2).getHostAddress();
              if ((str != null) && (str.length() != 0) && (!localArrayList.contains(localObject2))) {
                localArrayList.add(localObject2);
              }
            }
          }
        }
        else if (localArrayList.size() > 0)
        {
          localObject1 = (InetAddress[])localArrayList.toArray(new InetAddress[localArrayList.size()]);
          AppMethodBeat.o(67636);
          return localObject1;
        }
      }
      catch (Exception localException)
      {
        Logger.getLogger("AndroidDnsServer").log(Level.WARNING, "Exception in findDNSByReflection", localException);
        AppMethodBeat.o(67636);
        return null;
      }
      i += 1;
    }
  }
  
  public static c c()
  {
    AppMethodBeat.i(67637);
    a.1 local1 = new a.1();
    AppMethodBeat.o(67637);
    return local1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.network.a.a.a
 * JD-Core Version:    0.7.0.1
 */