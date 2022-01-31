package com.facebook.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.concurrent.atomic.AtomicLong;

class FileLruCache$1
  implements FileLruCache.StreamCloseCallback
{
  FileLruCache$1(FileLruCache paramFileLruCache, long paramLong, File paramFile, String paramString) {}
  
  public void onClose()
  {
    AppMethodBeat.i(72323);
    if (this.val$bufferFileCreateTime < FileLruCache.access$000(this.this$0).get())
    {
      this.val$buffer.delete();
      AppMethodBeat.o(72323);
      return;
    }
    FileLruCache.access$100(this.this$0, this.val$key, this.val$buffer);
    AppMethodBeat.o(72323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.internal.FileLruCache.1
 * JD-Core Version:    0.7.0.1
 */