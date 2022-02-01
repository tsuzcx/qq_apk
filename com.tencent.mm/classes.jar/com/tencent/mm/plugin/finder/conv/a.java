package com.tencent.mm.plugin.finder.conv;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/conv/FinderConvReporter;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "Builder", "ReportItem", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a AFu;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(336043);
    AFu = new a();
    TAG = "FinderConvReporter";
    AppMethodBeat.o(336043);
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/conv/FinderConvReporter$Builder;", "", "()V", "currentThread", "", "getCurrentThread", "()Ljava/lang/String;", "setCurrentThread", "(Ljava/lang/String;)V", "duration", "", "getDuration", "()J", "setDuration", "(J)V", "source", "getSource", "setSource", "sql", "getSql", "setSql", "tableSize", "getTableSize", "setTableSize", "build", "Lcom/tencent/mm/plugin/finder/conv/FinderConvReporter$ReportItem;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private String AFv = "";
    public long AFw;
    public long duration;
    private String source = "";
    private String sql = "";
    
    public final a avf(String paramString)
    {
      AppMethodBeat.i(336114);
      s.u(paramString, "source");
      this.source = paramString;
      AppMethodBeat.o(336114);
      return this;
    }
    
    public final a avg(String paramString)
    {
      AppMethodBeat.i(336122);
      s.u(paramString, "sql");
      this.sql = n.a(paramString, ',', ';');
      AppMethodBeat.o(336122);
      return this;
    }
    
    public final a avh(String paramString)
    {
      AppMethodBeat.i(336129);
      s.u(paramString, "currentThread");
      this.AFv = paramString;
      AppMethodBeat.o(336129);
      return this;
    }
    
    public final a.b dWL()
    {
      AppMethodBeat.i(336135);
      a.b localb = new a.b(this.source, this.sql, this.duration, this.AFv, this.AFw);
      AppMethodBeat.o(336135);
      return localb;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/conv/FinderConvReporter$ReportItem;", "", "source", "", "sql", "duration", "", "currentThread", "tableSize", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;J)V", "getCurrentThread", "()Ljava/lang/String;", "getDuration", "()J", "getSource", "getSql", "getTableSize", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "report", "", "toString", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    private final String AFv;
    private final long AFw;
    private final long duration;
    private final String source;
    private final String sql;
    
    public b(String paramString1, String paramString2, long paramLong1, String paramString3, long paramLong2)
    {
      AppMethodBeat.i(336119);
      this.source = paramString1;
      this.sql = paramString2;
      this.duration = paramLong1;
      this.AFv = paramString3;
      this.AFw = paramLong2;
      AppMethodBeat.o(336119);
    }
    
    private static final void a(b paramb)
    {
      AppMethodBeat.i(336134);
      s.u(paramb, "this$0");
      a locala = a.AFu;
      Log.d(a.getTAG(), paramb.toString());
      com.tencent.mm.plugin.report.service.h.OAn.b(23049, new Object[] { paramb.source, paramb.sql, Long.valueOf(paramb.duration), paramb.AFv, Long.valueOf(paramb.AFw) });
      AppMethodBeat.o(336134);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(336176);
      if (this == paramObject)
      {
        AppMethodBeat.o(336176);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(336176);
        return false;
      }
      paramObject = (b)paramObject;
      if (!s.p(this.source, paramObject.source))
      {
        AppMethodBeat.o(336176);
        return false;
      }
      if (!s.p(this.sql, paramObject.sql))
      {
        AppMethodBeat.o(336176);
        return false;
      }
      if (this.duration != paramObject.duration)
      {
        AppMethodBeat.o(336176);
        return false;
      }
      if (!s.p(this.AFv, paramObject.AFv))
      {
        AppMethodBeat.o(336176);
        return false;
      }
      if (this.AFw != paramObject.AFw)
      {
        AppMethodBeat.o(336176);
        return false;
      }
      AppMethodBeat.o(336176);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(336168);
      int i = this.source.hashCode();
      int j = this.sql.hashCode();
      int k = q.a..ExternalSyntheticBackport0.m(this.duration);
      int m = this.AFv.hashCode();
      int n = q.a..ExternalSyntheticBackport0.m(this.AFw);
      AppMethodBeat.o(336168);
      return (((i * 31 + j) * 31 + k) * 31 + m) * 31 + n;
    }
    
    public final void report()
    {
      AppMethodBeat.i(336153);
      if ((this.duration < 16L) && (!n.a((CharSequence)this.source, (CharSequence)"reportSize", true)) && (!n.a((CharSequence)this.source, (CharSequence)"enterFinderConversationPage", true)))
      {
        AppMethodBeat.o(336153);
        return;
      }
      com.tencent.threadpool.h.ahAA.bo(new a.b..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(336153);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(336163);
      String str = "source:" + this.source + ", sql:" + this.sql + ", duration:" + this.duration + ", currentThread:" + this.AFv + ", tableSize:" + this.AFw;
      AppMethodBeat.o(336163);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.a
 * JD-Core Version:    0.7.0.1
 */