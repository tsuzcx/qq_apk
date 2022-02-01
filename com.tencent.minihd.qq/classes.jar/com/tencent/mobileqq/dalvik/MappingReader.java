package com.tencent.mobileqq.dalvik;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MappingReader
{
  private List a = new ArrayList();
  
  public MappingReader()
  {
    a(new File("/proc/self/maps"));
  }
  
  private IllegalArgumentException a(String paramString)
  {
    return new IllegalArgumentException("Invalid /proc/self/maps line: '" + paramString + "'");
  }
  
  /* Error */
  private void a(File paramFile)
  {
    // Byte code:
    //   0: new 47	java/io/FileReader
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 49	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   8: astore_1
    //   9: new 51	java/io/BufferedReader
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 54	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   17: astore_2
    //   18: new 12	java/util/ArrayList
    //   21: dup
    //   22: invokespecial 13	java/util/ArrayList:<init>	()V
    //   25: astore_3
    //   26: aload_2
    //   27: invokevirtual 57	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   30: astore 4
    //   32: aload 4
    //   34: ifnonnull +22 -> 56
    //   37: aload_3
    //   38: invokeinterface 63 1 0
    //   43: ifle +8 -> 51
    //   46: aload_0
    //   47: aload_3
    //   48: invokespecial 66	com/tencent/mobileqq/dalvik/MappingReader:a	(Ljava/util/List;)V
    //   51: aload_1
    //   52: invokevirtual 69	java/io/FileReader:close	()V
    //   55: return
    //   56: aload_3
    //   57: aload 4
    //   59: invokeinterface 73 2 0
    //   64: pop
    //   65: goto -39 -> 26
    //   68: astore_2
    //   69: aload_1
    //   70: invokevirtual 69	java/io/FileReader:close	()V
    //   73: aload_2
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	MappingReader
    //   0	75	1	paramFile	File
    //   17	10	2	localBufferedReader	java.io.BufferedReader
    //   68	6	2	localObject	Object
    //   25	32	3	localArrayList	ArrayList
    //   30	28	4	str	String
    // Exception table:
    //   from	to	target	type
    //   9	26	68	finally
    //   26	32	68	finally
    //   37	51	68	finally
    //   56	65	68	finally
  }
  
  private void a(List paramList)
  {
    paramList = paramList.iterator();
    for (;;)
    {
      if (!paramList.hasNext()) {
        return;
      }
      this.a.add(b((String)paramList.next()));
    }
  }
  
  private boolean a(char paramChar1, char paramChar2, String paramString)
  {
    if (paramChar1 == paramChar2) {
      return true;
    }
    if (paramChar1 == '-') {
      return false;
    }
    throw a(paramString);
  }
  
  private final long[] a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    long l2 = -1L;
    long l1 = -1L;
    int i;
    if (!paramList.hasNext())
    {
      if (l2 != -1L)
      {
        localArrayList.add(Long.valueOf(l2));
        localArrayList.add(Long.valueOf(l1));
      }
      paramList = new long[localArrayList.size()];
      i = 0;
    }
    for (;;)
    {
      if (i >= localArrayList.size())
      {
        return paramList;
        Mapping localMapping = (Mapping)paramList.next();
        if (l2 == -1L)
        {
          l2 = localMapping.a();
          l1 = localMapping.b();
          break;
        }
        if (localMapping.a() == l1)
        {
          l1 = localMapping.b();
          break;
        }
        localArrayList.add(Long.valueOf(l2));
        localArrayList.add(Long.valueOf(l1));
        l2 = localMapping.a();
        l1 = localMapping.b();
        break;
      }
      paramList[i] = ((Long)localArrayList.get(i)).longValue();
      i += 1;
    }
  }
  
  private Mapping b(String paramString)
  {
    String[] arrayOfString1 = paramString.split(" +", 6);
    if (arrayOfString1.length != 6) {
      throw a(paramString);
    }
    String[] arrayOfString2 = arrayOfString1[0].split("-");
    if (arrayOfString2.length != 2) {
      throw a(paramString);
    }
    long l1;
    long l2;
    try
    {
      l1 = Long.parseLong(arrayOfString2[0], 16);
      l2 = Long.parseLong(arrayOfString2[1], 16);
      if (arrayOfString1[1].length() != 4) {
        throw a(paramString);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw a(paramString);
    }
    boolean bool1 = a(localNumberFormatException[1].charAt(0), 'r', paramString);
    boolean bool2 = a(localNumberFormatException[1].charAt(1), 'w', paramString);
    localNumberFormatException[1].charAt(3);
    return new Mapping(l1, l2, bool1, bool2, true, localNumberFormatException[5]);
  }
  
  public final Mapping a(String paramString)
  {
    Iterator localIterator = this.a.iterator();
    Mapping localMapping;
    do
    {
      if (!localIterator.hasNext()) {
        return null;
      }
      localMapping = (Mapping)localIterator.next();
    } while (!localMapping.a().contains(paramString));
    return localMapping;
  }
  
  public final long[] a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return a(localArrayList);
      }
      Mapping localMapping = (Mapping)localIterator.next();
      if (localMapping.a()) {
        localArrayList.add(localMapping);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dalvik.MappingReader
 * JD-Core Version:    0.7.0.1
 */