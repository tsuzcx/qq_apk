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
  public int tdI;
  public int tdJ;
  public int tdK;
  public int tdL;
  
  static
  {
    AppMethodBeat.i(65189);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(65189);
  }
  
  public LuckyMoneyEmojiSwitch()
  {
    this.tdI = 0;
    this.tdJ = 0;
    this.tdK = 0;
    this.tdL = 0;
  }
  
  protected LuckyMoneyEmojiSwitch(Parcel paramParcel)
  {
    AppMethodBeat.i(65187);
    this.tdI = 0;
    this.tdJ = 0;
    this.tdK = 0;
    this.tdL = 0;
    this.tdI = paramParcel.readInt();
    this.tdJ = paramParcel.readInt();
    this.tdK = paramParcel.readInt();
    this.tdL = paramParcel.readInt();
    AppMethodBeat.o(65187);
  }
  
  public static LuckyMoneyEmojiSwitch as(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65185);
    LuckyMoneyEmojiSwitch localLuckyMoneyEmojiSwitch = new LuckyMoneyEmojiSwitch();
    localLuckyMoneyEmojiSwitch.tdI = paramJSONObject.optInt("showOpenNormalExpression", 0);
    localLuckyMoneyEmojiSwitch.tdJ = paramJSONObject.optInt("showDetailNormalExpression", 0);
    localLuckyMoneyEmojiSwitch.tdK = paramJSONObject.optInt("enableAnswerByExpression", 0);
    localLuckyMoneyEmojiSwitch.tdL = paramJSONObject.optInt("enableAnswerBySelfie", 0);
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
    String str = "LuckyMoneyEmojiSwitch{showOpenNormalExpression=" + this.tdI + ", showDetailNormalExpression=" + this.tdJ + ", enalbeAnswerByExpression=" + this.tdK + ", enableAnswerBySelfie=" + this.tdL + '}';
    AppMethodBeat.o(65188);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(65186);
    paramParcel.writeInt(this.tdI);
    paramParcel.writeInt(this.tdJ);
    paramParcel.writeInt(this.tdK);
    paramParcel.writeInt(this.tdL);
    AppMethodBeat.o(65186);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.LuckyMoneyEmojiSwitch
 * JD-Core Version:    0.7.0.1
 */