package com.tencent.mm.plugin.game.ui.chat_tab;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.protobuf.ec;
import org.json.JSONObject;

public class GameTabData2$TabItem
  implements Parcelable
{
  public static final Parcelable.Creator<TabItem> CREATOR;
  public int dLS;
  public String iconUrl;
  public String iyd;
  public String jumpUrl;
  public int position;
  public String title;
  public String xHB;
  public String xHI;
  public String xXc;
  public String xXd;
  public String xXe;
  public String xXf;
  public String xXg;
  public String xXh;
  public GameTabData2.TabItemWeapp xXi;
  public GameTabData2.TabItemReport xXj;
  public boolean xXk;
  public int xXl;
  public int xXm;
  
  static
  {
    AppMethodBeat.i(204218);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(204218);
  }
  
  private GameTabData2$TabItem(Parcel paramParcel)
  {
    AppMethodBeat.i(204216);
    this.xHB = paramParcel.readString();
    this.title = paramParcel.readString();
    this.iyd = paramParcel.readString();
    this.xXc = paramParcel.readString();
    this.xXd = paramParcel.readString();
    this.xXe = paramParcel.readString();
    this.iconUrl = paramParcel.readString();
    this.xXf = paramParcel.readString();
    this.xXg = paramParcel.readString();
    this.xXh = paramParcel.readString();
    this.dLS = paramParcel.readInt();
    this.jumpUrl = paramParcel.readString();
    this.xXi = ((GameTabData2.TabItemWeapp)paramParcel.readParcelable(GameTabData2.TabItemWeapp.class.getClassLoader()));
    this.xXj = ((GameTabData2.TabItemReport)paramParcel.readParcelable(GameTabData2.TabItemReport.class.getClassLoader()));
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.xXk = bool;
      this.xXl = paramParcel.readInt();
      this.xHI = paramParcel.readString();
      this.position = paramParcel.readInt();
      AppMethodBeat.o(204216);
      return;
    }
  }
  
  public GameTabData2$TabItem(ec paramec)
  {
    AppMethodBeat.i(204213);
    if (paramec == null)
    {
      AppMethodBeat.o(204213);
      return;
    }
    this.xHB = paramec.xMX;
    this.title = paramec.Title;
    this.iyd = paramec.xNv;
    this.xXc = paramec.xNw;
    this.xXd = paramec.xNx;
    this.xXe = paramec.xNy;
    this.iconUrl = paramec.IconUrl;
    this.xXf = paramec.xNz;
    this.xXg = paramec.xJd;
    this.xXh = paramec.xNA;
    this.dLS = paramec.oUv;
    this.jumpUrl = paramec.xIy;
    this.xXi = new GameTabData2.TabItemWeapp(paramec.xNB);
    this.xXj = new GameTabData2.TabItemReport(paramec.xNC);
    this.xXk = paramec.xND;
    this.xXl = paramec.xNE;
    dWD();
    AppMethodBeat.o(204213);
  }
  
  public GameTabData2$TabItem(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(204214);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(204214);
      return;
    }
    this.xHB = paramJSONObject.optString("Key");
    this.title = paramJSONObject.optString("Title");
    this.iconUrl = paramJSONObject.optString("IconUrl");
    this.xXf = paramJSONObject.optString("SelectedIconUrl");
    this.xXg = paramJSONObject.optString("DarkModeIconUrl");
    this.xXh = paramJSONObject.optString("DarkModeSelectedIconUrl");
    this.dLS = paramJSONObject.optInt("Type");
    this.jumpUrl = paramJSONObject.optString("JumpUrl");
    this.xXi = new GameTabData2.TabItemWeapp(paramJSONObject.optJSONObject("JumpWeapp"));
    this.xXj = new GameTabData2.TabItemReport(paramJSONObject.optJSONObject("Report"));
    this.xXk = false;
    this.xXl = 2;
    dWD();
    AppMethodBeat.o(204214);
  }
  
  private void dWD()
  {
    AppMethodBeat.i(204215);
    switch (this.dLS)
    {
    default: 
      this.xHI = "";
      AppMethodBeat.o(204215);
      return;
    case 1: 
      this.xHI = GameChatTabUI.class.getName();
      AppMethodBeat.o(204215);
      return;
    }
    this.xHI = GameWebTabUI.class.getName();
    AppMethodBeat.o(204215);
  }
  
  public final boolean dWC()
  {
    return this.dLS == 1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(204217);
    paramParcel.writeString(this.xHB);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.iyd);
    paramParcel.writeString(this.xXc);
    paramParcel.writeString(this.xXd);
    paramParcel.writeString(this.xXe);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeString(this.xXf);
    paramParcel.writeString(this.xXg);
    paramParcel.writeString(this.xXh);
    paramParcel.writeInt(this.dLS);
    paramParcel.writeString(this.jumpUrl);
    paramParcel.writeParcelable(this.xXi, paramInt);
    paramParcel.writeParcelable(this.xXj, paramInt);
    if (this.xXk) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.xXl);
      paramParcel.writeString(this.xHI);
      paramParcel.writeInt(this.position);
      AppMethodBeat.o(204217);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.chat_tab.GameTabData2.TabItem
 * JD-Core Version:    0.7.0.1
 */