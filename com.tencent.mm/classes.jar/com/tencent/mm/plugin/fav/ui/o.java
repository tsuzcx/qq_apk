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
import com.tencent.mm.b.q;
import com.tencent.mm.cc.a;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.protocal.protobuf.agv;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.protocal.protobuf.ahf;
import com.tencent.mm.protocal.protobuf.ahm;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.ahw;
import com.tencent.mm.protocal.protobuf.aic;
import com.tencent.mm.protocal.protobuf.anw;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.am;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class o
{
  private static Map<String, f.a> qOs;
  private static com.tencent.mm.b.f<String, Bitmap> qOt;
  private static com.tencent.mm.b.f<String, Bitmap> qOu;
  public Context context;
  public h qOp;
  public HashMap<String, String[]> qOq;
  private HashMap<String, String[]> qOr;
  
  static
  {
    AppMethodBeat.i(106992);
    qOs = new HashMap();
    qOt = new com.tencent.mm.memory.a.b(10, o.class);
    qOu = new com.tencent.mm.memory.a.b(20, o.class);
    AppMethodBeat.o(106992);
  }
  
  public o(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(106974);
    this.qOq = new HashMap();
    this.qOr = new HashMap();
    this.context = paramContext;
    int i = paramInt;
    if (paramInt <= 0) {
      i = 24;
    }
    this.qOp = new h(i);
    AppMethodBeat.o(106974);
  }
  
  public static Bitmap a(final agx paramagx, final com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(106985);
    if (!com.tencent.mm.compatible.util.e.YD())
    {
      paramagx = BitmapFactory.decodeResource(ai.getContext().getResources(), 2131233476);
      AppMethodBeat.o(106985);
      return paramagx;
    }
    if (com.tencent.mm.plugin.fav.a.b.aco(paramagx.dhw) == null)
    {
      AppMethodBeat.o(106985);
      return null;
    }
    Bitmap localBitmap = a(paramagx, true, false);
    if (localBitmap == null)
    {
      String str = com.tencent.mm.plugin.fav.a.b.a(paramagx);
      com.tencent.mm.kernel.g.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106968);
          if (o.eu(this.iaZ)) {
            com.tencent.mm.plugin.fav.a.b.a(paramg, paramagx);
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
  
  public static Bitmap a(final agx paramagx, final com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(106984);
    if (!com.tencent.mm.compatible.util.e.YD())
    {
      paramagx = BitmapFactory.decodeResource(ai.getContext().getResources(), 2131233476);
      AppMethodBeat.o(106984);
      return paramagx;
    }
    if (paramagx.dhw == null)
    {
      AppMethodBeat.o(106984);
      return null;
    }
    Bitmap localBitmap = a(paramagx, false, false);
    if (localBitmap == null)
    {
      final String str = com.tencent.mm.plugin.fav.a.b.d(paramagx);
      com.tencent.mm.kernel.g.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106966);
          if ((this.qOw) || (o.eu(str))) {
            com.tencent.mm.plugin.fav.a.b.a(paramg, paramagx, this.qOw);
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
  
  private static Bitmap a(agx paramagx, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(106981);
    if (paramBoolean1) {}
    for (paramagx = com.tencent.mm.plugin.fav.a.b.a(paramagx); !com.tencent.mm.vfs.i.eA(paramagx); paramagx = com.tencent.mm.plugin.fav.a.b.d(paramagx))
    {
      ac.w("MicroMsg.FavoriteImageLogic", "getBitmap file not exist");
      AppMethodBeat.o(106981);
      return null;
    }
    paramagx = e.aX(paramagx, paramBoolean2);
    AppMethodBeat.o(106981);
    return paramagx;
  }
  
  public static void a(final ImageView paramImageView, int paramInt1, final agx paramagx, final com.tencent.mm.plugin.fav.a.g paramg, final boolean paramBoolean, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(209483);
    if (!com.tencent.mm.compatible.util.e.YD()) {
      paramImageView.setImageBitmap(BitmapFactory.decodeResource(ai.getContext().getResources(), 2131233476));
    }
    if (paramagx.dhw == null) {
      paramImageView.setImageResource(paramInt1);
    }
    Bitmap localBitmap = a(paramagx, paramg);
    String str = com.tencent.mm.plugin.fav.a.b.d(paramagx);
    if (com.tencent.mm.vfs.i.eA(str)) {
      localBitmap = d(str, paramInt2, paramInt3, true);
    }
    if (localBitmap == null)
    {
      paramImageView.setImageResource(paramInt1);
      paramImageView.setTag(str);
      com.tencent.mm.kernel.g.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106971);
          final Bitmap localBitmap = o.d(this.val$path, paramInt2, paramInt3, false);
          if (localBitmap == null)
          {
            o.c(paramg, paramagx, paramBoolean);
            AppMethodBeat.o(106971);
            return;
          }
          String str = (String)paramImageView.getTag();
          if ((str != null) && (str.equals(this.val$path)))
          {
            com.tencent.mm.kernel.g.agU();
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(106970);
                o.6.this.pBf.setImageBitmap(localBitmap);
                AppMethodBeat.o(106970);
              }
            });
          }
          AppMethodBeat.o(106971);
        }
      });
      AppMethodBeat.o(209483);
      return;
    }
    paramImageView.setImageBitmap(localBitmap);
    AppMethodBeat.o(209483);
  }
  
  public static Bitmap b(final agx paramagx, final com.tencent.mm.plugin.fav.a.g paramg, int paramInt)
  {
    AppMethodBeat.i(106982);
    if (!com.tencent.mm.compatible.util.e.YD())
    {
      paramagx = BitmapFactory.decodeResource(ai.getContext().getResources(), 2131233476);
      AppMethodBeat.o(106982);
      return paramagx;
    }
    if (paramagx.dhw == null)
    {
      AppMethodBeat.o(106982);
      return null;
    }
    String str = com.tencent.mm.plugin.fav.a.b.d(paramagx);
    if (!com.tencent.mm.vfs.i.eA(str))
    {
      ac.w("MicroMsg.FavoriteImageLogic", "getBitmap file not exist");
      localObject = null;
    }
    for (;;)
    {
      if (localObject == null)
      {
        str = com.tencent.mm.plugin.fav.a.b.d(paramagx);
        com.tencent.mm.kernel.g.agU().az(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(106964);
            if ((this.qOw) || (o.eu(this.iaZ))) {
              com.tencent.mm.plugin.fav.a.b.a(paramg, paramagx, this.qOw);
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
      localObject = (Bitmap)qOt.get(str);
      if (localObject == null) {
        break;
      }
      ac.d("MicroMsg.FavoriteImageLogic", "get bm from cache %s", new Object[] { str });
    }
    ac.d("MicroMsg.FavoriteImageLogic", "get from cache fail, try to decode from file");
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    Bitmap localBitmap = MMBitmapFactory.decodeFile(str, (BitmapFactory.Options)localObject);
    if (localBitmap != null)
    {
      ac.i("MicroMsg.FavoriteImageLogic", "bitmap recycle %s", new Object[] { localBitmap });
      localBitmap.recycle();
    }
    int j = ((BitmapFactory.Options)localObject).outWidth;
    int i = ((BitmapFactory.Options)localObject).outHeight;
    ac.d("MicroMsg.FavoriteImageLogic", "width: %s, height: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
    if (j > paramInt) {
      i = ((BitmapFactory.Options)localObject).outHeight * paramInt / ((BitmapFactory.Options)localObject).outWidth;
    }
    for (;;)
    {
      paramInt = Math.max(1, paramInt);
      i = Math.max(1, i);
      ac.w("MicroMsg.FavoriteImageLogic", "fit long picture, beg %d*%d, after %d*%d", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject).outHeight), Integer.valueOf(paramInt), Integer.valueOf(i) });
      int k = BackwardSupportUtil.ExifHelper.ce(str);
      if ((k == 90) || (k == 270)) {}
      for (;;)
      {
        localObject = com.tencent.mm.sdk.platformtools.f.e(str, paramInt, i, false);
        if (localObject == null)
        {
          ac.e("MicroMsg.FavoriteImageLogic", "getSuitableBmp fail, temBmp is null, filePath = ".concat(String.valueOf(str)));
          localObject = null;
          break;
        }
        localObject = com.tencent.mm.sdk.platformtools.f.a((Bitmap)localObject, k);
        qOt.put(str, localObject);
        break;
        j = paramInt;
        paramInt = i;
        i = j;
      }
      paramInt = j;
    }
  }
  
  public static void b(com.tencent.mm.plugin.fav.a.g paramg, agx paramagx)
  {
    AppMethodBeat.i(106989);
    b(paramg, paramagx, true);
    AppMethodBeat.o(106989);
  }
  
  private static void b(final com.tencent.mm.plugin.fav.a.g paramg, final agx paramagx, boolean paramBoolean)
  {
    AppMethodBeat.i(106988);
    final String str = com.tencent.mm.plugin.fav.a.b.d(paramagx);
    com.tencent.mm.kernel.g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106972);
        if ((this.qOw) || (o.eu(str))) {
          com.tencent.mm.plugin.fav.a.b.a(paramg, paramagx, this.qOw);
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
  
  private static boolean c(ahf paramahf)
  {
    AppMethodBeat.i(106978);
    if ((paramahf != null) && (paramahf.hgY == 5) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bIP()))
    {
      AppMethodBeat.o(106978);
      return true;
    }
    AppMethodBeat.o(106978);
    return false;
  }
  
  private void cqN()
  {
    AppMethodBeat.i(106975);
    h localh = this.qOp;
    synchronized (localh.lock)
    {
      ac.d("MicroMsg.ImageEngine", "do clear mark");
      localh.DER.clear();
      localh.DES.clear();
      localh.DER = new HashMap();
      localh.DES = new HashMap();
      AppMethodBeat.o(106975);
      return;
    }
  }
  
  public static Bitmap d(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(106986);
    boolean bool = false;
    if (!com.tencent.mm.vfs.i.eA(paramString))
    {
      ac.w("MicroMsg.FavoriteImageLogic", "file not exist");
      AppMethodBeat.o(106986);
      return null;
    }
    Bitmap localBitmap = (Bitmap)qOu.get(paramString);
    if ((localBitmap != null) || (paramBoolean))
    {
      if (localBitmap != null) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        ac.d("MicroMsg.FavoriteImageLogic", "return bm path %s, bm %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
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
        com.tencent.mm.sdk.platformtools.f.decodeFile(paramString, localOptions);
        localObject = localBitmap;
        i = localOptions.outWidth;
        localObject = localBitmap;
        j = localOptions.outHeight;
        localObject = localBitmap;
        m = BackwardSupportUtil.ExifHelper.ce(paramString);
        if (m == 90) {
          break label625;
        }
        if (m != 270) {
          break label607;
        }
      }
      catch (IOException paramString)
      {
        ac.e("MicroMsg.FavoriteImageLogic", paramString.getMessage());
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
      ac.d("MicroMsg.FavoriteImageLogic", "decode top region width: %d, height: %d, scaleheight: %d, rotate: %b", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k), Boolean.valueOf(paramBoolean) });
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
            paramString = com.tencent.mm.sdk.platformtools.f.a(localBitmap, m);
          }
        }
        if (paramString == null) {
          break label593;
        }
        localObject = paramString;
        ac.d("MicroMsg.FavoriteImageLogic", "width %d, height %d, tw %d, th %d", new Object[] { Integer.valueOf(paramString.getWidth()), Integer.valueOf(paramString.getHeight()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        localObject = paramString;
        qOu.put(str, paramString);
        break;
        localObject = localBitmap;
        localRect.right = j;
        localObject = localBitmap;
        localRect.bottom = k;
        break label395;
        localObject = localBitmap;
        localOptions.inJustDecodeBounds = false;
        localObject = localBitmap;
        localBitmap = com.tencent.mm.sdk.platformtools.f.decodeFile(paramString, localOptions);
        str = paramString;
      }
      label593:
      localObject = paramString;
      ac.w("MicroMsg.FavoriteImageLogic", "decode bm fail!");
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
  
  public static Bitmap l(agx paramagx)
  {
    AppMethodBeat.i(106983);
    if (!com.tencent.mm.compatible.util.e.YD())
    {
      paramagx = BitmapFactory.decodeResource(ai.getContext().getResources(), 2131233476);
      AppMethodBeat.o(106983);
      return paramagx;
    }
    if (paramagx.dhw == null)
    {
      AppMethodBeat.o(106983);
      return null;
    }
    paramagx = a(paramagx, false, true);
    AppMethodBeat.o(106983);
    return paramagx;
  }
  
  public final void a(ImageView paramImageView, agx paramagx, com.tencent.mm.plugin.fav.a.g paramg, int paramInt1, int paramInt2, int paramInt3)
  {
    String str = null;
    AppMethodBeat.i(106979);
    if (paramImageView == null)
    {
      AppMethodBeat.o(106979);
      return;
    }
    if (!com.tencent.mm.compatible.util.e.YD())
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
      ac.w("MicroMsg.FavoriteImageLogic", "attach thumb, pass type is %d", new Object[] { Integer.valueOf(paramg.field_type) });
      AppMethodBeat.o(106979);
      return;
    case 7: 
      if (paramagx != null)
      {
        a(paramImageView, paramagx, paramg, paramagx.dbZ, paramInt1, paramInt2, paramInt3);
        AppMethodBeat.o(106979);
        return;
      }
      break;
    case 4: 
    case 16: 
      if (paramagx != null)
      {
        a(paramImageView, paramagx, paramg, paramagx.dbZ, paramInt1, paramInt2, paramInt3);
        AppMethodBeat.o(106979);
        return;
      }
      break;
    case 5: 
      bool = c(paramg.field_favProto.CoY);
      ac.v("MicroMsg.FavoriteImageLogic", "alvinluo attachThumb isBizNativeVideo: %b", new Object[] { Boolean.valueOf(bool) });
      localObject = paramg.field_favProto.EAK;
      if (paramagx == null)
      {
        if (localObject != null)
        {
          paramg = this.qOp;
          if (!bool) {
            break label295;
          }
        }
        label295:
        for (paramagx = com.tencent.mm.api.b.q(((aic)localObject).thumbUrl, 4);; paramagx = ((aic)localObject).thumbUrl)
        {
          paramg.a(paramImageView, null, paramagx, paramInt1, paramInt2, paramInt3);
          AppMethodBeat.o(106979);
          return;
        }
      }
      if (localObject == null)
      {
        if (!bs.isNullOrNil(str)) {
          break label493;
        }
        str = paramagx.dbZ;
      }
      break;
    }
    label493:
    for (;;)
    {
      localObject = str;
      if (bool) {
        localObject = com.tencent.mm.api.b.q(str, 4);
      }
      a(paramImageView, paramagx, paramg, (String)localObject, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(106979);
      return;
      str = ((aic)localObject).thumbUrl;
      break;
      paramagx = paramg.field_favProto.EAM;
      if (paramagx != null)
      {
        this.qOp.a(paramImageView, null, paramagx.thumbUrl, paramInt1, paramInt2, paramInt3);
        AppMethodBeat.o(106979);
        return;
        paramagx = paramg.field_favProto.EAO;
        if (paramagx != null)
        {
          this.qOp.a(paramImageView, null, paramagx.thumbUrl, paramInt1, paramInt2, paramInt3);
          AppMethodBeat.o(106979);
          return;
          paramagx = paramg.field_favProto.EAM;
          if (paramagx != null)
          {
            this.qOp.a(paramImageView, null, paramagx.thumbUrl, paramInt1, paramInt2, paramInt3);
            AppMethodBeat.o(106979);
            return;
          }
        }
      }
      AppMethodBeat.o(106979);
      return;
    }
  }
  
  public final void a(final ImageView paramImageView, final agx paramagx, final com.tencent.mm.plugin.fav.a.g paramg, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(106977);
    String str = com.tencent.mm.plugin.fav.a.b.aco(paramagx.dhw);
    String[] arrayOfString = null;
    if (paramagx.dhw != null)
    {
      arrayOfString = (String[])this.qOr.get(str);
      if (arrayOfString != null) {
        break label136;
      }
      arrayOfString = new String[1];
      arrayOfString[0] = com.tencent.mm.plugin.fav.a.b.a(paramagx);
      this.qOr.put(str, arrayOfString);
    }
    label136:
    for (;;)
    {
      this.qOp.a(paramImageView, arrayOfString, paramString, paramInt1, paramInt2, paramInt3);
      if ((arrayOfString == null) || (arrayOfString.length <= 0))
      {
        AppMethodBeat.o(106977);
        return;
      }
      paramImageView = arrayOfString[0];
      com.tencent.mm.kernel.g.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106960);
          if (o.eu(paramImageView)) {
            com.tencent.mm.plugin.fav.a.b.a(paramg, paramagx);
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
  
  public final void b(ImageView paramImageView, agx paramagx, com.tencent.mm.plugin.fav.a.g paramg, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(106980);
    if (paramImageView == null)
    {
      AppMethodBeat.o(106980);
      return;
    }
    if (!com.tencent.mm.compatible.util.e.YD())
    {
      paramImageView.setImageResource(2131233476);
      AppMethodBeat.o(106980);
      return;
    }
    if ((paramg == null) || (paramagx == null))
    {
      paramImageView.setImageDrawable(a.l(this.context, paramInt1));
      AppMethodBeat.o(106980);
      return;
    }
    Object localObject1;
    boolean bool;
    switch (paramagx.dataType)
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
      ac.w("MicroMsg.FavoriteImageLogic", "attach thumb, pass type is %d", new Object[] { Integer.valueOf(paramg.field_type) });
      AppMethodBeat.o(106980);
      return;
    case 7: 
      a(paramImageView, paramagx, paramg, paramagx.dbZ, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(106980);
      return;
    case 4: 
    case 15: 
      a(paramImageView, paramagx, paramg, paramagx.dbZ, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(106980);
      return;
    case 5: 
      localObject1 = null;
      if (paramagx.EzZ != null)
      {
        localObject1 = paramagx.EzZ.EAK;
        bool = c(paramagx.EzZ.CoY);
        if (localObject1 != null) {
          break label374;
        }
        localObject1 = null;
        label276:
        if (!bs.isNullOrNil((String)localObject1)) {
          break label888;
        }
        localObject1 = paramagx.dbZ;
      }
      break;
    }
    label374:
    label888:
    for (;;)
    {
      Object localObject2 = localObject1;
      if (bool) {
        localObject2 = com.tencent.mm.api.b.q((String)localObject1, 4);
      }
      a(paramImageView, paramagx, paramg, (String)localObject2, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(106980);
      return;
      ac.w("MicroMsg.FavoriteImageLogic", "webpage: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[] { paramagx.dhw, Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
      bool = false;
      break;
      localObject1 = ((aic)localObject1).thumbUrl;
      break label276;
      if ((paramagx.EzZ != null) && (paramagx.EzZ.EBc != null) && (!bs.gY(paramagx.EzZ.EBc.mediaList)) && (!bs.isNullOrNil(((anw)paramagx.EzZ.EBc.mediaList.getFirst()).thumbUrl)))
      {
        this.qOp.a(paramImageView, null, ((anw)paramagx.EzZ.EBc.mediaList.getFirst()).thumbUrl, paramInt1, paramInt2, paramInt3);
        AppMethodBeat.o(106980);
        return;
      }
      paramImageView.setImageDrawable(am.k(paramImageView.getContext(), 2131690572, paramImageView.getContext().getResources().getColor(2131099777)));
      AppMethodBeat.o(106980);
      return;
      if (paramagx.EzZ == null)
      {
        ac.w("MicroMsg.FavoriteImageLogic", "good: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[] { paramagx.dhw, Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
        AppMethodBeat.o(106980);
        return;
      }
      paramagx = paramagx.EzZ.EAM;
      if (paramagx != null)
      {
        this.qOp.a(paramImageView, null, paramagx.thumbUrl, paramInt1, paramInt2, paramInt3);
        AppMethodBeat.o(106980);
        return;
        if (paramagx.EzZ == null)
        {
          ac.w("MicroMsg.FavoriteImageLogic", "tv: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[] { paramagx.dhw, Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
          AppMethodBeat.o(106980);
          return;
        }
        paramagx = paramagx.EzZ.EAO;
        if (paramagx != null)
        {
          this.qOp.a(paramImageView, null, paramagx.thumbUrl, paramInt1, paramInt2, paramInt3);
          AppMethodBeat.o(106980);
          return;
          if (paramagx.EzZ == null)
          {
            ac.w("MicroMsg.FavoriteImageLogic", "product: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[] { paramagx.dhw, Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
            AppMethodBeat.o(106980);
            return;
          }
          paramagx = paramagx.EzZ.EAM;
          if (paramagx != null)
          {
            this.qOp.a(paramImageView, null, paramagx.thumbUrl, paramInt1, paramInt2, paramInt3);
            AppMethodBeat.o(106980);
            return;
            if (paramagx.EzZ == null)
            {
              ac.w("MicroMsg.FavoriteImageLogic", "app brand: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[] { paramagx.dhw, Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
              AppMethodBeat.o(106980);
              return;
            }
            paramagx = paramagx.EzZ.EAX;
            if (paramagx != null)
            {
              this.qOp.a(paramImageView, null, paramagx.iconUrl, paramInt1, paramInt2, paramInt3);
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
    cqN();
    this.qOq.clear();
    this.qOr.clear();
    this.qOp.destroy();
    this.context = null;
    this.qOq = null;
    this.qOr = null;
    this.qOp = null;
    AppMethodBeat.o(106976);
  }
  
  public final Context getContext()
  {
    return this.context;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.o
 * JD-Core Version:    0.7.0.1
 */