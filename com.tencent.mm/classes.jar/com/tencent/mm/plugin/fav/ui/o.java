package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.b.q;
import com.tencent.mm.cb.a;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.pluginsdk.ui.tools.i;
import com.tencent.mm.protocal.protobuf.ajv;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.ajy;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akw;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.protocal.protobuf.ary;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.ao;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class o
{
  private static Map<String, f.a> rGC;
  private static f<String, Bitmap> rGD;
  private static f<String, Bitmap> rGE;
  public Context context;
  public HashMap<String, String[]> rGA;
  private HashMap<String, String[]> rGB;
  public h rGz;
  
  static
  {
    AppMethodBeat.i(106992);
    rGC = new HashMap();
    rGD = new com.tencent.mm.memory.a.b(10, o.class);
    rGE = new com.tencent.mm.memory.a.b(20, o.class);
    AppMethodBeat.o(106992);
  }
  
  public o(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(106974);
    this.rGA = new HashMap();
    this.rGB = new HashMap();
    this.context = paramContext;
    int i = paramInt;
    if (paramInt <= 0) {
      i = 24;
    }
    this.rGz = new h(i);
    AppMethodBeat.o(106974);
  }
  
  public static Bitmap a(final ajx paramajx, final com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(106985);
    if (!com.tencent.mm.compatible.util.e.abo())
    {
      paramajx = BitmapFactory.decodeResource(ak.getContext().getResources(), 2131233476);
      AppMethodBeat.o(106985);
      return paramajx;
    }
    if (com.tencent.mm.plugin.fav.a.b.aha(paramajx.dua) == null)
    {
      AppMethodBeat.o(106985);
      return null;
    }
    Bitmap localBitmap = a(paramajx, true, false);
    if (localBitmap == null)
    {
      String str = com.tencent.mm.plugin.fav.a.b.a(paramajx);
      com.tencent.mm.kernel.g.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106968);
          if (o.fv(this.ixp)) {
            com.tencent.mm.plugin.fav.a.b.a(paramg, paramajx);
          }
          AppMethodBeat.o(106968);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(106969);
          String str = super.toString() + "|getThumb";
          AppMethodBeat.o(106969);
          return str;
        }
      });
    }
    AppMethodBeat.o(106985);
    return localBitmap;
  }
  
  public static Bitmap a(final ajx paramajx, final com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(106984);
    if (!com.tencent.mm.compatible.util.e.abo())
    {
      paramajx = BitmapFactory.decodeResource(ak.getContext().getResources(), 2131233476);
      AppMethodBeat.o(106984);
      return paramajx;
    }
    if (paramajx.dua == null)
    {
      AppMethodBeat.o(106984);
      return null;
    }
    Bitmap localBitmap = a(paramajx, false, false);
    if (localBitmap == null)
    {
      final String str = com.tencent.mm.plugin.fav.a.b.d(paramajx);
      com.tencent.mm.kernel.g.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106966);
          if ((this.rGG) || (o.fv(str))) {
            com.tencent.mm.plugin.fav.a.b.a(paramg, paramajx, this.rGG);
          }
          AppMethodBeat.o(106966);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(106967);
          String str = super.toString() + "|getBigImg";
          AppMethodBeat.o(106967);
          return str;
        }
      });
    }
    AppMethodBeat.o(106984);
    return localBitmap;
  }
  
  private static Bitmap a(ajx paramajx, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(106981);
    if (paramBoolean1) {}
    for (paramajx = com.tencent.mm.plugin.fav.a.b.a(paramajx); !com.tencent.mm.vfs.o.fB(paramajx); paramajx = com.tencent.mm.plugin.fav.a.b.d(paramajx))
    {
      ae.w("MicroMsg.FavoriteImageLogic", "getBitmap file not exist");
      AppMethodBeat.o(106981);
      return null;
    }
    paramajx = e.bb(paramajx, paramBoolean2);
    AppMethodBeat.o(106981);
    return paramajx;
  }
  
  public static void a(final ImageView paramImageView, int paramInt1, final ajx paramajx, final com.tencent.mm.plugin.fav.a.g paramg, final boolean paramBoolean, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(191064);
    if (!com.tencent.mm.compatible.util.e.abo()) {
      paramImageView.setImageBitmap(BitmapFactory.decodeResource(ak.getContext().getResources(), 2131233476));
    }
    if (paramajx.dua == null) {
      paramImageView.setImageResource(paramInt1);
    }
    Bitmap localBitmap = a(paramajx, paramg);
    String str = com.tencent.mm.plugin.fav.a.b.d(paramajx);
    if (com.tencent.mm.vfs.o.fB(str)) {
      localBitmap = c(str, paramInt2, paramInt3, true);
    }
    if (localBitmap == null)
    {
      paramImageView.setImageResource(paramInt1);
      paramImageView.setTag(str);
      com.tencent.mm.kernel.g.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106971);
          final Bitmap localBitmap = o.c(this.val$path, paramInt2, paramInt3, false);
          if (localBitmap == null)
          {
            o.c(paramg, paramajx, paramBoolean);
            AppMethodBeat.o(106971);
            return;
          }
          String str = (String)paramImageView.getTag();
          if ((str != null) && (str.equals(this.val$path)))
          {
            com.tencent.mm.kernel.g.ajU();
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(106970);
                o.6.this.qlp.setImageBitmap(localBitmap);
                AppMethodBeat.o(106970);
              }
            });
          }
          AppMethodBeat.o(106971);
        }
      });
      AppMethodBeat.o(191064);
      return;
    }
    paramImageView.setImageBitmap(localBitmap);
    AppMethodBeat.o(191064);
  }
  
  public static Bitmap b(final ajx paramajx, final com.tencent.mm.plugin.fav.a.g paramg, int paramInt)
  {
    AppMethodBeat.i(106982);
    if (!com.tencent.mm.compatible.util.e.abo())
    {
      paramajx = BitmapFactory.decodeResource(ak.getContext().getResources(), 2131233476);
      AppMethodBeat.o(106982);
      return paramajx;
    }
    if (paramajx.dua == null)
    {
      AppMethodBeat.o(106982);
      return null;
    }
    String str = com.tencent.mm.plugin.fav.a.b.d(paramajx);
    if (!com.tencent.mm.vfs.o.fB(str))
    {
      ae.w("MicroMsg.FavoriteImageLogic", "getBitmap file not exist");
      localObject = null;
    }
    for (;;)
    {
      if (localObject == null)
      {
        str = com.tencent.mm.plugin.fav.a.b.d(paramajx);
        com.tencent.mm.kernel.g.ajU().aw(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(106964);
            if ((this.rGG) || (o.fv(this.ixp))) {
              com.tencent.mm.plugin.fav.a.b.a(paramg, paramajx, this.rGG);
            }
            AppMethodBeat.o(106964);
          }
          
          public final String toString()
          {
            AppMethodBeat.i(106965);
            String str = super.toString() + "|getBigImg";
            AppMethodBeat.o(106965);
            return str;
          }
        });
      }
      AppMethodBeat.o(106982);
      return localObject;
      localObject = (Bitmap)rGD.get(str);
      if (localObject == null) {
        break;
      }
      ae.d("MicroMsg.FavoriteImageLogic", "get bm from cache %s", new Object[] { str });
    }
    ae.d("MicroMsg.FavoriteImageLogic", "get from cache fail, try to decode from file");
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    Bitmap localBitmap = MMBitmapFactory.decodeFile(str, (BitmapFactory.Options)localObject);
    if (localBitmap != null)
    {
      ae.i("MicroMsg.FavoriteImageLogic", "bitmap recycle %s", new Object[] { localBitmap });
      localBitmap.recycle();
    }
    int j = ((BitmapFactory.Options)localObject).outWidth;
    int i = ((BitmapFactory.Options)localObject).outHeight;
    ae.d("MicroMsg.FavoriteImageLogic", "width: %s, height: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
    if (j > paramInt) {
      i = ((BitmapFactory.Options)localObject).outHeight * paramInt / ((BitmapFactory.Options)localObject).outWidth;
    }
    for (;;)
    {
      paramInt = Math.max(1, paramInt);
      i = Math.max(1, i);
      ae.w("MicroMsg.FavoriteImageLogic", "fit long picture, beg %d*%d, after %d*%d", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject).outHeight), Integer.valueOf(paramInt), Integer.valueOf(i) });
      int k = BackwardSupportUtil.ExifHelper.df(str);
      if ((k == 90) || (k == 270)) {}
      for (;;)
      {
        localObject = com.tencent.mm.sdk.platformtools.h.d(str, paramInt, i, false);
        if (localObject == null)
        {
          ae.e("MicroMsg.FavoriteImageLogic", "getSuitableBmp fail, temBmp is null, filePath = ".concat(String.valueOf(str)));
          localObject = null;
          break;
        }
        localObject = com.tencent.mm.sdk.platformtools.h.a((Bitmap)localObject, k);
        rGD.put(str, localObject);
        break;
        j = paramInt;
        paramInt = i;
        i = j;
      }
      paramInt = j;
    }
  }
  
  public static void b(com.tencent.mm.plugin.fav.a.g paramg, ajx paramajx)
  {
    AppMethodBeat.i(106989);
    b(paramg, paramajx, true);
    AppMethodBeat.o(106989);
  }
  
  private static void b(final com.tencent.mm.plugin.fav.a.g paramg, final ajx paramajx, boolean paramBoolean)
  {
    AppMethodBeat.i(106988);
    final String str = com.tencent.mm.plugin.fav.a.b.d(paramajx);
    com.tencent.mm.kernel.g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106972);
        if ((this.rGG) || (o.fv(str))) {
          com.tencent.mm.plugin.fav.a.b.a(paramg, paramajx, this.rGG);
        }
        AppMethodBeat.o(106972);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(106973);
        String str = super.toString() + "|reDownload";
        AppMethodBeat.o(106973);
        return str;
      }
    });
    AppMethodBeat.o(106988);
  }
  
  public static Bitmap c(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(106986);
    boolean bool = false;
    if (!com.tencent.mm.vfs.o.fB(paramString))
    {
      ae.w("MicroMsg.FavoriteImageLogic", "file not exist");
      AppMethodBeat.o(106986);
      return null;
    }
    Bitmap localBitmap = (Bitmap)rGE.get(paramString);
    if ((localBitmap != null) || (paramBoolean))
    {
      if (localBitmap != null) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        ae.d("MicroMsg.FavoriteImageLogic", "return bm path %s, bm %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(106986);
        return localBitmap;
      }
    }
    Object localObject = localBitmap;
    for (;;)
    {
      BitmapFactory.Options localOptions;
      int m;
      try
      {
        localOptions = new BitmapFactory.Options();
        localObject = localBitmap;
        localOptions.inJustDecodeBounds = true;
        localObject = localBitmap;
        com.tencent.mm.sdk.platformtools.h.decodeFile(paramString, localOptions);
        localObject = localBitmap;
        i = localOptions.outWidth;
        localObject = localBitmap;
        j = localOptions.outHeight;
        localObject = localBitmap;
        m = BackwardSupportUtil.ExifHelper.df(paramString);
        if (m == 90) {
          break label625;
        }
        if (m != 270) {
          break label607;
        }
      }
      catch (IOException paramString)
      {
        ae.e("MicroMsg.FavoriteImageLogic", paramString.getMessage());
        paramString = (String)localObject;
        AppMethodBeat.o(106986);
        return paramString;
      }
      localObject = localBitmap;
      localOptions.inSampleSize = 1;
      localObject = localBitmap;
      if (i / localOptions.inSampleSize > paramInt2)
      {
        localObject = localBitmap;
        if (j / localOptions.inSampleSize > paramInt1)
        {
          localObject = localBitmap;
          localOptions.inSampleSize += 1;
          continue;
        }
      }
      localObject = localBitmap;
      int k = j * paramInt2 / paramInt1;
      localObject = localBitmap;
      ae.d("MicroMsg.FavoriteImageLogic", "decode top region width: %d, height: %d, scaleheight: %d, rotate: %b", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k), Boolean.valueOf(paramBoolean) });
      Rect localRect;
      label395:
      String str;
      if ((k > 0) && (i > k))
      {
        localObject = localBitmap;
        localRect = new Rect();
        localObject = localBitmap;
        localRect.top = 0;
        localObject = localBitmap;
        localRect.left = 0;
        if (paramBoolean)
        {
          localObject = localBitmap;
          localRect.right = k;
          localObject = localBitmap;
          localRect.bottom = j;
          localObject = localBitmap;
          str = q.k(paramString, false);
          localObject = localBitmap;
          paramString = BitmapRegionDecoder.newInstance(str, true);
          localObject = localBitmap;
          localOptions.inJustDecodeBounds = false;
          localObject = localBitmap;
          localBitmap = paramString.decodeRegion(localRect, localOptions);
        }
      }
      for (;;)
      {
        paramString = localBitmap;
        if (localBitmap != null)
        {
          paramString = localBitmap;
          if (paramBoolean)
          {
            localObject = localBitmap;
            paramString = com.tencent.mm.sdk.platformtools.h.a(localBitmap, m);
          }
        }
        if (paramString == null) {
          break label593;
        }
        localObject = paramString;
        ae.d("MicroMsg.FavoriteImageLogic", "width %d, height %d, tw %d, th %d", new Object[] { Integer.valueOf(paramString.getWidth()), Integer.valueOf(paramString.getHeight()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        localObject = paramString;
        rGE.put(str, paramString);
        break;
        localObject = localBitmap;
        localRect.right = j;
        localObject = localBitmap;
        localRect.bottom = k;
        break label395;
        localObject = localBitmap;
        localOptions.inJustDecodeBounds = false;
        localObject = localBitmap;
        localBitmap = com.tencent.mm.sdk.platformtools.h.decodeFile(paramString, localOptions);
        str = paramString;
      }
      label593:
      localObject = paramString;
      ae.w("MicroMsg.FavoriteImageLogic", "decode bm fail!");
      continue;
      label607:
      k = i;
      int i = j;
      int j = k;
      paramBoolean = bool;
      continue;
      label625:
      paramBoolean = true;
    }
  }
  
  private static boolean c(akf paramakf)
  {
    AppMethodBeat.i(106978);
    if ((paramakf != null) && (paramakf.hBV == 5) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bOe()))
    {
      AppMethodBeat.o(106978);
      return true;
    }
    AppMethodBeat.o(106978);
    return false;
  }
  
  private void cxY()
  {
    AppMethodBeat.i(106975);
    h localh = this.rGz;
    synchronized (localh.lock)
    {
      ae.d("MicroMsg.ImageEngine", "do clear mark");
      localh.FCv.clear();
      localh.FCw.clear();
      localh.FCv = new HashMap();
      localh.FCw = new HashMap();
      AppMethodBeat.o(106975);
      return;
    }
  }
  
  public static Bitmap l(ajx paramajx)
  {
    AppMethodBeat.i(106983);
    if (!com.tencent.mm.compatible.util.e.abo())
    {
      paramajx = BitmapFactory.decodeResource(ak.getContext().getResources(), 2131233476);
      AppMethodBeat.o(106983);
      return paramajx;
    }
    if (paramajx.dua == null)
    {
      AppMethodBeat.o(106983);
      return null;
    }
    paramajx = a(paramajx, false, true);
    AppMethodBeat.o(106983);
    return paramajx;
  }
  
  public final void a(ImageView paramImageView, ajx paramajx, com.tencent.mm.plugin.fav.a.g paramg, int paramInt1, int paramInt2, int paramInt3)
  {
    String str = null;
    AppMethodBeat.i(106979);
    if (paramImageView == null)
    {
      AppMethodBeat.o(106979);
      return;
    }
    if (!com.tencent.mm.compatible.util.e.abo())
    {
      paramImageView.setImageResource(2131233476);
      AppMethodBeat.o(106979);
      return;
    }
    if (paramg == null)
    {
      AppMethodBeat.o(106979);
      return;
    }
    boolean bool;
    Object localObject;
    switch (paramg.field_type)
    {
    case 6: 
    case 8: 
    case 9: 
    case 12: 
    case 13: 
    case 14: 
    default: 
      ae.w("MicroMsg.FavoriteImageLogic", "attach thumb, pass type is %d", new Object[] { Integer.valueOf(paramg.field_type) });
      AppMethodBeat.o(106979);
      return;
    case 7: 
      if (paramajx != null)
      {
        a(paramImageView, paramajx, paramg, paramajx.dox, paramInt1, paramInt2, paramInt3);
        AppMethodBeat.o(106979);
        return;
      }
      break;
    case 4: 
    case 16: 
      if (paramajx != null)
      {
        a(paramImageView, paramajx, paramg, paramajx.dox, paramInt1, paramInt2, paramInt3);
        AppMethodBeat.o(106979);
        return;
      }
      break;
    case 5: 
      bool = c(paramg.field_favProto.Ekw);
      ae.v("MicroMsg.FavoriteImageLogic", "alvinluo attachThumb isBizNativeVideo: %b", new Object[] { Boolean.valueOf(bool) });
      localObject = paramg.field_favProto.GBf;
      if (paramajx == null)
      {
        if (localObject != null)
        {
          paramg = this.rGz;
          if (!bool) {
            break label295;
          }
        }
        label295:
        for (paramajx = com.tencent.mm.api.b.t(((alc)localObject).thumbUrl, 4);; paramajx = ((alc)localObject).thumbUrl)
        {
          paramg.a(paramImageView, null, paramajx, paramInt1, paramInt2, paramInt3);
          AppMethodBeat.o(106979);
          return;
        }
      }
      if (localObject == null)
      {
        if (!bu.isNullOrNil(str)) {
          break label493;
        }
        str = paramajx.dox;
      }
      break;
    }
    label493:
    for (;;)
    {
      localObject = str;
      if (bool) {
        localObject = com.tencent.mm.api.b.t(str, 4);
      }
      a(paramImageView, paramajx, paramg, (String)localObject, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(106979);
      return;
      str = ((alc)localObject).thumbUrl;
      break;
      paramajx = paramg.field_favProto.GBh;
      if (paramajx != null)
      {
        this.rGz.a(paramImageView, null, paramajx.thumbUrl, paramInt1, paramInt2, paramInt3);
        AppMethodBeat.o(106979);
        return;
        paramajx = paramg.field_favProto.GBj;
        if (paramajx != null)
        {
          this.rGz.a(paramImageView, null, paramajx.thumbUrl, paramInt1, paramInt2, paramInt3);
          AppMethodBeat.o(106979);
          return;
          paramajx = paramg.field_favProto.GBh;
          if (paramajx != null)
          {
            this.rGz.a(paramImageView, null, paramajx.thumbUrl, paramInt1, paramInt2, paramInt3);
            AppMethodBeat.o(106979);
            return;
          }
        }
      }
      AppMethodBeat.o(106979);
      return;
    }
  }
  
  public final void a(final ImageView paramImageView, final ajx paramajx, final com.tencent.mm.plugin.fav.a.g paramg, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(106977);
    String str = com.tencent.mm.plugin.fav.a.b.aha(paramajx.dua);
    String[] arrayOfString = null;
    if (paramajx.dua != null)
    {
      arrayOfString = (String[])this.rGB.get(str);
      if (arrayOfString != null) {
        break label136;
      }
      arrayOfString = new String[1];
      arrayOfString[0] = com.tencent.mm.plugin.fav.a.b.a(paramajx);
      this.rGB.put(str, arrayOfString);
    }
    label136:
    for (;;)
    {
      this.rGz.a(paramImageView, arrayOfString, paramString, paramInt1, paramInt2, paramInt3);
      if ((arrayOfString == null) || (arrayOfString.length <= 0))
      {
        AppMethodBeat.o(106977);
        return;
      }
      paramImageView = arrayOfString[0];
      com.tencent.mm.kernel.g.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106960);
          if (o.fv(paramImageView)) {
            com.tencent.mm.plugin.fav.a.b.a(paramg, paramajx);
          }
          AppMethodBeat.o(106960);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(106961);
          String str = super.toString() + "|mAttachThumb";
          AppMethodBeat.o(106961);
          return str;
        }
      });
      AppMethodBeat.o(106977);
      return;
    }
  }
  
  public final void b(ImageView paramImageView, ajx paramajx, com.tencent.mm.plugin.fav.a.g paramg, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(106980);
    if (paramImageView == null)
    {
      AppMethodBeat.o(106980);
      return;
    }
    if (!com.tencent.mm.compatible.util.e.abo())
    {
      paramImageView.setImageResource(2131233476);
      AppMethodBeat.o(106980);
      return;
    }
    if ((paramg == null) || (paramajx == null))
    {
      paramImageView.setImageDrawable(a.l(this.context, paramInt1));
      AppMethodBeat.o(106980);
      return;
    }
    Object localObject1;
    boolean bool;
    switch (paramajx.dataType)
    {
    case 6: 
    case 8: 
    case 9: 
    case 12: 
    case 13: 
    case 16: 
    case 17: 
    case 18: 
    case 20: 
    case 21: 
    default: 
      ae.w("MicroMsg.FavoriteImageLogic", "attach thumb, pass type is %d", new Object[] { Integer.valueOf(paramg.field_type) });
      AppMethodBeat.o(106980);
      return;
    case 7: 
      a(paramImageView, paramajx, paramg, paramajx.dox, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(106980);
      return;
    case 4: 
    case 15: 
      a(paramImageView, paramajx, paramg, paramajx.dox, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(106980);
      return;
    case 5: 
      localObject1 = null;
      if (paramajx.GAu != null)
      {
        localObject1 = paramajx.GAu.GBf;
        bool = c(paramajx.GAu.Ekw);
        if (localObject1 != null) {
          break label374;
        }
        localObject1 = null;
        label276:
        if (!bu.isNullOrNil((String)localObject1)) {
          break label888;
        }
        localObject1 = paramajx.dox;
      }
      break;
    }
    label374:
    label888:
    for (;;)
    {
      Object localObject2 = localObject1;
      if (bool) {
        localObject2 = com.tencent.mm.api.b.t((String)localObject1, 4);
      }
      a(paramImageView, paramajx, paramg, (String)localObject2, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(106980);
      return;
      ae.w("MicroMsg.FavoriteImageLogic", "webpage: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[] { paramajx.dua, Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
      bool = false;
      break;
      localObject1 = ((alc)localObject1).thumbUrl;
      break label276;
      if ((paramajx.GAu != null) && (paramajx.GAu.GBx != null) && (!bu.ht(paramajx.GAu.GBx.mediaList)) && (!bu.isNullOrNil(((arx)paramajx.GAu.GBx.mediaList.getFirst()).thumbUrl)))
      {
        this.rGz.a(paramImageView, null, ((arx)paramajx.GAu.GBx.mediaList.getFirst()).thumbUrl, paramInt1, paramInt2, paramInt3);
        AppMethodBeat.o(106980);
        return;
      }
      paramImageView.setImageDrawable(ao.k(paramImageView.getContext(), 2131690572, paramImageView.getContext().getResources().getColor(2131099777)));
      AppMethodBeat.o(106980);
      return;
      if (paramajx.GAu == null)
      {
        ae.w("MicroMsg.FavoriteImageLogic", "good: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[] { paramajx.dua, Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
        AppMethodBeat.o(106980);
        return;
      }
      paramajx = paramajx.GAu.GBh;
      if (paramajx != null)
      {
        this.rGz.a(paramImageView, null, paramajx.thumbUrl, paramInt1, paramInt2, paramInt3);
        AppMethodBeat.o(106980);
        return;
        if (paramajx.GAu == null)
        {
          ae.w("MicroMsg.FavoriteImageLogic", "tv: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[] { paramajx.dua, Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
          AppMethodBeat.o(106980);
          return;
        }
        paramajx = paramajx.GAu.GBj;
        if (paramajx != null)
        {
          this.rGz.a(paramImageView, null, paramajx.thumbUrl, paramInt1, paramInt2, paramInt3);
          AppMethodBeat.o(106980);
          return;
          if (paramajx.GAu == null)
          {
            ae.w("MicroMsg.FavoriteImageLogic", "product: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[] { paramajx.dua, Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
            AppMethodBeat.o(106980);
            return;
          }
          paramajx = paramajx.GAu.GBh;
          if (paramajx != null)
          {
            this.rGz.a(paramImageView, null, paramajx.thumbUrl, paramInt1, paramInt2, paramInt3);
            AppMethodBeat.o(106980);
            return;
            if (paramajx.GAu == null)
            {
              ae.w("MicroMsg.FavoriteImageLogic", "app brand: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[] { paramajx.dua, Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
              AppMethodBeat.o(106980);
              return;
            }
            paramajx = paramajx.GAu.GBs;
            if (paramajx != null)
            {
              this.rGz.a(paramImageView, null, paramajx.iconUrl, paramInt1, paramInt2, paramInt3);
              AppMethodBeat.o(106980);
              return;
            }
          }
        }
      }
      AppMethodBeat.o(106980);
      return;
    }
  }
  
  public final void destory()
  {
    AppMethodBeat.i(106976);
    cxY();
    this.rGA.clear();
    this.rGB.clear();
    this.rGz.destroy();
    this.context = null;
    this.rGA = null;
    this.rGB = null;
    this.rGz = null;
    AppMethodBeat.o(106976);
  }
  
  public final Context getContext()
  {
    return this.context;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.o
 * JD-Core Version:    0.7.0.1
 */