package com.google.android.gms.common.data;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Locale;

public final class TextFilteredDataBuffer<T>
  extends FilteredDataBuffer<T>
  implements TextFilterable
{
  private final ArrayList<Integer> zzob;
  private AbstractDataBuffer<T> zzoc;
  private final String zzoo;
  private String zzop;
  private TextFilterable.StringFilter zzoq;
  private Locale zzor;
  
  public TextFilteredDataBuffer(AbstractDataBuffer<T> paramAbstractDataBuffer, String paramString)
  {
    super(paramAbstractDataBuffer);
    AppMethodBeat.i(11673);
    this.zzob = new ArrayList();
    this.zzoc = paramAbstractDataBuffer;
    this.zzoo = paramString;
    AppMethodBeat.o(11673);
  }
  
  private final String zzh(String paramString)
  {
    AppMethodBeat.i(11678);
    paramString = paramString.toLowerCase(this.zzor);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int j = paramString.length();
    while (i < j)
    {
      if (!Character.isIdentifierIgnorable(paramString.charAt(i))) {
        localStringBuilder.append(paramString.charAt(i));
      }
      i += 1;
    }
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(11678);
    return paramString;
  }
  
  public final int computeRealPosition(int paramInt)
  {
    AppMethodBeat.i(11675);
    if (TextUtils.isEmpty(this.zzop))
    {
      AppMethodBeat.o(11675);
      return paramInt;
    }
    if ((paramInt < 0) || (paramInt >= this.zzob.size()))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException(53 + "Position " + paramInt + " is out of bounds for this buffer");
      AppMethodBeat.o(11675);
      throw localIllegalArgumentException;
    }
    paramInt = ((Integer)this.zzob.get(paramInt)).intValue();
    AppMethodBeat.o(11675);
    return paramInt;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(11674);
    if (TextUtils.isEmpty(this.zzop))
    {
      i = this.mDataBuffer.getCount();
      AppMethodBeat.o(11674);
      return i;
    }
    int i = this.zzob.size();
    AppMethodBeat.o(11674);
    return i;
  }
  
  public final void setFilterTerm(Context paramContext, TextFilterable.StringFilter paramStringFilter, String paramString)
  {
    AppMethodBeat.i(11677);
    Preconditions.checkNotNull(paramStringFilter);
    this.zzop = paramString;
    this.zzoq = paramStringFilter;
    if (!TextUtils.isEmpty(this.zzop))
    {
      this.zzor = paramContext.getResources().getConfiguration().locale;
      this.zzop = zzh(this.zzop);
      this.zzob.clear();
      paramContext = this.zzoc.mDataHolder;
      paramStringFilter = this.zzoo;
      boolean bool = this.zzoc instanceof EntityBuffer;
      int i = 0;
      int k = this.zzoc.getCount();
      if (i < k)
      {
        if (bool) {}
        for (int j = ((EntityBuffer)this.zzoc).zzi(i);; j = i)
        {
          paramString = paramContext.getString(paramStringFilter, j, paramContext.getWindowIndex(j));
          if ((!TextUtils.isEmpty(paramString)) && (this.zzoq.matches(zzh(paramString), this.zzop))) {
            this.zzob.add(Integer.valueOf(i));
          }
          i += 1;
          break;
        }
      }
      AppMethodBeat.o(11677);
      return;
    }
    this.zzob.clear();
    AppMethodBeat.o(11677);
  }
  
  public final void setFilterTerm(Context paramContext, String paramString)
  {
    AppMethodBeat.i(11676);
    setFilterTerm(paramContext, CONTAINS, paramString);
    AppMethodBeat.o(11676);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.data.TextFilteredDataBuffer
 * JD-Core Version:    0.7.0.1
 */