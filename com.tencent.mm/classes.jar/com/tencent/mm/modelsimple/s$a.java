package com.tencent.mm.modelsimple;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;

public final class s$a
{
  public String dpf;
  public String dxD;
  public String imd;
  public Bundle ime;
  public int type;
  public String username;
  
  public final String toString()
  {
    AppMethodBeat.i(134164);
    String str = String.format("AuthBioInfo hash[%d], type[%d]. username[%s], ticket[%s], helpUrlp[%s], wording[%s], extra[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.type), this.username, bt.aRp(this.dpf), this.imd, this.dxD, this.ime });
    AppMethodBeat.o(134164);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.s.a
 * JD-Core Version:    0.7.0.1
 */