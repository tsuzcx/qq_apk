package com.google.android.material.internal;

import android.graphics.PorterDuff.Mode;
import android.view.View;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
{
  public static PorterDuff.Mode c(int paramInt, PorterDuff.Mode paramMode)
  {
    switch (paramInt)
    {
    case 4: 
    case 6: 
    case 7: 
    case 8: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    default: 
      return paramMode;
    case 3: 
      return PorterDuff.Mode.SRC_OVER;
    case 5: 
      return PorterDuff.Mode.SRC_IN;
    case 9: 
      return PorterDuff.Mode.SRC_ATOP;
    case 14: 
      return PorterDuff.Mode.MULTIPLY;
    case 15: 
      return PorterDuff.Mode.SCREEN;
    }
    return PorterDuff.Mode.ADD;
  }
  
  public static boolean s(View paramView)
  {
    AppMethodBeat.i(209287);
    if (z.U(paramView) == 1)
    {
      AppMethodBeat.o(209287);
      return true;
    }
    AppMethodBeat.o(209287);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.internal.l
 * JD-Core Version:    0.7.0.1
 */