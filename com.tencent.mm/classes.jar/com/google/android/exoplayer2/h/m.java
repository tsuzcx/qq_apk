package com.google.android.exoplayer2.h;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class m
  implements g
{
  private g aWG;
  private final g bwU;
  private g bwV;
  private g bwW;
  private g bwX;
  private g bwY;
  private final x<? super g> bws;
  private final Context context;
  
  public m(Context paramContext, x<? super g> paramx, g paramg)
  {
    AppMethodBeat.i(93059);
    this.context = paramContext.getApplicationContext();
    this.bws = paramx;
    this.bwU = ((g)a.checkNotNull(paramg));
    AppMethodBeat.o(93059);
  }
  
  private g vn()
  {
    AppMethodBeat.i(93064);
    if (this.bwW == null) {
      this.bwW = new c(this.context, this.bws);
    }
    g localg = this.bwW;
    AppMethodBeat.o(93064);
    return localg;
  }
  
  private g vo()
  {
    AppMethodBeat.i(93065);
    if (this.bwY == null) {}
    try
    {
      this.bwY = ((g)Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
      label38:
      if (this.bwY == null) {
        this.bwY = this.bwU;
      }
      g localg = this.bwY;
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
    if (this.aWG == null)
    {
      bool = true;
      a.checkState(bool);
      str = paramj.uri.getScheme();
      if (!com.google.android.exoplayer2.i.x.o(paramj.uri)) {
        break label116;
      }
      if (!paramj.uri.getPath().startsWith("/android_asset/")) {
        break label83;
      }
      this.aWG = vn();
    }
    for (;;)
    {
      long l = this.aWG.a(paramj);
      AppMethodBeat.o(93060);
      return l;
      bool = false;
      break;
      label83:
      if (this.bwV == null) {
        this.bwV = new q(this.bws);
      }
      this.aWG = this.bwV;
      continue;
      label116:
      if ("asset".equals(str))
      {
        this.aWG = vn();
      }
      else if ("content".equals(str))
      {
        if (this.bwX == null) {
          this.bwX = new e(this.context, this.bws);
        }
        this.aWG = this.bwX;
      }
      else if ("rtmp".equals(str))
      {
        this.aWG = vo();
      }
      else
      {
        this.aWG = this.bwU;
      }
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(93063);
    if (this.aWG != null) {
      try
      {
        this.aWG.close();
        return;
      }
      finally
      {
        this.aWG = null;
        AppMethodBeat.o(93063);
      }
    }
    AppMethodBeat.o(93063);
  }
  
  public final Uri getUri()
  {
    AppMethodBeat.i(93062);
    if (this.aWG == null)
    {
      AppMethodBeat.o(93062);
      return null;
    }
    Uri localUri = this.aWG.getUri();
    AppMethodBeat.o(93062);
    return localUri;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93061);
    paramInt1 = this.aWG.read(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(93061);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.h.m
 * JD-Core Version:    0.7.0.1
 */