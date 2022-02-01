package androidx.core.app;

import android.app.RemoteInput.Builder;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f$e
  implements f.f
{
  private Bitmap bou;
  public f.e.a bpb;
  private int mColor = 0;
  
  private static Bundle a(f.e.a parama)
  {
    int i = 0;
    AppMethodBeat.i(196448);
    Bundle localBundle1 = new Bundle();
    Parcelable[] arrayOfParcelable = null;
    Object localObject = arrayOfParcelable;
    if (parama.bpg != null)
    {
      localObject = arrayOfParcelable;
      if (parama.bpg.length > 1) {
        localObject = parama.bpg[0];
      }
    }
    arrayOfParcelable = new Parcelable[parama.bpc.length];
    while (i < arrayOfParcelable.length)
    {
      Bundle localBundle2 = new Bundle();
      localBundle2.putString("text", parama.bpc[i]);
      localBundle2.putString("author", (String)localObject);
      arrayOfParcelable[i] = localBundle2;
      i += 1;
    }
    localBundle1.putParcelableArray("messages", arrayOfParcelable);
    localObject = parama.bpd;
    if (localObject != null) {
      localBundle1.putParcelable("remote_input", new RemoteInput.Builder(((j)localObject).bpK).setLabel(((j)localObject).bpL).setChoices(((j)localObject).bpM).setAllowFreeFormInput(((j)localObject).bpN).addExtras(((j)localObject).mExtras).build());
    }
    localBundle1.putParcelable("on_reply", parama.bpe);
    localBundle1.putParcelable("on_read", parama.bpf);
    localBundle1.putStringArray("participants", parama.bpg);
    localBundle1.putLong("timestamp", parama.bph);
    AppMethodBeat.o(196448);
    return localBundle1;
  }
  
  public final f.d a(f.d paramd)
  {
    AppMethodBeat.i(196458);
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(196458);
      return paramd;
    }
    Bundle localBundle = new Bundle();
    if (this.bou != null) {
      localBundle.putParcelable("large_icon", this.bou);
    }
    if (this.mColor != 0) {
      localBundle.putInt("app_color", this.mColor);
    }
    if (this.bpb != null) {
      localBundle.putBundle("car_conversation", a(this.bpb));
    }
    paramd.getExtras().putBundle("android.car.EXTENSIONS", localBundle);
    AppMethodBeat.o(196458);
    return paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.core.app.f.e
 * JD-Core Version:    0.7.0.1
 */