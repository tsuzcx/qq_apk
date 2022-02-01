package com.tencent.mm.plugin.appbrand.jsapi.video.b.b;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.i;
import java.util.List;
import java.util.Map;

public final class n
  extends j
{
  private static int sBL = 3;
  private static boolean sBM;
  private com.tencent.mm.plugin.appbrand.jsapi.video.b.c.n sBE;
  private com.tencent.mm.plugin.appbrand.jsapi.video.b.c.e sBN;
  private int sBO;
  private String uuid;
  
  public n(String paramString, i<String> parami, s params, com.tencent.mm.plugin.appbrand.jsapi.video.b.c.e parame, com.tencent.mm.plugin.appbrand.jsapi.video.b.e.e<Map<String, List<String>>> parame1, com.tencent.mm.plugin.appbrand.jsapi.video.b.c.n paramn)
  {
    super(paramString, parami, params, true, parame1);
    AppMethodBeat.i(328535);
    this.sBO = 0;
    this.sBN = parame;
    this.sBE = paramn;
    if (!sBM)
    {
      sBL = a.cvH().sAN;
      sBM = true;
    }
    AppMethodBeat.o(328535);
  }
  
  private int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, l.a parama)
  {
    AppMethodBeat.i(328577);
    h.log(4, getLogTag(), "read source error occurred " + parama.toString());
    this.sBO += 1;
    long l1 = this.sAT.position + bytesRead();
    int i = this.sBO * 2000;
    h.log(4, getLogTag(), "retrying after " + i + " ms, read start at offset " + l1 + " retry " + this.sBO + "/" + sBL);
    long l2 = i;
    g localg;
    try
    {
      Thread.sleep(l2);
      localg = new g(Uri.parse(getUri()), 0L, l1, -1L, null, 0, this.uuid, this.sAT.priority);
      if ((Thread.currentThread().isInterrupted()) || (this.sBO >= sBL)) {
        break label306;
      }
      if (this.sBE.Bn(1))
      {
        h.log(4, getLogTag(), "abort retry videoRequest is cancelling " + this.sBE);
        paramArrayOfByte = new l.c("readRetry interrupted " + this.sBE, this.sAT);
        AppMethodBeat.o(328577);
        throw paramArrayOfByte;
      }
    }
    catch (InterruptedException paramArrayOfByte)
    {
      h.log(5, getLogTag(), "readRetry interrupted");
      AppMethodBeat.o(328577);
      throw parama;
    }
    a(localg);
    paramInt1 = read(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(328577);
    return paramInt1;
    label306:
    AppMethodBeat.o(328577);
    throw parama;
  }
  
  private long a(g paramg, l.a parama)
  {
    AppMethodBeat.i(328561);
    int i = 0;
    if ((parama instanceof l.f)) {
      i = ((l.f)parama).responseCode;
    }
    Object localObject1 = paramg.uri.toString();
    h.log(4, getLogTag(), "retryOpen url=" + (String)localObject1 + " with responseCode=" + i);
    i = 0;
    Object localObject3;
    if ((!Thread.currentThread().isInterrupted()) && (i < sBL)) {
      if (this.sBN != null)
      {
        localObject3 = this.sBN.cvP();
        h.log(4, getLogTag(), "retryCount=" + i + " retryUrl=" + (String)localObject3);
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          break label458;
        }
        localObject3 = localObject1;
      }
    }
    label451:
    label458:
    for (;;)
    {
      if (((String)localObject3).equals(localObject1)) {
        h.log(5, getLogTag(), "retryUrl is same as origin url");
      }
      i += 1;
      int j = i * 2000;
      h.log(4, getLogTag(), "retry open retrying after " + j + " seconds  retry " + i + "/" + sBL);
      long l = j;
      try
      {
        Thread.sleep(l);
        localObject1 = new g(Uri.parse((String)localObject3), paramg.absoluteStreamPosition, paramg.position, paramg.length, paramg.key, paramg.flags, paramg.uuid, paramg.priority);
      }
      catch (InterruptedException paramg)
      {
        Thread.currentThread().interrupt();
        paramg = new l.b("retry open interrupted " + this.sBE, this.sAT);
        AppMethodBeat.o(328561);
        throw paramg;
      }
      try
      {
        l = super.b((g)localObject1);
        AppMethodBeat.o(328561);
        return l;
      }
      catch (l.a locala)
      {
        if ((this.sBE == null) || (!this.sBE.Bn(1))) {
          break label451;
        }
        h.log(4, getLogTag(), "abort retryOpen videoRequest is cancelling " + this.sBE + ", reason=" + h.s(locala));
        paramg = new l.b("retry open interrupted " + this.sBE, this.sAT);
        AppMethodBeat.o(328561);
        throw paramg;
        Object localObject2 = localObject3;
      }
      h.log(4, getLogTag(), "httpRetryLogic is null");
      AppMethodBeat.o(328561);
      throw parama;
      break;
    }
  }
  
  public final long a(g paramg)
  {
    AppMethodBeat.i(328598);
    this.uuid = paramg.uuid;
    long l;
    try
    {
      l = super.a(paramg);
      AppMethodBeat.o(328598);
      return l;
    }
    catch (l.a locala)
    {
      l = a(paramg, locala);
      AppMethodBeat.o(328598);
    }
    return l;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(328605);
    try
    {
      int i = super.read(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(328605);
      return i;
    }
    catch (l.a locala)
    {
      paramInt1 = a(paramArrayOfByte, paramInt1, paramInt2, locala);
      AppMethodBeat.o(328605);
    }
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.b.n
 * JD-Core Version:    0.7.0.1
 */