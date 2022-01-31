package com.tencent.mm.plugin.exdevice.f.a;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.f;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.i.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class e
{
  public static void a(Context paramContext, ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(19441);
    if (paramImageView != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (!al.isMainThread()) {
        break;
      }
      b(paramImageView, paramString, 2131689922);
      AppMethodBeat.o(19441);
      return;
    }
    al.d(new e.1(paramContext, paramImageView, paramString));
    AppMethodBeat.o(19441);
  }
  
  public static boolean a(MMActivity paramMMActivity, int paramInt1, int paramInt2, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(19444);
    if ((paramInt1 == 1001) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
      if ((paramIntent != null) && (paramIntent.size() > 0))
      {
        paramIntent = (String)paramIntent.get(0);
        paramString = new Intent();
        paramString.putExtra("CropImageMode", 1);
        paramString.putExtra("CropImage_OutputPath", com.tencent.mm.compatible.util.e.esz + "temp.cover");
        paramString.putExtra("CropImage_ImgPath", paramIntent);
        com.tencent.mm.bq.d.b(paramMMActivity, ".ui.tools.CropImageNewUI", paramString, 1002);
        AppMethodBeat.o(19444);
        return true;
      }
    }
    else if ((paramInt1 == 1002) && (paramInt2 == -1))
    {
      paramMMActivity = d.Lz(com.tencent.mm.compatible.util.e.esz + "temp.cover");
      paramIntent = ad.bqi();
      paramIntent.appName = paramString;
      long l = System.currentTimeMillis();
      paramIntent.lHg = com.tencent.mm.al.c.a("uploadexdeivce", l, r.ZS().field_username, String.valueOf(l));
      paramString = paramIntent.lHg;
      g localg = new g();
      localg.edp = paramIntent;
      localg.field_mediaId = paramString;
      localg.field_fullpath = paramMMActivity;
      localg.field_thumbpath = "";
      localg.field_fileType = com.tencent.mm.i.a.ecQ;
      localg.field_talker = "";
      localg.field_priority = com.tencent.mm.i.a.ecE;
      localg.field_needStorage = true;
      localg.field_isStreamMedia = false;
      localg.field_appType = 200;
      localg.field_bzScene = 2;
      if (!f.afO().e(localg)) {
        ab.e("MicroMsg.ExdevicePictureUploader", "hy: cdntra addSendTask failed. clientid:%s", new Object[] { paramString });
      }
      AppMethodBeat.o(19444);
      return true;
    }
    AppMethodBeat.o(19444);
    return false;
  }
  
  static void b(ImageView paramImageView, String paramString, int paramInt)
  {
    AppMethodBeat.i(19442);
    if ((!bo.isNullOrNil(paramString)) && (!"#".equals(paramString)))
    {
      ab.d("MicroMsg.ExdeviceRankUtil", "hy: set url to %s", new Object[] { paramString });
      ad.bqb().a(paramString, paramImageView, ad.Lx(paramString));
      AppMethodBeat.o(19442);
      return;
    }
    ab.d("MicroMsg.ExdeviceRankUtil", "hy: url is null or nill. set to default picture resource");
    paramImageView.setImageResource(paramInt);
    AppMethodBeat.o(19442);
  }
  
  public static void e(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(19443);
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    localLinkedList1.add(paramMMActivity.getString(2131299371));
    localLinkedList2.add(Integer.valueOf(0));
    h.a(paramMMActivity, "", localLinkedList1, localLinkedList2, null, true, new e.2(paramMMActivity));
    AppMethodBeat.o(19443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.a.e
 * JD-Core Version:    0.7.0.1
 */