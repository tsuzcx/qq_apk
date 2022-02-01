package com.tencent.mm.openim.api;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.openim.model.IOpenIMKefuConfirmController.ConfirmResultReceiver;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.sdk.platformtools.Log;

public class OpenIMKefuStartConversationRequest
  implements Parcelable
{
  public static final Parcelable.Creator<OpenIMKefuStartConversationRequest> CREATOR;
  public Context context;
  public long hBk;
  public String prA;
  public boolean prB;
  public boolean prC;
  public boolean prD;
  public boolean prE;
  public Intent prF;
  public Intent prG;
  public int prw;
  public int prx;
  public du pry;
  public boolean prz;
  
  static
  {
    AppMethodBeat.i(235769);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(235769);
  }
  
  public OpenIMKefuStartConversationRequest()
  {
    AppMethodBeat.i(235765);
    this.context = null;
    this.hBk = 0L;
    this.prz = false;
    this.prA = "";
    this.prE = true;
    this.prG = new Intent();
    this.prx = 2;
    this.prB = false;
    this.prC = false;
    AppMethodBeat.o(235765);
  }
  
  private OpenIMKefuStartConversationRequest(Parcel paramParcel)
  {
    AppMethodBeat.i(235767);
    this.context = null;
    this.hBk = 0L;
    this.prz = false;
    this.prA = "";
    this.prE = true;
    this.prG = new Intent();
    this.hBk = paramParcel.readLong();
    this.prw = paramParcel.readInt();
    this.prx = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.prz = bool1;
      this.prA = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label220;
      }
      bool1 = true;
      label104:
      this.prB = bool1;
      if (paramParcel.readByte() == 0) {
        break label225;
      }
      bool1 = true;
      label118:
      this.prC = bool1;
      if (paramParcel.readByte() == 0) {
        break label230;
      }
      bool1 = true;
      label132:
      this.prE = bool1;
      if (paramParcel.readByte() == 0) {
        break label235;
      }
    }
    label220:
    label225:
    label230:
    label235:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.prD = bool1;
      this.prG = ((Intent)paramParcel.readParcelable(IOpenIMKefuConfirmController.ConfirmResultReceiver.class.getClassLoader()));
      try
      {
        int i = paramParcel.readInt();
        if (i > 0)
        {
          byte[] arrayOfByte = new byte[i];
          paramParcel.readByteArray(arrayOfByte);
          this.pry = new du();
          this.pry.parseFrom(arrayOfByte);
        }
        AppMethodBeat.o(235767);
        return;
      }
      catch (Exception paramParcel)
      {
        Log.printErrStackTrace("", paramParcel, "OpenIMKefuStartConversationRequest parse exception", new Object[0]);
        AppMethodBeat.o(235767);
      }
      bool1 = false;
      break;
      bool1 = false;
      break label104;
      bool1 = false;
      break label118;
      bool1 = false;
      break label132;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(235771);
    int i = this.prw;
    String str1;
    int j;
    boolean bool1;
    boolean bool2;
    if (this.pry != null)
    {
      str1 = this.pry.url;
      j = this.prx;
      bool1 = this.prB;
      bool2 = this.prC;
      if (this.pry == null) {
        break label135;
      }
    }
    label135:
    for (String str2 = this.pry.username;; str2 = "null")
    {
      str1 = String.format("OpenIMKefuStartConversationRequest {getContactScene: %s, url: %s, uiMode: %s, needConversationList: %s, needChattingAnim: %s, username: %s, needUpdateTicket: %s}", new Object[] { Integer.valueOf(i), str1, Integer.valueOf(j), Boolean.valueOf(bool1), Boolean.valueOf(bool2), str2, Boolean.valueOf(this.prE) });
      AppMethodBeat.o(235771);
      return str1;
      str1 = "null";
      break;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(235770);
    paramParcel.writeLong(this.hBk);
    paramParcel.writeInt(this.prw);
    paramParcel.writeInt(this.prx);
    if (this.prz)
    {
      i = 1;
      paramParcel.writeByte((byte)i);
      paramParcel.writeString(this.prA);
      if (!this.prB) {
        break label218;
      }
      i = 1;
      label64:
      paramParcel.writeByte((byte)i);
      if (!this.prC) {
        break label223;
      }
      i = 1;
      label79:
      paramParcel.writeByte((byte)i);
      if (!this.prE) {
        break label228;
      }
      i = 1;
      label94:
      paramParcel.writeByte((byte)i);
      if (!this.prD) {
        break label233;
      }
    }
    label218:
    label223:
    label228:
    label233:
    for (int i = j;; i = 0)
    {
      paramParcel.writeByte((byte)i);
      paramParcel.writeParcelable(this.prG, paramInt);
      try
      {
        if (this.pry != null)
        {
          byte[] arrayOfByte = this.pry.toByteArray();
          if (arrayOfByte != null)
          {
            paramParcel.writeInt(arrayOfByte.length);
            paramParcel.writeByteArray(arrayOfByte);
            AppMethodBeat.o(235770);
            return;
          }
          paramParcel.writeInt(0);
          paramParcel.writeByteArray(new byte[0]);
          AppMethodBeat.o(235770);
          return;
        }
      }
      catch (Exception paramParcel)
      {
        Log.printErrStackTrace("", paramParcel, "OpenIMKefuStartConversationRequest writeToParcel exception", new Object[0]);
        AppMethodBeat.o(235770);
        return;
      }
      paramParcel.writeInt(0);
      AppMethodBeat.o(235770);
      return;
      i = 0;
      break;
      i = 0;
      break label64;
      i = 0;
      break label79;
      i = 0;
      break label94;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.api.OpenIMKefuStartConversationRequest
 * JD-Core Version:    0.7.0.1
 */