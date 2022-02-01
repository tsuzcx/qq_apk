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
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.a;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
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
  private static Map<String, Integer> nhJ;
  private static com.tencent.mm.b.f<String, Bitmap> qLT;
  
  static
  {
    AppMethodBeat.i(106690);
    qLT = new com.tencent.mm.memory.a.b(20, e.class);
    nhJ = new HashMap();
    HashMap localHashMap = new HashMap();
    nhJ = localHashMap;
    localHashMap.put("avi", Integer.valueOf(2131689581));
    nhJ.put("m4v", Integer.valueOf(2131689581));
    nhJ.put("vob", Integer.valueOf(2131689581));
    nhJ.put("mpeg", Integer.valueOf(2131689581));
    nhJ.put("mpe", Integer.valueOf(2131689581));
    nhJ.put("asx", Integer.valueOf(2131689581));
    nhJ.put("asf", Integer.valueOf(2131689581));
    nhJ.put("f4v", Integer.valueOf(2131689581));
    nhJ.put("flv", Integer.valueOf(2131689581));
    nhJ.put("mkv", Integer.valueOf(2131689581));
    nhJ.put("wmv", Integer.valueOf(2131689581));
    nhJ.put("wm", Integer.valueOf(2131689581));
    nhJ.put("3gp", Integer.valueOf(2131689581));
    nhJ.put("mp4", Integer.valueOf(2131689581));
    nhJ.put("rmvb", Integer.valueOf(2131689581));
    nhJ.put("rm", Integer.valueOf(2131689581));
    nhJ.put("ra", Integer.valueOf(2131689581));
    nhJ.put("ram", Integer.valueOf(2131689581));
    nhJ.put("mp3pro", Integer.valueOf(2131689564));
    nhJ.put("vqf", Integer.valueOf(2131689564));
    nhJ.put("cd", Integer.valueOf(2131689564));
    nhJ.put("md", Integer.valueOf(2131689564));
    nhJ.put("mod", Integer.valueOf(2131689564));
    nhJ.put("vorbis", Integer.valueOf(2131689564));
    nhJ.put("au", Integer.valueOf(2131689564));
    nhJ.put("amr", Integer.valueOf(2131689564));
    nhJ.put("silk", Integer.valueOf(2131689564));
    nhJ.put("wma", Integer.valueOf(2131689564));
    nhJ.put("mmf", Integer.valueOf(2131689564));
    nhJ.put("mid", Integer.valueOf(2131689564));
    nhJ.put("midi", Integer.valueOf(2131689564));
    nhJ.put("mp3", Integer.valueOf(2131689564));
    nhJ.put("aac", Integer.valueOf(2131689564));
    nhJ.put("ape", Integer.valueOf(2131689564));
    nhJ.put("aiff", Integer.valueOf(2131689564));
    nhJ.put("aif", Integer.valueOf(2131689564));
    nhJ.put("jfif", Integer.valueOf(2131689570));
    nhJ.put("tiff", Integer.valueOf(2131689570));
    nhJ.put("tif", Integer.valueOf(2131689570));
    nhJ.put("jpe", Integer.valueOf(2131689570));
    nhJ.put("dib", Integer.valueOf(2131689570));
    nhJ.put("jpeg", Integer.valueOf(2131689570));
    nhJ.put("jpg", Integer.valueOf(2131689570));
    nhJ.put("png", Integer.valueOf(2131689570));
    nhJ.put("bmp", Integer.valueOf(2131689570));
    nhJ.put("gif", Integer.valueOf(2131689570));
    nhJ.put("rar", Integer.valueOf(2131689573));
    nhJ.put("zip", Integer.valueOf(2131689573));
    nhJ.put("7z", Integer.valueOf(2131689573));
    nhJ.put("iso", Integer.valueOf(2131689573));
    nhJ.put("cab", Integer.valueOf(2131689573));
    nhJ.put("doc", Integer.valueOf(2131689585));
    nhJ.put("docx", Integer.valueOf(2131689585));
    nhJ.put("ppt", Integer.valueOf(2131689571));
    nhJ.put("pptx", Integer.valueOf(2131689571));
    nhJ.put("xls", Integer.valueOf(2131689557));
    nhJ.put("xlsx", Integer.valueOf(2131689557));
    nhJ.put("txt", Integer.valueOf(2131689576));
    nhJ.put("rtf", Integer.valueOf(2131689576));
    nhJ.put("pdf", Integer.valueOf(2131689568));
    nhJ.put("unknown", Integer.valueOf(2131689577));
    AppMethodBeat.o(106690);
  }
  
  private static int a(cs paramcs, int paramInt)
  {
    AppMethodBeat.i(106682);
    agx localagx;
    if ((paramcs.dck.dcm.nxC != null) && (paramcs.dck.dcm.nxC.size() > 0))
    {
      localagx = (agx)paramcs.dck.dcm.nxC.getLast();
      if (paramInt <= 0) {
        switch (paramInt)
        {
        default: 
          localagx.XO(0);
        }
      }
    }
    for (;;)
    {
      b(paramcs, paramInt);
      AppMethodBeat.o(106682);
      return paramInt;
      localagx.XO(1);
      localagx.aIQ(null);
      continue;
      localagx.XO(2);
      localagx.aIQ(null);
    }
  }
  
  private static int a(cs paramcs, agx paramagx, int paramInt)
  {
    AppMethodBeat.i(106683);
    if (paramagx == null)
    {
      paramInt = a(paramcs, paramInt);
      AppMethodBeat.o(106683);
      return paramInt;
    }
    if (paramInt <= 0) {
      switch (paramInt)
      {
      default: 
        paramagx.XO(0);
      }
    }
    for (;;)
    {
      b(paramcs, paramInt);
      AppMethodBeat.o(106683);
      return paramInt;
      paramagx.XO(1);
      paramagx.aIQ(null);
      continue;
      paramagx.XO(2);
      paramagx.aIQ(null);
    }
  }
  
  public static int a(bo parambo, cs paramcs, boolean paramBoolean)
  {
    AppMethodBeat.i(106681);
    Object localObject1 = "";
    ac.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo msg type is %d", new Object[] { Integer.valueOf(parambo.getType()) });
    int i;
    if ((!paramBoolean) && (paramcs.dck.dcp > 0))
    {
      ac.i("MicroMsg.FavExportLogic", "(!result)&&(favoriteEvent.data.errorType > FavExportLogic.KEY_FAV_PARA_NO_ERROR)");
      i = a(paramcs, paramcs.dck.dcp);
      AppMethodBeat.o(106681);
      return i;
    }
    if ((paramcs.dck.type == 4) || (paramcs.dck.type == 8) || (paramcs.dck.type == 16) || (paramcs.dck.type == 2)) {}
    for (paramBoolean = false;; paramBoolean = true)
    {
      boolean bool = paramBoolean;
      agx localagx;
      if (paramcs.dck.type == 14)
      {
        bool = paramBoolean;
        if (paramcs.dck.dcm.nxC.size() > 0)
        {
          localagx = (agx)paramcs.dck.dcm.nxC.getLast();
          if ((localagx.dataType != 4) && (localagx.dataType != 8) && (localagx.dataType != 15))
          {
            bool = paramBoolean;
            if (localagx.dataType != 2) {}
          }
          else
          {
            bool = false;
          }
        }
      }
      if ((paramcs.dck.type == 14) || (paramcs.dck.type == 18)) {}
      for (paramBoolean = false;; paramBoolean = true)
      {
        ac.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo msg type skipCheck %B", new Object[] { Boolean.valueOf(bool) });
        if ((bool) || (parambo.cru()))
        {
          i = a(paramcs, 0);
          AppMethodBeat.o(106681);
          return i;
        }
        if (paramcs.dck.dcm == null)
        {
          i = a(paramcs, -1);
          AppMethodBeat.o(106681);
          return i;
        }
        if (paramcs.dck.dcm.nxC == null)
        {
          i = a(paramcs, -1);
          AppMethodBeat.o(106681);
          return i;
        }
        if (System.currentTimeMillis() - parambo.field_createTime > 259200000L) {}
        for (bool = true;; bool = false)
        {
          ac.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo isOverThreeDays %B", new Object[] { Boolean.valueOf(bool) });
          if (1 <= paramcs.dck.dcm.nxC.size())
          {
            localagx = (agx)paramcs.dck.dcm.nxC.getLast();
            localObject1 = localagx.EzD;
          }
          for (i = localagx.dataType;; i = 0)
          {
            if (localagx == null) {
              ac.w("MicroMsg.FavExportLogic", "dataItem is null, size:" + paramcs.dck.dcm.nxC.size());
            }
            if (bool)
            {
              if (!bs.isNullOrNil((String)localObject1))
              {
                localObject2 = localObject1;
                if (i.eA((String)localObject1)) {}
              }
              else
              {
                if ((parambo != null) && ((parambo.getType() == 43) || (parambo.getType() == 44) || (parambo.getType() == 62)))
                {
                  localObject1 = u.Ej(parambo.field_imgPath);
                  if ((localObject1 != null) && (((s)localObject1).iaP == -1))
                  {
                    localObject1 = ((s)localObject1).aJJ();
                    if (!i.eA((String)localObject1)) {}
                  }
                }
                while (bs.isNullOrNil((String)localObject1))
                {
                  i = a(paramcs, localagx, -4);
                  AppMethodBeat.o(106681);
                  return i;
                  localObject1 = null;
                }
                ((agx)paramcs.dck.dcm.nxC.getLast()).aIQ((String)localObject1);
                localObject2 = localObject1;
              }
              if (a(parambo, paramcs, localObject2, true, paramBoolean, i))
              {
                i = a(paramcs, localagx, -5);
                AppMethodBeat.o(106681);
                return i;
              }
              ac.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  isOverThreeDays true not big not expired");
            }
            while (!a(parambo, paramcs, (String)localObject1, false, paramBoolean, i))
            {
              Object localObject2;
              ac.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  fav data is normal");
              i = a(paramcs, localagx, 0);
              AppMethodBeat.o(106681);
              return i;
            }
            i = a(paramcs, localagx, -5);
            AppMethodBeat.o(106681);
            return i;
            localagx = null;
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
          if (this.qLV != null) {
            this.qLV.onClick(paramAnonymousDialogInterface, -2);
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
          if (this.qLV != null) {
            this.qLV.onClick(paramAnonymousDialogInterface, -1);
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
      ac.e("MicroMsg.FavExportLogic", "handleErrorType activity = null && fragment = null");
      AppMethodBeat.o(106677);
      return;
    }
    if (paramb == null) {
      paramb = new e.1();
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
          h.d((Context)localObject, paramActivity, "", new e.2(paramOnClickListener));
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
        if (this.qLV != null) {
          this.qLV.onClick(paramAnonymousDialogInterface, -1);
        }
        AppMethodBeat.o(106673);
      }
    }, 2131101171);
    AppMethodBeat.o(106679);
  }
  
  private static boolean a(bo parambo, cs paramcs, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(106684);
    Object localObject;
    if (!bs.isNullOrNil(paramString))
    {
      localObject = new com.tencent.mm.vfs.e(paramString);
      if (((com.tencent.mm.vfs.e)localObject).exists())
      {
        if (((com.tencent.mm.vfs.e)localObject).length() > ((af)g.ad(af.class)).getFavSizeLimit(paramBoolean2, paramInt))
        {
          ac.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file is big");
          AppMethodBeat.o(106684);
          return true;
        }
        ac.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file not big");
      }
    }
    else
    {
      localObject = parambo.field_content;
      if (localObject == null) {
        break label274;
      }
    }
    label274:
    for (parambo = k.b.az((String)localObject, parambo.field_reserved);; parambo = null)
    {
      if (parambo != null)
      {
        if (parambo.hhF > ((af)g.ad(af.class)).getFavSizeLimit(paramBoolean2, paramInt))
        {
          ac.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file is big");
          AppMethodBeat.o(106684);
          return true;
          if (paramBoolean1) {
            break;
          }
          ac.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  not download finish ！attachFile.exists()");
          ((agx)paramcs.dck.dcm.nxC.getLast()).aIQ(null);
          break;
        }
        if ((!bs.isNullOrNil(paramString)) && (i.eA(paramString)) && (!paramBoolean1))
        {
          long l = i.aSp(paramString);
          if (parambo.hhF > l)
          {
            ac.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  not download finish content.attachlen > datasize");
            ((agx)paramcs.dck.dcm.nxC.getLast()).aIQ(null);
          }
        }
      }
      if ((localObject == null) || (parambo == null)) {
        ac.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  (xml == null ) ||(content == null)");
      }
      AppMethodBeat.o(106684);
      return false;
    }
  }
  
  public static Bitmap aX(String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(106687);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(106687);
      return null;
    }
    Object localObject = (Bitmap)qLT.get(paramString);
    if (localObject != null)
    {
      ac.d("MicroMsg.FavExportLogic", "get bm from cache %s", new Object[] { paramString });
      AppMethodBeat.o(106687);
      return localObject;
    }
    if (paramBoolean)
    {
      AppMethodBeat.o(106687);
      return null;
    }
    if (!i.eA(paramString))
    {
      AppMethodBeat.o(106687);
      return null;
    }
    ac.d("MicroMsg.FavExportLogic", "get from cache fail, try to decode from file");
    localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    Bitmap localBitmap = MMBitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    if (localBitmap != null)
    {
      ac.i("MicroMsg.FavExportLogic", "bitmap recycle %s", new Object[] { localBitmap });
      localBitmap.recycle();
    }
    int j;
    if ((ae.dv(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight)) && (((BitmapFactory.Options)localObject).outWidth > 480))
    {
      i = 1;
      if ((!ae.du(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight)) || (((BitmapFactory.Options)localObject).outHeight <= 480)) {
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
        ac.w("MicroMsg.FavExportLogic", "fit long picture, beg %d*%d, after %d*%d", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject).outHeight), Integer.valueOf(j), Integer.valueOf(i) });
      }
    }
    int i = BackwardSupportUtil.ExifHelper.ce(paramString);
    if ((MMNativeJpeg.IsJpegFile(paramString)) && (MMNativeJpeg.isProgressive(paramString)))
    {
      localObject = MMNativeJpeg.decodeAsBitmap(paramString);
      if (localObject == null)
      {
        paramBoolean = bool;
        ac.i("MicroMsg.FavExportLogic", "Progressive jpeg, result isNull:%b", new Object[] { Boolean.valueOf(paramBoolean) });
      }
    }
    for (;;)
    {
      if (localObject != null) {
        break label415;
      }
      ac.e("MicroMsg.FavExportLogic", "getSuitableBmp fail, temBmp is null, filePath = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(106687);
      return null;
      paramBoolean = false;
      break;
      localObject = com.tencent.mm.sdk.platformtools.f.aKA(paramString);
    }
    label415:
    localObject = com.tencent.mm.sdk.platformtools.f.a((Bitmap)localObject, i);
    if (((Bitmap)localObject).getByteCount() > 20971520)
    {
      AppMethodBeat.o(106687);
      return localObject;
    }
    qLT.put(paramString, localObject);
    AppMethodBeat.o(106687);
    return localObject;
  }
  
  public static int acR(String paramString)
  {
    AppMethodBeat.i(106688);
    paramString = (Integer)nhJ.get(paramString);
    if (paramString == null)
    {
      i = ((Integer)nhJ.get("unknown")).intValue();
      AppMethodBeat.o(106688);
      return i;
    }
    int i = paramString.intValue();
    AppMethodBeat.o(106688);
    return i;
  }
  
  @TargetApi(8)
  public static Bitmap acS(String paramString)
  {
    AppMethodBeat.i(106689);
    Bitmap localBitmap = null;
    if (d.kZ(8)) {
      localBitmap = com.tencent.mm.sdk.platformtools.f.createVideoThumbnail(paramString, 1);
    }
    AppMethodBeat.o(106689);
    return localBitmap;
  }
  
  private static void b(cs paramcs, int paramInt)
  {
    AppMethodBeat.i(106685);
    if ((paramcs.dck.dcm.nxC == null) || (paramcs.dck.dcm.nxC.size() == 0))
    {
      paramcs.dck.dcp = paramInt;
      AppMethodBeat.o(106685);
      return;
    }
    if (paramcs.dck.dcp == -9)
    {
      AppMethodBeat.o(106685);
      return;
    }
    if ((paramInt > 0) || (paramcs.dck.dcp > 0)) {}
    for (int i = 1;; i = 0)
    {
      int k = 0;
      int n = 0;
      int m = 0;
      int j = 0;
      if (k < paramcs.dck.dcm.nxC.size())
      {
        switch (((agx)paramcs.dck.dcm.nxC.get(k)).EAn)
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
          paramcs.dck.dcp = -9;
          AppMethodBeat.o(106685);
          return;
        }
        paramcs.dck.dcp = paramInt;
        AppMethodBeat.o(106685);
        return;
      }
      if (m > 0)
      {
        if (n > 0)
        {
          paramcs.dck.dcp = -8;
          AppMethodBeat.o(106685);
          return;
        }
        if (j == 0)
        {
          paramcs.dck.dcp = -5;
          AppMethodBeat.o(106685);
          return;
        }
        if (j > 0)
        {
          paramcs.dck.dcp = -7;
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
          paramcs.dck.dcp = -4;
          AppMethodBeat.o(106685);
          return;
        }
        if (j > 0)
        {
          paramcs.dck.dcp = -6;
          AppMethodBeat.o(106685);
          return;
        }
      }
      AppMethodBeat.o(106685);
      return;
    }
  }
  
  public static void cqy()
  {
    AppMethodBeat.i(106686);
    qLT = new com.tencent.mm.memory.a.b(20, e.class);
    AppMethodBeat.o(106686);
  }
  
  public static void cqz() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e
 * JD-Core Version:    0.7.0.1
 */