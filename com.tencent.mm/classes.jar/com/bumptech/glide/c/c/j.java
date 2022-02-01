package com.bumptech.glide.c.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class j
  implements h
{
  private volatile Map<String, String> aHy;
  private final Map<String, List<i>> headers;
  
  j(Map<String, List<i>> paramMap)
  {
    AppMethodBeat.i(77249);
    this.headers = Collections.unmodifiableMap(paramMap);
    AppMethodBeat.o(77249);
  }
  
  private static String r(List<i> paramList)
  {
    AppMethodBeat.i(77251);
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      String str = ((i)paramList.get(i)).oL();
      if (!TextUtils.isEmpty(str))
      {
        localStringBuilder.append(str);
        if (i != paramList.size() - 1) {
          localStringBuilder.append(',');
        }
      }
      i += 1;
    }
    paramList = localStringBuilder.toString();
    AppMethodBeat.o(77251);
    return paramList;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(77253);
    if ((paramObject instanceof j))
    {
      paramObject = (j)paramObject;
      boolean bool = this.headers.equals(paramObject.headers);
      AppMethodBeat.o(77253);
      return bool;
    }
    AppMethodBeat.o(77253);
    return false;
  }
  
  public final Map<String, String> getHeaders()
  {
    AppMethodBeat.i(77250);
    if (this.aHy == null) {
      try
      {
        if (this.aHy == null)
        {
          HashMap localHashMap = new HashMap();
          Iterator localIterator = this.headers.entrySet().iterator();
          while (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            String str = r((List)localEntry.getValue());
            if (!TextUtils.isEmpty(str)) {
              localHashMap.put(localEntry.getKey(), str);
            }
          }
          this.aHy = Collections.unmodifiableMap(localMap1);
        }
      }
      finally
      {
        AppMethodBeat.o(77250);
      }
    }
    Map localMap2 = this.aHy;
    AppMethodBeat.o(77250);
    return localMap2;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(77254);
    int i = this.headers.hashCode();
    AppMethodBeat.o(77254);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(77252);
    String str = "LazyHeaders{headers=" + this.headers + '}';
    AppMethodBeat.o(77252);
    return str;
  }
  
  public static final class a
  {
    private static final Map<String, List<i>> aHA;
    private static final String aHz;
    boolean aHB = true;
    private boolean aHC = true;
    Map<String, List<i>> headers = aHA;
    
    static
    {
      AppMethodBeat.i(77245);
      Object localObject = System.getProperty("http.agent");
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
      for (;;)
      {
        aHz = (String)localObject;
        localObject = new HashMap(2);
        if (!TextUtils.isEmpty(aHz)) {
          ((Map)localObject).put("User-Agent", Collections.singletonList(new j.b(aHz)));
        }
        aHA = Collections.unmodifiableMap((Map)localObject);
        AppMethodBeat.o(77245);
        return;
        int j = ((String)localObject).length();
        StringBuilder localStringBuilder = new StringBuilder(((String)localObject).length());
        int i = 0;
        if (i < j)
        {
          char c = ((String)localObject).charAt(i);
          if (((c > '\037') || (c == '\t')) && (c < '')) {
            localStringBuilder.append(c);
          }
          for (;;)
          {
            i += 1;
            break;
            localStringBuilder.append('?');
          }
        }
        localObject = localStringBuilder.toString();
      }
    }
  }
  
  static final class b
    implements i
  {
    private final String value;
    
    b(String paramString)
    {
      this.value = paramString;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(77247);
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        boolean bool = this.value.equals(paramObject.value);
        AppMethodBeat.o(77247);
        return bool;
      }
      AppMethodBeat.o(77247);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(77248);
      int i = this.value.hashCode();
      AppMethodBeat.o(77248);
      return i;
    }
    
    public final String oL()
    {
      return this.value;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(77246);
      String str = "StringHeaderFactory{value='" + this.value + '\'' + '}';
      AppMethodBeat.o(77246);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.bumptech.glide.c.c.j
 * JD-Core Version:    0.7.0.1
 */