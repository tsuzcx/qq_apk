package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.mm.sdk.platformtools.bk;
import java.util.HashMap;
import java.util.HashSet;

final class c$a
{
  final HashMap<String, HashSet<String>> gWQ = new HashMap();
  
  final void B(String paramString1, String paramString2)
  {
    if ((bk.bl(paramString1)) || (bk.bl(paramString2))) {
      return;
    }
    try
    {
      paramString1 = (HashSet)this.gWQ.get(paramString1);
      if (paramString1 != null) {
        paramString1.remove(paramString2);
      }
      return;
    }
    finally {}
  }
  
  final boolean ca(String paramString1, String paramString2)
  {
    if ((bk.bl(paramString1)) || (bk.bl(paramString2))) {
      return false;
    }
    for (;;)
    {
      try
      {
        paramString1 = (HashSet)this.gWQ.get(paramString1);
        if ((paramString1 != null) && (paramString1.contains(paramString2)))
        {
          bool = true;
          return bool;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  final void put(String paramString1, String paramString2)
  {
    if ((bk.bl(paramString1)) || (bk.bl(paramString2))) {
      return;
    }
    try
    {
      HashSet localHashSet2 = (HashSet)this.gWQ.get(paramString1);
      HashSet localHashSet1 = localHashSet2;
      if (localHashSet2 == null)
      {
        localHashSet1 = new HashSet();
        this.gWQ.put(paramString1, localHashSet1);
      }
      localHashSet1.add(paramString2);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.c.a
 * JD-Core Version:    0.7.0.1
 */