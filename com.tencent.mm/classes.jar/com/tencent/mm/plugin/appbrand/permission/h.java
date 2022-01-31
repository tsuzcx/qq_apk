package com.tencent.mm.plugin.appbrand.permission;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;

public class h
  implements f
{
  protected final i gRG;
  
  public h(i parami)
  {
    this.gRG = parami;
  }
  
  public void Ez(String paramString)
  {
    AppMethodBeat.i(102303);
    Toast.makeText(this.gRG.getContext(), String.format("jsapi banned %s", new Object[] { paramString }), 0).show();
    AppMethodBeat.o(102303);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.h
 * JD-Core Version:    0.7.0.1
 */