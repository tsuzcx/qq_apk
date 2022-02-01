package com.tencent.d.e.b.a.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.Parcel;
import com.tencent.d.e.b.a.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends d
{
  public final String a(Context paramContext, IBinder paramIBinder)
  {
    int i = 0;
    AppMethodBeat.i(138444);
    String str = paramContext.getPackageName();
    paramContext = b.cr(paramContext, str);
    if (paramContext != null)
    {
      int j = paramContext.length;
      if (i < j)
      {
        localObject = paramContext[i];
        if (!"SHA1".equals("SHA1")) {}
      }
    }
    for (paramContext = b.a((Signature)localObject, "SHA1");; paramContext = null)
    {
      localObject = Parcel.obtain();
      localParcel = Parcel.obtain();
      try
      {
        ((Parcel)localObject).writeInterfaceToken("com.heytap.openid.IOpenID");
        ((Parcel)localObject).writeString(str);
        ((Parcel)localObject).writeString(paramContext);
        ((Parcel)localObject).writeString("OUID");
        paramIBinder.transact(1, (Parcel)localObject, localParcel, 0);
        localParcel.readException();
        paramContext = localParcel.readString();
        return paramContext;
      }
      finally
      {
        localParcel.recycle();
        ((Parcel)localObject).recycle();
        AppMethodBeat.o(138444);
      }
      i += 1;
      break;
    }
  }
  
  public final Intent getIntent()
  {
    AppMethodBeat.i(138443);
    Intent localIntent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
    localIntent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
    AppMethodBeat.o(138443);
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.d.e.b.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */