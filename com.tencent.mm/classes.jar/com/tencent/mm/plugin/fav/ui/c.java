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
import com.tencent.mm.ae.g.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.h.a.cj.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.snackbar.a.b;
import com.tencent.mm.ui.widget.snackbar.a.c;
import com.tencent.mm.vfs.e;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class c
{
  private static ab<String, Bitmap> kbK = new ab(20);
  private static Map<String, Integer> kbL = new HashMap();
  
  static
  {
    HashMap localHashMap = new HashMap();
    kbL = localHashMap;
    localHashMap.put("avi", Integer.valueOf(n.h.app_attach_file_icon_video));
    kbL.put("m4v", Integer.valueOf(n.h.app_attach_file_icon_video));
    kbL.put("vob", Integer.valueOf(n.h.app_attach_file_icon_video));
    kbL.put("mpeg", Integer.valueOf(n.h.app_attach_file_icon_video));
    kbL.put("mpe", Integer.valueOf(n.h.app_attach_file_icon_video));
    kbL.put("asx", Integer.valueOf(n.h.app_attach_file_icon_video));
    kbL.put("asf", Integer.valueOf(n.h.app_attach_file_icon_video));
    kbL.put("f4v", Integer.valueOf(n.h.app_attach_file_icon_video));
    kbL.put("flv", Integer.valueOf(n.h.app_attach_file_icon_video));
    kbL.put("mkv", Integer.valueOf(n.h.app_attach_file_icon_video));
    kbL.put("wmv", Integer.valueOf(n.h.app_attach_file_icon_video));
    kbL.put("wm", Integer.valueOf(n.h.app_attach_file_icon_video));
    kbL.put("3gp", Integer.valueOf(n.h.app_attach_file_icon_video));
    kbL.put("mp4", Integer.valueOf(n.h.app_attach_file_icon_video));
    kbL.put("rmvb", Integer.valueOf(n.h.app_attach_file_icon_video));
    kbL.put("rm", Integer.valueOf(n.h.app_attach_file_icon_video));
    kbL.put("ra", Integer.valueOf(n.h.app_attach_file_icon_video));
    kbL.put("ram", Integer.valueOf(n.h.app_attach_file_icon_video));
    kbL.put("mp3pro", Integer.valueOf(n.h.app_attach_file_icon_music));
    kbL.put("vqf", Integer.valueOf(n.h.app_attach_file_icon_music));
    kbL.put("cd", Integer.valueOf(n.h.app_attach_file_icon_music));
    kbL.put("md", Integer.valueOf(n.h.app_attach_file_icon_music));
    kbL.put("mod", Integer.valueOf(n.h.app_attach_file_icon_music));
    kbL.put("vorbis", Integer.valueOf(n.h.app_attach_file_icon_music));
    kbL.put("au", Integer.valueOf(n.h.app_attach_file_icon_music));
    kbL.put("amr", Integer.valueOf(n.h.app_attach_file_icon_music));
    kbL.put("silk", Integer.valueOf(n.h.app_attach_file_icon_music));
    kbL.put("wma", Integer.valueOf(n.h.app_attach_file_icon_music));
    kbL.put("mmf", Integer.valueOf(n.h.app_attach_file_icon_music));
    kbL.put("mid", Integer.valueOf(n.h.app_attach_file_icon_music));
    kbL.put("midi", Integer.valueOf(n.h.app_attach_file_icon_music));
    kbL.put("mp3", Integer.valueOf(n.h.app_attach_file_icon_music));
    kbL.put("aac", Integer.valueOf(n.h.app_attach_file_icon_music));
    kbL.put("ape", Integer.valueOf(n.h.app_attach_file_icon_music));
    kbL.put("aiff", Integer.valueOf(n.h.app_attach_file_icon_music));
    kbL.put("aif", Integer.valueOf(n.h.app_attach_file_icon_music));
    kbL.put("jfif", Integer.valueOf(n.h.app_attach_file_icon_pic));
    kbL.put("tiff", Integer.valueOf(n.h.app_attach_file_icon_pic));
    kbL.put("tif", Integer.valueOf(n.h.app_attach_file_icon_pic));
    kbL.put("jpe", Integer.valueOf(n.h.app_attach_file_icon_pic));
    kbL.put("dib", Integer.valueOf(n.h.app_attach_file_icon_pic));
    kbL.put("jpeg", Integer.valueOf(n.h.app_attach_file_icon_pic));
    kbL.put("jpg", Integer.valueOf(n.h.app_attach_file_icon_pic));
    kbL.put("png", Integer.valueOf(n.h.app_attach_file_icon_pic));
    kbL.put("bmp", Integer.valueOf(n.h.app_attach_file_icon_pic));
    kbL.put("gif", Integer.valueOf(n.h.app_attach_file_icon_pic));
    kbL.put("rar", Integer.valueOf(n.h.app_attach_file_icon_rar));
    kbL.put("zip", Integer.valueOf(n.h.app_attach_file_icon_rar));
    kbL.put("7z", Integer.valueOf(n.h.app_attach_file_icon_rar));
    kbL.put("iso", Integer.valueOf(n.h.app_attach_file_icon_rar));
    kbL.put("cab", Integer.valueOf(n.h.app_attach_file_icon_rar));
    kbL.put("doc", Integer.valueOf(n.h.app_attach_file_icon_word));
    kbL.put("docx", Integer.valueOf(n.h.app_attach_file_icon_word));
    kbL.put("ppt", Integer.valueOf(n.h.app_attach_file_icon_ppt));
    kbL.put("pptx", Integer.valueOf(n.h.app_attach_file_icon_ppt));
    kbL.put("xls", Integer.valueOf(n.h.app_attach_file_icon_excel));
    kbL.put("xlsx", Integer.valueOf(n.h.app_attach_file_icon_excel));
    kbL.put("txt", Integer.valueOf(n.h.app_attach_file_icon_txt));
    kbL.put("rtf", Integer.valueOf(n.h.app_attach_file_icon_txt));
    kbL.put("pdf", Integer.valueOf(n.h.app_attach_file_icon_pdf));
    kbL.put("unknown", Integer.valueOf(n.h.app_attach_file_icon_unknow));
  }
  
  public static int CT(String paramString)
  {
    paramString = (Integer)kbL.get(paramString);
    if (paramString == null) {
      return ((Integer)kbL.get("unknown")).intValue();
    }
    return paramString.intValue();
  }
  
  @TargetApi(8)
  public static Bitmap CU(String paramString)
  {
    Bitmap localBitmap = null;
    if (d.gF(8)) {
      localBitmap = ThumbnailUtils.createVideoThumbnail(paramString, 1);
    }
    return localBitmap;
  }
  
  private static int a(cj paramcj, int paramInt)
  {
    int i = 1;
    xv localxv;
    if ((paramcj.bIw.bIy.sXc != null) && (paramcj.bIw.bIy.sXc.size() > 0))
    {
      localxv = (xv)paramcj.bIw.bIy.sXc.getLast();
      if (paramInt > 0) {}
    }
    switch (paramInt)
    {
    default: 
      localxv.EJ(0);
      if ((paramcj.bIw.bIy.sXc == null) || (paramcj.bIw.bIy.sXc.size() == 0)) {
        paramcj.bIw.bIC = paramInt;
      }
      break;
    }
    while (paramcj.bIw.bIC == -9)
    {
      return paramInt;
      localxv.EJ(1);
      localxv.XI(null);
      break;
      localxv.EJ(2);
      localxv.XI(null);
      break;
    }
    int j = i;
    if (paramInt <= 0) {
      if (paramcj.bIw.bIC <= 0) {
        break label420;
      }
    }
    label420:
    for (j = i;; j = 0)
    {
      int k = 0;
      i = 0;
      int n = 0;
      int m = 0;
      if (k < paramcj.bIw.bIy.sXc.size())
      {
        switch (((xv)paramcj.bIw.bIy.sXc.get(k)).sVO)
        {
        }
        for (;;)
        {
          k += 1;
          break;
          i += 1;
          continue;
          n += 1;
          continue;
          m += 1;
        }
      }
      if (j > 0)
      {
        if ((n > 0) || (i > 0))
        {
          paramcj.bIw.bIC = -9;
          return paramInt;
        }
        paramcj.bIw.bIC = paramInt;
        return paramInt;
      }
      if (n > 0)
      {
        if (i > 0)
        {
          paramcj.bIw.bIC = -8;
          return paramInt;
        }
        if (m == 0)
        {
          paramcj.bIw.bIC = -5;
          return paramInt;
        }
        if (m <= 0) {
          break;
        }
        paramcj.bIw.bIC = -7;
        return paramInt;
      }
      if (i <= 0) {
        break;
      }
      if (m == 0)
      {
        paramcj.bIw.bIC = -4;
        return paramInt;
      }
      if (m <= 0) {
        break;
      }
      paramcj.bIw.bIC = -6;
      return paramInt;
    }
  }
  
  public static int a(bi parambi, cj paramcj, boolean paramBoolean)
  {
    y.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo msg type is %d", new Object[] { Integer.valueOf(parambi.getType()) });
    if ((!paramBoolean) && (paramcj.bIw.bIC > 0))
    {
      y.i("MicroMsg.FavExportLogic", "(!result)&&(favoriteEvent.data.errorType > FavExportLogic.KEY_FAV_PARA_NO_ERROR)");
      return a(paramcj, paramcj.bIw.bIC);
    }
    if ((paramcj.bIw.type == 4) || (paramcj.bIw.type == 8) || (paramcj.bIw.type == 16) || (paramcj.bIw.type == 2)) {}
    for (paramBoolean = false;; paramBoolean = true)
    {
      boolean bool = paramBoolean;
      Object localObject;
      if (paramcj.bIw.type == 14)
      {
        bool = paramBoolean;
        if (paramcj.bIw.bIy.sXc.size() > 0)
        {
          localObject = (xv)paramcj.bIw.bIy.sXc.getLast();
          if ((((xv)localObject).aYU != 4) && (((xv)localObject).aYU != 8) && (((xv)localObject).aYU != 15))
          {
            bool = paramBoolean;
            if (((xv)localObject).aYU != 2) {}
          }
          else
          {
            bool = false;
          }
        }
      }
      y.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo msg type skipCheck %B", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        return a(paramcj, 0);
      }
      if (paramcj.bIw.bIy == null) {
        return a(paramcj, -1);
      }
      if (paramcj.bIw.bIy.sXc == null) {
        return a(paramcj, -1);
      }
      if (System.currentTimeMillis() - parambi.field_createTime > 259200000L) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        y.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo isOverThreeDays %B", new Object[] { Boolean.valueOf(paramBoolean) });
        if (1 <= paramcj.bIw.bIy.sXc.size()) {}
        for (localObject = ((xv)paramcj.bIw.bIy.sXc.getLast()).sVe;; localObject = "")
        {
          if (paramBoolean)
          {
            if ((!bk.bl((String)localObject)) && (e.bK((String)localObject))) {
              break label530;
            }
            if ((parambi != null) && ((parambi.getType() == 43) || (parambi.getType() == 44) || (parambi.getType() == 62)))
            {
              localObject = u.oe(parambi.field_imgPath);
              if ((localObject != null) && (((com.tencent.mm.modelvideo.s)localObject).eHO == -1))
              {
                localObject = ((com.tencent.mm.modelvideo.s)localObject).SC();
                if (!e.bK((String)localObject)) {}
              }
            }
            while (bk.bl((String)localObject))
            {
              return a(paramcj, -4);
              localObject = null;
            }
            ((xv)paramcj.bIw.bIy.sXc.getLast()).XI((String)localObject);
          }
          label530:
          for (;;)
          {
            if (a(parambi, paramcj, (String)localObject, true)) {
              return a(paramcj, -5);
            }
            y.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  isOverThreeDays true not big not expired");
            do
            {
              y.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  fav data is normal");
              return a(paramcj, 0);
            } while (!a(parambi, paramcj, (String)localObject, false));
            return a(paramcj, -5);
          }
        }
      }
    }
  }
  
  public static void a(int paramInt1, int paramInt2, Activity paramActivity, Fragment paramFragment, a.c paramc, DialogInterface.OnClickListener paramOnClickListener, a.b paramb)
  {
    if ((paramActivity == null) && (paramFragment == null))
    {
      y.e("MicroMsg.FavExportLogic", "handleErrorType activity = null && fragment = null");
      return;
    }
    if (paramb == null) {}
    for (Object localObject1 = new c.1();; localObject1 = paramb)
    {
      if (paramInt2 == 0)
      {
        if (paramFragment != null)
        {
          com.tencent.mm.ui.widget.snackbar.b.a(paramFragment, paramFragment.getString(n.i.favorite_ok), paramFragment.getString(n.i.favorite_add_tag_tips), (a.b)localObject1, paramc);
          return;
        }
        if (paramActivity == null) {
          break;
        }
        com.tencent.mm.ui.widget.snackbar.b.a(paramActivity, paramActivity.getString(n.i.favorite_ok), paramActivity.getString(n.i.favorite_add_tag_tips), (a.b)localObject1, paramc);
        return;
      }
      if (paramActivity == null) {}
      for (paramb = paramFragment.getActivity();; paramb = paramActivity)
      {
        switch (paramInt2)
        {
        case -3: 
        default: 
          h.a(paramb, paramInt2, 0, new c.2(paramOnClickListener));
          return;
        case -2: 
          h.a(paramb, paramb.getString(n.i.favorite_fail_clean_alert_content), paramb.getString(n.i.favorite_fail_clean_alert_title), paramb.getString(n.i.favorite_fail_fav_clean), paramb.getString(n.i.confirm_dialog_cancel), new c.3(paramb, paramOnClickListener), new c.4(paramOnClickListener), n.b.wechat_green);
          return;
        case -9: 
        case -8: 
        case -7: 
        case -6: 
        case -5: 
        case -4: 
          Object localObject2;
          if (paramFragment == null)
          {
            localObject2 = paramb;
            if (paramInt2 != -4) {
              break label412;
            }
            switch (paramInt1)
            {
            default: 
              paramActivity = "";
            }
          }
          for (;;)
          {
            h.a((Context)localObject2, paramActivity, "", ((Context)localObject2).getString(n.i.plugin_favorite_opt), ((Context)localObject2).getString(n.i.confirm_dialog_cancel), new c.5(paramOnClickListener, paramFragment, (a.b)localObject1, paramc, paramb), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                paramAnonymousDialogInterface.dismiss();
                if (this.kbN != null) {
                  this.kbN.onClick(paramAnonymousDialogInterface, -1);
                }
              }
            }, n.b.wechat_green);
            return;
            localObject2 = paramFragment.getActivity();
            break;
            paramActivity = ((Context)localObject2).getString(n.i.favorite_expired_image);
            continue;
            paramActivity = ((Context)localObject2).getString(n.i.favorite_expired_file);
            continue;
            paramActivity = ((Context)localObject2).getString(n.i.favorite_expired_video);
            continue;
            paramActivity = ((Context)localObject2).getString(n.i.favorite_fail_record_expired);
            continue;
            label412:
            if (paramInt2 == -5)
            {
              if (paramInt1 != 14) {
                paramActivity = ((Context)localObject2).getString(n.i.favorite_big_file);
              } else {
                paramActivity = ((Context)localObject2).getString(n.i.favorite_fail_record_bigfile);
              }
            }
            else if (paramInt2 == -6)
            {
              paramActivity = ((Context)localObject2).getString(n.i.favorite_fail_record_expired);
            }
            else if (paramInt2 == -7)
            {
              paramActivity = ((Context)localObject2).getString(n.i.favorite_fail_record_bigfile);
            }
            else if (paramInt2 == -8)
            {
              paramActivity = ((Context)localObject2).getString(n.i.favorite_fail_record_expired_bigfile);
            }
            else
            {
              if (paramInt2 == -9)
              {
                if (paramFragment != null)
                {
                  com.tencent.mm.ui.widget.snackbar.b.a(paramFragment, ((Context)localObject2).getString(n.i.favorite_ok), ((Context)localObject2).getString(n.i.favorite_add_tag_tips), (a.b)localObject1, paramc);
                  return;
                }
                com.tencent.mm.ui.widget.snackbar.b.a(paramb, ((Context)localObject2).getString(n.i.favorite_ok), ((Context)localObject2).getString(n.i.favorite_add_tag_tips), (a.b)localObject1, paramc);
                return;
              }
              paramActivity = ((Context)localObject2).getString(n.i.favorite_fail_argument_error);
            }
          }
        }
        if (paramFragment == null) {}
        for (;;)
        {
          com.tencent.mm.ui.base.s.makeText(paramb, n.i.favorite_fail_open_im_withdown_download, 0).show();
          return;
          paramb = paramFragment.getActivity();
        }
      }
    }
  }
  
  public static void a(int paramInt, Activity paramActivity, a.b paramb)
  {
    a(-1, paramInt, paramActivity, null, null, null, paramb);
  }
  
  private static boolean a(bi parambi, cj paramcj, String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (!bk.bl(paramString))
    {
      localObject = new com.tencent.mm.vfs.b(paramString);
      if (((com.tencent.mm.vfs.b)localObject).exists())
      {
        if (((com.tencent.mm.vfs.b)localObject).length() > com.tencent.mm.m.b.Ai())
        {
          y.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file is big");
          return true;
        }
        y.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file not big");
      }
    }
    else
    {
      localObject = parambi.field_content;
      if (localObject == null) {
        break label233;
      }
    }
    label233:
    for (parambi = g.a.M((String)localObject, parambi.field_reserved);; parambi = null)
    {
      if (parambi != null)
      {
        if ((parambi.dQz != 0) || (parambi.dQv > com.tencent.mm.m.b.Ai()))
        {
          y.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file is big");
          return true;
          if (paramBoolean) {
            break;
          }
          y.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  not download finish ！attachFile.exists()");
          ((xv)paramcj.bIw.bIy.sXc.getLast()).XI(null);
          break;
        }
        if ((!bk.bl(paramString)) && (e.bK(paramString)) && (!paramBoolean))
        {
          long l = e.aeQ(paramString);
          if (parambi.dQv > l)
          {
            y.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  not download finish content.attachlen > datasize");
            ((xv)paramcj.bIw.bIy.sXc.getLast()).XI(null);
          }
        }
      }
      if ((localObject == null) || (parambi == null)) {
        y.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  (xml == null ) ||(content == null)");
      }
      return false;
    }
  }
  
  public static Bitmap aB(String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    if (bk.bl(paramString)) {
      return null;
    }
    Object localObject = (Bitmap)kbK.get(paramString);
    if (localObject != null)
    {
      y.d("MicroMsg.FavExportLogic", "get bm from cache %s", new Object[] { paramString });
      return localObject;
    }
    if (paramBoolean) {
      return null;
    }
    if (!e.bK(paramString)) {
      return null;
    }
    y.d("MicroMsg.FavExportLogic", "get from cache fail, try to decode from file");
    localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    Bitmap localBitmap = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    if (localBitmap != null)
    {
      y.i("MicroMsg.FavExportLogic", "bitmap recycle %s", new Object[] { localBitmap });
      localBitmap.recycle();
    }
    int j;
    if ((aa.bD(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight)) && (((BitmapFactory.Options)localObject).outWidth > 480))
    {
      i = 1;
      if ((!aa.bC(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight)) || (((BitmapFactory.Options)localObject).outHeight <= 480)) {
        break label227;
      }
      j = 1;
    }
    for (;;)
    {
      label182:
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
            label227:
            j = 0;
            break label182;
          }
        }
        j = Math.max(1, j);
        i = Math.max(1, i);
        y.w("MicroMsg.FavExportLogic", "fit long picture, beg %d*%d, after %d*%d", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject).outHeight), Integer.valueOf(j), Integer.valueOf(i) });
      }
    }
    int i = BackwardSupportUtil.ExifHelper.YS(paramString);
    if ((MMNativeJpeg.IsJpegFile(paramString)) && (MMNativeJpeg.isProgressive(paramString)))
    {
      localObject = MMNativeJpeg.decodeAsBitmap(paramString);
      if (localObject == null)
      {
        paramBoolean = bool;
        y.i("MicroMsg.FavExportLogic", "Progressive jpeg, result isNull:%b", new Object[] { Boolean.valueOf(paramBoolean) });
      }
    }
    for (;;)
    {
      if (localObject != null) {
        break label391;
      }
      y.e("MicroMsg.FavExportLogic", "getSuitableBmp fail, temBmp is null, filePath = " + paramString);
      return null;
      paramBoolean = false;
      break;
      localObject = com.tencent.mm.sdk.platformtools.c.dn(paramString, 0);
    }
    label391:
    localObject = com.tencent.mm.sdk.platformtools.c.b((Bitmap)localObject, i);
    kbK.put(paramString, localObject);
    return localObject;
  }
  
  public static void aRf() {}
  
  public static void aYx()
  {
    kbK = new ab(20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.c
 * JD-Core Version:    0.7.0.1
 */