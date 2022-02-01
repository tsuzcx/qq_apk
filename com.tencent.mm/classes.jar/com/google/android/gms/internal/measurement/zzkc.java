package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

final class zzkc
  extends SSLSocket
{
  private final SSLSocket zzarj;
  
  zzkc(zzkb paramzzkb, SSLSocket paramSSLSocket)
  {
    this.zzarj = paramSSLSocket;
  }
  
  public final void addHandshakeCompletedListener(HandshakeCompletedListener paramHandshakeCompletedListener)
  {
    AppMethodBeat.i(2115);
    this.zzarj.addHandshakeCompletedListener(paramHandshakeCompletedListener);
    AppMethodBeat.o(2115);
  }
  
  public final void bind(SocketAddress paramSocketAddress)
  {
    AppMethodBeat.i(2126);
    this.zzarj.bind(paramSocketAddress);
    AppMethodBeat.o(2126);
  }
  
  public final void close()
  {
    try
    {
      AppMethodBeat.i(2127);
      this.zzarj.close();
      AppMethodBeat.o(2127);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void connect(SocketAddress paramSocketAddress)
  {
    AppMethodBeat.i(2128);
    this.zzarj.connect(paramSocketAddress);
    AppMethodBeat.o(2128);
  }
  
  public final void connect(SocketAddress paramSocketAddress, int paramInt)
  {
    AppMethodBeat.i(2129);
    this.zzarj.connect(paramSocketAddress, paramInt);
    AppMethodBeat.o(2129);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(2167);
    boolean bool = this.zzarj.equals(paramObject);
    AppMethodBeat.o(2167);
    return bool;
  }
  
  public final SocketChannel getChannel()
  {
    AppMethodBeat.i(2130);
    SocketChannel localSocketChannel = this.zzarj.getChannel();
    AppMethodBeat.o(2130);
    return localSocketChannel;
  }
  
  public final boolean getEnableSessionCreation()
  {
    AppMethodBeat.i(2125);
    boolean bool = this.zzarj.getEnableSessionCreation();
    AppMethodBeat.o(2125);
    return bool;
  }
  
  public final String[] getEnabledCipherSuites()
  {
    AppMethodBeat.i(2110);
    String[] arrayOfString = this.zzarj.getEnabledCipherSuites();
    AppMethodBeat.o(2110);
    return arrayOfString;
  }
  
  public final String[] getEnabledProtocols()
  {
    AppMethodBeat.i(2113);
    String[] arrayOfString = this.zzarj.getEnabledProtocols();
    AppMethodBeat.o(2113);
    return arrayOfString;
  }
  
  public final InetAddress getInetAddress()
  {
    AppMethodBeat.i(2131);
    InetAddress localInetAddress = this.zzarj.getInetAddress();
    AppMethodBeat.o(2131);
    return localInetAddress;
  }
  
  public final InputStream getInputStream()
  {
    AppMethodBeat.i(2132);
    InputStream localInputStream = this.zzarj.getInputStream();
    AppMethodBeat.o(2132);
    return localInputStream;
  }
  
  public final boolean getKeepAlive()
  {
    AppMethodBeat.i(2133);
    boolean bool = this.zzarj.getKeepAlive();
    AppMethodBeat.o(2133);
    return bool;
  }
  
  public final InetAddress getLocalAddress()
  {
    AppMethodBeat.i(2134);
    InetAddress localInetAddress = this.zzarj.getLocalAddress();
    AppMethodBeat.o(2134);
    return localInetAddress;
  }
  
  public final int getLocalPort()
  {
    AppMethodBeat.i(2135);
    int i = this.zzarj.getLocalPort();
    AppMethodBeat.o(2135);
    return i;
  }
  
  public final SocketAddress getLocalSocketAddress()
  {
    AppMethodBeat.i(2136);
    SocketAddress localSocketAddress = this.zzarj.getLocalSocketAddress();
    AppMethodBeat.o(2136);
    return localSocketAddress;
  }
  
  public final boolean getNeedClientAuth()
  {
    AppMethodBeat.i(2122);
    boolean bool = this.zzarj.getNeedClientAuth();
    AppMethodBeat.o(2122);
    return bool;
  }
  
  public final boolean getOOBInline()
  {
    AppMethodBeat.i(2137);
    boolean bool = this.zzarj.getOOBInline();
    AppMethodBeat.o(2137);
    return bool;
  }
  
  public final OutputStream getOutputStream()
  {
    AppMethodBeat.i(2138);
    OutputStream localOutputStream = this.zzarj.getOutputStream();
    AppMethodBeat.o(2138);
    return localOutputStream;
  }
  
  public final int getPort()
  {
    AppMethodBeat.i(2139);
    int i = this.zzarj.getPort();
    AppMethodBeat.o(2139);
    return i;
  }
  
  public final int getReceiveBufferSize()
  {
    try
    {
      AppMethodBeat.i(2140);
      int i = this.zzarj.getReceiveBufferSize();
      AppMethodBeat.o(2140);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final SocketAddress getRemoteSocketAddress()
  {
    AppMethodBeat.i(2141);
    SocketAddress localSocketAddress = this.zzarj.getRemoteSocketAddress();
    AppMethodBeat.o(2141);
    return localSocketAddress;
  }
  
  public final boolean getReuseAddress()
  {
    AppMethodBeat.i(2142);
    boolean bool = this.zzarj.getReuseAddress();
    AppMethodBeat.o(2142);
    return bool;
  }
  
  public final int getSendBufferSize()
  {
    try
    {
      AppMethodBeat.i(2143);
      int i = this.zzarj.getSendBufferSize();
      AppMethodBeat.o(2143);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final SSLSession getSession()
  {
    AppMethodBeat.i(2114);
    SSLSession localSSLSession = this.zzarj.getSession();
    AppMethodBeat.o(2114);
    return localSSLSession;
  }
  
  public final int getSoLinger()
  {
    AppMethodBeat.i(2144);
    int i = this.zzarj.getSoLinger();
    AppMethodBeat.o(2144);
    return i;
  }
  
  public final int getSoTimeout()
  {
    try
    {
      AppMethodBeat.i(2145);
      int i = this.zzarj.getSoTimeout();
      AppMethodBeat.o(2145);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String[] getSupportedCipherSuites()
  {
    AppMethodBeat.i(2109);
    String[] arrayOfString = this.zzarj.getSupportedCipherSuites();
    AppMethodBeat.o(2109);
    return arrayOfString;
  }
  
  public final String[] getSupportedProtocols()
  {
    AppMethodBeat.i(2112);
    String[] arrayOfString = this.zzarj.getSupportedProtocols();
    AppMethodBeat.o(2112);
    return arrayOfString;
  }
  
  public final boolean getTcpNoDelay()
  {
    AppMethodBeat.i(2146);
    boolean bool = this.zzarj.getTcpNoDelay();
    AppMethodBeat.o(2146);
    return bool;
  }
  
  public final int getTrafficClass()
  {
    AppMethodBeat.i(2147);
    int i = this.zzarj.getTrafficClass();
    AppMethodBeat.o(2147);
    return i;
  }
  
  public final boolean getUseClientMode()
  {
    AppMethodBeat.i(2119);
    boolean bool = this.zzarj.getUseClientMode();
    AppMethodBeat.o(2119);
    return bool;
  }
  
  public final boolean getWantClientAuth()
  {
    AppMethodBeat.i(2123);
    boolean bool = this.zzarj.getWantClientAuth();
    AppMethodBeat.o(2123);
    return bool;
  }
  
  public final boolean isBound()
  {
    AppMethodBeat.i(2148);
    boolean bool = this.zzarj.isBound();
    AppMethodBeat.o(2148);
    return bool;
  }
  
  public final boolean isClosed()
  {
    AppMethodBeat.i(2149);
    boolean bool = this.zzarj.isClosed();
    AppMethodBeat.o(2149);
    return bool;
  }
  
  public final boolean isConnected()
  {
    AppMethodBeat.i(2150);
    boolean bool = this.zzarj.isConnected();
    AppMethodBeat.o(2150);
    return bool;
  }
  
  public final boolean isInputShutdown()
  {
    AppMethodBeat.i(2151);
    boolean bool = this.zzarj.isInputShutdown();
    AppMethodBeat.o(2151);
    return bool;
  }
  
  public final boolean isOutputShutdown()
  {
    AppMethodBeat.i(2152);
    boolean bool = this.zzarj.isOutputShutdown();
    AppMethodBeat.o(2152);
    return bool;
  }
  
  public final void removeHandshakeCompletedListener(HandshakeCompletedListener paramHandshakeCompletedListener)
  {
    AppMethodBeat.i(2116);
    this.zzarj.removeHandshakeCompletedListener(paramHandshakeCompletedListener);
    AppMethodBeat.o(2116);
  }
  
  public final void sendUrgentData(int paramInt)
  {
    AppMethodBeat.i(2153);
    this.zzarj.sendUrgentData(paramInt);
    AppMethodBeat.o(2153);
  }
  
  public final void setEnableSessionCreation(boolean paramBoolean)
  {
    AppMethodBeat.i(2124);
    this.zzarj.setEnableSessionCreation(paramBoolean);
    AppMethodBeat.o(2124);
  }
  
  public final void setEnabledCipherSuites(String[] paramArrayOfString)
  {
    AppMethodBeat.i(2111);
    this.zzarj.setEnabledCipherSuites(paramArrayOfString);
    AppMethodBeat.o(2111);
  }
  
  public final void setEnabledProtocols(String[] paramArrayOfString)
  {
    AppMethodBeat.i(2108);
    String[] arrayOfString = paramArrayOfString;
    if (paramArrayOfString != null)
    {
      arrayOfString = paramArrayOfString;
      if (Arrays.asList(paramArrayOfString).contains("SSLv3"))
      {
        paramArrayOfString = new ArrayList(Arrays.asList(this.zzarj.getEnabledProtocols()));
        if (paramArrayOfString.size() > 1) {
          paramArrayOfString.remove("SSLv3");
        }
        arrayOfString = (String[])paramArrayOfString.toArray(new String[paramArrayOfString.size()]);
      }
    }
    this.zzarj.setEnabledProtocols(arrayOfString);
    AppMethodBeat.o(2108);
  }
  
  public final void setKeepAlive(boolean paramBoolean)
  {
    AppMethodBeat.i(2154);
    this.zzarj.setKeepAlive(paramBoolean);
    AppMethodBeat.o(2154);
  }
  
  public final void setNeedClientAuth(boolean paramBoolean)
  {
    AppMethodBeat.i(2120);
    this.zzarj.setNeedClientAuth(paramBoolean);
    AppMethodBeat.o(2120);
  }
  
  public final void setOOBInline(boolean paramBoolean)
  {
    AppMethodBeat.i(2155);
    this.zzarj.setOOBInline(paramBoolean);
    AppMethodBeat.o(2155);
  }
  
  public final void setPerformancePreferences(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(2156);
    this.zzarj.setPerformancePreferences(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(2156);
  }
  
  public final void setReceiveBufferSize(int paramInt)
  {
    try
    {
      AppMethodBeat.i(2157);
      this.zzarj.setReceiveBufferSize(paramInt);
      AppMethodBeat.o(2157);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void setReuseAddress(boolean paramBoolean)
  {
    AppMethodBeat.i(2158);
    this.zzarj.setReuseAddress(paramBoolean);
    AppMethodBeat.o(2158);
  }
  
  public final void setSendBufferSize(int paramInt)
  {
    try
    {
      AppMethodBeat.i(2159);
      this.zzarj.setSendBufferSize(paramInt);
      AppMethodBeat.o(2159);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void setSoLinger(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(2160);
    this.zzarj.setSoLinger(paramBoolean, paramInt);
    AppMethodBeat.o(2160);
  }
  
  public final void setSoTimeout(int paramInt)
  {
    try
    {
      AppMethodBeat.i(2161);
      this.zzarj.setSoTimeout(paramInt);
      AppMethodBeat.o(2161);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void setTcpNoDelay(boolean paramBoolean)
  {
    AppMethodBeat.i(2162);
    this.zzarj.setTcpNoDelay(paramBoolean);
    AppMethodBeat.o(2162);
  }
  
  public final void setTrafficClass(int paramInt)
  {
    AppMethodBeat.i(2163);
    this.zzarj.setTrafficClass(paramInt);
    AppMethodBeat.o(2163);
  }
  
  public final void setUseClientMode(boolean paramBoolean)
  {
    AppMethodBeat.i(2118);
    this.zzarj.setUseClientMode(paramBoolean);
    AppMethodBeat.o(2118);
  }
  
  public final void setWantClientAuth(boolean paramBoolean)
  {
    AppMethodBeat.i(2121);
    this.zzarj.setWantClientAuth(paramBoolean);
    AppMethodBeat.o(2121);
  }
  
  public final void shutdownInput()
  {
    AppMethodBeat.i(2164);
    this.zzarj.shutdownInput();
    AppMethodBeat.o(2164);
  }
  
  public final void shutdownOutput()
  {
    AppMethodBeat.i(2165);
    this.zzarj.shutdownOutput();
    AppMethodBeat.o(2165);
  }
  
  public final void startHandshake()
  {
    AppMethodBeat.i(2117);
    this.zzarj.startHandshake();
    AppMethodBeat.o(2117);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(2166);
    String str = this.zzarj.toString();
    AppMethodBeat.o(2166);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzkc
 * JD-Core Version:    0.7.0.1
 */