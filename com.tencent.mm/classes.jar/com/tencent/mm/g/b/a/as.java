package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class as
  extends a
{
  public long eqk;
  public int eql;
  public int eqm;
  private String eqn;
  private String eqo;
  private String eqp;
  
  public as()
  {
    this.eqn = "";
    this.eqo = "";
    this.eqp = "";
  }
  
  public as(String paramString)
  {
    AppMethodBeat.i(108282);
    this.eqn = "";
    this.eqo = "";
    this.eqp = "";
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 6) {
          break label138;
        }
        String[] arrayOfString = new String[6];
        Arrays.fill(arrayOfString, 0, 6, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label138:
    for (;;)
    {
      this.eqk = Util.getLong(paramString[0], 0L);
      this.eql = Util.getInt(paramString[1], 0);
      this.eqm = Util.getInt(paramString[2], 0);
      ix(paramString[3]);
      iy(paramString[4]);
      iz(paramString[5]);
      AppMethodBeat.o(108282);
      return;
    }
  }
  
  public final String abV()
  {
    AppMethodBeat.i(108286);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eqk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eql);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqp);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(108286);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(108287);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterTime:").append(this.eqk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.eql);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.eqm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pid:").append(this.eqn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("info:").append(this.eqo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("index:").append(this.eqp);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(108287);
    return localObject;
  }
  
  public final int getId()
  {
    return 18662;
  }
  
  public final as ix(String paramString)
  {
    AppMethodBeat.i(108283);
    this.eqn = x("pid", paramString, true);
    AppMethodBeat.o(108283);
    return this;
  }
  
  public final as iy(String paramString)
  {
    AppMethodBeat.i(108284);
    this.eqo = x("info", paramString, true);
    AppMethodBeat.o(108284);
    return this;
  }
  
  public final as iz(String paramString)
  {
    AppMethodBeat.i(108285);
    this.eqp = x("index", paramString, true);
    AppMethodBeat.o(108285);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.as
 * JD-Core Version:    0.7.0.1
 */