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
import com.tencent.mm.cc.a;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.protocal.protobuf.ajl;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajo;
import com.tencent.mm.protocal.protobuf.ajv;
import com.tencent.mm.protocal.protobuf.akc;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.protocal.protobuf.aks;
import com.tencent.mm.protocal.protobuf.ari;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ao;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class o
{
  private static Map<String, f.a> ryr;
  private static f<String, Bitmap> rys;
  private static f<String, Bitmap> ryt;
  public Context context;
  public h ryo;
  public HashMap<String, String[]> ryp;
  private HashMap<String, String[]> ryq;
  
  static
  {
    AppMethodBeat.i(106992);
    ryr = new HashMap();
    rys = new com.tencent.mm.memory.a.b(10, o.class);
    ryt = new com.tencent.mm.memory.a.b(20, o.class);
    AppMethodBeat.o(106992);
  }
  
  public o(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(106974);
    this.ryp = new HashMap();
    this.ryq = new HashMap();
    this.context = paramContext;
    int i = paramInt;
    if (paramInt <= 0) {
      i = 24;
    }
    this.ryo = new h(i);
    AppMethodBeat.o(106974);
  }
  
  public static Bitmap a(final ajn paramajn, final com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(106985);
    if (!com.tencent.mm.compatible.util.e.abf())
    {
      paramajn = BitmapFactory.decodeResource(aj.getContext().getResources(), 2131233476);
      AppMethodBeat.o(106985);
      return paramajn;
    }
    if (com.tencent.mm.plugin.fav.a.b.agd(paramajn.dsU) == null)
    {
      AppMethodBeat.o(106985);
      return null;
    }
    Bitmap localBitmap = a(paramajn, true, false);
    if (localBitmap == null)
    {
      String str = com.tencent.mm.plugin.fav.a.b.a(paramajn);
      com.tencent.mm.kernel.g.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106968);
          if (o.fp(this.iuv)) {
            com.tencent.mm.plugin.fav.a.b.a(paramg, paramajn);
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
  
  public static Bitmap a(final ajn paramajn, final com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(106984);
    if (!com.tencent.mm.compatible.util.e.abf())
    {
      paramajn = BitmapFactory.decodeResource(aj.getContext().getResources(), 2131233476);
      AppMethodBeat.o(106984);
      return paramajn;
    }
    if (paramajn.dsU == null)
    {
      AppMethodBeat.o(106984);
      return null;
    }
    Bitmap localBitmap = a(paramajn, false, false);
    if (localBitmap == null)
    {
      final String str = com.tencent.mm.plugin.fav.a.b.d(paramajn);
      com.tencent.mm.kernel.g.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106966);
          if ((this.ryv) || (o.fp(str))) {
            com.tencent.mm.plugin.fav.a.b.a(paramg, paramajn, this.ryv);
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
  
  private static Bitmap a(ajn paramajn, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(106981);
    if (paramBoolean1) {}
    for (paramajn = com.tencent.mm.plugin.fav.a.b.a(paramajn); !com.tencent.mm.vfs.i.fv(paramajn); paramajn = com.tencent.mm.plugin.fav.a.b.d(paramajn))
    {
      ad.w("MicroMsg.FavoriteImageLogic", "getBitmap file not exist");
      AppMethodBeat.o(106981);
      return null;
    }
    paramajn = e.aZ(paramajn, paramBoolean2);
    AppMethodBeat.o(106981);
    return paramajn;
  }
  
  public static void a(final ImageView paramImageView, int paramInt1, final ajn paramajn, final com.tencent.mm.plugin.fav.a.g paramg, final boolean paramBoolean, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(218789);
    if (!com.tencent.mm.compatible.util.e.abf()) {
      paramImageView.setImageBitmap(BitmapFactory.decodeResource(aj.getContext().getResources(), 2131233476));
    }
    if (paramajn.dsU == null) {
      paramImageView.setImageResource(paramInt1);
    }
    Bitmap localBitmap = a(paramajn, paramg);
    String str = com.tencent.mm.plugin.fav.a.b.d(paramajn);
    if (com.tencent.mm.vfs.i.fv(str)) {
      localBitmap = c(str, paramInt2, paramInt3, true);
    }
    if (localBitmap == null)
    {
      paramImageView.setImageResource(paramInt1);
      paramImageView.setTag(str);
      com.tencent.mm.kernel.g.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106971);
          final Bitmap localBitmap = o.c(this.val$path, paramInt2, paramInt3, false);
          if (localBitmap == null)
          {
            o.c(paramg, paramajn, paramBoolean);
            AppMethodBeat.o(106971);
            return;
          }
          String str = (String)paramImageView.getTag();
          if ((str != null) && (str.equals(this.val$path)))
          {
            com.tencent.mm.kernel.g.ajF();
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(106970);
                o.6.this.qeK.setImageBitmap(localBitmap);
                AppMethodBeat.o(106970);
              }
            });
          }
          AppMethodBeat.o(106971);
        }
      });
      AppMethodBeat.o(218789);
      return;
    }
    paramImageView.setImageBitmap(localBitmap);
    AppMethodBeat.o(218789);
  }
  
  public static Bitmap b(final ajn paramajn, final com.tencent.mm.plugin.fav.a.g paramg, int paramInt)
  {
    AppMethodBeat.i(106982);
    if (!com.tencent.mm.compatible.util.e.abf())
    {
      paramajn = BitmapFactory.decodeResource(aj.getContext().getResources(), 2131233476);
      AppMethodBeat.o(106982);
      return paramajn;
    }
    if (paramajn.dsU == null)
    {
      AppMethodBeat.o(106982);
      return null;
    }
    String str = com.tencent.mm.plugin.fav.a.b.d(paramajn);
    if (!com.tencent.mm.vfs.i.fv(str))
    {
      ad.w("MicroMsg.FavoriteImageLogic", "getBitmap file not exist");
      localObject = null;
    }
    for (;;)
    {
      if (localObject == null)
      {
        str = com.tencent.mm.plugin.fav.a.b.d(paramajn);
        com.tencent.mm.kernel.g.ajF().ay(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(106964);
            if ((this.ryv) || (o.fp(this.iuv))) {
              com.tencent.mm.plugin.fav.a.b.a(paramg, paramajn, this.ryv);
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
      localObject = (Bitmap)rys.get(str);
      if (localObject == null) {
        break;
      }
      ad.d("MicroMsg.FavoriteImageLogic", "get bm from cache %s", new Object[] { str });
    }
    ad.d("MicroMsg.FavoriteImageLogic", "get from cache fail, try to decode from file");
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    Bitmap localBitmap = MMBitmapFactory.decodeFile(str, (BitmapFactory.Options)localObject);
    if (localBitmap != null)
    {
      ad.i("MicroMsg.FavoriteImageLogic", "bitmap recycle %s", new Object[] { localBitmap });
      localBitmap.recycle();
    }
    int j = ((BitmapFactory.Options)localObject).outWidth;
    int i = ((BitmapFactory.Options)localObject).outHeight;
    ad.d("MicroMsg.FavoriteImageLogic", "width: %s, height: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
    if (j > paramInt) {
      i = ((BitmapFactory.Options)localObject).outHeight * paramInt / ((BitmapFactory.Options)localObject).outWidth;
    }
    for (;;)
    {
      paramInt = Math.max(1, paramInt);
      i = Math.max(1, i);
      ad.w("MicroMsg.FavoriteImageLogic", "fit long picture, beg %d*%d, after %d*%d", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject).outHeight), Integer.valueOf(paramInt), Integer.valueOf(i) });
      int k = BackwardSupportUtil.ExifHelper.cY(str);
      if ((k == 90) || (k == 270)) {}
      for (;;)
      {
        localObject = com.tencent.mm.sdk.platformtools.g.d(str, paramInt, i, false);
        if (localObject == null)
        {
          ad.e("MicroMsg.FavoriteImageLogic", "getSuitableBmp fail, temBmp is null, filePath = ".concat(String.valueOf(str)));
          localObject = null;
          break;
        }
        localObject = com.tencent.mm.sdk.platformtools.g.a((Bitmap)localObject, k);
        rys.put(str, localObject);
        break;
        j = paramInt;
        paramInt = i;
        i = j;
      }
      paramInt = j;
    }
  }
  
  public static void b(com.tencent.mm.plugin.fav.a.g paramg, ajn paramajn)
  {
    AppMethodBeat.i(106989);
    b(paramg, paramajn, true);
    AppMethodBeat.o(106989);
  }
  
  private static void b(final com.tencent.mm.plugin.fav.a.g paramg, final ajn paramajn, boolean paramBoolean)
  {
    AppMethodBeat.i(106988);
    final String str = com.tencent.mm.plugin.fav.a.b.d(paramajn);
    com.tencent.mm.kernel.g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106972);
        if ((this.ryv) || (o.fp(str))) {
          com.tencent.mm.plugin.fav.a.b.a(paramg, paramajn, this.ryv);
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
    if (!com.tencent.mm.vfs.i.fv(paramString))
    {
      ad.w("MicroMsg.FavoriteImageLogic", "file not exist");
      AppMethodBeat.o(106986);
      return null;
    }
    Bitmap localBitmap = (Bitmap)ryt.get(paramString);
    if ((localBitmap != null) || (paramBoolean))
    {
      if (localBitmap != null) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        ad.d("MicroMsg.FavoriteImageLogic", "return bm path %s, bm %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
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
        com.tencent.mm.sdk.platformtools.g.decodeFile(paramString, localOptions);
        localObject = localBitmap;
        i = localOptions.outWidth;
        localObject = localBitmap;
        j = localOptions.outHeight;
        localObject = localBitmap;
        m = BackwardSupportUtil.ExifHelper.cY(paramString);
        if (m == 90) {
          break label625;
        }
        if (m != 270) {
          break label607;
        }
      }
      catch (IOException paramString)
      {
        ad.e("MicroMsg.FavoriteImageLogic", paramString.getMessage());
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
      ad.d("MicroMsg.FavoriteImageLogic", "decode top region width: %d, height: %d, scaleheight: %d, rotate: %b", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k), Boolean.valueOf(paramBoolean) });
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
            paramString = com.tencent.mm.sdk.platformtools.g.a(localBitmap, m);
          }
        }
        if (paramString == null) {
          break label593;
        }
        localObject = paramString;
        ad.d("MicroMsg.FavoriteImageLogic", "width %d, height %d, tw %d, th %d", new Object[] { Integer.valueOf(paramString.getWidth()), Integer.valueOf(paramString.getHeight()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        localObject = paramString;
        ryt.put(str, paramString);
        break;
        localObject = localBitmap;
        localRect.right = j;
        localObject = localBitmap;
        localRect.bottom = k;
        break label395;
        localObject = localBitmap;
        localOptions.inJustDecodeBounds = false;
        localObject = localBitmap;
        localBitmap = com.tencent.mm.sdk.platformtools.g.decodeFile(paramString, localOptions);
        str = paramString;
      }
      label593:
      localObject = paramString;
      ad.w("MicroMsg.FavoriteImageLogic", "decode bm fail!");
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
  
  private static boolean c(ajv paramajv)
  {
    AppMethodBeat.i(106978);
    if ((paramajv != null) && (paramajv.hzh == 5) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bNg()))
    {
      AppMethodBeat.o(106978);
      return true;
    }
    AppMethodBeat.o(106978);
    return false;
  }
  
  private void cwx()
  {
    AppMethodBeat.i(106975);
    h localh = this.ryo;
    synchronized (localh.lock)
    {
      ad.d("MicroMsg.ImageEngine", "do clear mark");
      localh.FjX.clear();
      localh.FjY.clear();
      localh.FjX = new HashMap();
      localh.FjY = new HashMap();
      AppMethodBeat.o(106975);
      return;
    }
  }
  
  public static Bitmap l(ajn paramajn)
  {
    AppMethodBeat.i(106983);
    if (!com.tencent.mm.compatible.util.e.abf())
    {
      paramajn = BitmapFactory.decodeResource(aj.getContext().getResources(), 2131233476);
      AppMethodBeat.o(106983);
      return paramajn;
    }
    if (paramajn.dsU == null)
    {
      AppMethodBeat.o(106983);
      return null;
    }
    paramajn = a(paramajn, false, true);
    AppMethodBeat.o(106983);
    return paramajn;
  }
  
  public final void a(ImageView paramImageView, ajn paramajn, com.tencent.mm.plugin.fav.a.g paramg, int paramInt1, int paramInt2, int paramInt3)
  {
    String str = null;
    AppMethodBeat.i(106979);
    if (paramImageView == null)
    {
      AppMethodBeat.o(106979);
      return;
    }
    if (!com.tencent.mm.compatible.util.e.abf())
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
      ad.w("MicroMsg.FavoriteImageLogic", "attach thumb, pass type is %d", new Object[] { Integer.valueOf(paramg.field_type) });
      AppMethodBeat.o(106979);
      return;
    case 7: 
      if (paramajn != null)
      {
        a(paramImageView, paramajn, paramg, paramajn.dnv, paramInt1, paramInt2, paramInt3);
        AppMethodBeat.o(106979);
        return;
      }
      break;
    case 4: 
    case 16: 
      if (paramajn != null)
      {
        a(paramImageView, paramajn, paramg, paramajn.dnv, paramInt1, paramInt2, paramInt3);
        AppMethodBeat.o(106979);
        return;
      }
      break;
    case 5: 
      bool = c(paramg.field_favProto.DSw);
      ad.v("MicroMsg.FavoriteImageLogic", "alvinluo attachThumb isBizNativeVideo: %b", new Object[] { Boolean.valueOf(bool) });
      localObject = paramg.field_favProto.Giw;
      if (paramajn == null)
      {
        if (localObject != null)
        {
          paramg = this.ryo;
          if (!bool) {
            break label295;
          }
        }
        label295:
        for (paramajn = com.tencent.mm.api.b.s(((aks)localObject).thumbUrl, 4);; paramajn = ((aks)localObject).thumbUrl)
        {
          paramg.a(paramImageView, null, paramajn, paramInt1, paramInt2, paramInt3);
          AppMethodBeat.o(106979);
          return;
        }
      }
      if (localObject == null)
      {
        if (!bt.isNullOrNil(str)) {
          break label493;
        }
        str = paramajn.dnv;
      }
      break;
    }
    label493:
    for (;;)
    {
      localObject = str;
      if (bool) {
        localObject = com.tencent.mm.api.b.s(str, 4);
      }
      a(paramImageView, paramajn, paramg, (String)localObject, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(106979);
      return;
      str = ((aks)localObject).thumbUrl;
      break;
      paramajn = paramg.field_favProto.Giy;
      if (paramajn != null)
      {
        this.ryo.a(paramImageView, null, paramajn.thumbUrl, paramInt1, paramInt2, paramInt3);
        AppMethodBeat.o(106979);
        return;
        paramajn = paramg.field_favProto.GiA;
        if (paramajn != null)
        {
          this.ryo.a(paramImageView, null, paramajn.thumbUrl, paramInt1, paramInt2, paramInt3);
          AppMethodBeat.o(106979);
          return;
          paramajn = paramg.field_favProto.Giy;
          if (paramajn != null)
          {
            this.ryo.a(paramImageView, null, paramajn.thumbUrl, paramInt1, paramInt2, paramInt3);
            AppMethodBeat.o(106979);
            return;
          }
        }
      }
      AppMethodBeat.o(106979);
      return;
    }
  }
  
  public final void a(final ImageView paramImageView, final ajn paramajn, final com.tencent.mm.plugin.fav.a.g paramg, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(106977);
    String str = com.tencent.mm.plugin.fav.a.b.agd(paramajn.dsU);
    String[] arrayOfString = null;
    if (paramajn.dsU != null)
    {
      arrayOfString = (String[])this.ryq.get(str);
      if (arrayOfString != null) {
        break label136;
      }
      arrayOfString = new String[1];
      arrayOfString[0] = com.tencent.mm.plugin.fav.a.b.a(paramajn);
      this.ryq.put(str, arrayOfString);
    }
    label136:
    for (;;)
    {
      this.ryo.a(paramImageView, arrayOfString, paramString, paramInt1, paramInt2, paramInt3);
      if ((arrayOfString == null) || (arrayOfString.length <= 0))
      {
        AppMethodBeat.o(106977);
        return;
      }
      paramImageView = arrayOfString[0];
      com.tencent.mm.kernel.g.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106960);
          if (o.fp(paramImageView)) {
            com.tencent.mm.plugin.fav.a.b.a(paramg, paramajn);
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
  
  public final void b(ImageView paramImageView, ajn paramajn, com.tencent.mm.plugin.fav.a.g paramg, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(106980);
    if (paramImageView == null)
    {
      AppMethodBeat.o(106980);
      return;
    }
    if (!com.tencent.mm.compatible.util.e.abf())
    {
      paramImageView.setImageResource(2131233476);
      AppMethodBeat.o(106980);
      return;
    }
    if ((paramg == null) || (paramajn == null))
    {
      paramImageView.setImageDrawable(a.l(this.context, paramInt1));
      AppMethodBeat.o(106980);
      return;
    }
    Object localObject1;
    boolean bool;
    switch (paramajn.dataType)
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
      ad.w("MicroMsg.FavoriteImageLogic", "attach thumb, pass type is %d", new Object[] { Integer.valueOf(paramg.field_type) });
      AppMethodBeat.o(106980);
      return;
    case 7: 
      a(paramImageView, paramajn, paramg, paramajn.dnv, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(106980);
      return;
    case 4: 
    case 15: 
      a(paramImageView, paramajn, paramg, paramajn.dnv, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(106980);
      return;
    case 5: 
      localObject1 = null;
      if (paramajn.GhL != null)
      {
        localObject1 = paramajn.GhL.Giw;
        bool = c(paramajn.GhL.DSw);
        if (localObject1 != null) {
          break label374;
        }
        localObject1 = null;
        label276:
        if (!bt.isNullOrNil((String)localObject1)) {
          break label888;
        }
        localObject1 = paramajn.dnv;
      }
      break;
    }
    label374:
    label888:
    for (;;)
    {
      Object localObject2 = localObject1;
      if (bool) {
        localObject2 = com.tencent.mm.api.b.s((String)localObject1, 4);
      }
      a(paramImageView, paramajn, paramg, (String)localObject2, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(106980);
      return;
      ad.w("MicroMsg.FavoriteImageLogic", "webpage: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[] { paramajn.dsU, Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
      bool = false;
      break;
      localObject1 = ((aks)localObject1).thumbUrl;
      break label276;
      if ((paramajn.GhL != null) && (paramajn.GhL.GiO != null) && (!bt.hj(paramajn.GhL.GiO.mediaList)) && (!bt.isNullOrNil(((ari)paramajn.GhL.GiO.mediaList.getFirst()).thumbUrl)))
      {
        this.ryo.a(paramImageView, null, ((ari)paramajn.GhL.GiO.mediaList.getFirst()).thumbUrl, paramInt1, paramInt2, paramInt3);
        AppMethodBeat.o(106980);
        return;
      }
      paramImageView.setImageDrawable(ao.k(paramImageView.getContext(), 2131690572, paramImageView.getContext().getResources().getColor(2131099777)));
      AppMethodBeat.o(106980);
      return;
      if (paramajn.GhL == null)
      {
        ad.w("MicroMsg.FavoriteImageLogic", "good: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[] { paramajn.dsU, Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
        AppMethodBeat.o(106980);
        return;
      }
      paramajn = paramajn.GhL.Giy;
      if (paramajn != null)
      {
        this.ryo.a(paramImageView, null, paramajn.thumbUrl, paramInt1, paramInt2, paramInt3);
        AppMethodBeat.o(106980);
        return;
        if (paramajn.GhL == null)
        {
          ad.w("MicroMsg.FavoriteImageLogic", "tv: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[] { paramajn.dsU, Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
          AppMethodBeat.o(106980);
          return;
        }
        paramajn = paramajn.GhL.GiA;
        if (paramajn != null)
        {
          this.ryo.a(paramImageView, null, paramajn.thumbUrl, paramInt1, paramInt2, paramInt3);
          AppMethodBeat.o(106980);
          return;
          if (paramajn.GhL == null)
          {
            ad.w("MicroMsg.FavoriteImageLogic", "product: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[] { paramajn.dsU, Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
            AppMethodBeat.o(106980);
            return;
          }
          paramajn = paramajn.GhL.Giy;
          if (paramajn != null)
          {
            this.ryo.a(paramImageView, null, paramajn.thumbUrl, paramInt1, paramInt2, paramInt3);
            AppMethodBeat.o(106980);
            return;
            if (paramajn.GhL == null)
            {
              ad.w("MicroMsg.FavoriteImageLogic", "app brand: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[] { paramajn.dsU, Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
              AppMethodBeat.o(106980);
              return;
            }
            paramajn = paramajn.GhL.GiJ;
            if (paramajn != null)
            {
              this.ryo.a(paramImageView, null, paramajn.iconUrl, paramInt1, paramInt2, paramInt3);
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
    cwx();
    this.ryp.clear();
    this.ryq.clear();
    this.ryo.destroy();
    this.context = null;
    this.ryp = null;
    this.ryq = null;
    this.ryo = null;
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