package com.google.android.exoplayer2.h;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.i.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class l
  implements f
{
  private final t<? super f> aQN;
  private final f aRr;
  private f aRs;
  private f aRt;
  private f aRu;
  private f aRv;
  private f ayZ;
  private final Context context;
  
  public l(Context paramContext, t<? super f> paramt, f paramf)
  {
    this.context = paramContext.getApplicationContext();
    this.aQN = paramt;
    this.aRr = ((f)a.E(paramf));
  }
  
  private f nV()
  {
    if (this.aRt == null) {
      this.aRt = new c(this.context, this.aQN);
    }
    return this.aRt;
  }
  
  private f nW()
  {
    if (this.aRv == null) {}
    try
    {
      this.aRv = ((f)Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
      label33:
      if (this.aRv == null) {
        this.aRv = this.aRr;
      }
      return this.aRv;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      break label33;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label33;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label33;
    }
    catch (InstantiationException localInstantiationException)
    {
      break label33;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      break label33;
    }
  }
  
  public final long a(i parami)
  {
    boolean bool;
    String str;
    if (this.ayZ == null)
    {
      bool = true;
      a.aC(bool);
      str = parami.uri.getScheme();
      if (!com.google.android.exoplayer2.i.t.f(parami.uri)) {
        break label103;
      }
      if (!parami.uri.getPath().startsWith("/android_asset/")) {
        break label70;
      }
      this.ayZ = nV();
    }
    for (;;)
    {
      return this.ayZ.a(parami);
      bool = false;
      break;
      label70:
      if (this.aRs == null) {
        this.aRs = new p(this.aQN);
      }
      this.ayZ = this.aRs;
      continue;
      label103:
      if ("asset".equals(str))
      {
        this.ayZ = nV();
      }
      else if ("content".equals(str))
      {
        if (this.aRu == null) {
          this.aRu = new e(this.context, this.aQN);
        }
        this.ayZ = this.aRu;
      }
      else if ("rtmp".equals(str))
      {
        this.ayZ = nW();
      }
      else
      {
        this.ayZ = this.aRr;
      }
    }
  }
  
  public final void close()
  {
    if (this.ayZ != null) {}
    try
    {
      this.ayZ.close();
      return;
    }
    finally
    {
      this.ayZ = null;
    }
  }
  
  public final Uri getUri()
  {
    if (this.ayZ == null) {
      return null;
    }
    return this.ayZ.getUri();
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return this.ayZ.read(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.h.l
 * JD-Core Version:    0.7.0.1
 */