package com.tencent.mm.plugin.fav.ui;

import android.annotation.TargetApi;
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
import com.tencent.mm.aj.k.b;
import com.tencent.mm.b.f;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.dd.a;
import com.tencent.mm.f.a.hi;
import com.tencent.mm.f.c.et;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.modelvideo.y;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LongBitmapHandler;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.widget.snackbar.a.b;
import com.tencent.mm.ui.widget.snackbar.a.c;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class e
{
  private static Map<String, Integer> saE;
  private static f<String, Bitmap> wJX;
  
  static
  {
    AppMethodBeat.i(106690);
    wJX = new com.tencent.mm.memory.a.b(20, e.class);
    saE = new HashMap();
    HashMap localHashMap = new HashMap();
    saE = localHashMap;
    localHashMap.put("avi", Integer.valueOf(s.h.app_attach_file_icon_video));
    saE.put("m4v", Integer.valueOf(s.h.app_attach_file_icon_video));
    saE.put("vob", Integer.valueOf(s.h.app_attach_file_icon_video));
    saE.put("mpeg", Integer.valueOf(s.h.app_attach_file_icon_video));
    saE.put("mpe", Integer.valueOf(s.h.app_attach_file_icon_video));
    saE.put("asx", Integer.valueOf(s.h.app_attach_file_icon_video));
    saE.put("asf", Integer.valueOf(s.h.app_attach_file_icon_video));
    saE.put("f4v", Integer.valueOf(s.h.app_attach_file_icon_video));
    saE.put("flv", Integer.valueOf(s.h.app_attach_file_icon_video));
    saE.put("mkv", Integer.valueOf(s.h.app_attach_file_icon_video));
    saE.put("wmv", Integer.valueOf(s.h.app_attach_file_icon_video));
    saE.put("wm", Integer.valueOf(s.h.app_attach_file_icon_video));
    saE.put("3gp", Integer.valueOf(s.h.app_attach_file_icon_video));
    saE.put("mp4", Integer.valueOf(s.h.app_attach_file_icon_video));
    saE.put("rmvb", Integer.valueOf(s.h.app_attach_file_icon_video));
    saE.put("rm", Integer.valueOf(s.h.app_attach_file_icon_video));
    saE.put("ra", Integer.valueOf(s.h.app_attach_file_icon_video));
    saE.put("ram", Integer.valueOf(s.h.app_attach_file_icon_video));
    saE.put("mp3pro", Integer.valueOf(s.h.app_attach_file_icon_music));
    saE.put("vqf", Integer.valueOf(s.h.app_attach_file_icon_music));
    saE.put("cd", Integer.valueOf(s.h.app_attach_file_icon_music));
    saE.put("md", Integer.valueOf(s.h.app_attach_file_icon_music));
    saE.put("mod", Integer.valueOf(s.h.app_attach_file_icon_music));
    saE.put("vorbis", Integer.valueOf(s.h.app_attach_file_icon_music));
    saE.put("au", Integer.valueOf(s.h.app_attach_file_icon_music));
    saE.put("amr", Integer.valueOf(s.h.app_attach_file_icon_music));
    saE.put("silk", Integer.valueOf(s.h.app_attach_file_icon_music));
    saE.put("wma", Integer.valueOf(s.h.app_attach_file_icon_music));
    saE.put("mmf", Integer.valueOf(s.h.app_attach_file_icon_music));
    saE.put("mid", Integer.valueOf(s.h.app_attach_file_icon_music));
    saE.put("midi", Integer.valueOf(s.h.app_attach_file_icon_music));
    saE.put("mp3", Integer.valueOf(s.h.app_attach_file_icon_music));
    saE.put("aac", Integer.valueOf(s.h.app_attach_file_icon_music));
    saE.put("ape", Integer.valueOf(s.h.app_attach_file_icon_music));
    saE.put("aiff", Integer.valueOf(s.h.app_attach_file_icon_music));
    saE.put("aif", Integer.valueOf(s.h.app_attach_file_icon_music));
    saE.put("jfif", Integer.valueOf(s.h.app_attach_file_icon_pic));
    saE.put("tiff", Integer.valueOf(s.h.app_attach_file_icon_pic));
    saE.put("tif", Integer.valueOf(s.h.app_attach_file_icon_pic));
    saE.put("jpe", Integer.valueOf(s.h.app_attach_file_icon_pic));
    saE.put("dib", Integer.valueOf(s.h.app_attach_file_icon_pic));
    saE.put("jpeg", Integer.valueOf(s.h.app_attach_file_icon_pic));
    saE.put("jpg", Integer.valueOf(s.h.app_attach_file_icon_pic));
    saE.put("png", Integer.valueOf(s.h.app_attach_file_icon_pic));
    saE.put("bmp", Integer.valueOf(s.h.app_attach_file_icon_pic));
    saE.put("gif", Integer.valueOf(s.h.app_attach_file_icon_pic));
    saE.put("rar", Integer.valueOf(s.h.app_attach_file_icon_rar));
    saE.put("zip", Integer.valueOf(s.h.app_attach_file_icon_rar));
    saE.put("7z", Integer.valueOf(s.h.app_attach_file_icon_rar));
    saE.put("iso", Integer.valueOf(s.h.app_attach_file_icon_rar));
    saE.put("cab", Integer.valueOf(s.h.app_attach_file_icon_rar));
    saE.put("doc", Integer.valueOf(s.h.app_attach_file_icon_word));
    saE.put("docx", Integer.valueOf(s.h.app_attach_file_icon_word));
    saE.put("ppt", Integer.valueOf(s.h.app_attach_file_icon_ppt));
    saE.put("pptx", Integer.valueOf(s.h.app_attach_file_icon_ppt));
    saE.put("xls", Integer.valueOf(s.h.app_attach_file_icon_excel));
    saE.put("xlsx", Integer.valueOf(s.h.app_attach_file_icon_excel));
    saE.put("txt", Integer.valueOf(s.h.app_attach_file_icon_txt));
    saE.put("rtf", Integer.valueOf(s.h.app_attach_file_icon_txt));
    saE.put("pdf", Integer.valueOf(s.h.app_attach_file_icon_pdf));
    saE.put("unknown", Integer.valueOf(s.h.app_attach_file_icon_unknow));
    AppMethodBeat.o(106690);
  }
  
  private static int a(dd paramdd, int paramInt)
  {
    AppMethodBeat.i(106682);
    anm localanm;
    if ((paramdd.fyI.fyK.syG != null) && (paramdd.fyI.fyK.syG.size() > 0))
    {
      localanm = (anm)paramdd.fyI.fyK.syG.getLast();
      if (paramInt <= 0) {
        switch (paramInt)
        {
        default: 
          localanm.ars(0);
        }
      }
    }
    for (;;)
    {
      b(paramdd, paramInt);
      AppMethodBeat.o(106682);
      return paramInt;
      localanm.ars(1);
      localanm.bsL(null);
      continue;
      localanm.ars(2);
      localanm.bsL(null);
    }
  }
  
  private static int a(dd paramdd, anm paramanm, int paramInt)
  {
    AppMethodBeat.i(106683);
    if (paramanm == null)
    {
      paramInt = a(paramdd, paramInt);
      AppMethodBeat.o(106683);
      return paramInt;
    }
    if (paramInt <= 0) {
      switch (paramInt)
      {
      default: 
        paramanm.ars(0);
      }
    }
    for (;;)
    {
      b(paramdd, paramInt);
      AppMethodBeat.o(106683);
      return paramInt;
      paramanm.ars(1);
      paramanm.bsL(null);
      continue;
      paramanm.ars(2);
      paramanm.bsL(null);
    }
  }
  
  public static int a(ca paramca, dd paramdd, boolean paramBoolean)
  {
    AppMethodBeat.i(106681);
    Object localObject1 = "";
    Log.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo msg type is %d", new Object[] { Integer.valueOf(paramca.getType()) });
    int i;
    if ((!paramBoolean) && (paramdd.fyI.fyO > 0))
    {
      Log.i("MicroMsg.FavExportLogic", "(!result)&&(favoriteEvent.data.errorType > FavExportLogic.KEY_FAV_PARA_NO_ERROR)");
      i = a(paramdd, paramdd.fyI.fyO);
      AppMethodBeat.o(106681);
      return i;
    }
    if ((paramdd.fyI.type == 4) || (paramdd.fyI.type == 8) || (paramdd.fyI.type == 16) || (paramdd.fyI.type == 2)) {}
    for (paramBoolean = false;; paramBoolean = true)
    {
      boolean bool = paramBoolean;
      anm localanm;
      if (paramdd.fyI.type == 14)
      {
        bool = paramBoolean;
        if (paramdd.fyI.fyK.syG.size() > 0)
        {
          localanm = (anm)paramdd.fyI.fyK.syG.getLast();
          if ((localanm.dataType != 4) && (localanm.dataType != 8) && (localanm.dataType != 15))
          {
            bool = paramBoolean;
            if (localanm.dataType != 2) {}
          }
          else
          {
            bool = false;
          }
        }
      }
      if ((paramdd.fyI.type == 14) || (paramdd.fyI.type == 18)) {}
      for (paramBoolean = false;; paramBoolean = true)
      {
        Log.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo msg type skipCheck %B", new Object[] { Boolean.valueOf(bool) });
        if ((bool) || (paramca.dlS()))
        {
          i = a(paramdd, 0);
          AppMethodBeat.o(106681);
          return i;
        }
        if (paramdd.fyI.fyK == null)
        {
          i = a(paramdd, -1);
          AppMethodBeat.o(106681);
          return i;
        }
        if (paramdd.fyI.fyK.syG == null)
        {
          i = a(paramdd, -1);
          AppMethodBeat.o(106681);
          return i;
        }
        if (System.currentTimeMillis() - paramca.field_createTime > 259200000L) {}
        for (bool = true;; bool = false)
        {
          Log.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo isOverThreeDays %B", new Object[] { Boolean.valueOf(bool) });
          if (1 <= paramdd.fyI.fyK.syG.size())
          {
            localanm = (anm)paramdd.fyI.fyK.syG.getLast();
            localObject1 = localanm.Syl;
          }
          for (i = localanm.dataType;; i = 0)
          {
            if (localanm == null) {
              Log.w("MicroMsg.FavExportLogic", "dataItem is null, size:" + paramdd.fyI.fyK.syG.size());
            }
            if (bool)
            {
              if (!Util.isNullOrNil((String)localObject1))
              {
                localObject2 = localObject1;
                if (u.agG((String)localObject1)) {}
              }
              else
              {
                if ((paramca != null) && ((paramca.getType() == 43) || (paramca.getType() == 44) || (paramca.getType() == 62)))
                {
                  localObject1 = y.Yk(paramca.field_imgPath);
                  if ((localObject1 != null) && (((com.tencent.mm.modelvideo.w)localObject1).mhX == -1))
                  {
                    localObject1 = ((com.tencent.mm.modelvideo.w)localObject1).bqN();
                    if (!u.agG((String)localObject1)) {}
                  }
                }
                while (Util.isNullOrNil((String)localObject1))
                {
                  i = a(paramdd, localanm, -4);
                  AppMethodBeat.o(106681);
                  return i;
                  localObject1 = null;
                }
                ((anm)paramdd.fyI.fyK.syG.getLast()).bsL((String)localObject1);
                localObject2 = localObject1;
              }
              if (a(paramca, paramdd, localObject2, true, paramBoolean, i))
              {
                i = a(paramdd, localanm, -5);
                AppMethodBeat.o(106681);
                return i;
              }
              Log.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  isOverThreeDays true not big not expired");
            }
            while (!a(paramca, paramdd, (String)localObject1, false, paramBoolean, i))
            {
              Object localObject2;
              Log.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  fav data is normal");
              i = a(paramdd, localanm, 0);
              AppMethodBeat.o(106681);
              return i;
            }
            i = a(paramdd, localanm, -5);
            AppMethodBeat.o(106681);
            return i;
            localanm = null;
          }
        }
      }
    }
  }
  
  private static void a(int paramInt1, int paramInt2, final Activity paramActivity, final Fragment paramFragment, DialogInterface.OnClickListener paramOnClickListener, final a.b paramb, final a.c paramc)
  {
    AppMethodBeat.i(229431);
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
      com.tencent.mm.ui.base.h.a((Context)localObject, str, "", ((Context)localObject).getString(s.i.plugin_favorite_opt), ((Context)localObject).getString(s.i.confirm_dialog_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(106674);
          paramAnonymousDialogInterface.dismiss();
          if (this.wJZ != null) {
            this.wJZ.onClick(paramAnonymousDialogInterface, -2);
          }
          if (paramFragment != null)
          {
            paramAnonymousDialogInterface = paramFragment.getView();
            if ((paramFragment instanceof MMFragment)) {
              paramAnonymousDialogInterface = ((MMFragment)paramFragment).getContentView();
            }
            com.tencent.mm.ui.widget.snackbar.b.a(paramFragment.getContext(), paramAnonymousDialogInterface, paramFragment.getActivity().getString(s.i.favorite_ok), paramFragment.getActivity().getString(s.i.favorite_add_tag_tips), paramb, paramc);
            AppMethodBeat.o(106674);
            return;
          }
          com.tencent.mm.ui.widget.snackbar.b.a(paramActivity, paramActivity.getString(s.i.favorite_ok), paramActivity.getString(s.i.favorite_add_tag_tips), paramb, paramc);
          AppMethodBeat.o(106674);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(106675);
          paramAnonymousDialogInterface.dismiss();
          if (this.wJZ != null) {
            this.wJZ.onClick(paramAnonymousDialogInterface, -1);
          }
          AppMethodBeat.o(106675);
        }
      }, s.b.wechat_green);
      AppMethodBeat.o(229431);
      return;
      localObject = paramFragment.getActivity();
      break;
      str = ((Context)localObject).getString(s.i.favorite_expired_image);
      continue;
      str = ((Context)localObject).getString(s.i.favorite_expired_file);
      continue;
      str = ((Context)localObject).getString(s.i.favorite_expired_video);
      continue;
      str = ((Context)localObject).getString(s.i.favorite_fail_record_expired);
      continue;
      label199:
      if (paramInt2 == -5)
      {
        if (paramInt1 != 14)
        {
          if (paramInt1 == 2) {
            str = ((Context)localObject).getString(s.i.favorite_big_file, new Object[] { Integer.valueOf(((ag)com.tencent.mm.kernel.h.ag(ag.class)).getImageSizeLimitInMB(true)) });
          } else if (paramInt1 == 4) {
            str = ((Context)localObject).getString(s.i.favorite_big_file, new Object[] { Integer.valueOf(((ag)com.tencent.mm.kernel.h.ag(ag.class)).getVideoSizeLimitInMB(true)) });
          } else {
            str = ((Context)localObject).getString(s.i.favorite_big_file, new Object[] { Integer.valueOf(((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFileSizeLimitInMB(true)) });
          }
        }
        else {
          str = ((Context)localObject).getString(s.i.favorite_fail_record_bigfile);
        }
      }
      else if (paramInt2 == -6)
      {
        str = ((Context)localObject).getString(s.i.favorite_fail_record_expired);
      }
      else if (paramInt2 == -7)
      {
        str = ((Context)localObject).getString(s.i.favorite_fail_record_bigfile);
      }
      else if (paramInt2 == -8)
      {
        str = ((Context)localObject).getString(s.i.favorite_fail_record_expired_bigfile);
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
            com.tencent.mm.ui.widget.snackbar.b.a(paramFragment.getContext(), paramActivity, ((Context)localObject).getString(s.i.favorite_ok), ((Context)localObject).getString(s.i.favorite_add_tag_tips), paramb, paramc);
            AppMethodBeat.o(229431);
            return;
          }
          com.tencent.mm.ui.widget.snackbar.b.a(paramActivity, ((Context)localObject).getString(s.i.favorite_ok), ((Context)localObject).getString(s.i.favorite_add_tag_tips), paramb, paramc);
          AppMethodBeat.o(229431);
          return;
        }
        str = ((Context)localObject).getString(s.i.favorite_fail_argument_error);
      }
    }
  }
  
  public static void a(int paramInt1, int paramInt2, Activity paramActivity, Fragment paramFragment, View paramView, a.c paramc, DialogInterface.OnClickListener paramOnClickListener, a.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(229419);
    if ((paramActivity == null) && (paramFragment == null) && (paramView == null))
    {
      Log.e("MicroMsg.FavExportLogic", "handleErrorType activity = null && fragment = null");
      AppMethodBeat.o(229419);
      return;
    }
    if (paramb == null) {
      paramb = new a.b()
      {
        public final void bPM()
        {
          AppMethodBeat.i(106670);
          hi localhi = new hi();
          localhi.fEb.type = 35;
          EventCenter.instance.publish(localhi);
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
            com.tencent.mm.ui.widget.snackbar.b.a(paramFragment.getContext(), paramActivity, paramFragment.getString(s.i.favorite_ok), paramFragment.getString(s.i.favorite_add_tag_tips), paramb, paramc);
            AppMethodBeat.o(229419);
            return;
          }
          if (paramActivity != null)
          {
            com.tencent.mm.ui.widget.snackbar.b.a(paramActivity, paramActivity.getString(s.i.favorite_ok), paramActivity.getString(s.i.favorite_add_tag_tips), paramb, paramc);
            AppMethodBeat.o(229419);
            return;
          }
          if (paramView != null)
          {
            paramActivity = paramView.getContext();
            com.tencent.mm.ui.widget.snackbar.b.a(paramActivity, paramView, paramActivity.getString(s.i.favorite_ok), paramActivity.getString(s.i.favorite_add_tag_tips), paramb, paramc);
            AppMethodBeat.o(229419);
          }
        }
      }
      else {
        if (paramActivity != null) {
          break label469;
        }
      }
      label469:
      for (paramView = paramFragment.getActivity();; paramView = paramActivity)
      {
        switch (paramInt2)
        {
        case -3: 
        default: 
          if (paramInt2 == s.i.favorite_too_large_format) {
            if (paramInt1 == 2) {
              paramActivity = paramView.getString(s.i.favorite_too_large_format, new Object[] { Integer.valueOf(((ag)com.tencent.mm.kernel.h.ag(ag.class)).getImageSizeLimitInMB(true)) });
            }
          }
          break;
        }
        for (;;)
        {
          com.tencent.mm.ui.base.h.d(paramView, paramActivity, "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(106671);
              if (this.wJY != null) {
                this.wJY.onClick(paramAnonymousDialogInterface, -1);
              }
              AppMethodBeat.o(106671);
            }
          });
          AppMethodBeat.o(229419);
          return;
          f(paramView, paramOnClickListener);
          AppMethodBeat.o(229419);
          return;
          a(paramInt1, paramInt2, paramView, paramFragment, paramOnClickListener, paramb, paramc);
          AppMethodBeat.o(229419);
          return;
          a(paramView, paramFragment);
          AppMethodBeat.o(229419);
          return;
          if ((paramInt1 == 4) || (paramInt1 == 16))
          {
            paramActivity = paramView.getString(s.i.favorite_too_large_format, new Object[] { Integer.valueOf(((ag)com.tencent.mm.kernel.h.ag(ag.class)).getVideoSizeLimitInMB(true)) });
          }
          else
          {
            paramActivity = paramView.getString(s.i.favorite_too_large_format, new Object[] { Integer.valueOf(((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFileSizeLimitInMB(true)) });
            continue;
            paramActivity = paramView.getString(s.i.favorite_too_large);
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
    AppMethodBeat.i(229404);
    a(-1, paramInt, paramActivity, null, null, paramc, paramOnClickListener, paramb, true);
    AppMethodBeat.o(229404);
  }
  
  private static void a(Activity paramActivity, Fragment paramFragment)
  {
    AppMethodBeat.i(229423);
    if (paramFragment != null) {
      paramActivity = paramFragment.getActivity();
    }
    com.tencent.mm.ui.base.w.makeText(paramActivity, s.i.favorite_fail_open_im_withdown_download, 0).show();
    AppMethodBeat.o(229423);
  }
  
  private static boolean a(ca paramca, dd paramdd, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(106684);
    Object localObject;
    if (!Util.isNullOrNil(paramString))
    {
      localObject = new q(paramString);
      if (((q)localObject).ifE())
      {
        if (((q)localObject).length() > ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavSizeLimit(paramBoolean2, paramInt))
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
      localObject = paramca.field_content;
      if (localObject == null) {
        break label281;
      }
    }
    label281:
    for (paramca = k.b.aG((String)localObject, paramca.field_reserved);; paramca = null)
    {
      if (paramca != null)
      {
        if (paramca.llX > ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavSizeLimit(paramBoolean2, paramInt))
        {
          Log.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file is big");
          AppMethodBeat.o(106684);
          return true;
          if (paramBoolean1) {
            break;
          }
          Log.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  not download finish ！attachFile.exists()");
          ((anm)paramdd.fyI.fyK.syG.getLast()).bsL(null);
          break;
        }
        if ((!Util.isNullOrNil(paramString)) && (u.agG(paramString)) && (!paramBoolean1))
        {
          long l = u.bBQ(paramString);
          if (paramca.llX > l)
          {
            Log.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  not download finish content.attachlen > datasize");
            ((anm)paramdd.fyI.fyK.syG.getLast()).bsL(null);
          }
        }
      }
      if ((localObject == null) || (paramca == null)) {
        Log.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  (xml == null ) ||(content == null)");
      }
      AppMethodBeat.o(106684);
      return false;
    }
  }
  
  public static int aAm(String paramString)
  {
    AppMethodBeat.i(106688);
    paramString = (Integer)saE.get(paramString);
    if (paramString == null)
    {
      i = ((Integer)saE.get("unknown")).intValue();
      AppMethodBeat.o(106688);
      return i;
    }
    int i = paramString.intValue();
    AppMethodBeat.o(106688);
    return i;
  }
  
  @TargetApi(8)
  public static Bitmap aAn(String paramString)
  {
    AppMethodBeat.i(106689);
    Bitmap localBitmap = null;
    if (d.qV(8)) {
      localBitmap = BitmapUtil.createVideoThumbnail(paramString, 1);
    }
    AppMethodBeat.o(106689);
    return localBitmap;
  }
  
  private static void b(dd paramdd, int paramInt)
  {
    AppMethodBeat.i(106685);
    if ((paramdd.fyI.fyK.syG == null) || (paramdd.fyI.fyK.syG.size() == 0))
    {
      paramdd.fyI.fyO = paramInt;
      AppMethodBeat.o(106685);
      return;
    }
    if (paramdd.fyI.fyO == -9)
    {
      AppMethodBeat.o(106685);
      return;
    }
    if ((paramInt > 0) || (paramdd.fyI.fyO > 0)) {}
    for (int i = 1;; i = 0)
    {
      int k = 0;
      int n = 0;
      int m = 0;
      int j = 0;
      if (k < paramdd.fyI.fyK.syG.size())
      {
        switch (((anm)paramdd.fyI.fyK.syG.get(k)).SyU)
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
          paramdd.fyI.fyO = -9;
          AppMethodBeat.o(106685);
          return;
        }
        paramdd.fyI.fyO = paramInt;
        AppMethodBeat.o(106685);
        return;
      }
      if (m > 0)
      {
        if (n > 0)
        {
          paramdd.fyI.fyO = -8;
          AppMethodBeat.o(106685);
          return;
        }
        if (j == 0)
        {
          paramdd.fyI.fyO = -5;
          AppMethodBeat.o(106685);
          return;
        }
        if (j > 0)
        {
          paramdd.fyI.fyO = -7;
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
          paramdd.fyI.fyO = -4;
          AppMethodBeat.o(106685);
          return;
        }
        if (j > 0)
        {
          paramdd.fyI.fyO = -6;
          AppMethodBeat.o(106685);
          return;
        }
      }
      AppMethodBeat.o(106685);
      return;
    }
  }
  
  public static Bitmap bg(String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(106687);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(106687);
      return null;
    }
    Object localObject = (Bitmap)wJX.get(paramString);
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
    if (!u.agG(paramString))
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
    wJX.put(paramString, localObject);
    AppMethodBeat.o(106687);
    return localObject;
  }
  
  public static void dkO()
  {
    AppMethodBeat.i(106686);
    wJX = new com.tencent.mm.memory.a.b(20, e.class);
    AppMethodBeat.o(106686);
  }
  
  public static void dkP() {}
  
  private static void f(Context paramContext, final DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(106679);
    com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(s.i.favorite_fail_clean_alert_content), paramContext.getString(s.i.favorite_fail_clean_alert_title), paramContext.getString(s.i.favorite_fail_fav_clean), paramContext.getString(s.i.confirm_dialog_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(106672);
        Intent localIntent = new Intent();
        localIntent.putExtra("key_enter_fav_cleanui_from", 3);
        com.tencent.mm.plugin.fav.a.b.b(this.val$context, ".ui.FavCleanUI", localIntent);
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
        if (this.wJZ != null) {
          this.wJZ.onClick(paramAnonymousDialogInterface, -1);
        }
        AppMethodBeat.o(106673);
      }
    }, s.b.wechat_green);
    AppMethodBeat.o(106679);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e
 * JD-Core Version:    0.7.0.1
 */