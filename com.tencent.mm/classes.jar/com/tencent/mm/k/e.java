package com.tencent.mm.k;

import android.view.ContextMenu.ContextMenuInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class e
{
  public static final int[] lZN = { 1 };
  private int id;
  HashMap<String, HashMap<String, String>> lZO;
  public Map<String, String> lZP;
  int version;
  
  public e(int paramInt)
  {
    AppMethodBeat.i(131988);
    this.lZO = new HashMap();
    this.lZP = null;
    this.id = paramInt;
    AppMethodBeat.o(131988);
  }
  
  static boolean DK(String paramString)
  {
    AppMethodBeat.i(131989);
    for (;;)
    {
      int i;
      try
      {
        boolean bool = Util.isNullOrNil(paramString);
        if (bool)
        {
          AppMethodBeat.o(131989);
          return false;
        }
        Object localObject = new ArrayList();
        if (!Util.isNullOrNil(paramString))
        {
          paramString = paramString.split(",");
          if ((paramString != null) && (paramString.length > 0))
          {
            i = 0;
            if (i < paramString.length)
            {
              if (Util.isNullOrNil(paramString[i])) {
                break label267;
              }
              ((List)localObject).add(paramString[i]);
              break label267;
            }
          }
        }
        paramString = LocaleUtil.getApplicationLanguage();
        bool = Util.isNullOrNil(paramString);
        if (bool)
        {
          AppMethodBeat.o(131989);
          return false;
        }
        Log.d("MicroMsg.ConfigListInfo", "locale is ".concat(String.valueOf(paramString)));
        localObject = ((List)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          if ((str.trim().toLowerCase().equals("other")) && (!paramString.equals("zh_CN")))
          {
            Log.d("MicroMsg.ConfigListInfo", "find other");
            AppMethodBeat.o(131989);
            return true;
          }
          if (!str.trim().toLowerCase().equals(paramString.trim().toLowerCase())) {
            continue;
          }
          Log.d("MicroMsg.ConfigListInfo", "find ");
          AppMethodBeat.o(131989);
          return true;
        }
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.ConfigListInfo", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
        Log.d("MicroMsg.ConfigListInfo", "isContainLocale failed " + paramString.getMessage());
        AppMethodBeat.o(131989);
        return false;
      }
      label267:
      i += 1;
    }
  }
  
  private static LinkedList<a> c(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(131990);
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
      AppMethodBeat.o(131990);
      return localLinkedList;
    }
  }
  
  public static LinkedList<a> r(Map<String, String> paramMap)
  {
    AppMethodBeat.i(131991);
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
      AppMethodBeat.o(131991);
      return localObject3;
    }
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (((LinkedList)localObject3).size() > 0)
      {
        Log.d("MicroMsg.ConfigListInfo", "has menuItem2, %s, %s", new Object[] { Integer.valueOf(((LinkedList)localObject2).size()), Integer.valueOf(((LinkedList)localObject3).size()) });
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
      AppMethodBeat.o(131991);
      return localObject1;
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
    private static int lZQ = 10000;
    public final int id;
    public final String key;
    public final String title;
    
    public b(String paramString1, String paramString2)
    {
      AppMethodBeat.i(131987);
      int i = lZQ;
      lZQ = i + 1;
      this.id = i;
      this.key = paramString1;
      this.title = paramString2;
      AppMethodBeat.o(131987);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.k.e
 * JD-Core Version:    0.7.0.1
 */