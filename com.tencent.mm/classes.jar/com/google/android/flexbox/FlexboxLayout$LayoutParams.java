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
  private int bJH;
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
    AppMethodBeat.i(62269);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(62269);
  }
  
  public FlexboxLayout$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(62266);
    this.bJH = 1;
    this.bJI = 0.0F;
    this.bJJ = 1.0F;
    this.bJK = -1;
    this.bJL = -1.0F;
    this.mMaxWidth = 16777215;
    this.mMaxHeight = 16777215;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, d.a.FlexboxLayout_Layout);
    this.bJH = paramContext.getInt(8, 1);
    this.bJI = paramContext.getFloat(2, 0.0F);
    this.bJJ = paramContext.getFloat(3, 1.0F);
    this.bJK = paramContext.getInt(0, -1);
    this.bJL = paramContext.getFraction(1, 1, 1, -1.0F);
    this.mMinWidth = paramContext.getDimensionPixelSize(7, 0);
    this.mMinHeight = paramContext.getDimensionPixelSize(6, 0);
    this.mMaxWidth = paramContext.getDimensionPixelSize(5, 16777215);
    this.mMaxHeight = paramContext.getDimensionPixelSize(4, 16777215);
    this.bJM = paramContext.getBoolean(9, false);
    paramContext.recycle();
    AppMethodBeat.o(62266);
  }
  
  protected FlexboxLayout$LayoutParams(Parcel paramParcel)
  {
    super(0, 0);
    AppMethodBeat.i(62268);
    this.bJH = 1;
    this.bJI = 0.0F;
    this.bJJ = 1.0F;
    this.bJK = -1;
    this.bJL = -1.0F;
    this.mMaxWidth = 16777215;
    this.mMaxHeight = 16777215;
    this.bJH = paramParcel.readInt();
    this.bJI = paramParcel.readFloat();
    this.bJJ = paramParcel.readFloat();
    this.bJK = paramParcel.readInt();
    this.bJL = paramParcel.readFloat();
    this.mMinWidth = paramParcel.readInt();
    this.mMinHeight = paramParcel.readInt();
    this.mMaxWidth = paramParcel.readInt();
    this.mMaxHeight = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {}
    for (;;)
    {
      this.bJM = bool;
      this.bottomMargin = paramParcel.readInt();
      this.leftMargin = paramParcel.readInt();
      this.rightMargin = paramParcel.readInt();
      this.topMargin = paramParcel.readInt();
      this.height = paramParcel.readInt();
      this.width = paramParcel.readInt();
      AppMethodBeat.o(62268);
      return;
      bool = false;
    }
  }
  
  public FlexboxLayout$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
    this.bJH = 1;
    this.bJI = 0.0F;
    this.bJJ = 1.0F;
    this.bJK = -1;
    this.bJL = -1.0F;
    this.mMaxWidth = 16777215;
    this.mMaxHeight = 16777215;
  }
  
  public FlexboxLayout$LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
    this.bJH = 1;
    this.bJI = 0.0F;
    this.bJJ = 1.0F;
    this.bJK = -1;
    this.bJL = -1.0F;
    this.mMaxWidth = 16777215;
    this.mMaxHeight = 16777215;
  }
  
  public FlexboxLayout$LayoutParams(LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
    this.bJH = 1;
    this.bJI = 0.0F;
    this.bJJ = 1.0F;
    this.bJK = -1;
    this.bJL = -1.0F;
    this.mMaxWidth = 16777215;
    this.mMaxHeight = 16777215;
    this.bJH = paramLayoutParams.bJH;
    this.bJI = paramLayoutParams.bJI;
    this.bJJ = paramLayoutParams.bJJ;
    this.bJK = paramLayoutParams.bJK;
    this.bJL = paramLayoutParams.bJL;
    this.mMinWidth = paramLayoutParams.mMinWidth;
    this.mMinHeight = paramLayoutParams.mMinHeight;
    this.mMaxWidth = paramLayoutParams.mMaxWidth;
    this.mMaxHeight = paramLayoutParams.mMaxHeight;
    this.bJM = paramLayoutParams.bJM;
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
    return this.bJH;
  }
  
  public final int getWidth()
  {
    return this.width;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(62267);
    paramParcel.writeInt(this.bJH);
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
      AppMethodBeat.o(62267);
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
 * Qualified Name:     com.google.android.flexbox.FlexboxLayout.LayoutParams
 * JD-Core Version:    0.7.0.1
 */