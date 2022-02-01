package com.tencent.mm.modelavatar;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.plugin.emoji.c.c;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
import junit.framework.Assert;

public final class f
  implements com.tencent.mm.am.h
{
  j orT;
  d osj;
  m osk;
  boolean osl;
  private boolean osm;
  private boolean osn;
  private Handler oso;
  
  public f()
  {
    AppMethodBeat.i(150274);
    this.orT = null;
    this.osj = null;
    this.osk = null;
    this.osl = false;
    this.osm = true;
    this.osn = true;
    this.oso = null;
    com.tencent.mm.kernel.h.aZW().a(158, this);
    AppMethodBeat.o(150274);
  }
  
  private static int a(a parama)
  {
    AppMethodBeat.i(231367);
    com.tencent.threadpool.h.ahAA.i(parama, "get-hd-headimg");
    AppMethodBeat.o(231367);
    return 0;
  }
  
  private int a(j paramj)
  {
    AppMethodBeat.i(150278);
    if (this.oso == null) {
      this.oso = new Handler(Looper.myLooper());
    }
    int i = a(new f.c(this, paramj));
    AppMethodBeat.o(150278);
    return i;
  }
  
  public final void Qh()
  {
    AppMethodBeat.i(150275);
    com.tencent.mm.kernel.h.aZW().b(158, this);
    AppMethodBeat.o(150275);
  }
  
  public final int a(String paramString, d paramd)
  {
    AppMethodBeat.i(150276);
    int i = a(paramString, paramd, "");
    AppMethodBeat.o(150276);
    return i;
  }
  
  public final int a(String paramString1, d paramd, String paramString2)
  {
    AppMethodBeat.i(231381);
    if (paramd != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("GetHDHeadImg must set callback", bool);
      if (!Util.isNullOrNil(paramString1)) {
        break;
      }
      paramd.resultCallback(3, -101);
      AppMethodBeat.o(231381);
      return -101;
    }
    this.osj = paramd;
    if (au.bwS(paramString1)) {}
    for (String str = au.bxd(paramString1);; str = paramString1)
    {
      this.orT = q.bFE().LS(str);
      Log.d("MicroMsg.GetHDHeadImgHelper", "GetHDHeadImg: %s", new Object[] { str });
      if ((this.orT == null) || (!this.orT.getUsername().equals(str)))
      {
        this.orT = new j();
        this.orT.username = str;
        if (!TextUtils.isEmpty(paramString2)) {
          this.orT.osN = paramString2;
        }
      }
      if (Util.isNullOrNil(this.orT.bFw()))
      {
        Log.w("MicroMsg.GetHDHeadImgHelper", "dkhurl [%s] has NO URL flag:%d !", new Object[] { paramString1, Integer.valueOf(this.orT.jZY) });
        this.osk = new m(str);
        if (!com.tencent.mm.kernel.h.aZW().a(this.osk, 0))
        {
          paramd.resultCallback(3, -102);
          AppMethodBeat.o(231381);
          return -102;
        }
        AppMethodBeat.o(231381);
        return 0;
      }
      if (a(this.orT) == 0)
      {
        AppMethodBeat.o(231381);
        return 0;
      }
      paramd.resultCallback(3, -103);
      AppMethodBeat.o(231381);
      return -103;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(150277);
    this.osj.resultCallback(paramInt1, paramInt2);
    AppMethodBeat.o(150277);
  }
  
  static abstract class a
    implements QueueWorkerThread.ThreadObject, Runnable
  {
    private final Handler mHandler;
    
    public a(Handler paramHandler)
    {
      this.mHandler = paramHandler;
    }
    
    public void run()
    {
      if (doInBackground()) {
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(231358);
            f.a.this.onPostExecute();
            AppMethodBeat.o(231358);
          }
        });
      }
    }
  }
  
  final class b
    extends f.a
  {
    boolean djI;
    boolean isHevc;
    j orT;
    String osq;
    String osr;
    boolean oss;
    
    public b(j paramj, String paramString1, String paramString2)
    {
      super();
      AppMethodBeat.i(231321);
      this.oss = true;
      this.isHevc = false;
      this.orT = paramj;
      this.osq = paramString1;
      this.osr = paramString2;
      this.djI = false;
      AppMethodBeat.o(231321);
    }
    
    public final boolean doInBackground()
    {
      AppMethodBeat.i(150269);
      Object localObject;
      String str1;
      String str2;
      if (this.djI)
      {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(138, 61);
        Log.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: decrypt %s", new Object[] { this.osr });
        localObject = UtilsJni.DecryptAvatar(y.bi(this.osr, 0, -1));
        if ((localObject != null) && (localObject.length > 0))
        {
          y.deleteFile(this.osr);
          y.f(this.osr, (byte[])localObject, localObject.length);
        }
      }
      else
      {
        if (!ImgUtil.isWXGF(this.osr)) {
          break label334;
        }
        this.isHevc = true;
        Log.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: hevc to pic start");
        com.tencent.mm.plugin.report.service.h.OAn.kJ(138, 63);
        localObject = this.osr + "_hevc";
        boolean bool1 = y.qn(this.osr, (String)localObject);
        boolean bool2 = y.bEp(this.osr);
        str1 = y.n(this.osr, true);
        str2 = y.n((String)localObject, false);
        if ((str1 != null) && (str2 != null)) {
          break label281;
        }
        Log.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: uri is null %s, %s; path %s, %s; result %s, %s", new Object[] { str1, str2, this.osr, localObject, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        com.tencent.mm.plugin.report.service.h.OAn.kJ(138, 65);
        AppMethodBeat.o(150269);
        return true;
      }
      com.tencent.mm.plugin.report.service.h.OAn.kJ(138, 62);
      Log.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: decrypt failed");
      AppMethodBeat.o(150269);
      return true;
      label281:
      int i = ((c)com.tencent.mm.kernel.h.ax(c.class)).nativeWxam2Pic(str2, str1);
      y.deleteFile((String)localObject);
      if (i != 0)
      {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(138, 64);
        Log.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: hevc to pic failed");
        AppMethodBeat.o(150269);
        return true;
      }
      label334:
      this.oss = false;
      AppMethodBeat.o(150269);
      return true;
    }
    
    public final boolean onPostExecute()
    {
      AppMethodBeat.i(150270);
      if (f.this.osl)
      {
        AppMethodBeat.o(150270);
        return false;
      }
      if (this.oss)
      {
        if ((this.isHevc) && (f.c(f.this)))
        {
          Log.i("MicroMsg.GetHDHeadImgHelper", "onPostExecute: first request hevc failed");
          f.d(f.this);
          f.e(f.this);
          f.b(new f.c(f.this, this.orT));
        }
        for (;;)
        {
          AppMethodBeat.o(150270);
          return false;
          f.this.osj.resultCallback(3, -1);
        }
      }
      y.deleteFile(this.osq);
      y.qn(this.osr, this.osq);
      m.bs(this.osq, this.orT.getUsername());
      f.this.osj.resultCallback(0, 0);
      AppMethodBeat.o(150270);
      return true;
    }
  }
  
  public static abstract interface d
  {
    public abstract int resultCallback(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelavatar.f
 * JD-Core Version:    0.7.0.1
 */