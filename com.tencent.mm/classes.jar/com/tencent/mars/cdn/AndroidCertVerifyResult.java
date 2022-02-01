package com.tencent.mars.cdn;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AndroidCertVerifyResult
{
  private final List<X509Certificate> mCertificateChain;
  private final boolean mIsIssuedByHostMatched;
  private final boolean mIsIssuedByKnownRoot;
  private final int mStatus;
  
  public AndroidCertVerifyResult(int paramInt)
  {
    this.mStatus = paramInt;
    this.mIsIssuedByKnownRoot = false;
    this.mCertificateChain = Collections.emptyList();
    this.mIsIssuedByHostMatched = false;
  }
  
  public AndroidCertVerifyResult(int paramInt, boolean paramBoolean, List<X509Certificate> paramList)
  {
    this.mStatus = paramInt;
    this.mIsIssuedByKnownRoot = paramBoolean;
    this.mCertificateChain = new ArrayList(paramList);
    this.mIsIssuedByHostMatched = false;
  }
  
  public AndroidCertVerifyResult(int paramInt, boolean paramBoolean1, List<X509Certificate> paramList, boolean paramBoolean2)
  {
    this.mStatus = paramInt;
    this.mIsIssuedByKnownRoot = paramBoolean1;
    this.mCertificateChain = new ArrayList(paramList);
    this.mIsIssuedByHostMatched = paramBoolean2;
  }
  
  public byte[][] getCertificateChainEncoded()
  {
    byte[][] arrayOfByte = new byte[this.mCertificateChain.size()][];
    int i = 0;
    try
    {
      while (i < this.mCertificateChain.size())
      {
        arrayOfByte[i] = ((X509Certificate)this.mCertificateChain.get(i)).getEncoded();
        i += 1;
      }
      return localCertificateEncodingException;
    }
    catch (CertificateEncodingException localCertificateEncodingException)
    {
      return new byte[0][];
    }
  }
  
  public int getStatus()
  {
    return this.mStatus;
  }
  
  public boolean isIssuedByHostMatched()
  {
    return this.mIsIssuedByHostMatched;
  }
  
  public boolean isIssuedByKnownRoot()
  {
    return this.mIsIssuedByKnownRoot;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mars.cdn.AndroidCertVerifyResult
 * JD-Core Version:    0.7.0.1
 */