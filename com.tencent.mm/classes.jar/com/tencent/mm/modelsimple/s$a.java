package com.tencent.mm.modelsimple;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class s$a
{
  public String crs;
  public String cyA;
  public String fPF;
  public Bundle fPG;
  public int type;
  public String username;
  
  public final String toString()
  {
    AppMethodBeat.i(123440);
    String str = String.format("AuthBioInfo hash[%d], type[%d]. username[%s], ticket[%s], helpUrlp[%s], wording[%s], extra[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.type), this.username, bo.aqg(this.crs), this.fPF, this.cyA, this.fPG });
    AppMethodBeat.o(123440);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsimple.s.a
 * JD-Core Version:    0.7.0.1
 */