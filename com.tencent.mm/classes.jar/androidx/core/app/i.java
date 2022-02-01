package androidx.core.app;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;

public final class i
{
  final String JH;
  final CharSequence JI;
  final CharSequence[] JJ;
  final boolean JK;
  private final int JL;
  final Set<String> JM;
  final Bundle mExtras;
  
  public i(String paramString, CharSequence paramCharSequence, CharSequence[] paramArrayOfCharSequence, boolean paramBoolean, int paramInt, Bundle paramBundle, Set<String> paramSet)
  {
    AppMethodBeat.i(250461);
    this.JH = paramString;
    this.JI = paramCharSequence;
    this.JJ = paramArrayOfCharSequence;
    this.JK = paramBoolean;
    this.JL = paramInt;
    this.mExtras = paramBundle;
    this.JM = paramSet;
    if ((this.JL == 2) && (!this.JK))
    {
      paramString = new IllegalArgumentException("setEditChoicesBeforeSending requires setAllowFreeFormInput");
      AppMethodBeat.o(250461);
      throw paramString;
    }
    AppMethodBeat.o(250461);
  }
  
  static RemoteInput[] b(i[] paramArrayOfi)
  {
    AppMethodBeat.i(250462);
    if (paramArrayOfi == null)
    {
      AppMethodBeat.o(250462);
      return null;
    }
    RemoteInput[] arrayOfRemoteInput = new RemoteInput[paramArrayOfi.length];
    int i = 0;
    while (i < paramArrayOfi.length)
    {
      i locali = paramArrayOfi[i];
      RemoteInput.Builder localBuilder = new RemoteInput.Builder(locali.JH).setLabel(locali.JI).setChoices(locali.JJ).setAllowFreeFormInput(locali.JK).addExtras(locali.mExtras);
      if (Build.VERSION.SDK_INT >= 29) {
        localBuilder.setEditChoicesBeforeSending(locali.JL);
      }
      arrayOfRemoteInput[i] = localBuilder.build();
      i += 1;
    }
    AppMethodBeat.o(250462);
    return arrayOfRemoteInput;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.core.app.i
 * JD-Core Version:    0.7.0.1
 */