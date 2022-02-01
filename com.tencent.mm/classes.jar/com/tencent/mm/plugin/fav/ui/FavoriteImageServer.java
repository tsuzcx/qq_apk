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
import com.tencent.mm.autogen.a.oc;
import com.tencent.mm.b.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.aru;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.protocal.protobuf.ask;
import com.tencent.mm.protocal.protobuf.bvj;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bb;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class FavoriteImageServer
{
  private static Map<String, f.a> AiU;
  private static MMTrimMemoryEventListener AiV;
  private static com.tencent.mm.b.f<String, Bitmap> AiW;
  private static com.tencent.mm.b.f<String, Bitmap> AiX;
  private h AiR;
  private HashMap<String, String[]> AiS;
  private HashMap<String, String[]> AiT;
  public Context context;
  
  static
  {
    AppMethodBeat.i(106992);
    AiU = new HashMap();
    AiV = null;
    AiW = new com.tencent.mm.memory.a.b(10, FavoriteImageServer.class);
    AiX = new com.tencent.mm.memory.a.b(20, FavoriteImageServer.class);
    AppMethodBeat.o(106992);
  }
  
  public FavoriteImageServer(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(106974);
    this.AiS = new HashMap();
    this.AiT = new HashMap();
    if (AiV != null) {
      AiV.dead();
    }
    MMTrimMemoryEventListener localMMTrimMemoryEventListener = new MMTrimMemoryEventListener(this);
    AiV = localMMTrimMemoryEventListener;
    localMMTrimMemoryEventListener.alive();
    this.context = paramContext;
    int i = paramInt;
    if (paramInt <= 0) {
      i = 24;
    }
    this.AiR = new h(i);
    AppMethodBeat.o(106974);
  }
  
  public static Bitmap a(final arf paramarf, final g paramg)
  {
    AppMethodBeat.i(106985);
    if (!com.tencent.mm.compatible.util.e.aPU())
    {
      paramarf = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), q.d.nosdcard_chatting_bg);
      AppMethodBeat.o(106985);
      return paramarf;
    }
    if (com.tencent.mm.plugin.fav.a.b.atP(paramarf.hIQ) == null)
    {
      AppMethodBeat.o(106985);
      return null;
    }
    Bitmap localBitmap = a(paramarf, true, false);
    if (localBitmap == null)
    {
      String str = com.tencent.mm.plugin.fav.a.b.a(paramarf);
      com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106971);
          if (FavoriteImageServer.auA(FavoriteImageServer.this)) {
            com.tencent.mm.plugin.fav.a.b.a(paramg, paramarf);
          }
          AppMethodBeat.o(106971);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(274428);
          String str = super.toString() + "|getThumb";
          AppMethodBeat.o(274428);
          return str;
        }
      });
    }
    AppMethodBeat.o(106985);
    return localBitmap;
  }
  
  public static Bitmap a(final arf paramarf, final g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(106984);
    if (!com.tencent.mm.compatible.util.e.aPU())
    {
      paramarf = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), q.d.nosdcard_chatting_bg);
      AppMethodBeat.o(106984);
      return paramarf;
    }
    if (paramarf.hIQ == null)
    {
      AppMethodBeat.o(106984);
      return null;
    }
    Bitmap localBitmap = a(paramarf, false, false);
    if (localBitmap == null)
    {
      final String str = com.tencent.mm.plugin.fav.a.b.d(paramarf);
      com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106968);
          if ((this.AiZ) || (FavoriteImageServer.auA(str))) {
            com.tencent.mm.plugin.fav.a.b.a(paramg, paramarf, this.AiZ);
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
  
  private static Bitmap a(arf paramarf, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(106981);
    if (paramBoolean1) {}
    for (paramarf = com.tencent.mm.plugin.fav.a.b.a(paramarf); !y.ZC(paramarf); paramarf = com.tencent.mm.plugin.fav.a.b.d(paramarf))
    {
      Log.w("MicroMsg.FavoriteImageServer", "getBitmap file not exist");
      AppMethodBeat.o(106981);
      return null;
    }
    paramarf = e.bs(paramarf, paramBoolean2);
    AppMethodBeat.o(106981);
    return paramarf;
  }
  
  public static void a(final ImageView paramImageView, int paramInt1, final arf paramarf, final g paramg, final boolean paramBoolean, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(274391);
    if (!com.tencent.mm.compatible.util.e.aPU()) {
      paramImageView.setImageBitmap(BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), q.d.nosdcard_chatting_bg));
    }
    if (paramarf.hIQ == null) {
      paramImageView.setImageResource(paramInt1);
    }
    Bitmap localBitmap = a(paramarf, paramg);
    String str = com.tencent.mm.plugin.fav.a.b.d(paramarf);
    if (y.ZC(str)) {
      localBitmap = c(str, paramInt2, paramInt3, true);
    }
    if (localBitmap == null)
    {
      paramImageView.setImageResource(paramInt1);
      paramImageView.setTag(str);
      com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106972);
          final Bitmap localBitmap = FavoriteImageServer.c(FavoriteImageServer.this, paramInt2, paramInt3, false);
          if (localBitmap == null)
          {
            FavoriteImageServer.c(paramg, paramarf, paramBoolean);
            AppMethodBeat.o(106972);
            return;
          }
          String str = (String)paramImageView.getTag();
          if ((str != null) && (str.equals(FavoriteImageServer.this)))
          {
            com.tencent.mm.kernel.h.baH();
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(274376);
                FavoriteImageServer.7.this.ytT.setImageBitmap(localBitmap);
                AppMethodBeat.o(274376);
              }
            });
          }
          AppMethodBeat.o(106972);
        }
      });
      AppMethodBeat.o(274391);
      return;
    }
    paramImageView.setImageBitmap(localBitmap);
    AppMethodBeat.o(274391);
  }
  
  public static Bitmap b(final arf paramarf, final g paramg, int paramInt)
  {
    AppMethodBeat.i(106982);
    if (!com.tencent.mm.compatible.util.e.aPU())
    {
      paramarf = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), q.d.nosdcard_chatting_bg);
      AppMethodBeat.o(106982);
      return paramarf;
    }
    if (paramarf.hIQ == null)
    {
      AppMethodBeat.o(106982);
      return null;
    }
    String str = com.tencent.mm.plugin.fav.a.b.d(paramarf);
    if (!y.ZC(str))
    {
      Log.w("MicroMsg.FavoriteImageServer", "getBitmap file not exist");
      localObject = null;
    }
    for (;;)
    {
      if (localObject == null)
      {
        str = com.tencent.mm.plugin.fav.a.b.d(paramarf);
        com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(106966);
            if ((this.AiZ) || (FavoriteImageServer.auA(FavoriteImageServer.this))) {
              com.tencent.mm.plugin.fav.a.b.a(paramg, paramarf, this.AiZ);
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
      localObject = (Bitmap)AiW.get(str);
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
        AiW.put(str, localObject);
        break;
        j = paramInt;
        paramInt = i;
        i = j;
      }
      paramInt = j;
    }
  }
  
  public static void b(g paramg, arf paramarf)
  {
    AppMethodBeat.i(106989);
    b(paramg, paramarf, true);
    AppMethodBeat.o(106989);
  }
  
  private static void b(final g paramg, final arf paramarf, boolean paramBoolean)
  {
    AppMethodBeat.i(106988);
    final String str = com.tencent.mm.plugin.fav.a.b.d(paramarf);
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(274427);
        if ((this.AiZ) || (FavoriteImageServer.auA(str))) {
          com.tencent.mm.plugin.fav.a.b.a(paramg, paramarf, this.AiZ);
        }
        AppMethodBeat.o(274427);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(274430);
        String str = super.toString() + "|reDownload";
        AppMethodBeat.o(274430);
        return str;
      }
    });
    AppMethodBeat.o(106988);
  }
  
  public static Bitmap c(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(106986);
    boolean bool = false;
    if (!y.ZC(paramString))
    {
      Log.w("MicroMsg.FavoriteImageServer", "file not exist");
      AppMethodBeat.o(106986);
      return null;
    }
    Bitmap localBitmap = (Bitmap)AiX.get(paramString);
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
        AiX.put(str, paramString);
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
  
  private static boolean c(arn paramarn)
  {
    AppMethodBeat.i(106978);
    if ((paramarn != null) && (paramarn.nQm == 5))
    {
      AppMethodBeat.o(106978);
      return true;
    }
    AppMethodBeat.o(106978);
    return false;
  }
  
  private void dRY()
  {
    AppMethodBeat.i(106975);
    h localh = this.AiR;
    synchronized (localh.lock)
    {
      Log.d("MicroMsg.ImageEngine", "do clear mark");
      localh.YsT.clear();
      localh.YsU.clear();
      localh.YsT = new HashMap();
      localh.YsU = new HashMap();
      AppMethodBeat.o(106975);
      return;
    }
  }
  
  public static Bitmap l(arf paramarf)
  {
    AppMethodBeat.i(106983);
    if (!com.tencent.mm.compatible.util.e.aPU())
    {
      paramarf = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), q.d.nosdcard_chatting_bg);
      AppMethodBeat.o(106983);
      return paramarf;
    }
    if (paramarf.hIQ == null)
    {
      AppMethodBeat.o(106983);
      return null;
    }
    paramarf = a(paramarf, false, true);
    AppMethodBeat.o(106983);
    return paramarf;
  }
  
  public final String a(final ImageView paramImageView, final arf paramarf, final g paramg, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(274410);
    String str = com.tencent.mm.plugin.fav.a.b.atP(paramarf.hIQ);
    String[] arrayOfString = null;
    if (paramarf.hIQ != null)
    {
      arrayOfString = (String[])this.AiT.get(str);
      if (arrayOfString != null) {
        break label143;
      }
      arrayOfString = new String[1];
      arrayOfString[0] = com.tencent.mm.plugin.fav.a.b.a(paramarf);
      this.AiT.put(str, arrayOfString);
    }
    label143:
    for (;;)
    {
      this.AiR.a(paramImageView, arrayOfString, paramString, paramInt1, paramInt2, paramInt3);
      if ((arrayOfString == null) || (arrayOfString.length <= 0))
      {
        AppMethodBeat.o(274410);
        return null;
      }
      paramImageView = arrayOfString[0];
      com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106960);
          if (FavoriteImageServer.auA(paramImageView)) {
            com.tencent.mm.plugin.fav.a.b.a(paramg, paramarf);
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
      AppMethodBeat.o(274410);
      return paramImageView;
    }
  }
  
  public final void a(ImageView paramImageView, arf paramarf, g paramg, int paramInt1, int paramInt2, int paramInt3)
  {
    String str = null;
    AppMethodBeat.i(106979);
    if (paramImageView == null)
    {
      AppMethodBeat.o(106979);
      return;
    }
    if (!com.tencent.mm.compatible.util.e.aPU())
    {
      paramImageView.setImageResource(q.d.nosdcard_chatting_bg);
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
      if (paramarf != null)
      {
        paramImageView = a(paramImageView, paramarf, paramg, paramarf.hDd, paramInt1, paramInt2, paramInt3);
        if ((paramarf.Zzy != null) && (paramarf.Zzy.ZAJ != null)) {
          paramarf.Zzy.ZAJ.oPc = paramImageView;
        }
        AppMethodBeat.o(106979);
        return;
      }
      break;
    case 4: 
    case 16: 
      if (paramarf != null)
      {
        a(paramImageView, paramarf, paramg, paramarf.hDd, paramInt1, paramInt2, paramInt3);
        AppMethodBeat.o(106979);
        return;
      }
      break;
    case 5: 
      bool = c(paramg.field_favProto.WKx);
      Log.v("MicroMsg.FavoriteImageServer", "alvinluo attachThumb isBizNativeVideo: %b", new Object[] { Boolean.valueOf(bool) });
      localObject = paramg.field_favProto.ZAj;
      if (paramarf == null)
      {
        if (localObject != null)
        {
          paramg = this.AiR;
          if (!bool) {
            break label345;
          }
        }
        label345:
        for (paramarf = com.tencent.mm.api.b.U(((ask)localObject).thumbUrl, 4);; paramarf = ((ask)localObject).thumbUrl)
        {
          paramg.a(paramImageView, null, paramarf, paramInt1, paramInt2, paramInt3);
          AppMethodBeat.o(106979);
          return;
        }
      }
      if (localObject == null)
      {
        if (!Util.isNullOrNil(str)) {
          break label544;
        }
        str = paramarf.hDd;
      }
      break;
    }
    label544:
    for (;;)
    {
      localObject = str;
      if (bool) {
        localObject = com.tencent.mm.api.b.U(str, 4);
      }
      a(paramImageView, paramarf, paramg, (String)localObject, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(106979);
      return;
      str = ((ask)localObject).thumbUrl;
      break;
      paramarf = paramg.field_favProto.ZAl;
      if (paramarf != null)
      {
        this.AiR.a(paramImageView, null, paramarf.thumbUrl, paramInt1, paramInt2, paramInt3);
        AppMethodBeat.o(106979);
        return;
        paramarf = paramg.field_favProto.ZAn;
        if (paramarf != null)
        {
          this.AiR.a(paramImageView, null, paramarf.thumbUrl, paramInt1, paramInt2, paramInt3);
          AppMethodBeat.o(106979);
          return;
          paramarf = paramg.field_favProto.ZAl;
          if (paramarf != null)
          {
            this.AiR.a(paramImageView, null, paramarf.thumbUrl, paramInt1, paramInt2, paramInt3);
            AppMethodBeat.o(106979);
            return;
          }
        }
      }
      AppMethodBeat.o(106979);
      return;
    }
  }
  
  public final void b(ImageView paramImageView, arf paramarf, g paramg, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(106980);
    if (paramImageView == null)
    {
      AppMethodBeat.o(106980);
      return;
    }
    if (!com.tencent.mm.compatible.util.e.aPU())
    {
      paramImageView.setImageResource(q.d.nosdcard_chatting_bg);
      AppMethodBeat.o(106980);
      return;
    }
    if ((paramg == null) || (paramarf == null))
    {
      paramImageView.setImageDrawable(a.m(this.context, paramInt1));
      AppMethodBeat.o(106980);
      return;
    }
    Object localObject1;
    boolean bool;
    switch (paramarf.dataType)
    {
    default: 
      Log.w("MicroMsg.FavoriteImageServer", "attach thumb, pass type is %d", new Object[] { Integer.valueOf(paramg.field_type) });
      AppMethodBeat.o(106980);
      return;
    case 7: 
    case 29: 
      a(paramImageView, paramarf, paramg, paramarf.hDd, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(106980);
      return;
    case 4: 
    case 15: 
      a(paramImageView, paramarf, paramg, paramarf.hDd, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(106980);
      return;
    case 5: 
      localObject1 = null;
      if (paramarf.Zzy != null)
      {
        localObject1 = paramarf.Zzy.ZAj;
        bool = c(paramarf.Zzy.WKx);
        if (localObject1 != null) {
          break label377;
        }
        localObject1 = null;
        label278:
        if (!Util.isNullOrNil((String)localObject1)) {
          break label891;
        }
        localObject1 = paramarf.hDd;
      }
      break;
    }
    label377:
    label891:
    for (;;)
    {
      Object localObject2 = localObject1;
      if (bool) {
        localObject2 = com.tencent.mm.api.b.U((String)localObject1, 4);
      }
      a(paramImageView, paramarf, paramg, (String)localObject2, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(106980);
      return;
      Log.w("MicroMsg.FavoriteImageServer", "webpage: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[] { paramarf.hIQ, Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
      bool = false;
      break;
      localObject1 = ((ask)localObject1).thumbUrl;
      break label278;
      if ((paramarf.Zzy != null) && (paramarf.Zzy.ZAB != null) && (!Util.isNullOrNil(paramarf.Zzy.ZAB.mediaList)) && (!Util.isNullOrNil(((bvj)paramarf.Zzy.ZAB.mediaList.getFirst()).thumbUrl)))
      {
        this.AiR.a(paramImageView, null, ((bvj)paramarf.Zzy.ZAB.mediaList.getFirst()).thumbUrl, paramInt1, paramInt2, paramInt3);
        AppMethodBeat.o(106980);
        return;
      }
      paramImageView.setImageDrawable(bb.m(paramImageView.getContext(), q.h.icons_outlined_finder_icon, paramImageView.getContext().getResources().getColor(q.b.Orange)));
      AppMethodBeat.o(106980);
      return;
      if (paramarf.Zzy == null)
      {
        Log.w("MicroMsg.FavoriteImageServer", "good: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[] { paramarf.hIQ, Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
        AppMethodBeat.o(106980);
        return;
      }
      paramarf = paramarf.Zzy.ZAl;
      if (paramarf != null)
      {
        this.AiR.a(paramImageView, null, paramarf.thumbUrl, paramInt1, paramInt2, paramInt3);
        AppMethodBeat.o(106980);
        return;
        if (paramarf.Zzy == null)
        {
          Log.w("MicroMsg.FavoriteImageServer", "tv: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[] { paramarf.hIQ, Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
          AppMethodBeat.o(106980);
          return;
        }
        paramarf = paramarf.Zzy.ZAn;
        if (paramarf != null)
        {
          this.AiR.a(paramImageView, null, paramarf.thumbUrl, paramInt1, paramInt2, paramInt3);
          AppMethodBeat.o(106980);
          return;
          if (paramarf.Zzy == null)
          {
            Log.w("MicroMsg.FavoriteImageServer", "product: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[] { paramarf.hIQ, Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
            AppMethodBeat.o(106980);
            return;
          }
          paramarf = paramarf.Zzy.ZAl;
          if (paramarf != null)
          {
            this.AiR.a(paramImageView, null, paramarf.thumbUrl, paramInt1, paramInt2, paramInt3);
            AppMethodBeat.o(106980);
            return;
            if (paramarf.Zzy == null)
            {
              Log.w("MicroMsg.FavoriteImageServer", "app brand: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[] { paramarf.hIQ, Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
              AppMethodBeat.o(106980);
              return;
            }
            paramarf = paramarf.Zzy.ZAw;
            if (paramarf != null)
            {
              this.AiR.a(paramImageView, null, paramarf.iconUrl, paramInt1, paramInt2, paramInt3);
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
  
  public final void c(final ImageView paramImageView, final arf paramarf, final g paramg, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(274417);
    if (paramImageView == null)
    {
      AppMethodBeat.o(274417);
      return;
    }
    if (!com.tencent.mm.compatible.util.e.aPU())
    {
      paramImageView.setImageResource(q.d.nosdcard_chatting_bg);
      AppMethodBeat.o(274417);
      return;
    }
    if ((paramarf == null) || (paramg == null))
    {
      AppMethodBeat.o(274417);
      return;
    }
    String str = paramarf.hIQ;
    if (str == null)
    {
      AppMethodBeat.o(274417);
      return;
    }
    final Object localObject1 = null;
    Object localObject3 = null;
    if (paramarf.hIQ != null)
    {
      Object localObject2 = localObject3;
      if (this.AiS != null)
      {
        localObject2 = localObject3;
        if (!this.AiS.isEmpty()) {
          localObject2 = (String[])this.AiS.get(str);
        }
      }
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = new String[2];
        localObject2[0] = com.tencent.mm.plugin.fav.a.b.d(paramarf);
        localObject2[1] = com.tencent.mm.plugin.fav.a.b.a(paramarf);
        localObject1 = localObject2;
        if (this.AiS != null)
        {
          this.AiS.put(str, localObject2);
          localObject1 = localObject2;
        }
      }
    }
    this.AiR.a(paramImageView, localObject1, null, paramInt1, paramInt2, paramInt3);
    if ((localObject1 == null) || (localObject1.length <= 0))
    {
      AppMethodBeat.o(274417);
      return;
    }
    paramImageView = localObject1[0];
    localObject1 = localObject1[1];
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106962);
        if (FavoriteImageServer.auA(paramImageView))
        {
          Log.i("MicroMsg.FavoriteImageServer", "attachVideoImg, needRestartCdnDownload, videoPath:%s", new Object[] { y.n(paramImageView, false) });
          com.tencent.mm.plugin.fav.a.b.a(paramg, paramarf, false);
        }
        if (FavoriteImageServer.auB(localObject1))
        {
          Log.i("MicroMsg.FavoriteImageServer", "attachVideoImg, restartCdnThumbDownLoad, thumbPath:%s", new Object[] { y.n(localObject1, false) });
          com.tencent.mm.plugin.fav.a.b.a(paramg, paramarf);
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
    AppMethodBeat.o(274417);
  }
  
  public final void d(final ImageView paramImageView, final arf paramarf, final g paramg, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(274419);
    if (paramImageView == null)
    {
      AppMethodBeat.o(274419);
      return;
    }
    if (!com.tencent.mm.compatible.util.e.aPU())
    {
      paramImageView.setImageResource(q.d.nosdcard_chatting_bg);
      AppMethodBeat.o(274419);
      return;
    }
    if ((paramarf == null) || (paramg == null))
    {
      AppMethodBeat.o(274419);
      return;
    }
    String str = paramarf.hIQ;
    if (str == null)
    {
      AppMethodBeat.o(274419);
      return;
    }
    String[] arrayOfString2;
    if (paramarf.hIQ != null) {
      if ((this.AiS != null) && (!this.AiS.isEmpty()))
      {
        arrayOfString2 = (String[])this.AiS.get(str);
        arrayOfString1 = arrayOfString2;
        if (arrayOfString2 == null)
        {
          arrayOfString2 = new String[2];
          arrayOfString2[0] = com.tencent.mm.plugin.fav.a.b.d(paramarf);
          arrayOfString2[1] = com.tencent.mm.plugin.fav.a.b.a(paramarf);
          arrayOfString1 = arrayOfString2;
          if (this.AiS != null) {
            this.AiS.put(str, arrayOfString2);
          }
        }
      }
    }
    for (String[] arrayOfString1 = arrayOfString2;; arrayOfString1 = null)
    {
      this.AiR.a(paramImageView, arrayOfString1, null, paramInt1, paramInt2, paramInt3);
      if ((arrayOfString1 == null) || (arrayOfString1.length <= 0))
      {
        AppMethodBeat.o(274419);
        return;
      }
      paramImageView = arrayOfString1[0];
      com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106964);
          if (FavoriteImageServer.auA(paramImageView))
          {
            Log.i("MicroMsg.FavoriteImageServer", "attachImg, restartCdnDataDownload, checkPath:%s", new Object[] { y.n(paramImageView, false) });
            com.tencent.mm.plugin.fav.a.b.a(paramg, paramarf, false);
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
      AppMethodBeat.o(274419);
      return;
      arrayOfString2 = null;
      break;
    }
  }
  
  public final void destory()
  {
    AppMethodBeat.i(106976);
    Log.i("MicroMsg.FavoriteImageServer", "destory");
    dRY();
    this.AiS.clear();
    this.AiT.clear();
    this.AiR.destroy();
    this.context = null;
    this.AiS = null;
    this.AiT = null;
    this.AiR = null;
    AppMethodBeat.o(106976);
  }
  
  static class MMTrimMemoryEventListener
    extends IListener<oc>
  {
    private final WeakReference<FavoriteImageServer> nph;
    
    public MMTrimMemoryEventListener(FavoriteImageServer paramFavoriteImageServer)
    {
      super();
      AppMethodBeat.i(274374);
      this.nph = new WeakReference(paramFavoriteImageServer);
      this.__eventId = oc.class.getName().hashCode();
      AppMethodBeat.o(274374);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavoriteImageServer
 * JD-Core Version:    0.7.0.1
 */