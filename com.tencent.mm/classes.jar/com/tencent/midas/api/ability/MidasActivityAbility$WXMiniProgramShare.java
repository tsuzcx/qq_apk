package com.tencent.midas.api.ability;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MidasActivityAbility$WXMiniProgramShare
  extends MidasActivityAbility.AbsWXShare
{
  public int miniprogramType;
  public boolean withShareTicket;
  
  public void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(253512);
    super.fromBundle(paramBundle);
    this.withShareTicket = paramBundle.getBoolean("__midas_ability_activity__" + WXMiniProgramShare.class.getSimpleName() + "_withShareTicket");
    this.miniprogramType = paramBundle.getInt("__midas_ability_activity__" + WXMiniProgramShare.class.getSimpleName() + "_miniprogramType");
    AppMethodBeat.o(253512);
  }
  
  public Bundle toBundle()
  {
    AppMethodBeat.i(253509);
    Bundle localBundle = super.toBundle();
    localBundle.putBoolean("__midas_ability_activity__" + WXMiniProgramShare.class.getSimpleName() + "_withShareTicket", this.withShareTicket);
    localBundle.putInt("__midas_ability_activity__" + WXMiniProgramShare.class.getSimpleName() + "_miniprogramType", this.miniprogramType);
    AppMethodBeat.o(253509);
    return localBundle;
  }
  
  public String toString()
  {
    AppMethodBeat.i(253514);
    String str = super.toString() + "|withShareTicket=" + this.withShareTicket + "|miniprogramType=" + this.miniprogramType;
    AppMethodBeat.o(253514);
    return str;
  }
  
  public int type()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.midas.api.ability.MidasActivityAbility.WXMiniProgramShare
 * JD-Core Version:    0.7.0.1
 */