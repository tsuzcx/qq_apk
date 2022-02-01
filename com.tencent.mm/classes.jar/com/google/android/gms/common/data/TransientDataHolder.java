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
    AppMethodBeat.i(11679);
    this.zzos = paramString2;
    this.zzot = paramString3;
    if (paramString1 != null)
    {
      this.zzou = DataHolder.builder(paramArrayOfString, paramString1);
      AppMethodBeat.o(11679);
      return;
    }
    this.zzou = DataHolder.builder(paramArrayOfString);
    AppMethodBeat.o(11679);
  }
  
  public final void addRow(ContentValues paramContentValues)
  {
    AppMethodBeat.i(11680);
    this.zzou.withRow(paramContentValues);
    AppMethodBeat.o(11680);
  }
  
  @VisibleForTesting
  public final DataHolder build(int paramInt)
  {
    AppMethodBeat.i(11687);
    DataHolder localDataHolder = build(paramInt, new Bundle(), -1);
    AppMethodBeat.o(11687);
    return localDataHolder;
  }
  
  public final DataHolder build(int paramInt1, Bundle paramBundle, int paramInt2)
  {
    AppMethodBeat.i(11688);
    paramBundle.putString("next_page_token", this.zzot);
    paramBundle.putString("prev_page_token", this.zzos);
    paramBundle = this.zzou.build(paramInt1, paramBundle, paramInt2);
    AppMethodBeat.o(11688);
    return paramBundle;
  }
  
  public final boolean containsRowWithValue(String paramString, Object paramObject)
  {
    AppMethodBeat.i(11681);
    boolean bool = this.zzou.containsRowWithValue(paramString, paramObject);
    AppMethodBeat.o(11681);
    return bool;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(11684);
    int i = this.zzou.getCount();
    AppMethodBeat.o(11684);
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
    AppMethodBeat.i(11682);
    this.zzou.modifyUniqueRowValue(paramObject1, paramString, paramObject2);
    AppMethodBeat.o(11682);
  }
  
  @VisibleForTesting
  public final void removeRows(String paramString, Object paramObject)
  {
    AppMethodBeat.i(11683);
    this.zzou.removeRowsWithValue(paramString, paramObject);
    AppMethodBeat.o(11683);
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
    AppMethodBeat.i(11685);
    this.zzou.sort(paramString);
    AppMethodBeat.o(11685);
  }
  
  public final void sortDataDescending(String paramString)
  {
    AppMethodBeat.i(11686);
    this.zzou.descendingSort(paramString);
    AppMethodBeat.o(11686);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.common.data.TransientDataHolder
 * JD-Core Version:    0.7.0.1
 */