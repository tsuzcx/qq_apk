package com.google.android.gms.common.net;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.security.PrivateKey;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public class SSLCertificateSocketFactory
  extends SSLSocketFactory
{
  private static final TrustManager[] zzvf;
  @VisibleForTesting
  private final Context mContext;
  @VisibleForTesting
  private SSLSocketFactory zzvg;
  @VisibleForTesting
  private SSLSocketFactory zzvh;
  @VisibleForTesting
  private TrustManager[] zzvi;
  @VisibleForTesting
  private KeyManager[] zzvj;
  @VisibleForTesting
  private byte[] zzvk;
  @VisibleForTesting
  private byte[] zzvl;
  @VisibleForTesting
  private PrivateKey zzvm;
  @VisibleForTesting
  private final int zzvn;
  @VisibleForTesting
  private final boolean zzvo;
  @VisibleForTesting
  private final boolean zzvp;
  @VisibleForTesting
  private final String zzvq;
  
  static
  {
    AppMethodBeat.i(4948);
    zzvf = new TrustManager[] { new zza() };
    AppMethodBeat.o(4948);
  }
  
  private SSLCertificateSocketFactory(Context paramContext, int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    AppMethodBeat.i(4921);
    this.zzvg = null;
    this.zzvh = null;
    this.zzvi = null;
    this.zzvj = null;
    this.zzvk = null;
    this.zzvl = null;
    this.zzvm = null;
    this.mContext = paramContext.getApplicationContext();
    this.zzvn = paramInt;
    this.zzvo = paramBoolean1;
    this.zzvp = paramBoolean2;
    this.zzvq = paramString;
    AppMethodBeat.o(4921);
  }
  
  public static SocketFactory getDefault(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(4922);
    paramContext = new SSLCertificateSocketFactory(paramContext, paramInt, false, true, null);
    AppMethodBeat.o(4922);
    return paramContext;
  }
  
  public static SSLSocketFactory getDefaultWithCacheDir(int paramInt, Context paramContext, String paramString)
  {
    AppMethodBeat.i(4924);
    paramContext = new SSLCertificateSocketFactory(paramContext, paramInt, true, true, paramString);
    AppMethodBeat.o(4924);
    return paramContext;
  }
  
  public static SSLSocketFactory getDefaultWithSessionCache(int paramInt, Context paramContext)
  {
    AppMethodBeat.i(4923);
    paramContext = new SSLCertificateSocketFactory(paramContext, paramInt, true, true, null);
    AppMethodBeat.o(4923);
    return paramContext;
  }
  
  public static SSLSocketFactory getInsecure(Context paramContext, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(4925);
    paramContext = new SSLCertificateSocketFactory(paramContext, paramInt, paramBoolean, false, null);
    AppMethodBeat.o(4925);
    return paramContext;
  }
  
  public static void verifyHostname(Socket paramSocket, String paramString)
  {
    AppMethodBeat.i(4926);
    if (!(paramSocket instanceof SSLSocket))
    {
      paramSocket = new IllegalArgumentException("Attempt to verify non-SSL socket");
      AppMethodBeat.o(4926);
      throw paramSocket;
    }
    paramSocket = (SSLSocket)paramSocket;
    paramSocket.startHandshake();
    paramSocket = paramSocket.getSession();
    if (paramSocket == null)
    {
      paramSocket = new SSLException("Cannot verify SSL socket without session");
      AppMethodBeat.o(4926);
      throw paramSocket;
    }
    if (!HttpsURLConnection.getDefaultHostnameVerifier().verify(paramString, paramSocket))
    {
      paramSocket = String.valueOf(paramString);
      if (paramSocket.length() != 0) {}
      for (paramSocket = "Cannot verify hostname: ".concat(paramSocket);; paramSocket = new String("Cannot verify hostname: "))
      {
        paramSocket = new SSLPeerUnverifiedException(paramSocket);
        AppMethodBeat.o(4926);
        throw paramSocket;
      }
    }
    AppMethodBeat.o(4926);
  }
  
  @VisibleForTesting
  private static void zza(Socket paramSocket, int paramInt)
  {
    AppMethodBeat.i(4946);
    if (paramSocket != null) {}
    try
    {
      paramSocket.getClass().getMethod("setHandshakeTimeout", new Class[] { Integer.TYPE }).invoke(paramSocket, new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(4946);
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Throwable localThrowable = localInvocationTargetException.getCause();
      if ((localThrowable instanceof RuntimeException))
      {
        paramSocket = (RuntimeException)localThrowable;
        AppMethodBeat.o(4946);
        throw paramSocket;
      }
      paramSocket = String.valueOf(paramSocket.getClass());
      paramSocket = new RuntimeException(String.valueOf(paramSocket).length() + 46 + "Failed to invoke setSocketHandshakeTimeout on " + paramSocket, localInvocationTargetException);
      AppMethodBeat.o(4946);
      throw paramSocket;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      paramSocket = String.valueOf(paramSocket.getClass());
      paramSocket = new IllegalArgumentException(String.valueOf(paramSocket).length() + 45 + paramSocket + " does not implement setSocketHandshakeTimeout", localIllegalAccessException);
      AppMethodBeat.o(4946);
      throw paramSocket;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label133:
      break label133;
    }
  }
  
  @VisibleForTesting
  private static void zza(Socket paramSocket, PrivateKey paramPrivateKey)
  {
    AppMethodBeat.i(4947);
    if (paramSocket != null) {}
    try
    {
      paramSocket.getClass().getMethod("setChannelIdPrivateKey", new Class[] { PrivateKey.class }).invoke(paramSocket, new Object[] { paramPrivateKey });
      AppMethodBeat.o(4947);
      return;
    }
    catch (InvocationTargetException paramPrivateKey)
    {
      Throwable localThrowable = paramPrivateKey.getCause();
      if ((localThrowable instanceof RuntimeException))
      {
        paramSocket = (RuntimeException)localThrowable;
        AppMethodBeat.o(4947);
        throw paramSocket;
      }
      paramSocket = String.valueOf(paramSocket.getClass());
      paramSocket = new RuntimeException(String.valueOf(paramSocket).length() + 43 + "Failed to invoke setChannelIdPrivateKey on " + paramSocket, paramPrivateKey);
      AppMethodBeat.o(4947);
      throw paramSocket;
    }
    catch (IllegalAccessException paramPrivateKey)
    {
      paramSocket = String.valueOf(paramSocket.getClass());
      paramSocket = new IllegalArgumentException(String.valueOf(paramSocket).length() + 42 + paramSocket + " does not implement setChannelIdPrivateKey", paramPrivateKey);
      AppMethodBeat.o(4947);
      throw paramSocket;
    }
    catch (NoSuchMethodException paramPrivateKey)
    {
      label129:
      break label129;
    }
  }
  
  @VisibleForTesting
  private static void zza(Socket paramSocket, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(4944);
    if (paramSocket != null) {}
    try
    {
      paramSocket.getClass().getMethod("setNpnProtocols", new Class[] { [B.class }).invoke(paramSocket, new Object[] { paramArrayOfByte });
      AppMethodBeat.o(4944);
      return;
    }
    catch (InvocationTargetException paramArrayOfByte)
    {
      Throwable localThrowable = paramArrayOfByte.getCause();
      if ((localThrowable instanceof RuntimeException))
      {
        paramSocket = (RuntimeException)localThrowable;
        AppMethodBeat.o(4944);
        throw paramSocket;
      }
      paramSocket = String.valueOf(paramSocket.getClass());
      paramSocket = new RuntimeException(String.valueOf(paramSocket).length() + 36 + "Failed to invoke setNpnProtocols on " + paramSocket, paramArrayOfByte);
      AppMethodBeat.o(4944);
      throw paramSocket;
    }
    catch (IllegalAccessException paramArrayOfByte)
    {
      paramSocket = String.valueOf(paramSocket.getClass());
      paramSocket = new IllegalArgumentException(String.valueOf(paramSocket).length() + 35 + paramSocket + " does not implement setNpnProtocols", paramArrayOfByte);
      AppMethodBeat.o(4944);
      throw paramSocket;
    }
    catch (NoSuchMethodException paramArrayOfByte)
    {
      label129:
      break label129;
    }
  }
  
  private static byte[] zza(byte[]... paramVarArgs)
  {
    AppMethodBeat.i(4930);
    if (paramVarArgs.length == 0)
    {
      paramVarArgs = new IllegalArgumentException("items.length == 0");
      AppMethodBeat.o(4930);
      throw paramVarArgs;
    }
    int k = paramVarArgs.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      arrayOfByte1 = paramVarArgs[i];
      if ((arrayOfByte1.length == 0) || (arrayOfByte1.length > 255))
      {
        i = arrayOfByte1.length;
        paramVarArgs = new IllegalArgumentException(44 + "s.length == 0 || s.length > 255: " + i);
        AppMethodBeat.o(4930);
        throw paramVarArgs;
      }
      j += arrayOfByte1.length + 1;
      i += 1;
    }
    byte[] arrayOfByte1 = new byte[j];
    int m = paramVarArgs.length;
    i = 0;
    j = 0;
    while (j < m)
    {
      byte[] arrayOfByte2 = paramVarArgs[j];
      arrayOfByte1[i] = ((byte)arrayOfByte2.length);
      int n = arrayOfByte2.length;
      k = 0;
      i += 1;
      while (k < n)
      {
        arrayOfByte1[i] = arrayOfByte2[k];
        k += 1;
        i += 1;
      }
      j += 1;
    }
    AppMethodBeat.o(4930);
    return arrayOfByte1;
  }
  
  @VisibleForTesting
  private static void zzb(Socket paramSocket, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(4945);
    if (paramSocket != null) {}
    try
    {
      paramSocket.getClass().getMethod("setAlpnProtocols", new Class[] { [B.class }).invoke(paramSocket, new Object[] { paramArrayOfByte });
      AppMethodBeat.o(4945);
      return;
    }
    catch (InvocationTargetException paramArrayOfByte)
    {
      Throwable localThrowable = paramArrayOfByte.getCause();
      if ((localThrowable instanceof RuntimeException))
      {
        paramSocket = (RuntimeException)localThrowable;
        AppMethodBeat.o(4945);
        throw paramSocket;
      }
      paramSocket = String.valueOf(paramSocket.getClass());
      paramSocket = new RuntimeException(String.valueOf(paramSocket).length() + 37 + "Failed to invoke setAlpnProtocols on " + paramSocket, paramArrayOfByte);
      AppMethodBeat.o(4945);
      throw paramSocket;
    }
    catch (IllegalAccessException paramArrayOfByte)
    {
      paramSocket = String.valueOf(paramSocket.getClass());
      paramSocket = new IllegalArgumentException(String.valueOf(paramSocket).length() + 36 + paramSocket + " does not implement setAlpnProtocols", paramArrayOfByte);
      AppMethodBeat.o(4945);
      throw paramSocket;
    }
    catch (NoSuchMethodException paramArrayOfByte)
    {
      label129:
      break label129;
    }
  }
  
  @VisibleForTesting
  private final SSLSocketFactory zzcx()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(4927);
        SSLSocketFactory localSSLSocketFactory;
        if (!this.zzvp)
        {
          if (this.zzvg == null) {
            this.zzvg = SocketFactoryCreator.getInstance().makeSocketFactory(this.mContext, this.zzvj, zzvf, this.zzvo);
          }
          localSSLSocketFactory = this.zzvg;
          AppMethodBeat.o(4927);
          return localSSLSocketFactory;
        }
        if (this.zzvq != null)
        {
          if (this.zzvh == null) {
            this.zzvh = SocketFactoryCreator.getInstance().makeSocketFactoryWithCacheDir(this.mContext, this.zzvj, this.zzvi, this.zzvq);
          }
          localSSLSocketFactory = this.zzvh;
          AppMethodBeat.o(4927);
          continue;
        }
        if (this.zzvh != null) {
          continue;
        }
      }
      finally {}
      this.zzvh = SocketFactoryCreator.getInstance().makeSocketFactory(this.mContext, this.zzvj, this.zzvi, this.zzvo);
    }
  }
  
  public Socket createSocket()
  {
    AppMethodBeat.i(4937);
    Socket localSocket = zzcx().createSocket();
    zza(localSocket, this.zzvk);
    zzb(localSocket, this.zzvl);
    zza(localSocket, this.zzvn);
    zza(localSocket, this.zzvm);
    AppMethodBeat.o(4937);
    return localSocket;
  }
  
  public Socket createSocket(String paramString, int paramInt)
  {
    AppMethodBeat.i(4941);
    Socket localSocket = zzcx().createSocket(paramString, paramInt);
    zza(localSocket, this.zzvk);
    zzb(localSocket, this.zzvl);
    zza(localSocket, this.zzvn);
    zza(localSocket, this.zzvm);
    if (this.zzvp) {
      verifyHostname(localSocket, paramString);
    }
    AppMethodBeat.o(4941);
    return localSocket;
  }
  
  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
  {
    AppMethodBeat.i(4940);
    paramInetAddress = zzcx().createSocket(paramString, paramInt1, paramInetAddress, paramInt2);
    zza(paramInetAddress, this.zzvk);
    zzb(paramInetAddress, this.zzvl);
    zza(paramInetAddress, this.zzvn);
    zza(paramInetAddress, this.zzvm);
    if (this.zzvp) {
      verifyHostname(paramInetAddress, paramString);
    }
    AppMethodBeat.o(4940);
    return paramInetAddress;
  }
  
  public Socket createSocket(InetAddress paramInetAddress, int paramInt)
  {
    AppMethodBeat.i(4939);
    paramInetAddress = zzcx().createSocket(paramInetAddress, paramInt);
    zza(paramInetAddress, this.zzvk);
    zzb(paramInetAddress, this.zzvl);
    zza(paramInetAddress, this.zzvn);
    zza(paramInetAddress, this.zzvm);
    AppMethodBeat.o(4939);
    return paramInetAddress;
  }
  
  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
  {
    AppMethodBeat.i(4938);
    paramInetAddress1 = zzcx().createSocket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2);
    zza(paramInetAddress1, this.zzvk);
    zzb(paramInetAddress1, this.zzvl);
    zza(paramInetAddress1, this.zzvn);
    zza(paramInetAddress1, this.zzvm);
    AppMethodBeat.o(4938);
    return paramInetAddress1;
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(4936);
    paramSocket = zzcx().createSocket(paramSocket, paramString, paramInt, paramBoolean);
    zza(paramSocket, this.zzvk);
    zzb(paramSocket, this.zzvl);
    zza(paramSocket, this.zzvn);
    zza(paramSocket, this.zzvm);
    if (this.zzvp) {
      verifyHostname(paramSocket, paramString);
    }
    AppMethodBeat.o(4936);
    return paramSocket;
  }
  
  public byte[] getAlpnSelectedProtocol(Socket paramSocket)
  {
    AppMethodBeat.i(4932);
    try
    {
      byte[] arrayOfByte = (byte[])paramSocket.getClass().getMethod("getAlpnSelectedProtocol", new Class[0]).invoke(paramSocket, new Object[0]);
      AppMethodBeat.o(4932);
      return arrayOfByte;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Throwable localThrowable = localInvocationTargetException.getCause();
      if ((localThrowable instanceof RuntimeException))
      {
        paramSocket = (RuntimeException)localThrowable;
        AppMethodBeat.o(4932);
        throw paramSocket;
      }
      paramSocket = String.valueOf(paramSocket.getClass());
      paramSocket = new RuntimeException(String.valueOf(paramSocket).length() + 44 + "Failed to invoke getAlpnSelectedProtocol on " + paramSocket, localInvocationTargetException);
      AppMethodBeat.o(4932);
      throw paramSocket;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      paramSocket = String.valueOf(paramSocket.getClass());
      paramSocket = new IllegalArgumentException(String.valueOf(paramSocket).length() + 43 + paramSocket + " does not implement getAlpnSelectedProtocol", localIllegalAccessException);
      AppMethodBeat.o(4932);
      throw paramSocket;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label122:
      break label122;
    }
  }
  
  public String[] getDefaultCipherSuites()
  {
    AppMethodBeat.i(4942);
    String[] arrayOfString = zzcx().getDefaultCipherSuites();
    AppMethodBeat.o(4942);
    return arrayOfString;
  }
  
  public byte[] getNpnSelectedProtocol(Socket paramSocket)
  {
    AppMethodBeat.i(4931);
    try
    {
      byte[] arrayOfByte = (byte[])paramSocket.getClass().getMethod("getNpnSelectedProtocol", new Class[0]).invoke(paramSocket, new Object[0]);
      AppMethodBeat.o(4931);
      return arrayOfByte;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Throwable localThrowable = localInvocationTargetException.getCause();
      if ((localThrowable instanceof RuntimeException))
      {
        paramSocket = (RuntimeException)localThrowable;
        AppMethodBeat.o(4931);
        throw paramSocket;
      }
      paramSocket = String.valueOf(paramSocket.getClass());
      paramSocket = new RuntimeException(String.valueOf(paramSocket).length() + 43 + "Failed to invoke getNpnSelectedProtocol on " + paramSocket, localInvocationTargetException);
      AppMethodBeat.o(4931);
      throw paramSocket;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      paramSocket = String.valueOf(paramSocket.getClass());
      paramSocket = new IllegalArgumentException(String.valueOf(paramSocket).length() + 42 + paramSocket + " does not implement getNpnSelectedProtocol", localIllegalAccessException);
      AppMethodBeat.o(4931);
      throw paramSocket;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label122:
      break label122;
    }
  }
  
  public String[] getSupportedCipherSuites()
  {
    AppMethodBeat.i(4943);
    String[] arrayOfString = zzcx().getSupportedCipherSuites();
    AppMethodBeat.o(4943);
    return arrayOfString;
  }
  
  public void setAlpnProtocols(byte[][] paramArrayOfByte)
  {
    AppMethodBeat.i(4929);
    this.zzvl = zza(paramArrayOfByte);
    AppMethodBeat.o(4929);
  }
  
  public void setChannelIdPrivateKey(PrivateKey paramPrivateKey)
  {
    this.zzvm = paramPrivateKey;
  }
  
  public void setHostname(Socket paramSocket, String paramString)
  {
    AppMethodBeat.i(4934);
    try
    {
      paramSocket.getClass().getMethod("setHostname", new Class[] { String.class }).invoke(paramSocket, new Object[] { paramString });
      AppMethodBeat.o(4934);
      return;
    }
    catch (InvocationTargetException paramString)
    {
      Throwable localThrowable = paramString.getCause();
      if ((localThrowable instanceof RuntimeException))
      {
        paramSocket = (RuntimeException)localThrowable;
        AppMethodBeat.o(4934);
        throw paramSocket;
      }
      paramSocket = String.valueOf(paramSocket.getClass());
      paramSocket = new RuntimeException(String.valueOf(paramSocket).length() + 32 + "Failed to invoke setHostname on " + paramSocket, paramString);
      AppMethodBeat.o(4934);
      throw paramSocket;
    }
    catch (IllegalAccessException paramString)
    {
      paramSocket = String.valueOf(paramSocket.getClass());
      paramSocket = new IllegalArgumentException(String.valueOf(paramSocket).length() + 31 + paramSocket + " does not implement setHostname", paramString);
      AppMethodBeat.o(4934);
      throw paramSocket;
    }
    catch (NoSuchMethodException paramString)
    {
      label127:
      break label127;
    }
  }
  
  public void setKeyManagers(KeyManager[] paramArrayOfKeyManager)
  {
    this.zzvj = paramArrayOfKeyManager;
    this.zzvh = null;
    this.zzvg = null;
  }
  
  public void setNpnProtocols(byte[][] paramArrayOfByte)
  {
    AppMethodBeat.i(4928);
    this.zzvk = zza(paramArrayOfByte);
    AppMethodBeat.o(4928);
  }
  
  public void setSoWriteTimeout(Socket paramSocket, int paramInt)
  {
    AppMethodBeat.i(4935);
    try
    {
      paramSocket.getClass().getMethod("setSoWriteTimeout", new Class[] { Integer.TYPE }).invoke(paramSocket, new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(4935);
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Throwable localThrowable = localInvocationTargetException.getCause();
      if ((localThrowable instanceof SocketException))
      {
        paramSocket = (SocketException)localThrowable;
        AppMethodBeat.o(4935);
        throw paramSocket;
      }
      if ((localThrowable instanceof RuntimeException))
      {
        paramSocket = (RuntimeException)localThrowable;
        AppMethodBeat.o(4935);
        throw paramSocket;
      }
      paramSocket = String.valueOf(paramSocket.getClass());
      paramSocket = new RuntimeException(String.valueOf(paramSocket).length() + 38 + "Failed to invoke setSoWriteTimeout on " + paramSocket, localInvocationTargetException);
      AppMethodBeat.o(4935);
      throw paramSocket;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      paramSocket = String.valueOf(paramSocket.getClass());
      paramSocket = new IllegalArgumentException(String.valueOf(paramSocket).length() + 37 + paramSocket + " does not implement setSoWriteTimeout", localIllegalAccessException);
      AppMethodBeat.o(4935);
      throw paramSocket;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label156:
      break label156;
    }
  }
  
  public void setTrustManagers(TrustManager[] paramArrayOfTrustManager)
  {
    this.zzvi = paramArrayOfTrustManager;
    this.zzvh = null;
  }
  
  public void setUseSessionTickets(Socket paramSocket, boolean paramBoolean)
  {
    AppMethodBeat.i(4933);
    try
    {
      paramSocket.getClass().getMethod("setUseSessionTickets", new Class[] { Boolean.TYPE }).invoke(paramSocket, new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(4933);
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Throwable localThrowable = localInvocationTargetException.getCause();
      if ((localThrowable instanceof RuntimeException))
      {
        paramSocket = (RuntimeException)localThrowable;
        AppMethodBeat.o(4933);
        throw paramSocket;
      }
      paramSocket = String.valueOf(paramSocket.getClass());
      paramSocket = new RuntimeException(String.valueOf(paramSocket).length() + 41 + "Failed to invoke setUseSessionTickets on " + paramSocket, localInvocationTargetException);
      AppMethodBeat.o(4933);
      throw paramSocket;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      paramSocket = String.valueOf(paramSocket.getClass());
      paramSocket = new IllegalArgumentException(String.valueOf(paramSocket).length() + 40 + paramSocket + " does not implement setUseSessionTickets", localIllegalAccessException);
      AppMethodBeat.o(4933);
      throw paramSocket;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label134:
      break label134;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.net.SSLCertificateSocketFactory
 * JD-Core Version:    0.7.0.1
 */