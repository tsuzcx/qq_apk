package com.google.android.gms.common.net;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamic.RemoteCreator.RemoteCreatorException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public class SocketFactoryCreator
  extends RemoteCreator<ISocketFactoryCreator>
{
  private static SocketFactoryCreator zzvr;
  
  protected SocketFactoryCreator()
  {
    super("com.google.android.gms.common.net.SocketFactoryCreatorImpl");
  }
  
  public static SocketFactoryCreator getInstance()
  {
    AppMethodBeat.i(89930);
    if (zzvr == null) {
      zzvr = new SocketFactoryCreator();
    }
    SocketFactoryCreator localSocketFactoryCreator = zzvr;
    AppMethodBeat.o(89930);
    return localSocketFactoryCreator;
  }
  
  protected ISocketFactoryCreator getRemoteCreator(IBinder paramIBinder)
  {
    AppMethodBeat.i(89929);
    paramIBinder = ISocketFactoryCreator.Stub.asInterface(paramIBinder);
    AppMethodBeat.o(89929);
    return paramIBinder;
  }
  
  public SSLSocketFactory makeSocketFactory(Context paramContext, KeyManager[] paramArrayOfKeyManager, TrustManager[] paramArrayOfTrustManager, boolean paramBoolean)
  {
    AppMethodBeat.i(89927);
    try
    {
      paramContext = (SSLSocketFactory)ObjectWrapper.unwrap(((ISocketFactoryCreator)getRemoteCreatorInstance(paramContext)).newSocketFactory(ObjectWrapper.wrap(paramContext), ObjectWrapper.wrap(paramArrayOfKeyManager), ObjectWrapper.wrap(paramArrayOfTrustManager), paramBoolean));
      AppMethodBeat.o(89927);
      return paramContext;
    }
    catch (RemoteException paramContext)
    {
      paramContext = new RuntimeException(paramContext);
      AppMethodBeat.o(89927);
      throw paramContext;
    }
    catch (RemoteCreator.RemoteCreatorException paramContext)
    {
      label47:
      break label47;
    }
  }
  
  public SSLSocketFactory makeSocketFactoryWithCacheDir(Context paramContext, KeyManager[] paramArrayOfKeyManager, TrustManager[] paramArrayOfTrustManager, String paramString)
  {
    AppMethodBeat.i(89928);
    try
    {
      paramContext = (SSLSocketFactory)ObjectWrapper.unwrap(((ISocketFactoryCreator)getRemoteCreatorInstance(paramContext)).newSocketFactoryWithCacheDir(ObjectWrapper.wrap(paramContext), ObjectWrapper.wrap(paramArrayOfKeyManager), ObjectWrapper.wrap(paramArrayOfTrustManager), paramString));
      AppMethodBeat.o(89928);
      return paramContext;
    }
    catch (RemoteException paramContext)
    {
      paramContext = new RuntimeException(paramContext);
      AppMethodBeat.o(89928);
      throw paramContext;
    }
    catch (RemoteCreator.RemoteCreatorException paramContext)
    {
      label47:
      break label47;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.net.SocketFactoryCreator
 * JD-Core Version:    0.7.0.1
 */