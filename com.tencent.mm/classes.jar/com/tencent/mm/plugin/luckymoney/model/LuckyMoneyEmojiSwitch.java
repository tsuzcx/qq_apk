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
  public int vAI;
  public int vAJ;
  public int vAK;
  public int vAL;
  
  static
  {
    AppMethodBeat.i(65189);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(65189);
  }
  
  public LuckyMoneyEmojiSwitch()
  {
    this.vAI = 0;
    this.vAJ = 0;
    this.vAK = 0;
    this.vAL = 0;
  }
  
  protected LuckyMoneyEmojiSwitch(Parcel paramParcel)
  {
    AppMethodBeat.i(65187);
    this.vAI = 0;
    this.vAJ = 0;
    this.vAK = 0;
    this.vAL = 0;
    this.vAI = paramParcel.readInt();
    this.vAJ = paramParcel.readInt();
    this.vAK = paramParcel.readInt();
    this.vAL = paramParcel.readInt();
    AppMethodBeat.o(65187);
  }
  
  public static LuckyMoneyEmojiSwitch aC(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65185);
    LuckyMoneyEmojiSwitch localLuckyMoneyEmojiSwitch = new LuckyMoneyEmojiSwitch();
    localLuckyMoneyEmojiSwitch.vAI = paramJSONObject.optInt("showOpenNormalExpression", 0);
    localLuckyMoneyEmojiSwitch.vAJ = paramJSONObject.optInt("showDetailNormalExpression", 0);
    localLuckyMoneyEmojiSwitch.vAK = paramJSONObject.optInt("enableAnswerByExpression", 0);
    localLuckyMoneyEmojiSwitch.vAL = paramJSONObject.optInt("enableAnswerBySelfie", 0);
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
    String str = "LuckyMoneyEmojiSwitch{showOpenNormalExpression=" + this.vAI + ", showDetailNormalExpression=" + this.vAJ + ", enalbeAnswerByExpression=" + this.vAK + ", enableAnswerBySelfie=" + this.vAL + '}';
    AppMethodBeat.o(65188);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(65186);
    paramParcel.writeInt(this.vAI);
    paramParcel.writeInt(this.vAJ);
    paramParcel.writeInt(this.vAK);
    paramParcel.writeInt(this.vAL);
    AppMethodBeat.o(65186);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.LuckyMoneyEmojiSwitch
 * JD-Core Version:    0.7.0.1
 */