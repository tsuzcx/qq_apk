package com.tencent.mm.plugin.exdevice.g.a;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.model.z;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.plugin.exdevice.model.ah;
import com.tencent.mm.plugin.gallery.picker.view.ImageCropUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.widget.a.f;
import java.util.ArrayList;
import junit.framework.Assert;

public final class e
{
  public static void a(Context paramContext, final ImageView paramImageView, final String paramString, final int paramInt)
  {
    AppMethodBeat.i(274567);
    if (paramImageView != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (!MMHandlerThread.isMainThread()) {
        break;
      }
      b(paramImageView, paramString, paramInt);
      AppMethodBeat.o(274567);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23506);
        e.b(paramImageView, paramString, paramInt);
        AppMethodBeat.o(23506);
      }
    });
    AppMethodBeat.o(274567);
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
        paramString.putExtra("CropImage_OutputPath", b.bmP() + "temp.cover");
        paramString.putExtra("CropImage_ImgPath", paramIntent);
        paramMMActivity.startActivityForResult(paramString, 1002);
        AppMethodBeat.o(23512);
        return true;
      }
    }
    else if ((paramInt1 == 1002) && (paramInt2 == -1))
    {
      paramMMActivity = d.apz(b.bmP() + "temp.cover");
      paramIntent = ah.dGb();
      paramIntent.appName = paramString;
      long l = System.currentTimeMillis();
      paramIntent.ytQ = h.a("uploadexdeivce", l, z.bBF().field_username, String.valueOf(l));
      paramString = paramIntent.ytQ;
      com.tencent.mm.g.g localg = new com.tencent.mm.g.g();
      localg.taskName = "task_ExdevicePictureUploader";
      localg.lwL = paramIntent;
      localg.field_mediaId = paramString;
      localg.field_fullpath = paramMMActivity;
      localg.field_thumbpath = "";
      localg.field_fileType = com.tencent.mm.g.a.lwl;
      localg.field_talker = "";
      localg.field_priority = com.tencent.mm.g.a.lvY;
      localg.field_needStorage = true;
      localg.field_isStreamMedia = false;
      localg.field_appType = 200;
      localg.field_bzScene = 2;
      if (!k.bHW().g(localg)) {
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
      ah.dFU().a(paramString, paramImageView, ah.apx(paramString));
      AppMethodBeat.o(23510);
      return;
    }
    Log.d("MicroMsg.ExdeviceRankUtil", "hy: url is null or nill. set to default picture resource");
    paramImageView.setImageResource(paramInt);
    AppMethodBeat.o(23510);
  }
  
  public static void g(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(23511);
    f localf = new f(paramMMActivity.getContext(), 1, false);
    localf.Vtg = new u.g()
    {
      public final void onCreateMMMenu(s paramAnonymouss)
      {
        AppMethodBeat.i(23507);
        paramAnonymouss.c(0, e.this.getString(R.l.gFN));
        AppMethodBeat.o(23507);
      }
    };
    localf.GAC = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(23508);
        if (paramAnonymousMenuItem.getItemId() == 0)
        {
          paramAnonymousMenuItem = e.this;
          Intent localIntent = new Intent();
          localIntent.putExtra("query_source_type", 9);
          localIntent.putExtra("query_media_type", 1);
          localIntent.putExtra("max_select_count", 1);
          com.tencent.mm.br.c.b(paramAnonymousMenuItem, "gallery", ".ui.AlbumPreviewUI", localIntent, 1001);
        }
        AppMethodBeat.o(23508);
      }
    };
    localf.dDn();
    AppMethodBeat.o(23511);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.e
 * JD-Core Version:    0.7.0.1
 */