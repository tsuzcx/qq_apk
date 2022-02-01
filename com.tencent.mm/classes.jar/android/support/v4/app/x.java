package android.support.v4.app;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;
import android.os.Bundle;
import java.util.Set;

public final class x
{
  final String II;
  final CharSequence IJ;
  final CharSequence[] IK;
  final boolean IL;
  final Set<String> IM;
  final Bundle mExtras;
  
  public x(String paramString, CharSequence paramCharSequence, CharSequence[] paramArrayOfCharSequence, boolean paramBoolean, Bundle paramBundle, Set<String> paramSet)
  {
    this.II = paramString;
    this.IJ = paramCharSequence;
    this.IK = paramArrayOfCharSequence;
    this.IL = paramBoolean;
    this.mExtras = paramBundle;
    this.IM = paramSet;
  }
  
  static RemoteInput[] b(x[] paramArrayOfx)
  {
    if (paramArrayOfx == null) {
      return null;
    }
    RemoteInput[] arrayOfRemoteInput = new RemoteInput[paramArrayOfx.length];
    int i = 0;
    while (i < paramArrayOfx.length)
    {
      x localx = paramArrayOfx[i];
      arrayOfRemoteInput[i] = new RemoteInput.Builder(localx.II).setLabel(localx.IJ).setChoices(localx.IK).setAllowFreeFormInput(localx.IL).addExtras(localx.mExtras).build();
      i += 1;
    }
    return arrayOfRemoteInput;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.x
 * JD-Core Version:    0.7.0.1
 */