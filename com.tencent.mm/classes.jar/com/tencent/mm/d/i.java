package com.tencent.mm.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class i
{
  public String bob;
  private Map<String, a> cKg;
  public int versionCode;
  
  public i(String paramString, int paramInt)
  {
    AppMethodBeat.i(953);
    this.cKg = new HashMap();
    if (paramString == null) {}
    for (this.bob = "http://dldir1.qq.com/weixin/android/";; this.bob = paramString)
    {
      this.versionCode = paramInt;
      AppMethodBeat.o(953);
      return;
    }
  }
  
  public static i eo(String paramString)
  {
    AppMethodBeat.i(957);
    Map localMap = f.K(paramString, "patchupdate");
    if (localMap == null)
    {
      AppMethodBeat.o(957);
      return null;
    }
    i locali = new i((String)localMap.get(".patchupdate.$base"), j.ep((String)localMap.get(".patchupdate.$versioncode")));
    int k = j.ep((String)localMap.get(".patchupdate.$count"));
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
      paramString = new a((String)localMap.get(paramString + ".$old"), (String)localMap.get(paramString + ".$new"), (String)localMap.get(paramString + ".$patch"), (String)localMap.get(paramString + ".$url"), j.ep((String)localMap.get(paramString + ".$size")));
      if ((paramString.cKh == null) || (paramString.cKi == null) || (paramString.patchMd5 == null) || (paramString.url == null)) {
        break label344;
      }
    }
    label344:
    for (int j = 1;; j = 0)
    {
      if (j != 0) {
        locali.cKg.put(paramString.cKh, paramString);
      }
      i += 1;
      break;
      paramString = "";
      break label115;
    }
  }
  
  public final String Kk()
  {
    AppMethodBeat.i(956);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(String.format("<patchupdate base=\"%s\" count=\"%d\" versioncode=\"%d\">", new Object[] { this.bob, Integer.valueOf(this.cKg.size()), Integer.valueOf(this.versionCode) }));
    Iterator localIterator = this.cKg.entrySet().iterator();
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
      ((StringBuilder)localObject).append(String.format("<item old=\"%s\" new=\"%s\" patch=\"%s\" url=\"%s\" size=\"%s\"></item>", new Object[] { locala.cKh, locala.cKi, locala.patchMd5, locala.url, Integer.valueOf(locala.size) }));
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(954);
    this.cKg.put(parama.cKh, parama);
    AppMethodBeat.o(954);
  }
  
  public final a en(String paramString)
  {
    AppMethodBeat.i(955);
    paramString = (a)this.cKg.get(paramString);
    AppMethodBeat.o(955);
    return paramString;
  }
  
  public static final class a
  {
    String cKh;
    public String cKi;
    public String patchMd5;
    public int size;
    public String url;
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
    {
      this.cKh = paramString1;
      this.cKi = paramString2;
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