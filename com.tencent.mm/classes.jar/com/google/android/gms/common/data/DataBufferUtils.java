package com.google.android.gms.common.data;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public final class DataBufferUtils
{
  public static final String KEY_NEXT_PAGE_TOKEN = "next_page_token";
  public static final String KEY_PREV_PAGE_TOKEN = "prev_page_token";
  public static final String PAGE_PLACEHOLDER_TOKEN = "has_local_data";
  
  public static <T, E extends Freezable<T>> ArrayList<T> freezeAndClose(DataBuffer<E> paramDataBuffer)
  {
    AppMethodBeat.i(11561);
    ArrayList localArrayList = new ArrayList(paramDataBuffer.getCount());
    try
    {
      Iterator localIterator = paramDataBuffer.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((Freezable)localIterator.next()).freeze());
      }
      paramDataBuffer.close();
    }
    finally
    {
      paramDataBuffer.close();
      AppMethodBeat.o(11561);
    }
    AppMethodBeat.o(11561);
    return localArrayList1;
  }
  
  public static boolean hasData(DataBuffer<?> paramDataBuffer)
  {
    AppMethodBeat.i(11564);
    if ((paramDataBuffer != null) && (paramDataBuffer.getCount() > 0))
    {
      AppMethodBeat.o(11564);
      return true;
    }
    AppMethodBeat.o(11564);
    return false;
  }
  
  public static boolean hasNextPage(DataBuffer<?> paramDataBuffer)
  {
    AppMethodBeat.i(11562);
    paramDataBuffer = paramDataBuffer.getMetadata();
    if ((paramDataBuffer != null) && (paramDataBuffer.getString("next_page_token") != null))
    {
      AppMethodBeat.o(11562);
      return true;
    }
    AppMethodBeat.o(11562);
    return false;
  }
  
  public static boolean hasPrevPage(DataBuffer<?> paramDataBuffer)
  {
    AppMethodBeat.i(11563);
    paramDataBuffer = paramDataBuffer.getMetadata();
    if ((paramDataBuffer != null) && (paramDataBuffer.getString("prev_page_token") != null))
    {
      AppMethodBeat.o(11563);
      return true;
    }
    AppMethodBeat.o(11563);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.data.DataBufferUtils
 * JD-Core Version:    0.7.0.1
 */