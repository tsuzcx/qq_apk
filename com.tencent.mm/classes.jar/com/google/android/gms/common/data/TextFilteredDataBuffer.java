package com.google.android.gms.common.data;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
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
    AppMethodBeat.i(61181);
    this.zzob = new ArrayList();
    this.zzoc = paramAbstractDataBuffer;
    this.zzoo = paramString;
    AppMethodBeat.o(61181);
  }
  
  private final String zzh(String paramString)
  {
    AppMethodBeat.i(61186);
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
    AppMethodBeat.o(61186);
    return paramString;
  }
  
  public final int computeRealPosition(int paramInt)
  {
    AppMethodBeat.i(61183);
    if (TextUtils.isEmpty(this.zzop))
    {
      AppMethodBeat.o(61183);
      return paramInt;
    }
    if ((paramInt < 0) || (paramInt >= this.zzob.size()))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException(53 + "Position " + paramInt + " is out of bounds for this buffer");
      AppMethodBeat.o(61183);
      throw localIllegalArgumentException;
    }
    paramInt = ((Integer)this.zzob.get(paramInt)).intValue();
    AppMethodBeat.o(61183);
    return paramInt;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(61182);
    if (TextUtils.isEmpty(this.zzop))
    {
      i = this.mDataBuffer.getCount();
      AppMethodBeat.o(61182);
      return i;
    }
    int i = this.zzob.size();
    AppMethodBeat.o(61182);
    return i;
  }
  
  public final void setFilterTerm(Context paramContext, TextFilterable.StringFilter paramStringFilter, String paramString)
  {
    AppMethodBeat.i(61185);
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
      AppMethodBeat.o(61185);
      return;
    }
    this.zzob.clear();
    AppMethodBeat.o(61185);
  }
  
  @VisibleForTesting
  public final void setFilterTerm(Context paramContext, String paramString)
  {
    AppMethodBeat.i(61184);
    setFilterTerm(paramContext, CONTAINS, paramString);
    AppMethodBeat.o(61184);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.data.TextFilteredDataBuffer
 * JD-Core Version:    0.7.0.1
 */