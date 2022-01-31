package com.tencent.d.e.a.a;

import android.content.Context;
import com.qq.taf.jce.JceInputStream;
import com.tencent.d.e.a.b.a;
import com.tencent.d.f.b;
import com.tencent.d.f.c;
import com.tencent.d.f.f;
import com.tencent.d.f.j;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class h
{
  private static final j<h> wMZ = new h.1();
  public Context mContext;
  public boolean mInit = false;
  
  public static h cOW()
  {
    return (h)wMZ.get();
  }
  
  public static h.a d(Map<String, a> paramMap, int paramInt)
  {
    if (paramMap == null) {}
    ArrayList localArrayList;
    Object localObject;
    do
    {
      return null;
      localArrayList = new ArrayList();
      Iterator localIterator = paramMap.keySet().iterator();
      localObject = null;
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        a locala = (a)paramMap.get(str);
        if ((locala != null) && (locala.requestType == paramInt))
        {
          localArrayList.add(str);
          if (localObject == null) {
            localObject = locala;
          } else {
            localObject.wNM.addAll(locala.wNM);
          }
        }
      }
    } while (localObject == null);
    paramMap = new h.a((byte)0);
    paramMap.wNC = localObject;
    paramMap.wND = localArrayList;
    return paramMap;
  }
  
  public static String ge(int paramInt1, int paramInt2)
  {
    return paramInt1 + "00" + paramInt2;
  }
  
  public final Map<String, a> cOX()
  {
    HashMap localHashMap = new HashMap();
    Object localObject = this.mContext.getDir("turingmm", 0);
    if (localObject == null) {}
    File[] arrayOfFile;
    do
    {
      return localHashMap;
      arrayOfFile = ((File)localObject).listFiles();
    } while (arrayOfFile == null);
    int j = arrayOfFile.length;
    int i = 0;
    label44:
    File localFile;
    if (i < j)
    {
      localFile = arrayOfFile[i];
      try
      {
        localObject = c.k(f.W(new File(localFile.getAbsolutePath())), c.cOZ());
        if (localObject == null)
        {
          localObject = null;
          label83:
          if (localObject != null) {
            break label150;
          }
          throw new NullPointerException("csGroupRecord is null.");
        }
      }
      catch (Throwable localThrowable)
      {
        localFile.deleteOnExit();
      }
    }
    for (;;)
    {
      i += 1;
      break label44;
      break;
      byte[] arrayOfByte = b.bO(localThrowable);
      if (arrayOfByte == null)
      {
        locala = null;
        break label83;
      }
      a locala = new a();
      locala.readFrom(new JceInputStream(arrayOfByte));
      break label83;
      label150:
      localHashMap.put(localFile.getAbsolutePath(), locala);
    }
  }
  
  public final String gd(int paramInt1, int paramInt2)
  {
    String str = ge(paramInt1, paramInt2);
    File localFile = this.mContext.getDir("turingmm", 0);
    if (localFile == null) {
      return "";
    }
    Object localObject2 = localFile.listFiles();
    if (localObject2 == null) {
      return "";
    }
    Object localObject1 = new ArrayList();
    paramInt2 = localObject2.length;
    paramInt1 = 0;
    Object localObject3;
    while (paramInt1 < paramInt2)
    {
      localObject3 = localObject2[paramInt1];
      if (((File)localObject3).getName().startsWith(str)) {
        ((List)localObject1).add(localObject3);
      }
      paramInt1 += 1;
    }
    if (((List)localObject1).size() <= 2) {
      return "";
    }
    localObject2 = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = ((File)((Iterator)localObject1).next()).getName().split("_");
      if ((localObject3.length == 2) && (localObject3[0].equals(str))) {
        ((List)localObject2).add(Long.valueOf(Long.parseLong(localObject3[1])));
      }
    }
    if (((List)localObject2).size() <= 2) {
      return "";
    }
    Collections.sort((List)localObject2);
    return localFile.getAbsolutePath() + File.separator + str + "_" + ((List)localObject2).get(0);
  }
  
  public final void init(Context paramContext)
  {
    this.mContext = paramContext;
    this.mInit = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.d.e.a.a.h
 * JD-Core Version:    0.7.0.1
 */