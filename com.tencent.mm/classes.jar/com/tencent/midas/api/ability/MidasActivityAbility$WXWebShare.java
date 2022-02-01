package com.tencent.midas.api.ability;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MidasActivityAbility$WXWebShare
  extends MidasActivityAbility.AbsWXShare
{
  public void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(217429);
    super.fromBundle(paramBundle);
    AppMethodBeat.o(217429);
  }
  
  public Bundle toBundle()
  {
    AppMethodBeat.i(217419);
    Bundle localBundle = super.toBundle();
    AppMethodBeat.o(217419);
    return localBundle;
  }
  
  public String toString()
  {
    AppMethodBeat.i(217441);
    String str = super.toString();
    AppMethodBeat.o(217441);
    return str;
  }
  
  public int type()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.midas.api.ability.MidasActivityAbility.WXWebShare
 * JD-Core Version:    0.7.0.1
 */