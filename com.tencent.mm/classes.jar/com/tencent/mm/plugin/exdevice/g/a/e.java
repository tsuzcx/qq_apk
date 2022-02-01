package com.tencent.mm.plugin.exdevice.g.a;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.i.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.gallery.picker.view.ImageCropUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
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
      if (!ar.isMainThread()) {
        break;
      }
      b(paramImageView, paramString, 2131100204);
      AppMethodBeat.o(23509);
      return;
    }
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23506);
        e.b(paramImageView, paramString, this.qlq);
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
        paramString.putExtra("CropImage_OutputPath", com.tencent.mm.loader.j.b.asz() + "temp.cover");
        paramString.putExtra("CropImage_ImgPath", paramIntent);
        paramMMActivity.startActivityForResult(paramString, 1002);
        AppMethodBeat.o(23512);
        return true;
      }
    }
    else if ((paramInt1 == 1002) && (paramInt2 == -1))
    {
      paramMMActivity = d.adr(com.tencent.mm.loader.j.b.asz() + "temp.cover");
      paramIntent = ad.cmT();
      paramIntent.appName = paramString;
      long l = System.currentTimeMillis();
      paramIntent.qlm = com.tencent.mm.an.c.a("uploadexdeivce", l, v.aBo().field_username, String.valueOf(l));
      paramString = paramIntent.qlm;
      g localg = new g();
      localg.fLl = "task_ExdevicePictureUploader";
      localg.fLm = paramIntent;
      localg.field_mediaId = paramString;
      localg.field_fullpath = paramMMActivity;
      localg.field_thumbpath = "";
      localg.field_fileType = com.tencent.mm.i.a.fKM;
      localg.field_talker = "";
      localg.field_priority = com.tencent.mm.i.a.fKz;
      localg.field_needStorage = true;
      localg.field_isStreamMedia = false;
      localg.field_appType = 200;
      localg.field_bzScene = 2;
      if (!f.aGZ().f(localg)) {
        ae.e("MicroMsg.ExdevicePictureUploader", "hy: cdntra addSendTask failed. clientid:%s", new Object[] { paramString });
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
    if ((!bu.isNullOrNil(paramString)) && (!"#".equals(paramString)))
    {
      ae.d("MicroMsg.ExdeviceRankUtil", "hy: set url to %s", new Object[] { paramString });
      ad.cmM().a(paramString, paramImageView, ad.adp(paramString));
      AppMethodBeat.o(23510);
      return;
    }
    ae.d("MicroMsg.ExdeviceRankUtil", "hy: url is null or nill. set to default picture resource");
    paramImageView.setImageResource(paramInt);
    AppMethodBeat.o(23510);
  }
  
  public static void e(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(23511);
    com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(paramMMActivity.getContext(), 1, false);
    locale.LfS = new n.d()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(23507);
        paramAnonymousl.d(0, this.qlr.getString(2131758499));
        AppMethodBeat.o(23507);
      }
    };
    locale.LfT = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(23508);
        if (paramAnonymousMenuItem.getItemId() == 0)
        {
          paramAnonymousMenuItem = this.qlr;
          Intent localIntent = new Intent();
          localIntent.putExtra("query_source_type", 9);
          localIntent.putExtra("query_media_type", 1);
          localIntent.putExtra("max_select_count", 1);
          com.tencent.mm.br.d.b(paramAnonymousMenuItem, "gallery", ".ui.AlbumPreviewUI", localIntent, 1001);
        }
        AppMethodBeat.o(23508);
      }
    };
    locale.cPF();
    AppMethodBeat.o(23511);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.e
 * JD-Core Version:    0.7.0.1
 */