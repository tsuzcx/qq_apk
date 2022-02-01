package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.IntersectionOverlay;

public final class nd
  extends mm<ne>
  implements mp, IntersectionOverlay
{
  nd(nc paramnc, ne paramne)
  {
    super(paramnc, paramne);
  }
  
  public final int e_()
  {
    AppMethodBeat.i(221375);
    int i = ((nc)this.c).a(this.b);
    AppMethodBeat.o(221375);
    return i;
  }
  
  public final void setBounds(Rect paramRect)
  {
    AppMethodBeat.i(221381);
    ((ne)this.d).setBounds(paramRect);
    a(this.d);
    AppMethodBeat.o(221381);
  }
  
  public final void setDarkMode(boolean paramBoolean)
  {
    AppMethodBeat.i(221410);
    ((ne)this.d).enableDarkMode(paramBoolean);
    a(this.d);
    AppMethodBeat.o(221410);
  }
  
  public final void setData(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(221389);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(221389);
      return;
    }
    ((ne)this.d).setData(paramArrayOfByte);
    a(this.d);
    AppMethodBeat.o(221389);
  }
  
  public final void setDistance(int paramInt)
  {
    AppMethodBeat.i(221405);
    ((ne)this.d).setDistance(paramInt);
    a(this.d);
    AppMethodBeat.o(221405);
  }
  
  public final void setVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(221397);
    ((ne)this.d).setVisibility(paramBoolean);
    a(this.d);
    AppMethodBeat.o(221397);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.nd
 * JD-Core Version:    0.7.0.1
 */