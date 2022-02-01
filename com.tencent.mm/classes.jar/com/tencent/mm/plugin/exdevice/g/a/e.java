package com.tencent.mm.plugin.exdevice.g.a;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.i.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.gallery.picker.view.ImageCropUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import java.util.ArrayList;
import junit.framework.Assert;

public final class e
{
  public static void a(Context paramContext, final ImageView paramImageView, final String paramString)
  {
    AppMethodBeat.i(23509);
    if (paramImageView != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (!MMHandlerThread.isMainThread()) {
        break;
      }
      b(paramImageView, paramString, 2131100237);
      AppMethodBeat.o(23509);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23506);
        e.b(paramImageView, paramString, this.rCl);
        AppMethodBeat.o(23506);
      }
    });
    AppMethodBeat.o(23509);
  }
  
  public static boolean a(MMActivity paramMMActivity, int paramInt1, int paramInt2, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(23512);
    if ((paramInt1 == 1001) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
      if ((paramIntent != null) && (paramIntent.size() > 0))
      {
        paramIntent = (String)paramIntent.get(0);
        paramString = new Intent(paramMMActivity, ImageCropUI.class);
        paramString.putExtra("CropImageMode", 1);
        paramString.putExtra("CropImage_OutputPath", com.tencent.mm.loader.j.b.aKZ() + "temp.cover");
        paramString.putExtra("CropImage_ImgPath", paramIntent);
        paramMMActivity.startActivityForResult(paramString, 1002);
        AppMethodBeat.o(23512);
        return true;
      }
    }
    else if ((paramInt1 == 1002) && (paramInt2 == -1))
    {
      paramMMActivity = d.anA(com.tencent.mm.loader.j.b.aKZ() + "temp.cover");
      paramIntent = ad.cKV();
      paramIntent.appName = paramString;
      long l = System.currentTimeMillis();
      paramIntent.rCh = com.tencent.mm.an.c.a("uploadexdeivce", l, z.aUL().field_username, String.valueOf(l));
      paramString = paramIntent.rCh;
      g localg = new g();
      localg.taskName = "task_ExdevicePictureUploader";
      localg.gqy = paramIntent;
      localg.field_mediaId = paramString;
      localg.field_fullpath = paramMMActivity;
      localg.field_thumbpath = "";
      localg.field_fileType = com.tencent.mm.i.a.gpY;
      localg.field_talker = "";
      localg.field_priority = com.tencent.mm.i.a.gpL;
      localg.field_needStorage = true;
      localg.field_isStreamMedia = false;
      localg.field_appType = 200;
      localg.field_bzScene = 2;
      if (!f.baQ().f(localg)) {
        Log.e("MicroMsg.ExdevicePictureUploader", "hy: cdntra addSendTask failed. clientid:%s", new Object[] { paramString });
      }
      AppMethodBeat.o(23512);
      return true;
    }
    AppMethodBeat.o(23512);
    return false;
  }
  
  static void b(ImageView paramImageView, String paramString, int paramInt)
  {
    AppMethodBeat.i(23510);
    if ((!Util.isNullOrNil(paramString)) && (!"#".equals(paramString)))
    {
      Log.d("MicroMsg.ExdeviceRankUtil", "hy: set url to %s", new Object[] { paramString });
      ad.cKO().a(paramString, paramImageView, ad.any(paramString));
      AppMethodBeat.o(23510);
      return;
    }
    Log.d("MicroMsg.ExdeviceRankUtil", "hy: url is null or nill. set to default picture resource");
    paramImageView.setImageResource(paramInt);
    AppMethodBeat.o(23510);
  }
  
  public static void e(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(23511);
    com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(paramMMActivity.getContext(), 1, false);
    locale.HLX = new o.f()
    {
      public final void onCreateMMMenu(m paramAnonymousm)
      {
        AppMethodBeat.i(23507);
        paramAnonymousm.d(0, this.rCm.getString(2131758798));
        AppMethodBeat.o(23507);
      }
    };
    locale.HLY = new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(23508);
        if (paramAnonymousMenuItem.getItemId() == 0)
        {
          paramAnonymousMenuItem = this.rCm;
          Intent localIntent = new Intent();
          localIntent.putExtra("query_source_type", 9);
          localIntent.putExtra("query_media_type", 1);
          localIntent.putExtra("max_select_count", 1);
          com.tencent.mm.br.c.b(paramAnonymousMenuItem, "gallery", ".ui.AlbumPreviewUI", localIntent, 1001);
        }
        AppMethodBeat.o(23508);
      }
    };
    locale.dGm();
    AppMethodBeat.o(23511);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.e
 * JD-Core Version:    0.7.0.1
 */