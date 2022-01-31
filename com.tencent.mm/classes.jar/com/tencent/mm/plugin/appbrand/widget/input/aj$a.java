package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.drawable.Drawable;
import com.tencent.mm.cd.e;
import com.tencent.mm.sdk.platformtools.ae;

final class aj$a
  extends e
{
  private String[] hwm = null;
  
  aj$a()
  {
    super(new aj.c(ae.getContext()));
  }
  
  public final int asv()
  {
    return 0;
  }
  
  public final int asw()
  {
    if (this.hwm != null) {
      return this.hwm.length;
    }
    return 0;
  }
  
  public final String getText(int paramInt)
  {
    return mX(paramInt);
  }
  
  public final Drawable mW(int paramInt)
  {
    return new aj.b(mX(paramInt), aj.access$000(), (byte)0);
  }
  
  public final String mX(int paramInt)
  {
    if ((this.hwm == null) || (paramInt < 0) || (paramInt > this.hwm.length - 1)) {
      return "";
    }
    Object localObject = this.hwm[paramInt].split(" ");
    char[] arrayOfChar = Character.toChars(Integer.decode(localObject[0]).intValue());
    localObject = Character.toChars(Integer.decode(localObject[1]).intValue());
    return arrayOfChar + (char[])localObject;
  }
  
  public final String mY(int paramInt)
  {
    return mX(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.aj.a
 * JD-Core Version:    0.7.0.1
 */