package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.sdk.b.b;

public final class kh
  extends b
{
  public a doE;
  public b doF;
  
  public kh()
  {
    this((byte)0);
  }
  
  private kh(byte paramByte)
  {
    AppMethodBeat.i(149868);
    this.doE = new a();
    this.doF = new b();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(149868);
  }
  
  public static final class a
  {
    public String appId;
    public Context context;
    public int dcz;
    public Bundle deG;
    public WXMediaMessage doG;
    public am doH;
  }
  
  public static final class b
  {
    public boolean doI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.kh
 * JD-Core Version:    0.7.0.1
 */