package com.tencent.mm.d.a;

import com.eclipsesource.v8.MultiContextV8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class v
  extends a
{
  private MultiContextV8 cba;
  
  v(String paramString, byte[] paramArrayOfByte)
  {
    super(paramString, paramArrayOfByte);
  }
  
  static v Cw()
  {
    AppMethodBeat.i(113900);
    v localv = new v(null, null);
    AppMethodBeat.o(113900);
    return localv;
  }
  
  static v k(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(113901);
    paramString = new v(paramString, paramArrayOfByte);
    AppMethodBeat.o(113901);
    return paramString;
  }
  
  final MultiContextV8 Ch()
  {
    AppMethodBeat.i(113902);
    this.cba = MultiContextV8.createMultiContextV8(this.cbg, this.cbh);
    this.cbh = null;
    MultiContextV8 localMultiContextV8 = this.cba;
    AppMethodBeat.o(113902);
    return localMultiContextV8;
  }
  
  d Ci()
  {
    AppMethodBeat.i(113903);
    w localw = w.Cx();
    AppMethodBeat.o(113903);
    return localw;
  }
  
  final void Cj()
  {
    AppMethodBeat.i(113904);
    try
    {
      this.cba.release();
      AppMethodBeat.o(113904);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.V8JSRuntime", "commonCleanUp exp = %s", new Object[] { localException });
      AppMethodBeat.o(113904);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.d.a.v
 * JD-Core Version:    0.7.0.1
 */