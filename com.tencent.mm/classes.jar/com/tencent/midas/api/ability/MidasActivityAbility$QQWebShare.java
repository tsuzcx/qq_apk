package com.tencent.midas.api.ability;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MidasActivityAbility$QQWebShare
  extends MidasActivityAbility.AbsQQShare
{
  public String appName;
  public String imageUrl;
  public String summary;
  public String title;
  
  public void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(253501);
    super.fromBundle(paramBundle);
    this.title = paramBundle.getString("__midas_ability_activity__" + QQWebShare.class.getSimpleName() + "_title");
    this.summary = paramBundle.getString("__midas_ability_activity__" + QQWebShare.class.getSimpleName() + "_summary");
    this.imageUrl = paramBundle.getString("__midas_ability_activity__" + QQWebShare.class.getSimpleName() + "_imageUrl");
    this.appName = paramBundle.getString("__midas_ability_activity__" + QQWebShare.class.getSimpleName() + "_appName");
    AppMethodBeat.o(253501);
  }
  
  public Bundle toBundle()
  {
    AppMethodBeat.i(253499);
    Bundle localBundle = super.toBundle();
    localBundle.putString("__midas_ability_activity__" + QQWebShare.class.getSimpleName() + "_title", this.title);
    localBundle.putString("__midas_ability_activity__" + QQWebShare.class.getSimpleName() + "_summary", this.summary);
    localBundle.putString("__midas_ability_activity__" + QQWebShare.class.getSimpleName() + "_imageUrl", this.imageUrl);
    localBundle.putString("__midas_ability_activity__" + QQWebShare.class.getSimpleName() + "_appName", this.appName);
    AppMethodBeat.o(253499);
    return localBundle;
  }
  
  public String toString()
  {
    AppMethodBeat.i(253502);
    String str = super.toString() + "|title=" + this.title + "|summary=" + this.summary + "|imageUrl=" + this.imageUrl + "|appName=" + this.appName;
    AppMethodBeat.o(253502);
    return str;
  }
  
  public int type()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.midas.api.ability.MidasActivityAbility.QQWebShare
 * JD-Core Version:    0.7.0.1
 */