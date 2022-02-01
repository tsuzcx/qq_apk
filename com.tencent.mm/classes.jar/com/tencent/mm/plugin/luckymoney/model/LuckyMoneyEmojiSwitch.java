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
  public int voD;
  public int voE;
  public int voF;
  public int voG;
  
  static
  {
    AppMethodBeat.i(65189);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(65189);
  }
  
  public LuckyMoneyEmojiSwitch()
  {
    this.voD = 0;
    this.voE = 0;
    this.voF = 0;
    this.voG = 0;
  }
  
  protected LuckyMoneyEmojiSwitch(Parcel paramParcel)
  {
    AppMethodBeat.i(65187);
    this.voD = 0;
    this.voE = 0;
    this.voF = 0;
    this.voG = 0;
    this.voD = paramParcel.readInt();
    this.voE = paramParcel.readInt();
    this.voF = paramParcel.readInt();
    this.voG = paramParcel.readInt();
    AppMethodBeat.o(65187);
  }
  
  public static LuckyMoneyEmojiSwitch aC(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65185);
    LuckyMoneyEmojiSwitch localLuckyMoneyEmojiSwitch = new LuckyMoneyEmojiSwitch();
    localLuckyMoneyEmojiSwitch.voD = paramJSONObject.optInt("showOpenNormalExpression", 0);
    localLuckyMoneyEmojiSwitch.voE = paramJSONObject.optInt("showDetailNormalExpression", 0);
    localLuckyMoneyEmojiSwitch.voF = paramJSONObject.optInt("enableAnswerByExpression", 0);
    localLuckyMoneyEmojiSwitch.voG = paramJSONObject.optInt("enableAnswerBySelfie", 0);
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
    String str = "LuckyMoneyEmojiSwitch{showOpenNormalExpression=" + this.voD + ", showDetailNormalExpression=" + this.voE + ", enalbeAnswerByExpression=" + this.voF + ", enableAnswerBySelfie=" + this.voG + '}';
    AppMethodBeat.o(65188);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(65186);
    paramParcel.writeInt(this.voD);
    paramParcel.writeInt(this.voE);
    paramParcel.writeInt(this.voF);
    paramParcel.writeInt(this.voG);
    AppMethodBeat.o(65186);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.LuckyMoneyEmojiSwitch
 * JD-Core Version:    0.7.0.1
 */