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
  private g aXs;
  private final g buQ;
  private g buR;
  private g buS;
  private g buT;
  private g buU;
  private final w<? super g> bur;
  private final Context context;
  
  public m(Context paramContext, w<? super g> paramw, g paramg)
  {
    AppMethodBeat.i(93059);
    this.context = paramContext.getApplicationContext();
    this.bur = paramw;
    this.buQ = ((g)a.checkNotNull(paramg));
    AppMethodBeat.o(93059);
  }
  
  private g vg()
  {
    AppMethodBeat.i(93064);
    if (this.buS == null) {
      this.buS = new c(this.context, this.bur);
    }
    g localg = this.buS;
    AppMethodBeat.o(93064);
    return localg;
  }
  
  private g vh()
  {
    AppMethodBeat.i(93065);
    if (this.buU == null) {}
    try
    {
      this.buU = ((g)Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
      label38:
      if (this.buU == null) {
        this.buU = this.buQ;
      }
      g localg = this.buU;
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
    if (this.aXs == null)
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
      this.aXs = vg();
    }
    for (;;)
    {
      long l = this.aXs.a(paramj);
      AppMethodBeat.o(93060);
      return l;
      bool = false;
      break;
      label83:
      if (this.buR == null) {
        this.buR = new q(this.bur);
      }
      this.aXs = this.buR;
      continue;
      label116:
      if ("asset".equals(str))
      {
        this.aXs = vg();
      }
      else if ("content".equals(str))
      {
        if (this.buT == null) {
          this.buT = new e(this.context, this.bur);
        }
        this.aXs = this.buT;
      }
      else if ("rtmp".equals(str))
      {
        this.aXs = vh();
      }
      else
      {
        this.aXs = this.buQ;
      }
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(93063);
    if (this.aXs != null) {
      try
      {
        this.aXs.close();
        return;
      }
      finally
      {
        this.aXs = null;
        AppMethodBeat.o(93063);
      }
    }
    AppMethodBeat.o(93063);
  }
  
  public final Uri getUri()
  {
    AppMethodBeat.i(93062);
    if (this.aXs == null)
    {
      AppMethodBeat.o(93062);
      return null;
    }
    Uri localUri = this.aXs.getUri();
    AppMethodBeat.o(93062);
    return localUri;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93061);
    paramInt1 = this.aXs.read(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(93061);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.h.m
 * JD-Core Version:    0.7.0.1
 */