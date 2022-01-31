package com.tencent.mm.ipcinvoker.d;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class c
{
  private static volatile c dHa;
  Map<String, List<e>> dHb = new ConcurrentHashMap();
  
  public static c Cb()
  {
    if (dHa == null) {}
    try
    {
      if (dHa == null) {
        dHa = new c();
      }
      return dHa;
    }
    finally {}
  }
  
  public final boolean a(String paramString, e parame)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    List localList = (List)this.dHb.get(paramString);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new LinkedList();
      this.dHb.put(paramString, localObject);
    }
    if (((List)localObject).contains(parame)) {
      return false;
    }
    try
    {
      boolean bool = ((List)localObject).add(parame);
      return bool;
    }
    finally {}
  }
  
  public final boolean b(String paramString, e parame)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    List localList = (List)this.dHb.get(paramString);
    if (localList != null) {
      try
      {
        boolean bool = localList.remove(parame);
        if (localList.isEmpty()) {
          this.dHb.remove(paramString);
        }
        return bool;
      }
      finally {}
    }
    return false;
  }
  
  public final boolean g(String paramString, Bundle paramBundle)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    paramString = (List)this.dHb.get(paramString);
    if ((paramString == null) || (paramString.isEmpty())) {
      return true;
    }
    try
    {
      ArrayList localArrayList = new ArrayList(paramString);
      paramString = localArrayList.iterator();
      while (paramString.hasNext()) {
        ((e)paramString.next()).U(paramBundle);
      }
      return true;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.d.c
 * JD-Core Version:    0.7.0.1
 */