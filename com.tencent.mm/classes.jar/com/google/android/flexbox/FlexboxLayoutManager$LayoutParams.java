package com.google.android.flexbox;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FlexboxLayoutManager$LayoutParams
  extends RecyclerView.LayoutParams
  implements FlexItem
{
  public static final Parcelable.Creator<LayoutParams> CREATOR;
  private float bJI;
  private float bJJ;
  private int bJK;
  private float bJL;
  private boolean bJM;
  private int mMaxHeight;
  private int mMaxWidth;
  private int mMinHeight;
  private int mMinWidth;
  
  static
  {
    AppMethodBeat.i(62323);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(62323);
  }
  
  public FlexboxLayoutManager$LayoutParams()
  {
    super(-2, -2);
    this.bJI = 0.0F;
    this.bJJ = 1.0F;
    this.bJK = -1;
    this.bJL = -1.0F;
    this.mMaxWidth = 16777215;
    this.mMaxHeight = 16777215;
  }
  
  public FlexboxLayoutManager$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.bJI = 0.0F;
    this.bJJ = 1.0F;
    this.bJK = -1;
    this.bJL = -1.0F;
    this.mMaxWidth = 16777215;
    this.mMaxHeight = 16777215;
  }
  
  protected FlexboxLayoutManager$LayoutParams(Parcel paramParcel)
  {
    super(-2, -2);
    AppMethodBeat.i(62322);
    this.bJI = 0.0F;
    this.bJJ = 1.0F;
    this.bJK = -1;
    this.bJL = -1.0F;
    this.mMaxWidth = 16777215;
    this.mMaxHeight = 16777215;
    this.bJI = paramParcel.readFloat();
    this.bJJ = paramParcel.readFloat();
    this.bJK = paramParcel.readInt();
    this.bJL = paramParcel.readFloat();
    this.mMinWidth = paramParcel.readInt();
    this.mMinHeight = paramParcel.readInt();
    this.mMaxWidth = paramParcel.readInt();
    this.mMaxHeight = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.bJM = bool;
      this.bottomMargin = paramParcel.readInt();
      this.leftMargin = paramParcel.readInt();
      this.rightMargin = paramParcel.readInt();
      this.topMargin = paramParcel.readInt();
      this.height = paramParcel.readInt();
      this.width = paramParcel.readInt();
      AppMethodBeat.o(62322);
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final float getFlexGrow()
  {
    return this.bJI;
  }
  
  public final float getFlexShrink()
  {
    return this.bJJ;
  }
  
  public final int getHeight()
  {
    return this.height;
  }
  
  public final int getMarginBottom()
  {
    return this.bottomMargin;
  }
  
  public final int getMaxHeight()
  {
    return this.mMaxHeight;
  }
  
  public final int getMaxWidth()
  {
    return this.mMaxWidth;
  }
  
  public final int getMinHeight()
  {
    return this.mMinHeight;
  }
  
  public final int getMinWidth()
  {
    return this.mMinWidth;
  }
  
  public final int getOrder()
  {
    return 1;
  }
  
  public final int getWidth()
  {
    return this.width;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(62321);
    paramParcel.writeFloat(this.bJI);
    paramParcel.writeFloat(this.bJJ);
    paramParcel.writeInt(this.bJK);
    paramParcel.writeFloat(this.bJL);
    paramParcel.writeInt(this.mMinWidth);
    paramParcel.writeInt(this.mMinHeight);
    paramParcel.writeInt(this.mMaxWidth);
    paramParcel.writeInt(this.mMaxHeight);
    if (this.bJM) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.bottomMargin);
      paramParcel.writeInt(this.leftMargin);
      paramParcel.writeInt(this.rightMargin);
      paramParcel.writeInt(this.topMargin);
      paramParcel.writeInt(this.height);
      paramParcel.writeInt(this.width);
      AppMethodBeat.o(62321);
      return;
    }
  }
  
  public final int xD()
  {
    return this.bJK;
  }
  
  public final boolean xE()
  {
    return this.bJM;
  }
  
  public final float xF()
  {
    return this.bJL;
  }
  
  public final int xG()
  {
    return this.leftMargin;
  }
  
  public final int xH()
  {
    return this.topMargin;
  }
  
  public final int xI()
  {
    return this.rightMargin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.flexbox.FlexboxLayoutManager.LayoutParams
 * JD-Core Version:    0.7.0.1
 */