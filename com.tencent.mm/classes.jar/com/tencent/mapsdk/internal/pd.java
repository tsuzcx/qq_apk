package com.tencent.mapsdk.internal;

import android.content.Context;
import android.os.AsyncTask;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.lang.ref.WeakReference;

public final class pd
  extends AsyncTask<Object, Void, Boolean>
{
  private WeakReference<Context> a;
  private WeakReference<a> b;
  private ri c;
  
  public pd(bg parambg, a parama)
  {
    AppMethodBeat.i(225507);
    this.a = new WeakReference(parambg.c);
    this.c = parambg.b.k.b;
    this.b = new WeakReference(parama);
    AppMethodBeat.o(225507);
  }
  
  private Boolean a()
  {
    AppMethodBeat.i(225530);
    if (this.a.get() == null)
    {
      localObject1 = Boolean.FALSE;
      AppMethodBeat.o(225530);
      return localObject1;
    }
    Object localObject1 = (Context)this.a.get();
    try
    {
      localObject2 = (cw)((dk)cj.a(dk.class)).h();
      Object localObject3 = gw.a();
      Object localObject4 = gw.h();
      int j = this.c.d;
      Object localObject5 = gw.d();
      int k = this.c.f;
      Object localObject6 = this.c;
      switch (ri.3.a[localObject6.i.ordinal()])
      {
      case 1: 
      case 2: 
        for (;;)
        {
          localObject2 = ((cw)localObject2).checkAuth((String)localObject3, (String)localObject4, j, (String)localObject5, k, 3, i);
          if ((localObject2 != null) && (((NetResponse)localObject2).available())) {
            break;
          }
          localObject1 = Boolean.FALSE;
          AppMethodBeat.o(225530);
          return localObject1;
          i = 2;
          continue;
          i = 1;
        }
        localObject2 = ((NetResponse)localObject2).toString();
        if (localObject2 != null)
        {
          if (((String)localObject2).length() == 0) {
            break label799;
          }
          for (;;)
          {
            AppMethodBeat.o(225530);
            return Boolean.valueOf(bool1);
            localObject3 = this.c;
            kh.c("TO", "开始更新配置：".concat(String.valueOf(localObject2)));
            localObject4 = (rq)JsonUtils.parseToModel((String)localObject2, rq.class, new Object[0]);
            if (localObject4 != null)
            {
              localObject5 = ((rq)localObject4).b;
              if (localObject5 != null) {
                break;
              }
            }
            kh.c("TO", "配置更新数据解析失败，使用上次的配置");
            bool1 = false;
          }
          if (((rq)localObject4).a != 0) {
            bool1 = ((ri)localObject3).e;
          }
          for (((ri)localObject3).e = false;; ((ri)localObject3).e = true)
          {
            kh.c("TO", "权限是否更新：".concat(String.valueOf(bool1)));
            if (((rp)localObject5).g == ((ri)localObject3).d) {
              break label811;
            }
            bool2 = true;
            kh.c("TO", "协议版本是否更新：".concat(String.valueOf(bool2)));
            if ((bool2 | bool1)) {
              break label385;
            }
            bool1 = false;
            break;
            if (((ri)localObject3).e) {
              break label805;
            }
            bool1 = true;
          }
          label385:
          localObject6 = ((ri)localObject3).a((rp)localObject5);
          if (localObject6 != null)
          {
            i = ((rl)localObject6).d;
            localObject6 = ((rl)localObject6).e;
            if (localObject6 != null)
            {
              j = ((rr)localObject6).d;
              k = ((rr)localObject6).b;
              kh.c("TO", "版本对比: old[" + ((ri)localObject3).c + "]-new[" + j + "]");
              kh.c("TO", "样式对比: old[" + ((ri)localObject3).b + "]-new[" + k + "]");
              if ((j != ((ri)localObject3).c) || (k != ((ri)localObject3).b) || (i != ((ri)localObject3).a))
              {
                localObject6 = new File(mf.a((Context)localObject1, null).b(), ((ri)localObject3).a());
                if (((File)localObject6).exists())
                {
                  ka.b((File)localObject6);
                  kh.c("TO", "删除海外图缓存目录: ".concat(String.valueOf(localObject6)));
                }
              }
            }
          }
          localObject5 = ((rp)localObject5).h;
          if (localObject5 != null)
          {
            localObject6 = ((ro)localObject5).b;
            kh.c("TO", "配置边界线: ".concat(String.valueOf(localObject6)));
            ((ri)localObject3).a((String)localObject6);
            ((ro)localObject5).a = ((ri)localObject3).f;
          }
          ((ri)localObject3).g = ((rq)localObject4);
          localObject4 = ((ri)localObject3).i;
          localObject1 = me.a((Context)localObject1);
          switch (ri.3.a[localObject4.ordinal()])
          {
          case 1: 
            for (;;)
            {
              ((ri)localObject3).a(((ri)localObject3).g);
              kh.c("TO", "配置更新完成");
              bool1 = true;
              break;
              ((me)localObject1).a("worldMapConfig", (String)localObject2);
            }
          }
        }
        break;
      }
    }
    finally
    {
      for (;;)
      {
        Object localObject2 = localThrowable.getMessage();
        if (kh.a != null) {
          kh.a.b((String)localObject2, localThrowable);
        }
        for (;;)
        {
          Boolean localBoolean = Boolean.FALSE;
          AppMethodBeat.o(225530);
          return localBoolean;
          localBoolean.a("worldMapConfig_BING", (String)localObject2);
          break;
          kh.c((String)localObject2, localBoolean);
        }
        int i = 0;
        continue;
        label799:
        boolean bool1 = false;
        continue;
        label805:
        bool1 = false;
        continue;
        label811:
        boolean bool2 = false;
      }
    }
  }
  
  private void a(Boolean paramBoolean)
  {
    AppMethodBeat.i(225538);
    super.onPostExecute(paramBoolean);
    if ((this.b != null) && (this.b.get() != null)) {
      ((a)this.b.get()).a(paramBoolean.booleanValue(), this.c);
    }
    AppMethodBeat.o(225538);
  }
  
  private boolean a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(225555);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(225555);
      return false;
    }
    ri localri = this.c;
    kh.c("TO", "开始更新配置：".concat(String.valueOf(paramString)));
    Object localObject1 = (rq)JsonUtils.parseToModel(paramString, rq.class, new Object[0]);
    if (localObject1 != null)
    {
      localObject2 = ((rq)localObject1).b;
      if (localObject2 != null) {}
    }
    else
    {
      kh.c("TO", "配置更新数据解析失败，使用上次的配置");
      AppMethodBeat.o(225555);
      return false;
    }
    boolean bool1;
    if (((rq)localObject1).a != 0)
    {
      bool1 = localri.e;
      localri.e = false;
      kh.c("TO", "权限是否更新：".concat(String.valueOf(bool1)));
      if (((rp)localObject2).g == localri.d) {
        break label201;
      }
    }
    label201:
    for (boolean bool2 = true;; bool2 = false)
    {
      kh.c("TO", "协议版本是否更新：".concat(String.valueOf(bool2)));
      if ((bool1 | bool2)) {
        break label207;
      }
      AppMethodBeat.o(225555);
      return false;
      if (!localri.e) {}
      for (bool1 = true;; bool1 = false)
      {
        localri.e = true;
        break;
      }
    }
    label207:
    Object localObject3 = localri.a((rp)localObject2);
    if (localObject3 != null)
    {
      int i = ((rl)localObject3).d;
      localObject3 = ((rl)localObject3).e;
      if (localObject3 != null)
      {
        int j = ((rr)localObject3).d;
        int k = ((rr)localObject3).b;
        kh.c("TO", "版本对比: old[" + localri.c + "]-new[" + j + "]");
        kh.c("TO", "样式对比: old[" + localri.b + "]-new[" + k + "]");
        if ((j != localri.c) || (k != localri.b) || (i != localri.a))
        {
          localObject3 = new File(mf.a(paramContext, null).b(), localri.a());
          if (((File)localObject3).exists())
          {
            ka.b((File)localObject3);
            kh.c("TO", "删除海外图缓存目录: ".concat(String.valueOf(localObject3)));
          }
        }
      }
    }
    Object localObject2 = ((rp)localObject2).h;
    if (localObject2 != null)
    {
      localObject3 = ((ro)localObject2).b;
      kh.c("TO", "配置边界线: ".concat(String.valueOf(localObject3)));
      localri.a((String)localObject3);
      ((ro)localObject2).a = localri.f;
    }
    localri.g = ((rq)localObject1);
    localObject1 = localri.i;
    paramContext = me.a(paramContext);
    switch (ri.3.a[localObject1.ordinal()])
    {
    }
    for (;;)
    {
      localri.a(localri.g);
      kh.c("TO", "配置更新完成");
      AppMethodBeat.o(225555);
      return true;
      paramContext.a("worldMapConfig", paramString);
      continue;
      paramContext.a("worldMapConfig_BING", paramString);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, ri paramri);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.pd
 * JD-Core Version:    0.7.0.1
 */