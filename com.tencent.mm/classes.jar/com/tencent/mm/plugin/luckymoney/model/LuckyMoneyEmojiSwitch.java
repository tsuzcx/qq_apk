package com.tencent.mm.plugin.luckymoney.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public class LuckyMoneyEmojiSwitch
  implements Parcelable
{
  public static final Parcelable.Creator<LuckyMoneyEmojiSwitch> CREATOR;
  public int ulX;
  public int ulY;
  public int ulZ;
  public int uma;
  
  static
  {
    AppMethodBeat.i(65189);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(65189);
  }
  
  public LuckyMoneyEmojiSwitch()
  {
    this.ulX = 0;
    this.ulY = 0;
    this.ulZ = 0;
    this.uma = 0;
  }
  
  protected LuckyMoneyEmojiSwitch(Parcel paramParcel)
  {
    AppMethodBeat.i(65187);
    this.ulX = 0;
    this.ulY = 0;
    this.ulZ = 0;
    this.uma = 0;
    this.ulX = paramParcel.readInt();
    this.ulY = paramParcel.readInt();
    this.ulZ = paramParcel.readInt();
    this.uma = paramParcel.readInt();
    AppMethodBeat.o(65187);
  }
  
  public static LuckyMoneyEmojiSwitch at(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65185);
    LuckyMoneyEmojiSwitch localLuckyMoneyEmojiSwitch = new LuckyMoneyEmojiSwitch();
    localLuckyMoneyEmojiSwitch.ulX = paramJSONObject.optInt("showOpenNormalExpression", 0);
    localLuckyMoneyEmojiSwitch.ulY = paramJSONObject.optInt("showDetailNormalExpression", 0);
    localLuckyMoneyEmojiSwitch.ulZ = paramJSONObject.optInt("enableAnswerByExpression", 0);
    localLuckyMoneyEmojiSwitch.uma = paramJSONObject.optInt("enableAnswerBySelfie", 0);
    AppMethodBeat.o(65185);
    return localLuckyMoneyEmojiSwitch;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(65188);
    String str = "LuckyMoneyEmojiSwitch{showOpenNormalExpression=" + this.ulX + ", showDetailNormalExpression=" + this.ulY + ", enalbeAnswerByExpression=" + this.ulZ + ", enableAnswerBySelfie=" + this.uma + '}';
    AppMethodBeat.o(65188);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(65186);
    paramParcel.writeInt(this.ulX);
    paramParcel.writeInt(this.ulY);
    paramParcel.writeInt(this.ulZ);
    paramParcel.writeInt(this.uma);
    AppMethodBeat.o(65186);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.LuckyMoneyEmojiSwitch
 * JD-Core Version:    0.7.0.1
 */