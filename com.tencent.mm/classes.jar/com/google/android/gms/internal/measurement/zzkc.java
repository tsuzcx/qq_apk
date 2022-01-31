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
    AppMethodBeat.i(69592);
    this.zzarj.addHandshakeCompletedListener(paramHandshakeCompletedListener);
    AppMethodBeat.o(69592);
  }
  
  public final void bind(SocketAddress paramSocketAddress)
  {
    AppMethodBeat.i(69603);
    this.zzarj.bind(paramSocketAddress);
    AppMethodBeat.o(69603);
  }
  
  public final void close()
  {
    try
    {
      AppMethodBeat.i(69604);
      this.zzarj.close();
      AppMethodBeat.o(69604);
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
    AppMethodBeat.i(69605);
    this.zzarj.connect(paramSocketAddress);
    AppMethodBeat.o(69605);
  }
  
  public final void connect(SocketAddress paramSocketAddress, int paramInt)
  {
    AppMethodBeat.i(69606);
    this.zzarj.connect(paramSocketAddress, paramInt);
    AppMethodBeat.o(69606);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(69644);
    boolean bool = this.zzarj.equals(paramObject);
    AppMethodBeat.o(69644);
    return bool;
  }
  
  public final SocketChannel getChannel()
  {
    AppMethodBeat.i(69607);
    SocketChannel localSocketChannel = this.zzarj.getChannel();
    AppMethodBeat.o(69607);
    return localSocketChannel;
  }
  
  public final boolean getEnableSessionCreation()
  {
    AppMethodBeat.i(69602);
    boolean bool = this.zzarj.getEnableSessionCreation();
    AppMethodBeat.o(69602);
    return bool;
  }
  
  public final String[] getEnabledCipherSuites()
  {
    AppMethodBeat.i(69587);
    String[] arrayOfString = this.zzarj.getEnabledCipherSuites();
    AppMethodBeat.o(69587);
    return arrayOfString;
  }
  
  public final String[] getEnabledProtocols()
  {
    AppMethodBeat.i(69590);
    String[] arrayOfString = this.zzarj.getEnabledProtocols();
    AppMethodBeat.o(69590);
    return arrayOfString;
  }
  
  public final InetAddress getInetAddress()
  {
    AppMethodBeat.i(69608);
    InetAddress localInetAddress = this.zzarj.getInetAddress();
    AppMethodBeat.o(69608);
    return localInetAddress;
  }
  
  public final InputStream getInputStream()
  {
    AppMethodBeat.i(69609);
    InputStream localInputStream = this.zzarj.getInputStream();
    AppMethodBeat.o(69609);
    return localInputStream;
  }
  
  public final boolean getKeepAlive()
  {
    AppMethodBeat.i(69610);
    boolean bool = this.zzarj.getKeepAlive();
    AppMethodBeat.o(69610);
    return bool;
  }
  
  public final InetAddress getLocalAddress()
  {
    AppMethodBeat.i(69611);
    InetAddress localInetAddress = this.zzarj.getLocalAddress();
    AppMethodBeat.o(69611);
    return localInetAddress;
  }
  
  public final int getLocalPort()
  {
    AppMethodBeat.i(69612);
    int i = this.zzarj.getLocalPort();
    AppMethodBeat.o(69612);
    return i;
  }
  
  public final SocketAddress getLocalSocketAddress()
  {
    AppMethodBeat.i(69613);
    SocketAddress localSocketAddress = this.zzarj.getLocalSocketAddress();
    AppMethodBeat.o(69613);
    return localSocketAddress;
  }
  
  public final boolean getNeedClientAuth()
  {
    AppMethodBeat.i(69599);
    boolean bool = this.zzarj.getNeedClientAuth();
    AppMethodBeat.o(69599);
    return bool;
  }
  
  public final boolean getOOBInline()
  {
    AppMethodBeat.i(69614);
    boolean bool = this.zzarj.getOOBInline();
    AppMethodBeat.o(69614);
    return bool;
  }
  
  public final OutputStream getOutputStream()
  {
    AppMethodBeat.i(69615);
    OutputStream localOutputStream = this.zzarj.getOutputStream();
    AppMethodBeat.o(69615);
    return localOutputStream;
  }
  
  public final int getPort()
  {
    AppMethodBeat.i(69616);
    int i = this.zzarj.getPort();
    AppMethodBeat.o(69616);
    return i;
  }
  
  public final int getReceiveBufferSize()
  {
    try
    {
      AppMethodBeat.i(69617);
      int i = this.zzarj.getReceiveBufferSize();
      AppMethodBeat.o(69617);
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
    AppMethodBeat.i(69618);
    SocketAddress localSocketAddress = this.zzarj.getRemoteSocketAddress();
    AppMethodBeat.o(69618);
    return localSocketAddress;
  }
  
  public final boolean getReuseAddress()
  {
    AppMethodBeat.i(69619);
    boolean bool = this.zzarj.getReuseAddress();
    AppMethodBeat.o(69619);
    return bool;
  }
  
  public final int getSendBufferSize()
  {
    try
    {
      AppMethodBeat.i(69620);
      int i = this.zzarj.getSendBufferSize();
      AppMethodBeat.o(69620);
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
    AppMethodBeat.i(69591);
    SSLSession localSSLSession = this.zzarj.getSession();
    AppMethodBeat.o(69591);
    return localSSLSession;
  }
  
  public final int getSoLinger()
  {
    AppMethodBeat.i(69621);
    int i = this.zzarj.getSoLinger();
    AppMethodBeat.o(69621);
    return i;
  }
  
  public final int getSoTimeout()
  {
    try
    {
      AppMethodBeat.i(69622);
      int i = this.zzarj.getSoTimeout();
      AppMethodBeat.o(69622);
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
    AppMethodBeat.i(69586);
    String[] arrayOfString = this.zzarj.getSupportedCipherSuites();
    AppMethodBeat.o(69586);
    return arrayOfString;
  }
  
  public final String[] getSupportedProtocols()
  {
    AppMethodBeat.i(69589);
    String[] arrayOfString = this.zzarj.getSupportedProtocols();
    AppMethodBeat.o(69589);
    return arrayOfString;
  }
  
  public final boolean getTcpNoDelay()
  {
    AppMethodBeat.i(69623);
    boolean bool = this.zzarj.getTcpNoDelay();
    AppMethodBeat.o(69623);
    return bool;
  }
  
  public final int getTrafficClass()
  {
    AppMethodBeat.i(69624);
    int i = this.zzarj.getTrafficClass();
    AppMethodBeat.o(69624);
    return i;
  }
  
  public final boolean getUseClientMode()
  {
    AppMethodBeat.i(69596);
    boolean bool = this.zzarj.getUseClientMode();
    AppMethodBeat.o(69596);
    return bool;
  }
  
  public final boolean getWantClientAuth()
  {
    AppMethodBeat.i(69600);
    boolean bool = this.zzarj.getWantClientAuth();
    AppMethodBeat.o(69600);
    return bool;
  }
  
  public final boolean isBound()
  {
    AppMethodBeat.i(69625);
    boolean bool = this.zzarj.isBound();
    AppMethodBeat.o(69625);
    return bool;
  }
  
  public final boolean isClosed()
  {
    AppMethodBeat.i(69626);
    boolean bool = this.zzarj.isClosed();
    AppMethodBeat.o(69626);
    return bool;
  }
  
  public final boolean isConnected()
  {
    AppMethodBeat.i(69627);
    boolean bool = this.zzarj.isConnected();
    AppMethodBeat.o(69627);
    return bool;
  }
  
  public final boolean isInputShutdown()
  {
    AppMethodBeat.i(69628);
    boolean bool = this.zzarj.isInputShutdown();
    AppMethodBeat.o(69628);
    return bool;
  }
  
  public final boolean isOutputShutdown()
  {
    AppMethodBeat.i(69629);
    boolean bool = this.zzarj.isOutputShutdown();
    AppMethodBeat.o(69629);
    return bool;
  }
  
  public final void removeHandshakeCompletedListener(HandshakeCompletedListener paramHandshakeCompletedListener)
  {
    AppMethodBeat.i(69593);
    this.zzarj.removeHandshakeCompletedListener(paramHandshakeCompletedListener);
    AppMethodBeat.o(69593);
  }
  
  public final void sendUrgentData(int paramInt)
  {
    AppMethodBeat.i(69630);
    this.zzarj.sendUrgentData(paramInt);
    AppMethodBeat.o(69630);
  }
  
  public final void setEnableSessionCreation(boolean paramBoolean)
  {
    AppMethodBeat.i(69601);
    this.zzarj.setEnableSessionCreation(paramBoolean);
    AppMethodBeat.o(69601);
  }
  
  public final void setEnabledCipherSuites(String[] paramArrayOfString)
  {
    AppMethodBeat.i(69588);
    this.zzarj.setEnabledCipherSuites(paramArrayOfString);
    AppMethodBeat.o(69588);
  }
  
  public final void setEnabledProtocols(String[] paramArrayOfString)
  {
    AppMethodBeat.i(69585);
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
    AppMethodBeat.o(69585);
  }
  
  public final void setKeepAlive(boolean paramBoolean)
  {
    AppMethodBeat.i(69631);
    this.zzarj.setKeepAlive(paramBoolean);
    AppMethodBeat.o(69631);
  }
  
  public final void setNeedClientAuth(boolean paramBoolean)
  {
    AppMethodBeat.i(69597);
    this.zzarj.setNeedClientAuth(paramBoolean);
    AppMethodBeat.o(69597);
  }
  
  public final void setOOBInline(boolean paramBoolean)
  {
    AppMethodBeat.i(69632);
    this.zzarj.setOOBInline(paramBoolean);
    AppMethodBeat.o(69632);
  }
  
  public final void setPerformancePreferences(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(69633);
    this.zzarj.setPerformancePreferences(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(69633);
  }
  
  public final void setReceiveBufferSize(int paramInt)
  {
    try
    {
      AppMethodBeat.i(69634);
      this.zzarj.setReceiveBufferSize(paramInt);
      AppMethodBeat.o(69634);
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
    AppMethodBeat.i(69635);
    this.zzarj.setReuseAddress(paramBoolean);
    AppMethodBeat.o(69635);
  }
  
  public final void setSendBufferSize(int paramInt)
  {
    try
    {
      AppMethodBeat.i(69636);
      this.zzarj.setSendBufferSize(paramInt);
      AppMethodBeat.o(69636);
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
    AppMethodBeat.i(69637);
    this.zzarj.setSoLinger(paramBoolean, paramInt);
    AppMethodBeat.o(69637);
  }
  
  public final void setSoTimeout(int paramInt)
  {
    try
    {
      AppMethodBeat.i(69638);
      this.zzarj.setSoTimeout(paramInt);
      AppMethodBeat.o(69638);
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
    AppMethodBeat.i(69639);
    this.zzarj.setTcpNoDelay(paramBoolean);
    AppMethodBeat.o(69639);
  }
  
  public final void setTrafficClass(int paramInt)
  {
    AppMethodBeat.i(69640);
    this.zzarj.setTrafficClass(paramInt);
    AppMethodBeat.o(69640);
  }
  
  public final void setUseClientMode(boolean paramBoolean)
  {
    AppMethodBeat.i(69595);
    this.zzarj.setUseClientMode(paramBoolean);
    AppMethodBeat.o(69595);
  }
  
  public final void setWantClientAuth(boolean paramBoolean)
  {
    AppMethodBeat.i(69598);
    this.zzarj.setWantClientAuth(paramBoolean);
    AppMethodBeat.o(69598);
  }
  
  public final void shutdownInput()
  {
    AppMethodBeat.i(69641);
    this.zzarj.shutdownInput();
    AppMethodBeat.o(69641);
  }
  
  public final void shutdownOutput()
  {
    AppMethodBeat.i(69642);
    this.zzarj.shutdownOutput();
    AppMethodBeat.o(69642);
  }
  
  public final void startHandshake()
  {
    AppMethodBeat.i(69594);
    this.zzarj.startHandshake();
    AppMethodBeat.o(69594);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(69643);
    String str = this.zzarj.toString();
    AppMethodBeat.o(69643);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzkc
 * JD-Core Version:    0.7.0.1
 */