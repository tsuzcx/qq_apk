package android.support.v4.app;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;
import android.os.Bundle;
import java.util.Set;

public final class ac
{
  final Bundle mExtras;
  final String yL;
  final CharSequence yM;
  final CharSequence[] yN;
  final boolean yO;
  final Set<String> yP;
  
  public ac(String paramString, CharSequence paramCharSequence, CharSequence[] paramArrayOfCharSequence, boolean paramBoolean, Bundle paramBundle, Set<String> paramSet)
  {
    this.yL = paramString;
    this.yM = paramCharSequence;
    this.yN = paramArrayOfCharSequence;
    this.yO = paramBoolean;
    this.mExtras = paramBundle;
    this.yP = paramSet;
  }
  
  static RemoteInput[] b(ac[] paramArrayOfac)
  {
    if (paramArrayOfac == null) {
      return null;
    }
    RemoteInput[] arrayOfRemoteInput = new RemoteInput[paramArrayOfac.length];
    int i = 0;
    while (i < paramArrayOfac.length)
    {
      ac localac = paramArrayOfac[i];
      arrayOfRemoteInput[i] = new RemoteInput.Builder(localac.yL).setLabel(localac.yM).setChoices(localac.yN).setAllowFreeFormInput(localac.yO).addExtras(localac.mExtras).build();
      i += 1;
    }
    return arrayOfRemoteInput;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v4.app.ac
 * JD-Core Version:    0.7.0.1
 */