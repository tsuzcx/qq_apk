package com.tencent.mm.plugin.game.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GameTabData$TabItem
  implements Parcelable
{
  public static final Parcelable.Creator<TabItem> CREATOR = new GameTabData.TabItem.1();
  public int bXn;
  public String jumpUrl;
  public String kOo;
  public String kQT;
  public boolean kQU;
  public boolean kQV;
  public int kQW;
  public int kQX;
  public String kQY;
  public String kQZ;
  public String kRa;
  public boolean kRb;
  public int kRc;
  public String title;
  
  public GameTabData$TabItem() {}
  
  public GameTabData$TabItem(Parcel paramParcel)
  {
    this.kQT = paramParcel.readString();
    this.title = paramParcel.readString();
    this.jumpUrl = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.kQU = bool1;
      if (paramParcel.readByte() == 0) {
        break label142;
      }
      bool1 = true;
      label53:
      this.kQV = bool1;
      this.kQW = paramParcel.readInt();
      this.kQX = paramParcel.readInt();
      this.kQY = paramParcel.readString();
      this.kQZ = paramParcel.readString();
      this.kRa = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label147;
      }
    }
    label142:
    label147:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.kRb = bool1;
      this.bXn = paramParcel.readInt();
      this.kRc = paramParcel.readInt();
      this.kOo = paramParcel.readString();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label53;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.kQT);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.jumpUrl);
    if (this.kQU)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.kQV) {
        break label141;
      }
      paramInt = 1;
      label50:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.kQW);
      paramParcel.writeInt(this.kQX);
      paramParcel.writeString(this.kQY);
      paramParcel.writeString(this.kQZ);
      paramParcel.writeString(this.kRa);
      if (!this.kRb) {
        break label146;
      }
    }
    label141:
    label146:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.bXn);
      paramParcel.writeInt(this.kRc);
      paramParcel.writeString(this.kOo);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label50;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.GameTabData.TabItem
 * JD-Core Version:    0.7.0.1
 */