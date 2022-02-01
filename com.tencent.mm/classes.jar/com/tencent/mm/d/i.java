package com.tencent.mm.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class i
{
  public String cSr;
  private Map<String, a> cSs;
  public int versionCode;
  
  public i(String paramString, int paramInt)
  {
    AppMethodBeat.i(953);
    this.cSs = new HashMap();
    if (paramString == null) {}
    for (this.cSr = "http://dldir1.qq.com/weixin/android/";; this.cSr = paramString)
    {
      this.versionCode = paramInt;
      AppMethodBeat.o(953);
      return;
    }
  }
  
  public static i eY(String paramString)
  {
    AppMethodBeat.i(957);
    Map localMap = f.M(paramString, "patchupdate");
    if (localMap == null)
    {
      AppMethodBeat.o(957);
      return null;
    }
    i locali = new i((String)localMap.get(".patchupdate.$base"), j.eZ((String)localMap.get(".patchupdate.$versioncode")));
    int k = j.eZ((String)localMap.get(".patchupdate.$count"));
    int i = 0;
    if (i >= k)
    {
      AppMethodBeat.o(957);
      return locali;
    }
    StringBuilder localStringBuilder = new StringBuilder(".patchupdate.item");
    if (i > 0)
    {
      paramString = Integer.valueOf(i);
      label115:
      paramString = paramString;
      paramString = new a((String)localMap.get(paramString + ".$old"), (String)localMap.get(paramString + ".$new"), (String)localMap.get(paramString + ".$patch"), (String)localMap.get(paramString + ".$url"), j.eZ((String)localMap.get(paramString + ".$size")));
      if ((paramString.cSt == null) || (paramString.cSu == null) || (paramString.patchMd5 == null) || (paramString.url == null)) {
        break label344;
      }
    }
    label344:
    for (int j = 1;; j = 0)
    {
      if (j != 0) {
        locali.cSs.put(paramString.cSt, paramString);
      }
      i += 1;
      break;
      paramString = "";
      break label115;
    }
  }
  
  public final String Lt()
  {
    AppMethodBeat.i(956);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(String.format("<patchupdate base=\"%s\" count=\"%d\" versioncode=\"%d\">", new Object[] { this.cSr, Integer.valueOf(this.cSs.size()), Integer.valueOf(this.versionCode) }));
    Iterator localIterator = this.cSs.entrySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        ((StringBuilder)localObject).append("</patchupdate>");
        localObject = ((StringBuilder)localObject).toString();
        AppMethodBeat.o(956);
        return localObject;
      }
      a locala = (a)((Map.Entry)localIterator.next()).getValue();
      ((StringBuilder)localObject).append(String.format("<item old=\"%s\" new=\"%s\" patch=\"%s\" url=\"%s\" size=\"%s\"></item>", new Object[] { locala.cSt, locala.cSu, locala.patchMd5, locala.url, Integer.valueOf(locala.size) }));
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(954);
    this.cSs.put(parama.cSt, parama);
    AppMethodBeat.o(954);
  }
  
  public final a eX(String paramString)
  {
    AppMethodBeat.i(955);
    paramString = (a)this.cSs.get(paramString);
    AppMethodBeat.o(955);
    return paramString;
  }
  
  public static final class a
  {
    String cSt;
    public String cSu;
    public String patchMd5;
    public int size;
    public String url;
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
    {
      this.cSt = paramString1;
      this.cSu = paramString2;
      this.patchMd5 = paramString3;
      this.size = paramInt;
      this.url = paramString4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.d.i
 * JD-Core Version:    0.7.0.1
 */