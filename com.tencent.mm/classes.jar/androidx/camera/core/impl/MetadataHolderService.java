package androidx.camera.core.impl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MetadataHolderService
  extends Service
{
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(198761);
    paramIntent = new UnsupportedOperationException();
    AppMethodBeat.o(198761);
    throw paramIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.camera.core.impl.MetadataHolderService
 * JD-Core Version:    0.7.0.1
 */