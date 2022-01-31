package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.h.b.a.av;
import com.tencent.mm.h.b.a.r;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.dynamic.j.a;
import com.tencent.mm.plugin.appbrand.dynamic.j.a.2;
import com.tencent.mm.plugin.appbrand.dynamic.j.a.d;
import com.tencent.mm.plugin.appbrand.dynamic.j.a.e;
import com.tencent.mm.plugin.appbrand.dynamic.j.d;
import com.tencent.mm.protocal.c.cll;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;

final class WxaWidgetInitializer$1
  implements Runnable
{
  WxaWidgetInitializer$1(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, int paramInt4, String paramString3, int paramInt5, WxaWidgetInitializer.a parama, String paramString4, String paramString5) {}
  
  public final void run()
  {
    y.d("MicroMsg.WxaWidgetInitializer", "initialize(id : %s, pkgType : %s, version : %s)", new Object[] { this.BD, Integer.valueOf(this.fAF), Integer.valueOf(this.fUd) });
    u.i("MicroMsg.WxaWidgetInitializer", "initialize(id : %s, pkgType : %s, version : %s)", new Object[] { this.BD, Integer.valueOf(this.fAF), Integer.valueOf(this.fUd) });
    long l = System.currentTimeMillis();
    v.jdMethod_if(1);
    Object localObject1 = a.a(this.val$appId, this.fAF, this.fUd, this.fUe, this.egz, this.fUf);
    if (localObject1 == null)
    {
      y.e("MicroMsg.WxaWidgetInitializer", "getLaunchWxaWidgetInfo(id : %s, pkgType : %s, version : %s) return null.", new Object[] { this.BD, Integer.valueOf(this.fAF), Integer.valueOf(this.fUd) });
      v.jdMethod_if(3);
      localObject1 = new r();
      ((r)localObject1).cjr = this.BD;
      ((r)localObject1).cjv = u.jy(this.BD);
      ((r)localObject1).cjw = this.fUg;
      ((r)localObject1).cjs = 2L;
      ((r)localObject1).cjt = System.currentTimeMillis();
      ((r)localObject1).cju = 2L;
      ((r)localObject1).cjy = aq.fH(ae.getContext());
      ((r)localObject1).QX();
      u.i("MicroMsg.WxaWidgetInitializer", "getLaunchWxaWidgetInfo(id : %s, pkgType : %s, version : %s) return null.", new Object[] { this.BD, Integer.valueOf(this.fAF), Integer.valueOf(this.fUd) });
      if (this.fUh != null) {
        this.fUh.a(this.BD, this.val$appId, false, null);
      }
    }
    Object localObject2;
    String str;
    label579:
    int i;
    do
    {
      return;
      u.i("MicroMsg.WxaWidgetInitializer", "get lauch info , replace version %d with %d", new Object[] { Integer.valueOf(this.fUd), Integer.valueOf(((d)localObject1).fXq.sCy) });
      localObject2 = new r();
      ((r)localObject2).cjr = this.BD;
      ((r)localObject2).cjv = u.jy(this.BD);
      ((r)localObject2).cjw = this.fUg;
      ((r)localObject2).cjs = 2L;
      ((r)localObject2).cjt = System.currentTimeMillis();
      ((r)localObject2).cju = 1L;
      ((r)localObject2).cjy = aq.fH(ae.getContext());
      ((r)localObject2).QX();
      v.jdMethod_if(2);
      localObject2 = a.a(this.BD, this.val$appId, this.fUi, this.fAF, ((d)localObject1).fXq.sCy, this.fUj);
      if (localObject2 != null)
      {
        u.i("MicroMsg.WxaWidgetInitializer", "get WxaPkgWrapping info", new Object[0]);
        localObject1 = WxaWidgetInitializer.a(this.BD, this.val$appId, (WxaPkgWrappingInfo)localObject2, (d)localObject1);
        if (this.fUh != null)
        {
          localObject2 = this.fUh;
          str = this.BD;
          localObject3 = this.val$appId;
          if (localObject1 == null) {
            break label579;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          ((WxaWidgetInitializer.a)localObject2).a(str, (String)localObject3, bool, (WxaWidgetContext)localObject1);
          localObject1 = new av();
          ((av)localObject1).cfv = 1L;
          ((av)localObject1).cjv = this.val$appId;
          ((av)localObject1).cpX = (System.currentTimeMillis() - l);
          ((av)localObject1).QX();
          return;
        }
      }
      u.i("MicroMsg.WxaWidgetInitializer", "get widget PkgWrappingInfo(id : %s, pkgType : %s, version : %s) return null.", new Object[] { this.BD, Integer.valueOf(this.fAF), Integer.valueOf(((d)localObject1).fXq.sCy) });
      if (this.fUh != null) {
        this.fUh.bk(this.BD, this.val$appId);
      }
      localObject2 = this.BD;
      str = this.val$appId;
      localObject3 = this.fUi;
      i = this.fAF;
      localObject1 = new a.e()
      {
        public final void Y(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          boolean bool2 = false;
          WxaWidgetInitializer.a locala = null;
          y.d("MicroMsg.WxaWidgetInitializer", "tryToUpdate(id : %s, pkgType : %s, version : %s), callback(%s, %s).", new Object[] { WxaWidgetInitializer.1.this.BD, Integer.valueOf(WxaWidgetInitializer.1.this.fAF), Integer.valueOf(this.fUk.fXq.sCy), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
          u.i("MicroMsg.WxaWidgetInitializer", "tryToUpdate(id : %s, pkgType : %s, version : %s), callback(%s, %s).", new Object[] { WxaWidgetInitializer.1.this.BD, Integer.valueOf(WxaWidgetInitializer.1.this.fAF), Integer.valueOf(this.fUk.fXq.sCy), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
          Object localObject = locala;
          boolean bool1 = paramAnonymousBoolean;
          if (paramAnonymousBoolean)
          {
            localObject = a.b(WxaWidgetInitializer.1.this.BD, paramAnonymousString, WxaWidgetInitializer.1.this.fUi, WxaWidgetInitializer.1.this.fAF);
            if (localObject == null) {
              break label250;
            }
            localObject = WxaWidgetInitializer.a(WxaWidgetInitializer.1.this.BD, paramAnonymousString, (WxaPkgWrappingInfo)localObject, this.fUk);
            bool1 = paramAnonymousBoolean;
          }
          for (;;)
          {
            if (WxaWidgetInitializer.1.this.fUh != null)
            {
              locala = WxaWidgetInitializer.1.this.fUh;
              String str = WxaWidgetInitializer.1.this.BD;
              paramAnonymousBoolean = bool2;
              if (bool1)
              {
                paramAnonymousBoolean = bool2;
                if (localObject != null) {
                  paramAnonymousBoolean = true;
                }
              }
              locala.a(str, paramAnonymousString, paramAnonymousBoolean, (WxaWidgetContext)localObject);
            }
            return;
            label250:
            bool1 = false;
            localObject = locala;
          }
        }
      };
    } while ((i == -2147483648) || (a.b((String)localObject2, str, (String)localObject3, i) != null));
    Object localObject3 = new Bundle();
    ((Bundle)localObject3).putString("id", (String)localObject2);
    ((Bundle)localObject3).putString("appId", str);
    ((Bundle)localObject3).putInt("debugType", i);
    f.a("com.tencent.mm", (Parcelable)localObject3, a.d.class, new a.2((a.e)localObject1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer.1
 * JD-Core Version:    0.7.0.1
 */