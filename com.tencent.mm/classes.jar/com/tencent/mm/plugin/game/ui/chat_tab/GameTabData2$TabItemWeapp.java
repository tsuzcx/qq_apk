package com.tencent.mm.plugin.game.ui.chat_tab;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.protobuf.ea;
import org.json.JSONObject;

public class GameTabData2$TabItemWeapp
  implements Parcelable
{
  public static final Parcelable.Creator<TabItemWeapp> CREATOR;
  public String jfi;
  public String xut;
  
  static
  {
    AppMethodBeat.i(204230);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(204230);
  }
  
  private GameTabData2$TabItemWeapp(Parcel paramParcel)
  {
    AppMethodBeat.i(204228);
    this.jfi = paramParcel.readString();
    this.xut = paramParcel.readString();
    AppMethodBeat.o(204228);
  }
  
  public GameTabData2$TabItemWeapp(ea paramea)
  {
    AppMethodBeat.i(204226);
    if (paramea == null)
    {
      AppMethodBeat.o(204226);
      return;
    }
    this.jfi = paramea.jfi;
    this.xut = paramea.xut;
    AppMethodBeat.o(204226);
  }
  
  public GameTabData2$TabItemWeapp(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(204227);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(204227);
      return;
    }
    this.jfi = paramJSONObject.optString("AppId");
    this.xut = paramJSONObject.optString("Path");
    AppMethodBeat.o(204227);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(204229);
    paramParcel.writeString(this.jfi);
    paramParcel.writeString(this.xut);
    AppMethodBeat.o(204229);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.chat_tab.GameTabData2.TabItemWeapp
 * JD-Core Version:    0.7.0.1
 */