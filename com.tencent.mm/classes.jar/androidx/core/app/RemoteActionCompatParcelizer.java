package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class RemoteActionCompatParcelizer
{
  public static RemoteActionCompat read(a parama)
  {
    AppMethodBeat.i(196400);
    RemoteActionCompat localRemoteActionCompat = new RemoteActionCompat();
    localRemoteActionCompat.bob = ((IconCompat)parama.d(localRemoteActionCompat.bob));
    localRemoteActionCompat.cZ = parama.d(localRemoteActionCompat.cZ, 2);
    localRemoteActionCompat.lT = parama.d(localRemoteActionCompat.lT, 3);
    localRemoteActionCompat.bpI = ((PendingIntent)parama.b(localRemoteActionCompat.bpI, 4));
    localRemoteActionCompat.mEnabled = parama.d(localRemoteActionCompat.mEnabled, 5);
    localRemoteActionCompat.bpJ = parama.d(localRemoteActionCompat.bpJ, 6);
    AppMethodBeat.o(196400);
    return localRemoteActionCompat;
  }
  
  public static void write(RemoteActionCompat paramRemoteActionCompat, a parama)
  {
    AppMethodBeat.i(196410);
    parama.a(paramRemoteActionCompat.bob);
    parama.c(paramRemoteActionCompat.cZ, 2);
    parama.c(paramRemoteActionCompat.lT, 3);
    parama.a(paramRemoteActionCompat.bpI, 4);
    parama.c(paramRemoteActionCompat.mEnabled, 5);
    parama.c(paramRemoteActionCompat.bpJ, 6);
    AppMethodBeat.o(196410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.app.RemoteActionCompatParcelizer
 * JD-Core Version:    0.7.0.1
 */