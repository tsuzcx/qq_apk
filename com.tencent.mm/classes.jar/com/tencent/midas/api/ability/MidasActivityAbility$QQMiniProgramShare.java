package com.tencent.midas.api.ability;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MidasActivityAbility$QQMiniProgramShare
  extends MidasActivityAbility.AbsQQShare
{
  public String imageUrl;
  public String miniProgramType;
  public String summary;
  public String title;
  
  public void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(253536);
    super.fromBundle(paramBundle);
    this.title = paramBundle.getString("__midas_ability_activity__" + QQMiniProgramShare.class.getSimpleName() + "_title");
    this.summary = paramBundle.getString("__midas_ability_activity__" + QQMiniProgramShare.class.getSimpleName() + "_summary");
    this.imageUrl = paramBundle.getString("__midas_ability_activity__" + QQMiniProgramShare.class.getSimpleName() + "_imageUrl");
    this.miniProgramType = paramBundle.getString("__midas_ability_activity__" + QQMiniProgramShare.class.getSimpleName() + "_miniProgramType");
    AppMethodBeat.o(253536);
  }
  
  public Bundle toBundle()
  {
    AppMethodBeat.i(253535);
    Bundle localBundle = super.toBundle();
    localBundle.putString("__midas_ability_activity__" + QQMiniProgramShare.class.getSimpleName() + "_title", this.title);
    localBundle.putString("__midas_ability_activity__" + QQMiniProgramShare.class.getSimpleName() + "_summary", this.summary);
    localBundle.putString("__midas_ability_activity__" + QQMiniProgramShare.class.getSimpleName() + "_imageUrl", this.imageUrl);
    localBundle.putString("__midas_ability_activity__" + QQMiniProgramShare.class.getSimpleName() + "_miniProgramType", this.miniProgramType);
    AppMethodBeat.o(253535);
    return localBundle;
  }
  
  public String toString()
  {
    AppMethodBeat.i(253537);
    String str = super.toString() + "|title=" + this.title + "|summary=" + this.summary + "|imageUrl=" + this.imageUrl + "|miniProgramType=" + this.miniProgramType;
    AppMethodBeat.o(253537);
    return str;
  }
  
  public int type()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.midas.api.ability.MidasActivityAbility.QQMiniProgramShare
 * JD-Core Version:    0.7.0.1
 */