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
    AppMethodBeat.i(69575);
    AppMethodBeat.o(69575);
  }
  
  private zzkb(SSLSocketFactory paramSSLSocketFactory)
  {
    this.zzari = paramSSLSocketFactory;
  }
  
  private final SSLSocket zza(SSLSocket paramSSLSocket)
  {
    AppMethodBeat.i(69584);
    paramSSLSocket = new zzkc(this, paramSSLSocket);
    AppMethodBeat.o(69584);
    return paramSSLSocket;
  }
  
  public final Socket createSocket()
  {
    AppMethodBeat.i(69583);
    SSLSocket localSSLSocket = zza((SSLSocket)this.zzari.createSocket());
    AppMethodBeat.o(69583);
    return localSSLSocket;
  }
  
  public final Socket createSocket(String paramString, int paramInt)
  {
    AppMethodBeat.i(69579);
    paramString = zza((SSLSocket)this.zzari.createSocket(paramString, paramInt));
    AppMethodBeat.o(69579);
    return paramString;
  }
  
  public final Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
  {
    AppMethodBeat.i(69581);
    paramString = zza((SSLSocket)this.zzari.createSocket(paramString, paramInt1, paramInetAddress, paramInt2));
    AppMethodBeat.o(69581);
    return paramString;
  }
  
  public final Socket createSocket(InetAddress paramInetAddress, int paramInt)
  {
    AppMethodBeat.i(69580);
    paramInetAddress = zza((SSLSocket)this.zzari.createSocket(paramInetAddress, paramInt));
    AppMethodBeat.o(69580);
    return paramInetAddress;
  }
  
  public final Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
  {
    AppMethodBeat.i(69582);
    paramInetAddress1 = zza((SSLSocket)this.zzari.createSocket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2));
    AppMethodBeat.o(69582);
    return paramInetAddress1;
  }
  
  public final Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(69576);
    paramSocket = zza((SSLSocket)this.zzari.createSocket(paramSocket, paramString, paramInt, paramBoolean));
    AppMethodBeat.o(69576);
    return paramSocket;
  }
  
  public final String[] getDefaultCipherSuites()
  {
    AppMethodBeat.i(69577);
    String[] arrayOfString = this.zzari.getDefaultCipherSuites();
    AppMethodBeat.o(69577);
    return arrayOfString;
  }
  
  public final String[] getSupportedCipherSuites()
  {
    AppMethodBeat.i(69578);
    String[] arrayOfString = this.zzari.getSupportedCipherSuites();
    AppMethodBeat.o(69578);
    return arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzkb
 * JD-Core Version:    0.7.0.1
 */