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
import com.tencent.mm.ci.a;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.f.a.mv;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.anu;
import com.tencent.mm.protocal.protobuf.aob;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aol;
import com.tencent.mm.protocal.protobuf.aor;
import com.tencent.mm.protocal.protobuf.bjc;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class o
{
  private static f<String, Bitmap> wMA;
  private static Map<String, f.a> wMx;
  private static a wMy;
  private static f<String, Bitmap> wMz;
  public Context context;
  private h wMu;
  private HashMap<String, String[]> wMv;
  private HashMap<String, String[]> wMw;
  
  static
  {
    AppMethodBeat.i(106992);
    wMx = new HashMap();
    wMy = null;
    wMz = new com.tencent.mm.memory.a.b(10, o.class);
    wMA = new com.tencent.mm.memory.a.b(20, o.class);
    AppMethodBeat.o(106992);
  }
  
  public o(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(106974);
    this.wMv = new HashMap();
    this.wMw = new HashMap();
    if (wMy != null) {
      wMy.dead();
    }
    a locala = new a(this);
    wMy = locala;
    locala.alive();
    this.context = paramContext;
    int i = paramInt;
    if (paramInt <= 0) {
      i = 24;
    }
    this.wMu = new h(i);
    AppMethodBeat.o(106974);
  }
  
  public static Bitmap a(final anm paramanm, final g paramg)
  {
    AppMethodBeat.i(106985);
    if (!com.tencent.mm.compatible.util.e.avA())
    {
      paramanm = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), s.d.nosdcard_chatting_bg);
      AppMethodBeat.o(106985);
      return paramanm;
    }
    if (com.tencent.mm.plugin.fav.a.b.azJ(paramanm.fEa) == null)
    {
      AppMethodBeat.o(106985);
      return null;
    }
    Bitmap localBitmap = a(paramanm, true, false);
    if (localBitmap == null)
    {
      String str = com.tencent.mm.plugin.fav.a.b.a(paramanm);
      com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106971);
          if (o.aAt(this.mih)) {
            com.tencent.mm.plugin.fav.a.b.a(paramg, paramanm);
          }
          AppMethodBeat.o(106971);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(229843);
          String str = super.toString() + "|getThumb";
          AppMethodBeat.o(229843);
          return str;
        }
      });
    }
    AppMethodBeat.o(106985);
    return localBitmap;
  }
  
  public static Bitmap a(final anm paramanm, final g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(106984);
    if (!com.tencent.mm.compatible.util.e.avA())
    {
      paramanm = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), s.d.nosdcard_chatting_bg);
      AppMethodBeat.o(106984);
      return paramanm;
    }
    if (paramanm.fEa == null)
    {
      AppMethodBeat.o(106984);
      return null;
    }
    Bitmap localBitmap = a(paramanm, false, false);
    if (localBitmap == null)
    {
      final String str = com.tencent.mm.plugin.fav.a.b.d(paramanm);
      com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106968);
          if ((this.wMC) || (o.aAt(str))) {
            com.tencent.mm.plugin.fav.a.b.a(paramg, paramanm, this.wMC);
          }
          AppMethodBeat.o(106968);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(106969);
          String str = super.toString() + "|getBigImg";
          AppMethodBeat.o(106969);
          return str;
        }
      });
    }
    AppMethodBeat.o(106984);
    return localBitmap;
  }
  
  private static Bitmap a(anm paramanm, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(106981);
    if (paramBoolean1) {}
    for (paramanm = com.tencent.mm.plugin.fav.a.b.a(paramanm); !u.agG(paramanm); paramanm = com.tencent.mm.plugin.fav.a.b.d(paramanm))
    {
      Log.w("MicroMsg.FavoriteImageServer", "getBitmap file not exist");
      AppMethodBeat.o(106981);
      return null;
    }
    paramanm = e.bg(paramanm, paramBoolean2);
    AppMethodBeat.o(106981);
    return paramanm;
  }
  
  public static void a(final ImageView paramImageView, int paramInt1, final anm paramanm, final g paramg, final boolean paramBoolean, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(229533);
    if (!com.tencent.mm.compatible.util.e.avA()) {
      paramImageView.setImageBitmap(BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), s.d.nosdcard_chatting_bg));
    }
    if (paramanm.fEa == null) {
      paramImageView.setImageResource(paramInt1);
    }
    Bitmap localBitmap = a(paramanm, paramg);
    String str = com.tencent.mm.plugin.fav.a.b.d(paramanm);
    if (u.agG(str)) {
      localBitmap = c(str, paramInt2, paramInt3, true);
    }
    if (localBitmap == null)
    {
      paramImageView.setImageResource(paramInt1);
      paramImageView.setTag(str);
      com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106972);
          final Bitmap localBitmap = o.c(this.val$path, paramInt2, paramInt3, false);
          if (localBitmap == null)
          {
            o.c(paramg, paramanm, paramBoolean);
            AppMethodBeat.o(106972);
            return;
          }
          String str = (String)paramImageView.getTag();
          if ((str != null) && (str.equals(this.val$path)))
          {
            com.tencent.mm.kernel.h.aHJ();
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(233470);
                o.7.this.vhS.setImageBitmap(localBitmap);
                AppMethodBeat.o(233470);
              }
            });
          }
          AppMethodBeat.o(106972);
        }
      });
      AppMethodBeat.o(229533);
      return;
    }
    paramImageView.setImageBitmap(localBitmap);
    AppMethodBeat.o(229533);
  }
  
  public static Bitmap b(final anm paramanm, final g paramg, int paramInt)
  {
    AppMethodBeat.i(106982);
    if (!com.tencent.mm.compatible.util.e.avA())
    {
      paramanm = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), s.d.nosdcard_chatting_bg);
      AppMethodBeat.o(106982);
      return paramanm;
    }
    if (paramanm.fEa == null)
    {
      AppMethodBeat.o(106982);
      return null;
    }
    String str = com.tencent.mm.plugin.fav.a.b.d(paramanm);
    if (!u.agG(str))
    {
      Log.w("MicroMsg.FavoriteImageServer", "getBitmap file not exist");
      localObject = null;
    }
    for (;;)
    {
      if (localObject == null)
      {
        str = com.tencent.mm.plugin.fav.a.b.d(paramanm);
        com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(106966);
            if ((this.wMC) || (o.aAt(this.mih))) {
              com.tencent.mm.plugin.fav.a.b.a(paramg, paramanm, this.wMC);
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
      AppMethodBeat.o(106982);
      return localObject;
      localObject = (Bitmap)wMz.get(str);
      if (localObject == null) {
        break;
      }
      Log.d("MicroMsg.FavoriteImageServer", "get bm from cache %s", new Object[] { str });
    }
    Log.d("MicroMsg.FavoriteImageServer", "get from cache fail, try to decode from file");
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    Bitmap localBitmap = MMBitmapFactory.decodeFile(str, (BitmapFactory.Options)localObject);
    if (localBitmap != null)
    {
      Log.i("MicroMsg.FavoriteImageServer", "bitmap recycle %s", new Object[] { localBitmap });
      localBitmap.recycle();
    }
    int j = ((BitmapFactory.Options)localObject).outWidth;
    int i = ((BitmapFactory.Options)localObject).outHeight;
    Log.d("MicroMsg.FavoriteImageServer", "width: %s, height: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
    if (j > paramInt) {
      i = ((BitmapFactory.Options)localObject).outHeight * paramInt / ((BitmapFactory.Options)localObject).outWidth;
    }
    for (;;)
    {
      paramInt = Math.max(1, paramInt);
      i = Math.max(1, i);
      Log.w("MicroMsg.FavoriteImageServer", "fit long picture, beg %d*%d, after %d*%d", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject).outHeight), Integer.valueOf(paramInt), Integer.valueOf(i) });
      int k = BackwardSupportUtil.ExifHelper.getExifOrientation(str);
      if ((k == 90) || (k == 270)) {}
      for (;;)
      {
        localObject = BitmapUtil.extractThumbNail(str, paramInt, i, false);
        if (localObject == null)
        {
          Log.e("MicroMsg.FavoriteImageServer", "getSuitableBmp fail, temBmp is null, filePath = ".concat(String.valueOf(str)));
          localObject = null;
          break;
        }
        localObject = BitmapUtil.rotate((Bitmap)localObject, k);
        wMz.put(str, localObject);
        break;
        j = paramInt;
        paramInt = i;
        i = j;
      }
      paramInt = j;
    }
  }
  
  public static void b(g paramg, anm paramanm)
  {
    AppMethodBeat.i(106989);
    b(paramg, paramanm, true);
    AppMethodBeat.o(106989);
  }
  
  private static void b(final g paramg, final anm paramanm, boolean paramBoolean)
  {
    AppMethodBeat.i(106988);
    final String str = com.tencent.mm.plugin.fav.a.b.d(paramanm);
    com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(231267);
        if ((this.wMC) || (o.aAt(str))) {
          com.tencent.mm.plugin.fav.a.b.a(paramg, paramanm, this.wMC);
        }
        AppMethodBeat.o(231267);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(231270);
        String str = super.toString() + "|reDownload";
        AppMethodBeat.o(231270);
        return str;
      }
    });
    AppMethodBeat.o(106988);
  }
  
  public static Bitmap c(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(106986);
    boolean bool = false;
    if (!u.agG(paramString))
    {
      Log.w("MicroMsg.FavoriteImageServer", "file not exist");
      AppMethodBeat.o(106986);
      return null;
    }
    Bitmap localBitmap = (Bitmap)wMA.get(paramString);
    if ((localBitmap != null) || (paramBoolean))
    {
      if (localBitmap != null) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        Log.d("MicroMsg.FavoriteImageServer", "return bm path %s, bm %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
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
        Log.e("MicroMsg.FavoriteImageServer", paramString.getMessage());
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
      Log.d("MicroMsg.FavoriteImageServer", "decode top region width: %d, height: %d, scaleheight: %d, rotate: %b", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k), Boolean.valueOf(paramBoolean) });
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
          str = q.n(paramString, false);
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
        Log.d("MicroMsg.FavoriteImageServer", "width %d, height %d, tw %d, th %d", new Object[] { Integer.valueOf(paramString.getWidth()), Integer.valueOf(paramString.getHeight()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        localObject = paramString;
        wMA.put(str, paramString);
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
      Log.w("MicroMsg.FavoriteImageServer", "decode bm fail!");
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
  
  private static boolean c(anu paramanu)
  {
    AppMethodBeat.i(106978);
    if ((paramanu != null) && (paramanu.llp == 5))
    {
      AppMethodBeat.o(106978);
      return true;
    }
    AppMethodBeat.o(106978);
    return false;
  }
  
  private void dli()
  {
    AppMethodBeat.i(106975);
    h localh = this.wMu;
    synchronized (localh.lock)
    {
      Log.d("MicroMsg.ImageEngine", "do clear mark");
      localh.RwG.clear();
      localh.RwH.clear();
      localh.RwG = new HashMap();
      localh.RwH = new HashMap();
      AppMethodBeat.o(106975);
      return;
    }
  }
  
  public static Bitmap l(anm paramanm)
  {
    AppMethodBeat.i(106983);
    if (!com.tencent.mm.compatible.util.e.avA())
    {
      paramanm = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), s.d.nosdcard_chatting_bg);
      AppMethodBeat.o(106983);
      return paramanm;
    }
    if (paramanm.fEa == null)
    {
      AppMethodBeat.o(106983);
      return null;
    }
    paramanm = a(paramanm, false, true);
    AppMethodBeat.o(106983);
    return paramanm;
  }
  
  public final String a(final ImageView paramImageView, final anm paramanm, final g paramg, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(229499);
    String str = com.tencent.mm.plugin.fav.a.b.azJ(paramanm.fEa);
    String[] arrayOfString = null;
    if (paramanm.fEa != null)
    {
      arrayOfString = (String[])this.wMw.get(str);
      if (arrayOfString != null) {
        break label143;
      }
      arrayOfString = new String[1];
      arrayOfString[0] = com.tencent.mm.plugin.fav.a.b.a(paramanm);
      this.wMw.put(str, arrayOfString);
    }
    label143:
    for (;;)
    {
      this.wMu.a(paramImageView, arrayOfString, paramString, paramInt1, paramInt2, paramInt3);
      if ((arrayOfString == null) || (arrayOfString.length <= 0))
      {
        AppMethodBeat.o(229499);
        return null;
      }
      paramImageView = arrayOfString[0];
      com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106960);
          if (o.aAt(paramImageView)) {
            com.tencent.mm.plugin.fav.a.b.a(paramg, paramanm);
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
      AppMethodBeat.o(229499);
      return paramImageView;
    }
  }
  
  public final void a(ImageView paramImageView, anm paramanm, g paramg, int paramInt1, int paramInt2, int paramInt3)
  {
    String str = null;
    AppMethodBeat.i(106979);
    if (paramImageView == null)
    {
      AppMethodBeat.o(106979);
      return;
    }
    if (!com.tencent.mm.compatible.util.e.avA())
    {
      paramImageView.setImageResource(s.d.nosdcard_chatting_bg);
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
      Log.w("MicroMsg.FavoriteImageServer", "attach thumb, pass type is %d", new Object[] { Integer.valueOf(paramg.field_type) });
      AppMethodBeat.o(106979);
      return;
    case 7: 
    case 21: 
      if (paramanm != null)
      {
        paramImageView = a(paramImageView, paramanm, paramg, paramanm.fyu, paramInt1, paramInt2, paramInt3);
        if ((paramanm.SyG != null) && (paramanm.SyG.SzR != null)) {
          paramanm.SyG.SzR.lVZ = paramImageView;
        }
        AppMethodBeat.o(106979);
        return;
      }
      break;
    case 4: 
    case 16: 
      if (paramanm != null)
      {
        a(paramImageView, paramanm, paramg, paramanm.fyu, paramInt1, paramInt2, paramInt3);
        AppMethodBeat.o(106979);
        return;
      }
      break;
    case 5: 
      bool = c(paramg.field_favProto.PTL);
      Log.v("MicroMsg.FavoriteImageServer", "alvinluo attachThumb isBizNativeVideo: %b", new Object[] { Boolean.valueOf(bool) });
      localObject = paramg.field_favProto.Szr;
      if (paramanm == null)
      {
        if (localObject != null)
        {
          paramg = this.wMu;
          if (!bool) {
            break label345;
          }
        }
        label345:
        for (paramanm = com.tencent.mm.api.b.M(((aor)localObject).thumbUrl, 4);; paramanm = ((aor)localObject).thumbUrl)
        {
          paramg.a(paramImageView, null, paramanm, paramInt1, paramInt2, paramInt3);
          AppMethodBeat.o(106979);
          return;
        }
      }
      if (localObject == null)
      {
        if (!Util.isNullOrNil(str)) {
          break label544;
        }
        str = paramanm.fyu;
      }
      break;
    }
    label544:
    for (;;)
    {
      localObject = str;
      if (bool) {
        localObject = com.tencent.mm.api.b.M(str, 4);
      }
      a(paramImageView, paramanm, paramg, (String)localObject, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(106979);
      return;
      str = ((aor)localObject).thumbUrl;
      break;
      paramanm = paramg.field_favProto.Szt;
      if (paramanm != null)
      {
        this.wMu.a(paramImageView, null, paramanm.thumbUrl, paramInt1, paramInt2, paramInt3);
        AppMethodBeat.o(106979);
        return;
        paramanm = paramg.field_favProto.Szv;
        if (paramanm != null)
        {
          this.wMu.a(paramImageView, null, paramanm.thumbUrl, paramInt1, paramInt2, paramInt3);
          AppMethodBeat.o(106979);
          return;
          paramanm = paramg.field_favProto.Szt;
          if (paramanm != null)
          {
            this.wMu.a(paramImageView, null, paramanm.thumbUrl, paramInt1, paramInt2, paramInt3);
            AppMethodBeat.o(106979);
            return;
          }
        }
      }
      AppMethodBeat.o(106979);
      return;
    }
  }
  
  public final void b(ImageView paramImageView, anm paramanm, g paramg, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(106980);
    if (paramImageView == null)
    {
      AppMethodBeat.o(106980);
      return;
    }
    if (!com.tencent.mm.compatible.util.e.avA())
    {
      paramImageView.setImageResource(s.d.nosdcard_chatting_bg);
      AppMethodBeat.o(106980);
      return;
    }
    if ((paramg == null) || (paramanm == null))
    {
      paramImageView.setImageDrawable(a.m(this.context, paramInt1));
      AppMethodBeat.o(106980);
      return;
    }
    Object localObject1;
    boolean bool;
    switch (paramanm.dataType)
    {
    default: 
      Log.w("MicroMsg.FavoriteImageServer", "attach thumb, pass type is %d", new Object[] { Integer.valueOf(paramg.field_type) });
      AppMethodBeat.o(106980);
      return;
    case 7: 
    case 29: 
      a(paramImageView, paramanm, paramg, paramanm.fyu, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(106980);
      return;
    case 4: 
    case 15: 
      a(paramImageView, paramanm, paramg, paramanm.fyu, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(106980);
      return;
    case 5: 
      localObject1 = null;
      if (paramanm.SyG != null)
      {
        localObject1 = paramanm.SyG.Szr;
        bool = c(paramanm.SyG.PTL);
        if (localObject1 != null) {
          break label377;
        }
        localObject1 = null;
        label278:
        if (!Util.isNullOrNil((String)localObject1)) {
          break label891;
        }
        localObject1 = paramanm.fyu;
      }
      break;
    }
    label377:
    label891:
    for (;;)
    {
      Object localObject2 = localObject1;
      if (bool) {
        localObject2 = com.tencent.mm.api.b.M((String)localObject1, 4);
      }
      a(paramImageView, paramanm, paramg, (String)localObject2, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(106980);
      return;
      Log.w("MicroMsg.FavoriteImageServer", "webpage: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[] { paramanm.fEa, Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
      bool = false;
      break;
      localObject1 = ((aor)localObject1).thumbUrl;
      break label278;
      if ((paramanm.SyG != null) && (paramanm.SyG.SzJ != null) && (!Util.isNullOrNil(paramanm.SyG.SzJ.mediaList)) && (!Util.isNullOrNil(((bjc)paramanm.SyG.SzJ.mediaList.getFirst()).thumbUrl)))
      {
        this.wMu.a(paramImageView, null, ((bjc)paramanm.SyG.SzJ.mediaList.getFirst()).thumbUrl, paramInt1, paramInt2, paramInt3);
        AppMethodBeat.o(106980);
        return;
      }
      paramImageView.setImageDrawable(au.o(paramImageView.getContext(), s.h.icons_outlined_finder_icon, paramImageView.getContext().getResources().getColor(s.b.Orange)));
      AppMethodBeat.o(106980);
      return;
      if (paramanm.SyG == null)
      {
        Log.w("MicroMsg.FavoriteImageServer", "good: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[] { paramanm.fEa, Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
        AppMethodBeat.o(106980);
        return;
      }
      paramanm = paramanm.SyG.Szt;
      if (paramanm != null)
      {
        this.wMu.a(paramImageView, null, paramanm.thumbUrl, paramInt1, paramInt2, paramInt3);
        AppMethodBeat.o(106980);
        return;
        if (paramanm.SyG == null)
        {
          Log.w("MicroMsg.FavoriteImageServer", "tv: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[] { paramanm.fEa, Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
          AppMethodBeat.o(106980);
          return;
        }
        paramanm = paramanm.SyG.Szv;
        if (paramanm != null)
        {
          this.wMu.a(paramImageView, null, paramanm.thumbUrl, paramInt1, paramInt2, paramInt3);
          AppMethodBeat.o(106980);
          return;
          if (paramanm.SyG == null)
          {
            Log.w("MicroMsg.FavoriteImageServer", "product: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[] { paramanm.fEa, Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
            AppMethodBeat.o(106980);
            return;
          }
          paramanm = paramanm.SyG.Szt;
          if (paramanm != null)
          {
            this.wMu.a(paramImageView, null, paramanm.thumbUrl, paramInt1, paramInt2, paramInt3);
            AppMethodBeat.o(106980);
            return;
            if (paramanm.SyG == null)
            {
              Log.w("MicroMsg.FavoriteImageServer", "app brand: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[] { paramanm.fEa, Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
              AppMethodBeat.o(106980);
              return;
            }
            paramanm = paramanm.SyG.SzE;
            if (paramanm != null)
            {
              this.wMu.a(paramImageView, null, paramanm.iconUrl, paramInt1, paramInt2, paramInt3);
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
  
  public final void c(final ImageView paramImageView, final anm paramanm, final g paramg, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(229517);
    if (paramImageView == null)
    {
      AppMethodBeat.o(229517);
      return;
    }
    if (!com.tencent.mm.compatible.util.e.avA())
    {
      paramImageView.setImageResource(s.d.nosdcard_chatting_bg);
      AppMethodBeat.o(229517);
      return;
    }
    if ((paramanm == null) || (paramg == null))
    {
      AppMethodBeat.o(229517);
      return;
    }
    String str = paramanm.fEa;
    if (str == null)
    {
      AppMethodBeat.o(229517);
      return;
    }
    final Object localObject1 = null;
    Object localObject3 = null;
    if (paramanm.fEa != null)
    {
      Object localObject2 = localObject3;
      if (this.wMv != null)
      {
        localObject2 = localObject3;
        if (!this.wMv.isEmpty()) {
          localObject2 = (String[])this.wMv.get(str);
        }
      }
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = new String[2];
        localObject2[0] = com.tencent.mm.plugin.fav.a.b.d(paramanm);
        localObject2[1] = com.tencent.mm.plugin.fav.a.b.a(paramanm);
        localObject1 = localObject2;
        if (this.wMv != null)
        {
          this.wMv.put(str, localObject2);
          localObject1 = localObject2;
        }
      }
    }
    this.wMu.a(paramImageView, localObject1, null, paramInt1, paramInt2, paramInt3);
    if ((localObject1 == null) || (localObject1.length <= 0))
    {
      AppMethodBeat.o(229517);
      return;
    }
    paramImageView = localObject1[0];
    localObject1 = localObject1[1];
    com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106962);
        if (o.aAt(paramImageView))
        {
          Log.i("MicroMsg.FavoriteImageServer", "attachVideoImg, needRestartCdnDownload, videoPath:%s", new Object[] { u.n(paramImageView, false) });
          com.tencent.mm.plugin.fav.a.b.a(paramg, paramanm, false);
        }
        if (o.fv(localObject1))
        {
          Log.i("MicroMsg.FavoriteImageServer", "attachVideoImg, restartCdnThumbDownLoad, thumbPath:%s", new Object[] { u.n(localObject1, false) });
          com.tencent.mm.plugin.fav.a.b.a(paramg, paramanm);
        }
        AppMethodBeat.o(106962);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(106963);
        String str = super.toString() + "|attachImg";
        AppMethodBeat.o(106963);
        return str;
      }
    });
    AppMethodBeat.o(229517);
  }
  
  public final void d(final ImageView paramImageView, final anm paramanm, final g paramg, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(229521);
    if (paramImageView == null)
    {
      AppMethodBeat.o(229521);
      return;
    }
    if (!com.tencent.mm.compatible.util.e.avA())
    {
      paramImageView.setImageResource(s.d.nosdcard_chatting_bg);
      AppMethodBeat.o(229521);
      return;
    }
    if ((paramanm == null) || (paramg == null))
    {
      AppMethodBeat.o(229521);
      return;
    }
    String str = paramanm.fEa;
    if (str == null)
    {
      AppMethodBeat.o(229521);
      return;
    }
    String[] arrayOfString2;
    if (paramanm.fEa != null) {
      if ((this.wMv != null) && (!this.wMv.isEmpty()))
      {
        arrayOfString2 = (String[])this.wMv.get(str);
        arrayOfString1 = arrayOfString2;
        if (arrayOfString2 == null)
        {
          arrayOfString2 = new String[2];
          arrayOfString2[0] = com.tencent.mm.plugin.fav.a.b.d(paramanm);
          arrayOfString2[1] = com.tencent.mm.plugin.fav.a.b.a(paramanm);
          arrayOfString1 = arrayOfString2;
          if (this.wMv != null) {
            this.wMv.put(str, arrayOfString2);
          }
        }
      }
    }
    for (String[] arrayOfString1 = arrayOfString2;; arrayOfString1 = null)
    {
      this.wMu.a(paramImageView, arrayOfString1, null, paramInt1, paramInt2, paramInt3);
      if ((arrayOfString1 == null) || (arrayOfString1.length <= 0))
      {
        AppMethodBeat.o(229521);
        return;
      }
      paramImageView = arrayOfString1[0];
      com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106964);
          if (o.aAt(paramImageView))
          {
            Log.i("MicroMsg.FavoriteImageServer", "attachImg, restartCdnDataDownload, checkPath:%s", new Object[] { u.n(paramImageView, false) });
            com.tencent.mm.plugin.fav.a.b.a(paramg, paramanm, false);
          }
          AppMethodBeat.o(106964);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(106965);
          String str = super.toString() + "|attachImg";
          AppMethodBeat.o(106965);
          return str;
        }
      });
      AppMethodBeat.o(229521);
      return;
      arrayOfString2 = null;
      break;
    }
  }
  
  public final void destory()
  {
    AppMethodBeat.i(106976);
    Log.i("MicroMsg.FavoriteImageServer", "destory");
    dli();
    this.wMv.clear();
    this.wMw.clear();
    this.wMu.destroy();
    this.context = null;
    this.wMv = null;
    this.wMw = null;
    this.wMu = null;
    AppMethodBeat.o(106976);
  }
  
  public final Context getContext()
  {
    return this.context;
  }
  
  static final class a
    extends IListener<mv>
  {
    private final WeakReference<o> kNt;
    
    public a(o paramo)
    {
      AppMethodBeat.i(229701);
      this.kNt = new WeakReference(paramo);
      this.__eventId = mv.class.getName().hashCode();
      AppMethodBeat.o(229701);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.o
 * JD-Core Version:    0.7.0.1
 */