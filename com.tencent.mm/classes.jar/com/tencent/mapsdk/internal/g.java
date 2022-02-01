package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.Properties;

public class g
{
  private static String a = null;
  private static String b = null;
  private static String c = null;
  
  static
  {
    AppMethodBeat.i(224877);
    try
    {
      InputStream localInputStream = g.class.getResourceAsStream("/com/qq/jce/wup/wup.properties");
      Properties localProperties = new Properties();
      localProperties.load(localInputStream);
      localInputStream.close();
      a = localProperties.getProperty("client.info");
      b = localProperties.getProperty("client.built");
      c = localProperties.getProperty("client.number");
      label69:
      if (a == null) {
        a = "Tencent Taf";
      }
      if (b == null) {
        b = "unknown";
      }
      if (c == null) {
        c = "unknown";
      }
      AppMethodBeat.o(224877);
      return;
    }
    finally
    {
      break label69;
    }
  }
  
  private static String a()
  {
    return a;
  }
  
  private static String b()
  {
    return b;
  }
  
  private static String c()
  {
    return c;
  }
  
  private static String d()
  {
    AppMethodBeat.i(224866);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Client version: " + a + "\n");
    ((StringBuilder)localObject).append("Client built:   " + b + "\n");
    ((StringBuilder)localObject).append("Client number:  " + c + "\n");
    ((StringBuilder)localObject).append("OS Name:        " + System.getProperty("os.name") + "\n");
    ((StringBuilder)localObject).append("OS Version:     " + System.getProperty("os.version") + "\n");
    ((StringBuilder)localObject).append("Architecture:   " + System.getProperty("os.arch") + "\n");
    ((StringBuilder)localObject).append("JVM Version:    " + System.getProperty("java.runtime.version") + "\n");
    ((StringBuilder)localObject).append("JVM Vendor:     " + System.getProperty("java.vm.vendor") + "\n");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(224866);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mapsdk.internal.g
 * JD-Core Version:    0.7.0.1
 */