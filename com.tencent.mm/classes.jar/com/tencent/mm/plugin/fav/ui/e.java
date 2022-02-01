package com.tencent.mm.plugin.fav.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.b.f;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.cv.a;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.snackbar.a.b;
import com.tencent.mm.ui.widget.snackbar.a.c;
import com.tencent.mm.vfs.i;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class e
{
  private static Map<String, Integer> nIf;
  private static f<String, Bitmap> rvV;
  
  static
  {
    AppMethodBeat.i(106690);
    rvV = new com.tencent.mm.memory.a.b(20, e.class);
    nIf = new HashMap();
    HashMap localHashMap = new HashMap();
    nIf = localHashMap;
    localHashMap.put("avi", Integer.valueOf(2131689581));
    nIf.put("m4v", Integer.valueOf(2131689581));
    nIf.put("vob", Integer.valueOf(2131689581));
    nIf.put("mpeg", Integer.valueOf(2131689581));
    nIf.put("mpe", Integer.valueOf(2131689581));
    nIf.put("asx", Integer.valueOf(2131689581));
    nIf.put("asf", Integer.valueOf(2131689581));
    nIf.put("f4v", Integer.valueOf(2131689581));
    nIf.put("flv", Integer.valueOf(2131689581));
    nIf.put("mkv", Integer.valueOf(2131689581));
    nIf.put("wmv", Integer.valueOf(2131689581));
    nIf.put("wm", Integer.valueOf(2131689581));
    nIf.put("3gp", Integer.valueOf(2131689581));
    nIf.put("mp4", Integer.valueOf(2131689581));
    nIf.put("rmvb", Integer.valueOf(2131689581));
    nIf.put("rm", Integer.valueOf(2131689581));
    nIf.put("ra", Integer.valueOf(2131689581));
    nIf.put("ram", Integer.valueOf(2131689581));
    nIf.put("mp3pro", Integer.valueOf(2131689564));
    nIf.put("vqf", Integer.valueOf(2131689564));
    nIf.put("cd", Integer.valueOf(2131689564));
    nIf.put("md", Integer.valueOf(2131689564));
    nIf.put("mod", Integer.valueOf(2131689564));
    nIf.put("vorbis", Integer.valueOf(2131689564));
    nIf.put("au", Integer.valueOf(2131689564));
    nIf.put("amr", Integer.valueOf(2131689564));
    nIf.put("silk", Integer.valueOf(2131689564));
    nIf.put("wma", Integer.valueOf(2131689564));
    nIf.put("mmf", Integer.valueOf(2131689564));
    nIf.put("mid", Integer.valueOf(2131689564));
    nIf.put("midi", Integer.valueOf(2131689564));
    nIf.put("mp3", Integer.valueOf(2131689564));
    nIf.put("aac", Integer.valueOf(2131689564));
    nIf.put("ape", Integer.valueOf(2131689564));
    nIf.put("aiff", Integer.valueOf(2131689564));
    nIf.put("aif", Integer.valueOf(2131689564));
    nIf.put("jfif", Integer.valueOf(2131689570));
    nIf.put("tiff", Integer.valueOf(2131689570));
    nIf.put("tif", Integer.valueOf(2131689570));
    nIf.put("jpe", Integer.valueOf(2131689570));
    nIf.put("dib", Integer.valueOf(2131689570));
    nIf.put("jpeg", Integer.valueOf(2131689570));
    nIf.put("jpg", Integer.valueOf(2131689570));
    nIf.put("png", Integer.valueOf(2131689570));
    nIf.put("bmp", Integer.valueOf(2131689570));
    nIf.put("gif", Integer.valueOf(2131689570));
    nIf.put("rar", Integer.valueOf(2131689573));
    nIf.put("zip", Integer.valueOf(2131689573));
    nIf.put("7z", Integer.valueOf(2131689573));
    nIf.put("iso", Integer.valueOf(2131689573));
    nIf.put("cab", Integer.valueOf(2131689573));
    nIf.put("doc", Integer.valueOf(2131689585));
    nIf.put("docx", Integer.valueOf(2131689585));
    nIf.put("ppt", Integer.valueOf(2131689571));
    nIf.put("pptx", Integer.valueOf(2131689571));
    nIf.put("xls", Integer.valueOf(2131689557));
    nIf.put("xlsx", Integer.valueOf(2131689557));
    nIf.put("txt", Integer.valueOf(2131689576));
    nIf.put("rtf", Integer.valueOf(2131689576));
    nIf.put("pdf", Integer.valueOf(2131689568));
    nIf.put("unknown", Integer.valueOf(2131689577));
    AppMethodBeat.o(106690);
  }
  
  private static int a(cv paramcv, int paramInt)
  {
    AppMethodBeat.i(106682);
    ajn localajn;
    if ((paramcv.dnG.dnI.nZa != null) && (paramcv.dnG.dnI.nZa.size() > 0))
    {
      localajn = (ajn)paramcv.dnG.dnI.nZa.getLast();
      if (paramInt <= 0) {
        switch (paramInt)
        {
        default: 
          localajn.ZK(0);
        }
      }
    }
    for (;;)
    {
      b(paramcv, paramInt);
      AppMethodBeat.o(106682);
      return paramInt;
      localajn.ZK(1);
      localajn.aOt(null);
      continue;
      localajn.ZK(2);
      localajn.aOt(null);
    }
  }
  
  private static int a(cv paramcv, ajn paramajn, int paramInt)
  {
    AppMethodBeat.i(106683);
    if (paramajn == null)
    {
      paramInt = a(paramcv, paramInt);
      AppMethodBeat.o(106683);
      return paramInt;
    }
    if (paramInt <= 0) {
      switch (paramInt)
      {
      default: 
        paramajn.ZK(0);
      }
    }
    for (;;)
    {
      b(paramcv, paramInt);
      AppMethodBeat.o(106683);
      return paramInt;
      paramajn.ZK(1);
      paramajn.aOt(null);
      continue;
      paramajn.ZK(2);
      paramajn.aOt(null);
    }
  }
  
  public static int a(bu parambu, cv paramcv, boolean paramBoolean)
  {
    AppMethodBeat.i(106681);
    Object localObject1 = "";
    ad.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo msg type is %d", new Object[] { Integer.valueOf(parambu.getType()) });
    int i;
    if ((!paramBoolean) && (paramcv.dnG.dnL > 0))
    {
      ad.i("MicroMsg.FavExportLogic", "(!result)&&(favoriteEvent.data.errorType > FavExportLogic.KEY_FAV_PARA_NO_ERROR)");
      i = a(paramcv, paramcv.dnG.dnL);
      AppMethodBeat.o(106681);
      return i;
    }
    if ((paramcv.dnG.type == 4) || (paramcv.dnG.type == 8) || (paramcv.dnG.type == 16) || (paramcv.dnG.type == 2)) {}
    for (paramBoolean = false;; paramBoolean = true)
    {
      boolean bool = paramBoolean;
      ajn localajn;
      if (paramcv.dnG.type == 14)
      {
        bool = paramBoolean;
        if (paramcv.dnG.dnI.nZa.size() > 0)
        {
          localajn = (ajn)paramcv.dnG.dnI.nZa.getLast();
          if ((localajn.dataType != 4) && (localajn.dataType != 8) && (localajn.dataType != 15))
          {
            bool = paramBoolean;
            if (localajn.dataType != 2) {}
          }
          else
          {
            bool = false;
          }
        }
      }
      if ((paramcv.dnG.type == 14) || (paramcv.dnG.type == 18)) {}
      for (paramBoolean = false;; paramBoolean = true)
      {
        ad.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo msg type skipCheck %B", new Object[] { Boolean.valueOf(bool) });
        if ((bool) || (parambu.cxg()))
        {
          i = a(paramcv, 0);
          AppMethodBeat.o(106681);
          return i;
        }
        if (paramcv.dnG.dnI == null)
        {
          i = a(paramcv, -1);
          AppMethodBeat.o(106681);
          return i;
        }
        if (paramcv.dnG.dnI.nZa == null)
        {
          i = a(paramcv, -1);
          AppMethodBeat.o(106681);
          return i;
        }
        if (System.currentTimeMillis() - parambu.field_createTime > 259200000L) {}
        for (bool = true;; bool = false)
        {
          ad.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo isOverThreeDays %B", new Object[] { Boolean.valueOf(bool) });
          if (1 <= paramcv.dnG.dnI.nZa.size())
          {
            localajn = (ajn)paramcv.dnG.dnI.nZa.getLast();
            localObject1 = localajn.Ghp;
          }
          for (i = localajn.dataType;; i = 0)
          {
            if (localajn == null) {
              ad.w("MicroMsg.FavExportLogic", "dataItem is null, size:" + paramcv.dnG.dnI.nZa.size());
            }
            if (bool)
            {
              if (!bt.isNullOrNil((String)localObject1))
              {
                localObject2 = localObject1;
                if (i.fv((String)localObject1)) {}
              }
              else
              {
                if ((parambu != null) && ((parambu.getType() == 43) || (parambu.getType() == 44) || (parambu.getType() == 62)))
                {
                  localObject1 = u.Hy(parambu.field_imgPath);
                  if ((localObject1 != null) && (((s)localObject1).iul == -1))
                  {
                    localObject1 = ((s)localObject1).aMU();
                    if (!i.fv((String)localObject1)) {}
                  }
                }
                while (bt.isNullOrNil((String)localObject1))
                {
                  i = a(paramcv, localajn, -4);
                  AppMethodBeat.o(106681);
                  return i;
                  localObject1 = null;
                }
                ((ajn)paramcv.dnG.dnI.nZa.getLast()).aOt((String)localObject1);
                localObject2 = localObject1;
              }
              if (a(parambu, paramcv, localObject2, true, paramBoolean, i))
              {
                i = a(paramcv, localajn, -5);
                AppMethodBeat.o(106681);
                return i;
              }
              ad.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  isOverThreeDays true not big not expired");
            }
            while (!a(parambu, paramcv, (String)localObject1, false, paramBoolean, i))
            {
              Object localObject2;
              ad.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  fav data is normal");
              i = a(paramcv, localajn, 0);
              AppMethodBeat.o(106681);
              return i;
            }
            i = a(paramcv, localajn, -5);
            AppMethodBeat.o(106681);
            return i;
            localajn = null;
          }
        }
      }
    }
  }
  
  private static void a(int paramInt1, int paramInt2, final Activity paramActivity, final Fragment paramFragment, DialogInterface.OnClickListener paramOnClickListener, final a.b paramb, final a.c paramc)
  {
    AppMethodBeat.i(106680);
    Object localObject;
    String str;
    if (paramFragment == null)
    {
      localObject = paramActivity;
      if (paramInt2 != -4) {
        break label197;
      }
      switch (paramInt1)
      {
      default: 
        str = "";
      }
    }
    for (;;)
    {
      h.a((Context)localObject, str, "", ((Context)localObject).getString(2131761941), ((Context)localObject).getString(2131757558), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(106674);
          paramAnonymousDialogInterface.dismiss();
          if (this.rvX != null) {
            this.rvX.onClick(paramAnonymousDialogInterface, -2);
          }
          if (paramFragment != null)
          {
            paramAnonymousDialogInterface = paramFragment.getView();
            if ((paramFragment instanceof MMFragment)) {
              paramAnonymousDialogInterface = ((MMFragment)paramFragment).getContentView();
            }
            com.tencent.mm.ui.widget.snackbar.b.a(paramFragment.getContext(), paramAnonymousDialogInterface, paramFragment.getActivity().getString(2131758936), paramFragment.getActivity().getString(2131758846), paramb, paramc);
            AppMethodBeat.o(106674);
            return;
          }
          com.tencent.mm.ui.widget.snackbar.b.a(paramActivity, paramActivity.getString(2131758936), paramActivity.getString(2131758846), paramb, paramc);
          AppMethodBeat.o(106674);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(106675);
          paramAnonymousDialogInterface.dismiss();
          if (this.rvX != null) {
            this.rvX.onClick(paramAnonymousDialogInterface, -1);
          }
          AppMethodBeat.o(106675);
        }
      }, 2131101171);
      AppMethodBeat.o(106680);
      return;
      localObject = paramFragment.getActivity();
      break;
      str = ((Context)localObject).getString(2131758882);
      continue;
      str = ((Context)localObject).getString(2131758881);
      continue;
      str = ((Context)localObject).getString(2131758883);
      continue;
      str = ((Context)localObject).getString(2131758897);
      continue;
      label197:
      if (paramInt2 == -5)
      {
        if (paramInt1 != 14)
        {
          if (paramInt1 == 2) {
            str = ((Context)localObject).getString(2131758847, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.af)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fav.a.af.class)).getImageSizeLimitInMB(true)) });
          } else if (paramInt1 == 4) {
            str = ((Context)localObject).getString(2131758847, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.af)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fav.a.af.class)).getVideoSizeLimitInMB(true)) });
          } else {
            str = ((Context)localObject).getString(2131758847, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.af)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fav.a.af.class)).getFileSizeLimitInMB(true)) });
          }
        }
        else {
          str = ((Context)localObject).getString(2131758896);
        }
      }
      else if (paramInt2 == -6)
      {
        str = ((Context)localObject).getString(2131758897);
      }
      else if (paramInt2 == -7)
      {
        str = ((Context)localObject).getString(2131758896);
      }
      else if (paramInt2 == -8)
      {
        str = ((Context)localObject).getString(2131758898);
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
            com.tencent.mm.ui.widget.snackbar.b.a(paramFragment.getContext(), paramActivity, ((Context)localObject).getString(2131758936), ((Context)localObject).getString(2131758846), paramb, paramc);
            AppMethodBeat.o(106680);
            return;
          }
          com.tencent.mm.ui.widget.snackbar.b.a(paramActivity, ((Context)localObject).getString(2131758936), ((Context)localObject).getString(2131758846), paramb, paramc);
          AppMethodBeat.o(106680);
          return;
        }
        str = ((Context)localObject).getString(2131758885);
      }
    }
  }
  
  public static void a(int paramInt1, int paramInt2, Activity paramActivity, Fragment paramFragment, a.c paramc, DialogInterface.OnClickListener paramOnClickListener, a.b paramb)
  {
    AppMethodBeat.i(106677);
    if ((paramActivity == null) && (paramFragment == null))
    {
      ad.e("MicroMsg.FavExportLogic", "handleErrorType activity = null && fragment = null");
      AppMethodBeat.o(106677);
      return;
    }
    if (paramb == null) {
      paramb = new a.b()
      {
        public final void bip()
        {
          AppMethodBeat.i(106670);
          gw localgw = new gw();
          localgw.dsV.type = 35;
          a.IbL.l(localgw);
          AppMethodBeat.o(106670);
        }
      };
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
          com.tencent.mm.ui.widget.snackbar.b.a(paramFragment.getContext(), paramActivity, paramFragment.getString(2131758936), paramFragment.getString(2131758846), paramb, paramc);
          AppMethodBeat.o(106677);
          return;
        }
        if (paramActivity != null)
        {
          com.tencent.mm.ui.widget.snackbar.b.a(paramActivity, paramActivity.getString(2131758936), paramActivity.getString(2131758846), paramb, paramc);
          AppMethodBeat.o(106677);
        }
      }
      else
      {
        if (paramActivity != null) {
          break label410;
        }
      }
      label410:
      for (Object localObject = paramFragment.getActivity();; localObject = paramActivity)
      {
        switch (paramInt2)
        {
        case -3: 
        default: 
          if (paramInt2 == 2131759025) {
            if (paramInt1 == 2) {
              paramActivity = ((Activity)localObject).getString(2131759025, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.af)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fav.a.af.class)).getImageSizeLimitInMB(true)) });
            }
          }
          break;
        }
        for (;;)
        {
          h.d((Context)localObject, paramActivity, "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(106671);
              if (this.rvW != null) {
                this.rvW.onClick(paramAnonymousDialogInterface, -1);
              }
              AppMethodBeat.o(106671);
            }
          });
          AppMethodBeat.o(106677);
          return;
          a((Context)localObject, paramOnClickListener);
          AppMethodBeat.o(106677);
          return;
          a(paramInt1, paramInt2, (Activity)localObject, paramFragment, paramOnClickListener, paramb, paramc);
          AppMethodBeat.o(106677);
          return;
          a((Activity)localObject, paramFragment);
          AppMethodBeat.o(106677);
          return;
          if (paramInt1 == 4)
          {
            paramActivity = ((Activity)localObject).getString(2131759025, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.af)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fav.a.af.class)).getVideoSizeLimitInMB(true)) });
          }
          else
          {
            paramActivity = ((Activity)localObject).getString(2131759025, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.af)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fav.a.af.class)).getFileSizeLimitInMB(true)) });
            continue;
            paramActivity = ((Activity)localObject).getString(2131759024);
          }
        }
      }
    }
  }
  
  public static void a(int paramInt, Activity paramActivity, a.b paramb)
  {
    AppMethodBeat.i(106676);
    a(-1, paramInt, paramActivity, null, null, null, paramb);
    AppMethodBeat.o(106676);
  }
  
  private static void a(Activity paramActivity, Fragment paramFragment)
  {
    AppMethodBeat.i(106678);
    if (paramFragment != null) {
      paramActivity = paramFragment.getActivity();
    }
    t.makeText(paramActivity, 2131758894, 0).show();
    AppMethodBeat.o(106678);
  }
  
  private static void a(Context paramContext, final DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(106679);
    h.a(paramContext, paramContext.getString(2131758887), paramContext.getString(2131758888), paramContext.getString(2131758890), paramContext.getString(2131757558), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
        if (this.rvX != null) {
          this.rvX.onClick(paramAnonymousDialogInterface, -1);
        }
        AppMethodBeat.o(106673);
      }
    }, 2131101171);
    AppMethodBeat.o(106679);
  }
  
  private static boolean a(bu parambu, cv paramcv, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(106684);
    Object localObject;
    if (!bt.isNullOrNil(paramString))
    {
      localObject = new com.tencent.mm.vfs.e(paramString);
      if (((com.tencent.mm.vfs.e)localObject).exists())
      {
        if (((com.tencent.mm.vfs.e)localObject).length() > ((com.tencent.mm.plugin.fav.a.af)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fav.a.af.class)).getFavSizeLimit(paramBoolean2, paramInt))
        {
          ad.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file is big");
          AppMethodBeat.o(106684);
          return true;
        }
        ad.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file not big");
      }
    }
    else
    {
      localObject = parambu.field_content;
      if (localObject == null) {
        break label274;
      }
    }
    label274:
    for (parambu = k.b.aA((String)localObject, parambu.field_reserved);; parambu = null)
    {
      if (parambu != null)
      {
        if (parambu.hzO > ((com.tencent.mm.plugin.fav.a.af)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fav.a.af.class)).getFavSizeLimit(paramBoolean2, paramInt))
        {
          ad.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file is big");
          AppMethodBeat.o(106684);
          return true;
          if (paramBoolean1) {
            break;
          }
          ad.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  not download finish ！attachFile.exists()");
          ((ajn)paramcv.dnG.dnI.nZa.getLast()).aOt(null);
          break;
        }
        if ((!bt.isNullOrNil(paramString)) && (i.fv(paramString)) && (!paramBoolean1))
        {
          long l = i.aYo(paramString);
          if (parambu.hzO > l)
          {
            ad.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  not download finish content.attachlen > datasize");
            ((ajn)paramcv.dnG.dnI.nZa.getLast()).aOt(null);
          }
        }
      }
      if ((localObject == null) || (parambu == null)) {
        ad.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  (xml == null ) ||(content == null)");
      }
      AppMethodBeat.o(106684);
      return false;
    }
  }
  
  public static Bitmap aZ(String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(106687);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(106687);
      return null;
    }
    Object localObject = (Bitmap)rvV.get(paramString);
    if (localObject != null)
    {
      ad.d("MicroMsg.FavExportLogic", "get bm from cache %s", new Object[] { paramString });
      AppMethodBeat.o(106687);
      return localObject;
    }
    if (paramBoolean)
    {
      AppMethodBeat.o(106687);
      return null;
    }
    if (!i.fv(paramString))
    {
      AppMethodBeat.o(106687);
      return null;
    }
    ad.d("MicroMsg.FavExportLogic", "get from cache fail, try to decode from file");
    localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    Bitmap localBitmap = MMBitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    if (localBitmap != null)
    {
      ad.i("MicroMsg.FavExportLogic", "bitmap recycle %s", new Object[] { localBitmap });
      localBitmap.recycle();
    }
    int j;
    if ((com.tencent.mm.sdk.platformtools.af.dx(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight)) && (((BitmapFactory.Options)localObject).outWidth > 480))
    {
      i = 1;
      if ((!com.tencent.mm.sdk.platformtools.af.dw(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight)) || (((BitmapFactory.Options)localObject).outHeight <= 480)) {
        break label256;
      }
      j = 1;
    }
    label256:
    for (;;)
    {
      label211:
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
            break label211;
          }
        }
        j = Math.max(1, j);
        i = Math.max(1, i);
        ad.w("MicroMsg.FavExportLogic", "fit long picture, beg %d*%d, after %d*%d", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject).outHeight), Integer.valueOf(j), Integer.valueOf(i) });
      }
    }
    int i = BackwardSupportUtil.ExifHelper.cY(paramString);
    if ((MMNativeJpeg.IsJpegFile(paramString)) && (MMNativeJpeg.isProgressive(paramString)))
    {
      localObject = MMNativeJpeg.decodeAsBitmap(paramString);
      if (localObject == null)
      {
        paramBoolean = bool;
        ad.i("MicroMsg.FavExportLogic", "Progressive jpeg, result isNull:%b", new Object[] { Boolean.valueOf(paramBoolean) });
      }
    }
    for (;;)
    {
      if (localObject != null) {
        break label415;
      }
      ad.e("MicroMsg.FavExportLogic", "getSuitableBmp fail, temBmp is null, filePath = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(106687);
      return null;
      paramBoolean = false;
      break;
      localObject = com.tencent.mm.sdk.platformtools.g.aQg(paramString);
    }
    label415:
    localObject = com.tencent.mm.sdk.platformtools.g.a((Bitmap)localObject, i);
    if (((Bitmap)localObject).getByteCount() > 20971520)
    {
      AppMethodBeat.o(106687);
      return localObject;
    }
    rvV.put(paramString, localObject);
    AppMethodBeat.o(106687);
    return localObject;
  }
  
  public static int agG(String paramString)
  {
    AppMethodBeat.i(106688);
    paramString = (Integer)nIf.get(paramString);
    if (paramString == null)
    {
      i = ((Integer)nIf.get("unknown")).intValue();
      AppMethodBeat.o(106688);
      return i;
    }
    int i = paramString.intValue();
    AppMethodBeat.o(106688);
    return i;
  }
  
  @TargetApi(8)
  public static Bitmap agH(String paramString)
  {
    AppMethodBeat.i(106689);
    Bitmap localBitmap = null;
    if (d.ly(8)) {
      localBitmap = com.tencent.mm.sdk.platformtools.g.createVideoThumbnail(paramString, 1);
    }
    AppMethodBeat.o(106689);
    return localBitmap;
  }
  
  private static void b(cv paramcv, int paramInt)
  {
    AppMethodBeat.i(106685);
    if ((paramcv.dnG.dnI.nZa == null) || (paramcv.dnG.dnI.nZa.size() == 0))
    {
      paramcv.dnG.dnL = paramInt;
      AppMethodBeat.o(106685);
      return;
    }
    if (paramcv.dnG.dnL == -9)
    {
      AppMethodBeat.o(106685);
      return;
    }
    if ((paramInt > 0) || (paramcv.dnG.dnL > 0)) {}
    for (int i = 1;; i = 0)
    {
      int k = 0;
      int n = 0;
      int m = 0;
      int j = 0;
      if (k < paramcv.dnG.dnI.nZa.size())
      {
        switch (((ajn)paramcv.dnG.dnI.nZa.get(k)).GhZ)
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
          paramcv.dnG.dnL = -9;
          AppMethodBeat.o(106685);
          return;
        }
        paramcv.dnG.dnL = paramInt;
        AppMethodBeat.o(106685);
        return;
      }
      if (m > 0)
      {
        if (n > 0)
        {
          paramcv.dnG.dnL = -8;
          AppMethodBeat.o(106685);
          return;
        }
        if (j == 0)
        {
          paramcv.dnG.dnL = -5;
          AppMethodBeat.o(106685);
          return;
        }
        if (j > 0)
        {
          paramcv.dnG.dnL = -7;
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
          paramcv.dnG.dnL = -4;
          AppMethodBeat.o(106685);
          return;
        }
        if (j > 0)
        {
          paramcv.dnG.dnL = -6;
          AppMethodBeat.o(106685);
          return;
        }
      }
      AppMethodBeat.o(106685);
      return;
    }
  }
  
  public static void cwd()
  {
    AppMethodBeat.i(106686);
    rvV = new com.tencent.mm.memory.a.b(20, e.class);
    AppMethodBeat.o(106686);
  }
  
  public static void cwe() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e
 * JD-Core Version:    0.7.0.1
 */