package com.google.android.exoplayer2.h;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class m
  implements g
{
  private final w<? super g> bEG;
  private final g bFf;
  private g bFg;
  private g bFh;
  private g bFi;
  private g bFj;
  private g bhN;
  private final Context context;
  
  public m(Context paramContext, w<? super g> paramw, g paramg)
  {
    AppMethodBeat.i(93059);
    this.context = paramContext.getApplicationContext();
    this.bEG = paramw;
    this.bFf = ((g)a.checkNotNull(paramg));
    AppMethodBeat.o(93059);
  }
  
  private g wD()
  {
    AppMethodBeat.i(93064);
    if (this.bFh == null) {
      this.bFh = new c(this.context, this.bEG);
    }
    g localg = this.bFh;
    AppMethodBeat.o(93064);
    return localg;
  }
  
  private g wE()
  {
    AppMethodBeat.i(93065);
    if (this.bFj == null) {}
    try
    {
      this.bFj = ((g)Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
      label38:
      if (this.bFj == null) {
        this.bFj = this.bFf;
      }
      g localg = this.bFj;
      AppMethodBeat.o(93065);
      return localg;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      break label38;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label38;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label38;
    }
    catch (InstantiationException localInstantiationException)
    {
      break label38;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      break label38;
    }
  }
  
  public final long a(j paramj)
  {
    AppMethodBeat.i(93060);
    boolean bool;
    String str;
    if (this.bhN == null)
    {
      bool = true;
      a.checkState(bool);
      str = paramj.uri.getScheme();
      if (!x.o(paramj.uri)) {
        break label116;
      }
      if (!paramj.uri.getPath().startsWith("/android_asset/")) {
        break label83;
      }
      this.bhN = wD();
    }
    for (;;)
    {
      long l = this.bhN.a(paramj);
      AppMethodBeat.o(93060);
      return l;
      bool = false;
      break;
      label83:
      if (this.bFg == null) {
        this.bFg = new q(this.bEG);
      }
      this.bhN = this.bFg;
      continue;
      label116:
      if ("asset".equals(str))
      {
        this.bhN = wD();
      }
      else if ("content".equals(str))
      {
        if (this.bFi == null) {
          this.bFi = new e(this.context, this.bEG);
        }
        this.bhN = this.bFi;
      }
      else if ("rtmp".equals(str))
      {
        this.bhN = wE();
      }
      else
      {
        this.bhN = this.bFf;
      }
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(93063);
    if (this.bhN != null) {
      try
      {
        this.bhN.close();
        return;
      }
      finally
      {
        this.bhN = null;
        AppMethodBeat.o(93063);
      }
    }
    AppMethodBeat.o(93063);
  }
  
  public final Uri getUri()
  {
    AppMethodBeat.i(93062);
    if (this.bhN == null)
    {
      AppMethodBeat.o(93062);
      return null;
    }
    Uri localUri = this.bhN.getUri();
    AppMethodBeat.o(93062);
    return localUri;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93061);
    paramInt1 = this.bhN.read(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(93061);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.h.m
 * JD-Core Version:    0.7.0.1
 */