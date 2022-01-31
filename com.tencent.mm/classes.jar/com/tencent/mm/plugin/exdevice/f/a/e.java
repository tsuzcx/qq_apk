package com.tencent.mm.plugin.exdevice.f.a;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import com.tencent.mm.R.l;
import com.tencent.mm.ak.b;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class e
{
  public static void a(Context paramContext, ImageView paramImageView, String paramString, int paramInt)
  {
    if (paramImageView != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (!ai.isMainThread()) {
        break;
      }
      b(paramImageView, paramString, paramInt);
      return;
    }
    ai.d(new e.1(paramContext, paramImageView, paramString, paramInt));
  }
  
  public static boolean a(MMActivity paramMMActivity, int paramInt1, int paramInt2, Intent paramIntent, String paramString)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramInt1 == 1001) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
      bool1 = bool2;
      if (paramIntent != null)
      {
        bool1 = bool2;
        if (paramIntent.size() > 0)
        {
          paramIntent = (String)paramIntent.get(0);
          paramString = new Intent();
          paramString.putExtra("CropImageMode", 1);
          paramString.putExtra("CropImage_OutputPath", com.tencent.mm.compatible.util.e.dzL + "temp.cover");
          paramString.putExtra("CropImage_ImgPath", paramIntent);
          com.tencent.mm.br.d.c(paramMMActivity, ".ui.tools.CropImageNewUI", paramString, 1002);
          bool1 = true;
        }
      }
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramInt1 != 1002);
      bool1 = bool2;
    } while (paramInt2 != -1);
    paramMMActivity = d.Bx(com.tencent.mm.compatible.util.e.dzL + "temp.cover");
    paramIntent = ad.aLV();
    paramIntent.appName = paramString;
    long l = System.currentTimeMillis();
    paramIntent.jxH = com.tencent.mm.ak.c.a("uploadexdeivce", l, q.GQ().field_username, String.valueOf(l));
    paramString = paramIntent.jxH;
    com.tencent.mm.j.f localf = new com.tencent.mm.j.f();
    localf.dlP = paramIntent;
    localf.field_mediaId = paramString;
    localf.field_fullpath = paramMMActivity;
    localf.field_thumbpath = "";
    localf.field_fileType = com.tencent.mm.j.a.dlv;
    localf.field_talker = "";
    localf.field_priority = com.tencent.mm.j.a.dlj;
    localf.field_needStorage = true;
    localf.field_isStreamMedia = false;
    localf.field_appType = 200;
    localf.field_bzScene = 2;
    if (!com.tencent.mm.ak.f.Nd().c(localf)) {
      y.e("MicroMsg.ExdevicePictureUploader", "hy: cdntra addSendTask failed. clientid:%s", new Object[] { paramString });
    }
    return true;
  }
  
  static void b(ImageView paramImageView, String paramString, int paramInt)
  {
    if ((!bk.bl(paramString)) && (!"#".equals(paramString)))
    {
      y.d("MicroMsg.ExdeviceRankUtil", "hy: set url to %s", new Object[] { paramString });
      ad.aLO().a(paramString, paramImageView, ad.Bv(paramString));
      return;
    }
    y.d("MicroMsg.ExdeviceRankUtil", "hy: url is null or nill. set to default picture resource");
    paramImageView.setImageResource(paramInt);
  }
  
  public static void d(MMActivity paramMMActivity)
  {
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    localLinkedList1.add(paramMMActivity.getString(R.l.exdevice_change_cover));
    localLinkedList2.add(Integer.valueOf(0));
    h.a(paramMMActivity, "", localLinkedList1, localLinkedList2, null, true, new e.2(paramMMActivity));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.a.e
 * JD-Core Version:    0.7.0.1
 */