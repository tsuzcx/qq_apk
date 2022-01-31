package com.facebook.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;

class FileLruCache$CloseCallbackOutputStream
  extends OutputStream
{
  final FileLruCache.StreamCloseCallback callback;
  final OutputStream innerStream;
  
  FileLruCache$CloseCallbackOutputStream(OutputStream paramOutputStream, FileLruCache.StreamCloseCallback paramStreamCloseCallback)
  {
    this.innerStream = paramOutputStream;
    this.callback = paramStreamCloseCallback;
  }
  
  public void close()
  {
    AppMethodBeat.i(72331);
    try
    {
      this.innerStream.close();
      return;
    }
    finally
    {
      this.callback.onClose();
      AppMethodBeat.o(72331);
    }
  }
  
  public void flush()
  {
    AppMethodBeat.i(72332);
    this.innerStream.flush();
    AppMethodBeat.o(72332);
  }
  
  public void write(int paramInt)
  {
    AppMethodBeat.i(72335);
    this.innerStream.write(paramInt);
    AppMethodBeat.o(72335);
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(72334);
    this.innerStream.write(paramArrayOfByte);
    AppMethodBeat.o(72334);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(72333);
    this.innerStream.write(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(72333);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.internal.FileLruCache.CloseCallbackOutputStream
 * JD-Core Version:    0.7.0.1
 */