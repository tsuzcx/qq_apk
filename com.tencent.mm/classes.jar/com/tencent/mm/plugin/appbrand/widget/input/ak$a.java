package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.e;
import com.tencent.mm.sdk.platformtools.ah;

final class ak$a
  extends e
{
  private String[] joy;
  
  ak$a()
  {
    super(new ak.c(ah.getContext()));
    AppMethodBeat.i(134284);
    this.joy = null;
    this.joy = ah.getContext().getResources().getStringArray(2131755038);
    AppMethodBeat.o(134284);
  }
  
  public final int aRA()
  {
    if (this.joy != null) {
      return this.joy.length;
    }
    return 0;
  }
  
  public final int aRz()
  {
    return 0;
  }
  
  public final String getText(int paramInt)
  {
    AppMethodBeat.i(134287);
    String str = qB(paramInt);
    AppMethodBeat.o(134287);
    return str;
  }
  
  public final Drawable qA(int paramInt)
  {
    AppMethodBeat.i(134285);
    f.aQD();
    ak.b localb = new ak.b(qB(paramInt), ak.access$000(), (byte)0);
    AppMethodBeat.o(134285);
    return localb;
  }
  
  public final String qB(int paramInt)
  {
    AppMethodBeat.i(134286);
    if ((this.joy == null) || (paramInt < 0) || (paramInt > this.joy.length - 1))
    {
      AppMethodBeat.o(134286);
      return "";
    }
    Object localObject2 = this.joy[paramInt].split(" ");
    Object localObject1 = Character.toChars(Integer.decode(localObject2[0]).intValue());
    localObject2 = Character.toChars(Integer.decode(localObject2[1]).intValue());
    localObject1 = (char[])localObject1 + (char[])localObject2;
    AppMethodBeat.o(134286);
    return localObject1;
  }
  
  public final String qC(int paramInt)
  {
    AppMethodBeat.i(134288);
    String str = qB(paramInt);
    AppMethodBeat.o(134288);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.ak.a
 * JD-Core Version:    0.7.0.1
 */