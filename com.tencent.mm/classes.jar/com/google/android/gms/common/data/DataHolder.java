package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.sqlite.CursorWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@KeepName
@SafeParcelable.Class(creator="DataHolderCreator", validate=true)
public final class DataHolder
  extends AbstractSafeParcelable
  implements Closeable
{
  public static final Parcelable.Creator<DataHolder> CREATOR;
  private static final Builder zznt;
  private boolean mClosed;
  @SafeParcelable.VersionField(id=1000)
  private final int zzal;
  @SafeParcelable.Field(getter="getStatusCode", id=3)
  private final int zzam;
  @SafeParcelable.Field(getter="getColumns", id=1)
  private final String[] zznm;
  private Bundle zznn;
  @SafeParcelable.Field(getter="getWindows", id=2)
  private final CursorWindow[] zzno;
  @SafeParcelable.Field(getter="getMetadata", id=4)
  private final Bundle zznp;
  private int[] zznq;
  private int zznr;
  private boolean zzns;
  
  static
  {
    AppMethodBeat.i(11614);
    CREATOR = new DataHolderCreator();
    zznt = new zza(new String[0], null);
    AppMethodBeat.o(11614);
  }
  
  @SafeParcelable.Constructor
  DataHolder(@SafeParcelable.Param(id=1000) int paramInt1, @SafeParcelable.Param(id=1) String[] paramArrayOfString, @SafeParcelable.Param(id=2) CursorWindow[] paramArrayOfCursorWindow, @SafeParcelable.Param(id=3) int paramInt2, @SafeParcelable.Param(id=4) Bundle paramBundle)
  {
    this.mClosed = false;
    this.zzns = true;
    this.zzal = paramInt1;
    this.zznm = paramArrayOfString;
    this.zzno = paramArrayOfCursorWindow;
    this.zzam = paramInt2;
    this.zznp = paramBundle;
  }
  
  public DataHolder(Cursor paramCursor, int paramInt, Bundle paramBundle)
  {
    this(new CursorWrapper(paramCursor), paramInt, paramBundle);
    AppMethodBeat.i(11582);
    AppMethodBeat.o(11582);
  }
  
  private DataHolder(Builder paramBuilder, int paramInt, Bundle paramBundle)
  {
    this(Builder.zza(paramBuilder), zza(paramBuilder, -1), paramInt, paramBundle);
    AppMethodBeat.i(11583);
    AppMethodBeat.o(11583);
  }
  
  private DataHolder(Builder paramBuilder, int paramInt1, Bundle paramBundle, int paramInt2)
  {
    this(Builder.zza(paramBuilder), zza(paramBuilder, paramInt2), paramInt1, paramBundle);
    AppMethodBeat.i(11584);
    AppMethodBeat.o(11584);
  }
  
  public DataHolder(CursorWrapper paramCursorWrapper, int paramInt, Bundle paramBundle)
  {
    this(paramCursorWrapper.getColumnNames(), zza(paramCursorWrapper), paramInt, paramBundle);
    AppMethodBeat.i(11581);
    AppMethodBeat.o(11581);
  }
  
  public DataHolder(String[] paramArrayOfString, CursorWindow[] paramArrayOfCursorWindow, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(11580);
    this.mClosed = false;
    this.zzns = true;
    this.zzal = 1;
    this.zznm = ((String[])Preconditions.checkNotNull(paramArrayOfString));
    this.zzno = ((CursorWindow[])Preconditions.checkNotNull(paramArrayOfCursorWindow));
    this.zzam = paramInt;
    this.zznp = paramBundle;
    validateContents();
    AppMethodBeat.o(11580);
  }
  
  public static Builder builder(String[] paramArrayOfString)
  {
    AppMethodBeat.i(11610);
    paramArrayOfString = new Builder(paramArrayOfString, null, null);
    AppMethodBeat.o(11610);
    return paramArrayOfString;
  }
  
  public static Builder builder(String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(11611);
    Preconditions.checkNotNull(paramString);
    paramArrayOfString = new Builder(paramArrayOfString, paramString, null);
    AppMethodBeat.o(11611);
    return paramArrayOfString;
  }
  
  public static DataHolder empty(int paramInt)
  {
    AppMethodBeat.i(11612);
    DataHolder localDataHolder = empty(paramInt, null);
    AppMethodBeat.o(11612);
    return localDataHolder;
  }
  
  public static DataHolder empty(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(11613);
    paramBundle = new DataHolder(zznt, paramInt, paramBundle);
    AppMethodBeat.o(11613);
    return paramBundle;
  }
  
  private final void zza(String paramString, int paramInt)
  {
    AppMethodBeat.i(11590);
    if ((this.zznn == null) || (!this.zznn.containsKey(paramString)))
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {}
      for (paramString = "No such column: ".concat(paramString);; paramString = new String("No such column: "))
      {
        paramString = new IllegalArgumentException(paramString);
        AppMethodBeat.o(11590);
        throw paramString;
      }
    }
    if (isClosed())
    {
      paramString = new IllegalArgumentException("Buffer is closed.");
      AppMethodBeat.o(11590);
      throw paramString;
    }
    if ((paramInt < 0) || (paramInt >= this.zznr))
    {
      paramString = new CursorIndexOutOfBoundsException(paramInt, this.zznr);
      AppMethodBeat.o(11590);
      throw paramString;
    }
    AppMethodBeat.o(11590);
  }
  
  private static CursorWindow[] zza(Builder paramBuilder, int paramInt)
  {
    int k = 0;
    AppMethodBeat.i(11589);
    if (Builder.zza(paramBuilder).length == 0)
    {
      AppMethodBeat.o(11589);
      return new CursorWindow[0];
    }
    Object localObject3;
    Object localObject2;
    ArrayList localArrayList;
    int i;
    label100:
    Object localObject1;
    if ((paramInt < 0) || (paramInt >= Builder.zzb(paramBuilder).size()))
    {
      localObject3 = Builder.zzb(paramBuilder);
      int m = ((List)localObject3).size();
      localObject2 = new CursorWindow(false);
      localArrayList = new ArrayList();
      localArrayList.add(localObject2);
      ((CursorWindow)localObject2).setNumColumns(Builder.zza(paramBuilder).length);
      paramInt = 0;
      i = 0;
      if (paramInt >= m) {
        break label742;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      int j;
      try
      {
        if (!((CursorWindow)localObject2).allocRow())
        {
          new StringBuilder(72).append("Allocating additional cursor window for large data set (row ").append(paramInt).append(")");
          localObject2 = new CursorWindow(false);
          ((CursorWindow)localObject2).setStartPosition(paramInt);
          ((CursorWindow)localObject2).setNumColumns(Builder.zza(paramBuilder).length);
          localArrayList.add(localObject2);
          localObject1 = localObject2;
          if (!((CursorWindow)localObject2).allocRow())
          {
            localArrayList.remove(localObject2);
            paramBuilder = (CursorWindow[])localArrayList.toArray(new CursorWindow[localArrayList.size()]);
            AppMethodBeat.o(11589);
            return paramBuilder;
            localObject3 = Builder.zzb(paramBuilder).subList(0, paramInt);
            break;
          }
        }
        Map localMap = (Map)((List)localObject3).get(paramInt);
        j = 0;
        bool = true;
        if ((j < Builder.zza(paramBuilder).length) && (bool))
        {
          localObject2 = Builder.zza(paramBuilder)[j];
          Object localObject4 = localMap.get(localObject2);
          if (localObject4 == null)
          {
            bool = ((CursorWindow)localObject1).putNull(paramInt, j);
            break label767;
          }
          if ((localObject4 instanceof String))
          {
            bool = ((CursorWindow)localObject1).putString((String)localObject4, paramInt, j);
            break label767;
          }
          if ((localObject4 instanceof Long))
          {
            bool = ((CursorWindow)localObject1).putLong(((Long)localObject4).longValue(), paramInt, j);
            break label767;
          }
          if ((localObject4 instanceof Integer))
          {
            bool = ((CursorWindow)localObject1).putLong(((Integer)localObject4).intValue(), paramInt, j);
            break label767;
          }
          if ((localObject4 instanceof Boolean))
          {
            if (!((Boolean)localObject4).booleanValue()) {
              break label774;
            }
            l = 1L;
            bool = ((CursorWindow)localObject1).putLong(l, paramInt, j);
            break label767;
          }
          if ((localObject4 instanceof byte[]))
          {
            bool = ((CursorWindow)localObject1).putBlob((byte[])localObject4, paramInt, j);
            break label767;
          }
          if ((localObject4 instanceof Double))
          {
            bool = ((CursorWindow)localObject1).putDouble(((Double)localObject4).doubleValue(), paramInt, j);
            break label767;
          }
          if ((localObject4 instanceof Float))
          {
            bool = ((CursorWindow)localObject1).putDouble(((Float)localObject4).floatValue(), paramInt, j);
            break label767;
          }
          paramBuilder = String.valueOf(localObject4);
          paramBuilder = new IllegalArgumentException(String.valueOf(localObject2).length() + 32 + String.valueOf(paramBuilder).length() + "Unsupported object for column " + (String)localObject2 + ": " + paramBuilder);
          AppMethodBeat.o(11589);
          throw paramBuilder;
        }
      }
      catch (RuntimeException paramBuilder)
      {
        boolean bool;
        i = localArrayList.size();
        paramInt = k;
        if (paramInt < i)
        {
          ((CursorWindow)localArrayList.get(paramInt)).close();
          paramInt += 1;
          continue;
          if (!bool)
          {
            if (i != 0)
            {
              paramBuilder = new DataHolderException("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
              AppMethodBeat.o(11589);
              throw paramBuilder;
            }
            new StringBuilder(74).append("Couldn't populate window data for row ").append(paramInt).append(" - allocating new window.");
            ((CursorWindow)localObject1).freeLastRow();
            localObject1 = new CursorWindow(false);
            ((CursorWindow)localObject1).setStartPosition(paramInt);
            ((CursorWindow)localObject1).setNumColumns(Builder.zza(paramBuilder).length);
            localArrayList.add(localObject1);
            i = paramInt - 1;
            paramInt = 1;
            j = i + 1;
            i = paramInt;
            paramInt = j;
            localObject2 = localObject1;
            break label100;
          }
          j = 0;
          i = paramInt;
          paramInt = j;
          continue;
        }
        AppMethodBeat.o(11589);
        throw paramBuilder;
      }
      label742:
      paramBuilder = (CursorWindow[])localArrayList.toArray(new CursorWindow[localArrayList.size()]);
      AppMethodBeat.o(11589);
      return paramBuilder;
      label767:
      j += 1;
      continue;
      label774:
      long l = 0L;
    }
  }
  
  private static CursorWindow[] zza(CursorWrapper paramCursorWrapper)
  {
    AppMethodBeat.i(11588);
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        int j = paramCursorWrapper.getCount();
        CursorWindow localCursorWindow = paramCursorWrapper.getWindow();
        if ((localCursorWindow == null) || (localCursorWindow.getStartPosition() != 0)) {
          break label182;
        }
        localCursorWindow.acquireReference();
        paramCursorWrapper.setWindow(null);
        localArrayList.add(localCursorWindow);
        i = localCursorWindow.getNumRows();
        if ((i < j) && (paramCursorWrapper.moveToPosition(i)))
        {
          localCursorWindow = paramCursorWrapper.getWindow();
          if (localCursorWindow != null)
          {
            localCursorWindow.acquireReference();
            paramCursorWrapper.setWindow(null);
            if (localCursorWindow.getNumRows() != 0)
            {
              localArrayList.add(localCursorWindow);
              i = localCursorWindow.getStartPosition();
              i = localCursorWindow.getNumRows() + i;
            }
          }
          else
          {
            localCursorWindow = new CursorWindow(false);
            localCursorWindow.setStartPosition(i);
            paramCursorWrapper.fillWindow(i, localCursorWindow);
            continue;
          }
        }
        paramCursorWrapper.close();
      }
      finally
      {
        paramCursorWrapper.close();
        AppMethodBeat.o(11588);
      }
      paramCursorWrapper = (CursorWindow[])localArrayList.toArray(new CursorWindow[localArrayList.size()]);
      AppMethodBeat.o(11588);
      return paramCursorWrapper;
      label182:
      int i = 0;
    }
  }
  
  public final void clearColumn(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(11602);
    zza(paramString, paramInt1);
    this.zzno[paramInt2].putNull(paramInt1, this.zznn.getInt(paramString));
    AppMethodBeat.o(11602);
  }
  
  public final void close()
  {
    AppMethodBeat.i(11608);
    try
    {
      if (!this.mClosed)
      {
        this.mClosed = true;
        int i = 0;
        while (i < this.zzno.length)
        {
          this.zzno[i].close();
          i += 1;
        }
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(11608);
    }
  }
  
  public final void copyToBuffer(String paramString, int paramInt1, int paramInt2, CharArrayBuffer paramCharArrayBuffer)
  {
    AppMethodBeat.i(11600);
    zza(paramString, paramInt1);
    this.zzno[paramInt2].copyStringToBuffer(paramInt1, this.zznn.getInt(paramString), paramCharArrayBuffer);
    AppMethodBeat.o(11600);
  }
  
  public final void disableLeakDetection()
  {
    this.zzns = false;
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(11609);
    try
    {
      if ((this.zzns) && (this.zzno.length > 0) && (!isClosed()))
      {
        close();
        String str = toString();
        new StringBuilder(String.valueOf(str).length() + 178).append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ").append(str).append(")");
      }
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(11609);
    }
  }
  
  public final boolean getBoolean(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(11595);
    zza(paramString, paramInt1);
    if (this.zzno[paramInt2].getLong(paramInt1, this.zznn.getInt(paramString)) == 1L)
    {
      AppMethodBeat.o(11595);
      return true;
    }
    AppMethodBeat.o(11595);
    return false;
  }
  
  public final byte[] getByteArray(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(11598);
    zza(paramString, paramInt1);
    paramString = this.zzno[paramInt2].getBlob(paramInt1, this.zznn.getInt(paramString));
    AppMethodBeat.o(11598);
    return paramString;
  }
  
  public final int getCount()
  {
    return this.zznr;
  }
  
  public final double getDouble(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(11597);
    zza(paramString, paramInt1);
    double d = this.zzno[paramInt2].getDouble(paramInt1, this.zznn.getInt(paramString));
    AppMethodBeat.o(11597);
    return d;
  }
  
  public final float getFloat(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(11596);
    zza(paramString, paramInt1);
    float f = this.zzno[paramInt2].getFloat(paramInt1, this.zznn.getInt(paramString));
    AppMethodBeat.o(11596);
    return f;
  }
  
  public final int getInteger(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(11593);
    zza(paramString, paramInt1);
    paramInt1 = this.zzno[paramInt2].getInt(paramInt1, this.zznn.getInt(paramString));
    AppMethodBeat.o(11593);
    return paramInt1;
  }
  
  public final long getLong(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(11592);
    zza(paramString, paramInt1);
    long l = this.zzno[paramInt2].getLong(paramInt1, this.zznn.getInt(paramString));
    AppMethodBeat.o(11592);
    return l;
  }
  
  public final Bundle getMetadata()
  {
    return this.zznp;
  }
  
  public final int getStatusCode()
  {
    return this.zzam;
  }
  
  public final String getString(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(11594);
    zza(paramString, paramInt1);
    paramString = this.zzno[paramInt2].getString(paramInt1, this.zznn.getInt(paramString));
    AppMethodBeat.o(11594);
    return paramString;
  }
  
  public final int getWindowIndex(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(11607);
    boolean bool;
    if ((paramInt >= 0) && (paramInt < this.zznr))
    {
      bool = true;
      Preconditions.checkState(bool);
    }
    for (;;)
    {
      int i = j;
      if (j < this.zznq.length)
      {
        if (paramInt < this.zznq[j]) {
          i = j - 1;
        }
      }
      else
      {
        paramInt = i;
        if (i == this.zznq.length) {
          paramInt = i - 1;
        }
        AppMethodBeat.o(11607);
        return paramInt;
        bool = false;
        break;
      }
      j += 1;
    }
  }
  
  public final boolean hasColumn(String paramString)
  {
    AppMethodBeat.i(11591);
    boolean bool = this.zznn.containsKey(paramString);
    AppMethodBeat.o(11591);
    return bool;
  }
  
  public final boolean hasNull(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(11601);
    zza(paramString, paramInt1);
    boolean bool = this.zzno[paramInt2].isNull(paramInt1, this.zznn.getInt(paramString));
    AppMethodBeat.o(11601);
    return bool;
  }
  
  public final boolean isClosed()
  {
    try
    {
      boolean bool = this.mClosed;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void logCursorMetadataForDebugging()
  {
    AppMethodBeat.i(11587);
    int i = this.zzno.length;
    new StringBuilder(32).append("num cursor windows : ").append(i);
    i = this.zznr;
    new StringBuilder(46).append("total number of objects in holder: ").append(i);
    i = this.zznq.length;
    new StringBuilder(42).append("total mumber of windowOffsets: ").append(i);
    i = 0;
    while (i < this.zznq.length)
    {
      int j = this.zznq[i];
      new StringBuilder(43).append("offset for window ").append(i).append(" : ").append(j);
      j = this.zzno[i].getNumRows();
      new StringBuilder(45).append("num rows for window ").append(i).append(" : ").append(j);
      j = this.zzno[i].getStartPosition();
      new StringBuilder(46).append("start pos for window ").append(i).append(" : ").append(j);
      i += 1;
    }
    AppMethodBeat.o(11587);
  }
  
  public final Uri parseUri(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(11599);
    paramString = getString(paramString, paramInt1, paramInt2);
    if (paramString == null)
    {
      AppMethodBeat.o(11599);
      return null;
    }
    paramString = Uri.parse(paramString);
    AppMethodBeat.o(11599);
    return paramString;
  }
  
  public final void replaceValue(String paramString, int paramInt1, int paramInt2, double paramDouble)
  {
    AppMethodBeat.i(11604);
    zza(paramString, paramInt1);
    this.zzno[paramInt2].putDouble(paramDouble, paramInt1, this.zznn.getInt(paramString));
    AppMethodBeat.o(11604);
  }
  
  public final void replaceValue(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(11605);
    zza(paramString, paramInt1);
    this.zzno[paramInt2].putLong(paramLong, paramInt1, this.zznn.getInt(paramString));
    AppMethodBeat.o(11605);
  }
  
  public final void replaceValue(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(11603);
    zza(paramString1, paramInt1);
    this.zzno[paramInt2].putString(paramString2, paramInt1, this.zznn.getInt(paramString1));
    AppMethodBeat.o(11603);
  }
  
  public final void replaceValue(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(11606);
    zza(paramString, paramInt1);
    this.zzno[paramInt2].putBlob(paramArrayOfByte, paramInt1, this.zznn.getInt(paramString));
    AppMethodBeat.o(11606);
  }
  
  public final void validateContents()
  {
    AppMethodBeat.i(11585);
    this.zznn = new Bundle();
    int i = 0;
    while (i < this.zznm.length)
    {
      this.zznn.putInt(this.zznm[i], i);
      i += 1;
    }
    this.zznq = new int[this.zzno.length];
    i = 0;
    int j = 0;
    while (i < this.zzno.length)
    {
      this.zznq[i] = j;
      int k = this.zzno[i].getStartPosition();
      j += this.zzno[i].getNumRows() - (j - k);
      i += 1;
    }
    this.zznr = j;
    AppMethodBeat.o(11585);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(11586);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeStringArray(paramParcel, 1, this.zznm, false);
    SafeParcelWriter.writeTypedArray(paramParcel, 2, this.zzno, paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 3, getStatusCode());
    SafeParcelWriter.writeBundle(paramParcel, 4, getMetadata(), false);
    SafeParcelWriter.writeInt(paramParcel, 1000, this.zzal);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    if ((paramInt & 0x1) != 0) {
      close();
    }
    AppMethodBeat.o(11586);
  }
  
  public static class Builder
  {
    private final String[] zznm;
    private final ArrayList<HashMap<String, Object>> zznu;
    private final String zznv;
    private final HashMap<Object, Integer> zznw;
    private boolean zznx;
    private String zzny;
    
    private Builder(String[] paramArrayOfString, String paramString)
    {
      AppMethodBeat.i(11565);
      this.zznm = ((String[])Preconditions.checkNotNull(paramArrayOfString));
      this.zznu = new ArrayList();
      this.zznv = paramString;
      this.zznw = new HashMap();
      this.zznx = false;
      this.zzny = null;
      AppMethodBeat.o(11565);
    }
    
    private final boolean zzg(String paramString)
    {
      AppMethodBeat.i(11573);
      Asserts.checkNotNull(paramString);
      if ((this.zznx) && (paramString.equals(this.zzny)))
      {
        AppMethodBeat.o(11573);
        return true;
      }
      AppMethodBeat.o(11573);
      return false;
    }
    
    public DataHolder build(int paramInt)
    {
      AppMethodBeat.i(11575);
      DataHolder localDataHolder = new DataHolder(this, paramInt, null, null);
      AppMethodBeat.o(11575);
      return localDataHolder;
    }
    
    public DataHolder build(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(11576);
      paramBundle = new DataHolder(this, paramInt, paramBundle, -1, null);
      AppMethodBeat.o(11576);
      return paramBundle;
    }
    
    public DataHolder build(int paramInt1, Bundle paramBundle, int paramInt2)
    {
      AppMethodBeat.i(11577);
      paramBundle = new DataHolder(this, paramInt1, paramBundle, paramInt2, null);
      AppMethodBeat.o(11577);
      return paramBundle;
    }
    
    public boolean containsRowWithValue(String paramString, Object paramObject)
    {
      AppMethodBeat.i(11569);
      int j = this.zznu.size();
      int i = 0;
      while (i < j)
      {
        if (Objects.equal(((HashMap)this.zznu.get(i)).get(paramString), paramObject))
        {
          AppMethodBeat.o(11569);
          return true;
        }
        i += 1;
      }
      AppMethodBeat.o(11569);
      return false;
    }
    
    public Builder descendingSort(String paramString)
    {
      AppMethodBeat.i(11572);
      if (zzg(paramString))
      {
        AppMethodBeat.o(11572);
        return this;
      }
      sort(paramString);
      Collections.reverse(this.zznu);
      AppMethodBeat.o(11572);
      return this;
    }
    
    public int getCount()
    {
      AppMethodBeat.i(11574);
      int i = this.zznu.size();
      AppMethodBeat.o(11574);
      return i;
    }
    
    public void modifyUniqueRowValue(Object paramObject1, String paramString, Object paramObject2)
    {
      AppMethodBeat.i(11567);
      if (this.zznv == null)
      {
        AppMethodBeat.o(11567);
        return;
      }
      paramObject1 = (Integer)this.zznw.get(paramObject1);
      if (paramObject1 == null)
      {
        AppMethodBeat.o(11567);
        return;
      }
      ((HashMap)this.zznu.get(paramObject1.intValue())).put(paramString, paramObject2);
      AppMethodBeat.o(11567);
    }
    
    public Builder removeRowsWithValue(String paramString, Object paramObject)
    {
      AppMethodBeat.i(11570);
      int i = this.zznu.size() - 1;
      while (i >= 0)
      {
        if (Objects.equal(((HashMap)this.zznu.get(i)).get(paramString), paramObject)) {
          this.zznu.remove(i);
        }
        i -= 1;
      }
      AppMethodBeat.o(11570);
      return this;
    }
    
    public Builder sort(String paramString)
    {
      AppMethodBeat.i(11571);
      if (zzg(paramString))
      {
        AppMethodBeat.o(11571);
        return this;
      }
      Collections.sort(this.zznu, new DataHolder.zza(paramString));
      if (this.zznv != null)
      {
        this.zznw.clear();
        int j = this.zznu.size();
        int i = 0;
        while (i < j)
        {
          Object localObject = ((HashMap)this.zznu.get(i)).get(this.zznv);
          if (localObject != null) {
            this.zznw.put(localObject, Integer.valueOf(i));
          }
          i += 1;
        }
      }
      this.zznx = true;
      this.zzny = paramString;
      AppMethodBeat.o(11571);
      return this;
    }
    
    public Builder withRow(ContentValues paramContentValues)
    {
      AppMethodBeat.i(11568);
      Asserts.checkNotNull(paramContentValues);
      HashMap localHashMap = new HashMap(paramContentValues.size());
      paramContentValues = paramContentValues.valueSet().iterator();
      while (paramContentValues.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramContentValues.next();
        localHashMap.put((String)localEntry.getKey(), localEntry.getValue());
      }
      paramContentValues = withRow(localHashMap);
      AppMethodBeat.o(11568);
      return paramContentValues;
    }
    
    public Builder withRow(HashMap<String, Object> paramHashMap)
    {
      AppMethodBeat.i(11566);
      Asserts.checkNotNull(paramHashMap);
      int i;
      if (this.zznv == null)
      {
        i = -1;
        if (i != -1) {
          break label115;
        }
        this.zznu.add(paramHashMap);
      }
      for (;;)
      {
        this.zznx = false;
        AppMethodBeat.o(11566);
        return this;
        Object localObject = paramHashMap.get(this.zznv);
        if (localObject == null)
        {
          i = -1;
          break;
        }
        Integer localInteger = (Integer)this.zznw.get(localObject);
        if (localInteger == null)
        {
          this.zznw.put(localObject, Integer.valueOf(this.zznu.size()));
          i = -1;
          break;
        }
        i = localInteger.intValue();
        break;
        label115:
        this.zznu.remove(i);
        this.zznu.add(i, paramHashMap);
      }
    }
  }
  
  public static class DataHolderException
    extends RuntimeException
  {
    public DataHolderException(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.data.DataHolder
 * JD-Core Version:    0.7.0.1
 */