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
  private static int lnf = 3;
  private static boolean lnh;
  private com.tencent.mm.plugin.appbrand.jsapi.video.b.c.n lmY;
  private com.tencent.mm.plugin.appbrand.jsapi.video.b.c.e lni;
  private int lnj;
  private String uuid;
  
  public n(String paramString, i<String> parami, s params, com.tencent.mm.plugin.appbrand.jsapi.video.b.c.e parame, com.tencent.mm.plugin.appbrand.jsapi.video.b.e.e<Map<String, List<String>>> parame1, com.tencent.mm.plugin.appbrand.jsapi.video.b.c.n paramn)
  {
    super(paramString, parami, params, true, parame1);
    AppMethodBeat.i(206063);
    this.lnj = 0;
    this.lni = parame;
    this.lmY = paramn;
    if (!lnh)
    {
      lnf = a.bnx().lmh;
      lnh = true;
    }
    AppMethodBeat.o(206063);
  }
  
  private int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, l.a parama)
  {
    AppMethodBeat.i(206067);
    h.log(4, getLogTag(), "read source error occurred " + parama.toString());
    this.lnj += 1;
    long l1 = this.lmn.position + this.bytesRead;
    int i = this.lnj * 2000;
    h.log(4, getLogTag(), "retrying after " + i + " ms, read start at offset " + l1 + " retry " + this.lnj + "/" + lnf);
    long l2 = i;
    g localg;
    try
    {
      Thread.sleep(l2);
      localg = new g(Uri.parse(getUri()), 0L, l1, -1L, null, 0, this.uuid, this.lmn.priority);
      if ((Thread.currentThread().isInterrupted()) || (this.lnj >= lnf)) {
        break label306;
      }
      if (this.lmY.tz(1))
      {
        h.log(4, getLogTag(), "abort retry videoRequest is cancelling " + this.lmY);
        paramArrayOfByte = new l.c("readRetry interrupted " + this.lmY, this.lmn);
        AppMethodBeat.o(206067);
        throw paramArrayOfByte;
      }
    }
    catch (InterruptedException paramArrayOfByte)
    {
      h.log(5, getLogTag(), "readRetry interrupted");
      AppMethodBeat.o(206067);
      throw parama;
    }
    a(localg);
    paramInt1 = read(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(206067);
    return paramInt1;
    label306:
    AppMethodBeat.o(206067);
    throw parama;
  }
  
  private long a(g paramg, l.a parama)
  {
    AppMethodBeat.i(206065);
    int i = 0;
    if ((parama instanceof l.f)) {
      i = ((l.f)parama).responseCode;
    }
    Object localObject1 = paramg.uri.toString();
    h.log(4, getLogTag(), "retryOpen url=" + (String)localObject1 + " with responseCode=" + i);
    i = 0;
    Object localObject3;
    if ((!Thread.currentThread().isInterrupted()) && (i < lnf)) {
      if (this.lni != null)
      {
        localObject3 = this.lni.bnF();
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
      h.log(4, getLogTag(), "retry open retrying after " + j + " seconds  retry " + i + "/" + lnf);
      long l = j;
      try
      {
        Thread.sleep(l);
        localObject1 = new g(Uri.parse((String)localObject3), paramg.absoluteStreamPosition, paramg.position, paramg.length, paramg.key, paramg.flags, paramg.uuid, paramg.priority);
      }
      catch (InterruptedException paramg)
      {
        Thread.currentThread().interrupt();
        paramg = new l.b("retry open interrupted " + this.lmY, this.lmn);
        AppMethodBeat.o(206065);
        throw paramg;
      }
      try
      {
        l = super.b((g)localObject1);
        AppMethodBeat.o(206065);
        return l;
      }
      catch (l.a locala)
      {
        if ((this.lmY == null) || (!this.lmY.tz(1))) {
          break label451;
        }
        h.log(4, getLogTag(), "abort retryOpen videoRequest is cancelling " + this.lmY + ", reason=" + h.h(locala));
        paramg = new l.b("retry open interrupted " + this.lmY, this.lmn);
        AppMethodBeat.o(206065);
        throw paramg;
        Object localObject2 = localObject3;
      }
      h.log(4, getLogTag(), "httpRetryLogic is null");
      AppMethodBeat.o(206065);
      throw parama;
      break;
    }
  }
  
  public final long a(g paramg)
  {
    AppMethodBeat.i(206064);
    this.uuid = paramg.uuid;
    long l;
    try
    {
      l = super.a(paramg);
      AppMethodBeat.o(206064);
      return l;
    }
    catch (l.a locala)
    {
      l = a(paramg, locala);
      AppMethodBeat.o(206064);
    }
    return l;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(206066);
    try
    {
      int i = super.read(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(206066);
      return i;
    }
    catch (l.a locala)
    {
      paramInt1 = a(paramArrayOfByte, paramInt1, paramInt2, locala);
      AppMethodBeat.o(206066);
    }
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.b.n
 * JD-Core Version:    0.7.0.1
 */