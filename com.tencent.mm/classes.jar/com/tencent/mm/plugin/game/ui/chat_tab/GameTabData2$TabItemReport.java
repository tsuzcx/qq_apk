package com.tencent.mm.plugin.game.ui.chat_tab;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.protobuf.eb;
import org.json.JSONObject;

public class GameTabData2$TabItemReport
  implements Parcelable
{
  public static final Parcelable.Creator<TabItemReport> CREATOR;
  public String xEl;
  public int xHK;
  public int xXn;
  
  static
  {
    AppMethodBeat.i(204224);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(204224);
  }
  
  private GameTabData2$TabItemReport(Parcel paramParcel)
  {
    AppMethodBeat.i(204222);
    this.xXn = paramParcel.readInt();
    this.xHK = paramParcel.readInt();
    this.xEl = paramParcel.readString();
    AppMethodBeat.o(204222);
  }
  
  public GameTabData2$TabItemReport(eb parameb)
  {
    AppMethodBeat.i(204220);
    if (parameb == null)
    {
      AppMethodBeat.o(204220);
      return;
    }
    this.xXn = parameb.xNu;
    this.xHK = parameb.xJv;
    this.xEl = parameb.xJt;
    AppMethodBeat.o(204220);
  }
  
  public GameTabData2$TabItemReport(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(204221);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(204221);
      return;
    }
    this.xXn = paramJSONObject.optInt("AreaId");
    this.xHK = paramJSONObject.optInt("PositionId");
    this.xEl = paramJSONObject.optString("ExternInfo");
    AppMethodBeat.o(204221);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(204223);
    paramParcel.writeInt(this.xXn);
    paramParcel.writeInt(this.xHK);
    paramParcel.writeString(this.xEl);
    AppMethodBeat.o(204223);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.chat_tab.GameTabData2.TabItemReport
 * JD-Core Version:    0.7.0.1
 */