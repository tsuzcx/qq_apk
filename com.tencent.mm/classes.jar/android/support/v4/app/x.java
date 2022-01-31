package android.support.v4.app;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;

public final class x
{
  final Bundle mExtras;
  final String zn;
  final CharSequence zo;
  final CharSequence[] zp;
  final boolean zq;
  final Set<String> zr;
  
  public x(String paramString, CharSequence paramCharSequence, CharSequence[] paramArrayOfCharSequence, boolean paramBoolean, Bundle paramBundle, Set<String> paramSet)
  {
    this.zn = paramString;
    this.zo = paramCharSequence;
    this.zp = paramArrayOfCharSequence;
    this.zq = paramBoolean;
    this.mExtras = paramBundle;
    this.zr = paramSet;
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
      arrayOfRemoteInput[i] = new RemoteInput.Builder(localx.zn).setLabel(localx.zo).setChoices(localx.zp).setAllowFreeFormInput(localx.zq).addExtras(localx.mExtras).build();
      i += 1;
    }
    return arrayOfRemoteInput;
  }
  
  public static final class a
  {
    public final Bundle mExtras = new Bundle();
    public final String zn;
    public CharSequence zo;
    public CharSequence[] zp;
    public boolean zq = true;
    public final Set<String> zr = new HashSet();
    
    public a(String paramString)
    {
      this.zn = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.x
 * JD-Core Version:    0.7.0.1
 */