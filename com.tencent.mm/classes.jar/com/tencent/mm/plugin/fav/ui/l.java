package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.protocal.protobuf.aby;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acb;
import com.tencent.mm.protocal.protobuf.acp;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acz;
import com.tencent.mm.protocal.protobuf.adf;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class l
{
  private static Map<String, g.a> myx;
  private static com.tencent.mm.a.f<String, Bitmap> myy;
  private static com.tencent.mm.a.f<String, Bitmap> myz;
  public Context context;
  public e myu;
  public HashMap<String, String[]> myv;
  private HashMap<String, String[]> myw;
  
  static
  {
    AppMethodBeat.i(74218);
    myx = new HashMap();
    myy = new com.tencent.mm.memory.a.b(10, l.class);
    myz = new com.tencent.mm.memory.a.b(20, l.class);
    AppMethodBeat.o(74218);
  }
  
  public l(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(74201);
    this.myv = new HashMap();
    this.myw = new HashMap();
    this.context = paramContext;
    int i = paramInt;
    if (paramInt <= 0) {
      i = 24;
    }
    this.myu = new e(i);
    AppMethodBeat.o(74201);
  }
  
  public static Bitmap a(aca paramaca, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(74211);
    if (!com.tencent.mm.compatible.util.f.Mi())
    {
      paramaca = BitmapFactory.decodeResource(ah.getContext().getResources(), 2130839821);
      AppMethodBeat.o(74211);
      return paramaca;
    }
    if (com.tencent.mm.plugin.fav.a.b.Ny(paramaca.mBq) == null)
    {
      AppMethodBeat.o(74211);
      return null;
    }
    Bitmap localBitmap = a(paramaca, true, false);
    if (localBitmap == null)
    {
      String str = com.tencent.mm.plugin.fav.a.b.c(paramaca);
      com.tencent.mm.kernel.g.RO().ac(new l.5(str, paramg, paramaca));
    }
    AppMethodBeat.o(74211);
    return localBitmap;
  }
  
  public static Bitmap a(aca paramaca, com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(74210);
    if (!com.tencent.mm.compatible.util.f.Mi())
    {
      paramaca = BitmapFactory.decodeResource(ah.getContext().getResources(), 2130839821);
      AppMethodBeat.o(74210);
      return paramaca;
    }
    if (paramaca.mBq == null)
    {
      AppMethodBeat.o(74210);
      return null;
    }
    Bitmap localBitmap = a(paramaca, false, false);
    if (localBitmap == null)
    {
      String str = com.tencent.mm.plugin.fav.a.b.b(paramaca);
      com.tencent.mm.kernel.g.RO().ac(new l.4(paramBoolean, str, paramg, paramaca));
    }
    AppMethodBeat.o(74210);
    return localBitmap;
  }
  
  private static Bitmap a(aca paramaca, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(74207);
    if (paramBoolean1) {}
    for (paramaca = com.tencent.mm.plugin.fav.a.b.c(paramaca); !com.tencent.mm.vfs.e.cN(paramaca); paramaca = com.tencent.mm.plugin.fav.a.b.b(paramaca))
    {
      ab.w("MicroMsg.FavoriteImageLogic", "getBitmap file not exist");
      AppMethodBeat.o(74207);
      return null;
    }
    paramaca = c.aO(paramaca, paramBoolean2);
    AppMethodBeat.o(74207);
    return paramaca;
  }
  
  public static void a(ImageView paramImageView, aca paramaca, com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(74213);
    if (!com.tencent.mm.compatible.util.f.Mi()) {
      paramImageView.setImageBitmap(BitmapFactory.decodeResource(ah.getContext().getResources(), 2130839821));
    }
    if (paramaca.mBq == null) {
      paramImageView.setImageResource(2131231298);
    }
    Bitmap localBitmap = a(paramaca, paramg);
    String str = com.tencent.mm.plugin.fav.a.b.b(paramaca);
    if (com.tencent.mm.vfs.e.cN(str)) {
      localBitmap = b(str, paramInt1, paramInt2, true);
    }
    if (localBitmap == null)
    {
      paramImageView.setImageResource(2131231298);
      paramImageView.setTag(str);
      com.tencent.mm.kernel.g.RO().ac(new l.6(str, paramInt1, paramInt2, paramg, paramaca, paramBoolean, paramImageView));
      AppMethodBeat.o(74213);
      return;
    }
    paramImageView.setImageBitmap(localBitmap);
    AppMethodBeat.o(74213);
  }
  
  public static Bitmap b(aca paramaca, com.tencent.mm.plugin.fav.a.g paramg, int paramInt)
  {
    AppMethodBeat.i(74208);
    if (!com.tencent.mm.compatible.util.f.Mi())
    {
      paramaca = BitmapFactory.decodeResource(ah.getContext().getResources(), 2130839821);
      AppMethodBeat.o(74208);
      return paramaca;
    }
    if (paramaca.mBq == null)
    {
      AppMethodBeat.o(74208);
      return null;
    }
    String str = com.tencent.mm.plugin.fav.a.b.b(paramaca);
    if (!com.tencent.mm.vfs.e.cN(str))
    {
      ab.w("MicroMsg.FavoriteImageLogic", "getBitmap file not exist");
      localObject = null;
    }
    for (;;)
    {
      if (localObject == null)
      {
        str = com.tencent.mm.plugin.fav.a.b.b(paramaca);
        com.tencent.mm.kernel.g.RO().ac(new l.3(str, paramg, paramaca));
      }
      AppMethodBeat.o(74208);
      return localObject;
      localObject = (Bitmap)myy.get(str);
      if (localObject == null) {
        break;
      }
      ab.d("MicroMsg.FavoriteImageLogic", "get bm from cache %s", new Object[] { str });
    }
    ab.d("MicroMsg.FavoriteImageLogic", "get from cache fail, try to decode from file");
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    Bitmap localBitmap = BitmapFactory.decodeFile(str, (BitmapFactory.Options)localObject);
    if (localBitmap != null)
    {
      ab.i("MicroMsg.FavoriteImageLogic", "bitmap recycle %s", new Object[] { localBitmap });
      localBitmap.recycle();
    }
    int j = ((BitmapFactory.Options)localObject).outWidth;
    int i = ((BitmapFactory.Options)localObject).outHeight;
    ab.d("MicroMsg.FavoriteImageLogic", "width: %s, height: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
    if (j > paramInt) {
      i = ((BitmapFactory.Options)localObject).outHeight * paramInt / ((BitmapFactory.Options)localObject).outWidth;
    }
    for (;;)
    {
      paramInt = Math.max(1, paramInt);
      i = Math.max(1, i);
      ab.w("MicroMsg.FavoriteImageLogic", "fit long picture, beg %d*%d, after %d*%d", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject).outHeight), Integer.valueOf(paramInt), Integer.valueOf(i) });
      int k = BackwardSupportUtil.ExifHelper.bY(str);
      if ((k == 90) || (k == 270)) {}
      for (;;)
      {
        localObject = d.d(str, paramInt, i, false);
        if (localObject == null)
        {
          ab.e("MicroMsg.FavoriteImageLogic", "getSuitableBmp fail, temBmp is null, filePath = ".concat(String.valueOf(str)));
          localObject = null;
          break;
        }
        localObject = d.b((Bitmap)localObject, k);
        myy.put(str, localObject);
        break;
        j = paramInt;
        paramInt = i;
        i = j;
      }
      paramInt = j;
    }
  }
  
  public static Bitmap b(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(74212);
    boolean bool = false;
    if (!com.tencent.mm.vfs.e.cN(paramString))
    {
      ab.w("MicroMsg.FavoriteImageLogic", "file not exist");
      AppMethodBeat.o(74212);
      return null;
    }
    Bitmap localBitmap = (Bitmap)myz.get(paramString);
    if ((localBitmap != null) || (paramBoolean))
    {
      if (localBitmap != null) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        ab.d("MicroMsg.FavoriteImageLogic", "return bm path %s, bm %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(74212);
        return localBitmap;
      }
    }
    Object localObject1 = localBitmap;
    for (;;)
    {
      Object localObject2;
      int m;
      try
      {
        localObject2 = new BitmapFactory.Options();
        localObject1 = localBitmap;
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
        localObject1 = localBitmap;
        d.decodeFile(paramString, (BitmapFactory.Options)localObject2);
        localObject1 = localBitmap;
        i = ((BitmapFactory.Options)localObject2).outWidth;
        localObject1 = localBitmap;
        j = ((BitmapFactory.Options)localObject2).outHeight;
        localObject1 = localBitmap;
        m = BackwardSupportUtil.ExifHelper.bY(paramString);
        if (m == 90) {
          break label627;
        }
        if (m != 270) {
          break label609;
        }
      }
      catch (IOException paramString)
      {
        ab.e("MicroMsg.FavoriteImageLogic", paramString.getMessage());
        AppMethodBeat.o(74212);
        return localObject1;
      }
      localObject1 = localBitmap;
      ((BitmapFactory.Options)localObject2).inSampleSize = 1;
      localObject1 = localBitmap;
      if (i / ((BitmapFactory.Options)localObject2).inSampleSize > paramInt2)
      {
        localObject1 = localBitmap;
        if (j / ((BitmapFactory.Options)localObject2).inSampleSize > paramInt1)
        {
          localObject1 = localBitmap;
          ((BitmapFactory.Options)localObject2).inSampleSize += 1;
          continue;
        }
      }
      localObject1 = localBitmap;
      int k = j * paramInt2 / paramInt1;
      localObject1 = localBitmap;
      ab.d("MicroMsg.FavoriteImageLogic", "decode top region width: %d, height: %d, scaleheight: %d, rotate: %b", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k), Boolean.valueOf(paramBoolean) });
      Rect localRect;
      label393:
      BitmapRegionDecoder localBitmapRegionDecoder;
      if ((k > 0) && (i > k))
      {
        localObject1 = localBitmap;
        localRect = new Rect();
        localObject1 = localBitmap;
        localRect.top = 0;
        localObject1 = localBitmap;
        localRect.left = 0;
        if (paramBoolean)
        {
          localObject1 = localBitmap;
          localRect.right = k;
          localObject1 = localBitmap;
          localRect.bottom = j;
          localObject1 = localBitmap;
          localBitmapRegionDecoder = BitmapRegionDecoder.newInstance(paramString, true);
          localObject1 = localBitmap;
          ((BitmapFactory.Options)localObject2).inJustDecodeBounds = false;
          localObject1 = localBitmap;
        }
      }
      for (localBitmap = localBitmapRegionDecoder.decodeRegion(localRect, (BitmapFactory.Options)localObject2);; localBitmap = d.decodeFile(paramString, (BitmapFactory.Options)localObject2))
      {
        localObject2 = localBitmap;
        if (localBitmap != null)
        {
          localObject2 = localBitmap;
          if (paramBoolean)
          {
            localObject1 = localBitmap;
            localObject2 = d.b(localBitmap, m);
          }
        }
        if (localObject2 == null) {
          break label590;
        }
        localObject1 = localObject2;
        ab.d("MicroMsg.FavoriteImageLogic", "width %d, height %d, tw %d, th %d", new Object[] { Integer.valueOf(((Bitmap)localObject2).getWidth()), Integer.valueOf(((Bitmap)localObject2).getHeight()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        localObject1 = localObject2;
        myz.put(paramString, localObject2);
        localObject1 = localObject2;
        break;
        localObject1 = localBitmap;
        localRect.right = j;
        localObject1 = localBitmap;
        localRect.bottom = k;
        break label393;
        localObject1 = localBitmap;
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = false;
        localObject1 = localBitmap;
      }
      label590:
      localObject1 = localObject2;
      ab.w("MicroMsg.FavoriteImageLogic", "decode bm fail!");
      localObject1 = localObject2;
      continue;
      label609:
      k = i;
      int i = j;
      int j = k;
      paramBoolean = bool;
      continue;
      label627:
      paramBoolean = true;
    }
  }
  
  public static void b(com.tencent.mm.plugin.fav.a.g paramg, aca paramaca)
  {
    AppMethodBeat.i(74215);
    b(paramg, paramaca, true);
    AppMethodBeat.o(74215);
  }
  
  private static void b(com.tencent.mm.plugin.fav.a.g paramg, aca paramaca, boolean paramBoolean)
  {
    AppMethodBeat.i(74214);
    String str = com.tencent.mm.plugin.fav.a.b.b(paramaca);
    com.tencent.mm.kernel.g.RO().ac(new l.7(paramBoolean, str, paramg, paramaca));
    AppMethodBeat.o(74214);
  }
  
  private void bxG()
  {
    AppMethodBeat.i(74202);
    e locale = this.myu;
    synchronized (locale.eKs)
    {
      ab.d("MicroMsg.ImageEngine", "do clear mark");
      locale.weH.clear();
      locale.weI.clear();
      locale.weH = new HashMap();
      locale.weI = new HashMap();
      AppMethodBeat.o(74202);
      return;
    }
  }
  
  public static Bitmap j(aca paramaca)
  {
    AppMethodBeat.i(74209);
    if (!com.tencent.mm.compatible.util.f.Mi())
    {
      paramaca = BitmapFactory.decodeResource(ah.getContext().getResources(), 2130839821);
      AppMethodBeat.o(74209);
      return paramaca;
    }
    if (paramaca.mBq == null)
    {
      AppMethodBeat.o(74209);
      return null;
    }
    paramaca = a(paramaca, false, true);
    AppMethodBeat.o(74209);
    return paramaca;
  }
  
  public final void a(ImageView paramImageView, aca paramaca, com.tencent.mm.plugin.fav.a.g paramg, int paramInt1, int paramInt2, int paramInt3)
  {
    String str = null;
    AppMethodBeat.i(74205);
    if (paramImageView == null)
    {
      AppMethodBeat.o(74205);
      return;
    }
    if (!com.tencent.mm.compatible.util.f.Mi())
    {
      paramImageView.setImageResource(2130839821);
      AppMethodBeat.o(74205);
      return;
    }
    if (paramg == null)
    {
      AppMethodBeat.o(74205);
      return;
    }
    adf localadf;
    switch (paramg.field_type)
    {
    case 6: 
    case 8: 
    case 9: 
    case 12: 
    case 13: 
    case 14: 
    default: 
      ab.w("MicroMsg.FavoriteImageLogic", "attach thumb, pass type is %d", new Object[] { Integer.valueOf(paramg.field_type) });
      AppMethodBeat.o(74205);
      return;
    case 7: 
      if (paramaca != null)
      {
        a(paramImageView, paramaca, paramg, paramaca.cpH, paramInt1, paramInt2, paramInt3);
        AppMethodBeat.o(74205);
        return;
      }
      break;
    case 4: 
    case 16: 
      if (paramaca != null)
      {
        a(paramImageView, paramaca, paramg, paramaca.cpH, paramInt1, paramInt2, paramInt3);
        AppMethodBeat.o(74205);
        return;
      }
      break;
    case 5: 
      localadf = paramg.field_favProto.wUf;
      if (paramaca == null)
      {
        if (localadf != null) {
          this.myu.a(paramImageView, null, localadf.thumbUrl, paramInt1, paramInt2, paramInt3);
        }
        AppMethodBeat.o(74205);
        return;
      }
      if (localadf == null)
      {
        if (!bo.isNullOrNil(str)) {
          break label422;
        }
        str = paramaca.cpH;
      }
      break;
    }
    label422:
    for (;;)
    {
      a(paramImageView, paramaca, paramg, str, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(74205);
      return;
      str = localadf.thumbUrl;
      break;
      paramaca = paramg.field_favProto.wUh;
      if (paramaca != null)
      {
        this.myu.a(paramImageView, null, paramaca.thumbUrl, paramInt1, paramInt2, paramInt3);
        AppMethodBeat.o(74205);
        return;
        paramaca = paramg.field_favProto.wUj;
        if (paramaca != null)
        {
          this.myu.a(paramImageView, null, paramaca.thumbUrl, paramInt1, paramInt2, paramInt3);
          AppMethodBeat.o(74205);
          return;
          paramaca = paramg.field_favProto.wUh;
          if (paramaca != null)
          {
            this.myu.a(paramImageView, null, paramaca.thumbUrl, paramInt1, paramInt2, paramInt3);
            AppMethodBeat.o(74205);
            return;
          }
        }
      }
      AppMethodBeat.o(74205);
      return;
    }
  }
  
  public final void a(ImageView paramImageView, aca paramaca, com.tencent.mm.plugin.fav.a.g paramg, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(74204);
    String str = com.tencent.mm.plugin.fav.a.b.Ny(paramaca.mBq);
    String[] arrayOfString = null;
    if (paramaca.mBq != null)
    {
      arrayOfString = (String[])this.myw.get(str);
      if (arrayOfString != null) {
        break label136;
      }
      arrayOfString = new String[1];
      arrayOfString[0] = com.tencent.mm.plugin.fav.a.b.c(paramaca);
      this.myw.put(str, arrayOfString);
    }
    label136:
    for (;;)
    {
      this.myu.a(paramImageView, arrayOfString, paramString, paramInt1, paramInt2, paramInt3);
      if ((arrayOfString == null) || (arrayOfString.length <= 0))
      {
        AppMethodBeat.o(74204);
        return;
      }
      paramImageView = arrayOfString[0];
      com.tencent.mm.kernel.g.RO().ac(new l.1(this, paramImageView, paramg, paramaca));
      AppMethodBeat.o(74204);
      return;
    }
  }
  
  public final void b(ImageView paramImageView, aca paramaca, com.tencent.mm.plugin.fav.a.g paramg, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject2 = null;
    AppMethodBeat.i(74206);
    if (paramImageView == null)
    {
      AppMethodBeat.o(74206);
      return;
    }
    if (!com.tencent.mm.compatible.util.f.Mi())
    {
      paramImageView.setImageResource(2130839821);
      AppMethodBeat.o(74206);
      return;
    }
    if ((paramg == null) || (paramaca == null))
    {
      paramImageView.setImageDrawable(a.k(this.context, paramInt1));
      AppMethodBeat.o(74206);
      return;
    }
    Object localObject1;
    switch (paramaca.dataType)
    {
    case 6: 
    case 8: 
    case 9: 
    case 12: 
    case 13: 
    case 16: 
    case 17: 
    case 18: 
    default: 
      ab.w("MicroMsg.FavoriteImageLogic", "attach thumb, pass type is %d", new Object[] { Integer.valueOf(paramg.field_type) });
      AppMethodBeat.o(74206);
      return;
    case 7: 
      a(paramImageView, paramaca, paramg, paramaca.cpH, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(74206);
      return;
    case 4: 
    case 15: 
      a(paramImageView, paramaca, paramg, paramaca.cpH, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(74206);
      return;
    case 5: 
      if (paramaca.wTw != null)
      {
        localObject1 = paramaca.wTw.wUf;
        if (localObject1 != null) {
          break label331;
        }
        localObject1 = localObject2;
        label250:
        if (!bo.isNullOrNil((String)localObject1)) {
          break label712;
        }
        localObject1 = paramaca.cpH;
      }
      break;
    }
    label712:
    for (;;)
    {
      a(paramImageView, paramaca, paramg, (String)localObject1, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(74206);
      return;
      ab.w("MicroMsg.FavoriteImageLogic", "webpage: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[] { paramaca.mBq, Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
      localObject1 = null;
      break;
      label331:
      localObject1 = ((adf)localObject1).thumbUrl;
      break label250;
      if (paramaca.wTw == null)
      {
        ab.w("MicroMsg.FavoriteImageLogic", "good: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[] { paramaca.mBq, Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
        AppMethodBeat.o(74206);
        return;
      }
      paramaca = paramaca.wTw.wUh;
      if (paramaca != null)
      {
        this.myu.a(paramImageView, null, paramaca.thumbUrl, paramInt1, paramInt2, paramInt3);
        AppMethodBeat.o(74206);
        return;
        if (paramaca.wTw == null)
        {
          ab.w("MicroMsg.FavoriteImageLogic", "tv: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[] { paramaca.mBq, Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
          AppMethodBeat.o(74206);
          return;
        }
        paramaca = paramaca.wTw.wUj;
        if (paramaca != null)
        {
          this.myu.a(paramImageView, null, paramaca.thumbUrl, paramInt1, paramInt2, paramInt3);
          AppMethodBeat.o(74206);
          return;
          if (paramaca.wTw == null)
          {
            ab.w("MicroMsg.FavoriteImageLogic", "product: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[] { paramaca.mBq, Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
            AppMethodBeat.o(74206);
            return;
          }
          paramaca = paramaca.wTw.wUh;
          if (paramaca != null)
          {
            this.myu.a(paramImageView, null, paramaca.thumbUrl, paramInt1, paramInt2, paramInt3);
            AppMethodBeat.o(74206);
            return;
            if (paramaca.wTw == null)
            {
              ab.w("MicroMsg.FavoriteImageLogic", "app brand: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[] { paramaca.mBq, Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
              AppMethodBeat.o(74206);
              return;
            }
            paramaca = paramaca.wTw.wUs;
            if (paramaca != null)
            {
              this.myu.a(paramImageView, null, paramaca.iconUrl, paramInt1, paramInt2, paramInt3);
              AppMethodBeat.o(74206);
              return;
            }
          }
        }
      }
      AppMethodBeat.o(74206);
      return;
    }
  }
  
  public final void destory()
  {
    AppMethodBeat.i(74203);
    bxG();
    this.myv.clear();
    this.myw.clear();
    this.myu.destroy();
    this.context = null;
    this.myv = null;
    this.myw = null;
    this.myu = null;
    AppMethodBeat.o(74203);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.l
 * JD-Core Version:    0.7.0.1
 */