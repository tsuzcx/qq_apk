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
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.a;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.g.c.du;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
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
  private static Map<String, Integer> mFE;
  private static com.tencent.mm.b.f<String, Bitmap> qdq;
  
  static
  {
    AppMethodBeat.i(106690);
    qdq = new com.tencent.mm.memory.a.b(20, e.class);
    mFE = new HashMap();
    HashMap localHashMap = new HashMap();
    mFE = localHashMap;
    localHashMap.put("avi", Integer.valueOf(2131689581));
    mFE.put("m4v", Integer.valueOf(2131689581));
    mFE.put("vob", Integer.valueOf(2131689581));
    mFE.put("mpeg", Integer.valueOf(2131689581));
    mFE.put("mpe", Integer.valueOf(2131689581));
    mFE.put("asx", Integer.valueOf(2131689581));
    mFE.put("asf", Integer.valueOf(2131689581));
    mFE.put("f4v", Integer.valueOf(2131689581));
    mFE.put("flv", Integer.valueOf(2131689581));
    mFE.put("mkv", Integer.valueOf(2131689581));
    mFE.put("wmv", Integer.valueOf(2131689581));
    mFE.put("wm", Integer.valueOf(2131689581));
    mFE.put("3gp", Integer.valueOf(2131689581));
    mFE.put("mp4", Integer.valueOf(2131689581));
    mFE.put("rmvb", Integer.valueOf(2131689581));
    mFE.put("rm", Integer.valueOf(2131689581));
    mFE.put("ra", Integer.valueOf(2131689581));
    mFE.put("ram", Integer.valueOf(2131689581));
    mFE.put("mp3pro", Integer.valueOf(2131689564));
    mFE.put("vqf", Integer.valueOf(2131689564));
    mFE.put("cd", Integer.valueOf(2131689564));
    mFE.put("md", Integer.valueOf(2131689564));
    mFE.put("mod", Integer.valueOf(2131689564));
    mFE.put("vorbis", Integer.valueOf(2131689564));
    mFE.put("au", Integer.valueOf(2131689564));
    mFE.put("amr", Integer.valueOf(2131689564));
    mFE.put("silk", Integer.valueOf(2131689564));
    mFE.put("wma", Integer.valueOf(2131689564));
    mFE.put("mmf", Integer.valueOf(2131689564));
    mFE.put("mid", Integer.valueOf(2131689564));
    mFE.put("midi", Integer.valueOf(2131689564));
    mFE.put("mp3", Integer.valueOf(2131689564));
    mFE.put("aac", Integer.valueOf(2131689564));
    mFE.put("ape", Integer.valueOf(2131689564));
    mFE.put("aiff", Integer.valueOf(2131689564));
    mFE.put("aif", Integer.valueOf(2131689564));
    mFE.put("jfif", Integer.valueOf(2131689570));
    mFE.put("tiff", Integer.valueOf(2131689570));
    mFE.put("tif", Integer.valueOf(2131689570));
    mFE.put("jpe", Integer.valueOf(2131689570));
    mFE.put("dib", Integer.valueOf(2131689570));
    mFE.put("jpeg", Integer.valueOf(2131689570));
    mFE.put("jpg", Integer.valueOf(2131689570));
    mFE.put("png", Integer.valueOf(2131689570));
    mFE.put("bmp", Integer.valueOf(2131689570));
    mFE.put("gif", Integer.valueOf(2131689570));
    mFE.put("rar", Integer.valueOf(2131689573));
    mFE.put("zip", Integer.valueOf(2131689573));
    mFE.put("7z", Integer.valueOf(2131689573));
    mFE.put("iso", Integer.valueOf(2131689573));
    mFE.put("cab", Integer.valueOf(2131689573));
    mFE.put("doc", Integer.valueOf(2131689585));
    mFE.put("docx", Integer.valueOf(2131689585));
    mFE.put("ppt", Integer.valueOf(2131689571));
    mFE.put("pptx", Integer.valueOf(2131689571));
    mFE.put("xls", Integer.valueOf(2131689557));
    mFE.put("xlsx", Integer.valueOf(2131689557));
    mFE.put("txt", Integer.valueOf(2131689576));
    mFE.put("rtf", Integer.valueOf(2131689576));
    mFE.put("pdf", Integer.valueOf(2131689568));
    mFE.put("unknown", Integer.valueOf(2131689577));
    AppMethodBeat.o(106690);
  }
  
  public static int Yv(String paramString)
  {
    AppMethodBeat.i(106688);
    paramString = (Integer)mFE.get(paramString);
    if (paramString == null)
    {
      i = ((Integer)mFE.get("unknown")).intValue();
      AppMethodBeat.o(106688);
      return i;
    }
    int i = paramString.intValue();
    AppMethodBeat.o(106688);
    return i;
  }
  
  @TargetApi(8)
  public static Bitmap Yw(String paramString)
  {
    AppMethodBeat.i(106689);
    Bitmap localBitmap = null;
    if (d.lf(8)) {
      localBitmap = com.tencent.mm.sdk.platformtools.f.createVideoThumbnail(paramString, 1);
    }
    AppMethodBeat.o(106689);
    return localBitmap;
  }
  
  private static int a(cs paramcs, int paramInt)
  {
    AppMethodBeat.i(106682);
    afy localafy;
    if ((paramcs.deQ.deS.mVb != null) && (paramcs.deQ.deS.mVb.size() > 0))
    {
      localafy = (afy)paramcs.deQ.deS.mVb.getLast();
      if (paramInt <= 0) {
        switch (paramInt)
        {
        default: 
          localafy.VF(0);
        }
      }
    }
    for (;;)
    {
      b(paramcs, paramInt);
      AppMethodBeat.o(106682);
      return paramInt;
      localafy.VF(1);
      localafy.aDz(null);
      continue;
      localafy.VF(2);
      localafy.aDz(null);
    }
  }
  
  private static int a(cs paramcs, afy paramafy, int paramInt)
  {
    AppMethodBeat.i(106683);
    if (paramafy == null)
    {
      paramInt = a(paramcs, paramInt);
      AppMethodBeat.o(106683);
      return paramInt;
    }
    if (paramInt <= 0) {
      switch (paramInt)
      {
      default: 
        paramafy.VF(0);
      }
    }
    for (;;)
    {
      b(paramcs, paramInt);
      AppMethodBeat.o(106683);
      return paramInt;
      paramafy.VF(1);
      paramafy.aDz(null);
      continue;
      paramafy.VF(2);
      paramafy.aDz(null);
    }
  }
  
  public static int a(bl parambl, cs paramcs, boolean paramBoolean)
  {
    AppMethodBeat.i(106681);
    Object localObject1 = "";
    ad.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo msg type is %d", new Object[] { Integer.valueOf(parambl.getType()) });
    int i;
    if ((!paramBoolean) && (paramcs.deQ.deV > 0))
    {
      ad.i("MicroMsg.FavExportLogic", "(!result)&&(favoriteEvent.data.errorType > FavExportLogic.KEY_FAV_PARA_NO_ERROR)");
      i = a(paramcs, paramcs.deQ.deV);
      AppMethodBeat.o(106681);
      return i;
    }
    if ((paramcs.deQ.type == 4) || (paramcs.deQ.type == 8) || (paramcs.deQ.type == 16) || (paramcs.deQ.type == 2)) {}
    for (paramBoolean = false;; paramBoolean = true)
    {
      boolean bool = paramBoolean;
      afy localafy;
      if (paramcs.deQ.type == 14)
      {
        bool = paramBoolean;
        if (paramcs.deQ.deS.mVb.size() > 0)
        {
          localafy = (afy)paramcs.deQ.deS.mVb.getLast();
          if ((localafy.dataType != 4) && (localafy.dataType != 8) && (localafy.dataType != 15))
          {
            bool = paramBoolean;
            if (localafy.dataType != 2) {}
          }
          else
          {
            bool = false;
          }
        }
      }
      if ((paramcs.deQ.type == 14) || (paramcs.deQ.type == 18)) {}
      for (paramBoolean = false;; paramBoolean = true)
      {
        ad.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo msg type skipCheck %B", new Object[] { Boolean.valueOf(bool) });
        if ((bool) || (parambl.cjN()))
        {
          i = a(paramcs, 0);
          AppMethodBeat.o(106681);
          return i;
        }
        if (paramcs.deQ.deS == null)
        {
          i = a(paramcs, -1);
          AppMethodBeat.o(106681);
          return i;
        }
        if (paramcs.deQ.deS.mVb == null)
        {
          i = a(paramcs, -1);
          AppMethodBeat.o(106681);
          return i;
        }
        if (System.currentTimeMillis() - parambl.field_createTime > 259200000L) {}
        for (bool = true;; bool = false)
        {
          ad.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo isOverThreeDays %B", new Object[] { Boolean.valueOf(bool) });
          if (1 <= paramcs.deQ.deS.mVb.size())
          {
            localafy = (afy)paramcs.deQ.deS.mVb.getLast();
            localObject1 = localafy.Dgx;
          }
          for (i = localafy.dataType;; i = 0)
          {
            if (localafy == null) {
              ad.w("MicroMsg.FavExportLogic", "dataItem is null, size:" + paramcs.deQ.deS.mVb.size());
            }
            if (bool)
            {
              if (!bt.isNullOrNil((String)localObject1))
              {
                localObject2 = localObject1;
                if (i.eK((String)localObject1)) {}
              }
              else
              {
                if ((parambl != null) && ((parambl.getType() == 43) || (parambl.getType() == 44) || (parambl.getType() == 62)))
                {
                  localObject1 = u.Ae(parambl.field_imgPath);
                  if ((localObject1 != null) && (((s)localObject1).hAo == -1))
                  {
                    localObject1 = ((s)localObject1).aCS();
                    if (!i.eK((String)localObject1)) {}
                  }
                }
                while (bt.isNullOrNil((String)localObject1))
                {
                  i = a(paramcs, localafy, -4);
                  AppMethodBeat.o(106681);
                  return i;
                  localObject1 = null;
                }
                ((afy)paramcs.deQ.deS.mVb.getLast()).aDz((String)localObject1);
                localObject2 = localObject1;
              }
              if (a(parambl, paramcs, localObject2, true, paramBoolean, i))
              {
                i = a(paramcs, localafy, -5);
                AppMethodBeat.o(106681);
                return i;
              }
              ad.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  isOverThreeDays true not big not expired");
            }
            while (!a(parambl, paramcs, (String)localObject1, false, paramBoolean, i))
            {
              Object localObject2;
              ad.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  fav data is normal");
              i = a(paramcs, localafy, 0);
              AppMethodBeat.o(106681);
              return i;
            }
            i = a(paramcs, localafy, -5);
            AppMethodBeat.o(106681);
            return i;
            localafy = null;
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
      h.a((Context)localObject, str, "", ((Context)localObject).getString(2131761941), ((Context)localObject).getString(2131757558), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(106674);
          paramAnonymousDialogInterface.dismiss();
          if (this.qds != null) {
            this.qds.onClick(paramAnonymousDialogInterface, -2);
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
          if (this.qds != null) {
            this.qds.onClick(paramAnonymousDialogInterface, -1);
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
      label199:
      if (paramInt2 == -5)
      {
        if (paramInt1 != 14)
        {
          if (paramInt1 == 2) {
            str = ((Context)localObject).getString(2131758847, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.af)g.ad(com.tencent.mm.plugin.fav.a.af.class)).getImageSizeLimitInMB(true)) });
          } else if (paramInt1 == 4) {
            str = ((Context)localObject).getString(2131758847, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.af)g.ad(com.tencent.mm.plugin.fav.a.af.class)).getVideoSizeLimitInMB(true)) });
          } else {
            str = ((Context)localObject).getString(2131758847, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.af)g.ad(com.tencent.mm.plugin.fav.a.af.class)).getFileSizeLimitInMB(true)) });
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
        public final void aXO()
        {
          AppMethodBeat.i(106670);
          gs localgs = new gs();
          localgs.dkc.type = 35;
          a.ESL.l(localgs);
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
          break label411;
        }
      }
      label411:
      for (Object localObject = paramFragment.getActivity();; localObject = paramActivity)
      {
        switch (paramInt2)
        {
        case -3: 
        default: 
          if (paramInt2 == 2131759025) {
            if (paramInt1 == 2) {
              paramActivity = ((Activity)localObject).getString(2131759025, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.af)g.ad(com.tencent.mm.plugin.fav.a.af.class)).getImageSizeLimitInMB(true)) });
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
              if (this.qdr != null) {
                this.qdr.onClick(paramAnonymousDialogInterface, -1);
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
            paramActivity = ((Activity)localObject).getString(2131759025, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.af)g.ad(com.tencent.mm.plugin.fav.a.af.class)).getVideoSizeLimitInMB(true)) });
          }
          else
          {
            paramActivity = ((Activity)localObject).getString(2131759025, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.af)g.ad(com.tencent.mm.plugin.fav.a.af.class)).getFileSizeLimitInMB(true)) });
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
        if (this.qds != null) {
          this.qds.onClick(paramAnonymousDialogInterface, -1);
        }
        AppMethodBeat.o(106673);
      }
    }, 2131101171);
    AppMethodBeat.o(106679);
  }
  
  private static boolean a(bl parambl, cs paramcs, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(106684);
    Object localObject;
    if (!bt.isNullOrNil(paramString))
    {
      localObject = new com.tencent.mm.vfs.e(paramString);
      if (((com.tencent.mm.vfs.e)localObject).exists())
      {
        if (((com.tencent.mm.vfs.e)localObject).length() > ((com.tencent.mm.plugin.fav.a.af)g.ad(com.tencent.mm.plugin.fav.a.af.class)).getFavSizeLimit(paramBoolean2, paramInt))
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
      localObject = parambl.field_content;
      if (localObject == null) {
        break label280;
      }
    }
    label280:
    for (parambl = k.b.ar((String)localObject, parambl.field_reserved);; parambl = null)
    {
      if (parambl != null)
      {
        if (parambl.gHe > ((com.tencent.mm.plugin.fav.a.af)g.ad(com.tencent.mm.plugin.fav.a.af.class)).getFavSizeLimit(paramBoolean2, paramInt))
        {
          ad.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file is big");
          AppMethodBeat.o(106684);
          return true;
          if (paramBoolean1) {
            break;
          }
          ad.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  not download finish ！attachFile.exists()");
          ((afy)paramcs.deQ.deS.mVb.getLast()).aDz(null);
          break;
        }
        if ((!bt.isNullOrNil(paramString)) && (i.eK(paramString)) && (!paramBoolean1))
        {
          long l = i.aMN(paramString);
          if (parambl.gHe > l)
          {
            ad.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  not download finish content.attachlen > datasize");
            ((afy)paramcs.deQ.deS.mVb.getLast()).aDz(null);
          }
        }
      }
      if ((localObject == null) || (parambl == null)) {
        ad.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  (xml == null ) ||(content == null)");
      }
      AppMethodBeat.o(106684);
      return false;
    }
  }
  
  public static Bitmap aW(String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(106687);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(106687);
      return null;
    }
    Object localObject = (Bitmap)qdq.get(paramString);
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
    if (!i.eK(paramString))
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
    if ((com.tencent.mm.sdk.platformtools.af.dv(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight)) && (((BitmapFactory.Options)localObject).outWidth > 480))
    {
      i = 1;
      if ((!com.tencent.mm.sdk.platformtools.af.du(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight)) || (((BitmapFactory.Options)localObject).outHeight <= 480)) {
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
        ad.w("MicroMsg.FavExportLogic", "fit long picture, beg %d*%d, after %d*%d", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject).outHeight), Integer.valueOf(j), Integer.valueOf(i) });
      }
    }
    int i = BackwardSupportUtil.ExifHelper.co(paramString);
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
        break label421;
      }
      ad.e("MicroMsg.FavExportLogic", "getSuitableBmp fail, temBmp is null, filePath = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(106687);
      return null;
      paramBoolean = false;
      break;
      localObject = com.tencent.mm.sdk.platformtools.f.aFj(paramString);
    }
    label421:
    localObject = com.tencent.mm.sdk.platformtools.f.a((Bitmap)localObject, i);
    if (((Bitmap)localObject).getByteCount() > 20971520)
    {
      AppMethodBeat.o(106687);
      return localObject;
    }
    qdq.put(paramString, localObject);
    AppMethodBeat.o(106687);
    return localObject;
  }
  
  private static void b(cs paramcs, int paramInt)
  {
    AppMethodBeat.i(106685);
    if ((paramcs.deQ.deS.mVb == null) || (paramcs.deQ.deS.mVb.size() == 0))
    {
      paramcs.deQ.deV = paramInt;
      AppMethodBeat.o(106685);
      return;
    }
    if (paramcs.deQ.deV == -9)
    {
      AppMethodBeat.o(106685);
      return;
    }
    if ((paramInt > 0) || (paramcs.deQ.deV > 0)) {}
    for (int i = 1;; i = 0)
    {
      int k = 0;
      int n = 0;
      int m = 0;
      int j = 0;
      if (k < paramcs.deQ.deS.mVb.size())
      {
        switch (((afy)paramcs.deQ.deS.mVb.get(k)).Dhh)
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
          paramcs.deQ.deV = -9;
          AppMethodBeat.o(106685);
          return;
        }
        paramcs.deQ.deV = paramInt;
        AppMethodBeat.o(106685);
        return;
      }
      if (m > 0)
      {
        if (n > 0)
        {
          paramcs.deQ.deV = -8;
          AppMethodBeat.o(106685);
          return;
        }
        if (j == 0)
        {
          paramcs.deQ.deV = -5;
          AppMethodBeat.o(106685);
          return;
        }
        if (j > 0)
        {
          paramcs.deQ.deV = -7;
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
          paramcs.deQ.deV = -4;
          AppMethodBeat.o(106685);
          return;
        }
        if (j > 0)
        {
          paramcs.deQ.deV = -6;
          AppMethodBeat.o(106685);
          return;
        }
      }
      AppMethodBeat.o(106685);
      return;
    }
  }
  
  public static void ciR()
  {
    AppMethodBeat.i(106686);
    qdq = new com.tencent.mm.memory.a.b(20, e.class);
    AppMethodBeat.o(106686);
  }
  
  public static void ciS() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e
 * JD-Core Version:    0.7.0.1
 */