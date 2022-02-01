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
    AppMethodBeat.i(4952);
    if (zzvr == null) {
      zzvr = new SocketFactoryCreator();
    }
    SocketFactoryCreator localSocketFactoryCreator = zzvr;
    AppMethodBeat.o(4952);
    return localSocketFactoryCreator;
  }
  
  protected ISocketFactoryCreator getRemoteCreator(IBinder paramIBinder)
  {
    AppMethodBeat.i(4951);
    paramIBinder = ISocketFactoryCreator.Stub.asInterface(paramIBinder);
    AppMethodBeat.o(4951);
    return paramIBinder;
  }
  
  public SSLSocketFactory makeSocketFactory(Context paramContext, KeyManager[] paramArrayOfKeyManager, TrustManager[] paramArrayOfTrustManager, boolean paramBoolean)
  {
    AppMethodBeat.i(4949);
    try
    {
      paramContext = (SSLSocketFactory)ObjectWrapper.unwrap(((ISocketFactoryCreator)getRemoteCreatorInstance(paramContext)).newSocketFactory(ObjectWrapper.wrap(paramContext), ObjectWrapper.wrap(paramArrayOfKeyManager), ObjectWrapper.wrap(paramArrayOfTrustManager), paramBoolean));
      AppMethodBeat.o(4949);
      return paramContext;
    }
    catch (RemoteException paramContext)
    {
      paramContext = new RuntimeException(paramContext);
      AppMethodBeat.o(4949);
      throw paramContext;
    }
    catch (RemoteCreator.RemoteCreatorException paramContext)
    {
      label49:
      break label49;
    }
  }
  
  public SSLSocketFactory makeSocketFactoryWithCacheDir(Context paramContext, KeyManager[] paramArrayOfKeyManager, TrustManager[] paramArrayOfTrustManager, String paramString)
  {
    AppMethodBeat.i(4950);
    try
    {
      paramContext = (SSLSocketFactory)ObjectWrapper.unwrap(((ISocketFactoryCreator)getRemoteCreatorInstance(paramContext)).newSocketFactoryWithCacheDir(ObjectWrapper.wrap(paramContext), ObjectWrapper.wrap(paramArrayOfKeyManager), ObjectWrapper.wrap(paramArrayOfTrustManager), paramString));
      AppMethodBeat.o(4950);
      return paramContext;
    }
    catch (RemoteException paramContext)
    {
      paramContext = new RuntimeException(paramContext);
      AppMethodBeat.o(4950);
      throw paramContext;
    }
    catch (RemoteCreator.RemoteCreatorException paramContext)
    {
      label49:
      break label49;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.net.SocketFactoryCreator
 * JD-Core Version:    0.7.0.1
 */