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
  public int yVG;
  public int yVH;
  public int yVI;
  public int yVJ;
  
  static
  {
    AppMethodBeat.i(65189);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(65189);
  }
  
  public LuckyMoneyEmojiSwitch()
  {
    this.yVG = 0;
    this.yVH = 0;
    this.yVI = 0;
    this.yVJ = 0;
  }
  
  protected LuckyMoneyEmojiSwitch(Parcel paramParcel)
  {
    AppMethodBeat.i(65187);
    this.yVG = 0;
    this.yVH = 0;
    this.yVI = 0;
    this.yVJ = 0;
    this.yVG = paramParcel.readInt();
    this.yVH = paramParcel.readInt();
    this.yVI = paramParcel.readInt();
    this.yVJ = paramParcel.readInt();
    AppMethodBeat.o(65187);
  }
  
  public static LuckyMoneyEmojiSwitch aX(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65185);
    LuckyMoneyEmojiSwitch localLuckyMoneyEmojiSwitch = new LuckyMoneyEmojiSwitch();
    localLuckyMoneyEmojiSwitch.yVG = paramJSONObject.optInt("showOpenNormalExpression", 0);
    localLuckyMoneyEmojiSwitch.yVH = paramJSONObject.optInt("showDetailNormalExpression", 0);
    localLuckyMoneyEmojiSwitch.yVI = paramJSONObject.optInt("enableAnswerByExpression", 0);
    localLuckyMoneyEmojiSwitch.yVJ = paramJSONObject.optInt("enableAnswerBySelfie", 0);
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
    String str = "LuckyMoneyEmojiSwitch{showOpenNormalExpression=" + this.yVG + ", showDetailNormalExpression=" + this.yVH + ", enalbeAnswerByExpression=" + this.yVI + ", enableAnswerBySelfie=" + this.yVJ + '}';
    AppMethodBeat.o(65188);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(65186);
    paramParcel.writeInt(this.yVG);
    paramParcel.writeInt(this.yVH);
    paramParcel.writeInt(this.yVI);
    paramParcel.writeInt(this.yVJ);
    AppMethodBeat.o(65186);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.LuckyMoneyEmojiSwitch
 * JD-Core Version:    0.7.0.1
 */