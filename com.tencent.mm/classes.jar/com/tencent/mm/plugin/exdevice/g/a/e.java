package com.tencent.mm.plugin.exdevice.g.a;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.g.c.av;
import com.tencent.mm.i.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.gallery.picker.view.ImageCropUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
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
      if (!ap.isMainThread()) {
        break;
      }
      b(paramImageView, paramString, 2131100204);
      AppMethodBeat.o(23509);
      return;
    }
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23506);
        e.b(paramImageView, paramString, this.pBg);
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
        paramString.putExtra("CropImage_OutputPath", com.tencent.mm.loader.j.b.apw() + "temp.cover");
        paramString.putExtra("CropImage_ImgPath", paramIntent);
        paramMMActivity.startActivityForResult(paramString, 1002);
        AppMethodBeat.o(23512);
        return true;
      }
    }
    else if ((paramInt1 == 1002) && (paramInt2 == -1))
    {
      paramMMActivity = d.YU(com.tencent.mm.loader.j.b.apw() + "temp.cover");
      paramIntent = ad.cgZ();
      paramIntent.appName = paramString;
      long l = System.currentTimeMillis();
      paramIntent.pBc = com.tencent.mm.an.c.a("uploadexdeivce", l, u.ayc().field_username, String.valueOf(l));
      paramString = paramIntent.pBc;
      g localg = new g();
      localg.frb = paramIntent;
      localg.field_mediaId = paramString;
      localg.field_fullpath = paramMMActivity;
      localg.field_thumbpath = "";
      localg.field_fileType = com.tencent.mm.i.a.fqB;
      localg.field_talker = "";
      localg.field_priority = com.tencent.mm.i.a.fqo;
      localg.field_needStorage = true;
      localg.field_isStreamMedia = false;
      localg.field_appType = 200;
      localg.field_bzScene = 2;
      if (!f.aDD().f(localg)) {
        ac.e("MicroMsg.ExdevicePictureUploader", "hy: cdntra addSendTask failed. clientid:%s", new Object[] { paramString });
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
    if ((!bs.isNullOrNil(paramString)) && (!"#".equals(paramString)))
    {
      ac.d("MicroMsg.ExdeviceRankUtil", "hy: set url to %s", new Object[] { paramString });
      ad.cgS().a(paramString, paramImageView, ad.YS(paramString));
      AppMethodBeat.o(23510);
      return;
    }
    ac.d("MicroMsg.ExdeviceRankUtil", "hy: url is null or nill. set to default picture resource");
    paramImageView.setImageResource(paramInt);
    AppMethodBeat.o(23510);
  }
  
  public static void d(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(23511);
    com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(paramMMActivity.getContext(), 1, false);
    locale.ISu = new e.2(paramMMActivity);
    locale.ISv = new e.3(paramMMActivity);
    locale.cED();
    AppMethodBeat.o(23511);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.e
 * JD-Core Version:    0.7.0.1
 */