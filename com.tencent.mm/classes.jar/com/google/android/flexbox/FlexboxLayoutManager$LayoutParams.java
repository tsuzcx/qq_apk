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
  private boolean bdA;
  private float bdw;
  private float bdx;
  private int bdy;
  private float bdz;
  private int mMaxHeight;
  private int mMaxWidth;
  private int mMinHeight;
  private int mMinWidth;
  
  static
  {
    AppMethodBeat.i(54786);
    CREATOR = new FlexboxLayoutManager.LayoutParams.1();
    AppMethodBeat.o(54786);
  }
  
  public FlexboxLayoutManager$LayoutParams()
  {
    super(-2, -2);
    this.bdw = 0.0F;
    this.bdx = 1.0F;
    this.bdy = -1;
    this.bdz = -1.0F;
    this.mMaxWidth = 16777215;
    this.mMaxHeight = 16777215;
  }
  
  public FlexboxLayoutManager$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.bdw = 0.0F;
    this.bdx = 1.0F;
    this.bdy = -1;
    this.bdz = -1.0F;
    this.mMaxWidth = 16777215;
    this.mMaxHeight = 16777215;
  }
  
  protected FlexboxLayoutManager$LayoutParams(Parcel paramParcel)
  {
    super(-2, -2);
    AppMethodBeat.i(54785);
    this.bdw = 0.0F;
    this.bdx = 1.0F;
    this.bdy = -1;
    this.bdz = -1.0F;
    this.mMaxWidth = 16777215;
    this.mMaxHeight = 16777215;
    this.bdw = paramParcel.readFloat();
    this.bdx = paramParcel.readFloat();
    this.bdy = paramParcel.readInt();
    this.bdz = paramParcel.readFloat();
    this.mMinWidth = paramParcel.readInt();
    this.mMinHeight = paramParcel.readInt();
    this.mMaxWidth = paramParcel.readInt();
    this.mMaxHeight = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.bdA = bool;
      this.bottomMargin = paramParcel.readInt();
      this.leftMargin = paramParcel.readInt();
      this.rightMargin = paramParcel.readInt();
      this.topMargin = paramParcel.readInt();
      this.height = paramParcel.readInt();
      this.width = paramParcel.readInt();
      AppMethodBeat.o(54785);
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final float getFlexGrow()
  {
    return this.bdw;
  }
  
  public final float getFlexShrink()
  {
    return this.bdx;
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
  
  public final int rm()
  {
    return this.bdy;
  }
  
  public final boolean rn()
  {
    return this.bdA;
  }
  
  public final float ro()
  {
    return this.bdz;
  }
  
  public final int rp()
  {
    return this.leftMargin;
  }
  
  public final int rq()
  {
    return this.topMargin;
  }
  
  public final int rr()
  {
    return this.rightMargin;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(54784);
    paramParcel.writeFloat(this.bdw);
    paramParcel.writeFloat(this.bdx);
    paramParcel.writeInt(this.bdy);
    paramParcel.writeFloat(this.bdz);
    paramParcel.writeInt(this.mMinWidth);
    paramParcel.writeInt(this.mMinHeight);
    paramParcel.writeInt(this.mMaxWidth);
    paramParcel.writeInt(this.mMaxHeight);
    if (this.bdA) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.bottomMargin);
      paramParcel.writeInt(this.leftMargin);
      paramParcel.writeInt(this.rightMargin);
      paramParcel.writeInt(this.topMargin);
      paramParcel.writeInt(this.height);
      paramParcel.writeInt(this.width);
      AppMethodBeat.o(54784);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.flexbox.FlexboxLayoutManager.LayoutParams
 * JD-Core Version:    0.7.0.1
 */