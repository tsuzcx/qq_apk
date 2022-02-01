package com.tencent.mm.plugin.expt.edge.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.edge.b;

public final class c
{
  public String dbPath;
  public String sql;
  public int zAd;
  public String zAf;
  public String zAh;
  public String zAi;
  public String zzS;
  public int zzX;
  
  public final String toString()
  {
    AppMethodBeat.i(299649);
    StringBuilder localStringBuilder = new StringBuilder("EdgeComputingSqlConfigModel{configID='").append(this.zzS).append('\'').append(", reportID=").append(this.zzX).append(", reportMethod=").append(this.zAd).append(", dbPath='");
    if (b.isDebugMode())
    {
      str = this.dbPath;
      localStringBuilder = localStringBuilder.append(str).append('\'').append(", sql='");
      if (!b.isDebugMode()) {
        break label207;
      }
      str = this.sql;
      label94:
      localStringBuilder = localStringBuilder.append(str).append('\'').append(", sqlURL='");
      if (!b.isDebugMode()) {
        break label213;
      }
      str = this.zAh;
      label121:
      localStringBuilder = localStringBuilder.append(str).append('\'').append(", sqlMD5='");
      if (!b.isDebugMode()) {
        break label219;
      }
      str = this.zAi;
      label148:
      localStringBuilder = localStringBuilder.append(str).append('\'').append(", originalJson='");
      if (!b.isDebugMode()) {
        break label225;
      }
    }
    label207:
    label213:
    label219:
    label225:
    for (String str = this.zAf;; str = "originalJson")
    {
      str = str + '\'' + '}';
      AppMethodBeat.o(299649);
      return str;
      str = "dbPath";
      break;
      str = "sql";
      break label94;
      str = "sqlURL";
      break label121;
      str = "sqlMD5";
      break label148;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.edge.e.a.c
 * JD-Core Version:    0.7.0.1
 */