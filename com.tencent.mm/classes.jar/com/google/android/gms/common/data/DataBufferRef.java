package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DataBufferRef
{
  protected final DataHolder mDataHolder;
  protected int mDataRow;
  private int zznj;
  
  public DataBufferRef(DataHolder paramDataHolder, int paramInt)
  {
    AppMethodBeat.i(11541);
    this.mDataHolder = ((DataHolder)Preconditions.checkNotNull(paramDataHolder));
    setDataRow(paramInt);
    AppMethodBeat.o(11541);
  }
  
  protected void copyToBuffer(String paramString, CharArrayBuffer paramCharArrayBuffer)
  {
    AppMethodBeat.i(11553);
    this.mDataHolder.copyToBuffer(paramString, this.mDataRow, this.zznj, paramCharArrayBuffer);
    AppMethodBeat.o(11553);
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(11556);
    if ((paramObject instanceof DataBufferRef))
    {
      paramObject = (DataBufferRef)paramObject;
      if ((Objects.equal(Integer.valueOf(paramObject.mDataRow), Integer.valueOf(this.mDataRow))) && (Objects.equal(Integer.valueOf(paramObject.zznj), Integer.valueOf(this.zznj))) && (paramObject.mDataHolder == this.mDataHolder))
      {
        AppMethodBeat.o(11556);
        return true;
      }
      AppMethodBeat.o(11556);
      return false;
    }
    AppMethodBeat.o(11556);
    return false;
  }
  
  protected boolean getBoolean(String paramString)
  {
    AppMethodBeat.i(11547);
    boolean bool = this.mDataHolder.getBoolean(paramString, this.mDataRow, this.zznj);
    AppMethodBeat.o(11547);
    return bool;
  }
  
  protected byte[] getByteArray(String paramString)
  {
    AppMethodBeat.i(11551);
    paramString = this.mDataHolder.getByteArray(paramString, this.mDataRow, this.zznj);
    AppMethodBeat.o(11551);
    return paramString;
  }
  
  protected int getDataRow()
  {
    return this.mDataRow;
  }
  
  protected double getDouble(String paramString)
  {
    AppMethodBeat.i(11550);
    double d = this.mDataHolder.getDouble(paramString, this.mDataRow, this.zznj);
    AppMethodBeat.o(11550);
    return d;
  }
  
  protected float getFloat(String paramString)
  {
    AppMethodBeat.i(11549);
    float f = this.mDataHolder.getFloat(paramString, this.mDataRow, this.zznj);
    AppMethodBeat.o(11549);
    return f;
  }
  
  protected int getInteger(String paramString)
  {
    AppMethodBeat.i(11546);
    int i = this.mDataHolder.getInteger(paramString, this.mDataRow, this.zznj);
    AppMethodBeat.o(11546);
    return i;
  }
  
  protected long getLong(String paramString)
  {
    AppMethodBeat.i(11545);
    long l = this.mDataHolder.getLong(paramString, this.mDataRow, this.zznj);
    AppMethodBeat.o(11545);
    return l;
  }
  
  protected String getString(String paramString)
  {
    AppMethodBeat.i(11548);
    paramString = this.mDataHolder.getString(paramString, this.mDataRow, this.zznj);
    AppMethodBeat.o(11548);
    return paramString;
  }
  
  public boolean hasColumn(String paramString)
  {
    AppMethodBeat.i(11544);
    boolean bool = this.mDataHolder.hasColumn(paramString);
    AppMethodBeat.o(11544);
    return bool;
  }
  
  protected boolean hasNull(String paramString)
  {
    AppMethodBeat.i(11554);
    boolean bool = this.mDataHolder.hasNull(paramString, this.mDataRow, this.zznj);
    AppMethodBeat.o(11554);
    return bool;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(11555);
    int i = Objects.hashCode(new Object[] { Integer.valueOf(this.mDataRow), Integer.valueOf(this.zznj), this.mDataHolder });
    AppMethodBeat.o(11555);
    return i;
  }
  
  public boolean isDataValid()
  {
    AppMethodBeat.i(11543);
    if (!this.mDataHolder.isClosed())
    {
      AppMethodBeat.o(11543);
      return true;
    }
    AppMethodBeat.o(11543);
    return false;
  }
  
  protected Uri parseUri(String paramString)
  {
    AppMethodBeat.i(11552);
    paramString = this.mDataHolder.parseUri(paramString, this.mDataRow, this.zznj);
    AppMethodBeat.o(11552);
    return paramString;
  }
  
  protected void setDataRow(int paramInt)
  {
    AppMethodBeat.i(11542);
    if ((paramInt >= 0) && (paramInt < this.mDataHolder.getCount())) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool);
      this.mDataRow = paramInt;
      this.zznj = this.mDataHolder.getWindowIndex(this.mDataRow);
      AppMethodBeat.o(11542);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.data.DataBufferRef
 * JD-Core Version:    0.7.0.1
 */