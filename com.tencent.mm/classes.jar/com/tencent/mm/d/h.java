package com.tencent.mm.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class h
{
  public String heA;
  private Map<String, a> heB;
  public int versionCode;
  
  public h(String paramString, int paramInt)
  {
    AppMethodBeat.i(953);
    this.heB = new HashMap();
    if (paramString == null) {}
    for (this.heA = "http://dldir1.qq.com/weixin/android/";; this.heA = paramString)
    {
      this.versionCode = paramInt;
      AppMethodBeat.o(953);
      return;
    }
  }
  
  public static h ib(String paramString)
  {
    AppMethodBeat.i(957);
    Map localMap = f.Z(paramString, "patchupdate");
    if (localMap == null)
    {
      AppMethodBeat.o(957);
      return null;
    }
    h localh = new h((String)localMap.get(".patchupdate.$base"), i.ew((String)localMap.get(".patchupdate.$versioncode")));
    int k = i.ew((String)localMap.get(".patchupdate.$count"));
    int i = 0;
    if (i < k)
    {
      StringBuilder localStringBuilder = new StringBuilder(".patchupdate.item");
      if (i > 0)
      {
        paramString = Integer.valueOf(i);
        label106:
        paramString = paramString;
        paramString = new a((String)localMap.get(paramString + ".$old"), (String)localMap.get(paramString + ".$new"), (String)localMap.get(paramString + ".$patch"), (String)localMap.get(paramString + ".$url"), i.ew((String)localMap.get(paramString + ".$size")));
        if ((paramString.heC == null) || (paramString.heD == null) || (paramString.patchMd5 == null) || (paramString.url == null)) {
          break label335;
        }
      }
      label335:
      for (int j = 1;; j = 0)
      {
        if (j != 0) {
          localh.heB.put(paramString.heC, paramString);
        }
        i += 1;
        break;
        paramString = "";
        break label106;
      }
    }
    AppMethodBeat.o(957);
    return localh;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(954);
    this.heB.put(parama.heC, parama);
    AppMethodBeat.o(954);
  }
  
  public final String aBN()
  {
    AppMethodBeat.i(956);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(String.format("<patchupdate base=\"%s\" count=\"%d\" versioncode=\"%d\">", new Object[] { this.heA, Integer.valueOf(this.heB.size()), Integer.valueOf(this.versionCode) }));
    Iterator localIterator = this.heB.entrySet().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)((Map.Entry)localIterator.next()).getValue();
      ((StringBuilder)localObject).append(String.format("<item old=\"%s\" new=\"%s\" patch=\"%s\" url=\"%s\" size=\"%s\"></item>", new Object[] { locala.heC, locala.heD, locala.patchMd5, locala.url, Integer.valueOf(locala.size) }));
    }
    ((StringBuilder)localObject).append("</patchupdate>");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(956);
    return localObject;
  }
  
  public final a ia(String paramString)
  {
    AppMethodBeat.i(955);
    paramString = (a)this.heB.get(paramString);
    AppMethodBeat.o(955);
    return paramString;
  }
  
  public static final class a
  {
    String heC;
    public String heD;
    public String patchMd5;
    public int size;
    public String url;
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
    {
      this.heC = paramString1;
      this.heD = paramString2;
      this.patchMd5 = paramString3;
      this.size = paramInt;
      this.url = paramString4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.d.h
 * JD-Core Version:    0.7.0.1
 */