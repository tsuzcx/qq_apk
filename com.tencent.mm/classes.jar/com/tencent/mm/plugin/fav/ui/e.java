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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.b.f;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.cw.a;
import com.tencent.mm.g.a.gx;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.snackbar.a.b;
import com.tencent.mm.ui.widget.snackbar.a.c;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class e
{
  private static Map<String, Integer> nNI;
  private static f<String, Bitmap> rEh;
  
  static
  {
    AppMethodBeat.i(106690);
    rEh = new com.tencent.mm.memory.a.b(20, e.class);
    nNI = new HashMap();
    HashMap localHashMap = new HashMap();
    nNI = localHashMap;
    localHashMap.put("avi", Integer.valueOf(2131689581));
    nNI.put("m4v", Integer.valueOf(2131689581));
    nNI.put("vob", Integer.valueOf(2131689581));
    nNI.put("mpeg", Integer.valueOf(2131689581));
    nNI.put("mpe", Integer.valueOf(2131689581));
    nNI.put("asx", Integer.valueOf(2131689581));
    nNI.put("asf", Integer.valueOf(2131689581));
    nNI.put("f4v", Integer.valueOf(2131689581));
    nNI.put("flv", Integer.valueOf(2131689581));
    nNI.put("mkv", Integer.valueOf(2131689581));
    nNI.put("wmv", Integer.valueOf(2131689581));
    nNI.put("wm", Integer.valueOf(2131689581));
    nNI.put("3gp", Integer.valueOf(2131689581));
    nNI.put("mp4", Integer.valueOf(2131689581));
    nNI.put("rmvb", Integer.valueOf(2131689581));
    nNI.put("rm", Integer.valueOf(2131689581));
    nNI.put("ra", Integer.valueOf(2131689581));
    nNI.put("ram", Integer.valueOf(2131689581));
    nNI.put("mp3pro", Integer.valueOf(2131689564));
    nNI.put("vqf", Integer.valueOf(2131689564));
    nNI.put("cd", Integer.valueOf(2131689564));
    nNI.put("md", Integer.valueOf(2131689564));
    nNI.put("mod", Integer.valueOf(2131689564));
    nNI.put("vorbis", Integer.valueOf(2131689564));
    nNI.put("au", Integer.valueOf(2131689564));
    nNI.put("amr", Integer.valueOf(2131689564));
    nNI.put("silk", Integer.valueOf(2131689564));
    nNI.put("wma", Integer.valueOf(2131689564));
    nNI.put("mmf", Integer.valueOf(2131689564));
    nNI.put("mid", Integer.valueOf(2131689564));
    nNI.put("midi", Integer.valueOf(2131689564));
    nNI.put("mp3", Integer.valueOf(2131689564));
    nNI.put("aac", Integer.valueOf(2131689564));
    nNI.put("ape", Integer.valueOf(2131689564));
    nNI.put("aiff", Integer.valueOf(2131689564));
    nNI.put("aif", Integer.valueOf(2131689564));
    nNI.put("jfif", Integer.valueOf(2131689570));
    nNI.put("tiff", Integer.valueOf(2131689570));
    nNI.put("tif", Integer.valueOf(2131689570));
    nNI.put("jpe", Integer.valueOf(2131689570));
    nNI.put("dib", Integer.valueOf(2131689570));
    nNI.put("jpeg", Integer.valueOf(2131689570));
    nNI.put("jpg", Integer.valueOf(2131689570));
    nNI.put("png", Integer.valueOf(2131689570));
    nNI.put("bmp", Integer.valueOf(2131689570));
    nNI.put("gif", Integer.valueOf(2131689570));
    nNI.put("rar", Integer.valueOf(2131689573));
    nNI.put("zip", Integer.valueOf(2131689573));
    nNI.put("7z", Integer.valueOf(2131689573));
    nNI.put("iso", Integer.valueOf(2131689573));
    nNI.put("cab", Integer.valueOf(2131689573));
    nNI.put("doc", Integer.valueOf(2131689585));
    nNI.put("docx", Integer.valueOf(2131689585));
    nNI.put("ppt", Integer.valueOf(2131689571));
    nNI.put("pptx", Integer.valueOf(2131689571));
    nNI.put("xls", Integer.valueOf(2131689557));
    nNI.put("xlsx", Integer.valueOf(2131689557));
    nNI.put("txt", Integer.valueOf(2131689576));
    nNI.put("rtf", Integer.valueOf(2131689576));
    nNI.put("pdf", Integer.valueOf(2131689568));
    nNI.put("unknown", Integer.valueOf(2131689577));
    AppMethodBeat.o(106690);
  }
  
  private static int a(cw paramcw, int paramInt)
  {
    AppMethodBeat.i(106682);
    ajx localajx;
    if ((paramcw.doL.doN.oeJ != null) && (paramcw.doL.doN.oeJ.size() > 0))
    {
      localajx = (ajx)paramcw.doL.doN.oeJ.getLast();
      if (paramInt <= 0) {
        switch (paramInt)
        {
        default: 
          localajx.aaq(0);
        }
      }
    }
    for (;;)
    {
      b(paramcw, paramInt);
      AppMethodBeat.o(106682);
      return paramInt;
      localajx.aaq(1);
      localajx.aPQ(null);
      continue;
      localajx.aaq(2);
      localajx.aPQ(null);
    }
  }
  
  private static int a(cw paramcw, ajx paramajx, int paramInt)
  {
    AppMethodBeat.i(106683);
    if (paramajx == null)
    {
      paramInt = a(paramcw, paramInt);
      AppMethodBeat.o(106683);
      return paramInt;
    }
    if (paramInt <= 0) {
      switch (paramInt)
      {
      default: 
        paramajx.aaq(0);
      }
    }
    for (;;)
    {
      b(paramcw, paramInt);
      AppMethodBeat.o(106683);
      return paramInt;
      paramajx.aaq(1);
      paramajx.aPQ(null);
      continue;
      paramajx.aaq(2);
      paramajx.aPQ(null);
    }
  }
  
  public static int a(bv parambv, cw paramcw, boolean paramBoolean)
  {
    AppMethodBeat.i(106681);
    Object localObject1 = "";
    ae.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo msg type is %d", new Object[] { Integer.valueOf(parambv.getType()) });
    int i;
    if ((!paramBoolean) && (paramcw.doL.doQ > 0))
    {
      ae.i("MicroMsg.FavExportLogic", "(!result)&&(favoriteEvent.data.errorType > FavExportLogic.KEY_FAV_PARA_NO_ERROR)");
      i = a(paramcw, paramcw.doL.doQ);
      AppMethodBeat.o(106681);
      return i;
    }
    if ((paramcw.doL.type == 4) || (paramcw.doL.type == 8) || (paramcw.doL.type == 16) || (paramcw.doL.type == 2)) {}
    for (paramBoolean = false;; paramBoolean = true)
    {
      boolean bool = paramBoolean;
      ajx localajx;
      if (paramcw.doL.type == 14)
      {
        bool = paramBoolean;
        if (paramcw.doL.doN.oeJ.size() > 0)
        {
          localajx = (ajx)paramcw.doL.doN.oeJ.getLast();
          if ((localajx.dataType != 4) && (localajx.dataType != 8) && (localajx.dataType != 15))
          {
            bool = paramBoolean;
            if (localajx.dataType != 2) {}
          }
          else
          {
            bool = false;
          }
        }
      }
      if ((paramcw.doL.type == 14) || (paramcw.doL.type == 18)) {}
      for (paramBoolean = false;; paramBoolean = true)
      {
        ae.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo msg type skipCheck %B", new Object[] { Boolean.valueOf(bool) });
        if ((bool) || (parambv.cyH()))
        {
          i = a(paramcw, 0);
          AppMethodBeat.o(106681);
          return i;
        }
        if (paramcw.doL.doN == null)
        {
          i = a(paramcw, -1);
          AppMethodBeat.o(106681);
          return i;
        }
        if (paramcw.doL.doN.oeJ == null)
        {
          i = a(paramcw, -1);
          AppMethodBeat.o(106681);
          return i;
        }
        if (System.currentTimeMillis() - parambv.field_createTime > 259200000L) {}
        for (bool = true;; bool = false)
        {
          ae.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo isOverThreeDays %B", new Object[] { Boolean.valueOf(bool) });
          if (1 <= paramcw.doL.doN.oeJ.size())
          {
            localajx = (ajx)paramcw.doL.doN.oeJ.getLast();
            localObject1 = localajx.GzY;
          }
          for (i = localajx.dataType;; i = 0)
          {
            if (localajx == null) {
              ae.w("MicroMsg.FavExportLogic", "dataItem is null, size:" + paramcw.doL.doN.oeJ.size());
            }
            if (bool)
            {
              if (!bu.isNullOrNil((String)localObject1))
              {
                localObject2 = localObject1;
                if (o.fB((String)localObject1)) {}
              }
              else
              {
                if ((parambv != null) && ((parambv.getType() == 43) || (parambv.getType() == 44) || (parambv.getType() == 62)))
                {
                  localObject1 = u.Ia(parambv.field_imgPath);
                  if ((localObject1 != null) && (((s)localObject1).ixf == -1))
                  {
                    localObject1 = ((s)localObject1).aNs();
                    if (!o.fB((String)localObject1)) {}
                  }
                }
                while (bu.isNullOrNil((String)localObject1))
                {
                  i = a(paramcw, localajx, -4);
                  AppMethodBeat.o(106681);
                  return i;
                  localObject1 = null;
                }
                ((ajx)paramcw.doL.doN.oeJ.getLast()).aPQ((String)localObject1);
                localObject2 = localObject1;
              }
              if (a(parambv, paramcw, localObject2, true, paramBoolean, i))
              {
                i = a(paramcw, localajx, -5);
                AppMethodBeat.o(106681);
                return i;
              }
              ae.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  isOverThreeDays true not big not expired");
            }
            while (!a(parambv, paramcw, (String)localObject1, false, paramBoolean, i))
            {
              Object localObject2;
              ae.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  fav data is normal");
              i = a(paramcw, localajx, 0);
              AppMethodBeat.o(106681);
              return i;
            }
            i = a(paramcw, localajx, -5);
            AppMethodBeat.o(106681);
            return i;
            localajx = null;
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
      com.tencent.mm.ui.base.h.a((Context)localObject, str, "", ((Context)localObject).getString(2131761941), ((Context)localObject).getString(2131757558), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(106674);
          paramAnonymousDialogInterface.dismiss();
          if (this.rEj != null) {
            this.rEj.onClick(paramAnonymousDialogInterface, -2);
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
          if (this.rEj != null) {
            this.rEj.onClick(paramAnonymousDialogInterface, -1);
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
            str = ((Context)localObject).getString(2131758847, new Object[] { Integer.valueOf(((af)g.ad(af.class)).getImageSizeLimitInMB(true)) });
          } else if (paramInt1 == 4) {
            str = ((Context)localObject).getString(2131758847, new Object[] { Integer.valueOf(((af)g.ad(af.class)).getVideoSizeLimitInMB(true)) });
          } else {
            str = ((Context)localObject).getString(2131758847, new Object[] { Integer.valueOf(((af)g.ad(af.class)).getFileSizeLimitInMB(true)) });
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
      ae.e("MicroMsg.FavExportLogic", "handleErrorType activity = null && fragment = null");
      AppMethodBeat.o(106677);
      return;
    }
    if (paramb == null) {
      paramb = new a.b()
      {
        public final void biY()
        {
          AppMethodBeat.i(106670);
          gx localgx = new gx();
          localgx.dub.type = 35;
          a.IvT.l(localgx);
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
              paramActivity = ((Activity)localObject).getString(2131759025, new Object[] { Integer.valueOf(((af)g.ad(af.class)).getImageSizeLimitInMB(true)) });
            }
          }
          break;
        }
        for (;;)
        {
          com.tencent.mm.ui.base.h.d((Context)localObject, paramActivity, "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(106671);
              if (this.rEi != null) {
                this.rEi.onClick(paramAnonymousDialogInterface, -1);
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
            paramActivity = ((Activity)localObject).getString(2131759025, new Object[] { Integer.valueOf(((af)g.ad(af.class)).getVideoSizeLimitInMB(true)) });
          }
          else
          {
            paramActivity = ((Activity)localObject).getString(2131759025, new Object[] { Integer.valueOf(((af)g.ad(af.class)).getFileSizeLimitInMB(true)) });
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
    com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131758887), paramContext.getString(2131758888), paramContext.getString(2131758890), paramContext.getString(2131757558), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
        if (this.rEj != null) {
          this.rEj.onClick(paramAnonymousDialogInterface, -1);
        }
        AppMethodBeat.o(106673);
      }
    }, 2131101171);
    AppMethodBeat.o(106679);
  }
  
  private static boolean a(bv parambv, cw paramcw, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(106684);
    Object localObject;
    if (!bu.isNullOrNil(paramString))
    {
      localObject = new k(paramString);
      if (((k)localObject).exists())
      {
        if (((k)localObject).length() > ((af)g.ad(af.class)).getFavSizeLimit(paramBoolean2, paramInt))
        {
          ae.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file is big");
          AppMethodBeat.o(106684);
          return true;
        }
        ae.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file not big");
      }
    }
    else
    {
      localObject = parambv.field_content;
      if (localObject == null) {
        break label274;
      }
    }
    label274:
    for (parambv = k.b.aB((String)localObject, parambv.field_reserved);; parambv = null)
    {
      if (parambv != null)
      {
        if (parambv.hCC > ((af)g.ad(af.class)).getFavSizeLimit(paramBoolean2, paramInt))
        {
          ae.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file is big");
          AppMethodBeat.o(106684);
          return true;
          if (paramBoolean1) {
            break;
          }
          ae.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  not download finish ！attachFile.exists()");
          ((ajx)paramcw.doL.doN.oeJ.getLast()).aPQ(null);
          break;
        }
        if ((!bu.isNullOrNil(paramString)) && (o.fB(paramString)) && (!paramBoolean1))
        {
          long l = o.aZR(paramString);
          if (parambv.hCC > l)
          {
            ae.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  not download finish content.attachlen > datasize");
            ((ajx)paramcw.doL.doN.oeJ.getLast()).aPQ(null);
          }
        }
      }
      if ((localObject == null) || (parambv == null)) {
        ae.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  (xml == null ) ||(content == null)");
      }
      AppMethodBeat.o(106684);
      return false;
    }
  }
  
  public static int ahD(String paramString)
  {
    AppMethodBeat.i(106688);
    paramString = (Integer)nNI.get(paramString);
    if (paramString == null)
    {
      i = ((Integer)nNI.get("unknown")).intValue();
      AppMethodBeat.o(106688);
      return i;
    }
    int i = paramString.intValue();
    AppMethodBeat.o(106688);
    return i;
  }
  
  @TargetApi(8)
  public static Bitmap ahE(String paramString)
  {
    AppMethodBeat.i(106689);
    Bitmap localBitmap = null;
    if (d.lA(8)) {
      localBitmap = com.tencent.mm.sdk.platformtools.h.createVideoThumbnail(paramString, 1);
    }
    AppMethodBeat.o(106689);
    return localBitmap;
  }
  
  private static void b(cw paramcw, int paramInt)
  {
    AppMethodBeat.i(106685);
    if ((paramcw.doL.doN.oeJ == null) || (paramcw.doL.doN.oeJ.size() == 0))
    {
      paramcw.doL.doQ = paramInt;
      AppMethodBeat.o(106685);
      return;
    }
    if (paramcw.doL.doQ == -9)
    {
      AppMethodBeat.o(106685);
      return;
    }
    if ((paramInt > 0) || (paramcw.doL.doQ > 0)) {}
    for (int i = 1;; i = 0)
    {
      int k = 0;
      int n = 0;
      int m = 0;
      int j = 0;
      if (k < paramcw.doL.doN.oeJ.size())
      {
        switch (((ajx)paramcw.doL.doN.oeJ.get(k)).GAI)
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
          paramcw.doL.doQ = -9;
          AppMethodBeat.o(106685);
          return;
        }
        paramcw.doL.doQ = paramInt;
        AppMethodBeat.o(106685);
        return;
      }
      if (m > 0)
      {
        if (n > 0)
        {
          paramcw.doL.doQ = -8;
          AppMethodBeat.o(106685);
          return;
        }
        if (j == 0)
        {
          paramcw.doL.doQ = -5;
          AppMethodBeat.o(106685);
          return;
        }
        if (j > 0)
        {
          paramcw.doL.doQ = -7;
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
          paramcw.doL.doQ = -4;
          AppMethodBeat.o(106685);
          return;
        }
        if (j > 0)
        {
          paramcw.doL.doQ = -6;
          AppMethodBeat.o(106685);
          return;
        }
      }
      AppMethodBeat.o(106685);
      return;
    }
  }
  
  public static Bitmap bb(String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(106687);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(106687);
      return null;
    }
    Object localObject = (Bitmap)rEh.get(paramString);
    if (localObject != null)
    {
      ae.d("MicroMsg.FavExportLogic", "get bm from cache %s", new Object[] { paramString });
      AppMethodBeat.o(106687);
      return localObject;
    }
    if (paramBoolean)
    {
      AppMethodBeat.o(106687);
      return null;
    }
    if (!o.fB(paramString))
    {
      AppMethodBeat.o(106687);
      return null;
    }
    ae.d("MicroMsg.FavExportLogic", "get from cache fail, try to decode from file");
    localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    Bitmap localBitmap = MMBitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    if (localBitmap != null)
    {
      ae.i("MicroMsg.FavExportLogic", "bitmap recycle %s", new Object[] { localBitmap });
      localBitmap.recycle();
    }
    int j;
    if ((ag.dx(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight)) && (((BitmapFactory.Options)localObject).outWidth > 480))
    {
      i = 1;
      if ((!ag.dw(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight)) || (((BitmapFactory.Options)localObject).outHeight <= 480)) {
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
        ae.w("MicroMsg.FavExportLogic", "fit long picture, beg %d*%d, after %d*%d", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject).outHeight), Integer.valueOf(j), Integer.valueOf(i) });
      }
    }
    int i = BackwardSupportUtil.ExifHelper.df(paramString);
    if ((MMNativeJpeg.IsJpegFile(paramString)) && (MMNativeJpeg.isProgressive(paramString)))
    {
      localObject = MMNativeJpeg.decodeAsBitmap(paramString);
      if (localObject == null)
      {
        paramBoolean = bool;
        ae.i("MicroMsg.FavExportLogic", "Progressive jpeg, result isNull:%b", new Object[] { Boolean.valueOf(paramBoolean) });
      }
    }
    for (;;)
    {
      if (localObject != null) {
        break label415;
      }
      ae.e("MicroMsg.FavExportLogic", "getSuitableBmp fail, temBmp is null, filePath = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(106687);
      return null;
      paramBoolean = false;
      break;
      localObject = com.tencent.mm.sdk.platformtools.h.aRD(paramString);
    }
    label415:
    localObject = com.tencent.mm.sdk.platformtools.h.a((Bitmap)localObject, i);
    if (((Bitmap)localObject).getByteCount() > 20971520)
    {
      AppMethodBeat.o(106687);
      return localObject;
    }
    rEh.put(paramString, localObject);
    AppMethodBeat.o(106687);
    return localObject;
  }
  
  public static void cxE()
  {
    AppMethodBeat.i(106686);
    rEh = new com.tencent.mm.memory.a.b(20, e.class);
    AppMethodBeat.o(106686);
  }
  
  public static void cxF() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e
 * JD-Core Version:    0.7.0.1
 */