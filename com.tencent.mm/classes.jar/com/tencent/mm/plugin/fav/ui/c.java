package com.tencent.mm.plugin.fav.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.ThumbnailUtils;
import android.support.v4.app.Fragment;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.cm.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.snackbar.a.b;
import com.tencent.mm.ui.widget.snackbar.a.c;
import com.tencent.mm.vfs.e;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class c
{
  private static f<String, Bitmap> mwg;
  private static Map<String, Integer> mwh;
  
  static
  {
    AppMethodBeat.i(73996);
    mwg = new com.tencent.mm.memory.a.b(20, c.class);
    mwh = new HashMap();
    HashMap localHashMap = new HashMap();
    mwh = localHashMap;
    localHashMap.put("avi", Integer.valueOf(2131230826));
    mwh.put("m4v", Integer.valueOf(2131230826));
    mwh.put("vob", Integer.valueOf(2131230826));
    mwh.put("mpeg", Integer.valueOf(2131230826));
    mwh.put("mpe", Integer.valueOf(2131230826));
    mwh.put("asx", Integer.valueOf(2131230826));
    mwh.put("asf", Integer.valueOf(2131230826));
    mwh.put("f4v", Integer.valueOf(2131230826));
    mwh.put("flv", Integer.valueOf(2131230826));
    mwh.put("mkv", Integer.valueOf(2131230826));
    mwh.put("wmv", Integer.valueOf(2131230826));
    mwh.put("wm", Integer.valueOf(2131230826));
    mwh.put("3gp", Integer.valueOf(2131230826));
    mwh.put("mp4", Integer.valueOf(2131230826));
    mwh.put("rmvb", Integer.valueOf(2131230826));
    mwh.put("rm", Integer.valueOf(2131230826));
    mwh.put("ra", Integer.valueOf(2131230826));
    mwh.put("ram", Integer.valueOf(2131230826));
    mwh.put("mp3pro", Integer.valueOf(2131230809));
    mwh.put("vqf", Integer.valueOf(2131230809));
    mwh.put("cd", Integer.valueOf(2131230809));
    mwh.put("md", Integer.valueOf(2131230809));
    mwh.put("mod", Integer.valueOf(2131230809));
    mwh.put("vorbis", Integer.valueOf(2131230809));
    mwh.put("au", Integer.valueOf(2131230809));
    mwh.put("amr", Integer.valueOf(2131230809));
    mwh.put("silk", Integer.valueOf(2131230809));
    mwh.put("wma", Integer.valueOf(2131230809));
    mwh.put("mmf", Integer.valueOf(2131230809));
    mwh.put("mid", Integer.valueOf(2131230809));
    mwh.put("midi", Integer.valueOf(2131230809));
    mwh.put("mp3", Integer.valueOf(2131230809));
    mwh.put("aac", Integer.valueOf(2131230809));
    mwh.put("ape", Integer.valueOf(2131230809));
    mwh.put("aiff", Integer.valueOf(2131230809));
    mwh.put("aif", Integer.valueOf(2131230809));
    mwh.put("jfif", Integer.valueOf(2131230815));
    mwh.put("tiff", Integer.valueOf(2131230815));
    mwh.put("tif", Integer.valueOf(2131230815));
    mwh.put("jpe", Integer.valueOf(2131230815));
    mwh.put("dib", Integer.valueOf(2131230815));
    mwh.put("jpeg", Integer.valueOf(2131230815));
    mwh.put("jpg", Integer.valueOf(2131230815));
    mwh.put("png", Integer.valueOf(2131230815));
    mwh.put("bmp", Integer.valueOf(2131230815));
    mwh.put("gif", Integer.valueOf(2131230815));
    mwh.put("rar", Integer.valueOf(2131230818));
    mwh.put("zip", Integer.valueOf(2131230818));
    mwh.put("7z", Integer.valueOf(2131230818));
    mwh.put("iso", Integer.valueOf(2131230818));
    mwh.put("cab", Integer.valueOf(2131230818));
    mwh.put("doc", Integer.valueOf(2131230830));
    mwh.put("docx", Integer.valueOf(2131230830));
    mwh.put("ppt", Integer.valueOf(2131230816));
    mwh.put("pptx", Integer.valueOf(2131230816));
    mwh.put("xls", Integer.valueOf(2131230802));
    mwh.put("xlsx", Integer.valueOf(2131230802));
    mwh.put("txt", Integer.valueOf(2131230821));
    mwh.put("rtf", Integer.valueOf(2131230821));
    mwh.put("pdf", Integer.valueOf(2131230813));
    mwh.put("unknown", Integer.valueOf(2131230822));
    AppMethodBeat.o(73996);
  }
  
  public static int NV(String paramString)
  {
    AppMethodBeat.i(73994);
    paramString = (Integer)mwh.get(paramString);
    if (paramString == null)
    {
      i = ((Integer)mwh.get("unknown")).intValue();
      AppMethodBeat.o(73994);
      return i;
    }
    int i = paramString.intValue();
    AppMethodBeat.o(73994);
    return i;
  }
  
  @TargetApi(8)
  public static Bitmap NW(String paramString)
  {
    AppMethodBeat.i(73995);
    Bitmap localBitmap = null;
    if (com.tencent.mm.compatible.util.d.fv(8)) {
      localBitmap = ThumbnailUtils.createVideoThumbnail(paramString, 1);
    }
    AppMethodBeat.o(73995);
    return localBitmap;
  }
  
  private static int a(cm paramcm, int paramInt)
  {
    AppMethodBeat.i(73989);
    aca localaca;
    if ((paramcm.cpR.cpT.wVc != null) && (paramcm.cpR.cpT.wVc.size() > 0))
    {
      localaca = (aca)paramcm.cpR.cpT.wVc.getLast();
      if (paramInt <= 0) {
        switch (paramInt)
        {
        default: 
          localaca.MK(0);
        }
      }
    }
    for (;;)
    {
      b(paramcm, paramInt);
      AppMethodBeat.o(73989);
      return paramInt;
      localaca.MK(1);
      localaca.anE(null);
      continue;
      localaca.MK(2);
      localaca.anE(null);
    }
  }
  
  public static int a(bi parambi, cm paramcm, boolean paramBoolean)
  {
    AppMethodBeat.i(73988);
    ab.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo msg type is %d", new Object[] { Integer.valueOf(parambi.getType()) });
    int i;
    if ((!paramBoolean) && (paramcm.cpR.cpX > 0))
    {
      ab.i("MicroMsg.FavExportLogic", "(!result)&&(favoriteEvent.data.errorType > FavExportLogic.KEY_FAV_PARA_NO_ERROR)");
      i = a(paramcm, paramcm.cpR.cpX);
      AppMethodBeat.o(73988);
      return i;
    }
    if ((paramcm.cpR.type == 4) || (paramcm.cpR.type == 8) || (paramcm.cpR.type == 16) || (paramcm.cpR.type == 2)) {}
    for (paramBoolean = false;; paramBoolean = true)
    {
      boolean bool = paramBoolean;
      Object localObject;
      if (paramcm.cpR.type == 14)
      {
        bool = paramBoolean;
        if (paramcm.cpR.cpT.wVc.size() > 0)
        {
          localObject = (aca)paramcm.cpR.cpT.wVc.getLast();
          if ((((aca)localObject).dataType != 4) && (((aca)localObject).dataType != 8) && (((aca)localObject).dataType != 15))
          {
            bool = paramBoolean;
            if (((aca)localObject).dataType != 2) {}
          }
          else
          {
            bool = false;
          }
        }
      }
      ab.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo msg type skipCheck %B", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        i = a(paramcm, 0);
        AppMethodBeat.o(73988);
        return i;
      }
      if (paramcm.cpR.cpT == null)
      {
        i = a(paramcm, -1);
        AppMethodBeat.o(73988);
        return i;
      }
      if (paramcm.cpR.cpT.wVc == null)
      {
        i = a(paramcm, -1);
        AppMethodBeat.o(73988);
        return i;
      }
      if (System.currentTimeMillis() - parambi.field_createTime > 259200000L) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        ab.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo isOverThreeDays %B", new Object[] { Boolean.valueOf(paramBoolean) });
        if (1 <= paramcm.cpR.cpT.wVc.size()) {}
        for (localObject = ((aca)paramcm.cpR.cpT.wVc.getLast()).wTa;; localObject = "")
        {
          if (paramBoolean)
          {
            if ((!bo.isNullOrNil((String)localObject)) && (e.cN((String)localObject))) {
              break label606;
            }
            if ((parambi != null) && ((parambi.getType() == 43) || (parambi.getType() == 44) || (parambi.getType() == 62)))
            {
              localObject = u.vr(parambi.field_imgPath);
              if ((localObject != null) && (((s)localObject).fXE == -1))
              {
                localObject = ((s)localObject).alO();
                if (!e.cN((String)localObject)) {}
              }
            }
            while (bo.isNullOrNil((String)localObject))
            {
              i = a(paramcm, -4);
              AppMethodBeat.o(73988);
              return i;
              localObject = null;
            }
            ((aca)paramcm.cpR.cpT.wVc.getLast()).anE((String)localObject);
          }
          label606:
          for (;;)
          {
            if (a(parambi, paramcm, (String)localObject, true))
            {
              i = a(paramcm, -5);
              AppMethodBeat.o(73988);
              return i;
            }
            ab.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  isOverThreeDays true not big not expired");
            do
            {
              ab.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  fav data is normal");
              i = a(paramcm, 0);
              AppMethodBeat.o(73988);
              return i;
            } while (!a(parambi, paramcm, (String)localObject, false));
            i = a(paramcm, -5);
            AppMethodBeat.o(73988);
            return i;
          }
        }
      }
    }
  }
  
  private static void a(int paramInt1, int paramInt2, Activity paramActivity, Fragment paramFragment, DialogInterface.OnClickListener paramOnClickListener, a.b paramb, a.c paramc)
  {
    AppMethodBeat.i(73987);
    Object localObject;
    String str;
    if (paramFragment == null)
    {
      localObject = paramActivity;
      if (paramInt2 != -4) {
        break label199;
      }
      switch (paramInt1)
      {
      default: 
        str = "";
      }
    }
    for (;;)
    {
      h.a((Context)localObject, str, "", ((Context)localObject).getString(2131302102), ((Context)localObject).getString(2131298499), new c.5(paramOnClickListener, paramFragment, paramb, paramc, paramActivity), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(73982);
          paramAnonymousDialogInterface.dismiss();
          if (this.mwj != null) {
            this.mwj.onClick(paramAnonymousDialogInterface, -1);
          }
          AppMethodBeat.o(73982);
        }
      }, 2131690701);
      AppMethodBeat.o(73987);
      return;
      localObject = paramFragment.getActivity();
      break;
      str = ((Context)localObject).getString(2131299710);
      continue;
      str = ((Context)localObject).getString(2131299709);
      continue;
      str = ((Context)localObject).getString(2131299711);
      continue;
      str = ((Context)localObject).getString(2131299725);
      continue;
      label199:
      if (paramInt2 == -5)
      {
        if (paramInt1 != 14) {
          str = ((Context)localObject).getString(2131299682);
        } else {
          str = ((Context)localObject).getString(2131299724);
        }
      }
      else if (paramInt2 == -6)
      {
        str = ((Context)localObject).getString(2131299725);
      }
      else if (paramInt2 == -7)
      {
        str = ((Context)localObject).getString(2131299724);
      }
      else if (paramInt2 == -8)
      {
        str = ((Context)localObject).getString(2131299726);
      }
      else
      {
        if (paramInt2 == -9)
        {
          if (paramFragment != null)
          {
            paramActivity = paramFragment.getView();
            if ((paramFragment instanceof MMFragment)) {
              paramActivity = ((MMFragment)paramFragment).getContentView();
            }
            com.tencent.mm.ui.widget.snackbar.b.a(paramFragment.getContext(), paramActivity, ((Context)localObject).getString(2131299764), ((Context)localObject).getString(2131299681), paramb, paramc);
            AppMethodBeat.o(73987);
            return;
          }
          com.tencent.mm.ui.widget.snackbar.b.a(paramActivity, ((Context)localObject).getString(2131299764), ((Context)localObject).getString(2131299681), paramb, paramc);
          AppMethodBeat.o(73987);
          return;
        }
        str = ((Context)localObject).getString(2131299713);
      }
    }
  }
  
  public static void a(int paramInt1, int paramInt2, Activity paramActivity, Fragment paramFragment, a.c paramc, DialogInterface.OnClickListener paramOnClickListener, a.b paramb)
  {
    AppMethodBeat.i(73984);
    if ((paramActivity == null) && (paramFragment == null))
    {
      ab.e("MicroMsg.FavExportLogic", "handleErrorType activity = null && fragment = null");
      AppMethodBeat.o(73984);
      return;
    }
    if (paramb == null) {
      paramb = new c.1();
    }
    for (;;)
    {
      if (paramInt2 == 0)
      {
        if (paramFragment != null)
        {
          paramActivity = paramFragment.getView();
          if ((paramFragment instanceof MMFragment)) {
            paramActivity = ((MMFragment)paramFragment).getContentView();
          }
          com.tencent.mm.ui.widget.snackbar.b.a(paramFragment.getContext(), paramActivity, paramFragment.getString(2131299764), paramFragment.getString(2131299681), paramb, paramc);
          AppMethodBeat.o(73984);
          return;
        }
        if (paramActivity != null)
        {
          com.tencent.mm.ui.widget.snackbar.b.a(paramActivity, paramActivity.getString(2131299764), paramActivity.getString(2131299681), paramb, paramc);
          AppMethodBeat.o(73984);
        }
      }
      else
      {
        if (paramActivity != null) {
          break label268;
        }
        paramActivity = paramFragment.getActivity();
      }
      label268:
      for (;;)
      {
        switch (paramInt2)
        {
        case -3: 
        default: 
          h.a(paramActivity, paramInt2, 0, new c.2(paramOnClickListener));
          AppMethodBeat.o(73984);
          return;
        case -2: 
          a(paramActivity, paramOnClickListener);
          AppMethodBeat.o(73984);
          return;
        case -9: 
        case -8: 
        case -7: 
        case -6: 
        case -5: 
        case -4: 
          a(paramInt1, paramInt2, paramActivity, paramFragment, paramOnClickListener, paramb, paramc);
          AppMethodBeat.o(73984);
          return;
        }
        a(paramActivity, paramFragment);
        AppMethodBeat.o(73984);
        return;
      }
    }
  }
  
  public static void a(int paramInt, Activity paramActivity, a.b paramb)
  {
    AppMethodBeat.i(73983);
    a(-1, paramInt, paramActivity, null, null, null, paramb);
    AppMethodBeat.o(73983);
  }
  
  private static void a(Activity paramActivity, Fragment paramFragment)
  {
    AppMethodBeat.i(73985);
    if (paramFragment != null) {
      paramActivity = paramFragment.getActivity();
    }
    t.makeText(paramActivity, 2131299722, 0).show();
    AppMethodBeat.o(73985);
  }
  
  private static void a(Context paramContext, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(73986);
    h.a(paramContext, paramContext.getString(2131299715), paramContext.getString(2131299716), paramContext.getString(2131299718), paramContext.getString(2131298499), new c.3(paramContext, paramOnClickListener), new c.4(paramOnClickListener), 2131690701);
    AppMethodBeat.o(73986);
  }
  
  private static boolean a(bi parambi, cm paramcm, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(73990);
    Object localObject;
    if (!bo.isNullOrNil(paramString))
    {
      localObject = new com.tencent.mm.vfs.b(paramString);
      if (((com.tencent.mm.vfs.b)localObject).exists())
      {
        if (((com.tencent.mm.vfs.b)localObject).length() > com.tencent.mm.m.b.MX())
        {
          ab.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file is big");
          AppMethodBeat.o(73990);
          return true;
        }
        ab.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file not big");
      }
    }
    else
    {
      localObject = parambi.field_content;
      if (localObject == null) {
        break label257;
      }
    }
    label257:
    for (parambi = j.b.ab((String)localObject, parambi.field_reserved);; parambi = null)
    {
      if (parambi != null)
      {
        if ((parambi.fgA != 0) || (parambi.fgw > com.tencent.mm.m.b.MX()))
        {
          ab.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file is big");
          AppMethodBeat.o(73990);
          return true;
          if (paramBoolean) {
            break;
          }
          ab.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  not download finish ！attachFile.exists()");
          ((aca)paramcm.cpR.cpT.wVc.getLast()).anE(null);
          break;
        }
        if ((!bo.isNullOrNil(paramString)) && (e.cN(paramString)) && (!paramBoolean))
        {
          long l = e.avI(paramString);
          if (parambi.fgw > l)
          {
            ab.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  not download finish content.attachlen > datasize");
            ((aca)paramcm.cpR.cpT.wVc.getLast()).anE(null);
          }
        }
      }
      if ((localObject == null) || (parambi == null)) {
        ab.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  (xml == null ) ||(content == null)");
      }
      AppMethodBeat.o(73990);
      return false;
    }
  }
  
  public static Bitmap aO(String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(73993);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(73993);
      return null;
    }
    Object localObject = (Bitmap)mwg.get(paramString);
    if (localObject != null)
    {
      ab.d("MicroMsg.FavExportLogic", "get bm from cache %s", new Object[] { paramString });
      AppMethodBeat.o(73993);
      return localObject;
    }
    if (paramBoolean)
    {
      AppMethodBeat.o(73993);
      return null;
    }
    if (!e.cN(paramString))
    {
      AppMethodBeat.o(73993);
      return null;
    }
    ab.d("MicroMsg.FavExportLogic", "get from cache fail, try to decode from file");
    localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    Bitmap localBitmap = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    if (localBitmap != null)
    {
      ab.i("MicroMsg.FavExportLogic", "bitmap recycle %s", new Object[] { localBitmap });
      localBitmap.recycle();
    }
    int j;
    if ((ad.cO(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight)) && (((BitmapFactory.Options)localObject).outWidth > 480))
    {
      i = 1;
      if ((!ad.cN(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight)) || (((BitmapFactory.Options)localObject).outHeight <= 480)) {
        break label259;
      }
      j = 1;
    }
    label259:
    for (;;)
    {
      label214:
      if ((i != 0) || (j != 0))
      {
        i = ((BitmapFactory.Options)localObject).outHeight;
        j = ((BitmapFactory.Options)localObject).outWidth;
        for (;;)
        {
          if (j * i > 2764800)
          {
            j >>= 1;
            i >>= 1;
            continue;
            i = 0;
            break;
            j = 0;
            break label214;
          }
        }
        j = Math.max(1, j);
        i = Math.max(1, i);
        ab.w("MicroMsg.FavExportLogic", "fit long picture, beg %d*%d, after %d*%d", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject).outHeight), Integer.valueOf(j), Integer.valueOf(i) });
      }
    }
    int i = BackwardSupportUtil.ExifHelper.bY(paramString);
    if ((MMNativeJpeg.IsJpegFile(paramString)) && (MMNativeJpeg.isProgressive(paramString)))
    {
      localObject = MMNativeJpeg.decodeAsBitmap(paramString);
      if (localObject == null)
      {
        paramBoolean = bool;
        ab.i("MicroMsg.FavExportLogic", "Progressive jpeg, result isNull:%b", new Object[] { Boolean.valueOf(paramBoolean) });
      }
    }
    for (;;)
    {
      if (localObject != null) {
        break label421;
      }
      ab.e("MicroMsg.FavExportLogic", "getSuitableBmp fail, temBmp is null, filePath = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(73993);
      return null;
      paramBoolean = false;
      break;
      localObject = com.tencent.mm.sdk.platformtools.d.aoV(paramString);
    }
    label421:
    localObject = com.tencent.mm.sdk.platformtools.d.b((Bitmap)localObject, i);
    if (((Bitmap)localObject).getHeight() * ((Bitmap)localObject).getWidth() > 20971520)
    {
      AppMethodBeat.o(73993);
      return localObject;
    }
    mwg.put(paramString, localObject);
    AppMethodBeat.o(73993);
    return localObject;
  }
  
  private static void b(cm paramcm, int paramInt)
  {
    AppMethodBeat.i(73991);
    if ((paramcm.cpR.cpT.wVc == null) || (paramcm.cpR.cpT.wVc.size() == 0))
    {
      paramcm.cpR.cpX = paramInt;
      AppMethodBeat.o(73991);
      return;
    }
    if (paramcm.cpR.cpX == -9)
    {
      AppMethodBeat.o(73991);
      return;
    }
    if ((paramInt > 0) || (paramcm.cpR.cpX > 0)) {}
    for (int i = 1;; i = 0)
    {
      int k = 0;
      int n = 0;
      int m = 0;
      int j = 0;
      if (k < paramcm.cpR.cpT.wVc.size())
      {
        switch (((aca)paramcm.cpR.cpT.wVc.get(k)).wTK)
        {
        }
        for (;;)
        {
          k += 1;
          break;
          n += 1;
          continue;
          m += 1;
          continue;
          j += 1;
        }
      }
      if (i > 0)
      {
        if ((m > 0) || (n > 0))
        {
          paramcm.cpR.cpX = -9;
          AppMethodBeat.o(73991);
          return;
        }
        paramcm.cpR.cpX = paramInt;
        AppMethodBeat.o(73991);
        return;
      }
      if (m > 0)
      {
        if (n > 0)
        {
          paramcm.cpR.cpX = -8;
          AppMethodBeat.o(73991);
          return;
        }
        if (j == 0)
        {
          paramcm.cpR.cpX = -5;
          AppMethodBeat.o(73991);
          return;
        }
        if (j > 0)
        {
          paramcm.cpR.cpX = -7;
          AppMethodBeat.o(73991);
          return;
        }
        AppMethodBeat.o(73991);
        return;
      }
      if (n > 0)
      {
        if (j == 0)
        {
          paramcm.cpR.cpX = -4;
          AppMethodBeat.o(73991);
          return;
        }
        if (j > 0)
        {
          paramcm.cpR.cpX = -6;
          AppMethodBeat.o(73991);
          return;
        }
      }
      AppMethodBeat.o(73991);
      return;
    }
  }
  
  public static void bxt()
  {
    AppMethodBeat.i(73992);
    mwg = new com.tencent.mm.memory.a.b(20, c.class);
    AppMethodBeat.o(73992);
  }
  
  public static void bxu() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.c
 * JD-Core Version:    0.7.0.1
 */