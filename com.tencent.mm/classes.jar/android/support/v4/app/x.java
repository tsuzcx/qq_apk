package android.support.v4.app;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;
import android.os.Bundle;
import java.util.Set;

public final class x
{
  final boolean IA;
  final Set<String> IB;
  final String Ix;
  final CharSequence Iy;
  final CharSequence[] Iz;
  final Bundle mExtras;
  
  public x(String paramString, CharSequence paramCharSequence, CharSequence[] paramArrayOfCharSequence, boolean paramBoolean, Bundle paramBundle, Set<String> paramSet)
  {
    this.Ix = paramString;
    this.Iy = paramCharSequence;
    this.Iz = paramArrayOfCharSequence;
    this.IA = paramBoolean;
    this.mExtras = paramBundle;
    this.IB = paramSet;
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
      arrayOfRemoteInput[i] = new RemoteInput.Builder(localx.Ix).setLabel(localx.Iy).setChoices(localx.Iz).setAllowFreeFormInput(localx.IA).addExtras(localx.mExtras).build();
      i += 1;
    }
    return arrayOfRemoteInput;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.x
 * JD-Core Version:    0.7.0.1
 */