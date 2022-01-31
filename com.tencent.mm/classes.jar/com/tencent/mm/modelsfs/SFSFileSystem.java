package com.tencent.mm.modelsfs;

import android.os.CancellationSignal;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.StatFs;
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
  public static final Parcelable.Creator<SFSFileSystem> CREATOR = new SFSFileSystem.1();
  private SFSContext eyL;
  private final SFSContext.Builder eyM;
  
  private SFSFileSystem(Parcel paramParcel)
  {
    this.eyM = ((SFSContext.Builder)paramParcel.readParcelable(SFSContext.class.getClassLoader()));
  }
  
  private void Qc()
  {
    if (this.eyL == null) {
      this.eyL = this.eyM.create();
    }
  }
  
  private FileSystem.a a(SFSContext.FileEntry paramFileEntry)
  {
    return new FileSystem.a(this, paramFileEntry.name, paramFileEntry.name.substring(paramFileEntry.name.lastIndexOf('/') + 1), paramFileEntry.size, paramFileEntry.size + 4095L & 0xFFFFF000, paramFileEntry.timestamp, false);
  }
  
  public final OutputStream I(String paramString, boolean paramBoolean)
  {
    Qc();
    return this.eyL.jI(paramString);
  }
  
  public final List<FileSystem.a> J(String paramString, boolean paramBoolean)
  {
    Qc();
    try
    {
      Object localObject = this.eyL.mX(paramString);
      paramString = new ArrayList(((List)localObject).size());
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramString.add(a((SFSContext.FileEntry)((Iterator)localObject).next()));
      }
      return paramString;
    }
    catch (IOException paramString)
    {
      return null;
    }
  }
  
  public final boolean K(String paramString, boolean paramBoolean)
  {
    Qc();
    try
    {
      paramString = this.eyL.mX(paramString).iterator();
      while (paramString.hasNext())
      {
        SFSContext.FileEntry localFileEntry = (SFSContext.FileEntry)paramString.next();
        this.eyL.jJ(localFileEntry.name);
      }
      return true;
    }
    catch (IOException paramString)
    {
      return false;
    }
  }
  
  public final String L(String paramString, boolean paramBoolean)
  {
    return null;
  }
  
  public final int Qd()
  {
    return 9;
  }
  
  public final void a(CancellationSignal paramCancellationSignal) {}
  
  public final boolean aC(String paramString1, String paramString2)
  {
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean exists(String paramString)
  {
    Qc();
    return this.eyL.exists(paramString);
  }
  
  public final boolean jJ(String paramString)
  {
    Qc();
    return this.eyL.jJ(paramString);
  }
  
  public final void m(Map<String, String> paramMap) {}
  
  public final FileSystem.b mZ(String paramString)
  {
    paramString = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
    FileSystem.b localb = new FileSystem.b();
    localb.uib = paramString.getBlockSize();
    localb.uia = paramString.getAvailableBlocks();
    localb.uhY = paramString.getBlockCount();
    localb.wux = (localb.uia * localb.uib);
    localb.wuy = (localb.uhY * localb.uib);
    return localb;
  }
  
  public final FileSystem.a na(String paramString)
  {
    Qc();
    paramString = this.eyL.mY(paramString);
    if (paramString == null) {
      return null;
    }
    return a(paramString);
  }
  
  public final boolean nb(String paramString)
  {
    return true;
  }
  
  public final InputStream openRead(String paramString)
  {
    Qc();
    return this.eyL.openRead(paramString);
  }
  
  public final boolean r(String paramString, long paramLong)
  {
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.eyM, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelsfs.SFSFileSystem
 * JD-Core Version:    0.7.0.1
 */