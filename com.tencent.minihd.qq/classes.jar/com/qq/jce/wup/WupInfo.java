package com.qq.jce.wup;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Properties;

public class WupInfo
{
  private static String clientBuilt = null;
  private static String clientInfo = null;
  private static String clientNumber = null;
  
  static
  {
    try
    {
      InputStream localInputStream = WupInfo.class.getResourceAsStream("/com/qq/jce/wup/wup.properties");
      Properties localProperties = new Properties();
      localProperties.load(localInputStream);
      localInputStream.close();
      clientInfo = localProperties.getProperty("client.info");
      clientBuilt = localProperties.getProperty("client.built");
      clientNumber = localProperties.getProperty("client.number");
      label64:
      if (clientInfo == null) {
        clientInfo = "Tencent Taf";
      }
      if (clientBuilt == null) {
        clientBuilt = "unknown";
      }
      if (clientNumber == null) {
        clientNumber = "unknown";
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      break label64;
    }
  }
  
  public static String getClientBuilt()
  {
    return clientBuilt;
  }
  
  public static String getClientInfo()
  {
    return clientInfo;
  }
  
  public static String getClientNumber()
  {
    return clientNumber;
  }
  
  public static void main(String[] paramArrayOfString)
  {
    System.out.println(showString());
    System.out.println("Client version: " + getClientInfo());
    System.out.println("Client built:   " + getClientBuilt());
    System.out.println("Client number:  " + getClientNumber());
    System.out.println("OS Name:        " + System.getProperty("os.name"));
    System.out.println("OS Version:     " + System.getProperty("os.version"));
    System.out.println("Architecture:   " + System.getProperty("os.arch"));
    System.out.println("JVM Version:    " + System.getProperty("java.runtime.version"));
    System.out.println("JVM Vendor:     " + System.getProperty("java.vm.vendor"));
  }
  
  public static String showString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("Client version: " + getClientInfo() + "\n");
    localStringBuffer.append("Client built:   " + getClientBuilt() + "\n");
    localStringBuffer.append("Client number:  " + getClientNumber() + "\n");
    localStringBuffer.append("OS Name:        " + System.getProperty("os.name") + "\n");
    localStringBuffer.append("OS Version:     " + System.getProperty("os.version") + "\n");
    localStringBuffer.append("Architecture:   " + System.getProperty("os.arch") + "\n");
    localStringBuffer.append("JVM Version:    " + System.getProperty("java.runtime.version") + "\n");
    localStringBuffer.append("JVM Vendor:     " + System.getProperty("java.vm.vendor") + "\n");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.qq.jce.wup.WupInfo
 * JD-Core Version:    0.7.0.1
 */