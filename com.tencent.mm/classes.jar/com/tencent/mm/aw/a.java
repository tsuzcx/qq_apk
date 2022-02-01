package com.tencent.mm.aw;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ov;
import com.tencent.mm.autogen.a.ov.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.List;

public final class a
{
  public static final String OK(String paramString)
  {
    AppMethodBeat.i(231038);
    Log.i("MicroMsg.MusicHelper", "markMusicVipIdPrefix:%s", new Object[] { paramString });
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(231038);
      return paramString;
    }
    paramString = "getlinkclisdkqqmusicmid_".concat(String.valueOf(paramString));
    AppMethodBeat.o(231038);
    return paramString;
  }
  
  public static final void a(f paramf)
  {
    AppMethodBeat.i(136995);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136988);
        ov localov = new ov();
        localov.hRE.action = 6;
        localov.hRE.hRG = a.this;
        localov.publish();
        AppMethodBeat.o(136988);
      }
    });
    AppMethodBeat.o(136995);
  }
  
  public static void b(f paramf)
  {
    AppMethodBeat.i(231033);
    ov localov = new ov();
    localov.hRE.action = 16;
    localov.hRE.hRG = paramf;
    localov.publish();
    AppMethodBeat.o(231033);
  }
  
  public static final void bLg()
  {
    AppMethodBeat.i(136991);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136981);
        ov localov = new ov();
        localov.hRE.action = 1;
        localov.publish();
        AppMethodBeat.o(136981);
      }
    });
    AppMethodBeat.o(136991);
  }
  
  public static final void bLh()
  {
    AppMethodBeat.i(136992);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136983);
        ov localov = new ov();
        localov.hRE.action = 2;
        localov.publish();
        AppMethodBeat.o(136983);
      }
    });
    AppMethodBeat.o(136992);
  }
  
  public static final void bLi()
  {
    AppMethodBeat.i(136993);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136984);
        ov localov = new ov();
        localov.hRE.action = -1;
        localov.publish();
        AppMethodBeat.o(136984);
      }
    });
    AppMethodBeat.o(136993);
  }
  
  public static final void bLj()
  {
    AppMethodBeat.i(136994);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136987);
        ov localov = new ov();
        localov.hRE.action = 11;
        localov.publish();
        AppMethodBeat.o(136987);
      }
    });
    AppMethodBeat.o(136994);
  }
  
  public static boolean bLk()
  {
    AppMethodBeat.i(136996);
    ov localov = new ov();
    localov.hRE.action = -3;
    localov.publish();
    boolean bool = localov.hRF.result;
    AppMethodBeat.o(136996);
    return bool;
  }
  
  public static boolean bLl()
  {
    AppMethodBeat.i(136997);
    ov localov = new ov();
    localov.hRE.action = 10;
    localov.publish();
    boolean bool = localov.hRF.result;
    AppMethodBeat.o(136997);
    return bool;
  }
  
  public static boolean bLm()
  {
    AppMethodBeat.i(136998);
    ov localov = new ov();
    localov.hRE.action = 9;
    localov.publish();
    boolean bool = localov.hRF.result;
    AppMethodBeat.o(136998);
    return bool;
  }
  
  public static f bLn()
  {
    AppMethodBeat.i(136999);
    Object localObject = new ov();
    ((ov)localObject).hRE.action = -2;
    ((ov)localObject).publish();
    localObject = ((ov)localObject).hRF.hRG;
    AppMethodBeat.o(136999);
    return localObject;
  }
  
  public static c bLo()
  {
    AppMethodBeat.i(137003);
    Object localObject = new ov();
    ((ov)localObject).hRE.action = 8;
    ((ov)localObject).publish();
    localObject = ((ov)localObject).hRF.hRK;
    AppMethodBeat.o(137003);
    return localObject;
  }
  
  public static void c(f paramf)
  {
    AppMethodBeat.i(137000);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136989);
        ov localov = new ov();
        localov.hRE.action = 0;
        localov.hRE.hRG = a.this;
        localov.publish();
        AppMethodBeat.o(136989);
      }
    });
    AppMethodBeat.o(137000);
  }
  
  public static void d(f paramf)
  {
    AppMethodBeat.i(137001);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136982);
        ov localov = new ov();
        localov.hRE.action = 3;
        localov.hRE.hRG = a.this;
        localov.publish();
        AppMethodBeat.o(136982);
      }
    });
    AppMethodBeat.o(137001);
  }
  
  public static boolean e(f paramf)
  {
    if (paramf == null) {
      return false;
    }
    switch (paramf.oOt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static void o(List<f> paramList, final int paramInt)
  {
    AppMethodBeat.i(182547);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136990);
        ov localov = new ov();
        localov.hRE.action = 4;
        localov.hRE.hJf = a.this;
        localov.hRE.hRH = paramInt;
        localov.publish();
        AppMethodBeat.o(136990);
      }
    });
    AppMethodBeat.o(182547);
  }
  
  public static boolean wH(int paramInt)
  {
    AppMethodBeat.i(137002);
    ov localov = new ov();
    localov.hRE.action = 7;
    localov.hRE.position = paramInt;
    localov.publish();
    boolean bool = localov.hRF.result;
    AppMethodBeat.o(137002);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.aw.a
 * JD-Core Version:    0.7.0.1
 */