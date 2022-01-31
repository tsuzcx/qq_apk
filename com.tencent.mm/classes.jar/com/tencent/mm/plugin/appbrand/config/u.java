package com.tencent.mm.plugin.appbrand.config;

import android.util.Pair;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Iterator;
import java.util.List;

public final class u
{
  public String appId;
  public int bFB;
  public String efZ;
  public int fPB;
  public List<WxaAttributes.WxaEntryInfo> fQZ;
  private String fRA = null;
  public List<Pair<String, String>> fRl;
  public String fRz;
  public String nickname;
  public String signature;
  public String username;
  
  public final String aet()
  {
    if ((bk.bl(this.fRA)) && (!bk.dk(this.fRl)))
    {
      Object localObject2 = new StringBuilder();
      Iterator localIterator = this.fRl.iterator();
      label110:
      while (localIterator.hasNext())
      {
        localObject1 = (Pair)localIterator.next();
        if (bk.bl((String)((Pair)localObject1).second)) {}
        for (localObject1 = (String)((Pair)localObject1).first;; localObject1 = (String)((Pair)localObject1).second)
        {
          if (bk.bl((String)localObject1)) {
            break label110;
          }
          ((StringBuilder)localObject2).append("、");
          ((StringBuilder)localObject2).append((String)localObject1);
          break;
        }
      }
      localObject2 = ((StringBuilder)localObject2).toString();
      Object localObject1 = localObject2;
      if (!bk.bl((String)localObject2)) {
        localObject1 = ((String)localObject2).replaceFirst("、", "");
      }
      this.fRA = ((String)localObject1);
    }
    return bk.pm(this.fRA);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.u
 * JD-Core Version:    0.7.0.1
 */