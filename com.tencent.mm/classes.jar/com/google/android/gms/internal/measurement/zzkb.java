package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

final class zzkb
  extends SSLSocketFactory
{
  private final SSLSocketFactory zzari;
  
  zzkb()
  {
    this(HttpsURLConnection.getDefaultSSLSocketFactory());
    AppMethodBeat.i(2098);
    AppMethodBeat.o(2098);
  }
  
  private zzkb(SSLSocketFactory paramSSLSocketFactory)
  {
    this.zzari = paramSSLSocketFactory;
  }
  
  private final SSLSocket zza(SSLSocket paramSSLSocket)
  {
    AppMethodBeat.i(2107);
    paramSSLSocket = new zzkc(this, paramSSLSocket);
    AppMethodBeat.o(2107);
    return paramSSLSocket;
  }
  
  public final Socket createSocket()
  {
    AppMethodBeat.i(2106);
    SSLSocket localSSLSocket = zza((SSLSocket)this.zzari.createSocket());
    AppMethodBeat.o(2106);
    return localSSLSocket;
  }
  
  public final Socket createSocket(String paramString, int paramInt)
  {
    AppMethodBeat.i(2102);
    paramString = zza((SSLSocket)this.zzari.createSocket(paramString, paramInt));
    AppMethodBeat.o(2102);
    return paramString;
  }
  
  public final Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
  {
    AppMethodBeat.i(2104);
    paramString = zza((SSLSocket)this.zzari.createSocket(paramString, paramInt1, paramInetAddress, paramInt2));
    AppMethodBeat.o(2104);
    return paramString;
  }
  
  public final Socket createSocket(InetAddress paramInetAddress, int paramInt)
  {
    AppMethodBeat.i(2103);
    paramInetAddress = zza((SSLSocket)this.zzari.createSocket(paramInetAddress, paramInt));
    AppMethodBeat.o(2103);
    return paramInetAddress;
  }
  
  public final Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
  {
    AppMethodBeat.i(2105);
    paramInetAddress1 = zza((SSLSocket)this.zzari.createSocket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2));
    AppMethodBeat.o(2105);
    return paramInetAddress1;
  }
  
  public final Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(2099);
    paramSocket = zza((SSLSocket)this.zzari.createSocket(paramSocket, paramString, paramInt, paramBoolean));
    AppMethodBeat.o(2099);
    return paramSocket;
  }
  
  public final String[] getDefaultCipherSuites()
  {
    AppMethodBeat.i(2100);
    String[] arrayOfString = this.zzari.getDefaultCipherSuites();
    AppMethodBeat.o(2100);
    return arrayOfString;
  }
  
  public final String[] getSupportedCipherSuites()
  {
    AppMethodBeat.i(2101);
    String[] arrayOfString = this.zzari.getSupportedCipherSuites();
    AppMethodBeat.o(2101);
    return arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzkb
 * JD-Core Version:    0.7.0.1
 */