package com.tencent.mm.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public class a
  extends bd
{
  public static IAutoDBItem.MAutoDBInfo info;
  public static final String maX;
  
  static
  {
    AppMethodBeat.i(42762);
    info = bd.aJm();
    maX = null;
    AppMethodBeat.o(42762);
  }
  
  public a() {}
  
  public a(String paramString)
  {
    AppMethodBeat.i(42759);
    setUsername(paramString);
    AppMethodBeat.o(42759);
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final void rv(int paramInt)
  {
    AppMethodBeat.i(42760);
    int i = this.field_attrflag | paramInt;
    if ((this.field_attrflag >= 0) && (this.field_attrflag < 536870912) && ((i >= 536870912) || (i < 0)) && (this.field_username.contains("@")))
    {
      Log.i("Conversition", "wrong add attr flag: %s, %s, %s, %s", new Object[] { this.field_username, Integer.valueOf(this.field_attrflag), Integer.valueOf(paramInt), Util.getStack() });
      f.Ozc.b(20435, new Object[] { Integer.valueOf(2), Integer.valueOf(this.field_attrflag), Integer.valueOf(paramInt), this.field_username });
    }
    pK(this.field_attrflag | paramInt);
    AppMethodBeat.o(42760);
  }
  
  public final void rw(int paramInt)
  {
    AppMethodBeat.i(42761);
    pK(this.field_attrflag & (paramInt ^ 0xFFFFFFFF));
    AppMethodBeat.o(42761);
  }
  
  public final boolean rx(int paramInt)
  {
    return (this.field_attrflag & paramInt) != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.l.a
 * JD-Core Version:    0.7.0.1
 */