package com.tencent.mm.m;

import android.view.ContextMenu.ContextMenuInfo;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class d
{
  public static final int[] dAk = { 1 };
  HashMap<String, HashMap<String, String>> dAl = new HashMap();
  public Map<String, String> dAm = null;
  private int id;
  int version;
  
  public d(int paramInt)
  {
    this.id = paramInt;
  }
  
  private static LinkedList<a> c(Map<String, String> paramMap, String paramString)
  {
    LinkedList localLinkedList = null;
    int i = 0;
    Object localObject2 = new StringBuilder().append(paramString);
    Object localObject1;
    if (i == 0)
    {
      localObject1 = "";
      label25:
      String str = localObject1;
      if (paramMap.get(str) == null) {
        break label202;
      }
      localObject1 = str + ".id";
      localObject2 = str + ".title";
      str = str + ".url";
      if (!paramMap.containsKey(localObject1)) {
        break label202;
      }
      localObject1 = new a((String)paramMap.get(localObject1), (String)paramMap.get(localObject2), (String)paramMap.get(str));
      if (localLinkedList != null) {
        break label204;
      }
      localLinkedList = new LinkedList();
    }
    label202:
    label204:
    for (;;)
    {
      localLinkedList.add(localObject1);
      i += 1;
      break;
      localObject1 = Integer.valueOf(i);
      break label25;
      return localLinkedList;
    }
  }
  
  public static LinkedList<a> f(Map<String, String> paramMap)
  {
    Object localObject1 = null;
    int i = 0;
    Object localObject3 = new StringBuilder(".ConfigList.Config");
    if (i == 0) {}
    for (Object localObject2 = "";; localObject2 = Integer.valueOf(i))
    {
      localObject3 = localObject2;
      localObject2 = localObject1;
      if (paramMap.get((String)localObject3 + ".$name") != null)
      {
        if (!((String)paramMap.get((String)localObject3 + ".$name")).equalsIgnoreCase("JDWebViewMenu")) {
          break label234;
        }
        localObject2 = c(paramMap, (String)localObject3 + ".menuItems.menuItem");
        localObject3 = c(paramMap, (String)localObject3 + ".menuItems.newMenuItem");
        if (localObject2 != null) {
          break;
        }
        localObject2 = localObject3;
      }
      return localObject2;
    }
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (((LinkedList)localObject3).size() > 0)
      {
        y.d("MicroMsg.ConfigListInfo", "has menuItem2, %s, %s", new Object[] { Integer.valueOf(((LinkedList)localObject2).size()), Integer.valueOf(((LinkedList)localObject3).size()) });
        ((LinkedList)localObject2).addAll((Collection)localObject3);
        localObject1 = localObject2;
      }
    }
    label234:
    for (;;)
    {
      i += 1;
      break;
    }
  }
  
  static boolean fh(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        if (bk.bl(paramString)) {
          return false;
        }
        Object localObject = new ArrayList();
        if (!bk.bl(paramString))
        {
          paramString = paramString.split(",");
          if ((paramString != null) && (paramString.length > 0))
          {
            i = 0;
            if (i < paramString.length)
            {
              if (bk.bl(paramString[i])) {
                break label237;
              }
              ((List)localObject).add(paramString[i]);
              break label237;
            }
          }
        }
        paramString = x.cqJ();
        if (bk.bl(paramString)) {
          return false;
        }
        y.d("MicroMsg.ConfigListInfo", "locale is " + paramString);
        localObject = ((List)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          if ((str.trim().toLowerCase().equals("other")) && (!paramString.equals("zh_CN")))
          {
            y.d("MicroMsg.ConfigListInfo", "find other");
            return true;
          }
          if (!str.trim().toLowerCase().equals(paramString.trim().toLowerCase())) {
            continue;
          }
          y.d("MicroMsg.ConfigListInfo", "find ");
          return true;
        }
      }
      catch (Exception paramString)
      {
        y.e("MicroMsg.ConfigListInfo", "exception:%s", new Object[] { bk.j(paramString) });
        y.d("MicroMsg.ConfigListInfo", "isContainLocale failed " + paramString.getMessage());
      }
      return false;
      label237:
      i += 1;
    }
  }
  
  public static final class a
  {
    public String id;
    public String title;
    public String url;
    
    public a(String paramString1, String paramString2, String paramString3)
    {
      this.id = paramString1;
      this.title = paramString2;
      this.url = paramString3;
    }
  }
  
  public static final class b
    implements ContextMenu.ContextMenuInfo
  {
    private static int dAn = 10000;
    public final int id;
    public final String key;
    public final String title;
    
    public b(String paramString1, String paramString2)
    {
      int i = dAn;
      dAn = i + 1;
      this.id = i;
      this.key = paramString1;
      this.title = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.m.d
 * JD-Core Version:    0.7.0.1
 */