package com.tencent.mm.plugin.fav.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.view.View;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.dn.a;
import com.tencent.mm.autogen.a.ht;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.b.f;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k.b;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LongBitmapHandler;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.snackbar.a.b;
import com.tencent.mm.ui.widget.snackbar.a.c;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class e
{
  private static f<String, Bitmap> Agu;
  private static Map<String, Integer> vlV;
  
  static
  {
    AppMethodBeat.i(106690);
    Agu = new com.tencent.mm.memory.a.b(20, e.class);
    vlV = new HashMap();
    HashMap localHashMap = new HashMap();
    vlV = localHashMap;
    localHashMap.put("avi", Integer.valueOf(q.h.app_attach_file_icon_video));
    vlV.put("m4v", Integer.valueOf(q.h.app_attach_file_icon_video));
    vlV.put("vob", Integer.valueOf(q.h.app_attach_file_icon_video));
    vlV.put("mpeg", Integer.valueOf(q.h.app_attach_file_icon_video));
    vlV.put("mpe", Integer.valueOf(q.h.app_attach_file_icon_video));
    vlV.put("asx", Integer.valueOf(q.h.app_attach_file_icon_video));
    vlV.put("asf", Integer.valueOf(q.h.app_attach_file_icon_video));
    vlV.put("f4v", Integer.valueOf(q.h.app_attach_file_icon_video));
    vlV.put("flv", Integer.valueOf(q.h.app_attach_file_icon_video));
    vlV.put("mkv", Integer.valueOf(q.h.app_attach_file_icon_video));
    vlV.put("wmv", Integer.valueOf(q.h.app_attach_file_icon_video));
    vlV.put("wm", Integer.valueOf(q.h.app_attach_file_icon_video));
    vlV.put("3gp", Integer.valueOf(q.h.app_attach_file_icon_video));
    vlV.put("mp4", Integer.valueOf(q.h.app_attach_file_icon_video));
    vlV.put("rmvb", Integer.valueOf(q.h.app_attach_file_icon_video));
    vlV.put("rm", Integer.valueOf(q.h.app_attach_file_icon_video));
    vlV.put("ra", Integer.valueOf(q.h.app_attach_file_icon_video));
    vlV.put("ram", Integer.valueOf(q.h.app_attach_file_icon_video));
    vlV.put("mp3pro", Integer.valueOf(q.h.app_attach_file_icon_music));
    vlV.put("vqf", Integer.valueOf(q.h.app_attach_file_icon_music));
    vlV.put("cd", Integer.valueOf(q.h.app_attach_file_icon_music));
    vlV.put("md", Integer.valueOf(q.h.app_attach_file_icon_music));
    vlV.put("mod", Integer.valueOf(q.h.app_attach_file_icon_music));
    vlV.put("vorbis", Integer.valueOf(q.h.app_attach_file_icon_music));
    vlV.put("au", Integer.valueOf(q.h.app_attach_file_icon_music));
    vlV.put("amr", Integer.valueOf(q.h.app_attach_file_icon_music));
    vlV.put("silk", Integer.valueOf(q.h.app_attach_file_icon_music));
    vlV.put("wma", Integer.valueOf(q.h.app_attach_file_icon_music));
    vlV.put("mmf", Integer.valueOf(q.h.app_attach_file_icon_music));
    vlV.put("mid", Integer.valueOf(q.h.app_attach_file_icon_music));
    vlV.put("midi", Integer.valueOf(q.h.app_attach_file_icon_music));
    vlV.put("mp3", Integer.valueOf(q.h.app_attach_file_icon_music));
    vlV.put("aac", Integer.valueOf(q.h.app_attach_file_icon_music));
    vlV.put("ape", Integer.valueOf(q.h.app_attach_file_icon_music));
    vlV.put("aiff", Integer.valueOf(q.h.app_attach_file_icon_music));
    vlV.put("aif", Integer.valueOf(q.h.app_attach_file_icon_music));
    vlV.put("jfif", Integer.valueOf(q.h.app_attach_file_icon_pic));
    vlV.put("tiff", Integer.valueOf(q.h.app_attach_file_icon_pic));
    vlV.put("tif", Integer.valueOf(q.h.app_attach_file_icon_pic));
    vlV.put("jpe", Integer.valueOf(q.h.app_attach_file_icon_pic));
    vlV.put("dib", Integer.valueOf(q.h.app_attach_file_icon_pic));
    vlV.put("jpeg", Integer.valueOf(q.h.app_attach_file_icon_pic));
    vlV.put("jpg", Integer.valueOf(q.h.app_attach_file_icon_pic));
    vlV.put("png", Integer.valueOf(q.h.app_attach_file_icon_pic));
    vlV.put("bmp", Integer.valueOf(q.h.app_attach_file_icon_pic));
    vlV.put("gif", Integer.valueOf(q.h.app_attach_file_icon_pic));
    vlV.put("rar", Integer.valueOf(q.h.app_attach_file_icon_rar));
    vlV.put("zip", Integer.valueOf(q.h.app_attach_file_icon_rar));
    vlV.put("7z", Integer.valueOf(q.h.app_attach_file_icon_rar));
    vlV.put("iso", Integer.valueOf(q.h.app_attach_file_icon_rar));
    vlV.put("cab", Integer.valueOf(q.h.app_attach_file_icon_rar));
    vlV.put("doc", Integer.valueOf(q.h.app_attach_file_icon_word));
    vlV.put("docx", Integer.valueOf(q.h.app_attach_file_icon_word));
    vlV.put("ppt", Integer.valueOf(q.h.app_attach_file_icon_ppt));
    vlV.put("pptx", Integer.valueOf(q.h.app_attach_file_icon_ppt));
    vlV.put("xls", Integer.valueOf(q.h.app_attach_file_icon_excel));
    vlV.put("xlsx", Integer.valueOf(q.h.app_attach_file_icon_excel));
    vlV.put("txt", Integer.valueOf(q.h.app_attach_file_icon_txt));
    vlV.put("rtf", Integer.valueOf(q.h.app_attach_file_icon_txt));
    vlV.put("pdf", Integer.valueOf(q.h.app_attach_file_icon_pdf));
    vlV.put("ofd", Integer.valueOf(q.h.app_attach_file_icon_ofd));
    vlV.put("unknown", Integer.valueOf(q.h.app_attach_file_icon_unknow));
    AppMethodBeat.o(106690);
  }
  
  private static int a(dn paramdn, int paramInt)
  {
    AppMethodBeat.i(106682);
    arf localarf;
    if ((paramdn.hDr.hDt.vEn != null) && (paramdn.hDr.hDt.vEn.size() > 0))
    {
      localarf = (arf)paramdn.hDr.hDt.vEn.getLast();
      if (paramInt <= 0) {
        switch (paramInt)
        {
        default: 
          localarf.axA(0);
        }
      }
    }
    for (;;)
    {
      b(paramdn, paramInt);
      AppMethodBeat.o(106682);
      return paramInt;
      localarf.axA(1);
      localarf.bsC(null);
      continue;
      localarf.axA(2);
      localarf.bsC(null);
    }
  }
  
  private static int a(dn paramdn, arf paramarf, int paramInt)
  {
    AppMethodBeat.i(106683);
    if (paramarf == null)
    {
      paramInt = a(paramdn, paramInt);
      AppMethodBeat.o(106683);
      return paramInt;
    }
    if (paramInt <= 0) {
      switch (paramInt)
      {
      default: 
        paramarf.axA(0);
      }
    }
    for (;;)
    {
      b(paramdn, paramInt);
      AppMethodBeat.o(106683);
      return paramInt;
      paramarf.axA(1);
      paramarf.bsC(null);
      continue;
      paramarf.axA(2);
      paramarf.bsC(null);
    }
  }
  
  public static int a(cc paramcc, dn paramdn, boolean paramBoolean)
  {
    AppMethodBeat.i(106681);
    Object localObject1 = "";
    Log.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo msg type is %d", new Object[] { Integer.valueOf(paramcc.getType()) });
    int i;
    if ((!paramBoolean) && (paramdn.hDr.hDx > 0))
    {
      Log.i("MicroMsg.FavExportLogic", "(!result)&&(favoriteEvent.data.errorType > FavExportLogic.KEY_FAV_PARA_NO_ERROR)");
      i = a(paramdn, paramdn.hDr.hDx);
      AppMethodBeat.o(106681);
      return i;
    }
    if ((paramdn.hDr.type == 4) || (paramdn.hDr.type == 8) || (paramdn.hDr.type == 16) || (paramdn.hDr.type == 2)) {}
    for (paramBoolean = false;; paramBoolean = true)
    {
      boolean bool = paramBoolean;
      arf localarf;
      if (paramdn.hDr.type == 14)
      {
        bool = paramBoolean;
        if (paramdn.hDr.hDt.vEn.size() > 0)
        {
          localarf = (arf)paramdn.hDr.hDt.vEn.getLast();
          if ((localarf.dataType != 4) && (localarf.dataType != 8) && (localarf.dataType != 15))
          {
            bool = paramBoolean;
            if (localarf.dataType != 2) {}
          }
          else
          {
            bool = false;
          }
        }
      }
      if ((paramdn.hDr.type == 14) || (paramdn.hDr.type == 18)) {}
      for (paramBoolean = false;; paramBoolean = true)
      {
        Log.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo msg type skipCheck %B", new Object[] { Boolean.valueOf(bool) });
        if ((bool) || (paramcc.dSI()))
        {
          i = a(paramdn, 0);
          AppMethodBeat.o(106681);
          return i;
        }
        if (paramdn.hDr.hDt == null)
        {
          i = a(paramdn, -1);
          AppMethodBeat.o(106681);
          return i;
        }
        if (paramdn.hDr.hDt.vEn == null)
        {
          i = a(paramdn, -1);
          AppMethodBeat.o(106681);
          return i;
        }
        if (System.currentTimeMillis() - paramcc.getCreateTime() > 259200000L) {}
        for (bool = true;; bool = false)
        {
          Log.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo isOverThreeDays %B", new Object[] { Boolean.valueOf(bool) });
          if (1 <= paramdn.hDr.hDt.vEn.size())
          {
            localarf = (arf)paramdn.hDr.hDt.vEn.getLast();
            localObject1 = localarf.Zzd;
          }
          for (i = localarf.dataType;; i = 0)
          {
            if (localarf == null) {
              Log.w("MicroMsg.FavExportLogic", "dataItem is null, size:" + paramdn.hDr.hDt.vEn.size());
            }
            if (bool)
            {
              if (!Util.isNullOrNil((String)localObject1))
              {
                localObject2 = localObject1;
                if (y.ZC((String)localObject1)) {}
              }
              else
              {
                if ((paramcc != null) && ((paramcc.getType() == 43) || (paramcc.getType() == 44) || (paramcc.getType() == 62)))
                {
                  localObject1 = ab.Qo(paramcc.field_imgPath);
                  if ((localObject1 != null) && (((z)localObject1).pbi == -1))
                  {
                    localObject1 = ((z)localObject1).bOt();
                    if (!y.ZC((String)localObject1)) {}
                  }
                }
                while (Util.isNullOrNil((String)localObject1))
                {
                  i = a(paramdn, localarf, -4);
                  AppMethodBeat.o(106681);
                  return i;
                  localObject1 = null;
                }
                ((arf)paramdn.hDr.hDt.vEn.getLast()).bsC((String)localObject1);
                localObject2 = localObject1;
              }
              if (a(paramcc, paramdn, localObject2, true, paramBoolean, i))
              {
                i = a(paramdn, localarf, -5);
                AppMethodBeat.o(106681);
                return i;
              }
              Log.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  isOverThreeDays true not big not expired");
            }
            while (!a(paramcc, paramdn, (String)localObject1, false, paramBoolean, i))
            {
              Object localObject2;
              Log.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  fav data is normal");
              i = a(paramdn, localarf, 0);
              AppMethodBeat.o(106681);
              return i;
            }
            i = a(paramdn, localarf, -5);
            AppMethodBeat.o(106681);
            return i;
            localarf = null;
          }
        }
      }
    }
  }
  
  private static void a(int paramInt1, int paramInt2, final Activity paramActivity, final Fragment paramFragment, DialogInterface.OnClickListener paramOnClickListener, final a.b paramb, final a.c paramc)
  {
    AppMethodBeat.i(274407);
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
      k.a((Context)localObject, str, "", ((Context)localObject).getString(q.i.plugin_favorite_opt), ((Context)localObject).getString(q.i.confirm_dialog_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(106674);
          paramAnonymousDialogInterface.dismiss();
          if (e.this != null) {
            e.this.onClick(paramAnonymousDialogInterface, -2);
          }
          if (paramFragment != null)
          {
            paramAnonymousDialogInterface = paramFragment.getView();
            if ((paramFragment instanceof MMFragment)) {
              paramAnonymousDialogInterface = ((MMFragment)paramFragment).getContentView();
            }
            com.tencent.mm.ui.widget.snackbar.b.a(paramFragment.getContext(), paramAnonymousDialogInterface, paramFragment.getActivity().getString(q.i.favorite_ok), paramFragment.getActivity().getString(q.i.favorite_add_tag_tips), paramb, paramc);
            AppMethodBeat.o(106674);
            return;
          }
          com.tencent.mm.ui.widget.snackbar.b.a(paramActivity, paramActivity.getString(q.i.favorite_ok), paramActivity.getString(q.i.favorite_add_tag_tips), paramb, paramc);
          AppMethodBeat.o(106674);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(106675);
          paramAnonymousDialogInterface.dismiss();
          if (e.this != null) {
            e.this.onClick(paramAnonymousDialogInterface, -1);
          }
          AppMethodBeat.o(106675);
        }
      }, q.b.wechat_green);
      AppMethodBeat.o(274407);
      return;
      localObject = paramFragment.getActivity();
      break;
      str = ((Context)localObject).getString(q.i.favorite_expired_image);
      continue;
      str = ((Context)localObject).getString(q.i.favorite_expired_file);
      continue;
      str = ((Context)localObject).getString(q.i.favorite_expired_video);
      continue;
      str = ((Context)localObject).getString(q.i.favorite_fail_record_expired);
      continue;
      label199:
      if (paramInt2 == -5)
      {
        if (paramInt1 != 14)
        {
          if (paramInt1 == 2) {
            str = ((Context)localObject).getString(q.i.favorite_big_file, new Object[] { Integer.valueOf(((ah)h.az(ah.class)).getImageSizeLimitInMB(true)) });
          } else if (paramInt1 == 4) {
            str = ((Context)localObject).getString(q.i.favorite_big_file, new Object[] { Integer.valueOf(((ah)h.az(ah.class)).getVideoSizeLimitInMB(true)) });
          } else {
            str = ((Context)localObject).getString(q.i.favorite_big_file, new Object[] { Integer.valueOf(((ah)h.az(ah.class)).getFileSizeLimitInMB(true)) });
          }
        }
        else {
          str = ((Context)localObject).getString(q.i.favorite_fail_record_bigfile);
        }
      }
      else if (paramInt2 == -6)
      {
        str = ((Context)localObject).getString(q.i.favorite_fail_record_expired);
      }
      else if (paramInt2 == -7)
      {
        str = ((Context)localObject).getString(q.i.favorite_fail_record_bigfile);
      }
      else if (paramInt2 == -8)
      {
        str = ((Context)localObject).getString(q.i.favorite_fail_record_expired_bigfile);
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
            com.tencent.mm.ui.widget.snackbar.b.a(paramFragment.getContext(), paramActivity, ((Context)localObject).getString(q.i.favorite_ok), ((Context)localObject).getString(q.i.favorite_add_tag_tips), paramb, paramc);
            AppMethodBeat.o(274407);
            return;
          }
          com.tencent.mm.ui.widget.snackbar.b.a(paramActivity, ((Context)localObject).getString(q.i.favorite_ok), ((Context)localObject).getString(q.i.favorite_add_tag_tips), paramb, paramc);
          AppMethodBeat.o(274407);
          return;
        }
        str = ((Context)localObject).getString(q.i.favorite_fail_argument_error);
      }
    }
  }
  
  public static void a(int paramInt1, int paramInt2, Activity paramActivity, Fragment paramFragment, View paramView, a.c paramc, DialogInterface.OnClickListener paramOnClickListener, a.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(274404);
    if ((paramActivity == null) && (paramFragment == null) && (paramView == null))
    {
      Log.e("MicroMsg.FavExportLogic", "handleErrorType activity = null && fragment = null");
      AppMethodBeat.o(274404);
      return;
    }
    if (paramb == null) {
      paramb = new a.b()
      {
        public final void onMessageClick()
        {
          AppMethodBeat.i(106670);
          ht localht = new ht();
          localht.hIR.type = 35;
          localht.publish();
          AppMethodBeat.o(106670);
        }
      };
    }
    for (;;)
    {
      if (paramInt2 == 0)
      {
        if (paramBoolean)
        {
          if (paramFragment != null)
          {
            paramActivity = paramFragment.getView();
            if ((paramFragment instanceof MMFragment)) {
              paramActivity = ((MMFragment)paramFragment).getContentView();
            }
            com.tencent.mm.ui.widget.snackbar.b.a(paramFragment.getContext(), paramActivity, paramFragment.getString(q.i.favorite_ok), paramFragment.getString(q.i.favorite_add_tag_tips), paramb, paramc);
            AppMethodBeat.o(274404);
            return;
          }
          if (paramView != null)
          {
            if (paramActivity != null) {}
            for (;;)
            {
              com.tencent.mm.ui.widget.snackbar.b.a(paramActivity, paramView, paramActivity.getString(q.i.favorite_ok), paramActivity.getString(q.i.favorite_add_tag_tips), paramb, paramc);
              AppMethodBeat.o(274404);
              return;
              paramActivity = paramView.getContext();
            }
          }
          if (paramActivity != null)
          {
            com.tencent.mm.ui.widget.snackbar.b.a(paramActivity, paramActivity.getString(q.i.favorite_ok), paramActivity.getString(q.i.favorite_add_tag_tips), paramb, paramc);
            AppMethodBeat.o(274404);
          }
        }
      }
      else {
        if (paramActivity != null) {
          break label477;
        }
      }
      label477:
      for (paramView = paramFragment.getActivity();; paramView = paramActivity)
      {
        switch (paramInt2)
        {
        case -3: 
        default: 
          if (paramInt2 == q.i.favorite_too_large_format) {
            if (paramInt1 == 2) {
              paramActivity = paramView.getString(q.i.favorite_too_large_format, new Object[] { Integer.valueOf(((ah)h.az(ah.class)).getImageSizeLimitInMB(true)) });
            }
          }
          break;
        }
        for (;;)
        {
          k.d(paramView, paramActivity, "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(106671);
              if (e.this != null) {
                e.this.onClick(paramAnonymousDialogInterface, -1);
              }
              AppMethodBeat.o(106671);
            }
          });
          AppMethodBeat.o(274404);
          return;
          g(paramView, paramOnClickListener);
          AppMethodBeat.o(274404);
          return;
          a(paramInt1, paramInt2, paramView, paramFragment, paramOnClickListener, paramb, paramc);
          AppMethodBeat.o(274404);
          return;
          a(paramView, paramFragment);
          AppMethodBeat.o(274404);
          return;
          if ((paramInt1 == 4) || (paramInt1 == 16))
          {
            paramActivity = paramView.getString(q.i.favorite_too_large_format, new Object[] { Integer.valueOf(((ah)h.az(ah.class)).getVideoSizeLimitInMB(true)) });
          }
          else
          {
            paramActivity = paramView.getString(q.i.favorite_too_large_format, new Object[] { Integer.valueOf(((ah)h.az(ah.class)).getFileSizeLimitInMB(true)) });
            continue;
            paramActivity = paramView.getString(q.i.favorite_too_large);
          }
        }
      }
    }
  }
  
  public static void a(int paramInt, Activity paramActivity, a.b paramb)
  {
    AppMethodBeat.i(106676);
    a(paramInt, paramActivity, null, null, paramb);
    AppMethodBeat.o(106676);
  }
  
  public static void a(int paramInt, Activity paramActivity, a.c paramc, DialogInterface.OnClickListener paramOnClickListener, a.b paramb)
  {
    AppMethodBeat.i(274400);
    a(-1, paramInt, paramActivity, null, null, paramc, paramOnClickListener, paramb, true);
    AppMethodBeat.o(274400);
  }
  
  private static void a(Activity paramActivity, Fragment paramFragment)
  {
    AppMethodBeat.i(274406);
    if (paramFragment != null) {
      paramActivity = paramFragment.getActivity();
    }
    aa.makeText(paramActivity, q.i.favorite_fail_open_im_withdown_download, 0).show();
    AppMethodBeat.o(274406);
  }
  
  private static boolean a(cc paramcc, dn paramdn, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(106684);
    Object localObject;
    if (!Util.isNullOrNil(paramString))
    {
      localObject = new u(paramString);
      if (((u)localObject).jKS())
      {
        if (((u)localObject).length() > ((ah)h.az(ah.class)).getFavSizeLimit(paramBoolean2, paramInt))
        {
          Log.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file is big");
          AppMethodBeat.o(106684);
          return true;
        }
        Log.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file not big");
      }
    }
    else
    {
      localObject = paramcc.field_content;
      if (localObject == null) {
        break label281;
      }
    }
    label281:
    for (paramcc = k.b.aP((String)localObject, paramcc.field_reserved);; paramcc = null)
    {
      if (paramcc != null)
      {
        if (paramcc.nRd > ((ah)h.az(ah.class)).getFavSizeLimit(paramBoolean2, paramInt))
        {
          Log.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file is big");
          AppMethodBeat.o(106684);
          return true;
          if (paramBoolean1) {
            break;
          }
          Log.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  not download finish ！attachFile.exists()");
          ((arf)paramdn.hDr.hDt.vEn.getLast()).bsC(null);
          break;
        }
        if ((!Util.isNullOrNil(paramString)) && (y.ZC(paramString)) && (!paramBoolean1))
        {
          long l = y.bEl(paramString);
          if (paramcc.nRd > l)
          {
            Log.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  not download finish content.attachlen > datasize");
            ((arf)paramdn.hDr.hDt.vEn.getLast()).bsC(null);
          }
        }
      }
      if ((localObject == null) || (paramcc == null)) {
        Log.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  (xml == null ) ||(content == null)");
      }
      AppMethodBeat.o(106684);
      return false;
    }
  }
  
  public static int aut(String paramString)
  {
    AppMethodBeat.i(106688);
    paramString = (Integer)vlV.get(paramString);
    if (paramString == null)
    {
      i = ((Integer)vlV.get("unknown")).intValue();
      AppMethodBeat.o(106688);
      return i;
    }
    int i = paramString.intValue();
    AppMethodBeat.o(106688);
    return i;
  }
  
  public static Bitmap auu(String paramString)
  {
    AppMethodBeat.i(106689);
    Bitmap localBitmap = null;
    if (d.rb(8)) {
      localBitmap = BitmapUtil.createVideoThumbnail(paramString, 1);
    }
    AppMethodBeat.o(106689);
    return localBitmap;
  }
  
  private static void b(dn paramdn, int paramInt)
  {
    AppMethodBeat.i(106685);
    if ((paramdn.hDr.hDt.vEn == null) || (paramdn.hDr.hDt.vEn.size() == 0))
    {
      paramdn.hDr.hDx = paramInt;
      AppMethodBeat.o(106685);
      return;
    }
    if (paramdn.hDr.hDx == -9)
    {
      AppMethodBeat.o(106685);
      return;
    }
    if ((paramInt > 0) || (paramdn.hDr.hDx > 0)) {}
    for (int i = 1;; i = 0)
    {
      int k = 0;
      int n = 0;
      int m = 0;
      int j = 0;
      if (k < paramdn.hDr.hDt.vEn.size())
      {
        switch (((arf)paramdn.hDr.hDt.vEn.get(k)).ZzM)
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
          paramdn.hDr.hDx = -9;
          AppMethodBeat.o(106685);
          return;
        }
        paramdn.hDr.hDx = paramInt;
        AppMethodBeat.o(106685);
        return;
      }
      if (m > 0)
      {
        if (n > 0)
        {
          paramdn.hDr.hDx = -8;
          AppMethodBeat.o(106685);
          return;
        }
        if (j == 0)
        {
          paramdn.hDr.hDx = -5;
          AppMethodBeat.o(106685);
          return;
        }
        if (j > 0)
        {
          paramdn.hDr.hDx = -7;
          AppMethodBeat.o(106685);
          return;
        }
        AppMethodBeat.o(106685);
        return;
      }
      if (n > 0)
      {
        if (j == 0)
        {
          paramdn.hDr.hDx = -4;
          AppMethodBeat.o(106685);
          return;
        }
        if (j > 0)
        {
          paramdn.hDr.hDx = -6;
          AppMethodBeat.o(106685);
          return;
        }
      }
      AppMethodBeat.o(106685);
      return;
    }
  }
  
  public static Bitmap bs(String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(106687);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(106687);
      return null;
    }
    Object localObject = (Bitmap)Agu.get(paramString);
    if (localObject != null)
    {
      Log.d("MicroMsg.FavExportLogic", "get bm from cache %s", new Object[] { paramString });
      AppMethodBeat.o(106687);
      return localObject;
    }
    if (paramBoolean)
    {
      AppMethodBeat.o(106687);
      return null;
    }
    if (!y.ZC(paramString))
    {
      AppMethodBeat.o(106687);
      return null;
    }
    Log.d("MicroMsg.FavExportLogic", "get from cache fail, try to decode from file");
    localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    Bitmap localBitmap = MMBitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    if (localBitmap != null)
    {
      Log.i("MicroMsg.FavExportLogic", "bitmap recycle %s", new Object[] { localBitmap });
      localBitmap.recycle();
    }
    int j;
    if ((LongBitmapHandler.isLongHorizontal(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight)) && (((BitmapFactory.Options)localObject).outWidth > 480))
    {
      i = 1;
      if ((!LongBitmapHandler.isLongVertical(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight)) || (((BitmapFactory.Options)localObject).outHeight <= 480)) {
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
        Log.w("MicroMsg.FavExportLogic", "fit long picture, beg %d*%d, after %d*%d", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject).outHeight), Integer.valueOf(j), Integer.valueOf(i) });
      }
    }
    int i = BackwardSupportUtil.ExifHelper.getExifOrientation(paramString);
    if ((MMNativeJpeg.IsJpegFile(paramString)) && (MMNativeJpeg.isProgressive(paramString)))
    {
      localObject = MMNativeJpeg.decodeAsBitmap(paramString);
      if (localObject == null)
      {
        paramBoolean = bool;
        Log.i("MicroMsg.FavExportLogic", "Progressive jpeg, result isNull:%b", new Object[] { Boolean.valueOf(paramBoolean) });
      }
    }
    for (;;)
    {
      if (localObject != null) {
        break label421;
      }
      Log.e("MicroMsg.FavExportLogic", "getSuitableBmp fail, temBmp is null, filePath = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(106687);
      return null;
      paramBoolean = false;
      break;
      localObject = BitmapUtil.decodeFileWithSample(paramString);
    }
    label421:
    localObject = BitmapUtil.rotate((Bitmap)localObject, i);
    if (((Bitmap)localObject).getByteCount() > 20971520)
    {
      AppMethodBeat.o(106687);
      return localObject;
    }
    Agu.put(paramString, localObject);
    AppMethodBeat.o(106687);
    return localObject;
  }
  
  public static void dRE()
  {
    AppMethodBeat.i(106686);
    Agu = new com.tencent.mm.memory.a.b(20, e.class);
    AppMethodBeat.o(106686);
  }
  
  public static void dRF() {}
  
  private static void g(Context paramContext, final DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(106679);
    k.a(paramContext, paramContext.getString(q.i.favorite_fail_clean_alert_content), paramContext.getString(q.i.favorite_fail_clean_alert_title), paramContext.getString(q.i.favorite_fail_fav_clean), paramContext.getString(q.i.confirm_dialog_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(106672);
        Intent localIntent = new Intent();
        localIntent.putExtra("key_enter_fav_cleanui_from", 3);
        com.tencent.mm.plugin.fav.a.b.b(e.this, ".ui.FavCleanUI", localIntent);
        paramAnonymousDialogInterface.dismiss();
        if (paramOnClickListener != null) {
          paramOnClickListener.onClick(paramAnonymousDialogInterface, -2);
        }
        AppMethodBeat.o(106672);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(106673);
        paramAnonymousDialogInterface.dismiss();
        if (e.this != null) {
          e.this.onClick(paramAnonymousDialogInterface, -1);
        }
        AppMethodBeat.o(106673);
      }
    }, q.b.wechat_green);
    AppMethodBeat.o(106679);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e
 * JD-Core Version:    0.7.0.1
 */