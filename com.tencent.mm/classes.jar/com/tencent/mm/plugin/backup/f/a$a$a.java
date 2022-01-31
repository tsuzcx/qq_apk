package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

final class a$a$a
{
  boolean bRg;
  Map<String, String> jDs;
  
  public a$a$a(String paramString)
  {
    AppMethodBeat.i(17435);
    this.jDs = null;
    this.bRg = true;
    this.jDs = be.apC(paramString);
    if (this.jDs == null)
    {
      this.bRg = false;
      this.jDs = new HashMap();
    }
    AppMethodBeat.o(17435);
  }
  
  final int getInt(String paramString)
  {
    AppMethodBeat.i(17436);
    if (!this.jDs.containsKey(paramString))
    {
      AppMethodBeat.o(17436);
      return 0;
    }
    int i = bo.getInt((String)this.jDs.get(paramString), 0);
    AppMethodBeat.o(17436);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.a.a.a
 * JD-Core Version:    0.7.0.1
 */