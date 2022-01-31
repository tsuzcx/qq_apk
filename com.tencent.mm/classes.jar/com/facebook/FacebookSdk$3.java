package com.facebook;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.concurrent.Callable;

final class FacebookSdk$3
  implements Callable<File>
{
  public final File call()
  {
    AppMethodBeat.i(71600);
    File localFile = FacebookSdk.access$000().getCacheDir();
    AppMethodBeat.o(71600);
    return localFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.FacebookSdk.3
 * JD-Core Version:    0.7.0.1
 */