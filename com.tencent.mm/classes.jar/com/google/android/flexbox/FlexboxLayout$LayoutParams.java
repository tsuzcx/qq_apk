package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FlexboxLayout$LayoutParams
  extends ViewGroup.MarginLayoutParams
  implements FlexItem
{
  public static final Parcelable.Creator<LayoutParams> CREATOR;
  private boolean bdA;
  private int bdv;
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
    AppMethodBeat.i(54732);
    CREATOR = new FlexboxLayout.LayoutParams.1();
    AppMethodBeat.o(54732);
  }
  
  public FlexboxLayout$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(54729);
    this.bdv = 1;
    this.bdw = 0.0F;
    this.bdx = 1.0F;
    this.bdy = -1;
    this.bdz = -1.0F;
    this.mMaxWidth = 16777215;
    this.mMaxHeight = 16777215;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, d.a.FlexboxLayout_Layout);
    this.bdv = paramContext.getInt(0, 1);
    this.bdw = paramContext.getFloat(1, 0.0F);
    this.bdx = paramContext.getFloat(2, 1.0F);
    this.bdy = paramContext.getInt(4, -1);
    this.bdz = paramContext.getFraction(3, 1, 1, -1.0F);
    this.mMinWidth = paramContext.getDimensionPixelSize(5, 0);
    this.mMinHeight = paramContext.getDimensionPixelSize(6, 0);
    this.mMaxWidth = paramContext.getDimensionPixelSize(7, 16777215);
    this.mMaxHeight = paramContext.getDimensionPixelSize(8, 16777215);
    this.bdA = paramContext.getBoolean(9, false);
    paramContext.recycle();
    AppMethodBeat.o(54729);
  }
  
  protected FlexboxLayout$LayoutParams(Parcel paramParcel)
  {
    super(0, 0);
    AppMethodBeat.i(54731);
    this.bdv = 1;
    this.bdw = 0.0F;
    this.bdx = 1.0F;
    this.bdy = -1;
    this.bdz = -1.0F;
    this.mMaxWidth = 16777215;
    this.mMaxHeight = 16777215;
    this.bdv = paramParcel.readInt();
    this.bdw = paramParcel.readFloat();
    this.bdx = paramParcel.readFloat();
    this.bdy = paramParcel.readInt();
    this.bdz = paramParcel.readFloat();
    this.mMinWidth = paramParcel.readInt();
    this.mMinHeight = paramParcel.readInt();
    this.mMaxWidth = paramParcel.readInt();
    this.mMaxHeight = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {}
    for (;;)
    {
      this.bdA = bool;
      this.bottomMargin = paramParcel.readInt();
      this.leftMargin = paramParcel.readInt();
      this.rightMargin = paramParcel.readInt();
      this.topMargin = paramParcel.readInt();
      this.height = paramParcel.readInt();
      this.width = paramParcel.readInt();
      AppMethodBeat.o(54731);
      return;
      bool = false;
    }
  }
  
  public FlexboxLayout$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
    this.bdv = 1;
    this.bdw = 0.0F;
    this.bdx = 1.0F;
    this.bdy = -1;
    this.bdz = -1.0F;
    this.mMaxWidth = 16777215;
    this.mMaxHeight = 16777215;
  }
  
  public FlexboxLayout$LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
    this.bdv = 1;
    this.bdw = 0.0F;
    this.bdx = 1.0F;
    this.bdy = -1;
    this.bdz = -1.0F;
    this.mMaxWidth = 16777215;
    this.mMaxHeight = 16777215;
  }
  
  public FlexboxLayout$LayoutParams(LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
    this.bdv = 1;
    this.bdw = 0.0F;
    this.bdx = 1.0F;
    this.bdy = -1;
    this.bdz = -1.0F;
    this.mMaxWidth = 16777215;
    this.mMaxHeight = 16777215;
    this.bdv = paramLayoutParams.bdv;
    this.bdw = paramLayoutParams.bdw;
    this.bdx = paramLayoutParams.bdx;
    this.bdy = paramLayoutParams.bdy;
    this.bdz = paramLayoutParams.bdz;
    this.mMinWidth = paramLayoutParams.mMinWidth;
    this.mMinHeight = paramLayoutParams.mMinHeight;
    this.mMaxWidth = paramLayoutParams.mMaxWidth;
    this.mMaxHeight = paramLayoutParams.mMaxHeight;
    this.bdA = paramLayoutParams.bdA;
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
    return this.bdv;
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
    AppMethodBeat.i(54730);
    paramParcel.writeInt(this.bdv);
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
      AppMethodBeat.o(54730);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.flexbox.FlexboxLayout.LayoutParams
 * JD-Core Version:    0.7.0.1
 */