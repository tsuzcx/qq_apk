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
  public int onR;
  public int onS;
  public int onT;
  public int onU;
  
  static
  {
    AppMethodBeat.i(42299);
    CREATOR = new LuckyMoneyEmojiSwitch.1();
    AppMethodBeat.o(42299);
  }
  
  public LuckyMoneyEmojiSwitch()
  {
    this.onR = 0;
    this.onS = 0;
    this.onT = 0;
    this.onU = 0;
  }
  
  protected LuckyMoneyEmojiSwitch(Parcel paramParcel)
  {
    AppMethodBeat.i(42297);
    this.onR = 0;
    this.onS = 0;
    this.onT = 0;
    this.onU = 0;
    this.onR = paramParcel.readInt();
    this.onS = paramParcel.readInt();
    this.onT = paramParcel.readInt();
    this.onU = paramParcel.readInt();
    AppMethodBeat.o(42297);
  }
  
  public static LuckyMoneyEmojiSwitch ad(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(42295);
    LuckyMoneyEmojiSwitch localLuckyMoneyEmojiSwitch = new LuckyMoneyEmojiSwitch();
    localLuckyMoneyEmojiSwitch.onR = paramJSONObject.optInt("showOpenNormalExpression", 0);
    localLuckyMoneyEmojiSwitch.onS = paramJSONObject.optInt("showDetailNormalExpression", 0);
    localLuckyMoneyEmojiSwitch.onT = paramJSONObject.optInt("enableAnswerByExpression", 0);
    localLuckyMoneyEmojiSwitch.onU = paramJSONObject.optInt("enableAnswerBySelfie", 0);
    AppMethodBeat.o(42295);
    return localLuckyMoneyEmojiSwitch;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(42298);
    String str = "LuckyMoneyEmojiSwitch{showOpenNormalExpression=" + this.onR + ", showDetailNormalExpression=" + this.onS + ", enalbeAnswerByExpression=" + this.onT + ", enableAnswerBySelfie=" + this.onU + '}';
    AppMethodBeat.o(42298);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(42296);
    paramParcel.writeInt(this.onR);
    paramParcel.writeInt(this.onS);
    paramParcel.writeInt(this.onT);
    paramParcel.writeInt(this.onU);
    AppMethodBeat.o(42296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.LuckyMoneyEmojiSwitch
 * JD-Core Version:    0.7.0.1
 */