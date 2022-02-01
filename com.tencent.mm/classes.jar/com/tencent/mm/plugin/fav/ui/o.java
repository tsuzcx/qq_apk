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
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.protocal.protobuf.bch;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class o
{
  private static Map<String, f.a> tgi;
  private static f<String, Bitmap> tgj;
  private static f<String, Bitmap> tgk;
  public Context context;
  public h tgf;
  public HashMap<String, String[]> tgg;
  private HashMap<String, String[]> tgh;
  
  static
  {
    AppMethodBeat.i(106992);
    tgi = new HashMap();
    tgj = new com.tencent.mm.memory.a.b(10, o.class);
    tgk = new com.tencent.mm.memory.a.b(20, o.class);
    AppMethodBeat.o(106992);
  }
  
  public o(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(106974);
    this.tgg = new HashMap();
    this.tgh = new HashMap();
    this.context = paramContext;
    int i = paramInt;
    if (paramInt <= 0) {
      i = 24;
    }
    this.tgf = new h(i);
    AppMethodBeat.o(106974);
  }
  
  public static Bitmap a(final aml paramaml, final com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(106985);
    if (!com.tencent.mm.compatible.util.e.apn())
    {
      paramaml = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), 2131234279);
      AppMethodBeat.o(106985);
      return paramaml;
    }
    if (com.tencent.mm.plugin.fav.a.b.arI(paramaml.dLl) == null)
    {
      AppMethodBeat.o(106985);
      return null;
    }
    Bitmap localBitmap = a(paramaml, true, false);
    if (localBitmap == null)
    {
      String str = com.tencent.mm.plugin.fav.a.b.a(paramaml);
      com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106968);
          if (o.gi(this.jsE)) {
            com.tencent.mm.plugin.fav.a.b.a(paramg, paramaml);
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
  
  public static Bitmap a(final aml paramaml, final com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(106984);
    if (!com.tencent.mm.compatible.util.e.apn())
    {
      paramaml = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), 2131234279);
      AppMethodBeat.o(106984);
      return paramaml;
    }
    if (paramaml.dLl == null)
    {
      AppMethodBeat.o(106984);
      return null;
    }
    Bitmap localBitmap = a(paramaml, false, false);
    if (localBitmap == null)
    {
      final String str = com.tencent.mm.plugin.fav.a.b.d(paramaml);
      com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106966);
          if ((this.tgm) || (o.gi(str))) {
            com.tencent.mm.plugin.fav.a.b.a(paramg, paramaml, this.tgm);
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
  
  private static Bitmap a(aml paramaml, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(106981);
    if (paramBoolean1) {}
    for (paramaml = com.tencent.mm.plugin.fav.a.b.a(paramaml); !s.YS(paramaml); paramaml = com.tencent.mm.plugin.fav.a.b.d(paramaml))
    {
      Log.w("MicroMsg.FavoriteImageLogic", "getBitmap file not exist");
      AppMethodBeat.o(106981);
      return null;
    }
    paramaml = e.bd(paramaml, paramBoolean2);
    AppMethodBeat.o(106981);
    return paramaml;
  }
  
  public static void a(final ImageView paramImageView, int paramInt1, final aml paramaml, final com.tencent.mm.plugin.fav.a.g paramg, final boolean paramBoolean, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(235322);
    if (!com.tencent.mm.compatible.util.e.apn()) {
      paramImageView.setImageBitmap(BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), 2131234279));
    }
    if (paramaml.dLl == null) {
      paramImageView.setImageResource(paramInt1);
    }
    Bitmap localBitmap = a(paramaml, paramg);
    String str = com.tencent.mm.plugin.fav.a.b.d(paramaml);
    if (s.YS(str)) {
      localBitmap = c(str, paramInt2, paramInt3, true);
    }
    if (localBitmap == null)
    {
      paramImageView.setImageResource(paramInt1);
      paramImageView.setTag(str);
      com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106971);
          final Bitmap localBitmap = o.c(this.val$path, paramInt2, paramInt3, false);
          if (localBitmap == null)
          {
            o.c(paramg, paramaml, paramBoolean);
            AppMethodBeat.o(106971);
            return;
          }
          String str = (String)paramImageView.getTag();
          if ((str != null) && (str.equals(this.val$path)))
          {
            com.tencent.mm.kernel.g.aAk();
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(106970);
                o.6.this.rCk.setImageBitmap(localBitmap);
                AppMethodBeat.o(106970);
              }
            });
          }
          AppMethodBeat.o(106971);
        }
      });
      AppMethodBeat.o(235322);
      return;
    }
    paramImageView.setImageBitmap(localBitmap);
    AppMethodBeat.o(235322);
  }
  
  public static Bitmap b(final aml paramaml, final com.tencent.mm.plugin.fav.a.g paramg, int paramInt)
  {
    AppMethodBeat.i(106982);
    if (!com.tencent.mm.compatible.util.e.apn())
    {
      paramaml = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), 2131234279);
      AppMethodBeat.o(106982);
      return paramaml;
    }
    if (paramaml.dLl == null)
    {
      AppMethodBeat.o(106982);
      return null;
    }
    String str = com.tencent.mm.plugin.fav.a.b.d(paramaml);
    if (!s.YS(str))
    {
      Log.w("MicroMsg.FavoriteImageLogic", "getBitmap file not exist");
      localObject = null;
    }
    for (;;)
    {
      if (localObject == null)
      {
        str = com.tencent.mm.plugin.fav.a.b.d(paramaml);
        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(106964);
            if ((this.tgm) || (o.gi(this.jsE))) {
              com.tencent.mm.plugin.fav.a.b.a(paramg, paramaml, this.tgm);
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
      localObject = (Bitmap)tgj.get(str);
      if (localObject == null) {
        break;
      }
      Log.d("MicroMsg.FavoriteImageLogic", "get bm from cache %s", new Object[] { str });
    }
    Log.d("MicroMsg.FavoriteImageLogic", "get from cache fail, try to decode from file");
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    Bitmap localBitmap = MMBitmapFactory.decodeFile(str, (BitmapFactory.Options)localObject);
    if (localBitmap != null)
    {
      Log.i("MicroMsg.FavoriteImageLogic", "bitmap recycle %s", new Object[] { localBitmap });
      localBitmap.recycle();
    }
    int j = ((BitmapFactory.Options)localObject).outWidth;
    int i = ((BitmapFactory.Options)localObject).outHeight;
    Log.d("MicroMsg.FavoriteImageLogic", "width: %s, height: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
    if (j > paramInt) {
      i = ((BitmapFactory.Options)localObject).outHeight * paramInt / ((BitmapFactory.Options)localObject).outWidth;
    }
    for (;;)
    {
      paramInt = Math.max(1, paramInt);
      i = Math.max(1, i);
      Log.w("MicroMsg.FavoriteImageLogic", "fit long picture, beg %d*%d, after %d*%d", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject).outHeight), Integer.valueOf(paramInt), Integer.valueOf(i) });
      int k = BackwardSupportUtil.ExifHelper.getExifOrientation(str);
      if ((k == 90) || (k == 270)) {}
      for (;;)
      {
        localObject = BitmapUtil.extractThumbNail(str, paramInt, i, false);
        if (localObject == null)
        {
          Log.e("MicroMsg.FavoriteImageLogic", "getSuitableBmp fail, temBmp is null, filePath = ".concat(String.valueOf(str)));
          localObject = null;
          break;
        }
        localObject = BitmapUtil.rotate((Bitmap)localObject, k);
        tgj.put(str, localObject);
        break;
        j = paramInt;
        paramInt = i;
        i = j;
      }
      paramInt = j;
    }
  }
  
  public static void b(com.tencent.mm.plugin.fav.a.g paramg, aml paramaml)
  {
    AppMethodBeat.i(106989);
    b(paramg, paramaml, true);
    AppMethodBeat.o(106989);
  }
  
  private static void b(final com.tencent.mm.plugin.fav.a.g paramg, final aml paramaml, boolean paramBoolean)
  {
    AppMethodBeat.i(106988);
    final String str = com.tencent.mm.plugin.fav.a.b.d(paramaml);
    com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106972);
        if ((this.tgm) || (o.gi(str))) {
          com.tencent.mm.plugin.fav.a.b.a(paramg, paramaml, this.tgm);
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
    if (!s.YS(paramString))
    {
      Log.w("MicroMsg.FavoriteImageLogic", "file not exist");
      AppMethodBeat.o(106986);
      return null;
    }
    Bitmap localBitmap = (Bitmap)tgk.get(paramString);
    if ((localBitmap != null) || (paramBoolean))
    {
      if (localBitmap != null) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        Log.d("MicroMsg.FavoriteImageLogic", "return bm path %s, bm %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
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
        BitmapUtil.decodeFile(paramString, localOptions);
        localObject = localBitmap;
        i = localOptions.outWidth;
        localObject = localBitmap;
        j = localOptions.outHeight;
        localObject = localBitmap;
        m = BackwardSupportUtil.ExifHelper.getExifOrientation(paramString);
        if (m == 90) {
          break label625;
        }
        if (m != 270) {
          break label607;
        }
      }
      catch (IOException paramString)
      {
        Log.e("MicroMsg.FavoriteImageLogic", paramString.getMessage());
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
      Log.d("MicroMsg.FavoriteImageLogic", "decode top region width: %d, height: %d, scaleheight: %d, rotate: %b", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k), Boolean.valueOf(paramBoolean) });
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
            paramString = BitmapUtil.rotate(localBitmap, m);
          }
        }
        if (paramString == null) {
          break label593;
        }
        localObject = paramString;
        Log.d("MicroMsg.FavoriteImageLogic", "width %d, height %d, tw %d, th %d", new Object[] { Integer.valueOf(paramString.getWidth()), Integer.valueOf(paramString.getHeight()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        localObject = paramString;
        tgk.put(str, paramString);
        break;
        localObject = localBitmap;
        localRect.right = j;
        localObject = localBitmap;
        localRect.bottom = k;
        break label395;
        localObject = localBitmap;
        localOptions.inJustDecodeBounds = false;
        localObject = localBitmap;
        localBitmap = BitmapUtil.decodeFile(paramString, localOptions);
        str = paramString;
      }
      label593:
      localObject = paramString;
      Log.w("MicroMsg.FavoriteImageLogic", "decode bm fail!");
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
  
  private static boolean c(amt paramamt)
  {
    AppMethodBeat.i(106978);
    if ((paramamt != null) && (paramamt.iwc == 5) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).cld()))
    {
      AppMethodBeat.o(106978);
      return true;
    }
    AppMethodBeat.o(106978);
    return false;
  }
  
  private void cWc()
  {
    AppMethodBeat.i(106975);
    h localh = this.tgf;
    synchronized (localh.lock)
    {
      Log.d("MicroMsg.ImageEngine", "do clear mark");
      localh.Kvt.clear();
      localh.Kvu.clear();
      localh.Kvt = new HashMap();
      localh.Kvu = new HashMap();
      AppMethodBeat.o(106975);
      return;
    }
  }
  
  public static Bitmap l(aml paramaml)
  {
    AppMethodBeat.i(106983);
    if (!com.tencent.mm.compatible.util.e.apn())
    {
      paramaml = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), 2131234279);
      AppMethodBeat.o(106983);
      return paramaml;
    }
    if (paramaml.dLl == null)
    {
      AppMethodBeat.o(106983);
      return null;
    }
    paramaml = a(paramaml, false, true);
    AppMethodBeat.o(106983);
    return paramaml;
  }
  
  public final String a(final ImageView paramImageView, final aml paramaml, final com.tencent.mm.plugin.fav.a.g paramg, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(235321);
    String str = com.tencent.mm.plugin.fav.a.b.arI(paramaml.dLl);
    String[] arrayOfString = null;
    if (paramaml.dLl != null)
    {
      arrayOfString = (String[])this.tgh.get(str);
      if (arrayOfString != null) {
        break label143;
      }
      arrayOfString = new String[1];
      arrayOfString[0] = com.tencent.mm.plugin.fav.a.b.a(paramaml);
      this.tgh.put(str, arrayOfString);
    }
    label143:
    for (;;)
    {
      this.tgf.a(paramImageView, arrayOfString, paramString, paramInt1, paramInt2, paramInt3);
      if ((arrayOfString == null) || (arrayOfString.length <= 0))
      {
        AppMethodBeat.o(235321);
        return null;
      }
      paramImageView = arrayOfString[0];
      com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106960);
          if (o.gi(paramImageView)) {
            com.tencent.mm.plugin.fav.a.b.a(paramg, paramaml);
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
      paramImageView = arrayOfString[0];
      AppMethodBeat.o(235321);
      return paramImageView;
    }
  }
  
  public final void a(ImageView paramImageView, aml paramaml, com.tencent.mm.plugin.fav.a.g paramg, int paramInt1, int paramInt2, int paramInt3)
  {
    String str = null;
    AppMethodBeat.i(106979);
    if (paramImageView == null)
    {
      AppMethodBeat.o(106979);
      return;
    }
    if (!com.tencent.mm.compatible.util.e.apn())
    {
      paramImageView.setImageResource(2131234279);
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
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    default: 
      Log.w("MicroMsg.FavoriteImageLogic", "attach thumb, pass type is %d", new Object[] { Integer.valueOf(paramg.field_type) });
      AppMethodBeat.o(106979);
      return;
    case 7: 
    case 21: 
      if (paramaml != null)
      {
        paramImageView = a(paramImageView, paramaml, paramg, paramaml.dFN, paramInt1, paramInt2, paramInt3);
        if ((paramaml.Lwh != null) && (paramaml.Lwh.Lxs != null)) {
          paramaml.Lwh.Lxs.jfz = paramImageView;
        }
        AppMethodBeat.o(106979);
        return;
      }
      break;
    case 4: 
    case 16: 
      if (paramaml != null)
      {
        a(paramImageView, paramaml, paramg, paramaml.dFN, paramInt1, paramInt2, paramInt3);
        AppMethodBeat.o(106979);
        return;
      }
      break;
    case 5: 
      bool = c(paramg.field_favProto.IXu);
      Log.v("MicroMsg.FavoriteImageLogic", "alvinluo attachThumb isBizNativeVideo: %b", new Object[] { Boolean.valueOf(bool) });
      localObject = paramg.field_favProto.LwS;
      if (paramaml == null)
      {
        if (localObject != null)
        {
          paramg = this.tgf;
          if (!bool) {
            break label345;
          }
        }
        label345:
        for (paramaml = com.tencent.mm.api.b.u(((anq)localObject).thumbUrl, 4);; paramaml = ((anq)localObject).thumbUrl)
        {
          paramg.a(paramImageView, null, paramaml, paramInt1, paramInt2, paramInt3);
          AppMethodBeat.o(106979);
          return;
        }
      }
      if (localObject == null)
      {
        if (!Util.isNullOrNil(str)) {
          break label544;
        }
        str = paramaml.dFN;
      }
      break;
    }
    label544:
    for (;;)
    {
      localObject = str;
      if (bool) {
        localObject = com.tencent.mm.api.b.u(str, 4);
      }
      a(paramImageView, paramaml, paramg, (String)localObject, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(106979);
      return;
      str = ((anq)localObject).thumbUrl;
      break;
      paramaml = paramg.field_favProto.LwU;
      if (paramaml != null)
      {
        this.tgf.a(paramImageView, null, paramaml.thumbUrl, paramInt1, paramInt2, paramInt3);
        AppMethodBeat.o(106979);
        return;
        paramaml = paramg.field_favProto.LwW;
        if (paramaml != null)
        {
          this.tgf.a(paramImageView, null, paramaml.thumbUrl, paramInt1, paramInt2, paramInt3);
          AppMethodBeat.o(106979);
          return;
          paramaml = paramg.field_favProto.LwU;
          if (paramaml != null)
          {
            this.tgf.a(paramImageView, null, paramaml.thumbUrl, paramInt1, paramInt2, paramInt3);
            AppMethodBeat.o(106979);
            return;
          }
        }
      }
      AppMethodBeat.o(106979);
      return;
    }
  }
  
  public final void b(ImageView paramImageView, aml paramaml, com.tencent.mm.plugin.fav.a.g paramg, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(106980);
    if (paramImageView == null)
    {
      AppMethodBeat.o(106980);
      return;
    }
    if (!com.tencent.mm.compatible.util.e.apn())
    {
      paramImageView.setImageResource(2131234279);
      AppMethodBeat.o(106980);
      return;
    }
    if ((paramg == null) || (paramaml == null))
    {
      paramImageView.setImageDrawable(a.l(this.context, paramInt1));
      AppMethodBeat.o(106980);
      return;
    }
    Object localObject1;
    boolean bool;
    switch (paramaml.dataType)
    {
    default: 
      Log.w("MicroMsg.FavoriteImageLogic", "attach thumb, pass type is %d", new Object[] { Integer.valueOf(paramg.field_type) });
      AppMethodBeat.o(106980);
      return;
    case 7: 
    case 29: 
      a(paramImageView, paramaml, paramg, paramaml.dFN, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(106980);
      return;
    case 4: 
    case 15: 
      a(paramImageView, paramaml, paramg, paramaml.dFN, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(106980);
      return;
    case 5: 
      localObject1 = null;
      if (paramaml.Lwh != null)
      {
        localObject1 = paramaml.Lwh.LwS;
        bool = c(paramaml.Lwh.IXu);
        if (localObject1 != null) {
          break label377;
        }
        localObject1 = null;
        label278:
        if (!Util.isNullOrNil((String)localObject1)) {
          break label891;
        }
        localObject1 = paramaml.dFN;
      }
      break;
    }
    label377:
    label891:
    for (;;)
    {
      Object localObject2 = localObject1;
      if (bool) {
        localObject2 = com.tencent.mm.api.b.u((String)localObject1, 4);
      }
      a(paramImageView, paramaml, paramg, (String)localObject2, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(106980);
      return;
      Log.w("MicroMsg.FavoriteImageLogic", "webpage: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[] { paramaml.dLl, Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
      bool = false;
      break;
      localObject1 = ((anq)localObject1).thumbUrl;
      break label278;
      if ((paramaml.Lwh != null) && (paramaml.Lwh.Lxk != null) && (!Util.isNullOrNil(paramaml.Lwh.Lxk.mediaList)) && (!Util.isNullOrNil(((bch)paramaml.Lwh.Lxk.mediaList.getFirst()).thumbUrl)))
      {
        this.tgf.a(paramImageView, null, ((bch)paramaml.Lwh.Lxk.mediaList.getFirst()).thumbUrl, paramInt1, paramInt2, paramInt3);
        AppMethodBeat.o(106980);
        return;
      }
      paramImageView.setImageDrawable(ar.m(paramImageView.getContext(), 2131690801, paramImageView.getContext().getResources().getColor(2131099792)));
      AppMethodBeat.o(106980);
      return;
      if (paramaml.Lwh == null)
      {
        Log.w("MicroMsg.FavoriteImageLogic", "good: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[] { paramaml.dLl, Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
        AppMethodBeat.o(106980);
        return;
      }
      paramaml = paramaml.Lwh.LwU;
      if (paramaml != null)
      {
        this.tgf.a(paramImageView, null, paramaml.thumbUrl, paramInt1, paramInt2, paramInt3);
        AppMethodBeat.o(106980);
        return;
        if (paramaml.Lwh == null)
        {
          Log.w("MicroMsg.FavoriteImageLogic", "tv: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[] { paramaml.dLl, Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
          AppMethodBeat.o(106980);
          return;
        }
        paramaml = paramaml.Lwh.LwW;
        if (paramaml != null)
        {
          this.tgf.a(paramImageView, null, paramaml.thumbUrl, paramInt1, paramInt2, paramInt3);
          AppMethodBeat.o(106980);
          return;
          if (paramaml.Lwh == null)
          {
            Log.w("MicroMsg.FavoriteImageLogic", "product: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[] { paramaml.dLl, Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
            AppMethodBeat.o(106980);
            return;
          }
          paramaml = paramaml.Lwh.LwU;
          if (paramaml != null)
          {
            this.tgf.a(paramImageView, null, paramaml.thumbUrl, paramInt1, paramInt2, paramInt3);
            AppMethodBeat.o(106980);
            return;
            if (paramaml.Lwh == null)
            {
              Log.w("MicroMsg.FavoriteImageLogic", "app brand: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[] { paramaml.dLl, Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
              AppMethodBeat.o(106980);
              return;
            }
            paramaml = paramaml.Lwh.Lxf;
            if (paramaml != null)
            {
              this.tgf.a(paramImageView, null, paramaml.iconUrl, paramInt1, paramInt2, paramInt3);
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
    cWc();
    this.tgg.clear();
    this.tgh.clear();
    this.tgf.destroy();
    this.context = null;
    this.tgg = null;
    this.tgh = null;
    this.tgf = null;
    AppMethodBeat.o(106976);
  }
  
  public final Context getContext()
  {
    return this.context;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.o
 * JD-Core Version:    0.7.0.1
 */