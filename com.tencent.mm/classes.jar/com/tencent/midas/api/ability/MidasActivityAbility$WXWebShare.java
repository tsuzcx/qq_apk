package com.tencent.midas.api.ability;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MidasActivityAbility$WXWebShare
  extends MidasActivityAbility.AbsWXShare
{
  public void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(253527);
    super.fromBundle(paramBundle);
    AppMethodBeat.o(253527);
  }
  
  public Bundle toBundle()
  {
    AppMethodBeat.i(253525);
    Bundle localBundle = super.toBundle();
    AppMethodBeat.o(253525);
    return localBundle;
  }
  
  public String toString()
  {
    AppMethodBeat.i(253529);
    String str = super.toString();
    AppMethodBeat.o(253529);
    return str;
  }
  
  public int type()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.midas.api.ability.MidasActivityAbility.WXWebShare
 * JD-Core Version:    0.7.0.1
 */