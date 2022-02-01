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
  private static final j<h> MtV;
  public Context mContext;
  public boolean mInit = false;
  
  static
  {
    AppMethodBeat.i(138409);
    MtV = new j() {};
    AppMethodBeat.o(138409);
  }
  
  public static a j(Map<String, a> paramMap, int paramInt)
  {
    AppMethodBeat.i(138407);
    if (paramMap == null)
    {
      AppMethodBeat.o(138407);
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
          localObject.ahuB.addAll(locala.ahuB);
        }
      }
    }
    if (localObject != null)
    {
      paramMap = new a((byte)0);
      paramMap.ahur = localObject;
      paramMap.ahus = localArrayList;
      AppMethodBeat.o(138407);
      return paramMap;
    }
    AppMethodBeat.o(138407);
    return null;
  }
  
  public static h jXt()
  {
    AppMethodBeat.i(138404);
    h localh = (h)MtV.get();
    AppMethodBeat.o(138404);
    return localh;
  }
  
  public static String pH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(138408);
    String str = paramInt1 + "00" + paramInt2;
    AppMethodBeat.o(138408);
    return str;
  }
  
  public final void init(Context paramContext)
  {
    this.mContext = paramContext;
    this.mInit = true;
  }
  
  public final Map<String, a> jXu()
  {
    AppMethodBeat.i(138406);
    HashMap localHashMap = new HashMap();
    Object localObject = this.mContext.getDir("turingmm", 0);
    if (localObject == null)
    {
      AppMethodBeat.o(138406);
      return localHashMap;
    }
    File[] arrayOfFile = ((File)localObject).listFiles();
    if (arrayOfFile == null)
    {
      AppMethodBeat.o(138406);
      return localHashMap;
    }
    int j = arrayOfFile.length;
    int i = 0;
    if (i < j)
    {
      File localFile = arrayOfFile[i];
      try
      {
        localObject = c.r(f.Y(new File(localFile.getAbsolutePath())), c.jXz());
        if (localObject == null)
        {
          localObject = null;
          label101:
          if (localObject != null) {
            break label175;
          }
          localObject = new NullPointerException("csGroupRecord is null.");
          AppMethodBeat.o(138406);
          throw ((Throwable)localObject);
        }
      }
      finally
      {
        localFile.deleteOnExit();
      }
      for (;;)
      {
        i += 1;
        break;
        byte[] arrayOfByte2 = b.dv(arrayOfByte1);
        if (arrayOfByte2 == null)
        {
          locala = null;
          break label101;
        }
        a locala = new a();
        locala.readFrom(new JceInputStream(arrayOfByte2));
        break label101;
        label175:
        localHashMap.put(localFile.getAbsolutePath(), locala);
      }
    }
    AppMethodBeat.o(138406);
    return localHashMap;
  }
  
  public final String pG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(138405);
    String str = pH(paramInt1, paramInt2);
    File localFile = this.mContext.getDir("turingmm", 0);
    if (localFile == null)
    {
      AppMethodBeat.o(138405);
      return "";
    }
    Object localObject2 = localFile.listFiles();
    if (localObject2 == null)
    {
      AppMethodBeat.o(138405);
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
      AppMethodBeat.o(138405);
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
      AppMethodBeat.o(138405);
      return "";
    }
    Collections.sort((List)localObject2);
    str = localFile.getAbsolutePath() + File.separator + str + "_" + ((List)localObject2).get(0);
    AppMethodBeat.o(138405);
    return str;
  }
  
  public static final class a
  {
    public a ahur;
    public List<String> ahus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.e.e.a.a.h
 * JD-Core Version:    0.7.0.1
 */