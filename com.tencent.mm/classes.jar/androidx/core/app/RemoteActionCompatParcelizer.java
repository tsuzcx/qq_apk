package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class RemoteActionCompatParcelizer
{
  public static RemoteActionCompat read(a parama)
  {
    AppMethodBeat.i(250455);
    RemoteActionCompat localRemoteActionCompat = new RemoteActionCompat();
    localRemoteActionCompat.HY = ((IconCompat)parama.d(localRemoteActionCompat.HY));
    localRemoteActionCompat.cZ = parama.d(localRemoteActionCompat.cZ, 2);
    localRemoteActionCompat.kX = parama.d(localRemoteActionCompat.kX, 3);
    localRemoteActionCompat.JF = ((PendingIntent)parama.b(localRemoteActionCompat.JF, 4));
    localRemoteActionCompat.mEnabled = parama.d(localRemoteActionCompat.mEnabled, 5);
    localRemoteActionCompat.JG = parama.d(localRemoteActionCompat.JG, 6);
    AppMethodBeat.o(250455);
    return localRemoteActionCompat;
  }
  
  public static void write(RemoteActionCompat paramRemoteActionCompat, a parama)
  {
    AppMethodBeat.i(250457);
    parama.a(paramRemoteActionCompat.HY);
    parama.c(paramRemoteActionCompat.cZ, 2);
    parama.c(paramRemoteActionCompat.kX, 3);
    parama.a(paramRemoteActionCompat.JF, 4);
    parama.c(paramRemoteActionCompat.mEnabled, 5);
    parama.c(paramRemoteActionCompat.JG, 6);
    AppMethodBeat.o(250457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.core.app.RemoteActionCompatParcelizer
 * JD-Core Version:    0.7.0.1
 */