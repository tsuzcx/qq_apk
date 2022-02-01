package com.tencent.mapsdk.internal;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class qn
{
  public static final int a = 1000;
  public static final int b = 11;
  private static final String f = "[{\"id\":0,\"index\":0,\"order\":1},{\"id\":-1,\"index\":1,\"order\":-1},{\"id\":-1,\"index\":2,\"order\":-1},{\"id\":-1,\"index\":3,\"order\":-1},{\"id\":-1,\"index\":4,\"order\":-1},{\"id\":-1,\"index\":5,\"order\":-1},{\"id\":-1,\"index\":6,\"order\":-1},{\"id\":-1,\"index\":7,\"order\":-1},{\"id\":16,\"index\":8,\"order\":-1},{\"id\":9,\"index\":9,\"order\":-1},{\"id\":10,\"index\":10,\"order\":-1},{\"id\":5,\"index\":11,\"order\":-1},{\"id\":4,\"index\":12,\"order\":-1},{\"id\":6,\"index\":13,\"order\":-1},{\"id\":7,\"index\":14,\"order\":-1},{\"id\":8,\"index\":15,\"order\":-1}]";
  public volatile List<qm> c;
  public mb d;
  public int e;
  
  public qn(Context paramContext, String paramString)
  {
    AppMethodBeat.i(225880);
    this.e = -1;
    if (paramString == null) {}
    for (this.d = me.a(paramContext);; this.d = md.a(paramContext, paramString))
    {
      this.c = new CopyOnWriteArrayList();
      paramString = this.d.a("mapStyleList");
      paramContext = paramString;
      if (paramString == null) {
        paramContext = "[{\"id\":0,\"index\":0,\"order\":1},{\"id\":-1,\"index\":1,\"order\":-1},{\"id\":-1,\"index\":2,\"order\":-1},{\"id\":-1,\"index\":3,\"order\":-1},{\"id\":-1,\"index\":4,\"order\":-1},{\"id\":-1,\"index\":5,\"order\":-1},{\"id\":-1,\"index\":6,\"order\":-1},{\"id\":-1,\"index\":7,\"order\":-1},{\"id\":16,\"index\":8,\"order\":-1},{\"id\":9,\"index\":9,\"order\":-1},{\"id\":10,\"index\":10,\"order\":-1},{\"id\":5,\"index\":11,\"order\":-1},{\"id\":4,\"index\":12,\"order\":-1},{\"id\":6,\"index\":13,\"order\":-1},{\"id\":7,\"index\":14,\"order\":-1},{\"id\":8,\"index\":15,\"order\":-1}]";
      }
      try
      {
        paramContext = new JSONArray(paramContext);
        this.c.addAll(a(paramContext));
        AppMethodBeat.o(225880);
        return;
      }
      catch (Exception paramContext)
      {
        AppMethodBeat.o(225880);
      }
    }
  }
  
  public static List<qm> a(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(225908);
    if (paramJSONArray == null)
    {
      AppMethodBeat.o(225908);
      return null;
    }
    int j = paramJSONArray.length();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j) {
      try
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
        localArrayList.add(new qm(localJSONObject.getInt("index"), localJSONObject.getInt("id"), localJSONObject.getInt("order")));
        i += 1;
      }
      catch (Exception paramJSONArray)
      {
        AppMethodBeat.o(225908);
        return null;
      }
    }
    Collections.sort(localArrayList);
    AppMethodBeat.o(225908);
    return localArrayList;
  }
  
  private void a(mk parammk)
  {
    AppMethodBeat.i(225915);
    if (parammk != null)
    {
      qm localqm = a(this.e);
      if (localqm != null) {
        parammk.i.b(localqm.a);
      }
    }
    AppMethodBeat.o(225915);
  }
  
  private void b()
  {
    AppMethodBeat.i(225888);
    this.c = new CopyOnWriteArrayList();
    String str = this.d.a("mapStyleList");
    Object localObject = str;
    if (str == null) {
      localObject = "[{\"id\":0,\"index\":0,\"order\":1},{\"id\":-1,\"index\":1,\"order\":-1},{\"id\":-1,\"index\":2,\"order\":-1},{\"id\":-1,\"index\":3,\"order\":-1},{\"id\":-1,\"index\":4,\"order\":-1},{\"id\":-1,\"index\":5,\"order\":-1},{\"id\":-1,\"index\":6,\"order\":-1},{\"id\":-1,\"index\":7,\"order\":-1},{\"id\":16,\"index\":8,\"order\":-1},{\"id\":9,\"index\":9,\"order\":-1},{\"id\":10,\"index\":10,\"order\":-1},{\"id\":5,\"index\":11,\"order\":-1},{\"id\":4,\"index\":12,\"order\":-1},{\"id\":6,\"index\":13,\"order\":-1},{\"id\":7,\"index\":14,\"order\":-1},{\"id\":8,\"index\":15,\"order\":-1}]";
    }
    try
    {
      localObject = new JSONArray((String)localObject);
      this.c.addAll(a((JSONArray)localObject));
      AppMethodBeat.o(225888);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(225888);
    }
  }
  
  private void b(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(225896);
    String str = this.d.a("mapStyleList");
    if (paramJSONArray != null)
    {
      List localList = a(paramJSONArray);
      if (localList != null)
      {
        this.c.clear();
        this.c.addAll(localList);
        if (!paramJSONArray.toString().equals(str))
        {
          this.d.a();
          this.d.a("mapStyleList", paramJSONArray.toString());
        }
      }
    }
    AppMethodBeat.o(225896);
  }
  
  public final qm a(int paramInt)
  {
    AppMethodBeat.i(225934);
    if ((this.c == null) || (this.c.size() == 0) || (paramInt < 0) || (paramInt - 1000 >= this.c.size()))
    {
      AppMethodBeat.o(225934);
      return null;
    }
    this.e = paramInt;
    if (paramInt >= 1000)
    {
      localObject = (qm)this.c.get(paramInt - 1000);
      AppMethodBeat.o(225934);
      return localObject;
    }
    if ((paramInt > 8) && (paramInt < 989))
    {
      paramInt += 11;
      if (paramInt >= this.c.size())
      {
        AppMethodBeat.o(225934);
        return null;
      }
      localObject = (qm)this.c.get(paramInt);
      AppMethodBeat.o(225934);
      return localObject;
    }
    Object localObject = this.c.iterator();
    while (((Iterator)localObject).hasNext())
    {
      qm localqm = (qm)((Iterator)localObject).next();
      if (localqm.c == paramInt)
      {
        AppMethodBeat.o(225934);
        return localqm;
      }
    }
    localObject = (qm)this.c.get(0);
    AppMethodBeat.o(225934);
    return localObject;
  }
  
  public final String a()
  {
    AppMethodBeat.i(225924);
    if (this.c == null)
    {
      AppMethodBeat.o(225924);
      return null;
    }
    Object localObject = new StringBuilder(128);
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      qm localqm = (qm)localIterator.next();
      if (localqm.b != -1)
      {
        if (((StringBuilder)localObject).length() == 0)
        {
          ((StringBuilder)localObject).append(localqm.b);
        }
        else
        {
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(localqm.b);
        }
      }
      else if (((StringBuilder)localObject).length() == 0) {
        ((StringBuilder)localObject).append(0);
      } else {
        ((StringBuilder)localObject).append(",");
      }
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(225924);
    return localObject;
  }
  
  public final int b(int paramInt)
  {
    AppMethodBeat.i(225944);
    if ((this.c == null) || (this.c.size() == 0) || (paramInt < 0))
    {
      AppMethodBeat.o(225944);
      return paramInt;
    }
    if (((paramInt >= 8) && (paramInt <= 19)) || (this.e >= 1000))
    {
      AppMethodBeat.o(225944);
      return paramInt + 1000;
    }
    if ((paramInt > 19) && (paramInt < 1000))
    {
      AppMethodBeat.o(225944);
      return paramInt - 11;
    }
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      qm localqm = (qm)localIterator.next();
      if (paramInt == localqm.a)
      {
        if ((paramInt == 0) && (localqm.b == 0) && (this.e <= 0))
        {
          AppMethodBeat.o(225944);
          return 1000;
        }
        paramInt = localqm.c;
        AppMethodBeat.o(225944);
        return paramInt;
      }
    }
    AppMethodBeat.o(225944);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.qn
 * JD-Core Version:    0.7.0.1
 */