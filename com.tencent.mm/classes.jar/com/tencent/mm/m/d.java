package com.tencent.mm.m;

import android.view.ContextMenu.ContextMenuInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class d
{
  public static final int[] etM = { 1 };
  HashMap<String, HashMap<String, String>> etN;
  public Map<String, String> etO;
  private int id;
  int version;
  
  public d(int paramInt)
  {
    AppMethodBeat.i(57867);
    this.etN = new HashMap();
    this.etO = null;
    this.id = paramInt;
    AppMethodBeat.o(57867);
  }
  
  private static LinkedList<a> c(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(57869);
    LinkedList localLinkedList = null;
    int i = 0;
    Object localObject2 = new StringBuilder().append(paramString);
    Object localObject1;
    if (i == 0)
    {
      localObject1 = "";
      label30:
      String str = localObject1;
      if (paramMap.get(str) == null) {
        break label207;
      }
      localObject1 = str + ".id";
      localObject2 = str + ".title";
      str = str + ".url";
      if (!paramMap.containsKey(localObject1)) {
        break label207;
      }
      localObject1 = new a((String)paramMap.get(localObject1), (String)paramMap.get(localObject2), (String)paramMap.get(str));
      if (localLinkedList != null) {
        break label214;
      }
      localLinkedList = new LinkedList();
    }
    label207:
    label214:
    for (;;)
    {
      localLinkedList.add(localObject1);
      i += 1;
      break;
      localObject1 = Integer.valueOf(i);
      break label30;
      AppMethodBeat.o(57869);
      return localLinkedList;
    }
  }
  
  public static LinkedList<a> g(Map<String, String> paramMap)
  {
    AppMethodBeat.i(57870);
    Object localObject1 = null;
    int i = 0;
    Object localObject3 = new StringBuilder(".ConfigList.Config");
    if (i == 0) {}
    for (Object localObject2 = "";; localObject2 = Integer.valueOf(i))
    {
      localObject3 = localObject2;
      if (paramMap.get((String)localObject3 + ".$name") == null) {
        break label240;
      }
      if (!((String)paramMap.get((String)localObject3 + ".$name")).equalsIgnoreCase("JDWebViewMenu")) {
        break label247;
      }
      localObject2 = c(paramMap, (String)localObject3 + ".menuItems.menuItem");
      localObject3 = c(paramMap, (String)localObject3 + ".menuItems.newMenuItem");
      if (localObject2 != null) {
        break;
      }
      AppMethodBeat.o(57870);
      return localObject3;
    }
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (((LinkedList)localObject3).size() > 0)
      {
        ab.d("MicroMsg.ConfigListInfo", "has menuItem2, %s, %s", new Object[] { Integer.valueOf(((LinkedList)localObject2).size()), Integer.valueOf(((LinkedList)localObject3).size()) });
        ((LinkedList)localObject2).addAll((Collection)localObject3);
        localObject1 = localObject2;
      }
    }
    label240:
    label247:
    for (;;)
    {
      i += 1;
      break;
      AppMethodBeat.o(57870);
      return localObject1;
    }
  }
  
  static boolean lu(String paramString)
  {
    AppMethodBeat.i(57868);
    for (;;)
    {
      int i;
      try
      {
        boolean bool = bo.isNullOrNil(paramString);
        if (bool)
        {
          AppMethodBeat.o(57868);
          return false;
        }
        Object localObject = new ArrayList();
        if (!bo.isNullOrNil(paramString))
        {
          paramString = paramString.split(",");
          if ((paramString != null) && (paramString.length > 0))
          {
            i = 0;
            if (i < paramString.length)
            {
              if (bo.isNullOrNil(paramString[i])) {
                break label267;
              }
              ((List)localObject).add(paramString[i]);
              break label267;
            }
          }
        }
        paramString = aa.dsG();
        bool = bo.isNullOrNil(paramString);
        if (bool)
        {
          AppMethodBeat.o(57868);
          return false;
        }
        ab.d("MicroMsg.ConfigListInfo", "locale is ".concat(String.valueOf(paramString)));
        localObject = ((List)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          if ((str.trim().toLowerCase().equals("other")) && (!paramString.equals("zh_CN")))
          {
            ab.d("MicroMsg.ConfigListInfo", "find other");
            AppMethodBeat.o(57868);
            return true;
          }
          if (!str.trim().toLowerCase().equals(paramString.trim().toLowerCase())) {
            continue;
          }
          ab.d("MicroMsg.ConfigListInfo", "find ");
          AppMethodBeat.o(57868);
          return true;
        }
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.ConfigListInfo", "exception:%s", new Object[] { bo.l(paramString) });
        ab.d("MicroMsg.ConfigListInfo", "isContainLocale failed " + paramString.getMessage());
        AppMethodBeat.o(57868);
        return false;
      }
      label267:
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
    private static int etP = 10000;
    public final int id;
    public final String key;
    public final String title;
    
    public b(String paramString1, String paramString2)
    {
      AppMethodBeat.i(57866);
      int i = etP;
      etP = i + 1;
      this.id = i;
      this.key = paramString1;
      this.title = paramString2;
      AppMethodBeat.o(57866);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.m.d
 * JD-Core Version:    0.7.0.1
 */