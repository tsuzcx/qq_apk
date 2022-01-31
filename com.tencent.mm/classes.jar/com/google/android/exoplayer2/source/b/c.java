package com.google.android.exoplayer2.source.b;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.f;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.source.b.a.a.a;
import com.google.android.exoplayer2.source.l;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

final class c
{
  Uri aJA;
  String aJB;
  com.google.android.exoplayer2.g.e aJC;
  byte[] aJl;
  final f aJo;
  final f aJp;
  final k aJq;
  final a.a[] aJr;
  final com.google.android.exoplayer2.source.b.a.e aJs;
  final l aJt;
  final List<Format> aJu;
  boolean aJv;
  byte[] aJw;
  IOException aJx;
  a.a aJy;
  boolean aJz;
  byte[] azp;
  
  public c(com.google.android.exoplayer2.source.b.a.e parame, a.a[] paramArrayOfa, d paramd, k paramk, List<Format> paramList)
  {
    this.aJs = parame;
    this.aJr = paramArrayOfa;
    this.aJq = paramk;
    this.aJu = paramList;
    parame = new Format[paramArrayOfa.length];
    paramk = new int[paramArrayOfa.length];
    int i = 0;
    while (i < paramArrayOfa.length)
    {
      parame[i] = paramArrayOfa[i].auL;
      paramk[i] = i;
      i += 1;
    }
    this.aJo = paramd.mU();
    this.aJp = paramd.mU();
    this.aJt = new l(parame);
    this.aJC = new c.c(this.aJt, paramk);
  }
  
  final void a(Uri paramUri, String paramString, byte[] paramArrayOfByte)
  {
    Object localObject;
    byte[] arrayOfByte;
    if (t.aE(paramString).startsWith("0x"))
    {
      localObject = paramString.substring(2);
      localObject = new BigInteger((String)localObject, 16).toByteArray();
      arrayOfByte = new byte[16];
      if (localObject.length <= 16) {
        break label109;
      }
    }
    label109:
    for (int i = localObject.length - 16;; i = 0)
    {
      System.arraycopy(localObject, i, arrayOfByte, 16 - localObject.length + i, localObject.length - i);
      this.aJA = paramUri;
      this.azp = paramArrayOfByte;
      this.aJB = paramString;
      this.aJl = arrayOfByte;
      return;
      localObject = paramString;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.c
 * JD-Core Version:    0.7.0.1
 */