package androidx.core.app;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Set;

public final class j
{
  final String bpK;
  final CharSequence bpL;
  final CharSequence[] bpM;
  final boolean bpN;
  private final int bpO;
  final Set<String> bpP;
  final Bundle mExtras;
  
  public j(String paramString, CharSequence paramCharSequence, CharSequence[] paramArrayOfCharSequence, boolean paramBoolean, int paramInt, Bundle paramBundle, Set<String> paramSet)
  {
    AppMethodBeat.i(196357);
    this.bpK = paramString;
    this.bpL = paramCharSequence;
    this.bpM = paramArrayOfCharSequence;
    this.bpN = paramBoolean;
    this.bpO = paramInt;
    this.mExtras = paramBundle;
    this.bpP = paramSet;
    if ((this.bpO == 2) && (!this.bpN))
    {
      paramString = new IllegalArgumentException("setEditChoicesBeforeSending requires setAllowFreeFormInput");
      AppMethodBeat.o(196357);
      throw paramString;
    }
    AppMethodBeat.o(196357);
  }
  
  static RemoteInput[] b(j[] paramArrayOfj)
  {
    AppMethodBeat.i(196369);
    if (paramArrayOfj == null)
    {
      AppMethodBeat.o(196369);
      return null;
    }
    RemoteInput[] arrayOfRemoteInput = new RemoteInput[paramArrayOfj.length];
    int i = 0;
    while (i < paramArrayOfj.length)
    {
      j localj = paramArrayOfj[i];
      RemoteInput.Builder localBuilder = new RemoteInput.Builder(localj.bpK).setLabel(localj.bpL).setChoices(localj.bpM).setAllowFreeFormInput(localj.bpN).addExtras(localj.mExtras);
      if (Build.VERSION.SDK_INT >= 26)
      {
        Object localObject = localj.bpP;
        if (localObject != null)
        {
          localObject = ((Set)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            localBuilder.setAllowDataType((String)((Iterator)localObject).next(), true);
          }
        }
      }
      if (Build.VERSION.SDK_INT >= 29) {
        localBuilder.setEditChoicesBeforeSending(localj.bpO);
      }
      arrayOfRemoteInput[i] = localBuilder.build();
      i += 1;
    }
    AppMethodBeat.o(196369);
    return arrayOfRemoteInput;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.core.app.j
 * JD-Core Version:    0.7.0.1
 */