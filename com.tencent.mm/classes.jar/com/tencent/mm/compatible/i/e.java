package com.tencent.mm.compatible.i;

import android.media.MediaRecorder;
import android.os.ParcelFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;

public final class e
  extends MediaRecorder
{
  private FileDescriptor lZn;
  private u mFile;
  
  public final void prepare()
  {
    AppMethodBeat.i(155943);
    if (this.lZn != null)
    {
      super.setOutputFile(this.lZn);
      super.prepare();
      AppMethodBeat.o(155943);
      return;
    }
    if (this.mFile != null)
    {
      u localu = this.mFile;
      ParcelFileDescriptor localParcelFileDescriptor = y.a(localu.mUri, localu.jKM(), "rw");
      try
      {
        super.setOutputFile(localParcelFileDescriptor.getFileDescriptor());
        super.prepare();
        if (localParcelFileDescriptor != null)
        {
          localParcelFileDescriptor.close();
          AppMethodBeat.o(155943);
          return;
        }
      }
      finally
      {
        if (localParcelFileDescriptor != null) {}
        try
        {
          localParcelFileDescriptor.close();
          AppMethodBeat.o(155943);
          throw localObject;
        }
        finally
        {
          localObject.addSuppressed(localThrowable);
        }
        AppMethodBeat.o(155943);
        return;
      }
    }
    IOException localIOException = new IOException("No valid output file");
    AppMethodBeat.o(155943);
    throw localIOException;
  }
  
  @Deprecated
  public final void setOutputFile(File paramFile)
  {
    AppMethodBeat.i(155942);
    setOutputFile(paramFile.getPath());
    AppMethodBeat.o(155942);
  }
  
  public final void setOutputFile(FileDescriptor paramFileDescriptor)
  {
    this.mFile = null;
    this.lZn = paramFileDescriptor;
  }
  
  public final void setOutputFile(String paramString)
  {
    AppMethodBeat.i(155941);
    if (paramString == null) {}
    for (paramString = null;; paramString = new u(paramString))
    {
      this.mFile = paramString;
      this.lZn = null;
      AppMethodBeat.o(155941);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.compatible.i.e
 * JD-Core Version:    0.7.0.1
 */