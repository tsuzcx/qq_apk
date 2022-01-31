package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.os.Bundle;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class TransientDataHolder
{
  private String zzos;
  private String zzot;
  private DataHolder.Builder zzou;
  
  public TransientDataHolder(String[] paramArrayOfString)
  {
    this(paramArrayOfString, null, null, null);
  }
  
  public TransientDataHolder(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(61187);
    this.zzos = paramString2;
    this.zzot = paramString3;
    if (paramString1 != null)
    {
      this.zzou = DataHolder.builder(paramArrayOfString, paramString1);
      AppMethodBeat.o(61187);
      return;
    }
    this.zzou = DataHolder.builder(paramArrayOfString);
    AppMethodBeat.o(61187);
  }
  
  public final void addRow(ContentValues paramContentValues)
  {
    AppMethodBeat.i(61188);
    this.zzou.withRow(paramContentValues);
    AppMethodBeat.o(61188);
  }
  
  @VisibleForTesting
  public final DataHolder build(int paramInt)
  {
    AppMethodBeat.i(61195);
    DataHolder localDataHolder = build(paramInt, new Bundle(), -1);
    AppMethodBeat.o(61195);
    return localDataHolder;
  }
  
  public final DataHolder build(int paramInt1, Bundle paramBundle, int paramInt2)
  {
    AppMethodBeat.i(61196);
    paramBundle.putString("next_page_token", this.zzot);
    paramBundle.putString("prev_page_token", this.zzos);
    paramBundle = this.zzou.build(paramInt1, paramBundle, paramInt2);
    AppMethodBeat.o(61196);
    return paramBundle;
  }
  
  public final boolean containsRowWithValue(String paramString, Object paramObject)
  {
    AppMethodBeat.i(61189);
    boolean bool = this.zzou.containsRowWithValue(paramString, paramObject);
    AppMethodBeat.o(61189);
    return bool;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(61192);
    int i = this.zzou.getCount();
    AppMethodBeat.o(61192);
    return i;
  }
  
  public final String getNextToken()
  {
    return this.zzot;
  }
  
  public final String getPrevToken()
  {
    return this.zzos;
  }
  
  public final void modifyUniqueRowValue(Object paramObject1, String paramString, Object paramObject2)
  {
    AppMethodBeat.i(61190);
    this.zzou.modifyUniqueRowValue(paramObject1, paramString, paramObject2);
    AppMethodBeat.o(61190);
  }
  
  @VisibleForTesting
  public final void removeRows(String paramString, Object paramObject)
  {
    AppMethodBeat.i(61191);
    this.zzou.removeRowsWithValue(paramString, paramObject);
    AppMethodBeat.o(61191);
  }
  
  public final void setNextToken(String paramString)
  {
    this.zzot = paramString;
  }
  
  public final void setPrevToken(String paramString)
  {
    this.zzos = paramString;
  }
  
  public final void sortData(String paramString)
  {
    AppMethodBeat.i(61193);
    this.zzou.sort(paramString);
    AppMethodBeat.o(61193);
  }
  
  public final void sortDataDescending(String paramString)
  {
    AppMethodBeat.i(61194);
    this.zzou.descendingSort(paramString);
    AppMethodBeat.o(61194);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.common.data.TransientDataHolder
 * JD-Core Version:    0.7.0.1
 */