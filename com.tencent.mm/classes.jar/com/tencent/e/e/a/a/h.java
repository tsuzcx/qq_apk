package com.tencent.e.e.a.a;

import android.content.Context;
import com.qq.taf.jce.JceInputStream;
import com.tencent.e.e.a.b.a;
import com.tencent.e.f.b;
import com.tencent.e.f.c;
import com.tencent.e.f.f;
import com.tencent.e.f.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  private static final j<h> Bky;
  public Context mContext;
  public boolean mInit = false;
  
  static
  {
    AppMethodBeat.i(114568);
    Bky = new h.1();
    AppMethodBeat.o(114568);
  }
  
  public static h dUM()
  {
    AppMethodBeat.i(114563);
    h localh = (h)Bky.get();
    AppMethodBeat.o(114563);
    return localh;
  }
  
  public static h.a e(Map<String, a> paramMap, int paramInt)
  {
    AppMethodBeat.i(114566);
    if (paramMap == null)
    {
      AppMethodBeat.o(114566);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramMap.keySet().iterator();
    Object localObject = null;
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
          localObject.Blk.addAll(locala.Blk);
        }
      }
    }
    if (localObject != null)
    {
      paramMap = new h.a((byte)0);
      paramMap.Blb = localObject;
      paramMap.Blc = localArrayList;
      AppMethodBeat.o(114566);
      return paramMap;
    }
    AppMethodBeat.o(114566);
    return null;
  }
  
  public static String im(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(114567);
    String str = paramInt1 + "00" + paramInt2;
    AppMethodBeat.o(114567);
    return str;
  }
  
  public final Map<String, a> dUN()
  {
    AppMethodBeat.i(114565);
    HashMap localHashMap = new HashMap();
    Object localObject = this.mContext.getDir("turingmm", 0);
    if (localObject == null)
    {
      AppMethodBeat.o(114565);
      return localHashMap;
    }
    File[] arrayOfFile = ((File)localObject).listFiles();
    if (arrayOfFile == null)
    {
      AppMethodBeat.o(114565);
      return localHashMap;
    }
    int j = arrayOfFile.length;
    int i = 0;
    if (i < j)
    {
      File localFile = arrayOfFile[i];
      try
      {
        localObject = c.n(f.af(new File(localFile.getAbsolutePath())), c.dUP());
        if (localObject == null)
        {
          localObject = null;
          label101:
          if (localObject != null) {
            break label175;
          }
          localObject = new NullPointerException("csGroupRecord is null.");
          AppMethodBeat.o(114565);
          throw ((Throwable)localObject);
        }
      }
      catch (Throwable localThrowable)
      {
        localFile.deleteOnExit();
      }
      for (;;)
      {
        i += 1;
        break;
        byte[] arrayOfByte = b.co(localThrowable);
        if (arrayOfByte == null)
        {
          locala = null;
          break label101;
        }
        a locala = new a();
        locala.readFrom(new JceInputStream(arrayOfByte));
        break label101;
        label175:
        localHashMap.put(localFile.getAbsolutePath(), locala);
      }
    }
    AppMethodBeat.o(114565);
    return localHashMap;
  }
  
  public final String il(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(114564);
    String str = im(paramInt1, paramInt2);
    File localFile = this.mContext.getDir("turingmm", 0);
    if (localFile == null)
    {
      AppMethodBeat.o(114564);
      return "";
    }
    Object localObject2 = localFile.listFiles();
    if (localObject2 == null)
    {
      AppMethodBeat.o(114564);
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
    if (((List)localObject1).size() <= 2)
    {
      AppMethodBeat.o(114564);
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
    if (((List)localObject2).size() <= 2)
    {
      AppMethodBeat.o(114564);
      return "";
    }
    Collections.sort((List)localObject2);
    str = localFile.getAbsolutePath() + File.separator + str + "_" + ((List)localObject2).get(0);
    AppMethodBeat.o(114564);
    return str;
  }
  
  public final void init(Context paramContext)
  {
    this.mContext = paramContext;
    this.mInit = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.e.e.a.a.h
 * JD-Core Version:    0.7.0.1
 */