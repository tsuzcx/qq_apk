package com.tencent.mm.plugin.finder.conv;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/conv/FinderConvReporter;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "Builder", "ReportItem", "plugin-finder-base_release"})
public final class c
{
  private static final String TAG = "FinderConvReporter";
  public static final c xfY;
  
  static
  {
    AppMethodBeat.i(258085);
    xfY = new c();
    TAG = "FinderConvReporter";
    AppMethodBeat.o(258085);
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/conv/FinderConvReporter$Builder;", "", "()V", "currentThread", "", "getCurrentThread", "()Ljava/lang/String;", "setCurrentThread", "(Ljava/lang/String;)V", "duration", "", "getDuration", "()J", "setDuration", "(J)V", "source", "getSource", "setSource", "sql", "getSql", "setSql", "tableSize", "getTableSize", "setTableSize", "build", "Lcom/tencent/mm/plugin/finder/conv/FinderConvReporter$ReportItem;", "plugin-finder-base_release"})
  public static final class a
  {
    public long duration;
    private String source = "";
    private String sql = "";
    private String xfZ = "";
    public long xga;
    
    public final a aAW(String paramString)
    {
      AppMethodBeat.i(261946);
      p.k(paramString, "source");
      this.source = paramString;
      AppMethodBeat.o(261946);
      return this;
    }
    
    public final a aAX(String paramString)
    {
      AppMethodBeat.i(261948);
      p.k(paramString, "sql");
      this.sql = n.a(paramString, ',', ';');
      AppMethodBeat.o(261948);
      return this;
    }
    
    public final a aAY(String paramString)
    {
      AppMethodBeat.i(261950);
      p.k(paramString, "currentThread");
      this.xfZ = paramString;
      AppMethodBeat.o(261950);
      return this;
    }
    
    public final c.b dpk()
    {
      AppMethodBeat.i(261952);
      c.b localb = new c.b(this.source, this.sql, this.duration, this.xfZ, this.xga);
      AppMethodBeat.o(261952);
      return localb;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/conv/FinderConvReporter$ReportItem;", "", "source", "", "sql", "duration", "", "currentThread", "tableSize", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;J)V", "getCurrentThread", "()Ljava/lang/String;", "getDuration", "()J", "getSource", "getSql", "getTableSize", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "report", "", "toString", "plugin-finder-base_release"})
  public static final class b
  {
    final long duration;
    final String source;
    final String sql;
    final String xfZ;
    final long xga;
    
    public b(String paramString1, String paramString2, long paramLong1, String paramString3, long paramLong2)
    {
      AppMethodBeat.i(259143);
      this.source = paramString1;
      this.sql = paramString2;
      this.duration = paramLong1;
      this.xfZ = paramString3;
      this.xga = paramLong2;
      AppMethodBeat.o(259143);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(259146);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!p.h(this.source, paramObject.source)) || (!p.h(this.sql, paramObject.sql)) || (this.duration != paramObject.duration) || (!p.h(this.xfZ, paramObject.xfZ)) || (this.xga != paramObject.xga)) {}
        }
      }
      else
      {
        AppMethodBeat.o(259146);
        return true;
      }
      AppMethodBeat.o(259146);
      return false;
    }
    
    public final int hashCode()
    {
      int k = 0;
      AppMethodBeat.i(259144);
      String str = this.source;
      int i;
      if (str != null)
      {
        i = str.hashCode();
        str = this.sql;
        if (str == null) {
          break label126;
        }
      }
      label126:
      for (int j = str.hashCode();; j = 0)
      {
        long l = this.duration;
        int m = (int)(l ^ l >>> 32);
        str = this.xfZ;
        if (str != null) {
          k = str.hashCode();
        }
        l = this.xga;
        int n = (int)(l ^ l >>> 32);
        AppMethodBeat.o(259144);
        return (((j + i * 31) * 31 + m) * 31 + k) * 31 + n;
        i = 0;
        break;
      }
    }
    
    public final void report()
    {
      AppMethodBeat.i(259138);
      if ((this.duration < 16L) && (!n.a((CharSequence)this.source, (CharSequence)"reportSize", true)))
      {
        AppMethodBeat.o(259138);
        return;
      }
      com.tencent.e.h.ZvG.bg((Runnable)new a(this));
      AppMethodBeat.o(259138);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(259140);
      String str = "source:" + this.source + ", sql:" + this.sql + ", duration:" + this.duration + ", currentThread:" + this.xfZ + ", tableSize:" + this.xga;
      AppMethodBeat.o(259140);
      return str;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(c.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(259099);
        c localc = c.xfY;
        Log.d(c.getTAG(), this.xgb.toString());
        com.tencent.mm.plugin.report.service.h.IzE.a(23049, new Object[] { this.xgb.source, this.xgb.sql, Long.valueOf(this.xgb.duration), this.xgb.xfZ, Long.valueOf(this.xgb.xga) });
        AppMethodBeat.o(259099);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.c
 * JD-Core Version:    0.7.0.1
 */