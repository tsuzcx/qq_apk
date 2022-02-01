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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.b.f;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.cz.a;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LongBitmapHandler;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.snackbar.a.b;
import com.tencent.mm.ui.widget.snackbar.a.c;
import com.tencent.mm.vfs.o;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class e
{
  private static Map<String, Integer> oYD;
  private static f<String, Bitmap> tdM;
  
  static
  {
    AppMethodBeat.i(106690);
    tdM = new com.tencent.mm.memory.a.b(20, e.class);
    oYD = new HashMap();
    HashMap localHashMap = new HashMap();
    oYD = localHashMap;
    localHashMap.put("avi", Integer.valueOf(2131689584));
    oYD.put("m4v", Integer.valueOf(2131689584));
    oYD.put("vob", Integer.valueOf(2131689584));
    oYD.put("mpeg", Integer.valueOf(2131689584));
    oYD.put("mpe", Integer.valueOf(2131689584));
    oYD.put("asx", Integer.valueOf(2131689584));
    oYD.put("asf", Integer.valueOf(2131689584));
    oYD.put("f4v", Integer.valueOf(2131689584));
    oYD.put("flv", Integer.valueOf(2131689584));
    oYD.put("mkv", Integer.valueOf(2131689584));
    oYD.put("wmv", Integer.valueOf(2131689584));
    oYD.put("wm", Integer.valueOf(2131689584));
    oYD.put("3gp", Integer.valueOf(2131689584));
    oYD.put("mp4", Integer.valueOf(2131689584));
    oYD.put("rmvb", Integer.valueOf(2131689584));
    oYD.put("rm", Integer.valueOf(2131689584));
    oYD.put("ra", Integer.valueOf(2131689584));
    oYD.put("ram", Integer.valueOf(2131689584));
    oYD.put("mp3pro", Integer.valueOf(2131689567));
    oYD.put("vqf", Integer.valueOf(2131689567));
    oYD.put("cd", Integer.valueOf(2131689567));
    oYD.put("md", Integer.valueOf(2131689567));
    oYD.put("mod", Integer.valueOf(2131689567));
    oYD.put("vorbis", Integer.valueOf(2131689567));
    oYD.put("au", Integer.valueOf(2131689567));
    oYD.put("amr", Integer.valueOf(2131689567));
    oYD.put("silk", Integer.valueOf(2131689567));
    oYD.put("wma", Integer.valueOf(2131689567));
    oYD.put("mmf", Integer.valueOf(2131689567));
    oYD.put("mid", Integer.valueOf(2131689567));
    oYD.put("midi", Integer.valueOf(2131689567));
    oYD.put("mp3", Integer.valueOf(2131689567));
    oYD.put("aac", Integer.valueOf(2131689567));
    oYD.put("ape", Integer.valueOf(2131689567));
    oYD.put("aiff", Integer.valueOf(2131689567));
    oYD.put("aif", Integer.valueOf(2131689567));
    oYD.put("jfif", Integer.valueOf(2131689573));
    oYD.put("tiff", Integer.valueOf(2131689573));
    oYD.put("tif", Integer.valueOf(2131689573));
    oYD.put("jpe", Integer.valueOf(2131689573));
    oYD.put("dib", Integer.valueOf(2131689573));
    oYD.put("jpeg", Integer.valueOf(2131689573));
    oYD.put("jpg", Integer.valueOf(2131689573));
    oYD.put("png", Integer.valueOf(2131689573));
    oYD.put("bmp", Integer.valueOf(2131689573));
    oYD.put("gif", Integer.valueOf(2131689573));
    oYD.put("rar", Integer.valueOf(2131689576));
    oYD.put("zip", Integer.valueOf(2131689576));
    oYD.put("7z", Integer.valueOf(2131689576));
    oYD.put("iso", Integer.valueOf(2131689576));
    oYD.put("cab", Integer.valueOf(2131689576));
    oYD.put("doc", Integer.valueOf(2131689588));
    oYD.put("docx", Integer.valueOf(2131689588));
    oYD.put("ppt", Integer.valueOf(2131689574));
    oYD.put("pptx", Integer.valueOf(2131689574));
    oYD.put("xls", Integer.valueOf(2131689560));
    oYD.put("xlsx", Integer.valueOf(2131689560));
    oYD.put("txt", Integer.valueOf(2131689579));
    oYD.put("rtf", Integer.valueOf(2131689579));
    oYD.put("pdf", Integer.valueOf(2131689571));
    oYD.put("unknown", Integer.valueOf(2131689580));
    AppMethodBeat.o(106690);
  }
  
  private static int a(cz paramcz, int paramInt)
  {
    AppMethodBeat.i(106682);
    aml localaml;
    if ((paramcz.dFZ.dGb.ppH != null) && (paramcz.dFZ.dGb.ppH.size() > 0))
    {
      localaml = (aml)paramcz.dFZ.dGb.ppH.getLast();
      if (paramInt <= 0) {
        switch (paramInt)
        {
        default: 
          localaml.ajf(0);
        }
      }
    }
    for (;;)
    {
      b(paramcz, paramInt);
      AppMethodBeat.o(106682);
      return paramInt;
      localaml.ajf(1);
      localaml.bgt(null);
      continue;
      localaml.ajf(2);
      localaml.bgt(null);
    }
  }
  
  private static int a(cz paramcz, aml paramaml, int paramInt)
  {
    AppMethodBeat.i(106683);
    if (paramaml == null)
    {
      paramInt = a(paramcz, paramInt);
      AppMethodBeat.o(106683);
      return paramInt;
    }
    if (paramInt <= 0) {
      switch (paramInt)
      {
      default: 
        paramaml.ajf(0);
      }
    }
    for (;;)
    {
      b(paramcz, paramInt);
      AppMethodBeat.o(106683);
      return paramInt;
      paramaml.ajf(1);
      paramaml.bgt(null);
      continue;
      paramaml.ajf(2);
      paramaml.bgt(null);
    }
  }
  
  public static int a(ca paramca, cz paramcz, boolean paramBoolean)
  {
    AppMethodBeat.i(106681);
    Object localObject1 = "";
    Log.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo msg type is %d", new Object[] { Integer.valueOf(paramca.getType()) });
    int i;
    if ((!paramBoolean) && (paramcz.dFZ.dGe > 0))
    {
      Log.i("MicroMsg.FavExportLogic", "(!result)&&(favoriteEvent.data.errorType > FavExportLogic.KEY_FAV_PARA_NO_ERROR)");
      i = a(paramcz, paramcz.dFZ.dGe);
      AppMethodBeat.o(106681);
      return i;
    }
    if ((paramcz.dFZ.type == 4) || (paramcz.dFZ.type == 8) || (paramcz.dFZ.type == 16) || (paramcz.dFZ.type == 2)) {}
    for (paramBoolean = false;; paramBoolean = true)
    {
      boolean bool = paramBoolean;
      aml localaml;
      if (paramcz.dFZ.type == 14)
      {
        bool = paramBoolean;
        if (paramcz.dFZ.dGb.ppH.size() > 0)
        {
          localaml = (aml)paramcz.dFZ.dGb.ppH.getLast();
          if ((localaml.dataType != 4) && (localaml.dataType != 8) && (localaml.dataType != 15))
          {
            bool = paramBoolean;
            if (localaml.dataType != 2) {}
          }
          else
          {
            bool = false;
          }
        }
      }
      if ((paramcz.dFZ.type == 14) || (paramcz.dFZ.type == 18)) {}
      for (paramBoolean = false;; paramBoolean = true)
      {
        Log.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo msg type skipCheck %B", new Object[] { Boolean.valueOf(bool) });
        if ((bool) || (paramca.cWK()))
        {
          i = a(paramcz, 0);
          AppMethodBeat.o(106681);
          return i;
        }
        if (paramcz.dFZ.dGb == null)
        {
          i = a(paramcz, -1);
          AppMethodBeat.o(106681);
          return i;
        }
        if (paramcz.dFZ.dGb.ppH == null)
        {
          i = a(paramcz, -1);
          AppMethodBeat.o(106681);
          return i;
        }
        if (System.currentTimeMillis() - paramca.field_createTime > 259200000L) {}
        for (bool = true;; bool = false)
        {
          Log.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo isOverThreeDays %B", new Object[] { Boolean.valueOf(bool) });
          if (1 <= paramcz.dFZ.dGb.ppH.size())
          {
            localaml = (aml)paramcz.dFZ.dGb.ppH.getLast();
            localObject1 = localaml.LvL;
          }
          for (i = localaml.dataType;; i = 0)
          {
            if (localaml == null) {
              Log.w("MicroMsg.FavExportLogic", "dataItem is null, size:" + paramcz.dFZ.dGb.ppH.size());
            }
            if (bool)
            {
              if (!Util.isNullOrNil((String)localObject1))
              {
                localObject2 = localObject1;
                if (com.tencent.mm.vfs.s.YS((String)localObject1)) {}
              }
              else
              {
                if ((paramca != null) && ((paramca.getType() == 43) || (paramca.getType() == 44) || (paramca.getType() == 62)))
                {
                  localObject1 = com.tencent.mm.modelvideo.u.QN(paramca.field_imgPath);
                  if ((localObject1 != null) && (((com.tencent.mm.modelvideo.s)localObject1).jsu == -1))
                  {
                    localObject1 = ((com.tencent.mm.modelvideo.s)localObject1).bhu();
                    if (!com.tencent.mm.vfs.s.YS((String)localObject1)) {}
                  }
                }
                while (Util.isNullOrNil((String)localObject1))
                {
                  i = a(paramcz, localaml, -4);
                  AppMethodBeat.o(106681);
                  return i;
                  localObject1 = null;
                }
                ((aml)paramcz.dFZ.dGb.ppH.getLast()).bgt((String)localObject1);
                localObject2 = localObject1;
              }
              if (a(paramca, paramcz, localObject2, true, paramBoolean, i))
              {
                i = a(paramcz, localaml, -5);
                AppMethodBeat.o(106681);
                return i;
              }
              Log.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  isOverThreeDays true not big not expired");
            }
            while (!a(paramca, paramcz, (String)localObject1, false, paramBoolean, i))
            {
              Object localObject2;
              Log.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  fav data is normal");
              i = a(paramcz, localaml, 0);
              AppMethodBeat.o(106681);
              return i;
            }
            i = a(paramcz, localaml, -5);
            AppMethodBeat.o(106681);
            return i;
            localaml = null;
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
      h.a((Context)localObject, str, "", ((Context)localObject).getString(2131763947), ((Context)localObject).getString(2131757785), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(106674);
          paramAnonymousDialogInterface.dismiss();
          if (this.tdO != null) {
            this.tdO.onClick(paramAnonymousDialogInterface, -2);
          }
          if (paramFragment != null)
          {
            paramAnonymousDialogInterface = paramFragment.getView();
            if ((paramFragment instanceof MMFragment)) {
              paramAnonymousDialogInterface = ((MMFragment)paramFragment).getContentView();
            }
            com.tencent.mm.ui.widget.snackbar.b.a(paramFragment.getContext(), paramAnonymousDialogInterface, paramFragment.getActivity().getString(2131759260), paramFragment.getActivity().getString(2131759169), paramb, paramc);
            AppMethodBeat.o(106674);
            return;
          }
          com.tencent.mm.ui.widget.snackbar.b.a(paramActivity, paramActivity.getString(2131759260), paramActivity.getString(2131759169), paramb, paramc);
          AppMethodBeat.o(106674);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(106675);
          paramAnonymousDialogInterface.dismiss();
          if (this.tdO != null) {
            this.tdO.onClick(paramAnonymousDialogInterface, -1);
          }
          AppMethodBeat.o(106675);
        }
      }, 2131101414);
      AppMethodBeat.o(106680);
      return;
      localObject = paramFragment.getActivity();
      break;
      str = ((Context)localObject).getString(2131759206);
      continue;
      str = ((Context)localObject).getString(2131759205);
      continue;
      str = ((Context)localObject).getString(2131759207);
      continue;
      str = ((Context)localObject).getString(2131759221);
      continue;
      label197:
      if (paramInt2 == -5)
      {
        if (paramInt1 != 14)
        {
          if (paramInt1 == 2) {
            str = ((Context)localObject).getString(2131759170, new Object[] { Integer.valueOf(((af)g.ah(af.class)).getImageSizeLimitInMB(true)) });
          } else if (paramInt1 == 4) {
            str = ((Context)localObject).getString(2131759170, new Object[] { Integer.valueOf(((af)g.ah(af.class)).getVideoSizeLimitInMB(true)) });
          } else {
            str = ((Context)localObject).getString(2131759170, new Object[] { Integer.valueOf(((af)g.ah(af.class)).getFileSizeLimitInMB(true)) });
          }
        }
        else {
          str = ((Context)localObject).getString(2131759220);
        }
      }
      else if (paramInt2 == -6)
      {
        str = ((Context)localObject).getString(2131759221);
      }
      else if (paramInt2 == -7)
      {
        str = ((Context)localObject).getString(2131759220);
      }
      else if (paramInt2 == -8)
      {
        str = ((Context)localObject).getString(2131759222);
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
            com.tencent.mm.ui.widget.snackbar.b.a(paramFragment.getContext(), paramActivity, ((Context)localObject).getString(2131759260), ((Context)localObject).getString(2131759169), paramb, paramc);
            AppMethodBeat.o(106680);
            return;
          }
          com.tencent.mm.ui.widget.snackbar.b.a(paramActivity, ((Context)localObject).getString(2131759260), ((Context)localObject).getString(2131759169), paramb, paramc);
          AppMethodBeat.o(106680);
          return;
        }
        str = ((Context)localObject).getString(2131759209);
      }
    }
  }
  
  public static void a(int paramInt1, int paramInt2, Activity paramActivity, Fragment paramFragment, a.c paramc, DialogInterface.OnClickListener paramOnClickListener, a.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(235282);
    if ((paramActivity == null) && (paramFragment == null))
    {
      Log.e("MicroMsg.FavExportLogic", "handleErrorType activity = null && fragment = null");
      AppMethodBeat.o(235282);
      return;
    }
    if (paramb == null) {
      paramb = new e.1();
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
            com.tencent.mm.ui.widget.snackbar.b.a(paramFragment.getContext(), paramActivity, paramFragment.getString(2131759260), paramFragment.getString(2131759169), paramb, paramc);
            AppMethodBeat.o(235282);
            return;
          }
          if (paramActivity != null)
          {
            com.tencent.mm.ui.widget.snackbar.b.a(paramActivity, paramActivity.getString(2131759260), paramActivity.getString(2131759169), paramb, paramc);
            AppMethodBeat.o(235282);
          }
        }
      }
      else {
        if (paramActivity != null) {
          break label420;
        }
      }
      label420:
      for (Object localObject = paramFragment.getActivity();; localObject = paramActivity)
      {
        switch (paramInt2)
        {
        case -3: 
        default: 
          if (paramInt2 == 2131759351) {
            if (paramInt1 == 2) {
              paramActivity = ((Activity)localObject).getString(2131759351, new Object[] { Integer.valueOf(((af)g.ah(af.class)).getImageSizeLimitInMB(true)) });
            }
          }
          break;
        }
        for (;;)
        {
          h.d((Context)localObject, paramActivity, "", new e.2(paramOnClickListener));
          AppMethodBeat.o(235282);
          return;
          f((Context)localObject, paramOnClickListener);
          AppMethodBeat.o(235282);
          return;
          a(paramInt1, paramInt2, (Activity)localObject, paramFragment, paramOnClickListener, paramb, paramc);
          AppMethodBeat.o(235282);
          return;
          a((Activity)localObject, paramFragment);
          AppMethodBeat.o(235282);
          return;
          if ((paramInt1 == 4) || (paramInt1 == 16))
          {
            paramActivity = ((Activity)localObject).getString(2131759351, new Object[] { Integer.valueOf(((af)g.ah(af.class)).getVideoSizeLimitInMB(true)) });
          }
          else
          {
            paramActivity = ((Activity)localObject).getString(2131759351, new Object[] { Integer.valueOf(((af)g.ah(af.class)).getFileSizeLimitInMB(true)) });
            continue;
            paramActivity = ((Activity)localObject).getString(2131759350);
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
    AppMethodBeat.i(235281);
    a(-1, paramInt, paramActivity, null, paramc, paramOnClickListener, paramb, true);
    AppMethodBeat.o(235281);
  }
  
  private static void a(Activity paramActivity, Fragment paramFragment)
  {
    AppMethodBeat.i(106678);
    if (paramFragment != null) {
      paramActivity = paramFragment.getActivity();
    }
    com.tencent.mm.ui.base.u.makeText(paramActivity, 2131759218, 0).show();
    AppMethodBeat.o(106678);
  }
  
  private static boolean a(ca paramca, cz paramcz, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(106684);
    Object localObject;
    if (!Util.isNullOrNil(paramString))
    {
      localObject = new o(paramString);
      if (((o)localObject).exists())
      {
        if (((o)localObject).length() > ((af)g.ah(af.class)).getFavSizeLimit(paramBoolean2, paramInt))
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
        break label274;
      }
    }
    label274:
    for (paramca = k.b.aD((String)localObject, paramca.field_reserved);; paramca = null)
    {
      if (paramca != null)
      {
        if (paramca.iwI > ((af)g.ah(af.class)).getFavSizeLimit(paramBoolean2, paramInt))
        {
          Log.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file is big");
          AppMethodBeat.o(106684);
          return true;
          if (paramBoolean1) {
            break;
          }
          Log.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  not download finish ！attachFile.exists()");
          ((aml)paramcz.dFZ.dGb.ppH.getLast()).bgt(null);
          break;
        }
        if ((!Util.isNullOrNil(paramString)) && (com.tencent.mm.vfs.s.YS(paramString)) && (!paramBoolean1))
        {
          long l = com.tencent.mm.vfs.s.boW(paramString);
          if (paramca.iwI > l)
          {
            Log.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  not download finish content.attachlen > datasize");
            ((aml)paramcz.dFZ.dGb.ppH.getLast()).bgt(null);
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
  
  public static int asl(String paramString)
  {
    AppMethodBeat.i(106688);
    paramString = (Integer)oYD.get(paramString);
    if (paramString == null)
    {
      i = ((Integer)oYD.get("unknown")).intValue();
      AppMethodBeat.o(106688);
      return i;
    }
    int i = paramString.intValue();
    AppMethodBeat.o(106688);
    return i;
  }
  
  @TargetApi(8)
  public static Bitmap asm(String paramString)
  {
    AppMethodBeat.i(106689);
    Bitmap localBitmap = null;
    if (d.oD(8)) {
      localBitmap = BitmapUtil.createVideoThumbnail(paramString, 1);
    }
    AppMethodBeat.o(106689);
    return localBitmap;
  }
  
  private static void b(cz paramcz, int paramInt)
  {
    AppMethodBeat.i(106685);
    if ((paramcz.dFZ.dGb.ppH == null) || (paramcz.dFZ.dGb.ppH.size() == 0))
    {
      paramcz.dFZ.dGe = paramInt;
      AppMethodBeat.o(106685);
      return;
    }
    if (paramcz.dFZ.dGe == -9)
    {
      AppMethodBeat.o(106685);
      return;
    }
    if ((paramInt > 0) || (paramcz.dFZ.dGe > 0)) {}
    for (int i = 1;; i = 0)
    {
      int k = 0;
      int n = 0;
      int m = 0;
      int j = 0;
      if (k < paramcz.dFZ.dGb.ppH.size())
      {
        switch (((aml)paramcz.dFZ.dGb.ppH.get(k)).Lwv)
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
          paramcz.dFZ.dGe = -9;
          AppMethodBeat.o(106685);
          return;
        }
        paramcz.dFZ.dGe = paramInt;
        AppMethodBeat.o(106685);
        return;
      }
      if (m > 0)
      {
        if (n > 0)
        {
          paramcz.dFZ.dGe = -8;
          AppMethodBeat.o(106685);
          return;
        }
        if (j == 0)
        {
          paramcz.dFZ.dGe = -5;
          AppMethodBeat.o(106685);
          return;
        }
        if (j > 0)
        {
          paramcz.dFZ.dGe = -7;
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
          paramcz.dFZ.dGe = -4;
          AppMethodBeat.o(106685);
          return;
        }
        if (j > 0)
        {
          paramcz.dFZ.dGe = -6;
          AppMethodBeat.o(106685);
          return;
        }
      }
      AppMethodBeat.o(106685);
      return;
    }
  }
  
  public static Bitmap bd(String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(106687);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(106687);
      return null;
    }
    Object localObject = (Bitmap)tdM.get(paramString);
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
    if (!com.tencent.mm.vfs.s.YS(paramString))
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
        break label415;
      }
      Log.e("MicroMsg.FavExportLogic", "getSuitableBmp fail, temBmp is null, filePath = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(106687);
      return null;
      paramBoolean = false;
      break;
      localObject = BitmapUtil.decodeFileWithSample(paramString);
    }
    label415:
    localObject = BitmapUtil.rotate((Bitmap)localObject, i);
    if (((Bitmap)localObject).getByteCount() > 20971520)
    {
      AppMethodBeat.o(106687);
      return localObject;
    }
    tdM.put(paramString, localObject);
    AppMethodBeat.o(106687);
    return localObject;
  }
  
  public static void cVI()
  {
    AppMethodBeat.i(106686);
    tdM = new com.tencent.mm.memory.a.b(20, e.class);
    AppMethodBeat.o(106686);
  }
  
  public static void cVJ() {}
  
  private static void f(Context paramContext, final DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(106679);
    h.a(paramContext, paramContext.getString(2131759211), paramContext.getString(2131759212), paramContext.getString(2131759214), paramContext.getString(2131757785), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
        if (this.tdO != null) {
          this.tdO.onClick(paramAnonymousDialogInterface, -1);
        }
        AppMethodBeat.o(106673);
      }
    }, 2131101414);
    AppMethodBeat.o(106679);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e
 * JD-Core Version:    0.7.0.1
 */