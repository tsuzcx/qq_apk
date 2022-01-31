package com.tencent.mm.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class i
{
  public String bWJ;
  private Map<String, i.a> bWK;
  public int versionCode;
  
  public i(String paramString, int paramInt)
  {
    AppMethodBeat.i(125693);
    this.bWK = new HashMap();
    if (paramString == null) {}
    for (this.bWJ = "http://dldir1.qq.com/weixin/android/";; this.bWJ = paramString)
    {
      this.versionCode = paramInt;
      AppMethodBeat.o(125693);
      return;
    }
  }
  
  public static i dq(String paramString)
  {
    AppMethodBeat.i(125697);
    Map localMap = f.F(paramString, "patchupdate");
    if (localMap == null)
    {
      AppMethodBeat.o(125697);
      return null;
    }
    i locali = new i((String)localMap.get(".patchupdate.$base"), j.getInt((String)localMap.get(".patchupdate.$versioncode"), 0));
    int k = j.getInt((String)localMap.get(".patchupdate.$count"), 0);
    int i = 0;
    if (i >= k)
    {
      AppMethodBeat.o(125697);
      return locali;
    }
    StringBuilder localStringBuilder = new StringBuilder(".patchupdate.item");
    if (i > 0)
    {
      paramString = Integer.valueOf(i);
      label114:
      paramString = paramString;
      paramString = new i.a((String)localMap.get(paramString + ".$old"), (String)localMap.get(paramString + ".$new"), (String)localMap.get(paramString + ".$patch"), (String)localMap.get(paramString + ".$url"), j.getInt((String)localMap.get(paramString + ".$size"), 0));
      if ((paramString.bWL == null) || (paramString.bWM == null) || (paramString.bWN == null) || (paramString.url == null)) {
        break label344;
      }
    }
    label344:
    for (int j = 1;; j = 0)
    {
      if (j != 0) {
        locali.bWK.put(paramString.bWL, paramString);
      }
      i += 1;
      break;
      paramString = "";
      break label114;
    }
  }
  
  public final String AK()
  {
    AppMethodBeat.i(125696);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(String.format("<patchupdate base=\"%s\" count=\"%d\" versioncode=\"%d\">", new Object[] { this.bWJ, Integer.valueOf(this.bWK.size()), Integer.valueOf(this.versionCode) }));
    Iterator localIterator = this.bWK.entrySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        ((StringBuilder)localObject).append("</patchupdate>");
        localObject = ((StringBuilder)localObject).toString();
        AppMethodBeat.o(125696);
        return localObject;
      }
      i.a locala = (i.a)((Map.Entry)localIterator.next()).getValue();
      ((StringBuilder)localObject).append(String.format("<item old=\"%s\" new=\"%s\" patch=\"%s\" url=\"%s\" size=\"%s\"></item>", new Object[] { locala.bWL, locala.bWM, locala.bWN, locala.url, Integer.valueOf(locala.size) }));
    }
  }
  
  public final void a(i.a parama)
  {
    AppMethodBeat.i(125694);
    this.bWK.put(parama.bWL, parama);
    AppMethodBeat.o(125694);
  }
  
  public final i.a dp(String paramString)
  {
    AppMethodBeat.i(125695);
    paramString = (i.a)this.bWK.get(paramString);
    AppMethodBeat.o(125695);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.c.i
 * JD-Core Version:    0.7.0.1
 */