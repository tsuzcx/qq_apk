package com.tencent.mm.ce;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
{
  public static int aiQ(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return 400;
    case 0: 
      return 440;
    case 2: 
    case 3: 
      return 360;
    }
    return 340;
  }
  
  public static void ats(int paramInt)
  {
    AppMethodBeat.i(233058);
    float f = axT(paramInt);
    com.tencent.mm.cd.a.i(MMApplicationContext.getContext(), f);
    Log.i("MicroMsg.FontUtil", "setFontSize currentIndex:%s, currentFont:%s ", new Object[] { Integer.valueOf(paramInt), Float.valueOf(f) });
    MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putFloat("current_text_size_scale_key", f);
    MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putInt("current_text_size_index_key", paramInt);
    c.axV(aiQ(paramInt));
    AppMethodBeat.o(233058);
  }
  
  public static float axT(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return 1.0F;
    case 0: 
      return 0.8F;
    case 2: 
      return 1.1F;
    case 3: 
      return 1.12F;
    case 4: 
      return 1.125F;
    case 5: 
      return 1.4F;
    case 6: 
      return 1.55F;
    }
    return 1.65F;
  }
  
  public static int dH(float paramFloat)
  {
    AppMethodBeat.i(233083);
    float f;
    if (paramFloat >= com.tencent.mm.cd.a.mc(MMApplicationContext.getContext()))
    {
      f = paramFloat;
      if (paramFloat <= com.tencent.mm.cd.a.mj(MMApplicationContext.getContext())) {}
    }
    else
    {
      f = com.tencent.mm.cd.a.mc(MMApplicationContext.getContext());
    }
    int i;
    if (com.tencent.mm.cd.a.bc(f, com.tencent.mm.cd.a.mc(MMApplicationContext.getContext()))) {
      i = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(233083);
      return i;
      if (com.tencent.mm.cd.a.bc(f, com.tencent.mm.cd.a.me(MMApplicationContext.getContext()))) {
        i = 2;
      } else if (com.tencent.mm.cd.a.bc(f, com.tencent.mm.cd.a.mf(MMApplicationContext.getContext()))) {
        i = 3;
      } else if (com.tencent.mm.cd.a.bc(f, com.tencent.mm.cd.a.mg(MMApplicationContext.getContext()))) {
        i = 4;
      } else if (com.tencent.mm.cd.a.bc(f, com.tencent.mm.cd.a.mh(MMApplicationContext.getContext()))) {
        i = 5;
      } else if (com.tencent.mm.cd.a.bc(f, com.tencent.mm.cd.a.mi(MMApplicationContext.getContext()))) {
        i = 6;
      } else if (com.tencent.mm.cd.a.bc(f, com.tencent.mm.cd.a.mj(MMApplicationContext.getContext()))) {
        i = 7;
      } else {
        i = 1;
      }
    }
  }
  
  public static int mu(Context paramContext)
  {
    int i = 1;
    AppMethodBeat.i(233097);
    if (paramContext != null) {
      i = paramContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getInt("before_care_mode_text_size_index_key", 1);
    }
    AppMethodBeat.o(233097);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ce.a
 * JD-Core Version:    0.7.0.1
 */