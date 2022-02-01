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
    AppMethodBeat.i(217431);
    super.fromBundle(paramBundle);
    this.withShareTicket = paramBundle.getBoolean("__midas_ability_activity__" + WXMiniProgramShare.class.getSimpleName() + "_withShareTicket");
    this.miniprogramType = paramBundle.getInt("__midas_ability_activity__" + WXMiniProgramShare.class.getSimpleName() + "_miniprogramType");
    AppMethodBeat.o(217431);
  }
  
  public Bundle toBundle()
  {
    AppMethodBeat.i(217424);
    Bundle localBundle = super.toBundle();
    localBundle.putBoolean("__midas_ability_activity__" + WXMiniProgramShare.class.getSimpleName() + "_withShareTicket", this.withShareTicket);
    localBundle.putInt("__midas_ability_activity__" + WXMiniProgramShare.class.getSimpleName() + "_miniprogramType", this.miniprogramType);
    AppMethodBeat.o(217424);
    return localBundle;
  }
  
  public String toString()
  {
    AppMethodBeat.i(217438);
    String str = super.toString() + "|withShareTicket=" + this.withShareTicket + "|miniprogramType=" + this.miniprogramType;
    AppMethodBeat.o(217438);
    return str;
  }
  
  public int type()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.midas.api.ability.MidasActivityAbility.WXMiniProgramShare
 * JD-Core Version:    0.7.0.1
 */