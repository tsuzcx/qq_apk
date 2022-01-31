package com.tencent.mm.modelsfs;

import android.os.CancellationSignal;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.FileSystem;
import com.tencent.mm.vfs.FileSystem.a;
import com.tencent.mm.vfs.FileSystem.b;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SFSFileSystem
  implements FileSystem
{
  public static final Parcelable.Creator<SFSFileSystem> CREATOR;
  private final SFSContext.Builder fOA;
  private SFSContext fOz;
  
  static
  {
    AppMethodBeat.i(93254);
    CREATOR = new SFSFileSystem.1();
    AppMethodBeat.o(93254);
  }
  
  private SFSFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(93242);
    this.fOA = ((SFSContext.Builder)paramParcel.readParcelable(SFSContext.class.getClassLoader()));
    AppMethodBeat.o(93242);
  }
  
  private FileSystem.a a(SFSContext.FileEntry paramFileEntry)
  {
    AppMethodBeat.i(93248);
    paramFileEntry = new FileSystem.a(this, paramFileEntry.name, paramFileEntry.name.substring(paramFileEntry.name.lastIndexOf('/') + 1), paramFileEntry.size, paramFileEntry.size + 4095L & 0xFFFFF000, paramFileEntry.timestamp, false);
    AppMethodBeat.o(93248);
    return paramFileEntry;
  }
  
  private void aji()
  {
    AppMethodBeat.i(93243);
    if (this.fOz == null) {
      this.fOz = this.fOA.create();
    }
    AppMethodBeat.o(93243);
  }
  
  public final boolean A(String paramString, long paramLong)
  {
    return false;
  }
  
  public final OutputStream M(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(93246);
    aji();
    paramString = this.fOz.qC(paramString);
    AppMethodBeat.o(93246);
    return paramString;
  }
  
  public final List<FileSystem.a> N(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(93251);
    aji();
    try
    {
      Object localObject = this.fOz.ui(paramString);
      paramString = new ArrayList(((List)localObject).size());
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramString.add(a((SFSContext.FileEntry)((Iterator)localObject).next()));
      }
      AppMethodBeat.o(93251);
    }
    catch (IOException paramString)
    {
      AppMethodBeat.o(93251);
      return null;
    }
    return paramString;
  }
  
  public final boolean O(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(93252);
    aji();
    try
    {
      paramString = this.fOz.ui(paramString).iterator();
      while (paramString.hasNext())
      {
        SFSContext.FileEntry localFileEntry = (SFSContext.FileEntry)paramString.next();
        this.fOz.qD(localFileEntry.name);
      }
      AppMethodBeat.o(93252);
    }
    catch (IOException paramString)
    {
      AppMethodBeat.o(93252);
      return false;
    }
    return true;
  }
  
  public final String P(String paramString, boolean paramBoolean)
  {
    return null;
  }
  
  public final void a(CancellationSignal paramCancellationSignal) {}
  
  public final boolean aV(String paramString1, String paramString2)
  {
    return false;
  }
  
  public final int ajj()
  {
    return 9;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean exists(String paramString)
  {
    AppMethodBeat.i(93247);
    aji();
    boolean bool = this.fOz.exists(paramString);
    AppMethodBeat.o(93247);
    return bool;
  }
  
  public final InputStream openRead(String paramString)
  {
    AppMethodBeat.i(93245);
    aji();
    paramString = this.fOz.openRead(paramString);
    AppMethodBeat.o(93245);
    return paramString;
  }
  
  public final void q(Map<String, String> paramMap) {}
  
  public final boolean qD(String paramString)
  {
    AppMethodBeat.i(93250);
    aji();
    boolean bool = this.fOz.qD(paramString);
    AppMethodBeat.o(93250);
    return bool;
  }
  
  public final FileSystem.b uk(String paramString)
  {
    AppMethodBeat.i(93244);
    paramString = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
    FileSystem.b localb = new FileSystem.b();
    localb.yqh = paramString.getBlockSize();
    localb.yqg = paramString.getAvailableBlocks();
    localb.yqe = paramString.getBlockCount();
    localb.APw = (localb.yqg * localb.yqh);
    localb.bau = (localb.yqe * localb.yqh);
    AppMethodBeat.o(93244);
    return localb;
  }
  
  public final FileSystem.a ul(String paramString)
  {
    AppMethodBeat.i(93249);
    aji();
    paramString = this.fOz.uj(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(93249);
      return null;
    }
    paramString = a(paramString);
    AppMethodBeat.o(93249);
    return paramString;
  }
  
  public final boolean um(String paramString)
  {
    return true;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(93253);
    paramParcel.writeParcelable(this.fOA, paramInt);
    AppMethodBeat.o(93253);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelsfs.SFSFileSystem
 * JD-Core Version:    0.7.0.1
 */