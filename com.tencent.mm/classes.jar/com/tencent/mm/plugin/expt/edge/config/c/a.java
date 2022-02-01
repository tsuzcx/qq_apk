package com.tencent.mm.plugin.expt.edge.config.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.c.i;

public final class a
{
  public static int zzE = 1000;
  private static int zzF = 30000;
  private static int zzG = 10000;
  private static int zzH = 4;
  private static long zzI = 60000L;
  public Map<String, a> zzJ;
  
  public a()
  {
    AppMethodBeat.i(299795);
    Object localObject = ((c)h.ax(c.class)).a(c.a.zqf, "");
    if (!i.hm((String)localObject))
    {
      localObject = ((String)localObject).split(";");
      if ((localObject.length > 0) && (!i.hm(localObject[0]))) {
        zzE = Util.getInt(localObject[0], 0);
      }
      if ((localObject.length > 1) && (!i.hm(localObject[1]))) {
        zzG = Util.getInt(localObject[1], 0);
      }
      if ((localObject.length > 2) && (!i.hm(localObject[2]))) {
        zzF = Util.getInt(localObject[2], 0);
      }
      if ((localObject.length > 3) && (!i.hm(localObject[3]))) {
        zzH = Util.getInt(localObject[3], 0);
      }
      if ((localObject.length > 4) && (!i.hm(localObject[4]))) {
        zzI = Util.getInt(localObject[4], 0);
      }
    }
    this.zzJ = new HashMap();
    AppMethodBeat.o(299795);
  }
  
  public static int dIp()
  {
    return zzF;
  }
  
  public static int dIq()
  {
    return zzG;
  }
  
  public static int dIr()
  {
    return zzH;
  }
  
  public static long dIs()
  {
    return zzI;
  }
  
  public final class a
  {
    public long zzK;
    public int zzL;
    
    public a(long paramLong)
    {
      this.zzK = paramLong;
      this.zzL = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.edge.config.c.a
 * JD-Core Version:    0.7.0.1
 */