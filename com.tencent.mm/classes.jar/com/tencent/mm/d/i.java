package com.tencent.mm.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class i
{
  public String cHn;
  private Map<String, a> cHo;
  public int versionCode;
  
  public i(String paramString, int paramInt)
  {
    AppMethodBeat.i(953);
    this.cHo = new HashMap();
    if (paramString == null) {}
    for (this.cHn = "http://dldir1.qq.com/weixin/android/";; this.cHn = paramString)
    {
      this.versionCode = paramInt;
      AppMethodBeat.o(953);
      return;
    }
  }
  
  public static i ed(String paramString)
  {
    AppMethodBeat.i(957);
    Map localMap = f.L(paramString, "patchupdate");
    if (localMap == null)
    {
      AppMethodBeat.o(957);
      return null;
    }
    i locali = new i((String)localMap.get(".patchupdate.$base"), j.ee((String)localMap.get(".patchupdate.$versioncode")));
    int k = j.ee((String)localMap.get(".patchupdate.$count"));
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
      paramString = new a((String)localMap.get(paramString + ".$old"), (String)localMap.get(paramString + ".$new"), (String)localMap.get(paramString + ".$patch"), (String)localMap.get(paramString + ".$url"), j.ee((String)localMap.get(paramString + ".$size")));
      if ((paramString.cHp == null) || (paramString.cHq == null) || (paramString.patchMd5 == null) || (paramString.url == null)) {
        break label344;
      }
    }
    label344:
    for (int j = 1;; j = 0)
    {
      if (j != 0) {
        locali.cHo.put(paramString.cHp, paramString);
      }
      i += 1;
      break;
      paramString = "";
      break label115;
    }
  }
  
  public final String JU()
  {
    AppMethodBeat.i(956);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(String.format("<patchupdate base=\"%s\" count=\"%d\" versioncode=\"%d\">", new Object[] { this.cHn, Integer.valueOf(this.cHo.size()), Integer.valueOf(this.versionCode) }));
    Iterator localIterator = this.cHo.entrySet().iterator();
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
      ((StringBuilder)localObject).append(String.format("<item old=\"%s\" new=\"%s\" patch=\"%s\" url=\"%s\" size=\"%s\"></item>", new Object[] { locala.cHp, locala.cHq, locala.patchMd5, locala.url, Integer.valueOf(locala.size) }));
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(954);
    this.cHo.put(parama.cHp, parama);
    AppMethodBeat.o(954);
  }
  
  public final a ec(String paramString)
  {
    AppMethodBeat.i(955);
    paramString = (a)this.cHo.get(paramString);
    AppMethodBeat.o(955);
    return paramString;
  }
  
  public static final class a
  {
    String cHp;
    public String cHq;
    public String patchMd5;
    public int size;
    public String url;
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
    {
      this.cHp = paramString1;
      this.cHq = paramString2;
      this.patchMd5 = paramString3;
      this.size = paramInt;
      this.url = paramString4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.d.i
 * JD-Core Version:    0.7.0.1
 */