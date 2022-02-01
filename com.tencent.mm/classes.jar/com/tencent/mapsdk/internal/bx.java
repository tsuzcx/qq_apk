package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.tencent.map.sdk.comps.offlinemap.OfflineItem;
import com.tencent.map.sdk.comps.offlinemap.OfflineItemController;
import com.tencent.map.sdk.comps.offlinemap.OfflineStatus;
import com.tencent.map.sdk.comps.offlinemap.OfflineStatusChangedListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

final class bx
  implements OfflineItemController
{
  OfflineStatusChangedListener a;
  a b;
  private final mb c;
  private final by d;
  private final OfflineItem e;
  private final String f;
  private final File g;
  private final File h;
  private final File i;
  private String j;
  private final le k;
  private final b l;
  private boolean m;
  private final bm n;
  
  bx(bm parambm, String paramString, OfflineItem paramOfflineItem, by paramby, mb parammb, OfflineStatusChangedListener paramOfflineStatusChangedListener)
  {
    AppMethodBeat.i(222365);
    this.n = parambm;
    this.c = parammb;
    this.e = paramOfflineItem;
    this.d = paramby;
    this.a = paramOfflineStatusChangedListener;
    this.k = new le();
    this.l = new b((byte)0);
    this.k.b = hb.d();
    this.f = paramString;
    this.g = new File(paramString, paramby.c + ".zip");
    this.h = new File(paramString, paramby.a());
    this.i = new File(mf.a(parambm.getContext(), null).d(), paramby.a());
    AppMethodBeat.o(222365);
  }
  
  private void a()
  {
    AppMethodBeat.i(222396);
    if (!this.g.exists())
    {
      AppMethodBeat.o(222396);
      return;
    }
    try
    {
      kh.c("OM", "开始缓存文件校验...");
      String str = kq.a(this.g);
      kh.c("OM", "结束缓存文件校验...");
      if (!this.d.b.equals(str))
      {
        kh.d("OM", "缓存文件MD5不一致！");
        ka.b(this.g);
        AppMethodBeat.o(222396);
        return;
      }
      ka.b(this.h);
      kd.a(this.g, this.h.getParent(), new FilenameFilter()
      {
        public final boolean accept(File paramAnonymousFile, String paramAnonymousString)
        {
          AppMethodBeat.i(225691);
          boolean bool = bx.d(bx.this).getName().equals(paramAnonymousString);
          AppMethodBeat.o(225691);
          return bool;
        }
      });
      AppMethodBeat.o(222396);
      return;
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(222396);
    }
  }
  
  private void a(OfflineStatusChangedListener paramOfflineStatusChangedListener)
  {
    this.a = paramOfflineStatusChangedListener;
  }
  
  private void a(a parama)
  {
    this.b = parama;
  }
  
  private void b()
  {
    this.b = null;
    this.a = null;
  }
  
  final boolean a(bm parambm)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(222550);
        if (parambm == null)
        {
          AppMethodBeat.o(222550);
          return bool;
        }
        a();
        if (!this.h.exists())
        {
          AppMethodBeat.o(222550);
          continue;
        }
        parambm = parambm.y();
      }
      finally {}
      parambm.d();
      ka.a(this.h, this.i);
      parambm.e();
      parambm.f();
      this.m = true;
      if (this.b != null) {
        this.b.a(this.e, true);
      }
      if (this.a != null) {
        this.a.onStatusChanged(this.e, OfflineStatus.OPEN);
      }
      kh.c("OM", "开启[" + this.d.c + "]离线");
      AppMethodBeat.o(222550);
      bool = true;
    }
  }
  
  /* Error */
  final boolean b(bm parambm)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 241
    //   6: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: getfield 125	com/tencent/mapsdk/internal/bx:i	Ljava/io/File;
    //   13: invokevirtual 137	java/io/File:exists	()Z
    //   16: ifeq +7 -> 23
    //   19: aload_1
    //   20: ifnonnull +12 -> 32
    //   23: ldc 241
    //   25: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aload_0
    //   29: monitorexit
    //   30: iload_2
    //   31: ireturn
    //   32: aload_1
    //   33: invokevirtual 204	com/tencent/mapsdk/internal/bm:y	()Lcom/tencent/mapsdk/internal/br;
    //   36: astore_1
    //   37: aload_1
    //   38: invokeinterface 208 1 0
    //   43: aload_0
    //   44: getfield 125	com/tencent/mapsdk/internal/bx:i	Ljava/io/File;
    //   47: aload_0
    //   48: getfield 110	com/tencent/mapsdk/internal/bx:h	Ljava/io/File;
    //   51: invokestatic 211	com/tencent/mapsdk/internal/ka:a	(Ljava/io/File;Ljava/io/File;)Z
    //   54: pop
    //   55: aload_1
    //   56: invokeinterface 214 1 0
    //   61: pop
    //   62: aload_1
    //   63: invokeinterface 216 1 0
    //   68: aload_0
    //   69: getfield 184	com/tencent/mapsdk/internal/bx:b	Lcom/tencent/mapsdk/internal/bx$a;
    //   72: ifnull +17 -> 89
    //   75: aload_0
    //   76: getfield 184	com/tencent/mapsdk/internal/bx:b	Lcom/tencent/mapsdk/internal/bx$a;
    //   79: aload_0
    //   80: getfield 58	com/tencent/mapsdk/internal/bx:e	Lcom/tencent/map/sdk/comps/offlinemap/OfflineItem;
    //   83: iconst_0
    //   84: invokeinterface 221 3 0
    //   89: aload_0
    //   90: getfield 62	com/tencent/mapsdk/internal/bx:a	Lcom/tencent/map/sdk/comps/offlinemap/OfflineStatusChangedListener;
    //   93: ifnull +19 -> 112
    //   96: aload_0
    //   97: getfield 62	com/tencent/mapsdk/internal/bx:a	Lcom/tencent/map/sdk/comps/offlinemap/OfflineStatusChangedListener;
    //   100: aload_0
    //   101: getfield 58	com/tencent/mapsdk/internal/bx:e	Lcom/tencent/map/sdk/comps/offlinemap/OfflineItem;
    //   104: getstatic 244	com/tencent/map/sdk/comps/offlinemap/OfflineStatus:CLOSE	Lcom/tencent/map/sdk/comps/offlinemap/OfflineStatus;
    //   107: invokeinterface 233 3 0
    //   112: aload_0
    //   113: iconst_0
    //   114: putfield 218	com/tencent/mapsdk/internal/bx:m	Z
    //   117: ldc 139
    //   119: new 86	java/lang/StringBuilder
    //   122: dup
    //   123: ldc 246
    //   125: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   128: aload_0
    //   129: getfield 60	com/tencent/mapsdk/internal/bx:d	Lcom/tencent/mapsdk/internal/by;
    //   132: getfield 91	com/tencent/mapsdk/internal/by:c	Ljava/lang/String;
    //   135: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: ldc 240
    //   140: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 145	com/tencent/mapsdk/internal/kh:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: iconst_1
    //   150: istore_2
    //   151: ldc 241
    //   153: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: goto -128 -> 28
    //   159: astore_1
    //   160: aload_0
    //   161: monitorexit
    //   162: aload_1
    //   163: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	bx
    //   0	164	1	parambm	bm
    //   1	150	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	19	159	finally
    //   23	28	159	finally
    //   32	89	159	finally
    //   89	112	159	finally
    //   112	149	159	finally
    //   151	156	159	finally
  }
  
  public final boolean checkInvalidate()
  {
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(222497);
        by localby = this.d;
        if (localby != null)
        {
          this.j = (localby.a + File.separator + localby.c + localby.e + ".zip");
          mb localmb = this.c;
          if (localmb != null)
          {
            String str = localmb.a(localby.c + "-md5");
            int i1 = localmb.b(localby.c + "-version", -1);
            if (localby.e != i1) {
              break label304;
            }
            if ((str != null) && (!str.equals(localby.b)))
            {
              break label304;
              kh.c("OM", "检查是否需要更新:[" + bool1 + "]");
              if ((!bool1) && (!this.m) && (!this.h.exists()))
              {
                bool1 = bool2;
                if (this.g.exists())
                {
                  a();
                  if (this.h.exists()) {
                    break label299;
                  }
                  bool1 = bool2;
                }
                if (this.b != null) {
                  this.b.b(this.e, bool1);
                }
                AppMethodBeat.o(222497);
                return bool1;
              }
            }
            else
            {
              bool1 = false;
              continue;
            }
          }
          else
          {
            bool1 = false;
            continue;
          }
          continue;
        }
        bool1 = false;
      }
      finally {}
      label299:
      continue;
      label304:
      boolean bool1 = true;
    }
  }
  
  public final boolean close()
  {
    AppMethodBeat.i(222512);
    boolean bool = b(this.n);
    AppMethodBeat.o(222512);
    return bool;
  }
  
  public final boolean open()
  {
    AppMethodBeat.i(222506);
    boolean bool = a(this.n);
    AppMethodBeat.o(222506);
    return bool;
  }
  
  public final boolean removeCache()
  {
    AppMethodBeat.i(222540);
    boolean bool = ka.b(this.g);
    kh.c("OM", "删除[" + this.d.c + "]离线缓存");
    AppMethodBeat.o(222540);
    return bool;
  }
  
  public final void startDownload()
  {
    AppMethodBeat.i(222523);
    if (this.n == null)
    {
      if (this.a != null) {
        this.a.onStatusChanged(this.e, OfflineStatus.ERROR);
      }
      AppMethodBeat.o(222523);
      return;
    }
    if (this.g.exists())
    {
      jw.a(new jw.g()
      {
        private Boolean a()
        {
          AppMethodBeat.i(225713);
          boolean bool = bx.this.a(bx.c(bx.this));
          AppMethodBeat.o(225713);
          return Boolean.valueOf(bool);
        }
      }).a(new jw.a()
      {
        private void a(Boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(225668);
          if (paramAnonymousBoolean.booleanValue())
          {
            if (bx.a(bx.this) != null)
            {
              bx.a(bx.this).onStatusChanged(bx.b(bx.this), OfflineStatus.COMPLETED);
              AppMethodBeat.o(225668);
            }
          }
          else {
            bx.this.startDownload();
          }
          AppMethodBeat.o(225668);
        }
      });
      AppMethodBeat.o(222523);
      return;
    }
    if ((!checkInvalidate()) || (TextUtils.isEmpty(this.j)))
    {
      if (this.a != null) {
        this.a.onStatusChanged(this.e, OfflineStatus.ERROR);
      }
      AppMethodBeat.o(222523);
      return;
    }
    if (this.a != null) {
      this.k.a(this.l);
    }
    kh.c("OM", "请求下载:[" + this.j + "]");
    this.k.a(this.j, this.l);
    if (this.a != null) {
      this.a.onStatusChanged(this.e, OfflineStatus.READY);
    }
    AppMethodBeat.o(222523);
  }
  
  public final void stopDownload()
  {
    AppMethodBeat.i(222531);
    if (TextUtils.isEmpty(this.j))
    {
      AppMethodBeat.o(222531);
      return;
    }
    kh.c("OM", "停止下载:[" + this.j + "]");
    this.k.b(this.j);
    AppMethodBeat.o(222531);
  }
  
  static abstract interface a
  {
    public abstract void a(OfflineItem paramOfflineItem, int paramInt);
    
    public abstract void a(OfflineItem paramOfflineItem, boolean paramBoolean);
    
    public abstract void b(OfflineItem paramOfflineItem, boolean paramBoolean);
  }
  
  final class b
    extends lg
    implements ld
  {
    private lf c;
    private File d;
    
    private b() {}
    
    public final void a(lf paramlf)
    {
      AppMethodBeat.i(223119);
      kh.c("OM", "下载状态：".concat(String.valueOf(paramlf)));
      this.c = paramlf;
      AppMethodBeat.o(223119);
    }
    
    public final void a(String paramString)
    {
      AppMethodBeat.i(223084);
      this.d = new File(bx.e(bx.this), this.b + ".tmp");
      kh.c("OM", "开始下载:[" + this.d + "]");
      if (bx.a(bx.this) != null) {
        bx.a(bx.this).onStatusChanged(bx.b(bx.this), OfflineStatus.START);
      }
      AppMethodBeat.o(223084);
    }
    
    public final void a(String paramString, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(223108);
      if ((TextUtils.isEmpty(paramString)) || (!paramString.equals(bx.m(bx.this))) || (paramArrayOfByte == null))
      {
        AppMethodBeat.o(223108);
        return;
      }
      if ((this.c == lf.b) && (this.d != null))
      {
        int i = (int)(this.d.length() * 100L / bx.h(bx.this).d);
        if (bx.l(bx.this) != null) {
          bx.l(bx.this).a(bx.b(bx.this), i);
        }
        kh.c("OM", "缓存文件下载中:：length: " + this.d.length() + "：" + i + "%");
        ka.b(this.d, paramArrayOfByte);
      }
      if (bx.a(bx.this) != null) {
        bx.a(bx.this).onStatusChanged(bx.b(bx.this), OfflineStatus.DOWNLOADING);
      }
      AppMethodBeat.o(223108);
    }
    
    public final void b(String paramString)
    {
      AppMethodBeat.i(223091);
      if (this.d != null)
      {
        kh.d("OM", "取消下载:[" + this.d + "]");
        ka.b(this.d);
      }
      if (bx.a(bx.this) != null) {
        bx.a(bx.this).onStatusChanged(bx.b(bx.this), OfflineStatus.CANCEL);
      }
      AppMethodBeat.o(223091);
    }
    
    public final void c(String paramString)
    {
      AppMethodBeat.i(223100);
      if ((this.d == null) || (!this.d.exists()))
      {
        AppMethodBeat.o(223100);
        return;
      }
      kh.c("OM", "完成下载:[" + this.d + "]");
      kh.c("OM", "创建城市缓存文件:[" + bx.d(bx.this) + "]");
      ka.b(bx.d(bx.this));
      ka.a(this.d, bx.f(bx.this));
      bx.g(bx.this);
      if (!bx.d(bx.this).exists())
      {
        kh.d("OM", "缓存文件创建失败！");
        AppMethodBeat.o(223100);
        return;
      }
      kh.c("OM", "解压成功:[" + bx.d(bx.this) + "]");
      paramString = bx.h(bx.this);
      mb localmb = bx.i(bx.this);
      if (localmb != null)
      {
        localmb.a(paramString.c + "-md5", paramString.b);
        localmb.a(paramString.c + "-version", paramString.e);
      }
      kh.c("OM", "保持城市缓存信息:[" + paramString + "]");
      bx.k(bx.this).b(bx.j(bx.this));
      if (bx.l(bx.this) != null)
      {
        bx.l(bx.this).a(bx.b(bx.this), 100);
        bx.l(bx.this).b(bx.b(bx.this), false);
      }
      if (bx.a(bx.this) != null) {
        bx.a(bx.this).onStatusChanged(bx.b(bx.this), OfflineStatus.COMPLETED);
      }
      AppMethodBeat.o(223100);
    }
    
    public final void d(String paramString)
    {
      AppMethodBeat.i(223111);
      if (this.d != null)
      {
        kh.d("OM", "缓存文件下载失败！");
        ka.b(this.d);
      }
      if (bx.a(bx.this) != null) {
        bx.a(bx.this).onStatusChanged(bx.b(bx.this), OfflineStatus.ERROR);
      }
      AppMethodBeat.o(223111);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.bx
 * JD-Core Version:    0.7.0.1
 */