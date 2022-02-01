package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

public final class Handshake
{
  private final String cipherSuite;
  private final List<Certificate> localCertificates;
  private final List<Certificate> peerCertificates;
  
  private Handshake(String paramString, List<Certificate> paramList1, List<Certificate> paramList2)
  {
    this.cipherSuite = paramString;
    this.peerCertificates = paramList1;
    this.localCertificates = paramList2;
  }
  
  public static Handshake get(String paramString, List<Certificate> paramList1, List<Certificate> paramList2)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("cipherSuite == null");
    }
    return new Handshake(paramString, Util.immutableList(paramList1), Util.immutableList(paramList2));
  }
  
  public static Handshake get(SSLSession paramSSLSession)
  {
    String str = paramSSLSession.getCipherSuite();
    if (str == null) {
      throw new IllegalStateException("cipherSuite == null");
    }
    try
    {
      Object localObject = paramSSLSession.getPeerCertificates();
      if (localObject != null)
      {
        localObject = Util.immutableList((Object[])localObject);
        paramSSLSession = paramSSLSession.getLocalCertificates();
        if (paramSSLSession == null) {
          break label77;
        }
        paramSSLSession = Util.immutableList(paramSSLSession);
        return new Handshake(str, (List)localObject, paramSSLSession);
      }
    }
    catch (SSLPeerUnverifiedException localSSLPeerUnverifiedException)
    {
      for (;;)
      {
        List localList = null;
        continue;
        localList = Collections.emptyList();
        continue;
        label77:
        paramSSLSession = Collections.emptyList();
      }
    }
  }
  
  public String cipherSuite()
  {
    return this.cipherSuite;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Handshake)) {}
    do
    {
      return false;
      paramObject = (Handshake)paramObject;
    } while ((!this.cipherSuite.equals(paramObject.cipherSuite)) || (!this.peerCertificates.equals(paramObject.peerCertificates)) || (!this.localCertificates.equals(paramObject.localCertificates)));
    return true;
  }
  
  public int hashCode()
  {
    return ((this.cipherSuite.hashCode() + 527) * 31 + this.peerCertificates.hashCode()) * 31 + this.localCertificates.hashCode();
  }
  
  public List<Certificate> localCertificates()
  {
    return this.localCertificates;
  }
  
  public Principal localPrincipal()
  {
    if (!this.localCertificates.isEmpty()) {
      return ((X509Certificate)this.localCertificates.get(0)).getSubjectX500Principal();
    }
    return null;
  }
  
  public List<Certificate> peerCertificates()
  {
    return this.peerCertificates;
  }
  
  public Principal peerPrincipal()
  {
    if (!this.peerCertificates.isEmpty()) {
      return ((X509Certificate)this.peerCertificates.get(0)).getSubjectX500Principal();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.squareup.okhttp.Handshake
 * JD-Core Version:    0.7.0.1
 */